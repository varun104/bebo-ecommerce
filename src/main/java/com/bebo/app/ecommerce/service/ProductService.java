package com.bebo.app.ecommerce.service;

import com.bebo.app.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {

    Boolean create(ProductDto productDto);

    ProductDto findBySku(String sku);

    void delete(String sku);

    void update(ProductDto productDto);

    List<ProductDto> findAll(String searchKey);
}
