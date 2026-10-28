package net.msrandom.minecraftcodev.forge.mixin

import net.msrandom.minecraftcodev.mixins.ExactMixinStripper
import net.msrandom.minecraftcodev.forge.jarjar.ForgeJarJarRule
import net.msrandom.minecraftcodev.mixins.produceMixins
import kotlinx.serialization.json.*
import net.neoforged.accesstransformer.cli.TransformerProcessor
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.TempDir
import org.objectweb.asm.ClassReader
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import java.io.PrintStream
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.jar.JarFile

class ForgeAccessTransformAndJarJarCompatibilityTests {
    @TempDir
    lateinit var temp: Path

    @AfterEach
    fun retain(info: TestInfo) {
        val destination = Path.of("build/reports/test", "retained-baseline", info.testMethod.orElseThrow().name)
        Files.walk(temp).use { files ->
            files.filter { Files.isRegularFile(it) }.forEach {
                val target = destination.resolve(temp.relativize(it))
                Files.createDirectories(target.parent)
                Files.copy(it, target, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    private fun read(path: Path, name: String): ByteArray = JarFile(path.toFile()).use { archive ->
        archive.getInputStream(archive.getJarEntry(name)).use { it.readAllBytes() }
    }

    private fun entries(path: Path): Map<String, ByteArray> = JarFile(path.toFile()).use { archive ->
        archive.entries().asSequence().filterNot { it.isDirectory }.associate { it.name to read(path, it.name) }
    }

    private fun g1(input: Path, label: String): Path {
        val output = temp.resolve("$label.jar")
        val records = temp.resolve("$label.records.json")
        // Real no-config producer; no full Forge task claim.
        produceMixins(input.toString(), emptyList(), emptyList(), "SERVER", output.toString(), records.toString())
        assertEquals(emptyMap<String, Set<String>>(), Json.parseToJsonElement(Files.readString(records)).jsonObject.mapValues { (_, entries) -> entries.jsonArray.map { it.jsonPrimitive.content }.toSet() })
        val stripped = temp.resolve("$label-stripped.jar")
        ExactMixinStripper.clean(output, records, stripped)
        return stripped
    }

    private fun reopenNested(bytes: ByteArray, label: String) {
        val extracted = temp.resolve("$label-embedded.jar")
        Files.write(extracted, bytes)
        JarFile(extracted.toFile()).use { archive ->
            assertEquals("fixture.embedded", archive.manifest.mainAttributes.getValue("Automatic-Module-Name"))
            assertArrayEquals("fixture-embedded-payload\n".toByteArray(), read(extracted, "payload.bin"))
            assertEquals("{\"keep\":true}", String(read(extracted, "META-INF/vendor.json")))
        }
    }

    @Test
    fun jarJarRemovalDeletesListedPayloadAndMetadataOnly() {
        val original = ForgeInputs.copyJar("access-input", temp.resolve("nested-before-g1.jar"))
        val processed = g1(original, "nested-after-g1")
        assertEquals(entries(original).keys, entries(processed).keys)
        for ((name, content) in entries(original)) assertArrayEquals(content, read(processed, name), name)
        reopenNested(read(original, "META-INF/jarjar/embedded.jar"), "before-g1")
        reopenNested(read(processed, "META-INF/jarjar/embedded.jar"), "after-g1")

        fun cleanup(source: Path, name: String): Pair<Path, Boolean> {
            val cleaned = temp.resolve(name)
            Files.copy(source, cleaned)
            val directoryRetained = FileSystems.newFileSystem(
                URI.create("jar:${cleaned.toUri()}"),
                mapOf<String, Any>("create" to false),
            ).use { fs ->
                val root = fs.getPath("/")
                val handler = ForgeJarJarRule().load(root)!!
                assertEquals(listOf("META-INF/jarjar/embedded.jar"), handler.list(root))
                handler.list(root).forEach { Files.delete(root.resolve(it)) }
                handler.remove(root)
                assertNull(ForgeJarJarRule().load(root))
                val directory = root.resolve("META-INF/jarjar")
                if (Files.exists(directory)) Files.newDirectoryStream(directory).use { assertFalse(it.iterator().hasNext()) }
                Files.exists(directory)
            }
            return cleaned to directoryRetained
        }

        val (baselineCleaned, beforeDirectoryRetained) = cleanup(original, "nested-baseline-cleaned.jar")
        val (cleaned, afterDirectoryRetained) = cleanup(processed, "nested-cleaned.jar")
        assertEquals(beforeDirectoryRetained, afterDirectoryRetained)
        val remaining = entries(cleaned)
        assertEquals(entries(baselineCleaned).keys, remaining.keys)
        for ((name, content) in entries(baselineCleaned)) assertArrayEquals(content, remaining[name], name)
        assertFalse(remaining.containsKey("META-INF/jarjar/metadata.json"))
        assertFalse(remaining.containsKey("META-INF/jarjar/embedded.jar"))
        for ((name, content) in entries(original)) if (!name.startsWith("META-INF/jarjar/")) assertArrayEquals(content, remaining[name], name)
        reopenNested(read(cleaned, "unlisted.jar"), "retained")
        println("NESTED_REOPEN stripped payload and unrelated resources preserved; ordinary JarJar cleanup unchanged")
    }

    private fun access(path: Path): Map<String, Int> {
        val node = ClassNode()
        ClassReader(read(path, "demo/AccessTarget.class")).accept(node, 0)
        return mapOf(
            "secret" to node.fields.single { it.name == "secret" }.access,
            "hidden" to node.methods.single { it.name == "hidden" }.access,
        )
    }

    private fun cli(input: Path, at: Path, label: String): Path {
        val output = temp.resolve("$label.jar")
        val arguments = arrayOf(
            "--inJar",
            input.toAbsolutePath().toString(),
            "--outJar",
            output.toAbsolutePath().toString(),
            "--atFile",
            at.toAbsolutePath().toString(),
        )
        val oldErr = System.err
        val oldOut = System.out
        try {
            PrintStream(Files.newOutputStream(temp.resolve("$label.stderr.log"))).use { err ->
                PrintStream(Files.newOutputStream(temp.resolve("$label.stdout.log"))).use { out ->
                    System.setErr(err)
                    System.setOut(out)
                    TransformerProcessor.main(*arguments)
                }
            }
        } finally {
            System.setErr(oldErr)
            System.setOut(oldOut)
        }
        return output
    }

    @Test
    fun actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload() {
        val input = ForgeInputs.copyJar("access-input", temp.resolve("at-before-g1.jar"))
        val transformed = g1(input, "at-after-g1")
        val at = temp.resolve("access.cfg")
        Files.writeString(at, "public-f demo.AccessTarget secret\npublic demo.AccessTarget hidden()I\n")
        val baseline = cli(input, at, "at-baseline")
        val result = cli(transformed, at, "at-current")
        assertEquals(access(input), access(transformed))
        assertEquals(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL, access(input)["secret"])
        assertEquals(Opcodes.ACC_PRIVATE, access(input)["hidden"])
        assertEquals(
            mapOf("secret" to Opcodes.ACC_PUBLIC, "hidden" to Opcodes.ACC_PUBLIC),
            access(result),
        )
        assertEquals(access(baseline), access(result))
        for (name in listOf("META-INF/vendor.json", "META-INF/jarjar/embedded.jar")) {
            assertArrayEquals(read(input, name), read(transformed, name))
            assertArrayEquals(read(input, name), read(baseline, name))
            assertArrayEquals(read(input, name), read(result, name))
        }
        reopenNested(read(result, "META-INF/jarjar/embedded.jar"), "at-retained")
        println("AT_ACCESS_OBSERVATION before=${access(input)} after=${access(result)}; stripped nested payload preserved")
    }
}
