package net.msrandom.minecraftcodev.mixins


data class MixinConfigReference(val resource: String, val side: ConfigSide) {
    init {
        require(resource.isNotBlank() && resource.none { it < ' ' }) { "Mixin config resource must be a nonblank path without control characters" }
        require(resource.isNotBlank() && resource.none { it < ' ' } && !resource.startsWith("/") && !resource.contains('\\') && !resource.contains(':') && resource.split('/').none { it == "." || it == ".." }) { "Unsafe archive path: $resource" }
    }
}
