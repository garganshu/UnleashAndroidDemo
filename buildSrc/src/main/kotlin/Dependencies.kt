
object Versions {
    const val core = "1.7.0"
    const val jUnit = "4.13.2"
    const val jUnitExt = "1.1.5"
    const val espresso = "3.5.1"
    const val koin = "3.4.3"
    const val retrofit = "2.9.0"
    const val interceptor = "4.11.0"
    const val chuck = "1.1.0"
    const val compose = "1.4.1"
    const val activityCompose = "1.3.1"
    const val lifecycle = "2.3.1"
    const val coil = "2.4.0"
    const val unleash = "0.5.5"
}

object Dependencies {

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    const val chuckDebug = "com.readystatesoftware.chuck:library:${Versions.chuck}"
    const val chuckRelease = "com.readystatesoftware.chuck:library-no-op:${Versions.chuck}"

    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle }}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeTestJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeTest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val unleash = "io.getunleash:unleash-android-proxy-sdk:${Versions.unleash}"
}