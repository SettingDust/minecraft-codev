# Mixin Kotlin-first 重设计 · processed Context

[Work](work.md) · [Plan](plan.md) · [唯一执行图 Waves](waves.md)

## 输入与权威

本 Context 是派生事实和限制，不是原始 Result、第二 Spec 或实施许可。三族 owner/reuse 判断见 [Work](work.md#原权威复用)，细则以[英文 Spec](../../spec/mixin-preapplication.md)为准，[中文 Spec](../../spec/mixin-preapplication.zh-CN.md)用于同义核对。

用户接受整体三图后，原 Plan 独立审查及 Router 披露完成，用户明确“开始”；I01 阻断后的 raw-control 库标准政策/恢复图也已对齐并独立审查（blocking defects=0、insufficient evidence=0）。R01/I02 completed、旧 W01 satisfied，随后 I03 partial 已由 Router 完整采用。用户后来接受八点简化及原生 required/optional/plugin/refmap fallback；八点新版 `codev-mixin-eight-point-review/g1` completed 已由 Router 完整采用（无阻断/重要证据缺口），披露后用户再次明确“开始”，新版实施范围已确认。S01→S13 局部恢复 review 后来也已通过。本次只在该范围 C5 授权内维护 S09 partial 后剩余普通引擎诊断可见性的四文件和作者自检，不实施修复、不独立 review、重选 authority、派发、Todo 或 Git 写入；S09→S14 图变化仍须受影响边界独立审查，未变范围不重复审批。

**当前完成维护说明**：上段“本次”是 S09 恢复图准备时点；待审查/未执行措辞不再表示当前范围。最终状态与实际执行记录见下节；本次只持久记录 Router 判断。

### 可靠采用的文档前置（不是本次运行结果）

| task / generation | 已采用的有界事实 | 限制 |
| --- | --- | --- |
| codev-mixin-design-spec-align / g1 | completed；仅原双语 Spec 对齐；25 处本地链接及 diff 静态检查通过。 | 不证明新实现；当前完整原文已读取。 |
| codev-mixin-prd-status-align / g1 | completed；仅双语 PRD 技术现状及中文引用对齐；10 处链接/diff 通过，Active 和 R/AC 未变。 | 不是产品目标重选或运行验收。 |
| codev-mixin-adr-design-align / g1 | completed；原同 identity ADR 局部对齐；8 个历史/核心块逐字保留、22 个链接及 5 个 fragment/diff 通过；Handoff 明确完整 Result 已读取解码并核对。 | 本次不重跑这些检查、不重写 ADR；不承诺仓库含原始 Result。 |

这些初次文档对齐事实继续按可靠采用的原范围保留；初始准备曾核对六份引用材料及必要工作树。本次读取现行双语 Spec、英文 PRD、同 identity ADR 和本目录四文件，复用未变的先前源码观察与三族 assessment；日志局部 reuse 已由 Router 采用并可见，R4/R6/AC4、Spec 诊断诚实/Engine outcomes and logs 与同 identity child-service owner 已充分覆盖，不另选日志政策。Spec 内旧的摘要同步/未确认说明保留其维护时点意义，不否定后续 PRD/ADR 对齐或用户确认；本次不改这些只读 owner。

### 本轮权威同步的后来事实

本轮 assessment 三族均 reuse，owner/边界见 [Work](work.md#原权威复用)：PRD 当前 R3/R6 与 AC3/AC4 已覆盖正常引擎 fallback/真实失败；双语 Spec 已覆盖八点及九行验收；同 identity Accepted ADR 已覆盖 Core reuse/平台所有权/selector 窗口与并发代价。沿用 Router 已完整采用的 completed 对齐 Results，不重复查权威或把 HTML/D 盘当新版 owner。

- `codev-mixin-eight-point-adr/g1`：**blocked，零写入**，保留原 writer 失败事实。
- `codev-mixin-adr-edit-recovery/g1`：**completed**，只改原 ADR；使用已注册 edit，22 本地引用/5 锚点及 diff 检查通过，未跑项目。不是为工具失败新增实施项。
- Spec/旧 Work 中“ADR 尚待同步”等是前时点注记；后来的恢复完成已限定其适用性，本次不越权改只读 authority。原三图 Core 解耦/虚拟 service 重定向被八点同 owner 细则取代；fresh loader、通知/all-match、文件接口与失败/复用核心未重选。

### 已采用的实施阻断及局部政策变化

本节所有“本次”“活跃四项未完成”“W01 未释放”均描述阻断与恢复图维护时点，非新版当前图；后来的 R01/I02/W01/I03 状态见下节，不改写旧 I01 blocked 与政策变化。

- 原计划初次独立审查完成，blocking defects=0、insufficient evidence=0；只支持原 Plan/Waves 字节和范围，不支持本次恢复图已经独立通过。随后用户确认整体实施范围，不需重议未变部分。
- MKF-I01 首次配置契约 Handler 的完整 Result 已由 Router 关联并采用为 **blocked**，不是 completed；后端任务 completed 仅表示终止。没有修改生产/测试/权威/图，也没有已完成实现可回放。平台编译/测试、SPI/host 接线、显式编辑等四组必要检查均未完成；没有 JUnit 计数，W01 未释放。
- 当次离线 dependencyInsight 确认 Fabric runtime JSON JVM 1.3.3（Gradle 9.4.0，既有 JDK17）。临时 source-launcher 使用缓存 JSON/core 1.3.3＋stdlib 2.3.0、JBR 21.0.11、`isLenient=false`：有效 `mixins:[]` 加未知 `custom` 字符串时，`parseToJsonElement` 与 `decodeFromString<JsonObject>` 均接受 U+0000–U+001F，32×2＝64 次解析；最终拒绝断言实际 exit 1。malformed 对照拒绝；重复键两入口 DOM 一致但未冻结 last-value。这仅是库探针，不是 handler/迁移/JUnit 验收。
- 用户随后接受的新政策已落在[原英文 Spec](../../spec/mixin-preapplication.md#entry-file-and-json-semantics)和[同步中文稿](../../spec/mixin-preapplication.zh-CN.md#条目文件与-json-语义)：所有 Codev DOM 路径（metadata/config/parent/refmap/entry-file）及未知字段字符串，不额外保证拒绝 raw control；重复对象键也沿用实际库行为。不固定接受结果或 last-value，不加扫描器/包装、不升级依赖；严格 UTF-8、其它格式错误、resource/side/原串业务规则和输入保护仍须验证。
- 此次 Spec 对齐只改原双语 owner 各四个块，英文 12、中文 13 本地链接及适用锚点、双语增量与 diff 检查通过；没有代码/项目/探针验收。三族为 PRD reuse、Spec update 已完成、ADR reuse，详见 [Work](work.md#原权威复用)。本记录不把静态文档检查当实现证据。
- 探针临时源码已删除，仓库无原始探针/证据包；可靠采用的事实不因此失效，也不承诺完整原文永久可读。本次不补跑、复制运行会话、外部 Result 定位或建证据包。[Waves](waves.md)保留旧 I01 blocked，仅由 R01 承接未完成配置契约；活跃四项与三个 gates 均未完成，恢复成功也不改写旧 I01。

## 已采用的组件完成与 W01 判断

本节保留前次完成记录维护采用的 R01/I02 Results 与 Router 独立 W01 判断；I02 原 Result 当时已完整读取解码。R01 四组、I02 五组要求按原范围满足，记录 **MKF-R01 completed、MKF-I02 completed、旧 MKF-W01 satisfied**，不是本 Writer 重评。下列“无 Core inheritance/编辑冲突”描述原完成效果，不是八点当前目标；新差异须另验，不能重写旧成功谓词。项目源码/测试只是定位，不是完整原日志或 Result 永久副本。

- **R01 配置契约**：专用 `load` → handler 与 resource/side 快照（ConfigSide COMMON/CLIENT/SERVER），快照脱离关闭 ZIP 可用；Fabric/Forge 真实 remove/removeConfigs、引用变更/双 metadata 冲突及格式/业务保护保留。Fabric DOM 移除 StrictJson 预扫，重复键/raw-control 的 load、编辑与未知值保留对照实际库，严格 UTF-8/业务负例通过；Forge Manifest/TOML 政策不变。host 仅 discovery 接线与直接 fixture/SPI 迁移；Core listing/Jar-in-Jar inheritance、旧 applicability/selective handler 和独立 environments 退出，未重写 child/执行/发布架构。定位：[listing](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt)、[Fabric handler](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinConfigHandler.kt)、[Forge handler](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinConfigHandler.kt)。
- **R01 实际验证**：Gradle 9.4.0 / Kotlin 2.3.0 / Microsoft JDK 17.0.19 / serialization 1.3.3。最终适用版本分两轮 27 tests，0 failures/errors/skipped：Mixins realDifferentArtifactsAndIsolation 1；Fabric metadata 9＋applicability 5；Forge metadata 10＋retained-baseline 2。首轮平台 test compile 因本次 enum 误改失败，修正后上述平台回归全过。13 文件主动 LSP 0 diagnostics；未测整仓/游戏，未改版本、协调文档或 Git。
- **I02 独立 Strip**：[StripMixins](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt) 自管生命周期、退出 OperationPublication，无 engine/discovery/metadata edit；[stripper](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/ExactMixinStripper.kt) 来源无关 removalsFile＋serialization DOM all-match，未变 config 保原 bytes，变更保其它 DOM/顺序/资源与 CRC/STORED。`AppliedMixins`（当时 entry-file owner，后来 S06 已删除）的文件写读当时可由 host 使用；现行写读定位见下方 S09 恢复记录；host 仅补 JSON/core 实现输入。真实手写/其它任务文件分别驱动注册 Transform；all-match/保留、坏 ZIP、严格 UTF-8/业务/path 负例、32 种 raw-control 与重复键对照实际库 DOM 均有实测。
- **I02 失败与交接**：实测写入、输出流 close、中断、move 失败；先有旧结果再失败消费、retry，以及原路径/hardlink/junction/real-parent alias/目录包含/同目的地冲突。失败不冒充旧成功，输入和另一操作结果保持。当前 host 回归实际观察目标 1→42、entry-file 读写及 Strip 交接、默认与仅自定义 target 的 applied-only 两种 TestKit；不把这些称为 I03 新隔离 producer 完成。定位：[Strip tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripMixinsTests.java)、[DOM tests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/StripDomTests.kt)、[registration tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripRegistrationTests.java)。
- **I02 实际验证与修正**：同一 Windows amd64 / Gradle 9.4.0 / Kotlin 2.3.0 / Microsoft JDK 17.0.19 / serialization 1.3.3。实际模块 selectors 为 Mixins 的 StripMixinsTests、StripDomTests、StripRegistrationTests、MixinSafeRetentionTests、MixinPreapplicationTests.realDifferentArtifactsAndIsolation、MixinProducerTests 的 validEmptyIsNotMissingOrMalformedInformation / exactRawKeysDuplicateSourcesArraysAndUnnotifiedEntries / taskTracksProducerInputsAndBothOutputs、MixinInputBindingTests.testKitProducerDefaultsAreQueryableBeforeExecution；最终 23 tests 全过。FabricApplicabilityRepairTests 另 5 tests 全过；两次成功运行共 28 tests，0 failures/errors/skipped，**不与 R01 的 27 合计为 55 个独立 tests**。命令使用现有 wrapper 的 :minecraft-codev-mixins:test / :minecraft-codev-fabric:test、--tests selectors，均 offline/no-configuration-cache/no-parallel/max-workers=1。扩展首轮 23 中 1 fail 是 fixture 的 Provider<File>→RegularFileProperty 绑定，改为 layout.file(entries.map { ... }) 保显式依赖后相同 selectors 23 全过。10 个变更文件主动 LSP 有 23 条辅助风格警告、6 文件未确认，**不称 LSP clean**；实际编译/tests 和限定 diff 检查通过。
- **Router 的 W01 判断**：两份 completed Results 分别提供平台 snapshot/直接 caller 可用且无 Core inheritance、独立 Strip/DOM 文件交接可用且无 metadata/engine 调用并退出通用 publication 的证据；必要正/负/保留/真实失败及严格 UTF-8/其它格式/业务/path 保护满足当前 W01 全部要求。不是单凭通过数、类名删除或文件存在判定。
- **当时未完成/复用限制**：R01/I02 完成时 I03/I04、W02/W03 尚 pending；后来 I03 partial 已完成旧框架最后调用退出，见下节，不能继续写成尚待清退。I02 自身未重跑未影响 Forge 等，未测整仓/游戏、独立缓存终验、其它 OS/FS；其 close 故障仅输出流，不证明 producer 输入 ZIP/loader close。同目录 ATOMIC_MOVE 不支持时失败而非回退；手写集合的业务选择/语义陈旧由提供方负责。

上次完成记录维护的 Handler Result 仍为 **blocked**：apply_patch 命令缺失，四文件前后逐字未变、零写入且无维护后检查；终端 metadata completed 仅表示运行结束。本次以已注册精确 edit 恢复未写入记录，不回放任何生产效果，也不把旧 blocked 改称成功。原 MKF-I01 同样仍 blocked。

## 已采用的 I03 partial

本次完整读取指定原始 transport envelope 并解码同一 Result；`subagentId=codev-mkf-isolated-producer`、generation 1、transport completed，**Result status=partial**，可靠关联 MKF-I03/旧 MKF-W02。后端终止不是业务完成。下列处理后记录不复制运行时定位，也不承诺原始 Result 永久可读。

- **已做**：Mixin→produceMixins→fresh IsolatingMixinClassLoader→Kotlin whole-JAR applyMixins；真实 transformer/recorder、task/implementation 分域、tracked inputs/两 outputs、身份/包含/物理输出独占、TCCL/cause/失败 pair 清理已落地。OperationRunner/EngineOperation/PinnedMixinAdapter/StrictJson/OperationPublication 及旧 SHA 的源码/直接测试/反射/生成 callers 退出搜索当时无匹配；这仅证明旧调用清退，不是全部行为验收。复用 R01 snapshot/平台编辑及 I02 DOM/Strip，未把其 close 证据算作新 producer 证明。最后修复缺 target/source/runtime/mapping 时在失效旧 pair 前因 isSameFile 退出的问题，新增 old-pair 失效/Strip 消费失败/raw 保持/retry 观察。
- **未做/不足**：第 1 组未直接充分观察完整返回 graph 为 JDK 值及 archive→return→loader close→entry→两输出各节点；第 2 组 unknown 测试仍含旧 auditTrail，不能证明新 recorder 真收到 unknown，dynamic 无原键通知也有缺口；第 6 组尚未触达真实 target/entry 流中途 write、entry stream close、输入 ZIP close。已有 checkWrite 主要是打开写时失败，不是中途/close；I02 Strip stream close 不可替代。原未完成第 3/4/5/7 组中仍适用输入域、mapping、状态/DOM 保护继续保留，而非复活被八点撤销的预扫或正常 fallback 拒绝。
- **A 实际运行**：`:minecraft-codev-mixins:test` 的 MixinProducerTests / MixinPreapplicationTests / MixinFailureStageTests / MixinMappingTests / MixinOperationIsolationTests / ProducerDomTests，suite 数 13/5/8/6/4/3；一轮 **39 tests、0 failures/errors/skips**。在最后 missing-input 补丁之前，未声称最后补丁后整轮重跑。
- **B 实际运行**：Mixins 的 StripMixinsTests/StripDomTests/StripRegistrationTests/MixinSafeRetentionTests，MixinInputBindingTests 的 task*、identicalConfigPluginAndRefmapShadowsAreRejected、cleanupConsumptionDoesNotReplayEngineBindings、testKitProducerDefaultsAreQueryableBeforeExecution；Fabric 的 FabricApplicabilityRepairTests/FabricMixinMetadataTests；Forge 的 ForgeMixinMetadataTests/ForgeRetainedBaselineTests。一轮 Mixins 24＋Fabric 14＋Forge 12＝**50 tests、0 failures/errors/skips**；平台编译/直接 caller 实际执行，Forge 有 always-true instance-check 警告。
- **C 最后聚焦**：ProducerDomTests.missingInputsInvalidateEarlierPairWithoutChangingRawInputs、MixinProducerTests.taskPreservesRawInputsAcrossHardlinksParentAliasesAndDirectoryGuards / actualWritesAndSecondMoveInvalidateOldPair、MixinOperationIsolationTests。初轮 **7 中 1 fail**（缺失 protected input 的 isSameFile）；修正后磁盘 XML **7 tests、0 failures/errors/skips**。最后同命令 BUILD SUCCESSFUL 的 test 为 **UP-TO-DATE**，不算再次执行。A/B/C 有重叠且字节版本不全相同，不累加成独立验收数。
- **其它聚焦与限制**：ProducerDomTests 曾因 JSON 转义测试编译失败后修正通过；actualLoaderCloseFailureBlocksHandoffAndPublication 已真实触达 loader close 拒绝，解除拒绝后释放测试句柄；samePhysicalDestinationRejectsProducerButAllowsCompletedReaders、取消/冲突聚焦也通过。均与上述轮次有重叠。所有命令沿既有 wrapper、对应模块 test 与上述 --tests，flags 为 --offline --no-configuration-cache --no-parallel --max-workers=1。
- **环境/静态**：Windows / Gradle 9.4.0 / Java 17 toolchain Microsoft JDK 17.0.19，shell JBR 21.0.11 不是测试 JVM；沿既有 Kotlin/serialization 版本。主动 LSP 最后两文件有 8 个辅助 warnings、1 inconclusive，不是全文件 clean。git diff --check exit 0，有 LF/CRLF 提示；未 stage/commit/push。SecurityManager JDK17 故障设施有弃用限制，不因此提高生产最低版本。
- **状态联系与便携 artifacts**：旧 I03 仍 partial，W02 未释放、I04 未执行、W03 pending，不判 Plan 完成。源码定位见下节 [producer/loader/child/recorder](#本次定点源码观察静态不是执行证据)；聚焦 [ProducerDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt)、[producer tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java)、[isolation tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinOperationIsolationTests.java)均为项目 artifacts，不是完整原日志。新版差异与残余证据分别交 [Waves](waves.md) 的 S01–S08/S12、S09/S10；不回放已清退旧框架或重做 fresh seam。

## 已采用的新版实施与 S01 恢复边界

以下“本次完整读取”“S13 pending”“所有新版 gates 未放行”及源码/XML 可读快照均为前次 S01 恢复维护时点；后来 S13 completed、Router W04 satisfied 见下一节，不改写原失败或方法。

本节是 Router 已完整读取关联采用的处理后事实；本次又完整读取并解码 S01/S04 原 transport envelope（均 generation 1，transport completed；内层分别 partial/completed），其余兄弟事实沿 Handoff 采用。不持久化会话/外部 Result 定位，不复制完整报告，不声称当前重跑或原文永久可读。

| task / item | 已采用终态、实际方法和结果 | 版本与复用限制 |
| --- | --- | --- |
| `codev-mkf-core-contract/g1` / S01 | **partial**。两 Mixins 接口继承 Core，Core 仅 list/remove 两行注释，平台 list 与 Java SPI/fixture 迁移已做。真实 SPI→Core load/list、关闭 ZIP 后重复 resource/side 快照、显式 remove/removeConfigs、Java producer 1→42/raw 不变、Fabric AW/nested-JAR 与 Forge JarJar 基线均有通过。两轮共 8 个不同 selectors **6 过、2 Windows TempDirectory cleanup fail**；Fabric 失败重试不新增独立覆盖，Forge 第一轮未执行、第二轮 4 中 3 过。 | 原 Forge 为 combined adapter，不能冒称现行独立 handlers 当时已验；失败整体仍失败，不因测试体未报告断言失败判绿。Core/Mixins/平台编译成功，Includes compileKotlin 为 UP-TO-DATE，不是完整 Includes Transform 集成验收。 |
| `codev-s01-cleanup-diagnosis/g1` | **completed** 诊断：Fabric 实证 loader/引擎资源未关闭；Forge 历史同因未证。 | 诊断不是 S01 验收/资源修正结果；后续成功不倒推历史归因。 |
| `codev-mkf-fabric-current-edit/g1` / S02 | **completed**。当前 JSON 两入口/新增引用/未知 DOM 保留；最终 metadata 11＋applicability 2＝**13 tests 零失败**。 | 前两轮各 1 个故障测试实现失败后修正，不把三轮加成 39；按当前源码/fixture 判断 S01 证据复用。 |
| `codev-mkf-neoforge-toml/g1` / S03 | **completed**。NeoForge 独立 TOML 和 Forge Manifest-only/SPI/直接调用迁移；当前 TOML 编辑、双格式发现及 producer 保留；metadata 12＋retained 2＝**14 tests 单轮全过**。 | 当时保留 Manifest snapshot-age 逻辑，后由 S12 完成；不能重写 S03 当时范围。 |
| `codev-mkf-forge-current-edit/g1` / S12 | **completed**。仅 ForgeMixinConfigHandler/ForgeMixinMetadataTests；checkReferences/重复读/equality 删除，两入口按当前 Manifest 编辑、保留新增及未知 main/entry attributes，真实 read/write/close 故障向外；metadata **14 tests 单轮零 failure/error/skip**。 | 不与 S03/其它轮相加；Manifest/TOML 显式原地写失败可能留下部分内容，无新增事务保证。 |
| `codev-mkf-resource-ownership/g1` / S04 | **completed**。ArchiveResources 删除且直接引用退出，discovery/child/loader/recorder/Strip 资源与路径保护归实际 owner；loader scoped 读完并关闭底层流后返回 ByteArrayInputStream，原 IOException cause/suppressed 保留。强持有返回流→关 loader→Windows 独占打开/删除 JAR→仍读完整字节、真实 read/close 失败和歧义/目录资源三个正式资源测试成立；两个原平台 producer 最终连 cleanup 全过。 | 返回资源内存随大小增长；Windows/JDK17 实证不推广其它 OS。不是 S10 完整 producer 生命周期或 S11 caller/cache 验收，也不自动完成 S01/S13/W04。 |

**S01 原方法与八个 selectors**：现有 wrapper，`:minecraft-codev-mixins:test` 的 `MixinPreapplicationTests.realDifferentArtifactsAndIsolation`；Fabric test 的 `FabricMixinMetadataTests.closedZipHandlerRetainsDuplicatesEnvironmentsAndRealWriters`、`actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits` 及 `FabricApplicabilityRepairTests.producerNotificationsRespectApplicabilityAndInputOwnership`；Forge test 的 `ForgeMixinMetadataTests.closedZipHandlersPersistSelectiveAndFullRemovalForBothMetadataFormats`、`actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy`、`producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata` 及 `ForgeRetainedBaselineTests.jarJarRemovalDeletesListedPayloadAndMetadataOnly`。各以 `--tests` 传入，`--offline --no-configuration-cache --no-parallel --max-workers=1`，第二轮带 `--continue`。两个失败正是 Fabric applicability producer 与 Forge dual-metadata producer；两次命令均 exit 1。Windows 10 amd64 / Gradle 9.4.0 / Kotlin 2.3.0 / Microsoft JDK 17.0.19；shell JBR 21.0.11 非测试 JVM。工具 LSP unavailable/incomplete，未称 clean。

**S04 分轮方法/版本**：同现有 wrapper、Mixins/Fabric/Forge test tasks、上述共同 flags 加 `--info`。先 compileKotlin 因误带工具尾文本失败后修正；Mixins 第一组 17 tests 全过；首次平台 filter 漏 `.mixin`，0 tests、Forge 未执行，不能计通过；正确两个平台各 1 过；Mixins 补充组 10 全过；最终 loadClass 路径保护补齐后 `MixinResourceTests` 三项＋`MixinOperationIsolationTests.declaredOrderControlsClassByteResourceAndMetadataDomain` 一项与两个原失败平台 selectors，最终 **4＋1＋1 零 failure/error/skip**。最终三个 test tasks 实际执行；Mixins compileKotlin/compileTestJava 执行，compileTestKotlin/平台编译 UP-TO-DATE。先前 17/10 覆盖真实输入域、parent/refmap/DOM/Windows 原输入/Strip CRC、STORED 和三种退出，但轮次重叠且版本不同，不合计独立数量；最终聚焦不冒称最后版本全套重跑。Windows 测试 JVM Microsoft OpenJDK 17.0.19+10-LTS，编译仍用既有 Java 11 toolchain，无版本/工具链修改。LSP 八文件未获 clean 确认，采用实际编译/tests。

**可读项目 artifacts 与限制**：现行 [Fabric metadata tests](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt)、[Forge metadata tests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt)、[NeoForge handler](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/NeoForgeMixinConfigHandler.kt)、[resource tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java)及下节既有 Core/producer/loader 定位已可读。当时普通 resource/isolation XML（`TEST-net.msrandom.minecraftcodev.mixins.MixinResourceTests.xml`、`TEST-net.msrandom.minecraftcodev.mixins.MixinOperationIsolationTests.xml`，本次已不在当前输出，不作可读链接）、Fabric XML（前次可读快照，普通输出可覆盖，不作持续证据链接）、Forge XML（前次可读快照，普通输出可覆盖，不作持续证据链接）前次只读可读性及 suite 属性，当时分别 3/1/2/14、零 failure/error/skip，Fabric/Forge 已是后续正常 task 输出，不能称它们是 S04 最终 1/1 或 S01 原轮永久证据。所有普通 XML/HTML 可能被后轮覆盖，历史采用事实不因此重置；源码/当前产物存在不证明本次执行或完整原始 Result。

**恢复与当前状态**：S01 全 predicate/scope/owner/evidence 及 partial 保留；[S13](waves.md#mkf-s13--s01-剩余-core-可消费契约验收恢复) pending 仅承接其剩余验收，依赖已采用 S02/S03/S04/S12 当前 adapters/fixtures/资源修正 Results。六个通过及其后续覆盖按源码/输入/配置/环境/覆盖/新鲜度判断有效；两个原失败的 S04 后续成功须与现行 adapter/fixture 关联，不机械重跑八个、不重做接口、不新增独立审计。原成功标准、架构、风险或生产许可若需变化，返回具体影响，不在恢复中擅改。S05–S11 未实施，所有新版 gates 未放行；本次作者维护和后续独立审查均不能宣告 S13 completed 或释放 gate。

## 已采用的 S09 partial 及诊断恢复边界

本节只补 Router 后来已完整采用的事实，不是本 Writer 重跑。完整读取解码指定 S09/g1 与诊断/g1 的 transport envelopes：外层均 completed，内层分别 **partial / completed**；任务分别为 `codev-mkf-recorder-notifications` 与 `codev-mkf-logger-gap-diagnosis`。前者对应 MKF-S09/原 MKF-W05，后者是其日志缺口诊断而非新实现 item。运行时 Result 定位仅用于本次读取，不持久化为仓库依赖或经 Context 中转。

### 后来兄弟事实与 gate 投影

| 可靠关联 / item → Wave | 已采用结果、方法/修正与限制 |
| --- | --- |
| S13/g1 → MKF-S13 / W04 | **completed**，零源码修改、补跑两个受影响接点均通过；结合 S02/S03/S12，**Router 已判 W04 satisfied**。S01 原 6 过/2 cleanup fail 与 partial 保留。前次 S01→S13 局部恢复 review 已通过。 |
| S05/g1 → MKF-S05 / W05 | **completed**，额外预扫/后验退出，原生正常 fallback 与实际异常分开；分轮 fixture 编译断言曾失败，修正后补验。不能据正常返回或方法名推定普通原生日志已可见。 |
| S06/g1 → MKF-S06 / W06 | **completed**，Task 在 loader close 后直接写、Strip 本地读，AppliedMixins 工具退出；3 轮 **78 个不同 tests 通过，非一次全套**。不代 S10 的完整 graph/关闭顺序/中途 write-close。 |
| S07/g1 → MKF-S07 / W05 | **completed**，Tiny 保算法改名；最终 **8 tests/0 failures，含 SRG**。原 SRG 字段 descriptor 限制保留，不冒称新增格式设计/全格式认证。 |
| S08/g1 → MKF-S08 / W05 | **completed**，短 selector 窗口、child service 缓存/恢复、多副本协调、窗口外 overlap 与 **7 次 TestKit 输入跟踪实测**；中间 fixture 失败已修补。原值/临时 selectors 非输入、非参与 host 可观察/干扰和 restore 拒绝局限仍保留。 |

以上五项的完整 task 名、selector/逐轮命令未在本 Handoff 提供，按 Router 已关联的 item/g1 采用，不造 task identity/数量/命令，也不从当前产物倒填原轮细节；不因此重开 completed。S04 completed 不变。W05/W06/W07 仍未放行，S10/S11 尚未执行；本次不判断任何未满足 gate。

### S09/g1 partial：完成效果、分轮与剩余

仅修改 [MixinFailureStageTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java) 与 [MixinProducerTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java)，生产代码零修改、无绑定修正。实际 producer/fresh child 中原生 IExtension 回调到新 recorder；观察器在 recorder 后核 config＋真实 MixinInfo 和原键，不手调 recorder/旧 auditTrail。

- 已知 `configs/nested/known.json` 的 plugin 动态提供无原串 `Dynamic`；demo/Target 回调收到 Good/Dynamic 但仅保 Good。准备阶段另注册未被 discovery 读取的 `configs/runtime.json`；首个普通类触发原生重新选配后 zzz/Late 实际回调到未知 config 的 Late，先前 Good 不撤销。目标值 42、动态/未知方法值 7/9 及观察标记证明路径，不认证完整应用。
- 文件严格为 `{"configs/nested/known.json":["Good"]}`；驱动两个物理 JAR 三数组同键 all-match，保留 Unused、不同原串 demo.mixin.Good、其它配置路径 Good、未知配置 Late、未知 DOM/资源，原输入 bytes 不变。
- 既有多目标方法扩充真实文件→Strip：Other 未处理时 `{"fixture.json":["Both"]}`，剩 Context/Unused；Other 参与但缺 value()、引擎正常返回时 `{"fixture.json":["Both","Unused"]}`，剩 Context；两次目标值 42，不因另一目标未完成/optional 失败撤销通知。
- A 组当前六个基线均过：producer 的 parent 原路径原串、exactRawKeysDuplicateSourcesArraysAndUnnotifiedEntries、多目标；failure-stage 的同类异 config/section、optional 正常返回资格、required 真实异常/cause。另 targetOwnedDefinitionsArePreservedWithoutSkippingOrdinaryTargets 通过，覆盖嵌套原串/路径及普通目标/Mixin 定义保留。不是把 I03 旧 audit 观察当新 recorder 证据。

实际沿现有 wrapper 的 `:minecraft-codev-mixins:test`，各项 `--tests`，flags 为 `--offline --no-parallel --max-workers=1 --no-configuration-cache --console=plain`。B 为 unknownAndDynamicNotificationsReachRecorderWithoutInventingOrRevokingKeys＋loggedNonNativeFailureDoesNotRevokeKnownKey；C 为 B 加多目标及 target-owned-definitions 两项。

| 轮次 | 已采用实际结果/修正 |
| --- | --- |
| 1 / A | 6 tests 全过。 |
| 2 / B | test compile 失败：旧 Gson JsonObject.deepCopy 非 public；改现有 JsonParser 复制 DOM，无测试执行。 |
| 3 / B | 2 tests/1 failure；Late 未转换，unknownValue 的反射抛 NoSuchMethodException，fixture 配置注册过晚。 |
| 4 / B | 改准备阶段注册并加首个普通类，2 tests 全过且出现实际 unknown 回调。 |
| 5 / C | 补多目标 Strip 联结后 4 tests 全过。 |
| 6 / C | 临时 console logger cache 可观测实验 4 tests 过但未取得实际引擎错误日志；无效 fixture 实验已撤回，不算日志证明。 |
| 7 / unknown＋多目标 | 最终源码聚焦 2 tests、0 failure/error/skip，两个 suites 各 1；不冒称最后字节全套。 |

各轮重叠不累计独立数；Windows 10 Pro x64、Gradle 9.4.0、Microsoft OpenJDK 17.0.19+10-LTS、动态 fixture `--release 11 -proc:none`，锁定 sponge-mixin 0.15.0+mixin.0.8.7 及既有 Kotlin/serialization。最后两个测试主动 LSP 2 clean/0 diagnostics、限定 diff 检查过（LF/CRLF 提示）；这些是 S09 的已采用检查，不是本次执行。当前方法名含 logged、正常返回与内容通过 **不能证明原生错误日志可读**，故 S09 仍 partial。

### 日志诊断/g1 completed：不是修复

创建→缓存→固定消费者→输出链已证：当前 [OperationService](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/IsolatedMixinService.kt) 未覆盖 MixinServiceAbstract.createLogger，默认 LoggerAdapterDefault 的 log/catching 为 no-op。真实 initializer/fresh child 的只读绑定探针确认 Codev service、child-owned logger，处理器 logger 与 cache 的 mixin 对象同一；不是仅漏抓控制台。锁定同版本 sources 与发布二进制 javap 交叉核对工厂/cache、MixinProcessor 静态引用和原生 optional 错误路径；成功 bootstrap 的缓冲日志最终也交所选 service，不由启动失败默认 console 补救。

- 诊断实际重跑既有多目标 selector：同 wrapper/task/flags，**1 test/0 failure/error/skip**，test task 执行、编译 UP-TO-DATE；两次内容标记成立，system-err 空、system-out 只有 fixture/engine-closure 标记，无原生诊断文本。负证据仅本 selector/本轮，不推全构建无日志。
- JShell 使用既有 implementation metadata classpath（过滤不存在的 NO-SOURCE 目录）；第一次因不存在目录启动 exit 1、片段未执行，过滤后成功。仅创建真实 loader、调用 initializer、读取 service/logger/processor/cache、恢复 TCCL/关 loader，不换 cache/不发射测试日志；javap 同时成功。沿既有 Windows/JDK17/Gradle9.4 环境，源码/测试零写入。
- 原生 optional InvalidMixinException/suppressed 路径按 required/optional action 记日志并可能正常返回；其级别可为 WARN，不能固定 ERROR。诊断没有逐次断点证明此场景每一 native log 调用，也未重演已撤回 cache 实验；消费者固定保存引用/child 域是必须排除变量，不是追认旧实验失败具体原因。
- 最小已授权恢复 owner 是 OperationService 的 createLogger 工厂扩展点，首次缓存前返回引擎已有 LoggerAdapterConsole；保原生缓存/调用者、隔离和 engine action。单个足够回归为增强既有多目标方法，真实第二轮 optional 错误前短作用域捕获 System.err/finally 恢复，观察 native InvalidInjectionException 与 fixture.json/Both/demo.Other，同时保正常完成、精确通知和 Strip 内容。不手造日志/换 cache，不新 Gradle 回调/固定格式/全量 DEBUG/TRACE/持久化。本诊断 **没有应用修复、写入断言或修复后正向验证**。

### 便携 artifacts、复用与恢复

以下为 S09 恢复图准备时点读取快照，不是当前 XML 属性或当前 pending/gate 状态；最终事实以上方说明及下节最终完成记录为准。

本次仅静态核读上述两个测试及 OperationService 的局部 owner。当前可读 producer XML（前次可读快照，普通输出可覆盖，不作持续证据链接） 为诊断后一项多目标 1/0/0/0 且无 InvalidInjectionException 标记；S09 最终 failure-stage XML 已不在当前输出，不链接为现存原证据。S04 原 resource/isolation XML 也已被正常后轮覆盖/移出；既有历史结果和 S09 两项通过不因此 reset，也不把当前 XML 当 S09 原两套最终记录。源码只定位断言与 owner，普通 XML 可覆盖；这里不承诺原文永久可读、不冒充重跑。

现写读定位为 [producer](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/produceMixins.kt)/[Strip](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt)，现改名为 [Tiny remapper](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/TinyMappingRemapper.kt)。已删除 codec/旧 remapper 不再作为可读链接。

S09 原全 predicate/scope/evidence 与 partial 保留；[S14](waves.md#mkf-s14--s09-剩余普通引擎诊断可见性恢复) pending 仅承接日志可读和同场通知不否决的剩余验收，按当前版本/输入/覆盖复用已完成 unknown/dynamic/parent/同类异 config/真实异常及文件/Strip，不机械重跑。S14 成功不自动完成旧 S09 或释放 W05；仍须原全部要求、S04/S05/S07/S08 兄弟 Results 与充分 gate 证据。S10 只等 S04/S06/S08 不变，S11 保独立 caller/cache；本次四文档维护既非实际修复也非独立 review/gate 判断。

## 已采用的最终完成记录

当前新版活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 全部 completed；S01/S09 保留 partial。Router 已完整采用关联业务 Results，并独立判断 W04/W05/W06/W07 satisfied；已确认八点范围无剩余实际执行项。旧 I01 blocked、I03 partial、R01/I02 completed、W01 satisfied、W02 未释放、I04 未执行、W03 pending 均不变。 这些是 Router 已核定事实的持久投影，不是 Writer 新验收或 release。原 PRD（产品/失败策略）、双语 Spec（八点接口/九行行为）、Accepted 隔离 ADR（临时属性/局限）继续 reuse，无新增 authority 缺口。本次完整读取并解码三份指定 transport envelopes，task/generation 分别核对如下；外层与内层均 completed。原 Result 仅用于运行时读取，不复制全报告、日志或外部定位。

### S14 普通诊断恢复

`codev-mkf-native-diagnostic-restore/g1` → S14：只在现有 [OperationService](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/IsolatedMixinService.kt) 覆盖 createLogger，首次缓存前返回引擎已有 LoggerAdapterConsole；沿用按名缓存和 child 所有权，不替 Map、不解析日志或改 engine action。既有 [producer tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java) 的 notifiedMultiTargetSurvivesLoggedFailureAndUnknownDynamicNotification 仅增强第二轮短作用域 System.err 捕获/finally 恢复。真实 optional Other 缺 value()、require=1：同 selector 红轮 1 test/1 failure，工厂修复后绿轮 1/0/0/0，非两个独立 tests。实际 WARN InvalidInjectionException 关联 fixture.json/Both/demo.Other；目标仍42，两轮通知分别 Both 与 Both/Unused，Strip 分别余 Context/Unused 与 Context，DOM/非配置 entries/raw 保持。JShell 真实 child 初始化只读探针确认 bootstrap cache=getLogger=processor 同一 child-owned console logger，finally 恢复 TCCL/关 child。

沿现有 wrapper 的 :minecraft-codev-mixins:test，--tests '*MixinProducerTests.notifiedMultiTargetSurvivesLoggedFailureAndUnknownDynamicNotification'；共同 flags 为 --offline --no-parallel --max-workers=1 --no-configuration-cache --console=plain。S09 unknown/dynamic、parent、同类异 config、重复来源数组、optional/non-native 资格和 required 真异常按未变源码/输入/配置/环境/覆盖复用，不重跑通知矩阵；S09 旧 Gson 编译、Late 注册和未获日志实验失败/撤回不改写。S14 当时两文件主动 LSP clean，但编译 deprecation 提示保留。

### S10 producer 生命周期

`codev-mkf-producer-lifecycle/g1` → S10：仅 [producer](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/produceMixins.kt) entry-file 改同位置 UTF-8 输出流 use/write，诊断增加 mixin=unknown；以及上述 producer tests。真实空/配置引擎调用输出1/42，直接在 child/host 返回点递归查整个 bootstrap-owned Map/Set/String，关 loader 后仍可遍历。既有 ASM 临时副本明确接点观察真实 target-stream-close→archive-close→child-return→host-return→loader-close→entry-stream-close→target-move→entry-move→pair-complete；强持有图下 Windows 独占打开成功、TCCL 恢复。

六类实际接点故障：target/entry 已写至少8 bytes 后 IOException、entry 底层 close 后 IOException、输入 JarFile.close 后 IOException、target 流期间 interrupt 取消、第一 move 后第二 move IOException。均先有旧成功，再 fail-current；命中、stage/cause/明确未知 Mixin、两输出失效、依赖 consumer/Strip 失败、无 staging 残留、raw/另一操作保持，解除后 retry 的归一化 class/entry DOM 与干净调用一致且真实 Strip 正确。另增强重跑 loader-close 权限拒绝/suppressed/补关/retry；open-write 拒绝单独保留，不冒充 mid-write/close。两输出 alias、hardlink/junction/realpath/containment、同目的地竞争、资源释放和默认/applied-only smoke 实际补验；S08 selector 矩阵及未变 S14/S06/I02 部分复用。

同 wrapper/task/共同 flags，首个 actualProducerGraphClosureAndMidStreamFailures 因测试 host 漏 fixture.testOutputs 得空图失败；只修 fixture classpath 后单项通过。随后10个不同方法通过（producer graph、loader close、actual writes/second move、aliases；isolation 目的地和取消；preapplication JDK handoff；resource 返回流；Strip DOM；input-binding 默认输出）。最终仅诊断字段/对应断言变化后重跑 graph 与 loader-close 两个受影响方法，2/0/0/0 实际执行，另8项按未受影响条件复用。不是最后版本单轮全套，也不累加重叠数量。Java LSP clean，Kotlin 仍10个辅助风格告警，实际编译通过。

### S11 同一 caller 的当前结果闭包

`codev-mkf-caller-consumption/g1` → S11：只增强 [MixinInputBindingTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java) 的全部 required JAR entry/非配置 bytes/完整 DOM、B 非 union、selector 原值复用和缓存/合法空断言；现有 pipeline-caller.gradle 接线未改。真实公开 Task/Transform 注册、Provider 参数/from-to/view/显式依赖，消费同操作 raw sources＋derived target，resolution-only/external 排除、producer 不反馈 stripped inputs。applied-only 目标42但未 cleaned；完整 A 精确清理两 JAR，B 保 client Good，不 union。所有当前 raw 输入执行期间保持。

同链 SUCCESS→UP_TO_DATE→只删两自有输出后换 TestKit home/daemon，producer FROM_CACHE 恢复两输出，新 consumer 无 producer memory 首次执行两个 Strip并验全部内容；再正常复用、另新 home 恢复两 Strip缓存并验真实路径/内容。逐类 plugin body/resource/config/mapping/side/context/native property unset/false/true/unset/runtime 顺序/implementation 副本资源、handoff 缺失/损坏/shape/stale 与独立 removalsFile/inputArtifact 变化均观察当前内容；合法空与坏/旧交接分开。source Strip、derived-target Strip、producer alias/publication/损坏 target 真失败不路由旧消费；两个 Strip 失败不否定已完成 applied 结果。mapping/side/context 的部分兼容输入只证失效和当前内容，语义矩阵复用 S05/S07，不夸称重验。

同 wrapper/task/共同 flags，第一轮五个方法：testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations、testKitProducerCacheRestoreThenFreshAndRestoredTransforms、testKitTransformTracksParametersAndInputArtifactIndependently、testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput、testKitFailedCurrentProducerCannotRouteOldSuccess；实际5/0/0/0。仅补 B/empty 后第二轮重跑首项及 testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption，实际2/0/0/0。**两轮6个不同方法，不是7个，非最后单轮全套**；第一轮其它四项未受影响复用。无意外 Gradle/JUnit 失败；辅助等待命令 exit1 不属项目失败。两次主动 LSP 都 inconclusive（含一次超时），不是 clean；实际测试编译通过。

S11 已采用九行 Spec 映射：Inputs 复用 S13/S02/S03/S12/S04/S05/S06，补 caller 输入/排除；Names 复用 S07，补 mapping/context 消费；Isolation 复用 S08/S10，补 A/B 和新 daemon；Engine outcomes and logs 复用 S05/S09/S14，补当前目标/通知消费；Applied outputs 复用 S06/I02/S09/S14，补全部 JAR 内容；Registration/collection 与 User-directed delivery 由实际公开接线/两种消费/Strip 失败支撑；Reuse/input changes 由同链恢复及逐类变化支撑并复用 S08；Failure safety 复用 S10，补两 Strip/producer 当前失败与旧消费不路由。未变组件证据复用而非此轮重跑。

### Router gate 事实与证据限度

Router 结合 S13/S02/S03/S12 判 W04；S04/S05/S07/S08/S14 加仍有效 S09 原全部通知要求判 W05；S06/S10 判 W06；S11 completed、九行映射及 W04/W05/W06 满足判 W07。新版范围已收口，无剩余实际项；恢复不擦除 I03/S01/S09 partial、旧 blocked/failed 或旧 gates。

三项执行环境均 Windows10 amd64 / Gradle9.4.0 / Microsoft OpenJDK17.0.19+10-LTS，现有 Mixin0.15.0+mixin.0.8.7/Kotlin/serialization；动态 fixture --release 11 -proc:none。shell JBR21 不是测试 JVM。SecurityManager 注入仅既有 JDK17 设施，不保证其它 JDK；实际 I/O 后短接点注入不是坏盘/断电。selector 窗口仍可被非参与 host 观察/干扰；两文件移动非原子事务、无跨构建锁。TestKit 自有 sibling homes 因 Windows daemon 句柄保留。普通 XML/fixture 输出可覆盖，不承诺永久原始证据；以上源码/测试仅供定位。deprecation/Gradle10 提示保留。未测整仓/游戏/其它 OS/外部 caller/完整支持矩阵，未 Git 提交。本次只静态维护四文档，未运行项目/探针/LSP，也未新造证据包。

## 已接受方向的规划含义

只摘录职责边界供定位，完整规范不在此重写：

- 两个独立生产者，保留 `Mixin` / `StripMixins` 名称；Task 两 tracked outputs 为 `outputFile`、`appliedMixins`，Strip 的 `Parameters.removalsFile` 可以来自 Task、其它任务或手写合规文件。caller 显式注册、参数/依赖/属性接线及消费；不做自动路由/新 DSL。
- raw target、raw sources、resolution classpath 分开；完整清理集合仅为同操作 raw Mixin sources＋derived target，全部需要的 Transform 结果由 caller 消费。resolution-only 不自动清理，不反馈 stripped inputs，不合并操作集合。
- host 持 Gradle 参数/跟踪/Loader 发现；fresh `IsolatingMixinClassLoader` 加载 Kotlin 整 JAR child 函数；归档关闭后只返回物化 JDK Map/Set，host 关闭 loader 再写完 entry file、完成两输出。Kotlin/DOM/引擎对象不跨界。
- 专用 listing/handler **复用 Core 原签名并继承**，resource/side 快照仍属 Mixin，无独立 environments 接口。仅 Core 两函数注释澄清引用/声明语义，不动签名/原 Jar-in-Jar 调用。Fabric/Forge/NeoForge 各自当前 metadata 显式编辑，保留新增及未知内容；不做 checkReferences/tomlMixins 预读/快照比对，不要求两格式集合相等。producer 只读，Strip 不发现/编辑 Loader metadata。
- `GradleMixinRecorderExtension` 直接以 config＋对应 Mixin 回到完整配置路径/原始条目；通知即资格，不以候选、类名猜测、日志、完整应用或 residual proof 代替。实际归属还须实现测试，但不再是用户未决选择。
- Kotlin serialization DOM 使用已安装库；重复对象键与字符串内未转义控制字符（含未知字段）均沿库版本标准行为，不保证额外拒绝或固定边缘结果/last-value，不加扫描器。语法政策不豁免资源/side/原始条目业务值；严格 UTF-8、其它格式、数组集合/all-match、业务形状、归档路径和原输入保护不撤销。没有变更的配置保留原字节，有变更仅保留其余 DOM 语义/资源。
- 旧 EngineOperation/StrictJson/SHA/publication 调用退出已由 I03 partial 记录，不重做。八点另删 ArchiveResources、AppliedMixins 独立层，不同形换名；Task/Strip 各自文件读写格式不变。ExactMappingRemapper→TinyMappingRemapper 只改名及必要 callers，不限 Tiny-only/不重设 MappingReader 能力。applyMixins 去重复预验/后巡检，保留真正原键读取/异常/业务保护，正常引擎 fallback 不否决。
- service 选择按现行 Spec/ADR：两原生 selector 在所有参与 Codev host copies 共用的短初始化互斥内保存/临时选择/缓存并 finally 恢复，child global-property 另须实际安装（无第三 selector）。恢复失败保 cause 向外；恢复后才解锁，转换仍可 overlap；不再 loader 虚拟 service 重定向，不追踪其它操作临时 selector/原 selector 值。其它有效 native options/unset/default 及 implementation inputs 继续跟踪。非参与 host 可观察/干扰临时值，不承诺插件沙箱、不造 lease/通用锁/多文件事务。

## 本次定点源码观察（静态，不是执行证据）

本节保留八点计划准备及前次 S01 恢复维护时点的源码观察/未来语气；S01–S08/S12/S13 的后来变化以上节已采用事实为准，不能把“不继承/combined/旧编辑/资源/codec/旧 remapper 仍存在”视作当前状态。下述“本次恢复维护定点核读”特指前次 S01 Writer 对 Core/adapter/fixture 的静态核对，不是本次重读或 S13 验收；本次仅核日志 owner/已有回归。原时点已观察继承/list 与独立 handlers、Forge 两 rules 和 loader scoped 关闭；这些源码观察本身不证明验收。

仅为分组/ownership 读取受影响源码，不重做全仓/D/E 审计；原始准备的旧类图观察已被 R01/I02/I03 的后来事实限定。Codev 自有 Git 工作树仍有大量 staged/unstaged/untracked 混合变更，本目录为既有四文件；只读 status，不 reset/stage/清理。没有发现适用祖先/本目录 AGENTS 文件。下列实际源码观察不等于测试通过：

| 当前位置 | 有界事实与新图关联 |
| --- | --- |
| [listing](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt)、[handler](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinConfigHandler.kt)、[Core](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/ListedFileHandler.kt) | Mixin 两接口当前不继承 Core；Core 两签名同在 ListedFileHandler.kt，注释仍仅 included JAR/实体移除。S01 改继承/list 与最小注释，非 ABI 重做；FileListingRules 没有独立同名源码文件。 |
| [Fabric handler](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinConfigHandler.kt) | 当前用旧 mixins 算 remaining，编辑时要求 current 等于 snapshot；S02 单独承接当前 metadata 编辑，不可机械保留旧冲突断言。 |
| [Forge rule](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt)、[handler](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinConfigHandler.kt) | 当前一次 load 读 Manifest/TOML 并构造 combined handler；tomlMixins/checkReferences 及 update 再读/比对，removeConfigs 要求两格式集合相等。S03 抽出独立 NeoForge 并退出 Forge 的 TOML 分派；Manifest 当前编辑有独立可用/重试边界，另列 S12；不为拆号复制 combined shim。 |
| [inputs](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinInputs.kt)、[producer](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/produceMixins.kt)、[loader](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/IsolatingMixinClassLoader.kt) | 新 seam 已在；discovery 遍历 rules 的循环已存在，不新造发现框架。nativePropertyNames 当前仍含两个 selector；loader 合成 Codev service URL。S08 必须同时修 selector/cache/global-property/跟踪，不能只删虚拟 URL。producer close/文件顺序源码存在但直接证据不足。 |
| [child](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/applyMixins.kt)、[recorder](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/GradleMixinRecorderExtension.kt) | child 有重复 config 读、parent 校验、每类/plugin/refmap 预扫和转换后 audit；S05 删这些而不删原键所需 reads/显式 context。recorder 使用 config＋Mixin，但 unknown/dynamic 的实际通知观察尚缺，S09 不以旧 auditTrail 测试顶替。 |
| `ArchiveResources`（S04 已删除，不作可读链接）、`AppliedMixins`（S06 已删除，非可读链接）、`ExactMappingRemapper`（S07 已改名，现链接见上节） | 资源层有 host/loader/child/recorder/Strip 等直接 consumers；codec 还被 producer/Strip/原串业务校验及平台 tests 使用；改名 remapper 仍以 MappingReader.read 自动处理格式。三者各有独立终态，S04/S06/S07 必须连必要 callers/反射/生成 fixture 一起迁移，不收窄能力。 |

以下检索与“未来”语气均为八点准备/S01 维护时点，后来 S05–S08 的 completed 由上节限定。本次只核日志 owner/已有回归，不重做引用审计。前次定点标识引用检索命中平台、Mixins production/tests/r04 生成插件；跨模块通配查询达到显示上限，只用于识别冲突与直接 consumer 类别，**不声称已穷尽所有调用者或完成退出搜索**。未来各项必须在自己的实际修改范围补完整引用检查。旧 runner/EngineOperation/StrictJson/publication 路径已退役，仅保留非链接历史名称，不把不存在的源码当可读 artifact。原 selector/codec/资源层在该准备时点仍存在不代表允许留在新版终态；资源层后来由 S04 删除，codec/改名后来分别由 S06/S07 completed，不再写成当前仍待实施。

## 历史与复用限度

Handoff 可靠提供：11 个本轮生产 Java 已迁 Kotlin，81 项相关测试曾通过；旧 listing/handler 恢复后曾有 20 项定点检查。它们不是三图实现/验收证据。本次未运行这些测试，也不将其直接投影为新图 completed。

[历史重实现 Context](../mixin-reimplementation/context.md)仅留作历史定位，不是通过 Context 绕到外部原始 Result 的依赖；旧图 blocked/partial/completed 与 gates 原样保留。当前有意义的是仍适用的输入保护、精确 remapper、目标普通类转换/Mixin 定义保留及 caller 场景，不是旧类名、重复键拒绝、publication 类图或套件总数。

旧 Core 六文件退役及新增五个 Core 测试/fixture 删除的边界按 Handoff 保留；不恢复、不调查其无关实现。现有部分故障注入依赖 JDK17 SecurityManager、曾用 Gradle9.4；这是测试设施事实/限制，绝不提升为生产版本要求。本次不验证运行环境可用性或完整支持矩阵。

未来证据只在输入/源码/配置/环境和覆盖仍有效时复用；改变 seam、DOM、依赖或故障注入命中点必须补测实际影响。普通源码、测试结果和小 JAR 内容断言足够，不制造原始 Result 副本、证据包、hash/receipt/账本或独立重复终验。
