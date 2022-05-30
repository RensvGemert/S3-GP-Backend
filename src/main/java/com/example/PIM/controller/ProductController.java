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

@CrossOrigin
@RestController
@RequestMapping("/api/company/{companyId}/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<ProductDto> getProductsByCompany(@PathVariable int companyId){
        return productService.getProductsByCompany(companyId);
    }

    @GetMapping("/{id}")
    public ProductDto getProductsById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }


    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto product) {
        Integer id = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }

    @Transactional
    @DeleteMapping("productField/{id}/{id2}")
    public ResponseEntity<String> deleteProductFieldFromProduct(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        System.out.println(id + id2 + " controller functie");
        productService.deleteFieldFromProduct(id, id2);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody ProductDto product) {
        productService.updateProduct(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getDiscount(), product.getImage(), product.getProductFields(), product.getCategories());
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }

    @GetMapping("/fields/{id}")
    public List<ProductFieldDto> getAllProductFieldsFromProduct(@PathVariable("id") int id)
    {
        return productService.SelectAllProductFieldsFromProduct(id);
    }
}
