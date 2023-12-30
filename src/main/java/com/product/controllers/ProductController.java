package com.product.controllers;

import com.product.dtos.AddProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getAllProducts(){
        return "Getting All Products";
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Long productId){
        return "Getting single Product By Id: " + productId;
    }

    @PostMapping()
    public String addProduct(@RequestBody AddProductDTO product){
        return "Adding Product: "+ product;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating Product: " + productId;
    }

    @PatchMapping("/{productId}")
    public String patchProduct(@PathVariable("productId") Long productId){
        return "Patching Product: " + productId;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting Product: " + productId;
    }
}
