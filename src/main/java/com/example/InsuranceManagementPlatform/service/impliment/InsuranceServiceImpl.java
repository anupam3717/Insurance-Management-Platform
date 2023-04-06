package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.repository.InsuranceRepo;
import com.example.InsuranceManagementPlatform.service.InsuranceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.INTERNAL_SERVER_ERROR;
import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.MANDATORY_PARAMETER_MISSING;

@Service
public class InsuranceServiceImpl implements InsuranceServiceInterface {
    @Autowired
    private InsuranceRepo policy;
    @Autowired
    private ClientServiceImpl client;
    @Override
    public List<InsurancePolicy> getAllInsurence() {
        Iterable<InsurancePolicy> iterable =policy.findAll();
        if(iterable==null){
            throw  new StatusCodeMyException(INTERNAL_SERVER_ERROR,500,"Something wront in server,try after sometime");
        }
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy str : iterable) {

            result.add(str);
        }
        return result;

    }

    @Override
    public InsurancePolicy getInsurenceById(Long id) {
        Optional<InsurancePolicy> x=policy.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        return  x.get();
    }

    @Override
    public boolean newInsurance(InsurancePolicy c) {
        Client x =client.getClientById(c.getClient().getId());
        c.setClient(x);
        InsurancePolicy y=policy.save(c);
        if(y==null){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid details");
        }

        return true;
    }

    @Override
    public boolean updateInsurance(InsurancePolicy c) {
        Optional<InsurancePolicy> x=policy.findById(c.getId());
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        policy.save(c);
        return false;
    }

    @Override
    public boolean deleteInsurance(Long id) {
        Optional<InsurancePolicy> x=policy.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        policy.deleteById(id);
        return false;
    }
}
