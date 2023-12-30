package com.product.services;

import com.product.dtos.AddProductDTO;

public interface IProductServiceInterface {
    String getAllProducts();

    String getProductById(Long productId);

    String addProduct(AddProductDTO product);

    String updateProduct(Long productId);

    String patchProduct(Long productId);

    String deleteProduct(Long productId);
}
