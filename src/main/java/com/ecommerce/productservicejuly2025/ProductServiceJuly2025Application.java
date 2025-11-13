package com.ecommerce.productservicejuly2025;

import com.ecommerce.productservicejuly2025.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  ProductServiceJuly2025Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceJuly2025Application.class, args);

        Product pro = new Product();
        //pro.setTitle("Macbook Pro");
    }

}
