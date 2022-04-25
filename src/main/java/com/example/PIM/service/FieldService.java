package com.example.PIM.service;

import com.example.PIM.model.Field;
import com.example.PIM.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    private final IFieldRepository fieldRepo;

    @Autowired
    public FieldService(IFieldRepository repo) {
        this.fieldRepo = repo;
    }

    public void createField(Field field){
        if(field.getName() != "") {
            fieldRepo.save(field);
        }
    }


}
