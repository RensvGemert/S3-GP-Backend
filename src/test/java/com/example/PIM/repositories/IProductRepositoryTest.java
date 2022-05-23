package com.example.PIM.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class IProductRepositoryTest {

    @Autowired
    private IProductRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Sql("/test-data.sql")
    @Test
    void itShouldReturnAllProductsByCompanyId_1() {
        var productsResult = underTest.getProductsByCompanyId(1);

        assertThat(productsResult.get(0).getTitle()).isEqualTo("product 1");

    }
}