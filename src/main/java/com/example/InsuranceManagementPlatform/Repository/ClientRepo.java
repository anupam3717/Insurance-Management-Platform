package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client,Long> {
}
