package com.product.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;
    private RatingDTO rating;
}
