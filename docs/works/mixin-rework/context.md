# G1 Mixin Rework Context

## 归档可访问性（清理后）

按用户要求，旧历史证据目录 `docs/works/mixin-rework/evidence/` 已整包删除，包括 `core/`、`pinned-engine/`、`g1-implementation/` 和 `g1-results.md`。其中原命令/exit/日志/XML、分窗报告、具名 ABI 输入与普通结果摘要原件均不再保留；没有另建备份、替代原件或重放包。保留本目录 Work/Context/Plan/Waves 的历史结果与执行图，以及同一 ADR 的架构决定。已采纳验收登记仍见 [Context](context.md#g1-acceptance)；该加工登记不是已删除的原实验报告或证据包，也不保证重放。

以下历史正文、JSON 图内路径/绑定及“完整保存/可读/可重验”等措辞只记录原时点，不再承诺已清理原件可访问，也不作为当前证据入口或新执行输入。已失效的 Markdown 证据链接已撤下；历史 task/generation/item/Wave、scope、状态、gate 与实际方法/失败/partial/unknown 均保留，不重置或释放。保留文档不是原件替代品，本次没有项目或 ABI/checker 重跑、没有新 G1 认证；旧已批准 G1 的 accepted/closed 仅适用旧兼容/选择性清理范围，不覆盖当前 [PRD](../../prd/codev-mixin-rework.md)（[中文](../../prd/codev-mixin-rework.zh-CN.md)）的生效（Active）目标：Codev 提供预应用 Task 与逐 JAR Strip Transform；使用者注册、接线并选择消费配置，Codev 按引擎应用通知取得清理资格，不额外核验全目标完成、无报错或最终字节码效果。键为完整 config 资源路径＋原始条目字符串，全部重复、跨数组、跨 JAR 匹配项一并删除，即使其它应用部分完成或 unknown；未通知的其它键保留。仅清单或让使用者补做 strip 不算完整清理流程；原输入不变，不扩至删除类、refmap、整个 config 或 Loader metadata。使用者决定消费者与编译/反编译/打包/运行用途，Codev 不管制用途、不代选路由、不保证任意下游兼容或安全。日志/异常承担诊断，不要求公共诊断返回、旧 Strip 兼容或独立 records 协议。当前 [Spec](../../spec/mixin-preapplication.md) 与[同一 ADR](../../adr/mixin-operation-isolation.md) 的适用说明不代表新实现或验收。Mixin 日志由用户阅读，Codev 不解析日志判定应用成功；引擎抛异常自然失败，Codev 自身 IO、原输入、资源、精确 JSON 与缓存保护仍保留。operation classloader/engine isolation 决定沿用；Task/Transform 结构及身份匹配已定，通知收集 hook/API、信息表示、发布及保存恢复/cache 机制仍未定且未实现；下方 Plan/Waves、selected/授权及 R/AC/验证编号只属旧交付时点，不是新目标执行图或验收映射。本说明仅维护当前适用事实与归档限制，不改变历史策略、图或 gate。

## 当前加工Context：mixin-consumer-docs-r01

<a id="doc-context"></a>

入口 [Work](work.md)；唯一匹配 [Plan](plan.md) / [Waves](waves.md#selectedwavesgraph)。当前用户已选择“写完三处（建议）”，消费者写入 executionAuthorized=true，仅三处写域及静态核对；不改源码或规范、不运行项目、不做Git、不覆盖已有内容。准备记录的缺席状态仅属检查时点，写前仍核对。

### G1总体验收：产品owner/user已接受结案

<a id="g1-acceptance"></a>

当前用户明确选择“接受结案（建议）”：接受本轮已批准兼容范围的G1验收，完成收口登记；Git另行授权。其后“继续”接续本登记，不扩大为项目运行或Git许可。Root据此与[总体充分性核定](#g1-final-review)明确登记本轮G1 **accepted / closed**：原批准的分层行为验证、改后AF修复运行与独立复核、三处I06共同支持适用产品/技术验收，无现存必补工程、测试或消费者文档。不以Doc-W01单独completed、UI状态或59/65数量代替总体判断；产品owner接受与Handler结案建议分别保留。

本登记复用已完整采纳且已关联的来源和当前用户决定，未重复采纳旧Result或重新运行检查。PRD/同一ADR/Spec reuse；下方核定的pending-owner为接受前时点。旧R13 failed/24行partial、R14 limited/strict=false/external unknown、AF失败/未确认回执、1114副本偏差及可信本地producer/filesystem等限制仍保持；不主张单窗全绿、改后全部平台重新认证、严格全Host合规或恶意并发替换沙箱。原65与AF59不相加；已退出范围的严格归属账本不重开。

登记只更新Work/Context/Plan/Waves的Root收口元数据，不改规范、源码、消费者文件或原报告，不运行项目、测试、安装或Git。当前已批准实施与文档交付全部收口；Git集成/提交/推送/PR/合并/发布未执行且未授权，G1接受不释放这些动作。

### G1总体余项核定：接受前时点（原结论保留）

<a id="g1-final-review"></a>

Root完整读取并关联 `codev-mixin-g1-remaining-review` generation1 的 completed 完整8414-byte Result，应用户“还差什么”仅作只读结案充分性核对。报告结论是：当前已批准兼容G1范围的结案建议 supported；未识别必须工程修补或确定的现行条款＋缺失行为observation；当前缺的是产品owner/user明确采纳总体验收及登记，非再欠一轮实现、测试、审计或文档。Git集成另需授权，严格全Host认证、外部消费者接线/采用、发布与扩版本矩阵不是本轮欠项。Root采纳此余项核定，但尚未替代产品owner/user接受G1。

核对来源：[现行PRD](../../prd/codev-mixin-rework.md)的Scope/R1–R10/Observable success and acceptance及产品验收归属；[Spec](../../spec/mixin-preapplication.md)的C1–C8/A1–A12；[同一ADR](../../adr/mixin-operation-isolation.md)的Decision/Consequences/Revisit criteria。三family reuse，无为结案必须改写的契约或新架构矛盾。证据沿分窗原报告（历史原件已删除；原路径 `evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md`）、[改后R02](../../../minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md)、本Context的F3正确关联/AF-A02完整采纳与[Doc交付](#doc-i06-closure)，并读取普通摘要（历史原件已删除；原路径 `evidence/g1-results.md`）及指南 `docs/guides/mixin-preapplication.md`（现已删除；此处保留原读取事实）。不沿原报告错误A/AC编号，不重新取回或重置已完整采纳的仓库外Result。

适用A/AC行为支持已具备：兼容注入/empty/legacy；隔离/task域/真实输入失效；完成与失败保护/绑定及AF身份、自洽负例；精确清理/完整native义务/平台双metadata与closed重开；mapping/refmap实际调用与负例；新producer→pair FROM_CACHE→fresh consumer；原Forge实际Java8、Core闭包/负例、ABI封存caller；pinned引擎和拒绝超支持边界。数量59/65本身不是理由，原65与AF59不相加成新总量，跨窗复用不冒称改后全平台重跑/单窗全绿。

本次仅读取现有文本/权威和加工事实，无项目或协调写入、运行、Git、状态采纳、补救设计或artifact创建（本段为Root后续加工登记）。原三权威中准备时点unexecuted/未集成标签及旧build/version待定已有后续scope记录，不构成必补工程。旧R13 failed/24行partial、R14 limited/strict=false/external unknown、Ruff限制、AF失败/未确认回执、1114副本偏差及可信本地producer/filesystem/build证据非永久保留全部不改绿。可主张本轮G1结案建议，不可主张单窗全绿、改后完整平台认证或严格全Host合规；当前overall G1正式接受仍pending-product-owner。此为加工结论，不是原Result全文或新执行权限。

### DOC-I06完整采纳与DOC-W01判断

<a id="doc-i06-closure"></a>

Root完整读取并关联 `codev-mixin-i06-docs-delivery` generation1 的 completed 完整4247-byte Result，符合当前用户“写完三处（建议）”及唯一DOC-I06边界。新增消费者指南 `docs/guides/mixin-preapplication.md`（现已删除）118行、普通结果摘要（历史原件已删除；原路径 `evidence/g1-results.md`）74行；[README](../../../README.md)仅末尾一个指南链接，原246-byte前缀逐字节不变，沿CRLF追加70 bytes至316 bytes。两目标exact-path两次缺席核对及CreateNew排他创建、README原bytes核对后末尾追加，未覆盖他人内容。

实际验证仅静态：27个本地Markdown链接通过（含5次锚点引用），三段示例逐属性对应当前Mixin/StripAppliedMixins及既有provider/cache/task-only/mapping fixtures，真实结果声明对应已采纳Context和可读R02/continuation-03来源；文档写后完整读回。七文件当前SHA-256仍7/7匹配R02 after-hashes，属于本次静态绑定核对，不是新运行或独立审计。未请求原公共外链或编译示例。

Root据三处完整交付、README拥有区保留及上述实际静态检查满足DOC-I06和DOC-W01，本Doc Plan收口；当前批准的分层交付、F1/F2修复复核及消费者说明均完成，没有新增代码/测试任务。此判断不自动满足历史图、完整规范G1/全24项证明或Git授权，不把跨窗/有限复用改成单窗全绿。

全部项目写入仅三消费者文件；未改源码、配置、测试、权威、旧证据或四协调状态，未建helper/脚本/账本/冻结包。辅助存储与文本组装各有一次准备工具错误，同范围内纠正，无项目执行/额外写域；保留该事实。未运行Gradle/Java/tests/caller/ABI/formatter/LSP/checker/进程查询/安装/Git。原failed/partial/blocked/unknown、AF-A01未确认回执、1114副本偏差、R14 limited/strict=false/external unknown、Ruff/fullStrictScope=false及可信本地producer/filesystem/并发替换限制继续保留；build来源不承诺永久保留。此为加工事实，不是仓库原始Result副本或永久取回承诺。

### 权威assessment与前置复用

| Family / owning boundary | 处置 / 可读来源 | 本范围理由 |
| --- | --- | --- |
| PRD / Codev产品owner | reuse；[Active PRD](../../prd/codev-mixin-rework.md)；update/create skip | R1–R10用户目标不变，仅普通用法/结果说明。 |
| ADR / 执行隔离与loader adapter owners | reuse；[同一Accepted ADR](../../adr/mixin-operation-isolation.md)；update/create skip | 不改operation-local、发布或selective决定。 |
| Spec / mixins与Fabric/Forge技术owners | reuse；[Active Spec](../../spec/mixin-preapplication.md)；update/create skip | C1–C8兼容/失败契约只引用，不新增API、版本支持或全A/AC验收。 |

复用Router给定并与当前三owner文档一致的assessment，无authority写权或新coverage gap。Root已完整采纳原I05及AF-A02 generation1完整15797-byte Result：F1/F2闭合、无新blocking findings，2026-10-12T15:49:58Z七文件7/7匹配R02 after-hashes。AF-W01/02/03 satisfied，原B-W05 F1/F2挂起已明确解除；这是[既有加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)，不是本Handler重审/重判gate或完整原报告副本。

AF-R02真实一次native exit0、10 suites/fresh59=Mixins50+Fabric6+Forge metadata3、零failure/error/skip，累计Native3/许可3不重置。可读仓库来源：[R02验证](../../../minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md)、[原七文件绑定](../../../minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/after-hashes.txt)；原分窗结论（历史原件已删除；原路径 `evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md`）。原65/Forge8/Core/ABI仅按原scope复用，不宣称本窗重跑或改后完整平台覆盖。

F3沿[正确有限编号加工摘要](context.md#已有证据有限复用与f3勘误)，不复制旧错配A/AC表或新造全24行通过证明。原failed/partial/blocked/unknown、AF-A01未确认回执、1114普通副本偏差、R14 limited/strict=false/external unknown、Ruff/fullStrictScope=false保留；可信本地filesystem身份保护不是恶意并发替换沙箱，digest不认证恶意生产者，不认证全Host/cache/卷/ACL或任意plugin副作用。

### 三目标准备时点存在/拥有状态（创建前记录，现已交付）

指南 `docs/guides/mixin-preapplication.md` 现已按用户要求删除；历史交付、静态验证及 gate 判断不变，旧指南创建/复验措辞不作为当前要求。当前技术入口为 [Spec](../../spec/mixin-preapplication.md)，不是旧指南原始证据。

下表保留准备时点exact-path检查；当前用户现已确认表列三处写域，此表是实施前记录，现已交付，结论见上方doc-i06-closure。输出缺席时不作可读refs，create-only/README追加边界保持。

| Codev相对路径 | 当前状态 | 当前 / 未来确认后的owning boundary |
| --- | --- | --- |
| docs/guides/mixin-preapplication.md | 文件与同名目录均不存在 | 当前不创建；未来create-only此指南；写前出现内容则停止报告，不覆写。 |
| docs/works/mixin-rework/evidence/g1-results.md | 文件与同名目录均不存在 | 当前不创建；未来create-only普通结果摘要，不复制原始Result/封包；出现内容同样停止。 |
| README.md | 已存在，无G1 usage区；正文为标题、简介、Full readme WIP及cloche链接 | 当前不改；未来仅末尾追加一个指南Markdown链接，原文/空行逐字保留，不新增其它README正文。 |

### 当前API/fixture输入（静态来源，非新执行）

路径相对Codev：
- `minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt`
- `minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt`
- `minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java`
- `minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java`

MixinInputBindingTests的testKitMatchingChainTracksInputsAndRejectsConsumerExpectations、buildCacheRestoresSuccessfulPairBeforeFirstFreshConsumer提供不同target/source与records/output/input provider接线；testKitTaskOnlyPluginBodyAndResourceChangesReexecute提供task-only plugin。MixinMappingTests的noMappingLegacyRefmapAndContextOnly、testKitMappingInputsReexecuteAndConsumerMismatchRejects提供无mapping与可选mapping来源。未来示例逐属性静态对应当前API/fixture；本准备没有写或执行示例。

Root短披露后当前用户已明确选择“写完三处（建议）”，D-DOC-CONFIRM已满足；原B-W05不再是阻断，旧I06图不作为当前执行图。当前无内容/authority/拥有区未决需求；发现他人新内容、绑定可见矛盾或范围外写入需求则报告具体gap，禁止扩域。加工事实不承诺仓库完整原始Result或永久取回。

## 以下为已完成AF范围及原时点Context（非 selected，原文保留）

> 旧当前/待实跑/阻断/额度只属原时点；现行关闭判断以上文及已采纳AF-A02加工段为准，不改旧记录。

## 当前加工事实：mixin-audit-f1-f2-r01

> **当前修复与独立复核已完成**：AF-R02一次native exit0、fresh59=Mixins50+Fabric6+Forge metadata3且零failure/error/skip；累计Native3/许可3，不再运行项目。Root完整读取并关联codev-mixin-af-a02-incremental-review generation1的完整15797-byte Result：F1、F2闭合，无新blocking findings；2026-10-12T15:49:58Z七文件SHA-256与R02 after-hashes全部一致。Root满足AF-W03，AF-W01/02/03共同完成当前有限修复Plan；并明确以原I05报告＋这次增量关闭原B-W05的F1/F2挂起，非仅凭报告completed自动接受。F3沿已接受正确有限编号，旧表/报告不覆盖；原failed/unknown、1114副本偏差及可信本地/Windows限制保留。消费者说明尚未交付，完整G1/I06/Git不自动放行。详情见[加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)。

> **历史AF-V03失败时点（本次单行修复确认之前）**：参数回显通过；此次唯一外层native exit1，累计2/2、尚余0。Mixins fresh 8 suites/50 cases：41通过、9 failures、0 errors/skips；均报OperationPublication.publish输入Projects缺失。Mixin完整check、Fabric6、Forge metadata3及P01/P02完整链未到达。F2字段变异/合法untouched=false与library输入保护已有fresh通过，但不释放整体验收。七源码候选在执行窗未改。新增1114普通副本未逐件证明必要性，属于已保存执行偏差；不宣称合规或全Host保全。AF-W02/03未满足，AF-A01/消费者说明/G1/Git仍阻断；只读定位已完成：Mixin.kt:98裸+Path把完整输入拆为相对片段；最小纠正为+listOf(Path)，未实施、未补验。gates与停止边界保持。

> **历史AF-V03补验许可（原确认时点）**：用户选择“补验一次”。先在自有临时目录进行有界参数回显（不启动Gradle/Java、不造helper框架），通过后原命令最多追加1次。总额度2，实际已用1，尚余1；原任务/七文件候选只读/环境与缓存边界不变。AF-V03是独立新Result；AF-V01 blocked、AF-V02 failed及旧流保留，新失败保存停止、不自动重试。AF-W02/03未满足，AF-A01/消费者说明/完整G1/Git不放行。

> **历史AF-V02失败时点（本次增量确认前）**：实际原生1次/exit1，额度已用1/许可1。Windows引号传递偏差导致daemon启动失败，全部所选tests未到达、fresh XML/cases为0（不是零失败通过）。F1/F2仍未实跑关闭，AF-W02未满足、AF-A01未启动；已保存并停止，没有追加运行授权。以下AF-V01 Native0是旧启动前时点。

[Work](work.md)为入口；[Plan](plan.md)/[Waves](waves.md)同目录直接匹配，唯一selected scope **mixin-audit-f1-f2-r01**。本节是portable processed facts owner，不是完整原文归档，不承诺永久取回原文；不直接或经Context间接依赖仓库外Result locator。下方历史外链仅保留原时点，不作本scope继续依赖，不开展全历史清理。

### 采纳状态、当前授权与证据等级

| task / generation / 关联 | 已采纳完成事实 | 限制与gate |
| --- | --- | --- |
| codev-mixin-i05-independent-audit / generation1 / B-AUDIT-01、B-W05 | Root已完整读取、解码并关联completed完整独立报告，接受报告交付；F1 high、F2 medium、F3 medium。 | F1父目录别名令publication在writer读取前删真实输入；F2success缺完成flag/native校验仍能删entry，均为静态可达路径，原审计及本准备未实跑复现。B-W05 not-satisfied-blocking-F1-F2，不是新修复前置。 |
| codev-mixin-audit-fix-scope / generation1 | Root已完整读取、解码并关联completed最小范围报告：四生产+三测试、输入/完成字段规则、必要cases、一次命令/效果/停点。 | 范围核定不是修复/Native证明；报告当时未授权实现是历史，以下当前确认已补足同一精确scope，不重研/重审。 |
| 原七文件确认（保留） | 选择“修复并验证（建议）”，并反馈“看不到问题，问题太长了”；准确七文件、四文档同步、唯一受影响Native/效果/恢复/停止条件与成功后独立只读增量复核已明确确认。 | F1→F2→共享验证→独立复核；共享MixinInputBindingTests要求串行。Native已用1/许可1（AF-V02 failed，当前停止），作者Native0。原准备Task仅四文档，已完成；AF-I01/AF-I02两个源码候选均已采纳，AF-W01只释放一次共享验证。 |
| 当前补验 ask_response | 用户选择“补验一次”：先自有参数回显（不启动Gradle/Java），通过后原命令最多追加1次。 | Native总许可2/已用1/余1；源/任务/环境/cache边界不变，新失败保存停。AF-V03独立新Result，旧blocked/failed不改绿。 |

没有仓库完整原始audit/scope Result引用；此缺席不回退已采纳completed、不重开旧任务，加工摘要也不保证恢复完整原文。新item Result仍须Root完整读取/可靠关联再据实际predicate判gate，本摘要不代替新Result初次采纳。

### AF-I01源码候选采纳

Root已完整读取并关联codev-mixin-af-i01-input-identity/generation1的full completed Result，对应本scope AF-I01。五个owned现有文件候选满足源码就绪谓词：共享真实路径/文件身份/目录包含guard在父目录创建、lock、旧结果删除和writer前；两个task完整接线，原API/失败/取消/失效语义保留。两个publication测试及三个task测试新增源码覆盖alias/目录拒绝和合法发布，原断言保留。Windows junction解除未确认时保留自有root并拒绝证据遍历/递归清理。

实际验证仅调用/接线/断言的定点只读核对，Native0，未编译/JUnit/Windows实验/LSP analyzer；编辑附带不完整诊断不是通过证据。F1未实跑关闭，Windows卷/ACL和编译可行性仍待AF-V02。可靠状态为AF-I01 completed/source-ready，AF-I02前置满足；AF-W01仍pending（F2未完成），不释放验证/审阅/历史B-W05。处理事实和真实源码路径是持久记录，不提供仓库完整原文或外部Result locator。

源码owner为下表AF-I01五文件，新增断言归现有OperationPublicationTests.java与MixinInputBindingTests.java；全局准确七文件和一次验证边界不变。

### AF-I02源码候选采纳与AF-W01判断

Root已完整读取并关联codev-mixin-af-i02-success-records/generation1的full completed Result（5593 UTF-8 bytes），对应本scope AF-I02。三个owned现有文件candidate满足源码就绪：consumer在整份config entry循环、source-matching与rewrite之前，独立success/untouched分支检查真实Boolean完成标志及native/provisional无重复字符串集合，两个clean入口共用；原binding/API/ordinary optional及合法untouched=false保留。当前pair生成后的31类字段变异、两个重载/匹配与不匹配source形成62次拒绝断言源码，另有完整side-excluded保留正例；这些不是已执行数量。原F1三task方法/共享fixture的alias先解除及失败禁止遍历/递归清理原样保全，无范围外写入。

实际只做字段生产链/两入口/验证顺序/断言/F1保全的定点只读核对；Native0，未编译/JUnit/Windows实验/LSP analyzer，自动编辑提示不作通过证据。F1/F2仍未实跑关闭。两个完整completed候选Result、七文件并集/串行拥有与原授权一致，Root因此满足AF-W01源码ready谓词，仅释放显式AF-V02前置；AF-W02/03仍pending，唯一Native已用0/许可1，AF-A01未启动。旧B-W05阻断/原失败、消费者说明、完整G1及Git不放行。

持久事实引用现有SelectiveConsumer.java、MixinInputBindingTests.java、MixinSafeRetentionTests.java及AF-I01五源码owner，不依赖外部Result locator或承诺完整原文恢复。

### 当前补验许可与AF-V03

当前用户ask_response选择“补验一次”：允许先在自有临时目录以参数回显小样核对我方启动方式（不运行Gradle/Java），核对通过后仅追加原命令1次。原任务、七源码候选只读、环境/cache/恢复边界不变，任何新失败保存停止、不自动重试。总nativeVerificationLimit=2，已用1/剩余1。仅此次受控小样和普通临时启动文件可写自有f1-f2-verification新子目录，不是新helper框架、任意Host进程管理、工具安装或父环境修改。

C6当前确认由Root拥有并已取得；C5只细化未完成验证为AF-V03，selected AF-W02 listed item及AF-A01前置改指新item。AF-V01 blocked与AF-V02 failed完整处理事实/旧原生流及其原predicate保留到history，不resume、不回写绿色、不因新增许可自动满足原失败item/gate。两source-ready候选及AF-W01不变；AF-V03需参数回显接收端逐参数与原数组一致、无多余quote、JVM属性单项完整，再运行原命令及原验证谓词。回显必须经过与修正后launcher相同的Windows shell/batch传递边界，不能仅PowerShell数组或整条echo字符串算成功。

### AF-A01启动字段纠正与AF-A02接续

- 原codev-mixin-af-a01-independent-incremental-review标识实际49字符，违反Router允许3–48字符要求。原Resolver launch/多次明确status查询返回result_projection_failed，没有可采纳身份/状态/Result；2026-10-12再次核对parent会话任务目录仍无此记录（有限negative evidence，不证明零启动/零作用），不将回执错误伪造为Handler failed或审阅完成。
- 新AF-A02只恢复原已授权尚未交付的独立七文件/AF-R02 fresh59增量review，完成与AF-W03要求不变。纠正startup为codev-mixin-af-a02-incremental-review（37字符），reasoning3/impact0保持实际所需不为过guard降低。原任务只读、无持久/项目执行effects授权，已先inspection，重执行界限仅read-only报告，当前无已知冲突writer；不resume未知/活动身份，不改源码、不启动Gradle/Java。
- AF-W01/02已采用事实与Native3/3不变；原AF-A01未确认状态归历史，AF-W03只以新AF-A02完整独立报告和无未处置重大缺陷判定，不凭成功launch/UI放行消费者说明/G1/Git。

### AF-R02完成采纳与AF-W02判断

- Root完整读取关联codev-mixin-af-r02-corrected-search-regression generation1 completed，并读完[verification](../../../minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md)及同目录native-v03.txt（这是新R02收据，不是旧V03）。唯一Mixin.kt单行包装，其它六源/test和四协调文档在执行窗SHA不变；原启动代码/argv/env复用，只有新日志目标数据参数化。
- 本窗2026-10-12T12:32:51.8837977Z–12:36:37.8611903Z，原外层1次/native exit0，累计3/许可3；fresh10 suites/59 cases（50+6+3），0 failure/error/skip，三个task及Mixins完整check/lint/validatePlugins实到；空Kotlin source-set NO-SOURCE派生SKIPPED不是JUnit跳过。
- 42条INPUT_GUARD与目录包含/合法路径/真实junction-hardlink-finally、62条COMPLETION_REJECT与合法untouched=false、新warm SUCCESS→pair FROM_CACHE→first fresh consumer SUCCESS及42/1/Unused、新13项implementation bindings、Fabric/Forge closed/reopen/dual metadata均有当前证据；不使用旧41绿或旧records补足。只具名8个旧XML保存、父十项env不变/child与流handles正常finally。
- Root据此满足AF-W02，仅释放AF-A01独立只读增量复核。AF-W03/B-W05/消费者说明/G1/Git未满足或未放行；历史failed、1114副本偏差及全Host/cache不可认证限制原样保留，不再新增Native。

### AF-R01准备失败与原授权接续

- AF-R01完整generation1 failed已读取关联：[普通失败日志](../../../minecraft-codev-mixins/build/f1-f2-verification/af-r01-20261012T122017Z-preparation-failure/preparation-failure.txt)。rg未展开Windows glob引起os error123；源码/Gradle/Java/echo均0，无fresh XML或备份，原失败保留。
- 已知零执行效果，Root在原单行及一次未用许可内纠正接续AF-R02一个修复并验证Result，不resume/改绿、不重复审批。累计Native2/许可3，所有原功能谓词/写域不变；ffgrep用明确现有目录/实际路径，不再rg字面glob。普通只读查询表示错误原范围纠正，实际项目失败和effects/权限缺口仍保存停止。

### 一行producer Path追加修复授权

- 当前用户选择“修一行并补验一次”：仅Mixin.kt上述Path包装修改与原三任务命令一次，Native累计许可3/已用2。原输入身份guard/fail-closed/所有角色顺序、已有tests、P01/P02及平台fresh验证保持；复用已核对启动器，不再参数实验/新增helper。
- AF-R01一个修复并验证Handler/Result，与因果修正耦合的源码差异、8个具名旧失败XML保存及原范围回归是其内部检查；不拆低上下文源码候选/再次审查阶段，不改变AF-A01独立只读复核依赖。
- 允许的唯一生产写为Mixin.kt，其它六源/test、authority/build/schema/依赖/旧Result不改；原任务图输出与子env/cache限制保持。新日志自有，旧失败日志保留，旧8个fresh XML按名称普通保存；不泛化复制任何fixture/classes/锁/JAR。任何新失败/缺口保存并停止，不扩修/重跑；不跑Core测试/Forge patched/ABI，不放行G1/Git。
- AF-V03原failed独立事实归入selected graph历史，不resume/改绿；新AF-R01有原完整fresh功能验收谓词，其Result不能自动满足旧failed item。Authority PRD/ADR/Spec的现有恢复范围assessment复用，无产品、架构或规范变动。

### AF-V03只读路径诊断完成（非修复/验收）

- generation1完整completed诊断Result已完整读取并关联；诊断Native0/修改0/项目产物0。原AF-V03 failed、2/2以及复制偏差不改绿。
- 九项原始失败栈均先到Mixin producer。最早偏离为`minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt:98`：集合拼接裸`+ input.toPath()`，Path实现Iterable，追加路径名字分段；相对`Projects`在共享publication第20行toRealPath失败，尚未到writer。StripAppliedMixins使用完整Path的listOf，没有同样裸拼接；legacy失败也先在ordinary producer。
- 源码及已保存XML支持最小因果纠正：只将这一个片段改为`+ listOf(input.toPath())`，其余输入顺序/角色、真实身份guard、fail-closed与发布失效规则保持。无需新增tests/helper/schema/依赖。现有三个task合法/alias/目录cases和六个TestKit失败cases覆盖该接线；原完整验收谓词不缩减。
- 静态机制推导，没有新编译探针、字节码或运行时inputs快照；不声称修后通过或后续无其它错误。Source对应Mixin.kt:93–101、StripAppliedMixins.kt:94–123、OperationPublication.java:19–43，以及[原窗验证](../../../minecraft-codev-mixins/build/f1-f2-verification/v03-20261012T105203Z-affected-regression/verification-v03.txt)/原始失败XML。诊断交付完成不释放AF-W02/03或AF-A01。
- 一行修复和额外一次回归尚待明确授权，不在本次只读诊断中实施。

### AF-V03失败与执行偏差采纳

- 已完整读取并关联本scope generation1完整failed Result；参数回显跨真实batch层16项相等。外层仅一次、native exit1，累计2/2。后端completed只表示交付结束，不改语义failed。
- [验证事实](../../../minecraft-codev-mixins/build/f1-f2-verification/v03-20261012T105203Z-affected-regression/verification-v03.txt)、[fresh XML汇总](../../../minecraft-codev-mixins/build/f1-f2-verification/v03-20261012T105203Z-affected-regression/xml-v03.txt)、[原生收据](../../../minecraft-codev-mixins/build/f1-f2-verification/v03-20261012T105203Z-affected-regression/native-v03.txt)。八个fresh Mixins suites/50 cases/9 failures/0 errors/skips；Fabric/Forge无fresh tests，不能拿旧XML补绿。
- F2有62条实际completion拒绝日志，合法untouched=false/library输入保护通过；task F1 alias/目录输入矩阵在初始producer失败，未到达。六条TestKit首构建失败，完整P01/P02链不成立。
- 新增1114文件/3016314 bytes普通副本，未逐件核定必要性；保留为已发生效果及执行偏差，不作为证明。执行期间32具名源/config/旧证据与十个选定父环境字段未变，不承诺全Host/cache保全。旧失败与副本不覆盖/删除；不杀daemon或补跑。
- 本次仅只读定位共享publication路径故障及最小纠正范围；不作AF-A01增量审计替代、不补写成功、不授予修复或第三次运行。

### AF-V02实际失败（增量许可前时点）：额度1/1，后继暂停

Root已完整读取并关联codev-mixin-af-v02-affected-regression/generation1 full Result（8001 bytes），语义**failed**，不是completed verification或启动前blocked。UTC 2026-10-12T09:56:04.8785056Z–09:56:09.0101650Z，实际启动1次、原生exit1；[原生回执](../../../minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/native-v02.txt)、[stdout原字节](../../../minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/stdout.raw)（107 bytes）、[stderr原字节](../../../minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/stderr.raw)（15177 bytes）保留。Handler把PowerShell单引号转双引号后经ProcessStartInfo.ArgumentList/cmd.exe /d /s /c，未保持JVM属性分组；有效daemon命令出现默认512m/256m而非3G且temp尾部多出双引号，属于我方执行偏差，不归因于F1/F2源码。

三个任务/test/lint/plugin checks均未到达；fresh suite/case为0，failure/error/skip不适用。现有14个旧XML与启动前普通副本一致，不能填为新通过；F1 alias/hardlink、F2变异/untouched=false、P01/P02/新pair/42行为/平台reopen全部未实跑。Handler保留1028个必要旧XML/相关闭合fixture普通副本，非新证据/封包；原startup.txt不覆写。仅19具名文件前后相同、父10项不变，不是全仓/Host/cache保全证明。child已退出、原生流/handles关闭，空temp最终非递归移除；无source/config/协调MD/authority/Git写入、安装/清cache/Host扫描或第二窗。完整[收尾](../../../minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/finally-v02.txt)与[验证判读](../../../minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/verification-v02.txt)可读。

实际Native已用1/许可1，原确认额度已耗尽。AF-V02 planningState/resultStatus=failed；AF-W02未满足，AF-W03 pending，AF-A01不eligible，消费者说明/完整G1/Git不放行。不因错误argv自动返还窗口或重跑，不把旧AF-V01或本failed改绿。任何补验先取得明确增量许可，当前无新执行授权。两个源码候选及源码gate仍保留，不宣称实跑修复关闭。

### AF-V01启动阻断与未用窗口恢复

Root已完整读取并关联codev-mixin-af-v01-affected-regression/generation1的full Result（4198 bytes），语义为**blocked**，不是tests failed或completed verification。实际Gradle/Java启动0次、JUnit0、无fresh XML/原生两流，窗口已用0/许可1；仅保存普通[启动日志](../../../minecraft-codev-mixins/build/f1-f2-verification/startup.txt)。父环境未改、只读handles关闭，没有覆盖旧生成输出、source/config/authority/协调文件或Git。AF-W02/03仍pending，F1/F2未实跑关闭。

阻断来自Root派生记录把外层wrapper误写7.6；已读取的实际gradle/wrapper/gradle-wrapper.properties:3为Gradle9.4.0。当前用户确认的是原样当前gradlew命令及该任务图正常效果，不是更改或固定7.6版本。Root仅勘误外层/内部版本绑定：外层保持仓库现有wrapper9.4.0与对应正常namespace；内部TestKit按既有配置，不强制7.6，不改wrapper/source/build/依赖、命令、JDK、任务、输出owner或窗口预算，不安装分发包或扩大整个cache权限。缺现有distribution/工具链仍停止。

C5仅将未完成验证边界细化为新的AF-V02/独立Handler/Result；原AF-V01保持blocked并列入selected graph历史，不resume、不回写completed。AF-W02当前listed item及AF-A01显式前置改为AF-V02，原exit0/fresh 52基线+新增/无failure-error-skip/新pair/P01/P02/finally谓词原样保留；新Result不能自动满足旧blocked item。AF-W01源码gate继续满足，Native实际仍0/1。旧startup.txt保留原样，新执行只用自有目录中的不同普通日志。

### 权威 assessment（复用，无写权）

| Family / action / path | owning boundary | 理由 |
| --- | --- | --- |
| PRD reuse；update/create skip；[codev-mixin-rework](../../prd/codev-mixin-rework.md)，Active | Codev产品owner/user | R1–R10/AC结果不变；原输入保护及可信完成/安全消费已有覆盖，只恢复而不新增用户结果。 |
| ADR reuse；update/create skip；[mixin-operation-isolation](../../adr/mixin-operation-isolation.md)，同一Accepted identity | mixins执行隔离/loader adapter owners | operation执行/发布/消费决定不变，engine/remapper/SPI不改，无新隔离架构或治理选择。 |
| Spec reuse；update/create skip；[mixin-preapplication](../../spec/mixin-preapplication.md)，Active | mixins/Fabric/Forge技术owners | F1恢复C1独立cleaned/C3输入验证先于写入；F2恢复C4矛盾/不完整记录拒绝/C5完整success与安全untouched区分。 |

沿用覆盖当前scope/版本的可靠assessment，并读取三份权威，无实质矛盾/重要coverage gap或必需改写。其unexecuted是准备时点验证限制，不覆写后续Work有限运行事实，也不代表完整G1已通过。

### 准确七文件拥有边界

路径均相对E:/Projects/cloche/minecraft-codev；本准备已定点确认七文件可读。无新helper/build/schema/engine/其它模块生产owner。

| 文件 | owner |
| --- | --- |
| minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationPublication.java | AF-I01 |
| minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt | AF-I01 |
| minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt | AF-I01 |
| minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/OperationPublicationTests.java | AF-I01 |
| minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java | AF-I02 |
| minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java | AF-I01后AF-I02共享串行 |
| minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java | AF-I02 |

### F1：输入保护候选边界

现有Mixin inputs为runtime+sources+inputFile+已配置mapping，输出target/records；StripAppliedMixins inputs为source/records/transformed/original+classpath+mixinFiles+已配置mapping，输出cleaned。task现有字符串/不对称Path比较与publication真实父目录解析不同，导致删除发生在writer读取前。

最小恢复：OperationPublication共享层在**任何旧结果删除/父目录创建/替换前**统一真实父目录/已有祖先+不存在后缀解析、Files.isSameFile和受保护目录包含关系检查所有outputs/inputs；身份解析失败抛错。保留publish(List<Path>, Writer)、Writer/staging/lock，只在原类加带inputs入口/必要私有路径逻辑；task提供已有完整集合，顺序/binding/cache/API不变。

身份拒绝时writer不进入，输入及其它已有合法输出/pair不变；取得所有权后writer失败/取消/second-move沿既有失效清理，不恢复旧陈旧成功。必需cases触达两task自身guard及所有输入角色父目录junction、existing-file hardlink、目录包含/合法相邻、不同真实file同basename或内容、合法不存在父目录/重跑；原failure/collision/cancel/child终止/retry保留。这里只记录待实现断言，不是已运行复现。

### F2：完成记录候选边界

现有producer正常success由normally-returned transformer完成：S=successes，T=targets，N=nativeTargets，D=nativeDeclaredTargets；S非空且S=T=N=D、failures空/非dynamic、Boolean obligationsComplete=true，provisional与正常返回链对应。consumer现有漏验flag/N/D。

只在现有整份entry循环补校验，放在source-matching continue及remove/rewrites之前：success flag真实Boolean true，N/D合法无重复字符串数组且S=T=N=D，provisional存在/合法并与S一致；两个clean入口共用，不改schema3/EngineOperation/PinnedMixinAdapter。untouched保持原独立分支/successes空/安全校验，Boolean false合法；active未访问T非空而N/D空、inactive全空也不能由空数组相等推断true。

当前implementation生成真实Good/Unused pair后分别变异flag缺失/false/null/非Boolean、N/D分别缺失/空/不同/额外/非字符串/重复、provisional缺失/矛盾；consumer拒绝、无新published cleaned，消费前后输入不变。正常Good与active未访问、side-excluded、inactive untouched=false保留entry/config/refmap/class/resources/未知字段。F2证据进入writer后旧cleaned按原publication失效，不承诺恢复；不要混同F1预校验保护旧合法输出。

### 授权效果与证据新鲜度

唯一外层命令在Waves AF-R02.verification原样登记，cwd E:/Projects/cloche/minecraft-codev。Mixins全check无filter+FabricApplicabilityRepairTests六case+ForgeMixinMetadataTests三case；原43+6+3=52基线+实际新增JUnit，最终数量取fresh XML，无failure/error/skip且exit0。排除全65/Forge patched八/Core vanilla三/ABI；依赖模块正常编译不等于运行其Minecraft fixture。

child Microsoft17 JAVA_HOME/PATH，JAVA_TOOL_OPTIONS和GradleVM java.io.tmpdir同为minecraft-codev-mixins/build/f1-f2-verification/temp；child移除冲突JDK_JAVA_OPTIONS/_JAVA_OPTIONS，父不改、GRADLE_USER_HOME继承，外层保持现有wrapper9.4.0、内部TestKit保持既有配置/编译11/所选tests17/heap3G。**不预写TestKit属性**，额外需求停止。外层--no-build-cache不取消P01/P02已有内部--build-cache/多次build；warm SUCCESS→pair FROM_CACHE→first fresh consumer SUCCESS、target42/original1/Unused保留必须新实测，作者不能另开focused窗口。

允许所选任务图正常classes/libs/plugin metadata/lint/XML/reports、对应项目.gradle/依赖编译和继承home的wrapper/cache/daemon/TestKit正常效果；fixture只Mixins build/fixture-evidence、Fabric/Forge build/platform-fixtures，普通logs/temp/必要旧生成证据副本只mixins/build/f1-f2-verification。非整build/cache/Temp，不建manifest/冻结/checker/账本。原审计/ABI/失败报告不改；仍需复用但会覆盖的旧XML/fixture先普通复制保留或用既有历史副本，不假称覆盖后仍是原物。

Windows负例限JUnit自有root内cmd.exe /d /c mklink /J、JDK Files.createLink；finally先cmd.exe /d /c rmdir自有alias **无/s**，检查退出/解除后再安全清理，不能递归误清target。实际卷/ACL未实验，建立/解除失败必须failure不skip/升权。只管理自有child/handles；publication原自有child终止/重试及TestKit内部build保留，不是Host管理。

缺工具链/依赖、额外写域/属性、范围外source、新failure/error/skip、junction建立/清理失败、必需旧实物无法保留均保存/finally后停止，不自动重试/扩跑/安装/清cache/升权。AF-A01只在AF-V03完整通过后一次独立只读改动/新证据复核，无额外Native。

### 已有证据有限复用与F3勘误

本准备验证存在且可读的仓库相对来源：
- docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md：原分窗/65场景/P01-P02/Forge8/Core四闭包及158class+1kotlin_module关联；旧A/AC表不作逐AC索引，不沿其外部Result指针重建本scope原文依赖。
- docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/runtime/native.txt：原五check exit1，Mixins/Fabric局部成功，不改绿整条native。
- docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/native.txt：原Includes exit0/test NO-SOURCE，不是新65重跑。

Root已采纳B-W01至B-W04有限结果；原continuation-02 exit1/Forge11+Core3局部成功、两原Forge实际compiler8、Core3/四闭包负例、B-I04独立Core+三caller四native0/18descriptor/default/Kotlinmetadata/精确debug继续按原scope有限复用。158class+1kotlin_module及八class28method166LNT恰+2/其余150保持是原结论，本准备未重算/重跑。R13 failed、R14 limited、strict=false/external unknown、Ruff/fullStrictScope=false、旧partial/failed/unknown/warnings全保留。

旧implementation records不能充改后正例；共享publication/consumer变化后的52基线和新增cases必须AF-V03产生新Native/XML/pair。历史绿样本不消除F1/F2，不证明全Host/cache/writer、完整平台矩阵或消费者接线。

F3采用codev-mixin-i05-independent-audit/generation1第5节正确编号的**有限场景关联**supersede原错误表，原表/报告/权威不改、不新建勘误文件，不重造12项完整验收证明：

| 正确编号 | 原有限场景关联 |
| --- | --- |
| A1/AC1 | 真实注入/empty与legacy all-delete/旧注册。 |
| A2/AC2 | 同JVM serial/overlap、plugin/domain/session独立、mapped A→unmapped B；不是provider/cache。 |
| A3/AC3 | task-only plugin/class/byte/resource顺序、body/resource-only失效。 |
| A4/AC4 | actual optional/required success/attempt、failure/cancel/retry/second-move/publication；F1未覆盖输入保护路径。 |
| A5/AC5 | 内容/顺序/side/scope/options/pair/mapping/duplicate origin绑定；F2拒绝仍不完整。 |
| A6/AC6 | 精确JSON Foo/FooExtra/other package、格式、side-excluded、未知metadata/resource保留。 |
| A7/AC7 | 完整native、多target all-success/缺失失败、residual/dynamic/parent/plugin拒绝。 |
| A8/AC8 | Fabric适用性/metadata、Forge manifest/TOML/多引用、third-party capability。 |
| A9/AC9 | owner/overload/descriptor/reverse/null/unmapped/ambiguous mapping identity。 |
| A10/AC10 | 真实refmap→MemberInfo→chain、tuple/namespace/context/wrong-direction。 |
| A11/AC11 | TestKit provider/恢复后fresh consumer/failure/retry、retained baseline。 |
| A12/AC12 | pinned engine/task extension、unsupported config/class/injector/private-access；无自动Extras/Loader扩展。 |

以上是已采纳编号加工摘要，不是完整审计原文或新逐AC通过证明。B-W05仍阻断，F1/F2实跑关闭依赖新验证及复核。AF-W01/02/03建立本Plan有限结果，不自动接受完整G1/消费者说明/I06/Git。



### AF-A02独立增量复核采纳与AF-W03判断

Root在2026-10-12完整读取并关联task `codev-mixin-af-a02-incremental-review`、generation1、status completed的完整Result（15797 UTF-8 bytes；非通知摘要，非项目外定位器依赖）。七文件与必要caller/原契约、本窗fresh XML/原始两流/具名closed records/JAR已由独立审阅者交叉核对；其方法为纯只读文件/XML/SHA/.NET ZIP，新增Gradle/Java/test/项目进程为0，无源码、文档或产物写入。

- **F1 high已闭合**：`OperationPublication.java:15–40,80–102`在任何mkdir/lock/delete/writer之前解析所有输入与两个输出slot真实身份；realpath、isSameFile及目录包含保护覆盖别名/hardlink/junction/缺父目录。`Mixin.kt:98–99`和`StripAppliedMixins.kt:102–103`声明全部实际输入；Path单元素包装防止Iterable拆段。fresh XML的42 INPUT_GUARD及真实目录/合法邻接/publication案例支持拒绝时输入和旧合法输出保全。
- **F2 medium已闭合**：`SelectiveConsumer.java:84–105`在source跳过及任何JAR写入之前验证整份operation；success要求完整且一致的success/nativeDeclared/nativeTargets/provisional集合及真Boolean完成flag、无失败/dynamic，严格拒绝非字符串或重复成员。31种变异×matching/other-source的62拒绝有真实records及失效旧cleaned断言；Good只删耗尽entry，合法Unused/side-excluded `untouched` + `obligationsComplete=false`与未知metadata/resources保留。
- **关键证据充分限定支持**：10 XML实际59cases=50+6+3、零failure/error/skipped；suite timestamps在R02原生窗口；真实warm produce SUCCESS→pair FROM_CACHE→首次fresh consumer cleaned SUCCESS、新13项implementation与42/1/Unused、有界Fabric/Forge双metadata closed/reopen、具名finally均与源码断言/原两流/闭合实物关联。42与62是JUnit内部断言数，不增算JUnit cases。没有旧41/旧records补绿。七文件在审阅终点2026-10-12T15:49:58Z仍7/7匹配R02 after-hashes，Mixin单行与before逐字绑定，无源码漂移。
- **Root gate判断**：独立报告完整交付与无重大未处置缺陷分别判断；AF-W03 satisfied，当前AF Plan完成。结合已完整接受的原I05/B-AUDIT-01及本修复增量，Root明确判原B-W05的F1/F2阻断已解除，I05缺陷处置完成；这是新的加工判断，旧B01 gate当时not-satisfied状态/旧报告保留历史，非覆写或再跑原全审。F3正确有限编号沿原Context supersede错误索引，本轮不造新的全24 A/AC证明。消费者文档仍未交付；不自动释放历史R13/W03、I06执行、G1或Git。
- **范围及残余**：只七文件/必要caller/本窗59，原65/Forge patched/Core/ABI兼容证据仍按既有范围，不重跑也不宣称本窗覆盖。真实身份保护不是恶意并发filesystem替换沙箱；digest不认证恶意生产者，native/thread/外部副作用和全OS/卷/ACL/全Host-cache认证不在原接受契约。本次只读路径/PowerShell计数/CDATА范围查询错误已纠正，没项目执行或写入，不构成新的许可缺口。旧failed/unknown、AF-A01未确认回执及1114普通副本偏差不改绿。

仓库内复查来源：`minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/`的`verification.md`、`native-v03.txt`、完整两流、`fresh-xml/`、`after-hashes.txt`、`single-line.diff`、`Mixin.before.txt`、`behavior-evidence.txt`与具名闭合实物；`minecraft-codev-mixins/build/fixture-evidence/MixinInputBindingTests/`中本窗completion/cache案例，及原有Fabric/Forge platform-fixtures具名closed JAR。此段为充分加工结论和gate理由，不是独立报告原文副本或新证据封包。

## 以下为历史 B01 Context（非 selected）

> 下方旧“当前/唯一/待确认/单次未用”仅原scope时点，历史外链只读保留，不参与新依赖/权限迁移；本次不造产物或原始报告副本。

## 当前范围确认：B-I05 Includes格式与分窗收尾

当前新增确认：用户选择“修格式并收尾（建议）”。仅Includes main目录下ExtractIncludes.kt、IncludedJarInfo.kt、IncludesJar.kt、StripIncludes.kt处理continuation-02原报告的八条逗号/换行/缩进诊断，不改逻辑、API、断言或lint规则，不运行全仓format。之后一次Includes check，沿--rerun-tasks/--no-parallel/--max-workers=1/--configuration-cache/--stacktrace/--console=plain。只读消费g1 Mixins43/Fabric8、continuation-02 Forge11/Core3及B-I04 ABI的同源source/TestKit/closed实物，全部适用A/AC、P01/P02与实际Java8不减；不重跑65测试、caller或focused。原两次exit1及历史failed/partial/unknown永久保留。新普通日志仅原B-I05 namespace的continuation-03/，temp仍原runtime/temp，有界正常输出和finally不扩域；新失败/reusegap保存停止、不自动重试，无安装/清cache/审计/I06/Git。Root已完整读取codev-b-i05-includes-format-closeout generation1的completed完整Result及continuation-03/verification.md。Includes唯一native exit0，编译/ktlint/validatePlugins/check完成，test如实NO-SOURCE；旧四module成功check/65tests零失败、错误、跳过按原窗/source/TestKit/closed实物关联，12对A/AC、P01/P02、实际两Forge Java8、Core四闭包负例、I04当前158class+1kotlin_module bytes及finally支持。Root据此接受B-W02/B-W04，B-W01/B-W03继续满足；本scope收尾完成，不追加native。三条既有auxiliary warnings及准备/读取错误保留，旧两条exit1、R13 failed/R14 limited/strict=false/external unknown/Ruff限制不回写，不自动释放历史W03/完整G1/I05/I06/Git。报告见 docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md。以上为当前唯一新增许可，下方原scope/执行结果保留其时点。

### 原四brace scope及执行结果（保留时点）

当前新增确认：用户选择“修四处并补三模块（建议）”。只在ForgeMixinMetadataTests.kt与PatchedMinecraftTests.kt补原ktlint诊断的四处分支花括号，不删断言、不改逻辑；之后一次Forge/Core/Includes check，沿原参数。复用g1 Mixins43/43、Fabric8/8须同输入且实际source/TestKit/closed产物可闭合；最终五模块按两窗组合，原五check exit1/failed永久保留。ABI不重跑，无focused/生产修复/清cache/安装/扩权/审计/Git。新普通日志只原B-I05/continuation-02/，g1原流/记录/SDKResult不覆写，child temp仍原runtime/temp。复用gap或新失败保存finally后停，B-W02/04未满足；新增四brace已完成；该唯一三模块续验native exit1，Includes四main文件八条ktlint逗号/换行/缩进失败。Forge本窗fresh11/11与Core本窗fresh3/3均零失败/错误/跳过，二者check实际成功；Includes:test/validatePlugins/check未到达。两流及finally已保存、generated属性精确恢复、父env/110局部必要输入前后不变；旧Mixins43/43与Fabric8/8未重跑。全部source/TestKit/closed产物及ABI复用最终消费因失败停点未完成；B-W02/04未满足，不宣称五模块成功。该增量次数已用完，未授权Includes源码修正或自动重试。以上为当前新增范围，以下原统一窗及初次准备说明保留各原时点，不与新增scope竞争。

原统一窗确认（原许可时点，g1失败保留）：恢复一次独立 Core compileKotlin/jar、原三封存 Java17 caller 与原 ABI/debug 验收；成功后串行执行一次 Mixins/Fabric/Forge/Core/Includes check，共用组合窗验证修正后的 PatchedMinecraftTests，不追加 focused。B-W01 已有限满足。B-I03 g1 启动脚本失败、g2 实际 focused native exit1/2 failures 均保留；g3 仅一行 argfile escaped-backslash 解码修正及离线检查完成，内层 partial，未原生回归。B-I03/B-W02 不提前释放，须以 g3 同一修正输入与 B-I05 的新完整原生结果共同成立；共享验证的入场不依赖尚待该窗证明的 B-W02，最终完成仍必须满足它。匹配 Waves 的新依赖只改变证据复用与次序，不减少 A/AC、Core3case、P01/P02、实际 Java8 或一次性维护条件。

仅既定生成子域、B-I04/B-I05 普通日志/必要结果快照、原受限 child/temp/TestKit 属性与精确 finally；不授权额外 focused、源代码/依赖/规范修复、清cache/安装/扩权、旧封包重跑、独立审计/I06/Git。失败保存恢复后停止，不自动重试。B-I04 g1完整Result已读取并关联：独立Core与三caller各一次native exit0、158class/模块bytes及原ABI/default/Kotlinmetadata/精确debug条件完整，输入前后不变，受限child无待恢复属性；B-W03有限满足。B-I05 g1完整failed Result已读取关联：唯一五check native exit1，Forge两个测试文件四处ktlint Missing { ... }，Mixins43/43与Fabric8/8本窗fresh零失败/错误/跳过，Forge/Core/Includes test/check未到达；两流已保存、handles结束、generated属性精确恢复。原单次窗口已用完，不自动source修正/重试；B-I03/B-W02及B-W04依旧未满足；文档/UI不是 admission 或通过证据。下方初次准备及原兼容段描述保留其原时点，以本节与当前 selectedWavesGraph 为新范围，不重写历史或建新取证包。

### B-I03 方法说明校正（沿用当前确认，非运行或 gate 结果）

直接使用原 `compileJava` 的 CLI 分支：必需 `fixtureJava8Javac` 经受限 outer child 的 `CODEV_TEST_JAVAC8` 传给原 nested invocation；`fork=true`、指定 executable、不设置 javaHome，`forkOptions.jvmArgs=[-J-showversion,-J-Duser.language=en]`，`verbose=true/incremental=false/failOnError=true`。保留 `jar/printCompileClasspath/-s/--rerun-tasks`，增加 `--info/--console=plain/--no-build-cache/--no-parallel/-PfixtureJava8Javac`；outer/test 保持17，不对 debug TestKit 使用 withEnvironment。逐 fixture 的实际8版本、原 Test.java 解析、本次 wrote、原 patched/named classpath、compileJava/jar SUCCESS 与重开 JAR 内 **Test.class** 原 bytes 等同为合取证据；major52仅辅助。原两源码实际产物为 Test.class，准备中的 Consumer.class 是方法说明误写。唯一 generated TestKit 属性原 bytes/缺席须 finally 精确恢复；不恢复 jcmd/CIM/observer 或四 key/byte-writer 账本。以下初次准备的未定方法描述保留其原时点，本节仅局部校正方法，不推进 Result/Waves/Todo/gate，也不构成实跑通过。


## 本次 processed context：mixin-layered-b01

直接入口：[Work](work.md) · [Plan](plan.md) · 唯一新候选 [Waves](waves.md)。本次只处理已接受 B 方向并首次派生 scope；旧图/旧 R13/collector 后续暂停，所有实施都等待 Router 集中披露及当前用户确认，不能由设计接受或此文件替代。

### 已接受决定与来源

用户“落实这部分吧”对应 B：日常小 JAR/局部 TestKit；Core/原两 Forge 真实构建按边界和组合交付；ABI/rename/debug 一次性维护；Fabric SERVER/client-only 重复合并；补一个真实 Forge manifest/TOML 双位置 JAR。四 Codev key、cold Temp 逐路径、严格 byte 归属不再卡新 R13 常规功能验收。此为当前 Handoff 的接受记录，不改设计报告原“建议尚未接受”的历史措辞。

完整读取并解码的设计来源：
[C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-mixin-test-design-simplification-artifacts/result-1.json](C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-mixin-test-design-simplification-artifacts/result-1.json)，subagentId=codev-mixin-test-design-simplification、generation1、内层 completed。§3 的源码 assertions、§4 compiler/strict 边界、§5 命令和§6 family assessment 直接消费，不重做调查。

| Family / 处置 | owning boundary / 当前可读 path | 本范围理由 |
| --- | --- | --- |
| PRD reuse；update/create skip | Codev 产品 owner/user；[codev-mixin-rework](../../prd/codev-mixin-rework.md)，Active | R1–R10 的用户行为保留；频率/重复证明变化落在 Work 而非产品删减。 |
| ADR reuse；update/create skip | mixins 执行隔离/loader adapter owners；同一 [mixin-operation-isolation](../../adr/mixin-operation-isolation.md)，Accepted | 隔离、完成结果及 evidence-consuming selective 架构不变。 |
| Spec reuse；update/create skip | mixins/Fabric/Forge 技术 owners；[mixin-preapplication](../../spec/mixin-preapplication.md)，Active | C1–C8 和 A1–A12 不删，A8 多 metadata 的实现测试缺口通过真实 JAR 补覆盖。 |

本次 read 当前三份 authority 与 assessment 的行为一致；其“unexecuted”是权威原文的验证限制，不据此覆写 Work 后续实际历史，也不在无授权时同步 authority。未知新生产缺陷或规范矛盾只停止受影响部分并报告。owners 是既有模块/职能边界，不捏造已指派的人名。

### 已有事实与最小变化

- 当前只读对照确认：FabricEnvironmentObligationsTests.serverMustNotConsumeClientOnlyConfiguration 仅 SERVER/client-only 输出=1；FabricApplicabilityRepairTests.outerEnvironmentIntersectsInternalKindsAndRetainsInactiveOnly 已包含该格，还检查 inactive/untouched records、cleaned config/metadata、class/AW/nested resource 保留、ordinary selective 拒绝。保留后者全矩阵及 providerChainReexecutesOnSideAndEnvironmentChanges，去重不丢客户端、side、parent、tamper/失效语义。
- ForgeMixinMetadataTests 当前 manifestSelectiveReopenTrimsBlanksAndPreservesOtherAttributes 与 neoforgeTomlSelectiveReopenSavesOnlyConsumedEntry 是两个不同单位置 JAR，不证明双位置共同更新。未来在同 suite 增加一个真实双位置 source→cleaned JAR 用例，不扩 Loader/version matrix；缺陷若暴露则不兼修生产。
- PatchedMinecraftTests 实际 nested argv 为 jar、printCompileClasspath、-s、--rerun-tasks；原 basic-patched-test 声明 Java8/1.12.2-14.23.5.2860，原 remapped-patched-test 声明 Java8/1.16.5-36.2.39。宿主测试目前只 build()，没有每 fixture 的实际 compiler→fresh class/JAR assertions。outer Gradle wrapper 9.4.0；外层 JDK17、Core test launcher11/nested17、Forge compiler8 分层不变。
- 当前读取是测试和原 fixture/build 源码对照，不是执行。没有运行 Gradle/Java、日志探针、jcmd/CIM 或取证实验；没有取得绑定当前 Gradle 9.4 compiler 执行路径的新增来源。--info/JavaCompile metadata 只能作候选，不能承诺足够。

### 条款迁移与保留

| 旧合同部分 | 新范围处理 |
| --- | --- |
| 全部 A1–A12/AC1–AC12、实际 target 调用、records/source/output association、selective 安全 | 保留；Plan 按风险关联同一证据，缺 observation 仍不完成。C4 产品 records 中的 content identity 不是本次删除的 Host hash 账本。 |
| P01/P02 的 cache restore→fresh consumer、input/body/resource/mapping/side 失效、publication/cancellation/retry/close | 保留现有 suites 和真实语义，不能以 UP_TO_DATE 或 hash 相等替代 FROM_CACHE consumer 链。 |
| Core 三 case/四 vanilla 闭包/准确负例，原两 Forge 真 Java8 | 保留；日常不常跑，触及边界及此次组合交付仍需要。无新版本矩阵、无六退役 source 恢复。 |
| 七 facade/18 descriptors/default/Kotlinmetadata、封存三旧 caller、八 class/166 LNT 恰+2等 debug 条件 | 本次维护交付一次性保留，不绑定以后每次 Mixin 日常修改；不重编封存 caller。 |
| 四 Codev key/cold 默认 Temp 逐路径/严格 byte-writer 账本/全 Host 保全 | 已接受退出新 R13 常规功能分母；不再扩 collector。失去相应精度如实披露，不能把 green/XML 当全 Host 保全。 |
| 历史只读/旧对象保护、source/tests 不被验证器修改、child 受限环境、允许 output namespaces、failure 保存/finally | 保留。不手动清 cache，不放行整个 build/cache/Temp。正常 effects 许可与严格归属证据是两件事。 |

### 未决只影响对应分支

**B-I03 / Java8 方法 gap**：必须证明实际受控 compiler 执行，而非传入 qualified=true、javaCompiler selection、major52 或版本声明。最小测试侧候选为原 JavaCompile 受控 fork/可定位 compiler 执行，与每 fixture compileJava SUCCESS、fresh 删除后重建的 class 和 jar 绑定；若采用原生执行日志，须先有与当前版本源码及运行证据一致的支持。此候选未 settled，本次不指定其已经可行的 exact argv/日志格式、不恢复 jcmd 采样或新增 observer。该分支在 Waves 显式 blocked；已 settled B-I01/B-I02 不依赖它。

**写边界 gap（条件性）**：受限 child 的 TestKit home、fixture.evidence、自有 Temp 和既有输出 namespace 必须可实现；private Gradle home 本身不隔离系统 Temp。旧 r05 的限定 namespace 是用途参考，run01 许可已用，非此范围授权。无法让相关默认临时创建落在受控新 namespace，或需要具名旧对象/第三方额外写入时，停止受影响运行并向 Router 报具体路径/原因，不能授权整 cache/Temp；也不重新要求严格四 key/逐 byte 全账本作为普通功能 PASS。

### 真实历史与本次界限

run01 原 failed/五 check exit1/Core2/3/Includes 未完成、fresh 独立 JAR/三 caller 未启动、24行 partial 保留。R14-V01 generation2 Core3/3/W09 局部接受仅为原有限历史；rawpartial、strict=false、三偏差、externalAfter 永久 unknown、Ruff/fullStrictScope=false、旧 g3/attempt01 unknown 不回写通过。collector partial/runtimeReady=false 是历史候选，所有调查与旧后续已终止/暂停，不以新范围静默续跑。

只授权四协调 MD 局部同步；未来目标/命令/原生 XML/JAR 输出均为文本，不是已有 artifact 或通过回执。本次未造证明封包/checker/冻结/hash ledger，不执行新图或发布 gate，历史 SDK/项目/session references 全保留在下方。

## 以下全部为历史 Context（原 scope/时点/证据保留）

> 下文旧“当前/唯一图/ready/单次未用”不竞争上方新方向；原状态与授权保留历史含义，不能成为新执行 permission。

# G1 Mixin Rework Work

## 当前 R13 执行事实与候选状态（本次仅事实维护）

现行事实以 Root 已关联、完整消费的四份内层 Result 为准，不以 SDK envelope 的 completed 代替执行结果。来源目录为 `C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/`：
- `codev-r13-run01-validation-artifacts/result-1.json`：generation1，内层 **failed**，实际生产失败。
- `codev-r13-collector-runtime-connection-artifacts/result-1.json`：generation1，内层 **partial**，部分接线候选。
- `codev-r13-collector-contract-assessment-artifacts/result-1.json`：generation1，内层 **completed**，必要条件矩阵与 PRD/Spec/同一 Accepted ADR reuse 判断；不是运行接受。
- `codev-mixin-plan-pragmatic-review-artifacts/result-1.json`：generation1，内层 **completed**，规划评审；本次仅落实过时事实校正，不将建议变成新图、降标或运行许可。

R13 的原单次窗口已用于 **run01**，不是 missing/not-run 或四窗口全0：

| 原四类动作 | run01 实际事实 |
| --- | --- |
| 五模块 check | 已实际到达 Gradle，cmd PID197840，native exit1；Mixins/Fabric/Forge check 到达，Core:test FAILED，Core/check 与 Includes:test/check 未完成。Core 三 case 为2pass/1failure/0error/0skip，不是3/3/0。 |
| 独立 fresh Core JAR | 未启动，native exit unknown；check 内的 Core:jar 依赖执行不替代独立窗口。 |
| 三封存旧 caller ABI | 全部未启动；七 facade/18 descriptors/default/Kotlinmetadata 与精确 debug 比较未完成。 |
| Forge observer | 随同一次 check 实际采样，取得 Java8 javac 栈与两个 fresh major52；严格归属闭包及观察边界未满足，不能算 Forge 验收通过。 |

run01 全24 A/AC 行均 **partial，0行生产通过**。未 qualified 的 PID194796 被执行630次 VM.system_properties，另有宽 java.exe/javaw.exe CIM 轮询偏差，不能由精确样本消除。唯一 generated Forge TestKit 属性 finally 已恢复原缺席，八父环境摘要相等；效果归属/适用 baseline、P01/P02 完整闭包与最终 executor 活动状态仍有缺证或 unknown。原失败、恢复与偏差完整保留，未补跑。

当前 collector 为 `evidence/g1-implementation/r13-collector-repair-r01/runtime-connected/` 的 **partial、runtimeReady=false** 候选：native/raw-close、逻辑终态、部分 publication/facts 与五固定输出 before 已接通；真实 Forge 合法定位/采样、动态 key/input/hash/Temp 归属、其余适用 baseline、全24/ABI 终验接线仍未闭合。48项自身检查只复用为该候选的聚焦证据，不证明生产 ready；必要条件矩阵的可替换方法判断也不补足真实缺口。本次未改 collector、未续跑 R13。

`evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/` 已是失败历史 owner，**不可覆写或附加新产物，不再是未来可写 owner**。保留图中的原路径/链接及 r05 finalBinding、finalPreparationBinding、r13FinalBinding、futureEvidenceOwner、productionOwner、plannedEvidenceDirectory 作为原准备绑定/历史定位，不把它们或原 runAuthorized=true 当成下一窗的实际就绪或新 owner 授权。旧 manifest 的四 tuple 身份不等于本次修正文档的新字节；未来新自有 owner、当前 tuple、许可和实际 ready 仍须 Root 核对，本次不指定或宣称任何新 owner ready。

历史 g3 仅按原278/T0/8-7-1、真实 default native0/198及完整 Result57 消费；R14-V01 generation2 的有限 localcompleted/W09前置满足沿用，不重新接受或重放。原 preseal false/null、SDK附加失败、R14 rawpartial/strict=false/三偏差/externalAfter永久unknown、Ruff/fullStrictScope=false、旧g3unknown和 attempt01 两unknown 均不漂白；旧封包只证明原快照，不要求旧默认程序在272新树通过。

唯一图仍是 `waves.md#G1-I04E-R13`。原节点/边/IDs/完成谓词/权限/链接不变；完成谓词中原“单次未用”描述的是原窗入场条件，不是现在的窗口余额。全五模块、24 A/AC、Core三项零跳过、四 vanilla 闭包/负例、P01/P02、ABI/精确debug、双Forge真实Java8及隔离/恢复要求不降。**R13 未 ready/completed，G1/W03/I05/I06/Git 未释放**；本次仅维护四文档事实，不投影 Root Todo 或 Gate。

## R13 r05 父capture最小修复（历史准备时点）

> 以下保留 r05 及其各代原 scope、冻结身份和准备时点；其中“当前/未运行/四窗口0/单次未用/未来run01”只描述当时，不覆盖以上现行失败事实，也不授予旧 owner 新写权。

本次同一四文档＋独立r05形成可供独立核对的同一R13合同；唯一matched执行图仍是 [Waves](waves.md)#G1-I04E-R13，Plan不是第二图。PRD/Spec/同一Accepted ADR三family reuse；产品、Mixin行为/API/闭包及隔离决策不变，AC1–AC12/A1–A12完整24分母不降。

用户已选择“补齐并继续”：原四动作、五check、Core3/3/0、freshCoreJar、三封存caller -Xverify:all、两原Forge freshJava8 PID-parent-javac栈及单次未用实际窗口均保留；必需增量与四派生MD/独立JSON-MD同步已获许可，独立只读核对通过后直接续原R13，不再等待逐文件或整段scope重确认。本writer只prep；runtime与启动Gate仍pending，不用旧startup结论替代新就绪。

Root已接受R14-V01 generation2有限localcompleted、W09前置满足；分层消费方式已接受，不由本writer释放完整W09/W03。原R14 rawpartial、strict=false、三历史偏差、externalAfter永久unknown及Ruff/fullStrictScope=false/attempt01限制保留。历史g3只按原278/T0/8-7-1消费真实46→47 default native0/198及完整Result57；517957 bytes/SHA256 `2d75221397dc47bc0caa3d8af5fca299ca8f9eb40601de44b6b26372241cd38a` 仍在r01 historical-default.json；preseal false/null及SDK附加失败不改，不在272树重放旧程序。

当前272命名输入identity `daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df`、六source缺席、新四tuple/24map/scope由 r05候选及短静态入口（历史原件不可访问；见顶部保留说明） 与其manifest/真实verification绑定。r04 before.json无损保存写前四MD完整bytes/length/SHA；r01/r02失败、r03八member与四tuple、原G1-I04E-R13 blocked32member/a17292aa798e3766c35b9e6ff259cd75e0a524e4eb4f87a3e8b8842ac56677cd及完整13993-byte审计关联保持原样。generation1 partial仅预检；generation2 blocked是scope缺口而非测试失败，四实际窗口全0，24 actualEvidence=null，单次许可未撤回/未使用。r03只作历史snapshot，不对newtree重放旧入口。

增量仅A/B/C/D，精确源/方法/分支与future-binding字段见r05 effect-rules.json及preparation-scope.json：A为两个original Forge fixture五固定task输出、必要父目录、实际miss的at.log/MCP步骤日志（cache hit仍delete/link/copy，不假设隔离copy）；B仅两个本轮实际TestKit userhome/caches/minecraft-codev四实际op/input-key锁及具名产物、version-manifest、实际1.12.2/1.16.5 metadata/官方SHA1下载/server提取/原Forge-userdev-MCP坐标对象；C仅冻结源码默认java.io.tmpdir中新创建本轮文件，绑定source/method/task/version/branch/PID/context/lifecycle；D未来新生产owner=docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/（本writer不创建）。原16具体proposed owner/26 build子域及四DSL main依赖、工具/八env/HTTPS限定对象/唯一TestKit属性finally恢复强度不变；不扩整个build/cache/Temp，不清cache/删foreign file/改全局TMP或JVM。

源码复核的MCP实际后缀是patches*.lzma、mcp-step*.out（不是审计/简称的*.jar），按已接受“实际分支MCP temps”精确绑定，不认证不存在的jar公式；mcp-data suffix来自实际已验证data key。动态physicalroot/key/input-hash/URL/坐标/随机名/PID/context仍future-unbound/unknown，模板许可不是runtime ledger，不计必需证据passed；第三方effects未穷尽，额外未声明范围/必需证据缺失仍停止，不虚构全Host/全cache保全。

完整未来证据仍含全五check/全部24 freshXML方法窗口、Core3/3/0、两MC×common/client四闭包/准确负例、P01/P02 SUCCESS→FROM_CACHE pair→fresh consumer及same-JVM native/metadata/provider/legacy注册、七facade18descriptor/default/Kotlinmetadata、八class28method166LNT恰+2且BCI/count/order与其它150class不变、两原Forge真实freshJava8。scope中的三ABI完整argv仅换自有CoreJAR/输出owner，其它classpath/顺序/数量/flags及三个完整observer模板不变。

Author准备状态与单次静态回执分离；**非R13 ready/run/G1 accepted**，scope可独立核对不等runner完整。本次只精准写四MD＋r05 JSON/MD；不跑Gradle/Java/jcmd/CIM/旧checker/collector，不创建run01，不投影Todo/Waves完成/释放Gate，不实施I05/I06/Git。新窗before/effective/finally/新final只读proof与实际执行程序仍未完成；原32包不得附加新产物，新actor只在run01自有owner输出。有限named-byte保全非全Host/atomic/continuous，SDK正常临时日志保留。

直接同目录入口：[Work](work.md) · [Context](context.md) · [Plan](plan.md) · [Waves](waves.md)。

r05仅修派生父capture：W明确为Codev下docs/works/mixin-rework；child返回先exclusive持久化真实exit/UTC/独立完整raw两流/cwd/argv/逻辑stdin来源，再decode/parse/metadata；派生异常独立关联raw并失败停止。r04父formal native1/未seal及原14成员+manifest+failed verification冻结保留，丢失child exit/UTC/两流/解析永久unknown；原197检查只继承。本候选仅capture回归与一次新完整static，结果见r05真实verification/seal，不代表独立接受或完整runner/R13实际ready；四实际窗口仍0、全部actualEvidence null。r05 before.json另存本次写前四MD真实bytes，旧历史不全局替换。

本次resume-before.json另存generation1 prepare失败后的mixed四MD真实bytes；REPAIR.md/before.json/FAILURE.md/preparation-failure.json原字节永久保留。CONTINUE.md新准备按artifact核对图33个候选prefix与1个contractId，scope-only tuple说明不要求出现在图。新capture回归与唯一完整static/末端seal分别由真实raw/UTC/native回执证明；原失败不改绿，后续独立接受责任未释放。

当前active静态子候选为r05/schema-corrected，修正原审计英文词语及role/file元数据误假设；原g1 prepare与g2 formal/terminal真实failed和47冻结成员全部原样保留，不加英文unknown到原audit。corrected/resume-before.json保存写前四tuple真实bytes及原58 named身份；新子候选完整formal与terminal/seal须实际通过，仍等待Root独立接受，不执行R13或释放任何门禁。

schema-corrected修正按ID绑定wave可选state presence/value；原g1/g2/g3失败、top47与corrected27冻结及全部named/raw不改绿。写前真实四tuple由schema-corrected/resume-before.json保存；新完整formal/terminal/seal必须真实通过，仍待Root独立接受，不执行R13或释放门禁。

## R14 有限局部完成合同记录（历史时点；g2接受以顶部为准）

当前用户明确选择“接受有限局部证明（建议）”；合同 **r14-limited-local-completion-r01** 及来源/静态核对见有限局部合同包（历史原件已删除；原路径 `evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/README.md`）。这是已接受派生合同的记录，不是正式 R14 接受或 G1 验收。

仅接受原窗口三条 **accepted known execution deviations**（路径相对 Cloche）：`minecraft-codev/.gradle/9.4.0/checksums/checksums.lock`、`minecraft-codev/.gradle/9.4.0/checksums/sha1-checksums.bin`、`minecraft-codev/.gradle/file-system.probe`。不称原窗原本合规，不认证 writer/必要性，不扩大整个 `.gradle/cache` 白名单或授予未来写权。

主动局部分母复用已完整独立核验的六精准删除、当前272输入、fresh3/3/0、四真实构建闭包/准确负例、原 native command/cwd/UTC/exit/两流/产物和有限本地域保护；**仅不可恢复的原 externalAfter/externalEffects 从此 R14 主动完成分母排除，永久 unknown**，不声称外部无变化或全缓存/全 Host 保全。禁止安装工具、扩权、全局配置变更仍有效。

原 `G1-I04E-R14` 执行已结束，原 `verification.json`/literal Result **partial**、两 strict=false、生产采集 native1、原独立 readonly native1及失败材料不改；准备 scope 的 executionAuthorized=false 仅历史。原 producer partial 不再作为 completed 前置。唯一后续 `G1-I04E-R14-V01` 独立只读 Result **missing/not-run**，正式局部接受 **pending verification**；只有新完整独立结论由 Router 判断才可能释放 W09。当前无 gate 释放，不运行测试/旧 README/准备/g3/补采外部 after。

PRD/Spec/同一 Accepted ADR 三 family reuse；派生合同 owner=Router协调/用户披露确认＋R14证据 owner，未来独立核验 owner=R14-V01/Router。本步只记合同及有限 source/tuple/包绑定，不新增产品/技术 authority、Tasks 或 runtime admission lifecycle。PermissionError具体文件 unknown、Producer151 partial/152缺席、旧Ruff/fullStrictScope=false/R11g3unknown/01两unknown及SDK日志/overflow事实保留。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 R13仅局部前置边改为新 R14-V01（原R14转历史来源），**消费方式/时点/验证方法不改仍blocked**；完整五模块check、A1–A12/AC1–AC12、P01/P02、ABI/旧caller精确debug、Forge真实Java8、W03/I05/G1/Git要求不降低。下列历次准备/状态段是原时间点历史，不能覆盖本节或唯一 Waves 当前图。

## 原六 source 退役准备（历史）

唯一同目录 [Work](work.md)、[Context](context.md)、[Plan](plan.md)、[Waves](waves.md) 延续；不新建第二tuple/Tasks。本次单一outcome是 **ready-retirement-scope** 局部披露确认准备＋静态证据，不实施任何节点，不接受Results/Todo或释放门禁。用户已明确选择“一起删除”B；未来执行仍由Router披露实际局部范围并取得当前确认，此准备不授权执行。

当前源码仍完整278 inputs；未来精确减去六source为272，path/length/SHA真实派生见 prospective-inputs.json（历史原件不可访问；见顶部保留说明），不得只改count继承g3 identity。未来Core预期3tests/3passed/0skipped/0fail/0error，不是本次实测；三个真实case及MC1.16.5/1.20.1×common/client四闭包和准确missing-ID/无成功outputs断言不降低。旧8/7/1、四空pass及Basic skip仅历史，不反写原日志/XML/JAR或方法。

Root已接受T0 R12A有限功能前置/W08来自当前Handoff inline；不是本Handler重新接受，旧missing字段仅冻结历史定义保留。g3 whole＋tuple当前树等式在本次四coord更新后即失效，六source删除后旧278/class/8-7-1/Disabled守卫也失效；g3全部23文件/22members和sealed preseal false/null均冻结，只作T0历史输入。原rawpartial/unknown/Ruff/fullStrictScope=false/R11g3unknown/01两unknown及V02末端SDK失败保留。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 **R13 blocked**：跨树消费方式/时点未接受；owner为Router＋R12A证据owner/R13消费owner。不在此设计/定案/执行，不接受B归档替代真实default或C白名单、不回滚coord/清生成物模拟T0。不反向阻断局部退役准备，也不声称R13 ready。后继完整五module checks、全A1–A12/AC1–AC12、P01/P02、ABI/旧caller精确debug、Forge双fixture真实Java8、I05/Git门禁全部保留。

### 已处理事实与authority assessment

1. `minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt` — future delete-only（当前仍存在）。
2. `minecraft-codev-core/basic-minecraft-test/build.gradle.kts` — future delete-only（当前仍存在）。
3. `minecraft-codev-core/basic-minecraft-test/settings.gradle.kts` — future delete-only（当前仍存在）。
4. `minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java` — future delete-only（当前仍存在）。
5. `minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java` — future delete-only（当前仍存在）。
6. `minecraft-codev-core/basic-minecraft-test/src/client/Test.java` — future delete-only（当前仍存在）。

复用完整评估 `codev-old-core-test-retirement-assessment-g1.jsonl:133/63788135`（提交134/aaf009b9）；其B候选正是本次明确选择。PRD reuse：Codev产品owner，`docs/prd/codev-mixin-rework.md`，空pass不构成AC/公开支持；Spec reuse：mixins＋Fabric/Forge元数据owner，`docs/spec/mixin-preapplication.md`，真实闭包与A1–A12不变；同一Accepted ADR reuse：执行/兼容及adapter边界，`docs/adr/mixin-operation-isolation.md`，隔离决策不变。update/create skip，只读同版本摘要详sources.json。

T0历史完整V02为 `codev-r12a-g3-inplace-v02-g1.jsonl:57/ccedc30b`；当前源实际只有57条，Handoff给的58成功回执不可认证，不补造。Root接受取Handoff inline。当前/派生input identities和完整来源objects在本准备sources/prospective JSON；没有通过未来test。五Vanilla owners及有效Forge具体保护由retirement-scope.json记录，Basic cache10保留。

## 既有协调合同历史（保留原scope/时点，不与当前退役范围竞争）

## 当前 R12A g3 就地修复：证据、权限和限制

唯一同目录 tuple 为 [Work](work.md)、[Context](context.md)、[Plan](plan.md)、[Waves](waves.md)。这是当前新确认范围的首次派生合同；只准备四文档，不修改 g3，不运行任何 static/capture/preseal/seal/default/helper/loader、Gradle、测试或下载，不投影 Todo/Result/运行状态、不派发或接受后继。下方旧“当前/ready/not-run/永久不动”文字保留原 scope、原时点；当前许可只由本节和唯一 Waves JSON 的新四项合同定义，不从历史 missing/not-run 推翻真实 g3 failed。

### 已确认权限与来源等级

当前 Handoff inline 用户明确确认只覆盖 g3 限定清理替换及四协调文档；精确路径已按实际16文件锁定于 [Plan](plan.md#精确就地清单与未来成员)，不逐文件再问、不广泛 glob 删除。证据不是新成功记录：四个绝对会话路径已完整解析，直接 literal Result/报告已读取；诊断 generation2 与98行审阅/59行边界评估仅支持修复合同，不证明任何新功能完成。真实 g3 failed 的两完整 receipts 保留 capture0/preseal1；01 BUILD FAILED 在 stderr（18856 bytes / 451efbe8e1aa2b7b284f87f127e7aed4442bb40e591fc382efdf905af40c810e），stdout 5264 bytes / 15565e692ef8408b235e9b94fa38ce674b3e4428f6a427969b77b415ec728bd8。F1 同版本 common/client 共享 common metadata，不伪造 client 副本。F2 当前新 phase receipt 消费漏验，需要完整实际外层调用及 source/stdin/loader/两流跨件绑定。旧 daemon/hash 解释被 generation2 直接证据否定，不洗白原失败。

重要会话来源位于 C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/：
- codev-r12a-functional-g3-g1.jsonl：实际 capture0/preseal1，未成功 seal/default；新历史归档不能回填成功。
- codev-r12a-g3-original01-guard-diagnosis-g1.jsonl：使用 generation2 完整恢复的 generation1 诊断 literal；错误 daemon/hash 解释来自 g3 功能作者的旧 Result，不是 generation1 诊断。
- codev-r12a-g3-remaining-guards-review-g1.jsonl：完整98行审阅 F0/F1/F2；不是功能成功 Result。
- codev-r12a-evidence-contract-boundary-assessment-g1.jsonl：完整59行合同评估；跨件绑定相容、default 全量回执、T0 限定；B/C 未接受。

### 现行权威 assessment（复用，无写权）

| Family/path | owning boundary / assessment | 复核 SHA256 |
|---|---|---|
| docs/prd/codev-mixin-rework.md | Codev 产品 owner；reuse，AC1–AC12/产品支持不改；update/create skip | 79f95fa457ec17fd5765b8aa266aa61a4892386d0ba0662850a75dda5b09c26c |
| docs/spec/mixin-preapplication.md | mixins 技术及 adapter owners；reuse，C1–C8/A1–A12不改；update/create skip | b65c479d8be86c750ed13d2e9d84dd6a75a1f141a7010ecc5dbc3ee535223368 |
| docs/adr/mixin-operation-isolation.md | operation 执行/发布/消费隔离 owner；同一 Accepted identity reuse；update/create skip | a641e545ece4244095d99f3e81cc84e891d975aa07b7d4657282c3b88134c4a2 |

只派生既有 Spec 行为的证据核验合同，不建立新产品 schema、支持或架构决定。出现 material authority 矛盾仅停止受影响覆盖、报告缺口，不能写 PRD/Spec/ADR。

### 真实前置与永久限制

W01/W02 已接受的完成记录保留于本 Work 的历史“目标、权威与当前状态”和 Waves 的 Router 状态块；W02 依赖 W01/I02/I03 的原 gate，不是本次重新跑出的证明。新 R01 completion 明列 R04/R05/P01/P02/R06A/R06B/R07 七基础并引用其原结果来源；R04/R05/P01/P02 raw completed、R06A/R06B raw partial 但 accepted functional completed、R07 completed 的各自有限谓词不变，不能将 raw partial 当严格全域完成。来源 refs 和实际文件存在性见 Waves confirmedG3InPlaceRepairScope.baseCompletionEvidence；既有已接受基础允许修复准备，不表示新四项已执行或 W08 已成立。

278 members 当前逐文件 length/SHA256 与原 inputs.json 相符，identity ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04；原310 member 集合/每成员 length/SHA256 与 manifest 完全相符，manifest SHA256 3529f2b57f3f85e26e43258dd3a2e84f5a8f0582765a8fe31f555829f73ceb64。这些是本次纯数据保全检查，不是执行旧 checker 或新功能。原273旧 inputs/67425历史、全部其它旧包和记录 external/env/Ruff 域仍属后继完整保全分母；本次不宣称已逐字节复核全部67425或全 Host。

原 R12 rawpartial/default1/attemptMetadataComplete=false/overallR12Complete=false、01 native exit/endUTC永久 unknown、R11g3 execution unknown、unknown Ruff/fullStrictScope=false 和会话/自动 temp 历史均保留。新阶段必须完整 native exit/UTC，不获01例外。final04三真实case/四闭包/负例仍是现有成功来源，不把四空 pass、唯一 Basic skip 或includes NO-SOURCE视为行为成功；不恢复旧selectors/八pipeline/Gradle8.2/8.6/8.8验证分母。

### 当前/后继时点边界

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 一次功能窗口尚未使用，static/独立static审阅并非功能窗口。修复完成后 tuple 字节从 capture 到独立default的 T0 验收必须冻结；新 default 不写 sealed g3，完整 receipt/raw streams 外置于正常 Harness 会话，实际重放仍必需。R13 当前消费方式不改，仍独立执行 README-default 并 fresh 五模块/24项/direct closure/ABI/双Forge Java8。后续协调投影或 R13 outputs 会破坏旧 whole+tuple 当前树等式，B 归档替代和 C 新白名单均未接受；本图只透明记录该依赖时点问题，不授权放宽，也不把没有依赖的未来问题变成当前 g3 准备阻断。

### 本次准备的执行偏差与宿主副作用

四文档合同/清单/图的准备与纯数据检查，不等于全程执行约束均无偏差。初段若干只读原生命令继承 Harness cwd E:/Projects/cloche，违反要求从启动起显式固定 Codev cwd 的约束；没有执行项目入口或写入，后续已显式设置 PowerShell 和 .NET cwd 为 E:/Projects/cloche/minecraft-codev，但不能追溯消除该偏差。失败读取、纯检查器的 null 数组处理错误与未启动的 codemode SyntaxError 不计检查通过；纠正后的纯图/字节检查单列于完整 Handler Result。

检查本调用宿主记录时一次过长诊断输出自动产生 C:/Users/WINDOWS/AppData/Local/Temp/pi-powershell-10cad8fdd2ebef9c.log（103553 bytes / SHA256 ce476562a7dc40375c3b58bbd3de34ae72de8983f8626e21fe9b87d6d43a96ea）；已完整读取并解析，保留不清理，不是主动 scratch、新证据包或 g3 功能输出。写工具固有 Markdown 诊断不作 g3 static/功能证据；没有主动 LSP/Ruff/项目核验。限定 Root namespace 的 metadata census 与 g3/310成员/278inputs/Git/三权威的内容哈希核对分别报告，不称全 Host 或全部67425历史逐字节保全。


## g3 旧 JSON/Markdown 候选准备记录（历史，原 scope/时点保留）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。用户已明确选择 JSON／Markdown 并在准备失败披露后回复“继续”；本次只同步这四份派生协调文档并在新 g3 目录生成完整候选与静态证明（历史原件不可访问；见顶部保留说明），不是 R12A 功能验收或 R13 实施，不接受 Results、不投影 Todo、不释放 gate。

- 未来 `G1-I04E-R12A` 的自有输出仅 JSON/Markdown：`core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md` 与 `verification.json`，具体 Codev 相对路径在唯一 Waves 的 `plannedEvidenceOutputs`；R13 的 `plannedEvidenceInputs` 精确消费同两文件，不再要求未来 R12A/verify.py。本次仅在新 g3 目录准备冻结候选及静态证据；根 verification.json/功能 manifest 尚未生成，未来功能 JSON/Markdown 仍归该目录所有；原 g1 六成员失败封包保留，禁止向其目录新增后代。
- 未来 README 必须保存**固定完整只读代码和短默认载入命令**：实际 cwd/ROOT 显式固定 Codev 根 `E:/Projects/cloche/minecraft-codev`，先核对 cwd 与来源可读，再从 Markdown 读取完整代码经 stdin 传入 `python -B -X utf8 -`，不将大型代码/回执拼入 argv。Harness 会话根 `E:/Projects/cloche` 仅用于文件工具的 `minecraft-codev/...`；原生命令的 `docs/...` 从 Codev 根解析，不重复前缀。保留旧原语真实来源/`__file__`/hash，不调用 legacy checker main 或冒用旧当前树等式，不创建/编辑 `.py`/`.ps1` helper。`verification.json` 绑定实际短 command/cwd/start-end UTC/nativeexit/stdout/stderr、完整 stdin 代码及来源/hash、逐项真实功能和保全断言，不能 JSON 自报 true 或只凭 helper exit0。图静态通过后尚待 Router 派发的一次 g3 只读功能窗口包含必要 preseal 与 postseal 默认重放，不重跑项目测试；本次仅冻结完整候选和静态证明，不执行任何功能入口，不消耗未来 g3 窗口。
- 所有原功能/保全谓词不变：278 inputs / `ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04`；final04 回执/XML/产物/源与工具链，8 tests / 7 pass / 1 skip / 0 failure / 0 error（四旧空 pass 与三真实 case 分列）；MC 1.16.5/1.20.1 × common/client 四条 resolve→compile→package、JAR/resource/fresh probe、准确 missing-ID cause 且无成功 outputs；02–04 元数据完整。仅 attempt01 native exit/end UTC 永久未知的局部例外保持，原 R12/审阅/contract g1 rawpartial、旧 overallR12Complete=false/默认 exit1、fullStrictScope=false/unknown Ruff/g3unknown 与全部失败仍保留，绝不豁免未来 partial、真实失败或 cache 漂移。
- 原310-member R12 seal、24-member contract seal、273旧 inputs/67425历史成员/全部旧封包/Git/已记录外部与环境身份、五新只读 test/resource owners、旧 Disabled/body/fixture/loops、Forge/生产/build/dependencies/versions/lockfile 均保全。此形式选择不改权威：Codev Mixin G1 boundary 的 PRD reuse / Spec reuse / 同一 ADR reuse，update/create skip；产品范围、Mixin 技术合同与操作隔离决策不变，不新建 Plan pair。
- 本次使用**全新独立准备窗口**检查四协调文件及新证据目录以外无新增/修改/删除；既有 `.ruff_cache/0.12.0/2552413281947668572`（41179 bytes / `1c4761e605f8796e02926a78315a6ae25eb4232f449a4653b2dbe8b63aa0e3e5`）与 `11437948984720022291`（22883 bytes / `3697f5ae39e3cfb83dfdb66b7ca475525780c4ee5ed37ef400c3c30a83756a34`）只读观察，旧 before/manifest 不重置或改写。旧 contract 写完整性失败与本新窗口结果单列；新异常仍如实 partial，不白名单/清缓存。诊断已证明 write/edit Python 可触发自动 ruff-lint，但历史每次子 PID/writer 未认证，避免该入口不洗白旧副作用。
- 唯一主动链仍为 `G1-I04E-R12A → G1-W08 → G1-I04E-R13 → W03 → I05/W04 → I06`；R12A 只需既有完整基础与 W02，W08 不等待 R13/W03 或自身 gate，R13 必须有独立完整 R12A Result 与 W08，W03/W04/I05/I06/Git 门禁不降。R12A/R13 仍 missing/not-run，全部后继未释放。R13 原五 module checks、全 A1-A12/AC1-AC12、P01/P02 direct closure、core ABI/精确旧 caller、Forge 双 fixture 真实 Java8 编译不变；旧 selectors/八 pipeline/Gradle8.2/8.6/8.8 本轮不计入且未验证，唯一 Basic Minecraft Build() skip 不计成功。

Router 已给定历史失败事实：此前两次准备为 codemode SyntaxError/No tool calls、消息提取 TypeError/无项目写入；direct-prep g1 capture nativeexit1/错误 cwd/无项目写入，均保留完整 failed Result，不提取失败命令草稿或重放。原 g1 ENAMETOOLONG 六成员失败包（历史原件不可访问；见顶部保留说明） 与已封 JSON/Markdown 静态准备（历史原件不可访问；见顶部保留说明） 只为历史来源，当前图主动输出/消费改为 g3；g2 唯一功能 preseal 已失败并精确保全九文件；本次未执行 g3、R13 或释放门禁。

本次完成谓词仅为代码+原收据证实 cwd 原因、最小完整候选/正负静态证明、四文档/唯一图与全量限定域最终保全、静态只读重放全部满足；结构候选 readiness 仅供 Router 判断，不能消费为 R12A/R13 completed 前置或实际 release。以下首回执准备记录保持原 partial 和原时点含义；当前形式及引用以本节和唯一 Waves JSON 为准。


当前完整候选/可重放静态程序/来源绑定/精确差异与回执见新 g3 README.md、PREPARATION.md、static-source.json、static-check.json、candidate-diff.md、static-manifest.json；原短载入静态准备仅作历史输入，不对新树重跑旧默认等式。

已授权 g3 静态纠错：原 g2 capture native0、唯一 preseal native1，stdin114 的 attempt02 conjunction 仅 cwd 字面值 `E:/Projects/cloche/minecraft-codev` 与 Windows `str(ROOT)` 反斜线表示不同而为 false；原 command/pid/start/exit/time 全为 true。候选仅将该 cwd 子条件改为 Windows Path 等值；真实同根正例/原会话不同根负例及非路径防线保留。原 g2 精确九文件/空 verification.json/failed、全部旧 partial/unknown 与 W02 历史接受均保留。功能范围仍要求未来 g3 实际 capture/preseal/seal/default；本次不执行、接受或释放，R13未启动。静态 manifest 只冻结候选成员，未来功能产物所有权未关闭。

## R12 首回执局部合同准备记录（历史，原 partial 保留）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。本次只同步四协调文档与自有静态准备证据（历史原件不可访问；见顶部保留说明），不实施新功能核验或 R13、不接受 Results、不投影 Todo 或释放 gate。

- 用户在详细披露后明确“接受”：**仅 G1-I04E-R12 generation1 的 attempt01 精确 native exit/endUTC 缺失，对当前主动功能前置不再要求补齐**；两值永久未知、不可补造，tool exit1 不是 native exit。原 R12 与独立审阅 rawpartial、原 completionPredicate、README/verify.py/manifest/失败字节均保留，旧 `attemptMetadataComplete=false`、`overallR12Complete=false`、默认 exit1 不变。这不是把 R12 改 completed，也不是泛化 partial 豁免。02–04 与未来真实命令仍须完整 command/cwd/UTC/native exit/stdout/stderr 绑定及功能/保全证明。
- 原 R12 封包（历史原件不可访问；见顶部保留说明）中完整绑定、已独立核对的 **attempt04** 是新功能核验的成功证据来源：native exit0，8 tests / 7 pass / 1 skip / 0 failure / 0 error；四旧空 pass 与三个新真实行为 case 分列。两 MC 版本各 common/client 四条 resolve→compile→package 闭包及 JAR/resource/fresh probe、准确 missing-ID 负例已实测；本次仅引用，不产生新验收。当前实际 **278 inputs / ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04**、原 310-member seal 与 273 旧 inputs / 67425 历史成员 / 52 Git 文件是保全锚。
- 主动链改为 **G1-I04E-R12A 单独完整只读功能核验 Result → 独立 G1-W08 gate → G1-I04E-R13 完整最终验收 → W03 → I05/W04 → I06**。R12 为历史输入，原 ID/边界/完成事实可追溯，不作 completed 前置。R12A 单一谓词是在同 278 身份及保全条件下核实 final04 三真实 case/四闭包及负例证据；一个 Handler/Result 交 Router 独立接受，不新跑 Gradle、不改五 source。W08 只等待 R12A 与 W02，不等待 R13 或 W03 release；R13 必须等待完整 R12A Result 及 W08 gate，不能用旧 partial 直接满足。当前 R12A/R13 仍 missing/not-run，W08/W03/I05/I06/Git 均未释放。
- 已确认 vanilla 分母仍是 **Gradle 9.4.0、既有 Java17、MC 1.16.5/1.20.1 × common/client**，Core 外层 Test Java11、Forge 原双 fixture 真实 Java8 编译不变。旧 selectors/八 pipeline/Gradle 8.2/8.6/8.8 **本轮不计入且未验证**；唯一 **Basic Minecraft Build()** legacy skip 不计成功，不能 filter/class disable/新增 skip。R13 原五 module checks、A1-A12/AC1-AC12 全24项、P01/P02 direct closure、core ABI/精确旧 caller、Forge 编译证明及 I05/I06/Git 门禁均不降低。
- 权威评估沿用 **PRD reuse / Spec reuse / 同一 ADR reuse；update/create skip**：产品用户成功条件、Mixin 行为/失败合同/矩阵、隔离架构不变。此例外只改本 Work 派生过程合同，不是全局治理 ADR；规范实质冲突只停止受影响部分，不自行扩大例外或改 authority。
- **fullStrictScope=false、unknown Ruff、g3unknown** 永久如实区分。Ruff 未知文件 `11437948984720022291` 当前 22883 bytes / SHA256 `3697f5ae39e3cfb83dfdb66b7ca475525780c4ee5ed37ef400c3c30a83756a34` 不在 278 inputs，writer 未获授权；不宣称全仓 scope clean。原审阅工具自动 temp 日志 `C:/Users/WINDOWS/AppData/Local/Temp/pi-powershell-f321eedebcdbd90a.log`（372703 bytes / SHA256 `36777cc6eaa4123c64fd46ec9bb55b73d7ebcc71d8dc2f530d81c700ea902db5`）不是项目/封包写入，保留不清理。本次读取超长 session 亦被工具自动 spool 到 `C:/Users/WINDOWS/AppData/Local/Temp/pi-powershell-3ab0f14b33bdd9e1.log`（162511 bytes / SHA256 `edc220cfba457014ab4bc447057c439066db95ea730f2cc685b7261026982725`）；未主动仓库外写入，副作用披露不掩盖。
- 本次静态重放发现新增未授权范围漂移 `.ruff_cache/0.12.0/2552413281947668572`（写前不存在，首次观测41179 bytes / SHA256 `1c4761e605f8796e02926a78315a6ae25eb4232f449a4653b2dbe8b63aa0e3e5`）。写工具固有Python诊断期间出现，不能据此认证writer/授权；不删除、不重置基线、不白名单。本次文档/图可核对与写入完整性分别报告，默认入口因实际越界漂移exit1，不能宣称派生准备完整。
- 新静态入口以本次写前局部基线只允许四协调差异，checksum 核对旧 seal/已封历史；不修改旧 manifest，也不在协调投影后盲跑旧 checker 当前树等式。结构候选 readiness 仅供 Router 判断，不是 R12A 功能完成、R13 执行授权或 W03 放行。

本次 settled evidence 包含当前用户明确接受、原 R12 完整 Handoff/Result 与实际工具回执、独立审阅完整 Result 和只读重放。原审阅未发现否定 final04 的具体缺陷；首记录缺口来自 runner 独占 stdout 后 Get-FileHash 失败，不可由后一次成功恢复。此依据只支持局部合同派生，非全仓严范围接受；本次不生成新核验接受记录。

| Authority family | Owning path | Assessment / reason |
| --- | --- | --- |
| PRD | `docs/prd/codev-mixin-rework.md` | reuse；G1 产品范围/成功条件不变，update/create skip |
| Spec | `docs/spec/mixin-preapplication.md` | reuse；Mixin 行为/完整矩阵与失败合同不变，局部首回执不是新增行为豁免 |
| ADR | `docs/adr/mixin-operation-isolation.md` | reuse；同一 Accepted 隔离决策不变，不另造全局 receipt ADR |

精确五新 owner 已存在、是当前 278 inputs 的只读成员；本次以及未来 R12A 均不修改它们。原 session 路径/内容 hashes、工具副作用及写前环境身份在静态证据 `before.json`，不把 session 摘要当完整 Result。

## R12基线图初始准备记录（历史）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。本轮只更新四份协调文档及 最小静态证据（历史原件不可访问；见顶部保留说明），不创建测试、不执行 Gradle/测试、不接受功能完成。

- 当前链为 **G1-I04E-R12 新基线五文件实施与聚焦验证 → G1-I04E-R13 独立最终五 module check/全24项 A/AC 验收 → W03 → I05/W04 → I06**。R12 是唯一新增候选 ready 实施项；R13 只有在 R12 完整实测 Result 及独立核验获接受后才 ready，partial 不满足前置。I05 的 scope、prerequisites、requiredEvidence 均消费同一 R13 最终树结果。W03/I05/I06/Git 仍未放行，本图不派发后继。
- 用户已接受用新当前 API vanilla 基线替换本轮旧 vanilla 证据分母：固定 **Gradle 9.4.0、既有 JDK17、MC 1.16.5/1.20.1，每版 common/client resolve→compile→package**；不是取消公开支持，也不承诺 selector 等价语义或新增 Core 支持。旧 Maven selectors、八 pipeline、Gradle 8.2/8.6/8.8 **本轮不计入且未验证**。
- 唯一 legacy skip 例外是已 Disabled 的 **Basic Minecraft Build()**，不计 vanilla 成功；原四空 pass 不构成行为证据。不允许 class disable、filter 或其他 skip。Core Test Java11 launcher、nested Gradle/编译17、Forge 原双 fixture 逐 fixture 真实 Java8 编译分层不变。
- 历史 R09 保持 raw/accepted partial、R10 保持 missing/not-run、R11 保持 raw/runtime/accepted partial；R09/R10 旧零 skip 完成谓词及原 receipt 封包仅历史，不再要求 R09 completed，不将 R11 窄停用目标改成 completed。unknown Ruff、**fullStrictScope=false**、**g3unknown**、历史失败及默认 exit1 全保留，不以分母调整解除严格范围限制。
- 当前未改动的 **273-input / 489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e** 仅历史锚。R12 创建后必须按实际成员/path/count 重绑新 identity，R13 在同一新最终树验收；未创建前不称为 278。完整五 checks、A1-A12/AC1-AC12、P01/P02 direct closure、core ABI、封存旧 caller 精确 debug 保全、原 Forge 真实闭包不可削减。
- 权威复核已 settle：PRD/Spec/同一 ADR 三 family 均 reuse，update/create 均 skip，不写 authority。具体执行越 owner、需要额外依赖/支持承诺或新阻断时停止并返回证据，不自动修复、安装 JDK、改版本/环境/Git。

### 已处理决策、来源与边界

| Family | 结论 | 当前权威 |
| --- | --- | --- |
| PRD | reuse；update/create skip | docs/prd/codev-mixin-rework.md |
| Spec | reuse；update/create skip | docs/spec/mixin-preapplication.md |
| ADR | reuse 同一 Accepted ADR；update/create skip | docs/adr/mixin-operation-isolation.md |

复用本轮已完成报告（不是新建权威/第二 Work）：
- scope：c:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-core-replacement-test-scope-g1.jsonl。
- authority：c:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-new-vanilla-baseline-authority-g1.jsonl。

R12 五个 planned outputs（相对 minecraft-codev，尚未创建，不能作为 readable input ref）：
1. minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt
2. minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts
3. minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts
4. minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java
5. minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java

冷解析必须使用新测试自有目录/cache，并禁用 build cache 复用；允许必要官方 metadata/client/server/mappings 下载和正常 outputs，不清全局/旧 cache。四条 common/client 闭包必须断言真实 task outcomes、resolver/JAR 内容、有效语言资源、fresh probe classes；不存在 ID 用 buildAndFail 检查准确 cause 与无新成功 outputs。只配置 DSL、只 build 成功、FROM-CACHE/UP-TO-DATE 或旧 XML 不替代新行为证据。

## 历史协调记录

### R11 generation4结果（原核验后状态投影）

R11已实施单方法停用并完成g4唯一新授权的原core:test；`lastResultStatus=partial`、`runtimeStatus=partial`、`acceptedCompletionStatus=partial`，不是完整completed。Router仅接受“单Basic方法停用并明确skipped”的窄目标已验证，不接受严格整体完成，不释放任何Wave门禁。本writer只更新四coord，不再运行Gradle/测试或旧verifier，不写Todo/源码/权威/证据/Git。

g4完整事实（历史原件不可访问；见顶部保留说明）、native receipt（历史原件不可访问；见顶部保留说明）与逐case/class分析（历史原件不可访问；见顶部保留说明）：PowerShell/cwd匹配的原core:test实际一次native exit0，UTC `2026-10-09T03:35:48.3806936Z–03:36:17.5186658Z`，test与compileTestKotlin实际EXECUTED；fresh五case恰4pass/1skip/0failure/0error，唯一skipped为原Basic Minecraft Build()。fresh compiled class仅该方法具有原plannedDisabledReason的Disabled；`xmlSkippedReasonProvided=false`，XML仅`<skipped/>`，不是XML输出reason。四pass方法仍为空，不证明Core行为或vanilla；原body/fixtures/8.2-8.6-8.8 loop及其他Core/Forge测试保留，skip不执行三版本循环。

Router已独立执行g4默认只读`verify.py`：实际exit1、errors=[]、`focusedChecks=true`、`fullStrictScope=false`、`detachedVerificationReceiptChecked=true`；29新sealed成员/16旧sealed/20旧R11文件/9ledger/273inputs/281protected/52Git匹配。exit1来自已披露unknown Ruff严格scope限制，不是整体checker通过或native测试失败。当前273-input identity为`489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e`；041锚仅为历史source-edit前身份。g1/g2机械失败及raw partial、g4准备KeyError均保留，g3执行历史仍unknown，不称g4首次执行或自动retry。

唯一图仍47items/7Waves；全部依赖/owner/verification/completion/release predicates不变，W07亦不释放。R09 raw/accepted partial、R10被原前置阻断且not-run、原vanilla/三版本/五check/24A-AC缺口及W03/I05/I06/Git未释放保持。PRD reuse、Spec reuse、同一ADR skip写update沿用，只读不改权威；暂停不是fixture/selector/API修复。

四coord新字节是Router核验之后已授权的状态投影；旧快照/manifest/verifier全部只读，不重封或宣称旧入口对更新树的current-tree等式仍成立。下方旧“当前/准备/ready/未实施/未运行”说明及JSON中原preparation/未来输出措辞仅保留历史定义；现时R11事实以本节与其结果字段为准，旧完成谓词保持原义。

## R11初始暂停准备记录（历史）

[Work](work.md) / [Plan](plan.md) / 唯一[Waves](waves.md)仍同owner。复用当前Handoff inline确认：用户先不修旧fixture/API、先禁用；Router ordinary披露只 `MinecraftTests.kt` 中 `Basic Minecraft Build()` 单方法JUnit `@Disabled`+具体temporary原因+必要 `org.junit.jupiter.api.Disabled` import，用户ask_response明确确认更新现图后仅改此项并实际验证。当前writer权限仍仅准备；没有授予fixture/selector/compat实验/公开API/新依赖或版本/JDK/环境权限。

| Family / owning boundary | Assessment / readable authority | 本新范围的理由 |
| --- | --- | --- |
| PRD / Codev产品owner-user | **reuse** [Active PRD](../../prd/codev-mixin-rework.md) | 暂停单一test不变产品scope或retained baseline；不证明R10/AC11、vanilla或任何缺失行为。 |
| Spec / mixins与Fabric/Forge技术验收、core测试维护 | **reuse** [Active Spec](../../spec/mixin-preapplication.md) | C1–C8/A1–A12及五check/24A-AC/原默认gate不变，skip不填Passed；selector/support matrix未改。 |
| ADR / 同一operation-isolation决定 | **skip写update** [Accepted ADR](../../adr/mixin-operation-isolation.md) | 临时annotation不改架构/classloader/operation隔离/engine/mapping决定身份。 |

完整读取三authority及独立21-claim review复用上述assessment，未发现本暂停必须修改norm或公开support matrix的矛盾，不新建/编辑权威。若实际出现material覆盖矛盾，仅加载spec-driven-development并报告受影响gap、停止受影响规划/实施，不代用户降低criteria。

只读来源：R09真实失败/Root单行（历史原件不可访问；见顶部保留说明）与独立review（历史原件不可访问；见顶部保留说明）。首nested8.2脚本19errors、8.6/8.8未到达；Core旧API物理缺席但未证唯一充分因果，Kotlinmetadata/实际注入共同阻塞未排除。当前Forge现代wiring与R03V/R07真实2/2是反证，不能当另外两过期fixture或转为core成功。没有接受selector等价规则或compat实验，均不由此写权代授。

后继source/body保全覆盖五@Test、八tasks/args/assertions/metadata/caller、完整8.2/8.6/8.8 loop、原fixture/settings、其他Core四空methods、Forge全部与rootlauncher。fresh原core:test预期恰4pass1skip0fail0error；必须逐case证明唯一Basic skipped及具体Disabled原因。四个原空方法通过不证明vanilla。新source变更才形成after新273identity，当前041锚仅before保全，不继承旧XML/PASS。

当前唯一准备结果是四份派生协调文档与独立静态证据（历史原件不可访问；见顶部保留说明）；不实施源码或执行Gradle/Java/tests，不写Todo、不委派/接受/释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`，Root已存在launcher1.9.0-M1；原R09 raw/accepted **partial**（5tests/1failure/0error/0skip）、R10 **waiting/not-run**、W03/I05/I06/Git未ready保持。新暂停完成也不释放这些原gates，不将原五fresh全部pass/旧selector/三版本谓词降为skip通过；vanilla仍gap，`fullStrictScope=false`与unknown Ruff历史保持。

仅新增一个暂停item `G1-I04E-R11` / `VG1-POST-10`，置于同图独立 `G1-W07`（前置原W02 gate），不是第二Plan/graph。原46items/6Waves保留，现47items/7Waves。R07及必要既有accepted基础和W01/W02 gate是completion前置；已验证R09 Root/source/CP失败只为readonly证据，不要求R09completed，不要求先修旧fixture。静态structurally-ready不是native完成或Router放行；当前唯一新可readyitem为R11，所有执行细节只在[Waves](waves.md)。

旧experimental/fixture repair方向明确 **deferred**；compatibility proposal **cancel-proposal（从未启动）**，被本暂停方向取代，不将用户取消记为completed，不删旧失败/身份。原root单行许可及旧writerPermission仅标注历史preparation，不给当前writer源码权限；后继仅R11该方法annotation/import例外，其他host/fixture/Forge/root保持readonly。以下所有旧“当前/最新/ready/宿主只读/未运行”文字按原记录当时理解，不与本首节竞争当前范围；旧图原完成谓词仍有效，不能从历史文字放行。

## R11准备前协调记录（历史）

下文完整旧记录保留其原义；当前实施许可仅以本首节和新R11 scope为准，原norm/原completion与失败仍不变。

## 当前精确用户许可、query证据与authority复用

用户最新ask明确选择“授权查询及有界候选修复/重验”，本轮派生许可标识 `D-G1-JUNIT-LAUNCHER-CONTINUATION`。原图准备 raw partial/strictscope 失败保留。R09 generation1 已实施并消费完整 Result，Router 独立只读核验 exit1/errors=[]/54 members/receiptChecked=true；唯一 launcher1.9.0-M1 单行生效，其他272 inputs、52 Git及旧包匹配。原 core:test fresh 5 tests/1 failure/0 errors/0 skipped，4通过均为原空方法；Basic Minecraft Build 在首个 Gradle8.2 阶段出现19条脚本编译错误，8.6/8.8未到达。首JUnit discovery边界已实际越过，原regression不足completed：R09 raw/accepted状态partial，R10未ready，W03/I05/Git未释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`；metadata/worker/core失败证据见R09（历史原件不可访问；见顶部保留说明）。unknown Ruff的fullStrictScope=false与旧Bash/PATH失败保持；后续四coord变更是父协调投影，不能改旧冻结快照或重放其current-tree等式。

原精确许可仍仅 `E:/Projects/cloche/minecraft-codev/build.gradle.kts` 共享测试dependencies新增一条 `testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.0-M1")`；原API/engine、其他coordinates/owner/断言/fixture/算法/五fork与Git边界保持。未来native验证允许正常获取已声明依赖及原源码实际选择的TestKit 8.2/8.6/8.8，不能换版本、安装JDK或改全局配置。

原R08 generation1/2仍historical-only **partial**，原默认exit1/2367输出/2373+12与receipt-bound extra2保持；62旧fresh tests不证明core executor通过，24行/direct/coreABI/逐fixture compiler仍缺闭包。首LauncherFactory机制 **supported、非唯一cause**；诊断/review raw partial与非UTF8编码恢复、167/176/53历史保持。PID151144属性支持core Java11，不等于确定Executor20映射；封存Gradle9.4文档示例为JUnit5.7.1，非JUnit6。

已完成native query三尝试真实exit **1/1/0**：Windows quoting未启动Gradle；root跨project无exclusive lock；仅临时query owner纠正后离线成功。Gradle9.4只调两个metadata task，API/engine5.9.0-M1、Platform engine/commons1.9.0-M1/BOM5.9.0-M1，无launcher/unresolved/artifactfailure。configuration files45/46与实际Test CP51/52皆无Factory；JavaLauncher JBR11.0.16与GradleVM Microsoft17.0.19分层。候选缓存JAR最大major53只是静态匹配，不证明worker可见/discovery/testpass。query raw Result **partial**；本writer在新增目录/文档前独立重跑默认只读入口exit1、errors=[]、receiptChecked=true；unknown Ruff严格scope失败，metadata成功不接受G1。

保全锚为273inputs `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`、52Git、query63members/53sources及旧176/53/2373/12。query实测正常generated仅 `build/reports/problems/problems-report.html` 的具体旧新hash；不是build目录allowlist。未知 `.ruff_cache/0.12.0/8623379424694068166` 及两review历史路径均未归属、未授权，后续新漂移继续逐path/length/hash披露；`fullStrictScope=false`、`functionalGatePassed=false`、W03/I05/I06/Git未释放。新增协调字节不重放旧current-inventory/default equality、不重封父包。

| Family / owning boundary | Assessment / readable authority | 本范围理由与条件 |
| --- | --- | --- |
| PRD / Codev产品owner-user | **reuse** [Active PRD](../../prd/codev-mixin-rework.md) | test-only restoration不改变生产能力/G1 scope；R1–R10与全部AC1–AC12保持。 |
| Spec / mixins及Fabric/Forge行为边界、core测试维护 | **reuse** [Active Spec](../../spec/mixin-preapplication.md) | root testRuntimeOnly不改变C1–C8行为/公开artifact API；全部A1–A12与必要直接闭包不降低。 |
| ADR / 同一operation-isolation决定 | **reuse** [Accepted ADR](../../adr/mixin-operation-isolation.md) | 不改变操作域/classloader/引擎/mapping决策身份；未发现query强制其他版本或owner。 |
| 新authority/产品/架构承诺 | **skip** | 无新增语义，三authority只读；若实际发现material覆盖问题则加载spec-driven-development并停止受影响规划/实施，返回证据，不作新accepted决定或改authority。 |

复用Router本Handoff逐family已可见assessment并完整读三authority核对，不是新接受决定。许可来源仅本Handoff inline当前ask答案，不虚构独立用户回执路径或时间；原“仅只读diagnosis/no dependency”限制只对此root单行与对应native验证解除。R09需新真实worker/discovery/原五测试；原第五Basic Minecraft Build源码依次8.2/8.6/8.8，不得避开潜在后续fixture失败。includes无测试源不生成sentinel、不算fresh testpass。R10需同最终273identity重新闭合五check/全部24row、P01/P02 direct、coreABI/封存旧caller及原Forge两fixture逐fixtureJava8 compiler。

R09/R10未运行、未接受；raw query/review/R08及旧strict失败不改为passed。现有accepted R06A/R06B功能事实和R07/P01/P02维持，旧缺失/ready标题以下均按记录当时理解。静态准备封包（历史原件不可访问；见顶部保留说明）逐member/source核验当前保存字节；四coordination原source哈希由before与query source-copies绑定，文档更新后不能把旧默认入口当新树校验。

## R09准备前协调记录（历史）

以下保留原协调记录/原义及其当时“当前/最新/ready/missing”措辞，不是现时执行状态或新增许可；当前scope/状态以上节为准，唯一执行依赖以Waves当前JSON为准。原Result/完成谓词/失败证据不改写。

派生 Context；入口为 [Work](work.md)，实施策略为 [Plan](plan.md)，唯一执行图为 [Waves](waves.md)。本文件只处理规划所需证据，不增加产品或技术权威。初始 Context 准备未执行任何构建、机制复现或实现验收；后续实际 Result 由下列当前记录投影。

## R08 当前已核验 partial

R08 generation1/2 的完整 Result 均为 **partial**；Router 独立重跑 verification-recovery/verify.py exit0，原2373封存成员、12补充成员、两final-receipt日志、273输入/authority/历史/Git/环境与临时属性保全通过。原verify.py成员集exit1和2367-member旧日志保留，不改旧seal。当前identity仍为 `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`。实际mixins/Fabric/Forge check通过；core:test不能加载JUnit Platform，core/includes check未到达，overall exit1；15 suites/62 fresh tests零failure/error/skipped不包含core执行器成功。24行partial、direct/coreABI/逐fixture Java8配对仍未闭合，functionalGatePassed=false、fullStrictScope=false，W03/I05/I06/Git不释放。接下来仅只读诊断JUnit运行时加载边界，不授新增依赖/源码/config权限，不运行Gradle或自动重试。证据见R08（历史原件不可访问；见顶部保留说明）与补充校验（历史原件不可访问；见顶部保留说明）。

## R07 已接受实现与 Java8 历史证据

R07 generation1完整Result completed已消费；Router独立默认只读verification.py exit0：单一nested --rerun-tasks diff，原双TestKit fresh2/2、两个compileJava/fixture jar实际EXECUTED且各自Java8 worker编译栈/工具身份/父TestExecutor/重建窗口绑定，major52及compiled class/JAR逐字节一致。临时generated JDK8发现属性finally精确恢复原不存在状态，继承环境受限摘要/outer属性保持；其他272inputs、64297历史文件和Git保持。273-input identity `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`；89新成员保全。内部forge-patch-8/mappings-3/remap-4命中自有缓存，不宣称这些内部action重做；unknown Ruff漂移披露，fullStrictScope=false保留。R07 accepted completed，R08成为唯一runtime-ready节点；新树终验仍须fresh五check/全A-AC，不能继承旧XML/P01/P02/PASS，W03/I05/Git不释放。 证据见R07（历史原件不可访问；见顶部保留说明）及其compiler-bindings.json；只读jcmd采样存选定compiler栈帧而非完整线程dump，不公开未知property/env。原两fixture/Java/断言/版本/工具链/classpath/算法保持；没有新source写权。

## R06B 注解生成行号效果的限定澄清

R06B generation1 raw Result及原默认verifier exit1保持partial，原strictDebug=false与strictScope=false均未改写。Router独立复现新审阅入口exit0，13审阅成员摘要匹配：158对class，八类28methods/166项LNT恰+2、逐table count/order/BCI不变，其余150类行号保持，rawCodePayloadDifferences=0，runtime/API/metadata归一化等价158且module bytes相同。PRD/Spec/同一ADR reuse，无需新权威或同范围重复确认。仅补齐已授权四个两行file注解的精确生成调试效果；stacktrace行号/调试定位可观察变化如实披露，不能称class byte equality。Ruff未知writer漂移仍strict失败、不清理/恢复/授权。Router按澄清后的功能谓词接受R06B完成以接续R07，不宣称strict scope或G1通过；273-input identity `477d38dd2e0b4604d4f67a04c5e84fc5b6e72b61ccbbd0c7ac2f7c9056fdeb00`，原2024成员及13新审阅成员保全。R07 ready，R08/W03/I05仍等待。 依据独立覆盖评估（历史原件已删除；原路径 `evidence/g1-implementation/r06b-debug-contract-review/report.md`）和其`reproduce.py`，八类166项逐条绑定及可复现检查见唯一Waves/审阅记录。这是派生完成清单漏项澄清，不增加source owner、fixture、算法、API承诺或Ruff写权。下方R06A当前锚和初次missing叙述保留为历史。

## V02 generation4 后的已授权最小补救范围

R06A generation1完整Result与Router独立verifier exit1一致：32内容finding消除、14owner变化/259其余inputs不变、三filename-only字节保全、原生core lint实际exit1仅七原filename、独立core compile实际exit0、PSI17/17等价、277成员与旧包/Git保全。当前273input identity `484b2a9b790e5559405b25700890b971e9564b1a34b6efcce60a753d87772b53`。未知writer的`.ruff_cache/0.12.0/8217250146170573555`变化使strictScope失败，raw Result保留partial，不改证据、不清缓存。Router只接受R06A功能完成谓词，允许R06B接续；不宣称strict范围/完整core lint/G1通过。当前前置实现输入锚见R06A证据（历史原件不可访问；见顶部保留说明）与其after-final-3.json，初始V02 frozen仅历史。

状态：**已授权，R06A及精确调试契约澄清后的R06B功能完成已接受，两个raw partial/strict失败保留；R07已独立核验completed，R08 ready**。下文初始未实施/准备锚为历史，当前以Waves Router记录为准。用户最新选择“授权两项最小扩展（推荐）”，记为 `D-G1-CORE-JAVA8-CONTINUATION`。仅解除下列 core17/7destination/4JvmName 与单一 nested argv 的原只读限制，其他 owner 与最终门禁保持。两项只读完整 Result 为 `codev-v02-core-lint-scope-diagnosis` generation1 与 `codev-v02-java8-fresh-diagnosis` generation1。Router 已核对 273 个 frozen.inputs 当前长度/SHA 无漂移，四个需保全的 facade class 摘要与 frozen.generated 匹配，无活动 wrapper/test/fixture。独立 V02 verifier exit0 只证明 continuation-g3 partial 封包可信。

39 项 core lint 中，38 项对应既有源码形态，1 项为 R01 新增 getter 注解的换行；R05 只增类声明/import并移行。没有运行 HEAD 基线 lint。原 R02 的27个 Fabric/Forge 样式 owner 与这17个 core文件交集为0；只有 getter相邻等价换行在原共享维护实质边界内，不能据此给整文件/目录写权。

已授权 R06A/R06B 合计冻结范围（旧复合R06保留历史）：`minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/` 下列17原文件，仅已报告的 imports/标点/缩进/换行及七项 filename 修复；保留 getter/cache声明、算法、短路顺序、类型/函数/package、资源字面值、五fork值及现有依赖。

| 目录 | 精确原文件 |
| --- | --- |
| resolve/bundled | BundledClientJarSplitter.kt |
| resolve/legacy | LegacyJarSplitter.kt、ServerFixer.kt |
| resolve | getMinecraftFile.kt、MinecraftMarker.kt、MinecraftVersionMetadata.kt、ServerExtractionState.kt、VanillaSplittingState.kt |
| task | AddClientSideAnnotations.kt |
| utils | build-utils.kt、Cache.kt、extension.kt、Hash.kt、isUnobfuscatedVersion.kt、ManifestSignatureRemover.kt、path-utils.kt、source-set-helpers.kt |

新增 destination ownership 仅下面七路径；四项 `@file:JvmName` 是明确授权的 ABI 保全措施，必须按表明列，不能隐称纯空白变化。所有顶层函数/默认参数桥与已编译 caller 的链接必须验证。

| 同目录原文件 → 新文件 | 固定原 facade 的措施 |
| --- | --- |
| getMinecraftFile.kt → GetMinecraftFile.kt | 默认 GetMinecraftFileKt，编译核对 |
| ServerExtractionState.kt → ServerExtractionResult.kt | @file:JvmName("ServerExtractionStateKt") |
| build-utils.kt → BuildUtils.kt | @file:JvmName("Build_utilsKt") |
| extension.kt → Extension.kt | 默认 ExtensionKt，编译核对 |
| isUnobfuscatedVersion.kt → IsUnobfuscatedVersion.kt | 默认 IsUnobfuscatedVersionKt，编译核对 |
| path-utils.kt → PathUtils.kt | @file:JvmName("Path_utilsKt") |
| source-set-helpers.kt → SourceSetHelpers.kt | @file:JvmName("Source_set_helpersKt") |

Windows case-only rename 使用唯一临时路径两步实体 rename，核对真实 basename/唯一 casefold映射；不采用 write-new/delete-old，不改 index/Git配置。在任何 compile 前保存七 facade/class、JAR、API descriptors、默认参数桥、Kotlin 可见 API 与旧 caller 字节及来源/hash；以新 full core compile 与 core JAR/type resolution 核对上述 API，并以保留的旧 caller/binary links 验证，不重编 caller 掩盖破坏。case-only 三项也逐一核对真实 basename/唯一 casefold 映射。允许并单列 SourceFile/SMAP/source-JAR 路径变化；其余 annotations、getter/cache声明、providers、literals、算法、版本/deps 全保留。

已授权 R07 精确范围：只在 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt` 的原 nested `withArguments("jar", "printCompileClasspath", "-s")` 增加 `"--rerun-tasks"`。不改两个 fixture、原Java源、版本/toolchain/classpath、断言、patch/remap或生产实现。外层 rerun 不传入 nested argv 是已观察事实；精确Gradle历史快照判定原因未采集，其他临时方案也未穷尽。不清共享缓存。保持原Java17宿主/现存JDK8以及generated TestKit home属性finally精确恢复，要求原双TestKit2/2、nested compileJava真实执行和与fixture绑定的Java8 compiler/toolchain记录，重开JAR/classes验证major52与成员。

本次只准备唯一执行图：R06A（32条内容规则）→ R06B（七命名/API保全）→ R07（原nested argv及真实Java8）→ R08（同树fresh五check/全A-AC）。R06A前置P02 completed与当前精确许可，native core lint预期exit1恰余七原filename且无其他违规，独立core compile exit0和语义等价；R06B前置R06A completed，完整core compile/JAR/core+includes validatePlugins/core lint均exit0及旧binary链接。两诊断/V02 partial和旧R06 blocked仅历史，不作为completed前置；细节以唯一Waves与下方分解节为准。原CLI串行、GRADLE_OPTS before-copy合并/保密、generated TestKit finally精确恢复及未知owner只读边界保持。

此次许可不改变产品能力、隔离决策或技术行为契约；受影响 authority 逐 family reuse 见下表。若 ABI/运行契约不能保全则阻断受影响范围并重新评估，不改权威降低门槛。Plan 的 shared 其余只读及原宿主只读仅对上述精确 owners/effects 解除；诊断与文档准备不释放 W03/I05/I06，也不授予 stage/commit/merge/push/publish。

| Family / owning boundary | Assessment / readable authority | 当前许可的复用理由 |
| --- | --- | --- |
| PRD / Codev产品owner-user | **reuse** [Active PRD](../../prd/codev-mixin-rework.md) R1/R10、AC1/AC11及完整AC | R06A保持语义、R06B保持旧caller/API，R07只强制原nested编译观察；恢复兼容证据，不增加产品能力/fixture/支持矩阵。 |
| Spec / core兼容边界及Forge TestKit、G1全矩阵 | **reuse** [Active Spec](../../spec/mixin-preapplication.md) C1–C8/A1–A12与retained baseline | 明列旧facade/桥/Kotlin API与真实Java8 compiler保持原契约；major52/JAR只作一致性，全五check仍须新树终验。 |
| ADR / 同一operation-isolation及Forge兼容边界 | **reuse** [Accepted ADR](../../adr/mixin-operation-isolation.md) | 样式/旧facade保全与nested rerun不改变隔离、引擎、映射/缓存架构或决定身份。 |
| DDD / 原领域边界 | **reuse** [Context map](../../../CONTEXT-MAP.md)及既有naming/embedding/launches | 原术语、owner与能力边界不变，文档只读复用。 |
| 新authority、缓存语义、G2–G5、治理/发布 | **skip** | 没有新增产品/规范/架构承诺；未知owner、deps/五fork/Git仍只读。 |

两诊断来源的完整只读 Result 已由 Router 消费；本 Handoff 的 inline settled evidence 是精确 provenance，不造不存在的诊断文件路径。`frozen.json` 当前273 inputs identity `373f897c8fcce3487fb85cb1a8566326aa4a557dfd42536248faa460fd097e9b` 与四旧facade摘要是保全锚。此次 pre-edit 四文档已含 Router 部分编辑，新协调变更不与旧 frozen coordination 强求相同，也不冒充生产 input 漂移。默认静态入口与历史成员核查见 新证据（历史原件不可访问；见顶部保留说明）。R06A/R06B/R07/R08 均 missing/未实施；V02 latest partial 为 historical-only，I05/W03 当前终验前置仅指 R08。

## 当前依据与权威评估

| Family | Assessment / owner | 可读依据与理由 |
| --- | --- | --- |
| PRD | **reuse**；Codev 产品 owner/user | [codev-mixin-rework](../../prd/codev-mixin-rework.md) 为 Active；R1–R10 / AC1–AC12 完整覆盖本轮 G1、兼容入口和保守失败边界。未采用更广差异提案。 |
| Spec | **reuse**；mixins，Fabric/Forge 元数据边界 | [mixin-preapplication](../../spec/mixin-preapplication.md) 为 Active；C1–C8 / A1–A12 覆盖生命周期、记录、选择性安全、映射与兼容。公共名字和紧凑编码有意留给实现，并非缺失规范。 |
| ADR | **reuse**；mixins 执行与兼容边界，Fabric/Forge 适配边界 | [mixin-operation-isolation](../../adr/mixin-operation-isolation.md) 为 Accepted；复用同一决策身份、每操作 classloader、版本绑定适配和 engine remapper chain，不新建生命周期。 |
| DDD | **reuse**；现有领域边界 | [Context map](../../../CONTEXT-MAP.md) 及其中 naming/embedding/launches Context 继续提供术语；预应用不等于 Loader runtime，namespace 不等于 package 或 refmap context。不编辑。 |
| 更广产品、架构或技术规范 | **skip** | [差异提案](../../proposals/codev-difference-rework.md) 仍为 Proposed；G2–G5、legacy Loader、发布、跨仓库改线没有本轮授权或新增承诺。 |
| legacy-forge 构建维护选择 | **skip：已完成的维护，保留历史边界** | 初次规划时 blocked；随后用户选择删除失效 include，I03 completed。本次只读 settings 已无该 include，不再待选择，也不恢复 Loader。 |

权威采用来自 supplied Router 结果 `codev-mixin-align-adopted-authority-state g1`，不是逐条用户政策确认，也不证明实现就绪。现读文档中“尚无 Work/Plan/Waves”的陈述属于此前维护范围的历史观察；本次新增派生文件不更改这些权威。没有发现本轮需要另改 PRD、Spec 或 ADR 的规范冲突；若后续机制不能满足 C4/C5，应报告该局部架构缺口，不能改写规范以宣布通过。模块边界不是新任命的人员 owner。

## Post-V01当前权威与必要闭包

本节保留 Post-V01 图准备时的派生评估/事实与已完成后继的历史来源；当前许可、273-input锚和终验以本文件首节及 Waves 为准。后文旧 check/patch 维护准备的版本/inputs和missing说明均属历史，不是现有树状态。准确完整 Result状态仍见 [Waves](waves.md)。本 Handler只主动更新四coordination与新静态证据，不执行生产/测试 runtime、下载、缓存清理/改写、Git或权威操作；全仓核验另发现已有 Ruff cache 的非预期漂移，实际失败边界见本节末尾和新证据。

| Family / owner | 处置 / 可读依据 | 原义与本轮边界 |
| --- | --- | --- |
| PRD / 产品 owner-user | **reuse** [Active PRD](../../prd/codev-mixin-rework.md) R1–R10/AC1–AC12 | G1用户预期、普通旧API、保守消费与baseline不变。Scope/R10/AC11要求 touched AT/patch/nested ordinary能力保持；不是完整AT或Loader支持矩阵。AC1要求旧注册/执行，需实际旧Gradle注册而非只direct调用。 |
| Spec / mixins及Fabric/Forge适配 | **reuse** [Active Spec](../../spec/mixin-preapplication.md) C1–C8/A1–A12 | A1确实要求Register and execute old no-mapping Mixin and legacy StripMixins；A6 exact、A7双目标完整consumer、A8第三方 selective显式失败而legacy可用、A11 real provider链原义成立。Authority and boundary明确保留Forge AT/patch及nested；不新增nested递归/identity政策。 |
| ADR / 同一operation-isolation | **reuse** [Accepted ADR](../../adr/mixin-operation-isolation.md) | 每操作classloader、coherent pinned engine与engine-chain remapper不变。须采集实际operation域来源/失败诊断；外层ASM9.9.1 metadata不能证明child ASM9.6相干或不相干，当前没有证据授权升级/替换引擎。 |
| DDD / 现有领域边界 | **reuse**现有Context map/naming/embedding/launches，不写 | 术语不变；namespace≠package/refmap context；预应用≠Loader runtime。 |
| 新缓存语义/支持矩阵/G2–G5/发布/治理 | **skip** | 三class禁缓存默认声明是精确授权维护，不新增可重定位Gradle-cache承诺、不改变CachedMinecraftTask子类自身cache策略；无新权威生命周期。 |

本轮Bundle是一份完整派生文档结果，authority reuse可继续；原文件完整读取，未发现需要SDD处理的实质规范缺口。audit中A1和AT/nested条件措辞已回原Spec/PRD确定以上边界，不自行新设或删去义务。后继若实际入口/诊断/规范出现实质矛盾，只将受影响覆盖准确blocked；不阻止三class维护准备，也不得弱化原契约或取得未知生产owner。

| 本树模块 | 当前 fork 值（只读保留；不再bump） |
| --- | --- |
| mixins | `0.1.0+terrarium.0.6.0` |
| fabric | `0.1.0+terrarium.0.7.2` |
| forge | `0.1.0+terrarium.0.9.2` |
| core | `0.1.0+terrarium.0.7.2` |
| includes | `0.1.0+terrarium.0.6.5` |

R03P/R03V/R04 completed沿既有完整Results保留，不回退重做；原V01 partial/failed provenance保留。Post-V01原图准备当时只读实现inputs为272，identity `8595111476c330a06a271adf72e16ef306ad225daa7c11984a880c1ab2e4773a`。当时新增R05/P01/P02/V02 missing（现R05/P01/P02 completed、V02 latest partial历史保留）；W03–W06/I05/I06未释放。下一实际实现/test树必然形成新的inputs身份，V02必须绑定最终实际identity，不强求未来仍272。

三声明诊断（历史原件不可访问；见顶部保留说明）已定位class自身cache声明缺失：Gradle逐类型lookup且注解不继承。仅三精确owner的import/类注解已获最新用户授权；前两because为`Relocatable Gradle build-cache semantics have not been verified`，base为`Base task type configures the Minecraft cache but does not define a complete cacheable operation`。现有getter/actions/ABI/provider/子类缓存/五fork与dependencies/root/settings保持，runs DownloadAssets仍out-of-scope，不能以base声明假称解决它。实际core/includes validator rerun exit0和原生`[]`是后继R05谓词。

矩阵audit（历史原件不可访问；见顶部保留说明）归纳5supported/7partial，是历史证据覆盖而非本树完整验收。实际必要闭包按真实owner只分producer/operation P01与consumer/provider/baseline P02：真实FROM-CACHE恢复到fresh consumer；same-JVM custom remapper A到no-remapper B；exact Foo/FooExtra/跨package保持；two-target all-success真实consumer删除；fresh Fabric服务/provider、第三方拒绝且同handler legacy成功；child engine/ASM provenance与unsupported bytecode/config/injector无success；A1旧注册和AT/nested原能力。可读source/现有method与精确owners见[Waves](waves.md#post-v01最小串行直接补证与独立终验)，复用closure与五check/全矩阵的独立Result见[Plan](plan.md#post-v01最小串行策略)。

P02原图准备时唯一新baseline test路径不存在，Waves当时明确planned output；现该文件已由P02创建，当前只读，未授权新建baseline owner；其他都为现有可读test/resource owners。沿真实现存TransformerProcessor入口观察非空AT效果并与cleanup/既有task wiring和最终原双fixture绑定；nested只证明payload及现有list/remove/cleanup语义保持，不改包含或遍历政策。若测试引出未知生产修复/依赖问题，该项blocked且具体报告，不能把test授权当成source泛写许可。

V01 README关于Fabric/Forge validator FROM-CACHE与native log冲突，只在此披露native log优先；旧README/包/manifest不编辑或重封。外层resolved ASM、旧PASS、XML、UP-TO-DATE与manifest不能替代当前required runtime。独立post-v01-repair-plan（历史原件不可访问；见顶部保留说明）保全四before、272identity、旧19包7901members/V011995members/两诊断99+11与Git/index；其静态图已独立通过，但完整全仓保全的实际 `--after` exit1：已有 `.ruff_cache/0.12.0/7846417971863111690` 发生非预期变化，只四协调文件变化的谓词不满足，详见 scope-failure（历史原件不可访问；见顶部保留说明）。未清理/恢复该只读缓存，也不修改 verifier 允许面；完整文档准备尚未验收，默认严格只读核验如实保留失败，任何 runtime gate 均未通过。

## 本次维护范围与逐 family 复用核对

本节保留 check-repair-plan 当时的历史评估/许可；后文 Forge patch 准备也属已完成历史。本轮当前边界以新增“Post-V01当前权威与必要闭包”节为准。此前 supplied 用户 ask_response 已确认“授权最小扩展（推荐）”，解除先前 core/includes owner 只读阻断，不需重复请求同范围授权。该许可用于后续最小实施；**上一轮 Handler 只写四份派生协调文档及新 check-repair-plan 静态证据**，没有 Gradle、formatter、tests、实际修复、Todo、委派、接受或 Wave 释放。

- **PRD reuse**：产品 owner/user 的 Active `docs/prd/codev-mixin-rework.md` R1/R9/R10、AC11 及完整 AC1–AC12，保留普通兼容、检查与 touched-path patch/nested-JAR 基线；两诊断是恢复现有任务/fixture 而非新产品能力。
- **Spec reuse**：mixins/Fabric/Forge 的 Active `docs/spec/mixin-preapplication.md` C1–C3、A11、完整 A1–A12 与 baseline 边界继续适用；完整 changed-module check 和 fork 版本协调复用既有 Plan gate/coordination defaults，并按本次授权扩展实际维护模块。Spec 未逐值规定 core/includes fork 值，不能把本次用户许可或派生图冒充新增规范。getter normalization 仅恢复已存在的输入追踪，不启用缓存。
- **ADR reuse**：同一 Accepted `docs/adr/mixin-operation-isolation.md` 的隔离、engine lock、无行为扩展与 revisit 边界未被脚本解析/注解/格式问题推翻；shared ABI/includes identity/G3/G4/G5 仍不变。维护例外是明确授权的实施范围，不是新架构生命周期。
- 三份权威本次完整读取，无新规范矛盾，均不写；可读输入/hash 由 静态证据（历史原件不可访问；见顶部保留说明）绑定。若后续暴露超出恢复范围的语义/规范冲突，受影响项 blocked，由 Router 处理，不偷改权威。

六任务诊断（历史原件不可访问；见顶部保留说明）的 `issues.md`、`task-diagnostics.json` 和 `summary.json` 给出 11 个 validation ERROR、94 条 lint、27 个文件。repair-boundary 使用 README 的“最小后继修复边界”索引，目录没有单独同名文件。共享例外严格为 `IncludesJar.kt.input` → NONE、`IncludedJarInfo.kt.file` → NAME_ONLY、`core/task/AddClientSideAnnotations.kt.directory` → 保守 ABSOLUTE；仅这些 getter 注解及必要 imports/相邻等价格式，不允许泛写 shared 目录。Forge `GenerateMcpToSrg.mappings` → NONE，五个具体 task 显式 DisableCachingByDefault；不使用 Internal/CompileClasspath 掩盖输入，不声明可重定位缓存支持。

lint 只允许该 27 文件的诊断规则及必要语义等价格式；`setupForgeRunsIntegration.kt` → `SetupForgeRunsIntegration.kt` 的 old/new owner 在 Waves 明列，保留 package/function/API/行为，先核对硬编码文件路径消费者。Forge 最小 fixture owner 仅两个既有 build.gradle.kts，接现存 ResolvePatchedMinecraft/provider/RemapTask，不恢复旧生产 DSL。Forge 因果诊断（历史原件不可访问；见顶部保留说明）保留当前/对齐基线 3/7 缺符号、52 同名 JAR、宿主控制和隔离限制；原两项 TestKit 必须实际 2/2，保留版本、Java/classpath、patch/remap/JAR/compileJava 断言。诊断 completed 不等于修复或 A11/AC11 通过。

| 模块 | check-repair-plan 当时值（历史） | 当时已确认后续目标 / 理由 |
| --- | --- | --- |
| mixins | `0.1.0+terrarium.0.6.0` | 保留 I04D 已接受值 |
| fabric | `0.1.0+terrarium.0.7.2` | 保留 I04D 已接受值 |
| forge | `0.1.0+terrarium.0.9.2` | 保留 I04D 已接受值 |
| core | `0.7.2` | 注解 owner 实际维护后仅 `0.1.0+terrarium.0.7.2` |
| includes | `0.6.5` | 注解 owners 实际维护后仅 `0.1.0+terrarium.0.6.5` |

最终 gate 同树五模块 check + 全 A1–A12/AC1–AC12 + inputs/cache/legacy/metadata/mapping 闭环，不传递旧树 PASS。I04E generation 1 partial 与旧 final 只读；新修复和验证各独立 evidence/Result，不能依赖旧 partial 的 completed。只报告结构上的下一 ready 项，不推进；W03–W06/I05–I07 未释放，D-GIT-INTEGRATE 未授权。branch `g1/mixin-rework`、HEAD/main `30d1d3d22267477db3275cb849e8692ada0f74de`、index 只读保全。

## 最小Forge patch恢复的受影响权威评估

最新 supplied 用户明确选择“授权最小生产修复（推荐）”。此前“仅两个 fixture，不改 patch/remap 算法”的限制仅对下面两个精确 production owner 解除；其他生产路径仍不取得写权。此前 shared 最小维护许可继续有效。**本次只更新 Work/Context/Plan/Waves 和新 `patch-repair-plan/**` 文档图证据**；不执行修复、Java/Gradle/tests、下载、缓存操作、Todo、委派、Result 接受或 Wave 释放。

| Family | Assessment / owning boundary / 可读路径 | 受影响部分的理由 |
| --- | --- | --- |
| PRD | **reuse**；Codev 产品 owner/user；[Active PRD](../../prd/codev-mixin-rework.md) | Scope 的 retained Forge patch/userdev/AT/nested-JAR baseline、R10/AC11 已要求 touched paths 保持 ordinary compatibility；恢复缺失未修改 class 的同 namespace 闭包没有新支持矩阵或产品能力。 |
| Spec | **reuse**；mixins/Fabric/Forge；[Active Spec](../../spec/mixin-preapplication.md) | Authority and boundary 明确保留 Forge patch/AT/nested baseline；本次纠正 patch→后续 rename/mcinject 的输入完整性，未改变 C1–C8、mapping 方向或 A1–A12。Spec 不要求晚期按旧 namespace 补齐；没有发现实质规范矛盾或缺失。 |
| ADR | **reuse**；同一 mixin-operation-isolation 决策，Forge 兼容边界；[Accepted ADR](../../adr/mixin-operation-isolation.md) | 既有 retained baseline 与“不新增 G3 cache redesign”边界适用；本 task 的版本域失效复用现有机制，不新建缓存/锁/架构生命周期，不触发隔离或 engine revisit。 |
| 新权威 / G2–G5 / 全 Forge 认证 | **skip**；本次未采用 | 无新产品、架构或规范行为；不把维护许可、静态图或既有 remapped 成功冒充权威、完整矩阵或扩展认证。 |

三份 authority 本次完整读取，仅重新评估上表受影响部分；不改权威。若后续修复必须改变 namespace 政策、工具版本、AT/nested 语义或超出两个 owner，受影响结果应准确 blocked，由 Router 处理，不能隐式扩大授权。

已接受 basic patch 诊断（历史原件不可访问；见顶部保留说明）的根因是 binarypatch subset 未含 `bn.class`；basic `notchObf=true` 的 rename 已将 MinecraftServer 的引用改为 ICommandSender，ResolvePatchedMinecraft 的晚期 clean 填充却补回 notch 定义。当前真实源码核对：`runBinaryPatcher`/`PatchResult` 在 Forge src 内仅有 ResolvePatchedMinecraft 一个调用，`PATCH_OPERATION_VERSION = 7` 位于该 owner；归档 clean/patched/rename/provider JAR 和静态 HEAD 对照是诊断来源，未重放，不能称新 baseline runtime。当前 271 inputs identity 仍为 `6044ede90315ca42796f7b7451ac303e64947a65b0a5446650cae90e4e3c2a9d`。

精确后续生产 owner：

- `minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt`：patch 完成后、下游 rename/mcinject 前补齐 clean 缺失 entries；只补缺失，patched bytes 优先，未修改 interface 与引用进入同 namespace；覆盖已有 placement 与末端 patch 路径。
- 同 task 目录 `ResolvePatchedMinecraft.kt`：消除晚期旧 namespace 回填责任；保持 universal/inject/AT/marker 的既有顺序和语义；`PATCH_OPERATION_VERSION` 7→8 使旧错误 cache 不复用，两现有 operation names 都派生同版本，不清共享缓存。
- 必要单文件局部回归 owner：`minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/task/McpActionPatchTests.kt`（本次核对不存在，目标输出，不是假装可读 ref）。只沿既有 JUnit/ASM/JDK 生成有界 JAR，验证 patched class 引用未修改 clean interface、missing entries 与 duplicate patched bytes 优先、补齐发生在下游前；不新增 fixture/resource/build/dependency owner。

原 basic/remapped `build.gradle.kts`、两 settings、两个 Test.java、`PatchedMinecraftTests.kt`/宿主断言及 module/root 配置均保持；Minecraft/Forge/工具版本、Java8 compile/Java17 host、`srg→named`、AT/nested 政策不变。独立 R03V 沿原过滤命令实际执行原两项 2/2，取得 basic ICommandSender definition/reference、Java8 compile/JAR/print 与 remapped patch/mappings/remap 闭环；R03P 最小聚焦证明不能替代它。现存 Java8 发现例外只在独占的 generated TestKit home 临时提供现有 JDK8 paths，before 原存在状态/bytes/hash 后 finally 精确恢复；不改 fixture/外层用户属性或安装。

R02C completed 与 DIAG-PATCH completed 为修复前置；R03 原 partial/blocked 和 I04E generation1 partial 全部保留，独立 R03V completed 才能建立新树 R03 outcome 并成为 core/includes 版本前置。随后同最终固定树五模块 check 与全 A1–A12/AC1–AC12，不把旧 PASS 传给新 identity。唯一 item graph、owner/predicate/dependency 见 [Waves](waves.md#最小forge-patch生产修复与独立重验)；策略见 [Plan](plan.md#basic-patch完整输入恢复已授权仅图准备)。来源、before/after/diff、Git/index 与旧封存保全及默认只读 verifier 见 新 patch-repair-plan（历史原件不可访问；见顶部保留说明）。本次第一 structurally-ready 候选为 R03P，仅报告；没有运行、接受、调度或放行，W03–W06/I05 继续等待。

## 初次规划观察（历史，当前状态以上节与 Waves 为准）

下列原 main/版本/未决/未运行陈述仅保留初次规划 provenance；三模块 fork、I01–I04D、两诊断及最新维护许可已由上节和 Waves 覆盖，不再作为当前 blocker 或通过证据。

## 仓库观察与来源边界

Codev 仓库是 `E:/Projects/cloche/minecraft-codev`，外部 Cloche 源码在相邻 `E:/Projects/cloche/cloche`。只读 Git 核对：Codev HEAD 为 `30d1d3d22267477db3275cb849e8692ada0f74de`，分支 `main`，241 条 tracked/index 路径，tracked 相对 HEAD 的路径差异为空。恢复工作时四份权威/背景文档与本 Work 初稿均为 untracked；未覆盖初稿或既有权威。快照用于核对本次写入前后，不代表历史全仓库取证。

只读检索涵盖 Codev Kotlin、Gradle 与服务注册文件及相邻 Cloche Kotlin 消费面；直接阅读下表拥有行为的文件。检查 Codev 文档拥有路径和可读祖先的 AGENTS 候选，以及工作区排除 Git/build 的 AGENTS 文件检索，没有找到适用 AGENTS；这是有界负证据。未检查外部不可见约定或任意 ignored 输出。

## 实际影响面

下表的路径均相对 Codev 根；“现状”是源码事实，不是本次复现结果。

| 边界与定位 | 当前源码事实 | 规划影响 / 写入 owner |
| --- | --- | --- |
| `minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MinecraftCodevMixinsPlugin.kt`，`apply` | plugin apply 调用 `MixinBootstrap.init()` 并推进共享环境阶段。 | mixins 移走 apply-time 执行初始化；apply 只配置 Gradle。 |
| 同包 `task/Mixin.kt`，属性与 `mixin` | 既有 target/mixinFiles/classpath/side/output；side 默认为 UNKNOWN，输出为 temporaryDir 下 `*-with-mixins`。classpath 标记 CompileClasspath；直接写 output ZIP；配置来自 mixinFiles/input；只用第一个 listing handler；类名使用 host separator。 | 保持 public 属性、旧默认及无映射调用；跟踪完整 runtime classpath、effective options、mapping、模式和新增 records；暂存后提交；ZIP `/`；独立 selective producer。 |
| 同包 `mixin/GradleMixinService.kt`，`use`/providers | retained lazy transformer；只清理部分 configs；synchronized shared service；每 use 新 URLClassLoader 无 close；类由 host Class.forName，字节/资源走 task loader，另有本地文件 fallback。 | 每操作丢弃 bootstrap/service/环境/缓存/静态状态；类与资源统一 task 域；有界 implementation 域；关闭资源；取消与失败复位。 |
| 同包 `mixin/GradleGlobalPropertyService.kt`；`src/main/resources/META-INF/services/org.spongepowered.asm.service.*` | 属性服务持有实例 map；Codev Mixin/service SPI 已存在。 | 复用 SPI，在操作域选中 Codev 实现；不能借 JVM 全局属性或竞争 Loader 服务选择泄漏。 |
| 同包 `StripMixins.kt`；`MixinListingRule.kt` | `TransformParameters.None` 明确全删，listing service 一次加载；删除所有列出 configs 后调用 handler.remove。 | 保留全删 ABI/语义；新增 records-consuming selective capability，由 mixins 所有。不能将旧入口默改、fallback 全删。 |
| `minecraft-codev-core/.../ListedFileHandler.kt`，`utils/Services.kt`，`utils/path-utils.kt` | shared handler 只有 list/remove；ServiceLoader 绑定接口 loader；已有 ZIP filesystem / stream walk helper。 | 只读复用；不扩大 shared ABI，不新增 core serializer，不通过反向 loader 依赖闭环。 |
| `minecraft-codev-fabric/.../mixin/FabricMixinListingRule.kt`、`FabricMixinConfigHandler.kt` | JSON scalar/array/object config 列表，remove 删除整个 mixins field。 | Fabric 实现局部选择性引用修改，保留 environment/未知字段/剩余次序；不可直接复用全删 remove。 |
| `minecraft-codev-forge/.../mixin/ForgeMixinListingRule.kt`、`ForgeMixinConfigHandler.kt` | manifest token split/trim 未过滤 blank；优先 manifest 再 TOML；TOML 路径使用 FileConfig 但未显式 load/save/close。 | Forge 过滤 blank；选择性路径枚举所有适用元数据，保存关闭并 reopen TOML，避免 first-handler 留下悬挂引用；不推断 Loader precedence。 |
| mixins/fabric/forge 的 `build.gradle.kts` 与 services | fabric/forge 已依赖 mixins；mixins 依赖 core。Mixin API 锁定 `0.15.0+mixin.0.8.7`。 | mixins owns capability，loader adapters 实现；无需 mixins→fabric/forge。优先现有 JSON/ZIP、mapping-io 先例和 JUnit/TestKit。 |
| `minecraft-codev-remapper/build.gradle.kts`；core build | mapping-io `0.7.1` 先例；core 当前 ASM 9.3、Guava 31.1-jre，而 scratch 使用 engine-POM ASM 9.6、Guava 21.0、Gson 2.2.4。 | 运行 implementation closure 必须核对实际 Gradle resolution 与 CodeSource，不能照抄 scratch classpath 假装产品已验证；不改全仓 core 依赖或复用 MappingService。 |
| Cloche `ProjectPluginApplicator.kt` 与 target/resource 配置 | 搜索发现应用 Codev Mixins plugin 与配置生成消费者；本轮符号检索未找到相邻 Cloche 直接注册 Codev `Mixin`/`StripMixins`。 | bounded negative evidence，不证明外部消费者不存在。保留旧 surface，以本地兼容 fixture 验证；不编辑相邻仓库或自动替换注册。 |

## 可核对的构建与版本输入

读取了根 settings/build/gradle.properties、wrapper 配置和 mixins/fabric/forge/core/remapper module build 文件；没有执行 Gradle。

- Codev wrapper 是 **Gradle 9.4.0**，不能使用 JVM reconstruction 或相邻 Cloche 的 wrapper 代替。
- 根 child project 约定为 Java 11 toolchain；side-annotations 与 forge runtime 子项目约定 Java 8；既有若干 Minecraft fixture 使用 Java 8/17/21。仅小型本地 G1 fixture 需要 Java 11 classfile；Gradle launcher JVM、Java 11 toolchain 和所选额外回归 fixture toolchain 的实际可用性未验证。不能把 scratch 的 JBR 21 事实当作 Codev build 成功。
- 根已有 `gradleTestKit()`、JUnit Jupiter、`useJUnitPlatform`；mixins/fabric/forge test 均依赖 pluginUnderTestMetadata。根 gradle.properties 已启用 `org.gradle.configuration-cache=true`，故 configuration-cache 存储、复用与输入变更后的重执行是现有配置下的必要兼容验证，不能仅关闭它后宣布通过。Forge 现有 `PatchedMinecraftTests` 会跑 Minecraft fixture，故 focused G1 gate 应以明确 `--tests` 的新 suite 运行，避免误当最小下载-free 验证。新测试应沿用已有框架，不新增测试平台。
- settings 最后一条 `include("minecraft-codev-legacy-forge")` 存在，实际目录检查为不存在。是否在当前 Gradle 版本配置失败尚未运行，维护选择见 Plan；不能伪造确定报错或悄悄创建 Loader 实现。

模块 `gradle.properties` 的实际当前值与 Spec 末段 supplied coordination defaults 相符：

| 实际变更模块 | 当前真实上游值 | 规划 fork 值（只在该模块实际变更时） |
| --- | --- | --- |
| minecraft-codev-mixins | 0.6.0 | `0.1.0+terrarium.0.6.0` |
| minecraft-codev-fabric | 0.7.2 | `0.1.0+terrarium.0.7.2` |
| minecraft-codev-forge | 0.9.2 | `0.1.0+terrarium.0.9.2` |

这使用独立 fork SemVer `0.1.0` 前缀与各自真实上游后缀，不将上游复制到 fork 前缀。不改 root、core、remapper、access-widener、includes 或 runtime 等未变模块版本；若后续实际变更集合超出三模块，必须重新披露原因及真实配置，不自动批量 bump。三个拟定值纳入实施范围确认；本次没有改版本，也不声称用户逐值确认。

## 锁定引擎机制证据：支持与不能推出的结论

完整读取 supplied [scratch report](C:/Users/WINDOWS/AppData/Local/Temp/mixin-pinned-proof-5114b43811224c1bad0db9bdc12ae115/report.md)，不重跑、不复制。报告记载一次成功运行 `original=1 transformed=42 completed=[demo.mixin.Good] failed=[demo.mixin.Bad]`；同 target 上两个原生 Inject 保留 `require=1`，optional config 允许 Bad 的原生 InvalidInjectionException。

| 证据事实（归属于报告） | 对规划的意义 |
| --- | --- |
| audit onApply 和 target candidates 均含 Good/Bad；postApply 私有 mixins 与 suppressed exceptions 的 native getMixin 身份可核对为 provisional Good。 | 审计回调、候选集、applied 标志均不是成功证据。仅 native 归属、精确 binary 控制流的有界 reconciled-state 可作实现起点。 |
| published binary 缺少 source 的 getMixins 方法；第一次反射失败，改用已验证私有字段后成功。 | 版本绑定 adapter 必须检查 binary/访问/身份，不照 source API 假设实现；不自动升级引擎。 |
| transformer 正常返回后输出实际调用为 42；callback 后仍有 processor/coprocessor/export/bytes 阶段。 | callback 事实暂存，完整 transformer 与 producer completion boundary 后才能成为 committed records。 |
| Bad handler 仍合入输出。 | optional 失败非 rollback；Bad 无成功仍不能安全保留或删除。普通输出可完成，selective 必须按 C5 拒绝。 |
| 独立 scratch JVM、一个普通 class、两个 native Inject。 | 不证明 Codev 每操作隔离、完整 obligations、其他失败阶段、接口 applicator、任意 plugin/extension/error handler 归属、资源释放、metadata、mapping 或 TestKit。 |

证据标识：engine SHA-256 `265FFE8B5B3A6B7E0C93749FE431BBB58523B429663CAF1BC722D4ED72856702`；source JAR `0D22C4CD5A7F44692F1A5130D4956B62CAEE4EA0DBA4938777EBAFC9EF8FB020`；original class `60D7D3E936F9A8BF33C59B57719283AC23218BEE85C252DD11C720DC198110F9`；transformed class `4C993D870ADA15EF56A61855DE2437257E691D9ED5794AD867D1FFADBA14A28E`。这些为报告引用，未本次重新计算或执行核验。

Temp 保留不是持久交付。Waves 将持久证据留存作为单独结果：规划目标 `evidence/pinned-engine/`，至少 report、src/resources、run.ps1、invocation、两次运行/退出码、transformed class/disassembly、pinned-javap、依赖来源/执行 hashes、关键 provenance/evidence hashes。依赖坐标、hash、原始来源与重建命令必须使 fixture 可重建；不默认将第三方 binary 全部 vendoring 入仓。归档时核对 hashes 并保留 source/binary 差异及残留限制；不能把归档 Result 当 A4/A7/G1 通过。若临时材料已丢失，报告 evidence-retention 缺口，后续需另有授权的有限复现；不得捏造归档。

## 实质未决与落实限制

| ID | 分类 | 当前事实 / 解除依据 |
| --- | --- | --- |
| D-SCOPE | 实施确认与权限未取得 | 本 Handler 仅写初始派生文档。Router 需披露 Plan 的具体范围并取得当前用户确认；采用权威不自动确认本图。 |
| D-BUILD | material 维护决策未接受 | 缺失 legacy-forge include 的两个候选仍未选择；依赖的构建项不得执行。选择与理由应按所属 authority 路径处理，不能在实现中隐式决定。 |
| D-VERSION | 需纳入范围的具体默认，非新规范缺口 | 三个值有 Spec coordination defaults 与真实配置支持；仅拟定、未写入，不冒称已逐值确认。 |
| D-GIT | 后续具体 Git 副作用授权 | 功能分支创建和本地签名集成需分别有明确范围；只读 main 不授权 reset/stash/清理 untracked。分支名、纳入文件清单、签名方式与目标须具体。 |
| E-TOOLS | 实施环境证据缺口 | wrapper launcher、Java 11、所选 suite/依赖 resolution、签名能力与 CI 均未实际验证；现有工具优先，不安装或升级作为本轮默认动作。 |
| E-ENGINE | 实施验收风险，非已接受的新决策 | native failure attribution 之外的路径、complete obligations、触发未尝试的独立 entry 的正例与 publication 仍需真实 fixture 证据；未知时拒绝 selective-ready。若所需正例或精确记录无法达成，不得以大量拒绝替代 A1–A12 的正例通过。 |

以上为初始文档时的限制和未执行观察，不改写历史。当前 D-SCOPE/D-BUILD/D-GIT-PREP 和本次最小扩展均已有明确许可；I04E generation 1 仍 partial，最终完整 A1–A12/AC1–AC12 未获通过，新树尚未执行；D-GIT-INTEGRATE 仍缺授权。

## R06 generation1 blocked 后的精确单-outcome分解

Router 已读取 `codev-v02-core-lint-repair-r06` generation1 完整 Result：**blocked**，内容格式与七rename/API保全是两个独立outcome，Handler在执行前停止，无源码/rename/build/evidence副作用。原 `G1-I04E-R06` 身份、原定义与历史证据保留为 **historical-only**，不参与当前completion门槛。旧父包 generation1 partial 与 Ruff漂移（写入者未知）保留；不运行旧默认脚本的新树 equality。

当前唯一串行执行分解为 **P02(completed) → R06A → R06B → R07 → R08**；仍只有一个 Work/Plan/Waves tuple、6 Waves。当前44 items；本次只准备派生文档，不执行任一节点。W03 requiredCompleted列R06A/R06B而非旧blocked R06；I05与W03保留R08最终全矩阵门槛。V02 latest partial与旧I04E/V01/V02继续仅为历史证据。

- **R06A / VG1-POST-05A**：一个Handler/Result，唯一修复原生32条内容规则。许可仍只覆盖原17sourceOwners的已报告imports/标点/缩进/换行/注解布局；14个有内容违规，三个filename-only文件无需修改且字节保全。不rename、不加JvmName、不改caller/其他owner。完成要求语义等价、native core compile exit0；独立fresh原生core lint预期exit1，完整报告恰剩原七`standard:filename`且无新增/其他违规。禁止关掉/筛掉filename规则冒称全lint0；该残余由R06B完成，不等同final gate通过。
- **R06B / VG1-POST-05B**：一个Handler/Result，仅在R06A completed后执行；唯一完成七文件物理命名迁移且兼容性不变，只覆盖原七source/destination与四@file:JvmName必要相邻注解格式，不泛修另外十source。四显式fixed为`ServerExtractionStateKt`、`Build_utilsKt`、`Path_utilsKt`、`Source_set_helpersKt`；`GetMinecraftFileKt`、`ExtensionKt`、`IsUnobfuscatedVersionKt`为默认名需真实编译核对，不能称七fixed授权。三case-only移动用同目录unique临时basename两步实体rename，保存实际路径/case证据。迁移前归档七facade/JAR/API/default桥/Kotlin metadata/旧caller字节；迁移后完整core compile/JAR、native core/includes validatePlugins和core lint均exit0，旧binary链接保持，不修改/重编旧caller隐藏ABI变化。允许SourceFile/SMAP/source-JAR路径差异，另仅按Waves精确LNT契约接受本次八类/166项行号+2（逐method/table count/order/BCI不变）；其余runtime/API/metadata保持，旧strict-debug失败仍保留；允许generated evidence probe但不新增项目test/build owner。
- **R07 / VG1-POST-06**：completion前置改为R06B completed（传递闭合R06A）；原单一nested argv `--rerun-tasks`、原fixture/source/断言和build-root ownership、五fork、真实Java8 compiler与Java8→Java17进程TestKit、精确环境恢复、Java11五module既有产物和保密门槛保持。
- **R08 / VG1-POST-07**：显式要求R06A、R06B、R07均completed；原同树fresh五module check、A1–A12/AC1–AC12、P01/P02 direct closure、Forge两TestKit/nativeCompiler独立验证全部保持。

R06A/R06B不清任务增量或其他cache，不获得R02C式移走state许可；真实compile暴露旧incremental state问题时据实partial及证据。原fixture、断言、算法/literals/providers、依赖/版本、未知includes/其他owner、五fork/Git权限均保持原边界。保留原逐family authority reuse，不修改PRD/ADR/Spec/DDD。仅**R06A structurally-ready**；R06B/R07/R08等待completion前置，未启动、未接受、未释放W03/I05/I06/Git。新静态封包见continuation-g2（历史原件不可访问；见顶部保留说明）；当前273inputs为准备前锚，旧冻结scope和旧parent graph/manifest/receipt/脚本均只读。
