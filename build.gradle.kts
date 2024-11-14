plugins {
    id("java")
    id("org.springframework.boot") version "3.3.4"
}

apply(plugin = "io.spring.dependency-management")

group = "app.pictari"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(platform("software.amazon.awssdk:bom:2.29.12"))
    implementation("software.amazon.awssdk:aws-core")
    implementation("software.amazon.awssdk:dynamodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.test {
    useJUnitPlatform()
}