package com.spring.scheduledevelop.application.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class SchedulePageResponse {

    private String title;
    private long commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;

    public static SchedulePageResponse from(String title, long commentCount, LocalDateTime createdAt, LocalDateTime updatedAt, String name) {
        return new SchedulePageResponse(title, commentCount, createdAt, updatedAt, name);
    }
}
