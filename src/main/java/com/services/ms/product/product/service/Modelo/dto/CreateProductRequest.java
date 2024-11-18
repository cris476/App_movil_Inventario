package com.services.ms.product.product.service.Modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateProductRequest {

    private String name;
    private String price;
    private String stock;
    private Integer certified;
    private String category;

}
