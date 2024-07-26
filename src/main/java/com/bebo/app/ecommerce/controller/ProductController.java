package com.bebo.app.ecommerce.controller;

import com.bebo.app.ecommerce.dto.ProductDto;
import com.bebo.app.ecommerce.dto.ResponseDto;
import com.bebo.app.ecommerce.service.ProductService;

import jakarta.validation.constraints.NotEmpty;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bebo.app.ecommerce.constants.AppConstants.*;
import static com.bebo.app.ecommerce.constants.ErrorConstants.ERROR_SKU_EMPTY;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/create")
    public ResponseEntity<ResponseDto> create(@RequestBody @Validated ProductDto productDto){
        productService.create(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED,PRODUCT_SUCCESSFULLY_CREATED));
    }

    @GetMapping("/findBySku/{sku}")
    public ResponseEntity<ProductDto> findBySku(@PathVariable
                                                    @NotEmpty(message = ERROR_SKU_EMPTY)
                                                    String sku){
        ProductDto product = productService.findBySku(sku);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(product);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDto>> findAll(@RequestParam(defaultValue = "") String searchKey){
        List<ProductDto> products = productService.findAll(searchKey);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(products);
    }


    @PutMapping("/admin/update")
    public ResponseEntity<ResponseDto> update(@RequestBody @Validated ProductDto productDto){
        productService.update(productDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK,PRODUCT_SUCCESSFULLY_UPDATED));
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam
                                                  @NotEmpty(message = ERROR_SKU_EMPTY)
                                                  String sku){
        productService.delete(sku);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK,PRODUCT_SUCCESSFULLY_DELETED));
    }

}
