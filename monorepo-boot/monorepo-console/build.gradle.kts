plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
    id("me.choicore.samples.gradle.plugin.docker.conventions")
}

group = "me.choicore.samples"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":monorepo-data:persistence:jpa"))
    implementation(project(":monorepo-data:cache:redis"))
}
