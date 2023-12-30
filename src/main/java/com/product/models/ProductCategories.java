package com.product.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductCategories extends BaseModel{
    private String name;
    private String description;
    private List<Product> products;
}
