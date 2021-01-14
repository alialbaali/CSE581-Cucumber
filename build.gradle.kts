import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    application
}

group = "com.alialbaali.cucumber"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.cucumber:cucumber-java8:6.8.1")
    testImplementation("io.cucumber:cucumber-junit:6.8.1")
    testImplementation("junit:junit:4.12")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "MainKt"
}