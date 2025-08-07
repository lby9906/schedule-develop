package com.spring.scheduledevelop.domain.schedule.entity;

import com.spring.scheduledevelop.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseEntity {
    private String title;
    private String contents;
    private String name;

    public static Schedule of(String title, String contents, String name) {
        return new Schedule(title, contents, name);
    }

    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
