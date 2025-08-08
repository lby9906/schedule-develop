package com.spring.scheduledevelop.domain.account.entity;

import com.spring.scheduledevelop.domain.common.entity.BaseEntity;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Account extends BaseEntity {
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Schedule> schedule = new ArrayList<>();

    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Account of(String name, String email, String password) {
        return new Account(name, email, password);
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}