package com.ecommerce.productservicejuly2025.service;

import com.ecommerce.productservicejuly2025.dtos.FakeStoreProductDto;
import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Category;
import com.ecommerce.productservicejuly2025.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //throw new ArrayIndexOutOfBoundsException();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                        FakeStoreProductDto.class);

        if(fakeStoreProductDto == null)
        {
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    //convert FakeStoreDto to my Product
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
//        product.setPrice(fakeStoreProductDto.getPrice());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setCategory(new Category(fakeStoreProductDto.getCategory(),fakeStoreProductDto.getDescription()));
       return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                       FakeStoreProductDto[].class);

        ArrayList<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;

    }

    @Override
    public Product replaceProduct(Long id,Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto=restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT , requestCallback, responseExtractor);


        //FakeStoreProductDto fakeStoreProductDto=restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,product , FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
}
