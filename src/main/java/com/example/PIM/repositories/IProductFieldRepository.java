package com.example.PIM.repositories;

import com.example.PIM.model.ProductField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductFieldRepository extends JpaRepository<ProductField, Integer> {
    @Query(value = "SELECT `field_id`, `product_id`, `value` FROM product_field where product_id = ?1", nativeQuery = true)
    public List<ProductField> selectAllProductFieldsFromProduct(int id);

}
