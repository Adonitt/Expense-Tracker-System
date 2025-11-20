package org.example.incomeandexpensebackend.services.interfaces;


import org.example.incomeandexpensebackend.dtos.category.CategoryDetailsDto;
import org.example.incomeandexpensebackend.dtos.category.CreateCategoryDto;
import org.example.incomeandexpensebackend.dtos.category.UpdateCategoryDto;
import org.example.incomeandexpensebackend.services.base_services.*;

public interface CategoryService extends Addable<CreateCategoryDto>,
        Modifiable<UpdateCategoryDto, Long>,
        Removable<Long>,
        FindAll<CategoryDetailsDto>,
        FindById<CategoryDetailsDto, Long> {
}
