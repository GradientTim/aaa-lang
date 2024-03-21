plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    application
}

group = "dev.gradienttim"
version = "0.1.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("dev.gradienttim.aaa.AAALangKt")
}

kotlin {
    jvmToolchain(17)
}