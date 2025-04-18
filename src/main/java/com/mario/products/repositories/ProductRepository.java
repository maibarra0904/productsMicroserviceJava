package com.mario.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mario.libs.msvc.commons.entities.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {
    // No additional methods are needed for basic CRUD operations

}
