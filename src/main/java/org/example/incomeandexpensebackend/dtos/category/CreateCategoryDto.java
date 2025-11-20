package org.example.backend.dtos.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.entities.TransactionEntity;
import org.example.backend.entities.UserEntity;
import org.example.backend.enums.TransactionTypeEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {
    private Long id;

    private String name;

    private Long userId;

    private TransactionTypeEnum type;

    private List<Long> transactionIds;

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();
}
