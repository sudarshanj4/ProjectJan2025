package com.example.project2025.controller;

import com.example.project2025.dto.PaymentRequestDto;
import com.example.project2025.dto.PaymentResponseDto;
import com.example.project2025.model.Product;
import com.example.project2025.service.PaymentService;
import com.example.project2025.service.ProductService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> addProduct(@PathVariable long id) throws Exception {
        Product p=productService.findProduct(id);
        return  new ResponseEntity<>(p, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/Payment")
    public ResponseEntity<PaymentResponseDto> addProduct(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        PaymentResponseDto paymentResponseDto=new PaymentResponseDto();
        paymentResponseDto.setUrl(paymentService.makePayment(20));

        return ResponseEntity.ok(paymentResponseDto);
    }
}
