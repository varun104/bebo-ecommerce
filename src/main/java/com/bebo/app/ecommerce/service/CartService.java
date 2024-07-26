package com.bebo.app.ecommerce.service;

import com.bebo.app.ecommerce.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto add(String sku);

    List<CartDto> getCart();
}
