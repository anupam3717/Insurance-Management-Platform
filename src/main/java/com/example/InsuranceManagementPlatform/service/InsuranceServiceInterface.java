package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;

import java.util.List;

public interface InsuranceServiceInterface {
    List< InsurancePolicy> getAllClients();
    InsurancePolicy getClientById(Long i);
    boolean newInsurance(InsurancePolicy c);
    boolean updateInsurance(InsurancePolicy c);
    boolean deleteInsurance(InsurancePolicy c);
}
