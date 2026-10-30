# Maven publication CI

Status: Ready for implementation planning. This specification records the accepted [Git-backed Maven publishing ADR](../adr/git-backed-maven-publishing.md) and the user's confirmed release, SNAPSHOT, and source-revision rules. The policy decisions are settled; CI implementation and publication verification remain unperformed. Documentation completion does not authorize or demonstrate CI implementation or publication.

## Boundary and triggers

The publication workflow must replace the obsolete [.github/workflows/publish.yml](../../.github/workflows/publish.yml) using the current local source baseline, without first synchronizing remote source. It must:

- Automatically run on `push` to `main` when a changed path matches `**/gradle.properties`, and expose `workflow_dispatch`.
- Have no automatic publication trigger for pull requests, other branches, or tags. Automatic and manual publication must both use `refs/heads/main`; a manual dispatch selecting any other branch or a tag must skip publication without changing the destination.
- Publish to the `maven` branch of the repository identified by `github.repository`, with Maven paths at the branch root, not under a `repository/` or `net/msrandom/` staging prefix.
- Use that repository's `GITHUB_TOKEN` with `contents: write` for the branch update. Publication must not create or move source tags or change source branches.
- Retain the existing HTTP publishing capability, but invoke no HTTP publication task in this CI path. An aggregate `publish` task that also reaches existing HTTP destinations does not satisfy this requirement.

The replacement must use a valid GitHub Actions job structure with `runs-on` and `steps`. The old file currently uses a sequence directly under `jobs.publish`, invokes `test publish`, and requests JDK 8. The [wrapper](../../gradle/wrapper/gradle-wrapper.properties) currently selects Gradle 9.4.0; the replacement must use a Gradle-compatible launcher JDK and satisfy the configured compilation toolchains separately. The [root build](../../build.gradle.kts) requests Java 11 for direct children; the two nested library builds below request Java 8. Java 8 compilation targets do not justify a Java 8 Gradle launcher.

## Publication set and output

The source of truth must be the evaluated `MavenPublication` objects in the root build and its included projects, not a hard-coded group prefix, project list, or only the modules whose properties changed. Every actual configured Maven publication must be included, with its configured coordinates, version, artifacts, and Gradle-generated metadata. Source versions must not be rewritten for CI.

The current [settings](../../settings.gradle.kts), [root configuration](../../build.gradle.kts), and module builds imply the following baseline. This is a static inventory, not a Gradle execution result or a fixed future allowlist.

