package com.example.PIM.service;

import com.example.PIM.model.Product;
import com.example.PIM.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public void createProduct(Product product){
        if(product.getTitle() != "" || product.getDescription()!= "") {
            productRepository.save(product);
        }
    }
    public void deleteProduct(int productid){
        boolean exists = productRepository.existsById(productid);
        if(!exists){
            throw new IllegalStateException("Product with id: " + productid + " does not exist");
        }
        productRepository.deleteById(productid);
    }

    @Transactional
    public void updateProduct(int id, String Title, String Description, BigDecimal Price, int Discount, String Image) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("product with id: " + id + " not found!"));
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
        if(Price != null &&
            !Objects.equals(product.getPrice(), Price)) {
                product.setPrice(Price);
            }
        if(     Discount >= 0 && Discount <= 100 &&
                !Objects.equals(product.getDiscount(), Discount)) {
            product.setDiscount(Discount);
        }
        if(Image != null &&
                Image.length() > 0 &&
                !Objects.equals(product.getImage(), Image)) {
            product.setImage(Image);
        }
    }
}
