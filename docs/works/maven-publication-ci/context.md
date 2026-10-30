# Maven publication CI Context

[Work](work.md) · [Plan](plan.md) · [Waves](waves.md)

## Settled boundary

The [Spec](../../spec/maven-publication-ci.md) owns detailed behavior and acceptance; the [ADR](../../adr/git-backed-maven-publishing.md) owns the accepted architecture. This Context records observations and implementation arrangements, not replacement authority.

The supplied prior documentation result reports the three policy gaps closed, minimal ADR synchronization and 19 relative-link checks passing, with no Gradle or publishing execution. The current authority files have been read for this preparation; the earlier check count is supplied history, not a newly reproduced test. The supplied migration facts say old `maven-repo` branches were deleted and the central repository retained; no remote branch inspection or migration is repeated here.

## Current implementation observations

- The [old workflow](../../../.github/workflows/publish.yml) triggers on pull requests and unrestricted `main` pushes, puts a sequence directly under `jobs.publish`, requests JDK 8 and invokes `test publish`. It needs replacement, not an additional competing workflow.
- The [wrapper](../../../gradle/wrapper/gradle-wrapper.properties) selects Gradle 9.4.0. Its [runtime compatibility matrix](https://docs.gradle.org/9.4.0/userguide/compatibility.html) requires JVM 17–26. JDK 17 is the chosen Gradle launcher; JDK 11 and JDK 8 remain compilation toolchains, not launchers.
- The [root build](../../../build.gradle.kts) applies Maven publishing and repository configuration to direct children and gives them Java 11, source and Javadoc JARs. It retains `mavenLocal` and HTTP publishing destinations. Nested [side-annotations](../../../minecraft-codev-core/side-annotations/build.gradle.kts) and [codev-forge-runtime](../../../minecraft-codev-forge/codev-forge-runtime/build.gradle.kts) have their own Maven publications and Java 8 toolchains; a direct-child-only new repository would miss them.
- The [settings](../../../settings.gradle.kts) include the nine Gradle plugin projects, the two nested libraries and IDEA. The Spec's publication table was checked against all twelve included module build files. It remains a static baseline, not evaluated Gradle output. Root and all included projects must be queried for actual `MavenPublication` objects, including late-created markers.
- [Core](../../../minecraft-codev-core/build.gradle.kts) explicitly configures `pluginMaven`; plugin builds declare their plugin IDs through `java-gradle-plugin`. Marker groups differ from `net.msrandom` and may be POM-only. The legacy client-annotations build is not included by settings.
- [IDEA](../../../minecraft-codev-idea/build.gradle.kts) defines `idea` at `com.jetbrains.plugins:net.msrandom.minecraft-codev:1.0-SNAPSHOT` from the Java component. Its separate Marketplace/signing tasks are not the Maven publication path. Source versions must stay as configured.
- The [root properties](../../../gradle.properties) enable configuration cache, configure-on-demand and parallel execution. The proposed publication invocation explicitly disables configuration cache and configure-on-demand so this narrow cross-project coordination sees every evaluated publication; normal developer invocations retain their existing settings.
- Inspection found no existing publication coordinator or dedicated local CI Maven repository task. No Gradle evaluation, compilation, publication, dependency resolution or consumer execution has been performed for this preparation.

## Chosen implementation seams

The root Gradle build will own a dedicated `ciMaven` file repository and the `:prepareCiMavenRepository` entry point. Proposed invocation inputs are `-PciMavenBase=<immutable-base-tree>` and `-PciMavenOutput=<disposable-candidate-tree>`, together with `--no-configuration-cache --no-configure-on-demand`. Paths must be distinct, outside the source checkout and `mavenLocal`; these names are planned interfaces, not existing tasks or properties.

The user's settled language preference is Deno + TypeScript for publication orchestration. An ordinary repository-local TypeScript helper running on Deno 2, proposed output `.github/publish-maven.ts` (not yet present), will own Git/source-ref orchestration and call that Gradle entry point. Use Deno's built-in filesystem/process APIs without third-party packages. This keeps Maven coordinates, payload checks and metadata ownership with Gradle and gives the workflow one locally exercisable transaction. The Spec excludes an external shared Deno publisher; it does not exclude a repository-local Deno helper. No shared publisher, manifest, receipt or alternative metadata generator is planned. Focused checks belong with their owning implementation item.

Source-ref guards run before Gradle. The helper pins the source SHA, reads an immutable destination base into a directory separate from the source checkout, and uses another directory for the candidate Maven tree. Temporary Git administrative files never become Maven content. Destination races fail rather than initiating automatic reconciliation. A later invocation starts afresh and rechecks `main`; no retry may bypass that check.

## Remaining evidence and limitations

Actual evaluated publications, generated file payloads, archive reproducibility, consumer resolution and Gradle-managed metadata/snapshot history remain to be demonstrated. The IDEA build and existing dynamic external dependencies may expose build failures during focused publication; such failures must be reported rather than hidden by version, dependency or toolchain policy changes.

Local Git remotes can demonstrate transaction behavior but cannot prove GitHub token policy, branch protection, hosted runner behavior or public repository consumption. These remain explicit limits even if the future local checks pass. No full project tests, Minecraft integration matrix, remote source synchronization, source-tag writes, live publication, central repository change or unrelated feature-plan edits are included.
