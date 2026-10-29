# Include target identity Context

[Work](./work.md) · [Plan](./plan.md) · [唯一执行图 Waves](./waves.md)

## 当前采用范围

本页是同目录交付的 processed Context，只保存已采用事实、仓库证据和选定接线理由，不保存外部原始 Result 路径，不是产品/架构权威或第二执行图。绝对 init-script 路径的独立定点复核已经闭合准备阻断；用户随后经完整披露明确选择“实施并验证”，范围包含 I03 共享 API 和 I04 分流/继承/实际任务验证，不含 buildSrc、发布或提交。本次 C5 仅同步已发生状态和 Router 已有最终 gate 判断，不补发授权或执行工作。

用户已选择**仅 include(target) 各自解析后汇集**；混合重复的版本采用普通来源优先，target 显式身份保留，无 ordinary 则使用 target 原规则。已接受的 [Spec](../../spec/include-identity.md) 是唯一行为合同，[ADR](../../adr/include-target-resolution.md) 是隔离方向决定；本轮仅 reuse，PRD skip，原产品目标未变。早期 no-new-ADR、单图复用、混合版本待决的准备判断已被后来接受的权威局部取代，不把旧文字当当前策略。Mixin PRD/Spec/ADR 和 Proposed difference proposal 不提供本工作授权。

## 当前已采用的交付与 gate 判断

本次完整读取、解码并关联以下三份 Result 的 task/generation、外层状态和内层正文，再对照仓库现有报告。I03/I04 均为独立 generation 1 completed，已终止且无并行写者；准备复核的 completed 只表示复核完成，当时就绪不等于实施授权。

| item / 作用 | task / generation | 采用结果及可移植证据 |
| --- | --- | --- |
| I03 共享 API | `recover-codev-include-source-gathering` / 1 | **completed**；[报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)、[最终 XML](../../../minecraft-codev-includes/build/reports/test/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)、[最终日志](../../../minecraft-codev-includes/build/reports/test/i03-gradle.log)、[真实来源/selector/任务观测](../../../minecraft-codev-includes/build/reports/test/i03-observations.log)、[API 隔离](../../../minecraft-codev-includes/build/reports/test/i03-api-isolation.log)。最终六旧三新 **9/0/0/0**，退出 0；新旧 API 本地来源与资源唯一性已检查。 |
| I04 生产交付 | `recover-cloche-target-include-isolation` / 1 | **completed**；[报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)、下列三批原 XML、[Forge Jar](../../../../cloche/build/reports/test/include-identity/fixtures/positive-11959594579841300059/build/included/forge.jar)、[Fabric Jar](../../../../cloche/build/reports/test/include-identity/fixtures/fabric-681644005113503057/build/included/fabric.jar)。实际分流/继承及生产 includeJarTask 已消费 I03 API。 |
| 准备路径独立复核 | `review-include-absolute-init-path` / 1 | **completed**；剩余 P1 已闭合，结合未变范围既有复核，准备可进入实际披露/确认。当时仅静态复核，不证明代码运行或释放 gate；后续确认和运行由上两项及 Router 当前判断承接，历史顺序见末节。 |

I03 已提供 IncludeTargetOrigin/IncludeTargetSource/ResolvedIncludeSource，保留旧单图签名，跨图先汇总全部 request 再判身份及 artifact 去重；ordinary 有效最后 selector 供版本规则。新任务 API 惰性一次汇集并保留 Configuration/Buildable 任务依赖。最终八次真实 TestKit build（旧 smoke 一次，新 API 七场景）含 strict/required/preferred/project-last/target-only/default/ambiguous；[strict gathered.jar](../../../minecraft-codev-includes/build/reports/test/fixtures/java-strict-904299463377634232/build/gathered/gathered.jar)及报告各场景日志保存实际消费证据。负例为选到同一真实 variant 后的身份歧义，不是更早选取失败。

