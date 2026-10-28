import net.msrandom.minecraftcodev.core.getVersionList
import net.msrandom.minecraftcodev.core.resolve.*
import net.msrandom.minecraftcodev.core.task.CachedMinecraftTask
import net.msrandom.minecraftcodev.core.utils.hashFile
import net.msrandom.minecraftcodev.forge.task.PATCH_OPERATION_VERSION
import com.google.common.hash.Hashing
import net.msrandom.minecraftcodev.forge.McpConfigFile
import net.msrandom.minecraftcodev.forge.UserdevConfig
import net.msrandom.minecraftcodev.forge.task.ResolvePatchedMinecraft
import org.gradle.process.ExecOperations
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.security.MessageDigest
import java.util.jar.JarFile
import java.util.zip.ZipFile
import javax.inject.Inject

plugins { id("minecraft-codev-forge") }

repositories {
    maven("https://maven.neoforged.net/releases/") { content { includeGroupByRegex("net\\.neoforged(\\..*)?"); includeGroup("cpw.mods") }; metadataSources { mavenPom(); artifact() } }
    maven("https://maven.minecraftforge.net/") { metadataSources { mavenPom(); artifact() } }
    maven("https://libraries.minecraft.net/")
    mavenCentral()
}

val neoPreparedRoot = providers.gradleProperty("neoPreparedRoot").orNull?.let { file(it).toPath().toRealPath() }
// Staged at <module>/build/reports/test/fixtures/<run>/<sample>/<phase>/project.
val privateCache = neoPreparedRoot?.resolve("prepare/cache")?.toFile() ?: file("../cache")
val evidence = file("../evidence").apply { mkdirs() }
val outputDirectory = file("../output").apply { mkdirs() }
val targetVersion = "1.12.2"
val userdevFiles = configurations.create("basicUserdev") { isTransitive = false }
dependencies.add(userdevFiles.name, "net.minecraftforge:forge:1.12.2-14.23.5.2860:userdev3")
val userdev = providers.provider {
    UserdevConfig.fromFile(userdevFiles.singleFile).fold(
        { throw (it ?: GradleException("Missing userdev config")) }, { it },
    ).also {
        check(it.notchObf && it.mcp == "de.oceanlabs.mcp:mcp_config:1.12.2-20200226.224830@zip")
        check(it.binpatcher.version == "net.minecraftforge:binarypatcher:1.1.1:fatjar")
    }
}
val metadata = providers.provider {
    getVersionList(privateCache.toPath(), isOffline = gradle.startParameter.isOffline).version(targetVersion)
}
val mcpFiles = configurations.create("basicMcp") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(userdev.get().mcp)) }
}
val universalFiles = configurations.create("basicUniversal") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(userdev.get().universal)) }
}
val minecraftLibraries = configurations.create("basicLibraries") {
    defaultDependencies {
        (getAllDependencies(metadata.get()) + userdev.get().libraries + userdev.get().modules).forEach {
            add(project.dependencies.create(it))
        }
    }
}
val mcp = providers.provider {
    McpConfigFile.configEntry(mcpFiles.singleFile).fold(
        { throw (it ?: GradleException("Missing MCP config")) }, { it },
    ).also { config ->
        check(config.version == targetVersion)
        check(config.functions.getValue("merge").version == "net.minecraftforge:mergetool:0.2.3.2:fatjar")
        check(config.functions.getValue("rename").version == "net.md-5:SpecialSource:1.8.3:shaded")
        check(config.functions.getValue("mcinject").version == "de.oceanlabs.mcp:mcinjector:3.7.3:fatjar")
    }
}
tasks.withType<CachedMinecraftTask>().configureEach { cacheParameters.directory.set(privateCache) }
val patchedBasicNotch = tasks.register<ResolvePatchedMinecraft>("patchedBasicNotch") {
    minecraftVersion.set(targetVersion)
    neoforge.set(false)
    patches.from(userdevFiles, mcpFiles)
    universal.from(universalFiles)
    libraries.from(minecraftLibraries)
    output.set(outputDirectory.resolve("minecraft-1.12.2-patched.jar"))
}
fun digest(file: File, algorithm: String = "SHA-256"): String =
    MessageDigest.getInstance(algorithm).digest(file.readBytes()).joinToString("") { "%02x".format(it) }
