plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-kotlin.conventions")
    id("me.choicore.samples.gradle.plugin.docker.conventions")
}

group = "me.choicore.samples"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation(project(":monorepo-core"))
    implementation(project(":monorepo-common"))
    implementation(project(":monorepo-data:persistence:exposed"))
    testImplementation(testFixtures(project(":monorepo-data:persistence:exposed")))
}
