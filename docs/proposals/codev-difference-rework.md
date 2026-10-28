# Codev Difference Rework

**Status: Proposed — non-authoritative, unaccepted.** Created 2026-10-04. This proposal identifies candidate behavior and decisions for review. It does not accept a baseline, authorize implementation or Git operations, or define an executable Plan/Waves graph.

Recommend **current main + G1 Mixin, G2 access correctness and G3 cache correctness**. Historical branch restoration would also import incomplete behavior, weak tests and incompatible service parameters. G4 remapper reuse and G5 include identity need separate decisions; interfaces, enums, performance architecture and legacy Minecraft support remain alternatives.

## Evidence and baseline

The completed [scope report][R] is the source of the findings below; its [provenance inventory][E] records exact objects, paths, branch tips, and equal blobs. Finding IDs D01–D22 and source IDs S1–S19 retain their report meanings. Facts below come from those sources; recommendations and hypothetical examples are candidate judgments, not observed runtime results.

| Object | Fixed identity and significance |
| --- | --- |
| B: upstream snapshot | `1e505d08364bd8865733e7291f513a652897794f`; locally established snapshot, **not verified latest upstream** |
| H: current `main` | `30d1d3d22267477db3275cb849e8692ada0f74de`; B plus four DDD documents, with the same functional source |
| F: historical fork | `45b8a58d13c30b017060a99f8a7e1b647ad16902`; 85 fork-only commits and 48 changed paths relative to B, not 48 features |
| Preserved backup | `backup/pre-terrarium-reset-20260927-042051-02ac3b17` points to F; existing original backup and remote-tracking refs remain evidence |

Recommend H because it preserves the independent documentation and needs no reset. B alone offers no code benefit and would need a separate document-retention decision. Updating upstream could reduce duplicated fixes but requires a newly authorized comparison against an unknown newer tree. Restoring F or merging whole historical feature branches would import unrelated changes and the defects below. These alternatives remain unselected. [R, sections 1–2, 7; S1–S4]

Preserve and reuse the [context map](../../CONTEXT-MAP.md), [game artifacts and naming](../../minecraft-codev-core/CONTEXT.md), [distribution embedding](../../minecraft-codev-includes/CONTEXT.md), and [development launches](../../minecraft-codev-runs/CONTEXT.md). They supply language and ownership boundaries, not product or technical authority. The shared [upstream difference inventory](../../../upstream-differences.md) has stale claims that current main is F, reset is pending, and only origin is configured; this proposal does not update it. [R, sections 1–2, 8; S17]

## Candidate scope

**Retained baseline, not new feature work:** existing build-time Mixin tasks; `.accesswidener`/`.ct` reading, Fabric AW remapping and Forge AT generation; nullable field descriptors and typed/untyped matching; inherited Fabric AW mapping; Forge manifest/directory, MCP patch, patched-Minecraft and lazy userdev handling; existing nested-JAR output/path handling. Their source retention is evidenced, but their runtime correctness has not been newly demonstrated. Keep them as regression targets rather than replaying old commits. Forge inherited AT behavior still needs its own example. [R, D07, D10–D11, D17; S4, S7, S12]

**Core candidates:** G1 owns the Mixin execution→record→cleanup/mapping chain in mixins, with core serialization and Forge metadata changes only if needed. G2 owns access correctness/model preservation in access-widener, with Fabric/Forge adapters only where behavior changes. G3 owns cache identity/concurrency in core/remapper. **Separate optional candidates:** G4 remapper reuse in remapper; G5 embedded identity/traversal in includes. Shared callers are a regression surface, not automatic module changes. D01–D19 and their evidence map below.

**Excluded from the recommended core:** worker architecture, IDEA/run formatting, unchanged decompiler/fabric/runs version bumps, historical publication workflows, bulk branch merges, and legacy-forge placeholder restoration. Publishing remains suspended. A `.gitkeep` does not implement legacy Forge. Native extraction for old clients is a separate support-matrix choice, not an old-fork difference to restore automatically. [R, D20–D22, section 4; S14–S15, S18–S19]

## Four scope decisions ready for review

All choices are pending. The recommended column is a review candidate, not recorded acceptance.

