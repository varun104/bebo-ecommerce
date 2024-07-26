package com.bebo.app.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CartDto {

    private Long cartId;

    @JsonProperty(value = "product")
    private ProductDto productDto;

    @JsonProperty(value = "user")
    private UserDto userDto;
}
