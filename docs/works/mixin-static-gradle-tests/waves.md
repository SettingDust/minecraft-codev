# Mixin 静态 Gradle 测试迁移 Waves

[Work](work.md) · [Context](context.md) · **唯一匹配 [Plan](plan.md)**

## 最终收口记录

**Router已核定MST-W02全部条件满足（satisfied）。** 已可靠采用17个静态owner completed：R13/R14/R15/R34/R17/R18/R19/R20/R21/R35/R27/R28/R29/R30/R31/R32/R33，以及R24/R25/R26 generation1 completed，共20个实际成员；R26独立结论ready、无阻断。此处仅同步Router既成判断，Handler未自行验收或释放gate；不另声明released。

R24仅删除InputBinding的13行无caller代码，目标compileTestJava实际重新编译成功，未运行测试。R25在R24最终输入上从根:test同次实际执行18类131方法（Mixins101/Fabric14/Forge16），零failure/error/skip，48 actionable tasks全部executed；三个模块test实际执行，根:test正常NO-SOURCE。151个静态Jar、R35全部21包及43条资源copy记录、嵌套缓存和真实故障/fresh retry均由当轮证据关联；G11原两方法包含其中。历史34/59/80保持各自版本和运行，不拼入本轮131。

R26逐项支持11类、S1–S8、F01–F18/G01–G18、R07全部16行及20成员要求。R24报告两处非阻断误述在此纠正：refmap实际selector为`mapping-mod`/`mapping-legacy-mod`；InputBinding:495实际将`probe.jar`的`resource.txt`改为`current-input`，并非fixture.json。原build报告不改写。详细处理事实及仓内导航见[Context收口证据](context.md#最终收口证据与限制)，唯一图及原gate见[Waves](waves.md#mst-w02-残留生成链恢复图)，范围和成功条件仍由[匹配Plan](plan.md)持有。

R23保持excluded / exception，保留Random/JarOutputStream/cleanup动态基线和全部正常/故障/retry保证，不记completed或failed、不作成功前置；R34/R35承接不抹去R16 blocked、R22 g1无终态/g2 failed及候选撤回。R23旧completed身份not-verifiable、I01/I03/I05 blocked、R02 partial、R08/R10旧not-ready及其他失败/局部历史均保留。PRD/ADR/Spec继续reuse；未改成员、边、谓词、gate合同或例外。

本轮仅四文档C5事实维护与静态自检，零构建、零测试、零代码/资源/配置/authority/build证据/Git写入。R07全历史树hash缺失、build证据可clean、部分temp仅能通过当轮XML/stdout及原断言关联，未检查全仓、游戏或MC下载；加工记录不承诺完整原Result永久可取。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 本文件是唯一执行图。**当前MST-W02 pending；R22 generation2 failed与R35 completed已采用；依用户明确决定，R23仅为StripStreamTests固定stream-copy基线打包的excluded / exception历史/范围记录，不再是实际执行item。** 保留动态@BeforeEach输入生成及全部原断言，不将它算作静态迁移完成。R35的21包资源化/删writer/同版34通过、其他owner已采用completed、R16 blocked及八路径/59通过不重开或重置。R23旧错误completed身份未关联、先前现场生成审计、候选资源计划独立review通过但用户未批准均保留，见[Context](context.md#r23-事实更正与冻结来源)；不追认为完成或虚构新failed。本轮仅四文档维护及作者自检，不实施、不测试、不作独立review、不完成R23或释放W02。

以下至 W02 前均为旧 W01 合同/历史记录。十三实际 member completed、R12 ready、Router 核定 W01 satisfied/released、131/131 与 Fabric14/14 保留；当前审计证明旧 S1/S8“无剩余静态化遗漏”的充分性过宽，历史通过不能证明当前组织无遗漏。I01 blocked、R02 partial、I03 blocked/草稿、I05 blocked/部分效果、R06 局部2/2、R08/R10 not-ready 及副作用永久保留。

## R07 执行合同与 16 行可执行矩阵

以下矩阵是 R07 的唯一完整 Forge 重验范围；每行都是一个可直接传给 `:minecraft-codev-forge:test` 的 Gradle `--tests` selector。矩阵中的 16 行必须绑定同一份当前源码 checkout、同一份 Gradle 解析后的依赖/插件版本、外层 Gradle JVM、`tasks.test.javaLauncher` 和 `fixture.gradleJava` 均为 JDK17 的同一轮测试任务结果；同一 R07 Result 必须分别记录外层 Gradle JVM 的完整 `java -version` 输出与实际路径、`tasks.test.javaLauncher` 解析后的实际 JDK 完整版本与实际路径、`fixture.gradleJava` 实际 JDK 完整版本与实际路径，明确三者均为 JDK17，并记录外层 JVM 的实际锁定方式（`JAVA_HOME` 或 `org.gradle.java.home`）及对应 `--version` 输出。不得把旧 I05 的 14/16、R06 的 2/2 或不同版本/不同缓存状态的结果拼接成 R07 的 16/16。每行的 `fixture.evidence` 根目录由 Forge `build.gradle.kts` 设置为 `minecraft-codev-forge/build/platform-fixtures`；兼容测试通过递归 `Files.walk` 写入 `retained-baseline/<method>`。metadata 行不要求非递归 retained 目录；没有直接保留文件时，使用与该 selector 和 Result 关联的 JUnit XML 或控制台断言证明行内断言。

共同运行边界（可解析字段）：

```yaml
r07Execution:
  task: :minecraft-codev-forge:test
  commonSourceAndResolvedVersion: one current checkout and one recorded Gradle-resolved dependency/plugin graph for all 16 rows
  gradleVersion: one recorded Gradle wrapper version for all 16 rows
  outerGradleJvm: JDK 17; record full `java -version` output and actual JDK path in the correlated Result
  outerGradleJvmLock: record the actual `JAVA_HOME` or `org.gradle.java.home` lock mechanism and its corresponding `--version` output
  javaLauncher: tasks.test.javaLauncher = JavaLanguageVersion.of(17); record the resolved actual JDK full version and path
  fixtureGradleJava: JDK 17; record the actual JDK full version and path
  jdkContract: outerGradleJvm, resolved javaLauncher, and fixtureGradleJava are all explicitly recorded as JDK17
  fixtureProject: minecraft-codev-forge/integration-test/forge
  fixtureWiring: [fixture.forgeProject, fixture.gradleJava, fixture.classpath, fixture.testOutputs, fixture.evidence]
  fixtureEvidence: minecraft-codev-forge/build/platform-fixtures
  selectors: 16 rows in the table below, passed as --tests selectors
  cleanCacheBoundary: clean minecraft-codev-forge/build outputs and build/platform-fixtures before the baseline; use --rerun-tasks; do not treat UP-TO-DATE/FROM-CACHE replay as a row pass
  cacheScope: this boundary excludes deleting the Gradle user-home dependency cache; any cache-replay observation is separate evidence
  resultRule: one correlated R07 Result records command, checkout/version, resolved dependencies, the full outer `java -version` output and actual path, the resolved `tasks.test.javaLauncher` JDK full version and path, the `fixture.gradleJava` JDK full version and path, explicitly states all three are JDK17, records whether the outer JVM was locked by `JAVA_HOME` or `org.gradle.java.home` plus its corresponding `--version` output, fixture path, selector outcomes, TaskOutcome, retained evidence or correlated JUnit XML/console assertions, and limitations
```

| Row | Source / line | Executable selector | Required assertion and evidence binding |
| --- | --- | --- | --- |
| R07-01 | `ForgeMixinMetadataTests.kt:55` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.manifestDiscoveryTrimsBlanksWithoutWritingMetadata` | References are exactly `a.json`, `b.json`; raw manifest attributes and `keep.txt` remain unchanged. Evidence: correlated JUnit XML/console archive assertions; `metadata/manifestDiscoveryTrimsBlanksWithoutWritingMetadata/` only if direct files are retained. |
| R07-02 | `ForgeMixinMetadataTests.kt:77` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.neoforgeTomlDiscoveryRetainsEveryEntry` | TOML references are exactly `a.json`, `b.json`; `vendor.keep=true` and `keep.txt` remain. Evidence: parsed TOML assertions in correlated JUnit XML/console output; `metadata/neoforgeTomlDiscoveryRetainsEveryEntry/` only if direct files are retained. |
| R07-03 | `ForgeMixinMetadataTests.kt:114` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata` | Dual metadata produces `Consumed`, target class value is `42`, and source bytes are unchanged. Evidence: correlated JUnit XML/console assertions plus cleanup JSON and output JAR; `metadata/producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata/` only if direct files are retained. |
| R07-04 | `ForgeMixinMetadataTests.kt:130` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.dualMetadataDiscoveryAndExactEditingPreserveReferences` | Original/output class values are `1/42`; only consumed mixins are emptied, all metadata/resources remain, and source bytes are unchanged. Evidence: correlated JUnit XML/console assertions plus records, cleaned JAR, reopen and content assertions; `metadata/dualMetadataDiscoveryAndExactEditingPreserveReferences/` only if direct files are retained. |
| R07-05 | `ForgeMixinMetadataTests.kt:183` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.originalNullableContractEmptyHandlersAndConstructors` | Missing/metadata-only inputs return null, valid empty metadata returns empty lists, constructors defensively retain references. Evidence: correlated JUnit XML/console null/empty/reference assertions; `metadata/originalNullableContractEmptyHandlersAndConstructors/` only if direct files are retained. |
| R07-06 | `ForgeMixinMetadataTests.kt:208` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.closedZipHandlersPersistRemovalForBothMetadataFormats` | Manifest/TOML/dual closed-archive paths retain exact references, remove only listed metadata, preserve vendor/resources/source, and reopen with no handlers. Evidence: correlated JUnit XML/console archive, metadata, byte and reopen assertions; `metadata/closedZipHandlersPersistRemovalForBothMetadataFormats/` only if direct files are retained. |
| R07-07 | `ForgeMixinMetadataTests.kt:276` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.manifestEditsCurrentReferencesAndAttributesWithoutChangingTomlOrSnapshot` | Removal uses current manifest entries while snapshot stays stable; TOML/resources and current attributes are preserved; absent config is unchanged and missing root fails. Evidence: correlated JUnit XML/console manifest, TOML, snapshot and exception assertions; `metadata/manifestEditsCurrentReferencesAndAttributesWithoutChangingTomlOrSnapshot/` only if direct files are retained. |
| R07-08 | `ForgeMixinMetadataTests.kt:315` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.manifestChangedReferencesRemainOutsideRemovalSet` | The changed reference remains in the current Manifest outside the removal set, and TOML source bytes remain unchanged. Evidence: correlated JUnit XML/console assertions; no retained metadata directory is required. |
| R07-09 | `ForgeMixinMetadataTests.kt:333` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy` | ServiceLoader finds both formats, duplicate references and `COMMON` policy are retained, references are immutable, and source bytes are unchanged. Evidence: correlated JUnit XML/console SPI/list/reference assertions; `metadata/actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy/` only if direct files are retained. |
| R07-10 | `ForgeMixinMetadataTests.kt:356` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.neoForgeEditsCurrentTomlWithoutChangingManifestOrSnapshot` | Current TOML removes only snapshot-listed entries; new/unknown entries, manifest, resources, and snapshot remain; absent mixins is unchanged. Evidence: correlated JUnit XML/console parsed TOML/manifest/snapshot assertions; `metadata/neoForgeEditsCurrentTomlWithoutChangingManifestOrSnapshot/` only if direct files are retained. |
| R07-11 | `ForgeMixinMetadataTests.kt:402` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.malformedMetadataAndBusinessPathsStillFailWithoutWrites` | Malformed, absolute, traversal, dot, backslash, NUL, and invalid TOML inputs throw without changing bytes; missing metadata is not recreated. Evidence: correlated JUnit XML/console exception, byte and non-recreation assertions; `metadata/malformedMetadataAndBusinessPathsStillFailWithoutWrites/` only if direct files are retained. |
| R07-12 | `ForgeMixinMetadataTests.kt:434` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.hostDiscoverySeesBothDistinctFormatsAndSingleFormatArchives` | Manifest, TOML, and dual archives discover the expected configs and `*` environment, without source mutation; closed archive remains readable. Evidence: correlated JUnit XML/console discovery, environment, byte and reopen assertions; `metadata/hostDiscoverySeesBothDistinctFormatsAndSingleFormatArchives/` only if direct files are retained. |
| R07-13 | `ForgeMixinMetadataTests.kt:467` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.actualReadWriteAndCloseFailuresEscapeRemove` | Read/read-close/write/write-close failures reach real I/O, close handles, propagate the original cause, preserve the read case, and recover after reset. Evidence: correlated JUnit XML/console per-mode failure, close, content and recovery assertions; `metadata/actualReadWriteAndCloseFailuresEscapeRemove/` only if direct files are retained. |
| R07-14 | `ForgeMixinMetadataTests.kt:584` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests.manifestActualReadWriteAndCloseFailuresEscapeBothEditEntrypoints` | Manifest read/write/close failures reach real I/O and propagate; content protection and post-failure recovery hold for both load/remove entry points. Evidence: correlated JUnit XML/console per-mode cause, close, content and recovery assertions; `metadata/manifestActualReadWriteAndCloseFailuresEscapeBothEditEntrypoints/` only if direct temp files are retained. |
| R07-15 | `ForgeAccessTransformAndJarJarCompatibilityTests.kt:74` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests.jarJarRemovalDeletesListedPayloadAndMetadataOnly` | G1 preserves all entries; cleanup deletes listed JarJar payload/metadata only, preserves unlisted nested content and exact `{"keep":true}` vendor bytes, and retains ordinary resources. Evidence: `retained-baseline/jarJarRemovalDeletesListedPayloadAndMetadataOnly/` and entry/content/nested-reopen assertions. |
| R07-16 | `ForgeAccessTransformAndJarJarCompatibilityTests.kt:152` | `--tests net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests.actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload` | G1 preserves access inputs; non-empty AT yields both public members identically for baseline/current, while vendor and nested payload bytes remain exact and reopenable. Evidence: `retained-baseline/actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload/` and access-map/byte/nested-reopen assertions. |

R07 的原执行合同与 16 行矩阵保持不变；Router 已采用单一 completed Result，逐行通过记录见下方 R07 completion record。本次只维护文档，不执行 Gradle、测试或清缓存。

## 共享资源冲突（结构化）

```yaml
resourceLocks:
  - id: root-gradle-test-state
    mode: exclusive
    members: [MST-R04, MST-I04, MST-I05, MST-R06, MST-R07, MST-R09, MST-R11]
    resources: [Gradle test execution, module build outputs, test daemon/JVM state]
    reason: root aggregate or platform test execution must not overlap while task outputs and execution state are being observed
  - id: forge-fixture-and-evidence
    mode: exclusive
    members: [MST-R04, MST-I05, MST-R06, MST-R07, MST-R09]
    resources: [minecraft-codev-forge/integration-test/forge, minecraft-codev-forge/build/platform-fixtures, fixture.evidence]
    reason: Forge tests consume the same fixture wiring and evidence destinations
  - id: forge-test-task-jdk17
    mode: exclusive
    members: [MST-I05, MST-R06, MST-R07, MST-R09]
    resources: [":minecraft-codev-forge:test", tasks.test.javaLauncher=JavaLanguageVersion.of(17), pluginUnderTestMetadata]
    reason: I05 and R06 exercise overlapping Forge test classes and must not mix task/cache state
  - id: final-evidence-snapshot
    mode: exclusive
    members: [MST-R09, MST-R10, MST-R11, MST-R12]
    resources: [three-module test outputs and fixture evidence, related source/build/fixture version, matched Work/Context/Plan/Waves snapshot]
    reason: final runs and the R11 test edit write inputs/evidence; R10/R12 inspect stable snapshots; no concurrent Gradle, cleanup, or relevant source/document writer
  - id: fabric-test-and-fixture-evidence
    mode: exclusive
    members: [MST-I04, MST-R09, MST-R11, MST-R12]
    resources: [Fabric test source, FabricInputs and static fixture inputs, minecraft-codev-fabric/build, platform-fixtures and JUnit outputs]
    reason: R11 must preserve the R09 frozen baseline and R12 must inspect final relevant bytes without a concurrent writer
serialization:
  - from: MST-R03
    to: MST-R04
  - from: MST-R04
    to: MST-R01
  - from: MST-R01
    to: MST-I02
  - from: MST-I02
    to: MST-R05
  - from: MST-R05
    to: MST-I04
  - from: MST-I04
    to: MST-I05
  - from: MST-I05
    to: MST-R06
  - from: MST-R06
    to: MST-R07
  - from: MST-R07
    to: MST-R08
  - from: MST-R08
    to: MST-R09
  - from: MST-R09
    to: MST-R10
  - from: MST-R10
    to: MST-R11
  - from: MST-R11
    to: MST-R12
```

serialization 记录历史冲突顺序和安全的后续串行路径，不是成功依赖。I05 的历史结束/blocked 足以解释其先于 R06 的资源释放，不要求 I05 completed。R09 还独占 Mixins/Fabric 的静态工程副本、相关 fixture 输出及整个共同 Gradle/JVM 状态；R10/R12 读证据期间不得重跑或清输出；R11 独占 Fabric 测试写面和公共 Gradle/JVM 状态，不写 Forge fixture，但仍禁止任何其它构建破坏冻结证据。所有已结束的 item 不因此重新执行；新写入者必须先结束并使版本/证据适用性重新明确，不能与本图组合运行或核验混写。

## MST-W01 — 普通静态输入迁移且既有保证保持

- state: completed
- itemIds: [MST-R01, MST-R03, MST-R04, MST-I02, MST-R05, MST-I04, MST-R06, MST-R07, MST-R08, MST-R09, MST-R10, MST-R11, MST-R12]
- prerequisiteWaveGates: []
- priorItemIds: [MST-R01, MST-R03, MST-R04, MST-I02, MST-R05, MST-I04, MST-I05, MST-R06, MST-R07, MST-R08]
- outcome：普通测试使用静态 Gradle 输入，旧正常动态重复链被替换，核心与平台内容、缓存、失败及局部保证保持；本 Plan 仅由此 gate 建立完成。
- gate：只有实际列出的十三个 item 均满足各自 predicate，并有完整可关联且已采用的 completed Result；全部 F01..F18、原 R07-01..16 和 Plan S1-S8 有充分、对最终相关版本适用的实际断言/内容证据。R09 的同次根 :test 三模块有限实际组合不重放、不拼接为新131运行；R11 必须补齐 F16 六故障→撤销/必要输入复位→成功 fresh retry→实际 metadata 内容，且聚焦 Fabric 完整14方法本轮实际执行、0 failure/error/skip。R12 必须独立核对 R09 冻结基线至最终相关版本的实际 diff、证据复用及必要重验，逐行闭合 S6/S8 和其余原合同，结论 ready、无未满足验收项，才满足gate。R11 若触及扩大写面则按下方差异规则补足受影响验证，不能以默认14方法豁免。R08/R10 仅作为已完成检查点，其旧 not-ready 不要求升级；R10 completed 不等于 gate ready。Router 完整读取并可靠关联 Results 后另行判断；Router 已核定 satisfied/released；此处只记录既有判断。
- recoverySubstitutions：I05 是被替代的历史 member，原 blocked、部分效果、旧 2/16 和原完整验收要求保留；R07 的独立完整重验 Result 已全部承接其 Forge 验证义务，实际成功成员为 R07，不再要求旧 I05 Result 变成 completed。R06 局部 2/2 仍不替代完整重验。R08 仍是 completed 的历史审计检查点 member，原 ready/not-ready 判断已完成且结论 not-ready 永久保留；它当时的最终充分性职责由 R10 在 R09 新证据上承接，gate 不要求把 R08 旧结论改成 ready。R10 completed/not-ready 继续是实际检查点 member；其唯一 F16 缺口由 R11 恢复，最终充分性由 R12 在 R09 基线＋R11 最终相关版本证据上承接，不改写 R10 原结论或要求永久升级。
- originalAcceptance：R04 根接线/历史有限验收与实际/UP-TO-DATE 区别不变，不替代最终新驱动组合；R05/R06 不替代平台完整覆盖，历史数字不得拼接成新实际组合。恢复调整 member 与实际验收承接关系，以最终diff判定未影响证据的适用性而不宣称新版本重跑131；未降低原 S1-S8/覆盖/共享回归/共同版本/根入口强度。
- 历史处置：I01/R02/I03 和被替代 I05 不属于实际 itemIds。原 completed/partial/blocked 与已完成效果均保留，不重放根接线、pipeline 或平台迁移。R08 的 not-ready 缺口登记已完成，不要求先重复登记或重新审计才能形成 R09 运行输入。
- 显式依赖方：无后继 Wave；所有成员仅受各自 item 前置和本 Wave 的空 prerequisiteWaveGates 约束，R09/R10/R11/R12 均不等待 W01 自身 gate。

只有 Router 判断 gate；Router 已完整关联 Results 并核定本 gate satisfied/released。作者自检、独立 review 和实际运行/验收仍是不同边界。

## MST-R01 — 恢复普通组件静态输入迁移

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: []
- completion record：ordinary 静态工程与共享直接消费者回归完成，25 个专用 Jar 实际消费，九类聚焦回归 80/80。Java 11、UTF-8、`-proc:none`；真实内容、TaskOutcome、通知、原输入保护与故障路径均有证据。
- owner：Mixins ordinary 静态输入、必要 helper、Preapplication/Producer 普通消费及直接共享回归。不拥有 mapping 正常输入或 pipeline 特有矩阵。

## MST-I02 — 映射普通输入静态化且名称结果等价

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R01]
- completion record：已消费 R01 completed Result；mapping 静态 source sets 与 JavaCompile/Jar provider 完成。mapping 8/8，Preapplication/Producer/ProducerDom 直接消费者 29/29；名称、通知键、context、缺失/无可用 refmap 与流故障证据齐备。
- owner：mapping 输入与名称合同；R05 不重复计入本项矩阵。

## MST-R03 — 校正独立 Strip 注册测试的现行失败合同

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: []
- completion record：只把 StripRegistrationTests 旧 numeric 拒绝期待改为真实 DOM 错误；聚焦测试 1/1 通过。保留失败消费、合法空恢复及各阶段原输入保护。没有增加 numeric/路径预检或生产行为。
- owner：独立注册测试合同校正及必要局部回归。

## MST-R04 — 恢复已接线根入口的剩余有限验收

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R03]
- completion record：根入口有限验收通过；root-only dry-run 确认 Mixins/Fabric/Forge 三模块依赖。Mixins 101/101 为本轮实际执行；Fabric 17/17、Forge 16/16 为正常 UP-TO-DATE 复用；合计 134 项，0 失败、错误、跳过。三类报告与任务结果区分记录。R02 的 134=133/1/0skip 仍为独立历史，不改写、不拼接。
- released dependencies：本完成 Result 满足 I04、I05 与 R06 各自的 R04 成功前置；I04 completed、I05 原 Result blocked；R06 completed，各项成功条件不因前置满足而自动完成。
- owner：根入口剩余验收，不重写 R02 已完成接线，不替代最终共同版本 gate。

## MST-R05 — 恢复 I03 静态 caller 工程与完整验证

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R01, MST-I02]
- completion record：pipeline 静态 Gradle 工程与 caller 完成；MixinInputBinding TestKit 10 个场景 10/10 通过，覆盖 SUCCESS、UP-TO-DATE、FROM-CACHE、输入变化、cleanup direct inputs、双 Strip 内容、坏输入、读写/发布失败及恢复重试。
- scope：仅承接 I03 pipeline 草稿及未完成合同。保留 consumeA/B 的 producer dependsOn 与 cleanup 直接必需 inputs.file、probe cleanup 直接输入；不重复普通/mapping 证据。
- history：原 I03 blocked 与草稿部分效果继续保留；先前 R05 READY 复审是历史实施准入，不替代此完成 Result。R05 完成不释放 W01。

## MST-I04 — Fabric 普通场景静态化且适用性保持

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R04]
- completion record：Fabric 静态 fixture 实际构建；Applicability 6/6、Metadata 8/8，共 14/14 通过。target/input JAR 内容及读写关闭故障已有通过证据；原摘要“恢复重试均已验证”过宽，R10 已证明 F16 六故障后成功 retry 的断言缺失。I04 completed/14通过历史不撤销，不能把原摘要作为恢复证据。未运行全仓限制保留；该 Result 不释放 W01。
- dependency status：R04 completed，根入口成功前置已满足。
- owner：Fabric 静态输入、真实 applicability/metadata/Strip、局部 snapshot/current edit 与 SPI 内容；不替代最终共同版本 gate。

## MST-I05 — Forge/NeoForge 普通双格式场景静态化


- state: blocked
- historicalWaveId: MST-W01
- replacedBy: MST-R07
- membership：原 W01 member，现为被替代历史；不要求旧 blocked Result 转 completed，完整原谓词/证据由实际 member R07 承接。
- prerequisiteItemIds: [MST-R04]
- prior Result：blocked，且部分效果已产生：Forge 静态工程与接线已创建，`ForgeMixinMetadataTests` 14/14 通过；原运行汇总 2/16 失败，两项均在 [`ForgeAccessTransformAndJarJarCompatibilityTests`](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt) 的嵌套 `META-INF/vendor.json` 精确内容断言处，分别涉及 `jarJarRemovalDeletesListedPayloadAndMetadataOnly` 与 `actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload`。
- timing limitation：旧报告输入为 `{"keep":true}` 加末尾 LF；报告之后静态源 [vendor.json](../../../minecraft-codev-forge/integration-test/forge/src/embedded/resources/META-INF/vendor.json) 已改为无末尾 LF。当前源字节只读核对为 13 字节、末字节 `}`；旧报告只证明修正前的失败；随后采用的 R06 Result 记录两个指定测试 2/2 新鲜通过。
- adopted combined coverage：I05 既有 metadata 14/14 与 R06 两项兼容性测试 2/2 仅共同覆盖一个已识别的局部边界；两次独立运行不拼成一次 16/16 全绿，原 blocked Result 与旧 2/16 失败历史保留。此记录不完成 I05、不释放 W01；完整重验由 R07 承接。
- owner/success evidence：Forge/NeoForge 双 metadata 静态输入、真实 producer/Strip、snapshot/current edit、局部流及兼容回归的原完整覆盖要求保留，由 R07 独立 completed Result 承接完整重验。原 blocked Result 与已有部分效果均保留；R06 不改写该 Result、不自动完成 I05。


## MST-R06 — 恢复静态 Forge vendor fixture 的精确尾部与兼容性

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R04]
- scope：只确保 [embedded `META-INF/vendor.json`](../../../minecraft-codev-forge/integration-test/forge/src/embedded/resources/META-INF/vendor.json) 保持原 JSON 内容且无末尾 LF，并执行两个既有测试方法：`jarJarRemovalDeletesListedPayloadAndMetadataOnly`、`actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload`。不改生产 handler、ServiceLoader、AT/JarJar 逻辑，不放宽测试断言，不扩大到其他测试。
- completion record：`vendor.json` 为 13 bytes、无末尾 LF；上述两个 Forge 兼容性测试 2/2 通过。该 Result 仅覆盖 I05 已识别的局部组合边界，不改写 I05 原 blocked Result、不完成 I05 或释放 W01。
- serialization：依赖 R04；与共享 Forge 测试/JVM 串行，并与 I04/I05 保持冲突顺序。冲突次序不是成功依赖，R06 无须 I05 completed Result。

## MST-R07 — 完整重验 I05 Forge/NeoForge 双格式场景

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R06]
- predicate：保留 I05 原 blocked Result、旧 2/16 失败历史和 R06 局部 Result，在一个同一源码 checkout、同一解析版本图、外层 Gradle JVM、`tasks.test.javaLauncher` 和 `fixture.gradleJava` 均锁定为 JDK17且同一 Result 已记录三者各自的完整版本/实际路径、外层 `java -version` 与路径、外层锁定方式（`JAVA_HOME` 或 `org.gradle.java.home`）及对应 `--version` 输出的同一 Forge fixture 和清理后的 `minecraft-codev-forge/build` / `build/platform-fixtures` 边界内，按上方 R07-01 至 R07-16 的 16 个独立 selector 重新覆盖 I05 全部必需 Forge/NeoForge 矩阵，形成一个新的、完整且可关联的 completed Result；不得把历史 14/14 与 R06 2/2 拼成一次 16/16，也不得把 UP-TO-DATE/FROM-CACHE 复用当作该矩阵的通过。
- evidence：16 行的 selector、源码行、JUnit 断言、`fixture.evidence` 证据（R07-15/16 使用 `retained-baseline`；metadata 行没有非递归 retained 目录时使用可关联的 JUnit XML/控制台断言）、共同版本/解析依赖、外层 Gradle JVM 的完整 `java -version` 输出/实际路径、解析后的 `tasks.test.javaLauncher` JDK 完整版本/实际路径、`fixture.gradleJava` JDK 完整版本/实际路径、三者均为 JDK17 的明确记录、外层 JVM 锁定方式及对应 `--version` 输出、fixture 路径、clean-cache 边界、每行 pass/fail/skip、TaskOutcome、内容/故障证据和限制均记录在同一个 Result；Router 已完整读取并可靠关联该 completed Result。
- completion record：R07-01..16 各实际执行 1 test，共 16 tests / 16 pass / 0 fail / 0 error / 0 skip，全部 TaskOutcome SUCCESS/executed，非 UP-TO-DATE/FROM-CACHE。同一 HEAD `30d1d3d22267477db3275cb849e8692ada0f74de` 及原有未提交迁移工作树、Gradle 9.4.0 wrapper、同轮 testRuntimeClasspath 解析图；外层 Gradle JVM、解析后的 `tasks.test.javaLauncher`、`fixture.gradleJava` 均为 Microsoft JDK `17.0.19+10-LTS`，实际路径 `D:/Applications/Scoop/apps/microsoft17-jdk/current`。外层 JAVA_HOME/PATH 锁定，嵌套 fixture `-Dorg.gradle.java.home`；先删除 Forge build 再建立证据，逐行 `--rerun-tasks --no-build-cache --no-configuration-cache --no-daemon --max-workers=1 --tests`，没有删除 user-home 依赖缓存。
- repository evidence：已核实可读的[16 行 selector/TaskOutcome/JUnit 索引](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/verified-rows.json)与[运行汇总及 fixture 字节](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/verification-summary.json)；环境、解析图及逐行执行边界的可读引用集中于 [Context 完成记录](context.md#r07-已采用完成事实与证据限制)。均为 build 输出，不是永久完整原始 Result。
- limitations：R07-08 实际断言 TOML bytes 和当前 Manifest 中 changed reference 未移除；vendor.json 前后 13 bytes、无 LF、未改动。未改生产代码、断言、依赖、根聚合、fixture 或 Git；未运行根 `:test`、其它模块或最终共同版本组合验证。I05 原 blocked/旧 2/16、R06 局部 2/2 保留；R07 completion record 不代替 R08 独立审计，R08 已完成并确认 W01 not ready。
- dependency/conflict：`MST-R06` 是恢复输入和成功前置；I05 原 blocked Result 仅提供待重验范围与失败历史，不是成功前置。R07 与 R04/I04/I05/R06 的共享 Gradle/Forge fixture/JVM 资源按上方 `resourceLocks` 串行，且必须在 R06 后执行。


## MST-R08 — 独立核验 W01 最终组合证据

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R07]
- predicate（保留 R08 时点）：独立检查当时其余九个 W01 item 的 Result 状态与证据、S1-S8、最终共同版本有限组合、必要共享回归、根接入和限制，形成 ready/not-ready Result；该检查已完成且结论 not-ready。
- recovery：completed 审计检查点继续属于实际 member；最终充分性由 MST-R10 在新 MST-R09 证据上判断，不要求 R08 旧结论改 ready，也不重复其已完成登记。
- evidence：独立核验范围、逐行证据索引、对 R07 完整 Result 的关联、最终组合证据核对及未满足项均登记在 adopted R08 Result 中。审计结论为 `W01 not ready`：R07 的 16/16 和历史已采用 Results 可支持其各自边界，但同一最终版本根 `:test` 三模块有限组合 artifact、完整逐行 S1-S8 覆盖和必要共享回归适用性证据仍缺失。
- completion record：Router 已完整读取并采用单一 R08 独立只读审计 Result，status `completed`、结论 `W01 not ready`。R08 支持 R07 16/16、三处 JDK17、Gradle 9.4.0、Forge fixture 与 clean module output 边界的逐行仓内证据；R01/I02/R03/R04/R05/I04 为已采用记录证据而非本次重跑。审计确认 R07 单项不补齐跨模块最终 gate；R08 自身不释放 W01。
- limitations：审计未写文件、未运行 Gradle/测试或 Git；R07 与 negative gate 结论置信度 high，历史其它项为 moderate，因为当时搜索仓内 docs/artifact 未见原始独立 R08 Result 副本，但这不否定 Router 已完整采用历史 Results。保留无全仓、游戏、下载验证限制。
- timing：审计当时看到 R07/R08 尚未登记并指出陈旧 pending；此前登记维护已经解决此时序缺口。当前四文档已登记 R07/R08，不把重复登记设为新前置；R08 真正未满足项由 R09/R10 承接，不改变 R07 的测试限制。
- dependency/conflict：只在 R07 Result 完整可关联后执行；不等待 W01 自身 gate，避免 gate 自等待。R08 是独立核验项，不替代任何成员 Result。

## 历史节点

### MST-I01 — blocked，零项目效果

保留原 blocked 与零效果事实，不属于实际 Wave member，不作为成功前置。

### MST-R02 — partial，根接线已完成

保留原 partial。根 build 三模块接线和 root-only dry-run 已完成；原有限实际运行 134 项＝133 通过、1 失败、0 跳过，Mixins 100/101、Fabric 17/17、Forge 16/16，根任务因依赖失败未执行。唯一失败是旧 numeric 拒绝期待；R03 校正，R04 完成剩余有限验收。不得将旧 Result 升级或将两个运行合并成一次全绿。

### MST-I03 — blocked，pipeline 草稿部分写入

保留原 blocked、交接计数差异及草稿部分效果；当前清单为 8 Java＋settings 共 9 文件。历史节点不属于实际 member，不原地重试、不改为零效果。未完成 pipeline 合同由 R05 承接且现已产生独立 completed Result；旧 blocked 状态仍保留。

## 最终组合恢复的单结果边界（R09/R10 历史准备）

以下保留上一轮 C5 的分组理由；R09/R10 已实际完成，历史准备文字不再描述当前执行状态。本轮维护与新分组见下方 F16 恢复合同。

| item | 唯一可观察终态 | 保持在内部的检查 | 独立边界与排除 |
| --- | --- | --- | --- |
| MST-R09 | 在同一最终工作树和环境，以根 `:test` 完成下列三模块有限实际组合，得到一份可关联的运行 Result 与当次 artifact。 | 版本/环境取证、root dry-run、有限过滤、必要共享消费者、TaskOutcome/JUnit/内容关联，只证明这一次组合结果。 | 运行失败可单独恢复；其证据被 R10 消费。不能合并独立验收或四文档结案。 |
| MST-R10 | 对 R09 及可复用历史作一次独立只读最终验收判断，明确 ready/not-ready 及逐行 S1-S8/gate 缺口。 | S1-S8、旧矩阵、共享回归适用性、源码/helper/Spec 链接、Results 与限制检查共用同一判断边界。 | 不运行测试、不修代码、不持久化四文档结案；completed 只表示判断完成，原gate另要求结论ready，现由R12承接、不改R10旧结论。 |

R09 的三个模块和共享消费者没有另拆：要求的是同次根入口组合 artifact，单模块成功不是这个结果；拆后再加独立组合会重复同一运行。R10 的逐项检查不另产独立 Results，也不调度缺口恢复。最终持久化记录仍是之后独立的文档动作，本图没有把它塞进 R09/R10，也不为尚未执行的记录新增 item。当时沿用两个新 ID，各一 item、一 Handler、一 Result；现已采用 completed，R10 结论 not-ready。

## R09 有限执行合同（已执行的历史合同）

所有路径以项目根为基准；命令工作目录固定为项目根。以下保留原执行合同；已采用实际结果见 R09 completion record，本次维护没有重跑。输入静态工程为 Mixins 的 `integration-test/mixins/ordinary`、`integration-test/mixins/pipeline`，Fabric 的 `integration-test/fabric`，Forge 的 `integration-test/forge`；路径均相对各自模块。

下表每行是整类 filter，包含该类全部现有方法；不使用全仓或平台全部测试 wildcard。Mixins 包名前缀为 `net.msrandom.minecraftcodev.mixins.`，平台包名前缀分别为 `net.msrandom.minecraftcodev.fabric.mixin.`、`net.msrandom.minecraftcodev.forge.mixin.`。R09 当轮计数为 101 + 14 + 16 = 131 个 @Test；已用同轮 JUnit 方法清单核对18类。后续原方法内扩断言可仍为131，不能误称新增方法；实际集合而非数字决定覆盖。

| 行 | 模块 / 类 selector（前缀如上） | 当前方法数 | 当次必须保留的观察 |
| --- | --- | ---: | --- |
| F01 | Mixins / [MixinPreapplicationTests][preapp] | 5 | 普通静态输入、1/42、JDK-only Map/Set handoff、真实 SPI、原输入、通知。 |
| F02 | Mixins / [MixinProducerTests][producer] | 18 | 精确 raw keys/父引用/跨输入、内容、原输入、producer 双输出、真实流/发布故障与 fresh retry。 |
| F03 | Mixins / [MixinMappingTests][mapping] | 8 | owner/overload/descriptor/direction、真实 refmap/context/MemberInfo、原通知键、缺 refmap 失败及流故障恢复。 |
| F04 | Mixins / [MixinInputBindingTests][input] | 16 | 全部十个 TestKit 场景和六个共享局部用例；A/B caller、两侧 Strip、缓存/当前输入/失败消费，以及别名、目录、独立 cleanup。 |
| F05 | Mixins / [MixinFailureStageTests][failure] | 9 | required/optional 真实阶段、通知与失败原因、不发布旧成功、动态/未知通知的原边界。 |
| F06 | Mixins / [MixinOperationIsolationTests][isolation] | 7 | 同 JVM 顺序/并发对照、冲突 writer、selector/TCCL/关闭、错误与 fresh retry；保留局部动态插件用途。 |
| F07 | Mixins / [MixinResourceTests][resource] | 7 | 资源发现、实际 read/close/cause/suppressed、释放与重试；不以 TestKit 代替。 |
| F08 | Mixins / [MixinSafeRetentionTests][safe] | 4 | 跨数组/JAR raw matches、嵌套全路径、未通知/空内容与原输入字节保护。 |
| F09 | Mixins / [StripMixinsTests][strip] | 11 | 独立参数/inputArtifact、真实 DOM/坏 ZIP、别名/硬链接/目录、失败不发布、entry 保持。 |
| F10 | Mixins / [StripRegistrationTests][registration] | 1 | 手写与 task cleanup、真实 DOM 错误、失败消费、合法空恢复及原输入不变。 |
| F11 | Mixins / [StripStreamTests][stream] | 2 | ZIP 内容/order/metadata、真实 bulk read/write/close、suppressed、失败后 fresh retry。 |
| F12 | Mixins / [ProducerDomTests][producer-dom] | 6 | installed DOM/UTF-8、真实 mapped injection、缺失/形状失败不复用旧成功。 |
| F13 | Mixins / [StripDomTests][strip-dom] | 4 | duplicate/unknown/raw string 与 installed DOM 一致、精确字符串/空数组、实现依赖跟踪。 |
| F14 | Mixins / [FixtureMixinRuleTests][fixture-rule] | 3 | 共享 Core MixinListingRule adapter 的关闭后 snapshot/remove 与 I/O 原因。 |
| F15 | Fabric / [FabricMixinApplicabilityTests][fabric-app] | 6 | 外部 environment 与内部 kind 交集、1/42、原通知和 inactive/input-owned 保留。 |
| F16 | Fabric / [FabricMixinMetadataTests][fabric-meta] | 8 | snapshot/current 编辑、未知/新增字段、SPI、AW/nested 保留、真实读写关闭故障及 retry（原合同）。R09实际8/8支持前述正常内容和六故障传播，但无故障后成功retry；R11补齐，R12判充分性。 |
| F17 | Forge / [ForgeMixinMetadataTests][forge-meta] | 14 | R07-01..14 原谓词逐行重跑，双 metadata/SPI/当前编辑/原输入与故障恢复。 |
| F18 | Forge / [ForgeAccessTransformAndJarJarCompatibilityTests][forge-compat] | 2 | R07-15/16 原谓词逐行重跑；实际非空 AT 的 public 成员、JarJar 精确删除、vendor 13 bytes 无 LF、nested 可重开。 |

必要共享回归明确包含 F02/F05..F14 和 F04 的六个局部方法：它们直接消费 ordinary/mapping/helper、生产 SPI、StripFixture 或同 JVM 状态。平台共享触及路径由 F15/F16 的 AW/nested 与 F18 的 AT/JarJar 覆盖。本轮不运行 access-widener/remapper 的 Minecraft 测试、Forge PatchedMinecraftTests、其它模块 test 或游戏/下载；构建这些模块的生产依赖与执行其测试不同。R10 按源码/输入/环境检验历史适用性，不要求为缺仓内原始 Result 重跑所有历史。

### 根入口命令与过滤

根 build 的 `:test` dependsOn 三模块 test；根本身没有测试时 `:test NO-SOURCE` 是预期，不能误报根执行了 131 个方法。根任务上的 --tests 不会传递给依赖模块，因此用一次临时 init script 给三项 test 精确设置 filter；不改仓内 build/settings/依赖。R09 已将下段保存为项目 build 输出下的临时 `build/mixin-final-r09/finite.init.gradle`，并核对合同文本；现存导航见 [当次 evidence](../../../build/mixin-final-r09/evidence.md)。下列命令只保留历史合同，不授权本次重跑：

```groovy
import org.gradle.api.tasks.testing.Test

def selected = [
    ':minecraft-codev-mixins': [
        'MixinPreapplicationTests', 'MixinProducerTests', 'MixinMappingTests',
        'MixinInputBindingTests', 'MixinFailureStageTests', 'MixinOperationIsolationTests',
        'MixinResourceTests', 'MixinSafeRetentionTests', 'StripMixinsTests',
        'StripRegistrationTests', 'StripStreamTests', 'ProducerDomTests',
        'StripDomTests', 'FixtureMixinRuleTests'
    ].collect { 'net.msrandom.minecraftcodev.mixins.' + it },
    ':minecraft-codev-fabric': [
        'FabricMixinApplicabilityTests', 'FabricMixinMetadataTests'
    ].collect { 'net.msrandom.minecraftcodev.fabric.mixin.' + it },
    ':minecraft-codev-forge': [
        'ForgeMixinMetadataTests', 'ForgeAccessTransformAndJarJarCompatibilityTests'
    ].collect { 'net.msrandom.minecraftcodev.forge.mixin.' + it }
]
gradle.projectsEvaluated {
    selected.each { projectPath, classes ->
        def p = gradle.rootProject.project(projectPath)
        p.tasks.named('test', Test).configure { t ->
            t.filter.setIncludePatterns(*classes)
            t.filter.setFailOnNoMatchingTests(true)
            t.maxParallelForks = 1
            t.doFirst {
                def launcher = t.javaLauncher.get().metadata
                println('R09 task=' + t.path + ' filters=' + t.filter.includePatterns)
                println('R09 launcher=' + launcher.installationPath + ' version=' + launcher.javaRuntimeVersion + ' vendor=' + launcher.vendor)
                println('R09 fixture.gradleJava=' + t.systemProperties['fixture.gradleJava'])
                println('R09 outer.java.home=' + System.getProperty('java.home'))
                p.configurations.getByName('testRuntimeClasspath').incoming.resolutionResult.allComponents.each {
                    println('R09 dependency ' + p.path + ' ' + it.id.displayName)
                }
            }
        }
    }
}
```

在 PowerShell 中先以已存在、实际核验的 Microsoft JDK17 路径锁定 JAVA_HOME/PATH（R07 的已采用路径为 D:/Applications/Scoop/apps/microsoft17-jdk/current，不凭路径名认定版本），分别记录外层完整 java -version 与 gradlew --version，再执行以下两条；不得让这段授权解释为现在运行：

```powershell
& "$env:JAVA_HOME/bin/java.exe" -version
./gradlew.bat --version
./gradlew.bat :test -I build/mixin-final-r09/finite.init.gradle --dry-run --offline --no-parallel --max-workers=1 --no-daemon --no-configuration-cache --console=plain
./gradlew.bat :test -I build/mixin-final-r09/finite.init.gradle --rerun-tasks --no-build-cache --offline --no-parallel --max-workers=1 --no-daemon --no-configuration-cache --console=plain --stacktrace --info
```

这四条输出属于同一 R09 的内部证据；dry-run 必须显示根与三模块 test，实际运行必须显示三个模块 test 均 SUCCESS/executed（非 UP-TO-DATE、FROM-CACHE、NO-SOURCE），JUnit 三模块逐类/逐方法 101/14/16，0 fail/error/skip。类缺失、过滤多跑/少跑或跳过均不能满足此谓词。外层强制执行与嵌套 TestKit 的 SUCCESS/UP-TO-DATE/FROM-CACHE/预期 FAILED 必须分层记录，后者按既有测试断言验收，不能把预期失败当外层失败，也不能把缓存恢复当新引擎运行。不修改既有 TestKit arguments 或 cache 流程来制造通过；JavaCompile/Jar 的任务结果取自 ORDINARY_INPUT/PIPELINE_INPUT/FABRIC_INPUT/FORGE_INPUT 及 fixture 日志，与输出内容一起关联；不是为每个不调用 Gradle 的局部断言虚构 TaskOutcome。

### 同轮版本、环境与证据保留

- 同一最终版本不只记录 HEAD：记录已采用 checkout 基线及未提交源码/构建/静态 fixture/测试 SPI 的实际内容标识和相对 R07/已采用 Results 的相关变化，包含未跟踪迁移输入；运行前后核对相关文件内容不变。HEAD 相同但内容不同不能宣称同版。无需新 ledger/schema，直接在单一 Result 说明范围、方法和差异。
- 记录 wrapper properties/JAR、实际 Gradle 版本、三模块实际解析 testRuntimeClasspath、插件版本依据与静态 fixture 的 host-supplied classpath；命令全程同一解析图。缺 offline 依赖、旧工具链不可用或结果与预期不同就报告运行缺口，不升级工具链、改依赖或增加 .gradle-user。
- 外层 Gradle JVM、三模块解析后的 tasks.test.javaLauncher、fixture.gradleJava 都须分别记录完整 java -version/实际路径，明确为 JDK17，并保留 JAVA_HOME/PATH 或 org.gradle.java.home 实际锁定方式及对应 Gradle --version。复用现有 JDK17 和 Java 11 编译能力；四个静态 build 的 release=11、UTF-8、-proc:none 与生成 class 的 major=55 可从编译参数/实际 JAR 关联核对，不设计升级。
- 不删除整个模块 build 或 user-home 依赖缓存；外层 --rerun-tasks --no-build-cache 建立本轮实际执行，保留 R07 现存证据。此边界不同于 R07 曾清 Forge build 的历史，不能声称本轮重新做过该 clean-cache 实验。
- 立即保留当次控制台、init script、三个模块 build/test-results/test 的 XML/报告、存在的 Mixins build/fixture-evidence 和两平台 build/platform-fixtures 中与方法相关的内容及 fixture 日志，避免后续运行覆盖。保存到既有 build 输出中的本轮目录即可，不建通用审计/ledger 系统、不要求完整原始 Result 副本。未来目录现在不是已存在 artifact 引用；新 Result 首次采用仍需 Router 完整读取与关联。
- 每个 F 行逐方法关联源码断言、JUnit testcase、当轮命令和相应内容。没有保留临时目录/fixture.evidence 时，用实际相关的 JUnit XML/system-out/控制台与源码断言关联；不要求不存在的 metadata retained 目录。R07-15/16 历史 retained 证据原合同不变，R09 的 F18 应保留测试实际产生的 retained-baseline 或等价可关联内容断言；缺少有效内容证据就标缺口。

## MST-R09 — 最终根入口三模块有限实际组合

- state: completed
- waveId: MST-W01
- prerequisiteItemIds: [MST-R05, MST-I04, MST-R08]
- handlerResult: one Handler / one Result
- predicate：满足上方 R09 执行合同，18 类在同一最终版本/解析图/环境通过根 :test 实际执行，形成逐方法可关联的三模块运行与内容证据；不拼接历史数字，不替代独立验收。
- evidence：F01..F18、dry-run 和实际根命令、三模块 SUCCESS/executed、131 个当前方法的 JUnit/断言关联及版本/JDK/输入内容/共享回归边界；发现源码方法数变化须逐方法解释，不能默默变更范围或原验收。
- completion record：Router 已完整读取并关联 execute-r09-final-root-combination/g1 completed。2026-10-18 根组合退出0，48 actionable tasks executed；18类131方法＝Mixins101/Fabric14/Forge16，0 failure/error/skip，三个模块 test 均 SUCCESS/executed，root NO-SOURCE正常。Microsoft JDK17.0.19+10-LTS（外层、3 launcher、3 fixture）与 Gradle9.4.0；538输入前后稳定、95份R07保全，实际内容/嵌套缓存/预期失败分层证据见[仓内当次导航](../../../build/mixin-final-r09/evidence.md)。R07全树hash缺失、build证据可清理限制保留。R10确认运行有效，但 R09 F16“retry”覆盖摘要过宽：本轮只执行了现存断言，未证明六故障后恢复；生产恢复失败也未被证明。
- writeOwnership：仅当次 Gradle/TestKit/module build 输出及临时工程/运行证据；不改生产/测试源码、fixture 源、构建/依赖、权威、四协调文档或 Git。不能借本项修测试或登记结案。
- dependency：R05 提供最终 pipeline/caller（传递消费 R01/I02），I04 提供 Fabric（经 R04/R03），R08 提供已采用缺口判断（经 R07/R06）；I05 blocked 仅作范围/历史输入，不是成功前置。R08 completed/not-ready 可以满足“已完成审计”输入，不满足最终 ready。
- conflicts：独占 root-gradle-test-state、forge-fixture-and-evidence、forge-test-task-jdk17 及 final-evidence-snapshot；与任何共享测试/构建、输出清理、源码/fixture/文档写入串行。没有可安全混写的并行路径。

## MST-R10 — 独立只读最终验收判断

- state: completed

- waveId: MST-W01
- prerequisiteItemIds: [MST-R09]
- handlerResult: one independent read-only Handler / one Result
- predicate：由不同于 R09 执行者的 Handler，消费完整可关联 R09 Result 及采用历史，按下表逐项完成 W01 最终验收判断，明确 ready/not-ready、未满足项与限制。检查完成可以是 completed/not-ready；缺必需输入无法检查时如实 blocked/partial，均不放行 gate。
- evidence：S1..S8 每行标实际方法/断言、R09 testcase/TaskOutcome/内容关联或历史 Result 的适用性理由；另检查 F01..F18 和 R07-01..16 全覆盖、实际验收成员、恢复承接及全部 gate 要求，不能只写“131 全绿”。
- completion record：Router 已完整读取并关联 audit-r10-final-acceptance/g1 completed，结论 W01 not-ready。独立只读审计核对131方法/JUnit/方法体、538输入、285冻结source、1339证据hash、95历史证据、R07全16行、实际字节/AT/JarJar及双语链接。唯一阻断为 [FabricMixinMetadataTests][fabric-meta] actualReadWriteAndCloseFailuresEscapeRemove:165–218 的六故障只有传播/关闭/identity/suppressed，无撤销后成功 handler.remove(temp) 和 metadata 内容；循环重写original不是retry。F16、S6及S8全矩阵充分性部分支持，其余原合同受支持。此为原 Plan S6/F16合同缺口，不是新要求或生产失败证明；R08旧缺口已由R09补足。审计未写文件/运行测试/释放gate。R10及I04过宽retry摘要不能弥补缺断言。
- recovery：本项检查完成不要求原结论改ready；R11补唯一缺口，R12独立判断最终充分性。
- writeOwnership：只读源码、文档和证据，仅返回 Result；不运行 Gradle/测试，不改四文档或其它仓内文件，不代替之后独立持久化动作。
- dependency/conflicts：须在 R09 Result 完整可关联、输出已稳定后执行；不等待 W01 gate，不自行释放 gate。final-evidence-snapshot 阻止审计期间 Gradle、输出清理及相关源码/文档写入；共享只读输入本身无冲突。

## S1-S8 到最终实际证据的验收映射

表内源码路径由 F 行链接唯一定位。下表保留 R10 原验收合同；R10 已作检查且仅 F16 retry 导致 S6/S8 部分支持，不能当作全通过。R12 继续用此表，以 R09 当次 testcase/内容、R11 新执行及最终实际 diff 逐行判断。历史采用不等于当前适用；必须比较相关源码/helper/fixture/输入/环境变化，注明可复用的范围、理由和限制。不能仅因缺仓内原始 Result 取消已采用的 R01/I02/R03/R04/R05/I04/R06/R07/R08 状态，也不能把已采用状态当作当前覆盖的充分证据。

| 成功条件 | 实际方法/断言与静态检查 | 新结果及历史适用性 / gate 用途 |
| --- | --- | --- |
| S1 | ordinary/pipeline/Fabric/Forge 静态 build/settings/src/variants 与 JavaCompile/Jar 输入，四 build 的 release=11/-proc:none；F01 realDifferentArtifactsAndIsolation、F03 realRefmapMemberInfoChainKeepsRawKeys、F04 testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations、F15/F17 的 producer 真实 1/42。对 ToolProvider/源码字符串/手工 JAR 的保留 caller 检查应说明局部故障、isolation 或独立 Strip 用途，并核对普通路径实际调用静态 helper。 | R09 fixture 日志+实际输入/内容；R10 只读调用点核对。R01/I02/R05/I04/R07 历史说明已完成替换；只复用未变边界，不据存在源码宣称执行。 |
| S2 | F04 testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations：A/B、双 Strip、applied-only、resolution-only/external、原输入；F02 exactRawKeysDuplicateSourcesArraysAndUnnotifiedEntries，F08 producerCleanupRemovesAllRawMatchesAcrossArraysAndDifferentJars / producerPreservesFullNestedConfigPathRatherThanBasename：1/42、原 config/entry key、跨数组/JAR、全路径与资源保留。 | R09 对应方法 JUnit/内容/通知/原输入断言；R01/R05 仅在相关输入/helper 未变处复用补充，不能代替本轮根组合。 |
| S3 | F04 testKitProducerCacheRestoreThenFreshAndRestoredTransforms、testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption、testKitNativeSelectorsAreNotOptionsWhileNativeValuesAndImplementationRemainInputs、testKitKotlinRuntimeContentsInvalidateAndRestoreCurrentOutputs、testKitTaskOnlyPluginBodyAndResourceChangesReexecute：SUCCESS/UP-TO-DATE/新 runner FROM-CACHE、两侧 Strip；body=45/resource=49、顺序=53/native=59（各自场景基线不同，按源码对应），runtime 内容变化与恢复后 42、mapping/context/side/unset/default 当前结果。 | R09 的嵌套逐阶段 TaskOutcome+消费内容；R05 历史与当前 caller/helper/Gradle/JDK 比较。外层 test 的强制执行不能替代内层缓存观察。 |
| S4 | F04 testKitTransformTracksParametersAndInputArtifactIndependently：cleanup-only/inputArtifact-only、{} 与 []、缺 cleanup/真实 DOM 失败；testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput / testKitFailedCurrentProducerCannotRouteOldSuccess：source/target/producer FAILED 无 CONSUMED，独立 applied-only=42；F10 handwrittenAndOtherTaskFilesDriveRealTransformAndFailedCurrentConsumption：is not a JsonArray、旧 caller copy 仍在但当前消费失败、合法空恢复。 | R09 当次方法与失败/恢复控制台/JUnit；R03/R05 原合同仍在，不恢复 numeric/路径额外拒绝，不以“曾失败过”替代本轮断言。 |
| S5 | F03 exactOwnerOverloadDescriptorReverseAndMissing / realRefmapMemberInfoChainKeepsRawKeys / noMappingLegacyRefmapAndContextOnly；F15 outerEnvironmentIntersectsInternalKindsAndRetainsInactiveOnly；F16 currentMetadataUsesCurrentZipValuesAndKeepsDiscoverySnapshot / actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits；F17 R07-01..14（含 manifestChangedReferencesRemainOutsideRemovalSet 的当前 Manifest/TOML bytes 原断言）；F18 R07-15/16 非空 AT/JarJar/nested。 | R09 8 mapping+6 applicability+8 Fabric metadata+16 Forge 的逐方法内容。I02/I04/R07 历史分别比较 mapping、平台 fixture/adapter 与环境，不将 R06 2/2 拼成旧 16/16，不扩大为全 MC/AW 认证。 |
| S6 | F02 originalConfigAndParentStreamFailuresBlockPairAndAllowFreshRetry / actualProducerGraphClosureAndMidStreamFailures：cause/suppressed、关闭与双输出失效；F03 recorderRefmapStreamFailuresKeepCauseCloseAndRetryWithExplicitContext；F04 taskInputsRejectRealWindowsParentAliasesAndHardlinksBeforeMutation / taskDirectoryInputsRejectDescendantsAndAllowAdjacentOutputs；F06 successFailureAndFlagOnlyInterruptionReleaseResourcesAndFreshRetry 及 selector 初始化/还原用例；F07 actualResourceReadAndCloseFailuresRetainCauseAndSuppression；F09 originalAndCleanupAliasesHardlinksAndDirectoryContainmentAreProtected；F11 actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh；F16/F17 真实 I/O 故障与 reset/retry。 | R09 已明确包含必要共享局部回归，JUnit 无 skip，原因/异常对象/关闭/TCCL/selector/原输入/新鲜重试断言按 F 行关联；R01/I02/R05/I04/R07 的未变历史可补充，TestKit 全绿不替代这些局部检查。 |
| S7 | 根 build dependsOn 三模块，R09 root-only dry-run 与实际三模块 SUCCESS/executed、18类方法清单；pluginUnderTestMetadata、fixture.classpath/testOutputs 和测试 SPI descriptor 接线；F01 kotlinProductsKeepStaticEntrySpiAndJdkOnlyHandoff、F14 三个 Core adapter 方法、F16 actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits、F17 actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy。核对 Java11 class major55 和三处 JDK17 的实际完整版本/路径。 | R09 新组合和环境 artifact 必需；R02/R04 可复用根接线历史，R04 101 实跑与平台 UP-TO-DATE 明确不是最终新组合。不得以 root NO-SOURCE 否定依赖模块真实执行，也不得只报 root 成功。 |
| S8 | R10 将每个 F 行、R07 原16行和 S1-S8 绑定实际断言/当次结果，核对 helper 删除/保留 caller、共享使用者和最终版本；核对双语 Spec 末尾 input-tests/mapping-tests 实际目标仍存在（本轮没有授权改 authority）。 | R09 同版组合 artifact 不可替代；现有双语链接仍指向 MixinInputBindingTests.java/MixinMappingTests.java，无删除/重命名就记条件不触发。R10历史判断保留；R12须在R11及最终diff基础上完整判断并结论ready、实际所有member completed+证据充分，才供Router判断W01；任何缺口保留not-ready。 |

[preapp]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java
[producer]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java
[mapping]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java
[input]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java
[failure]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java
[isolation]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinOperationIsolationTests.java
[resource]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java
[safe]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java
[strip]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripMixinsTests.java
[registration]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripRegistrationTests.java
[stream]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripStreamTests.java
[producer-dom]: ../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt
[strip-dom]: ../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/StripDomTests.kt
[fixture-rule]: ../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/FixtureMixinRuleTests.kt
[fabric-app]: ../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinApplicabilityTests.kt
[fabric-meta]: ../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt
[forge-meta]: ../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt
[forge-compat]: ../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt

## F16 fresh-retry 恢复的单结果边界

本节保留前次 C5 的恢复分组与合同；R11/R12 后续均已完成并采用，本次只将最终事实一致持久化，不执行下列合同。

| item | 唯一可观察终态 | 内部工作及分组检验 |
| --- | --- | --- |
| MST-R11 | F16 六种真实故障后各自成功 fresh retry、实际 metadata 内容正确，并有最终相关版本的聚焦执行证据。 | 测试扩断言、故障准备/撤销/必要输入复位、Fabric14方法回归、版本/证据关联仅证明这一测试恢复结果；六模式共用同一方法/断言合同，无单独迁移/发布/可消费Result，不逐模式拆项。可在原方法内扩断言，方法总数未必增加。生产修改、独立验收和四文档结案排除。 |
| MST-R12 | 对 R09＋R11 和适用历史独立判断最终 S1-S8/W01 ready 或 not-ready。 | 消费新Result，检查最终diff、复用/重验充分性、F01..18/R07全16行与各gate条件，都是这一判断的内部证据；不运行测试、不修代码、不登记结案。 |

R11 的修复与聚焦验证共用成功/失败/重试边界；不单产研究/测试审计结果。R12 的判断可独立成功完成为 completed/not-ready，其 Result 被 gate 消费，且必须由独立 Handler 进行，故不能与 R11 合并。其后持久结案不混入二者，也未新增未授权执行项。每项各一 Handler/一 Result。

## MST-R11 — 补齐 Fabric metadata 六故障后的 fresh retry

- state: completed
- completion record：Router 已完整读取并可靠关联 implement-r11-fabric-fresh-retry/g1 completed；六模式真实失败后同 handler/native temp 实际 remove 成功、精确 DOM/id/custom/无 mixins 及 snapshot/source 保护成立，原 hit/close/identity/suppressed 未弱化。本轮完整 Fabric14 实际执行14/14、0 failure/error/skip，三处 Microsoft JDK17.0.19+10-LTS、Gradle9.4.0；证据见[仓内新执行导航](../../../build/mixin-r11/evidence.md)。
- waveId: MST-W01
- prerequisiteItemIds: [MST-R10]
- handlerResult: one Handler / one Result
- predicate：仅扩充 [FabricMixinMetadataTests][fabric-meta] 的 actualReadWriteAndCloseFailuresEscapeRemove（当前165–218）及必要同文件断言；六模式各完成真实失败、保留原传播/关闭/identity/suppressed断言、撤销故障并必要输入复位、成功 fresh handler.remove(temp)、读取实际metadata并验证精确结果/保护；同一最终相关版本聚焦 Fabric 全14方法本轮通过，形成一份可关联 completed Result。不能仅恢复original、调用新handler正常编辑或引用旧8/8充作失败后retry。
- writeOwnership：仅该 Kotlin 测试文件及当次 Gradle/TestKit/build 输出和临时运行证据；不改 production、FabricInputs/helper、静态fixture、build/settings/依赖/工具链/authority、四文档或Git。若最小断言补齐暴露生产失败或确需额外写面，保留已完成效果并报告具体缺口，不借此项扩权或削弱断言。
- dependency：R10 completed/not-ready 提供已关联的唯一缺口及原合同判断；经 R10→R09 消费冻结组合/源基线，再经 R09 消费 R05/I04/R08 和历史输入。not-ready 是已完成审计输入，不是成功retry证据，不要求旧判断ready。无 W01 自等待，也无 I05 blocked 成功前置。
- conflicts：独占 root-gradle-test-state、fabric-test-and-fixture-evidence、final-evidence-snapshot；与相关源码/文档写入、Gradle/TestKit、输出清理和 R12 串行。R07/R09冻结证据不得覆盖或删除，保存新证据与旧artifact分开；此为原串行合同；R11/R12 已按已采用 Results 完成。

### 六模式准备、reset 与内容判据

当前源码以 metadata-duplicates 静态JAR中的 fabric.mod.json 为 original，在 native temp 上加载一次 handler（snapshot含 a.json/client、b.json/server、a.json/server），失败调用为 handler.remove(wrapped(temp))。自定义 provider 真正先读底层channel或写底层stream，再抛故障；不能替换为模拟直接throw。每种模式必须在下一轮重写original前完成本轮成功retry，否则仍只是下次失败准备。

| 模式 | 保留的真实故障/关闭合同 | 撤销与必要输入复位后再执行 |
| --- | --- | --- |
| read | channel.read之后抛原IOException；input关闭、identity，suppressed为空。 | 先断言temp metadata原字节不变，不作掩盖性复位；用 native temp 绕开故障provider，对同一handler重新remove。 |
| read-close | 真实read完成、input channel关闭后抛原IOException；不得打开writer。 | 先断言原字节未变；同上重新remove。 |
| read-close-suppressed | read抛主异常，已关闭channel再抛closeFailure，精确suppressed对象/顺序保留。 | 先断言原字节未变；同上重新remove。 |
| write | input先关闭，writer实际写一个byte后抛主异常，output关闭。 | 失败可能截断metadata；记录/保留实际失败观察后仅将temp/fabric.mod.json复位为original，再用native temp重新remove。 |
| write-close | input先关闭，实际完整write、output关闭后抛主异常。 | 不假设写失败原子回滚；仍允许仅复位temp metadata作为相同起点，再用native temp重新remove。 |
| write-close-suppressed | 实际写一个byte后抛主异常，output关闭并抛closeFailure，精确identity/suppressed保留。 | 只复位受损temp metadata，再用native temp重新remove；不得把复位操作当成功retry。 |

所有模式保留 hit、inputClosed、outputOpened/outputClosed、closed、assertSame(failure, thrown) 以及原 suppressed 判据；读失败不得开始写，写必须在input关闭后。撤销可以沿用同一handler但传原生temp（不再走wrapped故障provider），无需新生产开关；fresh表示故障后的新一次实际读写调用，不要求重新发现handler或新增TestKit运行。若选择同provider禁用故障，必须证明已撤销且实际重新读写，不改变原失败断言。

每轮 retry 后读取 path 的实际 JSON，精确等于 {"id":"demo","custom":{"keep":true}}，没有mixins且未知custom保持；handler.references snapshot保持原值，读写句柄已关闭，文件可再次正常读取。保留 source JAR bytes 前后完全相同，临时目录中既有非metadata输入（如有）不得被reset/retry修改；reset不得动静态源/fixture/源JAR或以预写期望结果代替handler输出。这里仅补原精确删除/原输入保护/失败后恢复合同，不增加原子失败发布要求；原来允许的部分写入不会被伪称生产回滚失败。

### 最小执行与证据适用性安排（已执行合同）

- selector精确为 net.msrandom.minecraftcodev.fabric.mixin.FabricMixinMetadataTests.actualReadWriteAndCloseFailuresEscapeRemove；最终聚焦执行选择完整类 net.msrandom.minecraftcodev.fabric.mixin.FabricMixinMetadataTests（8方法）和 net.msrandom.minecraftcodev.fabric.mixin.FabricMixinApplicabilityTests（6方法），覆盖唯一改动类和共享 [FabricInputs](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricInputs.kt) 的两个现有消费者。以实际方法集合核对14条JUnit，0 failure/error/skip；同方法扩断言不宣称新增方法或新132总数。若有真实方法变化逐一说明，不能变更原覆盖。
- 原方法单跑可作调试但不是另一个独立Result或必须再跑一次的前置；下列一次完整Fabric执行已包含该方法和六模式。R11 已执行的命令合同（本次不运行；工作目录为项目根）：

```powershell
./gradlew.bat :minecraft-codev-fabric:test --tests net.msrandom.minecraftcodev.fabric.mixin.FabricMixinMetadataTests --tests net.msrandom.minecraftcodev.fabric.mixin.FabricMixinApplicabilityTests --rerun-tasks --no-build-cache --offline --no-parallel --max-workers=1 --no-daemon --no-configuration-cache --console=plain --stacktrace --info
```

- 执行前锁定并实际核验与R09可比较的Microsoft JDK17：外层JAVA_HOME/PATH或org.gradle.java.home及对应完整java -version、gradlew --version；分别记录解析后的Fabric tasks.test.javaLauncher和fixture.gradleJava实际路径/完整版本，三者均明确JDK17。R09为17.0.19+10-LTS、Gradle9.4.0，路径 D:/Applications/Scoop/apps/microsoft17-jdk/current，不能只凭路径名认定。复用wrapper/解析依赖与release11/UTF-8/-proc:none，不升级/装工具链或创建新Gradle user-home。
- 外层Fabric test必须SUCCESS/executed，非UP-TO-DATE/FROM-CACHE/NO-SOURCE；记录真实TaskOutcome/JUnit/当次命令和六模式实际断言，嵌套FabricInputs assemble的JavaCompile/Jar及缓存按原行为另列，不修改helper/runner缓存来制造通过。passed单方法结合含六模式的冻结新源码/断言能关联每模式，不要求虚构六个JUnit testcase或不存在的retained目录；断言/控制台应能定位具体mode失败。保留当次XML/system-out/日志、测试与helper实际字节和metadata内容断言；临时文件被清理时用可关联JUnit＋源码断言，不伪造永久文件。
- 保全R09 build/mixin-final-r09及R07现存95份证据，不删整个module build/user-home；可在build输出下独立新轮目录保存聚焦证据（未来目标，不是已存在artifact，不新增通用receipt/schema）。新 Result须记录修改前/后及运行前/后的相关内容标识、实际diff、命令/fixture/环境/解析图、每模式failure→reset→retry→内容的关联、14方法精确集合和限制，供Router首次完整读取/关联。
- 重验决策以实际写面为准：若仅该方法新增断言、生产/helper/fixture/构建/依赖/SPI不变，Fabric14覆盖唯一改动及共享helper消费者，R09的根接线、其余F行、缓存/字节/AT/JarJar/共享局部运行可按未变输入/环境复用；不无依据再跑131，也不把两轮拼作同一新版本131执行。R09已满足原同次根组合合同，S8仍要求R12证明基线到最终测试版本的差异不影响未重验结论。若diff或环境/解析图变化影响其它消费者，明确受影响F/S、最小补验和理由；超出本项写面需报告，缺必要组合证据则保持not-ready，不能偷偷降低共同版本/共享回归门槛。

## MST-R12 — F16 恢复后的独立最终验收

- state: completed
- completion record：Router 已完整读取并可靠关联 audit-r12-fabric-retry-final-acceptance/g1 completed/ready。独立审计逐行支持 F01-F18、R07-01..16、S1-S8 和十三 member predicates；五文件实际差异及未变 production/helper/fixture/build/deps/SPI/环境/解析图支持 Fabric14 必要重验与 R09 原同次131复用，无剩余阻断或额外补验。Router 随后已核定 W01 satisfied/released；本项审计自身未释放 gate。
- waveId: MST-W01
- prerequisiteItemIds: [MST-R11]
- handlerResult: one independent read-only Handler / one Result
- predicate：由不同于R11执行者的Handler，消费完整可关联R11 Result与R09、R10及历史，在最终相关版本完成全部原F01..18/R07-01..16/S1-S8和W01验收判断，结论ready/not-ready并列明未满足项/限制。completed仅表示审计完成，gate还要求ready；必需输入缺失如实blocked/partial，不把缺口转移为隐式豁免。
- evidence：先核对R11实际写面与R09冻结 sources/、inputs-before/after 的逐文件diff（包含未提交/未跟踪相关输入），区分本轮四文档修改与后续测试修改，不宣称整个工作树仍同字节。核对最终生产/测试/helper/fixture/构建/依赖/SPI与环境、解析图；每个差异指明F/S影响、采用新执行或可复用R09的理由和限制，缺无法比较输入不得假定未变。
- acceptance：六模式各自先真实失败、撤销故障/仅必要输入复位、同handler新调用成功、实际metadata正确，原cause/close/identity/suppressed/源保护仍在；核对完整Fabric14当前方法、executed及0failure/error/skip，将新断言与当次JUnit/内容关联，闭合F16/S6。按上方S表复用未影响的R09根组合与其它行而非拼接新131，核对helper调用/双语链接条件及最终适用性闭合S8。其它F/S或必要共享回归如受diff影响必须有补验，不以R11通过自动宣布全矩阵充分。
- history/gate：十一项既有completed均保留；I05原完整义务由R07承接，R06只局部2/2；R02 partial、I03 blocked/草稿、I05 blocked/部分效果及R08/R10各自not-ready检查点不升级。核对十三实际members、依赖和W01全部gate条件，缺仓内历史完整原始Result本身不重开历史；R07完整树hash缺失、build证据可清理等限制继续说明。
- writeOwnership：只读源码、四文档和证据，仅返回一份Result；不运行Gradle/测试、不清输出、不写项目/Git、不执行文档结案或释放gate。
- dependency/conflicts：R11提供最终测试与实际聚焦证据；传递消费R10/R09及全部必要历史，无冗余的直接R09/R10成功边，无W01自等待。须待R11结束、Result完整可关联、证据稳定，独占final-evidence-snapshot和fabric-test-and-fixture-evidence，与Gradle/输出清理/相关源码文档写入串行；其它纯只读输入不冲突。


## 当前作者语义自检（F16 恢复图，非独立 review）

本节为前次 F16 收口的历史作者检查：当时检查十三member、R11 Fabric14/R12 ready、W01 satisfied/released、引用及旧图无环，未运行测试或自行放行gate。build可清理/R07全树hash缺失等限制保留。该自检关于S1/S8无遗漏的充分性不适用于当前组织；本轮检查见下方W02。

## MST-W02 残留生成链恢复图

- state: satisfied
- completion record：Router已核定全部原gate条件满足；20个实际成员completed已采用、R26独立ready。仅记录既成satisfied判断，不由本Handler释放gate。
- itemIds: [MST-R13, MST-R14, MST-R15, MST-R34, MST-R17, MST-R18, MST-R19, MST-R20, MST-R21, MST-R35, MST-R24, MST-R25, MST-R26, MST-R27, MST-R28, MST-R29, MST-R30, MST-R31, MST-R32, MST-R33]
- prerequisiteWaveGates: []
- outcome：11类中仍承担静态迁移职责的固定输入及完整caller静态承载、生成入口删除/限定；StripStreamTests固定stream-copy基线依用户确认保留动态生成，例外不扩散且原内容/隔离/缓存/输入保护/故障/无残留/fresh retry保证不减；最终组合与独立审计证据齐备。
- recoverySubstitutions：MST-R16移出实际itemIds，保留为historicalWaveId=MST-W02的blocked节点；MST-R34是唯一实际成功owner，完整承接P16迁移、显式fixture JDK接线及最终相关版本59方法/内容/证据义务。R34 completed须有完整可关联Result和下述证据，不能自动把R16升级、满足旧item或释放gate；Router仍逐项核定替代承接及全部原gate条件。不要求旧R16变为completed，也不豁免其原完整保证。 MST-R22同样移出实际itemIds，保留historicalWaveId=MST-W02、state=failed及generation1无终态/候选撤回/旧driver34通过事实；MST-R35是其唯一有效成功owner，完整承接原固定archive迁移、等价、删除与回归义务，改为用户已确认的对应测试资源承载。R24/gate须消费R35新的完整可关联completed Result并核对承接，不要求旧R22升级、不再次resume、不把旧34当新验收。 R23移出实际itemIds，保留historicalWaveId及错误完成声明/审计/旧候选；限定动态例外没有替代成功owner，不要求旧R23升级或补做迁移，不登记新completed/failed。
- gate：20个实际member的真实完整可关联completed Result均须已采用，其中17个静态迁移owner含R34替代R16、R35替代R22；不要求R23 completed或资源化证据。R24逐caller核对限定例外及全部原保证、其他固定入口收敛；R25同次有限组合及真实静态消费满足下文，含G11原两方法；R26独立结论ready。11类/S1–S8/G01–G18/F01–F18/R07全16行逐条充分，所有保留动态操作有具体必要性与caller或StripStreamTests明确例外。缺项/partial/blocked/failed/非ready不释放。历史R16/R22与R23例外不计实际member、不要求升级；Router独立判断release，作者维护不完成item或放gate。

### 边界、写面与验证通则

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> R13–R15/R34/R27–R33/R17–R21及R35已采用completed仅作背景，不另登记或重验；原pending文档投影不重置已采用历史。R23仍现场生成且原Result身份未知，不作为成功前置。历史首次独立review completed/not-ready、细分局部completed/ready及R23候选独立review通过但用户未批准均保留；旧ready不覆盖本次例外与连接变更。本轮只作作者自检，尚无针对本次material边界的独立review证据，受影响边界仍依既有职责等待独立review/Router准入判断，本轮不执行或新增审批协议。用户动态例外决定已明确，不再等待资源化候选确认。R16 blocked及八路径/59、R34承接、R22 generation1无终态/诊断/resume generation2 failed/候选撤回/旧34、R35新34均保留，不再次resume或升级旧failed。

R35的21包资源归属/处理、类内copy、固定caller替换/删writer及改后34方法已共同形成采用终态，不重开或并入R23。R23资源化候选独立review通过但用户未批准，现明确excluded / exception：约40KiB随机payload不值得打包，保留Random(31)/JarOutputStream/cleanup动态生成与原期望值/断言。当前不创建strip-stream资源/copy、不新增候选长度/hash断言、不删该writer、不要求其17方法迁移验收；例外仅限该固定stream-copy基线打包，其他静态owner和全部原保证不减。其他caller迁移仍可独立消费，helper增量兼容，共享写面只串行、不制造成功依赖。

全局生成入口收敛R24只消费17个有效静态迁移owner的真实完整可关联、证据充分的completed Result；R25同次组合、R26只读充分性各有独立终态。R16全部义务由R34/P16/G04承接，R22全部义务由R35及五类34方法承接，不转给收敛项代做。R23只留历史/限定例外记录，无当前实施Handler或新Result；R24核对其仍动态生成及全部保证，不能代做旧候选或把例外当静态完成。

写面：其他静态item仍限相应Mixins测试、既有ordinary/pipeline工程最小variants/完整caller、R35专属src/test/resources说明/hash与必要OrdinaryInputs/PipelineInputs/StripFixture/helper；复用既有属性、pluginUnderTestMetadata/classpath/testOutputs/SPI。StripStreamTests例外不新增stream资源/copy/断言或删除其固定writer，不扩展到其他owner。现有inputs.dir够用则不改模块build，不增属性/框架/DSL/manifest/receipt/CLI/includeBuild，不改production/deps/lock/authority/根接线/JDK策略，不删除或重命名Spec测试链接目标；额外写面或行为变化报告精确边界。本轮实际只写Work/Context/Plan/Waves四文档。

普通输入Result仍给固定输入→真实JavaCompile/Jar任务名/TaskOutcome→copy/consumer→内容断言；R35给冻结输入→src/test/resources→既有processTestResources输出→classpath流→私有copy→真实consumer/断言及五阶段整包/cleanup hash，不虚构编译或新增fixture前置。StripStreamTests例外继续动态生成，不要求资源hash/资源消费证据或新增候选冻结断言；正常metadata、流故障/关闭/identity/suppressed、输入保护/无残留/fresh retry仍须真实核对。其他新固定源码沿用release11/UTF-8/-proc:none、major55和隔离sourceSet；原ordinary/pipeline任务/模式、真实任务名称登记、diff/输入/源码/fixture/build/SPI内容标识和命令/环境/删除入口/caller证据合同不减。

### MST-R13 — 隔离输入 variants

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G06全类方法（下表）；共享回归同表。
- 固定输入：`r04/Plugin.java`，11/22/33/44 四个同 FQCN 依赖类（markerN/domainValue 与 origin-resource 一致），三种真实 service descriptor、坏 ASM/Mixin class bytes、must-not-discover fixture.list、含 33 的 mod、含 44 的 target、bare mod 及普通 control 模板。为这些固定源码/资源定义隔离 sourceSet/Jar，绝不进入宿主 test classpath；宿主 domainValue=99 竞争不变。
- 删除/限定：替换 `prepare` 的复制源码再编译、`compile`、`dependency(int)` 的源码拼接、`plugin`/`mod` 和各固定 dependency/target/bare Jar 打包调用。只让 `run` 在副本内替换 label/side/mode/绝对 ready/gate 路径；control 临时重包是跨操作真实同步所需。`normalizedTarget` 的 sessionId 归一化为输出比较，应保留。
- 完成谓词：七方法通过，真实 11/22 顺序、33/44 排除、class/bytecode/resource/metadata 一致优先级、宿主99与有效竞争 SPI 隔离、Jar URL 读取、同 JVM 串行/实际重叠、独立 session、TCCL/selector/关闭、权限/中断/冲突 writer/fresh retry 均保持。共享回归：G02/G03/G04/G07 调用 selectors/normalization；若改共享普通 helper，加完整 G01–G14。

### MST-R14 — 映射隔离与固定 refmap 输入

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G03全类方法（下表）；共享回归同表。
- 固定输入：两个同 FQCN `mapping.TracePlugin` isolation-A/B 源码（loads、operationProbe、remapper 1/0、tick/run 期望），已有 trace plugin、mapping-target/mod、named/default/legacy refmap/config 与 RawFix 布局；复用 ordinary 的 mapping/mappingTarget sourceSet 模式，固定资源放 variants。
- 删除/限定：删除 `isolationPlugin` 的源码读取/字符串 replace/写 .java/ToolProvider/遍历 classes 现场打包；`refmap` 和普通 trace/config/legacy 基线改读静态 variant。保留 realRefmap 的当前 mapping 字节变化、坏 tuple/缺文件/context 参数及 recorder 流故障。`operationProbe` 固定源片段在本项静态插件中承接，不因此等待 FailureStage 的后续迁移。
- 完成谓词：G03 八方法保留 owner/overload/descriptor/direction、SRG、原键与真实 MemberInfo/refmap/context，same-JVM mapped A→unmapped B、loads=1、remapper1/0、tick/run、side/TCCL 和实际输出调用；missing usable refmap/流 close/cause/retry 不弱化。共享回归 G01/G02/G12，必要共享 helper 闭包 G01–G14。

### MST-R15 — 阶段失败与通知固定基线

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G05全类方法（下表）；共享回归同表。
- 固定输入：Context/Main/Access/Apply/Final/Pre、PreInject/PreInfo/Register、三种 POST/EXPORT Register、Trigger/Late/Dynamic/late.mixin.Late/Unavailable、固定抛错插件、required/optional、双目标/双 config/重复 section、known/runtime nested/mirror raw-key variants。先比较已有 two-targets/two-configs 内容才复用，不能以名字推断等价。
- 删除/限定：替换 `fixture`/`compile`、`plugin`/`config` 的固定源码/配置拼装与整包；删除 Runtime javac。保留真实 callback 内破坏 coprocessors、export 抛错、70000 NOP、getMixins/Mixins.addConfiguration 与 recorder/ASM 通知观察；major=100 两字节/minVersion=999.0 局部变异、权限拒绝仍在副本发生。
- 完成谓词：G05 九方法验证 optional/required 原阶段、底层 cause、通知原键/unknown/dynamic、不撤销已知键、无成功 pair 与原输入；不得换成 javac 提前失败。共享回归 G02 的通知/故障消费者、G03 使用 operationProbe 的固定插件、G08 retention；若共享 helper 改动扩至完整闭包。

### MST-R16 — 完整 pipeline caller

- state: blocked
- historicalWaveId: MST-W02
- replacedBy: MST-R34
- history：原业务Result为blocked（声称缺Handoff、未做项目工作）；已采用诊断确认实际8源码路径迁移、首轮classpath失败/修正与最终59/59通过。包装completed只表示返回，不覆盖业务blocked。原完成谓词与保证保留如下，成功义务由R34显式承接；不原地重试、不重做静态四文件。实际效果及证据局限见[Context恢复记录](context.md#r16-实际效果与证据边界)。
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法；唯一迁移验收子集为下方P16六方法。共享回归G02/G03/G05/G06实际taskProducer/replace/plugin/junction消费者、G10插件接线；PipelineInputs/OrdinaryInputs接口变化则扩完整闭包。
- 固定输入/写面：仅`pipelineProject()`消费的完整settings/build/gradle.properties与`pipeline-caller.gradle`，六个pipeline Jar、mapping、probe基线及plugin40/43/resource；放现有pipeline/callers/pipeline，以fixture.pipelineProject定位。第572行追加的固定implementation-input断言并入此静态build。保留consumeA/B dependsOn、cleanup direct inputs.file及probe direct cleanup；probe原样重包改copy。
- 删除/限定：此caller不再project(body)/settings/cache拼接；保留当前plugin body/resource、config/refmap、mapping/side/context/native、输入顺序、当前implementation class复制/资源变化、cleanup损坏/inputArtifact最小变异和真正失败注入。
- 完成谓词：此静态caller实际消费产物，P16六场景的A/B、双Strip、applied-only、resolution-only/external排除、缓存/当前内容、失败不得路由旧成功和原输入保护等价。defaults/native/runtime/task-only及直接组件未迁不影响本项保留；project(String body)在仍有caller时不删。写面与R27–R33共享类/helper/静态工程及Gradle状态，仅按冲突顺序串行，无成功依赖。

### MST-R34 — 恢复 P16 显式 fixture JDK 接线与原完成谓词

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- terminal predicate：在保留R16既有静态caller迁移效果的最终相关版本，P16 caller的org.gradle.java.home显式跟随fixture.gradleJava；同一修正版本G04全16＋G02全18＋G03全8＋G05全9＋G06全7＋G10全1＝59方法实际通过，P16六方法的完整流/缓存/当前输入/失败/保护合同与静态消费均有可关联证据，足以承接R16原完整完成义务。必要接线修复和回归只证明这一个P16完成终态，不拆独立证据Result或新增证据体系。原59是历史观察，不能移作改后通过；不是共享61或77方法。
- 输入/历史：消费原R16 blocked及已采用诊断/部分效果，R13–R15已采用completed背景可复用，不重做它们；这些历史输入不是R16 completed成功前置。原八路径、59精确执行、静态copy和缓存失败内容可以作为旧版本对照，适用性须按source/inputs/environment/freshness说明；原无效before、首轮完整日志缺失永不补造。诊断completed不是本项实施completed。
- writeOwnership：仅P16专用pipelineProject的临时副本JDK适配及必要同域helper/静态caller接线（[InputBinding][input]及现有pipeline/callers/pipeline，必要PipelineInputs内部实现），保留静态模板可移植；不把机器绝对JDK写入静态仓内模板。不重迁现有build/settings/properties/script或六Jar/mapping，不改变defaults/native/runtime/task-only及R31–R33职责，不删仍有caller的project(String body)。不改外层JDK政策、公共接口、模块build/系统属性集合、production/deps/lock/authority；确需越界或material风险变化须报告影响边界。
- 接线证明：旧project(body)显式写入org.gradle.java.home=fixture.gradleJava，新caller遗漏而PipelineInputs assemble的-D参数只锁另一工程。恢复须证明每个P16 caller的实际Gradle运行均取得同一fixture.gradleJava显式值（包括新runner/cache/probe/失败路径），不能只观察本机恰为17；同时保持consumeA/B producer dependsOn、cleanup直接inputs.file和probe cleanup直接输入。沿用既有属性与跟随策略，不新增JDK政策。
- selector/完整方法：task为:minecraft-codev-mixins:test，完整六类selector及精确59方法取下方G04/G02/G03/G05/G06/G10表；P16的六方法一字不减，由下方P16/R34行唯一分配。使用通则原命令形状及六个完整类--tests，外层SUCCESS/executed、0failure/error/skip；单方法debug、旧59、UP-TO-DATE或FROM-CACHE外层结果均不代替此轮验收。只有真实公共接口/普通writer变化影响更多消费者才按实际闭包扩验，不能因内部copy列表变化机械扩至101。
- 版本/环境证据：修正执行之前取得真实相关输入/源码/fixture/build/SPI/未跟踪输入内容标识，保留实际diff（含8路径归因）及修改后、运行前后标识；与R15有效run-after清单仅有限比较，不把残留目录项算R16删除。该新修正版本前后标识不能填补原R16运行前快照缺口。记录实际命令、wrapper/Gradle版本、插件与testRuntimeClasspath解析图及host-supplied classpath；分别记录外层Gradle JVM、解析后的tasks.test.javaLauncher、fixture.gradleJava完整实际版本/路径，三者JDK17，外层JAVA_HOME/PATH或org.gradle.java.home实际锁定方式及对应--version。另关联P16显式fixture JDK接线，不以三层版本相同替代接线证据。
- 内容/静态消费证据：固定输入→实际compileTargetJava/compileSourceJava/compilePlugin40Java/compilePlugin43Java及六基础Jar/resource-first/mapping实际任务名和TaskOutcome→私有copy→P16六方法当次XML/日志/断言逐项关联。资源Jar不虚构编译；源码release11/UTF-8/-proc:none、major55。完整流A/B、1→42、原键/资源/原输入、双Strip/applied-only、resolution-only/external排除；producer SUCCESS→UP-TO-DATE→新runner FROM-CACHE及fresh/restored双Strip内容；参数/inputArtifact独立变化、空/缺cleanup/坏DOM；source/target Strip及当前producer真实失败不能消费旧成功而已完成applied-only可用；当前body/resource/config/refmap/mapping/side/context/native/顺序/implementation和handoff损坏恢复全部保留。
- 证据保全：沿既有build/fixture-evidence及单一Result保存当次命令/XML/日志/实际内容，覆盖前保全旧轮相关文件；只引用主日志/XML实际关联的runs，不把retained目录残留全算本轮。保留首轮classpath失败及classloader修复因果，首轮完整日志已覆盖只可用已采用原工具事实。无需新ledger/receipt或原文归档，禁止清整个build/user-home；可清理build/临时工程与历史缺失限制明确保留。
- conflicts/successor：与R16及全部残留项共享InputBinding/PipelineInputs/静态工程、Gradle/TestKit/JVM/cache/模块输出/证据快照排他锁，按下方R16结束/资源释放→R34→R27串行；R16 blocked不成为成功边，R27–R33没有R34成功前置。R24必须消费R34有效completed Result承接P16，不能替R34补迁移或凭诊断放行；R25同次组合、R26独立ready与W02全部原gate义务仍各自必需。

### MST-R17 — 独立 Strip caller

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G10全类方法（下表）；共享回归同表。
- 固定输入：完整 independent-strip settings/build、初始 cleanup.json/task-input.json、mod.client-1.2.jar 的 fixture.json、非 metadata 的 fabric.mod.json 与 missing fixture.list；Jar 由静态任务生成。caller 可放现有 pipeline/callers/strip 子目录以沿用现有路径接线。
- 删除/限定：替换唯一方法的 JarOutputStream、settings/build 拼接与初始固定文件写入；仅在副本补 JDK 路径与切换 taskSet、task-input 的有效→坏 DOM→{}。`writeRemovals` 和真实 Transform 注册仍执行；不增加 producer 或通知来源校验。
- 完成谓词：G10 唯一方法精确 Keep 与 Good/Good 结果、writeRemovals SUCCESS、坏 DOM 下 consume FAILED/无 STRIP-CONSUMED、合法空恢复、旧 caller copy 可在但当前消费失败、原输入 bytes 不变。共享回归 G04 参数/inputArtifact 与失败消费方法；若碰 StripFixture，加 G09/G11/G13。

### MST-R18 — 宿主竞争输入

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G01全类方法（下表）；共享回归同表。
- 固定输入：现有 ordinary 主链保持；含坏 Intrinsics.class 的 competing Kotlin runtime Jar 交静态资源 Jar 任务。
- 删除/限定：删除 `kotlinProductsKeepStaticEntrySpiAndJdkOnlyHandoff` 内固定 competitor 的手工 Jar 构造。共享 `jar(name,entries)` 仍有其它测试与真正当前输入 replace 调用，暂不删、不提前改其 byte/ordering 语义；`fixture`/`config`/`ordinaryJar` 保持静态复制。
- 完成谓词：G01 全五方法保持 Kotlin static entry/SPI/JDK-only Map/Set、真实1→42、竞争输入隔离、原通知/原输入、异常路径。共享基类接口若未变无需重跑无关类；若变更则 G02–G08/G12 直接实例化消费者，及经 StripFixture 的完整闭包。

### MST-R19 — producer 固定资源与边界基线

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G02全类方法（下表）；共享回归同表。
- 固定输入：Random(42) payload、目录/空 entry/指定 timestamp/乱序 target，reserved class、Unicode escape/引号 raw path、required/坏 JSON、parent visited/stream-parent source、runtime/plugin-resource 与 task 输入 variants。可复用 producer sourceSet 的 aaa/Helper 等；输入随机 bytes 固定存资源，不现场生成基线。
- 删除/限定：迁移 streamedResources、reserved-class、Unicode、required/malformed、parent-stream/task 的固定 Map/源码资源拼装和 JarOutputStream；保留 `lifecycleBytes`/`lifecycleHost` 对当前生产 class 插桩/defineClass、child 探针、真实 graph/stream/read/write/close/第二 move、alias、旧 pair 失效和 fresh retry。不得预存生产字节。
- 完成谓词：G02 全18方法保持资源/order/time=0/DEFLATED/bytes、1→42、raw keys/父路径/通知、双输出与原输入、全部真实故障命中/identity/suppressed/关闭/重试。共享回归 G03 的 LifecycleIO、G05/G07 的 producer helpers、G04 task 接线与 G08 retention；改普通 writer 时完整闭包。

### MST-R20 — 资源发现与 loader 固定基线

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G07全类方法（下表）；共享回归同表。
- 固定输入：UTF-8 资源、同路径不同 config bytes 冲突 Jar、required Good/Bad 与 optional/refmap 组合；identical.jar 原有 copy 保留。
- 删除/限定：删除固定资源/冲突/required/optional 的手工打包入口；保留 discovery duplicate 比较读/关闭、openingHost 对当前生产 bytecode 插桩、URL open 返回 null/异常、真实 read/close/cause/suppressed 与 release/retry。磁盘坏输入不等价于 URL/stream 故障。
- 完成谓词：G07 七方法保留 config 冲突无写、资源/loader 释放、required 和 optional 区分、cause/close/suppression/实际恢复；直接共享 G01/G02（实例化 fixture/producer）、G06 selectors；涉及共享 helper 时完整闭包。

### MST-R21 — 精确保留固定输入

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G08全类方法（下表）；共享回归同表。
- 固定输入：pretty/compact×package 组合 JSON、metadata/refmap/parent/坏实现 bytes、nested-source/consumer、full nested path、empty/no-config 及同名不同目录/未触及非法 bytes variants。
- 删除/限定：替换固定 content Map→fixture.jar 的基线打包；保留 cleanup 小值矩阵 writeString、当前 strip/remove 操作与原字节 snapshot。
- 完成谓词：G08 四方法逐 variant 验证跨数组/JAR 全 raw match、全路径而非 basename、未通知/空 config/未触及内容 bytes 不变及失败通知保留。共享回归 G02 通知与 G09/G13 精确 DOM；动 StripFixture 时所有实际消费者加回归。

### MST-R22 — 独立 Strip 固定 archive 基线

- state: failed
- historicalWaveId: MST-W02
- replacedBy: MST-R35
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / terminal generation2 Result (failed)
- history：generation1 pane/backend故障、无终态Result；只读诊断后resume generation2返回failed并已完整采用，不再次resume、不升级completed。候选21 Jar task实际executed/exit0但local/central extra各21差异、原始名称各1差异；未接consumer、writer删除0、候选源码已撤回、最终484项项目输入未变。原driver五类34/34通过仅证明旧实现。详见[Context失败记录](context.md#r22-失败事实与已确认恢复方法)。以下保留原范围与保证，成功义务由R35显式承接，原Jar承载尝试不再作为恢复方法。
- selector/预期集合：G09全类方法（下表）；共享回归同表。
- 固定输入：最小正常 fixture/cleanup、复杂 raw 匹配、合法特殊 entry names、合法/非法 JSON 基线、重复名称前的双 entry 基线、STORED entry 与目录。
- 删除/限定：替换 `fixture`/`archive(Map)` 固定 Jar 构造和末尾 STORED 手工基线；保留 local/central 两处同名 byte patch、坏 ZIP/截断/当前 cleanup 损坏、中断、读拒绝、写/close/发布、别名/硬链接/目录/冲突 writer。原尝试要求特殊entry/metadata先证明静态Jar等价才删writer；本次已失败且未删除，恢复的原字节等价/真实消费/删除前置由R35承接，不再要求ordinary Jar表达这些特殊包。
- 完成谓词：G09 十一方法保留精确 raw match/未触及项、重复 ZIP 拒绝且无输出、坏 DOM/ZIP、STORED/CRC/目录、原输入保护及故障恢复。共享回归 G11/G13 与 G04 参数/inputArtifact、G10 独立注册；若改 StripFixture 则所有 G01–G14 实际消费者。

### MST-R35 — 以对应测试资源恢复 R22 固定 archive 迁移

- state: completed
- completion record：已完整采用generation1 completed；21包4824 bytes/33 entry及cleanup/raw-cleanup/说明已落地，五阶段原字节/原始ZIP保真，全部固定caller接入，固定fixture/archive(Map)/STORED writer删除，同版G04/G09/G10/G11/G13五类34方法全过、0failure/error/skip。三层Microsoft JDK17.0.19+10-LTS、Gradle9.4.0，825相关输入稳定；[实际报告](../../../build/mixin-r35/report.md)、[verification](../../../build/mixin-r35/verification.json)及[资源说明](../../../minecraft-codev-mixins/src/test/resources/net/msrandom/minecraftcodev/mixins/strip-mixins/README.md)可读。build可clean/旧残留限制见Context。本次只纠正必要背景，不新增完成登记项、不重验、不改R22 failed或放gate。以下原合同保留用于说明已承接义务，未来式不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- terminal predicate：R22全部21个冻结ZIP/JAR基线及固定cleanup由StripMixinsTests对应测试资源承载，原字节经现有资源处理/classpath复制到私有路径后被全部原固定caller实际消费，固定fixture/archive(Map)/STORED手工基线writer已删除；同一最终相关版本G04/G09/G10/G11/G13全部34方法实际通过，原ZIP/DOM/保护/真实故障与fresh retry保证均有证据，足以完整承接R22原成功义务。资源放置、最小类内copy、删死入口、hash/metadata和回归仅共同证明此一迁移终态，不单产资源就绪或证据审计Result。
- 输入/成功前置：读取已采用R22 generation2 failed、[失败报告](../../../build/mixin-r22/report.md)、[原始对比及oldArchiveSHA256](../../../build/mixin-r22/zip-local-central-comparison.json)、[21 variant清单](../../../build/mixin-r22/legacy-variants.json)，以现存build/mixin-r22/legacy-baseline为唯一冻结来源。开始前核对21包/33 entry/4824 bytes与各oldArchiveSHA256；错误提取批次和candidate包不可用。若冻结输入缺失/不符则报告具体缺口，不重跑prepare/legacy生成器、不fallback生成。无R22 completed、R23或其它迁移completed的人造成功前置；旧failed只供范围/历史，不可再次resume。
- writeOwnership/归属：仅StripMixinsTests及其最小类内资源复制、minecraft-codev-mixins/src/test/resources/net/msrandom/minecraftcodev/mixins/strip-mixins/下21包、固定cleanup.json与简短来源/hash说明。目标已由R35实施创建，本次不修改；以冻结同名strip-*.jar承载，原entry不解压/重打包。配套说明记录用途、原writer/测试来源、冻结来源及全部21包SHA256和特殊语义供审阅，使后续正常运行不依赖build目录；不建manifest/ledger或fixture框架。不改ordinary/pipeline/Jar任务、模块build、fixture属性、production/deps/lock/authority；不顺带修改R23。若确需共享helper/StripFixture或额外写面，报告影响并按真实闭包补验，不借此增加框架。
- 完整固定集合：strip-normal、strip-raw、strip-duplicate、strip-invalid-0..5、strip-malformed、strip-accepted-0..2、strip-path-0..5、strip-empty、strip-stored共21包（33 entry、4824 bytes）。全部包首entry均带需保留的local/central feca0000 extra，不能只特例strip-path-4或strip-stored。strip-path-4原始a\bad（hex 615c626164）不能正规化成a/bad；duplicate基线仍为fixture.json与fixturE.json两个不同名entry。
- copy-consumer链：上述资源通过现有:minecraft-codev-mixins:processTestResources进入标准test资源输出及test runtime classpath；StripMixinsTests以自身class相对资源流strip-mixins/<variant>.jar读取，关闭流并用Files.copy原样覆盖到@TempDir的input.jar或方法私有路径，再交原StripFixture/StripMixins真实执行。固定cleanup.json同链复制到私有cleanup路径；缺资源直接失败，无生成fallback。normal供@BeforeEach及原普通故障/保护方法；raw供手写raw-match并保留other.jar实际copy；duplicate供双处同名patch；invalid/malformed/accepted/path/empty供原JSON/path/坏ZIP场景；stored供原目录/STORED场景。资源不能再过fixture Gradle构建，无新增Gradle fixture Copy任务/系统属性/writer/DSL/框架；普通JavaCompile/Jar不变。
- 等价及删writer前置：先将全部21个冻结包→仓内资源→processTestResources实际输出→测试classpath读取的私有副本逐包hash/bytes关联，局部patch/截断之前取证；确认原字节及全部entry原始local+central名称、extra、顺序、time、method、CRC、size、entry/archive comment及directory保证，原始header检查与JDK实际Jar entry观察相符，不以Python正规化名称或仅解压内容相同证明等价。整包SHA256可证明复制保真，无需新writer或ZIP修补器。所有固定caller已转资源消费且无残留调用后，才删fixture固定Jar构造、archive(Map)和末尾STORED固定构造及失去用途import；fixture生命周期与动态操作不删。当前cleanup小值矩阵和raw预期字符串仍用于真实变异/断言，不成为固定archive writer。
- 保留动态边界：duplicate仍在测试内把不同名基线local和central名称两处真实patch成同名并断言replaced=2；not-a-zip写入及删除尾部20 bytes截断、cleanup语法/DOM/UTF-8损坏、缺失/参数unset、interrupt flag、实际读权限拒绝、write/close/cancel/write-close/move、alias/hardlink/Windows junction/目录/冲突writer及fresh retry均在私有副本真实发生。不预存最终duplicate/截断/故障输出，不弱化原cause/identity/suppressed/关闭/无输出/输入保护/内容断言。
- selector/精确当次验证：task为:minecraft-codev-mixins:test；按通则给五个完整类selector：--tests net.msrandom.minecraftcodev.mixins.MixinInputBindingTests、--tests net.msrandom.minecraftcodev.mixins.StripMixinsTests、--tests net.msrandom.minecraftcodev.mixins.StripRegistrationTests、--tests net.msrandom.minecraftcodev.mixins.StripStreamTests、--tests net.msrandom.minecraftcodev.mixins.StripDomTests，取下方G04 16＋G09 11＋G10 1＋G11 2＋G13 4＝34个精确方法，0failure/error/skip，外层test SUCCESS/executed。G09十一方法均须关联资源variant→私有copy→原操作/内容/故障标记；G11/G13完整类、G04完整16方法及G10完整1方法为原共享闭包，不能只跑两种参数场景。仅改类内资源copy时无需机械扩跑101；若真改共享普通接口/writer或StripFixture，则核对G01–G14全部实际消费者并按闭包扩验。旧原driver34、R21的37或其它历史80/131不替代本版本验收、不拼接。
- 版本/环境/证据：真实记录实施前/改后及运行前后源码/资源/相关fixture/build/SPI的内容标识与diff（含未跟踪21包及cleanup/说明），保全旧R22证据后保存本次命令、task outcome、五类XML精确方法、日志/故障命中及内容。关联processTestResources输出、classpath实际来源、各私有副本hash，不能只凭文件/task存在；记录三层JDK17完整实际版本/路径与外层锁定/--version、wrapper/Gradle/解析图及host classpath，普通Java11参数/major55不变。原R22源最终未改与旧34是历史事实，不填新版本验证。只按本轮命令/XML/日志关联产物，不把retained旧残留算本轮；build证据可clean限制保留，不建receipt/原Result副本、不清整个build/user-home。
- conflicts/successor：原R22/R23执行结束/资源释放→R35→R24仅为历史冲突顺序，不证明R23完成；R35现已结束并采用completed，不重做。前轮候选R35→R23→R24随R23排除撤出，当前R35资源释放→R24，与共享写入者串行。R24消费本项有效completed并核对R22全部承接，不再等待R23 completed；G11共享回归不冒充R23静态化。R25同次组合、R26独立ready及W02 gate仍必需。

### MST-R23 — stream copy 精确 ZIP 基线

- historicalWaveId: MST-W02

**当前范围处置：excluded / exception（普通说明，不是新增state或Handler Result状态）。** 仅排除StripStreamTests固定stream-copy基线打包；R23不再是实际执行item，无当前实施Handler/成功owner，不进入R24 prerequisiteItemIds或W02成功计数。用户认为约40KiB随机payload不值得静态打包，重点是流故障注入、失败清理和成功重试。保留@BeforeEach的Random(31)/JarOutputStream/cleanup生成，不要求旧候选资源/copy/hash新增断言/删writer/17方法迁移验收，也不将其算作静态迁移完成。

正常entry/content/order/method/time/comment/extra/directory/size/CRC、JSON whitespace/unknown和原输入bytes保证不减；8192 bulk读写及各种read/input/output close故障、hit/异常identity/suppressed/全关闭、ASM/defineClass与禁止生产普通entry readAllBytes、source/cleanup保护、失败无output/staging、先成功→故障→无残留→撤销故障→fresh retry精确bytes均保留。R25最终同次组合仍执行G11原两方法，R24/R26核对限定例外及全部原保证；其他静态owner继续原合同。

旧completed声明身份不可关联，先前独立审计只证明当时仍在现场生成，不是本轮新审计。本次不追认为完成、不产生新failed或其他执行Result。原资源化候选曾独立review通过，但用户未批准，现明确排除。R22候选失败/旧driver34与R35 21包资源化/新34分别保留，均不证明R23静态化；详见[Context事实与冻结历史](context.md#r23-事实更正与冻结来源)。下列旧文的pending/须/未来/待review及确认/串行边仅属前轮候选时点，不参与当前图或gate。

<details>
<summary>已排除的R23资源化候选全文（仅历史）</summary>

> - state: pending
> - waveId: MST-W02
> - prerequisiteItemIds: []
> - handlerResult: one implementation Handler / one Result
> - 当前事实/确认边界：当前@BeforeEach仍Random(31)/JarOutputStream生成固定基线；源码SHA256 `65747003611859c2635f5c4c4caaa34e71718aff59cd2c43b7e8e0e4ca1c47e5`与R22/R35冻结版本一致。旧completed声明的原Result身份未关联，不虚构failed或恢复ID、不断言从未执行。R22/R35现有G11两方法通过仅证明旧driver共享回归，不能满足本项。原Jar逐entry等价承载前置现候选改为原字节test resources五阶段保真，全部行为/验收不减；尚待不同Handler独立review及Router C6 affected-scope披露/用户明确确认，禁止实施或放gate。
> - terminal predicate：六entry固定input.jar及cleanup由StripStreamTests专属测试资源保存，经现有processTestResources/classpath原样复制到每测试私有路径，被原G11两方法直接/反射StripFixture真实消费；payload有独立冻结长度/hash约束，原固定Random/JarOutputStream/cleanup writer删除；最终相关版本G11/G09/G13全部17方法实际通过，原ZIP/流/故障/输入保护/fresh retry保证有完整关联证据。资源放置、copy、删writer及回归共用一个成功/失败/恢复边界，不单产资源或hash Result，不并入R35、R24收敛或独立review。
> - 冻结来源（当前可读）：优先使用[正常方法input.jar](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes/input.jar)及[cleanup.json](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes/cleanup.json)，以[故障方法input.jar](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh/input.jar)及[cleanup](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh/cleanup.json)交叉核对。本次只读重核两套均同字节：Jar 80882 bytes、SHA256 `530ee6cd5d5140c9697643a772942a208fffd10574917a863de8481b347e9004`；cleanup 53 bytes、SHA256 `2942c134c581e3042548dfdcda8dfc1f8e69dbcdc139f171c338c9091c7cc599`。完整内容/metadata已核见[Context](context.md#r23-事实更正与冻结来源)。它们是可复用完整基线，不是R23实施证据；保留目录可能有历史残留、build可clean。未来开始前重新读/hash/解析，不符或丢失则报告缺口，不运行prepare/生成器、不能改用R35 strip-normal/ordinary producer-streamed或重造包。
> - 固定保证：六entry依序assets/、assets/data、empty、stored、fixture.json、unchanged.json；assets/为目录、empty非目录，payload两处均40001 bytes、CRC32=3999507122、SHA256 `e34c7a9ebc94f0bf4af307071ebd201d1bb9464bf2f083a94549e6deedfb8644`；两个37-byte JSON保留首/尾空格、LF与unknown，cleanup精确`{"fixture.json":["Good"],"unchanged.json":["Absent"]}`。原time=1700000000000、逐entry `kept <name>` comment、local/central `feca0000` extra、stored与fixture.json为STORED、其余DEFLATED、size/CRC/order/目录/原始名称/内容全部不减。候选复制整包不解压重打包、不正规化；epoch按同JDK/时区JarFile核对，原始DOS字段与压缩大小详见Context，不修改时间以配合环境。
> - writeOwnership/未来输出：仅StripStreamTests.java的fixture/最小类内资源copy与payload独立长度/hash断言，以及minecraft-codev-mixins/src/test/resources/net/msrandom/minecraftcodev/mixins/strip-stream/下input.jar、cleanup.json和简短来源/用途/hash/六entry说明；未来目录/文件尚未创建，不作可读ref。说明保留原writer/测试与已核冻结来源/hash，使正常测试不再依赖build目录；不创建单独payload、生成器/manifest/ledger/receipt或框架。不修改R35资源/类，不抽取共享copy helper、不改模块build/ordinary/pipeline、Gradle Copy/Jar任务、fixture属性/依赖/lock/工具链/production/authority/LLM指令/Git。若实际确需共享helper/StripFixture，报告真实写面及闭包，不能擅自扩大方法候选或削弱断言。
> - copy-consumer/payload：现有:minecraft-codev-mixins:processTestResources→标准test资源输出/runtime classpath；StripStreamTests以自身类相对strip-stream/input.jar和cleanup.json开流，缺失立即失败、关闭流，用Files.copy到本测试@TempDir的source/cleanup；output仍为私有output.jar。初始化时从已复制input.jar的assets/data读取resource，断言40001长度和上述独立冻结SHA256；stored仍由原内容/metadata断言覆盖，不新增payload资源。这里读取期望payload在探针外，不触及IO.InputJar对生产普通entry readAllBytes的禁止。正常方法直接StripFixture.strip，故障方法沿probedLoader反射StripFixture及当前ExactMixinStripper；保留原retry `assertArrayEquals(resource, ...assets/data...)`。不能用预存期望输出或从result反读payload作期望；长度/hash防止输入与期望值一同错误仍通过。
> - 等价/删writer前置：在删除前证明冻结来源→仓内资源→processTestResources实际输出→真实test classpath读取流→每测试私有copy的Jar和cleanup五阶段bytes/SHA256相等；验证原始local/central名称/extra/顺序、method/time/comment/directory/size/CRC/所有entry bytes，Java JarFile实际consumer观察与原始header一致。关联两个真实消费者的classpath来源/私有copy/hash和未变原断言；所有固定caller已接入、无固定writer残留调用后，才删除fixture中的Random、固定JarOutputStream/CRC构造、固定cleanup写入及死import。保留fixture生命周期/afterEach retain、IO.OutputJar真实探针输出，不因JarOutputStream同名误删。失败报告精确差异/未完成边界，不能fallback生成、默默保留固定writer或删减验收。
> - 动态合同：probedLoader继续对当前生产class ASM/defineClass且构造器替换hits=2；IO.InputJar禁止普通entry readAllBytes，read/read-close/input-close/write/output-close五模式真实bulk故障（read/write在8192后，close在完整40001后）、hit、异常identity、read-close的closeFailure suppressed、input/archive/output关闭保持。每模式先成功输出→真实故障→无当前output及无.codev-strip-临时残留、source与cleanup原字节不变→撤销故障→fresh strip→40001 payload精确bytes；正常方法逐entry保留order/method/time/comment/extra/directory/size/CRC、fixture精确编辑、unchanged原bytes及原输入保护。保留全部原断言，不能以资源化或TestKit成功替代故障。
> - selector/精确回归：按通则在同一最终R23版本一次运行:minecraft-codev-mixins:test，完整--tests net.msrandom.minecraftcodev.mixins.StripStreamTests、--tests net.msrandom.minecraftcodev.mixins.StripMixinsTests、--tests net.msrandom.minecraftcodev.mixins.StripDomTests；G11全2＋G09全11＋G13全4＝17个精确方法取下方G表，0failure/error/skip、外层test SUCCESS/executed。G11两方法为`streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes`与`actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh`，共享G09/G13原集合不减。若真改StripFixture，按原合同增加G02/G03/G04/G05/G07/G08/G12/G14实际消费者，连原17共88；公共普通helper/writer接口变化再按G01–G14实际闭包101核对，纯类内copy不机械扩验。旧R22/R35的2或34、旧根131均不替代本版本17/静态化证据、不拼接。
> - 版本/证据：保全既有R22/R35及其它相关证据后，沿既有build/fixture-evidence保存真实修改前/改后/运行前后输入、源码、资源、fixture/build/SPI标识和diff（含未来未跟踪资源）、命令/TaskOutcome/XML/日志、五fault hit、真实资源处理输出/classpath URL/private hash及内容断言；不建额外证据系统。分别记录外层Gradle JVM、解析test launcher及fixture.gradleJava完整实际JDK17版本/路径，外层实际锁定/java-version/--version、wrapper/Gradle/testRuntimeClasspath/host classpath及时间解释环境，Java11 release/UTF-8/-proc:none/major55不变。原R35为Microsoft17.0.19+10-LTS/Gradle9.4.0，仅供比较，不冒充新环境观察。build可clean、临时文件可消失，输出覆盖前保全，不清整个build/user-home、不把目录旧残留当本轮产物。
> - conflicts/successor：与已完成R35及其它测试资源/共享helper/Gradle/TestKit/JVM/cache/资源处理/classpath输出/证据快照写入者串行，安全路径为R35已结束/资源释放→获确认后的R23→R24→R25→R26；串行不制造R35成功前置或要求重做其它owner。R24必须消费真实、完整可关联且证据充分的R23 completed，逐项核六entry静态copy/等价/删writer/17回归；身份未知或迁移证据不足不放行，R35完成不替代。R25根131同次组合与R26独立ready/W02原gate分别必需，本作者不执行或判断释放。

</details>

### MST-R27 — defaults caller

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P27见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：默认及custom输出的完整build/settings/properties，固定注册和查询println、appliedOnly Sync均进静态模板；两个variant只选择静态副本，不拼build。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/defaults静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，默认/custom applied路径和默认removals在执行前可查询，produce/appliedOnly SUCCESS、1→42、精确Good通知与源target=1；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；保留两variant循环及临时JDK路径适配。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R28 — native / implementation caller

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P28见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：完整produce注册及doFirst input断言进静态build，config/plugin40基线由静态Jar消费。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/native静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，selector变化UP-TO-DATE、native unset/default/changed/unset的SUCCESS与42/52/42、implementation当前副本及资源改变触发SUCCESS、Good通知保持；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；保留实际当前implementation目录复制与资源重包，不能冻结生产class；保留native参数变化。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R29 — Kotlin-runtime caller

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P29见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：完整runtime-input settings/cache和过滤/child classloader、host关闭、runtimeMixin produce/consume及classpath断言进入静态工程。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/runtime静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，42消费、UP-TO-DATE、runtime内容改变后SUCCESS、新runner FROM-CACHE和双输出逐bytes及Good通知保持；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；复制实际当前Kotlin runtime再局部改资源；删除双输出/切换runner真实发生，不预存runtime或implementation。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R30 — task-only plugin caller

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P30见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：完整produce注册/custom output与refmap/config/plugin40/43、origin-resource固定基线静态承载。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/task-only静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，plugin body/resource独立变化下42→45→49、SUCCESS/UP-TO-DATE与configuration-cache复用、TASK-PLUGIN实际来源、Good通知、竞争host资源及源target=1保持；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；保留body切换与resource局部替换、原body/resource不变断言和当前runner。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R31 — 直接 taskProducer 保护输入

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P31见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：taskProducer使用的runtime-a/b、extra-source、task-mapping固定输入由现有静态任务生成/复制；保留ProjectBuilder真实Mixin/StripFixture绑定。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/task-inputs静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，四种taskProducer直接消费场景的双输出/implementation/runtime/source/mapping保护、真实Windows junction/hardlink、权限/dangling/目录、合法相邻/同basename及重复执行和原输入保持；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；这些方法不调用project/pipelineProject，不应迁成TestKit；保留真实alias/权限/目录变异和taskConsumer。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R32 — 直接 cleanup 消费基线

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P32见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：refmap/config的固定baseline静态承载；cleanupConsumption使用静态mod输入后才执行producer及独立Strip。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/cleanup静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，当前different.jar资源为9、独立cleanup消费不重放engine绑定，删applied仍能Strip、缺records必须失败无输出；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；保留不同当前input局部replace及删除output/records，不能将真实通知输出预存为固定cleanup。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R33 — 直接 ordered-domain 输入

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: []
- handlerResult: one implementation Handler / one Result
- selector/预期集合：G04整类16方法，唯一迁移验收子集P33见下表；共享回归G02/G03/G05/G06/G10，涉及OrdinaryInputs/PipelineInputs/普通writer接口则扩G01–G14实际闭包。
- 固定输入/写面：config-shadow/refmap-shadow、重复mod、分离plugin/config/refmap和source含plugin/无plugin固定variants交静态Jar；逐内容核等价后copy。owner为G04相应方法/必要helper及现有ordinary或pipeline/callers/ordered-domain静态输入，不增属性或框架。
- 完成谓词：自身静态任务→copy→实际消费者成立，config/refmap/plugin不共址仍1→42、原键Good/Both随实际顺序、重复配置、runtime/source/host-only fallback与classpath-only=1保持；其它caller迁移失败时本结果仍可保留、恢复只处理剩余边界。
- 删除/动态：只替换自身固定生成/脚本入口；静态variants选择表达固定竞争布局；当前输入变化仍需局部replace时逐caller解释，保持producer/Strip真实执行。必要helper在此谓词内增量维护，旧caller共存；project/refmap/configPlugin/plugin/replace及公共fixture的全局死入口核对留R24，不能提前删除实际caller。共享G04/helper/静态工程、Gradle/JVM/cache与证据写面仅串行，成功前置为空。

### MST-R24 — 收敛固定生成入口与共享writer

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: [MST-R13, MST-R14, MST-R15, MST-R34, MST-R17, MST-R18, MST-R19, MST-R20, MST-R21, MST-R35, MST-R27, MST-R28, MST-R29, MST-R30, MST-R31, MST-R32, MST-R33]
- handlerResult: one implementation Handler / one Result
- predicate：重新逐caller核对11类ToolProvider/JavaCompiler、源码字符串、JarOutputStream/archive/jar/project/config/refmap链；仍有静态owner的固定生成均已替代、死入口已删，剩余writer服务具体当前输入/特殊ZIP局部/control/故障输出或StripStreamTests明确例外。三处runtime javac消失；InputBinding import与Attempt/rejects按无caller清理，不误删FailureStage真实rejects。共享MixinPreapplicationTests.jar/MixinInputBindingTests.replace仍服务当前变化时保留byte/order/error语义、列每一caller/必要性；“isolation/fault”标签不证明动态必要，例外也不可外推。
- scope/evidence：仅原helper/import/失去消费者的旧资源/生成分支；旧r04/Plugin.java、mapping/TracePlugin.java、pipeline-caller.gradle在消费迁完后删除或保留单一静态来源。逐入口给源码位置/实际caller/静态替代/必要性或明确例外。改共享helper用G01–G14完整闭包，纯死代码删除以无caller核对并由R25覆盖；不误删ASM/defineClass/IO.OutputJar和StripStreamTests例外writer。17个有效静态owner真实完整可关联completed Result为前置，核对R34承接P16/接线/59及R35承接21包资源处理/classpath/copy/原字节metadata、删writer/改后34证据；不升级旧R16/R22或补代迁移。R23无成功Result前置，保留错误completed身份缺口/先前审计/旧候选；逐caller核实Random(31)/JarOutputStream/cleanup动态基线及正常entry/metadata、8192 bulk读写、关闭/identity/suppressed/输入保护/无残留/fresh retry全部原保证，不补做资源化或要求旧17方法/hash候选证据，其他固定owner不获豁免。

### MST-R25 — 恢复后根入口有限组合

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: [MST-R24]
- handlerResult: one execution Handler / one Result
- predicate：同一最终工作树/解析图/环境从根:test同次实际执行G01–G18/F01–F18（当前101/14/16共131方法），0failure/error/skip；三模块test SUCCESS/executed、root NO-SOURCE正常。仍有静态职责的输入有真实消费/内容证据：普通JavaCompile/Jar链、R35 21包既有processTestResources/classpath→私有copy及原字节保真；StripStreamTests按例外动态生成，不要求资源消费/hash或新增候选断言，G11原两方法与全部原保证必须在本轮组合执行。方法变化逐一解释，不能只凭131passed认定静态化。
- execution/writeOwnership：复用上方R09有限init filter/根dry-run与实际命令形状，临时init用既有build下本轮单独目录；实际命令/输出由新Result记录，不冒用R09日期/路径/结果。只写当次Gradle/TestKit/build/temp证据，不修代码/登记四文档。R24传递消费17个静态迁移结果并核对StripStreamTests明确例外；保全R07/R09/R11证据，不清整个build/user-home。
- evidence：G表逐方法→当次XML/TaskOutcome→源码/真实输出，覆盖1→42、raw键/双Strip、当前输入/SUCCESS/UP-TO-DATE/新runnerFROM-CACHE、全部真实故障/close/identity/suppressed/重试、F16六fault fresh retry、R07全16行/非空AT/JarJar/nested/13bytes vendor。记录普通静态JavaCompile/Jar及R35资源处理/实际classpath/复制前hash/consumer；StripStreamTests例外记录当前动态输入、G11两方法全部正常entry/metadata、8192 bulk读写与关闭故障、identity/suppressed、source/cleanup保护、无残留/fresh retry关联，不要求静态资源或新增候选长度/hash断言。记录各层JDK17完整版本/路径/锁定与Gradle/解析图、Java11参数/major55和输入稳定性，不改变JDK跟随；cache重放不冒充新执行。覆盖输出前保全本轮XML/log/fixture，build可清理；旧131/Fabric14/Results只支持未变边界，不拼成新运行。

### MST-R26 — 独立最终只读审计

- state: completed
- completion record：Router已可靠采用completed；当前效果及最终组合适用性由R24/R25与R26独立ready支持，见[最终收口证据](context.md#最终收口证据与限制)。以下原完成合同保留，不是待重做要求。
- waveId: MST-W02
- prerequisiteItemIds: [MST-R25]
- handlerResult: one independent read-only Handler / one Result
- predicate：不同于全部迁移及R24/R25实施/运行者的Handler消费完整关联Results、最终源码/输入及适用历史，逐行判断11类/S1–S8/F01–F18/R07全16行/W02 gate，给ready/not-ready、精确缺口与限制。completed只表示审计完成，gate仍须ready；缺输入如实blocked/partial。
- checks：三处javac消失、完整caller不再拼工程、共享writer全部caller/动态必要性及StripStreamTests明确例外；R35全21包资源归属/处理/copy-consumer/hash与原始metadata等价。R23不要求静态资源/copy/候选hash新增断言/删writer/17方法迁移证据，不消费其completed；核对例外仅限该固定stream-copy基线打包、仍有Random(31)/JarOutputStream/cleanup及全部正常entry/metadata、8192 bulk读写/各种关闭/identity/suppressed/输入保护/无残留/fresh retry保证，G11两方法在R25本轮组合真实执行，其他静态owner不获豁免。保留ASM/流/权限/并发实际时序、最终diff/解析图/环境/方法集合与回归充分性；独立Strip无producer，同FQCN不入宿主，断言不弱化。核对双语Spec input-tests/mapping-tests存活但不写authority，不以数目/旧R12代替审计。
- writeOwnership：只读，不构建/测试/清输出/修代码/写四文档/Git/放gate。Result只返回判断；持久导航限可核对仓内相对路径/公共URL，缺历史全原件不改旧状态。

### Selector 与预期方法集合

G01–G18与F01–F18同类对应；本轮源码只读核对以下集合。自身及共享消费者均用完整类selector，方法调试不能代替集合。

| G | task / `--tests` selector | 预期方法集合 |
| --- | --- | --- |
| G01 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinPreapplicationTests` | 5：`kotlinProductsKeepStaticEntrySpiAndJdkOnlyHandoff`、`realDifferentArtifactsAndIsolation`、`optionalFailureKeepsEveryNotifiedKey`、`partialTargetsDoNotRevokeNotifications`、`invalidArchivePathIsRejected` |
| G02 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinProducerTests` | 18：`targetOwnedDefinitionsArePreservedWithoutSkippingOrdinaryTargets`、`streamedResourcesKeepContentsOrderAndEntryMetadata`、`nonMixinClassInReservedPackageStillFailsWithoutPublishing`、`nativePropertiesAreObservedWithoutOverridesOrHostPollution`、`parentNotificationUsesParentsOriginalPathAndString`、`nativeExclusionsMissingClassesAndFallbacksReturnNormally`、`exactRawKeysDuplicateSourcesArraysAndUnnotifiedEntries`、`streamedNotificationsPreserveUnicodeEscapesAndDuplicateSetsForIndependentStrip`、`notifiedMultiTargetSurvivesLoggedFailureAndUnknownDynamicNotification`、`equalClassNamesInDifferentConfigsDoNotInventNotifications`、`validEmptyIsNotMissingOrMalformedInformation`、`directEngineExceptionAndInvalidInputDoNotPublishAndRetryIsFresh`、`actualWritesAndSecondMoveInvalidateOldPair`、`actualLoaderCloseFailureBlocksHandoffAndPublication`、`taskPreservesRawInputsAcrossHardlinksParentAliasesAndDirectoryGuards`、`originalConfigAndParentStreamFailuresBlockPairAndAllowFreshRetry`、`actualProducerGraphClosureAndMidStreamFailures`、`taskTracksProducerInputsAndBothOutputs` |
| G03 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinMappingTests` | 8：`exactOwnerOverloadDescriptorReverseAndMissing`、`mappingReaderStillAutoDetectsSrg`、`realRefmapMemberInfoChainKeepsRawKeys`、`actualNativeChainObservationInOrdinaryMode`、`mappedOperationThenConfiguredUnmappedOperationInSameJvm`、`recorderRefmapStreamFailuresKeepCauseCloseAndRetryWithExplicitContext`、`invalidTupleNamespaceContextAndDirectionPublishNothing`、`noMappingLegacyRefmapAndContextOnly` |
| G04 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinInputBindingTests` | 16：`taskInputsRejectRealWindowsParentAliasesAndHardlinksBeforeMutation`、`destinationAccessAndDanglingAncestorFailuresPreserveBothProducersOldResults`、`taskDirectoryInputsRejectDescendantsAndAllowAdjacentOutputs`、`taskDistinctSameBasenameContentMissingParentsAndRerunsAreLegal`、`cleanupConsumptionDoesNotReplayEngineBindings`、`orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation`、`testKitProducerDefaultsAreQueryableBeforeExecution`、`testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations`、`testKitProducerCacheRestoreThenFreshAndRestoredTransforms`、`testKitTransformTracksParametersAndInputArtifactIndependently`、`testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput`、`testKitFailedCurrentProducerCannotRouteOldSuccess`、`testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption`、`testKitNativeSelectorsAreNotOptionsWhileNativeValuesAndImplementationRemainInputs`、`testKitKotlinRuntimeContentsInvalidateAndRestoreCurrentOutputs`、`testKitTaskOnlyPluginBodyAndResourceChangesReexecute` |
| G05 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinFailureStageTests` | 9：`optionalNativeStagesKeepEveryNotifiedKeyWithoutReadingLogSeverity`、`requiredNativeStagesPublishNoSuccessAndKeepUnderlyingCause`、`notificationDoesNotRequireAllDeclaredTargetsToBeTransformed`、`sameFqcnInDistinctConfigsAndSectionsUsesOnlyNotifiedConfigRawKey`、`processorExportAndByteGenerationExceptionsAfterNotificationPublishNothing`、`unknownAndDynamicNotificationsReachRecorderWithoutInventingOrRevokingKeys`、`loggedNonNativeFailureDoesNotRevokeKnownKey`、`unavailableNotificationSurfaceCannotProduceUnknownSuccess`、`unsupportedMajorConfigAndUnavailableInjectorPublishNoConsumablePair` |
| G06 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinOperationIsolationTests` | 7：`sameJvmSequentialAndOverlappingOperationsMatchSerial`、`samePhysicalDestinationRejectsProducerButAllowsCompletedReaders`、`declaredOrderControlsClassByteResourceAndMetadataDomain`、`successFailureAndFlagOnlyInterruptionReleaseResourcesAndFreshRetry`、`initializationScopePreservesWriteFailuresAndSuppressionIdentity`、`nativeInitializationRestoresValuesUnsetFailureCancellationAndRestorationFailure`、`participatingHostCopiesExcludeInitializationThenOverlapWithRestoredSelectors` |
| G07 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinResourceTests` | 7：`unclosedReturnedStreamDoesNotRetainJarAfterLoaderClose`、`discoveryRejectsDifferentConfigBytesWithoutChangingInputs`、`discoveryComparisonReadAndCloseFailuresBlockRealProducerAndAllowRetry`、`jdkResourceOpeningIOExceptionIsNullButDefineClassKeepsCause`、`requiredConfigAndBytecodeOpenNullBlockPairAndRetryFresh`、`nativeOptionalRefmapOpenNullFallbackAndEngineFailureStayDistinct`、`actualResourceReadAndCloseFailuresRetainCauseAndSuppression` |
| G08 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.MixinSafeRetentionTests` | 4：`producerCleanupRemovesAllRawMatchesAcrossArraysAndDifferentJars`、`producerPreservesFullNestedConfigPathRatherThanBasename`、`partialAndLoggedFailureNotificationsStillStripAndKeepEmptyConfigs`、`validEmptyNoMatchingStringsPathsOrConfigsLeaveContentByteIdentical` |
| G09 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.StripMixinsTests` | 11：`publicTrackedParametersAndInputArtifactAreRequired`、`handwrittenRemovalsRemoveEveryRawMatchWithoutProducerOrMetadataDiscovery`、`duplicateZipEntriesCannotPublish`、`cleanupSyntaxOrDomShapeFailuresCannotPublish`、`malformedApplicableJsonOrInvalidZipCannotPublish`、`interruptFlagAloneBeforeDuringAndAfterRewriteDoesNotCancel`、`outputWriteCloseCancellationAndPublicationFailuresInvalidateCurrentOutput`、`suppliedFileReadFailurePropagatesFromLocalReaderAndInvalidatesOldOutput`、`originalAndCleanupAliasesHardlinksAndDirectoryContainmentAreProtected`、`realParentAliasesAndConflictingWritersDoNotMutateInputsOrWinner`、`storedEntriesAndDirectoriesSurvivePreciseEdits` |
| G10 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.StripRegistrationTests` | 1：`handwrittenAndOtherTaskFilesDriveRealTransformAndFailedCurrentConsumption` |
| G11 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.StripStreamTests` | 2：`streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes`、`actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh` |
| G12 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.ProducerDomTests` | 6：`childConfigAndParentFollowInstalledDomWithoutAdditionalSyntaxPolicy`、`childConfigAndParentUtf8FollowDefaultStreamDecoder`、`refmapUnknownFieldsFollowInstalledDomThroughRealMappedInjection`、`realRefmapUnknownFieldUtf8FollowsDefaultDecoder`、`missingInputsInvalidateEarlierPairWithoutChangingRawInputs`、`shapeResourcesSideAndPathsCannotReuseEarlierSuccess` |
| G13 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.StripDomTests` | 4：`duplicateFieldsAndUnknownNestedKeysFollowActualDomWithAndWithoutEdits`、`everyRawStringControlInUnknownNestedFieldsFollowsActualDom`、`entryFileDuplicateKeysMatchLibraryAndBusinessRulesStillApply`、`exactStringsAndEmptyArraysUseTheSameFileFormatAndTrackedDomDependencies` |
| G14 | :minecraft-codev-mixins:test / `net.msrandom.minecraftcodev.mixins.FixtureMixinRuleTests` | 3：`missingListReturnsNull`、`snapshotPreservesLinesAfterZipCloseAndRemovesOnlyFromNewRoot`、`readAndRemoveIoFailuresAreWrapped` |
| G15 | :minecraft-codev-fabric:test / `net.msrandom.minecraftcodev.fabric.mixin.FabricMixinApplicabilityTests` | 6：`discoveryMergesSidesAcrossIdenticalConfigsThroughProducer`、`producerNotificationsRespectApplicabilityAndInputOwnership`、`outerEnvironmentIntersectsInternalKindsAndRetainsInactiveOnly`、`scalarDefaultWildcardDuplicateAndInputOwnedReferences`、`rejectsMismatchedOrMissingApplicabilityBeforePublishing`、`sharedParentsInheritReferenceUnionWithoutLoadingInactivePlugin` |
| G16 | :minecraft-codev-fabric:test / `net.msrandom.minecraftcodev.fabric.mixin.FabricMixinMetadataTests` | 8：`discoveryPreservesObjectsUnknownFieldsAndReferences`、`discoveryIsReadOnlyForScalarAndObjectForms`、`nullableOriginalContractAndApplicableEmptyHandler`、`closedZipHandlerRetainsDuplicatesEnvironmentsAndRealWriters`、`scalarAndObjectReferencesSupportExplicitRemoval`、`currentMetadataUsesCurrentZipValuesAndKeepsDiscoverySnapshot`、`actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits`、`actualReadWriteAndCloseFailuresEscapeRemove` |
| G17 | :minecraft-codev-forge:test / `net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests` | 14：`manifestDiscoveryTrimsBlanksWithoutWritingMetadata`、`neoforgeTomlDiscoveryRetainsEveryEntry`、`producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata`、`dualMetadataDiscoveryAndExactEditingPreserveReferences`、`originalNullableContractEmptyHandlersAndConstructors`、`closedZipHandlersPersistRemovalForBothMetadataFormats`、`manifestEditsCurrentReferencesAndAttributesWithoutChangingTomlOrSnapshot`、`manifestChangedReferencesRemainOutsideRemovalSet`、`actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy`、`neoForgeEditsCurrentTomlWithoutChangingManifestOrSnapshot`、`malformedMetadataAndBusinessPathsStillFailWithoutWrites`、`hostDiscoverySeesBothDistinctFormatsAndSingleFormatArchives`、`actualReadWriteAndCloseFailuresEscapeRemove`、`manifestActualReadWriteAndCloseFailuresEscapeBothEditEntrypoints` |
| G18 | :minecraft-codev-forge:test / `net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests` | 2：`jarJarRemovalDeletesListedPayloadAndMetadataOnly`、`actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload` |

### 原R16 caller/直接消费者的完整分配

以下子集均属G04；可执行子集selector是`net.msrandom.minecraftcodev.mixins.MixinInputBindingTests.<方法名>`，运行task为`:minecraft-codev-mixins:test`。P16原owner R16为历史blocked，由R34唯一承接；每项仍须整类16方法和上述共享回归，子集只划迁移owner，不削弱验证集合。P16消费pipelineProject六Jar/mapping和build；P27–P30各自project(body)，不消费pipelineProject结果；P31–P33直接组件消费也没有pipeline成功依赖。源码定位见[InputBinding][input]的`pipelineProject`、十个TestKit方法与六个直接方法。共同fixture的runtime-a/b基线按实际消费者在各项需要时复用/复制，先迁者保留兼容入口，不能制造全局helper成功前置。

| 子集 / owner | 唯一归属的精确方法集合 |
| --- | --- |
| P16 / MST-R34 | `testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations`、`testKitProducerCacheRestoreThenFreshAndRestoredTransforms`、`testKitTransformTracksParametersAndInputArtifactIndependently`、`testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput`、`testKitFailedCurrentProducerCannotRouteOldSuccess`、`testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption` |
| P27 / MST-R27 | `testKitProducerDefaultsAreQueryableBeforeExecution` |
| P28 / MST-R28 | `testKitNativeSelectorsAreNotOptionsWhileNativeValuesAndImplementationRemainInputs` |
| P29 / MST-R29 | `testKitKotlinRuntimeContentsInvalidateAndRestoreCurrentOutputs` |
| P30 / MST-R30 | `testKitTaskOnlyPluginBodyAndResourceChangesReexecute` |
| P31 / MST-R31 | `taskInputsRejectRealWindowsParentAliasesAndHardlinksBeforeMutation`、`destinationAccessAndDanglingAncestorFailuresPreserveBothProducersOldResults`、`taskDirectoryInputsRejectDescendantsAndAllowAdjacentOutputs`、`taskDistinctSameBasenameContentMissingParentsAndRerunsAreLegal` |
| P32 / MST-R32 | `cleanupConsumptionDoesNotReplayEngineBindings` |
| P33 / MST-R33 | `orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation` |

八个边界均有独立可保留消费结果；pipeline的六场景共同消费同一完整caller，defaults两个variant共同验证默认通知合同，P31四场景共同验证taskProducer输入保护。共享runner/run/pipelineRun、project与retention只解释写面冲突，不能合成成功依赖。R24须等所有owner再作全局无caller清理；这不阻碍先迁caller单独完成。

### S1–S8 当前恢复覆盖

| 条件 | 必须的新证据（不是本轮运行事实） |
| --- | --- |
| S1 | R13–R15/R34/R17–R21/R27–R33/R35的17个静态owner及完整caller消费，R24全11类入口收敛；R35全部21包保持原资源合同。R23仅历史/范围记录，StripStreamTests固定stream-copy基线依用户决定保留动态生成，正常ZIP/流故障/输入保护/无残留/fresh retry全部原保证不减；例外不扩散，普通JavaCompile/Jar不变。 |
| S2 | G01/G02/G04/G05/G08/G09/G10/G12/G13真实1→42、原键/跨数组JAR/完整path、A/B/双Strip、原输入/未通知内容。 |
| S3 | G03/G04/G13当前mapping/side/context/native/unset/default、plugin body/resource、顺序、implementation/Kotlin runtime、SUCCESS/UP-TO-DATE/新runnerFROM-CACHE及内容。 |
| S4 | G04/G09/G10参数/inputArtifact独立变化、空/缺cleanup/坏DOM、当前producer失败不消费旧成功、applied-only。 |
| S5 | G03名称/refmap/MemberInfo/隔离、G15–G18snapshot/current metadata/AW/AT/nested/双格式与R07原16行职责。 |
| S6 | G02/G03/G04/G05/G06/G07/G09/G11/G16/G17真实流/close/identity/suppressed/权限/别名/硬链接/目录/双输出/selector/TCCL/并发/fresh retry；TestKit不替代局部故障。 |
| S7 | R25根dry-run/三模块/SPI/pluginUnderTestMetadata、普通静态任务及R35既有processTestResources/classpath/private-copy实际消费；StripStreamTests为明确动态例外，G11两方法真实执行及原保证不减。Java11 UTF-8 -proc:none/major55及各层JDK17不变，无新增fixture任务/属性/工具链策略。 |
| S8 | R24调用链、R25同次组合逐方法内容/最终diff/回归适用性、R26独立充分性；作者检查不是运行/验收。 |

### 冲突顺序与联合等待

所有实际项仍共享排他冲突边界：Java基类/writer/helper、ordinary/pipeline工程/caller、StripMixinsTests既有资源/说明/hash、Gradle/TestKit/JVM/cache、资源处理/classpath输出/历史证据及源码/四文档快照。R23没有当前实施/写面/资源占用，其历史候选边不再执行；不因例外删除StripStreamTests动态输入writer或故障探针。实施/运行/清理/文档写入不得与R26快照读取并行，并与历史锁当前使用者互斥；纯共享读取不构造冲突。以下为结束/资源释放顺序，保留R16/R22已终态历史释放点，不重演旧执行；blocked/failed释放不满足成功依赖，真实成功前置仅以节点prerequisiteItemIds及有效Result为准。

```yaml
residualSerialization:
  - from: MST-R13
    to: MST-R14
  - from: MST-R14
    to: MST-R15
  - from: MST-R15
    to: MST-R16
  - from: MST-R16
    to: MST-R34
  - from: MST-R34
    to: MST-R27
  - from: MST-R27
    to: MST-R28
  - from: MST-R28
    to: MST-R29
  - from: MST-R29
    to: MST-R30
  - from: MST-R30
    to: MST-R31
  - from: MST-R31
    to: MST-R32
  - from: MST-R32
    to: MST-R33
  - from: MST-R33
    to: MST-R17
  - from: MST-R17
    to: MST-R18
  - from: MST-R18
    to: MST-R19
  - from: MST-R19
    to: MST-R20
  - from: MST-R20
    to: MST-R21
  - from: MST-R21
    to: MST-R22
  - from: MST-R22
    to: MST-R35
  - from: MST-R35
    to: MST-R24
  - from: MST-R24
    to: MST-R25
  - from: MST-R25
    to: MST-R26
```

### 当前作者语义自检（MST-W02，非独立 review）

当前检查：20个实际成员completed投影与Router采用事实一致，W02 satisfied、R26 ready；成员/前置/串行/gate合同保持不变。四文档本地引用可读性及完成关联作静态检查，未重跑项目或独立验收。

前轮作者检查全文保留（当时pending仅属历史）：

> 本轮仅四文档维护及作者自检，未改源码/测试资源/build/依赖/lock/authority/Git，未运行Gradle或测试、未作独立review、未完成R23或释放W02。动态例外为用户已明确决定；候选独立review通过但未获实施批准、旧审计与本轮检查分别记录。
> 
> - 成员/引用：W01历史13项及释放不变；W02 pending，20个实际member无重复，为17个有效静态owner加R24/R25/R26。R16 blocked、R22 failed、R23 excluded / exception仅历史/范围记录，不新增state/Result协议、不算静态完成。
> - 真实前置：R24精确等待17个有效静态owner真实完整可关联completed Result，核对R34/P16/59与R35/21包/改后34承接，不重开已采用结果或被旧pending投影重置；不等R23 completed。R25仅等R24，R26仅等R25；旧R23身份未知和R22 failed/旧34不满足成功前置。
> - 无环/冲突：逐项prerequisite引用存在、同波；当前17 owner→R24→R25→R26依赖与串行同向，联合图无环/无悬空，W02无prerequisiteWaveGate。R16/R22仅已终态释放锚点，不作成功owner；R35→R23→R24旧边仅历史，现R35→R24。共享写面/Gradle/TestKit/JVM/cache/证据快照继续串行，终态与资源释放不能替代成功Result。
> - Gate：20项完整可关联completed已采用、17 owner承接充分、R24限定例外/全链收敛、R25同次131与G11原两方法全部保证、R26独立ready及原11类/S1–S8/G/F/R07全16行同时满足才可由Router判断release。R24–R26仍pending；排除R23成功要求不放宽任何测试保证，本轮不判断释放。
> - 互链/历史：四文档互链/本地引用核对，Waves仍唯一执行图，authority不变；R23错误completed身份缺口/先前现场生成审计/候选全文，R22 generation1/2 failed/候选撤回/旧34、R35资源化21包/新34、R16 blocked及部分效果保留。历史引文的旧数量/前置/未来措辞不参与当前执行。
> 
> - 本轮静态检查实际结果：四文档146处本地Markdown引用的目标/锚点均可解析，无缺失路径、坏锚点或未定义引用标签；W02的20个实际成员、17个静态owner、19条成功前置边和21条串行边已核对，含R16/R22历史释放点的22节点联合图无环、无悬空引用。R23无当前state/waveId/prerequisite字段，R16 blocked/R22 failed保留；W02及R24–R26仍pending。该检查只验证文档结构与本次连接，不证明实现或运行通过。
> 
> ### 前轮R23连接与作者检查（仅历史，已被限定例外替代）
> 

以下保留被替代的连接、策略与作者检查；旧21成员/18 owner/R23 completed前置/资源候选/待review或确认仅属前轮时点，不是当前图、gate、实施要求或新Result。R23旧候选全文另见其历史折叠块。

> 本文件是唯一执行图。**当前MST-W02 pending；R22 generation2 terminal failed与R35 generation1 completed已完整采用，R23当前静态迁移未获满足。** R35全部21包资源迁移/固定writer删除/同版34方法通过是已采用背景，不重做、不新增登记任务。R13–R15/R34/R27–R33/R17–R21已采用completed、R16 blocked及其八路径/59通过均保留，未重置其它owner。旧“R23已采用completed／R35唯一剩余”声明身份未关联，更正及原文字见[Context](context.md#r23-事实更正与冻结来源)；不推断R23从未执行，不制造failed或恢复ID。此次仅四文档R23局部候选计划及作者自检，尚待不同Handler独立review和Router C6 affected-scope披露/用户明确确认；不实施、不以R35确认延伸到R23、不放gate。

> - itemIds: [MST-R13, MST-R14, MST-R15, MST-R34, MST-R17, MST-R18, MST-R19, MST-R20, MST-R21, MST-R35, MST-R23, MST-R24, MST-R25, MST-R26, MST-R27, MST-R28, MST-R29, MST-R30, MST-R31, MST-R32, MST-R33]

> - outcome：原确认范围的11类固定输入与完整caller静态承载，生成入口删除/限定，真实内容/隔离/缓存/输入保护/故障保证保持，并有最终组合与独立审计证据。

> - recoverySubstitutions：MST-R16移出实际itemIds，保留为historicalWaveId=MST-W02的blocked节点；MST-R34是唯一实际成功owner，完整承接P16迁移、显式fixture JDK接线及最终相关版本59方法/内容/证据义务。R34 completed须有完整可关联Result和下述证据，不能自动把R16升级、满足旧item或释放gate；Router仍逐项核定替代承接及全部原gate条件。不要求旧R16变为completed，也不豁免其原完整保证。 MST-R22同样移出实际itemIds，保留historicalWaveId=MST-W02、state=failed及generation1无终态/候选撤回/旧driver34通过事实；MST-R35是其唯一有效成功owner，完整承接原固定archive迁移、等价、删除与回归义务，改为用户已确认的对应测试资源承载。R24/gate须消费R35新的完整可关联completed Result并核对承接，不要求旧R22升级、不再次resume、不把旧34当新验收。

> - gate：R23须有真实完整可关联completed Result及本项全部迁移/回归证据；当前未知身份与旧driver共享通过均不能满足。21个实际成功member（R34替代R16、R35替代R22）的完整可关联completed Result均须已采用；R25同次有限组合及内容/静态消费满足下文，R26独立结论ready；11类、S1–S8、G01–G18/F01–F18、R07原16行逐条充分，所有保留动态操作有具体必要性与实际caller。任何缺项/partial/blocked/failed/非ready不释放。Router独立判断release；作者维护不完成item、不释放gate。

> R13–R15/R34/R27–R33/R17–R21及R35已采用completed仅为本次背景，不另增登记任务或重做测试；其它原pending投影不重置其历史。R23当前原固定writer存活、原Result身份未知，不能作为满足的成功前置，事实更正见Context。历史首次独立review completed/not-ready（原复合caller）、上轮细分后局部独立review completed/ready保留；旧ready不覆盖本次R23候选方法及必要连接。原R16 blocked及八路径/59通过、R34承接、R22 generation1无终态/诊断/resume generation2 failed及候选撤回/旧34通过均保留，不再次resume、不升级旧failed。

> R35将冻结包归属、资源处理、类内copy、固定caller替换/删writer及改后34方法合在一个终态：全部G09固定archive已静态承载且由原真实操作/断言消费，故部分资源拷入或单独hash检查不构成独立可消费Result。R23的精确stream ZIP是另一独立迁移终态：六entry整包/cleanup静态承载、真实私有copy消费、payload独立长度/hash、删固定writer及聚焦回归只共同建立其结果；部分资源就绪/单独hash不是另一个可消费Result。R35已完成的21包不并入；本次只候选调整R23原Jar承载方法，全部原ZIP/流合同不减，待独立review及C6明确确认。原各caller在其它迁移失败后仍可独立保留，必要helper可增量兼容；共享写面只串行，不制造成功依赖。

> 全局生成入口收敛R24消费全部18个迁移结果；R25的同次组合和R26的只读充分性判断有独立终态。每项各一Handler/一Result，聚焦验证仅证明自身迁移。R16原全部义务由R34、下方P16分配和完整G04/共享集合承接；R22原全部义务由R35及当次五类34方法承接，均未转移到收敛项代做。
> 所有迁移item：自身selector取下表完整类及精确方法集合，另跑列明共享消费者。命令形状为 `./gradlew.bat :minecraft-codev-mixins:test --tests <完整类selector> ... --rerun-tasks --no-build-cache --offline --no-parallel --max-workers=1 --no-daemon --no-configuration-cache --console=plain --stacktrace --info`；XML方法集合匹配、0failure/error/skip、外层test SUCCESS/executed。单方法debug不能替代整类/必要共享回归，必要权限/OS用例不能skip通过。外层与嵌套cache的SUCCESS/UP-TO-DATE/FROM-CACHE/预期FAILED分层记录，不改原流程造通过。

> 写面：相应Mixins测试、现有 ordinary/pipeline 静态工程内最小variants/完整caller、R35专属src/test/resources命名空间与短说明/hash记录，以及R23候选的strip-stream专属资源/说明与StripStreamTests类内copy/断言；必要OrdinaryInputs/PipelineInputs/StripFixture与测试helper；复用已有系统属性、pluginUnderTestMetadata/classpath/testOutputs/SPI接线。现有inputs.dir子树足够则不改模块build，不增属性/通用框架/DSL/manifest/receipt/CLI/includeBuild，不改production/deps/lock/authority/根接线/JDK跟随策略，不删除/重命名Spec现存测试链接目标。暴露额外写面/真实行为变化应报告精确边界。

> 普通输入各项Result给出固定输入→实际JavaCompile/Jar任务名/TaskOutcome→copy/消费者→内容断言关联；R35及R23候选分别改为各自已核冻结输入→各自src/test/resources→现有processTestResources实际TaskOutcome及输出→test classpath资源流→私有copy→真实consumer/断言和五阶段整包/cleanup hash，不虚构JavaCompile/Jar或新增fixture构建前置。R23自身限定写面及不改共享helper的最小方案见其节点。资源Jar明确不需要JavaCompile，不能虚构编译；新固定源码沿用release11/UTF-8/-proc:none并核major55/隔离sourceSet。复用ordinary compileJava/compileProducerJava/compileMappingTargetJava/compileMappingJava、mapping-target/mod/trace-plugin与pipeline compileTargetJava/compileSourceJava/compilePlugin40Java/compilePlugin43Java、target/source/plugin40/43模式；新增实际任务名称在实现Result登记，不以assemble/Jar存在代替消费。记录diff、输入/源码/fixture/build/SPI前后内容标识、命令/环境/断言、删除入口及保留caller，沿用现有证据机制。

> - conflicts/successor：原准备时R22/R23历史执行结束/资源释放→R35→R24只表示冲突，未证明R23迁移完成；R35现已结束并采用completed，不重做。当前候选改为R35结束/资源释放→R23受影响实施→R24，与共享写入者串行。R24消费本项有效completed并核对R22原全部义务，同时仍须真实R23 completed，不能以本项G11共享回归代替R23。R25同次组合、R26独立ready及W02 gate仍必需。

> - prerequisiteItemIds: [MST-R13, MST-R14, MST-R15, MST-R34, MST-R17, MST-R18, MST-R19, MST-R20, MST-R21, MST-R35, MST-R23, MST-R27, MST-R28, MST-R29, MST-R30, MST-R31, MST-R32, MST-R33]

> - predicate：重新逐caller核对11类ToolProvider/JavaCompiler、源码字符串、JarOutputStream/archive/jar/project/config/refmap链，固定生成均已替代，死入口已删，剩余writer仅服务具体当前输入/特殊ZIP局部/control/故障输出用途。三处runtime javac消失；InputBinding的import及Attempt/rejects按无caller证据清理，不误删FailureStage真实rejects。共享 `MixinPreapplicationTests.jar`/`MixinInputBindingTests.replace` 如仍服务当前输入变化，保留其byte/order/error语义并列每一caller/必要性。“isolation/fault”用途标签不能证明必须动态生成。

> - scope/evidence：仅上述测试helper/import/失去消费者的旧资源/生成分支；旧r04/Plugin.java、mapping/TracePlugin.java、pipeline-caller.gradle在消费迁完后删或保留单一静态来源。逐入口给源码位置/实际caller/静态替代/保留理由；变更共享helper用G01–G14完整闭包回归，纯死代码删除则静态无caller核对并由R25组合覆盖。ASM/defineClass/IO.OutputJar等真实故障探针不误删。18个有效迁移owner Result（含R34替代R16承接P16、R35替代R22）是判断全局入口收敛的真实前置。R16原blocked和部分效果永久保留；R34成功不自动满足旧item，R24核对完整承接后才可收敛，不能代做其接线/59验收。R22原failed和候选撤回/旧driver34永久保留；本项须读取R35新的有效completed Result，逐项核对21包资源处理/classpath/private-copy/原字节metadata及固定writer删除和改后34证据，不能靠旧R22升级或在收敛项补做迁移。另须读取R23真实完整可关联completed Result，核对六entry/固定cleanup的已确认承载方法、五阶段原字节复制/metadata、两真实consumer/payload独立长度/hash、删固定writer及同版G11/G09/G13精确17方法（或真实helper变更后的原闭包）证据。R23当前未获满足、身份未知或候选尚未确认时不能放行；本项不能代做R23迁移/验收。

> - predicate：同一最终工作树/解析图/环境从根`:test`同次实际执行G01–G18/F01–F18（当前101/14/16共131方法），0failure/error/skip；三模块test SUCCESS/executed、root NO-SOURCE正常；每种残留输入有静态消费/实际内容证据：普通输入为JavaCompile/Jar任务链，R35的21包及获确认后的R23六entry整包/固定cleanup分别走现有processTestResources/classpath→私有copy链并证明原字节保真，不要求ordinary Jar重打包特殊输入。方法变动逐一解释，不能只凭131passed认定静态化。

> - execution/writeOwnership：复用上方R09有限init filter/根dry-run与实际命令形状，临时init用既有build下本轮单独目录；实际命令/输出导航由新Result记录，不能冒用R09日期/路径/结果。只写当次Gradle/TestKit/build/temp证据，不修代码/登记四文档。R24传递消费18个迁移结果；保全R07/R09/R11现存证据，不能清整个build/user-home。

> - evidence：G表逐方法→当次XML/TaskOutcome→源码/真实输出，覆盖1→42、raw键/双Strip、当前输入/SUCCESS/UP-TO-DATE/新runnerFROM-CACHE、全部真实故障/close/identity/suppressed/重试、F16六fault fresh retry、R07全16行/非空AT/JarJar/nested/13bytes vendor。记录普通静态JavaCompile/Jar及R35/R23各自现有processTestResources/实际classpath/复制前hash/真实consumer，R23两方法的六entry/cleanup/payload独立长度/hash及全部ZIP/真实bulk故障/fresh retry关联；同时记录各层环境（外层、每launcher、每fixture JDK17完整版本/路径/实际锁定方式）和Gradle/解析图、Java11参数/major55、输入前后稳定性。正常cache重放不冒充新引擎执行；不改变现有JDK跟随策略。运行输出覆盖前保全当轮XML/log/fixture内容，build仍可清理。旧131/Fabric14/历史Results只支持未变边界对照，不证明本轮修改路径，也不拼成新运行。

> - checks：三处javac消失、完整caller不再拼工程、共享writer全部caller及动态必要性、R35全21包与R23六entry整包/固定cleanup各自资源归属/现有资源处理/copy-consumer/hash及原始ZIP metadata等价，R23核对方法变更已明确确认、两真实consumer、payload独立长度/hash、固定writer删除与同版17方法/必要实际闭包，不用旧R22/R35共享G11通过代替；保留ASM/流/权限/并发操作及实际时序、最终diff/解析图/环境/方法集合与回归充分性；独立Strip无producer，同FQCN不进入宿主，原断言不弱化。核对双语Spec input-tests/mapping-tests存活条件，不写authority；不能以数目/旧R12代替静态化审计。

> | S1 | R13–R23（R16由R34、R22由R35承接）及R27–R33固定源码/资源/完整caller静态消费、R24全11类生成入口删除/限定；R35全部21特殊包已采用对应测试资源/classpath原样复制，R23候选同链承载六entry整包及cleanup，全部原ZIP/流/输入保护合同不减且待方法变更确认；普通JavaCompile/Jar不变，不能以隔离/故障用途代替动态必要性。 |

> | S7 | R25根dry-run/三模块执行/SPI/pluginUnderTestMetadata、普通静态任务及R35/R23各自现有processTestResources/classpath/private-copy实际消费、Java11 UTF-8 -proc:none/major55及各层JDK17，无新增fixture任务/系统属性或工具链策略变更。 |

> 所有新项共享一个排他冲突边界：Java基类/writer/helper、ordinary/pipeline静态工程/caller、StripMixinsTests及候选StripStreamTests各自专属测试资源/说明/hash、Gradle/TestKit/JVM/cache、模块资源处理/test classpath输出/历史证据及相关源码/四文档快照。实施/运行/清理/文档写入不得与R26快照读取并行，亦与历史锁当前使用者互斥；纯共享读取不构造冲突。以下仅为结束/资源释放顺序，前项blocked不作为成功依赖；成功前置只以节点prerequisiteItemIds为准。

> 原residualSerialization候选段：
>   - from: MST-R35
>     to: MST-R23
>   - from: MST-R23
>     to: MST-R24

> ### 当前作者语义自检（MST-W02，非独立 review）
> 
> 前轮R35准备自检是历史：当时曾核42节点/92边、21 member/18 owner、131方法/34聚焦、107本地引用及16锚点；当时“资源未实施/R35未完成”不描述现在。该自检关于“R23原合同不变/已完成”的适用性现被收窄；旧R23完成声明身份未关联的更正见Context，不推断从未执行或制造failed。R35实际completed与旧review结论各自保留。
> 
> - 本轮唯一结果为四文档R23局部一致候选计划及作者自检。已加载documentation-waves-writing/documentation-plan-writing，读取六个指定ref和全部inline；复用PRD/ADR/Spec三族assessment，不写authority、不登记accepted ADR。R23资源、copy、payload长度/hash、删writer及聚焦回归只共同证明同一迁移终态；R35、R24收敛、R25组合、R26独立判断不合并，不调度。
> - 当前源码及R35冻结源码hash一致，固定writer/两个实际消费者已读；两套现存input.jar/cleanup均逐字节hash并解析全部六entry、local/central header及内容，Jar 80882 bytes、cleanup 53 bytes、payload 40001 bytes，精确hash/顺序/metadata见Context与R23。来源可达且完整，未来strip-stream资源尚未创建，不作已存在ref。复制候选沿现有processTestResources/classpath→类内关闭流的Files.copy→每测试私有路径→原直接/反射StripFixture；resource仅是retry期望值，私有input.jar读取加独立冻结长度/hash即可，无需额外payload。readAllBytes禁止仍作用于真实生产bulk消费，当前class ASM/defineClass与IO.OutputJar探针保留。
> - R23候选以原字节资源五阶段保真替代原Jar-task等价承载前置，六entry、JSON whitespace/unknown、time/comment/extra/STORED/CRC/order、8192故障、exception identity/suppressed/关闭/原输入与cleanup/无当前输出及staging/fresh retry等全部原断言不减。等价、两caller接入及无残留固定调用后才删writer；缺来源/资源硬失败，不生成或重打包。自身资源与消费者写面明确，无新增Gradle Copy/Jar/fixture属性或共享框架；未来来源说明解除日后运行对可clean build的依赖。
> - R22 generation1无终态/诊断/resume generation2 failed、候选执行但不等价/撤回/旧34通过全部保留；R35 generation1真实completed（21包4824 bytes/33 entry、五阶段保真、固定writer删除、同版五类34全过、三层Microsoft JDK17.0.19+10-LTS/Gradle9.4.0）已加工为背景，无独立登记任务。R16 blocked/八路径59、R34及其它已采用completed、旧W01释放和历次not-ready/ready不重置或重做。R35共享G11通过不能证明R23静态化。
> - 只读解析联合item前置、串行边、member→Wave gate及前置Wave gate→member：42节点、92条去重边无环。W02仍21实际member/18迁移owner，R24的18成功前置与owner集合完全相等，包含独立R23；R25只依赖R24，R26只依赖R25，W02无前置gate/自等待。串行改为R35已结束/资源释放→获确认后的R23→R24→R25→R26，不制造额外成功前置、不重演R35；全部共享资源/Gradle/JVM/cache/输出/证据快照写入者排他。R24仍须真实完整可关联且证据充分的R23 completed，R25根131同次组合、R26独立ready及W02原gate保持。
> - 精确方法表与当前18源码类逐名匹配131（101＋14＋16），G04八owner覆盖16个唯一方法；原G表/P分配未改。R23聚焦G11 2＋G09 11＋G13 4＝17；真改StripFixture才加原G02/G03/G04/G05/G07/G08/G12/G14，共88，公共普通helper/writer实际闭包仍G01–G14共101。R35原五类34不减、不拼入新17。131处本地引用解析到68个可读仓内文件、20锚点存在；无项目外Result入口或Context间接依赖。对照R35冻结四文档（原读取片段一致）逐段核旧W01完整合同/历史、R16/R34、G表/P分配未变，Context从R16详细诊断起全部历史字节对应文本保持；R23原方法前置的material改动已明确，不能宣称其原合同文本未变。
> 
> 本次material边界为R23承载方法、payload断言/五阶段等价及删writer前置、资源/消费者写面、与已完成R35和共享写入者串行，以及R24–R26/W02必要连接；Plan S1/策略/风险/验证同步。仍待不同Handler独立delivery-plan review及Router C6 affected-scope披露/用户明确确认，不以沉默、R35历史确认或作者自检当作接受。此处只报告作者静态检查：未实施、未运行Gradle/JUnit/准备或生成脚本、未复制基线、未改源码/资源/build/依赖/lock/authority/工具链/LLM指令或Git；未完成R23、未判断实际gate通过、W02保持pending。ZIP的JDK实际等价/新五阶段copy及新17方法均待实施验证，build证据可clean/覆盖，原R23身份缺口保持。
