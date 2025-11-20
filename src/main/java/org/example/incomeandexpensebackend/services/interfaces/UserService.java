package org.example.incomeandexpensebackend.services.interfaces;


import org.example.incomeandexpensebackend.dtos.user.CreateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UpdateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UserDetailsDto;
import org.example.incomeandexpensebackend.dtos.user.UserListingDto;
import org.example.incomeandexpensebackend.services.base_services.*;

public interface UserService extends Addable<CreateUserDto>,
        Modifiable<UpdateUserDto, Long>,
        FindAll<UserListingDto>,
        FindById<UserDetailsDto,
                Long>, Removable<Long> {
}