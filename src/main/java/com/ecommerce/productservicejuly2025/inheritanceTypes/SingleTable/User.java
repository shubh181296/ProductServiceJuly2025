package com.ecommerce.productservicejuly2025.inheritanceTypes.SingleTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorColumn(name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class User {

    @Id
    private int id;
    private String name;
    private String email;

}
