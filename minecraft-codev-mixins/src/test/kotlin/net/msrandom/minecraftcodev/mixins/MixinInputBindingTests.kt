package net.msrandom.minecraftcodev.mixins

import com.google.gson.JsonParser
import net.msrandom.minecraftcodev.mixins.task.Mixin
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException
import java.nio.file.Files
import java.nio.file.LinkOption.NOFOLLOW_LINKS
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import java.nio.file.StandardOpenOption.APPEND
import java.security.Permission
import java.util.concurrent.TimeUnit
import java.util.jar.JarFile

class MixinInputBindingTests {
    // Own cleanup: a failed junction removal must never trigger recursive JUnit temp cleanup.
    private lateinit var root: Path
    private lateinit var junction: Path
    private lateinit var fixture: MixinFixture
    private lateinit var runtime: List<String>
    private lateinit var sources: List<String>

    @BeforeEach fun fixture() {
        if (!::root.isInitialized) root = Files.createTempDirectory("mixin-input-binding-")
        fixture = MixinFixture(root).also { it.create() }
        // Input identity needs distinct paths, not distinct resource contents.
        runtime = listOf(
            PipelineInputs.copyJar("resolution-only", root.resolve("runtime-a.jar")).toString(),
            PipelineInputs.copyJar("resolution-only", root.resolve("runtime-b.jar")).toString()
        )
        sources = listOf(fixture.mod.toString())
    }

    @AfterEach fun cleanup() {
        if (!::root.isInitialized) return
        if (::junction.isInitialized && !Files.notExists(junction, NOFOLLOW_LINKS)) {
            throw IOException("Junction remains; refusing recursive fixture traversal or cleanup: $root")
        }
        Files.walk(root).use { files -> files.sorted(Comparator.reverseOrder()).forEach(Files::delete) }
    }

    private fun entries(jar: Path): MutableMap<String, ByteArray> {
        val entries = sortedMapOf<String, ByteArray>()
        JarFile(jar.toFile()).use { archive ->
            for (entry in archive.entries()) if (!entry.isDirectory) entries[entry.name] = fixture.read(jar, entry.name)
        }
        return entries
    }

    private fun replace(jar: Path, name: String, changes: Map<String, ByteArray>): Path {
        val entries = entries(jar)
        entries.putAll(changes)
        return fixture.jar(name, entries)
    }

    private fun taskProducer(): Mixin {
        sources = listOf(fixture.mod.toString(), PipelineInputs.copyJar("resolution-only", root.resolve("extra-source.jar")).toString())
        val mapping = OrdinaryInputs.copyMappingResource("mapping.tiny", root.resolve("task-mapping.tiny"))
        val project = ProjectBuilder.builder().withProjectDir(root.toFile()).build()
        val task = project.tasks.create("inputProducer", Mixin::class.java)
        task.inputFile.set(fixture.target.toFile())
        task.classpath.from(runtime)
        task.mixinFiles.from(sources)
        task.side.set("SERVER")
        task.mappingFile.set(mapping.toFile())
        task.sourceNamespace.set("src")
        task.targetNamespace.set("named")
        task.outputFile.set(root.resolve("result/target.jar").toFile())
        task.appliedMixins.set(root.resolve("result/target.jar.cleanup.json").toFile())
        return task
    }

    private fun taskConsumer(producer: Mixin) = StripFixture(root, fixture.mod, producer.appliedMixins.get().asFile.toPath(), root.resolve("clean/mod.jar"))

    private fun snapshot(paths: Collection<Path>): MutableMap<Path, ByteArray> = paths.associateWithTo(linkedMapOf(), Files::readAllBytes)

    private fun unchanged(snapshot: Map<Path, ByteArray>) {
        for ((path, bytes) in snapshot) assertArrayEquals(bytes, Files.readAllBytes(path), path.toString())
    }

    private fun windows(vararg arguments: String) {
        val command = listOf("cmd.exe", "/d", "/c") + arguments
        val process = ProcessBuilder(command).redirectErrorStream(true).start()
        try {
            process.inputStream.use { stream ->
                val log = String(stream.readAllBytes())
                val exit = process.waitFor()
                println("WINDOWS $command exit=$exit\n$log")
                assertEquals(0, exit, "$command\n$log")
            }
        } finally {
            if (process.isAlive) {
                process.destroyForcibly()
                assertTrue(process.waitFor(15, TimeUnit.SECONDS))
            }
        }
    }

