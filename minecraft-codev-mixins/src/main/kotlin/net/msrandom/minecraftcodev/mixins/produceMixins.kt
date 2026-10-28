package net.msrandom.minecraftcodev.mixins

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.*
import java.io.Closeable
import java.lang.reflect.InvocationTargetException
import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes
import kotlin.io.path.outputStream

private val activeMixinOutputs = mutableSetOf<Path>()

/** Only participating Codev initializers share this JVM monitor; transformation is deliberately outside it. */
internal fun initializeMixinRuntime(loader: ClassLoader) {
    synchronized("net.msrandom.minecraftcodev.mixins.native-initialization".intern()) {
        val selectors = listOf("mixin.service", "mixin.bootstrapService")
        val previous = selectors.map { System.getProperty(it) }
        Closeable {
            var restoration: Throwable? = null
            for (index in selectors.indices) try {
                val value = previous[index]
                if (value == null) System.clearProperty(selectors[index]) else System.setProperty(selectors[index], value)
            } catch (error: Throwable) {
                if (restoration == null) restoration = error else restoration.addSuppressed(error)
            }
            // Keep restoration failures grouped when use suppresses them onto an initialization failure.
            if (restoration != null) throw restoration
        }.use {
            System.setProperty(selectors[0], "net.msrandom.minecraftcodev.mixins.runtime.IsolatedMixinService")
            System.setProperty(selectors[1], "net.msrandom.minecraftcodev.mixins.runtime.IsolatedMixinServiceBootstrap")
            try {
                loader.loadClass("net.msrandom.minecraftcodev.mixins.runtime.ApplyMixinsKt")
                    .getMethod("initializeMixins").invoke(null)
            } catch (wrapped: InvocationTargetException) { throw wrapped.cause ?: wrapped }
        }
    }
}

