plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins.create("minecraftCodevIncludes") {
        id = project.name
        description = "A Minecraft Codev module that provides ways of including Jar in Jars."
        implementationClass = "net.msrandom.minecraftcodev.includes.MinecraftCodevIncludesPlugin"
    }
}

dependencies {
    implementation(projects.minecraftCodevCore)
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
    systemProperty("fixture.gradleUserHome", gradle.gradleUserHomeDir.absolutePath)
    systemProperty("org.gradle.testkit.dir", gradle.gradleUserHomeDir.absolutePath)
    providers.gradleProperty("org.gradle.java.installations.paths").orNull
        ?.takeIf { it.isNotEmpty() }
        ?.let { systemProperty("org.gradle.java.installations.paths", it) }
    inputs.dir(layout.projectDirectory.dir("src/test/resources/include-identity"))
}
