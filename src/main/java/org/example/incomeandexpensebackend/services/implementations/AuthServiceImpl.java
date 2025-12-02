package org.example.incomeandexpensebackend.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.auth.AuthResponseDto;
import org.example.incomeandexpensebackend.dtos.auth.LoginDto;
import org.example.incomeandexpensebackend.entities.UserEntity;
import org.example.incomeandexpensebackend.exceptions.UnauthorizedException;
import org.example.incomeandexpensebackend.repositories.UserRepository;
import org.example.incomeandexpensebackend.security.JWTUtil;
import org.example.incomeandexpensebackend.services.interfaces.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest httpServletRequest;


    @Override
    public AuthResponseDto login(LoginDto dto) {
        UserEntity user = userRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new UnauthorizedException("Invalid email or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getFirstName(), user.getLastName());

        return new AuthResponseDto(token, user.getId(), user.getEmail(), user.getFirstName());
    }

    @Override
    public UserEntity validateToken(String token) {
        String email = jwtUtil.validateTokenAndGetEmail(token);
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public String getLoggedInUserEmail() {
        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);

        return jwtUtil.validateTokenAndGetEmail(token);
    }

}
