package com.spring.scheduledevelop.application.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SchedulePageRequest {
    private long pageNumber = 1;
    private long size = 10;
}
