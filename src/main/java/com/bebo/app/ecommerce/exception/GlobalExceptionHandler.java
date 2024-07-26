package com.bebo.app.ecommerce.exception;

import com.bebo.app.ecommerce.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error)->{
            validationErrors.put(((FieldError)error).getField(),error.getDefaultMessage());
        });

        return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(UserAlreadyExistsException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(UserNotFoundException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleProductAlreadyExistsException(ProductAlreadyExistsException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductDoesNotExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleProductDoesNotExistsException(ProductDoesNotExistsException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<ErrorResponseDto> handleProductDoesNotExistsException(ProductOutOfStockException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorCode(exception.getErrorCode());
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(request.getDescription(false));
        return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.NOT_FOUND);
    }


}
