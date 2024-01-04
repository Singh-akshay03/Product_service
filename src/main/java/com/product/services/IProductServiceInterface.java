package com.product.services;

import com.product.dtos.CreateNewProductDTO;
import com.product.dtos.UpdateProductDTO;
import com.product.models.Product;

import java.util.List;

public interface IProductServiceInterface {
    List<Product> getAllProducts();

    Product getProductById(Long productId);

    Product addProduct(CreateNewProductDTO product);

    UpdateProductDTO updateProduct(Long productId, UpdateProductDTO product);

    String patchProduct(Long productId);

    Product deleteProduct(Long productId);
}
