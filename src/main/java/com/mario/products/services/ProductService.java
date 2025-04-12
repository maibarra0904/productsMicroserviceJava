package com.mario.products.services;

import java.util.List;
import java.util.Optional;

import com.mario.products.entities.Product;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);

}
