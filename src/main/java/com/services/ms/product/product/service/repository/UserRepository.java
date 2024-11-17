package com.services.ms.product.product.service.repository;


import com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {


}
