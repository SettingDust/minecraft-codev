# Mixin 剩余简化 Plan

[Work](work.md) · [processed Context](context.md) · **唯一匹配执行图：[Waves](waves.md)**

当前进展见[当前图维护事实](#当前图维护事实)；以下保留原准备历史，不能据此否定后来的审查、确认与已采用执行结果。

## 范围与成功定义

本 Plan 保留原九项未完成的剩余简化要求，并新增五项补齐独立审查指出的 F1/F2 覆盖缺口：child config/parent、refmap 必要 context、Fabric load/current edit 的默认流读取，以及 loader-open null 的实际消费者验收。按现行默认解码/open 合同收敛 S01/S08 及其验收，同时保持通知身份、真实 mapping、当前 metadata 编辑、独立生产者完成/失败边界及输入保护。复用 [Work 的三族 assessment](work.md#权威与来源)、[英文 Spec](../../spec/mixin-preapplication.md)、[中文译本](../../spec/mixin-preapplication.zh-CN.md)、[PRD](../../prd/codev-mixin-rework.md)及[Accepted ADR](../../adr/mixin-operation-isolation.md)。

准备时点历史（保留，后来的状态以文末为准）：

旧独立审查任务 completed，当时判 MS-S08、MS-W02 及 Plan 整体不 ready；后续可行性核定在旧 strict 前提下未找到简单单次读取方案。本版不沿用已被取代的 strict 前提判定不可行：保留履行 required context 所需的局部二次 DOM 读取、实际 remap 委托 native mapper，已形成具体可审查策略，尚待独立局部审查而非已 ready。其余八项只复用原版本/范围未发现重要阻断的结论；S01 的默认解码及关联 gate/验收也属于本次受影响边界。Router 对本九项的 C4 范围披露/当前用户确认尚未发生；全部推进授权不替代该确认。文档存在、作者自检或以后有利的 review 都不授权实施。全部新执行项/gates 未执行。

未来此 Plan 的完成信号为 **MS-W01、MS-W02、MS-W03 三个 gate 全部有充分证据并由 Router 判定满足**。它要求原九项与新增五项完整成功，覆盖已授权读取/loader剩余验收，但不建立全部 Mixin 简化或产品整体的新验收。政策接受不补上旧 partial 的实际验收。

排除范围：擅自改变已接受 JSON 解码或 loader resource-open 政策；已经完成的 readability、清单 `use`、初始化局部清理、产物改名、五处 Kotlin Path I/O、loader override 删除及 fixture read hook 修正；旧图恢复/状态重写；authority/HTML 修改、自动 caller 接线、新取消/资源/发布框架、库升级和无关模块重设计。全 JSON 默认化/流读取 B 已按新增 items 分配到实际 owner；class bytes、Strip 未变配置原 bytes、STORED size/CRC 等必要缓冲保留。旧 Kotlin I/O UTF-8 与 loader cause 负例的剩余验收由 S08/S11–S15 归属，不能凭政策或旧 partial 销账。

## 最小策略与 owners

按现有职责就地收敛：Strip 精确三数组过滤归 stripper，自身 edit 去 strict/默认化但保留必要原 bytes；原 S09 的完整普通资源流复制由 S16 恢复；S11 负责 child config/parent 默认流读取，S12 负责 recorder 必要 context 读取的 stream/use；S13/S14 分别负责 Fabric load 与 current edit；S15 负责 loader-open null 的真实必需/可选消费者对照。其余原九项策略保持不变，具体 predicates、写面、证据和冲突只在 Waves 维护。

接口删除需要完整迁移才形成一个可用终态；私有 editing helper 可以保留在 adapter 内，不能保留 public 同名桥接。`remove` 仍从 snapshot 取得原引用集，实际读取并编辑当前 metadata，保留后来新增/未知内容。不要把“remove 当前 metadata”误解为删除所有后来新增引用。

source-independent Strip 与 Mixin Task 可分别成功、消费和重试，因此取消检测简化按两个真实生产者分别交付。destination 本轮只消除两个算法相同的真实祖先 resolver，实现统一后两侧仍保留自己的输入/输出保护；将一个已有函数开放为内部复用并迁移另一个 caller，不能在只创建无消费者 helper 时形成去重终态，故共享解析器及两侧必要迁移同属一个谓词。精确 strip、流复制、handler API、discovery、context 和输出编码也有独立可保留效果，必要 callers/helpers/fixtures/聚焦回归与各自谓词一起交付。具体唯一 predicates、写面、证据和冲突只在 Waves 维护，Plan 不复制第二执行图。

平台 owner 保持：Fabric JSON 属 Fabric；Manifest 与 NeoForge TOML 分属 Forge 模块独立 adapters；Core/Includes 签名及生产行为无新职责。class transform 和 loader defineClass 继续使用必要 bytes；普通资源或 JSON 输出的简化不能吞掉 read/write/close 原因，不能把原生正常 fallback 变失败，不能撤销已通知身份。

## 依赖、冲突及兼容风险

旧图没有新的 item 间业务 Result 前置；新增 items 与原九项之间只声明真实共写/运行冲突串行，不伪造成功依赖或 Wave 全局屏障。新增边界：S03→S11→S08，S08→S12→S10，S02→S13→S14→S05，S10→S15；最终组合版本须核对前项改动对后项证据的适用性。

- **公开 API 兼容**：删除 `removeConfigs` 有源代码/二进制影响，仓外消费者未知；不声称“没有调用方”。仓内直接调用、SPI anonymous 实现、反射和生成 fixture 必须迁移。旧文档对旧入口的历史记录不改。
- **信任输入**：额外名称/空白/路径/DOM/CRC 拒绝会减少；不许声称坏输入一定成功或全部坏输入必拒绝。真实 DOM/ZIP/I/O 失败照常外传；STORED 的输出 size/CRC 不能删。
- **取消检测**：仅置 flag 而 API 未抛时可能继续完成，不再承诺轮询拦截。真实 API 取消、I/O/引擎/close/move 异常仍阻止受影响输出完成。当前实查 8 处，按合同清理全部，不固定为旧 7 的计数。
- **destination**：真实祖先、硬链接、两个 Task 输出物理不同、受保护目录包含和 active writer 身份必须保留。normalize 不足以保护输入；先保护再删除旧输出。不要为数行去重新增通用文件服务。
- **context**：显式存在性及 SelectedContext 对 member/class 的固定仍需真实结果；native mapper 没有完整 context 查询能力，去 strict 不等于 `return true`。必要二次读取只做 context 存在性/多个 context 且无可用默认时的判断，用默认 decoder 与 `use`，不能将未知 wrapper 字段本身变成拒绝或改写理由。可能再次开流/解析整个 DOM及发生真实 read/close/DOM 失败，保留可获得 cause；不能要求 native 内部已捕获并正常 fallback 的异常一律外传。无显式 context 的 default mapper 正常跳过；显式 required context 不可用仍失败。不承诺零二次解析，不新增读取协议/缓存/拦截器；若真实实现只能违反 required context/native fallback，报告精确 gap。
- **默认解码与打开**：未知字段亦按适用库/引擎默认，不保证所有坏字节成功、拒绝、相同替换或 DEFAULT_MAPPER。JDK open IOException→null 丢 cause 的例外只限 loader 打开；必需输入不可用、取得流后 read/close、直接文件/JAR、写出、恢复和可获得 cause 的责任仍在。日志严重性不是 native 正常返回与抛异常的判据。
- **历史验证适用性**：新调用点可能绕过旧 ASM I/O probe；必须验证故障实际命中及 underlying/suppressed cause。29 项未重跑、loader partial 与坏 UTF-8 差异均不能被“历史绿”遮盖。

回退只涉及未来各 item 的局部代码改动；不迁移输入数据、不发布仓外 API bridge、不修改旧 authority/history。失败后原 inputs 和独立完成结果仍受保护；恢复不重放已完成独立效果。若必须改变本 Plan 的语义/范围/证据边界，返回精确缺口，不能由实施 Handler 擅自改图或权威。

## Spec 成功条件与验证安排

下表逐行对应现行 Spec 的九行验收；“保留”不是当前重测通过，也不是重开全部产品验收。各 item Result 先核对已有证据的实际源版本/输入/环境/新鲜度，仅对变动及缺口做必要聚焦回归；禁止默认全量重跑。

| Spec 成功条件 / PRD | 本范围必须证明的关联与边界 |
| --- | --- |
| Inputs / R3 AC3 | MS-W03：无 public removeConfigs，三格式当前编辑/新增保留/SPI 可用；MS-W02：发现顺序、side、双 metadata、host 同名判定保留，S11/S12/S13/S14 覆盖配置、parent、refmap、Fabric load/edit 的默认流读取与真实失败；MS-W01：三数组精确原字符串与信任输入/STORED，S01 自身去 strict。其余 loader/旧 I/O 限制由 S15 与 Context 记录，不凭 gate 扩大范围。 |
| Names / R8 AC9 | MS-W02：真实 selected context member/class 注入及宿主冲突下固定、显式缺失失败、多 context 无默认失败、可用无歧义默认、无 refmap/default mapper 正常处理；owner/overload/direction 保持，复用实际未受影响的 remapper 证据。 |
| Isolation / R2 AC2 | MS-W02：取消改动仍恢复 selector/TCCL、关闭资源、失败后新鲜 retry；两个输出及冲突 producer 独占；MS-W01：Strip 输出独占/失败关闭。初始化 Closeable.use 和 loader 既有释放只复用其适用证据，不重做也不升级 partial。 |
| Engine outcomes and logs / R4 R6 AC4 | MS-W02：context/discovery/取消改动后真实引擎结果、已通知键与候选区别、正常 fallback 与真实异常区别保留；日志不判资格。不重新实现旧通知/诊断效果。 |
| Applied outputs and exact cleanup / R5 R4 R6 AC5 | MS-W01：重复跨数组/跨 JAR 全匹配、不同路径/原字符串保留、未知 DOM/类/refmap/metadata/资源保留；手写/其它 task 文件独立 Strip、empty/no-match 原配置 bytes 保留。通知来源与多目标的未变语义复用旧适用证据，必要受影响连通回归。 |
| Task/Transform registration and collection / R3 R5 R10 AC3 AC5 AC11 | MS-W01/MS-W02：复用现有 caller 注册/同操作 sources＋derived target 集合；触及输出内容、文件交接或失败传播时选择一个现有真实 consumer 路径核对，raw inputs、属性/provider 和 build dependencies 不变。不新增自动 wiring 或将 resolution-only 纳入 strip。 |
| User-directed use and completed delivery / R10 AC11 | MS-W01/MS-W02：真实受影响组件失败不被 caller 消费为当前成功；applied-only 不冒充 cleaned。保留已有 source strip/derived-target strip 失败路径与输出改名消费效果；不认证下游任意兼容/安全。 |
| Reuse and input changes / R3 R5 R10 AC3 AC5 AC11 | MS-W02 的通知输出须保留同一 tracked JSON 语义、闭 loader 后写文件、cache-restored 无内存使用；MS-W01 保留 removalsFile/input tracking。优先复用已有 TestKit 当前链证据，若输出 API/参数/内容改变影响适用性则在对应 item 内补最小新消费/缓存恢复观察，不新造独立 audit/重复终验项。 |
| Failure safety / R6 R10 AC4 AC5 AC11 | MS-W01/MS-W02：实际读取/DOM、write/close/move/API 取消失败阻止当前半结果/旧成功，原输入/别名/硬链接/目录不覆盖，retry 新鲜。S11/S12/S13/S14 各自证明取得流后的 read/close 和 Fabric edit write/close 因果；S15 证明 JDK open-null 仅限 open、必需不可用失败、可选 fallback 与真实异常分开。MS-W03 保留 metadata 原真实失败。 |

实际测试接点、必要补充与调用迁移要求见 Waves。未来命令从项目根选现有 Gradle 模块 `:minecraft-codev-mixins:test`、`:minecraft-codev-fabric:test`、`:minecraft-codev-forge:test` 的明确选择器，按实际变化最小化；本次未运行它们。Mixins test 配置使用 Java 17，Gradle JVM 另传 fixture.gradleJava；后续 Result 必须列实际环境、完整命令/选择器、pass/fail/skip、真实观察及故障命中，不推定工具链可用。模块编译/引用扫描可证明 API 迁移完整性，不能替代真实 engine/consumer/失败测试。

## 作者语义自检

以下原准备轮自检保留为历史；本轮维护检查见文末，不作为当前全 pending 或未确认结论。

本次 Handoff 的 objective/constraints/deliverables 只建立“原九项匹配派生交付包按已接受默认政策修订并自检”一个终态。四文件、定点源码核对与静态验证都服务该谓词；没有实施、独立 review、authority 写入或执行派发。以下是本版作者检查，不能充当 ready、C4 确认或 gate release。

- **权威与历史**：复用已采用 A–L assessment，核对当前 PRD、双语 Spec、同 identity ADR 的适用条款；没有重新研究 A–L。默认 UTF-8 解码/open null 已 settled，未知字段亦遵循适用默认，未推导所有坏输入成功/必拒绝/相同替换/统一 DEFAULT_MAPPER。JDK open 例外限 loader 打开；必需输入不可用、取得流后 read/close、直接 I/O、写出/恢复和可获得 cause 的责任仍保留。native 内部正常 fallback 与向外异常分开，日志不判成败。Context 保留原 I03/S01/S09 partial、producer/readability partial 后清单 use 修复 Windows 3/3、初始化四项、改名三个消费者、Kotlin I/O 27/29 及 fixture 补验 1/1（未重跑29项）、loader 分轮8项与 JShell、旧 cause/UTF-8 负例未验收，不升级历史状态。
- **九项原意与新增覆盖**：Waves 保留原九个 completion predicates，并新增 S11–S15 分别覆盖 child/parent、refmap 必要 context 流读取、Fabric load/current edit 和 loader open-null 实际消费者验收。A–L 十二行保留，C/H/child copy/五处 I/O 等完成效果扣除。D 的三个 adapters 与 consumers 必须随入口删除共同迁移；K 的现有 helper 和两个 caller 不共同迁移便没有去重终态，故同属一个 predicate；G 的两个生产者可独立完成/消费/重试，继续分开。新增读取 items 的 callers/helpers/fixtures/聚焦回归只证明各自独立 predicate，不建立第二执行图。
- **S08 可行性与成本**：原审查唯一重要阻断与后续单次读取核定均基于旧 strict 前提；新政策消除该前提，不能继续原样判不可行。当前 recorder 已有 config.refMapper、DOM/context 检查和 SelectedContext 接点；OperationService 只委托 loader，采用的 mapper API 不提供完整 context 查询，故只保留存在性/无歧义默认必需的局部二次 DOM 读取，去 strict 和独立原生有效性复验，实际 member/class remap 仍委托 native。明确再次开流/全 DOM 解析的成本及真实 read/close/DOM 失败，不能以正常 fallback 的已捕获异常要求一律外传。不加缓存、拦截、扫描或单次读取协议，不扩 service/child 写面，不以 return true 删除职责。若无法取得 required context 仍须给精确 gap；这只是具体可审查策略，没有运行证明。
- **最低合同与证据**：S08 指定显式存在性/固定、宿主冲突下真实 member/class 注入、多个 context 无默认失败、可用默认及无 refmap/default mapper、namespace/direction/owner/overload/descriptor 和原 config+entry 通知身份。S01 保留三数组精确 all-match、原字符串/路径区别、原 bytes、STORED 和真实 DOM/ZIP/I/O；其自身 edit 去 strict。S11/S12/S13/S14/S15 分别覆盖 child/parent、refmap context、Fabric load/edit 和 loader open-null 的直接流/消费者边界；坏 UTF-8 按实际 default decoder 观察，未知字段不额外扫描/复验；不整类删负例。其余项保留当前 metadata/未知新增内容、side/双格式/顺序/歧义、8处无轮询与实际 API 取消、alias/hardlink/目录/冲突 writer、通知等价/关闭/消费和 fresh retry。以上均是未来证据，未把历史绿或静态读取当成已通过。
- **成功条件与 gate 覆盖**：上表九行逐一保留 Inputs、Names、Isolation、Engine outcomes/logs、Applied/exact cleanup、注册/集合、消费/完成、复用/输入变化、Failure safety，并关联 PRD AC2/3/4/5/9/11。MS-W01 收集 Strip 默认化、精确过滤/复制/取消的最终组合证据；MS-W02 收集 discovery/producer/destination/context/通知结果，明确实际 selected mapping 与 native fallback/抛异常、JDK open/read-close 边界；MS-W03 收集 API 完整迁移/三格式当前编辑与兼容风险。无 gate 能凭政策接受补齐旧 partial，不能绕过 S08、以编译替代实际 engine 或凭先前版本绿作当前证据。
- **独立审查与 scope 披露**：已采用 review/g1 仅证明原九项图内规划无阻断，并明确 F1/F2 缺 coverage；本版新增五项承接这些独立终态及真实冲突，作者不扮演独立 reviewer。新增 items 不改变 accepted policy，也不把旧 partial/政策接受当通过；新增边界须经受影响范围的独立审查与 C4/C6 流程。

图的语义检查：原显式 prerequisiteItemIds 与 prerequisiteWaveGates 全空，三个 gate 各等自己有限 members 的完整 Results 与规定行为证据；没有自等、旧 partial 前置、编号顺序或 Wave 全局屏障。每项恰属一个非空 Wave，每项保留一个 completion predicate。共享 stripper/producer/platform fixtures 与测试输出继续按原八条直接冲突边串行；共写互斥不变成成功依赖，前一项失败不抹去另一独立结果。S08 局部策略没有新增 service/child owner。最终 eligibility、scope 与资源许可不由作者判定。

历史检查记录保留为历史而非本版结果：原准备轮62处本地链接/32个不同目标/3个fragment通过，后续纠错轮66处本地链接/33个不同目标与fragments通过；当时均为9 items＋3 gates、全pending、联合冲突等待图12节点17边无环。这些静态通过未解除当时S08阻断；本版默认政策改变后需用本次检查及新的局部独立审查分别判断，不能借旧检查宣布ready。

本次实际静态检查（只读文档断言）：四文件齐全，原有本地链接/fragment检查仍适用；新增 items 的本地引用和 reciprocal membership 已纳入作者逐项核对。当前图为 14 个活跃 items＋1 个历史 blocked S09＋3 个已满足 gates，共 18 个唯一定义；活跃 item 每项恰属一个非空 Wave且各有一个 completion predicate，item/Wave 显式前置全空。A–L 原待办与 Plan 九行成功条件保留；本轮不重算执行图，不改变 predicate、依赖或冲突。

以上只验证四文档结构、引用与覆盖意图，不代替已采用的实际验证或 Router gate 判定。未运行构建/测试，未修改源码/fixtures/依赖/authority/HTML，未安装、未写 Git、未发起独立 review 或派发。

## 当前图维护事实

Router 已完整采用 codev-full-coverage-plan-review/g1 completed、无阻断；随后当前用户确认全部十四项实施范围，并授权必要图维护。PRD、双语 Spec、同 identity ADR 均 reuse；不重选策略、不扩行为。原未审/未确认/全 pending 文字仅保留准备时点历史。

Router 现已完整采用十四个活跃 item：MS-S01、MS-S02、MS-S03、MS-S04、MS-S05、MS-S06、MS-S08、MS-S10、MS-S11、MS-S12、MS-S13、MS-S14、MS-S15、MS-S16 均 completed；三个 gate MS-W01、MS-W02、MS-W03 均由 Router 判定满足。MS-S09 保留原 blocked 历史并退出活跃 membership，由 MS-S16 恢复其未执行范围；不能把 S09 改为 completed。详见 [Context](context.md#本次可靠采用的执行与恢复事实) 和 [Waves](waves.md#ms-s16--恢复-s09-未执行的-strip-流复制)。

本轮只投影已采用事实，不重验、不释放新的 gate、不改变执行合同。验证方法、实际观察、证据适用性核对及限制保留在 Context/Waves 的完成记录中。

### 本轮图维护作者自检

本次唯一终态是原已确认范围内的四文档图维护包：路径/上下文修正、未执行范围恢复、已采用事实投影及作者自检；没有另行实施或判断 gate。新 S16 只有一个可独立保留/失败/恢复的终态，完整承接原 S09 的普通资源流复制；必要 probe/回归只证明此谓词，S01/S04 已完成独立效果不重新交付。

实际检查结果：

- 逐行比较维护前后的十四项 contract：completion predicate、scope/effects、必需 evidence、聚焦接点、单结果理由以及专有流故障/默认行为条款均保留；S16 对原 S09 的五行完整合同逐字相同。W01 在明确替换 member 后，原 exact/原 bytes/STORED/资源/真实 I/O/API 取消/输入及 writer/最终组合版本/实际 consumer/默认 decoder gate 要求逐字保留。
- 四文件本地引用检查通过：78 处引用、37 个实际可读目标、10 个 heading fragments，匹配 Work/Plan/Waves 互链可解析；新增 XML 均先核实存在并解析摘要，未建立项目外 Result/session 依赖。A–L 十二行与 Plan 九行成功条件保留；authority assessment 由已采用 Handoff 复用，本轮未另核读或改写 authority。
Router 现已完整采用十四个活跃 item：MS-S01、MS-S02、MS-S03、MS-S04、MS-S05、MS-S06、MS-S08、MS-S10、MS-S11、MS-S12、MS-S13、MS-S14、MS-S15、MS-S16 均 completed；三个 gate MS-W01、MS-W02、MS-W03 均由 Router 判定满足。MS-S09 保留原 blocked 历史并退出活跃 membership，由 MS-S16 恢复其未执行范围；不能把 S09 改为 completed。
- 联合等待图包含 gate→活跃 member 的 14 条边，加现行直接冲突及完整保守串行路径的 18 条不同等待边，共 32 条，完整 18 节点检查无环；历史 S09 孤立、不成为等待条件，无自 gate 等待。现行 S04 → S16 → S06，以及保守路径 S04 → S16 → S02，均按冲突串行解释，S04 已结束，不能反向建立 S16 → S04 等待。共同 build/fixtures/JVM 资源继续串行，不新增成功 Result 前置或 Wave 全局屏障。
- W01/W02/W03 的 gate 结论已由 Router 基于完整关联 Results 与最终组合证据采用；本轮仅同步记录，不重新释放或重验 gate。联合等待图与 item predicates、依赖、冲突均保持原文。

需独立复核的最小边界：旧 S09 blocked 与新 S16 全合同一一对应、W01 member 替换及原 gate/Plan 成功条件承接、S01/S04 已完成事实及最终组合证据适用性、S16 与 S06 共写及完整串行路径连向 S02 的必要连接；纳入其联合等待/冲突图即可，不重审其余未变十四项策略。该复核尚未进行，作者自检不替代独立结论。原用户确认仍有效，路径/上下文修正不产生新的业务范围；若实施发现实质变化，仍由 Router 按适用边界判断。

本轮未运行构建或测试、未修改代码/测试/配置/依赖/authority、未安装或操作 Git，未实施 S16、未自行完成 item 或释放 gate。历史测试数与 XML 摘要不等于新验证；S04 中途 removals 读取消/OS 异步取消/新 JDK 未覆盖及 JDK17 SecurityManager 限制继续保留。


