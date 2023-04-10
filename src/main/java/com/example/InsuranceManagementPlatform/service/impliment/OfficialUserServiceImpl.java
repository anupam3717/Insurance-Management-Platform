package com.example.InsuranceManagementPlatform.service.impliment;

import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import com.example.InsuranceManagementPlatform.repository.RoleRepo;
import com.example.InsuranceManagementPlatform.repository.UserRepo;
import com.example.InsuranceManagementPlatform.service.OfficialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OfficialUserServiceImpl implements OfficialUserService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
   @Autowired
   @Lazy
   private PasswordEncoder encoder;
    @Override
    public Optional<OfficialUser> getUserByUsername(String userName) {


        return userRepo.findByUserName(userName);
    }

    @Override
    public String addUser(OfficialUser user) {
        String encodedPassword =encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "added";
    }

    @Override
    public void delete(Integer id) {

    }
}
