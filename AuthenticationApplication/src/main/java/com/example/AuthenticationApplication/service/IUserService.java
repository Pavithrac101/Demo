package com.example.AuthenticationApplication.service;

import com.example.AuthenticationApplication.domain.SignUpData;
import com.example.AuthenticationApplication.domain.User;

public interface IUserService
{
    public User registerUserUsingFC(SignUpData signUpData);
    public User registerUser(User user);
    public  User checkLogin(String email,String password);
}
