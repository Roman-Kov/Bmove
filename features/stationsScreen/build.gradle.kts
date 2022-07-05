plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

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

    implementation(Ui.fragments)
    implementation(Ui.viewBinding)
    implementation(Design.appcompat)
    implementation(Design.constraintlayout)
    implementation(Design.material)
    implementation(Dagger.dagger)
    implementation(Compose.composeMaterial)
    implementation(Compose.composeFoundation)
    implementation(Compose.composeFoundationLayout)
    implementation(Compose.composeRuntime)
    implementation(Compose.composeUIPreview)
    implementation(Compose.composeUi)
    implementation(Compose.composeLivecycle)
    implementation(Compose.composeUiTooling)
    kapt(Dagger.daggerCompiler)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.androidJUnit)
    androidTestImplementation(Test.espressoCore)
}