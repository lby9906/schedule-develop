package com.spring.scheduledevelop.application.account.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountUpdateRequest {

    @Size(min = 1, max = 20, message = "이름을 1 ~ 20자 사이로 입력해주세요.")
    private String name;

    @Email(message = "잘못된 이메일 형식입니다.")
    private String email;
}
