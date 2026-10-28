package net.msrandom.minecraftcodev.mixins

import net.msrandom.minecraftcodev.core.ListedFileHandler
import java.nio.file.Path

interface MixinConfigHandler : ListedFileHandler {
    val references: List<MixinConfigReference>
    override fun remove(root: Path)
}