    private fun removeJunction() {
        if (!Files.notExists(junction, NOFOLLOW_LINKS)) windows("rmdir", junction.toString())
        assertTrue(Files.notExists(junction, NOFOLLOW_LINKS), "junction must be gone before fixture traversal")
    }

    @Test fun taskInputsRejectRealWindowsParentAliasesAndHardlinksBeforeMutation() {
        val producer = taskProducer()
        producer.mixin()
        val consumer = taskConsumer(producer)
        consumer.strip()
        val pair = listOf(producer.outputFile.get().asFile.toPath(), producer.appliedMixins.get().asFile.toPath())
        val cleaned = consumer.destination.get().asFile.toPath()
        val producerInputs = linkedMapOf<String, Path>()
        for (file in producer.classpath.files) producerInputs["runtime:${file.name}"] = file.toPath()
        for (file in producer.mixinFiles.files) producerInputs["sources:${file.name}"] = file.toPath()
        producerInputs["inputFile"] = fixture.target
        producerInputs["mapping"] = producer.mappingFile.get().asFile.toPath()
        val implementation = producer.implementationClasspath.files.first { it.isFile }.toPath()
        val consumerInputs = linkedMapOf("source" to fixture.mod, "cleanup" to pair[1])
        val protectedFiles = producerInputs.values + consumerInputs.values + listOf(cleaned, implementation)
        val before = snapshot(protectedFiles)
        for (slot in listOf(0, 1)) {
            try {
                if (slot == 0) producer.outputFile.set(implementation.toFile()) else producer.appliedMixins.set(implementation.toFile())
                val error = assertThrows(IllegalArgumentException::class.java, producer::mixin)
                assertTrue(error.message!!.startsWith("Output overlaps an input:"), error.toString())
                unchanged(before)
                println("INPUT_GUARD producer implementation slot=$slot $error")
            } finally {
                producer.outputFile.set(pair[0].toFile())
                producer.appliedMixins.set(pair[1].toFile())
            }
        }
        junction = root.resolve("input-parent-alias")
        var index = 0
        try {
            windows("mklink", "/J", junction.toString(), root.toRealPath().toString())
            assertTrue(Files.isSameFile(root, junction))
            for (kind in listOf("junction", "hardlink")) {
                for ((name, input) in producerInputs) for (slot in listOf(0, 1)) {
                    val alias = if (kind == "junction") junction.resolve(root.relativize(input))
                    else Files.createLink(root.resolve("producer-hardlink-${index++}"), input)
                    try {
                        assertTrue(Files.isSameFile(alias, input))
                        if (slot == 0) producer.outputFile.set(alias.toFile()) else producer.appliedMixins.set(alias.toFile())
                        val error = assertThrows(IllegalArgumentException::class.java, producer::mixin)
                        assertTrue(error.message!!.startsWith("Output overlaps an input:"), error.toString())
                        unchanged(before)
                        assertTrue(Files.isSameFile(alias, input))
                        println("INPUT_GUARD producer $kind $name slot=$slot $error")
                    } finally {
                        producer.outputFile.set(pair[0].toFile())
                        producer.appliedMixins.set(pair[1].toFile())
                        if (kind == "hardlink") Files.delete(alias)
                    }
                }
                for ((name, input) in consumerInputs) {
                    val alias = if (kind == "junction") junction.resolve(root.relativize(input))
                    else Files.createLink(root.resolve("consumer-hardlink-${index++}"), input)
                    try {
                        assertTrue(Files.isSameFile(alias, input))
                        consumer.destination.set(alias.toFile())
                        val error = assertThrows(IllegalArgumentException::class.java, consumer::strip)
                        assertTrue(error.message!!.startsWith("Output overlaps an input:"), error.toString())
                        unchanged(before)
                        assertTrue(Files.isSameFile(alias, input))
                        println("INPUT_GUARD consumer $kind $name $error")
                    } finally {
                        consumer.destination.set(cleaned.toFile())
                        if (kind == "hardlink") Files.delete(alias)
                    }
                }
            }
        } finally {
            removeJunction()
        }
        unchanged(before)
    }

