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
    val temporaryDirectory = layout.buildDirectory.dir("reports/test/tmp")
    systemProperty("java.io.tmpdir", temporaryDirectory.get().asFile.absolutePath)
    doFirst { temporaryDirectory.get().asFile.mkdirs() }
    reports.html.outputLocation.set(layout.buildDirectory.dir("reports/test/html"))
    reports.junitXml.outputLocation.set(layout.buildDirectory.dir("reports/test/xml"))
    binaryResultsDirectory.set(layout.buildDirectory.dir("reports/test/binary"))
    dependsOn(tasks.pluginUnderTestMetadata)
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(17)) })
    systemProperty("fixture.gradleJava", System.getProperty("java.home"))
    val fixtureProject = layout.projectDirectory.dir("integration-test/fabric")
    inputs.dir(fixtureProject)
}
