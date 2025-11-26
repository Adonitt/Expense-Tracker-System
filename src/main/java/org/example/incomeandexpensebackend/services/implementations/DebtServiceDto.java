package org.example.incomeandexpensebackend.services.implementations;

import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.services.interfaces.DebtService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtServiceDto implements DebtService {
    @Override
    public DebtDto create(DebtDto dto) {
        return null;
    }

    @Override
    public List<DebtDto> findAll() {
        return List.of();
    }

    @Override
    public DebtDto findById(Long id) {
        return null;
    }

    @Override
    public DebtDto update(Long id, DebtDto dto) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
