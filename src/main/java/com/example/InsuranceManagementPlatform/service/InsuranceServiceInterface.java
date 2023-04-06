package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;

import java.util.List;
import java.util.Optional;

public interface InsuranceServiceInterface {
    List< InsurancePolicy> getAllInsurence();
    InsurancePolicy getInsurenceById(Long i);
    boolean newInsurance(InsurancePolicy c);
    boolean updateInsurance(InsurancePolicy c);
    boolean deleteInsurance(Long id);
}
