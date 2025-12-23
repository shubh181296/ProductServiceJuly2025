package com.ecommerce.productservicejuly2025;

import com.ecommerce.productservicejuly2025.projections.ProductWithIdAndTitle;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
class ProductServiceJuly2025ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDbQueries()
    {
        List<ProductWithIdAndTitle> productWithIdAndTitles=
                productRepository.randomSearchMethodForProduct();

        for(ProductWithIdAndTitle product:productWithIdAndTitles)
        {
            System.out.println(product.getId()+" "+product.getTitle());
        }

        System.out.println("DEBUG");

        List<ProductWithIdAndTitle> productWithIdAndTitlesFromNative=
                productRepository.nativeSearchMethodForProduct();

        for(ProductWithIdAndTitle product:productWithIdAndTitlesFromNative)
        {
            System.out.println(product.getId()+" "+product.getTitle());
        }

        System.out.println("DEBUG");
    }

}
