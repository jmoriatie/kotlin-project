import org.gradle.api.tasks.testing.logging.TestLogEvent.*

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events(PASSED, FAILED, STANDARD_ERROR, SKIPPED)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

val KOTEST_VERSION = "5.3.0"

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")

    kotlin("plugin.allopen") version "1.3.71"
    kotlin("plugin.noarg") version "1.3.71"
}

allOpen {
    annotation("javax.persistence.Entity")
}

noArg {
    annotation("javax.persistence.Entity")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.github.consoleau:kassava:2.1.0")

    // Kotest
    testImplementation("io.kotest:kotest-runner-junit5:${KOTEST_VERSION}")
    testImplementation("io.kotest:kotest-assertions-core:${KOTEST_VERSION}")

    // mockk
    testImplementation("io.mockk:mockk:1.9.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test"){
        exclude(module = "mockito-core")
    }

    // springMockk
    testImplementation("com.ninja-squad:springmockk:3.1.1")

    testRuntimeOnly("com.h2database:h2")
}
