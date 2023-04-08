package com.example.InsuranceManagementPlatform.service;

import com.example.InsuranceManagementPlatform.entity.Role;

public interface RoleService {
    public String getRoleById(Integer id);
    public String setRole(Role role);
    public void delete(Integer id);
}
