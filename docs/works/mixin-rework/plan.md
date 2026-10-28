# G1 Mixin Rework Plan

## 归档可访问性（清理后）

按用户要求，旧历史证据目录 `docs/works/mixin-rework/evidence/` 已整包删除，包括 `core/`、`pinned-engine/`、`g1-implementation/` 和 `g1-results.md`。其中原命令/exit/日志/XML、分窗报告、具名 ABI 输入与普通结果摘要原件均不再保留；没有另建备份、替代原件或重放包。保留本目录 Work/Context/Plan/Waves 的历史结果与执行图，以及同一 ADR 的架构决定。已采纳验收登记仍见 [Context](context.md#g1-acceptance)；该加工登记不是已删除的原实验报告或证据包，也不保证重放。

以下历史正文、JSON 图内路径/绑定及“完整保存/可读/可重验”等措辞只记录原时点，不再承诺已清理原件可访问，也不作为当前证据入口或新执行输入。已失效的 Markdown 证据链接已撤下；历史 task/generation/item/Wave、scope、状态、gate 与实际方法/失败/partial/unknown 均保留，不重置或释放。保留文档不是原件替代品，本次没有项目或 ABI/checker 重跑、没有新 G1 认证；旧已批准 G1 的 accepted/closed 仅适用旧兼容/选择性清理范围，不覆盖当前 [PRD](../../prd/codev-mixin-rework.md)（[中文](../../prd/codev-mixin-rework.zh-CN.md)）的生效（Active）目标：Codev 提供预应用 Task 与逐 JAR Strip Transform；使用者注册、接线并选择消费配置，Codev 按引擎应用通知取得清理资格，不额外核验全目标完成、无报错或最终字节码效果。键为完整 config 资源路径＋原始条目字符串，全部重复、跨数组、跨 JAR 匹配项一并删除，即使其它应用部分完成或 unknown；未通知的其它键保留。仅清单或让使用者补做 strip 不算完整清理流程；原输入不变，不扩至删除类、refmap、整个 config 或 Loader metadata。使用者决定消费者与编译/反编译/打包/运行用途，Codev 不管制用途、不代选路由、不保证任意下游兼容或安全。日志/异常承担诊断，不要求公共诊断返回、旧 Strip 兼容或独立 records 协议。当前 [Spec](../../spec/mixin-preapplication.md) 与[同一 ADR](../../adr/mixin-operation-isolation.md) 的适用说明不代表新实现或验收。Mixin 日志由用户阅读，Codev 不解析日志判定应用成功；引擎抛异常自然失败，Codev 自身 IO、原输入、资源、精确 JSON 与缓存保护仍保留。operation classloader/engine isolation 决定沿用；Task/Transform 结构及身份匹配已定，通知收集 hook/API、信息表示、发布及保存恢复/cache 机制仍未定且未实现；下方 Plan/Waves、selected/授权及 R/AC/验证编号只属旧交付时点，不是新目标执行图或验收映射。本说明仅维护当前适用事实与归档限制，不改变历史策略、图或 gate。

## Selected Plan：mixin-consumer-docs-r01

Owning [Work](work.md)、加工 [Context](context.md#doc-context)，恰一个同目录直接匹配 [Waves](waves.md#selectedwavesgraph)。只选本目录work.md / plan.md / waves.md，不建slice、overview、Tasks或Work。一个连贯普通文档交付，由唯一DOC-W01建立结果；item细节只在Waves。当前用户已选择“写完三处（建议）”，executionAuthorized=true，仅DOC-I06三处消费者文件及静态核对；当前已交付；Root完整采纳DOC-I06 generation1并据实际静态证据满足DOC-W01，本Doc Plan收口，见[加工结论](context.md#doc-i06-closure)。

**总体产品验收登记**：当前用户已明确“接受结案（建议）”，Root据总体核定及既有行为/修复/独立复核/Doc证据登记本轮已批准兼容G1 accepted / closed，见[验收登记](context.md#g1-acceptance)。不是由本Doc Plan自动推导G1；当前无待实施任务，不增加运行或写域，旧限制保留，Git另行授权。

### 目标、Spec-derived范围与非目标

沿已接受原G1-I06三处目标：指南解释预应用→records→选择性清理、不同artifact链、无mapping兼容及可选mapping、ordinary/StripMixins全删区别、task-only plugin、失败保护与兼容限制；普通结果摘要如实说明已接受验证；README只加指南入口。PRD/同一ADR/Spec三family reuse，owner/path/理由见Context，不改authority、API、版本支持或产品/架构决定。

### 一个最小策略与依赖

Root已短披露并取得当前用户“写完三处（建议）”确认，一个Handler串行交付三处。指南沿现有API/fixture解释producer/records/consumer一致绑定，保留producer provider依赖及不同target/source；结果摘要区分R02 fresh59/独立复核与原分窗65/Forge8/Core/ABI有限证据；README只在末尾追加一个指南链接。无独立例子/结果审阅/审批枝。

AF修复Plan已完成、AF-W01/02/03 satisfied、Root明确解除原B-W05阻断；只消费既有Context，不重开原I05或把历史I06/W03作新可执行前置。无待实施源码/运行依赖，本消费者scope当前确认已满足，没有未满足的外部前置。授权仅三处写域和静态核对，Root仍拥有新Result关联/gate判断。

### 静态完成条件与停点

未来只核对本地Markdown链接/锚点、example-to-API/fixture及结果声明-to-加工事实/可读来源，不编译示例或运行项目/ABI。三目标必须一致可导航、例子逐属性匹配真实provider/输入/side/options/scope/mapping绑定、结果与失败限制无误，README原文只追加一个入口；一个完整completed Result列变更区与静态证据才可能满足DOC-W01。missing/partial/failed/blocked或准备成功不释放gate。

实施写域仅新指南、新普通结果摘要与README末尾一个入口，当前用户已确认；四协调执行状态由Root维护，Handler不写。写前三目标若出现他人内容/需要额外区域则停止报告，不覆写。排除source/config/test、authority、旧证据/报告/历史图/Git与helper/ledger/冻结包；不启动Gradle/Java/test/caller/安装/formatter/LSP/checker/进程查询。

### 风险与充分准备信号

静态相符不是新实跑，跨窗结果不是单窗全绿；F3沿正确有限编号，不新造完整A/AC验收。七文件/实跑/复核仍沿原绑定，Native3/许可3；原failed/partial/blocked/unknown、AF-A01未确认回执、1114普通副本偏差、R14 limited/strict=false/external unknown、Ruff/fullStrictScope=false保留；可信本地filesystem身份保护不是恶意并发替换沙箱，digest不认证恶意生产者，不认证全Host/cache/卷/ACL或任意plugin副作用。发现真实矛盾/权限gap只报告，不兼修或设计新验证框架，不自动放行完整G1/Git。

准备充分信号为四MD互链、唯一selected graph、一Doc item/一Wave、合法refs/无环及旧AF保全核对成立；随后当前用户明确确认三处实施scope。消费者三处已交付，源码/项目不执行；Root据完整Result及27链接/示例/结果静态核对满足DOC-W01，不以确认代替完成。

## 以下为已完成AF Plan及原时点策略（非 selected，原文保留）

> 旧Selected/待验证/授权仅属原时点；AF完成、Native3/3、原失败限制不回写，新Doc不继承旧许可。

## Selected Plan：mixin-audit-f1-f2-r01（两源码就绪，待共享验证）

> **当前修复与独立复核已完成**：AF-R02一次native exit0、fresh59=Mixins50+Fabric6+Forge metadata3且零failure/error/skip；累计Native3/许可3，不再运行项目。Root完整读取并关联codev-mixin-af-a02-incremental-review generation1的完整15797-byte Result：F1、F2闭合，无新blocking findings；2026-10-12T15:49:58Z七文件SHA-256与R02 after-hashes全部一致。Root满足AF-W03，AF-W01/02/03共同完成当前有限修复Plan；并明确以原I05报告＋这次增量关闭原B-W05的F1/F2挂起，非仅凭报告completed自动接受。F3沿已接受正确有限编号，旧表/报告不覆盖；原failed/unknown、1114副本偏差及可信本地/Windows限制保留。消费者说明尚未交付，完整G1/I06/Git不自动放行。详情见[加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)。

> **历史AF-V03失败时点（本次单行修复确认之前）**：参数回显通过；此次唯一外层native exit1，累计2/2、尚余0。Mixins fresh 8 suites/50 cases：41通过、9 failures、0 errors/skips；均报OperationPublication.publish输入Projects缺失。Mixin完整check、Fabric6、Forge metadata3及P01/P02完整链未到达。F2字段变异/合法untouched=false与library输入保护已有fresh通过，但不释放整体验收。七源码候选在执行窗未改。新增1114普通副本未逐件证明必要性，属于已保存执行偏差；不宣称合规或全Host保全。AF-W02/03未满足，AF-A01/消费者说明/G1/Git仍阻断；只读定位已完成：Mixin.kt:98裸+Path把完整输入拆为相对片段；最小纠正为+listOf(Path)，未实施、未补验。gates与停止边界保持。

> **历史AF-V03补验许可（原确认时点）**：用户选择“补验一次”。先在自有临时目录进行有界参数回显（不启动Gradle/Java、不造helper框架），通过后原命令最多追加1次。总额度2，实际已用1，尚余1；原任务/七文件候选只读/环境与缓存边界不变。AF-V03是独立新Result；AF-V01 blocked、AF-V02 failed及旧流保留，新失败保存停止、不自动重试。AF-W02/03未满足，AF-A01/消费者说明/完整G1/Git不放行。

> **历史AF-V02失败时点（本次增量确认前）**：实际原生1次/exit1，额度已用1/许可1。Windows引号传递偏差导致daemon启动失败，全部所选tests未到达、fresh XML/cases为0（不是零失败通过）。F1/F2仍未实跑关闭，AF-W02未满足、AF-A01未启动；已保存并停止，没有追加运行授权。以下AF-V01 Native0是旧启动前时点。

> 历史AF-V01 generation1语义blocked（启动前版本误绑定），实际Native0/1，原启动日志保留。现按C5将未完成验证细化为AF-V02，原命令/52基线+新增/恢复/停点不变；外层保持现有wrapper9.4.0，内部TestKit保持既有配置，不改wrapper或安装。旧blocked不回写成功，新Result独立判断AF-W02。

Owning [Work](work.md)、加工 [Context](context.md)；恰一个同目录直接匹配 [Waves](waves.md)。唯一selected scope仍mixin-audit-f1-f2-r01，B01/R13仅历史。AF-R02完整实跑与AF-A02完整独立增量报告已分别采纳，AF-W01/02/03均satisfied，本修复Plan完成。Root明确解除原B-W05 F1/F2挂起，原I05发现处置完成；消费者说明尚未交付且不自动进入新写入scope。累计Native3/许可3，不再运行项目，不自动放行完整G1/I06/Git。

### Spec-derived边界与确认

当前用户已选择“修复并验证（建议）”，准确七文件、四文档同步、一次Native/效果/停点和成功后独立只读增量复核已披露确认，不再问内部接线。PRD reuse（Codev产品owner、Active docs/prd/codev-mixin-rework.md）、同一ADR reuse（执行隔离/adapter owners、Accepted docs/adr/mixin-operation-isolation.md）、Spec reuse（mixins/平台owners、Active docs/spec/mixin-preapplication.md）；可靠assessment理由及读取事实见Context，update/create skip，无authority写权。

仅恢复F1的C1/C3真实输入保护与F2的C4/C5记录自洽/合法untouched=false。四生产文件为OperationPublication、两个现有task、SelectiveConsumer；三个现有tests为OperationPublicationTests、MixinInputBindingTests、MixinSafeRetentionTests。准确item文件、写权、命令、deps与单一predicates只在Waves；不另建Plan pair/Tasks/证明平台或规划审阅节点。

### 一个最小连贯策略

publication共享层对真正删除/发布的destination，在任何旧结果删除/父目录创建/替换前统一真实路径/Files.isSameFile/受保护目录包含规则；两个task交已有完整inputs，原API/顺序/binding/cache/lock/staging保持。身份拒绝必须writer未进入、输入及其它合法旧输出不变；取得所有权后的writer失败仍清无效结果，不恢复陈旧成功。

consumer现有整份entry循环先校验success完成Boolean/native/provisional链，再source matching/remove；untouched另走安全分支，false合法。producer/schema3/engine/remapper/SPI不改，不提供签名或真实性验证，不重新执行engine。

F1、F2是独立源码就绪outcomes，共写MixinInputBindingTests，F2显式依赖F1；每item单Handler/Result，代码completed不是JUnit通过。两候选ready才进入唯一共享验证，再由独立只读增量复核消费新完整Result/证据。B-W05阻断是动机而非入场前置，不形成自身gate死锁。

### 最小真实验证、权限与停点

AF-V03唯一外层命令在Waves原样登记，cwd E:/Projects/cloche/minecraft-codev：Mixins完整check无filter + FabricApplicabilityRepairTests六场景 + ForgeMixinMetadataTests三场景（52基线+实际新增JUnit），fresh XML无failure/error/skip且exit0。新implementation pair必须重新生成，不能拿旧records假充新正例；保留P01/P02恢复fresh consumer/target42行为、publication失败保护、平台metadata reopen。排除全65/Forge patched/Core vanilla/ABI重跑。

作者Native0；唯一共享窗口已用1/许可2（尚余1，补验已确认）。既有TestKit内部build、publication自有child终止/重试和Windows junction/hardlink case是任务图行为，非Host管理/额外外层窗口。child Microsoft17/受控temp、父不改、GRADLE_USER_HOME继承，不预写TestKit属性；有界正常输出、必要旧生成实物普通副本及finally见Waves/Context，不授权整build/cache/Temp。

缺工具链/依赖、额外属性/写域、范围外source、新failure/error/skip、junction建立/解除失败或必需旧实物无法保留均保存停止；不自动重试、扩跑、安装、清cache、升权或兼修其它模块。Windows卷/ACL实际可行性未实验，不能提前称必通过或skip代覆盖。

### 证据、风险与准备完成

两gen1报告completed已完整关联：审计交付有F1/F2阻断、范围核定完成；persistent记录用Context加工事实和已验证可读的仓库相对source/spec/native，不迁入external Result locator，不因仓库原文缺席回退已采纳状态。原65/Forge8/Core/ABI与failed/partial/unknown仅有限复用；F3正确有限编号supersede原表，原表不改，无新勘误/authority文件。

风险是共享publication/consumer可能破坏正常重跑或误拒untouched，以一次受影响闭包及真实负例/合法正例承担，不添observer/helper/证据平台。字段自洽/绑定不提供authenticity，路径修复不承诺恶意并发重定向的全文件系统事务；范围变化停交Router，不自行扩权。

本准备只检查匹配链接/唯一选择/稳定IDs及引用/联合DAG/owns-conflicts/授权与源码ready、真实验证predicate一致。不运行Gradle/Java/checker/LSP/实验。未来完整Result+实际predicate由Router判gate；partial/failed/blocked/missing不release。AF-A01报告可完成但带阻断不满足AF-W03；没有消费者说明/完整G1/历史W03/I06/Git自动放行。

## 以下为历史 B01 Plan（非 selected）

> 下方旧Selected/当前/待确认/ready与命令只属原B01/R13时点；原结果、失败/unknown保留，不成为当前第二策略或继续许可。

## 当前范围确认：B-I05 Includes格式与分窗收尾

当前新增确认：用户选择“修格式并收尾（建议）”。仅Includes main目录下ExtractIncludes.kt、IncludedJarInfo.kt、IncludesJar.kt、StripIncludes.kt处理continuation-02原报告的八条逗号/换行/缩进诊断，不改逻辑、API、断言或lint规则，不运行全仓format。之后一次Includes check，沿--rerun-tasks/--no-parallel/--max-workers=1/--configuration-cache/--stacktrace/--console=plain。只读消费g1 Mixins43/Fabric8、continuation-02 Forge11/Core3及B-I04 ABI的同源source/TestKit/closed实物，全部适用A/AC、P01/P02与实际Java8不减；不重跑65测试、caller或focused。原两次exit1及历史failed/partial/unknown永久保留。新普通日志仅原B-I05 namespace的continuation-03/，temp仍原runtime/temp，有界正常输出和finally不扩域；新失败/reusegap保存停止、不自动重试，无安装/清cache/审计/I06/Git。Root已完整读取codev-b-i05-includes-format-closeout generation1的completed完整Result及continuation-03/verification.md。Includes唯一native exit0，编译/ktlint/validatePlugins/check完成，test如实NO-SOURCE；旧四module成功check/65tests零失败、错误、跳过按原窗/source/TestKit/closed实物关联，12对A/AC、P01/P02、实际两Forge Java8、Core四闭包负例、I04当前158class+1kotlin_module bytes及finally支持。Root据此接受B-W02/B-W04，B-W01/B-W03继续满足；本scope收尾完成，不追加native。三条既有auxiliary warnings及准备/读取错误保留，旧两条exit1、R13 failed/R14 limited/strict=false/external unknown/Ruff限制不回写，不自动释放历史W03/完整G1/I05/I06/Git。报告见 docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md。以上为当前唯一新增许可，下方原scope/执行结果保留其时点。

### 原四brace scope及执行结果（保留时点）

当前新增确认：用户选择“修四处并补三模块（建议）”。只在ForgeMixinMetadataTests.kt与PatchedMinecraftTests.kt补原ktlint诊断的四处分支花括号，不删断言、不改逻辑；之后一次Forge/Core/Includes check，沿原参数。复用g1 Mixins43/43、Fabric8/8须同输入且实际source/TestKit/closed产物可闭合；最终五模块按两窗组合，原五check exit1/failed永久保留。ABI不重跑，无focused/生产修复/清cache/安装/扩权/审计/Git。新普通日志只原B-I05/continuation-02/，g1原流/记录/SDKResult不覆写，child temp仍原runtime/temp。复用gap或新失败保存finally后停，B-W02/04未满足；新增四brace已完成；该唯一三模块续验native exit1，Includes四main文件八条ktlint逗号/换行/缩进失败。Forge本窗fresh11/11与Core本窗fresh3/3均零失败/错误/跳过，二者check实际成功；Includes:test/validatePlugins/check未到达。两流及finally已保存、generated属性精确恢复、父env/110局部必要输入前后不变；旧Mixins43/43与Fabric8/8未重跑。全部source/TestKit/closed产物及ABI复用最终消费因失败停点未完成；B-W02/04未满足，不宣称五模块成功。该增量次数已用完，未授权Includes源码修正或自动重试。以上为当前新增范围，以下原统一窗及初次准备说明保留各原时点，不与新增scope竞争。

原统一窗确认（原许可时点，g1失败保留）：恢复一次独立 Core compileKotlin/jar、原三封存 Java17 caller 与原 ABI/debug 验收；成功后串行执行一次 Mixins/Fabric/Forge/Core/Includes check，共用组合窗验证修正后的 PatchedMinecraftTests，不追加 focused。B-W01 已有限满足。B-I03 g1 启动脚本失败、g2 实际 focused native exit1/2 failures 均保留；g3 仅一行 argfile escaped-backslash 解码修正及离线检查完成，内层 partial，未原生回归。B-I03/B-W02 不提前释放，须以 g3 同一修正输入与 B-I05 的新完整原生结果共同成立；共享验证的入场不依赖尚待该窗证明的 B-W02，最终完成仍必须满足它。匹配 Waves 的新依赖只改变证据复用与次序，不减少 A/AC、Core3case、P01/P02、实际 Java8 或一次性维护条件。

仅既定生成子域、B-I04/B-I05 普通日志/必要结果快照、原受限 child/temp/TestKit 属性与精确 finally；不授权额外 focused、源代码/依赖/规范修复、清cache/安装/扩权、旧封包重跑、独立审计/I06/Git。失败保存恢复后停止，不自动重试。B-I04 g1完整Result已读取并关联：独立Core与三caller各一次native exit0、158class/模块bytes及原ABI/default/Kotlinmetadata/精确debug条件完整，输入前后不变，受限child无待恢复属性；B-W03有限满足。B-I05 g1完整failed Result已读取关联：唯一五check native exit1，Forge两个测试文件四处ktlint Missing { ... }，Mixins43/43与Fabric8/8本窗fresh零失败/错误/跳过，Forge/Core/Includes test/check未到达；两流已保存、handles结束、generated属性精确恢复。原单次窗口已用完，不自动source修正/重试；B-I03/B-W02及B-W04依旧未满足；文档/UI不是 admission 或通过证据。下方初次准备及原兼容段描述保留其原时点，以本节与当前 selectedWavesGraph 为新范围，不重写历史或建新取证包。

### B-I03 方法说明校正（沿用当前确认，非运行或 gate 结果）

直接使用原 `compileJava` 的 CLI 分支：必需 `fixtureJava8Javac` 经受限 outer child 的 `CODEV_TEST_JAVAC8` 传给原 nested invocation；`fork=true`、指定 executable、不设置 javaHome，`forkOptions.jvmArgs=[-J-showversion,-J-Duser.language=en]`，`verbose=true/incremental=false/failOnError=true`。保留 `jar/printCompileClasspath/-s/--rerun-tasks`，增加 `--info/--console=plain/--no-build-cache/--no-parallel/-PfixtureJava8Javac`；outer/test 保持17，不对 debug TestKit 使用 withEnvironment。逐 fixture 的实际8版本、原 Test.java 解析、本次 wrote、原 patched/named classpath、compileJava/jar SUCCESS 与重开 JAR 内 **Test.class** 原 bytes 等同为合取证据；major52仅辅助。原两源码实际产物为 Test.class，准备中的 Consumer.class 是方法说明误写。唯一 generated TestKit 属性原 bytes/缺席须 finally 精确恢复；不恢复 jcmd/CIM/observer 或四 key/byte-writer 账本。以下初次准备的未定方法描述保留其原时点，本节仅局部校正方法，不推进 Result/Waves/Todo/gate，也不构成实跑通过。


## 历史 Plan：mixin-layered-b01（初次派生原时点，非 selected）

Owning [Work](work.md) 与 [Context](context.md)；恰一个匹配 [Waves](waves.md)，其 selectedWavesGraph 是唯一新候选执行图。selected tuple 为 E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/{work,plan,waves}.md 的三个直接文件，不是历史冻结 tuple。图的 B-W01/B-W02/B-W03/B-W04 gates 建立本实施 Plan 的完成；本次只交付准备文档，未实施或释放它们，且不自动承接历史 W03/I05/I06/Git。

**用户接受的是方向 B 与此次准备，不是新实施 scope。** B-I03 的 compiler 方法仍 blocked；该部分不是 ready scope。已 settled Fabric 去重/metadata 补覆盖可单独在新 scope 集中确认后按其独立 prerequisites 执行，不等待 compiler 选择。无第二 Plan、overview、Tasks 或独立准备审计任务。

### 目标、权威与兼容范围

交付仍可验证的 G1 测试/验收方式：减少 Mixin 日常回归与无关 Minecraft 构建、一次性维护和严格归属证明的耦合，而不降低用户行为、selective 安全或实际 compiler/consumer/cache/publication 证明。PRD R1–R10、Spec C1–C8/A1–A12、同一 Accepted ADR 全部 reuse，owning boundaries/版本与理由见 Context；本 Plan 不创产品/技术 authority。

本次 scope 包括三项最小测试侧候选变化、一次性当前 Core ABI/rename/debug 兼容闭包及一次组合交付。不存在生产修复、公开 API 变化、依赖/lockfile/版本更改、tool installation、全局/父环境变更、collector 扩建、Git 或 publishing。旧六 source 退役保持；Core3case、原两 Forge fixture 及版本不删不扩。

### 一个连贯策略

先保住已有更强 assertions，去掉仅重复的 SERVER/client-only fixture，再让一个真实双位置 source JAR 走现有 selective 路径补 C6/A8 缺口。两项只改已有 test owners；复用现有 helpers、普通 test/--tests 和原生 XML/closed JAR，不以 mocks/string-only/新 TestTask/tag 替代。仅 compiler 的必要 test-side 接线可能触及原 fixture build；未 settled 时不承诺改法，保留两原 Java API 源码/版本/任务链。

日常选择小 JAR/局部 TestKit套件；真实 Core/Forge 集成按受影响边界触发，此次组合交付必须纳入。一次性 Core 维护证明与日常功能测试分开；以后只在公开 ABI/facade/debug 维护再触发。各 item 的具体文件、命令、prereq/effects 和单一完成谓词只在 Waves，下面风险表是验收关联，不是第二工作清单。

| 风险组 / A与AC成对关联 | 必须保留的 observable；现有主要 owner |
| --- | --- |
| 入口、空调用与真实消费：A1/AC1、A5/AC5、A11/AC11 | MixinPreapplicationTests/LegacyStripMixinsTests/MixinInputBindingTests；原 no-mapping 注入调用 1→42，旧 all-delete 保留其意义，target/mod 区别与原 source 不变。provider/task、ArtifactTransform、旧 registerTransform 不是相同入口，不能合并删掉。 |
| 隔离/任务域/输入：A2/AC2、A3/AC3 | MixinOperationIsolationTests、MixinMappingTests.mappedOperationThenConfiguredUnmappedOperationInSameJvm；并发等于串行、同 JVM 有 config 的 B 不受 A remapper 影响、退出 close/TCCL。testKitTaskOnlyPluginBodyAndResourceChangesReexecute 保留 SUCCESS/UP_TO_DATE、body→45/resource→49，真实 Windows archive path。 |
| 实际 success、残留与失败恢复：A4/AC4、A7/AC7 | MixinFailureStageTests/OperationPublicationTests：Good success 与 Bad attempted/residual 分开，ordinary native optional 语义保留；required/unknown/postprocessor 失败、second-move failure、取消/进程中断、fresh retry、不消费旧 half-pair、资源关闭仍实测。 |
| 精确 selective/safe retention：A6/AC6、A7/AC7 | MixinSafeRetentionTests：compact/pretty、Foo/FooExtra/另 package、side excluded untouched、unknown metadata/resources；双 target 全 success 才删，缺失/失败/unknown拒绝；零success的残留或不明 attempted entry 拒绝；parent/plugin 重供不安全拒绝。 |
| Loader 与 side：A8/AC8（关联A1/A6） | FabricApplicabilityRepairTests 全外层environment×内层kind/side、parent/tamper/input失效；FabricMixinMetadataTests/ForgeMixinMetadataTests 原三种形式、blank tokens/TOML save+reopen 保留。新增真实双位置 JAR 的所有适用引用一起更新，retained order/metadata/resources 不变；冲突/不可解释 metadata 不得发布。 |
| 映射/refmap：A9/AC9、A10/AC10 | MixinMappingTests：owner/overload/descriptor/reverse/null/unmapped/ambiguous，不取任意首name；真实 refmap→MemberInfo→remapper 调用正确目标；legacy/no-refmap 正例与tuple/context/wrong-direction负例、TestKit输入失效均保留。 |
| Cache/records 绑定：A3/AC3、A5/AC5、A11/AC11 | buildCacheRestoresSuccessfulPairBeforeFirstFreshConsumer 等：producer SUCCESS→target+records FROM_CACHE→首次 fresh consumer SUCCESS；target42/original1/source不变/cleaned保留Unused。仅 UP_TO_DATE、hash 等式或 collector 自检均不足。 |
| Engine/extension边界：A12/AC12 | 锁定0.15.0+mixin.0.8.7、实际 engine/ASM provenance、native invalid config/major及不可用bootstrap/injector失败、显式task-scoped extension；不自动 Extras/Loader限制，不宣称全局sandbox。 |
| touched旧能力与平台兼容：R10、A11/AC11 | McpActionPatchTests、ForgeRetainedBaselineTests 的真实 AT access/nested payload/reference；Core VanillaBuildTests 三case、MC1.16.5/1.20.1各common/client四条resolve→compile→package/资源/major61/准确missing-ID且无成功outputs；Forge原1.12.2/1.16.5真实编译/patch/remap闭包。keep.aw资源保留不是AW算法实测。 |

每个适用 observation 必须关联实际方法/命令/原生 XML 和必要产物；A与AC引用同一证据，不强制 24 次运行/Result。缺 assertion、失败或 unknown 明确报告，不能以改表格分母消除。

### 运行频率、最小验证与一次性完成标准

所有未来命令 cwd=E:/Projects/cloche/minecraft-codev，以下均未执行。使用已安装外层 Java17、Core test launcher11/nested17、Forge compiler8；不把外层 Gradle 降成Java8。

- **日常**（适用的 suite 不新拆 test task）：
  - .\gradlew.bat :minecraft-codev-mixins:test :minecraft-codev-fabric:test --stacktrace
  - .\gradlew.bat :minecraft-codev-forge:test --tests '*ForgeMixinMetadataTests' --tests '*ForgeRetainedBaselineTests' --tests '*McpActionPatchTests' --stacktrace
- **边界变化**：Core resolver/resource/package 改动时选 '*VanillaBuildTests'；Forge patch/remap/compile 接线改动时选 '*PatchedMinecraftTests'，使用 --rerun-tasks 保证真实执行。保留原套件，不恢复旧selector/Gradle矩阵；这些入口不是download-free/纯内存unit。
- **此次组合交付**：唯一一次全五 check（Waves B-I05），原生 validation/lint/test，Core恰3case且零fail/error/skip、Includes NO-SOURCE 如实。关联所有适用风险组/真实行为，以及 B-I03 的逐fixture actual Java8/fresh output 证据和 B-I04 的一次性fresh独立CoreJAR/封存caller/debug证明。所有来源必须对应同一交付输入，原生原始两流/argv/cwd/时窗/exit与XML/JAR足以承担普通结果，不再制造 JSON证明包/hash账本/collector回执程序。

每项测试改动只运行其必要 focused check；组合交付全套一次，独立 review 消费这批证据，不默认再全套。输入/行为不变且符合所需freshness的 focused/native 证据可引用；发生变化、失败或来源不足才补对应风险，不自动retry。不能把旧run01/R14/旧P01/P02 PASS填成新组合PASS；新的 cache/consumer链仍须实际发生。Core/Forge的 current平台闭包不靠普通小fixture冒充。

### 实际 Java8 的局部 blocker

现有 PatchedMinecraftTests 只 nested build成功，原fixture toolchain8是意图，不证明正在用Java8 compiler。最小候选是不增加 observer：在原 compileJava 路径受控启动可识别 Java8 compiler，并记录其实际执行事实，绑定 compileJava SUCCESS、fresh Test.class、jar内容及本fixture patch/remap输出。compiler可执行文件身份/执行成功→当前新class→当前jar必须闭合；major52仅交叉检查。仅 doFirst 打印 javaCompiler.metadata/java.version、--info声明toolchain或 caller qualified=true 不能闭合。

本次没有证实 Gradle9.4实际compiler日志可行性，也没有绑定其compiler执行源码的新证据。因此**B-I03保持 blocked**，其测试侧实现/额外argv未settled；不从设计接受推导日志已经够用，不恢复jcmd/CIM或新增遥测observer。依赖它的组合gate相应不ready。这个 gap 是实施证据方法，不是 PRD/ADR/Spec 行为缺失；若后续涉及生产观测、安装工具或新权限则超出本 scope。独立两项test覆盖准备不被该gap拖住。

### 写边界、保护、失败与停点

本 writer 仅写四MD。未来测试writer仅拥有 Waves 明列的测试文件及条件性的原两fixture build文件；verification-only Handler 不改 source/tests/config。未来输出只使用该 item 自有 native log/XML/closed JAR namespace、既有相关 build 子域与经确认的 TestKit/Gradle/Codev operation namespaces，不是整个build/cache/Temp。原run01目录和所有历史 Result/session/evidence只读；其原许可已用，不可借 normalEffectsProposed 模板续跑。

child环境以copy/受限覆盖使用，不改父环境/全局；TestKit属性若必须临时生成，只限已确认的唯一generated位置并finally精确恢复。保存真实失败流和必要新输出，不修 source以救验收、不手清旧cache、不覆写旧对象/历史。private Gradle home 不隔离系统Temp；默认Files.createTempFile或第三方写入若不能落在已有允许namespace/受控child临时根，则**只阻断受影响执行**并报告具体gap，不取消保护、不授权整Temp，也不把严格归属账本重新列为普通PASS。

四 Codev key/cold Temp逐路径/strict byte-writer/fullHost证明退出新R13常规分母；C3/C4产品缓存/内容绑定、正常效果许可、旧对象保护、child/finally仍保留。新功能completed不能声称全Host或严格写归属通过。历史partial/failed/unknown和原授权保留，不回写旧rawResult。

### 风险、关键决定与有限收口

B延后发现部分跨模块/平台回归且失去常规逐字节归属精度；以边界触发/当前组合交付、真实consumer/失败保护及受限写域弥补，不承诺耗时收益。Java8方法与临时写边界仍可能阻塞后两支；owner是Forge compiler测试边界/Router权限披露，不自动生产修复。最小rollback是仅还原本scope新增/去重测试diff（需对应授权），不清cache、不恢复退役六source、不改历史证据。

本次准备完成标准：匹配tuple/links、唯一候选selectedWavesGraph与合法无环依赖、明示outcomes/owners/排除项/方法blocker及上述验收条款一致。未来实施完成需 B-W01至B-W04真实满足；没有结果或partial/failed/blocked不release。Router完整消费Result判断gates；文档/UI不是gate，I05/I06/Git和最终G1接受不在本scope。

## 以下全部为历史 Plan（保留旧scope/合同/结果，不作新执行清单）

> 下文旧“当前/唯一图/ready/单次未用/新run01”只保留其原时点；新选择是mixin-layered-b01和匹配Waves顶部selectedWavesGraph。旧图/授权不隐式迁移，历史state不改绿。

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

当前源码仍完整278 inputs；未来精确减去六source为272，path/length/SHA真实派生见 prospective-inputs.json（历史原件不可访问；见顶部保留说明），不得只改count继承g3 identity。当前278 identity为 `ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04`；未来272 prospective identity为 `daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df`（未删除/未实测）。未来Core预期3tests/3passed/0skipped/0fail/0error，不是本次实测；三个真实case及MC1.16.5/1.20.1×common/client四闭包和准确missing-ID/无成功outputs断言不降低。旧8/7/1、四空pass及Basic skip仅历史，不反写原日志/XML/JAR或方法。

Root已接受T0 R12A有限功能前置/W08来自当前Handoff inline；不是本Handler重新接受，旧missing字段仅冻结历史定义保留。g3 whole＋tuple当前树等式在本次四coord更新后即失效，六source删除后旧278/class/8-7-1/Disabled守卫也失效；g3全部23文件/22members和sealed preseal false/null均冻结，只作T0历史输入。原rawpartial/unknown/Ruff/fullStrictScope=false/R11g3unknown/01两unknown及V02末端SDK失败保留。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 **R13 blocked**：跨树消费方式/时点未接受；owner为Router＋R12A证据owner/R13消费owner。不在此设计/定案/执行，不接受B归档替代真实default或C白名单、不回滚coord/清生成物模拟T0。不反向阻断局部退役准备，也不声称R13 ready。后继完整五module checks、全A1–A12/AC1–AC12、P01/P02、ABI/旧caller精确debug、Forge双fixture真实Java8、I05/Git门禁全部保留。

### Spec-derived 局部范围、策略及验证

1. `minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt` — future delete-only（当前仍存在）。
2. `minecraft-codev-core/basic-minecraft-test/build.gradle.kts` — future delete-only（当前仍存在）。
3. `minecraft-codev-core/basic-minecraft-test/settings.gradle.kts` — future delete-only（当前仍存在）。
4. `minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java` — future delete-only（当前仍存在）。
5. `minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java` — future delete-only（当前仍存在）。
6. `minecraft-codev-core/basic-minecraft-test/src/client/Test.java` — future delete-only（当前仍存在）。

最小策略是先确认六source精确身份及保护owner，后继只逐文件delete-only（不清目录/cache）、重算实际278→272 identity，然后在同新树沿原core:test fresh运行三case完整闭包。项目写owner只有六删除及必要正常generated效果与新runtime evidence；五Vanilla/有效Forge/production/config/deps/versions/旧包/权威/Git不动。此为一个局部实现outcome，item步骤/依赖/排他冲突由唯一Waves承担，不在Plan另造执行层。

未来确切native命令复用accepted attempt04 `receipt.json#command`，显式Shell/.NET/child cwd=E:/Projects/cloche/minecraft-codev：

```text
.\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain
```

Gradle9.4 wrapper及既有Microsoft17 GradleVM/JAVA_HOME、Core Java11 JBR launcher、Java17 helper/嵌套9.4/compiler，GRADLE_USER_HOME沿attempt04。源码VanillaBuildTests.kt:17–55/80–145与resources build.gradle.kts:9–50规定自有new temp project/coldcache、官方metadata/client/server/mappings、六task SUCCESS、major61/Stone资源及准确missing-ID最后cause/无成功outputs。正常outputs精确类别、现存工具路径及未知owner停止边界在confirmedRetirementScope；不增加下载探测、不安装/改全局配置。

真实完成必须新command/UTC/nativeexit/raw两流/freshXML/输入及产物binding；core:test和compileTestKotlin真实EXECUTED、准确三case恰3/3/0，四MC-side闭包不弱化；任何filter/skip/UP-TO-DATE/旧XML/缺元数据不能代fresh，obsolete compiled MinecraftTests不得偷偷筛掉或手工clean掩盖。只允许Gradle正常obsolete-output维护。未知工具/额外owner/未接受决策阻断受影响item，不自动修复/重试。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 W09只建立此局部退役与聚焦结果；W03/W04/W05及另确认Git继续按原完整predicate。R13显式还依赖R14实际完成及独立跨树决策，不设计该消费方式。代价是永久移除旧selectors/八pipeline/Gradle8.2/8.6/8.8空/停用测试路径（本轮仍未验证，不代表取消公开支持），原g3不能再以当前树default消费；局部green不足完整G1。回退需另确认且保留新失败回执，不恢复/清cache掩盖失败。

本次只运行独立标准库静态检查refs/唯一ID/联合DAG/reciprocal tuple/delete-only/protected owners/278/prospective272/旧包及本窗口写scope；命令/UTC/nativeexit/双流/来源/manifest绑定见新准备目录。未执行六删除/Gradle/测试/g3/Ruff/LSP/Git。

## 既有协调合同历史（保留原scope/时点，不与当前退役范围竞争）

## 当前 Spec-derived R12A g3 就地修复 scope（首次派生）

唯一 [Work](work.md)/[Context](context.md)/[Plan](plan.md)/[Waves](waves.md) pair 延续，不建 overview/新 slice/Tasks。当前目标仅是用户新确认就地许可的精确合同、保护清单和匹配图一致准备；本次不修复或运行 g3。当前新范围的行为和失败分母仍派生于 Active Spec C1–C8/A1–A12、PRD AC1–AC12及同一 Accepted isolation ADR，三family reuse/同版本摘要和 owner 在 Context；证据表示不是产品 application-record schema。下方旧“当前/ready/永久不动/not-run”只保留原scope/时点，本节及唯一 JSON的新四items优先，不改原Result状态。

### 当前授权、非目标与最小策略

用户明确选择“就地修复，并核验一次（建议）”，取代仅针对 g3 的永久不动限制；不建 g4，不清理 g3 外旧核验或旧包。当前 g3 真相是 capture0、唯一preseal1、空verification，无成功seal/default。以实际16文件为分母：静态11精确替换，failed五文件先逐字归档保护后删除失效根位置，之后新功能只在同名授权位置 exclusive创建；不覆盖归档、不重填旧native1为0。新归档仅是同一g3内历史JSON五份，不是g4或用归档代替实际default的B路线。Root/native cwd始终显式 E:/Projects/cloche/minecraft-codev；Harness文件路径才可使用 minecraft-codev/ 前缀。

唯一分解在 Waves：本次 standalone合同准备之后 R12A-R01 → R12A-V01 → R12A-F01 → R12A-V02，四项各一可观察predicate/Handler/Result，全串行。R01修复候选并证明静态合同；V01独立只读审阅；F01只运行一次capture→唯一preseal→seal窗口，产生合法候选与真实封包，不执行独立default；V02独立实际default及完整回执验收。原R12A整项保持旧scope/状态字段并标为historical-only，不把旧定义揉入新多结果item。W08同时要求四项completed及原W02/七base证据，准备/partial/failed/blocked/missing不释放；不等待R13/W03或自身gate。

非目标：不改生产/测试/五新test-resource owners/依赖/config/lockfile/PRD/Spec/ADR/Git，不创建py/ps1/new helper，不导入运行旧main；不项目测试/Gradle/TestKit/download/metadata query/安装/reload/deploy，不启动R13，不降低其独立README-default/fresh五模块/全24项/direct closure/ABI/Forge要求。新错误必须停止并保存真实结果，不自动重试、扩项、建g4或清理失败产物。

### 精确就地清单与未来成员

所有下表路径均相对 **docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/**；当前目录完整枚举恰16文件、没有根manifest.json或seal-receipt.json。原身份以 length/SHA256 锁定，写前须逐项再核对，不因同名或当前可读而略过。当前Markdown引用实际只来自 work/context/plan/waves 与 g3 README/PREPARATION/candidate-diff；JSON引用由静态 manifest、现有 loader/program及完整 receipts 派生。g3外受保护旧包没有获得任何删除/替换权。

| 精确路径 | R01动作 | 写前 length / SHA256 | 现行引用/作用 | 保护归属 |
|---|---|---|---|---|
| before.json | 先逐字复制到 history/failed-functional/before.json 并复核，再删除根同名失效文件；归档永久保留 | 32192042 / f3d9ed5f96c402cc11cd1d557f2861ab886540c52d1fdfe8f8fc655f5f873820 | README program 的功能 snapshot/current 对比；failed capture 输出 | 真实失败保存对象，不改字节；其原位置不是其它历史封包 |
| candidate-diff.md | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 71485 / ffdcb76e86175ecadefa022604e623b8e9095048c35576d839b34a17cf62612d | PREPARATION/README 的差异证明、static-manifest member | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| capture-receipt.json | 先逐字复制到 history/failed-functional/capture-receipt.json 并复核，再删除根同名失效文件；归档永久保留 | 86346 / 331d35a181d34204c36cb69ae03118071705430e494a7e32c95a96ac7bc5036b | README program 的 capture 消费点；真实 native0，来源/双流完整 | 真实失败保存对象，不改字节；其原位置不是其它历史封包 |
| PREPARATION.md | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 43792 / 140823962f6106258f9cc194a6a7160e25f1153f8c86d92303e8eed003b901ce | 四协调文档、新/旧静态入口、四 static receipts.source | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| README.md | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 38048 / 5b8bed7d0494571ad22a7b99e299b9bed7d0ef64ba2b80ccc073394339e60258 | 四协调文档/Waves、R13 plannedEvidenceInputs、两功能 receipts.source 与 program/loader 来源 | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| source-results.json | 先逐字复制到 history/failed-functional/source-results.json 并复核，再删除根同名失效文件；归档永久保留 | 82029 / cb28b4d4da5d5289777af30c452d0d50c60b4ea429fb9ef2c9d1ac51dbeee7ee | README program 的原会话完整 Result/nativeBindings；failed capture 输出 | 真实失败保存对象，不改字节；其原位置不是其它历史封包 |
| static-before.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 32947506 / 3ba0b9d190a5caf29ca1a21c271116073352e8488dbb060ac5a3faf3d872457b | PREPARATION 的 snapshot/check 与 README program 的旧 tuple/whole 基线 | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-check-receipt.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 111959 / be8b370eb43003fdac02284f3c8fed2be8d645b4f32f15f088ce92e20e488e2f | PREPARATION static-check、static-manifest member | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-check.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 35497 / 6beca377d795669dced2b3ae249352e9da33004e2746c67dd985036354cd7781 | PREPARATION freeze/replay 与四协调历史静态证明 | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-freeze-receipt.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 111963 / 6212be44d629d10b3348bcb6f85cc99b7e291ac7f3cc52ad4d1b9179a9e1a4cf | PREPARATION static-freeze、static-manifest member | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-manifest.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 2017 / 086528b0d16f4bfa8b829d6d07a13a5077a9e397c282f95a25f15748ee8513b2 | README loader/program 的静态 subset/tuple 来源、四协调历史静态锚 | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-prepare-receipt.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 99676 / 200880d976008dba122abde72bccc7304b0d526b51b4745f9ebfbd72dfff8c0b | PREPARATION static-prepare、static-manifest member | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-snapshot-receipt.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 99661 / f8a53bf7947069a491b588e3361c6939869a8f85201b896d97f559a3430af05e | PREPARATION static-snapshot、static-manifest member | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| static-source.json | 原路径 REPLACE，旧静态结果失效/候选逻辑过期 | 115341 / 6745fa42dfeedb74615b5fdd28422e56b1d2326656efa56d6f352775b1adbfd1 | README program 的 sourceSessions/g2 原始来源映射、PREPARATION/静态证明 | g3 本次可替换的未成功功能封包内自有静态材料，不是 g3 外旧包 |
| verification-receipt.json | 先逐字复制到 history/failed-functional/verification-receipt.json 并复核，再删除根同名失效文件；归档永久保留 | 86024 / 90d6a97a3110441813a8df2d946bb8a83a8b1982f5b03a2838d9ebc434559511 | README seal/default 的 preseal 消费点；真实 native1/171-byte stderr，历史失败身份 | 真实失败保存对象，不改字节；其原位置不是其它历史封包 |
| verification.json | 先逐字复制到 history/failed-functional/verification.json 并复核，再删除根同名失效文件；归档永久保留 | 0 / e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855 | README seal/default 与 R13 plannedEvidenceInputs；实际 preseal stdout 0 bytes，不是成功 JSON | 真实失败保存对象，不改字节；其原位置不是其它历史封包 |

R01 删除集仅为表中五个根文件，**先五份全部复制并逐字hash验证成功，才可删除原位置**；目标 history/failed-functional/<同名> 五文件必须原本不存在并 exclusive创建，任何copy/hash/identity失败保留原路径并停止。归档保存 before32MB、完整source-results、capture0/preseal1两完整回执与0-byte verification；旧会话的原路径以表中原SHA/归档映射解析，不改会话内容。11 REPLACE允许旧静态check/receipt/manifest和过期program从活跃入口退役，但其历史完成含义及会话记录不变；本次准备没有执行以上任何动作。

R01完成时的精确16文件：静态11（README.md、PREPARATION.md、candidate-diff.md、static-before.json、static-source.json、static-check.json、static-snapshot-receipt.json、static-prepare-receipt.json、static-check-receipt.json、static-freeze-receipt.json、static-manifest.json）加 history/failed-functional/ 下五份同名归档；根before/source-results/capture-receipt/verification/verification-receipt及seal-receipt/manifest均不存在。新的 static-manifest.json 自排除，精确覆盖10静态成员+5归档=15；directoryClosed=false、functionalComplete=false，不提前关闭功能owner。R01只能改这11路径及复制/删去表中五原位置，不写四协调文档/Host任意scratch。

F01成功后的完整g3精确23文件：上述16加根 before.json、source-results.json、capture-receipt.json、verification.json、verification-receipt.json、seal-receipt.json、manifest.json。最终 manifest.json 自排除，members恰22＝11静态+5归档+6功能JSON，每path/length/SHA绑定；不允许额外默认receipt、失败sidecar或helper。R01拥有11静态替换和五归档/五根删除；F01只拥有未来七根JSON的exclusive创建，不改静态或归档；V01/V02无项目写权，只有正常Harness记录。所有当前/未来成员在 Waves confirmedG3InPlaceRepairScope 锁定，禁止 glob 删除、猜文件或自行放宽集合。

原310-member R12、g1失败六文件、g2精确九文件、24-member contract、其它所有旧封包/原始测试日志/XML/JAR、278实现inputs及273旧inputs/67425历史成员/Git/记录external-env-Ruff仍保全。现行metadata两精确成员均属310包：projects/attempt04/1.16.5/minecraft-cache/common/version-metadata/1.16.5.json；projects/attempt04/1.20.1/minecraft-cache/common/version-metadata/1.20.1.json。不能制造client metadata或把两项目×两variant四闭包合并成两条。

### F0/F1/F2修正与消费合同

- **F0**：BUILD FAILED只取实际原01 stderr；stdout和stderr与原manifest逐path/length/hash绑定，旧失败XML/start/session/cause也绑定。真实正例是stderr banner、stdout无banner；缺失/截断/改单字节/交换流/其它attempt或summary，即使含banner也拒绝。只保留原01 native exit/endUTC永久unknown两值，禁止新阶段继承。旧daemon/hash解释错误，不引入该无据文字条件。
- **F1**：每实际版本项目唯一common metadata供common/client各自下载消费；id/download SHA1/size/URL和四逐variantdownload/JAR/probe/classes/resources等守卫不减。缺失、重复、错version或download不符均拒绝；准确missing-ID cause且无成功outputs仍必需。
- **F2**：所有新static/functional/default阶段的消费检查必须独立核对实际外层工具调用和返回的稳定locator（绝对session路径、record ID/物理行、toolCallId、对应toolResult及content位置）、完整command、显式Codev cwd、完整child argv/Python版本和可执行来源。loader构造的command字符串不等于真实外层调用；新receipt关联仍须真实外层记录。UTC为subprocess.run立即前/返回后且阶段顺序成立，明确不是OS spawn/exit instrumentation；真实child native0与loader最终成功策略（child0且stderr原bytes为空）共同成立，tool isError=false不能替代。每阶段保存完整stdin/loader/README或PREPARATION source(path/length/hash)，唯一块提取规则、尾LF恰一与源码逐字一致；两流原bytes/base64/strictUTF8/length/SHA全面自洽。交换stage、command/cwd/argv/Python/time/source/stdin/loader/任一流或摘要、重复/截断块及native0+非空stderr负例都拒绝。静态阶段前置归档/候选来源和完整whole域依赖按新16/23成员重派生，不调用旧PREPARATION直接回写协调文件。

verification.json **仍是实际新preseal stdout原字节**，不是拼造包装；其可读JSON必须显式声明verification-receipt.json及实际preseal外层locator/source/输入身份的关联，并由消费方把其所有字段、完整stdout和旁侧receipt实际逐字核对。receipt写入发生在child返回后，不能把其最终自身hash预嵌入stdout产生自引用；以固定receipt路径、真实stage/来源/locator和随后manifest绑定形成可验证双向关联。合法preseal candidateFunctionalComplete=true、ownSealChecked=false、overallR12AComplete=false，不回填历史空JSON为true。

seal必须消费完整新capture/preseal回执且preseal stdout等于verification原字节；seal child native0/stderr空返回后由同一实际loader保存seal-receipt.json，再一次性生成最终22-member manifest——**在seal receipt落盘前不得声称最终seal已完成**，不能遗漏该receipt/把manifest自身列入成员或用第二次subprocess重试。静态freeze同理先保存真实freeze receipt再最终固化15-member static subset。默认仅只读精确22成员/manifest，重新完整核验278输入、310原包、final04真实命令/两流/XML/工具链/四闭包/负例及capture→当前限定域保全；成功default实际输出才可ownSealChecked=true、overallR12AComplete=true。sealed verification.json的preseal false值保持不写回。F01 completed只支持合法候选+真实seal，不表示default或W08完成。

### 默认完整回执保存与T0限制

V02实际执行默认入口一次，冻结loader须输出**完整default receipt**（全部stdin/loader/source与两流raw/base64/UTF8/length/SHA、command/cwd/argv/Python/UTC/nativeexit等），正常Harness session JSONL保存；不能只输出NATIVE_RECEIPT摘要或只留下内存对象。Result给出实际outer-call/return及完整default receipt稳定locator，并绑定g3最终manifest length/hash、实现278 identity及实际default stdout。若工具换行转换/自动overflow，则实际可读取完整Host输出的稳定绝对locator和可重建raw-byte/base64身份也必需；若只能摘要或截断缺正文，V02不得completed。不主动新建Host任意文件，也不创建g3/default-receipt.json或排除新接受目录：避免sealed写回和未接受C白名单。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 整个capture→seal→独立default的tuple固定于新合同字节；独立default在**T0（seal后、任何coord运行状态投影/R13副作用前）**对whole限定域和tuple当前树等式成立。新graph的历史R12A字段只是历史，不应保留旧程序的“活跃R12A必须missing/not-run”硬编码；检查新四项合同/冻结字节，不伪造未来completed。当前未接受B归档替代实际重放或C投影后新白名单。R13依然需要其独立README-default实际重放及fresh五模块/24项/direct closure/ABI/Forge；其消费/投影时点未settle，不能静默删除重放、回滚coord/清生成物模拟T0、复用T0保全冒称最终R13树。该后继问题没有反向依赖于本次准备，单独透明报告，不在本Plan选择方法或启动R13。

### 验证、依赖及完成边界

重要依赖是原W02已接受gate及R04/R05/P01/P02/R06A/R06B/R07七项有限完成依据（Waves分别记录已有provenance/ref，R06A/B rawpartial与accepted功能completed并存）。新四项未发生，任何prepared/status文字都不是执行或Router release。本Plan不另列task层；项目写冲突R01/F01及其间只读观察须按唯一图严格串行，默认输入不变期间也禁止coord投影。

本次只做标准库目录/JSON/JSONL/原字节摘要及纯图检查：same tuple、Plan恰一Waves/反链、实际wavesGraph/items54/8、唯一ID/verification ID、所有item/gate及可读refs可解、active/historical membership、联合62-node DAG无环且W08不经R13/W03自依赖、owner冲突串行、旧runtime/result字段不改、R13原消费要求不减。直接会话交付和四文档是准备结果证据；没有额外项目verification文件。后继各item的实际正负检查和成功证据只由其自身Result成立，不被这份Plan提前完成。

未执行static/loader/helper/capture/preseal/seal/default、Gradle/项目测试/LSP/Ruff/下载/metadata/Git，不消耗新功能窗口。风险是候选尚未修复和执行、功能可能仍失败、完整保全为分时非原子而非全Host；新失败不自动重试。当前限定域内容保护和更广namespace观察范围在Handler Result如实分开报告，不把metadata census说成全部历史字节验证。


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

### 当前最小策略、依赖与完成合同

只在 Waves 分解：将原 R12 移出活跃 Wave.items 至明确历史成员，原谓词/证据不变；新增 R12A 与独立 W08，R13 仅替换必要主动前置及证据消费关系。W08 建立本轮主动 vanilla 功能前置；W03 仍建立完整 G1 功能，W04/I05 独立审计、W05/I06 普通文档及另确认 W06/Git 保持。

本次完成谓词仅是四文档/唯一图局部合同一致且静态证据保全：全部 stable IDs/refs/ownership/conflicts、活跃/历史分区、item+Wave 联合 DAG、W08 无自身 release 或 R13/W03 等待、278 输入/原 310 seal/历史/Git/环境均可重放核对。R12A/R13 运行细节和所需证据只在 Waves，不在 Plan 建第二图。

**Plan 的“每次验证留 exact command、退出码”原义保留**；唯一历史例外是指定 attempt01 不可恢复的 native exit/endUTC 不阻断新 R12A 的主动功能谓词，绝不把工具值填入或抹除原 R12 未满足事实。02–04/未来 native 执行与只读核验的真实命令/退出仍完整记录。静态入口 exit0 仅本次派生文档/保全谓词，不代表 fullStrictScope 或 native 功能门禁。

代价是原首 attempt 永久不完整、未知 Ruff 与 g3 执行历史仍不可认证。保持原包与 before/after 身份而非补造/重封；若将来输入/证据变动、例外超界或 authority 矛盾，停止并返回证据，不自行重跑/修复/放宽。没有 scheduler、registry、receipt persistence 或自动状态推进。

## R12基线图初始准备记录（历史）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。本轮只更新四份协调文档及 最小静态证据（历史原件不可访问；见顶部保留说明），不创建测试、不执行 Gradle/测试、不接受功能完成。

- 当前链为 **G1-I04E-R12 新基线五文件实施与聚焦验证 → G1-I04E-R13 独立最终五 module check/全24项 A/AC 验收 → W03 → I05/W04 → I06**。R12 是唯一新增候选 ready 实施项；R13 只有在 R12 完整实测 Result 及独立核验获接受后才 ready，partial 不满足前置。I05 的 scope、prerequisites、requiredEvidence 均消费同一 R13 最终树结果。W03/I05/I06/Git 仍未放行，本图不派发后继。
- 用户已接受用新当前 API vanilla 基线替换本轮旧 vanilla 证据分母：固定 **Gradle 9.4.0、既有 JDK17、MC 1.16.5/1.20.1，每版 common/client resolve→compile→package**；不是取消公开支持，也不承诺 selector 等价语义或新增 Core 支持。旧 Maven selectors、八 pipeline、Gradle 8.2/8.6/8.8 **本轮不计入且未验证**。
- 唯一 legacy skip 例外是已 Disabled 的 **Basic Minecraft Build()**，不计 vanilla 成功；原四空 pass 不构成行为证据。不允许 class disable、filter 或其他 skip。Core Test Java11 launcher、nested Gradle/编译17、Forge 原双 fixture 逐 fixture 真实 Java8 编译分层不变。
- 历史 R09 保持 raw/accepted partial、R10 保持 missing/not-run、R11 保持 raw/runtime/accepted partial；R09/R10 旧零 skip 完成谓词及原 receipt 封包仅历史，不再要求 R09 completed，不将 R11 窄停用目标改成 completed。unknown Ruff、**fullStrictScope=false**、**g3unknown**、历史失败及默认 exit1 全保留，不以分母调整解除严格范围限制。
- 当前未改动的 **273-input / 489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e** 仅历史锚。R12 创建后必须按实际成员/path/count 重绑新 identity，R13 在同一新最终树验收；未创建前不称为 278。完整五 checks、A1-A12/AC1-AC12、P01/P02 direct closure、core ABI、封存旧 caller 精确 debug 保全、原 Forge 真实闭包不可削减。
- 权威复核已 settle：PRD/Spec/同一 ADR 三 family 均 reuse，update/create 均 skip，不写 authority。具体执行越 owner、需要额外依赖/支持承诺或新阻断时停止并返回证据，不自动修复、安装 JDK、改版本/环境/Git。

### 当前策略与验证，不另造分解层

1. R12 单一 Result：严格五文件 current API 新基线 + 实际聚焦验证；每个版本 common/client 从真实 resolver 到 fresh 编译/封包。新测试自有冷目录/cache、禁用 build-cache 复用、必要官方下载，验证准确 missing-ID cause 及失败后无新成功 outputs。保留所有原 tests/fixtures/Disabled/Java 层次，不修改生产或 build dependencies。
2. 接受 R12 全部实测及独立核验后，R13 单一独立 Result：冻结并重绑实际新 input members/count/identity，原全五 check 的命令序列不删减，全 A1-A12/AC1-AC12 及 P01/P02、ABI/旧 caller、Forge 逐 fixture native Java8 compiler 绑定同一新最终树。唯一 Basic skip 不计 vanilla；其余无过滤/disable/skip，四空 pass 不补行为覆盖；includes NO-SOURCE 如实记录。
3. R13 完整 completed 经独立核验才可判断 W03；I05 独立正确性审计消费同一 R13 固定树。R12 聚焦 green、历史窄成功、任何 partial/blocked/failed/missing 均不能释放 W03/I05/I06/Git。

历史验收矩阵中 vanilla 的旧 selector/八 pipeline/三 Gradle 参数只作历史方法；本轮 vanilla 子分母仅用上面已接受的新基线。其他全部权威行、直接闭包、精确 debug 与 fresh/native/compiler/cache 谓词仍有效。原 R09/R10 的零 skip 谓词在历史 item 内原样保留，不套到本轮唯一 Basic skip 例外上。

当前 writer 仅执行静态验证：四协调文档唯一变更、reciprocal links、prose/JSON 一致、49 stable items/7 Waves/唯一图、item prerequisites 与跨 Wave gates 的联合无环、五新 outputs 非 inputs、排他 conflict、新 ready/未 ready 原因、273 实现输入/旧证据/Git 保全。缓存漂移独立披露不修复；raw exit、static graph/related readiness 与 fullStrictScope 分开。此策略没有已执行 runtime evidence。

## 历史协调记录

### R11 generation4结果（原核验后状态投影）

R11已实施单方法停用并完成g4唯一新授权的原core:test；`lastResultStatus=partial`、`runtimeStatus=partial`、`acceptedCompletionStatus=partial`，不是完整completed。Router仅接受“单Basic方法停用并明确skipped”的窄目标已验证，不接受严格整体完成，不释放任何Wave门禁。本writer只更新四coord，不再运行Gradle/测试或旧verifier，不写Todo/源码/权威/证据/Git。

g4完整事实（历史原件不可访问；见顶部保留说明）、native receipt（历史原件不可访问；见顶部保留说明）与逐case/class分析（历史原件不可访问；见顶部保留说明）：PowerShell/cwd匹配的原core:test实际一次native exit0，UTC `2026-10-09T03:35:48.3806936Z–03:36:17.5186658Z`，test与compileTestKotlin实际EXECUTED；fresh五case恰4pass/1skip/0failure/0error，唯一skipped为原Basic Minecraft Build()。fresh compiled class仅该方法具有原plannedDisabledReason的Disabled；`xmlSkippedReasonProvided=false`，XML仅`<skipped/>`，不是XML输出reason。四pass方法仍为空，不证明Core行为或vanilla；原body/fixtures/8.2-8.6-8.8 loop及其他Core/Forge测试保留，skip不执行三版本循环。

Router已独立执行g4默认只读`verify.py`：实际exit1、errors=[]、`focusedChecks=true`、`fullStrictScope=false`、`detachedVerificationReceiptChecked=true`；29新sealed成员/16旧sealed/20旧R11文件/9ledger/273inputs/281protected/52Git匹配。exit1来自已披露unknown Ruff严格scope限制，不是整体checker通过或native测试失败。当前273-input identity为`489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e`；041锚仅为历史source-edit前身份。g1/g2机械失败及raw partial、g4准备KeyError均保留，g3执行历史仍unknown，不称g4首次执行或自动retry。

唯一图仍47items/7Waves；全部依赖/owner/verification/completion/release predicates不变，W07亦不释放。R09 raw/accepted partial、R10被原前置阻断且not-run、原vanilla/三版本/五check/24A-AC缺口及W03/I05/I06/Git未释放保持。PRD reuse、Spec reuse、同一ADR skip写update沿用，只读不改权威；暂停不是fixture/selector/API修复。

四coord新字节是Router核验之后已授权的状态投影；旧快照/manifest/verifier全部只读，不重封或宣称旧入口对更新树的current-tree等式仍成立。下方旧“当前/准备/ready/未实施/未运行”说明及JSON中原preparation/未来输出措辞仅保留历史定义；现时R11事实以本节与其结果字段为准，旧完成谓词保持原义。

## R11初始暂停准备记录（历史）

同一[Work](work.md)、[Context](context.md)与唯一匹配[Waves](waves.md)派生一个有界暂停，不另建Plan/tasks或修改权威。当前用户在ordinary披露之后明确确认单方法临时JUnit停用并实际验证；当前Handoff只准备图，不实施。逐family PRD reuse、Spec reuse、同一ADR skip写update由Context承载。

最小策略是在唯一core测试宿主保留完整旧body/fixture与其他tests，仅给一个方法增加明确temporary停用理由及必要annotation/import；后继沿原core:test现有配置fresh验证唯一skip，而不是绕过filter、修API/迁移selector/做compat实验。所有source owners/允许diff/命令/XML逐case谓词与verification ID由Waves独占，不在此建立第二分解。

采用独立暂停Wave，不依赖尚partial的原修复完成；原已completed基础及可读Root/CP/失败证据足以建立新暂停的结构前置。原功能W03、独立审计W04、普通文档W05与另确认Git W06仍共同按旧predicate建立原Plan结果；新W07只建立临时暂停，不释放或替代原任一gate。共享source/Gradle/TestKit/generated/Git责任必须串行，readonly材料不构成写冲突。

代价是红测不再执行、vanilla/旧selector行为继续未验证，不是修复完成或降低support承诺。保留全部旧失败/Raw partial并绑定source新identity与fresh case，unknown Ruff严格scope单列失败，不清理/rebaseline。当前不添加自动恢复/到期机制；重新启用须另有明确修复/验证边界，不能自动回滚/恢复去掩盖原失败。材料规范矛盾仅停止受影响范围并条件加载spec-driven-development。

当前唯一准备结果是四份派生协调文档与独立静态证据（历史原件不可访问；见顶部保留说明）；不实施源码或执行Gradle/Java/tests，不写Todo、不委派/接受/释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`，Root已存在launcher1.9.0-M1；原R09 raw/accepted **partial**（5tests/1failure/0error/0skip）、R10 **waiting/not-run**、W03/I05/I06/Git未ready保持。新暂停完成也不释放这些原gates，不将原五fresh全部pass/旧selector/三版本谓词降为skip通过；vanilla仍gap，`fullStrictScope=false`与unknown Ruff历史保持。

仅新增一个暂停item `G1-I04E-R11` / `VG1-POST-10`，置于同图独立 `G1-W07`（前置原W02 gate），不是第二Plan/graph。原46items/6Waves保留，现47items/7Waves。R07及必要既有accepted基础和W01/W02 gate是completion前置；已验证R09 Root/source/CP失败只为readonly证据，不要求R09completed，不要求先修旧fixture。静态structurally-ready不是native完成或Router放行；当前唯一新可readyitem为R11，所有执行细节只在[Waves](waves.md)。

旧experimental/fixture repair方向明确 **deferred**；compatibility proposal **cancel-proposal（从未启动）**，被本暂停方向取代，不将用户取消记为completed，不删旧失败/身份。原root单行许可及旧writerPermission仅标注历史preparation，不给当前writer源码权限；后继仅R11该方法annotation/import例外，其他host/fixture/Forge/root保持readonly。以下所有旧“当前/最新/ready/宿主只读/未运行”文字按原记录当时理解，不与本首节竞争当前范围；旧图原完成谓词仍有效，不能从历史文字放行。

## R11准备前协调记录（历史）

下文完整旧记录保留其原义；当前实施许可仅以本首节和新R11 scope为准，原norm/原completion与失败仍不变。

## 当前root launcher维护与独立最终验收策略

用户最新ask“授权查询及有界候选修复/重验”已确认，`D-G1-JUNIT-LAUNCHER-CONTINUATION` 只许可root共享测试依赖一条launcher1.9.0-M1及串行对应验证；原文档准备已结束并保留raw partial。R09已按许可单行实施，首JUnit discovery成功，但原core:test fresh五项仅4个原空方法通过，Basic Minecraft Build首Gradle8.2阶段19条script compilation errors，8.6/8.8未到达；Router独立核验exit1/errors=[]/54成员及272其余inputs/Git/旧包保全，R09 raw/accepted partial、unknown Ruff fullStrictScope=false。R10仍必须等待真实R09 completed，不放宽五check/24row/worker/ABI谓词。新的fixture/API/Kotlin DSL失败仅先只读诊断，不获新owner/version/assertion/production写权；原冻结包和Bash/PATH失败保持，只投影当前结果而不重放旧等式。原生依据见R09（历史原件不可访问；见顶部保留说明）。逐family **reuse/reuse/reuse** 及完整诊断/review/query限度见[Context](context.md#当前精确用户许可query证据与authority复用)，PRD/Spec/同一ADR只读。query实际offline metadata成功但raw partial/默认exit1/unknownscope保持；没有“补一行必过”的证据。

最小策略是先在原共同依赖owner恢复test-only runtime，再在单独固定最终树窗口验收；不逐module修声明、不升级API/engine、不删成功模块launcher、不改fixture/测试/断言/算法或五fork。第一修复的focused regression必须真实执行原core:test、原五测试及原TestKit循环，新afterTaskCP/selected train与新Java11 executor/Java17 GradleVM绑定；候选不足或后续fixture失败保留failure/rawpartial并停止，不修other owner。后继正常获取仅既有coordinate/原distribution，不安装JDK/换版本/全局配置。

focused成功不是G1 gate。独立终验在R09真实completed及所有既有必要基础成立后，同一新最终273input identity fresh重跑原五module check、全部A1–A12/AC1–AC12、P01/P02必要direct closure、当前coreABI/封存旧caller二进制及原Forge两fixture真实Java8编译逐fixture配对；原断言、精确R06B LNT及cache阶段FROM-CACHE→fresh consumer门槛不降低。旧62tests、24partial、PASS/XML/UP-TO-DATE/metadata或manifest不代替runtime，includes NO-SOURCE单列。

唯一[Waves](waves.md)新增R09/VG1-POST-08与R10/VG1-POST-09，一item一Handler/Result，R09→R10显式串行；源码/配置/Gradle/TestKit/generated输出/Git责任禁止并行，旧query/R08只历史且不作为completed前提。W03/I05仅指R10最终结果，W04/I06与Git另确认保持。**R09 structurally-ready；R10 waiting；两项not-run；G1 gate=false。**本段仅策略，item predicate/owner/verification/ref由Waves独占。

风险是首机制supported非唯一cause、缓存/静态major53非worker可见性、原第五TestKit可能暴露后续legacy/download边界与unknown Ruff strictscope。最小措施为分层真实after/worker/fresh证据和fail closed；不自动rollback隐藏失败。若Router另决定撤销，仅撤销本item新增root单行并保留raw证据，不回滚其他输入/清cache/改Git。material authority问题只停止受影响范围、加载spec-driven-development返回证据。静态准备封包（历史原件不可访问；见顶部保留说明）为当前默认只读静态验证；原R08/defaultexit1/编码恢复/2367/167/176/53/2373+12/63封包及全部rawpartial保全，不重封。

## R09准备前协调记录（历史）

以下保留原协调记录/原义及其当时“当前/最新/ready/missing”措辞，不是现时执行状态或新增许可；当前scope/状态以上节为准，唯一执行依赖以Waves当前JSON为准。原Result/完成谓词/失败证据不改写。

实施范围已由用户选择“按计划完整执行”确认；当前在 `g1/mixin-rework`，前置 I01–I03 已完成。本阶段禁止 stage/commit/merge/push/publish，具体执行状态以 Waves 为准。初始规划中的未决表保留为历史披露，与当前已确认状态冲突时以 Waves 的授权及完整 Result 记录为准。同目录 [Work](work.md)、[Context](context.md) 和唯一匹配 [Waves](waves.md)；没有 overview、sliced pair 或历史 Tasks。本文件给出连贯策略与验收，Waves 独占 item 分解、依赖、冲突及放行规则；这里的段落次序不产生执行依赖。

## Post-V01最小串行策略

本轮图准备仅产生四派生coordination文档与新静态证据；以下未实施叙述为当时准备状态。后续R06A已按授权实施并由Router接受功能完成条件，raw partial/strictScope失败保留；R06B按精确LNT澄清后的功能谓词接受，raw partial/原strict-debug失败保留，R07已独立核验completed，R08 generation1/2 partial已由补充入口独立核验，core:test启动阻断。最新 `D-G1-CORE-JAVA8-CONTINUATION` 用户许可只扩大 Context 明列 core17/7destination/4JvmName 与原宿主单一 nested argv；原 D-G1-TASK-DECLARATIONS 和 G1 必要直接补证许可按原边界保留；五fork/tools/dependencies/子类cache策略均保持，不再版本bump。先前check/patch准备与旧missing叙述保留为历史，当前状态以唯一[Waves](waves.md#当前执行状态router)及[Context受影响评估](context.md#post-v01当前权威与必要闭包)为准。仅接受R06A内容修复/compile/PSI/inputs完成谓词，不宣称strictScope、full core lint或G1通过。严格缓存失败见R06A证据（历史原件不可访问；见顶部保留说明），不清理/恢复/授权缓存，不释放W03/I05。

R04已completed作为冻结起点。历史串行策略 **R05三声明/两native validator → P01操作/producer闭包 → P02消费端/provider/原基线闭包 → V02新最终identity独立全五check/全矩阵** 已执行到 V02 partial；后续经用户精确授权的 continuation 为 **R06A 内容规则 → R06B 命名/API保全 → R07 nested TestKit Java8 fresh编译观察 → R08 新树独立最终全五check/全矩阵**。R06A/R06B/R07/R08 只在同一实际树上串行推进，旧 partial/failed evidence 不改写。

| Verification ID / 节点 | 最小证明与来源 | 完成边界 |
| --- | --- | --- |
| `VG1-POST-01` / R05 | 三class own DisableCachingByDefault及import；core/includes native validatePlugins真实rerun exit0，各`[]`；exact diff保持getter/action/ABI/provider/子类cache | class维护完整Result；不兼G1/五check |
| `VG1-POST-02` / P01 | 现有MixinPreapplication/InputBinding/Mapping/FailureStage四suites：真实cache producer TaskOutcome.FROM_CACHE恢复pair→fresh consumer首次SUCCESS、同JVM remapper A→无mapping但有配置的B、实际child engine/ASM provenance、三unsupported failure语义 | producer/operation必要闭包Result；不兼最终matrix |
| `VG1-POST-03` / P02 | 现有exact/safe/input/legacy/Fabric/provider/metadata suites与单planned Forge baseline test：exact身份保持、双target全成功consumer删除；fresh Fabric；第三方显式拒绝+legacy；旧Gradle registerTransform真实artifact resolution；有界AT/nested原能力 | 消费端闭包Result，绑定真实producer/record/source/cleaned；不扩生产scope |
| `VG1-POST-04` / V02（历史终验谓词，latest partial） | 新最终identity五模块check实际exit0 + 全A1–A12/AC1–AC12、inputs/cache/legacy/metadata/mapping/retained baseline current matrix；native validation/lint、fresh XML零失败/错误/跳过、finally/end身份保全 | V02原终验谓词/Result仅历史；当前接受由R08/VG1-POST-07承担，未释放W03/I05 |

cache证明复用现有TestKit生成fixture/local build cache：producer先正常实际成功，保存target/record绑定；只移走本fixture生成的outputs并实际`--build-cache`恢复，nested cache阶段禁止`--rerun-tasks`以确保观察真实`FROM-CACHE`。fresh consumer在新destination首次执行，reopen源配置并调用target；真实原始artifact binding必须相同，不能用随意换path或旧输出冒充。外层suite执行加rerun取fresh XML，与nested缓存语义分开。保留configuration-cache，fresh consumer不许UP-TO-DATE代替运行。

remapper隔离复用现有mapping/engine-chain测试，A有真实映射/注入和plugin身份，B在同一JVM无mapping但实际使用未映射config/目标（避免仅空config漏观测remapper）。原no-config/side/plugin隔离既有正向断言继续用fresh结果复用。operation provenance从真实OperationRunner.Domain child加载的MixinEnvironment/ASM ClassReader/ClassVisitor和适配类采集CodeSource、resource/JARhash/package/bytecode支持版本与委派方向；外层9.9.1 metadata与child9.6不能代替这个闭环。复用现有failure-stage fixture，分别触发unsupported class major、engine-invalid配置及unavailable injector，保留native cause/identity与success absent/no published pair；不upgrade ASM/engine、不引入生产诊断API。

exact/双target复用真实producer+selectiveConsumer：compact/pretty Foo/FooExtra/另一package、side/unattempted/unknown nested字段和resources逐一reopen，all-success两target只有完整消费entry/config/reference消失，原partial/failed/residual拒绝继续fresh观察。FabricApplicabilityRepairTests现已有providerChainReexecutesOnSideAndEnvironmentChanges，接fresh服务/provider与真实输出即可，避免镜像测试。test-only第三方all-delete-only provider在fixture jar隔离接线，同handler selective显式unsupported且无发布，legacy真正删除并可用。

A1与baseline补证边界回原authority：Spec A1/PRD AC1要求旧注册/执行，新增仅真实registerTransform和artifact resolution观察，旧直接legacy结果保留；Spec Authority and boundary/PRD Scope R10/AC11要求touched AT/patch/nested ordinary能力保留。P02沿现存TransformerProcessor.main非空AT操作观察access变化，将产物与真实G1前后/现有task wiring及最终原PatchedMinecraft双fixture结合；nested验证payload bytes/metadata及原JarJar list/remove/cleanup语义。这个有界证明不认证全部AT规则、全Loader矩阵或新nested政策。Forge baseline test在P02原准备中是planned output；P02已completed并已创建该文件，当前可读且只读保全，不授权新增baseline/test owner；其余test/resource owner均现存。发现不可达原入口或未知生产缺口只blocked受影响覆盖，不偷扩写权。

历史positive复用只能复用方法与原义required assertion，不能继承旧PASS/XML；R08在R06A/R06B/R07后同新树fresh XML testcase/command/timestamps/actualTaskOutcome与target+record+source+cleaned/JAR/resource内容、binding/hash和失败native日志相互对应。原V02接受P01/P02的同identity设计保留为历史；R06B七rename将产生新路径identity，R08必须同最终树fresh复跑必要producer/direct suites或fixtures并重建closure。不得用历史PASS、旧XML、UP-TO-DATE、manifest或audit supported替代需要的runtime。

R08固定R06A/R06B/R07后的新最终tree用五模块check加`--rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain`真实运行；全部最终A/AC行从本树fresh命令/XML/运行artifact追溯，任何partial/blocked不能称gate passed。Post-V01旧准备before/after272为历史锚；本轮当前锚为273/373f897c…，七实体rename后的真实路径与新identity如实绑定，不授权新增test owner。V01原Result partial/失败包与原predicate历史保留，Fabric/Forge validator FROM-CACHE误述以native log为准，仅本新文档披露不编辑旧包。R08 continuation 还必须在 R06A/R06B/R07 后捕获新 identity；不能用旧 V02、P01/P02 或 UP-TO-DATE 观察替代同树 fresh closure。

每个后继只写其精确owner与独立新evidence目录，不再bump五fork、不改tools/deps/root/settings/AT/nested或未知production。PRD/Spec/同一ADR按Context reuse。原静态graph与全repo/旧sealed/Git保全证据post-v01-repair-plan（历史原件不可访问；见顶部保留说明）仅保留历史；当前默认静态核验见v02-core-java8-plan（历史原件不可访问；见顶部保留说明）。R06A/R06B/R07/R08当前验证ID分别为`VG1-POST-05A`/`VG1-POST-05B`/`VG1-POST-06`/`VG1-POST-07`；旧`VG1-POST-05`仅历史，不构成runtime通过或执行许可。

## R08 当前 partial 的已核验事实

R08 generation1/2 的完整 Result 均为 **partial**；Router 独立重跑 verification-recovery/verify.py exit0，原2373封存成员、12补充成员、两final-receipt日志、273输入/authority/历史/Git/环境与临时属性保全通过。原verify.py成员集exit1和2367-member旧日志保留，不改旧seal。当前identity仍为 `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`。实际mixins/Fabric/Forge check通过；core:test不能加载JUnit Platform，core/includes check未到达，overall exit1；15 suites/62 fresh tests零failure/error/skipped不包含core执行器成功。24行partial、direct/coreABI/逐fixture Java8配对仍未闭合，functionalGatePassed=false、fullStrictScope=false，W03/I05/I06/Git不释放。接下来仅只读诊断JUnit运行时加载边界，不授新增依赖/源码/config权限，不运行Gradle或自动重试。证据见R08（历史原件不可访问；见顶部保留说明）与补充校验（历史原件不可访问；见顶部保留说明）。

## R07 已接受与 R08 固定树验证策略

R07 generation1完整Result completed已消费；Router独立默认只读verification.py exit0：单一nested --rerun-tasks diff，原双TestKit fresh2/2、两个compileJava/fixture jar实际EXECUTED且各自Java8 worker编译栈/工具身份/父TestExecutor/重建窗口绑定，major52及compiled class/JAR逐字节一致。临时generated JDK8发现属性finally精确恢复原不存在状态，继承环境受限摘要/outer属性保持；其他272inputs、64297历史文件和Git保持。273-input identity `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`；89新成员保全。内部forge-patch-8/mappings-3/remap-4命中自有缓存，不宣称这些内部action重做；unknown Ruff漂移披露，fullStrictScope=false保留。R07 accepted completed，R08成为唯一runtime-ready节点；新树终验仍须fresh五check/全A-AC，不能继承旧XML/P01/P02/PASS，W03/I05/Git不释放。 依据R07（历史原件不可访问；见顶部保留说明），原R06A/R06B raw partial/strict失败及所有历史封包继续只读。R08只验证不修复；开始冻结新273-input identity，五check、原双TestKit actual compiler、必要producer/consumer/isolation/compatibility和完整矩阵逐项绑定当前树。旧默认verifier依赖旧current-tree equality时不得重跑，改用冻结manifest/member/detached receipt保全历史。未知新阻断准确partial/blocked，不取得额外owner。

## R06B 精确调试契约澄清与当前接受

R06B generation1 raw Result及原默认verifier exit1保持partial，原strictDebug=false与strictScope=false均未改写。Router独立复现新审阅入口exit0，13审阅成员摘要匹配：158对class，八类28methods/166项LNT恰+2、逐table count/order/BCI不变，其余150类行号保持，rawCodePayloadDifferences=0，runtime/API/metadata归一化等价158且module bytes相同。PRD/Spec/同一ADR reuse，无需新权威或同范围重复确认。仅补齐已授权四个两行file注解的精确生成调试效果；stacktrace行号/调试定位可观察变化如实披露，不能称class byte equality。Ruff未知writer漂移仍strict失败、不清理/恢复/授权。Router按澄清后的功能谓词接受R06B完成以接续R07，不宣称strict scope或G1通过；273-input identity `477d38dd2e0b4604d4f67a04c5e84fc5b6e72b61ccbbd0c7ac2f7c9056fdeb00`，原2024成员及13新审阅成员保全。R07 ready，R08/W03/I05仍等待。 仅补充本次八类/28methods/166项原line_number+2，逐method/table条目数、顺序及start_pc/BCI保持，其他条目保持；精确class列表、当前identity及封存old/new bytes绑定由Waves维护。依据独立覆盖评估（历史原件已删除；原路径 `evidence/g1-implementation/r06b-debug-contract-review/report.md`），不创建或改写PRD/Spec/ADR，也不改旧包/脚本/receipt/exit1；不是忽略全部行号/debug。现有compile/JAR/lint/validators和旧caller链接证据仍要求成立。本澄清闭合debug功能谓词，不闭合Ruff strictScope，不释放R08/W03/I05。

## V02 partial 后授权 continuation

用户最新选择“授权两项最小扩展（推荐）”，`D-G1-CORE-JAVA8-CONTINUATION` 已确认，**未实施**；无需重复审批。该许可只对两项精确新增范围解除旧只读限制，完整策略与所有权清单由 Context/Waves 约束：

- **R06A(content) strategy / VG1-POST-05A**: 仅修复32条内容规则；原17owner中14个有内容违规，另三个filename-only文件无需修改。不rename、不加JvmName；native core compile exit0与语义等价，fresh原生lint预期exit1且恰余七原filename、无其他违规。残余由R06B闭合，不宣称全lint或final gate通过。
- **R06B(rename/API) strategy / VG1-POST-05B**: R06A completed后仅七实体rename与四显式JvmName必要相邻注解格式。四fixed＋三默认facade实证；三case-only经唯一临时basename两步实体rename。迁移前冻结facade/JAR/API/default桥/Kotlin metadata/旧caller，迁移后core compile/JAR/core+includes validatePlugins/core lint均exit0及旧binary链接。SourceFile/SMAP/source-JAR路径差异及Waves精确八类166项LNT+2限定效果允许，原strict-debug失败保留；不重编旧caller或新增项目owner，不移走/清cache；incremental失败partial。
- **R07 nested Java 8 fresh 观察**：仅修改 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt` 的 nested `GradleRunner.withArguments`，增加 `--rerun-tasks`。不改 fixture、源、断言、版本、toolchain、classpath、生产实现或 patch/remap。保持 Java17 outer/现存JDK8，不清cache。优先 launcher CLI `--no-parallel --max-workers=1`；若设置 child `GRADLE_OPTS`，先记录 before 原值存在性/受限摘要，再 child copy 合并，argv/进程环境不泄密。generated TestKit home 的临时发现属性记录 before/effective/finally，精确恢复原存在状态/bytes/hash。原双TestKit须真实2/2，nested compileJava须实际执行，Java8 compiler/toolchain与对应原fixture关联；major52、JAR/patch/remap reopen只是产物一致性，不替代compiler证明。
- **R08 最终重验**：只写新 evidence；在 R06A/R06B/R07 完成后的实际 identity 上重新执行五模块 `check`、P01/P02 必要 direct closure、Forge 原双 TestKit 和全部 A1–A12/AC1–AC12。旧 V02 partial、R06A/R06B/R07 失败和环境限制均保留。

R06A 的 completed 前置只有 P02 与最新许可；两只读诊断来源和 V02 partial 归 historical evidence，不能要求 partial completed。R07依赖R06B completed；R08依赖R06A/R06B/R07 completed。R06A → R06B → R07 → R08 串行；任一超出 owner、ABI 无法保全、Java 8 compiler 未实际观察或出现新未授权生产缺口时，仅阻断受影响节点，不扩大依赖、版本、其他 owner、权威或 Git 写权。R08 完整 completed 并经独立核验后，才可重新接受 I04E 和释放 W03/I05。

目标是完整交付既有 G1 Mixin 预应用链：每操作隔离，在任务域解析插件/类/资源，生成与实际完成输出绑定的精确应用记录，再仅清除已被完整消费的 runtime contribution，并支持精确方向的可选映射与 Fabric/Forge/NeoForge 元数据。保留普通无映射 `Mixin`、其 public inputs/side/output 默认，以及 `StripMixins : TransformAction<TransformParameters.None>` 的明确全删语义。

[Active PRD](../../prd/codev-mixin-rework.md) R1–R10 / AC1–AC12 owns 产品结果；[Active Spec](../../spec/mixin-preapplication.md) C1–C8 / A1–A12 owns 行为及失败契约；[Accepted ADR](../../adr/mixin-operation-isolation.md) 是同一既有 operation-isolation 决策。[Context 的逐 family 评估](context.md#当前依据与权威评估) 为 reuse/reuse/reuse；无需改权威。公共属性新名字和 compact local records 编码是 Spec 明确留给实现的选择，不应新造 ADR 或公共协议。

仅规划 G1。排除 G2–G5、class-tweaker/AW/AT 政策扩展、shared remap cache/lock、MappingService 重用、includes identity、launch/native/IDEA、旧 Loader 恢复、相邻 Cloche 改线、远端 Git 与发布。触及现有 Forge/Fabric 文件须保留其他 metadata 和现有 AW/AT/patch/nested-JAR 能力；这些是回归边界，不是本轮新认证整套 Loader。锁定 `net.fabricmc:sponge-mixin:0.15.0+mixin.0.8.7`；不自动捆绑/初始化 MixinExtras，不推断 Loader 版本限制。

## 最小连贯策略与所有权

只有一个 G1 功能交付 outcome；其 producer–records–selective-consumer 闭环、平台适配和 mapping 必须最终在同一 actual tree 上组合验证。为满足单一 Handler/Result 边界，Waves 保留核心链、Fabric/Forge metadata 适配、可选 mapping、实际变更模块版本配置、最终组合验收的 I04A-E 串行策略；核心链内部按已观察的安全缺口细化为独立修复、固定树聚焦复验、module check 与核心验收结果。I04B 历史 partial 暴露的外层 environment 丢失已由 R01 和独立 V01 completed 补证，Router 已重新接受 I04B；该返工不扩大 UNKNOWN/Loader precedence 承诺。I04C/D 也已接受。I04E generation 1 partial 暴露的校验/格式/旧 fixture 失败使用已确认最小维护例外串行修复，再由独立验证 Handler 在新固定树完整重验；不要求旧 partial 变 completed，也不将旧证据自动继承给新树。各实现结果附带自身聚焦验证，最终验收只验证固定树、不兼做修复。持久证据、构建前置、独立审计、普通文档和本地 Git 交付有不同终止条件，故在 Waves 里单列。完整 A1–A12 和所变模块 check 的总门禁不变。

| 所有权 | 具体允许影响面 | 行为责任 |
| --- | --- | --- |
| mixins | `minecraft-codev-mixins/src/main/kotlin/.../mixins/` 与其 services；module build/gradle.properties；G1 test sources/resources | public task 与新 selective consumer；operation loader/runtime；records/binding/publication；局部 capability；版本绑定 success adapter；mapping-io adapter。 |
| Fabric | `minecraft-codev-fabric/.../mixin/`；必要的局部服务注册与 G1 tests；module gradle.properties | 新 capability 的选择性 JSON 引用变更；旧全删路径仍可用。 |
| Forge | `minecraft-codev-forge/.../mixin/`；必要的局部服务注册与 G1 tests；module gradle.properties | blank token、安全的所有适用 metadata 同步；manifest/TOML load/save/close 与独立 reopen。 |
| root build 维护 | 仅决策后明确允许的 `settings.gradle.kts` 维护；实测需要的最小 launcher/toolchain 修正另行披露 | 缺失 legacy-forge include 的维护，不实现 legacy Forge；不顺手升级 Gradle/依赖/其他模块。 |
| ordinary docs / proof | 本 Work 的 evidence、后续 usage/results 文档与 README 的有界说明 | 可复现证据和消费者用法；不将 Work 文档改为权威，不更新 PRD/Spec/ADR。 |
| shared core/includes 最小维护例外 | 仅 Waves 精确列出的三个 getter owner（必要 imports/相邻等价格式）与各自 gradle.properties | IncludesJar.input NONE、IncludedJarInfo.file NAME_ONLY、AddClientSideAnnotations.directory 保守 ABSOLUTE；不改 ABI/identity/行为/缓存能力。已确认 core/includes fork 值及新增模块 check，非 shared 目录泛写权。 |
| Forge patch 最小生产恢复例外 | 仅 `minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/{McpAction,ResolvePatchedMinecraft}.kt` 与 Waves 单列的新局部 test owner | 在 rename/mcinject 前以 patched bytes 优先补齐 clean 缺失 entries；消除晚期错误 namespace 填充，PATCH_OPERATION_VERSION 7→8，不清共享缓存。原两 fixture/Java/宿主断言只读；宿主仅 R07 单一 nested argv 获精确例外。 |
| core新增样式/ABI保全精确例外 | 仅 Context 17原文件/7destination/4JvmName与其必要generated证明；R06A只32内容规则、R06B只七命名/API迁移，各自完成谓词独立 | 未实施；保留facade/API/旧caller/算法/声明/provider，不授权其他core/includes owner。 |
| Forge原宿主单一argv例外 | 仅PatchedMinecraftTests.kt nested withArguments增加--rerun-tasks；R07承担Java8聚焦证明 | 原fixture/Java/断言/版本/toolchain/classpath/patch/remap只读；不新建build root owner。 |
| shared core/includes 其余、remapper/其他 modules、相邻 Cloche | 只读（排除上面精确新增例外） | 重用 ZIP/JSON/helpers 与 mapping-io 版本先例；不改 shared handler ABI，不建立 mixins→loader 或 remapper-service 依赖。 |

### I04E 最小维护策略（历史已确认范围）

用户此前选择“授权最小扩展（推荐）”已确认共享输入注解维护、core `0.1.0+terrarium.0.7.2`、includes `0.1.0+terrarium.0.6.5` 及全五实际变更模块 check；最新“授权最小生产修复（推荐）”仅增加两个精确 Forge patch owner 及必要局部回归。受影响 family reuse 依据见 [Context](context.md#最小forge-patch恢复的受影响权威评估)，既有维护核对见同文件原节；恢复现有能力，不新增产品/架构/规范行为，不改 PRD/Spec/ADR。

按真实共享 source/config/TestKit/Gradle outputs 冲突串行推进：已完成输入注解/诊断 lint/R02C 补救之后，在 patch 的共享责任边界恢复完整输入并附最小聚焦证明；独立冻结新树重验原两个 Forge TestKit 后，才协调已授权新增实际维护模块版本，最后独立固定树完整验收。生产修复的聚焦证据与独立原测试重验有不同可观察 Result；最终验收只验证固定树、不兼做修复。文件级 owner、stable IDs、前提与唯一 completionPredicate 只在 [Waves](waves.md#最小forge-patch生产修复与独立重验) 定义；本段是策略，不是第二执行图。

validation 使用六任务诊断的八个精确 owners，四个 getter normalization 与五个具体 DisableCachingByDefault 声明（一个路径重叠），不启用缓存、不用 Internal/CompileClasspath 隐藏输入、不将目录改为未经证明的 RELATIVE。lint 仅诊断 27 文件；filename old/new rename 保持 package/function/type/API 及行为，先查路径硬编码。Forge 原 fixture 接线维护仅两个 build.gradle.kts，保留 1.12.2/14.23.5.2860、1.16.5/36.2.39、Java8 compile/Java17 TestKit 宿主、classpath、真实 patch/remap/JAR/Java 断言；原 PatchedMinecraftTests 必须实际 2/2，无 failure/error/skipped。原两个 fixture 与 settings、Test.java、测试宿主源码保持只读，只有 R07 原 nested argv 精确例外；不改生产 DSL。此前“不改 patch/remap 算法”的限制仅对本次明确的 McpAction.kt / ResolvePatchedMinecraft.kt 完整输入与 task 缓存版本责任解除，不泛写生产目录或改 mapping 方向。

所有新 evidence 仅各 item 独立 `evidence/g1-implementation/check-repair/<item-id>/`；旧 `final/` 和两诊断目录只读、不重建索引或重封。任何新树 source/config/tests identity 都必须重新证明五模块 check 与完整 A/AC；历史核心/平台/mapping 结果只作 provenance，不能无绑定继承通过。实际工具链或下载不可用准确 blocked，超出精确 owner 或出现规范矛盾准确报告，不顺带升级依赖、改 root/settings/其他模块或关闭任何检查。下一 ready 只报告结构事实；本次不委派/运行/接受/释放。

### 核心修复策略与当前证据

初始规划材料已由 I04A 核心验收和 I04B partial 产生实际结果；以下策略保留历史缺口与 authority mapping，不把未实施方案写成通过。当前 I04B 的真实失败已由独立诊断确认：Fabric 外层 environment 在 path-only discovery 中丢失，核心 discovery/execute/records/consumer 必须恢复统一 applicability-aware 绑定，Fabric 仅提供 exact environment 来源；inactive-only 来源必须保留，错误 SERVER 消费不得发布或删除配置。该有界 repair 复用既有 PRD/Spec/ADR 的 side/scope/retention 契约，不新增 UNKNOWN、Loader precedence 或任意 plugin 证明承诺。

核心策略按 crash-retry/publication、完整 ordered inputs 与 effective-options/origin 绑定、失败阶段/来源/义务精确归属、操作隔离与资源关闭、安全 untouched 与无贡献 plugin/parent 正例分别收敛。每个修复只承担其行为结果和最小聚焦证明；共享 records/runtime/publication 与 fixtures 写入串行。随后对固定核心树做完整核心聚焦复验（含 legacy/empty/cache restore），再取得同树 mixins module check，最后由 I04A 只读核验全部细分 Results/覆盖并接受核心结果。具体 stable IDs、路径、先决项、完成谓词和 evidence 仅在 [Waves](waves.md#核心修复细化与证据限制) 定义；本段不构成第二执行图或调度授权。

恢复比较（历史原件不可访问；见顶部保留说明） 只证明所列 22 路径中 OperationPublication.java 的 before/resumed hash 不同；不能将生成 2 遗留代码认作 completed。归档 publication XML 为 3/4，crash-retry 因输出被占用失败；恢复后两个 suite 9/9 仅保留原 Router 观察，缺失完整 Handler Result 未补齐。module-check.exit（历史原件不可访问；见顶部保留说明）=1 与其 log（历史原件不可访问；见顶部保留说明）证明 ktlint 依赖解析在 configuration-cache 保存期间因 Kotlin compiler 1.9.10 下载超时失败，不证明所有功能失败或确定独立缓存缺陷。历史 partial/failed 与原件保持；后续成功须有固定树、逐项覆盖和完整 Result，不能只覆盖失败日志。

module check 单列为验证门禁：环境/依赖不可用准确 blocked，真实技术失败准确 failed/partial；均不放行。该验证不兼做 root build 修复、安装升级、关闭 configuration-cache 或禁用 ktlint。I04B-E 仍依赖已接受核心结果，最终 I04E 在平台/mapping/版本组合后的 actual tree 验证全部 A1–A12/AC1–AC12 和所有所变模块 check；核心 check 不免除最终 check。没有失败归属或所需安全正例的支持证据时停止受影响结果，不修改 authority 来降低要求。

### 生命周期与解析域

plugin apply 只配置 Gradle surface。每次 task action 创建并最终关闭 operation classloader，让执行实现、Mixin/ASM、service/global-properties、环境、transformer、configs、metadata caches、extensions、recording state 与 task plugin static state 属于一次操作。禁止 host 预初始化后只重置若干 fields 的替代方案。

平台类与 implementation closure 保留各自定义域；普通类/插件/资源/字节码统一以 `classpath → mixinFiles → inputFile` 的声明顺序解析。engine/ASM 不得被 task 中竞争 service/部分依赖替换；验证实际 dependency resolution 与 CodeSource，而不是假定 scratch 的 POM closure 等于 Gradle resolved closure。public `Side` 保留在 host API，loader 边界用 JDK/simple values 传递其值；不跨 loader cast Mixin/ASM 实例。TCCL 在 finally 恢复，所有 loader/streams/ZIP filesystem 在成功、失败、取消时关闭；不同操作有各自 temporary path。并发同输出目的地必须从写入到发布有独占权或拒绝；无全局锁性能承诺。

仅从 `mixinFiles` 和 `inputFile` 发现配置；classpath 只供解析。记录 origin，plugin/refmap 必须跟随该 origin，不允许同名 resource 静默替换；当前引擎若不能无歧义注册两个同名 config origin，明确失败。移除隐式 working-directory/host resource fallback；不要新增 external-file facility。归档路径按 ZIP `/` 解析。

### 一个完成结果及其消费绑定

保持旧 task 参数不新增 mandatory recording argument。新增有 convention 的 records output 和显式 selective producer mode；具体 Kotlin 属性名由实现选取并在 usage 文档固定。普通 producer 可保留引擎 optional failure 语义并产生不宣称 selective-ready 的证据；selective producer 必须完成全部 C4/C5 安全检查。

Gradle 输入跟踪完整 ordered runtime classpath，包括插件 method body/resources；side/effective inherited options、mode、mapping file/namespace/refmap context 与 consuming artifact identity 都是输入，不能用 CompileClasspath 忽略执行代码。根已默认启用 configuration-cache；task action 只消费已配置的 inputs，不临时访问 Project 或持有 operation runtime 到配置缓存中；实际缓存存储、复用、输入改变与重执行必须验证。records 采用 mixins-local structured encoding，复用已有 JSON 与 JDK digest；没有必要新增 core serializer 或全局 cache。

records 区分目标、配置来源 artifact/config/member/target 身份与：未尝试且证明完全未触碰、尝试失败及其 stage/cause/known-or-unknown residual、provisional success、committed success。按 engine 准备出的真实 identities/target metadata 与本次处理域核对 applicable obligations；候选发现、无成功、整个 target 的相等 bytes 都不能替代 completeness 或独立 untouched 证明。动态来源未知时不制造完整 obligations。

目标 JAR 与 records 先写操作专属 staging，全部 transform、serialization 与所需 safety 检查后才标记 logical complete；定义可验证 completion boundary，不要求公共 manifest 协议或多文件 filesystem 原子 rename。consumer 验证 records schema/mode/completion、target 内容 hash、source config artifact 内容 hash、engine/执行 scope 与所有相关输入关系。失败/取消/重试/中断不能让旧 records 成为当前输出成功；跨 cache restoration 也核对。目标和 config-bearing artifact 不同必须是正常支持路径，不能把 cleanup 输入错当 producer target。

### 精确成功与拒绝边界

版本绑定的单个 adapter 以 pinned binary 控制流为准，先验证 private surface 和准确 native error identity。scratch 的 `TargetClassContext.mixins − native suppressed identities` 只支持一个普通 applicator 场景；callback 仍在后置阶段之前，故成功只能 provisional，直到 transformer 正常返回及 output completion。不使用 candidate list、target postApply、audit onApply、applied flag、byte diff 或 absence of exceptions 授权成功。

必要 fixture 必须覆盖创建 context、各 applicator pass、final postApply validation、后置 processor/export/byte generation 失败及 required/optional 路径。实现不一定为所有扩展故障提供普适 instrumentation：归属不可信、private access 不可用、必需 obligations 不完整的 selective-ready 路径明确失败，并报告支持边界。对必须支持的普通 class 正例不能只增加拒绝逻辑然后宣称成功。

将完整读取的 Temp proof 持久留存与机制研发分开：保存其原始 provenance/source/binary 差异、Good 完成与 Bad 失败身份、Bad residual handler、脚本/fixture/日志/退出码/输出 hashes。不得把留存或一次 scratch PASS 当 A4/A7 全部通过；后续 Codev fixtures 要单独证明自己的实际 closure、operation ownership 与 completion。

### 选择性清理与适配

保留 legacy 全删。新增 mixins-owned records-consuming task/transform entry point 与局部 selective handler capability，可新增该边界的接口/实现，但不改变 shared `ListedFileHandler.list/remove` ABI。Fabric/Forge 已依赖 mixins，沿原方向实现 capability；第三方只实现 legacy handler 的 selective 调用明确报 unsupported，保留其旧全删用法。

按 JSON 语义处理 mixins/client/server/package/compatibilityLevel/refmap/plugin/parent 与未知字段，只删“全部 applicable contribution 已成功消费”的 exact entry。保留有正面 evidence 的独立且完全未尝试/未触碰成员；记录缺失不等于 untouched。全耗尽且无 dynamic contribution 才可删除 config 与所有适用引用；plugin/parent 默认留存不意味着安全，必须同时证明不能 re-supply 已预应用 mixin，否则拒绝。没有预应用贡献且无不安全 failed attempt 的 plugin/parent config 可完整保持。

zero-success failed entry 只有覆盖全部 obligations 的 no-residual + safe runtime retention 证明才能保留。known residual、unknown effects、部分 multi-target success、未知剩余 obligations 或无法证明 suppression 的 dynamic re-supply 均拒绝 selective publication；既不默认留也不默认删。Good/Bad residual fixture 要同时证明普通 mode 仍按原生 optional 语义完成、selective mode 拒绝。没有新 rollback/reapplication 或 runtime target-exclusion 架构。

Fabric 保留 string/object 形式、environment/未知字段、剩余次序；Forge manifest split→trim→drop blanks，仅删 proven exhausted references，并保留其他 attributes；NeoForge TOML 在 ZIP 内明确 load/save/close 后独立 reopen 验证。处理所有适用 reference 而非依赖当前 first-match listing 行为，多个不一致来源明确失败。没有 ownership proof 不删 mixin class/refmap。

### 可选映射与实际模块版本

在 mixins 使用 `mapping-io 0.7.1` 先例作局部 `IRemapper` adapter，经 locked engine 的 `refmap(reference) → MemberInfo → environment remapper chain` 生效；不手工替换 refmap JSON，不依赖 Codev MappingService。无 mapping tuple 保留 legacy effective defaults/explicit setting，不默认启用 REFMAP_REMAP；显式完整 tuple 在写输出前验证。

source namespace 是 refmap 后 selector，target namespace 是输入 target 字节码；refmap context 独立。member 以 source owner/name/descriptor 定位，target name 从同 entry 取；class/descriptor 同方向、unmap 反方向。缺失/null target 与 null member name passthrough；缺 owner/descriptor 仅在唯一时 rename，否则 passthrough + ambiguity diagnostic，由正常 engine required/optional 匹配决定。无 namespace 猜测、official/named 别名或 first-name/inheritance 猜测。

只有实际改动模块设 fork version：I04D 已接受的 mixins `0.1.0+terrarium.0.6.0`、fabric `0.1.0+terrarium.0.7.2`、forge `0.1.0+terrarium.0.9.2` 保留。本次已明确授权新增维护 core/includes；只读当前真实上游值为 `0.7.2` / `0.6.5`，在注解维护成为 actual changed set 后分别设置 `0.1.0+terrarium.0.7.2` / `0.1.0+terrarium.0.6.5`。新增版本 item 只拥有两条 gradle.properties，核对动态 project.version/项目依赖及实际 changed set；不改另三个 fork、root/runtime/其他模块。这不是新规范、全仓 bump 或发布许可；其他额外变更仍需披露，不把上游复制为 fork prefix。

## 可运行验证设计（完整验收仍待执行）

使用仓库已有 JUnit/TestKit/ASM/JSON 和小型真实 JAR，避免仅 mock engine 或昂贵 Minecraft download 作为首个 gate。建议新增三个 suite `MixinPreapplicationTests`、`FabricMixinMetadataTests`、`ForgeMixinMetadataTests`，位于各模块既有 `src/test` 布局；名称是将创建的测试契约，不声称现有。尽量一组 fixture 复用，独立 origins、task-only plugin、host/task 同名依赖、竞争 service、required/optional/native failures、实际 refmap 与 bytecode selectors 均要真实参与。

每次验证留 exact command、退出码、Git revision + dirty tree/diff 或输入 hashes、resolved engine/ASM coordinates/hashes、JDK/Gradle、actual producer/consumer artifact hashes、records 和关键 bytecode/运行观察；red/green 只记录实际运行。不要求源码 diff 假装 runtime 证据。

| Spec / PRD 映射 | 最小真实观察 / 验收判据 |
| --- | --- |
| A1 / AC1 | 注册旧 Mixin 输入/side/output，无 mapping/records 新参数；真实 target 方法原值 1 经 producer 实际调用变 42。旧 Strip 注册 `TransformParameters.None` 全删仍成立；selective 新入口独立可用。 |
| A2 / AC2 | 同 JVM run A/B，plugin static marker/config/mapping/side 不交叉；独立输出并发 A/B 也分离；success/failure/cancel 后 TCCL 恢复，拥有资源可 rename/delete；同 output collision 被独占或拒绝。单进程 scratch 不算。 |
| A3 / AC3 | plugin 及依赖仅在 task inputs；host 存同名不同 class/resource，验证 class/byte/resource task 来源一致及顺序；竞争服务不能替换 coherent engine/ASM；classpath-only config 不注册、同名 distinct origin 无法支持则确定报错；资源/impl body 改变触发重执行。 |
| A4 / AC4 | 同 target 的 Good 完成/Bad native optional 失败精确分离，记录真实 config origin/FQCN/target/obligations；required 失败不成功；各支持失败阶段与 callback 后失败不提交 success。同 FQCN/不同 config 不能串属；私有访问或非 native 归属未知的 selective 路径失败。只靠 candidate discovery 不通过。 |
| A5 / AC5 | 先产 transformed **target.jar + records**，再清另一 **config-bearing mod.jar** 的正常链通过；逐一交换 source config bytes、target bytes、records、side/scope/inputs、failed producer、不完整/旧 records/cache restore 均在完成输出前拒绝，不误伤输入。 |
| A6 / AC6 | 同 config 的 fully consumed 与有证明 wholly untouched entry 共存：只删前者，保留后者及 package/refmap/compatibility/未知字段/有所有权限制的资源；全耗尽 non-dynamic 才删 config 和所有 references；reopen JAR/JSON 断言。必须有正例。 |
| A7 / AC7 | multi-target mixed completion、unknown obligation、plugin/parent 再供给、same-target Good/Bad residual、zero-success unknown residual 均拒绝 selective 且未发布；普通 optional mode 仍可完成。保留完全 untouched 的独立 entry、无 pre-applied contribution 的安全 plugin/parent 配置两个正例；若声明 failed-no-residual retention，必须执行其独立安全证明与 runtime retention 观察。 |
| A8 / AC8 | Fabric string/object + environment/unknown keys/ordering；Forge `a, , b,` 无空路径读取；NeoForge TOML ZIP load/save/close/reopen；manifest+TOML 同时存在时所有适用引用一致、其他 attrs 保留。无 selective capability 的第三方 handler 显式失败，其 legacy 路径仍通过。 |
| A9 / AC9 | 实际 mapped target + refmap + engine selector fixture，owner/overload/descriptor/继承身份，class/descriptors 与 reverse direction 正确；缺 namespace/partial tuple 在写入前失败。直接 IRemapper unit check 不能替代真实 chain。 |
| A10 / AC10 | 无 mapping legacy/refmap 调用有效且不自动启用 remap；成员缺/null/不完整 tuple passthrough，唯一可改、歧义诊断，refmap-context 与 namespace 不混同；无 refmap/default mapper 也能真实运行。 |
| A11 / AC11 | TestKit 完整 task→records→不同 artifact selective chain；副作用 input changes 触发执行；up-to-date、build-cache restore、失败/中断后 retry、cancel、serialization/commit fault 不消费 stale/half output；在根已启用 configuration-cache 的配置下，首次存储、第二次复用及 input/resource/body/mapping/side 变更重执行仍正确，不能通过关闭缓存回避。 |
| A12 / AC12 | engine coordinate/hash 固定；不加 MixinExtras 自动初始化或 metadata Loader 版本 gate；task plugin 主动 extension 初始化可独立执行；真实不兼容 bytecode/config/injector 失败有原生诊断且不成为 success。 |

额外触碰回归最小断言：Fabric 其他 keys/嵌套 JAR/AW metadata 原样语义保留；Forge manifest/TOML 非 mixin 字段、AT/patch/nested-JAR 记录不受变更；旧 listing/remove 调用保留。若这些 assertions 不能覆盖实际改动的既有运行路径，再明确增加对应回归命令，不默认跑所有 Minecraft fixture。

在 Codev 根使用真实 wrapper。以下是 future commands，**本次未运行**，所有 scoped suite 名需实际存在后才可使用：

```powershell
.\gradlew.bat :minecraft-codev-mixins:test --tests '*MixinPreapplicationTests' --stacktrace
.\gradlew.bat :minecraft-codev-fabric:test --tests '*FabricMixinMetadataTests' --stacktrace
.\gradlew.bat :minecraft-codev-forge:test --tests '*ForgeMixinMetadataTests' --stacktrace
.\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --stacktrace
```

前三条用于 focused suites，包括 suite 自带的 TestKit 子构建和 cache/retry 情景；最终 `check` 在 toolchain 与既有 integration fixtures 依赖可用后完成所变模块的全套检查与 ktlint。最后一条可能需要既有 Minecraft fixture 的额外工具链/下载，不能把它称作下载-free。无法完成时报告确切范围和环境 blocker，不能把没有被执行的 A 行或全 `check` 写成 PASS。无需 whole-root build、publish、cache deletion 或 global tool installation。独立审计复查所需最小 reproducer，不因已经有 green logs 再跑无关全仓 suite。

### basic patch完整输入恢复（已授权，仅图准备）

本节为patch-repair-plan历史准备；R03P/R03V/R04现在已completed，原说明不重新授予或安排生产修改。

只读诊断（历史原件不可访问；见顶部保留说明） generation2 及 Router 独立 verifier 已完成；本次只读复用其来源，不重跑旧 verifier 或实验。Java8 恢复后 R03 实际 1/2：basic patch 子集在 rename 前缺 clean `bn` interface，引用改为 ICommandSender 后晚期按 notch 名填充导致 definition/reference namespace 错配。用户已明确授权最小生产修复，旧“待确认”候选已被该许可替代。本次只准备图，未修复代码、缓存或测试。

在共享 patch 完成边界补齐 clean 缺失 entries，使 rename/mcinject 获取完整输入，patched bytes 优先；末端 patch sibling 路径同样获得完整结果。只允许两个真实生产 owner `minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt` / `ResolvePatchedMinecraft.kt` 调整该责任；删除/停止晚期旧 namespace clean 填充，保留 universal/inject/AT/marker 原顺序与语义。task owner 的 `PATCH_OPERATION_VERSION` 当前确为 7，计划最小递增到 8，使既有 forge/neoforge operation names 的旧错误域失效，不清共享 cache，不改 shared cache/lock 架构、依赖/工具版本、公共 DSL、mapping 方向或 AT/nested 政策。

局部回归限制为 Waves 声明的一份新 Kotlin test owner，沿既有 JUnit/ASM/JDK 小型 JAR 验证 patched class 引用未修改 clean interface、未修改 interface 同 namespace、重复 entries 的 patched bytes 优先以及补齐发生在下游前。它是生产 repair 的最小聚焦证明，不是原两项 TestKit 或最终验收。未出现 test 文件/新 fixture/build/dependency 修改，也不把拟创建路径当读取依据。

原 R03 outcome 与 ID 作为历史 partial/blocked 保留，R02C completed 及 patch 诊断 completed 作为修复前置。独立原测试重验冻结新 source/config/test tree，原 basic/remapped 的真实命令、Test.java、宿主断言与版本不变；新 XML 必须实际 2/2 且零 failure/error/skipped。basic provider JAR 的 ICommandSender 内部名称/定义与 MinecraftServer interface reference 一致，真实 Java8 compile/JAR/print 成功；remapped patch/mappings/srg→named/Java8/JAR 闭环保持。AT/nested 观察如未作语义验证必须单列限制，不能由无 embedded JAR 推断认证。沿既有 Java8 发现例外，在独占 generated TestKit home 临时提供现有 JDK8 paths，采集实际 home/tool 身份并在 finally 精确恢复原存在状态/bytes/hash；不改 fixture、外层属性、全局环境或安装。

仅独立新树原两项重验 completed 才建立 R03 的新 outcome 并允许既有 core/includes 版本节点被 Router 考虑；随后在最终实际五模块版本树独立执行全部 check 与完整 A1–A12/AC1–AC12。旧 R03/I04E partial、原诊断/manifests/snapshots 和所有失败保持，新 Result 与旧 generation 不混同。图及唯一谓词在 [Waves](waves.md#最小forge-patch生产修复与独立重验)，静态来源/before-after/diff/保全/核验限制在 patch-repair-plan（历史原件不可访问；见顶部保留说明）。本次仅报告第一 structurally-ready 候选，不运行或放行；Router 持有实际决定。

## 完成 gates 与交付判据

下面保留旧patch/check准备时的状态与接受策略，包括当时未实施/旧V01的说明；当时四项missing及V02接受策略均属历史；当前R06A/R06B/R07/R08 missing与唯一R08接受边界由前面continuation节及Waves声明，不能从旧叙述回退completed结果或放行V01 partial。

[Waves](waves.md) 的 `G1-W03` gate 是功能结果：完整 A1–A12 / AC1–AC12 evidence、旧兼容、ordinary/selective 正例及拒绝、不同 artifact 消费链、actual changed-module versions，并且无不受支持路径被伪装成功。`G1-W04` gate 是该固定 source/config/test tree 的独立 read-only 审计，无未处理的重大正确性/证据/安全缺陷。`G1-W05` gate 是匹配该 tree 的普通用法与结果文档。三者共同建立本 Plan 的功能、审计与文档交付结果；`G1-W06` 只有另取得具体 Git 授权才建立本地签名集成结果。

当前 W01/W02 已按 Waves 的完整 Results 释放；I04A 已接受。I04B 原始平台 Result 为 partial，诊断、I04B-R01 applicability 修复与 I04B-V01 独立平台重验均 completed，Router 据 V01 重新接受 I04B 并释放 I04C；I04C 已 completed，Router 已核对真实 mapping/refmap/engine chain、no-mapping、输入绑定与 focused evidence；I04D 已 completed，三个实际变更模块的版本配置与动态引用已核验；恢复核查 completed，I04E 的旧 running 说明缺少可关联启动/Result 证据；当前 `codev-mixin-g1-final-i04e` generation 1 完整 Result 为 partial：两次三模块 check 均 exit 1，A11/AC11 partially-supported，Forge 基线诊断已 completed，确认旧 integration fixture/API 错位，最小修复使用现有 task/provider 接线且保留原断言；六个插件校验/ktlint任务诊断已completed，105项精确索引及200份封存证据核验通过；诊断时共享属性 owner 受 core/includes 只读限制；最新用户已确认最小扩大范围，三个精确共享 getter owners、core/includes fork 版本及新增 check 纳入维护范围，不再待重复授权。R01/R02已按自身聚焦证明完成；R02C完整Result也已completed，实际Forge full compile与四lint通过，先前imports与大小写rename增量阻断解除。R03 generation1原测试0项partial及其后网络/Java8 blocked原件保留；现Java8临时发现恢复后的独立原运行为2项1/2 partial，basic namespace缺失根因由已completed patch诊断确认，remapped闭环仅是该旧树的局部观察。用户已授权两个精确生产owner及必要单文件局部回归，不再待生产范围确认；本次只准备新图，R03P/R03V尚missing。旧 I04E generation 1 partial 保留为历史，不作为新修复的 completed 前提；新的 I04E-V01 独立 Result 只有在同一新 actual tree 上全五模块 check 和 A1–A12/AC1–AC12 真实满足后才可重新接受 I04E 的 outcome。W03/I05 此前不得放行，不把旧 Result 改写为 completed。原 partial 与失败证据保留，W03-W06 尚未释放，完整功能验收未完成。具体局部测试观察不等于完整矩阵通过。结构检查通过只证明规划依赖与引用一致，不释放任一 gate。最新生产 patch 许可仅覆盖两个精确 owner 和单文件局部回归；R03P 聚焦证明 → 独立 R03V 原两项新树 2/2 → 既有 core/includes 版本 → I04E-V01 同最终树五模块 check/完整矩阵的显式串行关系，以 Waves 为唯一图。原 R03/I04E partial/blocked 与旧证据保留，生产 repair、独立重验、版本和最终验收本次均未运行。一个 item 对应一个 Handler/Result；Router 全读 Result 后才判断后继，partial/failed/blocked/missing 不放行。独立审计不得同时修代码、改文档或做 Git 集成；若需修复，由 Router 处理图内该功能 outcome 的返工，再以实际改后 tree 取得独立审计，不能以旧 audit 继承通过。

## 物质缺口与确认准备

下表保留初次准备的历史披露，不是当前再次提问；D-SCOPE/D-BUILD/D-VERSION/D-GIT-PREP 已按 Waves 和当前维护确认满足。本次唯一新增例外已明示，D-GIT-INTEGRATE 仍未授权；E-TOOLS/E-ENGINE 仍须对每次实际新验证诚实报告，不能继承旧 PASS。

| ID | 所需证据/决策 | 当前限制 |
| --- | --- | --- |
| D-SCOPE | 披露以上 implementation closure、三模块影响、preserved API、新 records/mode/selective capability、mapping 和保守拒绝、版本值、全部验证、独立审计与 ordinary docs；取得对该具体范围的当前用户确认。 | 本次 standalone 规划授权不允许开始实施或跟进执行。既有“开始实现 Mixin”授权供采用权威，不替代本 Plan 完整范围确认。 |
| D-BUILD | `settings.gradle.kts` 的 missing legacy-forge：候选 1 删除失效 include（最少维护，建议）；候选 2 保留空项目，仅在有明确使用理由并实际证明 Gradle 配置支持时。选择、理由和具体允许 diff 需接受。 | 没有选定，依赖的构建/功能项被该外部前提阻断。不能在本 Plan 写“已删除”或实现旧 Loader。可能额外 root configuration 失败尚未复现；不预授权全部 build 修复。 |
| D-VERSION | 在 D-SCOPE 中明确纳入 `0.1.0+terrarium.{0.6.0,0.7.2,0.9.2}` 对应三个真实模块；只改 actual changed set。 | 配置与 Spec 默认已核对，未写入，不声称逐值用户同意。不是复制上游作 prefix。 |
| D-GIT-PREP | 明确授权仅 Codev 仓库创建功能分支（拟 `g1/mixin-rework` 或确认的其他名），以 current HEAD 为起点，保留全部已有 docs/untracked。 | 无写 Git 授权，不在 main 编码、不 reset/stash/clean；若 branch 已存在或 worktree 不安全，先报告，不覆盖。 |
| D-GIT-INTEGRATE | 到交付时披露 exact tree/revision、explicit staging list（含需纳入的既有 untracked 四权威与 Work，如获授权）、本地签名 commit 与 main 的非覆盖式集成方案、签名能力和冲突处理范围。 | 当前不授权 stage/commit/merge/rebase/cherry-pick，远端仍排除。仅 clean main 不允许 reset。branch prepare 的授权不自动授权集成。 |
| E-TOOLS | 实测 Gradle 9.4.0 launcher JVM、Java 11 toolchain、resolved engine/ASM closure、所选 fixtures 与签名工具；只使用现有环境。 | 本次只有配置读取，未运行任何命令证明 toolchain、build、CI 或签名可用。环境缺失应准确阻断，不隐式安装升级。 |
| E-ENGINE | pinned adapter 私有访问/精准异常归属、全部 required fixture 的 obligation 集合和 safe-retention 正例可实现，且 publication/retry 证据完整。 | 这是实施研究/验收风险；scratch 只给 bounded 起点。不能编造普适成功或以拒绝所有输入通过功能 gate；规范满足不了时停止受影响 outcome，回到 owning 决策而不自动升级引擎。 |

## 重要风险与保护

- 私有适配的版本/API/异常归属：单点 adapter + binary/surface/CodeSource/hash 检查 +真实 failure-stage fixtures；未知 selective 状态失败，普通 optional 语义保留。
- 残留与重复应用：记录 failed attempts/residual/completeness；对 mixed target、dynamic re-supply 和未知安全性拒绝。没有自动 rollback 或 suppression 的承诺。
- 输出中断与并发：per-operation staging、logical completion、消费者 hash/scope 校验与目的地所有权；fault injection/retry/cancel/cache restore 验证。
- 任意插件可写 JVM properties、native/thread/filesystem 状态：classloader 不是 sandbox。不新建 process isolation；有实证无法满足既有隔离契约时按 ADR revisit，不淡化证据。
- metadata 与路径信任边界：schema/JSON/TOML/records 的显式输入校验；config path 归一化且不能逃逸 archive root、损坏/不受支持表示报错；known hashes 绑定 Codev evidence，不认证恶意外部 producer。
- local Git 与 existing docs：所有 effects 单列授权，explicit staging 与 before/after tree；不覆盖 main、不清掉既有文档或把有界观察称全历史保持。

普通 producer 的输出和 selective distribution 是不同保证，失败时诊断要说明 mode、config origin、mixin/target、known stage/cause、安全失败原因和待核对义务，不泄漏凭据或依赖机器绝对路径作稳定 identity。完整结果可停留功能分支；本地签名集成尚无权限时准确报告限制，不声明 Git 交付完成。


本轮文档图只建立 structurally-ready R06A，未启动源码/验证，不接受任何 runtime Result。新 v02-core-java8-plan（历史原件不可访问；见顶部保留说明） 保存 Router 部分编辑后的此次 pre-edit 快照、diff/after、273inputs/旧包/Git 保全与默认只读核验；旧原包/default receipt/失败/Ruff偏差不修改。旧 V01/V02/原 I04E 的终验措辞保留为 historical-only，当前 W03/I05 仅可依据 R08 同新树完整五check/全matrix；I06/W04 与 Git 后续原门槛保持。

## R06 generation1 blocked 后的精确单-outcome分解

Router 已读取 `codev-v02-core-lint-repair-r06` generation1 完整 Result：**blocked**，内容格式与七rename/API保全是两个独立outcome，Handler在执行前停止，无源码/rename/build/evidence副作用。原 `G1-I04E-R06` 身份、原定义与历史证据保留为 **historical-only**，不参与当前completion门槛。旧父包 generation1 partial 与 Ruff漂移（写入者未知）保留；不运行旧默认脚本的新树 equality。

当前唯一串行执行分解为 **P02(completed) → R06A → R06B → R07 → R08**；仍只有一个 Work/Plan/Waves tuple、6 Waves。当前44 items；本次只准备派生文档，不执行任一节点。W03 requiredCompleted列R06A/R06B而非旧blocked R06；I05与W03保留R08最终全矩阵门槛。V02 latest partial与旧I04E/V01/V02继续仅为历史证据。

- **R06A / VG1-POST-05A**：一个Handler/Result，唯一修复原生32条内容规则。许可仍只覆盖原17sourceOwners的已报告imports/标点/缩进/换行/注解布局；14个有内容违规，三个filename-only文件无需修改且字节保全。不rename、不加JvmName、不改caller/其他owner。完成要求语义等价、native core compile exit0；独立fresh原生core lint预期exit1，完整报告恰剩原七`standard:filename`且无新增/其他违规。禁止关掉/筛掉filename规则冒称全lint0；该残余由R06B完成，不等同final gate通过。
- **R06B / VG1-POST-05B**：一个Handler/Result，仅在R06A completed后执行；唯一完成七文件物理命名迁移且兼容性不变，只覆盖原七source/destination与四@file:JvmName必要相邻注解格式，不泛修另外十source。四显式fixed为`ServerExtractionStateKt`、`Build_utilsKt`、`Path_utilsKt`、`Source_set_helpersKt`；`GetMinecraftFileKt`、`ExtensionKt`、`IsUnobfuscatedVersionKt`为默认名需真实编译核对，不能称七fixed授权。三case-only移动用同目录unique临时basename两步实体rename，保存实际路径/case证据。迁移前归档七facade/JAR/API/default桥/Kotlin metadata/旧caller字节；迁移后完整core compile/JAR、native core/includes validatePlugins和core lint均exit0，旧binary链接保持，不修改/重编旧caller隐藏ABI变化。允许SourceFile/SMAP/source-JAR路径差异，另仅按Waves精确LNT契约接受本次八类/166项行号+2（逐method/table count/order/BCI不变）；其余runtime/API/metadata保持，旧strict-debug失败仍保留；允许generated evidence probe但不新增项目test/build owner。
- **R07 / VG1-POST-06**：completion前置改为R06B completed（传递闭合R06A）；原单一nested argv `--rerun-tasks`、原fixture/source/断言和build-root ownership、五fork、真实Java8 compiler与Java8→Java17进程TestKit、精确环境恢复、Java11五module既有产物和保密门槛保持。
- **R08 / VG1-POST-07**：显式要求R06A、R06B、R07均completed；原同树fresh五module check、A1–A12/AC1–AC12、P01/P02 direct closure、Forge两TestKit/nativeCompiler独立验证全部保持。

R06A/R06B不清任务增量或其他cache，不获得R02C式移走state许可；真实compile暴露旧incremental state问题时据实partial及证据。原fixture、断言、算法/literals/providers、依赖/版本、未知includes/其他owner、五fork/Git权限均保持原边界。保留原逐family authority reuse，不修改PRD/ADR/Spec/DDD。仅**R06A structurally-ready**；R06B/R07/R08等待completion前置，未启动、未接受、未释放W03/I05/I06/Git。新静态封包见continuation-g2（历史原件不可访问；见顶部保留说明）；当前273inputs为准备前锚，旧冻结scope和旧parent graph/manifest/receipt/脚本均只读。
