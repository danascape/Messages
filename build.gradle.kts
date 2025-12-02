import org.jetbrains.kotlin.gradle.plugin.KaptExtension

// Needed until we upstream
buildscript {
    dependencies {
        classpath("io.realm:realm-gradle-plugin:10.15.0")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.2")
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("com.android.library") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.21" apply false
    id("com.google.gms.google-services") version "4.3.14" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

subprojects {
    afterEvaluate {
        extensions.findByType(KaptExtension::class.java)?.apply {
            javacOptions {
                option("-source", "8")
                option("-target", "8")
            }
        }
    }
}
