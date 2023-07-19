package com.yasarplusback.YasarPlusBackend.requests;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private String email;
    private String password;
}