package com.example.PIM.controller;

import com.example.PIM.model.Product;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
	public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductsById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        productService.updateProduct(id, product.title, product.description);
    }
}
