# Mixin Artifact Pipeline Context

入口：[Work](work.md) · [Plan](plan.md) · 唯一执行图：[Waves](waves.md)。本文件加工 Router 已采用的实施、验证与限制，不是权威、完整原报告或新的完成判定。

本 Pipeline 已由 [Mixin 重实现 Work](../mixin-reimplementation/work.md) 接替；旧 C5 repair/recovery 已暂停取消。下述实施阶段、Provider 阻断及未完成边界均为原记录时点，保留原 partial/status/gates，不作为当前实现状态或待执行路线；现行 owner/API 见下表及现行 Work。

## 当前依据与证据等级（历史记录）

- **Implementation confirmed / in progress。** 当前用户已确认原三单元完整披露范围，包含 producer/strip 生产实现、组件及真实 TestKit 检查，允许正常本项 Gradle/fixture 自有 outputs/cache。C5 在同一范围修复默认 Provider 缺口，不新增权限、需求、架构、用途或 API 兼容决定；本次文档维护本身不执行代码或测试。
- PRD / Codev 产品边界：**reuse** [Active PRD](../../prd/codev-mixin-rework.md)（[中文译本](../../prd/codev-mixin-rework.zh-CN.md)），通知即清理及 Codev 算法/caller 注册绑定选用职责不变。
- Spec / `minecraft-codev-mixins`：**reuse** [现合同](../../spec/mixin-preapplication.md)，public Task/Transform tracked inputs/outputs、正常 producer/provider/cache 与独立 applied-only/完整清理消费已覆盖默认 Provider 的义务；不用新增 Spec 解释实现缺口。
- ADR / 操作隔离：**reuse** [同一 Accepted ADR](../../adr/mixin-operation-isolation.md)，每操作 loader、加载域、engine pin 与 mapping 链不变，Provider 修复不改变隔离选择。原 authority assessment 继续适用于本范围，不编辑 authority。
- 下述 completed/partial 与 gate 是 Router 已完整采用并关联的事实，不是本次 writer 重新判定。缺少仓库内原 Result 不重开 I02/I03，也不将 backend completed 当业务完成。这里只保留处理后的事实与已核实可读的仓库引用，不复制完整报告、不依赖项目外 Result/session locator、不承诺永久取回原件。

## 已确定边界（细则以 Spec 为准）

- 结构仍为预应用 Task＋逐 JAR Strip Artifact Transform。Codev 实现组件与算法；caller 注册 Task/项目级 Transform，绑定清理输出 provider/参数及必要 build dependencies，选择 configuration/artifact view、请求属性并消费。producer 只读本 operation 的 raw target、raw Mixin sources、raw resolution，不能读自己的 strip view。
- 完整清理集合严格为本 operation 的 raw Mixin-source JARs＋其派生 target，全部使用同一 Transform/该操作清理信息；target 自带 config 不能略过。resolution-only/外部配置不扩入，不合并多 operation 清单，不建立来源库存。
- 身份仅为 config 完整资源路径＋数组原字符串（包名展开/映射前）；获通知后，同数组重复、跨数组、跨 JAR 全 matching 一起删除。不按来源/section/index/hash匹配或附加唯一性拒绝；另一物理来源同键未单独应用也删除是已接受代价。保留真实引擎输入解析、类/资源一致性等必要校验。
- 通知即清理资格；发现/prepared、普通返回、无报错、全目标完成或最终字节效果均不替代通知或成为额外资格门槛。其它处失败/部分/unknown 不撤销已通知键；未知归因不造键，未通知键保留。用户读 Mixin 日志，Codev 不扫描裁定成功；引擎直接异常自然向外失败。
- Task target＋小型内部清理文件、Transform 参数/inputArtifact/输出受跟踪，目标是正常 cache 恢复后无 producer 内存仍可消费。内部交接不是独立 records/证明协议；有效空集与缺失/损坏/无效/陈旧不能混同。当前表示与公开组件已实现，不再记作完全未实现，但默认 Provider 和 caller/cache 闭包仍未满足。
- 通知资格与组件完成分离：自身写入、关闭/退出、发布成功后才可按该组件成果消费。正常 applied target 不是 stripped；请求完整流须消费全部 required strips。required strip 失败传播到受影响消费，不否定独立已完成的 applied target，也不能报全流成功；不加全局 ready、统一双出口或任意 caller tasks 的事务。
- 原 target/sources/resolution/mapping 不变；精确 JSON 删除以外的未知字段/值、剩余顺序、空 config、类/refmap/metadata/resources 保留。输入别名/hardlink/目录、ZIP 路径、资源关闭/TCCL、staging/ownership 保护及异常传播不削弱；取消/写入/关闭/runtime exit/发布失败阻断受影响组件，旧成功不能冒充当前结果。用途自由不承诺任意下游兼容或安全。

## 已采用的实施与验证事实

### MAP-I02 / MAP-W02 — completed / satisfied（组件范围）

