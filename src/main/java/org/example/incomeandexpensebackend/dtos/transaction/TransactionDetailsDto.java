package org.example.incomeandexpensebackend.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.incomeandexpensebackend.enums.CategoryEnum;
import org.example.incomeandexpensebackend.enums.TransactionTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailsDto {
    private Long id;

    private CategoryEnum category;

    private Long debtId;

    private double amount;

    private Long userId;

    private String userFullName;

    private TransactionTypeEnum type;

    private String description;

    private LocalDate date;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
