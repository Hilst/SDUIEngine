plugins {
    kotlin("multiplatform") version "1.9.0"
}

group = "hilst.sdui.engine"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
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
