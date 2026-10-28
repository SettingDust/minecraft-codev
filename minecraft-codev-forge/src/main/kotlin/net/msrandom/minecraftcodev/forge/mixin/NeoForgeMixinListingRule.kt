package net.msrandom.minecraftcodev.forge.mixin

import com.electronwill.nightconfig.toml.TomlParser
import net.msrandom.minecraftcodev.forge.MinecraftCodevForgePlugin.Companion.NEOFORGE_MODS_TOML
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists

class NeoForgeMixinListingRule : MixinListingRule {
    override fun load(root: Path): MixinConfigHandler? {
        val path = root.resolve("META-INF").resolve(NEOFORGE_MODS_TOML)
        if (!path.exists()) return null
        val config = Files.newBufferedReader(path).use(TomlParser()::parse)
        return NeoForgeMixinConfigHandler.mixins(config)?.let(::NeoForgeMixinConfigHandler)
    }
}
