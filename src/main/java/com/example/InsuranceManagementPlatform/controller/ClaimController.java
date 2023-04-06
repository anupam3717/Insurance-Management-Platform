package com.example.InsuranceManagementPlatform.controller;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.service.impliment.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {
    @Autowired
    private ClaimServiceImpl claimService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(claimService.getAllClaims());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Claim claim){
        claimService.newClaim(claim);
        return ResponseEntity.ok().body("created successfully");
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long policyId){
        return ResponseEntity.ok().body(claimService.getClaimById(policyId));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Claim claim){
        claimService.updateClaim(claim);
        return ResponseEntity.ok().body("updated successfully");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long claimId){
        claimService.deleteClaim(claimId);
        return ResponseEntity.ok().body("Deleted Successfully");
    }
}