    @Test fun destinationAccessAndDanglingAncestorFailuresPreserveBothProducersOldResults() {
        val producer = taskProducer()
        producer.mixin()
        val consumer = taskConsumer(producer)
        consumer.strip()
        val pair = listOf(producer.outputFile.get().asFile.toPath(), producer.appliedMixins.get().asFile.toPath())
        val cleaned = consumer.destination.get().asFile.toPath()
        val observed = listOf(fixture.target, fixture.mod, pair[0], pair[1], cleaned, root.resolve("task-mapping.tiny")) +
            runtime.map(Paths::get) + sources.map(Paths::get)
        val before = snapshot(observed)
        val previous = System.getSecurityManager()
        for (denied in listOf(pair[0], pair[1], cleaned)) {
            var reached = false
            val access = SecurityException("fixture destination access denied: $denied")
            try {
                System.setSecurityManager(object : SecurityManager() {
                    override fun checkPermission(permission: Permission) {}
                    override fun checkRead(path: String) {
                        if (path == denied.toString() && Thread.currentThread().stackTrace.any { frame ->
                            frame.className == "net.msrandom.minecraftcodev.mixins.ProduceMixinsKt" && frame.methodName == "mixinDestination"
                        }) {
                            reached = true
                            throw access
                        }
                    }
                })
                assertSame(access, assertThrows(SecurityException::class.java) { if (denied == cleaned) consumer.strip() else producer.mixin() })
                assertTrue(reached, "must reach the shared resolver's actual NIO access")
            } finally {
                System.setSecurityManager(previous)
            }
            unchanged(before)
        }
        junction = root.resolve("dangling-output-parent")
        try {
            windows("mklink", "/J", junction.toString(), root.resolve("absent-parent").toString())
            assertTrue(Files.exists(junction, NOFOLLOW_LINKS))
            assertFalse(Files.exists(junction))
            for (slot in listOf(0, 1, 2)) {
                val forbidden = junction.resolve("missing/result.jar")
                try {
                    when (slot) {
                        0 -> producer.outputFile.set(forbidden.toFile())
                        1 -> producer.appliedMixins.set(forbidden.toFile())
                        else -> consumer.destination.set(forbidden.toFile())
                    }
                    assertThrows(NoSuchFileException::class.java) { if (slot == 2) consumer.strip() else producer.mixin() }
                    unchanged(before)
                    assertFalse(Files.exists(root.resolve("absent-parent")))
                } finally {
                    producer.outputFile.set(pair[0].toFile())
                    producer.appliedMixins.set(pair[1].toFile())
                    consumer.destination.set(cleaned.toFile())
                }
            }
        } finally {
            removeJunction()
        }
        producer.mixin()
        consumer.strip()
        assertTrue(Files.isRegularFile(pair[0]))
        before.keys.removeAll(listOf(pair[0], pair[1], cleaned))
        unchanged(before)
        assertArrayEquals(fixture.read(fixture.mod, "fixture.json"), fixture.read(cleaned, "fixture.json"))
        println("S06_RESOLUTION actualAccessDenied=3 danglingAncestor=3 oldPairAndStripAndInputsUnchanged=true retry=true")
    }

