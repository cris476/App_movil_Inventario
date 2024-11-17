package com.services.ms.product.product.service.repository;

import  com.services.ms.product.product.service.Modelo.entity.Category;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category , Long> {

}
