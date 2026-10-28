package net.msrandom.minecraftcodev.forge

import kotlinx.serialization.json.*
import com.google.common.hash.Hashing
import net.msrandom.minecraftcodev.core.resolve.MinecraftVersionMetadata
import net.msrandom.minecraftcodev.core.resolve.getAllDependencies
import net.msrandom.minecraftcodev.core.utils.hashFile
import net.msrandom.minecraftcodev.forge.task.PATCH_OPERATION_VERSION
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import java.util.jar.JarFile
import java.util.jar.Manifest
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.gradle.testkit.runner.UnexpectedBuildFailure
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.commons.ClassRemapper
import org.objectweb.asm.commons.Remapper
import java.io.File
import java.io.InputStream
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest
import java.util.jar.JarInputStream
import java.util.zip.Adler32
import java.util.zip.ZipFile

/** Private real-input preparation; only the selected sample is materialized. */
internal object ForgePatchNamespaceInputs {
    private val json = Json { prettyPrint = true }
    private fun sha(bytes: ByteArray) = MessageDigest.getInstance("SHA-256").digest(bytes)
        .joinToString("") { "%02x".format(it) }
    private fun write(path: Path, value: JsonElement) = Files.writeString(path, json.encodeToString(JsonElement.serializer(), value))
    private fun fileRows(path: Path) = Files.readAllLines(path).drop(1).map { it.split('\t') }
    private fun artifact(rows: List<List<String>>, token: String) = Path.of(rows.single { it[0].contains(token) }[1])
    private fun names(zip: ZipFile) = zip.entries().asSequence().filterNot { it.isDirectory }.map { it.name }.toSortedSet()
    private fun bytes(zip: ZipFile, name: String): ByteArray? = zip.getEntry(name)?.let { zip.getInputStream(it).use(InputStream::readBytes) }
    private fun semantic(bytes: ByteArray): String {
        val writer = ClassWriter(0)
        ClassReader(bytes).accept(writer, ClassReader.SKIP_DEBUG)
        return sha(writer.toByteArray())
    }
    private fun references(bytes: ByteArray): Set<String> {
        val refs = sortedSetOf<String>()
        val remapper = object : Remapper() {
            override fun map(internalName: String): String { refs.add(internalName); return internalName }
        }
        ClassReader(bytes).accept(ClassRemapper(ClassWriter(0), remapper), ClassReader.SKIP_DEBUG)
        return refs
    }
    private fun definition(bytes: ByteArray) = buildJsonObject {
        val reader = ClassReader(bytes)
        put("this_class", reader.className); put("super", reader.superName ?: "")
        put("interfaces", JsonArray(reader.interfaces.map(::JsonPrimitive)))
        put("sha256", sha(bytes)); put("semanticFingerprintWithoutDebug", semantic(bytes))
        put("references", JsonArray(references(bytes).map(::JsonPrimitive)))
    }

    fun prepareBasicNotch(): Path = prepare("basicNotch")

    fun prepareForge1165Mcinject(): Path = prepare("forge1165Mcinject")

    fun prepareNeo121NoMcinject(): Path = prepare("neo121NoMcinject")

