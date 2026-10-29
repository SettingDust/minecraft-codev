package net.msrandom.minecraftcodev.includes

import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.result.ResolvedArtifactResult
import org.gradle.api.artifacts.result.ResolvedComponentResult

/** Producer provenance; the original target name is retained before any suffix normalization. */
data class IncludeTargetOrigin(
    val buildIdentity: String,
    val projectPath: String,
    val targetName: String,
    val group: String,
    val name: String,
)

data class IncludeTargetSource(val origin: IncludeTargetOrigin, val configuration: Configuration)

/** A null origin denotes the single ordinary graph. No resolution is performed by these values. */
data class ResolvedIncludeSource(
    val rootComponent: ResolvedComponentResult,
    val artifacts: Set<ResolvedArtifactResult>,
    val origin: IncludeTargetOrigin? = null,
)
