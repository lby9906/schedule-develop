package com.spring.scheduledevelop.application.comment.dto.response;

import com.spring.scheduledevelop.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private Long commentId;
    private Long scheduleId;
    private String name;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(), comment.getSchedule().getId(),
                comment.getAccount().getName(), comment.getContents(),
                comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
