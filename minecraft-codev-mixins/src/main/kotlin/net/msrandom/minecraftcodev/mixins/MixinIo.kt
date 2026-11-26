package net.msrandom.minecraftcodev.mixins

import java.io.Closeable
import java.nio.file.Path
import java.util.concurrent.ConcurrentHashMap

/** Per-path I/O probes: nested Gradle builds and parallel transforms must not affect unrelated operations. */
internal object MixinIo {
    enum class Operation { RESOLVE, READ_RECORD, OPEN_JAR, DELETE_STAGE, PUBLISH }
    private val probes = ConcurrentHashMap<Pair<Operation, Path>, Runnable>()

    fun observe(operation: Operation, path: Path, probe: Runnable): Closeable {
        val key = operation to path.toAbsolutePath().normalize()
        check(probes.putIfAbsent(key, probe) == null)
        return Closeable { probes.remove(key, probe) }
    }

    fun before(operation: Operation, path: Path) {
        if (probes.isNotEmpty()) probes[operation to path.toAbsolutePath().normalize()]?.run()
    }
}
