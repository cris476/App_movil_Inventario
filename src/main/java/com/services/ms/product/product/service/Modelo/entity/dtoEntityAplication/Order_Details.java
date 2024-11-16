package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Order_Details")
@Getter
@Setter
public class Order_Details {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Integer id ;

    @Column(name = "order_id", length = 255) // ID del pedido
    private String orderId;

    @Column(name = "user_id", length = 255) // ID del usuario
    private String userId;

    @Column(name = "product_id", length = 255) // ID del producto
    private String productId;

    @Column(name = "isApproved") // Indica si está aprobado
    private Boolean isApproved;

    @Column(name = "quantity") // Cantidad del producto
    private Integer quantity;

    @Column(name = "date_of_order_creation") // Fecha de creación del pedido
    @Temporal(TemporalType.DATE)
    private Date dateOfOrderCreation;

    @Column(name = "price") // Precio unitario
    private Float price;

    @Column(name = "total_amount") // Monto total
    private Float totalAmount;

    @Column(name = "product_name", length = 255) // Nombre del producto
    private String productName;

    @Column(name = "user_name", length = 255) // Nombre del usuario
    private String userName;

    @Column(name = "message", length = 1000) // Mensaje del pedido
    private String message;

    @Column(name = "certified") // Indica si el producto está certificado
    private Boolean certified;

    @Column(name = "category", length = 255) // Categoría del producto
    private String category;


}
