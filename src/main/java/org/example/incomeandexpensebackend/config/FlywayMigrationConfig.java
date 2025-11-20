package org.example.incomeandexpensebackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayMigrationConfig {

    @Bean
    FlywayMigrationStrategy repairFlyway() {
        return flyway -> {
            flyway.migrate();
            flyway.repair();
        };
    }

}
