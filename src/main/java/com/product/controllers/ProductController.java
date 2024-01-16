package com.product.controllers;

import com.product.Exceptions.ProductNotFoundException;
import com.product.clients.fakestore.dto.FakeStoreProductDto;
import com.product.dtos.CreateNewProductDTO;
import com.product.dtos.UpdateProductDTO;
import com.product.models.Product;
import com.product.services.IProductServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    IProductServiceInterface productService;
    public ProductController(IProductServiceInterface productService){
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<FakeStoreProductDto>> getAllProducts(){
        try{
            List<FakeStoreProductDto> products=productService.getAllProducts();
            return ResponseEntity.ok(products);
        }catch (Exception e){
            throw new RuntimeException("Error Occurred while getting all products");
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<FakeStoreProductDto> getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        try{
            FakeStoreProductDto product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        }catch (Exception e){
            throw new ProductNotFoundException("Product with ID: "+productId+" Not Found");
        }
    }

    @PostMapping()
    public ResponseEntity<FakeStoreProductDto> addProduct(@RequestBody CreateNewProductDTO product){
        try{
            FakeStoreProductDto newProduct = productService.addProduct(product);
            return ResponseEntity.ok(newProduct);
        }catch (Exception e){
            throw new RuntimeException("Error Occurred while adding new product");
        }
    }

    @PutMapping("/{productId}")
    public UpdateProductDTO updateProduct(@PathVariable("productId") Long productId, @RequestBody UpdateProductDTO product){
        return productService.updateProduct(productId,product);
//        try{
//            return productService.updateProduct(productId,product);
//        }catch (Exception e){
//            throw new RuntimeException(e.getMessage());
//        }
    }

    @PatchMapping("/{productId}")
    public String patchProduct(@PathVariable("productId") Long productId){
        return "Patching Product: " + productId;
    }

    @DeleteMapping("/{productId}")
    public FakeStoreProductDto deleteProduct(@PathVariable("productId") Long productId){
        try{
            return productService.deleteProduct(productId);
        }catch (Exception e){
            throw new RuntimeException("Error Occurred while deleting product");
        }
    }
}
