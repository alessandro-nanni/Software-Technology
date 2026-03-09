package com.amol.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.product.entity.ProductResponse;
import com.amol.product.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ProductResponse getAllProducts(){
        return new ProductResponse(productRepository.findAll());
    }
}
