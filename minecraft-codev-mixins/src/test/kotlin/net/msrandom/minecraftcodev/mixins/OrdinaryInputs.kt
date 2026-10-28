package net.msrandom.minecraftcodev.mixins

import org.gradle.testkit.runner.GradleRunner
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

/** Private inputs; build only the requested fixture, never the old engine matrix. */
object OrdinaryInputs {
    private val project: Path by lazy {
        val template = Path.of("integration-test/mixins/ordinary")
        val copy = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), "ordinary-")
        for (entry in listOf("settings.gradle", "build.gradle", "src", "variants")) {
            val source = template.resolve(entry)
            val destination = copy.resolve(entry)
            if (Files.isDirectory(source)) copyTree(source, destination)
            else Files.copy(source, destination)
        }
        copy
    }

    private fun build(task: String) {
        val runner = GradleRunner.create().withProjectDir(project.toFile()).withPluginClasspath()
        val result = runner.withArguments(
            task, "-PfixtureClasspath=" + runner.pluginClasspath.joinToString(java.io.File.pathSeparator) { it.path },
            "-Dorg.gradle.java.home=" + System.getProperty("fixture.gradleJava"),
            "--offline", "--stacktrace", "--max-workers=1"
        ).build()
        Files.writeString(project.resolve("$task.log"), result.output)
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

    @JvmStatic fun copyClasses(sourceSet: String, destination: Path) {
        val classes = project.resolve("build/classes/java/$sourceSet")
        if (!Files.isDirectory(classes)) build("${sourceSet}Classes")
        copyTree(classes, destination)
    }

    @JvmStatic fun copyResources(sourceSet: String, destination: Path) {
        val resources = project.resolve("build/resources/$sourceSet")
        if (!Files.isDirectory(resources)) build("${sourceSet}Classes")
        copyTree(resources, destination)
    }

    @JvmStatic fun copyJar(name: String, destination: Path): Path {
        val jar = project.resolve("build/inputs/$name.jar")
        if (!Files.isRegularFile(jar)) build(name)
        Files.copy(jar, destination, REPLACE_EXISTING)
        return destination
    }

    @JvmStatic fun copyMappingResource(name: String, destination: Path): Path {
        Files.copy(Path.of("integration-test/mixins/ordinary/src/mapping/resources", name), destination, REPLACE_EXISTING)
        return destination
    }
}
