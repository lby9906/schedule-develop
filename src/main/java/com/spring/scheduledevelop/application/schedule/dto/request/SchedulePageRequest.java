package com.spring.scheduledevelop.application.schedule.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SchedulePageRequest {
    //현재 페이지 번호
    private long pageNumber = 1;

    //한 페이지에 담긴 데이터 개수
    private long size = 10;
}
