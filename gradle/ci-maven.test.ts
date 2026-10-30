// Run from the repository root: deno run --allow-read --allow-write --allow-env --allow-run gradle/ci-maven.test.ts
// Small native-publisher faults are not a substitute for Codev's complete publication/consumer run.
export {};

const root = Deno.cwd().replaceAll("\\", "/");
const scratch = await Deno.makeTempDir({ prefix: "codev-ci-maven-policy-" });
const fixture = `${root}/build/tmp/mpc-i01/fixture`;
const reports = `${root}/build/tmp/mpc-i01`;
await Deno.mkdir(reports, { recursive: true });
await Deno.writeTextFile(`${reports}/policy-root.txt`, scratch);
function assert(value: unknown, message: string): asserts value {
  if (!value) throw new Error(message);
}
async function exists(path: string) {
  try {
    await Deno.stat(path);
    return true;
  } catch (e) {
    if (e instanceof Deno.errors.NotFound) return false;
    throw e;
  }
}
async function copy(from: string, to: string) {
  await Deno.mkdir(to, { recursive: true });
  for await (const entry of Deno.readDir(from)) {
    assert(!entry.isSymlink, `Unexpected link ${entry.name}`);
    if (entry.isDirectory) {
      await copy(`${from}/${entry.name}`, `${to}/${entry.name}`);
    } else await Deno.copyFile(`${from}/${entry.name}`, `${to}/${entry.name}`);
  }
}
async function tree(path: string): Promise<Map<string, string>> {
  const result = new Map<string, string>();
  async function visit(directory: string, prefix: string) {
    for await (const entry of Deno.readDir(directory)) {
      if (entry.isDirectory) {
        await visit(`${directory}/${entry.name}`, `${prefix}${entry.name}/`);
      } else {
        const bytes = await Deno.readFile(`${directory}/${entry.name}`);
        const hash = new Uint8Array(
          await crypto.subtle.digest("SHA-256", bytes),
        );
        result.set(
          `${prefix}${entry.name}`,
          Array.from(hash, (b) => b.toString(16).padStart(2, "0")).join(""),
        );
      }
    }
  }
  await visit(path, "");
  return result;
}
await Deno.mkdir(`${fixture}/src/main/java/sample`, { recursive: true });
await Deno.writeTextFile(
  `${fixture}/settings.gradle.kts`,
  'rootProject.name = "policy-fixture"\n',
);
await Deno.writeTextFile(
  `${fixture}/src/main/java/sample/Example.java`,
  "package sample; /** Fixture. */ public class Example {}\n",
);
await Deno.writeTextFile(`${fixture}/extra.txt`, "shared version artifact\n");
await Deno.writeTextFile(
  `${fixture}/build.gradle.kts`,
  `
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository
import java.security.MessageDigest
plugins { id("java-library"); id("maven-publish") }
group = "test.publication"
version = providers.gradleProperty("releaseVersion").getOrElse("2.0")
java { withSourcesJar(); withJavadocJar() }
publishing {
    publications {
        create<MavenPublication>("main") { from(components["java"]) }
        create<MavenPublication>("marker") { artifactId = "marker"; pom { packaging = "pom" } }
        create<MavenPublication>("shared") {
            from(components["java"])
            artifactId = "policy-fixture"
            artifact("extra.txt") { classifier = "extra"; extension = "txt" }
        }
        create<MavenPublication>("idea") {
            groupId = "com.jetbrains.plugins"
            artifactId = "net.msrandom.minecraft-codev"
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
        if (providers.gradleProperty("addVersion").isPresent) {
            create<MavenPublication>("added") { version = providers.gradleProperty("addVersion").get(); from(components["java"]) }
        }
    }
}
apply(from = "${root}/gradle/ci-maven.gradle.kts")
gradle.projectsEvaluated {
    tasks.withType<PublishToMavenRepository>().filter { it.repository.name == "ciMaven" }.forEach { task ->
        task.doLast {
            if (providers.gradleProperty("fault").orNull == "publication-failure") error("Injected publication failure")
        }
    }
    tasks.named("prepareCiMavenRepository") {
        doFirst {
            val fault = providers.gradleProperty("fault").orNull
            val out = file(providers.gradleProperty("ciMavenOutput").get())
            val dir = out.resolve("test/publication/policy-fixture/$version")
            if (fault == "missing-output") check(dir.resolve("policy-fixture-$version-sources.jar").delete())
            if (fault == "invalid-metadata") {
                val index = out.resolve("test/publication/policy-fixture/maven-metadata.xml")
                index.writeText("not XML")
                listOf("md5" to "MD5", "sha1" to "SHA-1", "sha256" to "SHA-256", "sha512" to "SHA-512").forEach { (suffix, algorithm) ->
                    val digest = MessageDigest.getInstance(algorithm).digest(index.readBytes()).joinToString("") { "%02x".format(it) }
                    out.resolve("test/publication/policy-fixture/maven-metadata.xml.$suffix").writeText(digest)
                }
            }
            if (fault == "empty-output") out.listFiles()!!.forEach { check(it.deleteRecursively()) }
        }
    }
}
`,
);
const wrapper = Deno.build.os === "windows"
  ? ["cmd.exe", "/d", "/c", `${root}/gradlew.bat`]
  : [`${root}/gradlew`];
