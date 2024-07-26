package com.bebo.app.ecommerce.constants;

public interface ErrorConstants {

    String ERROR_PASSWORD_EMPTY = "iUser Password should not be empty.";
    String ERROR_FIRST_NAME_EMPTY = "User first name should not be empty.";
    String ERROR_LAST_NAME_EMPTY = "User last name should not be empty.";
    String ERROR_PRODUCT_NAME_EMPTY = "Product Name should not be empty.";
    String ERROR_PRODUCT_SKU_EMPTY = "Product SKU should not be empty.";
    String ERROR_PRODUCT_DESCRIPTION_EMPTY = "Product Description should not be empty.";
    String ERROR_PRODUCT_CATEGORY_EMPTY = "Product Category should not be empty.";
    String ERROR_PRODUCT_QTY = "Product Qty should be greater than zero.";
    String ERROR_PRODUCT_PRICE = "Product Price should not be empty.";


    String ERROR_FIRST_NAME_LIMIT = "User first name size not within 5 to 100.";
    String ERROR_LAST_NAME_LIMIT = "User last name size not within 5 to 100.";
    String ERROR_INVALID_EMAIL_FORMAT = "User email format is invalid.";
    String ERROR_EMAIL_EMPTY = "User email should not be empty.";
    String ERROR_PRIMARY_PHONE_EMPTY = "User primary phone should not be empty.";
    String ERROR_PRIMARY_PHONE_INVALID_FORMAT = "User primary phone format is invalid.";
    String ERROR_ROLE_EMPTY = "User role should not be empty.";

    String ERROR_CODE_USER_ALREADY_EXISTS = "UC10001";
    String ERROR_CODE_USER_NOT_FOUND = "UC10002";
    String ERROR_CODE_PRODUCT_ALREADY_EXISTS = "PD30001";
    String ERROR_CODE_PRODUCT_DOES_NOT_EXISTS = "PD30002";
    String ERROR_CODE_ORDER_DOES_NOT_EXISTS = "PD30003";
    String ERROR_CODE_PRODUCT_OUT_OF_STOCK = "PD30004";


    String ERROR_MESSAGE_USER_ALREADY_EXISTS = "Another user already registered with this email. Please retry.";
    String ERROR_MESSAGE_USER_NOT_FOUND = "User not found registered with this email. Please retry.";
    String ERROR_MESSAGE_PRODUCT_ALREADY_EXISTS = "Another Product already registered with this Sku. Please retry.";
    String ERROR_MESSAGE_PRODUCT_DOES_NOT_EXISTS = "Product does not exists with this Sku. Please retry.";
    String ERROR_MESSAGE_PRODUCT_OUT_OF_STOCK = "Product out of stock for this Sku. Sorry.";

    String ERROR_SKU_EMPTY = "Product sku cannot be empty for this operation to complete. Please retry.";
    String ERROR_RESOURCE_FIELD_NOT_FOUND = "%s not found with %s = %s.";

}