| Decision | Recommended choice and reason | Material alternatives and consequences |
| --- | --- | --- |
| **1. Baseline and core** | H plus G1, G2 access correctness/model preservation, and G3. This keeps DDD and concentrates on evidenced failure boundaries | B needs explicit DDD retention; newer upstream needs new evidence; whole F imports known risks. Removing a core group leaves its reported correctness gap outside the rework |
| **2. Additional class-tweaker capability** | Keep additional interfaces/enums outside the core until a concrete consuming use case is named; existing access-model preservation remains in G2 | Add declaration storage/remapping only, with no claim of bytecode injection; or add real interface emission, including generic signatures. Enum extension is an independent opt-in with a full model/emission/runtime contract. Neither complete feature can be claimed as restored legacy behavior |
| **3. Remapper reuse (G4)** | Defer, retaining create/use/finish per operation while fixing G3. This avoids a new lifecycle without performance evidence | Internal fingerprint-based reuse or an optional validated ID can preserve current consumer APIs. Restoring mandatory `remapperId`/service parameters requires separate Cloche ownership and change authorization; Codev-only acceptance cannot authorize those edits |
| **4. Include identity (G5)** | Defer the identity rewrite until a concrete feature/multi-capability example establishes the intended coordinates; retain the current rule provisionally | If selected, recommend default capability for ordinary projects and the explicitly selected feature capability for feature artifacts, with ambiguity made explicit. A universal default rule loses feature identity; any non-default rule can select the wrong feature; caller-supplied coordinates introduce a new contract |

Initial Codev SemVer is a later module decision: `0.1.0` is recommended but unaccepted; another explicit start remains possible. The established rule is independent fork SemVer plus `+terrarium.<true upstream module version>`, only for changed modules. H's mixins example is `0.1.0+terrarium.0.6.0`. No versions change here. [R, section 5; S15, S19]

## Later module choices and proposed behavior

These choices refine an accepted scope; they do not all require an immediate user decision.

**G1: execution, records, cleanup and mappings.** Recommend fresh state per operation, coherent task-classpath class/resource loading and resource closure after success/failure. A per-operation classloader follows the smallest historical direction; process/worker isolation remains optional if demonstrated conflicts require it. Shared services must not retain operation configuration. [R, D01–D02; S5]

Record actual application by configuration and exact mixin identity. Parse configuration structure, remove only recorded `mixins`/`client`/`server` entries, and preserve metadata, unapplied runtime entries and loader references. Remove configuration/references only when no runtime entries remain under the selected policy. Compact JSON, substrings and partial application need consistent results. Whole-config removal is an alternative with explicit runtime-behavior loss; the old core serializer is not required. [R, D03–D04; S5]

Map by source namespace, owner, name and descriptor, including descriptor conversion, so other owners and overloads cannot collide. Decide pass-through versus failure for missing/null mappings. Forge blank MixinConfigs filtering belongs here. [R, D05, D18; S5, S12]

| G1 policy | Recommendation and reason | Alternatives and consequence |
| --- | --- | --- |
| Refmaps | Explicit mapping/namespace inputs and collision-safe remapping of required references | Declared target-namespace pass-through or reject refmap-dependent inputs; guessing risks corruption |
| MixinExtras | Opt in for a concrete consuming example and align compatibility | Bundling broadens testing/support; exclusion leaves Extras inputs unsupported; F's dependency alone proves no guarantee |
| Fabric Loader compatibility | Tested Loader range; constrain or reject unhandled predicates | Full range/array interpretation broadens scope; explicit caller compatibility avoids inference. F's minimum-version heuristic is insufficient |

**G2: access models versus new bytecode features.** Recommend keeping public visibility when AW `extendable` removes final, preserving explicit AT `PUBLIC`/`PROTECTED`/`PRIVATE` and final `ADD`/`REMOVE`/`NONE`, and defining merge and JSON round-trip behavior without translating all AT semantics into AW events. Nullable field descriptors must remain safe. F's conversion only represented some access changes, and its final visitor did not apply saved interface declarations; enum evidence was limited to event forwarding. Declaration storage, actual interfaces/signatures, and actual enum emission therefore have distinct acceptance targets. A library/visitor upgrade is an implementation alternative only after these contracts are selected. [R, D08–D10, retention risks, section 4; S6–S8, S18]

**G3: cache identity and concurrency.** Recommend separating input roles and retaining source→target direction, mapping/input content and classpath identity, with an explicit classpath-order policy where resolution order matters. Cover transform outer/nested JARs and task entry points. Put cache existence checks inside mutual exclusion, address same-JVM file-lock fallback, and release locks after failures. Widening a generic key to String/Path or switching sets does not by itself solve role/order loss. The misleading mapping-resolution success log can be corrected within this group; unused imports are not a separate outcome. [R, D12–D13, D16; S8–S9]

**G4: compatible reuse alternatives.** Codev remapper would own service identity, lifecycle, input retention and misuse behavior; Cloche owns its task/transform registrations and selection of mapping inputs. Compatible candidates are (a) derive an internal fingerprint from mappings, directional namespaces, classpath/options and isolate operation inputs, or (b) offer an optional ID with a safe default and reject inconsistent reuse. Both need bounded retained input state, error cleanup, finish/close and cross-project isolation. The old mandatory-ID API is a distinct breaking alternative that needs a jointly owned consumer contract. This proposal changes no Cloche consumer and assumes no measured speedup. [R, D14–D15; S10, S16]

