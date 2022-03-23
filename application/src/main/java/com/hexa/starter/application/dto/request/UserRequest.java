package com.hexa.starter.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    @JsonProperty
    Integer id;
    @JsonProperty
    String username;
    @JsonProperty
    String password;
}
