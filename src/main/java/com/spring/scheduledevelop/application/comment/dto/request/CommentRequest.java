package com.spring.scheduledevelop.application.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequest {
    @NotBlank(message = "내용을 필수로 입력해주세요.")
    @Size(min = 1, max = 100, message = "내용을 1 ~ 100자 사이로 입력해주세요.")
    private String contents;
}
