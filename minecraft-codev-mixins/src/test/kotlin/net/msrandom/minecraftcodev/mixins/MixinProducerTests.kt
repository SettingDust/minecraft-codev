package net.msrandom.minecraftcodev.mixins

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

/** One real engine smoke: Codev bootstraps Mixin and applies the simplest existing fixture. */
class MixinProducerTests {
    @TempDir lateinit var root: Path

    @Test fun bootstrapAndApplyOneMixinThroughCodevProducer() {
        val fixture = MixinFixture(root)
        fixture.target = OrdinaryInputs.copyJar("target", root.resolve("target.jar"))
        val source = OrdinaryInputs.copyJar("smoke-source", root.resolve("smoke-source.jar"))
        val output = fixture.produce("startup", listOf(source.toString()), emptyList())
        assertEquals(42, fixture.value(output))
    }
}