    @Test fun taskDirectoryInputsRejectDescendantsAndAllowAdjacentOutputs() {
        val producer = taskProducer()
        producer.mixin()
        val consumer = taskConsumer(producer)
        consumer.strip()
        val pair = listOf(producer.outputFile.get().asFile.toPath(), producer.appliedMixins.get().asFile.toPath())
        val cleaned = consumer.destination.get().asFile.toPath()
        val runtimeDirectory = Files.createDirectory(root.resolve("protected-runtime"))
        val sourceDirectory = Files.createDirectory(root.resolve("protected-sources"))
        Files.writeString(runtimeDirectory.resolve("runtime.txt"), "runtime keep")
        Files.writeString(sourceDirectory.resolve("source.txt"), "source keep")
        producer.classpath.from(runtimeDirectory)
        producer.mixinFiles.from(sourceDirectory)
        val protectedFiles = listOf(fixture.target, fixture.mod, pair[0], pair[1], cleaned, root.resolve("task-mapping.tiny"), runtimeDirectory.resolve("runtime.txt"), sourceDirectory.resolve("source.txt")) +
            runtime.map(Paths::get) + sources.map(Paths::get)
        val before = snapshot(protectedFiles)
        junction = root.resolve("directory-parent-alias")
        try {
            windows("mklink", "/J", junction.toString(), root.toRealPath().toString())
            for (directory in listOf(runtimeDirectory, sourceDirectory)) for (parent in listOf(directory, junction.resolve(root.relativize(directory)))) {
                val forbidden = parent.resolve("not-created/output.jar")
                for (slot in listOf(0, 1)) {
                    try {
                        if (slot == 0) producer.outputFile.set(forbidden.toFile()) else producer.appliedMixins.set(forbidden.toFile())
                        val error = assertThrows(IllegalArgumentException::class.java, producer::mixin)
                        assertTrue(error.message!!.startsWith("Output overlaps an input:"))
                        unchanged(before)
                        assertFalse(Files.exists(directory.resolve("not-created")))
                    } finally {
                        producer.outputFile.set(pair[0].toFile())
                        producer.appliedMixins.set(pair[1].toFile())
                    }
                }
                try {
                    consumer.source.set(directory.toFile())
                    consumer.destination.set(forbidden.toFile())
                    val error = assertThrows(IllegalArgumentException::class.java, consumer::strip)
                    assertTrue(error.message!!.startsWith("Output overlaps an input:"))
                    unchanged(before)
                    assertFalse(Files.exists(directory.resolve("not-created")))
                } finally {
                    consumer.source.set(fixture.mod.toFile())
                    consumer.destination.set(cleaned.toFile())
                }
            }
        } finally {
            removeJunction()
        }
        // Config discovery is archive-only; keep the runtime directory for the valid adjacent case.
        producer.mixinFiles.setFrom(sources)
        producer.outputFile.set(root.resolve("protected-runtime-neighbor/target.jar").toFile())
        producer.appliedMixins.set(root.resolve("protected-runtime-neighbor/target.jar.cleanup.json").toFile())
        consumer.cleanup.set(producer.appliedMixins)
        consumer.destination.set(root.resolve("protected-sources-neighbor/mod.jar").toFile())
        producer.mixin()
        consumer.strip()
        assertTrue(Files.isRegularFile(producer.outputFile.get().asFile.toPath()))
        assertArrayEquals(fixture.read(fixture.mod, "fixture.json"), fixture.read(consumer.destination.get().asFile.toPath(), "fixture.json"))
        unchanged(before)
    }

    @Test fun taskDistinctSameBasenameContentMissingParentsAndRerunsAreLegal() {
        val producer = taskProducer()
        val consumer = taskConsumer(producer)
        val target = producer.outputFile.get().asFile.toPath()
        val cleaned = consumer.destination.get().asFile.toPath()
        assertFalse(Files.exists(target.parent))
        assertFalse(Files.exists(cleaned.parent))
        val inputs = listOf(fixture.target, fixture.mod, root.resolve("task-mapping.tiny")) + runtime.map(Paths::get) + sources.map(Paths::get)
        val before = snapshot(inputs)
        producer.mixin()
        consumer.strip()
        assertEquals(fixture.target.fileName, target.fileName)
        assertEquals(fixture.mod.fileName, cleaned.fileName)
        // Existing equal-content files are not aliases; both task writers must still run normally.
        Files.copy(fixture.target, target, REPLACE_EXISTING)
        Files.copy(fixture.mod, cleaned, REPLACE_EXISTING)
        assertArrayEquals(Files.readAllBytes(fixture.target), Files.readAllBytes(target))
        assertFalse(Files.isSameFile(fixture.target, target))
        assertArrayEquals(Files.readAllBytes(fixture.mod), Files.readAllBytes(cleaned))
        assertFalse(Files.isSameFile(fixture.mod, cleaned))
        producer.mixin()
        consumer.strip()
        producer.mixin()
        consumer.strip()
        assertTrue(Files.isRegularFile(target))
        assertTrue(Files.isRegularFile(fixture.target))
        assertArrayEquals(fixture.read(fixture.mod, "fixture.json"), fixture.read(cleaned, "fixture.json"))
        assertArrayEquals(fixture.read(fixture.mod, "resource.txt"), fixture.read(cleaned, "resource.txt"))
        unchanged(before)
    }

    @Test fun manifestClassPathCannotExtendExplicitResolutionDomain() {
        val a = fixture.jar("A.jar", mapOf("META-INF/MANIFEST.MF" to "Manifest-Version: 1.0\nClass-Path: X.jar\n\n".toByteArray()))
        val b = OrdinaryInputs.copyJar("resolution-22", root.resolve("B.jar"))
        OrdinaryInputs.copyJar("resolution-11", root.resolve("X.jar"))
        IsolatingMixinClassLoader(emptyArray(), arrayOf(a.toUri().toURL(), b.toUri().toURL())).use { loader ->
            MixinResourceTests.resolutionWinner(loader, b, 22)
        }
    }

