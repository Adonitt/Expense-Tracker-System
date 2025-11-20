package org.example.incomeandexpensebackend.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
