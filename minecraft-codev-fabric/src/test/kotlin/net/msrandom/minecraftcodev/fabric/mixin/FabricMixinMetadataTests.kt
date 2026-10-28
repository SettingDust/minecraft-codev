package net.msrandom.minecraftcodev.fabric.mixin

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import net.msrandom.minecraftcodev.core.FileListingRules
import net.msrandom.minecraftcodev.core.ListedFileHandler
import net.msrandom.minecraftcodev.mixins.ConfigSide
import net.msrandom.minecraftcodev.mixins.MixinConfigHandler
import net.msrandom.minecraftcodev.mixins.MixinConfigReference
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.io.TempDir
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.jar.JarFile

class FabricMixinMetadataTests {
    @TempDir lateinit var temp: Path

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

    private fun copy(name: String): Path = FabricInputs.copyJar(name, temp.resolve("$name.jar"))

    @Test
    fun discoveryPreservesObjectsUnknownFieldsAndReferences() {
        val jar = copy("metadata-discovery")
        Files.copy(jar, temp.resolve("fabric-before.jar"))
        open(jar).use { fs ->
            val io = MetadataIO(fs.getPath("/"))
            val handler = FabricMixinListingRule().load(io.root)!!
            assertEquals(listOf("a.json", "b.json", "c.json"), handler.list(io.root))
            assertEquals(listOf(MixinConfigReference("a.json", ConfigSide.COMMON), MixinConfigReference("b.json", ConfigSide.CLIENT), MixinConfigReference("c.json", ConfigSide.COMMON)), handler.references)
            assertEquals(1, io.reads)
            assertEquals(1, io.closes)
            assertEquals(0, io.writes)
        }
        assertArrayEquals(Files.readAllBytes(temp.resolve("fabric-before.jar")), Files.readAllBytes(jar))
        JarFile(jar.toFile()).use { archive ->
            val json = archive.getInputStream(archive.getJarEntry("fabric.mod.json")).reader().readText()
            assertTrue(json.contains("a.json") && json.contains("b.json") && json.contains("c.json"))
            assertTrue(json.contains("environment") && json.contains("custom"))
            assertTrue(json.contains("元数据"))
            assertNotNull(archive.getJarEntry("keep.txt"))
        }
    }

    @Test
    fun nullableOriginalContractAndApplicableEmptyHandler() {
        val rule: MixinListingRule = FabricMixinListingRule()
        assertNull(rule.load(temp))
        Files.writeString(temp.resolve("fabric.mod.json"), "{\"id\":\"demo\"}")
        assertNull(rule.load(temp))
        Files.writeString(temp.resolve("fabric.mod.json"), "{\"id\":\"demo\",\"mixins\":[]}")
        assertNotNull(rule.load(temp))
        assertEquals(emptyList<String>(), rule.load(temp)!!.references.map { it.resource })
        for (bad in listOf("[1]", "[\"../bad.json\"]", "[{\"config\":\"a.json\",\"environment\":\"invalid\"}]")) {
            Files.writeString(temp.resolve("fabric.mod.json"), "{\"mixins\":$bad}")
            assertThrows(Exception::class.java) { rule.load(temp) }
        }
    }

    @Test
    fun closedZipHandlerRetainsDuplicatesEnvironmentsAndRealWriters() {
        val source = copy("metadata-duplicates")
        val before = Files.readAllBytes(source)
        val rule: FileListingRules = java.util.ServiceLoader.load(MixinListingRule::class.java).single { it is FabricMixinListingRule }
        val handler = open(source).use { rule.load(it.getPath("/")) as MixinConfigHandler }
        val coreHandler: ListedFileHandler = handler
        assertEquals(listOf("a.json", "b.json", "a.json"), coreHandler.list(temp.resolve("closed-zip")))
        assertArrayEquals(before, Files.readAllBytes(source))
        assertEquals(listOf(MixinConfigReference("a.json", ConfigSide.CLIENT), MixinConfigReference("b.json", ConfigSide.SERVER), MixinConfigReference("a.json", ConfigSide.SERVER)), handler.references)
        val copy = Files.copy(source, temp.resolve("remove.jar"))
        open(copy).use { fs -> coreHandler.remove(fs.getPath("/")) }
        open(copy).use { fs ->
            val actual = Json.parseToJsonElement(Files.readString(fs.getPath("/".plus("fabric.mod.json")))).jsonObject
            assertEquals("demo", actual["id"]!!.jsonPrimitive.content)
            assertEquals("true", actual["custom"]!!.jsonObject["keep"]!!.jsonPrimitive.content)
            assertArrayEquals(byteArrayOf(9), Files.readAllBytes(fs.getPath("keep.txt")))
        }
        assertEquals(listOf("a.json", "b.json", "a.json"), coreHandler.list(temp))
        Files.move(copy, temp.resolve("remove-closed.jar"))
        assertArrayEquals(before, Files.readAllBytes(source))
        assertThrows(Exception::class.java) { handler.remove(temp.resolve("missing")) }
    }

