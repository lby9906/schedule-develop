package com.spring.scheduledevelop.application.comment.service;

import com.spring.scheduledevelop.application.comment.dto.request.CommentRequest;
import com.spring.scheduledevelop.application.comment.dto.response.CommentResponse;
import com.spring.scheduledevelop.application.comment.dto.response.CommentUpdateResponse;
import com.spring.scheduledevelop.domain.account.entity.Account;
import com.spring.scheduledevelop.domain.account.repository.AccountRepository;
import com.spring.scheduledevelop.domain.comment.entity.Comment;
import com.spring.scheduledevelop.domain.comment.repository.CommentRepository;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import com.spring.scheduledevelop.domain.schedule.repository.ScheduleRepository;
import com.spring.scheduledevelop.exception.ErrorCode;
import com.spring.scheduledevelop.exception.ScheduleDevelopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final AccountRepository accountRepository;
    private final ScheduleRepository scheduleRepository;

    //댓글 생성
    public CommentResponse create(CommentRequest request, Long scheduleId, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));

        Comment comment = Comment.of(request.getContents(), account, schedule);
        commentRepository.save(comment);

        return CommentResponse.from(comment);
    }

    //댓글 수정
    public CommentUpdateResponse update(CommentRequest request, Long scheduleId,
                                        Long accountId, Long commentId,
                                        LocalDateTime now) {
        accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_COMMENT));

        comment.update(request.getContents());
        return CommentUpdateResponse.from(comment, now);
    }

    //댓글 삭제
    public void remove(Long scheduleId, Long accountId, Long commentId) {
        accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_COMMENT));

        commentRepository.delete(comment);
    }

    //댓글 전체 조회
    @Transactional(readOnly = true)
    public List<CommentResponse> findAll() {
        List<Comment> findAll = commentRepository.findAll();
        return findAll
                .stream()
                .map(comment -> CommentResponse.from(comment))
                .collect(Collectors.toList());
    }
}
