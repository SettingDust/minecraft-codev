# Include Identity

This is the accepted local target contract for `include(MinecraftTarget)` and its necessary Codev identity consumption. **Must**, **must not**, and **may** express requirements, not implemented or verified behavior. The user authorized specification and implementation preparation, not production changes or publication.

## Boundary

Cloche owns the public dependency entry, request provenance, resolution-graph separation and embedding-task wiring; Codev `minecraft-codev-includes` owns resolved embedding identity, shared by Forge JarJar and Fabric JarInJar. This contract reuses existing target capabilities and consumer attributes; it introduces no identity system or mod DSL. A target capability is the identity selected by this overload, not a promise of canonical modId equality across different platform targets.

The accepted [include-target-resolution ADR][resolution-decision] authorizes the direction of isolating only `include(MinecraftTarget)` requests and gathering their results. It supersedes this Spec's former no-new-ADR assumption for resolution structure; the local product scope still needs no new PRD. The [Mixin Spec](mixin-preapplication.md) and [Mixin ADR](../adr/mixin-operation-isolation.md) exclude includes identity. The broader [difference proposal](../proposals/codev-difference-rework.md) remains Proposed; this Spec adopts only the local contract below, not its other candidates or hypothetical cross-platform identity policy. The [embedding context](../../minecraft-codev-includes/CONTEXT.md) supplies vocabulary, not authority.

## Cloche request contract

[ClocheDependencyHandler][request] must expose this member while retaining its `include: DependencyCollector` property:

```kotlin
fun include(target: MinecraftTarget): Unit
```

Existing string, `Dependency` and `Provider` include syntax must remain usable. `CommonTarget` is not an input to this overload; no `includeTarget` entry is introduced. For existing producer and consumer targets, `consumer.dependencies { include(a); include(b) }` must express two includes without a new DSL.

The overload must internally obtain the supplied target's owning project and create the project dependency through that project's existing dependency API, then add it to the existing include collector. It must not call the consumer's no-argument `project()` or interpret `target.name` as a project path. Public `MinecraftTarget` need not expose a new project property.

The dependency must explicitly request the target's existing **base capability**, as complete `group:name`, with coordinates read lazily according to the producer's existing rules:

- `group` is the owning project's group.
- For a nonempty target name, `name` is `projectName-targetSuffix`, where every `:` in the target name becomes `-`.
- For the empty-name single target, `name` is the root `projectName`.

These rules must agree with [target naming][target] and [outgoing capability production][variants]; they must not freeze early group values or manufacture loader, modId or compilation suffix identities. The existing [internal target][internal-target] provides the project connection.

### Request provenance and repeated targets

A contribution made by the overload must remain distinguishable from an ordinary collector contribution, including an ordinary `ProjectDependency` that happens to compare equal or request the same capability. Dependency class, project path, capability text or Provider wrapping alone must not classify a request as originating from the overload. Observing `include.dependencies` on demand must still expose the generated producer-project dependency and its complete capability request. This preserves collector observability, not a new guarantee of one Set entry per call or of DSL call order. Ordinary collector dependencies and dependency constraints must retain their existing meaning.

Within one receiving compilation, repeated overload calls may share one isolated graph only when they denote the same original producer-owned target and the same lazily obtained complete base identity. Observable grouping evidence must distinguish the producer's build/project identity, the original target name before suffix normalization, and the resulting `group:name`. Repeated `include(a)` must not produce duplicate embeddings. Different targets must not be grouped merely because their project, normalized suffix, coordinates or file names coincide; A/B remain separate even within one producer. This defines grouping behavior, not a new public key/API or configuration-naming scheme.

Creating a request or arranging its group must not resolve it, query artifact files, or freeze producer coordinates at the overload call. The generated dependency, group key and requested capability must agree when their Providers are demanded after producer configuration. Late group/version configuration must continue to affect the request and real outgoing target capability according to the existing producer rules.

## Isolated resolution and production wiring

For each receiving compilation, Cloche must route only contributions from `include(MinecraftTarget)` into actual isolated resolution graphs, one per distinct target group above. The ordinary string/Dependency/Provider contributions must continue through the original ordinary include graph. In particular, ordinary project dependencies must not all be classified as target mods or split into new graphs. Only overload-origin contributions are removed from the ordinary resolution input; their visibility in the collector must remain. A manually expressed ordinary request retains ordinary-graph conflict and failure behavior.

