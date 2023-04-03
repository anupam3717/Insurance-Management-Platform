package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Entity.Claim;
import org.springframework.data.repository.CrudRepository;

public interface ClaimRepo extends CrudRepository<Claim,Long> {
}
