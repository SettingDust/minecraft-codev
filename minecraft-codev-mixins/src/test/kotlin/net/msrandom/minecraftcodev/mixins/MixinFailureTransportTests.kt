package net.msrandom.minecraftcodev.mixins

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.*
import java.lang.reflect.InvocationTargetException
import java.nio.file.Files
import java.nio.file.Path
import java.util.IdentityHashMap

class MixinFailureTransportTests {
    @TempDir lateinit var root: Path

    private val reason = "Requested refmap context without a usable refmap: unknown"
    private val mixinException = "org.spongepowered.asm.mixin.throwables.MixinException"
    private val selectors = listOf("mixin.service", "mixin.bootstrapService")

    private data class Diagnostic(val type: String, val message: String?, val stack: List<StackTraceElement>, val cause: Int?, val suppressed: List<Int>)

    private fun graph(root: Throwable, original: Boolean = false): List<Diagnostic> {
        val ids = IdentityHashMap<Throwable, Int>()
        val nodes = mutableListOf<Throwable>()
        fun id(node: Throwable): Int = ids[node] ?: nodes.size.also { ids[node] = it; nodes.add(node) }
        id(root)
        val result = mutableListOf<Diagnostic>()
        var index = 0
        while (index < nodes.size) {
            val node = nodes[index++]
            // Resolve every public signature just as Gradle does, including after deserialization.
            if (!original) {
                assertSame(MixinFailureTransportTests::class.java.classLoader, node.javaClass.classLoader)
                node.javaClass.methods.forEach { it.parameterTypes; it.returnType; it.exceptionTypes }
            }
            result.add(Diagnostic(if (original) node.javaClass.name else node.toString().substringBefore(':'),
                node.message, node.stackTrace.toList(), node.cause?.let(::id), node.suppressed.map(::id)))
        }
        return result
    }

    @Test fun realChildFailureGraphRemainsInspectableAndSerializableAfterClose() {
        val target = OrdinaryInputs.copyJar("target", root.resolve("target.jar"))
        val source = OrdinaryInputs.copyJar("smoke-source", root.resolve("source.jar"))
        val previous = Thread.currentThread().contextClassLoader
        val priorSelectors = selectors.map(System::getProperty)
        lateinit var expected: List<Diagnostic>
        val safe = try {
            IsolatingMixinClassLoader(implementationInputs().map { Path.of(it).toUri().toURL() }.toTypedArray(),
                arrayOf(source.toUri().toURL(), target.toUri().toURL())).use { loader ->
                Thread.currentThread().contextClassLoader = loader
                initializeMixinRuntime(loader)
                val method = loader.loadClass("net.msrandom.minecraftcodev.mixins.runtime.ApplyMixinsKt")
                    .getMethod("applyMixins", String::class.java, String::class.java, String::class.java,
                        List::class.java, Map::class.java, String::class.java, String::class.java, String::class.java, String::class.java)
                val failure = assertThrows(InvocationTargetException::class.java) {
                    method.invoke(null, target.toString(), root.resolve("staged.jar").toString(), "SERVER",
                        listOf("fixture.json"), mapOf("fixture.json" to setOf("*")), null, null, null, "unknown")
                }.cause!!
                assertEquals(mixinException, failure.javaClass.name)
                assertSame(loader, failure.javaClass.classLoader)
                val shared = IllegalStateException(null as String?)
                val ring = IOException("cycle")
                shared.initCause(ring)
                ring.initCause(shared)
                val child = failure.javaClass.getConstructor(String::class.java).newInstance("suppressed child") as Throwable
                child.addSuppressed(ring)
                failure.addSuppressed(shared)
                failure.addSuppressed(child)
                failure.addSuppressed(shared)
                expected = graph(failure, original = true)
                hostMixinFailure(failure)
            }
        } finally { Thread.currentThread().contextClassLoader = previous }
        assertEquals(priorSelectors, selectors.map(System::getProperty))
        assertEquals(expected, graph(safe))
        assertSame(safe.suppressed[0], safe.suppressed[2])
        assertSame(safe.suppressed[0], safe.suppressed[0].cause!!.cause)
        assertNull(safe.suppressed[0].message)
        val bytes = ByteArrayOutputStream().also { buffer -> ObjectOutputStream(buffer).use { it.writeObject(safe) } }.toByteArray()
        val restored = ObjectInputStream(ByteArrayInputStream(bytes)).use { it.readObject() as Throwable }
        assertEquals(expected, graph(restored))
        val trace = StringWriter().also { restored.printStackTrace(PrintWriter(it)) }.toString()
        assertTrue(trace.contains(mixinException), trace)
        assertTrue(trace.contains(reason), trace)
        assertTrue(trace.contains("CIRCULAR REFERENCE"), trace)
        Files.writeString(root.resolve("graph.txt"), trace)
        for (path in listOf(target, source)) {
            val moved = path.resolveSibling(path.fileName.toString() + ".released")
            Files.move(path, moved)
            Files.move(moved, path)
        }
        println("HOST_GRAPH nodes=${expected.size} originalTypes/messages/stacks/orderedEdges=true shared/cycle/null=true reflection/serializationAfterClose=true jarsReleased=true")
    }

