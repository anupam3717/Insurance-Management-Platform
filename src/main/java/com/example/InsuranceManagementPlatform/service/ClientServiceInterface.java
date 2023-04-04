package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientServiceInterface {
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    boolean newClient(Client c);
    boolean updateClient(Client c);
    boolean deleteClient(Long id);
}
