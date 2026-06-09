# AxiomPaper Folia Support

AxiomPaper is the server-side plugin for Axiom, adapted here for **Folia** and **Minecraft 1.21.11**.

This fork focuses on compatibility and clearer debugging:

- Folia-safe scheduling
- better packet error logging
- Folia-aware world time handling
- `folia-supported: true` in `plugin.yml`
- build output renamed for the target Minecraft version

## Downloads

Download the matching release asset from the GitHub Releases page.

Recommended file:

- `AxiomPaper-5.0.4+1.21.11-all.jar`

Use the `-all.jar` file for server installation unless you have a specific reason not to.

## Supported Version

- Minecraft `1.21.11`
- Folia

## Installation

1. Stop the server.
2. Put the downloaded jar into the `plugins/` folder.
3. Remove older incompatible AxiomPaper builds.
4. Start the server again.

## Building From Source

### Requirements

- JDK 25
- Git
- Windows, Linux, or macOS
- The Gradle wrapper is already included

### Build the latest version

If you want the newest code in this repository, build the default branch:

```bash
git clone <your-repo-url>
cd AxiomPaperPlugin-src
./gradlew build
```

On Windows:

```powershell
$env:JAVA_HOME="C:\Path\To\JDK"
$env:Path="$env:JAVA_HOME\bin;$env:Path"
.\gradlew.bat build
```

### Build a specific version

If you want a specific Minecraft version, check out the matching branch or tag first.

Example:

```bash
git checkout v5.0.4-1.21.11-folia
./gradlew build
```

If you maintain multiple versions, each version should have its own branch or tag, for example:

- `v5.0.4-1.21.11-folia`
- `v5.0.4-1.21.10-folia`
- `v5.0.4-1.20.4-folia`

## Build Output

After a successful build, the jar files are written to:

```text
build/libs/
```

Main release artifact:

```text
AxiomPaper-5.0.4+1.21.11-all.jar
```

## Latest vs Specific Builds

### Latest build

Use the latest GitHub Release if you want the newest supported build.

### Specific build

Use the release that matches your Minecraft version exactly.

Example release names:

- `AxiomPaper-5.0.4+1.21.11-all.jar`
- `AxiomPaper-5.0.4+1.21.10-all.jar`
- `AxiomPaper-5.0.4+1.20.4-all.jar`

## Versioning Strategy

Recommended structure:

- `main` branch tracks the latest supported version
- one release tag per Minecraft version
- one GitHub Release per build
- one jar asset per version

This makes it easy for users to download the correct file without guessing.

## GitHub Release Example

A good release should include:

- a short summary of what changed
- the supported Minecraft version
- the Folia compatibility note
- the `-all.jar` asset

Example asset list:

- `AxiomPaper-5.0.4+1.21.11-all.jar`
- `AxiomPaper-5.0.4+1.21.11.jar`

## Notes

- This fork is focused on Folia compatibility.
- If a feature touches world state, chunk state, entity state, or world time, it must use the correct Folia scheduler.
- Error logs have been improved so debugging should be much easier if something still goes wrong.

## FAQ

### Why is the `-all.jar` recommended?

It is the safest server-ready build artifact to install in `plugins/`.

### How do I get the newest build?

Use the latest GitHub Release or build the `main` branch.

### How do I build an older version?

Checkout the matching tag or branch first, then run `./gradlew build`.
