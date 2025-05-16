plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
    `java-test-fixtures`
}

group = "me.choicore.samples"

dependencies {
    testFixturesApi("org.springframework.boot:spring-boot-starter-test")
    testFixturesApi("org.springframework.boot:spring-boot-testcontainers")
    testFixturesApi("org.testcontainers:junit-jupiter")
    testFixturesRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
