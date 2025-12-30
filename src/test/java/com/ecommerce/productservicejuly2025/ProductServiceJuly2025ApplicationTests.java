package com.ecommerce.productservicejuly2025;

import com.ecommerce.productservicejuly2025.models.Category;
import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.projections.ProductWithIdAndTitle;
import com.ecommerce.productservicejuly2025.repositories.CategoryRepository;
import com.ecommerce.productservicejuly2025.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceJuly2025ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testDbQueries()
    {
//        List<ProductWithIdAndTitle> productWithIdAndTitles=
//                productRepository.randomSearchMethodForProduct();
//
//        for(ProductWithIdAndTitle product:productWithIdAndTitles)
//        {
//            System.out.println(product.getId()+" "+product.getTitle());
//        }
//
//        System.out.println("DEBUG");
//
//        List<ProductWithIdAndTitle> productWithIdAndTitlesFromNative=
//                productRepository.nativeSearchMethodForProduct();
//
//        for(ProductWithIdAndTitle product:productWithIdAndTitlesFromNative)
//        {
//            System.out.println(product.getId()+" "+product.getTitle());
//        }

        Optional<Product> product=productRepository.findById(9L);

        Optional<Category> category=categoryRepository.findById(1L);

        if(category.isPresent()) {
            System.out.println("product:" + category.get().getProducts());
        }

        System.out.println("DEBUG");
    }

}
