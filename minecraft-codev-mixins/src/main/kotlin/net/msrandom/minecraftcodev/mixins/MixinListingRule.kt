package net.msrandom.minecraftcodev.mixins

import net.msrandom.minecraftcodev.core.FileListingRules
import net.msrandom.minecraftcodev.core.utils.serviceLoader
import java.nio.file.Path

interface MixinListingRule : FileListingRules {
    override fun load(root: Path): MixinConfigHandler?
}

val mixinListingRules = serviceLoader<MixinListingRule>()