I04 已实现 ordinary/generated collector 分流、原 target 对象去重、共享首次晚坐标快照、独立真实解析配置、接收 compilation 属性/constraints/非传递/requireCapability，Linkage 沿原继承关系传播记录；保留重载及两处 late fallback，不在 Cloche 复制跨图算法。真实 `:consumer:includeJar` 未手工分图或 dependsOn producer，即自动执行 `:producer:fixtureA`、`:producer:fixtureB`、`:single:fixtureSINGLE`、`:library:jar`。同一 Forge Jar 共 6 项，A/B 分别为 `late.targets:producer-demo-a:5.6` / `late.targets:producer-demo-b:5.6`、range `[5.6,)`、path `META-INF/jars/a.jar` / `META-INF/jars/b.jar`，JUnit 解包核对 target A/B payload。

### I04 真实分批结果

| 原 XML | tests / failures / errors / skipped | 实际顺序与修正 |
| --- | --- | --- |
| [core attempt1](../../../../cloche/build/reports/test/include-identity/i04-core-attempt1.xml) | **3/1/0/0** | A/B 与 ordinary-only 通过；继承 fixture 被既有 testExternalRuntime 缺失挡住。 |
| [compat attempt1](../../../../cloche/build/reports/test/include-identity/i04-compat-attempt1.xml) | **7/1/0/0** | 继承改用真实 Fabric client/data/clientData 后通过，另有 Fabric/混合/歧义/属性/能力方法通过；碰撞 fixture 初次触发既有 single-target 检查。 |
| [collision attempt2](../../../../cloche/build/reports/test/include-identity/i04-collision-attempt2.xml) | **1/0/0/0** | 补足 fixture 的 unused named target、明确晚坐标后，对原碰撞方法定点重验通过。 |

共 **11 个方法实例、9 个不同方法、13 个不同 fixture 场景**；9 个方法各自最新结果均通过。两个中间失败原样保留；不存在一次 9/0 的 I04 suite，未合成 XML，当前 xml/html 只代表最后单方法运行。最新通过逐方法对应如下（XML 见上表）：

| 方法 | 最新通过 XML |
| --- | --- |
| `targetsAndOrdinaryCollectorCallsDeliverRealJarJar` | core attempt1 |
| `ordinaryOnlyCollectorStillUsesProductionIncludeJar` | core attempt1 |
| `inheritedTargetsUseReceivingCompilationAttributesWithoutDuplicates` | compat attempt1 |
| `ordinaryVersionsTakePrecedenceAcrossProductionTargetSources` | compat attempt1 |
| `conflictingOrdinaryAndGeneratedIdentitiesFailWithSourceDetails` | compat attempt1 |
| `normalizedTargetsFromDistinctProjectsAreNotSilentlyMerged` | collision attempt2 |
| `incompatibleMinecraftTargetFailsOriginalAttributeSelection` | compat attempt1 |
| `missingLateBaseCapabilityFailsNormalResolution` | compat attempt1 |
| `fabricUsesDefaultAndExplicitIdentityAndPreservesExistingMetadata` | compat attempt1 |

[继承日志](../../../../cloche/build/reports/test/include-identity/fixtures/inheritance-9859678214678446931/gradle.log)记录 client/data/clientData 接收属性及每处 3 个 target 图、多路/本地重复不增图；[碰撞日志](../../../../cloche/build/reports/test/include-identity/fixtures/collision-8972837236901670711/gradle.log)保留两个来源、自动 producer 任务和 2 项 IncludedJarInfo，真实 includeJar 因 duplicate a.jar 明确失败，这是预期负例，不是成功 Jar。普通 string/Dependency/Provider/action/bundle/constraints、ordinary-only、混合 strict/required/preferred/project/default、非传递、MC/缺 capability 失败及 Fabric 生成/已有 metadata 的实际覆盖详见 I04 报告。

Router 逐项对照原 `ITI-W01-G`：I01 原单图行为由历史 14/0 与 I03 六旧三新 9/0 承接；I03 真实多源关联、普通混合版本、身份歧义/去重、任务依赖已验证；I04 原重载/late/普通 DSL/属性/requireCapability/非传递、同 Jar A/B 身份/版本/path/payload/自动 producer、Fabric/继承/重复/混合/负例均有对应证据，外层编译及内外本地来源已实测。当前成员 I01/I03/I04 均有独立 completed Result 与证据，Router 已判断 **ITI-W01 完成、ITI-W01-G 满足**。本页与 Waves 只投影该判断，不自行改变原条件或释放新 gate；I02 generation 1 仍 partial，历史 unmet/not-ready 不被改写。

