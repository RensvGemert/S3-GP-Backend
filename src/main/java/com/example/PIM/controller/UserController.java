package com.example.PIM.controller;

import com.example.PIM.model.User;
import com.example.PIM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/create")
    public void CreateUser(@RequestBody User newUser)
    {
        userService.CreateUser(newUser);
    }
}
