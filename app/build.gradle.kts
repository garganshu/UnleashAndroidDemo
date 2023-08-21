plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.unleashdemo"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "UNSPLASH_API_URL", "\"${properties["UNSPLASH_API_URL"]}\"")
        buildConfigField("String", "UNSPLASH_KEY", "\"${properties["UNSPLASH_KEY"]}\"")
        buildConfigField("String", "UNLEASH_API_URL", "\"${properties["UNLEASH_API_URL"]}\"")
        buildConfigField("String", "UNLEASH_CLIENT_KEY", "\"${properties["UNLEASH_CLIENT_KEY"]}\"")


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources.excludes.run {
            add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Dependencies.core)
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitExt)
    androidTestImplementation(Dependencies.espresso)

    implementation(Dependencies.koin)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.interceptor)

    debugImplementation(Dependencies.chuckDebug)
    releaseImplementation(Dependencies.chuckRelease)

    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeToolingPreview)
    implementation(Dependencies.composeLifecycle)
    implementation(Dependencies.composeActivity)
    androidTestImplementation(Dependencies.composeTestJUnit)
    debugImplementation(Dependencies.composeTooling)
    debugImplementation(Dependencies.composeTest)

    implementation(Dependencies.coil)
    implementation(Dependencies.unleash)

}