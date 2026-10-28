package net.msrandom.minecraftcodev.mixins.task

import net.msrandom.minecraftcodev.mixins.implementationInputs
import net.msrandom.minecraftcodev.mixins.nativePropertyNames
import net.msrandom.minecraftcodev.mixins.produceMixins
import org.gradle.api.DefaultTask
import org.gradle.api.file.FileCollection
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class Mixin : DefaultTask() {
    @get:InputFile
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val inputFile: RegularFileProperty

    @get:Classpath
    abstract val mixinFiles: ConfigurableFileCollection

    @get:Classpath
    abstract val classpath: ConfigurableFileCollection

    @get:InputFile
    @get:Optional
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val mappingFile: RegularFileProperty

    @get:Input
    @get:Optional
    abstract val sourceNamespace: Property<String>

    @get:Input
    @get:Optional
    abstract val targetNamespace: Property<String>

    @get:Input
    @get:Optional
    abstract val refmapContext: Property<String>

    @get:Input
    abstract val side: Property<String>

    @get:Classpath
    val implementationClasspath: FileCollection = project.files(implementationInputs())

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @get:OutputFile
    abstract val appliedMixins: RegularFileProperty

    init {
        outputFile.convention(project.layout.buildDirectory.file("mixin/$name/applied.jar"))
        appliedMixins.convention(project.layout.buildDirectory.file("mixin/$name/removals.json"))
        side.convention("UNKNOWN")
        for (key in nativePropertyNames()) {
            // Empty list distinguishes unset from every possible raw property string; Mixin still reads it natively.
            inputs.property("nativeMixin.$key", project.providers.provider { System.getProperty(key)?.let { listOf(it) } ?: emptyList<String>() })
        }
    }

    @TaskAction
    fun mixin() {
        val input = inputFile.get().asFile
        val outputJar = outputFile.get().asFile.toPath()
        val recordsFile = appliedMixins.get().asFile.toPath()
        val outputs = listOf(outputJar, recordsFile)
        val runtime = classpath.files.map { it.absolutePath }
        val sources = mixinFiles.files.map { it.absolutePath }
        try {
            produceMixins(input.absolutePath, sources, runtime, side.get(), outputJar.toString(), recordsFile.toString(),
                mappingFile.orNull?.asFile?.absolutePath, sourceNamespace.orNull, targetNamespace.orNull, refmapContext.orNull)
        } catch (failure: Throwable) {
            logger.error("Mixin producer/publication failed: target=$input outputs=$outputs", failure)
            throw failure
        }
    }
}
