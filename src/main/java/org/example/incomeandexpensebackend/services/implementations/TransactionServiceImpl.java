package org.example.incomeandexpensebackend.services.implementations;

import org.example.incomeandexpensebackend.dtos.transaction.CreateTransactionDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionDetailsDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionListingDto;
import org.example.incomeandexpensebackend.dtos.transaction.UpdateTransactionDto;
import org.example.incomeandexpensebackend.services.interfaces.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public CreateTransactionDto create(CreateTransactionDto dto) {

        return null;
    }

    @Override
    public List<TransactionListingDto> findAll() {
        return List.of();
    }

    @Override
    public TransactionDetailsDto findById(Long id) {
        return null;
    }

    @Override
    public UpdateTransactionDto update(Long id, UpdateTransactionDto dto) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
