package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.repository.InsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsuranceServiceImpliment implements InsuranceServiceInterface{
    @Autowired
    private InsuranceRepo policy;
    @Override
    public List<InsurancePolicy> getAllClients() {
        return null;
    }

    @Override
    public InsurancePolicy getClientById(Long i) {
        return null;
    }

    @Override
    public boolean newInsurance(InsurancePolicy c) {
        policy.save(c);
        return false;
    }

    @Override
    public boolean updateInsurance(InsurancePolicy c) {
        return false;
    }

    @Override
    public boolean deleteInsurance(InsurancePolicy c) {
        return false;
    }
}