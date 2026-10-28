# Mixin Kotlin-first 重设计 Plan

[Work](work.md) · [processed Context](context.md) · **唯一匹配执行图：[Waves](waves.md)**

**状态：已确认八点范围完成，最终可移植完成记录同步。** 当前新版活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 全部 completed；S01/S09 保留 partial。Router 已完整采用关联业务 Results，并独立判断 W04/W05/W06/W07 satisfied；已确认八点范围无剩余实际执行项。旧 I01 blocked、I03 partial、R01/I02 completed、W01 satisfied、W02 未释放、I04 未执行、W03 pending 均不变。 详细采用事实见 [Context](context.md#已采用的最终完成记录)。本次不实施、不重验组件、不改 scope/成功条件/图义，不自行释放 gate；下文策略/验证安排仍为原合同，旧准备时点明确区分。

## 权威、结果与排除项

采用 [Work 三族 assessment](work.md#原权威复用)：当前 [Active PRD](../../prd/codev-mixin-rework.md)、[英文 Spec](../../spec/mixin-preapplication.md)/[同步中文稿](../../spec/mixin-preapplication.zh-CN.md)、[Accepted 同 identity ADR](../../adr/mixin-operation-isolation.md)均 reuse。本轮双语 Spec、PRD 与原 ADR 的对齐已由 Router 采用 completed；ADR 原 writer blocked 与恢复 completed 分开见 [Context](context.md#本轮权威同步的后来事实)。Spec 的“ADR 待同步”旧维护注记不否定后来完成，不据此重做 authority/选型。HTML/D 盘只有设计历史地位；八点后的 owner 优先。日志局部 assessment 也已由 Router 完整采用并可见：PRD R4/R6/AC4、双语 Spec 的普通可读诊断/非日志判决及现 child-service ADR owner 足够，三族 reuse；本次不重选 authority 或日志设计。

**整体结果**：以已落地 Kotlin-first producer/Strip 作为起点，落实 Core 签名复用、metadata 各格式当前编辑、必要原键读取与原生引擎决策、就近资源/文件序列化、保持能力的 Tiny 改名和 native selector 初始化；补仍适用 I03 证据缺口，真实 caller 可消费当前 applied-only 或同操作完整清理结果，并在输入变化/正常缓存复用/失败中保持诚实。文件接口、通知/all-match、fresh loader、真实命名/资源/输入/失败保护未重选。

**排除**：不重做 Java→Kotlin 或旧 producer seam/框架清退，不要求旧 ABI/DSL/records 或外部 caller 兼容，不做全游戏/新支持矩阵、完整应用/注入语义证明、日志判决、source/hash/receipt/账本/证据包、原 Result 副本、自动注册/聚合交付/用途路由、通用资源/codec/锁/属性 lease/发布替代框架或多文件事务。不升级引擎/依赖/锁/工具链，不改无关 Core/Includes/Forge patch、旧退役测试/fixture、cache/remapper/launch 架构。**Core 新增写边界仅 ListedFileHandler 函数注释，原签名/Jar-in-Jar 调用不动。**

## 职责与最小迁移策略

下表是 scope/ownership/verification 变化，不是第二执行图；实际 item 谓词与等待只在 Waves。复用当前实现及未变证据，必要迁移/直接 callers/聚焦回归跟同一终态，不留悬空 SPI、反射/生成源码调用或长期双轨。

| 已接受变化 | owner 与策略；重要验证变化 |
| --- | --- |
| 1. Core 继承与最小注释 | Mixins listing/handler 继承 Core 原接口，resource/side snapshot/list 与显式编辑保持；Core 两函数注释从 included JAR/物理删除澄清为资源引用/声明，函数/原 Jar-in-Jar 调用不动。补 Core-typed 真实消费/SPI 与触及 Jar-in-Jar 最小保留，不再要求“无 Core inheritance”。 |
| 2. 去 ArchiveResources | Mixins discovery/loader/child/recorder/Strip 实际资源 owner 直接使用现有 NIO/JAR/loader scoped use，必要本地路径/业务校验不随删层丢失；删除全部直接 callers 而非换名 façade。回归实际输入域、class/resource 一致、path/UTF-8/read/close/原输入及触及 Strip 保留。 |
| 3–4. 去重复预读与平台分立 | Fabric JSON、Forge Manifest、NeoForge TOML 各自在实际 load/edit 边界处理当前 metadata。删除 tomlMixins/checkReferences/snapshot-age/equality，不迁成新 helper。NeoForge extraction 必须退出 Forge combined TOML 分派；Manifest 当前编辑可单独完成，与 Fabric 各有独立终态。补同 ZIP 不同引用集合的双发现、分别编辑只动 owner、load 后新增引用/未知内容、TOML 扩展字段不作 Fabric side、真实 load/save/close 失败。旧“两格式相等/引用后来变化就失败”不再是新 gate 条件。producer 仍只读，Strip 不发现/编辑 Loader metadata。 |
| 5. 去 child 预验/转换后巡检 | Mixins child 只做原键/必要 parent 遍历读取、side/mapping、注册/真实逐 entry 转换，保留 target @Mixin 定义；visited 用于终止而非另证 parent 正确。不得预扫所有声明类/plugin/refmap 存在或同源、重复 DOM、转换后审 active/environment/plugin/refmap，不能改名搬家。正常 required/optional/side/plugin/refmap/default-mapper 返回不追加 Codev 失败；必需 mapping/显式 context、实际读取/业务/UTF-8/path/取消/engine/I/O/close 异常仍传播。未知 refmapWrapper 字段不单独否决/重写/认证。 |
| 6. 去 AppliedMixins codec | Host Task 生命周期中直接写、Strip 本地读同一 resource→原串数组文件；所有原串业务校验、平台 tests/反射/fault callers 就近迁移，不新 schema/公共 codec。补真实文件互通、手写/其它任务独立 strip、格式/业务/path/DOM/空与缺失区分；写者与读者共同建立单一文件交接终态。 |
| 7. TinyMappingRemapper | Mixins 仅 Exact→Tiny 名称及 child/tests/反射迁移，不改 MappingReader 输入能力、锁定 engine/mapping-io 或 owner/name/descriptor、双向/null/unmapped/歧义语义。聚焦既有 mapping/真实注入，并检既有自动格式入口及已支持非 Tiny 输入，非新格式设计。 |
| 8. native service selectors | Mixins host/loader/child service/bootstrap/global-property 与 native tracking：删合成 service-resource 重定向。参与 Codev host copies 共用 JVM 级短初始化互斥，任何 child engine init 前保存两 selector 值/unset→临时选择 Codev→缓存 child service并安装/cache child global-property→finally 恢复后释放；无第三 selector。不串行全转换。恢复失败向外且保前 cause；原 selector 值/其它操作临时值不作 option input，其它有效 native options/unset/default/implementation classpath 继续跟踪。补成功/失败/取消/unset/恢复失败、多 host copy 与转换 overlap；承认非参与 host 可观察/干扰窗口。 |

原 I03 的真实结果可保留：producer seam、Task 两输出/输入、旧控制/SHA/parser/publication 退出和已验证输入域/映射/失败保护；不因为新版工作重跑这些独立效果。**残余通知准确性**与**残余 producer 完成生命周期**是可独立消费/失败/重试的边界，分别补 unknown/dynamic 新 recorder 观察与 JDK graph/关闭顺序/中途流 write-close 证据，不能合成“所有 I03 剩余”一个混合成功。删除预验时不把被撤销的正常 fallback 拒绝当恢复债。S09 后来已补实际 unknown/dynamic、多目标和文件/Strip，但普通引擎诊断仍缺证，Result partial；已完成通知在日志恢复失败后仍有独立价值，故本次另以 S14 承接剩余诊断可读，而不重放通知或并入 S10/S11。

S01 原契约验收 partial 及全 predicate/scope/owner/evidence 不改；S13 恢复边界的原要求保留。后来 S13/g1 completed，零源码修改、补跑两个受影响接点均过，Router 结合 S02/S03/S12 已判 W04 satisfied；不是本次作者验收。S02/S03/S12 当前 adapters/fixtures 和 S04 资源修正是其输入，原 S01 6 过/2 cleanup fail 不倒改，原迁移不重放。W04 活跃成员仍为 S13/S02/S03/S12，全部 Core/Jar-in-Jar/snapshot/list/三格式当前编辑与双发现标准不减；旧 S01 partial 不成为死等或被自动完成。原映射仍由 [Waves S13](waves.md#mkf-s13--s01-剩余-core-可消费契约验收恢复)唯一拥有。

S09 剩余恢复只在现有 child `OperationService.createLogger` 工厂扩展点采用锁定引擎已有可见 console adapter，保留原生缓存/调用者，不在初始化后换 cache；一个已有真实 optional 多目标测试增强日志观察，继续保正常完成、精确通知、Strip 与 raw 保护。诊断已运行确认 child/logger/processor/cache 同一 no-op 对象，故不是仅漏抓输出。新增 S14 消费 S05/S06/S08 当前原生处理/文件/child-service Results，并按版本/输入/覆盖复用 S09 partial 已完成的通知/异常/文件证据。它不新增固定 severity/格式、全量 DEBUG/TRACE、持久化、Gradle 专属 callback 或跨 loader 日志返回；optional 错误可以 WARN，不能固定 ERROR。修复/单个关联回归仅共同建立一个剩余可读诊断终态，细节由 [Waves S14](waves.md#mkf-s14--s09-剩余普通引擎诊断可见性恢复)唯一拥有。W05 活跃成员用 S14 替代 S09，原 S09 全要求及 partial 保留；新 Result 不自动完成旧 S09/释放 gate。

调用流保持 host raw 输入/Loader 发现→fresh child 整 JAR/通知→关 archive→JDK Map/Set→关 loader→host 写完 entry→两输出完成；Strip 只按 supplied 文件精确删数组内容，自管单 JAR workspace/关闭，不引擎/metadata。caller 显式 registerTransform、参数/from-to/attributes/view/producer dependency、raw sources＋derived target 完整消费；resolution-only 排除，不 feedback stripped inputs、不跨操作 union，不接管下游用途。两个生产者仍独立完成，不要求任意 caller 事务。

真实前置/冲突与 gates 由 Waves 明示：未消费某 Result 的编辑不因编号/Wave 被串成业务依赖；共享源码/fixture/daemon/cache/output 交还所有权后按最新状态串行。最终 caller 的组合/复用是当前链合同，不是新 cache 功能或独立重复终验。若不得不改生产算法或 authority，caller Handler 报具体失败及已做范围，不吞成第二结果。回退仅限授权自有改动，不 reset 混合工作树，不恢复被排除框架来追绿。

## 验证安排与完成条件

下列全是**完成要求**，已采用的新版 S01/S02/S03/S04/S12 结果和后来 S05–S09/S13、诊断事实及版本/产物限制见 [Context](context.md#已采用的-s09-partial-及诊断恢复边界)，不因记录完成而假定覆盖所有现行条件；旧执行与局限见 [I03 记录](context.md#已采用的-i03-partial)。按 [Spec 当前九行验收](../../spec/mixin-preapplication.md#build-copy-acceptance-conditions)关联现 PRD 的 AC2/3/4/5/9/11。Waves 是 item 细节 owner，表只追踪成功条件；旧 through counts、源码位置、删除类名、cache 标签不是新证据。

| 当前条件 / PRD | 所需可观察结果及证据复用/变化 | 新 item → gate |
| --- | --- | --- |
| Inputs / R3 AC3 | Core-typed resource/side snapshot；Fabric/Forge/NeoForge 当前 metadata 与双格式并存/新增/未知内容；task-only plugin/body/resource、resolution→sources→target、source/target-only discovery、Windows ZIP；真实歧义/业务/path/UTF-8/其它 malformed 失败。全部 Codev metadata/config/parent/refmap/entry JSON 的 duplicate/raw-control 含未知值对照实际库，不加扫描/固定边缘结果。正常 plugin/refmap fallback 交 engine，不一律拒绝。 | S01 原要求经 S13 恢复＋S02/S03/S12 → W04；S04/S05/S08 → W05；S06 → W06；S11 输入变化 → W07 |
| Names / R8 AC9 | Tiny 名称在 refmap→MemberInfo→engine chain 真实 mapped injection；原 MappingReader 能力/非 Tiny、owner/重载/descriptor 双向/null/unmapped/歧义；兼容名/no-refmap/default mapper 正常，坏 tuple/namespace/显式 context/方向失败不假成功。 | S05/S07 → W05；S11 变化/复用 → W07 |
| Isolation / R2 AC2 | fresh loader、同 JVM A→B、失败 retry、独立 overlap 对 serial；JDK graph/归档及 loader 关闭后可用。native service/bootstrap 及 child global-property 独有，参与窗口互斥且恢复/失败 cause/取消/unset 正确、恢复后转换可 overlap；TCCL/资源/JAR 可释放、冲突目的地不混。 | S04/S08 → W05；S10 → W06 |
| Engine outcomes and logs / R4 R6 AC4 | 真实输出可调用、target @Mixin 定义保留；原生排除/optional 缺类/plugin-refmap/default mapper 正常不追加失败，删除预扫/后验；普通原生处理/诊断日志实际可读、供用户阅读而非生产解析判决；真实 exception 区别于日志/partial/unknown 正常返回。新 recorder config＋Mixin 精确原键、unknown/dynamic 不造键/不撤销已知、候选未通知不造键，不证完整应用。 | S05＋S09 已完成通知证据经 S14 剩余日志关联验收 → W05；S10 完成与 S11 消费 → W06/W07 |
| Applied outputs and exact cleanup / R5 R4 R6 AC5 | 手写/其它任务独立 strip；同路径/原串同数组/跨数组/JAR 全删，不同键保留；未知 DOM/顺序/空 config/class/refmap/metadata/CRC/STORED/资源保留，无变化原 bytes。真实 producer 多目标通知后完整集合消费；正常部分/unknown 不取消通知资格。 | S04/S06 的受影响 I02 回归 → W05/W06；S09 已完成通知/Strip 证据＋S14 日志同场不否决资格 → W05；S11 完整流 → W07 |
| Task/Transform registration and collection / R3 R5 R10 AC3 AC5 AC11 | 真实 registerTransform/参数/from-to/view 与 dependency；raw sources＋derived target 都消费同操作 Strip，resolution-only 排除，不 feedback/union，不新 inventory。 | S11 → W07（组件文件契约 S06/S10 → W06） |
| User-directed use and completed delivery / R10 AC11 | applied-only 与 complete-cleanup 分别消费；source-strip/derived-target-strip 失败各使所需消费失败，不否定另一已完成组件；原输入不变、无用途/身份限制/自动路由/聚合出口，正常引擎返回不代组件完成。 | S10 → W06；S11 → W07 |
| Reuse and input changes / R3 R5 R10 AC3 AC5 AC11 | 同一链 SUCCESS→UP-TO-DATE→清自有输出后 FROM-CACHE，恢复两个 outputs、新 consumer 无 producer memory 仍清理/正确复用全部 required strip并验内容；逐类 config/plugin body/resource/mapping/side/context/其它有效 native property/unset/default/有序 runtime/implementation 改变产当前内容，独立 removalsFile/inputArtifact 也跟踪。原/临时 selectors 不作为 option input；合法空不等缺失/坏/stale。 | S08 跟踪 → W05；S06 文件 → W06；S11 → W07 |
| Failure safety / R6 R10 AC4 AC5 AC11 | 原输出后 invalid/engine throw/取消/真实 read/write/close/exit/selector restore 失败，stage/cause/已知身份或未知诚实；target/entry 中途 write、entry stream close、输入 ZIP close 必须真正触达。graph及时序、physical aliases/保护目录/冲突目的地/unsafe path/原输入/另一操作保持，半结果或旧 pair 不消费、retry 干净。不把正常 fallback 当失败负例。 | S02/S03/S12 → W04；S04/S05/S08 → W05；S06/S10 → W06；S11 消费 → W07 |

**新版 Plan 终止条件**：仅新版 MKF-W04/W05/W06/W07 的全部活跃 Results completed 且充分满足 gates，由 Router 完整读取/关联并实际判断。W04 为 S13/S02/S03/S12，已由 Router 判 satisfied；W05 为 S04/S05/S07/S08/S14，须原 S09 全部要求的仍有效证据与剩余日志关联验收共同充分，不含历史 partial S09；W06/W07 原要求不变；Router 已结合 S06/S10、S11 九行映射及三个前置 gates 分别判断 W06/W07 satisfied，W05 亦已按上述完整基线判 satisfied。旧 S01/S09 partial 不等待变 completed、也不被恢复自动升级；旧 W01 satisfied、W02/W03 未释放不变。partial/blocked/failed 或证据不足不能满足 gate，本次仅记录 Router 的既定完成/gate 判断，不重新裁判。

未来用 Codev 现有 wrapper 的 `:minecraft-codev-mixins:test` / `:minecraft-codev-fabric:test` / `:minecraft-codev-forge:test` 按变更选实际 suites/methods，小真实类/JAR、metadata fixtures、JUnit/TestKit 即足够；不下载/启动游戏或规定次数/全旧 suites。Result 报真实命令、测试 JVM/环境、selectors/结果/fail/skip、内容断言、未触达路径。必要注入接点必须证明已命中，旧类消失导致未注入不算失败检查通过。

复用以**源码/输入/配置/环境/覆盖与新鲜度**为界：R01/I02 原 snapshot/Strip、I03 既有 mapping/输入/状态场景只覆盖未变部分；Core/edit/资源/codec/child/service/fault 接点直接影响处补聚焦回归，不重做语言迁移、旧无关回滚或完整终验。I03 A 在最后 missing-input 补丁前，C 最后 test 为 UP-TO-DATE，不能写成同字节全套通过。JDK17 SecurityManager 旧设施不能覆盖真实流 mid-write/close，必要用实际 I/O/关闭的最小接点，不泛化故障框架、不改变生产最低版本。不能运行必需检查时如实 partial/blocked，不删保护追绿。

## 风险、取舍与审查边界

- **selector 窗口与并发**：必须所有参与 host copies 共用 JVM 级初始化排他，而非每 child 局部锁；选择/child global-property 适配受锁定引擎私有接点影响。两个属性本身不能安装 global-property。成功/失败/取消及恢复失败都要测，互斥只到恢复，不锁整转换。非参与 host 可看见/干扰临时值，任意插件副作用不受沙箱保护。若引擎/宿主实证无法满足，共同 owner 的 authority 缺口返回 Router，不发明锁/lease 平台。
- **删预验不是删真实保护**：旧额外拒绝会把正常 required/optional/plugin/refmap 返回升级失败，必须退出；实际读取/path/UTF-8/业务/mapping/context/engine/read/write/close 仍传播。DOM 库标准 raw-control/duplicate 策略不保证 engine 同样接受，也不豁免业务值；库探针/旧通过数不证明当前接线。
- **当前 metadata 与快照**：discovery snapshot 仍稳定，edit 读取当前内容，不用 snapshot 覆盖后加引用；不把“当前编辑”变成不校验业务结构。S03 必要分派迁移与 S12 Manifest 行为可独立保留/重试，必须显示两边的连接，不用新 combined shim 掩盖半完成。
- **资源/文件就近所有权**：删除两工具层会触及 host、child、Strip 和测试反射；每项保证直接 callers 可构建/异常完整，真实 close/write 证据不能从旧打开拒绝或 Strip 推到 producer。不新造多文件事务，ATOMIC_MOVE 不支持仍是当前真实失败限制。
- **兼容/范围**：Tiny 仅改名不能丢 MappingReader 支持；Core 仅注释/既有继承不扩 ABI，触及 Jar-in-Jar/AW/AT/nested-JAR 保留基线不变成重做。混合工作树保留、不用 reset/stage 证明保存。
- **S09 恢复图维护时点受影响独立 review 的精确集合（历史）**：S09 原 predicate/scope/evidence 与 partial、实际 unknown/dynamic/parent/同类异 config/多目标/entry-file/Strip 已完成效果及分轮/复用限制；诊断的实际 child no-op 结论、原生 WARN/正常返回与真实异常区别；新 S14 的唯一日志可读＋同场资格谓词、仅 OperationService 工厂/一个已有测试 owner、证据映射与写/运行冲突；W05 替换 membership 及不削减的原全部 gate 条件。必要连接包括 S05/S06/S08 已采用输入与日志缺口不被 completed 隐去、S14 只等这些 items 而非 W05/W06 gate、S10 原 S04/S06/S08 前置不变、S11 仅经 W05/W06 组合消费及 W07 传递等待；Plan Engine outcomes and logs / Applied outputs 行、Work/Context 后来事实与便携性。S13 completed/W04 satisfied 仅投影 Router 已判事实，S01/I03 partial/旧 gates 保留；不自动重审未变八点/旧 S13 图或全部组件实现。作者自检不是独立 review、修复实施或 gate 判断，未变确认范围不重复审批。

## 最终完成记录同步

当前新版活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 全部 completed；S01/S09 保留 partial。Router 已完整采用关联业务 Results，并独立判断 W04/W05/W06/W07 satisfied；已确认八点范围无剩余实际执行项。旧 I01 blocked、I03 partial、R01/I02 completed、W01 satisfied、W02 未释放、I04 未执行、W03 pending 均不变。 本次 C5 仅同步原四文档，零实现改动、零项目执行；不改下表九行成功条件、实施策略、图的任何要求或 authority。W04 由 S13/S02/S03/S12 支撑；W05 由 S04/S05/S07/S08/S14 与仍有效 S09 原通知证据支撑；W06 由 S06/S10 支撑；W07 由 S11、九行 Spec 映射与三个前置 gates 支撑。这里只投影 Router 已定判断，不由 Writer release。

三份指定原 Result 均完整读取/解码并核 task/g1：S14 单个真实 optional 错误先红1 fail后绿1 pass、绑定可见 console logger且精确通知/Strip保持；S10 完整 JDK graph/真实关闭顺序和六类故障、loader close/retry，10个不同方法通过后最终两个受影响方法补验，首轮 fixture classpath 漏项失败/修正保留；S11 只增强 caller测试，两轮5＋2含1重叠＝6个不同方法，实际公开接线/全部内容/逐类输入/真实失败/无 producer memory缓存恢复和九行映射成立。详细方法、复用而非重跑和限制由 [Context 最终记录](context.md#已采用的最终完成记录) 承载，不把统计或当前 XML 当永久原始证据。

本次局部静态自检：以内存编辑前基线核对，Waves 冻结历史全段、全部结构化 predicate/scope/owner/evidence/成员/前置/gate 要求、Plan 九行成功表及 Context R01/I02/I03 历史记录逐字保持；仅状态/已采用事实和时点说明变化。解析状态为12个新版活跃 completed items、4个新版 satisfied gates，S01/S09 partial 与旧状态不变。102处本地链接逐个读取、31个 fragments/40个不同项目内目标检查通过；Plan/Work/Waves 匹配互链及 portable 引用检查通过，无外部 Result/会话/home/绝对或逃逸依赖。三处旧 XML 链接改为非链接快照事实，未把可覆盖产物作持续原证据。四文件 no-index whitespace 检查均通过。本次检查不等于新测试或独立 review/gate release。

适用 Windows/Gradle9.4.0/JDK17；SecurityManager 注入限制、selector 窗口宿主干扰、非原子双移动、TestKit homes 留存、deprecation、S11 两次 LSP inconclusive 仍保留。不承诺整仓/游戏/其它 OS/外部 caller/完整支持矩阵或 Git 提交。下文“实际完成记录”与各作者自检保留原准备/恢复维护时点，含待 review、pending、no-op 仍可能吞日志等旧语气，不是当前缺口或本次重跑。

## 实际完成记录（信息性）

R01 的 27 与 I02 的 28 聚焦测试分别按分轮记录，不合计为独立 55；Router 已判断旧 W01 satisfied。I03 `codev-mkf-isolated-producer/g1` Result partial 的已做/未做、A/B/C 实际运行版本和命令/环境/警告见 [Context](context.md#已采用的-i03-partial)。本次不重新运行、不据静态类名或通过数重判完成；旧 I03 原谓词/七组验收及 W02/W03 requirements 仍在冻结 Waves。原协调记录维护的工具失败 blocked 与后来恢复、原 ADR writer blocked 与恢复 completed 分开保留，不新造实施项。

以下为前次 S01 恢复维护的已采用证据/读取快照，不是本次完整读取 S01/S04 或当前 gate 判断。S01 partial、S02/S03/S04/S12 completed 的后来已采用效果与实际验证见 [Context](context.md#已采用的新版实施与-s01-恢复边界)。本次完整读取解码 S01/S04 原 Result，区分外层终止与内层 partial/completed；只维护 adopted facts，不重新判定兄弟完成。当前正常 XML 已可被后续同 task 覆盖，历史通过不重置、也不把当前文件叫作原轮完整证据。Manifest/TOML 原地写失败可能留下部分内容；S04 返回资源缓存在内存，Windows/JDK17 释放观察不扩展为其它 OS 保证。S01 原要求和已做迁移保留，S13 pending；恢复实施/验收与 gates 均未完成。

## S09 诊断恢复维护作者自检

以下为前次 S09 恢复图维护时点的完整自检，保留其 pending/未 review/未放行与 no-op 风险语气及数字；当前 S14/S10/S11 completed、W04–W07 satisfied 见最终完成记录，以下不代表本次执行。

本 Handoff shape 合法，objective/constraints/deliverables 合起来只有“同目录四文档匹配恢复维护可供受影响独立审查”一个终态；同步兄弟完成事实、维护图与静态检查仅服务它，不包含修复/实施/独立 review/调度。已正常读取 primary 与三个 companion Skills，并遵循已激活 Ponytail；全部六个 refs 完整读取（两个 transport envelopes 内层完整解码），inline 权限/采用事实按给定范围使用。读取现行双语 Spec/英文 PRD/同 identity ADR 的相关条款，复用三族已采用 reuse assessment；未发现须扩 owner、改 authority 或重选日志方案的缺口。

- 起草前先按 Waves 方法检验完整 effects：S09 的通知、原键与 entry-file/Strip 成果在日志失败后仍可保留/消费，剩余可读诊断有独立恢复/Result 边界。S14 工厂修正和单个真实 optional 错误的可见性＋正常通知/Strip 回归只有一个终态，不混入 S10 生命周期、S11 caller/cache 或独立审计。
- S09 全原 predicate/scope/evidence 保留，原 parent/同类异 config/未通知、真实 exception、entry-file/Strip 等逐项映射 S14 五条证据；复用按当前源码/输入/配置/环境/覆盖/新鲜度，不机械重跑已证 unknown/dynamic，不用诊断 completed、logged 方法名或固定 ERROR 删验收。生产只工厂、测试只已有单项的未来边界明确，本次零实现。
- 九行成功条件逐一核对原 Spec/PRD AC2/3/4/5/9/11：仅 Engine outcomes and logs 明确原本已有的实际可读要求与 S09→S14 映射，Applied outputs 连接同场不否决通知，其余七行逐字保持。Inputs/Core/S13 及 W04 后来采用事实不减原要求；S10/S11 原块和 W06/W07 gate 不动。W05 仍需全部原通知/日志/引擎/资源/映射/service 证据和五个独立 completed Results，不能等待旧 partial 变 completed，也未判满足。
- 真依赖为 S14 消费 S05/S06/S08 的现行原生处理、文件和 child service/cache Results；S09 partial/诊断只作已读事实输入，不造不可满足的 completed 前置。S14 与 S09/S10/S11 的测试/fixture、Gradle 输出/daemon/cache、短作用域 System.err 副作用须串行且 finally 恢复；共享只读 authority 不冲突。S10 仅等 S04/S06/S08，S14 不等自己 W05 或 W06 gate；S11 仍等 W04/W05/W06。冲突方向不是下一动作或并行许可。

实际静态检查：从正文解析 **26 个唯一 item/gate ID**，全部引用解析；新版 **12 个活跃 items（9 completed＋S10/S11/S14 三个 pending）** 各恰好属于一个非空 Wave，S01/S09 partial 均非活跃成员。W04 satisfied 仅投影 Router 采用事实，W05/W06/W07 pending 未改判。合并显式 item 前置、containing-Wave 前置 gates、gate 等全部成员后的 **16 节点新版图、26 节点含历史图、再加入已声明冲突方向的图均无环**；新版可行层为 `{S02,S03,S12,S04,S05,S07,S08,S06} → {S13,S14,S10} → {W04,W05,W06} → S11 → W07`，不表示同层允许并行或实际调度。S10 三个前置逐字核对未变，S14 不等待历史 S09 completed 或自己 gate。

内存维护前基线对照：S01/S09 全原谓词/scope/owner/evidence、S10/S11 完整块、W06/W07 完整块、Waves 冻结历史全段及 Context I03 原 partial 记录逐字保持；九行成功表只有上述两行连接/可读要求维护，其余七行逐字保持，六个 PRD AC 集不变。S05–S08/S13 只补 adopted 状态/事实，原完成要求保留；W05 原验收文本保留并显式加强 S09 全要求的证据连接，不删除要求换通过。

逐一打开/读取验证 **97 处本地链接、27 个 fragments、42 个不同项目内目标** 通过，Plan→本 Work/唯一 Waves 与反链一致；本目录仍仅原四文件，没有绝对/会话/外部 Result/逃逸引用或 Context 中转。5 处已退役 codec/旧 remapper/已被后轮覆盖 XML 的失效链接改为注明时点的非链接事实及现行可读 owner，未删除历史采用结果、不新造原始证据。四文件 `git -c core.autocrlf=false diff --no-index --check -- NUL <file>` 均无 whitespace 输出（exit 1 为正常 no-index 差异）；所有实际文本变更仅用注册 edit 写原四文件。上述是作者静态自检，不是项目执行、独立 review 或运行/日志验收。

本次不执行 Gradle/项目/探针/LSP/安装，不改 authority、代码/测试/配置/依赖/工具链或其它 Work，不 Git 写入/Todo/提问/派发；未自行独立 review、判未满足 gate 或选择后续。当前原生诊断仍可能被 no-op 吞掉；此恢复图可审查不证明修复已实施或日志已可读。

## S01 恢复维护作者自检

以下完整保留前次 S01 恢复维护的作者检查与未 review/待执行语气，仅描述其当时范围和结果。后来局部独立 review 已通过、S13 completed、Router W04 satisfied 由当前状态限定；不是本次检查数字/执行或重复全范围审查请求。

本 Handoff 的 objective/constraints/deliverables 合起来只有“同目录 S01 剩余契约验收恢复匹配文档可供独立审查”一个终态；同步兄弟已采用事实和静态核对仅支持这一结果，不另做资源修复、恢复验收或审计。已加载五个指定 Skills，完整读取全部指定 refs 并解码 S01/S04 Result，复用可见 PRD/双语 Spec/ADR reuse assessment，核读受影响 authority 条款、现行接口/adapter/直接 fixture 与四个普通 XML；只用注册 edit 修改原四文件。

- S13 有独立重试/Result 边界：原 S01 的继承、注释、SPI/list 及六个通过即使恢复失败也保留；恢复的核对/必要补验共同建立同一剩余契约，不混入 S04 资源修复或平台编辑结果。S01 原 predicate/scope/owner/evidence 保留，旧原图全段与 W05/W06/W07 gate、S05–S11 要求不变；S02/S03/S04/S12 仅投影 Router 采用事实。
- 原 S01 evidence 每个要求均在 S13 五条映射：真实 SPI/Core 消费，关闭 ZIP 快照/list/重复 side 与显式编辑，两个原失败 producer/只读/cleanup，Core 两注释/签名/Jar-in-Jar 最小保留及引用/编译，实际结果/环境/版本限制。六过与 S04 后续通过只按现行适用性复用；源码/XML存在不是重跑或自动充分验收，不机械重跑八个、不删除原成功条件。
- 9 行 Spec/六个 PRD AC 的原成功条件保留，Inputs 映射明确 S01 原要求经 S13 恢复；Isolation 与 Failure safety 的资源修正只作已完成输入，S10/S11 等未完成边界不改。W04 仍需 S13/S02/S03/S12 独立 completed＋全部原 Core/当前 metadata/双发现证据，W05/W06/W07 原行为 gates 逐字保持；未判满足。
- 实际静态检查从现行正文解析 25 个唯一定义；12 个活跃 items（4 adopted completed＋8 pending）及 4 个新版 pending gates，S01 partial 非活跃成员。item 前置＋containing-Wave gates＋gate 等全部 members 的 16 节点新版图、包含历史的 25 节点图及加入声明冲突串行方向后均无环；可行层为 `{S02,S03,S12,S04,S05,S06,S07,S08} → {S13,S09,S10} → {W04,W05,W06} → S11 → W07`，不表示同层许可并行。S13 的四个真实 item 前置和 containing-Wave 空 gate 前置共同判断；S13 不等 W05 gate或历史 partial S01。保守冲突路线在 S04 后/S05 前插入 S13，只控制共享写/运行，不造全局业务屏障。
- 内存基线对照：S01 全原 predicate/scope/owner/evidence、整个历史原图、W05/W06/W07 与 S05–S11 块逐字保持，S02/S03/S04/S12 除 state/新增 adopted facts 外要求不变；Context R01/I02/I03 完成记录逐字保留。9 行成功条件仅 Inputs 的 S01→S13 恢复映射变化，六个 PRD AC 保留。逐一读取 93 处本地引用、25 个 fragments、42 个不同项目内目标均通过，无绝对/会话/外部 Result/逃逸引用；Plan→同 Work/唯一 Waves 与反链正确，本目录仍仅四文件。四文件 no-index whitespace 检查通过。初版静态表行筛选误计表头/其它行，限定成功表并排除表头后通过；这不是项目测试失败。

未发现需要更改原成功标准、架构或实现许可的未决选择；恢复充分性仍须实际 S13 Result 支撑，当前作者与后续独立审查均不宣告恢复完成或释放 gate。受影响审查边界如上，未变确认范围不重复用户审批。本次未运行 Gradle/项目测试/构建/实验/LSP、安装/reload，未改生产/测试/authority/其它 Work，未 Git 写入/Todo/调度。

## 本轮八点维护作者自检

以下是八点初次计划维护的历史自检（含“本轮”、全 pending、未 review/待确认、旧 24 节点/80 引用数字），不是本次恢复检查；后来的 review/确认与 S01–S04/S12 事实由本 Plan 状态及 Context 新节限定。其原本审查边界已由 adopted 八点 review 覆盖，不作为当前重复全范围审查请求。

本轮 Handoff 的 objective＋constraints＋deliverables 只有“同目录匹配计划维护可供受影响独立审查”一个终态。已读取全部九个精确 refs（含完整解码 I03 Result），加载五个指定 Skills，使用 inline assessment/授权，定点读取当前 grouping/ownership 源码及只读 Git 状态；无全仓/D/E 重审、authority/实现写入或项目执行。

1. 对照英文/中文 Spec 当前九行验收、PRD R2/3/4/5/6/8/10 和六个 AC、最新同 identity ADR，八点及正常 fallback/真实失败均在上表/Waves 找到 owner/观察。旧禁 Core 继承/禁写任何属性/双格式 equality/额外预验只留历史，未做新前置。
2. 新图十二个独立终态逐项检验：Core 引用契约、Fabric 当前编辑、NeoForge 独立 TOML、Forge 当前 Manifest、资源就近、原生 engine 处理、文件 codec 就近、Tiny 保能力改名、短窗口 services、unknown 通知、producer 完成生命周期、caller 当前链。必要 helpers/callers/聚焦回归随同谓词；S03 的旧 Forge TOML 分派迁移必需，但 S12 可独立失败/保留，不合为平台混合 Result。S09 与 S10 分别可消费/重试，不因 I03 同来源合并。S11 多状态同链验证不另立缓存功能/审计。
3. 新版各 item 的 evidence 覆盖真实业务/失败，不以编译/标识删除替代；R01/I02/I03 原状态/谓词、分轮验证/局限与旧 gates 保留，I03 仅补可靠 partial。恢复不重放已完成独立效果，也不自动满足旧或新 gate。
4. 联合 item＋Wave 等待、所有权冲突方向、可判定 gates 与本地互链的实际静态检查结果如下；这些只证明派生计划，不是独立 review、实施确认、模型运行或项目验收。

实际作者检查结果：

- 从 Waves 当前正文解析 **12 新活跃 items＋4 新 gates，全部 pending**；24 个总定义 ID 唯一（另 5 个历史 items＋3 个历史 gates），引用全部解析、每个活跃 item 恰好属于一个非空 Wave，objective/owner/evidence/单结果说明齐全。旧 I01 blocked、R01/I02 completed、I03 partial、I04 pending、W01 satisfied、W02/W03 pending 逐项核对。
- **16 节点新版联合 wait DAG 无环**：`{S01,S02,S03,S04,S05,S06,S07,S08,S12} → {S09,S10,W04} → {W05,W06} → S11 → W07`；此为可行拓扑层，不要求同层并行或全部上一层完成。显式 item waits 仅 S09 等 S05、S10 等 S04/S06/S08；成员还等 containing-Wave 的前置 gates，每 gate 等全部 members 及其前置 gates。加入历史的 **24 节点**联合模型、再加入 Waves 声明的保守冲突串行方向均无环；无隐藏历史 partial 前置/自等 gate，不靠编号造依赖。
- 作者逐条检查真实 owner/caller 输入及冲突：S01 与各 adapter 的 list/fixture、S03 与 S12 的 Forge extraction/编辑、resource/child/codec/loader/notification/lifecycle 的共享写面与测试副作用已显式串行；S02/S03/S12 不互以成功为业务前置。W04 四份、W05 五份、W06 两份、W07 一份独立 Results 加各自行为/失败证据才可判 gate，当前均未判满足。
- 逐行语义检查 **9/9 Spec 成功条件、6 个当前 PRD AC**；脚本核对表行/AC 集及新 item/gate 映射均解析。八点全部有 owner/终态/必要聚焦回归，原输入/隔离/通知/mapping/I/O/关闭与失败消费保护保留；删预验不复活正常 fallback 拒绝，也不吞真实异常。证据要求仍有待实际实现 Handler 提供，作者检查不称其已运行。
- 内存原文对照通过：Waves 原图从旧语义段到末尾，除历史标题/对应导航及 I03 pending→partial 外逐字保留；**全部旧 item 谓词/验证/owner/前置、membership、三个原 gate 块未改**。Plan 原两次作者自检正文保留，仅明确历史标题/时点；Context R01/I02 实际完成效果、27/28 分轮运行/修正/局限和 Router W01 判断段逐字保留。I03 完整原 Result 解码/关联后处理为便携事实，不新增本机定位/全报告包。
- **80 处本地引用可读，19 个 fragments 解析通过，35 个不同目标均在项目内**；Plan→同 Work/唯一 waves.md、Waves→同 Plan/Work 相互对应。首轮发现一处旧“作者自检记录”锚点因历史标题失效，修为历史标题后复检通过；未改变旧谓词。外部 Result/会话/绝对本机定位与逃逸引用检查通过，不经 Context 中转。
- 对四文件执行 `git -c core.autocrlf=false diff --no-index --check -- NUL <file>`，均无 whitespace 输出/错误（接受 no-index 的正常差异状态）。现有混合 Git 变更保留；全部文本修改只由已注册 edit 写这四文件。没有 Gradle、编译、项目 tests、LSP、探针/实验、安装/reload、Git 写入、Todo、提问、派发或独立 review。

本轮准备未发现需要擅定的产品/架构决策或写入权限缺口；实施所需的受影响独立 review 与 Router 披露/确认尚未发生。以上检查不证明新版实施、运行验收、完整原始证据永久可读或 gate 释放。

## 历史作者自检记录

以下初始准备及局部恢复维护检查完整保留其当时字节/范围（含“本次实际”、全 pending、未 review 与未释放数字），不是本轮八点维护检查，不覆盖上方后来采用的 I03 partial 或新版图；原链接数字与拓扑仅属旧图。

### 初始准备记录（保留当时范围和结果）

以下计数、全 pending 与尚未实测说明均为初始准备时点，不描述 I01 阻断和本次新图；初次 review/用户确认及政策改变见本 Plan 状态和 Context。

1. 已读取全部六份精确引用输入并采用 inline 授权/事实；三族均 reuse。Spec 9 行当前验收条件逐行映射到上表及 Waves；PRD 六个当前 AC2/3/4/5/9/11 和 R2/3/4/5/6/8/10 都有实现/实测 owner。旧 A/C 编号不替代新条件。
2. Handoff objective＋constraints＋deliverables 整体仅一个准备终止谓词，四文件和作者检查只服务其匹配可审查性；未混入独立审查或实施。未来四项的单谓词理由、可独立重试/消费边界及拒绝合并理由见 Waves，不以文件计数划分。
3. 每项证据对应真实合同而非类名/编译成功：配置 snapshot/显式编辑、独立 DOM Strip、隔离 producer 与真实 caller/cache 分别有正/负/保留内容/失败消费观察。I03 改动先前已测组件必须补其受影响回归；I04 复用未变组件，不制造第二完整终验。
4. 联合等待、ID/membership、实际依赖/冲突、gate 可判定性及四文档本地互链的脚本检查结果在本节末尾记录；这些静态检查只证计划结构。

实际静态检查结果：

- 四文件齐全，Plan 精确链接本 Work 和唯一 `waves.md`，Waves 反链同一 Plan/Work；**55 处本地链接逐个读取通过，9 个 fragment 全部解析通过**，所有目标位于项目内。没有外部 Result/会话/绝对用户路径、逃逸链接或 Context 中转依赖。
- 脚本从 Waves 实际字段提取 **4 个 item、3 个 gate**：ID 唯一、引用均解析、每项恰好属于一个非空 Wave，7 个执行状态全部 pending；每项均有 objective/scope/owner/evidence/单谓词说明。
- 合并 item 前置、containing-Wave 的 prerequisite gates 及每 gate 等全部 members 后，**7 节点联合 wait 图无环**；拓扑为 `{MKF-I01,MKF-I02} → MKF-W01 → MKF-I03 → MKF-W02 → MKF-I04 → MKF-W03`。另加入 I01 在 I02 前的冲突串行边，仍无环。作者逐项核对真实输入/最后调用清退依赖、共享文件/fixture/运行冲突及每 gate 的可判定证据，不以编号制造前置。
- **9 行 Spec 成功条件均有 item/gate 映射，6 个当前 PRD AC 均覆盖**；脚本只验证映射引用与数量，语义覆盖/证据足够性由作者按每行要求核对。范围不丢通知、多目标/跨来源、target-owned definitions、独立 Strip、consumer failure 与无内存缓存恢复等条件。
- 对四个新文件分别运行 `git -c core.autocrlf=false diff --no-index --check -- NUL <file>`：无 whitespace 输出；新文件有差异时退出码 1 是 no-index 的差异状态。首次包装脚本误期望 0 而中止于 diff 部分，随后按实际差异状态校正检查，不能把该包装断言当项目失败或构建结果。聚焦 NUL→四文件差异和仅本目录新增状态核对，无权威/历史/源码写入。
- 没有运行 Gradle、编译、测试、LSP、游戏、依赖解析、安装/reload 或独立 review；没有 Git 写入/Todo/派发。既有 81/20 和三项文档对齐的检查只以可靠提供的原范围保留，不冒充本次实测。当前未发现准备阻断；运行库 JSON 边缘行为、隔离/失败/缓存真实效果仍是未来必需验证，不是作者自检已通过的运行事实。

### 此次局部恢复维护记录

以下为本次实际作者检查；初次 review 通过与用户确认、I01 blocked、库探针/Spec 对齐结果来自 Router 已可靠采用的事实，不是本次重跑。

1. 完整读取选定四文件、原双语 Spec、英文 PRD 和同 identity ADR；复用 PRD reuse、Spec update 已完成后复用、ADR reuse 的可见 assessment。Handoff 的 objective/constraints/deliverables 合起来只有“同目录匹配恢复协调文档可供受影响边界独立审查”一个终态；未混入实现或自行独立审查。
2. 分组仍是四种独立结果：配置契约 R01、独立 Strip I02、隔离 producer I03、真实 caller 当前结果 I04；每项一 Handler/一 Result。R01 的接口、双平台 adapter、host/SPI/fixture 迁移和四组回归共同证明一个可消费契约；旧 I01 无已完成实现可回放，不新增第二配置效果或独立审计结果。R01 与 I02 虽共享写面仍是独立结果，冲突串行不伪装成成功依赖。
3. 从实际 Waves 字段提取 **4 活跃 items＋3 gates，全 pending**；另有 **1 个历史 I01 blocked**。共 8 个定义 ID 唯一，活跃引用全部解析、每个活跃 item 恰好属于一个非空 Wave，旧 I01 无活跃 membership/前置入边；保留其原 W01 关联与空前置。W01 活跃成员为 R01/I02；I03 真正依赖 R01/I02，I04 依赖 R01/I02/I03，W02→W01、W03→W02 的 gate 关系未变。
4. 脚本联合 item 前置、containing-Wave prerequisite gates、gate 等全部 members：**7 活跃节点无环**，拓扑 `{R01,I02}→W01→I03→W02→I04→W03`；加入历史 I01 孤立记录的 **8 节点检查仍无环**。增加冲突串行边后为 `R01→I02→W01→I03→W02→I04→W03`，无自等 gate。人工核对共享 host/fixture/测试输出的 R01–I02、host/SPI 的 R01–I03、DOM/publication 的 I02–I03 及 I04 对全部组件的冲突；待前项终结、交还所有权并读取当前效果后才能触及冲突面，只有 required completed＋足够证据才满足实际前置/gate。
5. 逐行比对 **9/9 Spec 当前成功条件、6 个 PRD AC（2/3/4/5/9/11）** 的映射，脚本确认名称/数量/显式 ID 可解析，作者核对语义与证据足够性。Inputs 的 DOM 双语法政策覆盖 R01 metadata、I02 config/entry-file、I03 child config/parent/refmap 及 host/entry 交接、I04 必要组合/输入复用，均含未知字段字符串；不再有活跃 raw-control 一律拒绝断言。严格 UTF-8、其它 malformed、shape/类型/resource/side/原串、归档路径及其余保护未删；不承诺 engine 采用同一 DOM 或接受所有库可解析输入。
6. 内存维护前后逐字对照通过：旧 I01 objective/scope/owner/四组原检查及单谓词解释完整保留；R01 同谓词/owner/检查 1、3、4 保留，scope/检查 2 仅对齐 JSON 政策及必要保留验证。I02 未受影响检查 1/2/4/5、I03 检查 1–6、I04 检查 1/2/3/5/6 与三项原谓词不变；Plan 其它 8 行成功条件、W02/W03 完整 gate 块逐字未动。W01 仍需两个独立 completed Results、全部必要正/负/保留/失败及接线证据，W02 仍需真实 engine/通知/关闭与退出，W03 仍需真实消费/失败/当前输入与无内存复用；gate 均可依其必要观察判定，未删条件制造就绪，也未实际判断释放。
7. 四文件共 **61 处本地引用可读、14 个 fragments 解析通过**（Markdown 标题及 HTML 元素 id）；Plan 精确链接本 Work 和唯一 Waves，Waves 反链同一 Plan/Work，本目录仍仅原四文件。没有项目外 Result/会话/绝对本机定位、逃逸或 Context 中转依赖。四文件 `git -c core.autocrlf=false diff --no-index --check -- NUL <file>` 均无 whitespace 输出（有差异的 no-index exit 1 正常）。这些只验证派生文档，不是项目测试。
8. **受影响边界独立 review 尚未进行**：准确边界为 R01 全谓词/四组证据与旧 I01 历史，W01 membership/gate、R01–I02/R01–I03 冲突、I03/I04 item 前置、R01/I02/I03 JSON 检查和 I04 组合连接；必要关联包括 W02/W03 传递 gates、Plan Inputs/DOM 风险/成功条件和 Work/Context 状态/授权/证据限制。原审查只支持原字节，当前维护与自检不宣布新图就绪、实现通过或 gate 释放。

本次仅写现有四文件；未运行 Gradle、编译、项目测试、依赖解析/探针、安装、独立 review，未改 authority/代码/测试/工具链，未 Git 写入、操作 Todo 或调度。维护本身未发现未决权限/政策或结构阻断；恢复与后续实现、验收和 gates 均未完成，库探针不是其证据。
