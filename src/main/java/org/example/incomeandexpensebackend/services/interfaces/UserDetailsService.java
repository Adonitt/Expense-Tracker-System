package org.example.incomeandexpensebackend.services.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    public UserDetails loadUserByUsername(String email);
}
