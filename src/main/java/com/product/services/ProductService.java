package com.product.services;

import com.product.dtos.AddProductDTO;

public class ProductService implements IProductServiceInterface {
    @Override
    public String getAllProducts() {
        return "getAllProducts";
    }

    @Override
    public String getProductById(Long productId) {
        return "getProductById";
    }

    @Override
    public String addProduct(AddProductDTO product) {
        return "addProduct";
    }

    @Override
    public String updateProduct(Long productId) {
        return "updateProduct";
    }

    @Override
    public String patchProduct(Long productId) {
        return "patchProduct";
    }

    @Override
    public String deleteProduct(Long productId) {
        return "deleteProduct";
    }
}
