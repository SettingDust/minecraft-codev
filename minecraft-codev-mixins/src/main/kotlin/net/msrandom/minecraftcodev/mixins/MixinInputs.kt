package net.msrandom.minecraftcodev.mixins

import java.net.URL
import java.nio.file.*
import java.util.TreeSet

/** Native property names only: no inheritance, parsing or override values. */
@Throws(ReflectiveOperationException::class)
fun nativePropertyNames(): List<String> {
    val property = org.spongepowered.asm.mixin.MixinEnvironment.Option::class.java.getDeclaredField("property")
    property.isAccessible = true
    val names = ArrayList<String>()
    for (option in org.spongepowered.asm.mixin.MixinEnvironment.Option.values()) names.add(property.get(option) as String)
    // Service selectors belong to the initialization window, not operation options.
    // Direct native reads outside Option in bootstrap and JavaVersion.
    names.addAll(listOf("sun.java.command", "java.version"))
    return names
}
private fun location(type: Class<*>): URL = type.protectionDomain.codeSource.location

@Throws(Exception::class)
fun implementationInputs(): List<String> {
    val implementation = LinkedHashSet<String>()
    for (type in listOf(IsolatingMixinClassLoader::class.java, org.spongepowered.asm.launch.MixinBootstrap::class.java,
        org.objectweb.asm.ClassReader::class.java, org.objectweb.asm.tree.ClassNode::class.java,
        org.objectweb.asm.tree.analysis.Analyzer::class.java, org.objectweb.asm.commons.ClassRemapper::class.java,
        org.objectweb.asm.util.CheckClassAdapter::class.java, com.google.gson.Gson::class.java,
        com.google.common.collect.ImmutableList::class.java, net.fabricmc.mappingio.MappingReader::class.java,
        kotlinx.serialization.json.Json::class.java, kotlinx.serialization.KSerializer::class.java,
        kotlin.Unit::class.java, kotlin.jvm.internal.Intrinsics::class.java,
        Class.forName("kotlin.jdk7.AutoCloseableKt"), Class.forName("kotlin.collections.jdk8.CollectionsJDK8Kt"))) {
        implementation.add(Paths.get(location(type).toURI()).toString())
    }
    for (rule in mixinListingRules) implementation.add(Paths.get(location(rule.javaClass).toURI()).toString())
    implementation.add(Paths.get(location(MixinListingRule::class.java).toURI()).toString())
    return ArrayList(implementation)
}

internal fun discoverMixinConfigs(input: String, sources: List<String>, environments: MutableMap<String, MutableSet<String>>): List<String> {
    val configs = LinkedHashSet<String>()
    val artifacts = ArrayList(sources)
    artifacts.add(input)
    for (artifact in artifacts) FileSystems.newFileSystem(Paths.get(artifact), null as ClassLoader?).use { fs ->
        val root = fs.getPath("/")
        for (rule in mixinListingRules) {
            val handler = rule.load(root) ?: continue
            for ((config, side) in handler.references) {
                val environment = when (side) {
                    ConfigSide.COMMON -> "*"
                    ConfigSide.CLIENT -> "client"
                    ConfigSide.SERVER -> "server"
                }
                environments.getOrPut(config) { TreeSet() }.add(environment)
                configs.add(config)
            }
        }
    }
    return configs.toList()
}
