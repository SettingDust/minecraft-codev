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
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(17)) })
    systemProperty("fixture.gradleJava", System.getProperty("java.home"))
    val ordinaryProject = layout.projectDirectory.dir("integration-test/mixins/ordinary")
    val pipelineProject = layout.projectDirectory.dir("integration-test/mixins/pipeline")
    inputs.dir(ordinaryProject)
    inputs.dir(pipelineProject)
}
