package me.choicore.samples.monorepo.container;

import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class TestRedisConfiguration {
    @TestConfiguration(proxyBeanMethods = false)
    public static class Redis {
        public static final GenericContainer<?> REDIS_CONTAINER = new GenericContainer<>(DockerImageName.parse("redis:latest"))
                .withExposedPorts(6379);

        @Bean
        @ServiceConnection(name = "redis")
        GenericContainer<?> redisContainer() {
            return REDIS_CONTAINER;
        }

        @Bean
        DynamicPropertyRegistrar redisDynamicPropertyRegistrar(
                @Nonnull final @Qualifier("redisContainer") GenericContainer<?> redisContainer
        ) {
            return registry -> {
                registry.add("spring.data.redis.host", redisContainer::getHost);
                registry.add("spring.data.redis.port", redisContainer::getFirstMappedPort);
            };
        }
    }
}
