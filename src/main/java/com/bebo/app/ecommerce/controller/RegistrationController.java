package com.bebo.app.ecommerce.controller;

import com.bebo.app.ecommerce.dto.ResponseDto;
import com.bebo.app.ecommerce.dto.UserDto;
import com.bebo.app.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bebo.app.ecommerce.constants.AppConstants.USER_SUCCESSFULLY_CREATED;

@RestController
@RequestMapping("/api")
@Validated
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(final @Valid @RequestBody UserDto userDto){
        userService.register(userDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, USER_SUCCESSFULLY_CREATED));
    }
}
