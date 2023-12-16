package com.example.AuthenticationApplication.controller;

import com.example.AuthenticationApplication.domain.SignUpData;
import com.example.AuthenticationApplication.domain.User;
import com.example.AuthenticationApplication.service.ISecurityTokenGenerator;
import com.example.AuthenticationApplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/v1")
public class userController
{
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ISecurityTokenGenerator iSecurityTokenGenerator;

    // http://localhost:4444/auth/v1/register   [post]  requestbody
    @PostMapping("/register")
    public ResponseEntity regisUser(@RequestBody SignUpData signUpData)
    {
        signUpData.setRole("Role_User");
        return new ResponseEntity(iUserService.registerUserUsingFC(signUpData), HttpStatus.CREATED);
    }


    // http://localhost:4444/auth/v1/login   [get]  requestbody
     @GetMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user)
     {
         User retrivedUser=iUserService.checkLogin(user.getEmail(),user.getPassword());
         if(retrivedUser!=null) {
             return new ResponseEntity(iSecurityTokenGenerator.generateToken(retrivedUser), HttpStatus.OK);
         }
         else
         {
             return new ResponseEntity("Email or PWD is incorrect...",HttpStatus.BAD_REQUEST);
         }
     }
}
