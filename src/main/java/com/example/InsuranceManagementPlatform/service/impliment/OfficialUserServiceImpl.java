package com.example.InsuranceManagementPlatform.service.impliment;
import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.repository.RoleRepo;
import com.example.InsuranceManagementPlatform.repository.UserRepo;
import com.example.InsuranceManagementPlatform.service.OfficialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.MANDATORY_PARAMETER_MISSING;

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
    public OfficialUser getUserByUsername(String userName) {
        Optional<OfficialUser> x=userRepo.findByUserName(userName);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid username");
        }

        return x.get();
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
        Optional<OfficialUser> x=userRepo.findById(id);
        if(x.isEmpty()){
            throw  new StatusCodeMyException(MANDATORY_PARAMETER_MISSING,404,"please enter valid ID");
        }
          userRepo.deleteById(id);
    }
}
