package com.bebo.app.ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static com.bebo.app.ecommerce.constants.ErrorConstants.*;

@Data
@ToString
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ProductDto {

    @NotEmpty(message=ERROR_PRODUCT_NAME_EMPTY)
    private String name;

    @NotEmpty(message=ERROR_PRODUCT_SKU_EMPTY)
    private String sku;

    @NotEmpty(message=ERROR_PRODUCT_DESCRIPTION_EMPTY)
    private String description;

    @NotEmpty(message=ERROR_PRODUCT_CATEGORY_EMPTY)
    private String category;

    @NotNull(message = ERROR_PRODUCT_QTY)
    private Long qty;

    @NotNull(message = ERROR_PRODUCT_PRICE)
    private Double price;
}
