package net.msrandom.minecraftcodev.remapper

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Test
import java.io.File

class RemappedMinecraftTests {
    @Test
    fun `Test remapped Minecraft`() {
        GradleRunner.create()
            .withProjectDir(File("basic-remapped-test"))
            .withPluginClasspath()
            .withArguments(
                "printCompileClasspath",
                "jar",
                "-s",
            )
            .forwardOutput()
            .withDebug(true)
            .build()
    }
}
