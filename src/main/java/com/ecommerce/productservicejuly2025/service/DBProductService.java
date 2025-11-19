package com.ecommerce.productservicejuly2025.service;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("dbProductService")
public class DBProductService implements ProductService {

    ProductRepository productRepository;
    public DBProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id "+id+" does not exist");
        }
        Product product= optionalProduct.get();
        return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
         return null  ;
    }
}
