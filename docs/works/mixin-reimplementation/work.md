# Mixin 重实现 Work

[Context](context.md) · [Plan](plan.md) · 唯一匹配执行图：[Waves](waves.md)

## 目标与阶段

从当前产品/技术合同内部重实现现有公开 `task.Mixin` Task＋逐 JAR 精确 `StripMixins` Transform，替换混杂旧兼容、来源证明和 metadata 删除职责的编排；保留真实输入解析、操作隔离、通知归属、精确编辑、资源与安全发布、正常 Gradle 跟踪/缓存职责。

**Router 已采用用户对保留现有类型名范围的“可以”及随后 C6 简化范围确认：保留 `Mixin` / `StripMixins`、producer `Mixin.appliedMixins` 与 consumer `StripMixins.Parameters.removalsFile`，取消逐 Task 通用 `engineOptions` 及相应 getter 字节码适配。** PRD R3 与 Spec 的必要澄清已完成，同一隔离 ADR 复用，没有新增 options 架构选择或权限待定。本次是同目录四协调文档的已采用 R04 completion / Router supplied WR04 gate 与当前选定 Plan 完成事实维护，不实施或运行生产验证；后续已确认 scope 与本次文档权限分开，确认不来自这些派生文档。

MRI-I01:g1 的业务 Result **blocked**、0 生产改动及 MRI-W01 pending/未释放作为历史保留。Router 已完整读取并关联 `mixin-producer-native-options-reimplementation:g1` / **MRI-R01:g1**，采用业务 Result **partial**（不是 backend completed）：`appliedMixins` tracked output、两个独立 buildDirectory defaults、最小空插件及旧 host 类/实体 SPI/Groovy 注册退出、必要 producer/caller 引用迁移已落地；默认输出真实 TestKit 和 20 项 focused tests 通过，但原生输入观测、旧 proof/RecordData 编排与平台只读迁移未完成，Strip 参数仍为 `cleanupFile`。证据与限制见 [Context](context.md#mri-r01-partial-事实与可复用基线)。

原 R01 item/predicate/evidence/owner 和 **MRI-WR01 pending/未释放** 保留历史，不重置或回放。Router 已采用 **MRI-R02:g1 completed / MRI-WR02 satisfied** 和 **MRI-I02:g1 completed / MRI-W02 satisfied**，保留当时独立核对 membership、前置及 evidence/release predicate 的判断；R02 的 whole producer 判断仅覆盖当时实测输入与组件场景，**不覆盖本次暴露的 target-owned Mixin class dispatch/preservation 缺口**，不再据此宣称当前 producer 全覆盖。Router 已从 full join 完整读取并关联 `mixin-real-caller-cache-reimplementation:g1` / **MRI-I03:g1**，采用业务 **partial**（backend completed 仅表示调用终结）；**MRI-W03 pending/未释放**。原 I03 完整 predicate/owner/verification 与前置保留历史，不作为新路线的 completed prerequisite。当前同范围恢复仍为 **MRI-R03→MRI-R04**：Router 已完整读取并关联 `mixin-target-owned-class-dispatch-repair:g1` / **MRI-R03:g1 completed**，并独立判 **MRI-WR03 satisfied**；**MRI-R04:g1 completed / MRI-WR04 satisfied** 已由 Router 采用/提供判断，结合 WR02/W02/WR03 三个既有 satisfied gates 建立当前选定 Plan 完成；本 writer 只记录 supplied judgement，不重判其它 gates。I01 blocked、R01 partial 与 W01/WR01 pending/未释放不变。采用事实与限制见 [R03 Context](context.md#mri-r03-completed-事实与独立-gate-判断)。 活跃结果由既有 R02/I02 组件加新 R03 局部修复及 R04 实际 caller/cache 闭包建立；I03 partial 是已采用输入，不要求其 completed。失败、fixture 修正和未执行分支见 [I03 Context](context.md#mri-i03-partial-事实与目标内-mixin-class-缺口)。

## 权威复用

| Family / owner | 处置与依据 |
| --- | --- |
| PRD / Codev 产品边界 | **reuse（必要 update 已完成）** [Active 英文 PRD](../../prd/codev-mixin-rework.md)及[等义中文稿](../../prd/codev-mixin-rework.zh-CN.md)：已采用 `mixin-prd-native-options-boundary:g1` completed，双语 R3 澄清通用选项沿用原生宿主属性/default、不提供逐 Task overrides；R2/R4/R5/R6/R8/R10 与跟踪/隔离职责不变。 |
| Spec / `minecraft-codev-mixins` | **reuse（必要 update 已完成）** [现行 Spec](../../spec/mixin-preapplication.md)及[中文稿](../../spec/mixin-preapplication.zh-CN.md)：已采用 `mixin-spec-native-options-boundary:g1` completed，五处澄清原生读取、内部输入观测及排除 raw override/getter 适配；隔离、mapping、通知、精确 strip、发布保护和缓存主体不变，未冻结内部观测算法。 |
| ADR / 操作隔离技术边界 | **reuse** [Accepted ADR](../../adr/mixin-operation-isolation.md)：fresh operation loader、加载域、原生 service、锁定引擎及 mapping 链不变；历史 selective 政策不成为当前门槛。 |

复用 Router 完整采用的 `mixin-native-options-authority-impact:g1` 三族局部 assessment 及 I03 的 reuse 判断，沿用此前完整读取现行 PRD/Spec/ADR 的依据：PRD R3/R5/R6/R10 已覆盖目标自带 config/classes、原输入保护及真实消费；Spec 的 supplied target/discovery、class/resource preservation、build-copy、同链消费/cache 已覆盖新观测缺口；ADR 的 fresh operation loader/加载域/锁定引擎不变。必要 update 已在原 owner 完成，本次三族均 reuse，无重要 authority 缺口；R03 的具体私有修复机制由 owning code Handler 决定，不在此选新架构或收窄支持。原五份权威未明确承诺逐 Task `engineOptions` 或 getter 适配，撤下的是未接受候选，不是撤销已接受架构。本 Work/Context/Plan/Waves 均不修改或替代 authority，文档本身不提供实施许可。

## 边界与完成信号

- 仅一个 coherent Plan，无 overview、slice、tasks.md、提案、审计包或额外终验系统；执行分解只在本目录 Waves。
- 活跃 Plan 完整结果由 **MRI-WR02、MRI-W02、MRI-WR03、MRI-WR04** 共同建立：保留 R02/I02 当时实测的组件成果，R03 已完成目标 JAR 普通类转换与目标内 Mixin 定义/资源保留的实测局部修复，WR03 satisfied；R04:g1 已 completed，原五组剩余 caller/cache 要求已实测补齐，Router supplied WR04 satisfied；四个活跃 gates 共同建立当前选定 Plan 完成，详见 [R04 Context](context.md#mri-r04-completed-事实与-router-supplied-gateplan-判断)。最终集成自然归 MRI-R04，不另开参数/完整应用证明或重复终验 gate。旧 MRI-W01/MRI-WR01/MRI-W03 保持 pending/未释放，不因新恢复自动满足。
- 当前完成记录维护的完成信号是四文档互链、Spec 来源与去留边界清楚、IDs/前置/owner/冲突与 gate 无环且一致，并完成静态链接/图检查；不是上述实施完成信号。
- [旧 artifact-pipeline Work](../mixin-artifact-pipeline/work.md)、[Context](../mixin-artifact-pipeline/context.md)、[Plan](../mixin-artifact-pipeline/plan.md)、[Waves](../mixin-artifact-pipeline/waves.md)仅作只读历史。其 I02/I03 completed、I04 partial/W04 未释放事实保留；旧 repair/recovery 已由当前用户暂停取消，不恢复、不覆盖旧图、不自动补完旧 predicate。
- 不改生产、测试/fixture、构建/配置/依赖、PRD/Spec/ADR、旧 G1 或旧执行图；不运行 Gradle、安装、Git 写入、reset 或清理未跟踪文件，不访问/修改 D 盘参考树。未知作者的既有混合工作树内容保持原样。

## 本次检查记录

本次完整读取四协调文档及指定 PRD/Spec/ADR，复用三族 authority assessment；普通完整读取确切 R04:g1 JSON envelope、解码全部 result，核对 subagentId=`mixin-remaining-caller-cache-closure`、generation=1、backend / 业务 completed。仅记录 Router 已采用 R04 completed、supplied WR04 satisfied 和当前选定 Plan 完成，不自行重判其它 gates。R04 仅改测试/fixture 两文件；8 个不同 selectors 分轮最终通过（6 次调用、18 次 method 执行，4 次中间 fixture 失败已修正），不是一次 8/0。最新 XML 仅 H 单方法 1/0/0/0，不覆盖或相加 R02/I02/R03 计数。具体命令/日志、五组实测与仍适用组件复用、原输入保护、缓存不是新通知及恢复/重建合法性见 [R04 Context](context.md#mri-r04-completed-事实与-router-supplied-gateplan-判断)。静态核对四文档相对链接/anchors、tuple、IDs/membership/显式前置及含 item/Wave 等待的无环一致性、本轮四文件 delta 和可读 logs/XML/JAR/fixture；不是重新验收。故障注入依赖当前 JDK17 SecurityManager（弃用及迁移限制），R04 Java LSP 0 diagnostics 仅该测试文件，Groovy 仅实际 Gradle 执行；普通载体可覆写，无全仓/游戏/全平台复验。本轮不改实现/authority/Todo，不运行 Gradle/LSP/新实验，不自行释放其它 gate、调度或选择 continuation，不追加或撤销既有实施许可。
