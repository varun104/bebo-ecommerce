package com.bebo.app.ecommerce.service;

import com.bebo.app.ecommerce.dto.LoginResponseDto;

public interface AuthService {

    public LoginResponseDto attemptLogin(String email, String password);

}
