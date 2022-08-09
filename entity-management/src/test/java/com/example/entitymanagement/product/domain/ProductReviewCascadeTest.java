package com.example.entitymanagement.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class ProductReviewCascadeTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @DisplayName("cascade all이면 review를 추가하기만 해도 persistcontext에서 관리한다")
    void cascadeAllTest() {
        //given
        Product product = Product.create("상품1");
        Review review1 = Review.create("리뷰 코멘트1");
        Review review2 = Review.create("리뷰 코멘트2");

        product.addReview(review1);
        product.addReview(review2);

        //when
        testEntityManager.persist(product);

        //then
        assertAll(
                () -> assertThat(testEntityManager.getId(review1)).isNotNull(),
                () -> assertThat(testEntityManager.getId(review1)).isNotNull()
        );
    }

    /**
     * - cascade.All: 부모 엔티티가 삭제되면 자식 엔티티도 삭제된다
     * - orphanRemoval: 부모 엔티티와 연관관계가 제거되면 자식 엔티티가 삭제된다
     */
    @Test
    @DisplayName("orphan removal 옵션을 추가할 경우 리스트에서 삭제되는 순간 데이터가 삭제된다")
    void orphanRemoval() {
        //given
        Product product = Product.create("상품1");
        Review review1 = Review.create("리뷰 코멘트1");
        Review review2 = Review.create("리뷰 코멘트2");

        product.addReview(review1);
        product.addReview(review2);

        //when
        testEntityManager.persist(product);
        product.remove(review1);

        //then
        assertAll(
                () -> assertThat(reviewRepository.findAll()).hasSize(1),
                () -> assertThat(product.reviews()).hasSize(1)
        );
    }

    @Test
    @DisplayName("product를 조회시 Review의 추가 쿼리 여부를 확인한다")
    void checkOptionalQuery() {
        //given
        Product product = Product.create("상품1");
        Review review1 = Review.create("리뷰 코멘트1");
        Review review2 = Review.create("리뷰 코멘트2");

        product.addReview(review1);
        product.addReview(review2);

        testEntityManager.persist(product);

        //when
        Product lookupProduct = productRepository.findByName("상품1");

        List<Review> reviews = lookupProduct.getReviews().reviews();
        System.out.println(reviews.size());
        //then
    }

}