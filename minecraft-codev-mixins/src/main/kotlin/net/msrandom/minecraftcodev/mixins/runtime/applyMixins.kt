package net.msrandom.minecraftcodev.mixins.runtime

import kotlinx.serialization.json.*
import kotlinx.serialization.json.decodeFromStream
import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import org.spongepowered.asm.util.Annotations
import org.spongepowered.asm.transformers.MixinClassReader
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.*
import org.spongepowered.asm.mixin.transformer.ext.Extensions
import org.spongepowered.asm.service.MixinService
import org.spongepowered.asm.service.IGlobalPropertyService
import java.lang.reflect.Modifier
import java.io.FileNotFoundException
import java.nio.file.Paths
import java.util.ArrayDeque
import java.util.ArrayList
import java.util.HashSet
import java.util.LinkedHashMap
import java.util.Locale
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import kotlin.io.path.outputStream

private fun active(environments: Set<String>, side: String): Boolean {
    if (environments.contains("*")) return true
    if (side != "CLIENT" && side != "SERVER") throw IllegalArgumentException("Explicit config environment requires a known operation side")
    return environments.contains(side.lowercase(Locale.ROOT))
}

/** Called by the host under the shared selector window, before any other child engine initialization. */
fun initializeMixins() {
    MixinService.boot()
    // The pinned engine has no property-service selector; install its child cache before GlobalProperties reads it.
    val owner = MixinService::class.java.declaredFields.single { Modifier.isStatic(it.modifiers) && it.type == MixinService::class.java }
    owner.isAccessible = true
    val properties = MixinService::class.java.declaredFields.single { it.type == IGlobalPropertyService::class.java }
    properties.isAccessible = true
    properties.set(owner.get(null), IsolatedMixinGlobalPropertyService())
    MixinService.getService()
    MixinBootstrap.init()
}

/** Only JDK values cross the operation boundary. */
@Throws(Exception::class)
fun applyMixins(input: String, output: String, side: String, discovered: List<String>, sides: Map<String, Set<String>>,
    mappingFile: String?, sourceNamespace: String?, targetNamespace: String?, context: String?): Map<String, Set<String>> {
    val configs = discovered.filter { active(sides.getValue(it), side) }
    val selectedSide = MixinEnvironment.Side.valueOf(side)
    val remapper = if (mappingFile != null || sourceNamespace != null || targetNamespace != null)
        TinyMappingRemapper(mappingFile, sourceNamespace, targetNamespace) else null
    if (context != null && context.isBlank()) throw IllegalArgumentException("Empty refmap context")
    val originalEntries = readOriginalEntries(configs, Thread.currentThread().contextClassLoader)
    val phase = MixinEnvironment::class.java.getDeclaredMethod("gotoPhase", MixinEnvironment.Phase::class.java)
    phase.isAccessible = true
    phase.invoke(null, MixinEnvironment.Phase.DEFAULT)
    val environment = MixinEnvironment.getCurrentEnvironment()
    environment.side = selectedSide
    if (context != null) environment.obfuscationContext = context
    if (remapper != null) {
        environment.setOption(MixinEnvironment.Option.REFMAP_REMAP, true)
        environment.remappers.add(remapper)
    }
    for (config in configs) Mixins.addConfiguration(config)
    val recorder = GradleMixinRecorderExtension(ArrayList(Mixins.getConfigs()), originalEntries, context)
    val transformer = (MixinService.getService() as IsolatedMixinService).transformer()
    (transformer.extensions as Extensions).add(recorder)
    JarFile(input).use { source ->
        JarOutputStream(Paths.get(output).outputStream()).use { destination ->
            for (entry in source.entries().toList().sortedBy { it.name }) {
                require(entry.name.isNotBlank() && entry.name.none { it < ' ' } && !entry.name.startsWith("/") && !entry.name.contains('\\') && !entry.name.contains(':') && entry.name.split('/').none { it == "." || it == ".." }) { "Unsafe archive path: ${entry.name}" }
                val copy = JarEntry(entry.name).apply { time = 0 }
                if (entry.name.endsWith(".class")) {
                    val bytes = source.getInputStream(entry).use { it.readAllBytes() }
                    val name = entry.name.removeSuffix(".class").replace('/', '.')
                    val transformed = try {
                        val node = ClassNode()
                        MixinClassReader(bytes, name).accept(node, ClassReader.SKIP_CODE or ClassReader.SKIP_DEBUG or ClassReader.SKIP_FRAMES)
                        // Archive Mixin definitions are inputs, not runtime classload requests (including inactive definitions).
                        if (Annotations.getInvisible(node, Mixin::class.java) != null) bytes
                        else transformer.transformClassBytes(name, name, bytes)
                    } catch (failure: Throwable) {
                        System.err.println("Codev Mixin transform failed: target=$name cause=$failure")
                        throw failure
                    }
                    destination.putNextEntry(copy)
                    destination.write(transformed)
                } else {
                    destination.putNextEntry(copy)
                    source.getInputStream(entry).use { it.copyTo(destination) }
                }
                destination.closeEntry()
            }
        }
    }
    return recorder.notifications()
}

// Read original keys through the same ordered task domain as native registration.
private fun readOriginalEntries(configs: List<String>, loader: ClassLoader): Map<String, Set<String>> {
    val pending = ArrayDeque(configs)
    val originalEntries = LinkedHashMap<String, Set<String>>()
    while (pending.isNotEmpty()) {
        val path = pending.removeFirst()
        if (originalEntries.containsKey(path)) continue
        val config = loader.getResourceAsStream(path)?.use { Json.decodeFromStream<JsonObject>(it) }
            ?: throw FileNotFoundException(path)
        val raw = hashSetOf<String>()
        for (section in listOf("mixins", "client", "server")) if (config.containsKey(section)) {
            for (entry in config.getValue(section).jsonArray) {
                mixinName(config, entry)
                raw.add((entry as JsonPrimitive).content)
            }
        }
        originalEntries[path] = raw
        if (config.containsKey("parent")) pending.addLast(configString(config, "parent"))
    }
    return originalEntries
}

internal fun configString(config: JsonObject, name: String): String {
    val value = config.getValue(name) as? JsonPrimitive
    require(value != null && value.isString) { "Invalid config string: $name" }
    return value.content
}

internal fun mixinName(config: JsonObject, member: JsonElement): String {
    require(member is JsonPrimitive && member.isString) { "Invalid mixin entry" }
    val raw = member.content
    require(raw.isNotBlank() && raw.none { it < ' ' }) { "Invalid original Mixin string" }
    val prefix = if (config.containsKey("package")) configString(config, "package") else ""
    return (if (prefix.isEmpty()) "" else "$prefix.") + raw
}