### 运行限制与保留失败

I03 attempt1/2 的不完整 JDK paths、attempt3 helper 编译、attempt4 substitution 失败及同范围修正顺序见原报告；最终 selector 日志修正后再次九方法 9/0。I04 最初 Java21/Java17 变体不匹配、非导出 annotation import、把编译 artifact 误当 Jar 的三次失败，分别通过沿用 Java17、运行时来源反射和实际 project/class directory 检查修正；两次 fixture 失败与重验按上表保留。I04 先加载 implement-change/read context、后补齐 implement-plan/pragmatic-delivery 的顺序偏差如实保留，不重演或补跑。

既有 testExternalRuntime 缺失未修；继承证据只覆盖真实 Fabric client/data/clientData。未运行根 test、MC 重构建、版本/配置缓存矩阵、G2/G3；I03 其余八个旧方法未重跑，I04 未重跑 I03 成功套件。buildSrc、安装、发布、提交、推送均未执行。公开 variant 无稳定 ID 时仍保守明确失败，build 下报告/归档/Jar 可能随清理消失；当前完成不代表全项目/全版本验收。

本次仅完整读取三份 Result 与现有报告、局部核对历史/当前 XML 和证据可读性，并回读四文档事实/相对链接；未独立重审实现或重跑验证。

## 恢复前历史结果与证据

原恢复准备阶段曾完整读取并采用四份原始结果：Spec 混合版本闭合及作者自检、Codev I01 generation 1、Cloche I02 generation 1、共同根能力冲突恢复分析。采用其内容而非包装层状态；不在仓库保存这些外部文件或指向它们的间接索引。它们形成以下可复核事实：

| 采用事实 | 仓库现有证据 | 适用范围/限制 |
| --- | --- | --- |
| I01 completed，14 tests、0 failures/errors/skipped，真实 Java smoke 通过 | [I01 归档报告](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/identity-evidence.md)、[归档 XML](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml) | 原单图 exact identity/duplicate/projection/default/version/failure 的结果；归档 XML 仍为 14/0/0/0。该历史运行不是跨图聚合或新 task API 的证据。 |
| I02 partial，5 tests、1 failure、0 errors/skipped | [I02 归档报告](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/identity-evidence.md)、[归档 XML](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/xml/TEST-earth.terrarium.cloche.IncludeTargetIdentityTests.xml) | single target+ordinary、属性不兼容、missing base、Fabric 四项通过；必需 A/B 失败。归档 XML 仍为 5/1/0/0；本次不改写旧运行。 |
| A/B 在同一真实 producer，旧 includeFiles 因共同根 capability 冲突，在提取/JarJar 前失败 | I02 报告中的失败输出与现有 [fixture](../../../../cloche/src/test/resources/include-identity/build.gradle.kts) | 该历史运行没有 A/B 元数据或最终 payload 成功证据；后续 I04 另有同 Jar 新证据。能力只是路由身份，不能靠删共同根或改属性绕过。 |
| 后续版本合同已关闭：all-source identity，ordinary 实际最后 selector 版本优先 | 当前 Spec 的 Versions / focused acceptance 与 Existing evidence | 该准备时点只决定版本选择，尚未运行；后续 I03/I04 已提供上列新证据。旧恢复分析的 A/B 候选中仅 B 被选择；A 非待实施方案。 |

保留原 task/generation：I01 `implement-codev-explicit-include-identity` / 1；I02 `implement-cloche-include-target-identity` / 1。I02 内层 partial 不因工具包装完成或后续新结果而转为 completed；旧 `{I01,I02}` 阶段 `ITI-W01-G` 未满足。原 Work 的“尚未实施”、旧 not-ready 和当时待独立复核口径均为历史，后续路径闭合/确认/实施/Router 最终判断见当前记录，不以旧 14/0 替代新边界证据。

