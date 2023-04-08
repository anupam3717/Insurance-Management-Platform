package com.example.InsuranceManagementPlatform.config;

import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import com.example.InsuranceManagementPlatform.entity.Role;
import com.example.InsuranceManagementPlatform.service.impliment.OfficialUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private OfficialUserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<OfficialUser> x = userService.getUserByUsername(username);
        if(x.isEmpty())throw new UsernameNotFoundException("Please enter vaild user");
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role:x.get().getRoles()){
           // System.out.println(role.getRole());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(x.get().getUserName(),x.get().getPassword(),authorities);
    }
}
