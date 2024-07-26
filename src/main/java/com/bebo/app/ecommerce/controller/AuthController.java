package com.bebo.app.ecommerce.controller;

import com.bebo.app.ecommerce.dto.LoginRequestDto;
import com.bebo.app.ecommerce.dto.LoginResponseDto;
import com.bebo.app.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Validated LoginRequestDto loginRequestDto){

        LoginResponseDto loginResponse = authService.attemptLogin(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());

        return ResponseEntity.status(HttpStatus.OK)
                .body(loginResponse);

    }
}
