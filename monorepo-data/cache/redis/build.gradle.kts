plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
    `java-test-fixtures`
}

group = "me.choicore.samples.persistence"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation(testFixtures(project(":monorepo-test:context")))
    testFixturesApi(testFixtures(project(":monorepo-test:context")))
    testFixturesApi("org.springframework.boot:spring-boot-starter-test")
    testFixturesApi("org.springframework.boot:spring-boot-testcontainers")
}
