package me.choicore.samples.gradle.plugin

plugins {
    id("me.choicore.samples.gradle.plugin.base.spring-boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}
