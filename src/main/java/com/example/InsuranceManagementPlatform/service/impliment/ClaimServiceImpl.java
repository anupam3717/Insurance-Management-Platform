package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.repository.ClaimRepo;
import com.example.InsuranceManagementPlatform.repository.InsuranceRepo;
import com.example.InsuranceManagementPlatform.service.ClaimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.INTERNAL_SERVER_ERROR;
import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.MANDATORY_PARAMETER_MISSING;

@Service
public class ClaimServiceImpl implements ClaimServiceInterface {
    @Autowired
    private InsuranceRepo policy;
    @Autowired
    private ClaimRepo claim;
    @Override
    public List<Claim> getAllClaims(){
        Iterable<Claim> iterable =claim.findAll();
        if(iterable==null){
            throw  new StatusCodeMyException(INTERNAL_SERVER_ERROR,500,"Something wront in server,try after sometime");
        }
        List<Claim> result = new ArrayList<>();
        for (Claim str : iterable) {

            result.add(str);
        }
        return result;

    }

    @Override
    public Claim getClaimById(Long id) {
        Optional<Claim> x=claim.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }

        return x.get();
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
        Optional<Claim> x=claim.findById(c.getId());
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        claim.save(c);
        return true;
    }

    @Override
    public boolean deleteClaim(Long id) {
        Optional<Claim> x=claim.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        claim.deleteById(id);
        return false;
    }
}