    @Test fun duplicateDeclarationsWithoutBodiesMergeAllSides() {
        val first = fixture.jar("declaration-a.jar", mapOf("fixture.list" to "fixture.json".toByteArray(), "fixture.client.list" to "fixture.json".toByteArray()))
        val second = fixture.jar("declaration-b.jar", mapOf("fixture.server.list" to "fixture.json".toByteArray()))
        sources = listOf(first.toString(), second.toString())
        val raw = snapshot(listOf(first, second, fixture.target))
        for (declaration in listOf(first, second)) assertFalse(entries(declaration).containsKey("fixture.json"))
        val environments = linkedMapOf<String, MutableSet<String>>()
        assertEquals(listOf("fixture.json"), discoverMixinConfigs(fixture.target.toString(), sources, environments))
        assertEquals(mapOf("fixture.json" to setOf("*", "client", "server")), environments)
        unchanged(raw)
    }

    private fun runner(task: String, vararg options: String): GradleRunner {
        val runner = GradleRunner.create().withProjectDir(root.toFile()).withPluginClasspath()
        val arguments = listOf(task, "--configuration-cache", "--stacktrace", "--console=plain", "--no-parallel", "--max-workers=1") + options
        return runner.withArguments(arguments)
    }

    private fun outcome(result: BuildResult, task: String, expected: TaskOutcome) {
        assertNotNull(result.task(task))
        assertEquals(expected, result.task(task)!!.outcome)
    }

    private fun pipelineProject() {
        PipelineInputs.copyJar("resolution-only", root.resolve("target-b.jar"))
        PipelineInputs.copyJar("source", root.resolve("source-b.jar"))
        PipelineInputs.copyJar("resolution-only", root.resolve("resolution-only.jar"))
        for (entry in listOf("settings.gradle", "build.gradle", "gradle.properties", "pipeline-caller.gradle")) {
            val caller = Path.of("integration-test/mixins/pipeline", "callers/pipeline", entry)
            Files.copy(caller, root.resolve(entry))
        }
        Files.writeString(root.resolve("gradle.properties"), "\norg.gradle.java.home=" + System.getProperty("fixture.gradleJava").replace('\\', '/') + "\n", APPEND)
    }

    private fun pipelineRun(label: String, failure: Boolean, vararg arguments: String): BuildResult {
        val args = mutableListOf("--offline", "--no-configuration-cache", "--build-cache", "--info")
        args.addAll(arguments)
        val gradle = runner(args.removeAt(0), *args.toTypedArray())
        val raw = snapshot(listOf("target.jar", "mod.jar", "target-b.jar", "source-b.jar", "resolution-only.jar").map(root::resolve).filter { Files.isRegularFile(it) })
        val result = try {
            if (failure) gradle.buildAndFail() else gradle.build()
        } finally {
            unchanged(raw)
            println("CALLER RAW INPUTS unchanged during $label: ${raw.keys}")
        }
        println("PIPELINE $label ${result.tasks}\n${result.output}")
        return result
    }

    private fun mixins(jar: Path, config: String, expected: String) {
        assertEquals(expected, JsonParser().parse(String(fixture.read(jar, config), Charsets.UTF_8)).asJsonObject.get("mixins").toString(), "$jar:$config")
    }

    private fun applied(id: String): Path = root.resolve("build/applied/$id.jar")
    private fun cleanup(id: String): Path = root.resolve("build/mixin/produce$id/removals.json")
    private fun consumed(id: String, jar: String): Path = root.resolve("build/consumed/$id/$jar-mixinStripped.jar")

    private fun sameEntries(expected: Path, actual: Path) {
        val before = entries(expected)
        val after = entries(actual)
        assertEquals(before.keys, after.keys, actual.toString())
        for (entry in before.keys) assertArrayEquals(before[entry], after[entry], "$actual:$entry")
    }

    private fun completeA() {
        sameEntries(fixture.mod, consumed("A", "mod"))
        sameEntries(applied("A"), consumed("A", "A"))
        assertEquals(setOf("A-mixinStripped.jar", "mod-mixinStripped.jar", "transform-paths.txt"), root.resolve("build/consumed/A").toFile().list()!!.toSet())
    }

