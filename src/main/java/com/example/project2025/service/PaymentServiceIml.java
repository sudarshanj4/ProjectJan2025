package com.example.project2025.service;

import com.example.project2025.payment.PaymentGatway;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceIml implements PaymentService {


    @Autowired
    PaymentGatway paymentGatway;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String makePayment(int orderId) throws StripeException {
        String url=paymentGatway.createPaymentLink(orderId,1000);
        return url;
    }
}
