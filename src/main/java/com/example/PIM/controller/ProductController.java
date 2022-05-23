package com.example.PIM.controller;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.Dtos.ProductFieldDto;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto product) {
        Integer id = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @Transactional
    @DeleteMapping("productField/{id}/{id2}")
    public ResponseEntity<String> deleteProductFieldFromProduct(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        System.out.println(id + id2 + " controller functie");
        productService.deleteFieldFromProduct(id, id2);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductsById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody ProductDto product) {
        productService.updateProduct(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getDiscount(), product.getImage(), product.getProductFields());
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @GetMapping("/fields/{id}")
    public List<ProductFieldDto> getAllProductFieldsFromProduct(@PathVariable("id") int id)
    {
        return productService.SelectAllProductFieldsFromProduct(id);
    }

    @GetMapping("/company/{id}")
    public List<ProductDto> getAllProductsFromCompany(@PathVariable("id") int id)
    {
        return this.productService.getAllProductsFromCompany(id);
    }

    @GetMapping("/filter/price")
    public List<ProductDto> getAllProductsFilterOnPrice()
    {
        return this.productService.getAllProductsFilterOnPrice();
    }


    @GetMapping("/filter/discount")
    public List<ProductDto> getAllProductsFilterOnDiscount()
    {
        return this.productService.getAllProductsFilterOnDiscount();
    }






}
