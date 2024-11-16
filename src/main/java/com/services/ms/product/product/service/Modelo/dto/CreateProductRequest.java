package com.services.ms.product.product.service.Modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@Builder
public class CreateProductRequest {

    @NotEmpty(message = "the field name cannot be empty or null")
    private  String name ;
    private  String description ;

    @NotNull(message = "the field price cannot be empty or null")
    private BigDecimal price  ;

    @NotNull(message = "the field category cannot be empty or null")
    private  long categoryid ;

}
