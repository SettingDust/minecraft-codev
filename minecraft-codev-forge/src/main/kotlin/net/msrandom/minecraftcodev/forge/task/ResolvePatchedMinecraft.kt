package net.msrandom.minecraftcodev.forge.task

import arrow.core.Either
import net.msrandom.minecraftcodev.core.resolve.*
import net.msrandom.minecraftcodev.core.task.CachedMinecraftTask
import net.msrandom.minecraftcodev.core.task.MinecraftVersioned
import net.msrandom.minecraftcodev.core.task.versionList
import net.msrandom.minecraftcodev.core.utils.*
import net.msrandom.minecraftcodev.forge.McpConfigFile
import net.msrandom.minecraftcodev.forge.UserdevConfig
import net.neoforged.accesstransformer.cli.TransformerProcessor
import org.gradle.api.artifacts.ConfigurationContainer
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*
import org.gradle.jvm.toolchain.JavaToolchainService
import org.gradle.process.ExecOperations
import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import javax.inject.Inject
import kotlin.io.path.*

const val PATCH_OPERATION_VERSION = 10

@CacheableTask
abstract class ResolvePatchedMinecraft : CachedMinecraftTask(), MinecraftVersioned {
    abstract val libraries: ConfigurableFileCollection
        @InputFiles
        @PathSensitive(PathSensitivity.ABSOLUTE)
        get

    abstract val patches: ConfigurableFileCollection
        @InputFiles
        @PathSensitive(PathSensitivity.ABSOLUTE)
        get

    abstract val universal: ConfigurableFileCollection
        @InputFiles
        @PathSensitive(PathSensitivity.ABSOLUTE)
        get

    abstract val neoforge: Property<Boolean>
        @Input
        get

    abstract val output: RegularFileProperty
        @OutputFile get

    abstract val configurationContainer: ConfigurationContainer
        @Inject get

    abstract val dependencyHandler: DependencyHandler
        @Inject get

    abstract val javaToolchainService: JavaToolchainService
        @Inject get

    abstract val execOperations: ExecOperations
        @Inject get

    init {
        output.convention(
            project.layout.file(
                minecraftVersion.map {
                    temporaryDir.resolve("minecraft-$it-patched.jar")
                },
            ),
        )
    }

