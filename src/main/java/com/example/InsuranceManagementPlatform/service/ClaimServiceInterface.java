package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.Claim;
import com.example.InsuranceManagementPlatform.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClaimServiceInterface {
    List<Claim> getAllClaims();
    Claim getClaimById(Long id);
    boolean newClaim(Claim c);
    boolean updateClaim(Claim c);
    boolean deleteClaim(Long id);
}
