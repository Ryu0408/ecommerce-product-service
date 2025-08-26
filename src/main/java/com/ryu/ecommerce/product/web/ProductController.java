package com.ryu.ecommerce.product.web;

import com.ryu.ecommerce.product.dto.ProductResponseDto;
import com.ryu.ecommerce.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public Page<ProductResponseDto> list(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String keyword,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "12") int size) {

        String sanitizedKeyword = (keyword == null || keyword.isBlank()) ? null : keyword.replaceAll("\\s+", "");

        return productRepository.search(category, sanitizedKeyword, PageRequest.of(page, size))
            .map(ProductResponseDto::new);
    }

}
