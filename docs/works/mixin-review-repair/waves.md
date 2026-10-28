# Mixin 审查修复 Waves

## 精简R与最终验证的现行连接

匹配[Work当前边界](work.md#已接受的精简r与最终验证维护)、[Context决定/复用事实](context.md#精简范围的已接受决定与复用边界)及[配对Plan](plan.md#已接受的精简r与最终验证策略)。本次只同步既有执行图的已采用完成记录，不执行、派发、代独立复核/实施确认或自行判断gate。用户已接受精简R和精简最终验证并随后确认单次兼容运行；Router已完整读取、可靠关联并采用 `run-at-jarjar-compatibility-once` generation1 completed，判断下列唯一兼容item完成及其单成员Wave限定gate满足。本节不再待运行；下方原完整R/V/H及其等待按原合同历史保留，不再承担本轮执行义务，仍未通过。

### VERIFY-FORGE-AT-JARJAR-COMPATIBILITY — 两项兼容观察的单次联合结果

**已采用完成事实。** `run-at-jarjar-compatibility-once` generation1 completed关联本item及唯一 `W-FORGE-AT-JARJAR-COMPATIBILITY`；[完整运行报告](../../../build/verify-forge-at-jarjar-compatibility-20261028-g1/report.md)与[实际记录](../../../build/verify-forge-at-jarjar-compatibility-20261028-g1/report.json)记录唯一outer加 `--rerun`，真实exit0、同次两精确方法新鲜JUnit2/0/0/0、AT_ACCESS_OBSERVATION/NESTED_REOPEN/JarJar通过，实际outer1/nested1/prepare0/reference0。编译UP-TO-DATE、nested静态assemble正常返回/数值exit null、outer offline而nested未强制offline、标准保留产物可能覆盖等限制见Context。以下原谓词/依赖/调用与停止规则保留为执行时合同，不授权重跑。

- 单一谓词V-compat：一次现有兼容整类调用中，真实非空AT CLI、嵌套payload/无关资源及JarJar在producer/strip前后行为均通过；两个方法同次执行，不拆构建/Result，也不先由R运行再由V重放。一个item/Handler/独立运行Result。
- 前置item：无。唯一归属W-FORGE-AT-JARJAR-COMPATIBILITY，前置Wave gates：无。该类只依赖正常编译及现有ForgeInputs静态fixture，P/Q/root/bootstrap/三模式/remapped是限定收尾可引用的既有证据，不是本兼容调用的额外完成屏障；不等待原R/V/H、完整代理gate或1165历史采用连接。运行前须实际运行确认及普通当前共享构建冲突/输入可用性检查；用户确认和该次实际运行已发生，本次只记录已采用结果，不重新做运行前检查。
- 调用/写拥有：只允许一次 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests` 及其正常编译/ForgeInputs首次lazy assemble依赖、正常构建缓存和新运行证据/已有保留产物。仅复用既有入口和观察，不改源码/配置/测试/工具/依赖或旧证据，不新增取证辅助。裸test、:test聚合、全模块clean/test、三组prepare/reference/冷热、17次代理探针、消费者重跑及Neo opt-in均排除。
- 成功证据：同次新鲜JUnit明确执行 `jarJarRemovalDeletesListedPayloadAndMetadataOnly` 和 `actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload`，tests/failures/errors/skipped=`2/0/0/0`且outer真实数值exit0；[Plan规定观察](plan.md#一个联合运行成果)、当前源码/加载内容、实际命令/日志及现有产物对应完整。正常新单worker成功路径预计outer1/nested1/prepare0/reference0，nested仅共享ForgeInputs首次lazy assemble；此为静态预计，实际调用/阶段照实报告，不承诺失败路径或额外worker也恰为该数。UP-TO-DATE/FROM-CACHE/SKIPPED、仅编译、旧XML或一项通过不能完成。
- 冲突/停止：与共享Forge/Mixins源码、编译输出、Gradle/TestKit/build/cache/ForgeInputs写运行串行；只读复用证据不另造成功依赖。缺输入/未获实际运行确认/冲突则不启动；实际失败、方法缺跑/skip、未知退出或证据不齐即停止保留边界，不强跑、不追加第二次调用、不顺手修源码或补测试。

| Wave | 增量结果 | items（唯一归属） | 前置Wave gates | 释放谓词 |
| --- | --- | --- | --- | --- |
| W-FORGE-AT-JARJAR-COMPATIBILITY | 一次现有兼容整类的两项联合新鲜观察 | VERIFY-FORGE-AT-JARJAR-COMPATIBILITY | 无 | G-FORGE-AT-JARJAR-COMPATIBILITY：唯一成员的一个完整Result为completed且Router可靠完整采用，同次两方法实际执行、新鲜JUnit2/0/0/0、真实outer exit0及上述AT/nested/JarJar行为/内容身份/实际调用证据均齐全；缺跑/skip/旧XML/仅编译/partial/failed/blocked/unknown不满足。此新gate只支持限定兼容结论，不能释放原R/V/H gate。Router已依据可靠完整采用的上述g1结果判断本item完成、本gate仅就限定兼容结论满足；本次仅记录该判断，不释放原R/V/H gate。 |

### 原R及直接消费者的本轮范围

| 原位置 | 当前执行/消费关系 | 保留原边界 |
| --- | --- | --- |
| TEST-FORGE-PATCH-NAMESPACE / W-FORGE-PATCH-REGRESSION | 取消本轮新增四方法矩阵及重复T/冷热/reference；复用既有证明，兼容缺口只由V-compat承担。原R不等待新V-compat，不再作为新运行的成功前置。 | 原R未实施完成，G-FORGE-PATCH-REGRESSION未满足；新兼容结果不回填。 |
| VERIFY-RECOVERY / W-REVERIFY | 取消本轮原三模块fresh、根入口及消费者/代理/准备重跑；不再作为当前运行项，原R及其它旧完整等待只保留历史。新V-compat的item与Wave均无旧R等待，不产生R↔V循环。 | 原完整V与G-RECOVERY-INTEGRATION未通过；旧完整技术合同保留，不改成两方法已足全验收。 |
| REVIEW-ACCEPTANCE / W-ACCEPTANCE | 原全交付验收不是本次精简收尾。本次限定收尾只陈述已采用V-compat联合结果与Context的适用旧证据/限制，不因本次维护新增验收、审计或构建项。 | 原H/G-ACCEPTANCE未通过；两方法、作者自检或未来限定收尾均不释放该门槛。 |

D/B/M已采用效果及原分支历史只复用，不新增R技术等待或重跑；1165技术completed与历史Router采用连接未闭合分别记录，不新增审计前置。Q-Neo限定actionFingerprint源码及完整Q g1均已采用completed，运行来源为[仓内报告](../../../build/verify-forge-patch-neo-lambda-fix-20261028-g1/report.json)：outer1/nested1/prepare0/reference0、outer exit0、JUnit1/0/0/0，旧内容/冷段适用性/原路径真实hit/新内容通过；不重跑、不新判gate。原P-v6 partial/已接受例外、全部旧failed/blocked/unknown、完整代理未满足及覆盖损失保留。

**下文Q源码/运行“待实施/待执行”只保留准备时点，以上述已采用事实为准；下文原R/V/H合同及其Wave等待不是本轮派发入口。**

## Q-Neo lambda插桩比较失败后的恢复连接

匹配[Work](work.md#q-neo-lambda插桩比较的限定恢复维护)、[Context](context.md#q-neo-lambda插桩差异与本轮失败采用)、[Plan](plan.md#q-neo-lambda插桩归一化后的接续策略)。本次仅 C5 受影响连接维护及作者自检，不实施、不运行、不代独立复核、实施确认或 gate 判断；PRD/ADR/Spec 已采用评估均 reuse。Stream 一行源码 g1 completed 已采用，且[本轮仓内报告](../../../build/verify-forge-patch-neo-stream-fix-20261028-g1/report.json)证明唯一 outer 的 `compileTestKotlin` 已真实通过。随后 `RECOVER-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX` g1 failed 已采用：outer1/nested0/prepare0/reference0、exit1、JUnit `1/1/0/0`，action 身份断言失败，旧完整内容/冷段当前适用性/原路径 hit/新完整内容均未建立。原 blocked、先前编译 failed、本轮身份 failed 及已发生调用、全部旧 gate 不满足历史分别保留；不重做 Stream 或 WIRE/空 Java FIX/T/P，不要求旧失败转成功。

### FIX-FORGE-PATCH-NEO-ACTION-FINGERPRINT — 限定lambda指纹的源码交付

**既有采用事实：源码g1已completed并被Router采用，以下原源码合同保留，不再实施或重复验证；不由作者新判断gate。**

- 单一谓词：仅在 helper `actionFingerprint` 内交付 [Plan 严格 bootstrap 归一化](plan.md#仅actionfingerprint的严格归一化边界)，形成后续 Q 可独立消费的源码，一个 item/Handler/独立源码 Result。严格匹配标准 `LambdaMetafactory.metafactory` 的三参数与对应 `altMetafactory` 的同三参数加整数 flag `1`，包括 bootstrap Handle 的 owner/name/descriptor/tag/interface；无其它 flag/额外参数。
- 保留边界：SAM 类型、实现 Handle、实例化类型及其值/目标属性、invokedynamic 名称/descriptor 和其它指令保持；未匹配形态照原规则比较，不吞异常、不跳身份断言、不归一不同实现目标、不普遍忽略 invokedynamic。仅 public `resolve()V`/`SKIP_DEBUG`/SHA 的原选择不变，不能凭 Handle 相同声称完整方法体或生产链等价。最终产物 class 的原仅忽略 debug 比较不受此规则影响。
- 前置item：FIX-FORGE-PATCH-NEO-STREAM-COLLECTION（已采用源码 completed）；唯一归属 W-FORGE-PATCH-NEO-ACTION-FINGERPRINT，等待 G-FORGE-PATCH-NEO-STREAM-COLLECTION 的足证据采用。WIRE/空 Java FIX 经原链保留，已采用诊断和用户接受方向为输入，不新增评估/诊断项，不等待旧 failed/blocked Q gate、自身或 R/V/H；作者不重判既有 gate。
- 写拥有/完成证据：只改 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceInputs.kt` 内该局部函数。精确 diff 和局部回读逐项证明严格匹配、前三项/其它指令/未匹配保留及身份/最终比较未减；不改其它函数/文件、生产/版本/key/输入、用户配置或旧证据。Result 明示未编译/实跑，源码完成不代 Q 成功；必要编译只在后项唯一 outer，不新增单测、编译探针、全链审计、运行时快照或额外验证成果。
- 冲突/停止：helper/Forge/fixture/Gradle/TestKit/build/cache 共享写运行串行，读取同一材料不另造成功依赖。当前形态不符、实现漂移、需扩归一范围/删除断言/改最终比较、权限/冲突不明即停保留实际状态，不终止无关进程。限定独立复核与适用实施授权由 Router 按原合同判断，本项不代办或放行后项。

### RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX — 保留原标准的完整Q新运行

**既有采用事实：本项g1已completed并被Router采用，真实结果见[报告](../../../build/verify-forge-patch-neo-lambda-fix-20261028-g1/report.json)。原调用已执行完毕，不重复运行；以下原完整合同保留，旧blocked/failed及旧gate不回填。**

- 单一谓词：在上述限定源码上取得原完整 Q 的旧完整内容/冷段当前适用性→原路径真实 action hit→完整新内容合取，一个 item/新 Handler/独立运行 Result。内部检查同属一个不可拆 JUnit，不拆旧内容/冷段/hit/新内容，不在运行中修源码，不重放或回填旧 Result。
- 前置item：FIX-FORGE-PATCH-NEO-ACTION-FINGERPRINT、FIX-FORGE-PATCH-NEO-STREAM-COLLECTION、FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、WIRE-FORGE-PATCH-NEO-VERIFICATION、RECOVER-FORGE-PATCH-NEO-CPW-MODS、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE。唯一归属 W-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX，等待 G-FORGE-PATCH-NEO-ACTION-FINGERPRINT、G-FORGE-PATCH-NEO-STREAM-COLLECTION、G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE。每个 item 谓词与所属 Wave 全部前置 gate 均须足证据 completed/完整采用；已采用前置不重做，不等三次旧 Q blocked/failed gate、自己或下游，局部复核和适用实施授权仍由 Router 判断。
- 写/调用拥有：按 [Plan 新运行](plan.md#原完整q的同范围新运行)复用既有 prepared/reference 和最近失败轮实际 command/init 原语义，仅必要输出及 init 引用重定位真正全新 Q 根；同一确切空 Java 预检/56项顺序/存在分支、selector/输入/原完整路径/离线隔离不变。旧 F/所有旧 Q 根只读，原 operation cache 正常原生 lock 例外保持；不改源码、原参数/reference/metadata、生产、依赖、用户配置或旧证据，不建空目录/假 hit。
- 完成证据：完整继承[原 Q 谓词](#verify-forge-patch-neo--neo-收窄合同完整实际验证-q-neo)、[全内容/冷段](plan.md#完整内容断言与冷段适用性)与[原路径/调用](plan.md#唯一路径离线供给与调用)。旧 final 全量 official/无mcinject/定义/引用/优先级/资源/AT/Dist主属性-marker-有限资源及当前冷段适用性通过，才允许原 operation10/inputs/key `6d7a8c95`/basename/完整路径的真实 task action hit，随后完整新 final 同一比较。outer 真实 exit0、当前唯一 XML `1/0/0/0`、nested 真实 BuildResult/TaskOutcome SUCCESS、明确 hit、原 Java21/独立参考/工具/实际加载/产物关联全齐才完成；编译通过、指纹修正/Handle相同、旧 XML/成功、UP-TO-DATE/FROM-CACHE/SKIPPED 或 miss 均不能代证。
- 预算/停止/冲突：本新项 outer≤1/nested≤1/prepare0/reference0，编译仅自然包含在唯一 outer，不另开 compile/help/探针、重跑成功项或添加单测/快照/全链审计。失败/unknown/缺证/输入身份不适用/冲突/miss 即停保全，不下载、冷生成、prepare/reference、追加源码修复或第二次调用；旧已耗调用不抹去、不推导无限重试。共享 helper/Forge/fixture/Gradle/TestKit/build/cache 写运行串行，不终止无关进程；不恢复历史 daemon、排空、共享 problems 旧字节调查要求，原未知影响如实保留。

**必要直接连接。** TEST-FORGE-PATCH-NAMESPACE（R）、VERIFY-RECOVERY（V）、REVIEW-ACCEPTANCE（H）的直接 Q 输入、R Wave 的 Q gate 及最终 G-RECOVERY-INTEGRATION 第1/10款改接本新 Q 结果/gate；V/H 仍经 R/最终复验 gate，原十二个完整消费者不增。源码 gate 只经本新 Q 消费，Q-1165/D/B/M 不加修复或 Neo 前置。完整代理、R 四矩阵/冷热、V 同版 fresh/根入口、H 不同 Handler 独立验收及原历史失败/unknown/覆盖损失/越界影响不减。新 gate 仅所属全部 item completed/足证据且完整采用后由 Router 判断；本次维护、方向接受、作者自检或有利复核不释放任何 gate。

作者自检只覆盖上述两个未来单一结果、各唯一 Wave/gate、真实前置与冲突、item/Wave 联合等待、必要直接消费者及原完整标准衔接，证据见本次维护 Result。不同 Handler 的限定独立复核尚未执行，本次源码与 Q 均未执行；未改原方案不重审，不新增第二执行图或辅助交付。

## Q-Neo Stream编译失败后的恢复连接

**历史恢复记录。** 以下两项原合同及旧失败限制保留：Stream 源码 g1 已 completed，随后 Q g1 已因身份断言 failed；当前唯一接续以页首 lambda 恢复连接及 Wave 表新增两行为准，不重做 Stream、不再派发该旧 Q。

匹配[Work](work.md#q-neo-编译失败后的最小接续维护)、[Context](context.md#q-neo-编译失败与stream根因采用)、[Plan](plan.md#q-neo-stream收集修正后的接续策略)。本次唯一成果为 C5 局部恢复连接及作者自检，不实施、不运行、不代独立复核或实施确认、不释放 gate。下节为空 Java 例外的历史安排；FIX g1 源码 completed/窄预检成功保留，随后 RECOVER-FORGE-PATCH-NEO-PREPARED-VALIDATION g1 为 failed，outer1/nested0/prepare0/reference0、exit1、compileTestKotlin 失败，JUnit/内容/hit 未到达，见[报告](../../../build/verify-forge-patch-neo-empty-java-20261028-g1/report.json)。其旧 gate 未满足，原 Q blocked 及所有历史状态保留；不重放旧 Result，不等待旧失败转成功。

### FIX-FORGE-PATCH-NEO-STREAM-COLLECTION — 一行收集 API 的源码交付

**已有成果保留：** g1 源码 completed 已采用，且随后唯一 Q outer 已真实执行 `compileTestKotlin` 通过；该源码不重做。以下为当时的静态交付合同，不将后续 Q 失败回填为源码失败或抹去实际编译事实。

- 单一谓词：只在 ForgePatchNamespaceInputs.kt 第279行原 Files.list(transforms).use 内，把过滤后的末端 .toList() 换为 .iterator().asSequence().toList()，保留过滤、遍历顺序、即时收集、use 关闭、原完整断言及 default。源码可独立保留并由 Q 消费，故一个 item/Handler/独立源码 Result；不夹带编译或 Q 运行。
- 前置item：FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT（已采用源码 completed）；唯一归属 W-FORGE-PATCH-NEO-STREAM-COLLECTION，等待 G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT 的足证据采用。WIRE/T/P/FIX 既有成果复用，不重做；已采用诊断是输入，不新增诊断 item，不等旧 failed/blocked gate、自身或 R/V/H。
- 写拥有/证据：只改该 helper 的这一行，实际 diff 与静态回读证明唯一表达式替换及保留行为；不改281/283/299、import、toolchain、依赖/代理/生产/用户配置/旧证据，不创建运行根或新增测试/工具。Result 明示未编译/实跑，静态交付不能证明 Java11 编译或 Q 成功，必要编译留到后项唯一 outer。
- 冲突/停止：与 helper/Forge/fixture/Gradle/TestKit/build/cache 共享写运行串行。当前源码不符、需额外修正或权限/实际冲突不明时保留实际状态并停止，不扩大改动或终止无关进程。独立限定复核及适用实施授权仍按原合同，由 Router 判断，本项不代确认或释放 Q gate。

### RECOVER-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX — 原完整 Q 的未完运行接续

**g1 已采用 failed：** 唯一 outer 内 `compileTestKotlin` 真实通过，outer1/nested0/prepare0/reference0、exit1、JUnit `1/1/0/0`，身份断言失败；旧完整内容/冷段当前适用性/hit/新内容未建立，旧 gate 未满足。本项原预算已耗，不继续派发、不以新结果回填；当前接续仅为页首 RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX。

- 单一谓词：在上述源码交付上完成原完整 Q 的旧内容/冷段适用性→原路径真实 action hit→完整新内容合取，一个 item/新 Handler/独立运行 Result；不是旧 failed Result 重放。一个 JUnit 内的内容/hit 不拆项，运行中不修源码。
- 前置item：FIX-FORGE-PATCH-NEO-STREAM-COLLECTION、FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、WIRE-FORGE-PATCH-NEO-VERIFICATION、RECOVER-FORGE-PATCH-NEO-CPW-MODS、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE（各须完整采用 completed/足证据；后四源码/技术结果已采用，不能以本维护代判 gate）。唯一归属 W-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX，等待 G-FORGE-PATCH-NEO-STREAM-COLLECTION、G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE。不等旧 Q failed/blocked gate、自身或下游；局部复核与适用实施授权仍由 Router 判断，原不变范围不重求批准。
- 写/调用拥有：沿 [Plan 原入口与新输出边界](plan.md#q-neo-stream收集修正后的接续策略)，使用失败轮实际 command/init 的原语义，仅必要输出及引用重定位真正全新 Q 根；同一确切空 Java 预检/56项顺序/存在分支、原 selector/原料/路径/离线隔离不变。旧 F/两 Q 根只读，原 operation cache 正常原生 lock 例外保持。不改源码、原参数/reference/metadata、用户配置/依赖/生产，不建空目录/假 hit 或削减断言。
- 完成证据：完整继承[原 Q 谓词](#verify-forge-patch-neo--neo-收窄合同完整实际验证-q-neo)及 [Plan 全内容与冷段](plan.md#完整内容断言与冷段适用性)、[原路径/调用](plan.md#唯一路径离线供给与调用)。旧 final 完整 official/无mcinject/定义/引用/优先级/全资源/AT/Dist主属性/marker/有限资源关系及当前冷段适用性通过，才允许原 operation10/inputs/key 6d7a8c95/basename/完整路径真实 task action hit，再验新 final 同一完整内容。outer真实 exit0、当前唯一 XML 1/0/0/0、nested真实 BuildResult/TaskOutcome SUCCESS/明确 hit、Java21/独立参考/工具/实际加载/产物关联全齐才完成；旧 T/P、源码/诊断/编译、旧 XML、UP-TO-DATE/FROM-CACHE/SKIPPED 或新 root miss 均不能代证。
- 预算/停止/冲突：旧 Q 的 outer1 已消耗永久保留，但不是禁止本次新接续的依据；此项自身仅 outer≤1/nested≤1/prepare0/reference0，编译自然包含在唯一 outer，不另开 compile/help/探针或重跑成功项。失败/unknown/缺证/输入不适用/冲突/miss 即停保全，不下载、补冷生成、prepare/reference、追加源码修复或第二次调用；不推导无限自动重试权。共享源码/Forge/Gradle/TestKit/build/cache/fixture 写运行串行，不终止无关进程。共享 problems report 旧字节/覆盖影响未知如实保留，不添加调查门槛，不恢复输出排空/历史 daemon 要求。

**必要直接连接。** R/TEST-FORGE-PATCH-NAMESPACE、V/VERIFY-RECOVERY、H/ACCEPT-RECOVERY 的直接 Q 输入及 R Wave 的 Q gate、最终 G-RECOVERY-INTEGRATION 第1/10款仅接新 Q 结果/gate；V/H 仍分别经 R/最终复验 gate，原十二个完整消费者数量不增。源码 gate 只经新 Q 被消费，Q-1165/D/B/M 不加 Neo 或修复前置。完整代理、R 四矩阵/冷热、V 最终同版 fresh/根入口、H 不同 Handler 独立验收及历史失败/unknown/覆盖损失/越界影响不减；任何新 gate 仅足证据 completed Result 完整采用后由 Router 判断，不由本维护自动释放。

作者自检仅限本节、两项各唯一 Wave 表行、必要前置及直接消费者、四文档互链和原成功条件保留；不是独立复核或实施确认。原已审未改方案不重审，不新增第二执行图或辅助验收项。

## Q-Neo 最小接线的待确认连接

**此前准备合同保留。** 本节原“当前新增/直接连接/未来一次”等均按空 Java 例外准备时点理解；FIX 已 completed、其后 Q 已 failed，现行恢复项、gate 及直接消费者以页首 lambda 恢复连接和 Wave 表为准。本节不构成重复派发、重新实施确认或旧失败 gate 的等待。

匹配 [Work](work.md#q-neo-最小接线的待确认准备)、[Context](context.md#t-neo-成功采用与q-neo-准备边界)、[Plan 策略及作者自检](plan.md#q-neo-最小接线策略与作者自检)，沿用原锚点。本轮只准备用户已接受的确切空 Java 声明输出例外及必要接续图并作者自检，不实施、不运行、不独立 review、不派发、不判 ready、不确认实施或释放 gate。原安排 review completed 无阻断、原范围已确认；WIRE/T/P 三个原直接 gate 已由 Router 据采用证据判断满足。受影响新安排仍待不同 Handler 独立定点复核及 Router 的 C6 披露确认，未改范围不重新求批准。

已采用 `recover-forge-patch-neo-cpw-mods` generation1 completed：本轮一次/累计第五次、exit0、JUnit `1/0/0/0`、prepare/reference/实际 Java21 工具和产物齐备，只是 T-Neo 及候选冷段输入。T gate 采用仍归 Router，本作者不代办；原 CPW-MODS 节和表的“未来一次”等只保留第五次前合同，不再授权重跑。原 failed/partial/blocked/unknown、进程越界/旧证据覆盖及影响未知保留。

**采用与分组。** WIRE g1 已采用 completed，仅静态核对，未编译/实跑；原 [Q](#verify-forge-patch-neo--neo-收窄合同完整实际验证-q-neo) g1 已采用 blocked，outer/nested/prepare/reference 全为0，无 XML/新 final，见[仓内阻断报告](../../../build/verify-forge-patch-neo-20261028-g1/report.md)。诊断 completed 只建立原因和窄修正方向，不能代 Q 成功。保留原源码及 blocked/旧 gate，不重做 WIRE，不将原 blocked 改 completed。helper 局部修复有独立稳定源码成果；后续 Q 有独立预算与真实终态，必须各一 Handler/Result。旧全内容/冷段适用性→一次原路径 action hit→完整新内容仍合成一个不可拆 JUnit，不拆内部检查/冷段/hit。仅下列恢复连接是当前新增执行安排，原 Q item/Wave 保留完整历史合同。

### WIRE-FORGE-PATCH-NEO-VERIFICATION — opt-in 接线源码交付

**已采用源码事实：** generation1 completed、三个接点已交付；仅静态核对、未编译/实跑，`G-FORGE-PATCH-NEO-VERIFICATION-WIRING` 已由 Router 判断满足。以下首次交付合同保留，旧“拟新增/待确认”只属当时，不授权重做；本次局部修复不回填或重开该成果。

- 单一谓词：仅在 Plan 三个既有源码接点交付 opt-in JUnit/helper/fixture 复用分支及原 Q 全内容断言，使原 prepare/default 行为保留，且形成可供下一项读取的稳定源码；一个 Handler/独立 Result。不是 Q 已运行/通过，也不是仅参数接线。
- 前置item：无；采用 T-Neo 原料与现有接口作为设计输入，不以 T/P gate 先释放作为无运行源码交付的条件。唯一归属 W-FORGE-PATCH-NEO-VERIFICATION-WIRING，无前置 Wave gate；不等 Q/R/V/H/自己 gate。实施本身仍待本增量独立定点复核、Router 披露确认及合法即时写条件。
- 写拥有：仅 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceFixtureTests.kt`、同目录 `ForgePatchNamespaceInputs.kt`、`minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts` 的 Plan 所列接点。无第四个项目源文件、生产/依赖/权威/用户配置/JDK/历史材料修改；不创建 Q 运行根、不运行编译/Gradle/JUnit/prepare/reference。
- 完成证据：实际 diff 可定位到拟新增的 `verifiesPreparedNeo121NoMcinjectWithCacheHit()`、`verifyPreparedNeo121NoMcinject(preparedRoot: Path, evidenceRoot: Path): Path` 与 `neoPreparedRoot` 分支；静态逐项核 Plan 完整断言、原 prepare/default 路径、唯一 runner 调用及原 output producer 依赖。源码 Result 明示尚未编译/实跑，编译归 Q 唯一外层；仅方法名/注释/空实现不完成。
- 冲突/停止：与这三个接点及共享 Forge/fixture/Gradle/TestKit/build/cache/输入写运行串行；不增加与其它分支的业务成功依赖。接点无法实现完整原合同、需第四文件/生产修复/新框架或权限不足即停止报告，不自行扩范围；只保留实际已写效果，失败不回填任何旧 Result/gate。

### FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT — 三处同一限定规则的源码修复

**已有成果保留：** g1 源码 completed/静态核对及后续窄预检成功已采用，不重做。下列待实施等为原准备时点；本维护不重判或释放其 gate。必要编译已在后续 Q outer 尝试并失败，不能再称当前 helper 从未编译尝试。

- 单一谓词：保留 WIRE 已交付源码，仅纠正 helper 原 classpath、旧 clean-at/patched-at argv、当前 runner classpath 三处无条件真实路径解析，使三者一致应用 [Plan 确切例外](plan.md#限定空java输出规则与恢复边界)；一个 Handler/独立源码 Result，不编译、不运行、不声称 Q 完成。
- 前置item：WIRE-FORGE-PATCH-NEO-VERIFICATION（已采用 completed/足静态证据）；唯一归属 W-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT，等待 G-FORGE-PATCH-NEO-VERIFICATION-WIRING（已采用满足）。诊断 completed 与用户接受例外是已定设计输入，不另加诊断/准备 item，不等旧 Q blocked/自己/下游。实施仍待此次受影响边界独立定点复核及 C6 确认。
- 写拥有：仅 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceInputs.kt` 的 Q 方法相关三处及必要局部解析；不重做 JUnit/fixture，不改原参数/reference argv/metadata、生产/依赖/用户配置/旧材料，不建缺失目录/新工具/测试/运行根，不运行 compile/help/探针或构建。
- 完成证据：三处实际 diff/定位与静态逐项核对，确切 `minecraft-codev-forge/build/classes/java/main` 仅已证缺失且当前空 Java 源集时保留声明项，存在时正常真实路径/来源检查；56项和顺序全部保留，其余55项含 Kotlin/JAR 无豁免、不吞任意异常；原完整断言/default/唯一 runner/producer 依赖及未来预检同一规则未减。明示只静态核对、未编译/实跑；未来预检是后续运行项的内部义务，不由本源码 Result冒称已执行。
- 冲突/停止：与 helper/Forge/fixture/Gradle/TestKit/build/cache/输入写运行串行；缺权限、必要输入/当前空集依据不成立、真实差异/冲突/unknown、需改其它文件或删断言/扩大例外即停并保留实际状态。源码完成只供后续 Q，不释放其消费者；修复必要编译只在后续唯一 outer，不另跑编译或测试。

### RECOVER-FORGE-PATCH-NEO-PREPARED-VALIDATION — 限定纠正后的唯一Q运行

**历史 g1 failed：** run-q-neo-empty-java-recovery-once 的唯一 outer 已返回 exit1，compileTestKotlin 失败；outer1/nested0/prepare0/reference0，无 JUnit/内容/hit，旧 G-FORGE-PATCH-NEO-PREPARED-VALIDATION 未满足。下列原完整合同和一次调用已消耗事实保留，不继续派发或回填；当前未完接续只由页首新源码/新 Q 承担，不将旧额度写为永久禁令。

- 单一谓词：在局部修复源码上完整建立原 Q-Neo 所有内容/适用性/原路径 action hit/完整新内容合取，一个独立 Handler/新可区分 Result；不是原 g1 blocked 转成功，不拆启动/预检/断言/hit 为独立项，不在运行内修源码。
- 前置item：FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、WIRE-FORGE-PATCH-NEO-VERIFICATION、RECOVER-FORGE-PATCH-NEO-CPW-MODS、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE（各完整采用 completed/足证据；后三者已采用）。唯一归属 W-FORGE-PATCH-NEO-PREPARED-VALIDATION，等待 G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE（后三 gate 已由 Router 判断满足）。不等旧 blocked/旧 G-FORGE-PATCH-NEO/自己/R/V/H/其它组，仍待受影响复核与 C6 确认。
- 写/调用拥有：仅未来真正全新 Q build 根的原合同薄 init/调用/日志/XML/tmp/私有 project/TestKitDir/home/output/evidence；预检按 Plan 同一确切例外检查56项及存在分支，不改 argv/reference argv/metadata、不建 Java 空目录或额外脚本工具。原 F/旧 g1 阻断根只读、仅原 operation cache 正常原生 lock 例外不变，旧 cache JAR 不改写。入口为已交付 opt-in 精确 selector，必要修复源码编译只在该唯一 outer；不另跑 compile/help/探针、不新增测试/构建。
- 完成证据：逐项继承 [原 Q 全部谓词及证据](#verify-forge-patch-neo--neo-收窄合同完整实际验证-q-neo) 与 [Plan 完整内容/冷段](plan.md#完整内容断言与冷段适用性)、[路径/隔离/调用](plan.md#唯一路径离线供给与调用)。先验旧完整内容与当前冷段适用性，通过后才一次原 operation10/inputs/key `6d7a8c95`/basename/完整 path 真实 task action hit，随后新 final 全验；outer真实exit0、当前唯一 JUnit XML `1/0/0/0`、nested真实BuildResult/TaskOutcome `SUCCESS`、明确hit及原离线隔离/Java21/工具/独立reference/源码加载/产物关联全齐。旧 T/P、静态源码/诊断、旧 XML、UP-TO-DATE/FROM-CACHE/SKIPPED、复制或新root miss不能代证。
- 预算/停止：未来合计 outer≤1/nested≤1/prepare0/reference0；g1四类调用0不增加额度或授权自动重试。当前必要输入缺失/空集依据不符/冲突/身份漂移/unknown 即停；未启动缺前提 blocked，实际编译/断言/构建失败 failed，未到达如实保留。旧内容/冷段不适用、缺21/离线依赖/真正必要文件、miss、无XML/真实退出或实际hit缺证均不完成；不下载/补冷生成/prepare/reference/第二次outer或nested/追加修复，不以剩余额度推导再试授权。
- 冲突：与局部源码修复及其它共享源码/Forge/Gradle/TestKit/build/cache/fixture/输入写运行串行；新 Q 根不消除原 cache/编译输出冲突，已完成来源只读不增加业务成功依赖。

**此前直接连接及未完边界（历史）。** R 的 `TEST-FORGE-PATCH-NAMESPACE`、V/H 的直接 Q 前置、R 所属 Wave 前置 gate 及最终第1/10款的 Q 位置仅换接 `RECOVER-FORGE-PATCH-NEO-PREPARED-VALIDATION`/`G-FORGE-PATCH-NEO-PREPARED-VALIDATION`；V/H 原 Wave 分别仍经 R/最终复验 gate 等待。原 `VERIFY-FORGE-PATCH-NEO` g1 blocked及`G-FORGE-PATCH-NEO`未满足保留，不要求变成功、不回填。新 gate 仅在本恢复 Q 独立 Result completed/足证据且 Router 采用后可能满足；局部源码通过此 Q 被消费，不添加第13个完整恢复消费者。Q-1165/D/B/M 不加 Neo/修复前置；完整代理仍未满足，R 四矩阵/三组冷热、V 最终同版 fresh/根入口、H 独立验收及全部旧 failed/partial/unknown/覆盖损失/越界影响保留，不增加 gate 豁免。

## NeoForge cpw.mods 局部恢复连接

**第五次前合同保留。** 本项 generation1 已采用 completed，事实见页首 Q-Neo；T gate 判断不由本作者代办。以下未来一次/未实施仅属原准备历史，不再授权重跑，Q/R/V/H 仍待自身完整结果。

匹配 [Work](work.md#neoforge-cpwmods-过滤修正后的单次恢复)、[Plan](plan.md#neoforge-cpwmods-局部恢复策略)、[Context](context.md#neoforge-第四次失败与cpwmods诊断采用)。用户已确认“修正并运行一次”；本次只准备新恢复项及作者局部自检，不修改模板、不运行项目、不独立 review、派发或释放 gate。PRD/ADR/Spec reuse、权威写入 skip。此前 AFTER-PROXY generation1 已 failed：一次/累计第四次、exit1、JUnit1/1/0/0，缺三个 cpw.mods 模块，prepared/reference 未完成；其原合同与前三次失败/unknown 保留。下节原“尚未执行/累计至多四次”等仅属第四次前的准备历史，不再现行等待。

### RECOVER-FORGE-PATCH-NEO-CPW-MODS

- 单一谓词：仅纠正已证模板过滤排除 cpw.mods 的缺陷，并用原 Neo 精确方法一次满足原完整 T-Neo；一个 Handler/一个可区分的新 generation1 Result。一处修正与原回归只建立该修复结果，无独立代码/自检成果边界，不拆内部检查项。仅修改或仅执行一次不算完成。
- 前置item：FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8（已采用满足 G-REPAIRS）、RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（后两项与 gate 已满足，复用不重跑）。唯一归属 W-FORGE-PATCH-FIXTURE-NEO-CPW-MODS，等待 G-REPAIRS、G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。仅本次同一未完 Neo 继续免 G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE 及其准备/最终审计等待，不等旧 failed/自身/后继或另组成功；不以有限三模式替代完整代理 gate，不重跑清理编译、三模式、root/bootstrap/remapped。
- 写拥有：未来仅模板 `minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts:19` NeoForge content 中追加 `includeGroup("cpw.mods")`，regex、仓库顺序、metadataSources、坐标/版本和依赖集合不变；不改原测试/helper/生产/代理/用户配置/JDK/历史证据/Git。该模板各 phase/其它样例也获得此 group 资格，用户已接受，运行仍仅 Neo。其它只写全新本轮 build 根必要同内容 init 副本/薄调用/正常私有输出及脱敏报告，不另建工具或验证项。
- 唯一调用：沿 [Plan 当前参数基线](plan.md#neoforge-cpwmods-局部恢复策略)的最近第四次实际 command.json 及同轮 init，保留20项有序 argv、cwd/executable/JDK/source-home；只允许必要新输出重定位。唯一任务/selector 为 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache`，未来至多一次、累计至多五次；原四次失败累计不重置，不借用 P/basic 预算，不另开编译/测试。
- 完成证据：本轮仅所述过滤追加、原 selector 实际执行/Gradle真实exit0/JUnit1/0/0/0，并且固定 MC1.21/NeoForge21.0.76-beta/NeoForm1.21-20240613.152323、真实provider/实际Java21工具角色/独立official reference/类与接口引用/资源见证/适用AT-Dist-marker/完整私有隔离/prepared及final output和命令/输入/JVM/阶段/任务图/argv/日志/退出收束全关联。沿原 T-Neo 全部准备，不以编译、过滤已改、libraries闭合、候选JDK、布局executed字段、旧缓存/XML或跨轮拼证代完成。自然阶段未到达就记未证，代理有效值/逐请求路由原未证限制保留，不新增来源证明或探针。
- 冲突/停止：所有共享模板/Forge/helper/Gradle/TestKit/build/cache/fixture 写运行串行；实际执行前只核当前相关共享冲突、必要输入/JDK/私有隔离及新输出不覆盖，本次准备不做运行时检查。不加控制器、矩阵、全量hash、daemon历史或来源调查，不清缓存/安装/复制用户配置/杀预存进程。缺权限/必要输入/JDK且未启动为 blocked；真实失败为 failed，失败/unknown/缺证保存实际命令/次数/日志/退出或未知原因/本轮XML与产物/未到达边界后停止，不重试、不追加修复或调用。修改已保留但运行失败仍不完成，所有旧失败/unknown和gate不回填。
- gate/必要消费连接：仅新Result completed/足证据且完整采用后才可能满足 G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS。Q-Neo/R/V/H 与最终 G-RECOVERY-INTEGRATION 第1/10款及 G-ACCEPTANCE 的 T-Neo 位置只换接新身份；旧 AFTER-PROXY item/Wave/gate 保留 failed/不满足历史。Q-Neo 独立完整内容/路径/冷热、R真实回归、V/H最终同版/独立验收及原完整代理合同不变，任何新成功均不自动释放后继，不增加参数/M或其它组的成功屏障。

作者自检只核新项/单成员Wave、原成功条件、已满足前置、串行冲突、直接消费者及最终合取；与四文档对齐。不重写其它历史/全图，不选执行次序、不推进实际状态或gate。原 AFTER-PROXY 下的消费说明按旧时点保留，当前连接以新项和相关显式前置/Wave/合取为准。

## NeoForge 本次单次尝试的当前边界

用户已明确接受“先跑NeoForge一次”。本次只准备一个运行项：复用尚未执行的 [RECOVER-FORGE-PATCH-NEO-AFTER-PROXY](#recover-forge-patch-neo-after-proxy) / `W-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY` 及未来唯一同名 generation1 Result，区别于原三次历史 failed；不另增并行 item 或派发运行。PRD/ADR/Spec reuse，权威写入 skip：仅本次运行前置例外，不改产品或隔离决策。

该 item 与所在 Wave 只移除完整代理 gate 及其准备/最终审计等待；G-REPAIRS、已满足的 root/bootstrap 与其它实际必要条件、原 selector 和完整 T-Neo 成功谓词不减。有限三模式证据已满足不构成完整代理验收，也不另设为新成功前置。原入口/实际参数及新输出规则集中在 [Plan](plan.md#neoforge-原测试一次尝试的原入口与参数来源)，采用事实与网络/JDK 未验证限制见 [Context](context.md#neoforge-单次尝试的已接受边界)。

本次原测试至多一次；失败/未知保存实际证据并停止，不补测试、不修代理/用户配置、不重试。仅后续运行前检查当前相关共享冲突和输出不覆盖，旧缓存隔离/必要 JDK 与原产物/JUnit 条件保留；本次准备不做运行时检查。完整代理 gate 仍未满足，Q-Neo 独立内容/缓存合同及 R/V/H 的其余等待不变，V/H 与其它完整消费者不因例外放行。下方 A 恢复的更早“Neo等待完整gate”描述仅为此前时点；当前以本节及对应 item/Wave 为准，不回填旧 failed/partial/blocked/unknown。

## 共同代理输出路径A恢复连接

匹配[Work](work.md#共同代理输出路径a恢复的最小维护)、[Plan](plan.md#共同代理输出路径a恢复策略与作者自检)、[Context](context.md#共同代理输出路径a选择与历史边界)。本轮只维护四份文档，未实施、未运行、未派发、未独立复核、未放行。A已完成；初次A读取失败、READ-RECOVERY CLI片段错误导致Java exit1/Gradle未启动/无XML、复合handoff在执行前blocked、CLI-PATH-RESTORATION额外猜测脚本读取失败均按历史保留。混合轮次证据根不跨轮拼接，历史越界终止进程的其它影响仍unknown。根缓存恢复和bootstrap argfile成功Result/gate已采用，只复用、不重跑。

当前唯一执行图保留准备、13个结果位置及最终独立只读隔离审计；本次只对齐`VERIFY-ISOLATED-GRADLE-PROXY-THREE-MODES` / `W-ISOLATED-GRADLE-PROXY-THREE-MODES`这一现有固定类selector的单次JUnit执行结果。一次方法中的三模式、内部断言、nested调用、真实客户端退出和本轮XML同属一个Handler/Result，不拆启动、不夹带来源矩阵或真实独立bootstrap build。旧`DEFAULT-DAEMON` generation1仍failed、构建启动0次/无项目写入/无JUnit；旧六项的“完整并入THREE-MODES”仅保留原迁移安排，现行有限谓词以下表为准，未覆盖合同转由原完整验收边界保留，不回填旧状态。

**当前前置与调用边界。** 根CACHE-RESTORE-REMAINDER、bootstrap ARGFILE成功Result/gate及`prepare-proxy-shared-validation` g1准备结果均已采用，复用现有[JSON](../../../build/proxy-a-read-recovery-eager-20261027-g1/junit-command.json)/[init](../../../build/proxy-a-read-recovery-eager-20261027-g1/verify.init.gradle)，不再修CLI路径或新建准备工程；`verify-proxy-entry-attribution` g1仅为已采用的限定静态归属结果。清理后[编译调用](../../../build/cleanup-compile-check-20261028-064620-294/compile-command.json)、[真实exit0](../../../build/cleanup-compile-check-20261028-064620-294/exit-code.txt)及[日志](../../../build/cleanup-compile-check-20261028-064620-294/gradle.log)支持mixins/fabric/forge五个测试编译任务实际执行，不等于Test通过，也不新增编译任务前置。实际运行前只做当前相关共享冲突和输出不覆盖检查，不猜准备目录为空；需要新目标时仅重定位现有init的evidence与命令/日志/XML保全输出，保留source-home、selector、JDK/完整单-P、offline/缓存语义及其它原参数。共享写运行串行，正常项目/cache输出照原边界；真实冲突/未知退出/真实失败即停并保存具体原因，无重试、预存进程终止、controller排空、旧daemon链或额外探针。

**原完整gate仍独立未满足。** `G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE`须原13个结果/gate、最终只读审计及完整合同缺口的实际证据全部齐备并经Router采用判定；单次JUnit有限成功不足以满足它。真实根Test合成来源的五键逐键缺失/空/非空、HTTPS显式空值、Properties转义/无关键及凭据排除等未覆盖映射证据仍缺，当前固定输入无补齐入口；它们不再是THREE-MODES完成门槛，也不因该gate有限通过而消失。其它来源变化/删除/失败关闭、显式覆盖冲突和真实独立build/错误恢复的独立结果仍保留，无本次执行授权。V/H及其它完整消费者仍只消费原完整gate及各自必要前置；仅本次Neo单次启动采用页首例外，原完整gate和成功条件不变，本文档维护不执行Neo。

**历史CLI-PATH-RESTORATION generation1 failed。** [独立报告](../../../build/proxy-cli-path-restoration-20261027-handler-g1/report.md)和[错误摘录](../../../build/proxy-cli-path-restoration-20261027-handler-g1/read-failure.txt)记录前三次检查/读取exit0，第四次额外读取猜测的`run-junit.ps1`不存在导致PowerShell exit1。Java/javac/Gradle/JUnit零启动、无XML/计数，路径/init未改；不是项目测试失败。摘录不是完整转录，旧报告根不得覆盖。

### RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY — 历史复合项（保留合同，不再派发）

**状态：** 本节及其原gate只记录此前的复合执行安排和完整原合同；由上方现行拆分项替代，不作为现行前置、等待或成功结果。不得把后续分项结果回填到该旧item/gate。

- 单一谓词：在已完成A、两处Java11及完整单-P输入上，一个新Handler/完整独立Result直接消费既有JSON/init，经两处原路径恢复及全新输出/init重定位，完成全部原未完共同传播/恢复/隔离验收；读取/路径/init纠正均只是内部动作，不拆独立项目成果，不再改源码。
- 前置item：`RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`（均已完整采用completed/足证据）；唯一归属`W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY`，等待`G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`（均已采用满足），不重验。不等旧CLI-PATH-RESTORATION或更早failed/旧gate转成功，不等自己、Neo、V/H。
- 调用/写拥有：直接解析[当前JSON](../../../build/proxy-a-read-recovery-20261027-g1/junit-command.json)的`executable/cwd/arguments`和[已有init](../../../build/proxy-a-read-recovery-20261027-g1/verify.init.gradle)；按[同版片段来源](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)仅在零基`arguments[2]`的`-javaagent`及`arguments[5]`的CLI jar中各将`lcvyxq3t37f6mx9miaydrrs`恢复为`lcvyxq3t37f6mx9miaydrrgs`，不复制整组旧D参数。保留Microsoft17/Gradle9.4.0/完整单-P/selector/cwd/source-home/offline/缓存/串行/max-workers及其余原arguments；未来必要输出/报告/XML/classes/worker/小build归真正全新根，新init副本仅改`isolated.proxy.evidence`到新根/junit、相应重定位命令init引用，sourceHome及其余init不变。源JSON/init及旧证据只读，不改源码/配置/依赖，不手工改缓存；正常Gradle/私有构建输出仍沿原拥有边界。
- 输入边界：已提供JSON/init足以准备原调用，猜测脚本不是依赖；不查找/探测/修复/重建旧脚本，不新增旧驱动前置、命令预审、文件存在自证、短进程实验、工具框架或审核门槛。必要薄调用直接使用JSON数组，不产生额外持久工具产品。
- 完整证据：沿原A全部合同及[Plan完整共同验收](plan.md#已完a与原完整共同验收)，A配置时机差异/五键时机不变；默认/显式TestKitDir与私有-g/embedded三模式、五键三态/真实home/来源变化删键删文件/未配置无残留、embedded正常与预期异常恢复；本轮新classes真实独立小build/来源先保存/六参/原309项有序classpath/原arguments/正常和异常及参数-oracle错误传播恢复；适用十入口含binding两路、原隔离脱敏/凭据排除、真实Gradle数值exit0与当前JUnit全部必需案例成功/实际XML计数/源码-classes-worker-输出关联及真实退出收束全部保持。旧Check/编译/静态归属/局部输出/skip/缺模式不能代完成。
- 冲突/停止：共享JUnit/编译/Gradle/TestKit/build/fixture/cache/相关输入写运行串行；新相关冲突/unknown/真实失败/缺证或越界即停保全，不杀进程、清缓存、覆盖旧根、重试或扩矩阵/工具。混合证据归属、历史未知与已有效果原样保留，不补造原件，本轮不执行Neo。
- gate/消费者（历史，现行连接已替换）：旧复合项当时仅在本项独立Result completed/足证据并由Router采用后才可能满足`G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY`；原图中“仅必要Neo/V/H item、所属Wave前置gate和最终合取换接该身份”的描述保留为历史，不是当前派发连接。现行消费者改接本表的准备、独立验收与只读审计图及`G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE`。旧CLI-PATH-RESTORATION item/Wave/gate仍failed/不满足且不回填。

作者自检仅核新增failed承接、授权与已完/未完事实、单谓词/两个前置、新item/独立Result/单成员Wave、直接双层连接/局部联合等待无环和旧合同保全；仅一次不同只读Handler必要局部复核该增量及连接，不重审A、既有成功或无关历史。本维护不实施、运行、派发、声明运行就绪/实施通过、采用Result或释放gate。以下原A/READ/CLI item及其Wave行均按原完整合同作为历史保留，其旧“当前/待确认”不另建现行等待或重复确认。

### RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION — A配置阶段固定输出路径并接续全部原共同验收

- 单一谓词：A源码接点已按用户选择落盘，仅在两项已采用成功前置上，以一个新独立Result完成全部原未完共同传播/恢复/隔离验收；当前恢复只把argv中`-javaagent`和`-jar`的两个`lcvyxq3t37f6mx9miaydrrs`目录片段恢复为`lcvyxq3t37f6mx9miaydrrgs`，不另拆路径纠正、源码修改或等价性检查成果。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（均须完整采用/completed/足证据）；唯一归属W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION，等待G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。不等旧Java11/单-P/共同failed或旧gate转成功，不等自己、Neo、V/H；实施前仍须独立局部复核、范围披露及明确实施确认。
- 写/调用拥有：A源码写入不再重复；未来仅按当前`junit-command.json`恢复上述两个CLI目录片段，和另一全新build根中的必要输出/报告/当前XML/真实classes/worker材料；不加JVM权限，不提前固定五键，任务action继续按原时机读取五键。三模式、断言、home/cache、完整单-P、Microsoft17/Gradle9.4.0/JDK/selector/cwd/source-home/offline/缓存/串行语义保持；不整体复制旧D invocation，不改根/bootstrap/生产/依赖/全局配置/用户配置、旧证据或历史脚本。
- 接受差异与证据：A已接受的缺少`probeOutput`属性配置阶段更早失败、配置完成后路径变化不再生效仍保留；A源码已写不等实测通过。两处Java11修复、完整单-P及原历史失败/越界/未知均只作为保留输入，当前READ-RECOVERY的Java exit1/Gradle未启动/无XML计数不冒充项目失败；未来仍须原完整JUnit/Gradle数值exit0/XML/计数关联、默认/显式私有`-g`/embedded三模式、五键三态与来源变化删键删文件无残留、embedded正常异常恢复、真实独立小build/来源先保存/六参有序classpath/原arguments/错误恢复、适用十入口含binding两路、隔离脱敏/凭据排除和真实输出收束。
- 冲突/停止：共享JUnit/编译/Gradle/TestKit/build/fixture/cache/输入写运行串行。真实失败、unknown、缺证、实际路径漂移、覆盖未定或A以外纠正即停保全；只用真正全新输出根，旧根只读，不主动终止预存/未知归属进程，不重试或扩矩阵/工具。配置阶段候选不改变五键求值、三模式、断言或缓存合同。
- gate/消费者：仅本项新完整独立Result completed/足证据且Router完整采用后，才可能满足G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION。仅Neo、V/H必要item/Wave和最终合取消费；Neo其它前置/至多一次/三次旧failed、V/H十二项/参数/完整M/fresh/根入口/独立验收保持。旧Java11/单-P/共同failed及旧gate不回填、不等待或释放。

作者自检及一次不同只读Handler局部复核限本A增量、原完整验收/历史、两项真实前置、新item/单成员Wave/gate、串行冲突/无环、Neo/V/H必要连接和四文档互链；不重审全图，不称ready，不实施、不派发、不采用、不释放gate。


OUTPUT-EAGER generation1 failed 发生在项目写入或构建前的读取阶段：一条PowerShell读取命令缺少外层块结束，原调用没有返回可用诊断文本；不补造parser错误号，不把PowerShell exit1算作项目失败。源码/配置零写入、构建零启动，旧item/Wave/gate、A完整合同及未满足状态原样保留。

### RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY — 读取失败后的A完整接续

- 单一谓词：新Handler先以正确、分段、短输出的PowerShell纯文本读取必要上下文，随后在两项已采用成功前置上承接原A配置接点，并以一个新独立Result完成全部原共同传播/恢复/隔离验收；读取不构成独立项目证据，不拆新测试、诊断或工具成果。
- 前置item：`RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`（均须完整采用/completed/足证据）；唯一归属`W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY`，等待`G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`。不等旧OUTPUT-EAGER failed/旧gate转成功，不等自己、Neo、V/H。
- 写/调用拥有与验收：完全继承原A item的接点、三模式、五键时机、断言、home/cache、单-P、JDK/selector/cwd/source-home/offline/串行、全新证据根、真实JUnit/Gradle数值exit0/XML计数关联、独立小build/来源先保存/六参有序classpath/原arguments/错误恢复、适用十入口及隔离脱敏/凭据排除；不改变A接受的配置时机差异，不改根/bootstrap/生产/依赖/全局配置/用户配置/旧证据。
- 读取/冲突/停止：仅先读所需文本，失败时只记录协调读取failed，不升级为项目失败或补造诊断；一旦开始项目实施，真实冲突、unknown、缺证、覆盖未定、路径漂移或A以外纠正即停保全。旧根只读，不杀进程、不覆盖旧证据、不重试或扩矩阵/工具。
- gate/直接消费者：仅新Result completed/足证据且Router完整采用后，才可能满足`G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY`。仅必要Neo、V/H item/Wave及最终合取改接新gate；Neo其它前置/至多一次/三次旧failed、V/H十二项/参数/完整M/fresh/根入口/独立验收不变。旧OUTPUT-EAGER item/Wave/gate保留failed且不回填、不释放。

作者自检仅复核：失败记录、一个恢复谓词、两个已采用真实前置、新item/Wave/gate、必要直接连接、局部无环、原A完整标准和当前用户确认；不重审A技术方案、B1/B2、旧历史或全图，不实施、不派发、不称ready。

**READ-RECOVERY generation1实际失败保留：** 上述item/Wave/gate的本次实际调用已由[报告](../../../build/proxy-a-read-recovery-20261027-g1/report.md)记录为Java启动exit1；stderr为无法访问当前`lcvyxq3t37f6mx9miaydrrs`目录下的Gradle CLI jar，Gradle未启动，JUnit/XML/计数均不可用。A源码的`.get()`改动已先落盘；这不是Gradle/JUnit项目测试失败，也不改判旧合同或释放旧gate。

### RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION — A源码完成后的CLI路径恢复与全部共同验收

- 单一谓词：在两项已采用成功前置和已落盘A源码改动上，新Handler以[当前argv](../../../build/proxy-a-read-recovery-20261027-g1/junit-command.json)为基底，按[有效目录来源](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)仅把`-javaagent`与`-jar`值中的两个目录片段`lcvyxq3t37f6mx9miaydrrs`恢复为`lcvyxq3t37f6mx9miaydrrgs`，必要时将输出重定位到真正全新的本项根，随后以一个独立Result完成全部原未完共同传播/恢复/隔离验收。路径恢复只是同一谓词内部动作，不新增独立修复、诊断或测试成果。
- 前置item：`RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`（均须完整采用/completed/足证据）；唯一归属`W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION`，等待`G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`、`G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION`。不等旧OUTPUT-EAGER/READ-RECOVERY/Java11/单-P/共同failed或旧gate转成功，不等自己、Neo、V/H。
- 调用/写拥有：只在当前`junit-command.json`上恢复这两个目录片段；保留Microsoft17、Gradle9.4.0、完整单-P、精确selector、source-home/cwd、offline/configuration-cache/build-cache/no-parallel/max-workers、原init脚本和其余arguments，不整体复制旧D invocation；必要输出、报告、XML、classes/worker和独立小build才可重定位到全新根。A源码不重复改写，不改根/bootstrap/生产/依赖/全局配置/用户配置/旧证据。
- 完整证据与停止：A的配置时机差异、三模式、五键时机/三态、断言、真实home/cache、来源变化/删键/删文件/未配置无残留、embedded正常/异常恢复、真实JUnit/Gradle数值exit0/XML计数与源码/classes/worker/输出关联、独立小build/来源先保存/六参有序classpath/原arguments/错误恢复、适用十入口含binding两路、隔离脱敏/凭据排除、真实输出收束及全部原停止规则不减。真实失败、unknown、缺证、冲突、路径漂移或两处以外纠正即停保全；旧根只读，不杀进程、不覆盖旧证据、不重试或扩矩阵/工具。
- gate/直接消费者：仅本新Result completed/足证据且Router完整采用后，才可能满足`G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION`。仅必要Neo、V/H item/Wave及最终合取改接新gate；旧READ-RECOVERY item/Wave/gate保留failed且不回填、不释放，Neo其余前置/至多一次/三次旧failed、V/H十二项/参数/完整M/fresh/根入口/独立验收不变。

作者自检仅覆盖：A已完成、CLI Java exit1/Gradle未启动、共同验收未完成三者边界；两个精确目录片段与全新输出根；两项真实前置；新item/独立Result/单成员Wave/gate、必要直接消费者/最终合取、串行冲突和局部无环、四文档互链。一次不同只读Handler仅复核本增量，不重审A技术方案、旧失败历史或未变全图；本维护不实施、不运行、不派发、不采用、不释放gate。

## 共同代理Java11兼容恢复连接

**历史保留说明：** 本节以下两处Java11修复、完整单-P、三次共同失败及旧gate合同不改写；它们不再是当前A恢复的item、前置或成功等待。最新Java11恢复generation1已failed，旧gate不满足；原VERIFY、单-P恢复两次旧failed及本项最新失败均保留其各自轮次，不回填、不作当前等待。 

匹配[Work](work.md#共同代理java11兼容恢复的已保留历史)、[Plan](plan.md#共同代理java11兼容恢复策略与作者自检)、[Context](context.md#共同代理两次failed与java11限定诊断采用)。本次仅局部维护/作者自检，未实施、运行或放行。原VERIFY generation1先因缺Java11发现而真实Gradle exit1、JUnit零执行；单-P恢复generation1越过发现后compileTestJava失败、真实Gradle exit1、JUnit零执行；最新Java11恢复generation1的两处修复已落地并编译通过，但整体真实Gradle exit1、JUnit为1/1/0/0，两个daemon各五stage的equal=true仅属局部观察，embedded失败且真实独立小build未完成。最新执行先门禁失败，随后越界强制终止三个预存相关进程，其他工作影响未知且未被接受。旧item/Wave完整标准仍保留，旧行条件式释放合同不是已满足事实。

`build/recover-isolated-gradle-proxy-validation-20261027-g1/`现为混合轮次根：`report.md`属旧单-P轮，部分command/log/exit/source已由最新轮覆盖，XML及小工程属最新轮；不把当前command当旧轮原件，不与旧报告拼成同轮证明，不补造丢失原件或改旧报告。准确会话中无可见Java/LSP分析调用，不据此补造静态分析事件。单-P已完/越过旧发现点、compileTestJava失败、最新局部编译通过但完整共同验收failed、正常缓存副作用及所有限制均不改判。

### RECOVER-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION — 两处兼容纠正接续全部原共同验收

- 单一谓词：保留既有JUnit，仅Plan两处宿主Java兼容纠正后完成全部原未完共同传播/恢复/隔离验收；一个新Handler/完整独立Result。编译和语义等价性仅内部检查，不独立拆修复成果。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（已完整采用completed/足证据）；唯一归属W-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION，等待G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（已采用满足）。不重跑或等旧VERIFY/单-P恢复failed/旧gate变成功，不等自己或Neo/V/H。
- 写/调用拥有：仅原IsolatedGradleProxyTests.java当前41–69行文本块→Java11普通字符串组合、31行宿主HexFormat→等价Java11编码；Groovy去共同缩进后逐行内容/内部缩进/末尾换行，SHA-256 32字节→64位小写补零/value:/absent/empty均保持，生成Groovy同名API不动，五键/三模式/stage/断言/异常/finally/home/cache不改。其它只限原授权薄驱动/未来全新build根必要输出，沿已纠正junit-command.json完整单-P及原调用语义；两旧根证据只读，不改根桥接/bootstrap/其它源码/配置/级别/JDK/依赖/用户配置、不重建测试或找工具链。
- 全部证据：原VERIFY/旧单-P恢复/Plan全部共同标准无减：精确JUnit所有必需案例真实成功/Gradle数值exit0/当前XML及实际计数与源码/classes/worker/输出关联；默认daemon/显式TestKitDir及-g/embedded三模式五键三态/一致性/真实home；真实来源变化删键删文件/随后未配置无残留、embedded正常异常finally恢复；本轮新javac持久bootstrap真实独立私有小build/来源先保存/六参有序classpath及原arguments/正常异常参数及oracle错误恢复；适用十入口含binding两路/原offline/缓存/output/tmp/fresh-reuse/脱敏/凭据排除隔离全部保持。编译/旧Check/静态归属/skip不能代动态，不重复已适用归属及根/bootstrap成功。
- 冲突/停止：共享JUnit/编译与Gradle/TestKit/build/fixture/cache/输入写运行串行，新根不等于无冲突。真实失败/unknown/缺证/覆盖未定/两处外实现纠正即停保全、不预报成功或自动重试。compiler未实测和中文日志不可恢复限制保留，不重复诊断或增compiler取证/框架/自证/矩阵/短进程/命令预审/全量快照/daemon门槛。
- gate/消费者（历史合同）：原本项的完整条件式释放合同只在唯一新完整独立Result completed/足证据并Router完整采用时成立；当前Java11恢复generation1已failed，G-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION旧gate不满足，当前不再等待或释放该gate。仅旧记录中的Neo、V/H必要item/Wave和最终合取消费关系保留；Neo其它原前置/至多一次/三次旧failed、V/H十二项/参数/完整M/fresh/根入口/不同Handler独立验收保持。原VERIFY与单-P恢复两次旧failed、最新本项失败及单-P已完效果不回填，本次不执行后继或释放。

作者自检及一次不同只读Handler局部复核范围见Plan，仅本增量和必要连接，不重审其它分支、不称ready。下节“本轮/新恢复/单-P候选”仅前次准备历史；旧恢复g1现failed，当前由本新项承接全部未完验收。


## 共同代理验证未完验收的恢复连接

**本轮仅局部安排与作者自检，未实施／运行／释放gate。** 匹配[Work](work.md#共同代理验证失败后的最小恢复维护)、[Plan](plan.md#共同代理验证的单参数恢复策略与作者自检)、[Context](context.md#共同代理验证g1失败与限定诊断采用)。原四项串行范围已确认；根剩余缓存恢复及bootstrap ARGFILE完整结果和各gate已由Router采用满足，不重跑。下方原准备“未确认／全部未执行／拟新增”等限原时点；新恢复仍保留这两个实际成功前置和对应Wave gates，不由本次文档代证或重新放行。

### RECOVER-ISOLATED-GRADLE-PROXY-VALIDATION — 单-P纠正后的全部未完共同验收

**历史generation1 failed：单-P已完成并保留，compileTestJava真实失败，Test/JUnit及独立小build零执行，G-ISOLATED-GRADLE-PROXY-VALIDATION-RECOVERY不满足。下列原完整合同与原Wave行保留，不作现行成功等待；新Java11恢复不回填本项或旧gate。**

- 单一谓词：保留已新增JUnit和适用的原十入口静态归属合同，以原完整工具链列表单-P纠正接续原共同三模式及真实独立小build全部传播／恢复／隔离义务，形成一个新Handler／完整独立Result。新增代理探针使当前真实入口至少为第十一个；静态结果只支持原十项及新探针发现，不证明全量清单或动态传播。Java11发现／越过旧解析点／编译仅为内部进展，不另拆item或代完整验收。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（均须完整采用/completed/足证据）；唯一归属W-ISOLATED-GRADLE-PROXY-VALIDATION-RECOVERY，等待G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。不等旧VERIFY failed或G-ISOLATED-GRADLE-PROXY转成功、不等Neo/V/H／自身gate；合法授权／即时相关资源条件仍适用。
- 调用／写拥有：按Plan从原D invocation逐字复用完整原顺序列表，作为原共同Gradle CLI一个-P参数；保留Microsoft17／Gradle9.4.0／selector／cwd／source-home、offline／configuration-cache／build-cache／no-parallel／max-workers及其余原语义，仅必要输出重定位未来全新本项build根。保留JUnit不重复新增或重建；必要测试承载／薄驱动仅属原已授权共同验收，不扩大源码权限、不修根／bootstrap／生产，不加全局-D、安装／下载／配置／代理读取器能力；旧证据仅读。
- 完整证据：继承原VERIFY item及Plan全部共同标准，真实JUnit全部必需案例成功／数值Gradle exit0／当前XML与实际计数、源码／classes／worker／输出关联；默认daemon、显式TestKitDir/-g、embedded三模式五键三态／一致性／home、源变化／删键／删文件／未配置无残留、embedded正常／异常恢复；本轮新javac持久bootstrap输出执行真实无游戏独立私有build，来源先保存后改目的、六参／有序classpath／原arguments-file／正常及异常和参数／oracle错误传播恢复；适用十入口含binding两路静态归属及原offline／缓存／output／tmp／fresh-reuse／凭据脱敏隔离均保留。静态旧成果不重复、不代动态；旧ARGFILE Check／越过Java11／编译／skip／缺模式不能完成。
- 冲突／停止：沿现有共享Gradle／TestKit／build／fixture／cache与相关输入写运行串行，普通当前冲突／身份／真实退出与完整输出保全条件保留。真实失败、unknown、缺证／覆盖未定或需越界实现纠正即停保存，不承诺通过、不自动重试；不新增矩阵、命令预审、控制器、快照、daemon门槛、短进程实验或根验证重跑。
- 完成／连接（历史合同）：原单-P恢复项若有新完整独立Result completed／足证据并Router完整采用才可能满足G-ISOLATED-GRADLE-PROXY-VALIDATION-RECOVERY；当前不作现行成功等待，不释放或回填该gate。其旧连接仅作历史记录，Neo、V/H的当前共同成功输入、Wave gate／最终合取由A新item替换；Neo其余原前置／未来至多一次／原三次failed、V/H其余十二项／fresh／根入口／独立验收不变，不执行或放行后继。旧VERIFY g1 failed、JUnit已写未编译／零执行／正常缓存副作用及旧Wave完整标准和旧gate不满足永不回填。

作者自检与一次必要不同只读Handler局部独立复核边界见Plan，只涵盖上述单谓词／原标准和历史、真实前置、三直接消费者／对应Wave／最终合取及必要联合等待与四文档互链；不重审全图、不称ready。


## 独立bootstrap未完验证的现行连接

**原argfile恢复准备与局部作者自检历史；当前既有采用结果见下列ARGFILE项，本次不重新实施或放行。** 用户已确认原四项串行范围；原ADD generation1 partial、两源码已写、预检exit1、javac／Check各零启动及无其真实退出码永久保留，[原报告](../../../build/independent-testkit-bootstrap-20261027-g1/report.md)不改。 后续execute-bootstrap-validation-recovery generation1 failed，包装PowerShell exit1、javac真实退出unknown、Check未启动及已有脚本输出按[本次failed报告](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/report.md)保留。现行只增下列ARGFILE恢复叶子与单成员Wave；旧恢复正文与Wave是原合同历史，不再作成功等待。下方原统一代理“未确认／全部未执行／拟新增”按准备时点保留；根代理缓存恢复已通过，不重跑。匹配[Plan策略与作者自检](plan.md#独立bootstrap未完验证策略与作者自检)、[Work](work.md#独立bootstrap-partial后的未完验证维护)、[Context](context.md#独立bootstrap-partial与冲突诊断采用边界)；本文是唯一执行图。

### RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION — 原参数语义的未完编译／Check接续

**当前已采用结果（非本次运行）。** `execute-bootstrap-argfile-validation` generation1 的完整关联 Result 已由Router采用为completed，对应现行bootstrap前置及新gate已采用满足；[实际报告](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/report.md)关联保留的两源码、双JDK原生argfile及当轮新classes，[javac退出码](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/javac.exit.txt)和[原`-ea` Check退出码](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/check.exit.txt)均为`0`，[原Check输出](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/check.stdout.log)为其既定合成检查的`PASS`，并明确`no Gradle build launched`。范围仅为保留源码编译及原合成断言；未建立真实上游保存来源时序、真实六参main／私有Gradle build／代理传播、独立CodeSource实测或外部观察器恢复验证，不替代共同验收。 本次只记录Router既有采用，不新判完成或释放gate。以下原完整谓词、资源／停止规则及后继连接照存，“仅安排／才可能”等为原准备时点，不再授权本项重跑；旧ADD partial／恢复failed／unknown及旧gate不满足不回填。

- 单一谓词：保留两份现存源码，以JDK17原生argfile在另一全新输出根完成实际独立javac及原 `-ea PrivateGradleRunnerCheck`，完整证明Plan原六参／五键三态／错误／连续重读／异常恢复标准。一个新Handler／完整独立Result；参数文件只是本谓词调用纠正，不新增工具成果或重做源码。
- 前置item：无；唯一归属W-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION，无前置Wave gate。原partial、恢复failed及已采用诊断仅为输入，不等旧ADD／旧恢复／旧gate转成功，也不等根恢复、共同VERIFY、V、H或自身gate；原已确认范围与合法即时资源条件仍须满足，独立不表示并跑。
- 调用／写拥有：严格按Plan双argfile边界，以[原javac命令](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/javac-command.json)和[原309项classpath](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/testkit-classpath.txt)为来源；单个分号连接的-cp参数及原顺序、JDK、cwd、UTF-8、两源码／Check语义不变，仅输出重定位。javac与Check java均用原生 `@argfile`，正确转义引号／路径，短命令行传入一个@文件实参，不通配符／重建依赖／拆classpath；Check运行classpath为本轮classes在前接原309项。只写本项全新build根的args、classes、原合成check目录及必要命令／日志／报告；旧根仅读，不原样重跑旧脚本、不覆写旧输出，不改源码／工具／配置／依赖／缓存／Spec／Git。
- 证据／验收：实际参数文件／调用、两源码及本轮classes／加载来源、JDK／有序编译运行classpath、完整输出与各真实数值退出码关联；仅javac实际exit0后运行原Check，实际 `-ea` Check exit0及原全部断言成立才满足。Plan完整六参来源链、UTF-8有序列表／完整单参数、HTTP／HTTPS四键与bypass非空／缺失／空、空host／port、无文件／无键、Properties转义／凭据排除、缺来源／读取解析错误／未决覆盖停止、A→B→删键→删文件、异常原身份／finally恢复及同JVM随后未配置全部保留。包装PowerShell退出、只写文件／编译、旧PASS或诊断completed均不替代该完整Result；披露未到达集合，不代共同真实小build／传播。
- 资源／停止：复用旧恢复已核实际输入／classes及合成根输出拥有、普通相关冲突检查和共享编译／Gradle／TestKit／build写串行；原Check配置真实GradleRunner但替代Invocation不调用build，错误五参main在build前失败。任意daemon存在／默认日志缺失不独立阻断，不宣称空闲、不重查daemon或根恢复；真实相关unknown／输入变动／实际冲突／启动异常／编译或断言失败即停保全。必要参数构造不加预写命令审核、控制器、自证、短进程实验、预热或额外检查，不顺手修源码／扩矩阵。
- 完成／后继：仅本项新完整独立Result completed／足证据且Router完整采用后，才可能满足G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。旧ADD partial、旧恢复failed及两个旧gate不满足永不回填；共同VERIFY及V/H仅直接bootstrap输入／Wave gate／最终合取换接本项，其它根恢复／共同传播／十二项／fresh／独立验收条件均不减。

新叶子无item／Wave前置，不向任何消费者反向等待；新增Wave也不等待旧failed或自身gate。必要局部独立复核只覆盖本增量及直接连接，作者自检不构成独立复核、执行、调度或gate释放。
### RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION — 保留源码的未完独立编译与聚焦Check

**历史generation1 failed：execute-bootstrap-validation-recovery已终止；包装PowerShell exit1，javac真实退出unknown、Check未启动。以下原完整合同保留，不回填、不等待其或旧gate转成功；现行接续只由上方ARGFILE恢复承担。**

- 单一谓词：保留现存bootstrap／Check源码，在全新证据根完成实际独立javac及原最小 `-ea` Check，证明原ADD六参来源链、五键读取／三态／投影、全部错误／连续重读／异常恢复标准；一个新Handler／完整独立Result。不重做已写源码，不代共同真实传播或小build。
- 前置item：无；唯一归属W-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION，无前置Wave gate。原partial和诊断仅为输入，不等待旧ADD／旧gate转成功、根恢复／Neo／共同VERIFY／V／H或自身gate；仍须原已确认范围、合法即时资源条件，独立不表示并跑。
- 写／运行拥有：仅本项另一全新build证据根的classes、原Check合成source-home／destination-home／project、plugin目录／classpath与arguments列表、必要命令／日志／报告。两现存源码、JDK／有序TestKit编译及运行classpath、Gradle安装只读；不改源码／工具／用户配置／缓存／旧classes或报告／Git，不新建根依赖／模块／解析器。实施者可依既定JDK与classpath构造必要命令，未预写argv不成为文档前置。
- 证据／未完谓词：两源码身份与本轮新classes／实际加载、真实javac成功和原Check实际 `-ea` 成功及两者数值退出码关联；六参顺序、改目的home前保存来源、UTF-8逐行有序classpath／完整单args、HTTP／HTTPS四键与bypass非空／缺失／空、空host／port、无文件／无键、Properties转义／凭据排除、缺来源／读取解析错误／未决显式覆盖停止、A→B→删键→删文件、异常身份／finally恢复及同JVM随后未配置全部按Plan原标准。不把仅编译或旧PASS串当通过；完整恢复Result关联保留源码／旧partial与实际检查，说明未执行和覆盖限制。
- 资源／冲突／停止：原Check实例化／配置真实GradleRunner，替代Invocation不调用build；唯一错误五参main在build前失败。判断实际输入稳定性、新classes／合成根及并发写拥有；任意daemon存在或默认日志缺失不证明冲突，也不证明空闲，不追查daemon历史。共享编译／Gradle／TestKit／build写运行及入口内容变更仍串行；相关unknown、真实失败、实际冲突或越权需求即停保全，不增加矩阵／控制器／自证／预热，不顺手修源码。
- 完成／后继：只有本恢复完整独立Result completed／足证据且被Router完整采用，才可能满足G-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION；原ADD partial及G-INDEPENDENT-TESTKIT-BOOTSTRAP未满足保留、不回填。共同VERIFY-ISOLATED-GRADLE-PROXY、V=VERIFY-RECOVERY、H=REVIEW-ACCEPTANCE仅在直接bootstrap输入处消费本新Result／gate，原其它item、Wave前置、共同真实小build／三模式、十二项／fresh和独立验收不减。

历史说明：前次新增叶子无item／Wave前置，三消费者当时只替换bootstrap输入；该次执行现已failed。现行三消费者只改接ARGFILE新叶子，历史ADD、旧恢复及各原Wave／gate完整合同保留，不成功等待或自动释放旧gate。本次作者自检仅覆盖增量联合等待与必要连接，不重审全图，不执行恢复、独立复核、选择后继或释放gate。


## 缺失配置输入恢复的现行连接

**本次仅对账既有采用结果。** 当前单次直接Gradle调用已完成并由Router采用，详见下列CACHE-RESTORE-REMAINDER项；本次只维护文档及局部作者自检，不重跑、派发或释放gate。旧controller `exit0/outputDrained=false`、collect1、stored而非restored、第二次零启动和原failed保留，不作为新成功。匹配[Work](work.md#缺失gradleproperties输入恢复的当前边界)、[Context](context.md#xml恢复失败采用与缺失输入恢复边界)、[Plan](plan.md#首次d外层输出例外与唯一剩余恢复)。

### RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER — 仅剩原第二次缓存恢复

**当前已采用结果（非本次运行）。** `execute-cache-restore-new-log` generation1 的完整关联 Result 已由Router采用为completed，对应现行根前置及新gate已采用满足；[实际报告](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/report.md)记录恰好一次直接Gradle调用、无重试，[数值退出码](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/exit-code.txt)为`0`，[当轮日志](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/gradle.log)第15／402行分别为`Reusing configuration cache.`／`Configuration cache entry reused.`。第393行Test为`UP-TO-DATE`，只证明该次配置缓存复用及真实exit0，不计作新Test执行，也不证明恢复后Test动作重新执行。 本次只记录Router既有采用，不新判完成或释放gate。以下原单次调用谓词、稳定输入／停止规则及依赖边照存，不再授权重跑；旧失败／unknown／收据及外层controller风险不改判。

- 单一终态：复用已修声明与首次D实际业务/Test/JUnit1/0/0/0、来源/五键缺失等已证输入，只执行一次直接Gradle调用；本轮日志明确configuration cache restored/reused且Gradle真实exit0，形成一个独立Result。该新Handler/独立Result已执行并由Router采用，事实及限定范围见本项当前记录；不重修源码或重跑本项、首次D/A/B/C/E。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER，无前置Wave gate。调用前只做普通共享构建冲突检查，确认版本/JDK/cwd/隔离home、源码、来源缺失及缓存键相关init/observer/cases路径内容未被改变；不追查历史daemon身份或固定PID。
- 运行边界：完整来源为[首次D invocation](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)；按[Plan当前安排](plan.md#首次d外层输出例外与唯一剩余恢复)用PowerShell数组直接调用其中实际executable和逐项arguments，cwd同为`E:/Projects/cloche/minecraft-codev`。stdout/stderr只写Plan声明的独立新日志位置，不经`collect.ps1`/`run.ps1`，不覆盖历史收据，不改源码/工具/配置/缓存/依赖。保留`--gradle-user-home`、configuration/build cache、offline、init/observer/cases及selector等输入；允许Gradle自行选择或启动daemon，不杀其它进程。调用后立即读取真实Gradle进程的数值`$LASTEXITCODE`。
- 唯一验收：shell读取Gradle进程的数值`$LASTEXITCODE`且为`0`，本轮日志明确出现configuration-cache restored/reused。`stored`、失效重配、仅任务缓存、仅`BUILD SUCCESSFUL`、未知退出或无恢复日志均不通过；Test可UP-TO-DATE，但不声称恢复后动作重新执行。
- 停止：最多一次调用；真实失败、未知、无恢复日志或输入冲突即停，不重试、换daemon、第三次、清禁缓存、依赖下载、历史daemon取证、旧收集器判断或新增协议。
- 完成/后继：上述一次直接调用谓词及稳定输入成立才满足`G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`；旧NEW-DAEMON及更早failed/blocked/partial、旧收据和外层controller风险不回填。共同VERIFY、V/H继续消费同一item/Wave gate，bootstrap、Neo、参数/M及其它验收不因本次裁减删除。

共同VERIFY、V/H只在item前置、Wave gate与最终合取改接本剩余身份；bootstrap独立、十二项/fresh/其它验收不变。局部复核只确认一次直接调用、真实Gradle exit0、日志明确恢复、稳定缓存键输入、历史保留和必要item/Wave连接；不再把两处旧入口判断、controller排空、历史daemon身份或字段收据作为现行门槛。本次只有作者自检，不代独立复核、真实运行、item完成或gate释放。

**以下为NEW-DAEMON实施前的准备历史。** 原item定义/完整合同照存；generation1现为failed，单行与首次业务已完成、第二次零启动。其“未执行/无Result/待修一行/未来两次/首次完整drain”等仅限当时，不再授权重放或作为现行消费者成功等待。

本轮唯一产物为四文档最小安排/作者自检，不执行、派发或放行。匹配[Work](work.md#缺失gradleproperties输入恢复的当前边界)、[Context](context.md#xml恢复失败采用与缺失输入恢复边界)、[Plan](plan.md#缺失配置输入的最小修复与作者自检)。XML恢复generation1 **failed** 已完整采用：A限定关联及B/C/E通过，D动作前真实失败，无worker/JUnit；只有stored/失效重配，无真实restored hit。XML/VALIDATION及更早原item/gate合同和所有failed/partial/unknown保留，下方旧“未执行/零启动”等是原时点文字。

**最新历史与唯一恢复替换：** 已完整JSON解码缺失输入执行generation1，内层 **blocked**：原daemon305908无记录，源码及项目文件零修改、首次D/第二次D各0启动，无新证据根。旧item/Result/原gate不满足及原完成合同保留；本次只将用户接受的新daemon接续条件落实到下列单一恢复替换及必要消费者，不推进实际状态。此前缓存边界独立复核对未变分层方法/入口适配的支持复用，不覆盖本次新daemon条件。

### RECOVER-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON — 新daemon接续未完根恢复

- 单一终态：承接原缺失输入generation1 blocked留下的同一未完根恢复；保留旧A限定关联/B/C/E及已完解析/短检查/编译效果，只纠正缺失来源一行输入声明，并以首次实际Test、第二次真实配置恢复/正常退出及两次同一新daemon建立完整恢复结果。一个新Handler/独立Result；本恢复尚未实施、无Result/完成事实，无独立工具/诊断/传播/消费者成果。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON，无前置Wave gate。旧缺失输入blocked、XML failed及旧A/B/C/E只作为历史/适用性输入，不要求旧item/gate成功，不等自身gate/bootstrap/共同VERIFY/V/H/Neo。原两次D各0启动不改判，未来仍至多两次D，不增加重试或第三次。
- 写/运行拥有：仅承接下方原缺失输入定义及[Plan](plan.md#原d一次恢复及必要缓存验证边界未来安排)的一行 `inputs.file(testProxyPropertiesFile).optional()` → `inputs.files(testProxyPropertiesFile)`、另一新build根中必要现有入口定位/收据/报告及正常缓存输出；文件集合缺失/创建/删除/内容跟踪、五键/来源/Properties/动作均不变。首次前必要入口适配仍仅分层判定及本次首次实例获取/第二次核对，不扩工具/检查/调用/参数协议。首轮完整成功/退出/drain后整体移存本轮runs/D为runs/D-first并保全state，第二次同一入口/固定槽，不改init/observer/cases缓存键路径内容；不动旧证据或项目Test/缓存输出。
- daemon边界：允许原Gradle调用正常启动新daemon。首次启动前只保留现有Gradle9.4.0/JDK/cwd/隔离home/缓存/输入适用性及共享排他核对，不要求原305908仍在，也不索取尚未生成的新实例身份/idle或另跑调用预启。首次正常启动后由现有身份/日志收据关联真实PID、创建时间、parent、executable、完整argv、版本/JDK/home及本轮输出；第二次紧邻启动重核同一完整实例/idle/排他，实际输出再次关联。不以仅PID/历史idle代证；关联不能取得、新unknown/冲突/缺证即停，不启动后轮、不清理或终止其它进程、不再换daemon重试。
- 历史复用：旧A/B/C/E仅保留原版本/输入范围真实成功及当时305908关联，不再要求与新D同daemon；沿Plan核对单行差异/未变映射动作载荷、版本/JDK/cwd/home/参数与来源输入适用性，不能关联即停，不因换daemon重跑或重新下载准备。旧A controller1/drained/限定替代、XML failed/D1、VALIDATION partial、缺失输入blocked/零项目写入/两次D各零启动及所有旧gate均不回填。
- 两次D与停止：原selector/参数/offline/cache和来源不存在保持，首次实际Test/新worker/当轮JUnit1/0/0/0、五键全缺失/无sentinel凭据、执行期原观察/清除重读及client0/controller0/完整输出/两层双流drain全部原义务通过并保全，才允许第二次同输入/同新实例D。首次失败/unknown/缺证即停；第二次仅以本轮真实configuration-cache restored hit、client0/controller0、完整输出/两层双流drain及同实例关联验收，允许Test UP-TO-DATE，不算新Test、不索取或虚构新worker/JUnit/执行期观察，不拿首轮材料代第二次证据。stored/失效重配/discarded不代hit；无hit/退出异常/unknown/收束缺证不通过，第二次结束即停，不自动第三次/rerun-tasks/禁清缓存/整组重跑。此例外不放宽Spec实际Test或V/H自身fresh等其它验收。
- 完成/后继：一行纠正/跟踪∧旧A限定关联及B/C/E跨版本/输入环境有据适用∧首次D全部原实际Test及正常退出/收束∧第二次真实restored hit、client0/controller0及完整输出/两层双流drain∧两次缓存键稳定/首轮保全∧两次新D同一新daemon真实关联全成立，且新独立Result completed/足证据被Router完整采用，才可满足G-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON。partial/failed/blocked/unknown均不放行；新成功不自动满足旧item/旧gate，不伪造历史跨轮同daemon连续性。所有根配置/共享Gradle/TestKit/build/fixture/cache写运行仍串行，bootstrap独立无根成功前置。

共同VERIFY-ISOLATED-GRADLE-PROXY、V=VERIFY-RECOVERY、H=REVIEW-ACCEPTANCE的item前置与所属Wave gate两层仅替换为本新恢复身份/新gate，最终合取同一谓词；其它前置/完整验收不减，不要求旧blocked转成功。局部作者自检及供独立复核范围仅新daemon边界、首次实例获取/第二次同实例、历史复用/blocked及必要新旧连接；不重审已通过的分层/入口方法/解析动作顺序或全图，不宣称ready、不实施/派发/释放gate。

### RECOVER-ROOT-TEST-PROXY-MISSING-INPUT — 缺失来源输入声明与未完根验证

**历史定义（generation1现已blocked）：** 原daemon305908无记录时按原边界停止；源码/所有项目文件零修改，两次D各0启动，新证据根未创建。下列“未执行/无新Result/同一item/原daemon”等仅保留执行前定义和原完成合同，不再授权旧实例接续；新恢复不回填本Result或旧gate，当前消费者仅接上方NEW-DAEMON。

- 单一终态：保留A限定关联/B/C/E及已完解析/短检查/编译效果，只纠正缺失来源输入声明并按首次实际Test、第二次配置恢复/正常退出的分层谓词建立根恢复结果；一个新Handler/独立Result，不含独立工具产品/共同传播/消费者。该item未执行，无新Result；文档完成不是实际完成。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY-MISSING-INPUT，无前置Wave gate。已采用的XML failed及A/B/C/E原材料为恢复输入，不要求旧failed/partial成功、不等自身gate/bootstrap/共同VERIFY/V/H/Neo。单行修复/一次D/复用已有局部独立支持；用户现明确接受两次D分层：首次全部原实际Test义务通过且正常退出/收束保全后才第二次，第二次仅真实恢复及正常退出/输出收束，允许Test为UP-TO-DATE，不算新Test执行；之后停止。此为新接受的限定验收调整，不追认完整ready/运行通过；仍同一item/Handler/Result，无新检查项或轮次。
- 写/运行拥有：未来仍仅根build.gradle.kts中 `inputs.file(testProxyPropertiesFile).optional()` → `inputs.files(testProxyPropertiesFile)` 一行；另一新build证据根的必要现有入口一次性定位、D前序E定位、现成收据/报告及正常缓存输出。固定同一路径文件集合保留不存在/创建/删除/内容快照，不按exists过滤。仅允许在首次前对现有入口作Plan第1款所需的局部分层判定适配，首次原实际Test检查不减、第二次不索取新worker/JUnit/执行期观察，不全局放宽、不扩收集器/框架或输出协议。首轮全部收束后仅将本轮新根 `runs/D` 整体移存 `runs/D-first` 并保全首轮state收据，第二次仍用原固定D槽；具体旧路径→移存路径在报告说明，不改原收据或旧证据。五键/来源File/Properties/动作/执行期清除重读、JUnit/十runner/生产/用户配置/独立bootstrap只读；不重修CDATA、round.json.client。
- 复用证据：旧A/B/C/E实际成功与原同daemon关联保持原版本，依Plan所述唯一声明差异及未变映射/动作/载荷/环境确定适用；新根脚本/派生类不能伪称旧字节未变。其它实际漂移报告具体失效范围，不一律作废或重跑。原A controller1/drained/stop及限定替代、XML failed/D1/VALIDATION partial和全部旧gate不回填。
- 仅获准的执行边界：沿已工作的XML/InnerText入口和既有收集接点，首次前一次性定位新根副本/固定init/observer/cases路径与D的原成功E只读前序；两次均同一 `collect.ps1 -Stage round -CaseId D`。保持来源不存在、原selector/参数/offline/缓存；首次D全部通过且两层真实退出/drain、材料已移存保全，才至多额外一次同D，不是失败重试。外层严格消费首轮成功收据，不能以run仍读E豁免该条件。两次间构建脚本、来源缺失、argv/cwd/home/JDK/原daemon及所有缓存键路径内容/相关环境不变，不改init换输出根。不重跑A/B/C/E/短检查/help/独立编译准备或扩矩阵；每次即时核对原daemon305908完整实例/idle/排他及版本/身份适用性。同daemon关联失败、新失败/unknown/冲突/缺证即停，不换daemon重放、自动再试或杀共享daemon。
- 两次D分层证据：首次来源不存在且越过输入校验，实际Test/新worker/当轮JUnit1/0/0/0、五键全缺失/无sentinel或凭据、seed→桥接→observe→worker/执行期清除重读、同轮来源/缓存/身份、client0/controller0及两层双流drain/完整输出全部原义务通过；UP-TO-DATE/FROM-CACHE/NO-SOURCE/SKIPPED或旧E/XML不能替代。首次失败/unknown/缺证即停，不启动第二次。第二次只需本轮真实configuration-cache restored hit及client0/controller0、完整输出/两层双流drain和身份关联；Test可UP-TO-DATE，不算新Test执行，不要求或虚构新worker/JUnit/执行期观察，不将首轮材料充作本轮恢复/退出证据。失败和未到达集合如实保存。
- 缓存验收与限定保证：stored、失效重配、真实restored hit分列，首轮stored不代第二次hit。原入口对第二次仍要求新JUnit/动作链的冲突，按本次用户已接受的分层谓词作必要局部适配；不保证或声称证明缓存命中后Test动作重新执行，不将此例外扩到其它场景/实际Test的Spec重新计算与无残留合同。无真实hit、异常退出/unknown或输出收束缺证即停止，局部效果保留为partial/实际失败，gate不满足；第二次结束后无论结果如何停止，不自动第三次、rerun-tasks、清禁缓存、删Test输出或扩工具。
- 完成/后继：仅当一行纠正及输入跟踪∧A限定关联/B/C/E有据适用∧首次D全部原实际Test证据及正常退出/收束∧第二次真实restored hit、client0/controller0及完整输出/两层双流drain∧两次缓存输入稳定/首轮不覆盖保全∧跨版本/同daemon关联全成立，且独立Result completed/足证据被Router完整采用，才满足自己的gate。第二次不再要求新worker/JUnit/执行期重读，也不据UP-TO-DATE声称这些已发生；该轮限定配置恢复及正常退出不代其它实际Test场景的映射义务。partial/failed/blocked/unknown均不放行共同VERIFY/V/H；不把旧五轮改写成新版本实跑，不放宽V最终fresh/H独立核对。所有根配置/共享Gradle/TestKit/build/fixture/cache写运行串行；bootstrap仍无根成功前置。

共同VERIFY-ISOLATED-GRADLE-PROXY、V=VERIFY-RECOVERY、H=REVIEW-ACCEPTANCE的item显式前置与所属Wave gate两层仍只消费本恢复同一分层根身份；各自bootstrap/传播/十二项/fresh/原验收不变。旧XML不回成功等待、不释放旧gate。必要局部复核限本次分层授权/谓词、入口验收适配边界、缓存键稳定与首轮保全、本item/单成员Wave/gate及上述必要连接；单行修复/旧成功复用已有局部支持，不重审全图、CDATA或观察顺序。本作者仅自检，不执行独立复核/实施、推进状态或释放gate。

## 根代理检查恢复的现行连接

**历史准备记录（XML恢复generation1现已failed）。** 以下现行/未执行/四轮零启动等仅保留当时；最新采用事实、缺失输入修正及后继连接以上方缺失输入恢复节为准，原完成合同及失败不改判。

本轮仅四文档维护/作者自检，不派发、不实施、不运行或释放gate。匹配[Work](work.md#根代理检查恢复的当前边界)、[Context](context.md#根代理检查恢复的采用事实与证据边界)、[Plan](plan.md#根代理检查恢复的执行计划与作者自检)。原VALIDATION generation1已partial：短检查成功、A底层成功但controller1/drained，B/C/E/D零启动。更早WIRE/CHECK/REPAIR failed、编译成功/历史unknown及各旧gate不满足保留，不回填；历史idle不代未来即时核对。

### RECOVER-ROOT-TEST-PROXY-CHECK-XML-RECOVERY — CDATA限定恢复与剩余四轮接续

**generation1已failed：A限定关联/B/C/E通过，D动作前输入校验失败，真实hit未证，旧gate不满足。** 以下单一终态/未执行/写拥有及完成合同仅保留原执行前定义，不再授权续跑或重放；现行后继消费新缺失输入恢复。

- 单一终态：复用已修源码/编译、成功短检查及本次VALIDATION的A原始底层效果，新根CDATA一行纠正/既存XML聚焦检查/只读A关联后，仅接续B→C删键→E无键→D删文件，按用户已接受的A限定证据替代修订后的五轮合取成立。一个Handler/独立Result；当前未执行、无Result、gate未满足。内部恢复/检查无独立消费者，不重跑A或短检查，不新增轮次/工具产品。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY-CHECK-XML-RECOVERY，无前置Wave gate。完整读取采用的VALIDATION partial及只读恢复completed结论、旧原始材料、编译/短检查成功为输入，不等旧item/gate转成功、自己gate、bootstrap/共同验证/Neo或后继；只读评估completed不代恢复完成。
- 写/运行拥有：未来仅另一新build证据根内必要collect/run副本、固定cases/observer输出路径和恢复关联/四轮输出，按原方案改变既存source-home合成来源/正常缓存。新控制器副本只把system-out正文读取一行改为InnerText，用既存A XML检查worker273156/id1；必要前序证据定位/新输出路径接续不扩为工具重写。根源码/工具/用户配置/旧根只读，不重编译、help、依赖准备/下载或框架化。
- B的限定前置（用户已明确接受仅A证据替代）：显式消费Context列出的完整A client/controller completion、stop、JUnit、stdout/stderr、seed/observation、invocation/identity/preflight与关联日志，以及只读恢复结论。必须核对A client0/drained、controller1/drained且唯一失败为XmlElement/CDATA误读、真实Test1/0/0/0、五键/worker/顺序/stored无拒绝同轮闭合；聚焦InnerText提取与原stdout一致才可接续。Assert-Complete的数值exit/drain不等于成功；不能只凭client0或诊断摘要放行，也不机械等旧controller0。原1/stop永久保留，不造0、不称A collection-level通过；本条与下条完整原始关联复核成立才替代A原成功收集的controller exit0且drained条件，不是该条件逐字不变。新入口首轮B读旧A原路径，C/E/D读本次真实前轮。
- A未写出的cache-events/daemon副本/postflight/source-identity/association不视为已存在；只在新根从现存完整原始材料只读恢复必要关联，标明原/恢复时点，不补旧收据或伪造当时postflight。源码/实际加载/输入适用性等缺证不能用来源文件SHA代证；必要关联不完整或超出已接受A替代即停止报告；不补造历史快照、不豁免业务/实际运行要求。
- 原完整证据/同版同daemon：Gradle9.4.0、原JDK/cwd/同隔离home、offline及原允许configuration/build cache、精确selector、固定A/B/C/E/D和五键/三态/凭据排除/seed→桥接→observe→worker不变。A锚定daemon305908的创建时间/executable/argv/home/日志，每轮写来源前及紧邻启动即时核对同一实例/当前idle/共享排他及同版内容，实际输出再关联；仅PID或历史idle不足，新daemon/关联不成即停，不重跑A另开序列。每轮实际Test/JUnit/worker/来源/缓存完整，A原数值1与0/drain保留，余四轮各client0/controller0和各自双流drain均必需；stored/restored hit/失效重配/discarded分列，任务缓存/skip或失效重配不代原执行/命中标准。
- 收集/冲突/停止：沿Plan有界单轮控制器/真实数值exit/持续双流独立落盘/EOF-error-drain/截止前自有树收束；前轮保存且收束后才下一轮。仅A这一个已证解析失败可按限定恢复消费，新的失败/unknown/冲突/缺证停止，不一般忽略controller错误/自动重试，不禁清缓存、rerun-tasks、增轮或杀共享daemon。所有共享Gradle/TestKit/build/fixture/cache及根行为写运行串行，新根不消除冲突。
- 完成/后继：新完整Result completed/足证据且Router完整采用后才可满足自己的gate；按Plan修订谓词，A全部业务/实际运行义务∧A限定替代复核∧B∧C∧E∧D全部原义务∧同版同daemon/收集关联全需；A复核只替代该轮原成功收集条件，余四轮各client0/controller0、输出完整/drain和原检查全需。共同验证及V/H在item和Wave gate两层改接新结果，仍各自等待bootstrap/传播/其它完整合取；bootstrap无根成功前置。新成功不回填VALIDATION partial或更早失败/unknown/旧gate，不代共同三模式/独立build/Neo。局部独立复核范围见Plan，作者不派发/判ready/放行。

### RECOVER-ROOT-TEST-PROXY-CHECK-VALIDATION — 保留编译后的完整剩余根验证（历史partial）

**generation1已partial，不强求旧Result变completed、不回填旧gate。** [原报告](../../../build/recover-root-test-proxy-check-validation-20261026-g1/report.md)保留入口收集调整、一次非项目exit7短检查成功、A client0/drained及JUnit1/0/0/0、controller1/drained和CDATA误报stop、B/C/E/D零启动。以下原完整定义/成员/完成合同按执行前时点保留，其中“当前未执行/未运行检查”仅指当时；不重新授权短检查/A/五轮重放，现行后继仅消费新XML恢复。

- 单一终态：已修根动作/编译成功不重做，必要收集入口局部修正及最小非项目短进程检查后，原A→B→C删键→E无键→D删文件五轮完整根验证成立。一个Handler/Result，当前未执行、无Result；内部收集检查无独立消费者/工具产品，不拆成另一个公共交付。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY-CHECK-VALIDATION，无前置Wave gate。已采用的REPAIR failed/编译成功及用户历史unknown例外是恢复输入，不是旧gate成功前置；不等自身gate、bootstrap、共同验证、Neo或业务消费者。
- 写/运行拥有：仅另一新build证据根内必要外层收集入口副本、薄控制器、固定合成cases/observer新输出路径及本轮运行材料；按原五轮改变已准备source-home的合成来源，正常配置/缓存可复用。根build.gradle.kts及其它源码/工具/配置/用户home/旧封存证据只读，不重修源码、重复help/编译/下载/准备依赖。复用[已采用编译](../../../build/recover-root-test-proxy-check-repair-20261026-g1/runs/compile/completion.json)和[字段终态](../../../build/recover-root-test-proxy-check-repair-20261026-g1/compile-terminal.json)；新入口显式消费用户例外/证据，不能改旧stop或只因旧exit0自动继续。
- 必要内部收集方法：按Plan逐次保存启动身份、持续双流文件，有限轮询Process真实退出并先单独保存数值exit；stdout/stderr各自完成/EOF-error/flush-close单独落盘，最后才合取，不把所有收据放在最后阻塞等待后。每个控制器只承载一轮，客户端和控制器均要真实exit/双路drain；截止前有界收束只认领自有树并保全，不能无限WaitForExit/GetResult或误杀共享daemon。先以同一接点做一个非项目双流标记/预设exit7短控制器检查（限15秒/留5秒收束保存）；它仅证明收集接点，不证明原超时根因消失、不修复历史unknown。检查失败则A不启动，当前未运行此检查。
- 原证据合同不减：同版Gradle9.4.0、原JDK/cwd/同一隔离home、同一新序列daemon、offline及原允许configuration/build cache；精确 `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments'`，仅原五轮。固定A非空/B变值含空/C删键/E无键/D删文件、五键完整key-set/精确值/凭据排除、seed→原桥接警告→observe→worker不变。每轮关联来源存在性/摘要、实际Test/五键、worker/JUnit1/0/0/0、客户端/控制器真实数值exit/各自双流排空及daemon/缓存事件，前轮完整保存/收束后才下一轮；任务UP-TO-DATE/FROM-CACHE/NO-SOURCE/SKIPPED或旧A/help stored不代证。
- 缓存/停止/冲突：每轮即时排他，存活daemon按当前日志和完整身份判断，不沿历史idle；stored、真实restored hit、输入变化失效重配、discarded分类，不能失效重配冒称命中。不禁缓存、清缓存、rerun-tasks或增轮补证。仅这次已接受控制器历史unknown例外；任何新相关unknown/失败/冲突/序列化拒绝/身份-输出-worker-缓存缺证停止，保全可得材料，不杀他人、不一般重试。所有共享Gradle/TestKit/build/fixture/cache及根行为写运行串行，即使不同新根亦然。
- 完成/后继：新完整Result completed/足证据且Router完整采用才可满足新gate；共同验证与V/H在item和Wave两层改接它，仍各自完整消费bootstrap/传播/最终合取。独立bootstrap无根成功前置；内部短检查/局部根五轮不代共同三模式、独立build或Neo，不扩大本项实施。任何新成功不回填旧WIRE/CHECK/REPAIR的failed/unknown或旧gate。

### RECOVER-ROOT-TEST-PROXY-CHECK（历史 failed）

- 旧结果已完成依赖准备并只实际到达 A：JUnit 1/0/0/0，但根 Gradle 客户端真实 exit 1；configuration cache 因根 `build.gradle.kts:95–100` 脚本级 `doFirst` 捕获脚本对象而拒绝序列化。B、删键、无键、删文件未启动。该 item、旧证据和旧 gate 保留，不转成功，不作为新版输入之外的验证证据。

### RECOVER-ROOT-TEST-PROXY-CHECK-REPAIR（历史 failed）

**已采用历史：** generation1 failed；根动作已修，静态及真实编译/字段检查成功，客户端310304真实exit0/双路输出排空。控制器273340真实exit、未保存输出/最终drain及工具终止影响unknown；新版五轮selector零启动。下列原完成合同/写拥有只保留历史，不再授权重修源码/编译准备、不再作为现行成功等待，旧gate不满足且不回填。

- 单一结果：仅修正根执行动作的脚本捕获/配置缓存序列化兼容性，并重新取得原根 Test 的实际映射、`A → B → 删键 → 无键 → 删文件` 变化删除无残留、错误与凭据排除、十个实际入口归属、真实 Test/worker/JUnit 及客户端数值 exit 证据。五键、来源、Properties、清除/重读、冲突、输入跟踪和既有测试行为不变；旧 A 不代新版 A。准备依赖复用仓内旧 `build/recover-root-test-proxy-check-20261026-g1/source-home`，新版运行材料另存，不产生公共工具或诊断产品。
- 前置 item：无；唯一归属 `W-ROOT-TEST-PROXY-CHECK-REPAIR`，无前置 Wave gate。不等待旧 failed、独立 bootstrap、Neo 或任何业务消费者成功；旧准备 daemon 不冒充新版 daemon。
- 写/运行边界：后续只允许根 `build.gradle.kts` 的代理执行动作改为不捕获脚本/Project/Gradle/配置回调/其它 Task、仅保存来源 `File` 与普通数据的独立可序列化动作；不得改五键语义、读取来源、Properties、冲突提示、清除/重读、输入跟踪或测试行为。新版固定同版 Gradle 9.4.0、同一新序列 daemon、同一隔离 home、原允许缓存和现有无网络纯参数 Test `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments'`，不新增测试载荷、不调用游戏下载 fixture、不用 `--no-daemon`、永久禁缓存、清缓存或 `--rerun-tasks`。五轮串行：A（五键非空）→B（五键均存在但值改变并保留空值态）→删键（保留文件、移除既定键）→无键（空文件）→删文件（文件不存在）。每轮先完成前轮真实退出、报告/输出封存、身份和 EOF/drain 收束。
- 证据与停止：每轮保存配置存在性/字节摘要→实际 Test 五键完整 key-set/精确值观察→task outcome/JUnit/XML与worker→外层客户端真实数值 exit→新 daemon及配置/构建缓存事件的同轮关联，并保存完整 stdout/stderr、命令/cwd/JDK/home和共享写串行。配置缓存 stored、真实 restored hit、输入变化导致的失效重配和 discarded/serialization error 分别记录，不把失效重配或 daemon结束冒充恢复/执行。失败、unknown、冲突、序列化拒绝、观察/worker/身份/退出或缓存关联缺证时停止后续启动并保全材料；不无限重试、不杀他人进程。配置期快照不足不并入独立 nested 三模式或 Neo 验收。Result 完整且 Router 采用后，才可作为共同验证的根输入。

### 现行代理连接修正

**历史XML恢复准备连接，已由页首缺失输入恢复及表内新gate取代。** 以下原合取/等待按当时保留，不再要求XML failed成功；最新A/B/C/E/D状态以上节为准。

共同VERIFY-ISOLATED-GRADLE-PROXY改等RECOVER-ROOT-TEST-PROXY-CHECK-XML-RECOVERY及独立ADD-INDEPENDENT-TESTKIT-BOOTSTRAP两个完整结果/新gate；V/H的item显式前置、所属Wave等待及最终合取第1/10款消费新恢复身份及其A限定替代；除该单轮成功收集证据条件修订外，其它合同不减。旧CHECK/REPAIR成功等待撤出，旧定义/成员/gate/失败事实保留不释放；bootstrap仍无根成功前置。必要局部复核只覆盖本恢复收集方法、历史例外/写拥有/单终态及这些连接，不重审已支持的观察顺序或扩到bootstrap/共同传播/Neo实施。 原VALIDATION partial/短检查成功/A局部成功但controller1及旧gate完整合同保留，不再成功等待；新恢复消费完整旧A/只读结论，仅接续四轮，完成谓词统一为A业务/实际运行义务∧A限定替代复核∧B∧C∧E∧D全部原义务∧同版同daemon/收集关联，不把A原成功收集条件写成未变。

## 统一隔离Gradle测试代理的现行连接


**未确认实施的准备图，不派发、不运行、不释放。** [Spec](../../spec/isolated-gradle-test-proxy.md)只读；[Plan](plan.md#统一隔离gradle测试代理的实施准备与作者自检)拥有文件/签名/检查/风险；[Work](work.md#统一隔离gradle测试代理的当前准备边界)与[Context](context.md#统一代理已接受范围与第三次neo失败)保留采用事实。本文是唯一执行图。根Test桥接与同worker可见、独立持久入口/javac形态已接受，不等于具体实施范围已确认。下列新增项全部未执行、无Result、无gate满足事实；旧仅运行许可不得用来启动新范围。

根桥接与独立bootstrap具有可独立保留/失败/恢复的成果，必须分Result；必要映射/编译检查留在各自项内。共同传播/隔离及完整T-Neo分别有独立实跑终态，不因落盘或局部代理通过被合并。新增四个单成员Wave在下方唯一表中定义，item前置和所属Wave前置gate须**同时**满足，显示顺序不制造依赖。

### WIRE-ROOT-TEST-PROXY — 根Test实际桥接

- 单一谓词：现行五模块十个实际nested源码入口共用的根Test配置已按Spec正确读取实际来源、三态五键投影、失败/无残留，内部实际映射检查成立；不冒充nested传播或Neo完成。一个Handler/Result。
- 前置item：无；唯一归属W-ROOT-TEST-PROXY，无前置Wave gate。仍需新范围确认和合法即时写/运行条件，不等待旧Neo或bootstrap成功。
- 写拥有：仅根build.gradle.kts及本项新build证据根的必要薄init检查/合成来源与运行材料；不写十runner/模块依赖/JDK/用户配置/旧build脚本。
- 证据：Plan实际根Test对象检查覆盖五键三态/bypass/转义/错误/凭据排除，来源A→B→删键→删文件在同外层daemon及原配置缓存/复用下无旧投影；十入口静态共同归属。真实执行记录及脱敏结果可关联，不用平行解析器或永久禁缓存自证；不需要全部历史用例重跑。
- 冲突/停止：根行为配置及所有共享Gradle/TestKit/build/cache/fixture写运行串行，按最新内容。缺来源/读取解析错误/显式覆盖未决/unknown/越权需求停止；不合成默认、不静默直连降级。仅本谓词成功保留，不自动满足共同验证或T-Neo。

### ADD-INDEPENDENT-TESTKIT-BOOTSTRAP — 独立启动共同入口

**历史generation1 partial：两源码已写、预检exit1，javac／Check各零启动；原完整合同如下保留，G-INDEPENDENT-TESTKIT-BOOTSTRAP仍未满足，不再作为现行成功等待；只由页首独立恢复接续未完验证，不回填或释放本旧gate。**

- 单一谓词：持久独立bootstrap的六参来源链及五键读取/本JVM投影/异常恢复正确，实际独立编译和聚焦断言完成；不宣称真实私有build传播或未来全部调用已接好。一个Handler/Result。
- 前置item：无；唯一归属W-INDEPENDENT-TESTKIT-BOOTSTRAP，无前置Wave gate；不等根实现/Neo成功，冲突仍串行且新范围须确认。
- 写拥有：拟新增tools/testkit/PrivateGradleRunner.java与PrivateGradleRunnerCheck.java，以及本项新证据根。沿现有javac/精确有序TestKit classpath，classes归新根，无根test依赖/新模块/插件/buildSrc或分叉bootstrap。
- 证据：按Plan六参签名、实际解析/投影接点合成检查和真实javac/Check退出；覆盖缺来源/读取解析错误、Properties三态/转义/凭据排除、连续调用重读及异常恢复。来源在目的GRADLE_USER_HOME改写前保存；原有序classpath/args和样本oracle归调用者，旧56项/标记不变为公共合同。未来真实小build另由共同验证项完成。
- 冲突/停止：与共同验证对入口/检查的读取及所有共享编译/Gradle/build运行串行；错误真实传播，来源缺失或已有显式覆盖优先关系未定即停。编译/落盘不能冒称全覆盖；不改历史build脚本。

### VERIFY-ISOLATED-GRADLE-PROXY — 共同实际传播与隔离

**历史generation1 failed：实际Gradle exit1，Test/JUnit零执行／无当前XML，新JUnit已写但未经编译；正常缓存写入及全部未到达义务见页首采用事实。以下原item完整合同及原Wave行保留，G-ISOLATED-GRADLE-PROXY不满足、不回填、不作现行成功等待；仅新恢复item承接未完共同验收，不执行或重试本旧item。**

- 单一谓词：同版实际根桥接与bootstrap在三类现用TestKit模式及真实独立私有build中满足Spec传播/恢复/隔离并闭合当前入口归属；一个独立Handler/Result，不代T-Neo。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（各完整采用/completed/足证据）；唯一归属W-ISOLATED-GRADLE-PROXY，等待G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。
- 写拥有：拟新增Forge Java测试IsolatedGradleProxyTests.java（完整路径见Plan）及新build证据根的合成来源/无游戏小工程/薄驱动/本轮bootstrap编译输出/报告；不改两项已完成实现/历史脚本/生产/依赖/原fixture，不新增代理读取器。
- 证据：Plan未来精确类selector实际JUnit全部执行成功/Gradle0；默认TestKit daemon、显式TestKit加私有-g、withDebug(true) embedded的worker→nested五键三态/一致性、home、变化/删除/未配置无残留、embedded成功/异常恢复及原offline/缓存/output/tmp关系。用本轮javac输出执行真实独立私有-home小build，证明保存原来源后才覆写目的环境、同一五键规则、classpath/args与错误传播；十文件含binding两路静态归属无绕过。只记实际采用独立入口，不能预报未来Q已覆盖；未命中/skip/缺模式不成功。无游戏下载/网络探针，不以只编译或另写解析模型代证。
- 冲突/停止：所有共享Gradle/TestKit/build/cache/fixture与根配置/入口内容写入串行，实际读取当前同版实现；失败/unknown/来源覆盖未定/身份退出缺证停止，需实现纠正则报告受影响项，不顺手重做他项成果。证据脱敏，缺凭据支持不称解决。

### RECOVER-FORGE-PATCH-NEO-AFTER-PROXY

**已采用 generation1 failed（历史合同保留）：** 本轮一次/累计第四次、exit1、JUnit1/1/0/0，libraries 缺三个 cpw.mods，prepared/reference 未完成，G-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY 不满足。仅作新 CPW-MODS 恢复的历史输入，不再以本项转成功为等待，以下原边界及消费说明只属旧安排。

- 单一谓词：仅本次不等待完整代理验收，用至多一次原 Neo 方法取得原 T-Neo 全部完整准备，一个同名 generation1 Handler/Result；执行一次或有限三模式通过不代原完整准备，不代 Q-Neo/R。复用本项尚未执行身份，三次旧 PREPARE/名称恢复/仅运行恢复 failed、已完成名称纠正及各旧 gate 不满足均保留。
- 前置item：FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8（已由 Router 采用满足 G-REPAIRS）、RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（后两项及其 gate 已满足，直接复用不重跑）。唯一归属 W-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY，等待 G-REPAIRS、G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION。用户已接受只对本次原测试移除 G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE 及 PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY / VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION 等待；不以有限 THREE-MODES gate 替代完整 gate，不等旧 failed/自身 gate 或 P/Q/R/D/B/M/另两组，V/H 与其它完整消费者不获豁免。
- 唯一调用：原任务/selector、完整有序 argv、JDK/source-home/环境实际来源及新输出重定位见 [Plan 单一参数表](plan.md#neoforge-原测试一次尝试的原入口与参数来源)；原命令为 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache`，不能用三模式 invocation 替代。未来至多一次、累计至多四次，不重置三次旧 failed，不套用 P/basic 次数/时间预算，用户已接受本次范围、不再等待同一决定确认。
- 运行边界：后续运行前只做当前相关共享冲突和输出不覆盖检查，保留必要资源/JDK/实际输入与原私有缓存隔离，采用全新本轮输出。历史 run.ps1 只作原参数来源，不直接重跑旧 daemon/PID/控制检查；不加网络探针、控制器排空、全量 hash 或工具/来源矩阵。本次只准备文档，不做运行时检查。普通构建依赖/下载按原任务处理；不补测试、不改代理/用户配置/源码、不安装、不清缓存或复制整份用户配置、不终止预存进程，不重编译或重跑已通过 root/bootstrap/remapped。
- 冲突/停止：所有共享 Forge/helper/Gradle/TestKit/build/cache/fixture 写运行串行。失败/未知保存实际完整调用/次数、日志、真实退出或未知原因、本轮 XML/产物和未到达边界并停止、不重试；未启动缺权限/JDK/输入/来源/能力为 blocked，已实际失败为 failed，unknown/缺证不成功。三次旧 failed、各旧 gate 不满足和 LSP unknown 保留，旧缓存/XML/归档、编译或 Java21 候选不代真实成功。
- 写拥有：仅新build证据根必要薄入口/脱敏观察/报告及正常私有输出/cache；沿项目Test根桥接，不再改fixture/helper/test/生产/代理实现/用户配置/依赖/JDK/Git/旧证据。
- 原完整成功条件：同轮JUnit1/0/0/0和Gradle0、固定MC1.21/NeoForge21.0.76-beta/NeoForm1.21-20240613.152323、真实provider/实际Java21工具角色/独立official参考/具体类接口资源见证/适用AT-Dist-marker/完整隔离/prepared/最终output及命令/输入/工具/JVM/argv/阶段/任务图/日志/退出收束全关联。完整标准沿原T-Neo，不降级或拼旧轮。按Plan记录实际nested JVM有效代理状态/来源关联与既有Gradle/Core下载阶段；缓存或成功不证明逐请求路由，网络未到达明示未证，不加探针/清缓存/补跑。

**消费连接与最终合取。** Q-Neo在T消费位置仅改接RECOVER-FORGE-PATCH-NEO-AFTER-PROXY / G-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY，另等原完整P；R/V/H显式前置也替换T身份，原Q/R各自内容/冷热缓存/矩阵/同版fresh义务不变。最终G-RECOVERY-INTEGRATION第1/10款在原十二项中只换T-Neo身份，另合取根桥接、独立bootstrap、共同实际验证三个Result及各gate，不与十二项或参数/M混算；G-ACCEPTANCE还须独立核对这些新证据。原三次failed项及其Wave/gate原合同保留历史，不再现行成功等待，新成功绝不回填。

参数与完整M、D/B及1165/P等未变分支不新增Neo/共同代理成功屏障；实际新独立调用须接持久bootstrap并按自身范围核对来源/新classes/原oracle，但不以此自动重开已过结果。新实现使旧证据身份不适用时只报告具体受影响范围，不一律撤销旧通过。作者自检/不同Handler必要局部复核范围见Plan；本次不自行复核、派发或判ready，作者completed仅指文档准备。

## JUnit精简验证的现行连接

### 自动LSP例外与参数启动边界

用户已明确接受本次自动Kotlin LSP Gradle调用的未知退出码及不可见写入影响，保留 `automatic LSP exit/write impact: unknown`；不是exit0、零副作用或已证退出。此例外仅解除这次历史unknown对精简核心参数JUnit的启动阻断，不豁免新的活动冲突、相关身份/实际退出unknown或真实失败；启动前必要排他、输出保全和有界收束仍保留，不以历史采样证明当前空闲。不清理、重置或绕过私有验证链，也不恢复ArgsCheck、AST/Python快照或jdb逐层取证。 本条仅适用于VERIFY-REMAPPED-NESTED-RERUN-REGRESSION启动：不再以[原g1 blocked记录](context.md#自动lsp阻断记录与用户例外)中的这次自动LSP unknown本身阻断后续参数调用；旧blocked及零selector事实不改，新Result必须持续披露风险。前述及参数item一般unknown停止条款受此窄例外限定，其它新冲突/未知/失败仍停止。

参数item/所属Wave的原发现与G-REPAIRS前置、参数合同和同daemon开启后关闭证据不变；完整M仍独立，未获此启动豁免，其真实Java8消费/必要来源不减。两者共享写运行串行、互无成功前置；V/H仍分别等待参数和M及原最终合取。不新增/完成item，不改Wave成员、等待边或释放gate。策略及作者检查见[Plan](plan.md#自动lsp例外的启动边界与作者自检)。

本图匹配[Work](work.md#junit精简验证的现行维护边界)/[Plan](plan.md#junit精简验证策略与作者自检)，事实见[Context](context.md#junit替换决定与最新失败采用)。已明确批准采用现有JUnit和原消费者，不实施；PRD/ADR/Spec reuse、权威写入skip，owner未知不编造。最新RECOVER-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION generation1 failed，actual类型已纠正、新wire.py可空AST类型错误、目标零启动及源码不变已采用；原WIRE/恢复g1和最新failed、旧gate不满足/已写效果保留，不再修或等待私有链成功。

现行只有参数回归及完整M两个独立结果，各一个Handler/Result；二者互无成功前置但共享资源串行。参数只依赖原发现适用及修复，不消费P/Q产物、不新增其直接成功等待；已采用原发现的历史关联前置保留，不要求重跑；M保留完整P、Q-1165、原发现适用及修复，不等参数或旧WIRE，不等Neo/R/D/B。V/H显式等待两者，参数不是第13个完整消费者，原十二项恢复合取、其它分支/同版三模块fresh/根入口不减。没有新接线item或gate，不推进执行状态。

**当前与历史分界。** 以下历轮WIRE/private harness成功等待、ArgsCheck/AST/hash/Capture内部自证、remapped jdb及内部逐层观察和参数→M依赖仅属已撤销准备合同，不再与本节及下列两项/表内现行行/最终补充竞争；原失败和原完成合同保留作历史，不宣称通过。原发现与修复不重开，basic和其它分支未变合同仍有效。去掉外层--debug-jvm但保留TestKit withDebug(true)，每次普通日志/JUnit/结果保存与必要身份/排他/实际退出仍必需；未知/冲突/真实失败停止，无一般重试扩张。

## WIRE恢复g1失败后的现行验证连接

**历史准备记录（已被页首JUnit替换条款取代）。** 保留当时失败、已写效果和原合同；私有接线验证成功等待/内部自证及remapped逐层jdb不再现行，最新验证恢复g1已failed、目标零启动，不能继续按本节修私有链或声称运行通过。

本图匹配[Work](work.md#wire恢复g1失败后的仅未完验证维护)/[Plan](plan.md#wire恢复g1失败后的未完验证策略与作者自检)，已采用事实见[Context](context.md#wire恢复g1失败与已完成输出的采用边界)。RECOVER-REMAPPED-NESTED-RERUN-WIRE generation1为failed，实际证据根g2；源码输出已补、工具未验证、wire.py未创建、静态检查停止后目标零启动。旧WIRE和本次恢复的failed、原合同/旧gate不满足均保留；旧根只读，不续旧项或等待旧failed转成功。本轮只有四文档维护/作者自检，不执行、派发、采样、采用新执行Result或释放gate。

新的验证恢复→独立VERIFY→独立完整M→V/H只替换必要接线成功输入。正式矩阵/同daemon隔离及原M实际Java8编译打包不并入新恢复，有效上游缓存允许，最终十二项合取不减；沿用既有授权和PRD/ADR/Spec reuse，不新增预算、冷重建或未变范围批准。先前独立ready仅保留未变部分，当前差异局部复核见Plan。

### RECOVER-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION — 已写接线的剩余验证

**已采用历史：** generation1已failed，actual注解已纠正、新wire.py真实可空AST类型错误后停止，目标零启动、真实源码不变。以下“未执行/无Result/仅安排”和完成合同保留当时准备含义；本项不再派生现行成功等待、不修私有链、不回填旧gate。

- 单一结果：保持已写源码不变后，原完整WIRE可安全调用/编译/加载/默认关闭及最小启用-basic合同成立；一个新Handler/独立Result，当前仅安排、未执行、无Result。前置items仅ASSESS-REMAPPED-DISCOVERY-EVIDENCE；所属单成员Wave只等G-REMAPPED-DISCOVERY-EVIDENCE和G-REPAIRS。原WIRE和恢复g1的failed仅为已采用恢复输入，不是成功前置；不等旧gate、自己gate、VERIFY/M或额外P/Q成功。
- 写拥有：仅另一全新build证据根的私有run/arguments/compile/ArgsCheck/wire-check及必要wire.py编排副本、正常本轮编译/取证输出；保留g2已写适配，但不冒称它已验证。真实PatchedMinecraftTests.kt（SHA256 `09f100792e150c4b5faf84a4308d2d5472802db752c11e1160ed1565257e32ae`）及g2/此前g1/所有旧根只读。worker PID/id、实际env/缺失值、工程/输入/真实helper argv已经写入，只需关联新class和实际输出，不重复源码补写，不改原接口/分支/三参数/唯一-D/basic/fixture/finally、生产/配置/依赖或公共工具框架；越界需要只报告。
- 最小纠正/编排：只纠正实际记录函数passed的actual参数合同以保留bool/dict/list取证载荷，不强转bool、删比较/断言/失败分支、改oracle或大范围抑制诊断；必要薄编排仅调用本项内部检查、原一次编译/加载及最小行为验证。SQL sink自动告警未判为漏洞；若阻断实际恢复，仅核实arguments.execute实际调用/数据流及受控夹具替换的局部点，不据告警扩修或擅自屏蔽。静态纠正/同版复查是本新恢复的内部动作，不能改写g1当时停止或许可任意实际失败后连续修跑。
- 必需证据：先完成Plan所列受影响实际函数/调用方的分类/AccessDenied与NoSuchProcess拒绝、逐次紧邻spawn完整资源/排他、唯一Capture立即接流和身份/后置慢采样、env副本/异常保全/finally真实退出与EOF无error-drain检查，逐份新字节/输入/夹具与检查适用对应，未变项说明依据，旧8/20/11+1不代新hash。再一次真实compileTestKotlin及harness编译/加载，将已写源码输出与新class/hash相连，核精确Java/javac/stdlib、classes/kotlin/test根和外部classOrigin/harnessOrigin/java.home。独立启用及显式pop默认两个Java进程各核basic/remapped代表输入：remapped开启恰一flag、默认关闭/basic不变、原三参数/唯一完整-D。命令/实际env/身份/exit0/EOF-drain/各轮分存与父环境前后无写回全部闭合；零启动/静态clean/grep不代任何运行成功。
- 完成/后继：仅本新完整Result completed、足证据且Router完整采用才可满足自己的新gate，仅供显式VERIFY和M；正式矩阵、真实worker传播/同daemon隔离由独立VERIFY验收，完整M仍须独立Result及原真实javac8/compileJava/jar/printCompileClasspath、有效缓存来源/输入/产物和同轮完整链。新成功不回填原WIRE或恢复g1/item/gate，本次作者维护不完成其中任一项。
- 停止/冲突：工具或实际检查失败、输入/加载不闭合、相关身份/退出/EOF-drain unknown、资源冲突立即停止后续启动并保存可得失败/输出/退出，按原方法有界收束自有进程，不杀他人daemon、不忽略全部AccessDenied、不新造重试/分钟/在线额度。与helper/class/编译/run/arguments/观察入口及相关Forge/Gradle/TestKit/build/fixture/cache写运行串行，即使不同新根也不并跑；正常任务输出允许，人工删除/备份/覆盖旧证据禁止。

## WIRE失败后的现行恢复连接

**历史准备入口。** 下述恢复g1现已failed，实际根g2、源码输出已补且目标零启动；原要求保留，但“待补写/未执行/无Result”和该旧恢复gate不再是现行成功输入。当前仅以上节新验证恢复承接剩余验证，不把历史技术合同删减或重新实施。


本图匹配 [Work](work.md#wire失败后的未完接线恢复安排) / [Plan](plan.md#wire失败后的有界接线恢复策略)，事实见 [Context](context.md#wire失败与只读诊断的采用边界)。用户已确认接线→回归→消费者范围，本次只维护恢复安排，不实施或释放gate。WIRE-REMAPPED-NESTED-RERUN generation1内层failed、源码和g1根已写但编译/加载/参数未验证、预检后构建零启动、只读诊断completed均保留；旧W-REMAPPED-NESTED-RERUN/G-REMAPPED-NESTED-RERUN原完整合同与不满足不回填。

仅以新的未完WIRE恢复item及单成员Wave/gate替换后继对旧WIRE成功的等待，不要求旧failed转成功。新恢复→独立VERIFY→独立完整M→V→H；新恢复不消费P/Q产物，不新增它们的直接成功依赖，原发现适用与修复前置及共享冲突保持。VERIFY/M原有P/Q及其它技术前置不删，V/H仍等实际M，十二项合取/最终完整验收不减。下节此前“未实施/无Result/三结果”的WIRE状态按准备历史保留，现行为保留源码的独立恢复，不重放它。

### RECOVER-REMAPPED-NESTED-RERUN-WIRE — 保留源码的未完接线验证

- 单一结果：保留已写接线、补齐原同文件取证输出后，原WIRE可安全调用/编译/加载/默认关闭的全部接线合同成立；以下为原完成合同，generation1已failed，实际根g2、源码输出已补但工具/编译加载/最小验证未完成，旧gate不满足且不再作现行成功等待。前置items：ASSESS-REMAPPED-DISCOVERY-EVIDENCE；所属Wave只等G-REMAPPED-DISCOVERY-EVIDENCE及G-REPAIRS。原WIRE failed和诊断仅为恢复输入，不是成功前置；不等旧gate、自己gate、VERIFY/M或P/Q额外成功。
- 写拥有：仅全新build证据根内复用已纠正run/arguments/compile/ArgsCheck/受影响检查的最小副本及正常自身编译输出；旧g1与所有旧根只读、不续轮/覆盖。真实源码唯一必要剩余写入为PatchedMinecraftTests.kt原新增纯参数方法内worker PID/id、实际env/缺失值、工程/输入/真实helper argv输出，先补齐并编译关联后移交VERIFY；原分支、一参接口、原三参数、两个fixture调用/System属性finally保留，不重做basic/producer/生产，不改Forge build.gradle.kts/Java示例/依赖/用户配置或公共框架。无法在原范围补齐则报精确缺口，不转嫁只读VERIFY。
- 内部实施/证据：按Plan复用原唯一Capture/立即身份/慢采样后移/finally/真实EOF和error判定，逐次spawn紧邻完整资源与排他；只在实际Popen最小传env副本、不写父环境。相关性先筛选并区分AccessDenied/NoSuchProcess，相关目标或不能可靠排除候选未知仍失败。纠正classpath根，复用精确适用Java/javac/stdlib并外核classOrigin/harnessOrigin。对受影响实际函数/调用方做Plan所列分类/身份/采样/异常/退出drain安全检查，记录逐份新字节和检查适用；再一次真实新helper编译/加载，最小独立启用和显式pop默认Java调用证明remapped恰一flag/默认关闭/basic不变及完整唯一-D。源码/class/harness/运行时/实际命令/env/身份/真实exit0/EOF无error-drain、父环境未写回及各轮分存全部闭合，缺一不可；补齐源码输出是移交条件，其真实worker传播由VERIFY验收。
- 完成：仅本新完整Result completed、足证据且Router完整采用，原WIRE全部接线要求加上述未完安全/取证义务成立，才可能满足新gate。内部检查不交独立工具Result，不执行40项正式矩阵、外层纯参数Test selector/同daemon隔离或nested消费者；正式VERIFY/M各有独立终态，旧8/20/11+1不自动代新hash。
- 停止/冲突：真实失败/目标身份或退出unknown/资源冲突/加载或输入不闭合立即停止后续启动并保全可得exit/output，按既有方法有界收束自有进程；不忽略全部AccessDenied、不杀daemon/他人、不新造一般重试/分钟/额度。与helper/class/编译/run/arguments/观察接点及所有相关Forge/Gradle/TestKit/build/fixture/cache写运行串行，即使不同新根也不并跑。正常任务重写自身输出可用；人工删除/备份/复制旧输出或覆盖旧证据禁止。

## 消费者本轮内层重跑恢复连接

本图仍为 [Work](work.md#本轮消费者恢复维护) / [Plan](plan.md#消费者本轮内层重跑策略与作者自检) 的唯一匹配执行图；本节只派生当前方案，不是实施、Result采用或gate释放。最新事实见 [Context](context.md#本轮消费者恢复的采用事实与边界)。本图下方历轮“当前/尚无/待关联”限其历史时点；原M、API恢复等failed、verify-remapped-fresh-consumer g1启动前blocked/零写入零构建及各旧gate不满足不回填。

ASSESS-REMAPPED-DISCOVERY-EVIDENCE g1 completed已完整采用、原版本发现gate满足是既有采用事实，不是作者本轮判定。其版本限定仍有效；新helper/class/入口env/观察字段必须由新的受影响回归补证，不可自动继承为新版本已验证。本轮接线、正式受影响回归、完整M是三个独立终态，各自一个Handler/Result；任何一项的通过均不能代另一项。原关联只读采用不重开，旧blocked消费不继续派发；真实M的新成功输入只供显式V/H，不新造完整消费者编号。

### WIRE-REMAPPED-NESTED-RERUN — 仅调用内启用的接线

- 单一结果：原一参helper和本轮新根薄入口形成可用、默认关闭的remapped重跑接线；原generation1已failed，已写源码及g1薄入口保留，编译/加载/最小检查未完成，旧gate不满足；以下原完成合同保留为历史，不续跑或回填。现行后继只消费本文新验证恢复Result/gate；上节原恢复g1也已failed，不再等待其成功。前置items仅为 ASSESS-REMAPPED-DISCOVERY-EVIDENCE；Wave同时等待G-REMAPPED-DISCOVERY-EVIDENCE及原G-REPAIRS。WIRE不读取P/Q产物或内容合同，故仅移除本item和所属Wave的P/Q成功依赖；版本/修复适用性及下述共享写冲突不变，回归及M的其它前置不删。采用仅在身份当前适用时成立，不等旧失败或自己的gate。
- 写拥有：仅 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt` 参数helper分支及新增纯参数JUnit方法 `Test patched Minecraft arguments`、本轮新build证据根内run/ArgsCheck等最小薄入口副本及正常自身编译输出。新方法只调用真实helper核对两工程/原四Java路径输入并finally恢复System属性，不调用GradleRunner/nested消费者；原两个fixture方法保持不变。V须枚举此当前新增案例，不把它计作额外完整消费者。保留 `patchedMinecraftArguments(String)`、原测试调用形状、jar/printCompileClasspath/-s、basic和唯一完整Java路径-D。候选 `CODEV_REMAPPED_NESTED_RERUN=1` 只由新根run.py实际Popen的子进程env副本传入；helper只对remapped且精确值1追加一个 `--rerun-tasks`，默认/空/非1及basic均不追加。不能常量true、不写父环境/持久设置，不改生产/Forge build.gradle.kts/用户配置/Java示例/依赖/旧工具或旧证据。
- 完成/证据：独立完整Result completed、足证据且被完整采用；实际修改/新helper编译和加载身份可核对，最小自身检查真实调用该helper证明启用remapped有一个flag、默认remapped及basic仍原参数，启动路径的子env副本与记录相符。新根源码/class/hash/实际命令/退出及输出收束关联明确，不能仅grep参数。此结果只建立接线，不代正式矩阵、旧发现新版本适用、真实Java8消费或M。
- 停止/冲突：新分支不满足默认不变、需要其它真实源码/持久切换/新配置框架或未知能力即报告，不自行扩修。真实身份/退出unknown和非网络失败仍停止并保存本轮证据。与共享test/helper编译、参数/发现/consumer、R/D/B/M/V及相关build/fixture/cache写入全部串行；旧证据只读，正常任务重写自身build输出允许，人工删除/备份/覆盖历史禁止。

### VERIFY-REMAPPED-NESTED-RERUN-REGRESSION — 现有JUnit参数与同daemon隔离成立

- 单一结果：当前helper的完整参数/basic默认/非1值及同daemon开启后关闭行为成立；当前仅计划、未执行、无新Result。前置items：ASSESS-REMAPPED-DISCOVERY-EVIDENCE；所属Wave只等待G-REMAPPED-DISCOVERY-EVIDENCE及G-REPAIRS，不等WIRE/harness或M，不新增P/Q直接成功等待，旧发现不自动证明当前版本。
- 写拥有：只允许本轮新证据目录内必要的直接JUnit调用记录/正常Gradle Test输出；真实源码、私有Python工具及旧根只读，不修wire.py/编译ArgsCheck或造框架。正常Test编译并实际运行已有精确selector，关联当前源码/方法及输出，不另要WIRE Result。
- 证据：按[Plan](plan.md#未来最小执行安排)，现有`Test patched Minecraft arguments`每次真实helper核basic/remapped×Java路径缺失/空/多目录/含空格；子env显式1、移除、空、0及其它非1值分别输入。核原jar/printCompileClasspath/-s、非空完整唯一同名-D单argv/无冲突-P，仅remapped精确1恰一flag，basic及默认不变。提交env是独立预期，与worker实际env/输入/argv对照，不由同一读取值自证传播。每次Gradle0/JUnit1/0/0/0且真实Test执行，非UP-TO-DATE/FROM-CACHE/SKIPPED。
- 同daemon隔离：开启→移除两次outer argv/cwd/JDK/home相同，同daemon身份可关联且有不同新worker；默认从父环境新复制并显式移除，不写回父环境。移除外层--debug-jvm，保留withDebug(true)，不withEnvironment/no-daemon/stop/换home补证。每次普通INFO/stdout/stderr、JUnit/XML、命令/env/身份/真实退出先独立保存，后次才启动。实际环境设置/恢复warning、身份未知/非同daemon/未新worker/输出或Test缺失均不能通过。
- 完成/停止/冲突：仅本独立完整Result completed、足证据且Router完整采用才可能满足G-REMAPPED-NESTED-RERUN-REGRESSION；不代M。取消私有harness/AST/hash/Capture自证和内部逐层调试覆盖，未观察部分明确披露；必要相关身份、排他、实时输出保全/实际退出和有界收束仍保留。真实失败/unknown/冲突即停止后续启动，不扩权修代码/改标准或一般重试。与M及共享Forge/helper/class/Gradle/TestKit/build/fixture/cache写运行串行，业务独立不是并跑许可。

### RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN — 原Java8消费者的独立真实消费

- 单一结果：原`PatchedMinecraftTests.Test remapped patched Minecraft`本轮完整M实际消费成立；当前仅计划、未运行、无Result，一个独立Handler/Result。前置items：ASSESS-REMAPPED-DISCOVERY-EVIDENCE、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165；所属Wave等待G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。不等参数回归、任何私有WIRE成功、旧blocked/failed或Neo/R/D/B，原发现适用不等于新消费者成功。
- 写拥有：仅本轮新证据根内直接调用/普通日志/结果保存及正常Gradle/fixture输出，保留当前源码和原Java示例、Forge配置、工具及旧根只读。只在本次子env副本设开关1，不写父环境，移除outer --debug-jvm而保留TestKit withDebug(true)，outer强制Test实际执行，不用jdb/Python链。正常任务重写自身输出允许，不人工删除、清理、备份旧输出或覆盖历史。
- 实际消费：原jar/printCompileClasspath/-s、非空完整唯一-D/无冲突nested -P、remapped启用恰一--rerun-tasks。原EVENT_BUS/named Entity.class Java8示例的compileJava非NO-SOURCE，compileJava和jar均真实执行，printCompileClasspath实际执行；有实际Java8 javac executable/metadata、编译执行/任务outcome及本轮class/Jar依据。UP-TO-DATE/FROM-CACHE/SKIPPED、只见配置compiler或现存Jar不能替代消费。
- 来源/缓存：普通日志及现有printCompileClasspath关联固定MC1.16.5/Forge36.2.39、userdev/MCP/universal/libraries/modules、ResolvePatchedMinecraft、official client server=false、Java8 LoadMappings official→MCP→Tiny obf/srg/named、显式srg→named RemapTask、实际provider图和完整classpath。有效上游Gradle/插件缓存允许，如实标层级/输入/实际插件及当前产物身份，必要来源缺失则报告缺口；不要求新的冷重建、全历史hash或内部逐层key自证，不把文件存在推成通过。P/Q/R各自未变缓存合同仍有效，原发现/生产修复不重开。
- 完成/限制/停止：本独立完整Result completed、足证据且Router完整采用，Gradle0/JUnit1/0/0/0、实际任务/来源/输入/产物及命令/cwd/JDK/home/env/身份/真实退出全部关联；每次先存普通stdout/stderr/JUnit/XML/失败及退出再后续启动。Provider直接帧、nested System/StartParameter两map/gradleProperty/effective installations及jdb/Capture内部证明已撤销，明确未直接观察，不能写逐层成功。必要排他/相关身份/实际退出与输出保全、有界收束自有进程仍保留；失败/unknown/冲突/skip即停，不杀他人、不吞错或扩大重试。与参数及其它共享Forge/Gradle/TestKit/build/fixture/cache写运行串行，独立成功不回填任何旧gate；V/H仍须另等参数结果和原最终合取。

**当前联合等待。** V/H分别显式消费参数回归G-REMAPPED-NESTED-RERUN-REGRESSION和完整M的G-REMAPPED-CONSUMER-RERUN；参数与M互不等待成功，不增加第13个完整消费者。旧WIRE/两恢复和旧consumer-recovery的failed/blocked及原gate不满足保留，不再现行等待。作者不执行、采用新执行Result或释放gate；其余历史连接以页首分界为准。

**历史C5（原发现完整采用之前）：独立结果登记→只读完整发现关联→不同Handler fresh完整M→V/H。** [唯一现行恢复连接](#remapped-分结果恢复与证据关联)取代下方生命周期“同一内部步骤/一个Handler/无独立Result”的旧准备分组，不改其原技术合同。原修正/20项与夹具恢复各failed保留，第12项恢复、参数8项和Java8选择各自completed范围保留；只剩跨结果版本/检查适用性的完整关联待独立Result。原审查blocked、旧unknown/偏差/gate不满足不回填；日志各9行Producer graph不证明fresh消费。事实见[Context](context.md#remapped-独立结果与差异核对采用事实)，策略/作者自检见[Plan](plan.md#remapped-分结果恢复策略与作者自检)。本次只维护文档，不执行验证、采用新执行结果、判断实际完成或放行；以下各轮“当前/待做”按各自历史时点保留。

**当前：SHELL-RECOVERY failed后的独立准备恢复。** 原确认范围有效；本次只维护四协调文档与作者自检，落实新确认的两类准备错误边界，并由独立新恢复Result承接全部未完发现。旧失败及gate不满足不回填，20/20只按适用条件复用；编译/实际参数回归/新完整发现均未执行。独立fresh完整M及V/H十二项最终合取不减。三族reuse、权威写入skip；不新增确认关卡或运行授权。见[当前事实](context.md#remapped-准备错误边界与shell-recovery失败)、[当前策略](plan.md#remapped-准备错误边界与独立恢复作者自检)、[唯一图](waves.md#remapped-准备错误后的独立恢复连接)。下方旧当前安排仅属各自历史时点。


**当前：VALIDATION failed 后的 shell 未完恢复。** 唯一现行发现连接为[新独立SHELL-RECOVERY](#remapped-shell失败后的未完恢复连接)实际足证据→独立fresh完整M→V/H；20/20按工具身份/输入/环境适用复用，不再修夹具/恢复源码。旧VALIDATION failed及其gate未满足、shell exit2/零Gradle和exit127后继续的未接受偏差保留。下方旧“当前/待修夹具”均按原准备时点，不覆盖本入口；本次仅四文档维护/作者自检，未实施或释放gate。

**当前M发现恢复：** 原发现generation1原始Result保留completed，核查generation1 completed但整体完成声明不足以采用，旧发现item/G-REMAPPED-JAVA8-FORWARDING未满足；本图只维护未完恢复，不执行或接受偏差。已确认原范围不重求授权，新的发现恢复继承原发现全部谓词，完整M另有独立Result；当前连接见[恢复节](#remapped-发现核查后的恢复连接)，事实见[Context](context.md#remapped-核查采用与未完恢复边界)，方法/作者自检见[Plan](plan.md#remapped-核查后的最小恢复策略与作者自检)。下方旧M“仅计划/待确认”等限原准备时点；原始报告、历史偏差、未满足gate及全部原合同保留，不由文档维护或新技术成功回填。


**当前维护：用户已接受本次P-v6在线次数偏差，技术证据采用条件待局部独立复审。** 原P-v6 item/Result保持partial、G-FORGE-REBUILT-CONTENT仍未释放；5标online入口（1次Java前失败、4次实际在线Gradle）及normalOnline=2重分类并存，不以2/3证明未超限。例外只接受既发生的本次偏差，不增加未来在线额度，不改旧账本/日志或降低完整技术标准。P-n-v完整completed及源码gate满足仅登记Router已采用事实，不重做。本轮只维护四文档及作者自检；新的只读证据核对item/独立Result与后继条件仅为准备，不执行、不采用或释放任何gate。事实见[Context](context.md#p-v6-一次性偏差接受与技术证据)，策略见[Plan](plan.md#p-v6-既有技术证据采用策略)，唯一图见[Waves](waves.md#p-v6-例外下的证据采用连接)。

## P-v6 例外下的证据采用连接

**现行事实。** P-n-v完整completed及G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION已由Router采用满足，原P-n partial/旧源码gate不回填。原P-v6仍partial，W-FORGE-REBUILT-CONTENT/G-FORGE-REBUILT-CONTENT的原成员/完整技术与运行合同保留且旧gate未释放，不续跑或改判。用户已确认的例外只接受[这次既发生的5标online/4实际在线Gradle偏差](context.md#p-v6-一次性偏差接受与技术证据)，不是用normalOnline=2/旧3计数证明合规、增加未来额度或直接以partial放行。

为[Plan本次采用策略](plan.md#p-v6-既有技术证据采用策略)显式加入P-v6-a：只读核对既有完整技术证据在此次例外下的可采用性，一个item/Handler/Result、一个单成员Wave/新gate。成功等待为已满足的源码恢复item/gate→P-v6-a自己的独立completed足证据且Router实际采用→新G-FORGE-REBUILT-CONTENT-EVIDENCE→8个完整P消费者。原P-v6 partial是可核对的技术输入，不是成功前置；旧gate不是新gate的祖先，不转换或释放。新item未执行、无新Result、新gate未释放；本轮作者completed只证明四文档维护。

Q-1165/Q-Neo、R、D、B、M、V、H共8个直接消费者仅替换完整P成功输入。两Q各等本组T，R保留三T/两Q且仅阻V/H，D不等Q/Neo/R，B另等D，M另等Q-1165而不等D/B/Neo/R；V/H仍汇合12个必需独立恢复Result（Mixin/三T/P-n-v/P-v6-a/两Q/R/D/B/M）、原三修复、最终同版fresh/根入口及全部技术标准。替换点为这些item前置、相应Wave前置gate、最终G-RECOVERY-INTEGRATION第1/10款；原失败/partial/unknown/未实施后继不回填，其余业务依赖/技术验证/写运行排他不改。

不同Handler的局部独立复审由Router安排，本作者未派发或模拟；其任务completed不代新P-v6-a Result或自动放行。新Result的实际采用和新gate判定仍归Router。只读核对不获构建/测试/CLI/下载/在线权限，不重复已通过技术检查或重新申请同一例外；不新增时钟、时间预算或形式签收要求。未来各分支仍须自己的全部真实验证及原停止条件。

**以下入口保留前轮规划与作者记录，当前连接以上述入口及其定点更新为准。**

**当前维护：P-n generation1 partial已采用，保留两owner/version10，只恢复未完编译与四引用验证。** 原P-n item/Result/源码gate及不满足历史完整保留，不续跑或回填。新P-n-v独立恢复Result消费已写源码及适用旧证据，补齐原P-n完整源码终态，不重做生产修改或两处有效reference修正；P-v6改消费恢复足证据，仍独立证明新实际加载、全部4782及原oracle、version10真实miss→rebuild→same-path hit→再次完整检查。8个完整P消费者及Q/R/D/B/M/V/H业务依赖不变。下方旧P-n待写/直接消费P-n和“两项/两Result”措辞保留原规划时点，现以[恢复策略](plan.md#p-n-partial后的未完验证恢复策略)、[采用事实](context.md#p-n-partial采用与未完验证边界)、[唯一现行连接](waves.md#overlay-未完验证的现行连接)为准。沿用PRD/ADR/Spec reuse与已确认范围，不重求许可、不重开预算研究；本轮仅四文档作者维护，不执行恢复、派发复审、推进item/Todo/gate或宣称ready。

**当前：用户已明确“不需要分钟预算”，撤销P-n→P-v6统一分钟政策。** 不再要求共用1800秒/30分钟截止、起点前双时钟采样、跨Handler共同单调时钟证明、交接扣时、全链阶段耗时/上界估算、至少60秒收束及独立保存余量证明，亦不再调查最终Result发布耗时。这些预算派生义务不再是P-n/P-v6启动、继续、Result采用或gate验收的前置；不新增替代时间上限、估时采样或预算证据项目。一般日志、实际UTC起止/耗时可照实保留；单次工具超时和可观测控制退出仍按实际工具合同处理。

原预算局部复审not-ready及P1跨Handler时钟/P2全链耗时调查作为历史保留：调查已完成，所需机制未建立/证据不足，不能称被技术补齐或独立复审通过；因用户撤销该政策，不再构成现行预算阻断。现行合同及作者自检见[Plan](plan.md#分钟预算撤销与作者自检)，决定与历史分界见[Context](context.md#分钟预算撤销的用户决定与现行边界)，执行图说明见[Waves](waves.md#预算撤销后的执行准备边界)。

此前已确认的P-n生产接线、version9→10和四引用聚焦修复，以及P-v6新实际产物加载、全部4782类/原完整oracle、真实miss→rebuild→same-path hit→再次全量检查均保持；两个独立Handler/Result、依赖、消费者、共享构建串行与非预算停止条件不变。正常网络全链最多3次（含hit），仅明确临时网络且前次真实退出/输出收束、证据分存和排他可判才可再试；不是无限重试。实际内容不符、身份不明、冲突或控制退出unknown继续停止受影响执行。本次仅四文档维护及作者自检，无实施/运行授权，不宣称独立review通过、实际item完成或gate释放；不变的已确认范围不重复确认，受影响边界独立复审仍未由本次完成。

**当前维护：保留P-v5 generation1 failed，编入notch游戏rename继承修正及新产物完整验证。** 当前只授权四协调文档、唯一Waves图和作者自检，未授权实施/运行。两处已有效reference修正和样本正负例不重做；拟由生产修正P-n交付有聚焦证据的共享源码/cache版本接线，再由P-v6独立交付新产物全部4782内容＋真实same-path hit，分别一个Handler/Result；不是把编译当完整验收。策略见[Plan](plan.md#游戏rename继承恢复与新产物验证策略)，采用事实/限制见[Context](context.md#p-v5-失败采用与游戏rename恢复边界)，唯一图及消费者见[Waves](waves.md#overlay-未完验证的现行连接)。P-v5及更早failed、两partial、全部旧合同/gate不满足、T-basic-v3 completed/已释放gate保留。本轮不宣称独立ready、item成功或gate释放；P-n原生产修复及P-v6完整验收范围已确认，不因撤销分钟预算重求许可，受影响边界的不同Handler局部review未由本次完成。

**缓存策略局部纠正，仍非ready。** 已采用独立复审的唯一阻断：原P-n/P-v6把Core路径/key写成另一实现。现以[当前源码事实](context.md#缓存策略复审采用与源码对齐)、[Plan实际缓存合同](plan.md#游戏rename继承恢复与新产物验证策略)和[本轮作者自检](plan.md#缓存策略源码对齐作者自检)为准：cached-operations路径、内容Murmur3-32/源码排序去重聚合、有序身份与Core key分记、版本10专属operation隔离及新miss/rebuild/same-path hit。旧7/8/9、P-v5失败和此前作者记录保留，不将旧“有序input-key”措辞解释为Core含basename/order/角色；本次只维护文档，不实施/确认或释放gate。

**P-v5准备入口历史（现已failed；下述当前/新限当时）。** **当前维护：P-v4 generation1 failed保留，新增P-v5独立reference语义恢复。** 现行P-v只指 `RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY`（P-v5）；此文件唯一拥有item/Wave/gate及必要消费连接，策略见[Plan](plan.md#p-v5-独立reference语义恢复与作者自检)，失败采用见[Context](context.md#p-v4-内容失败采用与reference根因)。仅未来新build根内两处reference修正与样本正负例服务同一未完完整oracle＋same-path hit终态；不独立交付工具。当前仅四文档维护/作者自检，不实施/宣称ready/确认或释放gate；仍待独立局部review、Router披露及具体实施确认。P-v4及更早failed、两partial、全部原合同/旧gate不满足、T-basic-v3 completed/已释放gate保留。

**前轮P-v4准备入口历史（现已failed；新/当前限当时）。** **当前 C5：保留 P-v3 failed，登记 P-v4 未完完整验证恢复。** 新 `RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY`（P-v4），一个 item/Handler/Result、单成员 Wave/gate，仅补完整独立 oracle＋same-path hit。用户已确认：仅新根薄工具自身可证的编写/静态类型错误可在同一1800秒内修正并复查，计时不重置、失败不删除；真实内容不符、输入/加载身份不明、运行冲突、退出unknown或到限仍停，不降低验收。现行 P-v 简称为 P-v4；旧 P-v/P-v2/P-v3 failed、两partial、全部旧完整合同/gate不满足和 T-basic-v3 completed/已释放gate永久保留。见 [失败与确认边界](context.md#p-v3-静态失败采用与同预算纠错边界)、[策略及作者自检](plan.md#p-v4-同预算工具纠错恢复与作者自检)、[唯一现行连接](waves.md#overlay-未完验证的现行连接)。仅维护四文档，不执行验证、不派发复审、不完成实际item或释放gate。

**前轮 P-v3 准备时点（已 failed；非当前停止规则或连接）。** 新 RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE（P-v3），一个 Handler/一个 Result/单成员 Wave/gate，仅补完整 oracle＋same-path hit。现行 P-v 简称为 P-v3，旧 P-v/P-v2 failed、两 partial、全部旧合同/gate 不满足、T-basic-v3 completed/已释放 gate 永久保留，不续旧预算、不回填。此前“当前/新 P-v2”均指当时。见 [采用事实](context.md#p-v2-尾窗误拒与恢复依据)、[本轮策略与自检](plan.md#p-v3-最小预检恢复与作者自检)、[现行图连接](waves.md#overlay-未完验证的现行连接)。仅维护文档，不实施/调度/完成 item/释放 gate。

**前轮 C5 连接历史（本页入口已取代）。** 原 P-v（RECOVER-FORGE-PATCH-OVERLAY-VALIDATION）已 failed，其原合同/Wave/gate 不满足永久保留；新增 RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY（P-v2）/一个 Handler/一个 Result，仅补未完完整验证。本页此前“新 P-v/当前 P-v”均保留其准备时点；现行完整P消费位置改指 P-v2 及 G-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY，不等待旧 failed gate、不回填旧失败。T-basic-v3 completed/已释放gate、两个partial及全部历史不变。不实施、不运行、不调度或释放新gate。 事实/精确导航见 [Context](context.md#p-v-失败采用与原证据定位纠正)，本轮作者自检/局部复审范围见 [Plan](plan.md#p-v2-定位与恢复连接作者自检)。

[Work](work.md) · [Context](context.md) · [唯一配对 Plan](plan.md)

**M当前恢复连接：** 原M/API恢复两次failed、作者blocked与实际fixture已写入矛盾、全部旧gate保留；未来标准属性发现与完整named消费者分别一个Handler/Result，唯一图见[新恢复连接](#remapped-标准属性恢复连接)。本次只准备并自检，不执行、采用新Result或放行；P/Q/D/B已通过效果不重做，12项完整恢复合取仅替换M消费者输入。

## 图的含义与拆分检查

本图只属于配对 Plan，不是第二份权威、调度器或自动队列。每个 item 对应一个 Handler / 一个独立 Result；只描述可验证合同，本次不改变运行状态、不释放 gate。仅 completed 加足够证据才可能满足谓词，partial/failed/blocked 和只读诊断 completed 均不自动满足修复或运行谓词。

原三项局部结果和 Mixin 恢复保留为 Router 已采用 completed；原 basic generation 1 保留 blocked（三次各1 execute / 1 fail / 0 skip，第三次 Java8 不可发现，最终脚本变量修改未运行，无 patched/consumer 产物）。首轮 VERIFY-COMBINED 保留 failed（153 execute / 150 pass / 3 fail / 0 skip），G-INTEGRATION 不满足；G-RECOVERY 也因原 basic blocked 不满足。项目内证据及限制见 [Work](work.md#已观察结果与恢复范围)、[Context](context.md#basic-阻断后的授权与恢复边界)。这是既有采用事实，不是作者推进 item/gate；原 G-REPAIRS 关联和 Mixin 已完成效果不重放。

Mixin、basic、remapped 的原独立终态和结果身份保留。原图已分 RECOVER-BASIC-JAVA8 与 RECOVER-BASIC-ARTIFACTS，发现与完整消费是独立终态；两边界转发本身共同服务发现谓词，无额外独立消费者。现在 Router 已采用原发现 generation 1 partial：接线完成、原方法1 execute / 1 fail / 0 skip、14条同轮 nested 观察及860文件原运行无漂移；patchedMinecraft 解析输入因 UnknownHost 失败，compiler 两行未到达、实际 Java8 未证、无 patched/consumer 产物，误做 git status 及不保证 .git 元数据未变的偏差保留于[原 partial 报告](../../../build/recover-basic-java8-evidence/report.md)。仅为未完成运行验证新增 RECOVER-BASIC-JAVA8-RETRY / 一个 Handler / 一个独立 Result；不重做成功接线、不回填原 partial、不并入产物恢复。后继实际消费新同轮发现结果与原已完成接线依据；两个 Forge 没有跨工程成功依赖。

旧RECOVER-BASIC-JAVA8-RETRY partial、有限RECOVER-BASIC-JAVA8-BOUNDED-RETRY failed及RECOVER-BASIC-JAVA8-RECOVERY failed保留；最新完整采用RECOVER-BASIC-JAVA8-TOKEN-RECOVERY generation 1 **partial**，同版实际函数离线131/131、token/身份/观察纠正已留存，真实原basic 1 execute / 1 fail / 0 error / 0 skip、17条观察，piston-data.mojang.com UnknownHost经UncheckedIOException包装，未到compiler action。137项变化中131项为旧工具unknown cache分类、非损坏证明；进程/线程/输出已正向收束、无监听/无kill，后续PID复用正确识别；见[仓内partial报告](../../../build/recover-basic-java8-token-recovery-evidence/report.md)及[当前采用/判据](context.md#正常网络重试决定与当前判据)。用户只要求正常重试，取消DNS诊断（cancelled、无Result，不计completed）；新增RECOVER-BASIC-JAVA8-NORMAL-RETRY / 一个Handler / 一个独立Result只取未完发现，不重做工具效果、诊断或离线回归。旧item/谓词/Wave/gate/预算不改判不续用；完整B、remapped、最终复验/不同Handler验收仍独立。

以上 token/正常重试准备保留为历史。最新 RECOVER-BASIC-JAVA8-NORMAL-RETRY 已 **failed**：原 basic 唯一调用约104秒/exit1，compileJava 缺 ICommandSender，1 execute / 0 pass / 1 fail / 0 error / 0 skip；17条观察但 compiler/metadata 零行，非网络停止、无后续调用，偶然 Jar 不等于 D/B。[原报告](../../../build/recover-basic-java8-normal-retry-evidence/report.md)和原 item/Wave/gate 完整保留不满足、不续预算。用户最新撤出尚未执行的新封存 S 及未来旧实物对照；本次维护真实私有 fixture T 的独立边界，修正 P 的真实最终产物/缓存完成证据、R 的真实可执行回归及 D/B/M 技术依赖；V/H 汇合所有必需证据。当前连接只见[末节](#forge-补丁恢复的现行连接与旧-gate-保留)。专用 fixture 及 remapped 原脚本迁移权限保留，封存要求已撤回；当前调用只维护文档，不复制/建 fixture/运行或放行。材料性变化独立 review 与适用披露/确认仍由 Router 判断，不重新要求不变授权。

原 FIX-OUTPUT、输出竞争、JMX/预约载体和专属测试/gate 均继续排除，不标 completed；静态迁移历史、StripStreamTests 动态例外、全量 partial、not-ready、blocked/failed 及498项等价盲区不变。范围变更独立 review、实施范围 Disclosure/确认由 Router 后续处理，本图不宣称 ready 或实施授权。

**历史：P-recovery准备时点，现行生产/验证分组以上方入口为准。** 当前C5只维护原P partial后的 **RECOVER-FORGE-PATCH-OVERLAY-CONTENT（P-recovery）**，一个item/Handler/Result恢复原完整P可消费结果；必要生产纠正、内部build验证和全部内容/cache验收共同服务该终态。T-basic-v3 generation1已采用completed，其单成员gate已由Router释放供原P；原P generation1 partial/原完整谓词/G-FORGE-PATCH-NAMESPACE不满足保留，两owner补全/去late-copy、版本7→8及编译/游戏类/资源改善不重做。新恢复只等已采用准备/原P保留效果，不等旧partial/旧gate或自身gate；Q/R/D/B/M/V/H真正消费完整P处改接新结果/新gate。采用见[Context](context.md#p-partial-采用与-overlay-完整内容恢复边界)，本轮唯一P1的静态接线修正见[Context最新加工](context.md#p-recovery-继承接线的局部复审修正)，策略与本轮自检见[Plan](plan.md#overlay-完整结果恢复策略)及[作者检查](plan.md#继承接线局部修正作者自检)。本次不实施/调度/独立复审/称ready或释放实际gate。

**历史：T-basic-v3准备维护。** 最新C5只登记T-basic-v2控制提前退出failed后的新 **T-basic-v3（RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION）** 独立完整验证及必要消费，一个item/Handler/Result；薄入口/取证及内部attempt无独立消费者。旧T-basic/T-basic-r/T-basic-v/T-basic-v2各failed、全部原合同/旧gate不满足、T-basic-v历史调用/启动/退出unknown和T-basic-v2真实Gradle退出/后代结束原因unknown保留，不resume/续预算、不因新成功回填。复用helper/test/LZMA/fixture及安全输入，仅新证据根最小控制：删除Start-Process＋WaitForExit false先exit124分叉，同一bash terminal前台同步原gradlew/argv，terminal_wait只等同一terminal不重启。真实工具硬限从单一1800秒剩余扣出收束/保存余量，不简单增大1200；强制中断不保证正常Gradle码，不伪造码、控制/身份/退出unknown仍停。实际排他/真实隔离/安全复用/完整可观测控制须即时确认，历史采样/用户重试不代证；仅纯临时网络且前次正向退出/分存/排他/余量充分才再试。完整同轮selector1/0/0/0与全部原prepare/reference/CLI/JVM/identity/witness/inventory/patch/prepared不减、不拼轮/skip/把未运行记不适用。P item/Wave、R/V/H及最终第1/10款改消费新结果/四failed史，Q/D/B/M、其它最终条款、Java21独立性/冲突串行及资源决定不变。采用见[Context](context.md#t-basic-v2-控制失败采用与同-terminal-前台恢复)，实际自检及不同Handler局部复审边界见[Plan](plan.md#basic-同-terminal-前台恢复维护作者自检)；本次不执行/宣称ready/item完成/释放gate。

## Item 定义

### FIX-RESOLUTION — 任务域仅扫描声明输入

- 单一终态：普通类、对应字节、plugin依赖及资源按显式有序域一致选择，Manifest不能增加执行输入；关闭、原生fallback及当前输入跟踪维持。
- 前置item：无。权威/输入：Context和Plan第1节。
- 写所有权：IsolatingMixinClassLoader.kt、MixinInputBindingTests.java、MixinResourceTests.java；ordinary 中新增 Manifest/竞争类资源/MR 及目录输入，pipeline/callers 中新增显式 classpath 和变化变体及其 Jar 注册。若必须修改测试私有输入 helper，只限该输入取用，不重构 fixture 框架。task 参数/缓存注解现状已足够，不预授权新隐式输入配置。必需局部验证统一消费 [Plan 局部清单](plan.md#局部验证-selector-与断言承载) 的 FIX-RESOLUTION 行及涉及的完整类；Producer/OperationIsolation 等仅为共享只读回归，不因列入验证而增加写范围。
- 验证：A 的 Manifest 引用 X 与显式 B 竞争、未显式 X 不可见、显式 X 放在首/尾的不同结果；类/字节/resource/plugin/转换值一致；目录与 Jar 竞争、URL 组件编码、MR；未显式 X 变化不影响结果，显式 X 变化后当前输入重执行或正确缓存且输出改变；JDK open-null、原生 refmap fallback、read/close/suppressed、loader 退出后原 Jar 可独占/移动、TCCL 及 CodeSource 保留。所有实际执行必须回填到 Plan 该行及新增反例的实际 `Class#method/parameter`，新增方法/参数不得只报类名。Gradle 的方法过滤语法沿用 Plan，不把文档的 `#` 直接当过滤串。
- 完成证据：Result列出直接URL/目录/Jar/关闭接点、静态输入与Gradle outcome/实际值、故障探针命中和受影响class报告。未关闭流测试或Manifest缓存反例未跑不能由普通有序测试替代。
- 写冲突：FIX-DISCOVERY 的 MixinInputBindingTests、MixinResourceTests、ordinary 注册及故障接点；同一处代码按最新工作树排他修改，不互相覆盖。
- 失败失效范围：显式域谓词未成立；其余独立修复结果保留，W-REPAIRS不释放。

### FIX-DISCOVERY — 重复路径只归并声明与side

- 单一终态：相同配置路径跨来源重复时无共址/字节相同前提，side归并和实际正文有序选择正确，原有真实失败及精确清理保证继续成立。
- 前置item：无。权威/输入：Plan第2节；在现有普通有序域即可独立构造有效反例。与Manifest修复没有业务成功依赖。
- 写所有权：MixinInputs.kt 的 discovery/imports、MixinInputBindingTests.java、MixinResourceTests.java 及 ordinary 静态外置/不同正文/side、清理输入和必要注册；不得改清理逻辑身份或增加来源身份。必需局部验证统一消费 [Plan 局部清单](plan.md#局部验证-selector-与断言承载) 的 FIX-DISCOVERY 行及涉及的完整类；Producer/SafeRetention/StripMixins/FabricApplicability 为共享只读回归，不因此授权修改这些类或 Fabric 生产代码。
- 验证：两个声明 Jar 都没有正文而显式 runtime 有正文成功；异正文 + runtime 覆盖及交换 source 顺序的实际转换/通知；side 合并；缺失必需正文仍失败；各物理副本同键批量清理且近似键/无通知项保留；原输入字节不变。旧 `discoveryRejectsDifferentConfigBytesWithoutChangingInputs` 的失败断言改为成功选择，旧 `discoveryComparisonReadAndCloseFailuresBlockRealProducerAndAllowRetry` 的故障接点迁到真实 metadata load；执行 Result 必须按 Plan 同一 selector 记录实际方法/参数、cause/suppressed、两输出失效和 fresh retry。
- 迁移必须包含：旧资源冲突失败断言改成有序成功断言，保留目录resource/CodeSource；原duplicate-content读/关闭故障接点迁到实际metadata load，保留真实read/close/read+close、异常identity/suppressed、两输出失效、关闭后移动及fresh retry。Result记录旧测试→新测试映射，不能删掉有效失败检查或保留死探针。
- 完成证据：新增反例与有效旧断言迁移表、最小及直接受影响classes运行报告、真实故障命中与成功retry；仅删除“Ambiguous”代码或原始131通过均不足。
- 写冲突：FIX-RESOLUTION 如上；测试若需兼容最新URL源，仅迁接点，不把另一个item结果悄悄并入此项。
- 失败失效范围：本项重复语义/必要回归未成立，不能进入组合；已完成域修复或 Fabric 覆盖不被重置。

### TEST-FABRIC-UTF8 — 真实metadata边界的默认流对照

- 单一终态：Fabric真实load及取得handler后修改当前metadata再remove，非法UTF-8行为与同安装库默认stream入口对照，有效内容/失败与快照边界均有可执行证据。
- 前置item：无。权威/输入：Context、Plan第3节；这是覆盖补全，不预设生产bug。
- 写所有权：FabricMixinMetadataTests.kt、Fabric 私有工程 variants 固定非法字节输入及必要 Jar 注册；FabricInputs.kt 仅在既有 copy 接口确需接纳新输入时局部修改。FabricMixinApplicabilityTests 仅为共享只读回归，不因此增加写范围。必需局部验证统一消费 [Plan 局部清单](plan.md#局部验证-selector-与断言承载) 的 TEST-FABRIC-UTF8 行及涉及的完整类，不另造 Fabric 类名。默认无 Fabric 生产修改；若最小合同恢复必要且有直接证据，须在本项 Result 明确列明，任何换解码器/严格化或权威变更仍阻断。
- 验证：截断、错误延续、过长序列等同一 ByteArray 独立默认 `decodeFromStream` oracle；真实 SPI load 只读与 references；先合法 load 再改私有 metadata 的真实 remove；oracle 成功的完整 DOM/unknown/current 新增字段和引用保留，失败的类型/阶段与未写出；handler 快照、独立原始输入不变。保留当前六模式实际 I/O 故障与 retry，并跑同一 selector 表中的 Fabric 业务回归。
- 完成证据：每个原始字节输入→oracle→load/remove实际结果→方法/参数/报告映射；不冻结replacement策略，不用字符串或严格decoder伪造oracle。
- 写冲突：与前两项无已知源码重叠；测试运行共享Gradle/fixture资源仍须排他。不得推断整仓可以安全并行写/跑。
- 失败失效范围：Fabric测试缺口仍存在；不因此否定或重做前两项已经采用的独立效果。

### VERIFY-COMBINED — 同一版最终组合证据

- 单一终态：W-REPAIRS 所采用的三个结果在同一可识别当前内容/环境上共同成立，新增反例和必要共享回归的运行结果可追溯。
- 前置item：FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8。所在Wave另等待G-REPAIRS；这是真实组合输入依赖。
- 写所有权：不修改生产/测试/authority/历史Work；仅正常构建产物与本item Result。不得借组合取证顺手修另一发现。
- 验证：统一消费 [Plan 局部清单](plan.md#局部验证-selector-与断言承载)、[旧名映射及必要断言](plan.md#验证分层与最终组合) 与 [完整模块清单](plan.md#同版最终组合的实际模块清单)，重枚举最终当前类/方法及新增反例，在同一最终版本 fresh 执行 Mixins、Fabric、Forge 完整 test 任务与根 test 入口。ForgeMixinMetadataTests、ForgeAccessTransformAndJarJarCompatibilityTests、PatchedMinecraftTests 三类必需 fresh 义务不变，不以“触及”为条件；当前观测类数不是未来固定数量。记录外层 Gradle JVM、各 test.javaLauncher、fixture.gradleJava、输入改动、task outcome、XML/HTML/日志/产物；根入口缓存只核对接线，不替代三模块同版 fresh。保留 Fixture 失败/partial，注明 skip 和平台局限，不用历史131或旧输出代替。
- 完成证据：同版内容/环境标识、每项反例与必要回归到实际执行的清单、所有非成功情况的范围解释；有覆盖要求而skip则谓词未成立。可移植持久化仅引用仓内可读产物（若被保留）或加工事实，不引入外部临时Result路径。
- 冲突：所有共享构建目录独占；不与修复item同时写/跑。源码如漂移，重核受影响组合证据，不能引用不匹配的局部成功。
- 失败失效范围：同版组合未成立，W-INTEGRATION不释放；局部已采用事实保留，不自动重新执行三项或擦除失败。

### RECOVER-FIXTURE-RULE — 实际发现的声明与真实删除异常

- 单一谓词：测试专用 FixtureMixinRule 的 snapshot 记录 load 实际读到的声明名，remove 仅在传入 root 删除这些名，并保留真实 read/remove IOException 包装、可选 side、原输入和 retry 合同。
- 前置item：FIX-RESOLUTION、FIX-DISCOVERY；所在 W-RECOVERY 另等待 G-REPAIRS。首轮 failed 结果及只读诊断是已采用输入证据，不是要求 failed item 先变 completed 的成功依赖。
- 写入拥有：仅 Mixins 测试 FixtureMixinRule.kt、FixtureMixinRuleTests.kt 及同一合同必要测试断言，不改生产 API。SPI 服务、MixinPreapplicationTests、MixinResourceTests 是验证消费者，不由列入验证推导额外写权限。
- 证据：按 [Plan 恢复一](plan.md#恢复一测试声明发现与删除异常合同)，保留三个原方法；逐例记录仅发现名删除、common/client/server/空声明、未发现 side 保留、空新 root 的真实 NoSuchFileException、确定性 read/remove 故障命中及重置后的成功 retry，snapshot/原输入不变。跑最小方法再完整 FixtureMixinRuleTests、MixinPreapplicationTests、MixinResourceTests，XML/日志/产物与当前源码对应。
- 冲突：与 RECOVER-BASIC-PATCHED、RECOVER-REMAPPED-PATCHED 无业务成功依赖，但所有共享 Gradle/build/fixture/cache 写运行排他；与原 Mixins 文件写入/读评估冲突。失败保留实际异常/尝试证据，禁止硬编码 throw 或泛化生产缺失策略，未足证据不满足本项。

### RECOVER-BASIC-PATCHED — 1.12.2 basic 的真实 patched 消费

Router 已采用 generation 1 blocked，详见[原报告](../../../build/recover-basic-patched-evidence/report.md)。以下原谓词/证据合同保留；不再以重新执行本项或改写其状态恢复。后续发现验证和完整消费使用下方独立结果及本次重试连接，不要求本项转成功，旧 G-RECOVERY 继续不满足。

- 单一谓词：固定 Minecraft 1.12.2 / Forge 14.23.5.2860 / userdev3 经现存 ResolvePatchedMinecraft 产生实际 patched Jar，由原 Java8 consumer 完成 compileJava/jar 和 printCompileClasspath；证据仅评价本工程。
- 前置item：无额外 item；所在 W-RECOVERY 等待 G-REPAIRS。首轮 failed 与只读诊断是来源证据；不等待 remapped 成功或旧 VERIFY-COMBINED 转成功。
- 写入拥有：仅 basic-patched-test/build.gradle.kts；确需断言时仅 PatchedMinecraftTests.kt 中本例或必要共享取证接点，须与另一恢复排他且不改其独立语义。保留原 Java consumer；不补生产 API、旧全局 DSL、TestKit classpath 参数或升级依赖。
- 证据：按 [Plan 恢复二](plan.md#恢复二两个-forge-fixture-迁移到现存任务-api)核对本例 task API、userdev3/MCP/patch tools/universal/libraries/modules/实际 namespace 和 provider 依赖。只运行 `PatchedMinecraftTests#Test patched Minecraft` 对应原 jar/printCompileClasspath 入口，保存 patched/compileJava/jar outcome、实际文件/坐标/产物及 Java8 consumer class、classpath；consumer 是 EVENT_BUS 与 MinecraftServer.main 的编译可见性，不承担继承/override 或额外 AT 证明。脚本 compile 或旧 class 不算通过。
- 冲突：共享 Gradle/build/fixture/cache 运行排他；与 remapped 无业务成功依赖，但共享 PatchedMinecraftTests.kt 接点（如需写）及构建资源须串行。任一恢复失败不重置另一独立 completed；完整类共同执行仅由 VERIFY-RECOVERY 验收。
- 停止/失败：现存解析能力或实际来源/namespace 无法闭合则报告本例具体缺口，不扩大生产/版本/consumer 范围；保留实际失败和重试，未足证据不满足本项或 G-RECOVERY。

### RECOVER-BASIC-JAVA8 — 标准属性两边界与实际 compiler 发现

Router 已采用 generation 1 **partial**，接线成功与运行失败/缺证完整保留；以下为原 item 的谓词、写拥有和证据合同，不是允许重新实施或复用原身份重试。原 W-BASIC-RECOVERY/G-BASIC-RECOVERY 不满足；新重试不把本项改 completed 或自动释放其 gate。

- 单一谓词：环境提供的已解析 `org.gradle.java.installations.paths` 从外层 Gradle 越过 Java17 Test JVM，只有 basic runner 以同名 -D 转发到 nested Gradle9.4.0，实际解析出具有 javac 的 Java8 compiler。仅源码支持、属性存在或候选目录存在不满足。
- 前置item：无额外 item；所在 W-BASIC-RECOVERY 等待 G-REPAIRS。旧 RECOVER-BASIC-PATCHED blocked 和只读追踪是已采用依据，不要求旧 item/gate 转成功，不依赖 remapped 或 Mixin 重新执行。
- 写入拥有：仅 minecraft-codev-forge/build.gradle.kts 的 Test 配置，以 providers.gradleProperty 取已解析值并传同名 systemProperty；PatchedMinecraftTests.kt 仅 basic invocation 读取并追加一个同名 -D 列表元素。缺失/空值不传空/null；保留原 jar/printCompileClasspath/-s、withPluginClasspath/forwardOutput/withDebug(true)、Java17 launcher/fixture.gradleJava、Java8 consumer 及独立 TestKit home。无本机路径字面量、fixture.*、用户配置/环境/JDK 安装或 withEnvironment，不修改 basic 脚本、consumer、生产或 remapped runner。
- 证据：按 [Plan 接线合同](plan.md#basic-未完成边界的标准属性接线)运行原 `PatchedMinecraftTests#Test patched Minecraft`，保存已解析 Provider→Test JVM 属性→最终 arguments→nested Java8 metadata/executable 的同轮对应；完整绝对路径列表作为单一参数，空格不嵌 shell 引号。明确的现有 compiler 来源是 basic `printCompileClasspath.doLast` 实际 action 输出的 `Java8 compiler:` executable 和 `Java8 metadata:` languageVersion；保存该 action 到达、invocation 和 forwardOutput/stdout 对应。原 build() 抛 UnexpectedBuildFailure 时仍保留已得输出、异常和实际阶段；若 patch/tool 先失败使 action 未到达或两行缺失，本项未完成，不能以候选、属性、失败阶段或预定输出补证，不放行产物项。不新增探针任务/替代入口，不承诺任意失败下本项都能 completed；原方法/完整 basic 成功须另有完整证据。区分当前 zulufx8 与旧 zulu8；来源缺失/无效或相对路径超范围时报缺口，不建配置框架。
- 本 invocation 的共享属性观察：沿现有 withDebug(true) 的 nested Gradle 实际运行帧，只读保存工程/调用/阶段标识、nested 同名 System 属性、StartParameter.systemPropertiesArgs/projectProperties、effective toolchain installations 配置和实际 compiler，与最终 arguments 对应；外层 Test 属性不是 nested 帧证据。现有观察能力不可用或未到达即缺证，不新增任务/探针框架。只判定 basic 接线及本 invocation 语义，remapped 的对应实测由其自身 item 与最终复验承担，不作为本发现项前置。未能判定共享属性/withDebug 影响或发现原语义被改变须报告，不能推定无影响或越权修复。
- 冲突：与 remapped 的 Forge Test 配置/PatchedMinecraftTests.kt 及所有 Gradle/build/fixture/cache 写运行排他；外层同名系统属性在共享 Test JVM 的影响须核对，不授权 remapped runner 转发。串行按最新文件，不能覆盖已有 basic 迁移或 Mixin 成果。
- 失败/停止：未观察到实际 Java8 compiler 解析则本项不满足；同名冲突 -P/-D、无 JDK 或超出现有能力时报告，不改版本/用户配置。后续产物失败不抹去已经成立的发现证据，重用须核对当前输入/环境新鲜度。

### RECOVER-BASIC-JAVA8-RETRY — 保留接线的一次新原入口发现验证

Router已采用generation 1 partial，见[已结束单次重试报告](../../../build/recover-basic-java8-retry-evidence/report.md)。以下旧单次合同逐字保留，不再据此续跑、修改为三次或回填completed；其Wave/gate仍不满足，新有限批次见下项。

- 单一谓词：当前保留的两处标准属性接线，通过一次新的原 `PatchedMinecraftTests#Test patched Minecraft` invocation，取得外层已解析 Provider→Java17 Test JVM 同名属性→basic 最终单一同名 -D 参数→nested 实际 Java8 compiler 的完整同轮证据，并以本轮 nested System 属性/StartParameter/effective installations 观察闭合共享属性/withDebug 语义。只证明原发现合同未完成的运行边界，不证明原 basic 全部产物恢复。
- 前置item：无额外成功 item；所在 W-BASIC-JAVA8-RETRY 只等待 G-REPAIRS，不等待原 RECOVER-BASIC-JAVA8 completed、G-BASIC-RECOVERY、旧 basic/G-RECOVERY、remapped、Mixin 重跑或本 Wave 自己的 gate。原 partial 的成功接线、旧14条观察/失败史是已采用输入，不是须变成功的前置。核对当前接线与原成功效果对应及输入/环境新鲜度；若已漂移致不可复用，只报告，不能在本项修接线。
- 写入拥有：仅正常运行/本次新取证产物；不修改两处接线、basic 脚本、源码/测试/consumer/生产、四文档、权威、版本、用户/网络/环境/JDK/缓存；不新增 runner 参数框架、探针任务/替代入口或 remapped -D。原 `jar printCompileClasspath -s`、Java17 Test/fixture.gradleJava、Java8 consumer、withPluginClasspath/forwardOutput/withDebug(true)、现有独立 TestKit home 全部保留。
- 一次有界运行：执行前记录有限墙钟时限，只启动一次新原 basic 方法 invocation；到限仅有界停止本轮并保存已得证据/缺口，不循环重试、不清缓存/根 clean、不恢复旧 worker。只读诊断所见 repo 禁用为 build-tree 内存状态，无需清缓存；不沿用 files.minecraftforge.net 的错误主机阻断，不把非 JVM curl 全200或稳定性证明新增为 gate，网络仍可能再次失败。此条是未来运行边界，本次图维护没有启动 invocation。
- 完成证据：本轮 invocation/工程/阶段、已解析 Provider、Test 系统属性、最终 arguments（同名 -D 仅一个、完整绝对路径列表为一个参数、无额外同名 -P）逐层关联；沿现有 withDebug(true) 的实际 nested 运行帧只读取 System.getProperty、StartParameter.systemPropertiesArgs/projectProperties、effective toolchain installations、选中 compiler，不能以外层快照替代。本轮 compiler 来源仍只有现有 basic printCompileClasspath.doLast action 实际 `Java8 compiler:` executable 与 `Java8 metadata:` languageVersion=8 两行，必须关联 action 到达及 forwardOutput/stdout；原14条观察不能与本轮 compiler 拼接。共享语义未决/观察不可用/任一缺证仍未完成，不推定无影响。
- 证据保全：新的独立 Result 保存实际方法 execute/fail/skip、task outcome、stdout、XML/HTML/fixture/运行前后内容一致性及所有异常/失败阶段；包括 UnexpectedBuildFailure、网络早失败或超时，没有 action/两行即不完成。原 partial、已完成接线、14条观察/860文件原无漂移及 git status 偏差/.git 不保证完整保留。新仓内证据须另存且核实可读后引用，不覆盖旧报告，不虚构新产物；正常运行偶然产出 patched/consumer 不等于产物项已完成。
- 冲突：与 basic 产物、remapped、所有 Gradle/build/TestKit/fixture/cache 运行及相关输入写入排他；共享 Forge Test/测试文件读观察与写拥有亦串行，按最新内容核对。展示顺序不构成 remapped 等待 basic 成功的业务前置。
- 失败/停止：提前解析/patch/tool 失败、超时、实际 Java8 未证、共享属性影响未决或其它生产缺口均保存实际证据并保持未完成，不放行产物/最终复验，不顺手修代码。新成功只满足本重试谓词及显式新后继；不改旧 Result、旧 item 或旧 gate，不重放 Mixin/原三 completed。
### RECOVER-BASIC-JAVA8-BOUNDED-RETRY — 临时网络失败的有限原入口发现

Router已采用generation 1 failed，见[失败批次报告](../../../build/recover-basic-java8-bounded-retry-evidence/report.md)：本地观测失效、仅一次调用exit1、JUnit计数unknown，无nested/compiler证据，无第二/三次。以下原合同保持；本item及其Wave/gate仍不满足，不续旧批次、不改工具后接着用剩余次数，新恢复另列下项。

- 单一谓词：当前保留接线在本新批次某一次原 PatchedMinecraftTests#Test patched Minecraft invocation 内，完整取得已解析Provider/Test同名属性/runner参数/nested实际帧/System/StartParameter/effective installations及现有action的Java8 compiler executable、languageVersion=8同轮证据，且共享Test/withDebug语义可判。只恢复未完发现，不证明完整basic产物、remapped或全量成功。
- 前置item：无额外成功item；所在 W-BASIC-JAVA8-BOUNDED-RETRY 只等待 G-REPAIRS。不等待旧 RECOVER-BASIC-JAVA8 或 RECOVER-BASIC-JAVA8-RETRY partial转成功、旧G-BASIC-RECOVERY/G-BASIC-JAVA8-RETRY/G-RECOVERY、产物、remapped、Mixin重跑或本Wave自己的gate。旧接线只读核对当前对应/输入环境新鲜度，漂移停止报告，不在本项修复。
- 写入拥有：仅正常运行及本新批次逐次新取证产物；不改接线、basic脚本、源码/测试/consumer/生产、四文档/权威、版本/依赖、用户/网络/JDK/环境或缓存配置。正常Gradle/build/TestKit/cache写入须记录，不授权清理/配置更改。保留原jar/printCompileClasspath/-s、Java17 Test/fixture.gradleJava、Java8 consumer、withPluginClasspath/forwardOutput/withDebug(true)及现有独立TestKit home；不增runner框架、探针/替代入口、remapped -D、生产重试机制/调度器/网络修复，不清缓存/根clean/恢复旧worker。
- 有限运行：新批次最多3次原basic实际调用，自本批次第一次实际调用起总墙钟30分钟，含暂停/取证/间隔，不逐次重置；旧05:01 UTC调用已结束，不当作本轮attempt 1。下一次调用必须前一进程已结束、退出码/异常/阶段可读、证据分存且副作用可判，仅明确临时DNS/连接超时等网络根因且无并存非网络阻断时在剩余预算内重试。不要求逐次审批或curl全200；到限只在可确认目标及既有有界停止能力内收束，必要保全不延长验证调用，未知退出/影响不授权再试。
- 同轮证据：每次唯一关联工程/invocation/阶段及nested帧、Provider已解析值→Java17 Test属性→basic最终一个同名-D完整绝对路径列表参数（无额外同名-P/空/null/硬编码）→nested System.getProperty/StartParameter.systemPropertiesArgs/projectProperties/effective installations/实际compiler。现有printCompileClasspath.doLast实际Java8 compiler executable与Java8 metadata languageVersion=8两行须关联本次action到达及forwardOutput/stdout。外层Provider无对象帧直接观察、仅未变转发代码与消费值关联的限制必须明示，不能冒称直接Provider/nested观察；此限制沿原已审查证据能力保留，不放宽成功判据。旧两轮或另一次观察/两行不得拼接补本次缺证。
- 逐次保全：每次日志/XML/HTML/stdout/fixture、运行前后输入内容、异常/UnexpectedBuildFailure、UTC起止/退出码、execute/pass/fail/skip、task outcome/失败阶段及缺证分别保存；未产生XML或退出状态未知则明示原因，不能填0或通过。先保全前次再开始下一次，不覆盖两份旧partial报告或失败目录；新仓内证据只在存在可读后引用，不虚构产物。保留旧报告解码损失、外层Provider/.git及超时终止分支未验证等限制；运行偶然产物不自动满足独立产物项。
- 冲突：与basic产物、remapped及所有共享Gradle/build/TestKit/fixture/cache运行和相关输入写入排他，Forge Test/测试文件观察与写拥有按最新内容串行。未知活动/资源冲突先停，不新增锁机制；展示顺序不构造remapped等待basic成功的业务依赖。
- 失败/停止：非网络错误、影响未知、观测失效、输入漂移、无法确认前进程退出，或3次/总30分钟上限到达即停止并保留未完成。临时网络失败仅在全部再试条件满足时继续；某一次完整同轮谓词满足即停止成功，但全部失败记录保留。没有compiler action/两行、真实帧不可用、共享影响未决均不完成，不跨轮拼接、不顺手修代码、不回填旧item/gate或重放原三completed/Mixin。


### RECOVER-BASIC-JAVA8-RECOVERY — 本地观测失效后的独立原入口发现恢复

采用状态：execute-basic-observer-recovery generation 1 **failed**；唯一调用11.737990秒/exit1，真实带成对ASCII39引号executor被拒识，无认领/attach/nested/compiler，JUnit全部unknown，无第二/三次。下列原身份/谓词/写边界及W-BASIC-JAVA8-RECOVERY / G-BASIC-JAVA8-RECOVERY原合同与不满足状态完整保留；晚到退出不恢复旧预算，工具离线45项与诊断模型不算完成。当前新后继不再等本item转成功；最新证据和限制见[Context](context.md#真实-token-失败与身份交接恢复依据)。

- 单一谓词：保留接线在新独立批次某一次原 PatchedMinecraftTests#Test patched Minecraft invocation 内取得完整Provider→Test→args→nested System/StartParameter/effective installations→现有action实际Java8 compiler executable及metadata languageVersion=8同轮证据，共享Test/withDebug语义可判。临时取证工具修正/离线检查只服务此谓词，无独立产品/消费者/Result；它们通过而未取得完整发现不能完成本item。不包含basic完整产物、remapped或最终全量。
- 前置item：无额外成功item；W-BASIC-JAVA8-RECOVERY只等原G-REPAIRS。原三修复、Mixin19/19与成功接线均为已采用输入，不重放；旧两份partial、有限failed、只读诊断completed及旧gate不是须先转成功的前置。执行前核对当前接线/7原输入/源码与旧证据稳定、环境新鲜度、资源排他、无相关worker/launcher/jdb/controller或5005监听及相关daemon可用；07:17:33Z快照不代替当前检查。
- 写入拥有：只在新独立build证据目录复制并必要修正临时本地取证控制链、离线检查及逐次产物；允许正常Gradle/module build/TestKit/cache输出并记录副作用。不改/覆盖旧工具、旧batch-start或任一旧证据，不修项目源码/测试/fixture/basic脚本/已完成接线/consumer/配置/权威、版本/依赖/锁或用户/网络/JDK/环境。不新增runner框架、探针/替代入口、remapped-D、生产重试系统，不清缓存/根clean/恢复旧worker；原jar/printCompileClasspath/-s、Java17 Test/fixture.gradleJava、Java8 consumer、withPluginClasspath/forwardOutput/withDebug(true)及独立TestKit home保持。
- 最小内部纠正：完整JDWP选项同时识别实际address=5005和既有localhost:5005，继续核验创建时间、cwd、worker/Test Executor、唯一候选、PID/create_time及监听对应。错误端口/旧时间/错误cwd或worker/零或多候选不attach；身份或退出状态不明不终止或再试，不能按名称杀Java/daemon或仅凭端口认领目标。
- 先行离线检查：只用既有录制启动行/transcript与内存替身，不启动真实进程、attach、网络或终止；覆盖匹配正反例、初始提示符/断点/表达式的实际收齐、分段/EOF/超时/jdb结束顺序，launcher结束而观察未结束、退出未知、旧XML、compiler两行缺失均不成功/不再试；假时钟/身份/停止函数核验一次deadline和目标限制。若暴露问题仅在本地链内作必要纠正，检查证据与Result同存。旧成功观察不证明新自动链；旧无害子进程或新模拟停止通过不证明完整真实Gradle/worker停止分支，未真实验证必须明示，不新增一次真实停止专项调用。
- 新预算与再试：旧失败窗口已过，独立新目录/新batch-start；最多3次原basic实际调用，自首次实际调用起一个总30分钟deadline，暂停/观察/间隔/取证均计入、不逐次重置。进入每次前须有足够执行/保全余量；每次后正向确认launcher、已识别worker及debugger退出，证据分存、副作用可判、无活动冲突，仅明确临时DNS/连接超时且无并存非网络阻断时才在剩余次数/时间内再试。不要求curl全200/逐次审批；非网络或观测失效、身份/退出未知、影响未知、漂移、资源冲突或上限即停，限内只收束正向确认的本轮目标，必要保全不延长验证调用。
- 同轮足证据：唯一关联工程/invocation/阶段、外层已解析Provider与Java17 Test同名属性、basic最终仅一个同名-D完整绝对路径列表参数（无冲突-P、空/null/硬编码），沿现有withDebug实际帧记录nested System.getProperty、StartParameter.systemPropertiesArgs/projectProperties、effective installations与实际compiler。Provider无直接对象帧、仅接线/消费值关联的限制继续明示、不冒称直接观察；现有printCompileClasspath.doLast实际Java8 compiler executable与Java8 metadata languageVersion=8两行须与action到达、forwardOutput/stdout同轮对应。旧两轮/failed/另一attempt片段不补证；帧缺失/提前失败未到action/共享影响未决均未完成。
- 逐次保全：离线检查与每次原调用的UTC起止/单一预算、命令/cwd/身份/监听关联、退出码/异常/UnexpectedBuildFailure/阶段、日志原字节及解码限制、XML/HTML/fixture/task outcome/JUnit计数、运行前后输入/旧证据稳定性分别存于新目录。无suite XML计数unknown，不以任务数填JUnit或借旧XML；保留全部失败和正常build/TestKit/cache副作用，不造产物或覆盖旧报告。区分调用/控制器回执/最终取证采样时点，不把采样当精确全部落盘时刻；原Provider/.git/解码/真实停止链未知限制不被新工具自检抹去。
- 冲突：与basic产物、remapped、所有共享Gradle/build/TestKit/fixture/cache运行和相关输入写入排他；Forge Test/测试文件观察与写拥有串行，不制造remapped等待basic成功的业务依赖。若实施暴露确实独立终态，停止报告边界，不自行实施另一个Result。
- 失败/完成效果：只有某一次新原入口全部同轮发现谓词及当前接线对应成立才完成，某次满足后停止并保全此前失败；工具修好/离线通过或偶然产物不代替发现/独立B。新成功只满足本item及其显式后继，不回填旧failed/两次partial、旧blocked或任何旧gate；其它独立缺口报告，不扩展实现或重放原三completed/Mixin。

### RECOVER-BASIC-JAVA8-TOKEN-RECOVERY — 真实Windows token与身份交接后的独立发现恢复

Router完整采用generation 1 **partial**，见[原报告](../../../build/recover-basic-java8-token-recovery-evidence/report.md)。以下旧谓词/内部工具及再试合同原样保留，W-BASIC-JAVA8-TOKEN-RECOVERY / G-BASIC-JAVA8-TOKEN-RECOVERY仍不满足；不resume或回填completed。已完成工具/离线效果复用，新正常重试不再受旧逐文件sideEffectsSafe、包装白名单及网络早败后完整观察合取阻挡。

- 单一谓词：原成功接线的当前对应成立，在新独立批次某一次原PatchedMinecraftTests#Test patched Minecraft invocation内完整闭合Provider→Test→唯一同名-D→nested System/StartParameter两map/effective installations→现有printCompileClasspath action实际Java8 compiler executable及metadata languageVersion=8，同轮共享Test/withDebug语义可判。新目录必要token/身份交接纠正、真实原快照离线回归只是同一个发现内部支撑，无独立工具发布/产品/消费者/Result；修好/离线通过不完成本item。完整B、remapped、最终复验/验收不在本终态。
- 前置item：无额外成功item；W-BASIC-JAVA8-TOKEN-RECOVERY只等已采用G-REPAIRS。消费[最新failed/token诊断加工](context.md#真实-token-失败与身份交接恢复依据)、仓内原始快照/实际控制器/离线源码及已修地址/观察逻辑，不重做旧成功效果。RECOVERY failed、有限failed、两partial/旧blocked、只读诊断completed与所有旧gate是保留输入，不是待转成功的前置。启动前核对当前7输入/成功接线/源码与旧证据稳定、环境及排他，无相关worker/launcher/jdb/controller/5005监听、daemon可用/idle；旧/晚到历史快照不代替当前检查。
- 写入拥有：只在新独立build证据目录复制已修地址/观察控制的临时链，必要修正下述token/身份交接与针对性离线检查、保存逐次产物；正常Gradle/module build/TestKit/cache副作用须记录。不改旧工具/旧证据/旧batch-start或项目源码/测试/fixture/basic脚本/consumer/已完成接线/配置/权威/版本/依赖/锁/用户环境/网络/JDK。不增通用runner框架、生产重试、替代入口/探针、remapped-D，不清缓存/根clean，不恢复旧worker。原jar/printCompileClasspath/-s、Java17 Test/fixture.gradleJava、Java8 consumer、withPluginClasspath/forwardOutput/withDebug(true)、独立TestKit home保持。
- 最小token纠正：仅完整裸Gradle Test Executor N或一组成对ASCII39单引号包裹的完整token；真实原末项为 `'Gradle Test Executor 2'`，两端字符不丢失。保留原始完整argv供身份比较，只局部解析token，不strip任意引号/空白，不接受substring/前后缀/嵌套或错配引号/非数字。复用5005与localhost:5005识别，原创建时间/cwd/GradleWorkerMain/完整JDWP选项/唯一候选/PID及监听一致限制不减，不按名称或端口取得所有权。
- 候选到认领：快照candidate与重新读取的identity必须逐项相等PID/create_time/cwd/原始完整argv，不以新identity仍alive替代旧身份一致性；attach前再核对同一身份和监听仍归同一PID。消失/复用/任一字段变化/读取失败、监听缺失/变化/未知/多归属均拒绝attach/终止/再试，不能接受替代进程。此为静态防护缺口，不宣称旧调用出现PID复用。
- 内部实施顺序：当前授权/输入/编辑资源排他核对 → 在新目录作最小token/身份及副作用-retry判定纠正 → 同版实际函数的原快照/身份/副作用/退出清理正反离线回归 → 固定工具hash和本版基线 → 真实运行前当前排他/输入/daemon/预算检查 → 新批次逐轮收束、保全、分类、判定。前两项纠正及离线证据由本item未来生产，是真实批次的内部前置，不是开始实施纠正前须已通过的条件；不新增工具终态或图边。已采用review-basic-worker-token-recovery generation 1 completed / not-ready和发现1/2/3均保留，见[Context](context.md#新-token-恢复局部复审采用与本次维护)。
- 先行真实录制回归：把[原始worker-listener快照](../../../build/recover-basic-java8-recovery-evidence/attempt-1/worker-listener-snapshot.json)完整processes/listeners不经预处理直接送入旧实际纯候选函数复现零候选，再送入修正后的同一实际纯候选实现选出原PID283784/create_time1792658574.857099；旧/新实现、原输入/hash与输出对应，不用独立模型或预去引号输入代替。时间界注明[原command UTC](../../../build/recover-basic-java8-recovery-evidence/attempt-1/command.json)与原main time.time()位置：started_epoch未保存，UTC仅为有采样差限制的代理，不伪称原值或从worker create_time反推。内存单变量派生裸token/错配或嵌套引号/多余空白前后缀/非数字、旧时间/错误cwd/worker/JDWP、零多候选和监听缺失/未知/错PID；candidate→identity分别变更PID/create_time/cwd/argv、模拟消失/读取失败，attach前监听变化均拒绝且不触达attach/kill/再试；同身份/监听保持为正例。
- 其它离线约束：保留双地址、初始提示符/断点/表达式实际收齐、分段/EOF/超时/jdb结束、launcher结束而观察未收束、退出未知、旧XML/缺compiler不可完成、假时钟单deadline/余量及停止目标限制的针对性回归。只用录制输入/内存替身，不创建被测真实进程/attach/网络/终止，不新增真实停止专项调用。原两轮各45项对应不同controller hash，不称90项同版通过；诊断仅内存证明未修文件，新离线通过亦不证明真实进程创建/attach/完整Gradle-worker停止链或完整发现。
- 副作用/清理实际消费：按[Context逐轮判据](context.md#逐轮副作用与网络再试判据)，固定源/输入/已采用旧证据和封存attempt不变，有限任务输出映射内的本轮可解释生成变化可保留；未知差异/缺清单/可能复用的半缓存或残留即停。assess提供逐项依据及sideEffectsSafe，eligible_retry必须消费它、分存完成、全体正向退出、清理无未知、无监听/相关残留、输出无错排空及观察线程收束，再合取原网络/观察/身份/预算条件；缺字段不放行，存fixture-after或taskkill exit0不等于safe。离线允许/拒绝用同版实际分类及retry函数、记录输入/内存替身验证，不另造模型或证明真实停止链。
- 独立预算与再试：新目录/新batch-start，不续RECOVERY或任何旧次数/窗口；最多3次原basic实际调用，首次实际调用起一个总30分钟deadline，暂停/观察/间隔/取证均计入、不逐次重置。进入每次前须有足够执行和保全余量；前次launcher/已识别worker/debugger及本轮wrapper退出正向确认、证据分存、副作用/共享影响可判且无活动冲突，仅明确临时DNS/连接超时、无并存非网络阻断才可在余下次数/时间内再试。非网络（含token/认领/观察）、观测/身份/退出未知、影响未决、漂移/资源冲突或上限立即停；晚到退出不恢复已停止批次资格，不在失败后修工具续该批次。不要求curl全200/逐次批准，不按名称杀Java/daemon或终止未知目标；停止保全不延长验证调用。
- 同轮足证据：工程/invocation/阶段、已解析Provider与Java17 Test同名属性、basic最终arguments仅一个同名-D完整绝对路径列表参数（无冲突-P、空/null/硬编码）逐层关联，沿现有withDebug实际帧记录nested System.getProperty、StartParameter.systemPropertiesArgs与projectProperties两map、effective installations、实际compiler。原Provider无直接对象帧限制保留，代码/消费值关联不冒称直接观察。现有printCompileClasspath.doLast实际Java8 compiler executable与Java8 metadata languageVersion=8两行必须对应action到达/forwardOutput/stdout，不加探针、不拼旧14条/failed/另一attempt；提前失败/缺帧/未到action/共享语义未决即未完成。
- 逐次保全：新目录内分存离线原始输入/变体/版本/hash/断言与每次原调用命令/cwd、UTC起止/单预算/余量、原始候选/重新认领/attach前身份和监听、退出码/异常链/UnexpectedBuildFailure/失败阶段、日志原字节/解码限制、XML/HTML/fixture/task outcome/JUnit计数及输入/旧证据稳定范围、全部失败和正常build/TestKit/cache副作用。无suite XML则JUnit各计数unknown，不填0、不借旧XML或任务数；记录无输出与原因，不造产物。区分调用/回执/最终采样时点，不把采样当全部落盘精确时刻；原Provider/.git/解码/真实完整停止链未知限制继续披露。
- 冲突与失败效果：与basic产物/remapped/所有共享Gradle/build/TestKit/fixture/cache运行及相关输入写入排他，Forge Test/测试文件观察与写拥有串行，remapped不等待basic成功。某一次完整谓词成立即停止并保全先前失败，新成功仅供本item显式新后继，不回填RECOVERY failed、有限failed、两partial、旧blocked/首轮failed或任一旧gate。工具/离线通过或偶然产物不代替发现或B；独立缺口停止报告，不顺手修项目、扩展工具产品或重放completed效果。

### RECOVER-BASIC-JAVA8-NORMAL-RETRY — 复用工具的独立正常网络再试

**历史 item，已 failed，原完整谓词/前置/预算保留但不再是新路线成功前置。** 非网络 compileJava 失败且缺 compiler 两行；不续旧批次、不回填旧 gate。

- 单一谓词：当前保留接线与某一次新原PatchedMinecraftTests#Test patched Minecraft invocation完整同轮Provider关联→Java17 Test同名属性→basic唯一同名-D→nested System/StartParameter.systemPropertiesArgs及projectProperties/effective installations→现有printCompileClasspath action实际Java8 compiler executable及metadata languageVersion=8、共享Test/withDebug语义全闭合；只完成未完发现D，不证明完整basic产物B或remapped/最终验收。
- 前置item：无额外成功item；唯一归属W-BASIC-JAVA8-NORMAL-RETRY，只等已采用G-REPAIRS。消费已采用token partial、同版实际函数131/131和保留的token/身份/观察纠正/成功接线；旧partial/failed/blocked、取消诊断、产物、remapped及自身gate均不是本项成功前置，不重做工具/离线效果。启动前仍即时核对当前输入/接线/旧证据、串行排他及daemon可用/idle，旧无活动/退出快照不替代当前检查。
- 写入拥有：独立新build证据目录复用已有工具与观察逻辑，必要时只最小绕开旧eligible_retry过严分类并取证；不扩展工具、建立分类引擎/工具产品或新离线检查前置。普通Gradle bookkeeping/module build/TestKit/cache输出变化可正常保留，不需逐文件归属、安全证明或新sideEffectsSafe认证；不是认可具体损坏或允许清理。旧工具/证据/批次不覆盖，不改源码/测试/fixture/basic脚本/接线/consumer/配置/权威/版本/依赖/锁/用户环境/网络/JDK，不增runner框架/探针/替代入口/remapped-D，不清缓存/根clean。
- 正常再试：按[Context当前判据](context.md#正常网络重试决定与当前判据)，当轮实际异常链/日志可识别DNS/UnknownHost或连接超时等网络失败且无明确并存非网络阻断时，前次本轮拥有launcher/worker/debugger/wrapper正向退出、线程/输出收束、无相关监听/冲突、证据分存后可再从原入口调用。普通UncheckedIOException包装不否决、不设包装白名单；unknown cache/抽象影响未知不成为131项缓存审计前置。纯网络早败未到compiler/后续观察不视为非网络故障，不要求旧observationsComplete/freshXml/debugger.finished全为真才重试；真实控制器/观察故障、具体输入或旧证据损坏/漂移、身份/退出不明、明确非网络错误须停止报告，不能以网络掩盖。不需原因诊断、网络恢复证明、端点全成功或逐次批准。
- 单一预算与基本安全：新目录/新batch-start，最多3次实际原basic调用，从首次实际调用起一个1800秒deadline（暂停/观察/间隔/取证/落盘均计入）；deadline前60秒收束、下一轮至少180秒余量，次数/时间不足即停不重置。身份链/attach前同一身份及监听核对不减，必要收束仅针对正向认领的本轮目标，不按名称/端口杀未知进程或daemon；已停旧批次不靠晚到退出重开。不在实际控制器故障后改工具续同批次。
- 同轮证据与逐次保全：保留原jar/printCompileClasspath/-s、Test17/fixture.gradleJava/consumer8、withPluginClasspath/forwardOutput/withDebug(true)和独立TestKit home。每轮分别保存命令/cwd/UTC起止/预算/阶段、原日志/异常链/退出、身份/监听与收束依据、XML有无/实际JUnit计数；无XML记无/unknown，不借旧XML或任务数。普通缓存/构建变化可留不证明fresh compiler或成功；缺compiler只表示D未完。原Provider无直接对象帧、.git/解码/未实测完整停止链限制明示；完整同轮原证据缺一则不能completed，旧17条或其它轮不补本轮缺证。
- 冲突与效果：与basic产物/remapped/所有共享Gradle/build/TestKit/fixture/cache及输入写入排他，remapped不等待basic成功。某次完整D成立就停止并保存先前失败；仅新独立Result供显式后继，不回填token partial/旧failed/partial/blocked/gate。完整B、独立M、最终三模块fresh/Forge三类/根入口/全部当前案例和不同Handler验收不变；具体独立缺口停止报告，不顺手实施另一终态。

### PREPARE-FORGE-PATCH-BASIC — basic 真实私有入口准备 T-basic

**历史 item，generation1 failed。** [原报告](../../../build/prepare-forge-patch-basic-20261023/report.md)及 t9 XML 保留1 test/1 failure/0 errors/0 skipped（Pipe closed）；真实 prepare/reference 及8 CLI成功、LZMA drain 修后仅编译/聚焦检查均不改判。以下原完成合同、W-FORGE-PATCH-FIXTURE-BASIC/G-FORGE-PATCH-FIXTURE-BASIC 原成员/合同及未满足状态完整保留；新恢复不回填、不续原身份，不要求其先转成功。已交付工程/helper/入口复用；其后独立T-basic-r也已failed，当前后继只由新T-basic-v2提供，以下原完整合同保留。

- 单一谓词 T-basic：仅 basicNotch 固定合法输入/真实 task/provider、私有隔离、官方参考 producer/具体可复现见证和实际 JVM 角色准备完整并执行到最终 output；不要求准备输出 namespace 正确，不代 P/consumer。
- 前置item：无额外成功 item；唯一归属 W-FORGE-PATCH-FIXTURE-BASIC，等待 G-REPAIRS；不等 T-1165/T-Neo/P/Q/R 或自己的 gate，无 S/旧实物前置。
- 写入拥有：仅 [Plan 专用 fixture](plan.md#专用真实-fixture-与新鲜证据) 的未来 integration-test/forge/patch-namespace 工程、ForgePatchNamespaceInputs.kt、ForgePatchNamespaceFixtureTests.kt 及本项新 build 证据/私有副本缓存，不写生产/原 caller/consumer/runner、公共 API/依赖/权威或旧证据。后两组重用共同文件，重叠写须串行核对。
- 证据：未来精确 selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'` 的实际源码/执行报告与本组 patchedBasicNotch/referenceBasicNotch provider、userdev3/MCP/clean/binpatch/精确工具、实际 JVM/argv/退出/stage/任务图/最终 output 全关联；[固定来源/参考](plan.md#固定输入与逐分支判定来源) 的 patched 引用方/未补丁接口（含 ICommandSender 关联）及资源见证有独立期望。metadata/task cache、工程/TestKit/Gradle home/output/prepare/fresh/reuse/reference 隔离有证，不以配置/编译/mock 完成。只物化本组，不能由共享配置/BeforeAll/无关 provider 先要求 Java21；完整新增 fixture 类/三方法最终仍由 R/V 全跑，不设为本项 gate。
- 冲突：与其它 T、P/Q/R/D/B/M/V 及共享 Forge/Gradle/TestKit/build/fixture/cache 写运行串行排他，不把冲突改成成功前置。
- 停止/失败：本组真实输入/任务/参考/见证/隔离缺失则未完成；缺所需 JDK 未启动 blocked、实际调用失败 failed，不 skip；保留真实失败及未执行集合，不安装/换版。独立已完整结果不被其它样本失败改判。

### RECOVER-FORGE-PATCH-BASIC-PREPARATION — 固定 basic 未完准备恢复 T-basic-r

**历史item，generation1 failed。** recover-basic-preparation-witnesses的完整采用、678.0457361秒/exit1/1-1-0-0、UnknownHost及未到reference/CLI/判定见[原报告](../../../build/recover-forge-patch-basic-preparation-20261024/report.md)。两个测试文件已修改/编译但新判定未动态执行。以下原完整合同/写边界及原Wave/gate合同保留不满足；不resume、不回填，新验证仅见T-basic-v。

- 单一谓词 T-basic-r：保留已交付 basic 工程/helper/入口、真实输入/独立参考与 LZMA drain 修正，仅纠正未完 fixture 的阶段/空集适用性及 collision clean/patch 合集判定，并在独立新根完整执行现存 basic 方法，取得相互关联的完整准备证据；不重建已交付工程、不代 P/consumer。
- 前置item：无额外成功 item；唯一归属 W-FORGE-PATCH-FIXTURE-BASIC-RECOVERY，等待已采用 G-REPAIRS。消费旧 T-basic failed 的已完成效果/事实而非成功状态；不等旧 item/gate 转成功、P/Q/R、T-1165/T-Neo 或自身 gate。启动前核对当前保留工程/helper/LZMA 修正与固定输入可复用、私有隔离及串行排他；漂移不能在本边界消化则停止报告。
- 写入拥有：仅已存在 ForgePatchNamespaceInputs.kt、ForgePatchNamespaceFixtureTests.kt 的必要私有见证/证据判定接点及本项新 build 证据/私有运行输出；保留 integration-test/forge/patch-namespace 已交付工程，不重建/重放迁移，不改生产/原 caller/consumer/runner、配置/依赖/版本/公共 API/权威/旧证据，不增加样本/JDK 安装/备份或通用框架。
- 验证合同：消费 [Plan 资源阶段及适用性](plan.md#补丁阶段资源范围与固定-basic-空见证适用性)。仅固定 basic merge-clean 无 clean-only 候选、配置 inject/ 而归档无前缀/payload 时可记正向见证不适用，保存完整清单/筛选/阶段/归档身份与覆盖损失，非 skip。碰撞用过滤后 universal 与 clean/patch 合集，空交集仍检查真实 universal-only payload。有候选就验证；1165/Neo 实有载荷不豁免。类/接口/引用/patch checksum/官方参考仍必需，不冒名用 raw 资源、mcinject 文件或 MCP 源码 inject。
- 精确现存 selector：`:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`；本轮完整1 test / 0 failure / 0 errors / 0 skipped、prepare 的真实 provider 最终 output 和独立 reference/各 CLI、JVM/工具/输入/阶段身份与方法 XML/日志必须关联，并产出 prepared.txt、class-witnesses.json、resource-witnesses.json 及完整 inventory/适用性记录。不以只编译/私有函数/旧 t9 task 或 CLI 成功拼成完成；允许正常完整运行重产新鲜 prepare/reference，不复制旧状态。
- T/P 边界：类见证的独立期望/引用/checksum 完整，actual 的 ICommandSender 缺失/bn.class 等只如实观察，不要求 production namespace 内容相等、P 内容或新语义 miss→rebuild→hit 先通过。P 才修这两个生产接点/自有键，P/R 的完整最终内容验证不减。准备结果对 basic clean 非 class 补全、inject 正向复制/冲突无动态覆盖，碰撞空集不证覆盖优先级；P/R/V/H 必须保留这些精确损失。
- 冲突/停止/消费：与1165/Neo扩展、P/Q/R/D/B/M、所有共享 Forge 源/测试/Gradle/TestKit/build/fixture/cache 写运行串行；缺 JDK/输入或真实失败按现有规则 blocked/failed，不 skip、不换版/造资源。完整独立 Result 仅供 P/R/V/H 新后继，不回填旧 T-basic failed 或释放其 gate；生产修正、其它准备/回归与 consumer 仍是各自终态。

### RECOVER-FORGE-PATCH-BASIC-VALIDATION-RETRY — basic未完完整验证的独立有限重试 T-basic-v

**历史item，generation1 failed。** [仓内失败报告](../../../build/recover-forge-patch-basic-validation-retry-20261023/report.md)与[旧观察](../../../build/recover-forge-patch-basic-validation-retry-20261023/final-observation.json)保留准备效果及启动/退出/历史实际总调用unknown；无完整验证，不把原报告“0 attempts/未启动”当确定零调用/零效果/已退出证明。以下原完整谓词/写边界及W-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RETRY/原gate行与不满足完整保留，不resume/reset/续旧次数，不由新成功回填；当前只由新T-basic-v2供显式后继。

- 单一谓词 T-basic-v：保留已交付工程/两个helper-test判定修改/LZMA，某一次新现存basic方法完整运行，固定输入/真实provider/独立官方参考/阶段与适用性/类及资源见证/实际JVM全部同轮闭合；只补未完验证，不重做实现或代P/consumer，一个Handler/一个独立Result。
- 前置item：无额外成功item；唯一归属 W-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RETRY，只等已采用G-REPAIRS及必要当前身份/隔离/输入/资源核对。不等原T-basic/T-basic-r failed或其gate转成功、P/Q/R、T-1165/T-Neo或自己gate；历史状态不代当前排他。复用[四文件身份](../../../build/recover-forge-patch-basic-preparation-20261024/current-implementation-identities.json)，实际漂移/缺权限只报告，不在此修复。
- 写入拥有：只生成独立新build证据及正常私有运行输出/缓存；每轮由既有helper建独立新根，XML/日志/产物按attempt分存，保留旧失败根/证据。不改源码/helper/test/fixture工程/生产/原caller/consumer/runner/配置/依赖/版本/公共API/权威/用户环境/网络/JDK；不复制旧状态补证、备份、清缓存或新增debugger/探针/取证框架/端点预探测，不重做LZMA/两文件修改。
- 有限批次：按[Plan](plan.md#basic-未完完整验证的独立有限重试)，最多3次原selector实际调用，从首次实际调用起一个总30分钟（1800秒）deadline，取证/等待/间隔/收束均计入、不逐次重置、不续旧窗口。每次进入前记录实际剩余及本轮执行/退出/保全限额；不足以执行并确认退出/保存则不再启动，不以最多3次保证跑满。到限前按既有能力仅收束正向识别的本轮目标，身份未知不杀、不再试，不超限或延长验证窗口。
- 再试与停止：仅实际异常链明确临时DNS/UnknownHost/连接超时且无并存明确非网络错误，前次本轮外层/worker/nested调用/wrapper/main等拥有进程正向结束、线程输出收束、证据分存、当前排他及余量足够才再试。共享daemon须即时确认可用/不冲突；历史Kotlin驻留未认证idle不冒称当前idle或必有调用。普通Gradle/TestKit/cache/ruff变化不做逐文件审计/sideEffectsSafe认证，网络早败缺后续证据不阻正常再试；无需网络诊断/恢复证明/逐次批准。明确非网络（含编译/工具/断言/见证）、具体输入/旧证据损坏、真实控制/观察故障、身份/退出不明、冲突或次数/时间到限即停，不修代码后续同批次，不换版本/网络配置。
- 原完整成功证据：精确现存selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`；某轮完整1 test/0 failure/0 errors/0 skipped，prepare真实provider最终output与独立reference全部CLI/输入/工具/JVM/argv/退出/阶段/任务图及最终output、方法XML/日志、prepared.txt/class-witnesses.json/resource-witnesses.json/完整resource-inventory和patch记录全关联。不能以编译、旧t9/8CLI、仅配置/缓存或别轮补证；无XML/退出/产物须明确unknown/未到达，不填0。资源实际空集才可不适用，未执行不算；[阶段/空集及损失](plan.md#补丁阶段资源范围与固定-basic-空见证适用性)、collision clean/patch合集/空集universal-only及1165/Neo实有载荷义务不变。类/接口/引用/checksum独立期望保留，actual缺失/混淆entry如实观察，不要求P namespace/cache先通过。
- 每轮保全与冲突：各轮命令/cwd/源码及fixture身份、独立根/隔离、UTC起止/时长/累计剩余预算、实际计数/outcome/异常链/阶段/未到达、输入/工具/JVM/CLI/输出/完整witness及退出/排他依据分别保存。全批次只认某一轮完整证据，不拼旧或不同轮次，成功即停止且保留先前失败。与全部共享Forge/helper/Gradle/TestKit/build/fixture/cache及输入写运行串行；不因图中展示顺序制造Neo成功屏障或basic/remapped互等。
- 消费/失败效果：完整Result completed/足证据且被采用仅供P/R/V/H新连接；原T-basic与T-basic-r各failed/原完整合同/旧gate不满足全部保留，不resume、不自动回填/释放。原T-basic-r[failed报告](../../../build/recover-forge-patch-basic-preparation-20261024/report.md)与[汇总](../../../build/recover-forge-patch-basic-preparation-20261024/evidence-summary.json)保留两文件已编译而判定未到达事实。未启动缺JDK/权限为blocked，实际调用失败为failed，缺证/上限不completed；不代P/Q/R/D/B/M或最终fresh/不同Handler验收。

### RECOVER-FORGE-PATCH-BASIC-VALIDATION-RECOVERY — 启动控制失败后独立完整验证 T-basic-v2

**历史item，generation1 failed。** run-basic-new-validation-batch实际精确selector1次；内部1200秒WaitForExit=false/Gradle exit=null后脚本主动124，1260秒工具硬限未触发，保存累计1544.712401秒，无XML/计数unknown/完整证据缺失。原完整谓词/写边界及本Wave/gate合同与不满足保留，不resume/续预算；旧后代结束原因仍unknown。最新[采用及诊断](context.md#t-basic-v2-控制失败采用与同-terminal-前台恢复)只定位控制缺口，不证明完整验证或退出；当前显式后继仅由T-basic-v3提供。

- 单一谓词 T-basic-v2：保留工程/helper/test/LZMA及安全复用的已物化输入，某一次新现存basic完整方法取得固定真实输入/provider/独立参考/适用阶段/类资源见证/JVM与身份的全同轮证据，只补未完完整验证。必要短临时调用文本纠正/前检/结束整理和内部attempt仅服务同一结果，无独立工具或attempt消费者，一个Handler/一个独立Result，不代P/consumer。
- 前置item：无额外成功item；唯一归属 W-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RECOVERY，只等已采用G-REPAIRS及下述实际安全/能力条件。不等旧三failed/unknown及其gate先转成功、P/Q/R、T-1165/T-Neo或自身gate；采用与安全边界见[Context](context.md#t-basic-v-启动未知失败采用与新批次边界)，不把旧未获回执当零启动/已退出。
- 写入拥有：只生成新独立build证据根内必要临时调用文本/前检/控制/收束记录及正常私有运行输出/缓存，不重做helper/test/LZMA/fixture/工具或已完成效果。不改源码/测试/工程/生产/caller/consumer/runner/配置/依赖/版本/API/权威/用户网络/JDK/旧证据/旧工具/批次；不复制旧状态补证、备份/清缓存，不增debugger/探针/网络预探测/普通缓存审计/调度器/取证框架。
- 实际启动条件：即时核对共享写运行排他、相关worker/wrapper/GradleMain/控制shell/daemon的真实冲突；每轮全新根内工程、TestKit/Gradle home、metadata/task cache/output真实隔离，当前保留实现与已物化输入identity/完整性/复用安全须实际验证。旧采样只证当时未见活动，不倒推历史退出/未来安全，用户重试不代证。具体未知效果仍可能冲突、已证风险无安全路径或能力不足即停止精确报告，不改图绕过，不要求永久历史清零。
- 最小控制与预算：按[Plan新批次](plan.md#basic-启动控制失败后的独立完整验证新批次)将前检、短且闭合可解析的完整启动/有界等待、结束整理分开；完整command与对应toolResult/实际进程证据须可关联，timeout为真实工具参数。启动前核实完整可观测控制、实际工具时限及有界收束能力，不用字符串内timeout/无回执冒充执行。新目录/new batch-start，最多3次原selector实际调用，首次实际调用起单一1800秒deadline覆盖执行/等待/间隔/退出收束/保存，每轮实际执行/保存限额受同一剩余约束；至少预留60秒收束，下一轮至少180秒且足够执行/退出/保存才启动。控制/解析/回执/身份/退出unknown即停，不记确定0调用后续跑、不延长验证窗口。
- 再试与停止：仅实际异常链明确临时DNS/UnknownHost/连接超时且无并存明确非网络错误，前次本轮外层/worker/nested调用/wrapper/main等拥有进程正向结束、线程输出收束、证据分存、当前排他及余量足够才再试。共享daemon须即时确认可用/不冲突；历史Kotlin驻留未认证idle不冒称当前idle或必有调用。普通Gradle/TestKit/cache/ruff变化不做逐文件审计/sideEffectsSafe认证，网络早败缺后续证据不阻正常再试；无需网络诊断/恢复证明/逐次批准。明确非网络（含编译/工具/断言/见证）、具体输入/旧证据损坏、真实控制/观察故障、身份/退出不明、冲突或次数/时间到限即停，不修代码后续同批次，不换版本/网络配置。
- 原完整成功证据：精确现存selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`；某轮完整1 test/0 failure/0 errors/0 skipped，prepare真实provider最终output与独立reference全部CLI/输入/工具/JVM/argv/退出/阶段/任务图及最终output、方法XML/日志、prepared.txt/class-witnesses.json/resource-witnesses.json/完整resource-inventory和patch记录全关联。不能以编译、旧t9/8CLI、仅配置/缓存或别轮补证；无XML/退出/产物须明确unknown/未到达，不填0。资源实际空集才可不适用，未执行不算；[阶段/空集及损失](plan.md#补丁阶段资源范围与固定-basic-空见证适用性)、collision clean/patch合集/空集universal-only及1165/Neo实有载荷义务不变。类/接口/引用/checksum独立期望保留，actual缺失/混淆entry如实观察，不要求P namespace/cache先通过。
- 保全/冲突：另逐轮分存源码/fixture/输入和进程identity、真实隔离/复用依据、实际工具参数/回执、命令/cwd/UTC起止/累计剩余预算、结果/异常链/未到达、witness/输出及正向退出收束记录。全批次只认某轮完整证据，不拼旧或不同轮次、不skip；成功即停并保留此前失败。与所有共享Forge/helper/Gradle/TestKit/build/fixture/cache及输入写运行串行，不增Neo/Java8共同屏障。
- 消费/失败效果：完整Result completed/足证据且完整采用仅供P/R/V/H新连接；旧T-basic/T-basic-r/T-basic-v各failed/原完整合同/旧gate不满足及T-basic-v历史调用/启动/退出unknown全部保留，不resume/reset/续旧次数，新成功不抹unknown或回填旧gate。未启动缺JDK/权限/安全能力为blocked，实际调用失败为failed，缺证/上限不completed，不代P/Q/R/D/B/M、最终fresh或不同Handler验收。

### RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION — 同 terminal 前台生命周期的独立完整验证 T-basic-v3

**已采用generation1 completed。** [原报告](../../../build/recover-forge-patch-basic-foreground-validation-20261023-1751/report.md)第二轮完整1/0/0/0及真实prepare/provider/reference8CLI/同轮见证齐全；首轮DNS失败及四个旧failed/历史unknown保留。Router已释放本单成员gate供原P，本次仅登记采用、不重新释放。以下原合同保留，不要求重跑准备，不代P内容/cache。

- 单一谓词 T-basic-v3：复用工程/helper/test/LZMA/fixture和安全输入，某一次新的现存basic完整方法取得固定真实输入/provider最终output/独立参考/适用阶段/类资源见证/JVM/身份的全部同轮证据，只补未完完整验证，不代P/consumer。必要薄控制/取证和内部attempt仅服务一个item/Handler/Result，无独立消费者，不重做已完成实现。
- 前置item：无额外成功item；唯一归属 W-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION，只等已采用G-REPAIRS及下述实际安全/能力条件。不等旧T-basic/T-basic-r/T-basic-v/T-basic-v2各failed或其gate先转成功，不等P/Q/R、T-1165/T-Neo或自己gate。采用见[Context](context.md#t-basic-v2-控制失败采用与同-terminal-前台恢复)；历史unknown不永久阻无冲突隔离新验证，也不因用户重试/旧无PID采样自动清除。
- 写入拥有：仅新独立build证据根内必要薄入口/本轮控制取证和正常私有运行输出/缓存；复用已交付实现/固定安全输入，不改旧run.ps1/工具/证据/批次、项目源码/helper/test/LZMA/fixture/caller/consumer/runner/配置/依赖/版本/API/权威/用户网络/JDK。不复制旧状态补证/备份/清缓存，不增debugger/探针/网络探测或原因诊断/普通缓存审计/取证框架/清理器/调度器。
- 实际启动条件：即时确认共享Forge/helper/Gradle/TestKit/build/fixture/cache及输入写运行排他、相关worker/wrapper/main/shell/daemon无实际冲突；每轮工程/TestKit/Gradle home/metadata-task cache/output真实隔离，当前实现/输入identity完整性与复用安全、完整可观测控制和真实工具硬限能力须实际核对。目录名/旧采样不是永久锁，具体风险无安全路径/能力不足即停止精确报告，不改图绕过。
- 最小同terminal控制：按[Plan](plan.md#basic-控制提前退出后的同-terminal-前台验证)，删除中间Start-Process＋WaitForExit false先exit124分叉，优先同一bash terminal前台同步调用原gradlew/argv；必要PowerShell薄入口仅环境准备、前台正常返回后立即记录/原样转发真实退出码。短yield不是短进程生命周期；terminal_wait只等同一terminal，一次wait尚未结束不重启/不算新调用。正常返回须关联真实wrapper/Gradle退出和输出收束；工具超时/强制中断只记工具事实，真实Gradle退出缺失写unknown、不造124或其它正常码，不保证强制终止后一定有正常退出码，控制/身份/退出未知仍停，不凭PID消失再试。不追查旧执行端清理原因。
- 单一预算：新根/new batch-start，最多3次现存完整selector实际调用，首次实际调用起单一1800秒覆盖执行/等待/间隔/退出收束/保存，不resume或重置。每次启动记录剩余及执行/收束/保存限额；真实工具timeout作为实际参数，从剩余扣出至少60秒收束和另行合理保存余量，不把1800全跑完才保存，不以单纯增大1200解决机制。下一轮至少180秒且实际执行/确认退出/分存够用才启动；到限按既有安全能力只收束正向拥有目标，未知不杀/不扩工具、不延长窗口。
- 再试与停止：仅实际异常链明确临时DNS/UnknownHost/连接超时且无并存明确非网络错误，前次本轮外层/worker/nested调用/wrapper/main等拥有进程正向结束、线程输出收束、证据分存、当前排他及余量足够才再试。共享daemon须即时确认可用/不冲突；历史Kotlin驻留未认证idle不冒称当前idle或必有调用。普通Gradle/TestKit/cache/ruff变化不做逐文件审计/sideEffectsSafe认证，网络早败缺后续证据不阻正常再试；无需网络诊断/恢复证明/逐次批准。明确非网络（含编译/工具/断言/见证）、具体输入/旧证据损坏、真实控制/观察故障、身份/退出不明、冲突或次数/时间到限即停，不修代码后续同批次，不换版本/网络配置。
- 原完整成功证据：精确现存selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`；某轮完整1 test/0 failure/0 errors/0 skipped，prepare真实provider最终output与独立reference全部CLI/输入/工具/JVM/argv/退出/阶段/任务图及最终output、方法XML/日志、prepared.txt/class-witnesses.json/resource-witnesses.json/完整resource-inventory和patch记录全关联。不能以编译、旧t9/8CLI、仅配置/缓存或别轮补证；无XML/退出/产物须明确unknown/未到达，不填0。资源实际空集才可不适用，未执行不算；[阶段/空集及损失](plan.md#补丁阶段资源范围与固定-basic-空见证适用性)、collision clean/patch合集/空集universal-only及1165/Neo实有载荷义务不变。类/接口/引用/checksum独立期望保留，actual缺失/混淆entry如实观察，不要求P namespace/cache先通过。
- 逐轮保全与冲突：分别保存源码/fixture/输入及拥有身份、真实隔离/安全复用依据、完整命令/argv/cwd/同一terminal及工具参数/回执、真实返回或中断/输出收束、UTC起止/累计剩余/预算分配、实际结果/异常/阶段/未到达、全部输出与witness。某轮完整成功即停且保留先前失败，不拼旧或不同轮、不skip、未运行不记不适用。与所有共享Forge/helper/Gradle/TestKit/build/fixture/cache及输入写运行串行；不增Neo或R对Java8路线的共同成功屏障。
- 消费/失败效果：仅本独立完整Result completed/足证据且被完整采用供P/R/V/H新连接；旧T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及全部原谓词/Wave/gate合同/不满足、T-basic-v历史调用/启动/退出unknown、T-basic-v2真实Gradle退出/后代结束原因unknown保留，新成功不回填/不清unknown/不续旧预算。未启动缺JDK/权限/安全能力为blocked，实际调用失败为failed，缺证/上限不completed；不代Q/D/B/M、最终全量fresh/根入口或不同Handler验收。


### PREPARE-FORGE-PATCH-1165 — 1.16.5 真实私有入口准备 T-1165

- 单一谓词 T-1165：forge1165Mcinject 固定输入/真实 provider、独立官方参考与具体见证/私有隔离/JVM 准备完整并执行到最终 output；不证明 namespace 已修正，不代 Q-1165/M。
- 前置item：无额外成功 item；唯一归属 W-FORGE-PATCH-FIXTURE-1165，等待 G-REPAIRS，不等 basic/Neo 准备、P/Q/D/B/M/R 或自己 gate。
- 写入拥有：复用已交付专用私有 fixture/helper/入口，按最新内容串行仅补本组、新证据/私有输出；保持 basic 独立恢复合同/可独立 selector，不重建已交付工程；不改生产/原 caller/consumer/runner/版本/依赖/公共 API 或旧证据。
- 证据：未来精确 selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesForge1165McinjectWithPrivateCache'`，实际 patchedForge1165Mcinject/referenceForge1165Mcinject、36.2.39 userdev/MCP1.16.5-20210115.111550/真实 clean/1.0.12 binpatcher/rename-mcinject/overlay/AT/libraries 输入身份、命令/JVM/退出/stage/任务图/最终 output；按 Plan 独立参考推导 patched/未补丁引用/优先级/资源见证并证明各层私有隔离。只物化本组，不以 Neo 工具/JDK/完整类成功为前置；完整类最终由 R/V 保留。
- 冲突：与其它 T/P/Q/R/D/B/M/V、共同 fixture/helper/Forge/Gradle/TestKit/build/cache 写运行全部串行。
- 停止/失败：本组来源/参考/见证/真实执行或隔离不闭合不 completed，缺 JDK 准确 blocked/failed，不以其它组成功/编译或 skip 代证；未证能力只报告，不越界。

### PREPARE-FORGE-PATCH-NEO — Neo 私有样本真实入口准备 T-Neo

- 单一谓词 T-Neo：neo121NoMcinject 固定真实输入/provider/官方参考/具体见证/私有隔离/实际 Java21 角色准备完整并执行到最终 output；不代 Q-Neo/R，不宣称生产平台支持扩张或旧 attrs 等价。
- 前置item：无额外成功 item；唯一归属 W-FORGE-PATCH-FIXTURE-NEO，等待 G-REPAIRS，不等另外两组/P/Q/R/D/B/M 或自己 gate。
- 写入拥有：相同专用私有 fixture/helper/入口范围按最新内容串行补本组、新证据/私有缓存输出；不写生产/Dist 修复、原 consumer/runner/JDK/配置/依赖/公共 API 或旧证据。
- 证据：未来精确 selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache'`，实际 patchedNeo121NoMcinject/referenceNeo121NoMcinject、MC1.21/NeoForge21.0.76-beta/NeoForm1.21-20240613.152323、实取 userdev/clean/提取 server/mappings/工具/libraries/modules/overlay/AT 身份与 Java21 选择、实际 argv/退出/stage/任务图/最终 output、独立 official 参考及具体引用/资源见证/各层隔离。没有 old 根/旧 attrs/旧 cache 对照；完整 fixture 类/三方法由 R/V 汇合。
- 冲突：与所有共同 fixture/helper/Forge/Gradle/TestKit/build/cache 写运行串行，独立不表示并跑。
- 停止/失败：缺21未能启动为 blocked，已调用失败为 failed；其它缺输入/见证/真实执行同样不满足，不 silent skip/partial 当成功。只阻本组和真实后继，不取消另两组或具备自身前置的 Java8 路线，不安装 JDK/改 runner。

### RECOVER-FORGE-PATCH-NEO-PREPARATION — 未完T-Neo独立恢复

**历史：generation1已failed。** 名称纠正已生效、stage2通过，随后真实Maven连接超时；本项及旧gate不满足永久保留。下述写拥有仅是当时授权，不再执行源码纠正或消费本项成功；现行仅由新运行恢复承接未完T-Neo。

- 历史输入：PREPARE-FORGE-PATCH-NEO generation1 failed、旧 G-FORGE-PATCH-FIXTURE-NEO 不满足；三份已写私有 fixture/helper/test、compileTestKotlin通过及已实取固定输入保留。依据[报告](../../../build/prepare-forge-patch-neo-20261026-g1/report.md)和[验证](../../../build/prepare-forge-patch-neo-20261026-g1/verification.json)，没有失败后修正或重试；这是 Router 后续独立授权的恢复，不延续旧 Handler 或改写真实失败停止规则。
- 单一谓词：完整满足上方原 T-Neo 所述固定真实输入/provider/独立official参考/具体见证/私有隔离/实际Java21角色及最终output准备要求；名称修正和必要编译仅为内部步骤，不代Q-Neo/R。
- 前置item：无额外成功item；唯一归属 W-FORGE-PATCH-FIXTURE-NEO-RECOVERY，等待 G-REPAIRS（已采用满足），不等旧failed或旧gate转成功、不等自身gate、P/Q/R/D/B/M及另两组。
- 写入拥有：仅 minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts 新增fixture已定位的java.nio.file名称解析冲突（使用明确import/别名等最小纠正），以及本结果必要新证据和正常私有输出/cache；保留其它有效实现和固定输入。helper/test及生产/Dist/原consumer/runner/JDK/用户配置/依赖/API/旧证据不改；无新研究、验证框架、全量快照或自证义务。
- 验证：原精确 preparesNeo121NoMcinjectWithPrivateCache selector 必须真实Gradle exit0、JUnit1/0/0/0，原T-Neo全部固定来源/实际Java21工具选择/patch-provider/reference/argv/退出/stage/任务图/最终output/class与resource witnesses/prepared及隔离证据同轮关联。候选java-version可运行、源码已写、compile通过、目录存在或其它组成功均不能代证；Q-Neo完整内容/冷热缓存合同仍由Q承担。
- 冲突/停止：共享fixture/helper/Forge/Gradle/TestKit/build/cache写运行串行，按最新内容保留已过效果，不重跑basic/1165/remapped；即时必要排他/身份/退出及输出保全保留。真实失败、未知或范围不足按原规则停止，不引入一般连续重试；历史三次LSP unknown不改判。
- 消费：仅本新独立Result completed/足证据且Router完整采用才可供新gate与显式Q-Neo/R/V/H输入；旧failed和旧gate永不回填。本次文档维护不执行item、不判ready或释放gate。

### RECOVER-FORGE-PATCH-NEO-VALIDATION — 仅未完T-Neo运行恢复

**历史：generation1已failed，真实累计三次Neo调用/三次failed。原合同和旧gate不满足保留，不再成功等待或续跑；当前只按页首新代理范围准备，未确认实施。**

- 单一谓词：在已生效名称纠正和两个Neo failed保留之上，取得上方原T-Neo全部完整准备；一个新Handler/独立Result，仅运行，不代Q-Neo或R。
- 前置item：无额外成功item；唯一归属W-FORGE-PATCH-FIXTURE-NEO-VALIDATION，只等已采用满足G-REPAIRS及实际启动安全条件，不等两个旧failed/旧gate、自己gate、P/Q/R/D/B/M或另外两组。
- 写拥有：仅新build证据根内必要薄运行入口/报告及正常私有输出/cache；fixture/helper/test/源码/生产/用户配置/仓库/代理/JDK/依赖/Git/旧证据全部不改，不重做名称纠正或已过basic/1165/remapped。
- 唯一调用：`:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache'`，至多一次，失败/unknown立即停止并保全，不同批连续重试、不网络预探测/诊断。累计保留原PREPARE一次和名称恢复一次，本次至多一次，不以新ID重置直接适用次数限制；若有直接适用上限/授权不足准确blocked，不套用P/basic历史预算、不造Neo分钟规则。
- 启动/冲突：当前核对上一实际目标已结束/输出保存、共享Forge/helper/fixture/Gradle/TestKit/build/cache与输入写资源无冲突、真实控制身份及可观测实际退出/保全能力。旧JVM空数组不代当前检查；普通缓存记账不做新增逐文件副作用审计，历史三次LSP unknown保留。所有共享写运行串行，独立不表示并跑。
- 成功证据：同轮原selector真实Gradle exit0、JUnit1/0/0/0，上方T-Neo固定输入/真实provider/实际Java21工具角色/独立official参考/具体类接口引用与资源见证/适用AT及Dist-marker原边界/完整隔离/prepared/最终output，以及命令/输入/工具/JVM/argv/阶段/任务图/日志/退出收束全关联。未到达不记不适用，不拼旧轮/skip，网络早败不假充成功；Q-Neo完整内容和冷热缓存仍另验。
- 消费：只有本新完整Result completed/足证据且Router完整采用才供新gate及显式Q-Neo/R/V/H；原两个failed/旧gate不满足永不回填。未启动缺能力/权限/JDK为blocked，实际调用失败为failed，unknown或缺证不释放。本轮仅维护文档不运行、不宣称ready或自行调度。

### FIX-FORGE-PATCH-NAMESPACE — 共同生产修正及 basic 完整可消费结果 P

**已采用generation1 partial，原完整谓词/原gate仍不满足。** [原报告](../../../build/fix-forge-patch-namespace-20261023-1830/report.md)保存补全时机/去late-copy、版本7→8、编译成功及新游戏类/ICommandSender/25资源改善；三次selector均1/1/0/0，第三次provider成功但reference DNS失败、8CLI未执行。792 overlay类obf及完整reference/AT/body/cache缺证；[错误见证](../../../build/fix-forge-patch-namespace-20261023-1830/known-overlay-namespace-limit.json)与已采用诊断见Context。本item/Wave/gate及以下完整原谓词不覆写、不重跑/续预算；新P-recovery成功不回填。

- 单一谓词 P：两个既定生产边界与语义键共同完成更正（资源仅为实际补丁输入阶段完整内容及后续合法工具/overlay，不新增 raw 恢复；固定 basic 适用性及损失按 Plan，不豁免类/引用/实有 payload），basic 真实最终 patched 定义优先、未补丁接口/类的 entry/this_class/descriptor/reference/目标 namespace 及资源/适用 overlay/AT 完整正确，forge 实际有效完整路径隔离，新语义 miss→真实 rebuild→同输入同版 hit/内容均有证。不能以编译、diff 或 partial 完成，也不称关联/Neo 已验证。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（完整采用/completed/足证据）；唯一归属 W-FORGE-PATCH-NAMESPACE，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及各自旧gate转成功、三组聚合准备、T-1165/T-Neo、Q/R/D/B/M 或自己 gate；T-basic-v3 先于首次生产编辑，无 S/旧实物封存。
- 写入拥有：只生产 McpAction.kt 的 patch/rename/内部 PatchResult 交接及 ResolvePatchedMinecraft.kt 的 late-copy/PATCH_OPERATION_VERSION/等效键，不改公共 API/版本/依赖/原 caller/consumer/runner/网络/JDK/权威/旧证据。图维护不授予实施许可。
- 证据：按 [Plan P](plan.md#生产修正-p-的所有权与一个完成谓词) 从 T-basic-v3 验证的既有真实 provider 取新鲜最终 output，对独立官方参考/固定映射/具体 patched 与未补丁接口及资源见证；完整 namespace/引用/优先级/overlay/AT 内容与源码/fixture/输入身份关联。统一新语义值及两族使用静态核对，basic 的实际 forge operation/完整 key/basename/path 与旧语义隔离，私有新 key 初始不存在→Cache miss/工具生成/最终内容→同输入同版 Cache hit/一致内容闭合。P 不要求 neoforge 实际路径/三组缓存全齐；Q 各证明剩余真实分支，最终仍必需。无旧实物不证明历史动态拒绝/替换或旧 final 重放；仅外层重跑/能打开/版本变化不足，不代 Q/R/D/B/M。
- 冲突：与其它 T/Q/R/D/B/M/V、共享 Forge 源/测试/Gradle/TestKit/build/cache/fixture 写运行串行；实际内容绑定后继，新写漂移须重核受影响证据，不能把旧成功泛化到新内容。
- 停止/失败：basic 全内容/缓存或两个诊断边界/静态关联保留不能闭合、权威被推翻即具体 blocked/failed；不以“待 Neo 实跑”本身判 P 未完成，也不隐藏已知关联破坏。不升级/扩 API/填接口/改 consumer 绕过。

### RECOVER-FORGE-PATCH-OVERLAY-CONTENT — 原完整 P 可消费结果恢复 P-recovery

**已采用generation1 partial，原完整合同/未满足gate保留。** 两owner/version9及cache输入已完成；完整独立oracle与同路径hit未完成，Object父集误断言/重复目录exit1及deadline后postprocess事实见[Context](context.md#overlay-恢复-partial-采用与未完验证边界)。下述是前轮原合同，不授予本次再改生产；未完验证仅由新P-v补证，旧项不转completed。

- 单一谓词：在原P已完成效果之上，必要notch overlay类型/继承成员namespace纠正、两owner内部交接/专属新语义键和fresh basic全部原内容/cache验收共同恢复一个可消费结果。真实final的游戏类/完整接口、entry=this_class、descriptor/super/interfaces/成员引用/namespace、patched及overlay优先级、适用资源/inject/AT/marker完整正确，并在同输入同新语义的实际完整有效路径miss→真实rebuild→hit/内容闭合。编译、局部名称修正/792→0/partial均不能完成，不代Q/R/D/B/M。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-CONTENT，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P/旧G-FORGE-PATCH-NAMESPACE、自己gate、T-1165/T-Neo/Q/R/D/B/M；不重跑T-basic-v3或游戏补全/去late-copy已完成独立效果。
- 保留输入（非成功前置）：FIX-FORGE-PATCH-NAMESPACE generation1 partial的已完成效果和当前身份，不要求该item/旧gate先成功。
- 写入拥有：仅原生产McpAction.kt的patch/rename/内部PatchResult所需交接，ResolvePatchedMinecraft.kt的universal overlay交接/专属PATCH_OPERATION_VERSION或等效键；新build证据根可有本结果内部必要验证薄接线和正常私有输出/cache。非授权修改公共fixture/helper/test/consumer/API/依赖/Dist/Core.Cache或旧脚本/报告/Result，不因同两个文件而扩其它行为。当前Handoff只写四文档，不授予实施。
- 机制/停止选择：按[Plan恢复策略](plan.md#overlay-完整结果恢复策略)锁定固定SpecialSource:1.8.3:shaded未reverse的obf→SRG原rename参数加 `--live`；显式classpath为工具、filtered raw universal class、同次notch完整patch后/rename前游戏G、内容摘要规范序的既有libraries及其余fixedPatches（Java8启动资源仍优先）。McpAction内部PatchResult保留同次G/mapping/rename配置/fixedPatches，Resolve提供已有libraries/filtered U并在原overlay位置消费规范化class，不从最终SRG Path推回原始层次或把listLibraries文本当classpath。保持Forge自身名、原mcinject适用域/overlay→inject→AT→适用Dist→marker、filters/碰撞及覆盖优先级；资源/内置映射不文本替换，non-notch/Neo不无条件重复转换。Plan已给实际工具字节码/输入/闭包依据，不再把入口选择留给未来；动态CLI/完整验收仍未运行。前移class至rename前替代路径仍blocked，不静默切换；缺输入/权限/能力报告精确blocked，实际运行失败如实记失败，越公共测试边界先报。
- 证据：复用真实provider取fresh最终output，保存代码/fixture/固定输入/工具/JVM/命令/阶段/退出/产物身份。除IClientCommand保持Forge名、bk→ICommand及bn→ICommandSender外，锁定原ClientCommandHandler extends bj且无b声明、a(Lbn;Ljava/lang/String;)I原offset59的invokevirtual Forge-owner.b()Ljava/util/Map;；原始clean/patch中bj声明及fixed-mapping.tsrg:1132/1144独立给出期望：保留Forge调用owner，name为func_71555_a、descriptor不变，super为CommandHandler。完整overlay的独立reference按Plan从raw universal/独立patch-obf＋clean-minus-deleted/库/Java8声明取头闭包，以原mapping＋非映射类identity副本生成target/SRG单空格继承表（2448声明节点、2447条有父记录，每行至少两token；唯一无父Object保留identity/终点但不输出行，无live时input JarProvider缺失null→setParents(null)缓存空父集，禁止self-parent；child/parent inverse失败均报错，不丢弃/过滤），固定工具用 `--read-inheritance` 经mapping inverse还原，**无live/生产G/生产classpath/helper**；两锚点期望不从工具输出反推。保存增强映射、继承表、producer及逆向核对，完整class语义＋适用AT闭合；不照抄生产merge/自证golden/raw-universal+AT相等，不拿旧8CLI/旧DNS失败/792计数补证。资源oracle分离；游戏clean/patch参考、完整11方法接口、patched优先、25资源/filters、basic真空集及collision空交集清单/损失全保留并关联新身份。原完整内容与[Plan原P谓词](plan.md#生产修正-p-的所有权与一个完成谓词)不降低。
- 缓存证据：新语义与已知不完整8及历史7导出operation/聚合key/basename/完整path隔离，静态核对两族使用；Resolve自定义cache原patches集合须闭合新增universal/libraries读取及内容确定的classpath顺序，不只依赖Gradle外层输入，不以临时G/U路径作key，不改Core.Cache；basic私有新key可证不存在→真实Cache miss/工具rebuild/完整oracle→同输入同新语义/同有效缓存path真实hit及输出语义一致，记录两次task action/日志/路径。不能以外层rerun、仅版本diff、改输入或不同有效路径代证，不清缓存/造旧实物。non-notch/Neo实际路径/cache由各Q另证，不加三组全成功门槛。
- 冲突：与原两owner及所有共享Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行串行排他；实际内容绑定后继，漂移须复核/重取受影响Q/D/B/M证据，不泛化旧成功。
- 失败/消费边界：reference DNS/工具未跑/AT/body/继承成员/资源/cache任一缺证不满足，未运行不记不适用、不删断言。工具/权限/authority重要缺口blocked报告，已尝试失败/有用未完按真实Result记录；不改原P partial/旧gate或failed/unknown。仅本项completed且足证据才供新gate和Q/R/D/B/M/V/H完整P消费；诊断completed、作者自检或准备completed不代证。

### RECOVER-FORGE-PATCH-OVERLAY-VALIDATION — 仅未完完整oracle与同路径hit恢复 P-v

**历史 item：verify-forge-overlay-content-cache generation1 failed；原完整合同和 gate 不满足保留，不续预算。** 首次辅助文件读取 FileNotFoundError/exit1，80.054秒保存收束；Gradle/网络/reference/oracle/编译/hit均0次。不是生产缺陷或漂移证明；未来只由独立 P-v2 补未完验证。

- 单一谓词：在已完成version9实现及可核验原fresh/miss效果之上，完整独立class/body/继承成员/适用AT/游戏保持/优先级/资源oracle与同输入同语义同有效路径真实hit及再次完整oracle共同闭合原完整P；缺任一不完成，不代Q/R/D/B/M。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-VALIDATION，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P或P-recovery/两个旧不满足gate、自身gate、T-1165/T-Neo/Q/R/D/B/M。
- 保留输入（非成功前置）：原P与P-recovery各generation1 partial、T-basic-v3已完成效果；核对[原退出/身份证据](../../../build/recover-forge-overlay-content-20261024-0515/completion-evidence.json)及[新Plan策略](plan.md#overlay-未完验证的有界恢复策略)，实际源码/加载插件classes/runtimeClasspath/fixture/输入/工具/JVM及原fresh/miss产物和有效cache路径均须当前可检查且排他关联，不能拿旧未通过reference或跨身份拼接。
- 写入拥有：仅新build证据根内必要薄工具/离线核对/合法运行输出；源码两个owner/current version9、公共fixture/helper/test/API/consumer/依赖/非notch/Neo及旧证据全部只读。目录/工具纠正只服务同一验证，无独立工具阶段/框架/Result；不重做live overlay/补全/去late-copy/cache实现，发现实际实现问题只报告不修。
- 内部纠正与证据：新根原始class精确断言 IClientCommand super=java/lang/Object、interfaces={bk}、完整parents={java/lang/Object,bk}；同实际函数真实正例与缺父/额外父/inverse错误负例，不忽略父类。全部2448声明/2447有父记录、Object终点/无self-parent、完整target继承表与identity增强mapping/inverse规则保持；新空输出目录的实际准备函数首次/重复行为离线核对，不再因oracle-classes重复mkdir失败、不删旧目录。按Plan重建独立reference，不用live/生产G/生产classpath/helper或旧未通过输出；完整class/body/成员及适用AT、独立两锚点、游戏/11方法接口、patched/overlay优先、25资源/filters/空见证及覆盖损失全部逐项验证，不以基本1/0/0/0、8CLI或局部计数替代。
- 缓存/产物证据：保留新鲜9,912,576 bytes、SHA256 `175ecc9d748dc8d3acd2033c5807d247b76eaf4b929be97ee1c2be26d13e69c8` 的原第二轮真实forge-patch-9/17070801 miss/rebuild，核验初始不存在/实际operation/聚合key/basename/绝对path及命令输入。身份不足即不复用/不满足；本轮不假称重新cold。新根project/输出/日志但有效metadata/cache根与task配置不变，真实patched provider task action再次到达同path lookup并hit；前后cache/新provider final分层记录、hit final完整oracle通过且与fresh内容一致。UP-TO-DATE/不同key/path/搬cache/重新miss不算hit，不清缓存/伪造基线；原完整fresh合同不削弱。
- 时钟/退出/停止：一个全新1800秒deadline，从首个实际调用（含离线预检/编译/CLI）前计时，全部验证/hit/postprocess/报告落盘均计入；至少60秒收束并另留足够报告保存余量、每次timeout扣余量、下一次网络运行至少180秒并能容纳后续检查。真实前台terminal/argv/UTC/耗时/退出，terminal_wait不重启；最多3次真实网络运行，前次正向退出/收束/分存/当前排他/预算足够且只有明确临时网络才再试；任何非网络/目录/内容/身份/退出unknown/具体损坏或上限即停。保留旧deadline后调用违规事实，不能续旧预算/超时后继续postprocess算合法成功，无端点预探测/逐项cache审计。
- 冲突：与两个owner、全部共享Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行串行，执行即时核对排他，历史idle不作当前锁；漂移即复核/重取受影响证据，本项不授予修实现权限。
- 失败/消费：输入/权限/authority不足报告具体blocked，实际非网络失败停止如实failed/partial，缺任一完整证据不满足。只有本项独立Result completed/足证据且被采用才供新gate及Q/R/D/B/M/V/H完整P消费；原P/P-recovery各partial及各旧gate不满足不回填，本次作者维护不完成item/释放gate。

### RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY — 仅未完完整oracle与同路径hit恢复 P-v2

**历史 item：P-v2 generation1 failed，原完整合同/Wave/gate不满足保留，不续预算。** hash复验前预检误拒；以下准备文字仅指当时，见[采用事实](context.md#p-v2-尾窗误拒与恢复依据)。 输入定位按 [已核实导航](context.md#p-v-失败采用与原证据定位纠正)，是本完整验证内部步骤，不设探索/工具结果。不等待旧 P-v failed 或其 gate；原 review-forge-overlay-validation-recovery generation1 对未变完整策略的 ready 支持沿用，仅本次定位/新恢复连接待局部独立复审。

- 单一谓词：在已完成version9实现及可核验原fresh/miss效果之上，完整独立class/body/继承成员/适用AT/游戏保持/优先级/资源oracle与同输入同语义同有效路径真实hit及再次完整oracle共同闭合原完整P；缺任一不完成，不代Q/R/D/B/M。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P或P-recovery/两个旧不满足gate、自身gate、T-1165/T-Neo/Q/R/D/B/M。
- 保留输入（非成功前置）：原P与P-recovery各generation1 partial、T-basic-v3已完成效果；核对[原退出/身份证据](../../../build/recover-forge-overlay-content-20261024-0515/completion-evidence.json)及[新Plan策略](plan.md#overlay-未完验证的有界恢复策略)，实际源码/加载插件classes/runtimeClasspath/fixture/输入/工具/JVM及原fresh/miss产物和有效cache路径均须当前可检查且排他关联，不能拿旧未通过reference或跨身份拼接。
- 写入拥有：仅新build证据根内必要薄工具/离线核对/合法运行输出；源码两个owner/current version9、公共fixture/helper/test/API/consumer/依赖/非notch/Neo及旧证据全部只读。目录/工具纠正只服务同一验证，无独立工具阶段/框架/Result；不重做live overlay/补全/去late-copy/cache实现，发现实际实现问题只报告不修。
- 内部纠正与证据：新根原始class精确断言 IClientCommand super=java/lang/Object、interfaces={bk}、完整parents={java/lang/Object,bk}；同实际函数真实正例与缺父/额外父/inverse错误负例，不忽略父类。全部2448声明/2447有父记录、Object终点/无self-parent、完整target继承表与identity增强mapping/inverse规则保持；新空输出目录的实际准备函数首次/重复行为离线核对，不再因oracle-classes重复mkdir失败、不删旧目录。按Plan重建独立reference，不用live/生产G/生产classpath/helper或旧未通过输出；完整class/body/成员及适用AT、独立两锚点、游戏/11方法接口、patched/overlay优先、25资源/filters/空见证及覆盖损失全部逐项验证，不以基本1/0/0/0、8CLI或局部计数替代。
- 缓存/产物证据：保留新鲜9,912,576 bytes、SHA256 `175ecc9d748dc8d3acd2033c5807d247b76eaf4b929be97ee1c2be26d13e69c8` 的原第二轮真实forge-patch-9/17070801 miss/rebuild，核验初始不存在/实际operation/聚合key/basename/绝对path及命令输入。身份不足即不复用/不满足；本轮不假称重新cold。新根project/输出/日志但有效metadata/cache根与task配置不变，真实patched provider task action再次到达同path lookup并hit；前后cache/新provider final分层记录、hit final完整oracle通过且与fresh内容一致。UP-TO-DATE/不同key/path/搬cache/重新miss不算hit，不清缓存/伪造基线；原完整fresh合同不削弱。
- 时钟/退出/停止：一个全新1800秒deadline，从首个实际调用（含离线预检/编译/CLI）前计时，全部验证/hit/postprocess/报告落盘均计入；至少60秒收束并另留足够报告保存余量、每次timeout扣余量、下一次网络运行至少180秒并能容纳后续检查。真实前台terminal/argv/UTC/耗时/退出，terminal_wait不重启；最多3次真实网络运行，前次正向退出/收束/分存/当前排他/预算足够且只有明确临时网络才再试；任何非网络/目录/内容/身份/退出unknown/具体损坏或上限即停。保留旧deadline后调用违规事实，不能续旧预算/超时后继续postprocess算合法成功，无端点预探测/逐项cache审计。
- 冲突：与两个owner、全部共享Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行串行，执行即时核对排他，历史idle不作当前锁；漂移即复核/重取受影响证据，本项不授予修实现权限。
- 失败/消费：输入/权限/authority不足报告具体blocked，实际非网络失败停止如实failed/partial，缺任一完整证据不满足。只有本项独立Result completed/足证据且被采用才供新gate及Q/R/D/B/M/V/H完整P消费；原P/P-recovery各partial及各旧gate不满足不回填，本次作者维护不完成item/释放gate。

### RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE — 仅未完完整oracle与同路径hit恢复 P-v3

**历史item：P-v3 generation1 failed，原完整合同/Wave/gate不满足原样保留；下述“新/尚未执行”及一切非网络即停为其执行前时点。** setup exit0、同位置两条LSP诊断后停止，run.py/Gradle/完整oracle/hit均未启动；UTC保存463.814秒/无monotonic起点及implement-plan晚读保留，见[失败采用](context.md#p-v3-静态失败采用与同预算纠错边界)。本旧item不重开、不续预算、不回填。

**新独立未完验证 item；一个 Handler/一个 Result，尚未执行。** 消费已采用 P-v2 failed 与诊断加工，不等待旧 failed/gate。前次 review-forge-evidence-path-recovery generation1 ready 对未变字段/加载导航及完整策略沿用，本次仅最小预检与新恢复连接待局部独立复审。

- 单一谓词：在已完成version9实现及可核验原fresh/miss效果之上，完整独立class/body/继承成员/适用AT/游戏保持/优先级/资源oracle与同输入同语义同有效路径真实hit及再次完整oracle共同闭合原完整P；缺任一不完成，不代Q/R/D/B/M。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P或P-recovery/两个旧不满足gate、自身gate、T-1165/T-Neo/Q/R/D/B/M。
- 保留输入（非成功前置）：原P与P-recovery各generation1 partial、T-basic-v3已完成效果；核对[原退出/身份证据](../../../build/recover-forge-overlay-content-20261024-0515/completion-evidence.json)及[新Plan策略](plan.md#overlay-未完验证的有界恢复策略)，实际源码/加载插件classes/runtimeClasspath/fixture/输入/工具/JVM及原fresh/miss产物和有效cache路径均须当前可检查且排他关联，不能拿旧未通过reference或跨身份拼接。
- 写入拥有：仅新build证据根内必要薄工具/离线核对/合法运行输出；源码两个owner/current version9、公共fixture/helper/test/API/consumer/依赖/非notch/Neo及旧证据全部只读。目录/工具纠正只服务同一验证，无独立工具阶段/框架/Result；不重做live overlay/补全/去late-copy/cache实现，发现实际实现问题只报告不修。
- 最小预检与录制检查：仅新 build 薄工具的共享 exclusive()（start/prehot/final），同一身份对应完整读入日志先比较最后明确 busy/build-start 与 Marking the daemon as idle，再截尾展示。不扩大固定窗口，不单用 sleep/健康检查/无worker代 idle；后发busy、缺状态、身份不明/退出unknown仍停止。按 [原日志/片段定位](context.md#p-v2-尾窗误拒与恢复依据) 取得实际录制前缀，交给同一实际判定函数：前文idle但尾窗无状态应通过；分别追加后发busy/build-start应拒；只有原保存尾窗应unknown拒。保存原料身份/摘要、截点/对应和增长局限；原日志不可得/不匹配报告缺口，不造样本。检查与纠正只服务完整P，无独立工具终态/Result/消费者，不新增探针/锁/调度框架。
- 内部纠正与证据：新根原始class精确断言 IClientCommand super=java/lang/Object、interfaces={bk}、完整parents={java/lang/Object,bk}；同实际函数真实正例与缺父/额外父/inverse错误负例，不忽略父类。全部2448声明/2447有父记录、Object终点/无self-parent、完整target继承表与identity增强mapping/inverse规则保持；新空输出目录的实际准备函数首次/重复行为离线核对，不再因oracle-classes重复mkdir失败、不删旧目录。按Plan重建独立reference，不用live/生产G/生产classpath/helper或旧未通过输出；完整class/body/成员及适用AT、独立两锚点、游戏/11方法接口、patched/overlay优先、25资源/filters/空见证及覆盖损失全部逐项验证，不以基本1/0/0/0、8CLI或局部计数替代。
- 缓存/产物证据：保留新鲜9,912,576 bytes、SHA256 `175ecc9d748dc8d3acd2033c5807d247b76eaf4b929be97ee1c2be26d13e69c8` 的原第二轮真实forge-patch-9/17070801 miss/rebuild，核验初始不存在/实际operation/聚合key/basename/绝对path及命令输入。身份不足即不复用/不满足；本轮不假称重新cold。新根project/输出/日志但有效metadata/cache根与task配置不变，真实patched provider task action再次到达同path lookup并hit；前后cache/新provider final分层记录、hit final完整oracle通过且与fresh内容一致。UP-TO-DATE/不同key/path/搬cache/重新miss不算hit，不清缓存/伪造基线；原完整fresh合同不削弱。
- 时钟/退出/停止：一个全新1800秒deadline，从首个实际相关检查（含静态分析/LSP、录制检查、离线预检/编译/CLI）前计时，全部验证/hit/postprocess/报告落盘均计入；至少60秒收束并另留足够报告保存余量、每次timeout扣余量、下一次网络运行至少180秒并能容纳后续检查。真实前台terminal/argv/UTC/耗时/退出，terminal_wait不重启；最多3次真实网络运行，前次正向退出/收束/分存/当前排他/预算足够且只有明确临时网络才再试；任何非网络/目录/内容/身份/退出unknown/具体损坏或上限即停。保留旧deadline后调用违规事实，不能续旧预算/超时后继续postprocess算合法成功，无端点预探测/逐项cache审计。
- 冲突：与两个owner、全部共享Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行串行，执行即时核对排他，历史idle不作当前锁；漂移即复核/重取受影响证据，本项不授予修实现权限。
- 失败/消费：输入/权限/authority不足报告具体blocked，实际非网络失败停止如实failed/partial，缺任一完整证据不满足。只有本项独立Result completed/足证据且被采用才供新gate及Q/R/D/B/M/V/H完整P消费；原P/P-recovery各partial及各旧gate不满足不回填，本次作者维护不完成item/释放gate。

### RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY — 仅未完完整oracle与同路径hit恢复 P-v4

**历史item：P-v4 generation1 failed。** 独立normalize/AT exit0、fresh完整oracle exit1；4782类中4457一致/325不同（324游戏patched＋1 BlockFluidBase overlay），资源25/25、26/26一致；Gradle/网络/hit均0，加载/路径未闭合。双时钟1123.852秒至最终保存、余676.148秒/方法事前加载，schema/GBK纠错及LSP/Inspect/原miss采样限制保留。下述新/尚未执行为准备时点，原完整item/Wave/gate合同与failed/不满足不改、不续旧钟。

**新独立未完完整验证item；一个Handler/一个Result，尚未执行/无完成证据。** 消费P-v3 failed和[本轮用户明确确认](context.md#p-v3-静态失败采用与同预算纠错边界)，不等待任何旧failed/gate转成功。review-forge-idle-validation-recovery generation1 completed/ready支持未变预检/录制、字段/加载导航、完整oracle/hit及原图，不表示本新纠错规则/预算/连接已独立review通过。

- 单一谓词：在已完成version9实现及可核验原fresh/miss效果之上，完整独立class/body/继承成员/适用AT/游戏保持/优先级/资源oracle与同输入同语义同有效路径真实hit及再次完整oracle共同闭合原完整P；缺任一不完成，不代Q/R/D/B/M。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P/P-recovery两个partial、P-v/P-v2/P-v3 failed及其不满足gate、自身gate、T-1165/T-Neo/Q/R/D/B/M。
- 保留输入（非成功前置）：原P与P-recovery各generation1 partial、T-basic-v3已完成效果；核对[原退出/身份证据](../../../build/recover-forge-overlay-content-20261024-0515/completion-evidence.json)及[新Plan策略](plan.md#overlay-未完验证的有界恢复策略)，实际源码/加载插件classes/runtimeClasspath/fixture/输入/工具/JVM及原fresh/miss产物和有效cache路径均须当前可检查且排他关联，不能拿旧未通过reference或跨身份拼接。
- 写入拥有：仅新build证据根内必要薄工具/离线核对/合法运行输出；源码两个owner/current version9、公共fixture/helper/test/API/consumer/依赖/非notch/Neo及旧证据全部只读。新根目录/薄工具自身编写或静态类型纠错与同版复查只服务本完整oracle/hit谓词，无独立工具终态/消费者/框架/Result；不重做live overlay/补全/去late-copy/cache实现，发现实际实现问题只报告不修。
- 最小预检与录制检查：仅新 build 薄工具的共享 exclusive()（start/prehot/final），同一身份对应完整读入日志先比较最后明确 busy/build-start 与 Marking the daemon as idle，再截尾展示。不扩大固定窗口，不单用 sleep/健康检查/无worker代 idle；后发busy、缺状态、身份不明/退出unknown仍停止。按 [原日志/片段定位](context.md#p-v2-尾窗误拒与恢复依据) 取得实际录制前缀，交给同一实际判定函数：前文idle但尾窗无状态应通过；分别追加后发busy/build-start应拒；只有原保存尾窗应unknown拒。保存原料身份/摘要、截点/对应和增长局限；原日志不可得/不匹配报告缺口，不造样本。检查与纠正只服务完整P，无独立工具终态/Result/消费者，不新增探针/锁/调度框架。
- 内部纠正与证据：新根原始class精确断言 IClientCommand super=java/lang/Object、interfaces={bk}、完整parents={java/lang/Object,bk}；同实际函数真实正例与缺父/额外父/inverse错误负例，不忽略父类。全部2448声明/2447有父记录、Object终点/无self-parent、完整target继承表与identity增强mapping/inverse规则保持；新空输出目录的实际准备函数首次/重复行为离线核对，不再因oracle-classes重复mkdir失败、不删旧目录。按Plan重建独立reference，不用live/生产G/生产classpath/helper或旧未通过输出；完整class/body/成员及适用AT、独立两锚点、游戏/11方法接口、patched/overlay优先、25资源/filters/空见证及覆盖损失全部逐项验证，不以基本1/0/0/0、8CLI或局部计数替代。
- 缓存/产物证据：保留新鲜9,912,576 bytes、SHA256 `175ecc9d748dc8d3acd2033c5807d247b76eaf4b929be97ee1c2be26d13e69c8` 的原第二轮真实forge-patch-9/17070801 miss/rebuild，核验初始不存在/实际operation/聚合key/basename/绝对path及命令输入。身份不足即不复用/不满足；本轮不假称重新cold。新根project/输出/日志但有效metadata/cache根与task配置不变，真实patched provider task action再次到达同path lookup并hit；前后cache/新provider final分层记录、hit final完整oracle通过且与fresh内容一致。UP-TO-DATE/不同key/path/搬cache/重新miss不算hit，不清缓存/伪造基线；原完整fresh合同不削弱。
- 同预算工具纠错与复查：只在真实可读字段/值/类型及来源证明为新根薄工具自身编写/静态类型错误时，才可最小修改并针对性静态/LSP/离线复查；保留实际错误、分类依据、改动、同版复查结果/退出/时间与限制，不把失败改成功。size/bytes须验证必需字段真实存在/值类型合法后适配或缩窄；真实缺字段/身份不明/实际内容不符不能统称工具错误，无法明确分类即停。不得默认size、忽略诊断、删断言/skip、改oracle预期或输入凑通过；没有工具产品/通用重试框架，复查未通过不当完整P证据。
- 时钟/退出/停止：全部必需方法（包括implement-plan）在项目检查/实施前加载完；一个全新1800秒deadline，从首相关检查前同步UTC/monotonic起点计时，相关静态分析/LSP、录制/父集/目录/离线检查、合法薄工具纠错与复查、CLI/reference/完整oracle/hit/postprocess/报告最终保存全部计入，不续旧钟、不从检查通过或Gradle重新计时/中途重启。至少60秒收束并另留充分保存余量，每次timeout扣余量，下次网络至少180秒且能完成后续oracle/保存；余量不足不启新调用。真实前台terminal/原argv/UTC/耗时/真实退出，terminal_wait不重启，硬中断不伪造Gradle码，unknown仍停。最多3次真实网络运行，仅明确临时网络且前次及拥有进程正向退出/输出收束/证据分存/当前排他/预算充分才再试；非网络仅上条新根工具窄例外允许同预算纠错复查，其余下游工具CLI非网络失败、真实内容/字段不符、运行冲突、身份/退出unknown或到限立即停。全部失败保留，越时输出不计通过；无端点预探测/逐项cache审计/新控制框架。
- 冲突：与两个owner、全部共享Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行串行，执行即时核对排他，历史idle不作当前锁；漂移即复核/重取受影响证据，本项不授予修实现权限。
- 失败/消费：输入/权限/authority不足报告具体blocked；除上条已证新根工具窄例外可在同预算内修正复查外，实际非网络/真实内容/输入/运行失败按停止规则如实failed/partial，缺任一完整证据不满足。只有本项独立完整Result completed/足证据且完整采用才可供新gate及Q/R/D/B/M/V/H消费完整P；保留P-v3及更早failed/两partial/旧完整合同与旧gate不满足，不回填。本次仅文档维护不完成item或释放gate。

### RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY — 独立reference语义修正后的未完完整验证 P-v5

**新未执行item：一个Handler/一个Result。** 采用P-v4 failed及[已采用两根因](context.md#p-v4-内容失败采用与reference根因)作为保留输入，不等旧failed/partial/gate先转成功；旧ready不覆盖本次新差异。现仅文档维护，受影响独立局部review及Router披露/具体实施确认尚不由本次完成。

- 单一谓词：在当前version9/可核验原fresh-miss上，修正独立reference后的**全部4782 class/body/继承/AT/游戏/资源/优先级oracle**与同输入同语义同完整有效path真实task-action Cache hit及再次完整oracle共同闭合原完整P；缺任一不完成，不代Q/R/D/B/M。两reference/样本/正负例只为同一谓词，无独立工具产品/消费者/Result或中途gate。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属 W-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY，等待 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P/P-recovery两partial、P-v至P-v4 failed/旧gate、自身gate或T-1165/T-Neo/Q/R/D/B/M。
- 写入拥有：未来仅一个新build证据根内必要薄工具/阶段新输出/合法运行证据；生产两个owner/current version9、公共fixture/helper/test/参考producer、consumer/API/依赖/权威/非notch/Neo及旧证据只读。不重做cold或已完成实现，不读生产G/final生成预期、不造通用reference框架；需要越界或缺原fresh-miss即报告具体缺口，不放宽权限。
- 内部reference修正：按[唯一策略](plan.md#p-v5-独立reference语义恢复与作者自检)，独立patch优先clean-minus-deleted的原声明，根覆盖**全部游戏patched classes及member owners**并递归parents；保留独立稀疏patch payload，仅外接声明/target表、原rename→mcinject→AT，在新根oracle副本实际接入新patched参考。overlay不再为所有无显式类名强identity；原有效目标确为identity才添identity，内嵌awu$Builder保留BlockStateContainer$Builder有效目标，增强mapping/target唯一性/逐child-parent inverse/reader格式一起闭合。原overlay2448/2447是保留覆盖基线，新游戏闭包另记实际清单，Object空父终点/不输出行及Object+bk不减。
- 样本及全量证据：原ItemPredicate的ey.d(Object)Z沿ey→fh独立期望func_148741_d；BlockFluidBase全部5处NEW/构造器/Builder.add完整操作数及InnerClasses独立期望BlockStateContainer$Builder。保存raw/mapping来源、真实语义位置/阶段观察；同实际检查函数拒旧d/旧内嵌identity真实失败样本及缺必需父声明/错误identity/缺inverse/碰撞/只改指令不改InnerClasses单变量负例。随后仍全部4782及原两锚点/11方法接口/typed/完整body属性/AT/删除项/archive集/25资源和工具资源/manifest/marker/filters/适用inject/优先级核对，不删比较或从生产摘要改golden；basic真空集/碰撞空集与覆盖损失保留，不免1165/Neo实有义务。
- 完整身份/缓存：当前源码与实际加载classes/runtimeClasspath/fixture/输入/工具/JVM/排他重新闭合，原9,912,576 bytes及SHA256175ecc9d…69c8的fresh/miss与同轮阶段可关联。完整日志预检/实际录制正负例、Object+bk完整父集/目录首次与重复准备、7/8/9 operation/聚合key/basename/完整path隔离及两族静态使用仍有证；完整fresh oracle后沿原同输入/同语义/有效cache路径真实patched provider task action命中，cache/provider final分层记录、hit后再次完整oracle且与fresh语义一致。不以外层rerun/UP-TO-DATE、不同path/key/新miss或搬cache代hit，不清cache/改Core.Cache或跨身份拼接。
- 预算/停止：方法包括implement-plan事前加载，首相关检查前同步UTC/monotonic起点，全新单1800秒含语义修正、静态/LSP/离线/工具纠错同版复查/CLI/全量oracle/hit/postprocess/报告最终保存，不续余量/重置；至少60秒收束并另留保存余量，timeout扣余量，下一网络至少180秒且容纳后续oracle/保存，最多3次仅临时网络/前次正向退出/分存/排他才再试。两处语义修正是本项事先明确范围，不冒充P-v4旧编写/类型窄例外；窄例外本身仅可证新根工具自身错误同预算最小纠正/同版复查并保留实际错误/依据/改动/时间/退出，不能默认字段/忽略诊断/删断言/skip/改raw或随意改预期。真实内容/字段不符、身份/退出unknown、冲突、下游非网络失败或到限仍停，越时不计通过。
- 冲突：与原两个owner/插件编译输出、全部共享Forge/helper/fixture/Gradle/TestKit/build/cache/输入写运行串行；新根不是并跑许可，历史idle/退出不是当前锁。共享漂移须复核/重取受影响证据，不新增Neo/R→D/B/M或D/B→M成功等待。
- 失败/消费：缺输入/权限/authority报告精确blocked，真实失败按原停止规则failed/partial并保全，缺任何完整证据不满足。仅本项独立完整Result completed/足证据且完整采用可供自身新gate与Q/R/D/B/M/V/H消费；P-v4及更早failed/两partial/原完整合同/旧gate不满足永久保留，不回填。本次文档自检不完成item/释放gate。

### FIX-FORGE-GAME-RENAME-INHERITANCE — notch游戏rename共享生产修正 P-n

**generation1 partial历史。** 两owner/version10已写，编译和四引用未完；[报告/停止](context.md#p-n-partial采用与未完验证边界)已采用。下列原完整合同及旧Wave/gate不改、不重做或回填；现行未完部分由下方P-n-v恢复，不等待本partial转成功。

- 输入：[现行策略](plan.md#游戏rename继承恢复与新产物验证策略)、[四差异/独立预期](context.md#p-v5-失败采用与游戏rename恢复边界)、T-basic-v3准备、原P/P-recovery保留效果；P-v5 failed只作事实，不等旧失败转成功。
- 单一完成谓词：共享生产owner补齐notch游戏rename的Forge原域继承声明/必要参数及专属version10/input接线，且有真实固定工具四行聚焦回归支持的可独立保留源码修正。一个Handler/Result；源码可独立审查/采用并被后继消费，后续全量验证失败无需重做它。不是仅因编译可行拆项；参数交接/版本/聚焦检查只证明该修正，无独立工具产品。
- 写范围：仅McpAction.kt的runBinaryPatcher notch rename参数/extraClasspath、必要ResolvePatchedMinecraft.kt交接/专属版本输入；新minecraft-codev/build/forge-game-rename-inheritance-recovery-g1/内薄assert/报告及正常编译输出。payload/声明分离、工具/JDK→G→raw U→稳定libraries→固定MCP依赖优先级按Plan；不改non-notch/Neo行为、正确overlay、公共API/MCP配置/依赖/consumer/fixture/helper/test源码或Core.Cache，额外owner需求只报告。
- 证据：两owner差异/全部调用分支、实际cacheKey文件输入与完整有序声明classpath分别列明；按[Plan缓存合同](plan.md#游戏rename继承恢复与新产物验证策略)交付forge-patch-10/neoforge-patch-10专属operation/固定声明语义域及输入覆盖方案、Core内容hash排序去重聚合与完整输出path推导、相关Kotlin编译。Core不含basename/角色/order，元数据不进入key；不同operation隔离7/8/9，aggregate key可相同，不以换序/改名伪证失效。固定SpecialSource与同raw G/U/mapping/libs精确拟议命令的四行参数化正例、缺U原失败负例、声明命中来源/CLI/退出/输出摘要及源码参数逐项对应。旧G仅复用已诊断正确且身份吻合的patch阶段，旧rename失败四行只读对照不新封存；两reference修正不重做。CLI只证明机制和源码方案对应，不冒充新生产实际加载/新fresh或完整P。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION；其gate已采用释放。不等其它T/Q/R/Java21、旧failed/partial、自身或后继gate。
- 冲突：两owner/编译classes和共享Forge/根Gradle/TestKit/private fixture/build/cache/input写运行与P-v6/Q/R/D/B/M/V串行；只读输入不制造成功依赖。
- 执行准备条件：按[预算撤销后的现行边界](#预算撤销后的执行准备边界)，P1时钟/P2全链上界缺证仅为历史，不再是本项前置；原两owner生产修复及P-v6完整验收已确认，不重求旧预算起点或不变范围许可。已采用T-basic-v3及其gate仍是实际前置，运行时/输入/身份/即时冲突和受影响边界独立复审不由作者自检代行，本次不记实施或完成。
- 运行/停止：不要求统一1800秒、UTC/单调配对或跨Handler共同原点、交接扣时、Result发布末值、全链上界、60秒收束/独立保存余量证明，不设置替代分钟上限。独立完整Result交付两owner/version10/input修正、编译及四行真实固定工具正负例/参数对应，完整保存日志、失败、产物/输入/工具身份、真实退出/输出收束和未完边界；不冒称新生产加载或完整P。全链最多3次正常网络（含P-v6 hit），仅明确临时网络且前次正向退出/输出收束、证据分存及当前排他可判才再试；窄工具自身编写/类型纠错须保留原失败和同版复查，真实内容差异/缺字段、输入或加载身份不明、冲突、控制退出unknown仍停止。单次工具超时按实际工具合同处理，不构成统一分钟门槛。

### RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION — 保留源码的未完编译与四引用恢复 P-n-v

**已采用状态（非本次执行）：** Router已采用完整completed源码恢复Result并满足G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION；原完整源码标准保留，不重跑、不回填原P-n partial或旧源码gate。

- 输入：已采用P-n generation1 partial及[仓内报告/精确差异/停止与身份导航](context.md#p-n-partial采用与未完验证边界)、保留两owner/version10；[Plan等价标准](plan.md#p-n-partial后的未完验证恢复策略)。一个Handler/独立Result，原partial仅事实输入，不是completed前置。
- 单一完成谓词：保留源码修正满足原P-n完整源码终态，仅补相关Kotlin编译、真实固定SpecialSource四引用正例/缺U负例和源码参数对应。原静态证据可在身份未变且适用时关联，不重写两owner或重做reference纠正；薄工具/编译/CLI只证明此终态，不交付工具产品，不证明新生产加载或完整P。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed/足证据）；唯一归属W-FORGE-GAME-RENAME-INHERITANCE-VALIDATION，等待已采用G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION。不等原P-n partial/G-FORGE-GAME-RENAME-INHERITANCE、任何旧failed/partial/旧gate、自身或后继gate、Neo/Q/R/D/B/M。
- 写范围：未来仅新minecraft-codev/build/forge-game-rename-inheritance-validation-recovery-g1/内必要薄launcher/assert/日志/证据及正常相关模块编译输出；旧g1证据/脚本只读，不覆盖原失败。生产源码/正确overlay/公共fixture/helper/test/consumer/API/MCP配置/依赖/Core.Cache/权威只读，不清搬缓存。本次作者不创建新根；源码身份改变或需要范围外改动即报告边界，不在本项重做已完成效果或修生产。
- 完整证据：当前两owner与after-edit身份/差异对应、全部调用分支/notch-only --live、tool/JDK优先与G→raw U→稳定libraries→fixedPatches声明first-win及payload分离；version10两族operation/固定语义域、实际cacheKey实参覆盖/派生来源、Core内容hash排序去重聚合/完整path推导均有证（角色/order/basename不入key、有序身份另证、旧新aggregate可同，工具/JDK/G不假称直接hash）。恢复期间source/input/tool/JVM身份稳定；仅关联适用已完证据，不省略原partial未证内容。修正版Java8/11/17与-P配置的相关compileKotlin真实执行/成功/退出日志；固定SpecialSource/Java8/raw G/U/mapping/libs完整argv、四引用各自raw opcode/owner/name/descriptor/继承独立预期、实际输出/声明来源/重名遮蔽和first-win、四处正例及同一实际检查函数拒绝缺U负例、源码参数逐项对应与产物摘要。原96输入/3348类核对仅支持正确patch复用，不作rename新golden；旧compiled摘要/失败编译/未启动修正版不代证。CLI不冒充P-v6新加载/全量oracle/cache。
- 冲突/准备：与原两owner/编译classes、全部共享Gradle home/cache/TestKit/Forge/fixture/build/input写运行及P-v6/Q/R/D/B/M/V串行，每次构建/CLI前即时复核排他；历史idle/退出或新根不是锁，原冲突不抹除，不终止外部任务或续旧partial。源码漂移或输入覆盖缺口停止报告，不跨身份拼证。
- 运行/停止：无统一分钟/双时钟/全链上界或替代预算，单次工具按实际合同。正常网络全链已消费0/最多3次（含P-v6 hit）不重置，仅明确临时网络且前次正向退出/输出收束、分存和排他可判才再试，不查普通网络原因。薄工具可证编写/类型错误最小纠正并同版复查、保留失败；真实内容差异/缺字段、身份不明、冲突/控制退出unknown即停。缺外部前提如实blocked，实际失败/未完如实failed/partial；缺任何完整证据不完成，不改golden或放宽验收。
- 消费：仅本项独立完整Result completed/足证据且完整采用可供自身新gate/P-v6消费，原P-n item/Result/gate不回填。两owner效果在后继失败时保留；P-v6仍独立自证新加载/全部4782与原oracle/10真实miss-rebuild-same-path hit/再次全量检查，8消费者不从本项直接取完整P。作者自检不代独立复审、执行或gate释放。

### VERIFY-FORGE-REBUILT-CONTENT — 新产物全部内容与同路径hit P-v6

**原item执行后历史：** generation1及redelegated generation2的采用语义为partial；技术通过及网络偏差见[Context](context.md#p-v6-一次性偏差接受与技术证据)。下列原谓词/前置/完整技术与次数标准保留，旧gate未释放，不续跑或改completed；现行成功输入见P-v6-a，不以新Result回填本项。

- 输入：完整采用的P-n-v独立恢复Result（保留P-n源码/version10并闭合原完整源码/编译/聚焦标准）、原P-n partial及T-basic-v3原料、两已有效reference修正及身份适用性限制；[现行策略](plan.md#游戏rename继承恢复与新产物验证策略)。
- 单一完成谓词：当前实际加载新实现的version10新生产产物具有完整独立oracle与同版same-path真实hit足证据，供完整P消费者。一个Handler/Result；四行/声明/加载/内部工具/全部oracle/miss-rebuild-hit仅证明此终态，不交付独立工具产品。
- 写范围：仅新minecraft-codev/build/forge-rebuilt-content-validation-g1/内薄私有入口/复用reference和检查脚本/证据、全新私有cache及正常构建运行输出；允许必要新rebuild，不改生产/公共fixture/helper/test/consumer/依赖/权威/Core.Cache、不清搬缓存。旧P-v5只读生产/不cold原合同保留旧项，不阻挡本项新构建；旧9/fresh不代新成功。
- 证据：当前源码→实际compiled classes/code source/runtimeClasspath→完整inputs/tools/JVM/argv/阶段/无漂移；按[Plan缓存合同](plan.md#游戏rename继承恢复与新产物验证策略)记录实际cacheRoot/operation/cacheKey实参完整清单（角色/顺序/path/basename/bytes/SHA256/逐文件Murmur3-32）、源码比较器toSortedSet排序去重结果、重算aggregate key/output basename/绝对path。定位是`<cacheRoot>/cached-operations/<operation>/<aggregate-key>/<output basename>`，operation隔离7/8/9/10，Core不含basename/order/角色且hash可相同；完整有序声明/工具/JVM身份另证，不把元数据当key。先证明10目标输出path不存在或真实miss→同task-action真实generate/rebuild/new fresh→全部4782等oracle→同输入/顺序语义/加载/工具/JVM/root/operation/key/basename/path真实task-action hit→再次完整oracle。新fresh字节副本、含AT/适用Dist/marker的顶层cache输出及两次task final以path/bytes/SHA256/轮次日志关联；patch/G/rename/normalized overlay中间件另记。--rerun-tasks/UP-TO-DATE/FROM-CACHE/换key/再次miss/拷Jar或搬cache不代hit。
- 证据（内容）：raw child/parent/固定mapping独立预期逐行核对实际新游戏rename→实际新normalized overlay声明→fresh/hit最终引用、三invoke一字段及单变量负例；旧rename失败四行保留可读。已修reference/typed锚点/真实ItemPredicate和BlockFluidBase正负例须身份适用才复用、不重做纠正、不从生产生成golden。全部4782 class/body/成员/继承/属性/AT/游戏保持/11方法/优先级/资源/归档/manifest/marker与原合法要求、预检录制/Object+bk/reader/目录正负例不减；basic空集损失、旧miss/计时/LSP/unknown保留。
- 前置item：RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION；继承T-basic-v3，不等原P-n partial或旧failed/partial/旧gate、自身gate或Neo/Q/R/D/B/M。
- 冲突：与P-n和共享source/编译/Gradle/TestKit/fixture/build/cache/input写运行串行，重新确认即时排他，不把历史idle当锁或加Q/R成功依赖代替冲突控制。
- 执行准备条件：完整读取/采用P-n-v独立完整Result及新恢复gate，并关联原P-n partial/保留源码与适用旧证据，重新核对本项当前源码/实际新加载、输入/工具/JVM/cache身份和即时排他；依[预算撤销后的现行边界](#预算撤销后的执行准备边界)，不核P-n原始时钟、交接扣时或全链余量，不以P1/P2历史缺证阻止准备，不重求已确认完整验收范围许可。本次作者自检不代独立复审或本项实际足证据。
- 运行/停止：不再要求与P-n共用1800秒/共同双时钟/UTC配对、发布末值、全链上界或60秒收束及保存余量证明，不新建替代分钟预算。当前加载与完整输入身份、全部4782及原完整oracle、真实miss→rebuild→same-path hit→再次完整oracle和fresh/cache/两次final关联仍须完整证明；旧9/fresh、P-n四行CLI或编译不代证。全链最多3次正常网络（含hit），仅明确临时网络且前次正向退出/输出收束、完整分存及排他可判才再试；窄工具自身编写/类型纠错保留原失败并同版复查，不授权新reference语义纠正或越界生产。真实缺字段/内容差异、输入或新加载身份不明、冲突或控制退出unknown仍停止，实际工具超时按其合同保全失败与退出事实。完整Result保存全部日志/身份/退出/限制；P-n独立成果不因后继未完抹除，完整P消费者仍等待本项自己的足证据，本次无执行完成或gate释放。

### ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE — 单次例外下的既有技术证据采用核对 P-v6-a

- 单一完成谓词：一个独立Handler/Result完整核对原P-v6已通过的全部技术证据在本次用户接受偏差下是否可供后继采用；Result completed/足证据且Router实际采用才满足本项。不是重做产物验证、改写原partial或文档局部复审；仅核对结束但证据不充分不满足谓词。
- 前置item：RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION（已采用完整源码Result）；唯一归属W-FORGE-REBUILT-CONTENT-EVIDENCE，等待G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION（已采用满足）。原P-v6 partial只作技术输入，不等其item completed、旧G-FORGE-REBUILT-CONTENT、自身gate或后继。受影响边界局部独立复审和Router准备判断仍必要，作者未完成。
- 输入/证据：已确认的单次例外、Router完整读取关联verify-forge-rebuilt-content-redelegated generation2 partial的事实，原VERIFY-FORGE-REBUILT-CONTENT generation1 continuation的[报告/实际索引](../../../build/forge-rebuilt-content-validation-g1/pv6-continuation-report.md)与[未改原账本](../../../build/forge-rebuilt-content-validation-g1/network-attempts.json)。按[Plan采用策略](plan.md#p-v6-既有技术证据采用策略)逐项关联原P-v6全部技术谓词及source/实际加载/输入/有序声明/tool/JVM适用性、Core hash/key/path/版本隔离、真实miss-rebuild-fresh与全离线same-path task-action hit/再次全量oracle、输出字节、四引用/reader/typed/11方法/继承/AT/资源/68序列/19声明优先级、全部负例及覆盖损失；不以摘要代必要来源/适用性，不要求重跑已通过检查或重新取得旧Result。
- 写入/冲突：仅只读核对并交付独立Result；不写生产/公共fixture/helper/consumer/依赖/四协调文档/原日志账本/输入缓存，不执行构建/测试/CLI/下载/进程操作或新在线。核对对象稳定，与相关源码/证据/输入变动串行；共享只读不制造Q/R/D/B/M相互成功前置，漂移先报告。
- 足证据边界：5标online入口（1次Java前失败、4次实际在线Gradle）、normalOnline=2依赖物化重分类与旧保守3记法并存，不能据2/3证明原次数合规；例外仅这些已发生记录，无新运行/未来额度豁免。独立Result须关联该权限与未降低的全部技术证据，保留原P-v6 partial/旧gate未释放/失败/unknown/4项覆盖损失。实际缺证/身份不适用/冲突/需新权限或生产改动则报告受影响缺口，不虚构完成、改预期或自行恢复。
- 状态/放行：本次只准备，本项未执行、Result不存在、新gate未释放。作者completed、局部review completed或旧backend completed均不代本项completed/足证据/Router采用；新成功只服务显式后继，不释放原P-v6或其它旧gate，不等同Q/R/D/B/M/V/H成功或最终集成验收。

### VERIFY-FORGE-PATCH-1165 — non-notch 完整实际验证 Q-1165

- 单一谓词 Q-1165：同版 P-v 在 forge1165Mcinject 的完整真实最终 namespace/引用/优先级/资源/适用 mcinject/AT 合同及本组 forge 实际路径隔离/新语义冷热缓存闭合，可供 M 独立消费，不代 named consumer/R。
- 前置item：PREPARE-FORGE-PATCH-1165、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE（各完整采用/completed/足证据）；唯一归属 W-FORGE-PATCH-1165，等待 G-FORGE-PATCH-FIXTURE-1165、G-FORGE-REBUILT-CONTENT-EVIDENCE；不等 T-Neo/Q-Neo/R/D/B/M 或自己 gate。
- 写入拥有：仅本项独立新 build 证据/私有运行输出和缓存；只读共同生产/专用 fixture/helper，不另改代码/测试/配置/工具行为/原 consumer/runner/依赖或旧证据。
- 证据：从 T-1165 的精确方法/provider 运行本组，按 [Plan Q](plan.md#关联分支验证-q-的独立完成证据) 的固定 userdev/MCP/真实 SRG clean/官方 binpatcher1.0.12/适用 mcinject、独立参考/具体见证，证明最终 entry/this_class/descriptor/reference/未补丁完整接口、patched 优先/资源/overlay/AT 及不重复 rename。本组按[Plan缓存合同](plan.md#游戏rename继承恢复与新产物验证策略)记录实际forge operation/源码内容hash聚合key/output basename/完整path及独立输入身份，与旧语义的路径隔离不要求aggregate必异；目标输出path初始不存在或真实miss→真实task-action rebuild/最终内容→同root/operation/输入身份/key/basename/path hit/一致内容，命令/JVM/退出/日志/产物和实际源码/fixture/输入身份齐全，不由 P-v/basic 代证。
- 冲突：与所有共享 Forge/Gradle/TestKit/build/cache/fixture 写运行串行；最新内容漂移须重新核对受影响证据，不机械沿用旧成功。
- 停止/失败：缺输入/JDK/见证/真实执行/namespace/cache 证据不完成；缺 JDK blocked/failed，不 silent skip。生产真实缺陷仅报告，不顺手在 Q 修生产；不取消已经独立闭合且内容未漂移的 basic 结果。

### VERIFY-FORGE-PATCH-NEO — Neo 收窄合同完整实际验证 Q-Neo

**g1 历史及合同保留。** 本项 generation1 已采用 blocked，outer/nested/prepare/reference 全为0、无 JUnit/XML/新 final，G-FORGE-PATCH-NEO 未满足；不回填、不继续派发本旧结果。此前 PREPARED-VALIDATION g1亦已failed/旧gate未满足；Stream接续g1亦已failed（编译通过、身份断言失败、outer1/nested0/prepare0/reference0、exit1、JUnit1/1/0/0，旧gate未满足）；现行唯一接续为页首 RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX，完整继承以下全部谓词/证据/预算。WIRE 已交付入口；原“拟新增/未运行”只属当时状态，不重做源码。

- 本次固定走项目已交付 opt-in JUnit/TestKit，沿现有根 Test 桥接及已成功 source-home/真实安装参数。独立 Java 六参入口、单独 javac/PrivateGradleRunner 启动或额外读取器不属于这次单次调用；新薄 init/worker 属性和加载/来源记录只写新 Q 根。

- 单一谓词 Q-Neo：同版 P-v 在 neo121NoMcinject 的 official/无 mcinject 完整最终 namespace/引用/优先级/资源/适用 AT、明确 Dist 主属性/marker 及有限原始资源成员合同，以及本组 neoforge 实际有效路径隔离/新语义冷热缓存均闭合，不声称全 class side 或旧 attrs 等价。
- 前置item：WIRE-FORGE-PATCH-NEO-VERIFICATION、RECOVER-FORGE-PATCH-NEO-CPW-MODS、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE（各完整采用/completed/足证据）；唯一归属 W-FORGE-PATCH-NEO，等待 G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE；不等 Q-1165/R/D/B/M 或自己 gate。原 WIRE/T/P 完整证据已采用且三个 gate 已由 Router 判断满足，本项 g1 仍因预检 blocked/四类调用0，不能由原前置已满足推断运行或完成；本作者不重开旧采用或宣告新 gate。
- 写入拥有：仅未来全新 Q build 根的必要薄 init/调用记录、XML/日志/tmp/私有 project/TestKitDir/Gradle home/output/evidence。只读生产及已交付三个接点，不再修测试/fixture；旧 F 输入/项目/home/参考/output/见证/日志只读，唯一例外为原 S/prepare/cache 的目标 operation 目录正常原生 lock。cache JAR 与其它旧材料不改写，不清/复制用户缓存、不写 Dist/生产/配置/JDK/依赖/Git。
- 唯一运行入口：已由 WIRE g1 源码交付的 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.verifiesPreparedNeo121NoMcinjectWithCacheHit`。精确属性、argv/离线供给、隔离和证据槽由 [Plan](plan.md#唯一路径离线供给与调用)拥有；outer 1 次/nested 1 次/prepare 0/reference 0，测试编译在唯一外层，先验失败则 nested0，不另跑 compile/help/探针。
- 证据：先按 [Plan 完整断言](plan.md#完整内容断言与冷段适用性)核 T 原 final 的完整 official 类/接口/引用/优先级/资源/适用 AT 与原收窄 Dist/marker/有限原始资源合同，并有据采用原 miss/rebuild/输入/当前实现适用性；再用原 provider task action 在新 output 上实际执行一次，明确 `Cache hit for neoforge-patch-10`，复核新 final 全内容及 old/new SHA 关联。冷段必须使用原 F 的 operation10/inputs/key `6d7a8c95`/basename/完整 cache path；Core hash 排序去重规则不能误作有序聚合，路径隔离不要求 aggregate 必异。task `SUCCESS`/真实 action 与 hit 日志必需，UP-TO-DATE/FROM-CACHE/SKIPPED/新root miss/手工复制不能代证。保存 outer 真实数值 exit0、新方法实际 JUnit XML `1/0/0/0`、nested build 真实结果/task outcome、旧真实 Java21 工具和 reference 的适用身份以及本次命令/日志/产物/计数；不冒称重新运行 Java21/冷段/reference 或完整旧 attrs/全 class side 正确。
- 冲突：与三个接点/共同内容写入及所有共享 Forge/Gradle/TestKit/build/cache/fixture/输入写运行串行；新 Q 根不消除旧 cache 与编译输出冲突，不能消费漂移材料。
- 停止/失败：旧完整内容/适用身份不符、缺21/离线依赖/必要输入、需重新 prepare/reference、miss、新退出unknown/缺 XML 或实际 hit 均不 completed；未启动缺前提 blocked，实际编译/断言/构建失败 failed，未到达如实保留。不得追加第二次外层/nested、下载/冷生成/源码修复或 Dist 修复，不把回退生成当允许冷段。不恢复控制器排空、daemon 历史链或额外身份审计；真实退出/JUnit/完整内容/真实 hit 仍必需。仅本组及 R/V/H 真正依赖等待，D/B/M 自身满足则不被取消。

### TEST-FORGE-PATCH-NAMESPACE — 独立 namespace 与缓存反例回归

**原完整R合同/未完成事实保留；本轮不新增、实施或运行本项。** 下列三组准备/四方法/冷热/fixture整类及前置gate只是原合同，不继承到[V-compat](#verify-forge-at-jarjar-compatibility--两项兼容观察的单次联合结果)。本项不等待新兼容结果，也不成为新兼容运行的成功前置；原G-FORGE-PATCH-REGRESSION未满足。

- 单一谓词 R：按 [Plan 补丁阶段资源/固定 basic 适用性及覆盖损失](plan.md#补丁阶段资源范围与固定-basic-空见证适用性)，不恢复 raw、不免1165/Neo实有载荷，真实生产 patch/rename/最终补全和新语义自有缓存具备可重复回归，覆盖 patched 引用未补丁接口、entry/this_class/descriptor/reference/资源及 namespace 一致、patched 优先、版本有效路径隔离与新语义 miss→rebuild→同版 hit、non-notch/NeoForge 新鲜内容合同；独立 Handler/Result，不代交 P-v 或 consumer。无旧实物的未覆盖限制必须明示。
- 前置item：RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION、PREPARE-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-CPW-MODS、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX（各完整采用/completed/足证据）；唯一归属 W-FORGE-PATCH-REGRESSION，等待 G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165、G-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX。不等 S/D/B/M 或自身 gate，R 只是 V/H 质量门槛，不成为 D/B/M 技术输入。
- 写入拥有：拟新增 Forge 测试目录 ForgePatchNamespaceTests.kt、T 专用私有 fixture/helper 中实现矩阵所必需的输入/接点及本项独立 build 证据/私有缓存；已确认范围仅专用真实 fixture，不改生产、两个原 consumer 用例/runner、公共 API/通用框架或依赖版本。当前新增文件/方法均待实施，不冒充现存 selector。
- 证据：消费 [Plan 四项矩阵/准确未来 selector](plan.md#独立针对性回归-r-的最小矩阵) 和 [固定输入/判定](plan.md#固定输入与逐分支判定来源)，从三个真实 provider 执行并保存完整新增反例/fixture 类、现有 AT/JarJar 整类与方法参数/XML/日志/产物。新鲜 final 的 entry/this_class/descriptor/reference、未补丁接口、patched 优先/资源、语义路径隔离及私有缓存 miss→rebuild→同版 hit 逐项有证。nonNotch 实际命中 forge1165Mcinject 和 neo121NoMcinject，neoForge 在后者核对新 final 的明确 Dist 主属性/marker、universal/资源和有限原始资源成员关系。无旧 final/cache/P-v 前 attrs 比较，不证明完整旧 attrs 等价/全 class side 分类；已知静态风险保留。缺必需输入/见证/实际执行或 skip 不完成；JDK 缺失明确 blocked/failed。V 最终同版 fresh 重跑全部新增参数。
- 冲突：与生产 P-v、D/B/M、共享 Forge 输入/Gradle/TestKit/build/cache/fixture 全部串行；使用私有缓存演示失效，不动采用旧证据或清全局缓存。
- 停止/失败：无法从允许测试边界到达真实行为或存在必需 skip/反例未命中/缓存或关联路径缺证时不满足，报告具体缺口，不在 R 顺手补生产/API/consumer。

### RECOVER-BASIC-JAVA8-POSTPATCH — 修正之后的独立完整同轮发现

- 单一谓词 D：保留成功接线的当前对应加某一次新原 basic invocation 的 Provider/Test/唯一同名-D/nested System/StartParameter 两 map/effective installations、现有 printCompileClasspath 实际 action 的 Java8 compiler executable 与 metadata languageVersion=8 及共享语义全部闭合；Provider无直接对象帧限制明示，旧17条/别轮不能补证。只发现、不代交 B。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE（完整采用/completed/足证据），另消费既有 basic 成功接线；唯一归属 W-BASIC-JAVA8-POSTPATCH，等待 G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE。R 不提供本项技术输入，不设其成功等待；不等 NORMAL-RETRY 或更早 failed/partial/gate 转成功，不等 B/M 或自己 gate。
- 写入拥有：仅独立新 build 证据目录/正常运行输出；复用已有正常重试 token/身份/观察工具及接线，只在新目录更新本轮输入基线/证据路径，不改工具行为/源码/测试/脚本/两个 caller 或 consumer/runner/配置/网络/JDK。实施与运行仍须本次范围复审、披露及当前用户确认。
- 证据：只从原 PatchedMinecraftTests#Test patched Minecraft 进入，保留 jar/printCompileClasspath/-s、Test17/fixture.gradleJava/consumer8、withPluginClasspath/forwardOutput/withDebug(true)/隔离 TestKit home。按[Plan D](plan.md#patch-后-d-与完整-bm-的边界)及[正常网络安全原则](context.md#正常网络重试决定与当前判据)，新 batch 最多3次/首次实际调用起一个1800秒deadline，保留60秒收束、下一轮180秒余量；每轮分存真实日志/阶段/异常/XML有无和计数/退出/身份/监听/收束/预算/输入及旧证据稳定。完整成功必须现有 action 两行同轮到达，不能以候选/编译开始/偶然 Jar 或只读代码替代。
- 冲突：与全部 Forge/Gradle/TestKit/build/fixture/cache、输入写入及端口观察串行排他；启动即时核对当前输入/成功接线/旧证据/daemon及基本身份，历史空闲/退出快照不是当前锁。
- 停止/失败：只有实际临时网络且无并存非网络错误、全部本轮拥有进程正向退出/线程输出收束/分存/排他/剩余预算满足才正常再试；普通缓存不逐文件认证或清理，包装不设白名单。具体损坏、compiler/namespace/其它非网络错误、控制器/观察/身份/退出未知或到限即停，缺 action/两行则 D 不满足；NORMAL-RETRY 旧失败不可重开，D 的偶然产物不认领 B。

### RECOVER-BASIC-ARTIFACTS — 当前 basic 脚本的完整真实消费

- 单一谓词：从原 blocked 后保留且最终未运行的当前脚本，固定 MC1.12.2 / Forge14.23.5.2860 / userdev3，经实际来源/provider/namespace 与 Java8 选择产生 patched Jar，由原 EVENT_BUS / MinecraftServer.main consumer 完成 compileJava/jar/printCompileClasspath。不是仅发现 Java8。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、RECOVER-BASIC-JAVA8-POSTPATCH（各完整采用/completed/足证据）；R 不提供技术输入，所在原 W-BASIC-RECOVERY 仍只等待 G-REPAIRS，**不等待本 Wave 自己的 G-BASIC-RECOVERY**。消费原成功接线与新完整同轮 D；NORMAL-RETRY failed及更早 failed/partial/blocked 仅保留输入，不要求其转成功；不等待 remapped/Mixin 成功。
- 写入拥有：保留原 basic consumer 用例与成功接线，运行/取证生成新输出；原批准 basic-patched-test/build.gradle.kts 与必要原取证接点在未完成 caller 边界的必要修正权限仍有效，不重做已完成效果或规避性改写。原 reconciliation/旧 not-ready 见[Context](context.md#basic-三项复审阻断的局部纠正)；不扩大生产 API/版本/依赖/consumer/runner/配置/参数框架或 TestKit classpath，新增生产权限不由本项代行。
- 证据：保留原 RECOVER-BASIC-PATCHED 的全部验收义务及 [Plan 恢复二](plan.md#恢复二两个-forge-fixture-迁移到现存任务-api)。只用原 basic 方法/原 jar/printCompileClasspath 入口，重新核对当前 userdev3、MCP/functions、patch tools、universal/inject/AT、适用 libraries/modules、真实 namespace 和 provider/producer 依赖；实际选中 Java8 metadata/executable 与新独立恢复结果及当前输入/环境对应。保存 patchedMinecraft、compileJava、jar、printCompileClasspath 实际 outcome、坐标/文件/产物身份、当前 Test.class/Jar/classpath，class major52 仅辅助。外层重跑不代表 nested fresh；须保存/识别旧输出，记录有界的 nested 重执行方式，不用旧 class/cache 或仅配置通过替代当前产物执行。
- 冲突：与 P-v/RECOVER-BASIC-JAVA8-POSTPATCH 有真实前置；R 仅共享资源排他、无成功前置；原 RECOVER-BASIC-JAVA8 不重放；与 remapped 的共享 Test 配置/测试文件和 Gradle/build/fixture/cache 串行，但不等待 remapped 成功。最终内容写入不得与复验/验收并发。
- 失败/停止：保留本轮尝试与原三次失败，最终脚本未验证事实不能被发现项成功覆盖。来源、namespace/provider、现存生产能力或实际 compiler 不闭合则报告具体缺口，不扩大范围；不重放 Mixin/原三 completed，不改旧 basic blocked 或释放旧 gate。

### RECOVER-REMAPPED-PATCHED — 1.16.5 remapped 的真实 named 消费

- 单一谓词：固定 Minecraft 1.16.5 / Forge 36.2.39 / userdev 经现存 patched、official/load/RemapTask 链产生实际 named Jar，由原 Java8 consumer 完成 compileJava/jar 和 printCompileClasspath；证据仅评价本工程。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165（各完整采用/completed/足证据）；所在 W-RECOVERY 仍等 G-REPAIRS。不等 T-Neo/Q-Neo/R/basic D/B 成功或旧 failed 组合转成功；消费 P-v 后生产实现、本组完整 Q-1165 与自身迁移，R 是 V/H 质量证据而非本项输入。两个工程及 R 共享资源排他不构成成功依赖。
- 写入拥有：此前已批准但尚未完成的 remapped-patched-test/build.gradle.kts 旧 DSL→现存 ResolvePatchedMinecraft/ResolveMinecraftMappings/LoadMappings/RemapTask 迁移及必要原取证接点，正常运行/新独立证据输出；不再写成“只能执行旧脚本/不能改脚本”。保持原 consumer/版本/依赖/生产 API/runner；无新增同名-D、通用参数框架或规避性改写。原脚本仍旧 API，真实输入、namespace/provider/Java8 解析未闭合，范围内不能闭合就报告具体缺口，不借 M 扩大生产能力。
- 证据：按 [Plan 恢复二](plan.md#恢复二两个-forge-fixture-迁移到现存任务-api)保存本例 userdev/MCP/patch/universal/libraries/modules 链；ResolveMinecraftMappings 显式 server=false，LoadMappings 显式 Java8 executable 且按 official→MCP 顺序读取，真实 Tiny 树和 patched 内容核实 srg→named，RemapTask 显式 sourceNamespace、inputFile/mappings/classpath/outputFile providers。只运行 `PatchedMinecraftTests#Test remapped patched Minecraft` 对应原入口，保存全部 task outcome、来源/输出身份、Java8 compiler、EVENT_BUS / named Entity.class 的当前 consumer class/jar 与 classpath；无继承/override 义务。只设字符串、脚本 compile 或旧 class 不算通过。
- 本 invocation 的共享属性观察：在本项原 remapped 方法运行时保存最终 arguments（无新增同名 -D）、nested 同名 System 属性、StartParameter.systemPropertiesArgs/projectProperties、effective toolchain installations 配置与实际 Java8 compiler，关联 Test JVM 属性、工程/调用/阶段和 withDebug(true) 的实际运行帧。只读观察方式与 [Plan](plan.md#basic-未完成边界的标准属性接线)相同，不把外层 Test 快照当 nested 观察、不新增探针任务或 runner -D；检查值即使可见是否影响安装选择/任务语义。观察缺失、不能判定或真实改变原合同即本项不满足，报告具体影响而不越权修复。不等待 basic 成功，也不要求 basic 发现项预跑尚未迁移的本工程；最终复验在最终内容复核两 invocation。
- 冲突：与 basic 的共享测试取证文件（如需写）及所有共享 Gradle/build/fixture/cache 排他；串行是消除冲突，不要求 basic 先成功。全量三 Forge 类及真实 AT 兼容回归由最终复验保留。
- 停止/失败：实际 namespace、provider、输入解析或现存生产能力无法闭合即报告本例具体缺口，不补生产或改 consumer。basic 的独立成果保留；本项未满足时 G-RECOVERY 不释放。

## Remapped M API取证恢复连接

### RECOVER-REMAPPED-PATCHED-API-RECOVERY — 原M API/取证未完边界恢复

原 `RECOVER-REMAPPED-PATCHED` generation 1 `failed` 保持原Result、原谓词及 `W-RECOVERY` / `G-RECOVERY` 不满足状态；实际证据见[原报告](../../../build/recover-remapped-patched-g1/report.md)和[completion](../../../build/recover-remapped-patched-g1/completion.json)。仅新增以下独立恢复，不将诊断或文档作者完成视作实际M完成。

- 单一谓词：在原 `PatchedMinecraftTests#Test remapped patched Minecraft` 精确入口内完成固定 Minecraft 1.16.5 / Forge 36.2.39 / userdev 的完整真实输入与 API 链：userdev/MCP/universal/libraries/modules解析、patched producer、official client mappings（server=false）、Java8 executable的LoadMappings（official→MCP）、真实Tiny namespace/srg→named、显式namespace RemapTask及producer/provider闭合；原Java8 EVENT_BUS / named Entity.class consumer真实编译、jar、printCompileClasspath；fresh patched/named Jar、consumer class/Jar及完整classpath身份闭合。单轮nested属性/StartParameter两map/effective installations/实际compiler与metadata观察须判明共享属性/withDebug语义；真实Gradle exit0、JUnit 1 pass/0 failure/error/skip与命令/输出收束证据齐全。完整原M合同不得由脚本compile、旧产物、Q/D旧观察或跨轮拼接替代。
- 前置item/gate：仅 `ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE` 对应新P-v6-a完整Result获Router采用且 `G-FORGE-REBUILT-CONTENT-EVIDENCE` 满足；`VERIFY-FORGE-PATCH-1165` 完整Result获采用且 `G-FORGE-PATCH-1165` 满足；`G-REPAIRS` 满足。分别核当前来源/输入和实际适用证据；不等Neo、R、D、B或旧M转成功。新item不等自己gate。
- 写入与证据：仅已批准 remapped-patched-test/build.gradle.kts 原迁移范围、必要原取证接点和正常新运行证据；已诊断API修正见[Plan](plan.md#remapped-m-api恢复与作者自检)，本轮不改实现/fixture/工具/consumer。实际API使用原getVersionList/getGlobalCacheDirectory/顶层getAllDependencies、现有universal文件集合、UserdevConfig.fromFile、libraries文件依赖，不新增API或依赖；遇到真实生产能力缺口报告，不扩权。保留原TestKit `[jar, printCompileClasspath, -s]`，无新增同名-D；调试观测按原withDebug边界在实际nested运行帧记录，外层Test快照不能代替。
- 冲突/停止：与共享Forge测试观察点及Gradle/TestKit/build/fixture/cache运行排他，所有有冲突的实际运行串行。保留真实timeout/排他/身份/退出/非网络失败立即停止规则，不新设重试预算、在线额度或通用框架；脚本/API修正无法在批准范围闭合、任一必要阶段/新鲜产物/观察缺失、实际运行失败/skip或收束身份不明均不满足本项。
## Remapped 标准属性恢复连接

本节取代旧item未来“remapped无新增-D”限制，不修改原M及API恢复两个failed Result、谓词或旧Wave/gate。API恢复实况见[报告](../../../build/recover-remapped-patched-api-recovery-g1/report.md)，加工事实/授权见[Context](context.md#remapped-标准属性恢复的采用事实与授权)，策略/角色及作者自检见[Plan](plan.md#remapped-标准属性恢复策略与作者自检)。已写fixture保留不重做，下游未证；作者blocked与实际写入矛盾及启动前采样覆盖缺口保留。两项仅计划，待不同Handler局部独立复审、Router披露及用户实施确认；作者不派发、不采用新Result或释放gate。

### RECOVER-REMAPPED-JAVA8-FORWARDING — 标准属性转发后的同轮真实Java8发现

- 单一谓词/Result：原remapped精确方法一次新调用内，完整有效非空标准属性从既有Provider→Test System→remapped唯一同名-D→nested System/StartParameter.systemPropertiesArgs/gradleProperty provider/effective installations，实际解析选中Java8 compiler metadata/executable并回指用户列表；一个Handler/一个独立Result。下游另失败时必须保留真实Gradle/JUnit/未到达边界；仅发现可completed，不宣称M/named消费成功。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各完整采用/completed/足证据；所在W-REMAPPED-JAVA8-FORWARDING等G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。不等旧M/API失败转成功、Neo/R/D/B或自己的gate，不重做已通过Q/P/D/B。
- 写拥有：未来PatchedMinecraftTests.kt原helper仅让remapped像basic读取现有Test系统属性并追加一个完整非空-D；basic原语义/上游Forge Test接线/fixture.gradleJava/withDebug(true)/withPluginClasspath/forwardOutput不变。必要取证修改仅将remapped fixture现有compiler解析/两行输出移至配置完成后的gradle.projectsEvaluated回调，不重做API/provider迁移、不新增任务或改变compiler；见[Plan具体方法](plan.md#compiler证据的独立可达方法)。允许全新build证据根内必要私有薄入口、小自检和正常输出；旧run.py/helper/报告/输出、生产/Core/consumer/版本/依赖/用户配置只读，不备份旧状态、不清全局cache或新增框架。
- 转发/角色证据：正常启动外层Gradle，原[jar, printCompileClasspath, -s]后仅一个-Dorg.gradle.java.installations.paths=完整原值，不拆串/重排/额外shell引号，不发空/null/重复-D或冲突-P。聚焦回归覆盖basic保持、remapped多目录/空格完整单参及缺失/空值。撤销首次启动前从列表选所有JVM和Python属性读取器：Gradle现有Provider→Test System直接供runner消费；正常启动JVM与被测Java8分开。Test17由Gradle原javaLauncher选择；按[Plan时序及依据](plan.md#test-worker认领与jdb连接顺序)，外层--debug-jvm的suspend=y启动期监听出现即认领唯一worker，关联Test启动Command/四字段/listener；由该PID真实exe核对同安装bin/jdb.exe，显式传入新根observe，在attach前再复核，然后等待初始暂停、设原三断点后cont。同worker内nested withDebug(true)/RunInProcess不另建待attach进程，不能等nested/compiler先到达。新根helper只延迟接收路径并补exe核对，不在导入时依赖PATH jdb、不写死旧21/目录，不改旧helper/basic或重做131项。LoadMappings java及consumer javac由原Gradle Java8 providers提供；记录实际路径/metadata与同轮有效列表对应，不自行实现候选选择或读用户properties。工具路径小自检覆盖认领后延迟传入/派生及缺失拒绝，attach前身份或listener变化拒绝；能力缺口据实报告，不装JDK或改用户配置。启动暂停受实际child连接生命周期约束，旧未attach的120秒超时不是新预算或无限暂停保证。
- 同轮验收：记录实际最终args、Test/nested工程/调用/阶段/withDebug实际帧、nested两map（systemPropertiesArgs含同名键且projectProperties无冲突-P）、gradleProperty实际值、effective installations。配置完成回调在任务图/classpath解析及任务action前直接读取原compileJava.javaCompiler.get()、打印实际compiler metadata=8/executable并关联列表；不触达sourceSets/configuration，候选存在/静态provider/System可见/旧观察不代证。回调未到达/解析失败/观察缺失不得completed。该证据只证选择，javac执行和完整消费另由M证明；真实命令/Gradle/JUnit/下游失败阶段照实保留，外层Provider无直接对象帧限制明示。
- 排他/停止：与共享测试文件及所有Forge/Gradle/TestKit/build/fixture/cache/观察点写运行串行，按最新内容保全basic；每次启动前各样本（含紧邻spawn）与结束样本分存不可覆盖，关联源码/输入/进程/调用/UTC身份，真实退出、输出drain及worker/debugger/listener收束可判，不杀他人进程，不回填旧缺口。非网络实际失败停止；缺输入/权限/能力blocked、已尝试失败failed，发现完整与否据实独立判断，缺关键观察/退出unknown不完成。无统一分钟预算、新在线额度或重试框架，工具timeout照实记录。

## Remapped 发现核查后的恢复连接

原 `RECOVER-REMAPPED-JAVA8-FORWARDING` 的全部正文、W-REMAPPED-JAVA8-FORWARDING成员/前置及G-REMAPPED-JAVA8-FORWARDING完整合同保留。原实施generation1 Result仍是completed，已采用核查completed证实整体不足以采用；Router未接受旧item完成/未释放旧gate，不改成failed。invocation-10可保留同轮技术事实，但不满足basic保持/全部回归/身份拒绝/紧邻spawn资源等缺口，更不接受十次启动后非网络失败继续或XML3+HTML6备份偏差。

只增加下列一个恢复item/Handler/Result及单成员Wave/gate，继承原发现所有要求；必要源码恢复、参数/工具聚焦回归与采样只建立这个发现终态，无独立工具或诊断交付。当前成功连接为已满足且适用的P-v6-a/Q-1165/G-REPAIRS输入→新发现恢复Result实际采用/新gate实际满足→独立完整M Result/gate→V/H。旧发现Result是核对保留效果/缺口的输入，不是成功前置；新Result不自动完成旧item或释放旧gate，也不要求旧gate转成功。偏差采用由Router/用户决定，本维护不预判、不自动豁免，不创设偏差接受item或新权限。

### RECOVER-REMAPPED-JAVA8-FORWARDING-RESTORATION — 原确认范围的完整发现恢复

- 单一谓词/Result：恢复进入时basic及producer原诊断并保留remapped增量后，在当前同版原remapped精确方法的一次新调用内，实际满足原RECOVER-REMAPPED-JAVA8-FORWARDING全部同轮属性/真实Java8选择、回归/身份/采样/排他/退出要求；一个Handler/一个独立Result。不是仅修源码、仅自检或旧成功复用，也不是完整M。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各完整采用/completed/足证据；所在W-REMAPPED-JAVA8-FORWARDING-RESTORATION等G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。原发现未满足/旧两M failed仅为历史输入，不是成功等待，不等Neo/R/D/B、完整M或自身gate，不重做已过P/Q/D/B。
- 写拥有/最小方法：仅PatchedMinecraftTests.kt原helper恢复basic与remapped均转发完整非空同值-D，并实际测试withArguments所用同一构造路径；remapped fixture仅补回printCompileClasspath末尾进入时的Producer graph循环，已有效API/provider及projectsEvaluated两行compiler输出不重做、不改变producer或consumer。只在全新build证据根修薄入口/helper副本及聚焦自检：不再复制旧XML/HTML；按真实同一java文件身份核对Process.exe/启动Command/cmdline[0]后派生同bin jdb，保留认领及attach前四字段/listener变化拒绝；紧邻Popen前完整memory/disk/排他采样分存。具体步骤/用例由[Plan五项方法](plan.md#最小修复及证据对应)拥有。旧工具/源码之外生产/Core/consumer/版本/依赖/用户配置/旧9备份与全部历史证据只读，不以Git旧HEAD替代进入工作区、不删备份/覆盖旧样本或新增框架。
- 必需回归证据：实际调用共享参数构造路径的basic/remapped保持、多目录含空格完整单argv、缺失/空值、原三个参数保留及无重复-D/冲突-P用例；实际调用私有校验函数的同文件别名正例、同安装不同合法java/javaw错配/缺jdb/四字段或listener变化拒绝；实际不复制旧输出和采样→spawn顺序、完整原资源字段/时间关系的检查。不能由文本模式、安装根相同、不合法文件名反例或文件存在代替；保留各用例输入/实际返回与本轮工具/源码身份，不重做131项。
- 同轮完整发现证据：本轮既有Provider→Test System→原方法最终唯一完整同名-D→nested System、StartParameter.systemPropertiesArgs含键/projectProperties无冲突-P（真实含同值可记录）→gradleProperty provider/effective installations→配置完成回调真实解析原compileJava.javaCompiler、metadata=8/executable与列表对应，原三断点/withDebug同worker帧及工程/调用/阶段身份齐全。原属性值不拆分/重排/加shell引号，不发空/null；正常Gradle启动、Test17/fixture.gradleJava/Java8 providers及原consumer不变。外层Provider无直接帧限制保留，不用旧invocation-10补新轮。compiler选择不证明javac执行，完整M另证。
- 排他/运行证据及停止：与原发现/完整M、共享helper/fixture及Forge/Gradle/TestKit/build/cache/观察点写运行串行，按最新源码保全basic。各次启动前排他样本及紧邻实际Popen前的完整memory/disk资源、spawn时点、after-spawn和结束样本逐次分存，按真实UTC/调用/阶段核序，不把晚于Popen或早约25.6秒的旧样本当合格；记录源码/输入/进程身份、真实Gradle/JUnit/退出、输出drain和worker/debugger/listener收束，不杀他人进程、不回填旧缺口。非网络实际失败立即停止，不因语法/工具修好或发现证据成立再启动；缺输入/权限/能力blocked、已尝试失败failed、关键观察/退出unknown不完成。发现完整且下游失败可独立判断，但真实失败/未到达阶段仍保留，停止规则不获豁免。无新增预算、在线额度、重试循环或备份机制。
- 历史/采用边界：保存原发现completed报告与核查不满足两事实、旧item/旧gate未满足、两M failed/作者blocked与实际写入矛盾、十次真实Gradle启动与非网络失败后继续、9备份及invocation-10有效技术证据。新恢复成功不删除、改判或接受历史偏差，不自动完成原发现item/释放任何旧gate；只有本项全部原发现要求在当前证据中实际满足、新Result完整采用后，Router才可判新gate供完整M，作者不作采用/放行决定。

## Remapped 自检失败后的未完恢复连接

**现行覆盖范围。** 上节RESTORATION的item/Wave/gate及其完整完成条件逐字保留，generation1已failed，新成功不回填。失败与已写效果见[Context](context.md#remapped-自检失败后的未完边界)及[仓内报告](../../../build/recover-remapped-java8-forwarding-restoration-20261025/report.md)；前节“只增加/当前成功连接”等是前轮准备时点。既有P/Q/G-REPAIRS已采用输入仍有效，新恢复不等旧failed转成功。本轮唯一新增下列未完恢复item/Handler/Result及单成员Wave/gate，辅助夹具纠正/整组自检/真实参数回归只建立原完整发现一个终态，无独立工具消费者。

### RECOVER-REMAPPED-JAVA8-FORWARDING-VALIDATION — 保留已写源码的未完完整发现

**执行状态：generation1 failed，原完成条件及本项gate未满足。** 夹具纠正及20/20通过仅保留已完成效果；shell解析exit2、零Gradle及更早exit127后继续的未接受偏差见[本轮事实](context.md#remapped-validation-shell失败与复用边界)。新成功不改判本项。

- 单一谓词/Result：保留RESTORATION已写basic/remapped共享参数函数及producer原三行，在当前同版一次新原remapped精确方法调用内满足原RECOVER-REMAPPED-JAVA8-FORWARDING及RESTORATION的全部发现/回归/身份/采样/排他/真实退出收束要求；一个Handler、一个独立Result，不交付独立工具或完整M。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各已实际采用且须保持当前适用/completed/足证据；所在W-REMAPPED-JAVA8-FORWARDING-VALIDATION等G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。旧RESTORATION failed/旧发现未满足/两M failed仅历史与保留效果输入，不是成功等待；不等Neo/R/D/B、完整M或自身gate，不重做已过P/Q。
- 写拥有/方法：只在全新build证据根沿用现有私有run.py/self-check.py副本，纠正snapshot替身输入清单使before[x]读取符合真实合同；不改变main/生产合同，不删除用例、不另造工具。源码和fixture已写效果只读保留，不重复恢复basic/producer，不改生产/consumer/版本/依赖/用户配置/Git。工具/源码如有预期外实际scope或方法差异，只报精确缺口而不扩修。未来目录build/recover-remapped-java8-forwarding-validation-next/仅普通文本预约，不是现有ref；旧工具、失败报告、9备份/十轮输出及全部旧证据不复制/删除/覆盖。
- 必需回归：同版整组原工具自检通过，含已过19项及此前KeyError未到达的main“不备份旧输出”分支/所有其余用例；保留输入与实际结果/工具身份，不用19项充整组。编译并实际执行原withArguments所用共享参数路径，完整继承basic/remapped非空、含空格多目录单argv、缺失/空值、原三参数、恰一次完整-D及无冲突-P用例。原同文件别名/合法java-javaw错配/缺jdb、四字段/listener变化拒绝、不复制旧XML/HTML、完整采样先于spawn及缺字段/倒序拒绝全部保留，不重做131项或复制实现。
- 同轮发现及运行：逐项继承RESTORATION的完整同轮Provider→Test System→最终唯一完整同名-D→nested System/StartParameter两map→gradleProperty provider/effective installations→compiler metadata8/executable与原列表对应、三断点/同worker/原JDK角色及Provider间接观察限制。真实Gradle/JUnit、紧邻实际Popen前完整memory/disk/排他、spawn/after-spawn/结束样本逐次分存及真实launcher/worker/debugger退出、drain/listener收束仍必需。受控Popen、初末idle或旧invocation-10不能补本轮缺口，选择不代完整M真实javac。
- 冲突/停止：继承RESTORATION及下表全部共享源码接点/Forge/Gradle/TestKit/build/fixture/cache/观察点串行排他，不制造分支相互成功依赖。真实非网络失败立即停止；已知夹具修正不豁免新失败后继续，缺输入/权限/能力blocked、实际失败failed、身份/观察/退出unknown不完成。不新增重试额度、分钟预算、在线运行授权或停止豁免，不接受历史偏差。旧failed与19项/已写效果分别保留；新Result须完整采用/completed且全部原发现要求实际满足，才可能由Router判新gate，仅供显式完整M，不完成旧item/释放旧gate。

## Remapped shell失败后的未完恢复连接

VALIDATION generation1为failed；唯一snapshot夹具修正和20/20整组自检已实跑通过，但编译启动将PowerShell命令直交Bash解析exit2，Gradle零启动，实际参数回归/新发现/真实启动采样及收束未执行。更早exit127后继续是单独停止偏差，未接受。证据见[Context](context.md#remapped-validation-shell失败与复用边界)、[仓内报告](../../../build/recover-remapped-java8-forwarding-validation-20261025-g1/report.md)及[Plan策略/自检](plan.md#remapped-shell恢复策略与作者自检)。上节VALIDATION原item/Wave/gate及完整谓词保留且未满足；前轮“唯一新增/待修夹具”等是准备时点。本节只增一个恢复item/Handler/Result及单成员Wave/gate，旧成功不自动采用、旧失败不回填。

### RECOVER-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY — 20/20之后的未完完整发现

- 执行状态：generation1 failed，原完整谓词及gate未满足；可选文件ENOENT后未继续，20/20适用性核对及编译/回归/发现均未完。原准备合同如下保留，不由新Result回填。
- 单一谓词/Result：保全已写basic/remapped共享参数函数、producer三行及通过自检的工具，在当前同版一次新原remapped精确调用内实际满足原FORWARDING、RESTORATION和VALIDATION全部发现/回归/身份/资源排他/退出收束要求；编译/参数回归只为此终态的内部验证，一个新独立Handler/Result，不代完整M。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各完整采用/completed/足证据且当前适用；所在W-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY等G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。旧failed/未采用completed只作历史输入，不是成功等待；不等Neo/R/D/B、完整M或自身gate。新边界须经不同Handler局部独立复核并由Router采用ready；原用户确认范围不重求许可，本作者不派发。
- 20/20复用与写拥有：按[Context工具身份/输入/环境条件](context.md#remapped-validation-shell失败与复用边界)确认run.py/self-check.py字节、修正后的snapshot输入合同/覆盖及Python/psutil/Windows同文件、进程和资源接口适用性并留复用理由；不无理由重复无变化自检、不再修夹具或恢复源码。已通过受控工具自检不代真实共享参数/发现。只在未来全新build证据根沿用现存薄入口和工具，保存本轮正常输出及必要取证，不造脚本框架；未来目录 build/recover-remapped-java8-forwarding-shell-recovery-20261025-g1 仅普通文本预约，本次不创建或作现有ref。源码/fixture/生产/consumer/版本/依赖/用户配置/Git及旧工具/证据只读保全；预期外工具/源码/环境适用性差异如实报告缺口，不扩修。
- shell与未完验证：根E:/Projects/cloche/minecraft-codev；PowerShell语法只交实际可用powershell工具，或通过明确可用的pwsh -NoProfile -Command入口，不再直交Bash。记录实际shell/cwd/命令/真实退出，先完成原 `:minecraft-codev-forge:compileTestKotlin`，沿用原编译参数；再实际执行原withArguments共享参数构造路径，basic/remapped非空/缺失/空值、多目录含空格单argv、原三参数、恰一次完整-D/无冲突-P全部既定用例，不能以文本匹配/复制实现代证。
- 完整发现及回归：逐项继承VALIDATION及RESTORATION全部条款，同版整组自检适用义务由已通过20/20及上述复用判断承接；共享参数实际回归和一次新原方法同轮Provider→Test System→唯一完整-D→nested System/StartParameter两map/gradleProperty/effective installations→真实compiler metadata8/executable关联列表仍须执行。原三断点/同worker/启动暂停认领→核同文件Process.exe/Command/cmdline[0]→同bin jdb→attach前四字段/listener复核→设断点/cont、全部原拒绝用例、外层Provider间接观察限制不减。各次启动前排他和紧邻实际Popen完整memory/disk/spawn/after-spawn/结束样本分存、真实Gradle/JUnit/launcher/worker/debugger退出与输出drain/listener收束全部必需；20/20、仅编译、旧invocation-10、受控Popen/初末idle不能替代本轮。compiler选择不代完整M实际javac。
- 冲突/停止/历史：继承下表共享helper/fixture/Forge/Gradle/TestKit/build/cache/观察点排他串行。任何新真实非网络失败含shell/进程查询/编译/参数或发现失败立即停；缺输入/权限/能力blocked、已尝试失败failed、身份/关键观察/退出unknown不完成。无新增预算/恢复分钟/在线额度/重试/权限例外，不复制/删除/覆盖旧证据。VALIDATION failed/20项已过/零Gradle、RESTORATION failed/19项/已写效果、旧发现completed未整体采用、十次启动违规/9备份、exit127后继续偏差分别保留且不接受、不改判。
- 采用与后继：只有本项全部完整谓词成立、新Result完整读取/关联/采用且足证据completed，Router才可判断新gate供独立fresh完整M；不完成旧item/gate。完整M及V/H最终12项合取不减。

## Remapped 准备错误后的独立恢复连接

SHELL-RECOVERY generation1完整failed Result已关联采用；[本轮报告](../../../build/recover-remapped-java8-forwarding-shell-recovery-20261025-g1/report.md)记载未确认存在就读取自猜可选environment.json导致ENOENT，该文件不是必需Handoff引用。零编译/原remapped启动、零实际参数回归；仅新增失败证据根和报告，未改源码/工具/旧证据/协调图，未做摘要比对，不宣称全仓稳定。20/20既有通过保留，但本轮未完成当前字节、完整输入/覆盖和Python/psutil/Windows接口适用性判断，不宣称本轮复用完成。此前shell局部ready仅覆盖未变方法，不代本次差异独立复核。

本节保留原PREPARATION准备时点合同，现行连接见下方[生命周期恢复连接](#remapped-生命周期失败后的独立恢复连接)。原PREPARATION-RECOVERY随后真实编译完成而参数启动后unknown、Result failed，原item/Wave/gate不改判；下方“open/未运行/未编译”等均为此前准备历史，不能作为当前等待。原shell恢复及更早失败不重开；编译/回归/取证仍为完整发现内部阶段，无独立工具交付。

### RECOVER-REMAPPED-JAVA8-FORWARDING-PREPARATION-RECOVERY — 准备错误边界下的未完完整发现

- 准备状态：open，未运行、无新执行Result，新gate未满足；SHELL-RECOVERY generation1 failed及未完成20/20适用性核对保留，不等待其转成功。此处复核只覆盖本次停止边界与恢复连接，旧ready对未变方法继续适用，不重复确认同范围。
- 单一谓词/Result：保全已写basic/remapped共享参数函数、producer三行及通过自检的工具，在当前同版一次新原remapped精确调用内实际满足原FORWARDING、RESTORATION和VALIDATION全部发现/回归/身份/资源排他/退出收束要求；编译/参数回归只为此终态的内部验证，一个新独立Handler/Result，不代完整M。
- 前置item：ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各完整采用/completed/足证据且当前适用；所在W-REMAPPED-JAVA8-FORWARDING-PREPARATION-RECOVERY等G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。旧failed/未采用completed只作历史输入，不是成功等待；不等Neo/R/D/B、完整M或自身gate。新边界须经不同Handler局部独立复核并由Router采用ready；原用户确认范围不重求许可，本作者不派发。
- 20/20复用与写拥有：按[Context工具身份/输入/环境条件](context.md#remapped-validation-shell失败与复用边界)确认run.py/self-check.py字节、修正后的snapshot输入合同/覆盖及Python/psutil/Windows同文件、进程和资源接口适用性并留复用理由；不无理由重复无变化自检、不再修夹具或恢复源码。已通过受控工具自检不代真实共享参数/发现。只在未来全新build证据根沿用现存薄入口和工具，保存本轮正常输出及必要取证，不造脚本框架；未来目录 build/recover-remapped-java8-forwarding-preparation-recovery-next 仅普通文本预约，本次不创建或作现有ref。源码/fixture/生产/consumer/版本/依赖/用户配置/Git及旧工具/证据只读保全；预期外工具/源码/环境适用性差异如实报告缺口，不扩修。
- shell与未完验证：根E:/Projects/cloche/minecraft-codev；PowerShell语法只交实际可用powershell工具，或通过明确可用的pwsh -NoProfile -Command入口，不再直交Bash。记录实际shell/cwd/命令/真实退出，先完成原 `:minecraft-codev-forge:compileTestKotlin`，沿用原编译参数；再实际执行原withArguments共享参数构造路径，basic/remapped非空/缺失/空值、多目录含空格单argv、原三参数、恰一次完整-D/无冲突-P全部既定用例，不能以文本匹配/复制实现代证。
- 完整发现及回归：逐项继承VALIDATION及RESTORATION全部条款，同版整组自检适用义务由已通过20/20及上述复用判断承接；共享参数实际回归和一次新原方法同轮Provider→Test System→唯一完整-D→nested System/StartParameter两map/gradleProperty/effective installations→真实compiler metadata8/executable关联列表仍须执行。原三断点/同worker/启动暂停认领→核同文件Process.exe/Command/cmdline[0]→同bin jdb→attach前四字段/listener复核→设断点/cont、全部原拒绝用例、外层Provider间接观察限制不减。各次启动前排他和紧邻实际Popen完整memory/disk/spawn/after-spawn/结束样本分存、真实Gradle/JUnit/launcher/worker/debugger退出与输出drain/listener收束全部必需；20/20、仅编译、旧invocation-10、受控Popen/初末idle不能替代本轮。compiler选择不代完整M实际javac。
- 冲突/停止/历史：继承下表共享helper/fixture/Forge/Gradle/TestKit/build/cache/观察点排他串行。仅两类准备错误可纠正继续：可选材料定位错误，或有返回/执行证据确认目标进程尚未启动的命令解析错误；先据真实返回及执行记录分类，保留错误、依据和纠正记录，确认无未知副作用且不扩大原范围后再继续。错误返回本身不证明零执行；效果未知先只读核实，未能消除未知即停，不盲重试。先利用既有文件清单定位，禁止猜文件名作必需证据；可选材料不存在可查正确来源，不伪造environment文件；必需输入确实缺失仍blocked。实际工具自检、编译、参数回归或内容/发现验证失败，以及身份不明、资源冲突、退出状态未知仍立即停止，不扩展为一般非网络纠错或重试机制。 缺输入/权限/能力blocked、已尝试失败failed、身份/关键观察/退出unknown不完成。除上述两类已确认准备错误外无新停止例外；无新增预算/恢复分钟/在线额度/重试/权限扩展，不复制/删除/覆盖旧证据。VALIDATION failed/20项已过/零Gradle、RESTORATION failed/19项/已写效果、旧发现completed未整体采用、十次启动违规/9备份、exit127后继续偏差分别保留且不接受、不改判。
- 采用与后继：只有本项全部完整谓词成立、新Result完整读取/关联/采用且足证据completed，Router才可判断新gate供独立fresh完整M；不完成旧item/gate。完整M及V/H最终12项合取不减。

## Remapped 分结果恢复与证据关联

[Work](work.md)、[Plan](plan.md#remapped-分结果恢复策略与作者自检)与[Context](context.md#remapped-独立结果与差异核对采用事实)匹配。此处登记本图原发现成功连接，其g1已完整采用但仅适用原版本；下节LIFECYCLE-RECOVERY原复合合同及其单成员Wave/gate仅保留原要求和failed历史，不继续派发、不要求其转completed。20项passed是该failed结果内可保留检查事实，不能另造一个20项completed Result。独立恢复/参数/Java8已发生终态以下分别登记，不重新执行或由作者判它们gate满足。

### RECOVER-REMAPPED-LIFECYCLE-FIXTURE — 原生命周期夹具恢复记录

- 单结果边界/历史：局部psutil代理修正后的生命周期检查结果，原Result failed；11项passed与第12项缺run.py的FileNotFoundError/exit1同存。只读关联[夹具报告](../../../build/recover-remapped-arguments-lifecycle-20261025-g1/fixture-recovery-report.md)，不重复修正或重跑11项，不把旧failed改成功。
- 前置item：无新的成功等待；原LIFECYCLE-RECOVERY的已写工具和20项为保留输入，不等其failed转成功。所属Wave仍保留G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165前置。
- 原完成/证据：被恢复检查全部通过且Result completed/足证据/采用才满足本item；实际failed不满足，11项不能冒充全12项。写拥有/冲突：原证据根内self-check及驱动/输出，原运行已终止；现在只读，和工具/证据变动串行，不新增实施权限。

### RECOVER-REMAPPED-LIFECYCLE-COMPILE-CHECK — 第12项独立恢复记录

- 单结果边界/历史：仅补临时compile-identity-failure夹具的同hash run.py，完成第12项compile身份失败保全检查；其独立Result completed。[报告](../../../build/recover-remapped-arguments-lifecycle-20261025-g1/lifecycle-recovery-report.md)及[结果](../../../build/recover-remapped-arguments-lifecycle-20261025-g1/lifecycle-recovery-result.json)为可读仓内记录；不重跑前11项，不回填原两次failed。
- 前置item：无新的成功等待；上述failed结果的11项/源码为历史输入而非待转成功前置。所属Wave保留原三成功gate。
- 完成/证据：该独立Result completed/足证据并被完整关联采用，证明受控Popen→Capture→identity、身份unknown仍保全proc/可得退出/output且拒绝成功、实际exit0和受保护工具身份；不证明真实身份失明或整组32/32成功。原写拥有仅临时夹具/本轮证据，当前只读；与相应工具/输入/证据变动串行，无新的修正/重跑权限，作者不判gate。

### VERIFY-REMAPPED-ARGUMENTS — 独立真实参数结果记录

- 单结果边界/历史：临时ArgsCheck自身编译与basic/remapped四输入共8项真实参数结果，其独立Result completed；不是完整发现。前置item：RECOVER-REMAPPED-LIFECYCLE-COMPILE-CHECK；11项、聚焦20项及已编译真实helper为保留输入/适用性证据，不等待旧failed转成功。所在Wave等该检查gate及原三成功gate。
- 完成/证据：独立Result completed/足证据/完整采用，实际一参helper/System四输入/原jar、printCompileClasspath、-s/唯一非空完整-D单argv/无冲突-P、恢复System属性，单Java真实身份exit0/EOF/reader结束无error/drain、8项加汇总9行及源码/class/stdlib/Java/hash/命令输出收束关联全部成立。[参数报告](../../../build/recover-remapped-arguments-lifecycle-20261025-g1/parameter-regression-result.md)承载既有事实，不以文本匹配、复制helper或8次Gradle冒充。
- 原写拥有仅本证据根harness class/正常参数取证，当前只读保留；与同根工具/共享class或相关输入变动串行。不得重新编译已通过Kotlin、修真实helper/配置/生产或重跑已过8项；原失败、unknown及停止事实保留，作者不判gate。

### VERIFY-REMAPPED-JAVA8-EVIDENCE — 独立同轮Java8选择记录

- 单结果边界/历史：一个原remapped精确入口的Java8选择证据，其独立Result completed；不验完整发现或M。前置items：VERIFY-REMAPPED-ARGUMENTS、RECOVER-REMAPPED-LIFECYCLE-COMPILE-CHECK、FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165。所在Wave等参数/检查gate及原三成功gate。
- 完成/证据：独立Result completed/足证据/完整采用，同一次invocation的Provider代码→Test System→runner唯一完整-D→nested System/StartParameter两map→gradleProperty/effective installations→真实compiler executable/metadata8，worker三断点、同文件Java/同安装jdb/attach核身份listener、紧邻spawn完整memory/disk/after/end分存排他、Gradle0/JUnit1/0/0/0及真实退出/drain/listener收束成立。外层Provider间接观察限制明示，不升级为直接对象帧；[Java8报告](../../../build/remapped-java8-evidence-20261025-g1/java8-result.md)仅选择范围，compileJava/jar UP-TO-DATE不证明fresh消费，自动广义assessment仅未审输入。
- 原写拥有仅Java8新根薄入口副本与正常Gradle/fixture取证输出，当前只读保留；不授权新运行或改工具/源码/配置。原运行与全部共享Gradle/TestKit/build/cache/fixture/观察点串行，历史采样不代未来排他；参数/实际自检/编译/发现非网络失败、关键身份/退出unknown仍停，不追溯接受旧偏差，作者不判gate。

### ASSESS-REMAPPED-DISCOVERY-EVIDENCE — 原完整发现的跨结果适用性关联

- 单一谓词/已采用状态：generation1 completed已完整采用、原版本G-REMAPPED-DISCOVERY-EVIDENCE满足是最新已接受事实，本轮只登记、不重判或重跑。原只读关联范围为既有结果逐项覆盖原FORWARDING/RESTORATION/VALIDATION/PREPARATION/LIFECYCLE完整发现要求；下列原证据/停止合同保留。其helper/class/工具/环境版本限定不变，不证明本轮候选新版本；新差异由VERIFY-REMAPPED-NESTED-RERUN-REGRESSION补证，不再派发原关联。
- 前置items：FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165、RECOVER-REMAPPED-LIFECYCLE-COMPILE-CHECK、VERIFY-REMAPPED-ARGUMENTS、VERIFY-REMAPPED-JAVA8-EVIDENCE，各在其范围完整Result采用/completed/足证据且身份适用；所在Wave等待原三成功gate及这三份独立结果gate。原复合/夹具failed、旧审查blocked、已采用差异核对completed仅为保留输入，不作失败转成功等待、不以核对completed替代本谓词。
- 充分证据：逐份核对ArgsCheck源码/class、真实helper源码/class/加载位置、run/arguments/compile/self-check各轮字节、Java/javac/stdlib/环境与命令，关联参数8项到同轮真实runner消费；对20项和11+1逐项建立检查→函数/调用方/输入/夹具差异/环境适用关系。保留self-check原c23c7603…与后585582b6…差异、两次整组failed，不把新hash或分段通过当一次整组passed；共享spawn/Capture影响涵盖arguments.py、compile.py、run.py::main及原拒绝/采样检查，未变项逐项解释适用，不能只称“有20项”。按原完整清单核对Java8那一次invocation全部同轮属性/来源/两map/compiler、三断点/身份、实际采样时序/资源/排他/真实退出与Capture无读错EOF drain依据；不跨旧轮补证，不凭文件名遗漏否定已存载荷。既存Producer graph各9行可审，但不代完整M来源/fresh消费；外层Provider无直接帧、UP-TO-DATE/未重验manifest/Jar/HTML等范围限制逐项保留并判清义务归属。
- 完成/停止：只有本Result completed/足证据、逐项原发现义务全部覆盖且Router完整读取/关联/采用才可满足本item及新gate；缺证、真实差异、输入/环境/版本不适用、unknown或partial/failed/blocked不满足，只报告精确缺口，不自动重跑/扩修/接受偏差或声明齐备。历史结果始终保留各自终态，不由本次关联回填旧item/gate；新成功仅供独立fresh完整M双层前置，不增加第13个完整消费者。
- 写拥有/冲突：只读既存仓内源码/工具/输入/报告/原始证据，输出关联结论及可复核仓内定位到本独立Result，不新增证明文件体系/签收/审批门槛，不写权威/图/源码/配置/旧证据；无构建/测试/下载/Java/工具脚本运行权限。与被核对对象变动串行；若只读不能闭合原义务，停受影响采用并报告，不擅增运行任务。已确认两类准备错误例外/其余真实失败与身份退出unknown停止规则不减。

## Remapped 生命周期失败后的独立恢复连接

**历史复合准备合同，非继续执行单元。** 下列“一个未完终态/不单列Result/open/尚无Result”均限独立结果产生前；原修正及20项在原整组自检failed中保留，原全部完成/验证合同和旧gate不满足保留。已独立执行终态与现行只读关联按上节登记，不重新运行本复合项。

[Work](work.md)与[Plan恢复策略/作者自检](plan.md#remapped-生命周期恢复策略与作者自检)为本图的同目录owner；[Context](context.md#remapped-参数unknown失败与生命周期恢复依据)给出已采用失败、精确源码/日志、独立复核原not-ready及用户现确认的扩展边界。仅新根临时harness合同与生命周期/受影响检查共同建立一个未完完整发现终态，没有独立工具采用或消费者，不单列Result；不同Handler完整M仍为独立消费终态。现有item保持open/尚无Result，原PREPARATION及更早failed/item/gate不满足不回填。原harness权限缺口现已明确覆盖，本次只准备其具体纠正和局部独立复核范围，不宣称已修好/ready，不选派或放行。

### RECOVER-REMAPPED-JAVA8-FORWARDING-LIFECYCLE-RECOVERY — 保留真实编译后的未完完整发现

- **范围/前置：** 仅未来新证据build根纠正临时ArgsCheck的一参反射/System属性输入/原参数oracle及其自身编译，并纠正Popen→唯一Capture/立即真实身份→慢采样→wait/drain与异常保存、Capture.thread接缝；继承原FORWARDING/RESTORATION/VALIDATION/PREPARATION完整方法及用户现确认边界，不重放旧执行。前置items为 `FIX-RESOLUTION`、`FIX-DISCOVERY`、`TEST-FABRIC-UTF8`、`ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE`、`VERIFY-FORGE-PATCH-1165`；所在Wave前置同原三个适用成功gate，不等待任何旧发现/旧M失败。真实helper/PatchedMinecraftTests.kt/生产/fixture/用户gradle.properties/其它配置/Git/旧证据只读；编译来源/class身份适用则保留真实成功，不重跑已通过compileTestKotlin，漂移报告缺口而不自行扩编译范围。
- **完成谓词：** 唯一独立完整Result completed/足证据且Router完整采用。新ArgsCheck只反射实际 `patchedMinecraftArguments(String)`，以basic/remapped原工程名为唯一实参；在参数测试JVM逐例System.clearProperty/setProperty注入 `org.gradle.java.installations.paths` 的缺失/null、空、非空多目录、含空格多目录，调用真实原编译helper而非复制函数，断言 `[jar, printCompileClasspath, -s]` 及仅非空时唯一完整同名-D单argv/无冲突-P，恢复原System属性。新同版薄入口全部共享调用/Capture单一所有权/异常proc保全与可得退出输出保存、每份新字节SHA-256和受影响合同/生命周期/拒绝/采样检查、未变检查逐项适用依据成立。真实参数一次新Java运行具备真实身份/exit0/Capture.thread结束且无error的EOF drain、basic/remapped×4共8项passed及汇总9行的class/方法/输入/进程/时间关联；只在全部通过后一次新同版原remapped精确方法完整闭合原全部属性/来源/两map/gradleProperty/effective installations/实际compiler metadata8+executable、worker三断点/同文件Java/jdb与attach前身份listener、紧邻pre-spawn完整memory/disk与after/end分存/排他及Gradle0/JUnit1/0/0/0/真实退出收束，Provider观察限制保留。任一缺证/partial/failed/blocked/unknown均不满足；立即取身份亦不保证短进程可采到，unknown必须失败，不吞错通过。
- **证据/停止：** 原report/compile证据和原20/20复用判断保留在原根只读；新根记录ArgsCheck源码及class、run.py/arguments.py及受影响compile.py/self-check.py等每份实际新字节SHA-256、来源/差异/共享调用影响与检查对应，另关联真实helper源码/class/stdlib/Java/加载位置和实际命令、真实参数output/process-end/result、完整新invocation的全部同轮链及收束。旧20/20仅按来源/输入/环境适用条件保留，不标作新hash整组通过，不用旧Java缺失结果/旧invocation或受控检查补新真实证据；未来Result只引用仓内相对证据，不把预定新根当现存证据。参数失败/unknown不得启动完整发现；旧实际启动unknown不属两类准备错误豁免。异常保存可得exit/output仍不代身份；无睡眠、无限等待、一般重试、新框架或真实helper/生产修正。最小方法不能满足或需要已确认harness/接缝之外变更即报告Router，不自行接受；两类准备错误例外仅按PREPARATION原文字条件保留。
- **冲突/消费：** 与完整M、D/B及其它共享Test/fixture/Gradle资源写入者串行，未来启动仍须即时排他；共享spawn_sampled迁接涵盖arguments.py/compile.py/run.py::main及现有self-check接缝，无需重跑已通过编译或无关已过分支。结果只供下方不同Handler独立fresh完整M的item和Wave双前置，不等于M或最终验收，不完成旧item/gate或接受历史偏差。

### RECOVER-REMAPPED-PATCHED-CONSUMER-RECOVERY — 保留已写fixture的完整原M消费

**历史消费边界：** verify-remapped-fresh-consumer generation1在启动前blocked，零写入零构建，原gate未满足。本节保留原完整合同，不继续派发、不改为成功；现行恢复为RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN，其fresh/有效缓存解释及前置以本图首节和匹配Plan为准。

- 单一谓词/Result：原PatchedMinecraftTests#Test remapped patched Minecraft精确方法一次当前fresh调用完整闭合原M named消费；一个不同后继Handler/一个独立Result。只发现Java8、配置通过或前项摘要不能完成本项。
- 前置item：ASSESS-REMAPPED-DISCOVERY-EVIDENCE、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165，各完整Result采用/completed/足证据；所在W-REMAPPED-CONSUMER-RECOVERY等G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165。不等原两M failed/旧gate、Neo/R/D/B或自己gate。 原发现generation1原始completed未获采用、旧发现item/gate仍未满足；本新前置实际满足原发现全部要求后才可消费，不能以核查completed或旧invocation-10直接放行。
- 写拥有：保留发现项已写runner、fixture API/provider及配置完成compiler取证回调；本项仅全新build根内本轮私有薄入口/取证及正常Gradle/fixture生成输出，不重做有效接线/迁移。本项自己的新调用复用已纠正共享生命周期的适用同版薄入口并记录实际hash/Capture所有权及异常收束依据，不退回旧扫描先于Capture的入口；重新沿用[Plan启动暂停→认领→派生jdb→复核attach→设断点/cont顺序](plan.md#test-worker认领与jdb连接顺序)，不消费前项worker/调试器身份或旧观察；同安装jdb实际能力须本轮证明。正常外层Gradle启动、nested withDebug同worker、LoadMappings8/consumer javac8由原providers供给均不变，不再有首次启动前选候选或Python属性读取器。旧工具/报告/输出只读，无固定本机JDK、用户配置/生产/consumer/依赖写权限。实际需越界修fixture/能力则报告，不借验证顺手修复。
- 充分证据：固定MC1.16.5/Forge36.2.39/userdev及完整userdev/MCP/universal/libraries/modules真实解析身份→ResolvePatchedMinecraft实际patched→official client mappings(server=false)→Java8 executable的LoadMappings按official→MCP→真实Tiny含obf/srg/named→显式srg→named RemapTask与producer/provider实际图→原Java8 EVENT_BUS/named Entity.class consumer真实compileJava/jar/printCompileClasspath；fresh patched/named Jar、当前consumer class/Jar、完整classpath/字节身份关联。本轮完整唯一-D值、Test/runner/withDebug帧、nested System/StartParameter两map/gradleProperty provider/effective installations/实际compiler metadata/executable齐全；前项/旧轮/Q/D/P观察不补证。原selector真实Gradle exit0、JUnit1/0/0/0、task outcomes、命令/日志/源码输入稳定、正向真实退出/输出收束全部必需，控制器0不代Gradle0。
- 排他/停止：同发现项冲突及启动前/结束各采样分存、真实worker/debugger/监听退出要求，不杀他人进程、不覆盖/回填旧样本。任何缺证/失败/skip/退出unknown不完成，不释放新gate，更不释放G-RECOVERY/G-REMAPPED-API-RECOVERY。完整成功仅供显式V/H，不取消其fresh三模块/根入口/历史合取；无统一分钟预算或新增在线额度。

**V/H必要证据连接。**当前M须联合消费已采用原版本发现、新WIRE未完验证恢复及受影响版本回归，实际输入为RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN/G-REMAPPED-CONSUMER-RERUN；只在它完整成立后进入V/H，历史发现不能代新hash验证或真实消费。 并须保留原WIRE及恢复g1 failed/源码输出已补但未验证、诊断completed仅只读及历史未知的边界，新验证恢复不回填旧gate。下列V/H及最终第1/9款中的“M消费新发现Result/gate”现消费ASSESS-REMAPPED-DISCOVERY-EVIDENCE及其新gate实际满足的原全部发现覆盖前置，不消费旧复合failed/gate。须关联分段20项/11+1、参数及Java8独立结果与两failed/旧审查blocked/日志各9行纠正的范围和限制；必须关联PREPARATION-RECOVERY generation1 failed、真实编译exit0/输出收束、20项旧字节适用已完成而参数PID300888身份/Java退出/drain unknown且旧结果不可恢复，以及SHELL-RECOVERY generation1 failed/可选environment.json ENOENT/零构建及当时适用性未核完，以及VALIDATION generation1 failed、20/20已过但shell解析exit2/零Gradle/编译和参数及发现未运行、更早exit127后继续未接受偏差，以及RESTORATION generation1 failed、历史19项非整组成功、已写basic/producer但未编译、原停止事实。V/H仍直接等待独立完整M，显式新发现前置不能代完整M、改变12项完整恢复合取或回填任何旧gate；其它技术/历史要求不变。

- 统一代理现行前置：准备Result PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY与最终只读审计Result VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION各自completed并被采用，且G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE满足；该完整gate仍合取13个结果/gate及最终审计，并要求原合成根来源/逐键三态/HTTPS空值/Properties转义等未覆盖证据齐备；有限THREE-MODES成功不代完整通过。本次T-Neo单次启动仅按页首例外解除完整代理等待，其原其它必要前置和完整成功条件保留；V/H仍等待本段完整gate。

- 单一谓词：已采用 Mixin、原 partial 成功接线的当前对应、三组真实私有入口 T/生产 P-v/basic 与两组 Q/独立回归 R/patch后完整同轮 D、完整 basic B、独立 remapped M 及原三局部修复在同一最终内容上满足完整原组合合同和新增恢复证据，fresh 三模块、Forge 三类和根入口实际闭合。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY、VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION、VERIFY-REMAPPED-NESTED-RERUN-REGRESSION、FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8、RECOVER-FIXTURE-RULE、RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION、PREPARE-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-CPW-MODS、RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX、TEST-FORGE-PATCH-NAMESPACE、RECOVER-BASIC-JAVA8-POSTPATCH、RECOVER-BASIC-ARTIFACTS、RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN；所在 W-REVERIFY 等待 G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE、G-REMAPPED-NESTED-RERUN-REGRESSION、G-REPAIRS、G-FORGE-PATCH-REGRESSION、G-BASIC-JAVA8-POSTPATCH、G-REMAPPED-CONSUMER-RERUN。三组 T/P-v/Q 为输入，R 为必需真实回归质量门槛，D/B/M 各自终态不能省略；各显式前置都须完整采用/completed/足证据，不凭 D gate 略过 P-v/R/完整 B/M。原P-n generation1 partial（保留源码/原gate不满足，仅消费新P-n-v足证据）、原P及P-recovery各generation1 partial/Object父集错误及deadline后postprocess限制/原gate不满足、T-basic-v3已采用completed及首轮DNS失败、NORMAL-RETRY failed、token partial及更早 failed/partial/blocked、首轮组合 failed 与各旧 gate 不满足完整保留，仅作证据输入，不要求它们转成功或 G-RECOVERY 释放。
- 写入拥有：只生成新的运行/取证产物，不改实现、fixture/build 脚本、权威、图或旧证据。新的证据目录是未来输出，不是当前已存在证据。
- 证据：参数独立Result/gate与M分别核对，remapped观察按本次第9款替换，不恢复已撤销jdb/私有自证；basic及其它未变合同仍有效。完整满足下述 G-RECOVERY-INTEGRATION 的逐项合同与 [Plan 全量验证](plan.md#验证分层与最终组合)，独立 Result 关联原三 completed、已采用 Mixin、两次Java8 partial/原成功接线事实、NORMAL-RETRY failed及全部限制、旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及T-basic-v历史调用/启动/退出unknown 及独立 T-basic-v3/T-1165/T-Neo/P-v/Q-1165/Q-Neo/R/POSTPATCH D、完整basic B与独立 remapped Result、旧 basic blocked 和首轮三失败。保留补丁阶段/固定 basic 空集适用性与覆盖损失；不是只补跑三失败、把历史局部报告拼接或用根缓存替代 fresh。
- 统一代理现行前置：准备Result PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY与最终只读审计Result VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION各自completed并被采用，且G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE满足；该完整gate仍合取13个结果/gate及最终审计，并要求原合成根来源/逐键三态/HTTPS空值/Properties转义等未覆盖证据齐备；V/H不改等有限THREE-MODES gate，T-Neo及其它前置/原合同保留。

- 单一谓词 H：不同于实施和复验者的 Handler 对最终实际内容独立核对原三谓词、已采用 Mixin、三组真实fixture T/生产P-v/basic与两组Q/反例R、原partial成功接线加patch后完整D、完整basic B与独立remapped M及最终fresh V和历史映射证据，明确范围内接受/不接受和残余风险。
- 前置item：RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY、VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION、VERIFY-REMAPPED-NESTED-RERUN-REGRESSION、FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8、RECOVER-FIXTURE-RULE、RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION、PREPARE-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-CPW-MODS、RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX、TEST-FORGE-PATCH-NAMESPACE、RECOVER-BASIC-JAVA8-POSTPATCH、RECOVER-BASIC-ARTIFACTS、RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN、VERIFY-RECOVERY；所在 W-ACCEPTANCE 等待 G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE、G-REMAPPED-NESTED-RERUN-REGRESSION、G-RECOVERY-INTEGRATION、G-REMAPPED-CONSUMER-RERUN。各组 T 的来源/隔离、P-v/basic 与 Q 两组实际输出、R 真实回归与 D/B/M/V 全部汇合；不同于实施/复验者的 Handler 必须读取上述各完整实际 Result、原P-n generation1 partial（保留源码/原gate不满足，仅消费新P-n-v足证据）、原P及P-recovery各generation1 partial/Object父集错误及deadline后postprocess限制/旧gate不满足与T-basic-v3 completed/首轮DNS失败、旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及T-basic-v历史调用/启动/退出unknown、T-basic-v2真实Gradle退出/后代结束原因unknown/原 gate 未满足、阶段适用性与覆盖损失、NORMAL-RETRY failed原报告/未到compiler/偶然Jar及采用诊断边界、token partial/工具/131项离线限制、更早两partial/有限failed/观测恢复failed/blocked与首轮153/150/3/0及全部旧限制、最终实际差异和运行证据；不能只读作者摘要或拼接旧观察。
- 写入拥有：只读评估，除报告外不改实现、权威或图。评估 completed 不等于结论接受；仍须明确原三项、Mixin/basic/remapped 完整恢复及 basic 新发现证据与完整验证是否实际成立。
- 证据：参数独立Result/gate与M分别核对，remapped观察按本次第9款替换，不恢复已撤销jdb/私有自证；basic及其它未变合同仍有效。核对 Plan 同一局部/完整模块清单、首轮153到所有当前案例的映射、新增恢复证据及 fresh/根入口/输入一致性；逐项消费 G-RECOVERY-INTEGRATION 第9款的两 invocation 最终 arguments、nested 属性/StartParameter/toolchain 实际观察，独立判定共享 Test/withDebug 的影响及未决缺口，应核对basic/remapped非空时各一个完整同名-D，不得以参数存在推断实际toolchain成功。诊断完成、计划 review、作者自检、旧 failed 组合都不替代实际复验。
- 冲突：与所有最终内容写入和不稳定取证运行冲突。不能自行改权威、发布、完成 item 或释放 gate。旧等待 VERIFY-COMBINED / G-INTEGRATION 的验收连接留作历史，未执行或通过；本次仅显式改为下文逐项重建原合同的新 gate。

## 预算撤销后的执行准备边界

**用户已取消统一分钟预算，完整执行合同保留。** P-n/P-v6不再受统一1800秒/30分钟、起点前UTC/单调配对、跨Handler共同原点/宿主可比性、交接扣时、Result发布末值、全链阶段上界、60秒收束及独立保存余量证明约束；不调查或创造替代预算前置。P1机制未建立/P2证据不足和原not-ready仍属历史，不是技术修好或独立复审通过。原生产修复及完整验收范围已确认，不重求预算起点或不变范围许可；本次仅四文档维护及作者自检，受影响边界独立复审、实际执行与gate足证据未由作者完成。

原T-basic-v3→P-n→P-v6与两Result合同保留其规划时点；P-n partial采用后现行成功连接为T-basic-v3→P-n-v→P-v6，各自单成员Wave/gate与独立Result，原P-n及旧gate不回填。8个完整P消费者和Q/R/D/B/M/V/H业务依赖不变，详见[恢复现行连接](#overlay-未完验证的现行连接)。正常网络全链最多3次（含hit），完整日志/失败分存、前次真实退出和输出收束、输入/实际加载身份及即时排他继续适用，真实内容差异/缺字段、身份不明、冲突或控制退出unknown仍停止；单次工具超时遵守实际工具合同，不据此恢复统一分钟门槛。两owner/version10/input和四引用修正不代新实际加载、完整4782及原全部oracle、真实miss/rebuild/same-path hit及再次oracle。所有共享source/编译/Gradle/TestKit/fixture/build/cache/input写运行仍串行；源码gate不直接放行完整P消费者，不完成或释放任何实际item/gate。作者检查见[Plan](plan.md#分钟预算撤销与作者自检)，决定及前次blocked纠正见[Context](context.md#分钟预算撤销的用户决定与现行边界)。

### 统一预算执行准备阻断

**历史：下列为撤销前的准备阻断原文。** P1/P2调查未技术闭合，以下“当前不得开始/须补证/须再确认”仅限当时；现已因政策撤销退出前置，不继续调查，也不由历史段落重新设门槛。

**当前not-ready，不是新item/Wave/gate。** 已提供的独立预算局部复审P1/P2仍未闭合；[Plan现有机制/逐阶段耗时矩阵](plan.md#预算复审阻断与现有证据)、[Context采用事实](context.md#统一预算复审采用与证据缺口)和[作者自检](plan.md#预算复审修订作者自检)共同限定本图。旧Stopwatch取ticks/Frequency再转Python time.monotonic的可读链，没有证明新两Handler的共同原点/宿主启动身份/等待休眠/配对误差/Result保存终点；旧失败1466.68秒及嵌套阶段观察没有新全链上界。不能将字段要求、旧脚本timeout、未来确认或届时再测当作现有执行能力。

FIX-FORGE-GAME-RENAME-INHERITANCE（P-n）与VERIFY-FORGE-REBUILT-CONTENT（P-v6）当前均不得进入执行准备。P-n首次核查前须已有P1具体可取得机制依据、P2全部阶段保守耗时/上界与不确定性、至少60秒收束和独立保存余量的可行合计，且受影响边界复审无阻断/具体范围及预算起点变更已确认；本次没有满足或释放这些条件。将来合法启动后仍从P-n首执行相关核查前的原始双时钟至P-v6最终证据/Result保存共用唯一1800秒；交接完整读取/采用等待与P-v6方法加载均扣入，缺证或余量unknown/不足即停，不能先实施P-n再令P-v6重起钟、延长或降验收。

两item/独立Result/唯一Wave归属、P-n→P-v6前置与两个原gate身份不变；G-FORGE-GAME-RENAME-INHERITANCE只证明源码修正，完整P只由G-FORGE-REBUILT-CONTENT供Q-1165/Q-Neo/R/D/B/M/V/H；V/H全部分支合取和第10款仍在。它们的原前置和共享源码/编译/Gradle/TestKit/fixture/build/cache/input冲突不因文档补证或新根消失。未把复审或补测缺证变成新成功依赖/item，不运行或释放任何gate，全部旧failed/partial/unknown保留。

## 实际冲突与排他规则

原WIRE、恢复g1及最新验证恢复g1 failed/已写效果保留，私有成功等待已撤销。现行参数回归与完整M互无成功前置，但共享PatchedMinecraftTests/helper/class及Forge/Gradle/TestKit/build/fixture/cache写运行必须串行，与D/B/R/V及相关输入写入同样冲突。每次启动前即时核对排他和可靠相关身份，不以旧采样代当前；未知/冲突/真实失败停止并保全输出/实际退出、有界收束自有进程，不要求Capture内部自证/逐层采样凭据、不杀他人daemon或扩大重试。

| 冲突关系 | 真实资源/约束 |
| --- | --- |
| P-recovery ↔ 原两owner / T / Q / R / D / B / M / V / H | 原P代码效果保留；新内部验证/共享Forge/helper/fixture/Gradle/TestKit/build/cache/输入写运行串行排他。独立结果不表示并跑；不增加R→D/B/M或D/B→M成功等待。 |
| FIX-RESOLUTION ↔ FIX-DISCOVERY | MixinInputBindingTests.java、MixinResourceTests.java、ordinary build/static fixture 及关联 caller 共享写入；原已完成结果不重放，未来必要改动须按最新内容串行。 |
| RECOVER-FIXTURE-RULE ↔ 原 Mixins 写入 | Fixture SPI、相关消费者的行为接点及内容稳定性；若发生重叠必须串行，不能覆盖既有修复。 |
| RECOVER-FIXTURE-RULE ↔ 两 Forge 恢复 | 源码写拥有不重叠、无业务成功依赖；局部验证共享根工程、Mixins/core/remapper/Forge build、Gradle/TestKit、fixture 与 cache，不能并跑。 |
| RECOVER-BASIC-PATCHED（旧 blocked）、RECOVER-BASIC-JAVA8（旧 partial）、RECOVER-BASIC-JAVA8-RETRY（旧partial）、RECOVER-BASIC-JAVA8-BOUNDED-RETRY（旧failed）、RECOVER-BASIC-JAVA8-RECOVERY（最新旧failed）、RECOVER-BASIC-JAVA8-TOKEN-RECOVERY（旧partial）、RECOVER-BASIC-JAVA8-NORMAL-RETRY、RECOVER-BASIC-ARTIFACTS ↔ RECOVER-REMAPPED-PATCHED及原发现、新发现恢复与完整M项 | 原 basic 发现项已完成共享 Forge build.gradle.kts 的 Test 标准属性传递和 PatchedMinecraftTests.kt basic runner；新正常重试仅在新证据目录复用token/身份/观察工具，必要时最小绕开过严retry分类，不重做token/身份/观察实现或离线检查/接线；原remapped不获同名runner权限限旧item；原发现已实施但basic被排除；RECOVER-REMAPPED-JAVA8-FORWARDING-RESTORATION已failed，basic/remapped共享函数和producer三行已写未编译、工具19项后KeyError停止且零Gradle启动；RECOVER-REMAPPED-JAVA8-FORWARDING-VALIDATION已failed，夹具纠正与20/20通过但shell解析exit2/零Gradle、更早exit127后继续未接受；原RECOVER-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY与PREPARATION-RECOVERY均failed；后者真实编译exit0/输出收束及旧20/20适用判断保留，参数身份/退出/drain unknown不可恢复。历史LIFECYCLE-RECOVERY准备仅新根按用户确认纠正临时ArgsCheck一参/System属性四输入/原三参数oracle和共享生命周期接缝，逐份新字节记SHA并补受影响检查；不重跑编译、不改真实helper/源码/用户配置、不把旧20/20当新字节全通过，真实8项+汇总9行及身份/exit0/drain全通过后才一次新完整发现。该旧复合安排已由上方分结果恢复登记取代：原两failed保留，第12项/参数/Java8各独立结果；新只读ASSESS-REMAPPED-DISCOVERY-EVIDENCE与相关源码/工具/证据写入串行，后继独立fresh完整M及V/H仍消费原全部合同，不接受历史偏差，下文原 remapped“与 basic 相同”的边界仅指原生产/版本/consumer/TestKit 限制。共享外层 Test 配置/同一测试 JVM 影响、同文件取证接点（含新发现项必要的remapped fixture配置完成compiler取证回调）、Gradle/build/fixture/cache 均排他，按最新内容串行；各自脚本独立不代表可并跑，不制造相互成功前置；原发现的completed报告未获采用、9个备份/非网络失败后继续的历史保留，不以新成功接受偏差。 |
| 各组准备（basic 当前为 T-basic-v3）/P/Q/R ↔ D/B/M、其它 Forge 相关写入/运行 | 恢复与另两组扩展共用已交付 fixture/helper/入口，P 只写两生产边界/自有键，Q 只运行核对本组，R 写真实回归/必要私有接点。共享源/测试/Gradle/TestKit/build/fixture/cache 写运行串行；P 前只需 T-basic-v3，不能重放旧 failed 身份或等其 gate 转成功；M 消费 P/Q-1165，D/B 消费 P，不用三组/Neo gate 制造共同前置。R 仅 V/H 质量门槛，冲突不等于成功依赖。 |
| ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE ↔ 相关源码/原证据/输入变动 | 只读核对需稳定且身份适用的已存材料，与相关变动串行；本项无构建/测试/CLI/下载/网络/缓存写权限，共享只读不构成其它消费者成功前置，漂移/缺证只报告受影响采用。 |
| 所有 Gradle 运行 ↔ 其它 Gradle 运行/相关输入写入 | 原三项、既有恢复、原 partial/已完成接线及新增独立重试/产物结果、VERIFY-COMBINED 历史与新 VERIFY-RECOVERY 的根/模块 build、TestKit/fixture 产物及共享缓存；先结束/取证再清理，禁止根 clean、覆盖或删除历史证据。 |
| VERIFY-RECOVERY ↔ 任何最终内容写入 | 同版输入/产物一致性；复验期间所有相关源码、fixture、build/配置稳定，模块及根运行串行。 |
| REVIEW-ACCEPTANCE ↔ 最终内容写入或不稳定运行 | 只读评估必须消费固定的最终内容与已保存证据；不同时改评估对象。 |

历史串行示例（NORMAL-RETRY 执行前，现已 failed，不再作为当前连接）：安全串行路径仅说明冲突消解，不是本Handler的选择/调度：复用原三completed、Mixin、成功接线及已采用token partial的工具/离线效果，保留全部历史，旧批次不resume。新NORMAL-RETRY先即时核对输入/旧证据/排他/daemon，再从原入口最多3次、首次实际调用起总1800秒；前轮本轮拥有进程正向退出、线程/输出收束、分存及实际网络依据/预算满足后可正常重试，无普通缓存逐项分类或包装白名单前置。产物只在新完整发现D被采用后独立证明B；remapped可在排他允许的另一串行位置独立写/跑/保存，不要求basic成功。最终复验/不同Handler验收继续消费全部完整证据，不因展示顺序增加成功依赖。

当前三组准备（basic 为 T-basic-v3）/P/Q/R/D/B/M/V 的全部共享写入和运行必须串行排他；先结束并保全本轮输出/身份再移交稳定输入，不依据展示次序增加 basic/remapped 成功依赖。新生产内容需要失效旧错误自有键，而非扩大普通缓存审计或全局清理。

**历史：P-v5原补证冲突/权限，不是P-n/P-v6新项的生产构建上限。** P-v5补证与生产两个owner/插件编译输出、全部Forge/fixture/helper/Gradle/TestKit/build/cache/输入写运行继续串行排他；当前输入与原fresh/miss/reference/hit关联在运行期间保持，历史退出/idle不充当锁。Q/R/D/B/M之间未新增成功依赖，排他不等于必须先成功。 新根薄工具纠错/复查同属这一排他和预算，不赋予任何生产写权限，不因新目录就与Q/R/D/B/M/V并跑。 两处reference语义修正和两真实样本检查也同属该完整验证的排他/预算，不产生独立公共reference产品。

**游戏rename恢复新增排他。** P-n写两owner/编译classes，P-v6新私有project/cache及实际生产加载；与Q/R/D/B/M/V和共享Gradle/TestKit/fixture/build/cache/input写运行串行。不同新根不消除共享冲突，只读原料不制造依赖。按[预算撤销边界](#预算撤销后的执行准备边界)，原单预算候选、P1/P2缺证及再次确认、双时钟起算/跨Handler可比性、交接扣时、唯一1800秒和余量停止仅保留为已撤销政策的历史，不再作为当前执行准备或继续的前置，不重求旧起点或不变范围许可，不新增替代预算。真实内容差异/缺字段、输入或实际加载身份不明、冲突或控制退出unknown仍停止；单次工具超时遵守实际工具合同。

## Waves 与可判定 gate

**本轮状态分界。** 原P-n/P-v6及更早Wave的原成员/谓词/gate行保留原合同；P-n-v源码gate已由Router采用满足，原P-v6 partial对应G-FORGE-REBUILT-CONTENT仍未释放。新增P-v6-a自己的独立completed足证据/Router采用才可能满足新gate；下方后继行只换此成功输入，本次维护不放行。

| Wave | 增量结果 | items（每项唯一归属；新行括号注明直接前置item） | 前置Wave gates | 释放谓词 |
| --- | --- | --- | --- | --- |
| W-ROOT-TEST-PROXY-RECOVERY | 旧根Test代理检查恢复 | RECOVER-ROOT-TEST-PROXY-CHECK | 无 | G-ROOT-TEST-PROXY-RECOVERY：历史 failed，保留旧 A-only、真实客户端 exit 1、配置缓存序列化拒绝及未启动后四轮；不回填、不释放。 |
| W-ROOT-TEST-PROXY-CHECK-REPAIR | 根Test代理动作缓存兼容性局部修正及同版原验证 | RECOVER-ROOT-TEST-PROXY-CHECK-REPAIR | 无 | G-ROOT-TEST-PROXY-CHECK-REPAIR：历史generation1 failed/旧gate不满足，根动作已修/真实编译成功、控制器退出与输出unknown、新版零轮次保留，不再现行等待、不回填；以下原完成合同保留：唯一独立Result completed/足证据且Router完整采用；根动作不捕获脚本/Project/Gradle等对象，复用旧准备依赖并在同版9.4.0新序列daemon、同一隔离home和原允许缓存下重新取得 A→B→删键→无键→删文件。每轮须有实际 Test、五键完整精确观察、worker/JUnit、客户端真实 exit、配置缓存 stored/restored hit/失效重配分类及同轮身份关联；失败/unknown/序列化拒绝/缺证不释放。旧 Result 不能代新结果。 |
| W-ROOT-TEST-PROXY-CHECK-VALIDATION | 历史partial：短检查成功/A底层成功但controller1，四轮零启动 | RECOVER-ROOT-TEST-PROXY-CHECK-VALIDATION | 无 | G-ROOT-TEST-PROXY-CHECK-VALIDATION：历史generation1 partial/旧gate不满足，不回填或再现行等待；以下原完成合同按当时保留：本item唯一新独立Result completed/足证据且Router完整采用；保留根源码/实际编译成功及旧failed/unknown，仅在新根完成必要有界收集入口纠正和最小非项目短检查，原五轮精确selector/五键/seed-observe顺序及缓存不变。逐轮即时排他、同一新序列daemon、实际Test/JUnit/worker、客户端和控制器真实数值exit/各自双路EOF-error-drain及来源/缓存类别同轮关联完整；用户例外仅已接受REPAIR历史控制器事件，新的unknown/失败/冲突/序列化拒绝/缺证停止，不禁清缓存/加轮次/重编译准备。旧gate不回填，本次未执行或放行。 |
| W-ROOT-TEST-PROXY-CHECK-XML-RECOVERY | CDATA限定恢复/A复用与剩余四轮完整接续 | RECOVER-ROOT-TEST-PROXY-CHECK-XML-RECOVERY | 无 | G-ROOT-TEST-PROXY-CHECK-XML-RECOVERY：历史generation1 failed/旧gate不满足，不回填、不再现行成功等待；以下原完成合同按当时保留：唯一成员独立Result completed/足证据且Router完整采用；新根InnerText一行修正/既存A XML聚焦检查及Plan规定的完整A原始关联复核成立；依用户明确接受，仅该复核替代A原成功收集的controller exit0且drained条件，不是逐字未变或追认collection-level通过。原controller1/drained/stop和VALIDATION partial不改判。仅运行B→C→E→D，各轮真实client0/controller0/双流drain、实际Test/JUnit/worker/五键/来源/缓存及与A同版同daemon实例完整关联，A业务/实际运行义务及四轮全部原检查保持，完成谓词同Plan/现行item；A未写后置材料只能有据只读恢复且不补造历史快照，缺证/漂移/同daemon关联失败/新失败或unknown停止。不得重跑A/短检查/编译准备、清禁缓存/增轮，不回填任何旧gate，不代共同验证/V/H；当前未执行、无放行。 |
| W-ROOT-TEST-PROXY-MISSING-INPUT | 缺失声明与两次D分层验收 | RECOVER-ROOT-TEST-PROXY-MISSING-INPUT | 无 | G-ROOT-TEST-PROXY-MISSING-INPUT：历史generation1 blocked/旧gate不满足；原daemon305908无记录、零源码及项目改动、两次D各零启动，不回填或现行成功等待。以下原完成合同按原时点保留：独立Result completed/足证据且Router完整采用；一行inputs.files纠正/跟踪∧旧A限定关联及B/C/E有据适用∧首次D全部原实际Test/新worker/JUnit1/0/0/0/五键全缺失/client0/controller0/两层双流drain∧第二次真实restored hit、client0/controller0及完整输出/两层双流drain∧两次缓存键稳定/首轮不覆盖保全∧跨版本同daemon关联全成立。首次全部通过/收束保全才至多第二次；首次失败/unknown/缺证不启动第二次，第二次结束即停。第二次允许Test UP-TO-DATE，不算新Test执行，不要求新worker/JUnit/执行期观察，不声称证明缓存命中后Test动作重新执行；此限定不扩其它场景。无hit/异常退出/收束缺证仍partial/实际失败而不放行，不增轮/强制重跑。旧failed/partial/unknown及XML旧gate保留，本次只维护文档。 |
| W-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON | 历史：generation1 failed；旧gate不满足；新daemon接续同一未完根恢复 | RECOVER-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON | 无 | G-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON：新独立Result completed/足证据且Router完整采用；一行inputs.files纠正/跟踪∧旧A限定关联/B/C/E跨版本及输入环境有据适用∧首次D全部原实际Test/新worker/JUnit1/0/0/0/五键全缺失/client0/controller0/两层双流drain∧第二次本轮真实restored hit/client0/controller0/完整输出/两层双流drain∧稳定缓存键/首轮不覆盖保全∧两次新D同一新daemon实际关联。首次启动前无尚未生成实例前置，首次正常启动后取得真实完整实例，第二次紧邻启动及实际输出重核同实例；旧A/B/C/E不冒称与新D同daemon。版本/JDK/home/缓存/排他及关联、新unknown停止条件不减；首次全部成功/收束保全才第二次，第二次可UP-TO-DATE且不算新Test/不索取新worker/JUnit/执行期观察，无真实hit/异常退出/收束缺证仍partial/实际失败。至多两次、第二次结束即停，不加第三次或重试。旧缺失输入blocked/零写入/两次D各零启动及全部旧成功/failed/partial/unknown/旧gate保持，不回填、不在本文释放。 |
| W-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER | 已采用completed：单次直接调用exit0／配置缓存复用；Test UP-TO-DATE | RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER | 无 | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER：既有采用已满足（execute-cache-restore-new-log generation1，证据及范围见同名item）；本次仅对账，不新释放。原释放谓词及历史限制照存：新独立completed/足证据Result被Router完整采用；沿原完整参数、JDK、cwd、隔离home及稳定输入直接Gradle调用一次，调用前仅做普通当前构建冲突检查；唯一运行验收为本轮真实Gradle exit0且日志明确出现configuration-cache restored/reused，Test允许UP-TO-DATE。不要求旧collect/run、两处断言适配、controller排空或固定daemon身份；失败/unknown/无恢复日志/输入冲突即停，停止后不重试、不换daemon、不追加第三次、不清禁缓存、不下载依赖、不做历史daemon取证或旧收集器判断。旧NEW-DAEMON及更早failed/blocked/partial、旧收据和外层controller风险保留，不回填、不释放。 |
| W-ROOT-TEST-PROXY | 根Test实际五键桥接 | WIRE-ROOT-TEST-PROXY | 无 | G-ROOT-TEST-PROXY：原历史gate保留，不由新恢复回填；旧Result不能代新根检查。 |
| W-INDEPENDENT-TESTKIT-BOOTSTRAP | 持久独立bootstrap及聚焦检查 | ADD-INDEPENDENT-TESTKIT-BOOTSTRAP | 无 | G-INDEPENDENT-TESTKIT-BOOTSTRAP：唯一独立Result completed/足证据且完整采用，六参来源链、实际编译/解析投影/错误/连续调用与异常恢复成立；不代真实独立build或未来所有入口，非completed/缺证不释放。 |
| W-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION | 历史：generation1 failed；保留源码后的未完javac／原聚焦Check | RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION | 无 | G-INDEPENDENT-TESTKIT-BOOTSTRAP-VALIDATION：历史generation1 failed／旧gate不满足，不作现行成功等待、不回填；原完整完成合同保留：唯一成员完整独立Result completed／足证据且Router完整采用，保留两源码关联本轮新classes与实际javac／-ea Check数值exit0，原六参／五键三态／错误／连续重读／异常恢复全部成立；资源拥有／串行与停止规则同item。缺证／partial／failed／blocked／unknown不释放，不回填旧ADD partial／旧gate，不代共同真实build。 |
| W-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | 已采用completed：保留源码javac／原合成Check均exit0，无真实Gradle build | RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | 无 | G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION：既有采用已满足（execute-bootstrap-argfile-validation generation1，仅原合成检查范围，证据及限制见同名item）；本次仅对账，不新释放。原释放谓词及历史限制照存：唯一成员新完整独立Result completed／足证据且Router完整采用；两源码保留、双JDK原生argfile／原309项单个-cp有序参数与原语义／新输出根关联，实际javac数值exit0后原-ea Check数值exit0且Plan原六参／五键三态／错误／连续重读／异常恢复全部成立；资源串行／停止规则同item。partial／failed／blocked／缺证／unknown不释放；不等待旧failed或下游，不回填旧ADD partial／旧恢复failed或两旧gate，不代共同真实build。原准备时点仅安排，未执行；该时点记录不否认上列既有采用，也不授权重跑。 |
| W-ISOLATED-GRADLE-PROXY | 历史复合验收预案（由细分图替代；不再派发） | VERIFY-ISOLATED-GRADLE-PROXY | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY：旧gate未满足、不回填或再等待；原完整合同保留为历史内容：同版新根恢复与bootstrap、三模式、真实独立小build、十入口归属、无残留/恢复/原隔离全部有实际证据；源码落盘/编译/skip/缺模式或unknown不释放，不代Neo。 |
| W-ISOLATED-GRADLE-PROXY-VALIDATION-RECOVERY | 历史保留：单-P纠正接续全部未完共同验收 | RECOVER-ISOLATED-GRADLE-PROXY-VALIDATION | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | 历史合同G-ISOLATED-GRADLE-PROXY-VALIDATION-RECOVERY：原单-P输入纠正及原调用／隔离合同、三模式／源变化删除无残留／embedded正常异常恢复／真实独立小build与本轮classes和来源保存／六参有序参数与错误恢复／适用十入口归属／数值Gradle exit0及当前JUnit全部必需案例成功和实际计数关联保留；Java11发现／编译／旧Check／skip／缺模式或unknown不释放；原VERIFY failed／旧gate不满足及正常缓存副作用保留，不回填、不等旧成功、不代Neo。当前A新item替换其消费者连接，本历史项未执行或放行。 |
| W-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION | 历史保留：两处Java11兼容纠正与原共同验收合同 | RECOVER-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | `G-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION`历史generation1已failed、旧gate不满足；以下原条件式释放合同完整保留：唯一成员新完整独立Result completed/足证据且Router完整采用；仅Plan两处兼容纠正及载荷/指纹等价、已完成完整单-P/原调用/隔离保持，原三模式、真实来源变化/删键/删文件/未配置无残留、embedded正常异常恢复、本轮新classes真实独立小build与来源先保存、六参有序classpath及原arguments/错误恢复、适用十入口、真实Gradle数值exit0、当前JUnit全部必需案例成功及计数身份关联均成立。编译/内部等价性检查/旧Check/skip/缺模式/unknown不释放；原VERIFY与单-P恢复两次旧共同failed、最新本项failed、旧gate不满足及单-P已完效果保留，不回填或等旧成功、不代Neo或V/H；不作当前A恢复成功等待。 |
| W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION | A配置阶段固定输出路径并接续全部原共同验收 | RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION：旧gate未满足、不回填或再等待；以下原完整完成条件保留为历史合同：仅A接点及原完整共同传播/恢复/隔离合同闭合，缺失probeOutput配置阶段失败和配置后路径变化不生效为已接受差异，五键仍任务action读取；三模式/断言/home/cache/单-P/JDK/selector/cwd/source-home/offline/串行/十入口/独立小build/真实JUnit与数值exit0/XML计数关联全部成立。Java11修复、完整单-P及旧共同failed/越界/unknown保留，不回填或等待；缺证/failed/partial/blocked/unknown不释放。 | |
| W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY | 历史：读取失败后的A接续；generation1实际Java exit1、Gradle未启动 | RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | 历史G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-VALIDATION-READ-RECOVERY不满足；原完整A合同、旧item/Wave/gate及失败边界保留，不回填、不作现行成功等待。 | |
| W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION | A源码已完成后的两个CLI路径片段恢复与全部原共同验收 | RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION：旧gate未满足、不回填或再等待；以下原完整完成条件保留为历史合同：仅恢复当前argv的两个目录片段并完成原A全部共同传播/恢复/隔离合同，缺证/failed/partial/blocked/unknown不释放；旧READ-RECOVERY item/Wave/gate保留failed且不回填。 | |
| W-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION | 唯一授权复用/输入及新根准备；不运行项目验证 | PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY (前置item: RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER, RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION) | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION：一个准备Handler/Result completed且Router采用；只重用既有授权与成功前置，读取给定JSON/init、恢复两处限定路径、创建新证据根/init目标；不证明任一项目验收，不放行最终gate。 |
| W-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION | 原十个静态归属及新增代理探针归属（当前至少第十一个入口） | VERIFY-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION (前置item: PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY) | G-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION | G-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION：已有generation1 completed静态Result只支持原十个真实nested入口归根Test共同配置，含ordinary与pipeline fresh-home binding两路，并发现`IsolatedGradleProxyTests.java`是额外真实GradleRunner入口；总数至少11，不宣称全量恰为十或清单穷尽。pluginClasspath-only不算入口；静态归属不代动态传播。 |
| W-ISOLATED-GRADLE-PROXY-THREE-MODES | 现有固定三模式JUnit仅运行一次的有限结果 | VERIFY-ISOLATED-GRADLE-PROXY-THREE-MODES (前置item: PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY) | G-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION | G-ISOLATED-GRADLE-PROXY-THREE-MODES仅表示现有测试及实际覆盖通过：消费已准备JSON/init，固定`:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.IsolatedGradleProxyTests`只调用一次；唯一`@Test`实际执行、当前全部断言成功，真实Java/Gradle客户端数值exit0且本轮XML的tests/failures/errors/skipped=`1/0/0/0`，正常保存本轮命令/日志/XML和实际模式结果并关联当前classes/worker/output。`daemon-default`、`daemon-private`、`embedded`及现有worker-baseline/A/B-empty/removed-keys/unconfigured、nested一致性/home、正常恢复、embedded预期失败/finally恢复/随后未配置检查均在方法内，不拆Result或另起启动；预期内部失败按原断言判定。UP-TO-DATE/FROM-CACHE/SKIPPED或旧XML不能冒充本轮实际执行，若未执行只报告未取得本轮结果，不加参数强跑或补跑。缺真实退出/新资源冲突/真实失败停止并保全已达模式和具体原因，不将先通过模式拆为completed。运行前只做当前相关冲突及不覆盖检查，必要时仅重定位现有输出/init引用，原selector/source/JDK/完整单-P/offline/cache不变；不改源码、不补测试、不新增探针/控制器/矩阵或独立build。缺少合成根来源、逐键三态/HTTPS显式空值/Properties转义等是完整验收的独立缺口，不阻止如实完成本有限结果，也不由它满足G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE。一个Handler/Result，item/Wave尚未执行或放行，共享写运行串行。 |
| W-ISOLATED-GRADLE-PROXY-DEFAULT-DAEMON | 历史单项已退役：原合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-DEFAULT-DAEMON (历史，generation1 failed；不再派发) | G-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION | 历史G-ISOLATED-GRADLE-PROXY-DEFAULT-DAEMON保持failed/不满足：generation1因固定selector必然执行整类而停在启动前，构建启动0次、无项目写入、无JUnit/XML、无传播证据；不得回填。原默认TestKit home/daemon、五键三态/Properties值/实际home合同完整并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES，旧gate不由新Result释放。 |
| W-ISOLATED-GRADLE-PROXY-PRIVATE-TESTKIT-DIR | 历史单项已退役：原合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-PRIVATE-TESTKIT-DIR (历史，未独立执行) | G-ISOLATED-GRADLE-PROXY-DEFAULT-DAEMON | 历史G-ISOLATED-GRADLE-PROXY-PRIVATE-TESTKIT-DIR未满足且无独立Result；原显式withTestKitDir/private `-g`路径、来源与目的home区分、五键一致性及offline/cache/output/tmp/fresh-reuse、不复制用户配置/缓存合同全部并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES。旧gate不由新Result释放。 |
| W-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER | 显式五键冲突来源与实际优先关系 | VERIFY-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER (前置item: VERIFY-ISOLATED-GRADLE-PROXY-THREE-MODES) | G-ISOLATED-GRADLE-PROXY-THREE-MODES | G-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER：真实触发五键显式覆盖冲突，独立脱敏Result逐键记录来源与实际顺序；不创设政策，不新增-D/init全来源发现。共享运行串行。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE | 真实来源A变B后重算 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE (前置item: VERIFY-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER) | G-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER | G-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE：同一明确真实来源变更后新投影反映B而非daemon/环境/缓存旧值，worker/nested身份和脱敏状态可关联；唯一独立Result。共享运行串行。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL | 来源键逐项删除后的未配置与无残留 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE) | G-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE | G-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL：逐项删除五键后下次调用不复用被删键旧值，其余当前配置照常投影，空值与缺键区分；真实home/逐键脱敏状态可关联，运行串行。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL | 删除已存在来源文件后的未配置与无残留 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL) | G-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL | G-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL：在来源文件先含配置后删除文件，随后的真实调用为未配置且五键不残留；来源身份仍明确，与身份缺失/现存文件读取错误分开，运行串行。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED | 来源身份缺失时的失败关闭 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL) | G-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL | G-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED：来源身份无法取得时受影响启动关闭并保留真实失败，不伪装未配置；与明确身份但无文件的合法未配置状态分开。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED | 明确来源下现存文件读取失败关闭 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED) | G-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED | G-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED：来源身份明确且配置文件存在但实际读取失败时关闭并保留读取错误，不能借合法缺文件替代。 |
| W-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED | 明确来源读取后Properties解析失败关闭 | VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED) | G-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED | G-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED：标准Properties解析失败真实关闭且保留原解析错误，与身份缺失/缺文件/读取错误/无键分开。 |
| W-ISOLATED-GRADLE-PROXY-EMBEDDED-SUCCESS-RESTORE | 历史单项已退役：原合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-EMBEDDED-SUCCESS-RESTORE (历史，未独立执行) | G-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED | 历史G-ISOLATED-GRADLE-PROXY-EMBEDDED-SUCCESS-RESTORE未满足且无独立Result；原withDebug(true)正常返回后父JVM属性逐键恢复合同完整并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES，不单独释放旧gate。 |
| W-ISOLATED-GRADLE-PROXY-EMBEDDED-EXCEPTION-RESTORE | 历史单项已退役：原合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-EMBEDDED-EXCEPTION-RESTORE (历史，未独立执行) | G-ISOLATED-GRADLE-PROXY-EMBEDDED-SUCCESS-RESTORE | 历史G-ISOLATED-GRADLE-PROXY-EMBEDDED-EXCEPTION-RESTORE未满足且无独立Result；预期异常传播、finally逐键恢复及异常身份保全合同完整并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES，不单独释放旧gate。 |
| W-ISOLATED-GRADLE-PROXY-EMBEDDED-POST-FAILURE-UNCONFIGURED | 历史单项已退役：原合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-EMBEDDED-POST-FAILURE-UNCONFIGURED (历史，未独立执行) | G-ISOLATED-GRADLE-PROXY-EMBEDDED-EXCEPTION-RESTORE | 历史G-ISOLATED-GRADLE-PROXY-EMBEDDED-POST-FAILURE-UNCONFIGURED未满足且无独立Result；embedded异常恢复后同worker随后未配置调用逐键无残留合同完整并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES，不单独释放旧gate。 |
| W-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD | 实际独立私有home小build成功边界 | VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD (前置item: VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED, RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION) | G-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD：使用当轮bootstrap javac输出执行真实无游戏私有-home build；来源先保存；六参/原309项有序classpath与单-cp实参/arguments-file语义、五键/home和同轮真实成功输出关联均满足。共享运行串行。 |
| W-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR | 独立build参数错误传播与环境恢复 | VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR (前置item: VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD) | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR：原参数错误真实传播，调用环境/五键/来源恢复，无残留；六参/原309项有序单-cp/arguments-file语义及错误退出关联保留。 |
| W-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR | 独立build样本oracle错误传播与环境恢复 | VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR (前置item: VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR) | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR：样本身份/oracle错误独立真实传播，调用环境/五键/来源恢复且无残留；同一六参/classpath/arguments-file合同和错误关联完整。 |
| W-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY | 独立build预期构建异常传播与环境恢复 | VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY (前置item: VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR) | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY：预期构建异常独立传播并恢复调用环境/五键/来源，无残留；与参数/oracle错误Result分开，真实异常/退出关联齐全。共享运行串行。 |
| W-ISOLATED-GRADLE-PROXY-COMPLETE-JUNIT | 历史独立项已退役：完整JUnit合同由THREE-MODES承载 | VERIFY-ISOLATED-GRADLE-PROXY-COMPLETE-JUNIT (历史，未独立执行) | G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY、G-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION | 历史G-ISOLATED-GRADLE-PROXY-COMPLETE-JUNIT未满足且无独立Result；固定selector唯一测试、全执行/无skip、真实Gradle exit0、XML计数及JSON/源码/classes/worker/输出/退出收束关联合同完整并入新G-ISOLATED-GRADLE-PROXY-THREE-MODES，不单独释放旧gate。 |
| W-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION | 只读隔离、脱敏与凭据排除最终审计 | VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION (前置item: PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY, VERIFY-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION, VERIFY-ISOLATED-GRADLE-PROXY-THREE-MODES, VERIFY-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED, VERIFY-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED, VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD, VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR, VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR, VERIFY-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY) | G-ISOLATED-GRADLE-PROXY-EAGER-PREPARATION、G-ISOLATED-GRADLE-PROXY-ENTRY-ATTRIBUTION、G-ISOLATED-GRADLE-PROXY-THREE-MODES、G-ISOLATED-GRADLE-PROXY-OVERRIDE-ORDER、G-ISOLATED-GRADLE-PROXY-SOURCE-CHANGE、G-ISOLATED-GRADLE-PROXY-SOURCE-KEY-REMOVAL、G-ISOLATED-GRADLE-PROXY-SOURCE-FILE-REMOVAL、G-ISOLATED-GRADLE-PROXY-SOURCE-IDENTITY-FAIL-CLOSED、G-ISOLATED-GRADLE-PROXY-SOURCE-READ-FAIL-CLOSED、G-ISOLATED-GRADLE-PROXY-SOURCE-PARSE-FAIL-CLOSED、G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD、G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-PARAMETER-ERROR、G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-ORACLE-ERROR、G-ISOLATED-GRADLE-PROXY-INDEPENDENT-BUILD-EXCEPTION-RECOVERY | G-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION: independently read-only audit proves no user-config writes/full-config or cache copy, no proxy auth/repository/synthetic credentials, no JAVA_TOOL_OPTIONS/environment/System.getProperties propagation; offline/cache/home/output/tmp/fresh-reuse boundaries and redacted evidence preserved. No routing proof claimed. 本只读审计不补做来源/映射/独立build测试，不因有限JUnit成功把未覆盖的完整合同记为通过；原完整G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE须独立满足页首保留的完整证据缺口。 |
| W-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY | 历史复合执行图（由细分图替代；不再派发） | RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION | G-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY：旧gate保持未满足且已退役、不回填或再等待；以下原单一复合合同只留历史完整记录：两处限定片段/全新输出及init证据目标、原A全部共同验收与真实退出/XML计数身份关联全部满足，仅JSON读取/路径恢复/编译/旧Check/局部输出/skip/缺证/partial/failed/blocked/unknown不释放。旧CLI-PATH-RESTORATION generation1为非必需额外读取failed，原完整item/Wave释放合同永久保留、不回填或等待转成功；其它旧失败/混合归属/历史未知不改。 |
| W-FORGE-PATCH-FIXTURE-NEO-CPW-MODS | 一处模板过滤纠正及原Neo测试一次的同一修复结果 | RECOVER-FORGE-PATCH-NEO-CPW-MODS | G-REPAIRS、G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（均已满足，复用） | G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS：唯一新Result completed/足证据并完整采用；仅追加cpw.mods、未来至多一次/累计至多五次，原精确selector实际执行/Gradle0/JUnit1/0/0/0及原T-Neo全部准备同轮成立，当前共享排他/必要输入JDK/隔离/新输出保全有证。只免本次完整代理前置，不代完整gate或自动放行Q/R/V/H；失败/unknown/缺证停止不重试，旧四次failed/gate不回填。 |
| W-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY | 历史failed：本轮一次/累计第四次、exit1、JUnit1/1/0/0；旧gate不满足，以下保留原合同 | RECOVER-FORGE-PATCH-NEO-AFTER-PROXY | G-REPAIRS、G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION（后两项已满足，复用） | G-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY：唯一同名 generation1 Result completed/足证据且完整采用，未来至多一次/累计至多四次、真实退出/当前共享排他/新输出保全及原 T-Neo 全部准备和同轮精确 selector 1/0/0/0 成立；本次不等待完整代理 gate 或其准备/最终审计，不替代该 gate 或放行 V/H。失败/未知停止不重试，执行一次不算成功；缺证/failed/partial/blocked/unknown 不释放，不回填三次旧 failed/gate。 |
| W-REPAIRS | 三项独立合同恢复/覆盖结果 | FIX-RESOLUTION, FIX-DISCOVERY, TEST-FABRIC-UTF8 | 无 | G-REPAIRS：三个可靠关联且被采用的完整 Result 均 completed，逐项消费 [Plan 局部清单](plan.md#局部验证-selector-与断言承载) 的对应行、涉及整类和实际新增/迁移方法及参数；三谓词的必需反例/有效旧断言（含跨 Jar 全匹配/完整路径、Fabric side/producer）证据齐全，范围内阻断解决且排他写入后可组合。缺失、partial、失败、blocked 或必需案例 skip/未覆盖不释放。输出预约/竞争专属证据不属本 gate，也不表示风险已解决。 |
| W-INTEGRATION | 同版共同成立的运行证据 | VERIFY-COMBINED | G-REPAIRS | G-INTEGRATION：其 Result completed 且被采用，[Plan 完整模块清单](plan.md#同版最终组合的实际模块清单) 和局部/新增案例均有最终同版实际结果；Mixins、Fabric、Forge 完整模块必需 fresh（Forge 三类及当前新增案例全部实际执行）与根入口证据齐全，证据与最终内容一致。任何必需类/案例失败、缺跑或 skip、陈旧缓存均不满足；说明原因不能豁免覆盖，不以历史数量或根入口缓存替代。 |
| W-RECOVERY | 原 Mixin、basic、remapped 三项恢复，保留原 basic blocked 与 gate 不满足 | RECOVER-FIXTURE-RULE、RECOVER-BASIC-PATCHED、RECOVER-REMAPPED-PATCHED | G-REPAIRS | G-RECOVERY：原三个独立 Result 均 completed、完整采用并分别满足 Plan 与本图原谓词；Mixin 合同、basic 固定来源/patched/原 Java8 consumer、remapped 固定来源/mappings/显式 namespace/RemapTask/原 Java8 consumer 各自闭合。任何缺失、partial/failed/blocked 或仅脚本 compile 不满足，不以另一工程成功抵消。本 gate 目前不满足，现行复验无此 gate 前置；保留合同不自动用新 Result 释放。 |
| W-BASIC-RECOVERY | 旧 blocked 后两个独立 basic 终态 | RECOVER-BASIC-JAVA8、RECOVER-BASIC-ARTIFACTS | G-REPAIRS | G-BASIC-RECOVERY：两份新的完整 Result 均 completed 且被采用，分别满足标准属性两边界与实际 Java8 compiler 解析、当前固定版本 basic 全部来源/namespace/provider/patched/原 Java8 consumer/compileJava/jar/printCompileClasspath 的完整合同。任一缺失、partial/failed/blocked、仅候选存在/脚本 compile 或旧输出不满足；旧 blocked/三失败/最终脚本未运行历史保留。不要求旧 basic 或 G-RECOVERY 转成功，仅放行显式新后继。 |
| W-BASIC-JAVA8-RETRY | 原 partial 后仅未完成运行发现的独立验证 | RECOVER-BASIC-JAVA8-RETRY | G-REPAIRS | G-BASIC-JAVA8-RETRY：本重试完整 Result completed、足证据且被完整采用，当前保留接线与原成功效果可关联，本次一次原方法的 Provider/Test/args/nested 属性/StartParameter/effective installations/现有 action 实际 Java8 compiler 两行及共享语义全部闭合；旧14条观察不能补本轮缺证。partial/failed/blocked、超时早失败或任一缺证不释放；只作用于显式新后继，不满足原 partial 或任何旧 gate。 |
| W-BASIC-JAVA8-BOUNDED-RETRY | 两次partial后未完发现的有限同轮取证 | RECOVER-BASIC-JAVA8-BOUNDED-RETRY | G-REPAIRS | G-BASIC-JAVA8-BOUNDED-RETRY：新完整Result completed、足证据且完整采用；最多3次/本批次首次实际调用起总30分钟内某一次原调用完整满足本项同轮发现/现有action实际compiler两行/共享语义。逐次证据与失败/时间/退出码保全，外层Provider观测限制明示，禁止跨轮补证。partial/failed/blocked、缺证或超限不释放；只供显式新后继，不回填旧两次partial/item/gate，也不代替完整产物。 |
| W-BASIC-JAVA8-RECOVERY | 本地观测失效后保留原合同的独立发现 | RECOVER-BASIC-JAVA8-RECOVERY | G-REPAIRS | G-BASIC-JAVA8-RECOVERY：本新Result完整采用、completed且足证据；必要本地控制链纠正/针对性离线检查有证据，当前排他与输入/旧证据稳定，独立新批次最多3次/首次调用起总30分钟内某一次原调用完整闭合同轮Provider/Test/args/nested/System/StartParameter/effective installations/现有action实际Java8 compiler两行及共享语义。每次退出正向确认/分存/影响可判及严格网络再试条件成立，失败/计数unknown/时间采样/Provider与真实停止链限制完整保留；仅离线通过、缺证、partial/failed/blocked或超限不释放。只供显式新后继，不回填旧failed/partial/gate，不代替完整B。 |
| W-BASIC-JAVA8-TOKEN-RECOVERY | 真实token与身份交接纠正后保留原合同的独立发现 | RECOVER-BASIC-JAVA8-TOKEN-RECOVERY | G-REPAIRS | G-BASIC-JAVA8-TOKEN-RECOVERY：本新Result完整采用/completed/足证据；新目录必要token/身份交接纠正与真实原快照直接送实际纯候选的针对性离线回归可追踪，原始argv保留、快照到认领四字段一致及attach前监听仍同归属，未知/变化一律拒绝。当前排他/输入/旧证据稳定，独立新批次最多3次、首次调用起一个30分钟deadline，内部实施顺序及[逐轮副作用/清理/再试合取](context.md#逐轮副作用与网络再试判据)有同版实际函数离线证据、真实每轮分类/分存/全部正向退出与清理记录被retry实际消费，未知拒绝；每次执行/保全余量与纯临时网络再试严格成立；某一次同轮Provider/Test/唯一-D/nested System/StartParameter两map/effective installations/现有action实际compiler executable及metadata8/共享语义全闭合。旧failed/partial/unknown计数、不同hash离线/诊断模型/真实完整停止链限制完整保留；工具/离线通过不等于发现，partial/failed/blocked/缺证/超限不释放。只供显式新后继，不回填旧RECOVERY或其它item/gate，不代替B/remapped/最终验收。 |
| W-BASIC-JAVA8-NORMAL-RETRY | 最新token partial后复用工具的正常网络发现 | RECOVER-BASIC-JAVA8-NORMAL-RETRY | G-REPAIRS | G-BASIC-JAVA8-NORMAL-RETRY：完整独立Result completed、足证据并被完整采用；保留接线当前对应与某一次新原basic invocation的全部同轮Provider/Test/唯一-D/nested System/StartParameter两map/effective installations/现有action实际Java8 compiler executable及metadata8/共享语义闭合，Provider直接观察限制明示，不跨轮补证。新批次最多3次/首次调用起单一1800秒，正常网络再试、分轮保全/正向退出/基本身份与排他安全成立；普通缓存逐项归属/sideEffectsSafe新认证、包装白名单、网络早败时缺compiler不成为再试前置，但缺完整compiler等成功证据仍不释放gate。partial/failed/blocked、缺证或超限不满足，只供显式新后继，不回填旧token或其它item/Wave/gate，不代替B/M/最终验收。 |
| W-FORGE-PATCH-FIXTURE-BASIC | basic 真实入口准备 | PREPARE-FORGE-PATCH-BASIC | G-REPAIRS | G-FORGE-PATCH-FIXTURE-BASIC：本组完整 Result completed/足证据且采用，本组真实 provider/参考/见证/JVM/隔离及精确方法实际执行可关联。只判本组，不等另两组/完整类；配置/编译/mock/缺输入/实际运行/JDK 或泄漏不释放。 |
| W-FORGE-PATCH-FIXTURE-BASIC-RECOVERY | basic 未完准备的独立恢复 | RECOVER-FORGE-PATCH-BASIC-PREPARATION | G-REPAIRS | G-FORGE-PATCH-FIXTURE-BASIC-RECOVERY：新独立 Result completed/足证据且采用；复用工程/LZMA修正，阶段空集/适用性损失及 collision 合集有证，现存 basic selector 本轮1 test/0 failure/0 errors/0 skipped、完整同轮身份/XML/class及resource witness/prepared文件齐全，无 P 内容/cache 前置，不回填旧 failed/gate。 |
| W-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RETRY | basic仅未完完整验证的独立有限重试 | RECOVER-FORGE-PATCH-BASIC-VALIDATION-RETRY | G-REPAIRS | G-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RETRY：本新独立Result completed/足证据且完整采用；复用两文件修改/LZMA，不重做实现，最多3次/首次实际调用起单一1800秒（含取证/间隔/收束），逐轮新根/分存、正向退出/当前排他/实际余量/仅临时网络继续与非网络停止成立。某一轮现存basic selector完整1/0/0/0，真实prepare/reference全部CLI/输入/工具/JVM/阶段/任务/最终output/prepared/class/resource witness/inventory及适用性/损失全关联，无P namespace/cache前置，不拼轮；partial/failed/blocked/缺证/超限不满足。原T-basic和T-basic-r各failed/完整合同/旧gate不满足保留，不自动回填。 |
| W-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RECOVERY | 启动控制失败后未完完整验证的新独立批次 | RECOVER-FORGE-PATCH-BASIC-VALIDATION-RECOVERY | G-REPAIRS | G-FORGE-PATCH-FIXTURE-BASIC-VALIDATION-RECOVERY：本新独立Result completed/足证据且完整采用；即时排他/全新根真实隔离/已物化输入与实现复用安全、完整可观测短启动/有界等待/实际工具timeout能力已实际验证，具体未知冲突或无安全路径即停；复用两文件修改/LZMA，不重做实现，最多3次/首次实际调用起单一1800秒（含取证/间隔/收束），逐轮新根/分存、正向退出/当前排他/实际余量/仅临时网络继续与非网络停止成立。某一轮现存basic selector完整1/0/0/0，真实prepare/reference全部CLI/输入/工具/JVM/阶段/任务/最终output/prepared/class/resource witness/inventory/identity/patch及适用性/损失全关联，无P namespace/cache前置，不拼轮；partial/failed/blocked/缺证/超限不满足。原T-basic/T-basic-r/T-basic-v各failed及T-basic-v历史实际调用/启动/退出unknown/完整合同/旧gate不满足保留，不自动回填或因新成功消除历史unknown；控制/解析/回执或身份退出unknown停止。 |
| W-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | 同terminal前台生命周期下未完完整验证的新独立批次 | RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION | G-REPAIRS | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION：本独立Result completed/足证据且完整采用；实际即时排他/真实隔离/实现和输入安全复用、同一bash terminal前台同步原gradlew/argv及完整控制有证据，无Start-Process＋WaitForExit false先退出分叉；正常返回取得真实关联退出，硬中断不伪造Gradle码/不保证正常退出码，未知即停。真实timeout按首次实际调用起单一1800秒剩余扣出至少60秒收束及合理保存余量，最多3次/分轮新根分存，只有临时网络且前次正向退出/排他/实际余量满足才再试。某轮现存完整selector1/0/0/0及全部同轮真实prepare/provider最终output、reference全部CLI/inputs/tools/JVM/argv/退出/阶段/任务图/XML/日志/prepared/class-resource witnesses/inventory/patch/身份齐全，未运行不记不适用、不拼轮/skip、不等P namespace/cache。固定basic真空集/覆盖损失和1165/Neo实有合同不变；四旧failed/全部原合同及旧gate不满足、全部历史unknown保留，新成功不回填。partial/failed/blocked/缺证/控制身份退出unknown/超限不释放。 |
| W-FORGE-PATCH-FIXTURE-1165 | Forge1165 真实入口准备 | PREPARE-FORGE-PATCH-1165 | G-REPAIRS | G-FORGE-PATCH-FIXTURE-1165：本组完整 Result completed/足证据且采用，固定 userdev/MCP/真实 provider/独立参考/见证/JVM/隔离和精确方法运行可关联，不等 Neo/basic/完整类；缺输入/JDK/实际运行或 partial/failed/blocked 不释放。 |
| W-FORGE-PATCH-FIXTURE-NEO | Neo 私有样本真实入口准备 | PREPARE-FORGE-PATCH-NEO | G-REPAIRS | G-FORGE-PATCH-FIXTURE-NEO：本组完整 Result completed/足证据且采用，固定输入/实际 Java21/真实 provider/独立参考/见证/隔离和精确方法运行齐全；缺21/运行/见证不释放，不由另外两组代证或取消它们。 |
| W-FORGE-PATCH-FIXTURE-NEO-RECOVERY | 未完完整T-Neo独立恢复 | RECOVER-FORGE-PATCH-NEO-PREPARATION | G-REPAIRS | G-FORGE-PATCH-FIXTURE-NEO-RECOVERY：新独立Result completed/足证据且完整采用，原T-Neo全部固定输入/实际Java21/provider/独立参考/见证/隔离/最终output及精确selector1/0/0/0成立；仅名称修正/编译不满足。缺证/partial/failed/blocked/unknown不释放，旧failed及旧gate不满足保留且不回填。 |
| W-FORGE-PATCH-FIXTURE-NEO-VALIDATION | 仅未完T-Neo一次运行 | RECOVER-FORGE-PATCH-NEO-VALIDATION | G-REPAIRS | G-FORGE-PATCH-FIXTURE-NEO-VALIDATION：唯一新Result completed/足证据且完整采用，原T-Neo全部准备及同轮精确selector1/0/0/0成立；一次调用/真实累计限制、启动身份排他与退出保全满足。仅名称纠正/stage2或网络早败不满足；partial/failed/blocked/unknown/缺证不释放，两旧failed和旧gate不满足不回填。 |
| W-FORGE-PATCH-NAMESPACE | 共同生产修正及 basic 完整可消费 P | FIX-FORGE-PATCH-NAMESPACE | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-NAMESPACE：P 完整 Result completed/足证据且采用；共同更正及 basic 全部最终 namespace/接口/引用/优先级/资源/适用 AT、forge 实际完整路径隔离及本组 miss→真实 rebuild→同输入同版 hit 成立。两族版本使用静态检查不代 Neo 实际路径/运行，不等其它 T/Q/三组缓存全齐；仅编译/diff/版本/能打开/partial 不释放，也不称全分支已验证。 |
| W-FORGE-PATCH-OVERLAY-CONTENT | 原完整P可消费结果的独立恢复 | RECOVER-FORGE-PATCH-OVERLAY-CONTENT | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-CONTENT：唯一新恢复成员completed/足证据且完整采用，满足该item全部谓词/证据/停止边界，原P完整内容/cache结果闭合；版本8隔离、继承成员/独立class-resource-AT oracle及同有效path miss→真实rebuild→hit必须齐全，旧P partial/旧gate不满足不回填。 |
| W-FORGE-PATCH-OVERLAY-VALIDATION | 仅完整独立oracle与同路径hit未完验证恢复 | RECOVER-FORGE-PATCH-OVERLAY-VALIDATION | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-VALIDATION：唯一成员独立Result completed/足证据且采用，当前实现/输入/原fresh-miss身份及排他闭合、新根原始完整parents/目录核对、全新独立完整class-body-继承-AT-资源-优先级oracle、同输入同语义同完整有效path真实hit及再次完整oracle全部满足；单1800秒含首离线调用/postprocess/保存、真实前台退出/最多3次网络/非网络停止均合法。缺证/partial/failed/blocked/越时不释放；不回填原P及P-recovery两个partial/旧gate。 |
| W-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY | P-v2：仅完整独立oracle与同路径hit未完验证恢复 | RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY：唯一成员独立Result completed/足证据且采用，当前实现/输入/原fresh-miss身份及排他闭合、新根原始完整parents/目录核对、全新独立完整class-body-继承-AT-资源-优先级oracle、同输入同语义同完整有效path真实hit及再次完整oracle全部满足；单1800秒含首离线调用/postprocess/保存、真实前台退出/最多3次网络/非网络停止均合法。缺证/partial/failed/blocked/越时不释放；不回填原P及P-recovery两个partial/旧gate。 |
| W-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE | P-v3：仅完整独立oracle与同路径hit未完验证恢复 | RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE：唯一成员独立Result completed/足证据且采用，当前实现/输入/原fresh-miss身份及排他闭合、新根原始完整parents/目录核对、全新独立完整class-body-继承-AT-资源-优先级oracle、同输入同语义同完整有效path真实hit及再次完整oracle全部满足；共享最小预检及实际函数原前缀正例/后发busy与尾窗unknown负例通过；单1800秒含首相关检查（静态分析/LSP在内）/离线/CLI/hit/postprocess/保存、真实前台退出/最多3次网络/非网络停止均合法。缺证/partial/failed/blocked/越时不释放；不回填原P及P-recovery两个partial/旧gate。 |
| W-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY | P-v4：同预算工具纠错边界下的未完完整验证恢复 | RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY：唯一成员独立完整Result completed/足证据且完整采用，原完整实现/实际加载/输入/原fresh-miss/排他身份、新根Object+bk完整父集与目录正负例、共享完整日志预检与同实际函数真实录制正负例、新独立reference完整class/body/继承/AT/游戏/优先级/资源oracle、7/8/9完整路径隔离、同有效path真实hit及再次完整oracle全部成立。仅可证新根薄工具自身编写/静态类型错误允许同一预算内最小纠正/同版复查，实际错误/分类/改动/复查证据完整保留，不默认字段/忽略诊断/删断言或改输入及预期。方法事前加载，首相关检查前UTC/monotonic同步起点，一个1800秒覆盖全部静态/LSP/离线/纠错复查/CLI/hit/postprocess/保存，至少60秒收束并另留保存余量；前台真实退出/最多3次有限网络合法。真实缺字段/内容不符、身份/退出unknown、冲突/到限即停；缺证/partial/failed/blocked/越时不释放。P-v3及更早failed/两partial/旧完整合同与旧gate不满足不回填。 |
| W-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY | P-v5：仅独立reference语义恢复后的未完完整验证 | RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY：唯一成员独立完整Result completed/足证据且完整采用，本item全部谓词成立：游戏patched/member-owner原声明闭包与稀疏payload分离、原有效内嵌mapping/target唯一inverse/reader、两真实失败锚点及负例只是内部检查；原完整实现/实际加载/输入/原fresh-miss/排他、预检真实录制/Object+bk/目录正负例、全部4782 class/body/继承/AT/游戏/优先级/资源、7/8/9完整路径隔离、同path真实task-action hit及再次完整oracle均有证。两语义修正事先明确、不归旧窄例外；仅可证新根工具自身编写/类型错误同预算最小纠正/同版复查，错误/分类/改动/时间/退出保留；不改raw/随意预期/删比较。方法事前加载、首相关检查前双时钟单1800秒至最终保存、至少60秒收束并另留保存余量、有限网络/真实退出/unknown及到限停止合法。缺证/partial/failed/blocked/越时不释放，不回填P-v4及更早failed/两partial/全部旧合同/gate。 |
| W-FORGE-GAME-RENAME-INHERITANCE | 共享生产rename/cache修正 P-n | FIX-FORGE-GAME-RENAME-INHERITANCE | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-GAME-RENAME-INHERITANCE：唯一成员完整Result completed/足证据且采用，notch-only两owner接线、原域声明/稳定优先级与payload分离、version10专属operation/固定声明语义域与实际输入覆盖方案、Core逐文件Murmur3-32→源码比较器排序去重→聚合/完整path推导（不含basename/order/角色；有序身份另记，旧新aggregate可同）、编译及四行真实固定工具正负例/源码参数对应成立，输入/工具/控制退出可判。仅编译/--live flag不够，不证明新生产加载/全量P，不直接放行Q/R/D/B/M/V/H。按[预算撤销边界](#预算撤销后的执行准备边界)，统一分钟截止、双时钟/UTC配对/跨Handler可比性、交接扣时/发布末值、全链上界、60秒及保存余量证明不再是本gate前置，不重求原范围或旧起点许可，不新增替代预算。全链最多3次正常网络、完整日志/分存/真实退出/身份/冲突及真实内容差异停止保留；P1/P2仅保留未技术闭合历史。不代替完整P gate；缺证/partial/failed/blocked/unknown不释放，本次无放行。 |
| W-FORGE-GAME-RENAME-INHERITANCE-VALIDATION | 保留源码的未完验证 P-n-v | RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION | G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION | G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION：唯一成员独立完整Result completed/足证据并完整采用，原P-n完整源码标准全部成立：两owner/source identity、notch范围、声明优先级/payload分离、version10实际输入覆盖/Core内容hash排序去重聚合/完整path推导、相关Kotlin真实编译成功、固定SpecialSource四引用正例/缺U真实负例及源码参数对应/命中来源/退出/摘要。仅身份未变且适用的已完证据可关联，原partial无编译/CLI成功不能代证。每次启动前即时排他、正常网络全链0/3消费继承、真实停止与失败保全不减，无统一分钟或替代预算。不直接放行完整P，P-v6仍须全部自身证据；缺证/partial/failed/blocked/unknown不释放，不回填原P-n及旧gate，本次无放行。 |
| W-FORGE-REBUILT-CONTENT | 新产物完整P消费证据 P-v6 | VERIFY-FORGE-REBUILT-CONTENT | G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION | G-FORGE-REBUILT-CONTENT：唯一成员完整Result completed/足证据且采用，本item全部加载/输入/JVM/排他身份、Plan缓存证据对象（实际root/operation/完整输入bytes与逐文件hash/源码排序去重与aggregate/output basename/path，有序声明身份另证且不冒充Core自动编码）、7/8/9与10的operation路径隔离、10目标输出path先不存在或真实miss→真实task-action rebuild/fresh→全部4782等完整oracle→同root/operation/输入身份及顺序语义/key/basename/path真实task-action hit→再次完整oracle、新fresh/cache/两次final的字节身份关联、四行raw独立预期/新rename/实际normalized overlay声明闭合成立。reference复用身份适用，旧失败/空集损失/unknown保留；按[预算撤销边界](#预算撤销后的执行准备边界)，P1/P2缺证、原始起点/跨Handler双时钟可比性/UTC配对、交接扣时/发布末值、全链上界、统一1800秒、60秒及独立保存余量证明均不再约束准备/Result采用/本gate，不设替代分钟上限或重求原范围许可。全链最多3次正常网络（含hit）、完整日志/失败分存、正向退出/输出收束、输入及实际加载身份、排他和真实差异停止仍须成立，控制退出unknown仍停止；单次工具超时按其实际合同。旧9/fresh/CLI聚焦不代证；缺证/partial/failed/blocked/unknown不释放，不回填旧item/gate，本次无放行。 |
| W-FORGE-REBUILT-CONTENT-EVIDENCE | 本次例外下既有完整P技术证据可采用 P-v6-a | ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE | G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION | G-FORGE-REBUILT-CONTENT-EVIDENCE：唯一成员独立Result completed/足证据且Router实际采用；原P-v6全部未降低技术证据与身份适用性、此次精确例外/原账本5标online与4实际Gradle/2重分类及旧3区分、partial/旧gate/失败/unknown/覆盖损失均可核对。不据2/3声称原次数合规，无新增运行/未来额度豁免；只读核对不重复已通过检查。缺证/不适用/冲突或非completed不释放；作者维护或局部review completed不满足本gate，不回填原P-v6/G-FORGE-REBUILT-CONTENT，本次未执行或放行。 |
| W-FORGE-PATCH-1165 | non-notch 完整实际验证 Q-1165 | VERIFY-FORGE-PATCH-1165 | G-FORGE-PATCH-FIXTURE-1165、G-FORGE-REBUILT-CONTENT-EVIDENCE | G-FORGE-PATCH-1165：本组独立 Result completed/足证据且采用，本组完整最终 SRG namespace/接口/引用/优先级/资源/适用 mcinject/AT、独立参考/见证、forge 实际完整路径隔离与冷热缓存成立；不等 Neo/R/D/B/M，不用 P-v/basic 代证；缺实际内容/缓存/运行/JDK/partial 不释放。 |
| W-FORGE-PATCH-NEO-VERIFICATION-WIRING | 已采用completed：Q-Neo opt-in 源码接线，仅静态核对 | WIRE-FORGE-PATCH-NEO-VERIFICATION | 无 | G-FORGE-PATCH-NEO-VERIFICATION-WIRING：既有源码Result/静态证据已由Router采用满足，未编译实跑，不重做或由此完成Q；原三个接点/default/完整断言/唯一runner/producer依赖合同保留。 |
| W-FORGE-PATCH-NEO | 历史g1 blocked：outer/nested/prepare/reference全0，旧gate未满足 | VERIFY-FORGE-PATCH-NEO | G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE | G-FORGE-PATCH-NEO：本组唯一运行 Result completed/足证据且 Router 完整采用；原 official/无 mcinject 全内容/接口/引用/优先级/资源/AT/明确 Dist 主属性/marker/有限资源关系、neoforge 实际完整路径隔离/冷热成立。必须先验旧 final 完整内容及原冷段适用性，再一次原 operation/输入/key/basename/完整 cache path 的真实 action hit，最后新 final 同样全验；outer真实exit0/JUnit实际1/0/0/0和明确hit均必需，调用上限outer1/nested1/prepare0/reference0。缺21/内容/离线依赖/适用身份/真实hit/退出不释放，不由T成功、源码交付、UP-TO-DATE/FROM-CACHE或新root miss代证，不扩大旧attrs/全class side。此为原完整合同，g1 blocked不回填或继续派发；当前接续另见W-FORGE-PATCH-NEO-PREPARED-VALIDATION。 |
| W-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT | 已采用g1源码completed/窄预检成功；原合同保留、不重做 | FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT (前置item: WIRE-FORGE-PATCH-NEO-VERIFICATION) | G-FORGE-PATCH-NEO-VERIFICATION-WIRING（既有采用满足） | G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT：唯一独立源码Result completed/足静态证据且Router采用；helper三处仅按Plan确切路径缺失且当前空集保留声明项，存在时正常真实路径/来源检查，56项同序/其余55项严格核对/不吞异常/不改原argv-reference-metadata/不造目录/原完整断言及default均保留；不编译实跑、不完成Q，缺证/失败/unknown不释放。既有源码及窄预检成功不等于Q通过；本维护不新判gate。 |
| W-FORGE-PATCH-NEO-PREPARED-VALIDATION | 历史g1 failed：compileTestKotlin/exit1，outer1/nested0/prepare0/reference0，JUnit未到达，旧gate未满足 | RECOVER-FORGE-PATCH-NEO-PREPARED-VALIDATION (前置item: FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT, WIRE-FORGE-PATCH-NEO-VERIFICATION, RECOVER-FORGE-PATCH-NEO-CPW-MODS, ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE) | G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE（后三gate既有采用满足） | G-FORGE-PATCH-NEO-PREPARED-VALIDATION：唯一新运行Result completed/足证据且Router采用；未来预检与helper同一窄规则，并完整满足原Q official/无mcinject全内容/引用/优先级/资源/AT/Dist主属性-marker-有限资源及路径隔离/冷热合取，旧完整内容和冷段适用性→原同路径真实action hit→完整新内容、outer真实exit0/JUnit1/0/0/0/明确hit均必需，合计outer≤1/nested≤1/prepare0/reference0、必要编译仅该outer。缺必要输入/冲突/实际失败/unknown/miss/缺证停止，不以剩余额度重试；原g1 blocked/旧gate不回填，不代完整代理/R/V/H。原一次调用已消耗；不继续派发或回填，当前接续见W-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX。 |
| W-FORGE-PATCH-NEO-STREAM-COLLECTION | 已采用g1源码completed；后续唯一Q outer编译真实通过，不重做 | FIX-FORGE-PATCH-NEO-STREAM-COLLECTION (前置item: FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT) | G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT | G-FORGE-PATCH-NEO-STREAM-COLLECTION：唯一源码Result completed/足静态证据并Router完整采用；仅helper279末端替换为.iterator().asSequence().toList()，过滤/顺序/即时收集/use关闭/完整断言/default不变，实际一行diff及回读齐备，不编译运行。失败/partial/blocked/缺证不释放，不代Q通过。 |
| W-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX | 历史g1 failed：编译通过、身份断言失败，outer1/nested0/prepare0/reference0、exit1、JUnit1/1/0/0，旧gate未满足 | RECOVER-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX (前置item: FIX-FORGE-PATCH-NEO-STREAM-COLLECTION, FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT, WIRE-FORGE-PATCH-NEO-VERIFICATION, RECOVER-FORGE-PATCH-NEO-CPW-MODS, ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE) | G-FORGE-PATCH-NEO-STREAM-COLLECTION、G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE | G-FORGE-PATCH-NEO-Q-AFTER-STREAM-FIX：唯一新运行Result completed/原Q全部足证据并Router完整采用；同一窄预检及完整旧内容/冷段适用性→原同路径真实action hit→完整新内容、outer真实exit0/当前JUnit1/0/0/0/nested真实BuildResult-TaskOutcome SUCCESS/明确hit/原隔离工具参考加载产物关联全齐。此项outer≤1/nested≤1/prepare0/reference0，编译仅自然包含在outer，不追加探针/重跑成功项。失败/unknown/缺证/miss不释放；旧blocked/failed及两旧gate不回填，不代完整代理/R/V/H通过。 |
| W-FORGE-PATCH-NEO-ACTION-FINGERPRINT | 已采用g1源码completed；以下原合同保留，不重做 | FIX-FORGE-PATCH-NEO-ACTION-FINGERPRINT (前置item: FIX-FORGE-PATCH-NEO-STREAM-COLLECTION) | G-FORGE-PATCH-NEO-STREAM-COLLECTION | G-FORGE-PATCH-NEO-ACTION-FINGERPRINT：所属唯一源码item的Result completed/足静态证据且Router完整采用；只在actionFingerprint内严格配对标准metafactory三参数与altMetafactory同三项加整数flag1，核bootstrap Handle属性；前三项/实现目标/其它指令及未匹配规则保持，身份断言和最终class仅忽略debug比较未减。精确局部diff和回读齐备，不编译运行或加单测/探针/全链审计/快照；partial/failed/blocked/缺证不释放，不代Q通过。 |
| W-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX | 已采用g1完整Q completed：outer1/nested1/prepare0/reference0、exit0、JUnit1/0/0/0；不重跑 | RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX (前置item: FIX-FORGE-PATCH-NEO-ACTION-FINGERPRINT, FIX-FORGE-PATCH-NEO-STREAM-COLLECTION, FIX-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT, WIRE-FORGE-PATCH-NEO-VERIFICATION, RECOVER-FORGE-PATCH-NEO-CPW-MODS, ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE) | G-FORGE-PATCH-NEO-ACTION-FINGERPRINT、G-FORGE-PATCH-NEO-STREAM-COLLECTION、G-FORGE-PATCH-NEO-EMPTY-JAVA-OUTPUT、G-FORGE-PATCH-NEO-VERIFICATION-WIRING、G-FORGE-PATCH-FIXTURE-NEO-CPW-MODS、G-FORGE-REBUILT-CONTENT-EVIDENCE | G-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX：所属唯一运行item的Result completed/原Q全部足证据且Router完整采用；同一窄预检、完整旧内容及冷段当前适用性→原operation10/inputs/key6d7a8c95/basename/完整路径真实action hit→完整新内容、outer真实exit0/当前JUnit1/0/0/0/nested真实BuildResult-TaskOutcome SUCCESS/明确hit/原隔离工具参考加载产物关联全齐。outer≤1/nested≤1/prepare0/reference0，编译仅自然包含outer；失败/unknown/缺证/身份不适用/冲突/miss即停，不追加调用、单测/探针/审计/快照。三个旧Q blocked/failed及旧gate分别保留不回填，不代完整代理/R/V/H通过。 |
| W-FORGE-PATCH-REGRESSION | 原完整R合同保留/未完成；已取消本轮执行及成功等待，以下gate未满足 | TEST-FORGE-PATCH-NAMESPACE | G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165、G-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX | G-FORGE-PATCH-REGRESSION：R 独立完整 Result completed/足证据且被采用，四项矩阵/准确方法参数/完整新增反例与 fixture 类/真实 AT/JarJar 实际成功，版本路径隔离与新语义 miss→rebuild→同版 hit/内容、两个 non-notch 参数和 NeoForge 收窄新鲜内容合同及独立见证齐全。无旧实物对照义务；缺输入/见证/JDK/运行或必需 skip 不释放。只为 V/H 必需质量证据，不阻 D/B/M 技术输入。 |
| W-BASIC-JAVA8-POSTPATCH | 生产修正后的完整同轮发现 D | RECOVER-BASIC-JAVA8-POSTPATCH | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE | G-BASIC-JAVA8-POSTPATCH：D 完整 Result completed、足证据且被采用，新批次某一次原basic完整同轮层级/共享语义、现有action实际compiler executable及metadata8闭合且正常有界运行/保全成立；旧17条、候选、偶然Jar、缺action、partial/failed/blocked均不释放，不回填旧failed/partial/gate或代替B/M。 |
| W-REMAPPED-API-RECOVERY | 原M API迁移/实际消费的独立恢复 | RECOVER-REMAPPED-PATCHED-API-RECOVERY | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-API-RECOVERY：新item唯一Result完整采用且completed，满足本节全部原M技术、consumer、nested观察、fresh身份及真实退出/收束标准；任何partial/failed/blocked/缺证/skip不释放。旧M failed及G-RECOVERY不满足永远保留，不由新结果回填/释放；只放行显式新复验/验收后继。 |
| W-REMAPPED-JAVA8-FORWARDING | 同轮完整标准属性Java8发现 | RECOVER-REMAPPED-JAVA8-FORWARDING | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING：唯一独立Result完整采用/completed且本项全部同轮转发/来源/实际compiler/回归/分存排他及真实收束证据满足。缺证/partial/failed/blocked不释放；下游失败照实保留，仅放行显式完整消费者，不满足完整M或任何旧gate。 |
| W-REMAPPED-JAVA8-FORWARDING-RESTORATION | 原确认范围内全部发现要求的未完恢复 | RECOVER-REMAPPED-JAVA8-FORWARDING-RESTORATION | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING-RESTORATION：唯一独立Result完整采用/completed且原发现全部要求及本项恢复/实际回归/同文件身份拒绝/正确完整启动前资源/分存排他/真实同轮链与收束逐项满足；旧成功不拼轮，缺证/partial/failed/blocked/unknown不释放。只放行显式完整M，不证明完整消费，不自动完成旧发现item或释放G-REMAPPED-JAVA8-FORWARDING/两旧M gate；原始completed、核查不满足、历史偏差及偏差未接受分别保留，不以新技术成功补授权。 |
| W-REMAPPED-JAVA8-FORWARDING-VALIDATION | 保留源码后的未完完整发现 | RECOVER-REMAPPED-JAVA8-FORWARDING-VALIDATION | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING-VALIDATION：唯一独立Result完整采用/completed，原发现与RESTORATION全部要求、夹具纠正后同版整组自检/真实共享参数路径回归、新同轮完整发现/真实采样/收束足证据均满足；19项/已写源码/旧轮不代整组或本轮成功，缺证/partial/failed/blocked/unknown不释放。只供显式完整M，不自动完成旧RESTORATION或旧发现/两M item，不释放任何旧gate或接受历史偏差。 |
| W-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY | 保留20/20后以正确shell闭合未完完整发现 | RECOVER-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING-SHELL-RECOVERY：唯一新独立Result完整采用/completed且足证据，20/20适用复用、未完编译/实际共享参数回归/一次新同版完整发现及原身份/逐次紧邻spawn完整资源排他/退出收束全部满足；缺证/partial/failed/blocked/unknown不释放。仅供显式独立完整M，不完成旧VALIDATION/RESTORATION/发现item或旧gate，不接受历史偏差。 |
| W-REMAPPED-JAVA8-FORWARDING-PREPARATION-RECOVERY | 保留20/20后按新准备错误边界闭合未完完整发现 | RECOVER-REMAPPED-JAVA8-FORWARDING-PREPARATION-RECOVERY | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING-PREPARATION-RECOVERY：唯一新独立Result完整采用/completed且足证据，20/20适用复用、未完编译/实际共享参数回归/一次新同版完整发现及原身份/逐次紧邻spawn完整资源排他/退出收束全部满足；缺证/partial/failed/blocked/unknown不释放。仅供显式独立完整M，不完成旧VALIDATION/RESTORATION/发现item或旧gate，不接受历史偏差。 |
| W-REMAPPED-JAVA8-FORWARDING-LIFECYCLE-RECOVERY | 历史复合恢复（原整组failed/旧gate不满足保留） | RECOVER-REMAPPED-JAVA8-FORWARDING-LIFECYCLE-RECOVERY | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-JAVA8-FORWARDING-LIFECYCLE-RECOVERY：唯一新独立Result完整采用/completed且本item原完整发现与已确认新根临时harness一参/System属性四输入/原三参数、共享生命周期/逐份新字节SHA及受影响检查/真实8项+汇总9行/身份exit0/drain全部成立；参数未全通过不得新发现，保留编译不重跑。仅旧编译/旧20项适用或缺证/partial/failed/blocked/unknown不释放。仅供不同Handler独立fresh完整M，不完成PREPARATION或任何旧item/gate，不接受历史偏差。 |
| W-REMAPPED-LIFECYCLE-FIXTURE | 夹具恢复failed及11项局部事实 | RECOVER-REMAPPED-LIFECYCLE-FIXTURE | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-LIFECYCLE-FIXTURE：原完成合同须本结果completed/足证据且采用；实际failed/11项不代全组，旧gate不满足，任何新恢复不回填，不作为现行后继成功等待。 |
| W-REMAPPED-LIFECYCLE-COMPILE-CHECK | 第12项独立恢复记录 | RECOVER-REMAPPED-LIFECYCLE-COMPILE-CHECK | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-LIFECYCLE-COMPILE-CHECK：本项独立Result completed/足证据且完整采用，受控第12项及工具身份/异常保全全部满足；不回填前11项所在failed或证明整组/真实运行。作者仅登记事实，未判gate。 |
| W-REMAPPED-ARGUMENTS | 真实8项参数独立结果 | VERIFY-REMAPPED-ARGUMENTS | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165、G-REMAPPED-LIFECYCLE-COMPILE-CHECK | G-REMAPPED-ARGUMENTS：本项独立Result completed/足证据且完整采用，一参helper/System四输入/原三参数/唯一完整-D/无-P、单Java身份exit0/8项+汇总9行/EOF无error及drain与class/hash关联全部成立；不代完整发现/M，不回填failed，作者未判gate。 |
| W-REMAPPED-JAVA8-EVIDENCE | 同轮Java8选择独立结果 | VERIFY-REMAPPED-JAVA8-EVIDENCE | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165、G-REMAPPED-LIFECYCLE-COMPILE-CHECK、G-REMAPPED-ARGUMENTS | G-REMAPPED-JAVA8-EVIDENCE：本项独立Result completed/足证据且完整采用，全部本项同轮属性/选择compiler/worker三断点/身份/资源排他/真实退出收束满足；Provider间接及UP-TO-DATE限制保留，不代完整发现/fresh M，作者未判gate。 |
| W-REMAPPED-DISCOVERY-EVIDENCE | 原版本关联g1已完整采用/gate满足；不证明新helper | ASSESS-REMAPPED-DISCOVERY-EVIDENCE | G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165、G-REMAPPED-LIFECYCLE-COMPILE-CHECK、G-REMAPPED-ARGUMENTS、G-REMAPPED-JAVA8-EVIDENCE | G-REMAPPED-DISCOVERY-EVIDENCE：本项唯一独立完整Result completed/足证据且Router完整采用，原全部发现义务逐项版本/输入/环境/检查及同轮观察覆盖关联成立，所有分段终态/限制保留；无重跑、自动assessment或日志行数代证。缺证/真实差异/不适用/unknown或非completed不释放，只供不同Handler独立fresh M，不回填任一旧gate。 |
| W-REMAPPED-NESTED-RERUN | 默认关闭且仅本轮启用的接线 | WIRE-REMAPPED-NESTED-RERUN | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS | G-REMAPPED-NESTED-RERUN：本项独立完整Result completed/足证据且采用；实际helper与新根子env入口、编译/加载、最小启用/默认/basic真实参数检查成立，原接口/三参数/唯一-D及写拥有未越界。原generation1 failed/已写未验证，旧gate不满足且不作现行成功等待；非completed、缺证/unknown或默认改变不释放，不证明正式回归/M。 |
| W-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION | 历史generation1 failed/已写工具/目标零启动；撤销现行成功等待 | RECOVER-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS | G-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION：以下原完成合同仅保留历史，原gate不满足、不再供现行后继等待、不回填。唯一新成员独立完整Result completed/足证据且Router完整采用，原WIRE完整接线合同、本项仅剩工具参数合同纠正/必要编排、受影响内部检查、新编译加载/源码输出class身份、精确runtime/classpath/来源、逐次资源排他/唯一Capture立即身份/finally真实exit与EOF无error-drain、最小启用-default-basic及父环境无写回全部成立。不重复源码补写，旧根只读，不代正式VERIFY/同daemon隔离或完整M，不回填两旧failed/gate；缺证/unknown/非completed不释放，本次未执行或放行。 |
| W-REMAPPED-NESTED-RERUN-WIRE-RECOVERY | 历史恢复g1 failed，根g2已写源码输出但未验证，旧gate不满足 | RECOVER-REMAPPED-NESTED-RERUN-WIRE | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS | G-REMAPPED-NESTED-RERUN-WIRE-RECOVERY：唯一新成员独立完整Result completed/足证据并完整采用，原WIRE全部接线合同及本恢复写拥有、源码输出补齐与新编译class身份、分类/逐次完整采样/唯一Capture立即身份及finally退出EOF-error-drain、精确运行时和classpath/加载来源、受影响内部安全检查/最小真实启用-default-basic/父环境无写回证据全部满足。仅放行显式后继，正式VERIFY矩阵/同daemon隔离及M仍独立；缺证/unknown/非completed不释放，不回填旧WIRE/gate。原generation1已failed，不作为现行成功等待；上述完整原合同保留，不能用新验证恢复Result改判。 |
| W-REMAPPED-NESTED-RERUN-REGRESSION | 现有JUnit参数及同daemon隔离独立结果 | VERIFY-REMAPPED-NESTED-RERUN-REGRESSION | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS | G-REMAPPED-NESTED-RERUN-REGRESSION：本独立完整Result completed/足证据且Router采用，现有JUnit真实两工程四路径及1/移除/空/0/其它非1、完整argv/basic默认、同daemon开启后关闭/新worker/独立env预期、各次Gradle0/JUnit1/0/0/0/保存与真实退出成立；不等WIRE/M，不新增P/Q直接成功等待，不代消费者，失败/unknown/缺证不释放。 |
| W-REMAPPED-CONSUMER-RERUN | 原Java8消费者真实编译打包独立结果 | RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-CONSUMER-RERUN：本独立完整Result completed/足证据且Router采用，固定原M链/必要来源/namespace/provider/classpath/当前有效输入产物、Java8真实compileJava非NO-SOURCE及jar、printCompileClasspath执行、Gradle0/JUnit1/0/0/0/实际退出及分存排他全部成立；上游有效缓存允许，消费任务缓存/skip不代执行。不等参数或WIRE；撤销jdb/内部自证覆盖须明示，失败/unknown/缺证不释放。 |
| W-REMAPPED-CONSUMER-RECOVERY | 历史消费g1启动前blocked/零写入零构建；不继续派发，原合同保留 | RECOVER-REMAPPED-PATCHED-CONSUMER-RECOVERY | G-REMAPPED-DISCOVERY-EVIDENCE、G-REPAIRS、G-FORGE-REBUILT-CONTENT-EVIDENCE、G-FORGE-PATCH-1165 | G-REMAPPED-CONSUMER-RECOVERY：唯一独立Result完整采用/completed且本项全部原M链/fresh consumer/classpath/同轮nested provider及compiler/真实Gradle0和JUnit1/0/0/0/排他分存及退出收束满足；须实际满足新发现恢复前置，不能用旧原始completed/核查completed代替；缺证/partial/failed/blocked/skip不释放，仅供显式V/H。原两M failed及两个旧gate不满足不回填。 |
| W-REVERIFY | 原完整V合同保留/未通过；已取消本轮执行，以下等待只属历史完整验收 | VERIFY-RECOVERY | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE、G-REMAPPED-NESTED-RERUN-REGRESSION、G-REPAIRS、G-FORGE-PATCH-REGRESSION、G-BASIC-JAVA8-POSTPATCH、G-REMAPPED-CONSUMER-RERUN | G-RECOVERY-INTEGRATION：参数回归独立Result/gate也须足证据并采用，remapped观察按当前第9款替换；独立 Result completed 且被采用，全部显式原修复/Mixin/三组T/P-v/两组Q/R/D/完整B/独立M均 completed 加足证据，并逐项满足下文完整 gate 合同；不由历史拼接、局部成功或数量汇总自动满足。 | |
| W-ACCEPTANCE | 原全交付H及gate未通过；不由精简收尾替代，以下保留原完整等待/合同 | REVIEW-ACCEPTANCE | G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER、G-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION、G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE、G-REMAPPED-NESTED-RERUN-REGRESSION、G-RECOVERY-INTEGRATION、G-REMAPPED-CONSUMER-RERUN | G-ACCEPTANCE：参数回归独立Result/gate也须足证据并采用，remapped观察按当前第9款替换；其 Result completed 且被采用，独立核对 Plan 同一局部/完整模块清单与实际内容/报告，明确原三谓词、Mixin/basic/remapped 完整恢复及 basic 新发现证据和全部证据要求满足，无范围内未解决缺陷、必要验证空缺或待决合同；仅 review 完成不够。 | |

### G-RECOVERY-INTEGRATION 完整合同

**原完整V/H门槛及未通过事实保留。** 以下全模块fresh、根入口、完整R及各分支合取不再是本轮执行义务；也未被新兼容gate满足或放行。当前唯一运行及必要直接连接见[页首](#精简r与最终验证的现行连接)，原H不能消费限定兼容结论冒称全交付验收。

**统一代理范围的现行合取补充（第1/10款及H同时适用）：** 原十二项中的T-Neo现为RECOVER-FORGE-PATCH-NEO-CPW-MODS及其新gate；另须PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY与VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION两个独立Result被Router完整采用，并满足G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE；该完整gate须13个结果/gate（一个有限三模式JUnit、11个其它动态结果及一个静态入口归属）全部采用且足证据，并保留合成根来源逐键缺失/空/非空、HTTPS显式空值、Properties转义/无关键/凭据排除等未覆盖映射证据的独立未满足条件；这些缺口不再附加到有限JUnit完成谓词，也不因其通过而自动补齐。当前固定输入无补齐入口，原完整gate仍未满足，V/H及其它完整消费者不能仅凭一次测试成功放行；仅本次T-Neo单次启动解除这一等待，不豁免原T-Neo成功条件。准备仍复用已满足的RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER与RECOVER-INDEPENDENT-TESTKIT-BOOTSTRAP-ARGFILE-VALIDATION及其gate，不重跑。旧 `RECOVER-ROOT-TEST-PROXY-CHECK` 及其 `G-ROOT-TEST-PROXY-RECOVERY` 仍是历史 failed/不满足，不回填。新准备/审计及合取不替代十二项、参数回归、完整M或V/H，也不算三个新游戏消费者。Q-Neo/R/V/H消费新完整T身份，旧PREPARE/名称恢复/仅运行恢复及AFTER-PROXY四次failed及各旧gate不满足永不回填，累计四次/未来至多一次（累计至多五次）不重置；实际独立调用均须接持久bootstrap/本轮classes/显式源home，历史脚本不改。V在最终同版fresh中包含新增IsolatedGradleProxyTests及相应检查适用性，H独立核对五键/错误/无残留/隔离/凭据/来源、三模式与独立边界和T-Neo/Q-Neo分离；若来源或实际实现漂移使旧证据不适用只处理具体缺口，不一律重跑旧成功。第2–10款未变技术合同、参数/M无Neo成功前置及共享串行保留。本补充未建立任一实际完成/确认/gate释放。现行根输入仅RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER及其新gate：已修单行/原输入跟踪∧首次D已证业务/Test/JUnit/来源与五键缺失输入及用户接受的controller外层风险复用∧版本/JDK/cwd/隔离home/源码和缓存键相关init/observer/cases路径稳定∧唯一一次直接Gradle完整真实argv调用∧shell取得真实Gradle数值exit0∧本轮日志明确configuration-cache restored/reused。stored、失效重配、仅任务缓存、仅BUILD SUCCESSFUL、未知退出或无恢复日志不满足；Test可UP-TO-DATE但不声称恢复后动作重新执行。旧缺失输入blocked/当时零写入及两次D零启动、XML failed、VALIDATION partial、NEW-DAEMON failed/已修源码/首次业务通过/第二次零启动及全部旧gate保留；新成功不回填。其它原十二项、V/H自身fresh与独立验收均不减。

**当前补充（第1/9款remapped输入与覆盖替换）：** M仅指RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN/G-REMAPPED-CONSUMER-RERUN，另独立合取VERIFY-REMAPPED-NESTED-RERUN-REGRESSION/G-REMAPPED-NESTED-RERUN-REGRESSION；二者互无成功前置且必须串行，不再等任何WIRE/private harness成功。原发现g1采用只在当前未变范围适用，不重开或冒称新helper通过；最新验证恢复g1 failed/actual类型已写修正/AST可空错误/目标零启动、原WIRE和恢复g1 failed及旧消费blocked/全部已写效果/旧gate不满足保留，不回填。原十二项完整恢复Result、第2–8/10款、basic自身D/B及其第9款观察、P/Q/R等其它分支合同不变，不新增第13个消费者。

**第9款remapped现行替换（适用于V/H）：** 原逐层Provider/Test/runner/nested System、StartParameter两map、gradleProperty/effective installations、jdb安装/监听/attach/断点、Capture内部及全量hash/逐份私有检查证明已撤销，仅保留为下方历史；不再成功等待或据此重建自证链。改用当前JUnit普通输出与独立提交env、源码/实际参数转发接点及真实Java8 compileJava/jar、现有来源/classpath/产物关联证明参数和实际消费，去outer --debug-jvm、不改withDebug(true)。参数非1值、basic/默认、同daemon开启后关闭、新worker/父环境不写回仍必需；M有效上游缓存允许，消费compileJava/jar不得以缓存/skip替代，必要来源不足仍缺证。内部逐层未直接观察须明示为撤销覆盖，不称通过；身份/排他/真实退出/失败保存和共享串行仍必需，不扩一般重试。最终V/H各自须核对两个独立Result及同版实际内容，旧观察或文档自检不代新执行。

**历史补充（已被上述当前条款替代，保留原失败和当时合同，不再现行等待）：** 本轮M仅指RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN/G-REMAPPED-CONSUMER-RERUN；原发现g1已采用/gate满足只对原版本，须联合G-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION及原G-REMAPPED-NESTED-RERUN-REGRESSION；原WIRE及恢复g1均failed、源码输出已补未验证、诊断只读及旧G-REMAPPED-NESTED-RERUN/G-REMAPPED-NESTED-RERUN-WIRE-RECOVERY不满足保留，不回填或等待旧失败转成功。verify-remapped-fresh-consumer g1启动前blocked/零写入零构建不改，原消费者gate不满足不再等待。本轮M实际javac8/compileJava/jar必执行，上游有效缓存允许且来源/输入/产物身份须闭合，不增加删除/备份/冷重建；第2–8/10款及其它分支缓存义务不变。 M的新发现成功输入为ASSESS-REMAPPED-DISCOVERY-EVIDENCE / G-REMAPPED-DISCOVERY-EVIDENCE的完整关联Result与实际足证据采用，不再等待旧LIFECYCLE-RECOVERY failed/gate。参数8项+汇总9行completed、同轮Java8选择completed、第12项恢复completed各自独立保留；原修正/聚焦20项整组failed、夹具11项passed但整组failed、旧审查blocked不改，20+11+1不叫一次全组成功，原全部新字节/受影响检查/未变适用/同轮发现要求逐项核对不能省。Producer graph两日志各9行纠正旧0行，但不代完整M；自动广义assessment未采用。PREPARATION failed/编译exit0/旧20项适用/PID300888 unknown、全部旧failed/未采用completed/停止违规/9备份和未接受偏差完整保留。V/H仍直接等待不同Handler独立fresh完整M，十二项最终合取、第2–8/10款与原全部技术标准不减，不增加第13个完整消费者；现有选择和分段检查不代M或新完整关联，本次不实施/采用/判断实际完成或放行。

**历史第1/9款M发现输入说明（仅保留当时准备连接，现行输入以上述当前补充为准）：** “M消费新发现Result/gate”和“新发现→独立完整M”当时指RECOVER-REMAPPED-JAVA8-FORWARDING-VALIDATION及其新gate实际满足原发现及RESTORATION全部要求；RESTORATION generation1 failed、19项/已写效果及原gate不满足保留，新结果不回填；旧发现原始completed、核查不满足及旧gate未释放不回填。M的独立完整链/真实javac/fresh消费、V/H前置及12项完整恢复合取不变，不以invocation-10 UP-TO-DATE或新技术成功代完整M、接受历史偏差或放行。第2–8/10款、原两M失败及其余历史不改；当前作者不执行或采用新Result。

以下保留原组合gate全部技术义务，现行完整P成功输入为P-v6-a自己的独立证据采用Result/新gate，技术材料仍来自原P-v6 partial且不改写它；P-n-v完整源码Result/源码gate满足是Router已采用事实。第9款‘P-recovery之后’保留原消费位置语境，现消费新的完整P证据采用输入，不要求旧partial/gate转成功，也不降低发现/观察合同。T-basic-v3已采用completed/gate、旧failed/partial/unknown及全部原完整合同/未满足gate保留，不重跑准备。本次不建立P-v6-a完成、新gate释放或最终验收事实：

1. VERIFY-RECOVERY 自己的 Result completed 且被完整采用，Plan 完整模块清单和局部/新增案例均有最终同版实际结果；原 G-REPAIRS 下 FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8 三个 completed Result 关联保留，RECOVER-FIXTURE-RULE、RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION、PREPARE-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-CPW-MODS、RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION、ASSESS-FORGE-REBUILT-CONTENT-EVIDENCE、VERIFY-FORGE-PATCH-1165、RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX、TEST-FORGE-PATCH-NAMESPACE、RECOVER-BASIC-JAVA8-POSTPATCH、RECOVER-BASIC-ARTIFACTS、RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN 十二个独立 Result 均完整采用且 completed 加足证据（M消费ASSESS-REMAPPED-DISCOVERY-EVIDENCE / G-REMAPPED-DISCOVERY-EVIDENCE的完整关联Result及实际足证据采用，发现不是第13个完整消费者；原M及API恢复两failed、已写fixture及采样缺口保留，旧两gate均不释放）；其中P-n-v已由Router采用满足源码gate，P-v6-a完整证据判断已采用completed、对应gate已由Router判断满足（只读采用，不冒称新运行），原P-v6 generation1及redelegated generation2语义partial/本次已接受网络偏差/旧G-FORGE-REBUILT-CONTENT未释放单独保留，不把原partial计入这十二个必需completed Result或豁免其它分支；原P-n generation1 partial/两owner与version10保留/编译及四引用未完/旧gate不满足、新恢复不回填；P-v/P-v2/P-v3/P-v4/P-v5 generation1 failed及其完整合同/旧gate不满足（含P-v3静态错误/零runner/UTC463.814秒/缺monotonic起点/方法晚读）（另保留P-v4的325真实内容差异/原独立reference根因/双时钟1123.852秒/无hit/加载闭合及schema-GBK纠错/证据覆盖局限）、原P与P-recovery各generation1 partial/原始parents错误/重复目录exit1及deadline后postprocess/两个旧gate不满足、T-basic-v3 completed/已采用gate及首轮DNS失败保留；旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各generation1 failed及T-basic-v历史调用/启动/退出unknown、T-basic-v2真实Gradle退出/后代结束原因unknown/原合同及各旧gate未满足、NORMAL-RETRY failed（缺ICommandSender、无compiler两行、偶然Jar非B）及原RECOVER-BASIC-JAVA8-TOKEN-RECOVERY partial及其工具/同版离线效果，原 RECOVER-BASIC-JAVA8 和旧 RECOVER-BASIC-JAVA8-RETRY 两次 partial 与旧有限批次failed及RECOVER-BASIC-JAVA8-RECOVERY failed、各自诊断/时间/停止及token/身份交接限制、成功接线/失败/流程偏差只作完整保留的输入，不要求其转成功。发现部分必须组合原成功接线的当前对应与新独立恢复某一次全部同轮观察/实际 compiler，不能跨轮拼接旧14/17条观察。旧 basic blocked/三失败/最终脚本未运行事实继续关联，不能当成功前置，也不要求旧 G-RECOVERY 释放。任何 partial/failed/blocked、只读诊断或缺证据不能替代所需新前置。
2. Mixins、Fabric、Forge 完整模块必需 fresh，执行前枚举全部当前类/方法/参数，逐项覆盖首轮 **153 testcase（107 Mixins、28 Fabric、18 Forge）** 加全部当前新增/迁移恢复案例；不能固定153为封顶、用131或删方法降数通过。原19类/141源方法包含两个 factory 的对应仍可追踪，旧→新语义映射、execute/pass/fail/skip 和源码身份→XML/HTML/stdout/fixture 均有依据。
3. Mixins 完整14个当前类和新增类全部运行，包含故障阶段、InputBinding、Mapping、OperationIsolation、Preapplication、Producer、Resource、SafeRetention、StripMixins、StripRegistration、StripStream、FixtureMixinRule、ProducerDom、StripDom；原 Manifest A/B/X 顺序与真实缓存5阶段、目录/Jar/MR/编码/关闭、直接Jar失败、外置/异正文/side、原输入、两输出失效、真实 metadata read/close/read-close 与 identity/suppressed/retry、所有有效隔离/Strip/精确清理/当前输入回归均保留。StripStream 动态例外不变，不引入已排除预约/竞争要求。
4. Fabric 完整 FabricMixinMetadataTests、FabricMixinApplicabilityTests 及新增案例；invalidUtf8LoadMatchesDefaultStream 与 invalidUtf8RemoveMatchesCurrentDefaultStream 两 factory × 七原字节全部实际执行，以同库默认 Json.decodeFromStream 为 oracle，原 .bin/业务结果/未知字段/snapshot/原输入/当前metadata及未写出可定位；既有六种真实 I/O 模式及明确重置后的 retry 全部保留。
5. Forge 三个完整必需类及当前新增案例全部实际执行：net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests 的 producer/host discovery/metadata I/O；net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests 的真实 AT/JarJar；net.msrandom.minecraftcodev.forge.PatchedMinecraftTests 两方法。不能条件省略、别称或根入口缓存代替。两 fixture 需从当前任务 API/实际来源产生 patched/remapped Jar，保留版本、userdev3/userdev、MCP/patch/universal/libraries/mappings/namespace/classpath 证据及原 Java8 consumer 的真实 compileJava/jar 消费，basic 为 EVENT_BUS / MinecraftServer.main 的编译可见性，remapped 为 EVENT_BUS / named Entity.class 的编译可见性；不增加继承/override，真实 AT 仍由本款兼容类证明，非只配置成功。
6. 新增 FixtureMixinRule 恢复证据包括 load 实际发现声明名、remove 传入 root、未发现 side 不删、真实缺失/删除 IOException 包装、确定性 read/remove 命中和 retry、不可变 snapshot/原输入；首轮三失败分别关联到新实际案例，不能仅称整个 suite 通过。
7. 三模块 fresh 后根入口证据齐全，根 :test 真实图含三模块并成功到达应有末端；UP-TO-DATE/FROM-CACHE/自动重跑与此前 fresh 分列。图存在、任务未到达、旧缓存或历史数量不能代替 fresh。任何必需类/案例失败、缺跑或 skip、陈旧缓存均不满足；原因说明不豁免覆盖。
8. 所有证据与同一最终 tracked/untracked 源码/fixture/build/配置内容一致，运行前后无漂移（HEAD 不能替代实际内容），保留 Gradle/JDK、实际三个 test.javaLauncher 和 fixture.gradleJava，沿用 launcher17/现行参数。模块运行串行，clean 预核 Delete 目标仅相应模块 build，不动根 build/首轮及历史局部证据。每个 fresh 完成即保存 XML/HTML/日志/fixture，根自动重跑另存；原 failed、所有本轮失败/重试及限制完整保留。

9. basic 同一最终版本还须保留已解析 Provider→Test 系统属性→basic/remapped各自完整非空同名-D单参数→nested 实际 Java8 compiler metadata/executable 的对应；无空/null、硬编码本机路径、新 fixture.*或用户配置修改；remapped保留同值转发和原consumer，仅在本轮显式进程环境入口启用nested任务重跑；日常默认及basic不变。VERIFY-RECOVERY 在最终内容两次原方法执行中分别保存 basic/remapped 的最终 arguments、nested 同名 System 属性、StartParameter.systemPropertiesArgs/projectProperties、effective toolchain installations 配置与实际 compiler，附工程/调用/阶段标识及共享 Test 属性/withDebug(true) 的实际语义解释，独立验收消费这两套证据。basic/remapped非空时各应有且仅有一个完整同名-D，新增观察gradleProperty provider值及与effective installations/实际compiler的对应，不能仅以参数/System可见证明toolchain成功；必须据实际对象/选择/任务语义观察判定，缺观察、影响未决或改变原合同均不满足本 gate，只报告、不扩大新标准属性接线之外的JDK/consumer语义。不要求basic发现项提前跑 remapped，也不增加额外观察专项 item/Result；basic新独立恢复仍只恢复其原发现未完验证，remapped由已采用原版本ASSESS-REMAPPED-DISCOVERY-EVIDENCE / G-REMAPPED-DISCOVERY-EVIDENCE联合G-REMAPPED-NESTED-RERUN-WIRE-VERIFICATION及G-REMAPPED-NESTED-RERUN-REGRESSION→不同Handler独立RECOVER-REMAPPED-PATCHED-CONSUMER-RERUN完整M恢复，不重做已通过Q/P/D/B；其正常外层Gradle启动/现有Provider→Test→runner直接转值、Gradle选择的Test安装派生jdb和Java8 providers供LoadMappings/consumer及启动前后采样分存遵循新项，不增加首次启动前候选选择或Python属性读取器、不写死JDK目录、不回填旧采样。remapped发现的compiler证据按Plan配置完成回调真实解析，完整M/V/H仍须同轮真实Java8编译打包和全部原链，不以该回调替代完整消费；只验证当前绝对路径列表；zulufx8 候选与旧 zulu8 不混写为同一运行实例。basic发现项现有 compiler 证据来源为 printCompileClasspath 实际 action 两行，提前失败未到达则未完成；最终产物证据来自当前脚本真实执行，外层重跑不能替代 nested fresh，单独发现 Java8 不满足第5款或整个 basic。 新 POSTPATCH D 在 P-recovery 之后复用既有 basic 接线、已完成token/身份/观察及正常重试工具（无 R 技术前置）/同版实际函数离线131/131效果，不重做工具行为或检查；独立新批次最多3次/首次调用起总1800秒只服务同一发现谓词，普通缓存变化无需逐文件归属/sideEffectsSafe新认证、普通UncheckedIOException包装不否决网络再试，但原完整同轮成功合同不减，不减少任何上述最终证据；逐次分存时间/退出码/失败，不把原两次partial或不同调用拼接。外层Provider无直接对象帧观察的限制须明示，关联代码/消费值不能冒称直接观察；旧token partial、旧单次partial、有限failed、RECOVER-BASIC-JAVA8-RECOVERY failed及其原item/Wave/gate不因新成功满足。

10. 已采用P-n-v完整源码证据与已采用completed的P-v6-a完整证据判断须满足[本次采用策略](plan.md#p-v6-既有技术证据采用策略)、原完整技术策略及现行item/gate全部证据；P-v6-a只读核对原P-v6 partial中已通过技术证据与此次已接受偏差的采用连接，不重跑或回填旧gate，其独立Result completed/足证据及Router采用已发生，只读采用不等于新运行；原P-n partial及完整合同/旧gate不满足保持，P-n-v关联保留源码与适用旧证据并补齐原完整源码标准，不重做已完效果或回填旧状态；源码/原域接线/专属version10/input/四行真实固定工具回归独立保留，须关联原P-v6已执行的实际classes/runtimeClasspath/源码/完整输入/tool/JVM、当时全新隔离cache的10有效path先不存在→真实task-action miss/rebuild→fresh全量4782等oracle→同输入同版same-path全离线真实hit→再次完整oracle；原技术要求保持，本次核对不冒称新运行。四行raw独立预期→实际游戏rename→实际normalized overlay声明→最终产物闭合；两处有效reference修正与ItemPredicate/BlockFluidBase5指令/InnerClasses正负例仅在身份适用时复用，不重做纠正/从生产生成golden/删比较。7/8/9只读对照及10专属operation/实际输入域隔离有证；实际定位为`<cacheRoot>/cached-operations/<operation>/<aggregate-key>/<output basename>`，逐文件内容Murmur3-32/asBytes经源码toSortedSet比较器排序去重再putBytes聚合，basename/order/角色不进Core key，aggregate可与旧版相同。完整输入清单的角色/顺序/path/basename/bytes/SHA256/实际Murmur3-32、排序去重映射/重算aggregate及output/path，与声明/源码/加载/runtimeClasspath/工具/JVM身份分别对应；元数据不充当自动隔离。新fresh字节副本、已后处理的顶层cache输出与两次final的路径/bytes/SHA256/日志轮次关联，阶段中间件另记，不拿旧9/fresh代新成功。按[预算撤销后的执行准备边界](#预算撤销后的执行准备边界)和[现行Plan](plan.md#分钟预算撤销与作者自检)，用户已取消P-n→P-v6统一1800秒/30分钟截止、起点前UTC/单调配对、跨Handler共同原点/宿主可比性、交接扣时、Result发布末值、全链上界及60秒收束/独立保存余量证明，均不再是启动/继续/Result采用/本gate前置，不调查替代预算。P1机制未建立/P2证据不足仍为历史，不写成技术修好或复审通过；原生产修复及完整验收已确认，不重求旧起点或不变范围许可。原P-v6全链最多3次正常网络（含hit）及临时网络/前次正向退出/输出收束/分存/排他规则保留为其原合同；本次仅按用户已接受的这一次5标online/4实际在线Gradle偏差判断新证据采用，不以normalOnline=2或旧3计数声称原合同满足、不返还或提高未来次数、无新在线。其它分支原技术验证/重试合同、全部日志/失败/输入与加载身份、真实差异/冲突/控制退出unknown停止及单次工具合同不减。窄新根工具编写/类型纠错仍最小纠正、保留原失败并同版复查，不授权新reference语义纠正或越界生产，不削减完整验收。P-n独立成果可保留，本条不建立实施/独立复审通过或任何gate满足事实。P-v5 failed（4778/4782、四差异、1466.68秒、无Gradle/hit/加载闭合）、更早failed/两partial/旧合同/gate不满足及miss采样/计时/LSP/空集损失保留；旧P-v5只读生产/不cold仅限旧item，不禁止新item必要新构建。 以下T-basic-v3预算/控制只保留该已completed且gate已采用的准备历史，不重跑准备，也不转为P-n/P-v6预算前置。旧 T-basic、T-basic-r、T-basic-v及T-basic-v2各generation1 failed及各原完整合同/旧gate不满足完整保留；T-basic-v历史实际总调用/启动/退出unknown及T-basic-v2真实Gradle退出/谁结束后代unknown不因新成功消失，当时新执行的真实隔离/排他/输入与实现复用安全、同一bash terminal前台同步原gradlew/argv、terminal_wait仅等同一terminal不重启、实际工具timeout按剩余1800扣出收束/保存余量须实际验证（至少60秒收束并另留合理保存余量）；删除Start-Process＋WaitForExit false先exit124分叉，强制中断只记工具事实/Gradle码unknown、不保证正常码，控制/身份/退出未知即停，具体冲突或无安全路径即停；新独立T-basic-v3只重跑未完完整验证，不重做两文件修改/LZMA，某轮完整1/0/0/0与全部prepare/reference/CLI/输入/工具/JVM/阶段/任务/最终output/prepared/class/resource witness/inventory同轮闭合；最多3次/首次实际调用起总30分钟含取证/间隔/收束，逐轮新根/分存，仅临时网络且正向退出/排他/实际余量充分再试，非网络/未知/上限停止，不拼轮，不能借诊断 completed 或 t9 task 成功回填。S 及未来旧实物对照已撤出，不是本 gate 前置。T-basic-v3/T-1165/T-Neo 三组固定真实输入/provider/隔离/实际 Java 角色、官方同版参考及具体见证必须可复现；P-v/basic、Q-1165/1165、Q-Neo/Neo 及 R 的新鲜最终内容的 patched 优先、未补丁接口/引用/entry/this_class/descriptor/namespace/资源/适用 AT、语义版本有效完整路径隔离与隔离私有缓存 miss→真实 rebuild→同输入同版 hit 有证。R 四项矩阵、两个 non-notch 参数、同组 NeoForge 新鲜明确 Dist 主属性/marker、universal/资源和原始资源差集有限核对、完整新增反例/fixture 类及真实 AT/JarJar 均实际成功。资源只保留实际补丁输入阶段完整内容及合法后续工具/overlay，不新增 raw 恢复；仅固定 basic clean-only/inject 真空集按 Plan 明确不适用/阶段/身份/完整清单与覆盖损失，collision 核对 clean/patch 合集、空交集验证 universal-only，不豁免1165/Neo实有载荷。完整方法/矩阵仍实际执行，无 skip/假资源/换版；basic 非 class clean/inject正向与碰撞动态优先级未覆盖必须披露。无旧状态不证明旧错缓存动态拒绝/替换、旧 final 重放或完整旧 attrs 等价/全 class side 正确；限制/静态风险明示，不保留空头对照。Java21仅样本工具，Test17和两个Java8 consumer/原迁移边界不变。V 最终同版 fresh 重枚举 T/R 全部实际新增方法/参数，两个原 consumer 使用新语义真实产物。三组T、P-v6-a/Q-1165/Q-Neo/R/D/B/M任一必需新分支缺证/失败/partial/blocked或skip都不释放；原P-v6 partial只作核对输入，不能代P-v6-a自己的completed/足证据/Router采用；D/B 不等 Neo/Q/R、M 消费 P-v/Q-1165 而不等 Neo/R 不削弱最终合取。 P-v6-a采用仍须关联全部P-v6 typed锚点/11方法、已有效reference适用性及全部原技术要求，四行聚焦不代全量合同；现存证据若有真实差异/身份不适用则停止受影响采用并报告，不在本项重跑或扩权。 本次Q-Neo位置仅由RECOVER-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX/G-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX完整继承；Stream源码g1 completed已采用且其后唯一outer内compileTestKotlin真实通过，但Q-AFTER-STREAM-FIX g1 failed（outer1/nested0/prepare0/reference0、exit1、JUnit1/1/0/0），身份断言失败、旧完整内容/冷段当前适用性/hit/新内容未建立，该旧gate未满足，独立保留不回填；原VERIFY-FORGE-PATCH-NEO g1 blocked、PREPARED-VALIDATION g1 failed/outer1/nested0/prepare0/reference0/exit1及两旧gate未满足、WIRE/FIX源码completed与窄预检成功、诊断completed非Q通过独立保留，全部原Q内容/冷段适用性/原路径action hit/完整新内容/隔离/预算及消费者义务不减。

### 恢复分支与原 gate 的关系

下列早期恢复连接均为此前历史，原item/Wave/gate合同和不满足保留；其中“最新/现行/只等”以当时为限。唯一当前例外是下方“overlay 未完验证的现行连接”，与上表/当前item前置一致，不把新P-v连接也划作历史。
旧 W-INTEGRATION、VERIFY-COMBINED failed 和 G-INTEGRATION 不满足永久保留在本图；不重命名、不将新 Result 填入旧 item、不让恢复成功自动释放旧 gate。旧验收路线曾等待该 gate，尚无验收通过；本次显式重接为新 W-REVERIFY 的 G-RECOVERY-INTEGRATION → 原 REVIEW-ACCEPTANCE / G-ACCEPTANCE，不保留会令新恢复永远等待旧失败成功的伪依赖，也不把失败当成已完成前置。

以下四段为此前连接的保留历史，不是当前后继等待；最新精确替代见紧随其后的“partial 后的现行连接与旧 gate 保留”。

本轮另保留 W-RECOVERY 的原成员与 G-RECOVERY 合同：原 basic blocked 导致该 gate 不满足，新 Result 不填回它。现行 VERIFY-RECOVERY 明确不再依赖 G-RECOVERY 或旧 basic completed，而依赖新 G-BASIC-RECOVERY、G-REMAPPED-CONSUMER-RECOVERY 加 RECOVER-FIXTURE-RULE、RECOVER-REMAPPED-PATCHED-CONSUMER-RECOVERY 各自 completed/足证据；原 RECOVER-REMAPPED-PATCHED failed及旧G-RECOVERY仍不回填。W-BASIC-RECOVERY 两项均完成才可能释放其 gate；产物项只等待发现项而不等待自己 Wave 的释放。原 W-RECOVERY 内 remapped 只等待原 G-REPAIRS，不等待旧 basic 成功；这保留其独立性。 原W-REMAPPED-API-RECOVERY/G-REMAPPED-API-RECOVERY现保留failed及不满足历史；新发现不等待旧failed，新M仅等待新发现和适用P/Q门槛，不重放已保留fixture效果。

等效放行的可判定条件为：F=原 Mixin 完整合同及足证据，B=原 basic 固定来源/namespace/provider/patched/原 Java8 consumer/compileJava/jar/classpath 完整合同，M=原 remapped 完整合同，D=新增标准属性两边界及实际 Java8 发现。旧恢复要求 F ∧ B ∧ M；新复验前置要求 F ∧ D ∧ B ∧ M，B 必须由新产物 Result 实际完整证明，不用 D 代替。令 V 为原 G-INTEGRATION 的全量同版/fresh/全部案例/根入口/证据一致性合同，H 为首轮153映射和全部历史保留，新 G-RECOVERY-INTEGRATION 必须实际满足 **V ∧ F ∧ D ∧ B ∧ M ∧ H**。旧 V、B 的全部验收强度保持，新关系不声明旧 gate 满足；若发现任何旧义务无法等价保留，停止并报告，不能豁免。

Plan 当前完成连接为原 G-REPAIRS 关联、G-BASIC-RECOVERY 加独立 Mixin/remapped 前置、G-RECOVERY-INTEGRATION、G-ACCEPTANCE；历史 G-INTEGRATION/G-RECOVERY 不作为待改写对象。上述范围/谓词/依赖/conflict/gate 连接是材料性变更，供不同 Handler 独立复审，Router 判断 Disclosure/确认与实际放行。每个 gate 等待所属全部 item，仅对显式后继生效，不是自动调度；作者维护、自检、有利 review 或用户确认都不等于实际 item completed/gate 释放。

最新局部纠正只细化发现项的实际 compiler 来源/提前失败未完成规则、各自 invocation 的共享属性观察及第9款/独立验收消费，并采用 Router 对原 basic caller 授权的澄清；图成员和等待关系不变。实际作者检查见 [Plan](plan.md#basic-三项复审阻断纠正作者自检)，三阻断及历史 not-ready 见 [Context](context.md#basic-三项复审阻断的局部纠正)。本次未推进任何 item/gate。

#### partial 后的现行连接与旧 gate 保留

以下为此前单次重试准备的连接历史，实际该Result现为partial，不能再要求它转成功；本轮仅用下节取代其后继等待，旧item/Wave成员/gate完整合同不变。

以上为此前发现/产物首次拆分及三项复审纠正时的连接记录，以当时阶段为限；本次 C5 仅以下现行连接取代其中对旧发现 completed 和 G-BASIC-RECOVERY 的后继等待，旧 item、Wave 成员、gate 完整合同及不满足历史本身不变。

- 原 W-BASIC-RECOVERY 仍列 RECOVER-BASIC-JAVA8、RECOVER-BASIC-ARTIFACTS，其 G-BASIC-RECOVERY 原“两份完整 Result 均 completed”合同逐字保留；原发现 partial 使该 gate 不满足，新重试成功不能自动释放它。G-INTEGRATION/G-RECOVERY 的旧失败/不满足同样保留。
- 新重试唯一归属 W-BASIC-JAVA8-RETRY，只等待 G-REPAIRS；新 G-BASIC-JAVA8-RETRY 只等待本重试的完整独立 Result 和全证据，不依赖旧 partial/旧 G-BASIC-RECOVERY、产物项或自己释放。原 partial 的成功接线是已采用且须核对新鲜度的输入，不是旧 item 已 completed。
- RECOVER-BASIC-ARTIFACTS 保留在原 W-BASIC-RECOVERY，Wave 前置仍只有 G-REPAIRS，item 前置替换为新重试的 completed/足证据；不等待所属 Wave 自己 gate 或旧发现转成功。它仍须自己的完整 B，不以重试运行偶然产物或 D 代替。
- VERIFY-RECOVERY 保留原三修复、Mixin、basic 产物和 remapped 的显式 completed/足证据前置，只把旧发现成功依赖替换为新重试；所在 W-REVERIFY 改等 G-REPAIRS 和 G-BASIC-JAVA8-RETRY，不再等永远不由新结果回填的 G-BASIC-RECOVERY。不能只凭新重试 gate 跳过显式产物/Mixin/remapped。REVIEW-ACCEPTANCE 对应消费新重试及原 partial/成功接线，仍等完整实际 G-RECOVERY-INTEGRATION；不同 Handler 和 G-ACCEPTANCE 原要求不变。

等效性：沿用上文 F/B/M/V/H，令 W 为原 partial 中已完成、当前核对仍成立的两处接线，D_retry 为一次新原入口取得的完整同轮发现证据（含 Provider→Test→args→nested 属性/StartParameter/effective installations、现有 action 实际 compiler 两行及共享语义）。本次发现义务为 **D = W ∧ D_retry**，不把旧14条观察补进 D_retry，也不把原 item 视为 completed。现行最终前置仍为 **F ∧ D ∧ B ∧ M**，新 G-RECOVERY-INTEGRATION 仍须 **V ∧ F ∧ D ∧ B ∧ M ∧ H**；原来源/namespace/provider/Java8/产物、全部同版 fresh/Forge三类/根入口/独立验收不减少。原历史 gate 不被该等效论证宣布满足。

联合等待检查须覆盖所有 item 前置、所在 Wave 前置 gate、每个 gate 对全部成员的等待；保留旧不满足 gate 但移除它们对新路线的成功等待，不能出现跨 item/Wave 环或自等。资源冲突保持串行，不从展示顺序制造 basic/remapped 成功依赖。本次仅维护、未执行任何重试/产物项或 gate；独立复审所需受影响边界和实际作者检查见 [Plan](plan.md#basic-java8-独立重试图维护作者自检)。

#### 有限网络重试的现行连接与旧 gate 保留

本节保留为有限批次执行前的连接历史；该批次现failed，当前后继由下节“观测失败后的独立恢复连接与旧gate保留”取代。原记录：本节是当前连接解释，取代上节对旧单次重试成功的等待。原W-BASIC-RECOVERY/G-BASIC-RECOVERY及旧W-BASIC-JAVA8-RETRY/G-BASIC-JAVA8-RETRY成员、完整谓词与因partial不满足均保留；G-INTEGRATION/G-RECOVERY旧失败不满足不变，新成功不得回填或自动释放。

- 新有限重试唯一归属W-BASIC-JAVA8-BOUNDED-RETRY，只等G-REPAIRS；新gate只等待本新item完整Result与足证据，不等旧partial/gate、产物、remapped或自身释放。原接线只是当前须核对的已采用输入。
- RECOVER-BASIC-ARTIFACTS仍归W-BASIC-RECOVERY，该Wave仍只等G-REPAIRS；item改消费新有限重试completed/足证据，不等自己的G-BASIC-RECOVERY或旧partial转成功。它仍独立证明完整B，不用D或偶然产物代替。
- VERIFY-RECOVERY所在W-REVERIFY改等G-REPAIRS及G-BASIC-JAVA8-BOUNDED-RETRY，同时显式原三修复、Mixin、新有限发现、完整basic产物与独立remapped均须完整采用/completed/足证据。REVIEW-ACCEPTANCE仍经实际G-RECOVERY-INTEGRATION并读取上述结果与两次partial，不同Handler和G-ACCEPTANCE原要求不变。
- remapped只等G-REPAIRS，没有等待basic或新发现成功的业务前置；共享运行/输入写入排他只是冲突，不构成成功依赖。

等效性沿用F/B/M/V/H：W为原已完成且当前对应仍成立的接线，D_bounded为本新批次某次完整同轮证据及共享语义（保留外层Provider观测能力限制），D = W ∧ D_bounded。最多3次/总30分钟是一个D的内部取证，各失败attempt无独立消费者且必须完整保全，不能跨轮拼接。最终前置仍F ∧ D ∧ B ∧ M，新G-RECOVERY-INTEGRATION仍V ∧ F ∧ D ∧ B ∧ M ∧ H；来源/namespace/provider/实际Java8/产物、同版三模块fresh/Forge三类/根入口/不同Handler独立验收不减少。

本次只维护四文档，无新运行/实现/独立复审、item完成或gate释放；联合item/Wave/gate检查与受影响局部复审边界见[Plan](plan.md#basic-java8-有限网络重试维护作者自检)。

#### 观测失败后的独立恢复连接与旧 gate 保留

以下为上一地址恢复准备的连接历史；RECOVER-BASIC-JAVA8-RECOVERY现failed，该item/原Wave/gate完整保留但本节不再是当前等待。唯一现行连接由下节真实token恢复取代，旧成功等待不得复活。

本节为唯一现行连接解释，不改旧item完整谓词或Wave/gate成员/合同：原有限RECOVER-BASIC-JAVA8-BOUNDED-RETRY failed、两次发现partial、basic blocked、首次组合failed及其不满足gate永久保留，不续旧窗口、不用新成功回填。

- 新RECOVER-BASIC-JAVA8-RECOVERY唯一归属W-BASIC-JAVA8-RECOVERY，只等G-REPAIRS；新gate只等本item完整Result及足证据。已采用诊断是加工输入，没有新造诊断报告/独立工具Result前置；临时链纠正/离线检查均在同一个发现内部，没有独立消费者。旧failed/partial/gate、产物、remapped或本gate自身均不成为新恢复成功前置。
- RECOVER-BASIC-ARTIFACTS仍归原W-BASIC-RECOVERY（只等G-REPAIRS），item前置改消费新独立发现的completed/足证据；不等自己的G-BASIC-RECOVERY或旧failed/partial转成功。原完整来源/namespace/provider/Java8/patched/consumer/compileJava/jar/printCompileClasspath的B不变。
- VERIFY-RECOVERY所在W-REVERIFY改等G-REPAIRS及G-BASIC-JAVA8-RECOVERY，同时保留原三修复、Mixin、新独立发现、basic完整产物、remapped各项显式completed/足证据。REVIEW-ACCEPTANCE仍等实际G-RECOVERY-INTEGRATION并显式消费新恢复与原failed/两partial及限制；三模块fresh、Forge三类、根入口、全部当前案例及不同Handler标准不变。remapped仍只等G-REPAIRS，共享构建/输入排他不形成basic成功依赖。

沿用F/B/M/V/H，W为原成功接线的当前对应，D_recovery为新批次某一次全部同轮发现及共享语义（保留Provider观测限制），D = W ∧ D_recovery。必要临时控制链修正/离线检查与最多3次/总30分钟均无独立终态或消费者，仅服务D；旧证据或另一attempt不得补本次缺证。最终前置仍F ∧ D ∧ B ∧ M，最终gate仍V ∧ F ∧ D ∧ B ∧ M ∧ H；新的显式连接不证明任何实际item完成或gate满足。

本轮只维护四文档并作者自检；未修工具、离线/真实执行或独立复审。不同Handler局部复审应覆盖failed/时间/诊断采用、原发现合同与内部工具分组、新预算/再试/停止/身份边界、旧gate保留、新依赖/后继及联合等待/排他。实际作者检查见[Plan](plan.md#有限发现失败后的恢复图维护作者自检)。

#### 真实 token 失败后的现行连接与旧 gate 保留

**历史连接，非当前等待。** TOKEN-RECOVERY现已partial，此节旧item/Wave/gate完整合同及不满足保留，不续预算、不回填成功；当前由下节NORMAL-RETRY连接取代，下文“唯一现行”只指当时。

本节是唯一现行连接解释。RECOVER-BASIC-JAVA8-RECOVERY generation 1 failed与W-BASIC-JAVA8-RECOVERY / G-BASIC-JAVA8-RECOVERY原成员/谓词/合同及不满足状态、旧独立新批次预算完整保留；更早有限failed、两partial/basic blocked/首轮153/150/3/0和所有旧gate不满足均不改判。晚到退出/idle和新成功不回填、不续预算。

- 新RECOVER-BASIC-JAVA8-TOKEN-RECOVERY唯一归属W-BASIC-JAVA8-TOKEN-RECOVERY，只等已采用G-REPAIRS；新gate只等本item的completed完整Result与足证据。真实未预处理快照/身份交接回归和临时纠正只有该发现一个消费者，无独立工具终态/Result；诊断completed不是工具已修好或发现已完成，不造诊断报告副本前置。旧failed/partial/gate、产物、remapped或本gate释放均不是本item成功前置。
- RECOVER-BASIC-ARTIFACTS仍在原W-BASIC-RECOVERY（只等G-REPAIRS），item前置仅改消费新token发现completed/足证据；不等自己的G-BASIC-RECOVERY或旧RECOVERY/partial转成功。B的来源/namespace/provider/实际Java8/patched/原consumer/compileJava/jar/printCompileClasspath完整合同不变，D和偶然产物不能替代B；旧G-BASIC-RECOVERY因原partial仍不满足。
- VERIFY-RECOVERY所在W-REVERIFY改等G-REPAIRS与G-BASIC-JAVA8-TOKEN-RECOVERY，显式仍等待原三修复、Mixin、新token发现、完整basic产物和独立remapped各自completed/足证据。REVIEW-ACCEPTANCE仍由不同于实施/复验者的Handler消费全部实际Result、新发现及RECOVERY failed/旧failed/两partial/blocked/首轮失败与限制，等待实际G-RECOVERY-INTEGRATION；G-ACCEPTANCE原要求不变。remapped仍只等G-REPAIRS，无basic成功依赖；共享文件/运行排他是冲突，不是成功前置。

沿用F/B/M/V/H，W为原成功接线的当前对应，D_token为本新批次某一次原方法全部同轮发现和共享语义（Provider直接观察限制不提升），D = W ∧ D_token。最小token/身份交接纠正、真实快照离线回归与最多3次/一个30分钟deadline只有支持D的价值，不能跨轮补证。最终前置仍F ∧ D ∧ B ∧ M，最终gate仍V ∧ F ∧ D ∧ B ∧ M ∧ H；原完整B/独立remapped、首轮153加当前全部案例/三模块fresh/Forge三类/根入口/同版内容/不同Handler验收不减。旧item/Wave/gate全部留图，联合等待不得环/自等；旧failed不得成为新路线必须先成功的前置。

本轮仅四文档维护与作者自检，不修工具/执行离线或真实调用、不调度后继、不宣称ready、实施确认、item完成或gate释放。最新局部维护只细化同一token恢复item的内部实施顺序、逐轮副作用分类及retry消费/拒绝，不增改item/Wave成员/依赖；旧历史和最终合取不变。精确受影响局部独立复审边界和实际检查见[Plan](plan.md#副作用再试判据局部维护作者自检)，前一作者记录继续保留。

#### 正常网络重试的现行连接与旧 gate 保留

**历史连接，NORMAL-RETRY 已 failed。** 不再是 B/V/H 必须先成功的前置；原 item/Wave/gate/完整谓词及不满足保留，新 patch 后 D 不回填它。

本节唯一拥有当前连接解释，取代旧token成功等待；旧TOKEN-RECOVERY partial、原W-BASIC-JAVA8-TOKEN-RECOVERY成员及G-BASIC-JAVA8-TOKEN-RECOVERY完整谓词/不满足保留，旧not-ready和更早partial/failed/blocked不改判。已完成token/身份/观察及131/131离线只是输入，不是发现完成；取消DNS诊断无Result、不计completed，不造新审批或诊断gate。

- RECOVER-BASIC-JAVA8-NORMAL-RETRY唯一归属W-BASIC-JAVA8-NORMAL-RETRY，只等已采用G-REPAIRS；新G-BASIC-JAVA8-NORMAL-RETRY只等本项完整completed Result及原D足证据，不等旧token/partial/failed/gate、产物、remapped或自己gate释放。普通缓存分类与包装白名单不再是前置，基本身份/退出/排他/单一预算及原同轮成功合同保留。
- RECOVER-BASIC-ARTIFACTS仍归原W-BASIC-RECOVERY（Wave只等G-REPAIRS），item只改消费NORMAL-RETRY完整发现completed/足证据，不等自己的G-BASIC-RECOVERY或旧token转成功；原完整B和调用/写权限不变，D及偶然产物不能替代B。
- VERIFY-RECOVERY仍显式等原三修复、Mixin、NORMAL-RETRY、完整basic产物及独立remapped各自completed/足证据，所在W-REVERIFY只改等G-REPAIRS与G-BASIC-JAVA8-NORMAL-RETRY。REVIEW-ACCEPTANCE仍等实际G-RECOVERY-INTEGRATION，由不同于实施/复验者的Handler读取新Result、token partial/工具效果及全部旧历史/限制；最终G-ACCEPTANCE不减。remapped仅等G-REPAIRS，无basic成功依赖，全部共享文件/运行仍串行排他。

沿用F/B/M/V/H，W为已完成接线当前对应，D_normal为新批次某一次原basic完整同轮发现及共享语义（Provider直接观察限制不升级），D = W ∧ D_normal。最多3次/首次实际调用起单一1800秒只服务D，不能跨轮补证；最终前置仍F ∧ D ∧ B ∧ M，最终gate仍V ∧ F ∧ D ∧ B ∧ M ∧ H。正常保留Gradle/TestKit缓存与按实际异常链再试只改变临时运行条件，不减少B/M、首轮153加全部当前案例、同版三模块fresh/Forge三类/根入口及独立验收合同，不释放任何旧gate。

本次仅四文档维护及作者自检，不实现/运行/调度或声明ready。必要联合item/Wave/gate等待与排他检查、不同Handler最小局部复审范围见[Plan](plan.md#正常网络重试局部维护作者自检)；不要求重开不变权威、整份旧历史或普通缓存逐项调查。

#### overlay 未完验证的现行连接

现行成功连接见[P-v6例外下的证据采用连接](#p-v6-例外下的证据采用连接)：已采用P-n-v源码Result/源码gate→P-v6-a自己的独立足证据Result/新gate→8消费者。原P-v6 partial与旧gate未释放保留，不等它们改成功；本作者未执行新item、独立复审或放行。

**前轮P-n partial后的恢复连接历史。** 以下原‘当前/现行/0次’及P-v6完成等待仅限原准备时点，保留前轮图决策/作者记录，不覆盖上方新连接；P-v5及更早历史继续保留。

**当前完整P仍简称P-v6，源码未完验证由P-n-v恢复。** P-n generation1 partial/两owner/version10及原item/Result/gate保留，不续原批次、不回填成功。新RECOVER-FORGE-GAME-RENAME-INHERITANCE-VALIDATION一个Handler/独立Result、单成员W-FORGE-GAME-RENAME-INHERITANCE-VALIDATION/G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION只消费保留源码与适用证据，补原编译/四引用正负例/参数对应；原P-n全部源码/优先级/payload/version10输入/Core路径标准仍需足证据，不以仅编译或flag代证，不重做有效reference纠正。唯一图在本文件，策略归Plan。

现行成功等待为T-basic-v3→P-n-v→P-v6，gate依次G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION→G-FORGE-GAME-RENAME-INHERITANCE-VALIDATION→G-FORGE-REBUILT-CONTENT。T-basic-v3已completed/其gate已采用释放；P-n-v只等它，不等原P-n partial/G-FORGE-GAME-RENAME-INHERITANCE、旧failed/partial/gate、自身或后继。P-v6完整采用恢复Result及新gate，仍自行闭合当前源码→新实际classes/code source/runtimeClasspath/输入/tool/JVM及10真实miss-rebuild-fresh全量oracle-same-path hit-再次全量oracle。原源码gate合同保留但不作现行成功祖先，恢复CLI/旧9-fresh不代完整P；本次无实际完成或放行。

Q-1165/Q-Neo、R、D、B、M、V、H共8个直接完整P消费者仍仅指向VERIFY-FORGE-REBUILT-CONTENT；两Q各等本组T，R等三T/P-v6/两Q仅阻V/H，D不等Q/Neo/R，B另等D，M另等Q-1165不等D/B/Neo/R。V/H必要源码成功输入由原P-n换为P-n-v，仍汇合12个必需独立恢复Result（Mixin/三T/P-n-v/P-v6/两Q/R/D/B/M）及原三修复、最终fresh/根入口与原P-n partial历史。最终第1/10款只作该必要连接，第2–9款不改；Q/R各自分支内容/缓存、Java21与共享串行边界不变，源码恢复不直接放行完整P。

正常网络全链已消费0/最多3次（含P-v6 hit）；每次构建/CLI前即时复核共享源码/编译/Gradle home/cache/TestKit/fixture/build/input写运行排他，历史idle不是锁、原冲突不倒推抹除。无统一分钟/双时钟/上界或替代预算；真实内容/身份/退出unknown/冲突停止及窄编写类型纠错保留失败不减。沿用已确认范围/authority，不重求许可。作者只维护四文档，不执行、派发复审/调度/推进Todo或宣称ready；局部边界和自检见[Plan](plan.md#p-n未完验证恢复图作者自检)，原策略/作者记录限各自历史时点。

**P-v5及旧连接历史（非现行消费前置）。** P-v5 generation1 failed及已有效reference/正负例、4778一致/四差异、1466.68秒/无Gradle/hit/加载闭合见[Context](context.md#p-v5-失败采用与游戏rename恢复边界)。旧P-v至P-v5、原两partial/全部原谓词/单成员Wave/gate保持，不因新成功回填或释放；旧只读生产/不cold合同仅限旧item。下列保留P-v5准备时点原连接/作者自检，不覆盖现行图：

T-basic-v3 completed/已释放gate＋原P/P-recovery两partial可核验保留效果→P-v5；P-v5完整独立Result completed/足证据且完整采用→G-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY→完整P消费者。新item `RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY`唯一归属同名W-单成员Wave，只等T-basic-v3 item与G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION；不等旧failed/partial/gate转成功、自身gate或后继。新gate只等本成员全部完整证据，不因reference/样本/工具检查通过提前释放。

P-v4 g1 failed与原完整item/Wave/gate不满足保留：325真实差异、两reference根因、无Gradle/hit/加载路径闭合、双时钟1123.852秒含保存/余676.148及schema/GBK纠错、部分LSP inconclusive/Inspect时间粒度/原miss采样限制不消失；P-v3及更早failed/unknown、两partial、旧预算/停止合同均不重开/不回填。旧ready只支持未变策略，不代本次新差异独立复审。

- Q-1165=T-1165∧P-v5；Q-Neo=T-Neo∧P-v5，各本组内容/实际路径/冷热独立；不将Neo/Java21前移到P-v5/共享配置。
- D=P-v5∧原成功接线∧新原入口同轮完整Java8发现；B=P-v5∧D∧完整basic；M=P-v5∧Q-1165∧自身迁移/完整remapped。R不阻D/B/M，M不等D/B，共享写运行仍串行。
- R=T-basic-v3∧T-1165∧T-Neo∧P-v5∧Q-1165∧Q-Neo∧原完整真实回归；V/H仍合取全部T/P-v5/Q/R/D/B/M/F/Hist，所有当前案例/三模块fresh/Forge三类/根入口/不同Handler验收不减。
- P-v5的游戏声明闭包、原有效内嵌映射、两真实锚点与正负例只服务完整P内容/cache；全量4782、当前身份/原fresh-miss/预检录制/父集目录/7-8-9完整路径/同path hit与再次oracle仍全需。不改version9/公共工程，不重做cold或生产反推golden。新语义范围不冒充旧窄例外；方法事前加载、首相关检查前双时钟单1800秒至最终保存/保存余量/有限网络/真实退出/真实内容或字段/身份/冲突/退出unknown/到限停止全部保持。详见[Plan](plan.md#p-v5-独立reference语义恢复与作者自检)。

本次仅补完已有撤销入口之后的四文档正文/item/gate/链接及作者自检，不实施、独立复审、派发、调度、推进Todo、完成实际item或释放gate。P1/P2 not-ready及取数链/阶段unknown保持历史，不再作当前预算前置，也不称技术修好；不重求已确认范围或已撤销起点许可。受影响边界仅政策撤销、两item各自Result/gate、8消费者/最终第10款必要连接和历史分界；全部item/Wave/gate身份、唯一归属、前置边、共享构建串行及完整验收保留。实际修改/回读/链接及必要连接核对见[分钟预算撤销与作者自检](plan.md#分钟预算撤销与作者自检)，此前[预算修订作者记录](plan.md#预算复审修订作者自检)和[缓存纠正作者记录](plan.md#缓存策略源码对齐作者自检)均按当时保留。

#### P partial 后的完整结果恢复连接

**前轮连接历史，P-recovery现为partial。** 以下待完成连接由上节P-v取代，原执行谓词与gate不满足保留，不能继续授权生产修改。

唯一新连接：已采用T-basic-v3 completed/其gate（Router已释放）＋原P partial保留效果→P-recovery；P-recovery completed/足证据→G-FORGE-PATCH-OVERLAY-CONTENT→Q-1165/Q-Neo/R/D及实际完整P消费者。原FIX-FORGE-PATCH-NAMESPACE、W-FORGE-PATCH-NAMESPACE、G-FORGE-PATCH-NAMESPACE的原完整合同及partial/不满足保留，新gate不回填。内部renamer能力检查/验证接线/语义键/内容与cache共同服务一个恢复终态，没有独立工具/attempt Result。

- Q-1165 = T-1165 ∧ P-recovery；Q-Neo = T-Neo ∧ P-recovery，各只等本组，不把Java21前置回移到P-recovery或共享配置。
- D = P-recovery ∧ 成功接线 ∧ 新原入口同轮Java8发现；B = P-recovery ∧ D ∧ 完整basic；M = P-recovery ∧ Q-1165 ∧ 自身迁移/完整remapped。R不阻D/B/M，M不依D/B。
- R = T-basic-v3 ∧ T-1165 ∧ T-Neo ∧ P-recovery ∧ Q-1165 ∧ Q-Neo ∧ 完整独立真实回归；V/H仍汇合上述全部、D/B/M、F（原修复/Mixin）及Hist（原P partial、T-basic-v3已完成/首轮DNS、四个准备failed及全部历史unknown/旧gate不满足和更早限制）。R是V/H必需质量门槛，最终fresh/根入口及不同Handler验收不减。
- P-recovery只证basic全内容/新语义缓存和两族静态使用，不以non-notch/Neo实跑为共同门槛；三组实际有效路径/cache由P-recovery/Q合取提供，未证不称全部共享实现通过。共享内容再写须复核/重取受影响证据，所有共享构建串行。

#### Forge 补丁恢复的现行连接与旧 gate 保留

**历史：原P开始前的现行连接。** 以下T-basic-v3“待准备”、原P“待生产”和直接消费原P/gate限当时；当前采用/新恢复/消费者以上节及现行item/Wave表为准，旧谓词和最终全量不减。

本节解释上方唯一图。S 未执行即撤出，不标 completed/不生成 Result/不恢复备份。原聚合 PREPARE-FORGE-PATCH-FIXTURE 及 W/G-FORGE-PATCH-FIXTURE 尚无运行结果，此次按可消费结果替代为三组 T，不伪造旧 T completed；旧定义/当时共同等待只见 Plan 历史自检，不再拥有当前 gate。所有既有 failed/partial/blocked/not-ready、首轮153/150/3/0、旧 item/Wave/gate 完整合同及不满足保留，新成功不回填旧 gate。 旧 PREPARE-FORGE-PATCH-BASIC generation1 failed/原合同及 W/G-FORGE-PATCH-FIXTURE-BASIC 未满足保留；原独立T-basic-r也已failed，其原完整合同/旧gate未满足保留；旧T-basic-v也已failed且历史实际调用/启动/退出unknown，原合同及其gate不满足保持；旧T-basic-v2也已generation1 failed，实际1次/内部WaitForExit=false/脚本124而非Gradle码/真实Gradle退出及后代结束原因unknown，其原完整合同与gate不满足保留；现行basic准备仅由新RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（T-basic-v3）重跑未完完整验证，复用两文件修改/LZMA，不重做实现、不续旧批次或等旧失败先转成功。资源范围与适用性消费Plan；新执行采用同一terminal前台同步生命周期/真实timeout扣出收束保存余量，terminal_wait不重启，硬中断不伪造Gradle码、未知即停，详见[Plan](plan.md#basic-控制提前退出后的同-terminal-前台验证)；诊断完成不代准备完成。

- 三组现行准备 T-basic-v3/T-1165/T-Neo 各只等 G-REPAIRS，各提供自己的固定真实输入/provider/隔离/官方参考/见证/JVM/精确方法运行结果，不在共享配置/BeforeAll 强求另一样本/Java21；完整 fixture 类/三组覆盖由 R/V 保留。不是同一个 partial Result 的参数提前放行。
- P 只等 T-basic-v3/item 与 G-FORGE-PATCH-FIXTURE-BASIC-FOREGROUND-VALIDATION/Wave，统一写原两个生产边界/版本，但以 basic 全内容/forge 实际路径隔离/冷热缓存的完整结果完成。P 的静态两族版本检查不冒充 Neo 实证，三组缓存/两族运行不再聚合到 P。Q-1165 只等 T-1165/P 及对应两个 gate；Q-Neo 只等 T-Neo/P 及对应两个 gate，各有完整内容/本组路径/缓存的独立 Result，Q-Neo 另证收窄后处理；Q 不写生产、不互等/不等消费者。
- D 只等 P 与 G-REPAIRS/G-FORGE-PATCH-NAMESPACE、既有 basic 接线；B 在原 W-BASIC-RECOVERY（只等 G-REPAIRS）消费 P/D，不等自己旧 gate、Neo/Q/R。M 在原 W-RECOVERY（只等 G-REPAIRS）消费 P/Q-1165 及自身迁移，不等 Neo/R/D/B/自己的旧 gate。旧 G-BASIC-RECOVERY 仍因原 partial、旧 G-RECOVERY 仍因原 basic blocked 不满足；新结果不自动释放它们。
- R 显式全等三组现行准备 T-basic-v3/T-1165/T-Neo/P/Q，所在 Wave 等 P/Q-1165/Q-Neo 的三个 gate；R 执行完整四矩阵、三组冷热缓存/全部新 fixture 类及真实 AT/JarJar，为 V/H 必需质量门槛，不给 D/B/M 偷加前置。V 显式消费原三修复/Mixin、三组 T/P/Q/R/D/B/M，Wave 仍等 G-REPAIRS/G-FORGE-PATCH-REGRESSION/G-BASIC-JAVA8-POSTPATCH；最终合取为全量同版 fresh/全部当前案例/根入口合同 ∧ T-basic-v3 ∧ T-1165 ∧ T-Neo ∧ P ∧ Q-1165 ∧ Q-Neo ∧ R ∧ F ∧ D ∧ B ∧ M ∧ Hist（含旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及T-basic-v历史调用/启动/退出unknown、T-basic-v2真实Gradle退出/后代结束原因unknown、未满足原合同/gate及本次适用性损失）。第2–9款原完整合同不减，两个 operation 族实际有效路径与每组缓存最终全需。
- H 仍由不同于实施/复验者的 Handler 完整消费上述各实际 Result/最终证据与全部历史，等待实际 G-RECOVERY-INTEGRATION，明确接受/不接受；作者自检/评估 completed 不代 G-ACCEPTANCE。所有证据绑定真实源码/fixture/输入身份，后续共享写漂移必须重核受影响证据，不能把旧 P 或一组成功推广成新内容/全 Neo 成功。

### 缺所需 JDK：分支错误、独立继续与最终等待

按 Plan 保存准确版本/要求及选择来源、解析结果/异常、task/工具/方法/参数/实际 JVM 与未到达边界；unknown 明示。缺所需 JDK 未能启动为 blocked，已调用失败为 failed；受影响 item/gate 不满足，不 silent skip/partial 当成功，不用另组参数补证。

关键反例：只有21不可用而8/17条件充分，T-Neo blocked/failed，Q-Neo 等待，R/V/H 最终门槛仍未满足；已采用T-basic-v3/原P/P-recovery保留效果→P-v→D→B 与 T-1165/P-v→Q-1165→M 按各自完整实际前置可串行推进，不以 Neo/聚合 T gate/完整 fixture 类/P-v 全组缓存及两族实际路径全齐再阻 Java8 路线。此为依赖可达检查，不宣称运行或成功。D 缺8阻 B，M 依据自身8条件判断；Q-1165 不满足则 M 等待但不取消 D/B。未证 Neo 的共享实现不称全验证。

无依赖无冲突且工具允许的其它工作不终止/取消，全部共享 Forge/fixture/helper/Gradle/TestKit/build/cache 写运行仍串行。fail-fast 或工具契约无法继续则保存已失败/未执行集合和能力限制，不虚构并行、自动恢复/新委派协议；Router 依据真实契约判断实际执行，本次不调度。不安装/换版/改 consumer/runner 或扩大私有样本支持。

本次仅四文档维护及作者自检，不运行、不宣称 ready、不完成实际 item/释放 gate。受影响图边界须独立复审，实际检查与范围见[Plan](plan.md#overlay-未完验证维护作者自检)，review-no-baseline-jdk-plan completed / not-ready 及采用边界见[Context](context.md#java21-共同前置复审采用与结果边界)。

## 图作者检查与历史边界

以下为此前校准阶段的保留记录；其中五 item/三 Wave、仅三谓词及未实施文字以当时为限，不覆盖本轮恢复图或已采用执行结果。最新消费者恢复作者自检见 [Plan 本轮记录](plan.md#消费者本轮内层重跑策略与作者自检)；旧overlay自检及以下历史状态不覆盖当前三新边界或原发现g1采用。

现行五个稳定 item 各归属一个非空 Wave，共三 Wave；三修复无相互成功前置，组合只消费三修复及 G-REPAIRS，验收只消费组合及 G-INTEGRATION。排他表保留域/发现的共享文件冲突及所有 Gradle 运行资源冲突，未伪装为成功依赖；联合 item/Wave gate 等待须无环且无自等。

本图与 Plan 三项成功条件及最终组合/独立验收对应，每项有单一谓词、输入、写范围、证据、冲突及失败失效边界。旧 FIX-OUTPUT 无现行定义或成员，不标 completed；专属活动期兼容/身份/释放证据及冲突行已撤出。保留完整模块回归不等于恢复该排除项。

首次独立复审 not-ready 保留；在后续 generation 1 之前仅有输出载体候选修订、Forge fresh 澄清及作者自检，当时没有独立复审、实施、实际 item 完成或 gate 释放。历史四修复/六 item 及未运行局限见 Plan 历史自检和 Context，不作为现行图；Forge 三类及 G-INTEGRATION fresh 义务不变。

范围删减及 G-REPAIRS、VERIFY-COMBINED、REVIEW-ACCEPTANCE、G-ACCEPTANCE 的三谓词收敛是材料性变更，待受影响边界和必要连接的独立复审；作者维护不宣称 ready，不决定确认或调度。历史 partial/failed/blocked、迁移收口和 498 项等价盲区保留；三项成功不自动把全量审查改成 completed，不证明输出竞争已解决或 Cloche 已消费新版本。实际静态核验记录见 Plan 末节及本次 Result。后续 `review-reduced-mixin-repair-plan` generation 1 已由 Router 完整读取并采用：评估 completed、计划 not-ready，唯一阻断为七个不存在回归类及遗漏承载。本次只将 item/组合/gate 接到 Plan 的可定位同一清单，保留分组、依赖、冲突和排除风险；清单与必要连接仍需局部独立复审，不产生实际执行状态。
