package net.msrandom.minecraftcodev.mixins.runtime

import org.spongepowered.asm.service.IGlobalPropertyService
import org.spongepowered.asm.service.IPropertyKey
import java.util.HashMap

class IsolatedMixinGlobalPropertyService : IGlobalPropertyService {
    private val values = HashMap<String, Any?>()
    private class Key(val name: String) : IPropertyKey
    override fun resolveKey(name: String): IPropertyKey = Key(name)
    @Suppress("UNCHECKED_CAST")
    override fun <T> getProperty(key: IPropertyKey): T? = values[(key as Key).name] as T?
    override fun setProperty(key: IPropertyKey, value: Any?) { values[(key as Key).name] = value }
    override fun <T> getProperty(key: IPropertyKey, fallback: T): T = getProperty<T>(key) ?: fallback
    override fun getPropertyString(key: IPropertyKey, fallback: String?): String? = getProperty<Any>(key)?.toString() ?: fallback
}
