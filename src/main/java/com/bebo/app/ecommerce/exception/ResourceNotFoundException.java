package com.bebo.app.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_RESOURCE_FIELD_NOT_FOUND;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String errorCode;

    public ResourceNotFoundException(String errorCode, String resourceName, String fieldName, String fieldValue){
        super(String.format(ERROR_RESOURCE_FIELD_NOT_FOUND,resourceName,fieldName,fieldValue));
        this.errorCode= errorCode;

    }
}
