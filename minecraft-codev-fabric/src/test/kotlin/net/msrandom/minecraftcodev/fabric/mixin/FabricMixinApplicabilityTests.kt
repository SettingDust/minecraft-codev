package net.msrandom.minecraftcodev.fabric.mixin

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import net.msrandom.minecraftcodev.mixins.ExactMixinStripper
import net.msrandom.minecraftcodev.mixins.produceMixins
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.TempDir
import java.net.URLClassLoader
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.Collections
import java.util.Locale
import java.util.TreeMap
import java.util.jar.JarFile

class FabricMixinApplicabilityTests {
    @TempDir lateinit var root: Path
    lateinit var target: Path
    lateinit var mod: Path
    lateinit var output: Path
    lateinit var records: Path
    lateinit var mixin: ByteArray

    @BeforeEach
    fun fixture() {
        target = copy("target")
        mod = copy("client-mixins")
        mixin = entries(mod).getValue("demo/mixin/ClientOnly.class")
    }

    @AfterEach
    fun retain(info: TestInfo) {
        val destination = Paths.get("build/reports/test", "repair", info.testMethod.orElseThrow().name)
        Files.walk(root).use { files ->
            files.filter { Files.isRegularFile(it) }
                .filter { !root.relativize(it).toString().startsWith(".gradle") }
                .forEach { file ->
                    val copy = destination.resolve(root.relativize(file))
                    Files.createDirectories(copy.parent)
                    Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING)
                }
        }
    }

    private fun copy(name: String): Path = FabricInputs.copyJar(name, root.resolve("$name.jar"))

    private fun entries(path: Path): MutableMap<String, ByteArray> {
        val result = TreeMap<String, ByteArray>()
        JarFile(path.toFile()).use { jar ->
            for (entry in Collections.list(jar.entries())) {
                if (!entry.isDirectory) jar.getInputStream(entry).use { result[entry.name] = it.readAllBytes() }
            }
        }
        return result
    }

    private fun mod(name: String) {
        mod = copy(name)
    }

    private fun produce(label: String, side: String, sources: List<Path> = listOf(mod)) {
        output = root.resolve("$label-output.jar")
        records = root.resolve("$label.json")
        produceMixins(target.toString(), sources.map(Path::toString), emptyList(), side, output.toString(), records.toString())
    }

    private fun value(path: Path): Int = URLClassLoader(arrayOf(path.toUri().toURL()), javaClass.classLoader).use { loader ->
        val type = loader.loadClass("demo.Target")
        type.getMethod("value").invoke(type.getConstructor().newInstance()) as Int
    }

    private fun evidence(): JsonObject = JsonParser().parse(String(Files.readAllBytes(records), StandardCharsets.UTF_8)).asJsonObject

    private fun clean(label: String): Path {
        val cleaned = root.resolve("$label-clean.jar")
        ExactMixinStripper.clean(mod, records, cleaned)
        return cleaned
    }

    private fun check(label: String, side: String, active: Boolean) {
        val raw = Files.readAllBytes(mod)
        produce(label, side)
        assertEquals(if (active) 42 else 1, value(output))
        assertEquals(
            if (active) mapOf("client.json" to setOf("ClientOnly")) else emptyMap(),
            Gson().fromJson<Map<String, Set<String>>>(Files.readString(records), object : TypeToken<Map<String, Set<String>>>() {}.type),
        )
        val cleaned = clean(label)
        val before = entries(mod)
        val after = entries(cleaned)
        assertTrue(after.containsKey("client.json"))
        assertEquals(
            if (active) "[]" else "[\"ClientOnly\"]",
            JsonParser().parse(String(after.getValue("client.json"), StandardCharsets.UTF_8)).asJsonObject.getAsJsonArray("mixins").toString(),
        )
        val metadata = JsonParser().parse(String(after.getValue("fabric.mod.json"), StandardCharsets.UTF_8)).asJsonObject
        assertArrayEquals(before["fabric.mod.json"], after["fabric.mod.json"])
        if (!active) assertArrayEquals(before["client.json"], after["client.json"])
        for (resource in listOf("demo/mixin/ClientOnly.class", "keep.aw", "nested.jar")) {
            assertArrayEquals(before[resource], after[resource], resource)
        }
        if (metadata.has("accessWidener")) assertEquals("keep.aw", metadata.get("accessWidener").asString)
        if (metadata.has("custom")) assertTrue(metadata.getAsJsonObject("custom").get("keep").asBoolean)
        assertArrayEquals(raw, Files.readAllBytes(mod))
        println("PASS $label side=$side active=$active value=${value(output)} source=${Files.size(mod)} output=${Files.size(output)} records=${Files.size(records)} cleaned=${Files.size(cleaned)}")
        Files.copy(mod, root.resolve("$label-source.jar"), StandardCopyOption.REPLACE_EXISTING)
    }

    @Test
    fun discoveryMergesSidesAcrossIdenticalConfigsThroughProducer() {
        mod("client-mixins")
        val second = copy("server-mixins")
        val environments = linkedMapOf<String, MutableSet<String>>()
        val discover = Class.forName("net.msrandom.minecraftcodev.mixins.MixinInputsKt")
            .getMethod("discoverMixinConfigs", String::class.java, List::class.java, Map::class.java)
        assertEquals(listOf("client.json"), discover.invoke(null, target.toString(), listOf(mod.toString(), second.toString()), environments))
        assertEquals(mapOf("client.json" to setOf("client", "server")), environments)
        val raw = linkedMapOf<Path, ByteArray>()
        for (input in listOf(target, mod, second)) raw[input] = Files.readAllBytes(input)
        for (side in listOf("CLIENT", "SERVER")) {
            output = root.resolve("merged-$side.jar")
            records = root.resolve("merged-$side.json")
            produceMixins(target.toString(), listOf(mod.toString(), second.toString()), emptyList(), side, output.toString(), records.toString())
            assertEquals(42, value(output))
            assertEquals(JsonParser().parse("{\"client.json\":[\"ClientOnly\"]}"), evidence())
        }
        for ((input, bytes) in raw) assertArrayEquals(bytes, Files.readAllBytes(input))
    }

    @Test
    fun producerRespectsInputOwnership() {
        target = copy("input-config")
        val owned = root.resolve("input-config-output.jar")
        val cleanup = root.resolve("input-config-output.json")
        produceMixins(target.toString(), emptyList(), emptyList(), "CLIENT", owned.toString(), cleanup.toString())
        assertEquals(42, value(owned))
        assertEquals(mapOf("client.json" to setOf("ClientOnly")), Gson().fromJson(Files.readString(cleanup), object : TypeToken<Map<String, Set<String>>>() {}.type))
        assertArrayEquals(mixin, entries(owned)["demo/mixin/ClientOnly.class"])
        assertArrayEquals(entries(target)["client.json"], entries(owned)["client.json"])

        target = copy("input-config-external")
        mod("client-mixins")
        produceMixins(target.toString(), listOf(mod.toString()), emptyList(), "CLIENT", owned.toString(), cleanup.toString())
        assertEquals(42, value(owned))
        assertEquals(mapOf("client.json" to setOf("ClientOnly")), Gson().fromJson(Files.readString(cleanup), object : TypeToken<Map<String, Set<String>>>() {}.type))
        assertArrayEquals(entries(target)["client.json"], entries(owned)["client.json"])

        target = copy("input-config-external")
        val empty = copy("empty")
        produceMixins(target.toString(), emptyList(), listOf(empty.toString()), "SERVER", root.resolve("input-owned.jar").toString(), root.resolve("input-owned.json").toString())
        assertEquals(1, value(root.resolve("input-owned.jar")))
        assertEquals(emptyMap<String, Set<String>>(), Gson().fromJson(Files.readString(root.resolve("input-owned.json")), object : TypeToken<Map<String, Set<String>>>() {}.type))
    }

    @Test
    fun metadataEnvironmentControlsProducerAndCleanup() {
        for (environment in listOf("client", "server")) for (side in listOf("CLIENT", "SERVER")) {
            mod("$environment-mixins")
            check("$environment-$side", side, environment == side.lowercase(Locale.ROOT))
        }
        mod("scalar-reference")
        check("common-reference", "SERVER", true)

        mod("inactive-parent")
        produce("inactive-parent", "SERVER")
        assertEquals(1, value(output))
        assertEquals(JsonObject(), evidence())
        assertArrayEquals(entries(mod)["parent.json"], entries(clean("inactive-parent"))["parent.json"])
    }

    @Test
    fun rejectsMismatchedOrMissingApplicabilityBeforePublishing() {
        mod("invalid-reference")
        assertThrows(Exception::class.java) { produce("invalid", "SERVER") }
        assertFalse(Files.exists(output))
        mod("client-mixins")
        assertThrows(Exception::class.java) { produce("unknown", "UNKNOWN") }
        assertFalse(Files.exists(output))
        produceMixins(target.toString(), emptyList(), listOf(mod.toString()), "SERVER", root.resolve("runtime-only.jar").toString(), root.resolve("runtime-only.json").toString())
        assertEquals(1, value(root.resolve("runtime-only.jar")))
    }
}
