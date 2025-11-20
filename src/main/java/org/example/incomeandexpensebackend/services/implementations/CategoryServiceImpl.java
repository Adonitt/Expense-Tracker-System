package org.example.incomeandexpensebackend.services.implementations;


import org.example.incomeandexpensebackend.dtos.category.CategoryDetailsDto;
import org.example.incomeandexpensebackend.dtos.category.CreateCategoryDto;
import org.example.incomeandexpensebackend.dtos.category.UpdateCategoryDto;
import org.example.incomeandexpensebackend.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public CreateCategoryDto create(CreateCategoryDto dto) {
        return null;
    }

    @Override
    public List<CategoryDetailsDto> findAll() {
        return List.of();
    }

    @Override
    public CategoryDetailsDto findById(Long id) {
        return null;
    }

    @Override
    public UpdateCategoryDto update(Long id, UpdateCategoryDto dto) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
