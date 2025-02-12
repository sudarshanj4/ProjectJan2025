package com.example.project2025.controller;

import com.example.project2025.model.Product;
import com.example.project2025.service.ProductService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> addProduct(@PathVariable long id) throws Exception {
        Product p=productService.findProduct(id);
        return  new ResponseEntity<>(p, HttpStatusCode.valueOf(200));
    }
}
