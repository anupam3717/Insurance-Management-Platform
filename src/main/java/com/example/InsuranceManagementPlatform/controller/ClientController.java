package com.example.InsuranceManagementPlatform.Controller;

import com.example.InsuranceManagementPlatform.Entity.Client;
import com.example.InsuranceManagementPlatform.Service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
 private ClientServiceImpl clientService;
 @PostMapping("/")
 public String create(@RequestBody Client c){
     clientService.newClient(c);
     return "done";
 }
}
