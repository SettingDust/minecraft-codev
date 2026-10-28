# Mixin Kotlin-first 重设计 Waves

[Work](work.md) · [processed Context](context.md) · **唯一匹配 [Plan](plan.md)**

本文件是唯一执行图；新版活跃集合与冻结原图分开。**当前新版活跃 S02/S03/S04/S05/S06/S07/S08/S10/S11/S12/S13/S14 全部 completed；S01/S09 保留 partial。Router 已完整采用关联业务 Results，并独立判断 W04/W05/W06/W07 satisfied；已确认八点范围无剩余实际执行项。旧 I01 blocked、I03 partial、R01/I02 completed、W01 satisfied、W02 未释放、I04 未执行、W03 pending 均不变。** 本次 C5 仅持久记录 Router 已核定终态，零实现改动、零项目执行，不改图义或自行 release。八点范围已确认，旧准备/待 review/pending 语气只属其时点。实际分轮方法、失败修正、复用与限制见 [最终完成记录](context.md#已采用的最终完成记录)。

## 新版图语义与共同约束

每项一个 Handler / 一个 Result / 一个可验证终态。当前 authority 为 [Spec](../../spec/mixin-preapplication.md)、[PRD](../../prd/codev-mixin-rework.md)及[同 identity ADR](../../adr/mixin-operation-isolation.md)；[Plan](plan.md)负责范围/策略，图不成为第二合同。八点实施范围已确认；S09→S14 恢复图准备时的独立审查要求属于当时前置，当前只投影 Router 已完整采用的恢复结果及 gate 判断，不重开实施或改要求。未变范围不重复审批。共享只读 authority 不构成冲突。

共同保留：raw 输入/安全路径与 physical identity、真实歧义、严格 UTF-8、业务形状/值、真实 engine/I/O/close/取消/cause、TCCL/资源释放、原输入保护、通知即资格/all-match、有效空不等缺失/损坏/stale。重复对象键与字符串 raw-control（含未知字段）沿实际 serialization DOM，不额外扫描/固定 last-value。正常引擎 side/plugin/required/optional/plugin-refmap/default-mapper 返回不由 Codev 追加失败；必需 mapping/显式 context 和实际数据读取失败照常传播。不恢复已撤销的预验/转换后巡检、来源同 JAR 要求或完整应用 proof。

只写各项 owner 与必要直接 callers/fixtures/聚焦回归；不写 authority、其它 Work/HTML、无关 Core/Includes/Forge patch、版本/lock/工具链或外部 caller。Core 仅 S01 的函数注释可改，签名/原 Jar-in-Jar 调用不变。必要测试接点不能变成通用故障/锁/lease/发布框架。未变效果复用，变更处补验；旧组件历史不重放。

## 新版 Waves 与可判定 gates

### MKF-W04 — Core 复用及当前 metadata 契约

- state: satisfied
- 已采用判断：Router 完整采用 S13/g1 completed（零源码修改，补跑两个受影响接点均过），结合 S02/S03/S12 Results 判本 gate satisfied；不是本次 Writer 重新放行。S01 partial 与原失败历史不变。
- itemIds: [MKF-S13, MKF-S02, MKF-S03, MKF-S12]
- prerequisiteWaveGates: []
- gate：S13/S02/S03/S12 四个独立 Results completed 且各自全部证据充分；S13 必须以 S01 全部原要求为基线，结合其已完成迁移/仍有效证据和必要补验覆盖剩余契约，不以旧 partial 代替 completed，也不等待 S01 改为 completed。Core 签名/Jar-in-Jar 行为保持、Mixin resource/side snapshot/list 可消费，Fabric 与 Manifest/TOML 的当前 metadata 编辑保留新增及未知内容，两格式并存均可发现且互不编辑。原 W04 全部行为/验收标准保留；S04 completed 或两平台后续通过均不自动满足 S13/W04，Router 须完整读取关联恢复 Result 并独立判 gate。旧 W01 的“无 Core inheritance/双 metadata equality”只属旧范围，不可作为新 gate 条件。
- 显式依赖方：MKF-W07 的 caller；不阻挡不消费这些变更的 runtime items。

### MKF-W05 — 当前引擎职责、加载与通知契约

- state: satisfied
- 已采用判断：Router 已关联 S04/S05/S07/S08/S14 五份 completed Results，结合仍有效 S09 原通知/异常/文件证据与 S14 真实 optional 错误日志同场资格回归，判断本 gate satisfied；S09 partial 不变。 不是本次 Writer 自行放行；原 gate 要求如下保留。
- itemIds: [MKF-S04, MKF-S05, MKF-S07, MKF-S08, MKF-S14]
- prerequisiteWaveGates: []
- gate：五个独立 Results completed，资源层确已退出且真实读取/保护保留；无重复预验/后验，原生正常 fallback 与真实异常分开；Tiny 改名不收窄 MappingReader；native selectors/child global-property 的初始化、恢复、短互斥和跟踪实测；unknown/dynamic 通知不造键、不撤销已知键。必须有各项内容/行为和负例，不以删除标识/编译/计数代替。 活跃第五份为 S14，不再等待历史 partial S09 改 completed；S09 原全部 predicate/scope/evidence 仍是基线：真实 unknown/dynamic、已知保留、候选不造键、嵌套/parent/同类异 config、多目标、真实异常及 entry-file/Strip 内容都须由仍有效的 S09 证据与 S14 日志关联回归共同覆盖，原要求一条不删。普通原生诊断必须真正可读，不能以方法名含 logged、无异常或固定 ERROR 替代；日志不得裁判生产/通知。S14 completed 也不自动完成 S09 或释放 W05，仍须 Router 关联五份 completed Results、S09 partial 的可复用证据并逐项判定本 gate。
- 显式依赖方：MKF-W07；S10 只等下列具体 items，不等本 gate 全局屏障。

### MKF-W06 — 本地文件交接及 producer 完成生命周期

- state: satisfied
- 已采用判断：Router 已采用 S06/S10 completed，完整 JDK graph、直接关闭/完成顺序及真实流/close/取消/move 失败和 retry 证据满足本 gate。 不是本次 Writer 自行放行；原 gate 要求如下保留。
- itemIds: [MKF-S06, MKF-S10]
- prerequisiteWaveGates: []
- gate：两份 Results completed；文件编码未变、无独立 AppliedMixins 层，Task 直接写/Strip 本地读；S10 在其真实前置的新版代码上观察完整 JDK graph 与 archive→return→loader close→entry close→pair 完成，并触达 target/entry 中途 write、entry close、输入 ZIP close 等真实失败，旧输出不可消费、retry/输入保护成立。I02 的 Strip close 和 I03 的 open-write 拒绝不能填这些缺口。
- 显式依赖方：MKF-W07；不声称完整 caller/cache 已完成。

### MKF-W07 — 显式 caller 的当前完成消费与复用

- state: satisfied
- 已采用判断：Router 已采用 S11 completed，九行 Spec 映射、真实 caller/输入变化/失败/无 producer memory 复用及 W04/W05/W06 满足，判断本 gate satisfied。 不是本次 Writer 自行放行；原 gate 要求如下保留。
- itemIds: [MKF-S11]
- prerequisiteWaveGates: [MKF-W04, MKF-W05, MKF-W06]
- gate：S11 completed，真实同链内容/行为、全部所需 Transform 消费、两 strip 与 producer 失败、输入变化及无 producer memory 的 UP-TO-DATE/FROM-CACHE 均有有效观察；九行 Spec 验收在组件复用＋受影响补验中覆盖，未知/未测如实列明，不借缓存标签/文件存在判成功。此 gate 与 W04/W05/W06 建立 Plan；无独立重复终验项。

## 新版活跃 Items

以下谓词/验收保留为要求；实际状态仅投影 Router 已采用 Results，后来事实与版本限制见 [Context](context.md#已采用的-s09-partial-及诊断恢复边界)。S01/S09 原项均保留 partial 和全部原要求，分别移出 W04/W05 活跃成员，由 S13/S14 承接剩余验收；S13 已完成，不重放原迁移或 S09 已完成通知效果。历史 I03 的未完成证据按新 authority 分到 S09/S10，八点差异另由 S01–S08/S12 承接；旧 I04 的未执行 caller 效果仅由 S11 承接，不回放 R01/I02 或 I03 已落地的独立效果。

### MKF-S01 — 可复用 Core 的 Mixin 引用契约

- state: partial
- 原 wave: MKF-W04；现非活跃成员，恢复成员为 MKF-S13，原项不作为必须 completed 的等待前置。
- prerequisiteItemIds: []
- 已采用事实：`codev-mkf-core-contract/g1` 为 partial，继承、两行 Core 注释、平台 list 与 Java SPI/fixture 迁移已落地；原两轮 8 个不同选择器 6 过、Fabric/Forge 两个 producer 因 Windows TempDirectory cleanup 失败（Fabric 重试仍失败），不能改为 completed。后续诊断仅对 Fabric 证实 loader/引擎资源未关闭；S04 修正后两个原 producer 最终通过是后续版本事实，不倒改原失败或追认 Forge 同因。全部原 predicate/scope/owner/evidence 如下保留。
- 唯一 completion predicate：Mixin listing/handler 通过 Core 原签名可被消费，同时 resource/side snapshot、显式编辑与原 Jar-in-Jar consumer 行为保持。
- scope/effects：`MixinListingRule : FileListingRules` 协变 load、`MixinConfigHandler : ListedFileHandler`，list 返回 references 的 resource；无独立 environments 接口。只修 Core `ListedFileHandler` 两函数注释为资源引用/引用声明，不改签名或承诺所有 handler 删除实体。
- write owner：上述 Mixins 两接口；Core `ListedFileHandler.kt` 的注释；Fabric/Forge 现有 handlers 必要 list 实现及直接 SPI/fixture/生成源码和相关测试。不给 Core/Includes 功能或无关调用者新职责。
- 必需 evidence：真实 SPI load→Core typed list 与 resource/side snapshot 在 ZIP 关闭后可用；Mixin remove/removeConfigs 仍显式可调用、producer 只读；原 Jar-in-Jar 触及调用编译/最小保留回归，Core diff 仅注释、签名/调用未改。引用检查包含生成源码/fixture，而非仅两个接口编译。
- 单结果检验：注释和必要 adapter/caller 迁移只建立一个 Core 可消费的 Mixin 引用契约；metadata 编辑政策不随此项重写，独立交 S02/S03。

### MKF-S13 — S01 剩余 Core 可消费契约验收恢复

- state: completed
- 已采用事实：Router 采用 S13/g1 completed；零源码修改、补跑两个受影响接点均通过，结合 S02/S03/S12 判 W04 satisfied。以下 scope/evidence 保留为原要求，不要求重新执行；Handoff 未提供这两处的 selector/计数/完整命令，不从后轮 XML 推造原轮细节。
- wave: MKF-W04
- prerequisiteItemIds: [MKF-S02, MKF-S03, MKF-S04, MKF-S12]
- 唯一 completion predicate：在现行 adapters/fixtures 与 S04 资源修正上，S01 原 Core 可消费契约全部要求由仍有效的已采用证据和必要补验共同充分满足；恢复 Result 明确已做与剩余覆盖，不重放迁移或宣告原 S01 completed。
- scope/effects：仅恢复原验收未完成边界。以 S01 原 8 选择器的 6 过/2 cleanup fail 为起点，逐项核对源码、输入、配置、环境、覆盖/新鲜度；采用 S02/S03/S12 当前格式分立和编辑事实，S04 的底层流释放及两个原 producer 后续完整通过作为候选复用。S03 改变 Forge combined adapter/fixture、S12 改当前 Manifest 编辑、S04 改资源/直接测试，不能仅按旧方法同名或通过数认定仍有效；无需机械重跑八个或重新实现接口。
- write owner：必要的 Mixins Java SPI/preapplication、Fabric metadata/applicability、Forge metadata/retained-baseline 的直接契约 tests/fixtures；可无文件修改而用充分有效证据验收。不得重改生产/Core 注释、增加新平台、修 engine/资源/metadata 政策、实施 S05–S11 或重做独立审计；若实证发现需要生产修正/原成功标准变化，返回具体缺口及已做范围，由 Router 判断，不吞入恢复。
- 必需 evidence / 原要求映射：
  1. 原 SPI→Core typed load/list：关联 S01 的 Java fixture/真实 producer、Fabric 和 Forge SPI 既有通过，核对现行独立 Forge/NeoForge rules（不增加平台）仍满足原签名消费；当前 `closedZipHandlersPersistSelectiveAndFullRemovalForBothMetadataFormats` 和 `actualSpiSnapshotsKeepDuplicateReferencesAndExistingForgeSidePolicy` 已改为独立 handlers，结合 S03/S12 的实际通过评估复用，缺口才补最小检查。
  2. 原关闭 ZIP 后 resource/side snapshot、重复顺序/list 与 remove/removeConfigs 可用：复用仍适用 S01 的 Fabric/原 Forge 观察，并连接 S02/S03/S12 当前入口/未知及新增保留；显式编辑仍可从 Core remove 与 Mixin removeConfigs 消费，producer metadata/raw bytes 只读，snapshot 不被编辑改变。不得用当前编辑政策变化删掉原契约或复活 snapshot-age/equality。
  3. 原两个失败 producer 的未完验收：分别关联 Fabric `producerNotificationsRespectApplicabilityAndInputOwnership`、Forge `producerUsesDualMetadataAndInternalSideWithoutChangingRawMetadata` 的原失败与 S04 最终成功，保留 raw/metadata、目标实际行为及通知集合断言和完整 JUnit cleanup，不禁清理/GC/sleep/重试追绿。S04 底层流关闭、强持有返回流仍可独占打开/删除 JAR及真实 read/close cause/suppressed 仅支持资源修正；结合最新平台版本评估是否充分，覆盖或版本有缺口才定点补验，不自动推导本项 completed，不追认 Forge 历史失败同因。
  4. 原 Core 仅两行注释/原签名与 Jar-in-Jar consumer 保持：关联 S01 实际引用检查（含 SPI/生成源码/fixture）、Core/Mixins/平台编译和 Fabric AW/nested-JAR、Forge JarJar 最小保留通过，核对后续直接变更是否影响；Includes 当时 compileKotlin 为 UP-TO-DATE，不能冒称完整 Includes Transform 集成验收，也不把它新加为硬门槛。受影响点才补最小回归。
  5. Result 列明每条原要求采用哪一已读证据、对应版本/实际方法/结果与剩余限制；新执行须列真实 commands/environment/selectors/pass/fail/skip 及实际内容观察。正常 XML 可覆盖、源码/当前 XML 可读只供定位，不是当前重跑或旧轮永久原始 Result。证据不足仍 partial/blocked，不降低原要求。Router 完整读取关联新 Result 后分别判断 S13 与 W04，恢复成功不改 S01 partial 或任何旧/新 gate。
- 单结果检验：6 个通过及已做迁移在恢复失败后仍保留，故原 S01 与新恢复有独立重试/Result 边界；上述核对/必要补验只共同建立同一剩余 Core 契约验收，不另造资源修复、metadata 编辑或审计成果。四个前置各有独立 completed Result，S13 只消费其效果及版本条件。

### MKF-S02 — Fabric 基于当前 metadata 的显式编辑

- state: completed
- 已采用事实：`codev-mkf-fabric-current-edit/g1`，当前 JSON 两入口/新增引用/未知 DOM 保留；最终 metadata 11＋applicability 2＝13 tests，零失败。前两轮各一个故障测试实现失败后修正，不计为 39 个独立 tests；正常 XML 可被后轮覆盖。
- wave: MKF-W04
- prerequisiteItemIds: []
- 唯一 completion predicate：Fabric handler 的 remove/removeConfigs 在真实编辑边界使用当前 JSON，保持不在删除集合的当前/新增引用和未知 DOM，不因 snapshot 年龄拒绝。
- scope/effects：去除构造/编辑中的重复引用比对与基于旧 mixins 计算剩余项；快照仍用于 discovery，编辑解析/业务校验在当前文件。remove 与 removeConfigs 两条显式入口都遵守当前 owner 的引用移除/新增保留约束，不以旧快照覆盖当前内容；格式/side/resource 错误和真实 I/O 保留。
- write owner：Fabric Mixin listing/handler 及其 metadata/applicability 聚焦 tests；不改 Core/engine/Strip。
- 必需 evidence：load 后添加引用、未知嵌套值再分别显式 edit，保留新引用（定点删除）及其余当前内容、snapshot 不变；producer bytes 不变、Strip 不调用 handler。严格 UTF-8/业务 side/resource/shape/其它 malformed 负例；duplicate keys/raw-control 对照实际 DOM。真实读/写/close 失败向外，不新加预读扫描。
- 单结果检验：Fabric 编辑在既有接口上能独立完成并被显式 consumer 使用；不依赖 S01 完成，只与其 handler 写面冲突，不与其它格式强行合并。

### MKF-S03 — NeoForge 独立 TOML 发现与编辑

- state: completed
- 已采用事实：`codev-mkf-neoforge-toml/g1`，NeoForge 独立 TOML、Forge Manifest-only/SPI/直接 callers、双发现及 producer 保留；metadata 12＋retained 2＝14 tests 单轮全过。以下“Manifest 尚待 S12”保留 S03 当时边界，后来 S12 已完成；不能把当时保留的 snapshot-age 逻辑说成本项已修。
- wave: MKF-W04
- prerequisiteItemIds: []
- 唯一 completion predicate：NeoForge TOML 经独立 rule/handler 被发现并基于当前 TOML 显式编辑；同归档 Manifest 仍由 Forge 发现而不隐藏或重复处理 TOML。
- scope/effects：增加 NeoForge handler/rule，只管 TOML mixins/config；把原 Forge combined loader/handler 中的 TOML 分支、tomlMixins、TOML checkReferences/双格式 equality 及 boolean/dual constructor callers 迁出并删除，Forge 收窄为 Manifest-only 以免双重发现。所有适用 rules 均注册，无 fallback/combined shim。NeoForge 在实际 load/edit 边界解析当前文件、保留新增/未知表字段，environment 不解释为 Fabric side，拥有 load/save/close。**Forge 当前 Manifest snapshot-age 比对的剩余修改属于 S12，不在此顺带完成。**
- write owner：Forge 模块必要新 NeoForge listing/handler、原 Forge listing/handler 的 TOML 分支退出、Mixin SPI/直接构造器与 Forge metadata/retained-baseline fixtures；不改 Forge Manifest 编辑算法、patch/AT/nested-JAR 或 Core。
- 必需 evidence：同 ZIP 不同 Manifest/TOML 集合均被 host discovery 看见，无隐藏/重复，Forge-only、NeoForge-only 均工作；NeoForge load→添加引用/未知表/扩展字段→分别 remove/removeConfigs，仅 TOML 变化、定点删除保留新增项；错误 business/格式/path 与真实 TOML load/save/close 失败传播。旧 tomlMixins/combined TOML 分支/equality 不换名保留，直接 callers/SPI 可构建，触及平台基线保留；不把尚待 S12 的 Manifest snapshot-age 行为谎称已改。
- 单结果及迁移检验：NeoForge 可独立消费/重试的终态与 Forge 当前编辑政策不同。现 combined loader 会再次发现 TOML，故 Forge 的 TOML 分支退出及 SPI/caller extraction 是建立 NeoForge 独立路径的必要迁移，不另造临时双轨。Manifest 在此仍可保留原合法编辑行为；它的新当前编辑要求可独立完成且失败不撤销 NeoForge，故另列 S12，而非把两格式所有效果合并。

### MKF-S12 — Forge 基于当前 Manifest 的显式编辑

- state: completed
- 已采用事实：`codev-mkf-forge-current-edit/g1`，仅 ForgeMixinConfigHandler 与 ForgeMixinMetadataTests 两文件；两入口当前 Manifest 编辑/新增/未知 main、entry 属性保留，checkReferences/重复读/equality 退出，真实 read/write/close 故障传播；metadata 14 tests 单轮零 failure/error/skip。不与 S03 或后续覆盖报告相加；原地写失败仍可能留下部分内容。
- wave: MKF-W04
- prerequisiteItemIds: []
- 唯一 completion predicate：Forge Manifest remove/removeConfigs 在真实编辑边界按当前 MixinConfigs 修改，保持其它当前/新增引用与未知属性，不因旧 snapshot 拒绝。
- scope/effects / write owner：ForgeMixinConfigHandler 的 Manifest 编辑及真实 Forge metadata tests；删除 Manifest checkReferences/重复预读与旧 manifestNames equality，在一次实际编辑读取上验证业务值并计算剩余引用，不换名迁移预读。若 S03 尚未完成，不触及其 TOML 业务；已完成则从其 Manifest-only 最新状态接续。不加 combined/兼容 shim。
- 必需 evidence：load→增加引用及未知 main/entry attributes→removeConfigs，保留非删除集合（含新增）和未知内容；remove 入口同样检查当前内容/新增保留约束；真实读/写/close 与非法 Manifest business/path 失败，producer metadata bytes 保持、Strip 不调用编辑。不同 Manifest/TOML 集合不要求相等，若在 S03 前验证只断言本格式，不把旧 TOML 验收当新完成。
- 单结果检验：当前 Manifest 编辑有独立显式 consumer、失败/重试边界，与 NeoForge extraction 无成功 Result 依赖；只因同写 Forge 文件/tests，安全路线排在 S03 后。Fabric 同理已列 S02。

### MKF-S04 — 资源访问归回实际 owner

- state: completed
- 已采用事实：`codev-mkf-resource-ownership/g1`，ArchiveResources 与直接引用退出，loader scoped read/close 后返回内存流；资源释放/真实 read-close cause/suppressed、输入域与触及 Strip 保留已验证。分轮 17、10 及最终 Mixins 4＋Fabric 1＋Forge 1 通过，重叠/版本及初期编译和 filter 失败见 Context，不累计独立数量。S01 原失败/partial、S10 完整生命周期和所有 gates 不因本项完成改变。
- wave: MKF-W05
- prerequisiteItemIds: []
- 唯一 completion predicate：生产及直接 caller 不再依赖 ArchiveResources 或同形替代层，而由现有 JAR/loader/NIO scoped use 完成实际资源读取、路径保护和关闭。
- scope/effects：删除独立资源层，迁移 discovery/loader/child/recorder/Strip 中真正需要的读取与本地路径校验；不以删层为名丢真实歧义、非法路径/UTF-8、输入域/原因/关闭，也不把将由 S05 删除的额外预验包装成新 helper。
- write owner：Mixins ArchiveResources 及其 MixinInputs、loader、child、recorder、Strip/stripper、当前 codec 的直接使用点与 r04 plugin/直接 tests。不新建资源 façade 或 origin receipt。
- 必需 evidence：源码/测试/反射/生成资源内旧层引用退出；真实 task-only class/plugin/resource 优先、resolution→sources→target、跨输入合法资源读取与 Windows ZIP path、坏路径/UTF-8/真实 read/close 失败；class/resource 一致及触及 Strip 的 CRC/STORED/DOM/原输入保留聚焦回归。静态删除只证明退出，不替代这些行为。
- 单结果检验：共享层迁移到所有实际 consumers 后才有无中间层且保留资源合同的终态；不是重新开发一套资源工具。引擎政策、codec、selector 各有独立可保留效果，另列。

### MKF-S05 — 引擎原生决策与必要原键读取

- state: completed
- 已采用事实：Router 采用 S05/g1 completed：额外预扫/后验退出，原生正常 fallback 与实际异常分开；分轮中 fixture 编译断言已修正并补验。不是可见日志已恢复，日志缺口由 S09 partial/诊断及 S14 单独承接。
- wave: MKF-W05
- prerequisiteItemIds: []
- 唯一 completion predicate：applyMixins 只做原键所需读取/side-mapping/注册/真实转换，不以 Codev 重复预验或转换后巡检重裁正常引擎结果。
- scope/effects：去重复 DOM、class/plugin/refmap 存在性/同来源全扫、独立 parent 有效性证明和转换后 active/environment/plugin/refmap audit；原键/parent 遍历用普通 visited 终止而非第二验证器。保留实际读取、业务形状/UTF-8/path、真实歧义、必需 mapping/显式 context、取消与真实异常。未知 refmapWrapper 不因字段存在被拒绝，不宣称支持/重写。不得迁往改名 helper。
- write owner：Mixins runtime applyMixins、必要 recorder 原键/显式 context 读取接线、直接 producer/failure/DOM/mapping fixtures；不重做 mapping 算法或 notification proof。
- 必需 evidence：真实 side/plugin 排除、optional 缺类、缺 plugin/refmap 与 default mapper 的原生正常返回不追加失败；真实 engine throw 独立向外，required mapping/显式 context 负例仍失败。普通类真实转换、target-owned @Mixin 定义/资源保留，合法空/未通知与坏实际输入区分；parent 原串与 JSON 双语法政策实际 DOM 对照，未变业务保护保留；搜索证明被删预验/后验未换名复活。原先仅验证“必须缺 plugin/refmap 失败”的断言按 owner 调整，不保留为未测债。
- 单结果检验：读取/去预验/去后验/必要 context 接线与正反回归共同建立一个 engine-native 处理合同；不能单删校验却留后验否决。通知未知身份的剩余缺口不是此结果的替身，交 S09。

### MKF-S06 — 无独立 codec 的文件交接

- state: completed
- 已采用事实：Router 采用 S06/g1 completed：Task 在 loader close 后直接写，Strip 本地读，AppliedMixins 工具退出；3 轮共 78 个不同测试通过，非一次最后版本全套。完整 producer graph/真实流 close 仍属 S10。
- wave: MKF-W06
- prerequisiteItemIds: []
- 唯一 completion predicate：简单 entry-file 格式在 Task 直接写、Strip 本地读后仍能独立互通，AppliedMixins 类及同形工具层退出。
- scope/effects：host 在 loader 关闭后直接 serialization DOM 写资源路径→原串数组；Strip 本地读并验证 supplied removalsFile，原串验证回到实际使用点。删除 codec 的所有生产/测试/反射调用，不用测试再创建公共 codec。格式/集合/all-match、严格 UTF-8、业务值/path、空与坏文件区分不变。
- write owner：Mixins produceMixins/Task 完成写入位置、StripMixins/ExactMixinStripper 本地读取与直接 child/recorder 原串 consumers、runtime AppliedMixins、平台/producer/Strip tests 中文件断言与故障注入定位。
- 必需 evidence：真实 Task→文件→Strip、手写和其它任务→独立 Strip，不用 producer memory；空/重复字符串、错误 root/array/string/path/UTF-8/其它 malformed、实际 DOM 双语法政策及未知字段保留；原 bytes/no-match、跨数组/JAR all-match、格式未变。必要写失败与本地读失败向外，旧反射/类名 fault 命中迁移；全部精确关闭顺序/中途 write 的缺口由 S10 收口，不能在此冒充已证明。
- 单结果检验：只有写者与读者及直接引用一起迁移，才能删除同一个文件 codec 而不破坏接口；不是新 file schema 或新的 producer/Strip 功能。手写 set 的业务选择/年龄仍由提供者负责。

### MKF-S07 — 保持能力的 TinyMappingRemapper 改名

- state: completed
- 已采用事实：Router 采用 S07/g1 completed：Tiny 仅保算法改名，最终 8 tests/0 failures（含 SRG）；SRG 字段 descriptor 原限制保留，不升级格式支持承诺。
- wave: MKF-W05
- prerequisiteItemIds: []
- 唯一 completion predicate：现 remapper 以 TinyMappingRemapper 名称在原 engine 链被使用，既有 MappingReader 能力及映射语义不变。
- scope/effects / write owner：仅 Mixins ExactMappingRemapper→TinyMappingRemapper、child 构造/反射/运行域断言、MixinMappingTests 直接引用必要迁移；不新设 Tiny-only parser、改变 mapping-io/引擎版本或重做映射设计。
- 必需 evidence：旧名称的生产/测试/反射引用退出；现有 MappingReader 自动格式入口保留，至少既有格式及一项其已支持的非 Tiny 输入聚焦检查，不新增格式支持承诺；原六项 mapping 场景按受影响选择器验证 owner/重载、descriptor 双向、null/unmapped/歧义、方向/context/元组负例及兼容名/默认 mapper，真实 mapped injection 仍到正确成员。
- 单结果检验：改名、必要 callers 和受影响 mapping 回归只证明同一适配器身份迁移，旧六项通过不直接宣称改名后通过。

### MKF-S08 — native selector 短窗口与 child-owned services

- state: completed
- 已采用事实：Router 采用 S08/g1 completed：短 selector 窗口/child 服务缓存/恢复/多副本协调/窗口外 overlap，7 次 TestKit 输入跟踪实测；fixture 中间失败已修补。原值/临时 selector 值非输入，非参与 host 可观察/干扰及 restore 拒绝局限保留，不是 S10/S11 验收。
- wave: MKF-W05
- prerequisiteItemIds: []
- 唯一 completion predicate：参与 Codev host copies 的 child 初始化以 native selector 短互斥窗口选中并缓存自有 service/bootstrap/global-property，恢复宿主 selector 后转换仍独立并发且跟踪正确。
- scope/effects：删除 loader 虚拟 service URL/resource 重定向；在任何 child engine 初始化前共用 JVM 级短互斥，保存 mixin.service/mixin.bootstrapService 的原值或 unset，临时选择 child service/bootstrap、安装/缓存 child IGlobalPropertyService。finally 恢复后才释放互斥，不锁全转换；无第三 selector/lease/锁平台。不修改原生选项 getter 或创造逐 Task raw override。
- write owner：Mixins host producer/loader/runtime service-bootstrap-property 接点、MixinInputs/native property 跟踪/Task、直接隔离/失败/native-input tests；必要 child bootstrap 类/SPI 原有接点，不引入重定向替代品。
- 必需 evidence：真实成功/初始化失败/取消下两个 selector 原值和 unset 恢复；恢复失败 outward 且保留先前 cause；不同参与 host copies 初始化不交错，恢复后转换可 overlap 且对 serial，child global-property 独有不跨操作。loader 无合成 service resources、竞争 service 不取代 Codev；TCCL/释放与 retry。原 selector 值不作为有效 option 输入、不采到其它操作临时值，其它有效 native options/unset/default 和 implementation classpath 继续跟踪。记录非参与 host 可观察/干扰的真实限制，不声称沙箱。
- 单结果检验：selector、bootstrap、无原生 selector 的 global-property 安装、缓存和恢复是同一次可安全初始化的必要整体；仅改两个属性不是独立可验收的正确 service 选择。性能优化/通用锁不在范围。

### MKF-S09 — 剩余 unknown/dynamic 通知准确性

- state: partial
- 原 wave: MKF-W05；现非活跃成员，恢复成员为 MKF-S14；不作为必须 completed 的等待前置。
- 已采用事实：`codev-mkf-recorder-notifications/g1` Result partial（外层 transport completed 非业务完成）。仅改两个测试，真实 unknown/dynamic 到新 recorder、已知保留、两 JAR/三数组 all-match 与多目标 entry-file/Strip 已补，生产绑定零修改；可读日志仍缺证。`codev-mkf-logger-gap-diagnosis/g1` completed 运行时确认 child 实际 no-op logger，只是诊断。原要求如下逐字保留，不能以诊断 completed 或通知测试通过改 S09 为 completed。
- prerequisiteItemIds: [MKF-S05]
- 唯一 completion predicate：真实新 recorder 收到未知/动态无原键通知时不造键、不撤销已通知的已知原键，集合仍是通知合格身份而非候选/完整应用证明。
- scope/effects / write owner：仅 Mixins GradleMixinRecorderExtension 原键绑定的必要修正与 MixinFailureStageTests/producer 真实 fixture；消费 S05 的简化原始条目读取接线，补 I03 第 2 组残余缺口，不重写已成立 producer 或增加 proof 协议。
- 必需 evidence：断言实际到达 config＋对应 Mixin recorder 的 unknown/dynamic 无原串情形（旧 auditTrail 调用不能算）；同场已知通知保留、未通知候选不造键、嵌套/parent/同类异 config 原键准确、多目标部分/unknown/日志正常返回保资格，真实 exception 单独传播。用简单 entry-file 与 Strip all-match 内容联结，不认证完整应用。说明复用了哪些原 I03 通知场景、补了哪条实际路径。
- 单结果检验：通知集合的精确性是可独立消费/失败/重试的终态；旧 I03 lifecycle 成功不能代证，因此不与 S10 合并为一个恢复 Result。

### MKF-S14 — S09 剩余普通引擎诊断可见性恢复

- state: completed
- 已采用事实：`codev-mkf-native-diagnostic-restore/g1` completed；工厂首次缓存前返回已有 console adapter，指定真实 optional 多目标同 selector 先红1 fail后绿1 pass，JShell 绑定同一 child logger/cache/processor；日志实际可读而不裁判资格，目标42/精确通知/Strip/raw保持。复用 S09 有效通知/required基线，旧 partial不改。 详细方法/复用/限制见 [Context](context.md#已采用的最终完成记录)；原 scope/predicate/evidence 保留为要求。
- wave: MKF-W05
- prerequisiteItemIds: [MKF-S05, MKF-S06, MKF-S08]
- 唯一 completion predicate：在现行 fresh child 中普通原生诊断真正可读，同时同一真实 optional 错误正常返回仍完成输出、保留已通知身份和精确 Strip 结果；与仍有效 S09 已采用证据共同满足其全部原通知/日志要求，不宣告旧 S09 completed。
- scope/effects：仅恢复已确立的普通可读诊断。消费 S05 原生正常返回、S06 文件交接及 S08 child service 初始化/缓存 Results，以及已完整采用的 S09 partial 和日志诊断 completed（事实输入，不是等待 partial 变 completed 的 item 前置）。保留原生按名缓存/调用者和 child 所有权；在首次 getLogger 前由 OperationService 的 createLogger 工厂扩展点返回锁定引擎已有 LoggerAdapterConsole。不是新增日志方案/公共 API、Gradle 专属 callback、跨 loader 日志返回、固定 severity/格式/全量 DEBUG/TRACE/持久化。
- write owner：仅 Mixins `OperationService.kt` 的 logger 工厂及必要 imports，及已有 `MixinProducerTests.notifiedMultiTargetSurvivesLoggedFailureAndUnknownDynamicNotification` 方法内的单项原生错误回归。不得修改 recorder/资格/引擎 required-optional action、selector 生命周期、entry-file/Strip 算法、依赖/工具链；不得通过替 cache、手造日志、提高 injector 宽松度或日志判决追绿。若必须触及其它生产 owner，返回具体缺口，不扩写。
- 必需 evidence / S09 原要求映射：
  1. 关联 S09 原 Result 的真实 fresh child/IExtension→config＋Mixin recorder unknown/dynamic 观察、已知保留/未通知不造键，以及嵌套原串/parent/同类异 config/重复来源数组的当前基线。按现行源码、输入、配置、环境、覆盖和新鲜度判断复用，列出逐条对应；不重放已完成 unknown/dynamic/两 JAR Strip 或重写绑定，实际受工厂变化影响才补最小检查。
  2. 生产工厂在首次缓存前创建已有可见 adapter；不在初始化后换 Map entry 或重复逐调用者日志，不绕过 fresh child/cache/固定引用。原 diagnosis 已证实际 service/logger/processor/cache 同对象，源码只是定位，不代修复后实测。
  3. 只增强上述已有多目标测试：第二轮真实 Other 缺 value()、require=1 保持，用方法内短作用域串行捕获 System.err，finally 恢复；观察原生 InvalidInjectionException 诊断关联 fixture.json、Both、demo.Other，而非手调 logger/fixture 标记。不得绑定时间戳/整行格式/字面 ERROR（optional 可为 WARN）；测试读内容仅验可见性，生产不得解析日志裁判。报告当前 no-op 下该新增断言应失败与修正后实际通过，未实测不得声称红/绿已见。
  4. 同场保留原目标值 42、正常完成、多目标两种精确通知文件与 Strip 内容/原输入不变断言；正常日志/partial/unknown 不撤销资格、未通知不造键。真实 exception outward 独立要求仍用 S09 已采用 required 基线按有效性复用，不以 optional 正常返回代证；不重跑整套通知矩阵。S10 完整完成/失败时序与 S11 caller/cache 不包含在本项。
  5. Result 报实际文件变更、命令/环境/selector、结果与失败/修正/未测，区分已采用 S09 各轮与本次新执行；普通 XML 可覆盖、不保完整原文。证据不足仍 partial/blocked。恢复成功不自动完成旧 S09 或满足 W05；Router 仍须原全部要求、兄弟 completed Results 和充分 gate 证据。
- 单结果检验：已完成通知/entry-file/Strip 即使日志恢复失败仍有独立价值，故不复跑 S09；工厂修正和单个真实错误的可见性＋不否决通知断言共同证明一个剩余诊断合同，不另立日志审计。S10 生命周期与 S11 caller 各有独立消费/失败/恢复边界，不能与 S14 合并。

### MKF-S10 — 剩余 producer 完成与失败生命周期

- state: completed
- 已采用事实：`codev-mkf-producer-lifecycle/g1` completed；完整 JDK graph和直接 archive→return→loader→entry→pair时序、六类真实流/close/取消/move 故障及 loader-close、保护/retry成立。首轮漏 fixture classpath失败修正；10个不同方法通过后最终两个受影响方法补验，非最后单轮全套。 详细方法/复用/限制见 [Context](context.md#已采用的最终完成记录)；原 scope/predicate/evidence 保留为要求。
- wave: MKF-W06
- prerequisiteItemIds: [MKF-S04, MKF-S06, MKF-S08]
- 唯一 completion predicate：新版真实 producer 的 JDK 返回与两文件完成边界在正常及真实流/关闭失败时可证明，失败不能消费半 pair 或旧 pair，retry 与干净调用一致。
- scope/effects / write owner：Mixins produceMixins/child/loader 的必要生命周期修正和 producer/隔离/DOM failure tests；消费资源 API、本地文件交接及 selector 恢复三个真实变化后的 close/write 边界。仅补 I03 第 1/6 组及其受影响资源保护，已落地 fresh seam/旧框架退出不重做；无新通用注入/发布框架。
- 必需 evidence：真实处理调用输出行为并递归检查完整返回 graph 为 JDK Map/Set/String、关闭 archive 后返回仍可用；直接观察 archive close→return→loader close→host entry 完成→pair 完成，Kotlin/DOM/engine 不跨界。触达 target 与 entry 流中途 write、entry stream close、输入 ZIP close，以及已有 loader close/取消/第二 move 的受影响路径；不是 checkWrite-open 拒绝或仅文件回读。每次先有旧成功再 fail-current，stage/cause/未知身份诚实、Strip/required consumer 失败、raw/另一操作结果保持，解除故障 retry。两输出 alias、realpath/hardlink/containment、同目的地竞争、TCCL/JAR 释放按实际变更补验；I02 stream close 仅复用 Strip 自身，不代证 producer。默认输出查询/applied-only smoke 只补受影响者。
- 单结果检验：graph/关闭时序与中途 I/O 失败都是同一 producer 输出何时可消费的正反面；正常返回本身不足，故一次生命周期修复/聚焦证据不能拆成“只成功图”“只故障数量”的完成声明。unknown 通知归属是另一可保留结果，已列 S09。

### MKF-S11 — 显式 caller 的当前结果闭包

- state: completed
- 已采用事实：`codev-mkf-caller-consumption/g1` completed；只增强 caller tests，公开注册/全部required JAR内容、两 Strip及producer真实失败、逐类输入变化、两输出恢复和无producer memory清理成立。第一轮5方法、第二轮2方法重叠1，共6个不同方法，非7/非最后全套；九行映射已采用。两次LSP inconclusive，不称clean。 详细方法/复用/限制见 [Context](context.md#已采用的最终完成记录)；原 scope/predicate/evidence 保留为要求。
- wave: MKF-W07
- prerequisiteItemIds: []
- 唯一 completion predicate：同一真实 caller 的公开注册/依赖/消费在执行、输入变化及正常复用各状态都得到请求的当前 applied-only 或完整清理结果，失败不冒充成功。
- 真实前置：W04/W05/W06 提供当前 discovery/编辑契约、engine/通知/mapping/services 与完成文件交接；不依赖历史 I03/I04“变 completed”或旧 W02 释放。
- scope/effects / write owner：承接未执行 I04 的 Mixins pipeline-caller.gradle、MixinInputBindingTests 及必要小 fixture/测试注册/fault 定位；不偷偷修生产算法、接外部 caller 或重复完整组件终验。
- 必需 evidence：真实 registerTransform/type/parameters/from-to、provider→removalsFile、attributes/view 与 producer dependency；raw producer 输入＋raw sources/derived-target 全部必需 Strip 消费，resolution-only 排除、不同操作不 union/反馈。观察目标实际行为及全部清理内容，applied-only 不称 cleaned；source-strip/derived-target-strip/producer 各真实失败使所需消费失败，不否定另一已完成组件。相同链 SUCCESS→UP-TO-DATE→清自有输出 FROM-CACHE，恢复两 outputs，新 consumer 无 producer memory 仍执行/正确复用每个 Strip 并验内容。逐类改变 config/plugin body/resource/mapping/side/context/其它有效 native properties/unset/default/有序 runtime/implementation inputs，独立 removalsFile/inputArtifact 内容变化也跟踪；固定 selectors 原值/临时值不误作 option 输入。有效空与缺失/损坏/stale 分开，先成功再 fail-current 不回退旧文件。复用 R01/I02/I03 仍有效覆盖，只补新版接点/受影响场景；报告真实 commands/environment/selectors/结果、复用与未测，不自行判 gate。
- 单结果检验：这是既有同一 caller 链在执行/复用状态下的当前消费合同；缓存恢复不是独立缓存功能/平台，必须复用同一依赖/消费场景才有意义，不另造审计或固定终验。若需要生产修复，报告有界失败及已做范围，不吞进第二组件结果。

## 新版依赖、冲突与作者分组检查

- 业务 item 等待（箭头表示等待）：S09→S05 的原键输入；S10→S04/S06/S08 的实际资源/写读/初始化关闭接点；S13→S02/S03/S04/S12 的当前 adapters/fixture 与资源修正 Results；S14→S05/S06/S08 的原生处理、本地文件与 child service 缓存接点。S13 的四个前置已有 adopted completed 事实，但证据仍须按当前覆盖复用；不等 W05 gate。其余 items 无成功 Result 前置；S01/S09 partial 均不成为隐形成功依赖，S14 不等 W05/W06 gate。
- S01/S02/S03/S12 各自保持直接 callers 可构建；S01 与平台编辑只写面冲突。S03 抽出 NeoForge 时必须迁移旧 combined dispatch 的 TOML 分支；Manifest 当前编辑仍有独立终态，已列 S12，不借同文件/同平台合并。resource/engine/codec/remapper/services/notification/lifecycle 各有独立可保留、独立重试/消费效果，不能以“简化 producer”合并一个混合 Result。
- **写冲突串行，不冒充业务前置**：S01–S02（Fabric handler），S01–S03/S12、S03–S12（Forge handler/SPI/fixtures）；S04 与 S05/S06/S08/S09（child/recorder/loader/Strip 或其直接 calls）；S05 与 S06/S07/S08/S09（child/recorder/bootstrap/fixtures）；S06 与 S09/S10（原串/producer/file/fault callers）；S07 与 S09（mapping/recorder 对照及共享 engine fixture）；S08–S10（producer/loader/隔离失败）；S09–S10（producer/failure 共用 fixture）。所有触及同一测试源码/生成资源/Gradle 输出与 daemon/cache 的执行另行串行，不能并行覆盖；其它真实新增交集也按最新状态交还所有权后串行。安全保守路径为 S01→S02→S03→S12→S04→S05→S06→S07→S08→S09→S10→S11，仅作为冲突定向，不把此顺序填成全部 item 前置。
- S13 不写生产代码/Core/metadata 政策，只在必要时补直接契约 tests/fixtures；S01 原迁移不重放，S02/S03/S12 已交还的 metadata fixture、S04 的 Mixins fixture/loader 观察按最新状态消费。与 S05/S06/S07/S08/S09/S10/S11 的共享 tests/生成资源/Gradle 输出、daemon/cache 运行冲突全部串行，实际新增交集同理。保守冲突定向在原路线 S04→S05 间插入 S13：S01（仅历史效果）→S02→S03→S12→S04→S13→S05→S06→S07→S08→S09→S10→S11；这不是全部成功前置或实施调度。 这段原保守方向保留历史可行性，不要求把已完成 S05–S08/S13 重放；当前 S13 completed/W04 satisfied 由 Router 已采用。S14 与 S09/S10/S11 共享 MixinProducerTests/动态 fixture、Gradle 输出/daemon/cache，短时 System.err 捕获也有进程副作用，必须串行并 finally 交还；S05/S06/S08 若再触及工厂依赖/fixture 同理。可在原冲突方向 S09→S10 之间插入 S14 验证无环，此方向仅控制冲突，不是成功前置或调度决定。
- W04/W05/W06 没有前置 Wave gate；W07/S11 才等三个组件 gates。S14 等 W05 的 S05/S08 和 W06 的 S06 items 而非它们的 gate；W05 等 S14 但不等历史 partial S09，S10 仍仅等 S04/S06/S08，不加 W05 全局屏障。W04/W05/W06/W07 satisfied 只投影 Router 既定判断。S10/S11 原要求及 W06/W07 gate 不变。联合 wait/链接实检见 [Plan 本次作者自检](plan.md#s09-诊断恢复维护作者自检)。本次先测分组：S09 通知已有独立保留价值，剩余诊断可独立恢复；S14 的工厂/单项关联回归只建立一个谓词，不与生命周期或 caller 合并。

## 历史原图冻结边界

以下完整保留原范围的 item/gate 谓词、owner、验证和当时作者自检；除 I03 的可靠状态补为 partial 与明确历史标题外不改原要求。旧文本中的“活跃”“本次”“当前”“不写属性”“无 Core inheritance/冲突 equality”等只描述当时范围，不能执行或否定上方新版 owner。旧 W01 satisfied 不撤销，旧 W02/W03 未释放不变；新版 gates 不自动使它们 satisfied。旧 I04 pending 表示从未执行，其剩余效果由 S11 承接。原完成事实详见 [Context](context.md#已采用的-i03-partial)。

## 历史原图语义、owner 与冲突

- 一个 item 只交给一个 Handler，返回一个独立 Result；所有 scope、constraints、产物和检查共同建立该 item 的唯一谓词。所有权是未来写边界，不指定人员或暗示已获实施许可。
- 每项执行前仍须 Router 确认当前实施范围/权威、完整前置 Results/gates、写冲突和实际工具权限。每个 Result 只报告本项工作/检查/限制，不自行改 Waves/Todo、释放 gate 或决定 continuation。
- 本图共用约束：引用 [Plan](plan.md) 的排除项及 [Spec](../../spec/mixin-preapplication.md)；不写 authority/旧 Work、无关 Core/includes/Forge patch、锁/版本、外部 caller 或 LLM 指令。不得通过测试恢复旧 parser/框架/错误 inheritance；保留输入、资源、SPI/mapping、TCCL、原始 cause 与真实 physical destination 保护。未来必要模块 build 配置只可调整本职责的依赖可达/跟踪或测试注册，不改版本/lock/根工具链。
- **冲突表（不是假造的业务前置）**：

| items | 真实冲突面 | 安全串行安排 |
| --- | --- | --- |
| MKF-R01 / MKF-I02 | 共享当前 `OperationRunner` 的 discovery/host 依赖接线文件；还可能共享 `MixinPreapplicationTests` 构造器/公共 fixture、Fabric metadata 的直接 strip 回归和 Gradle test 输出/daemon。 | W01 内 R01 在 I02 前；不同时写共享 fixture/运行测试。I02 无业务 Result 前置，不依赖 W01 自己释放；先项终结/释放写所有权并读清当前效果后才能触及冲突面，partial/failed 不被当完成。 |
| MKF-R01 / MKF-I03 | host discovery、配置 snapshots、平台 producer tests、SPI/动态源码。 | I03 真正消费 R01 的接口/适配结果及 W01 gate，不重做其 metadata 能力。 |
| MKF-I02 / MKF-I03 | `AppliedMixins` 文件 DOM、`ExactMixinStripper` 必要调用、publication 最后调用清退、共享 tests 与运行副作用。 | I02 先把独立 Strip 从通用 publication 退出并提供直接文件 DOM，I03 以其为输入迁移 producer 并移除最后旧 framework/parser 调用，补受影响回归。 |
| MKF-I04 / 所有组件项 | 公开接口、caller resource、共享 tests/Gradle cache/output 的写入/执行效果。 | 全组件 completed/gates 满足后，再在最新状态验证真实组合；不一边改生产一边用旧 caller 结果。 |

只读同份权威不构成冲突。无正面非冲突证据不并行；这里给出充分串行路线，不新造跨构建锁。R01/I02 不能因写冲突合并为一个结果：它们各自对不同调用方式产生有用终态。

## 历史原图 Waves 与释放谓词

### MKF-W01 — 专用配置契约与独立 Strip 可用

- state: satisfied
- itemIds: [MKF-R01, MKF-I02]
- prerequisiteWaveGates: []
- 增量结果：平台装载的 Mixin 专用配置对象与来源无关的精确 Strip 都有完成证据，可以作为 producer 重写的已知输入。
- gate：Router 完整读取并可靠关联两个独立 completed Results，分别满足下文 R01/I02 谓词、必需正/负/保留/失败检查，必要直接 caller 迁移可构建；两者组合没有遗留 Core inheritance 或 Strip metadata/engine 调用。I02 已从通用 publication 退出、文件读写 DOM 可被 host 使用，R01 的快照不会丢 side/resource 关联。仅将旧 I01 未完成配置契约的活跃成员改为 R01；旧四组检查不删，JSON 两项语法政策按现行 Spec 验证，严格 UTF-8/其它格式/业务值/路径保护仍需负例。旧 I01 blocked 不需也不能被解释为完成；R01 completed 也不会自动释放本 gate，仍需 I02 及此处全部独立判断。任一不足都不释放。
- 显式依赖方：MKF-W02 / MKF-I03，以及通过后续组件关系消费的 MKF-I04；不是全仓全局 gate。

### MKF-W02 — Kotlin-first 隔离整 JAR producer 完成

- state: pending
- itemIds: [MKF-I03]
- prerequisiteWaveGates: [MKF-W01]
- 增量结果：接受的 host/loader/child/recorder 与 Task 独立完成生命周期取代旧控制/解析/发布框架，并保持真实行为与保护。
- gate：I03 的独立 Result completed 且包含其全部必需观察；W01 组件契约仍成立，I03 对它们的实际影响已验证，旧 parser/control/SHA/publication 框架的生产与直接测试调用退出，无换名复制。两 named outputs 来自真实 engine/准确通知，非编译或文件存在推断；本 gate 不声称 caller/cache 闭包已完成。
- 显式依赖方：MKF-W03 / MKF-I04。

### MKF-W03 — caller 请求的完成消费及正常复用闭包

- state: pending
- itemIds: [MKF-I04]
- prerequisiteWaveGates: [MKF-W02]
- 增量结果：真实显式注册的 caller 可以消费 applied-only，或同操作完整清理集合，并在输入变化、失败和正常复用时保持其所请求结果的真实性。
- gate：I04 Result completed，含其实际内容/行为、依赖、两 strip 失败、producer 失败、当前输入变化与无 producer memory 的 UP-TO-DATE/FROM-CACHE 观察；有效空与缺失/损坏/stale 明确区分。W01/W02 所需组件证据仍有效，所有 Spec 当前验收行均有足够覆盖，且记录未执行/复用边界。只看缓存标签、日志或文件存在不释放。
- 本 gate 连同 MKF-W01/MKF-W02 建立匹配 Plan 的整体结果；无新的实施 item 依赖本 gate，不新增独立重复终验。

## 历史原图 Items（原活跃集合，非当前执行集合）

### MKF-R01 — 未完成的平台专用 Mixin 配置契约恢复

- state: completed
- wave: MKF-W01
- prerequisiteItemIds: []
- 恢复边界：仅承接旧 MKF-I01 未完成的配置契约；旧项无实现修改可回放，不把库探针当迁移证据，不依赖旧 blocked 完成。以下四组检查全部仍需实际完成；每项一个 Handler/一个独立 Result。
- objective / 唯一 completion predicate：Fabric/Forge 经专用 Mixin listing 返回可用 resource/side reference 快照及真实显式 metadata 编辑 handler，所有直接发现 caller 已脱离 Core listing/Jar-in-Jar 与独立 environments 能力，现行格式/编辑冲突保护不回归。
- scope/effects：定义 `MixinListingRule`、`MixinConfigHandler`、`MixinConfigReference`、`ConfigSide` 的接受职责，不冻结未选 ABI/enum/null 策略；迁移 Fabric JSON、Forge Manifest/TOML 装载与 handler，保留 `remove`/`removeConfigs`。Fabric metadata 使用既有 serialization DOM，移除 StrictJson 前置扫描；重复对象键及字符串内未转义 U+0000–U+001F（含未知字段）沿实际库行为，不额外扫描或固定边缘结果。host discovery 改消费 snapshot，仍只读 metadata；仅迁移当前 host 的直接接口调用，不先重写 child/通知/生命周期。fixture rule/SPI/动态源码随接口一起改到可构建。
- write owner：Mixins `src/main/kotlin/net/msrandom/minecraftcodev/mixins/` 的 listing/reference/handler/side 对象，旧 `MixinConfigApplicability`/`SelectiveMixinConfigHandler` 引用退出；`OperationRunner` 仅 discovery 接口适配；Fabric/Forge `src/main/kotlin/net/msrandom/minecraftcodev/{fabric,forge}/mixin/` 及相应 Mixin listing SPI；这些契约的 Mixins fixture 与平台 `src/test/.../mixin/`。不改 Core 的 `FileListingRules`/`ListedFileHandler` 或 Jar-in-Jar consumer。
- 必要检查/产物：
  1. 沿现存 Fabric/Forge metadata tests，用真实 JSON/Manifest/TOML load→reference snapshot 检 resource 与 side 关联、重复引用/缺省/显式 side 与现行无结果行为；host 只读装载前后 metadata bytes 未变。
  2. 分别真实调用 remove/removeConfigs：精确引用更新、其余 metadata 保留，非法结构/路径/格式不支持的 metadata side 值（区别于 operation 显式未知 side）和引用修改/双 metadata 编辑冲突明确失败；不把“生产者只读”误写为删除 handler 方法。Fabric metadata 的 duplicate object keys 与 raw-control 字符串（含未知字段）分别直接对照所用库 DOM；不要求额外拒绝或固定 last-value。覆盖 load 与显式 edit/写回后未知值的 DOM 保留，必要 resource/side/原串业务值另验，严格 UTF-8 和两项语法政策以外的格式错误仍失败。不把库允许语法等同引擎或业务值允许，也不重开 Forge Manifest/TOML 政策。
  3. 编译及 focused fixture/平台测试证明真实 SPI load 与 host 调用接上；直接引用搜索涵盖 Core inheritance、environments、旧 handler、ServiceLoader/生成源码，不留错误继承/悬空注册。保留触及的 AW/AT/nested-JAR 最小基线，不扩成平台重做。
  4. Result 报实际变更、selectors/环境/结果及未测分支；不声称 producer 新设计或独立 Strip 完成。普通源代码/测试即产物，不需独立报告文件。
- 整体单谓词检验：对象、两个平台 adapters、必要 host/fixture 迁移与回归共同建立一个可消费的专用配置契约；单删接口/单保留 metadata 方法不能满足。其终态可供 producer 消费，故与 Strip/producer 分项，不按平台文件数另拆。

### MKF-I02 — 来源无关的 DOM 精确 Strip 生产者

- state: completed
- wave: MKF-W01
- prerequisiteItemIds: []
- objective / 唯一 completion predicate：公开 `StripMixins.Parameters.removalsFile` 不依赖 Mixin producer/engine/Loader metadata，能按任意合规文件完成单 JAR 精确清理副本与独立安全生命周期，内容保留及失败不可消费满足 Spec。
- scope/effects：重做 `ExactMixinStripper` 与 entry-file 直接 DOM 读写，保留简单文件/JDK set 接口；重复对象键与字符串内未转义控制字符遵循所用库标准行为，含未知字段且不固定边缘结果；不保留 StrictJson 或 raw-control/duplicate scanner。严格字节解码、业务 shape/字符串/资源路径验证继续存在。按精确 resource＋原串删全部三数组匹配，无变化原配置 bytes，有变化保留其它 DOM。Strip 从 OperationPublication 退出，把所需输入/alias、workspace/staging、关闭/异常/安全清理职责放回本组件，不创建通用替代框架；Task 旧 publication 的最后调用留 I03 清退，不在此宣称 producer 已重写。
- write owner：Mixins `StripMixins.kt`、`ExactMixinStripper.kt`、`runtime/AppliedMixins.kt`；仅必要的 archive-path 输入 helper/共享 fixture 直接调用，`StripMixinsTests`/`StripFixture` 与相关直接 strip/文件格式测试。不得提前改 engine/loader/recorder 或 handler 编辑职责。公共 entry writer 改成 DOM 时，保留 producer 当前可用文件编码/接口，允许仅补 `OperationRunner.implementationInputs` 的 host serialization 依赖可达/跟踪并跑受影响 host 写读回归；不改其执行编排，不把 DOM 对象传给 child。
- 必要检查/产物：
  1. 没有 Mixin producer 的真实手写文件、另一个任务输出，各自独立清理真实 JAR；空对象/空数组/重复字符串、空集/无匹配保留原 bytes，缺失/非 object/非 array/非 string/unsafe path 不变空成功。
  2. 同数组重复、跨 mixins/client/server、跨 JAR 同键全部移除；不同路径/原串、展开类名/映射类名不误匹配。不按 source/hash/section/index 唯一性拒绝。未知/null/嵌套 DOM、条目顺序、空 config 文件、class/refmap/metadata/无关资源和原始归档保留。包括 STORED size/CRC/损坏 ZIP/非法路径。
  3. 对配置字段/未知嵌套/entry-file 的重复 object keys 与字符串内 raw control 分别直接对照实际 serialization 库 DOM，不固定接受结果/last-value，不加扫描器。检查未知字段中的此类字符串在有变化时保持 DOM 值、无变化时保留原 bytes；合法语法不豁免 resource/原串业务规则。非法 UTF-8、其它 malformed JSON、错误 shape/元素/路径仍必须失败。若不能满足未变保护，返回具体冲突，不造 scanner/升级依赖/改 Spec。
  4. 真实写入/close/取消失败、已有旧输出后的失败消费、输入 realpath/hardlink/目录包含保护；失败输出不可当本次完成、原输入/其它输出不变。断言 Strip 没有加载 engine/metadata discovery/edit，不以文件存在或 Mock 替代真实 archive 检查。
  5. 返回本组件 Result 和实际测试/限制，必要 producer-host 文件读写回归只支撑本谓词，不声明隔离 producer 完成。
- 整体单谓词检验：DOM 文件读写/精确算法/独立 lifecycle 与直接测试是一个单 JAR Strip 产出契约；手写和其它任务来源只是同合同输入变体，不是独立审计/持久效果。独立 Strip 有自己的成功/失败与消费者，不能和 producer 合并 Result。

### MKF-I03 — Kotlin-first 隔离整 JAR Mixin 生产者

- state: partial
- wave: MKF-W02
- prerequisiteItemIds: [MKF-R01, MKF-I02]
- objective / 唯一 completion predicate：`Mixin` 从声明 raw 输入经 fresh IsolatingMixinClassLoader 加载的 Kotlin 整 JAR child 函数真实处理，准确通知在 archive/loader 关闭后形成两个可消费 tracked outputs；保持命名/隔离/失败保护，且不再依赖旧控制/parser/SHA/publication 框架。
- 真实前置：消费 R01 的专用 snapshot/平台 caller 契约；消费 I02 的简单 entry-file DOM 与独立 Strip 已退出通用 publication 的结果，才可移除共享旧 publication/parser 的最后引用。不是仅按 Wave 编号串行，也不把旧图 completed 用作前置。
- scope/effects：host 管参数/Loader 发现/缓存输入和完成；新具名 loader 与 Kotlin whole-JAR 函数建立实际加载 seam，child 内配置/parent/refmap DOM、锁定引擎初始化/mapping、普通类转换和目标内 Mixin 定义/资源保留。`GradleMixinRecorderExtension` 用 config＋对应 Mixin 直接映回完整路径/原条目，替换 candidates/audit-string 猜测。保留精准 remapper/native option 规则；不写全局属性、不引入 raw override/getter 适配。移除 EngineOperation 控制层/自建 SHA 钉死、旧 runner 控制形状、StrictJson 和通用 OperationPublication（含直接测试/反射/fixture caller），不换名复制；真实保护就近归属。
- write owner：Mixins Task、隔离 loader/Kotlin 函数/recorder、当前 `OperationRunner`/`runtime/EngineOperation`/`PinnedMixinAdapter`/service/property/mapping/resource 中实际承担上述职责的部分，旧 publication/parser 及直接调用测试；必要 Kotlin/serialization 实现 classpath 可达与 Gradle tracking。Fabric/Forge 仅直接 producer/反射测试调用迁移，不重写 R01 handler。I02 文件/strip helper 仅必要连接与受影响回归，不扩 strip 业务。保留最小插件 apply 不 bootstrap；旧 host/SPI/Groovy 已退出不回放。
- 必要检查/产物：
  1. 真实目标/config/plugin JAR，经新 Task/child seam 调用输出行为（如原值与处理后值），验证完整 resource/原字符串键、JDK graph 物化，archive 关闭→return→loader close→entry file complete→两输出完成顺序；serialization/Kotlin/engine/ASM 同域和输出相关实现依赖跟踪。默认两输出执行前可查，全部默认及只改 outputFile 的 TestKit applied-only smoke 不伪造 entry file。
  2. 真实 recorder config＋Mixin 原键（含同类名不同 config、嵌套路径、原数组串、parent、动态无原键）；发现/prepared 候选不授资格，多目标另一处失败/partial/unknown 且正常返回不撤销已通知键；日志可读但不解析裁判，engine exception 独立传播。零适用配置有效副本/零通知有效空，与坏输入区分。
  3. task-only class/plugin/resource 优先、sources/target-only discovery、resolution→sources→target、竞争 SPI 拒绝、无隐式 host/CWD fallback；必要输入真正歧义失败，不一律拒绝跨 JAR 重复清理键；Windows ZIP `/` 路径。包括 target 同时承载 config、Mixin 定义和普通类：普通类仍真 transform，定义/非转换资源保留，不按宽泛包猜测跳过。
  4. 现小 mapping fixture 经 refmap→MemberInfo→engine remapper 到正确 owner/重载；双向 descriptor/null/unmapped/歧义、兼容名/无 refmap/default mapper/context-only、坏 tuple/namespaces/context/方向失败。side/context 专用参数实际生效；原生宿主属性/default/未设置输入跟踪与 native 读取一致，Codev 不污染属性、无 mapping 不强启 remap。
  5. 同 JVM A→不同/空 B、失败→retry，独立 overlap 对 serial；TCCL finally/owned loader/ZIP/stream close 及文件可移动释放。Task outputs 互 alias、input realpath/hardlink/protected containment、相同物理 producer destination 拒绝或独占，多个消费者读完成输出不误判冲突。
  6. 已有效输出后 invalid/engine exception/取消/真实写入/中断/close/runtime exit 失败，含 entry-file 写/close 与 target 成功后失败：向外异常 stage/cause/已知身份或明确未知，不给半结果/stale success，不删另一操作结果；retry 如干净调用。不要求多文件事务/跨构建锁。
  7. 搜索生产/测试/反射字符串/SPI/生成源码的旧控制/parser/SHA/publication 调用，迁移必要引用，跑变更影响的 producer/preapplication/mapping/isolation/failure、平台 caller 与 I02 回归。重复键及字符串 raw-control 的库对照检查覆盖 child config/parent/refmap（含未知字段），host metadata 用 R01、entry-file 用 I02 的现行同义政策，不能只测 entry file；无额外拒绝/扫描或固定边缘结果。实际 engine 的业务/解析失败仍诚实传播，不声称第三方引擎采用同一 DOM。严格 UTF-8、其它格式错误、resource/side/原串及形状/路径保护照旧，必要保留内容与失败消费回归不能删。静态退出搜索不代替以上真实观察。
- 整体单谓词检验：Task/loader/child/recorder/命名与关闭/完成是一次 producer 的耦合生命周期，最后调用清退、直接 caller 迁移及回归都是建立其可消费两输出的手段；不单列删除/参数/通知 proof 项，也不在本 Result 完成 caller/cache 的独立效果。

### MKF-I04 — 显式 caller 的完成消费和当前输入复用

- state: pending
- wave: MKF-W03
- prerequisiteItemIds: [MKF-R01, MKF-I02, MKF-I03]
- objective / 唯一 completion predicate：真实 caller 通过公开组件显式注册/参数/依赖/属性消费，正常运行与当前输入复用都得到其请求的 applied-only 或同操作完整清理结果，失败不被旧文件/缓存标签/生产内存伪装为成功。
- scope/effects：沿现存 `pipeline-caller.gradle`/`MixinInputBindingTests` 用小真实 JAR 建立 caller 观察，更新受新私有 seam 影响的故障注入，保留显式 producer dependency。集成证明属于本项，不另立泛化终验/审计/证据平台，不在 fixture 偷修生产算法或触及外部工程。若需生产修复或新 authority，报告具体失败和已完成范围，不能静默扩大为第二 producer 结果。
- write owner：Mixins caller resource、`MixinInputBindingTests` 及其必要小 fixture/输入资源/实际 fault seam；必要测试注册，不改生产实现/依赖版本。普通 test 结果、小 JAR/配置内容断言为证据，不要求新报告包/hash/receipt。
- 必要检查/产物：
  1. 真实 project `registerTransform` 的 type/parameters/from-to、provider→removalsFile、attributes/configuration 或 artifactView、显式 producer dependency，实际消费处理结果；raw producer 输入不取 strip view。同操作 raw source＋含 config 的 derived target 全经对应 Strip，resolution-only/无关外部 config 不清理。两 operation 的不同 set 不 union、不串；originals 不变。
  2. 应用目标的真实行为和全部所需配置的精确清理内容同时观察；applied-only 可单独成功但不称 cleaned。分别令 source strip、derived-target strip 和 producer publication 真实失败，检查要求的消费失败、不用已存在 JAR 冒充；另一独立完成组件不被谎报未完成。日志不替代内容断言。
  3. 同链首次 SUCCESS、正常 UP-TO-DATE、清除自有输出后 FROM-CACHE（不清全局缓存），恢复两个 Task 输出；新 consumer/无 producer memory 的首次 strip 仍实际清理或正确复用每个 required Transform（包括 derived target），检查内容与输入保护，缓存标签不算新通知。单独检查 Transform 参数和 inputArtifact/输出复用。
  4. 仅改变 config、plugin method body、资源、mapping、专用 side/context、实际影响输出的宿主属性/未设置/default、runtime 顺序及实现输入，逐类检查 Task/Transform 失效或有效复用对应**当前内容**。实现 classpath 变化用最小 fixture 输入或现有有效测试支撑，不改生产依赖版本。独立 Strip 的手写/其它任务 removalsFile 内容和 inputArtifact 变化同样跟踪。组合输入中的 JSON（含未知字段字符串）沿 R01/I02/I03 与现行 Spec 的双语法政策：不恢复 raw-control 必须拒绝的旧断言，观察所用库 DOM 及保留内容，业务值/严格 UTF-8/其它无效格式/路径负例仍由组件与本链必要回归连接，不重新做独立 parser 审计。
  5. 有效空成功单列；丢失/损坏/无效/旧交接不靠内存或文件存在跳过清理，只有正常重建/正确恢复或消费失败合法；先有有效产物再 fail-current 也不能回退旧输出。更新 fault seam 后记录确实触及所需 I/O/close/write 点，未触达分支不得记通过。
  6. 按未变源码/输入/配置/环境复用有效组件证据，补真实受影响处，不重跑全部旧 suites。Result 列实际 commands/environment/selectors/结果、复用范围及未执行限制；不自行宣告 gate/Plan 完成、外部 caller 迁移或下游支持矩阵。
- 整体单谓词检验：注册/依赖/消费、失败和输入变化/cache 是同一 caller 在执行/复用状态下的当前结果正确性，不是分别发布/部署/审计；小场景共用同一链和恢复边界。组件成果单独有用且已各有 Result，不能被本项“补验”覆盖或重写历史。

## 历史原图的旧 item（不在原恢复成员集合）

旧 I01 的原成员关系与要求仅用于解释阻断和恢复来源；不是第五种实施结果，也不是等待其完成的隐藏前置。旧项没有活动写所有权；本次已知无其它活动执行/写任务。

### MKF-I01 — 平台专用 Mixin 配置对象契约

- state: blocked
- 原 membership：MKF-W01；本次仅迁移活跃成员为 MKF-R01，旧项不属于现活跃 Wave，不再作为执行前置。
- 原 prerequisiteItemIds: []
- 已采用事实：首次配置契约 Handler Result 为 blocked，无生产/测试/权威/图修改，没有已完成迁移可回放。库探针与当时 raw-control 拒绝要求冲突；下列四组必要验证没有执行，不存在 JUnit/handler 验收完成事实，旧阻断从未释放 W01。
- 时点说明：以下原 objective/scope/owner/四组检查逐字保留。其“其它格式”在当时仍包含 raw-control 拒绝（原图 I02 必要检查 3 明定 `非法 UTF-8/raw control/malformed JSON 必须失败`，并经 I03 传播到 child 路径）。用户后来接受并已写入 Spec 的语法政策只替代该拒绝要求，不追溯改写旧项状态；未变接口/平台/SPI/host/编辑/保护验收全部转入 R01。简洁事实与环境限制见 [Context](context.md#已采用的实施阻断及局部政策变化)。
- objective / 唯一 completion predicate：Fabric/Forge 经专用 Mixin listing 返回可用 resource/side reference 快照及真实显式 metadata 编辑 handler，所有直接发现 caller 已脱离 Core listing/Jar-in-Jar 与独立 environments 能力，现行格式/编辑冲突保护不回归。
- scope/effects：定义 `MixinListingRule`、`MixinConfigHandler`、`MixinConfigReference`、`ConfigSide` 的接受职责，不冻结未选 ABI/enum/null 策略；迁移 Fabric JSON、Forge Manifest/TOML 装载与 handler，保留 `remove`/`removeConfigs`。Fabric metadata 使用既有 serialization DOM，移除 StrictJson 前置扫描，不额外扫描重复键。host discovery 改消费 snapshot，仍只读 metadata；仅迁移当前 host 的直接接口调用，不先重写 child/通知/生命周期。fixture rule/SPI/动态源码随接口一起改到可构建。
- write owner：Mixins `src/main/kotlin/net/msrandom/minecraftcodev/mixins/` 的 listing/reference/handler/side 对象，旧 `MixinConfigApplicability`/`SelectiveMixinConfigHandler` 引用退出；`OperationRunner` 仅 discovery 接口适配；Fabric/Forge `src/main/kotlin/net/msrandom/minecraftcodev/{fabric,forge}/mixin/` 及相应 Mixin listing SPI；这些契约的 Mixins fixture 与平台 `src/test/.../mixin/`。不改 Core 的 `FileListingRules`/`ListedFileHandler` 或 Jar-in-Jar consumer。
- 必要检查/产物：
  1. 沿现存 Fabric/Forge metadata tests，用真实 JSON/Manifest/TOML load→reference snapshot 检 resource 与 side 关联、重复引用/缺省/显式 side 与现行无结果行为；host 只读装载前后 metadata bytes 未变。
  2. 分别真实调用 remove/removeConfigs：精确引用更新、其余 metadata 保留，非法结构/路径/格式不支持的 metadata side 值（区别于 operation 显式未知 side）和引用修改/双 metadata 编辑冲突明确失败；不把“生产者只读”误写为删除 handler 方法。对 Fabric duplicate object keys 只要求与实际库一致，其它 UTF-8/格式仍失败。
  3. 编译及 focused fixture/平台测试证明真实 SPI load 与 host 调用接上；直接引用搜索涵盖 Core inheritance、environments、旧 handler、ServiceLoader/生成源码，不留错误继承/悬空注册。保留触及的 AW/AT/nested-JAR 最小基线，不扩成平台重做。
  4. Result 报实际变更、selectors/环境/结果及未测分支；不声称 producer 新设计或独立 Strip 完成。普通源代码/测试即产物，不需独立报告文件。
- 整体单谓词检验：对象、两个平台 adapters、必要 host/fixture 迁移与回归共同建立一个可消费的专用配置契约；单删接口/单保留 metadata 方法不能满足。其终态可供 producer 消费，故与 Strip/producer 分项，不按平台文件数另拆。

## 历史作者语义自检与联合 wait 模型

以下保留局部恢复图维护时的作者自检及待 review 描述，不是当前执行状态。随后恢复图独立审查 completed（blocking defects=0、insufficient evidence=0）已由 Router 可靠采用；当前三个指定状态仅投影 Router 的完成与 gate 判断，所有谓词、检查、owner、membership、冲突、前置和 gate requirements 不变。

- 唯一维护谓词为匹配协调文档可供受影响边界独立审查；未包含实现或自行 review。活跃四种结果仍是专用配置契约（R01）、独立 Strip（I02）、隔离 producer（I03）、真实 caller 当前结果（I04），各一 Handler/一 Result。配置契约只更换恢复身份，不增加第二配置结果；必要 migration/helpers/callers/regressions 不另造授权/发布/恢复边界。
- 真实输入依赖为 R01/I02→I03、R01/I02/I03→I04；W01 含 R01/I02，两个独立结果都必须 completed 且满足全部证据。R01→I02 仅为共享 host/fixture/测试输出的保守冲突串行，无业务 Result 前置；前项终结/交还所有权并读取当前效果后才可触及冲突面，不要求 I02 等自己所属 gate。
- 联合 wait 模型：四个活跃 items＋三个 gates；item 等显式 item prerequisites 和 containing-Wave prerequisite gates，gate 等该 Wave 全部 members。历史 I01 另核其空前置/原 W01 关联与 blocked，没有活跃入边/成员资格，不等待其“完成”。
- 可行拓扑为 {R01,I02}→W01→I03→W02→I04→W03；加入冲突串行 R01→I02 后仍无环。gate 不等自身释放，成员不等自己的 gate；W02/W03 gate 及原有保护/失败/cache 条件不删，不把历史阻断或新恢复成功自动判为 gate 满足。
- JSON 政策连接覆盖 R01 metadata、I02 config/entry-file、I03 child config/parent/refmap 与 host/entry 交接、I04 必要组合和缓存输入；只调整 Codev DOM 的语法拒绝保证，不放宽业务值或规定 engine 接受范围。9 行成功条件覆盖和实际脚本检查见 [Plan 历史作者自检记录](plan.md#历史作者自检记录)。
- 独立 review 的精确受影响边界：R01 全谓词/四组验收与旧 I01 恢复历史，W01 成员/gate，R01–I02 及 R01–I03 冲突，I03/I04 的 item 前置，R01/I02/I03 的 JSON 证据及 I04 组合连接；连同 W02/W03 的传递 gates、Plan Inputs/风险/状态和 Work/Context 授权/证据限制核对。其余三图、四种结果与未变验收不因局部变化重选。作者自检不宣告新图就绪、不执行或释放。
