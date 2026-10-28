package net.msrandom.minecraftcodev.fabric.mixin

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.encodeToStream
import net.msrandom.minecraftcodev.mixins.ConfigSide
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinConfigReference
import java.nio.file.Path
import java.util.Collections
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

class FabricMixinConfigHandler(
    mixins: JsonElement,
    private val jsonName: String,
) : MixinConfigHandler {

    override val references: List<MixinConfigReference> = Collections.unmodifiableList(
        (if (mixins is JsonArray) mixins.toList() else listOf(mixins)).map(::reference),
    )

    override fun list(root: Path): List<String> = references.map { it.resource }

    @OptIn(ExperimentalSerializationApi::class)
    override fun remove(root: Path) {
        val resources = references.map { it.resource }.toSet()
        val path = root.resolve(jsonName)
        val current = path.inputStream().use { Json.decodeFromStream<JsonObject>(it) }
        val mixins = current["mixins"] ?: return
        val remaining = when (mixins) {
            is JsonArray -> JsonArray(mixins.filterNot { reference(it).resource in resources }).takeUnless { it.isEmpty() }
            else -> if (reference(mixins).resource in resources) null else mixins
        }
        val rewritten = if (remaining == null) JsonObject(current - "mixins") else JsonObject(current + ("mixins" to remaining))
        path.outputStream().use { output -> jsonCodec.encodeToStream(rewritten, output) }
    }

    private fun reference(element: JsonElement): MixinConfigReference {
        val value = if (element is JsonObject) element["config"] else element
        require(value is JsonPrimitive && value.isString) { "Fabric mixin reference must be a config path" }
        val environment = if (element is JsonObject && "environment" in element) element["environment"] else JsonPrimitive("*")
        require(environment is JsonPrimitive && environment.isString) { "Fabric mixin environment must be a string" }
        val side = when (environment.content) {
            "*" -> ConfigSide.COMMON
            "client" -> ConfigSide.CLIENT
            "server" -> ConfigSide.SERVER
            else -> throw IllegalArgumentException("Unknown Fabric mixin environment: "+environment.content)
        }
        return MixinConfigReference(value.content, side)
    }

    companion object {
        private val jsonCodec = Json { prettyPrint = true }
    }
}
