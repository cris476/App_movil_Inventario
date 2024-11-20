package com.services.ms.product.product.service.Controller;


import com.services.ms.product.product.service.Modelo.dto.*;
import com.services.ms.product.product.service.repository.ProductRepository;
import com.services.ms.product.product.service.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ControllerProduct {


    private  final ProductService productService;


    @GetMapping
     public List<ProductResponse> findbyAll(){
         return productService.findAll();
    }

    @GetMapping("/getAllUsers")
    public  List<GetUserResponse> alluser(){
         return productService.findAllUser();
    }



    @GetMapping("/{id}")
    public  ProductResponse finById(@PathVariable Long id){
         return productService.findByid(id);
    }

    @GetMapping("Category/{id}")
    public List<ProductResponse> finByCategoryId(@PathVariable Long id){
         return  productService.findAllByCategoryId(id);
    }

//    @PostMapping()
//    public  ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductRequest request){
//          ProductResponse productResponse = productService.save(request);
//          return ResponseEntity.created(URI.create("/api/products/" + productResponse.getId())).body(productResponse);
//    }

//    @PostMapping
//    public ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductRequest request) {
//        ProductResponse response = productService.save(request);
//        return ResponseEntity
//                .created(URI.create("/api/products/" + response.getId()))
//                .body(response);
//    }


    @PostMapping("/products")
    public  CreatedUserResponseDTO  addProduct( @Valid @RequestBody  CreateProductRequest request){
          return  productService.saveProduct(request);
    }

    @PostMapping("/createUser")
    public CreatedUserResponseDTO adduser(@Valid @RequestBody CreatedUserResquestDTO resquest){
         return   productService.addUser(resquest);
    }





}
