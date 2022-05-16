package com.example.PIM.service;

import com.example.PIM.model.Field;
import com.example.PIM.repositories.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FieldService {

    private final IFieldRepository fieldRepo;

    @Autowired
    public FieldService(IFieldRepository repo) {
        this.fieldRepo = repo;
    }

    public void createField(Field field){
        if(field.getName() != "") {
            this.fieldRepo.save(field);
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

    @Transactional
    public void updateField(int id, String name)
    {
        Field field = this.fieldRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("field with id: " + id + " not found!"));

        System.out.println(name);
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(field.getName(), name)) {
           field.setName(name);
        }

    }




}
