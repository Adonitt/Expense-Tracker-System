package org.example.backend.services.interfaces;

import org.example.backend.dtos.category.CategoryDetailsDto;
import org.example.backend.dtos.category.CreateCategoryDto;
import org.example.backend.dtos.category.UpdateCategoryDto;
import org.example.backend.services.base_services.*;

public interface CategoryService extends Addable<CreateCategoryDto>,
        Modifiable<UpdateCategoryDto, Long>,
        Removable<Long>,
        FindAll<CategoryDetailsDto>,
        FindById<CategoryDetailsDto, Long> {
}
