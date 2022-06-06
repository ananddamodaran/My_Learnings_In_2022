import dev.damodaran.app.build.configs.Versions
<<<<<<< HEAD
import dev.damodaran.app.build.dependencies.Dependencies
import java.util.Properties
=======
import dev.damodaran.app.build.dependencies.deps
>>>>>>> 8caba909bd7826e228944f6fc8675507e5a18033
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
}
android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "dev.damodaran.android_playground"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    signingConfigs {
        create("debugg") {
            val properties = Properties().apply {
                load(File("signing.properties").reader())
            }
            storeFile = File(properties.getProperty("storeFilePath"))
            storePassword = properties.getProperty("storePassword")
            keyPassword = properties.getProperty("keyPassword")
            keyAlias = properties.getProperty("keyAlias")
        }
        /*create("release") {
            val properties = Properties().apply {
                load(File("signing.properties").reader())
            }
            storeFile = file(System.getenv("KEYSTORE_FILE_PATH"))
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }*/
    }
    buildTypes {
       /* getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }*/
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debugg")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion  = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(deps.androidx.corektx)
    implementation (deps.androidx.appcompat)
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.compose.ui:ui:${Versions.COMPOSE}")
    implementation ("androidx.compose.material:material:${Versions.COMPOSE}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${Versions.COMPOSE}")

    implementation(platform("com.google.firebase:firebase-bom:29.1.0"))
    implementation ("com.google.firebase:firebase-analytics-ktx")
}