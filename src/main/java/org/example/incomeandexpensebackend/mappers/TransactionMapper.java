package org.example.incomeandexpensebackend.mappers;

import org.example.incomeandexpensebackend.dtos.transaction.CreateTransactionDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionListingDto;
import org.example.incomeandexpensebackend.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {


    TransactionEntity toEntity(CreateTransactionDto dto);

    CreateTransactionDto toDto(TransactionEntity entity);

    List<TransactionEntity> toTransactionEntityList(List<TransactionListingDto> transactionListingDtos);

    List<TransactionListingDto> toTransactionListingDtoList(List<TransactionEntity> transactionEntities);
}
