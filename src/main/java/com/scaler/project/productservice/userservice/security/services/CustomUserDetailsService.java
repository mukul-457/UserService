package com.scaler.project.productservice.userservice.security.services;

import com.scaler.project.productservice.userservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.scaler.project.productservice.userservice.security.models.CustomUserDetails;
import com.scaler.project.productservice.userservice.models.User;
import com.scaler.project.productservice.userservice.models.Role;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
        User user = new User();
        Role role = new Role();
        role.setName("ADMIN");
        user.setName("Mukul");
        user.setEmail("mukul@acharya.com");
        user.setHashedPassword("$2a$12$FVkYdsgWCBGnKZi2Ye70cuMWmxq3uo.SN57nEm8UZFffW9rcroyly");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        List<User> users = new ArrayList<>();
        users.add(user);
        role.setUsers(users);
        userRepo.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
