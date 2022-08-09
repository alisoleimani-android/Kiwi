interface Dependencies {
    fun getDependencies(): List<Dependency>
}

internal object AllDependencies {
    val coreKtx = Dependency(
        dependency = "androidx.core:core-ktx",
        dependencyVersion = DependencyVersions.coreKtxVersion,
        dependencyType = DependencyType.IMPLEMENTATION,
    )

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

    val glide = Dependency(
        dependency = "com.github.bumptech.glide:glide",
        dependencyVersion = DependencyVersions.glideVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

    val kotlinxDatetime = Dependency(
        dependency = "org.jetbrains.kotlinx:kotlinx-datetime",
        dependencyVersion = DependencyVersions.kotlinxDatetimeVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

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

    val timber = Dependency(
        dependency = "com.jakewharton.timber:timber",
        dependencyVersion = DependencyVersions.timberVersion,
        dependencyType = DependencyType.IMPLEMENTATION
    )

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
}


