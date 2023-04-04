package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Entity.Client;
import com.example.InsuranceManagementPlatform.Entity.InsurancePolicy;

import java.util.List;

public interface InsuranceServiceInterface {
    List< InsurancePolicy> getAllClients();
    InsurancePolicy getClientById(Long i);
    boolean newInsurance(InsurancePolicy c);
    boolean updateInsurance(InsurancePolicy c);
    boolean deleteInsurance(InsurancePolicy c);
}
