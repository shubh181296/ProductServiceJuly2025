package com.ecommerce.productservicejuly2025.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base {

    private String title;
    private Double price;
    @ManyToOne
    private Category category;

    /*
    Category:
    category name,category id,description

     */

}

/*
    1                   1
Product--------------Category => M:1
     M                   1
 */