plugins {
    id("me.choicore.samples.gradle.plugin.spring-boot-for-java.conventions")
}

group = "me.choicore.samples.persistence"

dependencies {
    runtimeOnly(project(":monorepo-data:persistence:common"))
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
}
