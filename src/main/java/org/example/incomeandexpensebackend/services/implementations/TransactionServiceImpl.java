package org.example.incomeandexpensebackend.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.transaction.CreateTransactionDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionDetailsDto;
import org.example.incomeandexpensebackend.dtos.transaction.TransactionListingDto;
import org.example.incomeandexpensebackend.dtos.transaction.UpdateTransactionDto;
import org.example.incomeandexpensebackend.entities.TransactionEntity;
import org.example.incomeandexpensebackend.entities.UserEntity;
import org.example.incomeandexpensebackend.enums.CategoryEnum;
import org.example.incomeandexpensebackend.exceptions.DebtTransactionException;
import org.example.incomeandexpensebackend.mappers.TransactionMapper;
import org.example.incomeandexpensebackend.repositories.TransactionRepository;
import org.example.incomeandexpensebackend.repositories.UserRepository;
import org.example.incomeandexpensebackend.services.interfaces.AuthService;
import org.example.incomeandexpensebackend.services.interfaces.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TransactionMapper mapper;
    private final AuthService authService;

    @Override
    public CreateTransactionDto create(CreateTransactionDto dto) {
        String email = authService.getLoggedInUserEmail();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));

        var entity = mapper.toEntity(dto);
        entity.setUser(user);
        entity.setCreatedAt(LocalDateTime.now());

        var saved = transactionRepository.save(entity);
        return mapper.toCreateDto(saved);
    }

    @Override
    public List<TransactionListingDto> findAll() {
        var transactionsList = transactionRepository.findAll();
        return mapper.toTransactionListingDtoList(transactionsList);
    }

    @Override
    public TransactionDetailsDto findById(Long id) {
        var transaction = transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
        return mapper.toTransactionDetailsDto(transaction);
    }

    @Override
    public UpdateTransactionDto update(Long id, UpdateTransactionDto dto) {

        TransactionEntity entity = transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        if (entity.getCategory() == CategoryEnum.DEBT) {
            throw new DebtTransactionException("This is a DEBT and cannot be updated as transaction, only in the DEBT section!");
        }
        entity.setAmount(dto.getAmount());
        entity.setType(dto.getType());
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());
        entity.setDate(dto.getDate());
        entity.setUpdatedAt(LocalDateTime.now());

        var savedEntity = transactionRepository.save(entity);
        return mapper.toUpdateDto(savedEntity);
    }

    @Override
    public void removeById(Long id) {
        var transaction = transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        if (transaction.getCategory() == CategoryEnum.DEBT) {
            throw new DebtTransactionException("This is a DEBT and cannot be deleted as transaction, only in the DEBT section!");
        }
        transactionRepository.deleteById(id);
    }
}
