package com.example.PIM.repositories;

import com.example.PIM.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM `products` ORDER BY `id` DESC LIMIT 1", nativeQuery = true)
    public Product GetLastCreatedProduct();

    @Query(value = "SELECT * FROM `products` WHERE `company_id` = ?1", nativeQuery = true)
    public List<Product> selectAllProductsFromCompany(int companyId);

    @Query(value = "SELECT * FROM `products` ORDER BY `price` DESC", nativeQuery = true)
    public List<Product> selectAllProductsOrderOnPriceFromCheapToExpensive();


}
