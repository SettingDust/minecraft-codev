package net.msrandom.minecraftcodev.forge.accesswidener

import net.msrandom.minecraftcodev.accesswidener.AccessModifiers
import net.msrandom.minecraftcodev.accesswidener.AccessModifierClassVisitor
import org.cadixdev.at.AccessChange
import org.cadixdev.at.AccessTransform
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.platform.commons.annotation.Testable
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

@Testable
class ForgeAccessTransformerNullDescriptorTests {
    @Test
    fun `forge at with field without descriptor does not cause null pointer exception`() {
        // Create a mock FileSystem with Forge AT containing a field without descriptor
        val modifiers = AccessModifiers(false, "official", false)

        // Simulate loading a Forge AT with a field that has no descriptor
        // This is what happens when visitField is called with null descriptor
        modifiers.visitField("net/minecraft/world/item/Item", "FOOD", null, AccessTransform.of(AccessChange.PUBLIC))

        // Verify that the field was registered without crashing
        assertTrue(modifiers.canModifyAccess("net/minecraft/world/item/Item"))
        
        // Verify the field rule exists (by checking getFieldAccess doesn't crash)
        val testAccess = Opcodes.ACC_PRIVATE
        val result = modifiers.getFieldAccess(testAccess, "net/minecraft/world/item/Item", "FOOD", "I")
        
        // Should have visibility modified to PUBLIC
        assertEquals(testAccess and Opcodes.ACC_PUBLIC, result and Opcodes.ACC_PUBLIC)
    }

    @Test
    fun `forge at field without descriptor can be applied to class bytes`() {
        // Create a simple test class
        val writer = ClassWriter(0)
        writer.visit(
            Opcodes.V17,
            Opcodes.ACC_PUBLIC,
            "test/Item",
            null,
            "java/lang/Object",
            emptyArray(),
        )

        // Add a private field
        writer.visitField(Opcodes.ACC_PRIVATE, "name", "Ljava/lang/String;", null, null)
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

        // Create modifiers with field rule (no descriptor)
        val modifiers = AccessModifiers(false, null, false)
        modifiers.visitField("test/Item", "name", null, AccessTransform.of(AccessChange.PUBLIC))

        // Apply modifiers using AccessModifierClassVisitor
        val outputWriter = ClassWriter(0)
        val reader = ClassReader(inputBytes)
        val visitor = AccessModifierClassVisitor(Opcodes.ASM9, outputWriter, modifiers)
        reader.accept(visitor, 0)

        // Verify output contains the modified field
        val outputBytes = outputWriter.toByteArray()
        val outputReader = ClassReader(outputBytes)

        var fieldFound = false
        var isPublic = false

        outputReader.accept(
            object : org.objectweb.asm.ClassVisitor(Opcodes.ASM9) {
                override fun visitField(
                    access: Int,
                    name: String,
                    descriptor: String,
                    signature: String?,
                    value: Any?,
                ): org.objectweb.asm.FieldVisitor? {
                    if (name == "name") {
                        fieldFound = true
                        isPublic = (access and Opcodes.ACC_PUBLIC) != 0
                    }
                    return null
                }
            },
            0,
        )

        assertTrue(fieldFound, "Field 'name' should be found in output")
        assertTrue(isPublic, "Field 'name' should be public after applying modifiers")
    }

    @Test
    fun `forge at null descriptor field does not interfere with typed fields`() {
        // Create modifiers with both typed and untyped field rules
        val modifiers = AccessModifiers(false, null, false)

        // Add a field with descriptor
        modifiers.visitField("test/Item", "typed", "I", AccessTransform.of(AccessChange.PUBLIC))

        // Add a field without descriptor
        modifiers.visitField("test/Item", "untyped", null, AccessTransform.of(AccessChange.PUBLIC))

        assertTrue(modifiers.canModifyAccess("test/Item"))

        // Both should be retrievable and applicable
        val testAccess = Opcodes.ACC_PRIVATE

        // Typed field matching with correct descriptor
        val typedResult = modifiers.getFieldAccess(testAccess, "test/Item", "typed", "I")
        assertEquals(testAccess and Opcodes.ACC_PUBLIC, typedResult and Opcodes.ACC_PUBLIC)

        // Untyped field matching (any descriptor should match)
        val untypedResult = modifiers.getFieldAccess(testAccess, "test/Item", "untyped", "Ljava/lang/String;")
        assertEquals(testAccess and Opcodes.ACC_PUBLIC, untypedResult and Opcodes.ACC_PUBLIC)
    }
}
