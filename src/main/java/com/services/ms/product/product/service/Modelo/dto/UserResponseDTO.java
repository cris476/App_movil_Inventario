package com.services.ms.product.product.service.Modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponseDTO {

      public  UserResponseDTO(){

      }
      private String message ;
      private  Boolean  status;

}
