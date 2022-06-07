package com.example.PIM.controller;

import com.example.PIM.model.Field;
import com.example.PIM.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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
    public List<Field> getFields(@RequestParam(name="_sort", defaultValue="id") String sort,
                                 @RequestParam(name="_order", defaultValue="ASC") String order,
                                 @RequestParam(name="name", defaultValue="") String search){
        return fieldService.selectAllFields(sort, order, search);
    }

    @PostMapping
    public ResponseEntity<String> createField(@RequestBody Field field) {
        fieldService.createField(field);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ field.getId() + " }");
    }

    @GetMapping("/{id}")
    public Optional<Field> getFieldById(@PathVariable int id) {
        return fieldService.selectFieldById(id);
    }
}
