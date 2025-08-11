package com.spring.scheduledevelop.application.schedule.controller;

import com.spring.scheduledevelop.application.schedule.dto.request.SchedulePageRequest;
import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleRequest;
import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleUpdateRequest;
import com.spring.scheduledevelop.application.schedule.dto.response.*;
import com.spring.scheduledevelop.application.schedule.service.ScheduleService;
import com.spring.scheduledevelop.config.LoginUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping("/accounts/{account-id}")
    public ScheduleResponse create(@LoginUser @Valid @RequestBody ScheduleRequest scheduleRequest, @LoginUser @PathVariable("account-id") Long accountId) {
        return scheduleService.create(scheduleRequest, accountId);
    }

    //일정 전체 조회
    @GetMapping
    public PageResponseDto<SchedulePageResponse> findAll(@RequestParam(required = false) String name, SchedulePageRequest schedulePageRequest) {
        return scheduleService.findAll(name, schedulePageRequest);
    }

    //일정 상세 조회
    @GetMapping("/{schedule-id}")
    public ScheduleByResponse findById(@LoginUser @PathVariable("schedule-id") Long scheduleId) {
        return scheduleService.findById(scheduleId);
    }

    //일정 수정
    @PatchMapping("/{schedule-id}/accounts/{account-id}")
    public ScheduleUpdateResponse update(@RequestBody @Valid ScheduleUpdateRequest request,
                                         @PathVariable("schedule-id") Long scheduleId,
                                         @LoginUser @PathVariable("account-id") Long accountId) {
        LocalDateTime now = LocalDateTime.now();
        return scheduleService.update(request, scheduleId, now, accountId);
    }

    //일정 삭제
    @DeleteMapping("/{schedule-id}/accounts/{account-id}")
    public ResponseEntity<Void> remove(@LoginUser @PathVariable("schedule-id") Long scheduleId,
                                       @PathVariable("account-id") Long accountId) {
        scheduleService.remove(scheduleId, accountId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
