package com.example.entitymanagement.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class ProductEntityManagementTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("준영속 상태 엔티티가 merge 메서드에서 반환한 객체와 같은지를 확인한다")
    void retrieveIdenticalWhenMerge() {
        //given
        String name = "name";
        Product product01 = Product.create(name);

        //when
        Product mergedProduct = entityManager.merge(product01);
        Product persistedProduct = productRepository.findByName(name);

        //then
        assertAll(
                () -> assertThat(product01).isNotEqualTo(mergedProduct),
                () -> assertThat(mergedProduct).isEqualTo(persistedProduct)
        );

    }

    @Test
    @DisplayName("준영속 상태 엔티티를 persist 메서드를 반환한 객체와 같은지 확인한다")
    void retrieveIdenticalWhenPersist() {
        //given
        String name = "name";
        Product detachedProduct = Product.create(name);

        //when
        entityManager.persist(detachedProduct);
        Product persistedProduct = productRepository.findByName(name);

        //then
        assertThat(detachedProduct).isEqualTo(persistedProduct);
    }

}
