package com.product.services;

import com.product.clients.fakestore.dto.FakeStoreProductDto;
import com.product.dtos.CreateNewProductDTO;
import com.product.dtos.UpdateProductDTO;
import com.product.models.ProductCategories;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements IProductServiceInterface {

    private final RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products"
                        ,FakeStoreProductDto[].class)
                .getBody();
        List<FakeStoreProductDto> products= new ArrayList<>();
        assert fakeStoreProductDto!= null;
        for(FakeStoreProductDto product:fakeStoreProductDto){
            products.add(getProduct(product));
        }
        return products;
    }

    @Override
    public FakeStoreProductDto getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}"
                        ,FakeStoreProductDto.class
                        ,productId)
                .getBody();
        assert fakeStoreProductDto != null;
        return getProduct(fakeStoreProductDto);
    }

    @Override
    public FakeStoreProductDto addProduct(CreateNewProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto= restTemplate
                .postForEntity("https://fakestoreapi.com/products"
                        ,product
                        ,FakeStoreProductDto.class)
                .getBody();
        assert fakeStoreProductDto != null;
        return getProduct(fakeStoreProductDto);
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
    public FakeStoreProductDto deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto= restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}"
                        ,FakeStoreProductDto.class
                        ,productId)
                .getBody();
        assert fakeStoreProductDto != null;
        return getProduct(fakeStoreProductDto);
    }

    private FakeStoreProductDto getProduct(FakeStoreProductDto productDto) {
        FakeStoreProductDto fakeStoreProductDto = FakeStoreProductDto.builder()
                .id(productDto.getId())
                .rating(productDto.getRating())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .image(productDto.getImage())
                .price(productDto.getPrice())
                .category(productDto.getCategory())
                .build();
        ProductCategories category=ProductCategories.builder()
                .name(productDto.getCategory())
                .build();
        fakeStoreProductDto.setCategory(category.getName());
        return fakeStoreProductDto;
    }
}
