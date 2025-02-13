package com.example.project2025.service;


import com.stripe.exception.StripeException;

public interface PaymentService {
    String makePayment(int orderId) throws StripeException;
}
