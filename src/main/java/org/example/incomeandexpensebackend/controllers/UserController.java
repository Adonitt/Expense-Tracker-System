package org.example.incomeandexpensebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.user.CreateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UpdateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UserDetailsDto;
import org.example.incomeandexpensebackend.dtos.user.UserListingDto;
import org.example.incomeandexpensebackend.services.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserListingDto>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UpdateUserDto> update(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(service.update(id, updateUserDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Long id) {
        service.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
