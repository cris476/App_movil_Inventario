package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;

    @Column(name = "userid" , length = 255)
    private  String userId;

    @Column(name = "password" , length = 255)
    private String password;

    @Column(name = "level" )
    private  int level ;

    @Column(name = "date_of_account_creation")
    @Temporal(TemporalType.DATE)
    private Date date_of_account_creation;

    @Column(name = "phone_info" , length = 255)
    private  String phone_info ;

    @Column(name = "isApproved" , columnDefinition = "BIT(1) default 0")
    private  Boolean isApproved;

    @Column(name = "block" , columnDefinition = "BIT(1) default 0")
    private Boolean  block ;

    @Column(name = "name" , length = 255)
    private String name ;

    @Column(name = "address" , length = 255)
    private  String address ;

    @Column(name = "email" , length = 255)
    private String email ;

    @Column(name = "phone_number" , length = 255)
    private String phone_number ;

    @Column(name = "pinCode" , length = 255)
    private String pinCode ;

}
