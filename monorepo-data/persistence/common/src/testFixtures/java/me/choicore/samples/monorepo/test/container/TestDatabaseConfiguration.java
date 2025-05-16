package me.choicore.samples.monorepo.test.container;

import jakarta.annotation.Nonnull;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestDatabaseConfiguration {
    static final MariaDBContainer<?> MARIA_DB_CONTAINER = new MariaDBContainer<>(DockerImageName.parse("mariadb:lts"));

    @Bean
    @ServiceConnection
    MariaDBContainer<?> mariaDbContainer() {
        return MARIA_DB_CONTAINER;
    }

    @Bean
    DynamicPropertyRegistrar mariaDbDynamicPropertyRegistrar(
            @Nonnull final MariaDBContainer<?> mariaDbContainer
    ) {
        return registry -> {
            registry.add("spring.datasource.driver-class-name", mariaDbContainer::getDriverClassName);
            registry.add("spring.datasource.url", mariaDbContainer::getJdbcUrl);
            registry.add("spring.datasource.username", mariaDbContainer::getUsername);
            registry.add("spring.datasource.password", mariaDbContainer::getPassword);
        };
    }

}
