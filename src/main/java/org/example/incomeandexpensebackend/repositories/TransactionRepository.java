package org.example.incomeandexpensebackend.repositories;

import org.example.incomeandexpensebackend.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<TransactionEntity> findByDebtId(Long debtId);
    void deleteByDebtId(Long debtId);

}
