# Distribution Embedding Context

This bounded context describes the identity and format translation used when dependency JARs are explicitly placed inside an outer Mod JAR. It does not own regular dependency linkage, source linkage, remapping, or Gradle settings `include`.

## Language

**included artifact**: A dependency artifact selected for embedding and represented by a file plus usable module identity. A file path alone is insufficient to identify the artifact. [Embedding information](src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L22)

**embedding coordinates**: The identity data used for an included artifact: group, module name, artifact version, version range, and file. These coordinates are not the outer Mod's loader attributes or mapping state. [Coordinate translation](src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L22)

**include intent**: An upstream request to embed selected dependencies. It is distinct from ordinary compile/runtime use, and Codev processes only the resolved, explicitly selected scope. [Cloche include selection](../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/TargetCompilation.kt#L274)

**capability and variant**: Dependency-resolution views used to infer an included artifact's identity. They are not the Mod's capability, target attributes, or remapping result. Files without usable coordinates are skipped, and a resolution failure is not success. [Identity inference](src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L44) [Processing boundary](src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L111)

**format adaptation**: Translation of one embedding intent into a loader-specific packaging representation. Fabric JarInJar and Forge JarJar are separate formats; one format's metadata cannot be assumed to define the other. [Fabric](../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt#L23) [Forge](../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt#L21)

**version range**: The version constraint carried with embedding coordinates. Its full consumer-facing policy is not defined by the inspected context alone. [Included artifact](src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L22)

## Unresolved

- The source does not establish a fallback identity for files that lack usable coordinates.
- The exact consumer contract for version ranges and the behavior of all resolution failures require an authoritative specification.
- Embedding is intentionally non-transitive in the Cloche selection path; the broader ownership of transitive packaging policy is not established here.
