# Mixin 静态 Gradle 测试迁移 Work

[Context](context.md) · [Plan](plan.md) · [唯一执行图 Waves](waves.md)

## 最终收口记录

**Router已核定MST-W02全部条件满足（satisfied）。** 已可靠采用17个静态owner completed：R13/R14/R15/R34/R17/R18/R19/R20/R21/R35/R27/R28/R29/R30/R31/R32/R33，以及R24/R25/R26 generation1 completed，共20个实际成员；R26独立结论ready、无阻断。此处仅同步Router既成判断，Handler未自行验收或释放gate；不另声明released。

R24仅删除InputBinding的13行无caller代码，目标compileTestJava实际重新编译成功，未运行测试。R25在R24最终输入上从根:test同次实际执行18类131方法（Mixins101/Fabric14/Forge16），零failure/error/skip，48 actionable tasks全部executed；三个模块test实际执行，根:test正常NO-SOURCE。151个静态Jar、R35全部21包及43条资源copy记录、嵌套缓存和真实故障/fresh retry均由当轮证据关联；G11原两方法包含其中。历史34/59/80保持各自版本和运行，不拼入本轮131。

R26逐项支持11类、S1–S8、F01–F18/G01–G18、R07全部16行及20成员要求。R24报告两处非阻断误述在此纠正：refmap实际selector为`mapping-mod`/`mapping-legacy-mod`；InputBinding:495实际将`probe.jar`的`resource.txt`改为`current-input`，并非fixture.json。原build报告不改写。详细处理事实及仓内导航见[Context收口证据](context.md#最终收口证据与限制)，唯一图及原gate见[Waves](waves.md#mst-w02-残留生成链恢复图)，范围和成功条件仍由[匹配Plan](plan.md)持有。

R23保持excluded / exception，保留Random/JarOutputStream/cleanup动态基线和全部正常/故障/retry保证，不记completed或failed、不作成功前置；R34/R35承接不抹去R16 blocked、R22 g1无终态/g2 failed及候选撤回。R23旧completed身份not-verifiable、I01/I03/I05 blocked、R02 partial、R08/R10旧not-ready及其他失败/局部历史均保留。PRD/ADR/Spec继续reuse；未改成员、边、谓词、gate合同或例外。

本轮仅四文档C5事实维护与静态自检，零构建、零测试、零代码/资源/配置/authority/build证据/Git写入。R07全历史树hash缺失、build证据可clean、部分temp仅能通过当轮XML/stdout及原断言关联，未检查全仓、游戏或MC下载；加工记录不承诺完整原Result永久可取。

在原确认范围及开始修改授权内，把残留固定源码、资源/JAR和完整caller迁回静态Gradle输入；按用户最新决定，StripStreamTests的固定stream-copy基线打包明确排除，保留动态输入生成。真实行为/内容/隔离/缓存/输入保护/故障边界不减。本轮交付仅为四份协调文档的一致维护与作者自检。

## 当前阶段

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> **MST-W02 pending；R35 generation1 completed已采用；R23为用户确认的动态例外，移出实际执行成员，不记completed或failed。** R35已将21个冻结包（4824 bytes/33 entry）及cleanup迁入StripMixinsTests对应测试资源，五阶段复制保真、固定writer删除、同版五类34方法通过均为已采用事实，见[Context](context.md#r35-已采用完成与适用边界)。R23的旧“已采用completed／R35唯一剩余”声明身份未关联；当前@BeforeEach仍Random(31)/JarOutputStream生成payload、cleanup及六entry Jar，审计与原错误声明保留于[Context](context.md#r23-事实更正与冻结来源)。不推断R23从未执行，不虚构failed或恢复身份。

用户明确认为该测试重点在流故障注入、失败清理和成功重试，不值得打包约40KiB随机payload；例外仅限StripStreamTests固定stream-copy基线，其他静态owner原合同不变。正常entry/metadata、8192 bulk读写故障、各种关闭故障、异常identity/suppressed、输入保护、无残留及fresh retry检查全部保留。原字节资源化候选虽已通过独立review，但未获用户实施批准，现明确排除；[R23历史节点](waves.md#mst-r23--stream-copy-精确-zip-基线)保留候选与审计，不再是执行项。此决定不是静态迁移完成，也不放宽测试保证。

R22 generation1 中断且无终态 Result，诊断后 resume generation2 才返回 failed；21个候选 Jar task 实际执行但等价失败、consumer 未接、writer 未删、候选源码撤回，最终484项项目输入未变。原 driver 当次五类34/34通过仅证明旧实现，不能充当R35改后验收；不得再次resume旧R22或升级其failed。

R13–R15、R34、R27–R33、R17–R21及R35已采用completed仅为背景，不另增登记任务或重做；原R16 blocked及八路径/59通过、首次review completed/not-ready和上轮局部completed/ready各自保留。R23资源化候选的独立review通过仅为历史，不覆盖本次排除及后继连接变更。W01十三member completed、R12 ready、Router satisfied/released、根131/131及Fabric14/14不变；旧S1/S8无遗漏判断过宽。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 三族authority继续reuse；本轮只记录用户限定的测试组织例外，普通JavaCompile/Jar及全部ZIP/流合同不变，不登记accepted ADR。R35已承接R22全部原成功义务；R24只等待仍承担静态迁移的17个真实owner及其完整可关联、证据充分的completed Result，不再要求R23 completed，并逐caller保留该动态例外。R25根131同次组合仍包含G11两方法，R26仍须独立ready；W02调整为20个实际member，全部完成证据和其余原gate条件继续必需。作者自检不是独立review，未完成迁移item、未释放gate。

## 权威复用与 owners

已完整采用本轮指定authority/原范围assessment：

| family/action | owning boundary/path | reuse理由 |
| --- | --- | --- |
| PRD / reuse | 产品范围：[codev-mixin-rework](../../prd/codev-mixin-rework.md)及[中文](../../prd/codev-mixin-rework.zh-CN.md) | 原迁移意图及真实内容/输入保护不变；用户限定的stream-copy动态例外没有新产品行为。 |
| ADR / reuse | 每operation隔离：[mixin-operation-isolation](../../adr/mixin-operation-isolation.md) | 静态Jar提供隔离竞争输入，同JVM/并发/selector/TCCL保证继续真实验证，无新架构决定。 |
| Spec / reuse | 技术/测试组织：[mixin-preapplication](../../spec/mixin-preapplication.md)及[中文](../../spec/mixin-preapplication.zh-CN.md) | 复用已有测试组织/dynamic边界assessment；本轮限定stream-copy输入承载例外，现有隔离/失败合同不变，无material authority gap。 |

本轮只维护派生协调文档，不写authority；无须新PRD/ADR/Spec。

## 承接边界与完成信号

Waves按可独立验收/保留/恢复结果覆盖全部11类：OperationIsolation固定11/22/33/44依赖/插件/SPI、Mapping同FQCN插件、FailureStage合法故障源、InputBinding完整caller、独立Strip caller及其余固定resource/ZIP；StripStreamTests固定stream-copy基线以明确动态例外覆盖，保留两方法全部行为保证。必要helper、实际selector/方法集合、固定输入/删除入口、普通JavaCompile/Jar及R35测试资源消费与保留动态操作的实际caller在Waves维护，Plan仅持策略/风险/验证。最终生成链收敛、同次组合运行、独立只读充分性判断各有独立终态。

前轮维护时点记录（已由上方最终收口事实更新；保留历史）：

> 当前恢复的完成信号是[W02明确gate](waves.md#mst-w02-残留生成链恢复图)：20个实际member完整可关联completed Result、最终实际静态任务/consumer/内容组合及独立ready，S1–S8/11类/所有方法与共享回归充分，逐caller核对R23动态例外；Router另行判断。历史W01 gate已释放不成为新图前置，不使遗漏自动闭合。

历史限制及部分效果详见[Context](context.md)：I01 blocked、R02 partial/133+1、I03 blocked/草稿、I05 blocked/静态Forge及metadata部分效果，R06局部2/2，R08/R10 completed/not-ready均保留。R07全树hash缺失、部分原报告未重取、build证据可清理；加工事实不承诺永久原始证据。本轮只写四份文档，不运行Gradle/测试、不清缓存、不改源码/依赖/lock/authority/工具链/LLM指令或Git。
