package org.example.incomeandexpensebackend.services.interfaces;


import org.example.incomeandexpensebackend.dtos.transaction.CreateTransactionDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionDetailsDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionListingDto;
import org.example.incomeandexpensebackend.dtos.transaction.UpdateTransactionDto;
import org.example.incomeandexpensebackend.services.base_services.*;

public interface TransactionService extends Addable<CreateTransactionDto>,
        Modifiable<UpdateTransactionDto, Long>,
        FindAll<TransactionListingDto>,
        FindById<TransactionDetailsDto, Long>,
        Removable<Long> {
}
