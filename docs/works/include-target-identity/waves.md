# Include target identity Waves

[Work](./work.md) · [Context](./context.md) · [匹配 Plan](./plan.md)

## 状态与唯一图

本文件是唯一 item/dependency/gate 执行图。本次 C5 **仅同步已发生的交付与 Router 已有 gate 判断**：准备路径独立复核已闭合，用户经完整范围披露明确选择“实施并验证”；I03/I04 各自 generation 1 已 completed，Router 已逐项判断 ITI-W01 完成、ITI-W01-G 在确认范围内满足。本次不选择或执行新项、不补发授权或另行释放 gate，不改变原完成谓词、成员、依赖、冲突或已确认方案。没有第二图或 Tasks，Plan 不复制本图。

权威为已接受的 [Spec](../../spec/include-identity.md) 与 [ADR](../../adr/include-target-resolution.md)。原 `ITI-I01 → ITI-I02` 的历史结果保留；旧单图策略失效部分由新有界项承接，不重用原 Handler 或追改原 Result。前序及 I03/I04 Handler 均已终止，无并行写者。

## 历史采用记录

| item | 原 task / generation | 历史终态 | 已交付与未履行事实 |
| --- | --- | --- | --- |
| `ITI-I01` | `implement-codev-explicit-include-identity` / 1 | **completed** | Codev 单图的 variant/request 聚合、完整身份优先、错误/默认/版本边界及必要 projection/API helper 已交付；14 tests、0 failures/errors/skipped，含真实 Java smoke。新跨图 API 不由这 14 项证明。 |
| `ITI-I02` | `implement-cloche-include-target-identity` / 1 | **partial** | Cloche target 重载、两处 late fallback、本地接线和 fixture 已交付；5 tests、1 failure、0 errors/skipped。single named/root + 普通调用、属性拒绝、缺失 base 拒绝、Fabric 四项通过；同一真实 producer A/B 在旧 includeFiles 因共同根 capability 冲突失败，未到身份/JarJar，无 A/B 最终 Jar。 |

历史可读证据：[I01 归档报告](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/identity-evidence.md)、[I01 归档 XML](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)、[I02 归档报告](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/identity-evidence.md)、[I02 归档 XML](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/xml/TEST-earth.terrarium.cloche.IncludeTargetIdentityTests.xml)。归档 XML 仍为 14/0/0/0 和 5/1/0/0，当前报告分别对应 I03/I04；不把新运行回写旧 Result。本次未执行测试，外部 Result 路径不持久写入文档。

原 W01 members 为 `{ITI-I01, ITI-I02}`，旧 `ITI-W01-G` **未满足**，不是后续方向接受时自动通过。I02 的原 prerequisite `ITI-I01` 与 generation 1 关联作为历史保留；它不再是待调度的当前恢复成员，也不假设其 partial 自动完成。

## 当前有界 items

### ITI-I01 — 已采用的单图身份消费

- **current state**：completed（原 task/generation 不变）；原无 prerequisite。
- **原 owner/write surface**：Codev includes 身份提取与必要共享 helper；局部原定点测试/fixture。完整 requested `group:name` 唯一 exact match 优先，default/feature-only 兼容，same-variant requests 聚合和 projection、版本 fallback/range、unresolved 传播等原成功边界保留。
- **required evidence**：上述 14/0 与真实 smoke，见历史报告/XML；不要求重跑原全部 14 项。它为新恢复 API 提供既有源码和基础行为，不能代替新 API 的证据。

### ITI-I02 — 保留的原 Cloche partial

- **current state**：partial（原 task/generation 不变）；历史 prerequisite 为 ITI-I01。
- **原 owner/write surface**：ClocheDependencyHandler 的 `include(target)`、真实 owning project/base request、两处 late capability fallback、现有本地替换及五项 fixture。
- **保留结果**：源码/四通过/一项必需 A/B 失败均真实保留，不回滚已完成能力，不把缺失结果改成 completed。原单图恢复不能继续；本项不再等待或占用新 Handler，不要求先改写其状态才能恢复。
- **未履行义务的明确承接**：同 producer A/B 的生产解析和最终同 Jar metadata/payload，由 ITI-I04 实际满足；必要共享跨图身份/去重/版本能力，由 ITI-I03 交付并被 ITI-I04 消费；原所有兼容条件仍是当前 gate 的条件。两份新 Result 不取代这份历史 partial。