    @Test
    fun scalarAndObjectReferencesSupportExplicitRemoval() {
        for (name in listOf("metadata-scalar", "metadata-object")) {
            val source = copy(name)
            val before = Files.readAllBytes(source)
            val handler = open(source).use { FabricMixinListingRule().load(it.getPath("/")) as FabricMixinConfigHandler }
            assertEquals(listOf(MixinConfigReference("a.json", ConfigSide.COMMON)), handler.references)
            assertArrayEquals(before, Files.readAllBytes(source))
            val copy = Files.copy(source, temp.resolve("$name-remove.jar"))
            open(copy).use { handler.remove(it.getPath("/")) }
            open(copy).use { assertEquals(Json.parseToJsonElement("{\"id\":\"demo\",\"custom\":${if (name == "metadata-scalar") "1" else "7"}}"), Json.parseToJsonElement(Files.readString(it.getPath("/".plus("fabric.mod.json"))))) }
            assertArrayEquals(before, Files.readAllBytes(source))
        }
    }

    @Test
    fun currentMetadataUsesCurrentZipValuesAndKeepsDiscoverySnapshot() {
        val source = copy("metadata-discovery")
        val sourceBefore = Files.readAllBytes(source)
        val handler = open(source).use { FabricMixinListingRule().load(it.getPath("/"))!! }
        val snapshot = handler.references
        val current = "{\"mixins\":[{\"config\":\"d.json\",\"environment\":\"server\"},\"c.json\"],\"custom\":{\"now\":\"当前\"},\"newField\":42}"
        val copy = Files.copy(source, temp.resolve("current-remove.jar"))
        open(copy).use { fs ->
            Files.writeString(fs.getPath("/fabric.mod.json"), current)
            val io = MetadataIO(fs.getPath("/"))
            handler.remove(io.root)
            assertEquals(Json.parseToJsonElement("{\"mixins\":[{\"config\":\"d.json\",\"environment\":\"server\"}],\"custom\":{\"now\":\"当前\"},\"newField\":42}"), Json.parseToJsonElement(Files.readString(fs.getPath("/fabric.mod.json"))))
            assertEquals(1, io.reads)
            assertEquals(1, io.closes)
            assertEquals(1, io.writes)
        }
        JarFile(source.toFile()).use { original -> JarFile(copy.toFile()).use { edited ->
            assertEquals(original.entries().asSequence().map { it.name }.toSet(), edited.entries().asSequence().map { it.name }.toSet())
            original.entries().asSequence().filter { !it.isDirectory && it.name != "fabric.mod.json" }.forEach { entry ->
                assertArrayEquals(original.getInputStream(entry).use { it.readBytes() }, edited.getInputStream(edited.getJarEntry(entry.name)).use { it.readBytes() }, entry.name)
            }
        } }
        org.junit.jupiter.api.Assertions.assertSame(snapshot, handler.references)
        assertEquals(listOf("a.json", "b.json", "c.json"), handler.list(temp))
        assertArrayEquals(sourceBefore, Files.readAllBytes(source))
    }

    @Test
    fun actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits() {
        val source = copy("metadata-baseline")
        val before = Files.readAllBytes(source)
        val copy = Files.copy(source, temp.resolve("baseline-remove.jar"))
        open(copy).use { fs ->
            val root = fs.getPath("/")
            val handler = java.util.ServiceLoader.load(MixinListingRule::class.java).single { it is FabricMixinListingRule }.load(root)!!
            handler.remove(root)
            assertArrayEquals(before, Files.readAllBytes(source))
            assertEquals("accessWidener v2 named\ntransitive-accessible class demo/Hidden\n", Files.readString(root.resolve("keep.aw")))
            assertEquals("nested\n", Files.readString(root.resolve("nested.jar")))
        }
        assertArrayEquals(before, Files.readAllBytes(source))
    }

