buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.GradleClassPath.androidGradlePlugin)
        classpath(BuildPlugins.GradleClassPath.kotlinGradlePlugin)
        classpath(BuildPlugins.GradleClassPath.hiltGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}