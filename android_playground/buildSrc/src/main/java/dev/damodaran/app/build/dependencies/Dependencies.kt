package dev.damodaran.app.build.dependencies

import dev.damodaran.app.build.configs.Libs
import dev.damodaran.app.build.configs.Versions
object versions {
    const val appcompat = "1.3.1"
    val activity = "1.3.1"
    val constraintLayout = "2.0.4"
    val core = "1.7.0"
    val coroutines = "1.5.1"
    val espresso = "3.4.0"
    val glide = "4.12.0"
    val junit = "4.13"
    val junitExt = "1.1.1"
    val material = "1.4.0"
    val moshi = "2.4.0"
    val okhttpLoggingInterceptor = "4.9.0"
    val retrofit = "2.9.0"
    val timber = "4.7.1"
    val firebaseBom = "28.3.1"
    val coil = "1.3.2"
    val hilt = Versions.HILT_AGP
    val hiltLifecycleViewmodel = "1.0.0-alpha03"
    val compose = Versions.COMPOSE
    val activityCompose = "1.3.1"
}
object deps {
    object androidx{
        const val appcompat = "${Libs.APPCOMPAT}:${versions.appcompat}"
        const val corektx = "${Libs.CORE_KTX}:${versions.appcompat}"
    }
/*
    api("${Libs.APPCOMPAT}:$appcompat")
    api("${Libs.ACTIVITY_KTX}:$activity")
    api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")

    api("${Libs.COROUTINES}:$coroutines")
    api("${Libs.ESPRESSO_CORE}:$espresso")
    api("${Libs.JUNIT}:$junit")
    api("${Libs.EXT_JUNIT}:$junitExt")
    api("${Libs.GLIDE}:$glide")
    api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")
    api("${Libs.MATERIAL}:$material")
    api("${Libs.MOSHI}:$moshi")
    api("${Libs.RETROFIT}:$retrofit")
    api("${Libs.NAVIGATION_FRAGMENT_KTX}:${Versions.NAVIGATION}")
    api("${Libs.NAVIGATION_UI_KTX}:${Versions.NAVIGATION}")
    api("${Libs.OKHTTP_LOGGING_INTERCEPTOR}:$okhttpLoggingInterceptor")
    api("${Libs.TIMBER}:$timber")
    api("${Libs.FIREBASE_BOM}:$firebaseBom")
    api("${Libs.FIREBASE_ANALYTICS}")
    api("${Libs.FIREBASE_CRASHLYTICS}")

    api("${Libs.COIL}:$coil")

    api("${Libs.HILT_ANDROID}:$hilt")
    api("${Libs.HILT_COMPILER}:$hilt")
    api("${Libs.HILT_LIFECYCLE_VIEWMODEL}:$hiltLifecycleViewmodel")

    api("${Libs.COMPOSE_UI}:$compose")
    api("${Libs.COMPOSE_MATERIAL}:$compose")
    api("${Libs.COMPOSE_UI_TOOLING_PREVIEW}:$compose")
    api("${Libs.COMPOSE_TOOLING}:$compose")
    api("${Libs.COMPOSE_TEST}:$compose")
    api("${Libs.ACTIVITY_COMPOSE}:$activityCompose")*/



}