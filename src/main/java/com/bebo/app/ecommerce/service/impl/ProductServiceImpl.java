package com.bebo.app.ecommerce.service.impl;

import com.bebo.app.ecommerce.dto.ProductDto;
import com.bebo.app.ecommerce.entity.Product;
import com.bebo.app.ecommerce.exception.ProductAlreadyExistsException;
import com.bebo.app.ecommerce.exception.ProductDoesNotExistsException;
import com.bebo.app.ecommerce.exception.ResourceNotFoundException;
import com.bebo.app.ecommerce.mapper.ProductMapper;
import com.bebo.app.ecommerce.repository.ProductRepository;
import com.bebo.app.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.bebo.app.ecommerce.constants.AppConstants.*;
import static com.bebo.app.ecommerce.constants.ErrorConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Boolean create(ProductDto productDto) {
        validateExistingProduct(productDto.getSku());

        Product product = ProductMapper.mapProductDtoToProduct(productDto, new Product());
        //update audit details
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy(ADMIN);

        Product savedProduct = productRepository.save(product);

        return Objects.nonNull(savedProduct);
    }

    private void validateExistingProduct(String sku) {
        Optional<Product> existingProduct = productRepository.findBySku(sku);
        if(existingProduct.isPresent()){
            throw new ProductAlreadyExistsException(ERROR_CODE_PRODUCT_ALREADY_EXISTS,ERROR_MESSAGE_PRODUCT_ALREADY_EXISTS);
        }
    }

    @Override
     public ProductDto findBySku(String sku) {
        Optional<Product> existingProduct = productRepository.findBySku(sku);
        if(existingProduct.isEmpty()){
            throw new ProductDoesNotExistsException(ERROR_CODE_PRODUCT_DOES_NOT_EXISTS,ERROR_MESSAGE_PRODUCT_DOES_NOT_EXISTS);
        }
        ProductDto productDto = ProductMapper.mapProductToProductDto(existingProduct.get());
        return productDto;
    }

    @Override
    public void delete(String sku) {
        Optional<Product> product = productRepository.findBySku(sku);
        product.ifPresentOrElse(
                p ->{ productRepository.delete(product.get());},
                ()->{
                    throw new ResourceNotFoundException(ERROR_CODE_PRODUCT_DOES_NOT_EXISTS,RESOURCE_PRODUCT,FIELD_SKU,""+sku);
                });
    }

    @Override
    public void update(ProductDto productDto) {
        Optional<Product> savedProduct = productRepository.findBySku(productDto.getSku());
        if(savedProduct.isEmpty()){
            throw new ResourceNotFoundException(ERROR_CODE_PRODUCT_DOES_NOT_EXISTS,RESOURCE_PRODUCT,FIELD_SKU,""+productDto.getSku());
        }

        ProductMapper.mapProductDtoToProduct(productDto,savedProduct.get());
        productRepository.save(savedProduct.get());
    }

    @Override
    public List<ProductDto> findAll(String searchKey) {
        List<Product> products = List.of();
        if(searchKey.isEmpty()){
            products = productRepository.findAll();
        } else {
            products = productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(searchKey,searchKey,searchKey);
        }

        return products.stream()
                .map(product -> ProductMapper.mapProductToProductDto(product))
                .toList();
    }


}