    @Test fun testKitProducerDefaultsAreQueryableBeforeExecution() {
        for (customTarget in listOf(false, true)) {
            val caller = Path.of("integration-test/mixins/pipeline", "callers/defaults", if (customTarget) "custom" else "default")
            for (entry in listOf("settings.gradle", "build.gradle", "gradle.properties")) {
                Files.copy(caller.resolve(entry), root.resolve(entry), REPLACE_EXISTING)
            }
            Files.writeString(root.resolve("gradle.properties"), "\norg.gradle.java.home=" + System.getProperty("fixture.gradleJava").replace('\\', '/') + "\n", APPEND)
            val result = pipelineRun(if (customTarget) "custom-target-default-notifications" else "both-default-outputs", false, "appliedOnly", "--no-build-cache", "--rerun-tasks")
            outcome(result, ":produce", TaskOutcome.SUCCESS)
            outcome(result, ":appliedOnly", TaskOutcome.SUCCESS)
            val target = root.resolve(if (customTarget) "build/custom/applied.jar" else "build/mixin/produce/applied.jar")
            val notifications = root.resolve("build/mixin/produce/removals.json")
            assertTrue(result.output.contains("BEFORE-TARGET=" + target.toFile()))
            assertTrue(result.output.contains("BEFORE-NOTIFICATIONS=" + notifications.toFile()))
            assertTrue(Files.isRegularFile(target))
            assertTrue(Files.isRegularFile(root.resolve("build/smoke-consumed/applied.jar")))
            assertEquals("{}", Files.readString(notifications))
            assertTrue(Files.isRegularFile(fixture.target))
        }
    }

    @Test fun testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations() {
        pipelineProject()
        val raw = snapshot(listOf(fixture.target, fixture.mod, root.resolve("target-b.jar"), root.resolve("source-b.jar"), root.resolve("resolution-only.jar")))
        try {
            val appliedOnly = pipelineRun("applied-only", false, "appliedA")
            outcome(appliedOnly, ":produceA", TaskOutcome.SUCCESS)
            outcome(appliedOnly, ":appliedA", TaskOutcome.SUCCESS)
            assertFalse(Files.exists(root.resolve("build/consumed/A")))
            assertFalse(appliedOnly.output.contains("CONSUMED-A"))
            assertTrue(Files.isRegularFile(root.resolve("build/applied-only/A/A.jar")))
            mixins(root.resolve("build/applied-only/A/A.jar"), "target.json", "[\"Both\"]")
            for (entry in listOf("target.json", "asset.txt")) {
                assertArrayEquals(fixture.read(fixture.target, entry), fixture.read(applied("A"), entry), entry)
                assertArrayEquals(fixture.read(fixture.target, entry), fixture.read(root.resolve("build/applied-only/A/A.jar"), entry), entry)
            }
            val full = pipelineRun("complete-two-operations", false, "consumeA", "consumeB")
            outcome(full, ":produceA", TaskOutcome.UP_TO_DATE)
            outcome(full, ":produceB", TaskOutcome.SUCCESS)
            outcome(full, ":consumeA", TaskOutcome.SUCCESS)
            outcome(full, ":consumeB", TaskOutcome.SUCCESS)
            completeA()
            assertTrue(Files.isRegularFile(consumed("B", "B")))
            sameEntries(root.resolve("source-b.jar"), consumed("B", "source-b"))
            assertEquals(entries(applied("B")).keys, entries(consumed("B", "B")).keys)
            for ((name, bytes) in entries(applied("B"))) assertArrayEquals(bytes, fixture.read(consumed("B", "B"), name), name)
            assertEquals("{}", Files.readString(cleanup("A")))
            assertEquals("{}", Files.readString(cleanup("B")))
        } finally {
            unchanged(raw)
            println("CALLER RAW INPUTS unchanged: target/source A+B, resolution-only")
        }
    }

