package com.webapp.loginpage.service;

import com.webapp.loginpage.entity.Login;
import com.webapp.loginpage.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAllUsers() {
        return loginRepository.findAll();
    }

    public Login createUser(Login login) {
        return loginRepository.save(login);
    }

    public void deleteUser(Long id) {
        loginRepository.deleteById(id);
    }

    public Login getUserById(Long id){
        return loginRepository.findById(id).orElse(null);
    }

    public Login updateUser(Long id,Login updatedUser) {
            Login existingUser = loginRepository.findById(id).orElse(null);
            existingUser.setUsername(updatedUser.getusername());
            existingUser.setPassword(updatedUser.getPassword());
            return  loginRepository.save(existingUser);
    }
}