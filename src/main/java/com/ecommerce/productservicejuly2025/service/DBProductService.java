package com.ecommerce.productservicejuly2025.service;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Category;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.repositories.CategoryRepository;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class DBProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public DBProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
//        if(category.getId() == null)
//        {
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }
        return productRepository.save(product);
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
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public void deleteSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product does not exist");
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product does not exist");
        }
        Product updatedProduct = optionalProduct.get();

        if(product.getTitle()!= null)
            updatedProduct.setTitle(product.getTitle());

        if(product.getPrice()!= null)
            updatedProduct.setPrice(product.getPrice());

        return productRepository.save(updatedProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
         return null  ;
    }
}
