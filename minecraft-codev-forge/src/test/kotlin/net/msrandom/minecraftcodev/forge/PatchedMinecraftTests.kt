package net.msrandom.minecraftcodev.forge

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Test
import java.io.File

private fun patchedMinecraftArguments(pathName: String): List<String> {
    val arguments = mutableListOf("jar", "printCompileClasspath", "-s")
    if (pathName == "basic-patched-test" || pathName == "remapped-patched-test") {
        System.getProperty("org.gradle.java.installations.paths")
            ?.takeIf { it.isNotEmpty() }
            ?.let { arguments.add("-Dorg.gradle.java.installations.paths=$it") }
    }
    if (pathName == "remapped-patched-test" && System.getenv("CODEV_REMAPPED_NESTED_RERUN") == "1") {
        arguments.add("--rerun-tasks")
    }
    return arguments
}

class PatchedMinecraftTests {
    private fun test(pathName: String) {
        GradleRunner.create()
            .withProjectDir(File(pathName))
            .withPluginClasspath()
            .withArguments(patchedMinecraftArguments(pathName))
            .forwardOutput()
            .withDebug(true)
            .build()
    }

    @Test fun `Test patched Minecraft arguments`() {
        val property = "org.gradle.java.installations.paths"
        val original = System.getProperty(property)
        val values = listOf(null, "", "C:\\Java17,D:\\Java8", "C:\\JDK One,D:\\Program Files\\Java\\jdk8")
        val rerun = System.getenv("CODEV_REMAPPED_NESTED_RERUN") == "1"
        println("Patched arguments worker: pid=${ProcessHandle.current().pid()} id=${System.getProperty("org.gradle.test.worker") ?: "<unset>"} env=${System.getenv("CODEV_REMAPPED_NESTED_RERUN") ?: "<unset>"}")
        try {
            for (pathName in listOf("basic-patched-test", "remapped-patched-test")) {
                for (value in values) {
                    if (value == null) System.clearProperty(property) else System.setProperty(property, value)
                    val expected = mutableListOf("jar", "printCompileClasspath", "-s")
                    if (!value.isNullOrEmpty()) expected.add("-D$property=$value")
                    if (pathName == "remapped-patched-test" && rerun) expected.add("--rerun-tasks")
                    val actual = patchedMinecraftArguments(pathName)
                    println("Patched arguments case: project=$pathName input=${value?.let { "\"$it\"" } ?: "<unset>"} argv=$actual")
                    check(actual == expected)
                }
            }
        } finally {
            if (original == null) System.clearProperty(property) else System.setProperty(property, original)
        }
    }

    @Test fun `Test patched Minecraft`() = test("basic-patched-test")

    @Test fun `Test remapped patched Minecraft`() = test("remapped-patched-test")
}
