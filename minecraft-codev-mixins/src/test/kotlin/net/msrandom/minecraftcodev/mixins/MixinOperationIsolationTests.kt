package net.msrandom.minecraftcodev.mixins

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Properties

/** Codev selector cleanup; the stub is not an engine smoke. */
class MixinOperationIsolationTests {
    private val selectors = listOf("mixin.service", "mixin.bootstrapService")

    private fun selectors(values: List<String?>) {
        for ((name, value) in selectors.zip(values)) {
            if (value == null) System.clearProperty(name) else System.setProperty(name, value)
        }
    }

    private fun selectors(): List<String?> = selectors.map(System::getProperty)

    class Initializer {
        companion object {
            var failure: Throwable? = null

            @JvmStatic fun initializeMixins() {
                failure?.let { throw it }
            }
        }
    }

    @Test fun initializationFailureStillRestoresBothSelectorsAndKeepsCause() {
        val saved = selectors()
        val prior = listOf("host.Service", "host.Bootstrap")
        val primary = RuntimeException("initializer failure")
        val restoration = SecurityException("first selector restore denied")
        val attempts = mutableListOf<String>()
        var restoring = false
        try {
            selectors(prior)
            Initializer.failure = primary
            val loader = object : ClassLoader() {
                override fun loadClass(name: String): Class<*> {
                    assertEquals(listOf("net.msrandom.minecraftcodev.mixins.runtime.IsolatedMixinService", "net.msrandom.minecraftcodev.mixins.runtime.IsolatedMixinServiceBootstrap"), selectors())
                    restoring = true
                    return Initializer::class.java
                }
            }
            val original = System.getProperties()
            System.setProperties(object : Properties() {
                init { putAll(original) }
                override fun setProperty(key: String, value: String): Any? {
                    if (restoring && key in selectors) {
                        attempts.add(key)
                        if (key == selectors[0]) throw restoration
                    }
                    return super.setProperty(key, value)
                }
            })
            try {
                val failure = assertThrows(Throwable::class.java) { initializeMixinRuntime(loader) }
                assertSame(primary, failure)
                assertArrayEquals(arrayOf(restoration), failure.suppressed)
                assertEquals(selectors, attempts)
                assertEquals(prior[1], selectors()[1])
            } finally { System.setProperties(original) }
        } finally {
            Initializer.failure = null
            selectors(saved)
        }
    }
}
