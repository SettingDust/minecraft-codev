# Game Artifacts and Naming Context

This bounded context describes how Minecraft version inputs become consumable game artifact views and how symbols and access changes are named. It does not own Cloche target graphs, loader distribution formats, or launch success.

## Language

**version metadata**: Inputs describing an upstream Minecraft version, including its identifier, downloads, libraries, asset index, Java version, and launch arguments. It is not a set of downloaded or verified files. [Version structure](src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt#L18)

**game common**: A game dependency view produced by the game-side split through bundled or legacy paths. It is not Cloche's common target or JVM Multiplatform's common API intersection. [Consumption views](src/main/kotlin/net/msrandom/minecraftcodev/core/MinecraftComponentMetadataRule.kt#L29) [Splitting](src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt#L14)

**game client**: The client-side companion view of a game artifact split. It is not a Cloche `client` compilation and does not by itself describe a runnable launch. [Consumption views](src/main/kotlin/net/msrandom/minecraftcodev/core/MinecraftComponentMetadataRule.kt#L29)

**mappings**: Correspondences used to transform symbols between naming namespaces. They are not package layouts or Mod IDs. [Mapping inputs](../minecraft-codev-remapper/src/main/kotlin/net/msrandom/minecraftcodev/remapper/task/LoadMappings.kt#L29)

**namespace**: A named symbol view such as `obf`, `named`, or a loader-specific name. `official` requires interpretation from its mapping source or file header; it is not unconditionally equivalent to `named`. [Namespace attribute](src/main/kotlin/net/msrandom/minecraftcodev/core/MappingsNamespace.kt#L6)

**remap**: A bytecode transformation governed by an input JAR, source and target namespaces, mappings, and a classpath. Renaming an attribute alone is not remapping. [Transformation inputs](../minecraft-codev-remapper/src/main/kotlin/net/msrandom/minecraftcodev/remapper/task/RemapTask.kt#L30)

**access modification**: A requested change to visibility, final status, or related class/member properties, organized with the relevant descriptor and namespace. It is not remapping or Java expect/actual matching. [Access model](../minecraft-codev-access-widener/src/main/kotlin/net/msrandom/minecraftcodev/accesswidener/AccessModifiers.kt#L24)

## Unresolved

- The inspected source does not define a general semantic or binary compatibility guarantee between game views across versions.
- The `official` interpretation exception is conditional and directional; a broader equivalence policy is not established.
- Cloche selects when this context's artifacts and transformations are requested; the cross-repository ownership and integration contract remain unspecified.