    private fun resolve(cacheDirectory: Path, outputPath: Path) {
        val isOffline = cacheParameters.getIsOffline().get()

        val metadata = cacheParameters.versionList().version(minecraftVersion.get())

        val clientJar = downloadFullMinecraftClient(cacheDirectory, metadata, isOffline)

        val extractionState = getServerExtractionState(cacheDirectory, metadata, isOffline)!!

        val serverJar = extractionState.result

        val userdevFile = patches.filter { "userdev" in it.name }.singleFile

        val userdev = when (val result = UserdevConfig.fromFile(userdevFile)) {
            is Either.Left -> throw (result.value
                ?: UnsupportedOperationException("Could not find userdev to generate patched minecraft with"))

            is Either.Right -> result.value
        }

        val mcpConfigPath = dependencyFile(patches, userdev.mcp)

        val mcpConfig = when (val result = McpConfigFile.configEntry(mcpConfigPath)) {
            is Either.Left -> throw (result.value
                ?: UnsupportedOperationException("Could not find ${userdev.mcp} to generate patched minecraft with"))

            is Either.Right -> result.value
        }

        val javaExecutable =
            metadata.javaVersion
                .executable(javaToolchainService)
                .get()
                .asFile

        val librariesFile = Files.createTempFile("libraries", ".txt")

        librariesFile.writeLines(libraries.flatMap { listOf("-e", it.absolutePath) })

        val serverJarSupplier = { serverJar }
        val clientJarSupplier = { clientJar }

        val preExecutedSteps = mapOf(
            "downloadServer" to serverJarSupplier,
            "stripServer" to serverJarSupplier,
            "extractServer" to serverJarSupplier,

            "downloadClient" to clientJarSupplier,
            "stripClient" to clientJarSupplier,

            "listLibraries" to { librariesFile },

            "downloadClientMappings" to {
                downloadMinecraftFile(
                    cacheDirectory,
                    metadata,
                    MinecraftDownloadVariant.ClientMappings,
                    isOffline,
                )!!
            }
        )

        val patchStepPlacement = if (userdev.notchObf) {
            // replace the output of merge with the patch, since we want to binary patch after merging and before remapping
            "merge"
        } else if (mcpConfig.steps.joined.any { it["type"] == "mcinject" }) {
            // replace the output of rename with the patch, since we want to binary patch after remapping and before injecting
            "rename"
        } else {
            // add patch to end
            null
        }

        val context = McpActionContext(
            javaExecutable,
            execOperations,
            logger,
            { temporaryDir.resolve("$it.log").toPath() },
        )
        val patchResult = runBinaryPatcher(
            userdev,
            userdevFile,
            McpConfigFile(
                mcpConfig,
                mcpConfigPath.toPath(),
            ),
            patchStepPlacement,
            preExecutedSteps,
            minecraftVersion.get(),
            dependencyHandler,
            configurationContainer,
            universal,
            libraries,
            context,
        )
        val patched = patchResult.patched

        val isNeoforge = neoforge.get()

        zipFileSystem(patched).use { patchedZip ->
            if (!isNeoforge || !isUnobfuscatedVersion(minecraftVersion.get())) {
                val filters = userdev.universalFilters.map(::Regex)

                val rawClasses = patchResult.notchOverlay?.let {
                    Files.createTempFile("universal-obf", ".jar").also(Path::deleteExisting)
                }
                val classZip = rawClasses?.let { zipFileSystem(it, create = true) }
                try {
                    zipFileSystem(universal.singleFile.toPath()).use { universalZip ->
                        val root = universalZip.getPath("/")

                        root.walk {
                            for (path in filter(Path::isRegularFile)) {
                                val name = root.relativize(path).toString()

                                if (!filters.all { name matches it }) {
                                    continue
                                }

                                val target = if (classZip != null && name.endsWith(".class")) classZip else patchedZip
                                val output = target.getPath(name)
                                output.parent?.createDirectories()
                                path.copyTo(
                                    output,
                                    StandardCopyOption.COPY_ATTRIBUTES,
                                    StandardCopyOption.REPLACE_EXISTING,
                                )
                            }
                        }
                    }
                } finally {
                    classZip?.close()
                }
                if (rawClasses != null) {
                    val normalized = normalizeNotchOverlay(rawClasses, checkNotNull(patchResult.notchOverlay), libraries, context)
                    zipFileSystem(normalized).use { overlayZip ->
                        val root = overlayZip.getPath("/")
                        root.walk {
                            for (path in filter { it.isRegularFile() && it.name.endsWith(".class") }) {
                                val output = patchedZip.getPath(root.relativize(path).toString())
                                output.parent?.createDirectories()
                                path.copyTo(output, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING)
                            }
                        }
                    }
                }
            }

            // Add userdev injects
            val inject = userdev.inject

            if (inject != null) {
                zipFileSystem(userdevFile.toPath()).use userdev@{ userdevZip ->
                    val injectPath = userdevZip.getPath("/$inject")

                    if (injectPath.notExists()) {
                        return@userdev
                    }

                    injectPath.walk {
                        for (path in filter(Path::isRegularFile)) {
                            val output = patchedZip.getPath(injectPath.relativize(path).toString())

                            output.parent?.createDirectories()
                            path.copyTo(output, StandardCopyOption.COPY_ATTRIBUTES)
                        }
                    }
                }
            }
        }

        val atFiles = zipFileSystem(userdevFile.toPath()).use { fs ->
            userdev.ats.flatMap {
                val path = fs.getPath(it)

                val paths =
                    if (path.isDirectory()) {
                        path.listDirectoryEntries()
                    } else {
                        listOf(path)
                    }

                paths.map {
                    val temp = Files.createTempFile("at-", ".tmp.cfg")

                    it.copyTo(temp, StandardCopyOption.REPLACE_EXISTING)

                    temp
                }
            }
        }

        val err = System.err

        try {
            temporaryDir.resolve("at.log").outputStream().use {
                System.setErr(PrintStream(it))

                TransformerProcessor.main(
                    "--inJar",
                    patched.toAbsolutePath().toString(),
                    "--outJar",
                    outputPath.toString(),
                    *atFiles
                        .flatMap { at ->
                            listOf("--atFile", at.toAbsolutePath().toString())
                        }.toTypedArray(),
                )
            }
        } finally {
            System.setErr(err)
        }

        if (isNeoforge) {
            DistAttributePostProcessor.postProcess(
                outputPath,
                clientJar,
                serverJar,
                cacheDirectory,
                metadata,
                isOffline,
            )
        }

        addMinecraftMarker(outputPath)
    }

    @TaskAction
    fun resolve() {
        val cacheDirectory = cacheParameters.directory.getAsPath()

        val operationName = if (neoforge.get()) {
            "neoforge-patch-$PATCH_OPERATION_VERSION"
        } else {
            "forge-patch-$PATCH_OPERATION_VERSION"
        }

        cacheExpensiveOperation(
            cacheDirectory,
            operationName,
            (patches + universal + libraries).map { it.toPath() },
            output.getAsPath(),
        ) { (output) ->
            resolve(cacheDirectory, output)
        }
    }
}
