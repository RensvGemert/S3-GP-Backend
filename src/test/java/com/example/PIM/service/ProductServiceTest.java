package com.example.PIM.service;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.model.Product;
import com.example.PIM.repositories.IProductRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    private ProductService underTest;

    @BeforeEach
    void SetUp(){
        underTest = new ProductService(productRepository);
    }

    @Test
    void canGetAllProducts(){
        // when
        underTest.getProducts("title","ASC","",0);
        // then
        verify(productRepository).findAll();
    }
}