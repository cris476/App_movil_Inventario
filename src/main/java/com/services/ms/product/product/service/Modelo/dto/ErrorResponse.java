package com.services.ms.product.product.service.Modelo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private  String code ;
    private HttpStatus httpStatus;
    private  String message ;
    private List<String> listDetails ;
    private LocalDateTime timeStamp ;


}
