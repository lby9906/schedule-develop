package com.spring.scheduledevelop.application.comment.controller;

import com.spring.scheduledevelop.application.comment.dto.request.CommentRequest;
import com.spring.scheduledevelop.application.comment.dto.response.CommentResponse;
import com.spring.scheduledevelop.application.comment.dto.response.CommentUpdateResponse;
import com.spring.scheduledevelop.application.comment.service.CommentService;
import com.spring.scheduledevelop.config.LoginUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/schedules/{schedule-id}/accounts/{account-id}")
    public CommentResponse create(@RequestBody @Valid CommentRequest request,
                                  @PathVariable("schedule-id") Long scheduleId,
                                  @LoginUser @PathVariable("account-id") Long accountId) {
        return commentService.create(request, scheduleId, accountId);
    }

    //댓글 수정
    @PatchMapping("{comment-id}/schedules/{schedule-id}/accounts/{account-id}")
    public CommentUpdateResponse update(@RequestBody @Valid CommentRequest request,
                                        @PathVariable("schedule-id") Long scheduleId,
                                        @LoginUser @PathVariable("account-id") Long accountId,
                                        @PathVariable("comment-id") Long commentId) {
        LocalDateTime nowTime = LocalDateTime.now();
        return commentService.update(request, scheduleId, accountId, commentId, nowTime);
    }

    //댓글 삭제
    @DeleteMapping("{comment-id}/schedules/{schedule-id}/accounts/{account-id}")
    public ResponseEntity<Void> remove(@PathVariable("schedule-id") Long scheduleId,
                                       @LoginUser @PathVariable("account-id") Long accountId,
                                       @PathVariable("comment-id") Long commentId) {

        commentService.remove(scheduleId, accountId, commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //댓글 조회
    @GetMapping
    public List<CommentResponse> findAll() {
        return commentService.findAll();
    }
}
