package com.spring.scheduledevelop.application.schedule.service;

import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleByResponse;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleResponse;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import com.spring.scheduledevelop.domain.schedule.repository.ScheduleRepository;
import com.spring.scheduledevelop.exception.ErrorCode;
import com.spring.scheduledevelop.exception.ScheduleDevelopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleReadService {
    private final ScheduleRepository scheduleRepository;

    //전체 일정 조회
    public List<ScheduleResponse> findAll(String name) {
        List<Schedule> scheduleList = scheduleRepository.findAllScheduleOrderByUpdatedAtDesc(name);
        return scheduleList.stream()
                .map(schedule -> ScheduleResponse.from(schedule))
                .collect(Collectors.toList());
    }

    //선택 일정 조회
    public ScheduleByResponse findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));

        return ScheduleByResponse.from(schedule);

    }
}
