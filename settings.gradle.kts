rootProject.name = "monorepo"

pluginManagement {
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(":monorepo-boot:monorepo-batch")
include(":monorepo-boot:monorepo-console")
include(":monorepo-common")
include(":monorepo-core")
include(":monorepo-test:context")
include(":monorepo-test:container")
include(":monorepo-data:persistence:common")
include(":monorepo-data:persistence:exposed")
include(":monorepo-data:persistence:jpa")
include(":monorepo-data:persistence:mybatis")
include(":monorepo-data:cache:redis")
