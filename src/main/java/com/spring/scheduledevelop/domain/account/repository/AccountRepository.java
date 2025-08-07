package com.spring.scheduledevelop.domain.account.repository;

import com.spring.scheduledevelop.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