### ITI-I03 — 可独立消费的多源提取与任务 API

- **current state**：completed；独立 task `recover-codev-include-source-gathering` / generation 1，外层与内层 Result 均 completed，已终止，由 Router 完整读取关联并采用。
- **single result / completion predicate**：本地 Codev includes 提供一个兼容现有单图调用的、可由 Cloche 独立消费的多源汇集/任务输入 API；它先建立真实 variant/artifact/request/source 关联，再完成身份、普通优先版本与去重，并保存 producer 任务依赖。一个 API 交付结果，不拆 compile、fixture 或测试项。
- **owner/write surface**：`minecraft-codev-includes` 的 IncludedJarInfo.kt、IncludesJar.kt、必要来源 DTO；既有 IncludedJarInfoIdentityTests 与 Java include-identity fixture。接口与关联/版本算法采用 Plan 的已选形状，不留给实施者重选。保留旧单图方法签名及公共 selector API；不改 Cloche 分流或 Forge/Fabric 生产消费。
- **prerequisites**：ITI-I01 已采用的实现/证据；恢复安排的独立复核与实际范围确认。上述前置均已满足，用户确认后才实施；该人类/Router 前置不伪装成新增测试 gate 或第二执行图。
- **required checks**：新多图聚合、mixed-source ordinary 最后 selector 版本和真实 Java 多图/task API 三类聚焦检查；同 variant/artifact 跨图重复、同 variant 不同/缺失 artifact 来源的全部 request 汇总、跨图两个完整身份失败、nonmatch、capability/request 顺序、projection/全 graph 属性、不同真实 target/variant 不合并、feature-only/default/unresolved 及版本 fallback，按 Plan 覆盖。只复核 Plan 精列的六个受影响旧方法，不无条件重做原 14 项。
- **入口/evidence**：实际 `-p minecraft-codev :minecraft-codev-includes:test`，重复 `--tests` 运行 Plan 所列六旧三新，最终 [XML](../../../minecraft-codev-includes/build/reports/test/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)为 **9/0/0/0**、退出 0。完整命令、Gradle 9.4.0 / daemon与fixture Temurin21.0.10 / JUnit Adoptium17.0.15、同一用户 Home、八次真实 TestKit build（旧 smoke 一次、新 API 七场景）、版本/身份/多 artifact/producer 依赖和失败修正见 [I03 报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)及 [观测日志](../../../minecraft-codev-includes/build/reports/test/i03-observations.log)。I01 原运行已归档，不冒称 Cloche 生产交付或改写旧 Result。
- **readiness relevance**：直接触及 I01 API/提取实现的新增 owner/写面和必要回归已纳入既有独立准备复核与实际披露/确认，随后按原 required checks 交付；不以“只改 Cloche”省去该边界。

### ITI-I04 — 实际 Cloche 嵌入任务的隔离 target 交付