原 I01/I02 报告和 XML/log 已在各自原 reports/test/history/ITI-I01-generation1 与 history/ITI-I02-generation1 保留，当前报告分别对应 I03/I04。归档报告内部旧路径仍是当时快照，本页的归档入口是现有位置；clean 仍可能删除全部 build 证据。本次不生成证据文件，不改写历史。

## 原准备时只读核实的恢复接点（历史快照）

下表及紧邻 javap 说明保留 I03/I04 实施前的结构与选定理由，不是当前源码现状；当前已交付的来源分流、共享 API、继承和任务接线见上文及两份现有报告。

| 位置 | 原准备时观察的结构 | 恢复采用理由 |
| --- | --- | --- |
| [ClocheDependencyHandler](../../../../cloche/src/main/kotlin/earth/terrarium/cloche/api/target/compilation/ClocheDependencyHandler.kt) | 现有 include: DependencyCollector；重载通过 producer.project 创建完整 base capability 的 Provider 请求并 include.add；没有来源 registry | 必须在写入时保存 provenance。仅从 collector Set 按 equals/类型/capability 移除会误删普通 equal 请求；选定 ordinary/generated 两个 backing collector，公开委托视图惰性并集，普通写方法只执行一次。 |
| [MinecraftTargetInternal](../../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/MinecraftTargetInternal.kt) | addCollectedDependencies 惰性 addAllLater(dependencies / dependencyConstraints)；现有 producer project 连接与 late fallback | 普通 bucket 改读 ordinary backing，而不是扫描混合 Set。生成记录的同一惰性快照提供 observer/group/full capability，保留 I02 两处 late fallback。 |
| [TargetCompilation](../../../../cloche/src/main/kotlin/earth/terrarium/cloche/target/compilation/TargetCompilation.kt) | ordinary bucket 包含整个公开 collector，includeFiles extendsFrom bucket；真实属性/attributeProvider 和 non-transitive；实际 includeJarTask 仅 fromResolutionResults(includeFiles) | 是生产分流和任务接线 owner。target 真实配置不继承 ordinary bucket，只带所需 constraints；复用同一实际属性配置函数，用一次共享多源 API 进入同一实际任务。 |
| [Linkage](../../../../cloche/src/main/kotlin/earth/terrarium/cloche/Linkage.kt) | extendFromDependency 使 include bucket 继承 dependency.includeBucketConfiguration | 新发现的必要 Cloche 写面。ordinary-only bucket 继承保留，并传递原 target 记录，在接收 compilation 用自身属性建图。否则隔离请求会在继承时丢失或回流。 |
| [IncludedJarInfo](../../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt) | 单个 root/artifact Set；图内 DFS append selectors；exact lookup + 唯一 artifact projection；已使用公共 CapabilitySelector 与 DependencyFactory 完整请求探针的等值筛选；SpecificCapabilitySelector 实现仅是源码证据，不是公共类型依赖 | I01 必要 helper 已存在，应在其上扩展。跨图还需保留 graph/source/selector/完整 attribute 值和 artifact 关联；最终 IncludedJarInfo 已失去这些证据。 |
| [IncludesJar](../../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt) | 只有单配置 API；每次 addAll 一个 Provider 计算出的最终 IncludedJarInfo | 多次调用无法满足 mixed-source identity/version/dedup；新增一次多源 API 与 Buildable 任务依赖，兼容旧签名。Codev 必须进入恢复披露写面。 |
| [Forge JarJar](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt)、[Fabric JarInJar](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt) | 都读取共享 IncludedJarInfo | 恢复共用聚合结果，不在 loader 各写一套身份逻辑；原 metadata 结构/普通库派生保留。 |
| [Cloche fixture](../../../../cloche/src/test/resources/include-identity/build.gradle.kts)、[外层测试](../../../../cloche/src/test/kotlin/earth/terrarium/cloche/IncludeTargetIdentityTests.kt) | 原 root targetJarJar 是单独注册并自己接单图；producer runtimeElements 仅用普通 Jar 替代昂贵 artifact；外/内层本地 includes 来源已有断言 | 重用真实 target/输出替换方式，但必须请求生产 :consumer:includeJar。fixture 不得自行分图/连接聚合或手工带 producer；只替换真实任务的 outer input/manifest 等昂贵来源。 |

