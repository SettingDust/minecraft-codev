package net.msrandom.minecraftcodev.mixins

import net.msrandom.minecraftcodev.mixins.runtime.TinyMappingRemapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/** Codev's member selection and namespace direction; mapping-io owns descriptor conversion. */
class MixinMappingTests {
    @TempDir lateinit var root: Path

    private fun observed(boundary: String, expected: String?, actual: String?) {
        assertEquals(expected, actual, boundary)
        println("OBSERVED $boundary -> $actual")
    }

    @Test
    fun exactOwnerOverloadDescriptorReverseAndMissing() {
        val mappings = OrdinaryInputs.copyMappingResource("mapping.tiny", root.resolve("mapping.tiny"))
        val r = TinyMappingRemapper(mappings.toString(), "src", "named")

        observed("method src/A.run(I)I", "tick", r.mapMethodName("src/A", "run", "(I)I"))
        observed("overload src/A.run(String)I", "label", r.mapMethodName("src/A", "run", "(Ljava/lang/String;)I"))
        observed("different owner src/B.run(I)I", "step", r.mapMethodName("src/B", "run", "(I)I"))
        observed("field src/A.s:I", "state", r.mapFieldName("src/A", "s", "I"))
        observed("missing owner+descriptor ambiguous", "run", r.mapMethodName(null, "run", null))
        observed("missing descriptor overload ambiguous", "run", r.mapMethodName("src/A", "run", null))
        observed("missing owner two candidates ambiguous", "run", r.mapMethodName(null, "run", "(I)I"))
        observed("missing owner+descriptor unique", "renamedUnique", r.mapMethodName(null, "unique", null))
        observed("missing descriptor unique", "renamedUnique", r.mapMethodName("src/A", "unique", null))
        observed("missing owner unique", "label", r.mapMethodName(null, "run", "(Ljava/lang/String;)I"))
        observed("null input member passthrough", null, r.mapMethodName("src/A", null, "(I)I"))
        observed("null target member passthrough", "nullName", r.mapMethodName("src/Null", "nullName", "()I"))
        observed("missing member passthrough", "absent", r.mapMethodName("missing", "absent", null))
        val reverse = TinyMappingRemapper(mappings.toString(), "named", "src")

        observed("reverse method tuple", "run", reverse.mapMethodName("game/A", "tick", "(I)I"))
        observed("reverse field tuple", "s", reverse.mapFieldName("game/A", "state", "I"))
    }
}
