package org.example.backend.dtos.transaction;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.enums.TransactionTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTransactionDto {
    private Long id;

    private Long userId;

    private Long categoryId;

    @NotNull(message = "Amount is required")
    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private double amount;

    private TransactionTypeEnum type;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 characters")
    private String description;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Date must be in the past or present")
    private LocalDate date;

    private LocalDateTime createdAt = LocalDateTime.now();
}
