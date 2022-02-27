package com.java.assignment1.service;

import com.java.assignment1.exception.BusinessException;
import com.java.assignment1.modle.entity.ProductEntity;
import com.java.assignment1.modle.response.GetProductResponse;
import com.java.assignment1.modle.response.SearchProductResponse;
import com.java.assignment1.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public SearchProductResponse searchProduct(String productName) {
        List<ProductEntity> products = productRepository.findByNameContains(productName);
        if (products.isEmpty()) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "product not found");
        }
        return SearchProductResponse.builder().products(
                products.stream().map(product -> SearchProductResponse.Product.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImagesUrl())
                .currentPrice(product.getCurrentPrice())
                .previousPrice(product.getPreviousPrice())
                .discount(calculatePercentDiscount(product.getCurrentPrice(), product.getPreviousPrice()))
                .shopProvince(product.getShopProvince())
                .ratingAvg(product.getRatingAvg())
                .ratingTotal(product.getRatingTotal())
                .build()).collect(Collectors.toList()))
                .build();
    }

    public GetProductResponse getProduct(Integer productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Product not found"));
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .currentPrice(product.getCurrentPrice())
                .previousPrice(product.getPreviousPrice())
                .discount(calculatePercentDiscount(product.getCurrentPrice(), product.getPreviousPrice()))
                .ratingAvg(product.getRatingAvg())
                .ratingTotal(product.getRatingTotal())
                .image(product.getImagesUrl())
                .build();
    }

    private String calculatePercentDiscount(Double currentPrice, Double previousPrice) {
        Double difPrice = previousPrice - currentPrice;
        Double percentDiscount = Math.ceil((difPrice / previousPrice) * 100);
        return String.format("%.0f%%", percentDiscount);
    }
}
