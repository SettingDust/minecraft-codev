package net.msrandom.minecraftcodev.core

import net.msrandom.minecraftcodev.core.resolve.MinecraftVersionList
import net.msrandom.minecraftcodev.core.resolve.getClientDependencies
import net.msrandom.minecraftcodev.core.resolve.setupCommon
import org.gradle.api.artifacts.CacheableRule
import org.gradle.api.artifacts.ComponentMetadataContext
import org.gradle.api.artifacts.ComponentMetadataRule
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.Category
import org.gradle.api.model.ObjectFactory
import java.io.File
import java.nio.file.Path
import javax.inject.Inject

const val VERSION_MANIFEST_URL = "https://launchermeta.mojang.com/mc/game/version_manifest_v2.json"

// TODO: Caching
fun getVersionList(
    cacheDirectory: Path,
    url: String = VERSION_MANIFEST_URL,
    isOffline: Boolean,
) = MinecraftVersionList.load(cacheDirectory, url, isOffline)

@CacheableRule
abstract class MinecraftComponentMetadataRule<T : Any> @Inject constructor(
    private val cacheDirectory: File,
    private val version: String,
    private val versionManifestUrl: String,
    private val isOffline: Boolean,
    private val client: Boolean,
    private val variantName: String,
    private val attribute: Attribute<T>,
    private val commonAttributeValue: T,
    private val clientAttributeValue: T,
) : ComponentMetadataRule {
    abstract val objectFactory: ObjectFactory
        @Inject get

    override fun execute(context: ComponentMetadataContext) {
        context.details.addVariant(variantName) {
            it.attributes { attributes ->
                attributes
                    .attribute(Category.CATEGORY_ATTRIBUTE, objectFactory.named(Category::class.java, Category.REGULAR_PLATFORM))
                    .attribute(attribute, clientAttributeValue)
            }

            it.withCapabilities { capabilities ->
                capabilities.addCapability("net.minecraft.dependencies", if (client) "client" else "server", "1.0.0")
            }

            it.withDependencies { dependencies ->
                val versionMetadata = getVersionList(cacheDirectory.toPath(), versionManifestUrl, isOffline).version(version)

                if (client) {
                    val id = context.details.id

                    getClientDependencies(cacheDirectory.toPath(), versionMetadata, isOffline).forEach(dependencies::add)

                    dependencies.add("${id.group}:${id.name}:${id.version}") { commonDependency ->
                        commonDependency.attributes { attributes ->
                            attributes
                                .attribute(Category.CATEGORY_ATTRIBUTE, objectFactory.named(Category::class.java, Category.REGULAR_PLATFORM))
                                .attribute(attribute, commonAttributeValue)
                        }
                    }
                } else {
                    setupCommon(cacheDirectory.toPath(), versionMetadata, isOffline).forEach(dependencies::add)
                }
            }
        }
    }
}