fun recordFile(role: String, file: File) {
    evidence.resolve("files.tsv").appendText("$role\t${file.absolutePath}\t${file.length()}\t${digest(file)}\n")
}
fun entries(file: File): List<String> = ZipFile(file).use { z ->
    z.entries().asSequence().filterNot { it.isDirectory }.map { it.name }.sorted().toList()
}
fun extract(archive: File, name: String): File = evidence.resolve(name).apply {
    parentFile.mkdirs()
    ZipFile(archive).use { z -> writeBytes(z.getInputStream(checkNotNull(z.getEntry(name))).use { it.readBytes() }) }
    recordFile("archive-entry:$name", this)
}
val basicTools = configurations.create("basicReferenceTools") {
    isTransitive = false
    defaultDependencies {
        listOf("merge", "rename", "mcinject").map { mcp.get().functions.getValue(it) }
            .plus(userdev.get().binpatcher).forEach { library ->
                (listOfNotNull(library.version) + library.classpath).forEach { add(project.dependencies.create(it)) }
            }
    }
}
val basicReferenceSources = configurations.create("basicReferenceSources") { isTransitive = false }
dependencies.add(basicReferenceSources.name, "net.minecraftforge:binarypatcher:1.1.1:sources")
abstract class BasicReferenceServices { @get:Inject abstract val exec: ExecOperations }
val referenceServices = objects.newInstance<BasicReferenceServices>()
val toolchains = extensions.getByType<JavaToolchainService>()
val referenceOutput = outputDirectory.resolve("reference-patched-at.jar")
val referenceBasicNotch = tasks.register("referenceBasicNotch") {
    outputs.file(referenceOutput)
    doLast {
        val game = metadata.get()
        val config = mcp.get()
        val ud = userdev.get()
        val tools = basicTools.resolve().sortedBy { it.name }
        val java8 = game.javaVersion.executable(toolchains).get().asFile
        check(game.javaVersion.majorVersion == 8)
        evidence.resolve("jvm.tsv").writeText("reference-gradle\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nmetadata-major\t8\ntools\t${java8.absolutePath}\n")
        val client = downloadFullMinecraftClient(privateCache.toPath(), game, false).toFile()
        val serverDownload = checkNotNull(downloadMinecraftFile(privateCache.toPath(), game, MinecraftDownloadVariant.Server, false)).toFile()
        val server = checkNotNull(getServerExtractionState(privateCache.toPath(), game, false)).result.toFile()
        recordFile("server-extracted-legacy-libraries-removed", server)
        for ((role, f) in listOf("client" to client, "server" to serverDownload)) {
            check(digest(f, "SHA-1") == game.downloads.getValue(role).sha1)
            recordFile(role, f)
        }
        val argsFile = evidence.resolve("argv.tsv")
        fun cli(name: String, tool: File, argv: List<String>, output: File, java: File = java8, cp: List<File> = listOf(tool), explicitMain: String? = null) {
            val main = explicitMain ?: JarFile(tool).use { it.manifest.mainAttributes.getValue("Main-Class") }
            argsFile.appendText("$name\t${java.absolutePath}\t${(listOf("-cp", cp.joinToString(File.pathSeparator), main) + argv).joinToString("\t")}\n")
            val exit = evidence.resolve("$name-stdout.log").outputStream().use { stdout ->
                evidence.resolve("$name-stderr.log").outputStream().use { stderr ->
                    referenceServices.exec.javaexec {
                        executable(java.absolutePath); classpath(cp); mainClass.set(main); args(argv)
                        standardOutput = stdout; errorOutput = stderr; isIgnoreExitValue = true
                    }.exitValue
                }
            }
            evidence.resolve("exits.tsv").appendText("$name\t$exit\n")
            check(exit == 0 && output.isFile && output.length() > 0) { "$name failed: exit=$exit; see $evidence" }
            recordFile("stage:$name", output)
            evidence.resolve("$name-entries.txt").writeText(entries(output).joinToString("\n"))
        }
        fun tool(notation: String): File {
            val parts = notation.substringBefore('@').split(':')
            return tools.single { it.name == "${parts[1]}-${parts[2]}${if (parts.size > 3) "-${parts[3]}" else ""}.jar" }
        }
        val data = config.data.filterValues { it != null && !it.endsWith('/') }.mapValues { extract(mcpFiles.singleFile, it.value!!) }
        val stages = outputDirectory.resolve("stages").apply { mkdirs() }
        fun stage(name: String) = stages.resolve("$name.jar")
        val clean = stage("merge-clean")
        val mergedArgs = mapOf("client" to client.path, "server" to server.path, "version" to targetVersion, "output" to clean.path)
        fun arguments(raw: List<String>, values: Map<String, String>) = raw.map { arg ->
            if (arg.startsWith('{') && arg.endsWith('}')) values.getValue(arg.substring(1, arg.length - 1)) else arg
        }
        val merge = config.functions.getValue("merge")
        cli("merge-clean", tool(merge.version!!), arguments(merge.args, mergedArgs), clean)
        val patches = extract(userdevFiles.singleFile, ud.binpatches)
        val patched = stage("patch-obf")
        cli("patch-obf", tool(ud.binpatcher.version!!), arguments(ud.binpatcher.args,
            mapOf("clean" to clean.path, "output" to patched.path, "patch" to patches.path)), patched)
        for ((branch, input) in listOf("clean" to clean, "patched" to patched)) {
            var previous = input
            for (name in listOf("rename", "mcinject")) {
                val lib = config.functions.getValue(name)
                val out = stage("$branch-$name")
                val values = data.mapValues { it.value.path } + mapOf("input" to previous.path, "output" to out.path, "log" to evidence.resolve("$branch-$name-tool.log").path)
                cli("$branch-$name", tool(lib.version!!), arguments(lib.args, values), out)
                previous = out
            }
            val ats = ud.ats.map { extract(userdevFiles.singleFile, it) }
            val pluginCp = providers.gradleProperty("fixtureClasspath").get().split(File.pathSeparator).map(::File)
            val atTool = pluginCp.single { it.name == "at-cli-13.0.3.jar" }
            val out = if (branch == "patched") referenceOutput else outputDirectory.resolve("reference-clean-at.jar")
            val java17 = toolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(17)) }.get().executablePath.asFile
            cli("$branch-at", atTool, listOf("--inJar", previous.path, "--outJar", out.path) + ats.flatMap { listOf("--atFile", it.path) }, out, java17, pluginCp, "net.neoforged.accesstransformer.cli.TransformerProcessor")
        }
        recordFile("binpatcher-source", basicReferenceSources.singleFile)
        recordFile("binarypatcher", tool(ud.binpatcher.version!!))
        evidence.resolve("reference-output.txt").writeText(referenceOutput.absolutePath)
    }
}
val recordBasicNotch = tasks.register("recordBasicNotch") {
    inputs.files(patchedBasicNotch.flatMap { it.output })
    doLast {
        val out = patchedBasicNotch.flatMap { it.output }.get().asFile
        recordFile("production-final", out)
        evidence.resolve("production-output.txt").writeText(out.absolutePath)
        evidence.resolve("production-entries.txt").writeText(entries(out).joinToString("\n"))
    }
}
tasks.register("describeBasicNotch") {
    doLast {
        evidence.resolve("files.tsv").writeText("role\tpath\tsize\tsha256\n")
        (listOf(userdevFiles, mcpFiles, universalFiles, minecraftLibraries, basicTools) +
            if (gradle.taskGraph.hasTask(":referenceBasicNotch")) listOf(basicReferenceSources) else emptyList()).forEach { c ->
            c.resolvedConfiguration.resolvedArtifacts.sortedBy { it.file.name }.forEach {
                recordFile("${c.name}:${it.moduleVersion.id}:${it.classifier ?: ""}", it.file)
            }
        }
        for ((label, archive) in listOf("userdev" to userdevFiles.singleFile, "mcp" to mcpFiles.singleFile)) {
            val out = evidence.resolve("$label-config.json")
            ZipFile(archive).use { z -> out.writeBytes(z.getInputStream(z.getEntry("config.json")).use { it.readBytes() }) }
            recordFile("$label-config", out)
        }
        val game = metadata.get()
        for (name in listOf("version-manifest.json", "version-metadata/$targetVersion.json")) recordFile("metadata:$name", privateCache.resolve(name))
        evidence.resolve("downloads.tsv").writeText(game.downloads.map { (name, d) -> "$name\t${d.url}\t${d.sha1}\t${d.size}" }.joinToString("\n"))
        evidence.resolve("isolation.tsv").writeText("project\t$projectDir\ngradleHome\t${gradle.gradleUserHomeDir}\ncache\t$privateCache\noutput\t$outputDirectory\n")
        evidence.resolve("gradle-jvm.tsv").writeText("${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nGradle\t${gradle.gradleVersion}\t${gradle.gradleHomeDir}\nmanifest\t${net.msrandom.minecraftcodev.core.VERSION_MANIFEST_URL}\n")
        gradle.taskGraph.allTasks.forEach { t ->
            evidence.resolve("task-graph.tsv").appendText("${t.path}\t${t.taskDependencies.getDependencies(t).map { it.path }.sorted()}\n")
        }
    }
}
patchedBasicNotch.configure { mustRunAfter("describeBasicNotch"); doFirst {
    val game = metadata.get()
    evidence.resolve("tool-jvm.tsv").writeText("metadata\t${game.javaVersion.majorVersion}\nexecutable\t${game.javaVersion.executable(toolchains).get().asFile}\nAT-in-process\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\n")
} }
referenceBasicNotch.configure { mustRunAfter("describeBasicNotch") }

