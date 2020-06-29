plugins {
    kotlin("jvm") version "1.3.72"
}

group = "uk.ryxn.discordkt"
version = "1.0-SNAPSHOT"

val ktorVersion = "1.3.2"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
    implementation("com.google.code.gson:gson:2.8.6")
}
