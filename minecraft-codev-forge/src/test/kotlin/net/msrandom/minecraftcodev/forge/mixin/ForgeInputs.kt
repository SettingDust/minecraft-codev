package net.msrandom.minecraftcodev.forge.mixin

import org.gradle.testkit.runner.GradleRunner
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

/** Build static Forge/NeoForge inputs once; tests only copy and exercise them. */
object ForgeInputs {
    private val project: Path by lazy {
        val template = Path.of("integration-test/forge")
        val copy = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), "forge-")
        for (entry in listOf("settings.gradle", "build.gradle", "src")) {
            val source = template.resolve(entry)
            val destination = copy.resolve(entry)
            if (Files.isDirectory(source)) copyTree(source, destination) else Files.copy(source, destination)
        }
        val runner = GradleRunner.create().withProjectDir(copy.toFile()).withPluginClasspath()
        val result = runner.withArguments(
            "assemble",
            "-PfixtureClasspath=" + runner.pluginClasspath.joinToString(java.io.File.pathSeparator) { it.path },
            "-Dorg.gradle.java.home=" + System.getProperty("fixture.gradleJava"),
            "--stacktrace", "--max-workers=1",
        ).build()
        val evidence = copy
        Files.writeString(evidence.resolve("gradle.log"), result.output)
        Files.writeString(evidence.resolve("project.txt"), copy.toString())
        copy
    }

    private fun copyTree(source: Path, destination: Path) {
        Files.walk(source).use { paths ->
            paths.forEach { path ->
                val target = destination.resolve(source.relativize(path).toString())
                if (Files.isDirectory(path)) Files.createDirectories(target)
                else Files.copy(path, target, REPLACE_EXISTING)
            }
        }
    }

    @JvmStatic fun copyJar(name: String, destination: Path): Path {
        Files.copy(project.resolve("build/libs/$name.jar"), destination, REPLACE_EXISTING)
        return destination
    }
}
