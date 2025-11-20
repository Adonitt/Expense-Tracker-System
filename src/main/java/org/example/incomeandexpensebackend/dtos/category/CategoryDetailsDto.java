package org.example.incomeandexpensebackend.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.incomeandexpensebackend.enums.TransactionTypeEnum;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailsDto {
    private Long id;

    private String name;

    private TransactionTypeEnum type;

    private List<Long> transactionIds;

    private String description;

}
