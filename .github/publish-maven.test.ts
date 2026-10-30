// Transport tests use local bare remotes only; no native Codev/Gradle publication is repeated.
// MPC_REAL_BASE / MPC_REAL_TREE optionally select I01's proven trees for the byte-replay transport check.
import {
  type Command,
  type Options,
  publishMaven,
  type Result,
  runCommand,
  type Runner,
} from "./publish-maven.ts";

function assert(value: unknown, message: string): asserts value {
  if (!value) throw new Error(message);
}
async function copy(from: string, to: string) {
  await Deno.mkdir(to, { recursive: true });
  for await (const entry of Deno.readDir(from)) {
    assert(!entry.isSymlink, "No fixture links");
    if (entry.isDirectory) {
      await copy(`${from}/${entry.name}`, `${to}/${entry.name}`);
    } else await Deno.copyFile(`${from}/${entry.name}`, `${to}/${entry.name}`);
  }
}
const identity = {
  GIT_AUTHOR_NAME: "local-transport-fixture",
  GIT_AUTHOR_EMAIL: "fixture@example.invalid",
  GIT_COMMITTER_NAME: "local-transport-fixture",
  GIT_COMMITTER_EMAIL: "fixture@example.invalid",
};
async function exec(command: Command) {
  const output = await runCommand(command);
  assert(output.code === 0, `${JSON.stringify(command)}: ${output.stderr}`);
  return output.stdout.trim();
}
const reports = `${Deno.cwd().replaceAll("\\", "/")}/build/tmp/mpc-i02`;
await Deno.mkdir(reports, { recursive: true });
const scratch =
  (await Deno.makeTempDir({ dir: reports, prefix: "local-remotes-" }))
    .replaceAll("\\", "/");
await Deno.writeTextFile(`${reports}/fixture-root.txt`, scratch);
const evidence = `${reports}/transactions.log`;
await Deno.writeTextFile(
  evidence,
  "MPC-I02 local Git transport evidence. Synthetic preparer faults; proven I01 bytes only where labelled.\n",
);
let count = 0;