- **current state**：completed；独立 task `recover-cloche-target-include-isolation` / generation 1，外层与内层 Result 均 completed，已终止，由 Router 完整读取关联并采用。
- **single result / completion predicate**：同一真实 producer 的独立 A/B，经 Cloche 生产来源分流和同一实际 TargetCompilation.includeJarTask 交付不同元数据身份与 payload；普通重复/版本及原普通/Fabric 边界同时保持。API 消费、collector/继承/任务接线及其验收共同构成这个用户可见终态，不按文件/辅助编译拆项。
- **owner/write surface**：ClocheDependencyHandler 内部 dual collector/target 登记；TargetCompilation 图与一次聚合接线；Linkage.extendFromDependency 的 ordinary bucket 与 target 记录继承；必要局部 internal helper；既有 IncludeTargetIdentityTests/fixture；仅必要现有 init script composite substitution 入口、属性控制 plugin metadata/source 检查接线。继续保留 I02 两处 late fallback。消费 ITI-I03 API，不在 Cloche 重写共享提取或重做 Codev item。
- **prerequisites**：ITI-I03 的可消费 API 与合格 Result/证据；上述恢复安排独立复核及实际范围确认，现均已满足。依赖是真实编译/运行 API 消费关系，不是“验证便利”；不等待 ITI-I02 completed 或 ITI-W01-G。
- **required checks — 生产图**：collector 可见 generated 完整请求；ordinary 与 generated 即使相等/相同 capability/Provider 包装仍按来源分流；重复同原 target 一图，不同原名/真实 target 不因 normalized suffix/路径/坐标碰撞归并。普通 bucket 及 inherited hierarchy 无 generated A/B；target 图保留真实 platform/loader/MC/distribution/legacy/data 属性值、Provider timing、Library/JAVA_RUNTIME/JAR、非传递及必要 constraints。共同根能力保留、full requireCapability、late group/version、冒号和 root 均按原规则；incompatible/missing/upstream failure 正常传播，不修改 producer 选取合同。
- **required checks — 交付**：fixture 只请求生产 `:consumer:includeJar`，不自己创建替代图或接共享方法；普通 fixture outer Jar/manifest 与 producer payload 替换只避免 MC 重任务。生产 Buildable 自行安排全部 producer，观测 selected variants/requests；同一最终 Jar 解包核对 A/B 不同 identity 与 payload、jars/path、版本字段。既有 compilation 继承多路记录也正确分流/去重，不给 fixture 手工 producer dependsOn 冒充生产依赖。
- **required checks — 重复/版本/兼容**：真实 target+ordinary module→同一 project runtime variant 混合保留全部身份来源、一次嵌入、unique explicit 优先且 ordinary traversal 最后 module 的 strict→required→preferred 不被 target default 替换；普通最后 project 保留 default，无普通来源保留 target rule；跨图 distinct complete identities 失败。ordinary-only last selector、string/Dependency/Provider、普通 project/module、重复不双嵌、非传递、Fabric 普通生成及已有 JSON、JarJar 数组/path 均保留；用受影响断言/方法过滤验证，不无条件重做已过项目或新建框架/版本矩阵。
- **入口/evidence**：现有 Cloche `-p cloche -I "E:/Projects/cloche/cloche/src/test/include-identity.init.gradle" includeIdentityTest --tests ... -PincludeIdentityCodevRoot=../minecraft-codev`（启动目录为 `E:/Projects/cloche`；`-I` 使用绝对脚本路径，属性路径由 Cloche settingsDir 解释，详见 Plan）；原 `build/reports/test/include-identity` 中命令/过滤方法、XML/log、本地 includes 外层/内层 codeSource 与 duplicate-class 检查、图/属性/selector/producer-task 观测、最终 Jar/解包内容和未运行边界。新增 source DTO/API 亦来自本地实现；旧 0.6.5 不能冒充通过。原 5/1 与四通过已在 history/ITI-I02-generation1 归档。实际使用 Gradle9.4.0、既有 Microsoft JDK17.0.19 和同一用户 Home；外层编译及内外层新旧 API/core/annotation 来源已实测。
- **实际结果**：[I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)对应三批原 XML：[core attempt1](../../../../cloche/build/reports/test/include-identity/i04-core-attempt1.xml) **3/1/0/0**、[compat attempt1](../../../../cloche/build/reports/test/include-identity/i04-compat-attempt1.xml) **7/1/0/0**、[collision attempt2](../../../../cloche/build/reports/test/include-identity/i04-collision-attempt2.xml) **1/0/0/0**。11 个方法实例、9 个不同方法各自最新通过，覆盖 13 个不同 fixture 场景；继承与碰撞两个中间失败经定点重验修正，非一次 9/0、无合成 XML。逐方法对应和真实 Fabric client/data/clientData 继承证据见 [Context](./context.md)。
- **实际生产交付**：仅请求 `:consumer:includeJar` 即自动带出 A/B/single/library producer tasks；同一 [Forge Jar](../../../../cloche/build/reports/test/include-identity/fixtures/positive-11959594579841300059/build/included/forge.jar)含 `late.targets:producer-demo-a:5.6` / `late.targets:producer-demo-b:5.6`、各 `[5.6,)`、`META-INF/jars/a.jar` / `b.jar` 及 target A/B payload；另有 [Fabric Jar](../../../../cloche/build/reports/test/include-identity/fixtures/fabric-681644005113503057/build/included/fabric.jar)兼容证据。没有 fixture 手工分图或 producer dependsOn。

## 依赖、冲突与联合等待

