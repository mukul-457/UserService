package com.scaler.project.productservice.userservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private  String name;
    private String email;
    private String hashedPassword;
    @ManyToMany(mappedBy = "users")
    @JsonBackReference
    private List<Role> Roles;
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Token> tokens;
 }
