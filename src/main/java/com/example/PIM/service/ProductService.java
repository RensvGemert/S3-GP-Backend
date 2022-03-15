package com.example.PIM.service;

import com.example.PIM.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", "(insert description)"));
        products.add(new Product(2, "Product 2", "(insert description)"));
        products.add(new Product(3, "Product 3", "(insert description)"));
        return products;
    }
}
