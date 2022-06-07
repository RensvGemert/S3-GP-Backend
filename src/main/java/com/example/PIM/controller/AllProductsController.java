package com.example.PIM.controller;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.model.Product;
import com.example.PIM.model.User;
import com.example.PIM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<ProductDto> getAllProducts(@RequestParam(name="_sort", defaultValue="id") String sort,
                                           @RequestParam(name="_order", defaultValue="ASC") String order,
                                           @RequestParam(name="title", defaultValue="") String searchTitle,
                                           @RequestParam(name="categories", defaultValue="0") int searchCategory ){
        return productService.getProducts(sort, order, searchTitle, searchCategory);
    }

    @GetMapping("all/{id}")
    public ProductDto getProductbyId(@PathVariable("id") int id)
    {
        return productService.getProductById(id);
    }

}
