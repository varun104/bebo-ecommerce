package com.bebo.app.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ResponseDto {

    private HttpStatus statusCode;

    private String statusMessage;

}
