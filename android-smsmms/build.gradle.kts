/*
 * Copyright (C) 2017 Moez Bhatti <moez.bhatti@gmail.com>
 * Copyright (C) 2025 Saalim Quadri <danascape@gmail.com>
 *
 * This file is part of QKSMS.
 *
 * QKSMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * QKSMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with QKSMS.  If not, see <http://www.gnu.org/licenses/>.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        targetSdk = 33
    }

    useLibrary("org.apache.http.legacy")

    lint {
        abortOnError = false
    }

    namespace = "com.klinker.android.send_message"
}

dependencies {
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.squareup.okhttp:okhttp:2.5.0")
    implementation("com.squareup.okhttp:okhttp-urlconnection:2.5.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.21")
}

repositories {
    google()
    maven(url = "https://jitpack.io")
    maven(url = "https://maven.google.com")
    maven {
        name = "glide-snapshot"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    mavenCentral()
}