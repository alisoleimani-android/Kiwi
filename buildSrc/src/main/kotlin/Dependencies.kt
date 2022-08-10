interface Dependencies {
    fun getDependencies(): List<Dependency>
}

internal object AllDependencies {

    // region Core
    val coreKtx = Dependency(
        dependency = "androidx.core:core-ktx",
        dependencyVersion = DependencyVersions.coreKtxVersion,
        dependencyType = DependencyType.IMPLEMENTATION,
    )
    // endregion Core

    // region UI
    val appcompat = Dependency(
        dependency = "androidx.appcompat:appcompat",
        dependencyVersion = DependencyVersions.appcompatVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val material = Dependency(
        dependency = "com.google.android.material:material",
        dependencyVersion = DependencyVersions.materialVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val constraintLayout = Dependency(
        dependency = "androidx.constraintlayout:constraintlayout",
        dependencyVersion = DependencyVersions.constraintLayoutVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    // endregion UI

    // region Reactive Streams & Parallelization
    val coroutinesAndroid = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-android",
        dependencyVersion = DependencyVersions.coroutinesAndroidVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val coroutinesCore = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-core",
        dependencyVersion = DependencyVersions.coroutinesCoreVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    // endregion Reactive Streams & Parallelization

    // region Dependency Injection
    val hiltAndroid = Dependency(
        dependency = "com.google.dagger:hilt-android",
        dependencyVersion = DependencyVersions.hiltAndroidVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val hiltCompiler = Dependency(
        dependency = "com.google.dagger:hilt-compiler",
        dependencyVersion = DependencyVersions.hiltAndroidVersion,
        dependencyType = DependencyType.KAPT
    )

    val hiltAndroidCompiler = Dependency(
        dependency = "com.google.dagger:hilt-android-compiler",
        dependencyVersion = DependencyVersions.hiltAndroidVersion,
        dependencyType = DependencyType.KAPT_TEST
    )
    // endregion Dependency Injection

    // region Architecture & Lifecycle
    val viewModel = Dependency(
        dependency = "androidx.lifecycle:lifecycle-viewmodel-ktx",
        dependencyVersion = DependencyVersions.lifecycleVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val lifecycleRuntime = Dependency(
        dependency = "androidx.lifecycle:lifecycle-runtime-ktx",
        dependencyVersion = DependencyVersions.lifecycleVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val fragmentKtx = Dependency(
        dependency = "androidx.fragment:fragment-ktx",
        dependencyVersion = DependencyVersions.fragmentKtx,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    // endregion Architecture & Lifecycle

    // region Navigation
    val navigationFragment = Dependency(
        dependency = "androidx.navigation:navigation-fragment",
        dependencyVersion = DependencyVersions.navigationVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val navigationUi = Dependency(
        dependency = "androidx.navigation:navigation-ui-ktx",
        dependencyVersion = DependencyVersions.navigationVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    // endregion Navigation

    // region Utils
    val kotlinxDatetime = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-datetime",
        dependencyVersion = DependencyVersions.kotlinxDatetimeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val timber = Dependency(
        dependency = "com.jakewharton.timber:timber",
        dependencyVersion = DependencyVersions.timberVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val glide = Dependency(
        dependency = "com.github.bumptech.glide:glide",
        dependencyVersion = DependencyVersions.glideVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )
    // endregion Utils

    // region Networking
    val retrofit = Dependency(
        dependency = "com.squareup.retrofit2:retrofit",
        dependencyVersion = DependencyVersions.retrofitVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val retrofitConverter = Dependency(
        dependency = "com.squareup.retrofit2:converter-moshi",
        dependencyVersion = DependencyVersions.retrofitVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val okhttp = Dependency(
        dependency = "com.squareup.okhttp3:okhttp",
        dependencyVersion = DependencyVersions.okhttpVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val okhttpLoggingInterceptor = Dependency(
        dependency = "com.squareup.okhttp3:logging-interceptor",
        dependencyVersion = DependencyVersions.okhttpVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val moshi = Dependency(
        dependency = "com.squareup.moshi:moshi-kotlin",
        dependencyVersion = DependencyVersions.moshiVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val moshiCodeGenerator = Dependency(
        dependency = "com.squareup.moshi:moshi-kotlin-codegen",
        dependencyVersion = DependencyVersions.moshiVersion,
        dependencyType = DependencyType.KAPT
    )
    // endregion Networking

    // region Caching
    val roomRuntime = Dependency(
        dependency = "androidx.room:room-runtime",
        dependencyVersion = DependencyVersions.roomVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val roomKtx = Dependency(
        dependency = "androidx.room:room-ktx",
        dependencyVersion = DependencyVersions.roomVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val roomCompiler = Dependency(
        dependency = "androidx.room:room-compiler",
        dependencyVersion = DependencyVersions.roomVersion,
        dependencyType = DependencyType.KAPT
    )
    // endregion Caching

    // region Test dependencies
    val junitTest = Dependency(
        dependency = "junit:junit",
        dependencyVersion = DependencyVersions.junitVersion,
        dependencyType = DependencyType.TEST_IMPL
    )

    val junitImpl = Dependency(
        dependency = "junit:junit",
        dependencyVersion = DependencyVersions.junitVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val mockkAndroid = Dependency(
        dependency = "io.mockk:mockk-android",
        dependencyVersion = DependencyVersions.mockkVersion,
        dependencyType = DependencyType.TEST_IMPL
    )

    val mockk = Dependency(
        dependency = "io.mockk:mockk",
        dependencyVersion = DependencyVersions.mockkVersion,
        dependencyType = DependencyType.TEST_IMPL
    )

    val coroutinesTest = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-test",
        dependencyVersion = DependencyVersions.coroutinesTestVersion,
        dependencyType = DependencyType.TEST_IMPL
    )

    val coroutinesTestImpl = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-coroutines-test",
        dependencyVersion = DependencyVersions.coroutinesTestVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val truth = Dependency(
        dependency = "com.google.truth:truth",
        dependencyVersion = DependencyVersions.truthVersion,
        dependencyType = DependencyType.TEST_IMPL
    )

    val turbine = Dependency(
        dependency = "app.cash.turbine:turbine",
        dependencyVersion = DependencyVersions.turbineVersion,
        dependencyType = DependencyType.TEST_IMPL
    )
    // endregion Test dependencies

}


