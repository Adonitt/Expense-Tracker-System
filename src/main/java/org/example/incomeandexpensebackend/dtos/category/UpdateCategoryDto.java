package org.example.incomeandexpensebackend.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.incomeandexpensebackend.enums.TransactionTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {
    private Long id;

    private String name;

    private TransactionTypeEnum type;

    private List<Long> transactionIds;

    private String description;

}
