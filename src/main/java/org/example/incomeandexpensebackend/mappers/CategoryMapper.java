package org.example.incomeandexpensebackend.mappers;

import org.example.incomeandexpensebackend.dtos.category.CategoryDetailsDto;
import org.example.incomeandexpensebackend.dtos.category.CreateCategoryDto;
import org.example.incomeandexpensebackend.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
@Mapper(componentModel = "spring")
public interface CategoryMapper extends SimpleMapper<CategoryEntity, CreateCategoryDto> {

    List<CategoryEntity> toCategoryEntityList(List<CategoryDetailsDto> categoryDetailsDtos);

    List<CategoryDetailsDto> toCategoryDetailsDtoList(List<CategoryEntity> categoryEntities);
}
