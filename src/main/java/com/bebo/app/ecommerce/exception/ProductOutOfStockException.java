package com.bebo.app.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductOutOfStockException extends RuntimeException{
    private String errorCode;

    public ProductOutOfStockException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
