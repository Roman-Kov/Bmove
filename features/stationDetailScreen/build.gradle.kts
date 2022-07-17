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

    implementation(Ui.viewBinding)
    implementation(Ui.fragments)
    implementation(Dagger.dagger)
    kapt(Dagger.daggerCompiler)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.androidJUnit)
    androidTestImplementation(Test.espressoCore)
}