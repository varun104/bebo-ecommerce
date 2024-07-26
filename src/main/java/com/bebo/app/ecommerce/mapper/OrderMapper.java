package com.bebo.app.ecommerce.mapper;

import com.bebo.app.ecommerce.dto.CartDto;
import com.bebo.app.ecommerce.dto.OrderDto;
import com.bebo.app.ecommerce.entity.CartItem;
import com.bebo.app.ecommerce.entity.Order;

import java.util.List;

public class OrderMapper {

    public static OrderDto mapOrderToDto(Order source, OrderDto target){
        target.setId(source.getId());
        target.setOrderStatus(source.getOrderStatus());
        target.setDescription(source.getDescription());
        target.setOrderDateTime(source.getOrderDateTime());
        target.setAddress(source.getAddress());
        target.setPrice(source.getPrice());
        //target.setCartItems(mapCartItemToDto(source.getCarts()));
        return target;
    }

    private static List<CartDto> mapCartItemToDto(List<CartItem> carts) {
        return carts.stream()
                .map(cartItem -> CartMapper.mapCartToCartDto(cartItem, new CartDto()))
                .toList();
    }

}
