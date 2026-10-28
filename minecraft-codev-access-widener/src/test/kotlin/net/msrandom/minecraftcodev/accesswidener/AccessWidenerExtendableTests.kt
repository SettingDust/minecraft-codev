package net.msrandom.minecraftcodev.accesswidener

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.fabricmc.classtweaker.api.visitor.AccessWidenerVisitor.AccessType.EXTENDABLE
import org.cadixdev.at.AccessChange
import org.cadixdev.at.AccessTransform
import org.cadixdev.at.ModifierChange
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.objectweb.asm.Opcodes

class AccessWidenerExtendableTests {
    @Test
    fun extendablePreservesPublicAccessThroughJsonAndAggregation() {
        val model = AccessModifiers(namedSource = true).apply {
            visitAccessWidener("example/Owner").apply {
                visitClass(EXTENDABLE, false)
                visitMethod("run", "()V", EXTENDABLE, false)
            }
        }
        val decoded = Json.decodeFromString<AccessModifiers>(Json.encodeToString(model))
        val aggregated = AccessModifiers(namedSource = true).apply { visit(decoded) }
        assertEquals(model, decoded)
        assertEquals(model, aggregated)

        for (modifiers in listOf(model, decoded, aggregated)) {
            assertEquals(
                Opcodes.ACC_PUBLIC or Opcodes.ACC_SYNTHETIC,
                modifiers.getClassAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_FINAL or Opcodes.ACC_SYNTHETIC, "example/Owner"),
            )
            assertEquals(
                Opcodes.ACC_PUBLIC or Opcodes.ACC_SYNTHETIC,
                modifiers.getMethodAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_FINAL or Opcodes.ACC_SYNTHETIC, "example/Owner", "run", "()V"),
            )
            assertEquals(
                Opcodes.ACC_PROTECTED or Opcodes.ACC_SYNTHETIC,
                modifiers.getMethodAccess(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL or Opcodes.ACC_SYNTHETIC, "example/Owner", "run", "()V"),
            )
        }
    }

    @Test
    fun aggregationRetainsAwOriginAndExistingAtMergeRules() {
        val aw = AccessModifiers(namedSource = true).apply {
            visitAccessWidener("example/Owner").apply {
                visitMethod("run", "()V", EXTENDABLE, false)
                visitMethod("open", "()V", EXTENDABLE, false)
            }
        }
        val at = AccessModifiers(namedSource = true).apply {
            visitMethod("example/Owner", "run", "()V", AccessTransform.of(AccessChange.PROTECTED, ModifierChange.REMOVE))
            visitMethod("example/Owner", "open", "()V", AccessTransform.of(AccessChange.PUBLIC, ModifierChange.ADD))
        }
        val decodedAt = Json.decodeFromString<AccessModifiers>(Json.encodeToString(at))
        assertEquals(at, decodedAt)
        assertEquals(
            Opcodes.ACC_PROTECTED,
            decodedAt.getMethodAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_FINAL, "example/Owner", "run", "()V"),
        )

        for (sources in listOf(listOf(aw, at), listOf(at, aw))) {
            val merged = AccessModifiers(namedSource = true).apply { sources.forEach { visit(it) } }
            val decoded = Json.decodeFromString<AccessModifiers>(Json.encodeToString(merged))
            assertEquals(merged, decoded)
            assertEquals(
                AccessTransform.of(AccessChange.PUBLIC, ModifierChange.REMOVE),
                decoded.classes.getValue("example/Owner").method("open", "()V")!!.accessTransform,
            )
            assertEquals(
                Opcodes.ACC_PUBLIC,
                decoded.getMethodAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_FINAL, "example/Owner", "run", "()V"),
            )
            assertEquals(
                Opcodes.ACC_PROTECTED,
                decoded.getMethodAccess(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL, "example/Owner", "run", "()V"),
            )
            assertEquals(
                Opcodes.ACC_PUBLIC,
                decoded.getMethodAccess(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL, "example/Owner", "open", "()V"),
            )
        }
    }
}
