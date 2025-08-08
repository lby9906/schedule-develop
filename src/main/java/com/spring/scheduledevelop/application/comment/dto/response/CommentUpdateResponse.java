package com.spring.scheduledevelop.application.comment.dto.response;

import com.spring.scheduledevelop.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentUpdateResponse {
    private Long commentId;
    private Long scheduleId;
    private String name;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentUpdateResponse from(Comment comment, LocalDateTime now) {
        return new CommentUpdateResponse(
                comment.getId(), comment.getSchedule().getId(),
                comment.getAccount().getName(), comment.getContents(),
                comment.getCreatedAt(), now);
    }
}
