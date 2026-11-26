package net.msrandom.minecraftcodev.mixins

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarFile

class StripRegistrationTests {
    @TempDir lateinit var root: Path

    private fun config(jar: Path): String = JarFile(jar.toFile()).use { archive ->
        archive.getInputStream(archive.getJarEntry("fixture.json")).use { String(it.readAllBytes()) }
    }

    private fun runner(taskSet: Boolean, vararg options: String): GradleRunner {
        val args = mutableListOf("consume", "--offline", "--no-configuration-cache", "--no-build-cache", "--no-parallel", "--max-workers=1", "--console=plain", "--stacktrace")
        if (taskSet) args.add("-PtaskSet")
        args.addAll(options)
        return GradleRunner.create().withProjectDir(root.toFile()).withPluginClasspath().withArguments(args).forwardOutput()
    }

    @Test fun orderedRecordContentsAndOrderInvalidateRealTransformAndNewProcessReusesWorkspace() {
        for (entry in listOf("settings.gradle", "build.gradle", "cleanup.json", "task-input.json")) {
            Files.copy(Path.of("integration-test/mixins/pipeline", "callers/strip", entry), root.resolve(entry))
        }
        val source = PipelineInputs.copyJar("independent-strip", root.resolve("mod.client-1.2.jar"))
        val before = Files.readAllBytes(source)
        Files.writeString(root.resolve("gradle.properties"), "org.gradle.java.home=" + System.getProperty("fixture.gradleJava").replace('\\', '/') + "\n")
        val first = Files.createDirectories(root.resolve("first")).resolve("records.json")
        val second = Files.createDirectories(root.resolve("second")).resolve("records.json")
        Files.writeString(first, """{"fixture.json":["Good"]}""")
        Files.writeString(second, "{}")
        fun run(label: String, records: String, process: String = "one"): Pair<Path, String> {
            val build = runner(false, "-Precords=$records", "--info", "-Dorg.gradle.jvmargs=-Xmx${if (process == "one") 512 else 768}m").build()
            val path = Path.of(build.output.lineSequence().first { it.startsWith("STRIP-PATH=") }.substringAfter('='))
            val pid = build.output.lineSequence().first { it.startsWith("STRIP-PROCESS=") }.substringAfter('=')
            assertTrue(Files.isRegularFile(path))
            assertArrayEquals(before, Files.readAllBytes(source))
            println("ORDERED_STRIP $label pid=$pid path=$path\n${build.output}")
            return path to pid
        }
        val initial = run("initial", "first/records.json,second/records.json")
        assertEquals("{\"mixins\":[\"Keep\"]}", config(initial.first))
        val reused = run("unchanged", "first/records.json,second/records.json")
        assertEquals(initial.first, reused.first)
        Files.writeString(second, """{"fixture.json":["Keep"]}""")
        val content = run("later-content", "first/records.json,second/records.json")
        assertNotEquals(initial.first, content.first)
        assertEquals("{\"mixins\":[]}", config(content.first))
        val reversed = run("reversed", "second/records.json,first/records.json")
        assertNotEquals(content.first, reversed.first, "order must invalidate even when final JSON is identical")
        assertEquals(config(content.first), config(reversed.first))
        val duplicate = run("same-File-deduplicated", "second/records.json,first/records.json,second/records.json")
        assertEquals(reversed.first, duplicate.first)
        val fresh = run("new-process", "second/records.json,first/records.json", "two")
        assertNotEquals(reversed.second, fresh.second)
        assertEquals(reversed.first, fresh.first)
        assertEquals("{\"mixins\":[]}", config(fresh.first))
    }

    @Test fun handwrittenAndOtherTaskFilesDriveRealTransformAndFailedCurrentConsumption() {
        for (entry in listOf("settings.gradle", "build.gradle", "cleanup.json", "task-input.json")) {
            Files.copy(Path.of("integration-test/mixins/pipeline", "callers/strip", entry), root.resolve(entry))
        }
        val source = PipelineInputs.copyJar("independent-strip", root.resolve("mod.client-1.2.jar"))
        val before = Files.readAllBytes(source)
        Files.writeString(root.resolve("gradle.properties"), "org.gradle.java.home=" + System.getProperty("fixture.gradleJava").replace('\\', '/') + "\n")
        println("STRIP_CALLER project=$root")
        val result = root.resolve("build/consumed/mod.client-1.2-mixinStripped.jar")
        val hand = runner(false).build()
        assertNull(hand.task(":writeRemovals"))
        assertNull(hand.task(":produce"))
        assertEquals("{\"mixins\":[\"Keep\"]}", config(result))
        assertArrayEquals(before, Files.readAllBytes(source))
        val task = runner(true).build()
        assertEquals(TaskOutcome.SUCCESS, task.task(":writeRemovals")!!.outcome)
        assertEquals("{\"mixins\":[\"Good\",\"Good\"]}", config(result))
        assertArrayEquals(before, Files.readAllBytes(source))
        val old = Files.readAllBytes(result)
        Files.writeString(root.resolve("task-input.json"), "{\"fixture.json\":{}}")
        val failed = runner(true).buildAndFail()
        assertEquals(TaskOutcome.SUCCESS, failed.task(":writeRemovals")!!.outcome)
        assertEquals(TaskOutcome.FAILED, failed.task(":consume")!!.outcome)
        assertFalse(failed.output.contains("STRIP-CONSUMED"))
        assertArrayEquals(old, Files.readAllBytes(result), "caller-owned old copy may remain but current consumption failed")
        assertArrayEquals(before, Files.readAllBytes(source))
        Files.writeString(root.resolve("task-input.json"), "{}")
        assertEquals(TaskOutcome.SUCCESS, runner(true).build().task(":consume")!!.outcome)
        assertEquals(config(source), config(result))
        assertArrayEquals(before, Files.readAllBytes(source))
    }
}
