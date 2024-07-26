package com.bebo.app.ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_EMAIL_EMPTY;
import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_PASSWORD_EMPTY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {

    @NotEmpty(message = ERROR_EMAIL_EMPTY)
    private String email;

    @NotEmpty(message = ERROR_PASSWORD_EMPTY)
    private String password;

}
