package net.msrandom.minecraftcodev.mixins

import com.google.gson.Gson
import com.google.gson.JsonParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import java.util.Objects
import java.util.jar.JarFile

/** Neutral removals and failure safety of the public per-JAR Transform. */
class StripMixinsTests {
    @TempDir lateinit var root: Path
    private lateinit var jar: Path
    private lateinit var cleanup: Path
    private lateinit var output: Path

    @BeforeEach fun fixture() {
        jar = root.resolve("input.jar")
        cleanup = root.resolve("cleanup.json")
        output = root.resolve("output.jar")
        copyResource("strip-normal.jar", jar)
        copyResource("cleanup.json", cleanup)
    }

    private fun copyResource(name: String, destination: Path) {
        val resource = "strip-mixins/$name"
        Objects.requireNonNull(javaClass.getResourceAsStream(resource), resource).use { input ->
            Files.copy(input, destination, REPLACE_EXISTING)
        }
    }

    private fun rejected() {
        val original = Files.readAllBytes(jar)
        val info = Files.readAllBytes(cleanup)
        Files.writeString(output, "old output")
        val failure = assertThrows(Exception::class.java) { StripFixture(root, jar, cleanup, output).strip() }
        assertFalse(Files.exists(output))
        assertArrayEquals(original, Files.readAllBytes(jar))
        assertArrayEquals(info, Files.readAllBytes(cleanup))
        println("STRIP_REJECT $failure")
        Files.list(root).use { files -> assertTrue(files.noneMatch { it.fileName.toString().startsWith(".codev-") }) }
    }

    @Test fun handwrittenRemovalsRemoveEveryRawMatchWithoutProducerOrMetadataDiscovery() {
        val config = "{\"vendor\":{\"mixins\":[\"Good\"],\"keep\":true},\"package\":\"raw.pkg\",\"mixins\":[\"Good\",\"Keep\",\"Good\",\"raw.pkg.Good\",\"mapped.Good\",\"GoodExtra\"],\"client\":[\"Good\",\"Client\",\"Good\"],\"server\":[\"Good\",\"Server\"],\"tail\":null}"
        copyResource("raw-cleanup.json", cleanup)
        copyResource("strip-raw.jar", jar)
        val otherJar = root.resolve("other.jar")
        Files.copy(jar, otherJar)
        for (source in listOf(jar, otherJar)) {
            val before = Files.readAllBytes(source)
            StripFixture(root, source, cleanup, output).strip()
            JarFile(output.toFile()).use { result ->
                val actual = JsonParser().parse(result.getInputStream(result.getJarEntry("nested/fixture.json")).use { String(it.readAllBytes(), Charsets.UTF_8) }).asJsonObject
                val expected = JsonParser().parse(config).asJsonObject
                expected.add("mixins", Gson().toJsonTree(listOf("Keep", "raw.pkg.Good", "mapped.Good", "GoodExtra")))
                expected.add("client", Gson().toJsonTree(listOf("Client")))
                expected.add("server", Gson().toJsonTree(listOf("Server")))
                assertEquals(expected, actual)
                assertEquals(expected.entrySet().map { it.key }, actual.entrySet().map { it.key })
                assertArrayEquals(config.toByteArray(), result.getInputStream(result.getJarEntry("fixture.json")).use { it.readAllBytes() })
                assertArrayEquals(byteArrayOf(7), result.getInputStream(result.getJarEntry("keep")).use { it.readAllBytes() })
            }
            assertArrayEquals(before, Files.readAllBytes(source))
        }
        assertEquals("{\"nested/fixture.json\":[\"Good\",\"Good\"]}", Files.readString(cleanup))
    }

