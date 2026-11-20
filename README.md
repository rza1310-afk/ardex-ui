# aRDEX-UI (no Firebase)

Sci-fi fullscreen terminal emulator, real-time Android system telemetry HUD, 3D network globe and
filesystem explorer inspired by eDEX-UI.

This build has **no Firebase, no Google sign-in and no cloud sync**. Everything (themes, HUD
profiles, macro decks, settings) is stored locally in DataStore and the app opens straight to the HUD.

## Build

1. Install the latest Android Studio (project uses AGP 9.1.1 / Gradle 9.3.1 / Kotlin 2.4.21,
   compileSdk 36.1).
2. File > Open this folder and let Gradle sync.
3. Build > Build APK(s), or `./gradlew assembleDebug` if you generated a wrapper with `gradle wrapper`.
4. APK: `app/build/outputs/apk/debug/app-debug.apk`

`debug.keystore` (standard Android debug key) is included so the debug build signs out of the box.
For a release build set `KEYSTORE_PATH`, `STORE_PASSWORD` and `KEY_PASSWORD` (key alias `upload`).

## Build online (GitHub Actions)

Push this folder to a GitHub repo. The workflow in `.github/workflows/build-apk.yml` builds the
debug APK on every push (or run it manually from the Actions tab > Build APK > Run workflow).
Download the APK from the run's **Artifacts** section.
