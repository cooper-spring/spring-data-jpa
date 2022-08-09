package com.example.entitymanagement.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded
    private Reviews reviews;

    @Column(name = "maker_id")
    private Long makerId;

    public Product(String name) {
        this.name = name;
        this.reviews = Reviews.create();
    }

    private Product(String name, Long makerId) {
        this.name = name;
        this.reviews = Reviews.create();
        this.makerId = makerId;
    }

    public static Product create(String name) {
        return new Product(name);
    }

    public static Product create(String name, Long makerId) {
        return new Product(name, makerId);
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
