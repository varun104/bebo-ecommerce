package com.bebo.app.ecommerce.security;

import com.bebo.app.ecommerce.entity.User;
import com.bebo.app.ecommerce.exception.UserNotFoundException;
import com.bebo.app.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_CODE_USER_NOT_FOUND;
import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_MESSAGE_USER_NOT_FOUND;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserPrincipal loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userService.findUserByEmailId(userName);
        if(user.isEmpty()){
            throw new UserNotFoundException(ERROR_CODE_USER_NOT_FOUND,ERROR_MESSAGE_USER_NOT_FOUND);
        }

        return UserPrincipal
                .builder()
                .userId(user.get().getUserId())
                .email(user.get().getEmail())
                .password(user.get().getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(user.get().getRole())))
                .build();
    }
}
