package com.bebo.app.ecommerce.service.impl;

import com.bebo.app.ecommerce.dto.UserDto;
import com.bebo.app.ecommerce.entity.User;
import com.bebo.app.ecommerce.exception.UserAlreadyExistsException;
import com.bebo.app.ecommerce.mapper.UserMapper;
import com.bebo.app.ecommerce.repository.UserRepository;
import com.bebo.app.ecommerce.security.JwtIssuer;
import com.bebo.app.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.bebo.app.ecommerce.constants.AppConstants.ADMIN;
import static com.bebo.app.ecommerce.constants.ErrorConstants.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtIssuer jwtIssuer;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Long register(UserDto userDto) {
        Optional<User> existingUser = findUserByEmailId(userDto.getEmail());
        if(existingUser.isPresent()) {
            throw new UserAlreadyExistsException(ERROR_CODE_USER_ALREADY_EXISTS, ERROR_MESSAGE_USER_ALREADY_EXISTS);
        }
        User user = UserMapper.mapUserDataDtoToUserData(userDto);
        user = processBeforeSave(userDto,user);
        user = userRepository.save(user);

        return user.getUserId();
    }

    private User processBeforeSave(UserDto userDto, User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(ADMIN);
        encodePassword(userDto,user);
        return user;
    }

    @Override
    public Optional<User> findUserByEmailId(String emailId) {
        return userRepository.findByEmail(emailId);
    }


    private void encodePassword(UserDto source, User target){
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }
}
