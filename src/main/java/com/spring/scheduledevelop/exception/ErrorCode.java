package com.spring.scheduledevelop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_FOUND_SCHEDULE(HttpStatus.NOT_FOUND, "등록된 일정을 찾을 수 없습니다."),
    NOT_MATCH_EMAIL_PASSWORD(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 일치하지 않습니다."),
    ONLY_TEN_REGISTER_COMMENTS(HttpStatus.CONFLICT, "10개의 댓글만 작성할 수 있습니다."),
    NOT_FOUND_ACCOUNT(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
    LOGIN_REQUIRED(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "권한이 없습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}
