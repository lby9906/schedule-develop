package com.spring.scheduledevelop.application.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountResponse {

    private Long accountId;
    private String name;
    private String email;

    public static AccountResponse from(Long accountId, String name, String email) {
        return new AccountResponse(accountId, name, email);
    }
}
