plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins.create("minecraftCodevMixins") {
        id = project.name
        description = "A Minecraft Codev module that allows applying mixins to Minecraft dependencies " +
                "and injecting mixins into run configurations."
        implementationClass = "net.msrandom.minecraftcodev.mixins.MinecraftCodevMixinsPlugin"
    }
}

dependencies {
    api(group = "net.fabricmc", name = "sponge-mixin", version = "0.15.0+mixin.0.8.7")
    // Keep the isolated Mixin engine's ASM readers compatible with Java 25 class files.
    implementation("org.ow2.asm:asm-commons:9.8")
    implementation("org.ow2.asm:asm-util:9.8")

    implementation(projects.minecraftCodevCore)
    implementation("net.fabricmc:mapping-io:0.7.1")
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
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.current()) })
    systemProperty("fixture.gradleJava", System.getProperty("java.home"))
    systemProperty("fixture.gradleInstallation", gradle.gradleHomeDir!!.absolutePath)
    val ordinaryProject = layout.projectDirectory.dir("integration-test/mixins/ordinary")
    val pipelineProject = layout.projectDirectory.dir("integration-test/mixins/pipeline")
    inputs.dir(ordinaryProject)
    inputs.dir(pipelineProject)
    inputs.dir(layout.projectDirectory.dir("integration-test/mixins/failure-transport"))
}
