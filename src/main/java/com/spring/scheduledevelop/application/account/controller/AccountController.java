package com.spring.scheduledevelop.application.account.controller;

import com.spring.scheduledevelop.application.account.dto.request.AccountRequest;
import com.spring.scheduledevelop.application.account.dto.request.AccountUpdateRequest;
import com.spring.scheduledevelop.application.account.dto.response.AccountResponse;
import com.spring.scheduledevelop.application.account.dto.response.AccountUpdateResponse;
import com.spring.scheduledevelop.application.account.service.AccountService;
import com.spring.scheduledevelop.config.LoginUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    //회원 생성
    @PostMapping
    public AccountResponse create(@Valid @RequestBody AccountRequest accountRequest) {
        return accountService.create(accountRequest);
    }

    //회원 조회
    @GetMapping("/{account-id}")
    public AccountResponse findById(
            @LoginUser @PathVariable("account-id") Long accountId) {
        return accountService.findById(accountId);
    }

    //회원 수정
    @PatchMapping("/{account-id}")
    public AccountUpdateResponse update(@LoginUser @PathVariable("account-id") Long accountId, @Valid @RequestBody AccountUpdateRequest accountUpdateRequest) {
        LocalDateTime now = LocalDateTime.now();

        return accountService.update(accountId, accountUpdateRequest, now);
    }

    //회원 삭제
    @DeleteMapping("/{account-id}")
    public ResponseEntity<Void> remove(@LoginUser @PathVariable("account-id") Long accountId) {
        accountService.remove(accountId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
