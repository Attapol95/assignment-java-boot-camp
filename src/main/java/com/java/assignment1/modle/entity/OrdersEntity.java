package com.java.assignment1.modle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "payer")
    private String payer;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "payee")
    private String payee;

    @Column(name = "detail")
    private String detail;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "credit_card_number")
    private int creditCardNumber;

    @Column(name = "status")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<OrderItemEntity> orderItems;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shipping_id")
    private ShippingAddressEntity shippingAddress;
}
