# Mixin 剩余简化 Waves

[Work](work.md) · [Context](context.md) · **唯一匹配 [Plan](plan.md)**

这是 Plan 的唯一执行图。原十四项范围已获当前用户实施确认；Router 已完整采用 codev-full-coverage-plan-review/g1 completed、无阻断。原准备版未审/未确认/全 pending 的措辞是当时事实，见 Plan/Context 的历史记录。当前投影：十四个活跃 items 均 completed，MS-S09 保留 blocked 历史并由 MS-S16 承接未执行范围；MS-W01、MS-W02、MS-W03 三个 gate 均由 Router 判定满足。本轮只维护已采用记录，不重验、不改变 predicate、依赖、冲突或 gate 合同。每个 item 恰有一个 Handler 和一个 Result，必要 caller/helper/fixture/聚焦验证属于该谓词。

## 共同边界与冲突

依据 [Spec](../../spec/mixin-preapplication.md)、[译本](../../spec/mixin-preapplication.zh-CN.md)、[PRD](../../prd/codev-mixin-rework.md)与[ADR](../../adr/mixin-operation-isolation.md)，以及 Work 三族 reuse assessment。原九项及最低成功要求保留，编码读取与 loader 打开政策已接受；全部已授权读取/验收都有完成事实或 item 归属，不再将 F1/F2 留在 scope 外。既有 partial/完成效果由 Context 保存，不重放、不自动追认；原版本其余八项无重要阻断结论仅在未变边界复用。

每项只改所列 owner 与必要直接消费者/测试。保持原输入、通知身份/全匹配、真实 mapping、side/顺序、当前 metadata、真实 API 异常/cause/close、TCCL/selector 恢复和组件完成边界。实施范围已由用户确认；本次 Handler 仅有图维护权限，不执行生产/测试改动。authority、HTML、旧 Work、Core/Includes 功能、版本/依赖/锁/工具链及无关功能不属于写面。

下列是**冲突串行方向，不是成功 Result 前置**。所有 prerequisiteItemIds 均为空；读取迁移与原九项之间无已证业务 Result 依赖。全部读取 authority、现有实现及对应 tests；只有所列直接 owner、必要 callers/fixtures/tests 可写。共享只读 authority 不冲突；旧 partial 不是等待其变 completed 的前置。任一独立结果可保留/单独恢复，冲突项须基于最新文件状态串行，即使前项 partial 也不能自动重放已完成效果或放行 gate。

- 历史方向 S01 → S09 → S04 → S06 保留为旧安排；S09 未执行且 blocked，S01/S04 已结束，不作为恢复的等待链。当前直接冲突方向为 S01 → S04 → S16 → S06（stripper/Transform/Strip tests；前两项仅为已结束事实）；S02 → S05（platform/SPI tests）；S05 → S03 → S06 → S08 → S10（host/child、producer/mapping tests 与 JVM native state）。
- 新增直接冲突方向：S02 → S13 → S14 → S05（Fabric adapter/load/current edit 与 metadata/discovery tests）；S03 → S11 → S08（child 共写 applyMixins 与 ProducerDom/mapping tests）；S08 → S12 → S10（refmap 共写 recorder、ProducerDom/通知 tests）；S10 → S15（实际 loader consumers 与 resource/producer/mapping tests）。S11 与 S05/S08、S12 与 S08、S13/S14 与 S02/S05 均按这些方向串行，不把文件冲突伪装成业务前置。
- 各测试共享 build/fixture 输出，部分使用 JVM selectors/SecurityManager/系统属性，不能未经资源证据并行。保守完整串行路径为 **S01 → S04 → S16 → S02 → S13 → S14 → S05 → S03 → S11 → S06 → S08 → S12 → S10 → S15**。路径仅规定互斥方向，不形成成功依赖、编号/Wave 全局屏障或本次调度决定；实际 eligibility 与工具/资源许可由 Router 判断。

## Waves 与 gates

### MS-W01 — 独立 Strip 的最小精确清理

- state: satisfied
- itemIds: [MS-S01, MS-S04, MS-S16]
- 恢复映射：MS-S09 是保留 blocked 的历史节点，不再列为本 gate 的待完成 member；MS-S16 完整承接原 S09 predicate/evidence。此为显式图修订，不把恢复 Result 自动归给旧项，亦不要求旧 blocked 变 completed。
- prerequisiteWaveGates: []
- incremental outcome：Strip 仍独立按 removalsFile 精确过滤，去额外拒绝/全资源缓冲/主动轮询，输入与失败边界保持。
- gate：MS-S01、MS-S04、MS-S16 三份关联完整 Results 均 completed、各项全部必需证据充分；核对 exact all-match/不变配置原 bytes、STORED/资源、真实 read/write/close/move/API 取消及不覆盖/冲突 writer 证据在最终组合源版本仍适用。共享 stripper/fixture 被后项改动影响的断言须在后项内最小补验，不能拿先前旧版本绿替代。复用现有独立手写/其它 task 的真实 Transform 消费路径；如组件变更使旧 consumer 失败/内容证据失效，在该变更项内补验。S01 自身读取须去 strict/额外扫描并迁移旧 UTF-8 断言，未知字段遵循适用默认 decoder，不保证坏输入全部成功/拒绝/相同替换；不凭本 gate 宣称全部 JSON 入口已迁移或 loader partial 已完成。
- 显式依赖方：无后继 Wave；此 gate 与 MS-W02/MS-W03 共同建立 Plan 的有界结果。

### MS-W02 — Mixin producer 的剩余就地收敛

