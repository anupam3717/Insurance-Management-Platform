package com.example.InsuranceManagementPlatform;

import com.example.InsuranceManagementPlatform.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AddressService add;
    @PostMapping("/")
    public String hello(@RequestBody Address address){
        add.add(address);
        return "done";
    }
}
