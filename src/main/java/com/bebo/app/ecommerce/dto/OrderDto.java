package com.bebo.app.ecommerce.dto;

import com.bebo.app.ecommerce.entity.User;
import com.bebo.app.ecommerce.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    @JsonProperty("orderId")
    private Long id;

    private String description;

    private String address;

    private String paymentType;

    private OrderStatus orderStatus;

    private LocalDateTime orderDateTime;

    private Double price;

    private User user;

    private List<CartDto> cartDtoList;
}
