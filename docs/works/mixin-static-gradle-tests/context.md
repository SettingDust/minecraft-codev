# Mixin 静态 Gradle 测试迁移 Context

[Work](work.md) · [Plan](plan.md) · [Waves](waves.md)

## 最终收口记录

**Router已核定MST-W02全部条件满足（satisfied）。** 已可靠采用17个静态owner completed：R13/R14/R15/R34/R17/R18/R19/R20/R21/R35/R27/R28/R29/R30/R31/R32/R33，以及R24/R25/R26 generation1 completed，共20个实际成员；R26独立结论ready、无阻断。此处仅同步Router既成判断，Handler未自行验收或释放gate；不另声明released。

R24仅删除InputBinding的13行无caller代码，目标compileTestJava实际重新编译成功，未运行测试。R25在R24最终输入上从根:test同次实际执行18类131方法（Mixins101/Fabric14/Forge16），零failure/error/skip，48 actionable tasks全部executed；三个模块test实际执行，根:test正常NO-SOURCE。151个静态Jar、R35全部21包及43条资源copy记录、嵌套缓存和真实故障/fresh retry均由当轮证据关联；G11原两方法包含其中。历史34/59/80保持各自版本和运行，不拼入本轮131。

R26逐项支持11类、S1–S8、F01–F18/G01–G18、R07全部16行及20成员要求。R24报告两处非阻断误述在此纠正：refmap实际selector为`mapping-mod`/`mapping-legacy-mod`；InputBinding:495实际将`probe.jar`的`resource.txt`改为`current-input`，并非fixture.json。原build报告不改写。详细处理事实及仓内导航见[Context收口证据](context.md#最终收口证据与限制)，唯一图及原gate见[Waves](waves.md#mst-w02-残留生成链恢复图)，范围和成功条件仍由[匹配Plan](plan.md)持有。

R23保持excluded / exception，保留Random/JarOutputStream/cleanup动态基线和全部正常/故障/retry保证，不记completed或failed、不作成功前置；R34/R35承接不抹去R16 blocked、R22 g1无终态/g2 failed及候选撤回。R23旧completed身份not-verifiable、I01/I03/I05 blocked、R02 partial、R08/R10旧not-ready及其他失败/局部历史均保留。PRD/ADR/Spec继续reuse；未改成员、边、谓词、gate合同或例外。

本轮仅四文档C5事实维护与静态自检，零构建、零测试、零代码/资源/配置/authority/build证据/Git写入。R07全历史树hash缺失、build证据可clean、部分temp仅能通过当轮XML/stdout及原断言关联，未检查全仓、游戏或MC下载；加工记录不承诺完整原Result永久可取。

## 当前残留审计与已接受范围

已完整读取并解码指定残留审计与authority核定Result。审计只读覆盖11个Java测试及相关静态输入/helper/resource：实际JavaCompiler调用在FailureStage、OperationIsolation、Mapping；InputBinding的ToolProvider只是遗留import，不是第四编译入口，但project/pipelineProject仍现场拼完整工程；StripRegistration仍拼独立caller。其余固定资源/ZIP基线也有遗漏。

PRD/ADR/Spec均reuse，无material gap；产品/隔离/缓存/故障语义不变。原确认范围中的OperationIsolation、Mapping、FailureStage、InputBinding完整caller、独立Strip及其余固定resource/ZIP静态迁移继续按原合同；当前输入变化/ASM/通知/同步control、特殊ZIP局部patch、真实流/关闭/权限/并发操作保留。R22候选失败与R35资源恢复completed事实见下文；完整清单、删除入口、实际caller和逐方法selector只在Waves。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> **当前MST-W02 pending；R22 generation2 terminal failed、R35 generation1 completed均已完整采用；R23现为用户确认的动态例外，移出实际执行成员，不记completed或failed。** 用户明确决定：StripStreamTests侧重流故障注入、失败清理和成功重试，不值得将约40KiB随机payload打包成静态资源；仅排除其固定stream-copy基线打包，保留动态输入生成。其他已完成静态迁移和后续R24–R26原合同继续适用。

例外不放宽测试保证：正常entry/content/order/metadata、8192后的真实bulk读写故障、read-close/input-close/output-close等各种关闭故障、异常identity/suppressed、source/cleanup输入保护、无当前output及无临时staging残留、撤销故障后的fresh retry全部保留。实际@BeforeEach的Random(31)/JarOutputStream/cleanup动态生成观察与旧错误completed声明、身份未关联限制保留于[下节](#r23-事实更正与冻结来源)。原资源化候选已通过独立review，但用户未批准实施，现明确排除；review通过不等于实施确认、R23 completed或gate通过。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 本轮只读取四份指定协调文档并采用Handoff的明确决定及已采用审计/执行事实，不宣称重新读取原Result、hash基线或重跑测试。R13–R15/R34/R27–R33/R17–R21及R35已采用completed仅为背景；R16 blocked/八路径59通过与历次独立review结论均保留。R24现等待17个仍有静态职责的真实owner completed，逐caller记录R23例外；R25仍须根131同次组合含G11两方法，R26独立ready，W02须20个实际member完成及其余原gate充分。例外不是把旧R23静态迁移判作完成；本次不释放任何执行项或gate。

## R22 失败事实与已确认恢复方法

本节加工Handoff中已完整采用的R22 generation2事实，并对照仓内[执行报告](../../../build/mixin-r22/report.md)、[原始local/central对比](../../../build/mixin-r22/zip-local-central-comparison.json)及当前[StripMixinsTests][strip]，不复制完整原Result，不以项目外session/Result locator作持久依赖。

- generation1 backend/pane故障且无终态Result；只读诊断completed已采用，resume generation2返回terminal failed且已完整采用。早期错误提取33个variant的一批位于 build/mixin-r22/legacy-baseline-generator-error，不能作为恢复输入；正确冻结21包在 build/mixin-r22/legacy-baseline，名称取[冻结variant清单](../../../build/mixin-r22/legacy-variants.json)。
- 候选ordinary中21个Jar task、33个entry确实executed/exit0，但21包各自首entry的local与central均丢失 feca0000 extra（各21处）；strip-path-4原始 a\bad 被改为 a/bad（local/central各1处），JDK17 JarFile同样观察到差异。Python ZipInfo.filename初检会正规化反斜杠，不足以证明原始名称等价；必须用原始local/central名称与Java实际consumer。不能只特例反斜杠包和STORED包：全部21包均需保留extra。
- 临时链仅到冻结writer包→marker资源→Jar task→candidate→对比，candidate未被StripMixinsTests消费；等价失败后候选源码撤回，固定writer删除0，原driver/StripFixture/OrdinaryInputs/生产代码未改，最终484项项目输入与initial一致。错误提取、比较assert、日志GBK解析失败及修正保留为证据程序历史，不能伪称首轮成功。
- 原driver当次G04 16＋G09 11＋G10 1＋G11 2＋G13 4＝34/34，0failure/error/skip。五类完整selector/精确方法与Waves相符；write/close/cancel/move、读拒绝、bulk read/close、双处同名patch、坏ZIP/截断、权限/alias/hardlink/junction/目录/冲突writer及fresh retry由原断言实际执行。它只证明旧实现，不是R35资源迁移通过；其它旧37/80/131不能拼入新34。
- R22已采用环境为Gradle9.4.0，三层Microsoft JDK17.0.19+10-LTS；解析图记录相同，未独立hash所有cache二进制。证据目录可能含旧retained文件，只按当次命令起止、五份XML与日志关联；源码版本由484项hash及initial-sources限定，HEAD本身不代表脏工作树版本。build证据可clean删除，不承诺永久原件或新版本适用性。

用户确认的21包（33 entry、合计4824 bytes）已由R35放入StripMixinsTests专属[资源说明](../../../minecraft-codev-mixins/src/test/resources/net/msrandom/minecraftcodev/mixins/strip-mixins/README.md)所在目录，经现有processTestResources/classpath复制到@TempDir。以下历史恢复合同已由R35实际证据承接，不是重新实施要求：冻结包必须匹配oldArchiveSHA256、不能用错误提取批次/candidate、不能重新生成/重打包；原始local/central名称、extra和全部ZIP内容/元数据、缺资源硬失败、双处同名patch、坏ZIP/截断/cleanup变异及真实故障/fresh retry保持。正常JavaCompile/Jar不变，无新增fixture Copy任务、系统属性、writer、DSL或框架。R23另有独立范围和确认边界。

## R35 已采用完成与适用边界

已完整读取并关联implement-r35-strip-test-resources generation1 completed；此处加工既成事实，不另做登记任务、不重新验收或放gate。见可读的[报告](../../../build/mixin-r35/report.md)、[五阶段及回归证据](../../../build/mixin-r35/verification.json)、[删writer前等价](../../../build/mixin-r35/pre-consumption-equivalence.json)、[当次命令](../../../build/mixin-r35/test-command.json)及[精确方法](../../../build/mixin-r35/test-methods.md)。

21包4824 bytes/33 entry、cleanup.json/raw-cleanup.json与说明已落地；来源→仓内资源→processTestResources输出→实际classpath流→私有copy五阶段SHA256/原始ZIP保真，全部固定caller改接，fixture/archive(Map)/STORED固定writer删除。同一最终版本G04 16＋G09 11＋G10 1＋G11 2＋G13 4＝34方法实际全过，0failure/error/skip；三层Microsoft JDK17.0.19+10-LTS、Gradle9.4.0，825相关输入运行前后稳定，集合标识`a0cc4be0bb24f7034665bda6cb58c5e5629c57b1c9222a4d478800ad1b1056b7`。实际动态patch、截断、输入保护与真实故障/fresh retry保持。未改共享helper/StripFixture或G11源码，G11通过仅是旧stream实现共享回归，不能替代R23静态化。build目录可clean、retained可能有旧文件，仅当次命令/XML/日志精确关联证明该次结果；不宣称目录所有文件均当轮新产。

## R23 事实更正与冻结来源

当前采用用户明确的excluded / exception范围语义：保留StripStreamTests动态生成固定stream-copy输入，不再实施资源打包、私有资源copy、删Random/JarOutputStream/固定cleanup writer或新增冻结payload长度/hash断言。此处是范围记录，不新增Result或状态协议。旧“R23已采用completed”“R35唯一剩余迁移边界”声明的身份未关联，审计观察仍不支持静态迁移完成；用户决定不能追溯为过去的completed或failed Result。

资源化候选曾通过独立review，但未获用户批准，现被明确排除。此前候选的17方法、五阶段保真及删writer前置仅为历史方案，不再是R24/W02等待条件；G11两方法原断言仍由R25最终组合及R26充分性审计覆盖。实际图与排除记录见[Waves R23](waves.md#mst-r23--stream-copy-精确-zip-基线)，不以R22旧34或R35新34替代R25本轮组合验收。

### 历史审计与资源化候选（已排除，不可执行）

以下逐段保留前轮事实更正、冻结来源和候选记录；其中“本次/未来/须/尚待确认”均指前轮审计或候选时点，不是本轮重新取证或当前实施要求。前轮记录未覆盖的候选独立review通过事实由本轮Handoff补充；通过后用户仍未批准实施。build证据可清理、原R23身份缺口保持。

> ## R23 事实更正与冻结来源
> 
> 旧四文档曾传播“R23已采用completed”“R35唯一剩余迁移边界”。保留原声明作简短更正：原R23 Result身份/定位及最初传播来源未关联，本次不能验证这项采用身份；当前[StripStreamTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripStreamTests.java)仍由@BeforeEach生成固定Random(31) payload、cleanup及六entry Jar，明确不支持当前静态迁移完成。不能断言R23历史上从未执行、创建failed或假恢复ID，亦不以节点pending推断执行历史。
> 
> 本次只读重核当前源码SHA256=`65747003611859c2635f5c4c4caaa34e71718aff59cd2c43b7e8e0e4ca1c47e5`，与[R35冻结源码](../../../build/mixin-r35/initial-sources/minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripStreamTests.java)一致；已采用只读审计亦关联R22同hash。实际消费者只有G11两个方法：正常metadata/content方法直接StripFixture，故障方法经probedLoader反射StripFixture/当前ExactMixinStripper。`resource`仅供fixture生成和fresh retry期望值，故可从复制后私有input.jar的assets/data读取，独立断言40001长度及冻结SHA256后继续原byte-array断言；无需另存payload或预存生产class/期望输出。
> 
> 本次确实读取并解析两方法现存input.jar/cleanup.json、ZIP原始local/central header与entry内容，未生成或复制基线。优先冻结来源为[正常方法input.jar](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes/input.jar)和[cleanup.json](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/streamedEntriesKeepContentsOrderMetadataAndUnchangedConfigBytes/cleanup.json)；[故障方法input.jar](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh/input.jar)及[cleanup](../../../build/mixin-r35/run-output/fixture-evidence/StripStreamTests/actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh/cleanup.json)是独立同字节交叉核对。它们是可复用的完整六entry基线，不是R23实施产物；保留目录可能含历史文件，不能单独断言生成日期。两份Jar均80882 bytes、SHA256=`530ee6cd5d5140c9697643a772942a208fffd10574917a863de8481b347e9004`，archive comment为空。两份cleanup均53 bytes、SHA256=`2942c134c581e3042548dfdcda8dfc1f8e69dbcdc139f171c338c9091c7cc599`，精确UTF-8内容`{"fixture.json":["Good"],"unchanged.json":["Absent"]}`，无末尾LF。
> 
> | 顺序 / entry | method | size / CRC32（十进制） | 内容 |
> | --- | --- | --- | --- |
> | assets/ | DEFLATED | 0 / 0 | 目录、空bytes |
> | assets/data | DEFLATED | 40001 / 3999507122 | payload SHA256 `e34c7a9ebc94f0bf4af307071ebd201d1bb9464bf2f083a94549e6deedfb8644` |
> | empty | DEFLATED | 0 / 0 | 非目录、空bytes |
> | stored | STORED | 40001 / 3999507122 | 与assets/data逐字节相等 |
> | fixture.json | STORED | 37 / 3211123590 | 带首空格、尾空格及LF的` {"mixins":["Good"],"unknown":true} \n` |
> | unchanged.json | DEFLATED | 37 / 3211123590 | 与fixture.json原始bytes相等，SHA256 `3572bce0637cc2491473afdb9a0f53f7abc10f28a6842016a049f9b6779385d7` |
> 
> 全部entry local/central原始名称一致、extra均`feca0000`、comment精确为`kept <entry名>`；DOS字段均为2023-11-15 06:13:20，对应原writer `setTime(1700000000000L)`的记录。epoch由JDK按运行时区解释，后续用同一JDK/时区的JarFile观察核对，不改ZIP时间来凑值；本次Python解析不能冒充新的Java实测。压缩size依次2/40016/2/40001/37/39；整包hash保留所有header/data descriptor/bytes，未来复制不可重打包或正规化。原time/comment/extra/STORED/CRC/顺序和JSON whitespace/unknown全部保留。
> 
> [R35 G11 XML](../../../build/mixin-r35/run-output/test-results/test/TEST-net.msrandom.minecraftcodev.mixins.StripStreamTests.xml)（SHA256 `69bb4922837a5172b6046521d28967fc5976388c5b34a056af81ed9595242d0d`）及已采用R22/R35命令/日志证明两个旧driver方法通过。它们不能证明静态copy、删writer或新方法验收。build可clean/覆盖；未来实施前须重核上述来源，缺失或hash/元数据不符则报告缺口，不能重跑旧prepare/生成器补造。未来资源目录及短说明尚未创建，不作当前可读ref；实际候选链、写面、删除前置与精确17方法回归只由[Waves R23](waves.md#mst-r23--stream-copy-精确-zip-基线)持有。
> 
> R23方法由原“静态Jar task逐entry等价”候选改为“完整原字节test resources＋现有资源处理/classpath私有copy”，只是承载方法候选；全部原ZIP/流/保护合同不减。候选尚待独立review和用户affected-scope confirmation，不以沉默、历史资源确认或文档落地当作接受。R35已完成仅为背景，R24仍须真实R23 completed，R25根131同次组合、R26独立ready和W02 gate保持。

## R16 实际效果与证据边界

本节保留前轮P16恢复时点的已采用事实与缺口；R34已采用completed是本次背景，以下原“本次/必须/缺口”不表示重新打开R34或要求重验。当前R23已明确排除为动态例外，R35已完成；此处“未执行”保留前轮时点，后续R24/R25/R26均已采用completed，见上方最终收口记录。

Router已完整读取采用只读诊断；本次完整解码该诊断、原R16业务Result及上轮局部ready Result。原R16外层completed只表示Handler返回，内层为blocked并声称缺Handoff、未做项目工作；诊断核对原始Handoff/成功工具操作/现存产物证明该说法与已发生效果冲突。保留原blocked，报告脱节原因未证实，不据compaction推断根因，不推断生产pipeline失败。本节是已采用事实加工，不是原始执行记录副本。

八个源码路径＝5新增/2修改/1删除（相对项目根），保留而不重迁：

| 路径 | 已发生效果 |
| --- | --- |
| [pipeline/callers/pipeline/build.gradle](../../../minecraft-codev-mixins/integration-test/mixins/pipeline/callers/pipeline/build.gradle) | 新静态插件入口，apply独立caller脚本。 |
| [pipeline/callers/pipeline/settings.gradle](../../../minecraft-codev-mixins/integration-test/mixins/pipeline/callers/pipeline/settings.gradle) | 新工程名/本地cache。 |
| [pipeline/callers/pipeline/gradle.properties](../../../minecraft-codev-mixins/integration-test/mixins/pipeline/callers/pipeline/gradle.properties) | 新静态配置缓存属性，最终仅org.gradle.configuration-cache=true。 |
| [pipeline/callers/pipeline/pipeline-caller.gradle][caller] | 原脚本迁入；通过插件classloader解析Mixin/StripMixins/MixinInputsKt，固定implementation-input断言移入produceA。 |
| [pipeline/gradle.properties](../../../minecraft-codev-mixins/integration-test/mixins/pipeline/gradle.properties) | 新静态输入工程属性。 |
| [PipelineInputs.kt](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/PipelineInputs.kt) | 内部copy列表增加gradle.properties，公共copyJar/copyMapping接口未变。 |
| [MixinInputBindingTests.java][input] | pipelineProject复制静态四文件，probe整包重建改copy，移除固定断言追加；六Jar/mapping继续消费。 |
| minecraft-codev-mixins/src/test/resources/pipeline-caller.gradle（已删除，不作存活链接） | 旧资源入口删除，由静态caller承载；project(body)仍供其它owner使用。 |

静态调用链保留consumeA/B producer dependsOn、cleanup直接inputs.file与probe cleanup直接输入，A/B及双Strip/applied-only均在。原输入保护、当前plugin/config/refmap/mapping/side/context/native/顺序/implementation变异与真实失败注入未被固定快照取代。

诊断采用的最终实际运行是G04 16＋G02 18＋G03 8＋G05 9＋G06 7＋G10 1＝59/59，0failure/error/skip；共享部分43，不是61或77。六完整类selector与[Waves精确方法集合](waves.md#selector-与预期方法集合)逐方法相符；[当次命令](../../../build/mixin-r16/command.json)与[最终日志](../../../build/mixin-r16/test.log)对应第二轮exit0、BUILD SUCCESSFUL in 6m 55s、15 actionable tasks executed。P16六方法全部在G04 XML内通过，完整流A/B/原键/内容/原输入、producer SUCCESS→UP-TO-DATE→新home FROM-CACHE、fresh双Strip stored2/loaded0与restore stored0/loaded2、独立参数/inputArtifact、空/缺cleanup/坏DOM、source/target/当前producer失败不消费旧成功及applied-only可用均有方法/断言/相关runs关联。四个JavaCompile、六基础Jar、plugin40/43/resource-first/mapping任务实际成功，release11/UTF-8/-proc:none及含class Jar major55保持；六方法私有caller四文件匹配模板。原运行是历史事实，不是修正后验收。

首轮exit1（4m51s）为独立apply脚本不能解析StripMixins/Mixin静态import，随后改用插件classloader解析并适配implementationInputs，第二轮成功。首轮完整日志/XML被覆盖，只有已采用原工具记录支持失败因果，不能声称有独立完整归档。保留目录有例如probe-invalid-20旧文件，最终关联为probe-invalid-21；只能采用当轮主日志/XML对应文件，不能把目录全体当作R16产物。

原运行后先写after，因before缺失报错，再连续补写before/after；730条相同清单和空actual.diff仅证明后补时点相同，不证明迁移不存在或原运行输入稳定。绝不rename/补造为原即时before。[R15有效run-after清单](../../../build/mixin-r15/run-after.json)365条可有限比较：原清单三路径改变及五新增归因上述八路径；run-after目录另五个旧failure Java残留不在清单，不是R16删除。HEAD含更早未提交迁移，不能作完整R16基线。新修正执行前后可采真实新版本标识，旧证据缺失永久保留。

实际日志支持Microsoft17.0.19+10-LTS、D:/Applications/Scoop/apps/microsoft17-jdk/current、Gradle9.4.0，外层JAVA_HOME/PATH锁定，test executor/fixture同路径；其它JDK探测不代表使用。但原R16未完整单独保留三层java-version、wrapper --version和完整解析图，不能把观察升级为完整原证据。尤其旧project(body)显式org.gradle.java.home=fixture.gradleJava，新caller properties/runner遗漏；PipelineInputs assemble的-D参数只锁另一工程，caller本轮恰好17不证明显式跟随。R34必须恢复P16接线及改后59/版本/内容关联，必要修复与回归共同证明同一P16完成谓词。

原始Result/工具记录为本次已读取采用来源，持久导航仅以上现有仓内相对引用，不持久依赖项目外原件或经Context跳转。build/临时工程可清理或覆盖，加工事实不承诺完整原件永久可取；本次未重跑测试、未修接线。详细执行owner、写面、替代gate和串行仅在[Waves](waves.md#mst-r34--恢复-p16-显式-fixture-jdk-接线与原完成谓词)；原R16不升级，诊断不等于实施，R34成功不自动放R24/W02。

## 历史记录的适用边界

以下保留各次已采用事实及当时合同/缺口，出现“当前/本次”仅指各段原执行或维护时点，不是W02状态。R11/R12闭合F16与W01释放是历史事实；旧“无剩余静态化遗漏”的充分性判断已被上述审计收窄，行为通过本身未失效。当前计划与作者检查见[W02](waves.md#mst-w02-残留生成链恢复图)。

## 已接受方向与证据层次

当前终态：Router 已完整读取并可靠关联 implement-r11-fabric-fresh-retry/g1 completed 与 audit-r12-fabric-retry-final-acceptance/g1 completed/ready，并已独立核定 MST-W01 验收满足（satisfied）及释放（released）。十三实际 member 均有已采用 completed 证据；本次只持久化既成判断，不重新执行验收或作 gate 决策。 下文 R03-R10 各节保留历史运行与判断边界。

[Work 的三族 assessment](work.md#权威复用与-owners)均为 reuse：目标与生产合同不变。静态项目承载普通 settings/build、Java、JSON/TOML、tiny/refmap 等可读输入，正常 JavaCompile/Jar 编译打包；少量 Kotlin JUnit/TestKit 负责临时副本、必要文件变更、重复执行与断言。直接组件、真实 I/O 故障、文件系统别名及生命周期测试按用途保留局部 fixture，宿主语言不强制统一。

继续 pluginUnderTestMetadata 和当前测试 SPI 注入。用户已确认根 `test` 聚合 Mixins/Fabric/Forge、五类原迁移覆盖及局部故障保持。普通输入与根验收是独立可验收结果，R02 接线保留但 partial；R01/I02 已完成并采用；R03/R04/R05 的完成事实如下。Fabric/Forge 各自 owner 与现有 adapters 不变。

## 已采用 R03、R04、R05 执行事实

以下为已完整读取并采用的独立完成 Results 摘要；实际执行与任务复用分开记录，不把不同运行拼为一次成功。

- **R03 completed：** StripRegistrationTests 仅将旧 numeric 拒绝期待改为真实 DOM 错误；聚焦测试 1/1 通过。失败消费、合法空恢复、各阶段原输入保护保留。
- **R04 completed：** root-only dry-run 确认根入口依赖 Mixins/Fabric/Forge。有限验收中 Mixins 101/101 为本轮实际执行；Fabric 17/17、Forge 16/16 为正常 UP-TO-DATE 复用；0 失败、错误或跳过。R02 原 134 项＝133 通过/1 失败/0 跳过仍是独立历史 partial，根任务当时因依赖失败未执行，不被改写或拼接。
- **R05 completed：** pipeline 静态 Gradle 工程与 caller 完成。MixinInputBinding TestKit 10 个场景 10/10 通过，覆盖 SUCCESS、UP-TO-DATE、FROM-CACHE、输入变化、cleanup direct inputs、双 Strip 内容、坏输入、读写/发布失败及恢复重试。

R03→R04 成功依赖已满足；R04 成功 Result 分别满足 I04/I05/R06 的根入口前置。R05 已消费 R01/I02 成功 Results；R05 不释放 W01。I04 completed：Fabric 静态 fixture 实际构建，Applicability 6/6、Metadata 8/8，共 14/14 通过；target/input JAR 内容及读写关闭故障已有通过证据；旧摘要“恢复重试均已验证”过宽，R10确认F16六故障后成功retry缺断言，不能视为已证明。I04 completed及14/14历史保留。未运行全仓限制保留。R06 completed，但仅覆盖 I05 已识别的局部组合边界。I05 原 Result 仍 blocked；R07 完整重验已采用 completed Result，R08 已完成独立只读审计并得出 W01 not ready。I03 blocked 及草稿部分效果、R02 partial 及原运行事实继续保留。

I04 completed：Fabric 静态 fixture 实际构建；Applicability 6/6、Metadata 8/8，共 14/14 通过；target/input JAR 内容及读写关闭故障已有通过证据；旧摘要“恢复重试均已验证”过宽，R10确认F16六故障后成功retry缺断言，不能视为已证明。I04 completed及14/14历史保留。未运行全仓限制保留。

采用判断：I05 既有 metadata 14/14 与 R06 两项兼容性测试 2/2 共同覆盖一个已识别的局部组合边界；这是两次独立运行，不合并为一次 16/16，也不构成 I05 完整完成。I05 原 blocked Result 与旧 2/16 失败历史保留，W01 不释放。R07 是新的完整 I05 重验项，已独立产生并采用完整 completed Result；R08 依赖 R07，已登记为 completed 的独立只读审计 Result，并确认 W01 not ready。

- **MST-I05 原 Result 为 blocked，部分效果保留。** Forge 静态工程与接线已产生；`ForgeMixinMetadataTests` 14/14 通过，原 I05 运行汇总 2/16 失败。两项失败均落在 [`ForgeAccessTransformAndJarJarCompatibilityTests`](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt) 的嵌套 `META-INF/vendor.json` 精确内容断言；对应方法为 `jarJarRemovalDeletesListedPayloadAndMetadataOnly` 与 `actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload`。
- 旧报告观察到的嵌套输入为 `{"keep":true}` 加末尾 LF。报告之后静态源 [vendor.json](../../../minecraft-codev-forge/integration-test/forge/src/embedded/resources/META-INF/vendor.json) 已改为无末尾 LF；本次只读字节核对为 13 字节、末字节 `}`。旧报告只证明修正前的失败；随后采用的 R06 Result 记录 fixture 13 bytes、无末尾 LF，以及两项测试 2/2 新鲜通过。
- **MST-R06 completed。** 唯一完成条件已满足：静态 fixture 无末尾 LF，且上述两个测试方法 2/2 通过；不放宽现有断言，不修改生产 handler、ServiceLoader、AT/JarJar 逻辑。R06 依赖 R04，并与共享 Forge 测试/JVM 串行，保留与 I04 的冲突顺序。R06 仅完成 I05 已识别的局部恢复边界；其 Result 不改写 I05 的 blocked Result、不完成 I05 或释放 W01。

## R07/R08 历史恢复与当时核验边界

- **MST-R07 completed：** Router 已完整读取并可靠关联单一完整 Result；R07-01..16 重新实际执行 16/16 通过，独立于 I05 metadata 14/14 和 R06 局部 2/2。I05 原 blocked Result 与旧失败历史保留，详细方法与限制见下方完成记录。
- **MST-R08 completed，W01 not ready：** Router 已完整读取并采用单一独立只读审计 Result。审计以 R07 的 16/16 及三处 JDK17、Gradle 9.4.0、clean module output 边界为已采用证据，并结合 R01/I02/R03/R04/R05/I04 的已采用记录；本次未重跑这些历史项。R08当时审计确认同一最终版本根 `:test` 三模块有限组合 artifact、完整逐行 S1-S8 覆盖和必要共享回归适用性证据仍缺失，R07 单项不补齐最终 gate。审计未运行 Gradle/测试或 Git，且不释放 W01。


## R07 已采用完成事实与证据限制

本节只加工 Router 已完整读取并可靠关联的单一 R07 completed Result；不重复采用或执行。R07-01..16 共 16 tests / 16 pass / 0 fail / 0 error / 0 skip，所有 TaskOutcome 均为 SUCCESS/executed，非 UP-TO-DATE/FROM-CACHE。已核实可读的 [16 行 selector/TaskOutcome/JUnit 索引](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/verified-rows.json)逐行各 1 test、0 failure/error/skip；[运行汇总与 fixture 字节记录](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/verification-summary.json)记录 HEAD `30d1d3d22267477db3275cb849e8692ada0f74de`、vendor 13 bytes/末字节 `0x7D` 和保留产物计数。索引与汇总仅是仓内 build 输出，不是完整原始 Result，也不保证永久保留；不以这些加工记录替代 Router 的完整读取与关联。

同一 HEAD 及原有未提交迁移工作树、Gradle 9.4.0 wrapper 和[同轮 testRuntimeClasspath 解析图](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/resolved-testRuntimeClasspath.txt)用于全部 16 行。外层 Gradle JVM、解析后的 `tasks.test.javaLauncher`、`fixture.gradleJava` 均为 Microsoft JDK `17.0.19+10-LTS`，实际路径均为 `D:/Applications/Scoop/apps/microsoft17-jdk/current`；外层通过 `JAVA_HOME` 和 `PATH` 锁定，嵌套 fixture 通过 `-Dorg.gradle.java.home` 锁定。已核实可读的[外层完整版本](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/outer-java-version.txt)、[launcher 完整版本](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/launcher-java-version.txt)、[fixture 完整版本](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/fixture-gradle-java-version.txt)、[JDK 关联](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/jdk-correlation.txt)、[外层锁定记录](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/lock.txt)与[对应 Gradle --version](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/environment/gradle-wrapper-version.txt)保存环境输出。

采用 Result 的方法：先删除 `minecraft-codev-forge/build` 再建立证据，使用 `minecraft-codev-forge/integration-test/forge`，逐行 `--rerun-tasks --no-build-cache --no-configuration-cache --no-daemon --max-workers=1 --tests`；没有删除 Gradle user-home 依赖缓存。[逐行执行边界记录](../../../minecraft-codev-forge/build/platform-fixtures/r07-run/execution-boundary-check.json)的 16 行均记录实际 test task、非 UP-TO-DATE、非 FROM-CACHE、build successful。R07-08 实际断言 TOML bytes 和当前 Manifest 中 changed reference 未移除；`vendor.json` 前后均为 13 bytes、无 LF 且未改动。未改生产代码、断言、依赖、根聚合、fixture 或 Git。

未运行根 `:test`、其它模块或最终共同版本组合验证；本次文档维护没有重跑任何测试或清理。I05 原 blocked 与旧 2/16、R06 局部 2/2、R02 partial、I03 blocked/部分效果均保留；R08 审计已完成但确认上述最终组合与覆盖证据缺失，该历史时点 W01 仍 pending、未释放。

## R07 完整矩阵的证据边界

Forge 源码实际包含 `ForgeMixinMetadataTests` 的 14 个 `@Test` 方法和 `ForgeAccessTransformAndJarJarCompatibilityTests` 的 2 个 `@Test` 方法；方法行号、完整 Gradle selectors、逐行断言/证据目录见 [Waves R07 矩阵](waves.md#r07-执行合同与-16-行可执行矩阵)。该矩阵的 16 个独立 selector 与已采用 R07 Result 的逐行索引一致；本次文档维护不执行测试。

Forge [build.gradle.kts](../../../minecraft-codev-forge/build.gradle.kts) 将 `tasks.test` 固定到 Java 17 launcher，并注入 `fixture.gradleJava`、`fixture.evidence`、`fixture.forgeProject`、`fixture.classpath`、`fixture.testOutputs`，同时声明 `integration-test/forge` 为输入且依赖 `pluginUnderTestMetadata`。因此 R07 Result 必须把同一当前 checkout、同一 Gradle 解析版本图、外层 Gradle JVM、`tasks.test.javaLauncher` 和 `fixture.gradleJava` 全部锁定为 JDK17，并在同一 Result 分别记录：外层 Gradle JVM 的完整 `java -version` 输出与实际路径；`tasks.test.javaLauncher` 解析后的实际 JDK 完整版本与实际路径；`fixture.gradleJava` 实际 JDK 完整版本与实际路径。该 Result 还必须明确三者均为 JDK17，记录外层 JVM 的实际锁定方式（`JAVA_HOME` 或 `org.gradle.java.home`）及对应 `--version` 输出；同时记录 `minecraft-codev-forge/integration-test/forge`、`build/platform-fixtures` 及 clean-cache 边界。metadata 行不要求非递归 retained 目录；没有直接保留文件时，必须使用与 selector/Result 关联的 JUnit XML 或控制台断言。不得用 UP-TO-DATE/FROM-CACHE 或历史分次结果替代 16 行。

R04、I04、I05、R06 的共享 Gradle/test/JVM、Forge fixture 与 evidence 输出冲突已在 Waves `resourceLocks`/`serialization` 中结构化记录。该段只定义安全串行边界，不改变 I05 原 blocked、R06 2/2 局部完成或该时点 W01 pending。


下列为既有源码接点记录；本次仅采用实施 Results，不作新的源码调查或测试。

| 接点 | 当前事实及迁移含义 |
| --- | --- |
| [根构建](../../../build.gradle.kts)、[settings](../../../settings.gradle.kts)、三个模块构建 | R02 已接线且 dry-run 证明三模块依赖；R04 有限验收 completed。新驱动共同版本最终验证仍属于 W01 gate，不重做接线。 |
| [MixinPreapplicationTests][preapp]、[InputBinding][input]、[caller][caller] | R01/I02/R05 各自 Result 及唯一覆盖范围见 Waves；R05 pipeline 保留 consumeA/B producer dependsOn 与 cleanup direct inputs、probe cleanup direct input。 |
| [Fabric applicability][fabric-app]、[Fabric metadata][fabric-meta]、[Forge metadata][forge-meta] | R04 满足各自根入口前置；I04 completed 并保留 14/14 证据，I05 原 Result blocked 保留，完整重验由 R07 独立 completed Result 承接；R06 只恢复两项 Forge 兼容性测试，不代替 I05 完整验收。 |

## 历史证据与限制

R01 ordinary 80/80、I02 mapping 8/8 与直接消费者 29/29 的完整内容及可核对实现接点保留在本 Context 历史段落/引用中；它们是 R05 的已满足前置，不能重复计入 R05 证据。旧 84 项 82/2、后续 13 次缓存构建、Producer 18 项均为独立历史事实，不合并成一次全绿。

R02 的原环境、命令、逐模块报告、133/1 失败细节及复用限制保留在 [历史证据与限制](#历史证据与限制)。R04 的 101 实际执行与 33 项 UP-TO-DATE 复用是另一次有限验收结果，不更改 R02 Result 状态。

## I03 blocked 与 pipeline 部分写入

I03 的 blocked 与部分草稿事实保留。只读枚举原为 8 个 Java＋settings.gradle 共 9 个文件；与交接称 9 个 Java 的差异仍不裁定、不虚构文件。R05 completed Result 已承接草稿并完成 pipeline 静态工程/caller；历史 I03 状态不升级、不删除。

## 依赖与限制

R03→R04、R01→I02/R05、I02→R05、R04→I04/I05/R06 的既有成功依赖保持；R06 已 completed，但仅覆盖 I05 的局部组合边界。R07 依赖 R06，并消费 I05 原 blocked Result 作为待重验范围而非成功前置；R08 依赖 R07 并已完成独立只读审计，结论为 W01 not ready。I05原Result仍blocked，不因R06/R07/R08自动改写；R08当时缺最终组合/逐行S1-S8/共享回归证据，后由R09组合及R10判断承接。R10时点的唯一F16 retry缺口见下节，当前已闭合。I04 completed、I05 原 Result blocked、R06/R07/R08 completed。

四份文档直接互链；唯一可执行图、覆盖索引和联合等待关系均由 Waves 持有。R07/R08 的已采用事实与证据限制已登记；原审计当时的登记缺口已解决，不形成重复登记前置。R08当时缺口已经R09/R10承接，不重复登记或要求旧结论ready；R11已补R10唯一F16缺口，R12已独立确认充分。

## R09/R10 已采用事实与当时 F16 缺口

本节“缺口”保留 R10 时点；当前已由 R11/R12 闭合，最终记录见下节。

**MST-R09 completed。** Router已完整读取并关联 execute-r09-final-root-combination/g1：2026-10-18同次根组合18类131方法（Mixins101/Fabric14/Forge16），0 failure/error/skip，三模块test均SUCCESS/executed，root NO-SOURCE正常。Microsoft JDK17.0.19+10-LTS（外层/三launcher/三fixture）、Gradle9.4.0，538相关输入前后稳定，95份R07证据保全；真实内容、分层缓存与预期失败证据见[当次仓内导航](../../../build/mixin-final-r09/evidence.md)。这不是本次文档维护重跑。R07完整树hash缺失、build证据可清理限制保留。

**MST-R10 completed，W01 not-ready。** Router已完整读取并关联 audit-r10-final-acceptance/g1的完整envelope/result；独立审计支持R09实际执行、精确方法、环境/输入稳定、字节/AT/JarJar与双语链接。唯一阻断：FabricMixinMetadataTests.actualReadWriteAndCloseFailuresEscapeRemove（165–218）六故障只有传播/关闭/identity/suppressed，无撤销故障后成功handler.remove(temp)及实际metadata内容；循环重写original不是retry。F16、S6与S8全矩阵充分性部分支持；其余原F/S受支持。这是原Plan S6/F16合同缺口，不是新增条件，也未证明生产恢复失败。I04及R09的历史“retry已验证”摘要过宽，不撤销completed或131通过，但不能再作为该缺口的证据。R08旧not-ready与R10新not-ready各自保留，不改ready。

本次已按精确路径完整读取两份运行时Result；上述是已采用事实的加工，不复制完整Result、不把项目外session/Result导航存为持久依赖，也不是新的独立审计。仓内当次导航目前可读，但不承诺永久原始Result访问。

Router 已完整读取并可靠关联 implement-r11-fabric-fresh-retry/g1 completed 与 audit-r12-fabric-retry-final-acceptance/g1 completed/ready，并已独立核定 MST-W01 验收满足（satisfied）及释放（released）。十三实际 member 均有已采用 completed 证据；本次只持久化既成判断，不重新执行验收或作 gate 决策。

**MST-R11 completed。** 仅在 FabricMixinMetadataTests.actualReadWriteAndCloseFailuresEscapeRemove 原方法内补断言。六模式各先真实故障，再撤销故障：read/read-close/read-close-suppressed 先证原字节不变、不 reset；write/write-close/write-close-suppressed 仅必要复位 temp metadata。随后同一 handler 对 native temp 新调用 remove 成功，读回 DOM 精确为 `{"id":"demo","custom":{"keep":true}}`，无 mixins，snapshot 与源 JAR bytes 保持；原 hit/close/identity/suppressed 未弱化。2026-10-19 本轮完整 Fabric metadata8＋applicability6 实际执行14/14，0 failure/error/skip，Fabric test SUCCESS/executed。三处 Microsoft JDK17.0.19+10-LTS、Gradle9.4.0；解析图与 R09 Fabric 相同，外层与嵌套任务/缓存分层记录。见[本轮仓内导航](../../../build/mixin-r11/evidence.md)，属于可被清理的 build 输出。

**MST-R12 completed/ready。** 独立只读审计已逐行支持 F01-F18、R07-01..16、S1-S8 和十三实际 member predicates，无剩余阻断、无需额外修复或补验。R09 冻结基线至审计版本只有四份派生文档与上述原测试方法变化；production/helper/fixture/build/deps/SPI、环境及解析图未变，Fabric14 重验覆盖唯一改动类及共享 FabricInputs 两消费者，足以支持复用其余证据。R09 原同次根18类131（101/14/16）通过仍适用；新14单独记录，未拼成新131或145。本次四文档收口只更新派生事实，不改变运行输入或验收合同。

R11/R12 恢复计划的独立 review-fabric-retry-recovery-plan/g1 completed/ready 已完整采用。R08/R10 各自 completed/not-ready 永久保留；I01 blocked、R02 partial/133+1、I03 blocked/草稿及计数差异、I05 blocked/部分效果、R06 仅局部2/2不改写，I05 原完整义务仍由 R07 承接。R07 无完整历史树 hash、历史某些原报告未重新取回、build 证据可被清理；加工记录不承诺永久完整原始证据，临时 metadata 以当次 JUnit/system-out 与冻结断言关联。本次未跑 Gradle/项目测试、未清缓存、未提交或写 Git。

该段为前次F16结案事实，本轮残留恢复不改其历史状态；当前图与检查见上文W02。

[preapp]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java
[input]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java
[caller]: ../../../minecraft-codev-mixins/integration-test/mixins/pipeline/callers/pipeline/pipeline-caller.gradle
[fabric-app]: ../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinApplicabilityTests.kt
[fabric-meta]: ../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt
[forge-meta]: ../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt

[strip]: ../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripMixinsTests.java

## 最终收口证据与限制

已完整读取本次指定R24/R25/R26 generation1 Result；永久记录仅保存已采用事实与以下现存仓内相对导航，不持久化外部session/Result定位。

| 已采用结果 | 仓内证据及适用边界 |
| --- | --- |
| R24 completed | [报告](../../../build/mixin-r24/report.md)、[精确diff](../../../build/mixin-r24/actual.diff)、[caller原文](../../../build/mixin-r24/source-sites.md)、[结构化检查](../../../build/mixin-r24/verification.json)、[实际编译日志](../../../build/mixin-r24/compile.log)。13行纯删除；共享jar的8个及replace的17个caller保留；819项输入只一个路径变化。仅编译，没有测试。报告selector/entry两处误述按上方更正解释。 |
| R25 completed | [完整报告](../../../build/mixin-r25/report.md)、[实际根日志](../../../build/mixin-r25/actual.log)、[命令脚本](../../../build/mixin-r25/run.ps1)、[131方法关联](../../../build/mixin-r25/verified-methods.json)、[静态Jar内容](../../../build/mixin-r25/static-input-content.json)、[R35当轮copy消费](../../../build/mixin-r25/r35-current-resource-consumption.json)、[缓存](../../../build/mixin-r25/cache-execution-associations.json)、[G11实际故障](../../../build/mixin-r25/g11-dynamic-stream-observations.json)、[真实故障及F16 retry](../../../build/mixin-r25/actual-faults-and-f16-retries.json)、[R07当前16行关联](../../../build/mixin-r25/r07-current-method-associations.json)。均为同次最终运行关联，不借用历史局部通过。 |
| R26 completed/ready | 本次采用的独立审计未产生仓内文件；审计事实加工于此，不虚构报告链接。逐行判断无阻断，独立交叉核验上述原始XML/源码/ZIP/日志，3403份证据manifest大小/hash，以及819/827两种不同范围输入连续性；[现存manifest](../../../build/mixin-r25/evidence-manifest.json)、[输入连续性](../../../build/mixin-r25/input-stability.json)、[环境关联](../../../build/mixin-r25/jdk-correlation.json)、[解析图](../../../build/mixin-r25/resolved-graphs.json)提供实际导航。该复核由R26执行，本次文档Handler没有重做全量hash或XML/ZIP审计。 |

R25实际UTC 2026-10-19T18:55:42.2568344Z至19:05:48.2862521Z，exit0；Gradle9.4.0，外层及各test launcher/fixture为Microsoft JDK17 17.0.19+10-LTS，显式跟随接线保留。Java静态输入release11/UTF-8/-proc:none、有效class major55；5个坏class是原负例，不冒充编译产物。R25证据整理首次README计数assert失败后只修正证据脚本计数，未改测试或重跑组合；R24命令包装失败、第二次up-to-date和最终目标重新编译历史均留在原报告。

R26审计只提供ready；Router随后采用R26并核定20个成员及W02全部条件满足。本轮只投影该程序事实，不将R26自称为已采用或Handler自作gate决定。此前各节待执行/未收口措辞均按其明确历史时点理解；合同仍保留且已由本轮最终证据满足。
