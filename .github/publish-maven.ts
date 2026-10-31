// deno run --allow-read --allow-write --allow-env --allow-run .github/publish-maven.ts <source-ref> <pinned-sha> <remote> [checkout]
// Gradle owns Maven policy. This helper owns only the fixed-source, exact-base Git transaction.
export interface Command {
  command: string;
  args: string[];
  cwd?: string;
  env?: Record<string, string>;
  stdin?: string;
}
export type Runner = (
  command: Command,
) => Promise<{ code: number; stdout: string; stderr: string }>;
export const runCommand: Runner = async (command) => {
  const process = new Deno.Command(command.command, {
    args: command.args,
    cwd: command.cwd,
    env: command.env,
    stdin: command.stdin === undefined ? "null" : "piped",
    stdout: "piped",
    stderr: "piped",
  }).spawn();
  if (command.stdin !== undefined) {
    const writer = process.stdin.getWriter();
    await writer.write(new TextEncoder().encode(command.stdin));
    await writer.close();
  }
  const output = await process.output();
  return {
    code: output.code,
    stdout: new TextDecoder().decode(output.stdout),
    stderr: new TextDecoder().decode(output.stderr),
  };
};
export interface Options {
  ref: string;
  sha: string;
  remote: string;
  checkout: string;
}
export interface Result {
  status: "published" | "no-op" | "skip" | "failed";
  message: string;
  source: string;
  base?: string | null;
  tree?: string;
  commit?: string;
  observedRemote?: string | null;
  remoteMayHaveChanged: boolean;
}
const destination = "refs/heads/maven";
const main = "refs/heads/main";
const oid = /^[0-9a-f]{40}$|^[0-9a-f]{64}$/;
function assert(value: unknown, message: string): asserts value {
  if (!value) throw new Error(message);
}
function safePath(path: string) {
  assert(
    !path.split("/").some((part) => part.toLowerCase() === ".git"),
    `Git administration in Maven tree: ${path}`,
  );
}
async function files(directory: string): Promise<string[]> {
  const result: string[] = [];
  async function visit(path: string, prefix: string) {
    for await (const entry of Deno.readDir(path)) {
      const relative = `${prefix}${entry.name}`;
      safePath(relative);
      assert(
        !entry.isSymlink && (entry.isFile || entry.isDirectory),
        `Link/special file in Maven tree: ${relative}`,
      );
      if (entry.isDirectory) {
        await visit(`${path}/${entry.name}`, `${relative}/`);
      } else result.push(relative);
    }
  }
  await visit(directory, "");
  return result.sort();
}

