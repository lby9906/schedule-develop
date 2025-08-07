package com.spring.scheduledevelop.application.schedule.dto.response;

import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;

    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(schedule.getId(), schedule.getTitle(),
                schedule.getContents(), schedule.getName());
    }
}
