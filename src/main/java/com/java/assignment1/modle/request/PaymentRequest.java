package com.java.assignment1.modle.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private CreditCard creditCard;

    private List<ProductOrder> productOrders;

    private ShippingAddress shippingAddress;

    private String paymentMethod;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductOrder {
        private Integer productId;
        private Integer quantity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShippingAddress {
        private String email;

        private String firstNameLastName;

        private String address;

        private int postCode;

        private String district;

        private String province;

        private String tel;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreditCard {
        private int cardNumber;
        private String cardName;
        private String cardExpire;
        private String ccv;
    }
}
