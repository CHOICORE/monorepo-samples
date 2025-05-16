package me.choicore.samples.monorepo.infrastructure.jpa.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.openfeign.querydsl.jpa.spring.repository.config.EnableQuerydslRepositories;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class JpaConfiguration {
    @EnableQuerydslRepositories(basePackages = "me.choicore.samples.monorepo.infrastructure.jpa")
    @Configuration(proxyBeanMethods = false)
    public static class QueryDslConfiguration {
        @Bean
        public JPAQueryFactory jpaQueryFactory(@Nonnull final EntityManager entityManager) {
            return new JPAQueryFactory(entityManager);
        }
    }
}
