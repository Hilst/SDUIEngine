import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "1.9.10"
}

group = "hilst.sdui.engine"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
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

    js(IR) {
        moduleName = "kmm-sdui"
        nodejs()
        generateTypeScriptDefinitions()
        binaries.library()
    }

    sourceSets {

        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)
        }
        val jsTest by getting {
            dependsOn(commonTest)
        }
    }
}
