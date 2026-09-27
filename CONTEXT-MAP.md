# Minecraft Codev Context Map

Minecraft Codev contains three bounded contexts with different meanings despite shared Gradle inputs. The map records their ownership and evidenced translations; it does not create a shared kernel or a cross-repository contract.

## Contexts

- [Game artifacts and naming](minecraft-codev-core/CONTEXT.md): prepares Minecraft game dependency views and defines symbol naming, remapping, and access modification language.
- [Distribution embedding](minecraft-codev-includes/CONTEXT.md): identifies dependency artifacts explicitly embedded in an outer Mod JAR and adapts that intent to loader formats.
- [Development launches](minecraft-codev-runs/CONTEXT.md): describes named run configurations, preparation inputs, and launch requests.

## Relationships

- **Cloche -> Game artifacts and naming**: Cloche target and compilation choices select the game artifact and naming inputs consumed by a target. Cloche's `common` target is not this context's game common view. [Cloche target compilation](../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/TargetCompilation.kt#L303)
- **Game artifacts and naming -> Distribution embedding**: Artifact identity and selected views can supply inputs to embedding, but an embedded artifact remains a packaging concern and is not automatically implied by ordinary dependency use. [Embedding coordinates](minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt#L44)
- **Cloche -> Distribution embedding**: Cloche's explicit include intent feeds Codev's embedding-coordinate and loader-format adaptation. Fabric JarInJar and Forge JarJar are separate format translations. [Fabric adapter](minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt#L23) [Forge adapter](minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt#L21)
- **Cloche -> Development launches**: Cloche run purposes, SourceSets, and loader arguments feed Codev run requests. Prepared arguments are launch inputs, not proof of a successful game run. [Run association](minecraft-codev-runs/src/main/kotlin/net/msrandom/minecraftcodev/runs/MinecraftRunConfiguration.kt#L31)
- **Game artifacts and naming -> Development launches**: Game dependency views and naming inputs contribute to the runtime selected for a run; a launch still depends on the run configuration and Java environment. [Run execution](minecraft-codev-runs/src/main/kotlin/net/msrandom/minecraftcodev/runs/task/RunMinecraft.kt#L17)
- **Cloche -> Mixins boundary**: Mod resource/metadata configuration and Codev's pre-application transformation are distinct meanings. Configuration does not prove transformation, and pre-application is not loader runtime loading. [Pre-application](minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt#L56) [Resource configuration](../cloche/src/main/kotlin/earth/terrarium/cloche/target/TargetHandler.kt#L241)

Namespace identifiers, game common/client views, and embedding coordinates cross these relationships as translated inputs. The inspected sources do not establish formal cross-team ownership, a shared version-coordination policy, or a composite-build integration guarantee. [Namespace](minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/MappingsNamespace.kt#L6) [Cloche dependencies](../cloche/build.gradle.kts#L40)
