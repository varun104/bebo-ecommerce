package com.bebo.app.ecommerce.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {

    private UserPrincipal principal;

    public UserPrincipalAuthenticationToken(UserPrincipal principal) {
        super(principal.getAuthorities());
        this.principal=principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return principal;
    }
}
