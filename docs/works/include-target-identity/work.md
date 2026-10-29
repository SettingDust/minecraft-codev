# Include target identity Work

[Context](./context.md) · [Plan](./plan.md) · [唯一执行图 Waves](./waves.md)

## 目标与当前阶段

让 `consumer.dependencies { include(a); include(b) }` 从同一真实 producer 包含独立 MinecraftTarget，在同一个实际嵌入任务中交付不同的 Forge 身份及对应 payload，普通 include/Fabric 保持兼容。当前恢复方向是**仅 target 重载隔离解析，先汇总真实 variant/artifact/request，再提取身份；混合重复由普通图有效最后 selector 提供版本规则**。

已确认范围已交付。绝对 init-script 路径的独立定点复核已闭合准备阻断；其后用户在完整披露 Codev 共享 API、Cloche 分流/继承/实际任务及验证范围后明确选择“实施并验证”。Router 已完整读取并关联 I03/I04 各自 generation 1 的 completed Result，确认两者已终止、无并行写者，并逐项判断原 `ITI-W01-G` 在已确认范围内满足，`ITI-W01` 完成。本次 C5 只同步这些已发生事实，不另作授权、实施或 gate 决定；早期 not-ready 及未确认口径仅属准备历史。

## 权威评估

| family | action / owner | 当前依据 |
| --- | --- | --- |
| PRD | skip；Cloche 局部请求与 Codev embedding | 原同 producer A/B、普通 include 兼容目标不变，无新增产品矩阵；不借用 [Mixin PRD](../../prd/codev-mixin-rework.md)。 |
| ADR | reuse；Cloche 解析边界，Codev 共享消费 | 已接受的 [include-target-resolution](../../adr/include-target-resolution.md)选择 B，仅新重载分图；取代原准备期“无需新 ADR”的结构判断，不改生产能力或普通图。 |
| Spec | reuse；Cloche 请求/接线与 Codev 提取/汇集 | 当前 [include-identity](../../spec/include-identity.md)已覆盖 provenance、collector、隔离、真实关联及普通版本优先，原混合版本缺口已关闭；本轮不改权威。 |

上述评估采用完整读取的 Spec 闭合结果与当前权威/源码；早期恢复分析中的候选 A/B 和版本缺口属于历史，不再作为待选方案。[difference proposal](../../proposals/codev-difference-rework.md)仍非本工作权威。

## 已采用的结果与历史

| item / task / generation | 采用的真实状态与证据边界 |
| --- | --- |
| `ITI-I01` / `implement-codev-explicit-include-identity` / generation 1 | **completed**；原单图共享身份提取及必要 projection/API helper 已交付。定点入口退出 0，14 tests、0 failures/errors/skipped，含真实 smoke；见 [I01 归档报告](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/identity-evidence.md)。不重开、重跑或改写原 Result。 |
| `ITI-I02` / `implement-cloche-include-target-identity` / generation 1 | **partial**；target 重载、两处 fallback 懒求值、本地接线及 fixture 已交付。定点入口退出 1，5 tests、1 failure、0 errors/skipped；四项通过、必需同 producer A/B 在原普通图因共同根 capability 冲突失败，当时尚无 A/B 最终 Jar。见 [I02 归档报告](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/identity-evidence.md)。任务包装层 completed 不改变内层 Result 的 partial。 |
| `ITI-I03` / `recover-codev-include-source-gathering` / generation 1 | **completed**；兼容旧单图的多源汇集和惰性任务 API 已交付。最终六旧三新 **9/0/0/0**，真实 Java 多图/混合版本/身份歧义、artifact 去重及 producer 自动任务依赖通过；见 [I03 报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)。 |
| `ITI-I04` / `recover-cloche-target-include-isolation` / generation 1 | **completed**；生产分流、独立解析、继承及实际 includeJarTask 已消费 I03。三批 XML **3/1/0/0、7/1/0/0、1/0/0/0**，11 个方法实例、9 个不同方法各自最新通过、13 个不同 fixture 场景；两次中间失败定点修正，非一次 9/0。见 [I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)。 |

旧 `{I01,I02}` 阶段 gate unmet、早期独立 review not-ready 与 I02 A/B 失败均保留为历史。原 A/B 未履行义务现由 I03/I04 新证据满足，不把 I02 generation 1 改为 completed。准备路径阻断的独立闭合、用户范围确认与 Router 当前最终 gate 判断分别记录于 [Context](./context.md) 和 [Waves](./waves.md)，不以文档作者自检替代。

## 归属与完成信号

保留同目录 `work.md`、`context.md`、`plan.md`、`waves.md` 和唯一匹配 Plan/Waves；无第二执行图、Tasks、overview 或新证据系统。Codev 拥有共享跨图提取/汇集 API，Cloche 拥有 collector 来源、普通 bucket、target 隔离图、继承与实际 includeJarTask 接线。具体恢复 item、依赖和 gate 仅在 Waves。

最终完成由 `ITI-W01-G` 建立；Waves 忠实记录 Router 对当前成员 I01/I03/I04 的 completed 结果及逐项证据作出的满足判断。I03 共享 API 已独立交付并被 I04 生产任务消费，I02 partial 的全部原义务与失败仍可追溯；原完成条件、成员、依赖、冲突及跨图/混合版本合同不因本次同步而改变。

本轮只写这四份派生协调文档，局部回读事实和仓库相对证据；未修改权威、生产/测试/配置/依赖、报告/XML/Jar、Home/代理或 Git，未运行 Gradle、构建、测试、发布安装。

交付限制仍在：I04 继承证明为真实 Fabric client/data/clientData；既有 testExternalRuntime 缺失未修，根 test、MC 重构建、版本/配置缓存矩阵、G2/G3 和 buildSrc 均不在本次验证内。I04 技能加载顺序偏差及失败修正见 Context/原报告；build 下证据可能被清理，当前结论不代表全项目或全版本验收，未发布、安装或提交。
