package com.example.PIM.controller;

import com.example.PIM.model.Field;
import com.example.PIM.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteField(@PathVariable int id){
        fieldService.deleteField(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateField(@PathVariable("id") int id, @RequestBody Field field) {
        System.out.println(field);
        fieldService.updateField(id, field.getName());
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }
}
