package com.example.PIM.controller;

import com.example.PIM.model.Product;
import com.example.PIM.model.User;
import com.example.PIM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ user.getId() + " }");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        userService.updateUser(id, user.getName(), user.getEmail(), user.getPassword(), user.isRole());
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ id + " }");
    }
}
