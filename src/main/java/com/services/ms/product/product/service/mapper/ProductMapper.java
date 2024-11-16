package com.services.ms.product.product.service.mapper;

import com.services.ms.product.product.service.Modelo.dto.ProductResponse;
import com.services.ms.product.product.service.Modelo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.services.ms.product.product.service.util.Constants.ACTIVE_STATUS;
import static com.services.ms.product.product.service.util.Constants.INACTIVE_STATUS;

@Mapper(componentModel = "spring" , uses = CategoryMapper.class)
public interface ProductMapper {

     @Mapping(target = "status" , expression = "java(mapStatus(product))")
     ProductResponse toProductResponse(Product product);

     default String mapStatus(Product product){
         return  product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
     }

}
