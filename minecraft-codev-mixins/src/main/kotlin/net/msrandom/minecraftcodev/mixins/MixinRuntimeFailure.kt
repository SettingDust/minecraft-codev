package net.msrandom.minecraftcodev.mixins

import java.util.IdentityHashMap

private class MixinRuntimeFailure(private val originalType: String, message: String?) : RuntimeException(message) {
    override fun toString(): String = if (message == null) originalType else "$originalType: $message"
}

/** Detach the complete diagnostic graph while every child exception can still be inspected. */
internal fun hostMixinFailure(failure: Throwable): Throwable {
    val copies = IdentityHashMap<Throwable, Throwable>()
    val pending = ArrayDeque<Throwable>()
    fun node(original: Throwable): Throwable = copies[original] ?: MixinRuntimeFailure(original.javaClass.name, original.message).also {
        it.stackTrace = original.stackTrace
        copies[original] = it
        pending.addLast(original)
    }
    val result = node(failure)
    while (pending.isNotEmpty()) {
        val original = pending.removeFirst()
        val copy = copies.getValue(original)
        copy.initCause(original.cause?.let(::node))
        for (suppressed in original.suppressed) copy.addSuppressed(node(suppressed))
    }
    return result
}