The [current collector bridge][internal-target] adds collected dependencies and constraints lazily to the [include bucket][selection], which currently feeds one `includeFiles` graph. The new production routing must prevent overload-origin A/B from re-entering that graph through the bucket or an inherited configuration. Keeping them in a failing old graph while adding extra successful graphs is insufficient. An ArtifactView of that same graph or fixture-only alternate wiring is insufficient.

Every isolated graph must retain the ordinary consumer's actual platform/loader, Minecraft-version, distribution, legacy side and data attribute values and Provider timing, plus Category.LIBRARY, Usage.JAVA_RUNTIME, LibraryElements.JAR and non-transitive semantics. There must be no attribute override to force a match, dedicated include-only producer variant, or change to the producer's existing capability set: **the common root capability remains**. Each request must still use `requireCapability` for its full base identity. Missing or incompatible capabilities and upstream unresolved dependencies must fail normally, without lenient omission, selecting away A/B or fallback to another target.

Existing separate-client compilations can publish a `server` or other compilation suffix instead of the base capability; the overload does not promise that every server/client compilation is selectable and must not invent or add capabilities to make it so. Different platform targets must not automatically be merged into one modId.

The ordinary graph and every isolated graph must feed the **same actual `TargetCompilation.includeJarTask`** through the shared embedding boundary. Cloche must preserve lazy resolution and the resolved artifacts' producer-task/build dependencies through grouping, extraction and task inputs; running only the embedding task must arrange all required producer artifacts. Reading raw file paths during configuration or discovering producer dependencies only inside the task action does not satisfy this obligation. No particular new configuration lifecycle or shared public method signature is selected here.

## Codev identity consumption

### Association before identity extraction

For each included artifact, Codev must aggregate dependency requests by its **resolved variant across all contributing graphs**, including requests reached through the existing resolution traversal. A later request must not overwrite earlier identity requests, and separate variants of one project must not be conflated. Repeated sources for the same resolved variant/artifact must yield one embedding after aggregation; different real target variants and different artifacts must remain distinct.

Before any graph is reduced to final `IncludedJarInfo` values, the gathering boundary must retain enough evidence to associate its selected graph variants, resolved artifacts and original requests. This includes resolved component owner (including build/project identity for projects), the complete variant capability set including versions, graph attributes and their values, resolved artifact identity/file, original selectors and overload/ordinary provenance. Per-graph traversal order must also survive for the version rule below. Requested identities must come from requests, never be reconstructed from artifact capabilities or display names.

