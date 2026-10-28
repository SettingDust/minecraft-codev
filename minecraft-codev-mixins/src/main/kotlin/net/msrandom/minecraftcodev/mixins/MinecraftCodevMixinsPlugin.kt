package net.msrandom.minecraftcodev.mixins

import org.gradle.api.Plugin
import org.gradle.api.Project

/** Callers register and compose the task and transform; applying the plugin owns no engine state. */
class MinecraftCodevMixinsPlugin : Plugin<Project> {
    override fun apply(target: Project) = Unit
}
