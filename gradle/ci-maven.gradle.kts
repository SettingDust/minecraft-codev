import java.nio.file.Files
import java.nio.file.LinkOption.NOFOLLOW_LINKS
import java.nio.file.attribute.BasicFileAttributes
import java.security.MessageDigest
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.GenerateMavenPom
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository
import org.gradle.api.publish.tasks.GenerateModuleMetadata
import org.w3c.dom.Element

// Gradle owns payload and metadata generation; this script only seeds and validates the tree.
fun filesIn(directory: File): Map<String, File> {
    if (!directory.exists()) return emptyMap()
    check(directory.isDirectory) { "Not a repository directory: $directory" }
    return directory.walkTopDown().onEnter {
        val attributes = Files.readAttributes(it.toPath(), BasicFileAttributes::class.java, NOFOLLOW_LINKS)
        check(!attributes.isSymbolicLink && !attributes.isOther) { "Repository link/special file: $it" }
        true
    }.filter {
        val attributes = Files.readAttributes(it.toPath(), BasicFileAttributes::class.java, NOFOLLOW_LINKS)
        check(!attributes.isSymbolicLink && !attributes.isOther) { "Repository link/special file: $it" }
        check(attributes.isDirectory || attributes.isRegularFile) { "Not a regular repository file: $it" }
        attributes.isRegularFile
    }.associateBy { it.relativeTo(directory).invariantSeparatorsPath }
}

fun sameTree(left: File, right: File): Boolean {
    val a = filesIn(left)
    val b = filesIn(right)
    return a.keys == b.keys && a.all { (path, file) -> Files.mismatch(file.toPath(), b.getValue(path).toPath()) == -1L }
}

fun xml(file: File): Element {
    val factory = DocumentBuilderFactory.newInstance()
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")
    return factory.newDocumentBuilder().parse(file).documentElement
}

fun Element.text(name: String): String = (0 until childNodes.length)
    .map { childNodes.item(it) }.filterIsInstance<Element>().singleOrNull { it.tagName == name }?.textContent.orEmpty()

fun checkedFile(file: File) {
    check(file.isFile && file.length() > 0) { "Missing/empty publication output: $file" }
    listOf("md5" to "MD5", "sha1" to "SHA-1", "sha256" to "SHA-256", "sha512" to "SHA-512").forEach { (suffix, algorithm) ->
        val sidecar = File("${file.path}.$suffix")
        val digest = MessageDigest.getInstance(algorithm)
        file.inputStream().use { input ->
            val buffer = ByteArray(65536)
            while (true) {
                val count = input.read(buffer)
                if (count < 0) break
                digest.update(buffer, 0, count)
            }
        }
        val expected = digest.digest().joinToString("") { "%02x".format(it) }
        check(sidecar.isFile && sidecar.readText().trim().equals(expected, ignoreCase = true)) { "Invalid/missing checksum: $sidecar" }
    }
}

data class CiPublication(val owner: Project, val publication: MavenPublication, val task: PublishToMavenRepository) {
    val gav get() = "${publication.groupId}:${publication.artifactId}:${publication.version}"
    val artifactPath get() = "${publication.groupId.replace('.', '/')}/${publication.artifactId}"
    val versionPath get() = "$artifactPath/${publication.version}"
    val snapshot get() = publication.version.endsWith("-SNAPSHOT")
}

val publications = mutableListOf<CiPublication>()
var base: File? = null
var output: File? = null
var initialized = false
var verified = false

fun safeDirectory(property: String): File {
    val raw = providers.gradleProperty(property).orNull ?: error("Required -P$property=<absolute-directory>")
    val file = File(raw)
    check(file.isAbsolute) { "$property must be absolute" }
    var cursor: File? = file.absoluteFile
    while (cursor != null) {
        if (Files.exists(cursor.toPath(), NOFOLLOW_LINKS)) {
            val attributes = Files.readAttributes(cursor.toPath(), BasicFileAttributes::class.java, NOFOLLOW_LINKS)
            check(!attributes.isSymbolicLink && !attributes.isOther) { "$property must not traverse links: $cursor" }
        }
        cursor = cursor.parentFile
    }
    val resolved = file.canonicalFile
    val source = rootDir.canonicalFile.toPath()
    val local = File(System.getProperty("maven.repo.local", "${System.getProperty("user.home")}/.m2/repository")).canonicalFile.toPath()
    val path = resolved.toPath()
    check(path.parent != null && !path.startsWith(source) && !source.startsWith(path) && !path.startsWith(local) && !local.startsWith(path)) {
        "$property must be outside the checkout and mavenLocal: $resolved"
    }
    return resolved
}

