package net.msrandom.minecraftcodev.mixins

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import java.util.Random
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.CRC32

/** Real Strip preserves untouched archive entries while editing the notified config. */
class StripStreamTests {
    @TempDir lateinit var root: Path
    private lateinit var source: Path
    private lateinit var cleanup: Path
    private lateinit var output: Path
    private val resource = ByteArray(40001)

    @BeforeEach fun fixture() {
        source = root.resolve("input.jar")
        cleanup = root.resolve("cleanup.json")
        output = root.resolve("output.jar")
        Random(31).nextBytes(resource)
        Files.writeString(cleanup, "{\"fixture.json\":[\"Good\"],\"unchanged.json\":[\"Absent\"]}")
        JarOutputStream(Files.newOutputStream(source)).use { jar ->
            for (name in listOf("assets/", "assets/data", "empty", "stored", "fixture.json", "unchanged.json")) {
                val bytes = when {
                    name == "assets/data" || name == "stored" -> resource
                    name.endsWith(".json") -> " {\"mixins\":[\"Good\"],\"unknown\":true} \n".toByteArray()
                    else -> byteArrayOf()
                }
                val entry = JarEntry(name)
                entry.time = 1700000000000L
                entry.comment = "kept $name"
                entry.extra = byteArrayOf(0xfe.toByte(), 0xca.toByte(), 0, 0)
                if (name == "stored" || name == "fixture.json") {
                    entry.method = JarEntry.STORED
                    entry.size = bytes.size.toLong()
                    entry.crc = CRC32().apply { update(bytes) }.value
                }
                jar.putNextEntry(entry)
                jar.write(bytes)
                jar.closeEntry()
            }
        }
    }

    @Test fun streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes() {
        val original = Files.readAllBytes(source)
        StripFixture(root, source, cleanup, output).strip()
        JarFile(source.toFile()).use { input ->
            JarFile(output.toFile()).use { result ->
                assertEquals(input.entries().asSequence().map { it.name }.toList(), result.entries().asSequence().map { it.name }.toList())
                for (entry in input.entries()) {
                    val actual = result.getJarEntry(entry.name)
                    assertEquals(entry.method, actual.method)
                    assertEquals(entry.time, actual.time)
                    assertEquals(entry.comment, actual.comment)
                    assertArrayEquals(entry.extra, actual.extra)
                    assertEquals(entry.isDirectory, actual.isDirectory)
                    val bytes = result.getInputStream(actual).use { it.readAllBytes() }
                    if (entry.name == "fixture.json") assertEquals("{\"mixins\":[],\"unknown\":true}", String(bytes, Charsets.UTF_8))
                    else assertArrayEquals(input.getInputStream(entry).use { it.readAllBytes() }, bytes, entry.name)
                    val crc = CRC32().apply { update(bytes) }
                    assertEquals(bytes.size.toLong(), actual.size)
                    assertEquals(crc.value, actual.crc)
                }
            }
        }
        assertArrayEquals(original, Files.readAllBytes(source))
    }
}
