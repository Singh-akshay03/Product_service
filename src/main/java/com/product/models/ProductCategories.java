package com.product.models;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductCategories extends BaseModel{
    private String name;
    private String description;
    private List<Product> products;
}
