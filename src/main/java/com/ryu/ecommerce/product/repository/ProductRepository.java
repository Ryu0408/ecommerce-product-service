package com.ryu.ecommerce.product.repository;

import com.ryu.ecommerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, byte[]> {
}
