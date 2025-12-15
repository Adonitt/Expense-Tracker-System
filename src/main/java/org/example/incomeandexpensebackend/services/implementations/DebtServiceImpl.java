package org.example.incomeandexpensebackend.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.entities.DebtEntity;
import org.example.incomeandexpensebackend.entities.TransactionEntity;
import org.example.incomeandexpensebackend.entities.UserEntity;
import org.example.incomeandexpensebackend.enums.*;
import org.example.incomeandexpensebackend.exceptions.UnauthorizedException;
import org.example.incomeandexpensebackend.mappers.DebtMapper;
import org.example.incomeandexpensebackend.repositories.DebtRepository;
import org.example.incomeandexpensebackend.repositories.TransactionRepository;
import org.example.incomeandexpensebackend.repositories.UserRepository;
import org.example.incomeandexpensebackend.services.interfaces.AuthService;
import org.example.incomeandexpensebackend.services.interfaces.DebtService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {
    private final DebtRepository debtRepository;
    private final DebtMapper debtMapper;
    private final TransactionRepository transactionRepository;
    private final AuthService authService;
    private final UserRepository userRepository;

    @Override
    public DebtDto create(DebtDto dto) {
        var debt = debtMapper.toEntity(dto);
        debt.setCreatedAt(LocalDateTime.now());

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCategory(CategoryEnum.DEBT);
        transactionEntity.setAmount(dto.getAmount());
        transactionEntity.setDate(dto.getDate());
        transactionEntity.setDescription(dto.getDescription());
        transactionEntity.setCreatedAt(LocalDateTime.now());

        String email = authService.getLoggedInUserEmail();

        if (debt.getType() == DebtTypeEnum.LENT) {
            transactionEntity.setType(TransactionTypeEnum.EXPENSE);
        } else if (debt.getType() == DebtTypeEnum.BORROWED) {
            transactionEntity.setType(TransactionTypeEnum.INCOME);
        }

        var savedDebt = debtRepository.save(debt);

        transactionEntity.setDebt(savedDebt);
        savedDebt.setTransaction(transactionEntity);

        UserEntity loggedInUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        transactionEntity.setUser(loggedInUser);

        transactionRepository.save(transactionEntity);

        return debtMapper.toDto(savedDebt);
    }


    @Override
    public List<DebtDto> findAll() {
        String email = authService.getLoggedInUserEmail();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User doesn't exists!"));

        List<DebtEntity> debtEntityList;

        if (user.getRole() == RoleEnum.ADMIN) {
            debtEntityList = debtRepository.findAll();
        } else {
            debtEntityList = debtRepository.findByTransactionUserId(user.getId());
        }

        return debtMapper.toDtoList(debtEntityList);
    }

    @Override
    public DebtDto findById(Long id) {
        var debt = debtRepository.findById(id).orElseThrow(() -> new RuntimeException("Debt not found"));

        String email = authService.getLoggedInUserEmail();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != RoleEnum.ADMIN && !debt.getTransaction().getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("You are not allowed to access this debt");
        }

        return debtMapper.toDto(debt);
    }

    @Override
    public DebtDto update(Long id, DebtDto dto) {
        var debt = debtRepository.findById(id).orElseThrow(() -> new RuntimeException("Debt not found"));
        debt.setAmount(dto.getAmount());
        debt.setPerson(dto.getPerson());
        debt.setDescription(dto.getDescription());
        debt.setStatus(dto.getStatus());
        debt.setType(dto.getType());
        debt.setDate(dto.getDate());
        debt.setUpdatedAt(LocalDateTime.now());

        TransactionEntity transaction = transactionRepository.findByDebtId(debt.getId()).orElseThrow(() -> new EntityNotFoundException("Transaction for debt not found"));

        if (debt.getType() == DebtTypeEnum.LENT) {
            transaction.setType(TransactionTypeEnum.EXPENSE);
            debt.setStatus(DebtStatus.PAID);
        } else if (debt.getType() == DebtTypeEnum.BORROWED) {
            transaction.setType(TransactionTypeEnum.INCOME);
            debt.setStatus(DebtStatus.PENDING);
        }

        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        transaction.setUpdatedAt(LocalDateTime.now());
        transactionRepository.save(transaction);

        return debtMapper.toDto(debt);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        findById(id);
        var transaction = transactionRepository.findByDebtId(id);

        System.out.println("Transaction found: " + transaction.isPresent());

        transactionRepository.deleteByDebtId(id);
        debtRepository.deleteById(id);
    }


}
