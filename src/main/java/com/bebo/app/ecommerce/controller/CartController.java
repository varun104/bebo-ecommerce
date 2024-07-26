package com.bebo.app.ecommerce.controller;

import com.bebo.app.ecommerce.dto.CartDto;
import com.bebo.app.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{sku}")
    public ResponseEntity<CartDto> add(@PathVariable String sku){

        CartDto cart = cartService.add(sku);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cart);

    }

    @GetMapping("/getCart")
    public ResponseEntity<List<CartDto>> getCart(){
        List<CartDto> cartDetails = cartService.getCart();
        return ResponseEntity.status(HttpStatus.OK)
                .body(cartDetails);
    }

}
