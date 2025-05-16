package me.choicore.samples.gradle.plugin

plugins {
    id("me.choicore.samples.gradle.plugin.base.spring-boot")
}

dependencies {
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
}
