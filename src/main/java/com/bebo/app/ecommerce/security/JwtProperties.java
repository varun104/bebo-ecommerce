package com.bebo.app.ecommerce.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@ConfigurationProperties("security.jwt")
@Data
public class JwtProperties {

    /**
     * Used to generate the JWT token.
     */
    private String secretKey;
    private Duration tokenDuration;
}