    @Test fun testKitProducerCacheRestoreThenReusedTransforms() {
        pipelineProject()
        val warm = pipelineRun("warm-producer-only", false, "produceA")
        outcome(warm, ":produceA", TaskOutcome.SUCCESS)
        assertFalse(Files.exists(root.resolve("build/consumed/A")))
        val target = Files.readAllBytes(applied("A"))
        val handoff = Files.readAllBytes(cleanup("A"))
        val current = pipelineRun("producer-up-to-date-before-clear", false, "produceA")
        outcome(current, ":produceA", TaskOutcome.UP_TO_DATE)
        assertArrayEquals(target, Files.readAllBytes(applied("A")))
        assertArrayEquals(handoff, Files.readAllBytes(cleanup("A")))
        Files.delete(applied("A"))
        Files.delete(cleanup("A"))
        val restored = pipelineRun("producer-from-cache", false, "consumeA")
        outcome(restored, ":produceA", TaskOutcome.FROM_CACHE)
        outcome(restored, ":consumeA", TaskOutcome.SUCCESS)
        assertArrayEquals(target, Files.readAllBytes(applied("A")))
        assertArrayEquals(handoff, Files.readAllBytes(cleanup("A")))
        completeA()
        val reused = pipelineRun("normal-reuse", false, "consumeA")
        outcome(reused, ":produceA", TaskOutcome.UP_TO_DATE)
        outcome(reused, ":consumeA", TaskOutcome.UP_TO_DATE)
        completeA()
        for (copy in listOf(consumed("A", "A"), consumed("A", "mod"), root.resolve("build/consumed/A/transform-paths.txt"))) Files.delete(copy)
        val transforms = pipelineRun("reuse-transforms", false, "consumeA")
        outcome(transforms, ":produceA", TaskOutcome.UP_TO_DATE)
        outcome(transforms, ":consumeA", TaskOutcome.SUCCESS)
        completeA()
        val paths = Files.readString(root.resolve("build/consumed/A/transform-paths.txt"))
        for (path in paths.split(Regex("\\R")).dropLastWhile { it.isEmpty() }) {
            val restoredJar = Paths.get(path)
            assertTrue(restoredJar.toRealPath().startsWith(Path.of(System.getProperty("org.gradle.testkit.dir")).toRealPath()), path)
            assertArrayEquals(Files.readAllBytes(restoredJar), Files.readAllBytes(root.resolve("build/consumed/A").resolve(restoredJar.fileName)))
        }
    }

    @Test fun testKitTransformTracksParametersAndInputArtifactIndependently() {
        pipelineProject()
        Files.copy(fixture.mod, root.resolve("probe.jar"))
        Files.writeString(root.resolve("probe-cleanup.json"), "{\"fixture.json\":[\"Good\"]}")
        pipelineRun("probe-first", false, "consumeProbe")
        val result = root.resolve("build/probe/probe-mixinStripped.jar")
        mixins(result, "fixture.json", "[\"Unused\"]")
        val input = snapshot(listOf(root.resolve("probe.jar")))
        Files.writeString(root.resolve("probe-cleanup.json"), "{\"fixture.json\":[\"Unused\"]}")
        pipelineRun("probe-parameter-only", false, "consumeProbe")
        unchanged(input)
        mixins(result, "fixture.json", "[\"Good\"]")
        val parameter = Files.readAllBytes(root.resolve("probe-cleanup.json"))
        replace(root.resolve("probe.jar"), "probe.jar", mapOf("resource.txt" to "current-input".toByteArray()))
        pipelineRun("probe-artifact-only", false, "consumeProbe")
        assertArrayEquals(parameter, Files.readAllBytes(root.resolve("probe-cleanup.json")))
        mixins(result, "fixture.json", "[\"Good\"]")
        assertArrayEquals("current-input".toByteArray(), fixture.read(result, "resource.txt"))
        Files.writeString(root.resolve("probe-cleanup.json"), "{}")
        pipelineRun("probe-valid-empty", false, "consumeProbe")
        assertArrayEquals(fixture.read(root.resolve("probe.jar"), "fixture.json"), fixture.read(result, "fixture.json"))
        val reused = pipelineRun("probe-valid-empty-reuse", false, "consumeProbe")
        outcome(reused, ":consumeProbe", TaskOutcome.UP_TO_DATE)
    }

