package com.example.PIM.service;

import com.example.PIM.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers(){
        User user = new User(1, "admin", "admin@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
