package com.spring.scheduledevelop.domain.comment.entity;

import com.spring.scheduledevelop.domain.account.entity.Account;
import com.spring.scheduledevelop.domain.common.entity.BaseEntity;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {

    private String contents;

    @ManyToOne(fetch = LAZY)
    private Account account;

    @ManyToOne(fetch = LAZY)
    private Schedule schedule;

    public static Comment of(String contents, Account account, Schedule schedule) {
        return new Comment(contents, account, schedule);
    }

    public void update(String contents) {
        this.contents = contents;
    }
}
