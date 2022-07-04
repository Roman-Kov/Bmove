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
    implementation(project(Modules.core))
    implementation(project(Modules.model))

    implementation(Kotlin.core)
    implementation(Kotlin.serialization)
    api(Ktor.client)
    api(Ktor.json)
    api(Ktor.clientSerialization)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.androidJUnit)
}