| item | 当前 prerequisite | conflicts / shared resources | 允许调度状态 |
| --- | --- | --- | --- |
| ITI-I01 | 无；历史已采用 | 无活跃写者 | completed，仅作为既有依赖 |
| ITI-I03 | ITI-I01；独立复核/实际范围确认均已满足 | ITI-I04：同一个真实用户 Gradle Home；本地 includes/core/side-annotations（`:minecraft-codev-core:side-annotations`）编译输出、includes/build/reports/test 及本地替换 classpath 的读写 | completed，已终止 |
| ITI-I04 | ITI-I03；独立复核/实际范围确认均已满足 | ITI-I03：上述共享 Home/输出/输入；Cloche build/reports/test/include-identity 与 fixture 输出也独占 | completed，已终止 |

四份同目录协调文档的维护也必须串行；不得与任何改同一 Home/本地 includes 或 Cloche 输出、相关源码的写者并行。I01/I02 及 I03/I04 Handler 均已结束，不作为锁或等待条件；本次无并行写者。若另有明确授权的后续写入，仍须重新核实冲突，不从本记录推导新调度。本表的冲突不是新增功能依赖或额外验收项。

当前行为依赖是 `ITI-I01 → ITI-I03 → ITI-I04`；gate 只向当前成员的合格结果收敛。W01 不依赖自己的 gate，I03/I04 不依赖 gate；无 item 自等、Wave 自等或 item↔gate 环。历史 I02 的 I01 prerequisite 不参与当前调度，不构造“必须把 partial 改 completed 才能开始”的死锁。

## ITI-W01 — 当前匹配恢复交付

- **current state**：completed，仍沿用同一 W01 ID；依据 Router 已有逐项判断同步，本次不另作 gate 决定。
- **members**：`ITI-I01`（已采用 completed）、`ITI-I03`（completed）、`ITI-I04`（completed）。
- **prerequisite gate**：无，保留原 W01 无前置 gate 的安排；文档准备/作者自检不产生执行选择。
- **member change**：原 I02 作为历史 partial 保留，未履行义务显式映射给新 I03/I04；不把原 partial 当作 member 成功，不删除其失败或豁免条件。

### ITI-W01-G — 原条件保留并扩展的合格证据门槛

**当前 state：satisfied（满足）**。Router 已完整读取并关联当前成员 Result，逐项判断以下原条件在确认范围内均有采用证据；本次只同步该现有判断，不由作者自检推导或放宽 gate。原 `{I01,I02}` 阶段 unmet 仍为历史，旧 I02 generation 1 仍 partial：

