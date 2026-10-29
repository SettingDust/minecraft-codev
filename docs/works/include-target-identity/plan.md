# Include target identity Plan

[Work](./work.md) · [Context](./context.md) · [唯一执行图 Waves](./waves.md)

## 状态、权威与范围

这是**已确认范围的交付记录与原实施安排**。准备路径问题已经独立定点复核闭合，用户经完整范围披露后明确选择“实施并验证”；I03/I04 各自 generation 1 已交付 completed Result，Router 已判断 `ITI-W01` 完成、`ITI-W01-G` 满足。下文保留原选定策略、完成条件与验证要求，实际结果另列，不新增或执行工作。唯一 item、状态、依赖、冲突和 gate 图仍在 Waves，本 Plan 只拥有策略、写面、风险和验证安排。

权威为 [include-identity Spec](../../spec/include-identity.md) 与已接受的 [include-target-resolution ADR](../../adr/include-target-resolution.md)；PRD skip，原产品目标不变。早期“复用单图、Codev 无需再变”的策略只解释历史，现由以下局部恢复策略取代。原 I01 completed（归档 14/0）、I02 partial（归档 5/1、四通过与 A/B 失败）及原阶段 gate 未满足保留为历史；新成功不追改旧 Handler/Result。已关闭的混合版本决策缺口不再作为实施者的待选问题。

最终确认范围仍是同一 producer 的 A/B 经实际 Cloche includeJarTask 交付，以及普通 include/Fabric 兼容。Codev 共享 API、Cloche collector/继承/实际任务接线及受影响检查已一并披露、确认并完成，未纳入 buildSrc、发布或提交。本次 C5 仅将 Router 已采用结果和最终 gate 判断投影至四份协调文档；不改权威、源码、测试、配置、依赖、锁文件、报告或 Home，不跑构建测试/Git 写入。

## 恢复结构与 owner

### Cloche：在进入普通 bucket 前区分来源

1. 保留 `ClocheDependencyHandler.include: DependencyCollector` 及 `include(target: MinecraftTarget): Unit` 的公开形状，保留普通 string/Dependency/Provider、配置 action、bundle 和 constraints。内部建立由 Gradle 管理的 ordinary collector 与 generated-target collector；公开 include 是委托 ordinary 写方法的 collector 视图，仅把 `dependencies` 的 Provider 改为两者集合的惰性并集，constraints 仍委托 ordinary。target 重载只向 generated collector 与 target 记录登记，不经普通 add 入口。普通 add/action 只执行一次，不能为镜像观察重复执行 action。由现有 `ObjectFactory.newInstance` 管理含 abstract collector 属性的内部 holder，其他 dependency collector 不变。
2. 普通 bucket 从内部 ordinary collector 读取 dependencies/constraints，不对公开集合做 `equals`、类型、路径或 capability 过滤。因此即使普通 ProjectDependency 与生成请求相等、相同 capability 或有 Provider 包装，普通来源仍在原图；公开 Set 即使去重仍有生成的完整 producer 请求，不承诺每次调用一条。绝不先混入普通 bucket 再试图移除。
3. target 记录以**原 producer-owned target 对象**登记；同对象重复调用复用其记录，不以 normalized suffix/项目路径/坐标合并不同对象。记录保留 owning project/build、原始 target.name（含 `:`）与懒生成的完整 base `group:name`。在首次按需读取时用同一请求快照派生 generated 依赖、完整 capability 与源描述，避免多个 Provider 各自产生不一致身份；不在重载调用时读取 group/version、解析或访问文件。快照按 producer 现有 late 规则取得坐标，不新增 outgoing capability。按需报告完整 `(build identity, project path, original target name, group:name)`；不同原 target 即使规范化碰撞仍不同组。
4. 接收 compilation 为每个原 target 记录注册一个真实 resolvable configuration；名采用接收 compilation 既有前缀加内部 `includeTarget<N>Files` 序号，不用懒坐标或文件名命名。登记记录时安排配置，不在 Provider 求值或 task action 中临时创建图；其 dependency 仍由原 target 的 owning project API 惰性创建并 `requireCapability(fullBaseIdentity)`。重复记录在同一接收 compilation 只产生一图；group identity 按快照验证后向共享 API 提供，不能因坐标相同折叠不同 target。
5. 把 `TargetCompilation` 当前 includeFiles 属性配置提成同一个内部配置函数，同时应用 ordinary/target 图：保留 target.attributes 的 platform/loader、Minecraft 及其兼容属性，distribution、legacy side 的 attributeProvider 和 data 实值，以及 Library/JAVA_RUNTIME/JAR、`isTransitive=false`。禁止仅复制 attribute key 或提前快照 Provider、强制属性匹配、lenient 或增加 include-only variant。target 图**不 extendsFrom ordinary include bucket 或其他 target 图**；只惰性复制接收 ordinary bucket 的 `allDependencyConstraints`，保留 constraints 而不带入 ordinary dependencies/A/B。普通 includeFiles 仍继承原 bucket，原普通冲突/失败语义不变；共同根 capability 不删。
6. [Linkage.kt](../../../../cloche/src/main/kotlin/earth/terrarium/cloche/Linkage.kt) 的 `extendFromDependency` 当前继承 include bucket，属于必须披露的真实接点。保留 ordinary-only bucket 的 extendsFrom，同时沿同一既有依赖关系传递 target 记录；每个接收 compilation 使用自己的属性建立图，不继承上游已解析结果/配置属性。多路继承和重复本地请求按同一原 target 记录归组，使用登记回调传播；继承记录不伪装成本地普通 add，也不回灌 ordinary bucket。保持原依赖方向，记录去重防止重复传播；不新增一套 dependency DSL。

