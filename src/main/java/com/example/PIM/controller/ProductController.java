package com.example.PIM.controller;

import com.example.PIM.model.Product;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/create")
	public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @DeleteMapping("/{Id}")
	public void deleteProduct(@PathVariable("Id") int Id) {
        productService.deleteProduct(Id);
    }

    @GetMapping("/{Id}")
    public Optional<Product> getProductsById(@PathVariable int Id) {
        return productService.getProductById(Id);
    }

    @PutMapping("/{Id}")
    public void updateProduct(@PathVariable("Id") int id, @RequestBody Product product) {
        productService.updateProduct(id, product.title, product.description);
    }
}
