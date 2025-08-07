package com.spring.scheduledevelop.domain.schedule.entity;

import com.spring.scheduledevelop.domain.account.entity.Account;
import com.spring.scheduledevelop.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseEntity {
    private String title;
    private String contents;
    private String name;

    @ManyToOne(fetch = LAZY)
    private Account account;

    public static Schedule of(String title, String contents, String name, Account account) {
        return new Schedule(title, contents, name, account);
    }

    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}
