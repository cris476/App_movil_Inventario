package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;


import com.services.ms.product.product.service.Modelo.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "products_id" , length = 255)
    private  String products_id;

    @Column(name = "name" , length = 255)
    private  String name ;

    @Column(name = "price")
    private Float price ;

    @Column(name = "category" , length = 255)
    private  String category ;

    @Column(name = "certified" )
    @Temporal(TemporalType.DATE)
    private Boolean certified ;

    @Column(name = "stock" , length = 255)
    private Integer stock ;


}



