package org.example.incomeandexpensebackend.mappers;

import org.example.incomeandexpensebackend.dtos.user.CreateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UpdateUserDto;
import org.example.incomeandexpensebackend.dtos.user.UserDetailsDto;
import org.example.incomeandexpensebackend.dtos.user.UserListingDto;
import org.example.incomeandexpensebackend.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(CreateUserDto dto);

    CreateUserDto toDto(UserEntity entity);

    UserDetailsDto toUserDetailsDto(UserEntity entity);

    UpdateUserDto toUpdateUserDto(UserEntity entity);

    List<UserEntity> toUserEntityList(List<UserListingDto> userListingDtos);

    List<UserListingDto> toUserListingDtoList(List<UserEntity> userEntities);
}
