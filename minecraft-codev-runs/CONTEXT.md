# Development Launches Context

This bounded context describes named development launch requests for Minecraft. It does not define an already-running game session, a distribution artifact, or test success.

## Language

**run configuration**: A named project-level launch definition containing an entry-point class, Java version, associated SourceSet, pre-run work, run dependencies, arguments, environment, and working directory. [Run configuration](src/main/kotlin/net/msrandom/minecraftcodev/runs/MinecraftRunConfiguration.kt#L31)

**run name**: The project-local identity used to select a run configuration. It is not the Minecraft version, Mod ID, or loader identity. [Run configuration](src/main/kotlin/net/msrandom/minecraftcodev/runs/MinecraftRunConfiguration.kt#L31)

**pre-run work**: Work associated with a run configuration and completed or requested before the Minecraft process is attempted. Its presence does not prove that the process started. [Run configuration](src/main/kotlin/net/msrandom/minecraftcodev/runs/MinecraftRunConfiguration.kt#L31)

**run preparation**: The launch inputs serialized or produced for a run, including arguments, JVM arguments, properties, and environment. Preparation does not contain the run's entire identity or runtime classpath. [Serialized preparation](src/main/kotlin/net/msrandom/minecraftcodev/runs/SerializedRunConfig.kt#L5) [Preparation](src/main/kotlin/net/msrandom/minecraftcodev/runs/task/PrepareRun.kt#L38)

**launch request**: An attempt to start Minecraft after reading preparation data and selecting the Java environment and runtime classpath. It is not a successful launch result. [Execution](src/main/kotlin/net/msrandom/minecraftcodev/runs/task/RunMinecraft.kt#L17)

**run purpose**: A Cloche association such as `server`, `client`, `data`, or `test` that supplies inputs to a run. It is not a loader, mapping namespace, or independent common target. [Cloche run purposes](../../cloche/README.md#L79) [Common boundary](../../cloche/src/main/kotlin/earth/terrarium/cloche/target/common/CommonTargetCreator.kt#L131)

## Unresolved

- The inspected source does not define a durable lifecycle or result model for a launch attempt beyond its preparation and process invocation.
- The ownership of success criteria, exit-status interpretation, and test reporting across Cloche and Codev is not established.
- A common compilation is not independently runnable, but the broader policy for rejecting or representing such a request is not specified.
