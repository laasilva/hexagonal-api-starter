package com.hexa.starter.application.controller;

import com.hexa.starter.application.dto.request.UserRequest;
import com.hexa.starter.application.dto.response.UserResponse;
import com.hexa.starter.application.mapper.UserDtoMapper;
import com.hexa.starter.core.port.command.SaveUserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/starter")
@RequiredArgsConstructor
@Slf4j
public class HexaStarterController {

    private final SaveUserCommand saveUserCommand;
    private final UserDtoMapper mapper;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody
                                                 UserRequest request) {
        log.info("Sending request for test POST User endpoint...");

        final var user = saveUserCommand.save(mapper.toModel(request));
        return ResponseEntity.ok(mapper.toDto(user));
    }
}
