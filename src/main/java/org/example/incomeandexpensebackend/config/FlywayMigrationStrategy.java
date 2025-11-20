package org.example.incomeandexpensebackend.config;

import org.flywaydb.core.Flyway;

@FunctionalInterface
public interface FlywayMigrationStrategy {
    void migrate(Flyway flyway);
}
