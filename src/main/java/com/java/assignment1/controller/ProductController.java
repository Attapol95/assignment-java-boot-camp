package com.java.assignment1.controller;

import com.java.assignment1.exception.BusinessException;
import com.java.assignment1.modle.response.GetProductResponse;
import com.java.assignment1.modle.response.SearchProductResponse;
import com.java.assignment1.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public SearchProductResponse searchProduct(@RequestParam String productName) {
        if (StringUtils.isBlank(productName)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "product name it should be is not empty");
        }
        return productService.searchProduct(productName);
    }

    @GetMapping("/{productId}")
    public GetProductResponse getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

}
