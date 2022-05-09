package com.example.PIM.repositories;

import com.example.PIM.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM `products` ORDER BY `id` DESC LIMIT 1", nativeQuery = true)
    public Product GetLastCreatedProduct();

}
