package net.msrandom.minecraftcodev.core.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.io.TempDir
import java.io.IOException
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption.CREATE_NEW
import java.nio.file.StandardOpenOption.WRITE
import java.util.concurrent.CountDownLatch
import java.util.concurrent.FutureTask
import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.atomic.AtomicInteger

class CacheExpensiveOperationTests {
    @TempDir
    lateinit var root: Path

    @Test
    fun sameJvmWaiterGeneratesOnceAndReceivesCompleteOutput() {
        val input = Files.writeString(root.resolve("input"), "key")
        val firstOutput = output(root, "first")
        val secondOutput = output(root, "second")
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val generations = AtomicInteger()
        val active = AtomicInteger()
        val maximumActive = AtomicInteger()
        val generate: (List<Path>) -> Unit = { (temporary) ->
            generations.incrementAndGet()
            maximumActive.accumulateAndGet(active.incrementAndGet(), ::maxOf)
            try {
                entered.countDown()
                assertTrue(release.await(30, SECONDS), "generator release timed out")
                Files.writeString(temporary, CONTENT)
            } finally {
                active.decrementAndGet()
            }
        }
        val first = FutureTask {
            cacheExpensiveOperation(root.resolve("cache"), "test", listOf(input), firstOutput, generate = generate)
        }
        val second = FutureTask {
            cacheExpensiveOperation(root.resolve("cache"), "test", listOf(input), secondOutput, generate = generate)
        }
        val firstThread = Thread(first, "cache-owner")
        val secondThread = Thread(second, "cache-waiter")
        try {
            firstThread.start()
            assertTrue(entered.await(30, SECONDS), "owner did not enter generation")
            secondThread.start()
            awaitLockWait(secondThread)
            assertEquals(1, generations.get())
            assertEquals(1, maximumActive.get())
            assertFalse(second.isDone)
            release.countDown()
            first.get(30, SECONDS)
            second.get(30, SECONDS)
            assertEquals(1, generations.get())
            assertEquals(1, maximumActive.get())
            assertEquals(CONTENT, Files.readString(firstOutput))
            assertEquals(CONTENT, Files.readString(secondOutput))
            println("SAME_JVM overlap waited; generations=${generations.get()}, maximumActive=${maximumActive.get()}, both outputs complete")
        } finally {
            release.countDown()
            for (thread in listOf(firstThread, secondThread)) {
                thread.interrupt()
                thread.join(5000)
                assertFalse(thread.isAlive, "cache test thread did not stop")
            }
        }
    }