| 保留/扩展的条件 | Router 已采用的当前满足证据 |
| --- | --- |
| 原 Codev 完整请求优先、默认兼容、diagnostic failure、版本 fallback 与 unresolved | [I01 归档 14/0](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)保留；[I03 最终 9/0](../../../minecraft-codev-includes/build/reports/test/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)含六个受影响旧方法与三项新增，承接完整请求/默认/版本/失败与多源边界。 |
| 原 Cloche owning project/base capability；完整 include DSL 兼容 | [I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)：生产 collector 分流、late 快照、producer owning identity/base、普通 string/Dependency/Provider/action/bundle/constraints、ordinary-only 和真实继承均有最新通过方法。I02 四通过仍保留为历史，不追改 partial。 |
| 原同 producer A/B 的不同 Forge 身份与对应最终 Jar payload | 原 I02 A/B 失败保留；I04 [core XML](../../../../cloche/build/reports/test/include-identity/i04-core-attempt1.xml)的生产任务正例通过，同一 [Forge Jar](../../../../cloche/build/reports/test/include-identity/fixtures/positive-11959594579841300059/build/included/forge.jar)解包核对 A/B 不同身份、5.6/[5.6,)、a.jar/b.jar 与各 payload；只请求 consumer 自动执行 producer tasks，无 fixture 分图或手工依赖。 |
| 原真实属性值、共同根 capability、requireCapability、非传递和普通失败 | I04 报告及 [compat XML](../../../../cloche/build/reports/test/include-identity/i04-compat-attempt1.xml)：真实接收属性、constraints、非传递、完整 requireCapability/共同根保留；Fabric client/data/clientData 多路继承通过，incompatible/missing capability 仍按原选择失败；未改能力/属性绕过。 |
| 原 Forge jars/path/version 与 Fabric 普通生成/已有 JSON 兼容 | I04 [Forge Jar](../../../../cloche/build/reports/test/include-identity/fixtures/positive-11959594579841300059/build/included/forge.jar)保留 6 项 metadata、版本/range/jars/path 和嵌套 payload；[Fabric Jar](../../../../cloche/build/reports/test/include-identity/fixtures/fabric-681644005113503057/build/included/fabric.jar)验证 target/普通生成、既有 outer 字段和 library metadata 字节保留。 |
| 原本地新实现与可读执行/元数据/payload 证据 | [I03 报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)与 [I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)记录原样命令、Gradle9.4.0、各自真实 JVM/同一 Home；I04 [compile-classpath](../../../../cloche/build/reports/test/include-identity/compile-classpath.txt)/[outer-sources](../../../../cloche/build/reports/test/include-identity/outer-sources.txt)及 fixture 日志证明本地编译/内外来源和唯一资源。历史、三批原 XML、log/Jar 均有可读相对入口。 |
| 新跨图真实 variant/artifact/source 汇集、精确身份与不双嵌 | I03 9/0 的真实多源 API、request-only/多 artifact/去重/不同 target/全属性/歧义检查与 I04 实际生产消费共同满足；I04 重复和混合单次嵌入通过，跨图完整身份歧义为预期失败；[碰撞重验 XML](../../../../cloche/build/reports/test/include-identity/i04-collision-attempt2.xml)保留两来源/producer，不误合并，重复 a.jar 显式失败属预期负例。 |
| 新 ordinary 优先版本合同 | I03 的完整 selector/fallback 与七个新 API 真实场景、I04 ordinaryVersionsTakePrecedenceAcrossProductionTargetSources 的五个 fixture 验证 ordinary 实际最后 module strict/required/preferred、最后 project/default、无 ordinary target rule，同时保留全部来源身份与单次产物。 |
| 当前成员结果完整性 | I01 原 task/generation 1 completed 不变；I03 `recover-codev-include-source-gathering` / 1 与 I04 `recover-cloche-target-include-isolation` / 1 各有独立 completed Result，Router 已完整读取关联并采用；两者终止、无并行写者。当前三成员均 completed，I02 仍 partial，其未履行义务由 I03 API 和 I04 生产同 Jar 新证据满足。 |

G2/G3、MC 重型构建、根 test、代理/Home 配置、发布安装和 Git 写入不属于 gate 成功条件。新增共享 API、collector/继承/任务接线及 focused 命令修正属于实际范围披露，不通过豁免原 A/B 或旧 gate 来收缩合同。

## 原作者自检记录（准备历史）

已按完整权威与四份原始 Result 核实上述历史和恢复边界；两项新实现分别是可独立消费的共享 API、消费该 API 的实际嵌入交付，各只有一个独立 Handler/Result 终态。所有测试/编译/fixture 为所属行为证据，未额外设门槛。当前 dependency/conflict/W01 成员与 gate 表逐项相互核对；旧 A/B 缺口有新责任方，gate 不等待旧 partial、无环无自等。这里只是作者检查结论，不是独立 readiness review、用户范围确认、item 完成或 gate 通过；更详细的来源/限制见 Context。

## 本次事实同步与限制

本次完整读取并关联三份指定 Result（I03/I04 交付及绝对路径独立复核），对照原两处报告、I01 14/0 与 I02 5/1 归档、I03 9/0 和 I04 三批原 XML。原完成谓词、owner/write surface、required checks、成员、前置依赖、冲突及本 gate 左列条件不变，只更新已发生状态/满足证据和历史归属；局部回读事实与相对链接，不独立重审实现、不运行构建测试。

I04 9 个方法各自最新通过不等于一次 9/0；两次中间 fixture 失败及定点修正保留，真实继承证明为 Fabric client/data/clientData。既有 testExternalRuntime 缺失未修，技能加载顺序偏差仍见 Context/原报告。未跑根 test、MC 重构建、版本/配置缓存矩阵、I03 其余八个旧方法或 G2/G3；未重跑 I03 成功套件，未处理 buildSrc、安装、发布或提交。build 下历史/当前证据可被清理，当前 gate 判断不代表全项目/全版本验收。