val initializeCiMavenRepository = tasks.register("initializeCiMavenRepository") {
    doLast {
        check(publications.isNotEmpty()) { "No Maven publications discovered" }
        base = safeDirectory("ciMavenBase")
        output = safeDirectory("ciMavenOutput")
        val seed = base!!
        val candidate = output!!
        check(!seed.toPath().startsWith(candidate.toPath()) && !candidate.toPath().startsWith(seed.toPath())) { "Base/output must be distinct and non-overlapping" }
        check(seed.isDirectory) { "Immutable base must exist (an empty directory for first publication): $seed" }
        check(!candidate.exists() || (candidate.isDirectory && candidate.listFiles()!!.isEmpty())) { "Output must be absent or empty: $candidate" }
        filesIn(seed) // Reject links before copying or deleting anything.
        publications.forEach { entry ->
            val p = entry.publication
            check(p.groupId.split('.').all { it.matches(Regex("[A-Za-z0-9_-]+")) } &&
                listOf(p.artifactId, p.version).all { it.matches(Regex("[A-Za-z0-9_][A-Za-z0-9_.+-]*")) }) { "Unsafe Maven coordinate: ${entry.gav}" }
            logger.lifecycle("CI_MAVEN ${entry.owner.path} | ${p.name} | ${entry.gav} | ${entry.task.path} | ${entry.versionPath}")
        }
        check(candidate.mkdirs() || candidate.isDirectory)
        initialized = true
        seed.copyRecursively(candidate, overwrite = false)
        publications.filterNot { it.snapshot }.map { it.versionPath }.distinct().forEach { path ->
            check(candidate.resolve(path).deleteRecursively()) { "Cannot clear release directory: $path" }
        }
    }
}

val prepareCiMavenRepository = tasks.register("prepareCiMavenRepository") {
    dependsOn(initializeCiMavenRepository)
    group = "publishing"
    description = "Prepare and validate the complete ciMaven tree against an immutable base."
    doLast {
        val seed = base!!
        val candidate = output!!
        check(filesIn(candidate).isNotEmpty()) { "Empty candidate Maven tree" }
        publications.forEach { entry ->
            val p = entry.publication
            try {
                check(entry.task.state.executed && !entry.task.state.skipped) { "Publication did not execute: ${entry.task.path}" }
                val artifactDir = candidate.resolve(entry.artifactPath)
                val versionDir = candidate.resolve(entry.versionPath)
                val index = artifactDir.resolve("maven-metadata.xml")
                checkedFile(index)
                val indexXml = xml(index)
                check(indexXml.tagName == "metadata" && indexXml.text("groupId") == p.groupId && indexXml.text("artifactId") == p.artifactId) { "Invalid artifact metadata: $index" }
                val versions = indexXml.getElementsByTagName("version")
                check((0 until versions.length).any { versions.item(it).textContent == p.version }) { "Version absent from metadata: ${entry.gav}" }
                val oldIndex = seed.resolve("${entry.artifactPath}/maven-metadata.xml")
                if (oldIndex.isFile) {
                    val oldVersions = xml(oldIndex).getElementsByTagName("version")
                    check((0 until oldVersions.length).all { old -> (0 until versions.length).any { versions.item(it).textContent == oldVersions.item(old).textContent } }) { "Lost historical versions: ${entry.gav}" }
                }
                val snapshotValues = mutableMapOf<Pair<String, String>, String>()
                if (entry.snapshot) {
                    val metadata = versionDir.resolve("maven-metadata.xml")
                    checkedFile(metadata)
                    val metadataXml = xml(metadata)
                    check(metadataXml.text("groupId") == p.groupId && metadataXml.text("artifactId") == p.artifactId && metadataXml.text("version") == p.version) { "Invalid snapshot metadata: $metadata" }
                    val nodes = metadataXml.getElementsByTagName("snapshotVersion")
                    for (i in 0 until nodes.length) {
                        val node = nodes.item(i) as Element
                        val value = node.text("value")
                        check(value.matches(Regex("[A-Za-z0-9_][A-Za-z0-9_.+-]*"))) { "Invalid native snapshot value: $value" }
                        snapshotValues[node.text("extension") to node.text("classifier")] = value
                    }
                    check(snapshotValues.isNotEmpty()) { "Empty snapshot versions: $metadata" }
                }
                fun payload(extension: String, classifier: String = ""): File {
                    val version = if (entry.snapshot) snapshotValues[extension to classifier] ?: error("Missing snapshot artifact $extension/$classifier: ${entry.gav}") else p.version
                    return versionDir.resolve("${p.artifactId}-$version${if (classifier.isEmpty()) "" else "-$classifier"}.$extension")
                }
                val expected = mutableListOf<Pair<File, File>>()
                p.artifacts.forEach { artifact -> expected += payload(artifact.extension, artifact.classifier.orEmpty()) to artifact.file }
                val capitalized = p.name.replaceFirstChar { it.uppercaseChar() }
                val pomTask = entry.owner.tasks.named("generatePomFileFor${capitalized}Publication", GenerateMavenPom::class.java).get()
                expected += payload("pom") to pomTask.destination
                val moduleTask = entry.owner.tasks.findByName("generateMetadataFileFor${capitalized}Publication") as? GenerateModuleMetadata
                if (moduleTask != null && moduleTask.state.executed && moduleTask.enabled && (!moduleTask.state.skipped || moduleTask.state.upToDate)) {
                    expected += payload("module") to moduleTask.outputFile.get().asFile
                }
                expected.forEach { (published, original) ->
                    checkedFile(published)
                    check(original.isFile && Files.mismatch(published.toPath(), original.toPath()) == -1L) { "Incorrect publication artifact: $published" }
                    logger.lifecycle("CI_MAVEN_ARTIFACT ${entry.gav} | ${published.relativeTo(candidate).invariantSeparatorsPath}")
                }
                val pom = xml(payload("pom"))
                check(pom.tagName == "project" && pom.text("groupId") == p.groupId && pom.text("artifactId") == p.artifactId && pom.text("version") == p.version) { "Invalid POM: ${entry.gav}" }
            } catch (failure: Exception) {
                val suffix = if (!entry.snapshot && seed.resolve(entry.versionPath).exists()) "; existing release requires a version increase" else ""
                throw GradleException("Invalid publication ${entry.gav}$suffix: ${failure.message}", failure)
            }
        }
        publications.filterNot { it.snapshot }.distinctBy { it.versionPath }.forEach { entry ->
            val old = seed.resolve(entry.versionPath)
            if (old.exists()) {
                check(sameTree(old, candidate.resolve(entry.versionPath))) { "Release conflict ${entry.gav}: complete paths/bytes differ; a version increase is required" }
            }
        }
        // Only native metadata and current version payloads may change; retain everything else byte-for-byte.
        val releasePaths = publications.filterNot { it.snapshot }.map { "${it.versionPath}/" }
        val mutableMetadata = publications.flatMap { entry ->
            listOf("${entry.artifactPath}/maven-metadata.xml") + if (entry.snapshot) listOf("${entry.versionPath}/maven-metadata.xml") else emptyList()
        }.toSet()
        filesIn(seed).forEach { (path, original) ->
            val metadata = mutableMetadata.any { path == it || path in listOf("$it.md5", "$it.sha1", "$it.sha256", "$it.sha512") }
            if (!metadata && releasePaths.none { path.startsWith(it) }) {
                val retained = candidate.resolve(path)
                check(retained.isFile && Files.mismatch(original.toPath(), retained.toPath()) == -1L) { "Lost/changed historical file: $path" }
            }
        }
        verified = true
        logger.lifecycle("CI_MAVEN_READY ${publications.size} publications in $candidate")
    }
}

