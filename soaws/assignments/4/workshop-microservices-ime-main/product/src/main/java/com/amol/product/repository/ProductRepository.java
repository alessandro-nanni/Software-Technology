package com.amol.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amol.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAll();
}
