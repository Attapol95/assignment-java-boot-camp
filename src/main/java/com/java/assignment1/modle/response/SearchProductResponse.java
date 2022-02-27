package com.java.assignment1.modle.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductResponse {
    private List<Product> products;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {
        private Integer id;
        private String name;
        private Double currentPrice;
        private Double previousPrice;
        private String discount;
        private String shopProvince;
        private Double ratingAvg;
        private int ratingTotal;
        private String image;
    }
}
