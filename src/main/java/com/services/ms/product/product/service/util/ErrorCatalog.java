package com.services.ms.product.product.service.util;

import lombok.Getter;

@Getter
public enum ErrorCatalog {


    PRODUCT_NOT_FOUND("ERR_PROD_001", "Product not found."),
    INVALID_PRODUCT("ERR_PROD_002", "Invalid product parameters."),

    CATEGORY_NOT_FOUND("ERR_CAT_001", "Category not found."),

    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

    private final   String code ;

    private  final  String messages ;

    ErrorCatalog(String code, String messages) {
        this.code = code;
        this.messages = messages;
    }
}
