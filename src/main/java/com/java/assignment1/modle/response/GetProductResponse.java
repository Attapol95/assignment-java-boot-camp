package com.java.assignment1.modle.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Double currentPrice;
    private Double previousPrice;
    private String discount;
    private Double ratingAvg;
    private int ratingTotal;
    private String image;
}
