package com.example.PIM.service;

import com.example.PIM.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        Product product = new Product(1, "Product1", "(insert description)");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }
}
