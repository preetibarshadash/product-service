package com.preeti.product_service.repo;

import com.preeti.product_service.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends MongoRepository<Products,String> {
}
