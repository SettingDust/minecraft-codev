import net.msrandom.minecraftcodev.core.getVersionList
import net.msrandom.minecraftcodev.core.resolve.getAllDependencies
import net.msrandom.minecraftcodev.core.task.ResolveMinecraftMappings
import net.msrandom.minecraftcodev.core.utils.getGlobalCacheDirectory
import net.msrandom.minecraftcodev.forge.UserdevConfig
import net.msrandom.minecraftcodev.forge.task.ResolvePatchedMinecraft
import net.msrandom.minecraftcodev.remapper.task.LoadMappings
import net.msrandom.minecraftcodev.remapper.task.RemapTask

plugins {
    java
    id("minecraft-codev-forge")
    id("minecraft-codev-remapper")
}

repositories {
    mavenCentral()
    maven {
        name = "Minecraft Libraries"
        url = uri("https://libraries.minecraft.net")
    }
    maven {
        name = "MinecraftForge"
        url = uri("https://maven.minecraftforge.net")
    }
}

val targetMinecraftVersion = "1.16.5"
val forgeVersion = "1.16.5-36.2.39"
val userdev by configurations.creating { isTransitive = false }
dependencies.add(userdev.name, "net.minecraftforge:forge:$forgeVersion:userdev")
val userdevConfig = UserdevConfig.fromFile(userdev.singleFile).fold(
    { throw (it ?: GradleException("Missing userdev config")) },
    { it },
)
val mcp by configurations.creating { isTransitive = false }
val universalFiles = configurations.create("universal") { isTransitive = false }
val minecraftLibraries by configurations.creating

dependencies {
    add(mcp.name, userdevConfig.mcp)
    add(universalFiles.name, userdevConfig.universal)
    val metadata = getVersionList(
        getGlobalCacheDirectory(project).toPath(),
        isOffline = gradle.startParameter.isOffline,
    ).version(targetMinecraftVersion)
    getAllDependencies(metadata).forEach { add(minecraftLibraries.name, it) }
    userdevConfig.libraries.forEach { add(minecraftLibraries.name, it) }
    constraints { userdevConfig.modules.forEach { add(minecraftLibraries.name, it) } }
}

val patchedMinecraft by tasks.registering(ResolvePatchedMinecraft::class) {
    minecraftVersion.set(targetMinecraftVersion)
    neoforge.set(false)
    patches.from(userdev, mcp)
    libraries.from(minecraftLibraries)
    universal.from(universalFiles)
    output.set(layout.buildDirectory.file("minecraft/minecraft-$targetMinecraftVersion-patched.jar"))
}
val clientMappings by tasks.registering(ResolveMinecraftMappings::class) {
    minecraftVersion.set(targetMinecraftVersion)
    server.set(false)
}
val loadedMappings by tasks.registering(LoadMappings::class) {
    mappings.from(clientMappings.flatMap { it.output }, mcp)
    javaExecutable.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(8))
    }.map { it.executablePath })
}
val remappedMinecraft by tasks.registering(RemapTask::class) {
    inputFile.set(patchedMinecraft.flatMap { it.output })
    mappings.set(loadedMappings.flatMap { it.output })
    classpath.from(minecraftLibraries)
    sourceNamespace.set("srg")
    targetNamespace.set("named")
    outputFile.set(layout.buildDirectory.file("minecraft/minecraft-$targetMinecraftVersion-named.jar"))
}

dependencies {
    implementation(files(remappedMinecraft.flatMap { it.outputFile }))
    implementation(files(minecraftLibraries))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

tasks.register("printCompileClasspath") {
    doLast {
        sourceSets.main.get().compileClasspath.forEach {
            println(it)
        }
        println("Mappings Java: ${loadedMappings.get().javaExecutable.get().asFile}")
        println("Userdev: ${userdev.singleFile}")
        println("MCP: ${mcp.singleFile}")
        println("Universal: ${universalFiles.singleFile}")
        println("Userdev libraries: ${userdevConfig.libraries}")
        println("Userdev module constraints: ${userdevConfig.modules}")
        listOf(userdev, mcp, universalFiles, minecraftLibraries).forEach { configuration ->
            configuration.resolvedConfiguration.resolvedArtifacts.forEach {
                println("Resolved ${configuration.name}: ${it.moduleVersion.id}:${it.classifier ?: ""} -> ${it.file}")
            }
        }
        println("Official mappings server: ${clientMappings.get().server.get()}")
        println("Official mappings: ${clientMappings.get().output.get().asFile}")
        println("Remap classpath: ${remappedMinecraft.get().classpath.files}")
        println("Patches: ${patchedMinecraft.get().patches.files}")
        println("Patched Minecraft: ${patchedMinecraft.get().output.get().asFile}")
        println("Mappings input order: ${loadedMappings.get().mappings.files}")
        println("Tiny mappings: ${loadedMappings.get().output.get().asFile}")
        println("Remap input: ${remappedMinecraft.get().inputFile.get().asFile}")
        println("Remap namespaces: ${remappedMinecraft.get().sourceNamespace.get()} -> ${remappedMinecraft.get().targetNamespace.get()}")
        println("Named Minecraft: ${remappedMinecraft.get().outputFile.get().asFile}")
        gradle.taskGraph.allTasks.forEach { task ->
            println("Producer graph: ${task.path} <- ${task.taskDependencies.getDependencies(task).map { it.path }.sorted()}")
        }
    }
}

gradle.projectsEvaluated {
    val compiler = tasks.compileJava.get().javaCompiler.get()
    println("Java8 compiler: ${compiler.executablePath.asFile}")
    println("Java8 metadata: ${compiler.metadata.languageVersion}")
}
