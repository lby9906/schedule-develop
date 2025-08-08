package com.spring.scheduledevelop.application.login.service;

import com.spring.scheduledevelop.application.login.dto.request.LoginRequest;
import com.spring.scheduledevelop.application.login.dto.response.LoginResponse;
import com.spring.scheduledevelop.config.PasswordEncoder;
import com.spring.scheduledevelop.domain.account.entity.Account;
import com.spring.scheduledevelop.domain.account.repository.AccountRepository;
import com.spring.scheduledevelop.exception.ErrorCode;
import com.spring.scheduledevelop.exception.ScheduleDevelopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        Account account = accountRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        if (!passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
            throw new ScheduleDevelopException(ErrorCode.NOT_MATCH_EMAIL_PASSWORD);
        }

        return LoginResponse.from(account.getId(), account.getName(), account.getEmail());
    }

    public LoginResponse findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        return LoginResponse.from(account.getId(), account.getName(), account.getEmail());
    }
}
