package com.product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    @ManyToOne
    private ProductCategories category;
}
