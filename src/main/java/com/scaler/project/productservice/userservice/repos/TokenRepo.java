package com.scaler.project.productservice.userservice.repos;

import com.scaler.project.productservice.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {
    Optional<Token> findByValue(String value);
}
