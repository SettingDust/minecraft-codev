import net.msrandom.minecraftcodev.core.getVersionList
import net.msrandom.minecraftcodev.core.resolve.getAllDependencies
import net.msrandom.minecraftcodev.core.utils.getGlobalCacheDirectory
import net.msrandom.minecraftcodev.forge.UserdevConfig
import net.msrandom.minecraftcodev.forge.task.ResolvePatchedMinecraft

plugins {
    java
    id("minecraft-codev-forge")
}

repositories {
    maven(url = "https://maven.minecraftforge.net/") {
        metadataSources {
            gradleMetadata()
            mavenPom()
            artifact()
        }
    }
    maven(url = "https://libraries.minecraft.net/")
    mavenCentral()
}

val targetMinecraftVersion = "1.12.2"
val userdevFiles = configurations.create("userdevFiles") { isTransitive = false }
dependencies.add(userdevFiles.name, "net.minecraftforge:forge:$targetMinecraftVersion-14.23.5.2860:userdev3")
val userdev = providers.provider {
    UserdevConfig.fromFile(userdevFiles.singleFile).fold(
        { throw (it ?: GradleException("Missing userdev config")) },
        { it },
    )
}
val mcpFiles = configurations.create("mcpFiles") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(userdev.get().mcp)) }
}
val universalFiles = configurations.create("universalFiles") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(userdev.get().universal)) }
}
val minecraftLibraries = configurations.create("minecraftLibraries") {
    defaultDependencies {
        val metadata = getVersionList(
            getGlobalCacheDirectory(project).toPath(),
            isOffline = gradle.startParameter.isOffline,
        ).version(targetMinecraftVersion)
        (getAllDependencies(metadata) + userdev.get().libraries).forEach {
            add(project.dependencies.create(it))
        }
    }
}
userdev.get().modules.forEach { dependencies.constraints.add(minecraftLibraries.name, it) }

val patchedMinecraft by tasks.registering(ResolvePatchedMinecraft::class) {
    minecraftVersion.set(targetMinecraftVersion)
    neoforge.set(false)
    patches.from(userdevFiles, mcpFiles)
    universal.from(universalFiles)
    libraries.from(minecraftLibraries)
    output.set(layout.buildDirectory.file("minecraft/minecraft-$targetMinecraftVersion-patched.jar"))
}

val printCompileClasspath by tasks.registering {
    doLast {
        println()
        println(configurations.compileClasspath.get().joinToString("\n"))
        println("Java8 compiler: ${tasks.compileJava.get().javaCompiler.get().executablePath}")
        println("Java8 metadata: ${tasks.compileJava.get().javaCompiler.get().metadata.languageVersion}")
        listOf(userdevFiles, mcpFiles, universalFiles, minecraftLibraries).forEach { configuration ->
            configuration.resolvedConfiguration.resolvedArtifacts.forEach {
                println("${configuration.name}: ${it.moduleVersion.id}:${it.classifier ?: ""} -> ${it.file}")
            }
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

dependencies {
    implementation(files(patchedMinecraft.flatMap { it.output }))
    implementation(files(minecraftLibraries))
}
