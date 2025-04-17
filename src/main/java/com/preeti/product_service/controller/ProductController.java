package com.preeti.product_service.controller;

import com.preeti.product_service.model.Products;
import com.preeti.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/getAll")
    ResponseEntity<List<Products>> getAll() {
        List<Products> allProducts = service.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/getById")
    ResponseEntity<Object> getProductById(@RequestParam String id) {
        return new ResponseEntity<>(service.findByProductId(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<?> save(@RequestBody Products product) {
        return new ResponseEntity<>(service.save(product), HttpStatus.OK);
    }
}
