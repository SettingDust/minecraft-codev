# include(target) 的隔离解析与结果汇集

**状态：Accepted。** 记录日期：2026-10-29。稳定决定标识：`include-target-resolution`。逻辑 owner：Cloche include 请求与选择边界；Codev 继续拥有共享嵌入身份消费。

用户已选择“分别解析 target（推荐）”：仅新重载分开解析再合并，保留现有能力和普通 include，并授权准备对应恢复安排。本 ADR 记录这一结构决定；接受方向不等于实现、验收、恢复安排就绪或实际结构修改授权。实际修改仍须在恢复安排就绪后具体披露并确认。

## 背景与驱动

目标仍是从同一个真实 producer 包含独立 A/B targets，交付两个正确身份及对应嵌入文件，并保持普通 include 兼容。[原 Spec][spec]与[Work][work]已有这一产品范围，因此 PRD skip 仍成立。此前 ADR skip 针对沿用既有选择机制的原接口范围；本次引入解析图边界，构成新的结构决定，不属于 Mixin ADR 的 owner。

[I02 实际报告][i02]为 **partial：5 项测试、1 项失败，其余 4 项通过**。必需 A/B 正例已分别请求 `late.targets:producer-demo-a` 和 `late.targets:producer-demo-b`，真实 runtime variants 各自提供对应的 `5.6` 能力，却共同提供 `early.targets:producer:0.1`。[失败日志][failure]显示它们在 `:consumer:includeFiles` 同图解析时发生 capability 冲突，早于共享身份提取及 JarJar 执行；没有 A/B 最终 Jar/metadata 成功证据。

[当前请求入口][request]已经分别使用 `requireCapability` 选择正确 target；它限制所需能力，不会删除被选 variant 的其他能力。[生产代码][variants]仍声明共同根能力，因此继续使用 `requireCapability` 是必要的，但仅靠它不能消除已观察到的同图冲突。只把根坐标改为晚期值，仍不能改变 A/B 共享根能力的事实。

## 决定

采用 **B：仅 `include(MinecraftTarget)` 请求隔离解析，再汇集到原嵌入任务**。

- 不同 target 的新重载请求进入各自真实解析图；必须在生产接线中分流，不能仍把冲突的 A/B 留在原 `includeFiles` 图中，另由测试绕路。保留请求来源的可辨识性、collector 可观察性及 producer 完整基础身份的懒求值。
- 普通字符串、`Dependency`、`Provider` include 继续使用原图及原含义；不把所有 `ProjectDependency` 拆图。保留 `requireCapability` 对真实 producer target 的完整 base 身份选择。
- 保留生产 capability 集合、现有 loader/platform、Minecraft-version、distribution、data、runtime-JAR 匹配属性值、非传递语义及正常失败传播。不得删除共同根、改属性强制匹配，或为原本缺 base capability 的编译补造能力。
- 最终汇集保留既有同 variant 请求去重、显式完整身份优先、歧义/非命中失败和版本语义。不得无条件拼接文件或身份列表，也不得按文件名、project 路径或最后结果覆盖吞掉不同 target；普通与新重载重复到达同一 variant 时也必须满足这些义务。跨图关联、归组、排序及具体可验证算法由后续 Spec 细化，本 ADR 不预选算法或配置生命周期。
- 不新增 mod DSL，不自动将跨平台 target 合成同一 modId；保留既有 Forge/Fabric 元数据格式和普通 include 默认身份。

## 选择理由与替代方案

B 直接放宽原“所有 target 经单个 `includeFiles` 图”的接线边界，保留用户要求的生产能力模型与匹配值。[当前 Cloche 接线][selection]使用一张非传递解析图；[IncludesJar 接口][embedding]通过 `includedJarInfo.addAll(...)` 接收解析结果，可作为汇集接点。这只是已有接点的源码依据，**不证明多图汇集已实现或兼容性已验证**。

**A：专用 consumable graph variants，未选。** A 可保留单图，但须新增仅提供 target base 身份、不携带共同根的 include 专用生产投影，并区分旧 variant 与新投影的选择，处理消歧、真实产物接线和混用兼容。它增加生产 variant 与选择契约的改动面。当前优先保留现有生产能力及普通消费路径，因此选择将责任限定在新重载消费边界的 B；A 不是已实现通过的后备方案。

