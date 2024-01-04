package com.product.services;

import com.product.dtos.CreateNewProductDTO;
import com.product.dtos.ProductDTO;
import com.product.dtos.UpdateProductDTO;
import com.product.models.Product;
import com.product.models.ProductCategories;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements IProductServiceInterface {

    private final RestTemplateBuilder restTemplateBuilder;
    public ProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO[] productDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products"
                        ,ProductDTO[].class)
                .getBody();
        List<Product> products= new ArrayList<>();
        assert productDto != null;
        for(ProductDTO product:productDto){
            products.add(getProduct(product));
        }
        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}"
                        ,ProductDTO.class
                        ,productId)
                .getBody();
        assert productDto != null;
        return getProduct(productDto);
    }

    @Override
    public Product addProduct(CreateNewProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDto= restTemplate
                .postForEntity("https://fakestoreapi.com/products"
                        ,product
                        ,ProductDTO.class)
                .getBody();
        assert productDto != null;
        return getProduct(productDto);
    }


    //TODO:- Implement the updateProduct method's logic
    @Override
    public UpdateProductDTO updateProduct(Long productId, UpdateProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate
                .postForEntity("https://fakestoreapi.com/products/{id}"
                        ,product
                        ,UpdateProductDTO.class
                        ,productId)
                .getBody();
    }

    @Override
    public String patchProduct(Long productId) {
        return "patchProduct";
    }

    @Override
    public Product deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}"
                        ,ProductDTO.class
                        ,productId)
                .getBody();
        assert productDto != null;
        return getProduct(productDto);
    }

    private  Product getProduct(ProductDTO productDto) {
        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .imageUrl(productDto.getImage())
                .price(productDto.getPrice())
                .build();
        product.setId(productDto.getId());
        ProductCategories category=ProductCategories.builder()
                .name(productDto.getCategory())
                .build();
        product.setCategory(category);
        product.setRating(productDto.getRating());
        return product;
    }
}
