# Git-backed Maven publishing

Status: Accepted. Decision identity: `git-backed-maven-publishing`.

Acceptance source: the user's confirmed publishing direction supplied with this documentation handoff. This ADR records an accepted architecture; it does not establish that CI has been implemented or a publication has succeeded.

## Context

Minecraft Codev needs a working CI publication path based on the current local working tree, without first synchronizing remote source changes. The accepted direction is for each participating project to host its Maven repository in its own GitHub repository rather than route the new CI through a central publishing repository.

The existing Codev publishing workflow is to be replaced because it is no longer a valid publication path. Existing Mixin, include, and JVM documentation owns other concerns and does not govern this publishing decision. No applicable publishing ADR or Spec was found during the documentation ownership check. This infrastructure decision does not change product requirements, so no PRD update is required.

## Decision

- Publish Codev's Maven artifacts to the `maven` branch of the repository identified by `github.repository`. The Maven repository directory layout starts at the branch root.
- Automatically trigger publication for changes matching `**/gradle.properties` on `main`, and provide `workflow_dispatch` for manual execution. Pull requests, other branches, and tags do not automatically trigger publication. Publication does not create or move source tags.
- Use the same repository's `GITHUB_TOKEN` with `contents: write` to update the publication branch.
- Produce the actual configured Maven publications, including Gradle plugin marker publications, in a dedicated local output directory. Publish that output rather than copying the entire `mavenLocal` repository.
- Preserve the existing HTTP publishing capability; the new CI publication path does not invoke it.
- Replace Codev's obsolete publishing workflow when implementing this decision. Base that implementation on the current local working tree without synchronizing remote source first.

This ADR authorizes no CI implementation, commit, or live publication. It records the accepted direction only.

## Rationale

A publication branch in the owning repository keeps artifact storage and write authority together. `github.repository` binds the destination to the project executing the workflow, and the repository token supplies the accepted write authority without a separate central publishing credential.

A dedicated Gradle publication output includes the project's configured artifacts and plugin markers without importing unrelated artifacts from a developer or runner's `mavenLocal`. The version-properties trigger supports the accepted release convention, while manual dispatch provides an explicit additional entry point without source-tag management.

The retained HTTP publisher remains available for existing uses. An external shared Deno publisher was not accepted and is not introduced by this decision; neither a shared publishing framework nor a manifest/receipt system is required.

## Consequences and follow-up

Consumers will need to use the Maven repository exposed from Codev's own `maven` branch. The implementation must maintain the Maven layout at the branch root and arrange the required repository token permission. Existing HTTP publishing remains a separate capability.

The handoff reports that the three participating projects' old `maven-repo` branches were already deleted and their absence confirmed with `ls-remote`; the central `SettingDust/maven` repository is retained. Those are supplied migration facts, not operations or remote checks performed for this ADR. They do not prove that the new publication path exists.

The [Maven publication CI Spec](../spec/maven-publication-ci.md) defines the confirmed policies: skip byte-identical complete existing releases and reject differences with a required version increase; allow Gradle-managed SNAPSHOT updates while retaining historical snapshots; restrict automatic and manual publication to `main` and skip stale source revisions after checking the current remote `main` HEAD. It also defines the accepted output organization: seed the dedicated local repository from the existing `maven` tree, or start empty when that branch does not exist, then let Gradle maintain Maven metadata and checksums. These policies do not require monotonically increasing version numbers, a separate metadata generator, or snapshot cleanup. The Spec owns the verifiable payload-comparison boundary and failure behavior; implementation mechanics remain for later planning.

## Revisit conditions

Revisit this decision if GitHub branch storage or artifact access cannot support the required Maven consumption, if the same-repository token cannot support the required publication operation, or if a concrete need arises for centralized hosting or a shared publisher. Any such change requires a new accepted decision rather than an implicit expansion of this ADR.
