package me.choicore.samples.gradle

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

fun Project.getVersion(name: String): String {
    val catalogs =
        extensions.findByType(VersionCatalogsExtension::class.java)
            ?: throw IllegalStateException("VersionCatalogsExtension not found")

    val libs = catalogs.find("libs").orElseThrow()
    return libs.findVersion(name).orElseThrow().toString()
}

fun Project.getLibrary(name: String): String {
    val catalogs =
        extensions.findByType(VersionCatalogsExtension::class.java)
            ?: throw IllegalStateException("VersionCatalogsExtension not found")

    val libs = catalogs.find("libs").orElseThrow()
    return libs
        .findLibrary(name)
        .orElseThrow()
        .get()
        .toString()
}
