package net.msrandom.minecraftcodev.mixins

import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

/** Plain target and resource-only inputs; only the engine smoke adds a Mixin source. */
class MixinFixture(val root: Path) {
    lateinit var target: Path
    lateinit var mod: Path

    fun create() {
        target = PipelineInputs.copyJar("target", root.resolve("target.jar"))
        mod = PipelineInputs.copyJar("source", root.resolve("mod.jar"))
    }

    fun jar(name: String, entries: Map<String, ByteArray>): Path {
        val path = root.resolve(name)
        JarOutputStream(Files.newOutputStream(path)).use { out ->
            for ((name, bytes) in entries.toSortedMap()) {
                out.putNextEntry(JarEntry(name))
                out.write(bytes)
                out.closeEntry()
            }
        }
        return path
    }

    fun produce(name: String, sources: List<String>, runtime: List<String>): Path {
        val output = root.resolve("$name.jar")
        produceMixins(target.toString(), sources, runtime, "SERVER", output.toString(), root.resolve("$name.json").toString())
        return output
    }

    fun value(jar: Path): Int = URLClassLoader(arrayOf(jar.toUri().toURL()), javaClass.classLoader).use { loader ->
        val type = loader.loadClass("demo.Target")
        type.getMethod("value").invoke(type.getConstructor().newInstance()) as Int
    }

    fun read(jar: Path, entry: String): ByteArray = JarFile(jar.toFile()).use { file ->
        file.getInputStream(java.util.Objects.requireNonNull(file.getJarEntry(entry), entry)).use { it.readAllBytes() }
    }
}
