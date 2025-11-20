package org.example.backend.services.implementations;


import org.example.backend.dtos.category.CategoryDetailsDto;
import org.example.backend.dtos.category.CreateCategoryDto;
import org.example.backend.dtos.category.UpdateCategoryDto;
import org.example.backend.services.interfaces.CategoryService;
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
