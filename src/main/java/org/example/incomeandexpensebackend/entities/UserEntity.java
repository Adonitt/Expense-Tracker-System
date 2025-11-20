package org.example.incomeandexpensebackend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.incomeandexpensebackend.enums.RoleEnum;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "isActive")
    private boolean isActive = true;
}
