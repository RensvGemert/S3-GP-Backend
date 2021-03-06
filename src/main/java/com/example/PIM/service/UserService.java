package com.example.PIM.service;

import com.example.PIM.model.AuthRepsonse;
import com.example.PIM.model.Authentication;
import com.example.PIM.model.Company;
import com.example.PIM.model.User;
import com.example.PIM.repositories.ICompanyRepository;
import com.example.PIM.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public List<User> getUsers(int companyId, String sort, String order, String search){
        if(companyId == 1)
        {
            List<User> users = new ArrayList<>();
            for(User user : userRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort)))
            {
                if(user.name.toLowerCase().contains(search.toLowerCase()) || user.email.toLowerCase().contains(search.toLowerCase())){
                    users.add(user);
                }
            }
            return users;
        }
        else
        {
            List<User> allUsers = userRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort));
            List<User> usersFromCompany = new ArrayList<>();
            for (User user : allUsers) {
                if(user.getCompanyId() == companyId && (user.name.toLowerCase().contains(search.toLowerCase()) || user.email.toLowerCase().contains(search.toLowerCase())))
                {
                    usersFromCompany.add(user);
                }
            }
            return usersFromCompany;
        }
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public void createUser(User user){
        if(user.getName() != "" || user.getEmail()!= "" || user.getCompanyId() != 0 || user.getPassword() != "") {
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
    public void updateUser(int id, String Name, String Email, String Password, int companyId) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("user with id: " + id + " not found!"));
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
        if(companyId != 0 &&
                !Objects.equals(user.getCompanyId(), companyId)) {
            user.setCompanyId(companyId);
        }
    }

    public AuthRepsonse login(Authentication authentication){
        int user = userRepository.login(authentication.getUsername(), authentication.getPassword());
        User userdata = userRepository.getById(user);

        int company = userdata.getCompanyId();
        Company companydata = companyRepository.getById(company);

        AuthRepsonse authRepsonse = new AuthRepsonse(userdata.getId(), userdata.getRole(), companydata.getRole(), userdata.getCompanyId());
        return authRepsonse;
    }
}
