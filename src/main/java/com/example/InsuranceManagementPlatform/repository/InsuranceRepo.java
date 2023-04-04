package com.example.InsuranceManagementPlatform.Repository;

import com.example.InsuranceManagementPlatform.Entity.InsurancePolicy;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepo extends CrudRepository<InsurancePolicy,Long> {
}