这解决 collector 的集合相等陷阱，也覆盖继承 bucket 的回流路径。不能仅在 fixture 分图、保留旧普通图中的 A/B 再加旁路图，或对同一失败图使用 ArtifactView。

### Codev：一次汇集后作身份及版本提取

新增共享边界放在 `minecraft-codev-includes`，由 Codev owner 实现和维护，不在 Cloche 复制提取算法。本安排选定以下 API 形状及职责，现已由 I03 交付并由 I04 消费：

- `IncludeTargetOrigin`：纯来源值，含 producer build identity、project path、原 target name、完整 base group/name；不引用 Cloche 类型，不解析 requested identity，不新增用户身份 DSL。build identity 由 producer build-root 身份和 project path 区分，不能只取 projectName。
- `IncludeTargetSource`：`origin` 与已登记的 `Configuration`；交付对象本身不解析配置。Cloche 以 Provider 列表交付其所有 target 图。
- `ResolvedIncludeSource`：一次图的 `rootComponent`、`Set<ResolvedArtifactResult>` 与 nullable target origin（null 唯一代表 ordinary）；包含图/原始 request/顺序证据，不能以 `IncludedJarInfo` 替代。
- `IncludedJarInfo.fromResolutionSources(objects, sources, logger): List<IncludedJarInfo>`：接收以上 resolved sources；至多一个 ordinary source，所有 target sources 保留来源。现有单图 `fromResolutionResults(objects, root, artifacts, logger)` 保持签名，委托一个 ordinary source，保留现有调用者语义。
- `IncludesJar.fromResolutionSources(ordinary: Provider<out Configuration>, targets: Provider<out List<IncludeTargetSource>>)`：唯一聚合调用。惰性取得 root/artifacts 后一次调用共享提取，再对 includedJarInfo 执行**一次** addAll。保留现有单图方法的签名与调用行为；其单图路径委托同一内部实现。调用者只能选择单图方法或一次聚合方法，不把多次单图 addAll 当成汇集。

上述纯来源类型只承载本次所需 Gradle 证据，不引入策略扩展点。静态入口没有 Gradle 内部 selector API 依赖；保留 I01 使用公共 CapabilitySelector 与 DependencyFactory 构造完整请求探针、按 selector 等值筛选的实现；SpecificCapabilitySelector 实现仅为源码证据，不是使用的公共类型，不倒退为版本相关 internal 转型。

汇集算法在产生任何最终 IncludedJarInfo 前完成：

