plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.kotlinKapt)
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = ConfigData.jvmTarget
        targetCompatibility = ConfigData.jvmTarget
    }

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget.toString()
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.DOMAIN))
    implementation(project(BuildModules.UI_COMMON))
    implementation(project(BuildModules.UI_RESOURCE))
    testImplementation(project(BuildModules.TEST_COMMON))
    addDependencies(FeatureDependencies.getDependencies())
}