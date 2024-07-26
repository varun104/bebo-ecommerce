package com.bebo.app.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.bebo.app.ecommerce.constants.ErrorConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    @NotEmpty(message = ERROR_FIRST_NAME_EMPTY)
    @Size(min=2,max=100, message = ERROR_FIRST_NAME_LIMIT)
    private String firstName;

    @NotEmpty(message = ERROR_LAST_NAME_EMPTY)
    @Size(min=3,max=100, message = ERROR_LAST_NAME_LIMIT)
    private String lastName;

    @NotEmpty(message = ERROR_EMAIL_EMPTY)
    @Email(message = ERROR_INVALID_EMAIL_FORMAT)
    private String email;

    @NotEmpty(message = ERROR_PRIMARY_PHONE_EMPTY)
    @Pattern(regexp = "(^$|[0-9]{10})", message = ERROR_PRIMARY_PHONE_INVALID_FORMAT)
    private String mobileNumber;

    @NotEmpty(message = ERROR_PASSWORD_EMPTY)
    private String password;

    @NotEmpty(message = ERROR_ROLE_EMPTY)
    private String role;

}
