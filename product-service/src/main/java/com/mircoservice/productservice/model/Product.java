package com.mircoservice.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

// define MongoDB document
@Document(value = "product")
// create a constructor including all args
@AllArgsConstructor
// create a default constructor
@NoArgsConstructor
// no need to use setter (e.g. Product.builder().id(1).name("Candy").build()
@Builder
// add getter, setter, toString
@Data
public class Product {
    // primary key
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
