package com.ecommerce.productservicejuly2025.repositories;

import com.ecommerce.productservicejuly2025.models.Product;
import com.ecommerce.productservicejuly2025.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Product Rep -> should contain all the methods(CRUD) related to product model

    //select * from Product where id=?
    Optional<Product> findById(Long id);

    //select * from Product where price>
    List<Product> findProductByPriceGreaterThan(Double price);

    //select * from Product where title like '%iphone%'
    List<Product> findProductByTitleLike(String title);

    //select * from Product
    List<Product> findAll();

    //HQL

    @Query("Select p.id as id,p.title as title from Product p ")
    List<ProductWithIdAndTitle> randomSearchMethodForProduct();

    //Native Queries: SQL

    @Query(nativeQuery = true,value = "Select p.id as id,p.title as title from product p ")
    List<ProductWithIdAndTitle> nativeSearchMethodForProduct();

}
