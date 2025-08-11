package com.spring.scheduledevelop.application.schedule.dto.request;

import lombok.Getter;

@Getter
public class SchedulePageRequest {

    private long pageNumber;
    private long size;

    public SchedulePageRequest(long pageNumber, long size) {
        this.pageNumber = 1;
        this.size = 10;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber < 0 || pageNumber > Integer.MAX_VALUE) {
            this.pageNumber = 1;
            return;
        }
        this.pageNumber = pageNumber;
    }

    public void setSize(int size) {
        if (size < 1 || size > 100) {
            this.size = 10;
            return;
        }
        this.size = size;
    }
}
