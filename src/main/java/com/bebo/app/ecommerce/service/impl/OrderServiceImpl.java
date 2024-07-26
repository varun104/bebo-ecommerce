package com.bebo.app.ecommerce.service.impl;

import com.bebo.app.ecommerce.dto.CartItemDto;
import com.bebo.app.ecommerce.dto.OrderDto;
import com.bebo.app.ecommerce.dto.PlaceOrderDto;
import com.bebo.app.ecommerce.entity.Order;
import com.bebo.app.ecommerce.exception.ResourceNotFoundException;
import com.bebo.app.ecommerce.mapper.OrderMapper;
import com.bebo.app.ecommerce.repository.OrderRepository;
import com.bebo.app.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bebo.app.ecommerce.constants.AppConstants.*;
import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_CODE_PRODUCT_DOES_NOT_EXISTS;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public void placeOrder(PlaceOrderDto orderDto){

        Double orderTotal = calculateCartAmount(orderDto.getCartItems());

    }

    private Double calculateCartAmount(List<CartItemDto> cartItems) {

        Double orderTotal = 0.0d;

        for(CartItemDto cartItemDto:cartItems){



        }

       return orderTotal;
    }

    @Override
    public OrderDto getOrderDetails(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()){
            throw new ResourceNotFoundException(ERROR_CODE_PRODUCT_DOES_NOT_EXISTS, RESOURCE_ORDER, FIELD_SKU, ""+orderId);
        }
        OrderDto orderDto = OrderMapper.mapOrderToDto(order.get(), new OrderDto());
        return orderDto;
    }
}
