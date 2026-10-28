package net.msrandom.minecraftcodev.mixins

import org.gradle.api.artifacts.transform.CacheableTransform
import org.gradle.api.artifacts.transform.InputArtifact
import org.gradle.api.artifacts.transform.TransformAction
import org.gradle.api.artifacts.transform.TransformOutputs
import org.gradle.api.artifacts.transform.TransformParameters
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity

import java.io.OutputStream
import java.nio.file.*
import kotlin.io.path.outputStream

/** Caller-registered, source-independent exact configuration cleanup for one JAR. */
@CacheableTransform
abstract class StripMixins : TransformAction<StripMixins.Parameters> {
    interface Parameters : TransformParameters {
        @get:InputFile
        @get:PathSensitive(PathSensitivity.NONE)
        val removalsFile: RegularFileProperty
    }

    @get:InputArtifact
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val inputFile: Provider<FileSystemLocation>

    override fun transform(outputs: TransformOutputs) {
        val input = inputFile.get().asFile.toPath()
        val removals = parameters.removalsFile.get().asFile.toPath()
        val output = outputs.file("${input.fileName.toString().substringBeforeLast('.')}-mixinStripped.jar").toPath()
        val inputs = listOf(input.toRealPath(), removals.toRealPath())
        val destination = mixinDestination(output.toAbsolutePath().normalize())
        require(!Files.isSymbolicLink(output)) { "Symbolic Strip output: $output" }
        for (protected in inputs) {
            require(destination != protected && !(Files.isDirectory(protected) && destination.startsWith(protected)) &&
                !(Files.exists(destination) && Files.isSameFile(destination, protected))) {
                "Output overlaps an input: $output -> $protected"
            }
        }
        require(!Files.isDirectory(destination)) { "Strip output is a directory: $output" }
        synchronized(activeOutputs) {
            require(activeOutputs.none { it == destination ||
                (Files.exists(it) && Files.exists(destination) && Files.isSameFile(it, destination)) }) {
                "Strip output is in use: $output"
            }
            activeOutputs.add(destination)
        }
        var staged: Path? = null
        var failure: Throwable? = null
        var invalidated = false
        try {
            Files.createDirectories(destination.parent)
            Files.deleteIfExists(destination)
            invalidated = true
            staged = Files.createTempFile(destination.parent, ".codev-strip-", ".jar")
            openOutput(staged).use { ExactMixinStripper.rewrite(input, removals, it) }
            Files.move(staged, destination, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING)
        } catch (error: Throwable) {
            failure = error
            throw error
        } finally {
            var cleanupFailure: Throwable? = null
            try {
                if (staged != null) Files.deleteIfExists(staged)
            } catch (cleanup: Throwable) { cleanupFailure = cleanup }
            try {
                if (invalidated && (failure != null || cleanupFailure != null)) Files.deleteIfExists(destination)
            } catch (cleanup: Throwable) {
                if (cleanupFailure == null) cleanupFailure = cleanup else cleanupFailure.addSuppressed(cleanup)
            } finally {
                synchronized(activeOutputs) { activeOutputs.remove(destination) }
            }
            if (cleanupFailure != null) {
                if (failure != null) failure.addSuppressed(cleanupFailure) else throw cleanupFailure
            }
        }
    }

    protected open fun openOutput(staged: Path): OutputStream = staged.outputStream()

    companion object {
        private val activeOutputs = mutableSetOf<Path>()
    }
}
