# Mixin Artifact Pipeline Waves

[Work](work.md) · [Context](context.md) · 唯一匹配 [Plan](plan.md)。本图只建立该 Plan 的“Codev Task/Strip Transform 组件正确性＋caller 注册消费 fixture 的完整清理与正常缓存恢复”结果，不是旧 G1 的继续图。

**Implementation confirmed / in progress；C5 同范围恢复。** 用户已确认原三单元完整披露范围及正常 Gradle/fixture 自有 outputs/cache。I02/I03 completed 与 W02/W03 组件范围 satisfied 为 Router 已采用事实；I04 partial/W04 不满足、未释放。新 repair/recovery 全 pending，本次不执行或释放。 一 item＝一 Handler＝一 Result；gate 判断由 Router 完整读取并关联 Result 后完成。只有 completed＋该 item 证据＋gate predicate 满足才释放显式依赖；partial/failed/blocked/missing 或 completed 但证明不足均不释放。表格顺序不建立隐含依赖；无自动 scheduler/新审批协议。

## 唯一执行图

| Wave ID | gateState | 非空 itemIds | predecessorWaveGates | incremental 结果与可核 release predicate |
| --- | --- | --- | --- | --- |
| MAP-W02 | satisfied（组件范围） | MAP-I02 | [] | producer 真实调用引擎、收集应用通知并映射原键，提供可在 loader 关闭后使用、当前输入跟踪的目标＋小型清理信息；I02 通知/交接及异常/IO/保护断言通过，不附加完整应用资格条件。 |
| MAP-W03 | satisfied（组件范围） | MAP-I03 | [MAP-W02] | 每 JAR Transform 满足全匹配精确 JSON 清理；I03 正负例及保留/失败检查通过，未依赖逐来源 records/metadata 删除。 |
| MAP-W04 | unsatisfied（未释放） | MAP-I04 | [MAP-W02, MAP-W03] | 原 predicate 保留：caller 注册/绑定/选择消费的完整清理、applied-only、跟踪/cache 与受影响消费失败闭包，连同有效组件证据覆盖原 Plan 条件。I04 partial 未满足；这是历史 gate，不是现行恢复路线终点，R04 完成不自动放行它。 |
| MAP-WR02 | pending | MAP-R02 | [MAP-W02, MAP-W03] | 公开 Mixin 的默认 cleanupFile Provider 在真实 caller scheduling/output 查询合法，不发生自身 producer 完成前 mapped output 拒绝；R02 completed＋不覆写默认的原失败 regression 及必要受影响 producer 检查通过，tracked outputs/安全未回归。 |
| MAP-WR04 | pending | MAP-R04 | [MAP-W02, MAP-W03, MAP-WR02] | R04 completed＋补齐原 I04 全部尚未满足的 caller 注册消费/cache/失败闭包，结合仍有效 probe、修复及组件证据覆盖原全部完成条件，无验证削减或未解释失败。 |

现行 Plan 结果需要 **MAP-W02、MAP-W03、MAP-WR02、MAP-WR04** 共同满足。原 I02→I03→I04 历史保留；恢复新增 I02/I03→R02→R04，R04 同时显式依赖 I02/I03。原 I04 partial 不是 requiring-completed 前置，W04 不成为新路线的前置或终点；不 resume 原 Result、不把原 partial 改 completed。每个新 item 各一 Handler、一独立 Result，未来实际证据由修复/recovery Result 产生。

## 所有 item 的共同边界

