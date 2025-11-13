package com.ecommerce.productservicejuly2025.inheritanceTypes.joinedTable;

import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User{

    private String companyName;
}
