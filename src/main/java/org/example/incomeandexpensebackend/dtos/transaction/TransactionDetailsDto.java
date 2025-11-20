package org.example.backend.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.enums.TransactionTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailsDto {
    private Long id;

    private Long userId;

    private Long categoryId;

    private double amount;

    private TransactionTypeEnum type;

    private String description;

    private LocalDate date;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
