package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.OfficialUser;

import java.util.Optional;

public interface OfficialUserService {
    public Optional<OfficialUser> getUserByUsername(String userName);
    public String addUser(OfficialUser role);
    public void delete(Integer id);
}
