package org.example.backend.services.interfaces;

import org.example.backend.dtos.user.CreateUserDto;
import org.example.backend.dtos.user.UpdateUserDto;
import org.example.backend.dtos.user.UserDetailsDto;
import org.example.backend.dtos.user.UserListingDto;
import org.example.backend.services.base_services.*;

public interface UserService extends Addable<CreateUserDto>,
        Modifiable<UpdateUserDto, Long>,
        FindAll<UserListingDto>,
        FindById<UserDetailsDto,
        Long>, Removable<Long> {
}