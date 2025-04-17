package com.preeti.product_service.service;

import com.preeti.product_service.model.Products;
import com.preeti.product_service.repo.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepo repo;

    public List<Products> getAllProducts() {
        return repo.findAll();
    }

    public Object findByProductId(String id) {
        Optional<Products> byId = repo.findById(id);
        if (byId.isEmpty())
            return "Product not found for id :" + id;
        return byId.get();
    }

    public Map<String, Object> save(Products product) {
        try {
            Products save = repo.save(product);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Product saved successfully");
            response.put("product", save);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", e.getMessage());
        }
    }

}