- state: satisfied
- itemIds: [MS-S05, MS-S03, MS-S06, MS-S08, MS-S10, MS-S11, MS-S12, MS-S15]
- prerequisiteWaveGates: []
- incremental outcome：host/child 实际输入、mapping 与完成协议保持，去外部无用来源数据、主动轮询、重复防御和通知输出中间 bytes；child config/parent 与必要 refmap context 读取流解码/use；recorder 保留最低 context 职责；loader 原生 open-null 在实际必需/可选消费者下完成剩余验收。
- gate：八份关联完整 Results 均 completed、每项必需证据充分；最终组合版本保留 discovery side/双格式/顺序/歧义、真实 selected context member/class 固定与必需失败、实际 API 取消/异常、两侧 producer/Strip 输入身份保护及 loader-close→entry-close→两输出完成顺序。后项若改实际 I/O，必须证明 probe 命中且可获得 cause/suppressed 不丢；真实 caller 的通知文件消费/完成依赖及当前输入复用证据经适用性核对，缺口在对应变更项内最小补验。不得以类名/编译/静态无轮询替代真实 engine/失败证据，不要求不受影响全套重跑。S11/S12 分别证明 child config/parent 和 refmap 实际流读取/use、无无必要中间 bytes；S08/S11/S12 按各自归属迁移并实际验证未知字段坏字节旧 strict 断言，S15 证明 loader-open null 的实际必需输入 unavailable 失败与 native 可选正常 fallback。允许必要 context 二次 DOM 读取，不以 `return true` 删除最低义务。native 内部捕获后正常 fallback 与向外抛异常区分；JDK null 只限 loader 打开，其它 read/close/直接 I/O/转换/写出/恢复及必需输入失败仍保留。旧 partial 或政策接受不充当通过证据；此 gate 的读取/cause 政策验收逐项对应 S08/S11/S12/S15，缺失即不满足。旧 I/O metadata UTF-8 断言由 W03 的 S13/S14 承担，最终 Plan 要求两 Wave 均满足；这里不增加 W02 等 W03 的 gate 前置，不声称机械 29/29 或重写旧 partial。
- 显式依赖方：无后继 Wave；此 gate 与 MS-W01/MS-W03 共同建立 Plan 的有界结果。

### MS-W03 — handler 入口收窄与 Fabric JSON 流读取

- state: satisfied
- itemIds: [MS-S02, MS-S13, MS-S14]
- prerequisiteWaveGates: []
- incremental outcome：仓内使用者只通过保留的 remove 编辑当前 metadata，无 public removeConfigs；Fabric load/current edit 都以默认 decoder 流读取/use，保留各自真实职责。
- gate：S02/S13/S14 三份完整关联 Results 均 completed；接口/三个 adapters/直接与 SPI consumers 均无 public removeConfigs，必要编译/引用迁移和三格式真实 remove 编辑、未知/新增保留、失败传播证据齐备。Fabric load 与 current edit 分别证明 decodeFromStream/use、无 readString 中转、坏 UTF-8 未知字段按实际默认 decoder 观察及真实 read/close（edit 另含 write/close）故障命中，S13/S14 共同承接旧 I/O metadata UTF-8 断言余项。核对 S05 或其它后项改动对最终组合版本是否影响这些证据，影响处在最后改动项内补最小直接验收；不得拿旧 public 入口通过数代替 remove 验收。仓外 source/binary 风险如实记录。
- 显式依赖方：无后继 Wave；此 gate 与 MS-W01/MS-W02 共同建立 Plan 的有界结果。

gate 的实际满足/释放只由 Router 在完整读取可靠关联 Results 后独立判断。partial、failed、blocked、缺失/不可采用 Results 或证据不足均不满足；作者自检、review completed、有利意见、用户确认或文件存在均不能释放。无 Wave 以自己的 gate 作前置，也无隐含旧 gate 等待。

## Items

下面测试路径均相对于项目根；命名为现有接点并不保证无需适配就足以验证。未来必须记录真实选择器、环境、结果、观察和实际故障命中，未跑/skip/版本限制如实保留。每项 state 均是执行状态，不是文档作者状态。

### MS-S01 — Strip 只做精确三数组过滤

- state: completed
- Router 已采用事实：最小三数组精确过滤及额外复验退出；8 项聚焦测试通过、无 skip，STORED 输出 size/CRC 与未变配置原 bytes 保留。仅记录 Handoff 事实，不补造测试选择器、命令或 artifact；后续修改须判断证据适用性。
- wave: MS-W01
- prerequisiteItemIds: []
- completion predicate：Strip 在信任输入边界内，仅以配置完整路径与原数组字符串精确过滤 mixins/client/server 的所有匹配，保持未变配置原 bytes 和其它内容，无额外手写输入复验。
- scope/effects：移除 cleanup/edit 手写 root/value/element 验证、名称/路径/空白/字符限制、输入 size/CRC 复验与自建 ZIP 重名集合；使用既有 DOM 访问完成实际编辑，不换名预扫。该过滤器自身 JSON 读取改用适用默认 decoder，去 strict 和额外扫描，未知字段亦同；不扩到其它 JSON 入口。loader、destination 与取消另有边界/独立项。
- write owner：[ExactMixinStripper](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/ExactMixinStripper.kt)及必要 StripDom/StripMixins/直接保留 tests；不编辑 metadata。
- 必需 evidence：手写 removals 独立使用、重复跨数组/跨 JAR 全移除、不同路径/原字符串/package/mapped 名不扩大匹配、未知 DOM/保留顺序/类/refmap/metadata/资源不动；empty/no-match 配置原 bytes；STORED 输出 size/CRC 可读；缺失文件、真实解析/DOM/ZIP/read/write/close 失败外传。迁移旧 invalidCleanup/malformed/CRC/unsafe/duplicate tests 及自身读取的 strict 坏 UTF-8 断言：只删除已撤销的额外拒绝要求，按当前适用 decoder 观察未知字段与业务形状，不预设所有坏输入成功、拒绝、相同替换；保留实际 DOM/ZIP/API 拒绝。JarOutputStream 自然拒绝重复 entry 可保留其实际失败断言，无自建集合。用无需裁剪的原始含空白/控制字符字符串作精确匹配观察，不手写扫描。
- 聚焦接点：[StripMixinsTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripMixinsTests.java) handwrittenRemovalsRemoveEveryRawMatchWithoutProducerOrMetadataDiscovery、storedEntriesAndDirectoriesSurvivePreciseEdits；[MixinSafeRetentionTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java)的 no-match/all-match 接点；实际 DOM 负例适配当前合同。
- conflicts：S16/S04/S06 的共享源码/fixture；S09 保留历史冲突，现行串行见上文。
- 单结果理由：这些检查退出、精确编辑及回归共同建立一个 Strip 过滤合同；流复制可独立保留/失败，另列 S09。

