package com.example.PIM.service;

import com.example.PIM.model.AuthRepsonse;
import com.example.PIM.model.Authentication;
import com.example.PIM.model.Company;
import com.example.PIM.model.User;
import com.example.PIM.repositories.ICompanyRepository;
import com.example.PIM.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;
    private final ICompanyRepository companyRepository;

    @Autowired
    public UserService(IUserRepository userRepository, ICompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();

    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public void createUser(User user){
        if(user.getName() != "" || user.getEmail()!= "" || user.getCompanyId() != 0) {
            userRepository.save(user);
        }
    }
    public void deleteUser(int userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("User with id: " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(int id, String Name, String Email, String Password, int role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("product with id: " + id + " not found!"));
        if(Name != null &&
                Name.length() > 0 &&
                !Objects.equals(user.getName(), Name)) {
            user.setName(Name);
        }
        if(Email != null &&
                Email.length() > 0 &&
                !Objects.equals(user.getEmail(), Email)) {
            user.setEmail(Email);
        }
        if(Password != null &&
                !Objects.equals(user.getPassword(), Password)) {
            user.setPassword(Password);
        }
        if(role != 0 &&
                !Objects.equals(user.getRole(), role)) {
            user.setRole(role);
        }
    }

    public AuthRepsonse login(Authentication authentication){
        int user = userRepository.login(authentication.getUsername(), authentication.getPassword());
        User userdata = userRepository.getById(user);

        int company = userdata.getCompanyId();
        Company companydata = companyRepository.getById(company);

        AuthRepsonse authRepsonse = new AuthRepsonse(userdata.getId(), userdata.getRole(), companydata.getRole());
        return authRepsonse;
    }
}
