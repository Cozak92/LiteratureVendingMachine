import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("org.springframework.boot") version "2.6.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id ("org.jetbrains.kotlin.plugin.allopen") version "1.6.20"
    id ("org.jetbrains.kotlin.plugin.noarg") version "1.6.20"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("kapt") version "1.4.10"
    idea
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.6.10"))
    }
}

idea {
    module {
        // Not using += due to https://github.com/gradle/gradle/issues/8749
        sourceDirs = sourceDirs + file("build/generated/ksp/main/kotlin") // or tasks["kspKotlin"].destination
        testSourceDirs = testSourceDirs + file("build/generated/ksp/test/kotlin")
        generatedSourceDirs = generatedSourceDirs + file("build/generated/ksp/main/kotlin") + file("build/generated/ksp/test/kotlin")
    }
}

group = "com.Cozak"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
val qeurydslVersion = "4.2.2"
val postgresDriverVersion = "42.3.3"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // QueryDSL
    implementation("com.querydsl:querydsl-jpa:$qeurydslVersion")
    implementation("com.querydsl:querydsl-core:$qeurydslVersion")
    implementation("com.querydsl:querydsl-codegen:5.0.0")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")

    implementation("org.postgresql:postgresql:${postgresDriverVersion}")
    platform("com.google.cloud:spring-cloud-gcp-dependencies:3.3.0-SNAPSHOT")
    implementation("jakarta.persistence:jakarta.persistence-api")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.6.20-1.0.5")
    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.12.3")
    testImplementation("io.kotest:kotest-runner-junit5:5.2.2")
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.2.2")
    testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

val querydslDir = "$buildDir/generated/querydsl"


tasks.withType<Test>().configureEach  {
    useJUnitPlatform()
}
