package com.ryu.ecommerce.product.dto;

import com.ryu.ecommerce.product.domain.Product;
import com.ryu.ecommerce.product.util.UuidUtil;

public class ProductResponseDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String categoryName;

    public ProductResponseDto(Product product) {
        // byte[16] → UUID → String
        this.id = UuidUtil.fromBytes(product.getId()).toString();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
    }

    // Getter (Jackson 직렬화용)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public String getCategoryName() { return categoryName; }
}
