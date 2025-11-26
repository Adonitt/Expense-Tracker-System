package org.example.incomeandexpensebackend.repositories;

import org.example.incomeandexpensebackend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Object findByEmail(String email);
}