let runs = 0;
async function run(
  name: string,
  base: string,
  props: string[] = [],
  failure?: string,
) {
  const output = `${scratch}/policy-${name}`;
  assert(!await exists(output), `Refusing to reuse output: ${output}`);
  const args = [
    ...wrapper.slice(1),
    "-p",
    fixture,
    ":prepareCiMavenRepository",
    "--no-configuration-cache",
    "--no-configure-on-demand",
    "--console=plain",
    "--offline",
    `-PciMavenBase=${base}`,
    `-PciMavenOutput=${output}`,
    ...props,
  ];
  const result = await new Deno.Command(wrapper[0], {
    cwd: root,
    args,
    stdout: "piped",
    stderr: "piped",
  }).output();
  const log = new TextDecoder().decode(result.stdout) +
    new TextDecoder().decode(result.stderr);
  await Deno.writeTextFile(`${reports}/policy-${name}.log`, log);
  runs++;
  if (failure) {
    assert(
      !result.success && log.includes(failure),
      `${name}: expected rejection ${failure}; see log`,
    );
    assert(
      !await exists(output),
      `${name}: failed candidate was not discarded`,
    );
  } else {
    assert(
      result.success && log.includes("CI_MAVEN_READY"),
      `${name}: failed; see log`,
    );
    assert(await exists(output), `${name}: output missing`);
  }
  console.log(`PASS ${name}${failure ? " (rejected and discarded)" : ""}`);
  return output;
}
const empty = `${scratch}/policy-empty`;
await Deno.mkdir(empty, { recursive: true });
const first = await run("first", empty);
const before = await tree(first);
const releasePrefix = "test/publication/policy-fixture/2.0/";
const rerun = await run("rerun", first);
const again = await tree(rerun);
for (const [file, hash] of before) {
  if (file.startsWith(releasePrefix)) {
    assert(again.get(file) === hash, `Actual release rebuild drift: ${file}`);
  }
  if (
    file.startsWith(
      "com/jetbrains/plugins/net.msrandom.minecraft-codev/1.0-SNAPSHOT/",
    ) && !file.split("/").at(-1)!.startsWith("maven-metadata.xml")
  ) {
    assert(again.get(file) === hash, `Lost older snapshot: ${file}`);
  }
}
const snapshotXml = await Deno.readTextFile(
  `${rerun}/com/jetbrains/plugins/net.msrandom.minecraft-codev/1.0-SNAPSHOT/maven-metadata.xml`,
);
assert(
  snapshotXml.includes("<buildNumber>2</buildNumber>"),
  "Native snapshot build number did not advance",
);
await Deno.writeTextFile(`${rerun}/unrelated.txt`, "retain this\n");
const history = await run("lower-version", rerun, ["-PaddVersion=1.0"]);
const index = await Deno.readTextFile(
  `${history}/test/publication/policy-fixture/maven-metadata.xml`,
);
assert(
  index.includes("<version>2.0</version>") &&
    index.includes("<version>1.0</version>"),
  "Metadata lost old or lower new release",
);
assert(
  await Deno.readTextFile(`${history}/unrelated.txt`) === "retain this\n",
  "Unrelated content lost",
);
const cases: [string, string, string][] = [
  ["archive", "policy-fixture-2.0.jar", "append"],
  ["pom", "policy-fixture-2.0.pom", "append"],
  ["module", "policy-fixture-2.0.module", "append"],
  ["checksum", "policy-fixture-2.0.jar.sha256", "append"],
  ["missing", "policy-fixture-2.0-sources.jar", "remove"],
  ["extra", "stale-inherited.txt", "create"],
];
for (const [name, file, change] of cases) {
  const base = `${scratch}/policy-base-${name}`;
  await copy(first, base);
  const target = `${base}/${releasePrefix}${file}`;
  if (change === "remove") await Deno.remove(target);
  else {
    await Deno.writeTextFile(target, "changed\n", {
      append: change === "append",
    });
  }
  await run(name, base, ["-PaddVersion=1.0"], "version increase");
}
for (
  const fault of [
    "missing-output",
    "invalid-metadata",
    "publication-failure",
    "empty-output",
  ]
) {
  await run(
    fault,
    first,
    [`-Pfault=${fault}`],
    fault === "publication-failure"
      ? "Injected publication failure"
      : fault === "missing-output"
      ? "version increase"
      : fault === "empty-output"
      ? "Empty candidate Maven tree"
      : "Invalid publication",
  );
}
await run("omitted-publication", first, [
  "-x",
  "publishMainPublicationToCiMavenRepository",
], "Publication did not execute");
await run(
  "overlap",
  first,
  [`-PciMavenOutput=${first}`],
  "distinct and non-overlapping",
);
await run(
  "nonempty",
  empty,
  [`-PciMavenOutput=${first}`],
  "Output must be absent or empty",
);
await run("checkout-path", first, [
  `-PciMavenOutput=${fixture}/unsafe`,
], "outside the checkout and mavenLocal");
await run(
  "relative-path",
  first,
  ["-PciMavenOutput=relative"],
  "must be absolute",
);
await run("mavenLocal-path", first, [
  `-PciMavenOutput=${
    Deno.env.get("USERPROFILE") ?? Deno.env.get("HOME")
  }/.m2/repository`,
], "outside the checkout and mavenLocal");
const linkedBase = `${scratch}/linked-base`;
if (Deno.build.os === "windows") {
  const junction = await new Deno.Command("cmd.exe", {
    args: [
      "/d",
      "/c",
      "mklink",
      "/J",
      linkedBase.replaceAll("/", "\\"),
      first.replaceAll("/", "\\"),
    ],
    stdout: "piped",
    stderr: "piped",
  }).output();
  assert(junction.success, "Could not create isolated test junction");
} else {
  await Deno.symlink(first, linkedBase);
}
await run("linked-base", linkedBase, [], "must not traverse links");
assert(
  JSON.stringify([...before].sort()) ===
    JSON.stringify([...(await tree(first))].sort()),
  "Immutable base was changed",
);
await Deno.writeTextFile(
  `${fixture}/build.gradle.kts`,
  `plugins { id("maven-publish") }\napply(from = "${root}/gradle/ci-maven.gradle.kts")\n`,
);
await run("empty-discovery", empty, [], "No Maven publications discovered");
await Deno.writeTextFile(
  `${reports}/policy-summary.txt`,
  `${runs} native Gradle fixture runs passed. Actual fixture release rebuild byte-identical; native snapshot updates retained timestamped artifacts/sidecars; lower release accepted; shared version-directory union and POM-only output validated; descriptor/archive/checksum/missing/extra/omitted/invalid/failure/empty-discovery and unsafe-path cases rejected. Initialized failed candidates discarded; immutable bases preserved. This is fixture evidence, not Codev whole-set evidence.\n`,
);
console.log(`PASS ${runs} fixture runs; immutable base unchanged`);
