package com.services.ms.product.product.service.Modelo.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedUserResquestDTO {

      @NotEmpty(message = "Se requiere un nombre")
      private String name ;
      @NotEmpty(message = "Se requiere una contraseña")
      private String password ;
      private  String email ;
      private  String  phone_info ;
      private  String address ;
      private  String phone_number ;
      private String pincod ;

}
