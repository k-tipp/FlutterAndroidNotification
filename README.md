# Example of Android notifications with Flutter

This project is a customization of the 'hello_services' project from the [Flutter examples](https://github.com/flutter/flutter/tree/master/examples).

--- The following section from 'hello_services' should also apply to this project. ---
## Android

### Configure

Create an `android/local.properties` file with these entries:

 * `sdk.dir=[path to the Android SDK]`
 * `flutter.sdk=[path to the Flutter SDK]`

There are a number of other parameters you can control with this file:

 * `flutter.buildMode`: Whether to build for `debug`, `profile`, or `release`.
   Defaults to `release`.
 * `flutter.jar`: The path to `flutter.jar`. Defaults to the
   `android-arm-release` version of `flutter.jar` in the `bin/cache` directory
   of the Flutter SDK.

See `android/app/build.gradle` for project specific settings, including:

 * `source`: The path to the directory that contains your `pubspec.yaml` file
   relative to your `build.gradle` file.
 * `target`: The path to your `main.dart` relative to your `pubspec.yaml`.
   Defaults to `lib/main.dart`.

### Build

To build directly with `gradle`, use the following commands:

 * `cd android`
 * `gradle wrapper`
 * `./gradlew build`

To build with Android Studio, open the `android` folder in Android Studio and
build the project as usual.
--- End of section ---
