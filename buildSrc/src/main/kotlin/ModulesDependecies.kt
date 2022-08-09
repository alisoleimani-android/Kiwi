object AppModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coreKtx,
        AllDependencies.appcompat,
        AllDependencies.material,
        AllDependencies.hiltCompiler,
        AllDependencies.hiltAndroid,
        AllDependencies.hiltAndroidCompiler,
        AllDependencies.navigationFragment,
        AllDependencies.navigationUi,
    )
}

object UiResourceModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.material,
    )
}

object FeatureDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.coroutinesCore,
        AllDependencies.coroutinesAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.hiltAndroid,
        AllDependencies.hiltAndroidCompiler,
        AllDependencies.fragmentKtx,
        AllDependencies.navigationUi,
        AllDependencies.viewModel,
        AllDependencies.navigationFragment,
    )

}

object CoreModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.coroutinesAndroid,
        AllDependencies.coroutinesCore,
        AllDependencies.timber,
        AllDependencies.lifecycleRuntime,
    )

}

object DataModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.retrofit,
        AllDependencies.retrofitConverter,
        AllDependencies.okhttp,
        AllDependencies.okhttpLoggingInterceptor,
        AllDependencies.moshi,
        AllDependencies.moshiCodeGenerator,
        AllDependencies.roomRuntime,
        AllDependencies.roomKtx,
        AllDependencies.roomCompiler,
        AllDependencies.coroutinesCore,
    )

}

object DomainModuleDependencies : Dependencies {

    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.hiltAndroid,
        AllDependencies.hiltCompiler,
        AllDependencies.coroutinesAndroid,
        AllDependencies.coroutinesCore,
        AllDependencies.kotlinxDatetime,
    )

}

object UiCommonModuleDependencies : Dependencies {
    override fun getDependencies(): List<Dependency> = listOf(
        AllDependencies.material,
        AllDependencies.glide,
    )
}
