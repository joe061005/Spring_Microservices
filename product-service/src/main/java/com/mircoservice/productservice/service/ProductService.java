package com.mircoservice.productservice.service;

// define business logic for product

import com.mircoservice.productservice.dto.ProductRequest;
import com.mircoservice.productservice.dto.ProductResponse;
import com.mircoservice.productservice.model.Product;
import com.mircoservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// create a constructor for all required arguments
@RequiredArgsConstructor
// Add log
@Slf4j
public class ProductService {

    private final ProductRepository productRepository; 

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }


}
