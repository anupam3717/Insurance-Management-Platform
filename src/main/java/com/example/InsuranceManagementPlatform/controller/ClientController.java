package com.example.InsuranceManagementPlatform.controller;

import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.service.impliment.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Client> list=clientService.getAllClients();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Client client){
        boolean x = clientService.newClient(client);
        return ResponseEntity.ok().body("created successfully");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long clientId){
        return ResponseEntity.ok().body(clientService.getClientById(clientId));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Client client){
        clientService.updateClient(client);
        return ResponseEntity.ok().body("updated successfully");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long clientId){
        clientService.deleteClient(clientId);

        return ResponseEntity.ok().body("Deleted Successfully");
    }
}
