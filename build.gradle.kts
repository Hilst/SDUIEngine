import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "2.0.0"
    id("com.android.library") version "8.0.0"
}

group = "hilst.sdui.engine"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    mavenLocal()
}

android {
    namespace = group.toString()
    compileSdkVersion = "android-31"
    defaultConfig {
        minSdk = 30
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
}

kotlin {
    // IOS TARGET
    val xcf = XCFramework()
    val iosTarget = listOf(iosX64(), iosArm64(), iosSimulatorArm64())

    iosTarget.forEach {
        it.binaries.framework {
            baseName = rootProject.name

            binaryOption("bundleId", "hilst.${rootProject.name}")
            xcf.add(this)
            isStatic = true
        }
    }

    // ANDROID TARGET
    androidTarget() {
        publishLibraryVariants("release", "debug")
    }

    // NODEJS TARGET
    js(IR) {
        moduleName = "kmm-sdui"
        nodejs()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jsMain by getting {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
    }
}
