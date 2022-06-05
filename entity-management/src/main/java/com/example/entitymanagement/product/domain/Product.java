package com.example.entitymanagement.product.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded
    private Reviews reviews;

    protected Product() {}

    public Product(String name) {
        this.name = name;
        this.reviews = Reviews.create();
    }

    public static Product create(String name) {
        return new Product(name);
    }

    public void addReview(Review review) {
        if(reviews.add(review)) {
            review.setProduct(this);
        }
    }

    public void remove(Review review) {
        reviews.remove(review);
    }

    public List<Review> reviews() {
        return reviews.reviews();
    }

}
