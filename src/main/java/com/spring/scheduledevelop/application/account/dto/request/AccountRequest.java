package com.spring.scheduledevelop.application.account.dto.request;

import lombok.Getter;

@Getter
public class AccountRequest {

    private String name;
    private String email;

    public AccountRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
