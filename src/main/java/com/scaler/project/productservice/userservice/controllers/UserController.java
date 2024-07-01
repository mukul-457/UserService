package com.scaler.project.productservice.userservice.controllers;

import com.scaler.project.productservice.userservice.dtos.LoginRequestDto;
import com.scaler.project.productservice.userservice.dtos.SignupRequestDto;
import com.scaler.project.productservice.userservice.dtos.UserDto;
import com.scaler.project.productservice.userservice.dtos.validateRequestDto;
import com.scaler.project.productservice.userservice.exceptions.InvalidIdPassword;
import com.scaler.project.productservice.userservice.exceptions.UserNotFound;
import com.scaler.project.productservice.userservice.models.Token;
import com.scaler.project.productservice.userservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.scaler.project.productservice.userservice.services.UserService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto requestDto){
        User user = userService.signup(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
        return UserDto.fromEntity(user);
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto loginDto){
        try {
            return userService.login(loginDto.getEmail(), loginDto.getPassword());
        }catch (InvalidIdPassword | UserNotFound e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

    @PostMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable String token){
        try {
            User user = userService.validateToken(token);
            return UserDto.fromEntity(user);
        }catch (InvalidIdPassword e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }


}
