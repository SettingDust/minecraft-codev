package net.msrandom.minecraftcodev.mixins.mixin

import com.google.common.base.Joiner
import com.google.common.collect.HashMultimap
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToStream
import net.fabricmc.mappingio.format.tiny.Tiny2FileReader
import net.fabricmc.mappingio.tree.MemoryMappingTree
import net.msrandom.minecraftcodev.core.utils.SetMultimapSerializer
import net.msrandom.minecraftcodev.core.utils.zipFileSystem
import net.msrandom.minecraftcodev.mixins.MixinListingRule
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.launch.platform.container.ContainerHandleURI
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.Mixins
import org.spongepowered.asm.service.MixinService
import java.io.File
import java.nio.file.FileVisitResult
import java.nio.file.StandardCopyOption
import java.util.ServiceLoader
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.copyTo
import kotlin.io.path.createParentDirectories
import kotlin.io.path.deleteIfExists
import kotlin.io.path.extension
import kotlin.io.path.fileVisitor
import kotlin.io.path.name
import kotlin.io.path.readBytes
import kotlin.io.path.visitFileTree
import kotlin.io.path.writeBytes

/**
 * Executor class that runs Mixin application in an isolated classloader context.
 * All Mixin framework references resolve to classes in the isolated classloader.
 * This class must be loaded by IsolatingMixinClassLoader.
 */
class IsolatedMixinExecutor {

    companion object {
        private val JOINER = Joiner.on('.')
    }

    /**
     * Execute mixin application in an isolated context.
     * All parameters are primitive/String types for cross-classloader safety.
     */
    @OptIn(ExperimentalPathApi::class, ExperimentalSerializationApi::class)
    fun execute(
        inputFilePath: String,
        outputFilePath: String,
        mixinFilePaths: List<String>,
        classpathPaths: List<String>,
        side: String,
        mappingsFilePath: String,
        sourceNamespace: String,
        targetNamespace: String,
        appliedMixinsFilePath: String
    ) {
        // 1. Initialize Mixin system (fresh in this classloader!)
        MixinBootstrap.init()

        val service = MixinService.getService() as GradleMixinService
        service.phaseConsumer.accept(MixinEnvironment.Phase.DEFAULT)

        // 2. Convert string paths to File/Path objects
        val inputFile = File(inputFilePath).toPath()
        val outputFile = File(outputFilePath).toPath()
        val mixinFiles = mixinFilePaths.map { File(it) }
        val classpathFiles = classpathPaths.map { File(it) }
        val mappingsFile = File(mappingsFilePath)
        val appliedMixinsFile = File(appliedMixinsFilePath)

        val mixinSide = MixinEnvironment.Side.valueOf(side)

        // 3. Set up the classpath (all files including mixins and input)
        val allClasspathFiles = classpathFiles + mixinFiles + listOf(inputFile.toFile())

        service.use(allClasspathFiles, mixinSide) {
            // 4. Set up mappings
            val mappings = MemoryMappingTree()
            Tiny2FileReader.read(mappingsFile.reader(), mappings)

            MixinEnvironment.getDefaultEnvironment().remappers.add(
                MappingIoRemapperAdapter(mappings, sourceNamespace, targetNamespace)
            )

            MixinEnvironment.getDefaultEnvironment().setOption(
                MixinEnvironment.Option.REFMAP_REMAP,
                System.getProperty("mixin.env.remapRefMap", "true").toBoolean()
            )

            // 5. Set up recorder
            val appliedMixins = HashMultimap.create<String, String>()
            recorderExtension.appliedMixins = appliedMixins

            // 6. Load mixin listing rules from this classloader
            val mixinListingRules = ServiceLoader.load(
                MixinListingRule::class.java,
                this.javaClass.classLoader
            ).toList()

            // 7. Add mixin configurations
            for (mixinFile in mixinFiles + listOf(inputFile.toFile())) {
                zipFileSystem(mixinFile.toPath()).use fs@{ fs ->
                    val root = fs.getPath("/")

                    val handler = mixinListingRules.firstNotNullOfOrNull { rule ->
                        rule.load(root)
                    }

                    if (handler == null) {
                        return@fs
                    }

                    val configs = handler.list(root)
                    if (configs.isEmpty()) {
                        return@fs
                    }

                    Mixins.addConfigurations(
                        configs.toTypedArray(),
                        ContainerHandleURI(mixinFile.toPath().toUri())
                    )
                }
            }

            // 8. Transform classes
            outputFile.deleteIfExists()

            zipFileSystem(inputFile).use { inputFs ->
                val root = inputFs.getPath("/")

                zipFileSystem(outputFile, true).use { outputFs ->
                    root.visitFileTree(fileVisitor {
                        onVisitFile { path, _ ->
                            val outputPath = outputFs.getPath(
                                path.getName(0).name,
                                *path.drop(1).map { it.name }.toList().toTypedArray()
                            )

                            outputPath.createParentDirectories()

                            if (path.extension == "class") {
                                val pathName = JOINER.join(root.relativize(path))
                                val name = pathName.substring(0, pathName.length - ".class".length)
                                outputPath.writeBytes(transformer.transformClassBytes(name, name, path.readBytes()))
                            } else {
                                path.copyTo(
                                    outputPath,
                                    StandardCopyOption.COPY_ATTRIBUTES,
                                    StandardCopyOption.REPLACE_EXISTING
                                )
                            }
                            FileVisitResult.CONTINUE
                        }
                    })
                }
            }

            // 9. Write applied mixins
            Json.encodeToStream(
                SetMultimapSerializer(String.serializer(), String.serializer()),
                appliedMixins,
                appliedMixinsFile.outputStream()
            )
        }
    }
}
