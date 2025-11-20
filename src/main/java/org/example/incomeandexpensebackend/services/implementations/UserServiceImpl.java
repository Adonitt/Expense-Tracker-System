package org.example.incomeandexpensebackend.services.implementations;

import org.example.incomeandexpensebackend.dtos.user.CreateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UpdateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UserDetailsDto;
import org.example.incomeandexpensebackend.dtos.user.UserListingDto;
import org.example.incomeandexpensebackend.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public CreateUserDto create(CreateUserDto dto) {
        return null;
    }

    @Override
    public List<UserListingDto> findAll() {
        return List.of();
    }

    @Override
    public UserDetailsDto findById(Long id) {
        return null;
    }

    @Override
    public UpdateUserDto update(Long id, UpdateUserDto dto) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
