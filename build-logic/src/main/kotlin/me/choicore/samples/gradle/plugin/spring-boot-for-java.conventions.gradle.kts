package me.choicore.samples.gradle.plugin

plugins {
    id("me.choicore.samples.gradle.plugin.base.spring-boot")
}

configurations {
    runtimeClasspath {
        extendsFrom(configurations.developmentOnly.get())
    }
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}