    @Test fun orderedRecordsAccumulateWithFileDeduplicationAndClosedPrivateStages() {
        copyResource("strip-raw.jar", jar)
        val first = Files.createDirectories(root.resolve("first")).resolve("records.json")
        val second = Files.createDirectories(root.resolve("second")).resolve("records.json")
        val empty = root.resolve("empty.json")
        Files.writeString(first, """{"nested/fixture.json":["Good"],"absent.json":["Missing"]}""")
        Files.writeString(second, """{"nested/fixture.json":["Good","Keep"]}""")
        Files.writeString(empty, "{}")
        val originals = listOf(jar, first, second, empty).associateWith(Files::readAllBytes)
        val action = StripFixture(root, jar, first, output)
        action.cleanup.setFrom(first.toFile(), empty.toFile(), second.toFile(), first.toFile())
        action.onOpen = Runnable {
            assertFalse(Files.exists(output), "no intermediate publication")
            if (action.step > 1) {
                val previous = action.stages[action.step - 2]
                val closed = previous.resolveSibling("closed-${action.step}.jar")
                Files.move(previous, closed)
                Files.move(closed, previous)
                JarFile(previous.toFile()).use { archive ->
                    val config = JsonParser().parse(archive.getInputStream(archive.getJarEntry("nested/fixture.json")).reader().use { it.readText() }).asJsonObject
                    assertFalse(config.getAsJsonArray("mixins").any { it.asString == "Good" })
                    assertTrue(config.getAsJsonArray("mixins").any { it.asString == "Keep" })
                }
            }
        }
        action.strip()
        assertEquals(3, action.step)
        assertEquals(1, action.registrations)
        JarFile(output.toFile()).use { archive ->
            val config = JsonParser().parse(archive.getInputStream(archive.getJarEntry("nested/fixture.json")).reader().use { it.readText() }).asJsonObject
            assertEquals(listOf("raw.pkg.Good", "mapped.Good", "GoodExtra"), config.getAsJsonArray("mixins").map { it.asString })
            assertTrue(config.getAsJsonObject("vendor").get("keep").asBoolean)
            assertNotNull(archive.getJarEntry("fixture.json"))
            assertArrayEquals(byteArrayOf(7), archive.getInputStream(archive.getJarEntry("keep")).use { it.readAllBytes() })
        }
        originals.forEach { (path, bytes) -> assertArrayEquals(bytes, Files.readAllBytes(path)) }
        action.stages.forEach { assertFalse(Files.exists(it)) }
        // Distinct paths with identical content are still separate records.
        Files.copy(first, second, REPLACE_EXISTING)
        val equal = StripFixture(root, jar, first, output)
        equal.cleanup.from(second.toFile())
        equal.strip()
        assertEquals(2, equal.step)
    }

    @Test fun zeroMissingAndEmptyRecordsHaveDistinctFailureAndCopySemantics() {
        val action = StripFixture(root, jar, cleanup, output)
        Files.writeString(output, "old")
        action.cleanup.setFrom(emptyList<java.io.File>())
        assertThrows(IllegalArgumentException::class.java, action::strip)
        assertEquals("old", Files.readString(output))
        action.cleanup.setFrom(cleanup.toFile(), root.resolve("missing.json").toFile())
        assertThrows(NoSuchFileException::class.java, action::strip)
        assertEquals("old", Files.readString(output))
        Files.writeString(cleanup, "{}")
        action.cleanup.setFrom(cleanup.toFile())
        action.strip()
        assertFalse(Files.isSameFile(jar, output))
        JarFile(jar.toFile()).use { source -> JarFile(output.toFile()).use { result ->
            for (entry in source.entries()) assertArrayEquals(source.getInputStream(entry).use { it.readAllBytes() }, result.getInputStream(result.getJarEntry(entry.name)).use { it.readAllBytes() })
        } }
    }

    @Test fun laterRecordsReceiveAllInputProtectionsBeforeInvalidation() {
        val later = root.resolve("later.json")
        Files.copy(cleanup, later)
        val originals = listOf(jar, cleanup, later).associateWith(Files::readAllBytes)
        val alias = root.resolveSibling("${root.fileName}-later-alias")
        val link = ProcessBuilder("cmd.exe", "/d", "/c", "mklink", "/J", alias.toString(), root.toRealPath().toString()).redirectErrorStream(true).start()
        val log = link.inputStream.use { String(it.readAllBytes()) }
        assertEquals(0, link.waitFor(), log)
        try {
            for (protected in originals.keys) {
                val hardlink = Files.createLink(root.resolve("${protected.fileName}.later-link"), protected)
                for (destination in listOf(protected, hardlink, alias.resolve(protected.fileName))) {
                    val action = StripFixture(root, jar, cleanup, destination)
                    action.cleanup.from(later.toFile())
                    assertThrows(IllegalArgumentException::class.java, action::strip)
                    assertEquals(0, action.step)
                    originals.forEach { (path, bytes) -> assertArrayEquals(bytes, Files.readAllBytes(path)) }
                }
            }
            val directory = Files.createDirectory(root.resolve("later-directory"))
            val child = alias.resolve(directory.fileName).resolve("missing/output.jar")
            val action = StripFixture(root, jar, cleanup, child)
            action.cleanup.from(directory.toFile())
            assertThrows(IllegalArgumentException::class.java, action::strip)
            assertFalse(Files.exists(child.parent))
            Files.writeString(output, "old")
            action.destination.set(output.toFile())
            action.cleanup.setFrom(cleanup.toFile(), root.resolve("missing.json").toFile())
            assertThrows(NoSuchFileException::class.java, action::strip)
            assertEquals("old", Files.readString(output))
        } finally {
            val unlink = ProcessBuilder("cmd.exe", "/d", "/c", "rmdir", alias.toString()).redirectErrorStream(true).start()
            val message = unlink.inputStream.use { String(it.readAllBytes()) }
            assertEquals(0, unlink.waitFor(), message)
        }
    }

