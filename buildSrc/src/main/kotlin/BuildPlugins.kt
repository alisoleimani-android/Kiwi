object BuildPlugins {
    object GradleClassPath {
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersions.kotlinVersion}"
        const val androidGradlePlugin =
            "com.android.tools.build:gradle:${DependencyVersions.androidGradleVersion}"
        const val hiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${DependencyVersions.hiltAndroidVersion}"
    }


    object Apply {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val javaLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlin = "kotlin"
        const val daggerHiltPlugin = "dagger.hilt.android.plugin"
    }
}