### MS-S02 — 删除 public removeConfigs 并完成必要迁移

- state: completed
- wave: MS-W03
- prerequisiteItemIds: []
- completion predicate：仓内 Mixin handler 和具体 adapters 不再暴露 public removeConfigs，所有实际消费者通过保留的 remove 完成原引用集对当前 metadata 的真实编辑。
- scope/effects：删除接口入口及具体 public overrides，Fabric/Forge/NeoForge 只保留实际需要的私有编辑逻辑；迁移全部直接调用、Java anonymous SPI 实现、反射/生成 fixture 与测试。测试中旧定点删除能力不再作为公开合同，但保留 remove 对当前数据、未知及新增引用的观察；不得用 no-op 或只改接口代替。
- write owner：[MixinConfigHandler](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinConfigHandler.kt)、[Fabric adapter](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinConfigHandler.kt)、[Forge adapter](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinConfigHandler.kt)、[NeoForge adapter](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/NeoForgeMixinConfigHandler.kt)和其必要直接 tests/fixtures；Core 签名不改。
- 必需 evidence：仓内 production/test/generated fixtures 的入口引用及 public 方法检查、三个受影响模块必要编译；三格式分别 load→添加引用/未知字段→remove，仅原引用集被从当前内容移除，新增及未知/current 内容保留、snapshot/list 不变；Manifest/TOML 两格式不互改，producer metadata 只读、Strip 不调 metadata；真实 malformed/business/读/写/close 负例仍经保留入口外传。不要求复活公开 selective 入口或统计旧两入口测试作新双倍数量。
- 聚焦接点：[FabricMixinMetadataTests](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt)、[ForgeMixinMetadataTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt)、[FixtureMixinRule](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java)、[MixinPreapplicationTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java)。仓外调用未知，删除的 source/binary 风险必须进入 Result。
- conflicts：S05 的 Forge/SPI tests，S01 的直接 preapplication/strip 保留 tests 可能相交；采用保守路径。
- 单结果理由：interface/三个实现/调用迁移共同才能形成一个无旧 public API 的可用终态，缺一即不满足；不是把三个独立 metadata 新算法合并。

### MS-S03 — producer 取消检测归实际 API

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：Mixin producer 的 host/child 不再显式轮询中断，真实 API 报告的取消/失败仍按同一 producer 生命周期恢复资源并阻止当前半结果消费。
- scope/effects：删除当前 host 3＋child 2 个轮询点，不重做 initializeMixinRuntime 的 Closeable.use，不加取消框架；保留 actual exception/cause、selector/TCCL、close/cleanup/retry。
- write owner：produceMixins、runtime/applyMixins 及直接 producer/isolation/failure/probe tests。
- 必需 evidence：生产搜索无剩余 producer 轮询；flag-only 且 API 未抛时不再依赖轮询失败，选可完成 fixture 观察输出与清 flag；另从真实初始化/转换/I/O/close/move 调用抛取消或 InterruptedIOException，证明 outward cause、恢复/关闭、旧 pair 不作当前成功及 fresh retry。不能只删 cancel 用例。适配 [MixinOperationIsolationTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinOperationIsolationTests.java)原 `cancel` 和 [MixinProducerTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java) LifecycleIO 的仅设 flag 语义，保留其它真实 I/O/关闭故障覆盖及故障命中。
- conflicts：S05/S06/S08/S10 的 producer/child/tests/运行环境；按共同串行方向。
- 单结果理由：host 初始化至两输出完成是一条 producer 生命周期；Strip 可独立消费/失败，所以其取消另列 S04。

### MS-S04 — Strip 取消检测归实际 API

- state: completed
- Router 已采用事实：Transform 两处及 stripper 一处轮询已删除，flag-only 与真实 API 取消已区分；两次 Gradle 运行分别 11/11 StripMixinsTests、1/1 真实 source/target Strip 失败消费测试通过、零 fail/error/skip，diff check 通过。方法、repo XML 与限制见 [Context](context.md#本次可靠采用的执行与恢复事实)。
- wave: MS-W01
- prerequisiteItemIds: []
- completion predicate：Strip Transform 及其 stripper 不再显式轮询中断，真实 API 取消/失败仍阻止其未完成输出并关闭资源。
- scope/effects：删除 Transform 2＋stripper 1 个轮询点，不改 engine 或新建取消框架。
- write owner：StripMixins/ExactMixinStripper、StripMixinsTests/StripFixture 必要回归。
- 必需 evidence：无剩余 Strip 轮询；原 StripFixture.close 的 cancel 仅设 flag，改为区分 flag-only 正常完成与实际 API 抛取消，后者外传并使旧/半输出不可用，cleanup 不删他方输出，输入不变，retry 正常。write/close/move 故障仍实际命中、cause 保持。
- conflicts：S01/S16/S06 共写/共测试；S09 仅为历史冲突。S04 已结束，后续恢复采用最新取消语义。
- 单结果理由：整个 Strip 输出从 rewrite 到 workspace publication 同属一个独立 producer，必要 fixture 更新只证明该谓词，不合并 Mixin Task 的独立结果。

### MS-S05 — discovery 只返回实际消费的数据

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：host discovery 对 caller 只交付有序配置名与实际需要的 side 数据，内部仍准确判定重复同名配置的真实歧义并发现全部适用 metadata。
- scope/effects：Map 的值不再对只读 keys 的 caller 外露，返回有序 List；保留本地 origins 内容比较、environments 与 child active 消费、sources→target 顺序和所有 listing rules。只删除可证未用的数据/重复工作；不可因 child 不看 value 删除 host 判定，也不去掉真实 side 参数。
- write owner：MixinInputs/produceMixins 及实际引用/反射 caller；必要 Forge/Fabric/SPI/preapplication/resource tests，child 签名仅在确有未用参数证据时改，不改变既有 config List 边界。
- 必需 evidence：同名相同 bytes 可发现/通知且不引入 uniqueness，异 bytes 真歧义清楚失败且原 inputs 不变；配置及 side 合并、双 metadata 不同集合都发现、sources/target 顺序及原路径/原字符串通知身份保持；真实读取/关闭失败外传。迁移 Forge `hostDiscoverySeesBothDistinctFormatsAndSingleFormatArchives` 对整个 Map 的反射断言；[MixinResourceTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java) discoveryRejectsDifferentConfigBytesWithoutChangingInputs 保留；用真实 producer side/双格式接点而非仅比较返回类型。
- conflicts：S02 平台 tests；S03/S06/S10 的 host/tests。没有 S02 成功依赖，按最新文件串行合并。
- 单结果理由：原样发现/判歧义能力上的数据交接收窄可独立完成，child 已接 List 的完成效果不重做。

### MS-S06 — 两个 producer 复用同一真实祖先解析

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：Mixin 与 Strip 的相同 destination 真实祖先解析只保留一个内部实现，两个实际 caller 均使用它且各自原有物理输入/输出保护不变。
- scope/effects：直接复用现有 mixinDestination（可改为 internal），迁移 Strip caller 并删除重复 destination 实现，不建立新资源/路径框架。两侧保护仍在破坏性动作前执行：真实祖先与 NoSuchFile/访问失败、真实路径别名、硬链接、受保护目录包含、Task 两输出不同与各自 active writer ownership 均保留。额外目录检查只在实际证明冗余时删，不以 normalize 或目录最终会读失败代替保护；没有证据多余的分支保留。
- write owner：produceMixins 的现有 resolver、StripMixins 的重复 resolver/调用、必要 producer/input-binding/isolation/StripMixinsTests；不修改 raw 输入或新增外部接口。
- 必需 evidence：源码显示两个实际 caller 使用一份真实祖先算法而非复制/同形替代；[MixinInputBindingTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java)的真实 Windows parent alias/hardlink/目录输入与相邻/缺失祖先合法输出，producer 两输出间 alias、受保护 runtime/source/implementation/mapping；Strip 的 originalAndCleanupAliasesHardlinksAndDirectoryContainmentAreProtected、realParentAliasesAndConflictingWritersDoNotMutateInputsOrWinner 及合法缺失祖先/相邻输出；两侧冲突 writer 不混写、失败 cleanup 不删赢家/原输入，实际访问/move 失败传播。后续 Result 分别说明两侧观察与被删防御的冗余依据。
- conflicts：S04 的 Transform/Strip tests；S03/S05/S10 的 host/tests；S08 运行环境。按共同方向串行，不把冲突误作前项成功依赖。
- 单结果及迁移检验：当前两函数的真实祖先解析算法相同，目标是这同一算法不再重复；只调一个无新消费者的 helper 可见性没有独立可消费的简化结果，保留旧 Strip resolver 则仍未去重。因此一份算法与两个必要调用迁移同属本谓词；两个既有生产者的安全策略只是要保持的原合同，不在此另交付独立新策略。若后来提出各自不同的保护政策变化，不可吞入本项。

### MS-S08 — recorder 仅保留必要 context 选择

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- readiness：原准备时点为供局部独立审查的策略、未声明 ready；后来全覆盖审查 completed、无阻断，且获用户实施确认。旧 strict 前提下未证简单单次读取的历史保留；默认政策已接受，不等政策决定，也不以零二次读取为完成要求。本轮没有重审或实施本项。
- completion predicate：recorder 仅保留 required context 存在性/无歧义默认选择与固定所必需的局部处理，使用适用默认 decoder，不额外 strict 或独立复验 native 正常结果的有效性；实际 selected member/class mapping、native 正常 fallback 和合同必需失败保持。
- scope/effects / write owner：[GradleMixinRecorderExtension](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/GradleMixinRecorderExtension.kt).checkActive、现有 SelectedContext 和必要 mapping/producer 聚焦 tests。复用 config.refMapper 与现有 TCCL resource/use/DOM 接点；去 `throwOnInvalidSequence = true`（若 S12 已去除则复用其实际效果），只用 `data`/`mappings` 元信息判定显式存在性和多 context 无可用默认。native mapper 不提供完整 context 查询，故允许为这些最低义务保留一次局部二次 DOM 读取；不另做完整 refmap 解析/映射计算、坏字节扫描、缓存/拦截或单次读取新协议，不改 OperationService/loader。所需读取会再次开流并解析整个 DOM，是保留 accepted context 的成本，不能宣称完全去重复解析。
- 必需 evidence：[MixinMappingTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java) realRefmapMemberInfoChainKeepsRawKeys（含宿主 obf=other 而显式 selection）、invalidTupleNamespaceContextAndDirectionPublishNothing、noMappingLegacyRefmapAndContextOnly 的真实注入/失败；补多 context 无默认须显式、可用无歧义默认、SelectedContext member/class 实际结果，保留 owner/overload/descriptor/namespace/direction 链、config+原 entry 通知身份。显式 context 不存在、mapper 默认/不可用且要求显式 context 均失败；无显式要求的无 refmap/default mapper 保留 native 正常行为。环境不能覆盖显式选择；不整块 `return true`。wrapper 信息不足只在不能履行 required context 时报告精确 gap，不仅因类型/未知字段独立判其正常结果无效。
- 默认行为与失败验收：[ProducerDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt) 的 realRefmapReadStillRejectsInvalidUtf8 是旧 strict 负例（未知 custom 字段含 0xFF、MalformedInputException、两输出不发布），未来须实际迁移到当前默认 decoder 的观察，不能留作当前必须 strict 或假称已通过。refmapUnknownFieldsFollowInstalledDomThroughRealMappedInjection 继续观察已安装 DOM 的未知字段/重复键/控制字符语义与真实 mapped injection；不保证所有坏输入相同结果或统一 DEFAULT_MAPPER。分别覆盖 native 内部捕获后正常 fallback、向外抛的真实转换异常、必要 context 读取开流 null 的 unavailable、取得流后的 read/close 与可获得 cause。null 只豁免 JDK loader 打开时不可获得的 IOException cause，不豁免必需输入、后续 read/close/直接 I/O/写出/恢复失败，原输入/两输出失败保护保持。日志严重性不作成败判据。
- 与流读取的连接：本项负责职责/选择和旧 refmap strict 语义断言；S12 独立负责 decodeFromStream/use 与中间 bytes 退出及真实流故障。两者共享 recorder 需串行，采用前项最新效果，不重做已完成改动或重复相同断言；S12 改调用点后必须核对本项真实 mapping/context 证据仍适用。
- conflicts：S11 共享 ProducerDom/mapping tests，S12 共写 recorder，及原 producer items/JVM state；保守方向 S06 → S08 → S12 → S10，本项不新增 OperationService/applyMixins 写面。
- 单结果理由：去独立复验并保留必要 context 是一个可用 naming contract；二次 DOM 读取是现有接口限制下的必要承接，不是另交付新解析设施。通知收集/postApply 不重做，输出编码另列 S10。

### MS-S09 — Strip 未编辑资源按流复制

- state: blocked
- Router 已采用阻断：执行者将 repo 路径误定位，缺少 cloche 层；未改文件、未运行测试。旧 Result 保持 blocked，以下原完整要求冻结为历史与恢复对照。
- wave: MS-W01（历史归属；已退出活跃 itemIds，由 MS-S16 承接）
- prerequisiteItemIds: []
- completion predicate：Strip 对不需编辑的普通资源按流复制，所需局部缓冲仅留给实际 JSON 编辑/STORED 输出，配置与资源保留及真实 I/O/关闭/完成语义等价。
- scope/effects / write owner：ExactMixinStripper.rewrite 的 ordinary entry 复制与直接测试/probe；不改 child 已完成 copyTo，不改 class transform/defineClass bytes，不引入 JSON decodeFromStream 或改变输入编码。
- 必需 evidence：压缩普通资源、空资源、目录、STORED（含需要编辑配置）均可读且内容正确；不变配置原 bytes、其它 entry 元信息按现有合同保留；actual resource read/output write/close 失败外传且失败输出不消费，故障 hook 覆盖 read(byte[],off,len)/新实际 copy 调用，不能只覆 readAllBytes。源 JAR 原样、流/use 关闭；不用仅检查 copyTo 字符串或内存基准代替内容/故障证据。
- 聚焦接点：StripMixinsTests 精确编辑/STORED/I/O，必要增加最小直接 copy read-failure 接点；child 的 streamedResourcesKeepContentsOrderAndEntryMetadata 是已经完成事实，不能记为本项新实现。
- conflicts：S01/S04 同 stripper；S06 共享 Strip tests。推荐在 S01 后作冲突串行，但不要求 S01 completed 才具有业务意义。
- 单结果理由：普通资源 copy 的内存/资源行为能独立保留，精确 DOM 简化失败不必重做其完成效果，故不混入 S01。

### MS-S16 — 恢复 S09 未执行的 Strip 流复制

- state: completed
- 恢复边界：仅修正路径/上下文，项目根为 minecraft-codev，四文档位于 docs/works/mixin-simplification/。基于 S01/S04 后最新源码和取消语义执行；不重做其独立效果，不重开旧 S09。原安排由一个 Handler/Result 独立证明以下完整原谓词；现已 completed，范围与成功标准不变。
- wave: MS-W01
- prerequisiteItemIds: []
- completion predicate：Strip 对不需编辑的普通资源按流复制，所需局部缓冲仅留给实际 JSON 编辑/STORED 输出，配置与资源保留及真实 I/O/关闭/完成语义等价。
- scope/effects / write owner：ExactMixinStripper.rewrite 的 ordinary entry 复制与直接测试/probe；不改 child 已完成 copyTo，不改 class transform/defineClass bytes，不引入 JSON decodeFromStream 或改变输入编码。
- 必需 evidence：压缩普通资源、空资源、目录、STORED（含需要编辑配置）均可读且内容正确；不变配置原 bytes、其它 entry 元信息按现有合同保留；actual resource read/output write/close 失败外传且失败输出不消费，故障 hook 覆盖 read(byte[],off,len)/新实际 copy 调用，不能只覆 readAllBytes。源 JAR 原样、流/use 关闭；不用仅检查 copyTo 字符串或内存基准代替内容/故障证据。
- 聚焦接点：StripMixinsTests 精确编辑/STORED/I/O，必要增加最小直接 copy read-failure 接点；child 的 streamedResourcesKeepContentsOrderAndEntryMetadata 是已经完成事实，不能记为本项新实现。
- conflicts：S01/S04 同 stripper（已结束，不存在当前并发等待）；S06 共享 Strip tests，现行方向 S04 → S16 → S06。无业务成功前置，不等待 S09 blocked 或 W01 release；后项使用最新文件并核对 S01/S04 的组合证据，受影响处最小补验。
- 单结果理由：普通资源 copy 的内存/资源行为能独立保留，精确 DOM 简化失败不必重做其完成效果，故不混入 S01。

### MS-S10 — 通知文件按现有语义直接流式编码

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：host 通知文件直接编码到所持输出流，仍是相同 resource→原始字符串集合语义且在 loader 关闭/entry close 后才完成两输出。
- scope/effects / write owner：produceMixins 的通知 JSON 写出（encodeToStream）和实际 producer/lifecycle/consumer tests；不改 JSON 读取、数据 schema、排序承诺或 Gradle tracking，不重做已完成 Kotlin outputStream 替换。
- 必需 evidence：真实通知含非 ASCII/转义、重复集/empty，旧等价 DOM 和独立 Strip 消费一致；archive→materialized JDK graph→loader close→entry write/close→pair 完成顺序保持。实际 mid entry-write/entry-close/second-move 失败的 outward cause/suppressed、旧 pair 不消费、retry 保留；调整 LifecycleIO ASM 接点到实际 encode stream，确认命中。核对现有 TestKit 文件 provider/参数追踪/缓存恢复证据对新实现是否适用，有缺口才补一个真实消费/无 producer memory 恢复路径，不默认全量重跑。不得声称输出流编码解决坏 UTF-8 输入选择。
- 聚焦接点：MixinProducerTests.actualProducerGraphClosureAndMidStreamFailures 与 MixinInputBindingTests 的现有 caller/current-input/cache-restoration 场景，最小选择由实际影响决定。
- conflicts：producer host/lifecycle/shared build 运行，与 S03/S05/S06/S08 串行。
- 单结果理由：中间输出 bytes 退出且文件仍可消费是一个通知输出合同；测试/probe/必要消费观察只证明此谓词，无独立额外审计或终验项。

### MS-S11 — child 原始配置及 parent 按流读取

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：child 为原通知键读取配置及 parent 时，统一走作用域内关闭的默认 JSON stream decoder，无额外 strict/扫描或纯解析所用整份 ByteArray，parent 遍历与原始身份语义不变。
- scope/effects / write owner：[applyMixins](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/applyMixins.kt).readOriginalEntries 及直接 ProducerDom/resource/producer fixtures/tests；不改 class transform 的必要 bytes、native 注册/校验策略或已完成 child 普通资源 copy。
- 必需 evidence：配置与 parent 均实际 decodeFromStream/use；有效非 ASCII、重复/控制字符/未知 DOM 遵循 installed DOM，坏 UTF-8 在未知字段按实际默认 decoder 观察，既不额外 strict 也不预定成功/拒绝；实际 producer 调用/通知保留完整 config path＋原 entry（含 parent 来源）、side/业务 shapes、visited traversal 与 missing/unsafe parent 必需失败。迁移 [ProducerDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt).invalidUtf8ShapeResourcesSideAndPathsCannotReuseEarlierSuccess 中仅 UTF-8 专属预期，保留其余真实业务/路径/先成功后失败保护；childConfigAndParentFollowInstalledDomWithoutAdditionalSyntaxPolicy 提供实际父子入口。UTF-8 观察必须带可处理的有效 config/parent，否则仅因缺 mixins 失败不能证明默认行为。
- 流故障证据：分别在 config/parent 实际读点注入 read、close（含 read＋close suppressed）并确认命中、新 use 关闭和 outward available cause，失败不消费旧 pair、原 inputs 不变、fresh retry；loader-open unavailable 可在本路径验证但其跨消费者政策销账归 S15。不仅改 mock 或搜 decodeFromStream 字符串。
- conflicts：S03 共写 applyMixins，S05/S08/S12/S15 共享 ProducerDom/consumer tests；按共同方向串行，无业务成功前置。
- 单结果理由：配置和 parent 经过同一 readOriginalEntries 队列/decoder，parent 原键是本次通知映射不可缺的递归输入；必要 caller/fixture/负例共同证明这一个 child 原键读取合同。无需拆成每个 JSON 文件一个 item；它可独立于取消删除、refmap 或 Fabric 读取保留和恢复，故新增独立 item。

### MS-S12 — 必要 refmap context DOM 按流解码

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：recorder 仍需执行的 context DOM 读取直接从受 use 管理的流以默认 decoder 解码，不再为纯解析 readAllBytes/decodeToString，并保持当时 required context/native mapping 合同及真实流失败因果。
- scope/effects / write owner：GradleMixinRecorderExtension.checkActive 读取接点及直接 ProducerDom/Mapping/resource fixtures/tests；不新增 context 查询 API/cache/service 拦截，不改 native ReferenceMapper 或 loader。与 S08 共写，若前项已默认化则沿用；此项不能顺带删除/扩张 context 职责，S08 的独立职责收窄仍有自己的完成谓词。
- 必需 evidence：实际必要二次读取采用 decodeFromStream/use，无额外 strict/扫描/中间整份 bytes，保留整 DOM 成本披露；坏 UTF-8 未知字段实际经过该读点且按安装 decoder 观察，S08 已迁移的 realRefmapReadStillRejectsInvalidUtf8 及真实 mapped invocation/通知断言核对适用性，有调用变化才补最小验收。以非 default native mapper＋显式可用 context 确保读点真的执行，不能用提前 fallback 跳过读取当流化通过。
- 流故障证据：在实际必要读取取得流后注入 read/close 与合并 suppressed，确认命中/use 关闭、available cause 外抛、原输入/旧 pair 保护及 retry；JDK open null 仍是 unavailable，native 内部捕获正常 fallback 不强制外抛。核对 S08 的显式缺失、多 context 歧义/可用默认、固定 member/class mapping 最后组合版本证据；未影响部分可复用，不能要求整套重跑。
- conflicts：S08 共写 recorder，S11/S15 共享相关测试；保守 S08 → S12 → S10 → S15。没有 S08 成功 Result 前置；两种简化可独立留存，图内互斥只保证使用最新状态。
- 单结果理由：把必要读取从 bytes 改为 stream 有独立可保留/重试的资源效果；即使 S08 的职责收窄后来失败，该读取迁移仍可成立。context 的保持测试只验证该迁移，不能把这项独立终态藏入 S08。

### MS-S13 — Fabric metadata load 默认流读取

- state: completed
- wave: MS-W03
- prerequisiteItemIds: []
- completion predicate：Fabric listing 的实际 load 直接用默认 JSON stream decoder/use 读取 metadata，不再 Files.readString 中转；discovery 仍只读且保留原 reference/side/顺序和业务失败。
- scope/effects / write owner：[FabricMixinListingRule](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt).load 与必要 [FabricMixinMetadataTests](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt)/discovery fixtures；不改当前 metadata edit、公开 API 或 Forge/NeoForge 读取。
- 必需 evidence：实际 decodeFromStream/use、无 strict/扫描/readString；有效标量/对象/数组 references、未知内容、side/顺序、metadata 缺失/无 mixins 的既有返回和只读原 bytes 保持。迁移 invalidUtf8OtherSyntaxShapesPathsAndSideValuesStillFail 中 load 的 MalformedInputException 专属预期；含有效 references 的坏 UTF-8 未知字段按实际默认 decoder 验收，保留其余实际 DOM/shape/path/side 负例。librarySyntaxPoliciesPreserveUnknownDomThroughLoadAndBothEdits 的 load 部分继续按安装 DOM 观察。
- 流故障证据：新 load 实际输入 read/close 与 read＋close suppressed 故障均命中并外传 available cause、流已关、源 JAR 不变；补现有 edit-only 故障 fixture 无法覆盖的 load 接点。真实 host discovery/producer 正常消费至少复用一个适用场景，若 S05 后改 tests/数据流，由其核对最终版本，不默认重跑全套。
- conflicts：S02/S14 的 Fabric metadata tests、S05 discovery tests；S02 → S13 → S14 → S05 串行，无业务前置。
- 单结果理由：load 的只读 discovery 可在 edit 仍用旧读法时独立成功/消费/重试；与 S14 分开。默认化、stream/use 与直接负例只证明本 load 结果，不兼任 API 删除。

### MS-S14 — Fabric current metadata edit 默认流读取

- state: completed
- wave: MS-W03
- prerequisiteItemIds: []
- completion predicate：Fabric 保留的 remove 在编辑当前 metadata 时以默认 stream decoder/use 读取，不再 Files.readString 中转；仅删除 snapshot 原引用集，未知/新增/current 内容与真实读写关闭失败保留。
- scope/effects / write owner：[FabricMixinConfigHandler](../../../minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinConfigHandler.kt) 的当前编辑读取及必要 FabricMixinMetadataTests/直接 fixtures；若 S02 已删除 public 入口则改其最新私有编辑接点，不复活旧入口、不重做输出已完成 encodeToStream/Path API。
- 必需 evidence：实际 decodeFromStream/use、无 strict/扫描/readString；load 后追加 reference/unknown 再 remove，实际重读当前 DOM，仅移原引用、新增/未知/顺序与 snapshot/list 保留。迁移 invalidUtf8OtherSyntaxShapesPathsAndSideValuesStillFail 中 remove 的 strict UTF-8 预期；旧 public removeConfigs 的调用由 S02 删除，不能将其通过数再计为新验收；librarySyntaxPoliciesPreserveUnknownDomThroughLoadAndBothEdits 与 bothEditsUseCurrentZipMetadataAndKeepDiscoverySnapshot 适配保留入口，按实际 decoder/DOM 验收坏字节未知字段而不整类删业务负例。
- 流故障证据：actualReadWriteAndCloseFailuresEscapeBothEditEntrypoints 迁移到实际保留入口/新输入调用，确认 input read/close、write/output close 及 primary/suppressed 故障命中/因果不丢，失败不是成功编辑；取得 metadata DOM 并关闭输入后才写出，不在 open input 上截断原文件。其边界不要求新事务/回滚框架。
- conflicts：S02 共写 adapter，S13/S05 共享 metadata/discovery tests；按 S02 → S13 → S14 → S05 串行，无业务成功前置。
- 单结果理由：current edit 的读取与保持/写出验收形成一个实际编辑终态，可在 load 未迁移时保留且单独恢复；与 S13/S02 分开，必要 fixture 与调用适配不另拆。

### MS-S15 — loader 原生 open-null 的实际消费者验收

- state: completed
- wave: MS-W02
- prerequisiteItemIds: []
- completion predicate：已删除 override 的原生 loader 在实际必需输入及允许可选 fallback 消费路径上符合已接受 open-null 政策，旧 cause 专属拒绝预期已迁移并经聚焦运行，取得流后的真实失败与可获得 cause 未被豁免。
- scope/effects / write owner：[MixinResourceTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java) 及必要实际 producer/child/Mapping fixtures/tests；生产 loader/OperationService/输入读取实现只读，不恢复预读/包装，不重做已通过八项实现。若发现真实生产缺陷超出本验收，返回具体未满足 predicate，不能将其作为通过或擅自改图。
- 必需 evidence：使用真实 IsolatingMixinClassLoader/JDK resource-open，注入可观察的 opening IOException，确认 open 被尝试、返回 null/unavailable 且无原 cause 要求；通过真实 child 原键配置读取及必需类/字节码消费分别观察明确 unavailable/required 失败、旧 pair 不可消费/原输入不变/新鲜 retry。defineClass 直接 stream 的 IOException 有 cause 时仍保留，不能错误套用 getResourceAsStream 的 null 豁免。分别通过 native 可选 refmap（无显式 required context）正常返回/fallback 和真实 engine outward failure 观察完成/阻断差别；日志严重性不作判据，显式 context 不可用仍须失败（可复用 S08/S12 的适用证据）。
- 剩余与复用边界：旧 cause 负例无可读 repo 精确 selector，按已采用失败语义在现有资源/真实消费 fixture 建最小直接验证并列实际 selector，不要求恢复会话/复制 Result。已有 actualResourceReadAndCloseFailuresRetainCauseAndSuppression 的无预读/read/close/suppressed 与 Windows 释放分轮证据，先核对源版本/环境/调用变化，仅变动或确有缺口处补验；直接文件/JAR、写出、恢复不落入 open 豁免，复用对应未变 item 证据。无需机械重跑旧八项或全部产品 tests。
- conflicts：S11/S12/S08 共享实际 child/refmap/consumer fixtures，S03/S05/S06/S10 共享 producer/JVM/build 状态；保守串行最后 S10 → S15，以最终读取版本补消费验收，无上述项 completed 的业务前置。旧 loader partial 保留，新证据只完成本 item，不追认历史状态。
- 单结果理由：这里交付一个已接受 loader 资源合同的剩余消费验收事实；required/unavailable、optional 正常返回和真实向外异常是同一合同的必要对照，fixture/断言迁移仅证明这一事实。实现 override 删除及既有释放效果已扣除，JSON 流迁移分别归 S11–S14，不混入本项。

## 原待办对应与扣除

| 原项 / 本轮 settled 意图 | 本图对应或排除事实 |
| --- | --- |
| A / ① 精确 strip | S01；未编辑普通资源流化原 S09 blocked，由 S16 完整恢复，取消独立 S04。 |
| B / JSON 流读取 | cleanup removals decodeFromStream/use 已完成扣除；S01 edit 默认化但保必要原 bytes；S11 child config/parent、S12 必要 refmap context（连接 S08）、S13 Fabric load、S14 current edit 分别承担 stream/default/use/实际失败。class bytes、未变配置原 bytes、STORED 输出 size/CRC 保留。MS-W01/02/03 共同覆盖全 B。 |
| C / 初始化局部清理 | 已 completed，扣除；S03 只处理当前取消检测变化，不重放 Closeable.use。 |
| D / ② 删除公开入口 | S02，完整平台/直接 callers/tests 必要迁移同一谓词。 |
| E / ④ discover | S05，保留 host 同名内容判断、真实 side、双 metadata、身份和顺序。 |
| F / ⑦ 普通资源复制 | child 已完成扣除；stripper 原 S09 blocked，剩余由 S16 完整恢复，class bytes 仍必要。 |
| G / ③ 去轮询 | S03 producer＋S04 Strip；当前实查 8 处，不将旧计数当硬上限。 |
| H / 输出名 | 已完成命名与三个真实消费者，扣除。 |
| I / ⑦ 通知编码、Kotlin I/O | S10 补 host encodeToStream；五处 Path API 已落地/fixture 补验 1/1 扣除，不重跑29项。原27/29的 UTF-8 剩余按实际读点归 S08/S12（refmap）、S11（child 混合负例）、S13/S14（Fabric load/remove）；S01 承担 Strip 自身默认化。保留 partial，由对应实际新证据验收余项而不升级旧记录。 |
| J / loader 原生流 | override 删除与8项分轮/Windows/read-close效果扣除且 partial 保留；S15 单独承担旧 cause 预期、新 open-null 必需/可选消费及真实 outward 对照验收，S11/S12 保各自新流 read/close。政策不代测试，原 partial 不追认为 completed。 |
| K / ⑤ destination | S06，同一现有真实祖先算法及两侧必要迁移；保留真实输入/alias/hardlink/containment/并发 owner，不默换 normalize。 |
| L / ⑥ checkActive | S08 收窄为去 strict/独立原生有效性复验并保留实际 selected mapping、必要 context 与失败；接受 context 所需二次 DOM 读取，不再要求零二次解析；全覆盖独立审查已 completed、无阻断；本项真实验收已由 Router 完整采用。 |

所有编号只提供唯一引用，不限定执行顺序。三 Wave 均无前置 gates；联合模型中每 gate 等全部活跃 members（W01 使用 S16，S09 仅存历史），每 item 无 item/gate 前置；加入声明冲突串行方向和保守路径仍不得有环。最终 Plan 完成须三 gate 全满足，不能用原九项的有利审查代替新增五项的未来结果。实际作者静态/语义核对见 [Plan](plan.md#作者语义自检)。
