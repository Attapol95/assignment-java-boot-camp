package com.java.assignment1.service;

import com.java.assignment1.modle.entity.OrderItemEntity;
import com.java.assignment1.modle.entity.OrdersEntity;
import com.java.assignment1.modle.entity.ProductEntity;
import com.java.assignment1.modle.entity.ShippingAddressEntity;
import com.java.assignment1.modle.request.PaymentRequest;
import com.java.assignment1.modle.response.PaymentResponse;
import com.java.assignment1.repository.OrderRepository;
import com.java.assignment1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public PaymentService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public PaymentResponse payment(PaymentRequest paymentRequest) {
        List<Integer> extractProductId = paymentRequest.getProductOrders().stream()
                .map(PaymentRequest.ProductOrder::getProductId)
                .collect(Collectors.toList());
        Map<Integer, ProductEntity> products = productRepository.findByIdIn(extractProductId).stream()
                .collect(Collectors.toMap(ProductEntity::getId, Function.identity()));

        OrdersEntity order = createOrder(paymentRequest, products);
        orderRepository.save(order);
        //send payment credit card to payment gateway and return status of payment success or fail
        order.setTransactionDate(LocalDateTime.now());
        orderRepository.save(order);

        return PaymentResponse.builder()
                .invoiceNo(order.getOrderId())
                .payer(order.getPayer())
                .transactionDate(order.getTransactionDate())
                .payee(order.getPayee())
                .detail(order.getDetail())
                .amount(order.getAmount())
                .build();
    }

    private OrdersEntity createOrder(PaymentRequest paymentRequest, Map<Integer, ProductEntity> products) {
        List<OrderItemEntity> orderItems = paymentRequest.getProductOrders().stream()
                .map(product -> OrderItemEntity.builder()
                        .productId(product.getProductId())
                        .productName(products.get(product.getProductId()).getName())
                        .price(products.get(product.getProductId()).getCurrentPrice())
                        .quantity(product.getQuantity())
                        .build()).collect(Collectors.toList());

        ShippingAddressEntity shippingAddress = ShippingAddressEntity.builder()
                .email(paymentRequest.getShippingAddress().getEmail())
                .firstNameLastName(paymentRequest.getShippingAddress().getFirstNameLastName())
                .address(paymentRequest.getShippingAddress().getAddress())
                .postCode(paymentRequest.getShippingAddress().getPostCode())
                .district(paymentRequest.getShippingAddress().getDistrict())
                .province(paymentRequest.getShippingAddress().getProvince())
                .tel(paymentRequest.getShippingAddress().getTel())
                .build();

        return OrdersEntity.builder()
                .payer(paymentRequest.getCreditCard().getCardName())
                .payee("Lazada")
                .detail("payment")
                .amount(calculateAmount(orderItems))
                .orderItems(orderItems)
                .paymentMethod(paymentRequest.getPaymentMethod())
                .creditCardNumber(paymentRequest.getCreditCard().getCardNumber())
                .shippingAddress(shippingAddress)
                .build();
    }

    private Double calculateAmount(List<OrderItemEntity> orderItems) {
        double price = 0.0;
        for (OrderItemEntity order : orderItems) {
            price += order.getPrice() * order.getQuantity();
        }
        return price;
    }
}
