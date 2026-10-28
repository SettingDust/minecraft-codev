package net.msrandom.minecraftcodev.forge.mixin

import com.electronwill.nightconfig.core.Config
import com.electronwill.nightconfig.toml.TomlParser
import net.msrandom.minecraftcodev.core.FileListingRules
import net.msrandom.minecraftcodev.core.ListedFileHandler
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.ConfigSide
import net.msrandom.minecraftcodev.mixins.MixinConfigReference
import net.msrandom.minecraftcodev.mixins.produceMixins
import net.msrandom.minecraftcodev.mixins.ExactMixinStripper

import kotlinx.serialization.json.*
import org.junit.jupiter.api.AfterEach

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.TempDir
import java.net.URI
import java.net.URLClassLoader
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.jar.Attributes
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.jar.Manifest

class ForgeMixinMetadataTests {
    @TempDir
    lateinit var temp: Path

    @AfterEach
    fun retain(info: TestInfo) {
        val destination = Path.of("build/reports/test", "metadata", info.testMethod.orElseThrow().name)
        Files.list(temp).use { files ->
            files.filter { Files.isRegularFile(it) }.forEach {
                Files.createDirectories(destination)
                Files.copy(it, destination.resolve(it.fileName), StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    @Test
    fun manifestDiscoveryTrimsBlanksWithoutWritingMetadata() {
        val jar = temp.resolve("forge.jar")
        val manifest = Manifest().apply {
            mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
            mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, " a.json, , b.json, ")
            mainAttributes.putValue("Automatic-Module-Name", "demo")
        }
        jar(jar, manifest, mapOf("a.json" to byteArrayOf(1), "b.json" to byteArrayOf(2), "keep.txt" to byteArrayOf(9)))
        Files.copy(jar, temp.resolve("forge-before.jar"))
        open(jar).use { fs ->
            val handler = ForgeMixinListingRule().load(fs.getPath("/"))!!
            assertEquals(listOf("a.json", "b.json"), handler.references.map { it.resource }.distinct())
        }
        JarFile(jar.toFile()).use { archive ->
            val attributes = archive.manifest.mainAttributes
            assertEquals(" a.json, , b.json, ", attributes.getValue(MANIFEST_MIXINS_CONFIG))
            assertEquals("demo", attributes.getValue("Automatic-Module-Name"))
            assertTrue(archive.getJarEntry("keep.txt") != null)
        }
    }

    @Test
    fun neoforgeTomlDiscoveryRetainsEveryEntry() {
        val jar = temp.resolve("neoforge.jar")
        jar(
            jar,
            null,
            mapOf(
                "META-INF/neoforge.mods.toml" to """[vendor]
keep=true

[[mixins]]
config="a.json"
environment="client"

[[mixins]]
config="b.json"
""".toByteArray(),
                "a.json" to byteArrayOf(1),
                "b.json" to byteArrayOf(2),
                "keep.txt" to byteArrayOf(9),
            ),
        )
        Files.copy(jar, temp.resolve("neoforge-before.jar"))
        open(jar).use { fs ->
            val handler = NeoForgeMixinListingRule().load(fs.getPath("/"))!!
            assertEquals(listOf("a.json", "b.json"), handler.references.map { it.resource }.distinct())
        }
        JarFile(jar.toFile()).use { archive ->
            val toml = archive.getInputStream(archive.getJarEntry("META-INF/neoforge.mods.toml")).reader().readText()
            val parsed = com.electronwill.nightconfig.toml.TomlParser().parse(toml)
            val entries = parsed.get<List<com.electronwill.nightconfig.core.Config>>("mixins")
            assertEquals(listOf("a.json", "b.json"), entries.map { it.get<String>("config") })
            assertEquals(true, parsed.get<Boolean>("vendor.keep"))
            assertTrue(archive.getJarEntry("keep.txt") != null)
        }
    }

    @Test
    fun producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata() {
        val target = ForgeInputs.copyJar("target", temp.resolve("producer-target.jar"))
        val source = ForgeInputs.copyJar("producer-source", temp.resolve("producer-source.jar"))
        val raw = Files.readAllBytes(source)
        val output = temp.resolve("producer-output.jar")
        val cleanup = temp.resolve("producer-cleanup.json")
        produceMixins(target.toString(), listOf(source.toString()), emptyList(), "SERVER", output.toString(), cleanup.toString())
        assertEquals(mapOf("consumed.json" to setOf("Consumed")), Json.parseToJsonElement(Files.readString(cleanup)).jsonObject.mapValues { (_, entries) -> entries.jsonArray.map { it.jsonPrimitive.content }.toSet() })
        URLClassLoader(arrayOf(output.toUri().toURL()), javaClass.classLoader).use { loader ->
            val type = loader.loadClass("demo.Target")
            assertEquals(42, type.getMethod("value").invoke(type.getConstructor().newInstance()))
        }
        assertArrayEquals(raw, Files.readAllBytes(source))
    }

    @Test
    fun dualMetadataDiscoveryAndExactEditingPreserveReferences() {
        val original = ForgeInputs.copyJar("target", temp.resolve("original.jar"))
        val source = ForgeInputs.copyJar("producer-source", temp.resolve("dual-source.jar"))
        val manifestNames = listOf("retained-second.json", "consumed.json", "retained-first.json")
        val manifest = JarFile(source.toFile()).use { it.manifest }
        val entries = JarFile(source.toFile()).use { archive ->
            archive.entries().asSequence().filterNot { it.isDirectory }.associate { entry ->
                entry.name to archive.getInputStream(entry).use { it.readAllBytes() }
            }
        }
        val before = Files.readAllBytes(source)
        Files.copy(source, temp.resolve("dual-source-before.jar"))
        open(source).use { fs ->
            val root = fs.getPath("/")
            val handler = ForgeMixinListingRule().load(root)!!
            assertEquals(manifestNames, handler.references.map { it.resource }.distinct())
        }
        val configs = listOf(source.toString())
        val output = temp.resolve("transformed.jar")
        val records = temp.resolve("dual.records.json")
        produceMixins(original.toString(), configs, emptyList(), "SERVER", output.toString(), records.toString())
        for ((path, expected) in listOf(original to 1, output to 42)) {
            URLClassLoader(arrayOf(path.toUri().toURL()), javaClass.classLoader).use { loader ->
                val type = loader.loadClass("demo.Target")
                assertEquals(expected, type.getMethod("value").invoke(type.getConstructor().newInstance()))
            }
        }
        assertEquals(mapOf("consumed.json" to setOf("Consumed")), Json.parseToJsonElement(Files.readString(records)).jsonObject.mapValues { (_, entries) -> entries.jsonArray.map { it.jsonPrimitive.content }.toSet() })
        val cleaned = temp.resolve("dual-cleaned.jar")

        ExactMixinStripper.clean(source, records, cleaned)
        JarFile(cleaned.toFile()).use { archive ->
            assertEquals(manifest, archive.manifest)
            assertTrue(archive.getJarEntry("consumed.json") != null)
            val consumed = archive.getInputStream(archive.getJarEntry("consumed.json")).use { com.google.gson.JsonParser().parse(it.reader()).asJsonObject }
            val expected = com.google.gson.JsonParser().parse(entries.getValue("consumed.json").decodeToString()).asJsonObject
            expected.add("mixins", com.google.gson.JsonArray())
            assertEquals(expected, consumed)
            for ((name, bytes) in entries) {
                if (name == "consumed.json") continue
                val actual = archive.getInputStream(archive.getJarEntry(name)).use { it.readAllBytes() }
                assertArrayEquals(bytes, actual, name)
            }
        }
        open(cleaned).use { fs ->
            val root = fs.getPath("/")
            assertEquals(manifestNames, ForgeMixinListingRule().load(root)!!.references.map { it.resource }.distinct())
        }
        assertArrayEquals(before, Files.readAllBytes(source), "Source JAR must not be changed by selective cleanup")
        println("DUAL_METADATA_REOPEN SERVER original=1 transformed=42 emptied=consumed.json allMetadataPreserved=true sourceUnchanged=true")
    }

    @Test
    fun originalNullableContractEmptyHandlersAndConstructors() {
        val forge: MixinListingRule = ForgeMixinListingRule()
        val neo: MixinListingRule = NeoForgeMixinListingRule()
        assertNull(forge.load(temp))
        assertNull(neo.load(temp))
        val metadata = Files.createDirectories(temp.resolve("META-INF"))
        Files.writeString(metadata.resolve("MANIFEST.MF"), "Manifest-Version: 1.0\r\n\r\n")
        Files.writeString(metadata.resolve("neoforge.mods.toml"), "[vendor]\nkeep=true\n")
        assertNull(forge.load(temp))
        assertNull(neo.load(temp))
        Files.writeString(metadata.resolve("MANIFEST.MF"), "Manifest-Version: 1.0\r\nMixinConfigs: \r\n\r\n")
        Files.writeString(metadata.resolve("neoforge.mods.toml"), "mixins=[]\n")
        assertEquals(emptyList<String>(), forge.load(temp)!!.list(temp))
        assertEquals(emptyList<String>(), neo.load(temp)!!.list(temp))
        val names = mutableListOf("a", "a")
        val direct = ForgeMixinConfigHandler(names)
        names.add("b")
        assertEquals(listOf("a", "a"), direct.list(temp))
        val configs = TomlParser().parse("[[mixins]]\nconfig=\"a\"\n").get<MutableList<Config>>("mixins")
        val directNeo = NeoForgeMixinConfigHandler(configs)
        configs.clear()
        assertEquals(listOf(MixinConfigReference("a", ConfigSide.COMMON)), directNeo.references)
    }

    @Test
    fun closedZipHandlersPersistRemovalForBothMetadataFormats() {
        val rules: List<FileListingRules> = java.util.ServiceLoader.load(MixinListingRule::class.java).filter { it is ForgeMixinListingRule || it is NeoForgeMixinListingRule }
        for (kind in listOf("manifest", "toml", "dual")) {
            val names = listOf("a.json", "b.json", "a.json")
            val manifest = Manifest().apply {
                mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
                mainAttributes.putValue("Automatic-Module-Name", "demo")
                entries["keep.txt"] = Attributes().apply { putValue("Vendor-Flag", "retained") }
                if (kind != "toml") mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, names.joinToString(", "))
            }
            val entries = linkedMapOf("a.json" to byteArrayOf(1), "b.json" to byteArrayOf(2), "keep.txt" to byteArrayOf(9))
            if (kind != "manifest") entries["META-INF/neoforge.mods.toml"] = """modLoader="javafml"
[vendor]
keep=true
[[mixins]]
config="a.json"
[[mixins]]
config="b.json"
environment="client"
vendor=7
[[mixins]]
config="a.json"
""".toByteArray()
            val source = temp.resolve("$kind-source.jar")
            jar(source, manifest, entries)
            val before = Files.readAllBytes(source)
            val loaded = open(source).use { fs -> rules.mapNotNull { it.load(fs.getPath("/")) as MixinConfigHandler? } }
            val listed = if (kind == "dual") names + names else names
            assertEquals(listed, loaded.flatMap { it.list(temp.resolve("closed-zip")) })
            assertEquals(listed.map { MixinConfigReference(it, ConfigSide.COMMON) }, loaded.flatMap { it.references })
            assertArrayEquals(before, Files.readAllBytes(source))
            assertEquals(listOf("a.json", "b.json"), loaded.flatMap { it.references }.map { it.resource }.distinct())
            val copy = Files.copy(source, temp.resolve("$kind-remove.jar"))
            assertEquals(listed, loaded.flatMap { it.list(temp) })
            open(copy).use { fs ->
                for (handler in loaded) {
                    val coreHandler: ListedFileHandler = handler
                    coreHandler.remove(fs.getPath("/"))
                }
            }
            JarFile(copy.toFile()).use { archive ->
                val expected = Manifest(manifest)
                if (kind != "toml") {
                    expected.mainAttributes.remove(Attributes.Name(MANIFEST_MIXINS_CONFIG))
                }
                assertEquals(expected, archive.manifest)
                if (kind != "manifest") {
                    val toml = archive.getInputStream(archive.getJarEntry("META-INF/neoforge.mods.toml")).use { TomlParser().parse(it.reader()) }
                    assertEquals("javafml", toml.get<String>("modLoader"))
                    assertEquals(true, toml.get<Boolean>("vendor.keep"))
                    assertNull(toml.get<Any>("mixins"))
                }
                entries.filterKeys { !it.endsWith(".toml") }.forEach { (name, bytes) ->
                    assertArrayEquals(bytes, archive.getInputStream(archive.getJarEntry(name)).use { it.readAllBytes() }, name)
                }
            }
            open(copy).use { fs ->
                val restored = rules.mapNotNull { it.load(fs.getPath("/")) as MixinConfigHandler? }
                assertTrue(restored.isEmpty())
            }
            assertEquals(listed, loaded.flatMap { it.list(temp) })
            assertEquals(listed.map { MixinConfigReference(it, ConfigSide.COMMON) }, loaded.flatMap { it.references })
            Files.move(copy, temp.resolve("$kind-remove-closed.jar"))
            assertArrayEquals(before, Files.readAllBytes(source))
        }
    }

    @Test
    fun manifestEditsCurrentReferencesAndAttributesWithoutChangingTomlOrSnapshot() {
        val source = temp.resolve("current-manifest.jar")
        val initial = Manifest().apply {
            mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
            mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, "a.json, b.json")
        }
        jar(source, initial, mapOf("META-INF/neoforge.mods.toml" to "[[mixins]]\nconfig=\"different.json\"\n".toByteArray(), "keep.txt" to byteArrayOf(9)))
        val handler = open(source).use { ForgeMixinListingRule().load(it.getPath("/"))!! }
        assertFalse(handler.javaClass.methods.any { it.name == "removeConfigs" })
        val snapshot = handler.references.toList()
        val copy = Files.copy(source, temp.resolve("current-manifest-remove.jar"))
        open(copy).use { fs ->
            val root = fs.getPath("/")
            val path = root.resolve(JarFile.MANIFEST_NAME)
            val current = Manifest(initial).apply {
                mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, "b.json, a.json, new.json, a.json, explicit.json")
                mainAttributes.putValue("Vendor-New", "current")
                entries["keep.txt"] = Attributes().apply { putValue("Vendor-Entry", "new") }
            }
            Files.newOutputStream(path).use(current::write)
            val toml = Files.readAllBytes(root.resolve("META-INF/neoforge.mods.toml"))
            handler.remove(root)
            current.mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, "new.json, explicit.json")
            assertEquals(current, Files.newInputStream(path).use(::Manifest))
            assertArrayEquals(toml, Files.readAllBytes(root.resolve("META-INF/neoforge.mods.toml")))
            assertArrayEquals(byteArrayOf(9), Files.readAllBytes(root.resolve("keep.txt")))
            assertEquals(snapshot, handler.references)
            assertEquals(listOf("a.json", "b.json"), handler.list(root))
            current.mainAttributes.remove(Attributes.Name(MANIFEST_MIXINS_CONFIG))
            Files.newOutputStream(path).use(current::write)
            val absent = Files.readAllBytes(path)
            handler.remove(root)
            assertArrayEquals(absent, Files.readAllBytes(path))
        }
        Files.move(copy, temp.resolve("current-manifest-remove-closed.jar"))
        assertThrows(Exception::class.java) { handler.remove(temp.resolve("missing")) }
    }

    @Test
    fun manifestChangedReferencesRemainOutsideRemovalSet() {
        val metadata = Files.createDirectories(temp.resolve("META-INF"))
        val manifest = metadata.resolve("MANIFEST.MF")
        val toml = metadata.resolve("neoforge.mods.toml")
        Files.writeString(manifest, "Manifest-Version: 1.0\r\nMixinConfigs: a.json\r\n\r\n")
        Files.writeString(toml, "[[mixins]]\nconfig=\"different.json\"\n")
        val handler = ForgeMixinListingRule().load(temp)!!
        val beforeToml = Files.readAllBytes(toml)
        handler.remove(temp)
        assertNull(ForgeMixinListingRule().load(temp))
        assertArrayEquals(beforeToml, Files.readAllBytes(toml))
        Files.writeString(manifest, "Manifest-Version: 1.0\r\nMixinConfigs: changed.json\r\n\r\n")
        handler.remove(temp)
        assertEquals(listOf("changed.json"), ForgeMixinListingRule().load(temp)!!.list(temp))
        assertThrows(Exception::class.java) { handler.remove(temp.resolve("missing")) }
    }

    @Test
    fun actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy() {
        val manifest = Manifest().apply {
            mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
            mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, " a.json, a.json, b.json, ")
        }
        val source = temp.resolve("snapshot.jar")
        jar(source, manifest, mapOf("META-INF/neoforge.mods.toml" to "[[mixins]]\nconfig=\"neo.json\"\nenvironment=\"vendor-value\"\n".toByteArray()))
        val before = Files.readAllBytes(source)
        val rules = java.util.ServiceLoader.load(MixinListingRule::class.java).filter { it is ForgeMixinListingRule || it is NeoForgeMixinListingRule }
        assertEquals(2, rules.size)
        val handlers = open(source).use { fs -> rules.map { it.load(fs.getPath("/"))!! } }
        val expected = listOf(listOf("a.json", "a.json", "b.json"), listOf("neo.json"))
        assertEquals(expected, handlers.map { it.list(temp) })
        for ((handler, names) in handlers.zip(expected)) {
            val core: ListedFileHandler = handler
            assertEquals(names, core.list(temp.resolve("closed-zip")))
            assertEquals(names.map { MixinConfigReference(it, ConfigSide.COMMON) }, handler.references)
            assertThrows(UnsupportedOperationException::class.java) { (handler.references as MutableList).clear() }
        }
        assertArrayEquals(before, Files.readAllBytes(source))
    }

    @Test
    fun neoForgeEditsCurrentTomlWithoutChangingManifestOrSnapshot() {
        val source = temp.resolve("current.jar")
        val manifest = Manifest().apply {
            mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
            mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, "forge-only.json")
            entries["keep.txt"] = Attributes().apply { putValue("Vendor-Flag", "keep") }
        }
        val original = "[[mixins]]\nconfig=\"a.json\"\n[[mixins]]\nconfig=\"b.json\"\n"
        jar(source, manifest, mapOf("META-INF/neoforge.mods.toml" to original.toByteArray(), "keep.txt" to byteArrayOf(9)))
        val handler = open(source).use { NeoForgeMixinListingRule().load(it.getPath("/"))!! }
        assertFalse(handler.javaClass.methods.any { it.name == "removeConfigs" })
        val snapshot = handler.references.toList()
        val current = TomlParser().parse(original + """
[[mixins]]
config="a.json"
[[mixins]]
config="new.json"
environment={vendor="not-a-side"}
extra=[1,2]
[vendor]
unknown={nested=["keep", "all"]}
""")
        val copy = Files.copy(source, temp.resolve("current-remove.jar"))
        open(copy).use { fs ->
            val root = fs.getPath("/")
            val path = root.resolve("META-INF/neoforge.mods.toml")
            Files.newBufferedWriter(path).use { com.electronwill.nightconfig.toml.TomlWriter().write(current, it) }
            val manifestBytes = Files.readAllBytes(root.resolve(JarFile.MANIFEST_NAME))
            handler.remove(root)
            val expected = TomlParser().parse(com.electronwill.nightconfig.toml.TomlWriter().writeToString(current))
            val kept = expected.get<List<Config>>("mixins").filterNot { it.get<String>("config") in setOf("a.json", "b.json") }
            expected.set<Any>("mixins", kept)
            assertEquals(expected, Files.newBufferedReader(path).use(TomlParser()::parse))
            assertArrayEquals(manifestBytes, Files.readAllBytes(root.resolve(JarFile.MANIFEST_NAME)))
            assertArrayEquals(byteArrayOf(9), Files.readAllBytes(root.resolve("keep.txt")))
            assertEquals(listOf("new.json"), NeoForgeMixinListingRule().load(root)!!.list(root))
            assertEquals(snapshot, handler.references)
            Files.writeString(path, "[vendor]\nkeep=true\n")
            val absent = Files.readAllBytes(path)
            handler.remove(root)
            assertArrayEquals(absent, Files.readAllBytes(path))
        }
        Files.move(copy, temp.resolve("current-remove-closed.jar"))
    }

    @Test
    fun malformedMetadataAndBusinessPathsStillFailWithoutWrites() {
        val metadata = Files.createDirectories(temp.resolve("META-INF"))
        val manifest = metadata.resolve("MANIFEST.MF")
        val toml = metadata.resolve("neoforge.mods.toml")
        for (input in listOf("not a manifest\r\n", "Manifest-Version: 1.0\r\nMixinConfigs: /a.json\r\n\r\n", "Manifest-Version: 1.0\r\nMixinConfigs: C:/a.json\r\n\r\n")) {
            Files.writeString(manifest, input)
            assertThrows(Exception::class.java) { ForgeMixinListingRule().load(temp) }
            assertEquals(input, Files.readString(manifest))
        }
        val forgeHandler = ForgeMixinConfigHandler(listOf("a.json"))
        for (input in listOf("not a manifest\r\n") + listOf("/a.json", "C:/a.json", "../a.json", "a/./b.json", "a\\b.json", "a\u0000.json").map { "Manifest-Version: 1.0\r\nMixinConfigs: $it\r\n\r\n" }) {
            Files.writeString(manifest, input)
            assertThrows(Exception::class.java) { forgeHandler.remove(temp) }
            assertEquals(input, Files.readString(manifest))
        }
        Files.delete(manifest)
        Files.writeString(toml, "[[mixins]]\nconfig=\"a.json\"\n")
        val handler = NeoForgeMixinListingRule().load(temp)!!
        val invalid = listOf("[[mixins]", "mixins={}", "mixins=1", "mixins=[1]", "[[mixins]]\nconfig=1", "[[mixins]]\nother=1") +
            listOf("", " ", "a\u0000.json", "/a.json", "C:/a.json", "../a.json", "a/./b.json", "a\\b.json").map { "[[mixins]]\nconfig=\"$it\"" }
        for (input in invalid.map { it.toByteArray() } + listOf("[[mixins]]\nconfig=\"a.json\"\n[vendor]\nlabel=\"".toByteArray() + byteArrayOf(0xc3.toByte(), 0x28) + "\"".toByteArray())) {
            Files.write(toml, input)
            assertThrows(Exception::class.java) { NeoForgeMixinListingRule().load(temp) }
            assertThrows(Exception::class.java) { handler.remove(temp) }
            assertArrayEquals(input, Files.readAllBytes(toml))
        }
        Files.delete(toml)
        assertThrows(Exception::class.java) { handler.remove(temp) }
        assertTrue(Files.notExists(toml), "missing metadata must not be recreated")
    }

    @Test
    fun hostDiscoverySeesBothDistinctFormatsAndSingleFormatArchives() {
        val discover = Class.forName("net.msrandom.minecraftcodev.mixins.MixinInputsKt").getDeclaredMethod(
            "discoverMixinConfigs", String::class.java, List::class.java, Map::class.java,
        )
        for (kind in listOf("manifest", "toml", "dual")) {
            val manifest = Manifest().apply {
                mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
                if (kind != "toml") mainAttributes.putValue(MANIFEST_MIXINS_CONFIG, "forge.json")
            }
            val source = temp.resolve("host-$kind.jar")
            val entries = linkedMapOf("forge.json" to "{}".toByteArray(), "neo.json" to "{}".toByteArray())
            if (kind != "manifest") entries["META-INF/neoforge.mods.toml"] = "[[mixins]]\nconfig=\"neo.json\"\nenvironment=\"client\"\n".toByteArray()
            jar(source, manifest, entries)
            val before = Files.readAllBytes(source)
            val expected = when (kind) {
                "manifest" -> listOf("forge.json")
                "toml" -> listOf("neo.json")
                else -> listOf("forge.json", "neo.json")
            }
            open(source).use { fs ->
                val handlers = java.util.ServiceLoader.load(MixinListingRule::class.java).mapNotNull { it.load(fs.getPath("/")) }
                assertEquals(expected, handlers.flatMap { it.list(fs.getPath("/")) })
            }
            val environments = linkedMapOf<String, MutableSet<String>>()
            val found = discover.invoke(null, source.toString(), emptyList<String>(), environments)
            assertEquals(expected, found)
            assertEquals(expected.associateWith { setOf("*") }, environments)
            assertArrayEquals(before, Files.readAllBytes(source))
            Files.move(source, temp.resolve("host-$kind-closed.jar"))
        }
    }

    @Test
    fun actualReadWriteAndCloseFailuresEscapeRemove() {
        val path = Files.createDirectories(temp.resolve("META-INF")).resolve("neoforge.mods.toml")
        val original = "[[mixins]]\nconfig=\"a.json\"\n[[mixins]]\nconfig=\"b.json\"\n[vendor]\nkeep=true\n"
        Files.writeString(path, original)
        val handler = NeoForgeMixinListingRule().load(temp)!!
        for (mode in listOf("read", "read-close", "write", "write-close")) {
            Files.writeString(path, original)
            val failure = java.io.IOException("NeoForge TOML $mode")
            var hit = false
            var closed = false
            val provider = object : java.nio.file.spi.FileSystemProvider() {
                override fun getScheme() = "neoforge-test"
                override fun newByteChannel(p: Path, options: Set<java.nio.file.OpenOption>, vararg attrs: java.nio.file.attribute.FileAttribute<*>): java.nio.channels.SeekableByteChannel {
                    val channel = Files.newByteChannel(temp.fileSystem.getPath(p.toString()), options, *attrs)
                    return object : java.nio.channels.SeekableByteChannel by channel {
                        override fun read(dst: java.nio.ByteBuffer): Int {
                            val count = channel.read(dst)
                            if (mode == "read") { hit = true; throw failure }
                            return count
                        }
                        override fun close() {
                            channel.close()
                            closed = true
                            if (mode == "read-close" && !hit) { hit = true; throw failure }
                        }
                    }
                }
                override fun newOutputStream(p: Path, vararg options: java.nio.file.OpenOption): java.io.OutputStream {
                    val stream = Files.newOutputStream(temp.fileSystem.getPath(p.toString()), *options)
                    return object : java.io.FilterOutputStream(stream) {
                        override fun write(bytes: ByteArray, offset: Int, length: Int) {
                            if (mode == "write") {
                                out.write(bytes, offset, 1)
                                hit = true
                                throw failure
                            }
                            out.write(bytes, offset, length)
                        }
                        override fun close() {
                            out.close()
                            closed = true
                            if (mode == "write-close" && !hit) { hit = true; throw failure }
                        }
                    }
                }
                override fun checkAccess(p: Path, vararg modes: java.nio.file.AccessMode) = temp.fileSystem.provider().checkAccess(temp.fileSystem.getPath(p.toString()), *modes)
                override fun newFileSystem(uri: URI, env: Map<String, *>) = throw UnsupportedOperationException()
                override fun getFileSystem(uri: URI) = throw UnsupportedOperationException()
                override fun getPath(uri: URI) = throw UnsupportedOperationException()
                override fun newDirectoryStream(p: Path, filter: java.nio.file.DirectoryStream.Filter<in Path>) = throw UnsupportedOperationException()
                override fun createDirectory(p: Path, vararg attrs: java.nio.file.attribute.FileAttribute<*>) = throw UnsupportedOperationException()
                override fun delete(p: Path) = throw UnsupportedOperationException()
                override fun copy(a: Path, b: Path, vararg options: java.nio.file.CopyOption) = throw UnsupportedOperationException()
                override fun move(a: Path, b: Path, vararg options: java.nio.file.CopyOption) = throw UnsupportedOperationException()
                override fun isSameFile(a: Path, b: Path) = throw UnsupportedOperationException()
                override fun isHidden(p: Path) = throw UnsupportedOperationException()
                override fun getFileStore(p: Path) = throw UnsupportedOperationException()
                override fun <V : java.nio.file.attribute.FileAttributeView> getFileAttributeView(p: Path, type: Class<V>, vararg options: java.nio.file.LinkOption): V? = throw UnsupportedOperationException()
                override fun <A : java.nio.file.attribute.BasicFileAttributes> readAttributes(p: Path, type: Class<A>, vararg options: java.nio.file.LinkOption): A = throw UnsupportedOperationException()
                override fun readAttributes(p: Path, attributes: String, vararg options: java.nio.file.LinkOption): MutableMap<String, Any> = throw UnsupportedOperationException()
                override fun setAttribute(p: Path, attribute: String, value: Any, vararg options: java.nio.file.LinkOption) = throw UnsupportedOperationException()
            }
            val fs = object : java.nio.file.FileSystem() {
                override fun provider() = provider
                override fun close() = throw UnsupportedOperationException()
                override fun isOpen() = true
                override fun isReadOnly() = false
                override fun getSeparator() = temp.fileSystem.separator
                override fun getRootDirectories() = throw UnsupportedOperationException()
                override fun getFileStores() = throw UnsupportedOperationException()
                override fun supportedFileAttributeViews() = throw UnsupportedOperationException()
                override fun getPath(first: String, vararg more: String) = throw UnsupportedOperationException()
                override fun getPathMatcher(pattern: String) = throw UnsupportedOperationException()
                override fun getUserPrincipalLookupService() = throw UnsupportedOperationException()
                override fun newWatchService() = throw UnsupportedOperationException()
            }
            // Wrap only Path dispatch; every read/write/close above reaches a real file first.
            fun wrapped(real: Path): Path = java.lang.reflect.Proxy.newProxyInstance(
                Path::class.java.classLoader, arrayOf(Path::class.java),
            ) { _, method, args ->
                if (method.name == "getFileSystem") fs else {
                    val result = try { method.invoke(real, *(args ?: emptyArray())) }
                    catch (exception: java.lang.reflect.InvocationTargetException) { throw exception.cause!! }
                    if (result is Path) wrapped(result) else result
                }
            } as Path
            val root = wrapped(temp)
            val thrown = assertThrows(Exception::class.java) {
                handler.remove(root)
            }
            assertTrue(hit, "$mode must reach actual I/O")
            assertTrue(closed, "$mode must close its real handle")
            assertTrue(generateSequence(thrown as Throwable?) { it.cause }.any { it === failure }, "original I/O cause must propagate")
            when (mode) {
                "read", "read-close" -> assertEquals(original, Files.readString(path))
                "write" -> assertTrue(Files.size(path) > 0, "must fail after writing real bytes")
                "write-close" -> {
                    val expected = TomlParser().parse(original)
                    expected.remove<Any>("mixins")
                    assertEquals(expected, TomlParser().parse(Files.readString(path)))
                }
            }
            if (mode.startsWith("read")) {
                hit = false
                closed = false
                val loadFailure = assertThrows(Exception::class.java) { NeoForgeMixinListingRule().load(root) }
                assertTrue(generateSequence(loadFailure as Throwable?) { it.cause }.any { it === failure })
                assertTrue(hit && closed, "load must reach $mode and close the real file")
            }
            Files.writeString(path, original)
            handler.remove(temp)
            assertNull(NeoForgeMixinListingRule().load(temp))
            assertEquals(true, TomlParser().parse(Files.readString(path)).get<Boolean>("vendor.keep"))
        }
    }

    @Test
    fun manifestActualReadWriteAndCloseFailuresEscapeBothEditEntrypoints() {
        val path = Files.createDirectories(temp.resolve("META-INF")).resolve("MANIFEST.MF")
        val original = "Manifest-Version: 1.0\r\nMixinConfigs: a.json, b.json\r\nVendor-Keep: true\r\n\r\n"
        Files.writeString(path, original)
        val handler = ForgeMixinListingRule().load(temp)!!
        for (mode in listOf("read", "read-close", "write", "write-close")) {
            Files.writeString(path, original)
            val failure = java.io.IOException("Forge Manifest $mode")
            var hit = false
            var closed = false
            val provider = object : java.nio.file.spi.FileSystemProvider() {
                override fun getScheme() = "forge-test"
                override fun newByteChannel(p: Path, options: Set<java.nio.file.OpenOption>, vararg attrs: java.nio.file.attribute.FileAttribute<*>): java.nio.channels.SeekableByteChannel {
                    val channel = Files.newByteChannel(temp.fileSystem.getPath(p.toString()), options, *attrs)
                    return object : java.nio.channels.SeekableByteChannel by channel {
                        override fun read(dst: java.nio.ByteBuffer): Int {
                            val count = channel.read(dst)
                            if (mode == "read") { hit = true; throw failure }
                            return count
                        }
                        override fun close() {
                            channel.close()
                            closed = true
                            if (mode == "read-close" && !hit) { hit = true; throw failure }
                        }
                    }
                }
                override fun newOutputStream(p: Path, vararg options: java.nio.file.OpenOption): java.io.OutputStream {
                    val stream = Files.newOutputStream(temp.fileSystem.getPath(p.toString()), *options)
                    return object : java.io.FilterOutputStream(stream) {
                        override fun write(bytes: ByteArray, offset: Int, length: Int) {
                            if (mode == "write") {
                                out.write(bytes, offset, 1)
                                hit = true
                                throw failure
                            }
                            out.write(bytes, offset, length)
                        }
                        override fun close() {
                            out.close()
                            closed = true
                            if (mode == "write-close" && !hit) { hit = true; throw failure }
                        }
                    }
                }
                override fun checkAccess(p: Path, vararg modes: java.nio.file.AccessMode) = temp.fileSystem.provider().checkAccess(temp.fileSystem.getPath(p.toString()), *modes)
                override fun newFileSystem(uri: URI, env: Map<String, *>) = throw UnsupportedOperationException()
                override fun getFileSystem(uri: URI) = throw UnsupportedOperationException()
                override fun getPath(uri: URI) = throw UnsupportedOperationException()
                override fun newDirectoryStream(p: Path, filter: java.nio.file.DirectoryStream.Filter<in Path>) = throw UnsupportedOperationException()
                override fun createDirectory(p: Path, vararg attrs: java.nio.file.attribute.FileAttribute<*>) = throw UnsupportedOperationException()
                override fun delete(p: Path) = throw UnsupportedOperationException()
                override fun copy(a: Path, b: Path, vararg options: java.nio.file.CopyOption) = throw UnsupportedOperationException()
                override fun move(a: Path, b: Path, vararg options: java.nio.file.CopyOption) = throw UnsupportedOperationException()
                override fun isSameFile(a: Path, b: Path) = throw UnsupportedOperationException()
                override fun isHidden(p: Path) = throw UnsupportedOperationException()
                override fun getFileStore(p: Path) = throw UnsupportedOperationException()
                override fun <V : java.nio.file.attribute.FileAttributeView> getFileAttributeView(p: Path, type: Class<V>, vararg options: java.nio.file.LinkOption): V? = throw UnsupportedOperationException()
                override fun <A : java.nio.file.attribute.BasicFileAttributes> readAttributes(p: Path, type: Class<A>, vararg options: java.nio.file.LinkOption): A = throw UnsupportedOperationException()
                override fun readAttributes(p: Path, attributes: String, vararg options: java.nio.file.LinkOption): MutableMap<String, Any> = throw UnsupportedOperationException()
                override fun setAttribute(p: Path, attribute: String, value: Any, vararg options: java.nio.file.LinkOption) = throw UnsupportedOperationException()
            }
            val fs = object : java.nio.file.FileSystem() {
                override fun provider() = provider
                override fun close() = throw UnsupportedOperationException()
                override fun isOpen() = true
                override fun isReadOnly() = false
                override fun getSeparator() = temp.fileSystem.separator
                override fun getRootDirectories() = throw UnsupportedOperationException()
                override fun getFileStores() = throw UnsupportedOperationException()
                override fun supportedFileAttributeViews() = throw UnsupportedOperationException()
                override fun getPath(first: String, vararg more: String) = throw UnsupportedOperationException()
                override fun getPathMatcher(pattern: String) = throw UnsupportedOperationException()
                override fun getUserPrincipalLookupService() = throw UnsupportedOperationException()
                override fun newWatchService() = throw UnsupportedOperationException()
            }
            // Wrap only Path dispatch; every read/write/close above reaches a real file first.
            fun wrapped(real: Path): Path = java.lang.reflect.Proxy.newProxyInstance(
                Path::class.java.classLoader, arrayOf(Path::class.java),
            ) { _, method, args ->
                if (method.name == "getFileSystem") fs else {
                    val result = try { method.invoke(real, *(args ?: emptyArray())) }
                    catch (exception: java.lang.reflect.InvocationTargetException) { throw exception.cause!! }
                    if (result is Path) wrapped(result) else result
                }
            } as Path
            val root = wrapped(temp)
            val thrown = assertThrows(Exception::class.java) {
                handler.remove(root)
            }
            assertTrue(hit, "$mode must reach actual I/O")
            assertTrue(closed, "$mode must close its real handle")
            assertTrue(generateSequence(thrown as Throwable?) { it.cause }.any { it === failure }, "original I/O cause must propagate")
            when (mode) {
                "read", "read-close" -> assertEquals(original, Files.readString(path))
                "write" -> assertTrue(Files.size(path) > 0, "must fail after writing real bytes")
                "write-close" -> {
                    val expected = Manifest(original.byteInputStream())
                    expected.mainAttributes.remove(Attributes.Name(MANIFEST_MIXINS_CONFIG))
                    assertEquals(expected, Files.newInputStream(path).use(::Manifest))
                }
            }
            if (mode.startsWith("read")) {
                hit = false
                closed = false
                val loadFailure = assertThrows(Exception::class.java) { ForgeMixinListingRule().load(root) }
                assertTrue(generateSequence(loadFailure as Throwable?) { it.cause }.any { it === failure })
                assertTrue(hit && closed, "load must reach $mode and close the real file")
            }
            Files.writeString(path, original)
            handler.remove(temp)
            assertNull(ForgeMixinListingRule().load(temp))
            assertEquals("true", Files.newInputStream(path).use(::Manifest).mainAttributes.getValue("Vendor-Keep"))
        }
    }

    private fun open(jar: Path) =
        FileSystems.newFileSystem(URI.create("jar:${jar.toUri()}"), mapOf<String, Any>("create" to false))

    private fun jar(path: Path, manifest: Manifest?, entries: Map<String, ByteArray>) {
        JarOutputStream(path.toFile().outputStream(), manifest ?: Manifest()).use { output ->
            entries.forEach { (name, bytes) ->
                output.putNextEntry(JarEntry(name))
                output.write(bytes)
                output.closeEntry()
            }
        }
    }
}
