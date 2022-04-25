package com.example.PIM.service;

import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.Dtos.ProductFieldDto;
import com.example.PIM.model.Field;
import com.example.PIM.model.Product;
import com.example.PIM.model.ProductField;
import com.example.PIM.model.ProductFieldKey;
import com.example.PIM.repositories.IFieldRepository;
import com.example.PIM.repositories.IProductFieldRepository;
import com.example.PIM.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository productRepository;
    private final IProductFieldRepository productFieldRepository;
    private final IFieldRepository FieldRepository;

    @Autowired
    public ProductService(IProductRepository productRepository, IProductFieldRepository productFieldRepo, IFieldRepository fieldRepo) {
        this.productRepository = productRepository;
        this.productFieldRepository = productFieldRepo;
        this.FieldRepository = fieldRepo;
    }

    public void deleteFieldFromProduct(int productFieldId, int productId)
    {
        System.out.println(productFieldId + ":fieldid" + productId);
        this.productFieldRepository.deleteProductFieldFromProduct(productFieldId, productId);
    }

    public List<ProductDto> getProducts(){

        List<ProductDto> dtos = new ArrayList<ProductDto>();

        for(Product product : productRepository.findAll())
        {
            List<ProductFieldDto> productFieldDtos = new ArrayList<ProductFieldDto>();
            ProductDto dto = new ProductDto(product.id, product.title, product.description, product.price, product.discount, product.image, product.createdAt, product.updatedAt, productFieldDtos);

            for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(product.id))
            {
                ProductFieldDto newPFDto = new ProductFieldDto(productField.field.Name, productField.value, productField.field.Id);
                dto.getProductFields().add(newPFDto);
            }

            dtos.add(dto);
        }

        return dtos;
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public void createProduct(ProductDto product){
        if(product.getTitle() != "" || product.getDescription()!= "") {
            Product newProduct = new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getDiscount(), product.getImage(), LocalDateTime.now(), product.getUpdatedAt(), null);
            productRepository.save(newProduct);
            Product createdProduct = productRepository.GetLastCreatedProduct();
            for(ProductFieldDto fieldDto: product.getProductFields())
            {
                Field field = FieldRepository.getById(fieldDto.getFieldId());

                ProductFieldKey key = new ProductFieldKey(createdProduct.getId(), field.getId());
                ProductField pf = new ProductField(key, field, createdProduct, fieldDto.getValue());
                System.out.println(pf);
                productFieldRepository.save(pf);
            }
        }
    }
    public void deleteProduct(int productid){
        boolean exists = productRepository.existsById(productid);
        if(!exists){
            throw new IllegalStateException("Product with id: " + productid + " does not exist");
        }

        for(ProductField pf : productFieldRepository.selectAllProductFieldsFromProduct(productid))
        {
            productFieldRepository.delete(pf);
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

    public List<ProductFieldDto> SelectAllProductFieldsFromProduct(int id)
    {

        List<ProductFieldDto> dtos = new ArrayList<ProductFieldDto>();
        ProductDto dto1 = new ProductDto(1, null, null, null, 0, null, null, null, null);
        ProductDto dto2 = new ProductDto(1, null, null, null, 0, null, null, null, null);
        if(dto1.equals(dto2))
        {
            System.out.println("hhhhhhhhhhak");
        }

        for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(id))
        {
            ProductFieldDto dto = new ProductFieldDto(productField.field.Name, productField.value, productField.field.Id);
            dtos.add(dto);
        }

        return dtos;
    }
}