本地缓存 Gradle 9.4.0 的 `javap` 只读核实了 DependencyCollector 的 add/action/bundle/constraint 与 dependencies Provider API、ObjectFactory.newInstance、ResolvedVariantResult 的 owner/capabilities/attributes/displayName、ProjectComponentIdentifier 的 build/project 身份以及 Configuration 的继承/依赖/Buildable 接口。这只是接口可用性的静态依据，不是编译或生命周期验证；未调用 Gradle。新 public source DTO 不依赖 Gradle internal 类型。

## 已选恢复设计的语义边界

- 来源来自写入入口：普通 collector 不被 target 重载污染，公开 collector 仍能按需看完整生成请求；相等/包装不改变来源。原 target 对象登记与按需 `(build/project, 原名, group:name)` 证明共同约束归组，不按 normalized suffix/项目路径/最终坐标折叠。
- 分图只针对重载，普通请求保留原图、constraints 和失败/冲突语义。target 使用 receiving compilation 的真实属性与 Provider timing、不传递、requireCapability/共同根能力；普通和继承 bucket 不能再带入 generated A/B。
- Codev 共享 source API 先关联真实 graph variant、artifact、全部 selectors/来源，再产生 IncludedJarInfo。图内保留 exact/projection，跨图比较完整 graph attribute 集；owner/完整能力集/variant 消歧/artifact 联合核实，不能仅按引用/路径/文件名/身份坐标去重。先在 variant 层汇总 requests，后在其内去重 artifact；同 variant 的不同 artifact/部分来源缺少 artifact 不能丢失 ordinary provenance 或身份请求。不同原 target 不能归并；不能唯一证明实际同一 variant 则诊断失败，不以最后结果覆盖。正常 target+ordinary 同一真实 variant 的成功仍需真实 Gradle 样本。
- 身份来自所有 complete requests；exact identity 去重/唯一选择优先，nonmatch/跨图多身份失败，feature-only/default 保留。关联后，同 variant/artifact 只嵌一次，不同 artifact/真实 target 保留。
- 版本取 ordinary 图该 variant 的实际 DFS 最后 selector，非“最后 module”或全局 DSL 次序；按 Spec 保留 capability→component→有效 module selector→0.0.0 与 strict→required→preferred→default 链。最后 project 不复活旧 module；无 ordinary 则 target 默认。优先版本不丢弃任何来源的身份信息。
- 实际 Cloche includeJarTask 一次消费共享聚合，依赖 Configuration/Buildable，不在配置时读取裸文件或在 action 才发现 producer。Codev API 可先独立被真实 Java fixture 消费，Cloche 完整生产交付再消费该 API；这正是两个新有界结果的接口边界，而非按仓库/文件数量机械分割。

API 形状、配置登记时点、继承接线、joint variant/artifact 关联和版本步骤已在 Plan 选择；本页不复制接口规范或执行图。必要代码/测试/helper 与常规编译随所属行为，不再生成辅助 item/gate。

## 已执行入口、本地来源与环境

Codev 使用现有叶级 `:minecraft-codev-includes:test --tests ...`，Cloche 使用 `:includeIdentityTest --tests ...`；完整实际命令、过滤方法和输出见各自 [I03 报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)与 [I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)，本次不再执行。原 I01 实际命令是叶级 `test`，原准备作者写成 `includeIdentityTest` 是历史误述，不是 I01 旧运行错误。

