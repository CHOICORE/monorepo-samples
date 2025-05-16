plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
}

group = "me.choicore.samples"

dependencies {
    testImplementation(testFixtures(project(":monorepo-test:context")))
}
