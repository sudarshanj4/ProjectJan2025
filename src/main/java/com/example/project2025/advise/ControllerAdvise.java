package com.example.project2025.advise;

import com.example.project2025.advise.exception.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<String> getproductNotFoundException(ProductNotFoundException e) {
    return  new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
}
}
