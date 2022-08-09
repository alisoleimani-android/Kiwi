plugins {
    id(BuildPlugins.Apply.androidApplication)
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
        applicationId = ConfigData.appID
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {

        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            isMinifyEnabled = true
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

        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    hilt {
        enableAggregatingTask = true
    }

    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.UI_COMMON))
    implementation(project(BuildModules.UI_RESOURCE))
    implementation(project(BuildModules.DATA))
    implementation(project(BuildModules.DOMAIN))
    implementation(project(BuildModules.HOME))
    addDependencies(AppModuleDependencies.getDependencies())
}