两项均从 `E:/Projects/cloche` 启动。I03 显式选用用户 Home 缓存的 Gradle 9.4.0，可执行文件位于 `D:/Applications/Scoop/apps/gradle/current/.gradle/wrapper/dists/gradle-9.4.0-bin/lcvyxq3t37f6mx9miaydrrgs/gradle-9.4.0/bin/gradle.bat`；daemon/fixture 为 Temurin 21.0.10，JUnit 为既有 Adoptium 17.0.15，最终没有覆盖 toolchain paths。I04 用 Cloche 9.4.0 wrapper，daemon/Test Executor/fixture 均为既有 Microsoft JDK 17.0.19。原准备对 current junction 9.5.1、Home junction 及 executable 的只读核实不等于运行版本；8.11 是早期文字，不能冒称当前 wrapper。

用户 Home/TestKit Home 沿用 `D:/Applications/Scoop/apps/gradle/current/.gradle`，真实目标 `D:/Applications/Scoop/persist/gradle/.gradle`；未切换/复制/清空 Home、改代理/用户环境/原 toolchain 配置或停止无关进程。I03/I04 实测工具链不同，原 Plan 的 daemon21/17 模板不是统一实际组合。

I04 实际参数为 `-p cloche -I 'E:/Projects/cloche/cloche/src/test/include-identity.init.gradle' '-PincludeIdentityCodevRoot=../minecraft-codev'`，绝对脚本避免原相对路径基准错误；属性仍由 [现有脚本](../../../../cloche/src/test/include-identity.init.gradle)以 Cloche settingsDir 解释。三项 substitution 为 includes→`:minecraft-codev-includes`、core→`:minecraft-codev-core`、side-annotations→`:minecraft-codev-core:side-annotations`。`build.gradle.kts` 属性分支只负责 plugin metadata，外层编译替换已由实际 composite 运行证据证明。

[compile-classpath.txt](../../../../cloche/build/reports/test/include-identity/compile-classpath.txt)记录 includes/core 的本地 project 编译输出与三者 runtime Jar；side-annotations 是 core implementation，由本地编译任务提供。[outer-sources.txt](../../../../cloche/build/reports/test/include-identity/outer-sources.txt)及各 fixture 日志分别验证旧入口、新 DTO/API、core、annotation 的外/内层本地来源及 class resource 恰好 1 个。不是仅凭脚本或 metadata 存在性宣称通过。

## 原恢复准备作者语义自检（历史记录）

| 检查 | 已完成的作者核对 | 仍不可据此声称 |
| --- | --- | --- |
| 权威覆盖 | 当前 ADR/Spec 已接受；PRD skip；原 A/B、collector/late/属性/非传递/失败/任务依赖、真实聚合、ordinary 优先版本均有策略与验收责任，版本缺口不再留待实施选定。 | 不表示生产机制实现、PRD/ADR/Spec 被本轮修改或需要本轮再次决策。 |
| 单结果主动测试 | 共享多源 API 可被既有普通调用者/真实 Java fixture 独立消费；Cloche 的集成终态真实消费它。API、collector/继承/任务接线及其必要编译/fixture 不再按文件拆成多结果项。每个新项只对应一个未来 Handler/Result。 | 不表示已创建 Handler、执行项目或以文档准备完成冒充 item completed。 |
| 充分证据 | 完整采用四份原 Result；只读核对仓库两个 XML 的 14/0 与 5/1，保持报告/四通过/A/B failure。受影响旧方法、新 source/mixed 及生产任务证据分别安排，未无条件重做原 14 项。 | 旧结果不验证新 API；fixture-only 图不验证生产路由；无新通过结果。 |
| 实际依赖/冲突 | 共享 API 是后续 Cloche 的真实编译/运行输入；Linkage 是已核实的额外写面。唯一 Waves 列出 Home、本地 includes 输出与相关源/报告串行要求，无已知并行写者。 | 不表示未来无需重新核实写者/Home/工具链。 |
| 可验证 gate/历史连续性 | 保留 I01 completed、I02 partial 的 task/generation、旧 gate 未满足；当前成员及全部原成功条件/新合同逐项列在唯一图中，原 A/B 未履行义务由新的交付证据满足。 | 不把 I02 partial 改 completed，不以移出调度豁免原义务，不释放 gate。 |
| 联合等待 | item 前向消费共享 API；Wave 无前置 gate；gate 只消费当前成员合格结果。旧 partial 是历史而非新项 prerequisite，不产生 item/Wave/gate 自等或环；独立复核/范围确认是外部前置，不伪装新测试门槛。 | 不代替独立 readiness review、实际范围披露与用户确认。 |

