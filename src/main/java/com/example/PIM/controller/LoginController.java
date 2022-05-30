package com.example.PIM.controller;

import com.example.PIM.model.AuthRepsonse;
import com.example.PIM.model.Authentication;
import com.example.PIM.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Authentication authentication) {
        AuthRepsonse response = userService.login(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(
                "{" +
                        " \"userId\": " + response.getUserid() + "," +
                        " \"companyRole\": " + response.getCompanyRole() + "," +
                        " \"companyId\": " + response.getCompanyId() + "," +
                        " \"userRole\": " + response.getRole() + " }");
    }
}
