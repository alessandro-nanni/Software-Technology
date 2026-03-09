package com.amol.microservices.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.microservices.ecommerce.assembler.ProductAssembler;
import com.amol.microservices.ecommerce.entity.EcommerceProduct;
import com.amol.microservices.ecommerce.entity.EcommerceProductResponse;

import java.util.List;

/**
 * @author Amol Limaye
 **/
@RestController
public class EcommerceController {

    @Autowired
    ProductAssembler productAssembler;

    @GetMapping("/ecommerceProducts")
    public EcommerceProductResponse getAllEcommerceProducts(){
        return new EcommerceProductResponse(productAssembler.getEcommerceProducts());
    }
}
