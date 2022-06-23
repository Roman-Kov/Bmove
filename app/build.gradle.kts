plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    compileSdk = Config.compileSdk
    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.repository))
    implementation(project(Modules.Features.stationDetailScreen))
    implementation(project(Modules.Features.stationsScreen))

    implementation(Kotlin.core)
    implementation(Design.appcompat)
    implementation(Design.material)
    implementation(Design.constraintlayout)
    implementation(Dagger.dagger)
    kapt(Dagger.daggerCompiler)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.androidJUnit)
    androidTestImplementation(Test.espressoCore)
}