// Independent non-notch sample: fixed release selects rename -> patch -> mcinject.
val forge1165Version = "1.16.5-36.2.39"
val forge1165Userdev = configurations.create("forge1165Userdev") { isTransitive = false }
dependencies.add(forge1165Userdev.name, "net.minecraftforge:forge:$forge1165Version:userdev")
val forge1165Ud = providers.provider {
    UserdevConfig.fromFile(forge1165Userdev.singleFile).fold({ throw (it ?: GradleException("Missing 1.16.5 userdev")) }, { it }).also {
        check(!it.notchObf && it.mcp == "de.oceanlabs.mcp:mcp_config:1.16.5-20210115.111550@zip")
        check(it.binpatcher.version == "net.minecraftforge:binarypatcher:1.0.12:fatjar")
        check(it.modules.isEmpty()) // This published config omits modules; no module constraints apply.
    }
}
val forge1165Metadata = providers.provider { getVersionList(privateCache.toPath(), isOffline = gradle.startParameter.isOffline).version("1.16.5") }
val forge1165Mcp = configurations.create("forge1165Mcp") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(forge1165Ud.get().mcp)) }
}
val forge1165Mc = providers.provider {
    McpConfigFile.configEntry(forge1165Mcp.singleFile).fold({ throw (it ?: GradleException("Missing 1.16.5 MCP")) }, { it }).also {
        check(it.version == "1.16.5" && it.steps.joined.any { step -> step["type"] == "mcinject" })
        for ((name, version) in mapOf("merge" to "net.minecraftforge:mergetool:1.1.1:fatjar", "rename" to "net.md-5:SpecialSource:1.8.3:shaded", "mcinject" to "de.oceanlabs.mcp:mcinjector:3.8.0:fatjar")) check(it.functions.getValue(name).version == version)
    }
}
val forge1165Tools = configurations.create("forge1165ReferenceTools") {
    isTransitive = false
    defaultDependencies {
        listOf("merge", "rename", "mcinject").map { forge1165Mc.get().functions.getValue(it) }.plus(forge1165Ud.get().binpatcher).forEach { library ->
            (listOfNotNull(library.version) + library.classpath).forEach { add(project.dependencies.create(it)) }
        }
    }
}
val forge1165Sources = configurations.create("forge1165ReferenceSources") { isTransitive = false }
dependencies.add(forge1165Sources.name, "net.minecraftforge:binarypatcher:1.0.12:sources")
val forge1165Universal = configurations.create("forge1165Universal") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(forge1165Ud.get().universal)) }
}
val forge1165Libraries = configurations.create("forge1165Libraries") {
    defaultDependencies {
        (getAllDependencies(forge1165Metadata.get()) + forge1165Ud.get().libraries + forge1165Ud.get().modules).forEach { add(project.dependencies.create(it)) }
    }
}
val patchedForge1165Mcinject = tasks.register<ResolvePatchedMinecraft>("patchedForge1165Mcinject") {
    minecraftVersion.set("1.16.5"); neoforge.set(false)
    patches.from(forge1165Userdev, forge1165Mcp)
    universal.from(forge1165Universal); libraries.from(forge1165Libraries)
    output.set(outputDirectory.resolve("minecraft-1.16.5-patched.jar"))
}
val recordForge1165Mcinject = tasks.register("recordForge1165Mcinject") {
    inputs.files(patchedForge1165Mcinject.flatMap { it.output })
    doLast {
        val out = patchedForge1165Mcinject.flatMap { it.output }.get().asFile
        recordFile("production-final", out)
        evidence.resolve("production-output.txt").writeText(out.absolutePath)
        evidence.resolve("production-entries.txt").writeText(entries(out).joinToString("\n"))
    }
}
val referenceForge1165Mcinject = tasks.register("referenceForge1165Mcinject") {
    doLast {
        val game = forge1165Metadata.get(); val mc = forge1165Mc.get(); val ud = forge1165Ud.get()
        check(game.javaVersion.majorVersion == 8)
        val java8 = game.javaVersion.executable(toolchains).get().asFile
        evidence.resolve("jvm.tsv").writeText("reference-gradle\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nmetadata-major\t8\ntools\t$java8\n")
        val client = downloadFullMinecraftClient(privateCache.toPath(), game, false).toFile()
        val serverDownload = checkNotNull(downloadMinecraftFile(privateCache.toPath(), game, MinecraftDownloadVariant.Server, false)).toFile()
        val server = checkNotNull(getServerExtractionState(privateCache.toPath(), game, false)).result.toFile()
        recordFile("server-extracted-legacy-libraries-removed", server)
        for ((role, f) in listOf("client" to client, "server" to serverDownload)) {
            check(digest(f, "SHA-1") == game.downloads.getValue(role).sha1); recordFile(role, f)
        }
        val tools = forge1165Tools.resolve()
        fun tool(notation: String): File {
            val parts = notation.substringBefore('@').split(':')
            return tools.single { it.name == "${parts[1]}-${parts[2]}${if (parts.size > 3) "-${parts[3]}" else ""}.jar" }
        }
        fun cli(name: String, jar: File, argv: List<String>, output: File, java: File = java8, cp: List<File> = listOf(jar), main: String? = null) {
            val mainName = main ?: JarFile(jar).use { it.manifest.mainAttributes.getValue("Main-Class") }
            evidence.resolve("argv.tsv").appendText("$name\t${java.absolutePath}\t${(listOf("-cp", cp.joinToString(File.pathSeparator), mainName) + argv).joinToString("\t")}\n")
            val exit = evidence.resolve("$name-stdout.log").outputStream().use { stdout -> evidence.resolve("$name-stderr.log").outputStream().use { stderr ->
                referenceServices.exec.javaexec {
                    executable(java.absolutePath); classpath(cp); mainClass.set(mainName); args(argv); jvmArgs("-Djava.io.tmpdir=${System.getProperty("java.io.tmpdir")}")
                    standardOutput = stdout; errorOutput = stderr; isIgnoreExitValue = true
                }.exitValue
            } }
            evidence.resolve("exits.tsv").appendText("$name\t$exit\n")
            check(exit == 0 && output.isFile && output.length() > 0) { "$name failed: exit=$exit; see $evidence" }
            recordFile("stage:$name", output); evidence.resolve("$name-entries.txt").writeText(entries(output).joinToString("\n"))
        }
        val data = mc.data.filterValues { it != null && !it.endsWith('/') }.mapValues { extract(forge1165Mcp.singleFile, it.value!!) }
        val patch = extract(forge1165Userdev.singleFile, ud.binpatches)
        val ats = ud.ats.map { extract(forge1165Userdev.singleFile, it) }
        val stages = outputDirectory.resolve("stages").apply { mkdirs() }
        fun stage(name: String) = stages.resolve("$name.jar")
        fun arguments(raw: List<String>, values: Map<String, String>) = raw.map { arg ->
            if (arg.startsWith('{') && arg.endsWith('}')) values.getValue(arg.substring(1, arg.length - 1)) else arg
        }
        val clean = stage("merge-clean"); val merge = mc.functions.getValue("merge")
        cli("merge-clean", tool(merge.version!!), arguments(merge.args, mapOf("client" to client.path, "server" to server.path, "version" to "1.16.5", "output" to clean.path)), clean)
        val renamed = stage("clean-rename"); val rename = mc.functions.getValue("rename")
        cli("clean-rename", tool(rename.version!!), arguments(rename.args, data.mapValues { it.value.path } + mapOf("input" to clean.path, "output" to renamed.path)), renamed)
        // Published sparse output proves patch membership; source-documented flags independently retain unpatched content/resources.
        val sparse = stage("patch-srg"); val complete = stage("patch-complete-srg")
        for ((name, out) in listOf("patch-srg" to sparse, "patch-complete-srg" to complete)) {
            cli(name, tool(ud.binpatcher.version!!), arguments(ud.binpatcher.args, mapOf("clean" to renamed.path, "output" to out.path, "patch" to patch.path)) + if (out == complete) listOf("--unpatched", "--data") else emptyList(), out)
        }
        for ((branch, input) in listOf("clean" to renamed, "patched" to complete)) {
            val lib = mc.functions.getValue("mcinject"); val out = stage("$branch-mcinject")
            cli("$branch-mcinject", tool(lib.version!!), arguments(lib.args, data.mapValues { it.value.path } + mapOf("input" to input.path, "output" to out.path, "log" to evidence.resolve("$branch-mcinject-tool.log").path)), out)
            val pluginCp = providers.gradleProperty("fixtureClasspath").get().split(File.pathSeparator).map(::File)
            val java17 = toolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(17)) }.get().executablePath.asFile
            val final = outputDirectory.resolve("reference-$branch-at.jar")
            cli("$branch-at", pluginCp.single { it.name == "at-cli-13.0.3.jar" }, listOf("--inJar", out.path, "--outJar", final.path) + ats.flatMap { listOf("--atFile", it.path) }, final, java17, pluginCp, "net.neoforged.accesstransformer.cli.TransformerProcessor")
            evidence.resolve("jvm.tsv").appendText("$branch-AT13.0.3\t$java17\n")
        }
        recordFile("binpatcher-source", forge1165Sources.singleFile)
        evidence.resolve("stages.tsv").writeText("sample\tforge1165Mcinject\nplacement\trename\npatchInputNamespace\tSRG\npostPatchRenameCount\t0\n")
    }
}
tasks.register("describeForge1165Mcinject") {
    doLast {
        evidence.resolve("files.tsv").writeText("role\tpath\tsize\tsha256\n")
        listOf(forge1165Userdev, forge1165Mcp, forge1165Universal, forge1165Libraries, forge1165Tools, forge1165Sources).forEach { c ->
            c.resolvedConfiguration.resolvedArtifacts.sortedBy { it.file.name }.forEach { recordFile("${c.name}:${it.moduleVersion.id}:${it.classifier ?: ""}", it.file) }
        }
        for ((label, archive) in listOf("userdev" to forge1165Userdev.singleFile, "mcp" to forge1165Mcp.singleFile)) {
            val out = evidence.resolve("$label-config.json"); ZipFile(archive).use { z -> out.writeBytes(z.getInputStream(z.getEntry("config.json")).use { it.readBytes() }) }; recordFile("$label-config", out)
        }
        val game = forge1165Metadata.get()
        for (name in listOf("version-manifest.json", "version-metadata/1.16.5.json")) recordFile("metadata:$name", privateCache.resolve(name))
        evidence.resolve("downloads.tsv").writeText(game.downloads.map { (name, d) -> "$name\t${d.url}\t${d.sha1}\t${d.size}" }.joinToString("\n"))
        evidence.resolve("isolation.tsv").writeText("project\t$projectDir\ngradleHome\t${gradle.gradleUserHomeDir}\ncache\t$privateCache\noutput\t$outputDirectory\n")
        evidence.resolve("gradle-jvm.tsv").writeText("${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nGradle\t${gradle.gradleVersion}\t${gradle.gradleHomeDir}\nmanifest\t${net.msrandom.minecraftcodev.core.VERSION_MANIFEST_URL}\n")
        evidence.resolve("temporary-paths.tsv").writeText("java.io.tmpdir\t${System.getProperty("java.io.tmpdir")}\nTMP\t${System.getenv("TMP")}\nTEMP\t${System.getenv("TEMP")}\nprojectCache\t${gradle.startParameter.projectCacheDir ?: projectDir.resolve(".gradle")}\n")
        evidence.resolve("branch.tsv").writeText("notchObf\t${forge1165Ud.get().notchObf}\nplacement\trename\nmodules\t${forge1165Ud.get().modules}\nuniversalFilters\t${forge1165Ud.get().universalFilters}\nuserdevLibraries\t${forge1165Ud.get().libraries.joinToString(";")}\n")
        gradle.taskGraph.allTasks.forEach { t -> evidence.resolve("task-graph.tsv").appendText("${t.path}\t${t.taskDependencies.getDependencies(t).map { it.path }.sorted()}\n") }
    }
}
patchedForge1165Mcinject.configure { mustRunAfter("describeForge1165Mcinject"); doFirst {
    val game = forge1165Metadata.get()
    evidence.resolve("tool-jvm.tsv").writeText("metadata\t${game.javaVersion.majorVersion}\nexecutable\t${game.javaVersion.executable(toolchains).get().asFile}\nAT-in-process\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\n")
} }
referenceForge1165Mcinject.configure { mustRunAfter("describeForge1165Mcinject") }

