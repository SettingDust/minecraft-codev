package net.msrandom.minecraftcodev.mixins

import org.gradle.api.artifacts.transform.TransformOutputs
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Provider
import org.gradle.testfixtures.ProjectBuilder
import java.io.FilterOutputStream
import java.io.IOException
import java.io.OutputStream
import java.io.UncheckedIOException
import java.lang.reflect.Proxy
import java.nio.file.Files
import java.nio.file.Path

/** Direct component fixture, deliberately not a Gradle registration/cache test. */
class StripFixture(root: Path, input: Path, information: Path, output: Path) : StripMixins() {
    private val project = ProjectBuilder.builder().withProjectDir(root.toFile()).build()
    @JvmField val source: RegularFileProperty = project.objects.fileProperty().also { it.set(input.toFile()) }
    @JvmField val cleanup: ConfigurableFileCollection = project.objects.fileCollection().from(information.toFile())
    @JvmField val destination: RegularFileProperty = project.objects.fileProperty().also { it.set(output.toFile()) }
    @JvmField val parameters: Parameters
    @JvmField var fault = ""
    @JvmField var faultReached = false
    @JvmField var outputClosed = false
    @JvmField val writeFailure = IOException("fixture write failure")
    @JvmField val closeFailure = IOException("fixture close failure")
    @JvmField var onOpen = Runnable {}
    @JvmField var step = 0
    @JvmField var faultStep = 1
    @JvmField var registrations = 0
    @JvmField val stages = mutableListOf<Path>()

    init {
        parameters = object : Parameters {
            override val removalsFile: ConfigurableFileCollection get() = cleanup
        }
    }

    override fun getParameters(): Parameters = parameters

    @Suppress("UNCHECKED_CAST")
    override val inputFile: Provider<FileSystemLocation>
        get() = source as Provider<FileSystemLocation>

    override fun openOutput(staged: Path): OutputStream {
        try {
            step++
            stages.add(staged)
            onOpen.run()
            return object : FilterOutputStream(Files.newOutputStream(staged)) {
                override fun write(bytes: ByteArray, offset: Int, length: Int) {
                    out.write(bytes, offset, length)
                    if (step == faultStep && !faultReached) {
                        if (fault == "write" || fault == "write-close") {
                            faultReached = true
                            throw writeFailure
                        }

                    }
                }

                override fun close() {
                    super.close()
                    outputClosed = true
                    if (step == faultStep && (fault == "close" || fault == "write-close")) {
                        faultReached = true
                        fault = ""
                        throw closeFailure
                    }
                    if (step == faultStep && !faultReached && fault.isNotEmpty()) {
                        faultReached = true
                        if (fault == "move") Files.delete(staged)
                    }
                }
            }
        } catch (error: IOException) {
            throw UncheckedIOException(error)
        }
    }

    fun strip() {
        transform(Proxy.newProxyInstance(javaClass.classLoader, arrayOf(TransformOutputs::class.java)) { _, method, _ ->
            if (method.name != "file") throw UnsupportedOperationException(method.name)
            registrations++
            destination.get().asFile
        } as TransformOutputs)
    }
}
