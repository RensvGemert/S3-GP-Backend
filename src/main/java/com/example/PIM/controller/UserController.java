package com.example.PIM.controller;

import com.example.PIM.model.AuthRepsonse;
import com.example.PIM.model.Authentication;
import com.example.PIM.model.Company;
import com.example.PIM.model.User;
import com.example.PIM.service.CompanyService;
import com.example.PIM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/company/{companyId}/users")
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping
    public List<User> getUsers(@PathVariable("companyId") int companyId){
        return userService.getUsers(companyId);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        user.setCreatedAt(LocalDateTime.now());
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ user.getId() + " }");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        userService.updateUser(id, user.getName(), user.getEmail(), user.getPassword(), user.getCompanyId());
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
                .body("{ \"id\": "+ id + " }");
    }

}
