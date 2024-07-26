package com.bebo.app.ecommerce.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT jwt){
        var authorityList = getClaimOrEmptyList(jwt, "au").stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        JwtAuthenticationFilter.CURRENT_USER = Long.parseLong(jwt.getSubject());

        return UserPrincipal.builder()
                .userId( Long.parseLong(jwt.getSubject()) )
                .email( jwt.getClaim("e").asString() )
                .authorities( authorityList )
                .build();
    }

    private List<String> getClaimOrEmptyList(DecodedJWT jwt, String claim) {
        if (jwt.getClaim(claim).isNull()) return List.of();
        return jwt.getClaim(claim).asList(String.class);
    }
}
