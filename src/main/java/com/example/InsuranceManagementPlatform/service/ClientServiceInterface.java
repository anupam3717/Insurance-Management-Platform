package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Entity.Client;

import java.util.List;

public interface ClientServiceInterface {
    List<Client> getAllClients();
    Client getClientById(Long i);
    boolean newClient(Client c);
    boolean updateClient(Client c);
    boolean deleteClient(Client c);
}
