plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-kotlin.conventions")
    `java-test-fixtures`
}

group = "me.choicore.samples.persistence"

val exposedVersion = libs.versions.exposed.get()

dependencies {
    implementation(project(":monorepo-data:persistence:common"))
    api("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    api("org.jetbrains.exposed:exposed-json:$exposedVersion")
    api("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
    testFixturesApi(testFixtures(project(":monorepo-data:persistence:common")))
    testImplementation(kotlin("test"))
}
