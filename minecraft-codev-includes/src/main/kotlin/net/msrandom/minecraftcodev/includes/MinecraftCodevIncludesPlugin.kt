package net.msrandom.minecraftcodev.includes

import net.msrandom.minecraftcodev.core.MinecraftCodevExtension
import net.msrandom.minecraftcodev.core.utils.applyPlugin
import net.msrandom.minecraftcodev.core.utils.extension
import org.gradle.api.Plugin
import org.gradle.api.plugins.PluginAware

class MinecraftCodevIncludesPlugin<T : PluginAware> : Plugin<T> {
    override fun apply(target: T) =
        applyPlugin(target) {
            extension<MinecraftCodevExtension>().extensions.create("includes", IncludesExtension::class.java)
        }
}
