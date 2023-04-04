package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.entity.Client;

import java.util.List;

public interface ClaimServiceInterface {
    List<Client> getAllClaims();
    Client getClaimById(Long i);
    boolean newClaim(Claim c);
    boolean updateClaim(Claim c);
    boolean deleteClaim(Claim c);
}
