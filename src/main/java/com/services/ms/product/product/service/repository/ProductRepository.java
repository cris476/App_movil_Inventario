package com.services.ms.product.product.service.repository;

import com.services.ms.product.product.service.Modelo.entity.Category;
import com.services.ms.product.product.service.Modelo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);

}
