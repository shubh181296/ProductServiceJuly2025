package com.ecommerce.productservicejuly2025.controller;

import com.ecommerce.productservicejuly2025.exception.ProductNotFoundException;
import com.ecommerce.productservicejuly2025.models.Product;
import jakarta.servlet.http.HttpServletResponse;
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

    public ProductController(ProductService productService, HttpServletResponse httpServletResponse) {

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

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    //Partial update
//    @PatchMapping("/{id}")
//    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
//        return null;
//    }
//
   @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return  productService.replaceProduct(id, product);
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
