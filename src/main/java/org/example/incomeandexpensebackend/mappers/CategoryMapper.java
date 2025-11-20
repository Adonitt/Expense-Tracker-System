package org.example.backend.mappers;

import org.example.backend.dtos.category.CategoryDetailsDto;
import org.example.backend.dtos.category.CreateCategoryDto;
import org.example.backend.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
@Mapper(componentModel = "spring")
public interface CategoryMapper extends SimpleMapper<CategoryEntity, CreateCategoryDto> {

    List<CategoryEntity> toCategoryEntityList(List<CategoryDetailsDto> categoryDetailsDtos);

    List<CategoryDetailsDto> toCategoryDetailsDtoList(List<CategoryEntity> categoryEntities);
}
