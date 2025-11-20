package org.example.backend.mappers;

import org.example.backend.dtos.transaction.CreateTransactionDto;
import org.example.backend.dtos.transaction.TransactionListingDto;
import org.example.backend.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
@Mapper(componentModel = "spring")
public interface TransactionMapper extends SimpleMapper<TransactionEntity, CreateTransactionDto> {
    List<TransactionEntity> toTransactionEntityList(List<TransactionListingDto> transactionListingDtos);

    List<TransactionListingDto> toTransactionListingDtoList(List<TransactionEntity> transactionEntities);
}
