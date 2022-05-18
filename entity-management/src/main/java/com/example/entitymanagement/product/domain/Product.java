package com.example.entitymanagement.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    protected Product() {}

    public Product(String name) {
        this.name = name;
    }

    public static Product create(String name) {
        return new Product(name);
    }

}
