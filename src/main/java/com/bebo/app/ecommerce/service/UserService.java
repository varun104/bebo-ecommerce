package com.bebo.app.ecommerce.service;

import com.bebo.app.ecommerce.dto.UserDto;
import com.bebo.app.ecommerce.entity.User;

import java.util.Optional;

public interface UserService {
    Long register(UserDto userDto);

    Optional<User> findUserByEmailId(String emailId);

}
