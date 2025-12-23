package com.ecommerce.productservicejuly2025.controller;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.productservicejuly2025.service.ProductService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final HttpServletResponse httpServletResponse;
    ProductService productService;

    public ProductController(@Qualifier("dbProductService") ProductService productService, HttpServletResponse httpServletResponse) {

        this.productService = productService;
        this.httpServletResponse = httpServletResponse;
    }

    /*
    Host get API
    1. Get all products
    2. Get product by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
       // ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);;
//        ResponseEntity<Product> response=null;
//        try{
//            response=new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
//
//
//        }
//        catch (Exception e){
//            response=new ResponseEntity<>(HttpStatus.BAD_GATEWAY  );
//
//        }
//            return response;

        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(id),
                HttpStatus.OK);

        return response;
        //return productService.getSingleProduct(id);

    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {

        ResponseEntity<List<Product>> response=new ResponseEntity<>(productService.getAllProducts(),
                HttpStatus.OK);

        return response;

    }

    //Partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

   @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return  productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        productService.deleteSingleProduct(id);
    }
    /*
    Create Product
    Get Product
    Update Product
    Delete product

    MySQL DB for this

    Client ----> Product Service ----> Database

    We will use Fakestore API to code our Product service

    Client ----> Product Service ----> Fakestore API(product: id, name, quantity, price)

    Agenda:
    How we are going to call 3rd party APIs from our product service
     */
}
