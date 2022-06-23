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
}

object Modules {

    const val app = ":app"
    const val core = ":core"
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
    const val kotlinPlugin = "1.6.21"
    //Kotlin
    const val kotlinCore = "1.8.0"
    //Design
    const val appcompat = "1.4.2"
    const val material = "1.6.1"
    const val constraintlayout = "2.1.4"
    //Dagger
    const val dagger = "2.40"
    // Fragments
    const val fragments = "1.4.1"
    //Test
    const val jUnit = "4.13.2"
    const val androidJUnit = "1.1.3"
    const val espressoCore = "3.4.0"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.kotlinCore}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
}

object Ui {
    const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragments}"
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
