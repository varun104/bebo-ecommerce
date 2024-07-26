package com.bebo.app.ecommerce.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ErrorResponseDto {

    private String apiPath;

    private String errorCode;

    private LocalDateTime errorTime;

    private String errorMessage;

}
