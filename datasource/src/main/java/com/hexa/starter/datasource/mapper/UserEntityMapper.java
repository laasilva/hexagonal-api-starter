package com.hexa.starter.datasource.mapper;

import com.hexa.starter.core.model.User;
import com.hexa.starter.datasource.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toModel(UserEntity entity);
    UserEntity toEntity(User model);
}
