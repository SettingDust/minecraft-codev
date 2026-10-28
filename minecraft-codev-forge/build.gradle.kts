plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins.create("minecraftCodevForge") {
        id = project.name
        description = "A Minecraft Codev module that allows providing Forge patched versions of Minecraft."
        implementationClass = "net.msrandom.minecraftcodev.forge.MinecraftCodevForgePlugin"
    }
}

dependencies {
    implementation(group = "io.arrow-kt", name = "arrow-core", version = "1.2.4")
    implementation(group = "io.arrow-kt", name = "arrow-core-serialization", version = "1.2.4")

    implementation("net.neoforged.accesstransformers:at-cli:13.0.3")

    implementation(group = "org.cadixdev", name = "lorenz", version = "0.5.8")

    implementation(group = "de.siegmar", name = "fastcsv", version = "2.2.0")
    implementation(group = "org.apache.logging.log4j", name = "log4j-core", version = "2.12.4")

    implementation(group = "com.electronwill.night-config", name = "toml", version = "3.6.0")

    implementation(projects.minecraftCodevAccessWidener)
    implementation(projects.minecraftCodevRemapper)
    implementation(projects.minecraftCodevRuns)
    implementation(projects.minecraftCodevMixins)
    implementation(projects.minecraftCodevIncludes)
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
    providers.gradleProperty("org.gradle.java.installations.paths").orNull
        ?.takeIf { it.isNotEmpty() }
        ?.let { systemProperty("org.gradle.java.installations.paths", it) }
    val fixtureProject = layout.projectDirectory.dir("integration-test/forge")
    inputs.dir(fixtureProject)
}
