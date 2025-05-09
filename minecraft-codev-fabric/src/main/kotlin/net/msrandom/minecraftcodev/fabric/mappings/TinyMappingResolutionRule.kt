package net.msrandom.minecraftcodev.fabric.mappings

import net.fabricmc.mappingio.adapter.MappingNsCompleter
import net.fabricmc.mappingio.adapter.MappingNsRenamer
import net.fabricmc.mappingio.format.tiny.Tiny1FileReader
import net.fabricmc.mappingio.format.tiny.Tiny2FileReader
import net.fabricmc.mappingio.tree.MappingTreeView
import net.msrandom.minecraftcodev.core.MappingsNamespace
import net.msrandom.minecraftcodev.fabric.MinecraftCodevFabricPlugin
import net.msrandom.minecraftcodev.remapper.MappingResolutionData
import net.msrandom.minecraftcodev.remapper.MappingResolutionRule
import net.msrandom.minecraftcodev.remapper.MinecraftCodevRemapperPlugin
import net.msrandom.minecraftcodev.remapper.ZipMappingResolutionRule
import java.nio.file.FileSystem
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.inputStream

private fun readTiny(
    data: MappingResolutionData,
    path: Path,
) {
    path.inputStream().bufferedReader().use { reader ->
        reader.mark(16)

        val parts = reader.readLine().split('\t')

        reader.reset()

        val version =
            when {
                parts[0].startsWith('v') -> parts[0].substring(1).toInt()
                parts[0] == "tiny" -> parts[1].toInt()
                else -> throw IllegalArgumentException("Invalid tiny header found")
            }

        val namespaceCompleter =
            if (MinecraftCodevFabricPlugin.INTERMEDIARY_MAPPINGS_NAMESPACE in parts) {
                if (
                    data.visitor.tree.dstNamespaces == null ||
                    data.visitor.tree.getNamespaceId(MinecraftCodevRemapperPlugin.NAMED_MAPPINGS_NAMESPACE) == MappingTreeView.NULL_NAMESPACE_ID
                ) {
                    MappingNsCompleter(
                        data.visitor.tree,
                        mapOf(
                            MinecraftCodevRemapperPlugin.NAMED_MAPPINGS_NAMESPACE to MinecraftCodevFabricPlugin.INTERMEDIARY_MAPPINGS_NAMESPACE,
                        ),
                        true,
                    )
                } else {
                    data.visitor.tree
                }
            } else {
                data.visitor.tree
            }

        val renamer = MappingNsRenamer(namespaceCompleter, mapOf("official" to MappingsNamespace.OBF))

        when (version) {
            1 -> Tiny1FileReader.read(reader, renamer)
            2 -> Tiny2FileReader.read(reader, renamer)
            else -> throw IllegalArgumentException("Unknown tiny mappings version found")
        }
    }
}

class TinyMappingResolutionRule : MappingResolutionRule {
    override fun load(path: Path, extension: String, data: MappingResolutionData): Boolean {
        if (extension != "tiny") {
            return false
        }

        readTiny(data, path)

        return true
    }
}

class TinyZipMappingResolutionRule : ZipMappingResolutionRule {
    override fun load(path: Path, fileSystem: FileSystem, isJar: Boolean, data: MappingResolutionData): Boolean {
        val tiny = fileSystem.getPath("mappings/mappings.tiny")

        if (!tiny.exists()) {
            return false
        }

        // Assuming tiny
        readTiny(data, tiny)

        return true
    }
}