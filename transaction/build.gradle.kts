import io.isr.gradle.swaggerSpringGen

plugins {
    java
}

group = "io.isr"
version = "0.1"

repositories {
    mavenCentral()
}


swaggerSpringGen("transaction", file("api/transaction-engine-swagger.yaml"))

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}