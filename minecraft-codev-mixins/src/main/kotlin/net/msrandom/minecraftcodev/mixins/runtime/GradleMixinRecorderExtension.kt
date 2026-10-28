package net.msrandom.minecraftcodev.mixins.runtime

import kotlinx.serialization.json.*
import kotlinx.serialization.json.decodeFromStream
import org.objectweb.asm.tree.ClassNode
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.extensibility.*
import org.spongepowered.asm.mixin.transformer.Config
import org.spongepowered.asm.mixin.transformer.ext.*
import org.spongepowered.asm.mixin.refmap.*
import java.lang.reflect.Field
import java.io.FileNotFoundException
import java.util.IdentityHashMap
import java.util.SortedSet
import java.util.TreeMap
import java.util.TreeSet

/** Config and corresponding Mixin identities at the engine application callback. */
internal class GradleMixinRecorderExtension @Throws(ReflectiveOperationException::class) constructor(
    registered: List<Config>, originalEntries: Map<String, Set<String>>, private val context: String?
) : IExtension {
    private val entries = IdentityHashMap<IMixinConfig, Set<String>>()
    private val notified = TreeMap<String, MutableSet<String>>()
    private val members: Field

    init {
        for (handle in registered) {
            val config = handle.config
            entries[config] = originalEntries[config.name] ?: emptySet()
        }
        // The released binary exposes the callback identities only through this field.
        members = Class.forName("org.spongepowered.asm.mixin.transformer.TargetClassContext").getDeclaredField("mixins")
        members.isAccessible = true
        if (members.type != SortedSet::class.java) throw IllegalStateException("Unsupported pinned notification surface")
    }

    override fun checkActive(environment: MixinEnvironment): Boolean {
        // Native selection has read the refmap; preparation (including target selectors) has not started.
        for (config in entries.keys) try {
            val field = config.javaClass.getDeclaredField("refMapper")
            field.isAccessible = true
            val mapper = field.get(config) as IReferenceMapper?
            if (mapper is SelectedContext) continue
            val selected = context ?: environment.refmapObfuscationContext
            if (mapper == null || mapper.isDefault) {
                if (context != null) throw IllegalArgumentException("Requested refmap context without a usable refmap: $context")
                continue
            }
            val name = mapper.resourceName
            val loader = Thread.currentThread().contextClassLoader
            val json = loader.getResourceAsStream(name)?.use { Json.decodeFromStream<JsonObject>(it) } ?: throw FileNotFoundException(name)
            val contexts = if (json.containsKey("data")) json.getValue("data").jsonObject else JsonObject(emptyMap())
            if (context != null && !contexts.containsKey(context)) throw IllegalArgumentException("Unknown refmap context: $context in $name")
            if ((selected == null || !contexts.containsKey(selected)) && contexts.size > 1 && (!json.containsKey("mappings") || json.getValue("mappings").jsonObject.isEmpty()))
                throw IllegalArgumentException("Refmap requires an explicit context: $name")
            if (context != null) field.set(config, SelectedContext(mapper, context))
        } catch (failure: Exception) {
            throw IllegalStateException("Cannot select refmap context for ${config.name}", failure)
        }
        return true
    }

    private class SelectedContext(private val delegate: IReferenceMapper, private val selected: String) : IReferenceMapper, IClassReferenceMapper {
        override fun isDefault(): Boolean = delegate.isDefault
        override fun getResourceName(): String? = delegate.resourceName
        override fun getStatus(): String? = delegate.status
        override fun getContext(): String = selected
        override fun setContext(ignored: String?) {}
        override fun remap(owner: String?, reference: String?): String? = delegate.remapWithContext(selected, owner, reference)
        override fun remapWithContext(ignored: String?, owner: String?, reference: String?): String? = remap(owner, reference)
        override fun remapClassName(owner: String?, name: String?): String? =
            if (delegate is IClassReferenceMapper) delegate.remapClassNameWithContext(selected, owner, name) else name
        override fun remapClassNameWithContext(ignored: String?, owner: String?, name: String?): String? = remapClassName(owner, name)
    }

    override fun preApply(context: ITargetClassContext) {}
    override fun postApply(context: ITargetClassContext) {
        for (value in members.get(context) as Collection<*>) {
            val mixin = value as IMixinInfo
            if (entries[mixin.config]?.contains(mixin.name) == true) {
                notified.getOrPut(mixin.config.name) { TreeSet() }.add(mixin.name)
            }
        }
    }
    override fun export(environment: MixinEnvironment, name: String, force: Boolean, node: ClassNode) {}
    fun notifications(): Map<String, Set<String>> = notified
}
