package com.bebo.app.ecommerce.controller;

import com.bebo.app.ecommerce.dto.OrderDto;
import com.bebo.app.ecommerce.dto.PlaceOrderDto;
import com.bebo.app.ecommerce.dto.ResponseDto;
import com.bebo.app.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bebo.app.ecommerce.constants.AppConstants.ORDER_SUCCESSFULLY_CREATED;
import static com.bebo.app.ecommerce.constants.AppConstants.PRODUCT_SUCCESSFULLY_CREATED;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getOrderDetails/{orderId}")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long orderId){
       OrderDto orderDto = orderService.getOrderDetails(orderId);
       return ResponseEntity
               .status(HttpStatus.FOUND)
               .body(orderDto);
    }


    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseDto> placeOrder(@RequestBody PlaceOrderDto orderDto){
        orderService.placeOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED,ORDER_SUCCESSFULLY_CREATED));
    }

}
