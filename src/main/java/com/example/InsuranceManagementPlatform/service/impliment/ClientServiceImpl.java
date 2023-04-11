package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.repository.ClientRepo;
import com.example.InsuranceManagementPlatform.service.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.*;

@Service
public class ClientServiceImpl implements ClientServiceInterface {
    @Autowired
   private ClientRepo clientRepo;

    @Override
    public List<Client> getAllClients() {
        Iterable<Client> iterable = clientRepo.findAll();
        if(iterable==null){
            throw  new StatusCodeMyException(INTERNAL_SERVER_ERROR,500,"Something wront in server,try after sometime");
        }
        List<Client> result = new ArrayList<>();
        for (Client str : iterable) {

            result.add(str);
        }
        return result;
    }

    @Override
    public Client getClientById(Long id) {

        Optional<Client> x=clientRepo.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        return x.get();
    }

    @Override
    public boolean newClient(Client c) {
        Client x = clientRepo.save(c);
        if(x==null){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid details");
        }
        return true;
    }

    @Override
    public boolean updateClient(Client c) {
        Optional<Client> x=clientRepo.findById(c.getId());
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
        clientRepo.save(c);
        return true;
    }

    @Override
    public boolean deleteClient(Long id) {
        Optional<Client> x=clientRepo.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(INVALID_ID,404,"please enter valid ID");
        }
        clientRepo.deleteById(id);
        return true;
    }
}
