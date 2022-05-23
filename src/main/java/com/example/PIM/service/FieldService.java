package com.example.PIM.service;

import com.example.PIM.model.Field;
import com.example.PIM.repositories.IFieldRepository;
import com.example.PIM.repositories.IProductFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Field> selectAllFields()
    {
        return this.fieldRepo.findAll();
    }

    public Optional<Field> getFieldById(int id) {
        return fieldRepo.findById(id);
    }
}
