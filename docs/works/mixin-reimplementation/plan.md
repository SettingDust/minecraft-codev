# Mixin 最小重实现 Plan

[Work](work.md) · [processed Context](context.md) · **唯一匹配执行图：[Waves](waves.md)**

**状态：Router 已采用现有类型名范围确认及随后 C6 原生选项简化确认；必要 PRD R3 / Spec 澄清已完成，同一 ADR reuse，无新增 options 决策/权限待定。** 本 Plan 保持一个 coherent scope，无 overview/slice/Tasks；本次仅记录已采用 R04 completion、Router supplied WR04 satisfied 与当前选定 Plan 完成判断，不实施或运行生产验证。Router 已采用 **MRI-R02:g1 completed / MRI-WR02 satisfied** 和 **MRI-I02:g1 completed / MRI-W02 satisfied**，保留当时独立核对 membership、前置及 evidence/release predicate 的判断；R02 的 whole producer 判断仅覆盖当时实测输入与组件场景，**不覆盖本次暴露的 target-owned Mixin class dispatch/preservation 缺口**，不再据此宣称当前 producer 全覆盖。Router 已从 full join 完整读取并关联 `mixin-real-caller-cache-reimplementation:g1` / **MRI-I03:g1**，采用业务 **partial**（backend completed 仅表示调用终结）；**MRI-W03 pending/未释放**。原 I03 完整 predicate/owner/verification 与前置保留历史，不作为新路线的 completed prerequisite。当前同范围恢复仍为 **MRI-R03→MRI-R04**：Router 已完整读取并关联 `mixin-target-owned-class-dispatch-repair:g1` / **MRI-R03:g1 completed**，并独立判 **MRI-WR03 satisfied**；**MRI-R04:g1 completed / MRI-WR04 satisfied** 已由 Router 采用/提供判断，结合 WR02/W02/WR03 三个既有 satisfied gates 建立当前选定 Plan 完成；本 writer 只记录 supplied judgement，不重判其它 gates。I01 blocked、R01 partial 与 W01/WR01 pending/未释放不变。采用事实与限制见 [R03 Context](context.md#mri-r03-completed-事实与独立-gate-判断)。 活跃完成 gates 为 **MRI-WR02、MRI-W02、MRI-WR03、MRI-WR04**；WR03/WR04 已 satisfied，原 W03 保持未释放历史。consumer 已为 removalsFile，独立 Strip completed，当前选定 Plan 已完成。执行分解仅在 Waves，证据见 [R02 Context](context.md#mri-r02-completed-事实与独立-gate-判断)、[I02 Context](context.md#mri-i02-completed-事实与独立-gate-判断)与 [I03 partial/新缺口](context.md#mri-i03-partial-事实与目标内-mixin-class-缺口)。

## Spec 来源、结果与非目标

复用 [Work 的 PRD/Spec/ADR assessment](work.md#权威复用)：Active [PRD](../../prd/codev-mixin-rework.md) R2/R3/R4/R5/R6/R8/R10、现 [Spec](../../spec/mixin-preapplication.md)及 Accepted [操作隔离 ADR](../../adr/mixin-operation-isolation.md)。英文与[PRD 中文稿](../../prd/codev-mixin-rework.zh-CN.md)/[Spec 中文稿](../../spec/mixin-preapplication.zh-CN.md)描述相同范围，不增平行权威。已采用三族局部 assessment 的必要 PRD R3 / Spec 五处 update 均已完成，当前版本可 reuse；ADR 保留同一身份。Spec 排除 public raw override 及其 getter 适配，未冻结内部观测/缓存算法；其余未定接口允许本规划保留已确认的具体安排，不要求复制旧类图。本次复用 I03 的局部 reuse assessment：PRD R3/R5/R6/R10 和 Spec supplied target/discovery、class/resource preservation、build-copy 及同链消费/cache 已覆盖目标自带 config/classes；新观测是实现缺口，不是新合同或隔离/引擎/选项设计选择。

本 Plan 的单一交付结果（已由四个活跃 gates 建立）：可由 caller 注册/组合的真实预应用 Task 与独立逐 JAR 精确 Strip Transform，连同必要旧路径清退；真实 caller 验证同操作 raw sources＋derived target 的清理消费、组件失败传播与正常当前输入缓存复用。Codev 实现算法，caller 负责注册、参数/依赖连接、集合/属性选择及消费，输出用途自主。

不做：旧 Provider repair 路线恢复、给 `RecordData` 套壳、旧 API/DSL/ABI/records 兼容、全目标完成或无报错证明、日志扫描、独立应用审计/注入语义验证器、来源库存/摘要/tree binding、空文件依赖桥、Map-only 恢复框架、JSON 通用规则引擎、Codev 自动接线/注册 helper/统一 provider/双出口/全局 ready、运行时抑制/重应用安全或任意下游兼容承诺。无引擎升级、MixinExtras 自动 bootstrap、根构建/通用缓存/工具链重设计。不改 Cloche/外部消费工程、D 树、Core/includes 通用能力、运行配置、CompileJar、lint 或独立 Forge patch；不恢复旧 Core 测试，不重开旧 G1。

## 提出的最小 API 与数据流

| 角色 | 本 Plan 已确认的实现范围（局部落地不等于完整实现） |
| --- | --- |
| producer | 保持现有公开 `task.Mixin`（Task 名 `Mixin`），只重实现其内部编排，不新增 `PreApplyMixins` 类型或安排纯命名迁移/兼容别名；保留逻辑输入 `inputFile`、`mixinFiles`、有序 `classpath`、可选 `mappingFile/sourceNamespace/targetNamespace/refmapContext` 和显式有效 `side`（简单字符串值，含 `UNKNOWN`）；**无 public `engineOptions` 或等价通用 raw override**。通用选项由 Mixin 原生读取宿主属性/default，内部观测仅作 Gradle 输入跟踪。`outputFile` 是 applied JAR；`appliedMixins: RegularFileProperty` 是应用通知清单的另一 tracked output，不叫 `cleanupFile/appliedMixinsFile`；consumer 的 `Parameters.removalsFile` 仍表示中立移除请求，同格式 provider 直接连接，不加 DTO/alias/转换层。 |
| 默认输出 | 两个 convention 分别直接来自 `layout.buildDirectory` 下 task 自有的 `mixin/<task-name>/applied.jar`、`mixin/<task-name>/removals.json`，不把一个 task output provider 映射成另一个默认值。caller 可以正常改目标位置；默认 appliedMixins 仍独立可查询，不加依赖 sentinel/bridge。以真实 Gradle 执行前输出查询和默认值测试证明，而非仅凭此设计断言修复。 |
| 通知文件 | 仅 UTF-8 JSON object：完整 archive config 路径→原字符串数组，例如 `{"nested/example.mixins.json":["Example","Other"]}`；`{}` 是有效空集。数组按集合语义读取，重复值折叠而非拒绝；config 内/跨数组/JAR 的重复匹配不拒绝。结构、UTF-8/JSON、重复 JSON object 字段歧义及路径有必要严格检查，不带 producer、来源、hash、section/index、complete/output、obligation 或诊断字段，不做旧格式迁移/版本协商。 |
| 精确消费者 | 保留现有公开 Transform 类型名 `StripMixins`，公开 `Parameters.removalsFile: RegularFileProperty` 为 `@InputFile`，`inputFile` 为 `@InputArtifact`；内容相关路径归一化采用 `PathSensitivity.NONE`。一个输入 JAR→一个独立输出。此文件可由任意符合格式的 producer 提供，Strip 不查通知资格/生产者或是否来自预应用；预应用 Task 只是一个 producer。 |
| 平台发现 | 将现 `MixinListingRule` 从 Core 的可删除 handler 继承中解耦，收窄为 Mixin 专用只读发现，返回 config 路径及环境集合（`*`/`client`/`server`；不适用可返回空/无结果）。沿已有平台 SPI 注册点迁移，不另造通用 discovery 框架。Fabric/Forge 读 metadata、不写 metadata；环境/parent/解析职责保留，具体私有 helper 不冻结。 |
| 插件入口 | 保留可加载的最小现模块插件入口/描述符，移除自动创建旧 mixins source-set 配置的便利表面及 Groovy 扩展注册；插件 apply 不 bootstrap 引擎、不注册/挑选 caller 的 Task/Transform/configuration。 |

文件内容是移除请求，不是成功账本。它与 producer 通知归因合同分开：producer 只能据原生应用通知建立准确键；Strip 只执行调用方给定的精确移除请求。路径是 archive 资源路径，原字符串取 package 展开和 mapping 之前。文件无内存依赖、无来源证明，不能靠文件存在宣称当前完成。

数据流：caller raw 输入 → Task 验证/跟踪 → 一次 fresh operation runtime 真实处理及通知归属 → runtime/自有资源退出后完成 Task outputFile＋appliedMixins 发布 → caller 注册同操作 Strip 参数和属性/view，保留 producer references/必要 build dependencies → raw source JARs＋derived target 各经同一 Transform → caller 消费要求的完成结果。applied-only 可独立请求，不宣称 stripped/完整清理。

## 新实现、局部复用与退出边界

| 边界 | 最小策略与 owner；不是整文件保留清单 |
| --- | --- |
| Gradle/host/runtime 编排 | 以 `minecraft-codev-mixins` 为主重建 Task、Runner、EngineOperation 职责，避免长位置参数、重复 discovery 和来源 proof 往返；公开 `task.Mixin` 类型保持不变，不要求沿用 Runner、EngineOperation 等内部类名。保留操作级实现域、task 域（resolution→sources→target），平台类正常委派。每次 bootstrap/services/properties/transformer/plugin/remapper 状态独立；跨 loader 用 JDK/simple values，不引入公共 DTO 框架。 |
| 目标 archive dispatch/preservation | R03 仅修复现 runtime 对普通目标类转换与应原样保留的目标内 Mixin 定义/相关资源边界；目标自带 config/classes 不移走。既有 R02 组件实测不能覆盖 I03 暴露的目标内 Mixin class 场景；具体私有修复机制由 owning code Handler 决定，不在 Plan 预选算法，不允许吞 IllegalClassLoadError、猜测宽泛包/目录跳过普通类或伪造通知。 |
| 通知与命名 | 局部复用锁定 `0.15.0+mixin.0.8.7` 的原生 `IMixinAuditTrail.onApply` 及必要通知原键适配；`preApply` 只绑定上下文/原字符串，不授予资格。保留可归属 parent、动态无原始键不造键、路径与原字符串精确性。未知归因保持诊断；不恢复 suppressed/obligation/残留对账。复用精确 mapping-io `0.7.1` remapper、refmap→MemberInfo→environment 链，双向 owner/name/descriptor、null/unmapped/歧义语义不弱化。 |
| `RecordData` 拆除 | 删除总容器而非套对象壳。按直接使用点安置少量文件 JSON/path 读写、专用 side/context、mapping tuple、有序输入/实际资源解析逻辑；不建设新万能 utility/DTO/协议。专用显式 side/mapping/context 真正作用于 operation，不以与继承值相等代替参数生效；通用选项沿原生宿主读取/default，内部仅观测实际影响输出的属性及相关未设置/default 状态。撤下 raw options 复算/覆盖要求，不注入独立选项快照、不写或泄漏 JVM 全局属性、不重解释原生继承/解析规则，也不为该能力改写 getter 字节码。不选内部载体/枚举/序列化/缓存私有算法，不扫描无关全 JVM 环境。去掉来源 `identity/digest/binding/configInputs/SCOPE`、重复手工摘要和 complete/output 断言；保留 engine pin 所需版本边界，不混同输入来源账本。 |
| Strip/发布 | 优先复用现精确编辑器的按路径/原字符串过滤、严格 JSON/ZIP、CRC/STORED entry、不变内容路径和真实写入/关闭异常 seam；去掉 `SelectiveConsumer` 的旧角色名/容器依赖，可就近改名/内联。复用 `OperationPublication` 的最小输入/别名/hardlink/目录保护、独占/staging/失败清理职责，不要求其类图不变。不能换成直接覆盖，不造跨任意 caller tasks 的事务。 |
| 旧 host 双轨/资源 | 旧 `mixin/GradleMixinService`、`GradleGlobalPropertyService` 与其两个实体 `META-INF/services/org.spongepowered.asm.service.*` 注册成对退出；保留/重组 operation-owned `OperationService/OperationProperties` 及隔离域原生 service 选择，不留竞争 provider。旧便利函数及 `org.codehaus.groovy.runtime.ExtensionModule` 成对退出，反射字符串/生成类名/描述符同步检查。 |
| 平台最小连接 | Fabric 的 config 字符串/object/list、路径/environment；Forge manifest 拆分/trim、NeoForge TOML 和双 metadata 发现保留。删除 Mixin 专用 `SelectiveMixinConfigHandler`、旧独立 applicability 容器（职责并入只读发现）、平台 `remove/removeConfigs/updateManifest/updateToml` 及仅服务 metadata 删除的检查。保留两个平台 listing SPI，随新签名同步实现/fixture，不能误删 Core `ListedFileHandler.remove` 或 includes consumers。 |
| 测试/fixture 迁移 | 不按旧 suite 绿色保留结构；生产 seam 改变的调用/反射/SPI/生成源码需在所属 item 内同步到可编译可运行。删除 proof/一律重复拒绝/metadata 删除断言与未用 `r05/RetentionPlugin.java`；`LegacyStripMixinsTests` 可整体退出，把参数、精确编辑、I/O/关闭、输入保护、ZIP 有效断言重组到当前职责测试。平台 proof 耦合移除，保留触及的 AW/AT/nested-JAR 等最小行为观察，不借此新认证全平台。 |

迁移按 [Waves](waves.md) 的真实合同/写冲突串行，不按文件数拆 item。producer 单元为撤下 `RecordData` 必须同步 reader/平台/测试引用的最小迁移，但不以此声称 Strip 或整链验收；Strip 单元再完成独立消费者整理与检查，最终 caller/cache 单元只测试公开组件，不在 fixture 偷修生产逻辑。I03:g1 partial 之后，R03 局部 producer 修复与 R04 剩余 caller/cache 各为一个有界 Handler/独立 Result，并按共享 runtime、tests/fixture 与运行/cache 副作用串行，不扩大原确认范围。无长期兼容双轨；旧代码/资源退出与调用者一起完成，不能只删名字留下字符串 caller。

R01 partial 已落地的命名/default/空插件/旧 host/SPI/Groovy 退出是 R02 复用 baseline，不回放改名/删除。**R02:g1 已完成**当时实测覆盖内的剩余 producer 职责：原生只读相关属性/unset 输入观测、去 public engineOptions/operationScope/Side enum/manual identity、简单 side/专用 mapping/context 实效与无污染、RecordData 拆为小职责、fresh runtime 与关闭/发布保护、只读平台/SPI 及旧 metadata writer 退出和必要直接调用迁移。上表保持已确认范围，不新增算法/机制要求；R02 终结时 SelectiveConsumer 仅 helper 迁移；I02:g1 已完成独立 Strip/removalsFile、ExactMixinStripper（serializeNulls 保留未知 null）、旧 legacy/未用 RetentionPlugin 退出及必要平台测试/fixture 迁移。AppliedMixins/StrictJson/ArchiveResources/OperationPublication 与 producer engine 未改；I03:g1 只完成独立目标 Mixin package 与 finally 六份 raw 不变 fixture 修正，五个不同 TestKit methods 0 通过，最终首个 method 1 test/1 failure，当时无 applied/通知/消费成果。此 I03 历史不回写；后续 R03:g1 已完成局部修复，原失败 caller method 在新独立 Result 中通过，WR03 已由 Router 独立判 satisfied；剩余五组 caller/cache 未执行部分已由 R04:g1 completed 补齐。pipeline-caller.gradle 公开接线 I03/R03 均未改；R04 仅增加 fixture-only 故障注入和输入场景，不改 caller 合同。

## 跟踪、保护与最小验证

验证来源是 [Spec 当前验收表](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions)，不是旧 C/A 编号、组件 green 或静态评估。以下是完整验收安排，**R02/I02 当时实测组件覆盖保留；R03 已实测修复目标内 Mixin class 场景并通过指定 caller regression；R04 已实测补齐剩余 caller/cache；下表保留原验证要求，实际分轮结果及组件复用范围见 [R04 Context](context.md#mri-r04-completed-事实与-router-supplied-gateplan-判断)，不是宣称全组件重跑**；R02 实际覆盖与限制见 [Context](context.md#mri-r02-completed-事实与独立-gate-判断)。R01 已有 default/provider/SPI/package 与 20-tests 局部证据见 [Context](context.md#mri-r01-partial-事实与可复用基线)，在 scope/输入/实现/环境与覆盖仍成立处复用，相关实现变化按适用条款重新验证，不冻结未修改时的 green 或要求无变化重测。具体 item 的唯一 predicate/evidence 见 Waves。

| Spec 现行条款 | 最小实质观察与归属 |
| --- | --- |
| Supplied materials / Naming / Operation ownership | MRI-R02：真实小类/JAR/plugin，指定任务域类与资源优先、sources/target-only discovery、parent/环境与真实冲突，重复身份可用；专用 side、原生宿主属性/default 选项行为与内部输入观测一致，宿主未被 Codev 污染；mapping 到正确 owner/overload，双向 descriptor/null/unmapped/歧义、无 mapping/无 refmap、显式 context/非法 tuple。同 JVM A→B、失败重试、独立并发对串行、输出冲突、TCCL 恢复与可释放 JAR。 |
| Real results / Applied outputs / Build copy | MRI-R02：真实目标输出可调用、通知准确原键、跨 loader 后可读文件、有效空；多目标某处通知而其它处失败/部分/unknown 且正常返回仍保键；仅日志报错不另判失败、引擎抛异常向外传播。实际 I/O/关闭/runtime exit/取消/发布失败不发布当前半成品或旧成功，原输入不变。真实输出断言仅检 Codev 调用了引擎，不独立认证注入语义或清理资格。 |
| Applied outputs and exact dependency cleanup | MRI-I02：独立手写格式文件和真实 producer 文件均可用；同数组/三数组/跨 JAR 重复全删、嵌套路径/不同原串不匹配，package/mapping 不扩大 key；未知嵌套字段、顺序、空 config、class/refmap/metadata/资源保留；空集合/无匹配保持 config 内容。非法文件/config/ZIP、输入别名及实际写入/关闭/发布/取消失败不能消费半成品，验证 STORED/CRC；不是只用 mock 或字符串断言。 |
| Supplied target / class-resource preservation / build copy | MRI-R03：真实 native 小 JAR 同时携带普通目标、目标自带 config/Mixin 定义及其他资源，观察普通类仍经真实引擎、Mixin 定义与其他非转换内容保留、准确通知及 raw 输入保护；复验现失败真实 caller method，不重复全部 cache/全组件。 |
| Task/Transform / completion / input changes/cache | MRI-R04（承接原 I03 未执行部分）：真实 TestKit caller 注册 Task、项目级 registerTransform、from/to/参数/属性/view/消费及必要显式 producer dependency。正常 applied-only/default 输出查询＋完整 sources/derived target（均含 config）、resolution-only 排除、两 operation 无串/无环；分别 fail source strip、target strip、producer/publication，受影响消费失败而独立 applied 成果不冒充全流。随后同链 SUCCESS→Task outputFile＋appliedMixins FROM-CACHE→无 producer 内存首次 fresh Transform，再检 Task UP-TO-DATE、每个 Transform 的正常缓存恢复/复用与内容。 |
| 同上 current-input correspondence | MRI-R04 同一已修正 fixture 内分别改 config/plugin body/resource/mapping/专用 side/context、相关继承宿主属性或其未设置/default 状态、有序输入和实现输入跟踪（不是 Task raw overrides），Transform removals/inputArtifact 单独变化，实际消费当前结果。合法空集单独成功；缺失/损坏/无效/陈旧交接必须正常重建/恢复或消费失败，不能猜空、只凭旧 JAR/文件存在或跳过要求的 Strip。 |

Task 用 Gradle 原生内容/有序 runtime classpath 跟踪（插件方法体/资源不可用 `@CompileClasspath` 代替），完整实现依赖、专用有效 side、mapping 内容/方向/context，以及实际影响输出的原生继承属性与未设置/default 状态都作为构建输入跟踪；内部观测须与实际原生读取一致，不冻结算法；outputFile/appliedMixins 各为 tracked output。Transform 的 inputArtifact/参数/输出受跟踪，caller 保留生产依赖，靠正常执行/缓存恢复防 stale，不加自制 hash、来源证明或恢复平台。缓存状态不是新引擎执行证据。

原验证安排沿现有 wrapper、JUnit/TestKit、pluginUnderTestMetadata、test launcher 17 和小 fixture `--release 11` 设施，在 Codev 根目录选择受影响 methods/suites；普通日志/XML、小 JAR 和真实内容断言足够。MRI-R02/I02 记录实际 selectors 与必要平台检查，含剩余 mapping/refmap/context、failure、native 观测一致/无污染、平台 metadata 保留及触及的 AW/AT/nested 检查；MRI-R03 仅补目标 archive dispatch/preservation 和现失败真实 caller regression；MRI-R04 复用仍覆盖新代码的 R02/I02/R03 证据，只补原 I03 五组要求中未实际执行的同链缺口。I03 提前 producer 失败不算 source/target Strip、故意 publication、缓存、输入变化或损坏交接分支已执行，当前 XML 也不能重建旧成功计数。旧 59/13 测试计数不是指定必须绿的旧套件，不全跑旧 G1、不下载/启动游戏、不安装或清全局缓存。

## 风险、兼容与停止边界

- 通知不保证全目标效果或无报错；同键跨物理来源一并删除是已确定代价，不设风险批准/全应用证明 gate。用户自行读 Mixin 日志，Codev 不加判读系统。
- 锁定引擎通知归属有版本敏感面，通用选项保留原生宿主/default 语义与内部输入观测，专用 side/mapping/context 不被宿主值替代；新链必须实测这些 Codev 责任及 Codev 未污染宿主。若确需引擎字节码改写、依赖升级、隔离架构变化、支持收窄或合同改变，加载 `spec-driven-development` 并返回具体条款/选择/影响，阻断受影响部分；不擅改 authority。常规私有命名/hook/JSON 实现不另造确认门槛。
- producer `appliedMixins` / consumer `removalsFile` 等新 API、旧 DSL/实体 SPI/metadata writer 清退是有意不兼容，不提供 shim/旧文件迁移；R01 已完成 producer 属性与旧 DSL/host 实体 SPI 退出，R02 已完成平台只读/SPI 与专属 metadata writer 退出，I02 已完成 consumer 参数/独立 Strip 与必要仓库内引用迁移；目标内 Mixin class producer 局部修复已由 R03:g1 completed / WR03 satisfied 记录；完整 caller/cache 已由 R04:g1 completed / Router supplied WR04 satisfied 补齐。必要仓库内 caller/fixture/平台注册随 owner 一起迁移，未知仓库外使用方需改接新组件。本 Plan 不声称已迁移任何外部使用方。
- 默认 Provider 原 regression 的真实 Gradle 路径要求不变；R01 已有全默认/只改 outputFile 的真实 smoke 通过证据，未改变的有效覆盖可复用，若相关实现改变则复验。fixture 不显式设置 appliedMixins 默认路径或伪造生产文件。参数 provider 本身不被假定足够调度所有 Transform，caller 显式依赖有实际依据，不增空文件桥。
- 混合工作树不得 reset/清未跟踪/还原未知作者内容；未来撤销只限有权限的本轮自有修改，不回退 authority/旧历史。输入保护与失败可见不能因“精简”删除。工具链/依赖/权限不足就报告真实限制，不顺手修 Core/lint/Forge patch。

## 完成边界

活跃 Plan 结果须由 **R02/I02/R03/R04 各自 completed**、证据分别满足 **WR02/W02/WR03/WR04** 及实际 caller/cache 闭包共同建立；现已采用 R02/I02/R03/R04 completed 与 WR02/W02/WR03/WR04 satisfied，当前选定 Plan 完成；R04 的五组实测、分轮结果及限制见 [R04 Context](context.md#mri-r04-completed-事实与-router-supplied-gateplan-判断)。R02/WR02 当时 whole producer 判断限于实测场景；R03 新增覆盖仅限已实际修复/验证的 target-owned Mixin class 与指定 caller regression，不泛化当前 producer 全覆盖。R03 仅改 EngineOperation.java、MixinProducerTests.java、MixinInputBindingTests.java，以锁定引擎 MixinClassReader 识别实际 @Mixin CLASS-retention invisible annotation、定义原字节保留，其余类仍真实 transformClassBytes；未改 engine/Task/Strip/platform/options/loader 架构。最终同次 8 项 focused 全通过及 native/真实 caller、两次中间修正、warning 和可覆写载体限制见 [R03 Context](context.md#mri-r03-completed-事实与独立-gate-判断)。

R03 是原确认 scope 内局部 producer archive dispatch/preservation 修复的单一结果：依赖既有 producer 和 Strip 组件以完成当前真实 caller regression，不承接整套 cache。R04 是修复后原 I03 尚未实际执行的五组 caller/cache 闭包的单一结果，只在新修复 gate 成立后获得前置，不靠 I03 partial 的 completed 或旧 W03 释放。R03 completed / WR03 satisfied 是 Router 已采用的独立完成/gate 事实；R04:g1 completed 已采用，WR04 satisfied 与当前选定 Plan 完成为 Router supplied 判断，不由文档静态检查推导。一个 item/一个 Handler/一个独立 Result，不拆参数、native 完整应用证明或另开终验/框架。可复用证据按实际 scope、输入、实现、环境与覆盖判断，不冻结旧 green、不要求无变化重测。图、membership、前置/冲突和唯一执行分解仅在 Waves。

保留 MRI-I01:g1 blocked（0 生产改动）、MRI-R01:g1 partial、MRI-I03:g1 partial 及其完整原 predicate/owner/verification；MRI-W01/MRI-WR01/MRI-W03 均 pending/未释放，不因新恢复自动满足。旧 MAP-I04 partial/未释放、旧 repair 取消与旧 G1 历史不改。本轮只维护协调事实与图结构，不运行 Gradle/LSP/新实验，不修实现、不重判/扩大既判 gates、不更新 Todo、不调度或选择 continuation。公开名称、原生选项边界与原确认 scope 不变，不以文档追加实施许可或 routine permission 门槛。
