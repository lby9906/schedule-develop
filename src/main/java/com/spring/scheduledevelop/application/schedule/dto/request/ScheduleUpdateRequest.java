package com.spring.scheduledevelop.application.schedule.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleUpdateRequest {

    @Size(min = 1, max = 30, message = "제목을 1 ~ 30자 사이로 입력해주세요.")
    private String title;

    @Size(min = 1, max = 20, message = "이름을 1 ~ 20자 사이로 입력해주세요.")
    private String name;
}