1. 每图沿现有 depth-first 顺序遍历：root.dependencies 逐边 append requested selector，再递归 `selected.getDependenciesForVariant(resolvedVariant)`；保留其 graph variant、所属图/来源、selector 列表及最后一个 selector。仍传播 UnresolvedDependencyResult.failure，不跳过失败。
2. 图内先用现有 exact variant lookup；否则使用唯一 artifact projection：相同 component owner（项目包括 build/project 身份）、完整 `(group,name,version)` capability 集，且每个 graph attribute 的实际值与 artifact 值相等。extra artifactType 可接受；多候选或显式请求无法关联必须诊断失败。请求身份仍只从原 request 提取。
3. 跨图先建立 **variant 层**关联：用 owner、完整 capability 集、**完整 graph attribute key/value 集**及不解析的 graph variant 名称联合核对，保留每张图原 variant/候选清单；artifact 的唯一 projection 和 component 只作佐证。variant 名称只作额外消歧证据，绝不解析它来推断身份，也不是独立 dedup key；对象引用相等不能代替这些核对。两张 graph 的属性不能互作 projection 子集比较。一个候选组中不同非空原 target origin 不合并；ordinary 记录只有能唯一关联到同一真实 graph variant 才并入，若候选属于不同 target 或无法消歧则诊断失败，不按顺序挑一个。相同字段不足以证明实际同一 variant，存在第二个真实 variant 时不得压平。不同真实 target/variant 即使文件或选定坐标相同仍独立。**相同 variant 不必有完全相同的 artifact 列表**：某图少 artifact 或不同 classifier 不得使其 requests/ordinary provenance 丢失，也不得以文件差异拆散本应汇总的 selectors。
4. 每个唯一关联 variant 先汇总全部 selectors/显式完整 capability requests，按 exact `(group,name)` 去重再选择身份：一个 exact match 优先，零匹配/不同 group/多个不同身份按 Spec 失败；feature-only 不补造完整坐标。所有关联图对该 variant 的 requests 都影响其每个 artifact，包括某来源只有 requests 而无对应 artifact 的情况。然后在该 variant 内按 resolved artifact identifier（含 component）+ 唯一关联的 artifact 投影 + 文件去重；同 variant 多个真实 artifact 保留。文件名、路径、坐标或最后一条记录均不是单独 dedup 依据。不得先各图降成 IncludedJarInfo。
5. 身份选定后选版本 selector：有 ordinary 来源就取**该普通图对该 variant 的实际最后 selector**；不查 DSL 全局调用序、不取最后一个 module selector、不取“含约束最多”者。无 ordinary 来源时保持 target project selector 的默认规则。artifactVersion 仍为 selected capability.version → module component.version → 有效 module selector.version → `0.0.0`；versionRange 为有效 module selector 的非空 strict → required → preferred，否则 `[$version,)`。ordinary 最后是 project 时不复活更早 module range；ordinary priority 不改变全部来源参与的身份判定，也不替换为普通默认身份。不合并/交叉版本约束或新增 conflict policy。

公开 Gradle graph variant 没有独立稳定 ID，因此保守唯一关联是明确的失败边界：若 owner/capabilities/全属性/variant 名称/artifact 及来源仍不能唯一证明同一真实 variant，报含来源/候选/请求的关联诊断，不以相似字段成功合并。对同一真实 variant 的正常 target+ordinary 混合必须有真实 Gradle 样本证明成功，不能用此失败边界拒绝混合本身。

### 实际任务及惰性依赖

Cloche 的实际 `TargetCompilation.includeJarTask` 替换原单图调用为一次共享多源调用，ordinary 和所有 target 图都进入该任务。Codev 的 task API 同时显式依赖 ordinary Configuration 和 `targets.map { sources -> sources.map { it.configuration } }` 所携带的 Configuration/Buildable 任务依赖；保留任务文件输入来自 IncludedJarInfo 的现有路径。禁止在配置阶段读 `.files`/裸路径取代 Configuration/Buildable，也不能只在 action 中发现 producer task。

Forge JarJar 与 Fabric JarInJar 继续消费同一 IncludedJarInfo，不重写各 loader 的身份选择；JarJar `jars` 数组/嵌套 path 与 Fabric 生成/既有 metadata 规则不变。Codev 的旧单图公开调用者可独立消费兼容入口，Cloche 消费新聚合入口。

## 必要写面与独立消费边界

| owner | 原确认的必要写面 | 可独立消费的结果与影响 |
| --- | --- | --- |
| Codev includes | IncludedJarInfo.kt、IncludesJar.kt；同包必要来源 DTO；既有 IncludedJarInfoIdentityTests 与 include-identity Java fixture | 兼容单图的真实多源汇集/任务 API；已有普通单图调用者不必改动，Cloche 可消费。I01 仍 completed，但其 API/algorithm 实现受影响，新增边界及受影响旧行为必须定点验证。 |
| Cloche | ClocheDependencyHandler.kt 内部 holder/来源记录；TargetCompilation.kt；Linkage.kt；必要局部 internal helper；既有 IncludeTargetIdentityTests/fixture | 生产分流、继承、共享 API 接线及实际任务的完整 A/B+兼容终态，依赖上行已交付 API；测试和普通编译随这个行为结果，不另造 fixture/compile item。 |
| Cloche 本地集成 | 现有 src/test/include-identity.init.gradle 显式 composite substitution 入口；build.gradle.kts 的属性控制 pluginUnderTestMetadata；fixture settings/build | 复用原本地 includes/core/side-annotations 与外层/内层来源断言；按新增 API 类型扩充 code-source/duplicate-class 检查即可。版本 0.6.5 不升级、不发布，不新建别的入口/框架。 |

不预设必须改 Forge/Fabric 生产类或 core/side-annotations；其现有 IncludedJarInfo 消费无需新签名。若实现发现超出以上 owner/行为的必要改动，应明确报告而非藏进 helper。两处 capability fallback 的 I02 实际完成代码保留，不因恢复而撤销 late 支持。

## 本地集成与精确入口修正

保留 `includeIdentityCodevRoot` 并显式加载现有 [init script](../../../../cloche/src/test/include-identity.init.gradle)：脚本只在 cloche 根 settings 且提供该属性时 includeBuild，将 `net.msrandom:minecraft-codev-includes` → `:minecraft-codev-includes`、`net.msrandom:minecraft-codev-core` → `:minecraft-codev-core`、`net.msrandom:side-annotations` → `:minecraft-codev-core:side-annotations` 替入外层编译/运行。`build.gradle.kts` 的该属性分支只调整 pluginUnderTestMetadata 的本地 classes/resources 条目及 builtBy，不能代替编译依赖的 composite substitution。默认依赖声明及发布解析不变。外层 TestKit/pluginUnderTestMetadata 和内层 fixture 两层均拒绝旧 includes JAR 与新实现并存，并验证 IncludedJarInfo、IncludesJar 及新增聚合 API 的 codeSource 位于本地 includes/build。不通过只打印一个自定义标记来代替来源检查。

**历史命令与现有入口**：I01 原报告记录从 Codev 根执行 `./gradlew.bat :minecraft-codev-includes:test --tests net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests --stacktrace --max-workers=1`，不是 `:minecraft-codev-includes:includeIdentityTest`；原准备作者的相反归述是历史误述。原 [I01 报告与 14/0 XML](../../../minecraft-codev-includes/build/reports/test/history/ITI-I01-generation1/identity-evidence.md)及 [I02 报告与 5/1 XML](../../../../cloche/build/reports/test/include-identity/history/ITI-I02-generation1/identity-evidence.md)均已在各自 reports/test/history 下保留，旧 Result 不追改。

**实际运行入口与环境**：两项均从 `E:/Projects/cloche` 启动，沿用用户 `D:/Applications/Scoop/apps/gradle/current/.gradle`（Home junction 的实际目标 `D:/Applications/Scoop/persist/gradle/.gradle`），未切换、复制或清空 Home，未改代理或用户 toolchain 配置。wrapper 为 Gradle 9.4.0；准备时 current junction 指向 9.5.1 只是历史存在性观察，不是本次执行版本。

- I03 实际选用缓存 `D:/Applications/Scoop/apps/gradle/current/.gradle/wrapper/dists/gradle-9.4.0-bin/lcvyxq3t37f6mx9miaydrrgs/gradle-9.4.0/bin/gradle.bat`，入口 `-p minecraft-codev :minecraft-codev-includes:test`，重复 `--tests` 精选六旧三新，附 `--no-daemon --max-workers=1 --no-configuration-cache --gradle-user-home` 及实际 JVM 参数。daemon/fixture 为 Temurin 21.0.10，JUnit 为既有 Adoptium 17.0.15；最终没有覆盖 `org.gradle.java.installations.paths`。完整最终命令和过滤方法见 [I03 实际报告](../../../minecraft-codev-includes/build/reports/test/identity-evidence.md)，不是准备模板的 JDK 假设。
- I04 实际使用 `./cloche/gradlew -p cloche -I 'E:/Projects/cloche/cloche/src/test/include-identity.init.gradle' '-PincludeIdentityCodevRoot=../minecraft-codev' :includeIdentityTest`，按报告三批重复 `--tests`，附 `--stacktrace --max-workers=1 --no-configuration-cache`。daemon、Test Executor、fixture 均为既有 Microsoft JDK 17.0.19；完整原样命令见 [I04 实际报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)。init 为已独立复核的绝对路径；属性仍由 Cloche settingsDir 解释而指向同级 Codev。整个 `-P...` 参数作为一个字符串传递。

此前将 `-I` 基准误说成启动目录而非应用 `-p` 后的 currentDir、以及“路径基准一致”的作者自检错误，均保留为历史；最终绝对路径独立复核已闭合阻断。原准备命令的 daemon21/JDK17 组合只是当时选项，不能替代上述实测结果；不完整 paths 覆盖的失败和后续修正见 I03 原报告。

外层编译已实际替换 includes/core/side-annotations：I04 [compile-classpath.txt](../../../../cloche/build/reports/test/include-identity/compile-classpath.txt)记录本地项目编译输出及 runtime Jar，[outer-sources.txt](../../../../cloche/build/reports/test/include-identity/outer-sources.txt)和 fixture 日志记录旧入口、新 DTO/API、core/annotation 的本地来源及每类唯一资源。此证据超出 metadata 分支的静态存在性。

原要求只按受影响方法过滤、不无条件重做旧 14 项，不新增 alias/辅助编译门槛；必要编译、metadata 和 fixture 随实际定点检查执行。报告仍在原两处 reports/test，历史与当前运行明确区分；本次不修改报告/XML/Jar，build 清理可能删除证据的限制不变。

## 原确认的受影响验证与证据安排

### Codev 汇集 API

在原测试类中补充三个聚焦检查：跨图真实 variant/artifact 关联与先汇总后去重；ordinary-source 有效最后 selector 的混合版本；真实 Java fixture 经新 IncludesJar task API 消费多图并自动携带 producer 任务依赖。静态假对象仅补精确边界，不能作为真实图/API 的全部证明。复用现有 Java fixture 和 TestKit，在其同一 owning producer 中建立真实可区分 variant/共同 capability，明确这里只证明共享 API，不冒充 Cloche target 分流证据。

以下旧方法被本次共享管线直接触及，按方法过滤复核：`artifactVariantProjectionPreservesAttributesAndSeparatesSameProjectVariants`、`duplicateAndDownstreamRequestsSurviveLaterDefaultRequestsAndCapabilityOrder`、`lastSelectorStillDeterminesVersionRangeStrictThenRequiredThenPreferredThenDefault`、`artifactVersionFallbackIsCapabilityThenComponentThenSelectorThenZero`、`unresolvedFailurePropagatesUnchangedIncludingDownstream`、`realJavaProjectRequestUsesPublicExtractionAndLocalImplementation`。新增检查还覆盖同名不同 group、不匹配/跨图多完整身份失败、feature-only/no-complete fallback、capability/request 顺序交换、project-only 重复、同 variant 不同 artifact、不完全 graph 属性不可误合并及不同原 target 不可折叠；未触及的旧校验复用历史通过，不要求重跑整 14 项。

混合版本检查在同一来源聚合路径覆盖 ordinary module 的 strict/required/preferred、capability/component/selector/zero fallback、ordinary 有效最后 project 覆盖更早 module、无 ordinary 的 target 默认值，身份均来自全体来源。真实 Gradle 样本以 ordinary module selector 经标准 module→producer project substitution，与 target 请求到达同一真实 variant/artifact；ordinary module 显式 require 同一个 base capability，保留其 module/rich-version selector，避免 producer A/B 的普通默认 capability 选择歧义。观察 source tags、普通图实际最后 selector、唯一显式身份和单次产物；strict/required/preferred 使用包含 producer 实际版本的约束。另用已有单 target 的 ordinary 默认请求验证无完整 ordinary 身份仍参与混合，局部假对象补实际 producer 有 version 时无法自然到达的 fallback 空值边界，不新建版本矩阵。

### Cloche 生产分流与同一实际嵌入任务

复用 `IncludeTargetIdentityTests` 和现有多项目 fixture，A/B 仍来自同一个真实 :producer，consumer 独立，真实 Cloche runtimeElements 和共同根 capability 不变。保留用普通 Jar 替换昂贵 producer artifact 的方法；修改 fixture 为请求 `:consumer:includeJar`，即 `TargetCompilation` 生产登记的任务。只替换这个实际任务的昂贵 outer input/manifest 来源和输出位置为普通 fixture Jar；不能在 fixture 调用 fromResolutionResults/fromResolutionSources、创建 target 替代图、手工 dependsOn producer Jar 或改 outgoing capability。原自定义 root targetJarJar 不能再充当生产接线证明。

把原 verifyRequests 的记录/断言作为实际嵌入任务的附加观测或 post-run 验证，不额外给它依赖 producer/target 图来代替生产 Buildable。仅请求该嵌入任务时，真实 producer payload tasks 必须自行进入任务图；观测实际 selected graph variants、attributes 实值、完整 requests 和 bucket/inherited hierarchy，证实 target 请求未回流。解压同一最终 Jar，核对不同 A/B 身份、元数据 versions/ranges、jars/path 结构及各 payload 内容而非仅条数或文件名。

原失败 A/B 方法变为恢复验收并加 repeated include(a)、原名/late/root、distinct normalized-collision 的防归并检查；同 compilation 的普通 ProjectDependency（含与 generated 相等的手写完整请求）和 Provider、constraints/bundle/action 保留 ordinary 来源。补一处既有 TargetCompilation 继承场景，验证多路径同 target 不重复、接收属性不被上游替换、target 不经 inherited bucket 回流。原四通过涉及本次 collector/attributes/task API/元数据输入，属于受影响义务：可把原 assertions 合入选中的恢复/兼容检查，或过滤运行仍有价值的方法；不为凑“五全跑”无条件重复。仍需覆盖普通单图 last selector、incompatible、missing-base 正常失败、非传递和 Fabric 普通生成/既有 JSON 不变。

真实混合样本要含 target+ordinary module→同一 producer runtime variant 的标准 substitution，ordinary module require 同一完整 base capability，分别给出非空 strict/required/preferred 与 ordinary 最后 project 的 default-range 情形；记录普通图实际 traversal/最后 selector，不伪造全局声明序。唯一完整 target 身份优先、ordinary 版本规则不被 target default 覆盖、同 artifact 只嵌入一次。跨图不同完整身份的真实负例：普通来源 require 共同根完整身份并 requireFeature 选中 A 的已有 feature，target 来源 require A 的完整 base；两图各只有一个完整身份、都选中同一真实 A variant，汇集必须报 ambiguity。feature-only 不被提取器补成第二个完整坐标；若该 fixture 未真正选到同一 variant，就没有证明这个负例，不许以更早的普通选取失败充数。多个边界可在相同 fixture 场景/参数里检查，不生成独立框架或平台/MC 版本矩阵。

原证据要求是在各自既有 evidence.md 记录命令、实际工具链/Home、执行结果/数量、过滤方法、local implementation 来源、图/selector/producer-task 观测、最终 Jar/metadata/payload 的相对证据和不适用/未运行项。该要求保留；失败不得记 completed，成功也不回写 I02 generation 1 为 completed。

## 已采用的实际交付与验证

- I03 `recover-codev-include-source-gathering` / generation 1：completed。最终 [XML](../../../minecraft-codev-includes/build/reports/test/xml/TEST-net.msrandom.minecraftcodev.includes.IncludedJarInfoIdentityTests.xml)为 **9/0/0/0**，六个受影响旧方法与三个新增方法均通过，退出 0。八次真实 TestKit build 为旧 smoke 一次加新 API 七个场景，证明真实多图关联、混合版本/身份歧义、多个 artifact/重复去重、惰性读取及自动 producer 任务依赖；不把该证据冒充 Cloche 交付。
- I04 `recover-cloche-target-include-isolation` / generation 1：completed。三批实际 XML 为 **3/1/0/0、7/1/0/0、1/0/0/0**，11 个方法实例、9 个不同方法各自最新通过、13 个不同 fixture 场景；不是一次 9/0，也未合成 XML。继承初次失败后于兼容批通过，碰撞初次失败后单方法重验通过；逐方法和原 XML 对应见 [Context](./context.md)及 [I04 报告](../../../../cloche/build/reports/test/include-identity/identity-evidence.md)。
- 真实生产 `:consumer:includeJar` 的同一个 [Forge Jar](../../../../cloche/build/reports/test/include-identity/fixtures/positive-11959594579841300059/build/included/forge.jar)含 `late.targets:producer-demo-a:5.6` 与 `late.targets:producer-demo-b:5.6`，各 `[5.6,)`、`META-INF/jars/a.jar` / `b.jar` 及 target A/B payload；只请求 consumer 即自动执行对应 producer tasks。另有 [Fabric Jar](../../../../cloche/build/reports/test/include-identity/fixtures/fabric-681644005113503057/build/included/fabric.jar)与真实 client/data/clientData 多路继承、重复、混合版本及负例证据。
- Router 已完整读取并关联两份独立 completed Result，逐项判断原 `ITI-W01-G` 条件在已确认范围内满足，当前成员 I01/I03/I04 均 completed，`ITI-W01` 完成。原门槛及图语义未改，旧 I02 partial/5/1 与历史 unmet/not-ready 均保留；具体逐项投影只在 Waves。

## 风险、非目标与停点

- collector 视图、继承传播、Provider timing 的原新增 Cloche 写面已由 I04 实际生产任务、重复/混合及真实继承验证；不得将此有限覆盖外推为所有 compilation/版本保证。
- Gradle variant/artifact 跨图对象不同；联合唯一关联和不同 target veto 是必要的保守边界；真实混合必须成功，无法唯一关联需保留诊断，不以文件名或最后结果覆盖。
- 共享 API 对 I01 的影响已由 I03 六旧三新 9/0 定点覆盖，旧 14/0 仍只证明原单图运行；本地内外层来源及 Buildable 自动任务依赖已在真实共享 API/实际 includeJarTask 观察，不外推到未跑矩阵。
- 原准备记录对 I01 命令的误述、init-script 基准错误及作者自检失实均已按历史顺序记录；最终绝对路径经独立复核后实际使用。build 报告易清理仍是证据限制，不改写旧结果。
- I04 既有 testExternalRuntime 缺失未修；继承实际用 Fabric client/data/clientData，不代表所有 compilation/版本。三个编译/来源断言失败、两次 fixture 失败及修正均保留；先 implement-change 后补齐 implement-plan/pragmatic-delivery 的技能顺序偏差仍属过程限制，不重演或补跑。
- 不含 MC 重型图、根 test、G2/G3、Mixin/AccessWidener/IDE、代理/Home 变更、发布安装、Git 提交或通用 Gradle 内部 selector 清理。现有 server/client suffix 能力限制保留，不新增能力或 canonical modId 策略。

本次停在四文档事实同步和局部回读，不新增实现、独立审查或运行验证。当前 gate 满足只覆盖已确认范围；根 test、全版本/配置缓存矩阵和 MC 重构建未运行，I03 其余八个旧方法未重跑，G2/G3/buildSrc/发布安装/提交未执行，不声称全项目或全版本验收。