冲突规则 `select` 掉 A 或 B、仅增加 secondary artifact variant、lenient 漏项、只改晚坐标、仅换 ArtifactView，均不构成本决定下的恢复：必须实际交付两个 target，而非隐藏原图失败或绕过真实图选择。

## 代价与未决实现限制

Cloche 的 `ClocheDependencyHandler` 与 `TargetCompilation` 需要承担请求分流、解析图与任务依赖接线、结果汇集的新增责任。多个图也带来额外配置/解析管理与跨图重复请求处理成本；非传递边界使范围可限于新重载的直接 target，但不消除这些成本。

Codev 现有接口只是候选接点，不能承诺无需修改 Codev。[I01][i01]证明的是单图逐 variant 的身份消费；尚未证明跨图同 variant 关联、混合普通/显式请求优先和版本行为。若实现需要扩展共享提取或汇集契约，恢复安排须明确披露受影响的 Codev 范围及证据需求，不能以旧 I01 结果覆盖新增代码。

后续须局部更新[原 Spec][spec]的 collector/选择接线及“无需 ADR”的范围说明，细化汇集算法；版本仍沿用既有 artifactVersion fallback 和有效最后 selector 的范围选择，不另立跨图版本合并政策。恢复安排还须披露新增 owner 和实际修改范围。本次只交付本 ADR，不修改 PRD、Spec、Work/Context/Plan/Waves、生产代码或测试。

## 验证事实与适用边界

- **I01 保持 completed**：既有报告为 14 项通过，含真实 smoke；本次未重跑，不重开其已完成事实。
- **I02 保持 partial**：已有单 named + 空名 root target 与普通 collector 混合、属性不兼容拒绝、缺基础能力拒绝、Fabric 默认/显式身份与原 metadata 保留这四项通过事实。必需同 producer A/B 正例仍失败，不能以四项通过替代。
- **`ITI-W01-G` 仍未满足**。B 当前为已接受方向，尚无生产分流、跨图汇集及 A/B 最终 metadata/payload 通过证据。后续恢复必须满足原 A/B 与普通调用兼容终态，不能降低为两个不同 producer、选掉一项或预期失败。本 ADR 不新增测试矩阵、gate 或证据系统。

上述结果来自已存在的仓库报告和日志，不是本次执行结果。原 Work 的准备期描述保留其历史时点，不覆盖后来 I01/I02 的实际结果。

## 复查条件

当保留原能力、匹配属性及普通图的前提下，B 无法交付真实 A/B 双身份与对应 payload，或无法维持同 variant 去重、显式优先和原版本语义时，复查本决定。若出现必须保留单解析图的真实约束，或必须改变生产能力/公共 API 的需求，也须重新评估 B 与 A 的代价；不因此自动授权采用 A 或扩大实现范围。

## 来源

以下均为已核实存在的仓库相对来源。构建报告/日志记录现有结果，不承诺在清理 build 输出后仍保留。

- [include-identity Spec][spec]：请求、身份、版本、兼容与验收合同；原接线待局部对齐。
- [include-target-identity Work][work]：文档归属、原 PRD/ADR skip 边界及 gate。
- [I02 partial 报告][i02]与[必需 A/B 失败日志][failure]：真实请求、共同根冲突与四项通过。
- [I01 completed 报告][i01]：14 项通过的既有范围与限制。
- [ClocheDependencyHandler][request]、[CompilationVariantCreator][variants]、[TargetCompilation][selection]、[IncludesJar][embedding]：当前请求、能力生产、单图接线及汇集接点。

[spec]: ../spec/include-identity.md
[work]: ../works/include-target-identity/work.md
[i02]: ../../../cloche/build/reports/test/include-identity/identity-evidence.md
[failure]: ../../../cloche/build/reports/test/include-identity/fixtures/positive-2653223811858626150/gradle.log
[i01]: ../../minecraft-codev-includes/build/reports/test/identity-evidence.md
[request]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/api/target/compilation/ClocheDependencyHandler.kt
[variants]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/CompilationVariantCreator.kt
[selection]: ../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/TargetCompilation.kt
[embedding]: ../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt
