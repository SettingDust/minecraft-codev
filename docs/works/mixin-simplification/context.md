# Mixin 简化 processed Context

[Work](work.md) · [Plan](plan.md) · [Waves](waves.md)

下文原准备轮政策、源码和待验证记录按其时点保留；当前采用的审查/确认、S01/S04 完成与 S09 阻断/恢复事实见文末，原描述不代表后续源码仍未修改。

## 来源及使用限制

本文件处理本轮 Handoff 已可靠采用的状态、完整读取的 A–L coverage Result 和现行项目材料。项目外 Result 只用于本次读取，不保存其路径，也不建立经 Context 中转的仓库依赖。这里不承诺完整原始 Results 永久可读，不是原始证据包、权威或新运行记录。

本轮采用 Handoff 已完整 adopt 的 authority assessment：PRD reuse，Spec 默认行为 update 与同 identity ADR update 均 completed；对现在可读的英文 PRD、Spec、ADR及中文 Spec 的受影响条款作核对，不重做 A–L 研究。原 A–L Result 的 J 限制曾触发政策核定，现已由默认解码/open 接受决定解决其规范冲突，原 partial 与未完成验收不变。原准备轮的 owner/消费者观察继续有界复用；本轮定点读取 recorder、child 的原始条目读取、OperationService、MixinInputs、Fabric adapter、ProducerDomTests 和 mapping 测试接点以准备修订，没有候选实现或运行测试。

## 必须扣除的已完成效果

以下状态来自已采用记录；“后来通过”不会改写此前 partial。源码观察仅印证当前落点，不补造历史命令、选择器或独立测试数量。

| 已有结果 | 已完成效果、实际验证及不足 |
| --- | --- |
| [旧重设计 Work](../mixin-kotlin-first-redesign/work.md) | 当前旧活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 completed；Router 已判旧 W04/W05/W06/W07 satisfied。旧 I01 blocked、I03 partial、R01/I02 completed、旧 W01 satisfied、旧 W02 未释放、I04 未执行、旧 W03 pending 保留；S01/S09 partial 保留。不能把旧 gates 自动继承到新图。 |
| produce/apply readability | 已具名顺序整理、两个私有函数、child 接配置名 List；child 普通资源已流式复制。原 readability/g1 **partial** 后，资源缺口由独立清单 stream `use` 修复完成，Windows 失败回归 **3/3 通过**；原 status 不变，未提供完整轮次命令，不补造。 |
| initializeMixinRuntime 局部清理 | `Closeable.use` 和四项直接回归完成；本图不再实现这一清理，不重放其独立效果。后续删除中断轮询只调整受影响取消断言，不能破坏已完成恢复。 |
| Strip 输出命名 | `<base>-mixinStripped.jar` 与三个真实消费测试完成；不再改名，不重复交付。 |
| codev-kotlin-file-io/g1 | 五处 Kotlin Path I/O 替换已落地，但 **partial**：29 项中 27 过、2 失败。resource fixture 只覆盖 `readAllBytes` 的缺口后来由 codev-resource-read-hook-fix/g1 **completed** 补齐原方法，1/1 通过；未重跑 29 项，坏 UTF-8 负例仍需按新默认政策实际验收。不能称 29/29 或追认原 partial completed。 |
| codev-loader-native-resource-stream/g1 | **partial**：预读 bytes 的 `getResourceAsStream` override 已删，8 项聚焦测试通过，Windows 释放与消费端 read/close 有证据。后来 JShell 实测 JDK 打开 IOException → null 丢 cause，当时未被接受且 cause 负例未过；如今选择已接受，但未迁移/重跑旧 cause 断言，不能据此将该项追认为 completed 或 release。 |

旧轮更详细分轮、失败修正、版本及复用限制由 [旧 Context](../mixin-kotlin-first-redesign/context.md)保存；本次不改旧记录，且上述后续结果不因旧材料缺少逐轮细节而被否定。后续复用仍需按源版本、输入、环境、变更面判断，历史通过数不是当前运行证据。

## 已接受默认行为与尚未完成的证据

1. **JSON UTF-8**：现行 Spec/同 identity ADR 已接受已安装库/引擎的默认解码（适用时可替换坏字节），包括未知字段；不得另加 strict decoder 或字节扫描。没有统一替换、全部坏输入成功/必拒绝或一律 DEFAULT_MAPPER 的保证。serialization 1.3.3 的 `decodeFromStream` 不再因替换行为与权威冲突；实际 DOM/业务形状、精确原字符串和真实失败仍须验证。[ExactMixinStripper](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/ExactMixinStripper.kt)的 cleanup 已流解码，edit 仍 strict；S01 在现有精确编辑谓词内去掉该 strict 分支并迁移相应 UTF-8 断言。S08 的 refmap context 读取同样去 strict，原生解析保持原生。
2. **loader 打开**：[IsolatingMixinClassLoader](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/IsolatingMixinClassLoader.kt)继承的 JDK `getResourceAsStream` 打开 IOException→null/不可用已被接受，可无原 cause；不得为恢复 cause 加预读/包装。必需输入不可用仍清楚失败；native 正常 fallback 保留。此例外不推广到取得流后的实际 read/close、直接文件/JAR I/O、写出、selector/TCCL 恢复或可获得 cause，且不授权 Codev 吞异常。测试须区分 native 内部捕获后正常返回与真实向外异常，不用日志严重性裁判。

政策接受没有补上运行证据。旧 partial、UTF-8 负例和 loader cause 事实保持历史；新增 S11–S15 将其剩余验收分别归属，不能升级原 partial。S11 覆盖 child `readOriginalEntries` 的 config/parent，S12 覆盖 recorder 必要 context 的实际 stream/use，S13/S14 覆盖 Fabric load/current edit，S15 覆盖 loader open-null 的必需/可选消费者对照。S01/S08 仍只负责自身谓词，但相关最终组合版本必须核对这些读取证据；class bytes、Strip 原 bytes、STORED size/CRC 等必要缓冲保留。当时全部 items/gates 仍 pending，政策接受不等于运行通过；后续状态见文末本次采用事实。

## 已采用的独立审查与有界可行性核定

旧 codev-simplification-plan-review/g1 **completed**，当时唯一重要阻断为 S08 与 strict UTF-8 耦合，影响 MS-W02/Plan；其余八项无重要阻断且拆分/冲突通过。后续 codev-refmap-read-boundary/g1 **completed**：在旧 strict 前提下没有找到简单单次读取接点，不证明所有方案不可能。codev-refmap-plan-correction/g1 **completed** 仅纠正四文档、保留九项/不 ready，当时 66 本地链接及联合图检查通过。历史不删除；新政策取代旧 strict 前提，不能沿用旧结论直接判本版不可行，也不能将旧审查当作本版通过。当时全部 items/gates 仍 pending、无本九项 C4 确认；后来的全覆盖审查与用户确认见文末。

已采用核定的锁定 `net.fabricmc:sponge-mixin:0.15.0+mixin.0.8.7` 事实：ReferenceMapper String 入口用 InputStreamReader/Gson，部分 Exception 被内部捕获而正常 fallback；公开 Reader 重载也捕获异常且不是当前注入入口。公开 mapper 能执行 remap/get/set context，但没有完整 context 存在性/枚举查询。新的默认解码政策消除了额外 strict 验证的必要性，没有增加 context 查询 API；原生 read/close 被内部捕获的情形不能被要求一律外传。

本轮定点源码印证：[recorder](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/GradleMixinRecorderExtension.kt)在原生选择后读取 `refMapper`；default/null mapper 在无显式 context 时跳过，有显式 context 时失败。非 default mapper 的二次 DOM 读取检查显式存在性、多个 context 且无 mappings 默认的歧义；SelectedContext 委托 `remapWithContext` 及 IClassReferenceMapper，并阻止后续 setContext 覆盖。`postApply` 的原始 config/entry 通知身份与这些选择职责不同，不能整块 `return true` 删除后者。[OperationService](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/IsolatedMixinService.kt)直接委托 loader，不提供已解析 context 清单。

S08 的最小可行策略据此收敛为：实际 mapping 继续使用已解析 native mapper/现有 SelectedContext；删除 strict 解码与独立原生有效性复验，但保留当前 API 无法替代、用于 context 存在性/无歧义默认判断的局部二次 DOM 读取（默认 decoder＋`use`）。这项读取不是 refmap 重写或第二套注入校验，不承担扫描未知坏字节的职责。它仍可能再次开流/解析整个 DOM并有真实 read/close/DOM 失败，因此必须披露其成本及失败出口，不能声称“零二次解析”。先复用当前接点，不新增缓存、服务拦截、单次读取协议或框架，也不扩展 service/child owner。未知 wrapper 字段本身不拒绝、不改写、不保证兼容；确实无法落实 required context 时提供精确受影响缺口，不猜选择。

该策略由现有接点和 Spec 保留的 required context 职责支持，是准备可行性而非运行证明。需要独立局部审查 S08 的“只留必要 context 读取”与 S01 默认化、MS-W01/MS-W02 gate 及九行验收的连接；其余八项原分组/冲突结论继续有界复用。没有新的 authority gap；若实施发现只能违反 required context/native fallback 才成立，必须返回具体 gap，不能自行放宽。

[ProducerDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt)中 `realRefmapReadStillRejectsInvalidUtf8` 的历史负例是未知 custom 字段含 0xFF、期待 MalformedInputException 且不发布两输出；该**严格拒绝预期被政策取代**，保留 fixture 后改为按实际 default decoder/native 结果验收，结合真实 mapped invocation、通知和原输入保护，不能仅删测试或宣称现已通过。`refmapUnknownFieldsFollowInstalledDomThroughRealMappedInjection` 的 duplicate/control/unknown DOM 观察按适用 installed DOM 保留，实际 native fallback 独立区分。混合用例 `invalidUtf8ShapeResourcesSideAndPathsCannotReuseEarlierSuccess` 也须分开其 UTF-8 专属断言与仍有效的业务/真实失败，不将整类负例删除。

[Mapping tests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java)的真实 member/class 注入、宿主 obf 冲突下显式固定、显式缺失、namespace/direction、默认/无 refmap保持；补多 context 无默认、可用无歧义默认及实际 class 路径证据。原生正常 fallback、loader-open null、取得流后的真实 read/close、直接文件/JAR 与引擎抛异常分别观察。上述均是未来验收，不是本次已过；原核定的字节码/API/catch 表检查仅采用其已提供事实，本轮未重新检查依赖二进制。

## 原准备轮源码事实与实际消费者

以下主要复用原准备轮的 owner/消费者事实，不重查九项；本轮定点核实的 recorder、child 读取及默认化限制以上节为准。

| Owner / 可读源码 | 当前事实与计划约束 |
| --- | --- |
| [ExactMixinStripper](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/ExactMixinStripper.kt) | `rewrite` 手写清单 root/元素检查、名称/路径/空白限制、ZIP 重名集合与逐 entry 输入 size/CRC 复验；普通 entry 全读 bytes。`edit` 对三数组过滤，未变时返回原 bytes。删除额外检查与普通资源流复制可分别交付；STORED 输出仍需 size/CRC，S01 自身 edit 去 strict/默认解码须与精确三数组合同一起验收。 |
| [MixinConfigHandler](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinConfigHandler.kt)及三个 adapters | 接口仍有 `removeConfigs`；Fabric/NeoForge 的 `remove` 调它，Forge 两入口共享私有更新。平台 tests、Java SPI fixture 与 preapplication tests 有直接调用；不存在“主链不用即可只删接口”的迁移。完整删除公开能力必须同批迁移这些消费者，保留 `remove` 按 snapshot 选定资源编辑当前 metadata、保留新增及未知内容的语义。 |
| [MixinInputs](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinInputs.kt)与 [produceMixins](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/produceMixins.kt) | discover 返回 Map 的外部值仅由 host 取 `.keys`；但函数内 origins 值用于同名 bytes 比较，不能整块删除。environments 收集实际传给 child 的 side；不是未用参数。Forge metadata test 反射消费整个返回 Map，需必要迁移。最小收敛是向 caller 返回有序配置名，保留本地来源判歧义与 side 数据。 |
| produceMixins / [StripMixins](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt) | `mixinDestination` / `destination` 有重复真实祖先解析；两组件各有输入身份、目录包含、硬链接及 active output 保护，各自独立生产/失败边界。仅 normalize 不等价。不得以去重为由删保护，亦不为共享数行强制引入新框架。 |
| produceMixins / [applyMixins](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/applyMixins.kt) / StripMixins / ExactMixinStripper | 只读搜索当前生产代码有 **8** 个显式 `isInterrupted` 点：host 3、child 2、Strip Transform 2、stripper 1。Handoff 的“7 处”是先前计数；执行目标按 Spec 的不轮询合同覆盖实际全部 8 处，不能为凑数漏掉初始化点。两独立生产者分别交付；无新取消框架。 |
| [GradleMixinRecorderExtension](../../../minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/runtime/GradleMixinRecorderExtension.kt) | `checkActive` 读 native mapper 后重读 refmap JSON、检查 context、包 SelectedContext。后者真实固定 member/class remap 的 context，不能整块 return true。原要求的去重复/额外拒绝收敛为只留 required context 所必需的二次读取、去 strict 与独立原生复验；保留 context/default/多 context 和实际 mapping 结果，不再以单次读取作未经证实的硬前提。 |
| produceMixins 与 applyMixins | host 通知文件仍 `json.toString().toByteArray` 后写流；可等价 `encodeToStream`。child 普通资源已有 `copyTo`，不可重复实现；class transform/defineClass 仍需 bytes。 |

## 验证接点及影响

以下为原准备轮观察；S01/S04 后的已采用效果与限制以文末为准，不将旧源码描述当作当前状态。

已读取 StripMixinsTests 中精确过滤、重复 ZIP、CRC/坏输入、STORED、alias、write/close/cancel/move 接点，StripFixture 的 `cancel` 目前只设 flag；已读取 MixinProducerTests 的实际 I/O probe（`cancel` 同样只设 flag）、MixinMappingTests 的真实 context 注入/必需失败和 MixinResourceTests 的 discovery/read-close 接点。删除轮询时必须将 flag-only 与真实 API 抛取消分开，不能仅删旧取消断言或把 flag-only 当异常证据。流输出或读取调用变更时，ASM probe 需要覆盖新实际接点，不能再次出现只拦旧方法的假覆盖。

源码/测试入口由 [Waves](waves.md)列明未来证据；本次没有执行 Gradle、构建、测试、安装、Git 写入或模型/LSP运行验收。没有把可读源码、历史 test 数或旧 gate 当作新 items 完成。

## 本次可靠采用的执行与恢复事实

本节仅投影 Router 已完整采用/可靠关联的 Handoff 事实。本 Handler 未读取项目外 Result，不补造命令或完整原始证据。codev-full-coverage-plan-review/g1 completed、无阻断，其后用户已确认完整十四项实施及必要图维护；此前未审/未确认是准备历史。三族 authority reuse，不变行为。

| 关联 item | 已采用终态、验证与限制 |
| --- | --- |
| MS-S01 / codev-ms-s01-strip-filter/g1 | completed：最小三数组精确过滤及额外复验退出；8 项聚焦测试通过、无 skip，STORED 输出 size/CRC 和未变配置原 bytes 保留。不虚构精确选择器/命令/新 artifact。 |
| MS-S09 / codev-ms-s09-strip-stream-copy/g1 | blocked：执行者误定位 repo，路径缺少 cloche 层，未改文件、未跑测试。原完整谓词/证据保留于 Waves；MS-S16 仅恢复未执行范围，旧 blocked 不升级。 |
| MS-S04 / codev-ms-s04-strip-interruption/g1 | completed：删 StripMixins 两处、ExactMixinStripper 一处 isInterrupted；StripFixture/StripMixinsTests 区分 flag-only 与真实 API 取消。两次 Gradle 运行分别 11/11 StripMixinsTests、1/1 MixinInputBindingTests.testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput 通过，零 fail/error/skip，diff check 通过。 |

S04 实际观察：flag 在进入前/write/close 被置位仍成功、输出正确、原 inputs 不变；write/close InterruptedIOException 原对象外传，removals 打开检查注入 CancellationException 命中；write+close primary/suppressed 保持、真实 move 失败、旧/半/暂存清理不删他方完成结果、fresh retry 成功。Windows hardlink/父目录 junction/目录保护/冲突 writer 通过；真实 source/target Strip 失败不消费旧结果，独立 applied 输出 42 可消费。

