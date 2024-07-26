package com.bebo.app.ecommerce.mapper;

import com.bebo.app.ecommerce.dto.CartDto;
import com.bebo.app.ecommerce.entity.CartItem;

public class CartMapper {
    public static CartDto mapCartToCartDto(CartItem cart, CartDto cartDto) {
        cartDto.setCartId(cart.getId());
        cartDto.setProductDto(ProductMapper.mapProductToProductDto(cart.getProduct()));
        //cartDto.setUserDto(UserMapper.mapUserDataToUserDataDto(cartItem.getUser()));
        return cartDto;
    }
}
