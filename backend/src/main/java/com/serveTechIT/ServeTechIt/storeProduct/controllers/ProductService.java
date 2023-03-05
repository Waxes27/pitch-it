package com.serveTechIT.ServeTechIt.storeProduct.controllers;


import com.serveTechIT.ServeTechIt.storeProduct.Categories;
import com.serveTechIT.ServeTechIt.storeProduct.Product;
import com.serveTechIT.ServeTechIt.storeProduct.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(AddProductRequest productRequest) {
        Product product = new Product(
                productRequest.price(),
                productRequest.name(),
                Categories.valueOf(productRequest.category())
        );
        productRepository.save(product);
        return product;
    }
}
