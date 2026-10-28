# Mixin 审查修复 Plan

## 已接受的精简R与最终验证策略

匹配[当前Work](work.md#已接受的精简r与最终验证维护)、[已接受决定及复用边界](context.md#精简范围的已接受决定与复用边界)及[唯一Waves连接](waves.md#精简r与最终验证的现行连接)。本次仅同步原四文档的已完成事实并局部回读，不新增实施或运行。此前准备及作者自检已结束，用户随后确认单次兼容运行；`run-at-jarjar-compatibility-once` generation1 completed已由Router可靠采用，item/Wave及限定gate判断见[Context完成记录](context.md#单次atjarjar兼容成功采用与精简交付说明)与唯一Waves。原策略和成功谓词保持，不把准备时点的待确认描述作为当前等待。当前Active PRD、Accepted隔离ADR及Spec行为/真实观察合同按Context的本次局部校正理由reuse，权威写入skip；采用建议中的旧R9/AC10不再冒充现行条款，历史G1与当前新目标验收严格分开。取消全模块fresh不表示产品全验收通过。

### 一个联合运行成果

`VERIFY-FORGE-AT-JARJAR-COMPATIBILITY`（V-compat）已交付并被采用一次现有兼容整类调用的联合结果；以下保留其原执行边界与成功谓词，不先跑独立R再由V重跑，也不把两个方法拆成两次构建或两个Result。唯一任务/selector为 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests`，现成源码见[兼容类](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt)。仅沿既有正常编译及[ForgeInputs](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeInputs.kt)静态fixture依赖；必要编译自然包含唯一outer，不另开编译/版本/help/dry-run/探针。

- `jarJarRemovalDeletesListedPayloadAndMetadataOnly`：真实ForgeJarJarRule在G1前后只删除列举payload及metadata，保留未列举JAR和无关资源。
- `actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload`：真实非空AT CLI的baseline/current访问行为比较、嵌套payload及无关资源保留；真实producer/strip路径保持。
- 两方法必须在同一次当前运行均实际执行，outer真实数值exit0、新鲜JUnit方法身份及tests/failures/errors/skipped=`2/0/0/0`，并关联当前源码/加载内容、命令/日志及现有保留产物。沿用已有`AT_ACCESS_OBSERVATION`、`NESTED_REOPEN`和`build/platform-fixtures/retained-baseline/<method>/`观察，不新增工具或辅助取证。仅编译、UP-TO-DATE/FROM-CACHE/SKIPPED、旧XML、找到旧产物、只一项通过均不足；未执行如实报告，不追加强跑或第二次调用。
- 正常新单worker且方法完整到达的成功路径预计outer1/nested1/prepare0/reference0；nested仅是共享ForgeInputs首次lazy assemble，不是三组T准备。实际计数及未到达必须照实记录，静态预计不作为已发生次数或无条件承诺。缺输入/冲突时不启动，运行失败/缺证/退出unknown即保存实际边界并停止，不在本项修源码、补测试或重复构建。

**已采用运行事实。** [仓内运行报告](../../../build/verify-forge-at-jarjar-compatibility-20261028-g1/report.md)及[实际记录](../../../build/verify-forge-at-jarjar-compatibility-20261028-g1/report.json)记录UTC 2026-10-28 11:14:06.5643507–11:14:37.1679023，精确整类selector加 `--rerun` 的唯一outer真实exit0，实际outer1/nested1/prepare0/reference0、新鲜两方法JUnit2/0/0/0，AT_ACCESS_OBSERVATION/NESTED_REOPEN及JarJar断言通过。编译任务UP-TO-DATE；nested静态assemble正常返回但数值exit为null；outer offline、nested未强制offline，标准同名保留产物可覆盖。此前预计现在有该次实际记录支持，不变成重复运行授权。Router已判断唯一兼容item完成及其限定gate满足；不释放原完整R/V/H或产品全验收。

### 取消重复执行与保留原验收边界

已接受的精简R复用P及各组既有内容/缓存证明，取消本轮新增ForgePatchNamespaceTests四方法/参数、三组冷热、完整准备fixture类、prepare/reference及重新构造golden；仅保留上节兼容观察。已接受的精简最终验证取消本轮三模块无过滤clean/test、裸`test`、`:test`聚合、根接线重跑、17次代理探针及basic/remapped消费者重跑；不以宽任务顺带恢复这些义务，不开启Neo opt-in Q或新增统一套件/工具。root/bootstrap限定检查、有限三模式、P/Q、remapped等已采用结果只在原适用范围引用，不重建采用史；1165历史Router采用关联未闭合只作为限制，不另设审计前置。

原完整R、VERIFY-RECOVERY/V、REVIEW-ACCEPTANCE/H均未通过，其Wave/gate原合同、旧失败和未完成事实仍保留，下方原矩阵/全模块清单与等待均只承载原完整合同，不再是本轮执行安排。新兼容item及其Wave不等待旧R、原V/H、完整代理gate或完整1165采用连接；这些不是兼容类的技术输入。直接消费者和唯一归属见Waves：原R没有等待新V-compat的反向边，新V-compat也不等原R，已采用D/B/M不因质量回归安排重新等待或重跑。本次精简收尾只记录该已采用联合结果及适用旧证据并披露限制，不据此满足G-FORGE-PATCH-REGRESSION、G-RECOVERY-INTEGRATION或G-ACCEPTANCE。

### 本次作者局部自检

**以下为运行前准备的作者自检历史。** 后续单次运行及Router采用已记录于上文；本次仅局部回读文字、链接与范围，不新增独立复核或验收链。

已局部回读四文档当前块及原R/V/H直接连接：精确selector、两方法同次联合谓词、新鲜成功证据、唯一item/Wave归属、item与Wave前置均为空的合取、共享写串行、直接消费者和无旧R循环一致。当前兼容类/ForgeInputs源码链接及本节新增仓内证据实际存在；新增持久范围不含仓外Result路径。回读中已合并Work重复当前节、区分静态预计/实际计数，并校正旧R9/AC10与当前权威版本；原P-v6 partial/例外、1165采用关联缺口、旧失败及原完整验收未通过均保留。

自检只限上述本次变更与必要连接，不重做历史证据审计或运行验证，不是独立复核。精确位置与实际检查由本次维护Result给出；本Handler未改代码/配置、未调用构建/测试/编译/网络/进程操作。该准备时点的文档维护completed本身不证明计划独立ready、兼容执行通过、实施确认或旧gate放行；后续用户运行确认及已采用兼容成功以上文为准，不再待运行。

**下文Q恢复策略保留准备时点；限定actionFingerprint源码和Q-Neo g1均已采用completed，最新事实见[Context](context.md#精简范围的已接受决定与复用边界)，不重复实施或运行。**

## Q-Neo lambda插桩归一化后的接续策略

匹配[Work](work.md#q-neo-lambda插桩比较的限定恢复维护)、[Context](context.md#q-neo-lambda插桩差异与本轮失败采用)和[唯一 Waves](waves.md#q-neo-lambda插桩比较失败后的恢复连接)。本次 C5 只维护已接受方向的必要恢复连接及作者自检，不实施或运行。已采用权威评估 PRD/ADR/Spec 均 reuse；此为测试身份观测纠正，无权威写入。Stream g1 源码 completed 不重做；[后续 Q g1 报告](../../../build/verify-forge-patch-neo-stream-fix-20261028-g1/report.json)已经证明 `compileTestKotlin` 在唯一 outer 内真实通过，但身份断言失败，outer1/nested0/prepare0/reference0、exit1、JUnit `1/1/0/0`。旧内容/冷段当前适用性/hit/新内容未建立；原 blocked/两次 failed、已发生调用和 WIRE/空 Java FIX/T/P/Stream 采用事实全部保留。

### 仅actionFingerprint的严格归一化边界

未来源码交付只改 [ForgePatchNamespaceInputs.kt](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceInputs.kt) 内 Q 方法的局部 `actionFingerprint`（当前285–295行）。其 public `resolve()V` 选择、`SKIP_DEBUG` 和 SHA 指纹路径保留；在这个指纹的指令访问中，以同一标准表示严格对应的 lambda bootstrap 配对：

- 只匹配标准 `java/lang/invoke/LambdaMetafactory` 的 `metafactory` 与 `altMetafactory`，核标准 bootstrap Handle 的 owner、名称、descriptor、静态调用 tag 和 interface 标志；`metafactory` 必须恰为三个参数，`altMetafactory` 必须恰为对应前三项加一个整数 flag `1`，无额外参数或其它 flag。不是按名称或 owner 单独匹配。
- 必须保留并比较前三项 SAM MethodType、实现 Handle、实例化 MethodType；Handle 的目标及其自身属性不改，invokedynamic 的名称/调用 descriptor 和其余指令不改。只消除该 bootstrap 配对及 flag 差异，不把不同实现目标归一、忽略所有 invokedynamic 或 synthetic 内容。
- 未匹配的 bootstrap、参数类型/数量/flag 或其它指令一律照原规则写入比较，不吞异常，不删除或跳过身份断言。`classBytes`、core 身份、source/plugin classpath/输入来源和现有冷段适用性检查不变；源码交付不得扩至其它方法、文件、生产逻辑、operation/version/key、依赖、用户配置或旧证据。
- 此归一化绝不进入最终产物的 `semantic`/class 内容比较；[原完整内容规则](#完整内容断言与冷段适用性)中最终 class 仍仅忽略 debug。相同实现 Handle 不能证明整个方法体或生产链相同，实际实现/输入漂移仍须拒绝冷段复用，不能以指纹纠正替代其它原检查。

该源码成果以只覆盖上述局部函数的精确 diff 和回读为完成证据；逐项核严格匹配、前三项/其它指令/未匹配保留、身份断言与最终比较未减。仅静态交付，尚未编译或运行，不新增单测、编译探针、全链审计、运行时快照或独立验证项；必要编译自然包含在后续原 Q 的唯一 outer。现存诊断缺少运行时字节快照和指纹数值是已知限制，不将补取它们设为门槛。

### 原完整Q的同范围新运行

依赖该源码的第二个未来成果仍是原完整 Q，一个不可拆 JUnit：先验完整旧内容和冷段当前适用性→原 operation10/inputs/key `6d7a8c95`/basename/完整路径真实 action hit→完整新内容。沿用[完整内容与冷段](#完整内容断言与冷段适用性)、[唯一路径/离线/调用](#唯一路径离线供给与调用)和[证据边界](#证据等待与局部自检边界)，不降低 official/无mcinject/定义/引用/优先级/全资源/AT/Dist主属性-marker-有限资源、工具/参考/实际加载/产物关联要求。outer 真实 exit0、当前唯一 XML `1/0/0/0`、nested 真实 BuildResult/TaskOutcome SUCCESS、明确 hit 均必需，不能用编译通过、静态指纹修正、旧成功或 skip 代替。

复用原 prepared/reference、WIRE/空 Java FIX/T/P/Stream。使用最近失败轮的[实际 command](../../../build/verify-forge-patch-neo-stream-fix-20261028-g1/run-1/command.json)和[薄 init](../../../build/verify-forge-patch-neo-stream-fix-20261028-g1/outer.init.gradle)原语义，仅将必要输出及 init 引用重定位到真正全新 Q 根；原 selector、56项顺序与同一确切空 Java 预检/存在分支、原料/路径/离线隔离全部保留。旧运行根和 F 只读，原 operation cache 正常原生 lock 例外不变。新项自身仍 outer≤1/nested≤1/prepare0/reference0，必要编译仅该 outer，不另开 compile/help/探针或重跑成功项。失败/unknown/缺证/身份不适用/冲突/miss 即停保全，不下载或补冷生成，不追加源码修正、prepare/reference 或第二次调用；既往失败调用永久保留，不推导无限重试权。

两个未来独立成果各一个 item/Handler/Result 及唯一 Wave/gate，只由 Waves 拥有；源码经新 Q 消费，R/V/H 与最终合取中的直接 Q 输入改接新 Q，不给 Q-1165/D/B/M 加等待。受影响实施最终需 `G-FORGE-PATCH-NEO-ACTION-FINGERPRINT` 和 `G-FORGE-PATCH-NEO-Q-AFTER-LAMBDA-FIX` 的实际足证据采用，不等待旧 failed gate 变成功。helper/Forge/Gradle/TestKit/build/cache/fixture 的共享写运行串行；不终止无关进程，不恢复历史 daemon、排空或共享 problems 旧字节调查门槛。

### 本次维护的作者自检边界

自检仅核两个未来成果各自单一终态/静态或动态证据、真实前置及冲突、item 与所属 Wave 联合等待、可验证 gate、直接消费者和最终合取继承原完整标准、四文档互链及历史状态保留。实际检查证据由本次 Result 报告，不新增报告文件或第二执行图。独立复核由不同 Handler 后续只读检查本节、Waves 新两项/两行及必要连接；作者不代复核、实施确认或 gate 判断，不把方向接受写成代码完成或 Q 通过，未改范围不重审或重新求批准。本次源码与 Q 均未执行。

**本次作者自检证据。** 已执行37项限定静态检查：当前恰好两个未来 item、各唯一 Wave/gate，Q 的六个前置 item/gate 均有既有或新增定义；item 与 Wave 联合等待一致，无自身/旧失败 gate 等待或反向依赖。新增源码 gate 仅由新 Q 消费，新 Q gate 仅由 R Wave 直接消费，R/V/H 输入及最终第1/10款已接新 Q，其余 Wave 不加等待。四文档当前段的30个链接实际存在可读、页内锚点可解析，仓内报告与当前 failed/编译通过事实一致，helper 仍保留 Stream 修正及原身份断言、归一化尚未实施。另逐项核严格归一化边界、静态/动态 gate、共享写运行串行和原完整 Q 标准衔接；这是作者自检，不是独立复核、实施确认或 gate 释放，未运行项目。

## Q-Neo Stream收集修正后的接续策略

**历史策略记录。** 以下为 Stream 源码交付及其后 Q 之前的准备安排；源码已 completed、唯一 outer 编译通过但 Q 身份断言 failed，当前接续只见页首 lambda 策略，不重复实施或继续派发旧运行。

匹配[Work](work.md#q-neo-编译失败后的最小接续维护)、[Context](context.md#q-neo-编译失败与stream根因采用)和[唯一 Waves](waves.md#q-neo-stream编译失败后的恢复连接)。本次 C5 只维护已定因失败后的必要连接及作者自检，原 PRD/ADR/Spec 评估 reuse、权威写入 skip。下节原空 Java 例外准备按其历史时点保留；该 FIX 源码 completed 与窄预检成功不重做，随后唯一 Q 编译 exit1/outer1/nested0/prepare0/reference0 的 failed 不回填，旧 blocked 同样保留。

后续源码交付仅把 ForgePatchNamespaceInputs.kt 第279行 Files.list(transforms).use 内 Stream 过滤后的末端 .toList() 改为 .iterator().asSequence().toList()。过滤条件、遍历顺序、即时收集、use 关闭及原完整断言/default 保持；不改281/283/299、import、toolchain、依赖或生产。实际一行 diff 与静态回读建立独立源码交付谓词，不能证明编译或 Q 通过；编译留在后续唯一 Q outer，自检不新增测试或探针。

随后原 Q 的 selector、输入、离线供给、路径、执行及成功条件完整沿用下节[完整内容/冷段](#完整内容断言与冷段适用性)、[唯一路径/离线/调用](#唯一路径离线供给与调用)、[证据边界](#证据等待与局部自检边界)。复用 T/P/WIRE/FIX 和原 prepared/reference 产物，不重跑 prepare/reference 或其它成功项。使用[失败轮 command](../../../build/verify-forge-patch-neo-empty-java-20261028-g1/run-1/command.json)及[同轮薄 init](../../../build/verify-forge-patch-neo-empty-java-20261028-g1/outer.init.gradle)的原语义，仅必要输出及 init 引用重定位真正全新 Q 根；旧失败根与 F 只读，原 operation cache 正常原生 lock 例外不变。

旧单次调用已消耗但不构成永久禁令。本次接续 Q 自身仍仅 outer≤1/nested≤1/prepare0/reference0，修正源码编译自然包含在该 outer；实际失败/unknown/缺证即停止，不增加第二次 outer/nested、compile/help/探针、冷生成或下载。完整旧内容及冷段适用性→原 operation10/inputs/key 6d7a8c95/basename/完整路径真实 action hit→完整新内容同属一个不可拆 JUnit；真实 outer exit0、当前 XML 1/0/0/0、nested 实际 BuildResult/TaskOutcome SUCCESS、明确 hit 及原隔离/工具/参考/源码加载关联全部必需，不能用静态修正、编译、旧成功、skip 或假 hit 替代。共享 problems report 旧字节未知仅作为保留限制，不添加追查条件；不恢复排空/历史 daemon 要求。

两个未来结果及各自唯一 Wave/gate、前置和直接消费者只由 Waves 拥有；本接续需新的源码交付 gate 与新的完整 Q gate，不能等待旧 failed gate 变成功，也不自动放行 R/V/H 或完整代理。共享 helper/Forge/Gradle/TestKit/build/cache/fixture 写运行串行；不终止无关进程、不改用户配置/依赖/生产/旧证据或放宽断言。限定独立复核只覆盖本段、Waves 新两项/两 Wave 及必要依赖/消费者，不重审未改原内容、不另增每次编辑确认；实施确认和 gate 判断仍归 Router，本作者不代办。

作者局部自检范围：源码交付与 Q 运行各一个可观测终态/Handler/Result；静态证据与动态完整证据分开；前置及联合 Wave gate 无自等/下游回等；R/V/H 和最终合取接新 Q，Q-1165/D/B/M 不加依赖；互链、原成功条件和旧 failed/blocked/completed 均保留。本次仅检查文档，不执行源码修改、编译、Q、独立复核或实施确认，实际检查结果由本次维护 Result 报告。

## Q-Neo 最小接线策略与作者自检

匹配 [Work](work.md#q-neo-最小接线的待确认准备)、[Context](context.md#t-neo-成功采用与q-neo-准备边界)、[唯一 Waves](waves.md#q-neo-最小接线的待确认连接)，沿用原锚点。本轮仅把用户已接受的确切空 Java 声明输出例外、helper 三处与未来预检的一致纠正及唯一未启动 Q 的接续落入原安排并作者自检；不实施、不运行、不独立 review、不判 ready、不释放 gate。原安排独立 review completed 无阻断、原范围已明确确认；WIRE g1 源码 completed、T-Neo 与 P-v6-a 完整证据判断已采用，Router 曾判断 Q 的三个直接 gate 满足。本次实质变更只待受影响边界独立定点复核和 C6 披露确认，未改范围不重新批准。Q g1 blocked/outer0/nested0/prepare0/reference0 与只读诊断 completed 独立保留；原完整内容、路径、冷热及消费者义务不减。

### 复用事实与原合同边界

采用 [T-Neo g1 报告](../../../build/forge-patch-neo-cpw-mods-20261028-g1/report.md)：本轮外层一次、累计第五次、Gradle exit0、JUnit `1/0/0/0`、prepare/reference 成功、实际 Java21 工具与最终产物齐备。下方 cpw.mods 的“未来一次”等仅属第五次前历史，不重做该修正或重跑。T gate 的采用判断仍由 Router 承担；本作者只记录事实，不把 Q 或其它 gate 写成通过。

以 `F = minecraft-codev-forge/build/forge-patch-neo-925395910390226218`、`S = F/neo121NoMcinject` 标识仓内原料。已采用的 prepare 日志有 `Cache miss for neoforge-patch-10`、key `6d7a8c95`，其最终 output 与原 cache JAR 同 SHA256 `56e71c9547b7961a7da792aafe5075dfb1fd7687b3f4e8502a03f9f1cfcdd525`。这里只是候选冷段：未来先验证它的原完整 Q 内容和当前实现/输入适用性，再允许一次原路径 hit；旧 728 资源相等不能代完整 Q，T 的 prepared 或 exit0 也不能代新运行成功。

原 [固定 Neo 来源与收窄合同](#固定输入与逐分支判定来源)、[Q 完整合同](#关联分支验证-q-的独立完成证据)、[资源阶段合同](#补丁阶段资源范围与固定-basic-空见证适用性)继续适用。“旧 JAR”仅指这次 T 产生的 operation10 候选，不是 P 前旧语义实物。完整检查不恢复旧 attrs 等价、全 class side 分类、raw 资源修复或旧错 key 动态拒绝证明；已知 mapped-client/obf-server 风险及原适用性损失保留。若必须改 Dist/其它生产才能成立，只报告受影响缺口并停止。

PRD [产品输入/隔离/失败](../../prd/codev-mixin-rework.md)、ADR [operation-local 隔离](../../adr/mixin-operation-isolation.md)、Spec [Mixins/loader 边界](../../spec/mixin-preapplication.md)按已披露评估 reuse，权威写入 skip；Q 具体检查仍由本 Plan/Waves 拥有，不改生产语义或再调查三族权威。有相反实证只报告具体覆盖缺口。root/bootstrap/remapped/三模式/编译和 T 的已采用成功按原范围复用，不重跑、不追原通知；完整代理及 R/V/H 未完义务不豁免。

### 三个既有源码接点

以下为已采用 WIRE g1 completed 的三个源码接点；只经静态核对，未编译/实跑。本次保留全部已交付效果，不重做三个接点或将其计作 Q 成功。原首次接线的接口/边界如下，仅 helper 的限定路径解析需要未来纠正，不增加模块、依赖、验证框架或生产 API。

| 接点 | 最小职责与明确接口 | 保留边界 |
| --- | --- | --- |
| [ForgePatchNamespaceFixtureTests.kt](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceFixtureTests.kt) | 已交付 `verifiesPreparedNeo121NoMcinjectWithCacheHit()`，JUnit `@Test` 加 `@EnabledIfSystemProperty(named="fixture.neo.verifyPrepared", matches="true")`。读取必需的 `fixture.neo.preparedRoot=S`、`fixture.neo.evidenceRoot=Q`，调用 helper；入口内一次先验内容→一次 hit→再验完整内容形成一个结果。 | 原三个 prepare 方法、默认行为及其真实覆盖不变；默认不启用 Q，不增加 BeforeAll 或跨样例准备。opt-in 缺失/没命中/skip 不能完成 Q。R/V 原三 prepare 方法仍须实际执行，不能用新增 opt-in 的默认跳过顶替原必需方法。 |
| [ForgePatchNamespaceInputs.kt](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceInputs.kt) | 已交付 `verifyPreparedNeo121NoMcinject(preparedRoot: Path, evidenceRoot: Path): Path`；复用 `fileRows/artifact/names/bytes/semantic/references/definition`。验证 S 的固定输入/官方参考/见证/原冷段，补完整断言；通过后仅建 Q 的私有 reuse 工程并调用一次 GradleRunner，随后对新 final 再验。所有新 JSON/日志写 Q，不调用 `prepare(...)` 或写 F 的见证。 | 不把原 `witnessesNeo121` 的记录误算断言，不改其 T 行为；独立参考只读，不能由 production final 反推期望。完整类定义/引用/资源断言是必要新增测试逻辑，绝非仅参数转发。 |
| [patch-namespace/build.gradle.kts](../../../minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts) | 已交付 opt-in `neoPreparedRoot` 分支，仅在 `patchedNeo121NoMcinject` 配置中，将 `patches/universal/libraries` 绑定 S/prepare/evidence/files.tsv 的已物化文件；复用原 `recordNeo121NoMcinject` 与 output flatMap 的 producer 依赖。输出仍用既有 `fixture.output`，证据仍用 `fixture.evidence`，不另增 `neoResult` 开关。必要 `doFirst` 只重核 operation/输入/key/完整 cache path 存在；不另建生产任务或绕过 task action。 | 无该属性走原 configuration/provider；原 describe/prepare/reference、其它样例、cpw.mods 过滤和依赖坐标不变。reuse 不选择 `describeNeo121NoMcinject`，避免重新解析 tools/sources/metadata；不改变 production 的缓存/生成语义。 |

分组检验：原稳定接线已独立交付，不再待实施。此次 helper 局部纠正同样形成可独立保留、失败与消费的源码结果，与随后单次 Q 运行各一 Handler/Result，不能硬合并；源码修复只作静态核对，不单独编译或新增测试。修复源码必要编译及实际正确性仍由 Q 唯一 outer 取得。完整旧内容先验、同路径 action hit、再次完整新内容仅共同建立一个不可拆 JUnit，不分派内部检查/冷段/hit。具体 item/Wave/依赖/gate 只在 Waves；受影响范围最终需源码修复 gate 与接续 Q gate 的实际足证据采用，原 blocked gate 不回填，作者不释放任何 gate。

### 限定空Java输出规则与恢复边界

[原 Q g1 阻断报告](../../../build/verify-forge-patch-neo-20261028-g1/report.md)记录预检对缺失声明输出执行 `Resolve-Path` 而 blocked，所有调用0、无新 JUnit/XML/final；原报告与旧 argv/reference argv/metadata 只读。诊断 completed 仅确认当前空 Java 源码集、旧 `compileJava NO-SOURCE`、56项同序来源及三处同类解析风险，不等于未来 runner/编译/完整内容/冷段/离线可用或 hit 已验证。证据入口和事实见 [Context](context.md#t-neo-成功采用与q-neo-准备边界)，不复制外部 Result 或据缺失路径推断其从未有内容。

- 唯一例外对象是实际仓库根下的确切 `minecraft-codev-forge/build/classes/java/main`。先按原来源保留每项及顺序，用绝对规范化路径逐项定位，不能按后缀、仅 basename、任意 build/classes 或所有目录匹配。仅当明确确认该确切路径不存在且当前 main Java 源码集仍空时，保留该声明路径作该项来源/顺序对应而不强求真实路径；`exists=false` 的未知/权限情形不能当作已证不存在，不吞任意 `toRealPath` 异常。该路径实际存在时，同其它项正常 `toRealPath`/来源核对，不适用例外。
- 原56项全部保留且顺序不变，不过滤、删除、重排或去重；其余55项继续逐项真实路径及来源检查。Kotlin 输出、所有 JAR 及其它缺失项均不豁免，不修改实际 fixtureClasspath、reference argv、metadata 或独立参考/预期，不制造空目录或用用户缓存补材料。
- 未来仅纠正 `ForgePatchNamespaceInputs.kt` 内 Q 方法的三处：原 `-PfixtureClasspath` 解析（当前153行）、旧 clean-at/patched-at argv 的 classpath（213行）、当前 `runner.pluginClasspath`（292行）。三者应用同一窄规则再作56项有序来源比较；保留 AT CLI 角色、其余真实路径/来源、当前加载身份及后续所有完整断言。行号仅定位，实施沿对应表达式核对，不改原 prepare/default 行为。
- 后续 Q 启动前的必要预检必须采用同一例外及严格存在分支，不再无条件 `Resolve-Path` 拒绝该唯一缺失声明项，也不宽泛略过缺失文件。此为唯一运行项内部预检规则，无独立脚本、工具、测试或额外构建交付；本轮不实施。原56项、其余现存输入/工具/参考/cache 实际可读与来源条件仍必需，发现真正必要输入缺失、当前空集依据不成立、身份漂移/冲突/unknown 即停，不以剩余额度自动再试。
- Q g1 零调用不增预算：之后合计仍 outer≤1/nested≤1/prepare0/reference0。局部修复不运行 compile/help/Java/javac/Gradle/JUnit/探针；必要编译只在唯一 outer。修复静态完成不是编译或 Q 成功，原 blocked 不完成任何下游。未来 Q 使用真正全新根，不能覆盖 g1 阻断根或旧 F；新运行须满足下列原合同全部要求，不能拼接旧成功或用回退生成补冷段。

### 完整内容断言与冷段适用性

旧 final 与 hit 新 final 各自都须通过下列原 Q 合取；不只比较两 JAR hash 或复读旧布尔标记。

- 固定版本/来源：MC1.21、NeoForge21.0.76-beta、NeoForm1.21-20240613.152323；校验 userdev/NeoForm 本体、无 inject/无 mcinject、placement=null、official 映射方向、发布 filters/AT 及 libraries/modules 完整集合。用 S 的两份 files.tsv 和 stages/工具退出记录建立实际文件/大小/SHA256、参考工具版本/真实 Java21/阶段关联；旧工具不重跑，缺21或输入不适用准确记录而非 skip。只核必要相关实现/输入身份，不新建历史 daemon/全量缓存/额外身份审计门槛。
- 完整类集合/定义：以 S/reference/output/reference-patched-at.jar 的独立完整官方链为最终预期，逐个必需 class 比较 entry=`this_class.class`、super/interfaces、字段/方法/descriptor、指令/成员 owner/name/引用/异常及适用 AT 的规范化语义（现有 semantic 只忽略 debug）；完整 class 清单相符，不能只验候选数量或 Jar 能打开。参考链是已成功 `patch-complete-official --unpatched --data`→独立 universal overlay→AT，不调用生产补全/rename helper。
- patched 优先和未补丁定义：读取实际 patch records、clean-rename、patch-official、reference-clean-at 与 class-witnesses 的具体 target/obf；核 clean Adler32、patch 存在且非删除/非 overlay、final 等于参考 patched 且不同于 clean。具体 patched 引用方的引用须解析到无 patch 的真实 clean 接口，完整定义与独立 clean+AT 相等；目标 official entry、this_class、descriptor/reference 一致，无对应 obf 重复定义。删除项不加入必保留集，不扩删除语义修复。
- 完整资源/overlay：从实际 clean、patch、过滤后的 universal 清单重新求 clean-only、universal 与 clean/patch 合集的碰撞、universal-only，逐个资源核来源与字节；manifest/marker 等后处理改写项按下一条字段合同检查，不与 AT 参考作整文件字节相等；碰撞取 universal，空交集仅可用真实 universal-only，空集必须有完整清单/原适用性依据。固定 Neo inject=null 实证保留，不把其它组 inject/AT 义务豁免。覆盖合法最终阶段资源和共同资源内容，不索取 raw client/server 资源恢复。
- 收窄后处理：新鲜 final 必须 `Minecraft-Dists=client server`、现存 `Codev-Minecraft-Marker=true`、预期 universal/适用 AT/资源内容与适用 `Minecraft-Dist` 格式。用原 client 与 extracted-server 的实际资源集合独立推导无需类映射的 client-only/共同资源；前者有成员就验 client 标记、后者按合法最终阶段来源验内容，空差集记录完整证据。仅此有限合同，不把 class side 或完整旧新 attrs 等价加回门槛。
- 原冷段复用：除上述 old final 完整断言，还须将已采用 prepare 的真实 miss/rebuild、当前相关 operation10 实现与实际加载输入适用性、旧 output/cache SHA、固定 inputs 及原 cache 完整路径联合关联。T 成功不是豁免这些检查；任一内容差异、身份不适用或关键旧证据缺失，在 nested 前停止，不追加冷生成/reference，也不把断言失败降为不适用。

### 唯一路径、离线供给与调用

仓内可读来源为 [prepare 输入清单](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/neo121NoMcinject/prepare/evidence/files.tsv)、[reference 输入清单](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/neo121NoMcinject/reference/evidence/files.tsv)、[原 nested 参数](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/neo121NoMcinject/prepare/arguments.txt)、[实际 Gradle/JDK 记录](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/neo121NoMcinject/prepare/evidence/gradle-jvm.tsv)、[旧内容见证](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/class-witnesses.json)、[资源清单](../../../minecraft-codev-forge/build/forge-patch-neo-925395910390226218/resource-inventory.json)、[原外层 command](../../../build/forge-patch-neo-cpw-mods-20261028-g1/run-1/command.json)及 [薄 init](../../../build/forge-patch-neo-cpw-mods-20261028-g1/outer.init.gradle)。F 其余 reference stage/最终 JAR 位置由这些清单解析，不持久化仓外 Result/JDK/home 字面路径。

- **原生缓存同路径：** `S/prepare/cache/cached-operations/neoforge-patch-10/6d7a8c95/minecraft-1.21-patched.jar` 必须还是原完整绝对路径；禁止复制到 Q/cache 后冒充原路径命中。Core 的 aggregate 是逐文件 `murmur3_32_fixed`，按 Cache.kt 的有符号 hash 字节比较器排序去重后再 putBytes 聚合；另记输入原有顺序/角色/路径/SHA，不把有序列表误当 aggregate 算法，不要求 forge/neoforge aggregate 必异。核 `PATCH_OPERATION_VERSION=10`、operation、输入、key、basename、完整 path 与旧 miss 一致且与旧版本/forge operation 路径隔离。
- **隔离与旧 F 写边界：** Q 是未来执行时选择且确认不存在的新仓内 build 根，本轮不创建。outer XML/html/binary/日志/tmp 归 Q；nested project/TestKitDir/Gradle home/output/evidence/tmp 各归 Q 的独立槽。F 所有原项目、home、输入、参考、output、见证/日志只读，唯一例外是原 `S/prepare/cache` 目标 operation 目录的正常原生 lock。cache JAR 内容/其它 F 文件不得改写。命中产物可能 hardlink；新 final 只读断言，不就地编辑，需保存副本只作普通字节副本，不回写旧链接、不复制用户缓存。
- **离线依赖如何到达：** outer 使用原 command 的实际 Gradle9.4.0/JDK17/source-home 和安装列表，新增 `--offline`，直接使用该已成功 home 的现存依赖；不拷贝用户 home/配置、不补下载。nested 新私有 home 不假称有依赖：helper 以 `withGradleInstallation` 使用 prepare/evidence/gradle-jvm.tsv 已记录的现存9.4.0安装，以当前 outer 产出的 `withPluginClasspath()` 注入插件及现存依赖；fixture 的 opt-in 分支将 patches 绑定 prepare files.tsv 中唯一 userdev+NeoForm，universal 绑定唯一 universal，libraries 按全部 `neo121Libraries:` 行的原文件直接供给，不使用空 home 再解析 Maven。参考/源码工具只读原清单文件，hit action 不应执行内部生成或解析参考配置。任何插件/Kotlin DSL/测试编译/依赖仍需本机缺失材料则真实离线失败并停止；不是空 home 一定可运行的承诺，不引入离线缓存复制方案。
- **outer 唯一调用：** 从原 command 取 executable/cwd/有序 argv/JDK/source-home，任务仍 `:minecraft-codev-forge:test`，精确 selector 为已交付的 `net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.verifiesPreparedNeo121NoMcinjectWithCacheHit`；保留 `--rerun`（仅强制 Test）、no-daemon/no-configuration-cache/no-build-cache/no-parallel/max-workers=1/info/stacktrace 与原安装列表/禁止自动下载，增加 `--offline`。只在 Q 建必要薄 init 副本，将原 neo.evidence/XML/html/binary/tmp 重定位 Q，并显式传上述三个 `fixture.neo.*` 到 Test worker；不改第四个项目源文件来转发。必要测试编译作为该唯一外层的正常前置完成，不另跑 compile/help/clean/测试。真实数值 exit0 与该新方法 XML `1/0/0/0` 必需；launcher/包装 shell 返回或旧 XML 不代替。
- **nested 唯一调用：** 仅在先验全部成立后，从 Q 私有 project 用现有 GradleRunner 选择 `recordNeo121NoMcinject`，通过原 output flatMap 到真实 `:patchedNeo121NoMcinject`；withTestKitDir、`-g`、tmp/output/evidence 归 Q，`-PneoPreparedRoot` 指 S，`-Pfixture.cache` 指原 S/prepare/cache，fixture.output 新目录仍输出同 basename。沿原 JDK/安装列表/fixtureClasspath、`--offline --no-configuration-cache --no-build-cache --rerun-tasks --no-parallel --max-workers=1 --info --stacktrace`；无 describe/prepare/reference。fixture 的临近 action 检查缺 key/文件即 throw；实际 patched task 必须 `SUCCESS`、action 真实到达、日志明确 `Cache hit for neoforge-patch-10`，新 output 原先不存在。UP-TO-DATE/FROM-CACHE/SKIPPED、新 root miss、仅 record 执行或手工复制 JAR 均不能替代。

上限为 **outer Gradle 1 次 / nested Gradle 1 次 / prepare 0 次 / reference 0 次**；先验失败时 nested 为0，编译失败时 JUnit 为0，均如实记未到达而非成功。nested 复用 TestKit 的真实 BuildResult/TaskOutcome 成败；该 API 不提供进程数值 exitCode，不伪造 nested 数字退出码，outer 真实数值退出仍必需。不得以编译失败、真实 miss、离线依赖不足或内容不符追加下载、第二次外层/nested、prepare/reference 或新冷根。临近 action 存在性检查不改生产 miss 分支；若日志仍出现 miss，此次 Q 即不满足且停止追加调用，不能接受随后的生成来拼成允许的冷段。

### 证据、等待与局部自检边界

未来 Q 保存：原来源/输入和独立 reference/工具关联、old final 完整断言明细、原 miss 的适用性及原 cache identity、当前源码/实际插件输入关联、唯一 outer/nested 完整 argv/cwd/JDK/真实退出与 task outcome/明确 hit、新 XML/完整新内容断言/产物 SHA 及实际调用计数。旧冷段与新 hit 分开标记并有据关联，不声称同轮重新生成；新结果 hash 与旧产物相等还必须各自全内容符合 oracle。unknown、缺 XML/实际 hit 或原材料不适用不能通过。不恢复 outputDrained、控制器排空、daemon 历史链或额外身份审计；必要真实退出、实际 JUnit、完整内容/真实 hit 仍必需。

实际实现与运行共享三个接点/Forge/Gradle/TestKit/build/fixture/cache/输入，和 P/其它 T/Q/R/D/B/M/V/H 相关写运行串行；只读旧原料不是新增成功依赖。依赖和所属 Wave/gate 共同等待只由 Waves 拥有；新源码结果不完成 Q，Q 不放行完整代理/R/V/H，也不增加 Java8/其它组屏障。实施仍待不同只读 Handler 复核本增量及必要连接，再由 Router 披露确认；本作者不选择后继或代办。

### 原接线准备作者自检记录（历史）

下列保留原首次准备时的作者静态检查，不是本轮重复执行；其中“拟新增/未实施/待确认”等仅指该时点，不能重置已采用 WIRE/T/P、原独立复核或原确认，也不提供新的编译/运行证据。

- 已读取三个源码接点、现有 helper 的记录/断言边界、fixture 的 patched/record provider 及独立 complete→universal→AT 参考链、原薄 init 与输入/Gradle/JDK 记录。确认新增 selector/helper/属性目前均不存在，所以始终标为拟新增，未将原 T 入口或现存记录函数算作完整 Q。manifest 后处理按字段合同验证，不误与前阶段 manifest 全字节比较；没有新增完整旧 attrs/class side 要求。
- 已核一个稳定源码交付和一个运行结果的真实独立边界；完整内容先验/原路径 hit/再次全验仍同一个不可拆 JUnit。原 Q 的 official/无 mcinject、补全/引用/优先级/AT/完整资源及收窄 Dist/marker/有限资源关系，分别落实到上述断言、独立参考与停止条件；原冷段只能经适用性后采用，不能由728资源或T成功顶替。
- PowerShell 纯文本断言检查通过：新源码 item/Q 各一次声明、各一次 Wave 归属、gate owner 匹配；Q 恰等源码/T/P 三 item 和对应三 gate；T/P 直接前置不回指 Q/消费者，R/V/H 仍各直接消费 Q，所属 Q→R→V→H gate 链一致。现存 V/H 以前置行及所属 Wave 表读取，未为检查方便重构历史标题。这里只检查受影响局部，不宣称全历史图已审计。
- 纯文本检查确认 V/H 仍等完整代理 gate，D/B/M 没有新加 Q/接线成功等待。共享源码/编译/Gradle/TestKit/build/cache/fixture/输入冲突仍串行，新 Q 根不被视为消除原缓存冲突。T 的一次例外不扩大为 Q/完整代理/R/V/H 豁免，旧失败/越界/证据覆盖/影响未知及其它未完项不改判。
- 已检查本增量38个链接的文件存在及标题锚点，原 cache JAR、两份参考 AT JAR 均在指定原路径；来源导航只落仓内相对路径，没有仓外 Result 间接依赖。旧输入/参考只读加原生 lock 例外、全新 Q 槽及现有 source-home/Gradle 安装/PluginClasspath/已物化文件的离线供给均明确；未承诺空 home 必可用。
- 调用合同核为 outer1/nested1/prepare0/reference0；编译只在该 outer，缺输入/适用性/离线依赖/真实 hit 或内容不符即停、不下载/不重试/不补冷生成。真实外层数值退出、JUnit1/0/0/0、nested 实际 BuildResult/task action/hit 和完整内容证据不可省，未知不能通过；未恢复输出排空、daemon 历史链或额外身份审计。
- 本轮只改原四份协调文档。未实施三个源码接点、未生成运行材料/未来Q目录，未运行Java/javac/Gradle/JUnit、网络或进程检查，未清缓存/终止进程/改用户配置/JDK/依赖/Git，未修改权威。自检为作者静态检查，未独立 review/判 ready/释放 gate；编辑器提示不作项目验证证据。

### 本次局部恢复作者自检

- 已完整读取本轮提供的诊断、Q g1 blocked 与 WIRE g1 源码 Result，仅作运行时采用输入；持久记录只使用已存在的仓内原料。纯文件/文本核对通过：prepare、metadata、旧 clean-at/patched-at 各56项按序规范化来源一致，其余55项存在，唯一缺失是确切 Java 声明输出；当前 main Java 源文件0、旧日志第286行 `compileJava NO-SOURCE`。这不证明历史从未有内容、未来动态 runner、编译或加载身份已通过。
- PowerShell 内存文本断言通过：新增源码修复和完整 Q 各一个独立结果边界、各一项/唯一 Wave/对应 gate；WIRE→修复→Q 与原 T/P 直接前置在受影响局部无回边/自等，R/V/H 各直接消费新 Q，R 所属 gate→V→H 及完整代理等待一致，最终仍十二个完整恢复消费者。原 WIRE completed、Q g1 blocked/四类调用0、诊断 completed 分开保留；旧 blocked/gate 不回填，D/B/M/Q-1165 不增加 Neo 成功前置。
- 已逐项核对 helper 三处及未来预检的同一确切规则：只在已证缺失且当前空 Java 源集时保留声明项，存在时正常真实路径/来源检查；56项/顺序保留，其余项/Kotlin/JAR/异常不豁免，不改原 argv/reference argv/metadata，不建目录。旧完整内容与冷段适用性、原同路径真实 action hit、完整新内容、outer真实exit0/JUnit1/0/0/0、独立参考与离线隔离/串行冲突仍必需；预算 outer≤1/nested≤1/prepare0/reference0、必要编译仅唯一 outer，真正必要输入/冲突/失败/unknown 即停，不据剩余额度重试。
- 受影响页首区域52个仓内相对文件链接均实际存在且可读，20个标题锚点及四文档 reciprocal 链接通过；无直接/经 Context 中转的外部 Result 定位。首轮自检发现新增 AT argv 链接文件名错误，已纠正为现存 `reference/evidence/argv.tsv` 并重核通过；文本链接检查表达式也作了本地纠正，不是项目运行或新验证工具交付。
- 本轮仅局部编辑原四文档；检查仅内存文本断言和必要只读文件/源码核对，不新增脚本、工具、测试、运行目录或原始 Result 副本。未写源码/fixture/用户配置/依赖/权威/旧证据，未运行 Java/javac/Gradle/JUnit、网络、LSP/IDE、进程操作或 Git 写入，未造目录、清缓存或触碰旧 lock。作者静态自检完成，不是独立 review、实施确认、项目验证或 gate 释放；旧 failed/partial/unknown、覆盖损失和越界影响均保留。

**待决/执行前条件。** 原独立复核、原实施确认及源码/T/P 三 gate 采用已发生，不重复求批准或重跑。此次限定规则/helper 修复/预检及必要接续尚待不同 Handler 独立定点复核、Router 对受影响实质变更披露与 C6 实施确认，准备完成不是确认或 ready。未来源码修复与 Q 分别按 Waves 执行/验收；不预报编译、旧完整内容/当前冷段适用性、离线材料或真实 action hit 可过，不足即停且不追加调用。本准备不完成实际项、独立复核、确认实施或释放任何 gate。

## NeoForge cpw.mods 局部恢复策略

**第五次前的准备历史。** 该 generation1 已采用 completed，真实结果及只作 T/候选冷段复用的边界见页首 Q-Neo；下述未来一次/未执行不再构成重跑或本次实施授权，原成功合同保留。

匹配 [Work](work.md#neoforge-cpwmods-过滤修正后的单次恢复)、[Context](context.md#neoforge-第四次失败与cpwmods诊断采用)及唯一 [Waves](waves.md#recover-forge-patch-neo-cpw-mods)。本轮只维护四文档并做作者局部自检，不修改模板、命令/init/用户配置，不运行项目，不独立 review、派发或释放 gate。用户已明确接受“修正并运行一次”；以下是未来一个修复结果，不拆源码修正与其原回归为独立成果。

**权威与写拥有。** PRD（`docs/prd/codev-mixin-rework.md`，产品输入/隔离/失败）、Accepted ADR（`docs/adr/mixin-operation-isolation.md`，operation-local 隔离）、Mixin Spec（`docs/spec/mixin-preapplication.md`，Mixins 与 loader adapter）均 reuse，沿用 Context 三族评估：此次 fixture 过滤纠正不改变上述规范。内部代理 Spec（`docs/spec/isolated-gradle-test-proxy.md`，根测试基础设施）reuse：仅延续已接受的同一未完 Neo 单次启动例外，完整合同不变。全部权威写入 skip，未发现相反证据。未来修改 owner 仅为 Forge 测试模板；生产处理、版本、依赖与 JDK 均不变。

**最小策略。** 模板 `minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts:19` 的 NeoForge Maven `content` 中，仅在现有 `includeGroupByRegex(...)` 后追加 `; includeGroup("cpw.mods")`；保留原 regex、仓库顺序及 `metadataSources { mavenPom(); artifact() }`。不改失败轮生成的 project 或原测试。`ForgePatchNamespaceInputs.kt` 将此模板复制到 prepare/fresh/reuse/reference，各 phase 和 basic/1165 样例因此也获得该 group 的仓库资格；用户已接受此影响，不因此扩大运行范围。失败根因已证为 fixture 过滤排除 cpw.mods；放行只使原坐标有机会进入 NeoForge Maven，不保证版本可用、下载或代理路由成功。

**原调用单处来源。** 以最近第四次实际 [command.json](../../../build/forge-patch-neo-once-exception-20261027-g1/run-1/command.json) 的 cwd/executable、20 项有序 argv、JAVA_HOME/TMP/TEMP 为唯一当前基线；[同轮 outer.init.gradle](../../../build/forge-patch-neo-once-exception-20261027-g1/outer.init.gradle)原样复制到未来全新证据根。该 JSON 的 environmentSource 只说明历史环境来历，不运行历史脚本。下节第三次命令及旧预定输出只属历史，不能覆盖本节基线，也不再调查参数。

保留 `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache`、原 `--rerun`、禁配置/构建缓存、串行/max-workers=1、Java17 外层/Test、完整五 JDK 路径、禁自动下载、`-Xmx512m` 及实际 source-home。仅允许必要新输出重定位：`--init-script` 的同内容副本路径、`-Dneo.evidence`、jvmargs 的 `java.io.tmpdir`、TMP/TEMP 与日志/XML/报告位置；不改其它实参/init 内容、代理/用户配置或缓存语义。未来只选真正全新根，本次未指定已可用路径或创建目录；旧失败根及其 command/init/XML 仅读。

**实际前置与一次边界。** 新 item/Wave 身份及唯一 gate 见 Waves；G-REPAIRS、root CACHE-RESTORE-REMAINDER、bootstrap ARGFILE 及其已满足 gate 直接复用，不重跑清理编译/三模式/root/bootstrap/remapped。仍仅本次 Neo 不等完整代理 gate 及其准备/最终审计，不用有限三模式替代完整代理；其它完整消费者与 V/H 仍等待原合同。运行前仅核当前共享冲突、必要输入/JDK、私有隔离及输出不覆盖；共享 Forge/helper/模板/Gradle/TestKit/build/cache 写运行串行。不加探针、控制器、矩阵、来源证明、全量 hash 或旧 daemon 历史检查。

旧四次失败及 unknown 不重置；新增至多一次、累计至多五次。模板一处纠正后仅原精确方法一次；失败/未知保全本轮真实命令/日志/退出/XML/产物及未到边界即停，不重试、不追加修复或测试。缺必要权限/输入/JDK且未启动为 blocked；真实调用失败为 failed，unknown 如实保留不算成功。正常依赖构建/下载仍属原唯一调用，不另开编译或构建。

**原成功条件不减。** 同轮原 selector 实际执行、Gradle 真实 exit0、JUnit tests/failures/errors/skipped=`1/0/0/0`，并满足原完整 T-Neo：固定 MC1.21 / NeoForge21.0.76-beta / NeoForm1.21-20240613.152323，provider/实际 Java21 工具角色、独立 official reference、类/接口/引用/资源见证、适用 AT/Dist/marker、私有隔离、prepared/final output 及阶段/任务图/argv/退出关联。原依据沿 [T-Neo 完成边界](#neo仅运行恢复策略与作者自检)；不以过滤已改、libraries 解析、编译、候选 JDK、布局文件的 executed=true 或旧产物代完成。自然日志仅支持已到达阶段，未到达即未证，不增路由/来源证明；原未证代理有效值和逐请求路由限制保留。新结果完整采用与 gate 判断仍属 Router，不自动释放 Q/R/V/H。

### cpw.mods 恢复的作者局部自检

本次只核本节及新 item/Wave、必要前置与直接消费者/最终合取：一个模板过滤修正与其原精确测试只建立一个可观测修复结果、一个 Handler/Result；原第四次 failed 不再作为成功等待，全部旧失败/unknown 和原成功条件保留。核对最近 command.json 的 20 项有序 argv 及同轮 init，未猜参数；仅必要输出可重定位。局部联合等待必须从新 gate 回到已满足 G-REPAIRS/root/bootstrap，不经 Q/R/V/H、完整代理或自身；其它消费者的原完整合同不减。自检结论与具体静态核对数量由本次 Result 报告，不沿用下节旧作者检查数量，也不声称运行、独立 review、ready 或 gate 释放。

## NeoForge 原测试一次尝试的原入口与参数来源

**唯一安排与授权。** 用户已接受“先跑NeoForge一次”：原测试至多一次，只对本次解除完整代理验收前置，不补测试、不改代理/用户配置、失败停止且不重试。PRD/ADR/Spec reuse，权威写入 skip（运行前置例外，不变更产品或隔离决策）；[原完整代理 Spec](../../spec/isolated-gradle-test-proxy.md)及 `G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE` 原合同/未满足状态保留。本节只准备安排，不运行或修代码；下方 A 恢复的原“Neo等待完整gate”及“三模式下一步”语句是此前时点，当前只有本节限定的单次 Neo 启动例外。

复用从未执行的 `RECOVER-FORGE-PATCH-NEO-AFTER-PROXY`，唯一单成员 Wave 为 `W-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY`，未来仅一个可区分的同名 generation1 Result；不是重开三次旧 failed。item/Wave 不再等待完整代理 gate、`PREPARE-ISOLATED-GRADLE-PROXY-EAGER-RECOVERY` 或 `VERIFY-ISOLATED-GRADLE-PROXY-ISOLATION-AND-REDACTION`；保留 G-REPAIRS、已满足的 root/bootstrap 及其 gate 作为必要输入，直接复用而不重跑。有限三模式已有 completed 及 item/Wave 证据满足只是已采用事实，不替代完整代理验收，也不新增成功等待。

**参数唯一来源。** 已文本回读 [第三次 Neo 实际调用 command.json](../../../build/recover-forge-patch-neo-validation-20261026-g1/run-1/command.json)、[原 outer.init.gradle](../../../build/recover-forge-patch-neo-validation-20261026-g1/outer.init.gradle)、[历史 run.ps1](../../../build/recover-forge-patch-neo-validation-20261026-g1/run.ps1)和[同轮失败报告](../../../build/recover-forge-patch-neo-validation-20261026-g1/report.md)。`run.ps1` 只用于定位原环境来源，禁止直接重跑其旧 PID/daemon、全量输入 hash 或控制检查。近期 [三模式 invocation.json](../../../build/proxy-a-read-recovery-eager-20261027-g1/invocation.json)只是不同测试的环境参考，不是 Neo selector、JDK/source-home 或命令模板。

| 原输入/参数 | 精确出处与本次沿用规则 |
| --- | --- |
| 项目与入口 | 历史 `command.json.cwd`、`executable`：项目为 `minecraft-codev` 仓根，入口为该根 `gradlew.bat`；执行者原 cwd `E:/Projects/cloche` 不可替代项目 cwd。 |
| 唯一任务/selector | `command.json.argv[0..2]`：`:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesNeo121NoMcinjectWithPrivateCache`。只运行此方法，不用三模式类、全类或新增 selector 替代。 |
| 其余完整有序 argv | 以历史 `command.json.argv` 为准：保留 `--rerun`、`--no-daemon`、`--no-configuration-cache`、`--no-build-cache`、`--no-parallel`、`--max-workers=1`、`--stacktrace`、`--info`、原 `-Xmx512m` 等；不换成 `--rerun-tasks`、不添加 `--offline`、代理 `-D`/`-P` 或额外测试。仅下行列出的新输出地址可替换。 |
| 输出重定位 | 后续使用全新本轮证据根（预定 `build/forge-patch-neo-once-exception-20261027-g1/`，此处未检查或创建），其中 `run-1/` 为本次唯一调用。将原 `--init-script` 指向新根内同内容 `outer.init.gradle`，`-Dneo.evidence` 指向新 `run-1`，仅重定位原 `-Dorg.gradle.jvmargs` 中 `java.io.tmpdir` 及进程 `TMP/TEMP` 到新 `run-1/tmp`；保留其它 argv/行为。原 init 只重定位该 Test 的 JUnit/HTML/binary 和 launcher 记录；保留这一原有接线，不创建验证框架。 |
| JDK/工具来源 | `command.json` 中 `-Dorg.gradle.java.home`、完整 `-Dorg.gradle.java.installations.paths`、`-Dorg.gradle.java.installations.auto-download=false`，以及历史 `run.ps1` 从既有用户 `org.gradle.java.installations.paths` 选取 Java17/21 的来源。进程 `JAVA_HOME` 沿用该次实际 Java17，禁自动下载/安装/换 runner；保留 Test17 与 NeoForm metadata 选择真实 Java21 工具的角色分离，不以 JavaProbe/候选目录代证。当前路径可用性未被本次文本读取证明。 |
| Gradle home/私有隔离 | 外层 `--gradle-user-home` 沿用历史 `command.json` 的实际值，不从三模式调用或执行者 cwd 猜测，也不复制整份用户配置。helper 原新建四阶段 project/testkit/gradle-home/output/evidence/tmp 私有根及空 cache 约束不变，不注入旧归档/cache，不清缓存。普通依赖解析/下载按原任务进行，不增网络探针。 |
| 固定样本与成功条件 | 原 T-Neo 的 MC1.21 / NeoForge21.0.76-beta / NeoForm1.21-20240613.152323、provider、独立 official reference、实际 Java21 工具、类/接口引用及资源、适用 AT/Dist/marker、完整私有隔离、prepared/final output 与同轮任务/argv/退出证据全部保留；见原 [T-Neo 完成边界](#neo仅运行恢复策略与作者自检)与 [Waves item](waves.md#recover-forge-patch-neo-after-proxy)。 |

**一次调用与有限结论。** 三次历史真实失败累计保留，未来至多一次、累计至多四次；不设 basic 的次数或时间预算。后续启动前只做当前相关共享冲突与输出不覆盖检查，保留原资源/JDK/输入等实际必要条件；共享 Forge/fixture/helper/Gradle/TestKit/build/cache 写运行串行。不重审旧 daemon 身份、不排空控制器、不加全量 hash、网络或 Java 探针；本次准备不进行上述运行时检查，也不重编译或重跑已通过 root/bootstrap/remapped/三模式。

后续 Result 必须记录本轮实际完整 argv/cwd/JDK/环境来源、唯一调用次数、完整日志、真实退出和同轮 JUnit/产物及未到达边界。只有真实原 selector 执行、Gradle exit0、JUnit tests/failures/errors/skipped=`1/0/0/0` 且上表原 T-Neo 全部实际条件同轮成立，才可报告原准备成功；执行过一次不等于成功，旧 XML/归档、编译、cached/skip 或候选 JDK 不代证。启动前缺必要输入/工具为 blocked，已调用失败为 failed，未知如实记录并停止；任何失败/未知均不重试，不修代理/用户配置/源码，不追加测试或扩大来源/工具矩阵。

**剩余限制与直接连接。** 历史原命令、init 和参数来源已定位，无需新增命令调查；本次不能证明当前 JDK/输入或联网成功，baseline 五键 absent，历史 Neo POM 超时/拒绝保留。`G-FORGE-PATCH-FIXTURE-NEO-AFTER-PROXY` 仍仅以原完整 T-Neo 成功且 Result 被完整采用为条件，本次不释放它。Q-Neo 仍另验完整内容/有效路径/冷热；R/V/H 原合取不减，V/H 及其它完整消费者仍等待完整代理 gate，有限三模式和 Neo 本次结果均不替代它。作者局部自检只针对本节、对应 item/Wave 前置例外及直接连接，不做独立 review，不声明 gate 完成或派发运行。

### 本次 Neo 单次安排的作者局部自检

已用 PowerShell 纯文本完成本次局部检查：四文档当前块一致；唯一 Neo item、唯一单成员 Wave，保留 G-REPAIRS/root/bootstrap 三个必要 gate；只解除本次完整代理及其准备/最终审计等待，不将有限三模式改作完整 gate。Q-Neo/R/V/H 四处直接前置仍指向同一 Neo 身份，V/H 的 item 和 Wave 均继续等待完整代理 gate；所选正向等待不含自己/后继，未整理或重审全图。Waves 写入时对照保留了三次历史 failed 段落及原 T-Neo 完整成功条件正文，未将旧失败改为待执行或成功。

本次新增块及所选 Neo item 的 23 处本地链接全部通过：11 个仓内可读目标、4 个可解析 fragment；原 Neo task/selector 与历史 command.json 的 20 项完整 argv 已核对，原 init 和 run.ps1 仅文本读取。新输出根只是未来目标，未创建/采样；没有执行 JDK/Gradle/JUnit、编译、网络或进程操作，也没有写入源码/配置、Git 或 PRD/ADR/Spec。该检查只证明本次安排与连接，不是独立 review、运行成功、Result 采用或 gate 释放。

原命令/参数来源无缺失；当前工具/必要输入和联网成功仍未证明，baseline 五键 absent 及历史 POM 超时/拒绝限制保留。后续缺输入或失败/未知就保留实际证据并停止、不重试；完整代理未满足及 V/H 其余合取不降低。

## 共同代理输出路径A恢复策略与作者自检

匹配[Work](work.md#共同代理输出路径a恢复的最小维护)、[Context](context.md#共同代理输出路径a选择与历史边界)、[唯一Waves](waves.md#共同代理输出路径a恢复连接)。本轮仅维护四文档及作者自检，不实施、运行、派发或判ready。PRD/隔离ADR/Mixin Spec及[内部代理Spec](../../spec/isolated-gradle-test-proxy.md)沿用reuse，权威写入skip；原A/全部共同验收已确认，历史进程终止影响未知已接受为保留限制，原确认继续有效，无新行为/范围/风险变化，无需重复确认。下方历史待确认/未接受措辞限原时点，不消除未知事实。

### 执行边界与验收策略（唯一分解见Waves）

本轮只维护四份Work材料及作者局部自检，不改项目代码、不执行测试、不派发或判断独立review通过、不释放gate。用户已确认的实际下一步仅为现有固定三模式JUnit运行一次，不新增/补测试、源码、探针、控制器、矩阵或真实独立bootstrap build。PRD、隔离ADR、Mixin Spec及[内部代理Spec](../../spec/isolated-gradle-test-proxy.md) reuse；权威写入跳过。原完整合同和根CACHE-RESTORE-REMAINDER、bootstrap ARGFILE已采用成功Result/gate沿用，保留完整合同不表示本次获准执行其它缺口。初次A读取失败、READ-RECOVERY因CLI片段错误导致Java exit1/Gradle未启动/无XML、复合Handoff执行前blocked、CLI-PATH-RESTORATION g1额外读取猜测脚本失败、旧混合证据根和历史越界终止进程后影响unknown均保留；不跨轮拼证、不覆盖旧根或补造原件。

Plan只记录验收策略和覆盖映射；唯一可执行分解及item/gate身份见[Waves](waves.md#统一隔离gradle测试代理的现行连接)：

| 验收边界 | 结果形态与范围 | 当前输入能力/限制 |
| --- | --- | --- |
| 准备与已采用结果 | 复用`prepare-proxy-shared-validation` g1已完成准备、[修复后JSON](../../../build/proxy-a-read-recovery-eager-20261027-g1/junit-command.json)/[init](../../../build/proxy-a-read-recovery-eager-20261027-g1/verify.init.gradle)，不再修路径或新建准备工程；根缓存恢复和bootstrap ARGFILE成功结果/gate不重跑。 | 准备gate已满足；清理后mixins/fabric/forge五个测试编译任务实际执行且exit0，仓内证据见[Context](context.md#共同代理输出路径a选择与历史边界)，不是Test运行通过或新增前置item。 |
| 静态入口归属 | 一个独立只读Result，保留原十个入口的归属证据及新增代理探针发现。 | 现有completed结果只支持原十个及至少第十一个入口，不宣称动态传播或全量恰为十个。 |
| 现有固定三模式JUnit有限结果 | 同一现有类selector仅调用一次，一个JUnit方法、一个Handler/Result；默认daemon、显式TestKitDir/private `-g`、embedded及方法内部全部断言/nested调用均在该次执行内。 | 完成仅要求唯一现有测试实际执行、原断言全部通过、真实Java/Gradle客户端exit0、本轮XML的tests/failures/errors/skipped=`1/0/0/0`，正常记录实际模式结果及命令/日志/XML与当前classes/worker/output关联。预期内部异常按原断言判定；缓存/skip或旧XML不代本轮执行，不改参数强跑/补跑。真实失败/未知退出即停并报具体原因和已达模式，不拆先行通过断言。合成根来源、逐键三态/HTTPS显式空值/Properties转义等未覆盖条件独立保留在完整gate，不阻止该有限结果如实完成。 |
| 其它根来源合同 | 覆盖显式优先序、真实来源变更/删除/未配置及身份/读取/Properties失败关闭的独立结果。 | 固定JUnit只改变worker属性，不验证真实来源文件变化；当前固定输入不含这些执行入口，原合同不降级、不并入JUnit结果。 |
| 独立bootstrap合同 | 真实私有home build及参数、oracle、预期构建异常传播恢复各有独立结果。 | 已采用ARGFILE Check不是实际Gradle build。须有各自可执行输入；本次不新增测试/调用。 |
| 最终审计与消费者 | 独立只读隔离、脱敏、凭据排除审计，之后由既有最终合取供Neo/V/H消费。 | 不证明逐请求路由，不替代Neo或V/H原合同。 |

原完整合同保持：五键三态/一致性/真实home、默认daemon与私有home及embedded恢复、来源更新与删除后无残留、失败关闭和显式覆盖冲突、真实独立build的来源先保存/六参/原309项有序单一classpath/arguments-file/正常与异常传播恢复、适用入口静态归属、offline/cache/output/tmp/fresh-reuse、隔离脱敏及凭据排除、实际Gradle exit/XML/源码/classes/worker/output关联。它们是原完整`G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE`的条件，不全是有限`G-ISOLATED-GRADLE-PROXY-THREE-MODES`的条件；未覆盖部分不会随有限测试成功消失。一次方法的三模式/断言/nested调用不拆Handler/Result，独立来源/bootstrap终态不并入本次调用。

现有输入直接支持这一次有限执行，不使原完整Spec自动可执行或已覆盖。执行前只核当前相关共享冲突及输出不覆盖，不猜准备目录未使用；有覆盖风险时仅重定位现有init的`isolated.proxy.evidence`、命令init引用和本轮输出/日志/XML保全位置，不另开准备工程。原source-home、selector、Microsoft17/Gradle9.4.0、完整单-P/JDK列表、offline/configuration-cache/build-cache/no-parallel/max-workers及其余语义保持。共享写运行串行，实际冲突/真实失败/缺真实退出即停保全，不盲重试、杀预存进程或恢复controller排空/旧daemon链/全量hash/自证门槛。其它来源与独立build结果及合成根来源逐键三态/HTTPS显式空值/Properties转义等缺口仍缺可执行输入或完整证据；本次不补测试或调用。


### CLI-PATH-RESTORATION与旧单一复合接续（历史保留，不再派发）

原OUTPUT-EAGER读取阶段failed及READ-RECOVERY的Java exit1/Gradle未启动/无XML计数保留。随后`CLI-PATH-RESTORATION` generation1亦failed：[独立报告](../../../build/proxy-cli-path-restoration-20261027-handler-g1/report.md)与[错误摘录](../../../build/proxy-cli-path-restoration-20261027-handler-g1/read-failure.txt)支持前三次检查/读取exit0、第四次对非必需且由执行者猜测的`run-junit.ps1`额外Get-Content因不存在而PowerShell exit1。已提供JSON/init均读取成功，不缺输入；Java/javac/Gradle/JUnit均零启动，无XML/计数，路径与init尚未改。该轮仅产生新的失败报告/摘录根，是已有效果，旧根不可覆盖；摘录不是完整原始转录。这不是项目测试失败，不重新诊断环境或补造原件。

历史上的新恢复草案曾由`RECOVER-ISOLATED-GRADLE-PROXY-OUTPUT-EAGER-CLI-PATH-RESTORATION-DIRECT-RECOVERY`一个新Handler/独立Result承接全部原未完共同验收；该单一item与旧gate现保留为历史，由现行准备项、13个独立验收Result及审计项取代，不再派发、不作为现行前置。旧CLI-PATH-RESTORATION failed及完整item/Wave释放合同保留、不回填、不等待其或其它旧failed/gate转成功。根CACHE-RESTORE-REMAINDER和bootstrap ARGFILE的完整成功Result/gate已采用满足，仍是准备项唯二真实项目前置，不重验；本轮维护不授予实施/运行权限。

### 历史复合调用输入、两处路径和全新输出（合同保留）

直接解析[当前命令JSON](../../../build/proxy-a-read-recovery-20261027-g1/junit-command.json)的`executable/cwd/arguments`数组，消费[已读取init](../../../build/proxy-a-read-recovery-20261027-g1/verify.init.gradle)。以[旧D同版目录片段](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)为来源，仅在零基`arguments[2]`的`-javaagent`及`arguments[5]`的CLI jar中各将`lcvyxq3t37f6mx9miaydrrs`恢复为`lcvyxq3t37f6mx9miaydrrgs`；不整体复制旧D参数。保留Microsoft17、Gradle9.4.0、完整单-P、selector、cwd、source-home、offline/configuration-cache/build-cache/no-parallel/max-workers及其余原arguments/有序语义。

未来输出只写真正全新的本项build根；新init副本仅将`isolated.proxy.evidence`从旧根改到新根/junit，命令的init引用随之重定位，`isolated.proxy.sourceHome`及其余init内容不变。必要输出/报告/XML/classes/worker/独立小build均归新根；源JSON/init、旧证据仅读。直接调用已有JSON数组即可，必要薄调用不成为额外持久工具产品；不存在的猜测脚本不是依赖，不查找/探测/修复/重建旧脚本，不新增命令预审、文件存在自证、短进程实验、工具框架或审核门槛。

### 已完A与原完整共同验收

A源码的`probeOutput.get()`、两处Java11修复及完整单-P已完成，作为输入，不重新授权或重复源码编辑。A已接受的配置阶段固定输出、缺少`probeOutput`更早失败、配置后路径变化不生效仍保持；五键仍由任务action读取，三模式/断言/home/cache与原调用语义不变。本次不再审A技术方案。

旧合同仍要求全部共同传播/恢复/隔离行为成功；它不再是当前单一item终态。`G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE`仍须原13个结果/gate、最终只读审计及合成根来源/逐键三态/HTTPS空值/Properties转义等完整证据缺口全部齐备并由Router采用判定；一次有限JUnit成功不能代这些缺口，也不自动释放该完整gate。完整验收保留：精确JUnit全部必需案例真实成功、真实Gradle数值exit0、当前XML/实际tests-failures-errors-skipped与源码/classes/worker/输出关联；默认TestKit daemon、显式TestKitDir/私有-g、withDebug(true) embedded三模式，五键三态/一致性/真实home、真实来源变化/删键/删文件/随后未配置无残留及embedded正常/预期异常finally恢复。

本轮新javac持久bootstrap输出执行真实无游戏独立私有-home小build、目的环境改写前保存来源、六参/原309项有序classpath/原arguments-file、正常和异常/参数/oracle错误传播及恢复全部保留。适用十入口含binding ordinary/pipeline两路静态归属，原offline/缓存/output/tmp/fresh-reuse/私有home隔离/脱敏/凭据排除和真实退出/输出收束不减。编译、已采用Check、局部输出、静态归属、skip或旧XML不代完整Result；不重跑根/bootstrap，不称Neo或逐请求路由成功。

### 连接、停止与作者自检

T-Neo、V/H直接消费者的item/Wave前置和最终合取仍消费原完整`G-ISOLATED-GRADLE-PROXY-EAGER-ACCEPTANCE`与最终只读审计Result，不改接有限JUnit gate；完整覆盖缺口未满足，Neo仍受限制。Neo其它前置/未来至多一次/三次旧failed、V/H原十二项/参数/完整M/fresh三模块及Forge类/根入口/不同Handler独立验收不变，本轮不执行Neo。共享JUnit/编译/Gradle/TestKit/build/fixture/cache/相关输入写运行仍串行，新相关冲突、unknown、真实失败、缺证或超出上述边界的纠正即停保全；不杀进程、清缓存、覆盖旧根或重试。混合轮次归属、历史未知及旧失败/gate限制原样保留，不拼旧材料为同轮证据。

作者局部自检核本次有限完成谓词、既有单item/单成员Wave/单Result、固定输入与已采用前置、当前冲突/输出不覆盖规则、item/Wave联合等待和Neo/V/H直接消费者：有限通过不推出完整gate，完整缺口与历史failed/partial/blocked/unknown保持。只检查受影响连接和四文档相对链接，不重审A方案、既有成功或全图；自检不等独立review通过、实际运行、Result采用或gate释放。本轮不运行Java/javac/Gradle/JUnit、网络、进程检查、Git或LSP；不派发评审，也不索取同一范围的重复授权。

## 共同代理Java11兼容恢复策略与作者自检

**历史保留说明：** 本节以下两处Java11修复、完整单-P、三次共同失败及旧gate合同仅作为已完成/历史输入保留，不再是当前A恢复的item、前置或成功等待；原合同、轮次和限制均不改写。 


### 当前范围与精确两处修复

匹配[Work](work.md#共同代理java11兼容恢复的已保留历史)、[Context](context.md#共同代理两次failed与java11限定诊断采用)、[唯一Waves](waves.md#共同代理java11兼容恢复连接)。本次仅四文档恢复维护/作者自检，不实施或运行。原四项串行范围已确认，PRD/隔离ADR/Mixin及[内部代理Spec](../../spec/isolated-gradle-test-proxy.md)reuse、权威写入skip。根CACHE-RESTORE-REMAINDER与bootstrap ARGFILE成功Result/gate已采用满足，保留前置不重跑。原VERIFY、单-P恢复两次旧failed及最新Java11恢复generation1 failed/旧gate不满足，保留原完整标准；新成功不回填历史。

已采用加工事实，不是本次运行或重新诊断。失败轮次必须区分：原VERIFY在缺Java11发现处真实Gradle exit1、JUnit零执行；单-P恢复越过发现后compileTestJava失败、Gradle exit1、JUnit零执行；最新Java11恢复两处修复已落地并编译通过但整体failed，真实Gradle exit1、JUnit为1/1/0/0，两个daemon各五stage的equal=true仅属局部观察，embedded失败且真实独立小build未完成。最新执行先门禁失败，随后越界强制终止三个预存相关进程，其他工作影响未知且未被接受。`build/recover-isolated-gradle-proxy-validation-20261027-g1/`是混合轮次根：`report.md`属旧轮，部分command/log/exit/source已被新轮覆盖，XML及小工程属新轮；不把当前command当旧轮原件，不与旧报告拼成同轮证明，不补造丢失原件或改旧报告。准确会话中无可见Java/LSP分析调用，不据此补造静态分析事件。

1. 当前41–69行Java文本块改Java11普通字符串组合，保持去共同缩进后Groovy逐行内容、内部缩进和末尾换行，不改生成工程逻辑。
2. 当前31行宿主HexFormat改Java11标准库等价SHA-256编码：UTF-8所得32字节按正值输出64位小写十六进制并保留前导零，继续`value:`；原null→`absent`、空串→`empty`分支不动。可用正数BigInteger与`%064x`，不加依赖。生成Groovy第52行同名API不属于此次宿主编译错误，保持不动。

五键、三模式、stage/断言、observe、异常/finally、home/cache全部不变。两处载荷/指纹语义等价性仅内部检查，无独立修复成果/Result/消费者，不加框架、自证、矩阵、短进程实验；编译通过不算完整验收。不重建测试，不改根桥接/bootstrap/Check/生产/其它fixture/配置/源码级别/JDK/依赖/用户配置；需要两处以外实现纠正即停止，旧“必要承载”不扩大当前源码权限。

### 原调用和全部共同验收保留

未来沿[已纠正实际调用](../../../build/recover-isolated-gradle-proxy-validation-20261027-g1/junit-command.json)保留有序五路径单-P为一个argv元素，不重取/拆分/重排/规范化/换-D。原Microsoft17/Gradle9.4.0/cwd/source-home、精确JUnit selector、offline/configuration-cache/build-cache/no-parallel/max-workers及其余参数语义保持，不再找工具链。其它写拥有只限原授权薄驱动、合成来源/真实小工程/新classes/参数/日志/XML/报告等未来另一全新build输出根，必要输出重定位不影响来源；无现存新ref，不改旧证据。实际compiler版本未测及中文日志部分不可恢复限制保留，不增compiler取证前置或重复诊断。

唯一终态为两处必要纠正后的全部原未完共同传播/恢复/隔离成功；[原VERIFY](waves.md#verify-isolated-gradle-proxy--共同实际传播与隔离)、旧单-P恢复与[原完整共同标准](#同一完整终态证据与停止)继续有效，不减下列任何义务：

- 原精确JUnit全部必需案例真实成功、真实数值Gradle exit0、当前XML和实际tests/failures/errors/skipped及本轮源码/classes/worker/输出关联；不预报计数、不以skip/缓存/编译/旧Check代实际执行。
- 默认TestKit daemon、显式withTestKitDir加私有-g、withDebug(true) embedded三模式，worker→nested五键三态/一致性/真实home；原HTTP/HTTPS/bypass/空host-port/Properties/凭据排除/错误合同。真实来源变化/删键/删文件/随后未配置无残留，synthetic stage不代真实删除；embedded正常和预期异常finally恢复、同worker后续未配置均须有证。
- 本轮新javac持久bootstrap输出运行真实无游戏独立私有-home小build；目的环境改写前保存来源，六参顺序/原309项有序classpath/完整原arguments-file保持，五键/home、正常和异常/参数/样本oracle错误传播及恢复完整。已采用ARGFILE Check不能代本轮真实build/classes。
- 原十个入口的适用静态归属（含binding ordinary/pipeline fresh-home）已核；新增代理探针使当前真实入口至少第十一个。该旧静态结果不代表全量清单或动态传播；按源码/版本适用性复用，不重复清点。原offline/configuration/build cache/output/tmp/fresh-reuse/私有home隔离/脱敏及凭据不转发保持；不称五模块全跑、逐请求路由或Neo成功，不加探针、不重跑根/bootstrap。

历史保留的原合同曾以G-ISOLATED-GRADLE-PROXY-JAVA11-VALIDATION为完整谓词；当前不再等待或释放该旧gate。原图连接、原VERIFY与单-P恢复两次旧failed、最新Java11恢复failed、已完成单-P及完整合同均保留，不由A新item回填。A当前图只在Waves：一个新item/新Handler/完整独立Result和单成员Wave，根/bootstrap原成功item及Wave gate为真实前置，不等任何旧共同failed/旧gate变成功或自己/消费者。仅换接Neo、V/H共同输入、对应Wave及最终合取；Neo其它三修复/G-REPAIRS/至多一次及三次旧failed不变，V/H十二项/参数/完整M/fresh三模块/Forge类/根入口/不同Handler独立验收不减。

共享JUnit/编译与Gradle/TestKit/build/fixture/cache/相关输入写运行仍串行，新根不证明无冲突。未来普通即时相关身份/资源和真实退出/输出保全保持，本次不采样进程。真实失败/unknown/缺证/覆盖未定或越界立即停止保全，不自动重试或预报修复必过；不增命令审核/控制器/全量快照/daemon门槛。本次不执行或释放消费者。

### 作者自检与不同Handler局部复核界面

作者自检限本增量的单一完整谓词、两处修复权限/行为不变、三次共同失败/单-P已完/原完整标准保留、根/bootstrap真实前置、新item/独立Result/单成员Wave/gate、Neo/V/H必要item/Wave/最终合取、局部联合等待无环/无自等和四文档互链。实际写后检查在本次Result报告，不重审无关全图或借旧自检作本轮证据。

一次不同只读Handler局部复核界面限四文档本增量、诊断采用限制/两处修复边界、三次共同失败及原item/Wave/gate保留、单-P/原调用语义、新完整恢复与根/bootstrap前置、Neo/V/H必要连接/局部无环/共享冲突/停止。未变权威、已采用根/bootstrap成功及其它分支/Neo其余合同/V/H十二项不重审、不重跑。本作者不派发/模拟复核，自检不是ready、实施、采用或gate释放。

下节单-P恢复及其作者记录仅为前次准备时点；单-P已完成且恢复g1随后failed，不能把“唯一纠正候选/必要承载”作当前待办或扩两处权限。原全部共同验收仍有效，本节仅替代现行恢复身份和剩余写拥有。


## 共同代理验证的单参数恢复策略与作者自检

### 范围、保留效果与唯一纠正

本轮是一个四文档局部安排终态，匹配[Work](work.md#共同代理验证失败后的最小恢复维护)、[Context](context.md#共同代理验证g1失败与限定诊断采用)和[唯一Waves](waves.md#共同代理验证未完验收的恢复连接)。原四项串行实施已确认，根剩余缓存恢复及bootstrap ARGFILE完整结果／gate已由Router采用满足，仅作为已采用前置，不重跑。原共同g1 failed及旧gate不满足永不回填；下文旧“尚未确认／拟新增／均未执行”保留原准备时点。本轮不实施或重试，未来恢复仍需合法授权、两项真实前置及对应Wave gates，作者准备不替代这些条件。沿用PRD／隔离ADR／Mixin Spec及[内部代理Spec](../../spec/isolated-gradle-test-proxy.md)的reuse判断，全部权威写入skip，无新产品／架构行为。

[原失败报告](../../../build/verify-isolated-gradle-proxy-20261027-g1/report.md)记录唯一Gradle9.4.0数值exit1，在runtimeClasspath→compileJava.javaCompiler的languageVersion11发现前失败，Test/JUnit执行0、无当前XML；不能填成JUnit通过。新`minecraft-codev-forge/src/test/java/net/msrandom/minecraftcodev/forge/IsolatedGradleProxyTests.java`已写但未编译，是当时仅有的JUnit承载；[原十入口静态归属](../../../build/verify-isolated-gradle-proxy-20261027-g1/entry-attribution.md)按当时源码/版本适用性复用，只支持原十项。现已另发现代理探针入口，当前总数至少11；不由原静态Result证明动态传播或完整清单。正常Gradle写入项目.gradle、configuration cache stored、problems report、原私有home daemon/cache是既发生副作用，不声称失败零写入，不清理或覆盖。

未来唯一调用纠正候选以[共同失败命令](../../../build/verify-isolated-gradle-proxy-20261027-g1/junit-command.json)为基底，从[首次D实际invocation](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)逐字取完整原顺序列表，恢复为**Gradle CLI的一个完整argv元素**（在-jar所指CLI之后，不作JVM选项）：

`-Porg.gradle.java.installations.paths=D:\Applications\Scoop\apps\zulufx8-jdk\current,D:\Applications\Scoop\apps\intellij-jbr11-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr17-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr21-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr25-sdk-jcef\current`

不裁出11、不拆分／重排／规范化五个路径、不把shell引号当值。原Microsoft17启动器、Gradle9.4.0、cwd `E:/Projects/cloche/minecraft-codev`、source-home `build/recover-root-test-proxy-check-20261026-g1/source-home`、精确selector `:minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.IsolatedGradleProxyTests` 和原 `--offline --configuration-cache --build-cache --no-parallel --max-workers=1` 及其它原参数语义保持。仅将本次init／证据属性所需输出路径、classes、日志／XML／独立小工程等重定位到未来另一全新本项build根，不覆写旧输出或把新根当已存在证据。来源home不因输出迁移被替换，不把它与合成／目的私有home混同；原source-home配置缺失不补写。

Forge Test既有gradleProperty→同名worker系统属性接线继续消费该-P，Test17和fixture.gradleJava角色不变；它不证明所有nested入口已取得工具链。不得另加全局-D或推广到全部nested／bootstrap，不扩五键读取器为工具链配置器，不安装／下载／更换JDK、不改用户home／配置／依赖。原路径存在与release声明只支持输入候选，不是Gradle识别、可执行或选中compiler证据。

### 同一完整终态、证据与停止

新恢复仅建立原共同完整传播／恢复／隔离谓词，一个新item／Handler／独立Result／单成员Wave；Java11实际发现并越过旧边界只是该验证内部进展，不产生另一个独立恢复item或验收。原成功标准见[原共同item](waves.md#verify-isolated-gradle-proxy--共同实际传播与隔离)和下文共同验证安排，保持：

- 原精确JUnit实际全部必需案例执行且成功；保存真实Gradle数值exit0、当前XML和真实tests／failures／errors／skipped计数及源码／classes／worker／输出关联，不预报测试数，不以shell0／skip／旧Check代共同结果。
- 默认TestKit daemon、显式withTestKitDir加私有-g、withDebug(true) embedded三模式的worker→nested五键三态／一致性及实际home；原HTTP／HTTPS／bypass／空host-port／Properties／凭据排除和错误义务保持，源变化／删键／删文件／未配置后无残留，embedded正常与异常finally恢复及随后未配置调用均要证明。现有synthetic stage不自动证明来源文件删除。
- 本轮新javac输出的持久bootstrap执行真实无游戏独立私有-home小build；来源在目的环境改写前保存、六参顺序、完整有序classpath／原arguments-file、五键／实际home、正常和异常／参数／样本oracle错误传播及恢复都保留。已过ARGFILE Check是输入，不能代真实小build或本轮classes。
- 已核的原十入口静态归属含binding普通和pipeline fresh-home；当前新增代理探针使总数至少第十一个，不宣称完整清单恰为十。

必要测试承载／薄驱动仍仅限原已授权共同验收，不扩大源码权限，不重写已新增JUnit或重复静态归属；若原验收确需补齐其原授权内必要接点，保留已有有效实现并在同一完整谓词中说明差异，不能顺手修根／bootstrap／生产。所有共享Gradle／TestKit／build／fixture／cache写运行按现有规则串行，普通即时相关冲突、身份及退出能力条件保留；本次不采样进程。真实失败、unknown、缺证／覆盖未定或需要越界实现纠正立即停止保全，不因已定位遗漏参数而承诺通过或自动重试。不新增验证矩阵、命令预审、控制器、快照、daemon门槛、短进程实验或额外前置。

只有新完整Result足证据／completed并由Router完整采用、新gate判定满足，Neo和V/H才能在其全部其余条件成立时消费；本次未执行／未放行。仅换接实际直接消费者的共同验证输入和对应Wave gates／最终合取，Neo的G-REPAIRS／其它三修复与未来至多一次／累计三次failed不变，V/H十二项、参数／M、fresh模块／Forge类／根入口及独立验收不减。旧共同item及Wave完整标准、g1失败／缓存副作用／JUnit未编译保留，新成功不释放旧gate。

### 作者自检与一次必要局部独立复核

本次作者检查仅核新增单一完整谓词、原标准与失败／已写效果保留、原两项／两gate真实前置和新单成员Wave、Neo/V/H必要直接连接／最终合取、无自等或新增等待环、四文档互链与新增仓内引用适用；具体写后结果由本次Result报告，不重审无关全图。本维护与未来验证各自只有一个终态，参数纠正、必要承载及内部Java11进展都不是独立成果。原共同item正文／Wave行除新增历史说明外保留，消费者其余合取不变。方法只用PowerShell纯文本，未用LSP，未运行java／javac／Gradle／测试／网络／进程诊断或Git。

一次必要不同只读Handler局部独立复核边界：四文档本次入口与本节；原g1失败／JUnit已写未编译／缓存副作用和单-P来源；新恢复item／独立Result／单成员Wave／gate等价承接原全部验收、原根／bootstrap前置；Neo及V/H的必要item／Wave／最终合取连接、串行／停止规则及无新增等待环。不重开已采用根缓存／ARGFILE成功或未变权威、未变分支／全图；本作者未派发或模拟该复核，自检不是ready、实施、Result采用或gate释放。


## 独立bootstrap未完验证策略与作者自检

**当前已采用结果（非本次运行）。** `execute-bootstrap-argfile-validation` generation1 的完整关联 Result 已由Router采用为completed，对应现行bootstrap前置及新gate已采用满足；[实际报告](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/report.md)关联保留的两源码、双JDK原生argfile及当轮新classes，[javac退出码](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/javac.exit.txt)和[原`-ea` Check退出码](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/check.exit.txt)均为`0`，[原Check输出](../../../build/independent-testkit-bootstrap-argfile-20261027-g1/check.stdout.log)为其既定合成检查的`PASS`，并明确`no Gradle build launched`。范围仅为保留源码编译及原合成断言；未建立真实上游保存来源时序、真实六参main／私有Gradle build／代理传播、独立CodeSource实测或外部观察器恢复验证，不替代共同验收。 本次仅维护既有采用记录，不重新运行或释放gate；下述方法、完整标准及作者自检保留其原准备时点，“未来／仅安排／未运行／才可能”不再表示本项待执行，不授权重跑；旧partial、failed、unknown及旧gate不改判。

### 当前范围与最小恢复方法

匹配[Work](work.md#独立bootstrap-partial后的未完验证维护)、[Context](context.md#独立bootstrap-partial与冲突诊断采用边界)及[唯一Waves](waves.md#独立bootstrap未完验证的现行连接)。原四项串行实施范围已由用户确认；本Handler只维护四协调文档及作者自检，不实施、不重求未变许可。沿用原PRD／译本、隔离ADR、Mixin Spec／译本reuse评估和内部[代理Spec](../../spec/isolated-gradle-test-proxy.md)的来源／五键／失败／隔离合同，owner仍根构建测试基础设施，权威写入skip，无新产品或架构决定。

保留原ADD generation1 partial、两份已写源码、原预检exit1和javac／Check各零启动／无退出码事实；旧完整谓词及旧gate不满足不改。其后execute-bootstrap-validation-recovery generation1 failed及包装PowerShell exit1、javac真实退出unknown、Check未启动也永久保留；该次准备已有目录／命令／日志等输出，不记为整段脚本零副作用。旧恢复item／Wave现为历史，不以其成功或旧gate释放为新恢复前置。恢复只读取现存 `tools/testkit/PrivateGradleRunner.java` 与 `PrivateGradleRunnerCheck.java`，不重写源码或另建解析器。未来写拥有仅另一全新build证据根的classes、原Check合成根及必要命令／日志／报告；不覆盖旧空classes、旧报告或采样，不改生产／工具／配置／缓存／历史脚本／Git。根代理缓存恢复已通过，不重跑。

**调用纠正边界（仅安排，未运行）。** 原[failed报告](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/report.md)、[javac-command.json](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/javac-command.json)及[testkit-classpath.txt](../../../build/independent-testkit-bootstrap-validation-recovery-20261027-g1/testkit-classpath.txt)是参数来源：JDK固定 `D:/Applications/Scoop/apps/microsoft17-jdk/current`，javac executable取原JSON；其实际cwd为 `E:/Projects/cloche`（原参数为绝对路径，继续保留该cwd），Gradle安装仍为 `C:/Users/WINDOWS/.gradle/wrapper/dists/gradle-9.4.0-bin/lcvyxq3t37f6mx9miaydrrgs/gradle-9.4.0`。原309项classpath顺序逐项沿用，分号连接后41288字符且与原argv[3]相等；不得改通配符、排序重算或重建依赖集合。超长参数移入JDK17原生参数文件，javac与Check的java均如此，不只修编译调用。

编译argfile保留原有序token：`-encoding`、`UTF-8`、`-cp`、原309项分号连接的**单个参数**、`-d`、本轮新classes绝对路径、原两份源码绝对路径；唯一实质参数改动是输出根重定位。Check argfile保留 `-ea`、`-cp`、本轮新classes加分号再加原309项classpath的**单个参数**、`PrivateGradleRunnerCheck`、本轮专属check合成根、上述实际Gradle安装，顺序不变；新classes不能被旧同名输出替代。两参数文件与必要命令／日志／报告均只写本项另一全新build输出根（args、classes、check），旧根所有文件仅读、不覆写，不原样重跑整段旧脚本。

每个argfile按JDK原生语法正确引号／转义：整个classpath token加双引号，路径可用等价正斜杠，保留反斜杠时按argfile规则转义，引号不能变成参数内容；不得直接把逐行jar列表当作argfile或拆成多个 `-cp` 值。文本编码须兼容所选JDK17参数文件解析，原ASCII路径可无BOM写入；`-encoding UTF-8`源码选项、Check内部UTF-8列表及完整单参数不变。进程命令行只携带短的 `@参数文件路径`，作为单一实参传给明确的javac.exe或同JDK java.exe，java的该实参置于主类之前供launcher展开；不是PowerShell数组展开，不交shell再展开classpath。实施者构造必要命令及参数文件属于普通实施，不增加预写argv审核、短进程实验、预热或其它验证门槛。

保存实际参数文件／调用、JDK／源码／classpath顺序、新classes／加载来源、必要输出及真实数值退出码。正常本机调用返回后立即保存该进程的 `$LASTEXITCODE`，启动异常或包装shell exit1绝不代javac/java数值退出；可用普通输出捕获，不新增控制器。仅实际javac exit0并关联本轮classes后运行原 `-ea` Check；真实编译／断言失败、启动异常、相关unknown或冲突即停保全，不追加修源码、重试矩阵、自证或预热。编译与Check只服务同一未完bootstrap验收谓词，既不重做已写源码，也不形成独立工具成果。

完整成功标准不变：六个有序必需参数 `<source-gradle-user-home> <project-dir> <gradle-installation> <testkit-dir> <plugin-classpath-file> <arguments-file>`，目的home改写前保存显式来源；UTF-8逐行有序classpath及完整单参数不重排。标准Properties五键仅为 `http.proxyHost`、`http.proxyPort`、`https.proxyHost`、`https.proxyPort`、`http.nonProxyHosts`；HTTP／HTTPS四键、bypass非空／缺失／空、空host／port、无文件／无键、转义、无关／合成凭据不转发均按原Check；缺来源、读取／Unicode解析错误和未决显式覆盖真实失败而不直连降级。A→B→删键→删文件连续重读无残留、Invocation原异常身份保全／finally恢复、同JVM后续未配置调用及显式覆盖冲突停止仍全部必需。Check通过也不替代真实私有build／共同三模式传播或未来入口接线。

资源核对依实际命令：只读两源码／JDK／有序classpath／Gradle安装，写本项新classes及Check合成source-home／destination-home／project、plugin目录／列表文件及其JVM System状态。原Check仍配置真实GradleRunner，但替代Invocation不调用build；唯一错误五参main在build前失败。不得因任意daemon存在或默认日志缺失另加门槛，不推断daemon空闲；不再调查历史daemon。实际共享编译／Gradle／TestKit／build写冲突、对上述输入的并发变更及输出写拥有不明仍须串行／停止，不能因新根或“不发起build”允许并跑。

恢复的完整独立Result须把保留两源码与本轮实际javac／Check关联，逐项说明原完整标准、真实退出／断言、来源／classpath／新classes适用性和未到达边界；只有该Result completed且足证据并由Router完整采用，才可能满足Waves的新恢复gate。旧partial、原恢复failed与两级旧gate绝不自动改判；现行仅由ARGFILE-VALIDATION的新单成员Wave／gate承接，原恢复不作成功等待；共同VERIFY与V/H在直接bootstrap输入、所属Wave和最终合取换新结果，其余根恢复／共同传播／十二项／fresh／独立验收保持。执行图只在Waves，不在此复制成员或调度序列。

### 作者自检与必要局部独立复核

**本次argfile增量作者自检。** 已以PowerShell纯文本写后回读四文件；本次替换逆向还原后与各自写前全文逐字相等，确认未触及所列局部段／历史状态注记／新item及Wave／9行必要直接连接以外的内容。原完整成功标准段、原ADD正文及原ADD Wave行逐字保留；旧恢复原正文／gate合同保留并明确generation1 failed、javac退出unknown及Check未启动。静态检查新item唯一定义／单成员Wave／唯一gate，无item前置／无Wave前置／不自等／不等待下游或旧failed转成功，三个直接消费者的item、三个Wave及最终合取只替换bootstrap身份，其它条件未变；新增仓内来源引用可读，未写仓外Result路径。原classpath309项、分号连接41288字符与原javac argv[3]完全相等已纯文本核对；编译／Check双argfile、单一-cp参数、输出新根及原标准覆盖已对照。这是局部增量及联合等待检查，不重审全图或根因。

必要不同Handler局部独立复核仅覆盖Work／Context本次入口、Plan双argfile语义与原完整标准保留、Waves新恢复item／单成员Wave／gate、旧partial及failed保留、共同VERIFY与V/H的9行必要直接连接。关注不新增审核／实验／daemon门槛、不移除真实冲突／相关unknown／失败停止、不等旧gate及下游，保留十二项／fresh／独立验收；不重开已核资源规则、根恢复或全图。本作者自检不等于该独立复核、ready、实施成功或gate释放；未运行javac／java／Check／Gradle／网络／进程检查／Git／LSP，不派发或执行。

**以下为前一次未完验证安排的作者自检历史，不代表本次argfile独立复核或运行。**
本轮作者检查限原partial／诊断／现存源码和内部Spec支持的上述未完边界，恢复唯一单结果及单成员Wave、实际写拥有与停止规则、共同VERIFY和V/H的直接item／Wave／最终合取连接；其余图与历史不重审。 已实际以PowerShell纯文本完成：四文档写后逐字回读；逆向移除本轮新增段／状态注记／单成员Wave并还原9行直接连接后，与内存中的写前全文逐字相等，确认其余历史及图未改；原ADD完整正文及旧Wave原行保留。增量断言通过唯一新item／唯一单成员Wave、item和Wave均无前置／无自等、共同VERIFY及V/H三个item输入和三个Wave新gate连接、仓内新引用存在且可读／无仓外Result定位器。新叶子无反向等待且原图其它边未改，未引入局部联合等待环；这不是全图独立复核。首轮静态断言误将旧gate原文预期为另一措辞，exit1；读取实际旧行并纠正断言后exit0，未为迎合断言改旧gate。未运行javac、Check、Java、Gradle、进程／daemon诊断、Git或LSP；没有新动态通过证据。必要不同Handler局部独立复核也只覆盖本节及Work／Context新入口、Waves新恢复item／Wave／gate、原ADD保留和三个消费者必要连接：原完整标准无削减、无旧partial成功等待／自身gate／根恢复重跑、无凭daemon／缺日志伪门槛、无真实冲突串行豁免。作者自检不是该独立复核、ready、实施完成或gate释放，不派发后继。


## 缺失配置输入的最小修复与作者自检

### 首次D外层输出例外与唯一剩余恢复

**当前已采用结果（非本次运行）。** `execute-cache-restore-new-log` generation1 的完整关联 Result 已由Router采用为completed，对应现行根前置及新gate已采用满足；[实际报告](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/report.md)记录恰好一次直接Gradle调用、无重试，[数值退出码](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/exit-code.txt)为`0`，[当轮日志](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/gradle.log)第15／402行分别为`Reusing configuration cache.`／`Configuration cache entry reused.`。第393行Test为`UP-TO-DATE`，只证明该次配置缓存复用及真实exit0，不计作新Test执行，也不证明恢复后Test动作重新执行。 本次仅维护既有采用记录，不重新运行或释放gate。

**以下保留原单次调用安排、验收谓词及作者自检；“剩余／尚未执行”等仅属当时，不再授权重跑。**首次D已通过的业务结果作为输入，controller原始`exit0/outputDrained=false`、collect1、stored而非restored、第二次零启动及原failed全部保留；不补造收束、不回填旧gate。

**最小执行安排。** `RECOVER-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER` 只执行一次与[首次D完整真实invocation](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D/invocation.json)相同的进程调用。该来源实际给出的 executable 是 `D:\Applications\Scoop\apps\microsoft17-jdk\current\bin\java.exe`，cwd 是 `E:/Projects/cloche/minecraft-codev`，arguments 逐项如下；只替换输出去向为独立新日志位置，不能覆盖历史D或收据；不经私有`collect.ps1`/`run.ps1`验证链，不改源码、脚本、用户配置、缓存或依赖。

```powershell
$cwd = 'E:/Projects/cloche/minecraft-codev'
$logPath = 'build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/runs/D-cache-restore-direct-20261026/gradle.log'
$gradleExecutable = 'D:\Applications\Scoop\apps\microsoft17-jdk\current\bin\java.exe'
$gradleArguments = @(
  '-Xmx64m'
  '-Xms64m'
  '-javaagent:C:/Users/WINDOWS/.gradle/wrapper/dists/gradle-9.4.0-bin/lcvyxq3t37f6mx9miaydrrgs/gradle-9.4.0/lib/agents/gradle-instrumentation-agent-9.4.0.jar'
  '-Dorg.gradle.appname=gradle'
  '-jar'
  'C:/Users/WINDOWS/.gradle/wrapper/dists/gradle-9.4.0-bin/lcvyxq3t37f6mx9miaydrrgs/gradle-9.4.0/lib/gradle-gradle-cli-main-9.4.0.jar'
  '--gradle-user-home'
  'E:/Projects/cloche/minecraft-codev/build/recover-root-test-proxy-check-20261026-g1/source-home'
  '--daemon'
  '--configuration-cache'
  '--build-cache'
  '--info'
  '--console=plain'
  '--stacktrace'
  '-Porg.gradle.java.installations.paths=D:\Applications\Scoop\apps\zulufx8-jdk\current,D:\Applications\Scoop\apps\intellij-jbr11-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr17-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr21-sdk-jcef\current,D:\Applications\Scoop\apps\intellij-jbr25-sdk-jcef\current'
  '--offline'
  '--init-script'
  'E:/Projects/cloche/minecraft-codev/build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/observe.init.gradle'
  ':minecraft-codev-forge:test'
  '--tests'
  'net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments'
)
Push-Location $cwd
try {
  New-Item -ItemType Directory -Force -Path (Split-Path -Parent $logPath) | Out-Null
  & $gradleExecutable @gradleArguments *> $logPath
  $gradleExit = $LASTEXITCODE
} finally {
  Pop-Location
}
```

该数组逐项复现来源 JSON 的 `arguments`，包括隔离`--gradle-user-home`、版本/JDK/cwd、offline、configuration/build cache、init/observer路径和测试selector；`$gradleExit` 紧接进程调用捕获，不能以目录创建、PowerShell包装或日志收集结果代替。调用前仅做普通共享构建冲突检查，并确认现有版本/JDK/cwd/隔离home、源码和来源缺失等输入未被随意改变；不要求或追查历史daemon身份、idle或固定PID，允许Gradle正常选择/启动daemon，不杀其它进程。该日志路径只属于本轮，安排本身尚未执行。

**唯一验收谓词。** `$gradleExit -eq 0` 且本轮日志明确出现configuration-cache restored/reused事件才通过。`stored`、失效重配、仅任务缓存、仅`BUILD SUCCESSFUL`、未知退出码或无恢复日志均不通过；Test允许`UP-TO-DATE`，但不声称缓存恢复后动作重新执行。一次调用失败、未知或缺证即停止，不追加重试、第三次、清缓存、依赖下载、daemon取证或私有收集器检查。

旧A/B/C/E、首次D和所有failed/partial/blocked/unknown及旧收据仍按对应版本保留；共同VERIFY/V/H继续消费同一item/gate，bootstrap、Neo、参数/M及其它验收不因本次裁减删除。本Handler不释放gate。

**局部作者自检。** 只核对规则短而明确、恰有一次直接Gradle调用、真实exit码和恢复日志是唯一门槛、历史记录保留、直接调用消费稳定输入、下游item/Wave连接一致；不做字段枚举、历史daemon链、旧收集器判断、全图链接检查或运行验证。

**以下为此前两次D、收集器和daemon接续方案的历史记录。**

沿既有固定槽办法，在任何剩余调用前完整保全首轮runs/D及根state原内容，原路径→D-first移存对应仅在新报告说明，原收据、旧报告/failed/false及未知输出内容不改；不得写伪造passed替代原final-association-check或将state冒充许可。随后仍只用原固定runs/D槽，不能覆盖未保全首轮，不移动项目Test/缓存输出；剩余调用的正常输出照原合同。本Handler未移动或写入任何证据。既有方法的原“全部drain后移存”门槛仅对这次外层完整性采用用户例外，不能将实际未完整drain记成完整保全了未知输出。

启动前依既有方法关联首轮daemon268860的完整身份：创建2026-10-26T23:44:05.395004+08:00、parent298772、executable/完整argv、版本/JDK/home与首轮日志；紧邻启动核对同一实例、当前idle/共享排他，剩余调用实际输出再次关联。不是只看PID或历史idle；关联不成、新unknown/冲突即停，不启动、不换daemon、不增加诊断/检查调用。唯一第二次须本轮真实configuration-cache restored hit并排除仅stored/失效重配/discarded，client0/controller0、完整输出和两层双流drain全部真实通过。Test可UP-TO-DATE，不算新Test，不要求或虚构worker/JUnit/执行期重读，不用首轮材料替第二次证据。任一缺证/新失败/unknown/无hit停止，第二次结束后无论结果如何停止；不重试、第三次、rerun-tasks、清禁缓存或扩工具。

**两处入口前置判断的精确适配边界（仅安排，尚未实施）。** [实际run.ps1](../../../build/recover-root-test-proxy-missing-input-new-daemon-20261026-g1/run.ps1)第12行以D-first/round.json识别第二次；第19–22及175行的共享 `Assert-Complete` 默认行为保持不变，`previousController`、`previousClient`、首轮client及其它调用继续要求可解码的 `exitCode` 数值和 `outputDrained=true`。仅在 `$secondD` 分支读取首轮 `controller-completion.json` 的这一精确调用可采用一次性局部例外；若实现需要窄参数，它只能由该调用显式启用，不改变共享默认值或其它调用。该收据的已知字段不得缺失且类型/值须与现存首轮一致：`phase` 为字符串 `round`，`startedUtc`/`endedUtc`/`stdout`/`stderr` 为非空字符串，`elapsedMs`/`pid`/`waitLimitMs`/`drainLimitMs` 为数值且 `pid=264452`、`waitLimitMs=1800000`、`drainLimitMs=5000`，`exitCode=0`，`launchError=null`，`timedOut=false`；唯一接受的例外是 `outputDrained=false`。缺字段、类型/值矛盾或未识别新增字段影响判定时拒绝，不能只凭 `status` 或自然语言放行。第178–179行的首轮 `final-association-check.json` 也只能在同一 `$secondD` 局部路径按字段判定：顶层 `status` 必须是字符串 `failed`，`checks` 必须是对象且以下16个布尔值逐一为 `client0=true`、`clientBothStreamsDrained=true`、`controller0=true`、`controllerBothStreamsDrained=false`、`noTimeoutOrCaptureError=true`、`actualTestExecuted=true`、`junitExactly1_0_0_0=true`、`nineXmlLinesMatchStdout=true`、`startupWorkerFiveKeysAndExclusionsAbsent=true`、`sourceMissing=true`、`fiveKeysAllMissing=true`、`sentinelAndExclusionsAbsent=true`、`seedBridgeObserveWorkerOrder=true`、`configurationCacheStored=true`、`configurationCacheRestoredHit=false`、`configurationCacheDiscarded=false`；其余顶层字段必须保持 `firstCompletePredicate=false`、`secondLaunches=0`、`firstLaunches=1`、`secondNotAuthorizedByFirstOutcome=true`、`gateReleased=false`，`firstDirectoryNotMoved` 为字符串 `runs/D preserved in place because full closure predicate failed`，且 `decisiveFailure` 必须精确等于 `controller-completion.json outputDrained=false; collect process exit1`。只有这组字段完整且唯一失败原因成立时，才把已接受的首轮外层例外用于该次前置；任何缺失、新增矛盾、其它失败原因或任一布尔偏差都停止。该局部判定不把汇总 `failed` 概括成放行，不改输出收集、等待或排空逻辑，不改原false/failed收据，不重跑首轮；第二次自身client0/controller0、真实restored hit、完整输出及两层双流drain仍完全必需。两处适配属于该唯一剩余调用的实现边界，不是本次已完成的工具修改；本次不改run/collect、不改旧证据、不另造入口、不绕过其它检查，不判ready。

**完整根谓词与必要连接。** 已修单行/原输入跟踪及旧A限定关联/B/C/E有据适用∧首轮实际Test/五键/新worker/JUnit与client0/完整drain及其它原义务∧仅首轮外层输出完整性的明确例外（controller0/drain=false及failed永久保留）∧首轮原材料保全/缓存键稳定∧唯一第二次真实restored hit/client0/controller0/完整输出/两层drain∧同一daemon268860实际关联，且未来按本节两处适配将原drain=true与status=passed硬门槛分别替换为“已接受例外＋其余真实义务检查”，足证据新独立Result被Router完整采用后才可能满足 `G-ROOT-TEST-PROXY-CACHE-RESTORE-REMAINDER`。两处适配不改变输出收集/等待/排空逻辑、原false/failed收据或第二次验收；入口适配尚未实施，不由文档维护宣称已运行。共同VERIFY/V/H在item与Wave两层及最终合取只换该根输入；bootstrap独立、其它前置/十二项/fresh/验收与共享写串行不减，旧failed/blocked/partial及其gate不回填或释放。

**局部作者自检与独立复核范围。** 仅核例外精确性、两处前置适配的实现边界（Assert-Complete的首轮controller drain=true及原汇总status=passed各自只替换为该轮已接受例外与其余真实义务检查）、已完效果/原failed/false保留、唯一剩余调用、缓存键稳定/首轮保全、启动前同实例与第二次完整验收、必要新旧item/Result/消费者两层连接。已完整解码前次 `review-root-proxy-new-daemon-boundary` generation1，复用其未变分层/固定槽/身份方法与连接支持；该局部ready是原时点结论，不覆盖本次两处适配或新身份。不重审已过的源码修复、CDATA/解析、动作顺序、旧成功适用方法或全图；本作者自检不等于不同Handler独立复核、实施成功或gate释放。写后局部静态核对结果在本节末记录。

作者自检记录：已完成写后纯文本定点核验；除 `$secondD` 分支首轮controller的精确局部例外外，共享 `Assert-Complete` 默认值、首轮client/其它调用的 `outputDrained=true` 要求及第二次自身两层收束均保留。对照现存 `controller-completion.json` 逐字段核对 `phase=round`、`pid=264452`、`exitCode=0`、`outputDrained=false`、`launchError=null`、`timedOut=false`、`waitLimitMs=1800000`、`drainLimitMs=5000` 及其余字符串/数值字段类型；对照 `final-association-check.json` 逐项核对16个 `checks` 布尔值、`firstCompletePredicate=false`、`firstLaunches=1`、`secondLaunches=0`、`secondNotAuthorizedByFirstOutcome=true`、`gateReleased=false`、`firstDirectoryNotMoved` 原字符串及唯一 `decisiveFailure` 原字符串。缺失、类型/值矛盾、新增字段影响判定、汇总failed替代字段检查或其它失败原因均拒绝，不把该自检称为入口已适配。四份现行段与历史分界、单次外层例外/原failed及false、同daemon268860/缓存键与唯一剩余item/Wave核对通过；共同VERIFY/V/H的三处item前置、三处Wave gate和最终合取均改接新身份，旧失败item/gate保留；新增19处本地链接及现行锚点可解析。静态确认run.ps1:175/179及相邻断言分别对应首轮false/failed，并确认仅允许替换这两处前置判断，不改收集/等待/排空或第二次验收；未认定适配已实施、入口可运行或gate可释放。未重审已过方法或全图，未运行项目/测试/网络/诊断/进程查询，未改源码/工具/配置/Spec/旧证据/Git；未实施、独立复核或释放gate。

**以下为new-daemon执行前的方案与原作者自检历史。** 原“尚未修复/两次未启动/首次必须完整成功”等仅是当时事实/合同；本次已完效果、单次外层例外及剩余范围以上节为准，旧完成条件和失败事实不追改。

### 目标、权威与许可

匹配[Work](work.md#缺失gradleproperties输入恢复的当前边界)、[Context](context.md#xml恢复失败采用与缺失输入恢复边界)、[唯一Waves](waves.md#缺失配置输入恢复的现行连接)。只恢复已接受[代理Spec](../../spec/isolated-gradle-test-proxy.md)的“明确来源但无文件合法、存在性/内容变化受跟踪、执行期重读、缓存不冻结投影”合同。沿用Context现存PRD/译本、隔离ADR、Mixin Spec/译本reuse及其拥有路径，三族写入skip；内部代理Spec reuse，技术owner仍根构建测试基础设施，不新建产品/架构选择，不虚构PRD个人owner。本Handler只维护四文档；用户已授予的局部源码纠正/验证权限留给后续实施，不由本次执行。

原已采用事实及[仓内报告](../../../build/recover-root-test-proxy-check-xml-recovery-20261026-g1/report.md)保持：XML恢复generation1真实failed，A限定复核及B/C/E通过，D动作前失败，stored不等于restored。旧failed/partial/unknown、A controller1/drained/stop及原限定例外全部保留。下方XML/VALIDATION准备段的“未执行/四轮零启动/同版五轮”只对应其原时点；本节拥有当前恢复策略，不改写旧原验收。

最新 `execute-root-proxy-missing-input` generation1已完整JSON解码：项目结果为 **blocked**，原daemon305908当前无记录，停止时源码/项目文件零修改、首次D和第二次D各0启动、新证据根未创建；无本轮Test、退出/drain或真实hit证据。保留该Result及原item/gate不满足；新daemon接续仅承接这一个未完恢复谓词，由新item/新Handler/独立Result交付，不回写旧Result或用新成功释放旧gate。

前轮 `review-root-proxy-missing-input-repair` generation1对单行修复、一次D、旧成功适用性及必要连接已有局部支持；当时完整根not-ready及后续补调用许可的历史不改判。本轮完整JSON解码 `review-root-proxy-cache-hit-boundary` generation1：其completed及局部ready仅对应此前两次D分层、必要入口适配/固定槽保全和必要连接；这些未变方法复用既有支持，不重审解析或动作顺序，也不将旧ready扩为新daemon边界的独立通过。首次全部原实际Test义务通过/收束保全才第二次；第二次仅真实配置缓存恢复及正常退出/输出收束，允许Test为UP-TO-DATE、不算新Test执行，至多两次及停止条件均不变。用户现唯一改变的是允许Gradle正常启动新daemon且两次新D同实例，不再把历史A/B/C/E接到该实例。本Handler只维护四文档，不实施、不判运行通过/ready。沿用Context权威覆盖评估：代理Spec要求实际Test重新计算/无残留，未要求历史A/B/C/E与新D同daemon或相同输入每次恢复都执行Test；来源、五键、隔离、缓存和其它验收保持，Spec reuse/写入skip。

### 唯一具体输入声明修正（尚未实施）

根[build.gradle.kts](../../../build.gradle.kts)当前第119行位于共同 `tasks.withType<Test>().configureEach`；仅将这一行：

```kotlin
inputs.file(testProxyPropertiesFile).optional()
```

替换为：

```kotlin
inputs.files(testProxyPropertiesFile)
```

`optional()`只允许未提供单文件属性值，不让已指定却不存在的单个File绕过存在性校验；D错误正发生于这个输入声明，尚未进入seed/桥接动作。改成文件集合输入，始终声明同一 `gradle.gradleUserHomeDir.resolve("gradle.properties")` 路径；文件不存在可以快照为缺失，后来创建、删除或内容变更仍改变该输入快照。不得以 `exists()` 条件注册/过滤文件集合、创建空文件、吞读取错误、禁缓存或取消输入声明替代。该方案的Gradle9.4.0运行效果仍待原D实际证明，不把本次文本推理称为测试通过。

触达只限根声明及其正常脚本重新求值；五键白名单、来源File、Properties解码/空值、配置期apply、执行期 `TestProxyPropertiesAction`（仅File/普通映射字段）、清除后重读/缺失return、冲突提示均不改。十runner、JUnit载荷、生产、独立bootstrap、用户配置及缓存策略不改。正常构建脚本重新编译若由D必需则属于这次调用内部效果，不另跑help/compileTestKotlin/准备依赖或重复已通过的独立编译检查。

### 已成功证据的受影响边界与复用判断

A限定关联及B/C/E保存为旧版本真实成功证据；四轮均为来源文件存在（C删键、E空文件），其配置/执行期五键逻辑、载荷和收集方法不因单文件输入改为同一路径文件集合而改变，因此不因根脚本摘要改变一律作废或默认重跑。短检查与CDATA读取也未受影响，不重做。执行前后只需用现有差异/输入关联确认真正唯一语义变化为上述声明，原映射/动作/载荷、Gradle9.4.0/JDK/cwd/同隔离home/参数及来源输入的适用性仍可关联，不能关联即停止；旧材料只读引用，保持A限定复核的特殊条件及原失败收据。旧A/B/C/E与daemon305908的关联仅是历史，不再要求该旧实例当前存在，也不声称它们与新D同daemon；换daemon本身不作废或重跑旧成功，不重新下载准备。

根脚本新摘要及其重新生成的脚本/动作类身份可能变化，不能继续用“15项摘要全部与旧版相同”拒绝预期单行修正，也不能把旧动作类加载说成新类加载。仅对受影响的根脚本/正常派生类关联新旧来源与未改动作定义，沿用已有记录方式，不扩快照、清单或身份框架；其它确有语义/输入/环境漂移则停止并指出哪一项成功证据不再适用，不擅自重跑。原“全部同版五轮”对新恢复明确收敛为“旧A/B/C/E有单行变更的适用性依据＋新声明下D及缓存证据”；这不是四轮在修正后版本重跑通过，V的最终fresh及H独立核对义务仍原样存在。

### 原D一次恢复及必要缓存验证边界（未来安排）

1. **首次调用前固定入口。** 复用已工作的XML/InnerText和有界收集接点，只在另一新build证据根一次性定位必要 `collect.ps1`、`run.ps1`、`observe.init.gradle`、固定cases/start/JDK路径材料；不执行它们的marker/A/B/C/E分支。新副本run的D只读前序指向既有成功E，observer内部证据根及cases.json路径只在这时定位。必要验收适配也须在首次前一次性限定完成：保留首次原实际Test断言，第二次仅据本轮真实恢复和退出/输出收束断言，不要求新JUnit时间或seed/桥接/observe/worker产物；只复用首轮成功收据/既有状态识别两次，不能全局删除原检查、不扩收集器/框架、不加D2参数或输出协议。后续两次均由同一 `collect.ps1 -Stage round -CaseId D` 启动，保持脚本/init/observer/cases路径内容及它生成的Gradle argv相同。D旧失败及最新blocked/零启动是历史事实。首次启动前仍即时核对Gradle9.4.0、原JDK/cwd/同source-home、缓存/内容适用性和现有共享排他条件；不再要求原daemon305908存在，不索取尚未生成的新PID/创建时间/idle，也不先另跑调用预启daemon。允许原Gradle入口正常启动新daemon；首次正常启动后，沿现有身份与日志收据取得该次实际实例的PID、创建时间、parent、executable、完整argv、版本/JDK/home及输出关联，不能只凭PID或历史日志。必要入口适配同时限于该首次实例获取/第二次同实例核对，不新增诊断、工具、检查调用或参数协议。不能取得真实关联、新unknown/冲突/缺证即停并保全材料，不启动第二次，不清理或终止其它进程、不替换daemon重试。现成client/controller收据承载数值exit和两层双流drain，不修 `round.json.client` 或取证框架。
2. **首次D只调用一次。** 单行修复后保留 `build/recover-root-test-proxy-check-20261026-g1/source-home/gradle.properties` 不存在，不创建空来源；精确selector仍为 `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments'`，保留原toolchain参数、`--offline --info --console=plain`、configuration/build cache和seed→桥接→observe→worker顺序。正常脚本重新编译仅随该次调用发生，不另跑A/B/C/E、短检查、help/独立编译/依赖准备、矩阵或rerun-tasks。
3. **首次全部通过才可补证。** D须越过输入校验，实际Test/新worker/当轮JUnit1/0/0/0，五键完整key-set均缺失且无sentinel/合成凭据；来源缺失、五键、首次实际新daemon完整实例、实际client0/controller0、两层双流drain/完整输出同轮关联，且无配置缓存拒绝。UP-TO-DATE/FROM-CACHE/NO-SOURCE/SKIPPED、旧E/XML或配置快照不替本轮D。任一失败/unknown/冲突/必要证据缺失即停止保存，不启动第二次、不自动重试或杀共享daemon。首次仅stored/失效重配不算restored hit，但在其它原D义务全部通过后允许进入这一次已接受的缓存补证。
4. **先保全再复用固定输出槽。** 既有run/collect及observer均写固定 `新根/runs/D`，不能直接第二次启动覆盖；首轮client/controller退出且各双流关闭、全部收据落盘后，将本轮新根的整个 `runs/D` 移存为未占用的 `runs/D-first`，首轮根级state.json一并另存到该目录，保留原始内容。报告注明原路径→移存路径，原收据内路径不伪改，不将移存后的首轮XML当新轮XML；旧证据根不动。第二次由同一入口新建原 `runs/D` 槽，因此init/observer的绝对路径、内容和其固定输出字面量均不变；第二次两层输出/退出/drain收据和真实缓存恢复日志单独保存在该槽，实际有无新worker/JUnit/执行期观察照实记载，无则记未执行/未产生而不补造。移存仅限本次新证据材料，不移动/删除项目Test输出、配置缓存或用户缓存，也不重写init/cases/start。不能完整保全时不启动第二次。
5. **第二次仅一次、只验恢复及正常退出。** 首次第3款全部通过并完成第4款后，再执行同一个 `collect.ps1 -Stage round -CaseId D`；构建脚本、来源缺失、Gradle argv/selector、cwd、source/TestKit home、JDK、首次D实际关联的新daemon实例及所有参与缓存键的init/observer/cases路径内容和环境保持不变，不因证据另存而切换init或加新参数。外层接续以移存的首轮成功收据为条件；紧邻第二次启动重核首次取得的同一完整实例、当前idle/共享排他，第二次实际输出再关联该实例，不以仅PID相同代证。新实例关联不能成立或新unknown即停，不另换daemon/增加调用。run内仍只读既有E前序，不能用E替代首轮条件。须从第二次本轮实际日志确认 `Reusing configuration cache` 等真实configuration-cache restored hit，排除仅stored/失效重配/discarded，并具本轮client0/controller0、两层双流drain/完整输出及身份关联；异常退出/unknown/缺证不通过。Test可为UP-TO-DATE，不算新Test执行；不要求新worker、当轮JUnit或执行期清除/重读/五键观察，不能用首轮XML或旧观察补称这些动作已发生。即使有其它任务复用/执行迹象，也只按真实记录报告，不据此扩大本轮验收结论；本轮恢复/退出证据不能由旧E、首轮或配置快照替代。第二次结束后无论结果如何停止；无真实hit、退出/收束不通过即保留局部效果并按实际结果报告partial/failed，不completed或放行，不自动第三次、rerun-tasks、禁清缓存或扩工具。
6. **限定差异及完整恢复谓词。** 原入口对第二次仍索取新JUnit及动作链的兼容冲突，已由用户明确接受收窄第二次完成谓词解决；未来必要适配仅限第1款，不是已写入口或运行成功。首次UP-TO-DATE/FROM-CACHE/NO-SOURCE/SKIPPED仍不能过实际Test验收；第二次UP-TO-DATE仅不阻断本次恢复/退出判定，不证明新Test、缓存命中后执行期重读或worker属性重新映射。该限定例外不得用于其它轮次、三模式传播、独立bootstrap或V/H自己的fresh运行，实际Test仍受Spec重新计算/无残留合同约束。完整根须：单行纠正/输入跟踪∧旧A限定关联及B/C/E有据适用∧首次D全部原实际Test证据及正常退出/收束∧第二次真实restored hit、正常client/controller退出及完整输出/两层drain∧两次稳定输入/首轮不覆盖保全、旧成功跨版本/输入环境适用性及两次新D同一新daemon的实际关联，全部成立才可供完整采用。不再将第二次新worker/JUnit/执行期观察作为必要项，也不声称这一较强保证已经验证。

根局部源码纠正和必要D回归只服务一个恢复终态，没有独立工具/研究交付。唯一执行图以 `RECOVER-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON` 的单一item/单成员Wave/独立Result承接原缺失输入恢复的未完成边界，Plan本恢复完成需要其 `G-ROOT-TEST-PROXY-MISSING-INPUT-NEW-DAEMON` 满足；完整gate未满足时共同验证/V/H均不放行，bootstrap无根成功前置。原缺失输入generation1 blocked/零源码改动/两次D各零启动、原XML failed及VALIDATION partial的item/Wave/原完成合同保留，不要求旧结果转成功，也不回填旧gate。此次仅作该必要恢复替换，不扩其它图或新增诊断/工具/测试/整组重跑。共享根配置/Gradle/TestKit/build/fixture/cache写运行串行；共同传播、独立小build、Neo/其它消费者实施不在本次恢复。

### 作者自检及最小独立复核范围

**前轮作者自检记录（本轮不重做）：** 当时实际只做PowerShell纯文本读取、指定Result完整解码关联、根声明/相邻既有映射与动作以及D实际错误定点核对；没有另行诊断已知根因、全仓扫描、运行Gradle/Java/测试/网络/进程或Git。对照代理Spec无文件合法/跟踪/执行期重读/缓存合同，确认方案精确落在同一路径文件集合，不更改五键或以空文件绕过；按既存来源文件存在的A/B/C/E与未变映射/动作解释条件复用，新旧版本、stored/hit和历史失败分别保留。

**前轮写后检查记录（保留原结果，不算本轮重验）：** 当时核验四文档当前入口/互链、唯一新item/单成员Wave/判定一致；共同VERIFY、V/H的item前置与Wave gate两层都换新根输入；旧XML/VALIDATION原合同仍为历史，bootstrap无新根前置，新根不等旧failed/自身gate/共同VERIFY，受影响连接无新增联合回环；十二项、fresh V/H、其它分支前置不减。实际写后作者检查已完成：四个新入口逐一回读，新增相对链接21处及其13处片段锚点均存在/可读；受影响5个item定义、5行Wave与局部item子图检查通过，新根/独立bootstrap均无成功前置，3个消费者的item与Wave两层均消费新根，最终合取同步，旧XML failed/VALIDATION partial及原合同保留。中间文本检查发现7处显式gate仍指旧XML及混合换行导致新段未居首，均已局部纠正、按完整新段原文移到标题后并重查通过，无遗留新旧成功等待混用。根源码原单文件声明仍在，未实施。只证明受影响文本/连接一致，不是全图/运行验证或独立ready。

**前轮作者自检记录（保留原时点冲突与检查结果，本轮不重做）：** 完整解码当时指定独立复核Result，只读取四协调文档受影响段、代理Spec及上述既有入口纯文本。对照用户新授权核对首次D全部通过/收束保全才有第二次、至多两次/结束即停；按run/collect固定 `runs/D` 和observer硬编码根/cases，核对先移存本轮首轮材料、同入口复用固定槽而不改缓存键；区分configuration-cache restored hit与Test实际执行，明确UP-TO-DATE路径下原执行期重读证据缺口未解决。写后局部文本检查仅核四文档这些条件、唯一恢复item/单成员Wave/gate、共同VERIFY及V/H两层消费/最终合取和bootstrap独立性一致，保留所有旧成功/failed/partial/unknown；不重审单行修复、复用方法或全图，不把前轮检查数量当作本轮结果。本轮已逐一回读四文档受影响段并完成上述静态断言，三位消费者的item前置/Wave gate及最终合取一致，bootstrap仍独立；受影响段26个相对链接及其中14个片段锚点核对通过。检查曾因要求逐字出现“两次间”的过窄断言停止，改为核对已有两次/稳定输入条件后剩余检查通过，非文档或运行失败；未运行项目/测试/网络/进程/Git，未改源码、Spec、工具、配置或旧证据。

**前轮分层验收作者自检（保留原时点结果，本轮不重做）：** 已完整JSON解码指定前轮作者Result，完整读取代理Spec，并用PowerShell纯文本定点读取/写后核对四文档受影响段及必要连接。对照用户已接受差异，核对首次实际Test/五键全缺失/新worker/JUnit及client0/controller0/两层双流drain全部原义务不减，失败/unknown/缺证不启动第二次；第二次仅本轮真实restored hit、client0/controller0和完整输出/两层drain，允许UP-TO-DATE、不要求新worker/JUnit/执行期观察，不声称证明恢复后Test动作重新执行。复用原首轮整体移存/state保全、同入口/固定槽和稳定缓存输入；必要入口适配仅限本次两层判定，未扩工具或调用。写后局部静态检查通过：四当前入口均无旧第二次强制执行冲突残留，唯一恢复item/单成员Wave/gate及V/H最终合取同谓词，三个消费者item与Wave两层仍引用同一根，bootstrap无根成功前置；14处匹配四文档片段链接可解析。一次初始断言误要求Work摘要逐字包含runs/D-first而停止，改为核对已有整体移存/state及Plan详细约定后完整通过，没有因此修改文档或运行项目。原A/B/C/E成功、failed/partial/unknown和所有旧gate保持原时点，旧作者检查与当时冲突保留为历史。Spec第31/46行覆盖实际Test重新计算/无残留，未要求每次相同输入恢复重新执行Test；本次限定验收不修改该合同，权威写入skip，无需权威调整。未重审全图、CDATA、观察顺序或网络，未读取/修改项目源码、工具、配置、旧证据或Git，未运行项目/测试/网络/进程操作；只证明文档局部一致，不是入口适配已实现、运行通过、独立复核/ready或gate释放。

**本轮新daemon边界作者自检（仅局部静态文档）：** 已完整JSON解码缺失输入执行generation1的blocked及缓存边界复核generation1的completed，读取四协调文档受影响段与内部代理Spec；复用前轮已通过的分层/必要入口方法，不重审源码、解析或动作顺序。写后回读并完成16项局部断言、15处四文档链接/片段核对：首次启动前无尚未生成实例前置，首次正常启动后真实完整实例关联，第二次紧邻启动及实际输出重核同实例；版本/JDK/home/缓存/共享排他与新unknown停止、首次实际Test/第二次真实hit分层/最多两次均保留，旧A/B/C/E仅按版本和输入适用性复用。新恢复唯一item/单成员Wave无旧blocked或后继成功前置，共同VERIFY/V/H的item与Wave两层及最终合取同接新Result/gate，bootstrap独立/共享写串行，因此这些替换连接无新增回环；未重审全图。原缺失输入blocked/零项目写入/两次D各零启动及旧原合同/gate、历史成功与failed/partial/unknown保留，不伪造新历史同daemon连续性，权威reuse/写入skip，无具体冲突。一次写入前唯一匹配校验因V/H相同摘要而停止，尚未落盘；改按原行精确定位后完成必要段写入及上述检查。全部项目读取使用PowerShell纯文本；本Handler仅写四协调文档，未改源码/工具/配置/Spec/旧证据或Git，未运行项目/测试/网络/LSP/进程查询控制，也无独立复核、ready、实际item完成或gate释放。

**受影响的最小局部独立复核范围：** 仅用户新接受的daemon接续边界、首次启动前不要求尚未生成实例/首次正常启动后真实实例获取、第二次同一完整实例核对及停止条件、旧A/B/C/E版本与输入环境适用性复用、缺失输入generation1 blocked及零写入/零D启动保留、新旧item/独立Result/gate的必要承接，以及共同VERIFY/V/H的item与Wave两层根输入和最终合取。前轮已通过的两次D分层、入口适配/固定槽保全、单行修复、CDATA/解析及动作顺序不重审；只核它们与本次边界的必要连接。本作者仅作局部自检，不执行独立复核、不派发/实施、不判ready、不完成实际item或释放gate；其它分支及V/H自身验收不减。

## 根代理检查恢复的执行计划与作者自检

**历史准备记录（XML恢复generation1现已failed）。** 以下现行/未执行/四轮零启动等仅保留当时；最新采用事实、缺失输入修正及后继连接以上方缺失输入恢复节为准，原完成合同及失败不改判。

### 边界与唯一结果

匹配[Work](work.md#根代理检查恢复的当前边界)、[Context](context.md#根代理检查恢复的采用事实与证据边界)与[唯一Waves](waves.md#根代理检查恢复的现行连接)。本轮仅四文档最小维护及作者自检，不实施。原 `RECOVER-ROOT-TEST-PROXY-CHECK-VALIDATION` generation1为partial：[原报告](../../../build/recover-root-test-proxy-check-validation-20261026-g1/report.md)保留收集调整/一次短检查成功/A客户端exit0及JUnit1/0/0/0、控制器exit1/drained和B/C/E/D零启动。新 `RECOVER-ROOT-TEST-PROXY-CHECK-XML-RECOVERY` 一个Handler/独立Result的唯一终态是**保留已修源码/编译、短检查及A的可复用效果，修复限定CDATA解析与A证据关联后接续B→C→E→D，使按用户已接受的A限定证据替代修订后的五轮合取成立**；内部解析检查/恢复关联无独立消费者，不另造工具产品或诊断Result。

原REPAIR failed/编译成功及控制器unknown、WIRE/CHECK失败/旧A局部性和VALIDATION partial/控制器真实失败全部保留，任何新成功不回填旧item/gate。三族及内部代理Spec reuse、写入skip，owner/依据沿Context，不改权威。原收集入口修正及原五轮已授权；用户现已明确接受仅A原始成功证据经完整关联复核后作为本次接续输入，替代A原成功收集的controller exit0且drained条件。此为该单轮证据验收条件的明确修订，不是逐字保持或旧收集通过；业务/运行标准不减，不制造不变范围重复许可，超出此替代或必要关联缺证即停止。

### 未来最小恢复方法（本轮未执行）

1. 仅在**另一新证据根**保留必要收集入口副本/固定cases/observer并调整新输出位置；原VALIDATION及更早证据只读。复用现有收集接点、成功短检查、源码/编译/依赖及原 `build/recover-root-test-proxy-check-20261026-g1/source-home` 正常缓存。不重跑A、短检查、help/编译/下载/依赖准备，不重写等待框架、源码、项目工具或用户配置。observer只迁移输出，不改已支持的观察顺序/五键算法；身份有影响适用性的漂移即停，不自行重编译或补跑。
2. 新控制器副本的唯一解析语义修正为 `$systemOut = [string]$xml.testsuite.'system-out'.InnerText`（原行直接转XmlElement，未读CDATA）。用[既存A JUnit](../../../build/recover-root-test-proxy-check-validation-20261026-g1/runs/A/junit.xml)作**聚焦解析检查**：同一worker正则从InnerText提取PID273156/id1，并与原stdout/身份关联；保留旧表达式不匹配、新表达式匹配的已采用只读结论，不执行旧控制器/原Test。该检查不重放短进程、不声称修好所有收集路径、不生成虚假控制器exit0。
3. **B的限定恢复前置（用户已接受的A单轮替代）：** 新入口显式只读引用旧A完整原始材料，而非默认在新根寻找虚构A成功收据：client/controller completion、stop、JUnit、两路原始输出、seed/observation、client/controller identity、invocation、preflight及关联daemon日志；消费Context已采用只读恢复结论并记录其适用边界。核对client315568 exit0/drained、controller293524 exit1/drained且唯一失败确为CDATA worker误读、JUnit1/0/0/0及worker273156/id1、实际Test执行/五键/来源/顺序/stored无拒绝均同A；遇到另一失败/unknown/缺证即拒绝。原控制器1和stop照实保留，**不要求旧controller变0，不用只看client0的通用放行，不把A提升为collection-level通过**。仅当本条及第4条的完整原始关联复核成立，才以该复核替代A原成功收集的controller exit0且drained条件作为接续输入；这不是仅诊断成功、仅client0或通用收集豁免。当前Assert-Complete只验证数值退出及drain，既不证明成功也不替上述限定消费；未来新入口将B首个前序证据定位到该旧A，后续C/E/D仍读取本次前轮真实完成收据。
4. 原解析失败后未写出的A cache-events/association/daemon副本/source-identity/postflight不得伪称已存在。只在新根从旧原始输出/seed/observation/调用和身份、可关联原daemon日志恢复必要关联，清楚标为只读恢复、保留原时点与恢复时点，不能伪造当时postflight或倒填旧根。同版源码/实际加载/输入/JDK/cwd/home及缓存适用性须有原始依据：A中的来源SHA256不是build源码SHA；编译复用声明不是完整版本身份证明。只能消费可证明的现存材料，若必要关联无法闭合，停止报告；本次接受只替代A成功收集条件，不豁免内容/加载/输入/daemon/缓存等原义务，不重跑A或加轮。
5. **A与四轮同版、同一daemon实例：** 以A invocation/identity/preflight和stdout中的daemon305908及日志为锚，B写合成来源前与紧邻启动时即时核对源码/实际加载/输入适用性、原Gradle9.4.0/JDK/cwd/home/参数/允许缓存，及daemon创建时间/executable/argv/home/日志/当前idle和共享排他；后续各轮同样核对并由实际输出证实。PID相同或历史idle不足；新daemon或无法关联原A即停止，不另开序列、不重跑A。A曾复用编译daemon是已观察事实，不把“新序列daemon”解释成必须另启一只而破坏A复用。
6. 除A已接受的成功收集证据替代外，有界收集合同不减：每个控制器只承载一轮，启动身份、命令/cwd/JDK/home先保存；并发双流持续落盘，Process真实数值exit单独保存，stdout/stderr各自EOF/error/flush-close后才形成drain合取。有限Process/任务等待，按实际工具timeout预留自有树收束、排空和保存余量（原方法示例30+15+10秒，不新增全链预算）；不能无限WaitForExit/GetResult、误杀共享daemon或在unknown时继续。前轮控制器和客户端完整保存/收束后才下一轮；B/C/E/D均须真实client0/controller0、输出完整及各自drained和全部原检查通过，任何非零/unknown/冲突/缺证停止。A的限定解析恢复不推广到剩余轮次或一般控制器错误。

### 原五轮验证合同与必要连接（不重审已通过方法）

总计仍仅A→B→C（删键）→E（无键）→D（删文件）；A只复用本次VALIDATION的原始结果，不用更早CHECK失败A；未来只运行余下四轮。精确selector保持：

`:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments'`。

A五键非空；B五键均存在但变值含空；C保留文件移除既定键；E空文件无键；D文件不存在。原固定cases、五键完整key-set/精确值三态、凭据/无关键排除、seed→原桥接→observe→worker顺序不变。保留 `--offline --info --console=plain`、原精确toolchain参数和configuration/build cache，不调用游戏下载fixture。每轮关联来源存在性/字节摘要、实际Test/worker/JUnit1/0/0/0、五键/顺序、client/controller真实exit/drain、同daemon及缓存事件（仅A成功收集条件按第3–4条限定替代，原1/0及drain照实保留）；UP-TO-DATE/FROM-CACHE/NO-SOURCE/SKIPPED、空报告或配置快照不代Test执行。

stored、真实restored hit、输入变化失效重配、discarded/serialization error分别记录，不以A的stored冒充恢复命中。五轮不能证明原必需缓存/重读关系则缺证停止；不禁/清缓存、rerun-tasks或增轮凑证。本次五轮完成谓词明确修订为：A全部业务/实际运行义务∧A限定替代复核∧B∧C∧E∧D全部原义务∧同版同daemon/收集关联。A限定替代复核即第3–4条完整原始关联：client0/drained、真实Test/JUnit/worker及五键/来源/顺序/缓存有证，controller1/drained/stop仅为已证CDATA误读且无另一失败，双层原始输出完整，源码/实际加载/输入及同daemon等适用性闭合；恢复时点和历史缺失明示、不补造快照。只有这一复核替代A原成功收集的controller exit0且drained条件，不要求旧1变0或追认旧collection-level通过；B/C/E/D各自client0/controller0、完整输出/drain及原检查仍全需。必要关联不完整停止，不把“已成功A”摘要代证，不普遍豁免收集错误。

共同验证与V/H在Waves的item显式前置和所属Wave gate两层改接新完整恢复Result/gate，仍等待bootstrap/传播及各自原完整合取；独立bootstrap无根成功前置。不让旧VALIDATION partial/gate成为新恢复必须先成功的等待，不把新Result填回旧gate；不扩bootstrap、共同传播、Neo或其它消费者实施。

### 作者自检与局部复核范围

本次作者定点自检：完整解码指定局部审查Result，区分唯一阻断（A替代缺接受依据）与已支持的解析、同daemon方法和必要连接；以用户当前明确接受为依据，仅修订A成功收集证据条件。对照Work/Context、本Plan第3–6条和五轮完成谓词、Waves现行item/新gate/现行连接及V/H最终合取，确认均消费同一个限定替代，而非声称原A成功收集条件逐字未变。原VALIDATION partial、controller1/drained/stop、缺失历史快照及B/C/E/D零启动保留，四轮各client0/controller0/完整输出/drain/全部原检查不变，必要关联缺证即停。未执行关联恢复或四轮，未重跑A/短检查/编译准备。



写后纯文本回读并与本次写前文本定点比较：仅四协调文档现行条款及本作者记录有变；旧VALIDATION item/原gate合同逐字保留，item身份、Wave成员和前置列/依赖行不变。未改图结构、未重审联合等待/全图或已获支持的解析、观察顺序、同daemon方法；沿用原审查对必要连接的支持。本自检不代独立复核，不声明ready、实际item完成或gate释放。

**供不同Handler复核的最小变更：** Work当前边界的A例外与四轮标准；Context接受依据和历史/缺失项边界；本Plan第3–6条及修订完成谓词；Waves新恢复item、新gate、现行连接与V/H合取对同一例外的消费。仅审授权落地及完成谓词一致性，不重审原已支持方法/全图；原partial、controller1与缺失快照不得抹除，关联复核及四轮未来仍须实证。本作者未派发或模拟独立复核。
## 统一隔离Gradle测试代理的实施准备与作者自检


### 权威、当前许可与范围

[Work](work.md#统一隔离gradle测试代理的当前准备边界)／[Context](context.md#统一代理已接受范围与第三次neo失败)／[唯一配对Waves](waves.md#统一隔离gradle测试代理的现行连接)共同维护本范围。**仅准备完成；新实施及运行范围未确认，不是ready。** 旧Neo仅运行授权不允许代理/源码改动，也不续用其失败item。图仅在Waves，本文不另列派发序列。

复用已完整采用的权威评估：原PRD及译本reuse既有产品目标、隔离ADR reuse原生命周期决策、Mixin Spec及译本reuse生产合同，全部写入skip；新[isolated-gradle-test-proxy Spec](../../spec/isolated-gradle-test-proxy.md)现存并reuse，owner是根构建测试基础设施。新Spec补足先前缺失的跨模块内部合同；用户已接受根桥接、普通测试可见性、独立入口落点和独立编译形态，不需新ADR、代理产品PRD或改Mixin Spec。本次只改匹配四文档，历史个人owner未知不虚构。

待任何新增测试/selector/argv或扩展运行范围前，由Router另行处理具体可执行输入及其授权边界；本次原A/共同验收范围不重问、不扩写。本Handler只做图维护，既有固定调用修正及已采用准备结果可复用，不执行。其余原合同的当前执行入口不足，须明确留作缺口，不能预先宣称全部图项已ready或由三模式Result覆盖。未来真实采用的独立入口必须按其合同使用共同bootstrap并明确来源；需改生产、配置优先级或认证能力仍停在该边界报告。

### 文件拥有、数据流与兼容边界

以下文件/调用边界沿用既有工作安排，不把拟议输出当已存在的实现。根`build.gradle.kts`已有共同Test接点；独立`tools/testkit/PrivateGradleRunner.java`与`PrivateGradleRunnerCheck.java`仍是既有计划中的独立入口/检查，不由本次创建。现存JUnit测试类并非拟新增文件，本次只读确认其唯一`@Test`承载三模式传播，未修改或运行。

| 文件/运行材料 | 拟议拥有与最小形态 | 明确不改 |
| --- | --- | --- |
| 根 `build.gradle.kts`（现存） | 根构建测试基础设施；实际 `gradle.gradleUserHomeDir/gradle.properties` →标准Properties→五键去前缀→共同Test worker。统一覆盖现行子模块Test任务（不只根:test聚合的三模块），保留各模块launcher/fixture参数。 | 十份runner、生产下载、各模块JDK/依赖、用户文件；无插件/buildSrc/新模块。 |
| `tools/testkit/PrivateGradleRunner.java`（拟新增） | 同owner的唯一持久独立Java/TestKit bootstrap；显式来源home→本JVM五键→原GradleRunner，调用结束恢复本桥接改动的System状态（含异常），新调用重新读取。 | 不搬历史源码为公共合同，不含样本选择/固定56项断言/P-v6标记、调度、预算或oracle。 |
| `tools/testkit/PrivateGradleRunnerCheck.java`（拟新增） | 同独立入口结果内的极小assert式聚焦检查：调用实际解析/投影接点，合成来源与错误/恢复检查；与入口用调用者现有TestKit classpath独立javac，新classes只入新build证据根。仅必要package-private接缝，不建测试框架。 | 不新增根test编译依赖，不复制平行解析模型，不分叉runner。 |
| `minecraft-codev-forge/src/test/java/net/msrandom/minecraftcodev/forge/IsolatedGradleProxyTests.java`（现存） | Forge现有JUnit/TestKit依赖、Test17和fixture.gradleJava承载的单个`@Test`；按序执行默认daemon、显式withTestKitDir/private `-g`、withDebug(true) embedded及内部恢复断言。 | 本固定selector下不能拆成三个独立结果；不以此一类宣称全部模块运行、原十入口已穷尽或独立启动已验证。 |
| 每项新 `build/<当轮证据根>/`（未来输出，尚未创建） | 必要薄入口/init检查、合成home/小工程/输入、独立编译classes、报告/日志/原退出/XML及正常私有输出/cache。实际新独立调用者在这里引用持久源码并执行本轮新classes。 | 不写旧P/Q脚本/旧oracle-classes/旧证据，不新增永久调度脚本或全量快照。 |

独立入口确定为 `public static void main(String[] args) throws Exception`，六个有序必需参数：`<source-gradle-user-home> <project-dir> <gradle-installation> <testkit-dir> <plugin-classpath-file> <arguments-file>`。前五个旧输入的内容语义保留，仅前置显式来源home；文本列表沿现有UTF-8逐行文件，classpath顺序不重排，arguments逐行保留原完整单参数，不在bootstrap补游戏/JDK/重跑/联网参数。数量错误/缺来源身份/读取解析错误真实失败；不存在的配置文件或无白名单键是合法未配置。调用者先从实际上游保存解析home，**再**改写目的GRADLE_USER_HOME或-g，不能由已覆盖环境反推、猜用户目录或沿用机器常量。plugin classpath/样本数量及独立oracle仍由调用者核对并传播错误，不能借公共化删除原必需检查；返回/异常和原build任务结果须保全。

根桥接和独立bootstrap各自用标准Properties及同一五键白名单语义，不为每个runner复制读取器，也不为共享几行解析新建模块。按键存在性区分缺失/空/非空，http.nonProxyHosts原串/通配符/`|`不trim重组、不创造https.nonProxyHosts。来源变化/键或文件删除须清除**本桥接前次**投影；根配置缓存/任务复用不得冻结旧值，独立JVM异常路径也须恢复。检查实际Test.systemProperties/实际bootstrap，不写一个平行模型替代。遇入口已有显式五键覆盖，报告冲突和实际优先关系，未定时停止，不发明优先级或默默清掉调用者配置。

用户home只读其配置，不复制配置全集/缓存；只投影五键，不转发认证、token、仓库凭据、jvmargs或整个System/environment。保留默认/显式TestKit home、-g、offline、configuration/build cache、output/tmp与fresh/reuse关系；网络许可不由代理接线授予。同worker普通单元测试可见五键为已接受影响，任意非Gradle Java CLI及其他工具联网不保证；真实认证或其他消费者缺口报告而非假称修好。日志只记来源身份、三态/一致性和脱敏必要信息，不记录真实值全集或凭据。

### 固定JUnit的真实边界与缺口

现有准备输入为[固定JSON argv](../../../build/proxy-a-read-recovery-eager-20261027-g1/junit-command.json)、[init](../../../build/proxy-a-read-recovery-eager-20261027-g1/verify.init.gradle)及[已完成准备Result](../../../build/proxy-a-read-recovery-eager-20261027-g1/preparation-result.md)，均原样复用。固定selector精确选择整个`net.msrandom.minecraftcodev.forge.IsolatedGradleProxyTests`类。现存[测试类](../../../minecraft-codev-forge/src/test/java/net/msrandom/minecraftcodev/forge/IsolatedGradleProxyTests.java)只有一个`@Test`：`workerToNestedPropagationAndRestorationInThreeCurrentModes`按`daemon-default`、`daemon-private`、`embedded`顺序运行；每种模式检查worker的五键状态、nested观察、home和正常返回后的恢复，embedded还执行预期失败、finally恢复及随后未配置检查。

因此原默认daemon、显式TestKitDir/private `-g`、embedded成功/异常/后续未配置及完整JUnit/XML/退出要求在执行边界上合并为一个item/Handler/Result/gate。一次固定selector执行是一个外层JUnit结果；该Result仍须满足内部真实传播、真实Gradle数值exit0、本轮XML `tests/failures/errors/skipped=1/0/0/0`及输入/源码/classes/worker/输出/退出收束关联。断言与nested调用不产生每模式Result；早期断言通过不能从整体failed Result中独立放行。现有source body有明确覆盖缺口：`worker-baseline/A/B-empty/removed-keys/unconfigured`是在worker JVM直接安装的属性状态，不是真实根来源文件更新；`B-empty`仅让HTTP host/port与bypass为空，HTTPS host/port从未显式为空；没有合成source文件逐键三态/Properties转义场景。故原Spec关于实际根映射的完整验收仍须在该单一执行Result中满足，但现有测试不够，未获授权不得改代码/selector/成功标准来填充。原`DEFAULT-DAEMON` generation1的failed、构建启动0次、无项目写入保留；旧六项/gates不回填，由新三模式Result承载其应有的单一执行边界而不提前释放旧gate。

现有test的`worker-baseline/A/B-empty/removed-keys/unconfigured`是worker系统属性状态，并非对真实来源文件逐次变更。`B-empty`只将HTTP host/port与bypass置空，HTTPS host/port仍非空；当前方法没有为HTTPS两键提供显式空样例，也没有用合成来源文件验证每键缺失/空/非空及Properties转义。外层根Test配置确实从当前source-home读取映射，但单次worker方法不操作/重建该来源；不能把当前用户基线当作全部合成来源用例。

### 入口归属、其它结果与审计

已完成的静态入口评估支持原有十个nested启动入口均归根共同Test配置，ordinary及pipeline fresh-home binding两路包含在内；新增的`IsolatedGradleProxyTests.java`本身含真实`GradleRunner`探针，是至少第十一个入口。它不是“全量恰为十个”的清单结论，也不代动态传播。原十入口路径维持如下，计数仅标明已核静态范围：

- Forge：`minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/{ForgePatchNamespaceInputs.kt,PatchedMinecraftTests.kt}`、同目录 `mixin/ForgeInputs.kt`。
- Access Widener：`minecraft-codev-access-widener/src/test/kotlin/net/msrandom/minecraftcodev/accesswidener/AccessWidenedMinecraftTests.kt`；Remapper：`minecraft-codev-remapper/src/test/kotlin/net/msrandom/minecraftcodev/remapper/RemappedMinecraftTests.kt`。
- Fabric：`minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricInputs.kt`。
- Mixins：`minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/{OrdinaryInputs.kt,PipelineInputs.kt}`、`minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/{StripRegistrationTests.java,MixinInputBindingTests.java}`。原binding ordinary与pipeline fresh-home均已核；仅取pluginClasspath的接点不算启动。

显式冲突优先序、真实来源更新/删除/失败关闭与独立bootstrap实际build/错误传播各保留独立结果。最终隔离/脱敏/凭据审计同样为独立只读结果；静态归属、测试运行与审计不能互相替代。根Test桥接、bootstrap解析/编译、三模式运行、独立私有build及T-Neo仍是不同验证边界；只复用已采用前置，不把一个共同JUnit结果包装成复合Handoff来覆盖第二个终态。

### 作者自检与局部独立复核范围

当前自检复读了匹配四文档、完整内部代理Spec、固定JSON/init/准备Result、DEFAULT-DAEMON完整failed Result、ENTRY-ATTRIBUTION完整completed Result、现存JUnit源码及根Test桥接文本；只用PowerShell纯文本读取项目文件。源码证实一个类selector、一个`@Test`、三模式连续顺序及embedded失败恢复；也证实worker矩阵不是合成根来源文件用例，HTTPS两键没有显式空态、标准Properties转义未由当前合成输入覆盖。failed Result证实未启动/零写入；静态completed Result限于原十项与新增探针发现。写后核唯一Waves分解、合并后的单一Result谓词/消费者、旧门禁状态、静态索引至少11及当前执行缺口。实际核验只支持文档修正，不是项目验证。

完整原Spec职责有映射：三模式内传播和JUnit退出/XML由新单一Result承担；真实来源变更/删除/错误关闭、独立bootstrap真实build及其错误边界仍逐项独立；静态归属仍独立且不宣称穷尽；隔离审计仍独立。图中shared Gradle/TestKit/build/cache运行串行，静态只读支路可并行，审计等待其余结果；Neo与V/H保持原最终gate消费者。没有将assertion数换算为启动数，没有重跑成功前置或把failed改判。

本作者未执行独立复核、派发、运行item或释放gate；不同只读Handler的`review-delivery-plan`仍由Router决定。此自检不等于reviewReady、C4/C6确认、项目验证或Result/gate采用。可执行性仍缺少除固定JUnit三模式外各原独立合同的实际入口；不以复合item或新授权假设解决。


## JUnit精简验证策略与作者自检

### 自动LSP例外的启动边界与作者自检

用户已明确接受本次自动Kotlin LSP Gradle调用的未知退出码及不可见写入影响，保留 `automatic LSP exit/write impact: unknown`；不是exit0、零副作用或已证退出。此例外仅解除这次历史unknown对精简核心参数JUnit的启动阻断，不豁免新的活动冲突、相关身份/实际退出unknown或真实失败；启动前必要排他、输出保全和有界收束仍保留，不以历史采样证明当前空闲。不清理、重置或绕过私有验证链，也不恢复ArgsCheck、AST/Python快照或jdb逐层取证。 参数调用继续使用上述现有JUnit精确selector和原五种开关输入；每轮仍须原参数/basic/默认/非1、同daemon开启后关闭、新worker、独立提交env oracle、实际Gradle/JUnit退出及逐次保存合同。后续Result持续披露该unknown，不再要求先取得本次自动LSP exit0或零写入证明才启动参数回归；新冲突或必要控制条件不满足仍停，不自动重试或杀他人daemon。此例外不扩展到完整M启动条件，不降低其真实Java8 compileJava/jar/printCompileClasspath及必要来源/输入/产物要求。

受影响局部连接仅为[Context原blocked及用户决定](context.md#自动lsp阻断记录与用户例外)→[参数启动边界](waves.md#自动lsp例外与参数启动边界)；参数item/所属Wave的发现及修复前置、参数与M互不等待成功、共享串行、V/H分别合取两者及原十二项均不改。没有新item/gate或状态推进。前述一般unknown停止条款对这次已接受的历史自动LSP unknown作此窄例外，其它未知不获豁免。

本轮作者自检限文档：对照已读取的两份仓内JSON和本次授权，核对四文档例外措辞、原blocked/零selector与自动Gradle已启动的区别、参数/M与V/H必要连接及保留合同；写后回读新增段落和参数item，确认无状态/gate改判。不是独立复核或运行验证；受影响独立局部复核范围仅本次历史unknown例外及上述必要连接，不重开未变权威/消费者合同。未运行项目命令、测试、采样或私有工具链，不声明通过。

匹配[Work](work.md#junit精简验证的现行维护边界)、[唯一Waves](waves.md#junit精简验证的现行连接)和[Context事实](context.md#junit替换决定与最新失败采用)。本节落实用户已经批准的JUnit精简替换，不研究选项、不实施。PRD/ADR/Spec仍reuse、权威写入skip，未知owner不编造；生产、basic、版本/缓存产品合同不变。现行完成仍由G-REMAPPED-NESTED-RERUN-REGRESSION与G-REMAPPED-CONSUMER-RERUN分别建立局部结果，再由G-RECOVERY-INTEGRATION/G-ACCEPTANCE及原十二项恢复合取建立最终结果；图和调度只归Waves。

### 未来最小执行安排

1. **参数独立结果。** 直接使用现有`net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments`，外层示例为`:minecraft-codev-forge:test --tests "net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments" --rerun --info --console=plain`，沿用已确认的完整外层属性/cwd/JDK/home。移除--debug-jvm，不改withDebug(true)，不启ArgsCheck/Python验证链。正常Test编译及实际JUnit执行关联当前源码/方法与输出，无独立WIRE成功门槛，不重做已写接线。
2. 现有JUnit每次实际调用真实helper覆盖basic/remapped及Java路径缺失、空、多目录、含空格四输入；外层逐次给子env副本的值依次为1、显式移除、空、0、其它非1值（如2），不新增测试矩阵或oracle系统。每次保留jar/printCompileClasspath/-s及非空唯一完整同名-D单argv、无冲突nested -P；仅remapped且1追加恰一--rerun-tasks。内部expected来自env，JUnit通过本身不足以证明传播，须把提交env作为独立预期与worker实际env/工程/输入/argv核对。
3. 开启→移除两次outer argv/cwd/JDK/home相同、同daemon可关联身份、新worker实际输出不同；不使用withEnvironment、--no-daemon/--stop或新daemon顶替。第二次从父环境重新复制并显式移除开关，不复用第一次副本，父环境不写回。各次真实执行Test（非缓存/skip），Gradle0/JUnit1/0/0/0且结果保存完再下一次。普通INFO/worker输出、JUnit及已有daemon日志承载证明；身份不明、实际环境设置/恢复warning、非同daemon或未执行仍不能通过。
4. **完整M独立结果。** 同一Forge Test任务改用原`net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test remapped patched Minecraft`精确selector、outer --rerun/--info/--console=plain及原属性，仅本次子env=1；保留TestKit withDebug(true)，无外层--debug-jvm或jdb。M不消费参数Result或私有WIRE gate，但保留原G-REPAIRS、完整P、Q-1165及原已采用发现当前适用输入；与参数共享运行必须串行，不等basic/Neo/R。必要编译与正常输出是该消费结果内部步骤，不另交接线Result。
5. M须本轮Java8真实javac编译原EVENT_BUS/named Entity.class示例，compileJava非NO-SOURCE且compileJava/jar均实际执行、printCompileClasspath实际执行；Gradle0/JUnit1/0/0/0、实际Java8 compiler executable/metadata与任务执行及当前class/Jar关联。只见配置回调或文件存在不够，UP-TO-DATE/FROM-CACHE/SKIPPED均不能替代消费。用现有普通日志和来源输出关联MC1.16.5/Forge36.2.39、userdev/MCP/universal/libraries/modules、ResolvePatchedMinecraft、official client server=false、Java8 LoadMappings official→MCP→Tiny obf/srg/named、显式srg→named RemapTask、provider图和完整classpath；必要输入/实际插件/有效产物关联仍保留，日志缺必需字段则报缺口，不能推断通过。
6. 上游Gradle/插件有效缓存允许，如实区分任务执行和内部hit；不要求冷重建、不人工删除/清理/备份旧输出、不把普通日志缺内部cache key推成已核验。P/Q/R各自既有缓存合同未改；M只复用适用来源证据并关联本轮输入/产物，不追加全历史hash账本。每次运行的命令/cwd/JDK/home、提交env、实际stdout/stderr、JUnit/XML、任务结果、可关联身份/真实退出和失败单独存本轮新证据根，下一次启动前先保存，正常任务可重写自身输出，不能覆盖历史证据。

### 保留和撤销覆盖及停止边界

停用独立ArgsCheck编译加载、AST/七份Python语法自证、全量源码树/历史根/父环境hash快照、旧8/20/11+1对新hash的自证映射、Capture内部自检、remapped jdb逐层Provider/System/StartParameter/gradleProperty/effective installations及classOrigin/harnessOrigin调试证明；不再修wire.py或把工具静态错误扩成新恢复链。撤销的是这些证明方法和等待，不是把最新failed或未覆盖判为通过。实际来源/输入/产物和Java8执行不撤销；普通日志不能支持的内部过程明确列为不再覆盖/未直接观察，不能称逐层验证成功。basic自身D/B及最终basic观察合同不改。

可靠相关目标身份、启动前即时排他及实际控制能力、实时输出保全、真实退出和有界收束自有进程仍保留；不需为Capture机制另造内部检查或逐层资源凭据。未知相关身份/退出、冲突、真实编译/测试/消费失败停止后续启动并保存可得输出/退出，不杀他人daemon、不吞错、不扩大一般重试/额度或新增预算。参数/M及其它Forge/Gradle/TestKit/build/fixture/cache写运行串行，无业务成功依赖不代表可并跑。

### 作者自检与必要局部独立复核

本次已作仅文档作者检查：四文档完整读回与精确局部替换预期一致，修改外正文保留；新增/受影响14个fragment均有对应标题、8个唯一仓内文件目标可达，新增持久文字无外部Result路径。联合正向item前置、所属Wave前置gate及gate等待全部成员，56个唯一item/51个非空Wave/51个gate、107节点266条去重等待边均可解析、成员唯一归属、无环/自等。只有参数、M、V/H四项的等待集合变化；参数/M互不等待，V/H分别合取两者，现行后继无WIRE成功祖先，M保留完整P/Q-1165且无Neo/R/D/B成功屏障。原已采用发现的历史关联祖先保留，不解释为新增P/Q直接前置或重跑。最终第2–8/10款逐字不变，其余修改仅最新failed/已写效果、接受的覆盖撤销与必要连接；原历史failed/partial/blocked/unknown/旧gate判断不回填。作者内存检查曾遇容量和文本解析问题，纠正后以上检查通过；没有因此执行项目脚本/构建/测试或采样。作者自检不是独立review、ready、实施或gate释放。必要不同Handler局部复核范围仅为：（1）用户接受的harness/AST/hash/Capture/jdb覆盖撤销与普通JUnit/日志替代，--debug-jvm移除而withDebug(true)保留；（2）参数非1值、完整argv/父环境与同daemon开启后关闭；（3）M独立、真实Java8 compileJava/jar和必要来源/有效缓存；（4）私有成功等待撤销、共享串行、参数/M→V/H联合输入及第9款remapped观察替换；（5）最新failed/零启动/已写效果及未覆盖披露。不重审原已采用发现、basic/producer/P/Q/D/B、未变权威或其它最终条款，不新增审批回合。

以下此前WIRE恢复和消费者策略/作者记录保留各自历史时点；其中私有WIRE/harness/Capture自证、remapped jdb/内部逐层观察、参数→M成功依赖等已撤销要求由本节和现行Waves替代，不再竞争；basic及其它未变合同仍有效。最新验证恢复g1已failed而非“未执行/无Result”，不再修或等待它成功。

## WIRE恢复g1失败后的未完验证策略与作者自检

**历史准备记录（已被页首JUnit替换条款取代）。** 保留当时失败、已写效果和原合同；私有接线验证成功等待/内部自证及remapped逐层jdb不再现行，最新验证恢复g1已failed、目标零启动，不能继续按本节修私有链或声称运行通过。

本节承接[Work](work.md#wire恢复g1失败后的仅未完验证维护)，唯一执行图为[Waves](waves.md#wire恢复g1失败后的现行验证连接)，事实归[Context](context.md#wire恢复g1失败与已完成输出的采用边界)。一个四文档维护及作者自检结果，不实施或启动任何项目检查/编译/测试/采样、不释放gate。继续采用既有PRD/ADR/Spec三族reuse、权威写入skip；既有产品/隔离/缓存合同覆盖未变范围，PRD owner未知仍未知，不新造权威或要求重新批准未变范围。

### 保留已完效果，只承接剩余谓词

原恢复generation1已failed、实际根g2工具未验证及目标零启动保留；此前WIRE failed及所有旧gate不回填。源码SHA256 `09f100792e150c4b5faf84a4308d2d5472802db752c11e1160ed1565257e32ae` 对应worker/env/工程/输入/真实helper argv输出已补齐，本轮从“待补写”改为“只读保留并关联新编译class/实际输出”，不重做源码、basic/producer、两个fixture、一参接口、原分支或System属性finally。新验证恢复与独立VERIFY、完整M仍是三个独立终态，工具和最小检查仅服务其中接线可验证这一个谓词，不独立交付公共工具。

只在另一全新build证据根复用g2已写的必要工具适配；g2、此前g1及其它旧根均只读。新根允许的最小剩余写入是实际自检记录函数的参数合同纠正、尚缺wire.py等必要薄编排和本轮正常编译/取证输出，不改真实源码、生产、Forge build.gradle.kts、Java示例、依赖、用户配置或公共框架。g2副本尚未被验证，不能因曾报Python clean而继承运行安全；复用已验证生命周期的原则保留，但每份新字节和受影响检查仍需逐项对应。

`wire-check.py` 的 `passed(name,actual=True)` 将actual原样写入证据，不把actual当通过条件；其真实调用包含bool及dict/list。纠正只应让该参数合同如实接受既有取证载荷，保留passed字段、断言、失败分支和原oracle，不能强转bool、默认兜底/删比较或大范围关闭诊断。SQL sink自动告警未判为漏洞，也不在此声称误报；若实际工具仍以它阻断，仅核实arguments.execute调用、实际被调用函数及受控夹具替换所经数据流，报告局部依据/未决缺口，不屏蔽规则或扩大为SQL修复。

### 原安全和验证合同不减

- 先分类候选、再取相关身份，分别保留AccessDenied/NoSuchProcess；相关目标或不能可靠排除候选的未知仍拒绝。每次spawn紧邻完整memory/disk及排他复核，唯一Capture立即接流→立即身份→慢采样后移，finally保全并收束自有进程，必须取得真实exit与EOF/无error-drain。只把开关写入实际Popen的env副本，显式默认调用重新复制并pop，父环境前后核对不靠停止时null代证。
- 新根的实际run/arguments/compile及编排/检查调用方逐项复核分类/拒绝、采样、异常、Capture/身份、退出drain和env；映射检查→实际函数/调用方/新hash/输入与夹具差异，未变项给适用依据。工具参数纠正后先作该合同的同版静态复查和受影响内部检查；任一真实检查失败立即保全停止，不把本次窄纠正扩大成任意失败修后连续重跑，旧8/20/11+1不自动代新hash。
- 再完成原一次真实compileTestKotlin/新helper class和临时harness编译加载；关联已完成源码输出、class/hash和输出字符串，复核精确Java/javac/stdlib、classes/kotlin/test根、外部classOrigin/harnessOrigin/java.home及真实命令身份。最小独立启用和显式默认两个Java调用各核basic/remapped代表输入：启用只给remapped一个flag，默认关闭、basic不变，jar/printCompileClasspath/-s及非空完整唯一-D不变；保留真实argv/退出/输出与父环境无写回证据，不以grep或静态意图代实际调用。

原风险/停止边界仍是工具/检查真实失败、加载/输入或相关身份不闭合、资源冲突、输出/drain或退出unknown即停止后续启动并有界收束自有进程，不杀他人daemon、不忽略全部AccessDenied、不清理/备份/覆盖旧证据、不新增通用重试/分钟/在线额度。与共享helper/class/编译/run/arguments/观察接点及相关Forge/Gradle/TestKit/build/fixture/cache写运行串行，新目录不消除冲突。实际需源码或其它越界修复时只报精确缺口。

### 后继验证和必要改接

Waves新增一个独立验证恢复及单成员Wave/gate；VERIFY和完整M的原接线成功输入改等它，不要求原恢复failed转成功、不等自己的gate，也不新增P/Q对接线的直接成功依赖。原发现适用和修复前置、VERIFY/M原有P/Q等前置与冲突不变；V/H最终合同中接线输入同步换新gate，实际M输入和十二项合取不改。完成当前接线恢复需其新完整Result completed、足证据并由Router完整采用，只供显式后继；整个既定完成路线仍须独立新版回归gate、完整M gate、原最终组合及独立验收gate，不以本次文档维护或最小检查满足它们。

正式VERIFY继续承担basic/remapped×四路径输入×开关矩阵、逐项旧发现适用和既有两次同outer argv/cwd/JDK/user-home的真实纯参数selector同daemon隔离；保留withDebug(true)、独立env oracle、新worker与同daemon身份/Gradle0/JUnit1/0/0/0/退出drain，不移入接线恢复。完整M继续独立证明原完整链、来源/namespace/provider/classpath及真实Java8 javac、compileJava/jar/printCompileClasspath和同轮身份/观察/退出；允许有效上游Gradle/插件缓存，准确记录来源/输入/输出和hit层级，不新增冷重建或由缓存免实际消费。V/H同版fresh三模块/根入口/历史映射及其余技术标准均不变。

### 本轮作者自检与局部独立复核边界

作者按本轮已采用failed、已完成源码输出与零启动事实逐项对照四文档；新恢复保留原完整WIRE谓词，仅去掉已完成源码补写并补剩余工具参数合同/编排。单一结果边界已核：工具纠正/内部检查/编译加载/最小调用共证一个接线验证结果；正式矩阵/同daemon隔离与完整M仍分别独立，未合并或执行。对实际文档文本作只读解析：51个非空Wave、56个item及51个gate的ID唯一，成员唯一归属，正文前置和表内gate引用均可解析；联合item前置、所属Wave前置及gate等待全部成员，未见自等或环。本轮新增11个四文档fragment链接均有对应标题，3个仓内证据文件已读取确认可读，新增持久记录无外部Result定位。定点只读哈希核对源码、g2六份工具及两个旧run共9文件均与已采用停止记录相符，g2 wire.py仍不存在；不把有限hash核对称全旧根前后比较。未变验证合同仅与既有正文对照，不重跑技术检查。

先前独立ready及其未变判断保留；本作者不宣称本轮已独立review通过或实施完成。此次必要局部独立复核仅覆盖：（1）g1失败/g2根与已写源码身份、不再补写及旧根只读；（2）passed实际载荷合同纠正和SQL告警局部核实界面/停止边界；（3）新根复用未验证适配后的受影响检查与原编译/加载/最小调用证据；（4）新恢复item/Wave/gate及VERIFY/M、最终组合的必要输入替换。只追上述改接的相关连接，不重审未变的正式矩阵、同daemon方案、M缓存/真实消费、全部旧合同或权威族，不新增审批回合。

以下旧“恢复未执行/无Result、源码输出待补”属本次failed之前的准备历史；原技术合同仍保留供当前验证承接，当前事实/写拥有以上节为准。

## WIRE失败后的有界接线恢复策略

本节为 [Work](work.md#wire失败后的未完接线恢复安排) 的当前策略，匹配唯一 [Waves](waves.md#wire失败后的现行恢复连接)，事实归 [Context](context.md#wire失败与只读诊断的采用边界)。用户已明确确认接线→回归→消费者具体范围；原WIRE failed及已写源码/薄入口保留。仅四文档维护及作者自检，不改源码/工具/配置/权威、不运行构建测试或项目验证脚本、不备份/Git写入。沿用既有PRD/ADR/Spec三族reuse、写入skip：产品/隔离/生产缓存合同不变，仅恢复已确认测试接线及取证方法；PRD owner未知仍未知，不新造权威或确认关卡。

### 同一未完WIRE谓词与写拥有

恢复只交付“保留源码的默认关闭接线可编译、可加载、可安全调用且可供只读正式回归消费”一个终态，不重放basic/producer或原发现。必要临时分类/生命周期纠正、内部安全检查和启用/default/basic最小helper检查只为此谓词，无独立工具消费者/Result；正式版本回归、同daemon隔离和完整消费者仍是后继独立结果。item/Wave/gate与前置唯一归Waves，不在Plan建立第二图。原failed/gate未满足不回填，新成功不要求旧failed先成功。

- **源码必要补齐先于编译与移交。** 保留PatchedMinecraftTests.kt已写helper分支、一参接口、原三参数/唯一-D、两个fixture调用及纯参数方法/System属性finally恢复，不重做它们。诊断指出该方法无可观测worker/env/argv，原已确认源码写拥有本已要求此输出；新恢复只在同一个纯参数方法内补worker PID、org.gradle.test.worker、实际env（缺失明确unset）、工程/输入及真实一参helper返回argv的可关联输出，供独立驱动固定oracle消费，不复制helper、不以所读env同时生成外部预期。保持不调用GradleRunner/nested consumer。此补齐与其新class身份是接线移交前置；WIRE恢复须证明补齐源码已进入实际编译class/方法，正式worker执行和输出真实性由VERIFY证明。不得把代码缺口推给只读VERIFY、也不能以编译代worker传播。若同文件最小补齐无法在原授权内闭合，报告缺少的具体源码/权限/能力，阻断受影响边界，不擅扩。
- **只用全新证据根。** 未来恢复根只是预约、不是现存证据；不删除g1 run-start标记、覆盖result或续旧轮。以已纠正生命周期根的run.py/arguments.py/compile.py及其适用检查为来源，旧根全只读；只在新副本实际Popen接缝最小增加env形参/传递：每次从父环境复制，启用值仅写子副本，默认从新副本显式pop。不改os.environ/用户系统环境/持久配置，不复制g1替代控制器作为基础；检查共享spawn实际调用方（run/main、arguments、compile及受控自检）都保持同一Capture/身份/异常合同，必要最小适配不另造框架。
- **纠正相关性而不削弱拒绝。** 先用可读名称等有限身份筛选相关Java/javaw/jdb/python/cmd和构建driver/launcher候选，再读目标cmdline/cwd等。保存已知name/PID/创建时间、失败字段及异常类别；明确无关进程的cmdline拒读不误拒，AccessDenied与NoSuchProcess不能合并。枚举消失须如实记录并检查是否有相关拥有者/活动残留；相关目标或无法可靠排除的候选身份未知仍停，不以忽略所有AccessDenied、PID白名单、管理员权限或杀daemon放行。daemon须唯一日志且确认idle/finished，活动worker/launcher/writer/driver冲突仍停；正常通信端口和锁文件存在只作线索，不推断损坏/占用，不清理或换home。
- **逐次spawn安全合同。** 每次compile/javac/helper Java的真实Popen前紧邻完整memory/disk/排他，不能用单入口preflight或历史idle代证；Popen立即交回已拥有proc→唯一Capture→真实PID/创建时间/cmdline/cwd→后置慢采样/保存，spawn/after/end分存。身份读取、采样/保存异常都在拥有proc的finally保全边界内，短命身份unknown仍失败但保存可得真实exit/output；不因exit0/有输出吞错通过。线程结束∧真实EOF∧无Capture.error才drain；wait/join有界并按既有方法保存自有launcher/后代结束或unknown，不能只kill父进程后无限communicate，不杀他人或新reader补证。当前无法可靠收束即停后续启动并报告限制。
- **编译与精确加载。** 新helper源码有变，须一次真实compileTestKotlin成功并保存实际源码、编译class/hash/退出收束；旧成功编译不代新class。ArgsCheck自身正常编译仅在新根，恢复classpath为minecraft-codev-forge/build/classes/kotlin/test根（非net/msrandom/...包目录）＋新harness根＋适用的精确stdlib。复用既存arguments/compile所关联实际Java安装与匹配javac/stdlib来源，启动前核对适用性，不从PATH重选或扫描全缓存jar；不可用/漂移不能默默替代，报告具体缺口。记录新run/arguments/compile/受影响检查、ArgsCheck源码/class、helper源码/class、Java/javac/stdlib字节身份、完整命令/cwd/env与结果；外部核对实际classOrigin/harnessOrigin等于指定根、方法为一参，运行时和实际加载来源闭合，不只打印不核验。

### 接线内部检查与正式回归分界

新恢复在真实编译/参数调用前对受影响实际函数/调用方做必要安全检查：无关拒读不误报、相关Java/driver拒读仍拒绝、NoSuchProcess/AccessDenied记录区分、idle与busy/活动worker区分；逐次完整采样/时间序、Popen→唯一Capture→identity→慢采样；快退出身份unknown仍保全且失败、采样/保存异常不丢proc；正常/非零exit、EOF/读错/线程未结束的drain合取；实际classpath/加载来源核验。沿用现有受控检查接点按实际新字节和函数差异补齐，不用grep代运行，不重做无关旧131或把20+11+1写成新版整组通过。检查失败仍按原停止合同，不能借“内部”无限修跑。

随后只做最小真实一参helper检查：一次独立子env=1证明remapped恰一flag且basic仍原参数；收束分存后另一个从父环境新复制并显式pop的默认Java调用证明remapped关闭（并核对basic不变）。使用代表性完整非空含空格Java路径单argv，原jar/printCompileClasspath/-s及唯一-D/无冲突-P不减，外部oracle以提交env和输入固定；实际Java/class/hash/加载来源/命令/env/真实身份exit0及无error EOF-drain、父环境前后未写回须全部关联。这两个最小调用不是同daemon传播证明，不跑g1五开关×两工程×四路径40项，不执行纯参数Test selector、nested消费者或M。

正式VERIFY仍独立补齐全部开关×工程×四路径矩阵、实际外层Gradle/Test worker传播、同daemon开启→显式移除的两次串行精确selector/新worker/独立oracle及所有原受影响检查和旧发现适用性；写拥有只新根参数/harness/自检和正常取证输出，真实源码只读。可按同字节/输入/环境适用性消费恢复中的实际已过检查，明确补齐剩余，不为分界重复相同检查也不把内部检查代正式完整谓词。原 [两次调用方法](#同daemon默认关闭隔离的两次调用) 的warning/同daemon/新worker/真实test/独立保存/退出drain合同不变。M仍独立完整真实Java8编译打包、允许有效上游缓存但身份闭合；V/H十二项、同版fresh三模块/根入口及历史限制不变。

### WIRE恢复维护作者自检与局部复核范围

本次作者已完整读取两个指定Result并定点核对仓内失败/初值、preflight字段、当前源码与harness和已纠正接缝；只读解析封存preflight确认150项同类、原daemon最后idle及memory/disk缺失，未做当前PID探测，不回填历史。修改只在本四文档的当前入口、恢复策略/事实、新单结果及必要后继item/Wave/gate/冲突连接；实际写后回读、链接和联合等待检查由本次Result如实列出，不沿用前轮全图统计。已写与未验证分离，原WIRE failed/旧完整合同与gate不满足保留，原发现不重开；源码缺口归恢复、VERIFY只读、M真实消费均有明确边界。

**本轮写后实检（仅文档）。** 四文档全文读回与内存原文＋精确替换预期一致，修改外原文保留，无落盘备份；受影响四文档/标题链接14处解析通过，新增仓内证据链接均来自本轮实际可读文件。表内50个非空Wave/50个唯一gate、55个成员各唯一归属，前置gate均解析；定点解析恢复/VERIFY/M/V/H五项的正向item前置，联合所属Wave前置gate及gate等待全部成员核查，无自等/受影响回环。此检查没有重新解析不变祖先的全部item正文，不宣称全图重新验证；逐项回读确认旧WIRE成功等待已从VERIFY/M的item与Wave两层移除，改为新恢复，新恢复无额外P/Q直接成功前置，VERIFY/M原P/Q、M→V/H及十二项原合取保持。内部作者检查曾遇内存缓存容量及枚举器遗漏WIRE前缀，已纠正并重新通过上述文档检查，不是项目执行或测试失败；项目脚本、构建及实际行为均未运行。工具自动Markdown检查四文件显示clean，仅为文档诊断，不代独立复核或运行证据。

必要不同Handler局部复核仅覆盖本次失败/保留效果与诊断采用限度、恢复单一谓词和原授权内源码输出补齐前置、新根接缝/分类/逐次采样/身份/收束/classpath/运行时与加载核验、内部安全及最小helper检查对正式VERIFY的分界、后继item＋Wave两个改接点、共享写串行及M→V/H/十二项原合取。无需重开原已采用发现、basic/producer/P/Q/D/B或不变权威。原not-ready及其它失败不改判；本作者未执行独立复核、实际恢复/验证、Result采用、ready判断或gate释放。无一般重试/新预算/新额度：真实非网络失败、目标身份或退出unknown、资源冲突和实际合同差异仍停，保全可得证据；两类原有准备错误例外保持其证据边界。

以下消费者策略中的候选/三个结果未实施及未确认文字限其准备时点；原技术合同继续适用，实际WIRE效果与现行成功等待由本节和唯一恢复图取代。

## 消费者本轮内层重跑策略与作者自检

**WIRE实施前的方案/作者记录历史。** 下文未实施、未确认及旧WIRE成功等待仅限当时；当前确认、失败与已写效果、新恢复及后继连接以上节为准，未变验收继续有效。

本节定义当前 [Work](work.md#本轮消费者恢复维护)的消费者恢复维护范围，匹配且只匹配本目录唯一 [Waves](waves.md#消费者本轮内层重跑恢复连接)。采用事实及本轮用户选择见 [Context](context.md#本轮消费者恢复的采用事实与边界)。下方历轮准备章节及旧“当前/待做”保留当时状态；当前remapped接线、消费和V/H连接以本节及匹配图为准。本次只编辑Work/Context/Plan/Waves，不执行代码、工具脚本、编译、构建、测试、下载、配置、备份或Git写入，不声明实际item完成或释放gate。

### 成功条件与权威范围

交付一份一致且自检完成的恢复方案：在本轮指定调用内强制remapped内层任务重执行，原消费者实际使用Java8编译打包，允许有效上游缓存。三个概念分别判定：`--rerun-tasks`及实际task outcome证明任务执行；producer内部缓存hit/miss和来源/输入/产物关联证明复用有效；本轮javac8执行、class/Jar及classpath证明真实消费，任何一个不能代另两个。`fresh`在本节是本轮真实消费，不要求所有patched/named上游重新生产。旧合同里的fresh patched/named Jar在现行M中解释为当前输入有效、可与本轮消费闭合的真实产物；不得以陈旧或失败产物替代。本项明确不改变P/Q/R的独立冷热缓存义务、basic原合同、V的三模块fresh/根入口或V/H十二项合取。

三族沿用既有reuse的范围仅是不变产品/生产合同；权威写入skip。已条件加载spec-driven-development核对本次差异：进程级测试入口和证据组织不是新生产缓存策略或产品消费承诺，不改原PRD/ADR/Spec。PRD owner仍未明确，不写成已确认；若局部独立复核发现新权威需要或实质解释冲突，报告具体缺口并阻断受影响实施，不以Plan替代权威。

### 具体候选实施边界

- **默认关闭、实际入口。** 候选固定使用 `CODEV_REMAPPED_NESTED_RERUN`，只有精确值 `1`且工程名为 `remapped-patched-test`才在原nested参数后追加一个 `--rerun-tasks`。原 `patchedMinecraftArguments(String)`一参反射接口、两个原测试方法、`test(pathName)`调用形状及 `[jar, printCompileClasspath, -s]`保留；非空Java路径仍作为唯一完整 `-Dorg.gradle.java.installations.paths=…`单argv，两种工程均无冲突-P。未设置/空/0/其它值以及basic，即使该标记为1，也不追加重跑参数。不能把remapped调用点永久写true或无条件加flag。
- **仅调用内启用。** 本轮新build证据根的既有薄入口副本在实际 `run.py::spawn_sampled` 的Popen调用处，从父环境复制子进程env，仅需启用的那次副本置标记为1；隔离回归的第二次调用须从父环境重新复制并显式移除标记，具体编排见下节。不得修改父进程 `os.environ`、用户/系统环境、gradle.properties、共享Gradle配置或日常命令默认值。环境经外层Gradle/Test worker到原一参helper的实际值、最后nested argv必须本轮观测；旧daemon/worker复用不能凭继承假设放行，传播/隔离不成立即停，不转用永久true或另加隐式开关。V若使用此接线，只在其本轮原remapped验收的具体启动中同样显式启用并保留自身证据，不自动视V已运行；H只读。
- **明确文件。** 候选源码写入仅 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt` 的参数helper分支和一个纯参数JUnit方法 `Test patched Minecraft arguments`；新方法调用真实helper并覆盖两工程/原四路径输入，finally恢复System属性，不调用GradleRunner或编译消费者。原两个fixture测试调用点保持原样，无需常量true或改签名；新增方法也属于V必须枚举的当前新增案例，不是新增完整消费者。新证据根内复用适用的现有run/ArgsCheck/自检与参数入口，最小补子进程env、启用/默认参数预期、实际nested参数与task/产物身份取证；旧 `build/remapped-java8-evidence-20261025-g1/`及生命周期根工具/报告保持只读。新根的实际输入快照、class/hash/加载路径及预测字段必须匹配新helper；预测不能冒充观测。允许正常compileTestKotlin/Gradle/fixture输出重写自身build文件；不改Forge build.gradle.kts、生产、Core缓存机制、Java消费者、依赖、用户配置，不引入通用启动/重试/配置框架。需要其它真实源码或能力修正即报告具体边界。
- **检查影响。** helper新分支和新编译class影响原真实参数8项的版本适用性、缺失/空/多目录/含空格-D的oracle、basic不受影响、remapped opt-in及默认行为；新根Popen env影响参数/compile/run共享生命周期接缝、Capture单一所有权、立即身份/采样顺序、异常保全与EOF drain。独立回归须按实际改动逐项重做受影响合同/拒绝/生命周期检查并给新字节身份，未变项逐项说明复用；不得把旧20+11+1称作新版本整组通过。源码变更所需真实Kotlin编译/加载和实际ArgsCheck调用都要有证据，不能拿旧compileTestKotlin exit0代新class；helper方法行号/新class可能影响jdb定位，须按实际新源码/加载方法重新关联观察点，不能照用旧行号。

### 同daemon默认关闭隔离的两次调用

本节是受影响回归的检查方法，不是本轮运行记录，也不是两个消费者结果。已采用只读传播调查的机制依据为当前wrapper的Gradle 9.4.0：[daemon文档](https://docs.gradle.org/9.4.0/userguide/gradle_daemon.html)说明client每次发送build环境；[`EstablishBuildEnvironment`](https://github.com/gradle/gradle/blob/v9.4.0/platforms/core-runtime/launcher/src/main/java/org/gradle/launcher/daemon/server/exec/EstablishBuildEnvironment.java)按本次Build环境临时应用，并在finally恢复；[`Test`环境合同](https://docs.gradle.org/9.4.0/dsl/org.gradle.api.tasks.testing.Test.html)及[`Test.java`](https://github.com/gradle/gradle/blob/v9.4.0/platforms/software/testing-jvm/src/main/java/org/gradle/api/tasks/testing/Test.java)把当前环境交给forked Test worker。这是方案依据，不证明当前Windows/JDK实际设置、恢复或传播成功。保留 `.withDebug(true)`；[GradleRunner API](https://docs.gradle.org/9.4.0/javadoc/org/gradle/testkit/runner/GradleRunner.html)不允许debug配合 `withEnvironment(...)`，本方案不使用该API，也不把debug中的nested build当另一inner daemon。

1. 只在新根现有薄入口的调用方增加最小串行编排，不新增通用框架。两次使用完全相同的outer argv、cwd、wrapper/JDK选项和Gradle user home；精确selector均为 `net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments`。outer命令保留既有等价强制test执行选项并包含 `--info --console=plain`；分别记录outer强制test参数与helper实际返回的inner argv，不把两者混为消费者执行。禁止用 `--no-daemon`、`--stop`、换home/JVM选项或fresh daemon代替同daemon检查。
2. 第一次 `env_on = os.environ.copy()` 后只在该副本设置 `CODEV_REMAPPED_NESTED_RERUN=1`，Popen显式传入env。该次真实退出、单一Capture无error EOF/drain及证据保存完成后，第二次才从未写回的父环境重新执行 `env_default = os.environ.copy()`，并 `pop("CODEV_REMAPPED_NESTED_RERUN", None)`；不得复用或修改第一次env副本，也不能只依赖父环境原先恰好unset。两次前后记录父环境该键及未写回依据；父环境即使原有该键也原样保留。
3. 两次在同一新根下使用各自独立调用子目录（如 `isolation-enabled/`、`isolation-default/`，仅未来预约、不作现存证据）保存原始stdout/stderr、实际outer命令/cwd/JDK/home和提交env摘要、启动/身份/退出/资源/收束记录、各自JUnit/XML或stdout。第一次报告须在第二次启动前保存，避免正常Test输出重写后丢失；不得覆盖旧根或把两轮拼成一次。每次沿用Popen后立即唯一Capture/真实身份、慢采样后移、异常不丢proc及可得退出输出保全的既有合同。
4. 每次从 `--info` 的daemon PID及 `daemon-<pid>.out.log` 关联同一真实daemon身份，结合可得创建时间/日志身份排除PID复用或多候选；两次PID及身份须一致。纯参数Test在真实worker中打印 `System.getenv("CODEV_REMAPPED_NESTED_RERUN")`（缺失明确为 `<unset>`）、worker PID、`org.gradle.test.worker`及真实一参helper返回的argv。优先由INFO保留stdout；缺失时读取本次Test标准output/XML，不从预测记录反推实际值。两次worker PID或worker id须不同，且两条记录各与本次test/调用关联，不以文档所述会fork代观察。
5. 两次各须真实执行该Test、Gradle exit0及JUnit 1/0/0/0、各一条可关联worker记录；UP-TO-DATE/FROM-CACHE、无测试或空报告不算执行。外部驱动按两次显式提交env独立固定oracle：第一次实际值为 `1`，remapped恰一个 `--rerun-tasks`；第二次为 `<unset>`且无该flag，basic始终无flag，原 `[jar, printCompileClasspath, -s]`及唯一非空完整-D合同不变。不能由worker读取的值同时生成预期与实际从而自证通过。空/非1及原路径矩阵仍按回归合同补齐，不增加消费者结果。
6. 任一次实际warning（特别是无法设置/恢复环境）、daemon身份缺失/多候选/非同一daemon、worker未新建、env/argv不符、未执行测试、身份/退出未知或Capture未drain均不得记通过，按实际失败/未知报告并停止后续启动，保全并收束本轮自有进程；不新开daemon补成功、不一般重试。只有以上合取实际成立才可证明本局部隔离；不要求先运行才可维护本计划，也不以机制调查或作者自检宣布隔离已通过。

### 独立结果与完成依据

唯一Waves分别表达接线可用、受影响新版本回归成立、原M完整真实消费三个独立结果及其成功前置。接线的最小自身检查只说明修改可编译、原接口可加载及一次启用/默认参数行为，不代正式回归或M；后继回归按同hash已过证据适用性复用并补齐完整矩阵，不为拆分而重复相同检查。回归同时说明已采用原发现Result对未变合同的适用性及新hash受影响部分的补证，不能重开原已completed关联，也不能自动沿用其gate为新版本已验证。最终消费者必须联合等待旧适用发现与新版本回归，独立Result失败不回填历史。

- **接线与回归证据。** 检查开关未设置/空/非1和1、basic/remapped、原Java路径四输入及含空格完整值；真实调用原新编译一参helper，保存输入、实际argv、Java/class/加载位置/hash、真实进程身份/退出和输出收束。开启时只有remapped有且仅有一个 `--rerun-tasks`，关闭及basic始终原参数；启用子进程退出后的独立默认调用仍关闭，父环境未被修改。正式传播/默认隔离回归使用精确selector `net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test patched Minecraft arguments`，逐次用外层Gradle/Test启动的env副本送入开关各值，强制该Test实际执行但不调用nested消费者；保存真实worker环境值/argv及Gradle0/JUnit1/0/0/0，外部驱动按实际提交的env独立判oracle，不能从worker读取的同一值推导期望来掩盖传播失败。开启→未设置的两次调用须关联同一外层daemon的真实身份，证明复用后新Test worker恢复默认；如无法证实复用隔离则报告缺口，不以新进程通过冒充。独立Java ArgsCheck可服务接线最小检查和适用复用，不能代上述真实worker证据。不反射篡改System.getenv或daemon全局环境；Java路径四输入按原harness清除/设置并恢复System属性。对任何实际改到的Popen/Capture/拒绝/资源采样路径做针对性真实函数检查，保留原失败、差异及复用依据，不用文本匹配代运行；独立Java的env检查不能冒充外层Gradle/Test worker的实际传播或旧daemon复用隔离，相关实际观察不足仍是阻断。
- **本轮M任务与真实消费。** 一次原精确remapped方法中实际nested argv启用内层重跑；`:compileJava`及`:jar`确实执行，不得UP-TO-DATE/FROM-CACHE/SKIPPED，compile必须非NO-SOURCE并有本轮Java8 executable/metadata及javac真实执行依据；printCompileClasspath实际执行及完整解析路径齐全。保留固定MC1.16.5/Forge36.2.39/userdev/MCP/universal/libraries/modules、official client mappings(server=false)、Java8 LoadMappings及official→MCP→Tiny obf/srg/named、显式srg→named RemapTask和producer/provider图、原EVENT_BUS/named Entity.class消费、当前class/Jar内容与完整classpath/字节对应。配置完成compiler回调只证明选择，不能代javac执行。
- **有效上游缓存。** 允许ResolvePatchedMinecraft/LoadMappings/RemapTask正常执行时复用有效插件缓存，以及适用上游正常Gradle缓存；按实际命中层分别记录，不能声称重跑flag必然冷重建。关联当前源码/已加载插件、固定来源与完整输入、实际cacheRoot/operation/key/路径及输出bytes/hash、阶段/namespace/provider、最后消费者classpath/Jar，复用相应已有同版证据时说明具体范围和当前适用性。本轮来源/输入/产物身份不闭合即缺证，不能把核对变成新冷重建、删除或备份要求；内部命中可不重新启动补丁/映射/rename工具，须说明对应阶段来源、工具/Java角色、当前有效输出及本轮关联，唯原消费者javac8编译打包不可省。不能用旧invocation-10或仅文件存在/时间戳补本轮消费。
- **同轮观察与收尾。** M仍须本轮Provider/Test→唯一-D→nested System/StartParameter两map/gradleProperty/effective installations→实际compiler，withDebug同worker、同文件Java/同安装jdb、attach前身份listener、紧邻spawn及after/end完整memory/disk/排他分存、原selector真实Gradle0/JUnit1/0/0/0及worker/debugger/listener正向退出、Capture无error EOF/drain。只能关联适用的已纠正薄入口，不能恢复旧慢采样先于Capture顺序；Provider间接观察限制明示。失败/unknown仍保全本轮输出和可得退出并收束本轮自有进程，不杀他人或覆盖旧证据；正常退出与异常路径均保证调用环境不写回父进程。由于入口不修改持久配置/源码为true，关闭是本次调用生命周期的内部后置条件，不存在可独立保留的“还原源码”结果；不得遗漏收束或用失败后的关旗声称M成功。若实现需要持久切换或独立恢复副作用，当前分组不覆盖，须报告。

旧verify-remapped-fresh-consumer g1启动前blocked/零写入零构建保留；新三个结果均未实施、无Result，均不能由本次文档完成推为completed。V/H输入改接新独立M及其gate，仍保留原修复、发现、P/Q/R/D/B等所有前置及原十二项合取；新增接线/回归仅为M前置，不增加第13个完整消费者，不要求旧blocked/failed成功或等待自己的gate。

### 局部独立复核范围与作者自检

已完整采用的首次局部独立复核结论为not-ready：同daemon关闭检查缺可执行编排，纯WIRE无实际消费依据却等待P/Q成功；该结论保留，不因作者修文改判。本次仅修正这两处，修改后的局部独立复核尚未发生，不能称review通过或ready。受影响复核范围为本节两次串行纯参数调用的编排、独立输出/daemon与新worker/独立oracle/退出drain和停止条件，以及Waves中WIRE item与所属Wave仅删除P/Q成功依赖；核对版本/修复适用性、共享写冲突、回归仍有的原前置、M真实P/Q前置和M→V/H/十二项合取等必要上下游。无需重审无关分支或不变权威；这是计划准备复核，不代实际验收或Scope确认。

**本次两阻断修正的作者自检（仅文档）。** 已回读四文档当前入口、两次调用方法、WIRE/回归/M的item与对应Wave行，以及V/H前置、共享冲突和最终合取。逐项核对：同outer argv/cwd/JDK/home、独立env副本与第二次显式pop、串行收束后分目录保存、同daemon可关联身份/新worker实际值与helper argv、外部oracle、两次真实test/退出drain和warning/unknown停止均有计划承载；withDebug保留且未引入withEnvironment或新daemon替代。仓内Work/Context/Plan/Waves入口、两次方法和局部自检锚点对应，新增wrapper相对引用已读到9.4.0，机制只引用已采用调查给出的固定版本公开URL，未把仓外Result路径持久化或称本轮重新核实网络来源。

联合等待按item前置＋所属Wave前置gate＋gate等待自身全部成员定点回读：WIRE只保留原发现item及发现/修复gate；其单成员gate→回归item及单成员gate→M→V→H，未引入自等、回边或新成员。原发现自身的Forge祖先仍保留，移除的仅WIRE直接额外P/Q等待，不宣称整条版本适用链已与Forge无关；回归Wave原三个gate及M的P/Q item/Wave双层真实消费前置未删。WIRE/回归/M仍各自一个独立Result，共享写运行仍串行，展示顺序不增加业务成功依赖。V/H显式M输入、完整M真实Java8编译打包/缓存身份、新hash补证、新案例覆盖、最终十二项及原验收等效强度保留；原failed/blocked/not-ready和历史gate未改判。本次没有重跑旧全图解析、构建、测试、Java或验证脚本，没有独立复核或实际隔离/消费者证据；该自检只证明本次计划维护检查已做，不声明ready、实施确认、item完成或gate释放。

以下为首次方案维护时的作者记录，保留其当时检查范围，不充当本次两阻断修正的复核或运行证据。

作者自检结论（仅文档）：本元组互链且唯一图；范围来自最新已接受意图，三族reuse仅不变产品/生产合同、PRD owner未知/权威写入skip；新项各一个可观察结果、证据和停止条件分别明确，依赖串行、冲突及联合等待可判，旧发现采用与旧消费者blocked不混同；原M完整链及V/H技术/历史义务保留，fresh解释局限本轮M；默认关闭不依赖日后人工还原，必要退出/保全是本轮内部条件；没有把外部Result路径、新证据目录或作者完成写成原始证据/实际通过。文档锚点、唯一ID及依赖的定点检查见本次维护Result；独立复核、实际传播/隔离、新helper编译与受影响回归、完整M均尚缺，不能从候选或旧gate推为已证实。

## Remapped 分结果恢复策略与作者自检

历史准备记录：原发现g1后续已完整采用；下述“仍缺关联/尚无Result”不再是当前发现状态。当前具体接线、版本补证及消费策略以[本轮策略](#消费者本轮内层重跑策略与作者自检)为准；未变原技术义务和全部失败历史保留。

**一个文档维护结果，不合并执行结果。** [Work](work.md) / [Context已采用事实](context.md#remapped-独立结果与差异核对采用事实) / [唯一配对Waves](waves.md#remapped-分结果恢复与证据关联)仍同目录匹配。沿用PRD codev-mixin-rework、ADR mixin-operation-isolation、Spec mixin-preapplication三族reuse/写入skip；本次仅C5纠正派发和登记，不改技术/验收/授权，不创建第二图。原“临时工具均为内部步骤”的分组已被独立failed/恢复/参数/Java8结果边界推翻，不能让一个Handler重放或重新领取这些终态。

**保留效果与原要求。** 原修正及聚焦20项随整组failed保留；夹具恢复11项passed但整组failed、第12项独立恢复completed、参数8项+汇总9行completed和同轮Java8选择completed分别登记，绝不改原两failed或旧审查blocked。工具/参数/选择成功不等于完整发现采用；20+11+1不得叫一次整组成功。已通过Kotlin编译、有效helper/producer接线、各分段检查与实际参数/Java8运行不重做。旧准备方法见下节，全部harness输入、共享Capture/调用方、受影响检查/未变检查适用、原全部同轮属性/来源/三断点/身份/资源/退出收束要求仍是覆盖义务。

**唯一剩余核对谓词。** 只读核对既存结果在最终适用版本上是否共同覆盖原完整发现要求，输出一个可判定的完整关联结论及逐项缺口；不是新工具产品、再执行参数或重跑发现，也不是M/验收。关联各份源码/加载class/Java/stdlib/hash与实际来源，分别对应20项、11+1、参数8项和一次Java8 invocation的函数、输入、环境、夹具变更和真实调用方；需要时只读核实差异，不以同hash替代输入/环境适用性，不把failed全组包装成当前全组passed。所有同轮属性/两map/compiler/worker断点/采样退出观察仍来自Java8那同一次invocation，不跨轮拼接旧14/17观察。明确已采用差异核对的覆盖限度，不能只据manifest、自动assessment或Producer graph行数判齐。任一缺证/身份不适用/真实差异则保留受影响缺口，不completed其完整覆盖谓词，不自动修复、重跑或接受偏差。

**M与最终门槛不下沉。** Producer graph日志各9行是可审输入，不是完整mapping/provider或fresh产物证明。Java8轮compileJava/jar UP-TO-DATE与外层Provider间接观察如实保留；不得把fresh M要求塞回Java8选择。独立M仍由不同后继Handler在自己的fresh原方法调用证明固定来源→patched→official client mappings→Java8 LoadMappings/真实Tiny obf/srg/named→显式srg→named RemapTask/producer/provider→原EVENT_BUS/named Entity.class consumer真实javac8/jar/classpath、全同轮观察及真实退出；不新增继承/override。V/H仍直接等M、十二项完整恢复合取/首轮映射/fresh三模块及根入口/最终两consumer观察，不增第13个完整消费者。

**依赖、停止与写边界。** 图仅把M的item/Wave两个发现成功输入接到新的完整关联item/gate；FIX-RESOLUTION/FIX-DISCOVERY/TEST-FABRIC-UTF8、G-REPAIRS及P-v6-a/Q-1165前置保留，相关Forge/Wave gates、M/V/H其它前置均不删。不要求历史failed/blocked或旧gate先转成功；各已独立completed只在其自身范围保留，不自动释放其gate。新关联只读、不构建/测试/下载/工具或源/fixture/配置修改，唯一输出为Result所述关联证据与缺口；与被核对源码/工具/输入/证据变动串行。后继运行共享Gradle/TestKit/build/cache/fixture与观察点仍串行即时排他；两类已确认准备错误例外及真实非网络失败/差异/身份或退出unknown/冲突停止均保持，无一般重试、新预算或额外审批门槛。

**作者自检与局部独立复核范围。** 本次方法为回读四文档差异，核对既存仓内引用与互链；逐项核对原发现义务分配、独立状态与证据范围、原item/gate保留、成员唯一归属、item前置+所在Wave前置+gate对全成员的联合等待，结果见本次Result与本节写后记录。受影响不同Handler局部独立复核仅覆盖：分段历史登记与failed/blocked保留；剩余只读关联谓词/证据适用性及缺口停止；M双层前置→V/H和最终第1/9款必要连接、原技术要求不减与共享冲突。无关已过P/Q/D/B及不变权威/第2–8/10款不重审。本作者不进行该独立复核、证据采用、实际完成或放行判断。

**本轮写后作者自检实测。** 四文件完整分段回读与内存中的精确编辑预期逐字一致，修改外原文保留（未落盘备份）。新增/变更段22个唯一仓内文件/标题链接均可解析；Work/Context/Plan/Waves互链与同目录配对成立。解析唯一图全部51个item、46个非空Wave/46个gate，成员各唯一归属、前置gate均解析；提取正向item前置（不把“不等待/历史输入”当成功依赖），联合item→item/所在Wave前置gate、gate→全部成员共97节点239边，DFS无环/无自等。定点复核原三修复及P-v6-a/Q-1165前置保留、M的item/Wave双层均改接新关联、V/H仍直接等M且H两处原有gate列举一致；旧复合/夹具failed及旧审查blocked不作现行成功等待。逐项语义核对原harness/生命周期/拒绝采样/同轮发现义务分配及M/V/H覆盖，原历史合同不改，未宣称全部执行证据齐备。仅文档自检，未运行项目/工具验证、未重算运行hash、未执行新完整关联或判任何gate。

## Remapped 生命周期恢复策略与作者自检

**历史准备策略。** 下文“一个Handler/一个Result/没有独立终态/尚未运行”仅描述独立结果产生前的安排；技术义务保留，派发/记录和剩余关联由上节及匹配Waves取代。

**当前准备范围。** 本节覆盖下节PREPARATION-RECOVERY原准备安排；[Work](work.md)、[加工事实/精确源码](context.md#remapped-参数unknown失败与生命周期恢复依据)、[唯一配对Waves](waves.md#remapped-生命周期失败后的独立恢复连接)仍为同一tuple。沿用Work所列PRD codev-mixin-rework（恢复目标/验收）、ADR mixin-operation-isolation（既有隔离决策）、Spec mixin-preapplication（生产/消费者合同）三族reuse、权威写入skip；本次无产品/架构变化。原编译真实成功、旧20/20适用已建立；参数实际启动后身份/退出/输出unknown，PREPARATION-RECOVERY failed及原gate不满足永久保留，不重放旧执行。用户已确认仅新证据根的临时harness合同纠正与生命周期接缝、受影响检查共同服务一个未完完整发现恢复谓词，一个Handler/一个Result；无独立工具消费者或单独采用/恢复终态，完整M另为不同Handler/fresh独立Result。此前独立复核completed/not-ready的权限缺口已由用户确认覆盖，历史判断保留；本次完成准备不等于纠正已实施、独立ready或执行/gate授权。

**保留编译、纠正临时harness。** 复用原compile/command.json、result.json、process-end.json与arguments/command.json的来源/编译输出/class/stdlib/Java身份；Context中的helper/class摘要为前轮核对事实，本轮未重算。未来实际调用前核对受影响源码/编译class/实际加载来源及命令适用性，成立则保留编译成功，不重跑 `compileTestKotlin`；真实漂移只报告受影响缺口，不擅自重编译或重放源码恢复/P/Q/D/B。原ArgsCheck的两参反射、直接value实参与 `build --stacktrace --info` oracle不兼容真实helper，旧参数仍unknown。仅新根ArgsCheck改为反射一参 `patchedMinecraftArguments(String)`，以 `basic-patched-test` / `remapped-patched-test` 为唯一实参；输入值通过本次参数测试JVM的 `org.gradle.java.installations.paths` System属性送入真实helper，不把value当第二参、不复制函数。缺失/null用System.clearProperty，空值用System.setProperty设空串，另两例设完整非空多目录/含空格多目录；每例显式设置或清除，结束恢复原System属性，避免用例串值。断言实际原序列 `[jar, printCompileClasspath, -s]`，仅非空追加一个完整同名-D单argv、无冲突-P，不嵌shell引号或拆目录。保留8项与汇总9行原合同；新编译仅限临时ArgsCheck本身，不改真实helper、PatchedMinecraftTests.kt、生产、fixture、用户gradle.properties或旧证据。

**最小生命周期接缝（仅新build根内，与上述harness共同准备，待受影响局部独立复核）。** 沿用现存run.py/arguments.py与Capture，不另造控制框架。把spawn_sampled中Popen之后的慢post-spawn扫描后移：Popen后立即把拥有的proc交给调用方，调用方立即建立唯一Capture并尝试保存真实PID/创建时间/cmdline/cwd身份，然后才保存完整post-spawn资源/排他样本，最后wait、join drain、封存结束状态/输出并解析。保持紧邻Popen前完整memory/disk及排他检查、spawn两时点和after/end分存；实际采样时间如实记录，不把后移样本伪称紧邻。Popen起至收束保存置于原调用方的异常保全边界内，proc不在慢扫描/文件保存失败时丢失；若Capture建立本身失败，保持proc可得并记录输出/drain未知，不创建第二个reader来假定补齐。使用现有Capture.thread（非cap.t），只有线程结束、真实EOF且无Capture.error才算drain，不能仅看finally置位的eof。

共享影响闭包为run.py::spawn_sampled→arguments.py、compile.py及run.py::main，另有self-check.py受控Popen和main pre-spawn接缝。选择共享接缝时须同步迁接新副本这些调用方各自的Capture/身份/异常/收束，保留原日志目标及单一stdout reader，不能参数用一个Capture、main再读同一pipe，或main仍等慢扫描后才Capture。compile.py只需必要接口适配/检查，不要求重跑已成功编译；jdb独立Capture不改变。若最小原接缝无法保住proc/异常证据/原采样合同，报告准确缺口，不以新wrapper、睡眠、无限等待、一般重试或伪造身份解决。

立即取身份仍可能遇到短进程先退出；此时身份仍unknown、本次失败并停止后续启动，但同一次已拥有Popen的可得真实退出码和输出须尽力收束保存，不能让NoSuchProcess再次在wait/保存前逃出，亦不能吞错通过。post-spawn扫描/身份保存/Capture读出异常均须留下原错误和可得退出/输出；保存失败也如实报告不可得部分。所有wait/join遵守实际工具控制上限及原收束方法，不新增无限等待。不得凭PID消失补身份、把Python码作Java码或把exit0/有输出代真实身份。

**工具新鲜度与必要验证安排（本次不执行/不写新自检）。** 原20/20仅对原hash字节及已记录输入/环境成立。新根ArgsCheck.java/实际harness class、run.py/arguments.py及受影响compile.py/self-check.py等每份实际新字节分别记录SHA-256、来源/差异/调用方及检查→函数对应；参数实际加载的helper class/源码/stdlib/Java身份另与保留编译关联，不用harness新hash冒充helper变化。受影响harness合同/生命周期/拒绝/采样检查在新同版工具上补齐；未变检查逐项说明函数/输入语义/环境适用，不沿用旧工具hash标称整组新20/20。沿用现有self-check接缝补必要受控用例：Popen后Capture/身份先于慢扫描且仅一次reader；快退出身份unknown仍保存可得exit/输出并失败；扫描/保存异常保留proc并收束/不吞错；正常exit0/非0、线程未结束/读错误的drain判定及main/参数/必要compile适配。原同文件别名/合法javaw错配/缺jdb、PID/创建时间/cmdline/cwd/listener认领与attach拒绝、紧邻pre-spawn完整字段/时间倒置拒绝、旧输出不复制与main截点仍有效；改到共享路径的用例须新同版重验，仅确证未受影响的检查按原结果复用，不重跑无关131项或已过分支。

真实参数回归仍只一次新Java调用，按上述一参/System属性合同加载原编译实际class/共享函数并记录Java/classpath/stdlib/harness源码及class/真实helper源码及class/加载位置；basic/remapped各缺失/null、空、非空多目录、含空格多目录共8项，原三参数、唯一完整非空-D单argv/无冲突-P全部检查。真实身份、Java exit0、Capture.thread已结束、无error且EOF成立，8项passed加汇总共9行与process-end/output/result的PID/时间/class SHA/方法/输入唯一关联全部成立，才允许启动新完整发现；任一失败/unknown停止，不用旧输出补新轮。System属性四输入只影响临时参数测试JVM，不写用户配置；harness编译成功或受控Popen检查不代真实8项通过。未来参数Result、hash和完整发现证据只引用仓内相对路径，预定新根不当当前已存在证据。

随后必须一次新同版原remapped精确方法实跑，继承FORWARDING/RESTORATION/VALIDATION/PREPARATION原全部要求：Provider→Test System→唯一完整同名-D→nested System/StartParameter两map→gradleProperty/effective installations→真实compiler metadata8/executable关联原列表；同worker三断点/启动暂停认领、Process.exe/Command/cmdline[0]同文件、同bin jdb及attach前身份/listener复核，全部拒绝/紧邻真实spawn完整资源/排他/分存，Gradle0/JUnit1/0/0/0及launcher/worker/debugger退出、drain/listener收束。外层Provider间接观察限制保留。发现新工具字节必须贯穿此轮，不能参数修后又换main版、用旧invocation-10或受控检查代证。参数通过前禁止启动；完整M仍独立fresh真实Java8 javac/jar/classpath/producer/named全链，V/H十二项与原最终合取不减。

**停止、冲突与完成。** 两类准备错误例外原样沿用下节：只有可选材料定位错误、或证据确认目标零启动的命令解析错误可在无未知副作用且不扩范围时最小纠正；本次PID300888及身份/退出unknown不属例外。原实际编译/参数/自检/发现失败、关键身份/退出/输出unknown、冲突仍停，无新预算/额度/一般重试。未来写边界仅新build根的临时ArgsCheck合同纠正/自身编译、薄入口与必要受影响检查及本轮正常证据；生产/真实helper/PatchedMinecraftTests.kt/fixture/用户配置/Git/旧工具旧证据只读，不重跑已通过Kotlin编译。当前无活跃执行者不代未来即时排他。新恢复item/gate→完整M的item/Wave两个成功输入→V/H及最终第1/9款由Waves唯一拥有；旧failed/gate仅保留历史，不作成功等待或回填。Plan完成仍须原G-RECOVERY-INTEGRATION及G-ACCEPTANCE，本次均未满足。

**作者自检及精确定点独立复核范围。** 本轮完整读取指定独立复核Result，将其合同阻断、共享生命周期诊断与用户已确认边界逐项对齐；定点读取真实helper/withArguments及封存ArgsCheck，确认一参/System属性/原三参数和basic/remapped×四输入设计对应，未运行它们或重算helper/class摘要。只维护四文档当前入口、Context确认事实、本节harness及生命周期/检查方法、既有open恢复item/单成员Wave/gate、共享冲突说明及V/H/最终第1/9款必要说明；item/Wave成员与依赖不变，M两层仍消费同一新发现成功输入。保留PREPARATION及SHELL/VALIDATION/RESTORATION failed、旧unknown/停止偏差/9备份、编译成功和旧20/20适用条件，原完整发现与M/12项合取未减少。实际回读、仓内引用与必要联合等待闭包检查见本次Result，不沿用旧全图统计。不同Handler受影响局部独立复核范围为授权/harness与真实helper、唯一Capture/共享调用/异常保存、每份新字节身份与检查新鲜度、新发现item/Wave→独立fresh完整M两层→V/H/最终合取；不重审无关已过P/Q/D/B或不变权威/最终其余条款。本次仅作者自检，不自行review、派发、判断ready/实际item完成、采用新执行Result、接受偏差或释放gate；Router保留后续判断，已确认范围不重问。

**以下PREPARATION/SHELL等节保留原准备时点，当前策略以上节为准。**

## Remapped 准备错误边界与独立恢复作者自检

本节为现行策略，覆盖下节原shell准备时点；同一Work/Context/Plan/Waves owner及配对不变，三族reuse/写入skip沿用Work既有评估。SHELL-RECOVERY generation1完整failed Result已关联采用；[本轮报告](../../../build/recover-remapped-java8-forwarding-shell-recovery-20261025-g1/report.md)记载未确认存在就读取自猜可选environment.json导致ENOENT，该文件不是必需Handoff引用。零编译/原remapped启动、零实际参数回归；仅新增失败证据根和报告，未改源码/工具/旧证据/协调图，未做摘要比对，不宣称全仓稳定。20/20既有通过保留，但本轮未完成当前字节、完整输入/覆盖和Python/psutil/Windows接口适用性判断，不宣称本轮复用完成。此前shell局部ready仅覆盖未变方法，不代本次差异独立复核。

仅两类准备错误可纠正继续：可选材料定位错误，或有返回/执行证据确认目标进程尚未启动的命令解析错误；先据真实返回及执行记录分类，保留错误、依据和纠正记录，确认无未知副作用且不扩大原范围后再继续。错误返回本身不证明零执行；效果未知先只读核实，未能消除未知即停，不盲重试。先利用既有文件清单定位，禁止猜文件名作必需证据；可选材料不存在可查正确来源，不伪造environment文件；必需输入确实缺失仍blocked。实际工具自检、编译、参数回归或内容/发现验证失败，以及身份不明、资源冲突、退出状态未知仍立即停止，不扩展为一般非网络纠错或重试机制。

保留下节全部方法与原发现FORWARDING/RESTORATION/VALIDATION技术谓词，不重改源码、工具或夹具，不无理由重跑20/20；先完成其字节/输入/环境适用性核对，再经正确PowerShell入口完成编译、真实共享参数全部用例，以及一次新同版原方法完整发现、逐次紧邻spawn的memory/disk/排他采样、同文件java/同bin jdb/attach即时复核、全部拒绝用例与真实退出/drain/listener收束。新输出根仅普通文本预约 build/recover-remapped-java8-forwarding-preparation-recovery-next，不创建或当现存证据。

唯一执行图新增独立恢复item/Handler/Result及单成员Wave/gate，继承旧SHELL-RECOVERY全部原发现谓词但应用本节新停止规则。完整M的item及Wave两个成功前置均改接新足证据，仍不同Handler、fresh原named全链真实Java8编译打包/classpath/producer及Gradle0/JUnit1/0/0/0；V/H仍等待完整M及十二项合取。旧SHELL-RECOVERY及更早failed/未采用completed/旧gate保持，不要求旧失败先转成功；新成功不回填旧item/gate或接受停止偏差/9备份。共享helper/fixture/Forge/Gradle/TestKit/build/cache/观察点串行排他，不占用本次文档维护的构建资源。

**作者自检与精确定点独立复核范围：** 仅本四文档当前入口、新失败/未完及20/20适用性、两类准备错误的证据先行分类和其余实际失败停止、新恢复单一发现谓词/原完整要求继承、前置三gate及冲突、新item/Wave/gate→完整M两个改接点→V/H和最终第1/9款现行输入。旧shell及更早item/Wave合同保留；第2–8/10款、P/Q/D/B原验收与最终十二项不重审。作者只做文档回读、受影响互链和等待闭包检查；实际自检证据在本次Result，不沿用旧统计。不同Handler局部独立复核仍须覆盖本次差异，不由旧ready或作者自检代替；作者不实施/调度/采用新Result或释放gate，不另增同范围确认关卡。


## Remapped shell恢复策略与作者自检

本节覆盖下节前轮“待修夹具/整组未过”的当前安排；旧作者记录与原完成条件保留。事实见[Context](context.md#remapped-validation-shell失败与复用边界)，所属[Work](work.md)及唯一配对[Waves](waves.md#remapped-shell失败后的未完恢复连接)不变。三族权威reuse/写入skip及用户原确认范围继续有效，不重审已支持API/compiler方法或已过P/Q/G-REPAIRS/basic/producer。新恢复仍只有“原完整发现全部要求成立”一个终态，编译/实际参数回归/新采样都是该谓词内验证阶段，不另立工具或源码交付。

最小方法：保全已写源码、有效API/provider/compiler回调和20/20工具字节，按Context工具身份/输入/环境适用条件复用，不再修snapshot夹具、不无理由重复自检、不重做basic/producer。通过实际可用powershell工具运行PowerShell并显式设项目根；若只能经Bash调用，必须使用明确可用的 `pwsh -NoProfile -Command` 入口，不能把 `& ./gradlew.bat` 或PowerShell查询直交Bash。后续保存实际shell/入口、命令、cwd和真实退出证据，先完成原 `:minecraft-codev-forge:compileTestKotlin`，再实际执行原withArguments所用共享构造路径的basic/remapped、多目录含空格完整单argv、缺失/空值、原三参数和唯一-D/无冲突-P全部用例，不能以文本检查或复制实现代替。

随后一次当前同版原remapped精确方法完整满足原FORWARDING、RESTORATION及VALIDATION全部发现条款：Provider→Test System→唯一完整同名-D→nested System/StartParameter两map→gradleProperty provider/effective installations→真实compiler metadata8/executable关联原列表，原三断点/同worker/启动暂停认领及同文件java与同bin jdb/attach复核/全部拒绝用例。每次真实启动前排他及紧邻Popen完整memory/disk、spawn/after-spawn/结束样本分存，真实Gradle/JUnit/worker/debugger/输出drain/listener收束，外层Provider间接观察限制全部保留。20/20、编译、旧invocation-10、受控Popen或初末idle不能代完整发现。真实新非网络失败立即停止，缺权限/能力/输入blocked、尝试失败failed、关键观察/身份/退出unknown不完成；预期外方法差异只报缺口，不扩源码、不新造脚本框架、预算/分钟/重试/权限例外。

未来输出仅普通文本预约 build/recover-remapped-java8-forwarding-shell-recovery-20261025-g1，不创建或作为现有证据链接。新发现足证据completed Result由Router完整读取/关联/采用后才可判断新gate；完整M的item和Wave改接此新实际满足前置，仍另一个Handler/Result的fresh原M全链named消费，真实Java8 javac/jar/classpath/producer及Gradle0/JUnit1/0/0/0不减。V/H仍直接等完整M、最终12项合取不变。旧VALIDATION failed/旧gate不满足、更早failed及未采用completed、十次启动违规/9备份、exit127后继续偏差分别保留，不接受、不改判、不覆盖旧证据。

**局部作者自检范围。** 对照完整failed Result、仓内report/20项结果及四文档，检查失败/通过/未完区分、复用条件、shell入口与停止条件、单一新item/Handler/Result、原发现要求继承，P/Q三成功gate→新发现→独立完整M→V/H必要闭包及共享冲突；检查M的item/Wave两个改接点、V/H/最终第1/9款与12项合取、唯一配对互链/现存相对证据、旧失败合同保留和引用解析/无环无自等。具体实际检查结果只在本次Result报告，不把本段当运行或独立ready证据。不同Handler定点复核只覆盖上述差异及必要闭包，不重审无关历史/已过分支；本次不运行编译/工具自检/Gradle/测试/进程探测/下载，不写源码/工具/配置/权威/Git，不派发或释放gate。

## Remapped 自检失败后的未完恢复与作者自检

**现行策略。** 沿用Work权威链接下PRD codev-mixin-rework、ADR mixin-operation-isolation、Spec mixin-preapplication及译本的可靠reuse评估，三族写入skip；功能/架构合同及用户已确认范围不变。事实见[Context](context.md#remapped-自检失败后的未完边界)，唯一图见[Waves](waves.md#remapped-自检失败后的未完恢复连接)。下节五项方法仍是验收来源，但其basic/producer恢复已写，不能重放；旧作者统计仅属当时。旧恢复failed及其原Wave/gate完整条件保留，新Result不自动完成旧项。

最小未完方法为：保留共享patchedMinecraftArguments及原producer循环，不再编辑生产/fixture来重复恢复；只在未来全新build证据目录内沿用现有私有run.py/self-check.py副本，纠正snapshot替身使其按真实输入清单提供before[x]所需键和值，不更改生产输入合同、绕过main检查或削减用例。未来目录例如build/recover-remapped-java8-forwarding-validation-next/仅为普通文本预约，不是已产出证据ref。完成同版完整工具自检（包含原19项及此前未到达的“不备份旧输出”main分支/其余用例）；19项历史通过不能替代整组通过。继而编译并实际执行withArguments使用的共享参数构造路径，覆盖basic/remapped非空、多目录含空格为单argv、缺失/空值、原三个参数、唯一-D/无冲突-P的全部既定用例，不复制另一套实现、不另造工具或重做131项。

这些辅助纠正及回归只服务“恢复后原发现全部谓词成立”这一个终态，无独立工具/源码消费者或Result；同一Handler/Result随后取得当前同版一次新原remapped方法的完整发现链、三断点/同worker、真实Gradle/JUnit、紧邻spawn完整资源/排他与前后分存、正向退出/输出drain/listener收束，全部继承下节五项方法及原发现合同。旧invocation-10或受控Popen/初末idle样本不能拼入本轮。非网络实际失败仍立即停止，缺输入/权限/能力blocked、实际尝试失败failed、身份/退出unknown不完成；夹具已知可修不构成失败后继续豁免，无新次数/分钟预算/在线授权。若出现预期外源码/工具方法差异，只报告准确缺口并停止受影响执行，不自行扩修。

新恢复足证据Result及其gate只供显式完整M；M仍由另一个Handler/独立Result、新fresh原方法完整消费，保留真实Java8 javac/jar/classpath、全部mapping/provider/producer链、原producer动态输出、Gradle0/JUnit1/0/0/0及同轮观察/收束。P-v6-a/Q-1165/G-REPAIRS既有实际采用输入不重做；完整M不等旧failed gate或Neo/R/D/B。V/H继续显式消费完整M及新发现前置/旧恢复失败、原12项合取及fresh三模块/Forge三类/根入口/不同Handler验收。共享源码接点、Forge/Gradle/TestKit/build/fixture/cache/取证写运行仍按最新状态串行。

**作者语义自检与局部独立复审边界。** 本次仅维护四文档的当前入口/上述方法、新恢复item/单成员Wave/gate、完整M两个发现改接点、冲突表和V/H及最终第1/9款必要说明。逐项对照failed完整Result与仓内报告：19项≠整组通过；basic/producer已写≠编译通过；0启动≠真实发现/退出通过；新恢复没有重复源码交付或独立工具终态。原发现/旧恢复item与Wave/gate正文、完整M验收、P/Q/G-REPAIRS输入及其它最终条款保持。受影响等待路径为既有三gate/P/Q输入→新发现恢复→完整M→V→H，旧failed/gate仅历史、不进入成功祖先；新gate不等待完整M/自身，无环或自等；V/H不以发现替代完整M或增加第13个完整消费者。具体差异与引用/原块保留检查见本次Handler Result，不把前轮42/37等统计当本次执行证据。

不同Handler局部独立复审应只覆盖本节及Work/Context最新失败与已写效果、新item原验收继承/停止条件、旧failed item/Wave/gate不回填、M两个改接点、共享冲突、V/H/最终第1/9款与12项合取必要连接；只核既有P/Q/G-REPAIRS采用未变，不重审无关历史或有效API/已过分支。本作者不派发、不模拟独立复审、不实施/采用/释放gate或宣称ready；未决为局部独立复审、未来实际验证足证据与Router采用/gate判断，历史偏差未因新技术成功获接受。不变范围不重求许可，受影响C6判断归Router。

## Remapped 核查后的最小恢复策略与作者自检

### 已确认范围与保留证据

本节是原确认范围内的恢复维护，取代下方前轮M策略中的待实施事实与当前成功等待；历史作者记录不回写。采用事实见[Context](context.md#remapped-核查采用与未完恢复边界)，唯一执行图见[Waves](waves.md#remapped-发现核查后的恢复连接)，Work保留同一入口。PRD/译本、隔离ADR、Spec/译本reuse且写入skip。用户已确认basic保持、remapped同值转发、仅移动compiler输出、新根私有工具和发现/完整M两个独立验收；不新增产品行为、公开API、生产、consumer、版本、依赖或用户配置。

原发现generation1的原始completed报告、核查completed但整体不足以采用、旧item/gate未满足是三个并存事实。invocation-10同轮属性/Java8实际选择/Gradle0/JUnit1/0/0/0/同安装jdb实际使用及收束保留；compileJava UP-TO-DATE只证明选择而非执行，projectProperties含同值不叫空。外层Provider无直接帧的限制保留。可复用已写API/provider、compiler配置完成回调和适用的方法/来源；恢复改变源码或工具后，旧轮不能代新轮同版观察、回归、即时排他/资源及收束，不重做有效迁移或已过P/Q/D/B。

### 最小修复及证据对应

以下修复、聚焦回归和取证只服务一个“原发现全部要求在恢复后成立”的终态，无独立工具交付；完整M是其独立后继终态，item/Handler/Result/gate只在Waves定义。

1. **恢复原basic并保留remapped增量。** 在当前PatchedMinecraftTests.kt原helper内，使basic-patched-test和remapped-patched-test均沿原System属性非空guard追加一个完整同名-D；原[jar, printCompileClasspath, -s]、值字节/空格/目录顺序、withDebug(true)/withPluginClasspath/forwardOutput、Test17及fixture.gradleJava不变。基线取本次进入工作区及已采用修改记录，禁止用更旧Git HEAD替换。未来小回归必须实际执行本helper用于withArguments的同一参数构造路径，不能另写一个只供测试的复制实现或只做文本模式检查；确需可调用接点时仅提取原构造几行并由原helper调用，不改变可见公共API。逐例记录basic/remapped非空、含空格多目录作为一个完整argv元素、缺失、空值、恰一次-D及原参数保留/无冲突-P；不以五个无空格目录的一次实跑替代。
2. **恢复进入时producer诊断。** 保留已经有效的fixture API/provider及projectsEvaluated的两行compiler输出，不重移、不改compiler或新增任务。只恢复printCompileClasspath.doLast原末尾 `gradle.taskGraph.allTasks.forEach`，仍打印每个task.path及 `task.taskDependencies.getDependencies(task).map { it.path }.sorted()` 的 `Producer graph: ... <- ...`；已采用进入时修改记录提供该循环，不从Git旧版重建fixture。源码差异核对须证明仅补回这段原输出，完整M实际到达printCompileClasspath时再提供真实输出；发现回调不因此多出任务图/classpath依赖。
3. **新根私有工具不再备份旧输出。** 只在全新build证据根修现有薄入口/helper副本，去掉复制旧XML/HTML的分支；只保存本轮正常输出及必要只读身份清单，不清理或复制已有9个备份、旧XML/HTML/日志，不覆写旧工具或证据。小检查实际调用该分支并断言没有旧输出复制，旧数据只读；不新建备份策略或证据框架。
4. **同一java文件身份与必要拒绝。** 延用原“正常spawn→暂停期认领→派生同bin jdb→attach前复核→先设三断点后cont→同worker nested观察”时序。对实际Process.exe、封存Test启动Command和cmdline[0]核同一个java文件；安装根相等、名称合法或字符串规范化不是充分条件。路径别名用平台已有同文件身份检查（如os.path.samefile）处理，无法核实即拒绝；jdb只从已核实exe的bin派生，不由PATH/其它JDK替代。实际调用同一私有校验函数的小自检覆盖同文件别名正例、同安装但不同合法java/javaw文件错配负例、缺jdb、PID/创建时间/cmdline/cwd变化及listener归属变化在认领/attach复核处拒绝；可用私有文件夹和受控快照，不探测/另起JDK来凑负例。只补原保证的检查与用例，不重做131项/候选框架。
5. **纠正完整启动前采样。** 沿用已有memory/disk/排他字段及保存方式，完成耗时准备后、实际Popen前紧邻取得完整资源和排他样本，再spawn；无准备工作插在采样与spawn之间。各次启动前排他样本、完整紧邻spawn资源样本、spawn时点、after-spawn及结束样本分存不可覆盖，关联同轮源码/输入/UTC/调用/阶段；先后由真实采样和spawn记录判定，不能只检查三个文件存在或把post-spawn算pre-spawn。实际运行采样与调用同源，小检查覆盖先采样再spawn的顺序及缺字段/时间倒置拒绝；不补写旧时点、不恢复分钟预算/新增等待或重试机制。

### 新发现与完整M的证据及停止界限

新发现恢复必须独立证明原发现全部同轮链：既有Provider→Test System→原方法最终唯一完整同名-D→nested System/StartParameter.systemPropertiesArgs含键、projectProperties无冲突-P（允许记录真实同值）→gradleProperty provider/effective installations→实际compileJava.javaCompiler解析metadata=8/executable与列表对应，及全部聚焦回归、工具拒绝/分存完整资源/即时排他、真实Gradle/JUnit/退出输出收束。外层Provider间接关联的限制不抹去。旧invocation-10可作方法与历史实证，不能拼入恢复后新调用。

若发现已完整但下游consumer失败，发现的证据可独立判断；真实Gradle/JUnit失败与未到达阶段照实保留，非网络实际失败仍停止，不得因自称发现成功、语法可修、工具可修或旧P-v6例外继续启动Gradle。缺输入/权限/能力按原合同blocked，实际尝试失败failed，关键观察/采样/身份/退出unknown不完成。任何再执行由Router按原授权与真实效果决定，本计划不新增预算/额度、循环重试或失败后继续例外。

新发现恢复Result即使completed也不自动完成旧发现item或释放旧G-REMAPPED-JAVA8-FORWARDING；其新gate须按原发现全部要求实际判定，完整消费者才有合格前置。十次启动/停止违反、producer额外删除及XML3+HTML6备份是历史偏差，恢复不消除，作者不作接受决定；Router及用户处理实际采用。技术恢复与偏差采用分开，后者不是可由新技术成功自动证明的谓词。

完整M保留自己的独立Handler/Result、新fresh原方法调用及原全部合同：MC1.16.5/Forge36.2.39/userdev，实际userdev/MCP/universal/libraries/modules→patched→official client mappings(server=false)→原Java8 LoadMappings official→MCP→真实Tiny obf/srg/named→显式srg→named RemapTask/provider/producer→原EVENT_BUS/named Entity.class Java8 consumer真实compileJava/jar/printCompileClasspath、fresh patched/named/consumer class/Jar与完整classpath/字节身份。本轮两map/provider/effective installations/compiler、真实javac执行、Gradle0/JUnit1/0/0/0/排他及退出收束仍必需，UP-TO-DATE或发现回调不代编译；原producer诊断须在真实printCompileClasspath输出可见。V/H仍消费完整M与12项原合取、fresh三模块/Forge三类/根入口，不把发现算第13个完整消费者，不重跑已过P/Q/D/B。

### 受影响闭包、作者自检与独立复审

当前图新增一个发现恢复item及单成员Wave/gate，原发现item/Wave/gate逐字保留；完整M的发现成功输入改接新恢复Result/gate，其P-v6-a、Q-1165、G-REPAIRS前置不变，V/H仍直接消费完整M。共享helper/remapped fixture、新根工具与所有Forge/Gradle/TestKit/build/fixture/cache/观察点按最新工作树串行排他；历史basic结果不重做，但当前basic回归须在本恢复内实际修复/回归，不能以历史D/B通过掩盖。旧未满足发现gate、两M失败gate、Neo/R/D/B均不是新发现成功等待；无自等或旧gate死锁。

**作者自检记录（本次实际静态检查）：** 四文档全部新增/替换段已逐字回读一致；按编辑记录逆向还原后，各文件SHA256均与进入本次的原文基线相同，证明修改外历史保留。唯一图现有42个item定义、37个非空Wave；原发现item及其Wave/gate正文不变，40个原item块、35条原Wave行逐字保留，唯一旧item改动是完整M的发现前置及必要说明，另增加一个恢复item/Wave/gate。只追受影响的发现恢复→完整M→V/H及必要输入，联合47个item/Wave/gate等待节点引用可解析且无环/自等，已排除“明确不等待”措辞被误当正向依赖；新发现无旧未满足gate、Neo/R/D/B成功祖先，完整M实际等待新发现恢复Result/gate，V/H仍等待完整M。24处受影响仓内文件/目录/标题链接均可解析；原发现全部义务、完整M/12项合取、basic/producer恢复、历史偏差不自动采用及写运行串行相互对应。这里只验证派生文档，不证明回归已运行、Result已采用、独立review通过或gate满足。

**精确独立复审范围：** Work新增当前M入口；Context本节的Result关联、invocation-10可采用边界、回归/9备份/十次启动与停止违反和缺证；Plan本节的五项最小恢复方法、同版证据/偏差不自动采用/原M不降标及本作者自检；Waves新增恢复item/单成员Wave/gate、原发现完整合同保留、完整M的两个改接点、共享冲突表、V/H前置和最终gate第1/9款必要解释。只核P-v6-a/Q-1165/G-REPAIRS输入未变、完整M全链/12项合取不减及旧gate不回填；不重审有效API、已过P/Q/D/B、其它历史或未改最终条款，不重做独立核查或派发复审。

本次仅文档维护与作者自检，未实施、未运行构建/测试/自检脚本/JDK/进程探测/下载，未改源码/工具/用户配置/缓存/Git，未复制、删除或覆盖备份/历史证据。不同Handler受影响独立复审、后续派发、实际证据采用及C6是否需要受影响确认均归Router；不重复要求不变的已确认范围，不代为宣称ready、接受偏差、完成item或释放gate。


**当前M范围说明：** 原M/API恢复现均failed、已写fixture保留；新标准属性恢复以[本轮策略及自检](#remapped-标准属性恢复策略与作者自检)为准。下文basic已完成接线及各历史“remapped无新增-D”限原时点/旧item，不约束用户新授权的未来计划，也不追认旧失败；本轮不实施，待不同Handler局部复审及用户实施确认。

**当前维护：用户已接受本次P-v6在线次数偏差，技术证据采用条件待局部独立复审。** 原P-v6 item/Result保持partial、G-FORGE-REBUILT-CONTENT仍未释放；5标online入口（1次Java前失败、4次实际在线Gradle）及normalOnline=2重分类并存，不以2/3证明未超限。例外只接受既发生的本次偏差，不增加未来在线额度，不改旧账本/日志或降低完整技术标准。P-n-v完整completed及源码gate满足仅登记Router已采用事实，不重做。本轮只维护四文档及作者自检；新的只读证据核对item/独立Result与后继条件仅为准备，不执行、不采用或释放任何gate。事实见[Context](context.md#p-v6-一次性偏差接受与技术证据)，策略见[Plan](plan.md#p-v6-既有技术证据采用策略)，唯一图见[Waves](waves.md#p-v6-例外下的证据采用连接)。

## P-v6 既有技术证据采用策略

**唯一变化与权限。** 用户已接受本次既发生的在线次数偏差并授权条件维护，见[Context](context.md#p-v6-一次性偏差接受与技术证据)。原P-v6 item/Result继续partial、原完整标准及G-FORGE-REBUILT-CONTENT未释放保留；只改变此次例外下采用已通过技术证据的条件，不宣称原3次约束满足，不授权新增在线、生产或技术重跑。P-n-v已采用完整completed/源码gate满足直接沿用，原P-n partial/旧源码gate不回填。三族authority reuse/写入skip沿用Work，不重求同一决定或不变范围许可。

**最小采用机制。** 准备一个显式只读证据采用核对终态，判断已关联P-v6 partial中的完整技术证据在此次例外下是否足以供后继消费；一个item/Handler/独立Result、单成员Wave/新gate仅归[唯一Waves](waves.md#p-v6-例外下的证据采用连接)。它不改旧Result或释放旧gate，不生成新的产物验证运行记录。文档作者completed、局部独立review completed、backend completed或用户接受偏差都不能替代该独立Result的completed/足证据及Router实际采用；本次只准备，未执行或放行。

**技术要求不减、已通过检查不重跑。** 复用Router已完整读取关联的verify-forge-rebuilt-content-redelegated generation2 partial和[仓内续接报告/实际索引](../../../build/forge-rebuilt-content-validation-g1/pv6-continuation-report.md)，逐项关联原P-v6全部技术谓词与身份适用性：source/实际loaded classes/code source/runtimeClasspath、完整raw输入/声明顺序/tool/JVM；Core逐文件Murmur3-32及signed-byte排序去重聚合、operation10与7/8/9隔离、key与有序身份区别、root/key/basename/path；真实首次miss→task-action rebuild→fresh完整oracle→同path全离线真实hit→再次完整oracle、fresh/frozen/cache/两次final字节。四引用raw独立预期/负例及新rename/实际normalized overlay闭合、两处有效reference身份适用、reader正负/完整parents/Object+bk、68序列/19声明first-win、全部4782 class/body/成员/继承/属性/异常/引用/AT、typed及11方法、ItemPredicate/BlockFluidBase、资源/归档/manifest/marker均按原合同，不以数量或摘要代完整技术证据。原4项basic空集/合同覆盖损失及纠错失败/日志仍披露，不升级动态覆盖，不豁免后继实有载荷。核对只关联现存通过，不执行这些检查或要求重新取得旧Result；若实际缺证/来源冲突/身份不适用/需额外权限，报告受影响缺口，不虚构、改预期或自行扩展恢复。

**例外仅此轮。** [原账本](../../../build/forge-rebuilt-content-validation-g1/network-attempts.json)的5标online入口、1次Java前失败、4次真实在线Gradle、normalOnline=2依赖物化重分类及旧保守3计数并存，不能用2/3证明未超限。例外只解除这些既发生偏差对新证据采用谓词的阻挡，不改旧P-v6原次数合同/旧gate、不返还次数或提高未来额度、不授权新在线；hit已经全离线。未来Q/R/D/B/M/V/H的必需真实验证、重试上限/非网络停止、真实退出/分存/身份/冲突要求按各自合同不减。分钟预算撤销继续有效，不新造时钟、时间上限或形式签收门槛。

**后继与局部复审。** 8个完整P消费者只换为该新证据采用结果/新gate，不等待原P-v6 partial转completed或旧gate释放；各分支T/Q/R/D/B/M业务依赖、同版三模块fresh/根入口V及不同Handler验收H全部保留。Plan全量完成仍须G-RECOVERY-INTEGRATION/G-ACCEPTANCE，本次未满足。不同Handler的局部独立复审由Router安排，范围仅本次例外/原标准等价、新item/Result/Wave/gate、8消费者及最终第1/10款必要连接；不重开未变三族和无关全图、不模拟复审或自动采用/放行。

**以下入口保留前轮规划与作者记录，当前连接以上述入口及其定点更新为准。**

**当前维护：P-n generation1 partial已采用，保留两owner/version10，只恢复未完编译与四引用验证。** 原P-n item/Result/源码gate及不满足历史完整保留，不续跑或回填。新P-n-v独立恢复Result消费已写源码及适用旧证据，补齐原P-n完整源码终态，不重做生产修改或两处有效reference修正；P-v6改消费恢复足证据，仍独立证明新实际加载、全部4782及原oracle、version10真实miss→rebuild→same-path hit→再次完整检查。8个完整P消费者及Q/R/D/B/M/V/H业务依赖不变。下方旧P-n待写/直接消费P-n和“两项/两Result”措辞保留原规划时点，现以[恢复策略](plan.md#p-n-partial后的未完验证恢复策略)、[采用事实](context.md#p-n-partial采用与未完验证边界)、[唯一现行连接](waves.md#overlay-未完验证的现行连接)为准。沿用PRD/ADR/Spec reuse与已确认范围，不重求许可、不重开预算研究；本轮仅四文档作者维护，不执行恢复、派发复审、推进item/Todo/gate或宣称ready。

**当前：用户已明确“不需要分钟预算”，撤销P-n→P-v6统一分钟政策。** 不再要求共用1800秒/30分钟截止、起点前双时钟采样、跨Handler共同单调时钟证明、交接扣时、全链阶段耗时/上界估算、至少60秒收束及独立保存余量证明，亦不再调查最终Result发布耗时。这些预算派生义务不再是P-n/P-v6启动、继续、Result采用或gate验收的前置；不新增替代时间上限、估时采样或预算证据项目。一般日志、实际UTC起止/耗时可照实保留；单次工具超时和可观测控制退出仍按实际工具合同处理。

原预算局部复审not-ready及P1跨Handler时钟/P2全链耗时调查作为历史保留：调查已完成，所需机制未建立/证据不足，不能称被技术补齐或独立复审通过；因用户撤销该政策，不再构成现行预算阻断。现行合同及作者自检见[Plan](plan.md#分钟预算撤销与作者自检)，决定与历史分界见[Context](context.md#分钟预算撤销的用户决定与现行边界)，执行图说明见[Waves](waves.md#预算撤销后的执行准备边界)。

此前已确认的P-n生产接线、version9→10和四引用聚焦修复，以及P-v6新实际产物加载、全部4782类/原完整oracle、真实miss→rebuild→same-path hit→再次全量检查均保持；两个独立Handler/Result、依赖、消费者、共享构建串行与非预算停止条件不变。正常网络全链最多3次（含hit），仅明确临时网络且前次真实退出/输出收束、证据分存和排他可判才可再试；不是无限重试。实际内容不符、身份不明、冲突或控制退出unknown继续停止受影响执行。本次仅四文档维护及作者自检，无实施/运行授权，不宣称独立review通过、实际item完成或gate释放；不变的已确认范围不重复确认，受影响边界独立复审仍未由本次完成。

**当前维护：保留P-v5 generation1 failed，编入notch游戏rename继承修正及新产物完整验证。** 当前只授权四协调文档、唯一Waves图和作者自检，未授权实施/运行。两处已有效reference修正和样本正负例不重做；拟由生产修正P-n交付有聚焦证据的共享源码/cache版本接线，再由P-v6独立交付新产物全部4782内容＋真实same-path hit，分别一个Handler/Result；不是把编译当完整验收。策略见[Plan](plan.md#游戏rename继承恢复与新产物验证策略)，采用事实/限制见[Context](context.md#p-v5-失败采用与游戏rename恢复边界)，唯一图及消费者见[Waves](waves.md#overlay-未完验证的现行连接)。P-v5及更早failed、两partial、全部旧合同/gate不满足、T-basic-v3 completed/已释放gate保留。本轮不宣称独立ready、item成功或gate释放；P-n原生产修复及P-v6完整验收范围已确认，不因撤销分钟预算重求许可，受影响边界的不同Handler局部review未由本次完成。

**缓存策略局部纠正，仍非ready。** 已采用独立复审的唯一阻断：原P-n/P-v6把Core路径/key写成另一实现。现以[当前源码事实](context.md#缓存策略复审采用与源码对齐)、[Plan实际缓存合同](plan.md#游戏rename继承恢复与新产物验证策略)和[本轮作者自检](plan.md#缓存策略源码对齐作者自检)为准：cached-operations路径、内容Murmur3-32/源码排序去重聚合、有序身份与Core key分记、版本10专属operation隔离及新miss/rebuild/same-path hit。旧7/8/9、P-v5失败和此前作者记录保留，不将旧“有序input-key”措辞解释为Core含basename/order/角色；本次只维护文档，不实施/确认或释放gate。

**P-v5准备入口历史（现已failed；下述当前/新限当时）。** **当前维护：P-v4 generation1 failed保留，新增P-v5独立reference语义恢复策略。** 现行P-v简称为P-v5，唯一item/Wave/gate及必要消费者只由[Waves](waves.md#overlay-未完验证的现行连接)拥有；本Plan仅拥有验证策略/成功标准及作者自检。未来仅新build根内两处已确认reference修正，服务未完完整P的一个oracle/cache终态，不改生产或公共测试工程、不用生产反推golden、不减比较。当前仅四文档维护权限；仍待不同Handler独立局部review、Router披露及具体实施确认，不宣称ready或释放gate。

**P-v4准备时点历史（现已failed；下述新/当前限当时）。** **当前 C5：保留 P-v3 failed，登记 P-v4 未完完整验证恢复。** 新 `RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY`（P-v4），一个 item/Handler/Result、单成员 Wave/gate，仅补完整独立 oracle＋same-path hit。用户已确认：仅新根薄工具自身可证的编写/静态类型错误可在同一1800秒内修正并复查，计时不重置、失败不删除；真实内容不符、输入/加载身份不明、运行冲突、退出unknown或到限仍停，不降低验收。现行 P-v 简称为 P-v4；旧 P-v/P-v2/P-v3 failed、两partial、全部旧完整合同/gate不满足和 T-basic-v3 completed/已释放gate永久保留。见 [失败与确认边界](context.md#p-v3-静态失败采用与同预算纠错边界)、[策略及作者自检](plan.md#p-v4-同预算工具纠错恢复与作者自检)、[唯一现行连接](waves.md#overlay-未完验证的现行连接)。仅维护四文档，不执行验证、不派发复审、不完成实际item或释放gate。

**前轮 P-v3 准备时点（已 failed；非当前停止规则或连接）。** 新 RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY-IDLE（P-v3），一个 Handler/一个 Result/单成员 Wave/gate，仅补完整 oracle＋same-path hit。现行 P-v 简称为 P-v3，旧 P-v/P-v2 failed、两 partial、全部旧合同/gate 不满足、T-basic-v3 completed/已释放 gate 永久保留，不续旧预算、不回填。此前“当前/新 P-v2”均指当时。见 [采用事实](context.md#p-v2-尾窗误拒与恢复依据)、[本轮策略与自检](plan.md#p-v3-最小预检恢复与作者自检)、[现行图连接](waves.md#overlay-未完验证的现行连接)。仅维护文档，不实施/调度/完成 item/释放 gate。

**前轮 C5 连接历史（本页入口已取代）。** 原 P-v（RECOVER-FORGE-PATCH-OVERLAY-VALIDATION）已 failed，其原合同/Wave/gate 不满足永久保留；新增 RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY（P-v2）/一个 Handler/一个 Result，仅补未完完整验证。本页此前“新 P-v/当前 P-v”均保留其准备时点；现行完整P消费位置改指 P-v2 及 G-FORGE-PATCH-OVERLAY-VALIDATION-RECOVERY，不等待旧 failed gate、不回填旧失败。T-basic-v3 completed/已释放gate、两个partial及全部历史不变。不实施、不运行、不调度或释放新gate。 事实/精确导航见 [Context](context.md#p-v-失败采用与原证据定位纠正)，本轮作者自检/局部复审范围见 [Plan](plan.md#p-v2-定位与恢复连接作者自检)。

[Work](work.md) · [Context](context.md) · [配对且唯一执行图](waves.md)

## 准备状态与选择

**历史准备概述；下列原P-v及P-v5只读生产、不cold等授权仅限当时；现行生产/新产物范围以[游戏rename恢复策略](#游戏rename继承恢复与新产物验证策略)为准。** 保留原三项局部/Mixin completed、首轮153/150/3/0 failed及全部旧failed/partial/blocked/not-ready/unknown。T-basic-v3 completed/其gate已释放；原FIX-FORGE-PATCH-NAMESPACE generation1 partial（版本7→8、补全/去late-copy及游戏类/资源改善）保留，最新RECOVER-FORGE-PATCH-OVERLAY-CONTENT（P-recovery）generation1 partial已完成两个owner的live overlay/继承交接、版本8→9和cache输入闭合，真实新产物miss/rebuild成功，但完整独立oracle/hit未完。原错误父集断言、目录exit1和deadline后postprocess违规保留，不作成功或合法续批。本轮仅四文档维护：新增 **RECOVER-FORGE-PATCH-OVERLAY-VALIDATION（P-v）** 一个item/Handler/Result仅补未完验证，不再授予生产写权限。两个旧partial及原完整谓词/未满足gate不回填；事实见[Context](context.md#overlay-恢复-partial-采用与未完验证边界)，当前策略见[下节](plan.md#overlay-未完验证的有界恢复策略)，唯一图见[Waves](waves.md#overlay-未完验证的现行连接)。

按用户最新范围决定，跨 host / 跨 Mixin 与 Strip 输出竞争及共享物理输出预约修复排除。旧 FIX-OUTPUT 不标 completed，其专属载体、身份、活动期兼容、释放测试与 gate/依赖不再是本次义务；不引入用于输出预约的 JMX、System properties、文件锁或共享对象方案；basic 本轮仅转发标准 toolchain 字符串属性，与已排除的共享预约无关。输出独占规范不变，竞争风险和未实施事实见 [Context](context.md#输出预约载体修正依据)。

首次独立复审 not-ready 保留；此前输出载体修订和 Forge fresh 清单修正的作者检查是历史，不等于独立复审通过。Router 已采用 `review-reduced-mixin-repair-plan` generation 1 的评估 completed / 计划 not-ready 及后续七个不存在类的校准事实。原三项策略、验证清单及作者历史保留其原阶段语境；新的已观察执行结果见 [Work](work.md#已观察结果与恢复范围)。本轮只维护四文档和作者自检，不实施、运行、确认或释放 gate，不声称 ready。

**历史：P-v至P-v5旧项范围，不是本节新生产修正/构建的上限。** 原三项、Mixin、成功接线与token/身份/观察、两个生产owner/version9效果不重放；NORMAL-RETRY及全部旧failed/partial/blocked/not-ready/unknown和未满足gate保留，旧批次不resume。P-v只关联已完成效果与未完完整oracle/hit，不能改生产/公共fixture/helper/test/consumer/API/依赖或非notch/Neo。独立R/D/B/M不合并Result；D仍另起批次取原入口完整同轮compiler证据，不把compileJava非网络错当网络再试。普通缓存不逐项审计、不清全局缓存；原7/8与当前9的真实operation/key/path隔离须只读补证，并非本项再实现失效。共享Forge/Gradle/TestKit/build/fixture/cache写运行串行，当前连接只见[Waves](waves.md#overlay-未完验证的现行连接)。

本 Plan 的当前完成标准包括已采用原三修复/Mixin、三组准备（basic T-basic-v3已completed）、已采用P-n-v源码足证据、P-v6-a既有完整技术证据采用结果、Q-1165/Q-Neo/R/D、完整B、独立M，以及最终同版三模块fresh/根入口V和不同Handler验收H。P-v6-a按[当前采用策略](#p-v6-既有技术证据采用策略)仅处理本次例外与证据适用性，不把原P-v6 partial改completed或释放G-FORGE-REBUILT-CONTENT；原P-n partial及旧源码gate不回填。成员/依赖/新阶段gate仅归[唯一Waves](waves.md#p-v6-例外下的证据采用连接)，最终仍以G-RECOVERY-INTEGRATION/G-ACCEPTANCE建立全量结果。各分支独立技术验证、共享串行、全部历史及完整验收不减，P不代表Neo已验证。本次只文档维护和作者自检，不执行或宣称局部独立复审通过、ready、采用或gate释放，不重求已确认例外或不变范围。

## 1. 显式任务输入查找：拒绝Manifest隐式域

### 选型

保留外层操作URLClassLoader、平台/实现owned加载、class定义/CodeSource与JDK `getResourceAsStream`入口；替换私有task域的默认URL集合搜索。选**空URL集合的局部URLClassLoader子类，findResource只顺序扫描构造时显式输入**。保留私有task URL源形状以迁移现有故障注入，task本身不把输入交给JDK URLClassPath，也不调用super.findResource去展开Manifest。类、类字节、plugin及普通资源继续调用同一task.findResource。

备选“每个输入一个普通URLClassLoader”仍会展开每个Manifest；“检查到Class-Path就拒绝整Jar”会拒绝只需普通内容的合法输入；“把Manifest引用递归加入跟踪”扩大合同且产生新隐式域；全部不选。无需独立ArchiveResources框架、外部依赖或自建归档缓存。

### 查找和关闭边界

- producer仍按runtime/classpath → sources → target传入列表，保留各内部顺序。host metadata发现仍只来源→target，不因class lookup读取别的metadata。输入仅接受本调用提供的本地file URL，转换为Path；不补cwd、宿主classpath、Manifest或网络URL。
- 在查找前沿用归档路径验证，Windows也用`/`。目录输入按明确root.resolve(name)查找，返回该资源file URL，CodeSource仍是声明目录root。只对确实不存在返回下一输入；直接属性读取/文件/Jar I/O真实失败不能被当作不存在。不要为修复Manifest另加JSON字节预读或解码验证。
- JAR输入按声明次序用局部`JarFile(..., runtimeVersion)` / `use`仅探测所需entry，不读JSON正文；保持JDK支持的multi-release选择，取实际entry realName。返回指向该明确Jar及已选择entry的`jar:` URL，entry保留`/`且对空格、`#`、`?`、非ASCII做URL组件编码，禁止由URL语法改变entry。查找本身不读取或跟随Class-Path；不缓存JarFile跨查找。
- URL继续经过现有uncached边界，实际消费者打开时`useCaches=false`。普通class从同一URL读取并define，CodeSource指明确Jar或目录；平台jrt及owned实现域保持。getResources仍遵循当前单一获胜资源行为，不引入新聚合枚举语义。
- task关闭与outer关闭仍在use/finally中，outer继承的JDK getResourceAsStream负责其取得Jar stream的关闭跟踪；直接`getResource(...).openStream()`消费者维持自己的use。不得改成预读ByteArrayInputStream或为恢复open cause包装JDK入口。lookup的临时JarFile立即关闭；loader退出后包括保留未显式关闭的返回stream都不能占用Jar，必须由现有Windows独占句柄/删除回归实际验证，而非只从实现推断。
- 资源打开时IOException→null仍由JDK处理；必需资源失败及原生optional refmap/plugin fallback不变。取得流后的真实read/close、direct I/O、TCCL恢复和输出失败义务保留。

### 反例与缓存关系

在ordinary私有工程准备A（Manifest Class-Path指X）、显式B及X的竞争类/资源/plugin版本。输入[A,B]必须选B，不能因A插入X；只有X且未显式传入时不可见，必须输入按原生政策失败或fallback，不把所有可选读取强制失败。显式[X,A,B]选X，显式[A,B,X]仍选B；分别断言普通类、对应class资源、实际plugin依赖/资源及最终转换值。增加目录→Jar竞争、Jar→目录竞争、带空格/#/非ASCII目录/entry、MR entry验证，保留已有资源故障回归。

在现有pipeline调用方fixture加声明顺序/Manifest变体：未显式X时仅变X内容不应改变输出/已声明输入快照；把X明确放进classpath后改变X，必须重做或命中对应新输入缓存，并改变实际转换值，禁止复用旧结果。记录task outcome与输出内容，不能仅靠“某次成功”。不要求给未声明X内容新建隐式输入。

## 2. 重复声明：路径去重、side合并，正文只由执行域选择

删除discoverMixinConfigs中跨来源正文预读/一致性比较及只为该比较使用的imports。继续按sources再target、各rule/references先见次序，用有序路径集合和现有side集合归并；不增加origin/hash/schema，不强迫声明Jar内存在正文。配置、parent、类、plugin、refmap仍由第1节任务域加载。独立修复可以先使用现有域证明重复语义，不把显式域修复成功虚构为该项业务前置。

新增两Jar声明同path且都不含正文、正文只在显式runtime的成功例；不同来源有不同合法正文，runtime覆盖及交换显式source顺序应选择相应正文，记录实际转换值/通知。共同/client/server side全部合并，inactive分支仍原生处理。相同配置资源下多个物理来源的精确清理继续按逻辑键批量发生；保留近似path/条目不匹配、无通知条目保留。另设显式执行域实际缺失必需正文的失败例，证明“删除提前比较”不是吞错。

ResourceTests的旧“Ambiguous config content”断言与合同冲突，改为以上成功反例，同时保留目录resource/CodeSource及原输入不变断言。其JarFile比较故障ASM接点也会消失：将故障注入改到真实metadata listing rule load的读取/关闭，用私有host中的测试ListingRule委托实际load并包装其Path/FileSystem I/O；直接读的是metadata，不虚构已删除的正文比较。保留read、close、read+close三种实际命中、cause identity/suppressed、失效两输出、可关闭移动原Jar及修复故障后fresh成功。若实现形式使原方法名失真，允许改名为metadataLoadReadAndCloseFailuresBlockRealProducerAndAllowRetry，并在Result记录旧→新对应，不以删除旧方法等同回归通过。不得为保测试而保留违反合同的重复正文读取。

## 3. Fabric：真实load/remove与同一库默认流对照

只改Fabric metadata测试及其私有输入工程。新增固定二进制metadata variants，使用同一被测classpath已安装的`Json.decodeFromStream<JsonObject>`与同配置，独立读取同一原始ByteArray作为oracle；不能用字符串构造、`readString`、严格CharsetDecoder或别的JSON库替代默认stream入口。

非法字节至少包括截断多字节、非法延续字节及过长编码，放在未知字符串字段，另保留一例适用业务字段的读取结果；每例同时放合法的Mixin引用及未知嵌套字段，避免只测语法失败。oracle若成功则比较完整DOM（包含实际replacement结果），若抛错则真实adapter在相应读取阶段也失败，比较可重复的异常类型/阶段，不冻结不同解码器的固定替换结果。

- load：从真实静态Jar副本调用实际SPI选到的FabricMixinListingRule.load；读取前后原Jar字节相同，成功时references等于oracle相应业务映射，未知字段按DOM保留；oracle业务形状不合法时按现行adapter失败规则判断。
- remove：先用合法metadata取得真实handler并关闭ZIP，保存references快照；再将私有副本当前metadata替换成上述非法字节。oracle读取的是修改后的同一字节，按现有精确引用移除语义计算期望DOM，再实际handler.remove并重开验证。成功时只移除捕获引用的匹配项、保留当前新增引用/unknown值/无关资源；失败时在真实读取阶段外传，不打开写流，不改字节。handler快照和独立原始输入均不变。
- 保留当前真实read/write/read-close/write-close及suppressed六模式与本地修复后retry。若在同一库同入口下揭示生产默认解码不符，可作为本item内合同恢复的证据报告；不授权换解析器/严格化或修改Spec。当前没有这种生产缺陷证据。

## 恢复一：测试声明发现与删除异常合同

边界仅为测试专用 `FixtureMixinRule.kt`、`FixtureMixinRuleTests.kt` 及确有必要的同一测试合同断言；不改生产 MixinListingRule/MixinConfigHandler，不泛化 Fabric/Forge 或可选资源的缺失策略。首轮失败是 `FixtureMixinRuleTests#readAndRemoveIoFailuresAreWrapped` 的 remove 断言（57行），`deleteIfExists` 返回 false；不是读取失败未包装。

- load 在实际成功读取 `fixture.list` / `fixture.client.list` / `fixture.server.list` 时记录声明名，只有实际发现的声明参与 remove；保留原行、重复、顺序、side 和不可变 references。完全无声明仍返回 null。
- remove 以调用传入的 root 解析这些名，执行真实严格删除并包装实际 IOException（缺失时保留 NoSuchFileException cause），不能硬编码抛错。load 时未发现的可选 client/server 不删；新 root 额外出现的未发现 side 声明保留。snapshot 在原 Zip 关闭、新 root 内容变化及 remove 前后均不变，原 archive/输入字节不变。
- 保留 `missingListReturnsNull`、`snapshotPreservesLinesAfterZipCloseAndRemovesOnlyFromNewRoot`、`readAndRemoveIoFailuresAreWrapped` 的有效断言；新增/加强 common-only、client-only/server-only/多 side、空声明文件确被发现、未发现 side 在新 root 保留的边界。确定性 read 故障复用目录占文件位置，修正实际文件后重新 load 成功；remove 在空新 root 确实命中缺失，补齐该 root 下已发现声明后同一 snapshot retry 成功。需要额外删除故障时用含子项的目录替代文件等确定性 NIO 失败，不依赖 Windows chmod 或人为无条件 throw；多声明部分删除后的 retry 应明确补齐全部已发现声明，不承诺事务回滚或可选文件一律必需。
- 最小证据为原失败断言、实际操作命中、cause 类型/路径或原异常 identity、原输入/snapshot 保护和成功 retry 的关联记录；再执行整个 `FixtureMixinRuleTests`、`MixinPreapplicationTests`、`MixinResourceTests`（SPI 选择、host/metadata load 及真实 I/O 探针消费者）。测试 SPI 服务入口及其他消费者仅核对，不扩大生产写入范围。

## 恢复二：两个 Forge fixture 迁移到现存任务 API

两个工程各有可独立验收、保留和重试的消费终态，一个成功不要求另一个成功；原 basic blocked 后的发现与产物边界按下节进一步拆为两个新 Handler / Result，remapped 仍单独一个结果。只共享当前任务/来源约束与串行构建资源，不共享成功谓词。basic 保留 Minecraft **1.12.2** / Forge **14.23.5.2860** / **userdev3**，remapped 保留 Minecraft **1.16.5** / Forge **36.2.39** / **userdev**，均保留 JavaLanguageVersion 8 和原 Java consumer。原 caller 写边界分别为各自 `build.gradle.kts`，确需产物证据断言时仅涉及 `PatchedMinecraftTests.kt` 对应方法或必要共享取证接点；本轮另有下节明确允许的 Forge 外层 Test 标准属性接线，basic原语义不变；本轮另将remapped同一标准属性转发纳入未来计划，见末节，尚未授权实施。同文件按最新内容排他修改，不扩大 Java 源码写范围。唯一执行分组、依赖、冲突与 gate 在 Waves。

以下表格按当前源码重新核对，证据入口见 [Context 纠错表](context.md#独立复审发现的局部纠错依据)。属性是源码事实，接线是未来迁移要求，尚无配置/运行成功证明。

| 当前所有者与真实属性 | 输入来源及必须到达的实际消费者 |
| --- | --- |
| `CachedMinecraftTask.cacheParameters`；`MinecraftVersioned.minecraftVersion` | `CachedMinecraftTask` 自行设置 manifest/cache/offline conventions；各 `ResolvePatchedMinecraft` 显式设置本例版本，remapped 的 `ResolveMinecraftMappings` 显式设置 1.16.5。`LoadMappings` 继承缓存参数但没有 minecraftVersion/sourceNamespace 属性。 |
| `ResolvePatchedMinecraft.patches: ConfigurableFileCollection` | 各 fixture 显式解析固定 Forge 坐标的唯一 userdev3/userdev Jar，经 `UserdevConfig.fromFile` 读取 config.json；再由其中 `mcp` 坐标解析 MCP config 归档，加入同例 patches。task 以文件名过滤唯一 userdev，`dependencyFile` 以 artifact 名定位 MCP；保存实际文件/坐标并检查无歧义。不能假定旧 dependency DSL 或未注册的 component metadata rule 已提供这些输入。 |
| `ResolvePatchedMinecraft.libraries` / `universal` | 由同版本 metadata 的 `getAllDependencies`（按现有 rules 过滤）及同一 userdev.libraries 显式构造可解析库集合，userdev.modules 作为依赖约束，保留 userdev 中同 Forge 模块的 classifier 依赖；这与现有 metadata rule 的消费语义对应，不把 modules 冒充额外库。universal 按 userdev.universal 坐标单独解析并满足 singleFile。fixture 只用现存公开解析入口与显式 configurations；libraries 同时供 MCP listLibraries、remap classpath 和 consumer compileClasspath，记录最终适用文件，不能只连接 patched Jar。 |
| `ResolvePatchedMinecraft.neoforge` / `output: RegularFileProperty` | 两例显式 neoforge=false，源码无此默认值。output 有按 minecraftVersion 生成临时 Jar 的 convention，可显式设置本 fixture build 下路径。用 `patchedProvider.flatMap { it.output }` 经 files(provider) 传递产物及 producer 依赖；basic 的 implementation/compileClasspath 消费此 provider 加上述适用库，不把路径字符串或旧 class 当输入。 |
| `McpAction.runBinaryPatcher`、`UserdevConfig.binpatches/binpatcher`、MCP functions | 现存实现解析 MCP functions 和 binpatcher 的 version/classpath 至内部非传递 detachedConfiguration，执行真实 patch，随后合并未 patch 类、universal、inject 并应用 userdev AT。patched 任务内部根据 metadata.javaVersion 选择 patch 工具 Java。basic 的 notchObf/最终命名空间与 remapped 的 SRG 路径由实际 userdev/MCP/产物确认，不凭版本名断言；来源链/工具日志与最终输出都需取证。 |
| `ResolveMinecraftMappings.minecraftVersion` / `server: Property<Boolean>` / `output` | remapped 显式 minecraftVersion=1.16.5、server=false，取得 ClientMappings。server 是必填且无 convention；源码用它选择 ClientMappings/ServerMappings，output convention 也依赖它。不存在 downloadType 属性。向下游传 `officialProvider.flatMap { it.output }`，不把旧 MinecraftType 枚举写成当前 API。 |
| `LoadMappings.mappings` / `javaExecutable: RegularFileProperty` / `output` | mappings 的声明顺序为 official client mappings output provider 在前、同例 MCP config 在后；保存迭代次序。javaExecutable 必须显式连接 `javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(8)) }.map { it.executablePath }`，源码在 load 时调用 get()，无自动 convention；实际可用性待验证，与外层/test/fixture Gradle JVM17 分开取证。output 默认 temporaryDir/mappings.tiny。无 sourceNamespace 属性，不设置虚构的输出 source；Proguard 读取规则建立 named/obf，随后 MCP 规则建立 obf/srg 并在缺 named 时补 srg，故需先 official 后 MCP。检查实际 Tiny 树含 obf/srg/named 且 named Entity 与原 consumer 对应。 |
| **选用 `RemapTask`** 的 `inputFile` / `mappings` / `sourceNamespace` / `targetNamespace` / `classpath` / `outputFile` | remapped 独立文件转换使用当前 RemapTask：inputFile.set(patchedProvider.flatMap { it.output })；mappings.set(loadProvider.flatMap { it.output })；classpath.from(上述适用库)。sourceNamespace 无 convention，须在 MCP/产物核实后显式设 srg；targetNamespace 有 named convention，计划显式设 named。outputFile 可显式置于 fixture build 下，convention 由 inputFile/targetNamespace 派生。consumer implementation 接收带 producer 依赖的 `files(remapProvider.flatMap { it.outputFile })` 加适用库，实际任务图必须先 patched、mapping/load、remap 再 compileJava/jar。不能声称默认 obf→named。 |
| `RemapJar` 的 API 区别（本次不选用） | 它继承 Jar，用 input/mappings/classpath 和继承的 archiveFile 输出；sourceNamespace convention 为 named、targetNamespace 无 convention。它没有 inputFile/outputFile/remapClasspath；不把其 archive API 与 RemapTask 混写，也不据此扩大生产修改范围。 |

basic 的独立证据：现有 [Test.java](../../../minecraft-codev-forge/basic-patched-test/src/main/java/Test.java) 第1–9行导入 MinecraftServer / MinecraftForge，在静态 test() 中打印 `MinecraftForge.EVENT_BUS` 并调用 `MinecraftServer.main(new String[0])`。由 `PatchedMinecraftTests#Test patched Minecraft` 运行原 `jar printCompileClasspath -s`，证明真实 patched Jar 和库的类/成员可见性、Java8 compileJava、当前 consumer class 与 jar 产出及 classpath 身份；不会实际启动 MinecraftServer，也不声称证明继承/override 或额外 AT 效果。

remapped 的独立证据：现有 [Test.java](../../../minecraft-codev-forge/remapped-patched-test/src/main/java/Test.java) 第1–9行导入 `net.minecraft.world.entity.Entity` / MinecraftForge，在静态 test() 中打印 `MinecraftForge.EVENT_BUS` 和 `Entity.class`。由 `PatchedMinecraftTests#Test remapped patched Minecraft` 运行同一 jar/printCompileClasspath 入口，证明实际 remapped Jar 的 named Entity 类可见性、Forge 成员与所需库可见、Java8 compileJava、当前 consumer class/jar 及 classpath 身份；没有继承/override 测试，不增加此类扩展。AT 行为继续由现有 [ForgeAccessTransformAndJarJarCompatibilityTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt) 的 `actualNonEmptyAtCliPreservesAccessBehaviorAcrossG1AndNestedPayload` 及原真实 AT 断言随全量 fresh 证明，两个 consumer 不替代它。

### basic 未完成边界的标准属性接线

[原 basic 报告](../../../build/recover-basic-patched-evidence/report.md)已采用为 blocked：三次各1 execute / 1 fail / 0 skip，第三次到依赖计算时 Java8 compiler 不可发现；patched/compileJava/jar/printCompileClasspath 未执行，最终 targetMinecraftVersion 重命名未运行。userdev3 已实际解析不等于完整输入链成立。保留现有脚本迁移和旧失败证据，不把修复前版本当当前脚本或重新实现已保留迁移。

此前新增授权的两处标准属性接线现已完成并保留，原发现 Result 仍为 partial，历史权限及合同如下（本次重试不重写接线或脚本；产物项的原 caller 恢复许可单独有效）：[Forge Test 配置](../../../minecraft-codev-forge/build.gradle.kts) 用 `providers.gradleProperty("org.gradle.java.installations.paths")` 取得已解析字符串，并有值且非空时传给 Test 的同名系统属性；[PatchedMinecraftTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt) 仅 basic invocation 读取该属性，在原 `jar printCompileClasspath -s` 列表追加一个同名 `-Dorg.gradle.java.installations.paths=...` 元素。列表保留为一个参数，路径空格不附 shell 引号；缺失/空值不传空/null，继续原发现行为并报告未建立“显式列表转发”保证。Gradle9.4.0 的 `-D` 专用桥接与 `-P` 弃用依据见 [Context](context.md#basic-阻断后的授权与恢复边界)，不另传冲突的 `-P`。

保留 Test Executor Java17、fixture.gradleJava、withPluginClasspath、forwardOutput、withDebug(true)、独立 TestKit home 及 Java8 consumer。只传环境提供的已解析绝对路径列表；不在代码/记录写本机路径，不读原始用户配置、不改用户/环境/TestKit 设置、不安装 JDK、不新增 fixture.*、不用 withEnvironment。相对路径解析基准及规范化不在授权范围，遇到未覆盖输入报告限制，不扩展配置框架。当前配置 `zulufx8` 与旧运行 `zulu8` 不同，候选目录或 release 不能充当实际选中 compiler 证据。remapped runner 无本轮标准属性转发授权；共享外层 Test 系统属性及 withDebug(true) 的运行影响按下述实际观察合同取证，写/跑与 remapped 串行。

权限一致性采用 Router 明确澄清：原用户已批准 basic-patched-test/build.gradle.kts 的现存任务 API 恢复及必要既有测试取证接点，从未撤回；后来“可以”只是在原范围上增加上述两处标准属性接线。上一 Handoff“授权仅两文件”造成的权限冲突、独立复审 completed / 计划 not-ready 均保留在 [Context](context.md#basic-三项复审阻断的局部纠正)。产物恢复可在原已确认的未完成 caller 边界继续必要脚本修正及验证，不重做已完成独立效果，不扩大生产 API/版本/Java consumer/参数框架。这是原权限一致性澄清，非新用户决定或新增批准轮次；remapped 只有原独立脚本恢复许可，无新增 runner -D 转发权限。

Java8 compiler 实际可解析是可独立保留和重试的终态：后续 patched 链失败不会抹去已经验证的发现边。因此与 basic 完整产物消费分成两个新 item，各一个 Handler / Result，后一项依赖前者；发现项不能以源码支持或候选存在完成，也不能以发现成功宣称 basic 全部通过。两处转发共同建立同一发现谓词，不单独拆成两个没有独立消费者的接线结果；原实现已完成而运行验证 partial，现仅为未完成运行验证设独立重试结果，不回填旧 Result；patched/compileJava/jar/printCompileClasspath 是同一原 consumer 成功的必要证据链，此次没有单独交付 patched Jar 的新终态。分组及唯一依赖图由 Waves 拥有。

### Forge 生产补丁 namespace 恢复策略

<a id="基线封存与专用真实-fixture"></a>

#### 专用真实 fixture 与新鲜证据

**本节保留原设计与准备历史。** basic的T-basic-v3后来已采用completed、原P已partial；以下早期“准备failed/待运行/P尚未修”的事实限其时点，当前恢复及消费以“overlay完整结果恢复策略”和Waves现行item/gate为准。真实输入/独立oracle/全部fresh与资源适用性合同继续，不重新要求准备或重做原P保留效果。

以下区分已交付效果与后续输出；basic 专用工程/helper/入口已创建但完整准备 failed，1165/Neo 扩展及 R 仍待实施。本次不创建或修 fixture、复制 JAR/缓存或执行验证。用户撤回的是新计划 S 和未来旧实物对照，不是仓内历史 Result/证据。S 不再有现行 item/Wave/gate 或 P/R/V/H 成功前置；旧 T-basic failed、独立 T-basic-v3/T-1165/T-Neo、P、Q-1165/Q-Neo、R/D/B/M/V/H 各保留一个独立 Handler/Result，不把撤出 S 记作已执行 completed 或取消了实际运行。

- **来源记录而非旧实物：** 保留 Git 可追踪的源码版本/提交标识作为算法和语义版本来源；实际工作内容另记录相关 diff/内容身份（含未提交/未跟踪输入），不以 HEAD 代替当前内容。本次不操作 Git。Git 不保存或证明生成 JAR、私有缓存、依赖字节、工具输出；原 failed/partial/blocked、日志和已有仓内报告原样保留，不要求新建旧源码/输入快照、重新运行旧实现或恢复旧 key 实物。
- **输入由 T 登记：** 固定 basic Minecraft1.12.2 / Forge14.23.5.2860:userdev3、真实 userdev/MCP 或 NeoForm 配置、joined.tsrg entry/header/方向、合法 clean/binpatch、精确工具 version/classpath/args/JDK、universal/inject/AT、适用 libraries/modules 与实际文件摘要。固定发布来源不等于本机物化，缺输入须报具体缺口；不为“验证旧失败”换一套输入或编造旧字节身份。
- **真实私有 fixture T：** basic 已交付 `minecraft-codev-forge/integration-test/forge/patch-namespace/` 专用 Gradle 工程、同包私有 helper `ForgePatchNamespaceInputs.kt` 及 `ForgePatchNamespaceFixtureTests.kt`，具体实现/失败见[原报告](../../../build/prepare-forge-patch-basic-20261023/report.md)；仅 basic provider/准备方法现存，1165/Neo 扩展及 R 的 `ForgePatchNamespaceTests.kt` 仍是未来输出，不重建 basic 工程。复用现有 GradleRunner/withPluginClasspath，按下表注册三个真实 ResolvePatchedMinecraft provider，output 的 flatMap 保留 producer 依赖；metadata 解析及所有 CachedMinecraftTask 显式使用本私有 cacheParameters.directory，工程、TestKit/Gradle home 与输出分别隔离。不改生产 API/原 consumer/runner 或全局设置，不建通用框架。
- **T 的独立完成边界：** 每组自己的固定输入、真实 task/provider、私有隔离、官方参考与具体见证均可执行到最终 output，才完成该组准备；不要求 namespace 已修好、不造旧 golden。同一 ForgePatchNamespaceFixtureTests 保留已存在的 basic 方法，并待扩展其它两组；提供可独立过滤的 `preparesBasicNotchWithPrivateCache`、`preparesForge1165McinjectWithPrivateCache`、`preparesNeo121NoMcinjectWithPrivateCache`，精确 selector 的现存/未来身份在 Waves 各项中区分。选择一个方法只物化本组 provider/参考/tool/JDK，不在共享配置或 BeforeAll 提前要求其它样本/Java21；共享 fixture/helper 写串行。三方法/完整类仍由 R/V 全跑，不作为单组/P gate。P 只等独立 T-basic-v3，Q-1165/Q-Neo 各等本组 T/P；原未执行聚合 T 被替代，不标 completed/不造 Result。
- **缓存新证据：** 每组优先用隔离空自有缓存；已有可安全控制的私有缓存也须证明本次新语义目标输出完整path初始不存在或真实miss。记录实际 `cached-operations/<operation>/<aggregate-key>/<output basename>`；按[现行缓存合同](#游戏rename继承恢复与新产物验证策略)区分operation版本隔离、Core内容hash排序去重聚合与另记的有序身份，不要求aggregate必异；P/R不预置旧错JAR/旧key实物。新语义首次 miss→真实 rebuild→同输入同版本再次 hit，命中时内容符合独立参考且与新生成内容一致。外层 rerun/no-build-cache 只用于让 task action 到达，不证明自有缓存失效；当前 Cache 自身 Cache miss/Cache hit 日志、工具生成日志与文件身份须同轮关联。tryLink 可能产生硬链接，运行产物不就地编辑，保存新证据用字节副本而非可回写的链接；不清全局缓存、不造额外 MCP 缓存层。

仅上述真实 fixture/helper/入口和必要新证据属后续范围；不新增旧状态封存、空 mock/接口或字符串 rename 替身。三组版本和 NeoForge 私有样本边界不变。无旧实物后的可证范围及 JDK 分支规则见下文；历史 S 规划/自检保留其时点，不恢复其执行前置。

#### basic 准备失败保留与独立恢复

**历史准备合同。** 原T-basic-r现已failed，以下实现权限与拟验证只指该已结束身份，原完整合同保留；当前不再修实现，仅按新批次T-basic-v3（见“basic 控制提前退出后的同 terminal 前台验证”）取未完运行证据。

旧 PREPARE-FORGE-PATCH-BASIC generation1 为 **failed**，其原无条件见证完成合同及 G-FORGE-PATCH-FIXTURE-BASIC 未满足，永久保留而不改写。[原报告](../../../build/prepare-forge-patch-basic-20261023/report.md)记录真实 production/reference 已生成、8个 CLI 退出0，t9 方法却为1 test / 1 failure / 0 errors / 0 skipped（Pipe closed）；LZMA drain 修后仅 compileTestKotlin 与聚焦拒绝检查，无完整 selector 重跑或 prepared.txt。诊断 completed 不等于 T 成功。ICommandSender 的 SRG 定义缺失、bn.class 仍在的生产事实保留，P 尚未修。

独立 **T-basic-r = RECOVER-FORGE-PATCH-BASIC-PREPARATION** 仅恢复未完 fixture 判定与完整方法验证：核对并复用已交付工程/helper/入口、固定输入/独立官方参考及 LZMA drain 修正；只在既有私有 helper/准备测试的必要接点落实本 Plan 阶段/空集适用性及 collision clean/patch 合集，不重建工程、不重写生产/原 caller/consumer/runner、升级版本/依赖或扩展工具。若已有工程/固定输入漂移致该边界不能复用，停止报告，不借恢复重放已完成效果。

在独立新运行根、原私有隔离/串行约束下完整执行现存 selector：`:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`。保存本轮源码/fixture/发布输入/各阶段身份、命令/实际任务图/JVM/工具退出、方法 XML、完整 class/resource inventory、class-witnesses.json、resource-witnesses.json 及最终 prepared.txt，所有相互关联；只编译/私有函数检查或借 t9 的 task/CLI 成功均不能 completed。完整运行可正常重产新 prepare/reference，这不是重建已交付工程或复制旧状态。

新结果只要求独立参考/合法 clean/patch 与具体类/引用见证可用，实际 production 的目标缺失/混淆 entry 等如实记为观察；**不要求生产 namespace 相等或 P 的新语义缓存验收先通过**。仅等已采用 G-REPAIRS 和保留效果/当前排他核对，不等旧 failed item/gate 转成功、不等 P/Q/R 或 Neo/JDK21。P 消费独立 T-basic-r 足证据，R/V/H 合取该恢复结果、另两组准备及旧 failed 历史；唯一连接在 Waves，新成功不回填旧 T-basic 或释放其 gate。

#### basic 控制提前退出后的同 terminal 前台验证

**历史准备，T-basic-v3现已completed且其gate已由Router采用释放。** 下列原合同/失败停止规则保留，不授权重跑准备或续旧批次；见Context最新采用。

当前仅 **T-basic-v3 = RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION** 提供未完basic准备的新独立完整验证，一个item/Handler/Result；旧T-basic/T-basic-r/T-basic-v/T-basic-v2各failed、全部原合同/旧gate未满足与历史unknown不回填、不resume/续预算。[Context采用](context.md#t-basic-v2-控制失败采用与同-terminal-前台恢复)和[仓内failed报告](../../../build/recover-forge-patch-basic-validation-recovery-20261023-1545/report.md)区分脚本主动124/Gradle exit=null/未触发1260硬限与未知的后代结束原因；不调查网络或追查旧执行端清理。

- **一个完整结果与最小权限：** 仅复用已交付helper/test/LZMA/fixture、已物化安全输入，取得未完的原完整basic验证。内部attempt、必要薄入口/取证仅服务该终态，无独立消费者；只在新证据根生成本轮临时入口/记录及正常私有输出，不改项目/旧工具/旧证据，不重做代码/离线效果，不复制旧状态/备份/清缓存，不建清理器/取证框架/调度器/网络探测。
- **同一terminal前台生命周期：** 删除中间Start-Process＋WaitForExit false先exit124分叉，优先在同一bash terminal前台同步执行原gradlew及原argv。必要PowerShell薄入口只做环境准备，前台命令正常返回后立即保存并原样转发真实退出码；不得在子命令未结束时让父控制器先结束。短yield只是短回执，terminal_wait持续等待同一terminal，一次wait未结束不重启/不算新attempt。正常返回关联真实wrapper/Gradle退出、输出及身份；工具硬超时/中断只能记录工具事实、真实Gradle码缺失记unknown，不能伪装124/正常码，也不保证强制终止后拿到正常退出码。进程树硬限合同不等于Windows全链已实测收束，仍缺退出/身份即停。
- **启动即时确认：** 当前共享运行排他/相关worker、wrapper、main、shell、daemon无实际冲突，每轮真实工程/TestKit/Gradle home/metadata-task cache/output隔离，保留实现/输入identity完整性和复用安全及完整可观测控制/真实工具硬限能力须实际确认。历史无PID/目录名/用户重试不代证；具体风险无安全路径即停，也不要求消除永久历史unknown才允许无冲突隔离的新验证。
- **一份时钟与有界等待：** 新目录/new batch-start，最多3次现存完整selector实际调用，首次实际调用起单一1800秒含执行/等待/间隔/退出收束/保存，不逐次重置/续旧窗口。启动前记录实时剩余、实际工具timeout、收束与保存分配；硬限必须是工具真实参数，并从剩余中扣出至少60秒收束及另行合理保存余量，不把1800全部用于运行后才保存。不是简单增大1200或1260；预算不足以执行/确认退出/保存就不启动，下一轮至少180秒且实际够用。到限按既有能力处理正向拥有目标，未知不杀、不补新清理器/延长验证；硬中断后不凭PID消失再试。
- **正常网络再试/停止：** 只在本轮真实异常链明确临时DNS/UnknownHost/连接超时且无并存明确非网络错误，前轮本次拥有launcher/worker/nested调用/wrapper/main等正向退出、线程输出收束、分存、当前排他及实际余量充分时再试。普通Gradle/TestKit/cache/ruff bookkeeping不做逐文件审计或sideEffectsSafe新认证；网络早败缺witness不是成功，也不单独否决安全网络再试。控制/身份/退出unknown、非网络/具体损坏/漂移/冲突/次数或时间到限立即停，保留真实failed/blocked和未到达边界，不修后续同批次，无网络原因诊断/预探测/逐轮审批。
- **不变的完整成功证据：** 精确现存selector `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'`；只认某轮完整1 test/0 failure/0 errors/0 skipped与全部同轮真实prepare/provider最终output、reference全部CLI/inputs/tools/JVM/argv/退出/阶段/任务图/XML/日志/prepared.txt/class-witnesses.json/resource-witnesses.json/完整inventory及patch记录和身份。无XML计数unknown，不拼旧或不同轮、不用exit0/编译/旧8CLI代证，不skip，未运行不算不适用。[资源阶段/固定真空集与损失](#补丁阶段资源范围与固定-basic-空见证适用性)、collision clean/patch合集和空交集universal-only、1165/Neo实有义务不变；类/接口/引用/checksum独立期望不减，actual缺失/混淆如实记录，不等P namespace/cache先通过。
- **消费者与保全：** 每轮分存源码/fixture/输入和拥有身份、真实隔离/复用依据、完整argv/cwd/同一terminal/tool回执、真实返回或中断/输出收束、UTC/累计剩余/各限额、异常/阶段/全部witness/输出。成功即停并保留失败；P item/Wave、R/V/H及最终第1/10款消费T-basic-v3足证据和四failed/unknown史，其余T/Q/D/B/M/其它最终条款保持，共享写运行串行，无Neo或R新共同屏障。唯一可执行图见Waves；本轮未运行。作者实检/不同Handler局部复审范围见[本次自检](#basic-同-terminal-前台恢复维护作者自检)。

#### basic 启动控制失败后的独立完整验证新批次

**历史策略，T-basic-v2已failed。** 下列身份/控制/预算只属该旧批次，原完整合同保留；当前仅上节T-basic-v3，不据此续跑。

当前仅 **T-basic-v2 = RECOVER-FORGE-PATCH-BASIC-VALIDATION-RECOVERY** 提供basic准备新结果，一个item/Handler/Result；旧三failed/原合同/旧gate不满足及T-basic-v历史实际总调用/启动/退出unknown保留，不resume/reset或续旧次数。[仓内报告](../../../build/recover-forge-patch-basic-validation-retry-20261023/report.md)与[旧观察](../../../build/recover-forge-patch-basic-validation-retry-20261023/final-observation.json)保留失败和准备效果，不采信确定零启动/零效果/已退出，已采用诊断和采样限度见[Context](context.md#t-basic-v-启动未知失败采用与新批次边界)；不要求无法取得的永久历史清零证明。

- **最小内部纠正及权限：** 复用已交付工程/helper/test/LZMA及安全复用的已物化输入，不重做实现、不复制旧状态补证；前检、短且闭合可解析的完整启动/有界等待、结束整理分开。command须完整且有可关联toolResult/实际进程证据，timeout必须作为真实工具参数，不放在command字符串内冒充能力。仅新证据根内必要临时调用文本/正常运行输出，无独立工具Result/消费者；不建调度器、通用runner、取证框架，不增debugger/探针/网络预探测/普通缓存审计，不改源码/测试/fixture/runner/配置/依赖/版本/权威/用户网络/JDK/旧证据，不备份/清缓存。
- **实际启动条件：** 即时验证共享排他/相关进程及daemon是否真实冲突、每轮全新根内工程/TestKit home/Gradle user home/metadata-task cache/output真实隔离、当前输入与保留实现identity/完整性/复用安全。旧采样/目录名/用户“重试就行了”不代证；具体未知效果仍可能冲突、已证风险无安全路径或完整可观测控制/真实工具时限/有界收束能力不可用即停止精确报告，不以改图绕过。
- **一次预算：** 新证据目录/new batch-start，最多3次现存完整selector实际调用，首次实际调用起单一1800秒deadline覆盖执行/等待/间隔/退出收束/保存。先验证工具timeout能力并将每次执行/保全限额纳入同一剩余时限；至少预留60秒收束，下一轮至少180秒且实际执行/退出/保存够用才启动，不逐次重置。控制/解析/回执/身份/退出unknown即停，不记确定0调用后续同批次，必要保存不延长验证窗口。
- **正常网络条件与停止：** 从本轮真实异常链识别临时DNS/UnknownHost/连接超时且无明确并存非网络阻断，前次外层/worker/本轮nested调用及wrapper/main等拥有进程均正向结束、线程/输出收束、证据已分存、即时排他与剩余时间满足，才可继续。驻留共享daemon只需确认可用/无冲突，不把历史Kotlin驻留假称idle或粗判仍在运行。普通Gradle/TestKit/cache/ruff bookkeeping变化不需逐项归属/sideEffectsSafe或端点预探测；网络早败缺后续witness不阻再试，但不满足成功。明确非网络（含断言/越界缺口、编译/工具/见证错误）、具体输入/旧证据损坏、身份/退出不明、控制/观察故障、排他失效或次数/时间到限即停止并保存failed/blocked及未到达/unknown，不诊断网络、不修代码后续同批次。
- **原完整成功合同不变：** 精确现存 selector :minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'，某一轮完整1 test/0 failure/0 errors/0 skipped；真实prepare provider与独立reference全部CLI、输入/工具/JVM/argv/退出/阶段/任务图/最终output、prepared.txt/class-witnesses.json/resource-witnesses.json及完整inventory/patch记录和XML/日志必须同轮全关联。各轮单独根/身份，不拼旧prepare/reference/CLI或不同轮witness，不以编译、旧XML、无输出填0或真实工具未执行的选择值补证；实际未到达不能记不适用。阶段真空集/归档前缀真空集须实际清单/身份支持，collision clean/patch合集与空交集universal-only、覆盖损失/1165和Neo实有载荷义务不变；类/接口/引用/checksum独立期望不减。实际production缺失/混淆entry如实观察，不要求P namespace相等或新语义冷热缓存先通过。
- **身份/保全与消费：** 另记录每轮源码/fixture/输入与进程identity、真实隔离/复用依据、工具参数与回执、命令/cwd/UTC/累计剩余预算、实际结果/异常/未到达、全部witness/输出和正向退出收束；attempt只服务同一Result，成功即停止并保留全部失败，不拼轮/skip。T-basic-v2只等已采用G-REPAIRS及必要实际安全条件；P/R/V/H消费新足证据及三次failed/unknown史，新成功不抹历史unknown或回填旧item/gate。其它T/Q/D/B/M及最终fresh/不同Handler验收不减，共享运行/写入仍串行，不增Neo/Java8屏障；唯一依赖/gate见Waves。本次不执行。

#### basic 未完完整验证的独立有限重试

**历史准备合同。** 原T-basic-v已failed且启动/退出unknown；以下原谓词/预算仅属旧身份，不续跑/回填，当前以新批次节为准。

当前仅 **T-basic-v = RECOVER-FORGE-PATCH-BASIC-VALIDATION-RETRY** 提供basic准备新结果，一个item/Handler/Result；上节原T-basic-r连同原T-basic各failed/原完成合同及旧gate不满足永久保留，不resume、回填或续预算。采用[失败报告](../../../build/recover-forge-patch-basic-preparation-20261024/report.md)、[真实计数/缺失汇总](../../../build/recover-forge-patch-basic-preparation-20261024/evidence-summary.json)及[四文件身份](../../../build/recover-forge-patch-basic-preparation-20261024/current-implementation-identities.json)；精确UTC/678.0457361秒/1-1-0-0、未到reference/CLI/判定、驻留daemon未认证idle/ruff比较局限见[Context](context.md#t-basic-r-网络失败采用与独立有限验证重试)。不把20261024目录名当运行日期、不把已编译或旧8 CLI称为本轮判定成功。

- **复用与权限：** 保留工程、两个helper/test判定修改和LZMA drain，执行前只核对必要当前文件/固定输入身份、私有隔离和资源排他/daemon是否实际冲突，历史快照不代当前确认；发现实际漂移/权限或能力缺口只报告，不在本item修代码。只写独立新build证据及正常私有运行输出/缓存，每次调用由既有helper产生新运行根，日志/XML等分存；不复制旧产物/根补证、不重跑实现、改生产/fixture/runner/配置/版本/依赖/权威/网络或JDK，不增debugger、探针/框架/全量缓存审计，不清全局缓存/备份。不变重试范围无需再次用户批准。
- **唯一预算：** 新批次最多3次现存basic selector实际调用，首次实际调用起一个总30分钟（1800秒）deadline；取证、间隔、等待和退出/保全均计入，不逐次重置、不续旧失败窗口。逐轮记录UTC起止、实际耗时、累计/剩余、调用次数和本次执行/收束/保全限额；仅剩余时间确足下一次实际运行及退出/保存余量时再启动，不能以最多3次要求跑满或沿用旧678秒作保证；不足即停，不超限。到限前收束，仅用既有能力处理正向识别的本轮目标，身份未知不杀不再试，不能延长验证窗口。
- **正常网络条件与停止：** 从本轮真实异常链识别临时DNS/UnknownHost/连接超时且无明确并存非网络阻断，前次外层/worker/本轮nested调用及wrapper/main等拥有进程均正向结束、线程/输出收束、证据已分存、即时排他与剩余时间满足，才可继续。驻留共享daemon只需确认可用/无冲突，不把历史Kotlin驻留假称idle或粗判仍在运行。普通Gradle/TestKit/cache/ruff bookkeeping变化不需逐项归属/sideEffectsSafe或端点预探测；网络早败缺后续witness不阻再试，但不满足成功。明确非网络（含断言/越界缺口、编译/工具/见证错误）、具体输入/旧证据损坏、身份/退出不明、控制/观察故障、排他失效或次数/时间到限即停止并保存failed/blocked及未到达/unknown，不诊断网络、不修代码后续同批次。
- **原完整成功合同不变：** 精确现存 selector :minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceFixtureTests.preparesBasicNotchWithPrivateCache'，某一轮完整1 test/0 failure/0 errors/0 skipped；真实prepare provider与独立reference全部CLI、输入/工具/JVM/argv/退出/阶段/任务图/最终output、prepared.txt/class-witnesses.json/resource-witnesses.json及完整inventory/patch记录和XML/日志必须同轮全关联。各轮单独根/身份，不拼旧prepare/reference/CLI或不同轮witness，不以编译、旧XML、无输出填0或真实工具未执行的选择值补证；实际未到达不能记不适用。阶段真空集/归档前缀真空集须实际清单/身份支持，collision clean/patch合集与空交集universal-only、覆盖损失/1165和Neo实有载荷义务不变；类/接口/引用/checksum独立期望不减。实际production缺失/混淆entry如实观察，不要求P namespace相等或新语义冷热缓存先通过。
- **消费与失效：** T-basic-v只等已采用G-REPAIRS和必要复用/隔离/资源核对；P/R/V/H消费本新足证据并保留T-basic和T-basic-r两次failed、旧合同/旧gate不满足及资源损失。新成功不自动完成旧item/gate，不并入P/Q/R/D/B/M或最终验证；任何一轮成功即停止并保留先前失败，缺必需证据/超限不完成。另两组及缺JDK分支独立规则、最终全量合取不变，只有Neo缺21不阻自身条件充分的T-basic-v→P→D→B及T-1165/P→Q-1165→M。唯一依赖/gate见Waves，本节只是策略与验证安排，本次未执行。

#### 固定输入与逐分支判定来源

三组为发布输入的固定绑定；basic 已有真实 prepare/reference 产物和失败证据，其完整方法仍未完成，另外两组的实际物化/扩展仍待证明；这不是三组已验证支持；来源/摘要等级见[Context](context.md#固定关联输入采用与证据限制)。每组 T 独立物化自己的输入/参考/见证，不封存旧 final/cache/源码或 golden；独立 T-basic-v3 完整后 P 即有自身准备前置，T-1165/T-Neo 仅约束各自 Q。不能把三参数单 Result、完整类或共同 gate 重新作为 P 前置。

| fixture 参数 / 分支 predicate | 固定发布输入及真实 clean 来源 | 工具、目标 namespace 与适用后处理 |
| --- | --- | --- |
| `basicNotch`：`notchObf=true`，placement=`merge` | MC1.12.2 / Forge14.23.5.2860 `userdev3`；MCP `de.oceanlabs.mcp:mcp_config:1.12.2-20200226.224830@zip`；真实 client/server 由同版 Mojang metadata 定位，经 merge 得 obf clean；T 登记本次实际文件/摘要，旧失败日志仅属历史 | binarypatcher `1.1.1:fatjar`，mergetool `0.2.3.2:fatjar`，SpecialSource `1.8.3:shaded` + 包内 `config/joined.tsrg`，mcinjector `3.7.3:fatjar`；patch obf→rename SRG→mcinject，最终 raw patched 为 SRG。userdev 指定 universal、`inject/`、`ats/forge_at.cfg`；该固定归档实际无 inject 前缀，按下文 basic 精确适用性记录。 |
| `forge1165Mcinject`：缺省 `notchObf=false` 且 joined 含 `mcinject`，placement=`rename` | MC1.16.5 / `net.minecraftforge:forge:1.16.5-36.2.39:userdev`；实际归档绑定 MCP `1.16.5-20210115.111550@zip`，`joined.lzma`；同版 client/server 经指定 merge→rename 得 SRG clean | **binarypatcher `1.0.12:fatjar`**；mergetool `1.1.1:fatjar`、SpecialSource `1.8.3:shaded`、mcinjector `3.8.0:fatjar`；patch 后 mcinject 仍 SRG，禁止第二次 obf→SRG。universal `1.16.5-36.2.39:universal@jar`、`inject/`（13 class＋3 service）、`ats/accesstransformer.cfg`；26 libraries 按固定配置完整解析，modules/filters 缺省空。M 后续 SRG→named 不属于这里 raw output oracle。 |
| `neo121NoMcinject`：缺省 `notchObf=false` 且无 `mcinject`，placement=`null`；同组另取 `neoforge=true` 后处理证据 | MC1.21 / `net.neoforged:neoforge:21.0.76-beta:userdev`；官方 moddev 配置绑定 `net.neoforged:neoform:1.21-20240613.152323@zip`、`joined.lzma`；Mojang 同版 client、server bundle **提取后 server**、client mappings 经 `extractServer→mergeMappings→merge→rename` 产生 decompiler 最终字节码输入 | binarypatcher `1.1.1:fatjar`、NeoForged mergetool `2.0.3:fatjar`、AutoRenamingTool `2.0.3:all`、installertools `2.1.2:fatjar`；NeoForm spec4/official/java_target21，rename 读 `mergeMappingsOutput`（官方 client mappings 的 right,left 合并），最终 official names，不用原始 `tsrg2 obf srg id` 头冒充最终 namespace。universal `21.0.76-beta:universal`、`ats/`、无 inject、filters 缺省空；libraries/modules 全部来自该固定配置。MC1.21 仍属 obf 发行，当前条件实际执行 universal overlay 和 Dist 后处理。 |

`T` 的私有工程（basic 已有，另外两组待扩展）仍为 `integration-test/forge/patch-namespace/`，三个明确任务 provider 为 `patchedBasicNotch`、`patchedForge1165Mcinject`、`patchedNeo121NoMcinject`（均注册现存 `ResolvePatchedMinecraft`）；按表分别设置 `minecraftVersion`、`neoforge`、`patches`、`universal`、`libraries`、`output`、`cacheParameters.directory`。`patches` 用解析该 userdev→所绑定 MCP 的 configuration/provider，物化后必须读取真实归档配置与发布绑定/摘要比较，特别 NeoForge userdev 目前只有发布摘要，不能只接受 moddev JSON 而不验本体；工具由真实 runBinaryPatcher 的精确 functions/binpatcher detached configuration 解析；`libraries` 完整消费 userdev libraries/modules 与同版游戏运行库，不能凭 filename 猜全量。fixture 若用准备任务，`flatMap` 输出 provider 携带 producer 依赖，记录任务图到每个实际文件；不以 `files("build/...")` 断开依赖。真实目标始终是各 provider 的最终 `output`，不是替代生产的参考任务。

每组私有运行根按 `sample/prepare|fresh|reuse|reference` 区分准备/新语义/同版复用/独立参考的工程副本、TestKit home、Gradle user home、metadata/task 自有 cache、输出和日志；fresh/reuse 固定 patches 内容、同一语义版本与 output basename。reuse 沿用 fresh 的自有缓存但用独立输出，实际调用 task action，避免输出别名或外层 UP-TO-DATE 冒充内部 hit。参考产物与新运行证据只读保存，不要求 old 根、旧 cache 副本或旧实现重跑。各组准备（basic 为 T-basic-v3）的独立方法、task/provider/工具日志与自己的 Result 必须可关联；三组/完整类报告由 R/V 汇合，不设为单组 gate。

NeoForm 工具仍由现存 `metadata.javaVersion.executable(javaToolchainService)` 选择实际 Java21；T 登记配置来源、metadata/executable、每个工具角色/版本，不因目录名推定可用。外层 Gradle、Test launcher17、fixture.gradleJava 与原两个 Java8 consumer 分别取证；不安装 JDK/升级工具链/改 consumer 或 runner。缺21、缺8及现有 parser/工具能力缺口均按下述分支规则记录，不新增转发框架。

**T 内部参考 producer 与可复现选择合同：** 只物化这些固定版本。私有 `referenceBasicNotch` 已交付，`referenceForge1165Mcinject`、`referenceNeo121NoMcinject` 待扩展，均为同工程的参考产物任务，输出 provider 供 fixture 入口取证；使用发布配置指定的独立工具 CLI、真实 clean/binpatch/mapping，不调用 P 的 patch/rename/late-copy helper，也不复制其补全算法。保存工具原包/来源摘要、完整 argv/退出、原始 stage Jar 与摘要、patch 记录和 sorted entry 清单。读取同版 binarypatcher 的 `Patch`/`Patcher`/`ConsoleTool` 来源及实际包身份，解开 LZMA 内 binpatch 记录；记录 obf/srg、exists/checksum、删除记录，先验证 clean checksum。1.0.12 的记录与 CLI 已有同版源码依据；1.1.1 仅用于 basic/NeoForge，不跨版推定。参考链只运行发布 joined 中到 decompiler 输入为止的字节码步骤，不运行反编译或游戏。

- 逐分支从非删除 patch 记录与 clean 实际存在且内容改变的类交集，按目标 internal name 字典序选择 patched 见证，保留 patch 记录→clean Adler32→官方 CLI patched 字节→必要 rename/mcinject 的链。排除随后被 universal/inject 覆盖的候选；AT 会修改时采用同一已安装版本 AT CLI 的独立单类/最小闭包参考输出，比较 this_class、字段/方法/descriptor/指令等语义而非 ZIP 时间。basic 必须包含已诊断 ICommandSender 关联的 patched 引用方及未 patch 接口；关联两组在候选类的 super/interfaces/descriptor/指令引用中按序选非删除、无 patch 记录而真实存在的 clean 类/接口，给出 target mapping 与完整定义。无见证时报告确切 inventory，不换成空接口、编译通过或“执行时再找”。
- notch 参考先独立 patch obf clean，再由固定映射/rename/mcinject 取得被补丁定义的期望；未补丁接口由 **clean 自身** 经相同固定映射/适用 mcinject 得到。non-notch＋mcinject 参考用 rename 后 SRG clean patch，并保留 mcinject 前后真实结果和 exceptions/access/constructors 输入；无 mcinject 参考用 NeoForm 最终 rename 输出 patch，映射由 mergeMappings 真正产物与官方 mappings 校验。通过这些独立 stage 得到逐类期望，不重跑 production 生成 golden，不用 final output 自证 namespace；成员签名/指令指纹及引用解析到未补丁定义均须相符。
- patched 优先必须在 clean 与 patch 两份定义都有且可辨的同名类上命中，final 语义等于参考 patched（计入适用 AT）而不同于 clean；未补丁见证等于参考 clean 变换，entry= this_class＋`.class`，descriptor/reference 对照固定映射且无该见证的 obf 重复定义。删除项从“必须保留”集合排除，不在此顺手修复所有历史删除语义。R 对每组记录选中类/引用/差异及断言，不能只判断 class 能打开。
- 资源判定按下节精确阶段/来源合同：clean-only 有真实候选即逐字节保留；仅固定 basic 的真实空集可按已接受条件记该正向见证不适用。碰撞按过滤后的 universal 与 clean/patch **合集**求交，空交集沿用 universal-only 合法替代；userdev inject 以真实归档载荷而非配置字符串判定。1165 实有 inject class/service、其它组实有阶段资源及 universal/AT/Dist/marker 验证不豁免。缺输入、工具未执行、类见证缺失或证据不全仍未完成，不能 skip；来源选择不是复制 late-copy 为 oracle。
- **NeoForge 收窄为新鲜产物合同：** 不再比较 P 前旧 final 的完整 Dist attrs，也不声称证明旧→新逐项不退化。新 final 必须具备 `Minecraft-Dists=client server`、现存 marker、预期 universal/AT/资源内容及适用的 `Minecraft-Dist` 格式；从同版 client/extracted-server 原始 entry 集独立选无需类映射的 client-only 资源（若有）核对 client 标记、共同资源内容保留，保存具体清单和推导。差集为空须记录完整差集证据，这是该见证不适用而非 JDK/必需案例 skip，主属性/marker/资源仍必需。未知类级 side 分类、完整 attrs 的旧新等价及所有历史行为不在本次证明范围；已知 mapped-client 对 obf-server 的静态风险继续保留。新产物不满足此明确合同或需改 DistAttributePostProcessor 才能闭合即停止受影响分支报告，不扩成 Dist 修复。

各 T 将本组来源身份、predicate、独立参考 producer/task/provider、具体见证/期望/推导及 Java 角色写入自己的新证据清单；P/basic、Q-1165/1165、Q-Neo/Neo 及 R 核对内容/输入新鲜度后消费，不把一个 partial 的局部参数改判 completed。缺输入、真实运行或见证只使本组未完成，不在规划先跑通；三组最终全需，无额外条件笛卡尔积。

#### 补丁阶段资源范围与固定 basic 空见证适用性

用户已接受：不新增 raw client/server 资源恢复，只保留**既定实际补丁输入阶段的完整内容及后续合法工具/overlay 内容**。basic clean 是 merge 输出（obf），1165 clean 是 rename 输出（SRG），Neo clean 是既定最终字节码阶段（official）；“raw patched”不是 Mojang raw 归档。被既定上游步骤排除的 raw 游戏资源不因此新增进入 final；不另定义双端 raw 资源合并/冲突政策。Mixin supplied-target 保留条款不被扩成 Forge raw 恢复义务，三族 reuse/写入 skip 见 Context。

- **完整内容与优先级：** 非删除 clean/patch 类、接口、引用及该阶段适用资源均须进入正确 namespace/后续处理，patched 定义优先。工具生成或改写资源按独立工具参考/阶段语义核对，不能用 clean 字节覆盖 patched 工具结果。适用 universal filters 后的 payload 覆盖同名内容；inject 相对前缀复制仍无 REPLACE_EXISTING，真实冲突应报错而非伪造覆盖优先。Manifest、AT、Dist/marker 的合法变化单独核对，不作普通资源逐字节损坏。P/各 Q/R/V/H 均消费此范围；类/引用/接口、universal payload、适用后处理与自有缓存隔离、miss→rebuild→hit 全部不减。
- **固定 basic clean-only：** 仅 MC1.12.2 / Forge14.23.5.2860:userdev3 / MCP1.12.2-20200226.224830 在实际 merge-clean 的完整候选集真实为空时，正向 clean-only 字节见证记“不适用：阶段候选集为空”。保留归档/阶段/Jar 摘要、全部非目录 entry、资源筛选与 overlay 排除清单及数量（不能只写结论）。直接诊断确认该 merge-clean 完全没有非 class；不把 raw client/server、后续 mcinject 生成的 fernflower_abstract_parameter_names.txt 或 MCP 源码 inject 冒名补入。损失：basic 不再动态证明非 class clean 补全，也不证明 raw 资源保留。
- **固定 basic inject：** 配置声明 inject/ 但同一真实 userdev3 无该前缀 entry/payload 时，正向 inject class/service 见证可记不适用；须同时保存原 config、归档身份、完整前缀扫描/空集与声明—实物差异。不是“未配置 inject”，也不报告复制成功。损失：basic 不覆盖正向 inject class/service/provider 复制及 inject 冲突分支。1165 的真实 13 class＋3 service 仍须按本组完整验证，不借 basic 空集豁免；Neo 无配置与实有资源的原合同不变。
- **universal 碰撞原有替代：** 用发布 filters 后的非 class 候选 `R(universal) ∩ (R(clean) ∪ R(patch))`，不能只看 clean；记录各阶段/排除项及完整交集。非空则实际核对最终 universal 覆盖字节；空则明确不覆盖碰撞动态优先级，核对真实 universal-only payload，不要求造碰撞。该 basic 已有25项适用 payload 的采用证据仍是旧产物上的有限关系，新恢复/后续运行须关联自身身份重新核对，不能顶替 clean-only/inject。
- **适用性不是 skip：** 只允许上述固定 basic 两种真实空候选及既有 collision 空交集替代；若有候选即执行正向内容断言。1165/Neo 实际存在的载荷继续验证，不扩成所有分支资源缺失均不适用。未物化/工具没跑/读失败/缺清单/JDK 缺失不是空集。精确 basic 方法仍完整实际执行，要求1 test / 0 failure / 0 errors / 0 skipped，不用 Assumptions/disabled/skip、假资源或改版本。覆盖损失贯穿 P/R 和最终验收，不以文档接受当运行通过。

#### 生产修正 P 的所有权与一个完成谓词

**原合同保留，generation1已partial、原gate不满足。** 本节“当前版本7/拟改”等是原P开始前时点；当前源码为版本9，未完完整结果由下节P-v恢复，不把此item改为completed。原两owner/完整谓词及未证reference/AT/body/cache不减。

P 只修改 McpAction.kt 的 runBinaryPatcher/patchStep/内部 PatchResult 交接和 ResolvePatchedMinecraft.kt 的 late-copy/自有 patch 语义版本或等效键；两个接点和缓存版本共同服务一个产出，不按文件拆分。单一完成谓词为：**共同生产修正落实到实际内容，并由 basic 固定真实最终产物完整证明 patched 优先、未补丁接口/类的 entry、this_class、descriptor、super/interfaces/reference 同属目标 namespace、资源/适用 overlay/AT 正确，以及 forge 实际完整有效路径隔离、新语义 miss→真实 rebuild→同输入同版 hit 的可复用结果。** P 消费独立 T-basic-v3 的完整准备/已采用诊断，不等旧 T-basic failed 转成功或另外两组 T、Q 或 R；不是编译成功的实现标记。

notch 路径不能 rename 后原样补入混淆类，也不能只改 entry 而不处理内部名/descriptor/引用。补全时机、namespace 变换、patched 优先和实际补丁输入阶段完整内容（含适用资源）及后续合法工具/overlay 内容一起纠正；不新增已被上游排除的 raw client/server 资源恢复；工具机制在现有能力可验证后选最小方式，不预设 CLI flag。不填空 ICommandSender、不改 consumer/升依赖/扩 API；两个生产边界内无法闭合或权威推翻则报告具体缺口并 blocked/failed。

当前 PATCH_OPERATION_VERSION=7、forge-patch-7/neoforge-patch-7。P 统一改变版本/等效键，静态核对两族调用都用新值；运行证据只在 basic 登记实际 operation/patches 聚合 key/output basename/完整路径与旧语义导出路径隔离，以及私有新 key 初始不存在→真实 Cache miss/工具生成/最终内容→同输入同版 Cache hit。不能在 P 偷加 Neo 实际路径或三组缓存全成功；关联实际路径/缓存由 Q 各自产证，最终仍全需。仅 bump/diff、输出父目录、外层 rerun/no-build-cache、Jar 可打开或偶然旧 Jar 均不足，不清全局缓存/改 Core.Cache。

P 从 T-basic-v3 验证的既有真实 provider 取得新鲜最终 output（所有适用 universal/inject/AT 后），按独立官方工具参考/固定映射及具体 patched/未补丁接口、资源见证核对，保存命令/工具日志/输出/冷热缓存对应和实际源码/fixture/输入身份。只能称“P 的 basic 完整谓词满足”，尚待关联/Neo 的共享实现不称全 namespace/两族实际路径通过。Q 失败不抹掉内容未漂移时已成立的 basic 证据；如共享源码/fixture 再改，核对/重取受影响证据，不能把旧 P/Q/D/B/M 泛化到新内容。P 不代交 Q/R/D/B/M。

#### overlay 完整结果恢复策略

**前轮 P-recovery 执行合同历史。** 该项现已 generation1 partial：两个 owner 为version9，实现效果保留，完整oracle/hit未完且旧gate不满足。下述原生产写权限/版本8缺陷/待执行文字限前轮，不能授权本次再改生产；当前仅按下一节补证，原完整内容/cache谓词不减。

**唯一终态与前置：** P-recovery只恢复原P完整可消费结果；消费已采用T-basic-v3 completed及原P partial中未漂移的已完成代码/输入/见证，不等待旧P或其gate转成功，不等待自身gate或Q/Java21。所有必要生产纠正和作者内容/cache验证为同一Result内部活动，没有独立工具或临时脚本消费者。保留游戏patch输入补全、去late-copy、完整ICommandSender和patched优先，不重复实施这些效果；新fresh验证必须重新关联实际身份，旧成功不补新内容证据。

**最小机制（静态接线已具体化，动态验证仍未运行，不是实施放行）：** 保持游戏原patch→rename→适用mcinject结果，再在原filtered universal覆盖位置、inject/最终AT之前，独立规范化notch适用class。固定选择 SpecialSource:1.8.3:shaded 的 `--live`＋显式 source-namespace classpath，不能仅把该flag加到当前工具classpath。规范化类型、字段/方法owner/name/descriptor、签名/指令/适用class属性而不改Forge自身internal name；继承查找失败不能降为只改entry/descriptor。不新增公开API、依赖或通用框架，不因同文件就允许其它行为。

**固定入口、格式与方向：** [固定MCP配置](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/basicNotch/reference/evidence/mcp-config.json)的rename是 `net.md-5:SpecialSource:1.8.3:shaded`，参数为 `--in-jar {input} --out-jar {output} --srg-in {mappings} --kill-source`，映射来自 `config/joined.tsrg`，方向obf→SRG。实际jar身份见[工具清单](../../../build/fix-forge-patch-namespace-20261023-1830/observed-input-identities.json)（SHA256 `9105207cc68fbba768b314fa8584f7c63de2cf664f1fd50aaab4a386975a88bd`）；本轮只读解析该归档的 `SpecialSource.main`、`JarMapping.tryClimb`、`InheritanceMap.load`、`ClassLoaderProvider.getParents`、`JarProvider.getParents` 字节码：main在 `--live` 时先加入系统ClassLoaderProvider，再加入input JarProvider；ClassLoaderProvider按 `<internalName>.class` 资源经ASM读super/interfaces，不反射加载游戏类；tryClimb无直接成员映射时，按这些原始owner/parents递归查映射。因此提供的是**obf class文件资源**（不是SRG成品、TSRG继承表或只有工具依赖），沿用未reverse的原映射；不使用 `--live-remapped`。生产规范化命令形状锁定为：

```text
<java8> -cp <tool.jar><sep><U-raw-classes.jar><sep><G-obf-full.jar><sep><libraries...><sep><other-fixedPatches...> net.md_5.specialsource.SpecialSource --in-jar <U-raw-classes.jar> --out-jar <U-srg-classes.jar> --srg-in <config/joined.tsrg> --kill-source --live
```

`<sep>`为当前平台classpath分隔符；使用该工具manifest的main class，工具jar保留首位以免库中的ASM/Guava替换工具自身依赖，余下fixedPatches去掉重复工具/库；库组按文件内容SHA256确定次序并按内容去重，不依临时绝对路径。JVM的Java8启动/扩展资源仍先于系统classpath。`U-raw-classes`只含原filters选中的class，lookup与转换共用此输入，优先于游戏；nonclass不经此工具。`G-obf-full`必须是实际notch merge替换点的**完整binary-patch输出、rename之前**，不是最终SRG/mcinject产物或稀疏patch子集；其patched-over-clean及删除语义沿用原P已完成补全。

**两个owner的有界交接：** [McpAction](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt)当前 `runBinaryPatcher(): Path` 最后只返回joined末步，`LibraryStep.executeStep` 的classpath只有工具和fixedPatches，二者都尚未提供上面的G/U/库。未来只在两个原生产owner内，把现有 `internal runBinaryPatcher` 返回值改为内部PatchResult：交接最终patched Path，以及notch所需的实际merge替换patch步deferred输出G、从同次rename已解析data参数取得的mapping Path、该rename的Library(tool/jvmargs/args)和fixedPatches。保存并await现有StepOutput/Deferred，不另跑patch或从最后Path猜原始输入。现有公开 `mcpConfig/run(): Path` 保持签名及原返回含义，若需共享执行体则只在本文件提取private/internal富结果入口、公开入口取final Path，internal runBinaryPatcher取内部结果；不改变公开McpAction/Step API。non-notch不生成/消费notch上下文。ResolvePatchedMinecraft继续拥有filters/overlay/inject/AT：以已有 `libraries` 输入集合（也是 `listLibraries` 的producer）及metadata选择的同一Java8/McpActionContext，把filtered U和内部上下文交回McpAction内的专用normalize调用；该调用给现有private executeStep增加仅此调用使用的额外runtime classpath和 `--live`，原游戏rename/mcinject调用不变。不能把listLibraries的 `-e`/路径文本文件当classpath，不能新建公开参数或把normalizer搬到fixture。Normalize只产出class overlay供Resolve在原位置覆盖；最终游戏Path及非notch/Neo行为不变。

原filters与是否叠加universal的条件保留（包括适用Neo路径）；游戏patched优先、filtered universal在原位置覆盖同名内容；核对映射后目标entry名/重复项/碰撞，不能引入先到先得或重复归档项。原inject相对前缀复制仍无REPLACE_EXISTING，真实冲突仍报错；overlay→inject→AT→适用Dist→marker不变。独立规范化不使universal新经过mcinject，不前移整个universal或inject；非class资源、manifest、service、内置映射（含deobfuscation_data）按既定资源/后处理合同保留，不做文本替换。non-notch SRG及Neo official不无条件再做obf→SRG。

**实质选择与blocked边界：** 下述静态归档/闭包核对支持现有工具、原始输入和两owner内的具体接线，P1不再以“届时找参数/继承见证”占位；未实跑仍是明确限制，未来固定见证与全量内容/cache验证仍为同一个P-recovery内部活动。实际工具失败如实记failed，缺输入/权限/能力则报告精确blocked，不靠只改名称或放松断言交付。把class移至既有rename前不是默认等价备选：其mcinject适用域/metadata、目标碰撞、顺序和优先级未有等价证据，**该替代路径blocked**，不能在实现中静默切换。需要改公共fixture/helper/test/consumer/Dist/API/依赖/支持namespace时先报告越界，不用本计划补权威或接受新选择。

**独立class/resource/AT oracle：** 允许在新build证据根规划必要薄验证接线，复用真实provider及已物化固定输入；不改旧verify-content.py或公共fixture/helper/test，若该边界不足须先报。原8CLI仅证明游戏clean/稀疏patched参考，raw-universal+AT不再作正确最终class期望；旧文件/未执行状态保留，不删其它断言。固定两个独立断言，不从共同renamer结果反推期望：

- **类型：** 原universal的 `net/minecraftforge/client/IClientCommand` 保持this_class，父接口bk→`net/minecraft/command/ICommand`，`allowUsageWithoutPrefix(Lbn;Ljava/lang/String;)Z`→`(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Z`；[固定映射](../../../build/fix-forge-patch-namespace-20261023-1830/fixed-mapping.tsrg):1145、1179及原class声明分别供证，映射后游戏定义真实存在且无bk/bn重复定义。
- **继承成员：** 原 `net/minecraftforge/client/ClientCommandHandler extends bj`，本类**没有** `b()Ljava/util/Map;` 声明；`a(Lbn;Ljava/lang/String;)I` 的原offset59为 `invokevirtual net/minecraftforge/client/ClientCommandHandler.b()Ljava/util/Map;`。`bj`在独立merge-clean及patch-obf中均声明该public实例方法，其super为java/lang/Object、接口bl；[固定映射](../../../build/fix-forge-patch-namespace-20261023-1830/fixed-mapping.tsrg):1132、1144给出 `bj→net/minecraft/command/CommandHandler` 和 `b ()Ljava/util/Map;→func_71555_a`。预期保留Forge调用owner，方法名改为 `func_71555_a`，descriptor仍为 `()Ljava/util/Map;`；class super改为CommandHandler，含bn的方法descriptor也须映射。最终按方法语义位置寻找对应指令，不硬要求重写后仍是offset59。只做类型替换或792→0会漏掉本断言，不能以直接声明在Forge本类的普通成员替代。

**独立reference的分离接线：** reference不用生产PatchResult/G/normalize/merge helper，也不拿生产输出作golden；使用[私有reference已归档输入](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/basicNotch/reference/evidence/files.tsv)中的原universal、`output/stages/patch-obf.jar`、`merge-clean.jar`及basicLibraries，另从该reference选定Java8运行时的class资源取必要JDK声明。新build薄接线独立应用原filters，只抽class；由原class头/常量池的member owners收集super/interfaces递归闭包，原始名下依次选universal、patch、clean fallback和库（JDK资源按启动优先），clean排除[patch记录](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/patch-records.json)的5个deleted类 `bul$1/cbp$1/c$6/c$7/ni$5`，patched头优先。只建声明表，不合成/复制生产完整游戏Jar，不让clean恢复deleted项。

该reference**不用 `--live`**：固定工具另有 `--read-inheritance <file>`，文本是每行单空格分隔的 `child parent1 parent2 ...`、JVM slash internal names、无descriptor/JSON/TSRG缩进；每行至少两个token，只输出有父节点记录；无父声明保留在声明表但不输出child-only行，不伪造self-parent。固定reader执行 `line.split(" ")`，不足两个token抛 `IOException("Invalid inheritance map file line: " + line)`。main实际调用 `InheritanceMap.load(reader, mapping.classes.inverse())`，故文件必须写**target/SRG名**，load后还原成原始obf名；child或parent的inverse解析失败分别抛 `Inheritance map input class not remapped` / `Inheritance map parent class not remapped`，不是丢弃或过滤；identity因此不可省略，不能直接喂obf表或假定Forge/库名自动保留。为完整保留closure，reference在原joined.tsrg副本末尾**仅**为闭包中无class映射的Forge/库/JDK类追加 `name name` class identity行（不加member映射，不改3344条游戏class及原member映射，先检验target唯一无碰撞），再按该增强表将原始声明表中有父节点记录的child/parent转为target名，输出 `reference-inheritance-srg.txt`。命令沿用同一工具/Java8原rename参数（含 `--kill-source`），但 `--srg-in <reference-identity-augmented.tsrg> --read-inheritance <reference-inheritance-srg.txt>`，**无reverse、无live、无生产G的classpath**。固定输入保留2448个声明节点，输出2447条有父节点记录；唯一无父 `java/lang/Object` 保留identity及终点记录，不写继承行。预载inheritance覆盖所有有父节点，input JarProvider仍只服务原class输入；无live时Object不在raw U输入中，`JarProvider.getParents` 返回null，`JarMapping.tryClimb` 把null传给 `InheritanceMap.setParents` 缓存空父集，搜索在此停止，不从系统/tool库补声明。工具的shaded库不充当reference的声明来源。原fixed映射副本、identity增量、声明producer/entry/摘要、target表与逆向还原核对均留在新build取证，不另设消费者或新工具阶段Result。

对reference规范化输出施加同版本适用AT或最小闭包AT，保存完整argv/工具/JVM/输入/阶段/退出，按字段/方法/descriptor/指令/属性的规范化语义对照真实final。共享固定renamer不构成自证：reference使用独立raw阶段/预载声明入口，且上面两条映射/原始声明预期独立判定。对所有适用overlay class作typed reference/namespace及独立语义参考核对，不能以792→0、无悬空名、raw class字节相等或仅聚焦见证替代完整body/AT。游戏clean/patch独立参考、完整11方法ICommandSender、patched/clean差异和合法工具资源继续核对。资源单独按entry/字节和适用manifest/AT/marker合同；25项universal资源重新关联新身份，basic clean-only/inject真空集和collision空交集仍列完整清单/损失，1165/Neo实有载荷不豁免。

**同一完整缓存终态：** 当前8已知含raw overlay，原7及8的历史语义保留，新语义须由原专属版本/等效key与8隔离，静态核对Forge/Neo共用值和新增派生输入/内部缓存语义闭合。Resolve现有自定义cache只传patches；新normalize读取的universal与libraries必须加入该owner内的实际输入集合，不能只依赖已有Gradle @InputFiles。G/mapping由同次既有patches/MCP/原游戏源输入派生，renamer/fixedPatches沿用原配置工具链、固定工具身份计入新专属语义定义而非新增依赖来源；不以临时G/U路径作key，不先生成G再查cache；额外库的内容确定顺序使Core.Cache的集合hash规范化不丢失classpath语义，不改Core.Cache。对basic登记实际operation、完整新增输入聚合key、output basename及完整路径，证明旧7/当前8导出路径与新语义不同；新私有空缓存或可证新key不存在时，同一输入同一新语义/路径取得miss→真实工具rebuild→完整oracle通过→再次task action真实hit，hit输出仍符合oracle且与rebuild语义一致。fresh/reuse可有独立输出但共享同一有效缓存路径，禁止变化输入伪造miss、外层rerun冒充失效/命中；不清缓存/改Core.Cache、不造旧缓存实物。缺reference/DNS/AT/body/hit均不满足，不将未运行记不适用。P-recovery只负责basic完整结果及两族静态使用核对，non-notch/Neo实际内容/path/cache仍由Q各自验证，不能夹成P三组全成功门槛。

**本轮静态可执行依据（不等于运行验证）：** 只读ZIP/class/映射及源码，未执行Java、Gradle、测试、旧取证脚本或网络。上述[reference文件身份清单](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/basicNotch/reference/evidence/files.tsv)、[userdev配置](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/basicNotch/reference/evidence/userdev-config.json)、[Java8选择记录](../../../minecraft-codev-forge/build/forge-patch-basic-2154581704691966044/basicNotch/reference/evidence/jvm.tsv)及实际归档在本轮均可读；userdev filter仅排除binpatches.pack.lzma。它们只作当前静态取证来源，不冒充恢复轮新身份/动态成功，也不依赖外部Result存储。

- 原universal SHA256为 `cd3fbf85d7ca744507fd6a37a41b90122d43e616a4f8962332b1b658655e8a64`；原merge-clean为 `d63b1e6df335a592f8da790ee73ff3b0f099152befde2e4e372feed3eaadc58d`，patch-obf为 `253cefadda238440fad438a7128bd5a49d4998b7930570911e3781e37c5efd9f`。两游戏archive均实际含bj及上述声明，原universal实际含offset59指令且本类无b声明；不是仅引用复审结论。reference的config/joined.tsrg与固定映射均为SHA256 `57527913c5bea02e110aa0d1fa929da6f995f1a7836b0e46d891014b94779f4e`。
- 对1434个universal class及其常量池member owners取2200个查找根，沿同源obf super/interfaces递归：独立声明闭包2448项（universal1434、patch186、clean202、63个basicLibraries归档供353、选定Java8运行时供273），**无缺失声明**，所需class最高major52；五个deleted已排除且raw patch均无相应entry。只取Java8可见类，不将META-INF/versions或未用可选JavaFX/SWT类算作所需声明。原3344条游戏class映射加入2061条identity后为5405条，无target碰撞；前轮将2448个声明节点转target后经增强映射inverse还原与原始声明表逐项相等；只证闭包/方向，未证reader格式，Object单token行实际必被拒绝，旧“验证文件格式”结论撤回。本轮只输出2447条有父记录并逐项核对token门槛及inverse还原，仍保留2448节点、Object identity/终点；没有落盘新mapping、继承文件或工具。
- 另按生产tool-first的真实资源优先级静态核对lookup：闭包2447项、无缺失。工具shaded库与真实库的 `Predicate`、`Function`、`ImmutableBiMap` parent集合有差异，不能称两张图相同；但对全部2200根可达的**游戏映射域祖先**一致，差异仅在不含游戏映射的外部库/JDK支路，故不妨碍本固定obf→SRG成员解析。reference采用无live的完整预载声明表，正是不把这些shaded声明当独立期望。未来须在同轮实际输入上重新记录该闭包/优先级，不能将当前静态计数当新输入恒量或省去完整body/AT验收。

现有固定工具能表示两种接线，G的producer/阶段可在原Step graph保留，U和libraries原已是Resolve输入，独立raw参考及映射/声明均实际可读；因此无需新依赖/公共API/前移路线即可给出静态可执行方案。尚未生成生产PatchResult、运行两种CLI、施加新AT、验完整final或证明cache；任何新输入/authority冲突照原边界报告，不以本段宣告ready。

**后继及证据身份：** 当前Q/R/D/B/M及最终V/H所称可消费完整P，均显式改指P-recovery completed且足证据；原P partial仅是保留输入/历史，不能满足旧gate。保存实际代码/fixture/输入/工具/命令/JVM/日志/产物身份及冷热路径对应；共享再写须复核/重取受影响Q/D/B/M证据，不泛化旧成功。R仍为V/H质量门槛而非D/B/M技术前置，M只等P-recovery/Q-1165不等D/B，Java21分支独立，共享写运行串行。

#### P-v2 定位与恢复连接作者自检

本轮只有“四协调文档的定位纠正及恢复图维护”一个结果；不是执行 P-v2，也不是独立复审。已读取全部八个指定文件及相关现存原清单/脚本/加载参数，inline 的 Router 采用/确认/授权按原范围沿用，PRD/ADR/Spec reuse、不写权威。

- 原证据定位按 [Context 精确导航](context.md#p-v-失败采用与原证据定位纠正) 核对实际字段/文件：sources/compiledClasses 而非 implementations/before-after；prepare/arguments.txt 的 fixtureClasspath 与实际 helper/plugin metadata 交叉导航；files.tsv 的 role/path/size/sha256，gradle-jvm/tool-jvm 和原目录均可读。作者额外尝试读取 prepare/evidence/argv.tsv 得到不存在，已查实际目录并明确不引用该不存在路径为证据；没有执行脚本、工具或重跑验证。
- 图静态内存检查：31 个唯一 item、26 个唯一 Wave/gate，所有 item 单一归属、成员引用可解析；联合 item 前置、Wave 前置 gate、gate 等待全部成员无环。P-v2 只有 T-basic-v3 item 和其已采用 gate 前置，没有旧 P-v failed/旧 gate 等待或自身 gate 回环。新单成员 Wave/gate 与一个 Handler/Result 的完整P终态相配，定位/目录/薄工具只是内部证明步骤。
- 必要消费者 Q-1165/Q-Neo/R/D/B/M/V/H 的 item 连接和实际适用 Wave gate、最终 gate 第1款均改接新恢复身份；现行 P-v 简称在入口明确解析为 P-v2，不改旧 P-v 合同/行。Q 不互等、R 只为 V/H 质量门槛、D/B 不阻 M、Java21不前移到basic；原共享写运行排他不变。缺证/失败不释放。
- 旧 P-v failed/80.054秒/首读失败/零实际验证、两个partial/各旧gate、T-basic-v3 completed/已释放gate及全部历史保留。完整实现/输入/fresh-miss身份、Object+bk/目录纠正、独立reference、class/body/继承/AT/资源/11方法/优先级 oracle、同路径hit及再次oracle、7/8/9隔离、首验证至最终保存单1800秒/有限网络/非网络停止全部不减。原 review-forge-overlay-validation-recovery generation1 ready 仅对这些未变策略沿用，不冒称新图已经review通过。

**精确受影响独立复审范围。** 只核对本次失败采用事实、Context 原证据导航/字段与加载链定位、Plan 对身份来源的纠正，以及新 P-v2 item/单成员 Wave/gate 与 Q/R/D/B/M/V/H 必要连接及历史保留。未变完整策略/生产version9、三族权威和其它无关图不全盘重审；本作者没有发起复审、调度、确认或放行。

未检查动态摘要/实际运行期加载/完整oracle/hit；静态可读导航不保证未来身份闭合，无法闭合仍须按原停止合同报告，不授权 cold/rebuild 或实现修补。

#### 游戏rename继承恢复与新产物验证策略

**原执行合同与历史分界。** 下述P-n/P-n-v/P-v6实施方法、原完整标准与准备记录保留；P-n-v已采用完整源码Result，P-v6技术已通过但Result仍partial。下述‘当前/未来/0次/最多3次’限原执行合同时点，不要求重跑或否定本次已接受偏差；当前证据采用和后继成功输入只按[本次策略](#p-v6-既有技术证据采用策略)及唯一Waves，不用旧completed/旧gate条件覆盖新采用机制。

**现行范围与权威。** 用户已确认原生产notch游戏rename修复及P-v6完整验收范围；当前Handler仅维护四文档，不实施，不因撤销分钟预算重求原范围或旧起点许可。沿用Work/Context的PRD/ADR/Spec三族reuse/写入skip，既有命名一致性、生命周期和资源合同不变，不做新产品/架构决定。P-v5真实四差异与诊断边界见[Context](context.md#p-v5-失败采用与游戏rename恢复边界)。旧P-v5和下节更早策略的只读生产/不cold、version9与旧fresh复用只属于旧item原合同，原文和旧gate保留；不拿它们限制本节必要新构建，也不拿旧failed作成功前置。所有当前完整P消费位置为P-v6，成员/依赖/Wave/gate只见[Waves](waves.md#overlay-未完验证的现行连接)。

#### P-n partial后的未完验证恢复策略

**保留与等价标准。** P-n generation1 partial及两owner/version10已写效果按[Context](context.md#p-n-partial采用与未完验证边界)保留；原item/Result/gate不转成功。恢复只消费已有代码，补未完相关Kotlin编译、固定SpecialSource四引用正例/缺U负例及源码参数对应，交付一个独立可采用的完整源码验证Result。编译/CLI/薄工具仅证明保留修正，不是新工具产品或完整P；唯一item/Wave/gate及连接归[Waves](waves.md#overlay-未完验证的现行连接)。下文原“拟写两owner/9→10/两项”保留P-n规划合同与成功标准，不授权重新实施；三族authority reuse/已确认范围不变。

执行前比对两owner实际内容与after-edit身份/差异；全部调用分支/notch-only条件、平台/tool-first及G→raw U→内容稳定libraries→fixedPatches first-win、完整G payload与U仅声明及正确overlay U-first均仍须足证据。版本10两族operation/固定声明语义域、实际cacheKey实参覆盖（patches+universal+libraries、G/mapping派生来源）与Core内容Murmur3-32→有符号bytes比较器排序去重→聚合→cached-operations/operation/key/basename完整路径推导不减；basename/角色/order不入key、有序身份另证、旧新aggregate可同，工具/JDK/派生G不得冒称直接hash。已完证据仅身份未变且适用时关联，原partial尚未证明的优先级/来源等不能省略。源码漂移、实际覆盖缺口/工具遮蔽或需范围外修正即报告边界，不在恢复中改生产/公共fixture/helper/test/API/依赖/Core.Cache或golden。

未来仅新build证据根内必要薄launcher/assert/日志及正常相关模块编译输出；旧根只读、不执行覆盖旧脚本。按原修正版Java8/11/17与-Porg.gradle.java.installations.paths作必要薄移植，保留原compile失败/纠错/预检冲突；先核当前JDK/源码/输入/即时排他，再取相关compileKotlin真实完成及退出证据，旧compiled摘要不代成功。随后同固定SpecialSource1.8.3 shaded/Java8及身份吻合raw G/U/mapping/libs，用与源码参数逐项对应的完整argv跑四引用正例，并省略U重现原失败。由raw child/parent声明及固定mapping独立重建opcode/owner/name/descriptor/父路径，同一实际检查函数检查正例并拒绝缺U负例，记录真实工具退出/输出摘要/声明来源、重名清单/first-win与工具/JDK遮蔽核对。三invokevirtual分别为NotificationModUpdateScreen.func_73863_a、ClientCommandHandler.func_71556_a、ModelLoader.func_177570_a，一getfield为WorldCapabilityData.field_76190_i；不能只用模拟/硬编码预期或把CLI exit0当负例验证。旧G只复用正确patch阶段，旧rename失败只读对照，不重做有效reference修正。

恢复足证据仅供P-v6取新实际加载/完整产物，不代其任何证据：新sources→实际classes/code source/runtimeClasspath/输入/tool/JVM，隔离10有效path初始不存在或真实miss→真实task-action rebuild→全部4782及原完整oracle→同输入/有序语义/加载/tool/JVM/root/operation/key/basename/path真实hit→再次完整oracle，fresh/cache/两次final身份关联均不变。原typed/11方法/继承/body/AT/资源/归档/优先级/负例与两有效reference身份适用合同不降；8消费者仍只消费P-v6，Q/R/D/B/M/V/H业务依赖不改。

共享构建/CLI串行，每次启动前即时复核排他，历史idle不作锁、原冲突不倒推抹除、不续旧partial。全链正常网络已消费0/最多3次（含P-v6 hit），仅明确临时网络且前次正向退出/输出收束、分存和排他可判才再试，不调查普通网络原因；薄工具编写/类型错误可最小纠正、保留失败并同版复查。真实内容差异/缺字段、源码或输入/加载身份不明、冲突/控制退出unknown即停。无统一分钟/双时钟/全链上界或替代预算；单次工具合同仍遵守。局部复审边界仅恢复图/P-v6/V/H必要连接及历史保留，作者不执行、派发、推进状态或宣称ready。

**最小共享生产接线（原P-n规划与完整标准，现保留已写效果）。** 只拟写McpAction.kt的runBinaryPatcher notch游戏rename分支及必要同文件内部参数构造，ResolvePatchedMinecraft.kt的调用数据交接/专属cache版本输入；不是改四个游戏调用点、全局executeStep默认行为、MCP JSON step或正确normalizeUniversal路径。已读实际调用：Resolve的notch路径→runBinaryPatcher→executeJoined→patch提供完整patch后rename前游戏G；现有executeStep(step, output, getOutput, extraClasspath)可传声明classpath，但当前游戏rename只用MCP原args、无live/外部Forge声明；已有overlay则有live及raw U/G/libraries。固定真实工具为SpecialSource1.8.3 shaded、main net.md_5.specialsource.SpecialSource，原rename参数 --in-jar G --out-jar new --srg-in rawMapping --kill-source（由固定MCP step展开）；此处拟在且仅在notch/step.name==rename的调用副本追加 --live 和下述extraClasspath，不改原MCP step或非notch/Neo分支。Resolve把原universal.singleFile及原libraries交给内部patch调用；若重复解析，复用同一次已解析输入，不新增公共属性/API或新依赖。

**payload≠声明，覆盖次序必须显式。** 游戏rename的唯一payload仍是binarypatcher --unpatched --data产出的完整G；raw universal只查原声明，绝不并入游戏payload，不提前覆盖或改变过滤/overlay/AT/资源/marker。实际工具JVM平台类先于应用classpath，应用工具main/toolJar必须首先，声明次序为G→raw universal U→既有libraries（沿用现有内容hash排序的稳定次序）→固定MCP工具依赖fallback；保留并记录实际最终classpath、重复条目及first-win来源。raw U是当前task universal原archive，不是已SRG normalized U/final；G是patch后rename前原域，不是旧SRG游戏；libraries是同task libraries真实已解析字节，不临时网络挑替代。overlay原有U-first的payload声明优先及G交接保持正确，不顺手重排overlay。若G/U重复类，游戏声明以G为准；四个Forge child仅在U，应能沿raw父链到G/clean声明，记录重名清单/命中来源。tool/JDK遮蔽目标声明、raw域错用或固定工具无法尊重所需优先级须停止报告，不靠顺序猜测通过、全局换provider/升级工具或暗增owner。这里选复用现存live/extraClasspath是最小实现策略，不是动态证明；单--live而classpath不含完整原域声明仍不合格。

**两项独立终态，不按文件或检查拆。** 生产源码/专属版本接线及有实际固定工具聚焦回归支持的修正可独立保留，被新产物验证消费；即使后续全量内容、运行或hit失败也无需重做这份源码修正，故与完整新产物验证分开Handler/Result。必要参数传递、缓存版本/输入调整和四行聚焦检查只证明同一共享修正，无独立公共API/工具产品消费者，不再拆。生产项最小验证为两个owner的差异/调用分支及cache输入静态核对、相关Kotlin编译，并在该项新根用同一固定工具、raw G/U/mapping/libs的精确拟议命令做四行参数化正例及省略U的原失败反例；四行应分别改变，记录实际argv/命中声明/退出和输出身份。此CLI回归证明工具机制与源码参数方案吻合，不冒充新生产task实际加载/完整产物验证。原G复用仅限诊断已证未损坏的patch阶段且全部输入摘要一致；不得用旧rename作新golden。所有薄assert脚本只在该项新build根，不新增公共测试工程。若聚焦失败/非网络/输入不明停止，不扩写正确overlay或reference。生产源码修正可以独立审查/采用，但编译通过本身既非独立价值理由，也不证明完整P。

**专属version10与完整有效key/path。** [ResolvePatchedMinecraft](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt)现PATCH_OPERATION_VERSION=9，顶层cacheKey实参为(patches + universal + libraries).map { it.toPath() }，operation为forge-patch-9/neoforge-patch-9；P-n拟升同一常量至10，以forge-patch-10/neoforge-patch-10独立operation域隔离7/8/9，不改Core.Cache、Hash、依赖或清搬旧缓存。非notch/Neo仅受缓存namespace变化影响，不宣称行为/实跑已验证。核对声明读取的raw U、G派生原料与库实际字节均有输入来源：userdev/MCP/binpatch/映射配置逐一关联实际patches，另记实际工具坐标/bytes、JVM及完整有序声明classpath；不把派生G或工具/JVM自动视为Core已hash的输入。确有新增所读File未覆盖时，仅在已授权两owner内补齐必要cache输入并记录实际实参；超出owner/API或无法证明覆盖即报告缺口。

**Core实际算法，不编码角色或顺序。** [Cache.cacheExpensiveOperation](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt)定位为`<cacheRoot>/cached-operations/<operation>/<aggregate-key>/<output basename>`；[Hash.hashFile](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt)对每个文件原始内容执行Murmur3-32（Hashing.murmur3_32_fixed），不混入basename、路径或角色。每文件HashCode.asBytes()经源码toSortedSet比较器排序去重：逐字节按Kotlin Byte.compareTo比较首个差异，无差异再比较长度；不是文件名、hex字符串或无符号数字排序。按此唯一hash序列依次putBytes到另一个murmur3_32_fixed hasher，hash().toString()才是aggregate key。故相同内容集合换序、重复输入、同内容改名不会自动改变key；相同32位hash也会被去重，key相等不证明完整输入身份相等。output basename只参与输出定位/allCached存在性判断，不进入上述输入hash。

**隔离的实际证明方法。** P-n须以源码/参数核对明确版本10专属operation所绑定的固定notch声明域及优先级：游戏G→raw U→内容确定次序的libraries→fixedPatches fallback，沿用既定payload分离与原overlay优先级；输入身份记录保留角色、解析顺序、重复项及实际first-win来源。Core的排序去重不替代该有序合同，记录元数据本身也不改变cache key。版本隔离比较`(cacheRoot, operation, aggregate-key, output basename)`完整定位；即使7/8/9/10的aggregate key相同，只要实际operation分别为对应版本即为不同路径，不能要求或虚构hash必然随版本变化。P-n交付版本/输入域方案及逐项覆盖依据，P-v6须把实际加载源码、operation实参、有序输入/命令和实际路径对应起来；同一版本域内若角色/次序/工具或JVM语义无法与约定一致，或所读输入未被覆盖，停止报告，不靠证据清单伪装Core自动区分，也不静默修改Core算法/增加未授权语义。

**P-v6缓存证据对象与同路径合同。** 在自身全新私有cache root，列明实际绝对root、operation、完整cacheKey实参清单（角色/顺序/path/basename/bytes/SHA256/实际Murmur3-32）、排序去重前后hash对应、按源码重算的aggregate key、output basename和最终绝对有效path；完整声明classpath/工具/JVM/加载身份另列并关联，不冒充都进入Core key。先保存目标版本10输出路径不存在或真实miss的可核对证据，再关联同一task action的Cache miss、真实generate/patch/rename/overlay/AT/marker及退出，取得新fresh；fresh全部4782等oracle通过后，以同一root/operation/实际输入字节与有序语义/key/basename/有效path再次进入task action取得Cache hit，再做全部oracle。记录新fresh留存副本、cache输出、两次task最终输出的路径/bytes/SHA256及日志/轮次对应；本顶层cache的generate调用resolve，缓存已含AT/适用Dist/marker的最终输出，须与该轮最终输出关联，G/rename/normalized overlay等中间件另记，不能混成同一对象。外层--rerun-tasks只使action到达，UP-TO-DATE/FROM-CACHE/换key/再次miss/拷Jar或搬cache均不代hit；tryLink可能硬链接，留存使用字节副本且不就地改产物。hit前后源码/实际compiled classes/code source/runtimeClasspath/完整输入/工具/JVM/有序语义不得漂移。旧version9/fresh、7/8/9历史路径和旧miss采样仅作只读历史对照，不代新10路径、真实rebuild或hit；本节全为未来验收合同，当前未运行。

**四处真实参数化闭合及独立预期。** 保留两处已有效reference修正、ItemPredicate真实ey→fh.func_148741_d、BlockFluidBase5指令/InnerClasses→BlockStateContainer$Builder及负例；仅当raw输入/mapping/tool/JVM/source脚本版本适用性一致才复用其算法/证据，不重做既成语义纠正、不直接认证旧输出。新reference仍由独立raw patch+clean-minus-deleted+raw universal/libraries/Java8声明建立target表/唯一inverse/有效内嵌mapping，通过固定工具read-inheritance；不用生产G/final、live/provider或生产helper反推golden。新build根可必要移植薄工具/路径，但只可纠正可证编写/静态类型错误，不扩展语义修正权限。

同一检查函数以Context四行raw child/parent、固定mapping及完整指令为参数：独立算出descriptor/owner/name/opcode/父路径→检查新生产实际游戏rename→在实际新normalized overlay及游戏声明中解析同一引用→再检查fresh/hit最终AT产物。三个invokevirtual与一个getfield均须唯一定位、按原parent正确映射（NotificationModUpdateScreen.func_73863_a、ClientCommandHandler.func_71556_a、ModelLoader.func_177570_a、WorldCapabilityData.field_76190_i）；字段继承与方法继承分别核对，不改调用owner来掩盖错误。省略Forge声明/保留obf名字等单变量负例应由同一实际函数拒绝。旧rename四行失败只读对照保留，不新增封存。聚焦回归和实际加载之间的证据边界明确分层，任何一行不符停止而非改golden。

**完整新产物与实际加载。** P-v6消费已采用源码修正结果，但从当前sources SHA256、编译classes/插件实际code source、fixture runtimeClasspath及每条摘要/顺序、完整输入、JVM executable/metadata、实际task argv和运行前后无漂移重新闭合；不能源码相同就复用旧编译输出。新源码编译/加载不可静默落到旧JAR/旧included build；缺实际加载来源不完成。production build/私有fixture/cache/reference新根均须当前排他；薄入口复用既有private fixture/current task API，不写公共fixture/helper/test/consumer。不拿P-n直接CLI输出或version9产物充当新task fresh。全部4782 class/body/成员/继承/属性/异常/reference/AT、11方法和原两个typed锚点、游戏类保持/完整parents/Object+bk、patched/overlay优先、资源/filters/inject、归档/manifest/marker及全部原合法验收持续有效；数量只作固定basic交叉检查，不作删比较上限。原预检真实录制/完整日志、相同实际函数正负例、新目录首次/重复准备、reader失败语义与target唯一inverse仍检查。basic资源空集/碰撞空交集适用性和损失明示，不能把未执行记不适用；1165/Neo实有载荷不豁免。fresh先完整oracle通过才能hit，hit后再次完整oracle。Q两组仍各证本组路径/内容/冷热，R仍完整矩阵/真实AT/JarJar，D/B/M各自独立，最终V/H全量合取不减。

**分钟预算已撤销，完整生产修复及验收不变。** 用户已取消P-n→P-v6共用1800秒/30分钟截止及其起点前UTC/单调配对、跨Handler共同原点/宿主可比性、交接扣时、最终Result发布末值、全链阶段上界、60秒收束和独立保存余量证明门槛。它们不再约束启动、继续、Result采用或gate，不再调查或创造替代预算前置；下列原协议/矩阵仅保留历史。全链正常网络最多3次（含hit），仅明确临时网络且前次真实正向退出/输出收束、证据分存及当前排他可判才再试。新根薄工具可证编写/类型错误仍只允许最小纠正和同版复查，保留原失败/分类/改动/复查；真实缺字段、实际内容差异、输入/加载身份不明、冲突或控制退出unknown仍停止。单次工具超时遵守实际工具合同，普通日志/实际起止耗时照实保留，不据此新建统一分钟预算。

**披露与复审边界。** P-n两个生产owner/notch-only原域声明和优先级/live接线、version9→10/input/key及non-notch/Neo缓存namespace影响、各新build根薄工具和实际构建/隔离cache、P-v6新实际加载/全部4782及原完整验收均按既有确认保留，不重求旧预算起点或不变范围许可。受影响边界的不同Handler局部review仍未由本次完成，只需核预算撤销、两item/独立Result/gate、8消费者/最终第10款必要连接及历史分界，不重审未变权威/三模块清单。作者自检不替代独立review或实际执行足证据，本轮没有生产执行、调度或gate释放；现行说明和本轮实际检查见[分钟预算撤销与作者自检](#分钟预算撤销与作者自检)。

#### 预算复审阻断与现有证据

**预算调查历史，非现行前置。** 本节完整保留撤销前复审/取数链/分阶段观察及unknown，不重验或抹除旧结论。P1机制未建立、P2证据不足仍为事实；用户已撤销其政策，故下述“阻断/不得开始/须补证/须再确认”仅指当时，不再约束P-n/P-v6或其gate，也不要求继续调查时钟、发布耗时及阶段上界。现行边界以[分钟预算撤销与作者自检](#分钟预算撤销与作者自检)和[Waves](waves.md#预算撤销后的执行准备边界)为准。

**采用结论与本轮终态。** Handoff提供的独立只读复审已判本预算局部**not-ready**：原文虽覆盖起点/连续1800秒/交接/保存/停止及图连接，P1仍缺可取得且已证跨Handler可比的具体时钟机制，P2仍缺新链全部阶段的耗时依据与可靠上界。本轮只读现存源码和已采用运行产物后，能细化候选和历史分段，**不能证明可行，因此保留两个阻断**；文档维护完成不等于预算ready、复审通过、实施确认或item/gate完成。执行图只归[Waves](waves.md#统一预算执行准备阻断)，采用与范围只归[Context](context.md#统一预算复审采用与证据缺口)、[Work](work.md)。

**P1：可指认的既有读数链，不是已证新链机制。** [P-v5原进程记录](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/initial-process-sample.json)包含启动PowerShell的真实CommandLine：先`[DateTime]::UtcNow`，再`[System.Diagnostics.Stopwatch]::GetTimestamp()`，频率取`[System.Diagnostics.Stopwatch]::Frequency`，然后写[budget-start.json](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/budget-start.json)。这证明旧批次具体取数入口及持久读数，不能把进程记录内引用的任务提示当新的授权。原始ticks为19131813792482，frequency为10000000 ticks/s；[setup.py](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/setup.py)按ticks/frequency得到1913181.3792482秒，再加1800写[budget.json](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/budget.json)，截止1914981.3792482。随后[run.py](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/run.py)的remaining()/call()和[finalize.py](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/finalize.py)直接使用Python `time.monotonic()`秒值；它们没有在这条源码链内验证两个API的共同原点。

| 时钟边界 | 现有可读证据已说明 | 尚缺而不能推定的依据 |
| --- | --- | --- |
| 具体接口/单位 | 旧PowerShell实际取Stopwatch ticks/Frequency，Python实际读time.monotonic；上述数值换算可复算 | 新P-n和P-v6实际可用的共同读数接口及提供者/运行时版本、宿主绑定；旧数值吻合不证明跨API语义相同 |
| 共同原点/宿主启动身份 | 旧记录有进程创建身份及单次频率 | 没有绑定到这两个时钟提供者的同一宿主启动标识、共同原点证明或重启/换宿主核对；进程CreationDate不是宿主启动身份 |
| 等待与休眠 | 旧起止值间计入了该次已有进程间隔 | 无可关联来源说明此具体提供者在两独立Handler/进程中连续涵盖调度/交接等待及可能的系统休眠；不能据“monotonic”名称免除 |
| UTC配对/精度 | 旧命令按UTC→ticks顺序读取并保存 | 没有配对误差界或包围取样记录；不能称原子同次、零误差或用UTC差额补单调缺口 |
| 保存完成/交接核对 | [finalization-exit.json](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/finalization-exit.json)在旧本地收束脚本后记录ticks和频率 | 没有P-n→P-v6两个Handler原始同源读数交接记录，也没有对应运行时Result持久保存完成的可核对终点；本地JSON结束不等于Result提交完成 |

现存可具体指认的候选是Stopwatch的ticks/Frequency；**本轮不将它或混用Python的旧方案确认为可执行跨Handler机制**，也不臆称QPC、宿主启动API或未来进程一定可用。P1最小缺证是：同一具体可取得接口及版本的仓内可关联来源，证明其原点/单位、跨进程与等待/休眠语义；实际绑定宿主启动实例并能在交接时核对的方法；UTC配对误差/保守扣减与最终保存终点的可取得依据。仅字段清单、同名API、相同频率或同机器不够。不能证明这些时，不得开始P-n执行准备或以P-v6重新起钟兜底。下节仍是受阻候选，非新增时钟框架或采样权限。

**P2：完整链路逐阶段依据与缺口。** 下表只读取既有文件并做字段/算术核对，没有执行这些运行证据脚本或启动构建、测试、进程采样。所有数值均为**旧批次观察**，不是新链测量、阶段上界或性能承诺；`unknown`不能填0。新链新增生产源码/编译/新加载/version10 rebuild和交接，旧P-v5只复用version9原fresh且在首轮完整oracle失败后停止，两者不可直接套用。

| 新链必需阶段（连续覆盖，不另立预算） | 可关联历史证据与观察秒数 | 新链上界/不确定性 |
| --- | --- | --- |
| P-n执行方法加载及运行时/输入/身份/冲突前置核查 | [旧budget-start](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/budget-start.json)到[setup-exit](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/setup-exit.json)的ticks差/f为229.3626324；[旧batch](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/batch.json)记录preparationElapsedSeconds=893.9130332 | unknown；两个是旧准备的嵌套区间，无法分解到新P-n的具体核查，不能相加或当上界 |
| P-n两owner编辑/version10/input接线、Kotlin编译及四行正负例 | [compile-oracle-exit](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/compile-oracle-exit.json)为1.9936772；[独立reference-v2](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/independent-overlay-reference-v2-exit.json)为16.7166917；[sample-controls-v3](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/sample-controls-v3-exit.json)为3.2577896 | unknown；分别是旧javac/reference/旧两样本，均非生产Kotlin编译和新四行聚焦回归，不能冒充新阶段实测 |
| P-n收束与Result保存、完整读取/关联/采用及Handler交接等待 | 旧P-v5为单一验证Handler，未有本链P-n Result/交接产物 | unknown；没有可拆分观察或调度等待上界，不能省略或移出1800秒 |
| P-v6方法加载、原钟核对、新classes/code source/runtimeClasspath及输入/JVM/排他重核 | [旧closure-state](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/closure-state.json)的currentLoadedIdentity=false，gradleRuns=0 | unknown；候选classpath快照不是新运行实际加载，旧准备总时长也不是本段上界 |
| 私有构建/version10真实miss→task-action rebuild/new fresh | [P-recovery completion-evidence](../../../build/recover-forge-overlay-content-20261024-0515/completion-evidence.json)第二轮外层调用470.150187秒；[同轮provider日志](../../../minecraft-codev-forge/build/forge-patch-basic-8671257575882094287/basicNotch/prepare/gradle.log)有forge-patch-9 miss、patch/rename/normalize与BUILD SUCCESSFUL in 3m 20s | unknown；旧version9外层成功还含fixture/reference等工作，日志200秒也不是可拆分的新version10 rebuild上界；首轮222.5083927秒失败保留，不混作成功估算 |
| 新fresh的第一次全部4782及完整内容oracle、必需typed/11方法等 | [content-fresh-exit](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/content-fresh-exit.json)为8.1639237秒、exit1；[旧closure-state](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/closure-state.json)记录4782中4778/4且后续anchors未到达 | unknown；该完整比较确已执行但失败，不含未到达的typed/11方法复查，也不是新产物成功总验收上界 |
| 同root/operation/输入与顺序语义/key/basename/path真实task-action hit | 旧closure-state的sameEffectivePathHit=false、gradleRuns=0；run.py仅保留未来hot/final代码 | unknown；源码中的timeout/require_budget常数不是实测或可靠上界，UP-TO-DATE/新miss仍不代hit |
| hit后的第二次全部4782及完整oracle与fresh/hit身份比较 | 旧closure-state的postHitFullOracle=false，无该轮执行记录 | unknown；不能拿第一次8.1639237乘2冒充两次成功全量及差异核验上界 |
| 后处理/真实退出/证据归档及至少60秒收束 | [budget-final](../../../build/recover-forge-overlay-validation-recovery-pv5-g1/budget-final.json)的旧失败收束脚本区间0.3048063秒；finalization-exit的wrapper ticks差为0.5868224秒 | unknown；这是失败后提取既有材料的嵌套片段，不含新成功链全部后处理，不相加、不挤占规定的收束余量 |
| 最终本地证据与Result保存（独立保存余量S） | budget-final采样在该JSON自身写入之前，报1466.6646031秒；finalization-exit在本地脚本结束后报1466.6798752秒，并明示不声称旧Result提交延迟已覆盖 | unknown；无新Result持久保存完成的耗时/关联终点，不能以0.3048秒或旧saveReserveSeconds=30替代充分的S依据 |

上述观察存在父子嵌套、来自不同批次/版本且有未达阶段，不得累加、删去失败/等待、把timeout当性能数据或用1800−1466.68当新链空间。若以互不重计的全部未完阶段保守上界记为`U_i`，则进入/继续前须能有依据地满足`Σ U_i + C + S ≤ 实际剩余R`（开始时R=1800，C≥60，独立S>0）；阶段身份/输入/实现/环境适用性、交接等待、正常网络最多3次及保存终点也必须闭合。**当前U_i及S的充分依据缺失，不能求得可行总预算，P2保持not-ready。** 最小缺证为上述每段同范围可关联耗时与保守上界/不确定性、无遗漏无重计的合计、等待边界及足额C/S；没有证据的阶段明确unknown，不因用户确认预算就变得可估。

这份缺证清单不授权本次运行来补证，不创建测量框架、独立item或新的收据协议。P1/P2及受影响边界复审/具体范围确认未满足，P-n与P-v6均不得进入执行准备；P-n将来若在合法边界内独立完成，后继预算不足仍保留其真实成果，但完整P/消费者gate继续等待P-v6自己的完整证据。两个Result、[全部消费者/联合gate](waves.md#overlay-未完验证的现行连接)、原1800秒/至少60秒及独立保存余量、真实差异/身份/控制退出unknown/冲突/到限即停均不削减。

#### P-n至P-v6统一预算起点与连续计时候选

**已撤销候选的历史原文，非当前执行合同。** 下列起点/跨Handler双时钟/唯一截止/交接扣时/全链估时/60秒及保存余量/发布末值/预算unknown或到限停止/预算起点再确认要求全部随用户取消分钟预算而退出当前前置；保留原文只为准确追踪未获技术证明的候选，不再补证、采样或追认。真实内容、输入/加载身份、冲突、控制退出和完整验收依现行合同继续约束。

**提案状态与事实边界。** 这是尚未接受或生效、经既有独立局部复审判not-ready的重大预算边界提案，不是既有实施确认；P1/P2未闭合时本节仅记录受阻合同。现有选定材料规定了共用1800秒，但没有供本次新范围使用的原始起点与跨独立Handler/进程可比证据；不能因此判断某次未记起点的执行用时或是否超限，不能从旧P-v5的1466.68秒、文件时间、当前UTC或后继启动时刻反推。本次只编写协议，不补填任何UTC/单调读数，不建立实际时钟能力或性能证明。PRD/ADR/Spec继续reuse，不改权威；唯一可执行分解仍在[Waves](waves.md#overlay-未完验证的现行连接)。

**唯一开始事件。** 在不同Handler完成受影响边界的只读独立复审后，仍须由Router披露并获得新的具体实施范围确认，其中明确包括本预算起点变更、计入/排除工作和不足即停。只有P1/P2证据缺口闭合、受影响边界独立复审无阻断且取得该确认后，P-n才可在首次执行相关方法加载、源码/静态/LSP/离线检查，以及运行时/输入/身份/冲突等执行前置核查之前，先保存同一采样事件的原始UTC `U0` 与单调读数 `M0`、来源和配对方式；先检查再补起点不合法。此采样本身即启动连续预算，不以首次Gradle、首条CLI、首处代码改动或P-v6启动为起点。若首次记录不能可靠取得/保存，停止执行准备，不先做生产工作。本候选不让任何旧批次重新拥有1800秒。

**跨进程可比性是证据要求，尚未建立。** 同时记录单调时钟的具体API/提供者及版本、宿主/启动实例、共同计时原点或时钟域、原始单位/频率及秒换算规则、采样精度/配对误差与限制，并提供可读仓内来源支持该提供者在两个独立Handler/进程中共享同一原点和单位、稳定单调且连续涵盖交接/调度等待及可能的休眠间隔。记录UTC与单调读数的同次采样关系，配对误差只能保守缩短可用时间，不能延后起点或截止。只有同名API、同一频率、同台机器或两个进程各自从零的elapsed不足以证明可比；不同宿主/重启后原点变化、读数倒退/换算不明或不能涵盖实际间隔均停止。已读现存Stopwatch→Python取数链及未证边界见[预算复审证据](#预算复审阻断与现有证据)；它未成为可执行机制，P1缺证须在允许进入执行准备之前闭合，不能假定未来范围确认会提供时钟能力。本次不建立或验证新时钟API、框架或公共工具。UTC供关联和异常说明，不用墙钟差额替代可靠单调用时。

**固定截止与连续覆盖。** 设已证频率为每秒 `f` 个原始单位，则单调截止 `D = M0 + 1800 × f`；任一同源读数 `M` 的已用 `E = (M - M0) / f` 秒，实际剩余 `R = 1800 - E` 秒。UTC展示截止为 `U0 + 1800秒`，仅供关联，不覆盖单调判定；保留原始读数、计算/舍入依据和负余量，不把超限截成零后当合规。截止不可延后，P-v6全部最终证据及Result必须在同一截止内保存完成，保存开始时间不代完成依据。新Handler/进程、日期变化、暂停、调度/交接等待、工具纠错或继续执行均不暂停、不重置、不补时。

预算从上述开始事件连续覆盖：P-n运行前运行时/输入/身份/冲突核查、执行相关方法加载/源码读取/静态/LSP/离线核对、两owner生产接线与版本10/输入、编译、固定工具四行聚焦正负例、进程收束及P-n Result保存；两个Handler之间完整Result读取/关联/采用判断及等待；P-v6首先核对计时来源和实际剩余，其后的当前输入/新classes/code source/runtimeClasspath/工具/JVM/排他身份重核、私有构建与缓存miss/rebuild、新fresh全部4782类及原完整oracle、同root/operation/key/basename/path真实task-action hit、再次完整oracle、postprocess/真实退出/证据与最终Result保存。内部薄工具最小编写/类型纠错及复查、有限网络尝试、失败取证与安全收束均在内，不能移到计时外。

明确不覆盖本次纯文档准备/作者自检、实施前独立局部复审与新的用户范围确认，也不覆盖已有历史批次或未来Q-1165/Q-Neo/R/D/B/M/V/H各自工作；这些不计入并不许可在起点前替本链预做执行核查、编译、预热/rebuild或oracle。将来在同一新范围内为P-n/P-v6实际进行的任何此类工作仍从上述开始事件计时。两项独立终态与各自gate不合并，P-v6自身不另得1800秒，范围外分支的原完整验收和预算也不被本提案改写。

**P-n Result的计时交接内容。** 在现有Result的报告/证据中携带原始 `U0/M0`、采样配对/误差、时钟来源/API/宿主/启动实例/共同原点/单位频率及跨进程可比性依据；P-n实际开始/结束及Result保存完成的同源UTC/单调读数与持久化关联、唯一单调/UTC展示截止、累计已用/实际剩余及计算。还须列明已经完成/未完成内容、网络次数、控制及所有拥有进程的真实退出/输出收束、原始日志/产物/输入身份、交接采样与等待边界；这不是只交一个“剩余N秒”摘要，也不新增Result顶层字段、收据或独立工具Result。P-n源码/聚焦结果及其gate仍按自身完整证据判定，不能预先认领新生产加载、完整oracle或hit。

**P-v6先验原钟，再决定是否开始运行。** 首先读取完整P-n Result中的原始计时记录并核对本次范围标识，取得自己的原始UTC/同源单调读数，核对相同时钟域/宿主启动实例/频率及可比性依据，再由原始 `M0` 和不变 `D` 计算包含交接等待在内的实际 `E/R`；不能只减P-n交付时的“余量”、另从零计时、只据墙钟推测或重建起点。当前源码/输入/加载身份、缓存和完整内容验证仅在该计时核对可判后开始。P-v6 Result继续保留同一原始双时钟/来源/截止、自身开始与最终保存完成读数、全链实际用时/剩余、全部失败/退出/取证限制；保存耗时与交接等待均不能遗漏。

**余量与停止条件。** 每次启动/继续工作及设置工具timeout之前，按实际同源读数估算全部剩余必需工作，包括可能尚未完成的P-n尾部与交接、P-v6前置核查/新加载、真实miss/rebuild、全部oracle、same-path hit、再次完整oracle及证据处理；记录估算依据和独立保存余量 `S > 0`。必须满足 `R ≥ 全部剩余工作估算 + 至少60秒收束 + S`，工具timeout不得侵占该两份余量；不能只估下一条命令或只给60秒而不另留保存时间。旧1466.68秒既未覆盖新增编译/rebuild/交接，也不是充分余量证明。剩余工作/保存耗时无法可靠估算即余量不可判，不按乐观假设启动。

若原始起点缺失、来源/宿主不可比较、预算/控制或退出状态unknown、冲突/身份/真实内容不符、余量不足或到限，停止P-v6及新增运行，按既有安全停止边界保全已完成结果和真实失败/unknown；不恢复生产执行、不延长/补时/分批、不降低完整验收。尽早用预留时间收束和独立保存；若仍出现截止后保存，必须如实标明越时，不能把它计作截止内完成或释放受影响gate。P-n已完成且足证据的独立源码结果可保留供审查，P-v6未满足不抹除它，也不因它完成而放行完整P消费者；没有合法起点/计时证据的结果不能冒称符合本候选。

**确认与尚缺证据。** 独立局部复审尚未执行，作者自检不作ready判断；新具体实施范围及上述起点变更尚未由用户再确认。实际时钟提供者/共同原点/宿主启动身份/跨进程连续可比证据、原始双时钟记录、全链可完成性估算、P-n源码与聚焦Result、P-v6新加载/miss-rebuild/两次完整oracle/same-path hit/截止内保存均未取得。当前只提供可复审候选；任何未来预算或分批政策改变还需单独披露取得决定，不能由本提案或后继Handler自行接受。

#### P-v5 独立reference语义恢复与作者自检

**一个结果与权限。** 按[Context](context.md#p-v4-内容失败采用与reference根因)保留P-v4 g1 failed：normalize/AT exit0但fresh oracle exit1、4782中4457/325（324游戏类4875成员操作数差异与1个BlockFluidBase）、无hit/新加载闭合，双时钟1123.852秒含保存/余676.148秒及全部纠错/观察局限。不续旧钟或回填旧item/完整合同/gate；两partial、更早failed/unknown、T-basic-v3 completed/已释放gate不变。新P-v5只取未完完整P；两处reference修正、样本/负例和薄接线无独立产品、成功消费者、Handler/Result或gate。任一修正/样本通过但全量oracle/hit缺失仍未完成；分组依据是一个完整验证谓词，不是同文件/同build根。

用户已确认拟恢复语义，**本次仅四文档维护及作者自检，无实施权限**。仍须不同Handler独立局部review，再Router披露具体实施变化并取得确认。未来才可在一个全新build根内复制必要薄工具/安排新阶段目录及正常输出；生产两个owner/version9、公共fixture/helper/test/参考producer、依赖/权威/旧证据只读。不能用本临时reference建立公共产品/通用框架。实际authority冲突、缺原fresh-miss或需要改公共工程才能闭合时报告具体缺口，不扩写界。

**游戏reference：稀疏payload与独立声明分离。** 用[独立清单](../../../minecraft-codev-forge/build/forge-patch-basic-8671257575882094287/basicNotch/reference/evidence/files.tsv)的patch-obf、merge-clean、原joined.tsrg、patch删除记录及libraries/所选Java8原声明。游戏声明patch优先于clean-minus-deleted（原5个deleted不能复活）；按真实需要补独立universal/库/JDK，启动资源优先、不取tool shaded声明，保存每节点producer/entry/hash/parents/优先级。根含**全部游戏patched class及其常量池member owners**，再递归super/interfaces，不是只取1434 overlay类的2200根。成员按原owner/name/descriptor沿原声明查固定映射，缺声明/来源歧义即错，不能静默保留原成员名。旧overlay的2448节点/2447父记录是保留覆盖的历史基线，不是扩大后游戏闭包固定总数；新游戏根/节点/父记录/来源重新清单登记，不删除旧覆盖或Object+bk要求凑数。

仅给原稀疏patch-obf rename payload外接声明表，不把clean类混进payload、不合成生产式完整G或复制生产补全算法。固定SpecialSource1.8.3/原Java8/原rename参数，新增增强mapping与target/SRG `--read-inheritance`（无live/reverse/生产classpath），新patched-rename→原3.7.3 mcinject（同exceptions/access/constructors及`--lvt=LVT`）→同版适用AT。具体入口是[原argv](../../../minecraft-codev-forge/build/forge-patch-basic-8671257575882094287/basicNotch/reference/evidence/argv.tsv)、[MCP配置](../../../minecraft-codev-forge/build/forge-patch-basic-8671257575882094287/basicNotch/reference/evidence/mcp-config.json)与[实际producer](../../../minecraft-codev-forge/integration-test/forge/patch-namespace/build.gradle.kts)，只在新根替换阶段input/output/log/声明输入，不调用或修改公共参考task、不重复patch/下载/cold。独立clean参考仍核验同输入身份并保留全部原比较；新根oracle副本显式接新patched与overlay参考。生产G/final/摘要仅能作actual，禁止用于声明/映射/命名选择或golden生成。

**增强mapping：原有效类型语义不变。** 从未增强原joined.tsrg按固定工具原规则计算闭包child/parent与锚点内嵌名的source→effective-target：显式class优先，未显式内嵌名沿原外部映射规则递归保留后缀，保存依据；不从旧identity表/生产输出求。保留原3344显式class和全部member行；**只有原有效目标确为自身才补identity**。无显式但有效非identity的节点须补原有效目标供inverse，例如 `awu$Builder net/minecraft/block/state/BlockStateContainer$Builder`，不得添awu$Builder identity。保留Object identity/空父终点。增强表全部target唯一/无碰撞、每child/parent inverse回原名及与原有效语义一致逐项断言；不能只删identity破坏inverse。reader仍为单空格target child+至少一个真实parent，禁止tab/空token/self-parent/child-only Object；inverse缺失/碰撞报错。游戏/overlay表可分别登记来源，均用此规则；不省原overlay闭包/typed检查，不硬套旧计数到游戏表。

**真实两样本先查，之后仍全量。** 期望先由原class声明/操作数和固定映射独立写出并保存来源，不从重写参考或生产hash反推；实际检查函数须消费真实样本及单变量负例：

- ItemPredicate原 `ey.d(Ljava/lang/Object;)Z` 沿ey→fh原声明解析为 `func_148741_d`。目标调用owner为 `net/minecraft/util/registry/RegistryNamespacedDefaultedByKey`、name为func_148741_d、descriptor仍`(Ljava/lang/Object;)Z`，以真实方法/语义指令位置定位，不锁重写后offset。记录patch/clean的fh声明/父边、原mapping成员行及rename/mcinject/AT阶段观察；旧错误参考中仍为d的真实样本应拒，单变量移去必需fh声明/父边须在闭包或成员解析拒，不退成identity。Registry类标签以原mapping为准，不沿用诊断摘要RegistrySimple误名。
- BlockFluidBase全部**5处**NEW/`<init>`/Builder.add相关type/owner/descriptor按raw universal＋awu外部映射独立期望 `net/minecraft/block/state/BlockStateContainer$Builder`；InnerClasses的inner同目标、outer为BlockStateContainer、simpleName=Builder，保留原flags/其它关系。逐处保存所属方法/语义位置/opcode/完整操作数及原/目标InnerClasses元组，不只扫无obf。旧awu$Builder identity真实错误参考应被同一锚点检查拒；单变量强identity、删所需派生target造成inverse缺失、target碰撞、只改指令不改InnerClasses也须拒。负例是实际检查函数对录制原料/内存扰动的预期拒绝，不把真实意外CLI失败称负例或继续改期望。

原IClientCommand的Object+bk/类型、完整11方法ICommandSender及ClientCommandHandler真实offset59继承锚点仍必需。之后比较**全部4782 class**（包括此前4457一致及325不同），完整entry/this_class、super/interfaces、字段/方法/descriptor、指令body/成员owner/name/引用/异常/InnerClasses等适用属性/AT、游戏clean/patch保持、patched/overlay优先；保留所有比较器断言、删除项/完整archive集合、25 universal与完整工具资源/manifest/marker/适用filters/inject。basic clean-only/inject真空集/collision空交集的完整清单/损失保留，1165/Neo实有义务不免。不能只测两类/325→0、改预期hash或删body/InnerClasses比较；新真实差异保全并停，不现场重定义预期。

**原完整P成功标准。** 按[原有界策略](#overlay-未完验证的有界恢复策略)重新闭合当前源码/实际加载classes/runtimeClasspath/fixture/输入/工具/JVM/排他、原fresh-miss（9,912,576 bytes及175ecc9d…69c8）及同轮阶段；完整日志预检/真实录制正负例、Object+bk完整父集正负例、目录首次/重复准备仍有证。新独立reference完整fresh oracle通过，7/8/9 operation/聚合key/basename/**完整有效path**隔离及两族静态使用有证，再让同输入同语义provider真实task action到达**原同path Cache hit**，cache与provider final分层记录，hit后再次完整oracle且与保留fresh语义一致。仅外层rerun/UP-TO-DATE、不同key/path、重新miss/搬cache、旧错误参考/跨身份拼接不完成；不重做cold/清缓存/改Core.Cache。只补basic完整P，Q两组实际内容/路径/冷热独立、Java8/Neo及M不等D/B/R不变，共享写运行串行。

**双时钟与停止不变，语义修正不冒充窄例外。** 方法（包括implement-plan）事前加载，一个全新1800秒自首相关检查前同步UTC/monotonic起点至最终保存，含语义修正、静态/LSP/离线正负例、工具纠错/同版复查、CLI/全量oracle/hit/postprocess/报告。不续P-v4余量/重置；至少60秒收束并另留充分保存余量，实际timeout扣余量、下一网络至少180秒且能容纳后续oracle/保存，最多3次且仅临时网络/前次正向退出/分存/排他才再试。两处语义修正是P-v5事先明确范围，**不是**旧P-v4工具编写/静态类型窄例外，不追改failed/旧停止合同。该窄例外仅允许可证新根工具自身错误同预算最小纠正/同版复查，保留错误/分类/来源/改动/时间/退出；不默认字段/吞诊断/删断言/skip/改raw输入或oracle预期。真实内容/字段不符、身份不明、冲突、下游工具非网络失败、退出unknown/到限仍停；余量不足不启调用，越时不计通过，全部历史时间/证据覆盖局限保留。

**独立局部复审及待披露边界。** 仅审本次P-v4失败/原比较/根因采用、游戏全patched/member-owner声明闭包与稀疏payload分离、新根rename→mcinject→AT及oracle输入重接、原有效内嵌mapping/target唯一inverse/reader、两样本与负例/完整oracle-hit不减，及P-v5单item/Handler/Result/单成员Wave/gate、8个必要消费者、final第1/10款、联合等待/共享排他/历史保留。未变三族reuse、version9生产/原fresh-miss、预检/录制/父集/目录及其它分支只核对必要连接，不全盘重开；旧ready不覆盖新差异。Router具体披露应说明：仅未来新build根写薄工具/阶段输出、不改公共producer；两处语义算法与先样本后全量次序；错误旧预期不再作golden但完整断言不减；完整身份/同path hit仍欠；新双时钟及旧窄例外不扩大；原导航缺口/风险。独立局部review后仍须取得具体实施确认，本次不发起review/调度或选择后继。

**本次实际作者自检（仅文档/内存，不是独立review或验证执行）。**

- 范围/成功标准：逐项核对本节与新item、单成员Wave/gate及现行连接；两reference/两样本均无独立终态或消费者，gate要求本item全部谓词和独立完整Result。原4782/body/继承/AT/游戏/资源/优先级及身份/原fresh-miss/7-8-9完整路径/真实同path hit/再次oracle不减，样本/工具成功不能提前完成。未变权威三族reuse/skip，不写PRD/ADR/Spec。
- 唯一图检查：在内存解析item段落、前置首句和5列表格，检查引用存在、成员非空、每item唯一Wave、每Wave唯一gate、gate等待目标可解析。合并item→显式前置item及所属Wave、Wave→等待gate、gate→全部成员后DFS检测：**34 item＋29 Wave＋29 gate＝92节点、159条去重边，无环**（原33/28/28、89节点/155边）。新增恰好一个item/单成员Wave/gate及4条联合边；8个完整P消费者不再成功等待P-v4。新P-v5只等已采用T-basic-v3/其gate；D/B/M祖先无Neo/Java21、R或旧failed/partial，M保留Q-1165而不等D/B；V/H仍真正汇合Neo/R与完整D/B/M。共享冲突单独检查为串行排他，未伪造成这些成功依赖。
- 历史/局部性：内存逐块比较确认**24个未涉及item body逐字保留**，8个消费者仅替换当前P-v/gate前置身份；P-v4新增failed采用标记但原完整body保留，原全部28 Wave的成员/gate身份不变，24行原Wave逐字保留，另外4行只更新必要消费gate。最终完整gate第2–9款逐字保留，第1/10款只纳入当前P-v5/新增完整策略及P-v4失败史。Work原采用结果表18条item行逐字保留、补P-v4 failed一行；Context旧采用段及Plan旧P-v4作者记录原文保留。T-basic-v3完成/已释放gate、两partial及全部旧failed/unknown/不满足gate不回填。
- 来源/导航：实际解析原all-class-comparisons.json得4782/4457/325（324 patched＋1 overlay），只读原report/budget/mapping/薄工具/公共producer及参数清单用于来源核对，未新跑工具。对本次涉及的59个相对Markdown引用检查16个仓内目标可读、41个标题fragment存在；诊断外部Result路径未写入四文档，也未经Context建立依赖。旧导航缺失的锚点观察文件只记具体缺口，不造证据/不能证明新reference或原4875解析已由本作者重跑。
- 写入/限制：只用定点替换维护四协调文档，写后回读与内存预期逐字核对，未编辑区域由替换范围约束保留；未运行Gradle/Java/项目测试/LSP/网络/Git/进程操作或清缓存，未建build工具/产物。此自检不是ready、实施确认、局部独立复审通过、实际item完成或gate释放。

未检查/未执行：原始class/归档重解析与hash重算、固定工具真实重放、当前加载/排他/新完整oracle和hit；4875成员根因按Handoff采用而非本次动态复验。
剩余限制：旧导航的实际锚点观察文件缺失、全部原证据覆盖局限保留；是否能在新1800秒内闭合尚无运行证明，任何写界/authority或原fresh-miss缺口只能报告。

#### P-v4 同预算工具纠错恢复与作者自检

**历史准备/作者自检：P-v4现已generation1 failed；本节原合同与当时检查原文保留，现行恢复只由上节P-v5拥有。**

本次只维护四协调文档并作者自检；沿用Work的PRD/ADR/Spec reuse评估及用户本轮明确确认，不写权威/生产/脚本，不执行验证。P-v3 generation1 failed及 [失败事实/确认范围](context.md#p-v3-静态失败采用与同预算纠错边界) 完整保留；setup exit0和生成薄工具不等于预检/录制/身份/内容通过，463.814秒UTC保存/monotonic起点缺失/implement-plan晚读/未做全仓漂移检测不消失。原两partial/P-v/P-v2 failed和全部旧gate不满足、T-basic-v3 completed/已释放gate不改判。

**一个完整结果。** 新P-v4仍仅补独立完整class/body/继承/AT/游戏/优先级/资源oracle与同输入同语义同完整有效path真实hit及再次完整oracle；新根薄工具纠错/复查只证明该谓词，没有工具产品、独立终态/消费者/Result或通用重试框架。唯一定义/成员/前置/新gate及Q/R/D/B/M/V/H必要连接由 [Waves](waves.md#overlay-未完验证的现行连接) 拥有。两个生产owner/current version9、原fresh/miss及旧证据只读，不重做cold；加载身份、原始Object+bk完整父集/负例/目录行为、共享日志预检及真实录制正负例、独立reference完整oracle、7/8/9隔离和同路径真实hit均沿用原完整策略，不以工具通过代最终通过。

**仅本新批次的窄例外。** 可证属于新根薄工具自身的编写/静态类型错误，可在同一预算内最小纠正并复查；先保留实际错误和真实字段/类型/来源依据，再记录改动及同版针对性静态/LSP/离线复查、时间/退出和未完边界。不预先宣称已修或已复查。对size/bytes只能依据实际可读记录验证必需字段存在、值/类型合法后适配/缩窄；不得默认size、吞诊断、删断言/skip、改oracle预期或输入凑通过。真实字段缺失/内容不符、身份不明、运行冲突、下游reference/Java/Gradle工具的实际非网络CLI失败或退出unknown不是此例外；无法证明只是工具错误即停。复查错误不改成功，只有仍明确落在此窄例外且剩余预算足够才继续最小纠错，不能把它泛化为非网络失败重试。

**新预算/方法顺序。** 全部必需方法（包括implement-plan）在项目检查/实施前加载完成；首个相关检查前同步记录UTC和monotonic起点及同一1800秒deadline。相关静态分析/LSP、录制/父集/目录/离线检查、薄工具纠错与复查、CLI/完整oracle/hit/postprocess/报告最终保存全部计入；不续P-v3余量、不从静态通过或Gradle重新计时、不因纠错重启。真实工具timeout只取剩余减至少60秒收束并另留充分保存余量；下一网络调用至少180秒且容纳后续oracle/保存，最多3次、仅临时网络/前次正向退出/分存/当前排他才再试。非网络停止仅有上述新根工具错误例外，真实产物/字段/身份/排他/退出unknown及到限仍立即停；余量不足不启新调用，使用预留在deadline前收束保存，意外晚到如实记越时而不计成功。

**受影响的独立局部复审范围。** 四文档本次P-v3失败/时间与流程偏差采用、用户确认的工具错误与真实失败分类、同预算纠错/同版复查及不允许规避的证据边界、方法事前加载与双时钟起点/完整保存余量；P-v4的单item/Handler/Result/单成员Wave/gate、Q-1165/Q-Neo/R/D/B/M/V/H必要连接、联合等待/共享冲突与旧合同/gate保留，final第1/10款及Java8/Neo独立性。review-forge-idle-validation-recovery generation1 completed/ready对未变预检/录制、字段/加载导航、完整oracle/hit及原图支持沿用；只审新差异和必要连接，不无据重开权威、version9生产、原fresh/miss、整套旧历史或未变完整验收。本次不实施独立review，不调度或宣称新规则ready；受影响实施前仍需不同Handler只读局部复审，作者自检和用户确认不能替代它。

**本次实际作者自检（纯文档，不是项目验证）。** 三个选定Skills及其所需委派合同在项目编辑前已加载；四文档与指定旧根报告/预算/诊断记录按确切路径只读读取。以编辑前内存原文为基线，写后从四个实际路径完整回读并逐字匹配预期改动，再对文档文本在工具沙箱内解析/断言：

- 33个唯一item、28个非空Wave、28个gate，联合item→前置item/所属Wave、Wave→前置gate、gate→全部成员共89节点/155条去重边，引用/单一归属齐全、无环/自等。新增仅P-v4及单成员Wave/gate；8个必要消费者的item/适用Wave等待均接新身份，新P-v4/D/B/M不等旧P/P-recovery/P-v/P-v2/P-v3或旧failed gate转成功。D/B/M祖先不含T-Neo/Q-Neo/R，M保留Q-1165且不依D/B；V/H仍合取Neo/R/完整D/B/M。排他条款逐项阅读，仍是共享输入/Forge/helper/fixture/Gradle/TestKit/build/cache写运行串行，不偷换业务依赖。
- 单结果与验收逐条核对：工具编写/类型错误纠正、同版针对性复查、真实录制/父集/目录检查无独立消费者，只服务完整oracle/hit；实际字段/身份/产物/冲突/退出unknown/到限仍停，不允许默认size、忽略诊断、删断言/skip或改输入及预期。当前Work、Context、Plan策略/selector、Waves item/gate/final第10款的事前方法、双时钟首检查、1800秒全活动、60秒以上收束/另留保存余量及有限网络/前台退出逐处一致；旧P-v3一切非网络即停已明确限其历史时点，未改原合同。
- 保留性断言：Work原采用表20行、Context自P-v2段至末全部旧正文、Plan原历次作者记录、23个其它未受影响原item正文和23个未改旧Wave/gate行一致；P-v3仅新增failed/时点说明，其原完整合同及原gate行原样保留。最终gate第2–9款逐字相同，T-basic-v3 completed/已释放gate、全部partial/failed/blocked/unknown和旧gate不满足不改判。
- 本次改动文本中46处本地链接、8个不同目标、41处标题片段经实际回读/标题核对；目标是本次已读三份协调文档及五份仓内原证据，不含虚构新根/新Result或项目外Result依赖。此计数只覆盖本次改动涉及的引用，不认证全部旧链接或全仓漂移；最终保存后继续以同一范围回读确认，不把编辑器Markdown提示当独立review或运行结果。

未实施/未检查：没有修或执行薄工具，没有Gradle/Java/测试/LSP/网络/Git/进程操作/清缓存/安装，也未重验动态加载身份、录制函数、reference/oracle/hit或全仓漂移。
剩余风险：当前只有文档维护完成；新规则/连接尚无不同Handler局部独立复审结果，P-v4无完整运行证据、未完成/未释放gate，历史Dist/输出竞争排除/覆盖盲区不关闭。

#### P-v3 最小预检恢复与作者自检

**历史：P-v3已generation1 failed；以下是执行前策略/作者检查，原完整合同及当时非网络即停不变，不再描述当前未执行身份。** 本轮P-v4只用上节明确例外，不回填旧失败或原gate。

本轮只有四协调文档局部维护一个结果。P-v3 的完整终态、唯一 item/Wave/gate及必要消费者只由配对 [Waves](waves.md#overlay-未完验证的现行连接) 定义；下述是策略和作者证据，不另建执行图。P-v/P-v2 failed、两partial、旧gate原合同/不满足、T-basic-v3 completed/已释放gate和全部历史保持。新gate只在新唯一完整Result completed/足证据且采用后可判，不自动满足旧gate。

**唯一最小变化。** 依[诊断加工与录制定位](context.md#p-v2-尾窗误拒与恢复依据)，未来仅在新build根复制薄工具，于共享 exclusive() 的完整已读日志上先比较最后明确busy/build-start与 Marking the daemon as idle，再取尾窗展示。只纠正报告裁剪误入状态判定；不改固定窗口上限、不单用sleep/健康检查/无worker替idle、不减身份/退出/当前排他要求。start/prehot/final共用修正，真busy/缺状态/身份不明/退出unknown仍停。实际判定函数消费可定位原录制前缀正例、分别追加后发busy/build-start负例、原保存尾窗unknown负例；原料不可得/匹配失败报告缺口不造样本。此纠正及录制检查无独立可消费终态，只服务未完完整验证，与原父集/目录核对同为内部步骤，不另立工具产品或写公共fixture/helper/test。

**预算与原完整策略。** 全新独立1800秒，从首个实际相关检查前记录UTC/单调时钟及deadline，包括编辑器/LSP静态分析、录制检查、离线/CLI/编译、reference/oracle/hit/postprocess/报告和最终保存；不待Gradle才计时、不续P-v2余量。原至少60秒收束/充分保存余量、真实timeout扣余量、下次网络至少180秒并容纳后续检查、最多3次正常有限网络运行/正向退出/分存/排他/纯临时网络才能再试、非网络或unknown立即停止均不变。旧计时前LSP和越时历史保留。原完整实际加载/输入/fresh-miss身份、原始Object+bk父集合与目录检查、独立reference/完整class-body-继承-AT-资源/优先级及两锚点oracle、7/8/9隔离、同有效路径真实hit及再次完整oracle逐项要求不变。不得重做cold/生产version9、假造fresh或以工具检查代内容通过。

**必要连接及局部独立复审边界。** 仅本次P-v2 failed/诊断采用及日志可读定位、共享最小预检/实际函数录制检查、首相关检查即计时的新预算覆盖，和P-v3单item/Handler/Result/单成员Wave/gate对Q-1165/Q-Neo/R/D/B/M/V/H必要完整P连接与历史保留。Neo/R不前移到Java8，D/B不阻M，R仍只作V/H质量门槛；共享写运行排他不是新业务依赖。前次ready对原字段/加载导航及未变完整策略沿用，不全盘重开权威/既定方案；作者自检不是独立复审/实施确认/实际item完成或gate释放，本轮不发起复审。

**作者实际检查。** 已事前加载三个选定Skills，逐段完整读取四文档、指定失败报告/failure和完整诊断Result，读取实际run.py关键函数，并只读核对原日志与片段精确匹配/状态索引；未执行该函数或录制检查。新增一个恢复终态，内部薄工具/录制/父集/目录检查无独立消费者。当前字段/链接、唯一成员及联合item/Wave/gate无环、必要消费者/冲突、原完整合同与历史正文的针对性内存检查见本次Result；未将未来检查写为已通过。

未实施/未检查：工具纠正、录制参数化检查、动态身份/reference/oracle/hit、进程排他采样；完整动态证据仍缺，不宣称ready或释放任何gate。

#### overlay 未完验证的有界恢复策略

**唯一结果与边界。** P-v 只对 P-recovery partial 未完的完整独立内容 oracle＋same-path hit取得可消费完整P证据；工具纠正/输出目录安排/离线检查是同一验证内部步骤，不是工具产品/框架/阶段或独立 Result。不重写已完成 live overlay、内部继承交接、补全/去late-copy、版本9或自有cache输入。未来只写一个全新 build 证据根内必要薄工具和正常运行输出，不改生产/公共fixture/helper/test/consumer/API/依赖/非notch/Neo、原脚本或旧证据。若发现实现缺陷/必须重建缺失fresh身份或需要越界写入，报告具体缺口而停，不借补证许可重做生产。

**开始即冻结实际身份和排他。** 先确认没有共享 Forge/Gradle/TestKit/build/cache/fixture/输入写运行；历史退出/idle不是当前锁，执行期间保持串行。只对本验证相关输入作摘要/路径核验，不增加缓存逐项审计。按 [已核实原证据定位/字段](context.md#p-v-失败采用与原证据定位纠正)，用原 completion-evidence 的 sources[]/compiledClasses[]/freshFinal/frozenFreshFinal/cache/prepareInputIdentities/referenceInputIdentities/rounds[]、第二轮stdout/XML、files.tsv、实际 gradle-jvm.tsv/tool-jvm.tsv 和原 arguments.txt 的 fixtureClasspath 及 provider/cache 日志核对（清单没有 before/after 或 implementations 字段）：两个owner当前SHA256/版本9；实际加载的插件classes/runtimeClasspath（防源码相同但编译输出过期）；fixture/build脚本/方法/参数；固定userdev/MCP/binpatch/clean/mapping/universal/libraries/工具及JVM字节身份、内容确定的classpath顺序与适用AT/过滤/资源输入；运行时缓存根、metadata目录、operation/聚合key/输出basename及绝对有效路径。原fresh/miss最终字节须仍为9,912,576 bytes及 `175ecc9d748dc8d3acd2033c5807d247b76eaf4b929be97ee1c2be26d13e69c8`，原patch/rename/G及独立reference原料对应同轮同输入。实际补录Core.Cache现行算法下7/8/9语义operation、聚合key、basename及完整path的只读推导/比较，证明版本9隔离已知不完整8/历史7并静态核对Forge/Neo使用，不声称旧错缓存实物动态拒绝。原记录未载明的细项可从其可读原始清单/日志补出，但不能臆测；缺失、漂移、退出unknown/冲突不能归属即不复用/不完成，不能改输入凑身份。新证据记录旧来源及新核验UTC/摘要，一一闭合，不只引用一句“版本9未变”。旧未通过reference输出不能直接认证。

**在新根纠正并离线核对。** 新复制/必要调整薄工具固定引用已核验输入，不执行旧硬编码根脚本或覆盖原证据；在解析raw class阶段，断言 IClientCommand 的完整原始 `super=java/lang/Object`、`interfaces={bk}`，并精确比较合并父集合 `{java/lang/Object,bk}`，非忽略Object/所有parents。保留原overlay的2448声明/2447有父记录历史覆盖基线（现行P-v5另按上节扩展游戏patched roots/member owners并登记新闭包，不硬套原计数）、唯一无父Object为终点且不输出行、每行child+至少一个parent/禁止self-parent、target→source inverse失败即错，缺失/额外/错误父均拒绝；允许多父仅来自真实class。离线用这个真实原始输入正例，以及缺Object/缺bk/额外parent/错误mapping inverse的单变量负例消费同一实际预检函数。`oracle-classes`、编译输出/reference及postprocess目录只在新根按步骤各用新空目录，明确谁创建谁消费；同一路径再次准备须安全拒绝或复用已核验同身份产物，不能因第二次mkdir(exist_ok=False)中止、递归删旧目录或忽略工具失败。离线检查同一实际路径准备函数的首次/重复行为，所有输出仍在新根，非另建通用runner。

**独立reference→完整内容，不自证。** 从已核验raw universal＋独立patch-obf/clean-minus-deleted＋libraries/Java8原始声明重建原独立reference：固定SpecialSource1.8.3原rename参数＋增强identity映射/完整target继承表，经 `--read-inheritance` inverse还原；不用 `--live`、生产G/生产classpath/helper或旧未通过oracle作golden。保存新producer脚本/输入/声明/边/增强mapping/继承表、命令/JVM/退出/输出摘要及inverse核对。两锚点仍独立：IClientCommand保持Forge名、bk→ICommand/bn→ICommandSender；ClientCommandHandler原bj/offset59 Forge-owner.b()Ljava/util/Map;依固定mapping和原声明期望CommandHandler/func_71555_a，不从输出反推。用独立参考和生产final逐class核对entry=this_class、super/interfaces/字段/方法/descriptor/指令body与成员owner/name/引用/异常等完整语义及适用AT；游戏clean/patch参考、11方法完整接口/游戏类保持、patched/overlay优先、25资源/filters及适用inject/marker等原完整项目全部逐项给证，basic真空集/collision空交集的适用性损失保留。只raw-universal+AT相等、792→0、Jar可开、基本1/0/0/0或旧8CLI不完成本oracle。 现行P-v5的游戏继承闭包、有效内嵌类mapping/target/inverse修正及ItemPredicate/BlockFluidBase真实正负例以[本次新增策略](#p-v5-独立reference语义恢复与作者自检)为准；本段原完整验收不减。

**原fresh/miss与新hit的排他关联。** 原第二轮已证新语义首次不存在→`forge-patch-9/17070801`真实miss/rebuild，只在上述身份、独立oracle及原完整operation/key/basename/path证据全部闭合后作为本结果的保留输入；本次不把新key已存在说成新cold miss。用新根私有project/输出/日志及已核验相同插件/任务配置，沿用原metadata/Resolve缓存根和实际 `-Pfixture.cache` 等有效值；只迁移证据路径/不影响行为的工程位置，须实查路径构造未因此改变有效key，不能沿用旧prepare_hot中未执行的假定或搬缓存制造hit。让真实 patched provider task action 再次进入同一自有Cache lookup（外层 `--rerun-tasks` 仅用于到达action，不等于hit），记录前台terminal/真实退出、实际Cache hit、完整有效path、输入/operation/key/basename、前后cache及新provider final摘要。hit最终output须完整oracle再次通过、内容与保留fresh结果一致；中间cache与final分层记录，不把二者错误要求同hash。若命中不同key/path、miss/rebuild、只有UP-TO-DATE/外层缓存、输入/实现漂移或任何内容不符，same-path hit不成立，非网络停止。不得清缓存、拷cache/旧Jar伪造基线或切到另一旧成功；缺原fresh/miss证据则报告本结果不满足，不静默削弱/重定义合同。

**一个新时钟与有限运行。** 全部必需方法事前加载，首个相关检查前同步记录UTC/monotonic起点与1800秒deadline；首检查包括静态分析/LSP、录制及离线原料解析/路径检查/编译、reference/内容CLI等，不能等到静态通过或Gradle才开始计时。目录/工具的必要准备在同一结果内，所有相关静态/LSP/离线检查、合法薄工具纠错与复查、CLI/验证、hit、postprocess、报告和最终落盘活动必须在同一预算，至少留60秒收束并另留足够报告保存余量；每次实际工具timeout不超过剩余减保留余量，下一次网络运行至少180秒余量并先估算可完成后续oracle/保存。相关调用用真实前台terminal、原argv/工具JVM、UTC/耗时/真实退出记录；terminal_wait只是观察原调用，不启动第二份。最多3次真实网络运行（包含hit尝试），只在明确临时网络、无并存非网络错误、前次及拥有进程正向退出/输出收束/证据分存/当前排他/预算足够时再试，不重放已经有效的生产改动/fresh来凑次数；当前P-v5仍仅按[同预算窄例外](#p-v4-同预算工具纠错恢复与作者自检)纠正可证的新根薄工具编写/静态类型错误并复查，保留失败、不重置时钟；其余离线或下游工具CLI非网络失败、真实缺字段/内容不符、运行冲突、身份/退出unknown、到限立即停止，不能将实际内容/输入问题统称工具错误。无需端点预探测、全缓存审计或新停止框架。执行余量不足即停止新调用，使用预留收束/保存时间在deadline前保全未完；不得deadline后继续CLI/postprocess再称合法成功，意外晚到输出原样记录越时并不计通过。 两处明确reference语义修正仅由P-v5事先范围授权，不归入此窄例外；本次文档维护没有实施权限。

**完成与消费者。** 原P和P-recovery的partial/原谓词/未满足gate永久保留；新Result需可复查地将当前源码/加载实现/输入、原fresh/miss、全新独立reference/完整oracle、同有效路径真实hit及hit后完整oracle唯一关联，才可给Q/R/D/B/M/V/H消费完整P。本次只规划/静态自检，无动态通过或gate释放。既有合同要求fresh→内容→同输入同语义同路径hit，不要求同Handler；上述保留输入没有豁免任何环节，也不允许跨身份拼接。若实际记录不能支持这个关联则报告具体矛盾/缺证，不降低完整P。Q两组本组完整内容/路径/冷热另证，R仍仅V/H质量门槛；不把Neo/R加到Java8前置或D/B加到M。材料性维护的精确独立复审边界见作者自检，本次不发起/调度。

#### 关联分支验证 Q 的独立完成证据

Q-1165/Q-Neo 各自有一个可独立成功/失败、保留、消费和恢复的验证结果，原完整成功输入为本组 T 和同版 P-v，不等对方或 D/B/M。Q-Neo 本次另消费已独立交付的最小接线源码，按 [当前安排](#q-neo-最小接线策略与作者自检)先验 T 原完整内容/冷段适用性、再一次原完整缓存路径真实 hit 并全验；不是重跑 T 或在 Q 内补源码。执行本组真实 provider、独立参考/见证并写新证据/私有运行输出；Q-1165 原安排不变，不在运行项另改生产/测试/配置或补通用工具框架。

- **Q-1165：** 固定 forge1165Mcinject raw SRG patch/适用 mcinject 不重复 rename；完整最终 patched/未补丁接口、entry/this_class/descriptor/reference/优先级/资源/overlay/AT 对照独立参考成立，本组实际 forge 完整 operation/key/basename/path 与旧语义隔离及本组 miss→真实 rebuild→同输入同版 hit/内容闭合。M 消费这一真实 non-notch 结果，原 srg→named/Java8 consumer 链仍独立另证。
- **Q-Neo：** 固定 neo121NoMcinject official/无 mcinject 的同类完整内容/适用 AT、neoforge 实际有效完整路径隔离/冷热缓存，以及已收窄的新鲜 Dist 主属性/marker、universal/资源及有限原始资源成员关系均有证。缺21准确 blocked/failed，不能由 P-v 静态 neoforge 版本使用或 Forge 运行代证。

每组保存源码/fixture/输入身份、独立参考/见证推导、实际命令/JVM/退出/日志/新鲜产物、路径隔离和冷→热对应。P-v＋Q-1165＋Q-Neo 才覆盖三组/两族实际路径和全部缓存，R/V/H 必须全部消费。无旧实物仍不证明旧错 key 在场动态拒绝/替换、旧 final 重放、NeoForge 完整旧 attrs 等价/全 class side 正确，不恢复备份或删必需验证。

#### 独立针对性回归 R 的最小矩阵

**原完整R合同保留，尚未完成；本轮已取消新增/运行此矩阵，不再派发。** 下列未来selector及四方法不因精简而成为现存或已通过；当前只复用适用既有证据，并由[V-compat单次联合运行](#一个联合运行成果)保留尚缺兼容观察，不回填原R/gate。

R 在三组准备（T-basic-v3/T-1165/T-Neo）、P-v/Q-1165/Q-Neo 完整结果后拟新增同包 ForgePatchNamespaceTests.kt，并复用真实私有 Gradle/TestKit 工程/helper/provider/cache 控制，不再假设“只生成小 Jar/映射”就能触达合法 binary patch。R 可在该专用 fixture 内补齐下列输入/断言和必要私有接点，不写公共测试开口、生产 API、两个原 consumer/runner 或通用 fixture 框架。新增完整类 selector 明确为未来目标 `:minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceTests'`；下列准确方法过滤串也均**待创建**，实施 Result 必须给出实际源码/方法/参数/执行 XML 身份，未实现或没命中不能报通过。R 的 completed 意味真实生产回归执行成功，不是测试已编译或写了矩阵。

1. `--tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceTests.notchPatchPreservesUnpatchedInterfacesAndPatchedPriority'`：使用 T 固定真实 userdev3/binpatch/MCP/clean，按独立 patch 记录/引用清单选 patched 引用方与无 patch 接口（包含已诊断 ICommandSender 关联，不虚构 A/I）。新鲜最终产物与独立工具/映射参考比较 entry/this_class/descriptor/reference、接口定义、目标 namespace 及无混淆重复。原 failed 只作历史问题来源；不要求旧 final 展示失败，不把新通过宣称成旧实物反例已重放。
2. 原始 A 与 patched A 有可区分的字节/行为，补全和 rename 后必须仍选 patched A；同时未补丁接口、实际补丁输入阶段与合法后续工具/overlay 中应保留的其它类/资源齐全（应用本 Plan 固定 basic 适用性及损失，不恢复 raw 资源），不靠“成功打开 Jar”或仅无报错断言。
3. `--tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceTests.patchCacheRebuildsWithNewOperationAndReusesCurrentOutput'`：展开 `basicNotch` / `forge1165Mcinject` / `neo121NoMcinject`，固定真实 patches/output basename，记录旧源码版本值→新有效 operation/key/path 的隔离，不加载旧缓存/旧 JAR。每组在隔离空缓存或已证新 key 不在的安全私有缓存中取得 Cache miss→工具生成/最终内容→同版 Cache hit，命中输出逐类/资源符合 oracle 且与新生成内容相同；保存日志/路径/摘要/task action 到达与方法/参数/XML。外层重跑只触发 action，不能代作自有失效；不删全局缓存、不变输入来伪造 miss，不用首次 miss 单独证明语义版本隔离。此方法不再声称证明历史旧错 key 的动态拒绝。
4. 关联矩阵仍拟用 `--tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceTests.nonNotchPatchPreservesExistingContract'`，参数 `forge1165Mcinject` / `neo121NoMcinject`，以及 `--tests 'net.msrandom.minecraftcodev.forge.ForgePatchNamespaceTests.neoForgePatchPreservesExistingContract'` 仅参数 `neo121NoMcinject`。方法名保留，但成功含义收窄为本节明确的新鲜内容合同，不等于旧实物等价。消费 T 固定来源/同版官方参考/具体见证；前者证明 SRG＋mcinject 不重复 rename、official 无 mcinject 的真实补全/优先/资源/适用 AT，后者检查新 final 的 universal/Dist/marker 和原始资源有限独立成员关系。无 P-v 前旧关联输出/完整旧 attrs 比较；不复制生产算法或扩大 side 修复。三参数逐项关联 producer/output/oracle，缺输入/见证/实际执行或必需 skip 不 completed，JDK 缺失单列 blocked/failed 而非 skip。另跑现存 AT/JarJar 完整类，不代替矩阵；R 新类/T 入口及全部新增参数由 V 最终同版 fresh 重跑。

#### JDK 缺失的分支错误、继续与最终等待

- 各 T/P-v/Q/R/D/B/M/V 按实际方法/参数和 JVM 角色记录准确版本、要求来源（metadata/NeoForm java_target、consumer8、Test17）、现存选择入口、解析结果/异常、task/工具与未到达边界，unknown 明示。未能启动为 blocked，已实际调用失败为 failed；受影响 item/gate 不满足，不能 partial/skip/disabled/Assumptions 当成功或豁免最终验收。
- 仅21不可用且8/17充分时，T-Neo 报错、Q-Neo 等待；T-basic-v3、T-1165 依自身真实条件准备，P-v 在 T-basic-v3 足证后关联已完成共同修正并补全basic完整内容/冷热缓存证据，D→B 可推进；Q-1165 在 T-1165/P-v 足证后完成本组全内容/冷热缓存，M 可推进。这是依赖可达，不是已运行/成功；不能在配置/共用入口、P-v 证据、item 或所属 Wave gate 再加 Neo 成功/完整 fixture 类屏障。
- D 缺8使 B 等待，M 按自己的8需求判断；Q-1165 失败只使 M 和真正汇合后继等待，不取消 D/B；Q-Neo/R 缺21不取消具备自身前置的 D/B/M。各项独立 Result 必须完整证据，不能以另一成功参数补 partial；所有共享写/Gradle/TestKit/build/cache 仍串行排他，不表示并跑。
- R 仍全等三组 T/P-v/Q，V/H 仍合取全部三组、两族实际路径/缓存、完整矩阵/AT/JarJar、原 consumer/全部同版 fresh。缺 Neo 时 G-RECOVERY-INTEGRATION/G-ACCEPTANCE 不释放；P-v basic 成功不称共享实现全验证。
- 不增加 scheduler/恢复/委派机制；测试/Gradle fail-fast 或工具契约不能继续则保存失败/未执行集合与限制，不虚称已继续。Router 按真实契约判断具体执行，本次不调度。不安装 JDK/换版/改 runner/consumer/扩大支持，不改旧停止/预算合同。

#### patch 后 D 与完整 B/M 的边界

NORMAL-RETRY 只保留 failed 原 Result，不作为新路线必须转成功的前置。新增 RECOVER-BASIC-JAVA8-POSTPATCH 是独立 D：只在 P-v completed/足证据被采用后，消费既有 basic 接线从同一原 basic 方法以新目录/新首次调用预算取得完整同轮发现；复用已保留接线、正常重试 token/身份/观察工具，不重做工具/131项离线检查，不新设网络诊断或普通缓存审计。不修源码、两个 caller/consumer 用例、runner 或配置；工具只可在新目录更新本轮输入基线与证据路径，不改行为。最多3次/首次实际调用起单一1800秒、60秒收束/再试180秒余量及正向退出/排他/分存规则保留；实际异常链明确临时网络且无并存非网络错误才再试。再次 compileJava/namespace/控制器/身份错误即停，不续旧 batch。

D 仍必须某一次 invocation 的 Provider关联（无直接对象帧限制明示）→Test→唯一同名-D→nested System/StartParameter两map/effective installations→现有 printCompileClasspath 实际 action 的 Java8 compiler executable 和 metadata languageVersion=8 及共享语义全部闭合，未到 action 就未完成，旧17条或另一轮不能补证。D 可能在原运行正常生成 Jar，但这不是 B；B 独立保存当前脚本实际 patchedMinecraft/compileJava/jar/printCompileClasspath、真实来源/namespace/provider、Java8 compiler 和 Test.class/Jar/classpath 全链。新生产修正前的偶然 Jar、旧类、单独候选或主版本52不能放行 B。

M 技术上消费 P-v 后生产实现、Q-1165 完整 non-notch 结果及自身原批准而未完成的旧 API 迁移，不等 R 或 basic D/B 成功；原 remapped 的来源、server=false、official→MCP LoadMappings、JavaExecutable、实际 srg→named RemapTask 和真实 Java8 EVENT_BUS/Entity.class consumer 全合同不减。当前旧 patches/mappings/minecraft.patched/remapped 脚本须在 M 内迁到现存 ResolvePatchedMinecraft/ResolveMinecraftMappings/LoadMappings/RemapTask，允许必要原脚本/取证接点修改，不再以“不能改脚本”阻断；原M无新增-D是历史限制；新恢复仅按末节计划追加同名-D，生产API、版本/依赖或consumer用例仍不扩权。B 消费 P-v/D，在原批准未完成 caller 边界可必要修正但不重做已完成效果/规避真实消费；D 仍只读既有脚本接线并运行取证。R 作为 V/H 必需质量门槛，不是 D/B/M 技术输入或隐形前置；本次约束已明确该区分，串行冲突另见 Waves。具体输入/namespace/provider/能力越界或观察缺证则保留失败/阻断，不能自动扩大范围。

### 正常网络重试策略

**历史准备，NORMAL-RETRY 已 failed。** 下列新 item/只等的描述只属当时，不再拥有后继连接；正常网络预算/安全原则可供新 D 复用，不能重开旧 batch 或豁免缺 ICommandSender 的非网络编译失败。

采用最新token partial及工具效果，不重复token/身份/观察实现或离线131项检查；旧报告、工具、hash及not-ready不改写。137项变化中131项只是旧工具unknown cache分类，不能推定损坏或要求逐项调查。已取消的DNS诊断无可用Result、不计completed；无需原因诊断、网络恢复证明、端点全成功或每次批准。

新RECOVER-BASIC-JAVA8-NORMAL-RETRY只有原发现D一个终态和独立Handler/Result，不并入完整basic产物B、remapped或最终验收。新目录只复用工具并可最小绕开旧retry过严分类，不扩展工具或新增通用分类引擎。按[Context当前判据](context.md#正常网络重试决定与当前判据)从原basic入口最多3次/首次调用起单一1800秒，串行、分轮保存日志/异常/退出/XML及预算，保留60秒收束和再试180秒余量。

允许正常Gradle bookkeeping/TestKit缓存/构建输出变化，不逐文件归属、不要求sideEffectsSafe新认证、不清缓存/根clean。DNS/连接超时按实际异常链/日志判断，普通UncheckedIOException包装不拒绝、无包装白名单；纯网络早败未到compiler/后续帧只表示发现未完，不把原完整observationsComplete/freshXml/debugger.finished合取恢复成再试门槛。实际观察工具故障、具体输入/旧证据损坏、身份/退出不明或明确并存非网络错误仍须停；前次本轮拥有launcher/worker/debugger/wrapper正向退出、输出/线程收束及即时排他核对不减，未知身份或daemon不误杀。不得用抽象“影响未知”把普通缓存全面审计加回。

成功仍须某一次原basic invocation的完整同轮Provider关联→Test→唯一同名-D→nested System/StartParameter两map/effective installations→现有printCompileClasspath action实际compiler executable及metadata=8、共享语义全部成立；Provider直接观察限制明示，不拼旧17条/其它轮。完整basic产物、remapped自己的观察、最终三模块fresh/Forge三类/根入口/全部当前案例/不同Handler验收保持原合同，不因正常网络重试而下降。必要后继和旧gate保留只见Waves，本次不放行或执行。

### 本地观测失败后的最小独立恢复策略

**历史准备，现已TOKEN-RECOVERY partial。** 下述最小token/身份/观察纠正及离线效果已经保留；旧副作用分类和完整观察retry合取只属该item历史，不再是正常重试的前置。当前以上节及Context正常判据为准。

上一RECOVER-BASIC-JAVA8-RECOVERY已generation 1 failed；唯一原调用11.737990秒/launcher exit1，JUnit全部unknown，无认领/attach/nested/compiler，未重试；成对ASCII39单引号executor token被裸token fullmatch拒识。原worker与5005监听在晚到历史检查中确认消失、daemon idle，但不恢复旧批次资格或替代未来启动前排他。上一地址失配failed的126.646381秒、127.419859/928.458591秒采样与801.038732秒差仍按[Context历史](context.md#有限发现失败与独立恢复依据)保存，不混成这次失败原因。最新失败、两轮45项不同hash及诊断限制见[Context](context.md#真实-token-失败与身份交接恢复依据)和[failed报告](../../../build/recover-basic-java8-recovery-evidence/report.md)；旧item/谓词/Wave/gate、所有partial/failed/blocked不改判、不续预算。

唯一新RECOVER-BASIC-JAVA8-TOKEN-RECOVERY只恢复未完成发现。新独立build证据目录复用已修好的5005/localhost:5005及观察控制逻辑，最小纠正完整裸executor或一组成对ASCII39包裹token识别，原始argv不改写，禁止任意strip/substring/宽松空白。保留时间界/cwd/完整worker/JDWP/唯一候选/监听PID全部限制；从快照到重新认领PID/create_time/cwd/原始完整argv必须相同，attach前再确认身份及监听归属，变化/消失/未知即拒绝，不接受替代进程。身份交接是静态合同缺口，不宣称原调用已发生PID复用。新工具仅内部支撑，无独立产品/发布/消费者/Result；出现真正独立结果就停止报告，不隐含扩大范围。

离线回归直接向实际纯候选实现输入未经预处理的真实worker-listener快照（processes/listeners）；旧实现零候选复现与修正后PID283784正例关联同份原始输入、相应工具版本/hash。原command UTC仅作有采样差说明的时间代理，started_epoch未单独保存，不以worker create_time推回自证。真实引号token、裸token及所有token/时间/cwd/worker/JDWP/零多候选/监听负例，分别扰动候选到重新认领PID/create_time/cwd/argv与attach前监听，拒绝路径不触达attach/kill/再试；身份/监听不变为正例。具体负例及旧地址/分段/EOF/超时/完整观察/收束/停止/缺compiler/旧XML/单deadline检查见[Context同节](context.md#真实-token-失败与身份交接恢复依据)和新item。只用录制输入/内存替身，不创建被测真实进程/attach/网络/终止，不新增真实停止专项调用。诊断模型未修文件，原45+45不同hash不是90项同版；新离线通过不证明真实进程创建、attach、完整停止链或发现成功。

实施顺序严格为：当前授权/输入与编辑资源排他核对 → 新目录内最小token/身份及副作用-retry判定纠正 → 同版实际候选/分类/eligible_retry的录制输入与内存替身回归 → 固定工具hash并更新本版基线 → 真实入口启动前当前排他/daemon/输入/旧证据/预算检查 → 新批次逐轮收束、分存、分类和再试判定。工具纠正/离线通过是运行前内部必要步骤，不是允许开始实施纠正前已须具备的循环前置；规划/复审不宣称未来证据已通过。最新review-basic-worker-token-recovery generation 1 completed / not-ready及三发现保留，语义采用见[Context](context.md#新-token-恢复局部复审采用与本次维护)。

真实入口启动前重核当前排他、daemon idle/可用、输入/成功接线/旧证据稳定；旧07:17:33Z或本次晚到idle快照不作当前锁。新目录、新batch-start，独立最多3次原basic调用，首次实际调用起一个30分钟总deadline，含暂停/观察/取证/间隔；每次预留足够执行/保全余量。正向确认前次launcher、已识别worker/debugger和wrapper退出、证据分存、副作用/共享影响可判，且明确临时网络失败、无并存非网络根因才可再试。非网络（含token/身份/观察）、身份/退出/观察未知、输入漂移/冲突或到限即停；无compiler的网络早败不能completed，正常单次成功即结束。已停止批次不因晚到退出/修工具重开；不按Java名称/端口/daemon或未知目标终止，不新增通用runner、生产重试、JDK/网络/接线修正。

逐轮副作用和再试以[Context唯一细则](context.md#逐轮副作用与网络再试判据)为准：固定源/输入/所有既存采用证据及已封存attempt不变；有限任务输出映射内可解释的正常生成变化可保留，未归属/缺清单/可能复用的部分缓存或残留为unknown即停。assess实际分类，eligible_retry必须合取消费sideEffectsSafe、证据分存、全部正向退出、清理/监听/排空/观察收束与原纯临时网络/完整观察条件，不能只保存fixture-after或看taskkill退出码。原单时钟1800秒、最多3次、保全60秒与再试至少180秒余量不变；通过实际函数/记录输入与内存替身离线验证允许和各类拒绝，不把模拟当真实停止链。无法界定实际副作用时只报告缺口，不补缓存管理/清理/网络配置机制。

同一次原basic方法须完整关联Provider（原无直接对象帧限制明示）、Test、唯一同名-D、nested System/StartParameter两map/effective installations、现有printCompileClasspath action实际compiler executable及metadata=8、共享语义与输出。复用原jar/printCompileClasspath/-s、Test17/fixture.gradleJava/consumer8、withPluginClasspath/forwardOutput/withDebug(true)/独立TestKit home，不新增探针或绕过action；缺任一或跨轮拼接均未完成。每轮分存命令/UTC/输入与旧证据稳定范围/日志/XML有无及unknown计数/异常链/原始身份/认领和attach前监听/退出与副作用/停止限制。临时纠正、离线与真实完整发现是同一终态；发现D与完整basic产物B不同，新发现不修B、remapped或最终验收。后继只消费新显式item/gate，旧failed与旧gate保留；原完整B、独立remapped观察、三模块fresh/Forge三类/根入口/当前全部案例/不同Handler验收合同不变。

### 两次 partial 后的有限原入口验证（历史准备）

本节有限安排已执行failed，原写权限/预算仅属旧阶段，不授权续跑。现行必要本地控制链纠正范围见上节，旧完整同轮成功合同仍保留。

最新采用事实与授权见 [Context](context.md#两次-partial-后的有限网络重试依据)。原发现和旧单次重试两个 generation 1 Result 均 partial；两处接线已成功且只读复用，compiler 两行仍未到达。本节取代此前“一次/不循环”运行安排，不改证据或产品合同。旧单次重试复审 completed/ready 不覆盖新边界；旧 item/gate 的 partial/不满足继续保留，新结果不得回填。

- **一个终态与预算：** 仍欠的是同一次原 basic invocation 的完整实际 Java8 发现证据。新批次最多3次调用，从本新批次第一次实际调用起总墙钟30分钟（含调试暂停、取证和间隔，不逐次重置）。此前2026-10-22 05:01:03–05:03:52 UTC的失败属于已结束旧轮，不算作本新批次已调用一次，也不宣称尚剩两次。各次只是一个发现 Result 的内部有界取证，不产生独立探测/修复/审批结果；发现、完整产物、remapped、最终复验及验收仍各自独立。
- **严格再试条件：** 每次启动前只读核对当前成功接线、输入/环境新鲜度、排他资源和既有取证能力；后续调用还须上一进程已结束，异常/阶段/退出码可读，输出分别保存且副作用可判。只对明确临时 DNS/连接超时等网络失败、无并存非网络阻断，在剩余次数和时间内重试。非网络错误、影响未知、输入漂移、观测失效或到限立即停止并报告未完成；不把普通失败一概视为网络，不以新进程重置预算。到限有界收束仅针对可确认的本次进程；未知退出/影响不授权下一次调用。停止后的必要证据保全不延长验证调用。
- **固定入口与权限：** 每次只运行原 PatchedMinecraftTests#Test patched Minecraft，保留 jar/printCompileClasspath/-s、withPluginClasspath/forwardOutput/withDebug(true)、Java17 Test/fixture.gradleJava、Java8 consumer 和现有独立 TestKit home。只产生正常运行及逐次新取证文件，不重做接线、不改 basic 脚本或任何源码/测试/配置/版本/依赖/网络/JDK/用户设置，不清缓存、根 clean、改 runner框架、探针任务或替代入口，不创建生产重试机制/调度器/网络修复，也不要求每次失败另行审批或 curl 全200。共享 Gradle/build/TestKit/cache 与相关输入写入保持排他。
- **同轮完整性：** 每次唯一关联 invocation/工程/阶段、已解析 Provider→Java17 Test JVM 同名属性→basic 最终单一同名 -D→实际 nested 帧/System/StartParameter.systemPropertiesArgs/projectProperties/effective installations 与 compiler。现有 action 实际 Java8 compiler executable 和 languageVersion=8 两行必须来自该次运行；旧两轮观察不能补新轮 compiler，反向也不能拼接。外层 Provider 没有对象帧直接观察的限制继续明示，未变转发代码与消费值只作原已审查对应证据，不升级为直接观察。只有某次完整谓词满足且共享语义可判时才停止为成功；没有 action/两行、观察失效或共享影响未决仍不完成。
- **逐次保全与后继：** 每次日志、XML/HTML/stdout、fixture/输入内容、异常、UTC起止、退出码、execute/pass/fail/skip、task outcome 与失败阶段单独保留；早失败没有XML/退出码时写明未产生或未知及原因，不能伪造0或通过。先保全前次再开始下一次，不覆盖旧报告或失败目录。正常运行偶然产出 patched/consumer 不等于产物项完成。后继仍须读取完整采用的新 Result、核对当前接线/输入/环境及自身全部产物/最终 fresh 合同，不从次数已用完或网络失败推导成功。

发现项最小验证仍从原 basic 方法进入，取得外层 Provider 已解析值→Java17 Test JVM 同名属性→basic 最终 arguments→nested Java8 compiler metadata/executable 的同轮对应。**当前明确可保存的 compiler 来源只有现有 basic `printCompileClasspath.doLast` 实际输出的 `Java8 compiler:` executable 与 `Java8 metadata:` languageVersion**，须与实际 action 到达、invocation 和 stdout 关联；不承诺依赖计算或 patch 失败前必有 compiler 日志。沿原 forwardOutput 保存输出，build() 抛 UnexpectedBuildFailure 时也保存实际输出、失败阶段和异常；未到达该 action 或缺这两行实际解析证据则发现谓词未成立，Result 保持未完成，后继产物项不能放行。候选/属性/预定输出、外层方法失败或另一轮日志均不能替代。若已建立足证据，随后独立产物运行失败不会抹去发现终态，但仍保留原方法失败和阶段，不声称方法或产物恢复通过。不新增探针任务、测试名、替代入口或只跑 javaToolchains。

共享 Test 属性和 withDebug(true) 的取证归属：发现项仅在上述 basic invocation 内记录本次最终 arguments，以及 nested 实际 System.getProperty("org.gradle.java.installations.paths")、Gradle StartParameter.systemPropertiesArgs/projectProperties、effective toolchain installations 配置与选中 compiler；**remapped 在自身 RECOVER-REMAPPED-PATCHED 的原方法执行中记录对应观察**，不成为发现项的提前执行前置。可沿现有 withDebug(true) 在 nested Gradle 实际运行帧只读观察这些对象并保存工程/调用/阶段标识；外层 Test JVM 的属性不能替代 nested 帧/Gradle 对象，调试观察不可用或运行未到达则报告缺口，不能臆测。原时点仅basic允许一个同名-D；未来remapped按末节新授权也追加一个同名-D，完整值不变，不追认旧运行；同时必须根据两 invocation 的实际属性可见性、StartParameter、toolchain 和任务选择解释共享外层属性/withDebug 的影响。值可见不自动等于语义变化，未传 -D 也不自动等于无影响；未能判定或出现改变原合同的真实影响则对应 item/gate 缺证，报告而不越权修复。最终 VERIFY-RECOVERY 在同版两方法中重新保存两套观察，G-RECOVERY-INTEGRATION 第9款及独立验收消费它们；不新增独立 Result、跨工程成功依赖或图环。

后续产物恢复继续从当前脚本核对真实 userdev/MCP/functions/patch/universal/适用 libraries/modules、namespace、provider/producer 依赖及实际 Java8 选择，完成 patchedMinecraft、compileJava、jar、printCompileClasspath。保留所有失败/重试，并明确外层 test 重执行不等于 nested 任务 fresh：执行前核对 nested 旧输出与实际重执行方式，仅在有界且保存证据后处理 basic fixture 输出，不能以旧 class/cache/配置通过代替真实执行。原 Test.java 的 EVENT_BUS / MinecraftServer.main 仅编译、不启动游戏；class major52 是辅助证据，不替代实际 compiler 和产物身份。无来源值、失效安装、冲突属性或现存生产能力缺口均如实报告，不自行升级、改 consumer 或扩大权限。

每个工程单独保存 patched（remapped 另含 official/load/remap）、compileJava、jar 的 task outcome、原输入坐标/文件和产物身份、Java8 compiler、当前 consumer class/Jar 与 printCompileClasspath 输出。只让脚本 compile 或复用旧 class 均不满足对应谓词。局部每项只以自己的方法和产物链验收；完整 PatchedMinecraftTests 的两方法共同义务留给独立最终复验，不能用整类中另一项失败否定已有独立成功，也不能据此豁免完整类。

仍欠的运行证据：basic userdev3 已由原 blocked 报告证明实际解析，不能抹去；其 MCP/functions/工具/完整库与产物仍未闭合。remapped 的远端 userdev/MCP/libraries/modules/工具解析、两个工程的 Gradle provider/variant 和真实任务依赖、实际 patched namespace/Tiny 树、Java8 launcher/compiler 及 consumer 编译均继续待证。源码核对没有证明这些已成功。实施先在对应工程有界预检；实际文件/命名空间若与拟用 srg 不符，必须给出来源/产物证据并报告不能在现存能力和范围内闭合的具体缺口，不盲设字符串、不补生产 API、不升级、不改 Java consumer、不补 TestKit classpath 参数、不复活旧全局 DSL。

## 验证分层与最终组合

**原分层/最终完整V/H合同及未完成事实保留。** 下文R新增矩阵、整类准备、三模块fresh、根入口与consumer重跑均不再是本轮执行义务；其未满足不改判。当前范围和取消重复执行以[页首策略](#已接受的精简r与最终验证策略)为准，原等待不继承到新兼容item。

Mixin 恢复的原最小/整类要求保留，Router 已采用其 completed 及修复后整类先于最小成功的顺序偏差；本次不重放。原发现与旧单次重试两次partial、有限批次failed均保留，新独立发现恢复与产物项各跑原 basic 方法并分开评价终态，remapped 仍只按自己的方法和完整产物链取证。原成功接线事实加新独立恢复某次完整同轮发现结果、basic 产物结果、已采用 Mixin 和独立 remapped 均满足后，由独立 VERIFY-RECOVERY 跑完整 PatchedMinecraftTests、三模块和根入口。首轮153案例是逐项覆盖下限而非未来固定总数；必须重枚举所有当前方法/参数及新增恢复案例，旧方法改名保留语义映射，不能缩减套件。不得用历史131作为通过门槛；参数化方法、方法数/执行数和模块总数都不是覆盖证明。下表原三项局部合同继续保留，新增/迁移反例的实际身份由原局部 Result 和首轮 method-map 关联，不重放已完成独立效果。

`Class#method` 是文档中的源身份，不是可原样传给 Gradle 的过滤串。下文模块清单给出每类的源码链接；Mixins 包前缀为 `net.msrandom.minecraftcodev.mixins.`，Fabric 为 `net.msrandom.minecraftcodev.fabric.mixin.`。局部执行在对应模块 `test` 任务使用 `--tests '完整包.Class.method'`，整类使用 `--tests '完整包.Class'`；例如 `:minecraft-codev-mixins:test --tests 'net.msrandom.minecraftcodev.mixins.MixinInputBindingTests.orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation'`。参数化方法的参数展开以实际报告为准，不把方法过滤命中等同于每个参数已执行。

### 局部验证 selector 与断言承载

现行消费完整P均为新P-v5，原P partial/原gate不满足不回填；T-basic-v3已completed及其gate释放是Router采用事实，本次不重跑或释放。旧selector合同保留，各项实际新内容/身份不能拼旧CLI或DNS失败轮补证。 表内P-v4及更早恢复行只保留历史selector/原完整合同，不重开旧failed；当前仅下方P-v5行可供新验证准备。

下表中三组 T 各自只要求本组精确准备方法，不在局部设完整 fixture 类/三方法共同成功门槛；P/Q 只运行各自真实 provider 并取得完整作者验证证据。完整新增 fixture 类及全部三方法/参数仍为 R 和最终 V 的必需实际覆盖。其余涉及整类要求不变。

| item | 关键现存方法（同时运行涉及的完整类） | 必须证明的关系 |
| --- | --- | --- |
| FIX-RESOLUTION | `MixinInputBindingTests#orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation`、`#testKitNativeSelectorsAreNotOptionsWhileNativeValuesAndImplementationRemainInputs`、`#testKitKotlinRuntimeContentsInvalidateAndRestoreCurrentOutputs`、`#testKitTaskOnlyPluginBodyAndResourceChangesReexecute`；`MixinProducerTests#taskTracksProducerInputsAndBothOutputs`；`MixinOperationIsolationTests#declaredOrderControlsClassByteResourceAndMetadataDomain`、`#successFailureAndFlagOnlyInterruptionReleaseResourcesAndFreshRetry`；`MixinResourceTests#unclosedReturnedStreamDoesNotRetainJarAfterLoaderClose`、`#jdkResourceOpeningIOExceptionIsNullButDefineClassKeepsCause`、`#requiredConfigAndBytecodeOpenNullBlockPairAndRetryFresh`、`#nativeOptionalRefmapOpenNullFallbackAndEngineFailureStayDistinct`、`#actualResourceReadAndCloseFailuresRetainCauseAndSuppression` | 显式输入顺序决定类/字节/资源/plugin 与转换结果；Manifest 不插入 X；未显式 X 的变化不改变结果，显式 X 的变化使当前输入重新执行或正确命中缓存；open-null、fallback、read/close、异常归因、原输入保护、loader 关闭和 fresh retry 仍实际命中。 |
| FIX-DISCOVERY | `MixinResourceTests#discoverySelectsDifferentConfigBodiesInSourceOrderAndRuntimeOverrides`（原 `discoveryRejectsDifferentConfigBytesWithoutChangingInputs`，保留旧→新映射）、`#metadataLoadReadAndCloseFailuresBlockRealProducerAndAllowRetry`（原 `discoveryComparisonReadAndCloseFailuresBlockRealProducerAndAllowRetry`，已迁到真实 metadata load）；`MixinInputBindingTests#orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation`；`MixinProducerTests#exactRawKeysDuplicateSourcesArraysAndUnnotifiedEntries`、`#streamedNotificationsPreserveUnicodeEscapesAndDuplicateSetsForIndependentStrip`；`MixinSafeRetentionTests#producerCleanupRemovesAllRawMatchesAcrossArraysAndDifferentJars`、`#producerPreservesFullNestedConfigPathRatherThanBasename`；`StripMixinsTests#handwrittenRemovalsRemoveEveryRawMatchWithoutProducerOrMetadataDiscovery`；`FabricMixinApplicabilityTests#discoveryMergesSidesAcrossIdenticalConfigsThroughProducer`、`#producerNotificationsRespectApplicabilityAndInputOwnership` | 重复路径只归并声明与 side，正文由有序执行域选择；保留 side/notification、实际转换值、缺失必需正文失败、原输入不变和不同物理副本完整路径清理。旧 Ambiguous 断言必须变为成功选择断言；旧 JarFile 比较探针必须变为真实 metadata read/close/read+close，保留 cause identity/suppressed、两输出失效和 fresh retry。 |
| TEST-FABRIC-UTF8 | `FabricMixinMetadataTests#discoveryPreservesObjectsUnknownFieldsAndReferences`、`#discoveryIsReadOnlyForScalarAndObjectForms`、`#nullableOriginalContractAndApplicableEmptyHandler`、`#scalarAndObjectReferencesSupportExplicitRemoval`、`#actualReadWriteAndCloseFailuresEscapeRemove`、`#currentMetadataUsesCurrentZipValuesAndKeepsDiscoverySnapshot`、`#closedZipHandlerRetainsDuplicatesEnvironmentsAndRealWriters`、`#actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits`；`FabricMixinApplicabilityTests#discoveryMergesSidesAcrossIdenticalConfigsThroughProducer`、`#producerNotificationsRespectApplicabilityAndInputOwnership`、`#sharedParentsInheritReferenceUnionWithoutLoadingInactivePlugin`；同一 `FabricMixinMetadataTests` 中新增的非法 UTF-8 load/remove oracle 参数化案例 | 真实 SPI load、handler snapshot、当前 metadata remove 与默认 `Json.decodeFromStream` 使用同一原始字节对照；截断/非法延续/过长编码的成功或失败、未知字段、references、未写出和原输入/快照不变均可定位。现有六种 I/O 故障与 retry 断言继续保留；不得用字符串、严格 decoder 或另一个 JSON 库替代入口。 |
| RECOVER-FIXTURE-RULE | `FixtureMixinRuleTests#missingListReturnsNull`、`#snapshotPreservesLinesAfterZipCloseAndRemovesOnlyFromNewRoot`、`#readAndRemoveIoFailuresAreWrapped` 及新增声明集合/side、read/remove/retry 案例；完整 `FixtureMixinRuleTests`、`MixinPreapplicationTests`、`MixinResourceTests` | 只删 load 实际发现的声明，以传入 root 定位；实际缺失/删除 IOException 包装、snapshot/原输入/未发现 side 保护，确定性失败命中和 retry。 |
| RECOVER-BASIC-PATCHED（历史 blocked） | `PatchedMinecraftTests#Test patched Minecraft`；原完整消费合同保留，不用新结果回填 | 固定1.12.2 / 14.23.5.2860 / userdev3、真实来源/provider/namespace、patched 和原 Java8 EVENT_BUS / MinecraftServer.main consumer 的 compileJava/jar/classpath 全部仍必需。 |
| RECOVER-BASIC-JAVA8（历史 partial） | 原方法1 execute / 1 fail / 0 skip；原接线与14条观察保留，compiler 两行未到达，不重跑/回填本项 | 外层已解析标准属性→Test JVM→仅 basic 的同名 -D 列表参数→nested compiler 实际解析为 Java8，metadata/executable 可关联，并保存本 invocation 的 nested 属性/StartParameter/toolchain 实际观察；只用现有 printCompileClasspath action 实际两行作 compiler 来源，未到达/缺证据即未完成。保留 Java17/withDebug，无空/null、本机硬编码或 remapped 新增 -D。方法失败须保留，不宣称整体通过。 |
| RECOVER-BASIC-JAVA8-RETRY（历史 partial） | 已结束generation 1；1 execute/0 pass/1 fail/0 skip，2026-10-22 05:01:03–05:03:52 UTC、Gradle exit1、launchermeta.mojang.com UnknownHost；旧单次合同保留，不续跑或回填 | 只证明保留接线的新同轮完整发现谓词；Provider/Test/args/nested 属性、StartParameter/effective installations 与现有 action 的实际 Java8 compiler/metadata 两行全部重取，旧14条观察不拼接。保留失败/超时与原 partial/流程偏差，不并入产物恢复、remapped 或自动满足旧 gate。 |
| RECOVER-BASIC-JAVA8-BOUNDED-RETRY（历史 failed） | 唯一原调用126.646381秒/exit1；本地JDWP拒识、120秒握手超时，无第二/三次，不续旧窗口 | JUnit计数unknown，无nested/compiler两行；原完整发现合同、Wave/gate及不满足保持，不用新成功回填。 |
| RECOVER-BASIC-JAVA8-RECOVERY（历史failed） | 同一原basic方法；新目录必要本地链修正/内部离线检查后，最多3次/首次调用起总30分钟 | 一个发现Result；内部检查不启动真实进程/attach/网络/终止，不修项目实现。某一次完整同轮Provider/Test/args/nested/System/StartParameter/effective installations/现有action实际Java8 compiler及metadata=8才满足；保持Provider限制、真实停止链未验证披露、严格正向退出/分存/影响可判/纯临时网络再试，禁止跨轮拼接。 |
| RECOVER-BASIC-JAVA8-TOKEN-RECOVERY（历史partial） | 同一原basic方法；仅新目录必要token/身份交接纠正、真实原快照直接进入实际纯候选的离线回归后，独立最多3次/首次调用起一个30分钟deadline | 一个未完发现Result；不重修地址或接线，不接受快照到重新认领/attach前身份或监听变化。录制输入/内存替身不证明真实创建/attach/完整停止链；某一次同轮Provider/Test/唯一-D/nested System/StartParameter两map/effective installations/原action实际compiler executable与metadata8/共享语义全闭合才完成。每次执行/保全余量、正向退出/分存及实际消费副作用分类/清理的纯临时网络再试不减，详见[逐轮判据](context.md#逐轮副作用与网络再试判据)；未知即停，无跨轮拼证，不代替B或remapped。 |
| RECOVER-BASIC-JAVA8-NORMAL-RETRY（历史failed） | 同一原basic方法；复用已采用token/身份/观察工具与131/131离线效果，新目录最多3次/首次实际调用起单一1800秒 | 只完成某一次原入口完整同轮发现D；普通Gradle/TestKit缓存/输出变化不需逐文件归属或sideEffectsSafe新认证，实际异常链可识别网络，UncheckedIOException包装不拒绝；网络早败缺compiler不否决再试但不成功。前次本轮拥有进程正向退出/输出线程收束、即时排他、分存/收束余量及具体损坏/身份/退出不明/控制器或非网络故障即停不减；详见[当前判据](context.md#正常网络重试决定与当前判据)，不拼轮、不代替B/M。 |
| PREPARE-FORGE-PATCH-BASIC（历史 failed） | 已有 preparesBasicNotchWithPrivateCache；t9 为1 test/1 failure/0 errors/0 skipped，修后未完整重跑 | 原完整无条件资源见证合同/gate 未满足；不重跑原身份、不回填。 |
| RECOVER-FORGE-PATCH-BASIC-PREPARATION（历史failed） | 原basic方法一次完整调用678.0457361秒/exit1，1/1/0/0；patchedBasicNotch下载UnknownHost | 两文件修改已编译但判定未到达，reference/CLI及prepared/class/resource/inventory缺；原完整合同/旧gate保留不满足，不resume或回填。 |
| 历史 RECOVER-FORGE-PATCH-BASIC-VALIDATION-RETRY | 现存preparesBasicNotchWithPrivateCache精确方法；独立最多3次/首次实际调用起总30分钟，每轮新根/分存 | 复用修改/LZMA，仅未完完整验证；某轮1/0/0/0与真实prepare/reference全部CLI/输入/工具/JVM/阶段/任务/最终output及prepared/class/resource witness/inventory/patch记录全关联；正常网络/正向退出/排他/实际余量才再试，非网络即停。不要求P namespace/cache先通过，空集不适用与损失不变，不拼轮。 |
| RECOVER-FORGE-PATCH-BASIC-VALIDATION-RECOVERY（历史failed） | 同一现存preparesBasicNotchWithPrivateCache完整方法；新独立最多3次/首次实际调用起单一1800秒 | 只取未完完整验证，实际即时排他/真实新根隔离/输入和实现复用安全；短而可解析的可观测启动/有界等待、真实工具timeout及单deadline；某轮1/0/0/0及全部同轮prepare/reference/CLI/JVM/identity/witness/inventory/patch/prepared足证据。正向退出/分存/余量/纯临时网络才再试，非网络/控制或身份退出unknown即停，旧三failed/unknown不回填。 |
| RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION（已采用completed） | 同一现存preparesBasicNotchWithPrivateCache完整方法；新独立最多3次/首次实际调用起单一1800秒 | 同一bash terminal前台同步原gradlew/argv，terminal_wait不重启；真实timeout扣出收束/保存余量，正常返回记录真实码、中断仅记工具事实/Gradle unknown。即时排他/真实隔离/安全复用；某轮1/0/0/0与全部同轮prepare/reference/CLI/inputs/tools/JVM/argv/阶段/任务图/XML/日志/prepared/class-resource witness/inventory/patch闭合，不拼轮/skip/以未运行记不适用，不等P namespace/cache。正向退出/分存/排他/余量充分且纯临时网络才再试，未知/非网络即停；四failed/历史unknown不回填。 |
| PREPARE-FORGE-PATCH-1165 / PREPARE-FORGE-PATCH-NEO | preparesForge1165McinjectWithPrivateCache / preparesNeo121NoMcinjectWithPrivateCache待新增；各项只跑自己的方法，完整类最终R/V全跑 | 各组真实provider/隔离/独立参考/见证及JVM完整，不要求生产namespace/cache先通过；无JDK/缺证blocked/failed，不以其它参数或完整类设共同前置。 |
| FIX-FORGE-PATCH-NAMESPACE（历史partial） | 原T-basic-v3真实入口及原两个owner；原完整谓词保留 | 两文件/版本8/编译及游戏类效果已完成，三次selector失败、overlay/reference/AT/body/cache未闭合；原gate不满足，不重跑原item或回填。 |
| RECOVER-FORGE-PATCH-OVERLAY-CONTENT（历史partial；不重开） | 复用既有真实provider；只规划新build内部验证接线，不改公共fixture/helper/test | 单一恢复终态：notch overlay类型/继承成员规范化、固定映射IClientCommand及真实继承/成员见证、完整独立class/resource/AT oracle、游戏类保持/优先级/资源、新语义与8完整路径隔离和同输入同新语义miss→真实rebuild→hit；仅basic，Q另证两组。 |
| RECOVER-FORGE-PATCH-OVERLAY-VALIDATION（历史failed；原规划时点） | 新build证据根的独立reference/完整内容检查；相同生产patched provider真实task action同有效path hit（仅规划、未运行） | 仅补原fresh/miss身份闭合＋完整class/body/继承/AT/优先级/资源oracle＋same-path hit/再次完整oracle；新根薄工具/目录离线核对为内部步骤，version9/生产/公共fixture不写。一个新1800秒时钟含首个离线调用、postprocess与保存，最多3次网络运行、非网络即停。 |
| RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-TOOL-RECOVERY（P-v4，未执行） | 新根独立reference/完整内容oracle；相同生产patched provider真实task action同有效path hit及再次完整oracle，不重做cold | 原完整身份/加载、共享预检/真实录制、Object+bk/目录、class/body/继承/AT/游戏/优先级/资源/7/8/9隔离合同全部保持。仅可证新根薄工具编写/静态类型错误可在同一预算最小纠正并同版复查，失败/修正/复查证据保留；真实缺字段/内容不符/身份不明/冲突/退出unknown/到限停，不用默认size或改输入/预期绕过。方法事前加载，首相关检查前同步UTC/monotonic起点，一个1800秒含静态/LSP/离线/纠错复查/CLI/hit/postprocess/保存，60秒收束并另留保存余量/有限网络/真实前台退出不变；详见[P-v4策略](#p-v4-同预算工具纠错恢复与作者自检)。 |
| RECOVER-FORGE-PATCH-OVERLAY-VALIDATION-REFERENCE-RECOVERY（P-v5，未执行） | 新根独立raw声明/有效mapping重接；完整内容oracle＋真实patchedBasicNotch task-action same-path hit及再次oracle | [P-v5策略](#p-v5-独立reference语义恢复与作者自检)的游戏patched/member-owner闭包、内嵌有效映射与target/inverse/reader、两真实锚点正负例；其后全部4782 class/body/继承/AT/资源/优先级及完整身份/7-8-9路径/hit谓词均有证，不改公共工程或以局部检查代P。 |
| VERIFY-FORGE-PATCH-1165 / VERIFY-FORGE-PATCH-NEO | 各自 T 的真实 provider/独立参考/见证与同版 P，按各自方法运行本组 | 各自完整 namespace/优先级/资源/适用后处理、实际 forge/neoforge 路径隔离及冷热缓存；Neo 另需收窄 Dist/marker 合同，不互等、不代 M/R/V。 |
| TEST-FORGE-PATCH-NAMESPACE（原完整R合同；本轮不新增或执行） | 拟新增 ForgePatchNamespaceTests 的准确未来 class/method selector 见[矩阵](#独立针对性回归-r-的最小矩阵)；现有 ForgeAccessTransformAndJarJarCompatibilityTests 完整类 | 真实生产回归必须实际命中/通过并关联 XML/产物/cache；消费三组固定来源、T 见证和收窄后的 NeoForge 新鲜内容边界，不用 mock/skip/AT 类替代。 |
| RECOVER-BASIC-JAVA8-POSTPATCH | 原 PatchedMinecraftTests#Test patched Minecraft，原参数/环境/consumer 不变，新批次 | 完整同轮 compiler executable/metadata=8 与各层属性/共享语义，缺 action 或跨轮补证不完成；只 D 不 B。 |
| RECOVER-BASIC-ARTIFACTS | 同一原 basic 方法；完整 PatchedMinecraftTests 及另两 Forge 类仍由独立最终 fresh 执行 | 消费 P-v 与原成功接线事实及新 POSTPATCH D 某次完整同轮发现证据（R 仅为 V/H 必需质量门槛，不是 B 输入）（NORMAL-RETRY及更早 failed/partial 均不要求变 completed），并在当前输入复核 Java8 选择，从最终未验证脚本完成原 basic 的来源、namespace/provider、patched/compileJava/jar/printCompileClasspath 和原 consumer class/Jar 全链；仅发现 Java8 不足。 |
| RECOVER-REMAPPED-PATCHED | `PatchedMinecraftTests#Test remapped patched Minecraft`；完整 PatchedMinecraftTests 及另两 Forge 类由独立最终 fresh 执行 | P-v 与 Q-1165 被采用后，按原批准权限迁移当前旧 API 脚本；Neo/R 非技术前置，关联 non-notch 发布绑定现已核实，M 自身 provider/迁移/运行仍未完成，不以本行代表已能执行。1.16.5 / 36.2.39 / userdev 经 patched、server=false official mappings、含 Java executable 的 LoadMappings、显式 namespace 的 RemapTask 产生 named Jar；原 Java8 EVENT_BUS / Entity.class consumer 及当前 class/jar/classpath 闭合；本 invocation 的最终 arguments、nested 属性/StartParameter/toolchain 实际观察必须能判定共享 Test 属性/withDebug 的影响，不能以无新增 -D 推定无影响，不能判定或改变原语义则报告且不完成。 |

以下原三项的反例义务保留为历史合同；其实现/执行已由原局部 Result 及首轮同版报告证明到相应输入范围，不推导为新的恢复或最终组合通过。现存方法提供的是有效旧断言，不凭类名证明反例存在。FIX-RESOLUTION 的 Manifest 不扩域、显式 X 缓存变化、MR/URL/目录竞争反例由 `MixinInputBindingTests` / `MixinResourceTests` 承载；FIX-DISCOVERY 的外置/不同正文有序选择及真实 metadata I/O 迁移由同两类承载；TEST-FABRIC-UTF8 的原始非法字节 oracle load/remove 由 `FabricMixinMetadataTests` 承载。实施时记录具体新增/改名方法及参数，不能把当前类名当作这些新断言已经实现的证明。删除旧比较接点后必须记录旧→新探针对应及真实命中；当前旧方法能定位不代表修复后仍有效。

旧审查表中的不存在名称逐个按原意归属如下；这些是历史映射，不是可执行 selector，也不要求新建类。局部验证消费上表所涉及整类；下表注明的其余共享承载由完整模块最终 fresh 覆盖，不能以抽样或改名替代：

| 旧名称（不可执行） | 真实类/方法与必要断言 | 修复或共享回归关系 |
| --- | --- | --- |
| `MixinTaskContractTests` | `MixinInputBindingTests#orderedTaskResourcesDoNotRequireConfigPluginAndRefmapColocation`、`#testKitNativeSelectorsAreNotOptionsWhileNativeValuesAndImplementationRemainInputs`、`#testKitKotlinRuntimeContentsInvalidateAndRestoreCurrentOutputs`、`#testKitTaskOnlyPluginBodyAndResourceChangesReexecute` 与 `MixinProducerTests#taskTracksProducerInputsAndBothOutputs`：真实 task 参数/有序输入、内容变化与两输出跟踪，不靠不存在 task 类。 | FIX-RESOLUTION 局部；InputBinding 的有序域也是 FIX-DISCOVERY 局部。 |
| `MixinPipelineTests` | `MixinInputBindingTests#testKitRegisteredCompleteFlowAppliedOnlyAndIndependentOperations`、`#testKitProducerCacheRestoreThenFreshAndRestoredTransforms`、`#testKitTransformTracksParametersAndInputArtifactIndependently`、`#testKitRequiredSourceAndTargetStripFailuresDoNotNegateAppliedOutput`、`#testKitFailedCurrentProducerCannotRouteOldSuccess`、`#testKitHandoffDamageRebuildsAndCurrentInputsReachConsumption`：真实 caller/Task/Transform 路由、FROM-CACHE/当前输入、失败失效及生产/消费独立；`MixinPreapplicationTests#realDifferentArtifactsAndIsolation` 保留最小真实入口及原输入隔离。 | InputBinding 随两项 Mixins 局部整类执行；Preapplication 与其余方法随完整模块最终 fresh，不把整链机械改成一个类名。 |
| `StripMixinFailureTests` | `StripMixinsTests#cleanupSyntaxOrDomShapeFailuresCannotPublish`、`#malformedApplicableJsonOrInvalidZipCannotPublish`、`#outputWriteCloseCancellationAndPublicationFailuresInvalidateCurrentOutput`、`#suppliedFileReadFailurePropagatesFromLocalReaderAndInvalidatesOldOutput` 及 `StripStreamTests#actualBulkCopyReadWriteAndCloseFailuresCannotPublishAndRetryFresh`：真实故障命中、cause/suppressed、旧输出失效、原输入不变及重置后 retry。 | StripMixins 随 FIX-DISCOVERY 局部整类；StripStream 为最终共享回归，动态输入例外保留。 |
| `StripMixinSemanticTests` | `MixinSafeRetentionTests#producerCleanupRemovesAllRawMatchesAcrossArraysAndDifferentJars`、`#producerPreservesFullNestedConfigPathRatherThanBasename`、`#partialAndLoggedFailureNotificationsStillStripAndKeepEmptyConfigs`、`#validEmptyNoMatchingStringsPathsOrConfigsLeaveContentByteIdentical`；`StripMixinsTests#handwrittenRemovalsRemoveEveryRawMatchWithoutProducerOrMetadataDiscovery`；`StripDomTests#duplicateFieldsAndUnknownNestedKeysFollowActualDomWithAndWithoutEdits`、`#everyRawStringControlInUnknownNestedFieldsFollowsActualDom`、`#entryFileDuplicateKeysMatchLibraryAndBusinessRulesStillApply`、`#exactStringsAndEmptyArraysUseTheSameFileFormatAndTrackedDomDependencies`：数组/跨 Jar 全匹配、完整路径而非 basename、近似键/无通知项、有效空集、unknown 字段与原输入保护。 | SafeRetention（此前所谓完整集合漏列）及 StripMixins 为 FIX-DISCOVERY 必需旧回归；StripDom 随最终共享回归，不能因删除正文比较丢掉精确清理保证。 |
| `FabricMixinParsingTests` | `FabricMixinMetadataTests#discoveryPreservesObjectsUnknownFieldsAndReferences`、`#discoveryIsReadOnlyForScalarAndObjectForms`、`#nullableOriginalContractAndApplicableEmptyHandler`、`#scalarAndObjectReferencesSupportExplicitRemoval`、`#currentMetadataUsesCurrentZipValuesAndKeepsDiscoverySnapshot`、`#actualReadWriteAndCloseFailuresEscapeRemove`：真实 load 的 references/只读与业务形状，remove 当前 DOM/unknown/快照、六模式真实 I/O/异常 identity/suppressed 与 retry。非法 UTF-8 默认流 oracle 仍是待新增，不由现存合法输入推定。 | TEST-FABRIC-UTF8 局部整类及最终 Fabric fresh。 |
| `FabricMixinTests` | `FabricMixinApplicabilityTests#discoveryMergesSidesAcrossIdenticalConfigsThroughProducer`（当前源码124–144行）明确断言路径去重、client/server side 并集、双方 producer 转换值42/通知及输入字节不变；另有 `#producerNotificationsRespectApplicabilityAndInputOwnership`、`#outerEnvironmentIntersectsInternalKindsAndRetainsInactiveOnly`、`#sharedParentsInheritReferenceUnionWithoutLoadingInactivePlugin` 保留适用性及 parent/plugin 边界。 | FIX-DISCOVERY 与 TEST-FABRIC-UTF8 的共享只读局部整类；其当前相同正文样例不能替代待新增的外置/异正文反例。 |
| `FabricPlatformBaselineTests` | `FabricMixinMetadataTests#actualSpiAndRetainedAwAndNestedJarRemainIndependentOfMixinEdits`、`#closedZipHandlerRetainsDuplicatesEnvironmentsAndRealWriters`：真实 SPI、关闭 ZIP 后 handler/重复 references/side、AW 与 nested Jar/无关资源及原输入保留。 | 同一 Metadata 类中的必需平台旧断言，随 UTF8 局部与最终 fresh，不虚构第三个 Fabric 类。 |

### 同版最终组合的实际模块清单

**历史完整组合清单，不作为本轮命令或派发入口。** 下列全模块clean/test、根test及版本调用均已取消本轮执行；不据仅兼容类结果宣称本清单全部fresh或原V/H通过。当前唯一精确入口见[一个联合运行成果](#一个联合运行成果)。

最终组合必须在同一最终版本重新枚举并覆盖下表当前源码中的全部测试类。下表每个类链接均指向现存源码；它们是观测到的模块承载，不是未来固定验收数量。T 的 [ForgePatchNamespaceFixtureTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/ForgePatchNamespaceFixtureTests.kt) 已有 basic 方法，另外两组方法及 R 的 ForgePatchNamespaceTests 尚待新增；现存类连同后续真实参数/新类全部纳入最终 Forge fresh，不因历史三类表未列而豁免，不为未来输出创建假链接。完整模块任务不能用下表抽样过滤代替；新增反例必须在 Result 中列出 `class#method/parameter -> execute|skip|fail -> XML/HTML/stdout/fixture`，不硬编码131或未来类数。

| 模块 test 任务 | 当前全部类与源码 |
| --- | --- |
| `:minecraft-codev-mixins:test` | [MixinFailureStageTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java)、[MixinInputBindingTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java)、[MixinMappingTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java)、[MixinOperationIsolationTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinOperationIsolationTests.java)、[MixinPreapplicationTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java)、[MixinProducerTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinProducerTests.java)、[MixinResourceTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinResourceTests.java)、[MixinSafeRetentionTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java)、[StripMixinsTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripMixinsTests.java)、[StripRegistrationTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripRegistrationTests.java)、[StripStreamTests](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/StripStreamTests.java)、[FixtureMixinRuleTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/FixtureMixinRuleTests.kt)、[ProducerDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/ProducerDomTests.kt)、[StripDomTests](../../../minecraft-codev-mixins/src/test/kotlin/net/msrandom/minecraftcodev/mixins/StripDomTests.kt) |
| `:minecraft-codev-fabric:test` | [FabricMixinMetadataTests](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt)、[FabricMixinApplicabilityTests](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinApplicabilityTests.kt) |
| `:minecraft-codev-forge:test` | [ForgeMixinMetadataTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt)、[ForgeAccessTransformAndJarJarCompatibilityTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeAccessTransformAndJarJarCompatibilityTests.kt)、[PatchedMinecraftTests](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt) |

Mixins 的故障阶段、mapping、registration、Fixture/DOM 与真实 pipeline 等未落入局部 selector 的方法随完整模块保留，是共享回归而非此次新增反例。特别是 `MixinSafeRetentionTests` 的全匹配/跨 Jar/完整路径是 FIX-DISCOVERY 的直接必需旧断言，不能因旧表漏列而仅作可选测试。

两个最终验证均保留原完整组合合同；首轮 VERIFY-COMBINED failed 不重写，新增 VERIFY-RECOVERY 须一个独立 Handler / Result。首轮153案例（Mixins107、Fabric28、Forge18）及全部当前新增/迁移案例必须逐项关联，不能只重跑三失败。执行前重新枚举下表所有当前类/方法/参数，数量增加时全部纳入，删除/改名必须证明语义映射。下面的完整模块、故障/缓存/输入保护要求全部原样适用。

最终执行时先用`java -version`和`./gradlew --version`记录外层JDK，检查三个test任务实际javaLauncher与fixture.gradleJava日志；沿用当前JDK安排，不改javaLauncher17或fixture参数清理。Mixins、Fabric、Forge三个模块均为必需fresh集合，分别clean/test `--rerun-tasks`取同版XML、HTML、stdout及fixture产物，最后根`test`入口核对三模块任务接线和当前输入结果。原有shared cache规则照旧，禁止同时用多个Handler运行共享build/fixture目录；根入口无需反复强制相同测试，记录其实际UP-TO-DATE/FROM-CACHE等结果及已有同版fresh证据即可。Forge必须实际执行上述三类，不能用旧不存在类名、别称或根入口缓存替代。

Forge必需fresh集合依据[Context](context.md#forge-fresh回归范围修正依据)：`net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests`实际调用producer、host discovery和精确清理；`net.msrandom.minecraftcodev.forge.mixin.ForgeAccessTransformAndJarJarCompatibilityTests`在真实producer/strip前后对照AT与JarJar行为；`net.msrandom.minecraftcodev.forge.PatchedMinecraftTests`覆盖现有模块patched/remapped入口。三类全部必须在最终实际内容上执行，不能条件性省略Forge、用类名别称或根入口的UP-TO-DATE/FROM-CACHE代替fresh证据。执行前重枚举新增类/方法并纳入对应证据，不冻结旧131总数。必需类/案例未执行或skip即组合证据不足，须保留原因，不能满足对应组合 gate（原 G-INTEGRATION / 新 G-RECOVERY-INTEGRATION）。

最终Result须列出源码/新增案例→方法或参数→实际执行/skip/fail→产物对应；JUnit aggregate数字不够，必需案例 skip 或平台局限要单列，不可宣称已覆盖。完整模块运行保留既有隔离/Strip 等回归，但不新增或恢复已排除的跨 host / 跨 producer 预约、hardlink 或载体验收；最终通过不证明该风险已解决。保留失败报告、修复后成功和明确retry输入重置；旧输出/旧缓存不是当前完成证据。最终组合Handler只组合和取证，不顺手再修独立发现；新阻断须回报，不能改权威或发布。

**当前适用分界：** 本段basic观察和其它最终条款不变；remapped内部逐层观察已由页首JUnit精简策略替换，V/H须分别消费参数回归与真实M的独立Result，未直接观察明确披露。以下原文字仅保留被替换部分的历史合同，不恢复私有成功等待。

VERIFY-RECOVERY 还须在最终内容的 basic/remapped 两次原 invocation 内保存各自最终 arguments、nested System 属性/StartParameter/effective toolchain 与实际 compiler 观察，关联共享 Test JVM 属性和 withDebug(true) 的运行语义，不能把 runner 无新增 -D 当作 remapped 无影响的证明；缺观察或未闭合影响则第9款不满足，仅按末节新计划恢复remapped标准属性转发，仍不改变consumer/版本语义。另须保存已采用 Mixin、两次Java8 partial/原成功接线事实、有限failed及诊断/时间/停止限制、RECOVER-BASIC-JAVA8-RECOVERY failed及token/身份交接诊断限制、已采用RECOVER-BASIC-JAVA8-TOKEN-RECOVERY partial及工具/同版离线效果、NORMAL-RETRY failed及限制、新 T-basic-v3/T-1165/T-Neo/P/Q/R/RECOVER-BASIC-JAVA8-POSTPATCH、旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及T-basic-v历史调用/启动/退出unknown 及 basic 产物和独立 remapped Result 的实际证据，保留旧 basic blocked/三失败/最终脚本未运行事实，关联原 G-REPAIRS 三个局部 Result、原三失败到新方法/参数的映射；核对同一最终 tracked/untracked 源码/fixture/build/配置内容运行前后稳定，不能只用 HEAD。三模块 fresh 串行，每模块结束即保留 XML/HTML/日志/fixture，再单独保存根自动重跑；不能覆盖原失败或 fresh 证据。clean 仅在核对 Delete 目标后清相应模块 build，保护根 build 全部历史，不运行根 clean。根 `:test` 必须成功到达应有末端，图存在但 task 未到达不算成功，缓存接线观察不能替代 fresh。

独立验收由不同于实施/复验者的 Handler 消费新的实际 VERIFY-RECOVERY、已采用 Mixin、两次Java8 partial/原成功接线事实、有限failed及诊断/时间/停止限制、RECOVER-BASIC-JAVA8-RECOVERY failed及token/身份交接诊断限制、已采用RECOVER-BASIC-JAVA8-TOKEN-RECOVERY partial及工具/同版离线效果、NORMAL-RETRY failed及限制、新 T-basic-v3/T-1165/T-Neo/P/Q/R/RECOVER-BASIC-JAVA8-POSTPATCH、旧 T-basic/T-basic-r/T-basic-v/T-basic-v2各failed及T-basic-v历史调用/启动/退出unknown 及 basic 产物与独立 remapped Result、旧 basic blocked、原三个局部 Result 及首轮失败史；不能用只读诊断 completed、作者自检、计划 review 或旧 failed 组合代替。新 gate 全文合同及旧 gate 保留关系见 Waves，独立 review 与实施范围 Disclosure/确认仍由 Router 处理。

## 风险与停止条件

- 当前风险为P-v5真实四差异/无完整P、新live声明优先级未动态证明、version10新实际加载/构建/cache/full oracle未运行，以及生产与验证共用1800秒可能不足；两reference修正、version9正确overlay和T-basic-v3 completed保留，不因文档自检关闭缺证。现行范围/停止规则见[新策略](#游戏rename继承恢复与新产物验证策略)，下面较早“生产未修/尚未完成”均限其历史时点，不扩大当前权限。
- basic 工程/helper/入口已交付，旧 T-basic/T-basic-r/T-basic-v/T-basic-v2 generation1各failed（T-basic-v历史调用/启动/退出unknown）；独立 T-basic-v3、T-1165/T-Neo、P/Q-1165/Q-Neo/R/patch 后 D 尚未完成，生产未修，不能将准备/参考成功等同完整方法成功；S 及未来旧实物对照已撤出，Git 只记录源版本，不证明生成内容。T 的固定输入/隔离/独立见证、P/R 新鲜最终内容与自有 key/冷→热行为仍待实际产证；无旧错缓存动态拒绝、旧 final 反例重放、NeoForge 完整旧 attrs 等价证明，这些限制不能静默恢复为承诺。JDK21/8 缺失按分支报错/等待/独立继续规则，最终 gate 不放行；remapped 原迁移仍获准但未实施。NORMAL-RETRY 非网络 compileJava failed 不续跑；不填空接口/改consumer/删Java8/换版/扩API或依赖。以下旧token准备只属历史，不重做成功效果。

- 输出竞争和共享预约尚未修复，按用户决定排除；首次 not-ready 及历史候选方案未实施事实保留。三项成功不得被表述为输出独占合同已全面实现。
- 显式 Jar 查找可能每资源短开 Jar；先保持正确性和关闭，不增缓存。MR/URL 编码/Windows 占用必须实际验证，未验证前仅为设计。
- ResourceTests 故障探针随真实接点迁移；死探针/空断言不算保留保证。排除预约不授权删除剩余三项有效的故障、关闭、清理、原输入保护或 retry 断言。
- 共享文件修改及共享 build/fixture 测试运行排他是图约束，不是业务成功依赖；不覆盖既有用户内容。
- 两次partial、有限failed与RECOVER-BASIC-JAVA8-RECOVERY failed均保留；新token/身份交接恢复只在新目录必要纠正，已修地址/观察控制不重做。真实未预处理快照回归通过不等于真实认领/attach/完整停止链或完整发现；同轮compiler/共享影响缺证仍未完成。独立最多3次/首次调用起一个总30分钟deadline，每次执行/保全余量、正向退出/分存/副作用可判及纯临时网络再试不减；非网络/观察/身份/退出未知即停，晚到退出不恢复旧资格。不新增curl全200门槛/通用runner/生产重试，不修项目或回填旧结果。
- 三族合同无已知具体缺口；若实际恢复必须改合同，报告受影响条款和不可行证据，不自行接受。全量审查 partial 和 498 项历史等价盲区仍独立存在。

## reference reader 格式局部纠正作者自检

已采用后续继承接线独立局部复审 **completed / not-ready**；唯一P1是固定reader拒绝无父child-only行及旧失败语义描述错误。此前生产live/资源优先级、两owner交接、reference独立性、两条继承锚点及原消费者/cache接线的支持保留。本轮只修格式合同及关联四文档，不重新选择方案或重审图。前轮闭包/逆向往返事实保留，但“2448行可供reader”的推论撤回；当时遗漏token门槛，不能冒称曾验证reader。

- **精确修改：** 恢复策略的reference格式、inverse失败语义、声明节点/边记录计数及终点合同，前轮作者自检的格式结论；同步Work入口、Context摘要及Waves同一P-recovery证据正文。来源沿用恢复策略内的仓内files.tsv、jvm.tsv、固定映射及其定位的实际归档，不保存项目外Result路径或报告副本。
- **实际reader核对：** Python标准库只读固定shaded归档，SHA256仍为9105207cc68fbba768b314fa8584f7c63de2cf664f1fd50aaab4a386975a88bd；解析常量池及方法Code，对照InheritanceMap.load的split/长度分支/三类IOException、JarProvider.getParents的缺失返回null、JarMapping.tryClimb的fallback→setParents及setParents(null)新建空ArrayList分支。不是运行Java/CLI。
- **内存格式/inverse/终点：** 从files.tsv实际raw U、独立patch-obf/merge-clean、63个basicLibraries及所选Java8 rt/jce只读重建。1434个U class及非数组member-owner形成2200根；闭包2448（U1434/patch186/clean202/库353/Java8 273），唯一无父Object。3344原class映射＋2061 identity＝5405，无target碰撞，保留Object identity；仅序列化2447条有父记录。逐行断言单空格、无空token/tab/前后空白、至少两token、每个child/parent可inverse、还原父集一致及无self-parent；child-only负例不满足门槛。raw U确无Object，内存终点模型按所读字节码null→空父集缓存停止。仅格式/图静态检查通过，未调用实际loader。初次解析尝试分别因数组owner未筛选、错误展开数组owner导致断言失败；纠正为实际非数组成员owner根后才得到上述通过计数，不把失败尝试算通过。
- **两锚点复核：** 原IClientCommand父bk及含bn的descriptor对应ICommand/ICommandSender；原ClientCommandHandler父bj且无b声明，a(Lbn;Ljava/lang/String;)I的Code offset59为Forge-owner.b()Ljava/util/Map;。独立clean/patch中bj均声明该方法，固定映射1132/1144仍要求super→CommandHandler、owner/descriptor保留、name→func_71555_a；目标表inverse保留两条继承路径。预期仍不由工具输出反推。
- **四文档静态保留检查：** 全文读入后仅执行13处精确替换，写前逆向替换可逐字还原各文件原文，写后回读一致。Waves行数不变且仅同一P-recovery的证据行变化，其余行（含全部item/依赖/Wave/gate/冲突/消费者）逐字不变；未重新全盘审图或冒称重跑前轮图计数。四份摘要的2448/2447及identity一致，新自检锚点唯一、Work/Context链接可达，沿用仓内files.tsv/jvm.tsv/两份映射链接可读，无项目外Result路径。本检查说明随后仅在此补记，不更改执行图。
- **未变边界：** 仅必要四文档正文，图结构/消费者/原谓词/Java21分离、原P partial及旧gate不满足、T-basic-v3 completed及已释放gate、版本8已知错误和全部failed/unknown/basic空集覆盖损失不变。新语义/fresh完整内容和同有效路径miss→rebuild→hit不降低；authority继续reuse、无写入。本轮不运行Gradle/Java/项目测试/网络/Git/安装/清缓存/进程操作，不落盘脚本/继承表或改生产/helper/test/fixture；不调度、不释放gate、不声明ready。局部复审范围仅reader格式、inverse失败/identity、Object终点及四文档关联，不扩大到已支持边界。

未检查/未执行：动态production/reference CLI、完整AT/body/final及冷热cache；静态模型不是CLI通过。剩余风险：作者自检不替代独立局部复审或未来P-recovery完整验收，全部既有缺证继续保留。

## 继承接线局部修正作者自检

**修正范围与判定。** 本轮仅处理 `review-forge-overlay-recovery` generation1 completed/not-ready 的唯一P1：固定1.8.3继承入口、可达同向输入、两owner内部交接及production/reference接线不具体。已把这些前提写成可静态推导的执行合同，没有实施代码、重跑动态验证、更新authority或判定独立复审通过。前轮“入口存在但输入未知”的状态不再作为当前设计；实际实现/日志/最终内容/cache仍由同一个P-recovery未来证明。

| 作者检查 | 本轮实际结果 |
| --- | --- |
| 工具/输入具体性 | **前轮记录：当时未检查reader的至少两token门槛，格式结论以下方最新自检纠正。** 只读源码、MCP/userdev JSON及现有jar/class/header/TSRG；核对固定工具SHA、`--live`/`--read-inheritance`调用链及后者目标namespace→inverse→源namespace格式。生产是obf `G`+filtered universal+显式libraries/Java8 live资源图，reference是独立raw producers的header表+仅class identity增补映射，无live/生产中间物。真实继承调用、声明、TSRG及IClientCommand类型预期均固定，详见恢复策略内静态依据；不是“实施时失败即停”替代当前可执行依据。 |
| 独立性与继承闭包 | 静态扫描固定universal的1434 class及其常量池成员owner，合计2200查找根；2448继承闭包class均有源头，含388游戏/353库/273 Java8 class。2061 identity项使全部声明的target→inverse往返保真，但不证明reader可加载2448行（Object单token会报错）；最新格式检查及2447行合同见下节。实际live shaded库遮蔽已检查、映射域祖先无差异，不声称库图完全相同。继承成员、类型、完整class语义、非class资源、AT及优先级各自有来源/谓词；旧8 CLI、raw+AT、零计数均不能单独成立。 |
| 四文档与权限 | 仅Work/Context/Plan/Waves局部修正。Work指向当前加工/策略/本自检，Context保留采用史并加工新依据，Plan持有具体设计/证据，Waves只将同一成员证据同步到可执行项；PRD/ADR/Spec reuse及C5四文档维护授权未改变。外部运行时Result只读，不写入持久引用、不复制原报告或另建Result文件。 |
| 图与原合同保留 | 对内存中的编辑前完整四文档逐行比较：原有表格行全部不变；Waves显式前置item行、冲突规则至末尾的表格/全部gate文本逐字不变。重解析仍29 item/24 Wave/24 gate/77节点/139边（51 item依赖+29 membership+29 member→gate+30 gate等待），全部引用端点存在且无环；无membership/依赖/冲突/消费者/图连接变更，无须以其它节点修补本P1。 |
| 实施与缓存边界 | 原P两个生产owner、既有fixture/helper/test边界和公开API/Core.Cache限制不变。内部结果通道保留公开Path入口签名；最终normalized overlay→inject→AT、适用mcinject/优先级未改为前移路线。保留version8及游戏改善、不命中新语义，保留实际输入闭合与同有效path miss→真实rebuild→hit，以及原P全部完整内容/适用AT/完整路径隔离谓词。 |
| 历史与后继 | T-basic-v3 completed/原gate此前释放；P generation1 partial/原gate不满足，P-recovery未执行/其gate未满足；旧failed/unknown不改判。Q-1165/Q-Neo/R/D/B/M/V/H的既有输入、Java21分离、串行排他、单终态、独立验收和完整Result采用合同全部保留，不加“旧P先成功”前置。 |
| 引用与后续复审影响 | 新增持久链接限可读仓内项目相对来源；新增本地路径与锚点定点校验。受影响复审范围仅本策略的真实CLI/数据通路/同向游戏与必要库可达性、read-inheritance格式及独立oracle与Waves对应证据、四文档/原合同相容；既有通过图结构未改变。此为作者自检，不是独立复审结论。 |

**未执行与风险。** 本轮只做只读静态解析和文档/图/引用检查，未运行Gradle、Java、测试、网络或现有取证脚本，未安装、改工具、清缓存或操作进程/Git。归档和当前源码支持所选接线，并不证明未来实现、实际JVM资源图、完整内容和缓存运行结果；相关动态证据仍是同一P-recovery的必需验收，不能据本记录释放任何gate。

## overlay 完整结果恢复作者自检

**前轮记录，保持其历史时点。** 其当时“具体argv/继承见证待内部证明”正是随后局部复审P1；本轮静态接线与实际检查见[最新作者记录](#继承接线局部修正作者自检)，旧记录不作为该缺口已关闭的证据。

本节是本次四文档维护的作者检查，不是不同Handler的review-delivery-plan、ready、实施许可、实际item完成或gate释放。T-basic-v3 completed/其gate先前由Router释放、原P generation1 partial及已采用诊断completed只按各自证据范围采用。

- **输入/authority/最小边界：** 已读取四份精确文档、指定原P/T-basic-v3仓内报告/错误见证及外部诊断Result，直接只读两个当前owner、私有reference与旧verify-content.py。外部Result仅导航，持久依据仅用本次已读仓内相对源码/报告/见证；没有新建报告/复制诊断依赖或重跑归档分析。PRD/ADR/Spec三族沿用reuse/译本写入skip；只有既定Forge产物一致性恢复，无新产品/隔离架构/公共API，实际重要缺口先报告。
- **一个可消费结果：** 新RECOVER-FORGE-PATCH-OVERLAY-CONTENT（P-recovery）/W-FORGE-PATCH-OVERLAY-CONTENT/G-FORGE-PATCH-OVERLAY-CONTENT各唯一；必要notch class规范化/内部交接/新语义键及全部原fresh内容/cache验收是同一终态，不单交编译标记、helper或脚本。只消费已采用T-basic-v3与原P partial保留效果；不重做游戏补全/去late-copy/准备，不要求原partial/gate先成功，不等自己gate。
- **具体机制/oracle与缺口：** 原overlay位置/filters、patched>clean/universal原覆盖优先、inject真实碰撞、原mcinject适用域及AT/Dist/marker次序不变；notch适用class由配置renamer加正确游戏继承上下文规范化类型/成员，资源/内置映射不文本替换，non-notch/Neo不重复转换。旧raw-universal+AT class期望明确无效，8CLI仅游戏参考。固定IClientCommand bk/bn映射、至少真实继承成员及完整独立class＋适用AT/分离资源oracle、游戏完整接口/优先/25资源/真空集与损失均必需。具体argv/继承能力/见证尚待同一恢复内部证据；不能闭合则报告blocked。前移class至rename前的mcinject/metadata/碰撞/优先级等价未证，该替代路径blocked，不是静默退路。新build薄验证接线不扩公共fixture/helper/test权限。
- **缓存原完整谓词：** 原7历史/当前8已知不完整与新语义有效operation/聚合key/basename/完整path必须区分，新增派生输入闭合；同输入同新语义/同有效缓存path的可证miss→真实rebuild→完整oracle→hit及内容一致性仍是恢复必需，不以版本diff、外层rerun或换输入代证，不清缓存/改Core.Cache/造旧实物。两族共用值只静态核对，non-notch/Neo实际内容/path/cache仍各由Q另证，不把三组全成功夹进P-recovery。
- **联合图检查：** 对内存候选Waves解析item前置、item→唯一Wave、Wave→前置gate、gate→全部成员；29 item/24 Wave/24 gate，77节点/139等待边，无悬空、重复归属、环或自等。155项定向文档断言含原历史保留/最终条款、真实消费者和缺21假设：Q/R/D/B/M/V/H完整P消费均改接新item/gate，D/B/M祖先无R或T-Neo/Q-Neo、M必需Q-1165但不依D/B；旧P/旧gate不成为恢复或新消费者待成功前置。
- **Java21反例/串行：** 假设仅21不可用且8/17/其余输入权限证据充分，同时保留旧failed/partial不成功，图闭包仍可达P-recovery→D→B、T-1165/P-recovery→Q-1165→M；Q-Neo/R/V/H及最终gates不满足，原P gate/G-RECOVERY/G-BASIC-RECOVERY仍不满足。这是文档依赖可达性，不是实际工具/结果/gate已成功。共享Forge两owner/fixture/helper/Gradle/TestKit/build/cache/输入写运行继续串行；无成功等待不表示并跑，漂移须复核/重取受影响证据。
- **历史/最终覆盖：** 编辑前内存原文对比确认全部旧Work表行、原P/T-basic-v3完整item合同、其旧Wave/gate行及全部既有Plan作者记录保留；旧item前加明确采用/历史状态而非改写。最终gate第2–8款逐字保留、第9款仅P引用改名，第1/10款和V/H显式合取更新新恢复/采用历史；153/150/3/0、全部failed/partial/blocked/not-ready/unknown、旧P partial/完整谓词/旧gate不满足不回填。三组实际路径/缓存、R完整矩阵/AT/JarJar、原Java8 consumer/共享属性、最终同版fresh/新增方法参数/根入口及不同Handler验收不减。
- **链接/写入检查范围：** 新链接只指向本次已读仓内源码/报告/见证或四文档实际标题，未写外部Result路径/伪造未来测试链接。最终写后回读、四文档互链/锚点及新增目标核对见本次Result；未重验历史外部URL、全仓源码稳定性或实际归档身份。

**待不同Handler局部独立复审的范围：** Work页首采用摘要；Context“P partial采用与overlay完整内容恢复边界”；本Plan原P完整谓词/新恢复策略/本自检；Waves新item/Wave/gate、Q/R/D/B/M/V/H改接/现行连接、final第1/9引用/10款及联合依赖/冲突。重点是一个恢复终态、原位置独立规范化与继承上下文/blocked选择边界、独立class-resource-AT oracle可达性、新语义8隔离/完整cache、Java21独立与旧历史不回填；不无据重开原资源决定/支持版本/已完成迁移/不变authority。本次不派发复审、不选后继。

未运行/未检查：Gradle、Java、项目测试、网络、Git、安装、缓存/进程操作及任何新生产/reference/工具/JDK/消费者证据；没有修改四文档外文件或创建脚本/fixture/备份。
剩余风险：新策略及具体renamer/继承成员能力尚未实跑且未独立复审，不能称ready或实施获准；原P内容/cache缺证、basic覆盖损失、旧unknown/Dist静态风险/输出竞争排除继续保留。

## basic 同 terminal 前台恢复维护作者自检

本次为一个C5协调文档维护谓词，仅改同目录Work/Context/Plan/Waves，不执行恢复。Router授权覆盖已确认原完整basic验证的正常重试连接；已加载Waves/Plan/Work方法及其检查/模板/委派规范。完整读取指定四文档、仓内failed报告/batch记录和已采用只读诊断，另核对实际run.ps1/exit.json/工具回执；诊断的项目外运行时Result只作导航，不成为仓库链接/持久依赖，不复制原Result/会话。直接源码只证明false时先exit124绕开真实退出获取；谁结束后代仍unknown，不假称网络/测试根因或清理已确认。

- **唯一结果及权限：** 新T-basic-v3（RECOVER-FORGE-PATCH-BASIC-FOREGROUND-VALIDATION）一个item/Handler/Result及独立Wave/gate，只取未完完整验证；薄入口/控制取证及最多3次attempt不拆独立消费者。复用helper/test/LZMA/fixture和安全输入，未修改代码/测试/旧工具/任何其它文件。三族PRD/ADR/Spec及译本继续reuse/写入skip，无资源决定/产品/架构/成功标准变更，不新建权威。上一review-basic-new-validation-batch已采用ready只属旧准备边界，不等于此次复审。
- **控制/预算作者核对：** 新策略/item/gate/第10款一致为同一bash terminal前台同步原gradlew/argv，必要PowerShell只环境与正常返回后的真实退出记录/转发；terminal_wait等同一terminal、wait未结束不重启。删除Start-Process＋WaitForExit false先exit124分叉，不靠增大1200；真实工具timeout从首次实际调用起单一1800秒剩余扣出至少60秒收束及另行合理保存余量，最多3次/下一轮至少180秒且实际够用，不续旧预算/到限才保存。强制中断不能保证正常Gradle码，只记工具事实/Gradle unknown，控制/身份/退出未知即停。启动即时排他/真实工程/TestKit/home/cache/output隔离/安全复用/可观测完整控制仍是未来事实要求，旧无PID/用户重试不代证，也不永久要求历史unknown清零。仅明确临时网络且正向退出/分存/当前排他/实际余量充分才再试；非网络/未知/冲突/上限停，无网络诊断/探测、普通缓存审计/逐轮审批或新取证框架/清理器/调度器。
- **真实静态检查：** 用工具内存断言解析全部item、Wave、成员/归属、显式item前置和Wave等待及成员gate，构建 **28 item＋23 Wave＋23 gate＝74节点/135边** 联合图，DFS无环，所有成员/前置/等待引用有定义，每item唯一归属且Wave非空，无自身gate等待。仅新增恢复三条归属/等待/gate边，P/R/V/H四item前置及P Wave等待改接新结果；没有把旧failed当待成功前置。当前T-basic-v3→P→D→B、T-1165/P→Q-1165→M无Neo/R额外成功屏障；R/V/H仍全等必需三组/最终结果，冲突只串行、不造成功依赖。
- **保留对照：** 对照修改前文本，**22个非受影响item块原样、21行既有Wave/gate原样**（唯一改接的旧行是P），包括Q/D/B/M和1165/Neo项；G-RECOVERY-INTEGRATION第2–9款逐字不变，第1/10款仅所需恢复与历史消费。旧T-basic-v2全部原item合同及gate行完整保留并另加failed采用注，旧T-basic/T-basic-r/T-basic-v各failed块及gate亦不改判。旧策略/旧作者计数保留时点语境；资源阶段/固定basic真空集合同逐字不变，clean-only/inject覆盖损失、collision clean/patch合集/空交集替代及1165/Neo实有义务不减。成功仍某轮完整selector1/0/0/0与全部同轮真实prepare/provider最终output、reference全部CLI/inputs/tools/JVM/argv/退出/阶段/任务图/XML/日志/prepared/class-resource witnesses/inventory/patch，不拼轮/skip、不以未运行记不适用、不等P namespace/cache先通过。新成功不回填任何旧gate/清历史unknown，已完成实现不重做。
- **导航/状态：** 四文档当前指针、Plan策略/作者自检与Context采用锚点对应；Waves页尾两处旧自检导航已同步。新增可移植证据链接指向实际已读取的仓内报告/脚本/记录，无项目外会话依赖。历史独立复审not-ready/failed/partial/blocked与旧ready的各自适用范围不改写。本次检查只证明文档结构/连接，不证明新terminal/Windows后代收束/隔离或运行成功；未启动Gradle/Java/测试/网络/进程操作，未用Git/安装/备份/清缓存、未派发复审。

**待不同Handler局部独立复审边界：** 仅本次T-basic-v2 failed/诊断采用及unknown、T-basic-v3单谓词/同terminal前台控制与真实硬限/收束保存预算、安全启动/重试停止、完整原合同保留、P item/Wave与R/V/H/最终第1/10款必要接线、当前导航及联合图一致性。不重审不变资源决定/产品架构/成功标准、不扩大Q/D/B/M/原consumer/Neo支持；具体越出确认范围的实质决定只报告。作者自检不等独立review、ready、item完成或gate释放；本轮不执行/调度、不自行放行。

## basic 启动控制失败后新批次维护作者自检

**历史作者记录，T-basic-v2后来failed。** 以下检查/计数仅属该轮准备；不证明本次同terminal恢复，最新自检见[本次记录](#basic-同-terminal-前台恢复维护作者自检)。

本节仅记录本次C5四文档局部维护及作者静态自检，不是独立复审、ready、测试成功、实际item完成或gate释放。完整Handoff bundle只有同一图维护终态；指定主Skill/两个companion及全部精确context/inline已消费。三族reuse/写入skip、不变scope/资源适用性/完整selector成功标准沿用，无权威变更或重复确认要求。

- **材料性变化：** 新增一个T-basic-v2（RECOVER-FORGE-PATCH-BASIC-VALIDATION-RECOVERY）item/Handler/Result与独立Wave/gate，仅取未完完整验证；内部attempt/必要短调用纠正无独立消费者。P的item/Wave、R/V/H及最终第1/10款必要消费改接新结果，旧T-basic/T-basic-r/T-basic-v各failed/原完整合同/旧gate不满足和T-basic-v历史实际调用/启动/退出unknown保留。无回执/文本解析错误不是零效果/已退出证明；新成功不清除unknown。
- **实际联合检查：** 只读内存JavaScript解析原/候选item前置、item所属Wave、Wave前置gate及gate对全部成员等待，26 item/21 Wave/21 gate/68节点129边变为27 item/22 Wave/22 gate/71节点132边；唯一非空归属、引用解析、无自等/环。130条针对性断言通过：19个不受影响item全文、三个旧basic item原谓词/写边界/证据正文、20条旧Wave/gate原行、最终第2–9款、Work全部旧采用表行、Context历史尾部及Plan旧作者正文保持；P所属Wave仅替换必要准备gate。
- **两个反例只属模型：** 将所有旧failed/partial固定未完成、其余新结果假设足证时H可达而旧gate仍不满足；只有21不可用而8/17及自身输入/权限/证据充分时T-basic-v2→P→D→B和T-1165/P→Q-1165→M可达，Neo/Q-Neo/R/V/H及最终gate仍等。未新增Neo对Java8、R对D/B/M或D/B对M屏障；共享Forge/helper/Gradle/TestKit/build/fixture/cache/输入写运行排他保留。模型不证明实际工具/JDK能力、合法启动或成功。
- **语义/证据检查：** 本轮加工仅引用已读取的仓内failed报告/旧观察，不持久化外部Result路径、不虚构未来产物。新批次明确实际即时排他/全新根隔离/已物化输入和实现复用安全、可观测短完整启动/有界等待/真实工具timeout能力；具体unknown冲突或无安全路径即停而不改图绕过。单一1800秒含执行/收束/保存、最多3次/余量、仅纯临时网络/正向退出/分存再试和完整同轮1/0/0/0及全部原证据不减，未执行不能记不适用。
- **不同Handler局部独立复审边界（本次未执行）：** Work当前入口/新增failed采用行/完成信号；Context页首启动unknown/采样限度/新批次条件；Plan新批次策略、selector与P/R/V/H消费、本节；Waves旧T-basic-v failed限定、新T-basic-v2 item/Wave/gate、P item及所属Wave、R/V/H前置、排他/现行连接及最终第1/10款。重点核对新旧身份/预算、失败unknown不回填、安全/能力实际条件、短调用与时限/收束及完整同轮合同。既定资源取舍/覆盖损失、Q/D/B/M原合同、不变权威和最终第2–9款不无据重开；不等于重新确认未变scope或执行放行。

未执行/未检查：Gradle、Java、测试/重试、网络、Git、安装/备份/清缓存、进程检查或终止、生产/测试/fixture/runner/配置/依赖/权威/旧证据修改；未核验全仓或实际启动安全，静态检查不落脚本文件。
剩余风险：实际工具timeout/可观测控制、即时排他/隔离及输入复用安全仍待未来执行验证；旧unknown、完整验证缺证、最终全量/独立验收和既有排除风险不关闭。

## basic 完整验证有限重试维护作者自检

**历史作者记录。** 下节检查及计数只属原T-basic-v准备阶段；该项后来failed且历史调用/启动/退出unknown，不证明当前新批次。最新检查见[本次自检](#basic-启动控制失败后新批次维护作者自检)。

本节仅证明本次选定四文档C5维护及作者静态检查；不是新运行Result、独立复审、ready、item完成或gate释放。上方/后续旧作者记录均按原阶段保留，不把其旧计数或“当前”视为本轮事实。

- **输入与单一终态：** 完整objective/constraints/deliverables仅一个协调图维护结果，指定Waves主Skill及Plan/Work两个companion均已加载，全部精确context及内联授权已消费。采用T-basic-r generation1 failed及用户已确认的测试修改/完整运行/正常网络重试，不重开设计；三族authority继续reuse/写入skip，仅改本目录work/context/plan/waves四文件。
- **材料性变化：** 原T-basic及T-basic-r各failed、原完成合同/旧gate不满足保留；已交付工程/LZMA及两文件修改实际编译但新判定未到达。新增一个T-basic-v（RECOVER-FORGE-PATCH-BASIC-VALIDATION-RETRY）item/Handler/Result与独立Wave/gate，只取未完完整selector验证，不再修改测试/实现。P的item及Wave准备等待、R/V/H的显式消费、最终gate第1/10款及四文档当前说明改接新结果和两次failed史；其它独立分支及第2–9款原完整最终合同不改。
- **执行/成功边界：** 独立新批次最多3次，首次实际调用起一个总30分钟，包含取证/间隔/收束；每轮新根/分存，前轮正向退出/输出收束、当前排他、明确临时网络且实际执行/保全余量充分才继续，非网络/未知/上限停止。只认某轮现存basic完整1/0/0/0与真实prepare/reference全部CLI/输入/工具/JVM/阶段/任务/最终output及prepared/class/resource witness/inventory全关联，不拼轮、仅编译不成功。未执行不能记不适用，阶段真空集/损失和1165/Neo实有载荷、P namespace/cache非前置不变。不增缓存全面审计/预探测/网络诊断/debugger/框架，不改版本或配置、不清缓存/备份，无需重复用户批准不变重试范围。
- **实际联合等待检查：** 对编辑前/候选文本用只读JavaScript解析item→前置及所属Wave、Wave→前置gates、gate→全部成员，25 item/20 Wave/20 gate/65节点/126边变为26 item/21 Wave/21 gate/68节点/129边；唯一非空归属、引用解析、无环/自等。133条针对性文档/图断言通过，包含P/R/V/H消费新item且不等两旧failed、原item成功依赖与排他区分、M必需P/Q-1165而不依D/B、新item只等G-REPAIRS。写后以只读stdin Python从确切四路径再次验证同一联合图及两组闭包反例，均通过；不采用作者历史计数作为本次检查。
- **关键反例（仅模型）：** 全部旧failed/partial固定未完成而新结果假设足证成功时H可达，G-INTEGRATION/G-RECOVERY/G-BASIC-RECOVERY/两个旧basic准备gate仍不满足；仅21缺失、8/17和自身输入/权限/证据充分时，T-basic-v→P→D→B及T-1165/P→Q-1165→M可达，Neo/Q-Neo/R/V/H及最终gate等待。该闭包检查不是实际JDK/工具可用或运行成功证明，不放行任何gate。
- **保留/证据检查：** 与编辑前内存文本比较，19个不受影响item全文、两个旧basic item的原完整谓词/写拥有/证据正文、19条原Wave/gate完整表行（唯一P行仅必要改接新gate）、最终第2–9款、Work全部旧采用表行、Context旧历史尾部及Plan历次作者历史均保持。只新增failed采用/新重试及必要连接，原153/150/3/0等历史不改判。新仓内report/evidence-summary/current-implementation-identities均已完整读取核实可读；精确时间/计数/未到达、进程结束及Kotlin idle未知、ruff比较局限依原证据加工，不声称本轮重hash/检查活跃进程或全仓稳定。写后只读核对160处四文档内部链接/标题片段、配对、当前身份/预算/自检入口及三个新证据目标，均通过。首轮完整性断言提示Context缺当前自检直达入口，补齐后复核通过。Waves的Markdown分析器不可用，不当作clean；结论以实际正文/联合图/引用检查为据。不写外部会话Result路径或虚构未来产物。
- **不同Handler局部独立复审边界（本次未执行）：** Work当前范围/failed采用行/完成信号，Context新“网络失败采用与独立有限验证重试”及当前准备别名，Plan新重试策略/selector/消费和本节，Waves旧T-basic-r failed限定、新T-basic-v item/Wave/gate、P item及所属Wave、R/V/H前置/历史消费、排他/现行连接、最终第1/10款。重点核对旧failed不回填、复用修改而不重做实现、总时限/每轮新根/网络条件/正向退出与成功完整同轮合同，以及无Neo/R新屏障且最终全量不减。无变化权威、既定资源范围/覆盖损失、Q原内容/cache、D/B/M原消费者/JDK合同、最终第2–9款及整份历史不无据重审。

未执行/未检查：Gradle、Java、项目测试或重试、网络、Git、进程操作、缓存/生产/测试/fixture/配置/依赖/权威修改、备份与清缓存；检查只读且不落脚本文件。
剩余限制：网络可能再次失败，两文件新判定仍未动态验证，同轮参考/witness及P/Q/R/D/B/M/V/H实际证据仍欠；作者自检不替代不同Handler局部复审或实际gate判断，历史/资源损失与已知排除风险不关闭。

## 补丁阶段资源与 basic 恢复维护作者自检

**历史作者记录。** 本节130断言/旧图计数及当时未运行仅属T-basic-r准备阶段；其后T-basic-r已failed，当前重试维护与作者检查见下一节“basic 完整验证有限重试维护作者自检”，旧记录不证明新判定动态通过。

本节为本次 C5 维护的作者检查记录；之后各作者章节均按原时点保留，不拥有当前范围/等待。唯一终态是四份协调文档局部一致及本次自检，不是实施、运行、独立复审或 gate 放行。

- **输入与证据：** 完整读取四文档、指定 T-basic 原报告和两份只读诊断/权威评估；采纳用户已解决的资源取舍。只读现存 basic 方法/helper，并读仓内 resource-inventory、evidence-summary 和原 t9 XML 交叉定位阶段空集、无 prepared 文件、1 test/1 failure/0 errors/0 skipped 及修后仅编译/聚焦检查；不重跑归档或沿用矛盾计数。持久引用只用项目相对证据/已有公开来源，不写会话 Result 路径。
- **单一结果/证据合同：** 新 T-basic-r 只补既有 fixture 判定和完整 selector；工程/helper/入口和 LZMA 修正保留，不重建已交付工程、不先修 production namespace/cache。完整方法、独立参考、类/引用/patch checksum、同轮身份/XML/class/resource witnesses/prepared 文件仍必需；实际 production 缺失/混淆 entry 如实观察，由 P 修正。按实际 patch 阶段保存适用完整内容及合法后续工具/overlay，不恢复 raw；basic 两项真空候选仅免正向资源见证，collision 按 clean/patch 合集，空交集仍检 universal-only。1165/Neo 实有载荷、patched 优先/适用 AT/Dist/marker、自有路径隔离及 miss→rebuild→hit 不减，损失明确贯穿 P/R/V/H。
- **联合等待检查（实际只读内存脚本）：** 用 Python 标准库从 Waves 的 item 定义与五列表格解析 item→前置 item/所属 Wave、Wave→前置 gates、gate→全部成员；检查唯一非空归属、引用解析、环/自等，并从联合边求祖先与假设可达闭包。25 item、20 Wave、20 gate，共65节点/126条边；130条针对性文档/图断言通过。P 只等独立 T-basic-r item/新 gate；新恢复不等旧 T-basic failed/gate 或 P。R/V/H 必需三组现行准备/P/两组Q；D/B/M 无 R/Neo 成功前置，M 必需 P/Q-1165 且不依 D/B。所有共享 fixture/helper/Forge/Gradle/TestKit/build/cache 写运行仍串行，排他不冒充成功依赖。
- **关键反例（不运行任何 item）：** 仅21缺失、8/17与自身真实输入/权限/证据充分时，T-basic-r→P→D→B 及 T-1165/P→Q-1165→M 在联合模型可达，T-Neo/Q-Neo/R/V/H 及对应最终 gates 等待。另在全部新结果假设足证成功、全部旧失败/partial 仍固定未完成的模型中，H 可达，而旧 G-INTEGRATION/G-RECOVERY/G-BASIC-RECOVERY/G-FORGE-PATCH-FIXTURE-BASIC 均仍未满足。以上只说明依赖没有循环/错误共同屏障，不证明 JDK 可用、结果成功或实际 gate 释放。
- **保留与一致性：** 编辑前仅在内存记录46个受保护块的 SHA-256，编辑后45块逐字一致，包括原 T-basic 完成合同（排除新增历史状态提示）、其它历史 item、原 basic Wave/gate、第2–9款完整最终合同及 Work/Context/Plan 的历史记录/旧事实行。唯一变化的旧保护块为 P 的 Wave 前置改接新 basic 恢复 gate，属本次必要连接；新增 item/Wave/gate 不覆盖旧身份。逐项回读四文档现行范围，纠正“basic 工程尚未创建/仍需旧 T-basic 成功”等相反表述；旧作者记录按历史解释，三族 reuse/写入 skip、R 非 D/B/M 技术前置及最终全量合取不变。
- **可读引用检查：** 另以只读 Python 标准库枚举四文档全部335个项目相对链接（含138个 Markdown 片段），核对文件存在和标题 slug/重复序号，均可定位；不据此声称公开 URL 已联网重验或生成内容运行成功。编辑工具的 Markdown 检查通过。
- **精确局部独立复审边界（本次未执行）：** 仅本次资源阶段/两项固定 basic 空集/覆盖损失及 collision 合集合同，T-basic 已交付/failed 事实与独立 T-basic-r 的单一谓词/写拥有/现存 selector/足证据及停止边界；Waves 新 item/Wave/gate、P item/所属 Wave 的新准备连接、R/V/H 的对应显式消费、冲突/现行连接说明和最终合同第1/10款；连同 Work 现行实施范围/完成信号与 Context 的采纳/三族 reuse，核对四文档一致。另用“旧失败不转成功/缺21”反例检查这些必要连接。无变化的权威、原修复/历史执行、Q 的完整原内容/cache 合同、D/B/M 原消费者/JDK/重试合同及最终第2–9款不重开；不是全份计划复审，不替代真实运行验收。

未执行：Gradle、Java、项目测试、网络、Git、生产/测试/配置/依赖/权威修改、JDK 安装、旧状态复制或备份；检查脚本经 stdin 运行且不写文件。
剩余限制：作者自检不等于独立复审或 ready；T-basic generation1 failed、修后未完整重跑和 production namespace 未修均保留。basic 非 class clean/inject 正向与碰撞优先级动态覆盖损失不被关闭，任何必需分支缺证最终仍不放行。

## 作者历史的适用范围

以下历次作者记录逐字保留，S、P 前封存、旧 key 实物和旧 attrs 比较、计数及“当前”均只指当时。上一轮 ready 仅沿本次 Handoff 采用为历史判断，不覆盖本轮材料性谓词/依赖变更；本轮作者自检见末节，不宣称 ready。

## 作者自检

以下各“历史/本次”子节均保留原阶段记录，尚未实施和图计数等只指当时。最新当前边界与检查见末尾“真实可行性与新增范围维护作者自检”；旧token及各轮作者自检不改写为本次运行证明。

### 历史作者检查（非当前执行图）

以下完整保留先前三阶段作者记录。其中“本次”、旧节号、四修复/六 item 及 FIX-OUTPUT 只指当时版本，不是现行义务或本次重跑声明。首次 not-ready 及未实施事实不变；当前缩小范围检查另列末节。


本节保留初始准备作者检查，并另记本次输出载体修正自检；均不能代替独立复审或运行时结果。以下原检查记录不是本次重跑声明。

- 已重读两份输入Result、三族相关权威、四条生产/测试链，确认reuse，无新增/改写权威。
- 四个独立修复、最终组合及独立验收各有唯一item；Waves明确真实依赖、写入冲突、入口/gate、证据和失效边界；无Tasks双图或成功依赖伪装排他。
- 初始准备已选定到载体、身份/两输出取得、释放、直接资源URL、目录/Jar/MR及关闭边界；其中旧Properties载体风险随后被首次独立复审判为阻断，本次仅以第1节临时JDK管理载体和活动期验收替代，不把风险披露当成通过。
- 此次未运行构建、测试、临时实现或独立复审；新增反例均为待实施要求，不是通过证据。没有写运行时状态、item完成或gate释放。
- 交付末尾的本地只读检查验证四文档相对文件链接、唯一item/Wave成员/依赖引用、598个依据文件与初始哈希集合一致、Git索引不变、既有683行状态保持且仅增加本目录四文件。该检查证明交付结构与未改基线，不证明运行方案正确。

### 历史：仅输出载体修正的自检

- 重新读取首次独立复审全文、输出预约实现及相关JDK合同/源码。首次结论not-ready仍为历史事实；活动期兼容不能由结束后无残留或风险披露代替。三族reuse仅在输出独占/资源生命周期边界重新核对，未写权威。
- 以Work拥有者方法区分历史、观测、未来验收：Work/Context说明本次只修发现1；Forge fresh措辞仍待另一结果。以Plan拥有者方法检查局部载体、批量取得、最后释放、异常回滚和活动期消费者证据闭合；JDK管理对象只承载预约，不接管运行域或扩大锁范围。
- 以Waves拥有者方法复核FIX-OUTPUT仍是一个独立终态，helper、两个caller及活动期/释放回归只证明同一预约谓词。未增加item、前置依赖或写冲突豁免；预约/Properties/JMX探针仍受既有测试运行排他约束。G-REPAIRS明确消费新必需证据，G-INTEGRATION/最终独立验收沿原依赖消费它，未释放任何gate。
- 实际只读文档检查：六个唯一item各归属一个非空Wave，共三Wave；把item前置、所在Wave gate等待及gate等待全部成员合并检查，引用可解析且无环/自等。与本次编辑前内存文本逐段比较：Plan第2–4节及完整验证安排（包括Forge原文）、Waves其它五项及冲突表均未变。58个仓内相对文件链接可读，无外部本地Result路径；这些不证明运行时语义。
- 本次仅写选定四文档。未运行构建/测试/临时实现/Git，也未重复初始598文件哈希或索引检查、独立复审、确认或调度。剩余风险为JDK/权限/自定义builder边界、载体失败清理和fileKey/hardlink跨平台的实际证据；新验收尚待实施，不能据此宣称计划ready或修复已完成。

### 历史：仅Forge fresh范围修正的作者自检

- 复用Context已有PRD/ADR/Spec三族reuse；本次只将既有共享消费者的组合验证要求具体化，没有改权威、输出载体或Plan第1–4节。
- 直接枚举Forge src/test并读取当前三类、ForgeInputs、listing rules及模块构建：两类真实producer/strip/discovery消费者必须fresh，PatchedMinecraftTests保留完整模块平台回归。用实际类名替换旧表两个不存在名称，统一Plan、VERIFY-COMBINED及G-INTEGRATION；不能以旧缓存、历史131或根入口缓存命中替代最终版实际执行。
- 局部静态自检保留六项单一终态、三Wave唯一成员、四修复无成功前置、组合依赖四修复/G-REPAIRS、验收依赖组合/G-INTEGRATION及原冲突表；组合所需三类全部实际执行才能满足gate。文档要求是未来验收，不是已执行事实。
- 本次仅写四份选定文档；与编辑前文本比较Plan第1–4节、Waves四修复及独立验收定义和冲突表未变；检查仓内相对文件链接可读、图引用及合并等待无环。首次not-ready、载体待独立复审和所有未实施事实保留，无item完成或gate释放。
- 未运行构建、测试、Git、临时实现或独立复审；未重复598文件哈希/索引检查，未验证JDK/OS、权限、hardlink或运行时行为。局部规划自检不等于ready；实际三模块fresh及当前新增案例证据仍待取得。

### 本次三项范围维护的作者自检

- 当前四文档只承诺三项修复及最终组合/独立验收；输出竞争历史风险和 not-ready 留存，旧 FIX-OUTPUT 没有现行定义、成员、前置、gate 或专属测试要求，不标 completed。权威 reuse 覆盖剩余范围，未改输出独占规范。
- 显式域、重复声明、Fabric 覆盖各可独立验收和重试；其 helper/静态输入/故障迁移只建立本项谓词。组合证明同版三项共同成立，独立验收另有只读评价边界；共享写入只形成排他，不制造成功前置。
- 已实际回读四文档并完成静态核验：62 个仓内相对文件链接可读（38 个唯一文件），4 个片段目标与现存标题对应，Work/Plan/Waves 互链且唯一配对；五个唯一 item 各归属一个非空 Wave，共三 Wave。把 item 前置、所在 Wave 前置 gate 及 gate 等待全体成员合并为 8 节点、11 条边，引用可解析，拓扑检查无环或自等。三项各有单一终态、必要证据和 gate，修复间无成功前置；共享文件及 Gradle 运行排他保留。与改稿前文本比较，三项策略正文仅节号/交叉引用改变；Forge 三类 fresh、根入口及最终独立验收义务保留。该核验仅证明文档结构与范围对应，不证明运行时正确。
- 材料性变更为撤出预约执行边界及专属证据/依赖/冲突，四修复缩为三修复，组合、独立验收及 gate 收敛为三谓词。待独立复审边界是该删减、剩余覆盖、共享写串行和通往最终组合/验收的必要连接；作者自检不替代复审，不宣称 ready，不自动重开不变的权威或 Forge 规划边界。
- 仅维护同目录四份文档；未运行构建、测试、Git、临时实现、独立复审或运行时检查，未重复历史 598 文件哈希/索引核对；没有实际 item 完成、gate 释放或实施确认。

### 本次回归身份校准的作者自检

- 本 Handoff 的唯一结果是验证合同校准；校准清单、Waves 同表消费和本作者检查共同建立该结果，不执行五个实际 item。复用 Router 已采用的三族 reuse、范围排除及 Forge 三类 fresh 评估；generation 1 评估 completed/计划 not-ready 与历史 partial/blocked/failed 留存，没有改写 PRD/ADR/Spec 或输出预约选择。
- 已直接核对测试方法/断言与根及三模块构建承载链，逐个解释七个旧名的真实覆盖归属；静态解析四文档中的 49 个唯一现存方法身份，均定位到实际测试类、方法声明及邻近 JUnit 测试注解。当前完整模块表与 src/test 枚举集合完全相符；观测类数不是新验收常数，新增 Manifest、异正文/外置配置、metadata I/O 迁移和非法 UTF-8 oracle 仍须由实施 Result 记录实际方法/参数与运行证据。
- 已回读四文档并核验 92 个仓内相对文件链接（48 个唯一目标）及 15 个标题片段，Work/Plan/Waves 互链、唯一配对；七个不存在名称仅保留在 Plan 的历史映射表，Waves 不再引用它们作为可执行身份。局部三行、最终完整模块与 G-REPAIRS/G-INTEGRATION/独立验收统一消费 Plan 同一清单；共享回归列入必需执行不扩大源码写权限。必需 skip/缺跑/失败不能以原因说明豁免，根入口缓存不能代替同版 fresh。
- 五个唯一 item 各归属一个非空 Wave，共三 Wave；合并 item 前置、所在 Wave 前置 gate 与 gate 等待所有成员后，为 8 节点、11 边，引用可解析且无环/自等。与本次后续校准前的内存文档快照逐段比较：Plan 三项策略正文、风险与既有作者历史原文不变；五项单一终态、前置、失败失效边界、Wave 成员/前置 gate 及原冲突表/安全串行说明保持。故障迁移不变成新的独立结果，局部清单及 gate 只校准必要证据承载。
- 需局部独立复审的材料性边界：七个旧名到实际方法/断言及共享回归的归属、SafeRetention 与 Fabric side/producer 补漏、现存/待新增反例和旧探针迁移的区分、实际测试写范围，以及同一清单通往局部验证/最终同版 fresh/gates 的必要连接。不重新打开已闭合的权威、Forge 范围或用户排除的预约载体选择；作者检查不等于 ready、实施确认、实际 item 完成或任何 gate 释放。
- 本 Handler 仅写本目录 Work/Context/Plan/Waves，未改生产、测试、fixture、资源、构建或权威，未运行构建测试或 Git 写操作，未实施独立复审。未重复历史 598 文件哈希/索引检查或证明全仓干净，也未取得新增反例、JDK/OS、MR/编码/句柄、默认解码或三模块 fresh 的运行证据；输出竞争排除风险及既有 498 项等价等盲区不因此关闭。

## 首轮恢复计划维护作者自检（历史）

以下为前一轮原记录；其中“两个恢复”、合并 Forge item、API 与 consumer 已核对的判断后来被独立复审指出错误，不能作为当前可执行依据。错误陈述由上文恢复二及末节本轮纠错自检取代，原失败/完成与既有历史不重写。

- 唯一交付是配对四文档维护。已消费 Handoff 全部范围/限制、四个 Skill、四文档、首轮报告和三失败映射，采用两个独立只读诊断并核对当前 SPI、测试、两个脚本、原 Java consumer 和现存任务/输入读取链；没有把诊断结论写成修复验证通过。
- authority/scope：五份现行权威 SHA256 与 Context 历史表一致，沿用三族 reuse，权威写入 skip；这是测试合同及现存 task caller 恢复，不引入新产品/架构承诺。输出竞争、JMX/预约、旧全量 partial、静态迁移收口、StripStreamTests 例外、工具链/依赖及既有 fixture 参数边界不变。
- 两恢复各自有单一终态、实际写拥有、最小/整类验证、失败和停止条件；Mixin 覆盖实际声明名/传入 root/真实异常/可选 side/snapshot/原输入/retry，Forge 明确 current properties、userdev/MCP/patch tools/universal/libraries、official→MCP mappings 读取顺序、srg→named、真实 Java8 consumer/compileJava/jar。核对的是当前源码输入链，未宣称远端解析、产物或编译已经成功。
- 原 FIX-RESOLUTION、FIX-DISCOVERY、TEST-FABRIC-UTF8、VERIFY-COMBINED 的四个 item 正文及 W-REPAIRS / W-INTEGRATION 两个原 gate 行逐字保留；三个局部 completed 与首次组合 failed（153/150/3/0）、G-INTEGRATION 不满足都有项目内证据引用。各历史作者/评审/partial/blocked/failed 记录保留原阶段语境，无外部 session/result 路径或伪造诊断产物。
- 图检查合并 item 前置、所在 Wave 前置 gate 及 gate 等待全部成员：8 个唯一 item、5 个非空 Wave、13 节点/30 条边，引用可解析、唯一归属、无环/自等。两恢复无相互成功依赖；共享 Gradle/build/fixture/cache 运行排他，有明确串行路径，failed 组合只作失败依据，不作为必须先成功的恢复前置。
- 新 G-RECOVERY 仅检查两个恢复 Result；G-RECOVERY-INTEGRATION 逐项重建原 V 合同并加恢复 R（V ∧ R），覆盖首轮153加全部当前案例、fresh 三模块、Forge 三类、根入口成功末端、内容一致及原始证据分存。原 gate 不自动满足，REVIEW-ACCEPTANCE 仅经新实际复验连接并由不同 Handler 消费原局部/恢复 Result。此连接仍须受影响边界独立 review 与 Router 的范围 Disclosure/确认，本次不判断 ready 或释放。
- 实际静态复核通过：131 个仓内相对文件链接、65 个唯一文件目标及26个标题片段均有效，Work/Plan/Waves 唯一配对互链。排除本四文档后的887个 tracked/untracked 路径（含既有缺失项）内容/路径综合指纹前后相同，Git索引 SHA256 和首轮 report.md / failure-map.json SHA256 均未变，五份权威版本与历史表一致；本次只通过 edit 写这四文档。该检查不认证忽略目录所有历史二进制或全仓干净，也不替代构建、测试、运行验证或独立评审。

剩余技术缺口：真实 userdev/MCP/libraries 解析、Gradle provider/依赖闭合、产物 namespace、Java8 toolchain 和两份 consumer 的编译尚未运行；若现存能力不足即停止报告生产能力/范围缺口。Mixin 的确定性删除/read 故障与 retry 也仍待实施证明。未实施或运行任何恢复/复验；输出竞争及原全量/跨平台等价盲区不因此关闭。


## 本轮计划维护作者自检

以下保留为前轮 API/consumer/两 Forge 拆分的作者记录；其中9 item/5 Wave及仍欠 Mixin 实施等判断仅指当时。本轮最新采用事实见 Context，标准属性维护的实际检查见末节，不把旧“本轮”当作当前运行证据。

- 本 Handoff 是一个局部计划纠错谓词：四文档与本自检共同建立当前任务 API、真实 consumer 和独立恢复边界的一致性；不执行未来 item。已完整消费指定四 Skill、四文档、独立复审 completed/not-ready Result 和内联约束，复用三族 authority assessment；PRD/ADR/Spec 仍 reuse、写入 skip。
- API 及来源按当前源码重核：ResolveMinecraftMappings.server 必填且显式 false；LoadMappings 无 sourceNamespace，javaExecutable 显式接 Java8 executable provider；选用 RemapTask.inputFile/mappings/classpath/outputFile，source 无默认，target 显式 named，RemapJar 单列真实 archive API。provider 输出保留 producer 依赖；userdev/MCP、patch tools、universal/inject/AT、适用 libraries/modules 约束、official→MCP 顺序和实际 srg→named 的核验责任均落到相应原工程，详细源码证据见 [Context 纠错表](context.md#独立复审发现的局部纠错依据)。
- consumer 已逐行回到两份现有 Test.java：basic 的 EVENT_BUS / MinecraftServer.main，remapped 的 EVENT_BUS / named Entity.class，仅证明 Java8 类/成员可见性、namespace 和真实 Jar 消费；撤去不存在的继承/override 承诺，不增加 Java 源码写范围。AT 行为仍由现有真实 AT 兼容测试承担。每个 Forge 恢复只按自己方法/产物链验收，完整类和三类 Forge fresh 留在独立最终复验。
- 单终态检查：Mixin、basic、remapped 各可独立成功、失败和重试，各一个 Handler/Result；两个工程没有互相消费的产物或成功前置，共用 PatchedMinecraftTests.kt 的必要取证接点及 Gradle/build/fixture/cache 形成排他冲突。Mixin 恢复策略不重复设计。唯一图有9个 item、5个非空 Wave；合并 item 前置、所在 Wave gate 等待及 gate 等待所有成员为14节点/34边，无自等或环；三个恢复只在 G-RECOVERY 汇合，原 failed 组合不成为须先成功的恢复前置。
- 恢复、复验和验收的必要连接同时维护：G-RECOVERY 要求三个独立 completed Result 和对应足证据；VERIFY-RECOVERY 及独立 REVIEW-ACCEPTANCE 都引用三项。新复验继续完整满足 V ∧ R：原三局部成果关联、首轮153加全部当前方法/参数、三模块同版完整 fresh、Forge 三类、根入口成功末端、版本/环境/内容一致及 fresh/根重跑分存，任何必需失败/skip/缺跑不能豁免。旧 VERIFY-COMBINED failed、153/150/3/0 和 G-INTEGRATION 不满足保留，新 gate 不自动改写它们。
- 历史保留检查覆盖原三策略、Mixin 恢复原文、原四 item 与旧两 gate、Context 历史章节及既有作者记录；只在需要的恢复分组/消费者/引用上纠错。前轮错误的作者判断已明确标为历史并指出替代位置，不删除旧完成/失败/partial/blocked。相对引用、图引用和写边界的实际静态核验结果随本次 Result 返回；持久化只引用已核实可读的项目内相对文件，不写外部 Result/session 路径。
- 实际静态核验通过：API/consumer/固定版本源码断言，9 item / 5 Wave / 14 节点 / 34 去重边的合并等待图无环且唯一归属；156 个项目内相对文件引用（72 个唯一目标）可读、31 个标题片段存在，Plan/Waves 唯一互配。五份权威 SHA256 与保留表一致；排除此四文档的受保护路径/证据共889条（tracked/untracked 路径含既有缺失项，另核首轮报告和失败映射），其内容指纹与 Git 索引 SHA256 前后相同。该集合不覆盖全部忽略目录二进制，也不证明全仓干净或运行正确；以显式引用/图/源码静态核验为据，Markdown 诊断不替代这些检查。
- 材料性纠错限于实际 API 接线计划、consumer 证据语义、两 Forge 独立边界及必要连接；不宣称独立 ready、实施确认、实际 item completed 或 gate 释放，不安排其它工作。只改本目录四文档，未运行任何恢复实现、Gradle/构建/测试、独立复审或 Git 写操作。

仍欠的证据：真实 userdev/MCP/工具/libraries/modules 解析、provider/variant/任务依赖、实际 namespace/Tiny 树、Java8 launcher/compiler 和各 consumer class/Jar 的运行产物，以及 Mixin 确定性 I/O/retry 和完整同版 fresh/根入口。以上均保留为未来验证；实际能力不足时必须报告具体范围缺口。输出竞争、静态迁移历史、全量 partial、498 项历史等价及跨平台盲区仍排除，本轮文档纠错不证明其已解决。

## basic 标准属性接线维护作者自检

以下保留为前轮作者记录；关于发现证据可达性、共享属性影响和两文件授权的不足已由 `review-basic-java8-recovery` generation 1 指出。历史自检不证明当前独立 ready，纠正与实际检查见末节。

- 本 Handoff bundle 只有一个可观察结果：选定四文档的有界 C5 维护与作者自检。已读取 primary/两个 companion Skills、治理合同、指定四文档、两个完整运行时 Result 和全部内联约束；复用三族 reuse/写入 skip。四文档互链、匹配且只有 plan.md/waves.md 一对，无 Tasks。此次不执行恢复、不运行 Gradle/构建/测试、不作独立评审，不推进 item 或释放 gate。
- 主动检查单终态后，basic 未完成边界细化为“标准属性两边界并实际发现 Java8 compiler”和“当前脚本完整真实产物消费”两个新结果，各一个 item/Handler/Result。发现成功在后续 patch 失败时可以保留，产物项消费发现项且继续原全部合同；不以仅找到 Java8、候选存在、脚本配置成功或缓存替代 basic 全部验收。内部两边界转发及消费证据链没有新增独立消费者，不额外拆项。remapped 仍独立，未增加标准属性 runner 接线授权。
- 本轮材料变更：Work 反映已采用 Mixin completed、旧 basic blocked、新写边界与当前完成连接；Context 记采用事实、源码追踪限制和用户明确授权；Plan 增加标准属性/实际选择/原产物合同及风险，保留验证强度；Waves 增加两个新 item、一个 Wave/gate，修改复验/验收必要前置和冲突。新增两处接线仅 Forge Test 的 Provider→同名系统属性与 basic runner→同名 -D；空/缺失不传空/null，不硬编码、不新增 fixture.*、不改配置/生产/consumer/版本，保留 Java17/withDebug 与 Java8 consumer。
- 图自检实际通过：11个唯一 item、6个非空 Wave/6 gate，每项唯一归属；合并 item 前置、Wave gate 等待和 gate→全部成员得到17节点/41去重边，无环/自等，所有引用可解析。产物项只等待发现项与原 G-REPAIRS，不等待本 Wave gate；新复验等待 G-BASIC-RECOVERY 及 Mixin/remapped 各自 completed/足证据，不等待旧 blocked 转成功。安全串行路径消除共享 Forge Test 配置、PatchedMinecraftTests.kt 和 Gradle/build/fixture/cache 冲突，不把冲突误作 remapped 的成功依赖。
- 历史/完整性检查实际通过：逐字比较保留的原三项策略/Mixin 恢复、此前作者历史、Context 历史、原四实现 item、remapped item 和 Waves 历史6个块；原完整模块验证清单、G-REPAIRS/G-INTEGRATION 原行及 G-RECOVERY-INTEGRATION 第2–8款另行比较，合同不变。13个本次读取的构建/测试配置与脚本、仓内报告/失败映射及五份权威文件的 SHA256 前后相同；不是全仓状态或忽略目录审计。本轮仅编辑四文档，没有新造报告或写外部 Result/session 路径。
- 四文档的174个本地 Markdown 引用全部落于仓内可读文件，标题片段全部解析；未发现外部本机绝对/用户目录/file URI/Result 定位。公共 Gradle9.4.0 源码 URL 是已采用追踪的来源，不声称本轮重新远端读取。Markdown 分析器曾报告不可用，未以空诊断充当通过；结论依据本次实际执行的只读 Python 文档/图/引用/内容核对及语义自检。
- 原三局部/Mixin completed、旧 basic blocked/三失败/最终脚本未运行、首次153/150/3/0与旧 G-INTEGRATION/G-RECOVERY 不满足、其它 partial/failed/blocked 和输出竞争排除均保留。新恢复前置为 F ∧ D ∧ B ∧ M，最终新 gate 完整要求 V ∧ F ∧ D ∧ B ∧ M ∧ H；没有删减三模块 fresh、Forge 三类、根入口、同版/输入一致性、首轮所有案例/新增恢复或任一原 basic 来源/namespace/provider/Java8/产物义务。Mixin 顺序偏差及真实 I/O/retry 已采用证据保留，不重放独立效果，最终 fresh 仍全部覆盖。

供不同 Handler 独立复审的材料边界为本节所列 basic 两个终态、标准属性两处写拥有、共享 Test 对 remapped 的影响/排他、旧 blocked 与新放行关系、原完整验证义务及采用事实一致性。作者不声称 ready、C4/C6 或实施确认/独立复审通过。实际剩余风险是当前 zulufx8 与旧 zulu8 非同一证据、实际 compiler 选择未验证、最后脚本未运行、来源/namespace/provider/产物链尚缺、绝对列表之外路径语义未纳入，以及原输出竞争和全量 partial/等价盲区。本次没有验证任何运行行为或重新查询活跃构建。

## basic 三项复审阻断纠正作者自检

- 本次唯一终态是匹配四文档对三项复审阻断的有界纠正及作者自检。编辑前已完整加载 documentation-waves-writing、documentation-plan-writing、documentation-work 和相关治理规则，读完所有指定 context（含完整独立复审 Result）与内联授权；复用三族 reuse、写入 skip。此次只写四文档，不执行未来恢复、复验或独立验收，不推进 item/gate，不作 Git 操作。
- 发现1落在上文标准属性合同与 Waves 发现项：明确现有 basic printCompileClasspath action 的 compiler/metadata 两行、forwardOutput/异常保存及 invocation 对应；patch 提前失败未到达或缺实际证据时发现项保持未完成。没有加入探针、替代入口或任意失败必能完成发现的承诺。实际 compiler 选择仍是必要证据，不用候选/属性/配置成功替代。
- 发现2落在 basic 自身观察、remapped 自身恢复观察、最终复验及 G-RECOVERY-INTEGRATION 第9款和独立验收：两 invocation 分别记录最终 arguments 与 nested 属性/StartParameter/effective toolchain/实际 compiler；现有 withDebug 的运行帧只读观察不可用或未到达就留缺口，不能由外层 Test 快照或 remapped 无新增 -D 推定无影响。remapped 不成为发现项提前执行前置，不新增独立 Result；观察属于各自原消费/选择合同及最终验收的证据。有真实影响则报告，不扩展 runner 接线或擅修越权行为。
- 发现3采用 [Context 的 Router 权限澄清](context.md#basic-三项复审阻断的局部纠正)，同步 Work、Plan 和产物 item：原 basic caller 脚本/必要既有取证接点的恢复权限从未撤销，后续“可以”仅增加两处标准属性接线。保留上一 Handoff“授权仅两文件”造成的冲突及 completed/not-ready 历史，不记新用户决定、不增加批准轮次、不重做已完成效果。remapped 保留原独立脚本恢复权限，无新增 runner -D 转发权限。
- 实际图检查：11个唯一 item、6个非空 Wave/6 gate，各项唯一归属；联合 item 前置、所在 Wave gate 等待、gate 等待全体成员为17节点/41去重边，引用可解析且无环/自等。与编辑前图比较，成员、前置及全部 Wave/gate 表不变；发现→产物是真实依赖，remapped 无 basic 成功前置。共享 Forge Test/测试文件和 Gradle/build/fixture/cache 的排他规则与安全串行说明保留；发现项不等待自己的 gate、remapped 或旧 blocked 转成功。
- 实际保留检查：对编辑前读取文本归一化连续换行后，9组正文比较一致，涵盖 Plan 原三策略/Mixin 恢复、原完整模块清单/主要全量验证、旧作者历史、Context 首次失败及后续历史、Work 原结果表、Waves 原四项/两旧恢复、最终 gate 第2–8款、旧图历史及全部 Wave/gate 表。四份当前构建/测试/fixture 源码、五份权威、四份旧恢复/组合证据共13文件 SHA256 与编辑前一致，五权威亦与 Context 历史表一致；不是全仓或忽略目录审计。原 basic 完整合同、三模块同版 fresh、Forge 三类、根入口、内容一致性、首轮153加全部当前案例以及独立验收义务未减。
- 实际只读引用检查通过：四文档186个本地 Markdown 引用对应74个唯一仓内可读文件目标，47个标题片段全部存在；Work/Plan/Waves 互链且仅一对 plan.md/waves.md，无 Tasks。外部本机路径/Result locator 扫描无匹配；9个公共 URL 沿用来源，未重新远端验证。首轮扫描的盘符正则误将 https 尾部 s:/ 识别为盘符，收紧词边界后重跑通过，没有因此修改文档来源。Markdown 分析器对部分编辑报告不可用，未以空诊断当作通过；正文比较、图检查与引用核验均仅为作者静态自检，不是独立 review 或运行证据。

局部独立复审的材料边界是三项纠正及其必要连接：发现项现有观测源和提前失败未完成规则、两 invocation 的实际观察归属与最终 gate/验收消费、原 basic caller 权限一致性、原合同和历史保留、排他与合并等待无环。原三项已完成效果、Mixin 19通过及顺序偏差、旧 basic blocked/三失败/最终脚本未运行/无产物、首轮153/150/3/0和旧 gate 不满足继续保留；本次没有新的实际 completed 或 gate 释放，也不声称实施 ready。

未实施或运行构建/测试、compiler/属性观察、产物恢复、fresh/根入口或独立复审；实际 nested 观察能力、最终 compiler 选择与产物仍待验证，若提前失败无证据就保留未完成。原输出竞争排除、全量 partial/等价/跨平台盲区继续存在。


## basic Java8 独立重试图维护作者自检

以下为此前单次重试准备的作者记录；其12 item/7 Wave/19节点/43边与未执行文字以当时为限。该次复审已 completed/ready，实际调用后来为 partial；本轮事实和自检见末节，不以历史作者检查替代。

本节是本次 C5 四文档维护的实际作者记录，取代此前作者记录中关于“当前”图的时点描述，不改写任何历史事实或宣称独立 ready。

- **单一结果及授权：** 完整检查 Handoff 的 objective/constraints/deliverables 为一个可观察图维护终态，四文档更新与自检均仅服务该终态。编辑前完整加载 documentation-waves-writing、documentation-plan-writing、documentation-work 及必要治理合同，读取全部指定 context（含原 partial 完整 Result 和仓内报告），复用三族权威 reuse/写入 skip。仅写本目录 work.md/context.md/plan.md/waves.md；本次不执行任何测试、构建、Git、网络探测、重试、产物恢复或独立复审，不选择后续工作、不推进新 item/gate。
- **粒度与组合依据：** 原 RECOVER-BASIC-JAVA8 partial 保留成功接线及旧同轮14条 nested 观察/失败/860文件原无漂移与 git status/.git 不保证偏差；仅新增一个运行验证重试 item/Handler/Result，只有正常运行/新取证写权限。新谓词为保留接线在一次原方法中的全部同轮 Provider/Test/args/nested 属性/StartParameter/effective installations/实际 compiler 两行及共享语义，旧观察不拼接；不重做接线、不改 basic 脚本、不并入产物修复或 remapped。W 与 D_retry 对应原完整 D，后继仍要求独立完整 B，最终 V ∧ F ∧ D ∧ B ∧ M ∧ H 不变。
- **联合等待实查：** 解析当前 Waves 得12个唯一 item、7个非空 Wave/7 gate、各项唯一归属；合并 item 前置、所属 Wave 前置 gate、gate 对全部成员等待为19节点/43条去重边，引用均可解析，无环/自等。新重试只等 G-REPAIRS；产物项改消费新重试、仍归原 W-BASIC-RECOVERY 且不等自己 gate；最终复验改等新重试 gate 并显式等待产物/Mixin/remapped。原 partial 及旧不满足 gate 不成为新路线须先转成功的前置。remapped 无 basic 成功依赖；排他表及安全串行说明覆盖共享 Forge Test/测试文件、build/TestKit/fixture/cache、最终输入写入和验收固定证据。
- **合同及历史实查：** 对编辑前完整文本逐字比较，原六个未改 item（原三修复、VERIFY-COMBINED、Mixin 恢复、remapped）正文不变，原 JAVA8 item 的完整谓词/写拥有/证据正文保留，只加采用 partial 的历史限定；W-REPAIRS/W-INTEGRATION/W-RECOVERY/W-BASIC-RECOVERY/W-ACCEPTANCE 原 gate 表行逐字保留，G-RECOVERY-INTEGRATION 第2–8款逐字保留。另比对 Plan 原三策略/Mixin 恢复、完整模块表及旧作者记录、Context 旧历史、Waves 历史和 Work 旧结果表，均保留。基本来源/namespace/provider/Java8/产物、全部当前案例/首轮153映射、三模块 fresh/Forge三类/根入口/内容一致性/不同 Handler 验收均未弱化；原发现 partial 和原 Wave/gate 不满足不被新成功回填。
- **证据及可移植实查：** 四文档195个本地 Markdown 引用对应75个唯一仓内可读文件目标，53个标题片段均经核对（本节标题补入后再作最终完整检查）；Work/Plan/Waves 唯一配对互链。对已引用源码、五份权威、旧恢复/组合报告及原 Java8 证据目录共114个受保护文件逐一 SHA256 比较，与编辑前相同；不认证全仓、所有忽略文件或 .git 元数据未变。外部本机路径、session/Result locator、file URI 无新增持久记录；公共 URL 沿用已采用来源，网络只记录 Handoff 加工事实，不造只读报告。路径扫描曾命中旧作者记录中作为反例提及的 s:/ 字样，按真实路径形态收紧后通过，未删除历史或修改来源。
- **受影响独立复审定位：** Work 当前阶段/采用表/完成信号；Context 新 partial 与重试依据；Plan 标准属性合同、单次验证/局部 selector/最终消费及风险；Waves 新重试定义、产物/复验/验收前置、排他、新 Wave/gate、完整合同第1/9款和 partial 后现行等效连接。复审应重点核对旧 partial/成功接线与新完整运行证据组合、旧 gate 保留且新路线不自锁、所有真实冲突、原验收义务和便携证据。仅作者自检完成，受影响边界仍需不同 Handler 独立复审；本记录不提供实施确认、实际 item completed 或 gate 释放。

未运行重试或任何测试，不声称原方法已重试/通过；网络仍可能再失败，compiler action/真实 nested 观察可能未到达或缺证，届时仍未完成且只保留失败证据。实际 Java8/产物、最终 fresh/根入口和独立验收仍欠；输出竞争排除、全量 partial/498项等价及跨平台盲区不因此关闭。

## basic Java8 有限网络重试维护作者自检

以下为此前有限批次准备的历史作者记录，13 item/8 Wave/21节点45边及“没有实际Result”以当时为限；批次后来failed，最新采用/连接与本轮检查见末节。

本节只记录本轮四文档维护与作者检查，不是独立复审、实施确认、实际item完成或gate释放。此前“本次/现行”按各历史阶段解释，旧单次重试复审completed/ready不覆盖本轮有限安排。

- **采用事实与范围：** 两份Java8发现generation 1 Result均保留partial，原两处接线和Mixin/原三项completed不重放。旧单次重试2026-10-22 05:01:03–05:03:52 UTC、launchermeta.mojang.com UnknownHost、1 execute/0 pass/1 fail/0 skip、Gradle exit1、compiler action/两行未到达均与仓内报告对应；原外层Provider无直接对象帧、解码损失、.git未知和未触发终止分支限制原样保留，不把旧报告的散列结论说成本次重验。
- **单项结果与有界策略：** 新RECOVER-BASIC-JAVA8-BOUNDED-RETRY只证明未完发现，一个Handler/一个Result。内部最多3次，从新批次首次实际调用起总30分钟，包含暂停/取证/间隔，不消耗或续接旧已结束调用；前次已结束、证据分存、副作用可判且明确临时网络失败才可继续。非网络、影响未知、观测失效/输入漂移或上限即停。逐次日志/XML/异常/UTC/退出码与完整Provider/Test/runner/nested/System/StartParameter/effective installations/现有action实际Java8 compiler及languageVersion=8唯一关联，只认某次完整同轮证据，禁止跨轮拼接。外层Provider限制不升级为直接观察，缺证不放行。
- **配对与证据链接：** 已回读四文档并只用内存文本解析及文件读取检查。Work/Context/Plan/Waves共73处内部互链/标题片段可解析，另72个唯一仓内相对目标实际可读，包括两份partial报告；没有以外部session/Result绝对路径建立持久依赖。新运行目录仍是待执行输出，本次没有虚构新日志/XML/结果。
- **联合图检查：** 13个唯一定义item各归属一个非空Wave，共8 Wave/8 gate；合并item前置、所属Wave前置gate、gate等待全部成员为21节点45条唯一等待边，所有引用可解析，无环/自等。新有限item只等G-REPAIRS；产物只等新发现完整结果而不等自己Wave释放；最终复验保留显式产物/Mixin/remapped等前置，remapped没有basic成功依赖。共享Gradle/build/TestKit/fixture/cache及相关输入写入继续排他。
- **历史与合同保全：** 与维护前文本逐段比较，Plan原三项策略、Mixin恢复策略和完整模块表不变；Waves原三修复、旧组合、Mixin、旧basic、旧Java8发现、remapped定义未变，旧单次重试的原谓词正文保留。原W-BASIC-RECOVERY/G-BASIC-RECOVERY与W-BASIC-JAVA8-RETRY/G-BASIC-JAVA8-RETRY成员及完整gate行保持，不因新结果变completed或释放。最终gate第2–8款全文未变，第1/9款只连接新发现及两次partial保全；完整basic来源/namespace/provider/Java8/consumer产物、独立remapped、同版三模块fresh/Forge三类/根入口/不同Handler验收义务均保留，D不能代替B。
- **受影响局部复审边界：** 最新两次partial采用、新旧item/预算身份划分、明确网络分类/再试条件/停止与逐次取证、同轮完整谓词和Provider限制、新gate与产物/复验/验收连接，以及item/Wave/gate联合等待和共享资源排他。只对这些材料性变更及必要后继审查，不重开不变权威/已完成修复；本作者自检不宣称独立ready、决定后继或执行计划。
- **仍未满足：** 新有限发现没有实际Result，旧两次partial及相关旧gate仍不满足，完整basic产物、remapped、最终fresh/根入口和不同Handler验收仍欠各自实际证据。网络仍可能反复失败，compiler action可达性和共享属性语义必须实际取得；任何新证据缺口均保持未完成，不能由规划、自检或旧ready评估抵消。
- **未执行与限制：** 本轮编辑工具只写本Work的四份文档；未运行shell/命令验证、Gradle、Java、测试、网络探测或Git，未修改源码/脚本/配置/权威/锁/依赖/网络/JDK设置，未新建产物或运行机制。没有重新散列全部源码/历史证据或检查进程/运行时；文件可读和静态图检查仅证明文档结构及保留关系，不证明未来运行成功。

## 有限发现失败后的恢复图维护作者自检

以下是上一地址恢复准备的作者历史，14 item/9 Wave等及“本次”以当时为限；RECOVER-BASIC-JAVA8-RECOVERY后来failed，最新token图与自检见末节，旧静态检查不作新执行通过。

本节只证明本次选定四文档的维护及作者静态自检完成，不是独立复审、ready、实际item完成或gate满足；此前有限批次准备的“本次/当前/未运行”及计数均为历史。

- **单一结果与依据：** 编辑前检查Handoff完整objective/constraints/deliverables为一个四文档图维护终态；加载Waves主Skill及Plan/Work拥有方法，完整读取指定四文档、失败报告和解码的诊断generation 1 completed原Result，采用内联Router授权及既有三族reuse/写入skip。不持久化外部Result定位，不造诊断报告前置，不改权威。
- **采用与时间：** 有限generation 1 failed及两份partial均不改判；唯一原调用126.646381秒/exit1、JUnit全部unknown、无nested/compiler两行、没有第二/三次。batch起点到控制器取样127.419859秒、到最终取证取样928.458591秒和间隔801.038732秒分别保留；后者不是额外调用或脚本连续运行，取样均非精确全部落盘完成。旧窗口已过，不续剩余次数/batch-start。已存860/101清单同键同值和7输入稳定、07:17:33Z进程/监听快照及daemon未查idle均以诊断范围为限，未当成本轮重hash或当前排他。
- **分组与足证据：** 新RECOVER-BASIC-JAVA8-RECOVERY把新目录临时控制链必要纠正、录制输入/内存替身离线检查、某一次原方法完整发现作为一个谓词；工具无独立发布/Result/消费者，离线通过不等于发现成功。匹配/提示符/分段/EOF/超时、身份/退出未知不终止或再试、单deadline及旧成功观察/真实停止链未验证限制明确；不修项目实现。basic完整B、独立remapped、最终V和独立验收保持独立终态，D不代替B，不拼旧轮。
- **联合等待实查：** 对当前内存图解析得到14个唯一item、9个非空Wave/9 gate，每项唯一归属；合并item前置、所属Wave前置gate、gate对全部成员等待为23节点/47条去重边，引用可解析、无环/自等。新恢复只等G-REPAIRS；产物前置改消费新恢复，不等自己Wave的gate。最终复验改等新gate且保留显式产物/Mixin/remapped，验收消费新恢复与failed/两partial，remapped无basic成功依赖。所有共享构建/取证/输入写入排他保留。
- **合同保全实查：** 与编辑前文本逐段比较，10个历史/未变item的原谓词正文保留（包括旧有限failed），原7条未改Wave/gate行及最终gate第2–8款逐字保留；仅新增一个item/Wave/gate，调整产物/复验/验收和第1/9款必要连接。Plan原三策略、Mixin恢复及完整模块清单未变；原完整basic来源/namespace/provider/Java8/产物、首轮153到全部当前案例、三模块fresh/Forge三类/根入口/输入一致性/不同Handler验收要求未弱化。旧failed/partial/blocked/gate不满足与原三修复/Mixin已完成效果均保留。
- **材料和便携自检：** 四文档79处内部文件/标题互链均在当前内存文本中解析，Work/Plan/Waves唯一互配；新引用的仓内失败报告已实际读取可读。新内容不落外部session/Result本机路径；没有声称重新检查全部既有源码链接、全树hash、Git索引或忽略目录。实际编辑仅本Work的work.md/context.md/plan.md/waves.md，最终回读核对写入内容与作者检查对象一致。编辑工具曾报告Plan/Waves的Markdown分析不可用，未将其视为clean；本节结论依据实际内存正文/图/互链检查及回读。
- **局部独立复审边界：** failed/诊断/三时间口径采用及限制，必要临时控制链纠正与单Result内部检查的分组/权限，原同轮发现合同、新独立目录/预算/再试/停止/身份/当前排他前置，旧item/gate保留，产物/最终复验/独立验收的必要连接与联合等待。需不同Handler只读复审这些材料变化及连接；不重开不变权威或已完成修复，不选择/调度续作，本自检不作放行。

本轮未执行命令、Gradle、Java、测试、离线工具自检、网络或Git，未修临时工具/源码/配置/依赖或改旧证据；静态文档核验不证明新自动attach/真实停止链、compiler/产物、最终fresh/根入口或独立验收通过。网络与compiler action可达性仍未知，原Provider/.git/解码及输出竞争排除、全量partial/498项等价/跨平台盲区继续保留。

## 真实 token 失败后的恢复图维护作者自检

本节只记录本轮四文档维护及作者静态检查，不是独立复审、实施确认、ready、item完成或gate释放；此前所有“本次/当前”和图计数均限定于原历史阶段。

- **单一结果、authority与写边界：** Handoff完整objective/constraints/deliverables只要求同一恢复图维护终态；加载指定Waves主Skill与Plan companion，完整消费四文档、指定诊断JSON和仓内failed报告及内联授权。采用三族PRD/ADR/Spec reuse/写入skip和Router已确认范围，无权威变更或新用户决定。只编辑本目录work.md/context.md/plan.md/waves.md，不新增Tasks/其它产物，不修临时工具/源码/测试/配置/依赖/锁/旧证据/Result，不做Git/网络/进程操作或调度。
- **采用与单终态：** 原RECOVER-BASIC-JAVA8-RECOVERY generation 1 failed、11.737990秒/exit1/JUnit全部unknown/无认领与观察/未重试、晚到退出/idle、两轮45项不同hash和诊断仅内存纠正的限制按源保留。更早有限failed、两partial/成功接线、basic blocked、首轮153/150/3/0、原三项及Mixin completed原样保留，不重放。新RECOVER-BASIC-JAVA8-TOKEN-RECOVERY一个item/Handler/Result，必要token/身份交接纠正、真实原快照直接消费的离线回归只服务某次同轮完整发现，无独立工具产品/消费者/Result；完整B、remapped、最终复验与验收不并入。
- **证据、权限与预算：** 原始成对ASCII39边界、完整token负例、真实未预处理processes/listeners直入实际纯候选的旧零候选/新原PID正例、command UTC代理的时间限制、candidate→重新认领四字段与attach前监听归属、未知/变化拒绝路径全部落到新item和gate。已修地址/观察控制复用，不重复实施；仅新目录最小临时纠正/离线取证和原入口正常副作用，不增生产机制/通用runner/真实停止专项调用。新单deadline/每次执行保全余量、正向退出/分存/副作用可判/明确临时网络才再试、非网络或未知即停不减；旧预算不续，晚到退出不恢复旧资格。录制输入/内存替身只说明局部，不证明真实创建/attach/完整停止链或发现完成。
- **联合等待、唯一归属及引用实查：** 实际以本轮编辑前/后内存文本解析：14 item/9 Wave/23节点/47边变为15个唯一item/10个非空Wave及对应10 gate、25节点/49条去重等待边。每item唯一归属，联合item前置、所属Wave前置gate、gate等待全部成员，无未解析引用、环或自等；只增加新item→G-REPAIRS与新gate→新item，原产物/复验/验收的4条旧成功等待替换为新发现/gate，旧item/Wave/gate仍在图中。四文档235个本地Markdown引用对应86个唯一仓内目标均实际读取可达，72个标题片段全部解析；Work/Plan/Waves互链且唯一配对，外部本机/session/Result locator扫描无匹配。检查只证明所读文件与文档结构，不是运行证据或全仓审计。
- **原合同与历史保留实查：** 37项静态断言通过：10个未受影响item全文不变；旧RECOVERY仅加failed采用说明，其原完整谓词/写边界/证据正文不变；8条既有Wave/gate完整表行逐字保留（W-REVERIFY仅换新gate等待），新增独立行。Plan原三策略/Mixin/Forge API/basic标准合同及完整模块源码表、最终gate第2–8款逐字不变；旧Plan作者/Context历史除明确时点标签外保持，Work全部旧采用表行原文保留。第1/9款只必要接入新发现与最新failed/诊断限制，不降低原B/M/V/H；没有新运行完成、旧结果回填或旧gate释放声明。
- **足证据与必要后继：** 原Provider关联及无直接对象帧限制、Test/唯一同名-D/nested System/StartParameter两map/effective installations/现有printCompileClasspath action实际compiler executable及metadata8/共享语义保持同轮完整，不拼旧14条或不同attempt。basic产物、最终复验/验收只改消费新发现及旧failed/诊断历史；remapped独立且无basic成功前置，共享文件/构建资源排他不变。原完整来源/namespace/provider/实际Java8/consumer产物、三模块fresh/Forge三类/根入口/全部当前案例及不同Handler验收不弱化。
- **精确局部独立复审边界：** Work当前采用/完成连接；Context最新token failed与身份交接静态缺口、晚到退出及离线版本限制的加工；Plan最小纠正策略/真实快照回归与时间界/同轮证据/selector/风险；Waves旧RECOVERY failed保留、新TOKEN-RECOVERY item/Wave/gate、candidate→identity四字段及attach前监听拒绝、单预算/再试/停止/当前排他、产物/复验/验收必要前置、最终gate第1/9款、等效合同与联合等待。只审查这些材料变化及其必要连接，不重开不变权威/已完成修复/输出竞争排除或全量验收边界；本作者检查不替代不同Handler局部独立复审，也不选择后继。

本轮未运行Gradle、Java、测试、离线工具、网络、Git或进程操作；未重新散列全仓/旧证据、重查活跃进程或认证.git/全仓干净。实际token纠正回归、真实认领/attach/完整停止链、compiler/产物、最终fresh/根入口及独立验收均未验证；Provider/.git/解码及输出竞争排除/全量partial/498项等价/跨平台盲区继续保留。

## 副作用再试判据局部维护作者自检

**历史作者记录。** 下述逐文件分类/sideEffectsSafe及retry离线前置不再支配新正常重试；旧not-ready与当时检查事实保留，当前以末节正常重试维护为准。

本节是本次C5四文档维护的作者静态自检，不是独立复审或执行证据。review-basic-worker-token-recovery generation 1 completed / not-ready和所有旧结果原样保留；前一作者自检仍属其原阶段。

- **一个边界与最小差异：** 完整objective/constraints/deliverables仅一个协调文档维护终态，主Waves/伴随Plan方法及既有Work约定适用；指定四文档、复审/诊断完整Result和仓内failed报告均已读取，只读核对实际控制器及fixture/build/cache源码。三族权威reuse/写入skip、不变原成功合同和用户授权沿用；本次只增加Context加工规则、Plan内部顺序/验证安排、现有token item/gate实际消费要求及Work局部复审入口，不新增item/工具Result或改图依赖。
- **证据可行性：** 现有snapshot排除build、fixture仅三处、old_snapshot仅前三目录和eligible_retry未消费副作用/完整清理是源码所见缺口，不冒称当前工具已修好。未来规则以固定清单/hash、任务路径/执行记录和现有退出/收束/停止记录作输入，允许有依据的正常输出变化，未知/缺证即拒绝；可能复用的半缓存/系统临时残留缺归属或完整性依据时必须报告具体路径而停，不能凭exists/快照放行或清理后续跑。实际函数/记录输入与内存替身的允许及单变量拒绝场景已列在[Context](context.md#逐轮副作用与网络再试判据)，但本次未执行它们。token/身份及上述最小纠正先实施、同版离线后才真实运行；未来内部证据不成为开始实施纠正前的循环门槛。
- **联合等待/冲突与保全实查：** 本次按前置item首句的正向依赖和Wave表解析，编辑前后均为15个唯一item、10个非空Wave/10 gate、25节点/49条去重等待边；每项唯一归属、引用可解析，无环/自等，前后成员与依赖集合相同；除当前token item的内部说明和自身gate消费谓词外，其余item正文、其余Wave/gate行、现行冲突表及最终G-RECOVERY-INTEGRATION完整第1–9款逐字不变。当前单一终态、remapped无basic成功依赖、产物只消费新完整发现、最终独立复验/验收和旧gate不回填均保持。源码/元数据全树无漂移不是本次检查结论。
- **材料/链接实查：** 核对四文档同目录Work/Plan/Waves互配及99处四文档内部文件/标题链接，均解析；新增仓内源链接已实际读取。新增内容无项目外Result locator，未复制原报告。修改只限本目录四文件；写入后回读对比检查对象，不把Markdown分析器缺席说成clean。
- **精确局部复审范围：** Context“新 token 恢复局部复审采用与本次维护”“逐轮副作用与网络再试判据”；Plan“本地观测失败后的最小独立恢复策略”、局部selector表的token行及本节；Waves仅RECOVER-BASIC-JAVA8-TOKEN-RECOVERY的内部步骤/副作用消费、G-BASIC-JAVA8-TOKEN-RECOVERY自身谓词及现行连接末段；Work本次局部入口。必要联合核对未变的产物/VERIFY-RECOVERY/REVIEW-ACCEPTANCE前置、最终合取及共享排他，不重开权威/已完成修复或吞入B/remapped/最终验收。

本次未修临时工具、执行离线回归/测试/Gradle/Java/网络/Git、attach/终止或调度；未改源码/配置/权威/旧证据/Result。未来真实输出与缓存/临时影响、同轮compiler/共享语义和真实完整停止链仍待证；无法可靠归属即停，原Provider/.git/解码与全部历史盲区不关闭，不宣称ready、item完成或gate释放。

## 正常网络重试局部维护作者自检

本节只记录本次C5四文档维护；一个文档协调终态及其作者自检，不是实施、独立复审、ready、item完成或gate释放。完整Handoff边界、两项写作Skill、四文档、所给原Result（完整JSON解码）及最新仓内partial报告已读取；PRD/ADR/Spec及译本reuse/写入skip沿用，不改权威。

- **采用及当前判据：** token generation 1保持partial，保留131/131同版实际函数离线、token/身份/观察效果、17条真实观察和原网络早败/缺compiler事实。取消DNS诊断为cancelled且无Result，不计completed。新NORMAL-RETRY一个Handler/Result只取原D；普通缓存/构建变化不再要求逐文件归属、sideEffectsSafe新认证或包装白名单，纯网络提前失败缺后续证据不等于工具故障；具体损坏、真实控制器/观察故障、身份/退出不明或明确非网络错误仍停。旧规则加历史标签，不抹旧not-ready或改旧谓词。
- **联合图实查：** 编辑前15 item/10 Wave/10 gate、25节点49条去重等待边；本次16 item/11非空Wave/11 gate、27节点51边。所有引用可解析、每item唯一归属、item前置+所属Wave前置gate+gate等全部成员的联合等待无环/自等。仅增NORMAL-RETRY→G-REPAIRS和新gate→本item，替换产物/复验/验收对旧token的4条成功等待；旧item/Wave/gate仍在图。remapped无basic成功依赖，冲突保持串行，新item不等旧partial/failed或自身gate。
- **原合同/历史保留实查：** 46项内存静态断言通过：11个未受影响item全文、token原完整谓词/正文、9条旧Wave/gate表行、最终gate第2–8款、Plan原三策略/Mixin/Forge API/接线合同及Work旧结果表行均保留；并检查新边界的预算/余量、原完整同轮compiler合同、基本身份/退出及具体损坏/非网络停止规则。最终gate第1/9款只接入正常重试/最新partial及工具效果，原F∧D∧B∧M及V∧F∧D∧B∧M∧H不减；发现不代替B/M、fresh或独立验收。
- **引用与写边界：** 四文档互链/配对及四文档内部Markdown标题引用已核对；新增仓内证据链接只指已完整读取的token partial报告，不保存外部Result定位或复制全文。写后回读对照本次编辑对象，作者检查只覆盖本次边界与必要联合图/历史保留，不是全仓/缓存/运行安全认证。
- **不同Handler最小局部复审范围：** Work当前采用、NORMAL-RETRY入口及完成连接；Context“正常网络重试决定与当前判据”及旧token/分类规则的历史标签；Plan准备状态、正常重试策略、selector新行、复验/验收输入及本节；Waves新NORMAL-RETRY item/Wave/gate、旧token partial说明、ARTIFACTS/VERIFY-RECOVERY/REVIEW-ACCEPTANCE必要前置、排他表、最终gate第1/9款和新现行连接。联合核对旧gate不回填、G-REPAIRS唯一新前置、原同轮D/完整B/M/V/H及基本运行安全即可；不重开不变权威/已完成修复、缓存逐项调查或整份旧历史。

本次未运行测试/构建/Java/网络/控制器/离线检查/Git或进程操作，未改工具、项目、缓存或旧证据；未确认实际启动排他、真实compiler/产物、最终fresh/根入口或独立验收。网络仍可能失败，Provider直接观察/.git/解码/原LSP probe inconclusive/真实完整停止链及输出竞争排除、全量partial和跨平台盲区继续保留。


## Forge 补丁恢复规划作者自检

**前轮历史自检，非当前连接。** 其中 P 的编译可选完成证据、P/R→D/B/M 与不能改 caller/fixture 的边界已由本次纠正；原自检事实与未运行/旧结果保留，当前见后续“真实可行性与新增范围维护作者自检”。

本节是当时四文档维护的作者自检 Result，不是独立复审、实施、运行、ready、item completed 或 gate release。

- **范围与事实：** 回读 Handoff 全部 objective/constraints/deliverables；回读 Work、Context、Plan、Waves、最新 NORMAL-RETRY failed 报告、PRD/ADR/Spec、McpAction.kt 与 ResolvePatchedMinecraft.kt。确认本次只写四份协调文档；源码读取显示当前 PATCH_OPERATION_VERSION=7，已按事实修正文档，不把旧错数字写入计划。
- **独立结果：** P（生产 patch namespace/late-copy/自有缓存失效）、R（针对性反例回归）、D（patch 后 Java8 同轮发现）、B（basic 完整产物）、M（remapped）、V（最终 fresh 组合）、H（独立验收）各有单一 item/Handler/Result 边界；缓存失效并入 P，未虚构 cache helper Result。D 不等于 B，B/M 不合并，V/H 仍独立。
- **覆盖检查：** 计划明确 patched 定义优先、未补丁接口经过 rename 后的 entry/内部名/描述符/引用一致、旧错误自有缓存 key miss/rebuild、non-notch/关联路径原合同；没有预设 CLI 开关、具体 patch 工具机制、空接口、consumer 绕过或版本升级。R 的未来新增测试类/方法明确标为未实施，不能冒充现存 selector。
- **历史与依赖：** NORMAL-RETRY 的非网络 compileJava failed、17条观察、compiler/metadata 缺失、偶然 Jar、token partial、两次 Java8 partial、有限/观测 failed、basic blocked、首轮153/150/3/0、旧 gate 不满足均保留。B 只消费 P/R/D；M 只消费 P/R，不等 D/B；V 消费 P/R/D/B/M；H 消费最终 G-RECOVERY-INTEGRATION。旧 Result 不被覆盖或改判。
- **图与资源：** Waves 唯一拥有 item、Wave、gate 等待；P→R→D→B，P/R→M，P/R/D/B/M→V→H 的业务依赖为有向关系，Gradle/TestKit/build/fixture/cache/Forge 共享写入另以串行冲突表达；未将排他误写成成功依赖，也未让旧 failed gate 成为新路线必须先成功的前置。文档内 Work/Context/Plan/Waves 互链，P/R/D 均链接回 Plan/Context。
- **实际静态核验：** 写后从四个确切路径完整回读；294个 Markdown 引用的本地文件目标全部可达，其中123个四文档内部引用及107个标题锚点全部解析。联合解析 item 正向前置、所属 Wave 前置 gate 与 gate 等待全体成员，得到19个唯一 item、14个非空 Wave/对应14个 gate、33节点/70条去重边；引用可解析、每项唯一归属，无环/自等。45项内存断言通过：11个未受影响 item 全文、10条旧 Wave/gate 表行、最终 gate 第2–8款及11条 Work 旧结果表行原文保留，并检查 B 的 P/R/D、M 的仅 P/R 前置及新增项单一谓词/拥有/证据/冲突/停止字段。直接比较三份权威、两份诊断边界源码和最新 normal-retry 报告的 SHA256，六份均与本次编辑前相同；这不证明全仓、其它历史证据、缓存或 .git 元数据稳定，也不是运行语义验证。
- **不同 Handler 最小局部复审边界：** Work 最新 failed 采用/拟实施范围与完成连接；Context 新“Forge 生产补丁诊断与本次规划边界”的报告/已采用诊断/源码区分、版本7与 operationName 的事实及三族 reuse；Plan 新生产 P/缓存失效、独立 R 四项矩阵、POSTPATCH D 与完整 B/M、selector 及本节；Waves 新 P/R/D item/Wave/gate、B/M/V/H 的必要前置、生产/运行排他、最终 gate 第1/9/10款及现行合取。联合检查旧失败/partial/gate 不回填、M 不等 basic D/B、原完整 B/M/三模块 fresh/Forge 三类及新增例/根入口/独立验收强度不减即可；不重开不变权威/原已完成修复或已排除输出竞争，不扩大普通缓存调查。材料性范围仍须不同 Handler 的 review-delivery-plan，不由作者自检代行。
- **停止边界：** 当前未修改生产/测试/fixture/脚本/缓存/配置/依赖/权威，未运行 Gradle/Java/测试/网络/Git，未实施或释放 gate。后续生产/回归范围须先经不同 Handler 的 review-delivery-plan，再由 Router 披露并取得当前用户确认；本自检不声明 ready。

本次未检查运行时新 patch 产物、Jar 内部 namespace、缓存 miss/rebuild、真实回归、Java8 compiler、basic/remapped 产物、最终 fresh 组合或独立验收；这些是后续 Result 的证据义务。

## 真实可行性与新增范围维护作者自检

**前轮作者自检保留：** 下列“尚缺固定合法输入/未闭合”记录限当时；本轮采用的固定来源、用户样本决定及具体 producer/oracle 维护见末节。前轮未运行、not-ready、历史与 gate 状态不改判。

本节仅记录本轮四文档作者自检；不是独立复审、实施授权、未来 item Result、ready 或 gate release。前轮计数/断言/hash/链接扫描及“当时本次”文字均保留为历史，本轮未重跑那些检查。

- **输入与唯一结果：** 已把 Handoff 的 objective、constraints、deliverables 作为整体检查：本轮只有同一 Work/Context/Plan/Waves 协调计划纠正及其作者自检这一结果，不执行所规划的独立 S/T/P/R/D/B/M/V/H。已读取指定四文档、PRD/ADR/Spec、两个 Forge 生产边界、CachedMinecraftTask.kt、Cache.kt、basic/remapped 脚本、PatchedMinecraftTests.kt 与 NORMAL-RETRY 原 report；新增事实分别归到 Context，策略在 Plan，唯一成员/依赖/gate 在 Waves，Work 只作入口和边界。
- **权威复用：** PRD reuse：恢复既有补丁/原 consumer，不新增产品平台或版本；ADR reuse：同一隔离决策/生命周期，无新架构版本；Spec reuse：维持输入/输出/当前产物与既有平台基线，不伪称已有完整 Forge patch 支持矩阵。此次源码事实未要求更新三族；中文译本沿用历史 reuse，未重新全文对照。具体实现若推翻覆盖，须 blocked 并报条款缺口，不自行写权威。
- **真实输入与边界：** 对照 basic 的 ResolvePatchedMinecraft/task provider 与 flatMap(output)、MCP patch/rename/mcinject、ResolvePatchedMinecraft 最终 late-copy、CachedMinecraftTask.directory 和 Cache operation/patch hash/basename。计划固定 1.12.2/14.23.5.2860:userdev3、真实 joined.tsrg/header/方向、binpatcher/binpatch/clean 和工具/库输入，显式控制 metadata 与所有 task 自有缓存、TestKit home、工程及输出；不把改一个 output/目录或 --no-build-cache 当失效证据。实际解析文件/摘要/key 仍待 S/T 登记，不编造规划阶段没有的合法输入。
- **基线与 fixture 的独立谓词：** S 是旧 JAR/对应旧自有缓存/源码/必要输入及日志来源可追踪的字节封存，原件保留，P 首次生产编辑前必须 completed/足证据。报告摘要不等于本次重新 hash，当前缺失/漂移/来源不明即阻断。T 是新专用真实私有 fixture/task/provider 实际可执行与缓存/输出受控的独立终态；旧实现可以运行且 namespace 仍错误，不反向等 P。两者路径/类/方法明确标未来输出，本轮无副本/fixture 被创建。
- **P/R 证据强度：** P 必需真实最终产物 entry/this_class/descriptor/reference、未补丁接口/相互引用、patched 优先/资源，以及旧自有 key miss/rebuild 或可观察等价事实；删去仅编译即可完成的退路。R 必须通过 T 的真实生产执行，准确未来 selector、四项反例/参数、完整 T/R 类及现有真实 AT/JarJar 有运行/XML/内容/cache 对应；写了测试、Jar 可打开、空 mock、skip 或偶然旧 Jar 都不能 completed。non-notch（含/不含 mcinject）/NeoForge 尚缺固定合法输入，明确未闭合/待决并阻断 R/V/H 放行，不虚报可运行能力。
- **授权纠正与消费者：** 专用 fixture/基线是用户已确认的后续范围；remapped 原旧 API→ResolvePatchedMinecraft/ResolveMinecraftMappings/LoadMappings/RemapTask 脚本迁移权限仍有效，不再标“不能改脚本”。但当前旧脚本及真实解析/namespace/provider/Java8 尚未闭合，不当作 non-notch 实证。不扩生产 API、版本、consumer 用例、依赖或 remapped runner -D。basic/Java8 D、完整 B、独立 M、最终三模块 fresh V、不同 Handler H 的单独 Result 与原合同均保持。
- **技术依赖和质量门槛：** 逐项对照 Waves 的 item 前置、Wave 前置 gate 与 gate 全体成员，现行新增路线是 S→T→P，R 消费 S/T/P，D 只读 P 后实现和原 basic 接线，B 消费 P/D，M 消费 P 与自身迁移；V/H 显式汇合 S/T/P/R/D/B/M 和原修复/Mixin。R 是本次约束已明确的 V/H 必需质量门槛，不是 D/B/M 技术输入，也没有默设先 R 全局 barrier。S/T/P/R 各自 gate 不等待自己或后继；B/M 不等所在旧失败 gate，V/H 不等旧 NORMAL-RETRY/token/partial 转成功。按这些正文关系人工展开没有新增环/自等；未运行图解析器，不沿用前轮边数或断言数量。
- **串行与历史：** S/T/P/R/D/B/M/V 及共享 Forge 文件、Gradle/TestKit/build/fixture/cache 全部写运行串行排他；M 与 D/B 无成功前置只存在共享资源冲突。保留 NORMAL-RETRY failed 的 compileJava 缺 ICommandSender/无 compiler/偶然 Jar、token partial/131项离线、两次 Java8 partial、旧 basic blocked/failed/partial、首轮153/150/3/0、三项修复/Mixin completed、旧 gate 成员/完整合同/不满足与历次 not-ready；新规划、自检或未来 S/T/P/R 不覆写/回填旧 Result、不释放旧 gate，最终 gate 第2–8款仍完整。
- **互链与实际检查范围：** 从四个确切路径回读本轮改动，人工核对 Work↔Context↔Plan↔Waves 入口、当前策略/基线/矩阵/自检及 Waves 现行连接的标题引用；新增可点击源码/原报告目标均为本次已读取路径，未来目录/类用 code 标注而非伪造现有链接。未全量扫描旧链接/锚点、未运行 hash/断言脚本，也不把编辑工具的 Markdown 诊断当运行验证或全仓稳定证明。
- **独立局部复审边界：** 仅本轮真实来源/用户已确认范围、S/T 的完成/先于生产编辑、P 真实最终产物/自有缓存谓词、R 真实 fixture/准确未来 selector/未闭合关联输入、D/B/M 技术依赖与 V/H 质量门槛、remapped 原迁移权限、联合 gate/串行/旧历史保留及本自检。材料性图维护尚未由不同 Handler review-delivery-plan；本次不创建复审/委派、不调度、不选后继。现有范围确认不等于当前文档 Handoff 允许实施。

本轮只修改 work.md、context.md、plan.md、waves.md；未修改生产/测试/Gradle fixture/脚本/缓存/依赖/锁/权威/Git，未复制 JAR/基线、创建 fixture，未运行 Gradle/Java/测试/网络或运行时验证。
剩余风险：旧基线现存身份、合法输入/私有隔离及 P/R 真实产物证据均待实施；non-notch/NeoForge 与 remapped 当前风险未闭合，旧输出竞争排除及历史盲区仍在，计划不据此 ready。

## 固定输入与判定合同维护作者自检

本轮只维护同一 Work/Context/Plan/Waves 的输入来源和验证合同；采用最新局部复审 completed / not-ready 的唯一 P1，不把作者维护当作不同 Handler 复审或实施确认。前轮自检/全部 failed、partial、blocked、not-ready 和首轮153 execute / 150 pass / 3 fail / 0 skip 原记录保留。

- **来源/版本：** 已完整读取两份指定外部 Result 并加工为 Context 的官方稳定入口，未把会话路径/Result 文件作为仓内依赖。Forge36.2.39 实取 userdev绑定MCP1.16.5及 SHA1 事实与先前“未取得”历史区分，binarypatcher纠正为1.0.12、inject纠正13 class＋3 service；本轮直接只读该版本三份完整工具源文本。basic/NeoForge的1.1.1与1.0.12分开，NeoForge userdev发布摘要与实取验证、config摘要与整包摘要均不混称。逐组实际工具/fatjar/依赖/clean仍由 T 物化取证。
- **predicate/oracle可达性：** 对照现存 ResolvePatchedMinecraft/McpAction/UserdevConfig/CachedMinecraftTask/DistAttributePostProcessor 源码，merge、rename＋mcinject、null三个位置与task output/cache/Java executable接点相符；将真实 patched task、独立官方参考 task、见证清单及消费连接写明。类/接口选择以patch记录/checksum/映射/实际stage产物和引用交集可复现，资源按清单及内容/冲突语义判断，删除项排除；不复制生产补全算法、不用entry能打开或源码编译自证。NeoForm official namespace以真实mergeMappingsOutput/官方映射为准。
- **producer时序/粒度：** S只封存basic原失败；T同一真实入口准备终态覆盖三组固定输入、参考产物/具体见证以及关联旧final/cache/源码/Dist attrs，须全部先于P任何生产编辑，P/R消费稳定副本。未按版本/文件拆item，不创造独立工具交付；T内部参考producer为必要判定输入，不反向等待P/R。当前未物化不是规划前须先跑通的条件，T执行缺输入/见证/Java21或旧对照则未完成，不能修后补造。
- **图/独立终态：** 静态比较维护前后，21个item身份及16个Wave的成员/前置gate不变；联合item前置、所在Wave前置和gate全成员等待图37节点无环/自等。保留S/T/P/R/D/B/M/V/H；R只为V/H必需质量门槛，不为D/B/M添加技术前置。全部共享Forge写入/Gradle/TestKit/cache继续串行，旧失败gate没有成为新路线待成功前置，原完整final gate第2–9款未削弱，第10款消费三组证据。
- **范围/Java：** 沿用三族reuse，不改权威。NeoForge21.0.76-beta/MC1.21只作用户接受的私有样本，同时见证无mcinject与后处理；Java21只由现存工具选择入口取证，不安装JDK/升级工具链/修改原consumer或runner。Dist只比较本次不退化和明确现存格式，已知跨namespace分类静态风险保留，真实新缺陷/需要额外生产边界即停止报告；无额外条件笛卡尔积。原basic/remapped版本、Java8消费、remapped批准迁移及输出竞争/静态迁移/Git排除不变。
- **互链/历史：** 四文档互链、固定来源→Plan判定→T/R/gate→V/H的消费关系已逐处校准；旧“尚无固定来源”自检明确标为当时历史，不改运行状态。作者静态核对90个不同仓内目标、313处本地链接（含锚点）全部可达；维护前后逐字比较 Work 已采用结果表、Context 旧历史尾部、旧失败/partial item 合同及 final gate第2–9款均不变。新增fixture/任务/测试路径和selector均以未来产物标明，未建假证据链接。

**供不同 Handler 局部复审的范围：** Context“固定关联输入采用与证据限制”、本Plan“固定输入与逐分支判定来源”及T完成边界/R四项矩阵与本自检；Waves的T/P/R证据、fixture/regression gate、final gate第10款及现行连接；Work相应采用摘要。重点复核固定版本绑定/证据等级、T内真实producer及参考见证选择是否可执行、P前旧关联封存/隔离、资源判定与NeoForge不退化/Java21边界、联合等待及R质量语义。S/T既有划分、notch真实入口、P内容/cache强度、remapped迁移及不变原三修复无需无据重审；材料性差异仍需独立评估，本轮未实施独立复审或释放gate。

未运行Gradle/Java/测试，未创建fixture、复制基线、物化依赖、改源码/构建配置/缓存或执行Git。
剩余限制：所有实际输入/工具/Java21可用性、具体见证及P前关联旧输出、P/R新产物与M迁移消费仍待各producer实际证明；已知Dist分类风险及输出竞争排除保持，当前不宣称ready。

## 去封存与 JDK 分支规则维护作者自检

本节记录本轮四文档维护；上方全部历次作者记录仍只属于其历史阶段。本次未实施或执行独立复审，不继承旧版 ready，不完成实际 item、不释放任何 gate。

- **S 与来源边界：** 已从现行 item 定义、Wave 成员/等待、P/R/V/H 合取撤出尚未执行的新 S，不标 completed、不生成或合并 S Result。T 仍为真实入口准备而非旧输出封存。Git 只记录可追踪源码版本，当前未提交/未跟踪内容须另记身份；生成 JAR、私有缓存、依赖字节和工具输出不由 Git 保存或证明。本次没有操作 Git。
- **P/R 可证性：** 从三个固定真实 provider 取得新鲜最终 output，在 universal/inject/AT/Dist/marker 之后按独立参考及具体见证核对 patched 优先、未补丁接口、entry/this_class/descriptor/reference/namespace/资源；编译或中间 Jar 不足。源码旧语义值到新有效 operation/key/basename/path 的隔离，加隔离空缓存或已证新 key 不存在的安全私有缓存 miss→真实 rebuild→同输入同版本 hit，为现行缓存证据。只读核对现存 Cache 路径、Cache miss/Cache hit 日志及 ResolvePatchedMinecraft 版本7/实际调用边界，确认能从现有入口取证；没有执行该序列，外层 rerun/no-build-cache 不替代它。新产物留存不使用可回写的硬链接，也不复制旧 JAR/缓存建基线。
- **明确收窄：** 无旧实物不再证明旧错缓存在场的动态拒绝/替换、旧 final 反例重放、NeoForge 完整旧 attrs 等价或全 class side 正确。NeoForge 只保留明确的新鲜主属性/marker、universal/资源及有限原始资源成员关系，已知 Dist 分类静态风险仍保留。固定官方来源不等于本机物化、独立见证已选定或运行成功；remapped 既有迁移、Java21 样本工具和两个 Java8 consumer 的支持/权限边界不扩大。
- **JDK 分支：** 精确版本、要求/选择来源、解析结果/异常及 task/方法/参数/工具失败和未到达边界必须记录。未能启动为 blocked、实际调用失败为 failed；必需参数缺失则所属 item 未满足，不能 skip/缺失算成功。只使真实后继等待，工具契约允许且无依赖/写冲突的其它分支继续，不终止或取消。T 缺任一样本仍阻 P；P 已完成后 R 缺21不是 D/B/M 技术前置，D 缺8仍阻 B，M 按自己的8要求判断。最终 gate 等全部必需分支成功；fail-fast/契约不能继续时报告失败/未执行集合和限制，不虚构并行或恢复机制，不安装 JDK 或改 consumer/runner。
- **联合图与排他：** 对写后 Waves 以只读 Python 解析现行定义、唯一 Wave 归属、item 前置及 Wave gate 等待：20 item、15 Wave、15 gate，共50个等待节点，联合无环、无自等、无悬空成员/前置/gate。断言 S 无现行节点、T→P→D→B、P→M、T/P→R，R 不在 D/B/M 的技术祖先中、M 不以 D/B 成功为前置，V 汇合 T/P/R/D/B/M 且不等旧 G-RECOVERY/G-BASIC-RECOVERY 转成功。人工核对共享 Forge 源/测试/Gradle/TestKit/build/fixture/cache 的冲突仍串行；独立继续不表示并跑。T 内分支继续不使其整体 gate 提前满足。
- **互链与历史：** 核对四文档仓内相对链接及 Markdown 锚点，未新增外部 Result 本地路径；最终写后复验结果见本次 Result。与编辑前内存原文对比，Work 全部已采用结果表、Context 旧历史尾部、Plan 全部历次作者自检、12个既有历史 item 合同和原历史 Wave/gate 行保留；首轮153/150/3/0、failed/partial/blocked 及旧 gate 不满足不回填。最终恢复 gate 第2–9款逐字保留，仅受撤 S/新证据影响的成员、第1/10款及相应新 gate/当前合取更新。旧自检中的封存、计数或当时 ready 限其原阶段，不再作为当前要求。

**供不同 Handler 受影响范围复审的材料：** [Work 当前范围](work.md#目标与当前阶段)、[Context 最新证据/JDK 合同](context.md#本轮去封存后的证据与-jdk-分支合同)、本 Plan 的专用真实 fixture、固定输入与逐分支判定、P/R 矩阵及 JDK 分支规则，以及 [Waves 当前连接和新 gate](waves.md#forge-补丁恢复的现行连接与旧-gate-保留)。重点是撤 S 后的证据可达性/未覆盖限制、Git 边界、语义路径隔离与新语义冷/热自有缓存、JDK 分支继续/等待与最终 gate、联合图及冲突。作者自检不替代独立 review-delivery-plan；材料性范围和具体放行仍由 Router 判断，本次不调度、不声明 ready。

本次只修改本目录四文档并做只读文档/源码检查；未运行 Gradle、Java 或项目测试，未创建 fixture/基线，未复制 JAR/缓存，未改生产、构建配置、依赖、权威或缓存。
剩余限制：三组实际输入/参考/具体见证、JDK 可用性及 P/R/D/B/M/V/H 全部新运行尚待真实证据；没有证明生产已修好或缺 JDK 的工具已支持继续。


## Java21 共同前置解除作者自检

本轮唯一结果为同一 Work/Context/Plan/Waves 的 Java21 共同前置局部修正版及作者自检，不执行文档中的任何准备/生产/验证终态。采用 review-no-baseline-jdk-plan generation1 completed / not-ready 的唯一阻断；前轮自检中的聚合 T、T 缺21阻 P、50节点等只属其历史，逐字保留，不作为当前合同。本节是作者检查，不是不同 Handler 独立复审、ready、实施确认、实际 item completed 或 gate release。

- **权限与权威：** 按完整 objective/constraints/deliverables 作为一个协调维护谓词检查；已加载 plan-implementation 及三个指定文档 companion，读取四份精确路径及必要 PRD/ADR/Spec/委派合同，沿用三族 reuse/译本不写。仅显式编辑本目录四文档，没有复制旧状态/创建 fixture/新报告，未触碰源码、测试、构建/配置/依赖、权威、缓存或 Git；未运行 Gradle/Java/项目测试/网络。
- **单一谓词与保留/消费：** 三组 T 分别有可独立成功/失败、保留、恢复和被消费的真实输入/参考/见证准备边界，按此拆分而非按文件。P 仍一个共同生产更正，只写原两个接点/版本，必须 basic 全 namespace/接口/引用/优先级/资源/适用 AT 及实际 forge 路径隔离/冷热缓存，不退化为编译标记。Q-1165/Q-Neo 各验证本组同版完整合同/实际路径/缓存；前者供 M，两者共同供 R/V/H，不能把一组/partial 称为全部共享实现通过。Q 失败不抹掉未漂移的独立已证结果；共享再写必须重核/重取受影响证据，不把旧证据推广到新内容。
- **真实输入与运行边界：** 各组精确未来方法对应自己的 patched/reference provider、固定合法 clean/binpatch/mappings/工具/JVM/独立 oracle 与具体见证；选择本组不在共享配置/BeforeAll/无关 provider 预先要求 Java21。各方法/完整 fixture 类最终由 R/V 全跑，不成为单组/P 共同门槛。P 静态核对两族新语义使用，但不要求 neoforge 实际路径或三组缓存全成功；实际证据由 Q 各产出且最终仍全需。无新调度/恢复框架、JDK 安装或版本/consumer/runner 扩张。
- **联合等待图：** 对改后 Waves 定义/表格作只读内存解析，将 item→item 前置及所属 Wave、Wave→前置 gate、gate→全部成员合并：24 item、19 Wave、19 gate，共62节点，引用/唯一非空归属齐全，无悬空、环或自等。77条针对性文档断言通过：S/未执行聚合 T 无现行节点，P 仅等 T-basic，D/B/M 的技术祖先均无 T-Neo/Q-Neo/R/旧失败 gate，M 必需 P/Q-1165 而不依 D/B；R/V/H 全部保留三组 T/P/Q。人工核对所有共享 fixture/helper/Forge/Gradle/TestKit/build/cache 写运行串行，冲突不偷换成业务前置。
- **Java21 关键反例：** 在“只有21不可用、8/17及各自真实输入/权限/证据充分”的假设下，按实际联合图求可达闭包，不执行任何 item：T-Neo 未启动 blocked 或已调用 failed，Q-Neo 等待；T-basic→P→D→B、T-1165/P→Q-1165→M 可达。R/V/H 与 G-FORGE-PATCH-NEO/G-FORGE-PATCH-REGRESSION/G-RECOVERY-INTEGRATION/G-ACCEPTANCE 不满足；旧 G-RECOVERY/G-BASIC-RECOVERY 仍未满足。这不是 JDK 已可用、工具已能继续、结果已通过或 gate 已释放；实际 fail-fast/能力限制仍须保存失败/未执行集合。
- **最终覆盖与历史：** 对编辑前内存原文逐字比较，最终 gate 第2–9款、Work 已采用结果及尾部历史、Context 历史尾部、Plan 全部历次作者记录、12个既有已执行/历史 item 完整合同与9个旧 Wave/gate 行均未改变。最终第1/10款及显式前置汇合三组 T/P/Q/R/D/B/M/F/Hist；四项 R 矩阵、三样本/两族实际有效路径/全部 miss→rebuild→hit、真实 AT/JarJar、两个原 Java8 consumer/共享属性观察、同版完整三模块 fresh/新增案例/首轮153映射/根入口及不同 Handler 验收不减。153/150/3/0、failed/partial/blocked/not-ready、旧 gate 不满足及取消 S 不计完成全部保留。
- **互链与可移植记录：** 核对 Work/Context/Plan/Waves 原配对入口与新增本地引用：新增链接只指向本次已读四文档及实际标题/锚点，未来 fixture/测试只用 code 标记，不造已存在证据。未新增项目外 Result 本机路径或恢复备份依赖；最后写后回读/链接核验见本轮 Result。未全仓扫描历史链接、重新核验外部 URL 或声称全仓内容稳定。

**不同 Handler 的受影响独立复审范围：** `work.md` 当前边界（页首互链）、[Context 采用与结果边界](context.md#java21-共同前置复审采用与结果边界)、本 Plan 的三组 T 精确入口/输入消费、P/basic 完整谓词与 Q 关联验证、JDK 反例/最终覆盖及本节；[Waves](waves.md#forge-补丁恢复的现行连接与旧-gate-保留) 的三组 T/P/两组 Q/R/D/B/M/V/H 必要连接、各 item 前置/所在 Wave gates、联合等待/串行冲突及最终第1/10款。重点核对没有把 Java21 屏障从 T 移到 P 或共享配置/完整类，P 不以编译冒称全 namespace，Q/M 真实消费与缺 Neo 时 Java8 可达但最终仍不满足。取消 S、既定官方来源/独立 oracle、新语义缓存证明与 Neo 收窄合同及不变权威不无据重开；本轮不派发复审/选择后继。

未检查/未覆盖：全部实际准备/生产/工具/JDK/运行及消费者证据尚待各自取得；没有旧错缓存动态拒绝、旧 final 重放、完整旧 attrs 等价/全 class side 正确证明，已知 Dist 静态风险/输出竞争排除和历史盲区不关闭。
剩余风险：修正版尚未由不同 Handler 独立复审，不能据作者检查宣称 ready；普通工具不能继续或真实输入/实现缺陷仍可能使相应分支 blocked/failed，最终必需验收不豁免。

## overlay 未完验证维护作者自检

本轮唯一结果为四文档未完验证恢复计划及作者静态检查；Handoff完整objective/constraints/deliverables为同一谓词，主Waves及Plan/Work companion已加载，指定四文档、报告/JSON及必要报告定位脚本只读核对。沿用原PRD/ADR/Spec reuse/写入skip，不改权威；只写本目录四文档，不修工具或实施验证，不发起复审/调度/完成item/释放gate。

- **事实/充分性：** P-recovery generation1 partial及两个owner/version9/cache输入/真实fresh miss保留；完整parents误断言、目录exit1及deadline后调用明确保留。新P-v一个item/Handler/Result、单成员Wave/gate，只补独立完整oracle与同path hit；新根薄工具/路径离线检查仅为内部步骤。当前源/加载实现/输入/原fresh与实际path/reference/hit必须唯一且排他关联，缺证/漂移不拼接；完整class/body/继承/AT/游戏/优先级/资源/再oracle及原缓存合同不减，原1/0/0/0和8CLI不代证。新时钟含第一离线调用至postprocess/报告保存，1800秒/最多3次网络/前台真退出/余量/非网络停止明确，旧预算不续。
- **联合等待实查：** 只读内存解析得到30个唯一item、25个非空Wave及对应gate，item→前置item/所属Wave、Wave→前置gate、gate→全部成员联合为80节点/143条去重边，引用可解析、每项唯一归属、无环/自等。新增仅P-v及单成员Wave/gate，必要Q/R/D/B/M/V/H改接新足证据；旧P/P-recovery及其gate不在新消费者成功祖先中，Neo/R不在Java8路线祖先，D/B不在M祖先；共享写运行继续串行。缺21时Java8路线仅按自身实际前置可达，不代表已运行；R/V/H仍等全部必需分支。
- **历史保全实查：** 内存逐字断言未受影响item全文、旧P-recovery原完整正文、非受影响Wave/gate表行（含两个旧P gate）、final gate第2–9款、Context全部旧正文、Plan全部旧作者记录及Work原采用表行保留；原P/P-recovery各partial、T-basic-v3 completed/已释放gate和旧failed/unknown/未满足gate不改判。九个实际只读源/报告/脚本/声明文件SHA256在本次编辑前后相同，仅说明这些文件，不认证全仓/.git/所有缓存。
- **链接与结果边界：** 四文档配对互链及本轮新增仓内证据/标题链接经实际文件/标题解析，未来新根/运行结果仅为计划，不造现有证据。未保存外部Result定位或复制运行时Result。最终写后回读与静态复验见本次Result，不把文档检查当完整内容/hit成功。
- **精确独立局部复审范围：** Work本轮采用/完成连接；Context“overlay恢复partial采用与未完验证边界”；本Plan新有界恢复策略、旧恢复历史限定、当前selector/必要消费者和本节；Waves旧P-recovery仅新增partial历史限定、新P-v item/单成员Wave/gate、Q/R/D/B/M/V/H前置/当前连接、final第1/10款、JDK可达与串行冲突。重点复核原fresh保留与新oracle/hit的实现/输入/实际路径排他关联、完整parents/独立reference、目录复用、首调用至保存预算及旧合同/历史不回填；不无据重开权威、已完成生产或Neo/R对Java8屏障。本次仅报告复审边界，不发起复审或宣称ready。

未执行Gradle/Java/测试/网络/Git/进程操作，未修脚本、建新映射/继承表、清缓存或重验完整107文件；动态内容/同路径hit和当前运行时排他尚待证。
风险：当前计划尚未经不同Handler局部独立复审，完整P与其后继均未因本次文档维护完成；原Dist/输出竞争排除/历史覆盖盲区保持。

## 游戏rename恢复计划作者自检

**缓存独立复审前的作者记录，原结论保留为历史。** 下文“完整有序aggregate-key-path”只保留当时措辞，不代表Core实际编码顺序/角色/basename；该缓存矛盾及顶层cache/final对象误述由[本轮源码对齐自检](#缓存策略源码对齐作者自检)纠正，不能用此前自检覆盖已采用not-ready或替代新独立局部review。

**本次仅四协调文档/唯一图维护的实际作者检查；不是独立review、计划ready、实施确认或运行成功。** 已按完整objective/constraints/deliverables确认本轮只交付一个可供局部复审的恢复计划变更；未来图含两个独立结果不表示本Handler执行它们。只读了必要现存源码/固定配置/API记录/原报告、映射与输入身份，未运行Gradle/Java/测试/网络/Git/进程命令，未主动运行LSP；编辑器伴随的Marksman silent提示不是clean证明。没有生产/公共测试/fixture/helper/consumer/依赖/权威写入，也未创建build脚本/产物、复制旧状态或清搬缓存。

- **authority与成功条件逐项对应。** PRD原恢复目标、ADR隔离生命周期、Spec既定合同沿用当前可靠reuse/写入skip；本轮无产品/API/资源政策或架构规范变更，未出现需重开权威的材料性覆盖冲突。共享rename原声明/参数及专属版本输入对应P-n/G-FORGE-GAME-RENAME-INHERITANCE；新实现实际加载、四行原域预期/实际rename/normalized overlay声明闭合、全量内容与新miss/rebuild/hit对应P-v6/G-FORGE-REBUILT-CONTENT；其它三T/两Q/R/D/B/M和最终fresh/根入口仍对应原各自结果与G-RECOVERY-INTEGRATION/G-ACCEPTANCE。不能用聚焦/编译/静态版本代替任何完整条件。
- **语义分组。** 检查源码修正有独立审查/采用/被后继消费及后继失败仍保留的边界，故与新产物全量验证分开，不以文件数/编译可行为拆分依据。参数传递/版本输入/聚焦是共享修正的必要支撑；reference复用/内部薄工具/四行实际闭合/完整oracle/冷热只支撑完整新产物谓词，无独立工具产品消费者。两处reference修正已有有效效果，不再作为新实施结果重做。
- **图与全部引用。** 用只读内存结构检查提取全部item定义、前置item的正向首句、Wave表成员/前置gate/本gate，并人工对照“不等/仅事实”等否定部分；检查从34 item/29 Wave/29 gate变为36/31/31，新增仅P-n/P-v6两项及两单成员Wave/gate。全部36项唯一归属、31 Wave非空、ID/gate唯一且引用有定义。联合等待图按item→前置item及所属Wave、Wave→前置gate、gate→全部成员建模，共98节点/169等待边，无环/自等。不是分别查三个列表，也不把静态无环当动态可执行或工具能力证明。
- **受影响最小集合与历史。** 对照改前文本：34个旧item中只有8个完整P消费者定义变化，另26个旧item原合同逐字保留；29个旧Wave的成员/旧gate身份均保留。8消费者全接VERIFY-FORGE-REBUILT-CONTENT，两Q/R/D的4处item显式gate等待及对应Wave表均无旧P-v5 gate残留；V/H另显式消费P-n，最终完整gate列齐12个必需独立恢复Result。P-v5 failed及4778/4782、四真实差异、1466.68秒/无Gradle-hit-加载闭合、两有效reference/样本效果保留；Context的P-v4及更早全部事实章节与改前逐字一致。旧failed/unknown/两partial/全部旧完整合同/gate不满足及T-basic-v3 completed/已释放gate不改判。
- **真实依赖/冲突与分支。** 检查P-n只等已采用T-basic-v3，P-v6只等P-n；旧failed/partial只作事实不成为成功前置，均不等自身gate。D只消费新完整P，B消费P-v6/D，M消费P-v6/Q-1165且无D/B/R/Neo前置；Q各自保留本组T，R保留三T/P-v6/两Q只阻V/H，Java21不阻Java8/1165链，最终仍等全合取。两owner/编译/Gradle/TestKit/fixture/build/cache/input写运行排他明确，异根不等于可并跑；只读共享不新增依赖。
- **gate足证据与版本策略。** 逐项检查新两gate要求对应完整Result被采用/completed且各item全部证据成立；源码gate不直接放行完整P消费。实际新classes/runtimeClasspath、raw inputs/工具/JVM、version10/完整有序aggregate-key-path、新目标不存在→真实task-action miss/rebuild→全量oracle→同版same-path真实hit→再次全量oracle都在新验证谓词/最终gate，不承接旧9/fresh为新成功；不改Core.Cache/清搬缓存、不用外层缓存代证。全部4782/body/成员/继承/属性/AT/游戏保持/11方法/typed锚点/优先级/资源/归档/manifest/marker及原合法要求、basic空集损失仍显式保留。
- **来源与四文档一致性。** 新增8个仓内证据路径均经ordinary read确认可读（report、artifacts、四差异、原gradle.log、declarations、reference-identity-augmented.tsrg、reference.py、specialsource-api.log），并使用已读两owner/固定MCP配置/files.tsv等原有来源；不凭想象引用不存在的独立mapping文件。新增同目录锚点均与实际标题对应，Work↔Plan↔唯一Waves配对不变，四文档当前入口都指向同一新策略/采用事实/现行图，旧“当前P-v5/不cold/只读生产”注明历史范围。四文档均无仓外Result locator或其间接导航。只核必要改动及连接，不重复扫描未变测试清单/权威。
- **预算与未知。** 明确P-n至P-v6首相关检查至最后保存共一个1800秒双时钟deadline（含编译/转交等待/新build/全部验证/保存），不是两个Result各开预算；至少60秒收束另留保存余量/全链最多3次正常网络/窄工具纠错与真实错误及unknown到限停止不减。旧1466.68秒不是新链性能证明，新编译/rebuild和跨Handler调度开销可能使计划无法在余量内完成；原时钟不可比或余量不足须保全已采用效果、报告未完和所需时间/授权决定，不延长/计时外预做/降低验收。live/classpath优先级、四行实际新生产/normalized overlay闭合、version10实际加载/路径/冷热/全量结果均未动态证明。
- **独立局部复审和实施披露边界。** 受影响范围限本节及新增策略/Context事实、新两item/Wave/gate、8消费者/4显式gate等待及对应Wave、最终完整gate和共享冲突/单预算；未变三模块/consumer合同不用重写或重审。不同Handler局部review尚未执行；Router仍需披露两个生产owner/notch-only参数与原域优先级、专属10/input-key及非notch/Neo缓存namespace影响、各新build根薄工具/正常编译和必要生产构建/隔离cache写运行、完整验收/预算风险/停止及排除权限，并取得具体实施确认。当前没有重要产品/架构待决项；具体实施许可尚缺，若实际预算/时钟能力不足，任何预算或分批政策改变仍需明确决定，本作者未批准。没有调度、Todo推进或gate释放。


## 缓存策略源码对齐作者自检

**本次唯一交付为四协调文档的缓存矛盾纠正及作者自检。** 完整Handoff按objective/constraints/deliverables联合判为一个文档结果，未来P-n/P-v6两个结果不由本Handler执行；事前完整加载Plan/Waves/Work及协调方法，读取全部指定上下文与四个源码，不重新加载未变权威或改PRD/ADR/Spec。本轮只以定点替换修改同目录四文档，没有生产/fixture/helper/test/consumer、依赖、缓存或运行输出写入。下列是实际完成的文件读取及内存文本/图核对，不是测试、构建、LSP或运行验收。

- **源码对照。** 直接核对[Cache.kt](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt)128–227、[Hash.kt](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt)12–22、[ResolvePatchedMinecraft.kt](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt)27/286–317及[McpAction.kt](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt)90–128/189–219/调用上下文：真实cached-operations路径；每文件内容Murmur3-32→HashCode.asBytes按有符号Byte逐项/长度比较toSortedSet去重→依序putBytes再Murmur3-32聚合；当前顶层实际输入patches+universal+libraries、version9及两族operation。文件名/路径/输入顺序/角色/重复次数均不由Core编码，声明工具链的SHA256排序不是Core算法，metadata目录也不是额外key字段。
- **版本隔离与对象。** 专属forge-patch-10/neoforge-patch-10及固定声明语义/实际输入覆盖方案由P-n交付；7/8/9/10可同aggregate但不同operation产生不同完整路径，不伪称改常量或记录metadata自动覆盖输入角色。完整有序声明manifest与实际cacheKey清单分记，所读File覆盖不足/角色或工具JVM语义不一致即停止。顶层cache已经过AT/适用Dist/marker；新fresh副本/cache输出/两次task final按path/bytes/SHA256/日志关联，G/rename/normalized overlay等阶段独立，不沿用“中间cache还要再AT”的误述。
- **完整证据合同。** P-v6须记录root/operation、全部输入角色/顺序/path/basename/bytes/SHA256/实际Murmur3-32、去重前后hash对应/源码比较器/重算aggregate/output basename/绝对path，加源码/compiled classes/code source/runtimeClasspath/工具/JVM/argv/阶段与无漂移；先不存在或真实miss→真实task-action rebuild/新fresh→全部4782等oracle→同root/operation/完整输入和顺序语义/key/basename/path真实hit→再次全部oracle。旧9/fresh、仅CLI/编译、外层rerun/UP-TO-DATE/FROM-CACHE/换key或再次miss都不代证。本次未计算实际输入hash、生成version10路径或取得任何miss/hit。
- **图与必要连接。** 从实际Waves item定义的“前置item”正向首句、唯一Wave表成员/前置gate/本gate重新解析；联合等待模型为item→前置item及所属Wave、Wave→前置gate、gate→全部成员。核得36 item、31非空Wave、31唯一gate，共98节点/169等待边，所有引用有定义、每item唯一归属，无环/自等；身份/归属/全部等待边与修改前一致。P-n只等已采用T-basic-v3，P-v6只等P-n，8个完整P消费者仍全指P-v6；D/B不依Neo/Q/R，M仍依P-v6/Q-1165且不依D/B/Neo/R，V/H显式全量合取。两新gate、两Q缓存引用、8消费者说明及最终第10款消费相同实际缓存对象，源码gate不提前释放完整P消费；共享写运行串行不变。
- **持久引用与保留核对。** 新增/受影响同目录引用和标题逐项匹配；本次实际读取四源码及既有P-v5 report/artifacts/四差异/declarations/mapping/reference.py/API记录、原gradle.log/MCP配置/files.tsv共10个历史证据入口，均可读，仅验证定位或相关片段，不宣称重跑其证据。Work/Context/Waves按定点替换重构与全文回读相等；Plan逐替换块回读，并核对未变全量验收、旧作者历史与预算区段，未做全仓Git diff或全量147个历史文件链接审计。四文档没有新增仓外Result依赖，未来新build根仍只是拟议输出。
- **不变条件与历史。** P-v5 generation1 failed、4778/4782与四差异、1466.68秒/无Gradle-hit-加载闭合、两处已有效reference/样本效果、7/8/9及更早failed/两partial/unknown/旧gate未满足完整保留。全部class/body/成员/继承/属性/AT、11方法/typed锚点、游戏/资源/filters/inject/优先级/归档/manifest/marker与basic空集损失不降；未改生产rename接线或权限。P-n首检查前至P-v6最终保存仍同一1800秒双时钟deadline，含交接等待/全部编译构建oracle/hit及保存，保留至少60秒收束另留保存余量、全链最多3次正常网络、真实错误/unknown/冲突/余量不足/到限停止。
- **不同Handler局部review边界。** 只审本次缓存策略/源码事实与历史措辞适用性、P-n专属operation/输入域及有序身份另证、P-v6新fresh-cache-final对象/同path合同、两新item/gate/两Q必要引用/8消费者和最终第10款、联合等待/历史及单预算不变。复用未变生产接线/声明优先级、完整验收与authority；本自检不宣称独立ready、具体实施确认、item完成或gate释放，也不发起review或选择后续。

未检查/未执行：Gradle、Java、测试、主动LSP、网络、Git、进程命令或任何真实cache/产物/JVM验证；编辑工具附带的Markdown clean/analysis unavailable提示均不作为静态检查通过证据。
剩余风险：仅文档已对齐，版本10/新源码加载及真实miss-rebuild-same-path hit仍待独立复审后的授权实施证明；旧1466.68秒不保证含新增编译/交接的单1800秒足够，不能削减验收或另开预算。

## 连续预算起点提案作者自检

**历史作者记录。** 下列是起点候选首次形成时的自检；其后已采用独立局部复审not-ready/P1/P2。本轮最新实际检查归[预算复审修订作者自检](#预算复审修订作者自检)，旧记录不是现行ready或复审通过。

**本次唯一结果是选定四协调文档的预算起点/连续计时候选及作者自检。** 按完整objective/constraints/deliverables联合确认是一个协调文档结果，P-n源码修正和P-v6完整验证只是未来两个独立结果，不由本Handler执行。已加载所选编写方法并读取七份指定上下文；定点维护本Work/Context/Plan/Waves，未改PRD/ADR/Spec、生产/测试/fixture/helper/consumer、依赖、Core.Cache或旧运行证据。以下只记录实际文档读取、文本与执行图的内存核对，不是独立复审、时钟验证或计划执行。

- **权威与提案状态。** 沿用原三族权威reuse和既定命名/完整验收，不产生产品/架构权威改写。四入口、现行策略、两item时间条款/两新gate、最终完整gate第10款及现行连接均明确预算起点是重大未接受候选；只在不同Handler局部复审及新的具体实施范围确认后才拟适用于新执行。已将预算起点变更列为后续披露必须请求用户确认的内容，没有把旧范围确认、文档完成或作者核对当成实施授权/ready。
- **覆盖与排除。** 核对唯一开始事件早于P-n首次运行时/输入/身份/冲突等执行前置核查及执行相关方法/源码/静态/LSP/离线工作；持续覆盖P-n接线/版本10/编译/四行真实固定工具正负例/Result保存、交接及Result读取采用等待、P-v6原钟核对/新产物实际加载/私有构建/真实miss-rebuild/全部4782类及原完整oracle/same-path hit/再次完整oracle/postprocess/退出/最终证据和Result保存。明确排除本次纯文档准备/作者自检、实施前独立复审/新确认及历史批次、未来Q/R/D/B/M/V/H各自工作；排除不许可把P-n/P-v6执行核查或构建验证预做在计时外，也不减少任何原完整验收。
- **起点缺口与可比证据。** 未补造UTC/单调起点，未用墙钟/文件时间/旧1466.68秒反推用时或宣告新范围仍有30分钟。候选要求同次原始双时钟/配对误差、具体来源/API/版本、宿主启动实例/共同原点/单位频率与连续涵盖等待/休眠的仓内可读依据；同名API、同频或各进程从零elapsed不算证明。实际来源与跨进程可比性仍未建立，故不声称方案已动态可执行。
- **交接、期限与停止。** 核对P-n完整Result的原始双时钟/来源/宿主可比性、实际起止及保存完成/唯一截止/已用和剩余、控制退出/未完限制；P-v6须先验同源可比，再从原始M0和不变D用自己的读数扣实际交接等待，之后才做身份/缓存/内容验证。D=M0+1800×f、E=(M−M0)/f、R=1800−E；UTC截止只展示，最终保存完成也在1800秒内。余量须足全部剩余工作加至少60秒收束及另行独立保存S>0，不能只估下一条命令；缺原钟/可比证据、预算或退出unknown、余量不足/冲突/真实内容或身份不符/到限即停并保留已完成结果。新Handler/进程/日期/继续执行均不重置，不补时/延长/分批/降验收，晚保存如实越时，不回判旧批次。
- **全部依赖/gate的实际核对。** 从唯一Waves的item定义、正向前置子句及Wave表提取36个item、31个非空Wave/31个gate；全部item唯一归属，item/gate引用可解析。联合item前置、所属Wave前置gate及gate等待全部成员的67节点图无环、无自等。P-n仍只消费T-basic-v3及其已采用gate，P-v6只消费P-n及G-FORGE-GAME-RENAME-INHERITANCE；两者保持单成员Wave、不同Handler/Result及各自gate。8个直接完整P消费者仍为两Q/R/D/B/M/V/H且均等待P-v6；两Q各等本组T，R等三T/P-v6/两Q且只阻V/H，D不等Q/Neo/R，B另等D，M另等Q-1165而不等D/B/Neo/R，V/H仍汇合12个必需独立恢复Result及原三修复/最终fresh/根入口。没有把旧failed/partial/gate转成功加入新前置，也没有把P-n源码gate直接当完整P放行；所有共享写构建/Gradle/TestKit/fixture/cache/input运行继续串行，展示顺序与只读共享输入不制造成功依赖。此核对只检查文档结构，不证明任何gate实际满足。
- **缓存、原验收与历史保留。** 原缓存真实路径`<cacheRoot>/cached-operations/<operation>/<aggregate-key>/<output basename>`、逐文件内容Murmur3-32/源码比较器排序去重聚合、basename/order/角色不入Core key、有序身份另证、版本10专属operation及旧新aggregate可同、真实miss/rebuild/same-path hit与两次完整oracle均保留；不修改Core.Cache。旧item定义/旧Wave gate行及既有作者记录未作回填，最终完整gate只细化第10款预算衔接，其余合同不删。P-v5 generation1 failed、4778/4782与四差异、1466.68秒/无Gradle-hit-加载闭合、两reference修正/正负例效果、更早failed/partial/unknown、两原partial、旧gate未满足、T-basic-v3 completed/已释放gate及basic空集损失完整保留；当前文档自检不是重验这些历史或永久取回完整原Result。
- **四文档一致性及复审边界。** 本Work明确文档结果/确认前置，Context记录起点缺记及可比证据空缺，Plan拥有候选协议/策略及本作者记录，Waves唯一拥有item/Wave/gate和消费者连接；新增引用仅指本目录可读仓内文档及实际标题，不新增仓外原Result入口、第二执行图或假报告。受影响局部复审材料为四文档、候选/本自检与必要权威，覆盖起点/跨Handler证据、连续覆盖/余量/停止、两item/Result/gate与8消费者/最终第10款的必要连接；不重审未变测试清单。作者只登记该边界，不作独立复审或派发后续。具体时钟可比性、全链性能/余量及实际源码/聚焦/加载/cache/全量运行证据仍缺，实施确认及预算起点变更再确认均未取得，无item状态推进或gate释放。

未检查/未执行：生产或测试改动、Gradle/Java/编译/测试、运行前身份/冲突核查、时钟采样/跨进程验证、独立局部复审及实施；编辑工具附带的Markdown诊断不作为通过依据。
剩余风险：候选尚未接受，可靠跨Handler单调来源及全部剩余工作耗时尚无证据，不能保证1800秒足够；缺证或不足即停止P-v6，保留已完成结果，不能以准备完成替代用户再确认。

## 预算复审修订作者自检

**历史作者记录，原not-ready按当时保留。** 本节不是预算撤销后的作者结论；P1/P2未技术闭合，因政策撤销不再作前置，最新实际维护与检查见[分钟预算撤销与作者自检](#分钟预算撤销与作者自检)。

**本轮唯一结果：四协调文档准确保留一个明确仍受阻的预算协议。** 联合检查完整objective/constraints/deliverables后按一个维护结果执行，P-n生产修正与P-v6验证仍为未来两个独立Result，不在本次交付。已加载plan-implementation和所选三份文档方法，读取七份指定上下文及所给inline复审结论；未改变PRD/ADR/Spec权威，未重做或独立批准旧评估。

- **实际证据。** 只读旧P-v5/P-recovery的JSON、脚本源码、进程快照中的原命令文本和关联日志，并核对两owner/Core及公开fixture实际代码；没有执行快照命令、旧脚本或取新运行读数。已把可指认的Stopwatch.GetTimestamp/Frequency→ticks/f→Python time.monotonic链与未证共同原点/宿主启动身份/版本/等待休眠/配对误差/Result保存终点分开。P1仍阻断，不把同名接口/频率、旧数值吻合、进程创建时间或本地JSON结束当作机制证明。
- **完整阶段与估算边界。** P2表覆盖P-n前置、编辑/编译/聚焦、收束/Result保存/交接，P-v6加载与原钟核对、miss/rebuild、第一次完整4782及全部oracle、same-path hit、第二次完整oracle、后处理/退出/归档和最终Result保存。旧229.3626324/893.9130332准备区间、1.9936772 javac、16.7166917 reference、3.2577896旧样本、470.150187外层旧version9成功、8.1639237失败oracle、0.3048063/0.5868224嵌套失败收束分别有可读依据；不能相加、当新链上界、把8.16乘2或由1466.68推出新链可行。各段适用上界和足额S仍unknown，至少60秒收束独立保留，未求得可行合计，P2仍阻断。
- **四文档回读及互链。** 回读四份完整文本并检查相对文件引用与同目录标题锚点：Work仅拥有范围/状态入口，Context记录已采用复审和事实/缺证，Plan拥有候选/证据矩阵/本自检，Waves独占执行图。四入口均转向本轮记录，早前作者自检明确按历史阶段保留；没有第二执行图、原Result假路径或仓外不可读新依赖。独立复审结论采用所给inline，不宣称本次重新完整读取原复审Result。
- **item/gate/联合等待。** 从唯一Waves提取36个item、31个非空Wave/31个gate；核对成员唯一归属、前置引用可解析及item前置＋所属Wave前置gate＋gate等待全部成员的67节点图无环/无自等。P-n仍只等T-basic-v3及其已采用gate，P-v6只等P-n及其源码gate；两个单成员Wave和独立Handler/Result保持。P-n/P-v6准备条款、两个gate、最终完整gate第10款和现行连接均同步P1/P2阻断，没有把源码gate当完整P。两Q/R/D/B/M/V/H这8个直接完整P消费者仍均等P-v6；两Q各等本组T，R仍等三T/P-v6/两Q且只阻V/H，D不等Q/Neo/R，B另等D，M另等Q-1165而不等D/B/Neo/R；V/H仍合取12个必需独立恢复Result与原三修复/最终fresh/根入口。没有完成任何item或释放gate。
- **预算/停止/历史。** 保留首执行相关核查前的起点、唯一1800秒固定截止、全部方法/源码/静态/LSP/运行检查与交接等待及最终保存计入、至少60秒收束和独立足额保存S、最多3次正常网络、窄工具纠错同预算；不延长/补时/重置/分批/计时外预做/削减4782或完整消费者验收。当前P1/P2不足即阻止两item进入执行准备；将来合法启动后，真实差异、身份不明、时钟/预算/控制退出unknown、余量不足/冲突/到限即停并保留已完成成果。P-v5 failed/4778与4差异、旧1466.68/无Gradle-hit-新加载闭合、已有效reference、原partial/unknown/旧gate与basic空集损失未回填或删去。
- **权限/冲突/修改范围。** 只修改本目录四文档。只读核对PRD/ADR/Spec沿用既有修复/operation/cache隔离及完整验收，未扩为新权威；共享两owner/编译classes/Gradle/TestKit/fixture/build/cache/input冲突继续串行，新根不消除冲突，也不变成成功依赖。该检查是文档权限与排他合同核对，不是现场运行身份/冲突核查。四入口状态修改后，对3份权威、两owner、Core.Cache/Hash、3份公开fixture测试及两个已采用证据根共377个现存文件取只读SHA256基线并在正文修订后复核一致；它不代表全仓基线或运行验证。既有未提交文件由只读git status识别，未暂存/提交/重置，不把既有源码修改归本次。
- **作者检查的限度。** 文本/链接/图与证据字段算术检查由只读脚本在内存完成，不保存或运行新测量框架；编辑器自动Markdown诊断既有clean也有analysis unavailable，不能宣称完整LSP/独立review通过。受影响边界仍包括P1具体可取机制/保存终点、P2逐阶段适用上界/余量和两item/Result/gate至8消费者/最终第10款的连接；本作者不派发复审、不询问用户、不推进Todo、不选择后续工作。范围/预算起点变更确认与受影响边界复审未由本轮完成，用户确认也不能补足机制和耗时证据。

未实施/未检查：生产修复、公开测试或fixture改动、Gradle/Java/编译/生产验证、两时钟新采样、运行前身份/排他检查、缓存/输入写入、新加载/真实miss-rebuild-hit/两次新oracle、独立复审和用户确认；未释放任何新旧gate。
剩余限制：本次文档维护与作者自检完成，预算协议仍not-ready；P1可比时钟/保存终点与P2完整链保守耗时/S无充分证据，不能据此启动P-n或P-v6，也不能把旧1466.68秒变成新链预算承诺。

## 分钟预算撤销与作者自检

**本次一个文档结果：保留已写撤销入口，补齐四文档正文/item/gate/链接并作者自检，不实施。** 联合核对objective/constraints/deliverables为同一完成谓词，加载plan-implementation及documentation-work、documentation-plan-writing、documentation-waves-writing方法，使用四个指定文件和Handoff已采用事实。PRD/ADR/Spec沿用既有reuse评估，无新增产品、架构或公开合同决定，不重开或写权威。旧作者记录、预算调查及not-ready/failed/partial/unknown按原时点保留；下述是本次实际文档操作和内存文本核对，不是独立复审、生产修复或运行验收。

- **实际写入。** Work修正现行维护/权限句及实施披露中的1800秒、全链上界/余量和再确认门槛，旧预算修订作者叙述标为历史；Context新增[用户决定与现行边界](context.md#分钟预算撤销的用户决定与现行边界)，给两段预算调查/起点提案加历史边界，纠正当前范围确认、缓存说明及新旧身份段；Plan替换当前策略的预算/披露条款，给旧矩阵、候选及预算复审作者记录加历史限定，并新增本节；Waves更新P-n/P-v6各自准备与停止条款、两个gate行、最终完整gate第10款及现行连接，新增[执行准备边界](waves.md#预算撤销后的执行准备边界)，旧预算阻断原文限为历史。未重复写四文档原撤销入口，也未全局删除1800、60或unknown等历史文本。
- **现行合同。** 统一1800秒/30分钟截止、起点前UTC/单调配对、跨Handler共同原点/宿主可比证明、交接扣时、最终Result发布末值、全链阶段上界、60秒收束及独立保存余量证明不再是P-n/P-v6启动/继续/Result采用/gate前置；不调查或新增替代分钟上限。原P1机制未建立、P2证据不足仍是事实，原not-ready未改成技术修好或复审通过，只因用户撤销政策退出当前前置；已确认生产修复及完整验收范围不重求许可。本次只有文档维护权限，受影响边界独立复审和实际执行足证据未由作者完成。
- **完整验收与停止保留。** P-n仍为McpAction/必要ResolvePatchedMinecraft两个owner的notch原域rename接线、version9→10/专属operation/input覆盖及四引用真实固定工具正负例；P-v6仍须新实际compiled classes/code source/runtimeClasspath、完整输入/工具/JVM身份、全部4782及原成员/继承/属性/AT/资源/归档/11方法/typed锚点等oracle、真实miss→rebuild→same-path hit→再次完整oracle和fresh/cache/两次final关联。两reference已有效修正不重做、旧9/fresh或四行CLI不代全量。全链最多3次正常网络（含hit）、完整日志/失败分存、正向退出/输出收束、身份/即时排他及真实内容差异/缺字段/控制退出unknown停止保留，窄工具错误仍最小纠正并同版复查；单次工具超时按实际合同，不变成新分钟预算。
- **实际结构核对。** 重读修改后的四文档；四份原入口前7行的文本SHA256与本轮基线相同。重新提取的36个item身份/前置、31个Wave的成员/前置gate与修改前一致，另外34个非目标item正文逐项摘要相同；P-n/P-v6仍不同Handler/Result/单成员Wave/gate，T-basic-v3→P-n→P-v6不变。8个完整P消费者仍为Q-1165/Q-Neo/R/D/B/M/V/H且均消费P-v6；Q各等本组T，R等三T/P-v6/两Q且只阻V/H，D不等Q/Neo/R，B另等D，M另等Q-1165而不等D/B/Neo/R，V/H全量合取保留。源码gate不直接放行完整P，共享source/编译/Gradle/TestKit/fixture/build/cache/input仍串行，未将旧failed/partial/gate转成功设为前置。两个gate新行与本次精确补丁完全一致。原缓存/连续起点/预算修订作者记录除本次新增历史说明外逐字保留，未改写旧自检为本轮结果。
- **历史纠正和编辑归属。** 采用Handoff提供的诊断事实并持久记录于[Context](context.md#分钟预算撤销的用户决定与现行边界)：前次remove-forge-minute-budget-gates generation1终态仍blocked，但四入口确已写入/回读，正文未完，“未写入/外部修改”归因错误；不沿用该错误、不要求未知作者追认。本次首个多块精确补丁未匹配，工具未写入；重读当前受影响段落后定点补齐，后续成功补丁均如实计入本次，不把自己写后的差异认作外部并发。原只读诊断的稳定读取不等于当前文件独占保证，本次未另诊断或声称不存在并发。
- **检查边界与链接。** 三个目标标题均唯一存在，四文档对三个目标的现行引用逐项命中；该检查与上述结构/正文保留核对均已通过。只核本次实际修改、上述三个标题及其现行同目录引用、P-n/P-v6当前合同和必要消费者/gate连接；没有重新审计无关历史或外部会话/Result，未新增仓外持久依赖。作者检查不等于独立局部复审、ready、实施、item completed或gate释放；不派发、不询问用户、不推进Todo或选择后续工作。编辑工具自动Markdown clean/analysis unavailable提示未作为完整LSP或独立复审证据。

未检查/未执行：生产/公共测试/fixture/helper/工具/依赖/缓存/权威写入，Gradle/Java/构建/测试/主动LSP、时钟或进程采样、真实新加载/miss-rebuild-hit/两次oracle及独立复审；仅曾只读git status，没有Git写操作。
剩余限制：本次只完成四文档余下同步与作者自检，实际P-n/P-v6及后继item/gate尚未完成；P1/P2技术缺证仍作为历史保留，不再构成分钟预算前置。

## P-n未完验证恢复图作者自检

**前轮作者自检历史。** 下述编译/四引用未完、0/3及P-v6待运行只描述当时；当前P-n-v已采用完整源码Result，P-v6技术通过/partial及本次一次性例外见页首和[本次自检](#p-v6-例外维护作者自检)，不改写下述历史。

**本轮唯一交付为四协调文档的局部恢复图及作者检查。** 完整Handoff的objective/constraints/deliverables联合检查为一个文档结果，不执行其中未来恢复或P-v6结果。已加载Waves及按其职责加载Plan/Work方法，实际读取全部七个指定仓内上下文及after-edit/compile-exit/tool-correction/compile.py；inline采用与授权按原边界沿用，PRD/ADR/Spec reuse/写入skip，不重开不变权威。

- **实际修改位置及写入。** Work/Context/Plan/Waves各新增当前P-n partial恢复入口；Context新增采用/源码身份/失败与冲突时效边界；本Plan现行游戏rename策略内新增恢复等价标准/权限和本自检；Waves只增原P-n历史限定、一个P-n-v item/单成员Wave/gate，改P-v6输入/成功前置、V/H必要源码输入和最终第1/10款及现行连接。原P-n完整正文（除明确历史限定外）、旧Wave/gate行保留；不是零写入或外部并发修改。本次分文件各一次定点edit写入四文件，写后回读/精确文本复验结果由本次Result报告；此前两次内存脚本错误无项目工具调用/无文件写入，不归因为外部冲突。
- **完整标准及分组。** 新P-n-v只消费已写两owner/version10和身份适用证据，补未完编译/固定工具四引用正负例/源码参数对应。源码identity/notch范围、原域声明优先级/payload分离、真实输入覆盖/Core聚合/路径推导均保留；未证first-win/遮蔽等不得仅引用原partial略过。编译和薄工具只证明保留修正，不独立交付产品。源码漂移/需额外改动报告实际边界，不重做已有效reference或越权修生产。P-v6新加载/全部4782及原完整oracle/10真实miss-rebuild-same-path hit/再次全量不减，CLI和编译不代完整P。
- **实际图检查。** 只读内存解析所有item定义、正向前置首句、Wave成员/前置gate/本gate，联合item→前置及所属Wave、Wave→前置gate、gate→全部成员；由36 item/31 Wave/31 gate、98节点169边变为37/32/32、101节点173边。引用可解析、item唯一归属、Wave非空、无环/自等。P-n-v仅等已采用T-basic-v3及其gate，P-v6消费P-n-v，原P-n partial/旧源码gate不再为P-v6/V/H成功祖先；V/H只替换必要源码终态输入。8个完整P消费者仍均指P-v6，Q/R/D/B/M/V/H业务依赖不变，D/B/M祖先无Neo/R障碍；共享写运行仍串行，不把冲突当成功依赖。
- **历史与停止。** 原P-n partial/两owner/version10、唯一Gradle exit1且Kotlin未运行、修正版仅预检失败/未重启、四引用未执行/正常网络0次保留。旧failed/partial/unknown/全部原gate不回填，T-basic-v3已采用完成及gate事实不改。历史idle不是锁；未来每次构建/CLI前即时复核排他，冲突/真实内容差异/身份或控制退出unknown停止。全链最多3次正常网络当前消费0、窄编写/类型纠错保留失败与同版复查不减，无统一分钟/双时钟/全链上界或替代预算，不调查普通网络原因。
- **受影响独立局部复审边界。** 仅四文档上述新增恢复/历史分界、原成功标准等价、新item/Wave/gate与P-v6/V/H必要消费连接、联合等待/排他/原gate保留；未变三族authority、全量验收及其它业务分支不重开。本作者未发起复审、调度/推进Todo/item/gate、请求确认或宣布ready。持久事实只用可读仓内相对路径，不新增外部会话/Result导航；历史自检只限原时点。

未执行/未检查：源码或测试修改、launcher/证据脚本执行、Gradle/编译/构建/CLI/测试/网络/主动LSP/Git/进程采样/终止、当前源码字节或运行期排他、真实新加载/产物/cache；只作文档文本与图检查，未修改旧证据或创建运行根。
剩余风险：文档作者检查不等于不同Handler局部复审或恢复完成，保留源码仍缺编译/四引用动态足证据；历史无活动观察不能保证未来排他，完整P与所有gate均未由本轮完成或释放。

## P-v6 例外维护作者自检

本节只报告本次四文档维护及实际作者检查；此前作者记录、0次计数与当时未完状态均保留历史，不是本轮运行或复审结论。

- **边界与权威。** Handoff整体是单一四文档一致维护终态；只编辑同目录work/context/plan/waves，未写其它文件或复制旧状态。PRD/译本、隔离ADR、Spec/译本沿用既有reuse/写入skip评估，无新产品/技术决定、无重复许可或新预算/签收要求。
- **事实与证据。** 读取仓内P-v6续接报告、原账本及报告索引中若干completion/identity/task-action JSON，只作来源和引用核对，不运行脚本。账本JSON仍为5标online、normalOnline=2、旧保守计数3；1次Java前失败/4次真实在线Gradle及全离线hit按原报告与已关联Result保留，不能据2/3称未超限。记录用户只接受本次既发生偏差、P-n-v已采用completed/源码gate满足、P-v6 generation1与redelegated generation2语义partial；backend completed不替代该语义。
- **保留与等价。** 回读并按精确替换与编辑前内存文本比对，四文档除本次声明的新增事实/策略/采用图及必要消费连接外保持原文。原P-v6全部原item条目和原W-FORGE-REBUILT-CONTENT/gate行逐字保留，技术标准未降低；最终组合第2–9款逐字未改。旧failed/partial/unknown、原P-n/两owner/version10、全部旧gate判断和失败/覆盖损失均不回填；第1/10款只将完整P成功输入换为新采用结果并保留技术证据要求/此次例外分界。
- **图与消费者。** 文本解析声明/正向前置/成员/前置gate/本gate，清点由37 item/32 Wave/32 gate变为38/33/33，item均唯一归属非空Wave。只对新item和8个直接消费者的必要联合等待闭包做循环/引用检查：42节点100边，无环/自等、引用可解析。新item仅成功等待已采用源码恢复item，单成员新Wave仅等已满足源码gate；原P-v6 partial/旧gate不在新成功祖先。8个消费者正向item前置与修改前仅作完整P输入名称替换，其余技术业务依赖一致；D/B/M仍无Neo/R成功前置，B仍等D，M仍另等Q-1165。共享写运行排他不变，新只读核对与对象变动冲突明确。
- **互链与便携性。** 核对Work/Context/Plan/唯一Waves互链和新增同目录锚点；新增证据链接只指已读取的仓内续接报告和原账本，索引关联的JSON确实可读。不添加外部本地Result/session依赖，不复制完整原报告；作者自检节写后回读与锚点终检由本次Result记录。
- **剩余复审边界。** 待不同Handler局部独立复审此次例外与原技术标准等价、新item/独立Result/单成员Wave/新gate、8消费者及最终第1/10款必要连接。作者未派发/模拟复审、未执行P-v6-a或后继、未采用新Result、未推进任何item/Todo/gate或宣称ready；局部review completed不自动等于通过，新Result/新gate实际采用判定仍归Router。

未执行/未检查：构建/测试/编译/CLI/下载/网络/主动LSP/Git/安装/进程操作、生产/fixture/helper/consumer修改、当前源码/产物/cache重新校验；原技术通过仅采用已给Result及仓内证据，不是本轮重跑。
剩余风险：局部独立复审尚未完成，P-v6-a未执行/无Result/新gate未释放，原P-v6仍partial且旧gate未释放；用户例外不保证未来运行合规，也不满足Q/R/D/B/M/V/H或最终集成验收。

## Remapped M API恢复与作者自检

### 范围、输入与原合同

只恢复原M `RECOVER-REMAPPED-PATCHED` generation1 failed 后未完成的 API/取证及原精确消费；不改变版本、原Java8 consumer、公开API、生产、测试目标或M完整成功条件。复用已确认的三族评估：PRD及译本reuse，隔离ADR reuse，Spec及译本reuse，本次三族写入skip。已采用只读诊断修正仅限 `remapped-patched-test/build.gradle.kts` 原批准迁移范围：`getVersionList(getGlobalCacheDirectory(project).toPath(), isOffline=gradle.startParameter.isOffline).version(targetMinecraftVersion)`、顶层`getAllDependencies(metadata)`、原配置名`universal`及task `universal.from(universalFiles)`、`UserdevConfig.fromFile(...).fold(...)`、`implementation(files(minecraftLibraries))`和named output provider。保持原official→MCP/Java8/srg→named/provider语义；本次不实施。

原M成功谓词不缩减：1.16.5/36.2.39/userdev来源和userdev/MCP/universal/libraries/modules真实解析；ResolvePatchedMinecraft实际patched输出；official client mappings `server=false`；Java8 executable的LoadMappings按official→MCP真实执行并输出含obf/srg/named的Tiny；显式namespace RemapTask真实执行并闭合provider/producer图，输出named Jar；原EVENT_BUS与named `Entity.class` consumer在当前生产Class/Jar与完整classpath上关联；本轮原精确selector真实Gradle exit0、JUnit 1/0/0/0，consumer Java8编译、jar及`printCompileClasspath`均实际到达；完整named Jar/consumer class/Jar/classpath新产物身份和字节对应；同轮nested System属性、StartParameter.systemPropertiesArgs/projectProperties、effective installations、所选Java8 compiler executable/metadata与Test JVM属性/最终arguments/实际withDebug帧关联，判明共享属性语义；实际命令、失败阶段、退出与输出收束完整可读。旧脚本编译、旧Q/D证据、候选/配置声明、跨轮观察均不足。未新增继承/override、启动游戏或额外AT要求。证据/停止合同以[原M图条目](waves.md#recover-remapped-patched--1165-remapped-的真实-named-消费)原合同为基础，仅新item取得独立Result。

### 作者自检

- **单一终态与Result：** fixture API迁移、私有观察和原完整消费共同验证同一M消费谓词，无独立可消费工具/诊断终态；一个新item、一个Handler/Result、单成员Wave/gate，不把文件或检查机械拆开。
- **前置和等待：** 新item仅等P-v6-a及其证据采用gate、Q-1165及其完整gate、G-REPAIRS。无Neo/R/D/B或旧M success依赖；不等自己的gate。其Gate只放行显式下游，不构成自身依赖，故无自环/旧failed祖先环。
- **旧失败及结果：** 原M generation1 `failed`、原脚本编译错误及五项诊断、实际Gradle/JUnit结果、无nested maps/effective toolchain/consumer产物、控制器偏差/未启动jdb及closure限制（不宣称所有worker退出，残留PID/daemon与后续其他项目命令按completion原记录保留）和旧G-RECOVERY不满足全部保留；新成功不改旧Result或释放旧gate。
- **写冲突：** 原remapped fixture脚本/必要测试观察接点属于新M授权范围；与其他共享Forge/Gradle/TestKit/build/fixture/cache写运行串行，和D/B/M所需共享观察点不并行。无新增写权限、生产或公开API修改。
- **V/H连接：** 最终复验/验收仅以新M完整Result替代旧M success输入，保留12项恢复合取、原 `V ∧ F ∧ D ∧ B ∧ M ∧ H` 与fresh三模块/Forge类/根入口及历史映射要求；原failed M作为历史输入可读，不作完成输入。
- **来源与互链：** Work/Context/Plan/Waves四份均按`E:/Projects/cloche/minecraft-codev/docs/works/mixin-review-repair/`定点互链；前次漏`cloche`导致blocked零写入的事实被记录。仓内原M报告/completion和已采用Q/D报告可追溯；无仓外Result locator依赖。三族reuse/write-skip被保留。
- **状态界限：** 本次仅完成文档维护/作者自检，不表示新M已执行、completed、ready、独立复审通过或任何gate释放；实现/运行及局部独立review尚未做。

## Remapped 标准属性恢复策略与作者自检

### 授权、直接传递与JDK角色

本轮唯一交付是四份协调文档维护及作者自检；未实施。两次M failed、作者blocked与实际fixture已写入的矛盾、已写API/provider接线、启动前采样覆盖缺口及全部旧gate保留，见[Context](context.md#remapped-标准属性恢复的采用事实与授权)。不重做有效迁移或已通过Q/P/D/B。PRD/译本、隔离ADR、Spec/译本reuse且写入skip；只恢复原测试消费，不变生产合同。用户已说继续，已撤回人为首次启动限制及Python属性读取器；本次不派发复审或执行实施。未来两个独立终态及gate归[唯一Waves](waves.md#remapped-标准属性恢复连接)。

正常启动外层Gradle，沿用[Forge Test配置](../../../minecraft-codev-forge/build.gradle.kts)现有`providers.gradleProperty("org.gradle.java.installations.paths")`→Test同名系统属性接线。最小runner变化仅在[PatchedMinecraftTests.kt](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt)原helper让remapped像basic读取Test系统属性：在原`[jar, printCompileClasspath, -s]`后追加唯一`-Dorg.gradle.java.installations.paths=完整原值`。完整非空字符串不拆分/重排/规范化或加shell引号；缺失/空值不追加、不发空/null，本次显式列表保证未建立须照实报告。basic行为/版本/consumer/withDebug(true)/withPluginClasspath/forwardOutput/fixture.gradleJava/Test Executor17保持；不另加冲突-P、fixture.*、withEnvironment、配置框架或配置读取器。

正常wrapper启动JVM沿当前Gradle启动配置，不要求先读取尚未启动的Gradle有效属性，也不强制其必须为17或来自该列表；实际身份照实记录。Test17仍由既有`javaToolchains.launcherFor(17)`选择，fixture.gradleJava仍记录外层实际java.home，不改语义。被测Java8由fixture既有`launcherFor(8)`供LoadMappings、`compileJava.javaCompiler`供consumer，Gradle消费转发后的同一有效属性列表并决定选择；Python只控制/保存运行证据，不解析用户properties或自行实现toolchain优先级。

私有验证入口只在全新build证据根最小移植，不照搬[旧run.py](../../../build/recover-remapped-patched-api-recovery-g1/run.py)固定Java8目录/发行版断言或由PATH jdb反推21的做法。Test17的工具路径在下述外层worker启动暂停期取得，再交给私有观察函数；不等待nested启动或compiler选择。helper原先在导入时从PATH固定JDB及立即断言的闭包，仅在新根副本改为由`observe`接收认领后派生的实际路径，使导入和外层spawn不依赖尚未知的jdb；旧helper/basic及131项检查不动。LoadMappings java与consumer javac仍由现有Gradle providers/实际compiler对象提供，保存metadata并与有效列表成员关联；配置声明或目录存在不代选择证明。不安装JDK、不改用户配置或环境、不把启动JVM与被测Java8混同。

### Test worker认领与jdb连接顺序

**暂停与同进程依据。** [现有Test配置](../../../minecraft-codev-forge/build.gradle.kts)39–45行选择Test launcher17；[原入口](../../../build/recover-remapped-patched-api-recovery-g1/run.py)27–29、96–117行正常spawn外层精确测试并在监听出现后认领。该次[启动日志](../../../build/recover-remapped-patched-api-recovery-g1/invocation-1/gradle-output.log)562–564行已封存Test java命令、`GradleWorkerMain`/`'Gradle Test Executor 1'`和`-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005`，其后出现监听；此时OS进程已存在，测试主程序尚在启动暂停期，可先读取身份/安装而无需jdb。外层Test任务的`--debug-jvm`建立这次JDWP暂停；[runner](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt)22行的`withDebug(true)`则让nested构建在Test worker内执行，不另建一个待attach的nested端口/OS进程。后者有同轮[原报告](../../../build/recover-remapped-patched-api-recovery-g1/report.md)及[调试栈](../../../build/recover-remapped-patched-api-recovery-g1/invocation-1/debug-transcript-gbk.txt)中的`RunInProcess.execute`/`SystemPropertySetterExecuter.execute`支持，不能把withDebug当作启动暂停来源。

未来两项各自的新调用均复用以下顺序，不新增启动器、握手框架或gate：

1. **先准备观察，再正常spawn。** 在新证据根加载私有helper副本、准备原输出捕获和身份纯函数；此时不解析用户properties、不找PATH jdb或先跑工具版本命令。分存各次启动前排他及紧邻spawn样本，记本次spawn时点；沿原`:minecraft-codev-forge:test --tests "net.msrandom.minecraftcodev.forge.PatchedMinecraftTests.Test remapped patched Minecraft" --debug-jvm --info`入口和其余原参数启动外层Gradle，立即捕获输出。正常wrapper JVM来源及直接属性链保持，不要求启动前先取得Test安装。
2. **监听出现即在启动暂停期认领。** 收到`Listening for transport dt_socket`后，保存当时进程/listener快照，沿[现有worker_candidates/validated_worker](../../../build/recover-basic-java8-postpatch-evidence/run-batch.py)198–222行：候选创建时间不早于本次spawn、cwd为Forge模块、含`GradleWorkerMain`及实际Test Executor token（保留支持成对单引号）、唯一JDWP参数满足`server=y,suspend=y,transport=dt_socket`及既有`5005`/`localhost:5005`形式；唯一候选与loopback:5005 listener归属一致，并关联本次`--info`的Test启动Command。候选到认领重新核对PID、创建时间、cmdline、cwd四字段和监听归属；不以端口文字、PID或安装目录单独认领，也不要求worker是wrapper直系子进程。此时不要等待Gradle child连接成功、测试方法、nested帧或Java8 compiler输出，它们都在后续恢复执行之后。
3. **从已认领安装取jdb，再复核attach。** 对同一PID读取真实可执行文件（现用psutil的`Process.exe()`），核对它与已保存启动Command及`cmdline[0]`指向同一java文件；路径别名按实际文件身份核对，无法核对即停止。只由该`java.exe`所在bin目录派生`jdb.exe`，记录完整路径/安装关联并检查工具存在，将路径显式传入新根`observe`；不遍历其它JDK、不由`fixture.gradleJava`/PATH或Java8 provider反推。派生完成、启动jdb之前，再调用原`validated_worker`重核四字段和listener，避免派生期间退出或PID复用。随即以argv执行`[实际jdb路径, '-connect', 'com.sun.jdi.SocketAttach:hostname=localhost,port=5005']`，保存命令/时间和debugger身份；不把版本探测、构建或人工等待插入此启动窗口。本次目标VM版本/安装由调试帧关联；工具版本输出放在attach并恢复执行之后或真实收束后保存，关联同一绝对工具文件，不占启动窗口。不假定旧21观察证明17的jdb可用。
4. **先设原断点，再恢复并取同轮值。** 沿[现有observe](../../../build/recover-basic-java8-postpatch-evidence/run-batch.py)265–296行等待初始`main[1]`暂停提示，先设置`DefaultGradleRunner.build`、`DefaultSettingsLoader.findAndLoadSettings`、`ProviderBackedToolchainConfiguration.getInstallationsFromPaths`三个原延迟断点，再发首个`cont`。依次在runner帧记录remapped工程/最终args/isDebug/Test属性，再在同一worker的nested settings帧记录StartParameter两map/System/RunInProcess栈，最后在toolchain帧记录provider/effective installations；保留原clear/cont顺序。随后按原compiler回调/完整M合同继续，而不是寻找第二个nested进程attach。原[调试记录](../../../build/recover-remapped-patched-api-recovery-g1/invocation-1/debug-transcript-gbk.txt)起始暂停、延迟断点和命中已证明此控制流程曾在该remapped入口工作；本轮只复用方法，不将旧观察补入新调用。
5. **尊重实际生命周期并收束。** 启动暂停不是无限存活承诺：[既有失败报告](../../../build/recover-basic-java8-bounded-retry-evidence/report.md)20–21行记未attach时Gradle child握手120.0秒超时。认领→本地路径派生→attach必须在本次仍存活且监听归属可复核时即时完成；任一步超时、身份/监听变化、无工具或无法取得暂停/断点提示，停止并保存真实失败/缺证与退出，不能放行未观察的worker或另换JDK硬凑。该既有工具生命周期事实不新增统一分钟预算/等待协议。继续后仍须真实Gradle/JUnit结果、worker/debugger/launcher退出、输出drain和listener收束，启动前及结束样本分别保存。

这里最小必要私有差异只有延迟接收jdb路径及读取/记录该PID的exe用于同安装核对；候选、认领复核、原断点/继续与收束流程均已有实现。不声称旧helper已支持这两个差异，也不把未来同安装jdb能力或实际窗口成功预写为已证。

### compiler证据的独立可达方法

本次小段核对确认[现有remapped fixture](../../../minecraft-codev-forge/remapped-patched-test/build.gradle.kts)的Java8 compiler两行在`printCompileClasspath.doLast`内且位于完整compileClasspath遍历之后，runner又先请求jar；原写法不能支持“consumer失败但发现独立完成”。未来必要取证改动仅将现有compiler取数/两行输出移到该fixture的配置完成回调，保持已写API/provider及原classpath/其余打印和原任务参数：

```kotlin
gradle.projectsEvaluated {
    val compiler = tasks.compileJava.get().javaCompiler.get()
    println("Java8 compiler: ${compiler.executablePath.asFile}")
    println("Java8 metadata: ${compiler.metadata.languageVersion}")
}
```

回调在本次fixture配置成功后、任务依赖图/compileClasspath解析及任何任务action之前读取原compileJava上实际配置的compiler provider；不遍历sourceSets/configuration，不调用jar或改compiler，不新增探针任务。此处`.get()`是真实解析，记录executable/metadata=8及安装与完整列表的对应，并与同轮nested System/StartParameter两map/gradleProperty/effective installations、工程/调用/阶段和实际调试帧关联。它是选中的compiler证据，不是javac进程已执行；真实Java8编译/LoadMappings执行仍属于完整M。已写fixture的API迁移不重做；此次仅必要取证时点移动，写冲突和复审必须覆盖该fixture。配置提前失败、provider解析失败/阻塞、未到回调或观察/收束不足均不得把发现记completed；这是具体待实施验证方法，本次未证明动态可达。

### 验证与恢复边界

转发及必要私有观察/取证调整只服务一个独立Java8发现Result，不交付工具产品。小回归检查basic保持、remapped多目录/空格完整单参、缺失/空值不追加、无重复-D/冲突-P；新根实际工具路径传递的小自检覆盖从Gradle worker路径派生jdb及缺工具拒绝，不重做候选选择器或131项旧检查。实际调用仍只走原remapped精确方法。发现须某一次同轮完整值→唯一-D→nested System、StartParameter.systemPropertiesArgs含键/projectProperties无冲突-P、gradleProperty provider、effective installations和上述真实解析compiler metadata/executable闭合。下游失败不抹去已有足证据发现，但必须保留真实Gradle/JUnit失败、未到达阶段及收束，不称M成功。只有新发现完整Result被采用且gate判定满足，独立后继消费者才能消费；摘要/旧轮/Q/D/P不能代后继实证。

运行前各次排他样本、紧邻spawn样本与结束样本分存不可覆盖，关联源码/输入/进程/调用/阶段/UTC、真实退出、输出drain及worker/debugger/listener收束；不杀他人进程，不回填旧缺口。无统一分钟预算、额外在线额度或重试框架；真实工具timeout照实记录。缺输入/权限/工具能力为blocked，实际调用失败照实failed；发现的完整性单独判定，不能以控制器0替代真实Gradle/JUnit结果。

完整M仍须MC1.16.5/Forge36.2.39/userdev真实userdev/MCP/universal/libraries/modules输入→patched→official client mappings(server=false)→Java8 LoadMappings official→MCP→含obf/srg/named的真实Tiny→显式srg→named RemapTask/provider/producer→原EVENT_BUS/named Entity.class Java8 consumer真实compileJava/jar/printCompileClasspath与fresh patched/named/consumer class/Jar/完整classpath字节身份；同轮nested两map/provider/effective installations/实际compiler及编译执行证据，真实Gradle exit0、JUnit1/0/0/0和退出/输出收束缺一不可。消费者在自己的新调用中重新取得compiler回调输出并证明后续真实编译，不拿前项观察补证。V/H最终内容仍重取basic/remapped两套同轮观察、各非空runner唯一完整-D，外层Provider无直接帧限制不变。最终12项完整恢复合取仅替换M消费者输入，发现是M真实前置，不是Q/P/D/B重跑。

### 本轮作者语义自检与局部独立复审范围

**前轮直接传递修订的作者记录。** 以下统计和复审范围保留原时点；本次只修正worker认领/工具取得/attach时序，当前实际检查及精确复核范围见下节，不重开已获复审支持的部分。

- 单一维护结果：四文档及必要源码小段核对仅建立同一协调计划修正；无第二个实现/诊断/独立复审结果。未来Java8发现与完整named消费者各自可独立保留、失败和恢复，继续两个item/Handler/Result；转发、私有工具路径和compiler取证时点无独立消费者，不额外拆项。
- 前置/冲突：新发现与完整消费者都保留P-v6-a、Q-1165完整Result/gate及G-REPAIRS；消费者另等新发现Result/gate。无旧失败、Neo/R/D/B或自身gate成功等待。共享PatchedMinecraftTests.kt、必要remapped fixture取证接点、Gradle/TestKit/build/cache/观察点按最新内容串行；排他不冒充成功依赖。V/H仍消费完整M及全部原合取。
- 证据充分性：P1以正常Gradle启动和现有直接传值消除人为循环，不再要求Python读属性/选择启动候选；P2以配置完成回调的实际compiler provider解析绕开jar/classpath可达依赖。回调只证选择，完整M保留真实LoadMappings/编译打包、全classpath/产物及退出要求。运行前样本覆盖缺口及两次failed/作者blocked矛盾永久保留。
- 实际作者检查：仅四文档定点维护；受影响源码核对为Forge Test属性接线、共享helper两个调用点、remapped toolchain及classpath/打印先后、旧私有入口JDK常量和观察闭包。工具内联合检查41个item、36个非空Wave、113个item/Wave/gate节点：唯一归属、引用可解析、无环/自等；发现→完整M→V/H成立，发现及M均无旧失败gate/Neo/R/D/B成功祖先。Wave表全部行不变；除两个M项及最终gate必要说明外其余item块摘要不变，Plan/Context本节之前的历史摘要不变。对四文档当前受影响入口/末节及必要连接的52个仓内链接核对文件存在和标题锚点，均可解析；不把前轮静态统计当运行证据。
- 精确局部独立复审范围：本节及Context本轮采用节、Work首段；Waves标准属性恢复的两个item/两个Wave及gate、其P-v6-a/Q-1165/G-REPAIRS输入、共享冲突表、V/H前置和最终gate第1/9款必要连接。重点是正常启动/Gradle工具路径来源、fixture配置完成回调能否独立取实际compiler、完整M不被发现代替。其余Q/P/D/B/历史及最终fresh三模块/Forge三类/根入口不重审；本作者未执行或模拟不同Handler复审。

未实施/未动态验证：runner、fixture回调、私有工具、JDK能力、构建测试下载和用户配置；未操作Git或生成备份。
风险与未决：配置完成回调和Gradle所选Test安装的jdb真实能力仍须在授权实施中验证；材料性差异尚未获不同Handler局部独立复审及Router实施确认，不宣称ready、实际item完成或gate释放。

### Test worker时序修正作者自检

本次唯一结果是四文档的同一局部计划维护及作者自检。按完整objective/constraints/deliverables判为一个终态；已加载plan-implementation及Work/Plan/Waves三个companion，沿用三族reuse/写入skip和所给已采用复审。正常外层启动、直接属性传递、两个独立终态及必要连接已获支持，`projectsEvaluated`实际解析留作未来实施验证，不再列为本次独立设计缺失。

- **证据与时序：** 已定点读取Test launcher配置/runner、旧入口spawn→监听→认领、helper身份/候选/attach/断点先后，以及同轮实际worker命令/身份/调试栈和旧120秒握手失败报告。可执行链为正常spawn→外层JDWP启动暂停→唯一worker认领→同安装派生jdb→attach前复核→初始暂停设断点→cont→同worker内nested观察→真实收束。withDebug只负责nested同进程，工具取得不依赖nested/Java8/compiler先执行；不保证无限暂停或未测jdb能力。
- **必要差异与保留：** 仅新根helper延迟接收jdb路径及读取已认领PID的exe，同安装关联在attach前完成，原basic/helper/131项不重做。fixture路径已按实际`minecraft-codev-forge/remapped-patched-test/build.gradle.kts`核对存在。已写API/provider、compiler策略、MC/Forge版本、consumer、原M全部验收、两次failed/作者blocked矛盾、样本分存/真实退出/共享构建串行及旧gate保持；两个M终态、其输入和V/H消费不变。
- **精确定点独立复核范围：** Work首段本次时序入口、Context标准属性节新增复审采用及暂停证据段、本Plan私有入口段/本时序小节/本自检、Waves两个M项的时序引用及继承关系。必要连接仅核对两个item各自原前置、两个单成员Wave/gate、消费者另等发现、V/H仍消费完整M和共享运行冲突；不重审已通过正常启动/直接转发/图连接、compiler回调设计或Q/P/D/B，不发起独立复审。

- **写后核对：** 已回读受影响段，34处相对文件/标题链接均可解析、方法标题唯一。41个item的前置及36个Wave/gate表行与修改前一致；仅两个M item正文改变，其余39项正文摘要相同；两个M及V/H的必要联合等待闭包47节点引用可解析、无环。compiler策略段、Plan/Context本次节以前的历史和Work其余正文摘要均保持原值。此为静态文本检查，不证明gate满足；未用编辑器自动Markdown提示代替该检查。

未执行：Gradle/测试/JDK、进程探测或工具/依赖下载，未改源码/脚本/配置/权威/缓存/Git，也未生成备份。剩余限制：同安装jdb能力、实际启动窗口及compiler回调/完整M仍待未来授权实施动态验证；能力不具备按原合同报告。本次未作独立复审/实施确认，不宣称ready、item完成或gate释放。

## Neo仅运行恢复策略与作者自检

**历史准备时点：本项随后generation1 failed，累计三次Neo failed。现行新范围见页首统一代理准备；本节旧仅运行授权不支持新源码代理改动，不再作为成功输入。**

匹配[Work](work.md#neo仅未完运行的现行恢复安排)、[Waves](waves.md#recover-forge-patch-neo-validation--仅未完t-neo运行恢复)与[Context](context.md#neo名称纠正已生效后的仅运行恢复)。沿用已接受PRD codev-mixin-rework、ADR mixin-operation-isolation、Spec mixin-preapplication的reuse评估，权威写入skip；本次不改变产品/隔离/缓存合同。旧两次Neo failed和名称修正已生效同时保留，不把网络失败解释为修正无效，也不把stage2通过当准备成功。下方旧策略中源码纠正权限及原恢复成功等待仅属历史。

仅一次新的原精确selector运行，由新独立Result取得原T-Neo全部准备；只写新build证据根必要薄入口/报告及正常私有输出/cache，不修fixture/helper/test/生产/配置/依赖/JDK/仓库/代理/Git，不重建验证框架。失败或unknown停止保存，无同批第二次调用或网络调查。真实累计记录为原PREPARE一次＋名称恢复一次＋本次至多一次；新item不重置任何直接适用的既有次数约束，执行前核对适用授权，若确有直接上限不足即报告blocked；P或basic专用3次/1800秒不能硬套Neo，本次不造新的分钟预算。

启动前核对前次实际目标已结束、输出已保存、当前共享资源无冲突及本次实际控制身份/正常退出和保全能力；历史空数组/目录或旧采样不代当前核对。普通缓存记账不增加逐文件副作用审计，缺网络早败后续见证不假充成功，也不是新开网络调查前置。共享Forge/Gradle/TestKit/build/fixture/helper/cache及输入写运行串行。G-REPAIRS已采用满足，不等旧failed转成功或自身gate。

成功必须同轮原selector Gradle exit0及JUnit1/0/0/0，固定MC1.21/NeoForge21.0.76-beta/NeoForm1.21-20240613.152323实取输入、真实provider和Java21工具角色、独立official参考、具体类/接口引用/资源见证、适用AT/Dist/marker原边界、完整隔离、prepared及最终output、输入/工具/JVM/argv/阶段/任务图/实际退出和日志全关联。未到达不记不适用、不拼轮；candidate JavaProbe/旧归档/编译成功不代证。新gate只建立完整T-Neo准备，Q-Neo仍独立承担原完整内容及neoforge有效路径/冷热缓存；R/V/H仍按原完整合取等待，不回填两旧gate。

作者自检及局部独立复核范围：本次四文档为一个安排终态，运行恢复自身为未来独立Result，未混入实施；定点核对失败report/verification/change.patch与原T-Neo完整合同、唯一新item/单成员Wave/G-REPAIRS入口、Q-Neo item与Wave双层换接、R/V/H及最终十二项合取的对应替换，保留所有其它前置/共享冲突、旧失败/旧gate及Java8独立分支。联合等待为G-REPAIRS→新准备→Q-Neo→R→V→H，Q另等原完整P证据，无回边/自等。受影响独立复核应覆盖这些变更及必要连接，不重审未变basic/1165/remapped或重新验证已生效修正。作者检查不是独立ready、运行成功、实施确认或gate释放；动态启动条件和完整T-Neo仍未证明。

## Neo准备失败后的独立最小恢复策略与作者自检

原 `PREPARE-FORGE-PATCH-NEO` generation1 failed 及其停止边界、三份已写私有 fixture/helper/test、`compileTestKotlin` 通过、固定 NeoForge/NeoForm 输入和未到达 output 事实全部保留。新增一个独立恢复结果，仅承接未完成的 T-Neo 准备；允许修正新增 fixture 中报告已定位的 `java.nio.file` 名称解析冲突，保留有效实现、输入、权限和原 selector，不拆出工具修正产品，不进行一般重试或根因扩展。

恢复验收仍逐项执行原 T-Neo 完整合同：实际 Java21 角色与 provider、NeoForge/NeoForm固定来源、独立 official 参考、patched/reference/final身份与原具体类/引用/资源等见证（保持原适用AT/Dist/marker边界，Q-Neo内容/冷热合同仍单独验收）、完整私有隔离、实际任务图和阶段、最终 output、命令/JVM/退出/收束证据。仅 fixture 配置名称纠正或编译通过不能完成恢复。恢复 Result completed 且被采用后，Q-Neo 才可消费；R/V/H 继续等待其必要的完整 Neo/Q 合同，旧失败和旧 gate 不变。

作者自检：已对照 Work、Context、原 Plan/Waves 的 T-Neo、Q-Neo、R/V/H 连接及仓内失败报告/verification.json，确认恢复只有一个 T-Neo 完整谓词、写入范围仅新增私有 fixture 名称冲突纠正及必要新证据、旧失败/旧 gate 保留、Java21/provider/参考/见证/隔离/output要求未削弱。受影响独立局部复核应检查该恢复 item/Wave、Q-Neo 及 R/V/H 等待边；本次未实施、未运行，不能称 ready、completed 或 gate 通过。