    @Test fun laterRecordSymlinksAndSymbolicOutputsStayProtected() {
        val later = root.resolve("later.json")
        Files.copy(cleanup, later)
        val recordLink = Files.createSymbolicLink(root.resolve("record-link.json"), later)
        val originals = listOf(jar, cleanup, later).associateWith(Files::readAllBytes)
        val action = StripFixture(root, jar, cleanup, later)
        action.cleanup.from(recordLink.toFile())
        assertThrows(IllegalArgumentException::class.java, action::strip)
        val unrelated = root.resolve("unrelated.jar")
        Files.writeString(unrelated, "unrelated completed output")
        val symbolic = Files.createSymbolicLink(root.resolve("symbolic-output.jar"), unrelated)
        action.destination.set(symbolic.toFile())
        assertThrows(IllegalArgumentException::class.java, action::strip)
        assertTrue(Files.isSymbolicLink(symbolic))
        assertEquals("unrelated completed output", Files.readString(unrelated))
        val dangling = Files.createSymbolicLink(root.resolve("dangling-output.jar"), root.resolve("absent.jar"))
        action.destination.set(dangling.toFile())
        assertThrows(NoSuchFileException::class.java, action::strip)
        assertTrue(Files.isSymbolicLink(dangling))
        originals.forEach { (path, bytes) -> assertArrayEquals(bytes, Files.readAllBytes(path)) }
        action.destination.set(output.toFile())
        action.strip()
        assertEquals(2, action.step)
        assertTrue(Files.isRegularFile(output))
    }

    @Test fun wholeLoopOccupancyRejectsContendersAtEveryStep() {
        val action = StripFixture(root, jar, cleanup, output)
        val later = root.resolve("later.json")
        Files.writeString(later, "{}")
        action.cleanup.from(later.toFile())
        action.onOpen = Runnable {
            val error = assertThrows(IllegalArgumentException::class.java) { StripFixture(root, jar, cleanup, output).strip() }
            assertTrue(error.message!!.contains("in use"))
            assertFalse(Files.exists(output))
        }
        action.strip()
        assertEquals(2, action.step)
        assertTrue(Files.isRegularFile(output))
        StripFixture(root, jar, cleanup, output).strip()
    }

    @Test fun firstAndLaterParseWriteCloseAndMoveFailuresRecoverWithoutPartialOutputs() {
        val later = root.resolve("later.json")
        Files.writeString(later, "{}")
        val originals = listOf(jar, cleanup, later).associateWith(Files::readAllBytes)
        for (step in listOf(1, 2)) for (fault in listOf("parse", "write-close", "close", "move")) {
            val action = StripFixture(root, jar, cleanup, output)
            if (step == 2 || fault != "move") action.cleanup.from(later.toFile())
            action.faultStep = step
            if (fault == "parse") Files.writeString(if (step == 1) cleanup else later, "{") else action.fault = fault
            Files.writeString(output, "old success")
            val failure = assertThrows(Exception::class.java, action::strip)
            assertFalse(Files.exists(output), "$step $fault")
            assertEquals(step, action.step)
            assertEquals(1, action.registrations)
            if (fault != "parse") assertTrue(action.faultReached)
            if (fault == "write-close" || fault == "close") {
                assertTrue(action.outputClosed)
                assertSame(if (fault == "close") action.closeFailure else action.writeFailure, failure.cause)
                if (fault == "write-close") assertTrue(action.closeFailure in failure.cause!!.suppressed)
            }
            if (fault != "move") {
                assertTrue(failure.message!!.contains(jar.toString()))
                assertTrue(failure.message!!.contains((if (step == 1) cleanup else later).toString()))
                assertTrue(failure.message!!.contains(if (step == 1) jar.toString() else action.stages[0].toString()))
            }
            action.stages.forEach { assertFalse(Files.exists(it)) }
            assertArrayEquals(originals.getValue(jar), Files.readAllBytes(jar))
            if (fault != "parse") originals.forEach { (path, bytes) -> assertArrayEquals(bytes, Files.readAllBytes(path)) }
            originals.forEach { (path, bytes) -> Files.write(path, bytes) }
            val recovery = StripFixture(root, jar, cleanup, output)
            recovery.cleanup.from(later.toFile())
            recovery.strip()
            assertTrue(Files.isRegularFile(output))
        }
    }

