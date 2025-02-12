package com.example.project2025.service;

import com.example.project2025.advise.exception.ProductNotFoundException;
import com.example.project2025.model.Product;
import com.example.project2025.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    public String url=("https://fakestoreapi.com/products/");


    @Override
    @Transactional
    public Product findProduct(Long id) throws Exception {

//        Product p = restTemplate.getForObject(url+id, Product.class);
        Product p = (Product)redisTemplate.opsForHash().get("PRODUCTS","product_"+id);

        if (p != null) {
            return p;
        }
        Product product = restTemplate.getForObject(url+id, Product.class);
        if(product==null) {
            throw new ProductNotFoundException("Product not found with id "+id);
        }


        redisTemplate.opsForHash().put("PRODUCTS","product_"+id,product);

        return product;
    }



}
