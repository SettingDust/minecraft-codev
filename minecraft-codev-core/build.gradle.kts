plugins {
    `java-gradle-plugin`
}

gradlePlugin {
    plugins.create("minecraftCodev") {
        id = rootProject.name
        description = "A Gradle plugin that allows using Minecraft as a dependency that participates in variant selection and resolution."
        implementationClass = "net.msrandom.minecraftcodev.core.MinecraftCodevPlugin"
    }
}

dependencies {
    implementation(projects.minecraftCodevCore.sideAnnotations)

    api(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version = "1.3.3")
    api(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.8.1")

    api(group = "net.minecraftforge", name = "srgutils", version = "latest.release")

    api(group = "org.ow2.asm", name = "asm-tree", version = "9.3")

    api(group = "com.google.guava", name = "guava", version = "31.1-jre")
    api(group = "org.apache.commons", name = "commons-lang3", version = "3.12.0")
    implementation(group = "commons-io", name = "commons-io", version = "2.11.0")

    api(group = "com.dynatrace.hash4j", name = "hash4j", version = "0.21.0")
}

tasks.test {
    dependsOn(tasks.pluginUnderTestMetadata)
}

publishing {
    publications {
        create<MavenPublication>("pluginMaven") {
            suppressAllPomMetadataWarnings()
        }
    }
}
