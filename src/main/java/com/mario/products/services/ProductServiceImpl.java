package com.mario.products.services;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mario.libs.msvc.commons.entities.Product;
import com.mario.products.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final Environment environment;

    
    public ProductServiceImpl(ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        int port = Integer.parseInt(environment.getProperty("local.server.port")); // Valor por defecto
        System.out.println(repository.findAll());
        return ((List<Product>) repository.findAll()).stream().map(p -> {
            p.setPort(port);
            return p;
        }).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        int port = Integer.parseInt(environment.getProperty("local.server.port")); // Valor por defecto
        return repository.findById(id).map(p -> {
            p.setPort(port);
            return p;
        });
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
