plugins {
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

group = "io.isr"
version = "0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "Hoxton.RC2"

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.29")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-zuul")
    testCompile("junit", "junit", "4.12")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}