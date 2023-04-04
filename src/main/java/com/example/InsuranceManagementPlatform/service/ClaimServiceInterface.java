package com.example.InsuranceManagementPlatform.Service;

import com.example.InsuranceManagementPlatform.Entity.Claim;
import com.example.InsuranceManagementPlatform.Entity.Client;

import java.util.List;

public interface ClaimServiceInterface {
    List<Client> getAllClaims();
    Client getClaimById(Long i);
    boolean newClaim(Claim c);
    boolean updateClaim(Claim c);
    boolean deleteClaim(Claim c);
}
