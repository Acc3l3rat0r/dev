package io.isr.gradle

import org.gradle.api.Project
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.*
import org.hidetake.gradle.swagger.generator.GenerateSwaggerCode
import java.io.File


fun Project.swaggerSpringGen(name: String, config: File) {

    project.pluginManager.apply("org.hidetake.swagger.generator")

    repositories {
        jcenter()
    }

    dependencies {
        "swaggerCodegen"("org.openapitools:openapi-generator-cli:3.3.4")
        "swaggerUI"("org.webjars:swagger-ui:3.10.0")
    }

    val configure: org.gradle.api.NamedDomainObjectContainer<org.hidetake.gradle.swagger.generator.SwaggerSource>.() -> Unit = {
        register(name) {
            setInputFile(config)
            code(delegateClosureOf<GenerateSwaggerCode> {
                language = "spring"
                components = listOf("models", "apis")
            })
        }
    }

    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("swaggerSources", configure)

    val swaggerSources = (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("swaggerSources") as org.gradle.api.NamedDomainObjectContainer<org.hidetake.gradle.swagger.generator.SwaggerSource>


    tasks.named("compileJava").configure {
        dependsOn(tasks.named("generateSwaggerCode"))
        dependsOn(tasks.named("generateSwaggerUI"))
    }

    project.extensions.configure(SourceSetContainer::class.java) {
        val main by getting
        val source = swaggerSources.getByName(name)
        main.java.srcDir("${source.code.outputDir}/src/main/java")
    }

}