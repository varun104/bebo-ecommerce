package com.bebo.app.ecommerce.service.impl;

import com.bebo.app.ecommerce.dto.LoginResponseDto;
import com.bebo.app.ecommerce.security.JwtIssuer;
import com.bebo.app.ecommerce.security.UserPrincipal;
import com.bebo.app.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtIssuer jwtIssuer;

    public LoginResponseDto attemptLogin(String email, String password){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .roles(principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build());

        return new LoginResponseDto(token);
    }
}