    @Test
    fun actualReadWriteAndCloseFailuresEscapeRemove() {
        val source = copy("metadata-duplicates")
        val sourceBefore = Files.readAllBytes(source)
        val path = temp.resolve("fabric.mod.json")
        val original = open(source).use { Files.readString(it.getPath("/fabric.mod.json")) }
        Files.writeString(path, original)
        val handler = FabricMixinListingRule().load(temp)!!
        val snapshot = handler.references.toList()
        for (mode in listOf("read", "read-close", "read-close-suppressed", "write", "write-close", "write-close-suppressed")) {
            Files.writeString(path, original)
            var failure = java.io.IOException("Fabric metadata $mode")
            val closeFailure = java.io.IOException("Fabric metadata close")
            var backingFileSystem = temp.fileSystem
            var hit = false
            var closed = false
            var inputClosed = false
            var outputOpened = false
            var outputClosed = false
            val provider = object : java.nio.file.spi.FileSystemProvider() {
                override fun getScheme() = "fabric-test"
                override fun newByteChannel(p: Path, options: Set<java.nio.file.OpenOption>, vararg attrs: java.nio.file.attribute.FileAttribute<*>): java.nio.channels.SeekableByteChannel {
                    val channel = Files.newByteChannel(backingFileSystem.getPath(p.toString()), options, *attrs)
                    return object : java.nio.channels.SeekableByteChannel by channel {
                        override fun read(dst: java.nio.ByteBuffer): Int { val count = channel.read(dst); if (mode == "read" || mode == "read-close-suppressed") { hit = true; throw failure }; return count }
                        override fun close() { channel.close(); inputClosed = true; closed = true; if (mode == "read-close" && !hit) { hit = true; throw failure }; if (mode == "read-close-suppressed" && hit) throw closeFailure }
                    }
                }
                override fun newOutputStream(p: Path, vararg options: java.nio.file.OpenOption): java.io.OutputStream { assertTrue(inputClosed); outputOpened = true; val stream = Files.newOutputStream(temp.fileSystem.getPath(p.toString()), *options); return object : java.io.FilterOutputStream(stream) { override fun write(bytes: ByteArray, offset: Int, length: Int) { if (mode == "write" || mode == "write-close-suppressed") { out.write(bytes, offset, 1); hit = true; throw failure }; out.write(bytes, offset, length) }; override fun close() { out.close(); outputClosed = true; closed = true; if (mode == "write-close" && !hit) { hit = true; throw failure }; if (mode == "write-close-suppressed" && hit) throw closeFailure } } }
                override fun checkAccess(p: Path, vararg modes: java.nio.file.AccessMode) = backingFileSystem.provider().checkAccess(backingFileSystem.getPath(p.toString()), *modes)
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
            val fs = object : java.nio.file.FileSystem() { override fun provider() = provider; override fun close() = throw UnsupportedOperationException(); override fun isOpen() = true; override fun isReadOnly() = false; override fun getSeparator() = temp.fileSystem.separator; override fun getRootDirectories() = throw UnsupportedOperationException(); override fun getFileStores() = throw UnsupportedOperationException(); override fun supportedFileAttributeViews() = throw UnsupportedOperationException(); override fun getPath(first: String, vararg more: String) = throw UnsupportedOperationException(); override fun getPathMatcher(pattern: String) = throw UnsupportedOperationException(); override fun getUserPrincipalLookupService() = throw UnsupportedOperationException(); override fun newWatchService() = throw UnsupportedOperationException() }
            fun wrapped(real: Path): Path = java.lang.reflect.Proxy.newProxyInstance(Path::class.java.classLoader, arrayOf(Path::class.java)) { _, method, args -> if (method.name == "getFileSystem") fs else { val result = try { method.invoke(real, *(args ?: emptyArray())) } catch (exception: java.lang.reflect.InvocationTargetException) { throw exception.cause!! }; if (result is Path) wrapped(result) else result } } as Path
            val thrown = assertThrows(java.io.IOException::class.java) { handler.remove(wrapped(temp)) }
            assertTrue(hit && closed, mode)
            assertTrue(inputClosed, mode)
            assertEquals(mode.startsWith("write"), outputOpened, mode)
            if (outputOpened) assertTrue(outputClosed, mode)
            org.junit.jupiter.api.Assertions.assertSame(failure, thrown)
            assertEquals(if (mode.endsWith("suppressed")) listOf(closeFailure) else emptyList<Throwable>(), thrown.suppressed.toList())
            val failedBytes = Files.readAllBytes(path)
            println("FABRIC_RETRY $mode failure hit=$hit inputClosed=$inputClosed outputOpened=$outputOpened outputClosed=$outputClosed bytes=${failedBytes.size}")
            if (mode.startsWith("read")) {
                assertArrayEquals(original.toByteArray(Charsets.UTF_8), failedBytes, mode)
            } else {
                Files.writeString(path, original)
            }
            println("FABRIC_RETRY $mode native retry reset=${mode.startsWith("write")}")
            handler.remove(temp)
            val actual = Json.parseToJsonElement(Files.readString(path))
            assertEquals(Json.parseToJsonElement("{\"id\":\"demo\",\"custom\":{\"keep\":true}}"), actual, mode)
            assertFalse("mixins" in actual.jsonObject, mode)
            assertEquals(snapshot, handler.references, mode)
            assertArrayEquals(sourceBefore, Files.readAllBytes(source), mode)
            println("FABRIC_RETRY $mode success metadata=$actual snapshot/source unchanged")
        }
    }

    @Test
    fun malformedMetadataClosesInputWithoutWritingOrChangingSnapshot() {
        val source = copy("metadata-discovery")
        val sourceBefore = Files.readAllBytes(source)
        val handler = open(source).use { FabricMixinListingRule().load(it.getPath("/"))!! }
        val snapshot = handler.references
        val current = Files.copy(source, temp.resolve("malformed.jar"))
        val malformed = "{\"mixins\":[".toByteArray(Charsets.UTF_8)
        open(current).use { Files.write(it.getPath("/fabric.mod.json"), malformed) }
        val currentBefore = Files.readAllBytes(current)
        open(current).use { fs ->
            val io = MetadataIO(fs.getPath("/"))
            assertThrows(kotlinx.serialization.SerializationException::class.java) { FabricMixinListingRule().load(io.root) }
            assertEquals(1, io.reads)
            assertEquals(1, io.closes)
            assertThrows(kotlinx.serialization.SerializationException::class.java) { handler.remove(io.root) }
            assertEquals(2, io.reads)
            assertEquals(2, io.closes)
            assertEquals(0, io.writes)
            assertArrayEquals(malformed, Files.readAllBytes(fs.getPath("/fabric.mod.json")))
        }
        org.junit.jupiter.api.Assertions.assertSame(snapshot, handler.references)
        assertEquals(listOf("a.json", "b.json", "c.json"), handler.list(temp))
        assertArrayEquals(currentBefore, Files.readAllBytes(current))
        assertArrayEquals(sourceBefore, Files.readAllBytes(source))
    }

    /** Observe the real ZIP provider without replacing its input stream or decoder. */
    private class MetadataIO(realRoot: Path) {
        var reads = 0
        var closes = 0
        var writes = 0
        private val backing = realRoot.fileSystem
        private fun real(path: Path) = backing.getPath(path.toString())
        private val provider = object : java.nio.file.spi.FileSystemProvider() {
            override fun getScheme() = "fabric-metadata-test"
            override fun newByteChannel(p: Path, options: Set<java.nio.file.OpenOption>, vararg attrs: java.nio.file.attribute.FileAttribute<*>): java.nio.channels.SeekableByteChannel {
                reads++
                val channel = backing.provider().newByteChannel(real(p), options, *attrs)
                return object : java.nio.channels.SeekableByteChannel by channel {
                    override fun close() { try { channel.close() } finally { closes++ } }
                }
            }
            override fun newOutputStream(p: Path, vararg options: java.nio.file.OpenOption): java.io.OutputStream {
                assertEquals(reads, closes, "Input must close before output opens")
                writes++
                return backing.provider().newOutputStream(real(p), *options)
            }
            override fun checkAccess(p: Path, vararg modes: java.nio.file.AccessMode) = backing.provider().checkAccess(real(p), *modes)
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
        private val fs = object : java.nio.file.FileSystem() {
            override fun provider() = provider
            override fun close() = throw UnsupportedOperationException()
            override fun isOpen() = backing.isOpen
            override fun isReadOnly() = backing.isReadOnly
            override fun getSeparator() = backing.separator
            override fun getRootDirectories() = throw UnsupportedOperationException()
            override fun getFileStores() = throw UnsupportedOperationException()
            override fun supportedFileAttributeViews() = throw UnsupportedOperationException()
            override fun getPath(first: String, vararg more: String) = throw UnsupportedOperationException()
            override fun getPathMatcher(pattern: String) = throw UnsupportedOperationException()
            override fun getUserPrincipalLookupService() = throw UnsupportedOperationException()
            override fun newWatchService() = throw UnsupportedOperationException()
        }
        private fun wrapped(real: Path): Path = java.lang.reflect.Proxy.newProxyInstance(Path::class.java.classLoader, arrayOf(Path::class.java)) { _, method, args ->
            if (method.name == "getFileSystem") fs else {
                val result = try { method.invoke(real, *(args ?: emptyArray())) }
                catch (exception: java.lang.reflect.InvocationTargetException) { throw exception.cause!! }
                if (result is Path) wrapped(result) else result
            }
        } as Path
        val root: Path = wrapped(realRoot)
    }

    private fun open(jar: Path) = FileSystems.newFileSystem(URI.create("jar:${jar.toUri()}"), mapOf<String, Any>("create" to false))
}
