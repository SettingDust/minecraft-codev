# 隔离 Gradle 测试的统一代理合同

**状态：已接受的内部测试环境要求，尚未实施或动态验证。** 本文的“必须／不得”规定目标行为，不表示运行通过、计划 ready、gate 释放或实施许可。技术 owner 为 `minecraft-codev` 根构建测试基础设施，不任命个人维护者；各调用者仍负责自身输入、JDK、参数与验收。

## 范围与两个启动边界

所有使用私有 Gradle user home 的项目隔离 Gradle 测试必须沿用用户已有代理，不按 Neo、basic、1165 或模块区别政策。

- **项目 Test 路线：** 在根 `build.gradle.kts` 的共同 Test 配置中统一桥接到 Test worker，覆盖现行五模块的 Test 启动链，包括 Access Widener、Remapper、Forge、Fabric、Mixins；不逐 runner 复制读取器。同 worker 的普通单元测试也可见这五个系统属性，这是已接受的影响。根 `test` 聚合任务的执行集合不等于上述全部模块已运行。
- **独立 Java/TestKit 路线：** 实际继续使用或新建的独立调用必须接入同一薄 bootstrap，按下文规则投影到调用 JVM，再由原 TestKit/Tooling API 传递。根 Test 配置不能自动覆盖这些入口，更不能代表所有未来入口已接线。持久源码拟放在 `tools/testkit/PrivateGradleRunner.java`（尚不存在、未实现）；沿现有独立 `javac` 形态，每次编译输出归当次新证据根。不得为此新增模块、插件、`buildSrc` 或根测试依赖，也不得分叉维护多份 bootstrap。

独立调用者必须保留其精确有序 plugin classpath、样本身份及 oracle 检查；历史 runner 的固定 classpath 数量和输出标记不成为共同 bootstrap 合同。具体新签名与聚焦编译检查归后续 Plan，本文不写实施安排。

## 来源、映射与失败

唯一新增配置来源是**实际外层 `gradle.gradleUserHomeDir` 下的 `gradle.properties`**，须尊重外层 `-g/--gradle-user-home` 的解析结果。独立启动者必须由上游明确取得并保存该来源身份，先保存，再创建或改写目的 `GRADLE_USER_HOME`/私有 `-g` 环境，显式交给 bootstrap。不得猜测用户目录、沿用历史机器常量，或把已切换的目的 home 当来源。

两类入口必须使用标准 `java.util.Properties` 读取，仅选择下列键，去掉 `systemProp.` 后传给 worker／独立调用 JVM：

| 来源键 | 目的系统属性 |
| --- | --- |
| `systemProp.http.proxyHost` | `http.proxyHost` |
| `systemProp.http.proxyPort` | `http.proxyPort` |
| `systemProp.https.proxyHost` | `https.proxyHost` |
| `systemProp.https.proxyPort` | `https.proxyPort` |
| `systemProp.http.nonProxyHosts` | `http.nonProxyHosts` |

- **来源已明确但无文件／无键**是合法未配置：不得合成该键。**键存在且为空**必须传空字符串；**非空**必须保留 Properties 解码后的值。不得统一过滤空值、补默认 host/port、硬编码代理或复制整个配置。
- `http.nonProxyHosts` 的原串、通配符和 `|` 必须保留，不 trim、不拆解重组、不删 bypass，不另造 `https.nonProxyHosts`。
- **来源身份缺失**不得伪装成未配置；现存文件读取／Properties 解析失败必须明确报告并停止受影响启动，不静默降级为直连。
- 映射必须随实际 Test／独立调用的来源重新计算；配置变化、键删除或文件删除后不得沿用本桥接前次投影的值。不得从旧 worker/daemon、用户缓存或环境代理猜补；配置缓存、任务复用也不得使旧投影冒充当前配置。
- 若入口有五键的显式覆盖，必须报告冲突与实际优先关系，不静默建立另一套政策。命令行 `-D`、init 脚本的全代理发现不是本次新增能力。

## 隔离、兼容与非目标

