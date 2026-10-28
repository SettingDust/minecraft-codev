package net.msrandom.minecraftcodev.mixins

import java.io.*
import java.net.*
import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes
import java.security.CodeSource
import java.security.ProtectionDomain
import java.security.cert.Certificate
import java.util.Collections
import java.util.Enumeration

/** One disposable implementation domain, with ordered task classes and resources. */
class IsolatingMixinClassLoader(implementation: Array<URL>, inputs: Array<URL>) : URLClassLoader(implementation, ClassLoader.getPlatformClassLoader()) {
    // Never give task inputs to URLClassPath: it would insert Manifest Class-Path entries.
    private val task: URLClassLoader = object : URLClassLoader(emptyArray(), null) {
        private val roots = inputs.map {
            require(it.protocol == "file") { "Non-local task input: $it" }
            Paths.get(it.toURI())
        }
        override fun findResource(name: String): URL? {
            archivePath(name)
            for (root in roots) {
                val attributes = attributes(root) ?: continue
                if (attributes.isDirectory) {
                    // A legal ZIP entry can be unrepresentable as a local filename (for example '?' on Windows).
                    val resource = try { root.resolve(name) } catch (unrepresentable: InvalidPathException) { continue }
                    if (attributes(resource) != null) return URL(resource.toUri().toASCIIString())
                } else {
                    val entry = java.util.jar.JarFile(root.toFile(), true, java.util.jar.JarFile.OPEN_READ,
                        java.util.jar.JarFile.runtimeVersion()).use { it.getJarEntry(name)?.realName } ?: continue
                    val encoded = URI(null, null, "/$entry", null).toASCIIString().substring(1)
                    val location = URL(root.toUri().toASCIIString())
                    return URL("jar:$location!/$encoded")
                }
            }
            return null
        }
    }
    companion object {
        private const val RUNTIME = "net.msrandom.minecraftcodev.mixins.runtime."
        private fun archivePath(name: String) {
            require(name.isNotBlank() && name.none { it < ' ' } && !name.startsWith("/") && !name.contains('\\') && !name.contains(':') && name.split('/').none { it == "." || it == ".." }) { "Unsafe archive path: $name" }
        }
        private fun attributes(path: Path): BasicFileAttributes? = try {
            Files.readAttributes(path, BasicFileAttributes::class.java)
        } catch (absent: NoSuchFileException) { null }
        private fun uncached(resource: URL?): URL? {
            if (resource == null) return null
            try {
                // URL-based plugin reads must not leave JDK-global cached archive handles.
                return URL(null, resource.toExternalForm(), object : URLStreamHandler() {
                    override fun openConnection(ignored: URL): URLConnection = resource.openConnection().apply { useCaches = false }
                })
            } catch (failure: MalformedURLException) { throw IllegalStateException(failure) }
        }
        private fun stream(resource: URL): InputStream = resource.openConnection().apply { useCaches = false }.getInputStream()
        private fun owned(name: String): Boolean = name.startsWith(RUNTIME) || name.startsWith("kotlin.") || name.startsWith("kotlinx.serialization.") || name.startsWith("net.fabricmc.mappingio.") ||
            name.startsWith("org.spongepowered.asm.") || name.startsWith("org.spongepowered.include.") || name.startsWith("org.objectweb.asm.") ||
            name.startsWith("com.google.gson.") || name.startsWith("com.google.common.") || name.startsWith("com.google.thirdparty.")
    }
    @Synchronized
    override fun loadClass(name: String, resolve: Boolean): Class<*> {
        var found = findLoadedClass(name)
        if (found == null) {
            try { found = parent.loadClass(name) } catch (absent: ClassNotFoundException) {
                if (owned(name)) found = findClass(name)
                else {
                    val path = name.replace('.', '/') + ".class"
                    archivePath(path)
                    val resource = uncached(task.findResource(path)) ?: throw absent
                    try {
                        stream(resource).use { stream ->
                            val bytes = stream.readAllBytes()
                            val origin = when (resource.protocol) {
                                "jar" -> (resource.openConnection() as JarURLConnection).jarFileURL
                                "file" -> {
                                    var root = Paths.get(resource.toURI())
                                    repeat(path.split('/').size) { root = root.parent }
                                    root.toUri().toURL()
                                }
                                else -> throw IllegalArgumentException("Untracked resource origin: $resource")
                            }
                            found = defineClass(name, bytes, 0, bytes.size, ProtectionDomain(CodeSource(origin, null as Array<Certificate>?), null))
                        }
                    } catch (failure: Exception) { throw ClassNotFoundException(name, failure) }
                }
            }
        }
        if (resolve) resolveClass(found)
        return found!!
    }
    override fun getResource(name: String): URL? {
        archivePath(name)
        if (owned(name.replace('/', '.'))) return uncached(findResource(name))
        val platform = parent.getResource(name)
        if (platform != null && platform.protocol == "jrt") return platform
        return uncached(task.findResource(name))
    }
    override fun getResources(name: String): Enumeration<URL> {
        val resource = getResource(name)
        return Collections.enumeration(if (resource == null) Collections.emptyList() else Collections.singletonList(resource))
    }
    @Throws(IOException::class)
    override fun close() { task.use { super.close() } }
}
