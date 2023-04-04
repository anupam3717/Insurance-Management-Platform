package com.example.InsuranceManagementPlatform.repository;

import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepo extends CrudRepository<InsurancePolicy,Long> {
}
