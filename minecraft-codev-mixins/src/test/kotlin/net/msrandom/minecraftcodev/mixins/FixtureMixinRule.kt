package net.msrandom.minecraftcodev.mixins

import java.io.IOException
import java.io.UncheckedIOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.Collections

/** Fixture-only discovery; no Fabric/Forge metadata behavior is simulated. */
class FixtureMixinRule : MixinListingRule {
    override fun load(root: Path): MixinConfigHandler? {
        val lists = mapOf("fixture.list" to ConfigSide.COMMON, "fixture.client.list" to ConfigSide.CLIENT, "fixture.server.list" to ConfigSide.SERVER)
        if (lists.keys.none { Files.exists(root.resolve(it)) }) return null
        try {
            val discovered = mutableListOf<String>()
            val references = Collections.unmodifiableList(lists.flatMap { (file, side) ->
                val path = root.resolve(file)
                if (Files.exists(path)) {
                    val lines = Files.readAllLines(path)
                    discovered.add(file)
                    lines.map { MixinConfigReference(it, side) }
                } else emptyList()
            })
            return object : MixinConfigHandler {
                override val references: List<MixinConfigReference> = references

                override fun list(root: Path): List<String> = references.map { it.resource }

                override fun remove(root: Path) {
                    try {
                        for (file in discovered) Files.delete(root.resolve(file))
                    } catch (e: IOException) {
                        throw UncheckedIOException(e)
                    }
                }
            }
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
    }
}
