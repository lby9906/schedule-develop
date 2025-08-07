package com.spring.scheduledevelop.application.schedule.service;

import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleRequest;
import com.spring.scheduledevelop.application.schedule.dto.request.ScheduleUpdateRequest;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleResponse;
import com.spring.scheduledevelop.application.schedule.dto.response.ScheduleUpdateResponse;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import com.spring.scheduledevelop.domain.schedule.repository.ScheduleRepository;
import com.spring.scheduledevelop.exception.ErrorCode;
import com.spring.scheduledevelop.exception.ScheduleDevelopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleWriteService {

    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = Schedule.of(request.getTitle(), request.getContents(), request.getName());
        scheduleRepository.save(schedule);

        return ScheduleResponse.from(schedule);
    }

    //일정 수정
    public ScheduleUpdateResponse update(ScheduleUpdateRequest request, Long scheduleId, LocalDateTime updateAt) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));
        schedule.update(request.getTitle(), request.getName());
        return ScheduleUpdateResponse.from(schedule, updateAt);
    }

    //일정 삭제
    public String remove(Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_SCHEDULE));

        scheduleRepository.delete(schedule);

        return "삭제 완료";
    }
}
