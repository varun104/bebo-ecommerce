package com.bebo.app.ecommerce.service;

import com.bebo.app.ecommerce.dto.OrderDto;
import com.bebo.app.ecommerce.dto.PlaceOrderDto;

public interface OrderService {
    OrderDto getOrderDetails(Long orderId);

    void placeOrder(PlaceOrderDto orderDto);
}