以下是原恢复准备结束时的历史自检，不能作为当前未完成状态：

原恢复准备的最小静态验证记录：四文档共 47 个本地 Markdown 引用均存在，外部原始 Result 路径泄漏为 0；核对四个 item 标题、当前 W01 成员和 unmet gate，并对与当前表逐条对应的等待边做拓扑检查，无环。作者重读还修正了 variant 级 request 汇总不能被 artifact 列表差异拆散的表达，并明确了真实混合正/负例的 capability/feature 选取，避免把普通图更早失败当成跨图 ambiguity 证据。本轮所有写操作只针对四份指定文档；只读 Git diff/stat 所列生产改动是此前已存在的脏工作区，未实施新机制。没有运行构建测试、MC 重型图、根 test、G2/G3、发布安装或 Git 写入。未解决的实际限制是恢复运行/生命周期/最终 Jar 尚无新证据、受影响修正仍待独立定点复核和实际范围确认、既有报告可能随 build 清理；这些不阻止完成“仅准备与作者自检”的本轮目标，也不能被省略为 ready。

## 准备纠错、复核与后续采用的历史顺序

1. 原恢复准备只写四文档并作作者自检；当时 I01 completed、I02 partial、I03/I04 pending、gate unmet。原静态记录为 47 个本地引用存在、无外部 Result 路径、等待图无环；这些不证明恢复运行成功。
2. 首次独立 readiness review 已 completed，但恢复安排 not-ready：缺本地替换脚本入口且环境事实有误。随后 C5 修正四文档入口/模块名/环境及邻近历史称谓，保持算法、required checks、gate 条件、成员与依赖不变；该次局部回读记录 54 个本地引用存在，但声称“Plan/Waves 路径基准一致”的作者自检错误，不能追记成当时已通过。
3. `review-include-recovery-command-correction` / generation 1 复核 completed，但恢复安排仍 not-ready；P2 等已闭合，唯一 P1 是 `-I` 相对路径及基准说明。`fix-include-init-script-absolute-path` / generation 1 先只修 Plan/Context，为绝对 `-I "E:/Projects/cloche/cloche/src/test/include-identity.init.gradle"`，当时未改 Work/Waves；其作者静态回读不代替独立复核或运行。随后 `align-include-waves-init-path` / generation 1 经 C5 授权同步 Waves/Context，仍不改变图或实施状态。保留启动目录 `E:/Projects/cloche`、`-p cloche`、属性 `../minecraft-codev` 和 settingsDir 解释。
4. 本次完整关联的 `review-include-absolute-init-path` / generation 1 独立复核已确认剩余 P1 闭合，未变范围的既有复核可沿用；读取了绝对脚本、参数基准、三项本地替换与四文档 12 条同目录互链，当时 I03/I04 仍 pending、gate unmet。其 completed/准备就绪不构成实施确认、item 完成或最终 gate。
5. 用户之后在完整披露 I03/I04 范围后明确“实施并验证”；两份独立 generation 1 completed 结果及其限制由 Router 完整读取关联，形成上列当前采用事实。Router 随后逐项作出原 gate 满足判断，本次文档收尾仅忠实投影，不重开 I02 或抹掉准备 not-ready/失败尝试。

本次局部回读结果：四文档 102 个本地 Markdown 引用对应 39 个仓库文件，均存在且可读，无外部 Result 定位；task/generation、I03 9/0、I04 三批原 XML/逐方法最新通过及 I01/I02 归档入口相符。与修改前逐字比较，Waves 原 completion predicates、owner/write surface、required checks、九项 gate 条件、成员及冲突不变，依赖链仍为 I01→I03→I04；Plan 原汇集算法/惰性任务依赖与 Codev/Cloche 受影响验证要求不变。不新增独立审查、构建、测试或证据系统，不将外部 Result 定位写入文档，执行命令中的环境绝对路径不作为 Result 索引。
