package com.product.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/categories")
public class ProductCategoryController {
    @GetMapping()
    public String getAllCategories(){
        return "Getting All Categories";
    }

    @GetMapping("/{categoryId}")
    public String getCategoryById( @PathVariable Long categoryId){
        return "Getting Category By Id: " + categoryId;
    }


}
