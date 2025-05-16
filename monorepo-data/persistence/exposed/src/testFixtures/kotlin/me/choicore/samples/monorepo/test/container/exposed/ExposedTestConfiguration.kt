package me.choicore.samples.monorepo.test.container.exposed

import jakarta.annotation.Nonnull
import org.jetbrains.exposed.spring.DatabaseInitializer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@TestConfiguration(proxyBeanMethods = false)
class ExposedTestConfiguration {
    @Bean
    fun databaseInitializer(
        @Nonnull applicationContext: ApplicationContext,
    ): DatabaseInitializer = DatabaseInitializer(applicationContext, emptyList())
}
