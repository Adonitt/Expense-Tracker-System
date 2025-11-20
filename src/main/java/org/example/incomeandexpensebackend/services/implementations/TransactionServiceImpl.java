package org.example.backend.services.implementations;

import org.example.backend.dtos.transaction.CreateTransactionDto;
import org.example.backend.dtos.transaction.TransactionDetailsDto;
import org.example.backend.dtos.transaction.TransactionListingDto;
import org.example.backend.dtos.transaction.UpdateTransactionDto;
import org.example.backend.services.interfaces.TransactionService;
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
    public void remove(Long id) {

    }
}
