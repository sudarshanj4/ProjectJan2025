package com.example.project2025.payment;

import com.stripe.exception.StripeException;

public interface PaymentGatway {
    public String createPaymentLink(int orderid,double amount) throws StripeException;
}
