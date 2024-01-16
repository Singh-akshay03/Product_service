package com.product.services;

import com.product.clients.fakestore.dto.FakeStoreProductDto;
import com.product.dtos.CreateNewProductDTO;
import com.product.dtos.UpdateProductDTO;

import java.util.List;

public interface IProductServiceInterface {
    List<FakeStoreProductDto> getAllProducts();

    FakeStoreProductDto getProductById(Long productId);

    FakeStoreProductDto addProduct(CreateNewProductDTO product);

    UpdateProductDTO updateProduct(Long productId, UpdateProductDTO product);

    String patchProduct(Long productId);

    FakeStoreProductDto deleteProduct(Long productId);
}
