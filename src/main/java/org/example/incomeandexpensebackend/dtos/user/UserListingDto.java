package org.example.backend.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.enums.RoleEnum;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListingDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private boolean isActive = true;
}
