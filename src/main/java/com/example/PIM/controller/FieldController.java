package com.example.PIM.controller;

import com.example.PIM.model.Field;
import com.example.PIM.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/fields")
public class FieldController
{
    private final FieldService fieldService;

    @Autowired
    public FieldController(FieldService service)
    {
        this.fieldService = service;
    }

    @GetMapping
    public List<Field> getFields(){
        return fieldService.selectAllFields();
    }

    @PostMapping
    public ResponseEntity<String> createField(@RequestBody Field field) {
        fieldService.createField(field);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ field.getId() + " }");
    }

    @GetMapping("/{id}")
    public Optional<Field> getFieldById(@PathVariable int id) {
        return fieldService.selectFieldById(id);
    }
}
