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
    @PostMapping
    public ScheduleResponse create(@RequestBody ScheduleRequest scheduleRequest) {
        return scheduleWriteService.create(scheduleRequest);
    }

    //일정 전체 조회
    @GetMapping
    public List<ScheduleResponse> findAll(@RequestParam(required = false) String name) {
        return scheduleReadService.findAll(name);
    }

    //일정 상세 조회
    @GetMapping("/{scheduleId}")
    public ScheduleByResponse findById(@PathVariable Long scheduleId) {
        return scheduleReadService.findById(scheduleId);
    }

    //일정 수정
    @PatchMapping("/{scheduleId}")
    public ScheduleUpdateResponse update(@RequestBody @Valid ScheduleUpdateRequest request, @PathVariable Long scheduleId) {
        LocalDateTime now = LocalDateTime.now();
        return scheduleWriteService.update(request, scheduleId, now);
    }

    //일정 삭제
    @DeleteMapping("/{scheduleId}")
    public String remove(@PathVariable Long scheduleId) {
        return scheduleWriteService.remove(scheduleId);
    }
}
