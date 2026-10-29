package net.msrandom.minecraftcodev.remapper

import net.msrandom.minecraftcodev.core.ListedFileHandler
import net.msrandom.minecraftcodev.core.utils.cacheExpensiveOperation
import net.msrandom.minecraftcodev.includes.IncludedJarListingRule
import net.msrandom.minecraftcodev.remapper.task.RemapTask
import org.gradle.api.Project
import org.gradle.api.artifacts.transform.TransformOutputs
import org.gradle.api.file.FileCollection
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode
import java.io.ByteArrayInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarEntry
import java.util.jar.JarInputStream
import java.util.jar.JarOutputStream

class RemapCacheTests {
    @TempDir
    lateinit var root: Path

    private val project: Project by lazy {
        ProjectBuilder.builder().withProjectDir(Files.createDirectories(root.resolve("project")).toFile()).build()
    }
    private var invocation = 0

    @Test
    fun transformClasspathContentReachesOuterAndNestedCaches() {
        val fixture = fixture()
        val cache = root.resolve("shared")
        val first = transform(fixture, cache)
        assertInvocation(first, "left")
        assertInvocation(nested(first), "left")
        assertEquals(2, operationCount(cache))
        assertEquals(
            setOf("remap-4"),
            Files.list(cache.resolve("cached-operations")).use { paths -> paths.map { it.fileName.toString() }.iterator().asSequence().toSet() },
        )

        classpath(fixture.classpath, "Right")
        val hot = transform(fixture, cache)
        val cold = transform(fixture, root.resolve("cold"))
        assertInvocation(hot, "right")
        assertInvocation(nested(hot), "right")
        assertEquals(contents(cold), contents(hot))
        assertEquals(contents(nested(cold)), contents(nested(hot)))
        assertEquals(4, operationCount(cache), "both outer and nested must miss for the new classpath")
        assertEquals(contents(hot), contents(transform(fixture, cache)))
        assertEquals(4, operationCount(cache))
    }

    @Test
    fun transformSourceAndTargetChangesReachOuterAndNestedCaches() {
        val fixture = fixture()
        val cache = root.resolve("shared")
        val baseline = transform(fixture, cache)
        for ((source, target) in listOf("named" to "named", "obf" to "alt")) {
            val hot = transform(fixture, cache, source, target)
            val cold = transform(fixture, root.resolve("cold-$source-$target"), source, target)
            assertNotEquals(contents(baseline), contents(hot))
            assertNotEquals(contents(nested(baseline)), contents(nested(hot)))
            assertEquals(contents(cold), contents(hot))
            assertEquals(contents(nested(cold)), contents(nested(hot)))
            assertEquals(contents(hot), contents(transform(fixture, cache, source, target)))
        }
        assertEquals(6, operationCount(cache))
    }

    @Test
    fun taskClasspathDirectionsAndMappingsMatchColdOutputs() {
        val fixture = fixture()
        val cache = root.resolve("shared")
        val baseline = task(fixture, cache)
        assertInvocation(baseline, "left")
        classpath(fixture.classpath, "Right")
        val changedClasspath = task(fixture, cache)
        assertInvocation(changedClasspath, "right")
        assertEquals(contents(task(fixture, root.resolve("cold-classpath"))), contents(changedClasspath))

        for ((source, target) in listOf("named" to "named", "obf" to "alt")) {
            val hot = task(fixture, cache, source, target)
            assertNotEquals(contents(changedClasspath), contents(hot))
            assertEquals(contents(task(fixture, root.resolve("cold-$source-$target"), source, target)), contents(hot))
            assertEquals(contents(hot), contents(task(fixture, cache, source, target)))
        }
        Files.writeString(fixture.mappings, Files.readString(fixture.mappings).replace("\tright\t", "\trenamed\t"))
        val changedMappings = task(fixture, cache)
        assertInvocation(changedMappings, "renamed")
        assertEquals(contents(task(fixture, root.resolve("cold-mappings"))), contents(changedMappings))
        assertEquals(5, operationCount(cache))
    }

    @Test
    fun taskNamespaceStringDistinguishesPathOnlyKeys() {
        val fixture = fixture()
        val cache = root.resolve("shared")
        val legacyOutput = output()
        cacheExpensiveOperation(cache, "remap-$REMAP_OPERATION_VERSION", listOf(fixture.classpath, fixture.mappings, fixture.input), legacyOutput) { (temporary) ->
            Files.writeString(temporary, "path-only result must never be reused")
        }
        val first = task(fixture, cache)
        assertInvocation(first, "left")
        assertEquals(contents(task(fixture, root.resolve("cold"))), contents(first))
        assertEquals(contents(first), contents(task(fixture, cache)))
        assertEquals(2, operationCount(cache), "namespace and path-only keys share the restored operation but remain distinct")
    }

    private data class Fixture(val input: Path, val mappings: Path, val classpath: Path)

    private fun fixture(): Fixture {
        val mappings = Files.writeString(root.resolve("mappings.tiny"), """
            tiny\t2\t0\tobf\tnamed\talt
            c\tsample/Child\tnamed/Child\talt/Child
            c\tsample/Parent\tsample/Parent\tsample/Parent
            c\tsample/Left\tsample/Left\tsample/Left
            \tm\t()I\tm\tleft\talternateLeft
            c\tsample/Right\tsample/Right\tsample/Right
            \tm\t()I\tm\tright\talternateRight
        """.trimIndent().replace("\\t", "\t") + "\n")
        val child = type("Child", "sample/Parent", invoke = true)
        val nested = jar(root.resolve("nested.jar"), mapOf("sample/Child.class" to child))
        val input = jar(root.resolve("input.jar"), mapOf("sample/Child.class" to child, "nested.jar" to Files.readAllBytes(nested)))
        val classpath = root.resolve("parent.jar")
        classpath(classpath, "Left")
        return Fixture(input, mappings, classpath)
    }

