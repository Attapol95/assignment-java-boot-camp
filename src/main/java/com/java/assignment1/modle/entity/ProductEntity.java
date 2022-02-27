package com.java.assignment1.modle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imagesUrl;

    @Column(name = "current_price")
    private Double currentPrice;

    @Column(name = "previous_price")
    private Double previousPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "shop_province")
    private String shopProvince;

    @Column(name = "rating_avg")
    private Double ratingAvg;

    @Column(name = "rating_total")
    private int ratingTotal;

    @Column(name = "quantity")
    private int quantity;
}

