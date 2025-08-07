package com.spring.scheduledevelop.application.schedule.controller;

import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleRequest;
import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleUpdateRequest;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleByResponse;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleResponse;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleUpdateResponse;
import com.spring.scheduledevelop.application.schedule.service.ScheduleReadService;
import com.spring.scheduledevelop.application.schedule.service.ScheduleWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleWriteService scheduleWriteService;
    private final ScheduleReadService scheduleReadService;

    //일정 생성
    @PostMapping("/{account-id}")
    public ScheduleResponse create(@RequestBody ScheduleRequest scheduleRequest, @PathVariable("account-id") Long accountId) {
        return scheduleWriteService.create(scheduleRequest, accountId);
    }

    //일정 전체 조회
    @GetMapping
    public List<ScheduleResponse> findAll(@RequestParam(required = false) String name) {
        return scheduleReadService.findAll(name);
    }

    //일정 상세 조회
    @GetMapping("/{schedule-id}")
    public ScheduleByResponse findById(@PathVariable Long scheduleId) {
        return scheduleReadService.findById(scheduleId);
    }

    //일정 수정
    @PatchMapping("/{schedule-id}/accounts/{account-id}")
    public ScheduleUpdateResponse update(@RequestBody @Valid ScheduleUpdateRequest request,
                                         @PathVariable Long scheduleId,
                                         @PathVariable("account-id") Long accountId) {
        LocalDateTime now = LocalDateTime.now();
        return scheduleWriteService.update(request, scheduleId, now, accountId);
    }

    //일정 삭제
    @DeleteMapping("/{schedule-id}/accounts/{account-id}")
    public String remove(@PathVariable Long scheduleId, @PathVariable("account-id") Long accountId) {
        return scheduleWriteService.remove(scheduleId, accountId);
    }
}