Router 已完整采用 `mixin-producer-engine-notices` generation 1 completed，对应 MAP-I02；MAP-W02 在其组件证据范围 satisfied。公开 Mixin Task 的 target＋`cleanupFile`、跨 loader 的 JDK 集合、通知到原 config/字符串映射已实现；真实引擎、自然异常/IO/资源释放/输入保护定向检查及受影响平台检查已通过。部分测试先失败后在 fixture 修正，不宣称全仓库通过。

这些独立组件事实继续有效。I04 新发现的是 default Provider 的真实 caller scheduling/output 查询缺口，I02 组件 green 并未证明默认完整 caller，也不能替代新修复 gate。邻近输入保护、mapping/publication 的成功证据可读于 [adjacent log][adjacent-log]；本次复用已采用结论，不重跑或从该日志臆推完整 I02 原报告。

### MAP-I03 / MAP-W03 — completed / satisfied（组件范围）

Router 已完整采用 `mixin-strip-exact-transform` generation 1 completed，对应 MAP-I03；MAP-W03 在组件证据范围 satisfied。公开 cacheable per-JAR [StripMixins][all-strip] 的 inputArtifact 与当时 cleanupFile 参数均 tracked / `PathSensitivity.NONE`；精确全 matching 删除并保留其它 JSON/config/classes/refmap/metadata/resources，完成旧 strip 路径及受影响平台的最小迁移；I03 未改变 producer、RecordData 或 OperationPublication。

已采用记录为 **28 个不同测试方法**有成功证据：[focused-final log][focused-log] 为精确编辑与平台最小迁移成功，[adjacent log][adjacent-log] 为相邻输入保护/mapping/publication 成功；最后 ZIP CRC 增量在 [zip-integrity log][zip-log] 复验受影响 2 项，不把重复方法计为新测试。日志记录 BUILD SUCCESSFUL；数量及范围承接 Router 已采用事实，不声称这几份外层日志独立列出全部方法。组件正负例不是 caller/producer-default/cache 完成证据。

### MAP-I04 / MAP-W04 — partial / 不满足、未释放

Router 完整采用 `mixin-caller-cache-testkit` generation 1 的业务 Result **partial**，不是 runtime 外壳的 completed。本项仅修改 [MixinInputBindingTests][input-tests]＋[pipeline-caller.gradle][caller-fixture]，新增六个 TestKit 方法及必要局部 fixture/helper；没有修生产 convention，也未显式覆写 cleanupFile 来掩盖缺口。fixture 已包含完整流、target 自带 config、resolution-only、多 operation、缓存与失败安排，但安排存在不是通过证据。

实际最后执行两个 selectors：`testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations` 失败；`testKitTransformTracksParametersAndInputArtifactIndependently` 通过。外层 [map-i04-focused.log][i04-log] 为 **2 tests completed, 1 failed / BUILD FAILED**，已采用 Result 记录外层退出 1，测试代码编译通过；当时 JUnit XML（历史路径 `minecraft-codev-mixins/build/test-results/test/TEST-net.msrandom.minecraftcodev.mixins.MixinInputBindingTests.xml`，本次已不再可读）读取时同为 tests=2 / failures=1 / errors=0。其余四个新增方法未执行。

- 通过的独立公开 Transform probe 实际注册/属性选择/消费；cleanup 参数单独变化及 inputArtifact 单独变化取得对应产物，有效空集保持配置内容；缺文件、损坏 JSON、非数组值、非字符串项四个负例消费失败且未猜空。可读普通 [probe runs][probe-runs] 中四次成功、四次预期失败，与该 JUnit 方法通过一致；不是 producer 缓存或完整链证据。
- 真实 `appliedA` 请求在进入完整流/Transform 前失败：[applied-only 原日志][applied-log] 显示 `:produceA` 的 cleanupFile 求值访问自身 outputFile 映射，错误为 “Querying the mapped value of task ':produceA' property 'outputFile' before task ':produceA' has completed is not supported”。[Mixin.kt][task] 当时默认链为 `cleanupFile.convention(project.layout.file(outputFile.map { ... }))`；这是已观察到的默认链缺口，不推断所有显式输出配置都不可用。
- 尚无本项正常 applied-only、完整清理流、target config/resolution-only、多 operation 不串/无环、producer SUCCESS→FROM-CACHE→首次 fresh Transform、各组件恢复/UP-TO-DATE、producer 交接损坏/陈旧恢复及 plugin/resource/config/mapping/environment 变化的闭包证据。来源 strip、target strip、producer/publication 失败的完整链也未执行；probe 负例和 I02/I03 局部证据均不能代替。
- 初期 PowerShell `-P` 参数引用、Groovy GString 属性类型、Windows 临时 home 锁是已在 fixture 修正的历史；未强制清理早期锁目录或正常临时 daemon/cache。最后仍为生产 Provider 失败，不得用修正早期环境/fixture 把本项改 completed。

### 可移植证据与适用限制

以上保留的日志链接可读；原记录曾读取 XML 及必要源码定位，未执行其中项目或测试。本次 XML 已不再可读，不撤销已采用的测试结果。普通 `build/test-results` XML 会被后续正常测试覆盖，当前读取事实与原失败以 `map-i04-focused.log`、applied-only 原日志为依据，不把 XML 当永久原件。保留 `map-i04-focused.log` 不覆写；恢复运行宜另名普通日志，不新增快照/备份包或 receipt/digest 平台。复用仍须覆盖实际 scope/inputs/source/environment/freshness，后续受影响变化才补验；缺少仓库内完整原 Result 不重置已采用历史。

