package com.ecommerce.productservicejuly2025.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category  extends Base   {

    private String category_name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

//    public Category(String category_name, String description) {
//        this.category_name = category_name;
//        this.description = description;
//    }

}
