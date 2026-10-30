# Maven publication CI Plan

[Work](work.md) · [Context](context.md) · Sole executable graph: [Waves](waves.md)

Status: prepared for independent delivery-plan review; implementation scope unconfirmed. This document describes future work. No actual publication, item completion or gate release is recorded.

## Outcome and authority

Implement the finalized [Maven publication CI Spec](../../spec/maven-publication-ci.md), within the accepted [Git-backed Maven publishing ADR](../../adr/git-backed-maven-publishing.md). The [Work assessment](work.md#authority-assessment) is PRD skip, ADR reuse and Spec reuse. The target is Codev's own `maven` branch at repository root, with the complete configured publication set, immutable releases, native retained snapshots and an atomic update from a still-current `main` source.

| Success condition | Required evidence owner in Waves |
| --- | --- |
| S1: Every evaluated Maven publication is published only to the dedicated file repository, including all groups, nested libraries, POM-only markers and IDEA. Representative marker and IDEA consumers resolve from it. | `MPC-I01`; required by `MPC-W01-G` |
| S2: Seeded history remains discoverable; complete release path/byte equality skips and every difference blocks the batch; Gradle maintains metadata and retained snapshots. | `MPC-I01`; required by `MPC-W01-G` |
| S3: Eligible source and destination checks yield one confirmed consistent branch tree, a truthful skip/no-op, or a failure without partial writes or lost updates. | `MPC-I02`; required by `MPC-W01-G` |
| S4: The replacement workflow has the exact triggers, main-only guards, token permission, compatible launcher/toolchains and exclusive local publication call. | `MPC-I03`; required by `MPC-W01-G` |
| S5: The workflow command and actual Gradle preparer compose successfully in a bounded local Git remote exercise; hosted behavior remains unverified. | `MPC-I03`; required by `MPC-W01-G` |

All five conditions and the single final gate are required. Item execution details, prerequisites and conflicts exist only in Waves.

## Strategy and ownership

### Gradle owns the complete candidate Maven tree

Extend the existing [root build](../../../build.gradle.kts) with the dedicated `ciMaven` file repository for root and every included project with `maven-publish`, using plugin-aware configuration rather than the existing direct-child-only loop. Discover the final `MavenPublication` objects and their corresponding `PublishToMavenRepository` tasks after all required projects are configured. Select only tasks whose repository is `ciMaven`; never use aggregate `publish`, `publishToMavenLocal` or Marketplace publication. The root may have no actual publications; require the total discovered set to be nonempty and every discovered publication to be accounted for. Do not freeze today's module list or normalize source versions.

Expose `:prepareCiMavenRepository` using the two path properties described in Context. Initialization must precede every selected file-publishing task, and final verification must follow all of them. Run with configuration cache and configure-on-demand disabled for this path. Keep the existing HTTP publishing definitions and compilation targets intact.

Copy the immutable base Maven tree, or an empty tree for first publication, to the disposable output. For each discovered release coordinate/version, remove only that version directory in the candidate before publishing; retain its artifact-level Maven index. Leave seeded snapshot directories intact. When publications share a version directory, compare the union of their generated payload only after all corresponding tasks finish. This prevents inherited files from hiding missing newly generated files while allowing Gradle to preserve previous versions in its index.

Run Gradle's native file publisher once over the complete set. Compare each newly generated release directory recursively against the immutable base by exact relative file set and bytes, without extension exclusions or normalization. An absent base version is new; an equal base version satisfies the publication without changing its version files; any difference, including incomplete base payload, aborts preparation with coordinate/version and a required version increase. Only artifact-level indexes outside version directories and their own sidecars have the Spec's mutable-index exception. No XML/checksum-wide exception is allowed.

Validate required publication outputs against evaluated artifacts/descriptors, including marker dependencies, applicable `.module` files and generated checksums. A successful task exit or a seeded directory alone cannot prove completeness. Gradle generates/updates metadata and snapshot names; retain unrelated content and all older timestamped snapshot files/sidecars. Empty output, missing publication, invalid metadata or build failure discards the candidate. Do not manually merge metadata XML or publish a partial tree. Necessary validation and regression checks are part of this result, not separate graph items.

### The Git helper owns one destination transaction

Use the proposed narrow repository-local Deno/TypeScript helper from Context with Git and the wrapper as subprocesses through `Deno.Command`. Use built-in APIs with no third-party packages or shared external publisher. It accepts the pinned source SHA/ref and a destination remote; the production destination is the repository identified by `github.repository`, while checks use a temporary local bare remote. Validate path/ref inputs before destructive temporary-directory operations. Never refresh or rebuild source from a new `main` inside a run.

For non-`refs/heads/main`, return an explicit skip before publishing. Obtain the exact destination base or positively establish branch absence; network/authentication failure is not evidence of absence. Export only its tree into the immutable base directory and prepare the candidate in a second directory through Gradle. Git state and source files stay outside the published tree.

Before any destination write, read current remote `refs/heads/main`: mismatch means stale-source skip, unreadable HEAD means failure. For a changed tree, construct one commit whose parent is exactly the observed destination base (a root commit for initial creation). Use an explicit expected-old-ref lease, including expected absence for first creation, and verify the candidate's parent relationship before pushing. The lease is compare-and-swap protection; it must never authorize overwriting a destination different from the observed base. No unconditional force push or source branch/tag update is permitted.

Reject a changed destination base rather than auto-rebasing, merging generated XML or rebuilding/reconciling. This is the minimal accepted concurrency strategy. A rerun obtains a new base and repeats all checks; any write retry must repeat source freshness and destination-base checks. No in-process write retry is required. After a push, confirm the expected destination commit/tree through the remote before reporting success; an ambiguous result is not confirmed publication. If the candidate has no diff, verify source freshness and that the remote destination still matches the intended base/tree, then succeed without a commit. Skips must be distinguishable from publication success.

### The workflow owns hosted entry and wiring

Replace the existing [publish.yml](../../../.github/workflows/publish.yml) with a valid job using `runs-on: ubuntu-latest` and `steps`. Use only `push` on `main` with `paths: ['**/gradle.properties']`, plus `workflow_dispatch`. Guard automatic and manual execution with `refs/heads/main`; no pull-request or tag trigger. Check out the fixed source SHA, not `github.head_ref`. Grant the publishing job `contents: write` through the same repository's `GITHUB_TOKEN`, with no unrelated secret or central destination.

Install JDK 8 and 11 as discoverable compilation toolchains, then select JDK 17 for the Gradle launcher; record the effective launcher/toolchains during focused checks. Provision Deno 2 and invoke the repository-local TypeScript helper with `deno run`, granting its required filesystem, environment and subprocess permissions explicitly; include the same runtime/permissions in local checks. Gradle 9.4.0 runtime compatibility is documented in [Context](context.md). The IDEA component stays in the actual Maven build; no Marketplace task substitutes for it. The helper invokes its sole local Gradle path, with no `test publish` or full-project test dependency. Serialize hosted writes with one repository-scoped Maven concurrency group and `cancel-in-progress: false`; the exact-base Git protection remains necessary for races outside that group.

## Verification boundary

Verification is publication-focused and included in each owning item's Result. Use necessary static workflow checking, actual Gradle file publication and consumer resolution, and bounded release/snapshot/Git fault cases in Waves. Record commands, effective JDKs, actual publication/task inventory, assertions and exit/skip outcomes against one identifiable implementation version. Distinguish actual Gradle execution from reused candidate bytes in fault tests.

Use isolated temporary directories and a local Git bare remote for all branch writes. Synthetic payloads may target comparison faults, but cannot replace the real complete-set publication, real marker/IDEA consumption or native snapshot/index checks. Avoid repeating heavy publication for each Git fault: reuse a proven prepared tree where the case concerns only the transaction, and perform one actual integrated preparer-to-remote case. No full root `test`, Minecraft fixture suite, broad JDK/platform matrix or live remote publication is planned.

## Exclusions, transition and risk

No shared external publisher/service, manifest/receipt, separate XML generator, snapshot cleanup, monotonic-version policy, source-version rewriting, source tags, central repository operation or unrelated Mixin/include plan expansion. Deno/TypeScript is the user's chosen local orchestration language; it adds no shared publisher. No dependency upgrades or compilation-target changes are included; install only the selected Deno runtime and required JDKs. A build incompatibility must be reported with the affected publication, not solved by silently excluding it or widening this scope.

Before live publication, the old invalid workflow is replaced in place; the retained HTTP route is not invoked by the new path. Failures before a branch update leave the destination unchanged. Rollback of source integration may restore/disable the workflow without deleting published Maven history; do not erase immutable releases to make a rerun pass. No live rollback or publication is authorized by this Plan.

Archive nondeterminism can make an unchanged release rebuild conflict under the accepted exact-byte policy; report it and require the prescribed version increase rather than normalize archives. Git branch growth and historical snapshots are accepted, with no retention system added. Hosted runner execution, token/branch protection and public serving remain unverified by local checks. The pre-write source check provides the Spec's point-in-time freshness, not a guarantee that `main` cannot advance immediately afterward.

## Author self-check

Performed for this preparation; all implementation checks above and in Waves remain future work.

| Check | Concrete author evidence and conclusion |
| --- | --- |
| Authority and scope | Read the finalized Spec, accepted ADR, workflow, wrapper, root/settings/properties and all twelve included module builds. Work records PRD skip and ADR/Spec reuse. S1–S5 trace to Spec publication/output, initialization, existing-versions, source-update and four acceptance conditions. The user's Deno/TypeScript preference is reflected in the local helper, workflow runtime and checks; the Spec's excluded shared publisher is not introduced. No policy change or extra product system is introduced. |
| Observable results | Waves separates a locally consumable policy-valid Maven tree, a Git transaction consuming that tree, and hosted workflow wiring consuming that transaction. Each survives a later item's failure and has its own Result/retry boundary. Initialization, descriptor checks, release comparison and snapshots are necessary checks of the single complete-tree result; no check-only items or file-based split. |
| Evidence sufficiency | `MPC-I01` requires actual complete-set output/consumer evidence plus exact equality/conflict and native history cases. `MPC-I02` requires local remote SHA/tree assertions for skips, failures and races. `MPC-I03` requires static checks and a real composed local run. Synthetic fixtures alone cannot satisfy real Gradle/consumer conditions; hosted limitations are retained. |
| Dependencies and conflicts | `MPC-I02` consumes `MPC-I01`; `MPC-I03` consumes both. Root build and publication outputs, helper code/temporary Git state, and final integrated evidence are exclusive when written or verified. No shared-read dependency or implicit Wave-order wait is invented. |
| Gates and combined waits | One Wave, three unique items and one final gate. Expanded wait edges are `I01 -> I02`, `I01 -> I03`, `I02 -> I03`, and each item to `W01-G`; the Wave has no predecessor gate. No item waits on its containing gate and there is no combined cycle. Release requires all three completed Results with S1–S5 evidence, never a partial result, document status or favorable plan review. |
| Tuple and portable references | Direct same-directory `work.md`, `context.md`, `plan.md`, `waves.md`; Plan links one Waves and its Work, Waves links that same Plan and Work. Relative links are checked for readable targets; the one public runtime reference is versioned Gradle documentation. Proposed implementation paths/interfaces are labeled as future outputs, not existing evidence. No external Result/session locator is recorded. |
| Actual preparation verification | Read back all four files. All 35 relative-link occurrences resolve to 15 readable repository targets; all 3 fragment references resolve. Plan/Waves correspondence, 3 unique items, 1 Wave, 1 gate, memberships and 6 combined wait edges pass static checks; topological order is I01, I02, I03, W01-G. SHA-256 checks found no changes in 427 pre-existing tracked/authority files; Git status adds only this Work directory to the initial untracked entries, and tracked diff whitespace checks pass. No Gradle, Deno helper, build, publication or Git write was executed. |

Author self-check is not independent review, user confirmation, implementation execution or gate release. No unresolved policy decision prevents this draft; evaluated build viability and hosted permissions remain future evidence requirements.
