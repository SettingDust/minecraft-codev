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

    private fun runner(taskSet: Boolean): GradleRunner {
        val args = mutableListOf("consume", "--offline", "--no-configuration-cache", "--no-build-cache", "--no-parallel", "--max-workers=1", "--console=plain", "--stacktrace")
        if (taskSet) args.add("-PtaskSet")
        return GradleRunner.create().withProjectDir(root.toFile()).withPluginClasspath().withArguments(args).forwardOutput()
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