    @Test fun firstAndLaterRecordReadFailuresRetainOriginalCauseAndRecover() {
        val later = root.resolve("later.json")
        Files.writeString(later, "{}")
        val originals = listOf(jar, cleanup, later).associateWith(Files::readAllBytes)
        for (record in listOf(cleanup, later)) {
            val action = StripFixture(root, jar, cleanup, output)
            action.cleanup.from(later.toFile())
            Files.writeString(output, "old success")
            val denied = SecurityException("fixture record read denied: $record")
            val failure = MixinIo.observe(MixinIo.Operation.READ_RECORD, record) { throw denied }.use {
                assertThrows(Exception::class.java, action::strip)
            }
            assertSame(denied, failure.cause)
            assertTrue(failure.message!!.contains(record.toString()))
            assertEquals(if (record == cleanup) 1 else 2, action.step)
            assertFalse(Files.exists(output))
            action.stages.forEach { assertFalse(Files.exists(it)) }
            originals.forEach { (path, bytes) -> assertArrayEquals(bytes, Files.readAllBytes(path)) }
            StripFixture(root, jar, cleanup, output).strip()
            assertTrue(Files.isRegularFile(output))
        }
    }

    @Test fun cleanupFailureAfterPublicationInvalidatesFinalOutputAndIsSuppressedOnPriorFailure() {
        val later = root.resolve("later.json")
        Files.writeString(later, "{}")
        val original = Files.readAllBytes(jar)
        for (priorFailure in listOf(false, true)) {
            val action = StripFixture(root, jar, cleanup, output)
            action.cleanup.from(later.toFile())
            action.faultStep = 2
            if (priorFailure) action.fault = "write-close"
            val denied = SecurityException("fixture staged deletion denied")
            var sawPublished = false
            var registration: java.io.Closeable? = null
            action.onOpen = Runnable {
                if (action.step == 1) registration = MixinIo.observe(MixinIo.Operation.DELETE_STAGE, action.stages.first()) {
                    sawPublished = Files.exists(output)
                    throw denied
                }
            }
            val failure = try { assertThrows(Exception::class.java, action::strip) } finally { registration?.close() }
            if (priorFailure) {
                assertSame(action.writeFailure, failure.cause)
                assertTrue(action.closeFailure in failure.cause!!.suppressed)
                assertTrue(denied in failure.suppressed)
                assertFalse(sawPublished)
            } else {
                assertSame(denied, failure)
                assertTrue(sawPublished, "the final move succeeded before cleanup failed")
            }
            assertFalse(Files.exists(output))
            assertTrue(Files.exists(action.stages.first()))
            assertFalse(Files.exists(action.stages.last()))
            assertArrayEquals(original, Files.readAllBytes(jar))
            Files.delete(action.stages.first())
            StripFixture(root, jar, cleanup, output).strip()
            assertTrue(Files.isRegularFile(output))
        }
    }

    @Test fun invalidRemovalsShapeCannotPublish() {
        Files.writeString(cleanup, "{\"fixture.json\":true}")
        rejected()
    }

    @Test fun invalidApplicableMixinArrayCannotPublish() {
        copyResource("strip-invalid-5.jar", jar)
        rejected()
    }