| Project / build evidence | Configured publication shape |
| --- | --- |
| [minecraft-codev-core](../../minecraft-codev-core/build.gradle.kts) | `pluginMaven`, plugin ID `minecraft-codev`, and its marker |
| [minecraft-codev-decompiler](../../minecraft-codev-decompiler/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-decompiler` |
| [minecraft-codev-remapper](../../minecraft-codev-remapper/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-remapper` |
| [minecraft-codev-forge](../../minecraft-codev-forge/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-forge` |
| [minecraft-codev-fabric](../../minecraft-codev-fabric/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-fabric` |
| [minecraft-codev-includes](../../minecraft-codev-includes/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-includes` |
| [minecraft-codev-runs](../../minecraft-codev-runs/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-runs` |
| [minecraft-codev-access-widener](../../minecraft-codev-access-widener/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-access-widener` |
| [minecraft-codev-mixins](../../minecraft-codev-mixins/build.gradle.kts) | Plugin implementation and marker for `minecraft-codev-mixins` |
| [minecraft-codev-core:side-annotations](../../minecraft-codev-core/side-annotations/build.gradle.kts) | Explicit `maven` publication from the Java component |
| [minecraft-codev-forge:codev-forge-runtime](../../minecraft-codev-forge/codev-forge-runtime/build.gradle.kts) | Explicit `maven` publication from the Java component |
| [minecraft-codev-idea](../../minecraft-codev-idea/build.gradle.kts) | Explicit `idea` publication: `com.jetbrains.plugins:net.msrandom.minecraft-codev:1.0-SNAPSHOT` |

The normal implementation/library group is `net.msrandom`. Gradle plugin markers use `<plugin-id>:<plugin-id>.gradle.plugin:<version>` and refer to their implementation publication; they can be POM-only publications. For example, Fabric's marker belongs under `minecraft-codev-fabric/minecraft-codev-fabric.gradle.plugin/`, outside `net/msrandom`. IDEA belongs under `com/jetbrains/plugins/`. Copying only `net/msrandom` loses required publications. The legacy `minecraft-codev-core/client-annotations` directory is not included by current settings and does not establish an additional publication requirement.

Publication must use Gradle's existing Maven publishing machinery with a dedicated local file repository. That repository must cover nested publishing projects as well as direct children; configuring only the root's current `childProjects` loop is insufficient. The CI task selection must target only this local repository, without invoking HTTP or JetBrains Marketplace publication.

The output directory must be separate from the source tree contents being published and from the runner/developer's `mavenLocal`. Only its Maven repository tree may become branch content. The output must include every artifact attached to each actual publication, including configured source/Javadoc JARs, POMs, Gradle module metadata where generated, Maven metadata, and generated checksums. CI must not invent a JAR for a POM-only marker, add unconfigured artifacts, or collect unrelated cache artifacts.

## Repository initialization and metadata

Gradle must generate and update Maven metadata and checksum files through its file-repository publisher; CI must not introduce a parallel XML generator, shared Deno publisher, manifest, or receipt format. Publication must preserve previously published unrelated coordinates and versions and keep their metadata discoverable. In particular, copying fresh `maven-metadata.xml` over an existing artifact's version index without preserving its prior versions is insufficient.

The dedicated local repository must be seeded from the current `maven` branch tree before Gradle publishes into it, so Gradle's publisher sees existing Maven metadata. With no destination branch, the directory must start as an empty Maven tree. The existing-release comparison below must still distinguish newly generated payload from files inherited through seeding. Snapshot metadata and filenames must follow Gradle's Maven publisher rather than assumptions about a single fixed `-SNAPSHOT.jar` file.

## Existing versions and reruns

A release is a configured version that does not end in `-SNAPSHOT`. For each release coordinate/version, the complete version payload is the set of relative file paths and bytes that its evaluated publications produce under that Maven version directory. This includes every attached artifact, POM, Gradle module metadata where generated, signatures if produced, generated checksums, and any other generated version-local file. A POM-only marker has the corresponding POM-only payload and its generated sidecars; it does not require a JAR.

Comparison must use the complete newly generated payload and the complete existing version directory. Seeding must not let inherited files masquerade as newly generated files or hide removed artifacts. Equality requires the same file paths and byte-identical content: missing or extra files and changed descriptors, archives, signatures, or checksums are differences. A rebuild whose archive bytes differ is a conflict even when its source or logical contents appear equivalent. No release file may be silently excluded by extension or normalized to obtain equality.

The mutable repository index is outside this release payload boundary: the artifact-level `maven-metadata.xml` outside the version directory and that index's own generated checksum/signature sidecars may change through Gradle to reflect publication activity while preserving previous versions. This exception does not cover a release's POM, `.module`, artifact, sidecar, or any file inside its version directory. CI must not use a general `maven-metadata.xml`, XML, or checksum exclusion to ignore release differences.

- A release coordinate/version with no existing version directory may be added.
- An existing complete release with an equal payload must be skipped successfully, leaving its version files unchanged. This counts as satisfying that publication in a complete-set run.
- Any difference in an existing release version directory, including an incomplete existing payload, must fail the whole run before a branch update. The failure must identify the conflicting coordinate/version and require a version increase; CI must not replace or silently repair it.
- A version ending in `-SNAPSHOT`, including IDEA's `1.0-SNAPSHOT`, may be updated through Gradle's native Maven publisher. Previously published timestamped snapshot files must be retained, along with their existing sidecars; metadata and its sidecars may change to select the new snapshot. No snapshot cleanup, retention limit, or separate metadata generator is introduced.

These rules apply to the entire configured publication set, including implementation publications, plugin markers, and the nested libraries. A changed module does not authorize overwriting another module's existing release. CI must not rewrite source versions or impose an additional rule that every published version be numerically newer than all previous versions.

## Source freshness and branch update

The source revision used for a run must remain fixed throughout its build and branch update. Before any destination-branch write, CI must read the current remote `main` HEAD and compare it with that source revision. If they differ, the run must skip publication without changing `maven`; it must not rebuild from the new HEAD within the same run. An unchanged current `main` commit may be rerun, subject to the release and SNAPSHOT rules above. Failure to establish the current HEAD must fail without a destination write. Any retry of a destination update must repeat the freshness check.

This check establishes source freshness at the pre-publication check; it does not impose monotonically increasing version numbers or promise that `main` cannot advance after the check. A later current commit may introduce an unused lower release version, but it must still respect existing release immutability.

All required publications must either pass the existing-release equality check or complete local Gradle publication before a branch update. Empty output, missing required publications, build/publication failure, invalid metadata, a release conflict, or rejected branch writes must fail the run; a subset must not be reported as a successful publication. Source-ref and stale-source skips must be reported as skips, not successful publication.

A successful update must expose a consistent Maven tree in one branch commit. Concurrent runs must not discard one another's repository changes: a stale destination base must be detected and serialized, reconciled, or rejected, rather than force-pushed over newer content. Reconciliation must reapply the payload and metadata requirements against the newer destination tree as well as repeat the source freshness check. An interrupted or failed local preparation must leave the remote branch unchanged; an ambiguous push result must not be reported as confirmed success. Existing files outside the intended publication changes, including historical snapshot files, must not be deleted as a side effect of staging cleanup. Success means the intended tree is confirmed on the destination branch. If the rules leave no tree change, the run must succeed without creating a destination commit; current-commit reruns may still produce a new Gradle-managed snapshot.

## Acceptance conditions (not executed)

1. Inspect the replacement workflow for valid job structure, the exact automatic path/branch filter, manual dispatch restricted to `refs/heads/main`, same-repository token permission, compatible launcher/toolchains, and absence of HTTP publication and source-tag writes. Exercise manual selection of another branch and of a tag; both must skip without changing `maven`.
2. Run the actual Gradle publication tasks into the dedicated local repository and compare their output with the evaluated Maven publications. Check the nested libraries, a marker outside `net/msrandom` (including its implementation dependency), and the IDEA publication. Resolve a representative plugin through its marker and the IDEA Maven coordinate from that repository; do not substitute Marketplace publication.
3. In one bounded local repository exercise, seed an existing version and publish a new version using the Gradle file publisher; verify both remain discoverable, their descriptors/artifacts and generated metadata/checksums are consistent, and unrelated files survive. Rerun an identical complete release payload and verify its version files are unchanged. Exercise changed archive bytes, a changed POM or `.module`, a changed version-local checksum, and missing/extra version files (including a stale file inherited from seeding); each must cause a conflict requiring a version increase and leave the remote tree unchanged. A valid artifact-level index update for a new version must not cause an existing equal release payload to conflict. Update IDEA's `1.0-SNAPSHOT` at least twice with Gradle; verify the latest metadata resolves the new snapshot while the older timestamped files and their sidecars remain. A release conflict in a run containing other new releases or snapshots must prevent the entire branch update.
4. Check branch-update behavior for initial creation from an empty tree, an existing branch seeded into the local repository, publication failure before push, and a stale destination base. Confirm the repository layout starts at the branch root and failure never publishes a partial tree or loses a newer update. Exercise source freshness for both automatic and manual `main` runs: an outdated source revision must skip without a destination write, a current revision must be eligible for rerun, and an unreadable `main` HEAD must fail without writing. A retried update must recheck source freshness and, if reconciled, validate against the newer destination tree. Verify an eligible run with no resulting tree changes succeeds without a new commit. An unused lower release version on the current `main` must not be rejected solely for being lower. A later authorized live publication requires separate evidence; this document records none.

These checks target the publication path only; no additional platform/JDK validation matrix or full Minecraft integration suite is required by this specification. This documentation change does not modify CI, Gradle, production sources, or unrelated Mixin/include work; the ADR follow-up is synchronized with the confirmed policies above.