/** The two Mixin files share one producer lifetime, not a multi-file transaction. */
@OptIn(ExperimentalSerializationApi::class)
@JvmOverloads
fun produceMixins(input: String, sources: List<String>, runtime: List<String>, side: String,
    output: String, appliedMixins: String, mappingFile: String? = null, sourceNamespace: String? = null,
    targetNamespace: String? = null, refmapContext: String? = null) {
    val implementation = implementationInputs()
    val inputs = (runtime + sources + implementation + listOfNotNull(input, mappingFile)).map { mixinDestination(Paths.get(it).toAbsolutePath().normalize()) }
    fun outputDestination(name: String): Path {
        val path = Paths.get(name).toAbsolutePath().normalize()
        require(!Files.isSymbolicLink(path)) { "Symbolic Mixin output: $path" }
        val destination = mixinDestination(path)
        for (protected in inputs) require(destination != protected &&
            !(Files.isDirectory(protected) && destination.startsWith(protected)) &&
            !(Files.exists(destination) && Files.exists(protected) && Files.isSameFile(destination, protected))) {
            "Output overlaps an input: $path -> $protected"
        }
        require(!Files.isDirectory(destination)) { "Mixin output is a directory: $path" }
        return destination
    }
    val outputJar = outputDestination(output)
    val recordsFile = outputDestination(appliedMixins)
    val outputs = listOf(outputJar, recordsFile)
    fun same(first: Path, second: Path) = first == second ||
        (Files.exists(first) && Files.exists(second) && Files.isSameFile(first, second))
    require(!same(outputJar, recordsFile)) { "Overlapping Mixin outputs: $outputs" }
    synchronized(activeMixinOutputs) {
        require(outputs.none { destination -> activeMixinOutputs.any { same(it, destination) } }) { "Mixin output is in use: $outputs" }
        activeMixinOutputs.addAll(outputs)
    }
    val staged = mutableListOf<Path>()
    var failure: Throwable? = null
    var invalidated = false
    var stage = "output preparation"
    var configs: List<String> = emptyList()
    try {
        outputs.forEach { Files.createDirectories(it.parent) }
        // Identity checks and exclusive ownership precede invalidating this producer's old result.
        invalidated = true
        outputs.asReversed().forEach { Files.deleteIfExists(it) }
        stage = "input availability"
        inputs.forEach { it.toRealPath() }
        val stagedJar = Files.createTempFile(outputJar.parent, ".codev-mixin-", ".tmp").also { staged.add(it) }
        val stagedRecords = Files.createTempFile(recordsFile.parent, ".codev-mixin-", ".tmp").also { staged.add(it) }
        stage = "discovery"
        val environments = linkedMapOf<String, MutableSet<String>>()
        configs = discoverMixinConfigs(input, sources, environments)
        stage = "runtime"
        val thread = Thread.currentThread()
        val previous = thread.contextClassLoader
        val notifications = try {
            IsolatingMixinClassLoader(
                implementation.map { Paths.get(it).toUri().toURL() }.toTypedArray(),
                (runtime + sources + input).map { Paths.get(it).toUri().toURL() }.toTypedArray()
            ).use { loader ->
                thread.contextClassLoader = loader
                stage = "runtime initialization/selector restoration"
                initializeMixinRuntime(loader)
                stage = "runtime"
                val result = invokeApplyMixins(loader, input, stagedJar.toString(), side, configs, environments,
                    mappingFile, sourceNamespace, targetNamespace, refmapContext)
                stage = "runtime exit/close"
                result
            }
        } finally { thread.contextClassLoader = previous }
        stage = "notification file write/close"
        val json = buildJsonObject {
            for ((path, entries) in notifications) put(path, JsonArray(entries.map { JsonPrimitive(it) }))
        }
        stagedRecords.outputStream().use { Json.encodeToStream(json, it) }
        stage = "output completion"
        Files.move(stagedJar, outputJar, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING)
        Files.move(stagedRecords, recordsFile, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING)
    } catch (error: Throwable) {
        failure = error
        System.err.println("Codev Mixin failed: stage=$stage target=$input configs=$configs mixin=unknown cause=$error")
        throw error
    } finally {
        var cleanupFailure: Throwable? = null
        for (path in staged) try { Files.deleteIfExists(path) } catch (error: Throwable) {
            if (cleanupFailure == null) cleanupFailure = error else cleanupFailure.addSuppressed(error)
        }
        try {
            if (invalidated && (failure != null || cleanupFailure != null)) for (path in outputs.asReversed()) {
                try { Files.deleteIfExists(path) } catch (error: Throwable) {
                    if (cleanupFailure == null) cleanupFailure = error else cleanupFailure.addSuppressed(error)
                }
            }
        } finally { synchronized(activeMixinOutputs) { activeMixinOutputs.removeAll(outputs.toSet()) } }
        if (cleanupFailure != null) {
            if (failure != null) failure.addSuppressed(cleanupFailure) else throw cleanupFailure
        }
    }
}

@Suppress("UNCHECKED_CAST")
private fun invokeApplyMixins(
    loader: ClassLoader,
    input: String,
    output: String,
    side: String,
    configs: List<String>,
    environments: Map<String, Set<String>>,
    mappingFile: String?,
    sourceNamespace: String?,
    targetNamespace: String?,
    refmapContext: String?
): Map<String, Set<String>> = try {
    loader.loadClass("net.msrandom.minecraftcodev.mixins.runtime.ApplyMixinsKt")
        .getMethod("applyMixins", String::class.java, String::class.java, String::class.java,
            List::class.java, Map::class.java, String::class.java, String::class.java, String::class.java, String::class.java)
        .invoke(null, input, output, side, configs, environments,
            mappingFile, sourceNamespace, targetNamespace, refmapContext) as Map<String, Set<String>>
} catch (wrapped: InvocationTargetException) { throw wrapped.cause ?: wrapped }

internal fun mixinDestination(path: Path): Path {
    var ancestor = path
    val suffix = ArrayDeque<Path>()
    while (true) {
        try {
            var real = ancestor.toRealPath()
            for (part in suffix) real = real.resolve(part)
            return real
        } catch (missing: NoSuchFileException) {
            try { Files.readAttributes(ancestor, BasicFileAttributes::class.java, LinkOption.NOFOLLOW_LINKS) }
            catch (absent: NoSuchFileException) {
                suffix.addFirst(ancestor.fileName ?: throw missing)
                ancestor = ancestor.parent ?: throw missing
                continue
            }
            throw missing
        }
    }
}
