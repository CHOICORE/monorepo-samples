package me.choicore.samples.monorepo.test.container.exposed.autoconfigure

import me.choicore.samples.monorepo.test.container.exposed.ExposedTestConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(ExposedTestConfiguration::class)
annotation class EnableExposedTesting
