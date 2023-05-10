package com.dw.dwbackendtest.Login.controller;

import com.dw.dwbackendtest.Login.dto.LoginDto;
import com.dw.dwbackendtest.Login.service.LoginService;
import com.dw.dwbackendtest.common.dto.SingleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDto.Post loginDto) {
        return new ResponseEntity<>(
                new SingleResponseDto<>(loginService.Login(loginDto)), HttpStatus.OK
        );
    }

}
