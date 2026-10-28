# G1 Mixin Rework Work

## 归档可访问性（清理后）

按用户要求，旧历史证据目录 `docs/works/mixin-rework/evidence/` 已整包删除，包括 `core/`、`pinned-engine/`、`g1-implementation/` 和 `g1-results.md`。其中原命令/exit/日志/XML、分窗报告、具名 ABI 输入与普通结果摘要原件均不再保留；没有另建备份、替代原件或重放包。保留本目录 Work/Context/Plan/Waves 的历史结果与执行图，以及同一 ADR 的架构决定。已采纳验收登记仍见 [Context](context.md#g1-acceptance)；该加工登记不是已删除的原实验报告或证据包，也不保证重放。

以下历史正文、JSON 图内路径/绑定及“完整保存/可读/可重验”等措辞只记录原时点，不再承诺已清理原件可访问，也不作为当前证据入口或新执行输入。已失效的 Markdown 证据链接已撤下；历史 task/generation/item/Wave、scope、状态、gate 与实际方法/失败/partial/unknown 均保留，不重置或释放。保留文档不是原件替代品，本次没有项目或 ABI/checker 重跑、没有新 G1 认证；旧已批准 G1 的 accepted/closed 仅适用旧兼容/选择性清理范围，不覆盖当前 [PRD](../../prd/codev-mixin-rework.md)（[中文](../../prd/codev-mixin-rework.zh-CN.md)）的生效（Active）目标：Codev 提供预应用 Task 与逐 JAR Strip Transform；使用者注册、接线并选择消费配置，Codev 按引擎应用通知取得清理资格，不额外核验全目标完成、无报错或最终字节码效果。键为完整 config 资源路径＋原始条目字符串，全部重复、跨数组、跨 JAR 匹配项一并删除，即使其它应用部分完成或 unknown；未通知的其它键保留。仅清单或让使用者补做 strip 不算完整清理流程；原输入不变，不扩至删除类、refmap、整个 config 或 Loader metadata。使用者决定消费者与编译/反编译/打包/运行用途，Codev 不管制用途、不代选路由、不保证任意下游兼容或安全。日志/异常承担诊断，不要求公共诊断返回、旧 Strip 兼容或独立 records 协议。当前 [Spec](../../spec/mixin-preapplication.md) 与[同一 ADR](../../adr/mixin-operation-isolation.md) 的适用说明不代表新实现或验收。Mixin 日志由用户阅读，Codev 不解析日志判定应用成功；引擎抛异常自然失败，Codev 自身 IO、原输入、资源、精确 JSON 与缓存保护仍保留。operation classloader/engine isolation 决定沿用；Task/Transform 结构及身份匹配已定，通知收集 hook/API、信息表示、发布及保存恢复/cache 机制仍未定且未实现；下方 Plan/Waves、selected/授权及 R/AC/验证编号只属旧交付时点，不是新目标执行图或验收映射。本说明仅维护当前适用事实与归档限制，不改变历史策略、图或 gate。

## 当前已确认范围：mixin-consumer-docs-r01

唯一 selected tuple 为本目录直接匹配的 [Work](work.md)、[Plan](plan.md)、[Waves](waves.md)；[Context](context.md#doc-context)保存加工事实。沿原G1-I06三处普通消费者说明目标，一个Doc item / 一个Wave / 一个Handler / 一个Result已完整交付，不重开已完成AF或原审计。

**当前用户已选择“写完三处（建议）”**：executionAuthorized=true，仅授权DOC-I06三处消费者写域及静态核对；不改源码或规范、不运行项目、不做Git、不覆盖已有内容。Root已完整采纳DOC-I06 generation1：指南、结果摘要和README入口已交付，27本地链接及示例/结果静态核对通过，DOC-W01 satisfied；没有新项目运行。拥有区与静态完成条件归唯一Waves。

复用[Root加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)：AF-W01/02/03 satisfied，AF-R02一次native exit0、fresh59=50+6+3零failure/error/skip，累计Native3/许可3；AF-A02 generation1完整采纳、F1/F2闭合、7/7hash一致，Root明确解除原B-W05阻断。不重新接受Result/gates，不自动宣告完整G1/Git。DOC-W01已satisfied，本Doc Plan已收口；[交付加工结论](context.md#doc-i06-closure)可读；历史结果摘要原件 `evidence/g1-results.md` 已删除；历史指南 `docs/guides/mixin-preapplication.md` 现已删除，当前技术入口为 [Spec](../../spec/mixin-preapplication.md)，不是旧指南原始证据。当前批准的交付完成，不把历史失败或严格审计限制改绿；Git未执行。

**已确认范围摘要**：仅新增G1指南和真实结果摘要，README末尾加一个入口链接；例子沿现有API/fixture，只核对本地链接与用法。不改源码或权威，不运行项目；当前用户已明确确认三处写入。

**总体G1已接受并结案（非新实施图）**：当前用户选择“接受结案（建议）”，Root据已采纳行为证据、总体核定与产品owner明确接受，登记本轮已批准兼容G1 **accepted / closed**。实施、测试、复核与消费者文档均已收口，无现存必补工程。详见[验收登记](context.md#g1-acceptance)；旧失败、未知及严格审计限制不改绿，不新执行或重开历史图。Git集成/提交/推送/PR/合并/发布未执行，仍须另行授权。

## 以下为已完成AF范围及原时点记录（非 selected，原文保留）

> 旧当前/selected/待验证/额度只属各原时点；AF完成、失败与限制保留，新Doc范围不继承旧执行许可。

## 当前已确认范围：mixin-audit-f1-f2-r01

> **当前修复与独立复核已完成**：AF-R02一次native exit0、fresh59=Mixins50+Fabric6+Forge metadata3且零failure/error/skip；累计Native3/许可3，不再运行项目。Root完整读取并关联codev-mixin-af-a02-incremental-review generation1的完整15797-byte Result：F1、F2闭合，无新blocking findings；2026-10-12T15:49:58Z七文件SHA-256与R02 after-hashes全部一致。Root满足AF-W03，AF-W01/02/03共同完成当前有限修复Plan；并明确以原I05报告＋这次增量关闭原B-W05的F1/F2挂起，非仅凭报告completed自动接受。F3沿已接受正确有限编号，旧表/报告不覆盖；原failed/unknown、1114副本偏差及可信本地/Windows限制保留。消费者说明尚未交付，完整G1/I06/Git不自动放行。详情见[加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)。

> **历史AF-V03失败时点（本次单行修复确认之前）**：参数回显通过；此次唯一外层native exit1，累计2/2、尚余0。Mixins fresh 8 suites/50 cases：41通过、9 failures、0 errors/skips；均报OperationPublication.publish输入Projects缺失。Mixin完整check、Fabric6、Forge metadata3及P01/P02完整链未到达。F2字段变异/合法untouched=false与library输入保护已有fresh通过，但不释放整体验收。七源码候选在执行窗未改。新增1114普通副本未逐件证明必要性，属于已保存执行偏差；不宣称合规或全Host保全。AF-W02/03未满足，AF-A01/消费者说明/G1/Git仍阻断；只读定位已完成：Mixin.kt:98裸+Path把完整输入拆为相对片段；最小纠正为+listOf(Path)，未实施、未补验。gates与停止边界保持。

> **历史AF-V03补验许可（原确认时点）**：用户选择“补验一次”。先在自有临时目录进行有界参数回显（不启动Gradle/Java、不造helper框架），通过后原命令最多追加1次。总额度2，实际已用1，尚余1；原任务/七文件候选只读/环境与缓存边界不变。AF-V03是独立新Result；AF-V01 blocked、AF-V02 failed及旧流保留，新失败保存停止、不自动重试。AF-W02/03未满足，AF-A01/消费者说明/完整G1/Git不放行。

> **历史AF-V02失败时点（本次增量确认前）**：实际原生1次/exit1，额度已用1/许可1。Windows引号传递偏差导致daemon启动失败，全部所选tests未到达、fresh XML/cases为0（不是零失败通过）。F1/F2仍未实跑关闭，AF-W02未满足、AF-A01未启动；已保存并停止，没有追加运行授权。以下AF-V01 Native0是旧启动前时点。

> 历史AF-V01 generation1语义blocked（启动前版本误绑定），实际Native0/1，原启动日志保留。现按C5将未完成验证细化为AF-V02，原命令/52基线+新增/恢复/停点不变；外层保持现有wrapper9.4.0，内部TestKit保持既有配置，不改wrapper或安装。旧blocked不回写成功，新Result独立判断AF-W02。

唯一 explicit selected scope 为 **mixin-audit-f1-f2-r01**。入口为本 Work；加工事实归 [Context](context.md)，策略归唯一 [Plan](plan.md)，执行图归同目录直接匹配 [Waves](waves.md) 的 selectedWavesGraph。当前用户选择“修复并验证（建议）”（并反馈“看不到问题，问题太长了”），已明确确认准确七文件、四文档同步、一次受影响 Native 和成功后一次独立只读增量复核；不再等待内部接线确认。

目标是防止输出路径别名在失败前删除真实输入（F1），并拒绝矛盾success records、保留合法untouched=false（F2）。仅Mixins四生产文件+三个现有tests，无新helper/build/schema/engine或其它模块生产文件。四个独立item：AF-I01/F1候选+tests → AF-I02/F2候选+tests → AF-R02/已核定单行恢复及一次共享验证 → AF-A01/成功后独立增量复核。共享MixinInputBindingTests要求两修复串行。代码completed只表示源码就绪，不是tests通过或缺陷实跑关闭。

Root已完整读取、解码并关联两generation1：独立审计报告交付completed，但B-W05因F1/F2仍 **not-satisfied-blocking-F1-F2**；最小范围核定completed。具体事实及F3正确有限编号归Context加工摘要，不依赖仓库外Result locator，不承诺永久取回原文，不重开旧任务。B-W05是修复动机，不是新图入场前置。

三family PRD/同一Accepted ADR/Spec **reuse**，仅恢复C1/C3、C4/C5，owner/path/理由见Context，无权威改写。原65/Forge8/Core/ABI结论按原scope有限复用；旧implementation records不假充改后正例。F3正确有限关系supersede错误表，原表/报告/native statuses不改。

**AF-I01/F1与AF-I02/F2两个源码候选完整completed Result均已采纳，尚未编译或实跑。** AF-W01满足源码ready谓词，只释放AF-V03一次共享验证；AF-V03 planned（参数核对后至多1次），AF-A01未启动。Native已用 **1/许可2（尚余1，补验已确认）**，作者无额外窗口；真实受影响闭包是Mixins全check+Fabric六+Forge metadata三（52基线+实际新增JUnit），不是全65/Forge patched/Core vanilla/ABI重跑。AF-W01已satisfied-source-ready，AF-W02/03仍pending；两个源码ready不是JUnit通过或缺陷实跑关闭。缺工具链/额外写域/新failure或skip/junction失败均保存停止，不重试、扩跑、安装、清cache或升权；成功后复核不自动满足消费者说明、完整G1、历史W03/I06/Git。

## 以下为历史 B01 协调记录（非 selected）

> 下方旧“当前/唯一/待确认/ready/单次未用”只属原scope时点；B01/R13原结果、failed/partial/unknown和B-W05阻断保留，不成为新权限或修复前置。本次不覆写运行结果。

## 当前范围确认：B-I05 Includes格式与分窗收尾

当前新增确认：用户选择“修格式并收尾（建议）”。仅Includes main目录下ExtractIncludes.kt、IncludedJarInfo.kt、IncludesJar.kt、StripIncludes.kt处理continuation-02原报告的八条逗号/换行/缩进诊断，不改逻辑、API、断言或lint规则，不运行全仓format。之后一次Includes check，沿--rerun-tasks/--no-parallel/--max-workers=1/--configuration-cache/--stacktrace/--console=plain。只读消费g1 Mixins43/Fabric8、continuation-02 Forge11/Core3及B-I04 ABI的同源source/TestKit/closed实物，全部适用A/AC、P01/P02与实际Java8不减；不重跑65测试、caller或focused。原两次exit1及历史failed/partial/unknown永久保留。新普通日志仅原B-I05 namespace的continuation-03/，temp仍原runtime/temp，有界正常输出和finally不扩域；新失败/reusegap保存停止、不自动重试，无安装/清cache/审计/I06/Git。Root已完整读取codev-b-i05-includes-format-closeout generation1的completed完整Result及continuation-03/verification.md。Includes唯一native exit0，编译/ktlint/validatePlugins/check完成，test如实NO-SOURCE；旧四module成功check/65tests零失败、错误、跳过按原窗/source/TestKit/closed实物关联，12对A/AC、P01/P02、实际两Forge Java8、Core四闭包负例、I04当前158class+1kotlin_module bytes及finally支持。Root据此接受B-W02/B-W04，B-W01/B-W03继续满足；本scope收尾完成，不追加native。三条既有auxiliary warnings及准备/读取错误保留，旧两条exit1、R13 failed/R14 limited/strict=false/external unknown/Ruff限制不回写，不自动释放历史W03/完整G1/I05/I06/Git。报告见 docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md。以上为当前唯一新增许可，下方原scope/执行结果保留其时点。

### 原四brace scope及执行结果（保留时点）

当前新增确认：用户选择“修四处并补三模块（建议）”。只在ForgeMixinMetadataTests.kt与PatchedMinecraftTests.kt补原ktlint诊断的四处分支花括号，不删断言、不改逻辑；之后一次Forge/Core/Includes check，沿原参数。复用g1 Mixins43/43、Fabric8/8须同输入且实际source/TestKit/closed产物可闭合；最终五模块按两窗组合，原五check exit1/failed永久保留。ABI不重跑，无focused/生产修复/清cache/安装/扩权/审计/Git。新普通日志只原B-I05/continuation-02/，g1原流/记录/SDKResult不覆写，child temp仍原runtime/temp。复用gap或新失败保存finally后停，B-W02/04未满足；新增四brace已完成；该唯一三模块续验native exit1，Includes四main文件八条ktlint逗号/换行/缩进失败。Forge本窗fresh11/11与Core本窗fresh3/3均零失败/错误/跳过，二者check实际成功；Includes:test/validatePlugins/check未到达。两流及finally已保存、generated属性精确恢复、父env/110局部必要输入前后不变；旧Mixins43/43与Fabric8/8未重跑。全部source/TestKit/closed产物及ABI复用最终消费因失败停点未完成；B-W02/04未满足，不宣称五模块成功。该增量次数已用完，未授权Includes源码修正或自动重试。以上为当前新增范围，以下原统一窗及初次准备说明保留各原时点，不与新增scope竞争。

原统一窗确认（原许可时点，g1失败保留）：恢复一次独立 Core compileKotlin/jar、原三封存 Java17 caller 与原 ABI/debug 验收；成功后串行执行一次 Mixins/Fabric/Forge/Core/Includes check，共用组合窗验证修正后的 PatchedMinecraftTests，不追加 focused。B-W01 已有限满足。B-I03 g1 启动脚本失败、g2 实际 focused native exit1/2 failures 均保留；g3 仅一行 argfile escaped-backslash 解码修正及离线检查完成，内层 partial，未原生回归。B-I03/B-W02 不提前释放，须以 g3 同一修正输入与 B-I05 的新完整原生结果共同成立；共享验证的入场不依赖尚待该窗证明的 B-W02，最终完成仍必须满足它。匹配 Waves 的新依赖只改变证据复用与次序，不减少 A/AC、Core3case、P01/P02、实际 Java8 或一次性维护条件。

仅既定生成子域、B-I04/B-I05 普通日志/必要结果快照、原受限 child/temp/TestKit 属性与精确 finally；不授权额外 focused、源代码/依赖/规范修复、清cache/安装/扩权、旧封包重跑、独立审计/I06/Git。失败保存恢复后停止，不自动重试。B-I04 g1完整Result已读取并关联：独立Core与三caller各一次native exit0、158class/模块bytes及原ABI/default/Kotlinmetadata/精确debug条件完整，输入前后不变，受限child无待恢复属性；B-W03有限满足。B-I05 g1完整failed Result已读取关联：唯一五check native exit1，Forge两个测试文件四处ktlint Missing { ... }，Mixins43/43与Fabric8/8本窗fresh零失败/错误/跳过，Forge/Core/Includes test/check未到达；两流已保存、handles结束、generated属性精确恢复。原单次窗口已用完，不自动source修正/重试；B-I03/B-W02及B-W04依旧未满足；文档/UI不是 admission 或通过证据。下方初次准备及原兼容段描述保留其原时点，以本节与当前 selectedWavesGraph 为新范围，不重写历史或建新取证包。

### B-I03 方法说明校正（沿用当前确认，非运行或 gate 结果）

直接使用原 `compileJava` 的 CLI 分支：必需 `fixtureJava8Javac` 经受限 outer child 的 `CODEV_TEST_JAVAC8` 传给原 nested invocation；`fork=true`、指定 executable、不设置 javaHome，`forkOptions.jvmArgs=[-J-showversion,-J-Duser.language=en]`，`verbose=true/incremental=false/failOnError=true`。保留 `jar/printCompileClasspath/-s/--rerun-tasks`，增加 `--info/--console=plain/--no-build-cache/--no-parallel/-PfixtureJava8Javac`；outer/test 保持17，不对 debug TestKit 使用 withEnvironment。逐 fixture 的实际8版本、原 Test.java 解析、本次 wrote、原 patched/named classpath、compileJava/jar SUCCESS 与重开 JAR 内 **Test.class** 原 bytes 等同为合取证据；major52仅辅助。原两源码实际产物为 Test.class，准备中的 Consumer.class 是方法说明误写。唯一 generated TestKit 属性原 bytes/缺席须 finally 精确恢复；不恢复 jcmd/CIM/observer 或四 key/byte-writer 账本。以下初次准备的未定方法描述保留其原时点，本节仅局部校正方法，不推进 Result/Waves/Todo/gate，也不构成实跑通过。


## 本次入口：精简分层 B 的初次范围准备

**当前阶段：准备文件已派生，实施 scope 等待 Router 集中披露及当前用户确认；不是 ready/run/验收通过。** 用户“落实这部分吧”授权本次准备，方向 B 已接受，不等于新实施范围已经确认。本次唯一交付是此 Work、[Context](context.md)、[Plan](plan.md) 和匹配 [Waves](waves.md) 的一致准备材料；没有选择执行旧 R13，也不消费其已用单次许可。

精确候选 selected tuple（同目录、直接、unsliced；这里只声明候选，不声称 Harness admission 已验证）：
- work: `E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/work.md`
- plan: `E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/plan.md`
- waves: `E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/waves.md`

选定 scope identity 为 **mixin-layered-b01**；唯一新候选执行图在 Waves 的 **selectedWavesGraph**。旧图完整保留为 historicalWavesGraph，不参与新图依赖、候选选择或 gate。Plan 是连贯策略而非第二执行清单。

### 实施范围摘要（待集中确认）

保持 G1 产品行为，用现有普通 test/--tests 将日常小 JAR/局部 TestKit、按边界的真实平台集成、一次性 ABI/rename/debug 维护分开。必要测试侧改动只有 Fabric 已覆盖 SERVER/client-only 用例去重、Forge 一个真实 manifest/TOML 双位置 JAR，以及**尚未 settled 的**原两 Forge fixture 实际 Java8 compiler→fresh class/JAR 证明补强。组合交付保留当前五个变更模块 check、Core 三真实 case/四构建闭包/负例、原两 Forge fixture、P01/P02 consumer/cache/input/publication 行为；不扩版本矩阵。

不改生产算法/API、依赖/lockfile、全局/父环境、私有 collector、权威、LLM 指令或 Git；不建新 TestTask/tag/调度器/遥测 observer/证明平台/Tasks/冻结包。发现生产缺陷仅报告，不自动兼修。

### 权威与验收条款

- [Active PRD](../../prd/codev-mixin-rework.md)：Codev 产品 owner/user；**reuse** R1–R10，update/create skip。
- [同一 Accepted ADR](../../adr/mixin-operation-isolation.md)：mixins 执行隔离与 Fabric/Forge adapter owners；**reuse** operation-local、完成结果及 selective 边界，update/create skip。
- [Active Spec](../../spec/mixin-preapplication.md)：mixins/loader 技术 owners；**reuse** C1–C8/A1–A12，update/create skip。可靠 assessment 及具体 assertions 来源见 Context；没有发现需要改权威的实质矛盾。

全部适用 A1–A12/AC1–AC12 按同一行为成对关联，共用风险组、XML、实际调用和重新打开的 JAR，绝非 24 个 Handler/运行。实际注入、缓存正确性、selective 安全、真实 consumer、输入失效、失败/发布/恢复及真 Java8 不减。四 Codev key、cold 临时 JAR 逐路径和严格 byte/writer 归属账本退出**新 R13 替代候选（B-I05）的常规功能门禁**；这不改 C4 的产品记录绑定，也不放弃旧对象保护或扩大整个 cache/Temp 权限。

### 历史、未决与完成信号

R13 run01 保持 **failed**：五 check exit1、Core 2pass/1failure，Includes 未完成，独立 fresh Core JAR/三旧 caller 未启动；24 行 partial 不变。R14-V01 generation2 的有限 Core 3/3 是历史局部接受，不覆盖最终 G1。collector 调查/续修及旧 R13 后续已暂停；历史 rawpartial/strict=false/unknown、旧授权和所有 Result/封包不改、不重放。

**局部 blocker**：Java8 执行证据替代旧 jcmd 的方法未证实，Waves 的 B-I03 分支 blocked；选中 compiler/声明 toolchain/major52 均不等于执行 compiler。它不阻断已 settled 的 B-I01/B-I02 准备。正常输出 namespace/受限 child/finally 仍须属于集中确认范围，若无法限制系统临时路径则停止受影响执行，不以降低取证要求扩权。

准备完成信号仅为四文件 reciprocal links、新图唯一性/引用/DAG 和 scope/验收一致。未来实施 Plan 的完成由 B-W01 至 B-W04 的实际 predicates 与完整 Results 支持，最终 B-W04 不自动释放历史 W03、I05/I06/Git。文档状态或 UI 不释放 gate。

## 以下全部为历史协调记录（原 scope、授权、结果原样保存）

> 下文旧“当前/唯一图/ready/未运行/单次未用/未来 run01”只指原时点。新方向及当前确认边界以上文和 matched Plan/Waves 为准；历史不再是新范围的执行图，但原失败、unknown、接受与授权事实仍有效。

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

局部结果入口：静态准备与重放（历史原件不可访问；见顶部保留说明）。唯一新增G1-I04E-R14/W09完成局部退役＋聚焦证明，不释放R13/W03/I05/Git。重要排除：五新Vanilla owner、有效Forge、production/deps/config/versions/authority、全部旧封包与cache/Git均只读；不删目录或Basic .gradle十文件。具体所有权/冲突/真实完成谓词只在Waves。

## 既有协调合同历史（保留原scope/时点，不与当前退役范围竞争）

## 当前 R12A g3 就地修复合同（首次派生，非执行）

唯一同目录 tuple 为 [Work](work.md)、[Context](context.md)、[Plan](plan.md)、[Waves](waves.md)。这是当前新确认范围的首次派生合同；只准备四文档，不修改 g3，不运行任何 static/capture/preseal/seal/default/helper/loader、Gradle、测试或下载，不投影 Todo/Result/运行状态、不派发或接受后继。下方旧“当前/ready/not-run/永久不动”文字保留原 scope、原时点；当前许可只由本节和唯一 Waves JSON 的新四项合同定义，不从历史 missing/not-run 推翻真实 g3 failed。

用户已选择“就地修复，并核验一次（建议）”：仅 g3 过期核验逻辑和失效派生结果可按 [Plan 精确清单](plan.md#精确就地清单与未来成员) 清理替换；不建 g4，不删除 g3 外旧核验或旧包，不修改生产/测试/config/dependencies/lockfile/权威/Git。该许可取代仅针对 g3 的永久不动限制，原始测试日志/XML/JAR、其它封包及真实失败事实不变。原 g3 capture native0、唯一 preseal native1、根 verification.json 为 0 bytes、没有成功 seal/default；F0 是 stdout/stderr 取流错误，不是 daemon/hash 错误。

已披露的五个独立结果仍串行：本次合同清单准备是独立 standalone Result；其后唯一 Waves 图的 R12A-R01（就地修复/static）、R12A-V01（独立 static 审阅）、R12A-F01（一次功能窗口）、R12A-V02（独立默认封包验收）各一 predicate/Handler/Result。原 R12A 原定义和状态字段保留为历史，不变成 completed。W08 只等待这四项的真实完整证据和 W02/七基础，不等待 R13/W03 或自身 gate；本次没有释放 W08/R13/W03/I05/I06/Git。

只读权威 assessment 复用并复核相同版本：Codev 产品 owner 的 PRD reuse（AC1–AC12/范围/支持不变）；mixins/adapter owners 的 Spec reuse（C1–C8/A1–A12不变，证据表示不是 application-record schema）；同一 Accepted ADR reuse（operation 执行/发布/消费隔离不变），update/create skip。278-input identity、原310-member seal/final04、02–04 完整元数据及唯一01历史 exit/endUTC unknown 例外均不变；新阶段不得继承例外。四空 pass/Basic skip 不是行为覆盖，unknown Ruff/fullStrictScope=false/R11 g3unknown、原 rawpartial/default1/overallfalse 全部保留。

> 【历史时点；已由顶部现行分层合同取代，不是当前执行要求】 默认完整 receipt/raw streams 只能在稳定 Host 会话 locator 保存；不能仅摘要、不能写回已 sealed g3。T0 是 seal 后、协调状态投影和 R13 副作用前，whole 限定域及 tuple 当前树等式仅在 T0 成立。R13 的真实独立 README-default 重放、fresh 五模块/24项/direct closure/ABI/Forge 要求不改、不启动；后续时点冲突仍是未接受的 Router 决策，不借 B 归档替代重放或 C 新白名单解决，也不反向阻断当前准备。


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

本 Work 的现时入口采用本节合同；下方旧“R12/R13 未实施、273 输入、R12 候选 ready”只保存图初始准备时点，不竞争当前状态。执行所有权/完整谓词仅在唯一 Waves；历史 Tasks 不作执行图。

## R12基线图初始准备记录（历史）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。本轮只更新四份协调文档及 最小静态证据（历史原件不可访问；见顶部保留说明），不创建测试、不执行 Gradle/测试、不接受功能完成。

- 当前链为 **G1-I04E-R12 新基线五文件实施与聚焦验证 → G1-I04E-R13 独立最终五 module check/全24项 A/AC 验收 → W03 → I05/W04 → I06**。R12 是唯一新增候选 ready 实施项；R13 只有在 R12 完整实测 Result 及独立核验获接受后才 ready，partial 不满足前置。I05 的 scope、prerequisites、requiredEvidence 均消费同一 R13 最终树结果。W03/I05/I06/Git 仍未放行，本图不派发后继。
- 用户已接受用新当前 API vanilla 基线替换本轮旧 vanilla 证据分母：固定 **Gradle 9.4.0、既有 JDK17、MC 1.16.5/1.20.1，每版 common/client resolve→compile→package**；不是取消公开支持，也不承诺 selector 等价语义或新增 Core 支持。旧 Maven selectors、八 pipeline、Gradle 8.2/8.6/8.8 **本轮不计入且未验证**。
- 唯一 legacy skip 例外是已 Disabled 的 **Basic Minecraft Build()**，不计 vanilla 成功；原四空 pass 不构成行为证据。不允许 class disable、filter 或其他 skip。Core Test Java11 launcher、nested Gradle/编译17、Forge 原双 fixture 逐 fixture 真实 Java8 编译分层不变。
- 历史 R09 保持 raw/accepted partial、R10 保持 missing/not-run、R11 保持 raw/runtime/accepted partial；R09/R10 旧零 skip 完成谓词及原 receipt 封包仅历史，不再要求 R09 completed，不将 R11 窄停用目标改成 completed。unknown Ruff、**fullStrictScope=false**、**g3unknown**、历史失败及默认 exit1 全保留，不以分母调整解除严格范围限制。
- 当前未改动的 **273-input / 489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e** 仅历史锚。R12 创建后必须按实际成员/path/count 重绑新 identity，R13 在同一新最终树验收；未创建前不称为 278。完整五 checks、A1-A12/AC1-AC12、P01/P02 direct closure、core ABI、封存旧 caller 精确 debug 保全、原 Forge 真实闭包不可削减。
- 权威复核已 settle：PRD/Spec/同一 ADR 三 family 均 reuse，update/create 均 skip，不写 authority。具体执行越 owner、需要额外依赖/支持承诺或新阻断时停止并返回证据，不自动修复、安装 JDK、改版本/环境/Git。

### 范围与当前边界

本轮单一交付物是已有协调 tuple 的新基线依赖图及其最小静态验证证据；不是 R12 实施或 R13 终验。已有 Work、稳定 item/Wave IDs 和唯一 wavesGraph 延续，不增加第二图、tasks 层或 scheduler。

R12 的唯一 implementation owner 是五个尚不存在的 Core test/resource 文件；所有原 source/build/旧 Disabled/body/fixture/四空方法/Forge 均只读。R13 独立只读实施树并生成自己的原生证据。实现/执行阶段必要正常 outputs 与官方下载权限不属于本图 writer。

静态证据只证明 tuple、prose/JSON、引用、联合 DAG、ownership/conflicts、输入/旧封包/Git 保全和结构 readiness；不证明 vanilla/runtime PASS，也不重放旧 verifier 的 current-tree equality。当前 Git 后续授权和功能 completion 均未发生。

## 历史协调记录

### R11 generation4结果（原核验后状态投影）

R11已实施单方法停用并完成g4唯一新授权的原core:test；`lastResultStatus=partial`、`runtimeStatus=partial`、`acceptedCompletionStatus=partial`，不是完整completed。Router仅接受“单Basic方法停用并明确skipped”的窄目标已验证，不接受严格整体完成，不释放任何Wave门禁。本writer只更新四coord，不再运行Gradle/测试或旧verifier，不写Todo/源码/权威/证据/Git。

g4完整事实（历史原件不可访问；见顶部保留说明）、native receipt（历史原件不可访问；见顶部保留说明）与逐case/class分析（历史原件不可访问；见顶部保留说明）：PowerShell/cwd匹配的原core:test实际一次native exit0，UTC `2026-10-09T03:35:48.3806936Z–03:36:17.5186658Z`，test与compileTestKotlin实际EXECUTED；fresh五case恰4pass/1skip/0failure/0error，唯一skipped为原Basic Minecraft Build()。fresh compiled class仅该方法具有原plannedDisabledReason的Disabled；`xmlSkippedReasonProvided=false`，XML仅`<skipped/>`，不是XML输出reason。四pass方法仍为空，不证明Core行为或vanilla；原body/fixtures/8.2-8.6-8.8 loop及其他Core/Forge测试保留，skip不执行三版本循环。

Router已独立执行g4默认只读`verify.py`：实际exit1、errors=[]、`focusedChecks=true`、`fullStrictScope=false`、`detachedVerificationReceiptChecked=true`；29新sealed成员/16旧sealed/20旧R11文件/9ledger/273inputs/281protected/52Git匹配。exit1来自已披露unknown Ruff严格scope限制，不是整体checker通过或native测试失败。当前273-input identity为`489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e`；041锚仅为历史source-edit前身份。g1/g2机械失败及raw partial、g4准备KeyError均保留，g3执行历史仍unknown，不称g4首次执行或自动retry。

唯一图仍47items/7Waves；全部依赖/owner/verification/completion/release predicates不变，W07亦不释放。R09 raw/accepted partial、R10被原前置阻断且not-run、原vanilla/三版本/五check/24A-AC缺口及W03/I05/I06/Git未释放保持。PRD reuse、Spec reuse、同一ADR skip写update沿用，只读不改权威；暂停不是fixture/selector/API修复。

四coord新字节是Router核验之后已授权的状态投影；旧快照/manifest/verifier全部只读，不重封或宣称旧入口对更新树的current-tree等式仍成立。下方旧“当前/准备/ready/未实施/未运行”说明及JSON中原preparation/未来输出措辞仅保留历史定义；现时R11事实以本节与其结果字段为准，旧完成谓词保持原义。

## R11初始暂停准备记录（历史）

用户已在Router ordinary披露精确单方法临时JUnit停用、实际验证4pass1skip非vanilla之后ask_response明确确认。来源是本Handoff inline，不造单独ask路径/时间。新 `D-G1-CORE-BASIC-TEMPORARY-DISABLE` 只为后继该暂停，不撤销原G1验收。matched tuple仍是本Work、[Context](context.md)、[Plan](plan.md)与唯一[Waves](waves.md)。

后继唯一source owner是 `minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt` 中 `Basic Minecraft Build()`；只允许Disabled必要import/单方法annotation及明确temporary原因，完整原body/fixture/8.2-8.6-8.8 loop/其余Core四空方法/Forge全部测试/root不动。原core:test必须实际fresh证明唯一该方法skipped，5tests=4pass1skip0fail0error，不说5/5。

当前唯一准备结果是四份派生协调文档与独立静态证据（历史原件不可访问；见顶部保留说明）；不实施源码或执行Gradle/Java/tests，不写Todo、不委派/接受/释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`，Root已存在launcher1.9.0-M1；原R09 raw/accepted **partial**（5tests/1failure/0error/0skip）、R10 **waiting/not-run**、W03/I05/I06/Git未ready保持。新暂停完成也不释放这些原gates，不将原五fresh全部pass/旧selector/三版本谓词降为skip通过；vanilla仍gap，`fullStrictScope=false`与unknown Ruff历史保持。

仅新增一个暂停item `G1-I04E-R11` / `VG1-POST-10`，置于同图独立 `G1-W07`（前置原W02 gate），不是第二Plan/graph。原46items/6Waves保留，现47items/7Waves。R07及必要既有accepted基础和W01/W02 gate是completion前置；已验证R09 Root/source/CP失败只为readonly证据，不要求R09completed，不要求先修旧fixture。静态structurally-ready不是native完成或Router放行；当前唯一新可readyitem为R11，所有执行细节只在[Waves](waves.md)。

旧experimental/fixture repair方向明确 **deferred**；compatibility proposal **cancel-proposal（从未启动）**，被本暂停方向取代，不将用户取消记为completed，不删旧失败/身份。原root单行许可及旧writerPermission仅标注历史preparation，不给当前writer源码权限；后继仅R11该方法annotation/import例外，其他host/fixture/Forge/root保持readonly。以下所有旧“当前/最新/ready/宿主只读/未运行”文字按原记录当时理解，不与本首节竞争当前范围；旧图原完成谓词仍有效，不能从历史文字放行。

## R11准备前协调记录（历史）

下文完整旧记录保留其原义；当前实施许可仅以本首节和新R11 scope为准，原norm/原completion与失败仍不变。

## 当前root launcher continuation（R09 partial，R10 等待）

用户最新ask明确选择“授权查询及有界候选修复/重验”，本轮派生许可标识 `D-G1-JUNIT-LAUNCHER-CONTINUATION`。原图准备 raw partial/strictscope 失败保留。R09 generation1 已实施并消费完整 Result，Router 独立只读核验 exit1/errors=[]/54 members/receiptChecked=true；唯一 launcher1.9.0-M1 单行生效，其他272 inputs、52 Git及旧包匹配。原 core:test fresh 5 tests/1 failure/0 errors/0 skipped，4通过均为原空方法；Basic Minecraft Build 在首个 Gradle8.2 阶段出现19条脚本编译错误，8.6/8.8未到达。首JUnit discovery边界已实际越过，原regression不足completed：R09 raw/accepted状态partial，R10未ready，W03/I05/Git未释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`；metadata/worker/core失败证据见R09（历史原件不可访问；见顶部保留说明）。unknown Ruff的fullStrictScope=false与旧Bash/PATH失败保持；后续四coord变更是父协调投影，不能改旧冻结快照或重放其current-tree等式。

原精确许可仍仅 `E:/Projects/cloche/minecraft-codev/build.gradle.kts` 共享测试dependencies新增一条 `testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.0-M1")`；原API/engine、其他coordinates/owner/断言/fixture/算法/五fork与Git边界保持。未来native验证允许正常获取已声明依赖及原源码实际选择的TestKit 8.2/8.6/8.8，不能换版本、安装JDK或改全局配置。

原R08 generation1/2仍historical-only **partial**，原默认exit1/2367输出/2373+12与receipt-bound extra2保持；62旧fresh tests不证明core executor通过，24行/direct/coreABI/逐fixture compiler仍缺闭包。首LauncherFactory机制 **supported、非唯一cause**；诊断/review raw partial与非UTF8编码恢复、167/176/53历史保持。PID151144属性支持core Java11，不等于确定Executor20映射；封存Gradle9.4文档示例为JUnit5.7.1，非JUnit6。

已完成native query三尝试真实exit **1/1/0**：Windows quoting未启动Gradle；root跨project无exclusive lock；仅临时query owner纠正后离线成功。Gradle9.4只调两个metadata task，API/engine5.9.0-M1、Platform engine/commons1.9.0-M1/BOM5.9.0-M1，无launcher/unresolved/artifactfailure。configuration files45/46与实际Test CP51/52皆无Factory；JavaLauncher JBR11.0.16与GradleVM Microsoft17.0.19分层。候选缓存JAR最大major53只是静态匹配，不证明worker可见/discovery/testpass。query raw Result **partial**；本writer在新增目录/文档前独立重跑默认只读入口exit1、errors=[]、receiptChecked=true；unknown Ruff严格scope失败，metadata成功不接受G1。

保全锚为273inputs `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`、52Git、query63members/53sources及旧176/53/2373/12。query实测正常generated仅 `build/reports/problems/problems-report.html` 的具体旧新hash；不是build目录allowlist。未知 `.ruff_cache/0.12.0/8623379424694068166` 及两review历史路径均未归属、未授权，后续新漂移继续逐path/length/hash披露；`fullStrictScope=false`、`functionalGatePassed=false`、W03/I05/I06/Git未释放。新增协调字节不重放旧current-inventory/default equality、不重封父包。

唯一active continuation为既有accepted功能R06A/R06B（raw partial保留）、R07/P01/P02/R04/R05基础 → **R09单行root修复及focused原core:test → R10独立同最终273identity全五check/24row验收**。原R08不再是requiredCompleted，不能partial死锁。R09/R10均missing/not-run；结构上只有R09 ready，不是dispatch/接受或运行回执。I05/W03统一消费R10完整Result，I06/W04与另确认Git门槛不变。精确owners/refs/依赖/验证在唯一[Waves](waves.md)，策略在[Plan](plan.md)，许可/authority复用在[Context](context.md)。

静态准备封包（历史原件不可访问；见顶部保留说明） 保存before/after四doc及diff、联合DAG/ownership/ref/readiness assertions、原默认真实bytes/receipt、273inputs/Git/旧source-member保全和严格scope结果。静态ready不代表runtime充分性。

## R09准备前协调记录（历史）

以下保留原协调记录/原义及其当时“当前/最新/ready/missing”措辞，不是现时执行状态或新增许可；当前scope/状态以上节为准，唯一执行依赖以Waves当前JSON为准。原Result/完成谓词/失败证据不改写。

这是唯一派生协调入口，matched tuple 为本 `work.md`、[Context](context.md)、[Plan](plan.md)、[Waves](waves.md)。原图准备仅更新四份文档并形成静态图证据；当前实施状态由 Router 的 [Waves 接受记录](waves.md#当前执行状态router) 跟踪，历史准备说明不替代实际 Result。当前 P02 已接受完成，V02 generation4 为已独立核验的 partial；mixins/Fabric/Forge check成功，core/includes未到达，两个只读诊断均已 completed；用户已精确许可 core17/7destination/4JvmName 与单一 nested argv 扩展。R06A raw Result 为 partial，但其功能完成条件已由 Router 独立核验接受：32条内容finding消除、native core compile exit0、恰余七条filename。R06A 的 strictScope 仍因未知 `.ruff_cache` 漂移失败，未提升为严格完成；R06B 已按精确行号澄清后的功能完成谓词接受，raw partial/strict失败保留；R07已独立核验并接受completed，R08 generation1/2已返回partial并经补充入口独立核验；core:test启动阻断，最终gate未释放。

用户最新选择“授权两项最小扩展（推荐）”，记为 **D-G1-CORE-JAVA8-CONTINUATION**：R06A/R06B 合计仅许可 Context 明列的17个 core 原文件、七 rename destinations 与四个 `@file:JvmName` 旧 facade 保全；R07 仅在原 `PatchedMinecraftTests.kt` nested `withArguments` 增加 `--rerun-tasks`。原 fixture/Java源/断言/生产算法、依赖、五 fork、未知 core/includes/其他 owner 与 Git 禁令保持。既有三声明维护和完整 G1 必要直接补证许可保持历史与原边界；本 Handler 不运行 Gradle/Java/formatter，也不启动、接受或放行修复。

## 目标、权威与当前状态

交付既有 G1 Mixin 预应用链：每操作隔离与任务域插件、输出绑定的应用记录、保守选择性清理、Fabric/Forge/NeoForge 引用一致性、可选精确映射，保留普通 Mixin/StripMixins 和 touched AW/AT/patch/nested baseline。权威保持 [Active PRD](../../prd/codev-mixin-rework.md)、[Active Spec](../../spec/mixin-preapplication.md)、同一 [Accepted ADR](../../adr/mixin-operation-isolation.md)；逐 family **reuse** 及 A1/AT/nested 原义见 [Context](context.md#post-v01当前权威与必要闭包)。新说明不创设技术或产品承诺。

W01/W02 与 I01–I04D 已有完成记录；R01/R02/R02C、patch诊断及 R03P/R03V/R04 的已接受 completed 按既有 Waves/Results保留。原 I04E generation1、原 R03 partial/blocked、V01 **partial** 和全部失败 history 原样保留；V01 转为 historical-only acceptance 前身，不要求把它改成 completed。W03–W06、I05/I06 当前仍未释放。

## 唯一当前串行图与交付界限

完成前置是 `G1-I04E-P02(completed)` 与最新精确许可；唯一 active continuation 为 `G1-I04E-R06A(accepted functional completion, raw partial) → G1-I04E-R06B(accepted reconciled functional completion, raw partial) → G1-I04E-R07(completed) → G1-I04E-R08(partial)`。R06A 的 strict scope 失败仅由未授权 Ruff cache 漂移造成，不阻断 R06B 的源码前置；V02、两个已完成只读诊断仅作历史证据。I05 需 R08 completed 与 W03 gate；I06 仍需 I05/W04。R04/R05/P01/P02 原 completed 状态保留。P01 已接受 25/25；P02 generation4 的新闭包 fresh56/56、独立默认只读 verifier exit0，固定273 inputs identity `b2e9afeef8f811468a44569c03f9019ab36c640ac513db0e218c8e6e4cd84e5b`。P02 generation3 的51/51 partial与失败包保持历史原字节。V02 generation3实际五check命令exit1，mixins/Fabric check通过，Forge测试ktlint阻断Forge/core/includes；52项fresh tests与补充双TestKit2/2零失败。V02的2863成员封包独立verifier exit0，只证明partial可信。Forge两test owner格式补救及其75成员/273inputs/旧证据保全已独立exit0，271个其他inputs不变，ktlint与PSI通过；新的最终identity必须重新捕获并fresh验证全部闭包，不继承旧P02身份。上述generation3与样式补救保留历史。最新V02 generation4/continuation-g3独立verifier exit0，273-input identity `373f897c8fcce3487fb85cb1a8566326aa4a557dfd42536248faa460fd097e9b`，2586封存成员匹配；三个check成功，core主源码39违规/17文件阻断core/includes，62项fresh测试零失败，原双ForgeTestKit2/2但compileJava UP-TO-DATE使A11/AC11 partial。GRADLE_OPTS原继承值未捕获及Ruff偏差原记录保留。两个只读诊断已完成，按最新许可准备精确 R06A/R06B/R07 owners 与验证门槛；未知 owner 仍只读，W03/I05 不释放。精确 owners、前置/完成谓词、可读 source 接点与 verification IDs 只在 [Waves](waves.md#post-v01最小串行直接补证与独立终验)，策略和复用条件见 [Plan](plan.md#post-v01最小串行策略)。

R05 只做三 class import/声明维护与两个原生 validators真实 rerun exit0且`[]`。P01 沿既有四 suites闭合 producer FROM-CACHE→fresh consumer、same-JVM remapper A→无remapper B、operation域 engine/ASM provenance与unsupported诊断。P02 沿现有 consumer/provider suites闭合 exact identity、two-target all-success删除、fresh Fabric/第三方拒绝+legacy、真实旧注册以及有界 AT/nested 原能力；只有一个 Forge baseline test 为明确 planned output，现已由 P02 generation3 新增；该 focused handler 证明不冒充真实 nested-JAR pipeline。未知生产修复、依赖/ASM升级或政策变更没有授权。

V02 原 ID、latest partial、全部 Result 与失败历史转为 historical-only；当前终验由独立 R08 承担：在 R06A/R06B/R07 后的同一新 identity 上，全五 check、P01/P02 necessary direct closure、原 Forge 双 TestKit 与真实 Java8 compiler、全部 A1–A12/AC1–AC12 均须完整满足。旧 PASS/XML/UP-TO-DATE/manifest 不替代必要 runtime；仅 R08 完整 completed 经 Router 独立核验后才能重新接受 I04E、释放 W03/I05，随后仍按 W04/I06 门槛。partial/blocked/failed/missing 均不释放，也不授予 Git。

## R06B 当前接受与限定调试契约

R06B generation1 raw Result及原默认verifier exit1保持partial，原strictDebug=false与strictScope=false均未改写。Router独立复现新审阅入口exit0，13审阅成员摘要匹配：158对class，八类28methods/166项LNT恰+2、逐table count/order/BCI不变，其余150类行号保持，rawCodePayloadDifferences=0，runtime/API/metadata归一化等价158且module bytes相同。PRD/Spec/同一ADR reuse，无需新权威或同范围重复确认。仅补齐已授权四个两行file注解的精确生成调试效果；stacktrace行号/调试定位可观察变化如实披露，不能称class byte equality。Ruff未知writer漂移仍strict失败、不清理/恢复/授权。Router按澄清后的功能谓词接受R06B完成以接续R07，不宣称strict scope或G1通过；273-input identity `477d38dd2e0b4604d4f67a04c5e84fc5b6e72b61ccbbd0c7ac2f7c9056fdeb00`，原2024成员及13新审阅成员保全。R07 ready，R08/W03/I05仍等待。 见独立覆盖评估（历史原件已删除；原路径 `evidence/g1-implementation/r06b-debug-contract-review/report.md`）及R06B原包（历史原件已删除；原路径 `evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md`）。精确八类/166项及old/new绑定仅由Waves的lineNumberTableReconciliation定义，不授泛化debug忽略权。

## R08 当前 partial 与后续只读诊断

R08 generation1/2 的完整 Result 均为 **partial**；Router 独立重跑 verification-recovery/verify.py exit0，原2373封存成员、12补充成员、两final-receipt日志、273输入/authority/历史/Git/环境与临时属性保全通过。原verify.py成员集exit1和2367-member旧日志保留，不改旧seal。当前identity仍为 `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`。实际mixins/Fabric/Forge check通过；core:test不能加载JUnit Platform，core/includes check未到达，overall exit1；15 suites/62 fresh tests零failure/error/skipped不包含core执行器成功。24行partial、direct/coreABI/逐fixture Java8配对仍未闭合，functionalGatePassed=false、fullStrictScope=false，W03/I05/I06/Git不释放。接下来仅只读诊断JUnit运行时加载边界，不授新增依赖/源码/config权限，不运行Gradle或自动重试。证据见R08（历史原件不可访问；见顶部保留说明）与补充校验（历史原件不可访问；见顶部保留说明）。

## R07 已接受的历史终验前置

R07 generation1完整Result completed已消费；Router独立默认只读verification.py exit0：单一nested --rerun-tasks diff，原双TestKit fresh2/2、两个compileJava/fixture jar实际EXECUTED且各自Java8 worker编译栈/工具身份/父TestExecutor/重建窗口绑定，major52及compiled class/JAR逐字节一致。临时generated JDK8发现属性finally精确恢复原不存在状态，继承环境受限摘要/outer属性保持；其他272inputs、64297历史文件和Git保持。273-input identity `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`；89新成员保全。内部forge-patch-8/mappings-3/remap-4命中自有缓存，不宣称这些内部action重做；unknown Ruff漂移披露，fullStrictScope=false保留。R07 accepted completed，R08成为唯一runtime-ready节点；新树终验仍须fresh五check/全A-AC，不能继承旧XML/P01/P02/PASS，W03/I05/Git不释放。 证据见R07（历史原件不可访问；见顶部保留说明），下方旧missing/前置锚保持历史，不与未来新树强求default snapshot equality。

## 来源、保全与剩余限制

post-v01-validation-diagnosis（历史原件不可访问；见顶部保留说明） 与 post-v01-matrix-audit（历史原件不可访问；见顶部保留说明） 是规划来源；不是runtime通过。V01 README 的 Fabric/Forge validator FROM-CACHE表述与 native日志冲突时原生日志优先，原包不修订/重封。ASM9.6 operation域与外层9.9.1 metadata是待闭合归属，未据此证明coherent engine矛盾或升级依赖。

新 post-v01-repair-plan（历史原件不可访问；见顶部保留说明） 独立保存四coordination before/diff、272inputs identity、全可枚举repo/Git/index及旧19包/两诊断/V01保全、graph verification、默认只读verifier日志与manifest。不改任何旧默认verifier的冻结coordination。**原图准备的严格全仓交付谓词当时未满足**：图检查通过，但显式 `--after` 实际 exit 1；除四 coordination 外，已有 `.ruff_cache/0.12.0/7846417971863111690` 也发生 hash/bytes 漂移，见 scope-failure（历史原件不可访问；见顶部保留说明）。不清理或改写该缓存，不弱化只四文件变化约束；默认严格只读核验须如实记录失败。完整文档准备不能据此视为已验收，runtime全部留给后继，不宣称功能完成。局部覆盖若实际无法满足原authority只block该覆盖，不扩大生产/政策写权。初始规划与维护历史仍在 Context/Plan、Waves原Router块以及旧sealed evidence；没有新PRD/Spec/ADR/Tasks/治理层。


本轮静态准备证据为 v02-core-java8-plan（历史原件不可访问；见顶部保留说明）：此次 pre-edit 四文档已含 Router 部分编辑，独立保存 before/diff/after、273-input 锚、所核查历史封存及 Git 保全和默认只读验证。旧图准备的 Ruff 偏差与原失败保持历史，不能解释为本次额外写权。新协调字节变化不属于生产 input 漂移。只报告 `G1-I04E-R06A` structurally-ready；没有 Handler 源码 Result，也没有 runtime gate 通过。

## R06 generation1 blocked 后的精确单-outcome分解

Router 已读取 `codev-v02-core-lint-repair-r06` generation1 完整 Result：**blocked**，内容格式与七rename/API保全是两个独立outcome，Handler在执行前停止，无源码/rename/build/evidence副作用。原 `G1-I04E-R06` 身份、原定义与历史证据保留为 **historical-only**，不参与当前completion门槛。旧父包 generation1 partial 与 Ruff漂移（写入者未知）保留；不运行旧默认脚本的新树 equality。

当前唯一串行执行分解为 **P02(completed) → R06A → R06B → R07 → R08**；仍只有一个 Work/Plan/Waves tuple、6 Waves。当前44 items；本次只准备派生文档，不执行任一节点。W03 requiredCompleted列R06A/R06B而非旧blocked R06；I05与W03保留R08最终全矩阵门槛。V02 latest partial与旧I04E/V01/V02继续仅为历史证据。

- **R06A / VG1-POST-05A**：一个Handler/Result，唯一修复原生32条内容规则。许可仍只覆盖原17sourceOwners的已报告imports/标点/缩进/换行/注解布局；14个有内容违规，三个filename-only文件无需修改且字节保全。不rename、不加JvmName、不改caller/其他owner。完成要求语义等价、native core compile exit0；独立fresh原生core lint预期exit1，完整报告恰剩原七`standard:filename`且无新增/其他违规。禁止关掉/筛掉filename规则冒称全lint0；该残余由R06B完成，不等同final gate通过。
- **R06B / VG1-POST-05B**：一个Handler/Result，仅在R06A completed后执行；唯一完成七文件物理命名迁移且兼容性不变，只覆盖原七source/destination与四@file:JvmName必要相邻注解格式，不泛修另外十source。四显式fixed为`ServerExtractionStateKt`、`Build_utilsKt`、`Path_utilsKt`、`Source_set_helpersKt`；`GetMinecraftFileKt`、`ExtensionKt`、`IsUnobfuscatedVersionKt`为默认名需真实编译核对，不能称七fixed授权。三case-only移动用同目录unique临时basename两步实体rename，保存实际路径/case证据。迁移前归档七facade/JAR/API/default桥/Kotlin metadata/旧caller字节；迁移后完整core compile/JAR、native core/includes validatePlugins和core lint均exit0，旧binary链接保持，不修改/重编旧caller隐藏ABI变化。允许SourceFile/SMAP/source-JAR路径差异，另仅按Waves精确LNT契约接受本次八类/166项行号+2（逐method/table count/order/BCI不变）；其余runtime/API/metadata保持，旧strict-debug失败仍保留；允许generated evidence probe但不新增项目test/build owner。
- **R07 / VG1-POST-06**：completion前置改为R06B completed（传递闭合R06A）；原单一nested argv `--rerun-tasks`、原fixture/source/断言和build-root ownership、五fork、真实Java8 compiler与Java8→Java17进程TestKit、精确环境恢复、Java11五module既有产物和保密门槛保持。
- **R08 / VG1-POST-07**：显式要求R06A、R06B、R07均completed；原同树fresh五module check、A1–A12/AC1–AC12、P01/P02 direct closure、Forge两TestKit/nativeCompiler独立验证全部保持。

R06A/R06B不清任务增量或其他cache，不获得R02C式移走state许可；真实compile暴露旧incremental state问题时据实partial及证据。原fixture、断言、算法/literals/providers、依赖/版本、未知includes/其他owner、五fork/Git权限均保持原边界。保留原逐family authority reuse，不修改PRD/ADR/Spec/DDD。仅**R06A structurally-ready**；R06B/R07/R08等待completion前置，未启动、未接受、未释放W03/I05/I06/Git。新静态封包见continuation-g2（历史原件不可访问；见顶部保留说明）；当前273inputs为准备前锚，旧冻结scope和旧parent graph/manifest/receipt/脚本均只读。
