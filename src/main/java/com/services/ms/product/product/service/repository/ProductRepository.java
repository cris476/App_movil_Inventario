package com.services.ms.product.product.service.repository;

import com.services.ms.product.product.service.Modelo.entity.Category;

import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findAllByCategory(Category category);
}
