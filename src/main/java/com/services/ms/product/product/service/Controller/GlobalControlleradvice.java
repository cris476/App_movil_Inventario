package com.services.ms.product.product.service.Controller;
import com.services.ms.product.product.service.Modelo.dto.ErrorResponse;
import com.services.ms.product.product.service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product.service.exceptions.ProductNotFoundException;
import com.services.ms.product.product.service.util.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControlleradvice {


     @ResponseStatus(HttpStatus.NOT_FOUND)
     @ExceptionHandler(ProductNotFoundException.class)
     public ErrorResponse handeleProductNotFoundExeption(){
           return  ErrorResponse.builder()
                   .code(ErrorCatalog.PRODUCT_NOT_FOUND.getCode())
                   .httpStatus(HttpStatus.NOT_FOUND)
                   .message(ErrorCatalog.PRODUCT_NOT_FOUND.getMessages())
                   .timeStamp(LocalDateTime.now()).build();
     }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handeleCategoryNotFoundExeption(){


        return  ErrorResponse.builder()
                .code(ErrorCatalog.CATEGORY_NOT_FOUND.getCode())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(ErrorCatalog.CATEGORY_NOT_FOUND.getMessages())
                .timeStamp(LocalDateTime.now()).build();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handeleMethodArgumentNotValidExeption(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        return  ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_PRODUCT.getCode())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .listDetails(result.getFieldErrors()
                        .stream().
                         map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .message(ErrorCatalog.INVALID_PRODUCT.getMessages())
                .timeStamp(LocalDateTime.now())
                .build();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handeleExeption(Exception exception){
        return  ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .listDetails(Collections.singletonList(exception.getMessage()))
                .message(ErrorCatalog.GENERIC_ERROR.getMessages())
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
