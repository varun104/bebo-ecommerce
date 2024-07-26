package com.bebo.app.ecommerce.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class JwtIssuer {

    @Autowired
    JwtProperties jwtProperties;

    public String issue(Request request) {
        var now = Instant.now();

        return JWT.create()
                .withSubject(String.valueOf(request.userId))
                .withIssuedAt(now)
                .withExpiresAt(now.plus(jwtProperties.getTokenDuration()))
                .withClaim("e", request.getEmail())
                .withClaim("au", request.getRoles())
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }

    @Getter
    @Builder
    public static class Request {
        private final Long userId;
        private final String email;
        private final List<String> roles;
    }
}
