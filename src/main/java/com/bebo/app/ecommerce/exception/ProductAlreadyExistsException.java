package com.bebo.app.ecommerce.exception;

import lombok.Getter;

@Getter
public class ProductAlreadyExistsException extends RuntimeException{

    private String errorCode;

    public ProductAlreadyExistsException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
