plugins {
    `kotlin-dsl`
}



repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    /* Depend on the kotlin plugin, since we want to access it in our plugin */
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")

    compile("gradle.plugin.org.hidetake:gradle-swagger-generator-plugin:2.18.1")
    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())
}