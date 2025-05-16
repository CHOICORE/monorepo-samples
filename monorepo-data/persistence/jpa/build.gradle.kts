plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
    id("me.choicore.samples.gradle.plugin.jpa-for-java.conventions")
}

group = "me.choicore.samples.persistence"

dependencies {
    implementation(project(":monorepo-data:persistence:common"))
}
