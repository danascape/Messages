import org.jetbrains.kotlin.gradle.plugin.KaptExtension

// Needed until we upstream
buildscript {
    dependencies {
        classpath("io.realm:realm-gradle-plugin:10.15.0")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.2")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.google.services) apply false
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
