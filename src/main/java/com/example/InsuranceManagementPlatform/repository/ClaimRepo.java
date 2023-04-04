package com.example.InsuranceManagementPlatform.repository;

import com.example.InsuranceManagementPlatform.entity.Claim;
import org.springframework.data.repository.CrudRepository;

public interface ClaimRepo extends CrudRepository<Claim,Long> {
}
