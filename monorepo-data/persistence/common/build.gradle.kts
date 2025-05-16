plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
    `java-test-fixtures`
}

group = "me.choicore.samples.persistence"

dependencies {
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    testImplementation(testFixtures(project(":monorepo-test:context")))
    testFixturesApi(testFixtures(project(":monorepo-test:context")))
    testFixturesImplementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    testFixturesImplementation("org.testcontainers:mariadb")
    testFixturesRuntimeOnly("org.mariadb.jdbc:mariadb-java-client")
}
