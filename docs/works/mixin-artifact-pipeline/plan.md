# Mixin Artifact Pipeline Plan

[Work](work.md) · [processed Context](context.md) · 唯一匹配执行图：[Waves](waves.md)。本 Plan 无 overview、slice 或 Tasks；执行分解只在 Waves。

**状态：Implementation confirmed / in progress；C5 同范围恢复。** 用户已明确确认原三项完整披露范围及正常本项 Gradle/fixture 自有 outputs/cache。Router 已采用 I02/I03 completed、W02/W03 组件范围 satisfied；I04 partial、W04 不满足且未释放，见 [实际事实与证据](context.md#已采用的实施与验证事实)。本次仅维护派生文档，不执行恢复代码或测试。现行 Plan 结果须共同满足 **MAP-W02、MAP-W03、MAP-WR02、MAP-WR04**；原 MAP-I04/MAP-W04 历史不重写，不作为恢复路线终点 gate。所有新修复/recovery item 和 gate 均 pending，文档检查不释放它们。

## 目标、权威和非目标

Codev 实现并执行真实预应用 Task 与逐 JAR 精确 Strip Artifact Transform：收集引擎应用通知，通知即取得 config 完整资源路径＋数组原字符串的清理资格，精确删除该键全部匹配项，未通知键保留。供 caller 注册、绑定清理信息/生产依赖、组织同操作 raw 来源＋派生目标集合并选择 configuration/artifact view 与消费结果；caller 无需自行实现 strip 算法。受限 TestKit 使用方 fixture 验证请求完整清理流取得真实应用目标及全部要求的清理副本，也验证正常 applied target 可独立消费但不能冒充 stripped/全流完成。输出用途由 caller 决定。按当前 Spec 派生一个连贯最小实施范围，不继承旧 G1 许可或验收。

| Family / owner | 处置、路径与依据 |
| --- | --- |
| PRD / Codev 产品边界 | **reuse** [Codev Mixin Rework](../../prd/codev-mixin-rework.md)：正文/R4/R5/R6/AC4/AC5/AC11 已明确通知即清理，区分算法与 caller 职责、组件/请求完整流及缓存/失败；保留 PRD 生效（Active）状态，不改变状态。 |
| Spec / `minecraft-codev-mixins` | **reuse** [Mixin Pre-application](../../spec/mixin-preapplication.md)：通知即资格、完整 config 路径＋原字符串全匹配、Task/逐 JAR Transform、同操作集合、tracked 交接与 caller 注册消费已固定；正常 public producer/provider/cache、独立 applied-only 和请求完整流合同已覆盖默认 Provider 缺口，不要求自动接线/统一出口，无需重复写 authority。 |
| ADR / 操作隔离 | **reuse** [mixin-operation-isolation](../../adr/mixin-operation-isolation.md)：fresh loader、加载域、锁定引擎和映射链继续有效，当前适用注释已同步；旧 selective 政策不覆盖当前 Spec，不另立决定。 |

不做 Codev 生产侧自动注册、自动选择配置、注册 helper/DSL、统一 artifact provider/聚合出口或新集成框架；不编辑 Cloche/外部消费工程。不做旧 API/records 兼容、公共诊断/证明协议、用途路由、完整 module graph 保留、全 config/class/refmap/metadata 删除、引擎升级/额外字节码改写、支持子集裁剪或新隔离架构。不改 PRD/Spec/ADR、旧图/历史结果、指南/README、无关 Core/Forge/缓存框架；不恢复旧 Core 测试，不撤回未知作者改动，不写参考工作树。

## 最小策略与 owner

生产写域以 `minecraft-codev-mixins` 为主，具体文件定位见 [Context 的 owner 表](context.md#现有-owner-与实际差距)。保留既有层次和测试入口；普通类名、私有方法、内部文件名由实施承担，不另设审批文件。以下策略保留原完整交付合同，不是将已完成组件重新排成待执行。

**恢复策略。** 先在 public Mixin producer 的默认 cleanupFile Provider/必要私有绑定处消除真实 caller scheduling/output 查询时的 own-output 映射拒绝，保留 target＋清理输出跟踪与输入/发布安全；默认 regression 不显式覆写 cleanupFile 掩盖失败。再由既有 TestKit owner 补齐原 caller 注册消费、cache 与失败闭包，采用仍有效 probe/修复/组件证据；不把生产修复和独立缓存闭包合成一个 Handler，也不以组件 green 抵消 caller 失败。精确前置、写权、冲突、predicate/evidence 仅见 Waves。此为 Router 已选的同范围 C5 细化，不新增需求/架构/用途/API 兼容决定，无需新 authority 或重复确认。

- **producer 通知与交接。** I02 已在组件范围实现现 Task/Runner/runtime/adapter 的通知交接；保留策略为：真实调用锁定 `0.15.0+mixin.0.8.7`；优先沿既有 native 扩展/回调机制收集引擎应用通知，保留 config→原 strings（包名展开/映射前），跨 loader 仅传共享 JDK 简单值/集合，Task 写出小型内部清理文件。具体 hook/API 和表示是本项有界实施细节，不新增独立 native 能力/完整性证明单元或 gate。通知即资格，不核实全目标完成、无报错、注入正确或最终字节效果，也不以 transform 正常返回作资格条件；发现/prepared 候选不能替代通知。未知归因不编造键，未通知键保留，其它位置失败/部分/unknown 不取消已通知键。目标＋信息经自身写入、资源关闭、runtime 退出和发布成功才成为 tracked Task outputs；这是组件生产边界而非再次证明应用资格。合法无通知可产有效空集，不能把合法通知永久记 unknown 充完成；引擎直接异常自然向外失败，不吞异常。
- **逐 JAR 精确编辑。** I03 已完成 `StripMixins` 的公开 cacheable per-JAR Transform 及精确编辑；保留策略为：参数取当前 operation 的 tracked 清理文件；逐 `mixins/client/server` 数组按两个原值精确过滤，所有同数组/跨数组/跨 JAR matching 一起删除。不用 section/index/source/hash/绝对路径匹配，不增加重复拒绝或逐来源复验。另一物理来源同键不同实现未单独执行也删是已接受代价，不重新询问。
- **使用方注册消费 fixture。** I04 已新增 fixture，但真实 applied-only 在默认 Provider 求值失败；未执行/未通过部分仍须 recovery 验证。合同不变：在已有 TestKit 中由 caller 显式注册公开 Task 与项目级 `registerTransform` 类型、参数和 from/to 属性规则，绑定 Task 清理输出 provider，并选择 configuration/artifact view 请求属性和消费。producer 始终读 raw target、raw sources、raw resolution；完整流的 strip 集合严格为 raw sources＋Task 派生目标（含目标自带 config），不是 raw target 或整个 runtime。每 operation 的参数独立，不并集清单、不读自身 strip view 或形成 provider 环；以 Gradle provider/inputArtifact/build dependencies 验证当前生产关系，不引入 Codev 接线层或下游路由实现。
- **组件完成与请求完整流。** Task target＋小型清理信息以及每个 Transform 输出各在自身处理/写入/关闭退出/发布成功后才是完成成果。caller 可消费正常完成的 applied target；请求完整清理流则选择并消费全部所需 Transform 结果，目标含配置也须清理。required strip 失败只阻断受影响消费且不能报全流成功，不否定独立完成的 applied target。沿 Gradle 依赖和现 publication 保护验证，不实现统一双出口、全局 ready 谓词、第二公共 strip task 或任意 caller tasks 的事务。

已采用 I02/I03 实现将旧 `SelectiveConsumer` 的 source/digest/展开名消费、`StripAppliedMixins` 的耗尽 config/metadata 删除，以及 runtime 的 partial/dynamic/attempted 整次 selective 拒绝替换为通知驱动路径；旧政策不能原样认证新合同。Mixin 日志由使用者阅读，Codev 不扫描日志裁定成功；仅日志报错或部分应用但正常返回不自行转失败，也不撤销已通知身份。删除仅限本轮确被替代且全调用检查无保留使用方的路径；不兼容旧 records/API。`RecordData` 仍被 Fabric listing/handler 使用的 path/JSON 校验、引擎 pin、真正输入解析/类与资源一致性保护须保留或原位拆出，不能连同旧 records 一刀删除。

Fabric/Forge owner 只在必要 listing/applicability 或退役接口引用受到影响时作最小适配；保持发现范围和实际加载优先级，不再要求清理去调用 metadata remove。不得扩至 Core ABI/Loader metadata 改写或无关 Forge patch。触及的 AW/class-tweaker、Fabric AW、Forge AT/patch/nested-JAR 行为须保持；未触及不重认证。

## 缓存、保护及验证安排

Task inputs 保留有序 raw 来源/完整 runtime（含 plugin bodies/resources）、effective side/options、实现依赖、mapping 内容/方向和 refmap context；不退回 `@CompileClasspath`。Task target＋清理文件、每 Transform inputArtifact/参数/输出均受跟踪；caller fixture 保留消费所需的 producer/provider 与 build dependencies。采用正常 Gradle 输入/缓存依赖防陈旧，不造绑定摘要、来源副本库存或恢复平台；缺失/无效/陈旧信息须重建/正常恢复或失败，不能默认为空。

沿用 `OperationPublication` 输入 real-path/别名/hardlink/目录包含保护、先校验后破坏、独占所有权、临时写入和失败传播；保留 TCCL finally 恢复、loader/stream/ZIP 关闭及 ZIP `/` 路径安全。原 target/sources/resolution/mapping 不变；JSON 未知字段/剩余值和顺序、空 config、类/refmap/metadata/无关资源保留，空移除不改 config 内容。无沙箱、任意下游安全或吞吐收益承诺。

验证以 [Spec 当前条件](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions)为准。下表保留原完整验证安排，不冒充全部已执行；实际已采用的方法、结果和限制以 Context/Waves 的事实记录为准。恢复只补当前缺口与变更影响，不重跑无变化证据：

| 窗口 | 最小实质观察 / 现有 fixture owner |
| --- | --- |
| producer 通知/交接 | `MixinFailureStageTests`、`MixinPreapplicationTests`、`MixinOperationIsolationTests` 的真实小类/JAR/plugin：观察 Codev 真实调用引擎及通知到 config/原字符串准确映射、loader 关闭后交接、组件写入/关闭/发布、空集与异常、隔离/重试；调用完成目标观察实际处理输出，不把效果断言用于判定清理资格。真实 fixture 覆盖多目标条目某处通知而其它处部分/失败/unknown 且正常返回，通知键仍保留资格；仅日志报错不自行失败，直接异常传播。plugin/字符串 target 只检 Codev 输入/归因路径，不重建或认证 native 义务。 |
| 精确 JSON 清理 | `MixinPreapplicationTests`、`MixinSafeRetentionTests` 等：改旧 selective/records assertions 为新合同；以通知信息驱动多数组/跨 JAR 全删、不同 key/未通知 key 保留及 config/资源/顺序保留。`MixinMappingTests` 保留真实 remapper 链，不能只测字符串；命名测试不另证引擎语义或全目标完成。 |
| Gradle 使用方消费 | `MixinInputBindingTests` 现 TestKit fixture 显式注册/传参/选 configuration 或 artifact view/请求属性/消费：provider、inputArtifact 与 build dependencies 可跟踪；target 自带 config、resolution-only 排除、多 operation 不串/无环。正常完整清理与 applied-only 消费分别成立；fail 来源 strip、目标 strip、producer/组件发布时受影响消费抛出异常且不报全流成功，独立完成的 applied target 不伪称已清理。 |
| 正常复用与安全 | 同 TestKit 的 producer SUCCESS→target＋信息 FROM-CACHE→首次 fresh Transform，再验证每个 Transform 恢复及 UP-TO-DATE；无 producer 内存仍可消费当前组件结果，完整流执行/复用全部所需清理。plugin body/resource/config/mapping/environment、Transform 当前参数/inputArtifact 变化须取得对应结果；有效空信息与缺失/损坏/无效/陈旧信息分别检查，后者正常重建/恢复或失败不能猜空。仅日志报错但正常返回、引擎抛异常、取消/写入/关闭/runtime exit/发布失败与 retry 配合 `OperationPublicationTests` 和原输入保护。 |

具体 selectors、每 item 写权与证据在 Waves。复用 test launcher 17、fixture `--release 11`、pluginUnderTestMetadata、JUnit/TestKit 及现 wrapper 9.4.0；不下载/启动游戏，不安装依赖/工具或先清缓存。仅保留普通测试 XML/日志和断言必需的小 JAR；保留 `map-i04-focused.log` 原失败日志，恢复运行宜另名普通日志、不覆写它。常规 XML 可被后续正常测试覆盖，不当作永久原件；不增快照/备份包、新采集器、整包复制或审批/证据台账。旧 fixture 的大范围 retain helpers 不作为新证明要求，不顺手重构。

## 关键代价、停点和完成信号

- 通知不保证全目标效果、无报错或最终注入正确；即使另一目标/物理出现位置未完成，同键仍全部删除，这是已接受代价，不是风险 stop gate。用户读 Mixin 日志评估应用问题；不加独立完整应用实证、不将同一证明藏入组件测试。
- 通知/精确原键归因、JDK 跨 loader 和精确 JSON 组件检查已采用 I02/I03 证据；默认 Provider 在真实 caller 调度失败，完整 caller/cache/失败闭包仍缺证，不能将旧 green 扩大为全链实证。修复与 recovery 只检查 Codev 的行为，不另设“先证明 Mixin”前提。若确需额外引擎字节码改写、重要依赖/架构变化、支持收窄或变更当前合同，报告具体缺口并停止 affected scope；此计划未接受这些方案。常规 hook/API、内部命名/序列化与使用方 fixture 参数绑定不另造确认门槛，也不接受新增 Codev 注册/交付 helper。
- 每操作 fresh loader、逐 JAR Transform 和 caller 参数/属性依赖有执行/配置成本；公开组件可注册、Gradle 参数/inputArtifact/build dependencies 与组件缓存必须用真实 TestKit 证明。若现机制无法实现合同，报告具体 gap；可用 applied target 不是降级的 cleaned 成功，不能绕过要求的 strip 或只交名单让用户实现算法。
- 不沿旧 records 做迁移；新旧 API 使用方必须随所替代路径迁移。工作树含混合改动，写前核对当前调用者，只修改本范围；回退仅撤本轮自有 diff（需要相应许可），不全树还原、不清缓存、不动旧 G1 accepted/closed 或失败/unknown 历史。

最终完成信号：MAP-W02、MAP-W03、MAP-WR02、MAP-WR04 以各自完整 Result 和实际证据共同满足，真实引擎通知/精确原键映射、真实输出调用/精确 JSON 清理、caller fixture 的注册/绑定/选择消费与同操作集合、组件发布及受影响消费失败传播、applied-only 不伪报完整清理和当前输入无内存缓存恢复均成立。最终集成 gate 复用 producer/strip 仍有效的组件证据并检查使用方闭包，不另立重复终验单元，更不认证 native 完整性。不能仅凭测试存在、静态检查、Plan prepared、Resolver 成功或旧 G1 绿测宣告完成。当前原完整范围已确认且实施中，但新修复/recovery 全 pending，生产缺口尚未修复；不能将此文档修订视为新 Result、gate release 或 runtime 调度。原 I04 partial/W04 未释放保留，R04 是接续未完成边界的新独立 Result，不 resume、不改 completed，也不在 R04 完成后自动放行旧 W04。
