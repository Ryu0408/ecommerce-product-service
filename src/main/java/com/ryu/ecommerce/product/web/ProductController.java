package com.ryu.ecommerce.product.web;

import com.ryu.ecommerce.product.domain.Product;
import com.ryu.ecommerce.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Product> list() {
        return productRepository.findAll();
    }
}