    private fun classpath(path: Path, parent: String) {
        val entries = mapOf(
            "sample/Parent.class" to type("Parent", "sample/$parent"),
            "sample/Left.class" to type("Left", "java/lang/Object", method = true),
            "sample/Right.class" to type("Right", "java/lang/Object", method = true),
        )
        jar(path, entries)
    }

    private fun type(name: String, parent: String, method: Boolean = false, invoke: Boolean = false): ByteArray {
        val writer = ClassWriter(0)
        writer.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "sample/$name", null, parent, null)
        if (method || invoke) {
            val visitor = writer.visitMethod(Opcodes.ACC_PUBLIC, if (invoke) "call" else "m", "()I", null, null)
            visitor.visitCode()
            if (invoke) {
                visitor.visitVarInsn(Opcodes.ALOAD, 0)
                visitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "sample/$name", "m", "()I", false)
            } else {
                visitor.visitInsn(Opcodes.ICONST_1)
            }
            visitor.visitInsn(Opcodes.IRETURN)
            visitor.visitMaxs(1, 1)
            visitor.visitEnd()
        }
        writer.visitEnd()
        return writer.toByteArray()
    }

    private fun jar(path: Path, entries: Map<String, ByteArray>): Path {
        Files.createDirectories(path.parent)
        JarOutputStream(Files.newOutputStream(path)).use { output ->
            for ((name, bytes) in entries) {
                output.putNextEntry(JarEntry(name).also { it.time = 0 })
                output.write(bytes)
                output.closeEntry()
            }
        }
        return path
    }

    private fun task(fixture: Fixture, cache: Path, source: String = "obf", target: String = "named"): Path {
        val output = output()
        project.tasks.register("remap${invocation}", RemapTask::class.java).get().apply {
            inputFile.set(fixture.input.toFile())
            mappings.set(fixture.mappings.toFile())
            sourceNamespace.set(source)
            targetNamespace.set(target)
            classpath.from(fixture.classpath.toFile())
            cacheDirectory.set(cache.toFile())
            outputFile.set(output.toFile())
            remap()
        }
        return output
    }

    private fun transform(fixture: Fixture, cache: Path, source: String = "obf", target: String = "named"): Path {
        val output = output()
        val parameters = project.objects.newInstance(RemapAction.Parameters::class.java).apply {
            mappings.set(fixture.mappings.toFile())
            sourceNamespace.set(source)
            targetNamespace.set(target)
            filterMods.set(false)
            cacheDirectory.set(cache.toFile())
        }
        val action = object : RemapAction() {
            override fun getParameters(): Parameters = parameters
            override val inputFile: Provider<FileSystemLocation> = project.layout.file(project.provider { fixture.input.toFile() }).map { it }
            override val classpath: FileCollection = project.files(fixture.classpath.toFile())
        }
        action.transform(object : TransformOutputs {
            override fun file(path: Any): java.io.File = output.toFile()
            override fun dir(path: Any): java.io.File = error("unexpected directory output")
        })
        return output
    }

    private fun output(): Path = Files.createDirectories(root.resolve("output-${++invocation}")).resolve("result.jar")

    private fun nested(path: Path): Path = Files.write(output(), entries(Files.readAllBytes(path)).getValue("nested.jar"))

    private fun contents(path: Path): Map<String, List<Byte>> = buildMap {
        for ((name, bytes) in entries(Files.readAllBytes(path))) {
            if (name.endsWith(".jar")) {
                put(name, emptyList())
                for ((nestedName, nestedBytes) in entries(bytes)) put("$name!$nestedName", nestedBytes.toList())
            } else {
                put(name, bytes.toList())
            }
        }
    }

    private fun entries(bytes: ByteArray): Map<String, ByteArray> = buildMap {
        JarInputStream(ByteArrayInputStream(bytes)).use { jar ->
            while (true) {
                val entry = jar.nextJarEntry ?: break
                if (!entry.isDirectory) put(entry.name, jar.readBytes())
            }
        }
    }

    private fun assertInvocation(path: Path, expected: String) {
        val bytes = entries(Files.readAllBytes(path)).filterKeys { it.endsWith("/Child.class") }.values.single()
        val node = ClassNode()
        ClassReader(bytes).accept(node, 0)
        val call = node.methods.single { it.name == "call" }.instructions.toArray().filterIsInstance<MethodInsnNode>().single()
        assertEquals(expected, call.name, "the actual remapper must resolve the inherited method using this classpath")
    }

    private fun operationCount(cache: Path): Int = Files.list(cache.resolve("cached-operations")).use { operations ->
        operations.mapToLong { operation ->
            Files.list(operation).use { entries -> entries.filter { Files.isDirectory(it) }.count() }
        }.sum().toInt()
    }
}

class TestNestedJarListingRule : IncludedJarListingRule {
    override fun load(directory: Path): ListedFileHandler? {
        if (!Files.exists(directory.resolve("nested.jar"))) return null
        return object : ListedFileHandler {
            override fun list(root: Path): List<String> = listOf("nested.jar")
            override fun remove(root: Path) = error("not used by remapping")
        }
    }
}
