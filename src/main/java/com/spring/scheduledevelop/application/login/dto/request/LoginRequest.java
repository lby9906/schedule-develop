package com.spring.scheduledevelop.application.login.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "이메일을 필수로 입력해주세요.")
    @Email(message = "잘못된 이메일 형식입니다.")
    private String email;

    @NotBlank(message = "비밀번호를 필수로 입력해주세요.")
    private String password;
}
