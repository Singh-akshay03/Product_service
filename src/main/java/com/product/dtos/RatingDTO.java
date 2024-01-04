package com.product.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RatingDTO {
    private double rate;
    private double count;
}
