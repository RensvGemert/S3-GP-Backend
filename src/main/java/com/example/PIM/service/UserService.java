package com.example.PIM.service;

import com.example.PIM.model.User;
import com.example.PIM.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private IUserRepository repo;

    @Autowired
    public UserService(IUserRepository givenRepo)
    {
        this.repo = givenRepo;
    }
    public List<User> getUsers(){
        //User user = new User(1, "admin", "admin@gmail.com");
        //List<User> users = new ArrayList<>();
        //users.add(user);
        List<User> users = repo.findAll();
        return users;
    }
}
