package com.example.InsuranceManagementPlatform.controller;

import com.example.InsuranceManagementPlatform.entity.Client;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import com.example.InsuranceManagementPlatform.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private AppProperties app;
    @Autowired
 private ClientServiceImpl clientService;
 @PostMapping("/")
 public String create(@RequestBody Client c){
     clientService.newClient(c);
     return "done";
 }
 @GetMapping("/all")
 public ResponseEntity<?> getAllClint(){
     List<Client> x = clientService.getAllClients();
     System.out.println(app.getServiceVersion());
     return ResponseEntity.status(200).body(x);
 }
}
