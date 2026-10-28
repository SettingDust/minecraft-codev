package net.msrandom.minecraftcodev.fabric.mixin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromStream
import net.msrandom.minecraftcodev.fabric.MinecraftCodevFabricPlugin
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.inputStream

class FabricMixinListingRule : MixinListingRule {
    @OptIn(ExperimentalSerializationApi::class)
    override fun load(root: Path): MixinConfigHandler? {
        val mod = root.resolve(MinecraftCodevFabricPlugin.MOD_JSON)
        if (!mod.exists()) return null
        val metadata = mod.inputStream().use { Json.decodeFromStream<JsonObject>(it) }
        val mixins = metadata["mixins"] ?: return null
        return FabricMixinConfigHandler(mixins, MinecraftCodevFabricPlugin.MOD_JSON)
    }
}
