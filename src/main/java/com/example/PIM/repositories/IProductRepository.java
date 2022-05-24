package com.example.PIM.repositories;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM `products` ORDER BY `id` DESC LIMIT 1", nativeQuery = true)
    public Product GetLastCreatedProduct();

    @Query(value = "SELECT * FROM `products` WHERE `company_id` = ?1", nativeQuery = true)
    public List<Product> getProductsByCompanyId(int id);

    @Query(value = "SELECT * FROM `products` WHERE `id` = ?1", nativeQuery = true)
    public Product getProductFromCompanyById(int id);
}
