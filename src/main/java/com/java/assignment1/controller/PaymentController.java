package com.java.assignment1.controller;

import com.java.assignment1.modle.request.PaymentRequest;
import com.java.assignment1.modle.response.PaymentResponse;
import com.java.assignment1.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

   private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public PaymentResponse payment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.payment(paymentRequest);
    }
}
