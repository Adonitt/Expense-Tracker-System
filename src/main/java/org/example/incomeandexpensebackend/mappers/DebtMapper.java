package org.example.incomeandexpensebackend.mappers;

import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.entities.DebtEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
public interface DebtMapper {
    DebtEntity toEntity(DebtDto dto);

    DebtDto toDto(DebtEntity entity);
}