    @Test fun outputWriteAndPublicationFailuresInvalidateCurrentOutput() {
        val other = root.resolve("another-operation.jar")
        Files.writeString(other, "other completed output")
        for (fault in listOf("write-close", "move")) {
            StripFixture(root, jar, cleanup, output).strip()
            val input = Files.readAllBytes(jar)
            val supplied = Files.readAllBytes(cleanup)
            val action = StripFixture(root, jar, cleanup, output)
            action.fault = fault
            val failure = try {
                assertThrows(Exception::class.java, action::strip)
            } finally {
                Thread.interrupted()
            }
            assertTrue(action.faultReached, "$fault must reach the actual Strip stream")
            assertTrue(action.outputClosed, fault)
            if (fault.startsWith("write")) {
                assertSame(action.writeFailure, failure.cause)
                assertTrue(action.closeFailure in failure.cause!!.suppressed)
                assertTrue(failure.message!!.contains(jar.toString()))
                assertTrue(failure.message!!.contains(cleanup.toString()))
            } else assertInstanceOf(NoSuchFileException::class.java, failure.cause)
            assertFalse(Files.exists(output))
            assertArrayEquals(input, Files.readAllBytes(jar))
            assertArrayEquals(supplied, Files.readAllBytes(cleanup))
            assertEquals("other completed output", Files.readString(other))
            Files.list(root).use { files -> assertTrue(files.noneMatch { it.fileName.toString().startsWith(".codev-strip-") }) }
            println("STRIP_FAULT $fault $failure")
            StripFixture(root, jar, cleanup, output).strip()
            JarFile(output.toFile()).use { result -> assertNotNull(result.getJarEntry("fixture.json")) }
        }
    }

    @Test fun originalAndCleanupAliasesHardlinksAndDirectoryContainmentAreProtected() {
        val input = Files.readAllBytes(jar)
        val information = Files.readAllBytes(cleanup)
        for (protectedInput in listOf(jar, cleanup)) {
            for (alias in listOf(protectedInput, Files.createLink(root.resolve("${protectedInput.fileName}.link"), protectedInput))) {
                assertThrows(IllegalArgumentException::class.java) { StripFixture(root, jar, cleanup, alias).strip() }
                assertArrayEquals(input, Files.readAllBytes(jar))
                assertArrayEquals(information, Files.readAllBytes(cleanup))
            }
        }
        val directory = Files.createDirectory(root.resolve("cleanup-directory"))
        val child = directory.resolve("not-created/output.jar")
        assertThrows(IllegalArgumentException::class.java) { StripFixture(root, jar, directory, child).strip() }
        assertFalse(Files.exists(child.parent))
        StripFixture(root, jar, cleanup, output).strip()
        assertArrayEquals(input, Files.readAllBytes(jar))
        assertArrayEquals(information, Files.readAllBytes(cleanup))
    }

    @Test fun realParentAliasesAndConflictingWritersDoNotMutateInputsOrWinner() {
        val alias = root.resolveSibling("${root.fileName}-alias")
        val link = ProcessBuilder("cmd.exe", "/d", "/c", "mklink", "/J", alias.toString(), root.toRealPath().toString()).redirectErrorStream(true).start()
        val log = link.inputStream.use { String(it.readAllBytes()) }
        assertEquals(0, link.waitFor(), log)
        try {
            assertTrue(Files.isSameFile(alias, root))
            val original = Files.readAllBytes(jar)
            val information = Files.readAllBytes(cleanup)
            for (protectedInput in listOf(jar, cleanup)) {
                assertThrows(IllegalArgumentException::class.java) { StripFixture(root, jar, cleanup, alias.resolve(protectedInput.fileName)).strip() }
            }
            val winner = StripFixture(root, jar, cleanup, output)
            winner.onOpen = Runnable {
                val conflict = assertThrows(IllegalArgumentException::class.java) { StripFixture(root, jar, cleanup, alias.resolve(output.fileName)).strip() }
                assertTrue(conflict.message!!.contains("in use"))
            }
            winner.strip()
            JarFile(output.toFile()).use { result -> assertNotNull(result.getJarEntry("fixture.json")) }
            assertArrayEquals(original, Files.readAllBytes(jar))
            assertArrayEquals(information, Files.readAllBytes(cleanup))
        } finally {
            val unlink = ProcessBuilder("cmd.exe", "/d", "/c", "rmdir", alias.toString()).redirectErrorStream(true).start()
            val message = unlink.inputStream.use { String(it.readAllBytes()) }
            assertEquals(0, unlink.waitFor(), message)
        }
    }
}
