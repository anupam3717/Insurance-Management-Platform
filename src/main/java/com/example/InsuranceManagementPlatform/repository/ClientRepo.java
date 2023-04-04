package com.example.InsuranceManagementPlatform.repository;

import com.example.InsuranceManagementPlatform.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepo extends CrudRepository<Client,Long> {
    Optional<Client> findById(Long i);
}
