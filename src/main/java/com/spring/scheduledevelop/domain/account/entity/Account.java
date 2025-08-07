package com.spring.scheduledevelop.domain.account.entity;

import com.spring.scheduledevelop.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    private String name;
    private String email;

    public static Account of(String name, String email) {
        return new Account(name, email);
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}