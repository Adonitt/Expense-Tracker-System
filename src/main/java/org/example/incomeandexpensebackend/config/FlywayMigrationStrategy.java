package org.example.backend.config;

import org.flywaydb.core.Flyway;

@FunctionalInterface
public interface FlywayMigrationStrategy {
    void migrate(Flyway flyway);
}
