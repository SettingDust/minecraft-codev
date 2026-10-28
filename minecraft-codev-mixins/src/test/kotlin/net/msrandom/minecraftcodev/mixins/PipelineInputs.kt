package net.msrandom.minecraftcodev.mixins

import org.gradle.testkit.runner.GradleRunner
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

/** Package private resource archives for Codev task/Strip wiring tests. */
object PipelineInputs {
    private val project: Path by lazy {
        val template = Path.of("integration-test/mixins/pipeline")
        val copy = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), "pipeline-")
        for (entry in listOf("settings.gradle", "build.gradle", "gradle.properties", "src")) {
            val source = template.resolve(entry)
            val destination = copy.resolve(entry)
            if (Files.isDirectory(source)) copyTree(source, destination)
            else Files.copy(source, destination)
        }
        val runner = GradleRunner.create().withProjectDir(copy.toFile())
        val result = runner.withArguments(
            "assemble",
            "-Dorg.gradle.java.home=" + System.getProperty("fixture.gradleJava"),
            "--offline", "--stacktrace", "--max-workers=1"
        ).build()
        Files.writeString(copy.resolve("assemble.log"), result.output)
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
        Files.copy(project.resolve("build/inputs/$name.jar"), destination, REPLACE_EXISTING)
        return destination
    }

}
