package com.scaler.project.productservice.userservice.services;

import com.scaler.project.productservice.userservice.exceptions.InvalidIdPassword;
import com.scaler.project.productservice.userservice.exceptions.UserNotFound;
import com.scaler.project.productservice.userservice.models.Token;
import com.scaler.project.productservice.userservice.repos.TokenRepo;
import com.scaler.project.productservice.userservice.repos.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.scaler.project.productservice.userservice.models.User;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepo userRepo;
    private TokenRepo tokenRepo;
    private BCryptPasswordEncoder  bCryptPasswordEncoder;

    public UserService(UserRepo UserRepo,BCryptPasswordEncoder encoder, TokenRepo tokenRepo) {
        this.userRepo = UserRepo;
        this.bCryptPasswordEncoder = encoder;
        this.tokenRepo = tokenRepo;
    }
    public User signup(String name , String email , String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));
        return userRepo.save(user);
    }

    public Token login(String email , String password) throws InvalidIdPassword, UserNotFound {
        Optional<User> user = userRepo.findByEmail(email);
        if(user.isPresent()){
            if(bCryptPasswordEncoder.matches(password , user.get().getHashedPassword())){
                return generateToken(user.get());
            }else {
                throw new InvalidIdPassword("Invalid Password");
            }
        }else{
            throw new UserNotFound("User not found");
        }
    }

    public User validateToken(String tokenValue) throws InvalidIdPassword{
        Optional<Token> token = tokenRepo.findByValue(tokenValue);
        if(token.isEmpty()){
            throw  new InvalidIdPassword("Token is invalid");
        }
        return token.get().getUser();
    }

    private  Token generateToken(User user){
        Token token = new Token();
        token.setValue(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiresAt("never");
        return tokenRepo.save(token);
    }

}
