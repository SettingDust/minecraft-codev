# Mixin Kotlin-first 重设计 Work

[processed Context](context.md) · [Plan](plan.md) · 唯一匹配执行图：[Waves](waves.md)

## 目标与当前边界

在同一 Work 内记录已确认八点简化范围的最终完成事实。仍是两个独立可组合生产者 `Mixin` Task / `StripMixins` Artifact Transform、Mixin resource/side 快照、真实 caller 的消费和当前输入复用；不重做 Kotlin 语言迁移或原架构选型。

**本次仅以 edit 同步原四文档的可移植完成记录，零实现改动、零项目执行。** 八点 review 已由 Router 采用、披露后用户明确“开始”；本次只记录 Router 已核定的 item/Wave 终态，不改要求、图义或 authority，不自行释放 gate。旧准备/恢复维护的待审查、未确认或 pending 语气仅保留时点意义。

可靠历史：**MKF-I01 blocked（零实现修改）；MKF-R01、MKF-I02 completed；旧 MKF-W01 satisfied；MKF-I03 partial；旧 MKF-W02 未释放、MKF-I04 未执行、旧 MKF-W03 pending。** I03 已完成新 producer 与旧控制/parser/SHA/publication 清退；当时 JDK graph/关闭顺序、unknown/dynamic 和真实流 write/close 证据不足的事实不改写，后来新版恢复覆盖不倒改旧 partial。详见 [Context 历史](context.md#已采用的-i03-partial)。

当前新版活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 全部 completed；S01/S09 保留 partial。Router 已完整采用关联业务 Results，并独立判断 W04/W05/W06/W07 satisfied；已确认八点范围无剩余实际执行项。旧 I01 blocked、I03 partial、R01/I02 completed、W01 satisfied、W02 未释放、I04 未执行、W03 pending 均不变。 S13/S02/S03/S12 支持 W04；S04/S05/S07/S08/S14 结合仍有效 S09 通知证据支持 W05；S06/S10 支持 W06；S11 的九行 Spec 映射及三个前置 gates 支持 W07。实际方法、分轮去重、失败修正、复用和限制见 [最终完成记录](context.md#已采用的最终完成记录)。

## 原权威复用

复用 Router 已采用的本轮三族 assessment 与 completed 对齐 Results；本次读取现行 owner 核对后均 **reuse**，不重做 assessment、不写新 authority。

| Family / owner | 路径与本轮覆盖 |
| --- | --- |
| PRD / Codev 产品边界 | [Active 英文 PRD](../../prd/codev-mixin-rework.md)：R2/3/4/5/6/8/10、AC2/3/4/5/9/11；R4/R6/AC4 已要求普通可读引擎诊断和非日志判决。正常 required/optional/plugin/refmap/default-mapper 返回不追加失败，真实异常与生产失败传播。 |
| Spec / Mixins，Fabric/Forge adapters | [英文技术合同](../../spec/mixin-preapplication.md)及[同步中文稿](../../spec/mixin-preapplication.zh-CN.md)：八点及九行验收不变；`Real results and diagnostic honesty` / `Engine outcomes and logs` 已覆盖日志供用户阅读、通知不撤销和真实异常。无需新增 severity/格式/全量 DEBUG/持久化合同。 |
| ADR / Mixins 隔离，Fabric/Forge metadata owner | [Accepted 同 identity ADR](../../adr/mixin-operation-isolation.md)：fresh loader、Core reuse、平台分立、短 selector 窗口和 child global-property 保留。现有 child `OperationService.createLogger` 工厂接引擎已有 console adapter 可恢复可见性，不改变隔离、跨 loader 返回或引入 Gradle 专属回调。 |

Spec 中“ADR 尚待同步”等说明属前一维护时点，后来原 ADR 已由恢复 Handler 对齐完成；本次不改只读 owner。原 [HTML 三图](../../design/mixin-design.html)与 D 盘仅是设计历史，八点后的 owner 优先，不将图上的禁止 Core 继承/虚拟 service 重定向复活为当前要求。

## 交付信号及历史边界

- **本次维护谓词**：四文档当前范围、实际验证与 Router 已定终态一致，保留旧 partial/blocked/failed、已完成效果、全部原要求与证据限制；只做局部静态检查。
- **新版 Plan 完成**：Router 已判断 [Plan](plan.md#验证安排与完成条件) 所需 W04/W05/W06/W07 satisfied。恢复不自动完成 S01/S09/I03 或旧 W02/W03；本 Writer 不重评 gate。
- [旧 G1 Work](../mixin-rework/work.md)、[artifact-pipeline Work](../mixin-artifact-pipeline/work.md)、[旧重实现 Work](../mixin-reimplementation/work.md)不改，不迁 Tasks，不 reset/reopen 旧状态。旧 Core 退役测试/fixture 不恢复。
- 本次唯一可写为现有四文件；authority、HTML、其它 Work、代码/注释/测试/构建/依赖/lock/LLM 指令只读。不运行项目/Gradle/测试/实验/安装/reload，不 Git 写入、Todo、提问、派发或选择后续。

## 记录解释

Context 是处理后的事实与来源限制，不是原始 Result；Plan 拥有范围/策略/风险/验证，Waves 是唯一可执行图。只链接已核实可读的项目相对 artifacts，不持久化运行时 Result/会话定位，不新造证据包、schema、receipt 或全报告副本。仓库没有原 Result 不重置可靠历史，源码定位和历史通过数也不自动成为新版验收。
