package com.spring.scheduledevelop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_FOUND_SCHEDULE(HttpStatus.NOT_FOUND, "등록된 일정을 찾을 수 없습니다."),
    NOT_MATCH_EMAIL_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    ONLY_TEN_REGISTER_COMMENTS(HttpStatus.CONFLICT, "10개의 댓글만 작성할 수 있습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