    @Test fun testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput() {
        pipelineProject()
        pipelineRun("before-strip-failure", false, "consumeA")
        completeA()
        val oldConsumption = snapshot(listOf(consumed("A", "A"), consumed("A", "mod")))
        // Change actual inputs so a shared-home transform cannot hide the selected I/O failure.
        replace(fixture.mod, "mod.jar", mapOf("resource.txt" to root.toString().toByteArray()))
        val source = pipelineRun("source-strip-failure", true, "consumeA", "-PfailStrip=source", "--no-build-cache")
        outcome(source, ":produceA", TaskOutcome.SUCCESS)
        assertTrue(source.output.contains("fixture strip read denied: " + fixture.mod), source.output)
        assertTrue(source.output.contains("ExactMixinStripper.rewrite"), source.output)
        outcome(source, ":consumeA", TaskOutcome.FAILED)
        unchanged(oldConsumption)
        assertFalse(source.output.contains("CONSUMED-A"))
        assertTrue(Files.isRegularFile(applied("A")))
        pipelineRun("independent-applied-after-source-failure", false, "appliedA")
        mixins(root.resolve("build/applied-only/A/A.jar"), "target.json", "[\"Both\"]")
        replace(fixture.target, "target.jar", mapOf("resource.txt" to root.toString().toByteArray()))
        val target = pipelineRun("target-strip-failure", true, "consumeA", "-PfailStrip=target", "--no-build-cache")
        outcome(target, ":produceA", TaskOutcome.SUCCESS)
        assertTrue(target.output.contains("fixture strip read denied: " + applied("A")), target.output)
        assertTrue(target.output.contains("ExactMixinStripper.rewrite"), target.output)
        outcome(target, ":consumeA", TaskOutcome.FAILED)
        unchanged(oldConsumption)
        assertFalse(target.output.contains("CONSUMED-A"))
        assertTrue(Files.isRegularFile(applied("A")))
        pipelineRun("independent-applied-after-target-failure", false, "appliedA")
        assertTrue(Files.isRegularFile(root.resolve("build/applied-only/A/A.jar")))
        mixins(root.resolve("build/applied-only/A/A.jar"), "target.json", "[\"Both\"]")
    }

    @Test fun testKitFailedCurrentProducerCannotRouteOldSuccess() {
        pipelineProject()
        pipelineRun("before-producer-failure", false, "consumeA")
        completeA()
        val success = Files.readAllBytes(consumed("A", "A"))
        val failed = pipelineRun("publication-output-conflict", true, "consumeA", "-PoverlapOutputs")
        outcome(failed, ":produceA", TaskOutcome.FAILED)
        assertFalse(failed.output.contains("CONSUMED-A"))
        assertArrayEquals(success, Files.readAllBytes(consumed("A", "A")), "old caller-owned copy may remain but was not routed as current success")
        val publication = pipelineRun("publication-actual-io-failure", true, "consumeA", "-PfailPublication", "--rerun-tasks", "--no-build-cache")
        outcome(publication, ":produceA", TaskOutcome.FAILED)
        assertTrue(publication.output.contains("fixture publication write denied:"), publication.output)
        assertTrue(publication.output.contains("ProduceMixinsKt.produceMixins"), publication.output)
        assertFalse(publication.output.contains("CONSUMED-A"))
        assertFalse(Files.exists(applied("A")))
        assertFalse(Files.exists(cleanup("A")))
        assertArrayEquals(success, Files.readAllBytes(consumed("A", "A")))
        Files.writeString(root.resolve("target.jar"), "broken current input")
        val invalid = pipelineRun("producer-invalid-current-input", true, "consumeA")
        outcome(invalid, ":produceA", TaskOutcome.FAILED)
        assertFalse(invalid.output.contains("CONSUMED-A"))
    }

    @Test fun testKitCurrentInputsAndMissingHandoffInvalidateProducer() {
        pipelineProject()
        pipelineRun("inputs-first", false, "consumeA")
        completeA()
        Files.delete(cleanup("A"))
        val repaired = pipelineRun("missing-handoff", false, "consumeA")
        assertTrue(repaired.task(":produceA")!!.outcome in setOf(TaskOutcome.FROM_CACHE, TaskOutcome.SUCCESS), repaired.output)
        completeA()
        replace(root.resolve("resolution-only.jar"), "resolution-only.jar", mapOf("resource.txt" to "runtime changed".toByteArray()))
        outcome(pipelineRun("runtime-resource", false, "consumeA"), ":produceA", TaskOutcome.SUCCESS)
        completeA()
        replace(fixture.mod, "mod.jar", mapOf("resource.txt" to "source changed".toByteArray()))
        outcome(pipelineRun("source-resource", false, "consumeA"), ":produceA", TaskOutcome.SUCCESS)
        completeA()
        outcome(pipelineRun("side-input", false, "consumeA", "-Pside=CLIENT"), ":produceA", TaskOutcome.SUCCESS)
        completeA()
    }
}