Preserve [the current extractor's][identity] exact variant lookup and unique artifact-projection association: a projection must have the same component owner and complete capability set, with every graph attribute matching its artifact-side value. Extra artifact attributes such as `artifactType` do not by themselves make a different graph variant. Across graphs, result-object instance identity is insufficient, and complete graph attribute sets must be compared as such, not by applying the projection subset rule between two graph variants. These checks must establish an unambiguous same-variant association; they do not authorize merging two distinct targets or variants that happen to share those fields. A complete request that cannot be uniquely associated must retain the existing diagnostic-failure obligation, not disappear into default inference.

Gather all original selectors for the associated variant before selecting its identity, then deduplicate only repeated resolved artifacts of that variant. File name, project path, selected embedding coordinates or list position alone is not a deduplication key. Resolving each graph independently to `IncludedJarInfo` and calling `includedJarInfo.addAll(...)` repeatedly cannot establish this contract: those values no longer retain the variant and request evidence needed for mixed-source identity decisions. The existing [IncludesJar][embedding] single-configuration method is an implementation observation, not proof of a sufficient cross-graph API. Any necessary shared extraction/gathering change belongs to Codev and must be disclosed in the recovery scope; this Spec does not promise that Codev stays unchanged.

From that variant's requests, Codev must collect explicit complete capability coordinates and deduplicate by exact `(group, name)`. A feature-only `requireFeature` selector is not a complete coordinate and must not be guessed into one. Against the artifact variant's capabilities:

| Complete requested identities | Required outcome |
| --- | --- |
| One distinct identity, exactly matching both group and name | Select that capability before default identity inference. Repeated requests for it are not ambiguity. |
| An explicit identity without an exact match | Fail identity extraction; do not silently fall back or skip the affected artifact as successful. |
| Multiple distinct identities | Fail as ambiguous; do not select the first or last, even if all are present. |
| None | Preserve the existing project-name/module-coordinate rules and fallback below. |

Explicit-request identity selection must be independent of capability-list order and duplicate-request order; the no-complete-request fallback retains its existing ordering. Failures must identify the affected artifact/variant and requested identities sufficiently to diagnose mismatch or ambiguity. Upstream unresolved dependency failures must continue to propagate.

With no complete identity request, preserve [current inference][identity]: for a module, prefer the capability matching its component group, module and version; for a project, prefer a capability whose name equals the project name; otherwise retain the existing first-capability fallback. With no usable capability, retain the existing warning-and-skip behavior. Thus ordinary includes without a complete capability request keep their default identity; existing manual complete capability requests participate in the explicit priority above.

### Versions and effective request order

The selected capability supplies `group` and `moduleName`. Preserve artifact-version fallback: selected capability version, then module component version, then the effective last selector's version if that selector is a module selector, then `0.0.0`. Preserve version-range selection separately: take the effective last selector; if it is a module selector, use nonempty strict, then required, then preferred version; if none is nonempty or the selector is not a module selector, use `[$version,)`. Within a graph, an earlier module selector must not replace a later project selector merely because it contains a version constraint. Identity order independence does not introduce a new order-independent version-constraint merge policy or a new conflict-selection policy.

Within a single graph, the effective order is the [existing extractor's][identity] actual traversal: iterate `rootComponent.dependencies`; append each edge's requested selector to its resolved variant; recursively visit `selected.getDependenciesForVariant(resolvedVariant)` before continuing with the next edge. The last appended selector for that variant supplies the version rule. The [collector bridge][internal-target] uses `addAllLater(collector.dependencies)` and `addAllLater(collector.dependencyConstraints)`; it supplies no recorded total call order across DSL calls, Provider realization, ordinary resolution and future isolated graphs. Neither that bridge nor artifact iteration order establishes a pre-existing global selector order.

Repeated overload requests contain project selectors. Repeated/mixed sources for the same variant whose selectors are all project selectors must therefore retain the selected capability's artifact-version fallback and default range. Other variants confined to one graph must retain that graph's actual last-selector behavior. These cases need no invented ordering between graphs. A mixed-source group for which every candidate last selector yields the same version pair must retain that common pair.

For repeated sources associated with the same resolved variant/artifact, **ordinary-source versions take priority**: if the ordinary graph contributes any requests to that group, Codev must use that graph's effective last selector under its existing traversal for the selector-dependent steps of both `artifactVersion` and `versionRange`. Apply the fallback chain above with the capability selected from all aggregated identity requests; ordinary-source priority does not substitute an ordinary default identity. A target project's default range must not replace a nonempty strict, required or preferred range from that effective ordinary module selector. If the effective ordinary selector is a project selector, retain its default-range behavior rather than reviving an earlier ordinary module constraint. When no ordinary source contributes to that group, retain the target requests' existing artifact-version fallback and default-range rule.

Version precedence must be applied only after aggregating all contributing identity requests and establishing the same-variant/artifact association above. All sources must remain available for unique exact identity selection, ambiguity/nonmatch failure and artifact deduplication; different real targets must remain distinct. This accepted source priority settles the former mixed module/project precedence gap. It must not create a global cross-graph declaration order, merge or intersect version constraints, introduce conflict selection or arbitrary choice, reject the mixture merely for being mixed, or silently discard a source. Ordinary-graph resolution and failure behavior remain unchanged.

## Metadata compatibility

[Forge JarJar][jarjar] must serialize the selected identity into `identifier.group` and `identifier.artifact`, retaining current version fields, the `jars` array and nested-JAR `path` rules. This change must not redesign arrays or paths.

Shared identity extraction must also preserve [Fabric JarInJar][fabric] compatibility: ordinary libraries without a complete request retain the existing default identity and generated mod metadata derivation; explicit unique requests feed the same existing derivation with the selected coordinates. Existing `fabric.mod.json` must remain untouched by that generation path. This is not a new canonical modId algorithm.

## Success and focused acceptance

Success requires both the Cloche overload's correct producer-project/base-capability request and Codev's consumption of that request in delivered metadata. Adding only the overload or changing only the default capability predicate is insufficient. The following are required acceptance checks for subsequent implementation, **not results executed by this document**:

1. Include compatible independent A/B targets from the **same real owning producer project**, distinct from the consumer project. Observe the original target/provenance, late full base requests, actual isolated selected runtime variants with the common root still present, exclusion of those contributions from the ordinary graph, and both distinct Forge metadata identities and corresponding payloads in the same real embedding task's final Jar. Cover `:`-to-`-` naming, empty-name root identity, late producer coordinate configuration, repeated `include(a)` grouping and producer-task dependencies when only the embedding task is requested. An incompatible variant and a missing base capability must fail normally rather than bypass consumer attributes or manufacture capabilities. Retain non-transitive behavior.
2. Verify existing string/Dependency/Provider calls and ordinary project/module includes retain their ordinary graph, default identities and version-range behavior, including Fabric's generated ordinary-library metadata and preservation of existing `fabric.mod.json`. Retain JarJar array/path structure. Ordinary `ProjectDependency` or Provider wrapping must not by itself trigger isolation. Existing ordinary-only version checks retain their actual traversal order.
3. At the shared extraction/gathering boundary, verify same-variant duplicate requests deduplicate **within and across graphs**, explicit-request identity is unchanged when duplicate requests/capability order changes, same-name/different-group does not match, explicit nonmatches and distinct multiple identities fail, and feature-only/no-complete-request inputs retain default behavior. In particular, a target request plus an ordinary request resolving to the same variant/artifact must retain both sources for identity selection, give the unique explicit identity priority and embed once; two complete identities for that same variant must fail even when they came from different graphs. Verify artifact-projection association and keep distinct A/B variants separate. Keep version-range selection checks separate from identity order independence: cover project-selector duplicate mixtures and preserve single-graph last-selector behavior. For an ordinary module/target project mixture associated with the same variant/artifact, observe that the ordinary graph's effective last selector supplies its existing strict-then-required-then-preferred range and selector-dependent artifact-version fallback, without replacement by the target default range, while the target's unique explicit identity is still selected and the artifact embedded once. Retain the default range when the effective ordinary selector is a project selector, and the existing target version rules when no ordinary source contributes. These are extensions of the existing duplicate/mixed-request obligations, not a new framework or version matrix.

End-to-end acceptance must actually load the modified local Codev includes implementation. Cloche currently pins `minecraft-codev-includes:0.6.5` in [its build][cloche-build]; a passing run using that unchanged published implementation is not evidence for this contract. The concrete local integration arrangement belongs to later planning; this Spec requires neither publication nor a new test framework.

### Existing evidence and applicability

The [I01 report][i01] records 14 passing checks for the single-graph identity contract, including a real smoke. It does not verify new cross-graph association, mixed-source gathering or their shared API changes. Reuse still-valid evidence for unchanged behavior; add focused evidence for the affected boundary rather than calling the old 14 checks proof of new code.

The [I02 report][i02] remains **partial: 5 checks, 1 required A/B failure and 4 passes**. The failure occurs in the original `includeFiles` graph before identity extraction/JarJar; the four passes cover single named/root plus ordinary calls, attribute rejection, missing-base rejection and Fabric compatibility. There is no successful A/B metadata/payload evidence. The existing [Plan][plan] and [Waves][waves] retain their historical single-graph preparation scope; they have not been revised or released by this Spec. `ITI-I01` remains completed, `ITI-I02` remains partial and `ITI-W01-G` remains unmet. The former mixed-source version decision gap is closed by the accepted ordinary-source priority above; implementation and runtime acceptance of that rule remain unverified.

Document completion does not establish implementation, runtime acceptance, a ready recovery arrangement or a ready Plan. Actual recovery changes still require the previously stated scope disclosure and confirmation. Work/Plan/Waves, production/tests/configuration/dependency changes, G2/G3 work, user configuration, Gradle user home, proxy configuration, Git commits and publication are outside this document's delivery scope. Build-report links record existing evidence and may disappear when build outputs are cleaned.

[resolution-decision]: ../adr/include-target-resolution.md
[request]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/api/target/compilation/ClocheDependencyHandler.kt
[embedding]: ../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt
[plan]: ../works/include-target-identity/plan.md
[waves]: ../works/include-target-identity/waves.md
[i01]: ../../minecraft-codev-includes/build/reports/test/identity-evidence.md
[i02]: ../../../cloche/build/reports/test/include-identity/identity-evidence.md
[target]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/api/target/ClocheTarget.kt
[variants]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/CompilationVariantCreator.kt
[internal-target]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/MinecraftTargetInternal.kt
[selection]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/TargetCompilation.kt
[identity]: ../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt
[jarjar]: ../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt
[fabric]: ../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt
[cloche-build]: ../../../cloche/build.gradle.kts
