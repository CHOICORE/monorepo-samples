package me.choicore.samples.gradle.plugin

import me.choicore.samples.gradle.getVersion

plugins {
    id("me.choicore.samples.gradle.plugin.base.spring-data-jpa-with-querydsl")
}

dependencies {
    annotationProcessor("io.github.openfeign.querydsl:querydsl-apt:${project.getVersion("querydsl")}:jpa")
}

tasks.clean {
    delete("src/main/generated")
}
