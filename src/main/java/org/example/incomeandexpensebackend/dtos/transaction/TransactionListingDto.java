package org.example.backend.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.entities.UserEntity;
import org.example.backend.enums.TransactionTypeEnum;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionListingDto {
    private Long id;

    private Long userId;

    private double amount;

    private TransactionTypeEnum type;

    private LocalDate date;
}
