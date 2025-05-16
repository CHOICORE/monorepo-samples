package me.choicore.samples.monorepo.infrastructure.jpa;

import me.choicore.samples.monorepo.infrastructure.jpa.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
