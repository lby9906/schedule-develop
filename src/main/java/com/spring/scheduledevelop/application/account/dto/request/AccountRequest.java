package com.spring.scheduledevelop.application.account.dto.request;

import lombok.Getter;

@Getter
public class AccountRequest {

    private String name;
    private String email;
    private String password;

    public AccountRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
