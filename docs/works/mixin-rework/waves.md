# G1 Mixin Rework Waves

## 归档可访问性（清理后）

按用户要求，旧历史证据目录 `docs/works/mixin-rework/evidence/` 已整包删除，包括 `core/`、`pinned-engine/`、`g1-implementation/` 和 `g1-results.md`。其中原命令/exit/日志/XML、分窗报告、具名 ABI 输入与普通结果摘要原件均不再保留；没有另建备份、替代原件或重放包。保留本目录 Work/Context/Plan/Waves 的历史结果与执行图，以及同一 ADR 的架构决定。已采纳验收登记仍见 [Context](context.md#g1-acceptance)；该加工登记不是已删除的原实验报告或证据包，也不保证重放。

以下历史正文、JSON 图内路径/绑定及“完整保存/可读/可重验”等措辞只记录原时点，不再承诺已清理原件可访问，也不作为当前证据入口或新执行输入。已失效的 Markdown 证据链接已撤下；历史 task/generation/item/Wave、scope、状态、gate 与实际方法/失败/partial/unknown 均保留，不重置或释放。保留文档不是原件替代品，本次没有项目或 ABI/checker 重跑、没有新 G1 认证；旧已批准 G1 的 accepted/closed 仅适用旧兼容/选择性清理范围，不覆盖当前 [PRD](../../prd/codev-mixin-rework.md)（[中文](../../prd/codev-mixin-rework.zh-CN.md)）的生效（Active）目标：Codev 提供预应用 Task 与逐 JAR Strip Transform；使用者注册、接线并选择消费配置，Codev 按引擎应用通知取得清理资格，不额外核验全目标完成、无报错或最终字节码效果。键为完整 config 资源路径＋原始条目字符串，全部重复、跨数组、跨 JAR 匹配项一并删除，即使其它应用部分完成或 unknown；未通知的其它键保留。仅清单或让使用者补做 strip 不算完整清理流程；原输入不变，不扩至删除类、refmap、整个 config 或 Loader metadata。使用者决定消费者与编译/反编译/打包/运行用途，Codev 不管制用途、不代选路由、不保证任意下游兼容或安全。日志/异常承担诊断，不要求公共诊断返回、旧 Strip 兼容或独立 records 协议。当前 [Spec](../../spec/mixin-preapplication.md) 与[同一 ADR](../../adr/mixin-operation-isolation.md) 的适用说明不代表新实现或验收。Mixin 日志由用户阅读，Codev 不解析日志判定应用成功；引擎抛异常自然失败，Codev 自身 IO、原输入、资源、精确 JSON 与缓存保护仍保留。operation classloader/engine isolation 决定沿用；Task/Transform 结构及身份匹配已定，通知收集 hook/API、信息表示、发布及保存恢复/cache 机制仍未定且未实现；下方 Plan/Waves、selected/授权及 R/AC/验证编号只属旧交付时点，不是新目标执行图或验收映射。本说明仅维护当前适用事实与归档限制，不改变历史策略、图或 gate。

历史指南 `docs/guides/mixin-preapplication.md` 现已按用户要求删除；下方图内该路径及创建/指南复验要求仅保留原交付时点，不作为当前入口或执行要求。DOC-I06/DOC-W01、旧 G1 结果及产品/组件必要验证不变；当前技术入口为 [Spec](../../spec/mixin-preapplication.md)，不是旧指南原始证据。

## 唯一 selected 图：mixin-consumer-docs-r01

Owning [Work](work.md) · 加工 [Context](context.md#doc-context) · 恰一个同目录直接匹配 [Plan](plan.md)。只选本目录work.md / plan.md / waves.md；一个Doc item / 一个Wave。当前用户已选择“写完三处（建议）”，executionAuthorized=true；仅DOC-I06三处消费者写域及静态核对，DOC-I06已完整交付，Root据实际静态验证满足DOC-W01，本Doc Plan收口。

AF完成及原B-W05关闭仅为已采纳外部事实，不指向历史图执行边、不重开原I05或Native窗口。原七文件/实跑/复核绑定、Native3/3、旧失败/unknown/1114副本偏差/可信本地filesystem限制保留；消费者已交付，详情见[加工结论](context.md#doc-i06-closure)。DOC-W01只建立本Plan结果，不自动宣告完整G1/Git。

**总体产品验收登记（不新增图项）**：当前用户明确接受本轮G1结案，Root据[总体核定及接受登记](context.md#g1-acceptance)登记已批准兼容G1 accepted / closed。DOC-I06/DOC-W01保持completed/satisfied，AF已完成，不重复接受/释放旧依赖、不重开历史图；旧失败和严格审计限制保留，没有新Native或Git许可。

### selectedWavesGraph

```json
{
  "scopeId": "mixin-consumer-docs-r01",
  "work": "docs/works/mixin-rework/work.md",
  "plan": "docs/works/mixin-rework/plan.md",
  "waves": "docs/works/mixin-rework/waves.md",
  "selected": true,
  "preparationOnly": false,
  "executionAuthorized": true,
  "scopeConfirmation": "当前用户选择写完三处（建议）；仅新指南、新结果摘要、README末尾一个链接及静态核对，不改源码或规范、不运行项目、不做Git、不覆盖已有内容。",
  "authorizedItemIds": ["DOC-I06"],
  "outcome": "原G1-I06三处普通说明一致可导航；不改authority，不执行项目，不自动放行完整G1/Git。",
  "authorityRefs": [
    "docs/prd/codev-mixin-rework.md",
    "docs/adr/mixin-operation-isolation.md",
    "docs/spec/mixin-preapplication.md"
  ],
  "processedContextRef": "docs/works/mixin-rework/context.md#doc-context",
  "externalPrerequisites": [
    {
      "id": "E-DOC-AF-CLOSED",
      "state": "adopted-complete",
      "ref": "docs/works/mixin-rework/context.md#af-a02独立增量复核采纳与af-w03判断",
      "predicate": "复用Root完整采纳原I05及AF-R02/AF-A02 g1；AF三gates satisfied，F1/F2闭合/B-W05解除，七文件7/7绑定，Native3/许可3；不重审/重判gate。"
    },
    {
      "id": "D-DOC-CONFIRM",
      "state": "confirmed",
      "confirmation": "当前用户已短披露后明确选择写完三处（建议）；原三处写域/排除/静态完成条件不变。",
      "owner": "当前用户/Root",
      "predicate": "Root短披露三处写域、排除、静态完成条件和限制后取得当前明确确认；准备成功不能满足。"
    }
  ],
  "wavesGraph": [
    {
      "id": "DOC-W01",
      "itemIds": [
        "DOC-I06"
      ],
      "predecessorWaveGates": [],
      "gateState": "satisfied",
      "resultRef": "docs/works/mixin-rework/context.md#doc-i06-closure",
      "incrementalOutcome": "三处已完整交付；27本地链接、示例/API及结果来源静态核对通过，README原246-byte前缀保留。无项目运行；本Doc Plan完成，不自动宣告完整规范G1/Git。",
      "releasePredicate": "DOC-I06完整completed Result及三处一致性/本地链接/example-to-API-fixture/结果声明静态核对通过，拥有区保留；Root据证据判断，仅建立本Doc Plan结果，不自动释放历史图/G1/Git。"
    }
  ],
  "items": [
    {
      "id": "DOC-I06",
      "waveId": "DOC-W01",
      "origin": "沿历史G1-I06已接受目标重新准备，不resume历史图/许可",
      "handler": "一个implement-plan Handler，一个普通文档交付Result，不拆三文件或例子/结果摘要为独立枝。",
      "resultCount": 1,
      "planningState": "completed",
      "resultStatus": "completed",
      "task": "codev-mixin-i06-docs-delivery",
      "generation": 1,
      "resultRef": "docs/works/mixin-rework/context.md#doc-i06-closure",
      "actualVerification": "仅静态：27本地链接/5次锚点引用、三段示例/API-fixture及结果来源核对；README原246 bytes保留并追加70 bytes；当前七文件7/7绑定；无项目/示例执行、公共外链请求或Git。",
      "objective": "交付G1指南、普通真实结果摘要和README指南入口，三处一致可导航。",
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisiteIds": [
        "E-DOC-AF-CLOSED",
        "D-DOC-CONFIRM"
      ],
      "ownedProjectFiles": [
        "docs/guides/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-results.md",
        "README.md"
      ],
      "sourceRefs": [
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "docs/works/mixin-rework/context.md",
        "minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md",
        "minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/after-hashes.txt",
        "docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md"
      ],
      "scopeAndEffects": [
        "写前三目标检查；当前指南和摘要均不存在、README无G1区。缺席目标若出现内容停止，不覆盖。",
        "指南覆盖预应用→记录→selective清理、不同target/source artifact链、无mapping兼容、optional mapping tuple/refmap context、ordinary/StripMixins全删区别、task-only plugin、失败保护与兼容/拒绝边界；例子只沿当前API/既有fixture及真实provider依赖。",
        "结果摘要引用已采纳Context/可读来源：AF-R02一次native0/fresh59=50+6+3零failure-error-skip、AF-A02 g1完整采纳/F1-F2闭合/7-7绑定；原65/Forge8/Core/ABI有限证据分列，不假称新实跑、单窗全绿或完整A/AC验收。",
        "F3沿加工Context正确有限编号，不复制错误表；原failed/partial/blocked/unknown、AF-A01未确认回执、1114普通副本偏差、R14 limited/strict=false/external unknown、Ruff/fullStrictScope=false保留；可信本地filesystem身份保护不是恶意并发替换沙箱，digest不认证恶意生产者，不认证全Host/cache/卷/ACL或任意plugin副作用。",
        "仅三消费者写域（确认后），不写四协调执行状态/authority/source/config/test/旧证据；不建helper/ledger/封包，不启动项目/Git。"
      ],
      "writeOwnership": [
        "docs/guides/mixin-preapplication.md（确认后create-only，出现内容停止）",
        "docs/works/mixin-rework/evidence/g1-results.md（确认后create-only普通摘要，出现内容停止）",
        "README.md（确认后仅末尾一个G1指南Markdown链接，原文/空行逐字保留）"
      ],
      "conflicts": [
        "相同三处ordinary docs writer",
        "更改所引用source/config/test/authority/证据的writer"
      ],
      "conflictReason": "单Handler串行拥有三处；复用输入需稳定，共享只读来源不冲突。",
      "completionPredicate": "三处一致可导航消费者说明完整交付；所有例子逐属性对应当前API/fixture、真实结果对应已采纳事实/可读来源、旧失败及限制明确保留；本地链接/锚点静态核对通过，README仅一个入口追加且原文不变，无范围外写入或项目执行。",
      "verification": [
        "纯只读本地Markdown链接/锚点核对；未来目标创建后才检查其可读链接，不把当前缺席输出当refs。",
        "example-to-API/fixture及结果声明-to-加工事实静态核对；不编译示例，不运行Gradle/Java/test/caller/ABI/formatter/LSP/checker/进程查询/安装。"
      ],
      "requiredEvidence": [
        "一个中文完整Result列确切三处修改/README追加区、链接与example静态对应、真实结果来源/七文件绑定和未运行项，不新造严格账本。",
        "真实内容/权限/绑定gap报告并停止；missing/partial/failed/blocked不满足完成，不扩域或覆写。"
      ]
    }
  ]
}
```

## 以下为已完成AF图与原时点记录（historicalAFGraph，非 selected）

> 原ID/state/predicate/验证/许可与限制保留，旧selected/待验证措辞仅属历史；原JSON内容不改，fence用text隔离，不作新可执行图/消费者权限。

## 唯一 selected 图：mixin-audit-f1-f2-r01

> **当前修复与独立复核已完成**：AF-R02一次native exit0、fresh59=Mixins50+Fabric6+Forge metadata3且零failure/error/skip；累计Native3/许可3，不再运行项目。Root完整读取并关联codev-mixin-af-a02-incremental-review generation1的完整15797-byte Result：F1、F2闭合，无新blocking findings；2026-10-12T15:49:58Z七文件SHA-256与R02 after-hashes全部一致。Root满足AF-W03，AF-W01/02/03共同完成当前有限修复Plan；并明确以原I05报告＋这次增量关闭原B-W05的F1/F2挂起，非仅凭报告completed自动接受。F3沿已接受正确有限编号，旧表/报告不覆盖；原failed/unknown、1114副本偏差及可信本地/Windows限制保留。消费者说明尚未交付，完整G1/I06/Git不自动放行。详情见[加工结论](context.md#af-a02独立增量复核采纳与af-w03判断)。

> **历史AF-V03失败时点（本次单行修复确认之前）**：参数回显通过；此次唯一外层native exit1，累计2/2、尚余0。Mixins fresh 8 suites/50 cases：41通过、9 failures、0 errors/skips；均报OperationPublication.publish输入Projects缺失。Mixin完整check、Fabric6、Forge metadata3及P01/P02完整链未到达。F2字段变异/合法untouched=false与library输入保护已有fresh通过，但不释放整体验收。七源码候选在执行窗未改。新增1114普通副本未逐件证明必要性，属于已保存执行偏差；不宣称合规或全Host保全。AF-W02/03未满足，AF-A01/消费者说明/G1/Git仍阻断；只读定位已完成：Mixin.kt:98裸+Path把完整输入拆为相对片段；最小纠正为+listOf(Path)，未实施、未补验。gates与停止边界保持。

> **历史AF-V03补验许可（原确认时点）**：用户选择“补验一次”。先在自有临时目录进行有界参数回显（不启动Gradle/Java、不造helper框架），通过后原命令最多追加1次。总额度2，实际已用1，尚余1；原任务/七文件候选只读/环境与缓存边界不变。AF-V03是独立新Result；AF-V01 blocked、AF-V02 failed及旧流保留，新失败保存停止、不自动重试。AF-W02/03未满足，AF-A01/消费者说明/完整G1/Git不放行。

> **历史AF-V02失败时点（本次增量确认前）**：实际原生1次/exit1，额度已用1/许可1。Windows引号传递偏差导致daemon启动失败，全部所选tests未到达、fresh XML/cases为0（不是零失败通过）。F1/F2仍未实跑关闭，AF-W02未满足、AF-A01未启动；已保存并停止，没有追加运行授权。以下AF-V01 Native0是旧启动前时点。

> 历史AF-V01 generation1语义blocked（启动前版本误绑定），实际Native0/1，原启动日志保留。现按C5将未完成验证细化为AF-V02，原命令/52基线+新增/恢复/停点不变；外层保持现有wrapper9.4.0，内部TestKit保持既有配置，不改wrapper或安装。旧blocked不回写成功，新Result独立判断AF-W02。

Owning [Work](work.md) · 加工 [Context](context.md) · 恰一个同目录直接匹配 [Plan](plan.md)。selected tuple仍为docs/works/mixin-rework/{work,plan,waves}.md。AF-I01/AF-I02原源码ready前置、AF-R02完整completed与AF-W02已接受；累计Native3/许可3，AF-A02只读前置具备，AF-W03未满足，消费者说明/完整G1/Git不放行。

AF-I01/F1候选 → AF-I02/F2候选（共写MixinInputBindingTests强制串行）→ AF-R02/单行恢复与一次共享验证 → AF-A01/成功后独立只读增量复核。仅三必要Wave：AF-W01两源码ready、AF-W02真实回归、AF-W03增量复核。每item单Handler/Result，候选ready不宣称实跑通过，不加fields/parsing/receipt或规划审阅节点。

Root已完整关联原I05与两个作者gen1前置、新R02完整实跑及AF-A02 generation1完整独立增量报告；加工结论见Context。原B-W05未满足为审计发现时点；Root现明确以原审计＋已验证并独立复核的修复解除F1/F2阻断。AF-W03满足，当前有限Plan完成；消费者文档尚未交付，完整G1/I06/Git仍不自动放行。

### historicalAFGraph

```text
{
  "scopeId": "mixin-audit-f1-f2-r01",
  "historicalItems": [{"id":"AF-V01","planningState":"blocked","resultStatus":"blocked","task":"codev-mixin-af-v01-affected-regression","generation":1,"resultRef":"minecraft-codev-mixins/build/f1-f2-verification/startup.txt","nativeRuns":0,"originalCompletionPredicate":"唯一外层native exit0且三个选定task实际到达，改后fresh XML基线52+实际新增cases无failure/error/skip；真实F1先拒绝与输入/旧合法输出保护、F2字段变异拒绝及合法untouched=false、现有P01/P02/42行为/平台reopen均成立，新pair对应当前implementation，必要旧实物保留及finally完成。缺项不completed，不自动重试。","successorItem":"AF-V02","limitation":"启动前误把外层wrapper记录为7.6；无Gradle启动/fresh XML/原生exit，旧Result不改绿。新Result仅建立当前细化验证谓词。"},{"id":"AF-V02","planningState":"failed","resultStatus":"failed","task":"codev-mixin-af-v02-affected-regression","generation":1,"nativeRuns":1,"nativeExit":1,"resultRef":"minecraft-codev-mixins/build/f1-f2-verification/v02-20261012T-affected-regression/native-v02.txt","originalCompletionPredicate":"唯一外层native exit0且三个选定task实际到达，改后fresh XML基线52+实际新增cases无failure/error/skip；真实F1先拒绝与输入/旧合法输出保护、F2字段变异拒绝及合法untouched=false、现有P01/P02/42行为/平台reopen均成立，新pair对应当前implementation，必要旧实物保留及finally完成。缺项不completed，不自动重试。","successorItem":"AF-V03","limitation":"我方Windows引号偏差令daemon启动失败，全部tests/fresh XML未到达；旧failed不改绿。补验仅由当前用户增量确认释放。"},{"id":"AF-V03","planningState":"failed","resultStatus":"failed","task":"codev-mixin-af-v03-argv-and-regression","generation":1,"nativeRuns":1,"nativeExit":1,"resultRef":"minecraft-codev-mixins/build/f1-f2-verification/v03-20261012T105203Z-affected-regression/verification-v03.txt","originalCompletionPredicate":"参数回显完整保留原argv/单项JVM属性、没有多余quote，随后此次唯一外层native exit0且三个选定task实际到达，改后fresh XML基线52+实际新增cases无failure/error/skip；真实F1先拒绝与输入/旧合法输出保护、F2字段变异拒绝及合法untouched=false、现有P01/P02/42行为/平台reopen均成立，新pair对应当前implementation，必要旧实物保留及finally完成。缺项不completed，不自动重试。","successorItem":"AF-R01","limitation":"参数回显通过，Mixins50项9失败，平台及完整cache链未到达；一行Path包装只读核定，原failed/1114副本偏差不改绿。"},{"id":"AF-R01","planningState":"failed","resultStatus":"failed","task":"codev-mixin-af-r01-path-wrapper-regression","generation":1,"nativeRuns":0,"resultRef":"minecraft-codev-mixins/build/f1-f2-verification/af-r01-20261012T122017Z-preparation-failure/preparation-failure.txt","originalCompletionPredicate":"只有Mixin.kt已核定单行差异，其余六源/test不改；复用已核对启动器原命令此次至多1次native exit0且三个task实际到达，fresh XML原52基线加实际新增cases无failure/error/skip；F1全部现有task输入角色/输出slot身份负例及合法缺父目录/重跑，F2字段变异拒绝/合法untouched=false，P01/P02新SUCCESS→pair FROM_CACHE→fresh consumer SUCCESS及42/1/Unused，平台闭合reopen/new implementation records成立；具名旧失败XML/log保留、finally完整。不得用旧41通过补绿，任何缺项/失败停止，不自动重试。","successorItem":"AF-R02","limitation":"准备搜索误传Windows未展开glob给rg导致os error123；源码/Gradle/Java均0，仅普通失败日志，无XML覆盖/备份；原单行及剩余一次授权内纠正接续，failed不改绿。"},{"id":"AF-A01","planningState":"launch-status-unconfirmed","task":"codev-mixin-af-a01-independent-incremental-review","dispatchError":"result_projection_failed","adoptedResult":false,"originalCompletionPredicate":"独立只读增量报告完整交付，具体关联这批diff与新证据、F1/F2处置、回归/安全/证据缺口及限制；报告完成可带findings，只有无未处置重大缺陷才满足AF-W03。","successorItem":"AF-A02","limitation":"原startup taskSlug长度49超过允许48；启动/inspect投影失败，当前parent任务目录无该记录只是有限负证据，不能证明零启动。未采纳原Handler Result。新调用修正启动标识，只恢复同一尚未交付的只读review；无代码/产物/进程effects授权、无项目重跑，历史未确认状态保留。"}],
  "work": "docs/works/mixin-rework/work.md",
  "plan": "docs/works/mixin-rework/plan.md",
  "waves": "docs/works/mixin-rework/waves.md",
  "selected": true,
  "scopeConfirmation": "当前用户原七文件修复范围已确认；最新明确选择“修一行并补验一次（建议）”：只Mixin.kt裸Path包装一处，不加tests，复用已核对启动器，原命令最多再1次（实际2/总许可3），原输出/环境/cache边界不变，只具名失败XML/log保留，无泛化备份，任何新失败保存停止。",
  "executionAuthorized": true,
  "authorizedItemIds": [
    "AF-I01",
    "AF-I02",
    "AF-R02",
    "AF-A02"
  ],
  "outcome": "F1输入保护与F2记录自洽恢复，改后一次共享回归完整通过且独立增量复核无未处置阻断；不等于完整G1/消费者说明/Git放行。",
  "preparationBoundary": "AF-R02完整g1 completed已读取关联；原命令一次native exit0及fresh59/功能-cache-平台-finally事实齐备，Root满足AF-W02，仅释放AF-A02只读增量复核。实际Native3/许可3，禁止再项目运行；历史原失败与1114副本偏差保留。",
  "authorityRefs": [
    "docs/prd/codev-mixin-rework.md",
    "docs/adr/mixin-operation-isolation.md",
    "docs/spec/mixin-preapplication.md"
  ],
  "processedContextRef": "docs/works/mixin-rework/context.md#当前加工事实mixin-audit-f1-f2-r01",
  "historicalGraph": "historicalLayeredB01Graph与historicalWavesGraph仅历史；B-W05 not-satisfied-blocking-F1-F2不是新图入场前置。",
  "externalPrerequisites": [
    {
      "id": "E-AF-AUDIT-G1",
      "state": "completed-report-adopted-gate-blocked-F1-F2",
      "task": "codev-mixin-i05-independent-audit",
      "generation": 1,
      "predicate": "Root已完整读取/解码并关联generation1，接受审计报告完成而非无缺陷；F1/F2静态路径未实跑复现，F3正确有限编号见Context加工事实。"
    },
    {
      "id": "E-AF-SCOPE-G1",
      "state": "completed-scope-adopted",
      "task": "codev-mixin-audit-fix-scope",
      "generation": 1,
      "predicate": "Root已完整读取/解码并关联generation1最小七文件/一次验证范围；报告自身不证明修复或运行，当前授权由D-AF-SCOPE提供。"
    },
    {
      "id": "D-AF-SCOPE",
      "state": "confirmed",
      "owner": "当前用户/Router",
      "predicate": "当前用户选择修一行并补验一次：只改Mixin.kt + input.toPath()为+ listOf(input.toPath())；不新增测试，复用已核对启动器，原命令再至多1次，总许可3/已用2；原任务/输出/环境/cache边界及新失败保存停止保持，只具名失败XML/log保留，无泛化备份。"
    }
  ],
  "outputBoundary": {
    "sourceOrTestFiles": [
      "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationPublication.java",
      "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
      "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt",
      "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/OperationPublicationTests.java",
      "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
      "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
      "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java"
    ],
    "sourceAuthorsNativeRuns": 0,
    "nativeVerificationLimit": 3,
    "nativeVerificationRunsUsed": 3,
    "scope": "仅所选任务图的classes/libs/plugin metadata/lint/XML/reports、对应项目.gradle与依赖编译、继承Gradle home的外层现有wrapper9.4.0及既有内部TestKit配置对应cache/daemon/TestKit正常效果；不是全build/cache/Temp任意权限。",
    "fixtureAndLogOwners": [
      "minecraft-codev-mixins/build/fixture-evidence/",
      "minecraft-codev-fabric/build/platform-fixtures/",
      "minecraft-codev-forge/build/platform-fixtures/",
      "minecraft-codev-mixins/build/f1-f2-verification/（自有logs/temp/必要旧生成证据普通副本）"
    ],
    "protection": "原审计/ABI/失败Result和原生流不改。只按名称保留将覆盖的AF-V03八个fresh XML及现有失败日志，禁止复制fixture树/锁/classes/JAR/旧产物或泛化备份；复用已核对启动方式及argv/环境逻辑，仅允许自有新日志目标/运行标识的数据参数化；无新增参数实验/helper框架/安装/配置/证据平台。",
    "onStop": "实际编译/测试/check新失败-error-skip、junction建立/解除失败、必要工具链/依赖缺失、额外属性或写域缺口：保存停止，不重试/扩跑/安装/清cache/升权。普通只读查询路径/glob/参数表示错误保留后在原范围纠正，不重复审批；禁止传未展开Windows路径glob给rg。",
    "readonlyAuditLimit": 1,
    "readonlyAuditRunsUsed": 0,
    "currentRepairSourceFiles": [
      "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt"
    ]
  },
  "wavesGraph": [
    {
      "id": "AF-W01",
      "itemIds": [
        "AF-I01",
        "AF-I02"
      ],
      "predecessorWaveGates": [],
      "gateState": "satisfied",
      "resultRef": "docs/works/mixin-rework/context.md#af-i02源码候选采纳与af-w01判断",
      "incrementalOutcome": "两个修复及必需tests源码候选就绪，未宣称实跑关闭F1/F2。",
      "releasePredicate": "AF-I01及AF-I02各一个完整completed Result且源代码就绪证据成立，授权/七文件拥有范围一致；只释放显式共享验证前置，不把作者static检查当JUnit通过。"
    },
    {
      "id": "AF-W02",
      "itemIds": [
        "AF-R02"
      ],
      "predecessorWaveGates": [
        "AF-W01"
      ],
      "gateState": "satisfied",
      "resultRef": "minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md",
      "incrementalOutcome": "改后同一候选输入的一次受影响回归完整通过。",
      "releasePredicate": "AF-R02完整completed Result：唯一外层native exit0，所选52基线场景加实际新增cases均无failure/error/skip，fresh XML/真实负例和正例、新implementation records及finally完整；不是旧65/ABI重跑或全G1。"
    },
    {
      "id": "AF-W03",
      "itemIds": [
        "AF-A02"
      ],
      "predecessorWaveGates": [
        "AF-W02"
      ],
"gateState": "satisfied",
"resultRef": "docs/works/mixin-rework/context.md#af-a02独立增量复核采纳与af-w03判断",
"incrementalOutcome": "独立只读增量复核支持本scope恢复结论；F1/F2闭合，无新blocking findings。",
      "releasePredicate": "AF-A02完整completed独立报告与改动/新证据相符，无未处置重大正确性/安全/证据缺陷；有报告但有阻断不满足gate。AF-W01/02/03共同建立本Plan结果；不自动改B-W05或释放历史W03/消费者说明/完整G1/I06/Git。"
    }
  ],
  "items": [
    {
      "id": "AF-I01",
      "waveId": "AF-W01",
      "handler": "一个implement-change Handler，一个Result；F1候选及必需tests是同一源码就绪outcome。",
      "resultCount": 1,
      "planningState": "completed",
      "resultStatus": "completed",
      "resultRef": "docs/works/mixin-rework/context.md#af-i01源码候选采纳",
      "objective": "共享publication在任何旧结果删除/创建/替换前统一真实输入身份保护，两个task完整接线，产出F1及tests候选。",
      "authorityRefs": [
        "docs/spec/mixin-preapplication.md#c1-compatible-entry-points-and-owned-data",
        "docs/spec/mixin-preapplication.md#c3-gradle-visible-inputs-and-publication"
      ],
      "contextRefs": [
        "docs/works/mixin-rework/context.md#f1输入保护候选边界"
      ],
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisiteIds": [
        "E-AF-AUDIT-G1",
        "E-AF-SCOPE-G1",
        "D-AF-SCOPE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationPublication.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/OperationPublicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java"
      ],
      "scopeAndEffects": [
        "OperationPublication内保留publish(List<Path>, Writer)原入口；新增带受保护已有inputs的入口/必要私有路径逻辑，不建新helper。全部输出采用同一真实父目录/已有祖先+不存在后缀解析，已有文件用Files.isSameFile，目录输入保护真实包含关系；解析失败抛错，不退回字符串。",
        "Mixin传runtime+sources+inputFile+已配置mapping，检查target/records二输出；StripAppliedMixins传source/records/transformed/original+classpath+mixinFiles+已配置mapping。顺序/binding/cache/API保持。",
        "删除前拒绝必须writer未进入且输入及其它已有合法输出/pair不变；取得所有权后的writer失败/取消/second-move沿原失效/close/lock-marker语义，不恢复陈旧成功。tests覆盖两个task真实父目录junction各输入角色、existing-file hardlink、目录输入包含/合法相邻与相同basename或内容不同file、合法不存在父目录/重跑；原failure/cancel/collision/retry断言保留。",
        "Windows tests只写其自有root，cmd.exe /d /c mklink /J与JDK Files.createLink；finally先cmd.exe /d /c rmdir自有alias无/s再安全清理；创建/解除失败是failure不能skip、升权或跟进真实target。这里只写cases，不现场实验。"
      ],
      "completionPredicate": "五个owned文件内F1共享边界/完整task输入与必需cases源码候选齐备，局部只读核对原API/失败保护及调用接线一致，无范围外改动；明确Native0且未证明tests通过或F1实跑关闭。",
      "verification": [
        "仅候选源码/测试断言和接线定点只读核对；不跑Gradle/Java/tests/checker/LSP analyzer/实验。真实证明统一归AF-V03。"
      ],
      "requiredEvidence": [
        "Result逐文件实际diff/共享guard在破坏性动作前的位置、完整输入角色接线、必需负例及合法输出正例断言关联；保留原failure/cancel/ownership语义，未检查项/风险据实。",
        "一个completed只表示source-ready；任何未完成/范围变化返回非成功，不自动扩源或开native窗。"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationPublication.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/OperationPublicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java"
      ],
      "conflicts": [
        "AF-I02",
        "AF-R01",
        "AF-A01"
      ],
      "conflictReason": "与AF-I02共写MixinInputBindingTests，必须先AF-I01后AF-I02；验证/审阅要求同一候选输入无并行writer。"
    },
    {
      "id": "AF-I02",
      "waveId": "AF-W01",
      "handler": "一个implement-change Handler，一个Result；F2候选及必需tests是同一源码就绪outcome。",
      "resultCount": 1,
      "planningState": "completed",
      "resultStatus": "completed",
      "resultRef": "docs/works/mixin-rework/context.md#af-i02源码候选采纳与af-w01判断",
      "objective": "consumer先校验整份operation entry完成字段自洽再选择source/remove，拒绝矛盾success且保留合法untouched=false，产出F2及tests候选。",
      "authorityRefs": [
        "docs/spec/mixin-preapplication.md#c4-application-evidence-and-completeness",
        "docs/spec/mixin-preapplication.md#c5-selective-json-cleanup-and-runtime-safety"
      ],
      "contextRefs": [
        "docs/works/mixin-rework/context.md#f2完成记录候选边界"
      ],
      "prerequisiteItemIds": [
        "AF-I01"
      ],
      "prerequisiteWaveGates": [],
      "externalPrerequisiteIds": [
        "D-AF-SCOPE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java"
      ],
      "scopeAndEffects": [
        "现有entry循环在source-matching continue及rewrites/remove之前校验：success obligationsComplete必须真实JSON Boolean true，S非空且S=T=N=D，nativeTargets/nativeDeclaredTargets合法无重复字符串数组；provisional存在/类型合法且与S一致，保留failures空及非dynamic。适用两个clean入口；不改schema3/producer/engine/SPI。",
        "untouched保持独立分支、successes空及原inactive空贡献检查；Boolean false合法，active未访问T非空而N/D空或inactive全空不由空数组相等推断完成。不得把provisional本身提升为成功。",
        "在当前implementation生成真实Good/Unused pair后分别变异flag缺失/false/null/非Boolean、两个native数组分别缺失/空/不同/额外/非字符串/重复、provisional缺失/矛盾；拒绝无新published cleaned artifact，消费前后输入不变。正常Good、active未访问/side-excluded/inactive untouched=false仍保留entry/config/refmap/class/resources/未知字段。原partial/dynamic、多target和失败负例保留。",
        "共享MixinInputBindingTests在AF-I01完成后编辑，保全F1候选；F2无效证据进入writer后按原publication失效旧cleaned，不承诺恢复旧cleaned，不混同F1删除前拒绝语义。"
      ],
      "completionPredicate": "三个owned文件内F2校验及真实pair变异/合法untouched正例源码齐备，局部只读核对字段生产形态/整份校验顺序和F1共享tests保全，无范围外改动；明确Native0且未证明F2实跑关闭。",
      "verification": [
        "只读候选代码/断言核对，不运行项目、生成pair或现场变异；改后真实pair及所有cases由AF-V03一次运行生成。"
      ],
      "requiredEvidence": [
        "Result实际consumer/test diff、各字段变异与拒绝/无新成功输出断言、untouched=false正例及F1共享tests保全；原binding/digest与ordinary optional语义不减。",
        "不以旧implementation records当改后有效正例；source-ready不是JUnit通过，实际覆盖数待新XML。"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java"
      ],
      "conflicts": [
        "AF-I01",
        "AF-R01",
        "AF-A01"
      ],
      "conflictReason": "共享MixinInputBindingTests，显式依赖AF-I01串行；其它验证/复核需输入稳定。"
    },
    {
      "id": "AF-R02",
      "waveId": "AF-W02",
      "handler": "一个implement-plan Handler，一个单行修复并验证Result；复用已核对启动器，原命令最多一次，不另做源码候选/扩修/审计/续跑。",
      "resultCount": 1,
      "planningState": "completed",
      "resultStatus": "completed",
      "nativeRuns": 1,
      "nativeExit": 0,
      "freshCases": 59,
      "resultRef": "minecraft-codev-mixins/build/f1-f2-verification/af-r02-20261012T123108Z-path-regression/verification.md",
      "objective": "将Mixin.kt裸+ input.toPath()改为+ listOf(input.toPath())保留完整输入身份，完成原受影响回归一次，保持现有功能/安全/缓存/平台全部验收断言。",
      "authorityRefs": [
        "docs/prd/codev-mixin-rework.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/spec/mixin-preapplication.md"
      ],
      "contextRefs": [
        "docs/works/mixin-rework/context.md#授权效果与证据新鲜度",
        "docs/works/mixin-rework/context.md#一行producer-path追加修复授权"
      ],
      "prerequisiteItemIds": [
        "AF-I01",
        "AF-I02"
      ],
      "prerequisiteWaveGates": [
        "AF-W01"
      ],
      "externalPrerequisiteIds": [
        "D-AF-SCOPE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt"
      ],
      "scopeAndEffects": [
        "源码唯一允许变动为Mixin.kt:98单个Path追加包装；其余六源码/测试、authority、build/依赖不改；复用已核对driver传递代码及原argv/环境，只允许新日志目标/运行标识的数据参数化，不加tests/helper框架或规避guard。",
        "cwd E:/Projects/cloche/minecraft-codev；唯一外层调用Mixins完整check（无filter）+FabricApplicabilityRepairTests六case+ForgeMixinMetadataTests三case，原43+6+3=52基线加实际新增JUnit；不跑Forge patched八/Core vanilla/ABI/全65。",
        "child JAVA_HOME与PATH前置D:/Applications/Scoop/apps/microsoft17-jdk/current及bin；JAVA_TOOL_OPTIONS=-Djava.io.tmpdir=E:/Projects/cloche/minecraft-codev/minecraft-codev-mixins/build/f1-f2-verification/temp；child移除冲突JDK_JAVA_OPTIONS/_JAVA_OPTIONS，父环境不改，GRADLE_USER_HOME继承。外层保持现有wrapper9.4.0；内部TestKit保持既有配置、编译11、所选test17/heap3G；不预写TestKit属性，额外属性需求停止。",
        "所选任务图正常依赖编译/metadata/lint/XML/reports和有限cache效果按outputBoundary；外层--no-build-cache不取消已有TestKit内部--build-cache。保留warm SUCCESS→pair FROM_CACHE→first fresh consumer SUCCESS、实际target42/original1/Unused保留；新implementation records重新生成。",
        "现有publication自有Java child终止/重试与TestKit内部build是原tests的一部分，不是Host进程管理/额外外层窗口。Windows junction/hardlink负例必须实际执行且finally先解除alias；建立/清理失败不能skip。普通流/XML/失败结果保存，自有handles关闭/temp安全清理，不扫描/杀Host或清cache。"
      ],
      "completionPredicate": "只有Mixin.kt已核定单行差异，其余六源/test不改；复用已核对启动器原命令此次至多1次native exit0且三个task实际到达，fresh XML原52基线加实际新增cases无failure/error/skip；F1全部现有task输入角色/输出slot身份负例及合法缺父目录/重跑，F2字段变异拒绝/合法untouched=false，P01/P02新SUCCESS→pair FROM_CACHE→fresh consumer SUCCESS及42/1/Unused，平台闭合reopen/new implementation records成立；具名旧失败XML/log保留、finally完整。不得用旧41通过补绿，任何缺项/失败停止，不自动重试。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:test --tests 'net.msrandom.minecraftcodev.fabric.mixin.FabricApplicabilityRepairTests' :minecraft-codev-forge:test --tests 'net.msrandom.minecraftcodev.forge.mixin.ForgeMixinMetadataTests' --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --configuration-cache --stacktrace --console=plain '-Dorg.gradle.java.home=D:/Applications/Scoop/apps/microsoft17-jdk/current' '-Dorg.gradle.jvmargs=-Xmx3G -Djava.io.tmpdir=E:/Projects/cloche/minecraft-codev/minecraft-codev-mixins/build/f1-f2-verification/temp'"
      ],
      "requiredEvidence": [
        "唯一生产单行差异/其它六源与tests未改；按名称保留AF-V03八个fresh XML，无泛化备份；Native由2到至多3。",
        "完整实际logical/launch argv、cwd、UTC起止、native exit与原始stdout/stderr；fresh三个模块JUnit/XML真实case数量/无failure-error-skip、check/lint/plugin validation task事实。",
        "新增cases真实junction/hardlink创建与解除结果、输入保护及无新成功artifact、正常Good/Unused与平台closed JAR/metadata、P01/P02新TestKit outcomes和implementation binding关联；不能只exit0或旧绿/XML。",
        "有界正常输出、必要旧生成证据保留、父env未改/自有child-handle finally与任何写域/工具/失败缺口如实；只普通logs/temp/XML/fixture，无manifest/checker/新证据平台。"
      ],
      "writeOwnership": [
        "只有Mixin.kt单行、outputBoundary正常任务生成输出、自有f1-f2-verification新普通logs/temp及按名称保留的8个旧失败XML；其它source/test/config/authority/旧Result/原审计/ABI/Git只读。"
      ],
      "conflicts": [
        "AF-I01",
        "AF-I02",
        "AF-A01"
      ],
      "conflictReason": "验证使用同一最终七文件候选/相关依赖与生成证据；排他source/test/config/产物/Git writer。"
    },
    {
      "id": "AF-A02",
      "waveId": "AF-W03",
      "handler": "一个独立review-correctness Handler，一个只读增量复核Result；不由修复作者自评替代。",
      "resultCount": 1,
      "planningState": "completed",
      "resultStatus": "completed",
      "acceptedResultRef": "docs/works/mixin-rework/context.md#af-a02独立增量复核采纳与af-w03判断",
      "recoveryOf": "AF-A01",
      "dispatchState": "completed",
      "task": "codev-mixin-af-a02-incremental-review",
      "generation": 1,
      "startedAt": "2026-10-12T15:32:15.430Z",
      "objective": "成功后只读复核七文件实际diff及这一次新受影响证据，判断F1/F2恢复及新增阻断/证据缺口。",
      "authorityRefs": [
        "docs/prd/codev-mixin-rework.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/spec/mixin-preapplication.md"
      ],
      "contextRefs": [
        "docs/works/mixin-rework/context.md#当前加工事实mixin-audit-f1-f2-r01"
      ],
      "prerequisiteItemIds": [
        "AF-R02"
      ],
      "prerequisiteWaveGates": [
        "AF-W02"
      ],
      "externalPrerequisiteIds": [
        "D-AF-SCOPE"
      ],
      "ownedProjectFiles": [],
      "scopeAndEffects": [
        "只读这批改动、必要相连caller/原契约、新完整Native Result及实际XML/logs/records/closed产物；不重跑B-AUDIT-01或旧审计/门禁/ABI，不研究全仓。",
        "核对F1删除前统一真实身份/全部inputs/目录/hardlink保护和失败语义；F2全operation success完成链/合法untouched/当前implementation records；核对真实新负例、受影响平台与finally证据，不以原65覆盖新增路径。",
        "复用Context中正确有限A/AC关系supersede原表；旧statuses/报告不写回，消费者说明/完整G1/Git仍不自动放行。"
      ],
      "completionPredicate": "独立只读增量报告完整交付，具体关联这批diff与新证据、F1/F2处置、回归/安全/证据缺口及限制；报告完成可带findings，只有无未处置重大缺陷才满足AF-W03。",
      "verification": [
        "一次只读代码/新证据交叉核对；不运行Gradle/Java/test/caller/checker/LSP analyzer/实验或进程/cache扫描。"
      ],
      "requiredEvidence": [
        "中文完整独立Result：审阅的七文件及新验证scope/实际native/cases关联，F1/F2关闭或仍阻断的证据与具体位置，未检查项/历史复用限制。",
        "禁止凭通知摘要/admission/UI放行；Router完整读取并关联该Result，分别判断报告交付与AF-W03 gate。"
      ],
      "writeOwnership": [],
      "conflicts": [
        "AF-I01",
        "AF-I02",
        "AF-R02"
      ],
      "conflictReason": "只读复核输入必须稳定；共享只读authority不冲突，不与任何source/test/证据writer并行。"
    }
  ]
}
```

## 历史 B01 图与记录（historicalLayeredB01Graph，非 selected）

> 下方B01原six items/gates/结果/授权保留原时点；旧selected称谓只为历史，fence改text防误选而JSON内容不变。历史external Result locators不参与本scope continuing dependency；B-W05阻断不回写green、不作修复前置。更下方historicalWavesGraph/R13亦仅历史。

## 历史已选图：mixin-layered-b01（非 selected）

B-W01 段结果（保留该段时点）：B-I01/B-I02 的 generation1 完整 Result 均已读取并与本段确认关联。I01 删除唯一重复类、强 suite 不改，一次 focused native exit0、fresh 6/6；I02 新增同一真实 JAR 双位置 metadata/selective reopen 用例、原两用例不改，一次 focused native exit0、fresh 3/3。两次均零失败/错误/跳过，窗口串行且已结束；真实 records、closed JAR、保留项及各自 source 不变证据支持本段 predicate。Router 据此仅满足 B-W01 gate，不释放 B-W02/03/04、完整 R13/G1/I05/I06/Git。原始 warnings、I01 补充只读判定失败及其它历史限制保留；不声称全缓存/全 Host 保全。

Owning [Work](work.md) · [Context](context.md) · 恰一个匹配 [Plan](plan.md)。selected tuple 为 E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/{work,plan,waves}.md 的直接unsliced文件；本页selectedWavesGraph只编制候选，不是admission、scope确认、runtime ready或gate回执。

原统一窗确认（原许可时点，g1失败保留）：恢复B-I04独立fresh Core JAR/原三caller/ABI，成功后串行B-I05唯一五模块check，共用该窗验证B-I03的一行修正，不追加focused。B-W01已有限满足；B-I03 g2原native exit1/2 failures及g3 partial/离线修正保持原状态，B-W02在共享新原生证据齐备前不释放。B-I05入场依赖修正输入ready与B-I04/B-W03，而不是等待自己将验证的B-W02，最终完成仍须真Java8/全部A/AC等原条件。仅既定生成子域/B-I04与B-I05普通日志/受限child-temp-TestKit属性及finally；不修源码/依赖/规范、清cache/安装/扩权、旧封包重跑、自动重试或执行I05/I06/Git。下方初次准备说明保留其原时点；当前scope以本节和图为准。

当前验收结果：B-I04 g1完整completed Result已读取关联，独立Core与三caller各一次native exit0及完整ABI/metadata/debug条件支持，B-W03有限满足。B-I05 g1完整failed Result已读取关联，唯一五check native exit1，Forge两个测试文件四处ktlint Missing { ... }；Mixins43/43、Fabric8/8本窗fresh零失败/错误/跳过，Forge/Core/Includes test/check未到达；原两流已保存、handles结束、generated属性精确恢复。原单次组合窗已用完，不自动修源码或重试；B-I03/B-W02及B-W04未满足，完整R13/G1/I05/I06/Git未放行。新增四处格式修正及续验范围尚待确认，未执行。

当前新增确认：用户选择“修四处并补三模块（建议）”。B-I05续行仅允许ForgeMixinMetadataTests.kt与PatchedMinecraftTests.kt各两处分支花括号格式修正，不删断言、不改逻辑；随后一次Forge/Core/Includes check，原参数不变，不重跑Mixins/Fabric测试、ABI或focused。同一交付输入与实物闭合成立才复用g1 Mixins43/43和Fabric8/8，完整五模块及A/AC/P01/P02验收由两窗口组成；原五check exit1永久保留。只读完整消费旧51测试的source/TestKit/closed产物；任何复用缺口/新的native失败保存恢复后停。新普通日志限原B-I05 namespace下continuation-02/，原stdout/stderr/runtime/native与SDK失败Result不覆盖；受限temp仍原runtime/temp，效果不扩cache/Temp。本次完整续行failed Result已读取关联：四brace恰为两处if/else区块，各分支仅加括号，原逻辑/断言/g3解码不变；唯一三check native exit1，Includes四main文件八条逗号/换行/缩进ktlint失败。Forge fresh11/11及Core fresh3/3零失败/错误/跳过，两模块check成功，Includes:test/validatePlugins/check未到达。父env/110局部必要输入前后不变、两流和finally保存、generated属性精确恢复；旧51测试未重跑，其XML保留仅有限支持，完整source/TestKit/closed产物及ABI复用最终消费未完成。旧五check及旧失败不回写，B-W02/04未满足；该增量次数已用完，Includes源码修正与新运行尚未授权。

当前唯一新增许可：用户选择“修格式并收尾（建议）”。仅Includes四个main文件处理continuation-02报告的八条逗号/换行/缩进问题；一次Includes check，原参数，之后只读消费既有65测试/实际Forge8/Core3/A/AC/P01/P02/ABI。旧两次exit1及failed/partial不改绿，旧65与ABI不重跑；任何新失败/reusegap保存后停。新普通日志仅原B-I05/continuation-03/，原runtime/temp与有界正常输出/finally不扩域；无全仓format/逻辑修复/lint豁免/安装/清cache/审计/Git。Root已完整读取codev-b-i05-includes-format-closeout generation1完整completed Result及continuation-03/verification.md。Includes唯一native exit0，编译/ktlint/validatePlugins/check完成，test如实NO-SOURCE；原四模块成功check与65 tests零失败/错误/跳过按原窗/source/TestKit/closed实物关联，全部12对A/AC、P01/P02、实际Forge8、Core四闭包负例、I04当前158class+1kotlin_module bytes关联及finally支持。Root据此接受B-W02/B-W04，B-W01/B-W03继续满足；本scope收尾完成、不追加native。三条既有auxiliary warnings、准备/读取错误和全部旧failed/partial/unknown保留；旧两条exit1与旧R13 failed/R14 limited/strict=false/external unknown/Ruff限制不回写，不自动释放历史W03/完整G1/I05/I06/Git。下方图记录当前接受结果，前述各scope/结果保留其时点。

图只引用当前items/gates/外部决定；executionAuthorized仅对应authorizedItemIds，不授权其余图项。该记录是当前用户决定的派生显示，不是admission或通过证据。partial/failed/blocked/缺失Result不释放显式dependents；Router完整读取并关联Result后独立判断，不由文档/UI/writer释放。共享native/Gradle验证串行，不从历史completed或旧run01许可继承当前入场。


### B-I03 方法说明校正（沿用当前确认，非运行或 gate 结果）

直接使用原 `compileJava` 的 CLI 分支：必需 `fixtureJava8Javac` 经受限 outer child 的 `CODEV_TEST_JAVAC8` 传给原 nested invocation；`fork=true`、指定 executable、不设置 javaHome，`forkOptions.jvmArgs=[-J-showversion,-J-Duser.language=en]`，`verbose=true/incremental=false/failOnError=true`。保留 `jar/printCompileClasspath/-s/--rerun-tasks`，增加 `--info/--console=plain/--no-build-cache/--no-parallel/-PfixtureJava8Javac`；outer/test 保持17，不对 debug TestKit 使用 withEnvironment。逐 fixture 的实际8版本、原 Test.java 解析、本次 wrote、原 patched/named classpath、compileJava/jar SUCCESS 与重开 JAR 内 **Test.class** 原 bytes 等同为合取证据；major52仅辅助。原两源码实际产物为 Test.class，准备中的 Consumer.class 是方法说明误写。唯一 generated TestKit 属性原 bytes/缺席须 finally 精确恢复；不恢复 jcmd/CIM/observer 或四 key/byte-writer 账本。以下初次准备的未定方法描述保留其原时点，本节仅局部校正方法，不推进 Result/Waves/Todo/gate，也不构成实跑通过。

### historicalLayeredB01Graph

```text
{
  "scopeId": "mixin-layered-b01",
  "work": "E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/work.md",
  "plan": "E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/plan.md",
  "waves": "E:/Projects/cloche/minecraft-codev/docs/works/mixin-rework/waves.md",
  "preparationOnly": false,
  "scopeConfirmation": "当前用户在独立只读审计→消费者说明的收尾披露后明确继续；当前只授权B-AUDIT-01完整独立审计报告。不修代码，不运行项目/测试/caller/checker，不安装/清cache/改权威或旧证据/Git，不由Handler续行。已完成的功能scope及失败保持历史身份，消费者说明待审计后细化。",
  "executionAuthorized": true,
  "authorizedItemIds": ["B-AUDIT-01"],
  "outcome": "已接受分层功能与一次性维护结果，加上当前独立审计报告；当前不写消费者说明或Git，不宣称strict全Host证明。",
  "historicalGraph": "historicalWavesGraph below: readonly provenance, not selected and no executable edges into this graph",
  "externalDecisions": [
    {
      "id": "D-B-SCOPE-CONFIRM",
      "state": "confirmed-unified-B-I04-then-B-I05-no-extra-focused",
      "owner": "Router/当前用户",
      "predicate": "集中披露并确认新scope/outcomes/exclusions/owners/命令/有界正常outputs与child/finally；不继承旧run01许可。B-I01/B-I02可独立确认；blocked compiler不被确认文字自动settle。"
    },
    {
      "id": "D-B-COMPILER-METHOD",
      "state": "settled-static-method",
      "methodResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i03-compiler-method-source-artifacts/result-1.json",
      "methodDecision": "Router已完整读取并关联generation1 Result，选择原compileJava直接javac8 CLI分支；实际版本/wrote、failOnError与非增量SUCCESS、原patch/remap classpath及本次JAR内Test.class字节闭合为合取证据。Test.class是原两fixture实际对象；Consumer.class是本候选准备中的误写，不能要求不存在对象。B-I03 g2已有一次实跑：两fixture真实javac8编译/打包成功，但新增argfile路径断言造成fresh 2/2 failures/native exit1；不能释放B-I03/B-W02。g3仅做最小解码纠错/离线验证，无额外原生运行许可。",
      "owner": "Forge compiler测试边界/Router",
      "predicate": "与当前Gradle9.4实际执行路径相符的测试侧方法已证实并定案，受控Java8 compiler执行→逐fixture fresh class/JAR闭合；不只selection/major52/qualified flag，不加observer/生产观测/安装工具。"
    },
    {
      "id": "D-B-FORGE-SOURCE-READY",
      "state": "settled-code-only-awaiting-shared-native",
      "owner": "Router/Forge测试边界",
      "sourceResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i03-java8-compile-proof-artifacts/result-3.json",
      "predicate": "g3一行argfile转义解码修正及离线两真实输入/quoted-UNC检查完成，所有原断言保留；仅源码就绪，不是修正后JUnit通过，须由B-I05新原生结果验证。"
    }
  ],
  "outputBoundary": {
    "historicalReadonly": true,
    "verifierMayModifySourceOrTests": false,
    "scope": "既有相关module build子域/native test-results/reports/platform-fixtures、经确认的原fixture输出和有限Gradle/TestKit/Codev operation namespaces；不是整build/cache/Temp。",
    "child": "受限环境copy；临时generated属性唯一允许位置及必要finally恢复；不改父/全局。",
    "onGap": "无法约束default Temp或需要额外具名旧对象/第三方effects时，只停止受影响执行并报告；不扩权，不用取消strict账本证明写域允许。"
  },
  "wavesGraph": [
    {
      "id": "B-W01",
      "gateState": "satisfied-bounded-scope",
      "gateEvidenceResultRefs": [
        "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i01-fabric-test-dedup-artifacts/result-1.json",
        "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i02-forge-dual-metadata-artifacts/result-1.json"
      ],
      "itemIds": [
        "B-I01",
        "B-I02"
      ],
      "predecessorWaveGates": [],
      "incrementalOutcome": "去重后Fabric行为覆盖不减，真实Forge双位置metadata缺口补齐。",
      "releasePredicate": "B-I01/B-I02各完整completed Result及focused原生XML/实际行为/closed JAR与source不变证据一致，集中scope确认存在，无未决生产缺陷；不依赖B-W02。"
    },
    {
      "id": "B-W02",
      "gateState": "satisfied-bounded-shared-B-I05-Forge8",
      "acceptedSharedResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-includes-format-closeout-artifacts/result-1.json",
      "evidenceRef": "docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md",
      "itemIds": [
        "B-I03"
      ],
      "predecessorWaveGates": [],
      "incrementalOutcome": "原两Forge fixture具备实际Java8执行和fresh compile/package闭包。",
      "releasePredicate": "当前确认允许g3修正输入与B-I05完整completed原生结果共同提供B-I03新回归证据：修正后PatchedMinecraftTests两case均通过，逐fixture实际compiler8→compileJava SUCCESS→本次class/JAR与patch/remap关联完整、正常输出/恢复可控。原g2 failed/g3 partial不修改，不能仅离线检查或旧JAR放行。"
    },
    {
      "id": "B-W03",
      "gateState": "satisfied-bounded-B-I04-maintenance",
      "acceptedResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i04-core-abi-validation-artifacts/result-1.json",
      "itemIds": [
        "B-I04"
      ],
      "predecessorWaveGates": [],
      "incrementalOutcome": "当前Core维护的独立fresh JAR/原三caller/ABI/debug一次性闭包。",
      "releasePredicate": "B-I04完整completed、所有一次性兼容条件与原sealed caller实际Java17链接证据齐备，same delivery Core输入绑定；不是每次Mixin日常门禁。"
    },
    {
      "id": "B-W04",
      "gateState": "satisfied-bounded-split-window-acceptance",
      "acceptedResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-includes-format-closeout-artifacts/result-1.json",
      "evidenceRef": "docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I05/continuation-03/verification.md",
      "itemIds": [
        "B-I05"
      ],
      "predecessorWaveGates": [
        "B-W01",
        "B-W03"
      ],
      "incrementalOutcome": "同一交付输入的精简分层组合功能验收成立，不漂白旧R13且不宣称strict Host保全。",
      "releasePredicate": "B-I05完整completed、最终B-W01/B-W02/B-W03三gates证据真实且适用；B-W02由本窗共享原生证据满足，不是执行前置，入场仅本项明确prerequisites及已修正源码ready。全五check/所有适用A1-A12与AC1-AC12共享风险证据/Core3case四闭包负例/P01-P02/原两Forge8/一次性维护全部满足，无失败/缺失/unknown。Router独立判断，不自动释放历史W03/I05/I06/Git/G1。"
    },
    {
      "id": "B-W05",
      "gateState": "not-satisfied-blocking-F1-F2",
      "acceptedReportRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-mixin-i05-independent-audit-artifacts/result-1.json",
      "blockingFindings": ["F1", "F2"],
      "evidenceCorrection": "F3：原A/AC表错配，使用独立报告第5节的正确编号有限关联，历史表不覆盖。",
      "itemIds": [
        "B-AUDIT-01"
      ],
      "predecessorWaveGates": [
        "B-W04"
      ],
      "incrementalOutcome": "当前交付树的独立正确性/安全/证据审计完成；不重新执行功能验收。",
      "releasePredicate": "B-AUDIT-01完整completed独立报告覆盖当前实现、相关调用链和已接受证据；没有未处置的重大正确性、安全或证据缺陷。完成审阅可带findings，不因此自动满足本gate。Router判定后才决定消费者说明；不自动释放历史W03/完整G1/I06/Git。"
    }
  ],
  "items": [
    {
      "id": "B-I01",
      "waveId": "B-W01",
      "handler": "一个implement-change Handler，一个Result；测试去重与其focused验证是同一outcome。",
      "resultCount": 1,
      "planningState": "completed",
      "objective": "合并已被更强矩阵覆盖的Fabric SERVER/client-only重复，保留全部适用行为assertions。", 
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisites": [
        "D-B-SCOPE-CONFIRM"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricEnvironmentObligationsTests.java",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java"
      ],
      "scopeAndEffects": [
        "删除仅重复的serverMustNotConsumeClientOnlyConfiguration及无其它用途的旧test类；以现有outerEnvironmentIntersectsInternalKindsAndRetainsInactiveOnly承接该格。仅必要局部assertion/说明调整，不另建fixture或改生产。",
        "保留全部side/environment/kind、inactive/untouched记录、ordinary拒绝、parent/tamper以及providerChain失效；不得删成只剩target值断言。"
      ],
      "completionPredicate": "重复已消除且保留suite在真实SERVER/client-only格仍证明target=1、inactive/untouched记录及cleaned config/reference/resources保留，全原矩阵和provider失效focused测试通过；其它消费者入口/生产未改。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-fabric:test --tests '*FabricApplicabilityRepairTests' --rerun-tasks --stacktrace --console=plain"
      ],
      "requiredEvidence": [
        "局部test diff与重复到更强assertions的关联；实际argv/cwd/exit/原始两流、fresh native XML及retained platform-fixtures JAR/records；source artifact不被cleanup修改。"
      ],
      "writeOwnership": [
        "仅上述test owners；minecraft-codev-fabric/build/test-results/test/**、reports/tests/test/**、platform-fixtures/**及该test所需既有classes/metadata输出；有限Gradle/TestKit/operation效果需在scope确认中具名，非整个build许可。"
      ],
      "conflicts": [
        "B-I02",
        "B-I03",
        "B-I04",
        "B-I05"
      ],
      "conflictReason": "原生验证共享root Gradle状态及其依赖build输出；与任何same-delivery验证窗口排他。I01/I02独立source edits本身可并行，但验证窗口不得重叠。",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i01-fabric-test-dedup-artifacts/result-1.json"
    },
    {
      "id": "B-I02",
      "waveId": "B-W01",
      "handler": "一个implement-change Handler，一个Result；真实双位置覆盖及focused验证。",
      "resultCount": 1,
      "planningState": "completed",
      "objective": "一个真实Forge source JAR同时含manifest/TOML，selective输出所有适用引用共同更新并安全保留。", 
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisites": [
        "D-B-SCOPE-CONFIRM"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt"
      ],
      "scopeAndEffects": [
        "保留现有两单位置用例；同suite新增真实dualMetadataSelectiveReopenUpdatesEveryApplicableReference场景，复用Jar/ZIP及现有OperationRunner/SelectiveConsumer/Forge handler，不改生产。",
        "同一source同时提供META-INF/MANIFEST.MF的MixinConfigs和META-INF/neoforge.mods.toml的mixins，含consumed和retained configs/order/vendor字段/resources；由真实producer evidence→selective cleaned JAR，不仅对两个孤立文本handler测试。"
      ],
      "completionPredicate": "真实selective双位置cleaned JAR重新打开时所有consumed引用共同消失且无dangling reference、retained引用顺序/metadata/resources保留、原source不变；原manifest blank-token与TOML save/reopen测试仍通过。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-forge:test --tests '*ForgeMixinMetadataTests' --rerun-tasks --stacktrace --console=plain"
      ],
      "requiredEvidence": [
        "新增一个真实双位置JAR场景的test diff；fresh XML、真实producer/records/consumer输入与closed source/target/cleaned JAR；重开manifest/TOML断言与native argv/cwd/exit/原两流。生产缺陷/冲突metadata发布缺口如实返回，不自动修。"
      ],
      "writeOwnership": [
        "仅该test文件；minecraft-codev-forge/build/test-results/test/**、reports/tests/test/**、platform-fixtures/**及该test所需既有classes/metadata输出；不写basic/remapped fixture或生产。"
      ],
      "conflicts": [
        "B-I01",
        "B-I03",
        "B-I04",
        "B-I05"
      ],
      "conflictReason": "与其它原生窗口共享root/dependency输出，且与I03共用forge:test的XML/platform-fixtures；source edits独立，验证排他。",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i02-forge-dual-metadata-artifacts/result-1.json"
    },
    {
      "id": "B-I03",
      "waveId": "B-W02",
      "handler": "一个implement-change Handler，一个Result；只有方法gap settled且scope确认后才可执行，不能边验边扩生产观测。",
      "resultCount": 1,
      "planningState": "completed-via-shared-B-I05-native-evidence",
      "acceptedSharedResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-includes-format-closeout-artifacts/result-1.json",
      "focusedNativeRunsUsed": 1,
      "additionalNativeExecutionAuthorized": false,
      "objective": "原两Forge真实fixture每个能证明Java8 compiler实际执行并绑定本次fresh class/JAR，而非静态配置。",
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisites": [
        "D-B-SCOPE-CONFIRM",
        "D-B-COMPILER-METHOD"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "minecraft-codev-forge/basic-patched-test/build.gradle.kts",
        "minecraft-codev-forge/remapped-patched-test/build.gradle.kts"
      ],
      "proposedWriteOwnership": [],
      "scopeAndEffects": [
        "原两fixture/Java8/1.12.2和1.16.5/真实Java API、patch/remap/jar任务链不改；不新增版本，不改outer Gradle成Java8。",
        "已选静态支持的直接CLI方法：原compileJava fork=true，以必需fixtureJava8Javac参数传现有绝对javac8；不设置javaHome，-J-showversion/-J-Duser.language=en/verbose=true/incremental=false/failOnError=true。实际版本与本次wrote、原class输入和classpath、SUCCESS及本次jar内Test.class原字节闭合是合取证据，不能只selection或major52。",
        "已确认三个test/fixture owners及受限outer child copy中的compiler路径传递；保留原nested jar/printCompileClasspath/-s/--rerun-tasks并增加--info/--console=plain/--no-build-cache/--no-parallel和-PfixtureJava8Javac。withDebug(true)不使用withEnvironment。普通实现/必要Work方法说明在此单结果内完成，不恢复jcmd/CIM/observer或 caller qualified=true。"
      ],
      "completionPredicate": "两原fixture各有真实Java8 compiler执行成功→compileJava SUCCESS→本次写入原Test.class→本次jar内该entry原字节与编译目录等同，且patch/remap classpath闭包和必要finally完成；major52仅佐证，任何缺证则不completed。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-forge:test --tests '*PatchedMinecraftTests' --rerun-tasks --stacktrace --console=plain；仅一次outer focused，outer/test17、原两fixture各直接javac8并串行，以BuildResult和重开JAR落实合取证据，不附加Java版本探针。"
      ],
      "requiredEvidence": [
        "与当前Gradle实际compiler执行路径一致的方法来源、精确待确认test diff/argv；逐fixture compiler身份/执行事实、fresh输出及原生XML/两流；不以版本声明/major/历史栈采样替代。"
      ],
      "writeOwnership": [
        "当前用户确认的三个test/fixture owners及必要Work方法说明校正；仅原fixture固定task输出与classes/java/main、libs、tmp/compileJava/java-compiler-args.txt，native test-results/reports/platform-fixtures和经确认有限child/temp/TestKit/operation namespace。受控compiler路径经outer child copy传递，不使用debug TestKit.withEnvironment；原唯一generated属性bytes/缺席finally精确恢复。普通日志/必要旧结果快照允许，不授权整个cache/Temp或新JSON封包；run01无余额。"
      ],
      "conflicts": [
        "B-I01",
        "B-I02",
        "B-I04",
        "B-I05"
      ],
      "conflictReason": "共享forge:test/XML、原fixture输出和同一交付输入；任何其它验证或fixture writer不得同时运行。",
      "prelaunchFailureResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i03-java8-compile-proof-artifacts/result-1.json",
      "nativeFailureResultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i03-java8-compile-proof-artifacts/result-2.json",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i03-java8-compile-proof-artifacts/result-3.json",
      "sharedNativeVerificationItemId": "B-I05"
    },
    {
      "id": "B-I04",
      "waveId": "B-W03",
      "handler": "一个review-evidence Handler，一个Result；只读项目，完成一次性当前Core维护兼容闭包，不兼改生产。",
      "resultCount": 1,
      "planningState": "completed",
      "objective": "当前Core维护具备独立fresh JAR、原三封存caller真实链接及原ABI/debug条件的同源一次性证据。",
      "prerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisites": [
        "D-B-SCOPE-CONFIRM"
      ],
      "ownedProjectFiles": [],
      "scopeAndEffects": [
        "独立Core compileKotlin/jar窗口；只消费原sealed caller/tool，不重编caller，不重跑旧封包default/seal/checker。",
        "复用R06B commands.json的native-compile-jar和new-direct-links/new-existing-caller-links/new-kotlin-runtime原完整argv，当前Core candidate/JAR与新自有输出替换；classpath顺序/其它members/flags不变。",
        "七facade/18 JVM descriptors/default桥/Kotlinmetadata、原八class/28method/166LNT恰+2且BCI/count/order及其余150class条件保留；不把任意debug改变白名单化。"
      ],
      "completionPredicate": "本次独立fresh Core JAR与原三sealed caller在Java17 -Xverify:all实际链接通过，且所有原ABI/default/Kotlinmetadata/精确debug条件满足，证据绑定同一当前Core输入；不是最终G1或日常Mixin测试完成。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:compileKotlin :minecraft-codev-core:jar --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "Java17原三调用：AbiTool link <sealed direct-links.tsv>；AbiNormalize existing；OldKotlinCallerKt <new own runtime output>。完整flags/-cp/argv依下方commandSource选择对应new-* receipt项，仅替换当前Core与output；不能执行compile-*/generate-*历史命令。"
      ],
      "commandSource": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/commands.json#receipt=native-compile-jar,new-direct-links,new-existing-caller-links,new-kotlin-runtime",
      "requiredEvidence": [
        "native fresh独立JAR窗口与三个实际Java17命令完整argv/cwd/两流/exit、当前CoreJAR及sealed caller关联；ABI/debug差异事实。历史PASS不是当前闭包。"
      ],
      "writeOwnership": [
        "仅现有core/build所需classes/kotlin/main/**、libs/**、tmp/compileKotlin/**等原限定编译输出及经确认有限Gradle正常namespace；非整个core/build许可。",
        "未来自有普通产物namespace：docs/works/mixin-rework/evidence/g1-implementation/layered-b01/B-I04/，仅native stdout.log/stderr.log、当前Core JAR、abi-debug.txt与runtime/；本次不创建，不生成JSON封包/manifest/seal/checker，不向历史R06B/run01追加。scope未确认不运行。"
      ],
      "conflicts": [
        "B-I01",
        "B-I02",
        "B-I03",
        "B-I05"
      ],
      "conflictReason": "Core编译/JAR输出为各test依赖及I05组合输入；验证窗口与其他source/fixture/Gradle writer排他。",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i04-core-abi-validation-artifacts/result-1.json"
    },
    {
      "id": "B-I05",
      "waveId": "B-W04",
      "handler": "一个implement-change Handler，一个最终续行Result；Includes八条格式及一次该module check与旧窗口完整复用组成同一五模块收尾outcome，不兼逻辑修复/I05审计/文档/Git。",
      "resultCount": 1,
      "planningState": "completed",
      "objective": "仅Includes四main文件八条原ktlint格式；一次Includes check并完整只读消费既有四module成功check/65 tests及ABI，满足分窗全部A/AC/P01/P02/Core3/实际Forge8，不宣称任何旧exit1命令通过。", 
      "prerequisiteItemIds": [
        "B-I01",
        "B-I02",
        "B-I04"
      ],
      "prerequisiteWaveGates": [
        "B-W01",
        "B-W03"
      ],
      "externalPrerequisites": [
        "D-B-SCOPE-CONFIRM",
        "D-B-COMPILER-METHOD",
        "D-B-FORGE-SOURCE-READY"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/ExtractIncludes.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/StripIncludes.kt"
      ],
      "scopeAndEffects": [
        "当前一次Includes check；只修四file八条格式，不改逻辑/API/断言/lint规则。只有同源实物闭合才复用g1 Mixins43/Fabric8及continuation-02 Forge11/Core3成功check，不重跑旧65tests/原fixture/ABI/caller/focused。",
        "全部A/AC按Plan风险共用证据，已有Core四vanilla闭包/负例、原两Forge actual8/class-JAR及P01/P02完整链只读闭合。Includes test NO-SOURCE仅当本窗真实如此；Core维护同源关联，不宣称Includes格式后产物bytes不变。",
        "四Codev key/cold Temp逐path/strict byte-writer/fullHost不在功能完成分母；C3/C4内容绑定/cache correctness/旧对象保护/有界effects/受限child/finally保留。"
      ],
      "completionPredicate": "唯一Includes native成功check，加g1 Mixins/Fabric与continuation-02 Forge/Core成功check按本次明确许可组合；旧两次exit1/failed永不改绿。四Includes files仅八条格式无逻辑/API/lint条件变化；source/TestKit/closed产物复用成立，65tests零fail/error/非许可skip、Core3/3四闭包负例、全部A1-A12/AC1-AC12/P01/P02、实际Forge8/class-JAR/API及Core ABI维护关联完整。缺项不completed，严格归属unknown另列，Root不提前释放gate。",
      "verification": [
        ".\\gradlew.bat :minecraft-codev-includes:check --rerun-tasks --no-parallel --max-workers=1 --configuration-cache --stacktrace --console=plain",
        "只读完整消费g1 Mixins43/Fabric8及continuation-02 Forge11/Core3的原XML/TestKit/source/assertions/closed实物、I04维护同源关联；不重跑旧native/65tests/ABI。"
      ],
      "requiredEvidence": [
        "原八诊断与四file最小before/after差异、Includes唯一native argv/cwd/UTC/exit/完整两流/实际check到达；旧四module成功check/65tests的方法和同输入实物消费；风险组合全部A/AC，不新造24运行或改绿旧failed。",
        "已有Core三case/four路径resource/major61/probe/JAR及精确missing-ID无成功输出；P01/P02 producer SUCCESS→target+records pair FROM_CACHE→first fresh consumer SUCCESS、target42/original1/source不变/Unused保留，body/resource/input失效及failure/cancel/publication/recovery完整合取，hash不替代算法。",
        "已有continuation-02两原Forge fixture实际compiler8/parsing/wrote/task SUCCESS及class-JAR/API闭合；I04完整维护Result与当前Core关联，不重复ABI/debug算法或运行；必要child/finally/有界effects及reusegap据实，旧B-I03/两次B-I05/所有历史unknown不回写。"
      ],
      "writeOwnership": [
        "正向源码仅四ownedProjectFiles中continuation-02原八comma/newline/indent诊断；无整仓format/其它source/test/fixture/config/逻辑/依赖/authority/Git写入。Includes check及必要依赖限原明确build/native reports/classes/JAR/有限Gradle namespace，不授整build/cache/Temp；其余module测试和产物只读复用、不主动生成。",
        "新普通native流/必要结果仅原B-I05/continuation-03/；g1与continuation-02原流/记录/旧SDKResult不覆盖。child temp仍原B-I05/runtime/temp，仅自己任务/JVM短命文件，必要generated属性精确finally，Includes不需Forge TestKit则不碰它；无manifest/seal/冻结包/observer/新采集框架。"
      ],
      "conflicts": [
        "B-I01",
        "B-I02",
        "B-I03",
        "B-I04"
      ],
      "conflictReason": "同交付输入及全部相关module/fixture outputs从验证开始到结果关联须稳定，排他所有source/test/config/Git writer。",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-includes-format-closeout-artifacts/result-1.json",
      "priorResultRefs": [
        "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-format-and-three-checks-artifacts/result-1.json",
        "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-b-i05-unified-module-checks-artifacts/result-1.json"
      ]
    },
    {
      "id": "B-AUDIT-01",
      "waveId": "B-W05",
      "handler": "一个独立review-correctness Handler，一个只读审计Result；security/evidence为同一审计的内部检查。",
      "resultCount": 1,
      "planningState": "completed",
      "objective": "独立审阅当前G1 Mixin改动及相连Core/Includes/Fabric/Forge行为、安全边界和已有验收证据，交付一个有来源的审计报告，不修复或运行项目。",
      "prerequisiteItemIds": [
        "B-I04",
        "B-I05"
      ],
      "prerequisiteWaveGates": [
        "B-W04"
      ],
      "externalPrerequisiteRefs": [],
      "ownedProjectFiles": [],
      "scope": [
        "仅当前五模块中本次Mixin交付变更及必要调用链/测试/现有文档；不审全仓或重复历史proof系统。",
        "复用65 tests、真实两Forge8、Core3/四闭包负例、12对A/AC、P01/P02及I04 ABI/debug；独立审阅不是信任摘要，必要时直接读现有原始源/日志/XML/JAR；不重跑。"
      ],
      "completionPredicate": "完整独立审阅报告有具体范围、当前source关联、覆盖与限制、按严重性排序的可复现路径/源码位置/最小修正建议及交付判断；未检查项/证据缺口如实标注。报告交付与无重大缺陷gate分别判断。",
      "verification": [
        "只读对照当前diff/实现/调用链/PRD/Accepted ADR/Spec，以及B-I04/B-I05完整结果和原始证据。禁止Gradle/Java/test/caller/checker重放或现场进程/缓存扫描。"
      ],
      "requiredEvidence": [
        "正确性与失败保护/隔离/关闭/取消/发布/缓存pair/选择性消费/metadata/mapping/legacy/provider兼容按实际范围审阅。",
        "安全findings须有实际入口/前提/影响/精确来源，证据风险不得当实现缺陷，旧strict unknown/failed保留但不恢复为常规产品门禁。",
        "中文完整审计Result；没有发现时说明检查范围和剩余风险，有发现时区分critical/high/medium/low及是否阻断交付。"
      ],
      "writeOwnership": [
        "无项目/source/tests/build/config/依赖/authority/旧证据/Git写入。只由既有Handler SDK交付报告；不新建审计程序/封包/冻结或消费者文档。"
      ],
      "conflicts": [
        "B-I01",
        "B-I02",
        "B-I03",
        "B-I04",
        "B-I05"
      ],
      "conflictReason": "审阅输入期间无并行source/test/config/产物/Git writer；只读共享不冲突。",
      "resultRef": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-mixin-i05-independent-audit-artifacts/result-1.json"
    }
  ]
}
```

## 以下全部为历史 Waves（historicalWavesGraph，完整只读保留）

> 下方旧图/IDs/edges/状态/原授权/权限/refs是历史provenance，不参与新图、不供本次执行或Gate。旧json标为text只防止被误选，JSON内容原样保留。原run01 failed/Core2/3/Includes未完成、24partial与R14有限localcompleted/unknown不改；不重封、不重放旧程序、不消费原runAuthorized=true。

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

唯一JSON图新增G1-I04E-R14/VG1-POST-13-RETIREMENT与独立W09；其only source写权六delete-only，新节点missing/not-run、confirmation未提供执行授权。既有54items/8waves及原运行/Result字段原义保留，不投影完成；当前55items/9waves联合64node DAG。W09不等待blocked R13；R13只追加R14/W09及跨树决策前置，原五checks/24项/default等要求不减；R13/I05当前退役树Core合同改为三真实case零skip，旧Basic例外保留历史字段。

本次preparation写权仅四coord＋core-test-retirement-plan-r01的新JSON/MD。future source/generated/evidence/conflicts/refs/完成谓词由下方唯一JSON的confirmedRetirementScope和R14定义；不把新planned outputs当input ref。旧Scope均保留为其原时点记录，本节和新retirement Scope才是当前局部源退役合同。

## 既有协调合同历史（保留原scope/时点，不与当前退役范围竞争）

## 当前 g3 就地修复匹配图（首次派生，54 items / 8 wavesGraph）

唯一 tuple：[Work](work.md)、[Context](context.md)、[Plan](plan.md)、本 [Waves](waves.md)。当前新确认scope的精确16路径/原SHA、五份历史归档保护和未来23文件在 Plan及下方唯一JSON的confirmedG3InPlaceRepairScope；四文档只派生合同，本次没有g3写入/程序执行/窗口消耗/Result或Todo投影/派发/接受/释放。旧“永久不动/新建g3/not-run/50items”说明仅原scope/时点，不与当前用户就地许可竞争。

本次standalone准备Result之外，唯一可执行分解为 G1-I04E-R12A-R01（候选修复/static）→G1-I04E-R12A-V01（独立static审阅）→G1-I04E-R12A-F01（一次capture/preseal/seal功能窗口）→G1-I04E-R12A-V02（独立实际default封包验收），每项一个predicate/Handler/Result，无auto retry。原R12A整个定义/历史missing字段保留为historical-only，并以真实capture0/preseal1会话及原SHA解析；不将历史rawfailed改为completed。W08只需新四项和原W02/七基础，绝不等待R13/W03/自身gate；当前未释放。

R13仍同两planned inputs README.md/verification.json及原独立实际default/fresh五模块/全24项/direct closure/ABI/双Forge Java8等完整消费要求；只把当前功能前置由原历史R12A引用接到新F01/V02完整证据，不修改实际消费方法或启动R13。T0的whole+tuple当前树等式限定为seal后、coord投影/R13副作用前；default完整receipt/raw streams必须稳定Host locator保存，sealed g3不写回，B/C未接受。后续R13时点冲突透明保留，不为当前准备增加未来反向依赖。

本节覆盖当前scope定义，不是运行状态/确认receipt或调度。原七base有限accepted完成、W01/W02 Router历史证据原样保留，rawpartial/fullStrictScope=false/unknownRuff/R11g3unknown/01仅两unknown例外不变；新四项无已执行Result，所有后继gate仍不得从准备release。


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

### 当前图的主动/历史解释

活跃 Wave 的 `itemIds` 与 `requiredCompletedItemIds` 必须完全相同；旧 incomplete 项只列 `historicalItemIds`，仍保留在全量 `items`、原 waveId/ID/边界/状态/谓词中。historicalOnly Wave（原 W07）不用于主动 release。所有引用的 item/Wave gate 与历史依赖都须可核对；显示次序/Wave 编号不产生依赖。R12A 位于独立 W08，继承 W02 与既有完整基础；W03 的既有入场前置仍仅 W02，R13 单项显式要求 W08 gate；W03 经 R13 消费 W08 并只要求活跃完整成员，不把新 gate 反向加给 R12A 已完成基础。R12A 自身不等待 W03/R13，R13 仍为唯一完整五 checks/24项终验。

图中 R12 `lastResultStatus=partial` 只是原已读取事实的历史登记，`acceptedCompletionStatus=missing` 保持（本次不接受其 Result）；原 R12 completionPredicate 不改。R12A/R13 status 均 missing/not-run，没有实际状态推进或释放。唯一 verification ID `VG1-POST-11A` 只属新 R12A，原 IDs 均保留。

## R12基线图初始准备记录（历史）

唯一 tuple：入口 [work.md](work.md)、处理上下文 [context.md](context.md)、策略 [plan.md](plan.md)、唯一可执行图 [waves.md](waves.md)。本轮只更新四份协调文档及 最小静态证据（历史原件不可访问；见顶部保留说明），不创建测试、不执行 Gradle/测试、不接受功能完成。

- 当前链为 **G1-I04E-R12 新基线五文件实施与聚焦验证 → G1-I04E-R13 独立最终五 module check/全24项 A/AC 验收 → W03 → I05/W04 → I06**。R12 是唯一新增候选 ready 实施项；R13 只有在 R12 完整实测 Result 及独立核验获接受后才 ready，partial 不满足前置。I05 的 scope、prerequisites、requiredEvidence 均消费同一 R13 最终树结果。W03/I05/I06/Git 仍未放行，本图不派发后继。
- 用户已接受用新当前 API vanilla 基线替换本轮旧 vanilla 证据分母：固定 **Gradle 9.4.0、既有 JDK17、MC 1.16.5/1.20.1，每版 common/client resolve→compile→package**；不是取消公开支持，也不承诺 selector 等价语义或新增 Core 支持。旧 Maven selectors、八 pipeline、Gradle 8.2/8.6/8.8 **本轮不计入且未验证**。
- 唯一 legacy skip 例外是已 Disabled 的 **Basic Minecraft Build()**，不计 vanilla 成功；原四空 pass 不构成行为证据。不允许 class disable、filter 或其他 skip。Core Test Java11 launcher、nested Gradle/编译17、Forge 原双 fixture 逐 fixture 真实 Java8 编译分层不变。
- 历史 R09 保持 raw/accepted partial、R10 保持 missing/not-run、R11 保持 raw/runtime/accepted partial；R09/R10 旧零 skip 完成谓词及原 receipt 封包仅历史，不再要求 R09 completed，不将 R11 窄停用目标改成 completed。unknown Ruff、**fullStrictScope=false**、**g3unknown**、历史失败及默认 exit1 全保留，不以分母调整解除严格范围限制。
- 当前未改动的 **273-input / 489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e** 仅历史锚。R12 创建后必须按实际成员/path/count 重绑新 identity，R13 在同一新最终树验收；未创建前不称为 278。完整五 checks、A1-A12/AC1-AC12、P01/P02 direct closure、core ABI、封存旧 caller 精确 debug 保全、原 Forge 真实闭包不可削减。
- 权威复核已 settle：PRD/Spec/同一 ADR 三 family 均 reuse，update/create 均 skip，不写 authority。具体执行越 owner、需要额外依赖/支持承诺或新阻断时停止并返回证据，不自动修复、安装 JDK、改版本/环境/Git。

### 当前 readiness 与 source of truth

R12/R13 IDs 已核对原图未占用后登记；其余 IDs/Wave membership 保持稳定。唯一 wavesGraph 的 W03 required 集改为消费 R12/R13，R09/R10 移入 historicalItemIds；W07/R11 历史暂停不释放 G1。现有 R04/R05/P01/P02/R06A/R06B/R07 accepted 功能基础及 W01/W02 gates 已有证据，R12 的新确认范围已 settle；R13 尚缺 R12 的完整实际 completed/独立核验，I05 尚缺同一 R13 + W03。

以下 prose 均保留为历史协调记录；它们中的“当前”、旧 zero-skip/R09/R10 gate 或暂未登记新 owner 不再是当前分母/门禁。文末 **唯一 JSON 可执行图**已更新到本节当前链，未变为历史图。JSON 中 historicalOnly item 的原完成谓词/状态/receipt 不被重解释，任何新 raw partial 不能满足 active completion。

## 历史协调记录

### R11 generation4结果（原核验后状态投影）

R11已实施单方法停用并完成g4唯一新授权的原core:test；`lastResultStatus=partial`、`runtimeStatus=partial`、`acceptedCompletionStatus=partial`，不是完整completed。Router仅接受“单Basic方法停用并明确skipped”的窄目标已验证，不接受严格整体完成，不释放任何Wave门禁。本writer只更新四coord，不再运行Gradle/测试或旧verifier，不写Todo/源码/权威/证据/Git。

g4完整事实（历史原件不可访问；见顶部保留说明）、native receipt（历史原件不可访问；见顶部保留说明）与逐case/class分析（历史原件不可访问；见顶部保留说明）：PowerShell/cwd匹配的原core:test实际一次native exit0，UTC `2026-10-09T03:35:48.3806936Z–03:36:17.5186658Z`，test与compileTestKotlin实际EXECUTED；fresh五case恰4pass/1skip/0failure/0error，唯一skipped为原Basic Minecraft Build()。fresh compiled class仅该方法具有原plannedDisabledReason的Disabled；`xmlSkippedReasonProvided=false`，XML仅`<skipped/>`，不是XML输出reason。四pass方法仍为空，不证明Core行为或vanilla；原body/fixtures/8.2-8.6-8.8 loop及其他Core/Forge测试保留，skip不执行三版本循环。

Router已独立执行g4默认只读`verify.py`：实际exit1、errors=[]、`focusedChecks=true`、`fullStrictScope=false`、`detachedVerificationReceiptChecked=true`；29新sealed成员/16旧sealed/20旧R11文件/9ledger/273inputs/281protected/52Git匹配。exit1来自已披露unknown Ruff严格scope限制，不是整体checker通过或native测试失败。当前273-input identity为`489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e`；041锚仅为历史source-edit前身份。g1/g2机械失败及raw partial、g4准备KeyError均保留，g3执行历史仍unknown，不称g4首次执行或自动retry。

唯一图仍47items/7Waves；全部依赖/owner/verification/completion/release predicates不变，W07亦不释放。R09 raw/accepted partial、R10被原前置阻断且not-run、原vanilla/三版本/五check/24A-AC缺口及W03/I05/I06/Git未释放保持。PRD reuse、Spec reuse、同一ADR skip写update沿用，只读不改权威；暂停不是fixture/selector/API修复。

四coord新字节是Router核验之后已授权的状态投影；旧快照/manifest/verifier全部只读，不重封或宣称旧入口对更新树的current-tree等式仍成立。下方旧“当前/准备/ready/未实施/未运行”说明及JSON中原preparation/未来输出措辞仅保留历史定义；现时R11事实以本节与其结果字段为准，旧完成谓词保持原义。

## R11初始暂停准备记录（历史）

matched [Work](work.md) / [Context](context.md) / [Plan](plan.md) / 本Waves唯一JSON图。新确认 `D-G1-CORE-BASIC-TEMPORARY-DISABLE` 由本Handoff inline的ordinary披露和用户明确ask_response提供；不是文档writer接受或runtime receipt。当前preparation写权只有四coord及新静态evidence；原writerPermission全部明确历史范围。

下方JSON初始派生唯一 `G1-I04E-R11`，一个Handler/Result/observable predicate、owner为唯一MinecraftTests.kt方法annotation/import，`VG1-POST-10`真实4pass1skip验证；所有原item predicates/status及W01–W06 release predicates不改。独立W07前置W02（传递W01），item前置R07及R04/R05/P01/P02/R06A/R06B/R07既有accepted基础；不需R09 completed/W03 gate，R09真实partial证据只读。所有actual inputs可读，未来R11输出路径仍普通文本，无假Result/receipt。

R11当前missing/not-run，structurally-ready只报告依赖事实。原R09partial、R10waiting及其五check/24A-AC/零skip/default gate不被R11取代；W03/I05/I06/Git不释放。旧方向deferred/cancel-proposal不改原节点为completed。未知Ruff及所有历史失败保持，静态相关inputs/图成功不能声明fullStrictScope或vanilla成功。

当前唯一准备结果是四份派生协调文档与独立静态证据（历史原件不可访问；见顶部保留说明）；不实施源码或执行Gradle/Java/tests，不写Todo、不委派/接受/释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`，Root已存在launcher1.9.0-M1；原R09 raw/accepted **partial**（5tests/1failure/0error/0skip）、R10 **waiting/not-run**、W03/I05/I06/Git未ready保持。新暂停完成也不释放这些原gates，不将原五fresh全部pass/旧selector/三版本谓词降为skip通过；vanilla仍gap，`fullStrictScope=false`与unknown Ruff历史保持。

仅新增一个暂停item `G1-I04E-R11` / `VG1-POST-10`，置于同图独立 `G1-W07`（前置原W02 gate），不是第二Plan/graph。原46items/6Waves保留，现47items/7Waves。R07及必要既有accepted基础和W01/W02 gate是completion前置；已验证R09 Root/source/CP失败只为readonly证据，不要求R09completed，不要求先修旧fixture。静态structurally-ready不是native完成或Router放行；当前唯一新可readyitem为R11，所有执行细节只在[Waves](waves.md)。

旧experimental/fixture repair方向明确 **deferred**；compatibility proposal **cancel-proposal（从未启动）**，被本暂停方向取代，不将用户取消记为completed，不删旧失败/身份。原root单行许可及旧writerPermission仅标注历史preparation，不给当前writer源码权限；后继仅R11该方法annotation/import例外，其他host/fixture/Forge/root保持readonly。以下所有旧“当前/最新/ready/宿主只读/未运行”文字按原记录当时理解，不与本首节竞争当前范围；旧图原完成谓词仍有效，不能从历史文字放行。

## R11准备前协调记录（历史）

下文完整旧记录保留其原义；当前实施许可仅以本首节和新R11 scope为准，原norm/原completion与失败仍不变。

## 当前R09 partial / R10 等待（原图准备保留）

用户最新ask明确选择“授权查询及有界候选修复/重验”，本轮派生许可标识 `D-G1-JUNIT-LAUNCHER-CONTINUATION`。原图准备 raw partial/strictscope 失败保留。R09 generation1 已实施并消费完整 Result，Router 独立只读核验 exit1/errors=[]/54 members/receiptChecked=true；唯一 launcher1.9.0-M1 单行生效，其他272 inputs、52 Git及旧包匹配。原 core:test fresh 5 tests/1 failure/0 errors/0 skipped，4通过均为原空方法；Basic Minecraft Build 在首个 Gradle8.2 阶段出现19条脚本编译错误，8.6/8.8未到达。首JUnit discovery边界已实际越过，原regression不足completed：R09 raw/accepted状态partial，R10未ready，W03/I05/Git未释放。当前273-input identity为 `041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44`；metadata/worker/core失败证据见R09（历史原件不可访问；见顶部保留说明）。unknown Ruff的fullStrictScope=false与旧Bash/PATH失败保持；后续四coord变更是父协调投影，不能改旧冻结快照或重放其current-tree等式。

原精确许可仍仅 `E:/Projects/cloche/minecraft-codev/build.gradle.kts` 共享测试dependencies新增一条 `testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.9.0-M1")`；原API/engine、其他coordinates/owner/断言/fixture/算法/五fork与Git边界保持。未来native验证允许正常获取已声明依赖及原源码实际选择的TestKit 8.2/8.6/8.8，不能换版本、安装JDK或改全局配置。

原R08 generation1/2仍historical-only **partial**，原默认exit1/2367输出/2373+12与receipt-bound extra2保持；62旧fresh tests不证明core executor通过，24行/direct/coreABI/逐fixture compiler仍缺闭包。首LauncherFactory机制 **supported、非唯一cause**；诊断/review raw partial与非UTF8编码恢复、167/176/53历史保持。PID151144属性支持core Java11，不等于确定Executor20映射；封存Gradle9.4文档示例为JUnit5.7.1，非JUnit6。

已完成native query三尝试真实exit **1/1/0**：Windows quoting未启动Gradle；root跨project无exclusive lock；仅临时query owner纠正后离线成功。Gradle9.4只调两个metadata task，API/engine5.9.0-M1、Platform engine/commons1.9.0-M1/BOM5.9.0-M1，无launcher/unresolved/artifactfailure。configuration files45/46与实际Test CP51/52皆无Factory；JavaLauncher JBR11.0.16与GradleVM Microsoft17.0.19分层。候选缓存JAR最大major53只是静态匹配，不证明worker可见/discovery/testpass。query raw Result **partial**；本writer在新增目录/文档前独立重跑默认只读入口exit1、errors=[]、receiptChecked=true；unknown Ruff严格scope失败，metadata成功不接受G1。

保全锚为273inputs `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`、52Git、query63members/53sources及旧176/53/2373/12。query实测正常generated仅 `build/reports/problems/problems-report.html` 的具体旧新hash；不是build目录allowlist。未知 `.ruff_cache/0.12.0/8623379424694068166` 及两review历史路径均未归属、未授权，后续新漂移继续逐path/length/hash披露；`fullStrictScope=false`、`functionalGatePassed=false`、W03/I05/I06/Git未释放。新增协调字节不重放旧current-inventory/default equality、不重封父包。

唯一当前JSON保留原44stable IDs/6Waves并新增R09、R10，共46items。R09/VG1-POST-08只拥有root共享testRuntimeOnly单行修复及focused原core:test；R10/VG1-POST-09只独立最终同树五check/完整24row验收。每项一Handler/Result；R09→R10显式串行，R09仅结构ready，R10待真实completed，均未运行。原R08字段/predicate/raw partial原样保留并标historical-only，从W03 requiredCompleted移出；其他必要accepted基础保持，W03/I05与W04绑定R10，I06/W04/Git另确认不变。

许可来源是本Handoff inline用户最新ask，不重问同范围、不新增accepted架构决定。query/review不是completed item依赖；metadata/相关静态检查不release gate。12个旧readableReferences因R06B实体rename已不可读，仅将其角色投影为明确原project locator→可读sealed before-source引用；原owner、Result与完成谓词保留，不改archive。所有新evidence路径仅planned output，不能作实际input ref。静态准备封包（历史原件不可访问；见顶部保留说明）验证唯一互链/IDs/refs/ownership/联合DAG/当前ready和bytes保全；严格scope unknown失败保持。

## R09准备前协调记录（历史）

以下保留原协调记录/原义及其当时“当前/最新/ready/missing”措辞，不是现时执行状态或新增许可；当前scope/状态以上节为准，唯一执行依赖以Waves当前JSON为准。原Result/完成谓词/失败证据不改写。

唯一执行图，匹配同目录 [Plan](plan.md)，入口 [Work](work.md)，证据 [Context](context.md)。

## 本次协调图准备边界

最新用户已选择“授权两项最小扩展（推荐）”，**D-G1-CORE-JAVA8-CONTINUATION** 已确认：仅 core17原文件/7destination/4JvmName保全，以及原PatchedMinecraftTests.kt nested argv增加--rerun-tasks；原完整G1必要直接闭包与三声明维护历史许可继续。其他owner/fixture/断言/生产算法/deps/五fork/Git禁令保持。**本次唯一结果为四份派生文档与新的静态图证据**；源码/测试/版本/权威/旧 evidence/Git/index 只读，不执行 Java/Gradle/TestKit、联网、formatter、清缓存、Todo、委派或 runtime 接受。

R03P/R03V/R04 的已经接受 completed 以既有 JSON 和下面原 Router 记录为依据；本 Handler 不重新接受。原 V01 Result **partial**、失败日志与原 `completionPredicate` 全保留；它转为 acceptance 的 historical-only predecessor，不能成为 completed 先决条件。下方“当前执行状态（Router）”原记录保留，追加本轮许可说明：其中待用户确认、尚 missing 等是当时观察；当前许可/状态以本节和唯一 JSON 为准。W03–W06 与 I05/I06 仍未释放。以上四项 missing 与 R05 structurally-ready 是原图准备时的观察；当前以 Router 既有接受记录和唯一 JSON 为准：R05/P01/P02 completed；V02 generation4 latest partial为historical-only（三个check成功，core lint阻断core/includes，A11/AC11 fresh Java8 compiler不足）。两只读诊断已completed，R06A/R06B/R07已授权未实施，R08当前终验；不释放W03/I05。

matched tuple 是 [Work](work.md) / [Context](context.md) / [Plan](plan.md) / 本 `waves.md`。本轮逐 family authority reuse 与原义判断见 [Context](context.md#post-v01当前权威与必要闭包)，策略与 verification 映射见 [Plan](plan.md#post-v01最小串行策略)，独立默认只读图验证及保全来源见 post-v01-repair-plan（历史原件不可访问；见顶部保留说明）。

## 当前执行状态（Router）

最新R08：R08 generation1/2 的完整 Result 均为 **partial**；Router 独立重跑 verification-recovery/verify.py exit0，原2373封存成员、12补充成员、两final-receipt日志、273输入/authority/历史/Git/环境与临时属性保全通过。原verify.py成员集exit1和2367-member旧日志保留，不改旧seal。当前identity仍为 `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`。实际mixins/Fabric/Forge check通过；core:test不能加载JUnit Platform，core/includes check未到达，overall exit1；15 suites/62 fresh tests零failure/error/skipped不包含core执行器成功。24行partial、direct/coreABI/逐fixture Java8配对仍未闭合，functionalGatePassed=false、fullStrictScope=false，W03/I05/I06/Git不释放。接下来仅只读诊断JUnit运行时加载边界，不授新增依赖/源码/config权限，不运行Gradle或自动重试。证据见R08（历史原件不可访问；见顶部保留说明）与补充校验（历史原件不可访问；见顶部保留说明）。 四派生协调文档在补充核验完成后投影当前状态；旧默认入口的current-files equality为当时快照，不重放或重封为新树。后续只读诊断不改变图结构/执行授权或原完成谓词。

最新接受R07：R07 generation1完整Result completed已消费；Router独立默认只读verification.py exit0：单一nested --rerun-tasks diff，原双TestKit fresh2/2、两个compileJava/fixture jar实际EXECUTED且各自Java8 worker编译栈/工具身份/父TestExecutor/重建窗口绑定，major52及compiled class/JAR逐字节一致。临时generated JDK8发现属性finally精确恢复原不存在状态，继承环境受限摘要/outer属性保持；其他272inputs、64297历史文件和Git保持。273-input identity `93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a`；89新成员保全。内部forge-patch-8/mappings-3/remap-4命中自有缓存，不宣称这些内部action重做；unknown Ruff漂移披露，fullStrictScope=false保留。R07 accepted completed，R08成为唯一runtime-ready节点；新树终验仍须fresh五check/全A-AC，不能继承旧XML/P01/P02/PASS，W03/I05/Git不释放。 完整Result为codev-v02-nested-java8-r07 generation1，Router独立只读入口exit0；原包不修改，R08只能在已接受R06A/R06B/R07后执行。

最新接受：R06B generation1 raw Result及原默认verifier exit1保持partial，原strictDebug=false与strictScope=false均未改写。Router独立复现新审阅入口exit0，13审阅成员摘要匹配：158对class，八类28methods/166项LNT恰+2、逐table count/order/BCI不变，其余150类行号保持，rawCodePayloadDifferences=0，runtime/API/metadata归一化等价158且module bytes相同。PRD/Spec/同一ADR reuse，无需新权威或同范围重复确认。仅补齐已授权四个两行file注解的精确生成调试效果；stacktrace行号/调试定位可观察变化如实披露，不能称class byte equality。Ruff未知writer漂移仍strict失败、不清理/恢复/授权。Router按澄清后的功能谓词接受R06B完成以接续R07，不宣称strict scope或G1通过；273-input identity `477d38dd2e0b4604d4f67a04c5e84fc5b6e72b61ccbbd0c7ac2f7c9056fdeb00`，原2024成员及13新审阅成员保全。R07 ready，R08/W03/I05仍等待。 原R06B完整Result与Router独立默认verifier均exit1/partial，以下item单列acceptedCompletionStatus，不把lastResultStatus改为completed；R07可接续但R08/W03/I05仍需最终新树验收。

最新接受：`codev-v02-core-content-lint-r06a` generation1 **raw Result partial**，Router独立verifier exit1与其一致：`relatedR06AChecksPassed=true`、`strictScopePassed=false`。32条内容finding全部消除；原生完整lint实际exit1且仅七原filename；独立core compile实际exit0；17/17 PSI等价、14owner变化/259其余inputs不变、277封存成员及61972历史文件/Git保全。当前273-input identity为 `484b2a9b790e5559405b25700890b971e9564b1a34b6efcce60a753d87772b53`。唯一strict scope偏差为`.ruff_cache/0.12.0/8217250146170573555`未知writer变化，未清理/恢复/授权；raw partial及exit1保留。Router仅接受R06A功能完成条件，`acceptedCompletionStatus=completed`允许R06B接续，不宣称严格范围/完整core lint或G1通过，不释放W03/I05。见R06A证据（历史原件不可访问；见顶部保留说明）。下方原准备/missing说明为历史观察；当前R06B ready，R07/R08等待。

本轮只消费既有Results与最新精确许可，未重新接受/调度runtime。两个只读诊断均已completed，先前“等待许可/core诊断running/宿主只读”是当时观察；现仅Context明列core17/7dest/4JvmName及单一nested argv解除限制。R06A/R06B/R07/R08均missing/未实施，V02原ID/latest partial/Result为historical-only；P02 completed与最新许可构成R06A实际前置。新静态准备证据见 v02-core-java8-plan（历史原件不可访问；见顶部保留说明）。

- core样式精确诊断 completed：`codev-v02-core-lint-scope-diagnosis` generation1完整只读Result已读取，39规则/17源码与273 frozen inputs绑定，38规则对应既有形态、1规则来自R01 getter布局而非R05类注解。原27样式owner交集为0；需新增17文件/七destination与四保全JvmName范围。Router核对当前273inputs长度/SHA、四facade生成class摘要及零活动执行器。两个诊断均未运行Gradle/编译、未写源码/旧证据。具体候选范围已处理在Context“V02 generation4后的待确认最小补救范围”，包括单一原PatchedMinecraftTests nested argv加rerun候选；Plan/Waves写权尚未扩大、修复未启动。当前等待精确许可，V02/W03/I05/I06继续partial/未释放。

- Java8 fresh路径只读trace completed：`codev-v02-java8-fresh-diagnosis` generation1完整Result已读取。Router核对原`PatchedMinecraftTests.kt`与continuation-g3 observations：outer Java17/Fresh双TestKit2/2成立，nested argv仅jar/printCompileClasspath/-s，没有outer --rerun-tasks；两compileJava UP-TO-DATE复用已有输出，major52/provider/JAR重开不替代fresh compiler。精确task-history skip原因未有info日志；原GRADLE_OPTS继承值未采集的限制保留。候选最小补救为nested rerun并捕获真实toolchain/compiler与outcomes，当前宿主只读，未实施或重验；不将未调查的其他临时执行办法宣称不可行。core样式scope诊断仍running，待合并确定必要许可/验证边界。此trace不释放V02/W03/I05/I06。

- `G1-I04E-V02` generation4 最新 partial 已独立核验：`continuation-g3/verification.py` Router后台exit0（2m34s），273 inputs identity `373f897c8fcce3487fb85cb1a8566326aa4a557dfd42536248faa460fd097e9b`，2586封存成员与旧26包14525成员/P02历史匹配；native exit1，mixins/Fabric/Forge check成功，core主源码ktlint39项/17文件失败，core/includes check未到达。fresh15 suites/62 tests零失败/错误/跳过，原Forge双TestKit2/2但nested compileJava均UP-TO-DATE，A11/AC11缺新的Java8 compiler observation；其余11组A/AC当前supported。不据完整性或局部PASS释放W03/I05/I06。GRADLE_OPTS原继承值未捕获、Ruff工具缓存变化限制原样保留。只读后续分别核查core/includes样式归属和rename/API边界，以及嵌套fresh Java8执行的最小证据方法；不授权扩大shared生产写权或自动重试。

- `G1-I04E-V02` generation3 partial 已独立核验：continuation-g2 默认只读 verifier exit0，273 inputs identity `04e9bb98881800f18bd0d6ed649e8896a01fd3de7465e7f8ddf010b6447a3608`，native exit1，mixins/Fabric check成功，Forge测试ktlint失败，Forge/core/includes check未到达；fresh52 tests与补充原Forge双TestKit2/2零失败，不替代完整门禁。A6/A8/A11/A12及对应AC partial；2863封存成员与历史包匹配。generation1 partial、generation2契约blocked、旧快照对新树files失败记录原样保留，不改旧包。

- V02测试样式补救 completed：此前Fabric单owner补救已接受；`codev-v02-forge-lint-repair` generation2完整Result已读取，Router独立只读核验exit0（1m25s）。Forge两个授权owner仅格式/import改变，271个其余inputs不变；75个repair成员、55280个历史recorded members、2863个sealed V02成员匹配，指定Forge ktlint实际exit0且原生报告为空，PSI实际独立复验exit0。generation1为无项目副作用的Handoff blocked。证据在 `evidence/g1-implementation/post-v01-repair/G1-I04E-V02-forge-test-ktlint/`。格式修复后必须捕获新identity并fresh重验P01/P02闭包及全五check/A-AC；旧运行不能因语义等价自动成为新树PASS。仅恢复V02运行前置，I04E/W03/I05/I06仍未完成。

- `G1-I04E-P02` completed：`codev-consumer-direct-proof-p02` generation4 完整 completed Result 已读取，Router 独立后台运行 continuation-g4 默认只读 verifier exit0（2m43s），coverageStatus=completed。最终输入 `b2e9afeef8f811468a44569c03f9019ab36c640ac513db0e218c8e6e4cd84e5b`、273 inputs、native exit0/fresh56tests、零 failure/error/skipped；仅九个原 test owners 改变，没有输入成员增删，原P02 9577成员与26历史包14525成员保全。精确Foo/FooExtra/跨package、双target全成功、拒绝矩阵、fresh Fabric/provider/metadata、同第三方provider selective拒绝与legacy全删、真实旧registerTransform/artifact resolution及有界AT/nested证明满足本项谓词。AT只证明实际CLI，nested只证明no-config G1 operation与既有handler/cleanup；完整Forge task接线、五check及全A/AC由V02独立验证。generation3 partial及所有失败封包不改写；本次Router状态更新与实现identity区分。仅释放V02实施前置，I04E/W03/I05/I06仍未完成。

- `G1-I04E-P02` generation3 historical partial：`codev-consumer-direct-proof-p02` generation3 完整 Result 已读取，Router 独立后台默认只读 verifier exit0。固定最终输入 `db622464ebddfbcdae496555dbb98097d2b0e11096ff52ebfc1b4b13bedb04c6`，273 inputs、26 历史包/14525 成员匹配；最终第三轮进程级关闭 parallel、workers.max=1，13 fresh XML suites/51 tests、零 failure/error/skipped、native exit0。仅 planned ForgeRetainedBaselineTests.kt 新增，before 首次捕获晚于其创建的限制已披露；前两轮 parallel 偏差、ZipFS 删除失败和 verifier 排序失败保留。完整性与 51/51 不闭合所有覆盖：FooExtra/另一 package、双 target 全成功、完整拒绝矩阵、第三方 selective/legacy 对照、真实 Gradle 注册、非空 AT 入口及真实 nested payload 仍需 P02 原范围内直接补证；未证明这些入口不可达。generation1/2 为无项目副作用的契约 blocked，保持历史状态。V02/W03/I05/I06 不释放。

- `G1-I04E-P01` completed：`codev-producer-direct-proof-p01` generation5 完整 Result 已读取，Router 独立默认只读 verifier exit0；固定命令 native exit0、四 suites fresh 25/25。producer target+records FROM-CACHE 恢复后的 fresh consumer、同 JVM mapped→configured-unmapped 隔离、operation 域来源及三 unsupported failure 契约满足本项谓词。accepted 输入 `9a26a415db0f0644ffc028fae12c3490ed53e020659d936841f74b2e85fce4b5`。Router 将 detached default-verification receipt 的 SHA-256 等价大写表示更正为小写后独立核验通过；未修改 Gradle/XML 原生结果。原 blocked/partial 与先前失败证据保留，早期 attempt-01 的 generation 归属未据此补造；P02 修改测试后不自动继承此运行 identity，只释放 P02 原范围补证。

- `G1-I04E-R05` completed：Router已读取 `codev-task-declarations-r05` generation1完整completed Result并按 VG1-POST-01 接受。仅三个精确class import/DisableCachingByDefault声明；core/includes原生validatePlugins实际rerun exit0，两个原生报告均为`[]`，configuration-cache stored。272 inputs仅三owner改变，after identity `0303f070f760f1fe54fe017bbad9ceea16c834f02758f59b22943d4747f8a958`；31新包成员、24旧包10049成员及Git/index保全由完整Result和默认verifier exit0支持。一个ignored Ruff cache变化单列，actor未知，不构成语义输入或运行成功证据；未运行独立Router领域核验。当前只释放P01的实施前置；P02/V02/W03/I05仍待，最终组合验收保持partial。

- post-V01 图准备按相关输入谓词接受：`codev-post-v01-repair-graph` generation1 与 `codev-post-v01-cache-review` generation1 原完整 Result 均为 partial，原 strict inventory exit1 保留，不改旧封包。Router 独立复核通过 272 inputs、39 items/6 waves、35 父包/8 review 成员、权威/旧 sealed/Git/index；已记录两项 ignored Ruff 生成缓存偏差（原文件变化及新增文件，actor 未知），不属于项目语义输入，接受其不影响图准备的保全结论。该接受只释放已授权 R05，不表示任何运行 gate 通过；P01/P02/V02/I05 继续等待。W04/I05 当前验收文字同步至 V02，历史 V01 partial 保留。

- post-V01 两项只读后续均 completed，最终gate仍partial：Router读取 `codev-core-includes-validation-diag` generation1及 `codev-final-matrix-gap-audit` generation1完整Result并分别独立默认verifier exit0。diagnosis99members、audit11members，固定272inputs/19旧包7901members/V011995members/Git/index保全，无活动wrapper/test/fixture。三abstract类型IncludesJar/AddClientSideAnnotations/CachedMinecraftTask各缺自身cache声明，Gradle9.4逐类型校验且声明不继承；HEAD静态对照缺失相同，但未运行HEAD。候选仅三个class DisableCachingByDefault/import，当前精确getter/五具体task许可未覆盖，待一次新增范围确认。矩阵5supported/7partial，必要cache-restore→fresh consumer、精确清理/两target consumer、remapper隔离、fresh Fabric/第三方边界等须补证；ASM9.6 operation域与外层9.9.1 metadata区别只证明归属不足，未证明引擎矛盾，不据此升级依赖。A1旧transform注册及AT/nested基线执行义务按原authority界定，不新增policy或产品承诺。两项完整交付不等于I05最终审计或运行通过；旧partial/failed包不改写。当前无活动执行者，未启动修复/五check重试，I04E/W03/I05/I06不释放。

- `G1-I04E-V01` partial：`codev-final-five-check-v01` generation1完整Result已读取并独立默认verifier exit0；1995本包成员、272inputs identity `8595111476c330a06a271adf72e16ef306ad225daa7c11984a880c1ab2e4773a`、19旧包7901members/Git/index保全，无活动wrapper/test/fixture。唯一五check命令exit1：core/includes validatePlugins因IncludesJar/AddClientSideAnnotations/CachedMinecraftTask缺缓存声明失败，五check均not-reached。44 fresh tests通过含原Forge2/2，旧Fabric9项排除；Java8发现属性finally恢复。矩阵5行supported/7行partially，FROM-CACHE后fresh consumer/部分精确清理、隔离及兼容案例仍缺证；实际probe ASM9.6与声明9.9.1差异待诊断。该证据完整性通过不等于验收通过，保留全部原失败及首次证据verifier失败。I04E/W03/I05/I06不释放；先独立只读定位声明owner与矩阵缺口，未修源码或重试五check。

- `G1-I04E-R04` completed：Router已读取 `codev-maintenance-versions-r04` generation1完整completed并独立默认verifier exit0。仅core/includes版本行变为 `0.1.0+terrarium.0.7.2` / `0.1.0+terrarium.0.6.5`，其余270输入及I04D三fork不变；五changed-module set与14动态项目引用一致。272最终inputs identity `8595111476c330a06a271adf72e16ef306ad225daa7c11984a880c1ab2e4773a`，29本包成员/18旧包7872成员/Git/index保全；未运行Gradle。仅释放 `G1-I04E-V01` 新树五模块check及完整矩阵，旧I04E仍partial、I05待最终完整Result。此后Router协调状态变化与实现identity区分，不再对当前树运行要求旧coordination或ignored产物不变的旧verifier。

- `G1-I04E-R03V` completed：Router已读取 `codev-forge-patch-r03v` generation1完整completed Result并独立重跑默认只读verifier exit0；409本包成员、272 inputs identity `bf1fd2fb4c98a4c3c183bce06c6a3fcfb0a87517a8b8fb69bdfc48590f973a89`、17历史包7463成员及Git/index匹配。原过滤命令一次exit0，原生fresh XML真实2/2、failure/error/skipped=0，外层test实际执行且configuration-cache reused；basic/remapped两个forge-patch-8均MISS，basic ICommandSender定义/引用同namespace，remapped remap-4 MISS且srg→named、mappings-3 HIT。两fixture compileJava实际Java8/major52；basic JAR实际生成，remapped JAR UP-TO-DATE但class与本次编译字节匹配。generated TestKit属性finally恢复，源码/config/tests/版本未改。原R03及R03P历史failed/partial/blocked保持，当前原fixture outcome由R03V承担；仅释放R04，五模块check/完整矩阵/AT语义/nested功能/I05仍待。后续Router协调变化单列，不再要求旧R03V全coordination快照与当前相同。

- `G1-I04E-R03P` 当前修复谓词 completed：Router已读取 `codev-forge-patch-repair` generation2完整partial Result及 `codev-patch-evidence-encoding` generation1完整completed补救Result，并独立重跑补充默认只读verifier exit0。仅两个生产owner及新McpActionPatchTests改变，原生局部4/4、编译/两ktlint exit0；271原输入identity `e3abcff9b10b4e1ff3696ab4a6de9b8adae7be3eb082fa8a35403e27ad4f73fa`，含新增测试272项identity `bf1fd2fb4c98a4c3c183bce06c6a3fcfb0a87517a8b8fb69bdfc48590f973a89`。原164成员及补充6成员清单匹配，15历史包7293成员/Git/index/旧cache保全；补充入口保留30条原assert，仅compiled ASCII bytes与补充子树清单边界不同。原generation1无Result失败、generation2 partial及原verifier UnicodeDecodeError exit1均不改写。此结论仅接受生产repair谓词，不是原双TestKit或完整G1通过；只释放R03V，R04/V01/I05仍等待。本次Router协调文字/JSON状态变化单列，不属于实现树漂移；后续以272个实现输入及旧包身份固定树。

- basic patch缺失接口诊断 completed：`codev-basic-patch-diagnosis` generation2完整Result已读取；generation1的child_exited_without_result及无Result失败保留。Router独立默认只读verifier（历史原件不可访问；见顶部保留说明） exit0，88来源/37选定class/128本包成员匹配，271inputs identity `6044ede90315ca42796f7b7451ac303e64947a65b0a5446650cae90e4e3c2a9d`、25136枚举文件、13历史包7136成员及Git/index/临时属性保持，未发现活动wrapper/test。保留证据确认basic notchObf=true时binarypatch子集缺bn接口，rename将MinecraftServer引用转为ICommandSender后，ResolvePatchedMinecraft按旧notch名补回bn定义；最早修复边界为patch子集进入rename/mcinject前的完整输入，两个fixture接线无法独立纠正。静态HEAD对照支持旧机制已有，未运行独立baseline，未重放实验/Gradle。建议最小扩展McpAction.kt与ResolvePatchedMinecraft.kt的完整输入/后填充责任及PATCH_OPERATION_VERSION旧错误缓存失效，保留patched bytes优先与原双fixture断言；现Plan明确不改生产patch/remap算法，故该扩展待用户确认，未实施或改图放行。R03/I04E仍partial，R04/V01及审计锁定。

- `G1-I04E-R03` Java8发现恢复后重验 partial：`codev-forge-r03-java8-rerun` generation1完整Result已读取，报告（历史原件不可访问；见顶部保留说明）默认只读verifier独立exit0。原命令一次实际执行exit1，fresh XML tests2/failures1/errors/skipped0；remapped原断言通过，patch/LoadMappings/srg→named/真实Java8compile/JAR/printCompileClasspath与major52观察成立。basic新patch JAR缺net/minecraft/command/ICommandSender.class，MinecraftServer仍implements该接口，compileJava失败，尚未定位生产根因。临时TestKit paths finally精确恢复，runtime home/Java8compiler已采样；源码改动0，377本包/271inputs/12旧包6759成员/Git/index匹配，无活动wrapper/test。保留原blocked与partial，先独立只读诊断basic输入→patch→classpath缺失边界，不改生产/断言/版本，不自动重跑，R04/V01及审计未释放。

- Java8工具链发现诊断 completed：`codev-forge-java8-diagnosis` generation1完整Result已读取并独立默认只读verifier exit0，36本包/386列明保护文件/271inputs/Git/index匹配。当前两套Azul Java8 JDK具有compiler结构且java -version均exit0；外层已有zulufx8 paths，nested generated TestKit home无gradle.properties，独立配置域未继承发现属性。精确历史home为源码+时间推导，尚非运行采样；未执行javac/Gradle。Router接受最小环境恢复边界：仅图内本项生成TestKit目录，独占原两测试时临时提供现存JDK8 paths，finally恢复文件bytes/存在状态，不安装/改全局配置/换Java17/降低Java8，沿既有授权重验R03。原blocked与诊断旧包保留，R04/V01及审计未释放。

- `G1-I04E-R03` 网络恢复后重验 blocked：`codev-forge-r03-network-rerun` generation1完整Result已读取，报告（历史原件不可访问；见顶部保留说明）与默认只读verifier已核验exit0。原命令本次test实际执行，fresh XML tests=2/failures=2/errors=skipped=0：两个嵌套构建在compileJava.javaCompiler查询时ToolchainProvisioningException，未检测到Java8且无toolchain download repositories。HTTP502未再出现，configuration-cache stored不代表fixture通过。源码/config/test修改0，372本包、24335枚举文件、271inputs及十旧包匹配，Git/index保持且无活动wrapper/test。此blocked已应用，旧partial/HTTP502保持；先只读诊断现存Java8安装/工具链发现配置及嵌套TestKit环境，不安装/改配置/重跑测试，R04/V01及审计未释放。

- R03网络阻断诊断 completed：`codev-neoforged-network-diagnosis` generation1完整Result已读取并独立运行默认只读verifier（历史原件不可访问；见顶部保留说明） exit0，67份本包、24262枚举文件及271inputs/Git/index匹配。同Java17沿原Gradle user-home既有HTTPS代理配置对精确metadata端点HEAD/GET均200，XML可解析；默认curl/Java直连超时属于不同配置域，不能据其断言Gradle网络仍失败。历史502源站/中间网关归属及Gradle特定transport、后续artifact可达性未排除。局部恢复证据允许Router单独释放一次同环境R03重验，不改代理/repository/动态版本/cache；诊断未执行Gradle，网络200不代替TestKit或任何gate通过。

- `G1-I04E-R03` 新树重验 blocked：`codev-forge-fixture-r03-rerun` generation 1完整Result已读取，运行时completed仅表示终止。新报告（历史原件不可访问；见顶部保留说明）记录wrapper exit1：srgutils latest.release缓存版本信息过期后，NeoForged metadata HEAD收到HTTP502，解析access-widener compileClasspath时停止，configuration-cache discarded。原task/test实际0项，新XML/JAR/reopen均0，无源码配置修改，不推断fixture通过。Router默认只读verifier exit0：370本包文件、23884枚举文件、271实现输入及八旧封存包匹配，Git/index保全，无活动wrapper/test/fixture。原R03 partial保留；本次blocked已应用，不自动重试测试，先只读诊断远程端点及恢复前置，R04/V01及审计未释放。

- `G1-I04E-R02C` completed：`codev-forge-compile-repair` generation 1完整Result已读取并独立运行verifier（历史原件不可访问；见顶部保留说明） exit0；268份本包与历史3961/200/405/365/194/310/211项摘要匹配。仅ForgeRunsDefaultsContainer两imports增加，271输入after identity为`6044ede90315ca42796f7b7451ac303e64947a65b0a5446650cae90e4e3c2a9d`；119成员旧增量域完整可逆归档，160旧classes保持至自然重建。真实Forge compileKotlin full rebuild非FROM-CACHE/UP-TO-DATE、exit0，四ktlint实际重跑exit0且新报告空；configuration-cache compile stored/lint reused。Git/index与23644其他枚举文件保持，无活动wrapper/test/fixture。只释放R03新树重验，原R03和I04E partial及工具失败证据保留，R04/V01及审计未释放。

- R03编译阻断诊断 completed：`codev-forge-compile-diagnosis` generation 1 完整Result已读取并独立运行verifier（历史原件不可访问；见顶部保留说明） exit0；211本包文件与六旧包3961/200/405/365/194/310匹配，23470枚举文件与950选定ignored状态未变，271inputs和Git保全。隔离单变量实际编译确认两条漏imports及case-only rename+旧Forge增量状态为各自根因；FROM-CACHE观察排除为实际编译证明。真实项目尚未修复。图新增R02C，R02→R02C→R03→R04→V01，32节点/6Wave无环与引用验证通过；真实compile/lint通过前不重试R03或放行R04/V01，原partial和历史失败保留。

- `G1-I04E-R03` partial：`codev-mixin-i04e-r03` generation 1 完整 Result 已读取，运行时completed不代表outcome通过。报告（历史原件不可访问；见顶部保留说明）保存仅两个既有fixture build.gradle.kts的候选现存task/provider接线；原版本/toolchain/Java/settings/TestKit/JAR断言保持。真实原PatchedMinecraftTests过滤命令exit1，Forge compileKotlin先失败：ForgeRunsDefaultsContainer缺SourceSet/SourceSetContainer imports，SetupForgeRunsIntegration报Conflicting overloads（因果未建立），两生产路径当前字节与R02一致；原测试实际0项，归档旧2失败XML明确stale，没有fresh patch/remap/compileJava/JAR/reopen证明。Router默认verification.py exit0仅确认partial可信：310本包文件、旧3961/200/405/365/194包、271运行输入与精确双owner匹配，branch/HEAD/main/index保全、无活动wrapper/test。R02原ktlint/结构通过证据保留，但不据此认定新树可编译；追加编译根因诊断先确定最小补救边界，未启动源码修复或自动重试。R04/V01及审计继续锁定，旧I04E仍partial。

- `G1-I04E-R02` completed：`codev-mixin-i04e-r02` generation 1 完整 Result 已读取并接受。修复报告（历史原件不可访问；见顶部保留说明）记录26同路径样式修改及唯一setupForgeRunsIntegration.kt→SetupForgeRunsIntegration.kt大小写rename，共27文件；原94条/18规则逐条映射到四个本次空报告，四ktlint任务--rerun-tasks实际执行且exit0，configuration-cache reused。Router默认重跑verification.py exit0：194项本包封存与旧3961/200/405/365包匹配，22954枚举文件无授权外变化，271 inputs after identity `c22f868575ccce31c6f4cd0e724f1896c1902ea1ce39ff579dab88d297610ae5` 匹配，主动PSI比较27文件通过、R01四getter/五task声明保留、rename硬编码消费者未见且JVM facade不变；branch/refs/HEAD/main/index保全，diff-check通过，无活动wrapper/test/fixture。Windows固定树旧大小写key须唯一映射后比较，原hash保留；中间rename删除/恢复和ktlint/PSI失败均披露保留。结构和import namespace检查不替代typed resolution/production编译或runtime验收；只释放R03，R04/V01与审计继续等待，旧I04E仍partial。

- `G1-I04E-R01` completed：`codev-mixin-i04e-r01` generation 1 完整 Result 已读取并接受。修复报告（历史原件不可访问；见顶部保留说明）记录八个 owner 仅增加四个 getter PathSensitive、五个具体 task DisableCachingByDefault 及必要 imports；源码移除允许的声明后逐字匹配 before。Fabric/Forge validatePlugins 本轮实际执行且 exit 0，新原生 JSON 均为空，原11项ERROR消失。真实输入证明共10次Gradle exit0，四个getter/五个具体类型反射、provider自动依赖和JAR重开成立；9项XML仅为日志衍生harness receipt，不是原生JUnit。容器改名仍因继承rootSpec$1保守重执行，不承诺task可重定位缓存。Router重跑verification.py exit0：365项本包封存匹配、22604枚举文件仅八owner变化、271 inputs after identity `8dfd6dfd2e0f3107fc0d7f5f7ba0a51cd8bc95926c6eea3b30e1915ae3281231` 匹配，旧3961/200/405包不变；diff-check通过，branch/HEAD/main/index保持，无活动wrapper/test/fixture。实现与fixture开发失败保留；只释放R02，R03/R04/V01及W03-W06等待，旧I04E仍partial。
- 修复图准备 `codev-mixin-repair-graph` generation 2 completed：完整Result与独立verifier已接受，31item/6Wave、271inputs、原24图证据及旧包匹配；仅恢复完整Result，不重放generation1编辑。以下generation1失败记录只作历史，不覆盖generation2和R01的最新结果。

- 修复图准备任务 `codev-mixin-repair-graph` generation 1 的运行时状态为 failed：`pane_verification_failed`（herdr shim 无法创建 pane get 进程），join 未返回完整 Handler Result；不得记为 completed。子会话与当前文件确认四份派生文档及 静态图证据（历史原件不可访问；见顶部保留说明） 已写入。Router 随后只读执行 verify.py verify，exit 0：31 item/6 Wave 无环且引用完整，8 个注解 owner/27 个 lint 文件精确，271 个实现输入与三个原封存包（3961/200/405项）匹配，枚举范围仅四份协调文档变化，未发现活动 wrapper/test/fixture。以上只核验遗留图与保全，不替代失败任务的完整 Result；本次未自动恢复或重派，R01 及全部后继尚未启动/放行，原 I04E 仍 partial。

- 用户已确认“按计划完整执行”：创建 `g1/mixin-rework`、删除失效 `legacy-forge` include、实现并验证 G1 三模块、实际变更模块采用计划中独立 fork 版本；本阶段不得 stage/commit/merge/push/publish。D-SCOPE、D-BUILD、D-GIT-PREP 已满足，D-GIT-INTEGRATE 未授权。
- `G1-I01` completed：`codev-mixin-g1-prepare-branch` generation 1 完整 Result 已核对。当前分支 `g1/mixin-rework`，HEAD 与 main 均保持 `30d1d3d22267477db3275cb849e8692ada0f74de`；index 原始字节与条目不变，241 个 tracked 文件与八份 untracked 文档（共 249 文件）的路径、长度、SHA-256 均未变。证据在该任务完整 Result；未创建独立临时证据目录。此前协调记录及 I02 Handoff 的另一完整 SHA 是 Router 转录错误，非实际观测，归档已保留并披露该差异。
- `G1-I02` completed：`codev-mixin-g1-archive-pinned-proof` generation 1 完整 Result 已核对；持久证据包（历史原件已删除；原路径 `evidence/pinned-engine/README.md`）保存 51 份原样复制与九份辅助文件，逐项来源/hash、脚本解析和重建映射检查通过，未重跑实验。
- `G1-W01`、`G1-W02` 已释放。`G1-I03` completed：`codev-mixin-g1-build-prerequisite` generation 1 完整 Result 已核对；唯一配置修改为删除失效 `minecraft-codev-legacy-forge` include，Gradle 9.4.0 wrapper `help` 与三个 G1 模块 `compileKotlin` 实际通过，锁定 Mixin 不变、实际 ASM 9.6。`G1-I04` generation 1 返回 blocked（复合 outcome；未改代码/运行测试），已替换为串行 `G1-I04A → G1-I04B → G1-I04C → G1-I04D → G1-I04E`。`G1-I04A` completed：`codev-mixin-g1-core-acceptance` generation 1 完整 Result 已核对；固定核心 identity `b3fc39465460565a4f9a23d166dabd411d33952f160371f38d79740a692c520b`，R01–R08、R08 后 V01/V02 十份 Result 均 completed。核心 A1–A7、A11、A12 在既定 fixture 范围内 supported；V01 30/30、V02 mixins `check` exit 0。历史 partial/failed 与证据限制保留。核心验收时 I04B 已释放；平台、mapping、版本与组合验收的后续状态以各自完整 Result 记录为准。历史首次 `codev-mixin-g1-core-chain` Result 仍为 partial：5/5 测试、22 个模块文件摘要一致，但当时尚缺输入绑定、失败归属、隔离关闭、锁恢复、安全保留和 legacy/check。两次 `codev-mixin-g1-core-safety-repair` 均 `child_exited_without_result`；generation 2 留下代码和 `evidence/core-repair/`，没有完整 Result。归档 publication 首次 3/4（crash retry 输出被占用），module-check.exit=1（Kotlin compiler 1.9.10 下载超时）；恢复 XML 的 9/9 不覆盖这些历史失败。后继 R01–R08、新树 V01/V02 和 I04A acceptance 构成补证链，而非把旧 Result 改为 completed。原始核心报告（历史原件已删除；原路径 `evidence/core/README.md`）及全部历史证据只读保留。全部功能 A1–A12 / AC1–AC12 仍未完成。

- `G1-I04B` partial：`codev-mixin-g1-platform-adapters-i04b` generation 1 完整 Result 已关联并核对。平台报告（历史原件不可访问；见顶部保留说明）保存 9 个源码/测试/构建路径的未完成改动；实际归档 XML 共 5 tests / 1 failure / 0 errors / 0 skipped，四项 metadata 检查通过，真实 SERVER producer 错误应用 Fabric `environment:"client"` 的 ClientOnly（目标值 42，预期 1），仍发布 complete/selective SERVER records。诊断已确认 FabricMixinConfigHandler.kt:21–28,61–69 将外层 environment 丢失为纯 config path；OperationRunner、EngineOperation、RecordData 和 SelectiveConsumer 无法恢复该义务，错误配置随后可被选择性删除。历史真实 SERVER/错误消费复现为红，CLIENT 对照为 42；原始 partial 不改写为通过；R01 与独立 V01 已 completed，Router 已据 V01 重新接受 I04B，I04C 可释放，I04D/E 继续等待各自前置。

- `G1-I04B-DIAG` completed：`codev-mixin-g1-platform-environment-diagnosis` generation 1 只读 Result 已核对。诊断报告（历史原件不可访问；见顶部保留说明）保存 52 份脚本、日志、A/B JAR、records 和保全摘要；重算 11,528 个枚举文件零变化，未修改源码、测试、构建、权威、Plan/Waves/Todo 或 Git。诊断结论是核心需要统一 applicability-aware discovery/execute/registration/records/consumer，Fabric 负责 exact environment source；inactive-only 配置必须保留，不得因缺 records 删除。PRD/Spec/ADR 对已确认 side/scope/retention 契约可 reuse；UNKNOWN、Loader precedence 和新双侧承诺 blocked。诊断时 post-fix 尚未执行；后续修复证据见 R01，不以诊断直接放行 I04B。

- `G1-I04B-R01` completed：`codev-mixin-g1-platform-applicability-repair` generation 1 完整 Result 已读取并核对。修复报告（历史原件不可访问；见顶部保留说明）确认五个已有文件修改、两个新增文件；外层 environment 贯穿 discovery/execute/registration 与 schema 3 records/consumer binding，inactive-only 原字节保留，legacy 无 side 全删语义保持。原 SERVER 红测未修改，修复后返回 1，CLIENT 返回 42；最终八份 XML 共 26/26、零 failure/error/skipped。Router 只读重算 1226 份证据、11575 个 after 枚举输入、七路径身份及 baseline 保全，21 个 JAR/provider reopen 观察已关联；branch/main/index 保全、无活动 wrapper/test/fixture，diff check 通过。原失败、fixture 编译/工具失败及修复前 binary 限制保留。UNKNOWN/Loader precedence/任意 plugin 证明不新增；Forge仅 metadata compatibility smoke，未跑三模块 check 或全核心矩阵。旧核心 identity 与 acceptance 只作为历史结果，后续实际组合树必须重新验证；仅释放 I04B-V01。

- `G1-I04B-V01` completed：`codev-mixin-g1-platform-rerun-v01` generation 1 完整 Result 已读取并关联。其独立报告（历史原件不可访问；见顶部保留说明）接受 R01 后的显式 SERVER/CLIENT 平台矩阵；12 份 XML 共 49/49，零 failure/error/skipped（Fabric 9、Forge 2、shared core 30、独立补充矩阵 8），全部实际 Gradle/审计命令 exit 0。可比枚举 12,679 文件前后无漂移，tree 指纹 `0b29201b84a845c6daee7aac5876c805beed982935ed83dc85593378fff55dd5`，R01 七路径及实现闭包一致；494 个有效 JAR 已 reopen。旧 platform/diagnosis/repair manifests 共 1,324 条未变，新 dossier 1,944 项重核；枚举长路径限制、九个负向非完整 artifacts、验证工具失败与修正均披露。Router 据该独立 completed Result 重新接受 I04B，只释放 I04C；不宣称 UNKNOWN/Loader precedence、mapping、版本、三模块完整 check 或最终 G1 完成。历史 partial 与失败证据保留。首次环境诊断 Resolver 调用在启动前因缺少 reasoning/impact 被拒绝，无执行者或文件副作用。

- `G1-I04C` completed：`codev-mixin-g1-optional-mapping-i04c` generation 1 完整 Result 已读取，Router 接受 mapping 聚焦报告（历史原件不可访问；见顶部保留说明）。7 个既有文件修改、3 个新增，mapping-io 0.7.1 精确 adapter 接入 task/runtime/records 与有效 inputs，真实 native refmap→MemberInfo→environment remapper 链和 no-mapping 兼容已验证。最终五份 suite 共 20/20、零 failure/error/skipped，聚焦 ktlint exit 0。Router 重跑 verification.py exit 0，并按 tree-after.json 只读核对当前 14,514 个枚举文件与源码快照、branch/HEAD/main/index 均匹配；无活动 wrapper/test/fixture。14,235 份已枚举历史证据保全，未枚举长路径/gitignored 文件不声称全量覆盖。mapping dossier 没有 evidence-manifest.json，Router 对该假定路径的额外 hash 检查报错，实际 verifier 通过；重跑会重建其明确拥有的派生证据，不宣称全目录封存 manifest。历史编译/测试失败、attempt-05 stale XML 和线性扫描性能限制均保留。I04D 可释放，I04E 组合验收及 W03-W06 继续等待。

- `G1-I04D` completed：`codev-mixin-g1-module-versions-i04d` generation 1 完整 Result 已读取并独立运行 `check.py` exit 0；18,285 个可比文件中仅三个实际变更模块版本文件变化，18,006 个历史 evidence 保全，版本值、上游后缀、动态引用、branch/HEAD/main/index 均符合授权。
- `G1-I04E` partial：`codev-mixin-g1-final-i04e` generation 1 完整 Result 已关联；最终组合报告（历史原件不可访问；见顶部保留说明）记录两个三模块 check attempt 均 exit 1，7 个失败任务（Fabric/Forge validatePlugins、两模块 main/test ktlint、Forge test）。当前 XML：Mixins 36/36、Fabric 9/9、Forge metadata 2/2 通过；Forge PatchedMinecraftTests 0/2，嵌套脚本 unresolved references；此原始验收时没有独立基线对照，后续 completed Forge 诊断确认基线携带 fixture/API 错位，见下方诊断记录。11 组 bounded A/AC supported，A11/AC11 partially-supported，不满足 completionPredicate。Router 只读重算封存 manifest 3961 项与271实际inputs零漂移，diff-check exit 0，无活动wrapper/test/fixture；Handler开始结束18307项保全。独立审计、文档与W03-W06继续锁定，诊断后才确定修复边界。历史启动与恢复事实：首次过长 task slug 被启动工具拒绝（Invalid task slug），未启动；缩短后同范围准入及启动成功。此次仅验证最终 source/config/test 树，Router 后续同步协调文档不构成实现树变化。此前 `codev-mixin-g1-final-combination-i04e` generation 1 running 的 Router 说明缺少可关联启动回执或完整 Result，不能作为执行或通过证据。`codev-mixin-i04e-recovery-evidence` generation 1 已 completed：限定原会话/任务目录/本 Work evidence 搜索未找到 I04E Result，final 目录不存在；I04D 快照的 18,285 项中只有 Waves 状态文字变化，271 个非 docs 输入、18,006 个历史 evidence 与版本/Git identity 均匹配，未发现活动 Gradle/test/fixture。恢复核查不证明从未执行、不替代验收；仅解除恢复不确定性以供 Router 正式委派同范围 I04E，完整 Result 已读取但为 partial，不释放后继。

- I04E 失败诊断（非实现/验收重试）：`codev-mixin-check-diagnosis` generation 1 completed：诊断报告（历史原件不可访问；见顶部保留说明）定位六任务105项（11个validation ERROR、94条ktlint）；83项对应基线已有源码，22项由当前代码引入，源码归属不冒充基线新运行。Router默认只读重跑seal-diagnosis.py exit0，200项证据匹配，271输入校验记录无漂移；Plan/Waves窗口内文档变化已披露，未修改源码或运行Gradle。validation需在core/includes共享getter owner声明normalization，并在五个具体task明确禁用未证明的Gradle缓存；lint涉及27文件。诊断时Plan将shared modules限定只读，扩大范围当时需用户确认；该历史限制现由下节最新最小维护许可解除，诊断不是修复。`codev-forge-baseline-diagnosis` generation 1 completed：完整诊断（历史原件不可访问；见顶部保留说明）通过当前/宿主对齐基线两项失败复现、相同旧脚本、52个同名JAR身份与旧/现存符号红绿控制，确认基线已有的 fixture/API 错位；不证明 patch/remap 算法损坏。原基线需删除失效include、补现有JUnit launcher并对齐Java17宿主，全部隔离控制保留，未把未进入脚本的基线失败当因果证据。Router重跑 verify-causality.py 与 seal.py 均exit0，405项诊断证据匹配；Handler核对21977个原文件、271 inputs、3961项旧final封存及Git保全。最小修复为Forge两个integration fixture接入现有ResolvePatchedMinecraft task/provider与RemapTask，保留原版本和Java/JAR/patch/remap断言；真实项目未修复、AC11/I04E仍partial。两项诊断均已completed；尚未修源码。最新共享owner最小维护范围已明确授权，本次仅细化图；后续仍需新固定树全五模块check与完整矩阵，新Result方可重新接受I04E的outcome。

- `G1-I04A-R01` completed：`codev-mixin-g1-publication-crash-retry` generation 1 完整 Result 已核对；独立证据（历史原件不可访问；见顶部保留说明）与新测试 XML 确认 5/5（零 failure/error/skipped）、真实持锁/半成品子进程强杀后 fresh retry、活 owner 冲突、独立输出重叠及 writer/serialization/move/cancel/cleanup 失败恢复。仅 OperationPublicationTests.java 内容变更，生产代码沿用 generation 2 修复。Router 当前核对 82 个受测输入无漂移，verified.exit=0，branch/main/index 保全且无活动 wrapper/test/fixture。历史 core/core-repair 失败证据保留；R01 完成仅释放 R02，不释放 I04A 或平台节点。

- `G1-I04A-R02` completed：`codev-mixin-g1-input-binding` generation 1 完整 Result 已核对；独立证据（历史原件不可访问；见顶部保留说明）的 final-bound.exit=0、两类 XML 9/9（零 failure/error/skipped），匹配跨制品链与 relocation 正例、完整 inputs/order/side/scope/effective-options/engine/origin 拒绝、16 次实际 TestKit 子构建及 plugin body/resource 变更重执行已证明。Router 只读重算 86 个受测 inputs、296 个 fixture、468 个历史 evidence，均零漂移；branch/main/index 保全、无活动 wrapper/test/fixture，diff check 通过。未运行 module check 或重验 R01，mapping identity 为 none、task-only plugin 正例属 ordinary 路线；仅释放 R03，I04A 整体保持 partial。

- `G1-I04A-R03` completed：`codev-mixin-g1-failure-attribution` generation 1 完整 Result 已核对；独立证据（历史原件不可访问；见顶部保留说明）的 verified-final.exit=0、真实 engine 聚焦测试 10/10（零 failure/error/skipped）。精确 native identity/origin/stage/完整 obligations 与 provisional/committed 边界已验证；optional/required 阶段、后置处理/export/byte-generation 失败、不同 config 同 FQCN、unknown/private-access 拒绝均有 records 或诊断。Router 以只读方式重算 verifier 全部断言与归档派生数据，28 个模块输入、412 个 fixture、811 个历史 evidence 无漂移，branch/main/index 保全、diff check 通过。仅三处 Java source/test 变更，锁定 engine 未变；未运行 module check 或后续矩阵。仅释放 R04，I04A 整体仍为 partial。

- `G1-I04A-R04` completed：`codev-mixin-g1-operation-isolation` generation 1 完整 Result 已核对；6/6 真实聚焦测试通过，覆盖 17 次同 JVM 操作、顺序/并发隔离、task class/resource 域解析、引擎/ASM/服务闭包，以及 success/failure/cancel 后 TCCL、rename/delete 和 fresh retry 资源恢复。30 个模块输入、216 个 fixture、3418 个历史证据无漂移；独立 verifier 重算通过，branch/main/index 保全，无活动 worker。仅释放 R05，I04A 整体仍为 partial。

- `G1-I04A-R05` completed：`codev-mixin-g1-safe-retention` generation 1 完整 Result 已核对；9/9 真实测试通过，四个安全消费重开正例、无贡献 plugin/parent 保留与 residual/mixed/unknown/dynamic re-supply 拒绝有实际证明。此前 Router 已独立核验 4037 个历史证据及前序 R04 输入无漂移；I04A 整体仍为 partial。
- `G1-I04A-V01` 保持 partial：首次执行因缺少 cloche 路径段 blocked，无副作用；路径修正后 `codev-mixin-g1-core-verification-rerun` generation 1 返回完整 partial Result，29/29 通过，但 legacy StripMixins 全删除回归与真实 build-cache restore 缺失。历史 V01 证据只读保留，不用后续成功改写原 Result。
- `G1-I04A-R06` completed：`codev-mixin-g1-stripmixins-regression-rerun` generation 1 完整 Result 已核对；真实 JAR 回归 1/1 通过，两个 listing 配置被全量删除，target class/listing/其他资源保留，目标字节码摘要一致且 value() 返回 7。旧 TransformAction<TransformParameters.None> 入口兼容。全删除是删除配置与对应引用，不是撤销已预应用的目标字节码变换；此前 Router 对其含义的口头解释已据真实结果纠正。首次错误路径 blocked 与 Resolver pre-launch 拒绝保留，无副作用。
- `G1-I04A-R07` completed：`codev-mixin-g1-build-cache-restore` generation 1 保存的完整 Result 已读取并核验；首次空 disposable cache 构建 exit=0、无 test FROM-CACHE，清理 module outputs 后第二次相同命令 exit=0，明确 :minecraft-codev-mixins:test FROM-CACHE，恢复 JUnit 1/1、零 failure/error/skipped。当前 Router 只读核对 76 个输入及 30 份证据摘要全部匹配；branch/main 均保持基线、index 为空、diff check 通过。仅证明 focused LegacyStripMixinsTests restore，不代表全核心或模块 check 通过。
- `G1-I04A-V01` 修复前 completed 结果仅作为旧 identity `23bb1e…` 的历史记录保留；R08 后的新核心 identity 为 `b3fc39465460565a4f9a23d166dabd411d33952f160371f38d79740a692c520b`。新树 `codev-mixin-v01-after-r08` generation 1 已 completed：七个现有 suite 实际 30/30 通过，76 个核心输入无漂移，新专用 cache 首次执行后第二次 `FROM-CACHE` 恢复 focused Legacy suite 1/1；同树 V02 已通过，I04A 核心接受已完成。
- `G1-I04A-V02` 修复前 failed 结果仅作为旧 identity 的历史记录保留；`codev-mixin-g1-module-check-v02-after-r08` generation 1 已 completed：同新核心 identity 的实际 `:minecraft-codev-mixins:check` exit 0，七个 suite 30/30（零 failure/error/skipped），主源码与脚本 ktlint FROM-CACHE 且报告为空，Kotlin test lint NO-SOURCE/SKIPPED。旧 configuration cache 因 JAVA_HOME 变化未复用，本次 entry stored。Router 只读重算 565 个 evidence 文件与 76 个核心输入均匹配；branch/main/index 保全，无活动 wrapper/test/fixture。仅释放 I04A 核心接受，不直接放行 I04B-E。
- `G1-I04A-R08` completed：`codev-mixin-g1-ktlint-style-r08-rerun` generation 1 完整 Result 已读取；独立结果（历史原件不可访问；见顶部保留说明）确认三个实际诊断 Kotlin 文件的九条违规已修复，focused `ktlintMainSourceSetCheck` exit=0、零字节 report，configuration-cache 保持启用并 stored，未执行 broader check/compile/test。新核心 identity 为 `b3fc39465460565a4f9a23d166dabd411d33952f160371f38d79740a692c520b`；Router 只读重算 76 个核心输入均匹配，三个文件精确格式替换与行结束符检查通过。Handler 原 Result 记录 9633 个项目文件中仅三个源码变更、9362 个历史 evidence 无漂移，branch/main/index 保全。Router 随后重跑原 verifier 在 Git CRLF stderr 被 PowerShell 当异常处中止，已覆盖 R08 内四个派生文件（after.json、diff-warnings.log、formatting-equivalence.json、preservation.json），并重新生成 manifest；该 manifest 的 33 项当前摘要核对通过，但不可冒充 Handler 原始封存摘要。focused log/exit、formatting-only.diff、原始九条诊断、final-verification.json 与源码快照未改变；完整 Handler Result 保留。Router 的 Waves 状态与文件归属修正属于执行图变化，非核心树漂移。新树 V01/V02 已 completed，I04A 已接受，首次 R08 blocked 与历史 V01/V02 证据保留。

以下保留 G1-W03 与 I04A-E 的总体目标和确认范围，并细化 I04A 的修复/验证依赖；历史执行状态以上述记录为准，不构成新的授权。R01–R07 的局部结果与修复前 V01 固定树复验已完成，V01 原 partial Result 保留为历史；V02 旧树已真实失败，R08 后新树 V01/V02 已完成，I04A 核心接受已完成，I04B 已释放，I04C-E 依赖各自前序结果。

新树 V01 完整证据（历史原件不可访问；见顶部保留说明）已由 Router 只读重算：1234 个证据文件、76 个核心输入均匹配，七份 XML 总计 30/30。新 cache 两轮 Gradle exit 0；runner 缺少 snapshot 脚本使证据后处理 exit 1，随后补采并核对首轮前/第二轮后身份，没有两轮之间的单独输入快照。不得将后处理错误误报为 Gradle 失败或宣称中间快照存在；历史 evidence 的全量 before/after 哈希仅覆盖七 suite 完成后的 cache 阶段。

Router 当前核对的实际日志入口为 R08 focused ktlint（历史原件不可访问；见顶部保留说明）、R08 后 V01 七 suite（历史原件不可访问；见顶部保留说明）、缓存首轮（历史原件不可访问；见顶部保留说明）与缓存恢复轮（历史原件不可访问；见顶部保留说明）；文件均存在，不改写封存 README 或日志。

Plan 的功能完成 gate 为 `G1-W03`，独立审计为 `G1-W04`，ordinary docs 为 `G1-W05`；另外取得 exact Git 副作用授权后，`G1-W06` 才证明本地签名集成。W01/W02 仅是必要前置，不能宣称 Mixin 结果完成。完整 A1–A12 / AC1–AC12 尚未完成；已有局部观察见上述原始 partial 与失败记录。

## 核心修复细化与证据限制

组织原则是按独立可验收的安全缺口划分终止条件，共享 runtime/records/publication/fixture 写入串行；图中的 prerequisiteItemIds 才产生依赖。五个核心安全修复结果各带最小聚焦证明，另有 R06 旧入口回归、R07 focused cache restore 和 R08 九条 ktlint 样式修复；核心聚焦复验、module check 和 I04A 核心验收分别只读固定树。I04A-E 的核心、平台、mapping、版本、最终组合职责保留；细分图不扩大既定授权，也不把 I04A 的安全缺口移给平台/mapping。

- 首次核心 partial（历史原件已删除；原路径 `evidence/core/README.md`） 的 5/5 仅覆盖所列五项场景；完整输入/effective-options、origin、失败阶段、隔离关闭、crash-retry 与正例缺口仍需逐项验收。
- generation 2 比较（历史原件不可访问；见顶部保留说明） 是 22 个路径的 before/resumed hash 对照，仅 OperationPublication.java 的 equal 为 false；不是生成前后全量安全审计，也不涵盖未列出的新增文件或证明行为正确。
- 归档 publication XML（历史原件不可访问；见顶部保留说明） 明确 tests=4/failures=1，killedProcessReleasesLockAndRetryIgnoresMarker 因 Output is in use 失败。后续恢复构建 XML 的 9/9 为上述 Router 历史记录，本次没有重跑或将其升级为正式 Result；原始失败保留。
- module-check.exit（历史原件不可访问；见顶部保留说明） 为 1；原始日志（历史原件不可访问；见顶部保留说明） 显示 loadKtlintReporters 的 configuration-cache 保存期间，解析 ktlint 依赖 Kotlin compiler 1.9.10 下载 Read timed out。它证明该次 check 未通过；不能单凭此断定独立的 ktlint/configuration-cache 产品缺陷或当前网络仍不可用。

两次 child_exited_without_result、原 I04 blocked 与首次 I04A partial 不删除、不改写为 completed。修复新证据按 item 独立目录留存；历史 evidence/core 和 evidence/core-repair 只读保留。无需重新确认未变实现范围，但不得由本次文档细化恢复/重试 Handler 或突破 Git、权威、版本与平台/mapping 的 owning 边界。

I04A 仅在全部细分 completed Results、核心聚焦覆盖、同树 mixins check 成功及既定核心谓词共同满足后可接受；module check 环境阻断与行为修复失败分开报告。V02 不兼做 build 维护、禁用 configuration-cache/ktlint 或安装升级；环境恢复后成功 check 必须另有实际证据。I04B 已释放，I04C-E 依赖各前序结果；W03-W06 均未释放，W06 还缺 D-GIT-INTEGRATE。历史 I04E generation1 的实际三模块组合验收为partial；新的 I04E-V01 必须在五模块实际维护树重核完整矩阵及全部check，核心早期check和旧树通过不替代新验收。

## I04E维护扩大范围与新树重验

本节是此前check-repair-plan准备时的授权与图策略；最新生产恢复及依赖替换以下节为准，下面旧ready/未实施语句保留为历史准备观察。

最新用户 ask_response 已明确选择“授权最小扩展（推荐）”：core/includes 三个精确共享 getter 的注解维护、core=0.1.0+terrarium.0.7.2、includes=0.1.0+terrarium.0.6.5 和新增模块 check。记为 D-G1-MAINTENANCE 已确认，只作为本轮实施维护许可；PRD/Spec/ADR reuse 依据见 [Context](context.md#本次维护范围与逐-family-复用核对)。没有 shared 目录泛写权、shared ABI/includes identity/Mixin 行为变更、旧生产 DSL 恢复、缓存能力扩展、检查关闭、root/settings/依赖升级、其他模块或 Git 授权。

本次仅图更新，八个validation owners、27个lint文件及rename old/new、两个fixture脚本、两个新版本文件精确列在下面JSON `ownedProjectFiles/writeOwnership`。validation owners来自 105项诊断索引（历史原件不可访问；见顶部保留说明）/task-diagnostics.json，lint来自同目录summary.json；原规则和必要语义等价格式不能改成规则豁免。共享例外只有IncludesJar.input NONE、IncludedJarInfo.file NAME_ONLY、AddClientSideAnnotations.directory ABSOLUTE及必要imports/相邻格式；另GenerateMcpToSrg.mappings NONE、五具体task DisableCachingByDefault，不启用缓存或用Internal/CompileClasspath掩盖输入。Forge原fixture/断言与隔离限制见 因果报告（历史原件不可访问；见顶部保留说明），不复制诊断临时宿主控制到生产配置。

串行新增 `G1-I04E-R01 → R02 → R03 → R04 → V01`，每节点一位Handler/一份Result，最小聚焦证明属于该修复谓词。所有source/config/provider与Gradle/共享outputs冲突不并行。两completed诊断已映射为 `G1-I04E-DIAG-CHECK` / `G1-I04E-DIAG-FORGE`；补入既有 `G1-I04B-DIAG` 仅使原记录可引用，不新执行或重新接受。旧B/E partial节点保留历史身份/原Result；历史B-R01的原partial前提保存在historicalPrerequisiteItemIds，当前图用已完成core/诊断作为修复前提。新R01只依赖已完成I04D与两诊断，不依赖旧I04E completed，避免partial死锁；新V01依赖R04。禁止将历史Result改写为completed。

W03全部member仍保留；其`requiredCompletedItemIds`明确排除历史B/E原partial，用平台V01（已经Router重新接受B）和新I04E-V01（尚missing）承担新结果谓词。I05前提也改为新V01与B-V01；W04显式依赖W03，新V01 completed但任一必需gate/证据缺失仍不能释放。完整A1–A12/AC1–AC12、全五actual changed modules check及输入/cache/legacy/metadata/mapping闭环必须同新identity满足，旧局部PASS不自动转移。新证据每项写独立`evidence/g1-implementation/check-repair/<stable-id>/`，不写/重封旧final/两诊断包。

只报告图上下一structurally-ready项为G1-I04E-R01（I04D/两诊断已completed、维护范围已确认），不是Router dispatch/运行许可回执。本次没有委派、Todo、Gradle/formatter/tests、修复、接受或gate释放；R01–R04/V01均缺新Result，W03–W06与I05–I07仍未释放，D-GIT-INTEGRATE仍未授权。静态验证与保全见 独立check-repair-plan证据（历史原件不可访问；见顶部保留说明）。

## 最小Forge patch生产修复与独立重验

本节为历史 patch-repair-plan 准备说明；R03P/R03V/R04 现已 completed，当前后继与接受门槛以下面的 Post-V01 节及唯一 JSON 为准。


D-G1-PATCH-REPAIR 已由 supplied 用户“授权最小生产修复（推荐）”明确满足。该例外仅给 `minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt` / `ResolvePatchedMinecraft.kt` 和必要一份新局部 test `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/task/McpActionPatchTests.kt`；最后路径当前不存在，是未来输出。没有生产目录泛写权，没有fixture/Test.java/宿主断言/build/依赖/mapping方向/Java8/AT/nested政策或Git放宽。

JSON仍是唯一执行图，原32 stable item IDs和6Wave保留，新增三个节点，共35item/6Wave：DIAG-PATCH登记既有completed诊断；R03P交付共享完整输入恢复和7→8旧错误缓存域失效及最小聚焦证明；R03V交付修复后独立原双TestKit/真实patch-remap-Java8-JAR证明。每项只有一个Handler/Result及一个completionPredicate。R03的fixture接线原Result和全部partial/blocked保持historicalOnly，由新的R03V独立Result承担同一outcome在新树上的重验，不把partial作为completed前提或覆盖旧generation。

R02C已completed，与DIAG-PATCH共同作为R03P前置；R03P完成后才允许独立R03V考虑执行。R04原ID/两版本值保留，前置从旧R03换为新R03V completed；I04E-V01仍依赖R04，独立绑定最终五模块版本树。真实source/config/provider/Gradle/TestKit outputs共享写入必须串行，R03P仅最小聚焦证明、R03V只读固定源码、R04只版本、I04E-V01只最终验收，各新目录独占，旧diagnosis/manifests/snapshots不重封。

完整输入的行为要求是patch完成后、rename/mcinject前补齐clean缺失entries，patched bytes优先，未修改interface同namespace，覆盖既有placement/null sibling路径；移除晚期旧namespace clean回填责任，保持universal/inject/AT/marker。PATCH_OPERATION_VERSION当前真实7，最小计划7→8，以现存operationName机制避免复用forge-patch-7错误结果，不清共享缓存。新局部回归仅一文件且不写两原fixture。独立R03V保持原命令/原断言/版本/Java8，fresh XML实际2/2与basic definition/reference、remapped srg→named、compile/JAR/print闭环同时成立；沿既有generated TestKit home临时Java8发现规则在finally恢复原存在状态/bytes/hash，外部路径或工具不可用准确blocked，不偷改配置/源码。

W03的requiredCompletedItemIds排除历史B/E/R03的partial，包含新DIAG-PATCH/R03P/R03V；I04E-V01必须在R04最终固定identity上取得五模块check与完整A1–A12/AC1–AC12和原双TestKit实际2/2，旧PASS不自动继承。I05仍依赖新I04E-V01与W03 gate，W04–W06串行和D-GIT-INTEGRATE未授权状态不变。本次完成静态图不代表生产修复/独立复验/功能验收完成。

唯一第一structurally-ready候选是`G1-I04E-R03P`（R02C/DIAG-PATCH既有completed，D-G1-PATCH-REPAIR已明确授权）。这只是可审阅的结构事实；Router决定实际放行。本Handler不运行准备图、不调度/委派、不写Todo、不接受Result。来源、before/after/diff、互链/唯一性/无环/串行/owner/历史保全与限制见新证据（历史原件不可访问；见顶部保留说明）。

## Post-V01最小串行直接补证与独立终验

唯一 active continuation：`G1-I04E-P02(completed) → G1-I04E-R06A(missing) → G1-I04E-R06B(missing) → G1-I04E-R07(missing) → G1-I04E-R08(missing)`，再以W03 gate判断I05/I06。V02 partial与两诊断仅historical evidence；不是要求completed的串行边。V02 generation4 partial及其旧 continuation包只读保留；R06A/R06B/R07/R08是用户授权的新串行 continuation。I05仍依赖W03 gate，I06仍依赖W04；无item依赖其自身Wave gate。

| Item / verification | 唯一结果与真实耦合 | 精确写入 owner / 边界 | 前置与完成信号 |
| --- | --- | --- | --- |
| `G1-I04E-R05` / `VG1-POST-01` | 三声明维护并观察两个原生 validators；不兼 G1 测试或终验 | 以下三 class，仅 import/类注解；独立 R05 evidence | R04 已 completed；两 native `[]`、实际 rerun exit0、精确 diff |
| `G1-I04E-P01` / `VG1-POST-02` | 同 operation 的 producer/cache恢复、remapper状态和运行域/错误诊断闭包 | 以下四既有 test suites；installed fixture/TestKit；独立 P01 evidence | R05 completed；真实 FROM-CACHE→fresh consumer、same-JVM A/B、child engine/ASM 与三失败边界 |
| `G1-I04E-P02` / `VG1-POST-03` | 使用真实 producer 结果的精确 consumer 与 loader/provider/旧 API/保留基线闭包 | 下列消费端 test/resource owners；单个新 ForgeRetainedBaselineTests 为 planned output；独立 P02 evidence | P01 completed；精确/双目标完整删除、fresh Fabric、第三方拒绝+legacy、真实旧注册及非空 AT/nested 原行为 |
| `G1-I04E-V02` / `VG1-POST-04` | 历史最终五模块运行；generation4 partial只作为R06A/R06B/R07前置事实，不释放W03 | 无 source/test/config/version owner；旧及continuation evidence只读 | P02 completed；partial Result保留，不满足gate |
| `G1-I04E-R06` / `VG1-POST-05` | historical-only：generation1 blocked，两个独立outcome，执行前停止无副作用 | 原定义/身份只读历史 | 不在requiredCompleted门槛，不启动/重接受 |
| `G1-I04E-R06A` / `VG1-POST-05A` | 唯一32内容规则，保持语义/类型 | 原17sourceOwners已报告内容位置，三filename-only无需修改 | P02 completed/当前许可；compile0，原生lint预期1且恰余七filename，无其他违规 |
| `G1-I04E-R06B` / `VG1-POST-05B` | 唯一七命名迁移且API兼容，四fixed＋三默认实证 | 七原source/destination及四JvmName必要注解相邻格式 | R06A completed；完整compile/JAR/validators/lint0及旧binary链接；三case-only两步，不清/移走state/cache |
| `G1-I04E-R07` / `VG1-POST-06` | nested Forge basic/remapped compileJava真实执行及Java8 compiler/toolchain观察 | 仅PatchedMinecraftTests.kt nested argv增加--rerun-tasks；独立R07 evidence；fixture/production/断言只读 | R06B completed；原双TestKit 2/2、compileJava EXECUTED/SUCCESS、Java8 compiler绑定、属性finally恢复，缺fresh compiler则partial/blocked |
| `G1-I04E-R08` / `VG1-POST-07` | 当前最终identity五模块check、P01/P02必要闭包、Forge双TestKit与完整A/AC矩阵 | 只写新R08 evidence；不修源码/测试/配置/版本/Git | R06A/R06B/R07 completed；五check exit0、fresh XML零失败/错误/跳过、A1-A12/AC1-AC12逐行闭环，独立核验后才释放W03/I05 |

R05 精确 source owners（本准备全部只读，后继仅补 import/类注解）：

- [IncludesJar.kt](../../../minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt)
- [AddClientSideAnnotations.kt](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt)
- [CachedMinecraftTask.kt](../../../minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt)

P01 精确 test owners（就地补必要观察，共享既有 generated fixtures；不新增生产诊断 API）：

- [MixinPreapplicationTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java)
- [MixinInputBindingTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java)
- [MixinMappingTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java)
- [MixinFailureStageTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java)

P02 精确 test/resource owners（与 P01 共享部分已由 item 依赖串行；service/helper只用于隔离 fixture，不改变原 provider 默认语义）：

- [MixinPreapplicationTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java)
- [MixinSafeRetentionTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java)
- [MixinInputBindingTests.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java)
- `minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java`（历史 P02 owner，已退役）
- [FixtureMixinRule.java](../../../minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java)
- [net.msrandom.minecraftcodev.mixins.MixinListingRule](../../../minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule)
- [FabricApplicabilityRepairTests.java](../../../minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java)
- [FabricMixinMetadataTests.kt](../../../minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt)
- [ForgeMixinMetadataTests.kt](../../../minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt)

P02当时唯一新增测试输出是 `minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeRetainedBaselineTests.kt`，**原准备时不存在、为planned output；现已创建且当前只读，无新增baseline owner许可**。用既有 JUnit/Kotlin/JDK/installed AT 运行入口生成临时有界 JAR，检查非空 AT access 变化与 nested payload/原 JarJar handler/cleanup reopen，不复制实现。可读接点为 [ResolvePatchedMinecraft 的 TransformerProcessor.main](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt) 与 [ForgeJarJarHandler](../../../minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt)。原任务 wiring source/hash、P02 边界观察与最终五 check 中原 PatchedMinecraft 双 fixture共同闭合 touched baseline；不得将单 AT CLI 调用误称完整 Resolve task 或新 Loader 认证。

原 A1 明确要求“Register and execute old no-mapping Mixin and legacy StripMixins APIs”（Spec A1 / PRD AC1）。因此保留现有 direct legacy transformed-target 字节/行为证据，最小补证是同 suite 生成的真实 Gradle registerTransform + artifact resolution；不是新产品要求。AT/nested 原保留义务来自 Spec Authority and boundary / PRD Scope R10/AC11；证明可读原入口与 G1 前后普通能力/非Mixin payload保持，不把 audit 条件措辞扩成新政策。其余既有正向断言须按 Plan 的 closure facts 同树 fresh 复用，不给每断言建执行者。当前未发现需另写规范的实质不明确；后续若无法到达 baseline入口、来源或现有契约，准确 blocked 该覆盖，不泛授生产修复/依赖变更，也不削弱 gate。

V01 README 的 Fabric/Forge validator “FROM-CACHE”描述与实际 native log 冲突：原生日志优先，历史 README/manifest/package 不修改、不重封；该矛盾不充当当前 validator 或 matrix PASS。文中 Gradle 仅为后续授权节点的验证设计；原R05/P01/P02已completed、V02历史partial，当前R06A/R06B/R07/R08均missing，不在文档准备阶段运行。

## 准入、证据与冲突规则

每个 item 有且只有一个 observable outcome、一位独立 Handler 和一份完整 Result；数组中的 scope/evidence 是该同一结果的组成或证明，不是顺便交付的新结果。图按实际终止条件区分了 Git preparation、历史证据保存、build prerequisite、完整功能、独立审计、ordinary docs 和 Git integration，未按一个源码文件一个 item 拆分。

JSON 块是本文件唯一 item/Wave graph；Plan 不再复制一个步骤清单。stable IDs 用于显式 references。`predecessorWaveGates` 仅指先前 gate；`prerequisiteItemIds` 是 item 局部依赖，两者均必须满足。`externalPrerequisites` 以 Plan 的缺口表为依据，未取得不准执行；D-SCOPE 同时覆盖具体版本值。E-TOOLS/E-ENGINE 是执行时须验证的环境/机制风险，不伪装成已完成的外部前提。

活跃Wave的itemIds必须与requiredCompletedItemIds（未设时为全部itemIds）一致，历史项仅historicalItemIds。gate 只有在这些活跃完整成员和显式predecessor gates均由Router全读 **completed** Result、核对required evidence及releasePredicate后才成立；historicalOnly item仅为保留的旧Result，不成为活跃completed前提，所有member均须有明确处置。partial/blocked/failed/missing Result 不放行。item Result 必须报告实际路径、变更集/tree hash、实际验证及未做事项；审计必须绑定固定 tree；Git Result 必须给确切 repository/ref/index/commit/signature evidence。已核对的 completed Result 见上述当前执行状态。

同一工作区只允许已放行的 owner 写其明示路径。读同一 authority 不冲突；archive 与 settings maintenance 没有共享写路径，故 W02 两项可独立处理。Git preparation 先于任何项目写入；Git integration 最后独占 index/refs/working tree，无其他 writer/test process 并行。功能阶段不得并行编辑 shared records/capability 或 Fabric/Forge contracts；audit 期间 source/config/test tree 固定；ordinary docs 在 audit 后写，且不得改变被审计代码。如果后续需要代码修复或权限/图改变，Router 处理对应新 Handoff 与重验；不得由 audit/documentation item 偷修并自动放行旧 gate。

## 当前唯一可执行图（非历史）

以下是当前 source of truth；上面的原协调 prose 仅历史。R12已执行的rawpartial仅历史；R12A/W08→R13新主动链未实施，所有新项missing/not-run，门禁未释放；不创建第二graph。

```text historicalWavesGraph
{
  "historicalPreparationScopeRef": "confirmedRetirementScope",
  "scopeApplicability": {
    "confirmedRetirementScope": "historical preparation snapshot; executionAuthorized=false remains original; R14 has already ended partial, no reauthorization",
    "confirmedG3InPlaceRepairScope": "T0-history-only after four coordination updates; old repair/cleanup permissions are not reissued",
    "confirmedVanillaBaselineScope": "historical baseline contract; five Vanilla owners protected, six future delete-only owners superseded only by confirmedRetirementScope",
    "confirmedR12FirstReceiptException": "historical T0/attempt01 exception only; never permission to inherit current-tree identity or omit future receipt fields",
    "confirmedContinuationScope": "historical permission only",
    "confirmedTemporaryDisableScope": "historical permission only; no skip authorized on future retirement tree",
    "recordedR14LimitedCompletionContract": "Root accepted generation2 limited local completed; W09 prerequisite satisfied; original rawpartial/strictfalse/externalunknown preserved, not R13 authorization"
  },
  "work": "work.md",
  "plan": "plan.md",
  "waves": "waves.md",
  "externalDecisions": [
    "D-SCOPE",
    "D-BUILD",
    "D-GIT-PREP",
    "D-GIT-INTEGRATE",
    "D-G1-MAINTENANCE",
    "D-G1-PATCH-REPAIR",
    "D-G1-TASK-DECLARATIONS",
    "D-G1-CORE-JAVA8-CONTINUATION",
    "D-G1-JUNIT-LAUNCHER-CONTINUATION",
    "D-G1-CORE-BASIC-TEMPORARY-DISABLE",
    "D-G1-CORE-VANILLA-BASELINE",
    "D-G1-R12-ATTEMPT01-RECEIPT-EXCEPTION",
    "D-G1-CORE-TEST-RETIREMENT-CONFIRM",
    "D-R13-CROSS-TREE-CONSUMPTION-DECISION",
    "D-G1-R14-LIMITED-LOCAL-COMPLETION",
    "D-R13-FINAL-WINDOW-CONFIRM"
  ],
  "wavesGraph": [
    {
      "id": "G1-W01",
      "itemIds": [
        "G1-I01"
      ],
      "predecessorWaveGates": [],
      "incrementalOutcome": "具体授权下的非 main 功能工作空间，现有文档与 HEAD 基线保全",
      "releasePredicate": "I01 completed；新 branch/worktree 及保全检查明确，D-SCOPE 与 D-GIT-PREP 已有具体授权证据"
    },
    {
      "id": "G1-W02",
      "itemIds": [
        "G1-I02",
        "G1-I03"
      ],
      "predecessorWaveGates": [
        "G1-W01"
      ],
      "incrementalOutcome": "持久且可追溯的机制证据与已接受的可构建前置同时齐备",
      "releasePredicate": "I02/I03 均 completed；归档来源/hashes/限制可核验；选定 build diff 与基础配置/编译验证实际通过，未扩展 Loader 或全仓依赖"
    },
    {
      "id": "G1-W03",
      "itemIds": [
        "G1-I04A-R01",
        "G1-I04A-R02",
        "G1-I04A-R03",
        "G1-I04A-R04",
        "G1-I04A-R05",
        "G1-I04A-R06",
        "G1-I04A-R07",
        "G1-I04A-R08",
        "G1-I04A-V01",
        "G1-I04A-V02",
        "G1-I04A",
        "G1-I04B-R01",
        "G1-I04B-V01",
        "G1-I04C",
        "G1-I04D",
        "G1-I04B-DIAG",
        "G1-I04E-DIAG-CHECK",
        "G1-I04E-DIAG-FORGE",
        "G1-I04E-R01",
        "G1-I04E-R02",
        "G1-I04E-R02C",
        "G1-I04E-R04",
        "G1-I04E-DIAG-PATCH",
        "G1-I04E-R03P",
        "G1-I04E-R03V",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07",
        "G1-I04E-R13"
      ],
      "predecessorWaveGates": [
        "G1-W02"
      ],
      "incrementalOutcome": "G1 Mixin pair/消费者修复及完整矩阵；新vanilla功能前置由独立R12A/W08建立，R13承担唯一完整终验。旧R12和原历史partial成员显式非执行。",
      "releasePredicate": "所有当前requiredCompletedItemIds经Root真实完整结果/独立核验接受，W02/W08及Root已给W09前置成立；R13须统一确认后按分层合同完成同final272/最终tuple独立完整五check/24项/P01-P02/ABI/旧caller/Forge，新的final只读核验完整才判断。历史g3只按原T0真实default身份消费，不在272重跑；旧rawpartial/failed/unknown仍历史不满足completed，局部R14不替完整G1。I05/I06/Git独立门禁不自动放行。",
      "requiredCompletedItemIds": [
        "G1-I04A-R01",
        "G1-I04A-R02",
        "G1-I04A-R03",
        "G1-I04A-R04",
        "G1-I04A-R05",
        "G1-I04A-R06",
        "G1-I04A-R07",
        "G1-I04A-R08",
        "G1-I04A-V01",
        "G1-I04A-V02",
        "G1-I04A",
        "G1-I04B-R01",
        "G1-I04B-V01",
        "G1-I04C",
        "G1-I04D",
        "G1-I04B-DIAG",
        "G1-I04E-DIAG-CHECK",
        "G1-I04E-DIAG-FORGE",
        "G1-I04E-R01",
        "G1-I04E-R02",
        "G1-I04E-R02C",
        "G1-I04E-R04",
        "G1-I04E-DIAG-PATCH",
        "G1-I04E-R03P",
        "G1-I04E-R03V",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07",
        "G1-I04E-R13"
      ],
      "historicalItemIds": [
        "G1-I04B",
        "G1-I04E",
        "G1-I04E-R03",
        "G1-I04E-V01",
        "G1-I04E-V02",
        "G1-I04E-R06",
        "G1-I04E-R08",
        "G1-I04E-R09",
        "G1-I04E-R10",
        "G1-I04E-R12"
      ]
    },
    {
      "id": "G1-W04",
      "itemIds": [
        "G1-I05"
      ],
      "predecessorWaveGates": [
        "G1-W03"
      ],
      "incrementalOutcome": "固定功能 tree 的独立 read-only 审计结论",
      "releasePredicate": "I05 completed且独立结论通过；scope/prerequisites/requiredEvidence均绑定同一G1-I04E-R13新最终树全五check/24项、新vanilla及必要直接闭包证据，W03已释放；无重大未决缺陷/缺失正例，不以历史或partial替代，不兼修复/Git。"
    },
    {
      "id": "G1-W05",
      "itemIds": [
        "G1-I06"
      ],
      "predecessorWaveGates": [
        "G1-W04"
      ],
      "incrementalOutcome": "与通过审计的功能相符的消费者用法和结果文档",
      "releasePredicate": "I06 completed；旧入口/new selective/mapping examples 绑定真实 API 与验证；限制/版本/结果披露准确；代码 tree 与审计绑定一致；未编辑权威或 LLM 指令"
    },
    {
      "id": "G1-W06",
      "itemIds": [
        "G1-I07"
      ],
      "predecessorWaveGates": [
        "G1-W05"
      ],
      "incrementalOutcome": "另有授权的本地签名 Git 集成结果",
      "releasePredicate": "I07 completed；明确 staging scope、签名 commit 及 main 非覆盖式集成可验证，集成 tree 与通过审计/文档 tree 一致；无 reset、丢失原文档、push 或 publish"
    },
    {
      "id": "G1-W07",
      "itemIds": [
        "G1-I04E-R11"
      ],
      "predecessorWaveGates": [
        "G1-W02"
      ],
      "incrementalOutcome": "独立临时暂停原过期Basic测试，不构成G1功能/vanilla验收。",
      "releasePredicate": "仅R11完整completed及其精确单方法暂停/fresh4pass1skip证据经Router核验，才能满足本暂停Wave；当前未运行/未释放。该gate没有通向R10/W03/I05/I06/Git的release边，不代替R09原completion。",
      "requiredCompletedItemIds": [
        "G1-I04E-R11"
      ],
      "historicalOnly": true
    },
    {
      "id": "G1-W08",
      "itemIds": [
        "G1-I04E-R12A-R01",
        "G1-I04E-R12A-V01",
        "G1-I04E-R12A-F01",
        "G1-I04E-R12A-V02"
      ],
      "requiredCompletedItemIds": [
        "G1-I04E-R12A-R01",
        "G1-I04E-R12A-V01",
        "G1-I04E-R12A-F01",
        "G1-I04E-R12A-V02"
      ],
      "predecessorWaveGates": [
        "G1-W02"
      ],
      "incrementalOutcome": "同g3修复静态候选、独立静态审阅、一次真实功能封包及独立实际default完整证据，原failed/功能/保全分母保持；不是R13/G1完成",
      "releasePredicate": "仅原W02 gate/七基础有限accepted证据及新R12A-R01/V01/F01/V02各完整completed Result、精确保护/封包/完整实际default native0+空stderr/overalltrue在T0成立，经Router读取完整Results和独立证据、真实状态projection才release；准备/旧rawpartial/failed/missing/static native0不release；不依赖R13/W03/自身gate",
      "historicalItemIds": [
        "G1-I04E-R12A"
      ],
      "nonExecutionBoundary": "只派生图，不修改运行状态、接受Result/Todo或release；新四项尚未执行"
    },
    {
      "id": "G1-W09",
      "itemIds": [
        "G1-I04E-R14-V01"
      ],
      "requiredCompletedItemIds": [
        "G1-I04E-R14-V01"
      ],
      "predecessorWaveGates": [],
      "incrementalOutcome": "已接受有限R14局部完成合同的独立接受依据；旧生产partial保留，不是R13完整G1",
      "releasePredicate": "仅 G1-I04E-R14-V01 新完整独立只读Result按 r14-limited-local-completion-r01 主动有限分母经Router核验后才判断W09局部接受；六删除/当前272/fresh3及四闭包/负例/有限保护和命令产物绑定全部保留。仅接受三已发生偏差，原外部after永久unknown不再为主动完成分母；不称原窗原本合规/全缓存保全。旧R14 rawpartial及两个strict=false/native1不改、不作completed前置；本合同记录/static/旧失败/missing不release；分层消费方式已接受；R13单次许可/必需effects增量已接受；实际runtime/startup仍pending；Root已接受g2局部子门禁，但不释放完整W03/I05/G1、完整G1/Git门槛不降。",
      "historicalItemIds": [
        "G1-I04E-R14"
      ],
      "releaseStatus": "W09 prerequisite satisfied by Root Handoff g2 localcompleted; writer not re-releasing"
    }
  ],
  "items": [
    {
      "id": "G1-I01",
      "waveId": "G1-W01",
      "handler": "一个 git-workflow Handler；只交付工作空间准备",
      "resultCount": 1,
      "objective": "在具体授权下从当前 Codev 基线创建并验证独立功能工作空间",
      "scopeAndEffects": [
        "仅 E:/Projects/cloche/minecraft-codev；拟 g1/mixin-rework 或具体授权名称；以实际当前 HEAD 为起点",
        "只创建/选择授权功能 branch/worktree，保留 existing tracked/untracked docs；不作 commit/merge/reset/stash/clean 或改文件",
        "若目标 branch 已有或 dirty tree 不安全，返回实际 blocker，不覆盖、不清理"
      ],
      "prerequisiteItemIds": [],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-GIT-PREP"
      ],
      "writeOwnership": [
        "仅授权 Codev local branch/worktree refs 与工作空间选择"
      ],
      "conflicts": [
        "任何同仓库 Git refs/index 操作与项目 writer；必须先于 I02/I03/I04"
      ],
      "completionPredicate": "功能工作空间可独立修改且原 HEAD/refs/文件内容保持符合具体授权，未在 main 编码",
      "requiredEvidence": [
        "确切 repo/branch/worktree/base HEAD 与授权范围",
        "before/after refs/status/index 与已有文档 hashes，既有 main 未被覆盖"
      ],
      "verification": [
        "只读 rev-parse/branch/status/ls-files 和文件 hash 比较；不运行 build"
      ],
      "authority": [
        "Plan D-SCOPE/D-GIT-PREP；supplied local Git restriction"
      ]
    },
    {
      "id": "G1-I02",
      "waveId": "G1-W02",
      "handler": "一个 implement-change Handler；仅 historical evidence 留存",
      "resultCount": 1,
      "objective": "将 supplied pinned-engine scratch 证明保存成有来源、hash 与限制的持久证据包",
      "scopeAndEffects": [
        "从 exact Temp proof 路径读取；只写本 Work 的 evidence/pinned-engine/，不改 scratch/source/authority",
        "保存 report、fixture src/resources/run.ps1/invocation、成功/失败尝试 logs/exits、输出 class/disassembly、pinned-javap、执行/provenance/evidence hashes 与来源重建说明",
        "第三方依赖以 exact coordinate/source/hash/重建命令记录；不默认全 binary vendoring，不重跑机制或完成 G1 验收"
      ],
      "prerequisiteItemIds": [
        "G1-I01"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/pinned-engine/**"
      ],
      "conflicts": [
        "同 evidence 目录 writer 与任何 Git staging/integration；可与 I03 并行，二者不写同路径"
      ],
      "completionPredicate": "持久包可核对原机制来源与 hashes、重建 fixture，并准确保留 Good/Bad、私有 API 差异、残留及有限适用范围",
      "requiredEvidence": [
        "归档路径清单与源/副本逐项 hash 比较",
        "报告限制、依赖重建来源与 original/transformed 对照完整",
        "明确没有新的 runtime 验收与没有重新运行 scratch"
      ],
      "verification": [
        "文件存在/hash/链接与 script 相对路径可重建核查；本项不运行引擎"
      ],
      "authority": [
        "Spec pinned-engine P1-P2、ADR S10；Plan evidence retention"
      ]
    },
    {
      "id": "G1-I03",
      "waveId": "G1-W02",
      "handler": "一个 implement-change Handler；仅已选择的 build prerequisite",
      "resultCount": 1,
      "objective": "落实已接受的缺失 legacy-forge 声明维护选择并证明 G1 所需基线可配置编译",
      "scopeAndEffects": [
        "只执行 D-BUILD 选定的 settings.gradle.kts diff；选择尚未取得时不得开始本项",
        "不创建 legacy Forge 实现，不升级 Gradle/engine/core deps，不擅改 root settings/build 修复别的失败",
        "允许必要 build/.gradle/测试临时输出；现有 launcher/Java 11 不可用或额外错误超界时准确报告 blocker"
      ],
      "prerequisiteItemIds": [
        "G1-I01"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-BUILD"
      ],
      "writeOwnership": [
        "settings.gradle.kts 中具体接受的 legacy-forge 维护区域",
        "Gradle 自有 build/.gradle temporary outputs"
      ],
      "conflicts": [
        "其他 settings/build 配置 writer、同 workspace Gradle invocation 与 Git 操作；可与只写独立 evidence 的 I02 并行"
      ],
      "completionPredicate": "所选最小维护准确实现，Gradle 9.4.0 下 root 配置与三个 G1 module 基础编译实际通过且 toolchain/resolve 事实可查",
      "requiredEvidence": [
        "D-BUILD 选择/理由/授权与 exact diff",
        "launcher/JDK11 与 resolved Mixin/ASM closure 事实",
        "真实 help/基础编译命令及 exit/log；未改变未授权模块或 Loader 政策"
      ],
      "verification": [
        "Codev wrapper help",
        "Codev wrapper :minecraft-codev-mixins:compileKotlin :minecraft-codev-fabric:compileKotlin :minecraft-codev-forge:compileKotlin --stacktrace；本项只验证当前基线不宣称 A1-A12"
      ],
      "authority": [
        "Plan D-BUILD；Context 当前 settings/toolchain 静态证据"
      ]
    },
    {
      "id": "G1-I04A-R01",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本项安全修复及其最小聚焦证明",
      "resultCount": 1,
      "objective": "跨进程 crash-retry 的输出所有权与完整发布",
      "scopeAndEffects": [
        "仅修复 OperationPublication 及其必要局部调用/聚焦测试：强制终止持锁子进程后，fresh retry 可取得该输出并形成有效 target/records pair；存活 owner 的同输出竞争仍拒绝或独占",
        "覆盖旧 marker、writer/serialization/第二次 move/cleanup 失败与取消；旧/half pair 不作为当前成功，独立输出可重叠；不引入 G3 shared cache/lock 或 process-isolation 架构"
      ],
      "prerequisiteItemIds": [
        "G1-I02",
        "G1-I03"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项必要局部代码/tests/resources；build.gradle.kts 仅本项确需的既有测试接线",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R01/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "真实子进程持锁被强制终止后 retry 与 clean run 语义一致且 consumer 不接受 stale/half pair，活 owner 冲突仍安全；本项全部 publication 聚焦断言通过",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "归档 killedProcessReleasesLockAndRetryIgnoresMarker 的失败 3/4 原件与新结果分开；新进程生命周期、锁持有/退出/取得观察及有效 pair hashes"
      ],
      "verification": [
        "真实跨进程 crash/retry + 同输出冲突/独立输出重叠 + publication fault/取消的最小聚焦检查"
      ],
      "authority": [
        "Spec C2-C4/A4-A5/A11；PRD R2/R6；原始 core publication 缺口"
      ]
    },
    {
      "id": "G1-I04A-R02",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本项安全修复及其最小聚焦证明",
      "resultCount": 1,
      "objective": "完整输入与 effective-options 的生产消费绑定",
      "scopeAndEffects": [
        "仅修复 task 输入、OperationRunner/EngineOperation/RecordData/SelectiveConsumer 的必要局部接线：ordered runtime classpath、原 target/config artifact 内容、side/mode、effective inherited engine options、engine identity 与当前已实现的执行 scope 均跟踪并由 consumer 校验",
        "config/plugin/refmap 跟随真实 recorded origin；同名 distinct origins 无法无歧义支持时明确失败；移除未跟踪 host/working-directory fallback，保留 task 域解析顺序",
        "mapping 尚未实现的字段/模式不得伪造通过；现有 binding 契约须给 I04C 的 mapping 接线保留既定要求，不在本项实现 mapping"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R01"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项必要局部代码/tests/resources；build.gradle.kts 仅本项确需的既有测试接线",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R02/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "真实不同 artifact producer→consumer matching chain 通过，逐一替换/重排输入、source/target/records、side/scope/options 均拒绝不匹配；只改插件 body/resource/effective input 的 TestKit 重执行及 origin 断言通过",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "绑定字段与有效配置来源、消费者实际期望值/哈希；逐项 tamper/order/body/resource/input-change 观察及 configuration-cache 存储/复用记录",
        "task-only plugin/refmap origin、host 同名资源及重复 origin 拒绝证据；未实现 mapping 覆盖明确留给 I04C/E"
      ],
      "verification": [
        "真实 JAR/TestKit 的 binding/origin 聚焦正负例；禁止仅修改 records 后自证匹配"
      ],
      "authority": [
        "Spec C2-C4/A3/A5/A11；PRD R3-R4；core binding/origin 缺口"
      ]
    },
    {
      "id": "G1-I04A-R03",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本项安全修复及其最小聚焦证明",
      "resultCount": 1,
      "objective": "失败阶段、来源与实际成功的精确归属",
      "scopeAndEffects": [
        "仅修复 pinned adapter、EngineOperation 与 records 的必要失败归属：config origin/entry kind/FQCN/target/obligations/stage/cause/residual 保持精确，不以同名集合串属",
        "覆盖 create-context、适用 applicator passes、final postApply validation、后置 processor/export/byte generation 和 required/optional 路径；callback 仅 provisional，transformer/publication 完成才 committed",
        "private access/native identity/义务不完整或非 native 归属未知时 selective 明确失败；ordinary 保留原生 optional，拒绝不得替代必须支持的普通 class 正例"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R02"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项必要局部代码/tests/resources；build.gradle.kts 仅本项确需的既有测试接线",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R03/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "各要求阶段的真实失败 fixture 不产生错误 committed success，同 FQCN/不同 config 不串属；Good/Bad ordinary 与 selective 残留拒绝、required 失败及未知归属保守失败均有精确 records/诊断且聚焦检查通过",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "逐阶段 fixture→native cause/origin/target/residual→provisional/committed 状态映射；完整 obligation 集合及明确支持边界",
        "pinned binary/private surface/engine CodeSource 核对；回调后失败未提交及反射 wrapper 底层 cause 保留观察"
      ],
      "verification": [
        "锁定引擎真实 failure-stage/identity/obligation fixtures；candidate/postApply/byte-diff 单独不作成功授权"
      ],
      "authority": [
        "Spec C3-C5/A4/A7/A12；PRD R4/R6；ADR private-adapter revisit"
      ]
    },
    {
      "id": "G1-I04A-R04",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本项安全修复及其最小聚焦证明",
      "resultCount": 1,
      "objective": "操作隔离、任务域解析与所有资源关闭",
      "scopeAndEffects": [
        "仅修复 operation loader/service/properties/runtime 与局部退出清理及其聚焦 fixtures；R01 已处理输出 ownership，本项不另创锁策略",
        "同 JVM 顺序 A/B、独立输出并发 A/B 对照 serial；plugin static/config/side/metadata/extension state 不交叉；task-only plugin/依赖的 class/byte/resource 同域且声明顺序一致，竞争 service 不替换 coherent engine/ASM",
        "success/failure/cancel 后 TCCL 恢复，loader/streams/ZIP filesystem 关闭且临时路径独立，可 rename/delete 实际拥有资源；不是任意插件全局副作用 sandbox"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R03"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项必要局部代码/tests/resources；build.gradle.kts 仅本项确需的既有测试接线",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R04/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "同 JVM 与并发真实操作与 serial 结果一致，任务域及竞争 service 断言通过，三个退出路径均恢复 TCCL 并可 rename/delete 拥有资源，后继 fresh operation 不继承状态",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "plugin/static marker、class/resource/CodeSource、A/B 输出行为与 serial 对照；三类退出及同 JVM retry 的资源关闭观察"
      ],
      "verification": [
        "真实 operation isolation/domain/resource fixtures，包含取消；不以独立 scratch JVM 证明隔离"
      ],
      "authority": [
        "Spec C2-C3/A2-A4/A12；PRD R2-R3；core isolation/close 缺口"
      ]
    },
    {
      "id": "G1-I04A-R05",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本项安全修复及其最小聚焦证明",
      "resultCount": 1,
      "objective": "安全 untouched 与无贡献 plugin/parent 保留正例",
      "scopeAndEffects": [
        "仅修复 completeness/retention 与 mixins-local selective consumer 必要局部行为及真实 fixtures；不实现 Fabric/Forge adapter",
        "同 target 上 fully consumed Foo 与独立且证明 never-attempted/wholly-untouched Bar：只删 Foo，保留 Bar 及未知字段/package/refmap/资源；不能以 missing record 或整 target bytes 相等证明 untouched",
        "安全 plugin 和 parent 各自无 pre-applied contribution、无 unsafe failed attempt 的配置完整保留；已预应用项可能再供给、mixed targets/unknown obligations/known-or-unknown residual 继续拒绝",
        "不引入普适任意插件证明/rollback/runtime exclusion；若声明 failed-no-residual retention，另给覆盖所有 obligations 与 runtime retention 的支持证据，缺失则不得声称支持"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R04"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项必要局部代码/tests/resources；build.gradle.kts 仅本项确需的既有测试接线",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R05/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "真实 producer 产生安全证据，consumer reopen 证明同 target untouched 正例以及无贡献 plugin/parent 正例保留且 consumed exact entry 删除；unsafe re-supply/residual/mixed/unknown 仍拒绝不发布，聚焦正负例通过",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "真实 target 调用/字节码、完整 obligations 与未尝试独立性证据、records 与 reopen JSON/资源观察；plugin 与 parent 正例分别可定位",
        "安全无贡献与动态再供给拒绝边界，普通 optional Good/Bad 语义保留；不得用手写 records 替代 producer"
      ],
      "verification": [
        "小型真实 JAR 的 untouched/plugin/parent 正例和已有安全拒绝回归"
      ],
      "authority": [
        "Spec C4-C5/A6-A7；PRD R5-R6；core safe-retention 正例缺口"
      ]
    },
    {
      "id": "G1-I04A-R06",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅旧 StripMixins 全量清理回归结果",
      "resultCount": 1,
      "objective": "补齐历史 V01 partial 暴露的旧 StripMixins 全量清理回归",
      "scopeAndEffects": [
        "只写 mixins tests/必要局部修复与本项独立证据；真实 JAR 验证全部列出配置被删除、target class/listing/其他资源保留及旧入口兼容，不撤销已预应用字节码",
        "不改平台/mapping/版本/权威/Git，不运行 module check 或兼做 cache restore"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R05"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中本项局部代码/tests",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R06/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "同 workspace writer、Gradle invocation 或 Git；必须串行"
      ],
      "completionPredicate": "真实旧入口全量清理回归通过，全部列出配置删除且目标字节码和保留资源符合旧契约，完整 Result 可核验",
      "requiredEvidence": [
        "完整 Result、changed set、实际命令/exit/XML、输入输出 JAR 条目及 target class 摘要/实际执行结果；历史 blocked/编译错误/V01 partial 保留"
      ],
      "verification": [
        "LegacyStripMixinsTests 真实 JAR/TestKit 聚焦回归"
      ],
      "authority": [
        "既有 Plan/Spec 旧入口兼容要求；历史 V01 partial 的 legacy 覆盖缺口"
      ]
    },
    {
      "id": "G1-I04A-R07",
      "waveId": "G1-W03",
      "handler": "一个验证专用 Handler；仅 focused build-cache restore 证据结果",
      "resultCount": 1,
      "objective": "证明 focused Gradle build-cache 实际恢复",
      "scopeAndEffects": [
        "冻结 R06 后 source/config/tests，使用 disposable build-cache，首次执行后清理模块输出并用同命令恢复；仅写本项独立证据和 temporary outputs",
        "不改生产行为/tests/build/平台/mapping/版本/权威/Git，不运行 module check；focused restore 不等于全核心验收"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R06"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R07/**",
        "本项 disposable cache/build/test temporary outputs"
      ],
      "conflicts": [
        "同 workspace writer、Gradle invocation 或 Git；固定树串行验证"
      ],
      "completionPredicate": "首构建实际执行、清理输出后第二次 test FROM-CACHE 且均 exit 0，恢复 XML 和输入/证据摘要完整匹配，完整 Result 可核验",
      "requiredEvidence": [
        "完整 Result、两次 exact commands/logs/exits、真实 test FROM-CACHE、恢复 XML、cache 身份和固定输入/证据摘要；历史 V01 partial 保留"
      ],
      "verification": [
        "LegacyStripMixinsTests focused build-cache restore，不替代 V01 或 V02"
      ],
      "authority": [
        "既有 Plan 核心 cache 验收要求；历史 V01 partial 的 restore 覆盖缺口"
      ]
    },
    {
      "id": "G1-I04A-R08",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅九条 ktlint 样式修复结果",
      "resultCount": 1,
      "objective": "修复 V02 实际 check 报告中的九条 Kotlin 样式违规，保持行为和全部检查设置",
      "scopeAndEffects": [
        "仅修改 V02 指出的 Kotlin 文件的 import/排序/换行，保留所有未提交实现，不改变控制流、API、运行选项或 dependency",
        "写独立 R08 evidence；不改测试/build/平台/mapping/版本/权威/Git，不冒充新树 V01/V02 完成"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R07"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/StripAppliedMixins.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-R08/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "同 workspace writer/Gradle invocation/Git；必须串行"
      ],
      "completionPredicate": "V02 failed 已保留，九条违规全部修复，existing ktlintMainSourceSetCheck exit 0；最小 diff 仅样式及显式等价 imports，完整 Result/新核心输入 identity 可核对",
      "requiredEvidence": [
        "V02 原始 log/exit/reports 身份、精确变更集与 before/after hashes、focused ktlint 命令/log/exit 和等价性说明；历史 evidence 与 branch/main/index 保全",
        "新输入身份和后续 V01/V02 重验边界；不降低检查或行为要求"
      ],
      "verification": [
        "既有 :minecraft-codev-mixins:ktlintMainSourceSetCheck --stacktrace；不关闭 configuration-cache/ktlint"
      ],
      "authority": [
        "已确认 G1 范围及既有 Plan 模块 check 门禁；V02 九条实际样式错误，PRD/Spec/ADR reuse，无行为变更"
      ]
    },
    {
      "id": "G1-I04A-V01",
      "waveId": "G1-W03",
      "handler": "一个验证专用 Handler；只交付本项固定树验证结果",
      "resultCount": 1,
      "objective": "固定核心树的聚焦复验",
      "scopeAndEffects": [
        "只读 R01-R08 最终 mixins source/config/tests；写本项 evidence 和验证 temporary outputs，不修代码、不写版本/平台/mapping/权威/普通文档/Git",
        "聚焦复验全部核心契约、旧 Mixin/StripMixins legacy/empty 正例、不同 artifact chain、negative binding/失败/安全拒绝、TestKit configuration-cache store/reuse 与 input changes/build-cache restore/cancel/retry/fault",
        "历史 5/5、归档 3/4 和恢复后 9/9 都仅是旧观察；仅在输入与当前固定树及覆盖关系明确时复用，不补造 Result；本项不运行全 module check"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R08"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-V01/**",
        "本项验证工具拥有的 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "固定核心树上全部必需核心聚焦验收行（A1-A7/A11/A12 的核心范围）有可追溯实际通过证据、legacy 回归通过且无未处理核心缺口；平台/mapping/最终组合覆盖明确待 I04B/C/E",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "R01-R08 每份 completed Result 与 fixture/log/exit/records/artifact 到核心矩阵映射；冻结 source/config/test hashes 与所有复用证据的输入一致性",
        "actual scoped suite/method 清单与 legacy/cache-restore 等缺项定位；suite 总数不能替代覆盖"
      ],
      "verification": [
        "实际存在的核心 JUnit/TestKit 聚焦 suites（含 MixinPreapplicationTests/OperationPublicationTests 与修复新增 fixtures），不修复失败、不宣称完整 A1-A12"
      ],
      "authority": [
        "Plan 核心行为矩阵；Spec A1-A7/A11-A12；核心复验独立于修复"
      ]
    },
    {
      "id": "G1-I04A-V02",
      "waveId": "G1-W03",
      "handler": "一个验证专用 Handler；只交付本项固定树验证结果",
      "resultCount": 1,
      "objective": "固定核心树的 Gradle module check 门禁",
      "scopeAndEffects": [
        "只读 V01 核心树，在现有 Gradle/JDK/依赖环境运行 mixins check；只写本项 evidence 和工具 temporary outputs，不改 build/source/tests/版本/权威/Git",
        "精确保留既有 ktlint configuration-cache 序列化期间 Kotlin compiler 1.9.10 下载超时及 exit=1；此证据不等于确定 ktlint 产品缺陷",
        "依赖/工具链不可用返回 blocked；实际技术失败返回 failed 或有用不完整结果 partial；均不得完成/放行。不关闭 configuration-cache、禁用 ktlint、安装升级依赖或顺带修根 build"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-V01"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/core/G1-I04A-V02/**",
        "本项验证工具拥有的 build/test temporary outputs"
      ],
      "conflicts": [
        "共享 core records/runtime/publication/测试与 build 配置可能交叠；修复和验证严格按 prerequisiteItemIds 串行",
        "同 workspace Gradle invocation、其他 source/config/test/evidence writer 与任何 Git 操作；验证期间冻结核心树"
      ],
      "completionPredicate": "同 V01 固定树的 :minecraft-codev-mixins:check 在既有 configuration-cache 配置下 exit 0 且全部要求检查通过；否则门禁未满足，准确记录 blocker/failure",
      "requiredEvidence": [
        "完整 Handler Result；确切 changed set/固定输入树 hashes、命令/退出码/原始日志、fixture 与产物/records hashes、实际 engine/ASM CodeSource；未执行与不支持项明确列出",
        "只读取并保留 evidence/core/**、evidence/core-repair/** 历史原件；新证据写独立 item 目录，不以旧 green/XML 或源码 diff 替代本项验证",
        "exact wrapper command/exit/完整日志、JDK/Gradle 与依赖/ktlint resolution；固定树 hashes 与 V01 一致",
        "历史 module-check.exit=1 与 module-check.log 保留；若下载恢复，须由新的完整 Result/成功日志证明，不由旧 focused PASS 推定"
      ],
      "verification": [
        "Codev 根 .\\gradlew.bat :minecraft-codev-mixins:check --stacktrace；本图本次只规划，未运行"
      ],
      "authority": [
        "Plan 全模块 check 门禁；Spec C3 configuration-cache；归档 module-check 阻断"
      ]
    },
    {
      "id": "G1-I04A",
      "waveId": "G1-W03",
      "handler": "一个验证/证据汇总 Handler；仅接受核心预应用与记录消费结果，不兼做修复",
      "resultCount": 1,
      "objective": "实现 mixins 内 operation-local producer→records→selective-consumer 核心链，保留旧入口",
      "scopeAndEffects": [
        "保留 I04A 核心总体目标与既定行为边界；仅核验 R01-R08、V01、V02 完整 Results 与固定核心树证据，写本项核心验收 evidence",
        "历史 partial 及两次 child_exited_without_result 仍保留，不将 generation 2 遗留修改或恢复后 green XML 升格为 completed",
        "不修改 source/config/tests/build/平台/mapping/版本/权威/普通说明/Git；缺口返回真实 partial/blocked/failed，不在验收中修复"
      ],
      "prerequisiteItemIds": [
        "G1-I04A-R01",
        "G1-I04A-R02",
        "G1-I04A-R03",
        "G1-I04A-R04",
        "G1-I04A-R05",
        "G1-I04A-R06",
        "G1-I04A-R07",
        "G1-I04A-R08",
        "G1-I04A-V01",
        "G1-I04A-V02"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/core/acceptance/**"
      ],
      "conflicts": [
        "整个被验收核心树及 evidence 固定，无代码/test/build/Git writer 并行；I04B-E 仍仅可后继串行"
      ],
      "completionPredicate": "R01-R08、V01、V02 全部有经 Router 核对的 completed Result，固定核心树满足既定核心正例/精确成功/安全拒绝/旧入口兼容/输入绑定/隔离关闭，mixins check 通过且无未决核心缺口；平台/mapping 仍分别由 I04B/C 完成",
      "requiredEvidence": [
        "逐项完整 Result 与固定 tree/inputs hashes 一致性；V01 核心矩阵、V02 check exit 0/log，缺一不接受",
        "原始 partial、两次 Handler failure、归档 crash-retry 失败/module-check 阻断及后续观察并存，明确 superseding 证据链",
        "核心 A1-A7/A11/A12 范围及留给 I04B/C/E 的覆盖边界，不宣称完整 G1"
      ],
      "verification": [
        "只读核对各 Result/固定树/覆盖/成功 check；无需再次无理由重跑聚焦 suites，不修复代码"
      ],
      "authority": [
        "既有 Active PRD/Spec 和 Accepted ADR；本 Plan 核心行为矩阵"
      ]
    },
    {
      "id": "G1-I04B",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅平台 metadata 消费结果",
      "resultCount": 1,
      "objective": "让 Fabric/Forge 平台通过 I04A 的 capability 精确消费已耗尽配置引用",
      "scopeAndEffects": [
        "只写 Fabric/Forge 的 mixin adapter、服务注册、聚焦 tests/resources 和必要 module build 配置；保留共享 core ABI",
        "Fabric string/object/environment/未知字段及顺序保全；Forge manifest trim/drop blanks 与全部适用引用同步；NeoForge TOML load/save/close/reopen",
        "第三方无 selective capability 显式失败，legacy 路径与非 mixin/AW/AT/patch/nested-JAR metadata 保全",
        "不改 mixins 核心、mapping、版本、权威、普通说明或 Git"
      ],
      "prerequisiteItemIds": [
        "G1-I04A"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-fabric/src/**、build.gradle.kts",
        "minecraft-codev-forge/src/**、build.gradle.kts",
        "本 Work evidence/g1-implementation/platform/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "其他模块 writer、Gradle invocation 或 Git；必须串行"
      ],
      "completionPredicate": "平台适配真实 JAR reopen 与保全/legacy 回归通过，并准确消费既有核心契约",
      "requiredEvidence": [
        "exact changed set、真实 metadata 输入输出、artifact hashes、命令/exit",
        "A8/AC8 平台覆盖及未满足项，不宣称完整 G1 通过"
      ],
      "verification": [
        "Fabric/Forge metadata focused suites 与相关旧行为回归"
      ],
      "authority": [
        "既有 Spec C6-C7/A8 与 PRD AC8；I04A 已完成能力契约"
      ],
      "historicalOnly": true,
      "lastResultStatus": "partial",
      "reacceptedByItemId": "G1-I04B-V01",
      "historicalDisposition": "generation 1 partial preserved; Router already reaccepted outcome using R01/V01 completed, not rewriting old Result"
    },
    {
      "id": "G1-I04B-R01",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅 applicability 修复与独立 repair evidence",
      "resultCount": 1,
      "objective": "恢复已接受的 environment applicability 契约，使核心 discovery/execute/records/consumer 不再把外层 Fabric environment 丢失",
      "scopeAndEffects": [
        "只写 mixins 核心 applicability 接线、Fabric exact environment capability、必要的 Fabric/Forge focused tests/resources 与本项 repair evidence；保留既有 shared ListedFileHandler ABI",
        "绑定外层 environment 与内部 side/scope 的交集，保留 inactive-only 来源证明并拒绝不适用配置进入 applied/consumable 集合；同步检查 task、execute、EngineOperation 两次 binding、StripAppliedMixins/SelectiveConsumer 及 shared callers",
        "不新增 UNKNOWN/Loader precedence/任意 plugin 证明承诺，不改 mapping、版本、权威、普通说明或 Git；legacy StripMixins 无 side 的明确全删语义保留"
      ],
      "prerequisiteItemIds": [
        "G1-I04A",
        "G1-I04B-DIAG"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中 applicability 接线与 tests/resources",
        "minecraft-codev-fabric/src/** 与必要 focused tests/resources",
        "必要 Forge compatibility tests/resources",
        "本 Work evidence/g1-implementation/platform-repair/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "其他 source/config/test writer、Gradle invocation 或 Git；必须串行"
      ],
      "completionPredicate": "失败 SERVER fixture 在修复后不再应用/删除 client-only 配置，CLIENT 与 ordinary SERVER 保持正确，inactive-only/side mismatch 保留，shared core 与 legacy 回归不退化；所有实际变更和限制有证据",
      "requiredEvidence": [
        "before/after changed set、source/record/artifact hashes、真实失败前与修复后命令/exit",
        "applicability-aware discovery/execute/record/consumer trace 与 authority coverage，不声称未知边界完成"
      ],
      "verification": [
        "最小真实 SERVER/CLIENT/ordinary 对照、inactive-only retention、wrong-side rejection、consumer cleanup 边界和既有核心 smoke；不得以 harness exit 0 替代断言"
      ],
      "authority": [
        "既有 Spec C1-C7/A5-A8、PRD R1/R3-R5/R7/R10/AC5/6/8/11、Accepted ADR task-owned resolution；诊断确认 reuse，不新增规范承诺"
      ],
      "historicalPrerequisiteItemIds": [
        "G1-I04B"
      ]
    },
    {
      "id": "G1-I04B-V01",
      "waveId": "G1-W03",
      "handler": "一个独立验证 Handler；仅 I04B repair 后平台重验",
      "resultCount": 1,
      "objective": "在 R01 后的新实际树上独立重验 Fabric/Forge 平台完整矩阵并决定是否重新接受 I04B",
      "scopeAndEffects": [
        "只读 R01 后 source/config/tests 与历史 I04B evidence，运行真实 JAR/TestKit/provider 聚焦矩阵并写 platform-rerun evidence；不修代码、不改权威或 Git",
        "覆盖 Fabric string/object/environment/unknown、SERVER/CLIENT/ordinary/inactive-only、Forge manifest trim/drop blanks/all applicable refs、JAR reopen、legacy 与 shared core compatibility"
      ],
      "prerequisiteItemIds": [
        "G1-I04B-R01"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "本 Work evidence/g1-implementation/platform-rerun/**",
        "验证工具拥有的 build/test temporary outputs"
      ],
      "conflicts": [
        "全部 source/config/test writer、其他 Gradle invocation 和 Git；冻结 R01 后实际树"
      ],
      "completionPredicate": "真实平台矩阵无 failure/error/skipped，SERVER 不应用或删除 client-only，CLIENT/ordinary/Forge/legacy 与 selective retention 通过；否则 I04B 仍 partial，I04C-E 不释放",
      "requiredEvidence": [
        "固定 R01 后 tree/changed set/input hashes、每项命令/exit、JAR/records/reopen 观察",
        "准确声明未覆盖的 UNKNOWN/Loader/动态边缘，不复用不匹配 identity"
      ],
      "verification": [
        "独立重算 manifest、真实 XML/log/JAR/records 与 I04B completion predicate；只读，不把历史 partial 改写为通过"
      ],
      "authority": [
        "既有 Spec/PRD/ADR 与 R01 已核对的恢复契约"
      ]
    },
    {
      "id": "G1-I04C",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅可选 mapping 结果",
      "resultCount": 1,
      "objective": "接入精确 namespace/owner/name/descriptor 方向的可选 mapping 并保留无 mapping 默认",
      "scopeAndEffects": [
        "只写 mixins 的 mapping adapter、必要 task/runtime 接线、module build 配置和聚焦测试；使用 mapping-io 0.7.1",
        "真实 refmap→MemberInfo→environment remapper chain，完整 tuple 验证、reverse mapping、null/缺失 passthrough 与歧义诊断",
        "不改平台适配、模块版本、shared MappingService、权威、普通说明或 Git"
      ],
      "prerequisiteItemIds": [
        "G1-I04B-V01"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/** 中 mapping/必要局部接线与 tests",
        "minecraft-codev-mixins/build.gradle.kts",
        "本 Work evidence/g1-implementation/mapping/**",
        "本项 build/test temporary outputs"
      ],
      "conflicts": [
        "其他模块 writer、Gradle invocation 或 Git；必须串行"
      ],
      "completionPredicate": "真实 mapped target/refmap/engine 正负例及 no-mapping 兼容通过，方向、身份和歧义行为满足 C8",
      "requiredEvidence": [
        "changed set、actual mapping/refmap/input/output hashes、运行命令/exit",
        "A9-A10/AC9-AC10 的真实引擎观察及未满足项"
      ],
      "verification": [
        "mapping focused unit 与真实 engine integration fixture；unit adapter 检查不能替代 chain"
      ],
      "authority": [
        "既有 Spec C8/A9-A10 与 PRD AC9-AC10"
      ]
    },
    {
      "id": "G1-I04D",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅实际变更模块版本配置结果",
      "resultCount": 1,
      "objective": "依据实际 changed set 写入用户已确认的独立 fork 模块版本",
      "scopeAndEffects": [
        "仅实际变更模块 gradle.properties：mixins 0.1.0+terrarium.0.6.0、fabric 0.1.0+terrarium.0.7.2、forge 0.1.0+terrarium.0.9.2；不改未变模块或其他文件/Git"
      ],
      "prerequisiteItemIds": [
        "G1-I04C"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "三个实际变更模块 gradle.properties",
        "本 Work evidence/g1-implementation/versions/**"
      ],
      "conflicts": [
        "任何版本/config writer、Gradle invocation 或 Git；必须串行"
      ],
      "completionPredicate": "actual changed-module set 与三个版本值/上游后缀及动态引用一致，未变模块保全",
      "requiredEvidence": [
        "实际代码变更模块清单、exact properties diff、版本与引用检查结果"
      ],
      "verification": [
        "聚焦版本值/来源/动态引用一致性检查，无需重跑行为测试"
      ],
      "authority": [
        "用户具体确认、Spec version defaults 与 Plan 版本规则"
      ]
    },
    {
      "id": "G1-I04E",
      "waveId": "G1-W03",
      "handler": "一个验证专用 Handler；仅同一实际代码树的组合验收结果",
      "resultCount": 1,
      "objective": "在 I04A-D 的最终实际代码树上验证全部 A1-A12/AC1-AC12 与所变模块 check",
      "scopeAndEffects": [
        "只读最终 source/config/tests，运行所需测试并写验证 evidence/temporary outputs；不修代码或修改权威/文档/Git",
        "核对旧兼容、平台/mapping、same-JVM/并发、缓存/configuration-cache、input changes、cancel/retry/fault/stale records 与不同 artifact 正负例"
      ],
      "prerequisiteItemIds": [
        "G1-I04D"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "本 Work evidence/g1-implementation/final/**",
        "验证工具拥有的 build/test temporary outputs"
      ],
      "conflicts": [
        "全部 source/config/test writers、其他 Gradle invocation 和 Git；冻结 actual tree"
      ],
      "completionPredicate": "全部 A1-A12/AC1-AC12 逐项有真实满足证据且所有所变模块 check 通过；否则准确报告 partial/blocked/failed，不放行 W03",
      "requiredEvidence": [
        "固定 actual changed set 与输入 hashes，完整 A/AC 到 fixture/log/records/artifacts/exit 映射",
        "resolved engine/ASM closure、版本、命令和全部限制；未执行项明确标明"
      ],
      "verification": [
        "Plan 全矩阵与三个模块 focused suites/check；已完成证据仅在输入与最终树关系可验证时复用"
      ],
      "authority": [
        "既有 PRD/Spec/ADR 与 Plan 完整验收矩阵"
      ],
      "historicalOnly": true,
      "lastResultStatus": "partial",
      "supersededForAcceptanceByItemId": "G1-I04E-R10",
      "historicalDisposition": "generation 1 partial and final evidence remain read-only; new acceptance Result required; no execution or resealing this node",
      "historicalAcceptanceSuccessorItemId": "G1-I04E-R08"
    },
    {
      "id": "G1-I05",
      "waveId": "G1-W04",
      "handler": "一个独立 review-correctness Handler；可加载 read-only review-evidence/review-security 方法，不产生第二结果",
      "resultCount": 1,
      "objective": "独立判断固定 G1 功能 tree 的行为与验收证据是否满足既有权威",
      "scopeAndEffects": [
        "独立最终正确性/证据审计：G1-I04E-R13完整completed后且W03已释放，在R13同一实际新final identity复核全24项/五check、新Core vanilla两MC×common/client/missing-ID、P01/P02、core ABI/封存旧caller精确debug、Forge真实Java8及操作域engine/ASM/诊断边界；退役树Core三真实case恰3/3/0，无Basic skip或四空pass；旧8/7/1仅历史。只读实现/旧包，历史partial/strict限制保留，不兼修复或Git。"
      ],
      "prerequisiteItemIds": [
        "G1-I04A",
        "G1-I04B-V01",
        "G1-I04C",
        "G1-I04D",
        "G1-I04E-R13"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "仅审计工具拥有的 temporary outputs；Result 返回审计证据，不直接改项目文件"
      ],
      "conflicts": [
        "I04 或其他 source/config/test/evidence writer、Git tree 改动；整个被审计 tree 固定"
      ],
      "completionPredicate": "给出绑定 actual tree/evidence 的独立可复核通过或缺陷结论；只有通过且无重大未决才满足 W04 release",
      "requiredEvidence": [
        "被审tree/changed set与所有required evidence的覆盖判断；核对G1-I04E-R13同一实际新final members/count/identity的五module check/全A1-A12/AC1-AC12、新vanilla及全部必要直接闭包；退役树不得skip/filter，Core三真实case恰3/3/0；旧Basic skip只历史；不继承旧audit/PASS/XML，unknown Ruff/fullStrictScope=false保持独立披露。",
        "实际复查命令/观察及未重跑范围",
        "所有发现的 severity/location/cause 与 remaining limits，不能以文档权威/归档/scratch PASS 替代验收"
      ],
      "verification": [
        "复核 Plan 矩阵及 producer/consumer artifacts；按发现运行最小真实 reproducer；不无故重跑全仓"
      ],
      "authority": [
        "相同 PRD/Spec/ADR 与 Plan 完成 gate"
      ],
      "lastResultStatus": "missing",
      "historicalPrerequisiteItemIds": [
        "G1-I04E",
        "G1-I04E-V01",
        "G1-I04E-V02",
        "G1-I04E-R08",
        "G1-I04E-R09",
        "G1-I04E-R10",
        "G1-I04E-R11"
      ],
      "r13FinalBinding": {
        "inputIdentity": "daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df",
        "inputCount": 272,
        "tupleRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/manifest.json#/tuple",
        "mapRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json",
        "scopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
        "inputsRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/inputs.json",
        "futureEvidenceOwner": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/",
        "requiredOutputNames": [
          "README.md",
          "inputs.json",
          "tuple.json",
          "commands.json",
          "streams.json",
          "xml-inspection.json",
          "acceptance-matrix.json",
          "direct-closure.json",
          "core-abi.json",
          "forge-java8.json",
          "effects-ledger.json",
          "environment.json",
          "manifest.json",
          "verification.json"
        ],
        "sameFinalOnly": true
      },
      "prerequisiteWaveGates": [
        "G1-W03"
      ]
    },
    {
      "id": "G1-I06",
      "waveId": "G1-W05",
      "handler": "一个 implement-change Handler；仅 ordinary documentation delivery",
      "resultCount": 1,
      "objective": "交付与独立审计通过 tree 一致的普通消费者说明和真实验证结果文档",
      "scopeAndEffects": [
        "新 docs/guides/mixin-preapplication.md 和本 Work evidence/g1-results.md，README 只加有界使用入口链接",
        "说明旧 ordinary/StripMixins 全删与新 selective producer/records/consumer 区别、不同 artifact 链、可选 mapping、task-only plugin、实际版本与支持/拒绝边界",
        "只使用真实 API/Result/log，引用已持久 evidence；不新写 PRD/Spec/ADR/DDD/AGENTS/Skill，不自动改 Work/Waves 执行状态",
        "若目标普通文档已存在，只更新授权 owning 区域且保留他人内容；未允许则报告，不能覆写"
      ],
      "prerequisiteItemIds": [
        "G1-I05"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "docs/guides/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-results.md",
        "README.md 的 G1 usage 链接区域"
      ],
      "conflicts": [
        "相同 ordinary docs writer；必须在 code audit 后，不得改 audited source/config/tests 或进行 Git staging"
      ],
      "completionPredicate": "三处普通说明组成一致的可导航消费者交付，examples 与真实 suite 相符，全部通过/拒绝/限制声明有固定审计 tree 证据",
      "requiredEvidence": [
        "确切新文档/修改区域与链接检查",
        "用法 example 对应实际 API 与已通过 TestKit fixture",
        "实际测试/版本/supported boundaries 和代码 tree hash，明确 authority 未改"
      ],
      "verification": [
        "本地链接与 example-to-fixture/API 核对；无新行为不另行运行功能验证"
      ],
      "authority": [
        "Plan documentation gate；existing authority 的兼容/失败契约仅引用"
      ]
    },
    {
      "id": "G1-I07",
      "waveId": "G1-W06",
      "handler": "一个 git-workflow Handler；仅另行授权的本地签名交付",
      "resultCount": 1,
      "objective": "将已验证审计并文档化的固定 G1 tree 按具体范围签名提交和非覆盖式集成到本地 main",
      "scopeAndEffects": [
        "只 Codev local Git；explicit stage list 与实际 changed tree，既有 untracked 四份权威/背景、Work/proof/普通文档仅在纳入范围已授权时提交",
        "按授权 signed commit；如 main 未前移可 fast-forward，前移则只执行明确授权且保留双方 tree 的非覆盖式集成，不自动 reset/rebase/stash/clean",
        "签名或纳入文件权限缺失、unexpected conflict/branch drift 时报告 blocker；不在此修 code/docs 或额外跑实现计划",
        "不 push/publish/release，不删除功能分支或清理无关 untracked"
      ],
      "prerequisiteItemIds": [
        "G1-I01",
        "G1-I05",
        "G1-I06"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-GIT-INTEGRATE"
      ],
      "writeOwnership": [
        "具体授权 Codev index/commit objects/function branch/main refs 与集成 working tree"
      ],
      "conflicts": [
        "全部项目 writer、同仓库 Git 操作、test/build process；最后独占集成，不与任何其他 item 并行"
      ],
      "completionPredicate": "具体授权文件集已形成可验证签名 commit 并非覆盖式进入本地 main，main tree 与已审计代码及普通文档 tree 一致且所有原内容保全",
      "requiredEvidence": [
        "纳入文件清单、authorization、before/after HEAD/refs/status/index",
        "commit IDs、signature verification 与 exact tree/diff/ancestry",
        "无未授权文件进入 commit，未 reset/丢文档/推送/发布；签名覆盖具体约定的提交"
      ],
      "verification": [
        "只读 signature/tree/ancestry/diff/status 核对；被审 tree 改变时不能复用旧审计放行"
      ],
      "authority": [
        "Plan D-GIT-INTEGRATE 与具体后续 Git 授权，不由 ADR 或原实施许可推定"
      ]
    },
    {
      "id": "G1-I04B-DIAG",
      "waveId": "G1-W03",
      "handler": "一个只读 diagnose Handler；已经完成的独立诊断结果，非本次新执行",
      "resultCount": 1,
      "objective": "定位历史 Fabric environment 丢失及 applicability owning 边界",
      "scopeAndEffects": [
        "仅读取失败并建立因果/owner 边界；该 Result 已由 Router 读取，当前仅纳入原已完成事实，不重新接受或执行"
      ],
      "prerequisiteItemIds": [
        "G1-I04A"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "历史诊断时本 Work evidence/g1-implementation/platform-diagnosis/**；现在只读"
      ],
      "conflicts": [
        "不与被诊断树 writer/Git 并行；历史 evidence 不再写入"
      ],
      "completionPredicate": "独立诊断完整 Result completed，原失败/身份/限制/因果与最小边界可核对；不表示修复或验收通过",
      "requiredEvidence": [
        "codev-mixin-g1-platform-environment-diagnosis generation 1 完整 completed Result（见当前执行状态）",
        "evidence/g1-implementation/platform-diagnosis/README.md 与关联原证据"
      ],
      "verification": [
        "只读关联既有 Result/证据；不将诊断 green control 认作产品 PASS"
      ],
      "authority": [
        "既有 PRD/Spec/ADR reuse；已完成诊断事实"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "Router 既有核对记录：codev-mixin-g1-platform-environment-diagnosis generation 1"
    },
    {
      "id": "G1-I04E-DIAG-CHECK",
      "waveId": "G1-W03",
      "handler": "一个只读 diagnose Handler；已经完成的独立诊断结果，非本次新执行",
      "resultCount": 1,
      "objective": "解释六检查任务105项并确定8个validation owners/27个lint文件",
      "scopeAndEffects": [
        "仅读取失败并建立因果/owner 边界；该 Result 已由 Router 读取，当前仅纳入原已完成事实，不重新接受或执行"
      ],
      "prerequisiteItemIds": [
        "G1-I04D"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "历史诊断时本 Work evidence/g1-implementation/check-diagnosis/**；现在只读"
      ],
      "conflicts": [
        "不与被诊断树 writer/Git 并行；历史 evidence 不再写入"
      ],
      "completionPredicate": "独立诊断完整 Result completed，原失败/身份/限制/因果与最小边界可核对；不表示修复或验收通过",
      "requiredEvidence": [
        "codev-mixin-check-diagnosis generation 1 完整 completed Result（见当前执行状态）",
        "evidence/g1-implementation/check-diagnosis/README.md 与关联原证据"
      ],
      "verification": [
        "只读关联既有 Result/证据；不将诊断 green control 认作产品 PASS"
      ],
      "authority": [
        "既有 PRD/Spec/ADR reuse；已完成诊断事实"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "Router 既有核对记录：codev-mixin-check-diagnosis generation 1"
    },
    {
      "id": "G1-I04E-DIAG-FORGE",
      "waveId": "G1-W03",
      "handler": "一个只读 diagnose Handler；已经完成的独立诊断结果，非本次新执行",
      "resultCount": 1,
      "objective": "证明两Forge旧fixture/API错位及现存task/provider纠正边界",
      "scopeAndEffects": [
        "仅读取失败并建立因果/owner 边界；该 Result 已由 Router 读取，当前仅纳入原已完成事实，不重新接受或执行"
      ],
      "prerequisiteItemIds": [
        "G1-I04D"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "历史诊断时本 Work evidence/g1-implementation/forge-baseline-diagnosis/**；现在只读"
      ],
      "conflicts": [
        "不与被诊断树 writer/Git 并行；历史 evidence 不再写入"
      ],
      "completionPredicate": "独立诊断完整 Result completed，原失败/身份/限制/因果与最小边界可核对；不表示修复或验收通过",
      "requiredEvidence": [
        "codev-forge-baseline-diagnosis generation 1 完整 completed Result（见当前执行状态）",
        "evidence/g1-implementation/forge-baseline-diagnosis/README.md 与关联原证据"
      ],
      "verification": [
        "只读关联既有 Result/证据；不将诊断 green control 认作产品 PASS"
      ],
      "authority": [
        "既有 PRD/Spec/ADR reuse；已完成诊断事实"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "Router 既有核对记录：codev-forge-baseline-diagnosis generation 1"
    },
    {
      "id": "G1-I04E-R01",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本修复结果及最小聚焦证明",
      "resultCount": 1,
      "objective": "恢复严格validation所需的最小输入和具体task声明",
      "scopeAndEffects": [
        "只修改诊断八个 owner：IncludesJar.input getter PathSensitivity.NONE；IncludedJarInfo.file getter NAME_ONLY（内容+basename）；AddClientSideAnnotations.directory getter 保守 ABSOLUTE；GenerateMcpToSrg.mappings getter NONE",
        "JarInJar、AddForgeClientSideAnnotations、GenerateForgeClientExtra、GenerateMcpToSrg、JarJar 五个具体 task 各显式 DisableCachingByDefault(because=尚未证明Gradle可重定位缓存语义)，不靠父类标记",
        "共享三个精确 getter 仅注解及必要 imports/相邻等价格式；保留 provider/producer 依赖与原输入内容/文件名语义。不改任务算法/API/shared ABI/includes identity/Mixin behavior，不启用缓存、不用 Internal/CompileClasspath 避错"
      ],
      "prerequisiteItemIds": [
        "G1-I04D",
        "G1-I04E-DIAG-CHECK",
        "G1-I04E-DIAG-FORGE"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/AddForgeClientSideAnnotations.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateForgeClientExtra.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateMcpToSrg.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/AddForgeClientSideAnnotations.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateForgeClientExtra.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateMcpToSrg.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludedJarInfo.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R01/**",
        "仅本项工具拥有的 build/.gradle/TestKit 临时 outputs"
      ],
      "conflicts": [
        "共享source/config/test/Gradle outputs与provider/classpath冲突；全链严格串行，无并行wrapper/formatter/test/Git/其他writer",
        "本项evidence独占；旧final/全部历史证据只读；最终验证期间source/config/tests与版本冻结"
      ],
      "completionPredicate": "八个owner内四getter normalization与五具体禁用缓存声明准确恢复，原11个ERROR在新实际身份的两loader validatePlugins报告中消失（任务exit0）；内容/basename/目录保守敏感性和provider依赖的最小证明成立，未改ABI/行为/缓存能力",
      "requiredEvidence": [
        "一份完整Result、exact changed set/before-after inputs+tree hash、真实命令/exit/原始log及新报告/XML/artifacts；分清未执行/环境blocker/技术失败",
        "本项精确owner和授权例外/不变禁令核对、旧失败和历史证据保全、branch/HEAD/main/index保全；新证据不写旧final或诊断包",
        "仅本修复最小聚焦证明，不冒充后续最终验收"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-fabric:validatePlugins :minecraft-codev-forge:validatePlugins --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "最小输入/注解反射及内容/basename变化核对、nested entry/Forge metadata/provider依赖语义证明；不宣称可重定位缓存"
      ],
      "authority": [
        "当前用户最小扩大范围许可D-G1-MAINTENANCE；Context逐family reuse",
        "Active PRD R1/R9/R10/AC11及全AC；Active Spec baseline/C1-C3/A11及全A；Accepted ADR isolation/无行为扩展"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "仅投影上方Router已接受的历史完整Result，不是本次新接受：codev-mixin-i04e-r01 generation1"
    },
    {
      "id": "G1-I04E-R02",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本修复结果及最小聚焦证明",
      "resultCount": 1,
      "objective": "修复诊断27文件的Kotlin样式且保持行为",
      "scopeAndEffects": [
        "仅 summary.json.lintFiles 的27文件，按 issues.md/task-diagnostics.json 94条原规则进行显式等价 imports/换行/缩进/标点及必要相邻布局；不豁免规则、不删断言、不更改类型/API/插件注册/行为",
        "filename 规则仅 minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/setupForgeRunsIntegration.kt → minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/SetupForgeRunsIntegration.kt；old/new 文件级 owner 已明列，先查硬编码旧路径消费者；package/function 保持不变，不删除原接线。不授予修复其他消费者文件的写权"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R01"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/jarinjar/FabricJarInJarHandler.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mappings/AccessWidenerRemapper.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mappings/TinyMappingResolutionRule.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/runs/FabricRunsDefaultsContainer.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/MergeAccessWideners.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/SplitModClient.kt",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/McpConfig.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/RemoveNameMappingService.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/UserdevConfig.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/accesswidener/ForgeAccessTransformerResolutionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/lexforge/ForgeLexToNeoComponentMetadataRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/lexforge/McpConfigToNeoformComponentMetadataRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mappings/ForgeModDetectionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mappings/McpConfigMappingResolutionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/ForgeRunsDefaultsContainer.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/setupForgeRunsIntegration.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/AddForgeClientSideAnnotations.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/DistAttributePostProcessor.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateAccessTransformer.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateMcpToSrg.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/SetupForgeRunsIntegration.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/jarinjar/FabricJarInJarHandler.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mappings/AccessWidenerRemapper.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mappings/TinyMappingResolutionRule.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/runs/FabricRunsDefaultsContainer.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/JarInJar.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/MergeAccessWideners.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/task/SplitModClient.kt",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/McpConfig.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/RemoveNameMappingService.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/UserdevConfig.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/accesswidener/ForgeAccessTransformerResolutionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/lexforge/ForgeLexToNeoComponentMetadataRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/lexforge/McpConfigToNeoformComponentMetadataRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mappings/ForgeModDetectionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mappings/McpConfigMappingResolutionRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/ForgeRunsDefaultsContainer.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/setupForgeRunsIntegration.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/AddForgeClientSideAnnotations.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/DistAttributePostProcessor.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateAccessTransformer.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/GenerateMcpToSrg.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/JarJar.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/SetupForgeRunsIntegration.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R02/**",
        "仅本项工具拥有的 build/.gradle/TestKit 临时 outputs"
      ],
      "conflicts": [
        "共享source/config/test/Gradle outputs与provider/classpath冲突；全链严格串行，无并行wrapper/formatter/test/Git/其他writer",
        "本项evidence独占；旧final/全部历史证据只读；最终验证期间source/config/tests与版本冻结"
      ],
      "completionPredicate": "仅27文件及明列rename发生语义等价布局变化，94原规则无豁免解决，四既有main/test ktlint任务新报告exit0，rename消费者核对与类型/API/行为保全证明成立",
      "requiredEvidence": [
        "一份完整Result、exact changed set/before-after inputs+tree hash、真实命令/exit/原始log及新报告/XML/artifacts；分清未执行/环境blocker/技术失败",
        "本项精确owner和授权例外/不变禁令核对、旧失败和历史证据保全、branch/HEAD/main/index保全；新证据不写旧final或诊断包",
        "仅本修复最小聚焦证明，不冒充后续最终验收"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-fabric:ktlintMainSourceSetCheck :minecraft-codev-fabric:ktlintTestSourceSetCheck :minecraft-codev-forge:ktlintMainSourceSetCheck :minecraft-codev-forge:ktlintTestSourceSetCheck --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "原规则到新文件/rename映射及语义等价diff；仅本结果聚焦证明"
      ],
      "authority": [
        "当前用户最小扩大范围许可D-G1-MAINTENANCE；Context逐family reuse",
        "Active PRD R1/R9/R10/AC11及全AC；Active Spec baseline/C1-C3/A11及全A；Accepted ADR isolation/无行为扩展"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "仅投影上方Router已接受的历史完整Result，不是本次新接受：codev-mixin-i04e-r02 generation1"
    },
    {
      "id": "G1-I04E-R02C",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；R02 编译补救及自身聚焦验证",
      "resultCount": 1,
      "objective": "纠正R02遗漏imports并恢复case-only rename后的Forge compileKotlin增量状态",
      "scopeAndEffects": [
        "仅ForgeRunsDefaultsContainer.kt imports加入SourceSet及SourceSetContainer，不改body/API/当前PascalCase文件名；保留R01声明与R03候选fixture",
        "先归档并逐项hash，再将仅minecraft-codev-forge/build/kotlin/compileKotlin增量状态移至本项专有归档；不删旧classes/配置缓存或清共享Gradle缓存",
        "在真实根独占编译writer，Forge compileKotlin --no-build-cache实际执行、四ktlint --rerun-tasks实际执行；configuration-cache开启。不执行R03 TestKit或最终五模块check"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R02"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "已接受codev-forge-compile-diagnosis generation1完整completed Result及独立verifier exit0"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/ForgeRunsDefaultsContainer.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/runs/ForgeRunsDefaultsContainer.kt 的两条imports",
        "minecraft-codev-forge/build/kotlin/compileKotlin 有界状态归档与恢复，以及本项编译/lint必要输出",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R02C/**"
      ],
      "conflicts": [
        "不与真实项目Gradle/编译/lint/fixture writer或Git写入并行"
      ],
      "completionPredicate": "完整Result completed；当前真实源码仅两imports增加，旧增量状态归档可重算；实际Forge compileKotlin exit0非FROM-CACHE，四项ktlint实际执行exit0且新报告空，原失败错误消失；源/config/fixture/版本/Git及旧封存证据保全。仅本补救完成，不代表R03或G1通过",
      "requiredEvidence": [
        "compile-diagnosis/README.md 单变量已确认根因与边界",
        "本项before/after与source diff、增量域原始归档/hash、实际commands/exit/log、新lint报告及独立只读verifier"
      ],
      "verification": [
        "按compile-diagnosis最小补救在真实根执行compile与四lint；排除FROM-CACHE编译证明，保留configuration-cache",
        "不重封旧证据；R03后续须同新树取得原2/2及真实patch/remap/Java/JAR证据"
      ],
      "authority": [
        "原R02样式维护范围与用户已确认D-G1-MAINTENANCE；PRD/Spec/ADR reuse，无新产品/ABI行为"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "仅投影上方Router已接受的历史完整Result，不是本次新接受：codev-forge-compile-repair generation1"
    },
    {
      "id": "G1-I04E-R03",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本修复结果及最小聚焦证明",
      "resultCount": 1,
      "objective": "恢复两个Forge原integration fixture的现存API接线",
      "scopeAndEffects": [
        "只修改两个既有 fixture build.gradle.kts：现存 ResolvePatchedMinecraft task/provider → compileClasspath/Java/JAR；remapped 再接实际 mappings 与 RemapTask；使用当前 repository/helpers，不恢复已删除生产 dependency/repository DSL",
        "保留 basic Minecraft1.12.2/Forge14.23.5.2860/userdev3、remapped Minecraft1.16.5/Forge36.2.39/userdev、Java8 compilation、现有Java17 TestKit宿主、原Java imports/classpath与jar printCompileClasspath -s/withPluginClasspath/debug路径",
        "PatchedMinecraftTests.kt、两个settings.gradle.kts、Java输入、Forge module build 和现存生产任务只读复用。原两TestKit测试必须实际2/2，无failure/error/skipped；观察真实patch/remap/JAR/compileJava/AT/nested-JAR边界，不以green help或只删import替代"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R02C"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/basic-patched-test/build.gradle.kts",
        "minecraft-codev-forge/remapped-patched-test/build.gradle.kts"
      ],
      "writeOwnership": [
        "minecraft-codev-forge/basic-patched-test/build.gradle.kts",
        "minecraft-codev-forge/remapped-patched-test/build.gradle.kts",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R03/**",
        "仅本项工具拥有的 build/.gradle/TestKit 临时 outputs"
      ],
      "conflicts": [
        "共享source/config/test/Gradle outputs与provider/classpath冲突；全链严格串行，无并行wrapper/formatter/test/Git/其他writer",
        "本项evidence独占；旧final/全部历史证据只读；最终验证期间source/config/tests与版本冻结"
      ],
      "completionPredicate": "现存task/provider接线在保留原版本/toolchain/classpath/Java/JAR断言下运行原PatchedMinecraftTests真实2/2且patch与实际remap链成功，输出可reopen核对；不恢复旧DSL/不跳过检查",
      "requiredEvidence": [
        "一份完整Result、exact changed set/before-after inputs+tree hash、真实命令/exit/原始log及新报告/XML/artifacts；分清未执行/环境blocker/技术失败",
        "本项精确owner和授权例外/不变禁令核对、旧失败和历史证据保全、branch/HEAD/main/index保全；新证据不写旧final或诊断包",
        "仅本修复最小聚焦证明，不冒充后续最终验收"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.PatchedMinecraftTests --stacktrace --configuration-cache --console=plain --no-daemon",
        "两项XML tests=2/failures=errors=skipped=0；真实patch/remap任务、compileJava/JAR/printCompileClasspath/输出reopen及原Java符号保留"
      ],
      "authority": [
        "当前用户最小扩大范围许可D-G1-MAINTENANCE；Context逐family reuse",
        "Active PRD R1/R9/R10/AC11及全AC；Active Spec baseline/C1-C3/A11及全A；Accepted ADR isolation/无行为扩展"
      ],
      "lastResultStatus": "partial",
      "historicalOnly": true,
      "reacceptedByItemId": "G1-I04E-R03V",
      "historicalDisposition": "保留原fixture接线Result、after-r02c/after-network blocked和after-java8原2项1/2 partial及全部证据；不重封旧包、不把原partial改为completed。新R03V独立Result承担修复后新树的同一R03 outcome。",
      "resultProvenance": "codev-mixin-i04e-r03 generation1 partial；codev-forge-fixture-r03-rerun及codev-forge-r03-network-rerun blocked；codev-forge-r03-java8-rerun generation1 partial"
    },
    {
      "id": "G1-I04E-R04",
      "waveId": "G1-W03",
      "handler": "一个 implement-change Handler；仅本修复结果及最小聚焦证明",
      "resultCount": 1,
      "objective": "协调新增实际维护模块core/includes的独立fork版本",
      "scopeAndEffects": [
        "仅 core/includes 两gradle.properties：真实上游0.7.2/0.6.5 → 0.1.0+terrarium.0.7.2 / 0.1.0+terrarium.0.6.5",
        "先验证 R01 实际共享维护使 changed-module set 恰为 mixins/fabric/forge/core/includes；保留 I04D 三fork值；静态核对项目动态版本/依赖引用，无root/runtime/其他module批量bump或发布"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R03V"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/gradle.properties",
        "minecraft-codev-includes/gradle.properties"
      ],
      "writeOwnership": [
        "minecraft-codev-core/gradle.properties",
        "minecraft-codev-includes/gradle.properties",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/**",
        "仅本项工具拥有的 build/.gradle/TestKit 临时 outputs"
      ],
      "conflicts": [
        "共享source/config/test/Gradle outputs与provider/classpath冲突；全链严格串行，无并行wrapper/formatter/test/Git/其他writer",
        "本项evidence独占；旧final/全部历史证据只读；最终验证期间source/config/tests与版本冻结"
      ],
      "completionPredicate": "实际五changed-module set、core/includes两fork值/上游后缀/动态引用一致，I04D三fork与未变模块不变；聚焦静态版本检查通过",
      "requiredEvidence": [
        "一份完整Result、exact changed set/before-after inputs+tree hash、真实命令/exit/原始log及新报告/XML/artifacts；分清未执行/环境blocker/技术失败",
        "本项精确owner和授权例外/不变禁令核对、旧失败和历史证据保全、branch/HEAD/main/index保全；新证据不写旧final或诊断包",
        "仅本修复最小聚焦证明，不冒充后续最终验收",
        "生产R03P completed及新独立R03V completed的完整Result/同树绑定；R03V实际原两项2/2后才考虑本版本节点，不依赖旧R03 partial"
      ],
      "verification": [
        "静态版本来源/值/dynamic引用/实际changed set/hash/diff核对，不运行行为测试"
      ],
      "authority": [
        "当前用户最小扩大范围许可D-G1-MAINTENANCE；Context逐family reuse",
        "Active PRD R1/R9/R10/AC11及全AC；Active Spec baseline/C1-C3/A11及全A；Accepted ADR isolation/无行为扩展"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "codev-maintenance-versions-r04 generation1完整completed；Router默认只读verifier exit0，两版本owner独占变化，272inputs最终identity8595111476c330a06a271adf72e16ef306ad225daa7c11984a880c1ab2e4773a；只支持版本谓词，不证明新树组合check",
      "plannedVersions": {
        "minecraft-codev-core": "0.1.0+terrarium.0.7.2",
        "minecraft-codev-includes": "0.1.0+terrarium.0.6.5"
      }
    },
    {
      "id": "G1-I04E-V01",
      "waveId": "G1-W03",
      "handler": "一个独立验证专用 Handler；只交付新固定树组合验收",
      "resultCount": 1,
      "objective": "在新五模块实际树独立重验完整G1最终验收",
      "scopeAndEffects": [
        "只读 R04 后最终 source/config/tests，冻结五模块 actual changed set/input/runtime/engine identities；在新独立目录交付一次组合验收 Result，不修复代码/版本/build/普通文档/权威/Git",
        "全五模块check与完整A1-A12/AC1-AC12是同一final acceptance谓词的组成；新树真实 producer→records→不同artifact consumer、输入/body/resource/mapping/side变化、配置缓存存储/复用、build-cache restore/fresh consumption、legacy/metadata/mapping、安全正例/拒绝、并发/关闭/cancel/retry/fault/stale pair闭环",
        "旧 I04E partial/旧 core/platform/mapping绿项仅作provenance；旧通过不自动传给新identity。每行须新实际证据或明确同新树依赖闭包绑定的可核验等价/复用证明；完整组合链与五check须本次真实通过。原Forge两TestKit仍实际2/2。失败准确partial/failed，外部环境缺失blocked，均不得放行"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R04"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/**",
        "仅本项工具拥有的 build/.gradle/TestKit 临时 outputs"
      ],
      "conflicts": [
        "共享source/config/test/Gradle outputs与provider/classpath冲突；全链严格串行，无并行wrapper/formatter/test/Git/其他writer",
        "本项evidence独占；旧final/全部历史证据只读；最终验证期间source/config/tests与版本冻结"
      ],
      "completionPredicate": "同一新固定树上全部A1-A12/AC1-AC12逐行真实满足、五个实际变更模块check均exit0且原Forge两TestKit2/2，输入/cache/legacy/metadata/mapping闭环绑定完整无未决必须证据；新独立Result completed才可供Router重新接受最终outcome，否则不放行W03/I05",
      "requiredEvidence": [
        "一份完整Result、exact changed set/before-after inputs+tree hash、真实命令/exit/原始log及新报告/XML/artifacts；分清未执行/环境blocker/技术失败",
        "本项精确owner和授权例外/不变禁令核对、旧失败和历史证据保全、branch/HEAD/main/index保全；新证据不写旧final或诊断包",
        "完整12行A/AC矩阵到实际命令/log/XML/records/target/source/cleaned-artifact哈希映射，五check及版本/engine/ASM/runtime域、新identity闭环与全部限制",
        "R03P生产完整输入/7→8旧错误缓存失效的聚焦证明、R03V独立原2/2与Java8 finally恢复证据、R04两版本；最终完整链和五check必须绑定R04后的同一新identity，旧局部通过不传递"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --stacktrace --configuration-cache --console=plain",
        "在最终identity重验Plan全部矩阵及真实TestKit/cache/legacy/platform/mapping fixtures；不能以UP-TO-DATE或旧XML推断新执行；存储/复用/input-change需实际日志"
      ],
      "authority": [
        "当前用户最小扩大范围许可D-G1-MAINTENANCE；Context逐family reuse",
        "Active PRD R1/R9/R10/AC11及全AC；Active Spec baseline/C1-C3/A11及全A；Accepted ADR isolation/无行为扩展"
      ],
      "lastResultStatus": "partial",
      "resultProvenance": "codev-final-five-check-v01 generation1完整partial，Router默认只读verifier exit0；五check exit1/not-reached、44fresh tests含Forge2/2，12行矩阵5supported/7partially，未满足最终gate",
      "requiredModuleChecks": [
        ":minecraft-codev-mixins:check",
        ":minecraft-codev-fabric:check",
        ":minecraft-codev-forge:check",
        ":minecraft-codev-core:check",
        ":minecraft-codev-includes:check"
      ],
      "acceptanceIds": [
        "A1",
        "A2",
        "A3",
        "A4",
        "A5",
        "A6",
        "A7",
        "A8",
        "A9",
        "A10",
        "A11",
        "A12",
        "AC1",
        "AC2",
        "AC3",
        "AC4",
        "AC5",
        "AC6",
        "AC7",
        "AC8",
        "AC9",
        "AC10",
        "AC11",
        "AC12"
      ],
      "historicalOnly": true,
      "supersededForAcceptanceByItemId": "G1-I04E-R10",
      "historicalAcceptanceSuccessorItemId": "G1-I04E-R08"
    },
    {
      "id": "G1-I04E-DIAG-PATCH",
      "waveId": "G1-W03",
      "handler": "一个只读diagnose Handler；已接受的独立诊断，仅登记历史结果",
      "resultCount": 1,
      "objective": "确认basic patch subset→rename完整输入缺口与两个生产owner边界",
      "scopeAndEffects": [
        "已完成codev-basic-patch-diagnosis generation2；generation1 child_exited_without_result保留。本次只关联来源，不重新诊断/运行/接受",
        "基本根因：clean bn未进入rename/mcinject，后填充旧notch定义与ICommandSender引用错配；保留静态HEAD对照不是独立baseline runtime的限制"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R02C"
      ],
      "historicalPrerequisiteItemIds": [
        "G1-I04E-R03"
      ],
      "externalPrerequisites": [
        "D-SCOPE"
      ],
      "writeOwnership": [
        "历史basic-patch-diagnosis/**现为只读；本次没有写入/重封责任"
      ],
      "conflicts": [
        "不与来源树或历史证据writer/Git并行；不产生新诊断写入"
      ],
      "completionPredicate": "既有独立完整diagnosis Result completed且来源/因果/owner/限制可核对；不证明生产修复或原两项2/2",
      "requiredEvidence": [
        "codev-basic-patch-diagnosis generation2完整Result与Router既有默认只读verifier exit0记录",
        "evidence/g1-implementation/basic-patch-diagnosis/README.md/sources.json/stage-comparison.json/baseline-comparison.json/manifest.json原件"
      ],
      "verification": [
        "只读关联既有completed Result、88来源/37选定class与完整输入诊断；本图准备不运行旧verifier、Java/Gradle或实验"
      ],
      "authority": [
        "已接受诊断及Context受影响authority reuse"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "Router已读取codev-basic-patch-diagnosis generation2完整completed Result并独立verifier exit0；本次不重新接受"
    },
    {
      "id": "G1-I04E-R03P",
      "waveId": "G1-W03",
      "handler": "一个implement-change Handler；仅最小生产patch恢复结果及其聚焦证明",
      "resultCount": 1,
      "objective": "恢复patch完整输入与旧错误结果失效，使未修改interface与patched引用进入相同下游namespace",
      "scopeAndEffects": [
        "仅McpAction.kt/ResolvePatchedMinecraft.kt共享patch完整输入与晚期填充责任：patch完成后在rename/mcinject前补齐clean缺失entries，只补缺失、patched bytes优先；未修改interface同namespace。覆盖notchObf merge placement、rename placement及末端patch，不只硬补ICommandSender",
        "停止晚期按原namespace补missing clean的错误责任；保留universal/inject/AT/marker顺序与语义，不改生产DSL、mapping方向、依赖/工具版本、Java8或nested政策",
        "ResolvePatchedMinecraft.kt内PATCH_OPERATION_VERSION当前7→8；现存forge/neoforge operationName随同字段失效旧域，旧forge-patch-7错误结果不复用，不清共享缓存，不新建shared cache/lock或通用迁移设施",
        "仅新McpActionPatchTests.kt沿既有JUnit/ASM/JDK内联生成局部JAR，验证patched class引用未修改clean interface、clean missing资源保留、重复entry patched bytes优先及补齐先于下游消费；不改原basic/remapped fixture、Test.java/PatchedMinecraftTests.kt宿主断言或module/root配置。最小证明属于本生产repair谓词，不兼独立原TestKit或最终验收"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R02C",
        "G1-I04E-DIAG-PATCH"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-PATCH-REPAIR"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/task/McpActionPatchTests.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/McpAction.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/task/McpActionPatchTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R03P/**",
        "仅本项局部compile/test工具拥有的build/.gradle临时outputs；不清共享cache"
      ],
      "conflicts": [
        "真实workspace所有source/config/test/provider、Gradle/TestKit/build outputs与Git writer冲突；按prerequisiteItemIds串行，不与其他wrapper/test/formatter/writer并行",
        "仅本项新evidence独占；全部旧diagnosis/final/check-repair manifests/snapshots只读；独立验证冻结生产/fixture/版本树"
      ],
      "completionPredicate": "完整patch输入在下游前恢复且patched bytes优先，未修改interface同namespace；仅两个生产owner/单文件局部回归的最小真实聚焦证明通过，PATCH_OPERATION_VERSION 7→8及旧错误缓存域不命中的绑定成立，授权外文件/原断言/缓存保全；一份completed生产repair Result，不宣称原TestKit2/2或G1验收",
      "requiredEvidence": [
        "唯一完整Result、三个精确owner before/after/diff、actual inputs/tree hashes、真实聚焦command/log/exit/XML/JAR与class identity；既有Step依赖到补齐完成/下游消费的控制流来源",
        "duplicate entry的patched bytes保持、clean未修改interface/resource在下游输入及输出namespace一致；覆盖placement/null路径的局部证明，不能只测无接线helper或硬补单class",
        "旧7当前来源、新8/operationName及原错误cache保留且不命中的失效证据；不通过清cache制造成功",
        "全部历史证据/Git refs/index/fixture/Test.java/宿主断言/依赖/工具/Java8/mapping/AT/nested政策保持；未执行项及环境blocker单列"
      ],
      "verification": [
        "沿既有Forge JUnit执行新单文件McpActionPatchTests最小聚焦证明并保留exact命令/exit；局部真实输出/namespace/重复entry优先与patch→下游先后观察",
        "只核对本task 7→8和既有operationName派生/旧域不复用；不清cache、不升级工具、不执行独立原双TestKit或最终五check"
      ],
      "authority": [
        "最新用户明确授权最小生产修复D-G1-PATCH-REPAIR；此前D-SCOPE/D-G1-MAINTENANCE仍有效，Git禁令不变",
        "Context本次受影响PRD/Spec/ADR reuse；既有retained Forge patch/userdev/AT/nested baseline维护，无新产品/架构/规范行为"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "Router接受generation2修复partial加独立编码补救completed的组合证据；补充默认verifier独立exit0，原30assert/164父成员/6补充成员/局部4tests通过；历史failed/partial/UnicodeDecodeError保留，仅R03P当前谓词完成"
    },
    {
      "id": "G1-I04E-R03V",
      "waveId": "G1-W03",
      "handler": "一个独立验证Handler；仅新树原basic/remapped两项重验Result，不修代码",
      "resultCount": 1,
      "objective": "在生产repair后固定树上独立证明原R03 outcome真实2/2与patch/remap/Java8/JAR闭环",
      "scopeAndEffects": [
        "只读R03P后的source/config/tests及原双fixture/Test.java/PatchedMinecraftTests.kt宿主原断言，不写生产/fixture/版本/module/root/权威/Git；新独立Result与旧R03所有partial/blocked分开",
        "沿原Java17 TestKit宿主、Minecraft1.12.2/Forge14.23.5.2860/userdev3和Minecraft1.16.5/Forge36.2.39/userdev、Java8 compilation、jar printCompileClasspath -s/withPluginClasspath/debug与srg→named不变；fresh原XML必须实际2/2零failure/error/skipped，不靠旧XML或UP-TO-DATE推定",
        "basic重开provider JAR证明ICommandSender definition/internal name与MinecraftServer interface reference可解析且无旧notch回填错配，真实Java8compile/JAR/print；remapped真实patch/LoadMappings/mappings/srg→named/Java8/JAR/print保持，class major52与tool/home identity记录",
        "沿已接受Java8发现临时恢复规则：仅独占generated TestKit home gradle.properties，before记录原存在状态/bytes/hash，临时org.gradle.java.installations.paths提供现存JDK8；finally精确恢复。保持Java17 host/原Test.java/宿主断言，不复制外层属性/凭据、不安装、不清cache、不改变全局环境",
        "保留AT原政策并准确区分执行与语义证明；nested-JAR未独立测试不能由ZIP无embedded JAR宣称认证。失败停止并准确partial/blocked/failed，不偷修或自动重跑"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R03P"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-PATCH-REPAIR"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R03V/**",
        "仅本项原过滤命令工具拥有的build/.gradle/TestKit临时outputs；minecraft-codev-forge/build/tmp/test/work/.gradle-test-kit/gradle.properties的既有Java8发现临时作用域，finally精确恢复"
      ],
      "conflicts": [
        "真实workspace所有source/config/test/provider、Gradle/TestKit/build outputs与Git writer冲突；按prerequisiteItemIds串行，不与其他wrapper/test/formatter/writer并行",
        "仅本项新evidence独占；全部旧diagnosis/final/check-repair manifests/snapshots只读；独立验证冻结生产/fixture/版本树"
      ],
      "completionPredicate": "固定R03P新树原两项freshXML真实2/2且failure/error/skipped=0，basic definition/reference同namespace及原Java8compile/JAR/print和remapped patch/mappings/srg→named/Java8/JAR闭环全部实际通过，临时属性finally精确恢复；一份独立completed Result才承担新树R03 outcome并可供Router考虑R04，旧partial不改写",
      "requiredEvidence": [
        "完整新独立Result、R03P completed Result/同固定输入tree绑定、exact原command/UTC/exit/日志/原生XML两testcase与新patch/mapped/fixture JAR hashes/reopen",
        "basic ICommandSender/MinecraftServer class definition/reference；remapped mappings方向/patch/remap链；真实compiler/launcher/home identity及major52/原Java源码与宿主断言保全",
        "generated TestKit home独占窗口、属性before/effective/finally restored存在状态/bytes/hash；外层属性/JDK/依赖/旧错误cache/Git/index和旧封存包保持，全部AT/nested/未执行限制明确",
        "新evidence仅R03V目录；原R03 README/XML/partial/blocked和basic诊断不重封不覆盖"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-forge:test --tests net.msrandom.minecraftcodev.forge.PatchedMinecraftTests --stacktrace --configuration-cache --console=plain --no-daemon",
        "原task真实执行及fresh XML tests=2/failures=errors=skipped=0；basic/remapped patch/Java8compile/JAR/print、映射/定义引用及finally恢复检查；不修代码、不兼五check/完整矩阵"
      ],
      "authority": [
        "最新用户明确授权最小生产修复D-G1-PATCH-REPAIR；此前D-SCOPE/D-G1-MAINTENANCE仍有效，Git禁令不变",
        "Context本次受影响PRD/Spec/ADR reuse；既有retained Forge patch/userdev/AT/nested baseline维护，无新产品/架构/规范行为"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "codev-forge-patch-r03v generation1完整completed；Router默认只读verifier独立exit0，409成员与272inputs同树、fresh XML原双fixture真实2/2，Java8/patch/remap/JAR闭环及finally恢复通过；旧R03历史partial/blocked保持",
      "reacceptsHistoricalItemId": "G1-I04E-R03"
    },
    {
      "id": "G1-I04E-R05",
      "waveId": "G1-W03",
      "handler": "codev-task-declarations-r05 generation1；完整completed Result已接受",
      "resultCount": 1,
      "prerequisiteItemIds": [
        "G1-I04E-R04"
      ],
      "scopeAndEffects": [
        "仅三个abstract class各补org.gradle.work.DisableCachingByDefault import及自身类注解，随后两个validatePlugins实际rerun；这是task声明维护，不是G1补证或最终五check。"
      ],
      "writeOwnership": [
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不改旧evidence/shared/global caches"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-TASK-DECLARATIONS"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt"
      ],
      "plannedOutputFiles": [],
      "readableReferences": [
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-validation-diagnosis/findings.json",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md"
      ],
      "conflicts": [
        "G1-W03所有实现/测试/Gradle/format任务共享树，显式串行；不并行活动wrapper/TestKit/fixture进程",
        "修改测试只在声明owner，运行前inputs冻结；超出owner或要求生产语义/依赖变更则受影响Result blocked"
      ],
      "completionPredicate": "三owner仅import+类注解；前两because=Relocatable Gradle build-cache semantics have not been verified；CachedMinecraftTask because=Base task type configures the Minecraft cache but does not define a complete cacheable operation；getter/actions/ABI/providers/子类own cache策略/五fork值不变。core/includes两个native validator真实执行，命令exit0且各原生validation JSON为[]；局部PASS不得释放W03。",
      "requiredEvidence": [
        "三个精确diff、before/after inputs身份、native command/cwd/flags/timestamps/exit/stdout/stderr与原生两个[]报告",
        "保留既有Fabric/Forge五own DisableCachingByDefault和pre-existing CacheableTask；若同flags附带两validator亦留native结果，不增四模块owner",
        "独立新evidence/manifest/默认只读verifier；旧V01/diagnoses/historical/Git/index保全"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:validatePlugins :minecraft-codev-includes:validatePlugins --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "VG1-POST-01：三精确class声明及原生[]；如含Fabric/Forge仍用同flags且真实执行；禁止任务缓存/UP-TO-DATE伪通过"
      ],
      "verificationIds": [
        "VG1-POST-01"
      ],
      "authority": [
        "D-SCOPE/D-G1-MAINTENANCE持续；D-G1-TASK-DECLARATIONS仅三class import/注解已确认；完整G1必要直接测试补证原许可持续",
        "Context逐family PRD/Spec/同一ADR reuse；不修改权威、依赖/ASM/engine、版本、AT/nested政策或Git/index"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "codev-task-declarations-r05 generation1完整completed；VG1-POST-01原生core/includes两validator实际rerun exit0/[]；三精确class声明，31新包成员与24旧包10049成员保全，generated及ignored Ruff偏差单列。Router按完整Result接受，不宣称完整G1或五check通过。"
    },
    {
      "id": "G1-I04E-P01",
      "waveId": "G1-W03",
      "handler": "codev-producer-direct-proof-p01；generation5 completed 已接受",
      "resultCount": 1,
      "prerequisiteItemIds": [
        "G1-I04E-R05"
      ],
      "scopeAndEffects": [
        "一个coupled producer验证结果：真实operation/cache恢复与状态隔离及failure contract closure。复用既有四套fixture和installed TestKit/engine，缺失断言就地补接；不复制实现或扩张生产owner。"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不改旧evidence/shared/global caches"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-TASK-DECLARATIONS"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java"
      ],
      "plannedOutputFiles": [],
      "readableReferences": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md"
      ],
      "conflicts": [
        "G1-W03所有实现/测试/Gradle/format任务共享树，显式串行；不并行活动wrapper/TestKit/fixture进程",
        "修改测试只在声明owner，运行前inputs冻结；超出owner或要求生产语义/依赖变更则受影响Result blocked"
      ],
      "completionPredicate": "固定此测试树，producer先有真实SUCCESS且保存target+records，然后仅移走generated outputs并从既有local Gradle build cache实际FROM-CACHE恢复；记录精确TaskOutcome.FROM_CACHE、恢复pair内容/binding/hash，fresh consumer首次执行SUCCESS而非旧输出/UP-TO-DATE，调用target行为并reopen source配置。same JVM A有custom engine-chain remapper、真实映射注入/plugin/side结果，B无mapping且有未映射配置，调用B原身份目标证明不泄漏；原no-config B独立观察继续复用。记录operation child类的engine/ASM/provenance，不用外层resolved metadata代替；unsupported bytecode、engine-invalid config、unavailable injector均fresh显式失败且无新success/pair。全部现存非新义务的positive基于本树fresh XML+artifact closure复用。",
      "requiredEvidence": [
        "独立新command/日志/fresh XML/fixture脚本/JAR及record pairs；cache warm/restored/fresh consumer三阶段task outcome与路径/hash绑定",
        "A→B同JVM、真实invoked值与classes/remapper身份；从OperationRunner.Domain MixinEnvironment/ASM ClassReader/ClassVisitor及适配类采集CodeSource、资源/JARhash、package/ASM版本，parent delegate归属明确",
        "三类unsupported失败native stack/root cause/class major/config/injector身份、success absent/publication拒绝；原dependencies/no Extras不变",
        "closure ledger区分fresh producer/cache/consumer、历史reference和未执行；本项不是最终矩阵验收"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:test --tests net.msrandom.minecraftcodev.mixins.MixinPreapplicationTests --tests net.msrandom.minecraftcodev.mixins.MixinInputBindingTests --tests net.msrandom.minecraftcodev.mixins.MixinMappingTests --tests net.msrandom.minecraftcodev.mixins.MixinFailureStageTests --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "VG1-POST-02：outer test task实际运行；nested cache restore显式使用--build-cache但不得--rerun-tasks，以TaskOutcome.FROM_CACHE判定；fresh nested consumer仅正常首次执行；同JVM/provenance/失败诊断闭环"
      ],
      "verificationIds": [
        "VG1-POST-02"
      ],
      "authority": [
        "D-SCOPE/D-G1-MAINTENANCE持续；D-G1-TASK-DECLARATIONS仅三class import/注解已确认；完整G1必要直接测试补证原许可持续",
        "Context逐family PRD/Spec/同一ADR reuse；不修改权威、依赖/ASM/engine、版本、AT/nested政策或Git/index"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "generation5 完整 completed Result；固定命令 fresh25/25、native exit0；Router detached receipt SHA-256表示修正后独立默认verifier exit0；仅释放P02，历史失败/blocked保留。"
    },
    {
      "id": "G1-I04E-P02",
      "waveId": "G1-W03",
      "handler": "codev-consumer-direct-proof-p02；generation4 completed 已接受",
      "resultCount": 1,
      "prerequisiteItemIds": [
        "G1-I04E-P01"
      ],
      "scopeAndEffects": [
        "一个coupled消费端验证结果：绑定P01的真实producer/evidence，精确安全清理→loader/provider→legacy与touched retained-baseline compatibility。沿现有fixtures补观察；只有下面单个Forge baseline test为planned output，不预授权泛写test/resources/production。"
      ],
      "writeOwnership": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeRetainedBaselineTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不改旧evidence/shared/global caches"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-TASK-DECLARATIONS"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeRetainedBaselineTests.kt"
      ],
      "plannedOutputFiles": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeRetainedBaselineTests.kt"
      ],
      "readableReferences": [
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md"
      ],
      "conflicts": [
        "G1-W03所有实现/测试/Gradle/format任务共享树，显式串行；不并行活动wrapper/TestKit/fixture进程",
        "修改测试只在声明owner，运行前inputs冻结；超出owner或要求生产语义/依赖变更则受影响Result blocked"
      ],
      "completionPredicate": "同consumer闭环证明Foo与FooExtra和另一package exact身份、client/server/unattempted entries/unknown nested metadata/resource保持；one mixin two-target全部成功，经真实consumer删除该entry及仅exhausted config/ref，同时partial/missing/skipped/failed/no-residual-unknown拒绝无selective发布继续fresh复用。真实Fabric ServiceLoader/provider配置运行、换side/environment重执行，reopen retained/deleted refs；第三方all-delete-only provider显式selective unsupported无输出，但同provider在legacy Strip路径仍全删成功。A1旧无mapping Mixin注册、StripMixins<None>真实Gradle registerTransform+artifact resolution无新必填参数，调用实际目标并检查旧全删；不能只direct.transform替代注册。有界非空AT沿ResolvePatchedMinecraft所用现存TransformerProcessor.main实际入口执行并观察access变化，产物与G1前后保持；nested payload bytes、JarJar list/remove原语与非Mixin metadata通过真实现有handler/cleanup reopen比较。该baseline只保留原能力，不认证完整AT规则/嵌套平台矩阵或改政策。",
      "requiredEvidence": [
        "新的producer target/records/source→consumer cleaned关联、fresh XML/native logs及invoked行为/reopened JSON/manifest/TOML资源语义比较",
        "test-only provider变体在generated jar隔离，用既有FixtureMixinRule/service owner可读接线；选择拒绝与legacy成功必须同第三方provider，新边界不冒充Fabric/Forge",
        "A1 TestKit真实旧task注册及Gradle registerTransform artifact resolve结果；legacy generic ABI/全删不新增args",
        "ForgeRetainedBaselineTests.kt为唯一新test output；真实非空AT processor来源与access前后/可执行probe、nested payload/hash/metadata原处理观察；原PatchedMinecraft两fixture的fresh既有check结果再由V02闭合task wiring；禁止把单CLI调用冒充完整Resolve task",
        "复用现有FabricApplicabilityRepairTests.providerChainReexecutesOnSideAndEnvironmentChanges与两metadata suites，补缺观测而非另造重复实现测试；无法到达原有baseline入口时精确blocked该覆盖"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:test :minecraft-codev-fabric:test :minecraft-codev-forge:test --tests \"*MixinPreapplicationTests\" --tests \"*MixinInputBindingTests\" --tests \"*MixinSafeRetentionTests\" --tests \"*LegacyStripMixinsTests\" --tests \"*FabricApplicabilityRepairTests\" --tests \"*FabricMixinMetadataTests\" --tests \"*ForgeMixinMetadataTests\" --tests \"*ForgeRetainedBaselineTests\" --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "VG1-POST-03：各module filter至少匹配本module现存/目标test，fresh XML无失败/错误/跳过；Gradle legacy registration与service provider必须runtime直证，tree冻结后运行"
      ],
      "verificationIds": [
        "VG1-POST-03"
      ],
      "authority": [
        "D-SCOPE/D-G1-MAINTENANCE持续；D-G1-TASK-DECLARATIONS仅三class import/注解已确认；完整G1必要直接测试补证原许可持续",
        "Context逐family PRD/Spec/同一ADR reuse；不修改权威、依赖/ASM/engine、版本、AT/nested政策或Git/index"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "generation4 完整 completed Result，continuation-g4固定最终identity b2e9afeef8f811468a44569c03f9019ab36c640ac513db0e218c8e6e4cd84e5b；fresh56/56/native exit0，Router独立后台默认只读verifier exit0；273inputs/原P02 9577成员/26历史包14525成员保全，仅释放V02。generation3 partial原字节保留。"
    },
    {
      "id": "G1-I04E-V02",
      "waveId": "G1-W03",
      "handler": "codev-final-five-check-v02；generation4 partial，core lint与A11 Java8观察待只读核查",
      "resultCount": 1,
      "prerequisiteItemIds": [
        "G1-I04E-P02"
      ],
      "scopeAndEffects": [
        "独立最终只读运行/证据Result；不得兼写代码/测试/配置/版本、修复、审计或Git。冻结R05/P01/P02后新inputs及tree identity，全五check+全A/AC矩阵；V01 partial原样保留，不重封。"
      ],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不改旧evidence/shared/global caches"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-TASK-DECLARATIONS"
      ],
      "ownedProjectFiles": [],
      "plannedOutputFiles": [],
      "readableReferences": [
        "docs/adr/mixin-operation-isolation.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/acceptance-matrix.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-validation-diagnosis/findings.json",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule"
      ],
      "conflicts": [
        "G1-W03所有实现/测试/Gradle/format任务共享树，显式串行；不并行活动wrapper/TestKit/fixture进程",
        "修改测试只在声明owner，运行前inputs冻结；超出owner或要求生产语义/依赖变更则受影响Result blocked"
      ],
      "completionPredicate": "五模块check同最终identity实际exit0；fresh XML failures/errors/skipped=0并记录实际TaskOutcome。全A1–A12/AC1–AC12与inputs/cache/legacy/metadata/mapping、retained baseline按现行authority逐行闭环，P01/P02closure事实在同identity复验或满足下面明确复用条件；无partial/blocked条目。各validation/lint/TestKit/fixture native结果及结束后identity保全，脚本默认只读exit0。只有完整completed Result被Router核验才重新接受I04E并释放W03/I05；本准备不能释放。",
      "requiredEvidence": [
        "新独立最终command/exit/stdout/stderr/五native check与validation/lint/fresh XML、五版本和branch/HEAD/index、全部相关fixture paths/hash/timestamps",
        "最终before/afterinputs+完整tree identity；273或新增test后实际数量据实记录，不预设未来仍272；旧272inputs/V01只历史锚",
        "全A/AC closure matrix逐行列authority clause/current方法/命令/XML testcase/actual target+evidence+cleaned/resource/binding与失败原生观察、支持或精确blocked边界；禁止历史PASS/旧XML/UP-TO-DATE/仅manifest代替必要runtime",
        "复用P01/P02仅final inputs identity完全相同且closure artifact/record binding/hash未漂移、生成命令与fresh执行来源可读；最终check task若UP-TO-DATE仅说明重复调度，由--rerun-tasks fresh重跑，不能拿其做必需运行证明",
        "operation child engine/ASM provenance、bytecode/config/injector native诊断与锁定deps对照；A1 registration及AT/nested bounded维持原义；旧19包/两诊断/V01 partial与失败历史保持；无遗留活动wrapper/tests/fixtures"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --rerun-tasks --stacktrace --configuration-cache --console=plain",
        "VG1-POST-04结合既有A1–A12/AC1–AC12：同最终identity真实五check、完整A/AC与retained-baseline matrix；必要direct fixtures同树fresh复跑，不用changedInputs历史身份代替最终身份"
      ],
      "verificationIds": [
        "VG1-POST-04"
      ],
      "authority": [
        "D-SCOPE/D-G1-MAINTENANCE持续；D-G1-TASK-DECLARATIONS仅三class import/注解已确认；完整G1必要直接测试补证原许可持续",
        "Context逐family PRD/Spec/同一ADR reuse；不修改权威、依赖/ASM/engine、版本、AT/nested政策或Git/index"
      ],
      "lastResultStatus": "partial",
      "resultProvenance": "generation4完整partial Result与continuation-g3默认只读verifierRouter独立exit0；identity373f897c8fcce3487fb85cb1a8566326aa4a557dfd42536248faa460fd097e9b，273inputs/nativeexit1，mixins/Fabric/Forge check成功，core lint39违规阻断core/includes；fresh62tests零失败，双ForgeTestKit2/2但compileJava UP-TO-DATE，A11/AC11 partial。2586成员封包和旧证据保全；环境原值未捕获/Ruff偏差保留，不释放W03/I05。",
      "requiredModuleChecks": [
        ":minecraft-codev-mixins:check",
        ":minecraft-codev-fabric:check",
        ":minecraft-codev-forge:check",
        ":minecraft-codev-core:check",
        ":minecraft-codev-includes:check"
      ],
      "acceptanceIds": [
        "A1",
        "A2",
        "A3",
        "A4",
        "A5",
        "A6",
        "A7",
        "A8",
        "A9",
        "A10",
        "A11",
        "A12",
        "AC1",
        "AC2",
        "AC3",
        "AC4",
        "AC5",
        "AC6",
        "AC7",
        "AC8",
        "AC9",
        "AC10",
        "AC11",
        "AC12"
      ],
      "reacceptsHistoricalItemId": "G1-I04E",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-V01"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02"
      ],
      "historicalOnly": true,
      "supersededForAcceptanceByItemId": "G1-I04E-R10",
      "historicalDisposition": "Original ID/latest generation4 partial/full Results and all failure evidence are immutable historical-only. Never rerun/capture/reseal or require this partial as a completed continuation prerequisite; R08 is current acceptance.",
      "historicalAcceptanceSuccessorItemId": "G1-I04E-R08"
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-CORE-JAVA8-CONTINUATION"
      ],
      "plannedOutputFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt"
      ],
      "conflicts": [
        "同一actual树的source/config/test/provider、Gradle/TestKit/build输出与Git共享责任冲突；R06→R07→R08显式串行，无并行wrapper/test/formatter/writer。",
        "各item仅独立新evidence与必要generated outputs；全部旧包/default receipt/失败历史只读，不清cache；运行阶段树冻结。"
      ],
      "authority": [
        "D-G1-CORE-JAVA8-CONTINUATION: 用户最新“授权两项最小扩展（推荐）”；原D-SCOPE/D-G1-MAINTENANCE/G1必要直接闭包持续。",
        "Context本轮逐family PRD/Spec/同一ADR reuse；不修改authority、算法、literals/annotations/providers、deps/五fork/原fixture/断言/未知owner或Git。"
      ],
      "lastResultStatus": "blocked",
      "resultProvenance": {
        "source": "codev-v02-core-lint-repair-r06",
        "generation": 1,
        "status": "blocked",
        "reason": "Content formatting and seven rename/API preservation are two independently observable outcomes; Handler stopped before execution.",
        "sourceKind": "Router supplied inline full Result; no invented on-disk Result reference",
        "sideEffects": "No source/rename/build/evidence side effects."
      },
      "historicalPrerequisiteItemIds": [
        "G1-I04E-V02"
      ],
      "historicalEvidence": [
        {
          "source": "codev-v02-core-lint-scope-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. 39 lint findings / 17 files; 38 existing forms and one R01 getter layout; no HEAD runtime baseline."
        },
        {
          "source": "codev-v02-java8-fresh-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. Nested argv does not inherit outer rerun; both compileJava UP-TO-DATE; historical skip reason not established."
        },
        {
          "itemId": "G1-I04E-V02",
          "status": "partial",
          "generation": 4,
          "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
          "role": "historical evidence only, never completed precondition"
        }
      ],
      "id": "G1-I04E-R06",
      "handler": "一个implement-change Handler，一个R06完整Result；精确core样式/ABI保全及同项必要证明",
      "objective": "在17原core文件/7dest中修复39已报告lint与filename并保全七既有JVM facade/API及旧caller links",
      "prerequisiteItemIds": [
        "G1-I04E-P02"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-P02"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不写其他source/test/config/旧evidence/global caches"
      ],
      "scopeAndEffects": [
        "只修诊断import/标点/缩进/换行及七filename；四JvmName按renameOperations明列；package/type/function/短路/算法/literals/annotations/providers/版本/deps不变。",
        "case-only rename用唯一临时名两步实体移动，核对真实basename与唯一casefold；禁止write-new/delete-old。",
        "任何compile前保全七facade/JAR/API/default桥/Kotlin可见API与旧caller字节；新full compile/JAR/type resolution/旧binary links验证；只允许单列SourceFile/SMAP/source-JAR变化。",
        "可运行现有core/includes lint前置暴露未知owner违规，不修未知owner、不关闭check；old-path regression有界，empty core tests不作行为证明；全五check只R08。"
      ],
      "completionPredicate": "17文件/7dest精确diagnostic等价修复完成且四JvmName/七facade/API/默认桥/Kotlin可见API/旧binary links保全；core主源码lint真实rerun exit0、full core compile与core JAR/type resolution实际成功、core/includes native validatePlugins真实rerun exit0且两个原生报告[]。必要老路径回归与未到达lint前置结果如实记录，无未知owner修复；超scope或ABI无法保全则受影响Result blocked，不释放R07/R08。",
      "requiredEvidence": [
        "逐39finding到精确diff映射、17原owner/7dest身份/rename实体轨迹/真实basename/临时名无残留与before-after hashes；四JvmName明列。",
        "compile前七facade/API descriptors/default桥/Kotlin metadata/API与旧caller/JAR字节封存；full compile/core JAR/type resolution与保留旧caller的binary links验证，禁止重编caller替代。",
        "core ktlint --rerun-tasks exit0/native空报告，真实full compile非FROM-CACHE/UP-TO-DATE、JAR API比对、core/includes validators exit0及[]；既有core/includes lint前置未知违规仅披露。",
        "annotations/getter/cache/provider、literals/算法/依赖/五fork/其他inputs与旧封包/Git保全；仅必要generated outputs。"
      ],
      "verification": [
        "先保存compile前七facade/JAR/API和旧caller；任何runtime未在本图准备执行。",
        ".\\gradlew.bat :minecraft-codev-core:ktlintMainSourceSetCheck :minecraft-codev-includes:ktlintMainSourceSetCheck --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；必要既有lint前置未知违规如实记录，不能修其他owner。",
        "真实full core compileKotlin/core jar + type resolution/API/default桥/Kotlin可见API/旧binary links；--rerun-tasks --no-build-cache，仅必要generated状态可逆封存后使用现有full-rebuild机制，禁止清共享cache。",
        ".\\gradlew.bat :minecraft-codev-core:validatePlugins :minecraft-codev-includes:validatePlugins --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；要求exit0/native []；必要有界old-path regression，不把empty tests当行为PASS。"
      ],
      "verificationIds": [
        "VG1-POST-05"
      ],
      "readableReferences": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json"
      ],
      "renameOperations": [
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
          "oldFacade": "GetMinecraftFileKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
          "oldFacade": "ServerExtractionStateKt",
          "fileJvmName": "ServerExtractionStateKt",
          "caseOnly": false,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
          "oldFacade": "Build_utilsKt",
          "fileJvmName": "Build_utilsKt",
          "caseOnly": false,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
          "oldFacade": "ExtensionKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
          "oldFacade": "IsUnobfuscatedVersionKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
          "oldFacade": "Path_utilsKt",
          "fileJvmName": "Path_utilsKt",
          "caseOnly": false,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt",
          "oldFacade": "Source_set_helpersKt",
          "fileJvmName": "Source_set_helpersKt",
          "caseOnly": false,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        }
      ],
      "fileJvmNamePreservation": {
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt": "ServerExtractionStateKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt": "Build_utilsKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt": "Path_utilsKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt": "Source_set_helpersKt"
      },
      "requiredBeforeCompile": [
        "七个旧facade/class/JAR字节与hash",
        "旧caller compiled bytes/hash/API与来源",
        "JVM descriptors/default参数桥/Kotlin可见API基线"
      ],
      "historicalOnly": true,
      "executionDisposition": "historical-only; compound Handler stopped before execution; never a completion prerequisite",
      "supersededForExecutionByItemIds": [
        "G1-I04E-R06A",
        "G1-I04E-R06B"
      ],
      "historicalReferenceReconciliation": [
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        }
      ]
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-CORE-JAVA8-CONTINUATION"
      ],
      "plannedOutputFiles": [],
      "conflicts": [
        "同一actual树的source/config/test/provider、Gradle/TestKit/build输出与Git共享责任冲突；R06A→R06B→R07→R08显式串行，无并行wrapper/test/formatter/writer。",
        "各item仅独立新evidence与必要generated outputs；全部旧包/default receipt/失败历史只读，不清cache；运行阶段树冻结。"
      ],
      "authority": [
        "D-G1-CORE-JAVA8-CONTINUATION: 用户最新“授权两项最小扩展（推荐）”；原D-SCOPE/D-G1-MAINTENANCE/G1必要直接闭包持续。",
        "Context本轮逐family PRD/Spec/同一ADR reuse；不修改authority、算法、literals/annotations/providers、deps/五fork/原fixture/断言/未知owner或Git。"
      ],
      "lastResultStatus": "partial",
      "resultProvenance": "codev-v02-core-content-lint-r06a generation1完整Result与Router独立verifier已核对；严格范围partial原样保留，仅Ruff缓存漂移。",
      "acceptedCompletionStatus": "completed",
      "completionAcceptanceBasis": "Router接受本item功能完成条件：32内容finding已消除、fresh完整lint exit1恰剩七原filename、native core compile实际exit0、17/17 PSI等价、14owner/259其余inputs与277证据成员及旧包/Git保全；strictScopePassed=false不提升为strict completed，不释放W03/I05。",
      "resultEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-V02",
        "G1-I04E-R06"
      ],
      "historicalEvidence": [
        {
          "source": "codev-v02-core-lint-scope-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. 39 lint findings / 17 files; 38 existing forms and one R01 getter layout; no HEAD runtime baseline."
        },
        {
          "source": "codev-v02-java8-fresh-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. Nested argv does not inherit outer rerun; both compileJava UP-TO-DATE; historical skip reason not established."
        },
        {
          "itemId": "G1-I04E-V02",
          "status": "partial",
          "generation": 4,
          "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
          "role": "historical evidence only, never completed precondition"
        },
        {
          "source": "codev-v02-core-lint-repair-r06",
          "generation": 1,
          "status": "blocked",
          "reason": "Content formatting and seven rename/API preservation are two independently observable outcomes; Handler stopped before execution.",
          "sourceKind": "Router supplied inline full Result; no invented on-disk Result reference",
          "sideEffects": "No source/rename/build/evidence side effects."
        }
      ],
      "id": "G1-I04E-R06A",
      "handler": "一个implement-change Handler，一个完整R06A Result；唯一32条内容规则修复及同项必要证明",
      "objective": "唯一outcome：原生报告32条非filename内容规则修复；仅17原sourceOwners中已报告imports/标点/缩进/换行/注解布局，保持语义等价与core compile类型解析。",
      "prerequisiteItemIds": [
        "G1-I04E-P02"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-P02"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/**",
        "仅本item必要build/.gradle/generated outputs；不清/移走state/cache，不写其他source/test/config/旧evidence/global caches"
      ],
      "scopeAndEffects": [
        "只写冻结17原sourceOwners的已报告内容规则。14个有内容违规；另三个filename-only文件无需修改，字节保全。不rename、不新增JvmName、不关闭/筛掉filename、不改caller/fixture/断言/生产算法。保全算法、常量、注解语义、providers、依赖/版本、旧caller与其他owner；不清任务增量或缓存，不授权R02C式移走state。真实compile暴露旧incremental state则据实partial。"
      ],
      "completionPredicate": "一个完整R06A Handler/Result：32条内容规则均已解决；未重命名、未添加JvmName、未改caller或其他owner；fresh原生core lint exit1且完整报告恰剩原七source的standard:filename、无新增/其他违规；独立native core compile exit0证明类型解析，语义等价保全成立。预期exit1不是full lint0或最终gate通过；七残余明确由R06B闭合。",
      "requiredEvidence": [
        "原32内容finding→精确diff/语义等价映射、17原owner逐项before/after及三filename-only字节保全；无rename/JvmName/caller/其他owner变化。",
        "fresh原生core lint完整stdout/stderr/exit1/native报告；恰七原source的standard:filename，无新增/其他违规；命令不filter/disable规则。",
        "独立native core compile实际执行exit0、类型解析、原literal/算法/注解语义/providers/deps/五fork/其他inputs/旧封包/Git保全；lint预期失败不作full gate0。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:ktlintMainSourceSetCheck --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；预期exit1，native完整报告恰七原filename，不filter/disable。",
        ".\\gradlew.bat :minecraft-codev-core:compileKotlin --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；与预期lint失败分开执行，要求native真实类型解析成功exit0；不移走/清增量state/cache。"
      ],
      "verificationIds": [
        "VG1-POST-05A"
      ],
      "readableReferences": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json",
        "docs/works/mixin-rework/evidence/g1-implementation/v02-core-java8-plan/continuation-g2/scope.json",
        "docs/works/mixin-rework/evidence/g1-implementation/v02-core-java8-plan/continuation-g2/README.md"
      ],
      "contentRuleOwnerFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt"
      ],
      "unchangedFilenameOnlyFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt"
      ],
      "expectedNativeLint": {
        "exit": 1,
        "remainingRule": "standard:filename",
        "remainingCount": 7,
        "remainingSources": [
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt"
        ],
        "fullLintGatePassed": false
      },
      "structuralReadiness": "R06A功能完成已由Router独立核验接受；Handler/raw strict Result partial保留，唯一Ruff背景不影响源码/类型/输入谓词；本节点已实施，R06B可接续。",
      "historicalReferenceReconciliation": [
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        }
      ]
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-CORE-JAVA8-CONTINUATION"
      ],
      "plannedOutputFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt"
      ],
      "conflicts": [
        "同一actual树的source/config/test/provider、Gradle/TestKit/build输出与Git共享责任冲突；R06A→R06B→R07→R08显式串行，无并行wrapper/test/formatter/writer。",
        "各item仅独立新evidence与必要generated outputs；全部旧包/default receipt/失败历史只读，不清cache；运行阶段树冻结。"
      ],
      "authority": [
        "D-G1-CORE-JAVA8-CONTINUATION: 用户最新“授权两项最小扩展（推荐）”；原D-SCOPE/D-G1-MAINTENANCE/G1必要直接闭包持续。",
        "Context本轮逐family PRD/Spec/同一ADR reuse；不修改authority、算法、literals/annotations/providers、deps/五fork/原fixture/断言/未知owner或Git。"
      ],
      "lastResultStatus": "partial",
      "resultProvenance": "codev-v02-core-rename-abi-r06b generation1完整raw partial及Router独立verification.py exit1均核对；新debug coverage Result completed/reproduce exit0已独立核对，旧strict-debug/scope失败保留。",
      "acceptedCompletionStatus": "completed",
      "completionAcceptanceBasis": "在本item精确lineNumberTableReconciliation澄清后接受功能完成：七实体rename/四JvmName/三默认facade、真实core compile/JAR/lint/core+includes validators0、158runtime/API/metadata/旧caller字节和链接保全；八类166LNT恰+2及BCI/count/order不变已独立复现。raw partial及原strict-debug/scope false不改写；Ruff未知writer不是授写权，不宣称全仓strict完成/G1门禁。",
      "resultEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-V02",
        "G1-I04E-R06"
      ],
      "historicalEvidence": [
        {
          "source": "codev-v02-core-lint-scope-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. 39 lint findings / 17 files; 38 existing forms and one R01 getter layout; no HEAD runtime baseline."
        },
        {
          "source": "codev-v02-java8-fresh-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. Nested argv does not inherit outer rerun; both compileJava UP-TO-DATE; historical skip reason not established."
        },
        {
          "itemId": "G1-I04E-V02",
          "status": "partial",
          "generation": 4,
          "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
          "role": "historical evidence only, never completed precondition"
        },
        {
          "source": "codev-v02-core-lint-repair-r06",
          "generation": 1,
          "status": "blocked",
          "reason": "Content formatting and seven rename/API preservation are two independently observable outcomes; Handler stopped before execution.",
          "sourceKind": "Router supplied inline full Result; no invented on-disk Result reference",
          "sideEffects": "No source/rename/build/evidence side effects."
        }
      ],
      "id": "G1-I04E-R06B",
      "handler": "一个implement-change Handler，一个完整R06B Result；唯一七文件命名迁移且API兼容不变及同项必要证明",
      "objective": "唯一outcome：冻结七文件物理命名迁移且兼容性不变；四显式fixed JVM facade保全、三默认facade通过真实编译核对和旧binary链接实证。",
      "prerequisiteItemIds": [
        "G1-I04E-R06A"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R06A"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/**",
        "仅本item必要build/.gradle/generated evidence probes；不新增项目test/build owner，不清/移走state/cache，不写其他source/test/config/旧evidence/global caches"
      ],
      "scopeAndEffects": [
        "只写原七source/destination及四@file:JvmName必要的相邻注解格式，不泛修另外十source。显式fixed仅ServerExtractionStateKt/Build_utilsKt/Path_utilsKt/Source_set_helpersKt；GetMinecraftFileKt/ExtensionKt/IsUnobfuscatedVersionKt是默认名，需实证，不称七fixed授权。三个case-only路径必须同目录unique临时basename两步实体rename；临时路径记录且不新增test/build owner。允许generated evidence probe，旧caller归档后禁止修改/重编。SourceFile/SMAP/source-JAR路径变化及本item精确lineNumberTableReconciliation八类166项LNT+2允许，不忽略其他debug变化；原strict-debug失败保留。保全算法、常量、注解语义、providers、依赖/版本、旧caller与其他owner；不清任务增量或缓存，不授权R02C式移走state。真实compile暴露旧incremental state则据实partial。"
      ],
      "completionPredicate": "一个完整R06B Handler/Result：七source→destination实体rename完成，case/真实目录项逐项核对；迁移前归档七facade/JAR/API/default桥/Kotlin metadata及旧caller字节，迁移后完整core compile/JAR、native core/includes validatePlugins及完整core lint均exit0；四显式fixed和三默认facade均通过编译/JAR/API/default桥/Kotlin metadata/旧binary链接实证，无重编或修改旧caller掩盖ABI变化。SourceFile/SMAP/source-JAR路径差异及本item精确lineNumberTableReconciliation八类166项LNT+2允许，逐method/table count/order/BCI不变及其他条目保持；其他runtime/API/metadata保持，原strict-debug失败保留。编译若暴露旧incremental state则partial，不移走/清除缓存。",
      "requiredEvidence": [
        "迁移前七facade/class/JAR/API/descriptors/default桥/Kotlin metadata与旧caller字节/hash/来源；四显式fixed、三默认名严格区分，不能只源码推断。",
        "七实体rename轨迹，三case-only同目录唯一临时basename两步实体移动、真实case/唯一casefold目录项/临时名无残留；SourceFile/SMAP/source-JAR路径差异单列。",
        "真实完整core compile/JAR/type resolution、新旧API/default桥/Kotlin metadata及七facade binary links；原旧caller字节不改、不重编，generated evidence probe不新增项目owner。",
        "core lint --rerun-tasks完整exit0/native无违规、core/includes native validatePlugins exit0且[]；增量state故障partial原生记录，不预授权R02C式移走/清cache；另十source与其他owner保全。"
      ],
      "verification": [
        "任何R06B compile前保存迁移前七facade/JAR/API/default桥/Kotlin metadata/原旧caller字节；不修改或重编旧caller。",
        ".\\gradlew.bat :minecraft-codev-core:compileKotlin :minecraft-codev-core:jar --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；要求真实完整compile/JAR/type resolution exit0与API/default桥/Kotlin metadata/旧binary links证据；不移动/清增量state/cache，失败partial。",
        ".\\gradlew.bat :minecraft-codev-core:ktlintMainSourceSetCheck :minecraft-codev-core:validatePlugins :minecraft-codev-includes:validatePlugins --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；全部exit0、完整core lint无违规、native validators []；未知owner只披露不修。"
      ],
      "verificationIds": [
        "VG1-POST-05B"
      ],
      "readableReferences": [
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/bundled/BundledClientJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/LegacyJarSplitter.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/legacy/ServerFixer.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftMarker.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/MinecraftVersionMetadata.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/VanillaSplittingState.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Cache.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Hash.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/ManifestSignatureRemover.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json",
        "docs/works/mixin-rework/evidence/g1-implementation/v02-core-java8-plan/continuation-g2/scope.json",
        "docs/works/mixin-rework/evidence/g1-implementation/v02-core-java8-plan/continuation-g2/README.md"
      ],
      "renameOperations": [
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/getMinecraftFile.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/GetMinecraftFile.kt",
          "oldFacade": "GetMinecraftFileKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt",
          "oldFacade": "ServerExtractionStateKt",
          "fileJvmName": "ServerExtractionStateKt",
          "caseOnly": false,
          "method": "physical source-to-destination rename; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt",
          "oldFacade": "Build_utilsKt",
          "fileJvmName": "Build_utilsKt",
          "caseOnly": false,
          "method": "physical source-to-destination rename; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/extension.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/Extension.kt",
          "oldFacade": "ExtensionKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/isUnobfuscatedVersion.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/IsUnobfuscatedVersion.kt",
          "oldFacade": "IsUnobfuscatedVersionKt",
          "fileJvmName": null,
          "caseOnly": true,
          "method": "two-step physical rename through a unique temporary name; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt",
          "oldFacade": "Path_utilsKt",
          "fileJvmName": "Path_utilsKt",
          "caseOnly": false,
          "method": "physical source-to-destination rename; real basename and unique casefold identity checked; never write-new/delete-old"
        },
        {
          "source": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "destination": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt",
          "oldFacade": "Source_set_helpersKt",
          "fileJvmName": "Source_set_helpersKt",
          "caseOnly": false,
          "method": "physical source-to-destination rename; real basename and unique casefold identity checked; never write-new/delete-old"
        }
      ],
      "fileJvmNamePreservation": {
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionResult.kt": "ServerExtractionStateKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/BuildUtils.kt": "Build_utilsKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/PathUtils.kt": "Path_utilsKt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/SourceSetHelpers.kt": "Source_set_helpersKt"
      },
      "requiredBeforeCompile": [
        "七个旧facade/class/JAR字节与hash",
        "旧caller compiled bytes/hash/API与来源",
        "JVM descriptors/default参数桥/Kotlin可见API基线"
      ],
      "explicitFixedFacades": [
        "ServerExtractionStateKt",
        "Build_utilsKt",
        "Path_utilsKt",
        "Source_set_helpersKt"
      ],
      "defaultFacadesRequiringCompileEvidence": [
        "GetMinecraftFileKt",
        "ExtensionKt",
        "IsUnobfuscatedVersionKt"
      ],
      "temporaryRenameOwnership": "Only same-source-directory unique ephemeral basename for three case-only moves; record actual path; never task state/cache movement or new test/build owner",
      "allowedCompatibilityDifferences": [
        "SourceFile",
        "SMAP",
        "source-JAR paths",
        "Only this item lineNumberTableReconciliation: exact 8 classes / 28 methods / 166 entries +2, table count/order/BCI unchanged; original strict-debug false preserved"
      ],
      "lineNumberTableReconciliation": {
        "source": "codev-r06b-debug-contract-assessment generation1 completed and Router independent reproduce.py exit0",
        "inputIdentity": "477d38dd2e0b4604d4f67a04c5e84fc5b6e72b61ccbbd0c7ac2f7c9056fdeb00",
        "classPrefix": "net/msrandom/minecraftcodev/core/",
        "classes": [
          "resolve/ServerExtractionResult.class",
          "resolve/ServerExtractionStateKt.class",
          "utils/Build_utilsKt$applyPlugin$2.class",
          "utils/Build_utilsKt$applyPlugin$3.class",
          "utils/Build_utilsKt.class",
          "utils/Path_utilsKt.class",
          "utils/Source_set_helpersKt$lowerCamelCaseGradleName$1.class",
          "utils/Source_set_helpersKt.class"
        ],
        "changedMethods": 28,
        "changedEntries": 166,
        "lineDelta": 2,
        "predicate": "Only exact four authorized two-line file:JvmName prefixes: method/table count, entry order and start_pc/BCI unchanged, changed line_number old+2; all other 150 classes LNT unchanged. Preserve raw Code payload/runtime/API/metadata/default bridges and sealed callers. Stacktrace line/debug location changes disclosed, not class byte equality. No arbitrary debug allowance.",
        "evidence": "docs/works/mixin-rework/evidence/g1-implementation/r06b-debug-contract-review/attempt-03-verification.json",
        "reproducer": "docs/works/mixin-rework/evidence/g1-implementation/r06b-debug-contract-review/reproduce.py",
        "binaryBinding": "R06B manifest 2024 old-core/new-core and after-final.json; review manifest 13 members and 632 read-input hashes; current input identity exact",
        "preserveOriginalStrictDebugFailure": true,
        "preserveOriginalStrictScopeFailure": true
      },
      "expectedNativeLint": {
        "exit": 0,
        "remainingCount": 0
      },
      "structuralReadiness": "R06B reconciled functional completion accepted by Router; raw partial/old strict-debug and scope failures preserved. R07 structurally ready; R08/gates still pending.",
      "historicalReferenceReconciliation": [
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/resolve/ServerExtractionState.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/build-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/path-utils.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        },
        {
          "historicalProjectLocator": "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "readableSealedSourceRef": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/before-sources/minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/utils/source-set-helpers.kt",
          "reason": "R06B已接受实体rename后的历史source；仅修引用角色，不修改原owner/Result/完成谓词或旧封包。"
        }
      ]
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-CORE-JAVA8-CONTINUATION"
      ],
      "plannedOutputFiles": [],
      "conflicts": [
        "同一actual树的source/config/test/provider、Gradle/TestKit/build输出与Git共享责任冲突；R06A→R06B→R07→R08显式串行，无并行wrapper/test/formatter/writer。",
        "各item仅独立新evidence与必要generated outputs；全部旧包/default receipt/失败历史只读，不清cache；运行阶段树冻结。"
      ],
      "authority": [
        "D-G1-CORE-JAVA8-CONTINUATION: 用户最新“授权两项最小扩展（推荐）”；原D-SCOPE/D-G1-MAINTENANCE/G1必要直接闭包持续。",
        "Context本轮逐family PRD/Spec/同一ADR reuse；不修改authority、算法、literals/annotations/providers、deps/五fork/原fixture/断言/未知owner或Git。"
      ],
      "lastResultStatus": "completed",
      "resultProvenance": "codev-v02-nested-java8-r07 generation1完整completed及Router独立默认verification.py exit0；89新成员/273inputs/旧包环境Git匹配。原双fresh2/2，两nestedcompileJava实际EXECUTED并逐fixture Java8 worker compiler stack观察；unknown Ruff delta/fullStrictScope=false保持披露，不表示G1门禁通过。",
      "acceptedCompletionStatus": "completed",
      "resultEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md",
      "acceptedInputIdentity": "93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-V02"
      ],
      "historicalEvidence": [
        {
          "source": "codev-v02-core-lint-scope-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. 39 lint findings / 17 files; 38 existing forms and one R01 getter layout; no HEAD runtime baseline."
        },
        {
          "source": "codev-v02-java8-fresh-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. Nested argv does not inherit outer rerun; both compileJava UP-TO-DATE; historical skip reason not established."
        },
        {
          "itemId": "G1-I04E-V02",
          "status": "partial",
          "generation": 4,
          "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
          "role": "historical evidence only, never completed precondition"
        }
      ],
      "id": "G1-I04E-R07",
      "handler": "一个implement-change Handler，一个R07完整Result；单一nested argv和Java8聚焦证明",
      "objective": "只给原nested GradleRunner.withArguments加--rerun-tasks并实际证明双fixture fresh Java8 compile",
      "prerequisiteItemIds": [
        "G1-I04E-R06B"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R06B"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt"
      ],
      "writeOwnership": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不写其他source/test/config/旧evidence/global caches"
      ],
      "scopeAndEffects": [
        "仅原nested withArguments(\"jar\", \"printCompileClasspath\", \"-s\")增加\"--rerun-tasks\"；不加fixture/源/断言/build root owner，不改toolchain/classpath/版本/生产/patch-remap。",
        "原Java17 outer/现存JDK8；CLI串行优先，不清cache；generated TestKit home临时发现属性before/effective/finally精确恢复。",
        "先记录原GRADLE_OPTS before存在性/受限摘要；若设置child选项，用environment copy合并，不覆盖未知原值，不泄露argv/进程环境。",
        "双原TestKit真实2/2，nested compileJava EXECUTED/SUCCESS和Java8 compiler/toolchain必须与对应basic/remapped fixture绑定；major52/JAR/patch-remap reopen仅一致性。"
      ],
      "completionPredicate": "仅原宿主单一nested argv增加rerun；原双TestKit fresh XML 2/2零failure/error/skipped、两nested compileJava真实执行并以Java8 compiler/toolchain原生记录逐fixture绑定，major52/JAR/patch-remap一致性重开；generated TestKit home before/effective/finally精确恢复与原GRADLE_OPTS before/child合并保全成立。无fresh compiler证据准确partial/blocked，不释放R08；不修改原fixture/Java/断言/production/版本/其他owner。",
      "requiredEvidence": [
        "精确单一argv diff及原fixture/settings/Java/断言/build/root/toolchain/classpath与R06B后inputs保全。",
        "Java17 outer、现存JDK8工具可读身份，原双TestKit exact command/exit/fresh XML；两fixture与nested argv/build路径/compileJava actual outcomes/compiler executable/version/hash/toolchain交叉绑定。",
        "nested原生compiler记录证明真实执行；major52和reopen provider/JAR/patch/remap为一致性而非compiler替代。",
        "GRADLE_OPTS before存在性/长度/受限摘要与childcopy合并、敏感选项不输出；generated发现属性before/effective/finally存在状态/bytes/hash精确恢复；旧环境未捕获限制历史保持。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-forge:test --tests \"*PatchedMinecraftTests\" --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "原nested jar/printCompileClasspath/-s/--rerun-tasks两fixture；采集真实compileJava EXECUTED/SUCCESS、Java8 compiler/toolchain和fresh2/2；不更改断言/fixture，不清cache。"
      ],
      "verificationIds": [
        "VG1-POST-06"
      ],
      "readableReferences": [
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json"
      ],
      "argumentChange": {
        "before": [
          "jar",
          "printCompileClasspath",
          "-s"
        ],
        "after": [
          "jar",
          "printCompileClasspath",
          "-s",
          "--rerun-tasks"
        ],
        "location": "original nested GradleRunner.withArguments only"
      },
      "generatedPropertyRestoration": {
        "path": "minecraft-codev-forge/build/tmp/test/work/.gradle-test-kit/gradle.properties",
        "stages": [
          "before",
          "effective",
          "finally"
        ],
        "predicate": "Original existence/bytes/hash exactly restored; existing JDK8 discovery only; no global/root/fixture property writes."
      }
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-MAINTENANCE",
        "D-G1-CORE-JAVA8-CONTINUATION"
      ],
      "plannedOutputFiles": [],
      "conflicts": [
        "同一actual树的source/config/test/provider、Gradle/TestKit/build输出与Git共享责任冲突；R06A→R06B→R07→R08显式串行，无并行wrapper/test/formatter/writer。",
        "各item仅独立新evidence与必要generated outputs；全部旧包/default receipt/失败历史只读，不清cache；运行阶段树冻结。"
      ],
      "authority": [
        "D-G1-CORE-JAVA8-CONTINUATION: 用户最新“授权两项最小扩展（推荐）”；原D-SCOPE/D-G1-MAINTENANCE/G1必要直接闭包持续。",
        "Context本轮逐family PRD/Spec/同一ADR reuse；不修改authority、算法、literals/annotations/providers、deps/五fork/原fixture/断言/未知owner或Git。"
      ],
      "lastResultStatus": "partial",
      "acceptedCompletionStatus": "partial",
      "resultProvenance": "codev-final-five-check-r08 generation1和2完整partial Result均已消费；原default member断言exit1保留，独立补充只读verify exit0只确认partial证据可信，不满足R08功能完成谓词。core:test JUnit Platform加载失败，core/includes check未到达，24行/direct/coreABI/compiler配对不完整，W03/I05/Git未释放。",
      "independentEvidenceAudit": {
        "status": "passed",
        "exit": 0,
        "originalDefaultExit": 1,
        "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/verification-recovery/verify.py",
        "manifestMembers": 2373,
        "supplementMembers": 12,
        "inputIdentity": "93306cf8c109ad21f8a8c5f1f720a505f4841096433bdf0f898daff780da368a",
        "functionalGatePassed": false,
        "fullStrictScope": false
      },
      "historicalPrerequisiteItemIds": [
        "G1-I04E",
        "G1-I04E-V01",
        "G1-I04E-V02",
        "G1-I04E-P01",
        "G1-I04E-P02"
      ],
      "historicalEvidence": [
        {
          "source": "codev-v02-core-lint-scope-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. 39 lint findings / 17 files; 38 existing forms and one R01 getter layout; no HEAD runtime baseline."
        },
        {
          "source": "codev-v02-java8-fresh-diagnosis",
          "generation": 1,
          "status": "completed",
          "role": "historical evidence, not a completion dependency",
          "provenance": "Full Result consumed by Router; supplied inline Handoff. Nested argv does not inherit outer rerun; both compileJava UP-TO-DATE; historical skip reason not established."
        },
        {
          "itemId": "G1-I04E-V02",
          "status": "partial",
          "generation": 4,
          "ref": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
          "role": "historical evidence only, never completed precondition"
        }
      ],
      "id": "G1-I04E-R08",
      "handler": "一个独立验证Handler，一个R08完整Result；只验证最终树，无修复/审计合并",
      "objective": "独立验证R06A/R06B/R07后当前新identity全五check与完整G1矩阵",
      "prerequisiteItemIds": [
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/**",
        "仅本item必要build/.gradle/TestKit/generated outputs；不写其他source/test/config/旧evidence/global caches"
      ],
      "scopeAndEffects": [
        "固定R06A/R06B/R07后的实际新inputs/tree，完整五modulecheck、A1-A12/AC1-AC12、P01/P02necessary direct closure、原Forge双TestKit及nativeCompiler均绑定同identity。",
        "仅evidence/必要generated outputs，无source/test/config/版本/authority/Git写权；旧I04E/V01/V02 partial与全部失败封包只历史，不capture/reseal/default重写。",
        "所有closure rows由同树fresh运行/native XML/原始log/artifact/binding关联；不继承旧P01/P02/V02身份/PASS/XML/UP-TO-DATE或manifest为runtime。"
      ],
      "completionPredicate": "R06A/R06B/R07 completed后的同一新final identity上五module check实际exit0，fresh XML零failure/error/skipped，全A1-A12/AC1-AC12及inputs/cache/legacy/metadata/mapping/retained baseline逐行完整，P01/P02necessary directclosure与原Forge双TestKit2/2/nativeJava8Compiler完整绑定；结束身份、old seals/Git保全和独立默认只读核验exit0。任何partial/blocked/failed/missing不释放W03/I05/I06/Git；仅完整completed经Router独立核验后才可重新接受I04E并判断W03/I05。",
      "requiredEvidence": [
        "新独立最终command/exit/stdout/stderr/五native check与validation/lint/fresh XML、五版本和branch/HEAD/index、全部相关fixture paths/hash/timestamps",
        "最终R06A/R06B/R07后273实现输入的真实路径/count/新identity与before/after完整tree identity；七实体rename后的路径如实绑定，禁止新增test owner；旧272/273inputs与V01/V02旧identity均只历史锚。",
        "全A/AC closure matrix逐行列authority clause/current方法/命令/XML testcase/actual target+evidence+cleaned/resource/binding与失败原生观察、支持或精确blocked边界；禁止历史PASS/旧XML/UP-TO-DATE/仅manifest代替必要runtime",
        "P01/P02 necessary direct closure须由同一新final identity fresh运行/native XML/命令/当前artifact+record绑定证明；旧P01/P02 Result仅复用方法与历史事实，不能继承旧PASS/XML；producer cache阶段仍需真实FROM-CACHE后fresh consumer。",
        "operation child engine/ASM provenance、bytecode/config/injector native诊断与锁定deps对照；A1 registration及AT/nested bounded维持原义；全部历史封包/两诊断/V01/V02 partial与失败历史保持；无遗留活动wrapper/tests/fixtures。",
        "同新identity R06B七facade/default桥/Kotlin可见API/旧binarylinks证明与R07每fixture nativeJava8Compiler观察，终于全五checks实际到达/exit0。",
        "独立完整Result与默认只读verifier证据，GRADLE_OPTS原值before记录后childcopy合并/CLI串行、generated TestKit home精确finally恢复，不泄露环境或降低门槛。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "VG1-POST-07：完整A1-A12/AC1-AC12、P01/P02necessary directclosure、原Forge双TestKit/nativeJava8Compiler同新identity fresh；producer cache阶段保持真实FROM-CACHE，不能对该nested缓存阶段强加rerun。"
      ],
      "verificationIds": [
        "VG1-POST-07"
      ],
      "readableReferences": [
        "docs/adr/mixin-operation-isolation.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/acceptance-matrix.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-validation-diagnosis/findings.json",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json"
      ],
      "requiredModuleChecks": [
        ":minecraft-codev-mixins:check",
        ":minecraft-codev-fabric:check",
        ":minecraft-codev-forge:check",
        ":minecraft-codev-core:check",
        ":minecraft-codev-includes:check"
      ],
      "acceptanceIds": [
        "A1",
        "A2",
        "A3",
        "A4",
        "A5",
        "A6",
        "A7",
        "A8",
        "A9",
        "A10",
        "A11",
        "A12",
        "AC1",
        "AC2",
        "AC3",
        "AC4",
        "AC5",
        "AC6",
        "AC7",
        "AC8",
        "AC9",
        "AC10",
        "AC11",
        "AC12"
      ],
      "reacceptsHistoricalItemId": "G1-I04E",
      "historicalOnly": true,
      "supersededForAcceptanceByItemId": "G1-I04E-R10",
      "historicalDisposition": "generation1/2 raw partial、acceptedCompletionStatus partial及全部原predicate/Result/2373+12/default exit1/2367日志保持；query只消费metadata，不提升R08。当前最终验收由R10独立完成，旧partial永不作requiredCompleted前置。"
    },
    {
      "id": "G1-I04E-R09",
      "waveId": "G1-W03",
      "handler": "一个implement-change Handler，可加载ponytail；一个R09完整Result，仅单行修复及其focused regression。",
      "resultCount": 1,
      "objective": "恢复root共享JUnit launcher声明，并以原core:test实际越过discovery首边界且原断言全部通过证明这一有界修复。",
      "prerequisiteItemIds": [
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-JUNIT-LAUNCHER-CONTINUATION"
      ],
      "confirmedScope": {
        "status": "confirmed",
        "decisionId": "D-G1-JUNIT-LAUNCHER-CONTINUATION",
        "source": "本轮Handoff inline：用户最新ask明确选择“授权查询及有界候选修复/重验”；Router已消费完整query generation1 Result，不是本writer重新问询或接受。",
        "allowedCorrection": "仅E:/Projects/cloche/minecraft-codev/build.gradle.kts共享测试dependencies块增加一条testRuntimeOnly(\"org.junit.platform:junit-platform-launcher:1.9.0-M1\")。",
        "allowedVerification": "串行原core:test及独立最终五module/24row A-AC；后继native阶段允许正常获取已声明coordinate及原TestKit 8.2/8.6/8.8 distribution，按原源码实际选择，不强换。",
        "stopBoundary": "需要other version/coordinate/owner/assertion/fixture/算法/公开运行库或material authority变化时停止受影响项并返回证据；不自动升级、安装JDK、改全局属性、五fork或Git。",
        "writerPermission": "历史R09/R10 preparation writer范围：当时仅四coordination和独立静态图证据，未运行/实施/接受。不是当前R11实施限制或泛写许可；R11只按confirmedTemporaryDisableScope单方法例外。"
      },
      "ownedProjectFiles": [
        "build.gradle.kts"
      ],
      "plannedOutputFiles": [],
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/",
      "writeOwnership": [
        "build.gradle.kts共享测试dependencies块唯一新增testRuntimeOnly(\"org.junit.platform:junit-platform-launcher:1.9.0-M1\")；不动原API/engine声明及其他依赖。",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/**（未来输出，不是已有input ref）",
        "仅native验证必要generated outputs、正常既有coordinate/原TestKit distribution获取；原generated TestKit临时JDK8发现例外若使用则独占并finally精确恢复。"
      ],
      "scopeAndEffects": [
        "在实际before树捕获root/273inputs及原配置和实际Test有序classpath/selected versions/framework/filter/javaLauncher；原query只作已完成的before机制证据，不证明未来worker。",
        "唯一单行root testRuntimeOnly launcher1.9.0-M1；其余272inputs、原五fork、public runtime/算法/fixture/断言/原测试与成功模块显式launcher不变。不新增第六fork或新test owner。",
        "after以native任务元数据确认launcher匹配Platform1.9.0-M1、Factory位于实际Test.classpath；核对core/includes原API/engine5.9.0-M1和Platform engine/commons1.9.0-M1，其他模块testRuntime selected versions有意义不一致需披露并停止未许可部分。",
        "串行fresh原core:test，五个原@Test全部执行且零failure/error/skipped；第五个Basic Minecraft Build原TestKit8.2/8.6/8.8循环与全部原断言/任务不删、不过滤、不disable、不替换。includes无测试源/NO-SOURCE不能称fresh tests passed。",
        "以新实际进程/有效Test记录关联core executor真实Java11与GradleVM17、JUnit discovery及实际测试执行；不从oldPID151144、jcmd17、缓存JAR、task静态文件或toy loader推断worker成功。",
        "candidate不足、后续core fixture失败或未知owner/版本/断言缺口：保存原native failure与修复已生效的有限范围，raw partial/blocked并停止R10；不修未知缺陷。历史scope失败、原失败streams/封包均保留。"
      ],
      "conflicts": [
        "root共享依赖影响五module实际runtime，所有source/config/test/fixture/metadata/Gradle/TestKit/generated outputs与Git责任串行；R09完成前不得运行R10或并行wrapper/test/writer。",
        "只写独立R09证据；全部旧query/diagnosis/review/R08/seals/default receipts只读；未知Ruff writer不授权、不清理、不恢复，exact path/length/hash披露。"
      ],
      "completionPredicate": "唯一root单行diff及其余272inputs/Git/authority/旧包保全；native afterTaskCP与selected train匹配、原core:test实际fresh五测试零failure/error/skipped且JUnit discovery越过原首边界、新worker Java11/GradleVM17证据绑定，真实完整Result为completed后才满足R10前置。仅metadata成功、factory entry存在或后续fixture失败均不completed，不放行G1 gate。",
      "requiredEvidence": [
        "精确用户许可来源、before/after root bytes/单行diff、273inputs新identity及其余272保全、五fork、Git/authority/旧member hashes与unknown cache exact path/hash。",
        "native before/after配置components/selected versions/constraints/reasons及实际Test ordered CP/framework/options/filter/javaLauncher；候选JAR length/hash/Factory entry与实际任务绑定，其他模块selected train对照。",
        "实际core:test argv/cwd/UTC/exit/raw stdout/stderr、fresh native XML五原tests及原TestKit distribution选择/任务日志；新process/有效task Java身份和discovery证据；后续失败分层，不能用旧62 tests代替。",
        "独立默认只读validator/真实receipt，related checks与fullStrictScope分开；未归属scope漂移如实失败，不改旧默认exit1/编码恢复/2367输出/167/176/53/2373+12/63包。"
      ],
      "verification": [
        "先核对当前273input identity与query原生before记录；临时metadata观察只写R09证据，不新增project task/dependency owner。",
        ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain；不加--tests过滤/替换原测试。",
        "VG1-POST-08：单行diff、272其余inputs保全、native afterTaskCP/selected train、fresh五core tests/实际JUnit discovery、新Java身份；不足准确partial/blocked并停止R10。"
      ],
      "verificationIds": [
        "VG1-POST-08"
      ],
      "readableReferences": [
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "build.gradle.kts",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/verify.py",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-core-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-includes-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-diagnosis-review/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/verification-recovery/README.md"
      ],
      "authority": [
        "当前精确用户许可D-G1-JUNIT-LAUNCHER-CONTINUATION；Active PRD/Spec与同一Accepted ADR按Context逐family reuse，只恢复test-only runtime，不新建/改权威。",
        "若实际暴露material authority问题，加载spec-driven-development作为受影响方法并停止该范围、返回证据；不作新accepted决定。"
      ],
      "rollbackAndRisk": [
        "launcher首机制supported但非唯一cause；静态major最大53不证明worker/TestKit兼容。既有第五测试可能出现另一个fixture/download边界，原样保留并停止，不扩大owner。",
        "不以rollback掩盖失败；若Router另行决定撤销，仅撤销本item新增单行、保留全部证据，不回滚其他输入、不清cache/修改Git。"
      ],
      "lastResultStatus": "partial",
      "acceptedCompletionStatus": "partial",
      "runtimeStatus": "executed-focused-partial",
      "lastResultEvidence": [
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/verify.py"
      ],
      "lastResultSummary": "codev-root-junit-launcher-r09 generation1完整关联；唯一root named-argument单行生效，after identity041d842bc52b9158846834f488b4fee1a739ff2482d9681f68e57e44d11b0a44，272其余inputs/52Git/原包保全。metadata exit0、实际Java11 core Executor2/Java17 Gradle9.4绑定与fresh5/1fail/0error/0skip；4pass为原空方法。Basic Minecraft Build首Gradle8.2原script19errors、8.6/8.8未到达。独立matching PowerShell默认只读exit1/errors=[]/relatedR09EvidenceChecksPassed=true/54sealedmembers/receiptCheckedtrue，fullStrictScope=false unknownRuff保持，focusedRegressionPassed=false，不接受completed，不执行R10。",
      "structuralReadiness": "实施已到原fixture编译失败边界；当前R09 partial不满足完成谓词，R10及W03/I05仍等待。只读诊断不获修改原fixture/版本/断言/生产算法的新许可。",
      "historicalOnly": true,
      "historicalDisposition": "原状态/完整receipt/完成谓词全部保留为历史；本轮active基线与终验改由R12→R13，历史partial或停用窄目标不作completed前置，不自动重跑。",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ]
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-JUNIT-LAUNCHER-CONTINUATION"
      ],
      "plannedOutputFiles": [],
      "conflicts": [
        "R09先完成，所有source/config/test/provider/Gradle/TestKit/generated outputs与Git串行；R10期间实际273input identity固定，无其他writer/wrapper/test/formatter。",
        "各旧包、raw partial、默认exit1、缓存/编码/2367历史只读；未知Ruff不授权，不清理/恢复或泛化scope allowlist。"
      ],
      "authority": [
        "当前精确用户许可D-G1-JUNIT-LAUNCHER-CONTINUATION；Active PRD/Spec与同一Accepted ADR按Context逐family reuse，只恢复test-only runtime，不新建/改权威。",
        "若实际暴露material authority问题，加载spec-driven-development作为受影响方法并停止该范围、返回证据；不作新accepted决定。"
      ],
      "lastResultStatus": "missing",
      "acceptedCompletionStatus": "missing",
      "id": "G1-I04E-R10",
      "handler": "一个独立review-evidence Handler，一个R10完整Result；只交付固定最终树验收，不修实现或兼做I05正确性审计。",
      "objective": "在R09真实completed后的同一最终273input identity独立fresh验证五module check与完整24row A/AC及全部必要直接闭包。",
      "prerequisiteItemIds": [
        "G1-I04E-R09"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07",
        "G1-I04E-R09"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-final/G1-I04E-R10/**（未来输出，不是已有input ref）",
        "仅本item必要native build/.gradle/TestKit/generated outputs与正常已声明依赖/原distribution获取；无source/test/config/版本/authority/Git写权。"
      ],
      "scopeAndEffects": [
        "固定R09真实completed后的实际新inputs/tree，完整五modulecheck、A1-A12/AC1-AC12、P01/P02necessary direct closure、原Forge双TestKit及nativeCompiler均绑定同identity。",
        "仅evidence/必要generated outputs，无source/test/config/版本/authority/Git写权；旧I04E/V01/V02/R08及query raw partial与全部失败封包只历史，不capture/reseal/default重写。",
        "所有closure rows由同树fresh运行/native XML/原始log/artifact/binding关联；不继承旧P01/P02/V02身份/PASS/XML/UP-TO-DATE或manifest为runtime。",
        "R09 focused green只释放本项结构前置，不继承为最终PASS；同一最终窗口fresh全五check、完整24行、P01/P02 direct closure、当前core ABI/封存旧caller二进制及原Forge两fixture逐fixture真实Java8 compiler绑定全部必须成立。",
        "保留原测试/fixture/断言与各cache阶段语义；includes NO-SOURCE如实记录，不冒充fresh tests。根新依赖不是第六fork/版本bump许可；任一未知新阻断准确partial/blocked，验收Handler不修源码。"
      ],
      "completionPredicate": "R09真实completed且其他必要基础成立后的同一新final identity上五module check实际exit0，fresh XML零failure/error/skipped，全A1-A12/AC1-AC12及inputs/cache/legacy/metadata/mapping/retained baseline逐行完整，P01/P02necessary directclosure与原Forge双TestKit2/2/nativeJava8Compiler完整绑定；结束身份、old seals/Git保全和独立默认只读核验exit0。任何partial/blocked/failed/missing不释放W03/I05/I06/Git；仅完整completed经Router独立核验后才可重新接受I04E并判断W03/I05。",
      "requiredEvidence": [
        "新独立最终command/exit/stdout/stderr/五native check与validation/lint/fresh XML、五版本和branch/HEAD/index、全部相关fixture paths/hash/timestamps",
        "最终R09后最终273实现输入的真实路径/count/新identity与before/after完整tree identity；七实体rename后的路径如实绑定，禁止新增test owner；旧272/273inputs与V01/V02旧identity均只历史锚。",
        "全A/AC closure matrix逐行列authority clause/current方法/命令/XML testcase/actual target+evidence+cleaned/resource/binding与失败原生观察、支持或精确blocked边界；禁止历史PASS/旧XML/UP-TO-DATE/仅manifest代替必要runtime",
        "P01/P02 necessary direct closure须由同一新final identity fresh运行/native XML/命令/当前artifact+record绑定证明；旧P01/P02 Result仅复用方法与历史事实，不能继承旧PASS/XML；producer cache阶段仍需真实FROM-CACHE后fresh consumer。",
        "operation child engine/ASM provenance、bytecode/config/injector native诊断与锁定deps对照；A1 registration及AT/nested bounded维持原义；全部历史封包/两诊断/V01/V02 partial与失败历史保持；无遗留活动wrapper/tests/fixtures。",
        "同新identity R06B七facade/default桥/Kotlin可见API/旧binarylinks证明与R07每fixture nativeJava8Compiler观察，终于全五checks实际到达/exit0。",
        "独立完整Result与默认只读verifier证据，GRADLE_OPTS原值before记录后childcopy合并/CLI串行、generated TestKit home精确finally恢复，不泄露环境或降低门槛。",
        "R09单行diff/afterTaskCP/focused Result只作前置，R10全部runtime绑定同一新final273input identity；原R08 partial及query metadata/旧62tests/旧PASS/XML/UP-TO-DATE均不可充当新验收。",
        "逐fixture实际Java8 compiler→PID/parent/toolchain/native frames/重建窗口→fresh class/JAR配对；当前core JAR/七facade/default桥/Kotlin API/封存old caller链接与精确LNT契约全部保持，不能toy或重编old caller补证。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "VG1-POST-09：R09 completed后同最终273identity fresh五check与A1-A12/AC1-AC12、P01/P02 necessary directclosure、core ABI/封存旧binary及双Forge nativeJava8Compiler；producer cache阶段仍真实FROM-CACHE→fresh consumer，不对该nested缓存阶段强加rerun。"
      ],
      "verificationIds": [
        "VG1-POST-09"
      ],
      "readableReferences": [
        "docs/adr/mixin-operation-isolation.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/acceptance-matrix.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-validation-diagnosis/findings.json",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json",
        "docs/works/mixin-rework/context.md",
        "build.gradle.kts",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/verify.py",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-core-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-includes-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-diagnosis-review/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/verification-recovery/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "requiredModuleChecks": [
        ":minecraft-codev-mixins:check",
        ":minecraft-codev-fabric:check",
        ":minecraft-codev-forge:check",
        ":minecraft-codev-core:check",
        ":minecraft-codev-includes:check"
      ],
      "acceptanceIds": [
        "A1",
        "A2",
        "A3",
        "A4",
        "A5",
        "A6",
        "A7",
        "A8",
        "A9",
        "A10",
        "A11",
        "A12",
        "AC1",
        "AC2",
        "AC3",
        "AC4",
        "AC5",
        "AC6",
        "AC7",
        "AC8",
        "AC9",
        "AC10",
        "AC11",
        "AC12"
      ],
      "reacceptsHistoricalItemId": "G1-I04E",
      "confirmedScope": {
        "status": "confirmed",
        "decisionId": "D-G1-JUNIT-LAUNCHER-CONTINUATION",
        "source": "本轮Handoff inline：用户最新ask明确选择“授权查询及有界候选修复/重验”；Router已消费完整query generation1 Result，不是本writer重新问询或接受。",
        "allowedCorrection": "仅E:/Projects/cloche/minecraft-codev/build.gradle.kts共享测试dependencies块增加一条testRuntimeOnly(\"org.junit.platform:junit-platform-launcher:1.9.0-M1\")。",
        "allowedVerification": "串行原core:test及独立最终五module/24row A-AC；后继native阶段允许正常获取已声明coordinate及原TestKit 8.2/8.6/8.8 distribution，按原源码实际选择，不强换。",
        "stopBoundary": "需要other version/coordinate/owner/assertion/fixture/算法/公开运行库或material authority变化时停止受影响项并返回证据；不自动升级、安装JDK、改全局属性、五fork或Git。",
        "writerPermission": "历史R09/R10 preparation writer范围：当时仅四coordination和独立静态图证据，未运行/实施/接受。不是当前R11实施限制或泛写许可；R11只按confirmedTemporaryDisableScope单方法例外。"
      },
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-final/G1-I04E-R10/",
      "rollbackAndRisk": [
        "只读最终树，不兼修复；任何缺失的fresh runtime/ABI/compiler/authority行均保留缺口，不以历史补齐或降低原断言。",
        "若树漂移/恢复失败/新fixture失败则准确partial/blocked；Router处置，未获completed不得释放W03/I05，历史scope失败不洗白。"
      ],
      "runtimeStatus": "not-run",
      "structuralReadiness": "waiting for actual completed R09 Result and all completion prerequisites; not executable now.",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-R08",
        "G1-I04E-V02"
      ],
      "historicalOnlyDependenciesAreEvidenceNotCompletion": true,
      "historicalOnly": true,
      "historicalDisposition": "原状态/完整receipt/完成谓词全部保留为历史；本轮active基线与终验改由R12→R13，历史partial或停用窄目标不作completed前置，不自动重跑。",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ]
    },
    {
      "id": "G1-I04E-R11",
      "waveId": "G1-W07",
      "handler": "一个implement-change Handler；一个R11完整Result，只交付单方法临时停用及其focused验证。",
      "resultCount": 1,
      "objective": "临时暂停唯一过期Basic Minecraft Build()，保留原测试内容，并以fresh原core:test精确4pass1skip证明该暂停。",
      "prerequisiteItemIds": [
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-CORE-BASIC-TEMPORARY-DISABLE"
      ],
      "confirmedScope": {
        "status": "confirmed",
        "decisionId": "D-G1-CORE-BASIC-TEMPORARY-DISABLE",
        "source": "当前Handoff inline：Router先ordinary披露精确单方法JUnit @Disabled+原因+必要import、原core:test预期4pass1skip且非vanilla；用户ask_response明确确认只禁用这一项、更新现有图后改该方法并实际验证。仅复用该确认，不造ask回执路径/时间，不重新ask或接受runtime。",
        "allowedCorrection": "仅E:/Projects/cloche/minecraft-codev/minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt的Basic Minecraft Build()增加org.junit.jupiter.api.Disabled import与单方法@Disabled具体temporary理由；不作class-level disable。",
        "allowedVerification": "后继实施仅串行原core:test按现有配置fresh rerun；原五tests恰4pass/1skip/0failure/0error，唯一skipped case必须是原Basic Minecraft Build()并绑定Disabled理由，不是5/5或vanilla验证。",
        "preserved": "五个原@Test、完整body/8.2-8.6-8.8 loop/eight tasks/args/assertions/caller/fixture/settings/selectors/metadata，其他Core四空method与Forge全部测试/root launcher/五版本/Git/authority/旧失败包保持。",
        "stopBoundary": "不修旧fixture/API、不实验/迁移/改selector、不新增公开API/依赖/版本/JDK/installation/env/global属性；未知owner或norm/support matrix矛盾停止受影响范围并加载spec-driven-development返回gap，不降criteria。",
        "preparationPermission": "当前writer仅四coord和本新静态evidence subtree；不实施@Disabled，不运行Gradle/Java/compiler/nativequery/tests，不触碰Todo/Git/权威/普通消费者文档，不dispatch/接受/释放。",
        "historicalPermissionInterpretation": "原confirmedContinuationScope及R09/R10 writerPermission只记其preparation历史；R09原五fresh全部pass/原selector/三版本谓词不改。新实施许可只属于R11，不回授R09/R10或泛化host写权。"
      },
      "ownedProjectFiles": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ],
      "plannedOutputFiles": [],
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/",
      "writeOwnership": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt：仅必要Disabled import与Basic Minecraft Build()的单方法annotation/temporary reason；其他字节保全。",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/**（未来输出，普通文本，不是actual input ref）",
        "仅此focused原core:test必要native generated outputs/现配置已声明依赖正常获取；不写源码其他owner、fixtures/settings、旧evidence/userhome配置/environment/Git。"
      ],
      "scopeAndEffects": [
        "只增加org.junit.jupiter.api.Disabled import和该方法@Disabled(\"Temporarily disabled: the Basic Minecraft fixture uses removed core DSL APIs; selector-preserving migration and Kotlin compatibility validation are deferred.\"); 保留所有五@Test、完整原方法body、8.2/8.6/8.8循环、八任务/args/forwardOutput/debug/build与四空方法；不disable class/其他case、不filter或改caller。",
        "所有fixture/settings/build/root launcher、selector literals/metadata/断言、Forge全部测试、五fork/authority/Git只读。方法skip使其原nested TestKit不执行；不声称原三版本/八任务/vanilla产物已验证。",
        "原core:test按现有配置fresh rerun：suite真实5tests/0failure/0error/1skip=4pass1skip；逐case识别唯一Basic Minecraft Build()的skipped节点及明确Disabled原因，其余四项原空方法通过不证明行为。",
        "273输入before应核对当前041 identity；source变更后273成员集合不变、仅该owner改变并形成新identity，不要求新after仍041；272其余inputs/Root单行/五版本/authority/旧sealed/Git保全，unknown Ruff逐path/length/hash披露。",
        "R09 partial只是已验证Root/source/TestCP/failure证据输入，绝不是required completed item。R11不修旧fixture/API、不改变R09/R10原completion/默认gate，不释放W03/I05/I06/Git；实验/repair提议deferred、compatibility proposal cancel-proposal（从未启动），不是completed。"
      ],
      "conflicts": [
        "与任何同树source/config/test、Gradle/TestKit/build/generated outputs及Git writer/wrapper/formatter排他串行；R11结构不依赖R09 completed，不意味着可与R09/R10并行。",
        "共享R09/review/原fixture/authority为readonly inputs，不构成写冲突；新R11 evidence独占，所有旧manifest/receipt/before/after/native失败只读，不capture/reseal/重放旧current equality、不清理恢复unknown Ruff。"
      ],
      "completionPredicate": "仅唯一Basic Minecraft Build()方法增加Disabled import/annotation及明确temporary理由，所有原@Test/body/fixtures/loops/selectors/其他方法/Forge/root/deps保持；原core:test在新273identity下实际fresh exit0，原五case精确4pass1skip/0failure/0error且唯一skipped方法与理由正确，真实command/XML/source/receipt与protected保全可独立核验。缺少上述证据不completed；此暂停完成不满足原R09五fresh全部pass或R10/vanilla/W03/I05/Git。",
      "requiredEvidence": [
        "当前确认来源、before/after owning source bytes及仅import/annotation diff，五@Test/完整body剥离新增项后逐字节相等；原fixture/settings/loop/task/args/caller/metadata/其他Core和Forge只读摘要。",
        "原focused argv/cwd/UTC/exit/raw stdout/stderr、fresh原生JUnit XML时间/hash/window/actual core:test执行；五个具体case/result、唯一skipped节点及Disabled原因，旧XML/stale/cache/total5不能替代。",
        "before273/041锚及after273新identity、272其余inputs/Root独立source object与唯一launcher1.9.0-M1、五版本/Git52/authority/旧seal/环境保全；raw R09partial/历史失败与unknowncache exactbytes/hash/ownerunknown保留，focusedChecks与fullStrictScope分开。",
        "新独立默认只读校验/member全集/manifest与实际receipt/raw streams/source绑定；fullStrictScope=false如实不写clean，不把Raw partial接受为completed。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "VG1-POST-10：精确唯一annotation/import diff与所有其余原字节保全；实际5tests=4pass1skip0fail0error，唯一skipped原Basic Minecraft Build()及理由；不是原5/5、不验证vanilla、不跑R09/R10/五check。"
      ],
      "verificationIds": [
        "VG1-POST-10"
      ],
      "readableReferences": [
        "build.gradle.kts",
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/after.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/after/build.gradle.kts",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/fresh-results/TEST-net.msrandom.minecraftcodev.core.MinecraftTests.xml",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-repair/G1-I04E-R09/after/minecraft-codev-core-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r09-basic-script-review/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r09-basic-script-review/claims.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "PRD reuse：产品/retained baseline scope不变；Spec reuse：C1-C8/A1-A12和原vanilla缺口不由skip变Passed；同一ADR skip写update：operation隔离/架构决定不变。",
        "D-G1-CORE-BASIC-TEMPORARY-DISABLE精确当前用户确认仅属于本暂停；三authority只读，材料矛盾条件加载spec-driven-development并阻断受影响coverage，不降验收。"
      ],
      "rollbackAndRisk": [
        "停用只使红测暂时不执行，未修旧API/selector/Kotlin兼容，原vanilla缺口继续未验证。没有自动expiry/新系统；重新启用需有证据和另行明确边界，当前不顺手恢复。",
        "后继若focused原core:test仍失败或scope/protected漂移，保存真实失败并partial/blocked，不修other owner/换依赖/版本/JDK；不rollback隐藏旧R09失败。"
      ],
      "lastResultStatus": "partial",
      "acceptedCompletionStatus": "partial",
      "runtimeStatus": "partial",
      "lastResultEvidence": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/native-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/test-analysis.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/detached/verification-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/verify.py"
      ],
      "lastResultSummary": "同一R11 generation4完整raw Result为partial；g2单方法Disabled import/annotation已保全，g4唯一新授权原core:test实际native exit0，UTC 2026-10-09T03:35:48.3806936Z–03:36:17.5186658Z，test/compileTestKotlin实际EXECUTED，fresh恰4pass1skip/0failure/0error且唯一Basic Minecraft Build() skipped。fresh compiled class仅该方法Disabled及plannedDisabledReason匹配；xmlSkippedReasonProvided=false，XML仅<skipped/>，四pass仍为空，不证明vanilla/三版本行为。Router独立g4 verify.py实际exit1/errors=[]/focusedChecks=true/fullStrictScope=false，29新seal/16旧seal/20旧R11文件/9ledger/273inputs/281protected/52Git匹配且detachedVerificationReceiptChecked=true；exit1为unknown Ruff严格scope限制，不是整体checker通过。当前inputIdentity 489b1cf530207123f83221b7c6460e17a118ddc0bd3017c9d033454320f93f2e；g1/g2机械失败/raw partial、g4准备KeyError和g3unknown保留。Router仅接受停用及明确skipped窄目标已验证，不接受R11严格整体completed，不释放W07/R10/W03/I05/I06/Git；四coord为核验后授权投影，旧current-tree equality不再宣称成立。",
      "focusedChecks": true,
      "fullStrictScope": false,
      "g3ExecutionHistory": "unknown",
      "structuralReadiness": "structurally-ready only：所需R07/既有accepted功能基础与W01/W02 gates已有证据，当前确认及R09 Root/source/CP失败可读；不要求R09completed/fixture修复。已实施并消费g4完整raw partial，仅停用/明确skipped窄目标经Router核验；R11严格整体未completed，W07不释放，R10/W03仍waiting。",
      "readonlyEvidenceInputsDoNotRequireCompletedR09": true,
      "releasesOriginalG1Gates": false,
      "plannedDisabledReason": "Temporarily disabled: the Basic Minecraft fixture uses removed core DSL APIs; selector-preserving migration and Kotlin compatibility validation are deferred.",
      "historicalOnly": true,
      "historicalDisposition": "原状态/完整receipt/完成谓词全部保留为历史；本轮active基线与终验改由R12→R13，历史partial或停用窄目标不作completed前置，不自动重跑。",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ]
    },
    {
      "id": "G1-I04E-R12",
      "waveId": "G1-W03",
      "handler": "一个implement-change Handler；一个完整Result只交付新Core vanilla五文件基线与聚焦验证。",
      "resultCount": 1,
      "objective": "用已接受的当前API新vanilla基线实际证明固定两MC版本的common/client resolve→compile→package。",
      "scopeAndEffects": [
        "仅五个新test/resource planned outputs，不修改生产/source build/依赖/版本/原测试/fixture/Disabled/body/四空方法/Forge；Gradle9.4.0、既有nested/编译JDK17，外层Core Test Java11不变。",
        "1.16.5/1.20.1每版common/client真实resolver输出、compile、JAR及有效语言资源/fresh probes；missing-ID buildAndFail准确cause与无新成功outputs。",
        "使用新测试自有cold dirs/cache且禁用build-cache复用；允许必要官方下载/正常outputs，不清或复用旧全局缓存以伪称cold。",
        "旧selector/八pipeline/三Gradle分母本轮不计入且未验证；Basic唯一legacy skip与原四空pass不能算vanilla正例，不新增class disable/filter/其他skip。",
        "实施后重绑实际input members/count/identity，273-input与当前旧identity仅历史锚，不预称278；focused成功不释放G1。"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-CORE-VANILLA-BASELINE"
      ],
      "ownedProjectFiles": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
      ],
      "plannedOutputFiles": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
      ],
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/",
      "writeOwnership": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/**（未来输出，非readable input ref）",
        "仅新测试必要native build/.gradle/TestKit outputs及必要官方下载；test-owned冷目录/cache，不写旧source/build/deps/environment/Git。"
      ],
      "conflicts": [
        "与所有同树source/config/test/resource/Gradle/TestKit/build outputs/Git writer排他串行；R12完整结果及独立核验接受后才执行R13，R13冻结同一新final identity；不与历史R09/R10/R11重跑并行。",
        "独立新evidence owner；所有旧包/manifest/default receipt/raw partial/历史失败只读，不capture/reseal重写；unknown Ruff漂移按exact path/length/hash披露，不清理修复，不解除fullStrictScope=false。"
      ],
      "completionPredicate": "五文件全部实现且同实际新input identity下两MC×common/client四真实闭包及missing-ID准确失败完整实测成立；task outcomes、resolver/JAR/resource/probes、冷目录/cache策略、外层Java11/嵌套编译17及保全/独立核验证据完整。一个Result完整completed获Router接受后才满足R13前置；partial/blocked/failed/missing、旧四空pass/Basic skip或仅配置成功均不满足。未知Ruff/fullStrictScope=false不自动改写，功能/严格scope与raw退出分别报告。",
      "requiredEvidence": [
        "精确五新文件diff/owner边界；其余当前实现输入、原tests/fixtures/Disabled/Forge、旧封包及Git before/after保全。",
        "实际新实现输入的members/paths/count/identity，不预设278；commands/exits/stdout/stderr/fresh XML、Java11 launcher/Gradle9.4.0 nested JDK17实际绑定。",
        "两MC×common/client每条新执行resolve/compile/package task outcomes及真实resolver/JAR有效语言资源/fresh probes；missing-ID buildAndFail完整cause和无新成功outputs。",
        "新测试自有cold dirs/cache与禁用build-cache复用的实测观察；必要官方下载/正常outputs按真实来源记录，不假冒完全离线或使用旧输出。",
        "完整聚焦Result及独立核验，raw exit、functional checks和strict scope分别记录；unknown Ruff/g3unknown/历史partial失败保留，不自动释放W03/I05/I06/Git。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain（未来core聚焦验证，保留全部测试，不过滤；唯一原Basic skip不计vanilla）",
        "VG1-POST-11：nested固定Gradle9.4.0/既有JDK17，使用测试自有fresh解析目录/cache，四完整闭包+准确missing-ID失败；完整实测及独立核验前R13保持not-ready。"
      ],
      "verificationIds": [
        "VG1-POST-11"
      ],
      "readableReferences": [
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "build.gradle.kts",
        "minecraft-codev-core/build.gradle.kts",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/MinecraftCodevPlugin.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/ResolutionRule.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "本轮settled scope与D-G1-CORE-VANILLA-BASELINE；三family reuse/update/create skip，权威只读。",
        "任何material authority覆盖矛盾按spec-driven-development停止受影响scope并返回证据，不私自改变权威或降低闭包。"
      ],
      "confirmedScope": {
        "status": "confirmed",
        "decisionId": "D-G1-CORE-VANILLA-BASELINE",
        "source": "本轮Handoff inline用户已接受新当前API vanilla基线；已完成scope/authority报告均复用；本writer不重新决定或接受。",
        "ownedProjectFiles": [
          "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
          "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
          "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
          "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
          "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
        ],
        "gradle": "9.4.0",
        "nestedGradleAndCompilerJava": 17,
        "coreTestLauncherJava": 11,
        "forgeFixtureCompilerJava": 8,
        "minecraftVersions": [
          "1.16.5",
          "1.20.1"
        ],
        "variants": [
          "common",
          "client"
        ],
        "closure": "resolve → compile → package",
        "coldResolution": "新测试自有目录/cache；禁用build-cache复用；允许必要官方metadata/client/server/mappings下载与正常outputs；不清全局或旧cache。",
        "requiredAssertions": [
          "真实新执行task outcomes，不以UP-TO-DATE/FROM-CACHE/只build成功补证",
          "实际resolver outputs、JAR内容、有效语言资源与fresh common/client probe classes",
          "不存在ID：buildAndFail准确root cause，且不存在新成功resolver/compiled/package outputs"
        ],
        "excludedButUnverified": [
          "旧Maven selectors",
          "八pipeline",
          "Gradle8.2/8.6/8.8"
        ],
        "supportBoundary": "本轮证据分母替换，不取消公开支持，不承诺selector等价语义或新增Core支持。",
        "authorityFamilies": {
          "prd": "reuse; update/create skip",
          "spec": "reuse; update/create skip",
          "adr": "reuse same Accepted ADR; update/create skip"
        },
        "stopBoundary": "额外依赖、超五owner、生产算法/旧fixture/原Disabled/body/四空方法/Forge变更、新版本/JDK/支持承诺或material authority矛盾即停；不安装JDK、不改环境/Git。",
        "writerPermission": "本次仅四coord与专有最小静态证据；无implementation/runtime/后继派发/功能状态释放权限。"
      },
      "legacySkipException": {
        "case": "Basic Minecraft Build()",
        "maximumSkipped": 1,
        "countsAsVanillaSuccess": false,
        "classDisableFilteringOrOtherSkipAllowed": false
      },
      "lastResultStatus": "partial",
      "acceptedCompletionStatus": "missing",
      "runtimeStatus": "executed-focused-partial",
      "structuralReadiness": "候选ready仅为结构：既有accepted完成基础/R07及W01/W02 gate证据、新scope确认可读；未实施、不获得功能完成。",
      "noCompletionFromPartial": true,
      "historicalPrerequisiteItemIds": [
        "G1-I04E-R08",
        "G1-I04E-R09",
        "G1-I04E-R10",
        "G1-I04E-R11"
      ],
      "historicalOnlyDependenciesAreEvidenceNotCompletion": true,
      "historicalOnly": true,
      "supersededForAcceptanceByItemId": "G1-I04E-R12A",
      "historicalDisposition": "原R12 generation1 rawpartial、acceptedCompletionStatus missing、原五owner/完成谓词/README/checker/manifest/全部失败保持；指定01精确nativeexit/endUTC永久未知。只读历史输入，不作active completed依赖；新主动功能前置由R12A完整Result建立。",
      "lastResultEvidence": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/analysis.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt01/runner-failure.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt04/receipt.json"
      ],
      "lastResultSummary": "原完整Result为partial；final04 nativeexit0/8tests/7pass1skip/0fail0error，其中四旧空pass与三真实新case分列，四闭包/准确missing-ID/工具链绑定已独立核对。原默认checker exit1/errors=[]/functionalChecksPassed=true/relatedPreservationChecksPassed=true/sealedManifestChecked=true；attemptMetadataComplete=false/overallR12Complete=false/fullStrictScope=false/g3unknown保留。此次仅登记历史事实及用户局部01例外，不新接受Result/不改completed。",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ]
    },
    {
      "id": "G1-I04E-R12A",
      "waveId": "G1-W08",
      "handler": "一个独立只读功能核验Handler；一个完整R12A Result，只核实final04已接受新基线证据，不做新native运行或R13。",
      "resultCount": 1,
      "objective": "同278实现身份和保护数据下，核实封存final04满足三真实case/四resolve→compile→package闭包及准确missing-ID的完整功能证据，按指定首回执局部合同提交单独完整Result。",
      "scopeAndEffects": [
        "只消费现有final04/source/protected历史；01缺口原样披露，02-04完整回执与最终功能绑定不降低。",
        "新Result的completed只指该单一局部功能核验谓词，fullStrictScope=false/unknown Ruff/g3unknown仍列限制；未满足谓词如实partial/blocked/failed，不用局部例外豁免其它错误。",
        "不得新运行Gradle/TestKit/lint/Ruff/download或改五source/authority/config/Git/旧证据；本次图writer不执行此项。"
      ],
      "prerequisiteItemIds": [
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "historicalPrerequisiteItemIds": [
        "G1-I04E-R12"
      ],
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-CORE-VANILLA-BASELINE",
        "D-G1-R12-ATTEMPT01-RECEIPT-EXCEPTION"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "所有278输入、五新source/resource、旧310封包/全部历史/Git/四协调文档/authority只读；只拥有独立新plannedEvidenceDirectory中的必要完整Result证明。",
        "仅拥有未来g3专有JSON/Markdown目录；原g1 ENAMETOOLONG六成员失败包不可改字节或新增后代。常规工具session/自动temp副作用如实披露，不主动仓库外写入/删除；Codev根显式cwd，Markdown固定完整代码经stdin短载入Python -B，不创建/编辑.py/.ps1等helper。"
      ],
      "readonlyProjectFiles": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
      ],
      "plannedOutputFiles": [],
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/",
      "readableReferences": [
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "build.gradle.kts",
        "minecraft-codev-core/build.gradle.kts",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/MinecraftCodevPlugin.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/ResolutionRule.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/core-basic-disable/G1-I04E-R11/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md",
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/verify.py",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/inputs.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/analysis.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt01/runner-failure.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt04/receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt04/stdout.bin",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/attempt04/stderr.bin",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/toolchains.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-contract/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-contract/verify.py",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-json-md-plan/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-json-md-plan/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-short-loader-plan/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-short-loader-plan/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A/README.md"
      ],
      "conflicts": [
        "与所有同树source/config/test/resource/Gradle/TestKit/build outputs/Git writer排他串行；R12完整结果及独立核验接受后才执行R13，R13冻结同一新final identity；不与历史R09/R10/R11重跑并行。",
        "独立新evidence owner；所有旧包/manifest/default receipt/raw partial/历史失败只读，不capture/reseal重写；unknown Ruff漂移按exact path/length/hash披露，不清理修复，不解除fullStrictScope=false。"
      ],
      "verification": [
        "先读取完整R12/独立审阅Result、当前g3 JSON/Markdown短载入合同及原封包；当前 g3 静态只读入口见 docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md 的固定短PowerShell命令，结果 docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-check.json 只证明图/保全/当前写完整性，不是R12A功能验收；旧JSON/Markdown准备和旧contract verify.py/默认exit1仅历史，不对新协调树运行旧main。",
        "在独占冻结树核对原manifest310成员/checksum和实际278 members/path/count/identity、273旧inputs/67425历史/52Git、四coord授权投影、unknown Ruff与g3/temp限制。",
        "独立只读核对final04 receipt与start/command/cwd/UTC/nativeexit0/stdout/stderr/XML/task outcomes/fresh outputs/source/toolchains：三个真实case、每版本common/client两闭包、resource/JAR/probe及missing-ID精确cause与无成功outputs；旧四空pass/唯一Basic skip分列不补覆盖。",
        "完整读取02-04回执，保留01失败/未知两值和原default exit1/overallfalse；不跑旧current-tree等式，不改旧checker，不以协调字节变化反推功能失败。",
        "只在未来g3专有目录产出README.md与verification.json等JSON/Markdown，保存一个完整Result；README保留固定完整只读代码和短默认载入命令，从Markdown读取完整代码经stdin送入python -B -X utf8 -，大型代码/回执不进入argv。实际cwd/ROOT显式Codev根E:/Projects/cloche/minecraft-codev，先核对cwd与来源可读，保留旧原语真实__file__/hash，不调用legacy main/旧当前树等式，不创建或编辑.py/.ps1等helper。verification.json绑定278身份、旧seal、授权投影、实际短命令/cwd/start-endUTC/nativeexit/stdout/stderr、完整stdin代码及来源/hash、逐项真实功能/保全断言和限制；不能JSON自报true、helper exit0或仅图静态通过代替。图通过后尚待Router派发的一次g3只读功能窗口包含必要preseal与postseal默认重放，不重跑项目测试；默认exit0只指局部功能谓词，不声称全仓clean，不自己放行W08/R13。本次仅冻结完整候选及静态证明，不执行此功能入口、不消耗g3窗口；原g1失败包和前述准备失败保留。"
      ],
      "requiredEvidence": [
        "原R12 generation1及独立审阅完整Result/Handoff/实际工具回执、用户明确接受精确01例外的来源；原README/checker/manifest/失败保全。",
        "同278-input identity ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04；310-member manifest SHA256 3529f2b57f3f85e26e43258dd3a2e84f5a8f0582765a8fe31f555829f73ceb64，273旧inputs/67425历史/52Git完整；写前后及唯一自有证据变化。",
        "final04 nativeexit0/command/cwd/start-endUTC/raw日志/XML精确8/7pass1skip/0fail0error，原四空pass与新三真实case分列；四闭包/source/resource/probe/compiler/cache绑定及准确missing-ID失败无成功outputs。",
        "02-04完整元数据；01 nativeexit/endUTC永久未知且tool1不冒充native，原attemptMetadataComplete=false/overallR12Complete=false/default exit1；unknown Ruff/fullStrictScope=false/g3unknown及两个工具temp副作用分列。",
        "一个单独完整Result与未来g3自有README.md/verification.json输出；README固定完整只读代码与短默认Markdown→stdin载入，JSON绑定实际短命令/Codev cwd/UTC/nativeexit/原始streams、完整stdin代码及来源/hash、全部功能/保全断言；preseal和postseal默认重放保持真实绑定，不创建.py/.ps1等helper，不能JSON自报true或仅凭helper exit0。原g1六成员失败包不得改字节或新增后代。输出不包含新native测试、R13五check结果或最终接受；本项新结果未接受之前R13/W03/I05/I06/Git不释放。"
      ],
      "completionPredicate": "同一278源身份 ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04 及原seal/历史/Git/授权coord投影保全下，完整独立只读核实绑定final04的三真实case、两MC×common/client四resolve→compile→package闭包、资源/probe/JAR/工具链及准确missing-ID无成功outputs；02-04元数据完整、01未知如实保留及局部例外精确适用，旧R12 rawpartial/overallfalse不变。独占自有新证据和一个完整Result的该功能/保全谓词全部满足、默认只读重放exit0后交Router独立接受；fullStrictScope=false/Ruff/g3限制不洗白。缺任何该谓词证据不completed，不靠旧R12 completed、R13或W03 release满足本项/W08。",
      "verificationIds": [
        "VG1-POST-11A"
      ],
      "noCompletionFromPartial": true,
      "lastResultStatus": "missing",
      "acceptedCompletionStatus": "missing",
      "runtimeStatus": "not-run",
      "successfulEvidenceAttempt": "attempt04",
      "historicalReceiptExceptionDecisionId": "D-G1-R12-ATTEMPT01-RECEIPT-EXCEPTION",
      "plannedEvidenceOutputs": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification.json"
      ],
      "historicalOnly": true,
      "historicalPredecessorWaveGates": [
        "G1-W02"
      ],
      "historicalDisposition": "原scope/完整predicate及lastResultStatus/accepted字段原样保留；真实g3 capture0/preseal1/空verification/无成功seal/default来自指定session，旧missing/not-run只是上次未投影字段，不推翻真实failed",
      "historicalRuntimeEvidenceLocator": {
        "session": "C:/Users/WINDOWS/.pi/agent/sessions/--E--Projects-cloche--/2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989/tasks/codev-r12a-functional-g3-g1.jsonl",
        "resultPhysicalLine": 54,
        "recordId": "db553ff3",
        "recordedPhysicalLine": 55,
        "meaning": "完整failed literal及对应recorded，原capture0/preseal1保持；不投影runtime/status"
      },
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ]
    },
    {
      "waveId": "G1-W03",
      "resultCount": 1,
      "externalPrerequisites": [
        "D-SCOPE",
        "D-G1-CORE-VANILLA-BASELINE",
        "D-R13-CROSS-TREE-CONSUMPTION-DECISION",
        "D-R13-FINAL-WINDOW-CONFIRM"
      ],
      "plannedOutputFiles": [
        "README.md",
        "inputs.json",
        "tuple.json",
        "commands.json",
        "streams.json",
        "xml-inspection.json",
        "acceptance-matrix.json",
        "direct-closure.json",
        "core-abi.json",
        "forge-java8.json",
        "effects-ledger.json",
        "environment.json",
        "manifest.json",
        "verification.json"
      ],
      "conflicts": [
        "未来same-final-tree验收窗口与任何source/config/test/resource/tuple/Git writer排他串行；新final272与最终tuple从preflight到全部窗口/最终只读核验一致；本次不启动。",
        "历史278封包/默认程序与原flow只读按T0身份消费；不能在新树执行旧程序、回滚tuple/恢复六source/删生成物模拟T0，不能重新capture/reseal旧包。"
      ],
      "authority": [
        "当前Handoff用户已接受历史运行按历史身份消费＋最终树独立完整验收；明确取消在272新树再运行绑定旧278/Basic/8-7-1的g3条款；仅派生完成合同调整。",
        "PRD user/Codev产品owner reuse；Spec mixins技术/Fabric-Forge metadata owner reuse；同一Accepted ADR执行兼容/loader隔离owner reuse；三family update/create skip。实质矛盾仅阻断，不扩写权。",
        "Root已完整采纳R14-V01 generation2 localcompleted，W09前置满足；旧R14 rawpartial/两个strict=false/外部永久unknown/三偏差/Ruff/旧g3unknown/attempt01缺口不改，不成为未来写豁免。"
      ],
      "lastResultStatus": "failed",
      "acceptedCompletionStatus": "missing",
      "id": "G1-I04E-R13",
      "handler": "一个独立review-evidence Handler，一个完整R13 Result；只交付同一新最终树全五check/24项验收，不修实现或兼做I05审计。",
      "objective": "按已接受分层消费合同，历史g3仅原T0/278/8-7-1真实回执身份消费；未来在同一实际final272及冻结四tuple独立完整五check/24项/全部直接闭包验收；本准备不执行。",
      "prerequisiteItemIds": [
        "G1-I04E-R12A-F01",
        "G1-I04E-R12A-V02",
        "G1-I04E-R14-V01"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07",
        "G1-I04E-R12A-F01",
        "G1-I04E-R12A-V02",
        "G1-I04E-R14-V01"
      ],
      "ownedProjectFiles": [],
      "writeOwnership": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/**（原计划输出owner，现为已用失败历史；只读，不可覆写或附加新产物，不是未来写owner）",
        "原已接受单次许可（run01已实际使用）：按 docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json#normalEffectsProposed 保留16既有owner并仅增加A五固定Forge输出/条件日志、B两原fixture实际key/对象、C源码方法分支绑定的新默认temp；run01现只作历史owner；未来新自有owner须Root核对，不在此指定或授权。无source/tests/原fixture脚本/deps/version/config/global env/Git/old evidence写权，不是整个build/cache/Temp许可。"
      ],
      "scopeAndEffects": [
        "原r05准备时点记录（冻结scope/模板身份，不是当前runtime账本或新窗授权）：完整accepted scoped templates; runtime not measured process/window/commands/owner/精确generated区域、安装工具链/八env/真实TestKit discovery路径/恢复方法及保护域见 docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json 和 environment.json；全部future runAuthorized=false，不泛化build/.gradle/全cache许可。",
        "当前272命名成员/identity daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df 与准备后的冻结四tuple独立绑定；未来start preflight与finish逐path/length/hash、命令/UTC/nativeexit/最终状态，不消费历史PASS补齐。",
        "Core恰3/3/0，全module零fail/error/skip；includes NO-SOURCE不冒充测试；两MC×common/client完整fresh closure及negative；P01/P02 FROM-CACHE pair→fresh consumer嵌套语义不被外层rerun覆盖。",
        "当前七facade/18descriptors/default/Kotlinmetadata＋封存旧caller真正链接（不重编）；仅八class166LNT恰+2的已接受精确debug；Forge两原fixture本窗fresh compile/JAR逐fixture实际Java8 worker/native javac stack/PID-parent/重建时窗，不以major52/-version/R07替代。",
        "各verification invocation单独真实窗口/退出，两流保留；失败即停止无自动retry；child environment copy/临时唯一generated TestKit属性finally精确恢复。checksums/probe/configuration-cache/限定cache/daemon/native日志/必要下载均须先统一确认且实际账本，R14例外不延伸。",
        "所有旧包/程序/原Result/partial/failed/unknown只读；不手动清旧Basic十cache或移走共享incremental；I05同final identity独立审、I06消费者文档及Git仍独立未放行。"
      ],
      "completionPredicate": "真实历史基础及Root门禁接受按其原身份消费，不要求旧rawpartial完成或旧g3在272树重跑。用户已接受完整单次未用许可及必需增量，独立只读scope核对和实际启动/运行就绪后，同一实际final272成员/identity和冻结最终tuple上全五check native0，fresh XML全零fail/error/skip且Core准确3/3/0，includes NO-SOURCE如实；本窗四vanilla闭包/负例、逐行24A/AC、P01/P02直接闭包、七facade/18descriptors/default/Kotlinmetadata/封存旧caller精确debug、两原Forge fresh实际Java8编译全部成立。各process/观察窗口真实argv/cwd/UTC/nativeexit/原两流和artifact绑定、限定effects/保护/八env与TestKit finally恢复、新final身份独立只读核验完整；任何缺口/漂移/失败停止无自动重试，不把历史unknown或partial抹去。仅新的完整Result供Router判断W03/I05；本准备不放行R13/I05/I06/Git或G1。",
      "requiredEvidence": [
        "历史g3 V02 #46→#47真实default、完整Result #57和原流无损保存绑定：docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r01/historical-default.json；原517957 bytes/SHA256 2d75221397dc47bc0caa3d8af5fca299ca8f9eb40601de44b6b26372241cd38a；源/保存bytes、command/cwd/UTC/nativeexit/toolCall/source/stdin/loader及179569 stdout/空stderr。仅原278/T0/198成立；原preseal false/null保留，不再次执行，不只依赖Temp。",
        "同一新final成员272/六缺席/identity和最终tuple前后、相关source/fixtures/工具hash、旧封包/Basic十/Git/Ruff保护账本；历史273/278身份仅历史，旧whole-tree不冒称最终树。",
        "全五nativecheck/lint/pluginvalidation/XML真实命令与退出；Core恰三真实case3/3/0；includes NO-SOURCE记录不算测试；全部无filter/skip/failure/error。",
        "24行方法/authority/native命令窗口/XML/targets-original-source-config-records-resource-side-mapping-binding-cleaned/JAR/runtime闭包按 docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json 当前方法与authority版本填入本窗真实evidence，不能继承旧matrix/PASS。",
        "P01/P02当前实际producer SUCCESS→pair FROM_CACHE→first fresh consumer SUCCESS，configuration-cache/input/body/resource/mapping/side、同JVM隔离/provenance、engine native诊断、metadata-provider-legacy真实Gradle注册；bounded AT/nested不替完整矩阵。",
        "Vanilla当前两MC×common/client四resolve/compile/package fresh SUCCESS、全部JAR/资源/probe/hash/工具链、本窗missing-id-r12 deepest cause与无成功outputs；冷cache/no-build-cache不变。",
        "独立fresh core JAR和Java17 ABI调用实际窗口；原sealed caller/tool完整argv与classpaths绑定，七facade/18 JVM descriptors/default桥/Kotlinmetadata及真实旧caller链接；精确已接受八class166LNT恰+2、BCI/count/order不变，其他150 class不变，无任意debug豁免/重编caller。",
        "原Forge两PatchedMinecraftTests fixture本窗nested compileJava与JAR真实fresh，Java8实际worker javac nativeStack＋PID-parent/executable/toolchain和class rebuild窗口逐fixture绑定；major52/-version/R07仅不足；每个observer invocation真实退出/两流。",
        "已安装outer17/core11/nested compiler17/Forge8、八env保密before/effective/finally、真实generated TestKit属性精确恢复；16原有限effects（含DSL必要四dependency owners）+A五固定输出/B四op-key及实际对象/C源码绑定新temp逐path/length/hash/真实owner/window及必要metadata/download来源。无安装/扩权/全局配置/全cache许可，原R14externalAfter豁免不扩。",
        "只读新final身份的完整限定验证及一个完整新的R13 Result，所有历史partial/失败/unknown/Ruff/strict/attempt01缺口另列；保护或finally不齐停止，不重试、不后验扩豁免。"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-mixins:check :minecraft-codev-fabric:check :minecraft-codev-forge:check :minecraft-codev-core:check :minecraft-codev-includes:check --rerun-tasks --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "VG1-POST-12：已获单次许可及增量、独立scope核对/实际启动就绪之后独立全五check/24A-AC/P01-P02/ABI/封存旧caller/原Forge两fresh nativeJava8；每个window必须有实际退出/完整两流。完整现行步骤/工具/精确effects看 docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json# windows/normalEffectsProposed。",
        "历史g3仅从 docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r01/historical-default.json 解码完整原bytes并核对原278/T0实际调用/原preseal；禁止在272final树执行旧README/default/旧接受checker。独立新final只读核验必须针对新的同final身份，不用旧T0当前树等式或helper exit0冒充。"
      ],
      "verificationIds": [
        "VG1-POST-12"
      ],
      "readableReferences": [
        "docs/adr/mixin-operation-isolation.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-V01/acceptance-matrix.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-matrix-audit/audit.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-validation-diagnosis/findings.json",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/AddClientSideAnnotations.kt",
        "minecraft-codev-core/src/main/kotlin/net/msrandom/minecraftcodev/core/task/CachedMinecraftTask.kt",
        "minecraft-codev-fabric/src/main/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinListingRule.kt",
        "minecraft-codev-fabric/src/test/java/net/msrandom/minecraftcodev/fabric/mixin/FabricApplicabilityRepairTests.java",
        "minecraft-codev-fabric/src/test/kotlin/net/msrandom/minecraftcodev/fabric/mixin/FabricMixinMetadataTests.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/jarjar/ForgeJarJarHandler.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinListingRule.kt",
        "minecraft-codev-forge/src/main/kotlin/net/msrandom/minecraftcodev/forge/task/ResolvePatchedMinecraft.kt",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeMixinMetadataTests.kt",
        "minecraft-codev-includes/src/main/kotlin/net/msrandom/minecraftcodev/includes/IncludesJar.kt",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/OperationRunner.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/SelectiveConsumer.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/EngineOperation.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/ExactMappingRemapper.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/OperationService.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/PinnedMixinAdapter.java",
        "minecraft-codev-mixins/src/main/java/net/msrandom/minecraftcodev/mixins/runtime/RecordData.java",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/MixinListingRule.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/StripMixins.kt",
        "minecraft-codev-mixins/src/main/kotlin/net/msrandom/minecraftcodev/mixins/task/Mixin.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/FixtureMixinRule.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/LegacyStripMixinsTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinFailureStageTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinInputBindingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinMappingTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinPreapplicationTests.java",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinSafeRetentionTests.java",
        "minecraft-codev-mixins/src/test/resources/META-INF/services/net.msrandom.minecraftcodev.mixins.MixinListingRule",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/PatchedMinecraftTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-V02/continuation-g3/frozen.json",
        "docs/works/mixin-rework/context.md",
        "build.gradle.kts",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/verify.py",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-core-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-runtime-query/minecraft-codev-includes-metadata.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-r08-junit-diagnosis-review/report.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-final/G1-I04E-R08/verification-recovery/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline/G1-I04E-R12/inputs.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r01/historical-default.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/sources.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/inputs.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/environment.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json",
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-mixins/src/test/java/net/msrandom/minecraftcodev/mixins/MixinOperationIsolationTests.java",
        "minecraft-codev-forge/src/test/kotlin/net/msrandom/minecraftcodev/forge/mixin/ForgeRetainedBaselineTests.kt",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/commands.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/compiler-bindings.json",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/discovery-before.json"
      ],
      "requiredModuleChecks": [
        ":minecraft-codev-mixins:check",
        ":minecraft-codev-fabric:check",
        ":minecraft-codev-forge:check",
        ":minecraft-codev-core:check",
        ":minecraft-codev-includes:check"
      ],
      "acceptanceIds": [
        "A1",
        "A2",
        "A3",
        "A4",
        "A5",
        "A6",
        "A7",
        "A8",
        "A9",
        "A10",
        "A11",
        "A12",
        "AC1",
        "AC2",
        "AC3",
        "AC4",
        "AC5",
        "AC6",
        "AC7",
        "AC8",
        "AC9",
        "AC10",
        "AC11",
        "AC12"
      ],
      "reacceptsHistoricalItemId": "G1-I04E",
      "confirmedScope": {
        "status": "user-confirmed-original-once-only-used-run01-failed-required-effects-accepted",
        "decisionId": "D-R13-FINAL-WINDOW-CONFIRM",
        "runAuthorized": true,
        "proposedScopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
        "acceptedConsumptionContract": "layered historical T0 + independently complete final tree",
        "notAuthorized": [
          "this writer actual project execution or run01 creation",
          "unlisted effects/keys/versions/coordinates/foreign Temp/global changes",
          "I05/I06/Git execution or release by preparation"
        ]
      },
      "plannedEvidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/",
      "rollbackAndRisk": [
        "只读最终树，不兼修复；缺失runtime/ABI/compiler/authority行原样partial/blocked，不从历史补齐。",
        "树漂移、额外skip、恢复失败或新阻断即停止；unknown Ruff/strict scope限制独立披露，不降谓词、不重写历史。"
      ],
      "runtimeStatus": "failed",
      "structuralReadiness": "run01已用且内层failed：五check native1/Core2pass1fail，observer已执行但越界及闭包不满足，独立CoreJAR/三caller未执行，24行partial。当前runtime-connected collector内层partial/runtimeReady=false；Forge采样、动态effects/适用baseline及完整终验接线未闭合。原run01路径/finalPreparationBinding仅历史定位，不是新写owner或当前tuple证明；confirmedScope.runAuthorized仅保留原许可。未续跑，不ready/completed，不释放G1/W03/I05/I06/Git。",
      "historicalPrerequisiteItemIds": [
        "G1-I04E-R08",
        "G1-I04E-R09",
        "G1-I04E-R10",
        "G1-I04E-R11",
        "G1-I04E-R12",
        "G1-I04E-R14"
      ],
      "historicalOnlyDependenciesAreEvidenceNotCompletion": true,
      "legacySkipException": {
        "case": null,
        "maximumSkipped": 0,
        "countsAsVanillaSuccess": false,
        "classDisableFilteringOrOtherSkipAllowed": false
      },
      "noCompletionFromPartial": true,
      "plannedEvidenceInputs": [
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r01/historical-default.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/sources.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/inputs.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/environment.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
        "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json"
      ],
      "prerequisiteWaveGates": [
        "G1-W08",
        "G1-W09"
      ],
      "historicalG3PrerequisiteItemIds": [
        "G1-I04E-R12A"
      ],
      "t0ConsumptionLimitation": "已接受分层替代：旧g3 actualdefault已发生native0/198，只以旧278/T0/8-7-1历史身份/原flow消费；新272完整最终树独立验收。不再次跑旧程序，不把旧whole-tree/tuple/true当新树证明。",
      "historicalLegacySkipException": {
        "case": "Basic Minecraft Build()",
        "maximumSkipped": 1,
        "countsAsVanillaSuccess": false,
        "classDisableFilteringOrOtherSkipAllowed": false
      },
      "historicalConfirmedVanillaScope": {
        "status": "confirmed",
        "decisionId": "D-G1-CORE-VANILLA-BASELINE",
        "source": "本轮Handoff inline用户已接受新当前API vanilla基线；已完成scope/authority报告均复用；本writer不重新决定或接受。",
        "ownedProjectFiles": [
          "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
          "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
          "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
          "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
          "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
        ],
        "gradle": "9.4.0",
        "nestedGradleAndCompilerJava": 17,
        "coreTestLauncherJava": 11,
        "forgeFixtureCompilerJava": 8,
        "minecraftVersions": [
          "1.16.5",
          "1.20.1"
        ],
        "variants": [
          "common",
          "client"
        ],
        "closure": "resolve → compile → package",
        "coldResolution": "新测试自有目录/cache；禁用build-cache复用；允许必要官方metadata/client/server/mappings下载与正常outputs；不清全局或旧cache。",
        "requiredAssertions": [
          "真实新执行task outcomes，不以UP-TO-DATE/FROM-CACHE/只build成功补证",
          "实际resolver outputs、JAR内容、有效语言资源与fresh common/client probe classes",
          "不存在ID：buildAndFail准确root cause，且不存在新成功resolver/compiled/package outputs"
        ],
        "excludedButUnverified": [
          "旧Maven selectors",
          "八pipeline",
          "Gradle8.2/8.6/8.8"
        ],
        "supportBoundary": "本轮证据分母替换，不取消公开支持，不承诺selector等价语义或新增Core支持。",
        "authorityFamilies": {
          "prd": "reuse; update/create skip",
          "spec": "reuse; update/create skip",
          "adr": "reuse same Accepted ADR; update/create skip"
        },
        "stopBoundary": "退役后六source不存在属明确B预期；其余五新owner/production/fixture/有效Forge/deps/toolchains/authority/Git变更仍停止；当前R13跨树消费blocked，不授权扩项。",
        "writerPermission": "本次仅四coord与专有最小静态证据；无implementation/runtime/后继派发/功能状态释放权限。"
      },
      "proposedRunScopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
      "acceptanceMapRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt"
      ],
      "finalPreparationBinding": {
        "inputIdentity": "daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df",
        "inputCount": 272,
        "tupleRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/manifest.json#/tuple",
        "mapRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json",
        "scopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
        "inputsRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/inputs.json",
        "futureEvidenceOwner": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/",
        "requiredOutputNames": [
          "README.md",
          "inputs.json",
          "tuple.json",
          "commands.json",
          "streams.json",
          "xml-inspection.json",
          "acceptance-matrix.json",
          "direct-closure.json",
          "core-abi.json",
          "forge-java8.json",
          "effects-ledger.json",
          "environment.json",
          "manifest.json",
          "verification.json"
        ],
        "sameFinalOnly": true
      }
    },
    {
      "id": "G1-I04E-R12A-R01",
      "waveId": "G1-W08",
      "handler": "implement-change（一个Handler/Result；仅候选修复/static）",
      "resultCount": 1,
      "confirmedScopeRef": "confirmedG3InPlaceRepairScope",
      "prerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R04",
        "G1-I04E-R05",
        "G1-I04E-P01",
        "G1-I04E-P02",
        "G1-I04E-R06A",
        "G1-I04E-R06B",
        "G1-I04E-R07"
      ],
      "prerequisiteWaveGates": [
        "G1-W02"
      ],
      "externalPrerequisites": [
        "当前Handoff已完整确认的g3就地清理替换、一次功能及独立默认验收许可；不是本item的已执行Result"
      ],
      "readableReferences": [
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "PRD reuse docs/prd/codev-mixin-rework.md（Codev产品owner，AC/支持不变）",
        "Spec reuse docs/spec/mixin-preapplication.md（mixins/adapter owners，C/A不变）",
        "同一Accepted ADR reuse docs/adr/mixin-operation-isolation.md（operation隔离不变）"
      ],
      "completionPredicate": "精确就地候选完成F0/F1/F2与静态正负检查，旧failed五文件归档逐字保全、失效根五文件已限定删除，修复后静态16文件/15-member subset与源/真实static回执绑定且无非owner变化；不执行功能。",
      "verificationIds": [
        "VG1-POST-11A-R01"
      ],
      "executionBoundary": "本次仅定义，尚无新Handler执行/Result；completed/partial/failed/blocked和gate projection全部由Router按真实证据处理",
      "conflicts": [
        "G1-I04E-R12A-F01",
        "G1-I04E-R12A-V01",
        "G1-I04E-R12A-V02",
        "G1-I04E-R13",
        "四协调文档状态投影"
      ],
      "objective": "在用户确认许可内就地清理修复g3完整候选，并生成可独立审阅的静态证据",
      "scopeAndEffects": [
        "仅精确11静态REPLACE及五旧根JSON先copy/hash到history/failed-functional同名、再限定删除原位置，禁止覆盖失败归档",
        "F0真实stderr/原两流XML保全；F1 common共享metadata/四variant闭包负例不减；F2所有新stage外层locator/native/UTC/source/stdin/loader/raw streams完整消费绑定",
        "重派生静态count/member/当前tuple及新四item合同；PREPARATION不得直接回写四coord、执行功能main或沿用旧95018/50-item hardcode"
      ],
      "ownedProjectFiles": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/candidate-diff.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-source.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-check.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-snapshot-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-prepare-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-check-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-freeze-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/source-results.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/capture-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/source-results.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/capture-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/verification-receipt.json"
      ],
      "plannedOutputFiles": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/candidate-diff.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-source.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-check.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-snapshot-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-prepare-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-check-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-freeze-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/static-manifest.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/source-results.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/capture-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/history/failed-functional/verification-receipt.json"
      ],
      "writeOwnership": [
        "仅上述精确路径；四coord、g3外旧包、production/tests/config/dependencies/lockfile/authority/Git无写权",
        "snapshot/prepare/check/freeze可用标准库静态解析/compile/有界guard正负自检，不调用功能入口或旧main；static-manifest先完整freeze回执后固定15members"
      ],
      "requiredEvidence": [
        "实际写前16路径length/SHA与Plan原身份一致，五归档逐字匹配，原session capture0/preseal1及0-byte stdout失败事实保持",
        "完整修复source/program/loader/PREPARATION blocks、精确candidate diff和所有新static完整outer-call/native receipts，实测F0/F1/F2鉴别正负例",
        "同tuple/54items8waves/联合62nodesDAG、可读refs、W02/七base、四新predicate/ownership串行及无状态投影纯图证据",
        "静态16文件集合/15members subset与当前源/归档身份、完整本次非owner before→after及原310/278/所有既定历史/Git/external/env/Ruff保全；真实异常不得completed"
      ],
      "verification": [
        "严格Plan精确清单/未来成员；不猜路径/广泛glob；copy/hash失败不得删原文件",
        "原两流/失败XML字节负例、shared metadata缺失重复错version/download负例、完整stage字段/流交换/原始字节native0+非空stderr负例均reject",
        "新的PREPARATION须只写自身owner而不执行旧脚本回写coord；不把static subset封存当功能完成"
      ]
    },
    {
      "id": "G1-I04E-R12A-V01",
      "waveId": "G1-W08",
      "handler": "review-correctness（独立只读Handler/Result）",
      "resultCount": 1,
      "confirmedScopeRef": "confirmedG3InPlaceRepairScope",
      "prerequisiteItemIds": [
        "G1-I04E-R12A-R01"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R12A-R01"
      ],
      "prerequisiteWaveGates": [
        "G1-W02"
      ],
      "externalPrerequisites": [
        "当前Handoff已完整确认的g3就地清理替换、一次功能及独立默认验收许可；不是本item的已执行Result"
      ],
      "readableReferences": [
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "PRD reuse docs/prd/codev-mixin-rework.md（Codev产品owner，AC/支持不变）",
        "Spec reuse docs/spec/mixin-preapplication.md（mixins/adapter owners，C/A不变）",
        "同一Accepted ADR reuse docs/adr/mixin-operation-isolation.md（operation隔离不变）"
      ],
      "completionPredicate": "独立完整读取R01候选/真实static证据及原来源，确认F0/F1/F2正确且没有减验/新缺陷、精确static16/15members和保护归属满足；只完成static审阅，不证明功能。",
      "verificationIds": [
        "VG1-POST-11A-V01"
      ],
      "executionBoundary": "本次仅定义，尚无新Handler执行/Result；completed/partial/failed/blocked和gate projection全部由Router按真实证据处理",
      "conflicts": [
        "G1-I04E-R12A-R01",
        "G1-I04E-R12A-F01",
        "G1-I04E-R13",
        "四协调文档状态投影"
      ],
      "objective": "独立审阅修复后的g3完整候选及精确保护/回执静态证据",
      "scopeAndEffects": [
        "只读源/归档/静态结果/实际会话；不修改/清理/重封g3，不运行功能capture/preseal/seal/default或项目测试",
        "允许独立只读static replay/有界标准库guard正负检查但不是新功能窗口；异常返回证据不自动修复"
      ],
      "ownedProjectFiles": [],
      "plannedOutputFiles": [],
      "writeOwnership": [
        "无项目写权；仅正常Harness独立审阅完整Result"
      ],
      "requiredEvidence": [
        "完整R01 Result及可读取全部source/static receipts/manifest/原始失败归档",
        "独立核对F0取流/双流XML、F1 shared common metadata和四闭包/负例、F2真实外层locator/命令/时间/native/完整代码原流消费链",
        "static16/15members与278inputs/原310seal/其它旧包保护检查，独立scope/unknown限制说明",
        "审阅只读且无功能执行，缺陷/不足不能放行F01"
      ],
      "verification": [
        "逐读取真实完整代码及消费者，不以diff/static-check true或helper exit0代替",
        "关键stage/流/source/metadata鉴别负例必须仍reject，旧exception不泛化",
        "仅静态审阅可completed；不接受功能或释放W08"
      ]
    },
    {
      "id": "G1-I04E-R12A-F01",
      "waveId": "G1-W08",
      "handler": "implement-plan（一个Handler/Result；一次功能窗口）",
      "resultCount": 1,
      "confirmedScopeRef": "confirmedG3InPlaceRepairScope",
      "prerequisiteItemIds": [
        "G1-I04E-R12A-V01"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R12A-V01"
      ],
      "prerequisiteWaveGates": [
        "G1-W02"
      ],
      "externalPrerequisites": [
        "当前Handoff已完整确认的g3就地清理替换、一次功能及独立默认验收许可；不是本item的已执行Result"
      ],
      "readableReferences": [
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "PRD reuse docs/prd/codev-mixin-rework.md（Codev产品owner，AC/支持不变）",
        "Spec reuse docs/spec/mixin-preapplication.md（mixins/adapter owners，C/A不变）",
        "同一Accepted ADR reuse docs/adr/mixin-operation-isolation.md（operation隔离不变）"
      ],
      "completionPredicate": "在R01与独立V01完整证据成立后，唯一capture→唯一preseal→seal实际成功，合法preseal原stdout/完整旁侧receipt绑定且candidateFunctionalComplete=true/ownSealChecked=false/overall=false，真实seal回执及最终22-member manifest完整、全部功能和末端保全成立；不执行独立default。",
      "verificationIds": [
        "VG1-POST-11A-F01"
      ],
      "executionBoundary": "本次仅定义，尚无新Handler执行/Result；completed/partial/failed/blocked和gate projection全部由Router按真实证据处理",
      "conflicts": [
        "G1-I04E-R12A-R01",
        "G1-I04E-R12A-V01",
        "G1-I04E-R12A-V02",
        "G1-I04E-R13",
        "四协调文档状态投影"
      ],
      "objective": "在同g3执行一次现有证据只读功能核验并形成可独立default验收的真实封包",
      "scopeAndEffects": [
        "功能窗口只有一个；capture/preseal/seal每阶段一次，任何失败停止且不得自动重试/修复/重填/建g4",
        "只读原测试证据与实现，不运行Gradle/TestKit/项目测试/metadata query/download；native cwd显式Codev ROOT",
        "原失败归档/static16均只读，根七授权JSON exclusive创建；verification是真实preseal stdout，历史0bytes只在归档不被追认成功"
      ],
      "ownedProjectFiles": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/source-results.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/capture-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/seal-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/manifest.json"
      ],
      "plannedOutputFiles": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/before.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/source-results.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/capture-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/verification-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/seal-receipt.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/manifest.json"
      ],
      "writeOwnership": [
        "仅七个未来根JSON；不得改静态/归档/四coord/其它包/生产测试配置权威Git；失败原样留下现有授权输出且完整failed Result",
        "seal native0+stderr空后先完整seal receipt再final22manifest；不在receipt产生前宣称seal，不自引用manifest或回执自身hash"
      ],
      "requiredEvidence": [
        "R01与独立V01完整completed证据及W02/七基础，开窗冻结tuple/当前16成员/278identity和所有保护输入",
        "真实capture/preseal/seal外层call/return stable locator、完整command/cwd/argv/Python/UTC/native、stdin/loader/source和双流原bytes/base64/UTF8/length/hash；child0+stderr空且wrapper实际成功",
        "实际final04三真实case/8tests7pass1skip0fail0error、四闭包/JAR/resource/probe/准确missing-ID无outputs、02–04元数据和工具链/源码绑定，不计四旧空pass和Basic skip",
        "合法preseal显式绑定真实stdout与旁侧verification-receipt，候选true/ownSealfalse/overallfalse；不强制嵌入最终receipt自hash",
        "capture→末端完整限定域和旧273/67425/全部其它旧seal/Git/external-env-Ruff保全；最终manifest自排除22members/总23文件，含完整seal receipt及五失败归档",
        "未执行default/R13、未投影或release；新失败立即停止无默认重试"
      ],
      "verification": [
        "所有原功能/保全及F0/F1/F2消费字段逐项实测，不能JSON自报true",
        "保存并可读取全部真正阶段原流，01仅两unknown例外不应用于新stage",
        "该item完成仅是合法功能候选+真实seal；独立default/native0及overalltrue由V02唯一负责"
      ]
    },
    {
      "id": "G1-I04E-R12A-V02",
      "waveId": "G1-W08",
      "handler": "review-evidence（独立只读Handler/Result；实际default一次）",
      "resultCount": 1,
      "confirmedScopeRef": "confirmedG3InPlaceRepairScope",
      "prerequisiteItemIds": [
        "G1-I04E-R12A-F01"
      ],
      "completionPrerequisiteItemIds": [
        "G1-I04E-R12A-F01"
      ],
      "prerequisiteWaveGates": [
        "G1-W02"
      ],
      "externalPrerequisites": [
        "当前Handoff已完整确认的g3就地清理替换、一次功能及独立默认验收许可；不是本item的已执行Result"
      ],
      "readableReferences": [
        "docs/works/mixin-rework/work.md",
        "docs/works/mixin-rework/context.md",
        "docs/works/mixin-rework/plan.md",
        "docs/works/mixin-rework/waves.md",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3/PREPARATION.md",
        "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
      ],
      "authority": [
        "PRD reuse docs/prd/codev-mixin-rework.md（Codev产品owner，AC/支持不变）",
        "Spec reuse docs/spec/mixin-preapplication.md（mixins/adapter owners，C/A不变）",
        "同一Accepted ADR reuse docs/adr/mixin-operation-isolation.md（operation隔离不变）"
      ],
      "completionPredicate": "在同封包与T0冻结tuple/whole域，独立实际README-default一次native0、stderr原字节空、完整可读取default receipt/原流与真实outer call/source/22member manifest/278input/final04绑定，重做全部功能和末端保全并实际输出ownSealChecked=true/overallR12AComplete=true；不写sealed数据。",
      "verificationIds": [
        "VG1-POST-11A-V02"
      ],
      "executionBoundary": "本次仅定义，尚无新Handler执行/Result；completed/partial/failed/blocked和gate projection全部由Router按真实证据处理",
      "conflicts": [
        "G1-I04E-R12A-R01",
        "G1-I04E-R12A-F01",
        "G1-I04E-R13",
        "四协调文档状态投影"
      ],
      "objective": "独立验收g3真实封包与一次真实默认完整native回执",
      "scopeAndEffects": [
        "只读g3/实现/旧证据，在seal后、任何coord projection或R13副作用前T0执行默认一次，不capture/preseal/seal/修复或项目测试",
        "完整default receipt从冻结loader输出到正常Host会话JSONL，Result稳定locator保存实际call/return和全部raw/base64/UTF8；不能只有NATIVE_RECEIPT摘要",
        "不在g3/verification或新default-receipt写回，不创建新白名单/accepted目录，不用归档替代实际重放"
      ],
      "ownedProjectFiles": [],
      "plannedOutputFiles": [],
      "writeOwnership": [
        "无项目写权，仅正常Harness完整独立Result/实际工具输出；自动overflow若发生须完整可读locator+披露",
        "不可改任何sealed成员，preseal ownSeal/overallfalse字节永久保留"
      ],
      "requiredEvidence": [
        "完整F01 Result、capture/preseal/seal receipts与精确22members/manifest、静态15subset/五旧失败归档身份",
        "实际default outer-call/return absolute session/record ID或行/toolCallId/content locator，完整receipt/原流/source/STDIN/loader/argv/Python/UTC/native与manifest/input绑定",
        "T0 whole限定域/tuple当前树等式及所有真实功能/末端保护checks，stdout ownSealChecked/overalltrue与native0+空stderr一致",
        "完整receipt保存和换行/overflow原bytes可重建性实际可读，不能仅摘要或内存；若不可读取不得completed",
        "记录真实历史T0调用与完整原native receipt/原Result/末端SDK附加失败，字节不回写；后继R13已接受分层消费，不再要求final272树跑旧g3；本项本来不执行fresh最终五check。"
      ],
      "verification": [
        "独立实际默认调用一次，完整命令和真实原native回执，不用preseal/static/cachedJSON true替代",
        "actual stderr长度/hash/base64/UTF8全为空、native0和loader策略一致；源/阶段/外层真实locators及流完整验证",
        "精确成员集合/每lengthSHA与同278identity/原310final04、所有功能/whole保全重新核对，presealfalse不写回",
        "本项实际默认调用仅原T0身份，后继按R13分层合同消费真实原flow；原失败不重试；不在更新树再次执行历史程序。"
      ],
      "historicalR13ConsumerClauses": [
        "记录仅T0接受，R13真实独立重放及fresh五模块/24项/direct/ABI/Forge保持且未执行；无coord/Result/Todo/Waves运行状态projection或gate release",
        "只读取T0事实，不授权B/C或取消R13下一次真实default；任何失败不自动retry"
      ]
    },
    {
      "id": "G1-I04E-R14",
      "waveId": "G1-W09",
      "handler": "implement-change；一个Handler/一个Result，仅完成六source退役及原core:test fresh聚焦证明，不兼R13或独立审计",
      "resultCount": 1,
      "objective": "精确delete-only六source并证明原core:test发现执行三真实case、零skip及原四side闭包/准确负例无减验",
      "confirmedScopeRef": "confirmedRetirementScope",
      "ownedProjectFiles": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt",
        "minecraft-codev-core/basic-minecraft-test/build.gradle.kts",
        "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts",
        "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java",
        "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java",
        "minecraft-codev-core/basic-minecraft-test/src/client/Test.java"
      ],
      "plannedOutputFiles": [],
      "prerequisiteItemIds": [],
      "completionPrerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "externalPrerequisites": [
        "D-G1-CORE-TEST-RETIREMENT-CONFIRM"
      ],
      "inheritedAcceptedEvidence": "当前Handoff明确Root已接受T0 R12A/W08有限前置；只作历史输入，不依赖旧missing字段、rawpartial或重跑g3；不使新R14 completed",
      "scopeAndEffects": [
        "先核对六paths/length/SHA与278身份，精确逐文件unlink且不递归/删目录/清cache；五新Vanilla/有效Forge/其余owner不写",
        "按实际成员移除六项重算272 identity（与prospective吻合）；四coord变化不属于source输入漂移",
        "同一新树运行原core:test完整fresh discovery及三case；正常generated效果、官方/已声明下载限定于scope输出边界，额外owner即停",
        "只写本item新JSON/MD证据目录；不修改coord/authority/旧包；项目tests仅此future窗口，不能filter/新增skip/UP-TO-DATE代替fresh"
      ],
      "writeOwnership": [
        {
          "operation": "delete-only",
          "paths": [
            "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt",
            "minecraft-codev-core/basic-minecraft-test/build.gradle.kts",
            "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts",
            "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java",
            "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java",
            "minecraft-codev-core/basic-minecraft-test/src/client/Test.java"
          ]
        },
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement/G1-I04E-R14/**（未来exclusive JSON/MD evidence）",
        "仅confirmedRetirementScope.futureNormalOutputBoundary的必要正常generated/已声明下载；逐path绑定，不清cache"
      ],
      "conflicts": [
        "所有同树source/config/tests/Gradle/TestKit/generated writer、四coord投影、g3各历史节点/README-default、R13/I05/Git；同一实际输入树和输出窗口排他串行",
        "原R14 rawpartial仅历史；新R14-V01 localcompleted已Root采纳为W09局部前置，不要求原rawpartial completed。R13分层消费已接受，但完整最终运行范围仍未确认。"
      ],
      "completionPredicate": "六指定source均不存在且只有该六项source删除、其余272成员/hash与prospective身份一致；原core:test nativeexit0且task/compileTestKotlin实际EXECUTED、freshXML发现且执行恰3tests/3passed/0skipped/0fail/0error，三case身份完整，MC1.16.5/1.20.1×common/client的resolve/compile/package各真实SUCCESS（不以cache替代）、JAR/resources/probe/工具链及missing-id-r12准确最后cause/无成功outputs完整；新command/cwd/UTC/nativeexit/两流/XML/输入产物绑定与限定保全均完整，无未披露额外owner或漂移。失败/partial保留、不自动修或重试。本completed不代表R13/W03/I05/Git通过。",
      "requiredEvidence": [
        "六delete-only before/after逐path/length/SHA、完整278→272成员及identity、五Vanilla/有效Forge/production/deps/config/authority/所有历史/旧cache/Git保全；原278/g3不覆盖",
        "实际完整native command/cwd/PID/UTC/nativeexit/stdout/stderr原bytes与XML/测试class/工具链/输入及新projects/产物hash绑定，fresh窗口与发现执行证明，不套01unknown例外",
        "原三@Test准确名称与3/3/0，缺失/旧MinecraftTests.class或XML/UP-TO-DATE/过滤/skip均不满足；未执行task必须如实失败/partial",
        "四条resolver→compile→package的TaskOutcome.SUCCESS及Minecraft类/Stone资源/probe major61及compiled/package一致；fresh自有project/coldcache，missing-ID最后Caused by严格全等，下游task不执行且resolved/classes/libs/metadata无成功输出",
        "原run.ps1/attempt04只作命令/捕获方法参考；新JSON/MD loader/receipt保存完整流，不执行原run.ps1写旧包、不创建新.py/.ps1",
        "逐path正常generated外部下载/daemon作用及保护差异、结束无活动此窗口执行器，环境值保密；未知owner/权限/依赖/工具不可用blocked，不安装/改配置",
        "Root对当前披露局部范围的实际确认；明确T0 history-only/R13 blocked/旧partial及末端SDK失败，不把本prepared当确认"
      ],
      "verification": [
        ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
        "逐case/fresh XML与原fixture源码 assertions，验证工具链及原四side全闭包/准确missing-ID失败，无过滤/skip；完整manifest及限定范围末端核对"
      ],
      "verificationIds": [
        "VG1-POST-13-RETIREMENT"
      ],
      "focusedCommand": ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
      "coreExpectedCounts": {
        "tests": 3,
        "passed": 3,
        "skipped": 0,
        "failures": 0,
        "errors": 0
      },
      "readableReferences": [
        "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\inputs.json",
        "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\attempt04\\receipt.json",
        "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\attempt04\\start.json",
        "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\toolchains.json",
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
        "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
        "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java",
        "docs/prd/codev-mixin-rework.md",
        "docs/spec/mixin-preapplication.md",
        "docs/adr/mixin-operation-isolation.md"
      ],
      "authority": [
        "复用133完整PRD/Spec/同一ADR assessment；当前明确B退役，不改变产品支持/行为/隔离契约"
      ],
      "lastResultStatus": "partial",
      "runtimeStatus": "partial",
      "acceptedCompletionStatus": "missing",
      "structuralReadiness": "historical production finished partial; original strict contract not satisfied; no rerun",
      "executionAuthorized": false,
      "historicalOnly": true,
      "limitedCompletionContractRef": "r14-limited-local-completion-r01",
      "expectedAbsentHistoricalReferences": [
        "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt",
        "minecraft-codev-core/basic-minecraft-test/build.gradle.kts",
        "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts",
        "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java",
        "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java",
        "minecraft-codev-core/basic-minecraft-test/src/client/Test.java"
      ],
      "historicalR13ConflictClause": "旧g3与所有sealed只读；R13必须等待本item实际completed且跨树消费决策已接受，不能与删除或验证并行"
    },
    {
      "id": "G1-I04E-R14-V01",
      "waveId": "G1-W09",
      "handler": "已完成独立review-evidence只读结果（g1核验/g2完整交付）；本准备不重跑/派发",
      "resultCount": 1,
      "objective": "独立核验已接受R14有限局部完成合同及immutable独立来源/当前有限身份的可重放接受依据，不执行项目测试或R13",
      "prerequisiteItemIds": [],
      "completionPrerequisiteItemIds": [],
      "prerequisiteWaveGates": [],
      "historicalEvidenceItemIds": [
        "G1-I04E-R14"
      ],
      "externalPrerequisites": [
        "D-G1-R14-LIMITED-LOCAL-COMPLETION"
      ],
      "ownedProjectFiles": [],
      "plannedOutputFiles": [],
      "writeOwnership": [],
      "scopeAndEffects": [
        "只读本局部合同包、绑定immutable sources、当前272命名输入/Basic十文件/四tuple；不重采原外部after、不依赖旧whole-tree T0",
        "原R14 partial/native1/两个strict=false/永久unknown及三accepted known deviations保留；不兼修复、测试、R13、Git或接受projection"
      ],
      "conflicts": [
        "四coord/本包及被核验source writer；固定同一当前tuple/source身份；本步不并发派发任何工作"
      ],
      "completionPredicate": "完整独立只读Result按 r14-limited-local-completion-r01 主动有限分母核验，绑定当前272/四tuple/包manifest和既有独立原材料，确认仅三已发生偏差被接受、原外部after永久unknown且非主动分母；旧rawpartial/strict/native失败不改变，禁止安装/扩权/全局配置限制保留。不得重新依赖原严格externalAfter或old whole-tree T0等式；只有新的完整独立结论经Router判断可建立局部接受，不接受原producer partial为completed前置，不代表R13/G1通过。",
      "requiredEvidence": [
        "六精确source delete-only，原278减六等于当前272完整命名输入及identity；其余源码保全",
        "复用已完整独立核验的原R14 native命令/cwd/UTC/退出/两流、fresh三真实case恰3/3/0",
        "MC1.16.5/1.20.1×common/client四条真实resolve/compile/package闭包、资源/JAR/probe/工具链绑定与missing-id-r12准确root cause/无成功outputs",
        "复用原已核验有限本地域保护样本；不重扫全历史/cache/Cloche/Host",
        "精确三偏差按accepted known execution deviations披露；原外部after永久unknown从此R14主动分母排除",
        "合同/immutable来源/当前有限输入和四tuple/包inventory-manifest绑定，经未来独立只读核验和Router判断；prepared/static/completed记录本身不release"
      ],
      "verification": [
        "仅读 docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/README.md 的完整loader/readonly-program后运行默认短入口；核对实际command/cwd/UTC/nativeexit/两流及Result外部manifest锚；此static入口通过不自动接受"
      ],
      "verificationIds": [
        "VG1-R14-LIMITED-LOCAL-ACCEPTANCE"
      ],
      "readableReferences": [
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/README.md",
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/contract.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/sources.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/verification.json",
        "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/manifest.json"
      ],
      "authority": [
        "当前Handoff inline用户明确选择有限局部证明；PRD/Spec/同一Accepted ADR reuse，不降低完整G1要求"
      ],
      "lastResultStatus": "completed",
      "runtimeStatus": "completed",
      "acceptedCompletionStatus": "completed",
      "structuralReadiness": "historical independent local verification accepted by Root; no R13 permission",
      "contractRef": "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/contract.json",
      "noCompletionFromPartial": true,
      "resultGeneration": 2,
      "resultSourceRef": "C:\\Users\\WINDOWS\\.pi\\agent\\sessions\\--E--Projects-cloche--\\2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989\\tasks\\codev-r14-limited-acceptance-v01-artifacts\\result-2.json",
      "acceptedSource": "current Handoff inline: Root fully adopted generation2 localcompleted, W09 prerequisite satisfied; no new acceptance chosen here"
    }
  ],
  "confirmedContinuationScope": {
    "status": "confirmed",
    "decisionId": "D-G1-JUNIT-LAUNCHER-CONTINUATION",
    "source": "本轮Handoff inline：用户最新ask明确选择“授权查询及有界候选修复/重验”；Router已消费完整query generation1 Result，不是本writer重新问询或接受。",
    "allowedCorrection": "仅E:/Projects/cloche/minecraft-codev/build.gradle.kts共享测试dependencies块增加一条testRuntimeOnly(\"org.junit.platform:junit-platform-launcher:1.9.0-M1\")。",
    "allowedVerification": "串行原core:test及独立最终五module/24row A-AC；后继native阶段允许正常获取已声明coordinate及原TestKit 8.2/8.6/8.8 distribution，按原源码实际选择，不强换。",
    "stopBoundary": "需要other version/coordinate/owner/assertion/fixture/算法/公开运行库或material authority变化时停止受影响项并返回证据；不自动升级、安装JDK、改全局属性、五fork或Git。",
    "writerPermission": "历史R09/R10 preparation writer范围：当时仅四coordination和独立静态图证据，未运行/实施/接受。不是当前R11实施限制或泛写许可；R11只按confirmedTemporaryDisableScope单方法例外。",
    "historicalOnly": true
  },
  "confirmedTemporaryDisableScope": {
    "status": "confirmed",
    "decisionId": "D-G1-CORE-BASIC-TEMPORARY-DISABLE",
    "source": "当前Handoff inline：Router先ordinary披露精确单方法JUnit @Disabled+原因+必要import、原core:test预期4pass1skip且非vanilla；用户ask_response明确确认只禁用这一项、更新现有图后改该方法并实际验证。仅复用该确认，不造ask回执路径/时间，不重新ask或接受runtime。",
    "allowedCorrection": "仅E:/Projects/cloche/minecraft-codev/minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt的Basic Minecraft Build()增加org.junit.jupiter.api.Disabled import与单方法@Disabled具体temporary理由；不作class-level disable。",
    "allowedVerification": "后继实施仅串行原core:test按现有配置fresh rerun；原五tests恰4pass/1skip/0failure/0error，唯一skipped case必须是原Basic Minecraft Build()并绑定Disabled理由，不是5/5或vanilla验证。",
    "preserved": "五个原@Test、完整body/8.2-8.6-8.8 loop/eight tasks/args/assertions/caller/fixture/settings/selectors/metadata，其他Core四空method与Forge全部测试/root launcher/五版本/Git/authority/旧失败包保持。",
    "stopBoundary": "不修旧fixture/API、不实验/迁移/改selector、不新增公开API/依赖/版本/JDK/installation/env/global属性；未知owner或norm/support matrix矛盾停止受影响范围并加载spec-driven-development返回gap，不降criteria。",
    "preparationPermission": "当前writer仅四coord和本新静态evidence subtree；不实施@Disabled，不运行Gradle/Java/compiler/nativequery/tests，不触碰Todo/Git/权威/普通消费者文档，不dispatch/接受/释放。",
    "historicalPermissionInterpretation": "原confirmedContinuationScope及R09/R10 writerPermission只记其preparation历史；R09原五fresh全部pass/原selector/三版本谓词不改。新实施许可只属于R11，不回授R09/R10或泛化host写权。",
    "historicalOnly": true
  },
  "confirmedVanillaBaselineScope": {
    "status": "confirmed",
    "decisionId": "D-G1-CORE-VANILLA-BASELINE",
    "source": "本轮Handoff inline用户已接受新当前API vanilla基线；已完成scope/authority报告均复用；本writer不重新决定或接受。",
    "ownedProjectFiles": [
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
      "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
    ],
    "gradle": "9.4.0",
    "nestedGradleAndCompilerJava": 17,
    "coreTestLauncherJava": 11,
    "forgeFixtureCompilerJava": 8,
    "minecraftVersions": [
      "1.16.5",
      "1.20.1"
    ],
    "variants": [
      "common",
      "client"
    ],
    "closure": "resolve → compile → package",
    "coldResolution": "新测试自有目录/cache；禁用build-cache复用；允许必要官方metadata/client/server/mappings下载与正常outputs；不清全局或旧cache。",
    "requiredAssertions": [
      "真实新执行task outcomes，不以UP-TO-DATE/FROM-CACHE/只build成功补证",
      "实际resolver outputs、JAR内容、有效语言资源与fresh common/client probe classes",
      "不存在ID：buildAndFail准确root cause，且不存在新成功resolver/compiled/package outputs"
    ],
    "excludedButUnverified": [
      "旧Maven selectors",
      "八pipeline",
      "Gradle8.2/8.6/8.8"
    ],
    "supportBoundary": "本轮证据分母替换，不取消公开支持，不承诺selector等价语义或新增Core支持。",
    "authorityFamilies": {
      "prd": "reuse; update/create skip",
      "spec": "reuse; update/create skip",
      "adr": "reuse same Accepted ADR; update/create skip"
    },
    "stopBoundary": "额外依赖、超五owner、生产算法/旧fixture/原Disabled/body/四空方法/Forge变更、新版本/JDK/支持承诺或material authority矛盾即停；不安装JDK、不改环境/Git。",
    "writerPermission": "本次仅四coord与专有最小静态证据；无implementation/runtime/后继派发/功能状态释放权限。"
  },
  "confirmedR12FirstReceiptException": {
    "externalDecisionId": "D-G1-R12-ATTEMPT01-RECEIPT-EXCEPTION",
    "historicalItemId": "G1-I04E-R12",
    "generation": 1,
    "attempt": "attempt01",
    "unrecoverableFields": [
      "nativeExitCode",
      "nativeEndUtc"
    ],
    "historicalRawResultStatus": "partial",
    "historicalOverallR12Complete": false,
    "inputCount": 278,
    "inputIdentity": "ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04",
    "successfulEvidenceAttempt": "attempt04",
    "historicalActiveFunctionalVerificationItemId": "G1-I04E-R12A",
    "activeFunctionalVerificationItemId": "G1-I04E-R12A-F01",
    "independentDefaultVerificationItemId": "G1-I04E-R12A-V02",
    "originalManifestSha256": "3529f2b57f3f85e26e43258dd3a2e84f5a8f0582765a8fe31f555829f73ceb64",
    "scope": "仅该历史缺口对主动功能谓词的影响；不改原predicate/封包/失败或豁免功能、保全、02-04/未来记录、Ruff/全仓scope；非自动partial升级规则。",
    "historicalWriterPermission": "本次只四协调文档及core-vanilla-baseline-contract静态证据；不运行R12A/R13。",
    "writerPermission": "本次standalone只四协调文档；历史准备写权不延用。后继精确g3写权仅由confirmedG3InPlaceRepairScope及新各item的ownership定义，不投影状态、不运行R13。",
    "currentPermissionScopeRef": "confirmedG3InPlaceRepairScope"
  },
  "confirmedG3InPlaceRepairScope": {
    "scopeIdentity": "R12A-g3-confirmed-in-place-repair-initial-derivation",
    "permissionSource": "本Handoff inline用户明确选择“就地修复，并核验一次（建议）”；仅g3旧逻辑/失效派生和四doc，取代仅针对g3永久不动；未接受g4/B/C",
    "root": "E:/Projects/cloche/minecraft-codev",
    "evidenceDirectory": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-baseline-functional/G1-I04E-R12A-g3",
    "planInventory": "plan.md#精确就地清单与未来成员",
    "preparationBoundary": "本次standalone只派生work/context/plan/waves，无g3写/程序/窗口/状态投影/dispatch；这是五独立结果中的第一个，不新增执行状态",
    "currentInventory": [
      {
        "length": 32192042,
        "path": "before.json",
        "sha256": "f3d9ed5f96c402cc11cd1d557f2861ab886540c52d1fdfe8f8fc655f5f873820"
      },
      {
        "length": 71485,
        "path": "candidate-diff.md",
        "sha256": "ffdcb76e86175ecadefa022604e623b8e9095048c35576d839b34a17cf62612d"
      },
      {
        "length": 86346,
        "path": "capture-receipt.json",
        "sha256": "331d35a181d34204c36cb69ae03118071705430e494a7e32c95a96ac7bc5036b"
      },
      {
        "length": 43792,
        "path": "PREPARATION.md",
        "sha256": "140823962f6106258f9cc194a6a7160e25f1153f8c86d92303e8eed003b901ce"
      },
      {
        "length": 38048,
        "path": "README.md",
        "sha256": "5b8bed7d0494571ad22a7b99e299b9bed7d0ef64ba2b80ccc073394339e60258"
      },
      {
        "length": 82029,
        "path": "source-results.json",
        "sha256": "cb28b4d4da5d5289777af30c452d0d50c60b4ea429fb9ef2c9d1ac51dbeee7ee"
      },
      {
        "length": 32947506,
        "path": "static-before.json",
        "sha256": "3ba0b9d190a5caf29ca1a21c271116073352e8488dbb060ac5a3faf3d872457b"
      },
      {
        "length": 111959,
        "path": "static-check-receipt.json",
        "sha256": "be8b370eb43003fdac02284f3c8fed2be8d645b4f32f15f088ce92e20e488e2f"
      },
      {
        "length": 35497,
        "path": "static-check.json",
        "sha256": "6beca377d795669dced2b3ae249352e9da33004e2746c67dd985036354cd7781"
      },
      {
        "length": 111963,
        "path": "static-freeze-receipt.json",
        "sha256": "6212be44d629d10b3348bcb6f85cc99b7e291ac7f3cc52ad4d1b9179a9e1a4cf"
      },
      {
        "length": 2017,
        "path": "static-manifest.json",
        "sha256": "086528b0d16f4bfa8b829d6d07a13a5077a9e397c282f95a25f15748ee8513b2"
      },
      {
        "length": 99676,
        "path": "static-prepare-receipt.json",
        "sha256": "200880d976008dba122abde72bccc7304b0d526b51b4745f9ebfbd72dfff8c0b"
      },
      {
        "length": 99661,
        "path": "static-snapshot-receipt.json",
        "sha256": "f8a53bf7947069a491b588e3361c6939869a8f85201b896d97f559a3430af05e"
      },
      {
        "length": 115341,
        "path": "static-source.json",
        "sha256": "6745fa42dfeedb74615b5fdd28422e56b1d2326656efa56d6f352775b1adbfd1"
      },
      {
        "length": 86024,
        "path": "verification-receipt.json",
        "sha256": "90d6a97a3110441813a8df2d946bb8a83a8b1982f5b03a2838d9ebc434559511"
      },
      {
        "length": 0,
        "path": "verification.json",
        "sha256": "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
      }
    ],
    "staticReplaceFiles": [
      "README.md",
      "PREPARATION.md",
      "candidate-diff.md",
      "static-before.json",
      "static-source.json",
      "static-check.json",
      "static-snapshot-receipt.json",
      "static-prepare-receipt.json",
      "static-check-receipt.json",
      "static-freeze-receipt.json",
      "static-manifest.json"
    ],
    "archiveThenDeleteRootFiles": [
      {
        "source": "before.json",
        "destination": "history/failed-functional/before.json",
        "rule": "five copies exclusive and all original length/SHA verified before any root deletion; never edit archives"
      },
      {
        "source": "source-results.json",
        "destination": "history/failed-functional/source-results.json",
        "rule": "five copies exclusive and all original length/SHA verified before any root deletion; never edit archives"
      },
      {
        "source": "capture-receipt.json",
        "destination": "history/failed-functional/capture-receipt.json",
        "rule": "five copies exclusive and all original length/SHA verified before any root deletion; never edit archives"
      },
      {
        "source": "verification.json",
        "destination": "history/failed-functional/verification.json",
        "rule": "five copies exclusive and all original length/SHA verified before any root deletion; never edit archives"
      },
      {
        "source": "verification-receipt.json",
        "destination": "history/failed-functional/verification-receipt.json",
        "rule": "five copies exclusive and all original length/SHA verified before any root deletion; never edit archives"
      }
    ],
    "futureStaticFiles": [
      "README.md",
      "PREPARATION.md",
      "candidate-diff.md",
      "static-before.json",
      "static-source.json",
      "static-check.json",
      "static-snapshot-receipt.json",
      "static-prepare-receipt.json",
      "static-check-receipt.json",
      "static-freeze-receipt.json",
      "static-manifest.json",
      "history/failed-functional/before.json",
      "history/failed-functional/source-results.json",
      "history/failed-functional/capture-receipt.json",
      "history/failed-functional/verification.json",
      "history/failed-functional/verification-receipt.json"
    ],
    "staticManifestMembers": [
      "README.md",
      "PREPARATION.md",
      "candidate-diff.md",
      "static-before.json",
      "static-source.json",
      "static-check.json",
      "static-snapshot-receipt.json",
      "static-prepare-receipt.json",
      "static-check-receipt.json",
      "static-freeze-receipt.json",
      "history/failed-functional/before.json",
      "history/failed-functional/source-results.json",
      "history/failed-functional/capture-receipt.json",
      "history/failed-functional/verification.json",
      "history/failed-functional/verification-receipt.json"
    ],
    "functionalExclusiveFiles": [
      "before.json",
      "source-results.json",
      "capture-receipt.json",
      "verification.json",
      "verification-receipt.json",
      "seal-receipt.json",
      "manifest.json"
    ],
    "finalManifestMembers": [
      "README.md",
      "PREPARATION.md",
      "candidate-diff.md",
      "static-before.json",
      "static-source.json",
      "static-check.json",
      "static-snapshot-receipt.json",
      "static-prepare-receipt.json",
      "static-check-receipt.json",
      "static-freeze-receipt.json",
      "static-manifest.json",
      "history/failed-functional/before.json",
      "history/failed-functional/source-results.json",
      "history/failed-functional/capture-receipt.json",
      "history/failed-functional/verification.json",
      "history/failed-functional/verification-receipt.json",
      "before.json",
      "source-results.json",
      "capture-receipt.json",
      "verification.json",
      "verification-receipt.json",
      "seal-receipt.json"
    ],
    "finalManifestSelfExcluded": true,
    "expectedStaticFileCount": 16,
    "expectedStaticManifestMemberCount": 15,
    "expectedFinalFileCount": 23,
    "expectedFinalManifestMemberCount": 22,
    "defaultReceiptOwner": "正常Host Harness session JSONL；真实完整outer-call/return和完整default receipt/raw streams稳定locator；不写sealed g3，不仅摘要",
    "currentSuccessorItemIds": [
      "G1-I04E-R12A-R01",
      "G1-I04E-R12A-V01",
      "G1-I04E-R12A-F01",
      "G1-I04E-R12A-V02"
    ],
    "baseItemIds": [
      "G1-I04E-R04",
      "G1-I04E-R05",
      "G1-I04E-P01",
      "G1-I04E-P02",
      "G1-I04E-R06A",
      "G1-I04E-R06B",
      "G1-I04E-R07"
    ],
    "baseReadableEvidence": [
      "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md"
    ],
    "w02GateEvidence": "work.md历史“目标、权威与当前状态”/Waves Router原状态块：W01/W02及I01–I04D已完成；原I02/I03/W01 gate releasePredicate原样；本次只关联、不重新native核验或release",
    "inputIdentity": "ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04",
    "oldR12ManifestSha256": "3529f2b57f3f85e26e43258dd3a2e84f5a8f0582765a8fe31f555829f73ceb64",
    "temporalBoundary": "旧T0 whole/tuple只属于其原历史身份；R13已接受分层消费真实历史default，未来新272完整验收，不再执行旧g3或回滚模拟T0。",
    "baseCompletionEvidence": [
      {
        "id": "G1-I04E-R04",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/check-repair/G1-I04E-R04/README.md",
        "rawResult": "completed",
        "acceptedCompletion": "completed",
        "provenance": "codev-maintenance-versions-r04 generation1完整completed；Router默认只读verifier exit0，两版本owner独占变化，272inputs最终identity8595111476c330a06a271adf72e16ef306ad225daa7c11984a880c1ab2e4773a；只支持版本谓词，不证明新树组合check",
        "boundedPredicate": "实际五changed-module set、core/includes两fork值/上游后缀/动态引用一致，I04D三fork与未变模块不变；聚焦静态版本检查通过",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-R05",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R05/README.md",
        "rawResult": "completed",
        "acceptedCompletion": "completed",
        "provenance": "codev-task-declarations-r05 generation1完整completed；VG1-POST-01原生core/includes两validator实际rerun exit0/[]；三精确class声明，31新包成员与24旧包10049成员保全，generated及ignored Ruff偏差单列。Router按完整Result接受，不宣称完整G1或五check通过。",
        "boundedPredicate": "三owner仅import+类注解；前两because=Relocatable Gradle build-cache semantics have not been verified；CachedMinecraftTask because=Base task type configures the Minecraft cache but does not define a complete cacheable operation；getter/actions/ABI/providers/子类own cache策略/五fork值不变。core/includes两个native validator真实执行，命令exit0且各原生validation JSON为[]；局部PASS不得释放W03。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-P01",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P01/README.md",
        "rawResult": "completed",
        "acceptedCompletion": "completed",
        "provenance": "generation5 完整 completed Result；固定命令 fresh25/25、native exit0；Router detached receipt SHA-256表示修正后独立默认verifier exit0；仅释放P02，历史失败/blocked保留。",
        "boundedPredicate": "固定此测试树，producer先有真实SUCCESS且保存target+records，然后仅移走generated outputs并从既有local Gradle build cache实际FROM-CACHE恢复；记录精确TaskOutcome.FROM_CACHE、恢复pair内容/binding/hash，fresh consumer首次执行SUCCESS而非旧输出/UP-TO-DATE，调用target行为并reopen source配置。same JVM A有custom engine-chain remapper、真实映射注入/plugin/side结果，B无mapping且有未映射配置，调用B原身份目标证明不泄漏；原no-config B独立观察继续复用。记录operation child类的engine/ASM/provenance，不用外层resolved metadata代替；unsupported bytecode、engine-invalid config、unavailable injector均fresh显式失败且无新success/pair。全部现存非新义务的positive基于本树fresh XML+artifact closure复用。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-P02",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/g1-direct-proof/G1-I04E-P02/continuation-g4/README.md",
        "rawResult": "completed",
        "acceptedCompletion": "completed",
        "provenance": "generation4 完整 completed Result，continuation-g4固定最终identity b2e9afeef8f811468a44569c03f9019ab36c640ac513db0e218c8e6e4cd84e5b；fresh56/56/native exit0，Router独立后台默认只读verifier exit0；273inputs/原P02 9577成员/26历史包14525成员保全，仅释放V02。generation3 partial原字节保留。",
        "boundedPredicate": "同consumer闭环证明Foo与FooExtra和另一package exact身份、client/server/unattempted entries/unknown nested metadata/resource保持；one mixin two-target全部成功，经真实consumer删除该entry及仅exhausted config/ref，同时partial/missing/skipped/failed/no-residual-unknown拒绝无selective发布继续fresh复用。真实Fabric ServiceLoader/provider配置运行、换side/environment重执行，reopen retained/deleted refs；第三方all-delete-only provider显式selective unsupported无输出，但同provider在legacy Strip路径仍全删成功。A1旧无mapping Mixin注册、StripMixins<None>真实Gradle registerTransform+artifact resolution无新必填参数，调用实际目标并检查旧全删；不能只direct.transform替代注册。有界非空AT沿ResolvePatchedMinecraft所用现存TransformerProcessor.main实际入口执行并观察access变化，产物与G1前后保持；nested payload bytes、JarJar list/remove原语与非Mixin metadata通过真实现有handler/cleanup reopen比较。该baseline只保留原能力，不认证完整AT规则/嵌套平台矩阵或改政策。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-R06A",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06A/README.md",
        "rawResult": "partial",
        "acceptedCompletion": "completed",
        "provenance": "codev-v02-core-content-lint-r06a generation1完整Result与Router独立verifier已核对；严格范围partial原样保留，仅Ruff缓存漂移。",
        "boundedPredicate": "一个完整R06A Handler/Result：32条内容规则均已解决；未重命名、未添加JvmName、未改caller或其他owner；fresh原生core lint exit1且完整报告恰剩原七source的standard:filename、无新增/其他违规；独立native core compile exit0证明类型解析，语义等价保全成立。预期exit1不是full lint0或最终gate通过；七残余明确由R06B闭合。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-R06B",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R06B/README.md",
        "rawResult": "partial",
        "acceptedCompletion": "completed",
        "provenance": "codev-v02-core-rename-abi-r06b generation1完整raw partial及Router独立verification.py exit1均核对；新debug coverage Result completed/reproduce exit0已独立核对，旧strict-debug/scope失败保留。",
        "boundedPredicate": "一个完整R06B Handler/Result：七source→destination实体rename完成，case/真实目录项逐项核对；迁移前归档七facade/JAR/API/default桥/Kotlin metadata及旧caller字节，迁移后完整core compile/JAR、native core/includes validatePlugins及完整core lint均exit0；四显式fixed和三默认facade均通过编译/JAR/API/default桥/Kotlin metadata/旧binary链接实证，无重编或修改旧caller掩盖ABI变化。SourceFile/SMAP/source-JAR路径差异及本item精确lineNumberTableReconciliation八类166项LNT+2允许，逐method/table count/order/BCI不变及其他条目保持；其他runtime/API/metadata保持，原strict-debug失败保留。编译若暴露旧incremental state则partial，不移走/清除缓存。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      },
      {
        "id": "G1-I04E-R07",
        "readableEvidence": "docs/works/mixin-rework/evidence/g1-implementation/post-v01-repair/G1-I04E-R07/README.md",
        "rawResult": "completed",
        "acceptedCompletion": "completed",
        "provenance": "codev-v02-nested-java8-r07 generation1完整completed及Router独立默认verification.py exit0；89新成员/273inputs/旧包环境Git匹配。原双fresh2/2，两nestedcompileJava实际EXECUTED并逐fixture Java8 worker compiler stack观察；unknown Ruff delta/fullStrictScope=false保持披露，不表示G1门禁通过。",
        "boundedPredicate": "仅原宿主单一nested argv增加rerun；原双TestKit fresh XML 2/2零failure/error/skipped、两nested compileJava真实执行并以Java8 compiler/toolchain原生记录逐fixture绑定，major52/JAR/patch-remap一致性重开；generated TestKit home before/effective/finally精确恢复与原GRADLE_OPTS before/child合并保全成立。无fresh compiler证据准确partial/blocked，不释放R08；不修改原fixture/Java/断言/production/版本/其他owner。",
        "restriction": "只关联既有有限完成，不升格rawpartial/fullStrictScope或替代新四项"
      }
    ],
    "historicalTemporalBoundary": "当前tuple/whole等式只在T0 seal后、coord状态projection/R13副作用前；未来R13实际default消费方法不改，投影时点未决，不授权B/C或阻断当前无依赖准备"
  },
  "confirmedRetirementScope": {
    "scopeIdentity": "ready-retirement-scope-r01",
    "preparationStatus": "ready-retirement-scope",
    "executionAuthorized": false,
    "choice": "B: 一起删除整份MinecraftTests.kt及五fixture sources；选择明确，未来执行仍需Router披露实际局部范围并取得当前确认",
    "authorityFamilies": {
      "prd": {
        "assessment": "reuse",
        "owner": "Codev产品owner/user",
        "path": "docs/prd/codev-mixin-rework.md",
        "reason": "AC1–AC12/公开支持不依赖四空pass；产品支持不变"
      },
      "spec": {
        "assessment": "reuse",
        "owner": "mixins技术及Fabric/Forge元数据owner",
        "path": "docs/spec/mixin-preapplication.md",
        "reason": "真实闭包/C1–C8/A1–A12完整要求不减"
      },
      "adr": {
        "assessment": "reuse same Accepted identity",
        "owner": "mixins执行/兼容及Fabric/Forge adapter边界",
        "path": "docs/adr/mixin-operation-isolation.md",
        "reason": "操作隔离/架构决定不变；update/create skip"
      }
    },
    "futureDeleteOnlyOwners": [
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt",
      "minecraft-codev-core/basic-minecraft-test/build.gradle.kts",
      "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts",
      "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java",
      "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java",
      "minecraft-codev-core/basic-minecraft-test/src/client/Test.java"
    ],
    "futureDeleteOnlyIdentities": {
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt": {
        "length": 1576,
        "sha256": "a6be42a42c697d8d987e473acbeacd23c86c6a99e870db2356c5b30a740b771c"
      },
      "minecraft-codev-core/basic-minecraft-test/build.gradle.kts": {
        "length": 3035,
        "sha256": "61c17483fb4385f1758de38f827d781e06f710a075250dfb11f825240ee66734"
      },
      "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts": {
        "length": 43,
        "sha256": "7aab6a4b21cd4c6cac678395b42a81dbf948d9038881c3f360abbdba1c2648b0"
      },
      "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java": {
        "length": 158,
        "sha256": "c1c435c8992d39251a3774bafdda832bb087b8c5de5090ca33d823192641a8d1"
      },
      "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java": {
        "length": 136,
        "sha256": "6a89f425fcd4002a7a5c1a1bb253cb8e08647ec952c937e6e463c85594cd4b00"
      },
      "minecraft-codev-core/basic-minecraft-test/src/client/Test.java": {
        "length": 141,
        "sha256": "f6c59d49db06234b4b3ac9c623fcc54d9fe5b57098a115c2e5454567bc8842ca"
      }
    },
    "protectedVanillaOwners": [
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
      "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
    ],
    "otherProtectedOwners": [
      "所有有效Forge test/fixture（含PatchedMinecraftTests两case、basic/remapped及metadata/retained/patch回归）",
      "全部production/deps/config/locks/versions/权威/Git",
      "其它Cloche、旧logs/XML/JAR/sealed、所有原cache；不递归删除目录"
    ],
    "legacyCacheProtected": [
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/checksums/checksums.lock",
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/dependencies-accessors/dependencies-accessors.lock",
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/dependencies-accessors/gc.properties",
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/fileChanges/last-build.bin",
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/fileHashes/fileHashes.lock",
      "minecraft-codev-core/basic-minecraft-test/.gradle/8.2/gc.properties",
      "minecraft-codev-core/basic-minecraft-test/.gradle/buildOutputCleanup/buildOutputCleanup.lock",
      "minecraft-codev-core/basic-minecraft-test/.gradle/buildOutputCleanup/cache.properties",
      "minecraft-codev-core/basic-minecraft-test/.gradle/buildOutputCleanup/outputFiles.bin",
      "minecraft-codev-core/basic-minecraft-test/.gradle/vcs-1/gc.properties"
    ],
    "beforeInputCount": 278,
    "beforeInputIdentity": "ed2c8a3a1efec19c693178a49bf772c6c0229bb41c0e0812167717a5d2bbed04",
    "prospectiveInputCount": 272,
    "prospectiveInputIdentity": "daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df",
    "identityAlgorithm": "sha256(json.dumps(members, sort_keys=True).encode())",
    "coreExpectedCounts": {
      "tests": 3,
      "passed": 3,
      "skipped": 0,
      "failures": 0,
      "errors": 0
    },
    "coreCaseNames": [
      "Minecraft 1_16_5 common and client build()",
      "Minecraft 1_20_1 common and client build()",
      "Missing Minecraft ID fails at resolver without outputs()"
    ],
    "focusedCommand": ".\\gradlew.bat :minecraft-codev-core:test --rerun-tasks --no-build-cache --no-parallel --max-workers=1 --stacktrace --configuration-cache --console=plain",
    "toolchain": {
      "cwd": "E:/Projects/cloche/minecraft-codev",
      "outerGradle": "9.4.0 wrapper",
      "gradleJavaHome": "D:/Applications/Scoop/apps/microsoft17-jdk/current",
      "coreTestLauncher": "D:/Applications/Scoop/apps/intellij-jbr11-sdk-jcef/current (Java11)",
      "nestedTestKit": "Gradle9.4.0, Java17 helper/compiler",
      "gradleUserHome": "D:/Applications/Scoop/apps/gradle/current/.gradle",
      "authority": "attempt04 start/observed/toolchains及现行源码；未来必须实核现存身份，不安装/换版本/全局配置"
    },
    "futureNormalOutputBoundary": {
      "project": [
        "minecraft-codev-core/build/classes/kotlin/test/（Gradle自行移除obsolete MinecraftTests.class，禁止手工clean/筛选残留）",
        "minecraft-codev-core/build/test-results/test/及build/reports/tests/test/ fresh",
        "minecraft-codev-core/build/vanilla-build-tests/<new1.16.5,new1.20.1,newmissing-id-r12>/",
        "core/side-annotations必要原compile/metadata/JAR及其本模块build输出",
        "root .gradle/9.4.0/{executionHistory,fileHashes}、buildOutputCleanup及configuration-cache正常任务状态",
        "root build/reports/{problems,configuration-cache}正常报告"
      ],
      "nested": [
        "每自有新项目minecraft-cache/common及client、gradle-home、test-kit、gradle.properties、java-args.txt、child.stdout/stderr.txt、nested-output.txt",
        "四版本side实际resolved/common.jar、client.jar，fresh classes/java/{commonProbe,clientProbe}、libs/common.jar与client.jar"
      ],
      "external": [
        "原GRADLE_USER_HOME内正常已声明依赖/distribution下载及daemon/native日志；新project自有冷cache允许官方metadata/client/server/mappings下载"
      ],
      "limits": "仅正常command的必要generated effects；逐path/length/hash记录，非整个build/cache白名单。旧Basic .gradle十文件、旧vanilla projects和sealed绝不手工清理；额外owner/权限/环境变更未知则blocked，不自行扩项。"
    },
    "historicalAcceptedEvidence": {
      "source": "当前Handoff inline Root已接受R12A active功能前置/W08；非本Handler新接受/状态投影",
      "v02Locator": "C:\\Users\\WINDOWS\\.pi\\agent\\sessions\\--E--Projects-cloche--\\2026-09-26T19-48-28-195Z_01a0df43-0ba3-7696-8006-8634ea05c989\\tasks\\codev-r12a-g3-inplace-v02-g1.jsonl#57",
      "defaultNativeExit": 0,
      "defaultAssertions": 198,
      "g3Manifest": "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline-functional\\G1-I04E-R12A-g3\\manifest.json",
      "g3ManifestIdentity": {
        "length": 3542,
        "sha256": "40a9c03ec982a9d193fc360561761f31b02bfb67fc07fc6be7bc71c6f804610a"
      },
      "g3CurrentTreeEquality": "invalid-after-coordination-update; T0-history-only",
      "originalCoreCounts": "8tests/7passed/1skipped；4空pass及Basic skip不是覆盖",
      "oldStatuses": "rawpartial/unknown/Ruff/fullStrictScope=false/R11g3unknown/V02末端SDK失败及01两unknown全部保留"
    },
    "readableReferences": [
      "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\inputs.json",
      "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\attempt04\\receipt.json",
      "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\attempt04\\start.json",
      "docs\\works\\mixin-rework\\evidence\\g1-implementation\\core-vanilla-baseline\\G1-I04E-R12\\toolchains.json",
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/MinecraftTests.kt",
      "minecraft-codev-core/basic-minecraft-test/build.gradle.kts",
      "minecraft-codev-core/basic-minecraft-test/settings.gradle.kts",
      "minecraft-codev-core/basic-minecraft-test/src/1.12/Test.java",
      "minecraft-codev-core/basic-minecraft-test/src/1.16+/Test.java",
      "minecraft-codev-core/basic-minecraft-test/src/client/Test.java",
      "minecraft-codev-core/src/test/kotlin/net/msrandom/minecraftcodev/core/VanillaBuildTests.kt",
      "minecraft-codev-core/src/test/resources/vanilla-build/settings.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/build.gradle.kts",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/commonProbe/java/probe/CommonProbe.java",
      "minecraft-codev-core/src/test/resources/vanilla-build/src/clientProbe/java/probe/ClientProbe.java"
    ],
    "plannedEvidenceOutputs": [
      "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement/G1-I04E-R14/README.md",
      "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement/G1-I04E-R14/verification.json"
    ],
    "preparationWriteOwners": [
      "docs/works/mixin-rework/work.md",
      "docs/works/mixin-rework/context.md",
      "docs/works/mixin-rework/plan.md",
      "docs/works/mixin-rework/waves.md",
      "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-plan-r01/** (new JSON/MD only)"
    ],
    "confirmationBoundary": "静态prepared/ready不是runtime完成、门禁释放或执行授权；Router先披露局部范围/风险，取得当前用户确认后方可实施",
    "historicalR13Blocker": {
      "status": "blocked",
      "owner": "Router（协调决策/披露确认）＋R12A证据owner/R13消费owner",
      "decisionId": "D-R13-CROSS-TREE-CONSUMPTION-DECISION",
      "reason": "四coord更新即破坏g3 tuple/whole当前树等式，未来六删除另改变278身份、旧class/8-7-1/Disabled守卫；未接受跨树消费方式或时点",
      "boundary": "不设计/定案/执行R13，不接受B归档替代真实default，不放宽C白名单，不回滚coord/删生成物模拟T0",
      "unchanged": "真实独立README-default要求、fresh完整五module check、全A1-A12/AC1-AC12、P01/P02、ABI/旧caller精确debug、Forge双fixture真实Java8、I05/Git门禁不減"
    },
    "currentR13PreparationRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r01/preparation-scope.json"
  },
  "activeCompletionContractRef": "r14-limited-local-completion-r01",
  "recordedR14LimitedCompletionContract": {
    "contractId": "r14-limited-local-completion-r01",
    "contractRef": "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/contract.json",
    "sourceIdentitiesRef": "docs/works/mixin-rework/evidence/g1-implementation/core-test-retirement-limited-acceptance-r01/sources.json",
    "status": "recorded",
    "formalAcceptance": "accepted-by-Root-current-Handoff-generation2-localcompleted",
    "historicalProducerItemId": "G1-I04E-R14",
    "independentVerificationItemId": "G1-I04E-R14-V01",
    "decisionId": "D-G1-R14-LIMITED-LOCAL-COMPLETION",
    "gateRelease": "W09 prerequisite satisfied by Root, not a new writer release"
  },
  "r13LayeredPreparation": {
    "contractId": "r13-layered-final-window-r05",
    "sourceRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/sources.json",
    "proposedScopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
    "currentScopeStatus": "run01-used-failed-runtime-connected-partial-not-runtime-ready; finalBinding-and-productionOwner-retain-original-preparation-history-not-future-write-authority",
    "runAuthorized": true,
    "historicalConsumptionAcceptedByUser": true,
    "gateReleasedByPreparation": false,
    "finalBinding": {
      "inputIdentity": "daf0c2bd6a8c13a12d32a8f164306e4f0077bff9f57d24b0a9dcb2815a0355df",
      "inputCount": 272,
      "tupleRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/manifest.json#/tuple",
      "mapRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/acceptance-map.json",
      "scopeRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/preparation-scope.json",
      "inputsRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/inputs.json",
      "futureEvidenceOwner": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/",
      "requiredOutputNames": [
        "README.md",
        "inputs.json",
        "tuple.json",
        "commands.json",
        "streams.json",
        "xml-inspection.json",
        "acceptance-matrix.json",
        "direct-closure.json",
        "core-abi.json",
        "forge-java8.json",
        "effects-ledger.json",
        "environment.json",
        "manifest.json",
        "verification.json"
      ],
      "sameFinalOnly": true
    },
    "acceptedRequiredEffects": {
      "rulesRef": "docs/works/mixin-rework/evidence/g1-implementation/r13-layered-consumption-plan-r05/schema-corrected/effect-rules.json",
      "userAccepted": true,
      "actualProjectAttemptUsed": true,
      "productionOwner": "docs/works/mixin-rework/evidence/g1-implementation/core-vanilla-final/G1-I04E-R13-run01/",
      "writerMayExecute": false,
      "runtimeEvidencePassed": false,
      "thirdPartyComplete": false
    }
  }
}
```

## 未决条件与结构检查边界

D-SCOPE/D-BUILD/D-GIT-PREP 与既有维护/patch许可及 R03P/R03V/R04 completed 原事实保留；D-G1-TASK-DECLARATIONS 已有 supplied 精确用户授权。原图准备时新增 R05/P01/P02/V02 均 missing；当前 R05/P01/P02 已接受 completed，仅 V02 未完成，W03–W06/I05/I06 未释放，D-GIT-INTEGRATE 仍未授权。五模块现有 fork 值全部保留；本轮不新增版本 bump、ASM/engine/依赖/root/settings owner。是否 completed 由后继实际验证的完整 Result决定，不能由本图、旧PASS或封存完整性得出。

独立图 verifier 检查唯一 tuple/JSON、实际 item/gate/verification IDs/refs、历史结果字段和 Router 历史块保持、每 item 唯一 Wave、所有引用存在、联合依赖无环无 gate自依赖、共享 owners显式串行、首个新 structurally-ready 仅 R06A（P02 completed与最新许可已具备；两个诊断/V02 partial仅历史证据）、五check/全A/AC/下游I05/I06边界及全仓库/Git/index/旧sealed保全。结构结果只证明文档准备；不安排运行或选择下一 workflow action。


当前JSON为44 items/6 Waves；原39 IDs、其他status/Result事实与全部历史完成谓词保持，新增R06A/R06B/R07/R08各一Handler/一Result。R08是W03/I05唯一当前终验来源，V02 partial永不作为completed前置。静态核验只报告R06A structurally-ready；不实施源码/Gradle、接受runtime、推进Todo或释放W03/I05/I06/Git。

## R06 generation1 blocked 后的精确单-outcome分解

Router 已读取 `codev-v02-core-lint-repair-r06` generation1 完整 Result：**blocked**，内容格式与七rename/API保全是两个独立outcome，Handler在执行前停止，无源码/rename/build/evidence副作用。原 `G1-I04E-R06` 身份、原定义与历史证据保留为 **historical-only**，不参与当前completion门槛。旧父包 generation1 partial 与 Ruff漂移（写入者未知）保留；不运行旧默认脚本的新树 equality。

当前唯一串行执行分解为 **P02(completed) → R06A → R06B → R07 → R08**；仍只有一个 Work/Plan/Waves tuple、6 Waves。当前44 items；本次只准备派生文档，不执行任一节点。W03 requiredCompleted列R06A/R06B而非旧blocked R06；I05与W03保留R08最终全矩阵门槛。V02 latest partial与旧I04E/V01/V02继续仅为历史证据。

- **R06A / VG1-POST-05A**：一个Handler/Result，唯一修复原生32条内容规则。许可仍只覆盖原17sourceOwners的已报告imports/标点/缩进/换行/注解布局；14个有内容违规，三个filename-only文件无需修改且字节保全。不rename、不加JvmName、不改caller/其他owner。完成要求语义等价、native core compile exit0；独立fresh原生core lint预期exit1，完整报告恰剩原七`standard:filename`且无新增/其他违规。禁止关掉/筛掉filename规则冒称全lint0；该残余由R06B完成，不等同final gate通过。
- **R06B / VG1-POST-05B**：一个Handler/Result，仅在R06A completed后执行；唯一完成七文件物理命名迁移且兼容性不变，只覆盖原七source/destination与四@file:JvmName必要相邻注解格式，不泛修另外十source。四显式fixed为`ServerExtractionStateKt`、`Build_utilsKt`、`Path_utilsKt`、`Source_set_helpersKt`；`GetMinecraftFileKt`、`ExtensionKt`、`IsUnobfuscatedVersionKt`为默认名需真实编译核对，不能称七fixed授权。三case-only移动用同目录unique临时basename两步实体rename，保存实际路径/case证据。迁移前归档七facade/JAR/API/default桥/Kotlin metadata/旧caller字节；迁移后完整core compile/JAR、native core/includes validatePlugins和core lint均exit0，旧binary链接保持，不修改/重编旧caller隐藏ABI变化。允许SourceFile/SMAP/source-JAR路径差异，另仅按Waves精确LNT契约接受本次八类/166项行号+2（逐method/table count/order/BCI不变）；其余runtime/API/metadata保持，旧strict-debug失败仍保留；允许generated evidence probe但不新增项目test/build owner。
- **R07 / VG1-POST-06**：completion前置改为R06B completed（传递闭合R06A）；原单一nested argv `--rerun-tasks`、原fixture/source/断言和build-root ownership、五fork、真实Java8 compiler与Java8→Java17进程TestKit、精确环境恢复、Java11五module既有产物和保密门槛保持。
- **R08 / VG1-POST-07**：显式要求R06A、R06B、R07均completed；原同树fresh五module check、A1–A12/AC1–AC12、P01/P02 direct closure、Forge两TestKit/nativeCompiler独立验证全部保持。

R06A/R06B不清任务增量或其他cache，不获得R02C式移走state许可；真实compile暴露旧incremental state问题时据实partial及证据。原fixture、断言、算法/literals/providers、依赖/版本、未知includes/其他owner、五fork/Git权限均保持原边界。保留原逐family authority reuse，不修改PRD/ADR/Spec/DDD。仅**R06A structurally-ready**；R06B/R07/R08等待completion前置，未启动、未接受、未释放W03/I05/I06/Git。新静态封包见continuation-g2（历史原件不可访问；见顶部保留说明）；当前273inputs为准备前锚，旧冻结scope和旧parent graph/manifest/receipt/脚本均只读。
