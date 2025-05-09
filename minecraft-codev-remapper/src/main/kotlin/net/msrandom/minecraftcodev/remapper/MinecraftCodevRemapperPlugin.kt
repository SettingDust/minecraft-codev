package net.msrandom.minecraftcodev.remapper

import net.msrandom.minecraftcodev.core.utils.applyPlugin
import net.msrandom.minecraftcodev.core.utils.createSourceSetConfigurations
import net.msrandom.minecraftcodev.core.utils.disambiguateName
import org.gradle.api.Plugin
import org.gradle.api.plugins.PluginAware
import org.gradle.api.tasks.SourceSet

val SourceSet.mappingsConfigurationName get() = disambiguateName(MinecraftCodevRemapperPlugin.MAPPINGS_CONFIGURATION)

class MinecraftCodevRemapperPlugin<T : PluginAware> : Plugin<T> {
    override fun apply(target: T) =
        applyPlugin(target) {
            createSourceSetConfigurations(MAPPINGS_CONFIGURATION)
        }

    companion object {
        const val NAMED_MAPPINGS_NAMESPACE = "named"
        const val MAPPINGS_CONFIGURATION = "mappings"
    }
}