本次核实可读的 repo 证据：[strip-unit.xml](../../../minecraft-codev-mixins/build/fixture-evidence/ms-s04/strip-unit.xml)（11 tests，0 failures/errors/skipped）与 [strip-consumer.xml](../../../minecraft-codev-mixins/build/fixture-evidence/ms-s04/strip-consumer.xml)（1 test，0 failures/errors/skipped，具名 selector 与上述一致）。XML 只证明保存的该轮测试摘要，不是本次重跑或完整 Result；两次运行命令未随 Handoff 提供，不补造。未覆盖取得 removals 流后的中途读取取消、OS 主动异步取消或更新 JDK；JDK17 SecurityManager 注入限制保留。

S16 已完成原 S09 未执行的完整流复制范围；S04 已结束，当前无并发写入/测试，故与恢复共写不构成反向等待。Router 已判定 MS-W01、MS-W02、MS-W03 均满足；本次只同步该判定与采用事实，不释放 gate、不重验。历史 partial/failed/blocked 保持不变，MS-S09 仍 blocked 且不属于活跃 membership。

### 本次新增可靠采用事实

Router 随后完整采用其余活跃 items 与三 Wave gate；以下仅记录已采用事实，不替代原始 Result、重跑或 gate 合同：

| 关联 item | 已采用验证事实与限制 |
| --- | --- |
| MS-S16 | completed：最终 6 项无 skip；普通资源实际 read/write/close、内容/元信息保持、source/target consumer 失败均命中；首轮 Java 11 不支持 API 的测试编译已修复。 |
| MS-S02 | completed：三模块编译、26 项测试无 skip；public API、三个 adapters、直接及 SPI 调用均迁移；三格式 remove 不扩大删除。仓外 source/binary 风险未知并保留。 |
| MS-S13 / MS-S14 | completed：Fabric load 12 项、edit 11 项无 skip；cwd/Gradle 环境预检失败不计测试；edit 读取失败不开输出，写后故障无事务回滚保证。 |
| MS-S05 | completed：7 项无 skip；有序 List、host 同名比对、side、双 metadata、顺序及真实 consumer 保持，最终调用链适用性已核对。 |
| MS-S03 | completed：三个聚焦方法分轮通过；flag-only 初始预期误要求真实 ZIP API 中断，已修正预期并补验，生产实现未改回。 |
| MS-S11 | completed：8 个不同方法分轮通过；config/parent 六组 read/close/read-close 命中，通知身份、原 inputs、双输出、retry、strip 保持；首轮两项错删未通知键断言已纠正补验。 |
| MS-S06 | completed：两轮 10 项无 skip；共用目的路径解析、Windows alias/hardlink/missing-parent/access、冲突及 retry 覆盖。 |
| MS-S08 | completed：5 项无 skip；默认解码去 strict，显式 context 固定、真实 mapping、fallback 与通知身份保留。必须区分真正 `codev-ms-s08-recorder-context/g1`，与 blocked 的 `ms-s08-recorder-context/g1`、`ms-s08-recorder-context-recovery/g1` 区分；两份路径 blocked 结果均无项目读写测试，后来 Resolver 引用 blocked 亦未启动。Router 误 join 身份已纠正。 |
| MS-S12 | completed：7 项通过；最终调整后的 2 方法另补跑无 skip；直接 decodeFromStream/use、实际 read/close/suppressed、mapping 与 retry 均命中。 |
| MS-S10 | completed：两轮 3+1 共 4 项无 skip；encodeToStream、Unicode/escaped/duplicates/empty、真实 write/close/second-move/retry、关闭顺序与实际 Strip 均核对；未作全套终验。 |
| MS-S15 | completed：唯一源码改动为 [MixinResourceTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java)；3 个聚焦测试 exit 0，3/0/0/0，Windows Gradle 9.4.0、Microsoft JDK 17.0.19。真实 opening IOException→null、defineClass cause 保留、required/optional/fallback/engine failure 对照均命中。XML 可能被后续测试覆盖，且不把它当永久证据包。 |

因此 Router 判定 MS-W01（S01/S04/S16）、MS-W02（S05/S03/S06/S08/S10/S11/S12/S15）和 MS-W03（S02/S13/S14）均满足。保留未测全套/29 项、全仓/游戏/其它平台、仓外消费者、默认解码后果、必要二次 DOM、短属性宿主干扰/恢复拒绝、双输出非 FS 原子性、metadata 写后 partial、环境与 Java LSP 限制；本次未运行 Gradle/测试、未改代码或 authority、未写 Git。

