package net.msrandom.minecraftcodev.forge.mixin

import com.electronwill.nightconfig.core.Config
import com.electronwill.nightconfig.toml.TomlParser
import com.electronwill.nightconfig.toml.TomlWriter
import net.msrandom.minecraftcodev.forge.MinecraftCodevForgePlugin.Companion.NEOFORGE_MODS_TOML
import net.msrandom.minecraftcodev.mixins.ConfigSide
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinConfigReference
import java.nio.file.Files
import java.nio.file.Path
import java.util.Collections

class NeoForgeMixinConfigHandler(mixins: List<*>) : MixinConfigHandler {
    override val references: List<MixinConfigReference> = Collections.unmodifiableList(mixins.map(::reference))

    override fun list(root: Path): List<String> = references.map { it.resource }

    override fun remove(root: Path) {
        val resources = references.map { it.resource }.toSet()
        val path = root.resolve("META-INF").resolve(NEOFORGE_MODS_TOML)
        val current = Files.newBufferedReader(path).use(TomlParser()::parse)
        val entries = mixins(current) ?: return
        val remaining = entries.filterNot { reference(it).resource in resources }
        if (remaining.isEmpty()) current.remove<Any>("mixins") else current.set<Any>("mixins", remaining)
        Files.newBufferedWriter(path).use { TomlWriter().write(current, it) }
    }

    private fun reference(entry: Any?): MixinConfigReference {
        require(entry is Config) { "NeoForge mixin entry must be a table" }
        val resource = entry.get<Any>("config")
        require(resource is String) { "NeoForge mixin config must be a path" }
        return MixinConfigReference(resource, ConfigSide.COMMON)
    }

    companion object {
        internal fun mixins(config: Config): List<*>? {
            val entries = config.get<Any>("mixins") ?: return null
            require(entries is List<*>) { "NeoForge mixins must be a list" }
            return entries
        }
    }
}
