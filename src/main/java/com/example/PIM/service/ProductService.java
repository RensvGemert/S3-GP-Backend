package com.example.PIM.service;

import com.example.PIM.Dtos.CategoryDto;
import com.example.PIM.Dtos.ProductDto;
import com.example.PIM.Dtos.ProductFieldDto;
import com.example.PIM.model.*;
import com.example.PIM.repositories.*;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductService {

    private IProductRepository productRepository;
    private IProductFieldRepository productFieldRepository;
    private IFieldRepository FieldRepository;
    private IProductCatagoryRepository productCatagoryRepository;
    private ICategoryRepository categoryRepository;

    @Autowired
    public ProductService(IProductRepository productRepository, IProductFieldRepository productFieldRepo, IFieldRepository fieldRepo, IProductCatagoryRepository productCatagoryRepository, ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productFieldRepository = productFieldRepo;
        this.FieldRepository = fieldRepo;
        this.productCatagoryRepository = productCatagoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Autowired
//    public ProductService(IProductFieldRepository productFieldRepository) {
//        this.productFieldRepository = productFieldRepository;
//    }
//
//    @Autowired
//    public ProductService(IFieldRepository fieldRepository) {
//        FieldRepository = fieldRepository;
//    }

    public void deleteFieldFromProduct(int productFieldId, int productId)
    {
        System.out.println(productFieldId + ":fieldid" + productId);
        this.productFieldRepository.deleteProductFieldFromProduct(productFieldId, productId);
    }

    public List<ProductDto> getProductsByCompany(int companyId, @NotNull String sort, @NotNull String order, String searchTitle, int searchCatagory){
        if(companyId == 1)
        {
            List<ProductDto> dtos = new ArrayList<>();
            for (Product product : productRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))) {
                if(product.title.toLowerCase().contains(searchTitle.toLowerCase())){
                    List<ProductFieldDto> productFieldDtos = new ArrayList<>();
                    List<Integer> categories = new ArrayList<Integer>();
                    ProductDto dto = new ProductDto(product.id, product.title, product.description, product.price, product.discount, product.image, product.createdAt, product.updatedAt, productFieldDtos, categories, product.companyId);
                    for (ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromProduct(product.id)) {
                        dto.getCategories().add(productCategory.category.id);
                    }
                    for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(product.id)) {
                        ProductFieldDto newPFDto = new ProductFieldDto(productField.field.name, productField.value, productField.field.id);
                        dto.getProductFields().add(newPFDto);
                    }
                    dtos.add(dto);
                }
            }

            List<ProductDto> categoryFilterDtos = new ArrayList<>();
            for(ProductDto product : dtos){
                if(searchCatagory == 0){
                    return dtos;
                }
                else{
                    if(product.getCategories().contains(searchCatagory)){
                        categoryFilterDtos.add(product);
                    }
                }
            }
            return categoryFilterDtos;
        }
        List<ProductDto> dtos = new ArrayList<>();
            for (Product product : productRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))) {
                if(product.companyId == companyId && product.title.toLowerCase().contains(searchTitle.toLowerCase())){
                    List<ProductFieldDto> productFieldDtos = new ArrayList<>();
                    List<Integer> categories = new ArrayList<Integer>();
                    ProductDto dto = new ProductDto(product.id, product.title, product.description, product.price, product.discount, product.image, product.createdAt, product.updatedAt, productFieldDtos, categories, product.companyId);
                    for (ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromProduct(product.id)) {
                        dto.getCategories().add(productCategory.category.id);
                    }
                    for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(product.id)) {
                        ProductFieldDto newPFDto = new ProductFieldDto(productField.field.name, productField.value, productField.field.id);
                        dto.getProductFields().add(newPFDto);
                    }
                    dtos.add(dto);
                }
            }

        List<ProductDto> categoryFilterDtos = new ArrayList<>();
        for(ProductDto product : dtos){
            if(searchCatagory == 0){
                return dtos;
            }
            else{
                if(product.getCategories().contains(searchCatagory)){
                    categoryFilterDtos.add(product);
                }
            }
        }
        return categoryFilterDtos;
    }

    public List<ProductDto> getProducts(@NotNull String sort, @NotNull String order, String searchTitle, int searchCatagory){
        List<ProductDto> dtos = new ArrayList<>();
        for(Product product : productRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort)))
        {
            if(product.title.toLowerCase().contains(searchTitle.toLowerCase())) {
                List<ProductFieldDto> productFieldDtos = new ArrayList<ProductFieldDto>();
                List<Integer> categories = new ArrayList<Integer>();
                ProductDto dto = new ProductDto(product.id, product.title, product.description, product.price, product.discount, product.image, product.createdAt, product.updatedAt, productFieldDtos, categories, product.companyId);
                for (ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromProduct(product.id)) {
                    dto.getCategories().add(productCategory.category.id);
                }
                for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(product.id)) {
                    ProductFieldDto newPFDto = new ProductFieldDto(productField.field.name, productField.value, productField.field.id);
                    dto.getProductFields().add(newPFDto);
                }
                dtos.add(dto);
            }
        }

        List<ProductDto> categoryFilterDtos = new ArrayList<>();
        for(ProductDto product : dtos){
            if(searchCatagory == 0){
                return dtos;
            }
            else{
                if(product.getCategories().contains(searchCatagory)){
                    categoryFilterDtos.add(product);
                }
            }
        }
        return categoryFilterDtos;
    }

    public ProductDto getProductById(int id){
        Product product = productRepository.getProductFromCompanyById(id);
        List<ProductFieldDto> productFieldDtos = new ArrayList<>();
        List<Integer> categories = new ArrayList<Integer>();
        ProductDto dto = new ProductDto(product.id , product.title, product.description, product.price, product.discount, product.image, product.createdAt, product.updatedAt, productFieldDtos, categories, product.companyId);

        for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(id))
        {
            ProductFieldDto newPFDto = new ProductFieldDto(productField.field.name, productField.value, productField.field.id);
            dto.getProductFields().add(newPFDto);
        }
        for(ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromProduct(id))
        {
            dto.getCategories().add(productCategory.category.id);
        }
        return dto;
    }

    public Integer createProduct(ProductDto product){
        if(product.getTitle() != "" || product.getDescription()!= "") {
            Product newProduct = new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getDiscount(), product.getImage(), LocalDateTime.now(), product.getUpdatedAt(), product.getCompanyId());
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
            for(Integer categoryId : product.getCategories()){
                Category category = categoryRepository.getById(categoryId);
                ProductCategoryKey key = new ProductCategoryKey(createdProduct.getId(), category.getId());
                ProductCategory productCategory = new ProductCategory(key, category, createdProduct);
                System.out.println(productCategory);
                productCatagoryRepository.save(productCategory);
            }
        }
        return productRepository.GetLastCreatedProduct().id;
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

        for(ProductCategory pc : productCatagoryRepository.selectAllProductCategoriesFromProduct(productid))
        {
            productCatagoryRepository.delete(pc);
        }
        productRepository.deleteById(productid);
    }

    @Transactional
    public void updateProduct(int id, String Title, String Description, BigDecimal Price, int Discount, String Image, List<ProductFieldDto> productFieldDtos, List<Integer> categories) {
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
        for(ProductField pf : productFieldRepository.selectAllProductFieldsFromProduct(id))
        {
            productFieldRepository.delete(pf);
        }
        for(ProductFieldDto fieldDto: productFieldDtos)
        {
            Field field = FieldRepository.getById(fieldDto.getFieldId());
            Product updatedProduct = productRepository.getById(id);
            ProductFieldKey key = new ProductFieldKey(updatedProduct.getId(), field.getId());
            ProductField pf = new ProductField(key, field, updatedProduct, fieldDto.getValue());
            System.out.println(pf);
            productFieldRepository.save(pf);
        }
        for(ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromProduct(id))
        {
            productCatagoryRepository.delete(productCategory);
        }
        for(Integer categoryId : categories)
        {
            Category category = categoryRepository.getById(categoryId);
            Product updatedProduct = productRepository.getById(id);
            ProductCategoryKey key = new ProductCategoryKey(updatedProduct.getId(), category.getId());
            ProductCategory productCategory = new ProductCategory(key, category, updatedProduct);
            System.out.println(productCategory);
            productCatagoryRepository.save(productCategory);
        }
    }

    public List<ProductFieldDto> SelectAllProductFieldsFromProduct(int id)
    {
        List<ProductFieldDto> dtos = new ArrayList<>();
        ProductDto dto1 = new ProductDto(1, null, null, null, 0, null, null, null, null);
        ProductDto dto2 = new ProductDto(1, null, null, null, 0, null, null, null, null);

        if(dto1.equals(dto2))
        {
            System.out.println("hhhhhhhhhhak");
        }

        for (ProductField productField : productFieldRepository.selectAllProductFieldsFromProduct(id))
        {
            ProductFieldDto dto = new ProductFieldDto(productField.field.name, productField.value, productField.field.id);
            dtos.add(dto);
        }


        return dtos;
    }
}
