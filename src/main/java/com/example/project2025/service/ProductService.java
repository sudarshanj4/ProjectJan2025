package com.example.project2025.service;

import com.example.project2025.model.Product;

public interface ProductService {
    Product findProduct(Long id) throws Exception;
}
