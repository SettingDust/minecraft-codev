package net.msrandom.minecraftcodev.mixins

import org.gradle.api.artifacts.transform.CacheableTransform
import org.gradle.api.artifacts.transform.InputArtifact
import org.gradle.api.artifacts.transform.TransformAction
import org.gradle.api.artifacts.transform.TransformOutputs
import org.gradle.api.artifacts.transform.TransformParameters
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity

import java.io.IOException
import java.io.OutputStream
import java.nio.file.*
import kotlin.io.path.outputStream

/** Caller-registered, source-independent exact configuration cleanup for one JAR. */
@CacheableTransform
abstract class StripMixins : TransformAction<StripMixins.Parameters> {
    interface Parameters : TransformParameters {
        @get:Classpath
        val removalsFile: ConfigurableFileCollection
    }

    @get:InputArtifact
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val inputFile: Provider<FileSystemLocation>

    override fun transform(outputs: TransformOutputs) {
        val input = inputFile.get().asFile.toPath()
        val removals = parameters.removalsFile.files.toList()
        require(removals.isNotEmpty()) { "No Strip records for $input" }
        val output = outputs.file("${input.fileName.toString().substringBeforeLast('.')}-mixinStripped.jar").toPath()
        val inputs = listOf(input.toRealPath()) + removals.map { it.toPath().toRealPath() }
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
        val staged = mutableListOf<Path>()
        var failure: Throwable? = null
        var invalidated = false
        try {
            Files.createDirectories(destination.parent)
            Files.deleteIfExists(destination)
            invalidated = true
            var current = input
            for ((index, record) in removals.withIndex()) {
                try {
                    val next = Files.createTempFile(destination.parent, ".codev-strip-", ".jar")
                    staged.add(next)
                    openOutput(next).use { ExactMixinStripper.rewrite(current, record.toPath(), it) }
                    current = next
                } catch (error: Exception) {
                    throw IOException("Cannot strip $input with record ${index + 1} $record from $current", error)
                }
            }
            try {
                Files.move(current, destination, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING)
            } catch (error: Exception) {
                throw IOException("Cannot publish Strip $input after record ${removals.last()} from $current to $destination", error)
            }
        } catch (error: Throwable) {
            failure = error
            throw error
        } finally {
            var cleanupFailure: Throwable? = null
            for (temporary in staged) {
                try {
                    Files.deleteIfExists(temporary)
                } catch (cleanup: Throwable) {
                    if (cleanupFailure == null) cleanupFailure = cleanup else cleanupFailure.addSuppressed(cleanup)
                }
            }
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
