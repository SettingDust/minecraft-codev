package net.msrandom.minecraftcodev.remapper

import net.msrandom.minecraftcodev.core.utils.cacheExpensiveOperation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path
import kotlin.io.path.createFile
import kotlin.io.path.readText
import kotlin.io.path.writeText

class RemapCacheTests {
    @Test
    fun `cache key separates remap namespaces`(@TempDir temporaryDirectory: Path) {
        val input = temporaryDirectory.resolve("input.jar").createFile()
        val firstOutput = temporaryDirectory.resolve("first.jar")
        val secondOutput = temporaryDirectory.resolve("second.jar")

        cacheExpensiveOperation(
            temporaryDirectory,
            "remap-test",
            listOf("intermediary", "named", input),
            firstOutput,
        ) { (output) ->
            output.writeText("named")
        }

        cacheExpensiveOperation(
            temporaryDirectory,
            "remap-test",
            listOf("official", "named", input),
            secondOutput,
        ) { (output) ->
            output.writeText("official")
        }

        assertEquals("named", firstOutput.readText())
        assertEquals("official", secondOutput.readText())
    }

    @Test
    fun `cache key separates reversed remap namespaces`(@TempDir temporaryDirectory: Path) {
        val input = temporaryDirectory.resolve("input.jar").createFile()
        val firstOutput = temporaryDirectory.resolve("first.jar")
        val secondOutput = temporaryDirectory.resolve("second.jar")

        cacheExpensiveOperation(
            temporaryDirectory,
            "remap-test",
            listOf("intermediary", "named", input),
            firstOutput,
        ) { (output) ->
            output.writeText("intermediary-to-named")
        }

        cacheExpensiveOperation(
            temporaryDirectory,
            "remap-test",
            listOf("named", "intermediary", input),
            secondOutput,
        ) { (output) ->
            output.writeText("named-to-intermediary")
        }

        assertEquals("intermediary-to-named", firstOutput.readText())
        assertEquals("named-to-intermediary", secondOutput.readText())
    }
}