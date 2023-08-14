package com.mircoservice.productservice.repository;

import com.mircoservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// String = type of the primary key (id)
public interface ProductRepository extends MongoRepository<Product, String> {
}
