package com.preeti.product_service.controller;

import com.preeti.product_service.model.ProductInput;
import com.preeti.product_service.model.Products;
import com.preeti.product_service.service.ProductService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ProductService service;

    @QueryMapping
    public List<Products> getAllProducts() {
        return service.getAllProducts();
    }

    @QueryMapping
    public Object getProductById(String id) {
        return service.findByProductId(id);
    }

    @MutationMapping
    public Object createProduct(@Argument ProductInput input) {
        System.out.println("Input received: " + input); // Debugging line
        return service.save(input);
    }
}
