package com.example.InsuranceManagementPlatform.controller;

import com.example.InsuranceManagementPlatform.entity.InsurancePolicy;
import com.example.InsuranceManagementPlatform.service.impliment.InsuranceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceServiceImpl insuranceService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(insuranceService.getAllInsurence());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody InsurancePolicy policy){
        insuranceService.newInsurance(policy);
        return ResponseEntity.ok().body("created successfully");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long policyId){
        return ResponseEntity.ok().body(insuranceService.getInsurenceById(policyId));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody InsurancePolicy policy){
        insuranceService.updateInsurance(policy);
        return ResponseEntity.ok().body("updated successfully");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long policyId){
        insuranceService.deleteInsurance(policyId);
        return ResponseEntity.ok().body("Deleted Successfully");
    }
}
