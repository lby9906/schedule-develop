package com.spring.scheduledevelop.application.schedule.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PageResponseDto<T> {

    private final long page;
    private final long size;
    private final long totalElements;
    private final int totalPages;
    private List<T> contents;

    public PageResponseDto(long page, long size, long totalElements, List<T> contents) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
        this.contents = contents;
    }

    public static <T> PageResponseDto<T> of(long page, long size, long totalElements, List<T> contents) {
        return new PageResponseDto<>(page, size, totalElements, contents);
    }
}
