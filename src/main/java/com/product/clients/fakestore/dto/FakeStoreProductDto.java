package com.product.clients.fakestore.dto;

import com.product.dtos.RatingDTO;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;
    private RatingDTO rating;
}
