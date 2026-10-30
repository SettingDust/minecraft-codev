# Maven publication CI Waves

Matched [Plan](plan.md) · [Work](work.md) · [Context](context.md)

This is the sole executable graph for the Plan's S1–S5 outcome. Graph drafting and author self-check only: all items are planned and unexecuted; the final gate is unsatisfied. Independent plan review, current implementation-scope confirmation, actual prerequisites and lawful tool permissions remain required before execution. One Handler returns one Result per item; checks below are internal evidence of that item's result.

## Grouping and conflict boundary

The complete local Maven tree can be consumed independently of CI. The Git transaction can be exercised independently of GitHub Actions and retained if workflow wiring fails. The hosted entry then consumes these two contracts. Those are three observable results, not a split by file or a single overall feature item. Seed initialization, fresh release comparison, metadata/history preservation and completeness checks jointly establish the local-tree result; none creates a separate publication system or check-only result.

All source writes and Gradle runs use the latest established implementation state. Read-only shared authority is not a conflict. Items run serially through their explicit Result dependencies. Unrelated source/build writers must not overlap publication output or evidence collection; if their changes invalidate inputs, re-establish affected evidence rather than combine incompatible runs.

## MPC-W01 — Publication path established locally and wired for CI

- itemIds: [MPC-I01, MPC-I02, MPC-I03]
- prerequisiteWaveGates: []
- gateId: MPC-W01-G
- Incremental outcome: the complete publication path satisfies Plan S1–S5 through actual local publication/consumption, protected local Git transactions and correct workflow wiring.
- Release predicate: every listed item has an adopted `completed` Result meeting its predicate and required evidence on compatible final implementation inputs. The Router must read/correlate the complete Results, verify S1–S5 coverage and judge the gate. `MPC-I03` must connect the real preparer, helper command and workflow inputs, not only independent synthetic tests. Hosted execution, token/branch-protection policy and public serving remain explicitly unverified and are not implied by gate satisfaction.
- Explicit dependents: none. This gate establishes the selected Plan's local implementation/verification outcome only; it does not authorize any live publication or automatically execute further work.
- Waiting rule: the gate waits for all three items; no item waits for this gate. A `partial`, `failed`, `blocked`, missing or insufficient Result leaves it unsatisfied.

## MPC-I01 — A complete policy-valid local Maven tree

- waveId: MPC-W01
- prerequisiteItemIds: []
- State: planned; no completion evidence yet.
- Write ownership: the existing root Gradle publication configuration; necessary focused publication checks; isolated local base/candidate repositories and build outputs. No workflow, Git transport, source-version, dependency or authority change.
- Conflicts: exclusive root Gradle configuration/build state and publication outputs; subsequent items consume its established interface and evidence. No overlap with other Gradle work that could mutate these outputs.
- Completion predicate: `:prepareCiMavenRepository` prepares a complete locally consumable Maven tree from the evaluated publication set, preserving base history and enforcing every release/SNAPSHOT rule before it can be consumed by a branch writer.

Bounded implementation:

- Add the dedicated `ciMaven` file repository and aggregate preparation path for root plus all nested included publishing projects, with plugin-aware late-publication discovery. Accept immutable-base/output path properties; reject unsafe or overlapping paths. Configure all projects for this invocation; initialization precedes every matching native publication task and verification follows all of them. Do not invoke HTTP, `mavenLocal`, Marketplace or root tests.
- Use the Plan's seeded-candidate strategy: clear only current release version directories in the candidate before generating their complete new payload; retain artifact indexes and all snapshot history. Compare whole regenerated release directories to the immutable base after all publications targeting each directory finish. Fail the batch for any difference and identify coordinate/version with a version-increase message; keep equal version files unchanged. Gradle alone maintains metadata/checksums and snapshot names.
- Validate every discovered publication's expected artifacts/descriptors, metadata and checksums; report evaluated project/publication/GAV/task coverage in the Result without creating a manifest or receipt. Never infer completeness from seeded files, a hard-coded group/module allowlist or an invented JAR for markers.

Required focused evidence:

