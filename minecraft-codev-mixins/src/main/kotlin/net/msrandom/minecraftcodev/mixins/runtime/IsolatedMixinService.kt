package net.msrandom.minecraftcodev.mixins.runtime

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode
import org.spongepowered.asm.logging.ILogger
import org.spongepowered.asm.logging.LoggerAdapterConsole
import org.spongepowered.asm.launch.platform.container.ContainerHandleVirtual
import org.spongepowered.asm.launch.platform.container.IContainerHandle
import org.spongepowered.asm.mixin.transformer.IMixinTransformer
import org.spongepowered.asm.mixin.transformer.IMixinTransformerFactory
import org.spongepowered.asm.service.*
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.Collections

/** Loaded only inside one operation's engine domain. */
class IsolatedMixinService : MixinServiceAbstract() {
    override fun getName(): String = "Codev operation"
    override fun isValid(): Boolean = true
    override fun createLogger(name: String): ILogger = LoggerAdapterConsole(name)
    fun transformer(): IMixinTransformer = getInternal(IMixinTransformerFactory::class.java).createTransformer()
    override fun getClassProvider(): IClassProvider = object : IClassProvider {
        override fun getClassPath(): Array<URL> = arrayOf()
        @Throws(ClassNotFoundException::class)
        override fun findClass(name: String): Class<*> = findClass(name, true)
        @Throws(ClassNotFoundException::class)
        override fun findClass(name: String, initialize: Boolean): Class<*> = Class.forName(name, initialize, IsolatedMixinService::class.java.classLoader)
        @Throws(ClassNotFoundException::class)
        override fun findAgentClass(name: String, initialize: Boolean): Class<*> = findClass(name, initialize)
    }
    override fun getBytecodeProvider(): IClassBytecodeProvider = object : IClassBytecodeProvider {
        @Throws(IOException::class)
        override fun getClassNode(name: String): ClassNode = getClassNode(name, true, 0)
        @Throws(IOException::class)
        override fun getClassNode(name: String, transform: Boolean): ClassNode = getClassNode(name, transform, 0)
        @Throws(IOException::class)
        override fun getClassNode(name: String, transform: Boolean, flags: Int): ClassNode =
            getResourceAsStream(name.replace('.', '/') + ".class").use { input ->
                if (input == null) throw FileNotFoundException(name)
                val node = ClassNode()
                ClassReader(input).accept(node, flags)
                node
            }
    }
    override fun getTransformerProvider(): ITransformerProvider? = null
    override fun getClassTracker(): IClassTracker = object : IClassTracker {
        override fun registerInvalidClass(name: String) {}
        override fun isClassLoaded(name: String): Boolean = false
        override fun getClassRestrictions(name: String): String = ""
    }
    override fun getAuditTrail(): IMixinAuditTrail? = null
    override fun getPlatformAgents(): Collection<String> = Collections.singletonList("org.spongepowered.asm.launch.platform.MixinPlatformAgentDefault")
    override fun getPrimaryContainer(): IContainerHandle = ContainerHandleVirtual("codev-operation")
    override fun getResourceAsStream(name: String): InputStream? = IsolatedMixinService::class.java.classLoader.getResourceAsStream(name)
}

/** No external host setup: the fresh child already owns its complete implementation domain. */
class IsolatedMixinServiceBootstrap : IMixinServiceBootstrap {
    override fun getName(): String = "Codev operation"
    override fun getServiceClassName(): String = IsolatedMixinService::class.java.name
    override fun bootstrap() {}
}