必须保留原 `withTestKitDir`、默认 TestKit home、私有 `-g`、offline、configuration/build cache、output、tmp 和 fresh/reuse 的共享关系；代理接线不授予联网许可，不重指定目录或将用户缓存作为私有缓存。不得修改用户配置、向目的 home 复制整份配置或搬运缓存。

根 worker／独立调用 JVM 的五键交由现用 TestKit/Tooling API 传播；不得以 `JAVA_TOOL_OPTIONS`、整个环境或全部 `System.getProperties()` 的额外复制扩散到任意子进程。生产下载代码不在修改范围；同一 nested JVM 的既有下载消费者可使用其有效系统属性，但任意 Java CLI、独立工具或其他联网子进程不由本合同保证。真实消费者缺口必须如实报告，不能借工具排除项遗漏独立 GradleRunner 测试。

认证代理、SOCKS、PAC、NTLM、自动系统代理及命令行/init 全来源发现不属新增支持。不得转发 proxyUser/proxyPassword、token、仓库凭据或 `org.gradle.jvmargs`；不得披露凭据、整份配置或真实值全集。证据宜记录来源身份、键存在／空状态和一致性，日志中的敏感值须脱敏；不支持的真实认证需求不得称已解决。

历史 `build/` 脚本和证据不得原地改写或回填。新实际独立调用必须引用持久 bootstrap 源码及当轮新编译输出，不能以旧同名类代表新接线。现有 PRD、隔离 ADR、Mixin Spec 的产品与生产合同不变。

## 足够的验收条件（尚未执行）

1. **实际映射：** 用合成来源检查实际根 Test 配置与共同 bootstrap 的读取／投影，而非平行解析模型；覆盖 HTTP/HTTPS 四键、bypass 非空／缺失／显式空、空 host/port、无文件／无键、标准 Properties 转义、无关键及合成凭据不转发。检查来源身份缺失及读取／解析错误不被当作未配置；配置变更／删除后无前次投影残留。
2. **三类现用传播模式：** 最小真实构建分别覆盖默认 TestKit home 的 daemon、显式 `withTestKitDir` 加私有 `-g`、现用 `withDebug(true)` 的 embedded 路线。核对 worker 与 nested 五键三态／一致性及实际 home；embedded 结束后属性恢复。保留 offline 和原缓存开关，不要求每类下载游戏。
3. **入口完整性：** 静态核对现行十个实际 nested 启动文件均归根共同 Test 配置，包含普通 binding 与 pipeline fresh-home 两路，不被后续 `withArguments/withEnvironment/withTestKitDir` 绕开；仅取 pluginClasspath 的接点不算实际启动。静态归属不能代替上述传播检查。
4. **独立边界：** 对实际采用的独立路线，核对来源在目的环境改写前保存，并以共同 bootstrap 的当轮输出执行一个真实私有-home build，观察同一五键规则及实际 home；缺少该证据不得声称全项目实际入口全部完成。样本原有身份／oracle 错误必须继续传播。

这些是实现验收条件，不是本次作者已执行结果；不要求全量历史回归、全量快照、自证框架或逐请求路由证明。网络成功、缓存命中或 bypass 字符串均不证明每条请求经代理／某 host 实际直连；若声称具体路由，必须另有对应观察。代理传播通过也不等于 Neo 准备、内容或冷热缓存验收通过。

## 现存依据与状态边界

- [根构建配置](../../build.gradle.kts)：现行跨模块 Test 共同接点；不是本合同已实现的证据。
- [历史独立 Q-1165 调用](../../build/verify-forge-patch-1165-g1/q.py)与[旧 runner](../../build/forge-rebuilt-content-validation-g1/PrivateGradleRunner.java)：说明不经过 Test worker 的独立启动边界，仅作定位证据，不是待修改源码。
- [既有 Work](../works/mixin-review-repair/work.md)：保留原工作和历史边界，本合同不推进其执行状态。

本次只建立短内部 Spec。根桥接与共同 bootstrap 均未由本文实施；未运行 Gradle、Java、测试或网络探测。现有 Neo 失败、LSP unknown 和已通过结果各自保留，不因文档完成而改判。
