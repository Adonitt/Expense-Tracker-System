package org.example.incomeandexpensebackend.repositories;

import org.example.incomeandexpensebackend.entities.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository<DebtEntity, Long> {
}
