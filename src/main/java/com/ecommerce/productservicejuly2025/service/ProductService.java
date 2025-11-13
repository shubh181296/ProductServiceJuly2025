package com.ecommerce.productservicejuly2025.service;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;

import java.util.ArrayList;


public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    ArrayList<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);
}
