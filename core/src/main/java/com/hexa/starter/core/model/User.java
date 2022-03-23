package com.hexa.starter.core.model;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class User {
    Integer id;
    String username;
    String password;
}