    @Test
    fun generationFailurePropagatesAndSameKeyCanMissThenHit() {
        val input = Files.writeString(root.resolve("input"), "key")
        val key = listOf(input, "obf-named")
        val result = output(root, "retry")
        val failure = IllegalStateException("generation failed")
        val thrown = assertThrows(IllegalStateException::class.java) {
            cacheExpensiveOperation(root.resolve("cache"), "test", key, result) { throw failure }
        }
        assertSame(failure, thrown)
        assertFalse(Files.exists(result))
        val generations = AtomicInteger()
        cacheExpensiveOperation(root.resolve("cache"), "test", key, result) { (temporary) ->
            generations.incrementAndGet()
            Files.writeString(temporary, CONTENT)
        }
        assertEquals(CONTENT, Files.readString(result))
        Files.delete(result)
        cacheExpensiveOperation(root.resolve("cache"), "test", key, result) {
            generations.incrementAndGet()
            throw AssertionError("completed cache must hit")
        }
        assertEquals(1, generations.get())
        assertEquals(CONTENT, Files.readString(result))
        val changedKey = listOf(input, "obf-alt")
        cacheExpensiveOperation(root.resolve("cache"), "test", changedKey, result) { (temporary) ->
            generations.incrementAndGet()
            Files.writeString(temporary, CONTENT)
        }
        Files.delete(result)
        cacheExpensiveOperation(root.resolve("cache"), "test", changedKey, result) {
            throw AssertionError("changed string key must hit after generation")
        }
        assertEquals(2, generations.get())
        assertEquals(CONTENT, Files.readString(result))
        val unsupported = assertThrows(IllegalStateException::class.java) {
            cacheExpensiveOperation(root.resolve("cache"), "test", listOf(input, 42), result) {
                throw AssertionError("unsupported key must fail before generation")
            }
        }
        assertTrue(unsupported.message!!.contains("Unsupported cache key type kotlin.Int"))
        println("FAILURE_RECOVERY original exception propagated; mixed Path/String retry, changed-string miss/hit and unsupported type checks passed")
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    fun copyFailureLeavesNoCacheHitAndSameKeyRecovers() {
        val input = Files.writeString(root.resolve("input"), "key")
        val result = output(root, "copy-retry")
        val cache = root.resolve("cache")
        var source: FileChannel? = null
        var generated: Path? = null
        val failure = try {
            assertThrows(IOException::class.java) {
                cacheExpensiveOperation(cache, "test", listOf(input), result) { (temporary) ->
                    generated = temporary
                    Files.writeString(temporary, CONTENT)
                    // Windows enforces byte-range locks on the real file copy.
                    source = FileChannel.open(temporary, WRITE).also { it.lock() }
                }
            }
        } finally {
            source?.close()
            generated?.let { Files.deleteIfExists(it) }
        }
        assertFalse(Files.exists(result))
        val cachedDirectory = Files.list(cache.resolve("cached-operations/test")).use { it.findFirst().orElseThrow() }
        assertFalse(Files.exists(cachedDirectory.resolve(result.fileName)))
        assertEquals(listOf("lock"), Files.list(cachedDirectory).use { paths -> paths.map { it.fileName.toString() }.iterator().asSequence().toList() })

        val generations = AtomicInteger()
        cacheExpensiveOperation(cache, "test", listOf(input), result) { (temporary) ->
            generations.incrementAndGet()
            Files.writeString(temporary, CONTENT)
        }
        assertEquals(1, generations.get())
        assertEquals(CONTENT, Files.readString(result))
        Files.delete(result)
        cacheExpensiveOperation(cache, "test", listOf(input), result) {
            throw AssertionError("recovered cache must hit")
        }
        assertEquals(1, generations.get())
        assertEquals(CONTENT, Files.readString(result))
        println("COPY_FAILURE_RECOVERY ${failure.javaClass.simpleName}: ${failure.message}; no final cache or staging fragment, same-key retry miss and subsequent hit passed")
    }

    @Test
    fun separateJvmWaiterRechecksCacheAfterFileLock() {
        Files.writeString(root.resolve("input"), "key")
        val children = mutableListOf<Process>()
        try {
            val java = Path.of(System.getProperty("java.home"), "bin", "java").toString()
            val classpath = System.getProperty("cache.test.classpath")
            val first = ProcessBuilder(java, "-Djava.io.tmpdir=$root", "-cp", classpath, javaClass.name, root.toString(), "owner")
                .redirectErrorStream(true).redirectOutput(root.resolve("owner.log").toFile()).start()
            children.add(first)
            awaitCondition("owner JVM did not enter generation") {
                assertTrue(first.isAlive, Files.readString(root.resolve("owner.log")))
                Files.exists(root.resolve("owner-entered"))
            }
            val second = ProcessBuilder(java, "-Djava.io.tmpdir=$root", "-cp", classpath, javaClass.name, root.toString(), "waiter")
                .redirectErrorStream(true).redirectOutput(root.resolve("waiter.log").toFile()).start()
            children.add(second)
            awaitCondition("waiter JVM did not wait for the file lock") {
                assertTrue(second.isAlive, Files.readString(root.resolve("waiter.log")))
                Files.exists(root.resolve("waiter-waiting"))
            }
            assertTrue(first.isAlive)
            assertFalse(Files.exists(output(root, "waiter")))
            first.outputStream.write(1)
            first.outputStream.flush()
            for ((role, process) in listOf("owner" to first, "waiter" to second)) {
                assertTrue(process.waitFor(30, SECONDS), "$role JVM did not finish")
                val log = Files.readString(root.resolve("$role.log"))
                assertEquals(0, process.exitValue(), log)
                println("CHILD $role exit=${process.exitValue()}\n$log")
                assertEquals(CONTENT, Files.readString(output(root, role)))
            }
            assertEquals("once", Files.readString(root.resolve("generated")))
            println("CROSS_JVM file-lock wait observed; one generation, both outputs complete")
        } finally {
            for (process in children) {
                if (process.isAlive) {
                    process.destroyForcibly()
                    assertTrue(process.waitFor(10, SECONDS), "child JVM did not stop")
                }
            }
        }
    }

    companion object {
        private val CONTENT = "begin\n" + "complete output\n".repeat(8192) + "end\n"

        private fun output(root: Path, role: String): Path =
            Files.createDirectories(root.resolve(role)).resolve("result.bin")

        private fun awaitCondition(message: String, condition: () -> Boolean) {
            val deadline = System.nanoTime() + SECONDS.toNanos(30)
            while (!condition()) {
                assertTrue(System.nanoTime() < deadline, message)
                Thread.sleep(10)
            }
        }

        private fun awaitLockWait(thread: Thread) {
            awaitCondition("cache caller did not wait in withLock") {
                assertTrue(thread.isAlive, "cache caller finished before waiting")
                thread.state == Thread.State.TIMED_WAITING && thread.stackTrace.any {
                    it.className == "net.msrandom.minecraftcodev.core.utils.CacheKt" && it.methodName == "withLock"
                }
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val root = Path.of(args[0])
            val role = args[1]
            val operation = FutureTask {
                cacheExpensiveOperation(root.resolve("cache"), "test", listOf(root.resolve("input")), output(root, role)) { (temporary) ->
                    Files.writeString(root.resolve("generated"), "once", CREATE_NEW)
                    check(role == "owner") { "waiter regenerated instead of hitting the cache" }
                    Files.writeString(root.resolve("owner-entered"), "entered")
                    check(System.`in`.read() == 1) { "owner release was not received" }
                    Files.writeString(temporary, CONTENT)
                }
            }
            val thread = Thread(operation, "cache-$role")
            thread.isDaemon = true
            thread.start()
            if (role == "waiter") {
                awaitLockWait(thread)
                Files.writeString(root.resolve("waiter-waiting"), "waiting")
                println("FILE_LOCK_WAIT observed before owner release")
            }
            operation.get(30, SECONDS)
        }
    }
}