allprojects {
    pluginManager.withPlugin("maven-publish") {
        extensions.configure<PublishingExtension> {
            repositories.maven {
                name = "ciMaven"
                url = uri(providers.gradleProperty("ciMavenOutput").orElse(layout.buildDirectory.dir("unused-ci-maven").map { it.asFile.absolutePath }))
            }
        }
    }
}

gradle.projectsEvaluated {
    allprojects.forEach { owner ->
        val publishing = owner.extensions.findByType(PublishingExtension::class.java) ?: return@forEach
        publishing.publications.withType(MavenPublication::class.java).forEach { publication ->
            val matches = owner.tasks.withType(PublishToMavenRepository::class.java).filter { it.repository.name == "ciMaven" && it.publication == publication }
            check(matches.size == 1) { "Expected exactly one ciMaven task for ${owner.path}:${publication.name}" }
            matches.single().dependsOn(initializeCiMavenRepository)
            publications += CiPublication(owner, publication, matches.single())
        }
    }
    prepareCiMavenRepository.configure { dependsOn(publications.map { it.task }) }
}

gradle.taskGraph.whenReady {
    if (hasTask(prepareCiMavenRepository.get()) || hasTask(initializeCiMavenRepository.get())) {
        check(!gradle.startParameter.isConfigurationCacheRequested && !gradle.startParameter.isConfigureOnDemand) {
            "ciMaven requires --no-configuration-cache --no-configure-on-demand"
        }
    }
}

gradle.buildFinished {
    // A failed/partial preparation is never a consumable candidate (including a failed publication dependency).
    if (initialized && (!verified || failure != null)) {
        check(output!!.deleteRecursively()) { "Cannot discard failed Maven candidate: $output" }
    }
}
