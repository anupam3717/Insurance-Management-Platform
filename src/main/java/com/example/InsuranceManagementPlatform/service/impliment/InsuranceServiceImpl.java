package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.repository.InsuranceRepo;
import com.example.InsuranceManagementPlatform.service.InsuranceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceImpliment implements InsuranceServiceInterface {
    @Autowired
    private InsuranceRepo policy;
    @Autowired
    private ClientServiceImpl client;
    @Override
    public List<InsurancePolicy> getAllInsurence() {
        Iterable<InsurancePolicy> iterable =policy.findAll();
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy str : iterable) {

            result.add(str);
        }
        return result;

    }

    @Override
    public Optional<InsurancePolicy> getInsurenceById(Long id) {

        return policy.findById(id);
    }

    @Override
    public boolean newInsurance(InsurancePolicy c) {
        Optional<Client> x =client.getClientById(c.getClient().getId());
        if(x.isPresent()){
           Client d=x.get();
            c.setClient(d);
            policy.save(c);
        }

        return false;
    }

    @Override
    public boolean updateInsurance(InsurancePolicy c) {
        policy.save(c);
        return false;
    }

    @Override
    public boolean deleteInsurance(Long id) {
        policy.deleteById(id);
        return false;
    }
}
