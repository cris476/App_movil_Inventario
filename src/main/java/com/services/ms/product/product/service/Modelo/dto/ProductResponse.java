package com.services.ms.product.product.service.Modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

     private  Long id ;
     private  String name ;
     private  String description ;
     private  BigDecimal price ;
     private  CategoryResponse category ;
     private  String status ;

}