1. Run actual complete-set Gradle file publishing with JDK 17 launcher and available Java 8/11 compilation toolchains, recording effective JVM/toolchains and tasks. Match output to evaluated publications in root and included projects. Demonstrate both nested libraries, a marker outside `net/msrandom` with its implementation dependency, and IDEA at `com.jetbrains.plugins:net.msrandom.minecraft-codev:1.0-SNAPSHOT`. Check configured source/Javadoc JARs, POM, applicable `.module`, generated checksums and POM-only markers as applicable. No HTTP/Marketplace publication is executed.
2. Resolve one representative plugin through its marker in a minimal Gradle consumer (`apply false` is sufficient; no Minecraft setup), and resolve the actual IDEA Maven artifact. Ensure Codev coordinates come from this file repository, not `mavenLocal`, caches or external substitutes; refresh snapshot resolution and show the selected files. External repositories may supply unrelated dependencies only.
3. In one bounded file-repository exercise, use Gradle to publish an existing and a new version; verify both remain discoverable in metadata and their descriptors/artifacts/checksums are coherent, with unrelated files retained. Use a temporary fixture/copy for alternate versions, never edit working source versions. An unused lower release version must be accepted when its path is unused.
4. Demonstrate an identical complete release rerun leaves version-local paths and bytes unchanged. Exercise changed archive bytes, changed POM and changed `.module` when generated, changed version-local checksum, missing file and extra file. Include a base-only stale inherited file and a removed/missing newly generated artifact so seeding cannot hide a difference. Each case fails preparation with coordinate/version and version-increase requirement; no tree becomes eligible for a branch update. A valid artifact-level index update while adding another version must not falsely conflict with an equal release. Do not filter extensions or normalize files to make equality pass. Exact previously produced bytes may target equality/conflict mechanics; record separately whether an actual rebuild was byte-identical.
5. Update IDEA's `1.0-SNAPSHOT` at least twice through Gradle's native publisher; check metadata resolves the newer timestamped output while older timestamped files and their sidecars remain byte-identical. Check old release versions and unrelated content survive. Empty discovery/output, omitted required output, invalid metadata and publication failure must fail closed. A conflict alongside a new release or snapshot invalidates the entire candidate.

The Result must distinguish real evaluated publication/consumer runs from small fault fixtures and byte replays. These checks establish one candidate-tree predicate; they are not separate items or evidence of any remote write.

## MPC-I02 — An atomic source-current Git destination transaction

- waveId: MPC-W01
- prerequisiteItemIds: [MPC-I01]
- State: planned; prerequisites are future requirements, not satisfied facts.
- Write ownership: proposed new `.github/publish-maven.ts` using Deno/TypeScript and necessary focused transaction checks using Deno's built-in test runner and direct assertions; temporary local Git remotes, base/candidate directories and Git work areas. The helper consumes I01's exact Gradle task/properties through built-in process APIs; it does not duplicate Maven payload/metadata policy or add third-party packages/shared publishers. No production remote write or workflow activation.
- Conflicts: exclusive helper/check sources, local remote refs and publication directories. Do not mutate I01's build contract or erase its evidence while consuming it; a required contract change needs affected evidence reconciliation.
- Completion predicate: the repository-local helper either confirms one complete intended Maven tree on a local destination branch from a current main source, returns a truthful ref/stale-source skip or unchanged-tree success, or fails without partial publication/lost destination updates.

Bounded implementation:

- Pin source SHA and guard `refs/heads/main` before publication; obtain the destination tree or positively establish absence; call I01 with isolated immutable base and candidate paths. Keep `.git`, source checkout and unrelated local caches out of the Maven branch.
- Check current remote `main` immediately before a destination write, including every write retry; fail if it cannot be established and skip if stale. Keep the source fixed. Confirm current destination base, create a single commit from the candidate with exactly that base as parent (or no parent for initial creation), and push with an explicit expected-base/expected-absence lease. Never overwrite a newer/different destination or update source refs/tags.
- Reject destination races; do not add automatic reconciliation or XML merging. A later invocation re-fetches base and rechecks main. Verify the resulting remote commit/tree before reporting success. For no diff, confirm freshness and destination identity and succeed with no commit. Treat unknown push outcome as unconfirmed/failure rather than publication success.

Required evidence uses only temporary local Git remotes:

