package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Entity.Client;
import com.example.InsuranceManagementPlatform.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientServiceInterface{
    @Autowired
   private ClientRepo clientRepo;
    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClientById(Long i) {
        return null;
    }

    @Override
    public boolean newClient(Client c) {
        Client x = clientRepo.save(c);
        return false;
    }

    @Override
    public boolean updateClient(Client c) {
        return false;
    }

    @Override
    public boolean deleteClient(Client c) {
        return false;
    }
}
