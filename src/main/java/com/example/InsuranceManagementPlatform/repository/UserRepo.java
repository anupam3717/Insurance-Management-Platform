package com.example.InsuranceManagementPlatform.repository;

import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<OfficialUser,Integer> {
    Optional<OfficialUser> findByUserName(String userName);
}
