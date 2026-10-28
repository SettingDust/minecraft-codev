package net.msrandom.minecraftcodev.forge.mixin

import net.msrandom.minecraftcodev.mixins.ConfigSide
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinConfigReference
import java.util.Collections
import java.nio.file.Path
import java.util.jar.Attributes
import java.util.jar.JarFile
import java.util.jar.Manifest
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

internal const val MANIFEST_MIXINS_CONFIG = "MixinConfigs"

class ForgeMixinConfigHandler(manifestNames: List<String>) : MixinConfigHandler {
    private val manifestNames = manifestNames.toList()

    override val references: List<MixinConfigReference> = Collections.unmodifiableList(
        this.manifestNames.map { MixinConfigReference(it, ConfigSide.COMMON) },
    )

    override fun list(root: Path): List<String> = references.map { it.resource }

    override fun remove(root: Path) {
        updateManifest(root, references.map { it.resource }.toSet())
    }

    private fun updateManifest(root: Path, resources: Set<String>) {
        val path = root.resolve(JarFile.MANIFEST_NAME)
        val manifest = path.inputStream().use(::Manifest)
        val current = manifest.mainAttributes.getValue(MANIFEST_MIXINS_CONFIG)
            ?.split(',')?.map(String::trim)?.filter(String::isNotEmpty) ?: return
        val remaining = current.map { MixinConfigReference(it, ConfigSide.COMMON).resource }
            .filterNot { it in resources }
        val key = Attributes.Name(MANIFEST_MIXINS_CONFIG)
        if (remaining.isEmpty()) manifest.mainAttributes.remove(key) else manifest.mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, remaining.joinToString(", "))
        path.outputStream().use(manifest::write)
    }

}
