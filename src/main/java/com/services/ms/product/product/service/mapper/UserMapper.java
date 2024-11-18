package com.services.ms.product.product.service.mapper;


import com.services.ms.product.product.service.Modelo.dto.CreatedUserResponseDTO;
import com.services.ms.product.product.service.Modelo.dto.GetUserResponse;
import com.services.ms.product.product.service.Modelo.dto.ProductResponse;
import com.services.ms.product.product.service.Modelo.dto.UpdateUserResponseDTO;
import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Products;
import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.services.ms.product.product.service.util.Constants.ACTIVE_STATUS;
import static com.services.ms.product.product.service.util.Constants.INACTIVE_STATUS;

@Mapper(componentModel = "spring" )
public interface UserMapper {


    @Mapping(target = "message"  , expression = "java(Message(product))")
    @Mapping(target = "status" , expression = "java(mapStatus(product))")
    UpdateUserResponseDTO toProductResponse(Products product);

    default String mapStatus(Products product){
        return  product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }

    default String Message(Products product){
         return  product.getStatus() ? "PERFECTO" : "IMPERFECTO";
    }

    @Mapping(target = "isApproved" , expression = "java(IsApproved(users))")
    @Mapping(target = "block" , expression = "java(Block(users))")
    GetUserResponse toUserResponse2(Users users);

   default  int IsApproved(Users user){
       return user.getIsApproved() ? 1 : 0 ;
   }

    default  int Block(Users user){
        return user.getIsApproved() ? 1 : 0 ;
    }

}
