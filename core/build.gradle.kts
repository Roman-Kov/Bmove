plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    api(project(Modules.model))
    api(project(Modules.utils))

    api(Kotlin.core)
    api(Kotlin.coroutinesAndroidLibrary)
    implementation(Dagger.dagger)
    implementation(LiveCycle.viewmodel)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.androidJUnit)
}