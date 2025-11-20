package org.example.backend.services.implementations;

import org.example.backend.dtos.user.CreateUserDto;
import org.example.backend.dtos.user.UpdateUserDto;
import org.example.backend.dtos.user.UserDetailsDto;
import org.example.backend.dtos.user.UserListingDto;
import org.example.backend.services.interfaces.UserService;
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
