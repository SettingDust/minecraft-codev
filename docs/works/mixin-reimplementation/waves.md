# Mixin 重实现 Waves

[Work](work.md) · [Context](context.md) · **唯一匹配 [Plan](plan.md)**

本图只建立该 Plan 的“新 Task/独立精确 Strip、必要旧路径退出及真实 caller/cache 同链消费”结果；不是旧 pipeline repair/recovery 的继续图。Router 已采用现有类型名范围及 C6 原生选项简化确认，PRD R3 / Spec 必要澄清已完成，原 ADR reuse。Router 已采用 **MRI-R02:g1 completed / MRI-WR02 satisfied** 和 **MRI-I02:g1 completed / MRI-W02 satisfied**，保留当时独立核对 membership、前置及 evidence/release predicate 的判断；R02 的 whole producer 判断仅覆盖当时实测输入与组件场景，**不覆盖本次暴露的 target-owned Mixin class dispatch/preservation 缺口**，不再据此宣称当前 producer 全覆盖。Router 已从 full join 完整读取并关联 `mixin-real-caller-cache-reimplementation:g1` / **MRI-I03:g1**，采用业务 **partial**（backend completed 仅表示调用终结）；**MRI-W03 pending/未释放**。原 I03 完整 predicate/owner/verification 与前置保留历史，不作为新路线的 completed prerequisite。当前同范围恢复仍为 **MRI-R03→MRI-R04**：Router 已完整读取并关联 `mixin-target-owned-class-dispatch-repair:g1` / **MRI-R03:g1 completed**，并独立判 **MRI-WR03 satisfied**；**MRI-R04:g1 completed / MRI-WR04 satisfied** 已由 Router 采用/提供判断，结合 WR02/W02/WR03 三个既有 satisfied gates 建立当前选定 Plan 完成；本 writer 只记录 supplied judgement，不重判其它 gates。I01 blocked、R01 partial 与 W01/WR01 pending/未释放不变。采用事实与限制见 [R03 Context](context.md#mri-r03-completed-事实与独立-gate-判断)。 一 item＝一 Handler＝一个完整 Result；实际证据见 [R02 Context](context.md#mri-r02-completed-事实与独立-gate-判断)、[I02 Context](context.md#mri-i02-completed-事实与独立-gate-判断)与 [I03 partial/缺口](context.md#mri-i03-partial-事实与目标内-mixin-class-缺口)，下面 required evidence 仍保留，不以验证安排替代实际证据。

## 唯一执行图

| Wave ID | gateState | itemIds | predecessorWaveGates | incremental outcome / release predicate |
| --- | --- | --- | --- | --- |
| MRI-WR02 | satisfied | [MRI-R02] | [] | 剩余 producer 在复用 R01 有效 baseline 后建立 whole producer：raw 输入真实引擎、准确文件与安全输出，原生输入观测/专用参数/mapping、拆旧证明编排/只读平台迁移及当前 Spec 适用证据满足；R02 completed 且独立完整 Result 结合仍有效证据覆盖全部 producer predicate。R01 partial 不是前置 gate，新结果不满足旧 R01/WR01。 |
| MRI-W02 | satisfied | [MRI-I02] | [MRI-WR02] | 独立逐 JAR Strip 仅按移除文件精确编辑，必要旧 strip/fixture 路径退出；I02 completed 且全匹配/保留/真实 I/O 与平台边界检查满足，不要求其输入由预应用产生。 |
| MRI-WR03 | satisfied | [MRI-R03] | [MRI-WR02, MRI-W02] | 局部 producer archive dispatch/preservation 修复成立：目标自带 config/Mixin 定义仍在，普通目标经真实引擎、应保留内容与准确通知/输入保护成立，现失败真实 caller regression 通过；R03 completed 且其独立完整 Result/全部 focused evidence 满足，不要求本 gate 完成全部 cache 或重复全组件。 |
| MRI-WR04 | satisfied | [MRI-R04] | [MRI-WR02, MRI-W02, MRI-WR03] | 修复后剩余真实 caller/cache 闭包成立：R04 completed 且原 I03 五组要求所有尚未实际执行部分已有实际全链当前内容、失败/变更/无内存正常复用证据，结合仍适用 R02/I02/R03 覆盖 Plan；无遗漏或未解释失败。不依赖 I03 completed/W03 释放，不自动满足旧项。 |

活跃 Plan 结果要求 **MRI-WR02、MRI-W02、MRI-WR03、MRI-WR04** 共同满足，R04 即自然集成门槛，无重复终验 item。WR02/W02 的 satisfied 与 R02/I02 completed 保留当时实测组件判断，WR02 表中的 whole producer / Spec 适用证据仅指当时覆盖；新 target-owned Mixin class 场景的局部修复由独立 R03:g1 completed 补充，不以旧判断代替。Router 已独立核 WR03 唯一 member R03、R02/I02 completed 与 WR02/W02 satisfied 显式前置及 R03 三组 evidence/release predicate，判 WR03 satisfied。Router 又完整采用 R04:g1 completed，核最新 tuple、WR04 唯一 member R04、R02/I02/R03 completed、WR02/W02/WR03 satisfied、原五组 evidence 与 release predicate，提供 WR04 satisfied 判断，与三个既有 gates 共同建立当前选定 Plan 完成。本次仅记录 supplied 判断，不自行重判或追加许可。原 W03 移入历史、仍 pending/未释放。Wave/item 前置是显式真实依赖，显示顺序或编号不额外建立门槛。只有各 item 的 completed＋足够证据及 gate predicate 成立，Router 才能释放显式依赖；partial/failed/blocked/missing 以及仅 backend/display success 均不释放。此图不管理自动调度/重试/确认协议。

## 所有 items 的共同边界

- 依据 [Plan](plan.md) 的范围/API/去留/验证安排和 [Context](context.md) 的现状；authority 为 [PRD](../../prd/codev-mixin-rework.md)、[Spec](../../spec/mixin-preapplication.md)、[ADR](../../adr/mixin-operation-isolation.md)。共享只读权威不冲突。条款以 Spec 当前标题为准，不借历史 C/A 编号解释当前要求。
- 路径以下以 `minecraft-codev/` 为根；`J/K/T/F` 分别指 Mixins 的 `src/main/java/net/msrandom/minecraftcodev/mixins/`、`src/main/kotlin/net/msrandom/minecraftcodev/mixins/`、`src/test/java/net/msrandom/minecraftcodev/mixins/`、`src/test/resources/`。只在声明 owner 内修改直接调用/生成源码/字符串/SPI/fixture；新增私有实现就近放置，不凭类名强留旧图。
- 输入/输出与资源保护、JDK 跨 loader、真实异常 cause、effective settings/mapping、精确原键、正常 tracked file/cache 是不可削减的职责。正常引擎报错日志/部分应用不自行转失败或撤销已通知键，不解释日志/验证全部应用。通知资格与写入/关闭/runtime exit/发布完成分开。
- 禁止改 PRD/Spec/ADR、旧 G1/旧 pipeline 四文档或结果、Core/includes 通用 ABI、运行配置、CompileJar/toolchain、无关 lint/Forge patch、Cloche/D 树。不得 reset/清未跟踪、做兼容 bridge/来源账本/额外证据系统或自动生产接线；未知作者改动保持。
- 现有类型名与原生选项简化范围确认均已由 Router 采用，必要权威澄清已完成，无新增 options 决策/权限待定；后续执行仍需相应权限及 prerequisites/gates，派生文档不提供新许可。通用选项无 public raw override、独立快照或 getter 适配，原生宿主/default 行为及内部输入观测沿当前 Spec；专用 side/mapping/context、无全局属性污染合同不变。未来沿现有受影响 Gradle/fixture 的普通 build/test/temp/cache 及小 JAR；本次文档维护不运行这些。无安装/升级/清全局缓存/Git 写入。证据只需真实 selectors/结果/内容断言/普通日志/XML 与限制，不新增报告包、快照或 receipts。
- 活跃组件与恢复项共享 runtime、API/文件格式、tests/fixture 及普通 Gradle/运行/cache 副作用，**R02→I02（既有成果）后 R03→R04 串行**，在最新树上修改/运行，不按文件数拆 item。R01/I03 partial 是已采用 baseline/失败输入，不作为 completed prerequisite；R03 消费 R02 producer 与 I02 Strip 供现失败真实 caller regression，R04 消费修复及组件以闭合 caller/cache。禁止旧 repair、原 partial Handler 或任何共享 owner/运行/cache writer 并行；共享只读 authority 不构成冲突。
- 若发现必需权威缺口/重要设计改变，按 Plan 停止受影响范围，加载 `spec-driven-development`，返回具体条款、选择和影响；不修改 authority、不降低支持/验证。普通内部命名/局部 helper 不新增门槛；缺工具/权限则据实返回，不能绕过真实 caller 或在 fixture 代实现生产合同。

## 活跃 Item 定义（唯一执行分解）

### MRI-R02 — 单一剩余 producer 恢复

- state: completed
- wave: MRI-WR02
- prerequisiteItemIds: []
- 采用与覆盖限制：R02:g1 completed / WR02 satisfied 是当时原 scope 与实测组件输入的历史独立判断，保留下述 predicate/owner/evidence；I03 后新发现目标内 Mixin class dispatch/preservation 尚不成立，不能把历史 whole producer 表述当当前全覆盖。该缺口另由 R03 承接，不 reset 或重开 R02/WR02。
- 恢复关联：MRI-R01:g1 已终结为 partial，已完成命名/default/插件/旧 host 与注册退出及直接引用迁移；这些是已采用事实与复用 baseline，不是 completed prerequisite。R02/WR02 无 item/gate 前置，承接原 R01 全部未完 producer 职责及当前 Spec 所有适用 verification。一个 Handler / 一个独立完整 Result 结合仍有效基线建立 whole producer；不重放已完成改名/删除副作用，不改写或自动满足 R01/WR01 或 I01/W01，不拆参数研究/hostprops、完整应用证明或重复终验。
- 单一 completion predicate：新公开 producer 能从声明的 raw 输入产出已完成、受跟踪的 applied target＋准确原键 appliedMixins，专用参数、原生选项/default 与内部输入观测、命名/隔离及失败安全满足当前 Spec，且不再依赖旧 host/RecordData 证明编排；独立默认输出在 producer 执行前可合法查询。已完成 baseline 与剩余实现一起满足 whole producer，不能凭局部 green 完成。
- scope/effects：按同一 Plan 保持现有 `task.Mixin` / `StripMixins` 与文件合同，复用 R01 已落地 appliedMixins tracked output/独立 buildDirectory defaults、空插件和旧 host/SPI/Groovy 退出，不再执行命名/删除。去 public engineOptions/operationScope、Side enum 与 manual ordered 来源 identity/proof 角色；简单 side 与专用 mapping/context 真实生效，通用选项沿 Mixin 原生宿主/default 读取，内部只观测实际影响输出的相关属性及未设置/default 输入，不写/泄漏全局属性。拆 RecordData 并重建最小 Task/host/runtime 编排，不套壳，不保 options 复算/相等校验、长参数/重复 discovery/binding/来源摘要；保留真实有序解析、fresh loader/task class-resource/native service、精确 remapper、通知原键、跨 loader JDK 值、资源退出和安全发布职责。
- 必要连接：Mixin listing 改为只读 config/环境发现，平台与 test SPI/fixture 同步；保留 Fabric/Forge 的路径/环境/parent/manifest/TOML 读语义，移除 selective/all-delete metadata writer、`SelectiveMixinConfigHandler` 及旧单独 applicability 接口，绝不改 Core 通用 `remove`。为删除 `RecordData`，精确编辑器只迁移必要 file/JSON/path helper 调用，原算法不在本项另作 Strip 完成声明。所有生产调用/测试动态源码/反射与 proof 形状断言同步到可编译状态，不留临时兼容容器或悬空注册。
- write owner：K `task/`、`MinecraftCodevMixinsPlugin.kt`、`MixinListingRule.kt`、`SelectiveMixinConfigHandler.kt`、`mixin/`；J `OperationRunner`、`runtime/`、`MixinConfigApplicability`、必要 `OperationPublication` 及 `SelectiveConsumer` 的 helper 引用；Mixins `src/main/resources/META-INF/` 中对应旧服务/扩展注册。Fabric/Forge `src/main/kotlin/.../{fabric,forge}/mixin/` 与各自 `META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule` 仅上述发现/清退迁移。T/F 及平台 `src/test/.../mixin/` 的相关调用/SPI/断言；`pipeline-caller.gradle` 仅新 Task/API/default smoke 必需迁移，非整链补验。模块 `build.gradle.kts` 仅实际插件/必要测试注册一致性（如确需），不改依赖版本、根构建/lockfiles。
- constraints：不把候选当通知、不永久丢弃可归属通知，不按 source/hash/section/index 做资格；保留真正执行输入歧义/资源遮蔽错误而非一律重复拒绝。专用 side/mapping/context 显式设置实际生效，不靠与继承值相等或改 JVM 全局属性；通用选项无 public `engineOptions` / 等价 raw override，不注入独立快照、不重算原生规则、不做相应 getter 字节码适配。内部仅跟踪实际影响输出的宿主属性及相关未设置/default，不冻结载体/枚举/序列化/缓存算法，不扫描无关全 JVM 环境；Codev 不写/泄漏全局属性，无 mapping 不强启 `REFMAP_REMAP`。不在 fixture 显式设 appliedMixins 默认路径或造空文件代替 producer。
- required evidence / 最小 verification：以下继承原 R01 全部 producer 要求与当前 Spec；已有 default/provider/SPI/package 与 20-tests 只在输入/实现/环境及覆盖仍成立处复用，相关实现改变则按适用要求重新验证，不冻结旧 green、不要求无变化重测。尤其不得漏掉剩余 mapping/refmap/context、failure、native 观测一致/无污染、平台 metadata 保留与触及 AW/AT/nested-JAR 检查。
  1. 真实引擎小类/JAR/plugin，经新入口读指定 raw target/sources/runtime，调用完成输出并读关闭 loader 后的文件；发现/候选不造键，多数组原串/完整路径、parent、动态无原键、有效空、重复等内容来源与真正冲突输入分别检查。多目标某处通知而另一处失败/部分/unknown 且正常返回仍收原键；仅日志报错不另判失败，直接异常传播，日志由用户读。
  2. 沿现 `MixinProducerTests`、`MixinPreapplicationTests`、`MixinMappingTests`、`MixinFailureStageTests`、`MixinOperationIsolationTests` 的有效场景改新 seam：真实 owner/overload/refmap/context、双向/null/unmapped/歧义、非法 tuple/方向；task-only class/plugin/resource 优先级、runtime 不 discovery、专用 side 和原生宿主属性/default 的实际选项行为。包括显式 context 不同于继承默认实际生效，而非拒绝差异来保旧断言；观测与实际原生读取一致，宿主属性未被 Codev 污染，不要求同 JVM 各 Task 独立 raw 值。
  3. 同 JVM A→B、失败重试、并发对串行/冲突目的地、TCCL 恢复及实际 JAR 可释放；取消/写入/关闭/runtime exit/发布异常阻断当前半成品和 stale success。Codev 失败经日志/向外异常标明阶段、已知 config/target 和底层 cause，未知归因明确，不吞反射包装原因。复用/迁移 `OperationPublicationTests` 的 alias/realpath/hardlink/目录保护，实际原输入不变。平台 focused tests 检只读发现/环境与 metadata 未改及触及 AW/AT/nested-JAR 行为，不保旧 metadata 删除断言；原未执行的 MixinFailureStageTests 与 mapping/refmap/context 条件仍需覆盖。
  4. 保持 Task 两 tracked outputs 并完成全部有效输入（含相关继承属性/未设置/default 状态）、完整 runtime 与实现依赖声明检查；真实 TestKit applied-only **不覆写两个默认 outputs**，执行前查询/调度并消费真实 applied target，以及仅改 outputFile、appliedMixins 用默认的要求不变。R01 两场景已通过，相关实现未变且覆盖仍有效则复用，否则定点复验；不回放命名/default 修复。此 smoke 不宣称完整 caller/cache。记录实际 selectors、结果和迁移引用搜索（含 ServiceLoader/反射字符串/扩展注册），不以编译或注解检查独立代替运行证据。
- conflicts：与 I02 共 file reader/path、编辑器、发布和测试；与 I03 共 API/defaults、caller resource 及运行/cache。I02 显式依赖 R02/MRI-WR02；I03 不能与之并行。平台只读 seam/旧能力退出一并交付，不把不编译树交给后项或强留原容器。

### MRI-I02 — 独立精确 Strip 与旧清理路径退出

- state: completed
- wave: MRI-W02
- prerequisiteItemIds: [MRI-R02]
- 单一 completion predicate：公开逐 JAR Strip 从有效移除文件恰删指定 config 数组内全部精确匹配并保留其余内容，真实非法输入/I/O/关闭/发布失败无可消费半成品，且不再有旧 selective/all-delete 清理入口或仅服务该入口的 fixture。
- scope/effects：`StripMixins.Parameters.removalsFile` 与 inputArtifact/outputs 原生跟踪；整理/复用精确 JSON/ZIP 编辑器、移除 `SelectiveConsumer` 旧角色名，保留必要 file reader/path/发布 seam，不校验 producer/预应用来源。重新组织有效断言，可删除 `LegacyStripMixinsTests` 整类；退役未用 `F r05/RetentionPlugin.java` 及只服务旧 proof/metadata 删除的分支。R02 范围要求退出的旧平台 writer 不再恢复（R02:g1 已完成该退出），保留独立配置/类/refmap/metadata/资源。
- write owner：K `StripMixins.kt`、J 精确编辑器（现 `SelectiveConsumer`）及必要 file/JSON/path/`OperationPublication` 的直接适配；T 的 strip/safe-retention/publication/参数检查、`StripFixture`、`FixtureMixinRule` 及 F 对应资源，`pipeline-caller.gradle` 仅新 Transform 参数/类型迁移；Fabric/Forge `src/test/.../mixin/` 中精确清理/metadata 保留及 proof 耦合迁移的必要 assertions。无 producer/engine 算法、platform writer、新 core ABI 或根构建写权；发现 R02 缺口报告而非悄悄扩写。
- required evidence / 最小 verification：
  1. 一个独立手写有效 removalsFile（无 producer 证明/任何 status 字段）和 R02 真实文件都驱动同一组件；分别验证同数组重复、跨 `mixins/client/server`、跨两个 JAR 同键全删（另一来源无需通知）；嵌套路径非 basename、不同原字符串、不匹配 key 保留。package 展开/mapped class 不扩大匹配，消费者不询问资格。
  2. 真 JAR 重开检查未知嵌套字段/剩余值与顺序、空数组 config、class/refmap/Loader metadata/资源/目录，原输入保持；有效空与无匹配保持 config 内容，重复文件集合值不被当错误。
  3. 缺文件/坏 UTF-8/非法 JSON/object 字段歧义/错误值形状或非字符串、危险路径/重复 ZIP entry/损坏 CRC、非法适用 config 明确失败，不能猜空；实际写入/关闭/取消/发布失败保持不可消费，STORED entry/CRC 与 aliases/hardlinks/目录保护保持。保留真实 I/O seam，而非仅 mock 正常返回。
  4. 基于迁移后的 strip/safe-retention/publication focused tests 及必要 Fabric/Forge metadata 保留测试验证新 seam；Forge baseline 去 complete/output/hash 耦合但保留触及的 AT/nested-JAR/无关资源观察，不重认证全平台。检查剩余旧类/资源/反射/fixture caller 无悬空，记录实际 selectors 与结果。独立 Gradle 参数/inputArtifact probe 可迁移运行，但不是 I03 缓存闭包替代。
- conflicts：消费 R02 确立的文件格式与 helper/平台发现；共享发布/测试/cache，必须在 MRI-WR02 后串行。I03 同时依赖 R02/I02 及两 gates，以最新公开 API/fixture 为准。不得为保旧测试添加 records shim/metadata 删除路径。

### MRI-R03 — 目标 archive dispatch/preservation 局部 producer 修复

- state: completed
- wave: MRI-WR03
- prerequisiteItemIds: [MRI-R02, MRI-I02]
- 已采用完成与 gate：Router 完整读取关联 `mixin-target-owned-class-dispatch-repair:g1` / R03 completed；另独立核 WR03 唯一 member、本项三组 evidence、既有 R02/I02 与 WR02/W02 显式前置和 release predicate，判 WR03 satisfied。仅三个 owner 文件改变；锁定引擎 MixinClassReader 读取实际 @Mixin invisible annotation，定义原字节保留、其余普通类仍真实转换，无吞异常/宽泛包跳过或架构变化。最终同次八项 focused 8/0/0/0、native 内容/通知/输入保护与原失败 caller method 的 applied-only、A/B 完整 sources＋derived target Strip 消费均通过；实际 selectors、两次中间修正、LSP warning 及可覆写载体见 [R03 Context](context.md#mri-r03-completed-事实与独立-gate-判断)。R04/cache/current-input/caller failure 闭包未执行；不改下述 predicate/owner/evidence 或旧 I03 partial。
- 恢复关联：I03:g1 的完整 partial 已采用，独立目标 package/finally 六份 raw 不变断言已落地，公开 caller 接线未改；它是已采用输入，不是 completed prerequisite。R02 提供现 runtime producer，I02 提供当前真实 caller regression 所需公开 Strip 组件；对应 gates 为 WR02/W02。一个 Handler / 一个独立完整 Result，只承担本项修复及其 focused regression，不执行 R04 全部 cache。
- 单一 completion predicate：目标 JAR 合法自带 config/Mixin 定义时，producer 正确区分普通目标类转换与应原样保留的目标内 Mixin 定义/相关资源，普通目标仍经真实引擎并完成准确通知、安全输出和输入保护，且当前失败真实 caller regression 通过；不靠移走目标输入、吞异常、猜测包跳过或伪造通知成功。
- scope/effects：仅调整现 runtime archive dispatch/preservation 边界，保留目标自带 config/classes、现 discovery/解析优先级、原生通知、异常传播与 staged publication/资源退出。具体私有机制交给 owning code Handler，不新增 API、引擎选项/适配、来源清单、完整应用证明或 classloader 架构。普通目标转换与非转换内容保留均须观察，不能以新 fixture 避开目标自带定义。未来只产生本 fixture/测试自有普通 build/test/temp/cache 与小 JAR 效果，无安装或清全局缓存。
- write owner：J `runtime/EngineOperation.java` 及直接必要的 runtime 私有调用；T 的相关 producer/native tests（现 `MixinProducerTests`、`MixinPreapplicationTests`、`MixinFailureStageTests` 中直接受影响部分）及必要 native fixture helpers/resources；T `MixinInputBindingTests` 中现失败 `testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations` 与其直接必要 fixture regression。F 仅这些测试直接必要资源，不改公开 caller 连接合同。无 Strip/ExactMixinStripper、平台算法、Task/host API、构建/launcher/依赖/工具链、通用选项或隔离架构写权；发现超出 owner 的必需改动据实返回，不在 fixture 代写生产。
- constraints：不吞 `IllegalClassLoadError` 或将异常转成原字节成功，不搬走/移除目标 config/Mixin classes，不按猜测宽泛 package/目录跳过普通目标，不制造通知或降低 injector 要求。不更换引擎/loader 架构、不新增 options getter 适配；真实引擎异常仍向外、通知即清理与原输入/关闭发布保护不变。
- required evidence / 最小 verification：
  1. 通过现 native 入口处理真实小 JAR：目标同时包含普通目标、目标自带 config/Mixin 定义、相关及无关资源。实际调用完成输出验证普通目标仍经真实引擎，重开 JAR 核对 Mixin 定义与其他非转换内容原样保留、配置/资源仍在，关闭后通知文件可读且准确保留原 config 路径/原数组字符串；全部 raw 输入字节不变，不以静态链接或 mock 代替。用就近 focused regression 约束不扩大跳过普通目标的边界。
  2. 沿已修正独立目标 Mixin package 的现真实 TestKit method `MixinInputBindingTests.testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations` 复验原失败场景，经公开 producer/Strip 连接实际消费；不移走目标 config/class、不覆写 appliedMixins 默认路径、不 fake producer/strip。沿现 finally 观察六份 raw 不变，记录实际 selector、通过/失败、输出/通知/消费内容及失败限制，不用旧 R02/I02 green 替代此 regression。
  3. 仅对本修改直接影响的 native 异常/保留/输入保护分支做最小回归，保留向外 cause 与无当前半成品/陈旧成功语义；已有发布、隔离、mapping/平台证据只在覆盖仍适用处复用，不重复全组件、全部 cache 或额外 native 完整应用证明。普通 logs/XML/小 JAR 足够，本 Result 明确实际覆盖与 R04 尚未执行范围。
- conflicts：与 R04 共享 runtime 行为、T/helpers、F/caller fixture 及 Gradle/运行/cache 副作用，必须先完成本项并满足 WR03，再由 R04 串行消费；与既有 R02/I02 owner/原 partial Handler/旧 repair 的共享写与运行同样冲突，不能并行回放或重置历史。只读权威不冲突。

### MRI-R04 — 修复后剩余真实 caller/cache 闭包

- state: completed
- wave: MRI-WR04
- 已采用完成与 gate：Router 已完整读取关联 `mixin-remaining-caller-cache-closure:g1` / MRI-R04:g1 completed，并 supplied MRI-WR04 satisfied 与当前选定 Plan 完成判断。仅测试/fixture 两文件改动，8 个不同 methods 分轮最终通过（6 次调用/18 次执行，4 次中间失败已修正），不是一次 8/0；五组实测及组件复用、日志、最新 XML 仅 H 与 JDK17 限制见 [R04 Context](context.md#mri-r04-completed-事实与-router-supplied-gateplan-判断)。下述 predicate/五组 evidence/owner/前置/冲突全部保留。
- prerequisiteItemIds: [MRI-R02, MRI-I02, MRI-R03]
- 恢复关联：完整采用 I03:g1 partial 及其已修正 fixture；此前五个不同 methods 0 通过，提前 producer 失败不算后续分支已执行。R03 completed / WR03 satisfied 是修复前置，R02/I02 及 WR02/W02 是组件前置；I03 completed/W03 satisfied 不是前置。一个 Handler / 一个独立完整 Result，补齐原五组中所有尚未实际执行要求，可复用 R03 真实 regression 仍适用部分，不无变化重复全测、不新增终验 Result。
- 单一 completion predicate：修复后的真实 TestKit 使用方经公开 Task/Transform 注册、参数/依赖连接及属性/view 选择，消费同操作全部当前清理结果并在无 producer 内存的正常复用后仍成立，组件失败不伪报当前成功；结合仍适用的 R02/I02/R03 实测证据覆盖原 I03 五组及 Plan 当前 Spec 条件，未执行/失败分支不能靠提前 producer 错误替代。
- scope/effects：只补原 I03 尚未实际执行的真实 caller、失败消费、current-input 与 cache 要求，沿已修正 fixture 与公开组件；保持 producer raw inputs、完整 raw sources＋derived target、applied-only/default、两 operation、resolution-only 排除。仅本 fixture 自有普通 build/test/temp/cache 和小 JAR，无全局缓存清理、默认路径覆写、fake producer/strip、自动接线 helper、额外终验/框架。
- write owner：仅 T 中现 `MixinInputBindingTests` 的 caller/TestKit/helpers/assertions 与 F `pipeline-caller.gradle` 及直接必要 caller fixture resources，保持原 I03 owner 不扩大。无生产 Task/Transform/runtime/plugin/publication、平台算法、build/launcher/dependencies/toolchain、外部使用方或 authority 写权；若仍有生产缺口返回真实 partial/failed/blocked，不在 fixture 造 removals 或 strip 代实现。
- required evidence / 最小 verification：
  1. 真正 `tasks.register` Task、项目级 `registerTransform` 的类型/参数/from-to、provider 连接、必要显式 producer dependency、configuration/artifactView 请求属性并消费（不直接调用 action/clean）。默认 outputs 的 applied-only 与只改 outputFile 场景可复用 R01 已通过且仍有效的 smoke（相关变化时按适用要求复验）；完整流检查 raw source 和含 config 的 derived target 都经同一 Transform/该操作文件，resolution-only/外部配置不扫，raw 输入不变，两个操作集合不串/不并集、无 provider 环。
  2. 真实调用处理目标并重开全部清理 JAR；正常 applied-only 的配置仍未清理，不宣称全流。分别令 source strip、derived-target strip、当前 producer/发布失败：受影响消费向外异常，不消费半成品/陈旧成功、不报全流；独立完成的 applied target 仍只按 applied 成果使用，不要求任意 caller tasks 事务。
  3. producer SUCCESS 暖缓存→只移除本 fixture 自有 outputFile＋appliedMixins 输出→在新执行/无 producer 内存 FROM-CACHE→首次 fresh Transform→消费全部所需结果；再检 Task UP-TO-DATE 和每个 Transform 正常缓存恢复/复用，核对真实内容而非只看状态。已有新组件证据可复用，不要求无变化重复全测。
  4. 各自改变 config/plugin 方法体/resource/mapping/专用 side/context、实际影响输出的继承宿主属性或其未设置/default 状态、影响解析的集合顺序；相关属性变化是当前构建输入变化，不是 Task raw overrides；检查完整实现依赖受跟踪；Transform removals 参数与 inputArtifact 各自变化得到对应消费内容。合法空成功；missing/损坏/无效/陈旧交接正常重建/恢复或失败，不能把旧 target 存在/缺少内存当空集或跳过 Strip。跨 operation 不 union，缓存状态不冒充本次引擎通知。
  5. 对照 [Spec 当前验收表](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions) 说明本项实际观察与 R02/I02/R03 的仍适用证据的覆盖；沿现六个 TestKit 场景改新 API，记录真正执行的 selectors/通过失败/缺口，不因方法存在/编译通过或旧 probe 通过宣布闭包。普通日志/XML/小 JAR 足够；没有新 native 完整性证明或独立终验 Result。
- evidence 复用与限制：以上五组完整要求沿原 I03，不以方法存在、静态注解、I02 probe、R03 提前修复成功或缓存状态补算实际观察；R03 已实测且仍适用部分可复用，剩余分支必须真正执行。输入变化按原生相关宿主属性/unset/default 而非 public raw override。Result 必须分清各 selector/分支的通过、失败、未执行和组件证据适用范围，不将普通 XML 覆写前的历史数相加。
- conflicts：与 R03 共享 tests/fixture/运行/cache、与 R02/I02 共享公开 API/格式与运行副作用，按上述 prerequisites 与 WR02/W02/WR03 串行；本项按 WR03 satisfied 显式前置串行执行，现已采用 completed / Router supplied WR04 satisfied。不得恢复旧 repair、改写 I03 partial/W03 pending 或自动释放旧 MAP-W04。

## 历史节点与未释放 gate（不属活跃路线）

MRI-I01:g1 blocked、MRI-R01:g1 partial、MRI-I03:g1 partial 均已终结，不重置为 pending。以下保留三个原 item 的完整 scope、predicate、evidence、owner 与当时 conflicts（R01/I03 state 记录为已采用 partial）；其中 Plan/options 及依赖描述各调用时安排，**不是新恢复的活跃要求/edges**。原 I01 raw options 未成为权威承诺；R01 仅部分实现；I03 仅完成 fixture 修正并暴露 producer 缺口。原 W01/WR01/W03 各对应原 predicate，均 pending/未释放；R02 或新 R03/R04 completed 不会自动满足旧项/gates，不以旧 partial 作为新路线的 completed prerequisite。

| Wave ID | gateState | itemIds | predecessorWaveGates | incremental outcome / release predicate |
| --- | --- | --- | --- | --- |
| MRI-WR01 | pending | [MRI-R01] | [] | 新 producer 从 raw 输入完成真实引擎处理、准确通知文件和安全组件输出，必要发现/旧容器调用迁移可用；R01 completed 且默认输出查询、通知/专用参数/原生选项与输入观测/mapping/隔离/资源与失败证据满足，不留旧 host/证明编排依赖。 |
| MRI-W01 | pending | [MRI-I01] | [] | 新 producer 从 raw 输入完成真实引擎处理、准确通知文件和安全组件输出，必要发现/旧容器调用迁移可用；I01 completed 且默认输出查询、通知/参数/mapping/隔离/资源与失败证据满足，不留旧 host/证明编排依赖。 |
| MRI-W03 | pending | [MRI-I03] | [MRI-WR02, MRI-W02] | caller 注册/绑定/选择消费和无内存正常缓存闭包成立；I03 completed 且真实全链当前内容、默认值、失败传播与复用证据，结合新组件有效证据覆盖 Plan 的 Spec 条件，无遗漏或未解释失败。 |

### MRI-I03 — 真实 caller 的完整消费与正常缓存闭包

- state: partial
- wave: MRI-W03
- prerequisiteItemIds: [MRI-R02, MRI-I02]
- 单一 completion predicate：真实 TestKit 使用方经公开 Task/Transform 注册、参数/依赖连接及属性/view 选择，消费同操作全部当前清理结果并在无 producer 内存的正常复用后仍成立，组件失败不伪报当前成功；结合新组件证据覆盖 Plan 的当前 Spec 条件。
- scope/effects：迁移并补足现 caller fixture 的有效场景，不继承旧 MAP-I04 完成状态；保持 producer raw inputs、完整集合 raw sources＋derived target、单独 applied-only、两 operation、resolution-only 排除。末项自然整合同链 tracking/cache/失败检查，不建第二终验、receipt、生产 wiring helper 或独立引擎证明。
- write owner：仅 T 中现 `MixinInputBindingTests` 的 caller/TestKit/helpers/assertions 与 F `pipeline-caller.gradle` 及直接必要 caller fixture resources。无生产 Task/Transform/runtime/plugin/publication、平台生产、build/launcher/dependencies、外部使用方或 authority 写权；生产缺口须报告真实 partial/failed/blocked，不能以 fixture 造 removals、显式覆盖默认路径或代写 strip 绕过。
- required evidence / 最小 verification：
  1. 真正 `tasks.register` Task、项目级 `registerTransform` 的类型/参数/from-to、provider 连接、必要显式 producer dependency、configuration/artifactView 请求属性并消费（不直接调用 action/clean）。默认 outputs 的 applied-only 与只改 outputFile 场景可复用 R01 已通过且仍有效的 smoke（相关变化时按适用要求复验）；完整流检查 raw source 和含 config 的 derived target 都经同一 Transform/该操作文件，resolution-only/外部配置不扫，raw 输入不变，两个操作集合不串/不并集、无 provider 环。
  2. 真实调用处理目标并重开全部清理 JAR；正常 applied-only 的配置仍未清理，不宣称全流。分别令 source strip、derived-target strip、当前 producer/发布失败：受影响消费向外异常，不消费半成品/陈旧成功、不报全流；独立完成的 applied target 仍只按 applied 成果使用，不要求任意 caller tasks 事务。
  3. producer SUCCESS 暖缓存→只移除本 fixture 自有 outputFile＋appliedMixins 输出→在新执行/无 producer 内存 FROM-CACHE→首次 fresh Transform→消费全部所需结果；再检 Task UP-TO-DATE 和每个 Transform 正常缓存恢复/复用，核对真实内容而非只看状态。已有新组件证据可复用，不要求无变化重复全测。
  4. 各自改变 config/plugin 方法体/resource/mapping/专用 side/context、实际影响输出的继承宿主属性或其未设置/default 状态、影响解析的集合顺序；相关属性变化是当前构建输入变化，不是 Task raw overrides；检查完整实现依赖受跟踪；Transform removals 参数与 inputArtifact 各自变化得到对应消费内容。合法空成功；missing/损坏/无效/陈旧交接正常重建/恢复或失败，不能把旧 target 存在/缺少内存当空集或跳过 Strip。跨 operation 不 union，缓存状态不冒充本次引擎通知。
  5. 对照 [Spec 当前验收表](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions) 说明本项实际观察与 R02/I02 新证据的覆盖；沿现六个 TestKit 场景改新 API，记录真正执行的 selectors/通过失败/缺口，不因方法存在/编译通过或旧 probe 通过宣布闭包。普通日志/XML/小 JAR 足够；没有新 native 完整性证明或独立终验 Result。
- conflicts：与 R02/I02 的 API/fixture/运行缓存冲突，prerequisites 与 MRI-WR02/W02 共同保证串行；旧 repair/caller recovery 不再启动。本项不修生产、不重写旧 partial/取消事实，也不会释放旧 MAP-W04。

I03:g1 已采用 partial：仅独立目标 Mixin package 与 finally 六份 raw 输入保护断言修正；五个不同 TestKit methods 0 通过，最终单方法 1 test/1 failure，producer 在目标内 Mixin class 处失败，没有 applied/通知/消费成果。缓存、输入变化及 Strip failure 等尚未实际执行；原 predicate 未满足、W03 pending/未释放。详细方法、失败与可移植载体见 [Context](context.md#mri-i03-partial-事实与目标内-mixin-class-缺口)。

### MRI-R01 — 原生选项边界下的完整 producer 恢复

- state: partial
- wave: MRI-WR01
- prerequisiteItemIds: []
- 恢复关联：原 MRI-I01:g1 blocked 且 0 生产改动；本项承接其全部未完成 producer 整体，仅按已确认的原生选项边界验证，不是参数证明或独立 hostprops 框架。一个 Handler / 一个独立 Result，不改写或自动满足 I01/MRI-W01。
- 单一 completion predicate：新公开 producer 能从声明的 raw 输入产出已完成、受跟踪的 applied target＋准确原键 appliedMixins，专用参数、原生选项/default 与内部输入观测、命名/隔离及失败安全满足当前 Spec，且不再依赖旧 host/RecordData 证明编排；默认输出在 producer 执行前可合法查询。
- scope/effects：按 Plan 保持现有公开 `task.Mixin`（`Mixin`）与 `StripMixins` 类型名，以独立默认 outputs 和中性文件格式内部重建 Task/host/runtime，不新增 `PreApplyMixins` 类型或安排纯命名迁移；一次 fresh loader、统一 task class/resource 解析、原生 service、专用 side/mapping/context 和 Mixin 原生宿主属性/default 选项行为，内部观测仅作 Gradle 输入跟踪，真实 engine 调用、通知原键归属及跨 loader JDK 值，资源退出后发布。复用精确 remapper/输入解析/组件发布逻辑，不保长参数/重复 discovery/binding/来源摘要。保留 `task.Mixin` 类型，拆除旧 `RecordData`，清退 host 双轨类/实体 SPI、旧便利 DSL/Groovy 注册；最小插件入口不自动接线。
- 必要连接：Mixin listing 改为只读 config/环境发现，平台与 test SPI/fixture 同步；保留 Fabric/Forge 的路径/环境/parent/manifest/TOML 读语义，移除 selective/all-delete metadata writer、`SelectiveMixinConfigHandler` 及旧单独 applicability 接口，绝不改 Core 通用 `remove`。为删除 `RecordData`，精确编辑器只迁移必要 file/JSON/path helper 调用，原算法不在本项另作 Strip 完成声明。所有生产调用/测试动态源码/反射与 proof 形状断言同步到可编译状态，不留临时兼容容器或悬空注册。
- write owner：K `task/`、`MinecraftCodevMixinsPlugin.kt`、`MixinListingRule.kt`、`SelectiveMixinConfigHandler.kt`、`mixin/`；J `OperationRunner`、`runtime/`、`MixinConfigApplicability`、必要 `OperationPublication` 及 `SelectiveConsumer` 的 helper 引用；Mixins `src/main/resources/META-INF/` 中对应旧服务/扩展注册。Fabric/Forge `src/main/kotlin/.../{fabric,forge}/mixin/` 与各自 `META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule` 仅上述发现/清退迁移。T/F 及平台 `src/test/.../mixin/` 的相关调用/SPI/断言；`pipeline-caller.gradle` 仅新 Task/API/default smoke 必需迁移，非整链补验。模块 `build.gradle.kts` 仅实际插件/必要测试注册一致性（如确需），不改依赖版本、根构建/lockfiles。
- constraints：不把候选当通知、不永久丢弃可归属通知，不按 source/hash/section/index 做资格；保留真正执行输入歧义/资源遮蔽错误而非一律重复拒绝。专用 side/mapping/context 显式设置实际生效，不靠与继承值相等或改 JVM 全局属性；通用选项无 public `engineOptions` / 等价 raw override，不注入独立快照、不重算原生规则、不做相应 getter 字节码适配。内部仅跟踪实际影响输出的宿主属性及相关未设置/default，不冻结载体/枚举/序列化/缓存算法，不扫描无关全 JVM 环境；Codev 不写/泄漏全局属性，无 mapping 不强启 `REFMAP_REMAP`。不在 fixture 显式设 appliedMixins 默认路径或造空文件代替 producer。
- required evidence / 最小 verification：
  1. 真实引擎小类/JAR/plugin，经新入口读指定 raw target/sources/runtime，调用完成输出并读关闭 loader 后的文件；发现/候选不造键，多数组原串/完整路径、parent、动态无原键、有效空、重复等内容来源与真正冲突输入分别检查。多目标某处通知而另一处失败/部分/unknown 且正常返回仍收原键；仅日志报错不另判失败，直接异常传播，日志由用户读。
  2. 沿现 `MixinProducerTests`、`MixinPreapplicationTests`、`MixinMappingTests`、`MixinFailureStageTests`、`MixinOperationIsolationTests` 的有效场景改新 seam：真实 owner/overload/refmap/context、双向/null/unmapped/歧义、非法 tuple/方向；task-only class/plugin/resource 优先级、runtime 不 discovery、专用 side 和原生宿主属性/default 的实际选项行为。包括显式 context 不同于继承默认实际生效，而非拒绝差异来保旧断言；观测与实际原生读取一致，宿主属性未被 Codev 污染，不要求同 JVM 各 Task 独立 raw 值。
  3. 同 JVM A→B、失败重试、并发对串行/冲突目的地、TCCL 恢复及实际 JAR 可释放；取消/写入/关闭/runtime exit/发布异常阻断当前半成品和 stale success。Codev 失败经日志/向外异常标明阶段、已知 config/target 和底层 cause，未知归因明确，不吞反射包装原因。复用/迁移 `OperationPublicationTests` 的 alias/realpath/hardlink/目录保护，实际原输入不变。平台 focused tests 检只读发现/环境与 metadata 未改，不保旧 metadata 删除断言。
  4. 新 Task 两 tracked outputs、全部有效输入（含相关继承属性/default 状态）、完整 runtime 与实现依赖声明检查；真实 TestKit applied-only **不覆写两个默认 outputs**，在执行前查询路径/调度并消费真实 applied target，再测 caller 只设置 outputFile、appliedMixins 用默认，覆盖原 own-output map regression。此 smoke 不宣称完整 caller/cache。记录实际 selectors、结果和迁移引用搜索（含 ServiceLoader/反射字符串/扩展注册），不以编译或注解检查独立代替运行证据。
- conflicts：与 I02 共 file reader/path、编辑器、发布和测试；与 I03 共 API/defaults、caller resource 及运行/cache。I02 显式依赖 R01/MRI-WR01；I03 不能与之并行。平台只读 seam/旧能力退出一并交付，不把不编译树交给后项或强留原容器。

R01:g1 已采用 partial：命名/独立 default/空插件/旧 host 与实体 SPI/Groovy 注册退出及必要引用迁移已完成，default smoke 和 20 focused tests 通过；native 观测、RecordData/proof 编排与只读平台迁移等未完成，WR01 不满足。详细执行/失败/包限制见 [Context](context.md#mri-r01-partial-事实与可复用基线)。

### MRI-I01 — 新预应用 producer 与操作执行边界

- state: blocked
- wave: MRI-W01
- prerequisiteItemIds: []
- 单一 completion predicate：新公开 producer 能从声明的 raw 输入产出已完成、受跟踪的 applied target＋准确原键 appliedMixins，实际参数/命名/隔离与失败安全满足 Spec，且不再依赖旧 host/RecordData 证明编排；默认输出在 producer 执行前可合法查询。
- scope/effects：按 Plan 保持现有公开 `task.Mixin`（`Mixin`）与 `StripMixins` 类型名，以独立默认 outputs 和中性文件格式内部重建 Task/host/runtime，不新增 `PreApplyMixins` 类型或安排纯命名迁移；一次 fresh loader、统一 task class/resource 解析、原生 service 和实际 effective options/side/context，真实 engine 调用、通知原键归属及跨 loader JDK 值，资源退出后发布。复用精确 remapper/输入解析/组件发布逻辑，不保长参数/重复 discovery/binding/来源摘要。保留 `task.Mixin` 类型，拆除旧 `RecordData`，清退 host 双轨类/实体 SPI、旧便利 DSL/Groovy 注册；最小插件入口不自动接线。
- 必要连接：Mixin listing 改为只读 config/环境发现，平台与 test SPI/fixture 同步；保留 Fabric/Forge 的路径/环境/parent/manifest/TOML 读语义，移除 selective/all-delete metadata writer、`SelectiveMixinConfigHandler` 及旧单独 applicability 接口，绝不改 Core 通用 `remove`。为删除 `RecordData`，精确编辑器只迁移必要 file/JSON/path helper 调用，原算法不在本项另作 Strip 完成声明。所有生产调用/测试动态源码/反射与 proof 形状断言同步到可编译状态，不留临时兼容容器或悬空注册。
- write owner：K `task/`、`MinecraftCodevMixinsPlugin.kt`、`MixinListingRule.kt`、`SelectiveMixinConfigHandler.kt`、`mixin/`；J `OperationRunner`、`runtime/`、`MixinConfigApplicability`、必要 `OperationPublication` 及 `SelectiveConsumer` 的 helper 引用；Mixins `src/main/resources/META-INF/` 中对应旧服务/扩展注册。Fabric/Forge `src/main/kotlin/.../{fabric,forge}/mixin/` 与各自 `META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule` 仅上述发现/清退迁移。T/F 及平台 `src/test/.../mixin/` 的相关调用/SPI/断言；`pipeline-caller.gradle` 仅新 Task/API/default smoke 必需迁移，非整链补验。模块 `build.gradle.kts` 仅实际插件/必要测试注册一致性（如确需），不改依赖版本、根构建/lockfiles。
- constraints：不把候选当通知、不永久丢弃可归属通知，不按 source/hash/section/index 做资格；保留真正执行输入歧义/资源遮蔽错误而非一律重复拒绝。mapping/context 显式设置实际生效，不靠与宿主相等或改 JVM 全局属性；无 mapping 不强启 `REFMAP_REMAP`。不在 fixture 显式设 appliedMixins 默认路径或造空文件代替 producer。
- required evidence / 最小 verification：
  1. 真实引擎小类/JAR/plugin，经新入口读指定 raw target/sources/runtime，调用完成输出并读关闭 loader 后的文件；发现/候选不造键，多数组原串/完整路径、parent、动态无原键、有效空、重复等内容来源与真正冲突输入分别检查。多目标某处通知而另一处失败/部分/unknown 且正常返回仍收原键；仅日志报错不另判失败，直接异常传播，日志由用户读。
  2. 沿现 `MixinProducerTests`、`MixinPreapplicationTests`、`MixinMappingTests`、`MixinFailureStageTests`、`MixinOperationIsolationTests` 的有效场景改新 seam：真实 owner/overload/refmap/context、双向/null/unmapped/歧义、非法 tuple/方向；task-only class/plugin/resource 优先级、runtime 不 discovery、有效 options/side。包括显式 context 不同于继承默认实际生效，而非拒绝差异来保旧断言。
  3. 同 JVM A→B、失败重试、并发对串行/冲突目的地、TCCL 恢复及实际 JAR 可释放；取消/写入/关闭/runtime exit/发布异常阻断当前半成品和 stale success。Codev 失败经日志/向外异常标明阶段、已知 config/target 和底层 cause，未知归因明确，不吞反射包装原因。复用/迁移 `OperationPublicationTests` 的 alias/realpath/hardlink/目录保护，实际原输入不变。平台 focused tests 检只读发现/环境与 metadata 未改，不保旧 metadata 删除断言。
  4. 新 Task 两 tracked outputs、全部有效输入/完整 runtime 与实现依赖声明检查；真实 TestKit applied-only **不覆写两个默认 outputs**，在执行前查询路径/调度并消费真实 applied target，再测 caller 只设置 outputFile、appliedMixins 用默认，覆盖原 own-output map regression。此 smoke 不宣称完整 caller/cache。记录实际 selectors、结果和迁移引用搜索（含 ServiceLoader/反射字符串/扩展注册），不以编译或注解检查独立代替运行证据。
- conflicts：与 I02 共 file reader/path、编辑器、发布和测试；与 I03 共 API/defaults、caller resource 及运行/cache。I02 显式依赖 I01/MRI-W01；I03 不能与之并行。平台只读 seam/旧能力退出一并交付，不把不编译树交给后项或强留原容器。

## 状态与实际证据边界

Router 已完整读取关联 MRI-I01:g1 blocked 与 MRI-R01:g1 partial，业务状态不取自 backend completed。I01 的 0 生产改动、既有 mapping 通过/build-only enum 拒绝历史不倒改。R01 已有 appliedMixins/独立 defaults、插件/旧 host/SPI/Groovy 退出与必要引用迁移、真实默认 smoke/20-tests/4-file LSP 和当前版本包退出检查；这些不是完整 producer、独立 Strip、平台迁移或 caller/cache 证据。未引用非增量参数的选任务失败未跑 test，旧版本 0.6.0 JAR 不当新产物。source artifacts/命令/缺口及 build 可变性见 [Context](context.md#当前执行事实与证据限制)。

原 MRI-W01/MRI-WR01/MRI-W03 均 pending/未释放，I01 blocked/R01 partial/I03 partial 保持终结状态。R02/I02 completed 与 WR02/W02 satisfied 是已采用的实测组件与独立 gate 历史，不 reset、不因新缺口重新开关；R03:g1 completed / WR03 satisfied 新增覆盖实测局部目标自带 config/Mixin class 修复与指定 caller regression，不据旧 whole producer 表述或新局部通过泛称全覆盖。R04:g1 completed 已补齐 fresh FROM-CACHE/current-input/caller failure 等剩余闭包，Router supplied WR04 satisfied 与既有 WR02/W02/WR03 共同建立当前选定 Plan 完成。本次只记录 supplied 判断，不自行重判其它 gate、执行或调度。

静态图/tuple/相对链接/anchor/Markdown 和改动范围检查只证明同一已确认 Plan 的 C5 同范围恢复记录结构，不证明生产修复、验证、闭包或 runtime admission。旧 [pipeline Context](../mixin-artifact-pipeline/context.md) 的 completed/partial、MAP-W04 未释放/repair 取消及旧 G1 保持原范围；不写外部 Result/session 定位器或新报告包。未来 Router 仍须完整读取并可靠关联各独立 Result，逐项核对 evidence 与新 gate predicate；本次只记录已采用 R04 completed / Router supplied WR04 satisfied、当前选定 Plan 完成、I03 partial 和历史 judgments，不更新 Todo、不选择 continuation，也不追加实施许可。
