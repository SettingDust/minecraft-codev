package net.msrandom.minecraftcodev.mixins

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.*
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.OutputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.util.Collections
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.CRC32
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

/** Internal staged JAR writer used by StripMixins; no engine or metadata replay. */
object ExactMixinStripper {
    @JvmStatic
    @Throws(IOException::class)
    fun clean(source: Path, cleanup: Path, staged: Path) {
        staged.outputStream().use { rewrite(source, cleanup, it) }
    }

    // The output is closed before the caller may deliver its staging file.
    @OptIn(ExperimentalSerializationApi::class)
    @JvmStatic
    @Throws(IOException::class)
    fun rewrite(source: Path, cleanup: Path, stream: OutputStream) {
        val json = cleanup.inputStream().use { Json.decodeFromStream<JsonObject>(it) }
        val removals = json.mapValues { (_, entries) ->
            entries.jsonArray.mapTo(linkedSetOf()) { it.jsonPrimitive.content }
        }
        JarOutputStream(stream).use { output ->
            JarFile(source.toFile()).use { archive ->
                for (entry in Collections.list(archive.entries())) {
                    val path = entry.name
                    val remove = removals[path]
                    val bytes = if (!remove.isNullOrEmpty() || entry.method == JarEntry.STORED) {
                        val original = archive.getInputStream(entry).use { it.readAllBytes() }
                        if (!remove.isNullOrEmpty()) {
                            try { edit(original, remove) }
                            catch (failure: Exception) { throw IOException("Cannot strip config $path in $source", failure) }
                        } else original
                    } else null
                    val copy = JarEntry(entry)
                    // Compression size/CRC belong to the original bytes, not an edited config.
                    copy.compressedSize = -1
                    if (copy.method == JarEntry.STORED) {
                        copy.size = bytes!!.size.toLong()
                        copy.crc = CRC32().apply { update(bytes) }.value
                    }
                    output.putNextEntry(copy)
                    if (bytes != null) output.write(bytes)
                    else archive.getInputStream(entry).use { it.copyTo(output) }
                    output.closeEntry()
                }
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun edit(bytes: ByteArray, remove: Set<String>): ByteArray {
        val config = ByteArrayInputStream(bytes).use { Json.decodeFromStream<JsonObject>(it) }
        var changed = false
        val fields = config.toMutableMap()
        for (kind in listOf("mixins", "client", "server")) {
            val field = config[kind] ?: continue
            val array = field.jsonArray
            fields[kind] = JsonArray(array.filter { entry ->
                val matches = entry.jsonPrimitive.content in remove
                if (matches) changed = true
                !matches
            })
        }
        return if (changed) JsonObject(fields).toString().toByteArray(StandardCharsets.UTF_8) else bytes
    }
}