    @Test fun producerFailureInvalidatesOldOutputsRestoresStateAndCanRetry() {
        val fixture = MixinFixture(root)
        fixture.target = OrdinaryInputs.copyJar("target", root.resolve("target.jar"))
        val source = OrdinaryInputs.copyJar("smoke-source", root.resolve("source.jar"))
        val inputs = listOf(fixture.target, source).associateWith(Files::readAllBytes)
        val previous = Thread.currentThread().contextClassLoader
        val priorSelectors = selectors.map(System::getProperty)
        val output = fixture.produce("retry", listOf(source.toString()), emptyList())
        val records = root.resolve("retry.json")
        assertEquals(42, fixture.value(output))
        val notifications = Files.readAllBytes(records)
        assertEquals("{\"fixture.json\":[\"Good\"]}", String(notifications))
        assertSame(previous, Thread.currentThread().contextClassLoader)
        assertEquals(priorSelectors, selectors.map(System::getProperty))
        val failure = assertThrows(Throwable::class.java) {
            produceMixins(fixture.target.toString(), listOf(source.toString()), emptyList(), "SERVER",
                output.toString(), records.toString(), refmapContext = "unknown")
        }
        assertEquals(mixinException, graph(failure)[0].type)
        assertTrue(StringWriter().also { failure.printStackTrace(PrintWriter(it)) }.toString().contains(reason))
        assertSame(previous, Thread.currentThread().contextClassLoader)
        assertEquals(priorSelectors, selectors.map(System::getProperty))
        assertFalse(Files.exists(output))
        assertFalse(Files.exists(records))
        Files.list(root).use { paths -> assertFalse(paths.anyMatch { it.fileName.toString().startsWith(".codev-mixin-") }) }
        fixture.produce("retry", listOf(source.toString()), emptyList())
        assertEquals(42, fixture.value(output))
        assertArrayEquals(notifications, Files.readAllBytes(records))
        assertSame(previous, Thread.currentThread().contextClassLoader)
        assertEquals(priorSelectors, selectors.map(System::getProperty))
        for ((path, bytes) in inputs) {
            assertArrayEquals(bytes, Files.readAllBytes(path))
            val moved = path.resolveSibling(path.fileName.toString() + ".released")
            Files.move(path, moved)
            Files.move(moved, path)
        }
        println("PRODUCER_RECOVERY value=42 failureInvalidatedPair=true stagedClean=true retryValue=42 notificationsRestored=true tccl/selectorsRestored=true inputsUnchangedAndReleased=true")
    }

