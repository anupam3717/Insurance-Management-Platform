package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import com.example.InsuranceManagementPlatform.entity.Role;
import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.repository.RoleRepo;
import com.example.InsuranceManagementPlatform.repository.UserRepo;
import com.example.InsuranceManagementPlatform.service.OfficialUserService;
import com.example.InsuranceManagementPlatform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.MANDATORY_PARAMETER_MISSING;
@Service
public class OfficialUserServiceImpl implements OfficialUserService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public Optional<OfficialUser> getUserByUsername(String userName) {


        return userRepo.findByUserName(userName);
    }

    @Override
    public String addUser(OfficialUser user) {

        userRepo.save(user);
        return "added";
    }

    @Override
    public void delete(Integer id) {

    }
}
