package net.msrandom.minecraftcodev.mixins.runtime

import net.fabricmc.mappingio.MappingReader
import net.fabricmc.mappingio.tree.MemoryMappingTree
import net.fabricmc.mappingio.tree.MappingTreeView
import org.spongepowered.asm.mixin.extensibility.IRemapper
import java.nio.file.Files
import java.nio.file.Paths

/** Exact source-entry lookup; deliberately does not infer inheritance or nullable-descriptor matches. */
class TinyMappingRemapper @Throws(Exception::class) constructor(file: String?, sourceNamespace: String?, targetNamespace: String?) : IRemapper {
    private val tree = MemoryMappingTree()
    private val source: Int
    private val target: Int
    init {
        if (file == null || sourceNamespace.isNullOrBlank() || targetNamespace.isNullOrBlank())
            throw IllegalArgumentException("Incomplete mapping tuple: file/sourceNamespace/targetNamespace required")
        val path = Paths.get(file)
        if (!Files.isRegularFile(path) || !Files.isReadable(path)) throw IllegalArgumentException("Unreadable mapping file: $path")
        MappingReader.read(path, tree)
        source = tree.getNamespaceId(sourceNamespace)
        target = tree.getNamespaceId(targetNamespace)
        if (source == MappingTreeView.NULL_NAMESPACE_ID || target == MappingTreeView.NULL_NAMESPACE_ID)
            throw IllegalArgumentException("Unknown mapping namespace: $sourceNamespace -> $targetNamespace")
    }
    private fun member(owner: String?, name: String?, descriptor: String?, field: Boolean): String? {
        if (name == null) return null
        var match: MappingTreeView.MemberMappingView? = null
        // shortcut: linear scan of supplied members; index only if mapping lookup profiling warrants it.
        for (cls in tree.classes) {
            if (owner != null && owner != cls.getName(source)) continue
            for (candidate in if (field) cls.fields else cls.methods) {
                if (name != candidate.getName(source) || descriptor != null && descriptor != candidate.getDesc(source)) continue
                if (match != null) {
                    System.err.println("Ambiguous mapping selector: $owner/$name$descriptor; passthrough")
                    return name
                }
                match = candidate
            }
        }
        return match?.getName(target) ?: name
    }
    override fun mapMethodName(owner: String?, name: String?, descriptor: String?): String? = member(owner, name, descriptor, false)
    override fun mapFieldName(owner: String?, name: String?, descriptor: String?): String? = member(owner, name, descriptor, true)
    override fun map(name: String?): String? = name?.let { tree.mapClassName(it, source, target) }
    override fun unmap(name: String?): String? = name?.let { tree.mapClassName(it, target, source) }
    override fun mapDesc(descriptor: String?): String? = descriptor?.let { tree.mapDesc(it, source, target) }
    override fun unmapDesc(descriptor: String?): String? = descriptor?.let { tree.mapDesc(it, target, source) }
}
