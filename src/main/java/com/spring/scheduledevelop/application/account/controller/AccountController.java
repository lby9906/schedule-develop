package com.spring.scheduledevelop.application.account.controller;

import com.spring.scheduledevelop.application.account.dto.request.AccountRequest;
import com.spring.scheduledevelop.application.account.dto.request.AccountUpdateRequest;
import com.spring.scheduledevelop.application.account.dto.response.AccountResponse;
import com.spring.scheduledevelop.application.account.dto.response.AccountUpdateResponse;
import com.spring.scheduledevelop.application.account.service.AccountReadService;
import com.spring.scheduledevelop.application.account.service.AccountWriteService;
import com.spring.scheduledevelop.config.LoginUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountWriteService accountWriteService;
    private final AccountReadService accountReadService;

    //회원 생성
    @PostMapping
    public AccountResponse create(@Valid @RequestBody AccountRequest accountRequest) {
        return accountWriteService.create(accountRequest);
    }

    //회원 조회
    @GetMapping("/{account-id}")
    public AccountResponse findById(
            @LoginUser @PathVariable("account-id") Long accountId) {
        return accountReadService.findById(accountId);
    }

    //회원 수정
    @PatchMapping("/{account-id}")
    public AccountUpdateResponse update(@LoginUser @PathVariable("account-id") Long accountId, @Valid @RequestBody AccountUpdateRequest accountUpdateRequest) {
        LocalDateTime now = LocalDateTime.now();

        return accountWriteService.update(accountId, accountUpdateRequest, now);
    }

    //회원 삭제
    @DeleteMapping("/{account-id}")
    public String remove(@LoginUser @PathVariable("account-id") Long accountId) {
        return accountWriteService.remove(accountId);
    }
}