## 现有 owner 与实际差距

| 边界 / 可读源码 | 当前事实及剩余边界 |
| --- | --- |
| Mixins：[Task][task]、[plugin][plugin] | 现行 tracked outputs 为 `outputFile`＋`appliedMixins`，分别独立默认到 `build/mixin/<task-name>/applied.jar` 与 `removals.json`，不再映射自身 outputFile。旧 cleanupFile Provider 失败保留为历史，不据此改旧 gate；当前完成范围见现行 Work。自动接线仍由 caller 负责。 |
| 同模块：[EngineOperation][engine]、[PinnedMixinAdapter][adapter]、[OperationRunner][runner] | 通知映射/JDK 跨 loader 交接及自然异常等组件事实按 I02 采用；不再把旧 provisional/整次 selective 拒绝当现状。操作隔离、engine pin 与 mapping 不改，不新增 native 完整性证明。 |
| 同模块：[ExactMixinStripper][consumer]、[StripMixins][all-strip] | 现行 `StripMixins.Parameters.removalsFile` 调用 `ExactMixinStripper.clean` 完成逐 JAR 精确编辑；旧 `SelectiveConsumer.java` 及 `task/StripAppliedMixins` 已退役，仅保留历史名称。组件检查不替代默认 producer/caller/cache 验证。 |
| 同模块：[OperationPublication][publication] 与 [TestKit owner][input-tests]/[caller fixture][caller-fixture] | 沿用输入保护、临时写入/独占所有权/异常传播及资源保护；caller 六个新增方法只有两项已执行，剩余链路须 recovery 补齐，不能在 fixture 代实现生产合同。 |

Fabric/Forge 仅在必要 listing/applicability 接口迁移处最小联动；已通过的受影响检查不等于全平台认证。不扩至 Core ABI/metadata 改写、无关 Forge patch 或 AW/class-tweaker、AT、nested-JAR 重新认证；触及行为不得回归。

## C5 同范围恢复与未闭合边界（历史路线，已由重实现接替）

Router 已选择 **producer 默认 Provider repair → caller 未完成边界 recovery**，精确 item、前置、owner 和冲突只在 [Waves](waves.md)。MAP-R02/MAP-WR02 与 MAP-R04/MAP-WR04 全 pending，本次不修代码、不释放它们。repair 只消除当前真实默认输出查询拒绝并保留 tracked outputs/必要安全；recovery 继承原 I04 全部未满足 caller/cache/失败条件，结合仍有效 probe、修复及组件证据，无验证削减。

原 MAP-I04 partial/MAP-W04 未释放保留，不 resume、不改原 Result；也不把 partial 当 requiring-completed 前置。当前 Plan 完成取决于 MAP-W02、MAP-W03、MAP-WR02、MAP-WR04 共同满足，原 W04 不是恢复路线终点，不会因 R04 完成自动放行。

通知部分应用仍全 matching 删除、用户读日志、直接异常自然失败、无 source/hash/index 或旧 records/API 兼容等边界不变。原独立 native 完整性单元/门槛不恢复，不补重复终验。工作树混合 diff 不撤回，不顺带修 Core/lint/Forge patch，不加 helper/自动注册/统一出口或收窄支持。

旧 G1 保持 **accepted / closed**；旧限定修复 59 项通过及独立复核仅属原范围，原 failed/partial/unknown、审计及归档可访问性限制保留（见 [Spec 历史适用说明](../../spec/mixin-preapplication.md#historical-applicability-and-source-limits)），不映射新验收或因原件未复制重开。当前全链仍未完成；本次仅四文档静态维护，不执行 Gradle/LSP/测试/安装/清缓存或 Git，不选择 runtime 调度。

[task]: ../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt
[plugin]: ../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MinecraftCodevMixinsPlugin.kt
[engine]: ../../../minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java
[adapter]: ../../../minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java
[consumer]: ../../../minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/ExactMixinStripper.java
[all-strip]: ../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt
[runner]: ../../../minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java
[publication]: ../../../minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationPublication.java
[input-tests]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java
[caller-fixture]: ../../../minecraft-codev-mixins/src/test/resources/pipeline-caller.gradle
[focused-log]: ../../../minecraft-codev-mixins/build/map-i03-focused-final.log
[adjacent-log]: ../../../minecraft-codev-mixins/build/map-i03-adjacent-tests.log
[zip-log]: ../../../minecraft-codev-mixins/build/map-i03-zip-integrity.log
[i04-log]: ../../../minecraft-codev-mixins/build/map-i04-focused.log
[applied-log]: ../../../minecraft-codev-mixins/build/fixture-evidence/MixinInputBindingTests/testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations/runs/applied-only.log
[probe-runs]: ../../../minecraft-codev-mixins/build/fixture-evidence/MixinInputBindingTests/testKitTransformTracksParametersAndInputArtifactIndependently/runs/
