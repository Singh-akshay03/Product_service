package com.product.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddProductDTO {
    private String title;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
}
