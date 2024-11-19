package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;


import com.services.ms.product.product.service.Modelo.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

//    @Column(name = "products_id" , length = 255)
//    private  String products_id;

    @Column(name = "name" , length = 255)
    private  String name ;

    @Column(name = "price")
    private Double price ;

    @ManyToOne
    @JoinColumn(name = "category")
    private  Category  category ;

    @Column(name = "description" , length = 255)
    private  String description ;

    @Column(name = "certified" )
    private Boolean certified ;

    @Column(name = "status" )
    private Boolean status ;

    @Column(name = "stock" , length = 255)
    private Integer stock ;


}



