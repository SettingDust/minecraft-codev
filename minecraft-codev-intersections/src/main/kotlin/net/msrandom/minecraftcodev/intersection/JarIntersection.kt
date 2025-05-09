package net.msrandom.minecraftcodev.intersection

import net.msrandom.minecraftcodev.core.utils.cacheExpensiveOperation
import net.msrandom.minecraftcodev.core.utils.getAsPath
import net.msrandom.minecraftcodev.core.utils.getLocalCacheDirectoryProvider
import net.msrandom.minecraftcodev.core.utils.zipFileSystem
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.Attributes
import java.util.jar.Manifest
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteExisting
import kotlin.io.path.exists
import kotlin.io.path.inputStream
import kotlin.io.path.moveTo
import kotlin.io.path.outputStream
import kotlin.io.path.writeBytes
import kotlin.math.min
import kotlin.streams.asSequence

@CacheableTask
abstract class JarIntersection : DefaultTask() {
    private companion object {
        private const val VISIBILITY_MASK = Opcodes.ACC_PUBLIC or Opcodes.ACC_PRIVATE or Opcodes.ACC_PROTECTED

        // Choose lower visibility of the two
        private fun accessIntersection(
            a: Int,
            b: Int,
        ): Int {
            val visibilityA = a and VISIBILITY_MASK
            val visibilityB = b and VISIBILITY_MASK

            fun visibilityOrdinal(value: Int) =
                when (value) {
                    Opcodes.ACC_PRIVATE -> 0
                    Opcodes.ACC_PROTECTED -> 2
                    Opcodes.ACC_PUBLIC -> 3
                    else -> 1
                }

            val visibility =
                if (visibilityOrdinal(visibilityA) > visibilityOrdinal(visibilityB)) {
                    visibilityB
                } else {
                    visibilityA
                }

            return a and VISIBILITY_MASK.inv() or visibility
        }

        private fun readNode(path: Path) =
            ClassNode().also {
                path.inputStream().use(::ClassReader).accept(it, 0)
            }

        private fun classIntersection(
            a: Path,
            b: Path,
            cacheA: MutableMap<Path, ClassNode>,
            cacheB: MutableMap<Path, ClassNode>,
        ): ByteArray {
            val nodeA = cacheA.computeIfAbsent(a, JarIntersection::readNode)
            val nodeB = cacheB.computeIfAbsent(b, JarIntersection::readNode)

            val node = ClassNode()

            node.version = min(nodeA.version, nodeB.version)
            node.access = nodeA.access
            node.name = nodeA.name
            node.signature = nodeA.signature

            var superNameA = nodeA.superName
            var superNameB = nodeB.superName

            val visitedSuperNamesA = mutableListOf<String>(superNameA)
            val visitedSuperNamesB = hashSetOf<String>(superNameB)

            while (true) {
                val match = visitedSuperNamesA.firstOrNull(visitedSuperNamesB::contains)

                if (match != null) {
                    node.superName = match
                    break
                }

                val superPathA = a.fileSystem.getPath("$superNameA.class")
                val superPathB = b.fileSystem.getPath("$superNameB.class")

                val existsA = superPathA.exists()
                val existsB = superPathB.exists()

                if (!existsA && !existsB) {
                    node.superName = superNameA
                    break
                }

                if (existsA) {
                    superNameA = cacheA.computeIfAbsent(superPathA, JarIntersection::readNode).superName

                    if (superNameA in visitedSuperNamesB) {
                        node.superName = superNameA
                        break
                    }
                }

                if (existsB) {
                    superNameB = cacheB.computeIfAbsent(superPathB, JarIntersection::readNode).superName
                }

                visitedSuperNamesA.add(superNameA)
                visitedSuperNamesB.add(superNameB)
            }

            node.interfaces = nodeA.interfaces.intersect(nodeB.interfaces.toSet()).toList()

            node.innerClasses =
                nodeA.innerClasses.filter { innerClass ->
                    nodeB.innerClasses.any {
                        it.name == innerClass.name
                    }
                }

            node.outerClass = nodeA.outerClass
            node.outerMethod = nodeA.outerMethod
            node.outerMethodDesc = nodeA.outerMethodDesc

            node.fields =
                nodeA.fields.mapNotNull { field ->
                    nodeB.fields.firstOrNull { it.name == field.name && it.desc == field.desc }?.let {
                        FieldNode(accessIntersection(it.access, field.access), it.name, it.desc, it.signature, null)
                    }
                }

            node.methods =
                nodeA.methods.mapNotNull { method ->
                    nodeB.methods.firstOrNull { it.name == method.name && it.desc == method.desc }?.let {
                        MethodNode(
                            accessIntersection(it.access, method.access),
                            it.name,
                            it.desc,
                            it.signature,
                            it.exceptions.toTypedArray().intersect(method.exceptions.toSet()).toTypedArray(),
                        )
                    }
                }

            val writer = ClassWriter(0)

            node.accept(writer)

            return writer.toByteArray()
        }

        private fun attributesIntersection(
            a: Attributes,
            b: Attributes,
        ): Attributes {
            val keys = a.keys.intersect(b.keys)

            val values =
                keys.mapNotNull {
                    val valueA = a[it]
                    val valueB = b[it]

                    if (valueA == valueB) {
                        it to valueA
                    } else {
                        null
                    }
                }

            return Attributes(values.size).apply { putAll(values) }
        }

        private fun manifestIntersection(
            a: Path,
            b: Path,
        ): Manifest {
            val manifestA = a.inputStream().use(::Manifest)
            val manifestB = b.inputStream().use(::Manifest)

            val manifest = Manifest()

            val attributeIntersections =
                manifestA.entries.keys.intersect(manifestB.entries.keys).map {
                    it to attributesIntersection(manifestA.getAttributes(it), manifestB.getAttributes(it))
                }

            manifest.mainAttributes.putAll(attributesIntersection(manifestA.mainAttributes, manifestB.mainAttributes))
            manifest.entries.putAll(attributeIntersections)

            return manifest
        }

        private fun fileIntersection(
            a: Path,
            b: Path,
            cacheA: MutableMap<Path, ClassNode>,
            cacheB: MutableMap<Path, ClassNode>,
            output: Path,
        ) {
            val name = a.toString()

            output.parent?.createDirectories()

            if (name.endsWith(".class")) {
                output.writeBytes(classIntersection(a, b, cacheA, cacheB))
            } else if (name.endsWith(".MF")) {
                output.outputStream().use(manifestIntersection(a, b)::write)
            }
        }
    }

