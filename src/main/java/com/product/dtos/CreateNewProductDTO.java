package com.product.dtos;

import lombok.Data;

@Data
public class CreateNewProductDTO {
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
}
