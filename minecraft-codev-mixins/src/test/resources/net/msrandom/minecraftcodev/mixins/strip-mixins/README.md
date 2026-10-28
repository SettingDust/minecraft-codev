# StripMixinsTests frozen inputs

The remaining archives are unchanged copies of the original frozen inputs.
They exercise Codev's raw-key edit and failure cleanup contracts.

Standard `processTestResources` puts these bytes on the test classpath.
`StripMixinsTests` copies each selected resource into its own temporary input
before invoking the real Strip transform. Missing resources fail immediately.
Do not unpack/repack, normalize paths, or rewrite these archives: all first entries
carry local and central `feca0000` extra data. Preserve exact archive bytes,
entry order, raw names, timestamps, compression, CRC/size, comments and directories.

| Input | Purpose / consuming test |
| --- | --- |
| strip-normal.jar + cleanup.json | Initial config/keep bytes; every test's private baseline, ordinary failures and input protection. |
| strip-raw.jar + raw-cleanup.json | Handwritten removals: raw nested key, repeated strings across arrays and JARs, untouched config/vendor/keep. |
| strip-invalid-5.jar | Applicable config has an object in its mixin array; failed edit must not publish an output. |

## Frozen archive SHA256

- `strip-normal.jar` — `ee4568c7b1e638aa9f947273595e7970d6abe49b8b6b335b80a64fbd2e1a0202`
- `strip-raw.jar` — `10cd1d2e7d13f557e71244bff02919900c2b074b3122e676ddcb06a88f30edc2`
- `strip-invalid-5.jar` — `34bf353ddfebd3072c8596830a45737562bc163ea4a1d471144bb8569ea4466a`
