package com.spring.scheduledevelop.application.schedule.dto.response;

import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleByResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;

    public static ScheduleByResponse from(Schedule schedule) {
        return new ScheduleByResponse(
                schedule.getId(), schedule.getTitle(),
                schedule.getContents(), schedule.getName());
    }
}