    /** Q uses the recorded T inputs/reference read-only; only its native operation lock is shared. */
    fun verifyPreparedNeo121NoMcinject(preparedRoot: Path): Path {
        val sample = preparedRoot.toRealPath()
        val originalRoot = sample.parent
        check(sample.fileName.toString() == "neo121NoMcinject" && Files.isRegularFile(originalRoot.resolve("prepared.txt")))
        val q = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), "neo-verification-").toRealPath()
        val repository = Path.of("..").toRealPath()
        check(sample == repository.resolve("minecraft-codev-forge/build/forge-patch-neo-925395910390226218/neo121NoMcinject").toRealPath()) { "The original prepared/cache root must not be relocated" }
        check(listOf(repository.resolve("build"), repository.resolve("minecraft-codev-forge/build")).any { q.startsWith(it) && q != it })
        check(!q.startsWith(originalRoot) && !originalRoot.startsWith(q)) { "Q evidence must be separate from the original F" }
        val evidence = Files.createDirectory(q.resolve("neo-verification"))
        Files.writeString(evidence.resolve("calls.tsv"), "nested\t0\nprepare\t0\nreference\t0\n")
        try {
            fun shaFile(path: Path) = sha(Files.readAllBytes(path))
            fun objectAt(path: Path) = Json.parseToJsonElement(Files.readString(path)).jsonObject
            fun rowsAt(path: Path): List<List<String>> {
                check(Files.readAllLines(path).first() == "role\tpath\tsize\tsha256")
                return fileRows(path).also { rows ->
                    check(rows.isNotEmpty() && rows.all { it.size == 4 })
                    check(rows.groupBy { it[0] }.values.all { records -> records.distinct().size == 1 }) { "Conflicting records for the same role" }
                    rows.forEach { row ->
                        val path = Path.of(row[1])
                        check(Files.isRegularFile(path) && Files.size(path) == row[2].toLong() && shaFile(path) == row[3]) {
                            "Recorded input/stage changed: ${row[0]} at $path"
                        }
                    }
                }
            }
            val prep = sample.resolve("prepare"); val ref = sample.resolve("reference")
            val prepRows = rowsAt(prep.resolve("evidence/files.tsv"))
            val refRows = rowsAt(ref.resolve("evidence/files.tsv"))
            val roles = listOf("neo121Userdev:", "neo121Mcp:", "neo121Universal:", "neo121Libraries:", "neo121ReferenceTools:", "neo121ReferenceSources:")
            fun inputRows(rows: List<List<String>>) = rows.filter { row -> roles.any { row[0].startsWith(it) } }
            fun inputInventory(rows: List<List<String>>) = inputRows(rows).map { listOf(it[0]) + it.drop(2) }.groupingBy { it }.eachCount()
            check(inputInventory(prepRows) == inputInventory(refRows)) {
                "Prepare/reference resolved inputs differ"
            }
            val userdev = artifact(prepRows, "neo121Userdev:net.neoforged:neoforge:21.0.76-beta:userdev")
            val neoform = artifact(prepRows, "neo121Mcp:net.neoforged:neoform:1.21-20240613.152323:")
            val universal = artifact(prepRows, "neo121Universal:net.neoforged:neoforge:21.0.76-beta:universal")
            check(shaFile(userdev) == "68a98a6a474e30b328e512a7c71715498e98842797b75bd516e97325f2fe64f0")
            check(shaFile(neoform) == "33bbf6d5dc922c081521b745d73f262a5738f7c6ff7c1e98b4ceef9068398857")
            val ud = UserdevConfig.fromFile(userdev.toFile()).fold({ throw (it ?: error("Missing userdev")) }, { it })
            val mc = McpConfigFile.configEntry(neoform.toFile()).fold({ throw (it ?: error("Missing NeoForm")) }, { it })
            check(!ud.notchObf && ud.inject == null && ud.mcp == "net.neoforged:neoform:1.21-20240613.152323@zip")
            check(ud.binpatcher.version == "net.minecraftforge:binarypatcher:1.1.1:fatjar")
            check(mc.version == "1.21" && mc.official && mc.steps.joined.none { it["type"] == "mcinject" })
            val config = objectAt(prep.resolve("evidence/mcp-config.json"))
            check(config.getValue("spec").jsonPrimitive.int == 4 && config.getValue("java_target").jsonPrimitive.int == 21)
            for ((name, coordinate) in mapOf("merge" to "net.neoforged:mergetool:2.0.3:fatjar", "rename" to "net.neoforged:AutoRenamingTool:2.0.3:all", "mergeMappings" to "net.neoforged.installertools:installertools:2.1.2:fatjar")) {
                check(mc.functions.getValue(name).version == coordinate)
            }
            for ((phase, rows) in listOf(prep to prepRows, ref to refRows)) {
                for ((archive, role) in listOf(userdev to "userdev-config", neoform to "mcp-config")) {
                    ZipFile(archive.toFile()).use { zip -> check(checkNotNull(bytes(zip, "config.json")).contentEquals(Files.readAllBytes(artifact(rows, role)))) }
                }
                val branch = Files.readAllLines(phase.resolve("evidence/branch.tsv")).associate { it.substringBefore('\t') to it.substringAfter('\t') }
                check(branch["notchObf"] == "false" && branch["placement"] == "null" && branch["official"] == "true")
                check(branch["modules"] == ud.modules.joinToString(";") && branch["userdevLibraries"] == ud.libraries.joinToString(";"))
                check(branch["universalFilters"] == ud.universalFilters.toString())
            }
            val metadataPath = artifact(prepRows, "metadata:version-metadata/1.21.json")
            val metadata = Json { ignoreUnknownKeys = true }.decodeFromString(MinecraftVersionMetadata.serializer(), Files.readString(metadataPath))
            check(metadata.id == "1.21" && metadata.javaVersion.majorVersion == 21)
            fun moduleKey(notation: String): String {
                val parts = notation.substringBefore('@').split(':')
                return "${parts[0]}:${parts[1]}:${parts.getOrElse(3) { "" }}"
            }
            val libraryRows = prepRows.filter { it[0].startsWith("neo121Libraries:") }
            val resolvedModules = libraryRows.map { moduleKey(it[0].removePrefix("neo121Libraries:")) }.toSet()
            check(libraryRows.isNotEmpty() && (getAllDependencies(metadata) + ud.libraries + ud.modules).all { moduleKey(it) in resolvedModules }) {
                "The recorded complete libraries/modules do not supply the fixed configuration"
            }
            val inputs = (listOf(userdev, neoform, universal) + libraryRows.map { Path.of(it[1]) }).distinct()
            val oldArguments = Files.readAllLines(prep.resolve("arguments.txt"))
            fun argument(prefix: String) = oldArguments.single { it.startsWith(prefix) }.removePrefix(prefix)
            val javaHome = Path.of(argument("-Dorg.gradle.java.home=")).toRealPath()
            check(javaHome == Path.of(checkNotNull(System.getProperty("fixture.gradleJava"))).toRealPath())
            val installations = argument("-Dorg.gradle.java.installations.paths=")
            check(installations.split(',').all { Files.isRegularFile(Path.of(it).resolve("bin/java.exe")) })
            val gradleJvm = Files.readAllLines(prep.resolve("evidence/gradle-jvm.tsv"))
            val installationRow = gradleJvm.single { it.startsWith("Gradle\t") }.split('\t')
            check(installationRow[1] == "9.4.0" && gradleJvm.first().split('\t').let { Path.of(it[0]).toRealPath() == javaHome && it[1].startsWith("17.") })
            val gradleInstallation = Path.of(installationRow[2]).toRealPath()
            check(Files.isDirectory(gradleInstallation.resolve("lib")) && Files.isRegularFile(gradleInstallation.resolve("bin/gradle.bat")))
            val javaOutput = repository.resolve("minecraft-codev-forge/build/classes/java/main").toAbsolutePath().normalize()
            fun classpathOrigin(path: Path): Path {
                val declared = path.toAbsolutePath().normalize()
                if (declared == javaOutput && Files.notExists(declared, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
                    val javaSources = repository.resolve("minecraft-codev-forge/src/main/java")
                    if (!Files.notExists(javaSources, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
                        Files.walk(javaSources, java.nio.file.FileVisitOption.FOLLOW_LINKS).use { sources ->
                            check(sources.noneMatch { it.fileName.toString().endsWith(".java", ignoreCase = true) }) {
                                "Missing Java output is only allowed for the empty main Java source set"
                            }
                        }
                    }
                    return declared
                }
                return path.toRealPath()
            }
            val oldClasspath = argument("-PfixtureClasspath=").split(File.pathSeparator).map { classpathOrigin(Path.of(it)) }
            check(oldClasspath.size == 56) { "The original ordered classpath must retain all 56 entries" }
            val toolJvm = Files.readAllLines(prep.resolve("evidence/tool-jvm.tsv")).map { it.split('\t') }
            check(toolJvm.single { it[0] == "metadata" }[1] == "21")
            val recordedJava21 = toolJvm.single { it[0] == "executable" }[1]
            val java21 = Path.of(recordedJava21).toRealPath()
            check(Files.isRegularFile(java21))
            val referenceJvm = Files.readAllLines(ref.resolve("evidence/jvm.tsv")).map { it.split('\t') }
            check(referenceJvm.single { it[0] == "metadata-major" }[1] == "21" && Path.of(referenceJvm.single { it[0] == "tools" }[1]).toRealPath() == java21)
            check(Regex("(?:openjdk|java) version \\\"21[.\\\"]").containsMatchIn(Files.readString(ref.resolve("evidence/java21-version.log"))))
            val stages = Files.readAllLines(ref.resolve("evidence/stages.tsv")).associate { it.substringBefore('\t') to it.substringAfter('\t') }
            check(stages == mapOf("sample" to "neo121NoMcinject", "placement" to "null", "patchInputNamespace" to "official", "mcinjectCount" to "0", "postPatchRenameCount" to "0"))
            val exits = Files.readAllLines(ref.resolve("evidence/exits.tsv")).map { it.split('\t') }
            val expectedExits = setOf("java21-version", "extracted-server", "merge-mappings", "merge-clean", "clean-rename", "patch-official", "patch-complete-official", "clean-at", "patched-at")
            check(exits.size == expectedExits.size && exits.map { it[0] }.toSet() == expectedExits && exits.all { it[1] == "0" })
            val cliRows = Files.readAllLines(ref.resolve("evidence/argv.tsv")).map { it.split('\t') }
            check(cliRows.size == 8 && cliRows.map { it[0] }.toSet() == expectedExits - "java21-version")
            check(cliRows.all { Path.of(it[1]).toRealPath() == java21 && it[2] == "-cp" })
            fun stage(name: String) = artifact(refRows, "stage:$name").also { check(it == ref.resolve("output/stages/$name.jar") || name in setOf("merge-mappings", "clean-at", "patched-at")) }
            fun cli(name: String, coordinate: String, rawArgs: List<String>, values: Map<String, Path>, extra: List<String> = emptyList()) {
                val row = cliRows.single { it[0] == name }
                val tool = artifact(refRows, "neo121ReferenceTools:${coordinate.substringBefore('@')}")
                check(row[3].split(File.pathSeparator).map { Path.of(it).toRealPath() } == listOf(tool.toRealPath()))
                check(row[4] == JarFile(tool.toFile()).use { it.manifest.mainAttributes.getValue("Main-Class") })
                val expected = rawArgs.map { arg -> if (arg.startsWith('{') && arg.endsWith('}')) values.getValue(arg.substring(1, arg.length - 1)).toString() else arg } + extra
                check(row.drop(5) == expected) { "Independent reference argv differs at $name" }
            }
            val data = mc.data.filterValues { it != null && !it.endsWith('/') }.mapValues { artifact(refRows, "archive-entry:${it.value!!}") }
            val binpatch = artifact(refRows, "archive-entry:${ud.binpatches}")
            ZipFile(neoform.toFile()).use { zip -> data.forEach { (key, path) -> check(checkNotNull(bytes(zip, mc.data.getValue(key)!!)).contentEquals(Files.readAllBytes(path))) } }
            ZipFile(userdev.toFile()).use { zip -> check(checkNotNull(bytes(zip, ud.binpatches)).contentEquals(Files.readAllBytes(binpatch))) }
            val client = Path.of(refRows.single { it[0] == "client" }[1])
            val server = Path.of(refRows.single { it[0] == "server" }[1])
            val mappings = Path.of(refRows.single { it[0] == "client_mappings" }[1])
            for ((role, path) in listOf("client" to client, "server" to server, "client_mappings" to mappings)) {
                val download = metadata.downloads.getValue(role)
                check(Files.size(path) == download.size.toLong())
                check(MessageDigest.getInstance("SHA-1").digest(Files.readAllBytes(path)).joinToString("") { "%02x".format(it) } == download.sha1)
            }
            val extracted = stage("extracted-server"); val merged = artifact(refRows, "stage:merge-mappings")
            val clean = stage("clean-rename"); val sparse = stage("patch-official"); val complete = stage("patch-complete-official")
            val overlaid = stage("patch-universal-official")
            val expectedClean = stage("clean-at"); val expectedPatched = stage("patched-at")
            check(expectedClean == ref.resolve("output/reference-clean-at.jar") && expectedPatched == ref.resolve("output/reference-patched-at.jar"))
            check(Files.readString(ref.resolve("evidence/reference-output.txt")).trim() == expectedPatched.toString())
            cli("extracted-server", mc.functions.getValue("bundleExtractJar").version!!, mc.functions.getValue("bundleExtractJar").args, mapOf("input" to server, "output" to extracted))
            cli("merge-mappings", mc.functions.getValue("mergeMappings").version!!, mc.functions.getValue("mergeMappings").args, mapOf("mappings" to data.getValue("mappings"), "official" to mappings, "output" to merged))
            cli("merge-clean", mc.functions.getValue("merge").version!!, mc.functions.getValue("merge").args, mapOf("client" to client, "server" to extracted, "output" to stage("merge-clean"), "version" to Path.of("1.21")))
            val renameLibraries = artifact(refRows, "rename-libraries")
            val referenceLibraries = refRows.filter { it[0].startsWith("neo121Libraries:") }.map { Path.of(it[1]).toAbsolutePath().toString() }.distinct().sorted()
            check(Files.readAllLines(renameLibraries) == referenceLibraries.flatMap { listOf("-e", it) })
            cli("clean-rename", mc.functions.getValue("rename").version!!, mc.functions.getValue("rename").args, mapOf("input" to stage("merge-clean"), "output" to clean, "mappings" to merged, "libraries" to renameLibraries))
            for ((name, out) in listOf("patch-official" to sparse, "patch-complete-official" to complete)) {
                cli(name, ud.binpatcher.version!!, ud.binpatcher.args, mapOf("clean" to clean, "output" to out, "patch" to binpatch), if (out == complete) listOf("--unpatched", "--data") else emptyList())
            }
            val ats = ZipFile(userdev.toFile()).use { zip -> names(zip).filter { name -> ud.ats.any { name == it || name.startsWith(it) } }.map { name ->
                artifact(refRows, "archive-entry:$name").also { check(checkNotNull(bytes(zip, name)).contentEquals(Files.readAllBytes(it))) }
            } }
            check(ats.isNotEmpty())
            for ((branch, input, output) in listOf(Triple("clean", clean, expectedClean), Triple("patched", overlaid, expectedPatched))) {
                val row = cliRows.single { it[0] == "$branch-at" }
                val cp = row[3].split(File.pathSeparator).map { classpathOrigin(Path.of(it)) }
                check(cp == oldClasspath && Files.isRegularFile(cp.single { it.fileName.toString() == "at-cli-13.0.3.jar" }))
                check(row[4] == "net.neoforged.accesstransformer.cli.TransformerProcessor")
                check(row.drop(5) == listOf("--inJar", input.toString(), "--outJar", output.toString()) + ats.flatMap { listOf("--atFile", it.toString()) })
            }
            val patch = patches(artifact(refRows, "neo121ReferenceTools:net.minecraftforge:binarypatcher:"), binpatch)
            check(patch.isNotEmpty())
            val witnesses = objectAt(originalRoot.resolve("class-witnesses.json"))
            check(witnesses.getValue("patchInputNamespace").jsonPrimitive.content == "official")
            check(witnesses.getValue("mcinjectCount").jsonPrimitive.int == 0 && witnesses.getValue("postPatchRenameCount").jsonPrimitive.int == 0)
            val officialToObf = Files.readAllLines(mappings).filter { !it.startsWith(' ') && it.endsWith(':') && " -> " in it }
                .associate { line -> line.removeSuffix(":").split(" -> ").let { it[0].replace('.', '/') to it[1].replace('.', '/') } }
            val mergedClasses = Files.readAllLines(merged).filter { it.isNotBlank() && !it[0].isWhitespace() && !it.startsWith("tsrg2 ") }
                .associate { line -> line.split(' ').filter(String::isNotEmpty).let { it.first() to it.drop(1) } }
            check(officialToObf.isNotEmpty() && mergedClasses.isNotEmpty())
            val cache = prep.resolve("cache").toRealPath()
            val originalOutput = Path.of(Files.readString(prep.resolve("evidence/production-output.txt")).trim()).toRealPath()
            check(originalOutput == prep.resolve("output/minecraft-1.21-patched.jar").toRealPath())
            check(artifact(prepRows, "production-final").toRealPath() == originalOutput)
            val operation = "neoforge-patch-10"
            check(PATCH_OPERATION_VERSION == 10)
            val hashes = inputs.map(::hashFile).toSortedSet { a, b ->
                val left = a.asBytes(); val right = b.asBytes()
                var comparison = 0
                for ((x, y) in left.zip(right)) { comparison = x.compareTo(y); if (comparison != 0) break }
                if (comparison != 0) comparison else left.size.compareTo(right.size)
            }
            val hasher = Hashing.murmur3_32_fixed().newHasher()
            hashes.forEach { hasher.putBytes(it.asBytes()) }
            val key = hasher.hash().toString()
            check(key == "6d7a8c95")
            val cached = cache.resolve("cached-operations/$operation/$key/${originalOutput.fileName}")
            val originalSha = "56e71c9547b7961a7da792aafe5075dfb1fd7687b3f4e8502a03f9f1cfcdd525"
            check(Files.isRegularFile(cached) && shaFile(cached) == originalSha && shaFile(originalOutput) == originalSha)
            check(witnesses.getValue("finalOutput").jsonPrimitive.content == originalOutput.toString() && witnesses.getValue("finalSha256").jsonPrimitive.content == originalSha)
            val oldLog = Files.readString(prep.resolve("gradle.log"))
            check(oldLog.contains("Cache miss for $operation operation for [$originalOutput]") && !oldLog.contains("Cache hit for $operation") && oldLog.contains("BUILD SUCCESSFUL"))
            check(oldLog.contains(recordedJava21)) { "The recorded production cold tools did not use the recorded Java21" }
            check(Files.readAllLines(prep.resolve("tasks.tsv")).toSet() == setOf(":describeNeo121NoMcinject\tSUCCESS", ":patchedNeo121NoMcinject\tSUCCESS", ":recordNeo121NoMcinject\tSUCCESS"))
            check(Files.readAllLines(ref.resolve("tasks.tsv")).toSet() == setOf(":describeNeo121NoMcinject\tSUCCESS", ":referenceNeo121NoMcinject\tSUCCESS"))
            check(Files.readString(prep.resolve("evidence/task-graph.tsv")).contains(":recordNeo121NoMcinject\t[:patchedNeo121NoMcinject]"))
            val isolatedPaths = (listOf(sample, originalOutput, cached) + inputs + listOf(clean, sparse, complete, overlaid, expectedClean, expectedPatched))
            check(isolatedPaths.none { q.startsWith(it) || it.startsWith(q) })
            val oldPaths = (1..9).map { cache.resolve("cached-operations/neoforge-patch-$it/$key/${originalOutput.fileName}").toAbsolutePath().normalize() } +
                (1..10).map { cache.resolve("cached-operations/forge-patch-$it/$key/${originalOutput.fileName}").toAbsolutePath().normalize() }
            check(oldPaths.none { it == cached.toAbsolutePath().normalize() })

            // The old private transforms retain the original core JAR and the loaded Forge action.
            val transforms = prep.resolve("gradle-home/caches/9.4.0/transforms")
            val transformRoots = Files.list(transforms).use { it.filter { path -> Files.isDirectory(path) }.iterator().asSequence().toList() }
            val coreName = oldClasspath.single { it.fileName.toString().startsWith("minecraft-codev-core-") && it.fileName.toString().endsWith(".jar") }.fileName.toString()
            val originalCore = transformRoots.map { it.resolve("transformed/original/$coreName") }.single { Files.isRegularFile(it) }
            val actionEntry = "net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.class"
            val oldAction = transformRoots.map { it.resolve("transformed/instrumented/instrumented-main/$actionEntry") }.single { Files.isRegularFile(it) }
            fun classBytes(entry: String) = checkNotNull(javaClass.classLoader.getResourceAsStream(entry)) { "Missing loaded implementation $entry" }.use(InputStream::readBytes)
            fun actionFingerprint(content: ByteArray): String {
                val writer = ClassWriter(0)
                val metafactory = org.objectweb.asm.Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory",
                    "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false)
                val altMetafactory = org.objectweb.asm.Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "altMetafactory",
                    "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false)
                ClassReader(content).accept(object : ClassVisitor(Opcodes.ASM9) {
                    override fun visit(version: Int, access: Int, name: String, signature: String?, superName: String?, interfaces: Array<out String>?) {
                        writer.visit(version, access, name, signature, superName, interfaces)
                    }
                    override fun visitMethod(access: Int, name: String, descriptor: String, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
                        if (name != "resolve" || descriptor != "()V" || access and Opcodes.ACC_PUBLIC == 0) return null
                        return object : MethodVisitor(Opcodes.ASM9, writer.visitMethod(access, name, descriptor, signature, exceptions)) {
                            override fun visitInvokeDynamicInsn(name: String, descriptor: String, bootstrapMethodHandle: org.objectweb.asm.Handle, vararg bootstrapMethodArguments: Any) {
                                val standard = bootstrapMethodHandle == metafactory && bootstrapMethodArguments.size == 3
                                val instrumented = bootstrapMethodHandle == altMetafactory && bootstrapMethodArguments.size == 4 &&
                                    bootstrapMethodArguments[3] is Int && bootstrapMethodArguments[3] == 1
                                val lambdaArguments = (standard || instrumented) &&
                                    (bootstrapMethodArguments[0] as? org.objectweb.asm.Type)?.sort == org.objectweb.asm.Type.METHOD &&
                                    bootstrapMethodArguments[1] is org.objectweb.asm.Handle &&
                                    (bootstrapMethodArguments[2] as? org.objectweb.asm.Type)?.sort == org.objectweb.asm.Type.METHOD
                                if (lambdaArguments) {
                                    super.visitInvokeDynamicInsn(name, descriptor, metafactory, *bootstrapMethodArguments.copyOfRange(0, 3))
                                } else {
                                    super.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, *bootstrapMethodArguments)
                                }
                            }
                        }
                    }
                    override fun visitEnd() { writer.visitEnd() }
                }, ClassReader.SKIP_DEBUG)
                return sha(writer.toByteArray())
            }
            val loadedAction = classBytes(actionEntry)
            check(actionFingerprint(Files.readAllBytes(oldAction)) == actionFingerprint(loadedAction)) { "The loaded operation/action no longer matches the recorded T action" }
            val coreIdentities = ZipFile(originalCore.toFile()).use { zip -> listOf("CacheKt", "HashKt").map { name ->
                val entry = "net/msrandom/minecraftcodev/core/utils/$name.class"
                val old = checkNotNull(bytes(zip, entry)); val loaded = classBytes(entry)
                check(old.contentEquals(loaded)) { "The loaded core $name differs from the recorded T input" }
                buildJsonObject { put("entry", entry); put("oldSha256", sha(old)); put("loadedSha256", sha(loaded)); put("original", originalCore.toString()) }
            } }
            val sourceNames = listOf("minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt", "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt", "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/DistAttributePostProcessor.kt", "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt", "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt")
            val sourceIdentity = sourceNames.map { name -> buildJsonObject { put("path", name); put("sha256", shaFile(repository.resolve(name))) } }

            val runner = GradleRunner.create().withPluginClasspath()
            check(runner.pluginClasspath.map { classpathOrigin(it.toPath()) } == oldClasspath) { "Current plugin classpath origins differ from T" }
            fun verifyContent(output: Path, label: String): JsonObject {
                val archives = mutableListOf<ZipFile>()
                try {
                    listOf(clean, sparse, complete, overlaid, expectedClean, expectedPatched, universal, client, extracted, output).forEach { archives.add(ZipFile(it.toFile())) }
                    val c = archives[0]; val p = archives[1]; val full = archives[2]; val overlay = archives[3]; val cAt = archives[4]
                    val oracle = archives[5]; val uni = archives[6]; val rawClient = archives[7]; val rawServer = archives[8]; val actual = archives[9]
                    val cNames = names(c); val pNames = names(p); val allUniversal = names(uni)
                    val filteredUniversal = allUniversal.filter { name -> ud.universalFilters.all { Regex(it).matches(name) } }.toSet()
                    val expectedNames = names(oracle); val actualNames = names(actual)
                    check(actualNames == expectedNames) { "$label final entries differ: missing=${expectedNames - actualNames}; extra=${actualNames - expectedNames}" }
                    val deleted = patch.filter { it.length == 0 }.flatMap { listOf("${it.obf}.class", "${it.srg}.class") }.toSet()
                    val required = ((cNames - deleted) + pNames + filteredUniversal).filter { it.endsWith(".class") }.toSet()
                    check(required.all { it in expectedNames }) { "The independent complete reference omits required classes" }
                    officialToObf.filterKeys { "$it.class" in cNames }.forEach { (target, obf) -> check(target in mergedClasses.getValue(obf)) { "Merged mappings are not obf -> official for $target" } }
                    val classChecks = expectedNames.filter { it.endsWith(".class") }.map { entry ->
                        val expected = checkNotNull(bytes(oracle, entry)); val observed = checkNotNull(bytes(actual, entry))
                        check(ClassReader(expected).className + ".class" == entry && ClassReader(observed).className + ".class" == entry) { "$label entry/this_class mismatch: $entry" }
                        check(semantic(expected) == semantic(observed) && references(expected) == references(observed)) { "$label definition/body/descriptor/reference/AT mismatch: $entry" }
                        val target = entry.removeSuffix(".class")
                        officialToObf[target]?.takeIf { it != target }?.let { obf -> check("$obf.class" !in actualNames) { "$label duplicated obf definition: $obf" } }
                        buildJsonObject { put("entry", entry); put("expected", semantic(expected)); put("actual", semantic(observed)); put("expectedSha256", sha(expected)); put("actualSha256", sha(observed)) }
                    }
                    val patchedWitnesses = witnesses.getValue("patched").jsonArray
                    check(patchedWitnesses.isNotEmpty())
                    val interfaceWitness = witnesses.getValue("unpatchedInterface").jsonObject
                    val interfaceName = interfaceWitness.getValue("target").jsonPrimitive.content
                    val interfaceBytes = checkNotNull(bytes(cAt, "$interfaceName.class"))
                    check(ClassReader(interfaceBytes).access and Opcodes.ACC_INTERFACE != 0)
                    check(interfaceWitness.getValue("obf").jsonPrimitive.content == officialToObf.getValue(interfaceName))
                    check(patch.none { it.obf == interfaceName || it.srg == interfaceName } && "$interfaceName.class" !in filteredUniversal)
                    check(semantic(interfaceBytes) == semantic(checkNotNull(bytes(actual, "$interfaceName.class"))))
                    check(interfaceWitness.getValue("expectedDefinitionFromClean").jsonObject.getValue("sha256").jsonPrimitive.content == sha(interfaceBytes))
                    var interfaceReferenced = false
                    val priorityChecks = patchedWitnesses.map { item ->
                        val witness = item.jsonObject; val target = witness.getValue("target").jsonPrimitive.content
                        val record = patch.single { it.entry == witness.getValue("patchRecord").jsonPrimitive.content }
                        check(record.exists && record.length > 0 && record.obf == target && "$target.class" !in filteredUniversal)
                        check(witness.getValue("obf").jsonPrimitive.content == officialToObf.getValue(target))
                        val before = checkNotNull(bytes(c, "$target.class")); val patched = checkNotNull(bytes(p, "$target.class"))
                        val adler = Adler32().apply { update(before) }.value
                        check(adler == Integer.toUnsignedLong(record.checksum) && witness.getValue("cleanAdler32").jsonPrimitive.long == adler && !before.contentEquals(patched))
                        val expected = checkNotNull(bytes(oracle, "$target.class")); val unpatched = checkNotNull(bytes(cAt, "$target.class"))
                        val observed = checkNotNull(bytes(actual, "$target.class"))
                        check(semantic(expected) != semantic(unpatched) && semantic(observed) == semantic(expected)) { "$label patch did not win over clean: $target" }
                        check(witness.getValue("expectedPatched").jsonObject.getValue("sha256").jsonPrimitive.content == sha(expected))
                        check(witness.getValue("expectedClean").jsonObject.getValue("sha256").jsonPrimitive.content == sha(unpatched))
                        if (interfaceName in references(expected)) {
                            check(interfaceName in references(observed) && "$interfaceName.class" in actualNames)
                            interfaceReferenced = true
                        }
                        buildJsonObject { put("target", target); put("patchRecord", record.entry); put("adler32", adler); put("patched", definition(observed)); put("clean", definition(unpatched)) }
                    }
                    check(interfaceReferenced) { "$label has no concrete patched caller of the unpatched interface" }
                    val resourceChecks = expectedNames.filter { !it.endsWith(".class") && !it.equals(JarFile.MANIFEST_NAME, true) }.map { entry ->
                        val expected = checkNotNull(bytes(oracle, entry)); val observed = checkNotNull(bytes(actual, entry))
                        check(expected.contentEquals(observed)) { "$label complete legal resource differs: $entry" }
                        buildJsonObject { put("entry", entry); put("expectedSha256", sha(expected)); put("actualSha256", sha(observed)) }
                    }
                    // Check overlay priority before AT, then compare the final classes/resources to the independent AT output above.
                    check(names(overlay) == names(full) + filteredUniversal) { "Independent overlay entry set differs" }
                    (names(full) - filteredUniversal).forEach { entry -> check(checkNotNull(bytes(full, entry)).contentEquals(checkNotNull(bytes(overlay, entry)))) { "Independent overlay lost complete-stage content: $entry" } }
                    (pNames - deleted).forEach { entry -> check(checkNotNull(bytes(p, entry)).contentEquals(checkNotNull(bytes(full, entry)))) { "Independent complete patch lost sparse payload: $entry" } }
                    filteredUniversal.forEach { entry -> check(checkNotNull(bytes(uni, entry)).contentEquals(checkNotNull(bytes(overlay, entry)))) { "Independent filtered universal priority differs: $entry" } }
                    fun resource(name: String) = !name.endsWith(".class") && !name.startsWith("META-INF/", true)
                    val cleanResources = cNames.filter(::resource).toSet(); val patchResources = pNames.filter(::resource).toSet()
                    val universalResources = filteredUniversal.filter(::resource).toSet()
                    val cleanOnly = cleanResources - patchResources - filteredUniversal
                    val collisions = universalResources intersect (cleanResources + patchResources)
                    val universalOnly = universalResources - cleanResources - patchResources
                    check(cleanResources.isNotEmpty() && (collisions.isNotEmpty() || universalOnly.isNotEmpty()))
                    cleanOnly.forEach { name -> check(checkNotNull(bytes(c, name)).contentEquals(checkNotNull(bytes(actual, name)))) { "$label clean-only resource lost: $name" } }
                    (collisions + universalOnly).forEach { name -> check(checkNotNull(bytes(uni, name)).contentEquals(checkNotNull(bytes(actual, name)))) { "$label universal resource priority differs: $name" } }
                    val manifest = Manifest(checkNotNull(bytes(actual, JarFile.MANIFEST_NAME)).inputStream())
                    check(manifest.mainAttributes.getValue("Minecraft-Dists") == "client server" && manifest.mainAttributes.getValue("Codev-Minecraft-Marker") == "true")
                    manifest.entries.forEach { (entry, attrs) -> attrs.getValue("Minecraft-Dist")?.let { dist ->
                        check(dist in setOf("client", "server") && entry.isNotBlank() && !entry.startsWith('/')) { "$label invalid Minecraft-Dist format: $entry=$dist" }
                    } }
                    val clientResources = names(rawClient).filter(::resource).toSet(); val serverResources = names(rawServer).filter(::resource).toSet()
                    val clientOnly = clientResources - serverResources; val common = clientResources intersect serverResources
                    check(clientOnly.all { manifest.entries[it]?.getValue("Minecraft-Dist") == "client" }) { "$label raw client-only resource Dist marker differs" }
                    val legalCommon = common intersect expectedNames
                    legalCommon.forEach { name -> check(checkNotNull(bytes(oracle, name)).contentEquals(checkNotNull(bytes(actual, name)))) }
                    fun strings(values: Iterable<String>) = JsonArray(values.sorted().map(::JsonPrimitive))
                    return buildJsonObject {
                        put("output", output.toString()); put("sha256", shaFile(output)); put("reference", expectedPatched.toString()); put("referenceSha256", shaFile(expectedPatched))
                        put("classes", JsonArray(classChecks)); put("patchedPriority", JsonArray(priorityChecks)); put("unpatchedInterface", definition(interfaceBytes))
                        put("resources", JsonArray(resourceChecks)); put("cleanEntries", strings(cNames)); put("patchEntries", strings(pNames))
                        put("universalEntries", strings(allUniversal)); put("filteredUniversal", strings(filteredUniversal)); put("filterExcluded", strings(allUniversal - filteredUniversal))
                        put("cleanOnly", strings(cleanOnly)); put("collisions", strings(collisions)); put("universalOnly", strings(universalOnly))
                        put("collisionApplicability", if (collisions.isEmpty()) "not-applicable: full filtered intersection empty; universal-only verified" else "required and verified")
                        put("rawClientResources", strings(clientResources)); put("rawExtractedServerResources", strings(serverResources)); put("rawClientOnly", strings(clientOnly)); put("rawCommon", strings(common))
                        put("legalCommonChecked", strings(legalCommon)); put("rawCommonOutsideStage", strings(common - expectedNames))
                        put("clientOnlyApplicability", if (clientOnly.isEmpty()) "not-applicable: complete raw difference empty" else "all client markers checked")
                        put("injectApplicability", "fixed userdev inject=null; no inject obligation for this Neo sample")
                        put("coverageLimits", "No full class-side classification, old/new attrs equivalence, raw resource restoration or old wrong-key dynamic rejection")
                    }
                } finally { archives.asReversed().forEach(ZipFile::close) }
            }
            val oldContent = verifyContent(originalOutput, "original-cold")
            write(evidence.resolve("original-content.json"), oldContent)
            write(evidence.resolve("cold-applicability.json"), buildJsonObject {
                put("operation", operation); put("version", PATCH_OPERATION_VERSION); put("key", key); put("basename", originalOutput.fileName.toString()); put("cache", cached.toString()); put("sha256", originalSha)
                put("inputRecords", JsonArray(prepRows.map { JsonArray(it.map(::JsonPrimitive)) })); put("referenceRecords", JsonArray(refRows.map { JsonArray(it.map(::JsonPrimitive)) }))
                put("orderedOperationInputs", JsonArray(inputs.map { buildJsonObject { put("path", it.toString()); put("sha256", shaFile(it)); put("murmur3", hashFile(it).toString()) } }))
                put("aggregateSemantics", "content murmur3_32_fixed; signed-byte sort and dedup; putBytes aggregate; role/order recorded separately")
                put("isolatedOldPaths", JsonArray(oldPaths.map { JsonPrimitive(it.toString()) })); put("oldMissLog", prep.resolve("gradle.log").toString())
                put("loadedActionSha256", sha(loadedAction)); put("actionFingerprint", actionFingerprint(loadedAction)); put("oldAction", oldAction.toString())
                put("coreIdentity", JsonArray(coreIdentities)); put("currentSources", JsonArray(sourceIdentity)); put("oldJava21", java21.toString()); put("referenceArgv", ref.resolve("evidence/argv.tsv").toString())
                put("atFiles", JsonArray(ats.map { buildJsonObject { put("path", it.toString()); put("sha256", shaFile(it)) } }))
            })

            // Only after every old-content/identity precondition: one fresh project and one build().
            val reuse = Files.createDirectory(q.resolve("neo-reuse"))
            for (dir in listOf("project", "output", "evidence", "tmp")) Files.createDirectory(reuse.resolve(dir))
            val template = Path.of("integration-test/forge/patch-namespace").toRealPath()
            for (name in listOf("settings.gradle.kts", "build.gradle.kts")) Files.copy(template.resolve(name), reuse.resolve("project/$name"))
            val output = reuse.resolve("output/${originalOutput.fileName}")
            check(!Files.exists(output) && output != cached && output != originalOutput)
            runner.withGradleInstallation(gradleInstallation.toFile())
                .withProjectDir(reuse.resolve("project").toFile())
                .withEnvironment(System.getenv() + mapOf("TMP" to reuse.resolve("tmp").toString(), "TEMP" to reuse.resolve("tmp").toString()))
            val args = listOf("recordNeo121NoMcinject", "--offline", "--stacktrace", "--info", "--max-workers=1", "--no-parallel", "--no-configuration-cache", "--no-build-cache", "--rerun-tasks",
                "-Dorg.gradle.java.home=$javaHome",
                "-Dorg.gradle.jvmargs=-Xmx512m -Djava.io.tmpdir=${reuse.resolve("tmp")}", "-Dorg.gradle.java.installations.auto-download=false", "-Dorg.gradle.java.installations.paths=$installations",
                "-PneoPreparedRoot=$sample",
                "-PfixtureClasspath=${runner.pluginClasspath.joinToString(File.pathSeparator) { it.path }}")
            Files.writeString(reuse.resolve("arguments.txt"), args.joinToString("\n"))
            Files.writeString(reuse.resolve("cwd.txt"), reuse.resolve("project").toString())
            Files.writeString(evidence.resolve("calls.tsv"), "nested\t1\nprepare\t0\nreference\t0\n")
            val result = try { runner.withArguments(args).build() } catch (failure: UnexpectedBuildFailure) {
                Files.writeString(reuse.resolve("gradle.log"), failure.buildResult.output)
                Files.writeString(reuse.resolve("tasks.tsv"), failure.buildResult.tasks.joinToString("\n") { "${it.path}\t${it.outcome}" })
                throw failure
            }
            Files.writeString(reuse.resolve("gradle.log"), result.output)
            Files.writeString(reuse.resolve("tasks.tsv"), result.tasks.joinToString("\n") { "${it.path}\t${it.outcome}" })
            check(result.tasks.map { it.path }.toSet() == setOf(":patchedNeo121NoMcinject", ":recordNeo121NoMcinject") && result.tasks.all { it.outcome == TaskOutcome.SUCCESS }) { "Actual producer/record actions must both execute SUCCESS" }
            check(result.output.contains("PREPARED_NEO_ACTION $operation $key $cached") && result.output.contains("Cache hit for $operation operation for [$output]"))
            check(!result.output.contains("Cache miss for $operation") && result.output.contains("BUILD SUCCESSFUL")) { "A miss is not an allowed cold segment; no retry" }
            check(Files.readString(reuse.resolve("evidence/action-cache.tsv")).contains("cache\t$cached\n"))
            check(Files.readString(reuse.resolve("evidence/task-graph.tsv")).contains(":recordNeo121NoMcinject\t[:patchedNeo121NoMcinject]"))
            check(Files.readString(reuse.resolve("evidence/production-output.txt")).trim() == output.toString())
            check(Files.isRegularFile(output) && shaFile(output) == originalSha && shaFile(cached) == originalSha && shaFile(originalOutput) == originalSha)
            write(evidence.resolve("hit-content.json"), verifyContent(output, "native-hit"))
            write(evidence.resolve("result.json"), buildJsonObject {
                put("output", output.toString()); put("sha256", shaFile(output)); put("cache", cached.toString()); put("key", key); put("oldFinal", originalOutput.toString())
                put("nestedBuild", "GradleRunner.build returned; producer and record SUCCESS; real action and native hit logged")
                put("nestedExitCode", JsonNull); put("exitLimitation", "TestKit BuildResult exposes outcomes, not a numeric process exit; outer exit/XML belong to the caller")
                put("nestedCalls", 1); put("prepareCalls", 0); put("referenceCalls", 0)
            })
            Files.writeString(evidence.resolve("verified.txt"), "Old full content and cold applicability; one real same-path native hit; new full content verified. Outer exit/JUnit still required.\n")
            return evidence
        } catch (failure: Exception) {
            Files.writeString(evidence.resolve("failure.txt"), failure.stackTraceToString())
            throw failure
        }
    }

    private fun prepare(sampleName: String): Path {
        val basic = sampleName == "basicNotch"
        val neo = sampleName == "neo121NoMcinject"
        val taskSuffix = when { basic -> "BasicNotch"; neo -> "Neo121NoMcinject"; else -> "Forge1165Mcinject" }
        val template = Path.of("integration-test/forge/patch-namespace").toAbsolutePath()
        check(Files.isRegularFile(template.resolve("build.gradle.kts")))
        val root = Files.createTempDirectory(Files.createDirectories(Path.of("build/reports/test/fixtures").toAbsolutePath()), when { basic -> "forge-patch-basic-"; neo -> "forge-patch-neo-"; else -> "forge-patch-1165-" })
        val sample = root.resolve(sampleName)
        check(System.getProperty("fixture.gradleJava") != null) { "fixture.gradleJava must select the actual Gradle JDK17" }
        val phases = listOf("prepare", "fresh", "reuse", "reference")
        for (phase in phases) {
            val phaseRoot = sample.resolve(phase)
            val project = Files.createDirectories(phaseRoot.resolve("project"))
            for (name in listOf("settings.gradle.kts", "build.gradle.kts")) Files.copy(template.resolve(name), project.resolve(name))
            for (name in listOf("cache", "output", "evidence", "tmp")) Files.createDirectories(phaseRoot.resolve(name))
        }
        write(root.resolve("isolation.json"), buildJsonObject {
            put("sample", sampleName); put("sourceCoordinate", "net.minecraftforge:binarypatcher:${if (basic || neo) "1.1.1" else "1.0.12"}:sources")
            put("testLauncherHome", System.getProperty("java.home")); put("testLauncherVersion", System.getProperty("java.version"))
            put("fixtureGradleJava", System.getProperty("fixture.gradleJava"))
            put("gradleDistributionSelection", "TestKit current distribution, as in existing PatchedMinecraftTests; actual installation/version recorded by fixture")
            put("roots", buildJsonObject { for (phase in phases) put(phase, buildJsonObject {
                for (name in listOf("project", "output", "evidence", "tmp")) put(name, sample.resolve("$phase/$name").toString())
                put("gradle-home", System.getProperty("org.gradle.testkit.dir"))
                put("cache", sample.resolve("${if (phase == "reuse") "fresh" else phase}/cache").toString())
                put("executed", phase in listOf("reference", "prepare"))
            }) })
            put("freshReuse", "Reserved separate projects/outputs; shared user Gradle Home; reuse also shares the fresh custom cache. Neither executed by this preparation selector.")
        })
        println("${when { basic -> "FORGE_PATCH_BASIC"; neo -> "FORGE_PATCH_NEO"; else -> "FORGE_PATCH_1165" }}_EVIDENCE=$root")
        fun run(phase: String, task: String) {
            val dir = sample.resolve(phase)
            val runner = GradleRunner.create().withProjectDir(dir.resolve("project").toFile())
                .withPluginClasspath()
            if (!basic) runner.withEnvironment(System.getenv() + mapOf("TMP" to dir.resolve("tmp").toString(), "TEMP" to dir.resolve("tmp").toString()))
            val args = mutableListOf("describe$taskSuffix", task, "--stacktrace", "--info", "--max-workers=1", "--no-parallel",
                "--no-configuration-cache", "--no-build-cache", "--rerun-tasks",
                "-Dorg.gradle.java.home=${System.getProperty("fixture.gradleJava")}",
                "-Dorg.gradle.jvmargs=-Xmx512m -Djava.io.tmpdir=${dir.resolve("tmp")}",
                "-Dorg.gradle.java.installations.auto-download=false",
                "-PfixtureClasspath=${runner.pluginClasspath.joinToString(File.pathSeparator) { it.path }}")
            System.getProperty("org.gradle.java.installations.paths")?.takeIf(String::isNotEmpty)?.let {
                args.add("-Dorg.gradle.java.installations.paths=$it")
            }
            Files.writeString(dir.resolve("arguments.txt"), args.joinToString("\n"))
            check(Files.list(dir.resolve("cache")).use { !it.findAny().isPresent }) { "Preparation must start with an empty private cache" }
            try {
                val result = runner.withArguments(args).build()
                Files.writeString(dir.resolve("gradle.log"), result.output)
                Files.writeString(dir.resolve("tasks.tsv"), result.tasks.joinToString("\n") { "${it.path}\t${it.outcome}" })
                check(result.task(":$task")?.outcome == TaskOutcome.SUCCESS) { "Real $task did not execute" }
                if (phase == "prepare") check(result.task(":patched$taskSuffix")?.outcome == TaskOutcome.SUCCESS)
            } catch (failure: UnexpectedBuildFailure) {
                Files.writeString(dir.resolve("gradle.log"), failure.buildResult.output)
                if (!basic) Files.writeString(dir.resolve("tasks.tsv"), failure.buildResult.tasks.joinToString("\n") { "${it.path}\t${it.outcome}" })
                Files.writeString(dir.resolve("failure.txt"), failure.stackTraceToString())
                throw failure
            }
        }
        run("prepare", "record$taskSuffix")
        run("reference", "reference$taskSuffix")
        val privatePaths = phases.flatMap { phase -> listOf("project", "output", "evidence", "tmp").map { sample.resolve("$phase/$it").toRealPath() } }
        check(privatePaths.distinct().size == privatePaths.size)
        check(phases.filter { it != "reuse" }.map { sample.resolve("$it/cache").toRealPath() }.distinct().size == 3)
        when { basic -> witnesses(sample, root); neo -> witnessesNeo121(sample, root); else -> witnessesForge1165(sample, root) }
        Files.writeString(root.resolve("prepared.txt"), if (basic) "basicNotch prepared to real final output; namespace correctness is not asserted by T-basic.\n"
            else "$sampleName prepared to real final output; namespace correctness is not asserted by ${if (neo) "T-Neo" else "T-1165"}.\n")
        return root
    }

    private data class PatchRecord(val entry: String, val obf: String, val srg: String, val exists: Boolean, val checksum: Int, val length: Int)
    private fun patches(tool: Path, patchFile: Path): List<PatchRecord> = URLClassLoader(arrayOf(tool.toUri().toURL()), ClassLoader.getPlatformClassLoader()).use { loader ->
        val decoder = loader.loadClass("lzma.sdk.lzma.Decoder")
        val stream = loader.loadClass("lzma.streams.LzmaInputStream").getConstructor(InputStream::class.java, decoder)
            .newInstance(Files.newInputStream(patchFile), decoder.getConstructor().newInstance()) as InputStream
        val patch = loader.loadClass("net.minecraftforge.binarypatcher.Patch")
        // Drain the threaded LZMA decoder before JarInputStream stops at the ZIP central directory.
        val archive = stream.use { it.readBytes() }
        JarInputStream(archive.inputStream()).use { jar ->
            val records = mutableListOf<PatchRecord>()
            while (true) {
                val entry = jar.nextJarEntry ?: break
                if (!entry.name.endsWith(".binpatch")) continue
                val value = patch.getMethod("from", InputStream::class.java).invoke(null, jar)
                records.add(PatchRecord(entry.name, patch.getField("obf").get(value) as String, patch.getField("srg").get(value) as String,
                    patch.getField("exists").getBoolean(value), patch.getField("checksum").getInt(value), (patch.getField("data").get(value) as ByteArray).size))
            }
            records
        }
    }

    private fun witnesses(sample: Path, root: Path) {
        val ref = sample.resolve("reference")
        val prep = sample.resolve("prepare")
        val records = fileRows(ref.resolve("evidence/files.tsv"))
        val tool = artifact(records, "basicReferenceTools:net.minecraftforge:binarypatcher:")
        val ud = artifact(records, "basicUserdev:")
        val universal = artifact(records, "basicUniversal:")
        val patch = patches(tool, ref.resolve("evidence/joined.lzma"))
        check(patch.isNotEmpty())
        val mappings = Files.readAllLines(ref.resolve("evidence/config/joined.tsrg")).filter { it.isNotEmpty() && !it[0].isWhitespace() }
            .associate { it.split(' ').let { words -> check(words.size == 2); words[0] to words[1] } }
        check(mappings.values.contains("net/minecraft/command/ICommandSender"))
        val output = Path.of(Files.readString(prep.resolve("evidence/production-output.txt")))
        ZipFile(ref.resolve("output/stages/merge-clean.jar").toFile()).use { clean ->
            ZipFile(ref.resolve("output/stages/patch-obf.jar").toFile()).use { rawPatched ->
                ZipFile(ref.resolve("output/reference-patched-at.jar").toFile()).use { expectedPatched ->
                    ZipFile(ref.resolve("output/reference-clean-at.jar").toFile()).use { expectedClean ->
                        ZipFile(universal.toFile()).use { uni -> ZipFile(ud.toFile()).use { inject -> ZipFile(output.toFile()).use { actual ->
                            val cleanNames = names(clean)
                            val patchNames = names(rawPatched)
                            val config = json.parseToJsonElement(checkNotNull(bytes(inject, "config.json")).decodeToString()).jsonObject
                            check(config.getValue("notchObf").jsonPrimitive.boolean &&
                                config.getValue("mcp").jsonPrimitive.content == "de.oceanlabs.mcp:mcp_config:1.12.2-20200226.224830@zip")
                            val filters = config["universalFilters"]?.jsonArray?.map { it.jsonPrimitive.content }.orEmpty()
                            val universalEntries = names(uni)
                            val universalNames = universalEntries.filter { name -> filters.all { Regex(it).matches(name) } }.toSortedSet()
                            val injectPrefix = config.getValue("inject").jsonPrimitive.content
                            check(injectPrefix == "inject/")
                            val userdevEntries = inject.entries().asSequence().map { it.name }.toSortedSet()
                            val injectEntries = userdevEntries.filter { it.startsWith(injectPrefix) }
                            val injected = names(inject).filter { it.startsWith(injectPrefix) }.associateWith { it.removePrefix(injectPrefix) }
                            val overlays = universalNames + injected.values
                            write(root.resolve("patch-records.json"), JsonArray(patch.map { p -> buildJsonObject {
                                put("entry", p.entry); put("obf", p.obf); put("srg", p.srg); put("exists", p.exists)
                                put("adler32", Integer.toUnsignedLong(p.checksum)); put("diffLength", p.length); put("deleted", p.length == 0)
                            } }))
                            val candidates = patch.filter { p -> p.exists && p.length > 0 && "${p.obf}.class" in cleanNames &&
                                "${mappings[p.obf]}.class" !in overlays && bytes(rawPatched, "${p.obf}.class") != null }
                                .filter { p -> !checkNotNull(bytes(clean, "${p.obf}.class")).contentEquals(checkNotNull(bytes(rawPatched, "${p.obf}.class"))) }
                                .sortedBy { mappings[it.obf] ?: error("Missing patch mapping ${it.obf}") }
                            Files.writeString(root.resolve("patched-candidates.tsv"), candidates.joinToString("\n") { "${mappings[it.obf]}\t${it.obf}\t${it.entry}" })
                            check(candidates.isNotEmpty()) { "No changed, non-deleted patch/clean intersection outside overlays" }
                            val commandInterface = "net/minecraft/command/ICommandSender"
                            val senderObf = mappings.entries.single { it.value == commandInterface }.key
                            check(patch.none { it.obf == senderObf }) { "ICommandSender must be a genuinely unpatched interface" }
                            val sender = checkNotNull(bytes(expectedClean, "$commandInterface.class"))
                            check(ClassReader(sender).access and 0x0200 != 0)
                            val related = candidates.firstOrNull { references(checkNotNull(bytes(expectedPatched, "${mappings[it.obf]}.class"))).contains(commandInterface) }
                                ?: error("No actual changed patched caller references clean ICommandSender; see full candidate inventory")
                            val chosen = listOf(candidates.first(), related).distinctBy { it.obf }
                            val witnessDir = Files.createDirectories(root.resolve("witnesses"))
                            write(root.resolve("class-witnesses.json"), buildJsonObject {
                                put("selection", "Target internal name lexical order; changed existing non-deleted patch intersection, excluding universal/inject overlays; plus first ICommandSender reference")
                                put("mappingDirection", "config/joined.tsrg obf -> SRG; header is first mapping, not tsrg2")
                                put("patched", JsonArray(chosen.map { p ->
                                    val target = mappings.getValue(p.obf)
                                    val cleanBytes = checkNotNull(bytes(clean, "${p.obf}.class"))
                                    val adler = Adler32().apply { update(cleanBytes) }.value
                                    check(adler == Integer.toUnsignedLong(p.checksum)) { "Illegal clean checksum: ${p.obf}" }
                                    val expected = checkNotNull(bytes(expectedPatched, "$target.class"))
                                    val unpatched = checkNotNull(bytes(expectedClean, "$target.class"))
                                    check(ClassReader(expected).className == target)
                                    check(semantic(expected) != semantic(unpatched)) { "No semantic patched/clean distinction after official transforms/AT: $target" }
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-patched.class"), expected)
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-clean.class"), unpatched)
                                    buildJsonObject {
                                        put("patchRecord", p.entry); put("obf", p.obf); put("target", target); put("cleanAdler32", adler)
                                        put("expectedPatched", definition(expected)); put("expectedClean", definition(unpatched))
                                        put("actualTarget", bytes(actual, "$target.class")?.let(::definition) ?: JsonNull)
                                        put("actualObfEntry", actual.getEntry("${p.obf}.class") != null)
                                        put("referencesICommandSender", commandInterface in references(expected))
                                    }
                                }))
                                put("unpatchedInterface", buildJsonObject {
                                    put("obf", senderObf); put("target", commandInterface); put("patchRecords", 0)
                                    put("expectedDefinitionFromClean", definition(sender)); put("actualTarget", bytes(actual, "$commandInterface.class")?.let(::definition) ?: JsonNull)
                                    put("actualObfEntry", actual.getEntry("$senderObf.class") != null)
                                })
                                put("finalOutput", output.toString()); put("finalSha256", sha(Files.readAllBytes(output)))
                                put("namespaceCorrectnessAsserted", false)
                            })
                            Files.write(witnessDir.resolve("ICommandSender-clean.class"), sender)
                            fun isResource(name: String) = !name.endsWith(".class") && !name.startsWith("META-INF/", true) && name != "binpatches.pack.lzma"
                            val resources = cleanNames.filter(::isResource)
                            val patchResources = patchNames.filter(::isResource)
                            val universalResources = universalNames.filter(::isResource)
                            val cleanOnly = resources.filter { it !in overlays }.sorted()
                            val collisions = universalResources.filter { it in resources || it in patchResources }.sorted()
                            val universalOnly = universalResources.filter { it !in cleanNames && it !in patchNames }.sorted()
                            val losses = mutableListOf("Raw client/server resource restoration is outside the patch-stage contract.")
                            if (cleanOnly.isEmpty()) losses.add("No dynamic basic non-class clean completion witness: merge-clean candidate set is empty.")
                            if (injected.isEmpty()) losses.add("No positive basic inject class/service/provider copy or inject conflict coverage: configured prefix has no archive payload.")
                            if (collisions.isEmpty()) losses.add("No dynamic universal collision priority coverage: filtered universal intersects neither clean nor patch resources.")
                            write(root.resolve("resource-inventory.json"), buildJsonObject {
                                put("sample", "MC1.12.2 / Forge14.23.5.2860:userdev3 / MCP1.12.2-20200226.224830")
                                put("resourceFilter", "Non-directory; exclude .class, META-INF/ (case-insensitive), binpatches.pack.lzma; universal additionally requires all published regex filters.")
                                put("userdevConfig", config)
                                put("archives", buildJsonObject {
                                    for ((role, archive) in listOf("merge-clean" to clean, "patch-obf" to rawPatched, "universal" to uni, "userdev" to inject, "production-final" to actual)) put(role, buildJsonObject {
                                        val path = Path.of(archive.name)
                                        put("path", path.toString()); put("sha256", sha(Files.readAllBytes(path))); put("size", Files.size(path))
                                        put("nonDirectoryEntries", JsonArray(names(archive).map(::JsonPrimitive)))
                                    })
                                })
                                put("universalFilters", JsonArray(filters.map(::JsonPrimitive)))
                                put("universalFilterExcluded", JsonArray((universalEntries - universalNames).map(::JsonPrimitive)))
                                put("universalResources", JsonArray(universalResources.map(::JsonPrimitive)))
                                put("cleanResources", JsonArray(resources.map(::JsonPrimitive)))
                                put("patchResources", JsonArray(patchResources.map(::JsonPrimitive)))
                                put("cleanOverlayExcluded", JsonArray(resources.filter { it in overlays }.map(::JsonPrimitive)))
                                put("cleanOnly", JsonArray(cleanOnly.map(::JsonPrimitive)))
                                put("universalResourceCollisions", JsonArray(collisions.map(::JsonPrimitive)))
                                put("universalOnly", JsonArray(universalOnly.map(::JsonPrimitive)))
                                put("injectPrefixEntriesIncludingDirectories", JsonArray(injectEntries.map(::JsonPrimitive)))
                                put("inject", JsonObject(injected.mapValues { JsonPrimitive(it.value) }))
                                put("cleanOnlyApplicability", if (cleanOnly.isEmpty()) "not-applicable: fixed basic merge-clean candidate set empty" else "required: candidates present")
                                put("injectApplicability", if (injected.isEmpty()) "not-applicable: configured inject/ absent from fixed basic userdev archive" else "required: payload present")
                                put("coverageLosses", JsonArray(losses.map(::JsonPrimitive)))
                            })
                            // Only this fixed basic sample may lack these two positive witnesses; do not borrow raw/tool-generated resources.
                            check(cleanOnly.isNotEmpty() || resources.isEmpty()) { "Empty clean-only set is not an empty merge-clean resource stage" }
                            check(injected.isNotEmpty() || injectEntries.isEmpty()) { "Empty inject payload with a present prefix is not the accepted absent-prefix case" }
                            check(collisions.isNotEmpty() || universalOnly.isNotEmpty()) { "No universal resource witness" }
                            fun resource(origin: String, archive: ZipFile, source: String, target: String = source) = buildJsonObject {
                                val expected = checkNotNull(bytes(archive, source))
                                val observed = bytes(actual, target)
                                put("origin", origin); put("source", source); put("target", target); put("expectedSha256", sha(expected))
                                put("actualSha256", observed?.let(::sha) ?: "missing")
                                check(observed != null && expected.contentEquals(observed)) { "$origin bytes differ at $target" }
                            }
                            val selectedInject = listOfNotNull(
                                injected.entries.filter { it.value.endsWith(".class") && it.value !in universalNames && it.value !in cleanNames && it.value !in patchNames }.minByOrNull { it.value },
                                injected.entries.filter { it.value.startsWith("META-INF/services/") && it.value !in universalNames && it.value !in cleanNames && it.value !in patchNames }.minByOrNull { it.value },
                            )
                            check(injected.isEmpty() || selectedInject.isNotEmpty()) { "Actual inject payload has no inject-only class/service witness; see complete resource-inventory.json" }
                            write(root.resolve("resource-witnesses.json"), JsonArray(
                                cleanOnly.map { resource("clean-only", clean, it) } +
                                    (if (collisions.isNotEmpty()) collisions.map { resource("universal-collision", uni, it) } else universalOnly.map { resource("universal-only; complete clean/patch collision intersection empty", uni, it) }) +
                                    selectedInject.map { resource("userdev-inject", inject, it.key, it.value) },
                            ))
                        } } }
                    }
                }
            }
        }
    }
    private fun witnessesForge1165(sample: Path, root: Path) {
        val ref = sample.resolve("reference"); val prep = sample.resolve("prepare")
        val rows = fileRows(ref.resolve("evidence/files.tsv"))
        val tool = artifact(rows, "forge1165ReferenceTools:net.minecraftforge:binarypatcher:")
        val userdev = artifact(rows, "forge1165Userdev:"); val universal = artifact(rows, "forge1165Universal:")
        val patch = patches(tool, ref.resolve("evidence/joined.lzma"))
        check(patch.isNotEmpty())
        val mappings = Files.readAllLines(ref.resolve("evidence/config/joined.tsrg")).filter { it.isNotEmpty() && !it[0].isWhitespace() }
            .associate { it.split(' ').let { words -> check(words.size == 2); words[0] to words[1] } }
        val inverse = mappings.entries.associate { it.value to it.key }
        val output = Path.of(Files.readString(prep.resolve("evidence/production-output.txt")).trim())
        ZipFile(ref.resolve("output/stages/clean-rename.jar").toFile()).use { clean ->
            ZipFile(ref.resolve("output/stages/patch-srg.jar").toFile()).use { sparse ->
                ZipFile(ref.resolve("output/reference-clean-at.jar").toFile()).use { expectedClean ->
                    ZipFile(ref.resolve("output/reference-patched-at.jar").toFile()).use { expectedPatched ->
                        ZipFile(universal.toFile()).use { uni -> ZipFile(userdev.toFile()).use { inject -> ZipFile(output.toFile()).use { actual ->
                            val config = json.parseToJsonElement(checkNotNull(bytes(inject, "config.json")).decodeToString()).jsonObject
                            check(config["notchObf"]?.jsonPrimitive?.booleanOrNull != true)
                            check(config.getValue("mcp").jsonPrimitive.content == "de.oceanlabs.mcp:mcp_config:1.16.5-20210115.111550@zip")
                            check(config["modules"]?.jsonArray.orEmpty().isEmpty())
                            val filters = config["universalFilters"]?.jsonArray?.map { it.jsonPrimitive.content }.orEmpty()
                            val cleanNames = names(clean); val sparseNames = names(sparse); val universalEntries = names(uni)
                            val universalNames = universalEntries.filter { name -> filters.all { Regex(it).matches(name) } }.toSortedSet()
                            val prefix = config.getValue("inject").jsonPrimitive.content
                            val injected = names(inject).filter { it.startsWith(prefix) }.associateWith { it.removePrefix(prefix) }
                            check(injected.values.count { it.endsWith(".class") } == 13 && injected.values.count { it.startsWith("META-INF/services/") } == 3)
                            val overlays = universalNames + injected.values
                            write(root.resolve("patch-records.json"), JsonArray(patch.map { p -> buildJsonObject {
                                put("entry", p.entry); put("obf", p.obf); put("srg", p.srg); put("exists", p.exists)
                                put("adler32", Integer.toUnsignedLong(p.checksum)); put("diffLength", p.length); put("deleted", p.length == 0)
                            } }))
                            val candidates = patch.filter { p -> p.exists && p.length > 0 && p.obf in inverse && "${p.obf}.class" in cleanNames &&
                                "${p.obf}.class" !in overlays && "${p.obf}.class" in sparseNames }
                                .filter { p -> !checkNotNull(bytes(clean, "${p.obf}.class")).contentEquals(checkNotNull(bytes(sparse, "${p.obf}.class"))) }
                                .filter { p -> semantic(checkNotNull(bytes(expectedClean, "${p.obf}.class"))) != semantic(checkNotNull(bytes(expectedPatched, "${p.obf}.class"))) }
                                .sortedBy { it.obf }
                            Files.writeString(root.resolve("patched-candidates.tsv"), candidates.joinToString("\n") { "${it.obf}\t${inverse.getValue(it.obf)}\t${it.entry}" })
                            check(candidates.isNotEmpty()) { "No legal SRG patch witness outside overlays" }
                            val patchNames = patch.flatMap { listOf(it.obf, it.srg) }.toSet()
                            val related = candidates.asSequence().mapNotNull { p ->
                                references(checkNotNull(bytes(expectedPatched, "${p.obf}.class"))).firstOrNull { name ->
                                    name in inverse && name !in patchNames && "$name.class" !in overlays &&
                                        bytes(expectedClean, "$name.class")?.let { ClassReader(it).access and 0x0200 != 0 } == true
                                }?.let { p to it }
                            }.firstOrNull() ?: error("No concrete patched caller references a genuinely unpatched game interface")
                            val chosen = listOf(candidates.first(), related.first).distinctBy { it.obf }
                            val witnessDir = Files.createDirectories(root.resolve("witnesses"))
                            write(root.resolve("class-witnesses.json"), buildJsonObject {
                                put("selection", "Lexical SRG target; changed existing non-deleted patch, legal renamed-clean checksum, no universal/inject overlap; plus first patched caller of an unpatched game interface")
                                put("mappingDirection", "Official joined.tsrg obf -> SRG; patch input is already renamed SRG; no post-patch rename")
                                put("patched", JsonArray(chosen.map { p ->
                                    val target = p.obf
                                    val source = checkNotNull(bytes(clean, "$target.class"))
                                    val adler = Adler32().apply { update(source) }.value
                                    check(adler == Integer.toUnsignedLong(p.checksum))
                                    val expected = checkNotNull(bytes(expectedPatched, "$target.class")); val unpatched = checkNotNull(bytes(expectedClean, "$target.class"))
                                    check(ClassReader(expected).className == target && semantic(expected) != semantic(unpatched))
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-patched.class"), expected)
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-clean.class"), unpatched)
                                    buildJsonObject {
                                        put("patchRecord", p.entry); put("patchInputName", p.obf); put("patchSrgField", p.srg); put("obf", inverse.getValue(target)); put("target", target)
                                        put("cleanAdler32", adler); put("expectedPatched", definition(expected)); put("expectedClean", definition(unpatched))
                                        put("actualTarget", bytes(actual, "$target.class")?.let(::definition) ?: JsonNull)
                                        put("referencesUnpatchedInterface", related.second in references(expected))
                                    }
                                }))
                                put("unpatchedInterface", buildJsonObject {
                                    val target = related.second; val source = checkNotNull(bytes(expectedClean, "$target.class"))
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-interface-clean.class"), source)
                                    put("target", target); put("obf", inverse.getValue(target)); put("patchRecords", 0)
                                    put("expectedDefinitionFromClean", definition(source)); put("actualTarget", bytes(actual, "$target.class")?.let(::definition) ?: JsonNull)
                                })
                                put("finalOutput", output.toString()); put("finalSha256", sha(Files.readAllBytes(output))); put("namespaceCorrectnessAsserted", false)
                            })
                            fun isResource(name: String) = !name.endsWith(".class") && !name.startsWith("META-INF/", true) && name != "binpatches.pack.lzma"
                            val resources = cleanNames.filter(::isResource); val sparseResources = sparseNames.filter(::isResource)
                            val universalResources = universalNames.filter(::isResource)
                            val cleanOnly = resources.filter { it !in overlays && it !in sparseNames }.sorted()
                            val collisions = universalResources.filter { it in resources || it in sparseResources }.sorted()
                            val universalOnly = universalResources.filter { it !in cleanNames && it !in sparseNames }.sorted()
                            val transformedResources = names(expectedPatched).filter { isResource(it) && it !in overlays }.sorted()
                            val losses = mutableListOf("Raw client/server resource restoration is outside the patch-stage contract.")
                            if (cleanOnly.isEmpty()) losses.add("No clean-only non-class candidate in this fixed sample's actual renamed clean stage.")
                            if (collisions.isEmpty()) losses.add("No dynamic universal collision priority coverage: complete filtered intersection is empty.")
                            write(root.resolve("resource-inventory.json"), buildJsonObject {
                                put("sample", "MC1.16.5 / Forge1.16.5-36.2.39:userdev / MCP1.16.5-20210115.111550")
                                put("userdevConfig", config); put("patchInputNamespace", "SRG")
                                put("resourceFilter", "Non-directory; exclude .class, META-INF/ case-insensitively, binpatches.pack.lzma; all published universal filters; inject checked separately in full")
                                put("archives", buildJsonObject {
                                    for ((role, archive) in listOf("clean-rename" to clean, "patch-srg" to sparse, "reference-clean-at" to expectedClean, "reference-patched-at" to expectedPatched, "universal" to uni, "userdev" to inject, "production-final" to actual)) put(role, buildJsonObject {
                                        val path = Path.of(archive.name); put("path", path.toString()); put("sha256", sha(Files.readAllBytes(path))); put("size", Files.size(path))
                                        put("nonDirectoryEntries", JsonArray(names(archive).map(::JsonPrimitive)))
                                    })
                                })
                                put("universalFilters", JsonArray(filters.map(::JsonPrimitive))); put("universalFilterExcluded", JsonArray((universalEntries-universalNames).map(::JsonPrimitive)))
                                put("cleanResources", JsonArray(resources.map(::JsonPrimitive))); put("patchResources", JsonArray(sparseResources.map(::JsonPrimitive)))
                                put("universalResources", JsonArray(universalResources.map(::JsonPrimitive)))
                                put("cleanOnly", JsonArray(cleanOnly.map(::JsonPrimitive))); put("universalResourceCollisions", JsonArray(collisions.map(::JsonPrimitive))); put("universalOnly", JsonArray(universalOnly.map(::JsonPrimitive)))
                                put("postTransformResources", JsonArray(transformedResources.map(::JsonPrimitive))); put("inject", JsonObject(injected.mapValues { JsonPrimitive(it.value) }))
                                put("cleanOnlyApplicability", if (cleanOnly.isEmpty()) "not-applicable: actual fixed renamed-clean set has no clean-only resource" else "required")
                                put("injectApplicability", "required: actual 13 classes and 3 services; every payload and every provider definition checked")
                                put("coverageLosses", JsonArray(losses.map(::JsonPrimitive)))
                            })
                            fun resource(origin: String, archive: ZipFile, source: String, target: String = source) = buildJsonObject {
                                val expected = checkNotNull(bytes(archive, source)); val observed = bytes(actual, target)
                                put("origin", origin); put("source", source); put("target", target); put("expectedSha256", sha(expected)); put("actualSha256", observed?.let(::sha) ?: "missing")
                                check(observed != null && expected.contentEquals(observed)) { "$origin bytes differ at $target" }
                                if (target.endsWith(".class")) put("definition", definition(expected))
                                if (target.startsWith("META-INF/services/")) {
                                    val providers = expected.decodeToString().lineSequence().map { it.substringBefore('#').trim() }.filter(String::isNotEmpty).toList()
                                    check(providers.isNotEmpty())
                                    put("providers", JsonArray(providers.map { provider ->
                                        val entry = provider.replace('.', '/') + ".class"
                                        val sourceBytes = when { entry in injected.values -> bytes(inject, prefix+entry); entry in universalNames -> bytes(uni, entry); else -> null }
                                        check(sourceBytes != null) { "No official overlay definition for service provider $provider" }
                                        val actualBytes = checkNotNull(bytes(actual, entry))
                                        check(sourceBytes.contentEquals(actualBytes)) { "Service provider bytes differ: $entry" }
                                        buildJsonObject { put("name", provider); put("entry", entry); put("expected", definition(sourceBytes)); put("actual", definition(actualBytes)) }
                                    }))
                                }
                            }
                            check(collisions.isNotEmpty() || universalOnly.isNotEmpty())
                            write(root.resolve("resource-witnesses.json"), JsonArray(
                                cleanOnly.map { resource("clean-only", clean, it) } +
                                    collisions.map { resource("universal-collision", uni, it) } + universalOnly.map { resource("universal-only", uni, it) } +
                                    transformedResources.map { resource("official-complete-patch-mcinject-at", expectedPatched, it) } +
                                    injected.entries.sortedBy { it.value }.map { resource("userdev-inject", inject, it.key, it.value) },
                            ))
                        } } }
                    }
                }
            }
        }
    }

    private fun witnessesNeo121(sample: Path, root: Path) {
        val ref = sample.resolve("reference"); val prep = sample.resolve("prepare")
        val rows = fileRows(ref.resolve("evidence/files.tsv"))
        val patch = patches(artifact(rows, "neo121ReferenceTools:net.minecraftforge:binarypatcher:"), ref.resolve("evidence/joined.lzma"))
        check(patch.isNotEmpty())
        val officialToObf = Files.readAllLines(artifact(rows, "client_mappings")).filter { !it.startsWith(' ') && it.endsWith(':') && " -> " in it }
            .associate { line -> line.removeSuffix(":").split(" -> ").let { it[0].replace('.', '/') to it[1].replace('.', '/') } }
        val merged = Files.readAllLines(ref.resolve("output/stages/merged-mappings.tsrg"))
        val mergedClasses = merged.filter { it.isNotEmpty() && !it[0].isWhitespace() && !it.startsWith("tsrg2 ") }.map { it.split(' ') }
        check(mergedClasses.isNotEmpty() && officialToObf.isNotEmpty())
        val output = Path.of(Files.readString(prep.resolve("evidence/production-output.txt")).trim())
        ZipFile(ref.resolve("output/stages/clean-rename.jar").toFile()).use { clean ->
            ZipFile(ref.resolve("output/stages/patch-official.jar").toFile()).use { sparse ->
                ZipFile(ref.resolve("output/reference-clean-at.jar").toFile()).use { expectedClean ->
                    ZipFile(ref.resolve("output/reference-patched-at.jar").toFile()).use { expectedPatched ->
                        ZipFile(artifact(rows, "neo121Universal:").toFile()).use { uni -> ZipFile(output.toFile()).use { actual ->
                            val cleanNames = names(clean); val sparseNames = names(sparse); val overlays = names(uni)
                            write(root.resolve("patch-records.json"), JsonArray(patch.map { p -> buildJsonObject {
                                put("entry", p.entry); put("obf", p.obf); put("srg", p.srg); put("exists", p.exists)
                                put("adler32", Integer.toUnsignedLong(p.checksum)); put("diffLength", p.length); put("deleted", p.length == 0)
                            } }))
                            val candidates = patch.filter { p -> p.exists && p.length > 0 && p.obf in officialToObf && "${p.obf}.class" in cleanNames &&
                                "${p.obf}.class" !in overlays && "${p.obf}.class" in sparseNames }
                                .filter { p -> !checkNotNull(bytes(clean, "${p.obf}.class")).contentEquals(checkNotNull(bytes(sparse, "${p.obf}.class"))) }
                                .filter { p -> semantic(checkNotNull(bytes(expectedClean, "${p.obf}.class"))) != semantic(checkNotNull(bytes(expectedPatched, "${p.obf}.class"))) }
                                .sortedBy { it.obf }
                            Files.writeString(root.resolve("patched-candidates.tsv"), candidates.joinToString("\n") { "${it.obf}\t${officialToObf.getValue(it.obf)}\t${it.entry}" })
                            check(candidates.isNotEmpty()) { "No changed official patch witness outside overlays" }
                            val patchNames = patch.flatMap { listOf(it.obf, it.srg) }.toSet()
                            val related = candidates.asSequence().mapNotNull { p -> references(checkNotNull(bytes(expectedPatched, "${p.obf}.class"))).firstOrNull { name ->
                                name in officialToObf && name !in patchNames && "$name.class" !in overlays &&
                                    bytes(expectedClean, "$name.class")?.let { ClassReader(it).access and 0x0200 != 0 } == true
                            }?.let { p to it } }.firstOrNull() ?: error("No concrete patched reference to an unpatched game interface")
                            val witnessDir = Files.createDirectories(root.resolve("witnesses"))
                            val chosen = listOf(candidates.first(), related.first).distinctBy { it.obf }
                            write(root.resolve("class-witnesses.json"), buildJsonObject {
                                put("selection", "Lexical official name: changed existing nondeleted patch outside universal; plus first patched caller of an unpatched game interface")
                                put("patchInputNamespace", "official"); put("mergedMappingsHeader", merged.first()); put("mcinjectCount", 0); put("postPatchRenameCount", 0)
                                put("patched", JsonArray(chosen.map { p ->
                                    val target = p.obf; val obf = officialToObf.getValue(target)
                                    check(mergedClasses.any { it.first() == obf && target in it.drop(1) }) { "Merged mapping is not obf -> official for $target" }
                                    val source = checkNotNull(bytes(clean, "$target.class")); val adler = Adler32().apply { update(source) }.value
                                    check(adler == Integer.toUnsignedLong(p.checksum))
                                    val expected = checkNotNull(bytes(expectedPatched, "$target.class")); val unpatched = checkNotNull(bytes(expectedClean, "$target.class"))
                                    check(ClassReader(expected).className == target && semantic(expected) != semantic(unpatched))
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-patched.class"), expected)
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-clean.class"), unpatched)
                                    buildJsonObject {
                                        put("patchRecord", p.entry); put("patchInputName", p.obf); put("patchSrgField", p.srg); put("target", target); put("obf", obf); put("cleanAdler32", adler)
                                        put("expectedPatched", definition(expected)); put("expectedClean", definition(unpatched)); put("actualTarget", bytes(actual, "$target.class")?.let(::definition) ?: JsonNull)
                                        put("referencesUnpatchedInterface", related.second in references(expected))
                                    }
                                }))
                                put("unpatchedInterface", buildJsonObject {
                                    val target = related.second; val source = checkNotNull(bytes(expectedClean, "$target.class"))
                                    Files.write(witnessDir.resolve("${target.substringAfterLast('/')}-interface-clean.class"), source)
                                    put("target", target); put("obf", officialToObf.getValue(target)); put("patchRecords", 0)
                                    put("expectedDefinitionFromClean", definition(source)); put("actualTarget", bytes(actual, "$target.class")?.let(::definition) ?: JsonNull)
                                })
                                put("finalOutput", output.toString()); put("finalSha256", sha(Files.readAllBytes(output))); put("namespaceCorrectnessAsserted", false)
                            })
                            fun isResource(n: String) = !n.endsWith(".class") && !n.startsWith("META-INF/", true)
                            val resources = cleanNames.filter(::isResource); val sparseResources = sparseNames.filter(::isResource)
                            val universalResources = overlays.filter(::isResource)
                            val cleanOnly = resources.filter { it !in overlays && it !in sparseNames }.sorted()
                            val collisions = universalResources.filter { it in resources || it in sparseResources }.sorted()
                            val universalOnly = universalResources.filter { it !in cleanNames && it !in sparseNames }.sorted()
                            check(resources.isNotEmpty()) { "Neo must have real non-class stage resources" }
                            check(collisions.isNotEmpty() || universalOnly.isNotEmpty())
                            fun resource(origin: String, archive: ZipFile, name: String) = buildJsonObject {
                                val expected = checkNotNull(bytes(archive, name)); val observed = bytes(actual, name)
                                put("origin", origin); put("source", name); put("target", name); put("expectedSha256", sha(expected)); put("actualSha256", observed?.let(::sha) ?: "missing")
                                check(observed != null && expected.contentEquals(observed)) { "$origin differs at $name" }
                            }
                            write(root.resolve("resource-witnesses.json"), JsonArray(cleanOnly.map { resource("clean-only", clean, it) } +
                                collisions.map { resource("universal-collision", uni, it) } + universalOnly.map { resource("universal-only", uni, it) }))
                            val manifest = java.util.jar.Manifest(checkNotNull(bytes(actual, "META-INF/MANIFEST.MF")).inputStream())
                            check(manifest.mainAttributes.getValue("Minecraft-Dists") == "client server")
                            check(manifest.mainAttributes.getValue("Codev-Minecraft-Marker") == "true")
                            ZipFile(Path.of(rows.single { it[0] == "client" }[1]).toFile()).use { client -> ZipFile(ref.resolve("output/stages/extracted-server.jar").toFile()).use { server ->
                                val clientResources = names(client).filter(::isResource).toSet(); val serverResources = names(server).filter(::isResource).toSet()
                                val clientOnly = (clientResources - serverResources).sorted(); val common = (clientResources intersect serverResources).sorted()
                                check(clientOnly.all { manifest.entries[it]?.getValue("Minecraft-Dist") == "client" })
                                write(root.resolve("resource-inventory.json"), buildJsonObject {
                                    put("sample", "MC1.21 / NeoForge21.0.76-beta / NeoForm1.21-20240613.152323"); put("patchInputNamespace", "official")
                                    put("cleanResources", JsonArray(resources.map(::JsonPrimitive))); put("patchResources", JsonArray(sparseResources.map(::JsonPrimitive)))
                                    put("universalResources", JsonArray(universalResources.map(::JsonPrimitive))); put("cleanOnly", JsonArray(cleanOnly.map(::JsonPrimitive)))
                                    put("universalResourceCollisions", JsonArray(collisions.map(::JsonPrimitive))); put("universalOnly", JsonArray(universalOnly.map(::JsonPrimitive)))
                                    put("injectApplicability", "not-applicable: fixed userdev has no inject setting")
                                    put("rawClientResources", JsonArray(clientResources.sorted().map(::JsonPrimitive))); put("rawExtractedServerResources", JsonArray(serverResources.sorted().map(::JsonPrimitive)))
                                    put("rawClientOnlyResources", JsonArray(clientOnly.map(::JsonPrimitive))); put("rawCommonResources", JsonArray(common.map(::JsonPrimitive)))
                                    put("manifestMain", manifest.mainAttributes.toString()); put("clientOnlyResourceDistChecked", true)
                                    put("coverageLosses", "No full class-side correctness or old/new attrs equivalence; no raw resource restoration or cold/hot acceptance.")
                                    put("archives", buildJsonObject { for ((role, archive) in listOf("clean-rename" to clean, "patch-official" to sparse, "reference-clean-at" to expectedClean, "reference-patched-at" to expectedPatched, "universal" to uni, "production-final" to actual)) put(role, buildJsonObject {
                                        put("path", archive.name); put("sha256", sha(Files.readAllBytes(Path.of(archive.name)))); put("nonDirectoryEntries", JsonArray(names(archive).map(::JsonPrimitive)))
                                    }) })
                                })
                            } }
                        } }
                    }
                }
            }
        }
    }
}
