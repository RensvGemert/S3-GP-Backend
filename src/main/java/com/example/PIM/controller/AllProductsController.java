package com.example.PIM.controller;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.model.Product;
import com.example.PIM.model.User;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class AllProductsController {

    private final ProductService productService;

    @Autowired
    public AllProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts(){
        return productService.getProducts();
    }

}
