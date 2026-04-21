# AGENTS.md

## Project Overview

minecraft-codev is a multi-module Gradle project that provides a set of Gradle plugins for Minecraft development workflows, including:
- resolving Minecraft artifacts as dependencies
- remapping between mapping namespaces
- access widening and class tweaker support
- Fabric/NeoForge integration helpers
- decompilation, run configuration support, and jar-in-jar includes

Primary language is Kotlin (Kotlin DSL Gradle plugins). Tests use JUnit 5.

## Repository Layout

Root modules are declared in `settings.gradle.kts`:
- `minecraft-codev-core` (main plugin id: `minecraft-codev`)
- `minecraft-codev-access-widener`
- `minecraft-codev-decompiler`
- `minecraft-codev-remapper`
- `minecraft-codev-fabric`
- `minecraft-codev-forge`
- `minecraft-codev-includes`
- `minecraft-codev-runs`
- `minecraft-codev-mixins`
- `minecraft-codev-legacy-forge`

Notable test locations:
- `minecraft-codev-core/src/test/kotlin`
- `minecraft-codev-access-widener/src/test/kotlin`
- `minecraft-codev-remapper/src/test/kotlin`
- `minecraft-codev-forge/src/test/kotlin`

## Environment And Setup

1. Use JDK 21 to run Gradle reliably (matches CI setup).
2. Run all commands from repository root.
3. Use Gradle Wrapper:
   - Linux/macOS: `./gradlew ...`
   - Windows: `gradlew.bat ...`

Initial verification:
- `./gradlew --version`
- `./gradlew tasks`

## Development Workflow

Common commands:
- Build all modules: `./gradlew build`
- Run all tests: `./gradlew test`
- Run checks (includes ktlint/check tasks when wired): `./gradlew check`
- Clean outputs: `./gradlew clean`

Useful module-scoped commands:
- `./gradlew :minecraft-codev-core:test`
- `./gradlew :minecraft-codev-access-widener:test`
- `./gradlew :minecraft-codev-forge:test`
- `./gradlew :minecraft-codev-fabric:compileKotlin`

## Testing Instructions

The repository configures tests with JUnit Platform and a larger heap (`maxHeapSize = "3G"`).

Run full suite:
- `./gradlew test --stacktrace --console plain`

Run a single module:
- `./gradlew :minecraft-codev-access-widener:test --console plain`

Run specific test classes (examples used in this repo):
- `./gradlew :minecraft-codev-access-widener:test --tests "*ClassTweakerInterfaceInjectionTests" --stacktrace --console plain`
- `./gradlew :minecraft-codev-forge:test --tests "*NeoInterfaceInjectionSerializationTests" --console plain`

When changing plugin behavior, prefer narrow `--tests` runs first, then run full module tests before finalizing.

## Code Style And Conventions

- Kotlin code style is set to `official` (`gradle.properties`).
- Ktlint is applied in subprojects with `ktlint_code_style=intellij_idea`.
- Keep changes module-local where possible.
- Favor Kotlin DSL patterns already used in existing build scripts.
- Do not introduce unrelated refactors while fixing targeted issues.

## Build And Publishing

Local publishing:
- `./gradlew publishToMavenLocal`

CI publishing is defined in `.github/workflows/maven-publish.yml`:
- Triggered on changes to `**/gradle.properties` or manual dispatch.
- Uses JDK 21.
- Runs `publishToMavenLocal`.
- Copies artifacts under group path `net/msrandom` into a separate Maven repository checkout.

If you change publication coordinates or artifact layout, verify both local publish output and workflow assumptions.

## Agent Working Agreements

- Make minimal, focused changes.
- Prefer module-scoped builds/tests to reduce turnaround time.
- After editing Kotlin or Gradle files, run at least one relevant module test task.
- If behavior spans modules, run the affected module tests plus a root-level `test` or `check` before completion.
- Preserve existing plugin ids and public task names unless the task explicitly requires changing them.

## Troubleshooting

- If tests fail due to environment/toolchain issues, confirm JDK selection and wrapper usage.
- If Gradle configuration cache causes unexpected behavior while debugging, retry once with `--no-configuration-cache`.
- For flaky or heavy tests, rerun with `--stacktrace --info` and narrow with `--tests`.
