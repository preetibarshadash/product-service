package com.preeti.product_service.service;

import com.preeti.product_service.model.ProductInput;
import com.preeti.product_service.model.Products;
import com.preeti.product_service.repo.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepo repo;

    private final ModelMapper mapper;

    public List<Products> getAllProducts() {
        return repo.findAll();
    }

    public Object findByProductId(String id) {
        Optional<Products> byId = repo.findById(id);
        if (byId.isEmpty())
            return "Product not found for id :" + id;
        return byId.get();
    }

    public Object save(ProductInput product) {
        try {
            // Map the input to the Products object
            Products map = mapper.map(product, Products.class);

            // You don't need to set the name here again, as it was already set during mapping.
            // map.setName(product.getName());

            System.out.println("Product before save: " + map);

            // Save the product
            Products savedProduct = repo.save(map);

            // Log the saved product to see if MongoDB has generated the ID
            System.out.println("Saved product with ID: " + savedProduct.getId());

            return savedProduct;
            // Prepare the response
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Product saved successfully");
//            response.put("product", savedProduct); // This will include the ID if generated
//            return response;
        } catch (Exception e) {
            // Handle any errors
            e.printStackTrace();
            return Map.of("error", e.getMessage());
        }
    }


}