**G5: concrete identity examples.** The following are hypothetical acceptance examples, not observed fixes. For project `org.example:widget:1.2.0`, assume capabilities `widget`, `widget-fabric`, and `widget-forge`:

| Selected artifact | Candidate coordinates if G5 is accepted | Policy implication |
| --- | --- | --- |
| Ordinary widget project JAR | `org.example:widget:1.2.0` | Default capability describes ordinary identity |
| Explicitly selected Fabric feature JAR | `org.example:widget-fabric:1.2.0` | Use the selected feature, not whichever non-default capability appears first |
| Variant with both feature capabilities and no identity choice | Explicit selection/override or an ambiguity failure | Capability-list ordering does not establish the intended identity |

Validate these intentions against a real Cloche resolution example and Fabric JarInJar/Forge JarJar output before choosing the rule. If G5 is accepted, cycles and diamonds need finite traversal/deduplication so identity extraction can complete. Caller-provided identity remains an alternative when Gradle selection cannot provide an unambiguous identity. No `!=` patch has been accepted. [R, D19, section 4; S13]

**Support boundary.** Recommend no automatic legacy Minecraft expansion. Including old client native extraction would add the reported ExtractNatives behavior to the acceptance surface and potentially runs changes. Separately, settings declares legacy-forge without a directory: removing a stale declaration or intentionally retaining an empty project are configuration alternatives requiring a rationale before build validation; neither is legacy loader implementation. Use Codev's own wrapper/toolchains: reported wrapper 9.4.0, ordinary module Java 11, Java 8 side/runtime subprojects and fixture-specific Java 8/17/21. Available local JDKs, dependency resolution and effective CI remain unverified; JVM reconstruction settings do not establish Codev settings. [R, D21, sections 4–5; S15, S18]

## Complete historical finding disposition

This compact map accounts for all 22 findings. Detailed paths, history and source support remain in [R] section 3 and [E]; the proposal does not repeat the broad investigation.

| ID | Finding | Proposed disposition / evidence |
| --- | --- | --- |
| D01 | Mixin execution isolation | G1 core candidate; architecture pending — S5 |
| D02 | Task-classpath plugin/config loading | G1 core candidate, loader closure/conflicts included — S5 |
| D03 | Actual applied records and serializer | G1 record→cleanup contract; serializer shape pending — S5 |
| D04 | Strip only applied mixins | G1 structured cleanup; retain remaining runtime entries — S5 |
| D05 | Mixin mappings/refmaps/null names | G1 collision-safe mapping; refmap policy pending — S5 |
| D06 | Loader compatibility, MixinExtras, logging/dependencies | G1 policy alternatives; no automatic dependency restoration — S5 |
| D07 | `.ct`/AW reading, Fabric remap, Forge AT generation | Already retained baseline; protect it — S6, S12 |
| D08 | Interface model/library upgrade | Optional storage versus actual interfaces; legacy task lacked emission — S6–S7 |
| D09 | Enum-extension forwarding | Unproven complete behavior; optional new capability — S6 |
| D10 | Null-descriptor fallback/tests/cache version | Retained behavior; G2 regression intent, correct weak assertions — S7, S11 |
| D11 | Inherited AW remap | Retained Fabric behavior; Forge inheritance remains a validation gap — S12 |
| D12 | Remap classpath/namespace cache inputs | G3 core candidate across outer/nested/task entries — S8–S9 |
| D13 | Generic key types/sets and shared locking | G3 identity/concurrency; do not copy widening as the fix — S8, S11 |
| D14 | MappingService/TinyRemapper reuse | G4 optional architecture, lifecycle and performance unproven — S10 |
| D15 | Service/task/transform public wiring | G4 compatibility/Codev–Cloche ownership; no consumer edit authorized — S10, S16 |
| D16 | Mapping-resolution misleading log/import | Small G3 diagnostic correction; import-only change excluded — S9 |
| D17 | Forge/MCP/userdev fixes | Retained or superseded baseline, not reimplementation — S12 |
| D18 | Forge blank MixinConfigs | Small G1 input correction — S12 |
| D19 | Includes capability predicate inversion | G5 separate identity decision; unproven `!=` fix — S13 |
| D20 | includes imports/sets, runs whitespace, IDEA | Excluded from functional scope — S13 |
| D21 | Historical workers/legacy-forge placeholder | Worker expansion excluded; legacy support optional, settings risk open — S14–S15 |
| D22 | Docs, versions, launcher, workflows, ignore | Reuse evidence/DDD; changed modules only; launcher if needed for validation; publishing skip — S3, S11, S15 |

## Candidate validation, not executed checks

