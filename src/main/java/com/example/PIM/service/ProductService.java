package com.example.PIM.service;

import com.example.PIM.model.Product;
import com.example.PIM.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int Id){
        return productRepository.findById(Id);
    }

    public void createProduct(Product product){
        if(product.title != "" || product.description != "") {
            productRepository.save(product);
        }
    }
    public void deleteProduct(int productId){
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with id: " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(int Id, String Title, String Description) {
        Product product = productRepository.findById(Id)
                .orElseThrow(() -> new IllegalStateException("product with id: " + Id + " not found!"));
        if(Title != null &&
            Title.length() > 0 &&
            !Objects.equals(product.getTitle(), Title)) {
                product.setTitle(Title);
            }
        if(Description != null &&
            Description.length() > 0 &&
            !Objects.equals(product.getDescription(), Description)) {
                product.setDescription(Description);
            }
    }
}
