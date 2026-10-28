package net.msrandom.minecraftcodev.accesswidener

import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.cadixdev.at.AccessChange
import org.cadixdev.at.AccessTransform
import org.cadixdev.at.ModifierChange
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.objectweb.asm.Opcodes

class AccessTransformJsonTests {
    @Test
    fun modelRoundTripPreservesFieldsAndAccessBits() {
        val model = AccessModifiers(namedSource = true).apply {
            visitClass("example/Owner", AccessTransform.of(AccessChange.PRIVATE, ModifierChange.ADD))
            visitMethod("example/Owner", "run", "()V", AccessTransform.of(AccessChange.PROTECTED, ModifierChange.NONE))
            visitField("example/Owner", "value", null, AccessTransform.of(AccessChange.PUBLIC, ModifierChange.REMOVE))
        }
        val encoded = Json.encodeToString(model)
        val owner = Json.parseToJsonElement(encoded).jsonObject.getValue("classes").jsonObject.getValue("example/Owner").jsonObject
        assertEquals(Json.parseToJsonElement("""{"accessChange":"PRIVATE","finalChange":"ADD"}"""), owner.getValue("accessTransform"))
        assertEquals(
            Json.parseToJsonElement("""{"accessChange":"PROTECTED","finalChange":"NONE"}"""),
            owner.getValue("methods").jsonObject.getValue("run").jsonArray.single().jsonObject.getValue("accessTransform"),
        )
        assertEquals(
            Json.parseToJsonElement("""{"accessChange":"PUBLIC","finalChange":"REMOVE"}"""),
            owner.getValue("fields").jsonObject.getValue("value").jsonObject.getValue("accessTransform"),
        )

        val decoded = Json.decodeFromString<AccessModifiers>(encoded)
        assertEquals(model, decoded)
        assertNull(decoded.classes.getValue("example/Owner").fields.getValue("value").descriptor)
        val aggregated = AccessModifiers(namedSource = true).apply { visit(decoded) }
        assertEquals(decoded, aggregated)
        assertEquals(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL or Opcodes.ACC_SYNTHETIC, aggregated.getClassAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_SYNTHETIC, "example/Owner"))
        assertEquals(Opcodes.ACC_PROTECTED or Opcodes.ACC_FINAL or Opcodes.ACC_STATIC, aggregated.getMethodAccess(Opcodes.ACC_PUBLIC or Opcodes.ACC_FINAL or Opcodes.ACC_STATIC, "example/Owner", "run", "()V"))
        assertEquals(Opcodes.ACC_PUBLIC or Opcodes.ACC_STATIC, aggregated.getFieldAccess(Opcodes.ACC_PRIVATE or Opcodes.ACC_FINAL or Opcodes.ACC_STATIC, "example/Owner", "value", "I"))
    }

    @Test
    fun reorderedFieldsDecodeAndRequiredFieldsAreEnforced() {
        val serializer = AccessModifiers.AccessTransformSerializer()
        assertEquals(
            AccessTransform.of(AccessChange.PUBLIC, ModifierChange.REMOVE),
            Json.decodeFromString(serializer, """{"finalChange":"REMOVE","accessChange":"PUBLIC"}"""),
        )
        assertThrows(SerializationException::class.java) {
            Json.decodeFromString(serializer, """{"accessChange":"PUBLIC"}""")
        }
        assertThrows(SerializationException::class.java) {
            Json.decodeFromString(serializer, """{"finalChange":"REMOVE"}""")
        }
    }
}
