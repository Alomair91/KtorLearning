val ktor_version:String by project
val kotlin_version:String by project
val logback_version:String by project

plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.serialization") version "1.8.21"
    application
}

group = "com.omairtech"
version = "0.0.1"

application {
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")

    //mainClass.set("MainKt")
    //mainClass.set("io.ktor.server.netty.EngineMain") // KotlinEngine
    mainClass.set("com.omairtech.ApplicationKt") // do server setting manually
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version") // server engine
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-html-builder:$ktor_version")


    implementation("ch.qos.logback:logback-classic:$logback_version") // allow us to see some logs from server


    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}