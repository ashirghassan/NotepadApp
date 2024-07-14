plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false

    id("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
        classpath("com.google.gms:google-services:4.3.15")

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")

    }
}