- 前提：当前用户已确认 [Plan](plan.md) 原完整实施范围；本次 C5 不改变该范围，不要求重复确认。后续各 item 仍须满足自身前置及所在 Wave 的 predecessorWaveGates；文档不是 runtime 授权回执或自动调度。
- 依据：Plan 的 PRD/Spec/ADR reuse 与 [processed Context](context.md)；规范细则以 [Spec](../../spec/mixin-preapplication.md) 当前章节为准。旧 selective/records、旧图/gate/实跑不当本轮证据。
- 路径以 Codev 仓库为根；下述短文件名定位于 Context 的可读源码/测试链接及 `minecraft-codev-mixins/src/{main,test}/` 对应包。新增局部私有实现/fixture 只限这些 owner 邻近；不是泛化框架或新采集器。
- 保留 Plan 的 JDK 跨 loader、输入/输出身份、安全 staging/ownership、资源/TCCL、真实 engine pin/加载一致性、未知字段/顺序/资源保护。Codev 实现组件/算法，caller 注册/绑定/组织集合/请求属性并选择消费；不实现生产自动注册/选配置、helper/DSL/统一 provider/聚合出口或全局 ready 谓词。只删新接口必要范围内被替代且调用检查无保留使用方的旧路径；旧 records/API 不作兼容。
- 不改 authority、旧 Work/图/证据、指南/README、无关 Core/Forge/其它工作树或 Git；不复原未知改动。缺工具链/依赖/权限或需额外引擎字节码改写、重要依赖/架构/支持范围变更时报告具体 gap 并停止 affected scope，不安装、扩权、清缓存、换子集或默默改合同。
- effects：未来运行仅正常 Gradle/fixture/Transform 自有 build/test/temp/cache 输出和必要小 JAR，普通 XML/日志即可；不得加整包/全树快照或外部 Result 路径依赖。持久记录只加工事实及可读 repo 相对引用，不复制完整 Result。
- 所有生产/测试写、共享 fixture/API 合同与 Gradle/缓存副作用串行；只读共享 authority 不冲突。I02/I03 的 completed 及 I04 partial 写入保留为既有状态；R02 在最新状态修 producer/共享 regression，R04 仅在 R02 completed＋WR02 satisfied 后接续同一 fixture，禁止两者并行。历史 partial I04 不再作为待 resume 的并行写 owner。已验证且 scope/inputs/source/environment/freshness 仍覆盖的局部证据可复用，不为重复证明重跑旧 G1。
- 原未执行的独立 native 完整应用实证 item/Wave 及前置/风险 stop gate 已移除，不换名或藏入 Codev 测试。原 I04 的重复终验仍属 caller 消费同一闭包，由 R04 接续未完成部分，不新增独立终验。保留 I02–I04 稳定 ID/结果与 gate 判定，不从缺号推断其它前提；I02/I03 的组件完成不放行新的 repair/recovery gates。

## Item 定义（唯一执行分解）

I02–I04 保留原完成合同与写域作范围对照；各项「已采用事实/evidence」才描述实际结果，不能将后面的 verification 要求读成全数已执行。新执行边界仅 R02/R04，原 caller/cache 全条件未删减。

### MAP-I02 — producer 的应用通知与可恢复交接

