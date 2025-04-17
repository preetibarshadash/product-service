package com.preeti.product_service;

import com.preeti.product_service.model.Products;
import com.preeti.product_service.service.ProductService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductResolver implements GraphQLQueryResolver {

    private final ProductService service;

    @QueryMapping
    public List<Products> getAllProducts() {
        return service.getAllProducts();
    }

    @QueryMapping
    public Object getProductById(String id) {
        return service.findByProductId(id);
    }
}
