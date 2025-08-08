package com.spring.scheduledevelop.application.login.controller;

import com.spring.scheduledevelop.application.login.dto.request.LoginRequest;
import com.spring.scheduledevelop.application.login.dto.response.LoginResponse;
import com.spring.scheduledevelop.application.login.service.LoginService;
import com.spring.scheduledevelop.domain.login.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        LoginResponse loginResponse = loginService.login(loginRequest);

        HttpSession session = request.getSession();
        LoginResponse loginUser = loginService.findById(loginResponse.getAccountId());

        session.setAttribute(Const.LOGIN_USER, loginUser);

        return "로그인 성공";
    }
}
