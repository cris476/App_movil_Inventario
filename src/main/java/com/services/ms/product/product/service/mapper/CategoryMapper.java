package com.services.ms.product.product.service.mapper;


import com.services.ms.product.product.service.Modelo.dto.CategoryResponse;
import com.services.ms.product.product.service.Modelo.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse  toCategoryResponse(Category category);

}
