plugins {
    kotlin("jvm") version "1.9.22"
    id("java")
    id("groovy")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "sample.htmx.javalin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "sample.htmx.AppKt"
}

dependencies {
    implementation("io.javalin:javalin:6.0.1")
    implementation("org.slf4j:slf4j-simple:2.0.10")
    implementation("io.javalin:javalin-rendering:6.0.1")
    implementation("org.apache.velocity:velocity-engine-core:2.3")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.44.1")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
    implementation("org.webjars.npm:htmx.org:2.0.0-alpha1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
