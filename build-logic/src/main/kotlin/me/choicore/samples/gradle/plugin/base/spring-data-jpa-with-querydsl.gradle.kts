package me.choicore.samples.gradle.plugin.base

import me.choicore.samples.gradle.getVersion

plugins {
    java
    `java-library`
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("io.github.openfeign.querydsl:querydsl-jpa-spring:${project.getVersion("querydsl")}")
}
