package com.scaler.project.productservice.userservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Token extends BaseModel{
    private String value;
    @ManyToOne
    @JsonManagedReference
    private User user;
    private String expiresAt;

}
