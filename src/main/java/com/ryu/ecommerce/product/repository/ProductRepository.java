package com.ryu.ecommerce.product.repository;

import com.ryu.ecommerce.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, byte[]> {

    @Query("SELECT p FROM Product p " +
            "JOIN p.category c " +
            "WHERE (:category IS NULL OR c.name = :category) " +
            "AND (:keyword IS NULL OR p.name LIKE %:keyword%)")
    Page<Product> search(@Param("category") String category,
                         @Param("keyword") String keyword,
                         Pageable pageable);
}
