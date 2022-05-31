package com.example.PIM.controller;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.model.Product;
import com.example.PIM.model.User;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("all/{id}")
    public ProductDto getProductbyId(@PathVariable("id") int id)
    {
        return productService.getProductById(id);
    }

}
