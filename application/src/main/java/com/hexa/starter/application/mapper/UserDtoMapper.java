package com.hexa.starter.application.mapper;

import com.hexa.starter.application.dto.request.UserRequest;
import com.hexa.starter.application.dto.response.UserResponse;
import com.hexa.starter.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User toModel(UserRequest request);
    UserResponse toDto(User user);
}
