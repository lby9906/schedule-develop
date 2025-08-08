package com.spring.scheduledevelop.application.account.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountRequest {

    @NotBlank(message = "이름을 필수로 입력해주세요.")
    @Size(min = 1, max = 20, message = "이름을 1 ~ 20자 사이로 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일을 필수로 입력해주세요.")
    @Email(message = "잘못된 이메일 형식입니다.")
    private String email;

    @NotBlank(message = "비밀번호를 필수로 입력해주세요.")
    @Size(min = 1, max = 20, message = "비밀번호를 1 ~ 20자 사이로 입력해주세요.")
    private String password;

    public AccountRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
