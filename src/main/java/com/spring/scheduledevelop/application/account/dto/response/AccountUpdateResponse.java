package com.spring.scheduledevelop.application.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AccountUpdateResponse {

    private Long accountId;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AccountUpdateResponse from(Long accountId, String name, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AccountUpdateResponse(accountId, name, email, createdAt, updatedAt);
    }
}
