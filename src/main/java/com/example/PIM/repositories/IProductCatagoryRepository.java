package com.example.PIM.repositories;

import com.example.PIM.model.Category;
import com.example.PIM.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductCatagoryRepository extends JpaRepository<ProductCategory, Integer> {
    @Query(value = "SELECT `category_id` FROM product_category where product_id = ?1", nativeQuery = true)
    public List<Category> selectAllCategoriesFromProduct(int id);

    @Query(value = "SELECT `category_id`, `product_id` FROM product_category where product_id = ?1", nativeQuery = true)
    public List<ProductCategory> selectAllProductCategoriesFromProduct(int id);

    @Query(value = "SELECT `category_id`, `product_id` FROM product_category where category_id = ?1", nativeQuery = true)
    public List<ProductCategory> selectAllProductCategoriesFromCategory(int id);
}