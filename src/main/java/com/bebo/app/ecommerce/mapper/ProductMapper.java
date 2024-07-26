package com.bebo.app.ecommerce.mapper;

import com.bebo.app.ecommerce.dto.ProductDto;
import com.bebo.app.ecommerce.entity.Product;


public class ProductMapper {

   public static ProductDto mapProductToProductDto(Product product){
      return ProductDto.builder()
              .name(product.getName())
              .qty(product.getQty())
              .sku(product.getSku())
              .description(product.getDescription())
              .category(product.getCategory())
              .build();
   }

   public static Product mapProductDtoToProduct(ProductDto productDto, Product product){
      product.setName(productDto.getName());
      product.setQty(productDto.getQty());
      product.setSku(productDto.getSku());
      product.setDescription(productDto.getDescription());
      product.setCategory(productDto.getCategory());
      return product;
   }
}
