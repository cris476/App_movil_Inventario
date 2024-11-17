package com.services.ms.product.product.service.Modelo.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDTO {
    private String name;
    private String password;
    private int level;
    private String dateOfAccountCreation;
    private Integer isApproved;
    private Integer block;
    private String address;
    private String email;
    private String number;
    private String pinCode;
    private String userId;

}