// Private fixed NeoForm sample; no other sample is resolved when this provider is selected.
val neo121Userdev = configurations.create("neo121Userdev") { isTransitive = false }
dependencies.add(neo121Userdev.name, "net.neoforged:neoforge:21.0.76-beta:userdev")
val neo121Ud = providers.provider {
    check(digest(neo121Userdev.singleFile) == "68a98a6a474e30b328e512a7c71715498e98842797b75bd516e97325f2fe64f0")
    UserdevConfig.fromFile(neo121Userdev.singleFile).fold({ throw (it ?: GradleException("Missing Neo userdev")) }, { it }).also {
        check(!it.notchObf && it.mcp == "net.neoforged:neoform:1.21-20240613.152323@zip")
        check(it.binpatcher.version == "net.minecraftforge:binarypatcher:1.1.1:fatjar" && it.inject == null)
    }
}
val neo121Metadata = providers.provider { getVersionList(privateCache.toPath(), isOffline = gradle.startParameter.isOffline).version("1.21") }
val neo121Mcp = configurations.create("neo121Mcp") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(neo121Ud.get().mcp)) }
}
val neo121Mc = providers.provider {
    check(digest(neo121Mcp.singleFile) == "33bbf6d5dc922c081521b745d73f262a5738f7c6ff7c1e98b4ceef9068398857")
    McpConfigFile.configEntry(neo121Mcp.singleFile).fold({ throw (it ?: GradleException("Missing NeoForm")) }, { it }).also {
        check(it.version == "1.21" && it.official && it.steps.joined.none { step -> step["type"] == "mcinject" })
        for ((name, coordinate) in mapOf("merge" to "net.neoforged:mergetool:2.0.3:fatjar", "rename" to "net.neoforged:AutoRenamingTool:2.0.3:all", "mergeMappings" to "net.neoforged.installertools:installertools:2.1.2:fatjar")) check(it.functions.getValue(name).version == coordinate)
    }
}
val neo121Tools = configurations.create("neo121ReferenceTools") {
    isTransitive = false
    defaultDependencies {
        listOf("bundleExtractJar", "mergeMappings", "merge", "rename").map { neo121Mc.get().functions.getValue(it) }.plus(neo121Ud.get().binpatcher).forEach { library ->
            (listOfNotNull(library.version) + library.classpath).forEach { add(project.dependencies.create(it)) }
        }
    }
}
val neo121Sources = configurations.create("neo121ReferenceSources") { isTransitive = false }
dependencies.add(neo121Sources.name, "net.minecraftforge:binarypatcher:1.1.1:sources")
val neo121Universal = configurations.create("neo121Universal") {
    isTransitive = false
    defaultDependencies { add(project.dependencies.create(neo121Ud.get().universal)) }
}
val neo121Libraries = configurations.create("neo121Libraries") {
    defaultDependencies {
        (getAllDependencies(neo121Metadata.get()) + neo121Ud.get().libraries + neo121Ud.get().modules).forEach { add(project.dependencies.create(it)) }
    }
}
val neoPreparedRows = neoPreparedRoot?.let { root ->
    Files.readAllLines(root.resolve("prepare/evidence/files.tsv")).drop(1).map { it.split('\t') }.also { rows ->
        check(rows.all { it.size == 4 }) { "Malformed prepared Neo files.tsv" }
    }
}
fun preparedNeoFiles(role: String): List<File> = checkNotNull(neoPreparedRows).filter { it[0].startsWith("$role:") }.map { row ->
    file(row[1]).also { input ->
        check(input.isFile && input.length() == row[2].toLong() && digest(input) == row[3]) { "Prepared Neo input changed: ${row[0]}" }
    }
}
val patchedNeo121NoMcinject = tasks.register<ResolvePatchedMinecraft>("patchedNeo121NoMcinject") {
    minecraftVersion.set("1.21"); neoforge.set(true)
    if (neoPreparedRoot == null) {
        patches.from(neo121Userdev, neo121Mcp)
        universal.from(neo121Universal); libraries.from(neo121Libraries)
    } else {
        patches.from(preparedNeoFiles("neo121Userdev").single(), preparedNeoFiles("neo121Mcp").single())
        universal.from(preparedNeoFiles("neo121Universal").single())
        libraries.from(preparedNeoFiles("neo121Libraries").also { check(it.isNotEmpty()) })
    }
    output.set(outputDirectory.resolve("minecraft-1.21-patched.jar"))
}
val recordNeo121NoMcinject = tasks.register("recordNeo121NoMcinject") {
    inputs.files(patchedNeo121NoMcinject.flatMap { it.output })
    doLast {
        val out = patchedNeo121NoMcinject.flatMap { it.output }.get().asFile
        recordFile("production-final", out)
        evidence.resolve("production-output.txt").writeText(out.absolutePath)
        evidence.resolve("production-entries.txt").writeText(entries(out).joinToString("\n"))
    }
}
val referenceNeo121NoMcinject = tasks.register("referenceNeo121NoMcinject") {
    doLast {
        val game = neo121Metadata.get(); val mc = neo121Mc.get(); val ud = neo121Ud.get()
        check(game.javaVersion.majorVersion == 21)
        val java21 = game.javaVersion.executable(toolchains).get().asFile
        evidence.resolve("jvm.tsv").writeText("reference-gradle\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nmetadata-major\t21\ntools\t$java21\n")
        val versionExit = evidence.resolve("java21-version.log").outputStream().use { log ->
            referenceServices.exec.exec { commandLine(java21.absolutePath, "-version"); standardOutput = log; errorOutput = log; isIgnoreExitValue = true }.exitValue
        }
        check(versionExit == 0)
        evidence.resolve("exits.tsv").appendText("java21-version\t$versionExit\n")
        val client = downloadFullMinecraftClient(privateCache.toPath(), game, false).toFile()
        val bundle = checkNotNull(downloadMinecraftFile(privateCache.toPath(), game, MinecraftDownloadVariant.Server, false)).toFile()
        val mappings = checkNotNull(downloadMinecraftFile(privateCache.toPath(), game, MinecraftDownloadVariant.ClientMappings, false)).toFile()
        for ((role, f) in listOf("client" to client, "server" to bundle, "client_mappings" to mappings)) {
            check(digest(f, "SHA-1") == game.downloads.getValue(role).sha1); recordFile(role, f)
        }
        val tools = neo121Tools.resolve()
        fun tool(notation: String): File {
            val parts = notation.substringBefore('@').split(':')
            return tools.single { it.name == "${parts[1]}-${parts[2]}${if (parts.size > 3) "-${parts[3]}" else ""}.jar" }
        }
        fun cli(name: String, jar: File, argv: List<String>, output: File, cp: List<File> = listOf(jar), main: String? = null, archive: Boolean = true) {
            val mainName = main ?: JarFile(jar).use { it.manifest.mainAttributes.getValue("Main-Class") }
            evidence.resolve("argv.tsv").appendText("$name\t${java21.absolutePath}\t${(listOf("-cp", cp.joinToString(File.pathSeparator), mainName) + argv).joinToString("\t")}\n")
            val exit = evidence.resolve("$name-stdout.log").outputStream().use { stdout -> evidence.resolve("$name-stderr.log").outputStream().use { stderr ->
                referenceServices.exec.javaexec {
                    executable(java21.absolutePath); classpath(cp); mainClass.set(mainName); args(argv); jvmArgs("-Djava.io.tmpdir=${System.getProperty("java.io.tmpdir")}")
                    standardOutput = stdout; errorOutput = stderr; isIgnoreExitValue = true
                }.exitValue
            } }
            evidence.resolve("exits.tsv").appendText("$name\t$exit\n")
            check(exit == 0 && output.isFile && output.length() > 0) { "$name failed: exit=$exit; see $evidence" }
            recordFile("stage:$name", output)
            if (archive) evidence.resolve("$name-entries.txt").writeText(entries(output).joinToString("\n"))
        }
        val data = mc.data.filterValues { it != null && !it.endsWith('/') }.mapValues { extract(neo121Mcp.singleFile, it.value!!) }
        val patch = extract(neo121Userdev.singleFile, ud.binpatches)
        val ats = ZipFile(neo121Userdev.singleFile).use { z -> z.entries().asSequence().filter { entry -> !entry.isDirectory && ud.ats.any { prefix -> entry.name == prefix || entry.name.startsWith(prefix) } }.map { extract(neo121Userdev.singleFile, it.name) }.toList() }
        check(ats.isNotEmpty())
        val stages = outputDirectory.resolve("stages").apply { mkdirs() }
        fun stage(name: String) = stages.resolve("$name.jar")
        fun arguments(raw: List<String>, values: Map<String, String>) = raw.map { arg ->
            if (arg.startsWith('{') && arg.endsWith('}')) values.getValue(arg.substring(1, arg.length - 1)) else arg
        }
        val extracted = stage("extracted-server"); val extractor = mc.functions.getValue("bundleExtractJar")
        cli("extracted-server", tool(extractor.version!!), arguments(extractor.args, mapOf("input" to bundle.path, "output" to extracted.path)), extracted)
        val server = checkNotNull(getServerExtractionState(privateCache.toPath(), game, false)).result.toFile()
        recordFile("production-server-extraction", server)
        check(entries(extracted).filter { it.endsWith(".class") }.toSet() == entries(server).filter { it.endsWith(".class") }.toSet())
        val mergedMappings = stages.resolve("merged-mappings.tsrg"); val mergeMappings = mc.functions.getValue("mergeMappings")
        cli("merge-mappings", tool(mergeMappings.version!!), arguments(mergeMappings.args, mapOf("mappings" to data.getValue("mappings").path, "official" to mappings.path, "output" to mergedMappings.path)), mergedMappings, archive = false)
        val libraries = evidence.resolve("libraries.txt")
        libraries.writeText(neo121Libraries.files.sortedBy { it.absolutePath }.flatMap { listOf("-e", it.absolutePath) }.joinToString("\n"))
        recordFile("rename-libraries", libraries)
        val clean = stage("merge-clean"); val merge = mc.functions.getValue("merge")
        cli("merge-clean", tool(merge.version!!), arguments(merge.args, mapOf("client" to client.path, "server" to extracted.path, "version" to "1.21", "output" to clean.path)), clean)
        val renamed = stage("clean-rename"); val rename = mc.functions.getValue("rename")
        cli("clean-rename", tool(rename.version!!), arguments(rename.args, mapOf("input" to clean.path, "output" to renamed.path, "mappings" to mergedMappings.path, "libraries" to libraries.path)), renamed)
        val sparse = stage("patch-official"); val complete = stage("patch-complete-official")
        for ((name, out) in listOf("patch-official" to sparse, "patch-complete-official" to complete)) {
            cli(name, tool(ud.binpatcher.version!!), arguments(ud.binpatcher.args, mapOf("clean" to renamed.path, "output" to out.path, "patch" to patch.path)) + if (out == complete) listOf("--unpatched", "--data") else emptyList(), out)
        }
        val pluginCp = providers.gradleProperty("fixtureClasspath").get().split(File.pathSeparator).map(::File)
        val overlaid = stage("patch-universal-official")
        complete.copyTo(overlaid)
        // Independent reference overlay uses the published archive/filter contract, not patch completion helpers.
        FileSystems.newFileSystem(overlaid.toPath()).use { fs ->
            ZipFile(neo121Universal.singleFile).use { z ->
                z.entries().asSequence().filter { !it.isDirectory && ud.universalFilters.all { filter -> Regex(filter).matches(it.name) } }.forEach { entry ->
                    val target = fs.getPath("/" + entry.name); target.parent?.let { Files.createDirectories(it) }
                    z.getInputStream(entry).use { Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING) }
                }
            }
        }
        recordFile("stage:patch-universal-official", overlaid)
        for ((branch, input) in listOf("clean" to renamed, "patched" to overlaid)) {
            val out = outputDirectory.resolve("reference-$branch-at.jar")
            cli("$branch-at", pluginCp.single { it.name == "at-cli-13.0.3.jar" }, listOf("--inJar", input.path, "--outJar", out.path) + ats.flatMap { listOf("--atFile", it.path) }, out, pluginCp, "net.neoforged.accesstransformer.cli.TransformerProcessor")
        }
        evidence.resolve("reference-output.txt").writeText(outputDirectory.resolve("reference-patched-at.jar").absolutePath)
        recordFile("binpatcher-source", neo121Sources.singleFile)
        evidence.resolve("stages.tsv").writeText("sample\tneo121NoMcinject\nplacement\tnull\npatchInputNamespace\tofficial\nmcinjectCount\t0\npostPatchRenameCount\t0\n")
    }
}
tasks.register("describeNeo121NoMcinject") {
    doLast {
        evidence.resolve("files.tsv").writeText("role\tpath\tsize\tsha256\n")
        listOf(neo121Userdev, neo121Mcp, neo121Universal, neo121Libraries, neo121Tools, neo121Sources).forEach { c ->
            c.resolvedConfiguration.resolvedArtifacts.sortedBy { it.file.name }.forEach { recordFile("${c.name}:${it.moduleVersion.id}:${it.classifier ?: ""}", it.file) }
        }
        for ((label, archive) in listOf("userdev" to neo121Userdev.singleFile, "mcp" to neo121Mcp.singleFile)) {
            val out = evidence.resolve("$label-config.json"); ZipFile(archive).use { z -> out.writeBytes(z.getInputStream(z.getEntry("config.json")).use { it.readBytes() }) }; recordFile("$label-config", out)
        }
        val game = neo121Metadata.get()
        check(game.javaVersion.majorVersion == 21)
        for (name in listOf("version-manifest.json", "version-metadata/1.21.json")) recordFile("metadata:$name", privateCache.resolve(name))
        evidence.resolve("downloads.tsv").writeText(game.downloads.map { (name, d) -> "$name\t${d.url}\t${d.sha1}\t${d.size}" }.joinToString("\n"))
        evidence.resolve("isolation.tsv").writeText("project\t$projectDir\ngradleHome\t${gradle.gradleUserHomeDir}\ncache\t$privateCache\noutput\t$outputDirectory\n")
        evidence.resolve("gradle-jvm.tsv").writeText("${System.getProperty("java.home")}\t${System.getProperty("java.version")}\nGradle\t${gradle.gradleVersion}\t${gradle.gradleHomeDir}\nmanifest\t${net.msrandom.minecraftcodev.core.VERSION_MANIFEST_URL}\n")
        evidence.resolve("temporary-paths.tsv").writeText("java.io.tmpdir\t${System.getProperty("java.io.tmpdir")}\nTMP\t${System.getenv("TMP")}\nTEMP\t${System.getenv("TEMP")}\nprojectCache\t${gradle.startParameter.projectCacheDir ?: projectDir.resolve(".gradle")}\n")
        evidence.resolve("branch.tsv").writeText("notchObf\t${neo121Ud.get().notchObf}\nplacement\tnull\nofficial\t${neo121Mc.get().official}\nmodules\t${neo121Ud.get().modules.joinToString(";")}\nuniversalFilters\t${neo121Ud.get().universalFilters}\nuserdevLibraries\t${neo121Ud.get().libraries.joinToString(";")}\n")
        gradle.taskGraph.allTasks.forEach { t -> evidence.resolve("task-graph.tsv").appendText("${t.path}\t${t.taskDependencies.getDependencies(t).map { it.path }.sorted()}\n") }
    }
}
patchedNeo121NoMcinject.configure { mustRunAfter("describeNeo121NoMcinject"); doFirst {
    if (neoPreparedRoot == null) {
        val game = neo121Metadata.get()
        evidence.resolve("tool-jvm.tsv").writeText("metadata\t${game.javaVersion.majorVersion}\nexecutable\t${game.javaVersion.executable(toolchains).get().asFile}\nAT-in-process\t${System.getProperty("java.home")}\t${System.getProperty("java.version")}\n")
    } else {
        check(gradle.startParameter.isOffline && PATCH_OPERATION_VERSION == 10 && neoforge.get())
        check(gradle.taskGraph.allTasks.map { it.path }.toSet() == setOf(":patchedNeo121NoMcinject", ":recordNeo121NoMcinject"))
        val inputs = preparedNeoFiles("neo121Userdev") + preparedNeoFiles("neo121Mcp") +
            preparedNeoFiles("neo121Universal") + preparedNeoFiles("neo121Libraries")
        check((patches + universal + libraries).files == inputs.toSet()) { "Prepared Neo producer inputs differ" }
        val hashes = inputs.map { hashFile(it.toPath()) }.toSortedSet { a, b ->
            val left = a.asBytes(); val right = b.asBytes()
            var comparison = 0
            for ((x, y) in left.zip(right)) { comparison = x.compareTo(y); if (comparison != 0) break }
            if (comparison != 0) comparison else left.size.compareTo(right.size)
        }
        val hasher = Hashing.murmur3_32_fixed().newHasher()
        hashes.forEach { hasher.putBytes(it.asBytes()) }
        val key = hasher.hash().toString()
        val cache = neoPreparedRoot.resolve("prepare/cache").toRealPath()
        val out = output.get().asFile.toPath().toAbsolutePath().normalize()
        check(privateCache.toPath().toRealPath() == cache && cacheParameters.directory.get().asFile.toPath().toRealPath() == cache)
        check(key == "6d7a8c95" && out.fileName.toString() == "minecraft-1.21-patched.jar" && !Files.exists(out))
        val cached = cache.resolve("cached-operations/neoforge-patch-10/$key/${out.fileName}")
        check(Files.isRegularFile(cached) && digest(cached.toFile()) == "56e71c9547b7961a7da792aafe5075dfb1fd7687b3f4e8502a03f9f1cfcdd525") {
            "Original Neo operation cache is missing or changed; refusing a cold rebuild"
        }
        evidence.resolve("action-cache.tsv").writeText("operation\tneoforge-patch-10\nkey\t$key\nbasename\t${out.fileName}\ncache\t$cached\noutput\t$out\n")
        evidence.resolve("producer-inputs.tsv").writeText(inputs.joinToString("\n") { "${it.absolutePath}\t${digest(it)}" })
        evidence.resolve("task-graph.tsv").writeText(gradle.taskGraph.allTasks.joinToString("\n") { task ->
            "${task.path}\t${task.taskDependencies.getDependencies(task).map { it.path }.sorted()}"
        })
        println("PREPARED_NEO_ACTION neoforge-patch-10 $key $cached")
    }
} }
referenceNeo121NoMcinject.configure { mustRunAfter("describeNeo121NoMcinject") }