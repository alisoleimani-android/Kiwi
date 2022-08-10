plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = ConfigData.jvmTarget
    targetCompatibility = ConfigData.jvmTarget
}

dependencies {
    addDependencies(TestCommonModuleDependencies.getDependencies())
}