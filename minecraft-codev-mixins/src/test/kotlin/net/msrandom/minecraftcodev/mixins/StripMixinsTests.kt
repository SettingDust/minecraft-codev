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
            if (fault.startsWith("write")) assertSame(action.writeFailure, failure)
            else assertInstanceOf(NoSuchFileException::class.java, failure)
            if (fault == "write-close") assertTrue(action.closeFailure in failure.suppressed)
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
