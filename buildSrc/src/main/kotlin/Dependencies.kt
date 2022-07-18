import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.rojer_ko.bmove"
    const val compileSdk = 32
    const val minSdk = 23
    const val targetSdk = 32
    val javaVersion = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val androidLibrary = "com.android.library"
    const val kapt = "kotlin-kapt"
    const val serialization = "plugin.serialization"
}

object Modules {

    const val app = ":app"
    const val core = ":core"
    const val uiCore = ":uicore"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"

    object Features {

        const val stationsScreen = ":features:stationsScreen"
        const val stationDetailScreen = ":features:stationDetailScreen"
    }
}

object Versions {
    //Plugins
    const val application = "7.2.0"
    //Kotlin
    const val kotlinCore = "1.8.0"
    const val serialization = "1.3.2"
    //Coroutines
    const val coroutines = "1.3.9"
    //JetPack
    const val livecycle = "2.4.1"
    //Design
    const val appcompat = "1.4.2"
    const val material = "1.6.1"
    const val constraintlayout = "2.1.4"
    const val swipeRefreshLayout = "1.1.0"
    const val viewBinding = "1.5.6"
    //Dagger
    const val dagger = "2.40"
    // Fragments
    const val fragments = "1.4.1"
    //Test
    const val jUnit = "4.13.2"
    const val androidJUnit = "1.1.3"
    const val espressoCore = "3.4.0"
    //Ktor
    const val ktor = "1.6.6"
    //Room
    const val room = "2.4.2"
    //Compose
    const val compose = "1.1.1"
    //Lottie
    const val lottie = "3.4.0"
}

object Kotlin {

    const val core = "androidx.core:core-ktx:${Versions.kotlinCore}"
    const val coroutinesAndroidLibrary = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
}

object LiveCycle {

    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.livecycle}"
    const val livecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.livecycle}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
}

object Ui {

    const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragments}"
    const val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBinding}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
}

object Test {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidJUnit = "androidx.test.ext:${Versions.androidJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Ktor {
    const val client = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val json = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
}

object Compose {

    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val composeLivecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.livecycle}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUIPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
}
