# Mixin 静态 Gradle 测试迁移 Plan

[Work](work.md) · [processed Context](context.md) · **唯一匹配执行图：[Waves](waves.md)**

## 最终收口记录

**Router已核定MST-W02全部条件满足（satisfied）。** 已可靠采用17个静态owner completed：R13/R14/R15/R34/R17/R18/R19/R20/R21/R35/R27/R28/R29/R30/R31/R32/R33，以及R24/R25/R26 generation1 completed，共20个实际成员；R26独立结论ready、无阻断。此处仅同步Router既成判断，Handler未自行验收或释放gate；不另声明released。

R24仅删除InputBinding的13行无caller代码，目标compileTestJava实际重新编译成功，未运行测试。R25在R24最终输入上从根:test同次实际执行18类131方法（Mixins101/Fabric14/Forge16），零failure/error/skip，48 actionable tasks全部executed；三个模块test实际执行，根:test正常NO-SOURCE。151个静态Jar、R35全部21包及43条资源copy记录、嵌套缓存和真实故障/fresh retry均由当轮证据关联；G11原两方法包含其中。历史34/59/80保持各自版本和运行，不拼入本轮131。

R26逐项支持11类、S1–S8、F01–F18/G01–G18、R07全部16行及20成员要求。R24报告两处非阻断误述在此纠正：refmap实际selector为`mapping-mod`/`mapping-legacy-mod`；InputBinding:495实际将`probe.jar`的`resource.txt`改为`current-input`，并非fixture.json。原build报告不改写。详细处理事实及仓内导航见[Context收口证据](context.md#最终收口证据与限制)，唯一图及原gate见[Waves](waves.md#mst-w02-残留生成链恢复图)，范围和成功条件仍由[匹配Plan](plan.md)持有。

R23保持excluded / exception，保留Random/JarOutputStream/cleanup动态基线和全部正常/故障/retry保证，不记completed或failed、不作成功前置；R34/R35承接不抹去R16 blocked、R22 g1无终态/g2 failed及候选撤回。R23旧completed身份not-verifiable、I01/I03/I05 blocked、R02 partial、R08/R10旧not-ready及其他失败/局部历史均保留。PRD/ADR/Spec继续reuse；未改成员、边、谓词、gate合同或例外。

本轮仅四文档C5事实维护与静态自检，零构建、零测试、零代码/资源/配置/authority/build证据/Git写入。R07全历史树hash缺失、build证据可clean、部分temp仅能通过当轮XML/stdout及原断言关联，未检查全仓、游戏或MC下载；加工记录不承诺完整原Result永久可取。

## 范围与成功条件

复用[三族assessment](work.md#权威复用与-owners)：[PRD](../../prd/codev-mixin-rework.md)及[译本](../../prd/codev-mixin-rework.zh-CN.md)、[ADR](../../adr/mixin-operation-isolation.md)、[Spec](../../spec/mixin-preapplication.md)及[译本](../../spec/mixin-preapplication.zh-CN.md)。用户已确认原测试组织范围并授权开始修复；本轮只维护派生图，不实施。生产目标、Task/Transform、通知资格、隔离/缓存/故障合同、fixture属性及JDK跟随策略不变，无material authority gap。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 历史MST-W01十三实际member completed、R12 ready、Router satisfied/released、根131/131与Fabric14/14保留。旧S1/S8“无剩余遗漏”判断过宽；R22 generation2 failed及候选执行/等价失败/撤回/旧driver34通过、R35已采用completed及21包资源化/删writer/同版34通过均保留。R34及其他已采用completed仅为背景，不另登记或重验。**当前W02 pending；R23依用户明确决定保留动态输入生成，仅排除StripStreamTests固定stream-copy基线打包，移出实际执行成员，不记completed或failed。** 资源化候选曾独立review通过、未获用户实施批准，现明确排除；旧错误completed声明身份未关联，见[Context](context.md#r23-事实更正与冻结来源)。本Plan恢复完成仍须[MST-W02 gate](waves.md#mst-w02-残留生成链恢复图)满足，W01释放不代替当前验收。

| 条件 | 必须可观察的结果 |
| --- | --- |
| S1 可读性与实际替换 | 普通build/settings、Java、JSON/TOML、tiny/refmap进入静态项目，由JavaCompile/Jar生成输入；R35的21个特殊包已按原字节测试资源承载，经现有processTestResources/classpath复制后真实消费。StripStreamTests固定stream-copy基线为用户确认的动态例外：保留约40KiB随机payload及@BeforeEach的Random(31)/JarOutputStream/cleanup生成，正常entry/metadata和全部故障/保护/retry断言不减。其他固定生成入口按原合同替换；保留动态逻辑逐caller说明必要性或明确例外。 |
| S2 完整流与精确内容 | 真实 producer→通知→两侧 Strip→caller，1→42、精确原 config/entry 键、跨数组/JAR 全匹配、A/B 隔离、未通知项/资源保留、resolution-only/external 排除、applied-only 与 cleaned 区别及原输入不变均保持。 |
| S3 当前输入与缓存 | plugin body/resource、顺序、mapping、side/context、native 值及 unset/default、implementation/Kotlin runtime 内容变化产生当前结果；SUCCESS/UP-TO-DATE/新进程 FROM-CACHE、两侧 Strip 首次与缓存恢复都有消费内容证据。 |
| S4 独立 Strip 与失败消费 | cleanup 和 inputArtifact 独立变化；合法空对象/空数组不清理；成功 UP-TO-DATE 后缺 cleanup 必须失败，真实解析/DOM 错误失败；source/target Strip 失败与当前 producer 失败不能路由旧成功，独立完成的 applied-only 仍可用。 |
| S5 名称、平台与当前 metadata | 真实 mapping/context 的成员/类/owner/overload/descriptor/direction 结果；Fabric 外部环境与内部 kind 交集；Forge/NeoForge 双格式发现及各自编辑职责；snapshot 与 current metadata 的时间顺序、未知/新增/未通知内容与触及路径 AW/AT/nested 既有保证保留。 |
| S6 局部边界与恢复 | 直接组件、流故障/异常对象/suppressed/关闭顺序、输入输出别名/硬链接/目录与双输出保护、TCCL/selector、实际失败后新鲜 retry 保留，不能以 TestKit 成功取代。 |
| S7 执行接入 | 根 `:test` 依赖三个模块 test，最终有限组合实际执行三个模块新驱动；R02 接线保留，R04 的根入口有限验收已完成。继续 pluginUnderTestMetadata 和现有测试 SPI 注入，核心规则/descriptor 与平台 adapters 实测可见。普通 Java release 11、`-proc:none`；故障接缝适用 JDK17。 |
| S8 最终组合与可追溯 | Waves 覆盖矩阵每行有实际测试/断言对应；必要 helper 删除无遗漏调用，条件式双语 Spec 源码链接同步；最终共同版本有限组合验证覆盖迁移改动和共享使用者。 |

## 最小策略与所有权

普通固定Java/JSON/refmap/资源/ZIP输入和完整caller继续由既有ordinary/pipeline静态工程的真实JavaCompile/Jar构建后复制到测试私有目录。R22恢复已采用用户确认的对应测试资源：StripMixinsTests的21个冻结包（33 entry、4824 bytes）放在模块src/test/resources/net/msrandom/minecraftcodev/mixins/strip-mixins/，固定cleanup.json同域承载；现有`:minecraft-codev-mixins:processTestResources`→test classpath→类资源流/Files.copy→@TempDir私有路径→StripFixture/原断言。缺资源直接失败、关闭流，不fallback生成；不新增fixture Copy任务、fixture系统属性、writer、DSL或框架，不要求资源再经过fixture Gradle构建。复用已有sourceSet、helper、系统属性和SPI，不加新fixture框架/DSL/manifest/CLI/includeBuild或dependency。逐个可独立保留/恢复的消费者迁移：同FQCN隔离输入、合法故障源、完整pipeline、defaults/native/Kotlin-runtime/task-only、直接输入保护/cleanup/ordered-domain、独立Strip及固定资源/特殊ZIP；必要helper和回归只随其结果归属。唯一item分解、成功前置和冲突串行路径在Waves，Plan不另列执行图。

保留真正当前输入变化、当前生产class的ASM/defineClass、动态通知、同JVM顺序/并发、临时control路径、特殊ZIP局部重复/截断、真实stream/read/write/close/权限/alias/hardlink/目录/发布故障与fresh retry。R35的21包已按整包hash及原始local/central metadata证明五阶段复制保真，接通全部固定caller后删除固定writer，全部extra保持，本轮不重开。

StripStreamTests重点是流故障注入、失败清理和成功重试，用户明确认为不值得将约40KiB随机payload打包。排除只覆盖该类固定stream-copy基线，不扩展到其他测试/静态owner；保留其Random(31)、JarOutputStream、cleanup现场生成及原期望值/断言。当前策略不再要求strip-stream资源、资源copy、删除该固定writer、新增冻结长度/hash断言或R23专属17方法迁移验收。旧候选及审计数据仅为历史；保留动态生成不等于静态迁移完成。

全局生成入口收敛消费17个仍承担静态迁移职责的owner的真实完整可关联、证据充分的completed Result，核对R34承接R16和R35承接R22；不再等待R23 completed。收敛逐caller记录StripStreamTests明确例外并保留全部测试保证。最终组合、独立充分性判断分别保持原合同；W02为20个实际member，R25根131同次组合仍含G11两方法，R26仍须独立ready，其他原gate条件不减。R16 blocked及已发生效果、R22 failed与旧34、R35 completed与新34不互相改写。共享helper/静态工程/资源、Gradle/TestKit/JVM/cache和证据快照继续串行；移除R23执行段后由已结束R35资源释放衔接收敛，不制造额外成功前置或重演已完成owner。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 首次独立review completed/not-ready、上轮细分局部completed/ready及R23资源化候选独立review通过均保留为历史；候选未获用户实施批准，现明确排除。本次material变更为限定例外、撤出R23执行成员及调整后继连接，不改变产品/架构/故障合同。本轮只作作者自检，尚无针对本次变更的独立delivery-plan review证据；受影响边界仍按既有职责等待独立review和Router准入判断，本轮不执行、不新增审批协议。用户对动态例外的决定已明确，不再等待资源化候选确认。

## 验证安排与风险

聚焦验证按Waves实际selector/精确方法集合及直接/共享consumer执行；最终从根有限组合在一个最终相关工作树同次执行现有18类131方法（Mixins101/Fabric14/Forge16），逐方法关联真实断言/内容及静态任务消费。方法有变动就解释集合差异，不能以131passed代替静态化证明，也不拼历史运行。S6的故障接缝不以TestKit通过替代；F16六种真实故障后fresh retry、当前metadata内容与原输入保护继续验证。保留Java release11/UTF-8/-proc:none/major55，JDK17与Gradle实际版本及外层/launcher/fixture环境分层关联，不改现有跟随策略。

已采用P16/R34的原恢复验证合同作为背景保留（本次不实施或重验）：限定同一修正版本G04 16＋G02 18＋G03 8＋G05 9＋G06 7＋G10 1＝59方法，P16六方法内容/静态copy/缓存失败证据完整关联；共享43，不是61或77，精确方法及owner仅在Waves维护。旧59只证明旧版本；真实公共接口/普通writer变化才按实际闭包扩验。三层JDK完整实际版本/路径、外层锁定与--version、最终输入/diff/解析图及P16显式跟随接线均须证明，不能只靠当轮恰为17。新执行前后取得真实新版本标识，原运行后补before与after相同的缺失不能补造；R15有效清单仅有限对照八路径，残留目录项不算变更。首轮classpath失败与修复保留，完整首轮日志已覆盖，仅已采用工具事实可用；旧相关build证据先保全再运行，沿原机制，不建ledger/receipt。详细已采用事实及来源局限见[Context](context.md#r16-实际效果与证据边界)。

R35已在同一资源迁移最终相关版本实际完成以下既定验证合同（本次不重跑）：G04 16＋G09 11＋G10 1＋G11 2＋G13 4＝34方法（五个完整类selector，精确方法在Waves），0failure/error/skip、外层test SUCCESS/executed；旧R22原driver34不替代。正常资源处理task/输出、classpath来源、各私有副本hash与11个G09方法实际消费逐一关联；保持双处同名patch、坏ZIP/截断、cleanup局部变异、权限/alias/hardlink/junction/目录/真实故障及fresh retry。若确实修改公共helper/StripFixture，则按实际消费者闭包扩验G01–G14，单纯类内资源复制不机械扩至101。记录真实执行前后源码/资源/输入标识、当次命令/日志/XML/故障命中、三层JDK17完整版本/路径与锁定、wrapper/解析图；旧证据覆盖前保全，build目录残留不能全算当轮产物。

G11原两方法仍在R25最终相关版本根有限组合内实际执行、0failure/error/skip；正常entry/content/order/method/time/comment/extra/directory/size/CRC、JSON whitespace/unknown和原输入bytes检查保持。故障方法继续对当前class ASM/defineClass，禁止生产普通entry readAllBytes；read/write在8192后真实故障，read-close/input-close/output-close等关闭故障、hit/exception identity/suppressed及全部关闭保证保持。每模式先成功→真实故障→无当前output/临时staging且source/cleanup不变→撤销故障→fresh retry精确payload bytes，不能用TestKit或历史R22/R35 G11通过代替本轮组合。R23候选17/88方法和五阶段冻结资源核验不再是当前实施要求；其他owner及共享helper实际闭包保持Waves原合同。

已采用的[失败报告](../../../build/mixin-r22/report.md)及[原始对比/hash](../../../build/mixin-r22/zip-local-central-comparison.json)限定R22历史失败与R35冻结来源，不是本次新通过证据。R35资源配套说明已落地；本次不创建StripStreamTests资源/说明/hash文件或复制包。候选冻结来源和精确hash保留于Context/Waves历史，build可清理，不作为动态例外的运行前置。

主要风险仍是同FQCN进入宿主掩盖隔离、合法失败源被javac提前失败替代、caller/cleanup direct input丢失、缓存掩盖当前执行、特殊ZIP metadata变化及共享writer提前删除/遗漏caller；对应原任务/内容/故障断言和全链审计继续必需。新增文档风险是将限定stream-copy例外泛化，或误删其writer/降低断言：R24逐caller核对范围，R25保留G11两方法，R26检查全部原保证及例外未扩散。R23旧completed身份缺口不被例外修复或追溯为新failed；恢复只处理自身未完成边界，旧证据保全，不清build/user-home。

历史R01 ordinary80/80、I02 mapping8/8与直接消费者29/29、R03独立Strip1/1、R04 Mixins101实际执行/Fabric17与Forge16 UP-TO-DATE、R05 TestKit10/10，仅支持各自当时范围。R02 partial/133+1、I03 blocked/草稿、I05 blocked/部分效果、R06局部2/2、R08/R10 not-ready永久保留，详情与可清理build导航见[Context](context.md)。R09根18类131与R11 Fabric14、R12ready支持旧版本验收，不证明本轮将改动的生成链；是否复用必须以最终diff/inputs/source/environment/freshness判断。R07完整历史树hash缺失、部分原报告未重取，派生记录不承诺永久原始Result访问。

## 作者自检与当前边界

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 本轮同步S1/策略/排除/风险/验证与R24–R26/W02连接。R23只作可审计excluded / exception范围记录，不新增state或Result协议；17个静态owner→收敛→同次组合→独立充分性保持真实边界，Waves仍为唯一执行图。互链、引用、联合等待/串行无环和历史保留检查见[Waves作者自检](waves.md#当前作者语义自检mst-w02非独立-review)。这是文档维护完成，不是独立review、实施确认、R23完成或W02释放；本轮不改源码/资源/build/依赖/lock/authority/Git，不运行Gradle或测试。

## R23 旧候选与前轮作者检查（已排除，仅历史）

以下保留被替代的候选段落；“本次/未来/须/待review或确认”属于前轮计划时点，不是当前要求。候选此后曾独立review通过，但用户未批准并明确排除；当前范围以上文及Waves实际图为准。

> 历史MST-W01十三实际member completed、R12 ready、Router satisfied/released、根组合131/131与Fabric14/14保留。残留审计证明旧S1/S8充分性过宽：固定输入被用于隔离/失败场景，不代表固定源码/资源必须动态生成。**当前W02 pending、组织未证明完整；R22 generation2已采用failed，候选Jar任务执行/等价失败/撤回及原driver34通过永久保留。R35已完成并采用，21包资源迁移/删writer及同版34通过见Context；R23当前固定writer仍存活，静态迁移未获满足。旧“R23已采用completed／R35唯一剩余”声明身份未关联，原文字与更正见Context，不推断从未执行或制造failed/恢复ID。R34及其它已采用completed仅为背景，不另登记或重验。本次仅准备R23承载方法候选，待独立review及Router C6 affected-scope披露/用户明确确认，不把R35确认延伸至R23。本Plan恢复完成仍须MST-W02全部gate满足，不能复用W01释放。**

> 保留真正当前输入变化、当前生产class的ASM/defineClass、动态通知、同JVM顺序/并发、临时control路径、特殊ZIP局部重复/截断、实际stream/read/write/close/权限/alias/hardlink/目录/发布故障与fresh retry。固定baseline与其后必须发生的动态变化分开；死生成入口删除，共享writer保留时逐caller解释必要性，不能只按方法用途标签豁免。R35特殊输入先以整包hash及原始local/central metadata证明冻结来源→仓内资源→processTestResources输出→consumer私有副本保真，接通全部固定caller后才删fixture/archive(Map)/STORED固定writer；21包均保留extra，不能只特例两包。R35已按上述删除前置完成。R23原合同要求先证明Gradle Jar逐entry等价才删固定writer；本次候选以完整原字节资源的五阶段保真替代其Jar-task承载前置，保留全部六entry/order/method/time/comment/extra/directory/size/CRC/bytes、固定cleanup及流故障义务，不能借资源化减验。候选以[已核实现存来源](context.md#r23-事实更正与冻结来源)的input.jar（80882 bytes，SHA256 `530ee6cd5d5140c9697643a772942a208fffd10574917a863de8481b347e9004`）及cleanup.json（53 bytes，SHA256 `2942c134c581e3042548dfdcda8dfc1f8e69dbcdc139f171c338c9091c7cc599`）进入未来strip-stream专属资源；缺失/不符则报告缺口，不生成。每测试先由现有processTestResources/classpath→类内关闭流的Files.copy→@TempDir，再执行原直接/反射StripFixture链。payload仅作为原retry期望值：从私有Jar的assets/data读出，独立核40001长度及SHA256 `e34c7a9ebc94f0bf4af307071ebd201d1bb9464bf2f083a94549e6deedfb8644`，保留原字节断言，不另存payload文件。未来短说明记录来源/hash/六entry语义以脱离可clean的build运行；现在尚未创建，不作可读ref。不新增Copy/Jar任务、fixture属性、helper框架，也不提取R35类内helper或重开其完成边界。

> 迁移各自可用；全局生成入口收敛依赖各有效迁移结果，最终组合依赖收敛结果，独立只读审计消费最终组合。共享Java基类/writer/helper、静态工程及Strip测试资源、Gradle/TestKit/JVM/cache与证据快照全部串行；共享读取不制造成功依赖。R22 failed是已采用恢复输入，不是成功前置；R35已完成，无需重跑或登记新任务。R23候选无其它迁移成功前置，但实施须待方法确认及相关写入者结束/资源释放；R35既成完成不因串行改动而重做。R24消费R35有效completed承接R22，同时必须等真实R23 completed与原完整保证证据，不能以R22/R35共享G11通过代替静态化或由收敛项补迁移；R25/R26及W02全部gate不减。旧R16 blocked及P16已发生效果、R34和其它已采用completed保留，不重迁、不另增登记任务，不以串行锁制造成功前置。

> 首次独立review completed/not-ready、上轮细分局部completed/ready各自保留；本次R23承载方法、等价/删除前置及payload断言方案的material变化须由不同Handler局部delivery-plan review覆盖R23、S1/策略/风险/验证、与R35及其它共享写入者的串行、R24–R26/W02必要连接；再由Router作C6披露/用户affected-scope confirmation。未取得R23本轮方法变更明确确认，文档与作者自检不替代确认。本作者不执行独立review，不调度、不完成实际item、不释放gate。

> R23候选聚焦验证为G11全2＋G09全11＋G13全4＝17方法，精确方法仍由Waves G表唯一列举；三完整selector为net.msrandom.minecraftcodev.mixins.StripStreamTests、StripMixinsTests、StripDomTests（后两者沿用相同包前缀）。须在最终R23版本一次实际执行，0failure/error/skip、外层test SUCCESS/executed，先证明冻结来源→仓内资源→现有processTestResources实际输出→真实classpath流→每测试私有copy的Jar/cleanup hash与全部ZIP保真，全部固定caller接入后才删Random/JarOutputStream/固定cleanup写入。保留readAllBytes禁止、8192后的真实bulk故障、当前class ASM、异常identity/suppressed/全部关闭/原输入与cleanup保护/无当前输出和临时staging/fresh retry原断言；payload长度/hash防止期望值随错误输入自洽。若确改StripFixture，加G02/G03/G04/G05/G07/G08/G12/G14实际消费者（连原17共88方法）；真实公共helper/writer接口变化按原G01–G14闭包101核对，不以类内copy机械扩验。保全旧证据，记录真实前后输入/源码/资源标识及diff、命令/XML/日志/五fault hit、三层JDK17实际完整版本/路径/外层锁定及Gradle/解析图，epoch观察用同一JDK/时区不改原时间。R22/R35两方法通过只是旧driver共享回归，不能拼作本轮17或迁移证据。

> 已采用的[失败报告](../../../build/mixin-r22/report.md)和[原始对比/hash](../../../build/mixin-r22/zip-local-central-comparison.json)限定旧失败与冻结来源，不是新通过证据。R35配套说明已落地，R23候选未来同样须随资源留下简短用途/原writer与测试来源/精确冻结来源及hash/六entry语义供审阅，避免日后运行依赖可clean的build目录；本次不创建资源说明、hash文件或复制包。整包hash证明所有字节保真，原始local/central名称与extra及Java实际entry观察用于避免名称正规化或局部metadata检查遗漏。

> 主要风险是同FQCN进入宿主classpath掩盖隔离、合法失败源被javac提前失败替代、完整caller依赖/cleanup direct input丢失、缓存重放掩盖当前执行、资源ZIP顺序/压缩方式/time/comment/extra/CRC变化、共享writer提前删除或遗漏caller。相应任务/内容/真实故障断言和全链审计均为必须证据，尚未证明等价及真实消费时不删writer、不削弱合同；R35复制保真不以旧失败Jar候选为来源。恢复可仅回退自身未完成迁移，不重做已采用独立结果；旧证据需保全，不清整个build/user-home。

> S1候选将R23整包及固定cleanup纳入自身测试资源；普通Jar与S2–S8、R23全部ZIP/流/输入保护合同不减。来源可达、实际两个consumer、payload无额外文件的独立长度/hash断言、资源/消费者写面、等价/接入后的writer删除、G11/G09/G13精确17方法及真实helper闭包、与R35串行、R24–R26/W02等待联合无环见[Waves作者自检](waves.md#当前作者语义自检mst-w02非独立-review)。本次material变化是R23由Jar-task承载前置改为原字节资源五阶段保真及对应回归/后继证据；不是accepted ADR，不声称用户已确认。R35真实完成、R22 failed、R16 blocked/R34承接与其它历史均保留，无独立完成登记任务。作者自检不是独立review，未完成任何迁移item、未释放MST-W02。本轮仅四文档维护，无源码/资源变更、测试、Gradle、缓存清理或Git操作。
> 
