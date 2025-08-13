package com.spring.scheduledevelop.application.account.service;

import com.spring.scheduledevelop.application.account.dto.request.AccountRequest;
import com.spring.scheduledevelop.application.account.dto.request.AccountUpdateRequest;
import com.spring.scheduledevelop.application.account.dto.response.AccountResponse;
import com.spring.scheduledevelop.application.account.dto.response.AccountUpdateResponse;
import com.spring.scheduledevelop.config.PasswordEncoder;
import com.spring.scheduledevelop.domain.account.entity.Account;
import com.spring.scheduledevelop.domain.account.repository.AccountRepository;
import com.spring.scheduledevelop.exception.ErrorCode;
import com.spring.scheduledevelop.exception.ScheduleDevelopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    //회원 생성
    public AccountResponse create(AccountRequest accountRequest) {
        Account account = Account.of(accountRequest.getName(), accountRequest.getEmail(), passwordEncoder.encode(accountRequest.getPassword()));
        accountRepository.save(account);
        return AccountResponse.from(account.getId(), account.getName(), account.getEmail());
    }

    //회원 수정
    public AccountUpdateResponse update(Long accountId, AccountUpdateRequest accountUpdateRequest) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));

        account.update(accountUpdateRequest.getName(), accountUpdateRequest.getEmail());
        accountRepository.save(account);
        accountRepository.flush();

        return AccountUpdateResponse.from(account.getId(), account.getName(),
                account.getEmail(), account.getCreatedAt(), account.getUpdatedAt());
    }

    //회원 삭제
    public void remove(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));
        accountRepository.delete(account);
    }

    //회원 조회
    @Transactional(readOnly = true)
    public AccountResponse findById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUND_ACCOUNT));
        return AccountResponse.from(account.getId(), account.getName(), account.getEmail());
    }
}
