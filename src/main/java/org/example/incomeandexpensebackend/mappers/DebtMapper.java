package org.example.incomeandexpensebackend.mappers;

import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.entities.DebtEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DebtMapper {

    DebtEntity toEntity(DebtDto dto);

    @Mapping(
            target = "transactionId",
            expression = "java(entity.getTransaction() != null ? entity.getTransaction().getId() : null)"
    )
    DebtDto toDto(DebtEntity entity);

    List<DebtDto> toDtoList(List<DebtEntity> entities);
}

