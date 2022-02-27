package com.java.assignment1.modle.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipping_address")
@ToString(exclude = "orders")
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Integer shippingId;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name_last_name")
    private String firstNameLastName;

    @Column(name = "address")
    private String address;

    @Column(name = "post_code")
    private int postCode;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "tel")
    private String tel;

    @OneToMany(mappedBy = "shippingAddress", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<OrdersEntity> orders;
}
