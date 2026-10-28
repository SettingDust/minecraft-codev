package net.msrandom.minecraftcodev.forge

import kotlinx.serialization.json.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfSystemProperty
import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class ForgePatchNamespaceFixtureTests {
    @Test
    @EnabledIfSystemProperty(named = "fixture.neo.verifyPrepared", matches = "true")
    fun verifiesPreparedNeo121NoMcinjectWithCacheHit() {
        fun requiredPath(name: String): Path = Path.of(checkNotNull(System.getProperty(name)?.takeIf(String::isNotBlank)) {
            "$name is required for the opt-in prepared Neo verification"
        })
        val evidence = ForgePatchNamespaceInputs.verifyPreparedNeo121NoMcinject(
            requiredPath("fixture.neo.preparedRoot"),
        )
        assertTrue(Files.isRegularFile(evidence.resolve("verified.txt")))
    }

    @Test
    fun preparesNeo121NoMcinjectWithPrivateCache() {
        val evidence = ForgePatchNamespaceInputs.prepareNeo121NoMcinject()
        assertTrue(Files.isRegularFile(evidence.resolve("prepared.txt")))
        val classes = Json.parseToJsonElement(Files.readString(evidence.resolve("class-witnesses.json"))).jsonObject
        assertTrue(classes.getValue("patched").jsonArray.isNotEmpty())
        assertEquals(0, classes.getValue("unpatchedInterface").jsonObject.getValue("patchRecords").jsonPrimitive.int)
        assertEquals("official", classes.getValue("patchInputNamespace").jsonPrimitive.content)
        val resources = Json.parseToJsonElement(Files.readString(evidence.resolve("resource-witnesses.json"))).jsonArray
        assertTrue(resources.isNotEmpty())
        resources.forEach { witness -> assertEquals(witness.jsonObject.getValue("expectedSha256"), witness.jsonObject.getValue("actualSha256")) }
    }
    @Test
    fun preparesForge1165McinjectWithPrivateCache() {
        val evidence = ForgePatchNamespaceInputs.prepareForge1165Mcinject()
        assertTrue(Files.isRegularFile(evidence.resolve("prepared.txt")))
        val classes = Json.parseToJsonElement(Files.readString(evidence.resolve("class-witnesses.json"))).jsonObject
        assertTrue(classes.getValue("patched").jsonArray.isNotEmpty())
        assertEquals(0, classes.getValue("unpatchedInterface").jsonObject.getValue("patchRecords").jsonPrimitive.int)
        val inventory = Json.parseToJsonElement(Files.readString(evidence.resolve("resource-inventory.json"))).jsonObject
        val inject = inventory.getValue("inject").jsonObject.values.map { it.jsonPrimitive.content }
        assertEquals(13, inject.count { it.endsWith(".class") })
        assertEquals(3, inject.count { it.startsWith("META-INF/services/") })
        val resources = Json.parseToJsonElement(Files.readString(evidence.resolve("resource-witnesses.json"))).jsonArray
        assertEquals(inject.toSet(), resources.map { it.jsonObject }.filter { it.getValue("origin").jsonPrimitive.content == "userdev-inject" }
            .map { it.getValue("target").jsonPrimitive.content }.toSet())
        resources.forEach { witness -> assertEquals(witness.jsonObject.getValue("expectedSha256"), witness.jsonObject.getValue("actualSha256")) }
    }

    @Test
    fun preparesBasicNotchWithPrivateCache() {
        val evidence = ForgePatchNamespaceInputs.prepareBasicNotch()
        assertTrue(Files.isRegularFile(evidence.resolve("prepared.txt")))
        assertTrue(Files.isRegularFile(evidence.resolve("class-witnesses.json")))
        assertTrue(Files.isRegularFile(evidence.resolve("resource-witnesses.json")))
        val inventory = Json.parseToJsonElement(Files.readString(evidence.resolve("resource-inventory.json"))).jsonObject
        fun entries(key: String) = inventory.getValue(key).jsonArray.map { it.jsonPrimitive.content }.toSet()
        val collisions = entries("universalResources").intersect(entries("cleanResources") + entries("patchResources"))
        assertEquals(collisions, entries("universalResourceCollisions"))
        if (entries("cleanOnly").isEmpty()) {
            assertTrue(entries("cleanResources").isEmpty())
            assertTrue(inventory.getValue("cleanOnlyApplicability").jsonPrimitive.content.startsWith("not-applicable:"))
        }
        if (inventory.getValue("inject").jsonObject.isEmpty()) {
            assertEquals("inject/", inventory.getValue("userdevConfig").jsonObject.getValue("inject").jsonPrimitive.content)
            assertTrue(entries("injectPrefixEntriesIncludingDirectories").isEmpty())
            assertTrue(inventory.getValue("injectApplicability").jsonPrimitive.content.startsWith("not-applicable:"))
        }
        val resources = Json.parseToJsonElement(Files.readString(evidence.resolve("resource-witnesses.json"))).jsonArray
        assertTrue(resources.isNotEmpty())
        if (collisions.isEmpty()) {
            assertEquals(entries("universalOnly"), resources.map { it.jsonObject }.filter {
                it.getValue("origin").jsonPrimitive.content.startsWith("universal-only;")
            }.map { it.getValue("target").jsonPrimitive.content }.toSet())
        }
        resources.forEach { witness ->
            assertEquals(witness.jsonObject.getValue("expectedSha256"), witness.jsonObject.getValue("actualSha256"))
        }
    }
}