async function fixture(sourceName = "source") {
  const root = `${scratch}/${++count}`;
  const source = `${root}/${sourceName}`;
  const remote = `${root}/remote.git`;
  await Deno.mkdir(source, { recursive: true });
  const git = (...args: string[]) =>
    exec({
      command: "git",
      args: ["--git-dir", remote, ...args],
      env: identity,
    });
  const src = (...args: string[]) =>
    exec({ command: "git", args, cwd: source, env: identity });
  await src("init", "-b", "main");
  await Deno.writeTextFile(`${source}/source.txt`, "fixed source\n");
  await src("add", ".");
  await src(
    "-c",
    "commit.gpgsign=false",
    "commit",
    "-m",
    "local fixture source",
  );
  const sha = await src("rev-parse", "HEAD");
  await exec({ command: "git", args: ["init", "--bare", remote] });
  await src(
    "push",
    remote,
    "HEAD:refs/heads/main",
    "HEAD:refs/tags/fixture-source",
  );
  const options: Options = {
    ref: "refs/heads/main",
    sha,
    remote,
    checkout: source,
  };
  async function head() {
    const output = await runCommand({
      command: "git",
      args: ["--git-dir", remote, "rev-parse", "--verify", "refs/heads/maven"],
    });
    return output.code === 0 ? output.stdout.trim() : null;
  }
  async function snapshot() {
    const commit = await head();
    return {
      commit,
      tree: commit ? await git("rev-parse", `${commit}^{tree}`) : null,
      parents: commit
        ? (await git("cat-file", "-p", commit)).split("\n\n")[0].split("\n")
          .filter((s) => s.startsWith("parent "))
        : [],
      paths: commit
        ? (await git("ls-tree", "-r", "--name-only", commit)).split("\n")
        : [],
      refs: await git("show-ref"),
    };
  }
  const payload = `${root}/payload`;
  await Deno.mkdir(`${payload}/synthetic/example/2.0`, { recursive: true });
  await Deno.writeTextFile(
    `${payload}/synthetic/example/2.0/example-2.0.pom`,
    "synthetic transport payload\r\n",
  );
  await Deno.writeTextFile(`${payload}/history.txt`, "unrelated history\n");
  async function winner() {
    const previous = await head();
    const writer = `${root}/writer-${crypto.randomUUID()}`;
    await Deno.mkdir(writer);
    await Deno.writeTextFile(`${writer}/winner.txt`, "concurrent winner\n");
    await git("read-tree", ...(previous ? [previous] : ["--empty"]));
    // Add just the winner path; retain every existing tree entry.
    await git("--work-tree", writer, "add", "--force", "--", "winner.txt");
    const tree = await git("write-tree");
    const commit = await exec({
      command: "git",
      args: [
        "--git-dir",
        remote,
        "commit-tree",
        tree,
        ...(previous ? ["-p", previous] : []),
      ],
      stdin: "competing local winner\n",
      env: identity,
    });
    await git(
      "update-ref",
      "refs/heads/maven",
      commit,
      previous ?? "0000000000000000000000000000000000000000",
    );
    return commit;
  }
  let preparations = 0;
  let pushes = 0;
  let producer = async (_base: string, candidate: string) => {
    await copy(payload, candidate);
    return {
      code: 0,
      stdout: "Synthetic complete transport payload",
      stderr: "",
    };
  };
  let intercept:
    | ((command: Command) => Promise<Awaited<ReturnType<Runner>> | undefined>)
    | undefined;
  const runner: Runner = async (command) => {
    if (command.args.includes(":prepareCiMavenRepository")) {
      preparations++;
      assert(
        command.args.includes("--no-configuration-cache") &&
          command.args.includes("--no-configure-on-demand"),
        "Exact I01 task flags",
      );
      assert(
        !command.args.includes("publish") && !command.args.includes("test"),
        "No aggregate publisher/tests",
      );
      const base = command.args.find((arg) => arg.startsWith("-PciMavenBase="))!
        .slice("-PciMavenBase=".length);
      const candidate = command.args.find((arg) =>
        arg.startsWith("-PciMavenOutput=")
      )!.slice("-PciMavenOutput=".length);
      assert(
        !base.startsWith(source) && !candidate.startsWith(source) &&
          base !== candidate,
        "Isolated I01 paths",
      );
      return await producer(base, candidate);
    }
    if (command.args.includes("push")) pushes++;
    const injected = await intercept?.(command);
    return injected ?? await runCommand(command);
  };
  async function invoke(label: string) {
    const before = await snapshot();
    const result = await publishMaven(options, runner);
    const after = await snapshot();
    await Deno.writeTextFile(
      evidence,
      JSON.stringify({
        label,
        source: options.sha,
        before,
        result,
        after,
        preparations,
        pushes,
      }) + "\n",
      { append: true },
    );
    // Source branch and tags are never publication targets.
    assert(
      await src("rev-parse", "HEAD") === sha,
      "Source checkout never switched",
    );
    const sourceRefs = (text: string) =>
      text.split("\n").filter((line) => !line.endsWith(" refs/heads/maven"))
        .join("\n");
    assert(
      sourceRefs(before.refs) === sourceRefs(after.refs),
      "No source branch/tag writes by helper",
    );
    return { result, before, after };
  }
  return {
    root,
    source,
    remote,
    payload,
    sha,
    options,
    git,
    src,
    head,
    snapshot,
    winner,
    invoke,
    runner,
    get preparations() {
      return preparations;
    },
    get pushes() {
      return pushes;
    },
    set producer(value: typeof producer) {
      producer = value;
    },
    set intercept(value: typeof intercept) {
      intercept = value;
    },
  };
}
function failed(result: Result, text: string) {
  assert(
    result.status === "failed" && result.message.includes(text),
    `Expected failure ${text}, got ${JSON.stringify(result)}`,
  );
}
function unchanged(
  run: Awaited<ReturnType<Awaited<ReturnType<typeof fixture>>["invoke"]>>,
) {
  assert(
    run.before.commit === run.after.commit &&
      run.before.tree === run.after.tree,
    "Destination commit/tree unchanged",
  );
}
async function seed(f: Awaited<ReturnType<typeof fixture>>) {
  const run = await f.invoke("synthetic seed");
  assert(run.result.status === "published", JSON.stringify(run.result));
  assert(
    run.after.parents.length === 0 && run.after.commit === run.result.commit &&
      run.after.tree === run.result.tree,
    "Single initial root commit confirmed",
  );
  return run;
}
Deno.test("MPC-I02 local Git transaction contract", async (test) => {
  await test.step("initial and existing root-layout trees; exact single parent; CRLF preserved", async () => {
    const f = await fixture();
    const initial = await seed(f);
    assert(
      initial.after.paths.includes("synthetic/example/2.0/example-2.0.pom") &&
        !initial.after.paths.some((p) =>
          p.includes(".git") || p.startsWith("repository/")
        ),
      "Maven layout at root",
    );
    assert(
      await f.git("rev-list", "--count", "refs/heads/maven") === "1",
      "One destination commit",
    );
    const bytes = await runCommand({
      command: "git",
      args: [
        "--git-dir",
        f.remote,
        "show",
        "refs/heads/maven:synthetic/example/2.0/example-2.0.pom",
      ],
    });
    assert(
      bytes.stdout === "synthetic transport payload\r\n",
      "Exact CRLF bytes",
    );
    f.producer = async (base, candidate) => {
      assert(
        await Deno.readTextFile(`${base}/history.txt`) ===
          "unrelated history\n",
        "Exact base exported",
      );
      await copy(base, candidate);
      await Deno.writeTextFile(
        `${candidate}/new-version.txt`,
        "unused lower version allowed by preparer\n",
      );
      return { code: 0, stdout: "Synthetic prepared addition", stderr: "" };
    };
    const update = await f.invoke("synthetic existing update");
    assert(
      update.result.status === "published" &&
        update.after.parents.join() === `parent ${initial.after.commit}`,
      JSON.stringify(update.result),
    );
    assert(
      update.after.paths.includes("history.txt") &&
        update.after.paths.includes("new-version.txt"),
      "History and new output survive",
    );
    assert(
      await f.git("rev-list", "--count", "refs/heads/maven") === "2",
      "Exactly one commit per changed tree",
    );
  });
  for (const event of ["automatic", "manual"]) {
    await test.step(`${event} main: current rerun no-op; stale skip; unreadable main fail`, async () => {
      const f = await fixture();
      await seed(f);
      const noop = await f.invoke(`${event} current main rerun`);
      assert(
        noop.result.status === "no-op" && !noop.result.commit,
        JSON.stringify(noop.result),
      );
      unchanged(noop);
      await Deno.writeTextFile(`${f.source}/source.txt`, "newer main\n");
      await f.src("add", ".");
      await f.src(
        "-c",
        "commit.gpgsign=false",
        "commit",
        "-m",
        "new remote main",
      );
      await f.src("push", f.remote, "HEAD:refs/heads/main");
      await f.src("checkout", "--detach", f.sha);
      const stale = await f.invoke(`${event} stale source`);
      assert(stale.result.status === "skip", JSON.stringify(stale.result));
      unchanged(stale);
      f.intercept = async (c) =>
        c.args[0] === "ls-remote" && c.args.at(-1) === "refs/heads/main"
          ? { code: 128, stdout: "", stderr: "synthetic main unreadable" }
          : undefined;
      const unreadable = await f.invoke(`${event} unreadable main`);
      failed(unreadable.result, "Cannot establish remote refs/heads/main");
      unchanged(unreadable);
    });
  }
  for (const ref of ["refs/heads/feature", "refs/tags/v1"]) {
    await test.step(`${ref} skips before checkout, preparer or Git`, async () => {
      const result = await publishMaven({
        ref,
        sha: "invalid",
        remote: "invalid",
        checkout: "not-a-checkout",
      }, () => {
        throw new Error("Must not run subprocess");
      });
      assert(
        result.status === "skip" && !result.remoteMayHaveChanged,
        "Explicit ref skip",
      );
      const cli = await runCommand({
        command: Deno.execPath(),
        args: [
          "run",
          "--allow-read",
          "--allow-write",
          "--allow-env",
          "--allow-run",
          new URL("./publish-maven.ts", import.meta.url).pathname.replace(
            /^\/([A-Za-z]:)/,
            "$1",
          ),
          ref,
          "invalid",
          "invalid",
          "not-a-checkout",
        ],
      });
      assert(
        cli.code === 0 && JSON.parse(cli.stdout).status === "skip",
        cli.stderr,
      );
    });
  }
  await test.step("actual checkout HEAD must equal full pinned SHA", async () => {
    const f = await fixture();
    f.options.sha = "a".repeat(40);
    const run = await f.invoke("pinned checkout mismatch");
    failed(run.result, "Actual source checkout HEAD");
    unchanged(run);
    assert(f.preparations === 0 && f.pushes === 0, "Reject before preparation");
  });
  for (
    const fault of [
      "publication failure",
      "release conflict plus new release/snapshot",
      "incomplete candidate",
    ]
  ) {
    await test.step(`I01 rejected ${fault}: no subset escapes`, async () => {
      const f = await fixture();
      await seed(f);
      f.producer = async (_base, candidate) => {
        await Deno.mkdir(candidate);
        await Deno.writeTextFile(
          `${candidate}/new-partial-output`,
          "must never escape\n",
        );
        return {
          code: 1,
          stdout: "",
          stderr: `Synthetic I01 rejection: ${fault}`,
        };
      };
      const run = await f.invoke(`synthetic ${fault}`);
      failed(run.result, fault);
      unchanged(run);
      assert(
        f.pushes === 1 && !run.result.remoteMayHaveChanged,
        "Only earlier seed pushed",
      );
    });
  }
  for (const fault of ["empty", "absent", "git-admin"]) {
    await test.step(`invalid successful preparer output: ${fault}`, async () => {
      const f = await fixture();
      await seed(f);
      f.producer = async (_base, candidate) => {
        if (fault !== "absent") await Deno.mkdir(candidate);
        if (fault === "git-admin") {
          await Deno.writeTextFile(`${candidate}/.git`, "not Maven\n");
        }
        return { code: 0, stdout: "synthetic malformed preparer", stderr: "" };
      };
      const run = await f.invoke(`synthetic ${fault} output`);
      if (fault === "empty") failed(run.result, "Empty candidate Maven tree");
      else if (fault === "git-admin") failed(run.result, "Git administration");
      else failed(run.result, "readdir");
      unchanged(run);
    });
  }
  await test.step("unreadable destination is not absence", async () => {
    const f = await fixture();
    f.intercept = async (c) =>
      c.args[0] === "ls-remote"
        ? { code: 128, stdout: "", stderr: "synthetic destination unreadable" }
        : undefined;
    const run = await f.invoke("unreadable destination");
    failed(run.result, "Cannot establish remote refs/heads/maven");
    unchanged(run);
    assert(f.preparations === 0, "No preparer on unreadable destination");
  });
  for (const initial of [false, true]) {
    await test.step(`exact ${initial ? "absence" : "base"} lease rejects racing writer; retry rechecks main`, async () => {
      const f = await fixture();
      if (!initial) {
        await seed(f);
        await Deno.writeTextFile(`${f.payload}/added.txt`, "stale writer\n");
      }
      let winner: string | undefined;
      f.intercept = async (c) => {
        if (c.args.includes("push")) winner = await f.winner();
        return undefined;
      };
      const race = await f.invoke(
        `synthetic ${initial ? "creation" : "existing"} lease race`,
      );
      failed(race.result, "Push failed");
      assert(
        race.after.commit === winner && race.after.paths.includes("winner.txt"),
        "Exact race winner retained",
      );
      assert(race.result.commit !== winner, "Stale commit not installed");
      f.intercept = undefined;
      await Deno.writeTextFile(`${f.source}/source.txt`, "newer remote main\n");
      await f.src("add", ".");
      await f.src(
        "-c",
        "commit.gpgsign=false",
        "commit",
        "-m",
        "advance main before retry",
      );
      await f.src("push", f.remote, "HEAD:refs/heads/main");
      await f.src("checkout", "--detach", f.sha);
      const retry = await f.invoke(
        "later invocation after race and main advance",
      );
      assert(retry.result.status === "skip", JSON.stringify(retry.result));
      unchanged(retry);
      assert(retry.after.commit === winner, "Retry preserves winner");
    });
  }
  for (const noop of [false, true]) {
    await test.step(`${noop ? "no-op" : "changed candidate"} detects base moved before preflight`, async () => {
      const f = await fixture();
      await seed(f);
      if (!noop) await Deno.writeTextFile(`${f.payload}/new.txt`, "addition");
      let winner: string | undefined;
      f.producer = async (_base, candidate) => {
        await copy(f.payload, candidate);
        winner = await f.winner();
        return { code: 0, stdout: "synthetic prepared", stderr: "" };
      };
      const run = await f.invoke(
        `synthetic ${noop ? "no-op" : "changed"} preflight race`,
      );
      failed(run.result, "Destination base changed");
      assert(
        run.after.commit === winner && f.pushes === 1,
        "Preflight refuses push and retains winner",
      );
    });
  }
  await test.step("actual local receive hook rejection is failure", async () => {
    const f = await fixture();
    await seed(f);
    await Deno.writeTextFile(`${f.payload}/added.txt`, "new\n");
    await Deno.writeTextFile(
      `${f.remote}/hooks/pre-receive`,
      "#!/bin/sh\necho local-fixture-rejected >&2\nexit 1\n",
    );
    if (Deno.build.os !== "windows") {
      await Deno.chmod(`${f.remote}/hooks/pre-receive`, 0o755);
    }
    const run = await f.invoke("actual local rejected push");
    failed(run.result, "Push failed");
    unchanged(run);
    assert(
      run.result.message.includes("local-fixture-rejected"),
      "Actual receive rejection observed",
    );
  });
  for (
    const fault of [
      "lost acknowledgement",
      "unreadable verification",
      "fetch verification failure",
      "different post-push commit",
    ]
  ) {
    await test.step(`${fault}: possible completed write is not success`, async () => {
      const f = await fixture();
      await seed(f);
      await Deno.writeTextFile(`${f.payload}/added.txt`, "new\n");
      let pushed = false;
      f.intercept = async (c) => {
        if (c.args.includes("push")) {
          const output = await runCommand(c);
          assert(output.code === 0, output.stderr);
          pushed = true;
          if (fault === "different post-push commit") await f.winner();
          return fault === "lost acknowledgement"
            ? {
              ...output,
              code: 1,
              stderr: "synthetic lost acknowledgement after actual local write",
            }
            : output;
        }
        if (
          pushed && fault === "unreadable verification" &&
          c.args[0] === "ls-remote"
        ) {
          return {
            code: 128,
            stdout: "",
            stderr: "synthetic post-write read failure",
          };
        }
        if (
          pushed && fault === "fetch verification failure" &&
          c.args.includes("fetch")
        ) {
          return {
            code: 128,
            stdout: "",
            stderr: "synthetic confirmation fetch failure",
          };
        }
        return undefined;
      };
      const run = await f.invoke(`synthetic ${fault} after actual write`);
      assert(
        run.result.status === "failed" && run.result.remoteMayHaveChanged &&
          run.result.message.includes("may have completed"),
        JSON.stringify(run.result),
      );
      assert(
        run.after.commit !== run.before.commit,
        "Write actually occurred, never falsely claimed unchanged",
      );
      if (fault !== "different post-push commit") {
        assert(
          run.after.commit === run.result.commit &&
            run.after.tree === run.result.tree,
          "Actual intended write despite failed confirmation",
        );
      } else {assert(
          run.after.paths.includes("winner.txt"),
          "Post-write winner retained",
        );}
    });
  }
  await test.step("CLI and real wrapper subprocess in a spaced checkout (synthetic preparer)", async () => {
    const f = await fixture("source with spaces");
    await Deno.writeTextFile(
      `${f.source}/prepare.ts`,
      `
const args = Deno.args;
await Deno.writeTextFile(${
        JSON.stringify(`${f.source}/observed.json`)
      }, JSON.stringify(args));
if (await Deno.stat(${
        JSON.stringify(`${f.source}/fail`)
      }).then(() => true, () => false)) Deno.exit(1);
const base = args.find(a => a.startsWith("-PciMavenBase="))!.slice("-PciMavenBase=".length);
const output = args.find(a => a.startsWith("-PciMavenOutput="))!.slice("-PciMavenOutput=".length);
if (!args.includes(":prepareCiMavenRepository") || !args.includes("--no-configuration-cache") || !args.includes("--no-configure-on-demand")) throw Error("Incorrect task invocation");
await Deno.stat(base);
await Deno.mkdir(output);
await Deno.copyFile(${
        JSON.stringify(`${f.payload}/history.txt`)
      }, output + "/history.txt");
console.log("synthetic preparer subprocess, not Gradle");
`,
    );
    await Deno.writeTextFile(
      `${f.source}/gradlew.bat`,
      `@"${Deno.execPath()}" run --allow-read --allow-write "%~dp0prepare.ts" %*\r\n`,
    );
    await Deno.writeTextFile(
      `${f.source}/gradlew`,
      `#!/bin/sh\nexec '${Deno.execPath()}' run --allow-read --allow-write "$(dirname "$0")/prepare.ts" "$@"\n`,
    );
    if (Deno.build.os !== "windows") {
      await Deno.chmod(`${f.source}/gradlew`, 0o755);
    }
    const cli = () =>
      runCommand({
        command: Deno.execPath(),
        args: [
          "run",
          "--allow-read",
          "--allow-write",
          "--allow-env",
          "--allow-run",
          decodeURIComponent(
            new URL("./publish-maven.ts", import.meta.url).pathname,
          ).replace(/^\/([A-Za-z]:)/, "$1"),
          f.options.ref,
          f.sha,
          f.remote,
          f.source,
        ],
      });
    const initial = await cli();
    assert(
      initial.code === 0 && JSON.parse(initial.stdout).status === "published",
      initial.stdout + initial.stderr,
    );
    const before = await f.snapshot();
    const noop = await cli();
    assert(
      noop.code === 0 && JSON.parse(noop.stdout).status === "no-op",
      noop.stdout + noop.stderr,
    );
    await Deno.writeTextFile(`${f.source}/fail`, "synthetic failure\n");
    const failure = await cli();
    assert(
      failure.code === 1 && JSON.parse(failure.stdout).status === "failed",
      failure.stdout + failure.stderr,
    );
    const after = await f.snapshot();
    assert(
      before.commit === after.commit && before.tree === after.tree,
      "CLI no-op and failure do not write",
    );
    await Deno.writeTextFile(
      evidence,
      JSON.stringify({
        label: "CLI default Runner, synthetic subprocess preparer, spaced path",
        source: f.sha,
        initial,
        noop,
        failure,
        before,
        after,
      }) + "\n",
      { append: true },
    );
  });
  const realBase = Deno.env.get("MPC_REAL_BASE");
  const realTree = Deno.env.get("MPC_REAL_TREE");
  await test.step({
    name:
      "proven I01 complete trees: initial, update, exact bytes and history, no-op",
    ignore: !realBase || !realTree,
    fn: async () => {
      const f = await fixture();
      f.producer = async (_base, candidate) => {
        await copy(realBase!, candidate);
        return {
          code: 0,
          stdout: "REPLAY I01 proven full-first; not a Gradle rebuild",
          stderr: "",
        };
      };
      const initial = await f.invoke(
        "REAL I01 full-first byte replay, initial transport",
      );
      assert(
        initial.result.status === "published" &&
          initial.after.parents.length === 0,
        JSON.stringify(initial.result),
      );
      f.producer = async (base, candidate) => {
        assert(
          await Deno.readTextFile(`${base}/unrelated.txt`) ===
            await Deno.readTextFile(`${realBase}/unrelated.txt`),
          "Unrelated base byte preservation",
        );
        await copy(realTree!, candidate);
        return {
          code: 0,
          stdout: "REPLAY I01 proven full-second; not a Gradle rebuild",
          stderr: "",
        };
      };
      const update = await f.invoke(
        "REAL I01 full-second byte replay, existing transport",
      );
      assert(
        update.result.status === "published" &&
          update.after.parents.join() === `parent ${initial.after.commit}`,
        JSON.stringify(update.result),
      );
      const expectedPaths: string[] = [];
      async function compare(dir: string, prefix: string) {
        for await (const entry of Deno.readDir(dir)) {
          const path = `${prefix}${entry.name}`;
          if (entry.isDirectory) {
            await compare(`${dir}/${entry.name}`, `${path}/`);
          } else {
            expectedPaths.push(path);
            const expected = await Deno.readFile(`${dir}/${entry.name}`);
            const blob = await new Deno.Command("git", {
              args: ["--git-dir", f.remote, "show", `refs/heads/maven:${path}`],
              stdout: "piped",
              stderr: "piped",
            }).output();
            assert(
              blob.code === 0 && expected.length === blob.stdout.length &&
                expected.every((b, i) => b === blob.stdout[i]),
              `Exact proven bytes: ${path}`,
            );
          }
        }
      }
      await compare(realTree!, "");
      assert(
        JSON.stringify(expectedPaths.sort()) ===
          JSON.stringify(update.after.paths.sort()),
        "Every proven path and no cache/admin/source path",
      );
      assert(
        expectedPaths.length === 511 && expectedPaths.some((p) =>
          p.startsWith("com/jetbrains/plugins/")
        ) && expectedPaths.some((p) =>
          p.startsWith("minecraft-codev-access-widener/")
        ),
        "Full adopted I01 tree, not net/msrandom subset",
      );
      const noop = await f.invoke("REAL I01 identical candidate no-op");
      assert(noop.result.status === "no-op", JSON.stringify(noop.result));
      unchanged(noop);
    },
  });
});
