package org.example.backend.mappers;

import org.example.backend.dtos.user.CreateUserDto;
import org.example.backend.dtos.user.UserListingDto;
import org.example.backend.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring")
@Primary
public interface UserMapper extends SimpleMapper<UserEntity, CreateUserDto> {
    List<UserEntity> toUserEntityList(List<UserListingDto> userListingDtos);

    List<UserListingDto> toUserListingDtoList(List<UserEntity> userEntities);

}
