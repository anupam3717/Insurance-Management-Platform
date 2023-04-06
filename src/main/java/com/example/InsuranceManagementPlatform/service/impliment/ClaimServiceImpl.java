package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.repository.ClaimRepo;
import com.example.InsuranceManagementPlatform.repository.InsuranceRepo;
import com.example.InsuranceManagementPlatform.service.ClaimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClaimServiceImpl implements ClaimServiceInterface {
    @Autowired
    private InsuranceRepo policy;
    @Autowired
    private ClaimRepo claim;
    @Override
    public List<Claim> getAllClaims(){
        Iterable<Claim> iterable =claim.findAll();
        List<Claim> result = new ArrayList<>();
        for (Claim str : iterable) {

            result.add(str);
        }
        return result;

    }

    @Override
    public Optional<Claim> getClaimById(Long id) {

        return claim.findById(id);
    }

    @Override
    public boolean newClaim(Claim c) {
        Optional<InsurancePolicy> x =policy.findById(c.getInsurancePolicy().getId());
        if(x.isPresent()){
            InsurancePolicy d=x.get();
            c.setInsurancePolicy(d);
            claim.save(c);
        }

        return false;
    }

    @Override
    public boolean updateClaim(Claim c) {
        claim.save(c);
        return false;
    }

    @Override
    public boolean deleteClaim(Long id) {
        claim.deleteById(id);
        return false;
    }
}
