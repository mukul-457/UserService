package com.scaler.project.productservice.userservice;

import com.scaler.project.productservice.userservice.models.User;
import com.scaler.project.productservice.userservice.repos.UserRepo;
import com.scaler.project.productservice.userservice.security.repos.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UserServiceApplicationTests {
    private UserRepo userRepo;
    private ClientRepository clientRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
    }

    @Test
    void addSampleUser(){
        User user = new User();
        user.setEmail("mukul@scaler.com");
        user.setHashedPassword(passwordEncoder.encode("password"));
        userRepo.save(user);
    }
}
