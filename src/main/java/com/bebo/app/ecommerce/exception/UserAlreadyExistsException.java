package com.bebo.app.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserAlreadyExistsException extends RuntimeException{

    private String errorCode;

    public UserAlreadyExistsException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
