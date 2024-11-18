package com.services.ms.product.product.service.Modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GetUserResponse {

    private Long id;
    private String address;
    private int isApproved;
    private int block;
    private String dateOfAccountCreation;
    private String phone_info;
    private String email;
    private int level;
    private String name;
    private String password;
    private String phone_number;
    private String pinCode;
    private String userId;

}
