# Codex Guide

This repository contains a Folia-compatible fork of AxiomPaper for Minecraft 1.21.11.

## What this repo is for

- keep the plugin working on Folia
- preserve the original AxiomPaper feature set as much as possible
- improve logging so packet and scheduler issues are easier to debug

## Important build facts

- JDK 25 is required for building in this environment
- the Gradle wrapper should be used
- the main build output is in `build/libs/`
- the recommended artifact is `AxiomPaper-5.0.4+1.21.11-all.jar`

## What Codex should check first

When investigating bugs or compatibility issues, review these files first:

- `src/main/java/com/moulberry/axiom/AxiomPaper.java`
- `src/main/java/com/moulberry/axiom/packet/AxiomBigPayloadHandler.java`
- `src/main/java/com/moulberry/axiom/packet/impl/SetBlockBufferPacketListener.java`
- `src/main/java/com/moulberry/axiom/packet/impl/SetTimePacketListener.java`
- `src/main/java/com/moulberry/axiom/world_properties/server/ServerWorldPropertiesRegistry.java`
- `src/main/resources/plugin.yml`
- `build.gradle.kts`

## Compatibility rules

- Do not use `MinecraftServer.execute(...)` for Folia-sensitive work.
- Use Folia schedulers instead.
- If the task touches world, chunk, block, entity, or world time state, the scheduler choice matters.
- If logging an error, include the packet name, player name or UUID, and the full stack trace.

## Current Folia-safe patterns in this repo

- global plugin tick uses `Bukkit.getGlobalRegionScheduler().runAtFixedRate(...)`
- packet processing logs errors with full context
- world time updates are executed on the global region scheduler
- `folia-supported: true` is set in `plugin.yml`

## Build commands

Windows:

```powershell
$env:JAVA_HOME="C:\Path\To\JDK"
$env:Path="$env:JAVA_HOME\bin;$env:Path"
.\gradlew.bat build
```

Linux/macOS:

```bash
export JAVA_HOME=/path/to/jdk
export PATH="$JAVA_HOME/bin:$PATH"
./gradlew build
```

## If you need to make a new version

1. Update the version number in `build.gradle.kts`.
2. Make sure the Paper dev bundle matches the target Minecraft version.
3. Verify `plugin.yml` still uses the correct `api-version` and `folia-supported: true`.
4. Build the jar.
5. Publish the `-all.jar` as a GitHub Release asset.

## If you need to support multiple Minecraft versions

Recommended approach:

- use one branch or tag per Minecraft version
- keep version-specific release assets
- update the README release table when a new version is added

## Editing rules for Codex

- keep changes focused on compatibility or documentation unless the user asks for more
- do not revert unrelated user work
- prefer `apply_patch` for edits
- keep logs readable and specific
- when debugging, look for the actual server-side exception before assuming the client error is the root cause
