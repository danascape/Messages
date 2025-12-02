import org.jetbrains.kotlin.gradle.plugin.KaptExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
        maven {
            name = "glide-snapshot"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.2")
        classpath("com.google.gms:google-services:4.3.14")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("io.realm:realm-gradle-plugin:10.15.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
        maven {
            name = "glide-snapshot"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
        mavenCentral()
    }
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
