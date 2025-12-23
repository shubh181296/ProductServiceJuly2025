package com.ecommerce.productservicejuly2025.service;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;

import java.util.ArrayList;
import java.util.List;


public interface ProductService {

    Product createProduct(Product product);

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);

    void deleteSingleProduct(Long id) throws ProductNotFoundException;

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
}
