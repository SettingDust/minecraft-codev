# Maven publication CI Work

[Context](context.md) · [Plan](plan.md) · [Waves](waves.md)

Prepare Codev's own Git-backed Maven publication path under the accepted [Spec](../../spec/maven-publication-ci.md) and [ADR](../../adr/git-backed-maven-publishing.md). The delivery outcome is a complete, policy-valid Maven tree published atomically to the owning repository's `maven` branch by an eligible current `main` run.

Current stage: implementation arrangements drafted and author-self-checked only. Preparation and graph drafting are authorized; the concrete source implementation scope is not yet confirmed. No implementation item has executed and no Wave gate has been satisfied. Independent delivery-plan review and implementation confirmation remain separate from this preparation.

## Authority assessment

| Family | Handling and owner | Evidence-backed reason |
| --- | --- | --- |
| PRD | skip; Codev publication infrastructure; no applicable publishing PRD | The accepted ADR explicitly leaves product requirements unchanged; existing Mixin product plans do not own publication infrastructure. |
| ADR | reuse; Codev repository hosting and publishing authority; [git-backed-maven-publishing](../../adr/git-backed-maven-publishing.md) | The accepted decision covers same-repository branch storage, triggers, token, retained HTTP capability and replacement of the obsolete workflow. |
| Spec | reuse; Codev Maven publication behavior; [maven-publication-ci](../../spec/maven-publication-ci.md) | The finalized contract covers publication completeness, release equality/conflicts, snapshot history, metadata initialization, source freshness and atomic destination updates. |

This assessment reuses the supplied settled-authority assessment and checks it against the current documents and source. No authority amendment or product-plan expansion is needed.

The Plan owns scope, strategy, risks and success conditions; Waves is the sole executable graph. Its `MPC-W01-G` establishes the Plan outcome only after the Router adopts all three required item Results and judges the stated evidence sufficient. Local verification does not establish a successful hosted run or permission to publish live.

Only the four documents in this Work are created in this preparation. Existing source, authority, documentation, generated outputs and Git history are preserved. Actual preparation checks and their limits are recorded in [Plan author self-check](plan.md#author-self-check).
