package net.msrandom.minecraftcodev.forge.mixin

import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import java.nio.file.Path
import java.util.jar.JarFile
import java.util.jar.Manifest
import kotlin.io.path.exists
import kotlin.io.path.inputStream

class ForgeMixinListingRule : MixinListingRule {
    override fun load(root: Path): MixinConfigHandler? {
        val manifestPath = root.resolve(JarFile.MANIFEST_NAME)
        val manifestNames = if (manifestPath.exists()) {
            manifestPath.inputStream().use(::Manifest).mainAttributes.getValue(MANIFEST_MIXINS_CONFIG)
                ?.split(',')?.map(String::trim)?.filter(String::isNotEmpty)
        } else null
        return manifestNames?.let(::ForgeMixinConfigHandler)
    }
}
