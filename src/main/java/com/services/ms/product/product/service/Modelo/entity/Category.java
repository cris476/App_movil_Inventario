package com.services.ms.product.product.service.Modelo.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Category {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private  Long id ;

      private  String name;
      private  String description ;


}
