package com.java.assignment1.modle.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Integer invoiceNo;
    private String payer;
    private LocalDateTime transactionDate;
    private String payee;
    private String detail;
    private Double amount;
}