| Accepted candidate | Smallest meaningful demonstration to design later |
| --- | --- |
| G1 | Same-JVM operations, second without configuration, and failure/retry; task-only plugin/conflicting dependencies; actual records, compact/partial/substring cleanup and retained references; owner/overload collisions; selected refmap/Extras/Loader policies |
| G2 | Public-final cross-package access/extension; explicit AT visibility/final and JSON round-trip; null/typed/untyped descriptors asserting actual PUBLIC bits. Optional declarations need round-trip; interfaces need emitted interfaces/signatures; enums need their selected full contract |
| G3 | Same input/mappings/**same output basename**, changed classpath/directional namespaces: hot=cold for outer/nested/task entries. Same-key threads/processes generate once without overlap and recover after failure; representative shared callers remain correct |
| G4, only if selected | Compatible existing calls, rejected identity misuse, isolated inputs/projects and finish after failure; timings/memory before claiming benefit |
| G5, only if selected | Real default/feature/ambiguous cases and loader metadata; finite A↔B/diamond traversal with stable coordinates |
| Retained/support boundary | Forge/AW/nested-JAR regression examples; native ZIP output only for selected old-client support; chosen legacy-forge configuration and available toolchains |

Do not treat old tests as adequate acceptance evidence: historical cache tests varied output basenames, and null-descriptor tests contained incorrect visibility assertions. Historical review observations have missing original temporary logs; they are reported evidence, not newly reproduced failures. No Gradle, build, runtime, unit, integration or performance tests ran in preparing this proposal. [R, sections 3–5, 10; S11, S18]

## Pending authority and ownership

The completed report found no Codev PRD, ADR, Spec, Work or Plan/Waves in its inspected current/historical Markdown and shared-document scope. That bounded negative evidence does not establish absence of external authority. Lack of coverage blocks later implementation admission, not this Proposed artifact. [R, sections 8, 10; S14, S17]

| Family | Pending coverage and proposed owner | Candidate location / disposition |
| --- | --- | --- |
| PRD | Codev fork product owner/user: supported users, Minecraft/Loader matrix, selected G1–G5 capabilities, compatibility, success criteria and initial SemVer | `docs/prd/codev-difference-rework.md` if coverage is required after scope acceptance; none authored |
| ADR | Owning Codev modules: Mixin isolation; optional service identity/lifecycle and includes policy. Codev remapper plus Cloche consumer owner jointly settle any changed cross-repository contract; specific accountable owners remain unconfirmed | `docs/adr/` only for accepted decisions; no accepted decisions or records created |
| Spec | mixins: operation/records/cleanup/mappings; access-widener: AW/AT/JSON/null-field and selected interfaces/enums; core/remapper: cache roles/order/locks; optional service/includes failure and identity contracts | `docs/spec/` by actual boundary; pending, none authored. This follows documentation-structure; the report's provisional `docs/specs/` suggestion is not an existing convention |
| DDD | Existing context owners for game artifacts/naming, embedding and launches; cross-repository contracts remain unresolved | Reuse all four existing documents unchanged |
| Publication | Explicit user exclusion | Skip; no release authority, workflow or publishing work |

A per-feature code-then-docs delivery pattern with signed merges may be considered after authority and scope are accepted, but the JVM pattern supplies no Codev Git authorization. This proposal creates no Work, Plan, Waves or Tasks and prescribes no branch/merge execution.

## Provenance and limits

| Source / locator | Claim and support | Accessed / scope |
| --- | --- | --- |
| [R: completed scope report][R], sections 1–11, D01–D22/S1–S19 | Baseline, behavior chains, retained fixes, risks, alternatives and authority gaps; completed source-based comparison and source registry | Report dated 2026-10-04; consumed in full. Static/local history plus attributed historical review; no new execution or network query |
| [E: source inventory][E], `currentHead`, `historicalDeltaPaths`, `equalBaselineAndForkFiles`, `functionalBranches`, `currentDocs` | Exact commit/path/blob/ref provenance supporting R | Inventory accessed `2026-10-04T13:02:19.4883004+08:00`; local fixed trees and recorded consumer head |
| Linked four DDD documents above | Existing language, repository ownership and unresolved contracts | Directly reread 2026-10-04; current working-tree documents |
| Local read-only state/layout check | H on main, clean before proposal, 241 tracked files; existing documentation is README plus four DDD files, with no applicable AGENTS found in checked ancestors/owning path | 2026-10-04; local Git/file checks only |

R and E are temporary local links; retention is not guaranteed. Full B/H/F identities are pinned above, with historical locators/ranges in R and paths in E. Latest upstream, performance, runtime success and external-authority completeness remain unverified. Proposal verification covers Markdown links/finding coverage and repository preservation around the single added file.

[R]: C:/Users/WINDOWS/AppData/Local/Temp/codev-rework-scope-c7df23c7b6c349b894f81052be120036/scope-report.md
[E]: C:/Users/WINDOWS/AppData/Local/Temp/codev-rework-scope-c7df23c7b6c349b894f81052be120036/source-evidence.json
