package com.scaler.project.productservice.userservice.security.repos;

import com.scaler.project.productservice.userservice.security.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
