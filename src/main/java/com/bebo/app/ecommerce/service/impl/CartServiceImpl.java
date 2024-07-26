package com.bebo.app.ecommerce.service.impl;

import com.bebo.app.ecommerce.dto.CartDto;
import com.bebo.app.ecommerce.entity.CartItem;
import com.bebo.app.ecommerce.entity.Product;
import com.bebo.app.ecommerce.entity.User;
import com.bebo.app.ecommerce.exception.ProductOutOfStockException;
import com.bebo.app.ecommerce.exception.ResourceNotFoundException;
import com.bebo.app.ecommerce.mapper.CartMapper;
import com.bebo.app.ecommerce.repository.CartItemRepository;
import com.bebo.app.ecommerce.repository.ProductRepository;
import com.bebo.app.ecommerce.repository.UserRepository;
import com.bebo.app.ecommerce.security.JwtAuthenticationFilter;
import com.bebo.app.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bebo.app.ecommerce.constants.AppConstants.*;
import static com.bebo.app.ecommerce.constants.ErrorConstants.*;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public CartDto add(String sku) {

        Optional<Product> product = productRepository.findBySku(sku);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(ERROR_CODE_PRODUCT_DOES_NOT_EXISTS,RESOURCE_PRODUCT,FIELD_SKU,sku);
        }

        if(product.get().getQty() < 1){
            throw new ProductOutOfStockException(ERROR_CODE_PRODUCT_OUT_OF_STOCK,ERROR_MESSAGE_PRODUCT_OUT_OF_STOCK);
        }

        Long userId = JwtAuthenticationFilter.CURRENT_USER;
        Optional<User> user = userRepository.findById(userId);

        CartItem cart = new CartItem(product.get(),user.get());

        cart = cartItemRepository.save(cart);

        return CartMapper.mapCartToCartDto(cart, new CartDto());
    }

    @Override
    public List<CartDto> getCart() {

        Long currentUser = JwtAuthenticationFilter.CURRENT_USER;

        Optional<User> user = userRepository.findById(currentUser);

        if(user.isEmpty()){
            throw new ResourceNotFoundException(ERROR_CODE_USER_NOT_FOUND,RESOURCE_USER,FIELD_USER_ID,""+currentUser);
        }
        List<CartItem> cartDetails = cartItemRepository.findByUser(user.get());

        return cartDetails.stream()
                .map(cartItem -> CartMapper.mapCartToCartDto(cartItem,new CartDto()))
                .toList();
    }
}
