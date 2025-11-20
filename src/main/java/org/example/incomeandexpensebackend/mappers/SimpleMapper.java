package org.example.incomeandexpensebackend.mappers;

public interface SimpleMapper<TEntity, TDto> {
    TEntity toEntity(TDto dto);

    TDto toDto(TEntity entity);
}
