//package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;
//
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "Available_Products")
//public class Available_Products {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT para el campo id
//    private Long id;
//
//    @Column(name = "product_id", length = 255) // ID del producto
//    private String productId;
//
//    @Column(name = "product_name", length = 255) // Nombre del producto
//    private String productName;
//
//    @Column(name = "category", length = 255) // Categoría del producto
//    private String category;
//
//    @Column(name = "certified")
//    private Boolean certified;
//
//    @Column(name = "price") // Precio del producto
//    private Float price;
//
//    @Column(name = "stock") // Stock disponible
//    private Integer stock;
//
//    @Column(name = "user_name", length = 255) // Nombre del usuario asociado
//    private String userName;
//
//    @Column(name = "user_id", length = 255) // ID del usuario asociado
//    private String userId;
//
//
//}
