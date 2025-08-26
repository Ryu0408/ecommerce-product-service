package com.ryu.ecommerce.product.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    private byte[] id; // BINARY(16)

    private String name;

    // getter/setter
    public byte[] getId() { return id; }
    public void setId(byte[] id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
