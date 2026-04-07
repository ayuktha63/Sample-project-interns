package com.webapp.loginpage.controller;

import com.webapp.loginpage.entity.Login;
import com.webapp.loginpage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/users")
    public List<Login> getAllUsers() {
        return loginService.getAllUsers();
    }

    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) {
        return loginService.createUser(login);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        loginService.deleteUser(id);
        return "User deleted!";
    }
}