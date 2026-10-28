# Mixin 剩余简化 Work

[Context](context.md) · [Plan](plan.md) · 唯一匹配执行图：[Waves](waves.md)

当前进展见[当前图维护事实](#当前图维护事实)；以下保留原准备历史，不能据此否定后来的审查、确认与已采用执行结果。

## 目标与阶段

为原九项已接受、尚未完成的 Mixin 简化，保留可审查的派生交付安排；按现行默认 UTF-8 解码和 JDK resource-open 合同修订受影响边界。只覆盖本 Plan 的剩余边界，不重新交付旧重设计，不宣称全部 Mixin 简化或产品验收完成。

准备时点历史（保留，后来的状态以文末为准）：

准备时点记录（历史）：当时默认政策已被 Spec/ADR 接受，原九项派生安排及新增五项覆盖完成作者自检，但尚待受影响边界的独立局部审查，也尚无本 Plan 范围的 C4 当前用户确认；当时新 items 和 gates 均 pending。旧独立审查 completed、当时整体不 ready 及 strict 前提下未解除阻断的结论均保留为历史。当前全覆盖审查、用户确认、十四项完成及三 gate 满足事实见文末；本轮只同步记录。

## 权威与来源

复用本轮已采用的 A–L coverage 核定及后续局部同步；完整读取当前 owner 后的适用性如下，不重新进行 A–L 研究。

| Family / owner | 现行依据与 assessment |
| --- | --- |
| PRD / Codev 产品目标 | **reuse**：[Active PRD](../../prd/codev-mixin-rework.md) R2/3/4/5/6/8/10、AC2/3/4/5/9/11；真实应用、精确清理、资源释放、真实失败和原输入保护目标不变。 |
| Spec / Mixins，平台 metadata adapters | **reuse（先前 update 已完成并采用）**：[英文 Spec](../../spec/mixin-preapplication.md)及[同合同中文译本](../../spec/mixin-preapplication.zh-CN.md)已接受默认 UTF-8 解码与 JDK open IOException→null/不可用，连同 Strip 信任输入、删除公开 `removeConfigs` 与不主动轮询中断，覆盖本次派生范围。 |
| ADR / Mixins 隔离与 Fabric/Forge adapters | **reuse（同 identity update 已完成并采用）**：[同 identity Accepted ADR](../../adr/mixin-operation-isolation.md)已记录默认解码/open 的兼容与诊断取舍；fresh loader、短 selector 窗口、资源/恢复、实际 context 与命名合同保留。 |
| 新 authority | **create: skip**：已有 owner 足够；本次没有写 PRD/Spec/ADR 的权限。 |
| 受影响边界 | **选择已定，实施/验收完成事实已采用**：未知字段亦遵循适用 decoder；不额外 strict/扫描，不保证所有坏输入成功、必拒绝、统一替换或统一 default mapper。JDK null 只限 loader 打开，必需输入不可用仍失败，取得流后的 read/close、直接文件/JAR、写出/恢复与可获得 cause 不豁免，原生内部捕获正常 fallback 与 outward exception 分开。 |

Spec 中 ADR 尚待同步的导航说明保留其原维护时点；不能据此重开已 completed 的局部同步。派生文档不修只读 owner 的时点措辞。

## 交付与历史边界

本次准备交付信号是四文件真实存在、互相匹配、保留原九项范围、成功条件与剩余证据边界，并留有 [Plan 作者语义自检](plan.md#作者语义自检)；不是新实现通过。

未来 Plan 成功要求 Waves 的 MS-W01、MS-W02、MS-W03 均由 Router 基于完整关联 Results 和规定证据判定满足。只读的 [旧 Work](../mixin-kotlin-first-redesign/work.md)及其图继续拥有旧完成记录；不迁移、覆盖或重开旧图。I03/S01/S09 partial、已完成效果及后轮修复的不同验证事实详见 [Context](context.md)。

本 Work 只拥有派生范围、事实与导航；Plan 拥有策略/风险/成功条件，Waves 拥有唯一执行图。旧审查对原九项图内规划无阻断，但发现 F1/F2 不能留在范围外；本版新增 S11–S15 承接 child/parent、refmap、Fabric load/edit 和 loader 实际消费者验收，并补充联合 gate 连接。此前局部独立审查和范围披露/确认的待办已由后来的全覆盖审查及用户确认解决；恢复连接及最终组合证据适用性已由 Router 核定，本项仅投影采用事实。

## 当前图维护事实

Router 已完整采用 codev-full-coverage-plan-review/g1 completed、无阻断；随后当前用户确认全部十四项实施范围，并授权必要图维护。PRD、双语 Spec、同 identity ADR 均 reuse；不重选策略、不扩行为。原未审/未确认/全 pending 文字仅保留准备时点历史。

Router 现已完整采用十四个活跃 item：MS-S01、MS-S02、MS-S03、MS-S04、MS-S05、MS-S06、MS-S08、MS-S10、MS-S11、MS-S12、MS-S13、MS-S14、MS-S15、MS-S16 均 completed；三个 gate MS-W01、MS-W02、MS-W03 均由 Router 判定满足。MS-S09 保留原 blocked 历史并退出活跃 membership，由 MS-S16 恢复其未执行范围；不能把 S09 改为 completed。详见 [Context](context.md#本次可靠采用的执行与恢复事实) 和 [Waves](waves.md#ms-s16--恢复-s09-未执行的-strip-流复制)。

本轮只投影已采用事实，不重验、不释放新的 gate、不改变执行合同。验证方法、实际观察、证据适用性核对及限制保留在 Context/Waves 的完成记录中。

