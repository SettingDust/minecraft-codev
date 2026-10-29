package net.msrandom.minecraftcodev.includes

import org.gradle.api.GradleException
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.api.artifacts.component.ComponentSelector
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.artifacts.component.ModuleComponentSelector
import org.gradle.api.artifacts.component.ProjectComponentIdentifier
import org.gradle.api.artifacts.dsl.DependencyFactory
import org.gradle.api.artifacts.result.DependencyResult
import org.gradle.api.artifacts.result.ResolvedArtifactResult
import org.gradle.api.artifacts.result.ResolvedComponentResult
import org.gradle.api.artifacts.result.ResolvedDependencyResult
import org.gradle.api.artifacts.result.ResolvedVariantResult
import org.gradle.api.artifacts.result.UnresolvedDependencyResult
import org.gradle.api.attributes.Attribute
import org.gradle.api.capabilities.Capability
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.logging.Logger
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.kotlin.dsl.newInstance
import org.gradle.util.GradleVersion
import javax.inject.Inject

// Keep the 8.11 capability-selector API off the legacy execution path.
private abstract class CompleteCapabilityRequests @Inject constructor(private val dependencies: DependencyFactory) {
    fun get(selector: ComponentSelector): List<Capability> = selector.requestedCapabilities.filter { candidate ->
        val probe = dependencies.create(candidate.group, candidate.name, null)
        probe.capabilities { requireCapability("${candidate.group}:${candidate.name}") }
        probe.capabilitySelectors.single() in selector.capabilitySelectors
    }
}

interface IncludedJarInfo {
    val group: Property<String>
        @Input get

    val moduleName: Property<String>
        @Input get

    val artifactVersion: Property<String>
        @Input get

    val versionRange: Property<String>
        @Input get

    val file: RegularFileProperty
        @InputFile get

