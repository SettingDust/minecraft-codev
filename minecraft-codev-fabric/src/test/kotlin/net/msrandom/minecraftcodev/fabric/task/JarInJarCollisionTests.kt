package net.msrandom.minecraftcodev.fabric.task

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarFile

class JarInJarCollisionTests {
    private fun fixture(): Path {
        val template = Path.of("integration-test/fabric-includes")
        val root = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), "fabric-includes-")
        Files.walk(template).use { paths ->
            paths.forEach { source ->
                val destination = root.resolve(template.relativize(source).toString())
                if (Files.isDirectory(source)) Files.createDirectories(destination)
                else Files.copy(source, destination)
            }
        }
        return root
    }

    private fun runner(root: Path, secondName: String) = GradleRunner.create().withProjectDir(root.toFile())
        .withPluginClasspath().withArguments(
            "embed", "-PsecondName=$secondName",
            "--stacktrace", "--max-workers=1", "--no-configuration-cache",
        )

    @Test
    fun differentSourcesWithSameBasenameFailBeforeCopying() {
        val root = fixture()
        val output = runner(root, "library.jar").buildAndFail().output
        assertTrue(output.contains("Conflicting included JAR name 'library.jar'"), output)
        assertTrue(output.contains(root.resolve("build/inputs/a/library.jar").toString()), output)
        assertTrue(output.contains(root.resolve("build/inputs/b/library.jar").toString()), output)
        assertFalse(Files.exists(root.resolve("build/tmp/embed/includes")))
        assertFalse(Files.exists(root.resolve("build/libs/output.jar")))
    }

    @Test
    fun differentBasenamesAndRepeatedSameSourceStillEmbed() {
        val root = fixture()
        runner(root, "other.jar").build()
        JarFile(root.resolve("build/libs/output.jar").toFile()).use { jar ->
            val metadata = Json.parseToJsonElement(jar.getInputStream(jar.getJarEntry("fabric.mod.json")).reader().readText()).jsonObject
            assertEquals(setOf("META-INF/jars/library.jar", "META-INF/jars/other.jar"),
                metadata.getValue("jars").jsonArray.map { it.jsonObject.getValue("file").jsonPrimitive.content }.toSet())
        }
        for ((name, payload) in listOf("library.jar" to "first", "other.jar" to "second")) {
            JarFile(root.resolve("build/tmp/embed/includes/$name").toFile()).use { jar ->
                assertEquals(payload, jar.getInputStream(jar.getJarEntry("payload.txt")).reader().readText())
                assertNotNull(jar.getJarEntry("fabric.mod.json"))
            }
        }
    }
}
