package com.example.InsuranceManagementPlatform.controller;

import com.example.InsuranceManagementPlatform.config.UserInfoUserDetailsService;
import com.example.InsuranceManagementPlatform.entity.OfficialUser;
import com.example.InsuranceManagementPlatform.service.impliment.OfficialUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AuthController {
    @Autowired
    private UserInfoUserDetailsService loadUser;
    @Autowired
    private OfficialUserServiceImpl userService;
    @PostMapping("signuppp")
    public String addUser(@RequestBody OfficialUser user){
        userService.addUser(user);
        return "added";
    }

    @PostMapping("signup")
    public ResponseEntity<?> test(@RequestBody OfficialUser user){

        return ResponseEntity.ok().body(loadUser.loadUserByUsername(user.getUserName()));
    }

    @PostMapping("signup/{userName}")
    public Optional<OfficialUser> find(@PathVariable("userName") String userName){
       return userService.getUserByUsername(userName);
    }
}
