plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins.create("minecraftCodevFabric") {
        id = project.name
        description = "A Minecraft Codev module that provides helpful utilities for using Minecraft Codev with the Fabric mod loader."
        implementationClass = "net.msrandom.minecraftcodev.fabric.MinecraftCodevFabricPlugin"
    }
}

dependencies {
    implementation(projects.minecraftCodevAccessWidener)
    implementation(projects.minecraftCodevRemapper)
    implementation(projects.minecraftCodevMixins)
    implementation(projects.minecraftCodevIncludes)
    implementation(projects.minecraftCodevRuns)
}

dependencies {
    testImplementation(projects.minecraftCodevCore)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.0-M1")
}

tasks.test {
    workingDir(layout.projectDirectory)
    systemProperty("java.io.tmpdir", temporaryDir.absolutePath)
    dependsOn(tasks.pluginUnderTestMetadata)
    executable = javaToolchains.launcherFor {}.get().executablePath.asFile.absolutePath
    val fixtureProject = layout.projectDirectory.dir("integration-test/fabric")
    inputs.dir(fixtureProject)
    inputs.dir(layout.projectDirectory.dir("integration-test/fabric-includes"))
}