- state: completed；wave: MAP-W02；prerequisiteItemIds: []。
- 已采用事实/evidence：Router 完整采用 `mixin-producer-engine-notices` generation 1 completed，W02 在组件范围 satisfied。target＋cleanupFile、JDK 集合跨 loader、通知原键映射、自然异常/IO/资源释放/输入保护定向检查及受影响平台检查通过；部分 fixture 曾先败后修，不宣称全仓库。见 [Context 组件记录](context.md#已采用的实施与验证事实)。默认完整 caller 调度并未被该 green 证明；I04 新发现另由 R02 修复，不重开 I02 或抹除独立组件事实。
- 单一完成 predicate：当前 raw 输入经真实引擎处理后，Codev 产出已完成的 tracked target＋可脱离 loader 使用的精确通知清理信息，且异常/IO 失败不发布当前成功、有效空集与异常信息可区分。
- scope/effects：提供可由 caller 注册/配置的公开 Task 类型及 tracked target/清理输出；沿现 native 扩展/回调机制实现通知收集和 config→原 strings 映射，JDK 简单值/集合跨 loader，Task 写出小型内部清理文件，不作公开 records。hook/API/表示是本项有界实现细节，无先行 native 能力证明依赖。移除重复 section/展开名 identity 拒绝及 partial/dynamic/attempted 一律整次 selective 拒绝；通知即资格，其它目标/来源失败、部分或 unknown 不取消已通知键。engine 正常返回不作资格条件；仅日志报错而正常返回不自行转失败，直接异常向外传播不吞掉。自身写入/关闭退出/发布完成仍是组件输出条件。
- write owner：`task/Mixin.kt`、`OperationRunner.java`、`runtime/EngineOperation.java`、`PinnedMixinAdapter.java`、`RecordData.java`、必要的 `OperationPublication.java` 及 plugin/SPI 的最小调用迁移；迁移对应生产调用的 `MixinPreapplicationTests`/`MixinFailureStageTests`/`MixinOperationIsolationTests`/`MixinMappingTests`/`MixinInputBindingTests`/`OperationPublicationTests` 最小 fixture/API 引用。依据 Spec「Operation ownership」「Real results」「Applied outputs」「Input changes」。不新增自动注册/接线。
- constraints：保留包名展开/映射前的完整 config 路径＋原数组值；通知归因未知不能编造键，未通知键保留，不把合法通知永久当 unknown。重复 cleanup key 不等于引擎解析歧义；修 discovery 的无条件跨来源拒绝，但保留真正必需解析校验、顺序与 class/resource 一致性、mapping 链/engine pin。`RecordData` 的有效输入校验不得随 records 序列化整体删除；外模块保留调用不破坏。旧 strip 调用仅作必要迁移准备，不在本项实现 Transform 或 Codev 注册/消费接线。
- verification/evidence：在真实引擎小类/JAR fixture 中观察处理输出及 Codev 通知→精确原键映射，发现/候选不造键；多目标条目某处获通知，其它处失败/部分/unknown 且正常返回，已通知键仍合格，未通知键不合格。仅报错日志保持可读、不解析判成功；直接异常传播、有效空与缺失/无效信息不同，producer 完成 unknown/写入/关闭退出/发布失败阻断。plugin/string target 检 Codev 输入和归因不裁支持；保留真实 naming/remapper、隔离/重试、资源关闭/TCCL 及输入别名/hardlink/目录保护断言，loader 关闭后交接无活 engine 对象。检查 target/信息声明输出及输出相关输入跟踪，普通 XML/日志/必要小产物即可。不验证注入语义、不重建 native 目标义务、不以最终 bytes/全目标完成/无报错认证资格；实际输出断言只检 Codev 真实处理。正常 build-cache 与 caller 依赖原归 I04，现由 R04 补齐未完成证明。
- conflicts：与 I03 共交接 reader、publication、测试和运行副作用，与 I04 共 TestKit fixture/API/参数合同及运行/cache 副作用；I03 与 I04 均显式依赖本项，以最新交接表示为输入，不并行冻结两个 schema 或保留旧 records 兼容层。

### MAP-I03 — 逐 JAR 精确 Strip Transform

- state: completed；wave: MAP-W03；prerequisiteItemIds: [MAP-I02]。
- 已采用事实/evidence：Router 完整采用 `mixin-strip-exact-transform` generation 1 completed，W03 在组件范围 satisfied。公开 cacheable per-JAR StripMixins 参数/inputArtifact 均 tracked / PathSensitivity.NONE，精确全 matching 删除与其它内容保留、平台最小迁移已通过；28 个不同测试方法有成功证据，最后 CRC 增量另复验受影响 2 项，不重复计数。I03 未改 producer/RecordData/OperationPublication；[Context](context.md#已采用的实施与验证事实) 链接 focused-final、adjacent、zip-integrity 原日志。组件正负例不等于 caller/producer-default/cache 完成。
- 单一完成 predicate：任一处理成员 JAR 经当前清理信息驱动的同一 Transform，恰删全部 matching 原数组值且保留其它内容，编辑/参数/发布失败无可用半成品。
- scope/effects：将 `StripMixins` 替换/复用为公开可注册、带 tracked 参数的 cacheable per-JAR Transform，inputArtifact 是 JAR，参数绑定有效清理文件；仅精确过滤 config 的 mixins/client/server。替代 `SelectiveConsumer` 和 `task/StripAppliedMixins` 的逐来源 records/耗尽 config/metadata 删除路径，不创建第二 strip task。
- write owner：`StripMixins.kt`、`SelectiveConsumer.java`、`task/StripAppliedMixins.kt` 及必要私有 JSON reader/已有 publication 调用；`MixinPreapplicationTests`、`MixinSafeRetentionTests`、`LegacyStripMixinsTests`、`MixinInputBindingTests`、`OperationPublicationTests` 中相关 strip 调用/assertions。`SelectiveMixinConfigHandler` 和 Fabric/Forge 对应 listing/handler/interface/tests 仅在移除真实无用引用或维持 listing/applicability 所必需时最小联动，不改 metadata 内容或 Core ABI。
- verification/evidence：I02 真实产出信息→Transform 正例；同数组重复/跨三数组/跨 JAR 同键全删（另一来源未单独应用也删）、不同完整路径/原字符串及未通知键保留，包名展开/映射不拓宽匹配。compact/pretty、未知嵌套字段、剩余顺序、耗尽数组但 config/class/refmap/metadata/资源全保留；有效空及无匹配 config 内容不变，原输入不变。
- negative evidence：缺失/无效信息不是空集；畸形适用 config、不可精确编辑、unsafe ZIP path、写入/关闭/发布失败 outward exception 且不可消费。无来源/hash/section/index 唯一性或每条恰好一次条件；不继承旧安全重放/残留拒绝 assertions。局部参数/Transform fixture 不能代替 I04 真实 Gradle 注册与恢复。
- conflicts：与 I02 共交接 reader、publication、测试和运行副作用，已依赖 I02；与 I04 共 TestKit fixture/参数合同及运行/cache 副作用，I04 显式依赖本项。删除前核全调用；仍有真实保留使用方的 validation/listing helper 不删除。

### MAP-I04 — 使用方注册消费与组件缓存 fixture

- state: partial；wave: MAP-W04；prerequisiteItemIds: [MAP-I02, MAP-I03]。
- 已采用事实/evidence：Router 完整采用 `mixin-caller-cache-testkit` generation 1 业务 partial；外壳 completed 不替代语义。仅 MixinInputBindingTests.java＋pipeline-caller.gradle 新增六方法，最后实际两项 1 过 1 败，其余 4 未执行。公开 Transform probe 的参数/inputArtifact 单独变化、有效空及四个非法参数消费负例通过；真实 appliedA 在默认 cleanupFile 映射 own outputFile、producer 完成前求值被拒绝，未到完整流/Transform。无本项完整 caller/cache/失败闭包证据；W04 不满足、未释放。见 [Context 的实际方法/失败/证据限制](context.md#已采用的实施与验证事实)。初期参数/GString/home 锁仅 fixture 修正，生产 Provider 未修。以下原完成要求全部保留，由 R04 接续未完成边界；此 partial/原 Result 不 resume、不改 completed。
- 单一完成 predicate：已有 TestKit 使用方 fixture 通过公开 Task/Strip Transform 的 caller 注册/绑定/选用，建立当前组件的完整清理消费与正常复用闭包；applied-only 不冒充清理，required strip 失败传播且不报全流成功，连同 I02/I03 有效证据覆盖 Plan 对应 Spec 条件。
- scope/effects：caller fixture 显式注册 Task 及项目级 `registerTransform` 类型/参数/from-to 规则，绑定 tracked 清理输出 provider 和生产依赖，选 configuration/artifact view、请求属性并消费结果；不手动调用 strip 或另实现 JSON 编辑。Task 始终读 raw inputs，不读 strip view；完整流的 raw Mixin-source collection＋派生 target 全经 I03 同一 Transform/该操作清理信息，目标含配置不能漏。无 Codev 生产注册 helper/DSL/统一 provider/聚合出口、新集成框架、全 runtime 扫描、跨 operation 清单并集、来源库存或完整 module graph 保留要求。
- write owner：仅 Mixins `MixinInputBindingTests` 的已有 TestKit/project/runner fixture 及必要测试 resources/assertions；生产 Task/Transform 跟踪与参数由 I02/I03 负责，本项不修改生产 plugin/接线/publication 或新增生产 API。不改顶层配置/依赖版本、Cloche、D 盘消费工程或下游用途路由；发现生产缺口如实报告，不在 fixture 里代实现组件合同。
- verification/evidence：真实 TestKit 注册/传参/请求属性/消费，检查 Gradle provider/inputArtifact/parameters/build dependencies 到达当前 producer 与所需 strip。用 source config＋target 自含 config、resolution-only/无关 external config、两个不同 operation；观察 raw 输入原样、指定成员全清理、resolution-only 不扫、无环/无串清单。正常完整清理流实际调用目标并检查所有清理副本；单独请求 Task applied target 观察应用及尚未清理的配置，不报 stripped 或全流完成。分别让来源 strip、派生目标 strip 失败：受影响消费向外抛异常/不报全流成功，独立已完成的 applied target 仍按 applied 成果使用；producer/组件发布失败不能消费该组件半成品或旧成功，不要求任意其它 caller tasks 一起回滚。
- cache evidence：producer SUCCESS 暖缓存→仅移走本 fixture 自有 target＋信息→FROM-CACHE→无 producer 内存的首次 fresh Transform；随后分别验证 Task UP-TO-DATE、各 Transform 的正常缓存恢复/复用，实际检查组件内容及完整流所有要求的清理结果而非只看状态。plugin body/resource/config/mapping/environment、Transform 当前清理参数及 inputArtifact 单独变化获得对应当前结果。有效空信息单独成功；缺失/损坏/无效/陈旧信息须正常重建/恢复或拒绝，不得猜空、跳过所需 strip 或用旧 JAR。正常 cache 已覆盖的不造第二持久化/绑定协议。
- closure/evidence：采用 I02/I03 当前仍有效的真实引擎通知/原键、命名/隔离、JSON 保留及异常/IO/发布证据，补 caller 同链消费、缓存和当前输入变化的必要缺口；对照 Spec 当前条件，无未解释失败或遗漏才满足本项。观察真实目标处理输出不是认证引擎注入语义或全目标完成，不另开独立 native/终验证明单元。普通测试 XML/日志与小产物足够；旧 G1 绿测不映射新验收。
- conflicts：依赖 I02/03 的最新生产/参数合同，共享 TestKit fixtures 和运行/cache 副作用，必须串行；本项无生产写权。若公开组件注册、provider/参数/inputArtifact/build dependencies 或缓存不能满足合同，报具体 gap，不能绕过 strip、补 Codev 聚合层或让用户实现算法。

### MAP-R02 — 默认 cleanupFile Provider 的 producer 修复

- state: pending；wave: MAP-WR02；prerequisiteItemIds: [MAP-I02, MAP-I03]。
- 单一完成 predicate：public Mixin 默认 cleanupFile Provider 在真实 caller scheduling/output 查询时合法，不再发生自身 producer 完成前 mapped outputFile 拒绝，且保留 tracked target＋清理输出及必要输入/发布安全。
- scope/effects：修当前默认 Provider/必要 producer 私有绑定，沿用公开 Task 与已选 caller 接线；让现失败 regression 不显式覆写默认 cleanupFile 而通过。本项不选择新 API、隔离架构或公共接线 helper，不补全 I04 独立缓存闭包。
- write owner：仅 `minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt` 的 default Provider/必要 producer 私有绑定；`MixinInputBindingTests.java` 与 `src/test/resources/pipeline-caller.gradle` 的当前失败 regression assertions，必要直接受影响 producer 检查（如现有 `MixinProducerTests`）。不改 Core、engine/adapter/RecordData/publication 算法、生产 plugin/公共接线 helper、顶层配置/launcher 或 authority；私有绑定不扩为新框架。
- verification/evidence：在真实 TestKit 重现的 `testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations` 默认路径上验证 producer/output 查询及 applied-only 消费通过，观察 producer 到目标内容，不允许以 fixture 显式设 cleanupFile、手工 strip 或直接调用 task action 绕过 Gradle 查询。原方法中随后到达的完整流/独立 operation 断言保持，不删断言以求绿；它们不替代 R04 独立 cache/失败闭包。补必要直接受影响 producer 输出声明/跟踪及输入保护检查，保留 target＋cleanupFile 为 outputs，不降低安全。完整新 Result 记录实际 selectors/结果、变更与未覆盖；普通日志/XML/最小产物即可，现无修复成功证据。
- conflicts：依赖 I02/I03 completed 及 W02/W03 的有效组件合同，在 I04 partial 既有修改上最小修复，不要求 I04 completed。不与 I04 resume 或 R04 并行；共享测试源码/fixture、默认输出行为和 Gradle/cache 副作用由 R02→R04 及 WR02→WR04 显式串行。R04 不修生产；若再见生产缺口如实报告，不把它藏入测试绕过。

### MAP-R04 — 原 caller 未完成边界的 recovery

- state: pending；wave: MAP-WR04；prerequisiteItemIds: [MAP-I02, MAP-I03, MAP-R02]。
- 单一完成 predicate：补齐原 MAP-I04 尚未满足的完整 caller 注册消费/cache/失败闭包，与当前仍有效原 probe、修复及组件证据一起覆盖原 I04 全部完成条件，无验证削减或未解释失败。
- scope/effects：从既有六个新增 TestKit 方法及 caller resource 接续未完成边界，沿用原 I04 的 scope、verification/cache/closure 要求。它是新 Handler/新独立 Result，不 resume 原 partial、不重写 I04/W04；完成 R04 不自动把旧 W04 放行。不能用 R02 默认回归 green 宣称此闭包完成。
- write owner：仍仅 Mixins `MixinInputBindingTests.java` 的既有 TestKit/project/runner fixture 与必要 test resources/assertions（含 `pipeline-caller.gradle`）；不写生产 Task/Transform/plugin/publication、公共 API、顶层配置/launcher、authority 或其它消费工程。不能在 fixture 代实现组件算法或掩盖默认 Provider。
- verification/evidence：补齐真实 caller 的公开 Task/项目级 registerTransform、参数/from-to 属性、cleanup provider/producer references/build dependencies、configuration/artifact view 请求和实际消费。producer 只读 raw inputs；完整集合严格是本 operation raw sources＋派生 target，同一 Transform/清理信息，含 target config；resolution-only/外部 config 不扫，多 operation 不串集合/清单、无环。调用真实处理目标、检查全部要求的清理副本与原输入不变；正常 applied-only 只报告 applied，不冒充 stripped/完整清理。
- cache/失败 evidence（同一闭包的必要观察）：producer SUCCESS 暖缓存→仅移走本 fixture 自有 target＋cleanup→FROM-CACHE→无 producer 内存首次 fresh Transform；随后 Task UP-TO-DATE、每个 Transform 正常缓存恢复/复用，检查内容与完整流全部成员而非只看状态。plugin body/resource/config/mapping/environment、Transform 参数及 inputArtifact 各自变化取得当前结果。有效空与缺失/损坏/无效/陈旧交接分别检查，后者正常重建/恢复或拒绝，不能猜空或用旧 JAR。分别 fail 来源 strip、派生 target strip 和当前 producer/组件发布：受影响消费抛异常、不报全流成功、不消费半成品/旧成功；独立已完成 applied target 仍仅按该成果消费，不要求任意 caller tasks 事务。
- closure/evidence：对照原 I04 全部 verification/cache/closure 及 Spec 当前条件；明确六个新增方法哪些已补跑、哪些证据复用及适用性，补其余实际缺口，不以 fixture 存在、probe 负例或组件 green 代替链路。复用 I02/I03 有效通知/映射/隔离、JSON/资源保留和异常/IO/发布证据，R02 变更影响则补相应检查；不新增 native 注入语义/全目标完成或重复终验。新完整 Result＋实际普通日志/XML/必要小产物才供 Router 判断 WR04，本次尚无这些结果。
- conflicts：显式依赖 R02 completed、MAP-WR02 satisfied 及 I02/I03 有效合同；与 R02 共测试/fixture、Provider 合同及 Gradle/cache 副作用，必须串行。I04 partial 只是已采用历史，不列 requiring-completed 前置或待 resume 写 owner。本项不扩大生产写权，后续发现不满足合同的生产缺口须保留失败/限制，不能补聚合层、绕过 strip 或让 caller 实现算法。

## 恢复验证安排与证据边界

以上为未来验证安排，本次均未运行。cwd 为 Codev 仓库，沿既有 Gradle 9.4.0、launcher 17、fixture `--release 11`、pluginUnderTestMetadata 与 JUnit/TestKit；不安装、升级、清缓存或切换参考树。新 items 仅选择实际受影响方法/suite，不因图细化重跑完整旧 G1 或无变化组件。

- R02 最小入口为当前失败的 `MixinInputBindingTests.testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations` 默认链与必要受影响 producer 检查；原断言不削减；若未来 R02 实际通过后取得完整流观察，仍有效时可归入 R04 closure，但不能据此宣称全部 cache/失败完成。
- R04 采用仍有效的 `testKitTransformTracksParametersAndInputArtifactIndependently` probe 与 R02 regression，补齐原未执行的 `testKitProducerCacheRestoreThenFreshAndRestoredTransforms`、`testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput`、`testKitFailedCurrentProducerCannotRouteOldSuccess`、`testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption` 及其未覆盖的原 predicate 必要断言；不能仅凭方法名或编译通过认证 closure。
- 保留 [Context](context.md#已采用的实施与验证事实) 所引 `map-i04-focused.log` 原失败日志；恢复运行宜另名普通日志，不覆写原件，不增快照/备份包、整包复制、receipt/digest/冻结台账。常规 XML 可被后续正常测试覆盖，记录需分清读取时事实与未来结果，不保证完整原件永久可取回。
- 若候选变化，只补受影响证据；Fabric/Forge/AW/AT/patch/nested-JAR 原要求保持但不预设全平台/旧 Core 编译矩阵，不借恢复修无关 lint/Forge patch。缺真实 prerequisite 如实报告限制，不改变合同或支持范围。