1. Exercise initial absent-branch creation and existing-branch update. Assert Maven paths start at branch root, only one destination commit represents each changed tree, and unrelated/history files survive. Record initial/final remote SHAs and tree assertions. All intended current publications must be present; no source tags/branches change.
2. For automatic and manual main invocations, exercise current SHA (including rerun eligibility), stale SHA and unreadable remote `main`. Stale skips and lookup failures leave the destination SHA/tree unchanged. Other-branch and tag selections skip before calling Gradle or pushing.
3. Exercise preparer/publication failure, mixed release-conflict-plus-new-output failure, and empty/incomplete candidate refusal. Assert the destination SHA/tree is unchanged; no successful subset escapes.
4. Introduce a competing destination update after base capture and race first creation against another creator. The exact-base lease rejects the stale writer and preserves the winning tree; no unconditional force push. Invoke again after changing main and prove the retry rechecks freshness and skips. An unreadable destination must fail rather than be treated as absent.
5. Exercise an unchanged candidate for a current source: success with no new commit, with no-op checks still detecting a changed base. Exercise rejected push and lost/ambiguous push acknowledgement: no confirmed-success report without matching remote evidence. A verification failure may follow an actually completed remote write; report that possibility truthfully, never claim the remote necessarily stayed unchanged after an ambiguous transport result.

Use I01's proven prepared tree for transport-only cases, with small deterministic fault payloads where useful; label each. Real native snapshot/metadata behavior stays owned by I01. I03 supplies the actual preparer-to-remote composition, so Git fault checks need not rebuild every publication repeatedly.

## MPC-I03 — The replacement workflow invokes the verified path

- waveId: MPC-W01
- prerequisiteItemIds: [MPC-I01, MPC-I02]
- State: planned; no implementation confirmation or prerequisite Result exists yet.
- Write ownership: replacement of existing `.github/workflows/publish.yml` and necessary focused wiring checks. Read I01/I02 implementation; use isolated local outputs for the final composed check. No production remote writes, authority edits or changes to existing feature plans.
- Conflicts: exclusive workflow/wiring sources and final integrated publication evidence; do not overlap helper/build writers, other publication runs or output cleanup. Consume the latest compatible I01/I02 Results.
- Completion predicate: the old workflow has been replaced by a structurally valid, exactly scoped main-only publication workflow whose real command composes I01 and I02 successfully against a local Git remote, while retaining the explicit hosted-execution limitation.

Required changes and internal verification:

1. Use valid `jobs.publish.runs-on`/`steps`, exact `push` branch/path filters plus manual dispatch, main-ref guard for both entry modes, pinned source checkout and same-repository `GITHUB_TOKEN` with `contents: write`. Use a repository-wide Maven concurrency group with `cancel-in-progress: false`, plus I02's destination lease. No PR/tag automatic trigger, source-tag update, central credentials, HTTP/Marketplace publication or `test publish` invocation.
2. Provision Deno 2, JDK 8/11 toolchains and JDK 17 launcher explicitly. Invoke the repository-local TypeScript helper via `deno run` with explicit required filesystem/environment/subprocess permissions; the helper calls only the dedicated local Gradle entry point. Keep existing HTTP capability definitions intact. Static workflow validation must cover schema, trigger/ref expressions, token and Deno permissions, runtime installation, quoting, command/argument correspondence and launcher/toolchain selection; use actionlint if available or an equivalent bounded YAML/schema/expression inspection, with its limits reported. No extra validation infrastructure or external shared publisher is required.
3. Run the exact `deno run` helper command, runtime permissions and argument contract used by the workflow against a temporary local Git remote and the actual Gradle preparer on the final implementation inputs. Confirm one complete root-layout tree and representative consumer evidence still apply; reuse I01 evidence when inputs are unchanged rather than repeat all checks. Exercise manual other-branch/tag selections with the same ref guard, proving no write. Reuse I02 fault coverage only after checking the final wiring did not bypass its checks.
4. Return a S1–S5 coverage reconciliation citing actual prior Results/commands and the final wiring evidence, including any affected checks rerun for changed inputs. Do not project task exit success as a hosted run. A full project test suite or live GitHub push is not a prerequisite and is not authorized by this graph.

## Graph author checks

There is one nonempty Wave, three unique item IDs, one unique gate and no unresolved graph references. Membership and prerequisites are explicitly listed above. The combined dependency direction is `MPC-I01 -> MPC-I02 -> MPC-I03 -> MPC-W01-G`, with additional edges from I01 to I03 and from I01/I02 to the gate; no reverse edge or own-gate wait exists. The containing Wave adds no predecessor-gate wait. The gate's only release predicate is the conjunction of the three actual Results and their S1–S5 evidence; none currently exists.

The [Plan self-check](plan.md#author-self-check) records authority/success, single-result grouping, evidence sufficiency, conflicts, dependencies, gates and tuple checks. This graph creates no independent-review item, extra approval system or automatic scheduling state. Plan readiness review and implementation confirmation remain separate Router-owned boundaries.