    @Test fun daemonTransportsRealFailureInBothLogAndFinalResultThenRetries() {
        val template = Path.of("integration-test/mixins/ordinary")
        val project = Files.createTempDirectory(Files.createDirectories(Path.of("build/tmp/failure-transport").toAbsolutePath()), "ordinary-")
        for (entry in listOf("settings.gradle", "build.gradle", "src", "variants")) {
            Files.walk(template.resolve(entry)).use { paths -> paths.forEach { path ->
                val destination = project.resolve(template.relativize(path).toString())
                if (Files.isDirectory(path)) Files.createDirectories(destination) else Files.copy(path, destination)
            } }
        }
        Files.copy(Path.of("integration-test/mixins/failure-transport/producer.gradle"), project.resolve("producer.gradle"))
        val buildFile = project.resolve("build.gradle")
        Files.writeString(buildFile, Files.readString(buildFile).replace("plugins { id 'java' }",
            "plugins { id 'java'; id 'minecraft-codev-mixins' }") + "\napply from: 'producer.gradle'\n")
        val runner = GradleRunner.create().withProjectDir(project.toFile()).withPluginClasspath()
            .withGradleInstallation(File(System.getProperty("fixture.gradleInstallation")))
        // Discovery SPI belongs only to this test runner, never to the production plugin.
        runner.withPluginClasspath(runner.pluginClasspath + listOf(
            File(FixtureMixinRule::class.java.protectionDomain.codeSource.location.toURI()), File("build/resources/test").absoluteFile))
        val classpath = runner.pluginClasspath.joinToString(File.pathSeparator) { it.path }
        fun run(label: String, fails: Boolean, vararg extra: String): org.gradle.testkit.runner.BuildResult {
            runner.withArguments(listOf("consume", "-PfixtureClasspath=$classpath", "-Dorg.gradle.java.home=" + System.getProperty("fixture.gradleJava"),
                "--offline", "--stacktrace", "--console=plain", "--max-workers=1", "--no-configuration-cache", "--no-build-cache", "--rerun-tasks") + extra)
            val result = if (fails) runner.buildAndFail() else runner.build()
            Files.writeString(project.resolve("$label.log"), result.output)
            return result
        }
        val success = run("success", false)
        assertEquals(TaskOutcome.SUCCESS, success.task(":produce")!!.outcome)
        assertEquals(TaskOutcome.SUCCESS, success.task(":consume")!!.outcome)
        val applied = project.resolve("build/mixin/produce/applied.jar")
        val records = project.resolve("build/mixin/produce/removals.json")
        val fixture = MixinFixture(root)
        assertEquals(42, fixture.value(applied))
        val notifications = Files.readAllBytes(records)
        assertEquals("{\"fixture.json\":[\"Good\"]}", String(notifications))
        val inputs = listOf("target.jar", "smoke-source.jar").map { project.resolve("build/inputs/$it") }.associateWith(Files::readAllBytes)
        Files.delete(project.resolve("build/consumed/applied.jar"))
        val failed = run("failure", true, "-PfailContext")
        assertEquals(TaskOutcome.FAILED, failed.task(":produce")!!.outcome)
        assertNull(failed.task(":consume"))
        assertFalse(Files.exists(project.resolve("build/consumed/applied.jar")))
        assertFalse(Files.exists(applied))
        assertFalse(Files.exists(records))
        Files.list(applied.parent).use { paths -> assertFalse(paths.anyMatch { it.fileName.toString().startsWith(".codev-mixin-") }) }
        assertTrue(failed.output.contains("TRANSPORT_ENV Gradle=" + org.gradle.util.GradleVersion.current().version + " Java=" + System.getProperty("java.specification.version")), failed.output)
        assertTrue(failed.output.contains("Mixin producer/publication failed:"), failed.output)
        assertTrue(failed.output.contains("FAILURE: Build failed with an exception."), failed.output)
        val log = failed.output.substringAfter("Mixin producer/publication failed:").substringBefore("FAILURE: Build failed with an exception.")
        val finalFailure = failed.output.substringAfter("FAILURE: Build failed with an exception.")
        for (part in listOf(log, finalFailure)) for (diagnostic in listOf(mixinException, "Cannot select refmap context for fixture.json", reason)) {
            assertTrue(part.contains(diagnostic), "Missing $diagnostic in transport section:\n$part")
        }
        for (broken in listOf("DaemonConnectionException", "NoClassDefFoundError", "StreamCorruptedException", "invalid type code")) assertFalse(failed.output.contains(broken), failed.output)
        for ((path, bytes) in inputs) assertArrayEquals(bytes, Files.readAllBytes(path))
        val retry = run("retry", false)
        assertEquals(TaskOutcome.SUCCESS, retry.task(":produce")!!.outcome)
        assertEquals(TaskOutcome.SUCCESS, retry.task(":consume")!!.outcome)
        assertEquals(42, fixture.value(project.resolve("build/consumed/applied.jar")))
        assertArrayEquals(notifications, Files.readAllBytes(records))
        println("DAEMON_TRANSPORT gradle=${org.gradle.util.GradleVersion.current()} normalBuildAndFail=true producer=FAILED consumerNotRun=true logAndFinalFailureOriginalDiagnostics=true invalidationAndRetry=true project=$project")
    }
}
