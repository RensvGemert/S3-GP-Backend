package com.example.PIM.service;

import com.example.PIM.model.Field;
import com.example.PIM.model.ProductCategory;
import com.example.PIM.model.ProductField;
import com.example.PIM.repositories.IFieldRepository;
import com.example.PIM.repositories.IProductFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final IFieldRepository fieldRepo;
    private final IProductFieldRepository productFieldRepository;

    @Autowired
    public FieldService(IFieldRepository repo, IProductFieldRepository productFieldRepository) {
        this.fieldRepo = repo;
        this.productFieldRepository = productFieldRepository;
    }

    public void createField(Field field){
        if(field.getName() != "" && field.getName() != null) {
            fieldRepo.save(field);
        }
    }

    public Optional<Field> selectFieldById(int id)
    {
        return fieldRepo.findById(id);
    }

    public List<Field> selectAllFields(String sort, String order, String search)
    {
        List<Field> fields = new ArrayList<>();
        for(Field field : fieldRepo.findAll(Sort.by(Sort.Direction.fromString(order), sort)))
        {
            if(field.name.toLowerCase().contains(search.toLowerCase())){
                fields.add(field);
            }
        }
        return fields;
    }

    public Optional<Field> getFieldById(int id) {
        return fieldRepo.findById(id);
    }

    public void deleteField(int id) {
        boolean exists = fieldRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("Category with id: " + id + " does not exist");
        }
        for ( ProductField productField : productFieldRepository.selectAllProductFieldsFromField(id) ) {
            productFieldRepository.delete(productField);
        }
        fieldRepo.deleteById(id);
    }
}