    abstract val files: ConfigurableFileCollection
        @InputFiles
        @PathSensitive(PathSensitivity.RELATIVE)
        get

    abstract val output: RegularFileProperty
        @OutputFile get

    abstract val cacheDirectory: DirectoryProperty
        @Internal get

    init {
        output.convention(
            project.layout.file(
                project.provider {
                    temporaryDir.resolve("intersection.jar")
                },
            ),
        )

        cacheDirectory.set(getLocalCacheDirectoryProvider(project))
    }

    private fun intersection(output: Path) {
        val intersection = files.asSequence().map(File::toPath).reduce { acc, path ->
            val intermediateOutput = Files.createTempFile("intermediate-intersection", ".jar")

            intermediateOutput.deleteExisting()

            zipFileSystem(acc).use { fileSystemA ->
                zipFileSystem(path).use { fileSystemB ->
                    zipFileSystem(intermediateOutput, create = true).use { outputFileSystem ->
                        val pathsA = Files.walk(fileSystemA.getPath("/")).asSequence().map(Path::toString)
                        val pathsB = Files.walk(fileSystemB.getPath("/")).asSequence().map(Path::toString)

                        val cacheA = hashMapOf<Path, ClassNode>()
                        val cacheB = hashMapOf<Path, ClassNode>()

                        for (path in pathsA.toSet().intersect(pathsB.toSet())) {
                            fileIntersection(
                                fileSystemA.getPath(path),
                                fileSystemB.getPath(path),
                                cacheA,
                                cacheB,
                                outputFileSystem.getPath(path),
                            )
                        }
                    }
                }
            }

            intermediateOutput
        }

        intersection.moveTo(output)
    }

    @TaskAction
    fun intersection() {
        val output = output.getAsPath()

        cacheExpensiveOperation(cacheDirectory.getAsPath(), "intersection", files.map { it.toPath() }, output) { (output) ->
            intersection(output)
        }
    }
}
