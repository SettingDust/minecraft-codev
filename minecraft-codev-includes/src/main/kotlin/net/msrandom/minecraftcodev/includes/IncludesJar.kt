package net.msrandom.minecraftcodev.includes

import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.bundling.Jar

abstract class IncludesJar : Jar() {
    abstract val includedJarInfo: ListProperty<IncludedJarInfo>
        @Nested
        get

    abstract val input: RegularFileProperty
        @InputFile
        get

    fun fromResolutionResults(configuration: Provider<out Configuration>) {
        fromResolutionSources(configuration, project.providers.provider { emptyList() })
    }

    fun fromResolutionSources(
        ordinary: Provider<out Configuration>,
        targets: Provider<out List<IncludeTargetSource>>,
    ) {
        val objects = project.objects
        val providers = project.providers
        val logger = logger

        // Keep Buildable configurations: extracted RegularFile values alone lose producer tasks.
        dependsOn(ordinary)
        dependsOn(targets.map { sources -> sources.map { it.configuration } })

        fun resolved(configuration: Configuration, origin: IncludeTargetOrigin?): Provider<ResolvedIncludeSource> =
            configuration.incoming.resolutionResult.rootComponent.zip(configuration.incoming.artifacts.resolvedArtifacts) { root, artifacts ->
                ResolvedIncludeSource(root, artifacts, origin)
            }

        val targetSources = targets.flatMap { sources ->
            sources.fold(providers.provider<List<ResolvedIncludeSource>> { emptyList() }) { result, source ->
                result.zip(resolved(source.configuration, source.origin)) { gathered, next -> gathered + next }
            }
        }
        includedJarInfo.addAll(ordinary.flatMap { resolved(it, null) }.zip(targetSources) { source, targetSources ->
            IncludedJarInfo.fromResolutionSources(objects, listOf(source) + targetSources, logger)
        })
    }
}
