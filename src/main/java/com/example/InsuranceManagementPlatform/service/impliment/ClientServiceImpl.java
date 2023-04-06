package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientServiceInterface{
    @Autowired
   private ClientRepo clientRepo;

    @Override
    public List<Client> getAllClients() {
        Iterable<Client> iterable = clientRepo.findAll();
        List<Client> result = new ArrayList<>();
        for (Client str : iterable) {

            result.add(str);
        }
        return result;
    }

    @Override
    public Optional<Client> getClientById(Long id) {

        return clientRepo.findById(id);
    }

    @Override
    public boolean newClient(Client c) {
        Client x = clientRepo.save(c);
        return false;
    }

    @Override
    public boolean updateClient(Client c) {
        clientRepo.save(c);
        return false;
    }

    @Override
    public boolean deleteClient(Long id) {
        clientRepo.deleteById(id);
        return false;
    }
}
