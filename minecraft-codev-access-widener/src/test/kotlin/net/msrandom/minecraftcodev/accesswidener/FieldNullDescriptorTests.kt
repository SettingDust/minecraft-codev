package net.msrandom.minecraftcodev.accesswidener

import org.cadixdev.at.AccessChange
import org.cadixdev.at.AccessTransform
import org.junit.jupiter.api.Test
import org.junit.platform.commons.annotation.Testable
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

@Testable
class FieldNullDescriptorTests {
    @Test
    fun `field with null descriptor can be created and merged`() {
        val modifiers = AccessModifiers(false, null, false)

        // Add a field with null descriptor
        modifiers.visitField("test/Class", "field1", null, AccessTransform.of(AccessChange.PUBLIC))

        // Merge with same field with null descriptor should succeed
        modifiers.visitField("test/Class", "field1", null, AccessTransform.of(AccessChange.PUBLIC))

        assertTrue(modifiers.canModifyAccess("test/Class"))
    }

    @Test
    fun `field with null descriptor matches any actual descriptor at bytecode level`() {
        val modifiers = AccessModifiers(false, null, false)

        // Add a field rule with null descriptor
        modifiers.visitField("test/Class", "field1", null, AccessTransform.of(AccessChange.PUBLIC))

        // getFieldAccess should match any descriptor
        val testAccess = Opcodes.ACC_PRIVATE
        
        // Try with int descriptor
        val resultInt = modifiers.getFieldAccess(testAccess, "test/Class", "field1", "I")
        assertEquals((testAccess or Opcodes.ACC_PUBLIC) and Opcodes.ACC_PRIVATE.inv(), resultInt and Opcodes.ACC_PUBLIC)

        // Try with String descriptor
        val resultString = modifiers.getFieldAccess(testAccess, "test/Class", "field1", "Ljava/lang/String;")
        assertEquals((testAccess or Opcodes.ACC_PUBLIC) and Opcodes.ACC_PRIVATE.inv(), resultString and Opcodes.ACC_PUBLIC)

        // Try with array descriptor
        val resultArray = modifiers.getFieldAccess(testAccess, "test/Class", "field1", "[I")
        assertEquals((testAccess or Opcodes.ACC_PUBLIC) and Opcodes.ACC_PRIVATE.inv(), resultArray and Opcodes.ACC_PUBLIC)
    }

    @Test
    fun `field with descriptor is preferred when merging with null descriptor`() {
        val modifiers = AccessModifiers(false, null, false)

        // First, add field without descriptor
        modifiers.visitField("test/Class", "field1", null, AccessTransform.of(AccessChange.PUBLIC))

        // Then, add same field with descriptor
        modifiers.visitField("test/Class", "field1", "I", AccessTransform.of(AccessChange.PUBLIC))

        // The field descriptor should now be "I"
        val fieldModel = modifiers.classes["test/Class"]?.fields?.get("field1")
        assertEquals("I", fieldModel?.descriptor)
    }

    @Test
    fun `field null descriptor does not conflict with typed field`() {
        val modifiers = AccessModifiers(false, null, false)

        // Add a field with descriptor
        modifiers.visitField("test/Class", "typedField", "I", AccessTransform.of(AccessChange.PUBLIC))

        // Add a field without descriptor (should not conflict)
        modifiers.visitField("test/Class", "untypedField", null, AccessTransform.of(AccessChange.PROTECTED))

        // Both should exist and be accessible
        val typed = modifiers.classes["test/Class"]?.fields?.get("typedField")
        val untyped = modifiers.classes["test/Class"]?.fields?.get("untypedField")

        assertEquals("I", typed?.descriptor)
        assertEquals(null, untyped?.descriptor)
    }

    @Test
    fun `applying null descriptor field rule to class bytes works correctly`() {
        // Create a test class with two fields
        val writer = ClassWriter(0)
        writer.visit(
            Opcodes.V17,
            Opcodes.ACC_PUBLIC,
            "test/Example",
            null,
            "java/lang/Object",
            emptyArray(),
        )

        writer.visitField(Opcodes.ACC_PRIVATE, "field1", "I", null, null)
        writer.visitField(Opcodes.ACC_PRIVATE, "field2", "Ljava/lang/String;", null, null)

        writer.visitMethod(
            Opcodes.ACC_PUBLIC,
            "<init>",
            "()V",
            null,
            null,
        ).apply {
            visitCode()
            visitVarInsn(Opcodes.ALOAD, 0)
            visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
            visitInsn(Opcodes.RETURN)
            visitMaxs(1, 1)
            visitEnd()
        }

        writer.visitEnd()
        val inputBytes = writer.toByteArray()

        // Create modifiers with a null-descriptor field rule
        val modifiers = AccessModifiers(false, null, false)
        modifiers.visitField("test/Example", "field1", null, AccessTransform.of(AccessChange.PUBLIC))

        // Apply modifiers
        val outputWriter = ClassWriter(0)
        val reader = ClassReader(inputBytes)
        val visitor = AccessModifierClassVisitor(Opcodes.ASM9, outputWriter, modifiers)
        reader.accept(visitor, 0)

        // Verify that field1 was made public
        val outputBytes = outputWriter.toByteArray()
        val outputReader = ClassReader(outputBytes)

        var field1Public = false
        var field2Private = true

        outputReader.accept(
            object : org.objectweb.asm.ClassVisitor(Opcodes.ASM9) {
                override fun visitField(
                    access: Int,
                    name: String,
                    descriptor: String,
                    signature: String?,
                    value: Any?,
                ): org.objectweb.asm.FieldVisitor? {
                    when (name) {
                        "field1" -> field1Public = (access and Opcodes.ACC_PUBLIC) != 0
                        "field2" -> field2Private = (access and Opcodes.ACC_PRIVATE) != 0
                    }
                    return null
                }
            },
            0,
        )

        assertTrue(field1Public, "field1 should be public after applying null-descriptor rule")
        assertTrue(field2Private, "field2 should remain private (not in rules)")
    }
}