export async function publishMaven(
  options: Options,
  run: Runner = runCommand,
): Promise<Result> {
  const result: Result = {
    status: "failed",
    message: "",
    source: options.sha,
    remoteMayHaveChanged: false,
  };
  // Do not even inspect the checkout or start Gradle for non-main selections.
  if (options.ref !== main) {
    return {
      ...result,
      status: "skip",
      message: `Ineligible source ref: ${options.ref}`,
    };
  }
  let scratch: string | undefined;
  try {
    assert(oid.test(options.sha), "A full pinned source SHA is required");
    assert(
      options.remote.length > 0 && !options.remote.startsWith("-") &&
        !/[\r\n\0]/.test(options.remote),
      "Invalid destination remote",
    );
    const checkout = await Deno.realPath(options.checkout);
    async function checked(command: Command) {
      const output = await run(command);
      assert(
        output.code === 0,
        `${command.command} ${command.args[0]} failed (${output.code}): ${
          output.stderr || output.stdout
        }`,
      );
      return output.stdout.trim();
    }
    async function sourceHead() {
      return await checked({
        command: "git",
        args: ["rev-parse", "HEAD"],
        cwd: checkout,
      });
    }
    assert(
      await sourceHead() === options.sha,
      "Actual source checkout HEAD differs from pinned SHA",
    );
    scratch = (await Deno.makeTempDir({ prefix: "codev-maven-transaction-" }))
      .replaceAll("\\", "/");
    const admin = `${scratch}/git`;
    const base = `${scratch}/base`;
    const candidate = `${scratch}/candidate`;
    await Deno.mkdir(base);
    await checked({ command: "git", args: ["init", "--bare", admin] });
    const git = (args: string[], stdin?: string) =>
      checked({ command: "git", args: ["--git-dir", admin, ...args], stdin });
    async function remoteHead(
      ref: string,
      allowAbsent = false,
    ): Promise<string | null> {
      const output = await run({
        command: "git",
        args: ["ls-remote", "--exit-code", "--refs", options.remote, ref],
        cwd: checkout,
      });
      if (allowAbsent && output.code === 2 && output.stdout.trim() === "") {
        return null;
      }
      assert(
        output.code === 0,
        `Cannot establish remote ${ref}: ${
          output.stderr || output.stdout || `exit ${output.code}`
        }`,
      );
      const lines = output.stdout.trim().split("\n");
      assert(lines.length === 1, `Expected exactly one remote ${ref}`);
      const [sha, name] = lines[0].trim().split(/\s+/);
      assert(oid.test(sha) && name === ref, `Invalid remote ${ref} response`);
      return sha;
    }
    async function fetchDestination(expected: string, localRef: string) {
      await git([
        "fetch",
        "--no-tags",
        "--depth=1",
        "--",
        options.remote,
        `${destination}:${localRef}`,
      ]);
      assert(
        await git(["rev-parse", localRef]) === expected,
        "Destination changed while fetching",
      );
      return await git(["rev-parse", `${localRef}^{tree}`]);
    }
    result.base = await remoteHead(destination, true);
    let baseTree: string | undefined;
    if (result.base !== null) {
      baseTree = await fetchDestination(result.base, "refs/publication/base");
      const entries = await git(["ls-tree", "-rz", result.base]);
      for (const entry of entries.split("\0").filter(Boolean)) {
        const separator = entry.indexOf("\t");
        const header = entry.slice(0, separator);
        const path = entry.slice(separator + 1);
        assert(
          /^(100644|100755) blob [0-9a-f]+$/.test(header),
          `Unsupported Maven tree entry: ${entry}`,
        );
        safePath(path);
      }
      // Override attributes only in this disposable Git admin area: export/stage exact bytes, no filters.
      await Deno.writeTextFile(
        `${admin}/info/attributes`,
        "* -text -filter -ident -working-tree-encoding\n",
      );
      await git(["read-tree", result.base]);
      await git([
        "--work-tree",
        base,
        "checkout-index",
        "--all",
        `--prefix=${base}/`,
      ]);
    }
    const args = [
      ":prepareCiMavenRepository",
      "--no-configuration-cache",
      "--no-configure-on-demand",
      "--console=plain",
      `-PciMavenBase=${base}`,
      `-PciMavenOutput=${candidate}`,
    ];
    const preparation = await run(
      Deno.build.os === "windows"
        ? {
          command: "cmd.exe",
          args: ["/d", "/c", `${checkout}/gradlew.bat`, ...args],
          cwd: checkout,
        }
        : { command: `${checkout}/gradlew`, args, cwd: checkout },
    );
    assert(
      preparation.code === 0,
      `Maven preparation failed (${preparation.code}): ${preparation.stderr}\n${preparation.stdout}`,
    );
    // Completeness, release equality and metadata validation belong to the successful I01 task, not a second publisher.
    const paths = await files(candidate);
    assert(paths.length > 0, "Empty candidate Maven tree");
    await Deno.writeTextFile(
      `${admin}/info/attributes`,
      "* -text -filter -ident -working-tree-encoding\n",
    );
    await git(["read-tree", "--empty"]);
    await git([
      "--work-tree",
      candidate,
      "-c",
      "core.autocrlf=false",
      "add",
      "--all",
      "--force",
      "--",
      ".",
    ]);
    result.tree = await git(["write-tree"]);
    if (result.tree !== baseTree) {
      result.commit = await checked({
        command: "git",
        args: [
          "--git-dir",
          admin,
          "commit-tree",
          result.tree,
          ...(result.base ? ["-p", result.base] : []),
        ],
        stdin: `Publish Maven from ${options.sha}\n`,
        env: {
          GIT_AUTHOR_NAME: "github-actions[bot]",
          GIT_AUTHOR_EMAIL:
            "41898282+github-actions[bot]@users.noreply.github.com",
          GIT_COMMITTER_NAME: "github-actions[bot]",
          GIT_COMMITTER_EMAIL:
            "41898282+github-actions[bot]@users.noreply.github.com",
        },
      });
      const commit = await git(["cat-file", "-p", result.commit]);
      const parents = commit.split("\n\n")[0].split("\n").filter((line) =>
        line.startsWith("parent ")
      );
      assert(
        JSON.stringify(parents) ===
          JSON.stringify(result.base ? [`parent ${result.base}`] : []),
        "Candidate commit has incorrect parent(s)",
      );
    }
    assert(
      await sourceHead() === options.sha,
      "Source checkout changed during preparation",
    );
    result.observedRemote = await remoteHead(destination, true);
    assert(
      result.observedRemote === result.base,
      "Destination base changed; refusing stale writer",
    );
    if (await remoteHead(main) !== options.sha) {
      return {
        ...result,
        status: "skip",
        message: "Pinned source is no longer current remote main",
      };
    }
    if (!result.commit) {
      return {
        ...result,
        status: "no-op",
        message:
          "Current source and exact destination base confirmed; tree unchanged",
      };
    }
    result.remoteMayHaveChanged = true;
    const push = await run({
      command: "git",
      args: [
        "--git-dir",
        admin,
        "push",
        "--porcelain",
        `--force-with-lease=${destination}:${result.base ?? ""}`,
        "--",
        options.remote,
        `${result.commit}:${destination}`,
      ],
    });
    // Even a failed transport may have written the ref. Observe, but never retry or claim no effect.
    result.observedRemote = await remoteHead(destination, true);
    assert(
      push.code === 0,
      `Push failed or acknowledgement lost (${push.code}); destination may already have changed: ${
        push.stderr || push.stdout
      }`,
    );
    assert(
      result.observedRemote === result.commit,
      "Post-push destination commit not confirmed; destination may already have changed",
    );
    const remoteTree = await fetchDestination(
      result.commit,
      "refs/publication/confirmed",
    );
    assert(
      remoteTree === result.tree,
      "Post-push destination tree not confirmed; destination may already have changed",
    );
    return {
      ...result,
      status: "published",
      message: "Intended destination commit and tree confirmed",
    };
  } catch (error) {
    result.message = `${error instanceof Error ? error.message : error}${
      result.remoteMayHaveChanged
        ? "; a destination write may have completed without confirmation"
        : "; no destination push attempted"
    }`;
    return result;
  } finally {
    if (scratch) {
      try {
        await Deno.remove(scratch, { recursive: true });
      } catch (error) {
        console.error(`Failed to remove scratch directory ${scratch}:`, error);
      }
    }
  }
}

if (import.meta.main) {
  const [ref, sha, remote, checkout = Deno.cwd()] = Deno.args;
  if (!ref || !sha || !remote || Deno.args.length > 4) {
    console.error(
      "Usage: publish-maven.ts <source-ref> <pinned-sha> <remote> [checkout]",
    );
    Deno.exit(1);
  }
  const result = await publishMaven({ ref, sha, remote, checkout });
  console.log(JSON.stringify(result));
  if (result.status === "failed") Deno.exitCode = 1;
}
