package com.services.ms.product.product.service.Modelo.entity.dtoEntityAplication;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Sell_History")
public class Sell_History {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT para el campo id
    private Long id;

    @Column(name = "sell_id", length = 255) // ID de la venta
    private String sellId;

    @Column(name = "product_id", length = 255) // ID del producto vendido
    private String productId;

    @Column(name = "quantity") // Cantidad vendida
    private Integer quantity;

    @Column(name = "remaining_stock") // Stock restante después de la venta
    private Integer remainingStock;

    @Column(name = "date_of_sell") // Fecha de la venta
    @Temporal(TemporalType.DATE)
    private Date dateOfSell;

    @Column(name = "total_amount") // Monto total de la venta
    private Float totalAmount;

    @Column(name = "price") // Precio unitario del producto
    private Float price;

    @Column(name = "product_name", length = 255) // Nombre del producto
    private String productName;

    @Column(name = "user_name", length = 255) // Nombre del usuario que realizó la venta
    private String userName;

    @Column(name = "user_id", length = 255) // ID del usuario que realizó la venta
    private String userId;

}
