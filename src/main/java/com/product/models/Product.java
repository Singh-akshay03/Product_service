package com.product.models;
import com.product.dtos.RatingDTO;
import lombok.*;

@Getter
@Setter
@Builder
public class Product extends BaseModel{
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private ProductCategories category;
    private RatingDTO rating;
}
