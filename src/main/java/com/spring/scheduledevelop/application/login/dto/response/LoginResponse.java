package com.spring.scheduledevelop.application.login.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private Long accountId;
    private String name;
    private String email;

    public static LoginResponse from(Long accountId, String name, String email) {
        return new LoginResponse(accountId, name, email);
    }
}
