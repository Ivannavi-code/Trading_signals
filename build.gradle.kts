plugins {
    kotlin("jvm") version "1.9.0" apply false
    id("com.android.application") version "8.2.0" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}