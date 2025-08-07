package com.spring.scheduledevelop.application.account.service;

import com.spring.scheduledevelop.application.account.dto.request.AccountRequest;
import com.spring.scheduledevelop.application.account.dto.request.AccountUpdateRequest;
import com.spring.scheduledevelop.application.account.dto.response.AccountResponse;
import com.spring.scheduledevelop.application.account.dto.response.AccountUpdateResponse;
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
public class AccountWriteService {
    private final AccountRepository accountRepository;

    //회원 생성
    public AccountResponse create(AccountRequest accountRequest) {
        Account account = Account.of(accountRequest.getName(), accountRequest.getEmail(), accountRequest.getPassword());
        accountRepository.save(account);
        return AccountResponse.from(account.getId(), account.getName(), account.getEmail());
    }

    //회원 수정
    public AccountUpdateResponse update(Long accountId, AccountUpdateRequest accountUpdateRequest, LocalDateTime now) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUNT_ACCOUNT));

        account.update(accountUpdateRequest.getName(), accountUpdateRequest.getEmail());
        accountRepository.save(account);
        return AccountUpdateResponse.from(account.getId(), account.getName(),
                account.getEmail(), account.getCreatedAt(), now);
    }

    //회원 삭제
    public String remove(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ScheduleDevelopException(ErrorCode.NOT_FOUNT_ACCOUNT));
        accountRepository.delete(account);

        return "삭제 완료";
    }
}
