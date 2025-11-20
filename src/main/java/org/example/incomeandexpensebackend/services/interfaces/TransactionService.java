package org.example.backend.services.interfaces;

import org.example.backend.dtos.transaction.CreateTransactionDto;
import org.example.backend.dtos.transaction.TransactionDetailsDto;
import org.example.backend.dtos.transaction.TransactionListingDto;
import org.example.backend.dtos.transaction.UpdateTransactionDto;
import org.example.backend.services.base_services.*;

public interface TransactionService extends Addable<CreateTransactionDto>,
        Modifiable<UpdateTransactionDto, Long>,
        FindAll<TransactionListingDto>,
        FindById<TransactionDetailsDto, Long>,
        Removable<Long> {
}