    companion object {
        private fun tryFindInfo(
            objectFactory: ObjectFactory,
            requestedIdentities: Set<Pair<String, String>>,
            versionSelector: ComponentSelector?,
            artifact: ResolvedArtifactResult,
            sources: String,
        ): IncludedJarInfo? {
            val componentId = artifact.id.componentIdentifier
            // Identity uses all requests; version constraints retain the original last-selector rule.
            val moduleSelector = versionSelector as? ModuleComponentSelector
            val explicitCapability = if (requestedIdentities.isNotEmpty()) {
                val diagnostic = "included artifact ${artifact.file}, variant ${artifact.variant.displayName}, requests " +
                        requestedIdentities.joinToString { (group, name) -> "$group:$name" } + " from $sources"
                if (requestedIdentities.size > 1) {
                    throw GradleException("Ambiguous capability identities for $diagnostic")
                }
                val (group, name) = requestedIdentities.single()
                artifact.variant.capabilities.firstOrNull { it.group == group && it.name == name }
                    ?: throw GradleException("No matching capability identity for $diagnostic")
            } else {
                null
            }

            val mainCapability = explicitCapability ?: when (componentId) {
                is ModuleComponentIdentifier ->
                    // Try to find first variant that matches identifier, for consistency(matches MDG behavior)
                    artifact.variant.capabilities.firstOrNull {
                        it.group == componentId.group &&
                                it.name == componentId.module &&
                                it.version == componentId.version
                    }

                is ProjectComponentIdentifier ->
                    // Not in parity with MDG, but gets the capability that matches the project name for consistency with module capability behavior
                    artifact.variant.capabilities.firstOrNull {
                        it.name == componentId.projectName
                    }

                else -> null
            }

            val capability = mainCapability ?: artifact.variant.capabilities.firstOrNull()

            if (capability == null) {
                return null
            }

            val group = capability.group
            val name = capability.name
            val version = capability.version ?: (componentId as? ModuleComponentIdentifier)?.version ?: moduleSelector?.version ?: "0.0.0"
            val versionRange = versionRange(moduleSelector?.versionConstraint) ?: defaultVersionRange(version)

            return objectFactory.newInstance<IncludedJarInfo>().also {
                it.group.set(group)
                it.moduleName.set(name)
                it.artifactVersion.set(version)
                it.versionRange.set(versionRange)
                it.file.set(artifact.file)
            }
        }

        private fun collectDependencyVariants(
            dependency: DependencyResult,
            dependencies: MutableMap<ResolvedVariantResult, MutableList<ComponentSelector>>
        ) {
            if (dependency is UnresolvedDependencyResult) {
                throw dependency.failure
            }

            dependency as ResolvedDependencyResult

            dependencies.getOrPut(dependency.resolvedVariant) { mutableListOf() }.add(dependency.requested)

            for (dependency in dependency.selected.getDependenciesForVariant(dependency.resolvedVariant)) {
                collectDependencyVariants(dependency, dependencies)
            }
        }

        private fun coordinates(variant: ResolvedVariantResult) =
            variant.capabilities.map { Triple(it.group, it.name, it.version) }.toSet()

        private data class VariantKey(
            val owner: org.gradle.api.artifacts.component.ComponentIdentifier,
            val capabilities: Set<Triple<String, String, String?>>,
            val attributes: Map<Attribute<*>, Any?>,
            val name: String,
        )

        private fun variantKey(variant: ResolvedVariantResult) = VariantKey(
            variant.owner,
            coordinates(variant),
            variant.attributes.keySet().associateWith { variant.attributes.getAttribute(it) },
            variant.displayName,
        )

        private class VariantRequests(
            val sourceIndex: Int,
            val origin: IncludeTargetOrigin?,
            val variant: ResolvedVariantResult,
            val selectors: List<ComponentSelector>,
        ) {
            val key = variantKey(variant)
            val artifacts = mutableListOf<ResolvedArtifactResult>()
            val description get() = "source[$sourceIndex]=${origin ?: "ordinary"}, variant ${variant.displayName}"
        }

        private fun associationFailure(
            entries: List<VariantRequests>,
            completeRequests: (ComponentSelector) -> List<Capability>,
            artifacts: List<ResolvedArtifactResult> = entries.flatMap { it.artifacts },
        ): Nothing = throw GradleException(
            "Cannot uniquely associate included artifacts ${artifacts.map { "${it.file}, variant ${it.variant.displayName}" }}, " +
                    "requests ${entries.flatMap { it.selectors }.flatMap(completeRequests).map { "${it.group}:${it.name}" }.toSet()} " +
                    "with resolved variants ${entries.map { it.description }}"
        )

        private fun resolveSource(
            sourceIndex: Int,
            source: ResolvedIncludeSource,
            completeRequests: (ComponentSelector) -> List<Capability>,
        ): List<VariantRequests> {
            val dependencies = buildMap {
                for (result in source.rootComponent.dependencies) {
                    collectDependencyVariants(result, this)
                }
            }
            val entries = dependencies.mapValues { (variant, selectors) ->
                VariantRequests(sourceIndex, source.origin, variant, selectors)
            }.toMutableMap()
            for (artifact in source.artifacts) {
                val exact = entries[artifact.variant]
                if (exact != null) {
                    exact.artifacts.add(artifact)
                    continue
                }
                // Only artifact projections use subset attributes; graph-to-graph keys use the full set.
                val componentVariants = entries.values.filter { it.variant.owner == artifact.id.componentIdentifier }
                val matching = componentVariants.filter { entry ->
                    coordinates(entry.variant) == coordinates(artifact.variant) &&
                            entry.variant.attributes.keySet().all { attribute ->
                                entry.variant.attributes.getAttribute(attribute) == artifact.variant.attributes.getAttribute(attribute)
                            }
                }
                val entry = when {
                    matching.size == 1 -> matching.single()
                    matching.size > 1 || componentVariants.any { it.selectors.flatMap(completeRequests).isNotEmpty() } ->
                        associationFailure(componentVariants, completeRequests, listOf(artifact))
                    else -> VariantRequests(sourceIndex, source.origin, artifact.variant, emptyList()).also {
                        entries[artifact.variant] = it
                    }
                }
                entry.artifacts.add(artifact)
            }
            return entries.values.toList()
        }

        private fun gatherVariants(
            entries: List<VariantRequests>,
            completeRequests: (ComponentSelector) -> List<Capability>,
        ): List<List<VariantRequests>> {
            val groups = mutableListOf<MutableList<VariantRequests>>()
            // Establish target groups first, so an ordinary record cannot bridge two original targets.
            for (entry in entries.sortedBy { it.origin == null }) {
                val candidates = groups.filter { group ->
                    group.first().key == entry.key &&
                            (entry.origin == null || group.first().origin == entry.origin)
                }
                if (candidates.size > 1) {
                    associationFailure(candidates.flatten() + entry, completeRequests)
                }
                val candidate = candidates.singleOrNull()
                if (candidate == null || candidate.any { it.sourceIndex == entry.sourceIndex }) {
                    // Two graph variants in one source are separate even when their public fields collide.
                    groups.add(mutableListOf(entry))
                } else {
                    candidate.add(entry)
                }
            }
            return groups
        }

        private fun versionRange(constraint: VersionConstraint?): String? {
            if (constraint == null) {
                return null
            }

            fun version(value: String): String? = value.takeUnless(String::isEmpty)

            return version(constraint.strictVersion)
                ?: version(constraint.requiredVersion)
                ?: version(constraint.preferredVersion)
        }

        private fun defaultVersionRange(version: String) = "[$version,)"

        fun fromResolutionResults(
            objectFactory: ObjectFactory,
            rootComponent: ResolvedComponentResult,
            artifacts: Set<ResolvedArtifactResult>,
            logger: Logger,
        ): List<IncludedJarInfo> = fromResolutionSources(
            objectFactory, listOf(ResolvedIncludeSource(rootComponent, artifacts)), logger,
        )

        fun fromResolutionSources(
            objectFactory: ObjectFactory,
            sources: List<ResolvedIncludeSource>,
            logger: Logger,
        ): List<IncludedJarInfo> {
            require(sources.count { it.origin == null } <= 1) { "At most one ordinary include source is allowed" }
            val completeRequests: (ComponentSelector) -> List<Capability> =
                if (GradleVersion.current() >= GradleVersion.version("8.11")) {
                    objectFactory.newInstance<CompleteCapabilityRequests>()::get
                } else {
                    { it.requestedCapabilities }
                }
            val entries = sources.flatMapIndexed { index, source -> resolveSource(index, source, completeRequests) }
            val jars = mutableListOf<IncludedJarInfo>()
            for (group in gatherVariants(entries, completeRequests)) {
                val selectors = group.flatMap { it.selectors }
                val versionSelector = group.singleOrNull { it.origin == null }?.selectors?.lastOrNull()
                    ?: selectors.lastOrNull()
                val artifacts = group.flatMap { it.artifacts }.distinctBy {
                    Triple(it.id, variantKey(it.variant), it.file)
                }
                if (artifacts.isEmpty()) continue
                val requestedIdentities = selectors.flatMap(completeRequests).map { it.group to it.name }.toSet()
                for (artifact in artifacts) {
                    val info = tryFindInfo(
                        objectFactory, requestedIdentities, versionSelector, artifact,
                        group.joinToString { it.description },
                    )
                    if (info == null) {
                        logger.warn("Skipping included file ${artifact.file} as its coordinates could not be determined")
                        continue
                    }
                    jars.add(info)
                }
            }

            return jars
        }
    }
}
