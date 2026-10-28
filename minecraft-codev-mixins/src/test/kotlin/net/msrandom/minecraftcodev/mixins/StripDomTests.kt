package net.msrandom.minecraftcodev.mixins

import kotlinx.serialization.json.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

class StripDomTests {
    @TempDir lateinit var root: Path
    private fun jar(config: String): Path = root.resolve("input.jar").also { path ->
        JarOutputStream(Files.newOutputStream(path)).use { out ->
            for ((name, bytes) in linkedMapOf(
                "nested/config.json" to config.toByteArray(),
                "fabric.mod.json" to "not metadata".toByteArray(),
                "META-INF/MANIFEST.MF" to "not a manifest".toByteArray(),
                "META-INF/neoforge.mods.toml" to "not TOML".toByteArray(),
                "fixture.list" to "missing-config.json".toByteArray(),
                "demo/Mixin.class" to byteArrayOf(1, 2),
                "refmap.json" to "not JSON".toByteArray()
            )) {
                out.putNextEntry(JarEntry(name)); out.write(bytes); out.closeEntry()
            }
        }
    }
    private fun read(path: Path, name: String = "nested/config.json"): ByteArray = JarFile(path.toFile()).use { jar ->
        jar.getInputStream(jar.getJarEntry(name)).use { it.readAllBytes() }
    }
    private fun strip(source: Path, entries: String): Path {
        val file = root.resolve("removals.json"); Files.writeString(file, entries)
        return root.resolve("output.jar").also { StripFixture(root, source, file, it).strip() }
    }

    @Test fun editsPreserveUnknownNestedFieldsAndUnnotifiedResourceBytes() {
        val config = """ {"mixins":["Good","Keep"],"custom":{"nested":[null,{"keep":true}]}} """
        val source = jar(config); val before = Files.readAllBytes(source)
        val changed = strip(source, """{"nested/config.json":["Good"]}""")
        assertEquals(Json.parseToJsonElement("""{"mixins":["Keep"],"custom":{"nested":[null,{"keep":true}]}}"""),
            Json.parseToJsonElement(String(read(changed))))
        JarFile(source.toFile()).use { jar ->
            for (entry in jar.entries()) if (entry.name != "nested/config.json")
                assertArrayEquals(read(source, entry.name), read(changed, entry.name), entry.name)
        }
        assertArrayEquals(config.toByteArray(), read(strip(source, """{"nested/config.json":["Absent"]}""")))
        assertArrayEquals(before, Files.readAllBytes(source))
    }

    @Test fun exactStringsAndEmptyArraysUseTheSameFileFormatAndTrackedDomDependencies() {
        val file = root.resolve("entries.json")
        val values = listOf("Nested.Good", "Dollar\$Name", "Unicode\u540d\u5b57")
        val implementation = implementationInputs()
        for (type in listOf(Json::class.java, kotlinx.serialization.KSerializer::class.java)) {
            assertTrue(implementation.contains(java.nio.file.Paths.get(type.protectionDomain.codeSource.location.toURI()).toString()))
        }
        Files.writeString(file, buildJsonObject {
            put("nested/config.json", JsonArray(values.map { JsonPrimitive(it) }))
            put("empty.json", JsonArray(emptyList()))
        }.toString())
        val source = jar(buildJsonObject { put("mixins", JsonArray((values + "Keep").map { JsonPrimitive(it) })) }.toString())
        val output = root.resolve("output.jar")
        StripFixture(root, source, file, output).strip()
        assertEquals("""{"mixins":["Keep"]}""", String(read(output)))
    }
}
