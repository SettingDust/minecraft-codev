package net.msrandom.minecraftcodev.mixins

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.IntInsnNode
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.Collections
import java.util.zip.ZipException

class MixinResourceTests {
    @TempDir lateinit var root: Path

    companion object {
        fun resolutionWinner(loader: IsolatingMixinClassLoader, origin: Path, expected: Int) {
            val type = loader.loadClass("resolution.Dependency")
            assertEquals(expected, type.getMethod("value").invoke(null))
            assertEquals(origin.toRealPath(), Paths.get(type.protectionDomain.codeSource.location.toURI()).toRealPath())
            val bytes = loader.getResource("resolution/Dependency.class")
            assertNotNull(bytes)
            val node = ClassNode()
            bytes!!.openStream().use { ClassReader(it).accept(node, 0) }
            val method = node.methods.first { it.name == "value" }
            assertTrue(method.instructions.toArray().any { it is IntInsnNode && it.operand == expected })
            loader.getResourceAsStream("encoded space#问/value.txt").use { input ->
                assertNotNull(input)
                assertEquals(expected.toString(), String(input!!.readAllBytes()).trim())
            }
            assertEquals(1, Collections.list(loader.getResources("resolution/Dependency.class")).size)
            println("RESOLUTION_WINNER value=$expected source=$origin bytes=$bytes")
        }
    }

    @Test fun orderedDirectoryAndJarResourcesCloseWithLoader() {
        val directory = Files.createDirectories(root.resolve("directory space#"))
        OrdinaryInputs.copyClasses("resolution11", directory)
        OrdinaryInputs.copyResources("resolution11", directory)
        val jar = OrdinaryInputs.copyJar("resolution-22", root.resolve("archive space#.jar"))
        IsolatingMixinClassLoader(emptyArray(), arrayOf(directory.toUri().toURL(), jar.toUri().toURL())).use { loader ->
            resolutionWinner(loader, directory, 11)
        }
        val retained: InputStream
        IsolatingMixinClassLoader(emptyArray(), arrayOf(jar.toUri().toURL())).use { loader ->
            val input = loader.getResourceAsStream("encoded space#问/value.txt")
            assertNotNull(input)
            retained = input!!
            assertEquals("22", String(retained.readAllBytes()).trim())
        }
        Files.delete(jar)
        retained.close()
    }

    @Test fun explicitLookupSkipsOnlyMissingAndPropagatesDirectJarFailures() {
        assertThrows(IllegalArgumentException::class.java) { MixinConfigReference("../bad.json", ConfigSide.COMMON) }
        val jar = OrdinaryInputs.copyJar("resolution-22", root.resolve("B.jar"))
        val absent = root.resolve("missing.jar")
        IsolatingMixinClassLoader(emptyArray(), arrayOf(absent.toUri().toURL(), jar.toUri().toURL())).use { loader ->
            assertNull(loader.getResourceAsStream("missing.json"))
            for (unsafe in listOf("../escape", "a\\bad")) {
                assertThrows(IllegalArgumentException::class.java) { loader.getResourceAsStream(unsafe) }
            }
            resolutionWinner(loader, jar, 22)
        }
        Files.writeString(absent, "not a jar")
        IsolatingMixinClassLoader(emptyArray(), arrayOf(absent.toUri().toURL(), jar.toUri().toURL())).use { loader ->
            assertThrows(ZipException::class.java) { loader.getResource("resolution/Dependency.class") }
            assertThrows(ZipException::class.java) { loader.loadClass("resolution.Dependency") }
            println("RESOLUTION_IO missing-skipped=true corrupt-first=ZipException resource-and-class=true")
        }
    }
}
