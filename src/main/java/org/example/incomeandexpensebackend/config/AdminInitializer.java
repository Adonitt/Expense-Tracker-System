package org.example.incomeandexpensebackend.config;

import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.entities.UserEntity;
import org.example.incomeandexpensebackend.enums.RoleEnum;
import org.example.incomeandexpensebackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        boolean adminExists = userRepository.existsByRole(RoleEnum.ADMIN);

        if (!adminExists) {
            UserEntity admin = new UserEntity();
            admin.setFirstName("System");
            admin.setLastName("Admin");
            admin.setEmail("adonit@admin.com");
            admin.setPassword(passwordEncoder.encode("Password1."));
            admin.setRole(RoleEnum.ADMIN);

            userRepository.save(admin);

            System.out.println("🚀 Default ADMIN created: adonit@admin.com / Password1.");
        } else {
            System.out.println("✔ ADMIN already exists");
        }
    }
}
