package com.ecommerce.productservicejuly2025.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category  extends Base   {

    private String category_name;
    private String description;

//    public Category(String category_name, String description) {
//        this.category_name = category_name;
//        this.description = description;
//    }

}
