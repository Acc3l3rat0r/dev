plugins {
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}
apply(plugin = "io.spring.dependency-management")

group = "io.isr"
version = "0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    extra["springCloudVersion"] = "Hoxton.RC2"
}


dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:2.1.3.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.10.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.10.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.0")
    implementation("io.swagger.core.v3:swagger-annotations:2.0.0")
    implementation("io.swagger.core.v3:swagger-core:2.0.0")
    implementation("io.swagger.core.v3:swagger-models:2.0.0")
    implementation("io.swagger.core.v3:swagger-jaxrs2:2.0.0")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
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