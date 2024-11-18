package com.services.ms.product.product.service.service;

import com.services.ms.product.product.service.Modelo.dto.*;


import java.util.List;

public interface ProductService {

    ProductResponse findByid(Long id);

    List<ProductResponse> findAll();

    List<GetUserResponse> findAllUser();

    List<ProductResponse> findAllByCategoryId(Long Categoryid);

    ProductResponse update(Long id , CreateProductRequest request);

    ProductResponse save(CreateProductRequest request) ;

    void deletedByid(Long id) ;

    CreatedUserResponseDTO addUser(CreatedUserResquestDTO resquest);


}
