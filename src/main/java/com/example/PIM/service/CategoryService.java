package com.example.PIM.service;

import com.example.PIM.model.Category;
import com.example.PIM.model.ProductCategory;
import com.example.PIM.repositories.ICategoryRepository;
import com.example.PIM.repositories.IProductCatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final ICategoryRepository categoryRepository;
    private final IProductCatagoryRepository productCatagoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository, IProductCatagoryRepository productCatagoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productCatagoryRepository = productCatagoryRepository;
    }

    public List<Category> selectAllCategories(String sort, String order, String search) {
        List<Category> categories = new ArrayList<>();
        for(Category category : categoryRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))){
            if(category.name.toLowerCase().contains(search.toLowerCase())){
                categories.add(category);
            }
        }
        return categories;
    }

    public void createCategory(Category category) {
        if(category.getName() != "" && category.getName() != null){
            category.setCreatedAt(LocalDateTime.now());
            categoryRepository.save(category);
        }
    }

    public Optional<Category> selectCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public void updateCategory(int id, String name) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Category with id: " + id + " not found!"));
        if(name.length() > 0 && name != null && name != category.name){
            category.setName(name);
        }
    }

    public void deleteCategory(int id) {
        boolean exists = categoryRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Category with id: " + id + " does not exist");
        }
        for ( ProductCategory productCategory : productCatagoryRepository.selectAllProductCategoriesFromCategory(id) ) {
            productCatagoryRepository.delete(productCategory);
        }
        categoryRepository.deleteById(id);
    }
}
