package com.ryu.ecommerce.product.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private byte[] id;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    @ManyToOne(fetch = FetchType.LAZY)   // 다:1 관계
    @JoinColumn(name = "category_id")    // FK 컬럼
    private Category category;

    public byte[] getId() { return id; }
    public void setId(byte[] id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
