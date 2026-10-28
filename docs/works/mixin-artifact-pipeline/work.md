# Mixin Artifact Pipeline Work

## 目标与当前阶段

本轮独立目标：Codev 实现真实预应用 Task＋逐 JAR 精确 Strip Artifact Transform，收集引擎应用通知，按 config 完整资源路径＋数组原字符串清理全部匹配项，未通知键保留；供使用者注册、绑定参数并选择消费。用受限使用方 fixture 验证完整清理流取得真实引擎处理目标及要求的清理副本，不认证引擎注入语义或全目标完成。正常完成的 Task target 可按 applied 成果独立消费，不冒充 stripped 或完整清理流；输出用途由使用者决定。具体合同归下列权威，本文件不另立要求。

**当前阶段：Implementation confirmed / in progress；C5 同范围恢复图修订。** 用户已明确确认 Router 披露的原三项完整实施范围（producer/strip 生产实现及组件/真实 TestKit 检查），允许正常本项 Gradle/fixture 自有 outputs/cache；不是待确认 prepared。本 Work 与 [processed Context](context.md)、同目录唯一 [Plan](plan.md)/[Waves](waves.md) 继续承载同一确认范围，不继承旧 G1 许可或验收，也不宣称本轮全链完成。

Router 已采用 MAP-I02、MAP-I03 的 completed 组件事实及 MAP-W02、MAP-W03 的组件范围 satisfied 判定；MAP-I04 为 partial，MAP-W04 不满足、未释放。真实 caller 的 applied-only 请求暴露默认 `cleanupFile` Provider 在 producer 完成前映射自身 `outputFile` 被拒绝；独立 Transform probe 通过不能抵消此失败。处理过的实际验证与限制见 [Context](context.md#已采用的实施与验证事实)。

## 权威复用

| Family / owner | 当前入口与处置 |
| --- | --- |
| PRD / Codev 产品边界 | **reuse** [英文 PRD](../../prd/codev-mixin-rework.md)及[中文译本](../../prd/codev-mixin-rework.zh-CN.md)：通知即清理、Codev 算法与 caller 注册消费职责、组件/请求完整流及用途自主已对齐；已生效（Active），译本不是独立权威。 |
| Spec / `minecraft-codev-mixins` | **reuse** [Mixin Pre-application](../../spec/mixin-preapplication.md)：public Task/Transform tracked inputs/outputs、正常 producer/provider/cache、applied-only 与完整清理消费合同已覆盖默认 Provider 缺口；修复不新增需求或 Spec，不要求 Codev 自动接线或统一出口。 |
| ADR / 操作隔离技术边界 | **reuse** [同一 Accepted ADR](../../adr/mixin-operation-isolation.md)：fresh operation loader、加载域、锁定引擎及映射链保留；Provider 缺陷不改变原隔离选择，无新决定 lifecycle。 |

本入口属于派生协调材料，不修改以上 authority，不升级其状态。原 reuse assessment 在本次恢复范围仍适用；无新的权限、用途、架构或 API 兼容选择待用户决定。

## 完成信号

- 本次只维护四份派生文件：记录已采用事实并细化恢复边；结构、互链、唯一 ID、前置无环和写冲突作静态核对，不执行恢复实现或测试，不产生新实施 Result、不释放 gate。
- 现行 Plan 结果须由 **MAP-W02、MAP-W03、MAP-WR02、MAP-WR04** 共同满足：保留有效组件证据，修复默认 Provider 后补齐原 caller 注册消费/cache/失败闭包，不削减 [Spec 当前验收条件](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions)。原 MAP-I04 partial/MAP-W04 未释放保留为历史，不是恢复路线的终点 gate，也不因 recovery 完成自动改写。

## 同目录派生边界

[Plan](plan.md) 描述策略，[Waves](waves.md) 是唯一执行分解。Router 已选择 producer 默认 Provider repair → caller 未完成边界 recovery；新 MAP-R02/MAP-WR02、MAP-R04/MAP-WR04 均 pending，未来各一 Handler、一独立 Result，不 resume 原 partial。原独立 native 完整应用实证单元与前置门槛不恢复；通知不保证全目标效果，部分完成仍删同键全部匹配项，这是已接受代价而非阻塞。

只面向 Mixin 组件及必要测试，caller 接线仅限已有 TestKit 使用方 fixture，不实现生产注册 helper/DSL/聚合出口。保留原始 `map-i04-focused.log` 失败日志；恢复运行宜用另名普通日志，不新增快照、备份包或证据平台。记录只保留加工事实与已核实可读的仓库相对引用，不承诺完整原 Result 的永久取回；普通测试 XML 可由后续正常测试覆盖。

本次不改生产/测试/launcher/config/authority、旧 G1、README、其它树或 Git；不运行 Gradle/LSP/测试，不安装或清缓存。不重置旧 G1 accepted/closed，不恢复旧 Core 测试，不顺手修 Core 命名/lint、Forge patch，不撤回未知作者混合 diff。
